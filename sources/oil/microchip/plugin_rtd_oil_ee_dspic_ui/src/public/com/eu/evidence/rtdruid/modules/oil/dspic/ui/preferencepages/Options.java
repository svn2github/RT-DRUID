/**
 * Created on 12/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.dspic.ui.preferencepages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.eu.evidence.modules.oil.dspic.constants.PicConstants;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.IOPPConstants;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.UiOilBuilderOptions;

/**
 * @author Nicola Serreli
 *
 */
public class Options extends UiOilBuilderOptions {

	/*
	 * PROPERTIES PIC 30
	 */
	public static final String PIC30_CONF_PREFIX=IOPPConstants.PREFIX+"PIC_CONF."; //$NON-NLS-1$
	/** A String that identifies the choiche about use EE Gcc for compile */
	public static final String PIC30_CONF_USE_EE_GCC_COMP=PIC30_CONF_PREFIX+"use_ee_gcc_compile";
	/** A String that identifies the choiche about use EE Gcc for deps */
	public static final String PIC30_CONF_USE_EE_GCC_DEPS=PIC30_CONF_PREFIX+"use_ee_gcc_deps";

	/** A String that identifies the GCC Path */
	public static final String PIC30_CONF_GCC= PIC30_CONF_PREFIX+"gcc_path";
	/** A String that identifies the ASM Path */
	public static final String PIC30_CONF_ASM= PIC30_CONF_PREFIX+"asm_path";

	
	/*
	 * PROPERTIES PIC 32
	 */
	public static final String PIC32_CONF_PREFIX=IOPPConstants.PREFIX+"PIC_32_CONF."; //$NON-NLS-1$

	/** A String that identifies the GCC Path */
	public static final String PIC32_CONF_GCC= PIC32_CONF_PREFIX+"gcc_path";
	/** A String that identifies the ASM Path */
	public static final String PIC32_CONF_ASM= PIC32_CONF_PREFIX+"asm_path";

	public static Options INSTANCE = new Options();

	protected ArrayList<OptionElement> initOpt() {
		ArrayList<OptionElement> answer = super.initOpt();
		answer.add(new OptionElement(
				PIC30_CONF_ASM,
				PicConstants.PREF_PIC30_ASM_PATH,
				PicConstants.DEFAULT_PIC30_CONF_ASM));
		
		answer.add(new OptionElement(
				PIC30_CONF_GCC,
				PicConstants.PREF_PIC30_GCC_PATH,
				PicConstants.DEFAULT_PIC30_CONF_GCC));
		
		answer.add(new OptionElement(
				PIC32_CONF_ASM,
				PicConstants.PREF_PIC32_ASM_PATH,
				PicConstants.DEFAULT_PIC32_CONF_ASM));
		
		answer.add(new OptionElement(
				PIC32_CONF_GCC,
				PicConstants.PREF_PIC32_GCC_PATH,
				PicConstants.DEFAULT_PIC32_CONF_GCC));
		
		return answer;
	}
	
	/**
	 * Returns the values of preferences controlled by this preference page.
	 */
	public static Map<String,?> getValues() {
		Map<String,Object> answer = new HashMap<String,Object>();
		answer.putAll(INSTANCE.getOptions());
		return answer;
	}
}
