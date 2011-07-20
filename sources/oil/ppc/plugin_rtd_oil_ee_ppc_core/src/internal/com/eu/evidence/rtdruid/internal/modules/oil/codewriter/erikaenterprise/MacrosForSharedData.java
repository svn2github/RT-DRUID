package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import com.eu.evidence.modules.oil.erikaenterprise.interfaces.IMacrosForSharedData;

public class MacrosForSharedData implements IMacrosForSharedData {

	@Override
	public String vectorRam(String vectorName, String array) {
		return "EE_SHARED_IDATA "+vectorName+array;
	}

	@Override
	public String vectorRom(String vectorName, String array) {
		return "EE_SHARED_IDATA "+vectorName+array;
	}

	@Override
	public String constVectorRam(String vectorName, String array) {
		return "EE_SHARED_CDATA "+vectorName+array;
	}

	@Override
	public String constVectorRom(String vectorName, String array) {
		return "EE_SHARED_CDATA "+vectorName+array;
	}

	@Override
	public String valueRam(String valueName) {
		return "EE_SHARED_IDATA "+valueName;
	}

	@Override
	public String valueRom(String valueName) {
		return "EE_SHARED_IDATA "+valueName;
	}

	@Override
	public String constValueRam(String valueName) {
		return "EE_SHARED_CDATA "+valueName;
	}

	@Override
	public String constValueRom(String valueName) {
		return "EE_SHARED_CDATA "+valueName;
	}
	
}
