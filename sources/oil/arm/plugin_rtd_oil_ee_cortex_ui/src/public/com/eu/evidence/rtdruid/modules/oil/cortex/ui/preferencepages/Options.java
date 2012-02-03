/**
 * Created on 12/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.cortex.ui.preferencepages;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;

import com.eu.evidence.rtdruid.modules.oil.codewriter.options.IBuildOptions;
import com.eu.evidence.rtdruid.modules.oil.cortex.constants.CortexConstants;
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
	public static final String CORTEX_CONF_PREFIX = IOPPConstants.PREFIX
			+ "CORTEX_CONF."; //$NON-NLS-1$

	/** A String that identifies the GCC Path */
	public static final String CORTEX_CONF_GCC = CORTEX_CONF_PREFIX + "gcc_path";

	/*
	 * Default values
	 */
	public static final String DEFAULT_CORTEX_CONF_GCC = CortexConstants.DEFAULT_CORTEXM0_CONF_CC;

	/**
	 * Returns the values of preferences controlled by this preference page.
	 */
	public static HashMap<String, String> getValues() {
		IPreferenceStore store = Rtd_core_uiPlugin.getDefault()
				.getPreferenceStore();
		HashMap<String, String> answer = new HashMap<String, String>();

		String gcc = store.contains(CORTEX_CONF_GCC) ? store
				.getString(CORTEX_CONF_GCC) : DEFAULT_CORTEX_CONF_GCC;
		answer.put(CortexConstants.PREF_CORTEXM0_CC_PATH, gcc);

		return answer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eu.evidence.rtdruid.modules.oil.cdt.ui.options.IBuildOptions#getOptions
	 * ()
	 */
	@Override
	public Map<String, ?> getOptions() {
		return getValues();
	}
}
