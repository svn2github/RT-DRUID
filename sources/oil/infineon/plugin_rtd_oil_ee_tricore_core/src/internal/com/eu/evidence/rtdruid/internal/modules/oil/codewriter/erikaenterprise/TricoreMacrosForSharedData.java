package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IMacrosForSharedData;

public class TricoreMacrosForSharedData implements IMacrosForSharedData {

	final String indent1 = IWritersKeywords.INDENT;
	
	public static class TricoreSharedDataWithPragma extends TricoreMacrosForSharedData implements IPragma {
		@Override
		public String getPragmaSections() {
			return "";
		}
	}

	@Override
	public IPragma getPragma() {
		return new TricoreSharedDataWithPragma();
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IMacrosForSharedData#vectorRamUnitialized(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String vectorRamUnitialized(String type, String vectorName, String array, String body) {
		return type + "EE_SHARED_UDATA "+vectorName+array + body;
	}
	
	@Override
	public String vectorRam(String type, String vectorName, String array, String body) {
		return type + "EE_SHARED_IDATA "+vectorName+array + body;
	}

	@Override
	public String vectorRom(String type, String vectorName, String array, String body) {
		return type + "EE_SHARED_IDATA "+vectorName+array + body;
	}

	@Override
	public String constVectorRam(String type, String vectorName, String array, String body) {
		return type + "EE_SHARED_CDATA "+vectorName+array + body;
	}

	@Override
	public String constVectorRom(String type, String vectorName, String array, String body) {
		return type + "EE_SHARED_CDATA "+vectorName+array + body;
	}

	@Override
	public String valueRamUnitialized(String type, String valueName, String body) {
		return type + "EE_SHARED_UDATA "+valueName + body;
	}
	
	@Override
	public String valueRam(String type, String valueName, String body) {
		return type + "EE_SHARED_IDATA "+valueName + body;
	}

	@Override
	public String valueRom(String type, String valueName, String body) {
		return type + "EE_SHARED_IDATA "+valueName + body;
	}

	@Override
	public String constValueRam(String type, String valueName, String body) {
		return type + "EE_SHARED_CDATA "+valueName + body;
	}

	@Override
	public String constValueRom(String type, String valueName, String body) {
		return type + "EE_SHARED_CDATA "+valueName + body;
	}
	
}
