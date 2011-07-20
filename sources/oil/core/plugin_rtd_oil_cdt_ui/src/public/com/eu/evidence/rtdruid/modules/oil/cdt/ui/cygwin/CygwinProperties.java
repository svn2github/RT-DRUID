package com.eu.evidence.rtdruid.modules.oil.cdt.ui.cygwin;

import org.eclipse.jface.preference.IPreferenceStore;

import com.eu.evidence.rtdruid.modules.oil.cdt.ui.Rtd_oil_cdt_Plugin;

public class CygwinProperties {

	public final static String CYGWIN_ROOT = "local path to cygwin_root";
	
	public static IPreferenceStore getPreferenceStore() {
		return Rtd_oil_cdt_Plugin.getDefault().getPreferenceStore();
	}
	
	public static String getCygwinPath() {
		return getPreferenceStore().getString(CYGWIN_ROOT);
	}
}
