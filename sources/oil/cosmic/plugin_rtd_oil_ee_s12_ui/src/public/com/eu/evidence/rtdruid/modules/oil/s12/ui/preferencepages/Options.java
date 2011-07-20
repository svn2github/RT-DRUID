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
//	/** A String that identifies the choiche about use EE Gcc for compile */
//	public static final String S12_CONF_USE_EE_GCC_COMP=S12_CONF_PREFIX+"use_ee_gcc_compile";
//	/** A String that identifies the choiche about use EE Gcc for deps */
//	public static final String S12_CONF_USE_EE_GCC_DEPS=S12_CONF_PREFIX+"use_ee_gcc_deps";

	/** A String that identifies the GCC Path */
	public static final String S12_CONF_GCC= S12_CONF_PREFIX+"gcc_path";
	/** A String that identifies the ASM Path */
//	public static final String S12_CONF_ASM= S12_CONF_PREFIX+"asm_path";

	/*
	 * Default values
	 */
//	public static final String DEFAULT_S12_CONF_ASM = "c:\\Programmi\\COSMIC\\EVAL12X";
	public static final String DEFAULT_S12_CONF_GCC = "c:\\Programmi\\COSMIC\\EVAL12X";
//	public static final boolean DEFAULT_S12_CONF_USE_EE_GCC_COMP = false;
//	public static final boolean DEFAULT_S12_CONF_USE_EE_GCC_DEPS = false;

	/**
	 * Returns the values of preferences controlled by this preference page.
	 */
	public static HashMap<String,String> getValues() {
		IPreferenceStore store = Rtd_core_uiPlugin.getDefault()
				.getPreferenceStore();
		HashMap<String,String> answer = new HashMap<String,String>();
	
//		boolean use_ee_deps = store.contains(S12_CONF_USE_EE_GCC_DEPS) ? ("" + true)
//				.equals(store.getString(S12_CONF_USE_EE_GCC_DEPS))
//				: DEFAULT_S12_CONF_USE_EE_GCC_DEPS;
//		answer.put(S12Constants.PREF_PIC30_USE_EEGCC_DEPS, "" + use_ee_deps);
//	
//		boolean use_ee_comp = store.contains(S12_CONF_USE_EE_GCC_COMP) ? ("" + true)
//				.equals(store.getString(S12_CONF_USE_EE_GCC_COMP))
//				: DEFAULT_S12_CONF_USE_EE_GCC_COMP;
//		answer.put(S12Constants.PREF_PIC30_USE_EEGCC_COMPILE, "" + use_ee_comp);
	
//		String asm = store.contains(S12_CONF_ASM) ? store
//				.getString(S12_CONF_ASM) : DEFAULT_S12_CONF_ASM;
	
//		answer.put(S12Constants.PREF_S12_ASM_PATH, asm);
	
		String gcc = store.contains(S12_CONF_GCC) ? store
				.getString(S12_CONF_GCC) : DEFAULT_S12_CONF_GCC;
		answer.put(S12Constants.PREF_S12_GCC_PATH, gcc);
	
		return answer;
	}
	
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.cdt.ui.options.IBuildOptions#getOptions()
	 */
	public Map<String, ?> getOptions() {
		return getValues();
	}
}
