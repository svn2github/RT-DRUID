package com.eu.evidence.rtdruid.vartree.data;

import java.util.HashMap;

import org.eclipse.emf.ecore.EDataType;

public final class ExtendVarManager {
	protected static HashMap<String, ExtendVar> extendedVariables = new HashMap<String, ExtendVar>();

	public static boolean containsExtention(EDataType eDataType) {
		return extendedVariables.containsKey("" + eDataType.getClassifierID());
	}
	
	public static Object createExtendedVarFromString(EDataType eDataType,
			String initialValue) {
		return containsExtention(eDataType) ? 
			((ExtendVar) extendedVariables.get(""
					+ eDataType.getClassifierID()))
					.createFromString(initialValue)
			: null;
	}

	public static String convertToString(EDataType eDataType, Object instanceValue) {
		return containsExtention(eDataType) ? 
			((ExtendVar) extendedVariables.get(""
					+ eDataType.getClassifierID()))
					.convertToString(instanceValue)
			: null;
	}
	
	public static ExtendVar getExtendVariable(EDataType eDataType) {
		return containsExtention(eDataType) ? 
				(ExtendVar) extendedVariables.get("" + eDataType.getClassifierID())
				: null;
	}


	public static void extendVariable(EDataType eDataType, Class<?> instanceClass,
			ExtendVar helper) {
		if (eDataType == null || instanceClass == null || helper == null) {
			throw new NullPointerException(
					"Required a not null dataType, instanceClass and helper");
		}

		if (eDataType.getInstanceClass() == instanceClass) {
			return;
		}

		if (extendedVariables.containsKey("" + eDataType.getClassifierID())) {
			throw new IllegalArgumentException(
					"Data Type already extended (" + eDataType + ")");
		}

		extendedVariables.put("" + eDataType.getClassifierID(), helper);
		eDataType.setInstanceClass(instanceClass);
	}

}
