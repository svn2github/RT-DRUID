/**
 * Created on 30/set/2008
 *
 * $Id$
 */
package com.eu.evidence.modules.oil.dspic.constants;

/**
 * @author Nicola Serreli
 *
 */
public interface PicConstants {

	/** Enable ICD2 for PIC30 */
	public final static String SGRK__PIC30_ICD2__ = "__PIC_30_ICD2__";
	public final static String SGRK__PIC32_ICD2__ = "__PIC32_ICD2__";
	
	
	/***************************************************************************
	 * 
	 * PIC30 preferences
	 *  
	 **************************************************************************/
	public final static String PREF_PIC30_ASM_PATH = "preference_pic30__path_for_asm_compiler";
	public final static String PREF_PIC30_GCC_PATH = "preference_pic30__path_for_gcc_compiler";
	//public final static String PREF_PIC30_USE_EE_GCC = "preference_pic30__use_evidence_compiler";
	
//	public final static String PREF_PIC30_USE_EEGCC_DEPS = "preference_pic30__use_evidence_compiler_4_deps";
//	public final static String PREF_PIC30_USE_EEGCC_COMPILE = "preference_pic30__use_evidence_compiler_4_compile";


	/***************************************************************************
	 * 
	 * PIC32 preferences
	 *  
	 **************************************************************************/
	public final static String PREF_PIC32_ASM_PATH = "preference_pic32__path_for_asm_compiler";
	public final static String PREF_PIC32_GCC_PATH = "preference_pic32__path_for_gcc_compiler";


	
	/***************************************************************************
	 * 
	 * Default values PIC 30
	 *  
	 **************************************************************************/
	public static final String DEFAULT_PIC30_CONF_ASM = "c:\\Programmi\\Microchip\\MPLAB ASM30 Suite";
	public static final String DEFAULT_PIC30_CONF_GCC = "c:\\Programmi\\Microchip\\MPLAB C30";
//	public static final boolean DEFAULT_PIC30_CONF_USE_EE_GCC_COMP = false;
//	public static final boolean DEFAULT_PIC30_CONF_USE_EE_GCC_DEPS = false;

	
	/***************************************************************************
	 * 
	 * Default values PIC 32
	 *  
	 **************************************************************************/
	public static final String DEFAULT_PIC32_CONF_ASM = "";
	public static final String DEFAULT_PIC32_CONF_GCC = "c:\\Programmi\\Microchip\\MPLAB C32";

}
