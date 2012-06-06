package com.eu.evidence.rtdruid.vartree;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Properties;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

import com.eu.evidence.rtdruid.epackage.EPackageUtility;
import com.eu.evidence.rtdruid.epackage.IEPackageMerge;
import com.eu.evidence.rtdruid.epackage.RTDEPackageBuildException;
import com.eu.evidence.rtdruid.epackage.RtdEPackage;
import com.eu.evidence.rtdruid.internal.vartree.VarTree;
import com.eu.evidence.rtdruid.io.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.variables.PropertyVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

public final class VarTreeUtil {

	/**
	 * A small class to customize the IVarTree creation
	 * 
	 * @author Nicola Serreli
	 * @since 2.0
	 * 
	 */
	public final static class VarTreeCreator {

		private CommandStack commandStack;
		private EPackage epkg;
		private AdapterFactory adapterFactory;

		public VarTreeCreator() {
			commandStack = null;
			epkg = null;
			adapterFactory = null;
		}

		/**
		 * Creates a new IVarTree instance using provided attributes. Multiple
		 * call of this methods returns different instances of IVarTree based on
		 * the same set of value (i.e., if set by the user, the CommandStack is shared
		 * among all instances produced)
		 * 
		 * @param ed
		 *            the editing domain where store the connection to the
		 *            EPackage
		 * @param epkg
		 *            the EPackage to add
		 * @return this VarTreeCreator
		 */
		public IVarTree istantiateVarTree() {
			CommandStack localCommandStack = this.commandStack;
			final IVarTree answer;
			if (localCommandStack == null && adapterFactory == null && epkg == null) {
				answer = new VarTree();
			} else {
				if (localCommandStack == null) {
					localCommandStack = new BasicCommandStack();
				}
				if (epkg != null && adapterFactory == null) {
					adapterFactory = new ComposedAdapterFactory(new AdapterFactory[] {
							new ResourceItemProviderAdapterFactory(), new ReflectiveItemProviderAdapterFactory() });
				}

				if (adapterFactory == null) {
					answer = new VarTree(localCommandStack);
				} else {
					answer = new VarTree(localCommandStack, adapterFactory);

					addEPackage(answer, epkg);
				}
			}
			if (answer.getResourceSet().getResources().size() == 0) {
				answer.getResourceSet().getResources().add((new RTD_XMI_Factory()).createResource());
			}

			return answer;
		}

		/**
		 * Add to EditingDomain the knowledge of a specific EPackage
		 * 
		 * @param ed
		 *            the editing domain where store the connection to the
		 *            EPackage
		 * @param epkg
		 *            the EPackage to add. If it is null or it has not an NsUri, the editing domain remain unchanged
		 *            
		 * @return this VarTreeCreator
		 */
		public static EditingDomain addEPackage(EditingDomain ed, EPackage epkg) {
			if (epkg != null) {
				String ns = epkg.getNsURI();
				if (ns != null) {
					ed.getResourceSet().getPackageRegistry().put(ns, epkg);
				}
			}
			return ed;
		}

		/**
		 * @param commandStack
		 *            the commandStack to set
		 * @return this VarTreeCreator
		 */
		public VarTreeCreator setCommandStack(CommandStack commandStack) {
			this.commandStack = commandStack;
			return this;
		}

		/**
		 * @param adapterFactory
		 *            the adapterFactory to set
		 * @return this VarTreeCreator
		 */
		public VarTreeCreator setAdapterFactory(AdapterFactory adapterFactory) {
			this.adapterFactory = adapterFactory;
			return this;
		}

		/**
		 * @param epkg
		 *            the EPackage to set
		 * @return this VarTreeCreator
		 */
		public VarTreeCreator setEpkg(EPackage epkg) {
			this.epkg = epkg;
			return this;
		}
	}


	/** disable constructor */
	private VarTreeUtil() {
	}

