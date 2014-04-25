/**
 * Created on 12/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.s12.ui.preferencepages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.IOPPConstants;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.UiOilBuilderOptions;
import com.eu.evidence.rtdruid.modules.oil.s12.constants.S12Constants;

/**
 * @author Nicola Serreli
 *
 */
public class Options extends UiOilBuilderOptions {

	/*
	 * PROPERTIES
	 */
	public static final String S12_CONF_PREFIX=IOPPConstants.PREFIX+"S12_CONF."; //$NON-NLS-1$

	/** A String that identifies the Cosmic GCC Path */
	public static final String S12_CONF_GCC= S12_CONF_PREFIX+"gcc_path";
	/** A String that identifies the Codewarrior Gcc Path */
	public static final String S12_CODEWARRIOR_CONF_GCC= S12_CONF_PREFIX+"codewarrior_gcc_path";

	public static Options INSTANCE = new Options();
	
	protected ArrayList<OptionElement> initOpt() {
		ArrayList<OptionElement> answer = super.initOpt();
		answer.add(new OptionElement(
				S12_CODEWARRIOR_CONF_GCC,
				S12Constants.PREF_S12_CODEWARRIOR_PATH,
				S12Constants.DEFAULT_S12_CODEWARRIOR_CONF_GCC));
		
		answer.add(new OptionElement(
				S12_CONF_GCC,
				S12Constants.PREF_S12_COSMIC_PATH,
				S12Constants.DEFAULT_S12_COSMIC_CONF_GCC));
		
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
