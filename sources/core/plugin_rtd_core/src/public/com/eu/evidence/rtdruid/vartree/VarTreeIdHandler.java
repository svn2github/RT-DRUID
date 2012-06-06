package com.eu.evidence.rtdruid.vartree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

public class VarTreeIdHandler {

	protected static DataPackage dpkg = DataPackage.eINSTANCE;

	private static HashMap<EClass, List<EAttribute>> eattrMap = new HashMap<EClass, List<EAttribute>>();
	private static HashMap<String, List<String>> idMap = new HashMap<String, List<String>>();

	static {
		setMap(dpkg.getTimeConstElement().getName(),
				Arrays.asList(new String[] {
						dpkg.getTimeConstElement_FirstEvent().getName(),
						dpkg.getTimeConstElement_SecondEvent().getName(),
						dpkg.getTimeConstElement_BoundType().getName()
				}));
		setMap(dpkg.getOrder().getName(),
				Arrays.asList(new String[] {
						dpkg.getOrder_FirstEvent().getName(),
						dpkg.getOrder_SecondEvent().getName()
				}));
		setMap(dpkg.getCacheMissCost().getName(),
				Arrays.asList(new String[] {
						dpkg.getCacheMissCost_Ref().getName(),
						dpkg.getCacheMissCost_Type().getName()
				}));
		setMap(dpkg.getExecTime().getName(),
				Arrays.asList(new String[] {
						dpkg.getExecTime_Ref().getName(),
						dpkg.getExecTime_Type().getName()
				}));
		setMap(dpkg.getProcMap().getName(),
				Arrays.asList(new String[] {
						dpkg.getProcMap_ModeRef().getName(),
						dpkg.getProcMap_ProcRef().getName()
				}));
		setMap(dpkg.getTaskMap().getName(),
				Arrays.asList(new String[] {
						dpkg.getTaskMap_ModeRef().getName(),
						dpkg.getTaskMap_TaskRef().getName()
				}));
		setMap(dpkg.getVarMap().getName(),
				Arrays.asList(new String[] {
						dpkg.getVarMap_ModeRef().getName(),
						dpkg.getVarMap_VarRef().getName()
				}));
		setMap(dpkg.getRtos().getName(),
				Arrays.asList(new String[0]));

	}
	
	
	//public static void setMap(EClass obj, List<EAttribute> idAttrs) {
	public static void setMap(String objId, List<String> idAttrs) {
		if (objId != null) {
			if (idAttrs == null) {
				idMap.remove(objId);
			} else {
				idMap.put(objId, Collections.unmodifiableList(new ArrayList<String>(idAttrs)));
			}
			
			//remove all elemenent that are related to the changed id
			for (Iterator<EClass> key = eattrMap.keySet().iterator(); key.hasNext(); ) {
				EClass ec = key.next();
				if (objId.equals(ec.getName())) {
					key.remove();
				}
			}
		}
	}
	
	
	private static List<EAttribute> getMap(EClass eclass) {
		if (eattrMap.containsKey(eclass)) {
			return eattrMap.get(eclass);
		}
		
		List<EStructuralFeature> features = eclass.getEAllStructuralFeatures();
		List<EAttribute> idFeatures = new ArrayList<EAttribute>();
		if (idMap.containsKey(eclass.getName())) {
			List<String> knonwIdIfeatures = idMap.get(eclass.getName());

			
			for (String featureName : knonwIdIfeatures) {
				EStructuralFeature esf = eclass.getEStructuralFeature(featureName);
				if (esf != null && esf instanceof EAttribute ) {
					idFeatures.add((EAttribute) esf);
				} else {
					RtdruidLog.showDebug("EClass " + eclass.getName() + " should contain " + featureName + " to correctly build the object id");
				}
			}
			
		} else {
			List<String> knonwIdIfeatures = new ArrayList<String>();
			
			EAttribute nameAttr = null;
			for (EStructuralFeature esf : features) {
				if (esf instanceof EAttribute && !((EAttribute) esf).isMany()) {
					if (((EAttribute) esf).isID()) {
						idFeatures.add((EAttribute) esf);
						knonwIdIfeatures.add(((EAttribute) esf).getName());
					}
					if ("name".equalsIgnoreCase(((EAttribute) esf).getName())) {
						nameAttr = (EAttribute) esf;
					}
				}
			}
			if (idFeatures.size() == 0 && nameAttr != null) {
				idFeatures.add(nameAttr);
				knonwIdIfeatures.add(nameAttr.getName());
			}
			idMap.put(eclass.getName(), knonwIdIfeatures);
		}


		idFeatures = Collections.unmodifiableList(idFeatures);
		eattrMap.put(eclass, idFeatures);

		return idFeatures;
	}