	/**
	 * The correct way to build a new VarTree
	 */
	public static IVarTree newVarTree() {
		return (new VarTreeCreator()).setEpkg(getDefaultPackage()).istantiateVarTree();
	}

	/**
	 * The correct way to build a new VarTree
	 */
	public static IVarTree newVarTree(CommandStack commandStack) {
		return (new VarTreeCreator()).setEpkg(getDefaultPackage()).setCommandStack(commandStack).istantiateVarTree();
	}

	/**
	 * 
	 */
	public static IVarTree newDynamicVarTree() {

		return (new VarTreeCreator()).istantiateVarTree();
	}

	/**
	 * Try to instantiate the root element
	 */
	public static EObject newVarTreeRoot(EditingDomain vt) {
		return newVarTreeRoot( getRtDruidEPackage(vt));
	}

	/**
	 * Try to instantiate the root element
	 */
	public static EObject newVarTreeRoot(Registry reg) {
		return newVarTreeRoot( reg.getEPackage(DataPackage.eNS_URI) );
	}

	/**
	 * Try to instantiate the root element
	 */
	public static EObject newVarTreeRoot(EPackage epkg) {
		if (epkg != null) {
			EClassifier rootClassifier = epkg.getEClassifier(DataPackage.Literals.SYSTEM.getName());
			if (rootClassifier != null) {
				return EcoreUtil.create((EClass) rootClassifier);
			}
		}
		return null;
	}
	
	public static EPackage getRtDruidEPackage(EditingDomain ed) {
		return ed.getResourceSet().getPackageRegistry().getEPackage(DataPackage.eNS_URI); 
	}
	
	private static EPackage getDefaultPackage() {
		return RtdEPackage.eINSTANCE;
	}

	public static void mergeEPackage(EditingDomain ed, EPackage epkg) throws RTDEPackageBuildException {
		EPackage originalPackage = getRtDruidEPackage(ed);
		HashMap<Resource, byte[]> temp = new HashMap<Resource, byte[]>();

		IEPackageMerge merger = EPackageUtility.instance.getPackageMerge();
		merger.addEPackage(EcoreFactory.eINSTANCE.createEPackage());
		merger.addEPackage(originalPackage);
		merger.addEPackage(epkg);
		EPackage newPackage = merger.getResult();

		boolean reset_package = false;

		try {
			EList<Resource> reslist = ed.getResourceSet().getResources();
			if (reslist.size() == 0) {
				reset_package = true;
				VarTreeCreator.addEPackage(ed, newPackage);
			} else {
				for (Resource res: reslist) {
					
					ByteArrayOutputStream output = new ByteArrayOutputStream();
					res.save(output, null);
					temp.put(res, output.toByteArray());
					res.getContents().clear();
				}
				VarTreeCreator.addEPackage(ed, newPackage);
				for (Resource res: reslist) {
					res.load(new ByteArrayInputStream(temp.get(res)), null);				
				}
			}
		} catch (IOException e) {
			// try to go back to original state
			if (reset_package) {
				VarTreeCreator.addEPackage(ed, originalPackage);
				for (Resource res: ed.getResourceSet().getResources()) {
					if (temp.containsKey(res)) {
						try {
							res.load(new ByteArrayInputStream(temp.get(res)), null);
						} catch (IOException ee) {
							// do nothing
						}
					}
				}
			}
			
			
			throw new RuntimeException(e);
		}

	}
	/**
	 * Make a distinct copy of current node and all its attributes and
	 * references
	 * */
	public static EObject copy(EObject original) {
//		if (original == null) {
//			return null;
//		}

		return EcoreUtil.copy(original);
	}

	/** Makes a new Instance of this object */
	public static EObject newInstance(EObject obj) {
		return newInstance(obj.eClass());
	}

	/** Makes a new Instance of this object */
	public static EObject newInstance(EClass objClass) {
		return objClass.getEPackage().getEFactoryInstance().create(objClass);
	}

