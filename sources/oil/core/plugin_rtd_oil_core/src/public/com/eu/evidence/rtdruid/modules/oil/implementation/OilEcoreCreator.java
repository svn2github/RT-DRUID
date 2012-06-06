package com.eu.evidence.rtdruid.modules.oil.implementation;


import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilEcoreCreatorImpl;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;

/**
*
* @author Nicola Serreli
* @since 2.0
*
*/
public abstract class OilEcoreCreator {
	/**
	 * 
	 */
	protected static final String RTDRUID_ANNOTATIONS_SOURCE = "http:///com/eu/evidence/rtdruid/annotations";
	/**
	 * 
	 */
	protected static final String ANNOTATION_ENUM_TYPE = "enumerator_type";

	/**
	 * 
	 */
	protected static final String ANNOTATION_VARIANT_TYPE = "variant_type";
	protected static final String ANNOTATION_OIL_ATTR = "oil_attribute";
	protected static final String ANNOTATION_OIL_REF = "oil_reference";
	protected static final String ANNOTATION_OIL_1L_OBJ_TYPE = "oil_first_level_type";

	protected OilEcoreCreator() {
		super();
	}

	public static OilEcoreCreator getCreator(IOilImplementation iimpl) {
		return new OilEcoreCreatorImpl(iimpl);
	}

	public abstract EPackage buildPackage();
	
	
	public static String getRtdEClassExtPoint(String type) {
		return type.toUpperCase() + "_OIL_EXT";
//		String answer = type.toUpperCase() + "_OIL_EXT";
//		if (IOilXMLLabels.OBJ_TASK.equalsIgnoreCase(type)) {
//			answer = IOilXMLLabels.OBJ_TASK;
//		} else if (IOilXMLLabels.OBJ_ISR.equalsIgnoreCase(type)) {
//			answer = "ISR";
//		} else if (IOilXMLLabels.OBJ_OS.equalsIgnoreCase(type)) {
//			answer = "RTOS";
//		} else if (IOilXMLLabels.OBJ_OSAPPLICATION.equalsIgnoreCase(type)) {
//			answer = "OS_APPLICATION";
//		} else if (IOilXMLLabels.OBJ_RESOURCE.equalsIgnoreCase(type)) {
//			answer = "MUTEX";
//		} else if (IOilXMLLabels.OBJ_ALARM.equalsIgnoreCase(type)) {
//			answer = "ALARM";
//		} else if (IOilXMLLabels.OBJ_COUNTER.equalsIgnoreCase(type)) {
//			answer = "COUNTER";
//		} else if (IOilXMLLabels.OBJ_EVENT.equalsIgnoreCase(type)) {
//			answer = "EVENT";
//		} else if (IOilXMLLabels.OBJ_APPMODE.equalsIgnoreCase(type)) {
//			answer = "APPMODE";
//		}
//		return answer == null ? null : answer+"_OIL_EXT";
	}

	public static boolean isOilFirstObject(IVarTreePointer vtp) {
		EMap<String, String> map = getAnnotation(vtp);
		if (map != null && map.containsKey(ANNOTATION_OIL_1L_OBJ_TYPE)) {
			return map.get(ANNOTATION_OIL_1L_OBJ_TYPE) != null;
		}
		
		return false;
	}

	public static boolean isOilAttribute(IVarTreePointer vtp) {
		IVarTreePointer.EmfPoint epoint = vtp.getEPoint();
		EStructuralFeature esf = epoint.getCurrentFeature();
		if (esf != null) {			
			EMap<String, String> map = getAnnotation(esf);
			if (map != null) {
				return map.containsKey(ANNOTATION_OIL_ATTR);
			}
		}

		return false;
	}

	public static boolean isOilReference(IVarTreePointer vtp) {
		IVarTreePointer.EmfPoint epoint = vtp.getEPoint();
		EStructuralFeature esf = epoint.getCurrentFeature();
		if (esf != null) {			
			EMap<String, String> map = getAnnotation(esf);
			if (map != null) {
				return map.containsKey(ANNOTATION_OIL_REF);
			}
		}
		
		return false;
	}
	public static boolean isOilEnum(IVarTreePointer vtp) {
		EMap<String, String> map = getAnnotation(vtp);
		if (map != null) {
			return map.containsKey(ANNOTATION_ENUM_TYPE);
		}
	
		
		return false;
	}
	public static boolean isOilVariant(IVarTreePointer vtp) {
		EMap<String, String> map = getAnnotation(vtp);
		if (map != null) {
			return map.containsKey(ANNOTATION_VARIANT_TYPE);
		}
		
		return false;
	}

	public static String getOilFirstObjectType(IVarTreePointer vtp) {
		EMap<String, String> map = getAnnotation(vtp);
		if (map != null && map.containsKey(ANNOTATION_OIL_1L_OBJ_TYPE)) {
			return map.get(ANNOTATION_OIL_1L_OBJ_TYPE);
		}
		
		return null;
	}

	public static String getOilEnumType(IVarTreePointer vtp) {
		EMap<String, String> map = getAnnotation(vtp);
		if (map != null) {
			if (map.containsKey(ANNOTATION_ENUM_TYPE)) {
				return map.get(ANNOTATION_ENUM_TYPE);
			}
		}
		
		return null;
	}
	
	/**
	 * Returns the type of the variant that contains current enum 
	 * 
	 * @param vtp
	 * @return
	 */
	public static String getOilEnumVariantType(IVarTreePointer vtp) {
		IVarTreePointer.EmfPoint epoint = vtp.getEPoint();
		EStructuralFeature esf = epoint.getCurrentFeature();
		if (esf == null) {
			EObject eobj = epoint.getEObject();
			if (eobj == null) {
				return null;
			}
			EStructuralFeature esfC = eobj.eContainingFeature();
			if (esfC != null) {
				return esfC.getName();
			}
		}
		
		return null;
	}
	
	/**
	 * Returns the type of the variant that contains current enum 
	 * 
	 * @param vtp
	 * @return
	 */
	public static boolean isOilEnumMultiValue(IVarTreePointer vtp) {
		IVarTreePointer.EmfPoint epoint = vtp.getEPoint();
		EStructuralFeature esf = epoint.getCurrentFeature();
		if (esf == null) {
			EObject eobj = epoint.getEObject();
			if (eobj == null) {
				return false;
			}
			EStructuralFeature esfC = eobj.eContainingFeature();
			if (esfC != null) {
				return esfC.isMany();
			}
		}
		
		return false;
	}


	public static String getOilVariantType(IVarTreePointer vtp) {
		EMap<String, String> map = getAnnotation(vtp);
		if (map != null) {
			if (map.containsKey(ANNOTATION_VARIANT_TYPE)) {
				return map.get(ANNOTATION_VARIANT_TYPE);
			}
		}
			
		return null;
	}

	protected static EMap<String, String> getAnnotation(IVarTreePointer vtp) {
		IVarTreePointer.EmfPoint epoint = vtp.getEPoint();
		EStructuralFeature esf = epoint.getCurrentFeature();
		if (esf == null) {
			EObject eobj = epoint.getEObject();
			if (eobj == null) {
				return null;
			}
			return  getAnnotation(eobj.eClass());
		} else {
			return  getAnnotation(esf.getEType());
		}
	}

	
	protected static EMap<String, String> getAnnotation(EModelElement classifier) {
		if (classifier != null) {
			EAnnotation annotation = classifier.getEAnnotation(RTDRUID_ANNOTATIONS_SOURCE);
			if (annotation != null) {
				return annotation.getDetails();
			}
		}
		return null;
	}
}