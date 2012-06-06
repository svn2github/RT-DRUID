/**
 * Created on 12/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.ppc.ui.preferencepages;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;

import com.eu.evidence.modules.oil.ppc.constants.PpcConstants;
import com.eu.evidence.rtdruid.modules.oil.codewriter.options.IBuildOptions;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.IOPPConstants;
import com.eu.evidence.rtdruid.ui.Rtd_core_uiPlugin;

/**
 * @author Nicola Serreli
 *
 */
public class Options implements IBuildOptions {

	/*
	 * PROPERTIES
	 */
	public static final String Ppc_CONF_PREFIX=IOPPConstants.PREFIX+"ppc_CONF."; //$NON-NLS-1$

	/** A String that identifies the Codewarrior Compiler Path */
	public static final String Ppc_CODEWARRIOR_CONF_CC= Ppc_CONF_PREFIX+"codewarrior_cc_path";
	/** A String that identifies the Diab Compiler Path */
	public static final String Ppc_DIAB_CONF_CC= Ppc_CONF_PREFIX+"diab_cc_path";
	
	/**
	 * Returns the values of preferences controlled by this preference page.
	 */
	public static HashMap<String,String> getValues() {
		IPreferenceStore store = Rtd_core_uiPlugin.getDefault()
				.getPreferenceStore();
		HashMap<String,String> answer = new HashMap<String,String>();
	
		String cwPath = store.contains(Ppc_CODEWARRIOR_CONF_CC) ? store
				.getString(Ppc_CODEWARRIOR_CONF_CC) : PpcConstants.DEFAULT_PPC_CODEWARRIOR_CONF_CC;
	
		answer.put(PpcConstants.PREF_PPC_CODEWARRIOR_PATH, cwPath);
	

		String diabPath = store.contains(Ppc_DIAB_CONF_CC) ? store
				.getString(Ppc_DIAB_CONF_CC) : PpcConstants.DEFAULT_PPC_DIAB_CONF_GCC;
	
		answer.put(PpcConstants.PREF_PPC_DIAB_PATH, diabPath);

		return answer;
	}
	
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.cdt.ui.options.IBuildOptions#getOptions()
	 */
	public Map<String, ?> getOptions() {
		return getValues();
	}
}
