/**
 * Created on 12/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.ppc.ui.preferencepages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.eu.evidence.modules.oil.ppc.constants.PpcConstants;
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
	public static final String Ppc_CONF_PREFIX=IOPPConstants.PREFIX+"ppc_CONF."; //$NON-NLS-1$

	/** A String that identifies the Codewarrior Compiler Path */
	public static final String Ppc_CODEWARRIOR_CONF_CC= Ppc_CONF_PREFIX+"codewarrior_cc_path";
	/** A String that identifies the Diab Compiler Path */
	public static final String Ppc_DIAB_CONF_CC= Ppc_CONF_PREFIX+"diab_cc_path";
	/** A String that identifies the Gnu Compiler Path */
	public static final String Ppc_GNU_CONF_CC= Ppc_CONF_PREFIX+"gnu_cc_path";
	
	public static Options INSTANCE = new Options();
	
	protected ArrayList<OptionElement> initOpt() {
		ArrayList<OptionElement> answer = super.initOpt();
		answer.add(new OptionElement(
				Ppc_CODEWARRIOR_CONF_CC,
				PpcConstants.PREF_PPC_CODEWARRIOR_PATH,
				PpcConstants.DEFAULT_PPC_CODEWARRIOR_CONF_CC));
		
		answer.add(new OptionElement(
				Ppc_DIAB_CONF_CC,
				PpcConstants.PREF_PPC_DIAB_PATH,
				PpcConstants.DEFAULT_PPC_DIAB_CONF_GCC));
		
		answer.add(new OptionElement(
				Ppc_GNU_CONF_CC,
				PpcConstants.PREF_PPC_GNU_PATH,
				PpcConstants.DEFAULT_PPC_GNU_CONF_GCC));
		
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
