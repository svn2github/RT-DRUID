package com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces;

/**
 * This interface is used to protect shared variables using macros
 * 
 * @author Nicola Serreli
 *
 */
public interface IMacrosForSharedData {
	
	public interface IPragma extends IMacrosForSharedData {
		String getPragmaSections();
	}
	
	IPragma getPragma();

	String vectorRamUnitialized(String type, String vectorName, String array, String body);

	String vectorRam(String type, String vectorName, String array, String body);

	String vectorRom(String type, String vectorName, String array, String body);

	String constVectorRam(String type, String vectorName, String array, String body);

	String constVectorRom(String type, String vectorName, String array, String body);

	String valueRamUnitialized(String type, String valueName, String body);
	
	String valueRam(String type, String valueName, String body);

	String valueRom(String type, String valueName, String body);

	String constValueRam(String type, String valueName, String body);

	String constValueRom(String type, String valueName, String body);
	
}
