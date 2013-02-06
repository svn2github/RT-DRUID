/**
 * Created on 26/jan/2010
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.modules.oil.mico32.constants;

import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;


/**
 * @author Nicola Serreli
 *
 */
public interface Mico32Constants {

	public final static String SGRK__MICO32_SMALLC__ = "sgrk_cpu_property_mico32__use_smallc";
	public final static String SGRK__MICO32_STANDALONE_PRINTF__ = "sgrk_cpu_property_mico32__use_standalone_printf";

	public final static String SGRK__MICO32_BOARD_EEC_DEFINES__ = "sgrk_cpu_property_mico32__eecfgH__board_definitions";

	public final static String SGRK__OS_PLATFORM_NAME__ = "sgrk_cpu_property_mico32__mcu_platform_name";
	public final static String SGRK__OS_PLATFORM_LIB_PATH_ = "sgrk_cpu_property_mico32__mcu_platform_lib_path";
	public final static String SGRK__OS_PLATFORM_CFG__ = "sgrk_cpu_property_mico32__mcu_platform_cfg";


	public final static String SGRK__MICO32_LAST_USED_UART__Integer = "sgrk_cpu_property_mico32__last_used_uart_id";
	public final static String SGRK__MICO32_LAST_USED_SPI__Integer = "sgrk_cpu_property_mico32__last_used_spi_id";
	public final static String SGRK__MICO32_LAST_USED_TIMER__Integer = "sgrk_cpu_property_mico32__last_used_timer_id";
	public final static String SGRK__MICO32_LAST_USED_I2C__Integer = "sgrk_cpu_property_mico32__last_used_i2c_id";
	public final static String SGRK__MICO32_LAST_USED_GPIO__Integer = "sgrk_cpu_property_mico32__last_used_gpio_id";

	
	
	public final static String SGRK__ISR_LEVEL__ = ISimpleGenResKeywords.ISR_LEVEL;
	public final static String SGRK__ISR_HANDLER__ = ISimpleGenResKeywords.ISR_HANDLER;

	/***************************************************************************
	 * 
	 * MICO32 preferences
	 *  
	 **************************************************************************/
	public final static String PREF_MICO32_ASM_PATH = "preference_mico32__path_for_asm_compiler";
	public final static String PREF_MICO32_GCC_PATH = "preference_mico32__path_for_gcc_compiler";
	
	public final static String PREF_MICO32_USE_EEGCC_DEPS = "preference_mico32__use_evidence_compiler_4_deps";
	public final static String PREF_MICO32_USE_EEGCC_COMPILE = "preference_mico32__use_evidence_compiler_4_compile";

	

}
