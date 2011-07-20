/**
 * Created on 12/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.avr5.preferencepages;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;

import com.eu.evidence.modules.oil.avr.constants.AvrConstants;
import com.eu.evidence.rtdruid.modules.oil.codewriter.options.IBuildOptions;
import com.eu.evidence.rtdruid.ui.Rtd_core_uiPlugin;

/**
 * @author Nicola Serreli
 *
 */
public class Options implements IBuildOptions {
	/*
	 * PROPERTIES
	 */
	public static final String AVR5_CONF_PREFIX=IAvrPPConstants.PREFIX+"UISP_CONF."; //$NON-NLS-1$
	
	// Preference constants
	/** A String that identifies the Gcc Path */
	public static final String AVR_CONF_GCC_PATH=AVR5_CONF_PREFIX+"gcc_path";
	/** A String that identifies the Uisp Path */
	public static final String AVR_CONF_UISP_PATH=AVR5_CONF_PREFIX+"uisp_path";
	/** A String that identifies the choiche about which Serial Port use */
	public static final String AVR_CONF_SERIAL_DEVICE=AVR5_CONF_PREFIX+"serial_device";

	/*
	 * Default
	 */

	/** A String that identifies the default value of gcc path */
	public static final String DEFAULT_AVR_CONF_GCC_PATH= "C:\\programmi\\AVRGCC\\avrgcc";
	/** A String that identifies the default value of uisp path */
	public static final String DEFAULT_AVR_CONF_UISP_PATH= "c:\\cygwin\\usr\\local\\bin\\uisp.exe";

	/**
	 * Returns the values of preferences controlled by this preference page.
	 */
	public static HashMap<String, Object> getValues() {
		IPreferenceStore store = Rtd_core_uiPlugin.getDefault()
				.getPreferenceStore();
		HashMap<String, Object> answer = new HashMap<String, Object>();
		
		String gcc = store.contains(Options.AVR_CONF_GCC_PATH) ?
				store.getString(Options.AVR_CONF_GCC_PATH) 
				: Options.DEFAULT_AVR_CONF_GCC_PATH;
		
		answer.put(AvrConstants.PREF_AVR_GCC_PATH, gcc);
		
		String uisp = store.contains(Options.AVR_CONF_UISP_PATH) ?
				store.getString(Options.AVR_CONF_UISP_PATH) 
				: Options.DEFAULT_AVR_CONF_UISP_PATH;
		
		answer.put(Options.AVR_CONF_UISP_PATH, uisp);
		
		String serial = store.contains(Options.AVR_CONF_SERIAL_DEVICE) ?
				store.getString(Options.AVR_CONF_SERIAL_DEVICE) 
				: "";
		
		answer.put(Options.AVR_CONF_SERIAL_DEVICE, serial);
		
		return answer;
	}
	
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.cdt.ui.options.IBuildOptions#getOptions()
	 */
	public Map<String, ?> getOptions() {
		return getValues();
	}
}
