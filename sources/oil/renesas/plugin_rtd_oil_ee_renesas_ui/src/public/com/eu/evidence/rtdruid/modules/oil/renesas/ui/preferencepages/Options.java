/**
 * Created on 29/March/2012
 */
package com.eu.evidence.rtdruid.modules.oil.renesas.ui.preferencepages;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;

import com.eu.evidence.rtdruid.modules.oil.codewriter.options.IBuildOptions;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.IOPPConstants;
import com.eu.evidence.rtdruid.modules.oil.renesas.interfaces.RenesasConstants;
import com.eu.evidence.rtdruid.ui.Rtd_core_uiPlugin;

/**
 * @author Nicola Serreli
 *
 */
public class Options implements IBuildOptions {

	/*
	 * PROPERTIES Renesas
	 */
	public static final String RENESAS_CONF_PREFIX=IOPPConstants.PREFIX+"RENESAS_CONF."; //$NON-NLS-1$

	/** A String that identifies the GCC Path */
	public static final String RENESAS_CONF_CCRX= RENESAS_CONF_PREFIX+"ccrx_path";


	/**
	 * Returns the values of preferences controlled by this preference page.
	 */
	public static HashMap<String,String> getValues() {
		IPreferenceStore store = Rtd_core_uiPlugin.getDefault()
				.getPreferenceStore();
		HashMap<String,String> answer = new HashMap<String,String>();
	

		String ccrx = store.contains(RENESAS_CONF_CCRX) ? store
				.getString(RENESAS_CONF_CCRX) : RenesasConstants.DEFAULT_RX200_CONF_CCRX_CC;
		answer.put(RenesasConstants.PREF_RX200_CCRX_CC_PATH, ccrx);
		
		return answer;
	}
	
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.cdt.ui.options.IBuildOptions#getOptions()
	 */
	public Map<String, ?> getOptions() {
		return getValues();
	}
}
