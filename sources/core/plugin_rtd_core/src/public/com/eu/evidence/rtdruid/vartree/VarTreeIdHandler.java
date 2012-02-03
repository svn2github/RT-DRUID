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

import com.eu.evidence.rtdruid.vartree.data.DataPackage;

public class VarTreeIdHandler {

	protected static DataPackage dpkg = DataPackage.eINSTANCE;

	private static HashMap<EClass, List<EAttribute>> idMap = new HashMap<EClass, List<EAttribute>>();

	static {
		setMap(dpkg.getTimeConstElement(),
				Arrays.asList(new EAttribute[] {
						dpkg.getTimeConstElement_FirstEvent(),
						dpkg.getTimeConstElement_SecondEvent(),
						dpkg.getTimeConstElement_BoundType()
				}));
		setMap(dpkg.getOrder(),
				Arrays.asList(new EAttribute[] {
						dpkg.getOrder_FirstEvent(),
						dpkg.getOrder_SecondEvent()
				}));
		setMap(dpkg.getCacheMissCost(),
				Arrays.asList(new EAttribute[] {
						dpkg.getCacheMissCost_Ref(),
						dpkg.getCacheMissCost_Type()
				}));
		setMap(dpkg.getExecTime(),
				Arrays.asList(new EAttribute[] {
						dpkg.getExecTime_Ref(),
						dpkg.getExecTime_Type()
				}));
		setMap(dpkg.getProcMap(),
				Arrays.asList(new EAttribute[] {
						dpkg.getProcMap_ModeRef(),
						dpkg.getProcMap_ProcRef()
				}));
		setMap(dpkg.getTaskMap(),
				Arrays.asList(new EAttribute[] {
						dpkg.getTaskMap_ModeRef(),
						dpkg.getTaskMap_TaskRef()
				}));
		setMap(dpkg.getVarMap(),
				Arrays.asList(new EAttribute[] {
						dpkg.getVarMap_ModeRef(),
						dpkg.getVarMap_VarRef()
				}));

	}
	
	
	public static void setMap(EClass obj, List<EAttribute> idAttrs) {
		if (obj != null) {
			if (idAttrs == null) {
				idMap.remove(obj);
			} else {
				idMap.put(obj, Collections.unmodifiableList(new ArrayList<EAttribute>(idAttrs)));
			}			
		}
	}
	
	
	private static List<EAttribute> getMap(EClass eclass) {
		if (idMap.containsKey(eclass)) {
			return idMap.get(eclass);
		}

		List<EStructuralFeature> features = eclass.getEAllStructuralFeatures();
		List<EAttribute> idFeatures = new ArrayList<EAttribute>();
		EAttribute nameAttr = null;
		for (EStructuralFeature esf : features) {
			if (esf instanceof EAttribute) {
				if (((EAttribute) esf).isID()) {
					idFeatures.add((EAttribute) esf);
				}
				if ("name".equalsIgnoreCase(((EAttribute) esf).getName())) {
					nameAttr = (EAttribute) esf;
				}
			}
		}
		if (idFeatures.size() == 0 && nameAttr != null) {
			idFeatures.add(nameAttr);
		}

		idFeatures = Collections.unmodifiableList(idFeatures);
		idMap.put(eclass, idFeatures);

		return idFeatures;
	}

	public static String getId(EObject obj) {
		List<EAttribute> idFeatures = getMap(obj.eClass());

		if (idFeatures.size() == 0) {
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
