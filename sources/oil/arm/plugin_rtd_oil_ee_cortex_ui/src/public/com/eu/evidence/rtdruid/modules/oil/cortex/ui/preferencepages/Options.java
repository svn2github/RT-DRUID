/**
 * Created on 12/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.cortex.ui.preferencepages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.eu.evidence.rtdruid.modules.oil.cortex.constants.CortexConstants;
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
	public static final String CORTEX_CONF_PREFIX = IOPPConstants.PREFIX
			+ "CORTEX_CONF."; //$NON-NLS-1$

	/** A String that identifies the GCC Path */
	public static final String CORTEX_CONF_CCS = CORTEX_CONF_PREFIX + "ccs_path";
	public static final String CORTEX_CONF_IAR = CORTEX_CONF_PREFIX + "iar_path";
	public static final String CORTEX_CONF_KEIL = CORTEX_CONF_PREFIX + "keil_path";
	public static final String CORTEX_CONF_GNU = CORTEX_CONF_PREFIX + "gcc_path";

	/*
	 * Default values
	 */
	public static final String DEFAULT_CORTEX_CONF_CCS = CortexConstants.DEFAULT_CORTEXMX_CONF_CCS_CC;
	public static final String DEFAULT_CORTEX_CONF_IAR = CortexConstants.DEFAULT_CORTEXMX_CONF_IAR_CC;
	public static final String DEFAULT_CORTEX_CONF_KEIL = CortexConstants.DEFAULT_CORTEXMX_CONF_KEIL_CC;
	public static final String DEFAULT_CORTEX_CONF_GNU = CortexConstants.DEFAULT_CORTEXMX_CONF_GNU_CC;

	public static Options INSTANCE = new Options();
	
	protected ArrayList<OptionElement> initOpt() {
		ArrayList<OptionElement> answer = super.initOpt();
		answer.add(new OptionElement(
				CORTEX_CONF_CCS,
				CortexConstants.PREF_CORTEXMx_CCS_CC_PATH,
				DEFAULT_CORTEX_CONF_CCS));
		
		answer.add(new OptionElement(
				CORTEX_CONF_IAR,
				CortexConstants.PREF_CORTEXMx_IAR_CC_PATH,
				DEFAULT_CORTEX_CONF_IAR));
		
		answer.add(new OptionElement(
				CORTEX_CONF_KEIL,
				CortexConstants.PREF_CORTEXMx_KEIL_CC_PATH,
				DEFAULT_CORTEX_CONF_KEIL));
		
		answer.add(new OptionElement(
				CORTEX_CONF_GNU,
				CortexConstants.PREF_CORTEXMx_GNU_CC_PATH,
				DEFAULT_CORTEX_CONF_GNU));
		
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
