/**
 * Created on 21/09/2011
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.cortex.constants;

/**
 * @author Nicola Serreli
 *
 */
public interface CortexConstants {

	/***************************************************************************
	 * 
	 * Gen Res Keywords
	 *  
	 **************************************************************************/
	public static final String SGRK__CORTEX_CPU_MODEL__ = "sgrk_os__cortex_cpu_model";
	public static final String SGRK__CORTEX_M0__ = "M0";
	public static final String SGRK__CORTEX_M4__ = "M4";
	public static final String SGRK__CORTEX_A9__ = "A9";

	public static final String SGRK__CORTEX_JLINK__ = "sgrk_os__cortex_jlink";
//	public static final String SGRK__CORTEX_IAR__ = "sgrk_os__iar_compiler";
//	public static final String SGRK__CORTEX_CCS__ = "sgrk_os__ccs_compiler";
	public static final String SGRK__CORTEX_COMPILER_TYPE__ = "sgrk_os__compiler_type";
	public static final String SGRK__IAR_COMPILER__ = "IAR";
	public static final String SGRK__CCS_COMPILER__ = "CCS";
	public static final String SGRK__KEIL_COMPILER__ = "KEIL";
	public static final String SGRK__GNU_COMPILER__ = "GNU";

	/***************************************************************************
	 * 
	 * CORTEX M0 preferences
	 *  
	 **************************************************************************/
	public final static String PREF_CORTEXM0_CC_PATH = "preference_cortex_m0__path_for_cc_compiler";
	public final static String PREF_CORTEXMx_IAR_CC_PATH = "preference_cortex_mx__path_for_iar_compiler";
	public final static String PREF_CORTEXMx_CCS_CC_PATH = "preference_cortex_mx__path_for_ccs_compiler";
	public final static String PREF_CORTEXMx_KEIL_CC_PATH = "preference_cortex_mx__path_for_keil_compiler";
	public final static String PREF_CORTEXMx_GNU_CC_PATH = "preference_cortex_mx__path_for_gnu_compiler";


	/***************************************************************************
	 * 
	 * Default values CORTEX M0
	 *  
	 **************************************************************************/
	public static final String DEFAULT_CORTEXM0_CONF_CC = "C:\\Programmi\\IAR Systems\\Embedded Workbench 6.0 Kickstart\\arm";
	public static final String DEFAULT_CORTEXMX_CONF_IAR_CC = "C:\\Programmi\\IAR Systems\\Embedded Workbench 6.0 Kickstart\\arm";
	public static final String DEFAULT_CORTEXMX_CONF_CCS_CC = "C:\\Programmi\\Texas Instruments\\ccsv4";
	public static final String DEFAULT_CORTEXMX_CONF_KEIL_CC = "C:\\Keil\\ARM";
	public static final String DEFAULT_CORTEXMX_CONF_GNU_CC = "C:\\gnu\\ARM";


	/***************************************************************************
	 *
	 * CORTEX Ax preferences
	 *  
	 **************************************************************************/
	public final static String PREF_CORTEXAx_GNU_CC_PATH = "preference_cortex_ax__path_for_gnu_compiler";
	public final static String PREF_CORTEXAxXenPV_GNU_CC_PATH = "preference_cortex_ax_xenpv__path_for_gnu_compiler";


	/***************************************************************************
	 *
	 * Default values CORTEX Ax
	 *
	 **************************************************************************/
	public static final String DEFAULT_CORTEXAx_CONF_GNU_CC = "C:\\gnu\\ARM";

}
