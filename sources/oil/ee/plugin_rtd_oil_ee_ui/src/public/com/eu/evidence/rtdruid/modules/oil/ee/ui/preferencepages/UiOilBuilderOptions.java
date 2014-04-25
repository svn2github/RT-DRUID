package com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;

import com.eu.evidence.rtdruid.modules.oil.codewriter.options.IBuildOptions;
import com.eu.evidence.rtdruid.modules.oil.codewriter.options.PreferenceStorage;
import com.eu.evidence.rtdruid.ui.Rtd_core_uiPlugin;

public abstract class UiOilBuilderOptions implements IBuildOptions {
	
	protected class OptionElement {
		final String uiKey;
		final String confKey;
		final String defaultValue;
		public OptionElement(String uiKey,
				String confKey,
				String defaultValue) {
			this.uiKey = uiKey;
			this.confKey = confKey;
			this.defaultValue = defaultValue;
		}
	}

	protected PreferenceStorage pref;
	protected IPreferenceStore store;
	protected ArrayList<OptionElement> options;

	public UiOilBuilderOptions() {
		pref = PreferenceStorage.getCommonIstance();
		store = Rtd_core_uiPlugin.getDefault().getPreferenceStore();
		
		options = initOpt();
	}
	
	protected ArrayList<OptionElement> initOpt() {
		// do nothing
		return new ArrayList<OptionElement>();
	}
	
	/**
	 * Returns the values of preferences controlled by this preference page.
	 */
	public String getValue(String uiKey, String confKey, String defaultValue) {

		return store.contains(uiKey) ?
				store.getString(uiKey) :
				pref.getValue(confKey, defaultValue);
	}
	
	
	/**
	 * Returns the default value of preference controlled by this preference page.
	 */
	public String getUiDeafultValue(String uiKey) {

		for (OptionElement elem : options) {
			if (elem.uiKey.equals(uiKey))
				return pref.getValue(elem.confKey, elem.defaultValue);
		}
		return null;
	}
//	
//	/**
//	 * Returns the default value of preference controlled by this preference page.
//	 */
//	public String getUiDeafultValueByConfID(String confKey) {
//
//		for (OptionElement elem : options) {
//			if (elem.confKey.equals(confKey))
//				return pref.getValue(elem.confKey, elem.defaultValue);
//		}
//		return null;
//	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.cdt.ui.options.IBuildOptions#getOptions()
	 */
	public Map<String, ?> getOptions() {
		HashMap<String,String> answer = new HashMap<String,String>();
		for (OptionElement elem : options) {
			answer.put(elem.confKey, getValue(elem.uiKey, elem.confKey, elem.defaultValue));
		}
		return answer;
	}
	

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.cdt.ui.options.IBuildOptions#getOptions()
	 */
	public Map<String, String> getUiOptions() {
		HashMap<String,String> answer = new HashMap<String,String>();
		for (OptionElement elem : options) {
			answer.put(elem.uiKey, getValue(elem.uiKey, elem.confKey, elem.defaultValue));
		}
		return answer;
	}
}
