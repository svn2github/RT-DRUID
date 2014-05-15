/*
 * Created on Jun 15, 2005
 *
 * $Id: IAvrPPConstants.java,v 1.1 2007/07/18 06:53:03 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.avr.preferencepages;

/**
 * This interface contains only some ID used to store Oil's preferences
 * 
 * @author Nicola Serreli
 */
public interface IAvrPPConstants {
	// identifies the prefix of all oil preferences
	public static final String PLUGIN_ID ="com.eu.evidence.rtdruid.oil";
	public static final String PREFIX = PLUGIN_ID+".";

	/*
	 * Avr5 programmer Configurator 
	 */
	public static final String AVR5_PRG_CONF_PREFIX=PREFIX+"AVR5_PROGR_CONF."; //$NON-NLS-1$
	
	// Preference constants
	public static final String OS_CONF_CONTEXT = AVR5_PRG_CONF_PREFIX+"preference_page_context"; //$NON-NLS-1$
	
	
//	/** A String that identifies the distribution Type */
//	public static final String OS_CONF_DISTRIBUTION_CHOICE=OS_CONF_PREFIX+"distribution";
//	/** An Int that identifies a "Binary" distribution */
//	public static final int OS_CONF_DISTRIBUTION_CHOICE_BINARY=0; 
//	/** An Int that identifies a "Source" distribution */
//	public static final int OS_CONF_DISTRIBUTION_CHOICE_SOURCE=1; // 0 = DEFAULT
//	public static final int OS_CONF_DISTRIBUTION_CHOICE_DEFAULT = OS_CONF_DISTRIBUTION_CHOICE_SOURCE;  
//
//	// Help context ids
//	public static final String OS_CONF_CONTEXT = OS_CONF_PREFIX+"preference_page_context"; //$NON-NLS-1$
//
//	/** A String that identifies the signature's file */
//	public static final String OS_CONF_SIGNATURE_FILE=OS_CONF_PREFIX+"signature_file";
//	/** The default place where looking for Signature's file */
//	public static final String OS_CONF_SIGNATURE_FILE_DEFAULT="";

}
