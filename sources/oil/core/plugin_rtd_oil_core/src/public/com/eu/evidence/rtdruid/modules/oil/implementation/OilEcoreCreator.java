package com.eu.evidence.rtdruid.modules.oil.implementation;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EPackage;

import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilEcoreCreatorImpl;

/**
*
* @author Nicola Serreli
* @since 2.0
*
*/
public abstract class OilEcoreCreator {

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
	

	/**
	 * Creates a Emf type identifier corresponding to an Oil type path
	 * 
	 * @param path
	 * @return
	 */
	public static String compute_full_name(ArrayList<String> path) {
		StringBuffer answer = new StringBuffer();
		
		for (String elem : path) {
			incremental_compute_full_name(answer, elem);
		}
		
		return answer.toString();
	}

	/**
	 * Creates a Emf type identifier corresponding to an Oil type path
	 * 
	 * @param path
	 * @return
	 */
	public static String incremental_compute_full_name(String base, String newElement) {
		return incremental_compute_full_name(new StringBuffer(base == null ? "" :base), newElement);
	}

	/**
	 * Creates a Emf type identifier corresponding to an Oil type path
	 * 
	 * @param base the 
	 * @param newElement
	 * @return
	 */
	private static String incremental_compute_full_name(StringBuffer base, String newElement) {
		StringBuffer answer = base;

		final String sep;
		if (answer.length() == 0) {
			sep = "";
			newElement = "OIL"+newElement;
		} else {
			 sep = "__";
		}
		answer.append(sep);

		// this loop searches all sequences of _ and replace them with _counter
		// where the counter is the number of consecutive _ (max 9)
		int counter = 0;
		for (byte c: newElement.getBytes()) {
			if (((char)c) == '_') {
				counter++;
				if (counter==9) {
					answer.append("_9");
					counter = 0;
				}
			} else {
				if (counter >0) {
					answer.append("_"+counter);
					counter = 0;
				}
				answer.append((char)c);
			}
		}
		
		return answer.toString();
	}

	
}