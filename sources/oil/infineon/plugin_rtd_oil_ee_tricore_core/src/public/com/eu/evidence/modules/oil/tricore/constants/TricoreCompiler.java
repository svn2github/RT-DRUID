/**
 * 12/nov/2012
 */
package com.eu.evidence.modules.oil.tricore.constants;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public enum TricoreCompiler {
	GNU(TricoreConstants.SGRK__GNU_COMPILER__), TASKING(TricoreConstants.SGRK__TASKING_COMPILER__), DIAB(TricoreConstants.SGRK__DIAB_COMPILER__), UNKNOWN(null), DEFAULT(null);
	
	final String name;
	
	private TricoreCompiler(String name) {
		this.name = name;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public static TricoreCompiler get(String txt) {
		if (txt == null) {
			return DEFAULT;
		}
		for (TricoreCompiler elem :values()) {
			if (elem.name != null && elem.name.equalsIgnoreCase(txt)) {
				return elem;
			}
		}
		
		return UNKNOWN;
	}
}
