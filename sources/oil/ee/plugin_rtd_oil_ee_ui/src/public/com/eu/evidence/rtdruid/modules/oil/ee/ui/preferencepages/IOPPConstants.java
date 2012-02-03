/*
 * Created on Jun 15, 2005
 *
 * $Id: IOPPConstants.java,v 1.3 2007/03/09 09:12:42 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages;

import com.eu.evidence.rtdruid.modules.oil.ee.ui.Activator;

/**
 * This interface contains only some ID used to store Oil's preferences
 * 
 * @author Nicola Serreli
 */
public interface IOPPConstants {

	/** Identifies the Erika Enterprise Location Preference page */
	public static final String EE_LOCATION_PREFERENCE_PAGE_ID = "com.eu.evidence.rtdruid.oil.eeLocationPreferencePagesID";
	
	// identifies the prefix of all oil preferences
	public static final String PLUGIN_ID = Activator.PLUGIN_ID;
	public static final String PREFIX = PLUGIN_ID+".";

	// Preference constants
	public static final String PRE_CHECK1=PREFIX+"check1"; //$NON-NLS-1$
	public static final String PRE_CHECK2=PREFIX+"check2"; //$NON-NLS-1$
	public static final String PRE_CHECK3=PREFIX+"check3"; //$NON-NLS-1$
	public static final String PRE_RADIO_CHOICE = PREFIX+"radio_choice"; //$NON-NLS-1$
	public static final String PRE_TEXT = PREFIX+"text"; //$NON-NLS-1$

	// Help context ids
//	public static final String EDITOR_ACTION1_CONTEXT = PREFIX+"editor_action1_context"; //$NON-NLS-1$
//	public static final String EDITOR_ACTION2_CONTEXT = PREFIX+"editor_action2_context"; //$NON-NLS-1$
//	public static final String EDITOR_ACTION3_CONTEXT = PREFIX+"editor_action3_context"; //$NON-NLS-1$
//	public static final String SECTIONS_VIEW_CONTEXT = PREFIX+"sections_view_context"; //$NON-NLS-1$
	public static final String PREFERENCE_PAGE_CONTEXT = PREFIX+"preference_page_context"; //$NON-NLS-1$
//	public static final String PROPERTY_PAGE_CONTEXT = PREFIX+"property_page_context"; //$NON-NLS-1$
//	public static final String PROPERTY_PAGE2_CONTEXT = PREFIX+"property_page2_context"; //$NON-NLS-1$
//	public static final String EDITOR_CONTEXT = PREFIX+"editor_context"; //$NON-NLS-1$
//	public static final String SECTIONS_DIALOG_CONTEXT = PREFIX+"sections_dialog_context"; //$NON-NLS-1$
//	public static final String CONTENT_OUTLINE_PAGE_CONTEXT = PREFIX+"content_outline_page_context"; //$NON-NLS-1$
//	public static final String CREATION_WIZARD_PAGE_CONTEXT = PREFIX+"creation_wizard_page_context"; //$NON-NLS-1$
	
	// Marker attributes
//	public static final String MARKER_ATT_ID = PREFIX+"id"; //$NON-NLS-1$
//	public static final String MARKER_ATT_LEVEL = PREFIX+"level"; //$NON-NLS-1$
//	public static final String MARKER_ATT_DEPT = PREFIX+"department"; //$NON-NLS-1$
//	public static final String MARKER_ATT_CODE = PREFIX+"code"; //$NON-NLS-1$
//	public static final String MARKER_ATT_LANG = PREFIX+"language"; //$NON-NLS-1$
	
	/*
	 * OS Configurator 
	 */
	public static final String OS_CONF_PREFIX=PREFIX+"OS_CONF."; //$NON-NLS-1$
	
	// Preference constants
	/** A String that identifies the distribution Type */
	public static final String OS_CONF_DISTRIBUTION_CHOICE=OS_CONF_PREFIX+"distribution";
	/** An Int that identifies a "Binary" distribution */
	public static final int OS_CONF_DISTRIBUTION_CHOICE_BINARY=0; 
	/** An Int that identifies a "Source" distribution */
	public static final int OS_CONF_DISTRIBUTION_CHOICE_SOURCE=1; // 0 = DEFAULT
	public static final int OS_CONF_DISTRIBUTION_CHOICE_DEFAULT = OS_CONF_DISTRIBUTION_CHOICE_SOURCE;  

	// Help context ids
	public static final String OS_CONF_CONTEXT = OS_CONF_PREFIX+"preference_page_context"; //$NON-NLS-1$

	/** A String that identifies the signature's file */
	public static final String OS_CONF_SIGNATURE_FILE=OS_CONF_PREFIX+"signature_file";
	/** The default place where looking for Signature's file */
	public static final String OS_CONF_SIGNATURE_FILE_DEFAULT="";

}
