/*
 * Created on Aug 26, 2004
 *
 * $Id: OilApplPointer.java,v 1.3 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.vartree.data.oil.impl;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilImplFactory_Impl;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplID;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IOilImplElementDescr;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IOilImplID;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IOilImplPointer;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IOilImplementation;
import com.eu.evidence.rtdruid.modules.oil.keywords.IOilXMLLabels;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ISubVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.VarTreePointerEMF;
import com.eu.evidence.rtdruid.vartree.data.ObjectWithID;
import com.eu.evidence.rtdruid.vartree.data.oil.Enumerator;
import com.eu.evidence.rtdruid.vartree.data.oil.HW;
import com.eu.evidence.rtdruid.vartree.data.oil.OilApplFactory;
import com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage;
import com.eu.evidence.rtdruid.vartree.data.oil.OilObjectWithID;
import com.eu.evidence.rtdruid.vartree.data.oil.Parameter;
import com.eu.evidence.rtdruid.vartree.data.oil.RTOS;
import com.eu.evidence.rtdruid.vartree.data.oil.Root;
import com.eu.evidence.rtdruid.vartree.data.oil.Value;
import com.eu.evidence.rtdruid.vartree.data.oil.Variant;
import com.eu.evidence.rtdruid.vartree.variables.BooleanVar;
import com.eu.evidence.rtdruid.vartree.variables.IntegerVar;
import com.eu.evidence.rtdruid.vartree.variables.MultiValues;
import com.eu.evidence.rtdruid.vartree.variables.OilVarMP;
import com.eu.evidence.rtdruid.vartree.variables.StringDescrMVar;
import com.eu.evidence.rtdruid.vartree.variables.StringDescrVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * JAVADOC commentare
 * 
 * @author Nicola Serreli
 */