	/**
	 * Compare two trees
	 * 
	 * @param first
	 * @param second
	 * @return an IStatus.OK if the two trees are similar, otherwise returns an
	 *         IStatus.ERROR
	 */
	public static IStatus compare(IVarTree first, IVarTree second) {
		return (new VtCompare(first, second)).checkTrees();
	} 

	/**
	 * Compare two subtrees
	 * 
	 * @param first
	 * @param second
	 * @return an IStatus.OK if the two trees are similar, otherwise returns an
	 *         IStatus.ERROR
	 */
	public static IStatus compare(EObject first, EObject second) {
		return (new VtCompare(first, second)).checkTrees();
	}
	
	/**
	 * Try to merge current node with another Object of the same type (and all
	 * its attributes and references). The result is stored in current node.
	 * 
	 * Note that this function is not intended to work with EPackages.
	 * 
	 * @throws IllegalArgumentException
	 *             if two object are not compatible (or one of theirs
	 *             descendants)
	 * */
	public static IVarTree merge(IVarTree first, EditingDomain second) {
		if (first == null) {
			first = newVarTree();
		}
		EObject firstRoot = getTreeRoot(first);
		EObject secondRoot = getTreeRoot(second);
		if (firstRoot == null) {
			if (secondRoot == null) {
				// return first;
			} else {			
				firstRoot = copy(secondRoot);
				first.setRoot(firstRoot);
			}
		} else {
			merge(firstRoot, secondRoot);
		}
		return first;
	} 

	/**
	 * Try to merge current node with another Object of the same type (and all
	 * its attributes and references). The result is stored in current node.
	 * 
	 * Note that this function is not intended to work with EPackages.
	 * 
	 * @throws IllegalArgumentException
	 *             if two object are not compatible (or one of theirs
	 *             descendants)
	 * */
	public static EObject merge(EObject destination, EObject addition) {
		merge(destination, addition, "", false);
		return destination;
	}

