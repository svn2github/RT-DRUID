/**
 * Created on 2012/03/27
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.renesas.interfaces;


/**
 * 
 * @author Nicola Serreli
 */
public interface RenesasConstants {

	public static final String SGRK__RENESAS_COMPILER_TYPE__ = "sgrk_os__renesas_compiler_type";
	public static final String SGRK__RENESAS_USE_E2STUDIO__ = "sgrk_os__renesas_enable_e2studio";
	public static final String SGRK__RENESAS_USE_CSPLUS__ = "sgrk_os__renesas_enable_csplus";

	public static final String SGRK__CCRX_COMPILER__ = "CCRX";
	public static final String SGRK__CCRL_COMPILER__ = "CCRL";
	public static final String SGRK__CA78K0R_COMPILER__ = "CA78K0R";

	public static final String DEFAULT_RX200_CONF_CCRX_CC = "C:\\Programmi\\Renesas\\Hew\\Tools\\Renesas\\RX\\1_2_0";
	public static final String DEFAULT_RL78_CONF_CCRL_CC = "";
	public static final String DEFAULT_RL78_CONF_E2STUDIO = "";
	public static final String DEFAULT_RL78_CONF_CA78K0R_CC = "";
	public static final String DEFAULT_RL78_CONF_CSPLUS = "";

	public static final String PREF_RX200_CCRX_CC_PATH = "preference_renesas_rx200__path_for_ccrx_compiler";
	public static final String PREF_RL78_CCRL_CC_PATH = "preference_renesas_rl78__path_for_ccrl_compiler";
	public static final String PREF_RL78_E2STUDIO_PATH = "preference_renesas_rl78__path_for_e2studio";
	public static final String PREF_RL78_CA78K0R_CC_PATH = "preference_renesas_rl78__path_for_ca78k0r_compiler";
	public static final String PREF_RL78_CSPLUS_PATH = "preference_renesas_rl78__path_for_csplus";


}