public class OilApplPointer extends VarTreePointerEMF implements
		ISubVarTreePointer {

	protected final static OilApplPackage oilAppPack = OilApplPackage.eINSTANCE;

	OilVarMP.DocumentState docState;

	/**
	 * Makes a new Oil application Pointer.
	 * 
	 * @param root
	 *            contains the root node of this sub-tree, or empty if this
	 *            sub-tree is empty
	 * @param editingDomain
	 *            contains the editing domain for this tree (factory,
	 *            CommandStack, ...)
	 * @param notifier
	 *            is a link to parent node
	 */
	public OilApplPointer(EList root, EditingDomain editingDomain,
			OilVarMP.DocumentState notifier) {
		super(root, editingDomain);
		docState = notifier;
		treeFactory = OilApplFactory.eINSTANCE;
	}

	/**
	 * Makes a copy of current pointer.
	 * 
	 * @return a copy of current pointer.
	 */
	public IVarTreePointer clone() {
		OilApplPointer answer = new OilApplPointer(root, editingDomain,
				docState);

		answer.point = (LittlePointer) this.point.clone();

		return answer;
	}
	
	

	protected void execAddCommand(EObject owner, CommandParameter command) {
		super.execAddCommand(owner, command);
		docState.modified();
	}
	protected void execClearCommand(EObject owner, EReference feature) {
		super.execClearCommand(owner, feature);
		docState.modified();
	}
	protected void execRemoveCommand(EObject owner, EReference feature,
			Collection objects) {
		super.execRemoveCommand(owner, feature, objects);
		docState.modified();
	}
	protected void execSetValueCommand(EObject owner, EAttribute feature,
			Object value) {
		super.execSetValueCommand(owner, feature, value);
		docState.modified();
	}
	// ----------------------------------

	public String add(String name, String type) {
		String namedId = DataPath.makeId(name);
		if (point.pointer == null) {
			if (!(oilAppPack.getRoot().getName().equalsIgnoreCase(type))) {
				throw new IllegalArgumentException("required "+oilAppPack.getRoot().getName()+" as type for root node");
			}
			//if (root == null) { root = new BasicEList(); }
			
			// accept more than one root
			if (root.size() >0) {
				// search the new element inside the list. if it's found, exit,
				// other wise add it
				for (int i=0; i<root.size(); i++) {
					
					String tmpId = ((ObjectWithID) root.get(i)).getObjectID(); 
					if (namedId.equals(tmpId)) {
						
						return DataPath.addSlash(tmpId);
					}
				}
			}
			// add the new node
			Root rt = OilApplFactory.eINSTANCE.createRoot();
			
			// TODO :  USARE i COMANDI!!! : creare un nuovo comando stile EMF
			
			rt.setObjectID(name); // set "Oil Object Type"
			root.add(rt);
			docState.modified();
			return DataPath.addSlash(rt.getObjectID());
		}

		if (point.attr != null) {
			if (point.pointer instanceof Root
					&& oilAppPack.getRoot_HwList() == point.attr) {
				
				if (!(oilAppPack.getHW().getName().equalsIgnoreCase(type))) {
					throw new IllegalArgumentException("required "+oilAppPack.getHW().getName()+" as type");
				}

				int index = getIndex(((Root) point.pointer).getHwList(), namedId);
				
				if (index <0) { // add a new element
					ObjectWithID hw = OilApplFactory.eINSTANCE.createHW();
					hw.setObjectID(name);
					CommandParameter cp = new CommandParameter(point.pointer, point.attr, hw);
					execAddCommand(point.pointer, cp);

					return DataPath.addSlash(hw.getObjectID());
					
				}
				
				// use an "old" node
				return DataPath.addSlash(( (ObjectWithID) 
						(((Root) point.pointer).getHwList()).get(index)).getObjectID());
			}

			if (point.pointer instanceof HW
					&& oilAppPack.getHW_RtosList() == point.attr) {

				if (!(oilAppPack.getRTOS().getName().equalsIgnoreCase(type))) {
					throw new IllegalArgumentException("required "+oilAppPack.getRTOS().getName()+" as type");
				}

				int index = getIndex(((HW) point.pointer).getRtosList(), namedId);
				
				if (index <0) { // add a new element
					ObjectWithID rt = OilApplFactory.eINSTANCE.createRTOS();
					rt.setObjectID(name);
					CommandParameter cp = new CommandParameter(point.pointer, point.attr, rt);
					execAddCommand(point.pointer, cp);

					return DataPath.addSlash(rt.getObjectID());
					
				}
				
				// use an "old" node
				return DataPath.addSlash(( (ObjectWithID) (
						((HW) point.pointer).getRtosList()).get(index)).getObjectID());
			}
			
			if ((point.pointer instanceof RTOS && oilAppPack
					.getRTOS_ParameterList() == point.attr)
					|| (point.pointer instanceof Variant && oilAppPack
							.getVariant_EnumeratorList() == point.attr)
					|| (point.pointer instanceof Enumerator && oilAppPack
							.getEnumerator_ParameterList() == point.attr)) {

				Stack pathSk = buildOilPath(point);
				/*
				 * NB: pathSk contains at least 3 elements:
				 * - ObjectType from Root node 
				 * - CpuType from HW node
				 * - RT OS name from rtos node
				 */

				String objType = (String) pathSk.pop();

				IOilImplID oilId;
				{
					String tmp1 = DataPath.removeSlash(DataPath.removeSlash((String) pathSk.pop()));
					String tmp2 = DataPath.removeSlash(DataPath.removeSlash((String) pathSk.pop()));
					oilId = new OilImplID(null,tmp1, tmp2);
				}

				IOilImplementation impl = OilImplFactory_Impl.getAnInstance((IVarTree) editingDomain)
						.getImpl(oilId);

				// there isn't any implementation with given id
				if (impl == null) {
					throw new IllegalStateException("Oil Implementation not found: "+ oilId);
				}
				IOilImplPointer oiPointer = impl.getPointer();
				String otype = DataPath.resolveId(DataPath.removeSlash(objType))[0];
				boolean go = oiPointer.goChild(otype);
				while (go && !pathSk.empty()) {
					String tmp = (String) pathSk.pop();
					go = oiPointer.goChild(tmp);
					if (!go) {
						buildOilPath(point);
						throw new IllegalStateException("Oil Implementation Path not valid");
					}
				}
				//there was a problem with path
				if (!go) {
					throw new IllegalStateException("Oil Implementation Path not valid");
				}
				
				return add(name, type, oiPointer, point, true);
			}
			throw new IllegalArgumentException(
					"New element's type not found (name = " + name
							+ ", type = " + type + ")");

		}

		// add a Attribute / Reference
		return super.add(name, type);
//		throw new IllegalStateException("Try to add a new element in a wrong place");
	}

	private int getIndex(EList<? extends EObject> list, String namedId) {
//		return ((EObjectContainmentUniqueEList)
//		(list).indexOfById(namedId);		
		
		for (int i=0; i<list.size(); i++) {
			ObjectWithID ref = (ObjectWithID) list.get(i);
			if (namedId.equals(ref.getObjectID())) {
				return i;
			}
		}

		
		return -1;
	}
	
	protected String add(String name, String type, IOilImplPointer oiPointer, LittlePointer current, boolean useCommand) {
		final int point=0;
		String namedId = DataPath.makeId(name);
		
		ArrayList<String> valid_types = new ArrayList<String>(); 
		
		// oiPointer points to Implementation description of current EMF node
		IOilImplElementDescr children[] = oiPointer.getChildrenDescr();
		for (int i=0; i<children.length; i++) {
			valid_types.add(children[i].getName());
			switch (children[i].getType()) {
				case IOilImplPointer.ATTRIBUTE :
				{
							if (!check(name, children[i].getName(), type, (String) children[i].getAttributes().get(IOilXMLLabels.ATTR_TYPE))) {
								break;
							}
							
							//EObjectContainmentUniqueEList eocue = (EObjectContainmentUniqueEList)
							EList<EObject> eocue = (EList<EObject>) current.pointer.eGet(current.attr);
							
							int index = getIndex(eocue, namedId);
							if (index <0) { // add a new element
								Value pa = OilApplFactory.eINSTANCE.createValue();
								pa.setObjectID(name);
								
								// set attributes
								Enumeration en = children[i].getAttributes().propertyNames();
								while (en.hasMoreElements()) {
									String tmp = (String) en.nextElement();
									
									if (IOilXMLLabels.ATTR_MULTIPLE_VALUES.equalsIgnoreCase(tmp)) {
										pa.setMultiValues(new BooleanVar(children[i].getAttributes().getProperty(tmp)));
										
									} else if (IOilXMLLabels.ATTR_NAME.equalsIgnoreCase(tmp)) {
										pa.setName(new StringVar(children[i].getAttributes().getProperty(tmp)));
										
									} else if (IOilXMLLabels.ATTR_TYPE.equalsIgnoreCase(tmp)) {
										pa.setType(new StringVar(children[i].getAttributes().getProperty(tmp)));

									} else if (IOilXMLLabels.ATTR_DEFAULT_VALUE.equalsIgnoreCase(tmp)) {
									    // FIXME: attenzione ci sono problemi con i valori di default
										pa.getValues().add(new StringDescrVar(children[i].getAttributes().getProperty(tmp)));
									}
								}

								// store the new object
								if (useCommand) {
									CommandParameter cp = new CommandParameter(current.pointer, current.attr, pa);
									execAddCommand(current.pointer, cp);
								} else {
									eocue.add(pa);
								}

								return DataPath.addSlash(pa.getObjectID());
							}

							// check attributes
							ObjectWithID o = (ObjectWithID) eocue.get(index);
							if (!(o instanceof Value)) {
								throw new IllegalStateException("Try to add a new element with an already used id by an incompatible node");
							}
							Value pa = (Value) o;
							Enumeration en = children[i].getAttributes().propertyNames();
							boolean ok = true;
							while (en.hasMoreElements()) {
								String tmp = (String) en.nextElement();
								
								if (IOilXMLLabels.ATTR_MULTIPLE_VALUES.equalsIgnoreCase(tmp)) {
									ok = check(pa.getMultiValues(), children[i].getAttributes().getProperty(tmp));
									
								} else if (IOilXMLLabels.ATTR_NAME.equalsIgnoreCase(tmp)) {
									ok = check(pa.getName(), children[i].getAttributes().getProperty(tmp));
									
								} else if (IOilXMLLabels.ATTR_TYPE.equalsIgnoreCase(tmp)) {
									ok = check(pa.getType(), children[i].getAttributes().getProperty(tmp));
								}
							}
							
							if (!ok) {
								throw new IllegalStateException("Try to add a new element with an already used id by an incompatible node");
							}

							// make a new node
							return DataPath.makeSlashedId(pa.getObjectID());
				}		
				case IOilImplPointer.VARIANT :
				{
							if (!check(name, children[i].getName(), null, null)) {//type, (String) children[i].attributes.get(OilXMLLabels.ATTR_TYPE))) {
								break;
							}
							
							//EObjectContainmentUniqueEList eocue = (EObjectContainmentUniqueEList)
							EList<EObject> eocue = (EList<EObject>) 
									current.pointer.eGet(current.attr);
							
							int index = getIndex(eocue, namedId);
							if (index <0) { // add a new element
								String defaultValue = null;
								Variant pa = OilApplFactory.eINSTANCE.createVariant();
								pa.setObjectID(name);
								
								// set attributes
								Enumeration en = children[i].getAttributes().propertyNames();
								while (en.hasMoreElements()) {
									String tmp = (String) en.nextElement();
									
									if (IOilXMLLabels.ATTR_MULTIPLE_VALUES.equalsIgnoreCase(tmp)) {
										pa.setMultiValues(new BooleanVar(children[i].getAttributes().getProperty(tmp)));
										
									} else if (IOilXMLLabels.ATTR_NAME.equalsIgnoreCase(tmp)) {
										pa.setName(new StringVar(children[i].getAttributes().getProperty(tmp)));
										
									} else if (IOilXMLLabels.ATTR_TYPE.equalsIgnoreCase(tmp)) {
										pa.setType(new StringVar(children[i].getAttributes().getProperty(tmp)));
										
									} else if (IOilXMLLabels.ATTR_DEFAULT_VALUE.equalsIgnoreCase(tmp)) {

										defaultValue = children[i].getAttributes().getProperty(tmp);
									}
									
								}

								// if there is a default Value, create it (without use emf commands)
								if (defaultValue != null) {
									LittlePointer tmpPointer = new LittlePointer(pa,
												oilAppPack.getVariant_EnumeratorList());
									IOilImplPointer tmpOIP = (IOilImplPointer) oiPointer.clone();
									if (tmpOIP.goChild(pa.getOilType())) {
										add(defaultValue, defaultValue, tmpOIP, tmpPointer, false);
									}
									
								}
								// store the new object
								if (useCommand) {
									CommandParameter cp = new CommandParameter(current.pointer, current.attr, pa);
									execAddCommand(current.pointer, cp);
								} else {
									eocue.add(pa);
								}

								return DataPath.addSlash(pa.getObjectID());
							}

							// check attributes
							ObjectWithID o = (ObjectWithID) eocue.get(index);
							if (!(o instanceof Variant)) {
								throw new IllegalStateException("Try to add a new element with an already used id by an incompatible node");
							}
							Variant pa = (Variant) o;
							Enumeration en = children[i].getAttributes().propertyNames();
							boolean ok = true;
							while (en.hasMoreElements()) {
								String tmp = (String) en.nextElement();
								
								if (IOilXMLLabels.ATTR_MULTIPLE_VALUES.equalsIgnoreCase(tmp)) {
									ok = check(pa.getMultiValues(), children[i].getAttributes().getProperty(tmp));
									
								} else if (IOilXMLLabels.ATTR_NAME.equalsIgnoreCase(tmp)) {
									ok = check(pa.getName(), children[i].getAttributes().getProperty(tmp));
									
								} else if (IOilXMLLabels.ATTR_TYPE.equalsIgnoreCase(tmp)) {
									ok = check(pa.getType(), children[i].getAttributes().getProperty(tmp));
								}
							}
							
							if (!ok) {
								throw new IllegalStateException("Try to add a new element with an already used id by an incompatible node");
							}

							// make a new node
							return DataPath.makeSlashedId(pa.getObjectID());
				}
				case IOilImplPointer.REFERENCE :
				{
							if (!check(name, children[i].getName(), type, (String) children[i].getAttributes().get(IOilXMLLabels.ATTR_OBJ_REF_TYPE))) {
								break;
							}
							
							//EObjectContainmentUniqueEList eocue = (EObjectContainmentUniqueEList)
							EList<EObject> eocue = (EList<EObject>) 
									current.pointer.eGet(current.attr);
							
							int index = getIndex(eocue, namedId);
							if (index <0) { // add a new element
								Value pa = OilApplFactory.eINSTANCE.createValue();
								pa.setObjectID(name);
								
								// set attributes
								Enumeration en = children[i].getAttributes().propertyNames();
								while (en.hasMoreElements()) {
									String tmp = (String) en.nextElement();
									
									if (IOilXMLLabels.ATTR_MULTIPLE_VALUES.equalsIgnoreCase(tmp)) {
										pa.setMultiValues(new BooleanVar(children[i].getAttributes().getProperty(tmp)));
										
									} else if (IOilXMLLabels.ATTR_NAME.equalsIgnoreCase(tmp)) {
										pa.setName(new StringVar(children[i].getAttributes().getProperty(tmp)));
										
									} else if (IOilXMLLabels.ATTR_OBJ_REF_TYPE.equalsIgnoreCase(tmp)) {
										pa.setType(new StringVar(children[i].getAttributes().getProperty(tmp)));
		
									}
								}
		
								// store the new object
								if (useCommand) {
									CommandParameter cp = new CommandParameter(current.pointer, current.attr, pa);
									execAddCommand(current.pointer, cp);
								} else {
									eocue.add(pa);
								}
		
								return DataPath.addSlash(pa.getObjectID());
							}
		
							// check attributes
							ObjectWithID o = (ObjectWithID) eocue.get(index);
							if (!(o instanceof Value)) {
								throw new IllegalStateException("Try to add a new element with an already used id by an incompatible node");
							}
							Value pa = (Value) o;
							Enumeration en = children[i].getAttributes().propertyNames();
							boolean ok = true;
							while (en.hasMoreElements()) {
								String tmp = (String) en.nextElement();
								
								if (IOilXMLLabels.ATTR_MULTIPLE_VALUES.equalsIgnoreCase(tmp)) {
									ok = check(pa.getMultiValues(), children[i].getAttributes().getProperty(tmp));
									
								} else if (IOilXMLLabels.ATTR_NAME.equalsIgnoreCase(tmp)) {
									ok = check(pa.getName(), children[i].getAttributes().getProperty(tmp));
									
								} else if (IOilXMLLabels.ATTR_OBJ_REF_TYPE.equalsIgnoreCase(tmp)) {
									ok = check(pa.getType(), children[i].getAttributes().getProperty(tmp));
								}
							}
							
							if (!ok) {
								throw new IllegalStateException("Try to add a new element with an already used id by an incompatible node");
							}
		
							// make a new node
							return DataPath.makeSlashedId(pa.getObjectID());
				}
				case IOilImplPointer.ENUMERATOR :
				{
							if (!check(name, children[i].getName(), null, null)) { //type, (String) children[i].getAttributes().get(OilXMLLabels.ATTR_TYPE))) {
								break;
							}
							
							//EObjectContainmentUniqueEList eocue = (EObjectContainmentUniqueEList)
							EList<EObject> eocue = (EList<EObject>) 
									current.pointer.eGet(current.attr);
							
							int index = getIndex(eocue, namedId);
							if (index <0) { // add a new element
								Enumerator pa = OilApplFactory.eINSTANCE.createEnumerator();
								pa.setValue(new StringVar(name));
								
								// add the index
								int validId = getEnumValidIndex(eocue);
								pa.setIndex(new IntegerVar("" + validId));
								/*
								// set attributes
								Enumeration en = children[i].getAttributes().propertyNames();
								while (en.hasMoreElements()) {
									String tmp = (String) en.nextElement();
									
									if ("Name".equalsIgnoreCase(tmp)) {
										pa.setValue(new StringVar(children[i].getAttributes().getProperty(tmp)));
										
									}
									
								}*/
		
								// store the new object
								if (useCommand) {
									CommandParameter cp = new CommandParameter(current.pointer, current.attr, pa);
									execAddCommand(current.pointer, cp);
								} else {
									eocue.add(pa);
								}
		
								return DataPath.addSlash(pa.getObjectID());
							}
		
							// check attributes
							ObjectWithID o = (ObjectWithID) eocue.get(index);
							if (!(o instanceof Variant)) {
								throw new IllegalStateException("Try to add a new element with an already used id by an incompatible node");
							}
							Enumerator pa = (Enumerator) o;
							Enumeration en = children[i].getAttributes().propertyNames();
							boolean ok = true;
							while (en.hasMoreElements()) {
								String tmp = (String) en.nextElement();
								
								if (IOilXMLLabels.ATTR_NAME.equalsIgnoreCase(tmp)) {
									ok = check(pa.getValue(), children[i].getAttributes().getProperty(tmp));
									
								}
							}
							
							if (!ok) {
								throw new IllegalStateException("Try to add a new element with an already used id by an incompatible node");
							}
		
							// make a new node
							return DataPath.makeSlashedId(pa.getObjectID());
				}
				default : break; // nothing
				}
		}

		throw new IllegalArgumentException(
				"New element's type not found (name = " + name
				+ ", type = " + type + "). Expected one of " + valid_types);

	}
	
	private int getEnumValidIndex(EList<EObject> list) {
		
		// get all used indexes
		ArrayList<Integer> usedIds = new ArrayList<Integer>();
		for (EObject o: list) {
			if (o instanceof OilObjectWithID) {
				OilObjectWithID oo = (OilObjectWithID) o;
				String id = oo.getObjectID();
				
				try {
					Integer val = Integer.decode(id);
					int index = Collections.binarySearch(usedIds, val);
					if (index <0) {
						usedIds.add(-index -1, val);
					}
				} catch (Exception e) {
					// do nothing
				}
			}
		}
		
		// get the first not used id. note that all indexes are sorted
		int i=0;
		for (; i<usedIds.size(); i++) {
			if (i != usedIds.get(i).intValue()) {
				break;
			}
		}

		
		return i;
	}

	/** Checks if names are equals and types are equals (null is equal only to null)*/
	private boolean check(String name1, String name2, String type1, String type2) {
		return (name1 == null ? name2 == null : name1.equals(name2)) 
			&& (type1 == null ? type2 == null : type1.equals(type2));
	}
	/** Checks if the String rapresentation of IVariable is equal to given String */
	private boolean check(IVariable var, String txt) {
		return (var == null ? txt == null : (txt == null ? var.get() == null : var.get() != null && txt.equals(var.toString())));
	}

	public String add(String name, IVariable var) {
		return super.add(name, var);
	}

	/**
	 * Destroy current node.
	 * 
	 * @return BACK_TO_PARENT if current node is the root of this sub-tree, OK
	 *         otherwise
	 */
	public int subDestroy() {
		// isn't valid destroy a null point.pointer (the oil var !!)
		if (point.pointer == null) {
			throw new IllegalStateException("try to destroy the OilVar from inside");
		}
		
		// is this the root node ?
		if ((point.pointer != null)
				&& point.attr == null && root.contains(point.pointer)) {

			root.remove(point.pointer);
			docState.modified();
			point.pointer = null;
			// TODO : usare i comandi stile EMF!!!
			return BACK_TO_PARENT;
		}

		// it wasn't the root node, than ask to super class
		super.destroy();
		docState.modified();
		return OK;
	}

	// ----------------------------------

	public String[][] getNewChildTypes() {

		if (point.pointer == null) {
			return new String[][] { { "Root", null } };
		}

		if (point.attr != null) {
			if (point.pointer instanceof Root
					&& oilAppPack.getRoot_HwList() == point.attr) {
				return new String[][] { { oilAppPack.getHW().getName(), null } };
			}
			if (point.pointer instanceof HW
					&& oilAppPack.getHW_RtosList() == point.attr) {
				return new String[][] { { oilAppPack.getRTOS().getName(), null } };
			}
			if ((point.pointer instanceof RTOS && oilAppPack
					.getRTOS_ParameterList() == point.attr)
					|| (point.pointer instanceof Variant && oilAppPack
							.getVariant_EnumeratorList() == point.attr)
					|| (point.pointer instanceof Enumerator && oilAppPack
							.getEnumerator_ParameterList() == point.attr)) {

				Stack pathSk = buildOilPath(point);
				/*
				 * NB: pathSk contains at least 3 elements:
				 * - ObjectType from Root node 
				 * - CpuType from HW node
				 * - RT OS name from rtos node
				 */

				String objType = (String) pathSk.pop();

				IOilImplID oilId;
				{
					String tmp1 = (String) pathSk.pop();
					String tmp2 = (String) pathSk.pop();
					oilId = new OilImplID(null, tmp1, tmp2);
				}

				IOilImplementation impl = OilImplFactory_Impl.getAnInstance((IVarTree) editingDomain)
						.getImpl(oilId);

				// there isn't any implementation with given id
				if (impl == null) {
					return new String[0][0];
				}

				IOilImplPointer oiPointer = impl.getPointer();
				boolean go = oiPointer.goChild(objType);
				while (go && !pathSk.empty()) {
					String tmp = (String) pathSk.pop();
					go = oiPointer.goChild(tmp);
				}
				//there was a problem with path
				if (!go) {
					return new String[0][0];
				}
				
				// oiPointer points to Implementation description of current EMF node
				IOilImplElementDescr children[] = oiPointer.getChildrenDescr();
				String answer[][] = new String[children.length][];
				for (int i=0; i<children.length; i++) {
					switch (children[i].getType()) {
						case IOilImplPointer.ATTRIBUTE :
						case IOilImplPointer.VARIANT :
									answer[i] = new String[] {
											(String) children[i].getAttributes().get(IOilXMLLabels.ATTR_TYPE),
											children[i].getName()
											};
									break;
						case IOilImplPointer.REFERENCE :
									answer[i] = new String[] {
											(String) children[i].getAttributes().get(IOilXMLLabels.ATTR_OBJ_REF_TYPE),
											children[i].getName()
											};
									break;
						case IOilImplPointer.ENUMERATOR :
									answer[i] = new String[] {
											children[i].getName(),
											null
											};
									break;
						}
				}
				
				return answer;
				
			}

			// else use the parent method
		}

		// for all other cases, use the parent method : ask to EMF Factory
		return super.getNewChildTypes();
	}

	public IVariable getNewVar() {
		if (point.attr != null && point.attr instanceof EAttribute) {

			EAttribute at = (EAttribute) point.attr; 
			Class type = at.getEAttributeType().getInstanceClass();

			IVariable risp = null;
			
			if (at.isMany()) {
				risp = convert(type, null);
	
			} else {

				risp = (IVariable) ((OilApplFactoryImpl) treeFactory).createFromStringGen(at.getEAttributeType(), null);
			}

			return risp;
			
		}
		throw new IllegalStateException("try to get a var from a container");
	}

	protected IVariable convert(Class type, EList values) {
		MultiValues risp = null;
		
		if (type == StringDescrVar.class) {
			
			boolean convert = false;
			if (point.pointer instanceof Parameter) {
				IVariable var = ((Parameter) point.pointer).getMultiValues();
				if (var != null) {
					convert = "TRUE".equalsIgnoreCase(var.toString());
				} else if (values != null && values.size() >1) {
					convert = true;
				}
			}

			if (!convert) {
				IVariable answer = new StringDescrVar();
				if (values!= null && values.size()>0) {
					answer = (StringDescrVar) values.get(0);
				}
				return answer;
			}
			
			risp = new StringDescrMVar();
		}
		else { return super.convert(type, values); }
	
		if (values != null) {
			for (int i=0; i< values.size(); i++) {
				IVariable v = (IVariable) values.get(i);
				risp.appendValue( v.toString() );
				
			}
		}
	
		return risp;
	}

	public String getType() {
		return getType(point);
	}

	// ----------------------------------

	/**
	 * Goes to the first child of the current element.
	 * 
	 * @return true if there's a child. Otherwise returns false and doesn't
	 *         change position on the tree.
	 */
	public int subGoFirstChild() {
		return super.goFirstChild() ? OK : ERROR;
	}

	/**
	 * Goes to next child, in alphabetical order, of the same parent.
	 * 
	 * @return true if there's a next node. Otherwise returns false and doesn't
	 *         change position on the tree.
	 */
	public int subGoNextSibling() {
		if (point.pointer != null && point.attr == null
				&& root.contains(point.pointer)) {
			
			int pos = root.indexOf(point.pointer)+1;
			if (pos<root.size()) {
				point.pointer = (EObject) root.get(pos);
				return OK;
			}
			
			// it was the last child
			return ERROR; 
		}
		
		return super.goNextSibling() ? OK : ERROR;
	}

	/**
	 * Goes to parent node.
	 * 
	 * @return true if there's a parent node. Otherwise returns false and
	 *         doesn't change position on the tree (already on the root).
	 */
	public int subGoParent() {
		Stack st = new Stack();
		st.push(GO_PARENT);
		return makeSteps(st);
	}

	/**
	 * Performs one or more steps.
	 * 
	 * @param path
	 *            all steps
	 * 
	 * @return one of ERROR, OK and BACK_TO_PARENT
	 */
	public int makeSteps(Stack path) {
		LittlePointer current = (LittlePointer) point.clone();

		while (path.size() > 0) {

			String step = (String) path.pop();

			// check for GO_PARENT
			if (GO_PARENT.equals(step)) {

				if (current.pointer == null) {
					return ERROR;
				}

				if (current.attr == null && root.contains(current.pointer)) {
					// store before return
					point.pointer = null;
					return BACK_TO_PARENT;
				}

				// else use the common method
			}
			
			if (!makeAStep(step, current)) {
				return ERROR;
			}
		}

		// store
		point = current;
		return OK;
	}
	
	

	/* (non-Javadoc)
	 * @see rtdruid.vartree.VarTreePointerEMF#makeAStep(java.lang.String, rtdruid.vartree.VarTreePointerEMF.LittlePointer)
	 */
	protected boolean makeAStep(String step, LittlePointer current) {
		if (current.pointer == null && current.attr == null
				&& !GO_PARENT.equals(step) && !CURRENT.equals(step)) {
			
			step = DataPath.removeSlash(step);
			
			for (Iterator iter= root.iterator(); iter.hasNext(); ) {
				ObjectWithID owid = (ObjectWithID) iter.next();
				
				if (check(step, owid.getObjectID(), null, null)) {
					current.pointer = owid;
					return true;
				}
			}
			
			// not found
			return false;
		}
		
		// common Make A Step
		return super.makeAStep(step, current);
	}
	// ----------------------------------

	/*
	 * the same of VarTreeEMF
	 */
	/*
	 * public boolean isContainer() { return super.isContainer(); }
	 * 
	 * public String getName() { return super.getName(); }
	 * 
	 * public int getChildrenNumber() { return super.getChildrenNumber(); }
	 * 
	 * public IVariable getVar() { return super.getVar(); }
	 * 
	 * public void setVar(IVariable var) { super.setVar(var); }
	 *  
	 */

	// ----------------------------------
	/*
	 * DISABLE destroy, goXXX, existXXX
	 */

	/** Disabled */
	final public void destroy() {
		throw new UnsupportedOperationException();
	}

	/** Disabled */
	final public boolean exist(String path) {
		throw new UnsupportedOperationException();
	}

	/** Disabled */
	final public boolean existAbsolute(String path) {
		throw new UnsupportedOperationException();
	}

	/** Disabled */
	final public boolean go(String path) {
		throw new UnsupportedOperationException();
	}

	/** Disabled */
	final public boolean goAbsolute(String path) {
		throw new UnsupportedOperationException();
	}

	/** Disabled */
	final public boolean goFirstChild() {
		throw new UnsupportedOperationException();
	}

	/** Disabled */
	final public boolean goNextSibling() {
		throw new UnsupportedOperationException();
	}

	/** Disabled */
	final public boolean goParent() {
		throw new UnsupportedOperationException();
	}

	// --------------------------

	/** Returns the type of given pointer */
	protected String getType(LittlePointer current) {
		if (current.pointer == null) {
			throw new RuntimeException();
		}
		if (current.attr != null) {
			if (point.attr instanceof EAttribute) {
				return ((EAttribute) point.attr).getEAttributeType().getName()
						+ (point.attr.isMany() ? "[]" : "");
			} else if (point.attr instanceof EReference) {
				if (point.attr.isMany()) {
					return point.attr.getName();
				} //else {

				throw new IllegalStateException(
						"Cannot have getType of a one to one reference");

			} // else {

			throw new IllegalStateException("Unknow structural feature");
		}
		return ((OilObjectWithID) current.pointer).getOilType();
	}

	/**
	 * Return a stack that contains on the top the ObjectType, then the HW and
	 * RTOS id, and after all parents of given node
	 *  
	 */
	public Stack buildOilPath(LittlePointer current) {

		if (current == null) {
			return new Stack();
		}
		// use a copy of given pointer
		current = (LittlePointer) current.clone();

		// don't consider attributes
		current.attr = null;

		Stack answer = new Stack();
		while (current.pointer != null) {
			if (current.pointer instanceof Enumerator && ((Enumerator) current.pointer).getValue() != null && ((Enumerator) current.pointer).getValue().get() != null) {
				answer.push(((Enumerator) current.pointer).getValue().get());
			} else {
				String id = ((ObjectWithID) current.pointer).getObjectID();
				String[] split = DataPath.resolveId(DataPath.removeSlash(id));
				if (split.length>1) {
					id = split[0];
				}
				
				answer.push(id);
			}
			current.pointer = current.pointer.eContainer();

			// TODO: controllare come si comporta con il root node, e "cosa
			// succede se metto un legame tra oil e resto"
		}
		return answer;
	}
}