	/**
	 * Try to merge current node with another Object of the same type (and all
	 * its attributes and references). The result is stored in current node.
	 * 
	 * Note that this function is not intended to work with EPackages.
	 * 
	 * @throws IllegalArgumentException
	 *             if two object are not compatible (or one of theirs
	 *             descendants)
	 * */
	public static void merge(EObject destination, EObject addition, String path, boolean overwrite) {
		if (destination.getClass() != addition.getClass()) {
			throw new IllegalArgumentException("Try to merge two not compatible objects: one " + destination.getClass()
					+ " and one " + addition.getClass() + "\n\tpath = " + path);
		}
		{
			String curID = VarTreeIdHandler.getId(destination);
			String sourceID = VarTreeIdHandler.getId(addition);
			if (curID == null ? sourceID != null : !curID.equals(sourceID)) {
				if (!("System".equalsIgnoreCase(destination.eClass().getName()))) {
					throw new IllegalArgumentException("Try to merge two objects with differents ID: " + curID + " and "
							+ sourceID + "\n\tpath = " + path);
				}
			}

			path = (path == null ? "" : path) + DataPath.SEPARATOR + curID;
		}

		// copy all attributes
		EList<EAttribute> attrs = destination.eClass().getEAllAttributes();
		for (int i = 0; i < attrs.size(); i++) {
			EAttribute attr = (EAttribute) attrs.get(i);
			if (attr.isDerived()) {
				// do nothing
			} else if (attr.isMany()) {
				@SuppressWarnings("unchecked")
				EList<Object> children = (EList<Object>) destination.eGet(attr);
				EList<?> newChildren = (EList<?>) addition.eGet(attr);

				LinkedList<?> tmpChildren = new LinkedList<Object>(children);
				for (int j = 0; j < newChildren.size(); j++) {

					Object var = newChildren.get(j);
					if (var != null) {
						if (!searchVar(tmpChildren, var)) {
							if (var instanceof IVariable) {
								children.add(((IVariable) var).clone());
							} else {
								children.add(EcoreUtil.createFromString(attr.getEAttributeType(), var.toString()));
							}
						}
					}
				}

			} else {
				Object var = destination.eGet(attr);
				Object newVar = addition.eGet(attr);
				if (!compare(var, newVar)) {
					
					if (("System".equalsIgnoreCase(destination.eClass().getName())) && "Name".equalsIgnoreCase(attr.getName())) {
						if (overwrite) {
							destination.eSet(attr, newVar);
						} // else do nothing
					} else {
	
						if ("properties".equalsIgnoreCase(attr.getName())) {
							
							if (var == null) {
								destination.eSet(attr, newVar);
							} else {
								if (var instanceof PropertyVar) {
									PropertyVar pv1 = ((PropertyVar) var);
									Properties p1 = pv1.get();
									if (newVar != null && newVar instanceof PropertyVar) {
										Properties p2 = ((PropertyVar) newVar).get();
										boolean changed = false;
										for (Entry<Object, Object> e : p2.entrySet()) {
											if (p1.containsKey(e.getKey())) {
												if (overwrite) {
													changed = true;
													pv1.set((String)e.getKey(), (String)e.getValue());
												} else {
													if (!(("" + p1.get(e.getKey())).equals(""+e.getValue()))) {
														throw new IllegalArgumentException(
																"Try to change the vaule of an already set property. " + "path = "
																		+ path + DataPath.SEPARATOR + attr.getName() + ", property = " + e.getKey());
													}
												}
											} else {
												changed = true;
												pv1.set((String)e.getKey(), (String)e.getValue());
											}
										}
										if (changed) {
											destination.eSet(attr, pv1);
										}
									}
								}
							}
							
						} else {
							
							if (overwrite) {
								destination.eSet(attr, newVar);
							} else {
		
								// check if it was the default value
								Object def = attr.getDefaultValue();
								if (compare(var, def)) {
									destination.eSet(attr, newVar);
								} else if (!compare(newVar, def)) {
									throw new IllegalArgumentException(
											"Try to change the vaule of an already set attribute (mono value). " + "path = "
													+ path + DataPath.SEPARATOR + attr.getName());
								}
							}
						}
					}
				}
			}
		}

		// copy all references
		EList<EReference> refs = destination.eClass().getEReferences();
		for (int i = 0; i < refs.size(); i++) {
			EReference ref = (EReference) refs.get(i);
			if (ref.isMany()) {
				@SuppressWarnings("unchecked")
				EList<EObject> children = (EList<EObject>) destination.eGet(ref);
				@SuppressWarnings("unchecked")
				EList<EObject> newChildren = (EList<EObject>) addition.eGet(ref);

				for (int j = 0; j < newChildren.size(); j++) {

					EObject newChild = newChildren.get(j);
					if (newChild != null) {
						EObject oldChild = searchEObjectById(children, newChild);
						if (oldChild == null) {
							EObject child = newInstance(newChild.eClass());
							VarTreeIdHandler.setId(child, VarTreeIdHandler.getId(newChild));

							children.add(child);

							// check the new child.
							// Note: set overwrite to true, because the new
							// child may have default values
							merge(child, newChild, path, overwrite);

						} else {
							// check the old child
							merge(oldChild, newChild, path, overwrite);
						}
					}
				}

			} else {

				EObject child = (EObject) destination.eGet(ref);
				EObject newChild = (EObject) addition.eGet(ref);
				if (newChild != null) {
					if (child == null) {
						child = newInstance(newChild.eClass());
						VarTreeIdHandler.setId(child, VarTreeIdHandler.getId(newChild));

						destination.eSet(ref, child);
						// Note: set overwrite to true, because the new
						// child may have default values
						merge(child, newChild, path, overwrite);
					} else {
						merge(child, newChild, path, overwrite);
					}
				}
			}
		}
	}
	
