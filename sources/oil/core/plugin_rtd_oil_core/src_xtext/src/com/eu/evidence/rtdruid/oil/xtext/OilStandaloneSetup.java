
package com.eu.evidence.rtdruid.oil.xtext;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class OilStandaloneSetup extends OilStandaloneSetupGenerated{

	public static void doSetup() {
		new OilStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	
}

