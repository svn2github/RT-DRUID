/**
 * Created on 21/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.modules.oil.ee.ui.preferencepages;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;

import com.eu.evidence.modules.oil.erikaenterprise.constants.IDistributionConstant;
import com.eu.evidence.rtdruid.modules.oil.codewriter.options.IBuildOptions;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.Activator;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.IOPPConstants;

/**
 * @author Nicola Serreli
 *
 */
public class Options implements IBuildOptions {

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.cdt.ui.options.IBuildOptions#getOptions()
	 */
	public Map<String, ?> getOptions() {
		
		
		// get Parent properties
		HashMap<String, Object> answer = new HashMap<String, Object>();
		
		// set Distribution Properties
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();

		int choice = store.contains(IOPPConstants.OS_CONF_DISTRIBUTION_CHOICE) ? 
				store.getInt(IOPPConstants.OS_CONF_DISTRIBUTION_CHOICE):
					IOPPConstants.OS_CONF_DISTRIBUTION_CHOICE_DEFAULT;

		switch (choice) {
		case IOPPConstants.OS_CONF_DISTRIBUTION_CHOICE_SOURCE:
			answer.put(IDistributionConstant.DEF__EE_USE_SOURCE_DISTRIBUTION__, "");
			break;
			
		case IOPPConstants.OS_CONF_DISTRIBUTION_CHOICE_BINARY:
		default : {
			
				String sign = store.contains(IOPPConstants.OS_CONF_SIGNATURE_FILE) ?
						store.getString(IOPPConstants.OS_CONF_SIGNATURE_FILE)
						: IOPPConstants.OS_CONF_SIGNATURE_FILE_DEFAULT;
						
				InputStream stream = null;
				
				final boolean disableSignature = true; 
				
				if (!disableSignature) {
					stream = null;//Utilities.searchSignature(enableMessages, sign, vt, rtosPath);
					
					if (stream == null) {
						throw new RuntimeException("No signature found");
					}

				}
				
				if (stream != null) {
					answer.put(IDistributionConstant.DEF__EE_USE_BINARY_DISTRIBUTION__, "");
					answer.put(IDistributionConstant.DEF__EE_SIGNATURE_DOCUMENT_ISTREAM__, stream);
					
				} else {
//					answer.put(IWritersKeywords.DEF__EE_USE_BINARY_DISTRIBUTION__, "ee_NIOS2_OO");
//					answer.put(IWritersKeywords.DEF__EE_DISTRIBUTION_NAME__, "NIOS2_OO");
//					answer.put(IWritersKeywords.DEF__EE_USE_BINARY_DISTRIBUTION_FULL__, "");
				}
				
				answer.put(IDistributionConstant.DEF__BINARY_DISTRIBUTION_FORCE_ALARM_AUTOSTART__, ""+true);
				answer.put(IDistributionConstant.DEF__BINARY_DISTRIBUTION_FORCE_TASK_AUTOSTART__, ""+true);
				
			}
			break;
		}

		// TODO Auto-generated method stub
		return answer;
	}
}