	public static String getId(EObject obj) {
		List<EAttribute> idFeatures = getMap(obj.eClass());

		if (idFeatures.size() == 0) {
			EStructuralFeature conFeature = obj.eContainmentFeature();
			if (conFeature == null) {
				return obj.eClass().getName();
			} // else 
			if (conFeature.isMany()) {
				try {
					return "" + ((EList<EObject>)obj.eContainer().eGet(conFeature)).indexOf(obj);
				} catch (Exception e) {
					// do nothing
				}
			} // else
			return obj.eClass().getName();
		}

		String[] elems = new String[idFeatures.size()];
		for (int i = 0; i < elems.length; i++) {
			EAttribute attr = idFeatures.get(i);
			Object o = obj.eGet(attr);
			if (o instanceof IVariable) {
				IVariable v = (IVariable) o;
				elems[i] = v.get() == null ? null : v.toString();
			} else {
				elems[i] = o == null ? null : o.toString();
			}
		}

		return DataPath.makeId(elems);
	}

	/**
	 */
	public static boolean checkNewID(EObject obj, String newID) throws IllegalIDException {
		String oldID = getId(obj);
		if (newID == null ? oldID == null : newID.equals(oldID))
			return true;

		if (obj.eContainer() != null && obj.eContainmentFeature() != null) {
			Object parentList = obj.eContainer().eGet(obj.eContainmentFeature());

			if (parentList != null && parentList instanceof EList<?>) {
				
				boolean found = false;
				for (Iterator<?> iter = ((EList<?>) parentList).listIterator(); iter.hasNext() && !found; ) {
					found = equalsByID((EObject) iter.next(), newID);
				}
				/*
				 * if ( !(parentList instanceof EObjectContainmentUniqueEList))
				 * { System.err.println(
				 * "\nWARNING: la lista non e' una EObjectContainmentUniqueEList -> potrebbe non fare i check correttamente\n"
				 * ); }
				 */
//				if (((EList<?>) parentList).contains(newID)) {
				if (found) {
					throw new IllegalIDException(
							"Try to use an already used ID : " + newID);
					// return false;
				}
			}
		}
		return true;
	}

	
	
	 /**
	  * 
	  * */
	 public static boolean equalsByID(EObject first, Object second) {
	 	String tmp = getId(first);
	 	if (second == null) {
	 		return (tmp == null);
	 	}
	 	
		EReference eFeature = first.eContainmentFeature();
	 	if (second instanceof EObject
	 			&& eFeature.getEType().isInstance(second)) {
	 		String oTmp = getId((EObject) second);
	 		return (tmp == null ? oTmp == null : tmp.equals(oTmp));
	 	} else if (second instanceof String) {
			return (tmp == null ? second == null : tmp.equals(second));
	 	}
	
	 	return (first == second);
	 }
	 
	 
//	 public static EObject getById(EList<EObject>, Object id) {
//		 
//	 }

	 
	 /**
	  * Set ID using commands
	  * 
	  * @param editingDomain
	  * @param obj
	  * @param s
	  * @return
	  */

	public static Command setId(EditingDomain editingDomain, EObject obj, String s) {
		return setId(editingDomain, obj, DataPath.resolveId(s));
	}

	public static Command setId(EditingDomain editingDomain, EObject obj, String[] s) {

		List<EAttribute> idFeatures = getMap(obj.eClass());

		if (idFeatures.size() == 0 || s.length == 0) {
			return null;
		}

		ArrayList<Command> clist = new ArrayList<Command>();
		for (int i = 0; i < s.length; i++) {
			clist.add(SetCommand.create(editingDomain, obj, idFeatures.get(i),
					s[i]));
		}

		return (s.length > 1) ? new CompoundCommand(clist) : clist.get(0);
	}

	
	/**
	 * Just setting ID
	 * 
	 * @param obj
	 * @param s
	 * @return
	 */
	
	public static void setId(EObject obj, String s) {
		setId(obj, DataPath.resolveId(s));
	}

	public static void setId(EObject obj, String[] s) {

		List<EAttribute> idFeatures = getMap(obj.eClass());

		if (idFeatures.size() == 0 || s.length == 0) {
			return;
		}

		for (int i = 0; i < s.length; i++) {
			EAttribute attr = idFeatures.get(i);
			obj.eSet(attr, EcoreUtil
					.createFromString(attr.getEAttributeType(), s[i]));
		}
	}
}
