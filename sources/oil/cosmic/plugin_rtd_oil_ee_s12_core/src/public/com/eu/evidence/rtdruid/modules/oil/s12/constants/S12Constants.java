/**
 * Created on 30/set/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.s12.constants;

/**
 * @author Nicola Serreli
 *
 */
public interface S12Constants {

	/** Enable ICD2 for S12 */
//	public final static String SGRK__S12_ICD2__ = "__PIC_30_ICD2__";
	
	
	/***************************************************************************
	 * 
	 * S12 preferences
	 *  
	 **************************************************************************/
	public final static String PREF_S12_CODEWARRIOR_PATH = "preference_S12__path_for_codewarrior_compiler";
	public final static String PREF_S12_COSMIC_PATH = "preference_S12__path_for_cosmic_compiler";
	/*
	 * Default values
	 */
	public static final String DEFAULT_S12_COSMIC_CONF_GCC = "c:\\Program Files\\COSMIC\\EVAL12X";
	public static final String DEFAULT_S12_CODEWARRIOR_CONF_GCC = "c:\\Program Files\\Freescale\\CWS12v5.1";

	

}
