/**
 * Created on 12/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.arm.ui.preferencepages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.eu.evidence.modules.oil.arm7.constants.Arm7Constants;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.IOPPConstants;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.UiOilBuilderOptions;

/**
 * @author Nicola Serreli
 * 
 */
public class Options extends UiOilBuilderOptions {

	/*
	 * PROPERTIES
	 */
	public static final String ARM_CONF_PREFIX = IOPPConstants.PREFIX
			+ "ARM7_CONF."; //$NON-NLS-1$

	/** A String that identifies the GCC Path */
	public static final String ARM_CONF_GCC = ARM_CONF_PREFIX + "gcc_path";
	// /** A String that identifies the ASM Path */
	// public static final String ARM_CONF_ASM= ARM_CONF_PREFIX+"asm_path";

	public static Options INSTANCE = new Options();
	
	/*
	 * Default values
	 */
	// public static final String DEFAULT_ARM_CONF_ASM = "";
	public static final String DEFAULT_ARM_CONF_GCC = "c:\\path\\to\\gcc";

	protected ArrayList<OptionElement> initOpt() {
		ArrayList<OptionElement> answer = super.initOpt();
		answer.add(new OptionElement(
				ARM_CONF_GCC,
				Arm7Constants.PREF_ARM7_GCC_PATH,
				DEFAULT_ARM_CONF_GCC));
		
		return answer;
	}
	/**
	 * Returns the values of preferences controlled by this preference page.
	 */
	public static Map<String, ?> getValues() {
		Map<String,Object> answer = new HashMap<String,Object>();
		answer.putAll(INSTANCE.getOptions());
		return answer;
	}
}
