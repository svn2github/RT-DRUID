/**
 * Created on 12/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.tricore.ui.preferencepages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.eu.evidence.modules.oil.tricore.constants.TricoreConstants;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.IOPPConstants;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.UiOilBuilderOptions;

/**
 * @author Nicola Serreli
 *
 */
public class Options extends UiOilBuilderOptions {

	public static final String TRICORE_CONF_PREFIX=IOPPConstants.PREFIX+"TRICORE_CONF."; //$NON-NLS-1$
	
	public static final String TRICORE_CONF_TASKING_CC_PATH = TRICORE_CONF_PREFIX+"tasking_compiler";
	public static final String TRICORE_CONF_GNU_CC_PATH     = TRICORE_CONF_PREFIX+"gnu_compiler";
	public static final String TRICORE_CONF_DIAB_CC_PATH    = TRICORE_CONF_PREFIX+"diab_compiler";

	public static Options INSTANCE = new Options();

	protected ArrayList<OptionElement> initOpt() {
		ArrayList<OptionElement> answer = super.initOpt();
		answer.add(new OptionElement(
				TRICORE_CONF_TASKING_CC_PATH,
				TricoreConstants.PREF_TRICORE_TASKING_CC_PATH,
				""));
		
		answer.add(new OptionElement(
				TRICORE_CONF_GNU_CC_PATH,
				TricoreConstants.PREF_TRICORE_GNU_CC_PATH,
				""));
		
		answer.add(new OptionElement(
				TRICORE_CONF_DIAB_CC_PATH,
				TricoreConstants.PREF_TRICORE_DIAB_CC_PATH,
				""));
		
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
