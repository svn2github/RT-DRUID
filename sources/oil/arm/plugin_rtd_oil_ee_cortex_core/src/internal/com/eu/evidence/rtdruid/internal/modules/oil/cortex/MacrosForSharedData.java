package com.eu.evidence.rtdruid.internal.modules.oil.cortex;

import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IMacrosForSharedData;

public class MacrosForSharedData implements IMacrosForSharedData {

	final String indent1 = IWritersKeywords.INDENT;

	public static class SharedDataWithPragma extends MacrosForSharedData implements IPragma {

		public String getPragmaSections() {
			return "";
		}
	}


	public IPragma getPragma() {
		return new SharedDataWithPragma();
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IMacrosForSharedData#vectorRamUnitialized(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */

	public String vectorRamUnitialized(String type, String vectorName, String array, String body) {
		return type + "EE_SHARED_UDATA "+vectorName+array + body;
	}


	public String vectorRam(String type, String vectorName, String array, String body) {
		return type + "EE_SHARED_IDATA "+vectorName+array + body;
	}


	public String vectorRom(String type, String vectorName, String array, String body) {
		return type + "EE_SHARED_IDATA "+vectorName+array + body;
	}


	public String constVectorRam(String type, String vectorName, String array, String body) {
		return type + "EE_SHARED_CDATA "+vectorName+array + body;
	}


	public String constVectorRom(String type, String vectorName, String array, String body) {
		return type + "EE_SHARED_CDATA "+vectorName+array + body;
	}


	public String valueRamUnitialized(String type, String valueName, String body) {
		return type + "EE_SHARED_UDATA "+valueName + body;
	}


	public String valueRam(String type, String valueName, String body) {
		return type + "EE_SHARED_IDATA "+valueName + body;
	}


	public String valueRom(String type, String valueName, String body) {
		return type + "EE_SHARED_IDATA "+valueName + body;
	}


	public String constValueRam(String type, String valueName, String body) {
		return type + "EE_SHARED_CDATA "+valueName + body;
	}


	public String constValueRom(String type, String valueName, String body) {
		return type + "EE_SHARED_CDATA "+valueName + body;
	}

}
