package com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw;

import com.eu.evidence.modules.oil.erikaenterprise.interfaces.IMacrosForSharedData;

public class EmptyMacrosForSharedData implements IMacrosForSharedData {

	@Override
	public String vectorRam(String vectorName, String array) {
		return vectorName + array;
	}

	@Override
	public String vectorRom(String vectorName, String array) {
		return vectorName + array;
	}

	@Override
	public String constVectorRam(String vectorName, String array) {
		return vectorName + array;
	}

	@Override
	public String constVectorRom(String vectorName, String array) {
		return vectorName + array;
	}

	@Override
	public String valueRam(String valueName) {
		return valueName;
	}

	@Override
	public String valueRom(String valueName) {
		return valueName;
	}

	@Override
	public String constValueRam(String valueName) {
		return valueName;
	}

	@Override
	public String constValueRom(String valueName) {
		return valueName;
	}

}
