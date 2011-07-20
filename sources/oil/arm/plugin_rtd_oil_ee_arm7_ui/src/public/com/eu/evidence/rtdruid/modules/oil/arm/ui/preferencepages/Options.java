/**
 * Created on 12/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.arm.ui.preferencepages;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;

import com.eu.evidence.modules.oil.arm7.constants.Arm7Constants;
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
	public static final String ARM_CONF_PREFIX = IOPPConstants.PREFIX
			+ "ARM7_CONF."; //$NON-NLS-1$

	/** A String that identifies the GCC Path */
	public static final String ARM_CONF_GCC = ARM_CONF_PREFIX + "gcc_path";
	// /** A String that identifies the ASM Path */
	// public static final String ARM_CONF_ASM= ARM_CONF_PREFIX+"asm_path";

	/*
	 * Default values
	 */
	// public static final String DEFAULT_ARM_CONF_ASM = "";
	public static final String DEFAULT_ARM_CONF_GCC = "c:\\path\\to\\gcc";

	/**
	 * Returns the values of preferences controlled by this preference page.
	 */
	public static HashMap<String, String> getValues() {
		IPreferenceStore store = Rtd_core_uiPlugin.getDefault()
				.getPreferenceStore();
		HashMap<String, String> answer = new HashMap<String, String>();

//		String asm = store.contains(ARM_CONF_ASM) ? store
//				.getString(ARM_CONF_ASM) : DEFAULT_ARM_CONF_ASM;
//
//		answer.put(ArmConstants.PREF_PIC30_ASM_PATH, asm);

		String gcc = store.contains(ARM_CONF_GCC) ? store
				.getString(ARM_CONF_GCC) : DEFAULT_ARM_CONF_GCC;
		answer.put(Arm7Constants.PREF_ARM7_GCC_PATH, gcc);

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
