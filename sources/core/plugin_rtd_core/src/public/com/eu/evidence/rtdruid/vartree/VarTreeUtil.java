package com.eu.evidence.rtdruid.vartree;

import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.eu.evidence.rtdruid.internal.vartree.VarTree;
import com.eu.evidence.rtdruid.internal.vartree.data.impl.ObjectWithIDImpl;
import com.eu.evidence.rtdruid.vartree.data.DataFactory;
import com.eu.evidence.rtdruid.vartree.data.ObjectWithID;
import com.eu.evidence.rtdruid.vartree.data.Type;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

public abstract class VarTreeUtil {

	/**
	 * The correct way to build a new VarTree
	 */
	public static IVarTree newVarTree() {
		return new VarTree();
	}
	
	/**
	 * The correct way to build a new VarTree
	 */
	public static IVarTree newVarTree(CommandStack commandStack) {
		return new VarTree(commandStack);
	}

	/**
	 * Make a distinct copy of current node and all its attributes and
	 * references
	 * */
	public static EObject copy(EObject original) {
		if (original == null) {
			return null;
		}

		return EcoreUtil.copy(original);
	}
	
	/**
	 * Compare two trees
	 * 
	 * @param first
	 * @param second
	 * @return an IStatus.OK if the two trees are similar, otherwise returns an IStatus.ERROR
	 */
	public static IStatus compare(IVarTree first, IVarTree second) {
		return (new VtCompare(first, second)).checkTrees();
	}
	
	/**
	 * Compare two subtrees
	 * 
	 * @param first
	 * @param second
	 * @return an IStatus.OK if the two trees are similar, otherwise returns an IStatus.ERROR
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
		// if (this.eResource() == null) {
		// throw new
		// RuntimeException("Expected a not null resource. Perhaps it's a Bug!!!");
		// }
if (destination instanceof Type) {
	System.out.println(destination);
}
		{
			String curID = VarTreeIdHandler.getId(destination);
			String sourceID = VarTreeIdHandler.getId(addition);
			if (curID == null ? sourceID != null : !curID.equals(sourceID)) {
				throw new IllegalArgumentException("Try to merge two objects with differents ID: " + curID + " and "
						+ sourceID + "\n\tpath = " + path);
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
				EList<IVariable> children = (EList<IVariable>) destination.eGet(attr);
				@SuppressWarnings("unchecked")
				EList<IVariable> newChildren = (EList<IVariable>) addition.eGet(attr);

				LinkedList<IVariable> tmpChildren = new LinkedList<IVariable>(children);
				for (int j = 0; j < newChildren.size(); j++) {

					IVariable var = (IVariable) newChildren.get(j);
					if (var != null) {
						if (!searchVar(tmpChildren, var)) {
							children.add((IVariable) var.clone());
						}
					}
				}

			} else {
				IVariable var = (IVariable) destination.eGet(attr);
				IVariable newVar = (IVariable) addition.eGet(attr);
				if (var != null && newVar != null) {
					Object v1 = var.get();
					Object v2 = newVar.get();

					boolean eq = (v1 == null ? v2 == null :
					// v1.toString().equals(v2.toString())); // not work with
					// TimeVar (var=1ms, newVar=1us)
							var.toString().equals(newVar.toString()));
					// if (var.getClass() != newVar.getClass() || !eq) { // if
					// current and source are the same type, also two vars are
					// the same type
					if (!eq) {
						if (overwrite) {
							destination.eSet(attr, newVar);
						} else {

							// check if it was the default value
							addition.eUnset(attr);
							IVariable defaultValue = (IVariable) destination.eGet(attr);
							Object def = defaultValue.get();
							boolean eq2 = (v1 == null ? def == null :
							// v1.toString().equals(v2.toString())); // not work
							// with TimeVar (var=1ms, newVar=1us)
									var.toString().equals(defaultValue.toString()));

							if (eq2) {
								destination.eSet(attr, newVar);
							} else {
								throw new IllegalArgumentException(
										"Try to change the vaule of an already set attribute (mono value). "
												+ "path = " + path + DataPath.SEPARATOR + attr.getName());
							}
						}
					}

				} else {
					if (newVar != null) {
						destination.eSet(attr, newVar.clone());
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

					ObjectWithIDImpl newChild = (ObjectWithIDImpl) newChildren.get(j);
					if (newChild != null) {
						int pos = children.indexOf(newChild);
						if (pos < 0) {
							ObjectWithID child = (ObjectWithID) DataFactory.eINSTANCE.create(newChild.eClass());
							child.setObjectID(newChild.getObjectID());

							children.add(child);

							// check the new child.
							// Note: set overwrite to true, because the new
							// child may have default values
							merge((ObjectWithIDImpl) child, newChild, path, true);

						} else {
							// check the old child
							merge((ObjectWithIDImpl) children.get(pos), newChild, path, overwrite);
						}
					}
				}

			} else {

				ObjectWithIDImpl child = (ObjectWithIDImpl) destination.eGet(ref);
				ObjectWithID newChild = (ObjectWithID) addition.eGet(ref);
				if (newChild != null) {
					if (child == null) {
						child = (ObjectWithIDImpl) DataFactory.eINSTANCE.create(newChild.eClass());
						child.setObjectID(newChild.getObjectID());

						destination.eSet(ref, child);
						// Note: set overwrite to true, because the new
						// child may have default values
						merge(child, newChild, path, true);
					} else {
						merge(child, newChild, path, overwrite);
					}
				}
			}
		}
	}

	private static boolean searchVar(LinkedList<IVariable> vars, IVariable value) {
		boolean risp = false;

		Iterator<IVariable> iter = vars.iterator();
		while (!risp && iter.hasNext()) {
			IVariable v = (IVariable) iter.next();
			if (v == null && value == null) {
				iter.remove();
				risp = true;

			} else if (value != null && v != null) {
				Object v1 = v.get();
				Object v2 = value.get();
				boolean eq = (v1 == null ? v2 == null : v1.toString().equals(v2.toString()));
				if (eq) {
					iter.remove();
					risp = true;
				}
			}
		}

		return risp;
	}

	protected StringVar varToUpperCase(StringVar value) {
		StringVar answer = null;
		if (value != null && value.get() != null) {
			answer = new StringVar(value.toString().toUpperCase());
		}
		return answer;
	}

	/** Makes a new Instance of this object */
	protected ObjectWithID newInstance(EClass objClass) {
		return (ObjectWithID) DataFactory.eINSTANCE.create(objClass);
	}

}
