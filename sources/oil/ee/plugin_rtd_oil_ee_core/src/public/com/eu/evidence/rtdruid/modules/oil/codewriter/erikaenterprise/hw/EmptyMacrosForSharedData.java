package com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw;

import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IMacrosForSharedData;

public class EmptyMacrosForSharedData implements IMacrosForSharedData {
	public static class EmptySharedDataWithPragma extends EmptyMacrosForSharedData implements IPragma {
		@Override
		public String getPragmaSections() {
			return "";
		}
	}

	@Override
	public IPragma getPragma() {
		return new EmptySharedDataWithPragma();
	}

	@Override
	public String vectorRamUnitialized(String type, String vectorName, String array, String body) {
		return type + vectorName + array + body;
	}
	
	@Override
	public String vectorRam(String type, String vectorName, String array, String body) {
		return type + vectorName + array + body;
	}

	@Override
	public String vectorRom(String type, String vectorName, String array, String body) {
		return type + vectorName + array + body;
	}

	@Override
	public String constVectorRam(String type, String vectorName, String array, String body) {
		return type + vectorName + array + body;
	}

	@Override
	public String constVectorRom(String type, String vectorName, String array, String body) {
		return type + vectorName + array + body;
	}
	
	@Override
	public String valueRamUnitialized(String type, String valueName, String body) {
		return type + valueName + body;
	}

	@Override
	public String valueRam(String type, String valueName, String body) {
		return type + valueName + body;
	}

	@Override
	public String valueRom(String type, String valueName, String body) {
		return type + valueName + body;
	}

	@Override
	public String constValueRam(String type, String valueName, String body) {
		return type + valueName + body;
	}

	@Override
	public String constValueRom(String type, String valueName, String body) {
		return type + valueName + body;
	}

}
