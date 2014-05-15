
package com.eu.evidence.modules.oil.tricore.constants;

import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;

/**
 * @author Nicola Serreli
 *
 */
public interface TricoreConstants {

	
	public final static String SGRK__TRICORE_MODEL__ = "sgrk_cpu_property_tricore1__model";
	public final static String SGRK__TRICORE_MODEL_INFO__ = "sgrk_cpu_property_tricore1__model_info";

	public final static String SGRK__TRICORE_BOARD_MODEL__ = "sgrk_cpu_property_tricore1__board_model";

	
	public final static String SGRK__ISR_LEVEL__ = ISimpleGenResKeywords.ISR_LEVEL;
	public final static String SGRK__ISR_HANDLER__ = ISimpleGenResKeywords.ISR_HANDLER;

	
	public final static String ISR_HANDLER_FILE = "ee_hndlr.S";
	
	public static final String SGRK__Tricore_COMPILER_TYPE__ = "sgrk_os__compiler_type";
	public static final String SGRK__Tricore_COMPILER_EXPORT_FILE__ = "sgrk_os__compiler_export_file";
	public static final String SGRK__GNU_COMPILER__ = "GNU";
	public static final String SGRK__TASKING_COMPILER__ = "TASKING";
	public static final String SGRK__DIAB_COMPILER__ = "DIAB";


	public static final String PREF_TRICORE_TASKING_CC_PATH = "preference_tricore__path_for_tasking_compiler";
	public static final String PREF_TRICORE_GNU_CC_PATH     = "preference_tricore__path_for_gnu_compiler";
	public static final String PREF_TRICORE_DIAB_CC_PATH    = "preference_tricore__path_for_diab_compiler";

}
