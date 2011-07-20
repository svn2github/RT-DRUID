/**
 * Created on 12/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.dspic.ui.preferencepages;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;

import com.eu.evidence.modules.oil.dspic.constants.PicConstants;
import com.eu.evidence.rtdruid.modules.oil.codewriter.options.IBuildOptions;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.IOPPConstants;
import com.eu.evidence.rtdruid.ui.Rtd_core_uiPlugin;

/**
 * @author Nicola Serreli
 *
 */
public class Options implements IBuildOptions {

	/*
	 * PROPERTIES PIC 30
	 */
	public static final String PIC30_CONF_PREFIX=IOPPConstants.PREFIX+"PIC_CONF."; //$NON-NLS-1$
	/** A String that identifies the choiche about use EE Gcc for compile */
	public static final String PIC30_CONF_USE_EE_GCC_COMP=PIC30_CONF_PREFIX+"use_ee_gcc_compile";
	/** A String that identifies the choiche about use EE Gcc for deps */
	public static final String PIC30_CONF_USE_EE_GCC_DEPS=PIC30_CONF_PREFIX+"use_ee_gcc_deps";

	/** A String that identifies the GCC Path */
	public static final String PIC30_CONF_GCC= PIC30_CONF_PREFIX+"gcc_path";
	/** A String that identifies the ASM Path */
	public static final String PIC30_CONF_ASM= PIC30_CONF_PREFIX+"asm_path";

	
	/*
	 * PROPERTIES PIC 32
	 */
	public static final String PIC32_CONF_PREFIX=IOPPConstants.PREFIX+"PIC_32_CONF."; //$NON-NLS-1$

	/** A String that identifies the GCC Path */
	public static final String PIC32_CONF_GCC= PIC32_CONF_PREFIX+"gcc_path";
	/** A String that identifies the ASM Path */
	public static final String PIC32_CONF_ASM= PIC32_CONF_PREFIX+"asm_path";


	/**
	 * Returns the values of preferences controlled by this preference page.
	 */
	public static HashMap<String,String> getValues() {
		IPreferenceStore store = Rtd_core_uiPlugin.getDefault()
				.getPreferenceStore();
		HashMap<String,String> answer = new HashMap<String,String>();
	
//		boolean use_ee_deps = store.contains(PIC30_CONF_USE_EE_GCC_DEPS) ? ("" + true)
//				.equals(store.getString(PIC30_CONF_USE_EE_GCC_DEPS))
//				: PicConstants.DEFAULT_PIC30_CONF_USE_EE_GCC_DEPS;
//		answer.put(PicConstants.PREF_PIC30_USE_EEGCC_DEPS, "" + use_ee_deps);
//	
//		boolean use_ee_comp = store.contains(PIC30_CONF_USE_EE_GCC_COMP) ? ("" + true)
//				.equals(store.getString(PIC30_CONF_USE_EE_GCC_COMP))
//				: PicConstants.DEFAULT_PIC30_CONF_USE_EE_GCC_COMP;
//		answer.put(PicConstants.PREF_PIC30_USE_EEGCC_COMPILE, "" + use_ee_comp);
	
		String asm_30 = store.contains(PIC30_CONF_ASM) ? store
				.getString(PIC30_CONF_ASM) : PicConstants.DEFAULT_PIC30_CONF_ASM;
		answer.put(PicConstants.PREF_PIC30_ASM_PATH, asm_30);
	
		String gcc_30 = store.contains(PIC30_CONF_GCC) ? store
				.getString(PIC30_CONF_GCC) : PicConstants.DEFAULT_PIC30_CONF_GCC;
		answer.put(PicConstants.PREF_PIC30_GCC_PATH, gcc_30);
	
		
		// ---------------
		
		
	
		String asm_32 = store.contains(PIC32_CONF_ASM) ? store
				.getString(PIC32_CONF_ASM) : PicConstants.DEFAULT_PIC32_CONF_ASM;
	
		answer.put(PicConstants.PREF_PIC32_ASM_PATH, asm_32);
	
		String gcc_32 = store.contains(PIC32_CONF_GCC) ? store
				.getString(PIC32_CONF_GCC) : PicConstants.DEFAULT_PIC32_CONF_GCC;
		answer.put(PicConstants.PREF_PIC32_GCC_PATH, gcc_32);

		
		
		return answer;
	}
	
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.cdt.ui.options.IBuildOptions#getOptions()
	 */
	public Map<String, ?> getOptions() {
		return getValues();
	}
}
