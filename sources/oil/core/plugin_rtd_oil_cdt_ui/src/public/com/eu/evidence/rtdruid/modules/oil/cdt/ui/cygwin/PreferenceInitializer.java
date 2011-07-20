package com.eu.evidence.rtdruid.modules.oil.cdt.ui.cygwin;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

	public PreferenceInitializer() {
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = CygwinProperties.getPreferenceStore();
		
		String path = AutoCygwindSearch.search();
		
		if (path != null)
			store.setDefault(CygwinProperties.CYGWIN_ROOT, path);

	}

}
