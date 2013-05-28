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

	/**
	 * Returns the values of preferences controlled by this preference page.
	 */
	public static HashMap<String, String> getValues() {
		IPreferenceStore store = Rtd_core_uiPlugin.getDefault()
				.getPreferenceStore();
		HashMap<String, String> answer = new HashMap<String, String>();

		{
			String gcc = store.contains(CORTEX_CONF_CCS) ? store
					.getString(CORTEX_CONF_CCS) : DEFAULT_CORTEX_CONF_CCS;
			answer.put(CortexConstants.PREF_CORTEXMx_CCS_CC_PATH, gcc);
		}
		{
			String gcc = store.contains(CORTEX_CONF_IAR) ? store
					.getString(CORTEX_CONF_IAR) : DEFAULT_CORTEX_CONF_IAR;
			answer.put(CortexConstants.PREF_CORTEXMx_IAR_CC_PATH, gcc);
		}
		{
			String gcc = store.contains(CORTEX_CONF_KEIL) ? store
					.getString(CORTEX_CONF_KEIL) : DEFAULT_CORTEX_CONF_KEIL;
			answer.put(CortexConstants.PREF_CORTEXMx_KEIL_CC_PATH, gcc);
		}
		{
			String gcc = store.contains(CORTEX_CONF_GNU) ? store
					.getString(CORTEX_CONF_GNU) : DEFAULT_CORTEX_CONF_GNU;
			answer.put(CortexConstants.PREF_CORTEXMx_GNU_CC_PATH, gcc);
		}

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
