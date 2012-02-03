/**
 * Created on 12/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.s12.ui.preferencepages;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;

import com.eu.evidence.rtdruid.modules.oil.codewriter.options.IBuildOptions;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.IOPPConstants;
import com.eu.evidence.rtdruid.modules.oil.s12.constants.S12Constants;
import com.eu.evidence.rtdruid.ui.Rtd_core_uiPlugin;

/**
 * @author Nicola Serreli
 *
 */
public class Options implements IBuildOptions {

	/*
	 * PROPERTIES
	 */
	public static final String S12_CONF_PREFIX=IOPPConstants.PREFIX+"S12_CONF."; //$NON-NLS-1$

	/** A String that identifies the Cosmic GCC Path */
	public static final String S12_CONF_GCC= S12_CONF_PREFIX+"gcc_path";
	/** A String that identifies the Codewarrior Gcc Path */
	public static final String S12_CODEWARRIOR_CONF_GCC= S12_CONF_PREFIX+"codewarrior_gcc_path";

	/**
	 * Returns the values of preferences controlled by this preference page.
	 */
	public static HashMap<String,String> getValues() {
		IPreferenceStore store = Rtd_core_uiPlugin.getDefault()
				.getPreferenceStore();
		HashMap<String,String> answer = new HashMap<String,String>();
	
		String cwPath = store.contains(S12_CODEWARRIOR_CONF_GCC) ? store
				.getString(S12_CODEWARRIOR_CONF_GCC) : S12Constants.DEFAULT_S12_CODEWARRIOR_CONF_GCC;
	
		answer.put(S12Constants.PREF_S12_CODEWARRIOR_PATH, cwPath);
	
		String gcc = store.contains(S12_CONF_GCC) ? store
				.getString(S12_CONF_GCC) : S12Constants.DEFAULT_S12_COSMIC_CONF_GCC;
		answer.put(S12Constants.PREF_S12_COSMIC_PATH, gcc);
	
		return answer;
	}
	
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.cdt.ui.options.IBuildOptions#getOptions()
	 */
	public Map<String, ?> getOptions() {
		return getValues();
	}
}
