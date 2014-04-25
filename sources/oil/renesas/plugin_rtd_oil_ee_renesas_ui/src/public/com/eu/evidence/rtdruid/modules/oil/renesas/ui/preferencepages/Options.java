/**
 * Created on 29/March/2012
 */
package com.eu.evidence.rtdruid.modules.oil.renesas.ui.preferencepages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.IOPPConstants;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.UiOilBuilderOptions;
import com.eu.evidence.rtdruid.modules.oil.renesas.interfaces.RenesasConstants;

/**
 * @author Nicola Serreli
 *
 */
public class Options extends UiOilBuilderOptions {

	/*
	 * PROPERTIES Renesas
	 */
	public static final String RENESAS_CONF_PREFIX=IOPPConstants.PREFIX+"RENESAS_CONF."; //$NON-NLS-1$

	/** A String that identifies the GCC Path */
	public static final String RENESAS_CONF_CCRX= RENESAS_CONF_PREFIX+"ccrx_path";

	public static Options INSTANCE = new Options();

	protected ArrayList<OptionElement> initOpt() {
		ArrayList<OptionElement> answer = super.initOpt();
		answer.add(new OptionElement(
				RENESAS_CONF_CCRX,
				RenesasConstants.PREF_RX200_CCRX_CC_PATH,
				RenesasConstants.DEFAULT_RX200_CONF_CCRX_CC));
		
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
