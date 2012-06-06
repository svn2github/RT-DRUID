/**
 * Created on 30/set/2008
 *
 * $Id$
 */
package com.eu.evidence.modules.oil.arm7.constants;

/**
 * @author Nicola Serreli
 *
 */
public interface Arm7Constants {

	/***************************************************************************
	 * 
	 * CPU
	 *  
	 **************************************************************************/

	/** Identifies the ARM7 cfg file (memory pointers) */
	public final static String FILE_EE_E7T_H = "cfg_e7t.h";

	/***************************************************************************
	 * 
	 * BOARD
	 *  
	 **************************************************************************/

	/** Enable EVALUATOR7T */
	public final static String DEF__EVALUATOR7T__ = "__EVALUATOR7T__";

	/***************************************************************************
	 * 
	 * MCU
	 *  
	 **************************************************************************/

	/** Enable samsung KS_32_C_50100 */
	public final static String DEF__SAMSUNG_KS32C50100__ = "__SAMSUNG_KS32C50100__";

	/** Enable samsung KS_32_C_50100 */
	public final static String DEF__unibo_mparm__ = "__unibo_mparm__";

	
	/***************************************************************************
	 * 
	 * ARM7 preferences
	 *  
	 **************************************************************************/
//	public final static String PREF_ARM7_ASM_PATH = "preference_arm7__path_for_asm_compiler";
	public final static String PREF_ARM7_GCC_PATH = "preference_arm7__path_for_cc_compiler";
	
}