	private static EObject searchEObjectById(EList<EObject> elements, EObject value) {
		String vId = VarTreeIdHandler.getId(value);
		if (vId == null) {
			return null;
		} else {
			for (EObject elem : elements) {
				if (vId.equals(VarTreeIdHandler.getId(elem))) {
					return elem;
				}
			}
		}
		
		return null;
	}

	private static boolean searchVar(LinkedList<?> vars, Object value) {
		boolean risp = false;

		Iterator<?> iter = vars.iterator();
		while (!risp && iter.hasNext()) {
			Object v = iter.next();
			if (compare(v, value)) {
				iter.remove();
			}
		}

		return risp;
	}

	private static boolean compare(Object o1, Object o2) {
		boolean answer = false;
		if (o1 == null && o2 == null) {
			answer = true;
		} else if (o1 != null && o2 != null) {

			if (o1.getClass() == o2.getClass()) {
				final Object v1;
				final Object v2;
				if (o1 instanceof IVariable) {
					v1 = ((IVariable) o1).get();
					v2 = ((IVariable) o2).get();
				} else {
					v1 = o1;
					v2 = o2;
				}

				answer = (v1 == null ? v2 == null : (v2 != null && v1.toString().equals(v2.toString())));
			}
		}
		return answer;
	}
	
	////////////////////////////////////////////////////////////
	
	/**
	 * Checks if given node contains the var <code>varName</code> and, if true,
	 * checks if the var's value is the given one. If the node doesn't contains
	 * the var or if the value is null, this method creates a new var with the
	 * given value and adds it to <code>parent</code> node.
	 * 
	 * @param parent
	 *            the node that contains the node with the required var
	 * @param varName
	 *            identifies the variable
	 * @param value
	 *            the required value
	 * 
	 * @throws IllegalArgumentException
	 *             if the <code>parent</code> node already contains the variable
	 *             but with a value different from default one.
	 */
	public static void storeAVar(IVarTreePointer parent, String varName, String value) {
		storeAVar(parent, varName, value, false);
	}
	
	/**
	 * Checks if given node contains the var <code>varName</code> and, if true,
	 * checks if the var's value is the given one. If the node doesn't contains
	 * the var or if the value is null, this method creates a new var with the
	 * given value and adds it to <code>parent</code> node.
	 * 
	 * @param parent
	 *            the node that contains the node with the required var
	 * @param varName
	 *            identifies the variable
	 * @param value
	 *            the required value
	 * 
	 * @throws IllegalArgumentException
	 *             if the <code>parent</code> node already contains the variable
	 *             but with another not null value.
	 */
	public static void storeAVar(IVarTreePointer parent, String varName, String value, boolean overwrite) {

		IVarTreePointer curr = (IVarTreePointer) parent.clone();
		if (!curr.go(varName)) {
			curr.add(varName, new StringVar(value));
		} else {
			IVariable var = curr.getVar();
			if (var != null && var.get() != null) {
				if (var instanceof IMultiValues) {
					if (value != null) {
						((IMultiValues) var).appendValue(value);
						curr.setVar(var);
					}
				} else {
					
					if (!compare(var.toString(), value)) {

						if (overwrite) {
							var.set(value);
							curr.setVar(var);
						} else {

							// check if it was the default value
							Object def = curr.getDefaultValue();
							if (compare(var, def)) {
								var.set(value);
								curr.setVar(var);
							} else if (!compare(value, "" +def)) {
								throw new IllegalArgumentException(
										"Try to change the vaule of an already set attribute ("+varName+").");
							}
						}
					}
				}
			} else {
				IVariable tmpVar = curr.getNewVar(value);
				curr.setVar(tmpVar);
			}
		}
	}

	/**
	 * @param vt
	 * @return
	 */
	public static EObject getTreeRoot(EditingDomain vt) {
		if (vt != null) {
			EList<Resource> resources = vt.getResourceSet().getResources();
			if (resources.size()>0) {
				EList<EObject> objectes = resources.get(0).getContents();
				if (objectes.size()>0) {
					return objectes.get(0);
				}
			}
		}
		return null;
	}

}
