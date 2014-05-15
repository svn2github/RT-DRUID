/**
 * Created on 12/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.avr.preferencepages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.eu.evidence.modules.oil.avr.constants.AvrConstants;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.UiOilBuilderOptions;

/**
 * @author Nicola Serreli
 *
 */
public class Options extends UiOilBuilderOptions {
	/*
	 * PROPERTIES
	 */
	public static final String AVR5_CONF_PREFIX=IAvrPPConstants.PREFIX+"UISP_CONF."; //$NON-NLS-1$
	
	public static final String AVR8_CONF_PREFIX=IAvrPPConstants.PREFIX+"AVR8."; //$NON-NLS-1$
	
	// Preference constants
	/** A String that identifies the Gcc Path */
	public static final String AVR5_CONF_GCC_PATH=AVR5_CONF_PREFIX+"gcc_path";
	/** A String that identifies the Gcc Path */
	public static final String AVR8_CONF_GCC_PATH=AVR8_CONF_PREFIX+"gcc_path";
	/** A String that identifies the Uisp Path */
	public static final String AVR_CONF_UISP_PATH=AVR5_CONF_PREFIX+"uisp_path";
	/** A String that identifies the choiche about which Serial Port use */
	public static final String AVR_CONF_SERIAL_DEVICE=AVR5_CONF_PREFIX+"serial_device";

	/** A String that identifies the Gcc Path */
	public static final String AVR8_CONF_ARDUINO_PATH=AVR8_CONF_PREFIX+"arduino_path";

	/*
	 * Default
	 */

	/** A String that identifies the default value of gcc path */
	public static final String DEFAULT_AVR_CONF_GCC_PATH= "C:\\programmi\\AVRGCC\\avrgcc";
	/** A String that identifies the default value of uisp path */
	public static final String DEFAULT_AVR_CONF_UISP_PATH= "c:\\cygwin\\usr\\local\\bin\\uisp.exe";

	public static Options INSTANCE = new Options();
	
	protected ArrayList<OptionElement> initOpt() {
		ArrayList<OptionElement> answer = super.initOpt();
		answer.add(new OptionElement(
				AVR5_CONF_GCC_PATH,
				AvrConstants.PREF_AVR5_GCC_PATH,
				Options.DEFAULT_AVR_CONF_GCC_PATH));
		
		answer.add(new OptionElement(
				AVR8_CONF_GCC_PATH,
				AvrConstants.PREF_AVR8_GCC_PATH,
				""));
		
		answer.add(new OptionElement(
				AVR_CONF_UISP_PATH,
				AVR_CONF_UISP_PATH,
				Options.DEFAULT_AVR_CONF_UISP_PATH));
		
		answer.add(new OptionElement(
				AVR_CONF_SERIAL_DEVICE,
				AVR_CONF_SERIAL_DEVICE,
				""));
		
		answer.add(new OptionElement(
				AVR8_CONF_ARDUINO_PATH,
				AvrConstants.PREF_AVR8_ARDUINO_PATH,
				""));

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
