package com.eu.evidence.rtdruid.modules.oil.codewriter.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Bundle;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.modules.oil.Rtd_oil_corePlugin;

public class RtdruidConfiguratorNumber {

	public final static String RTDRUID_CONFIGURATOR_NUMBER = "rtdruid.configurator.number";
	public final static String RTDRUID_CONFIGURATOR_NUMBER_ID = "" + '0';
	public final static String RTDRUID_CONFIGURATOR_BUILD_NUMBER_ID = "" + '2';
	
	private final static Properties currentVersion = new Properties();


	static {
		try {
			// RTDRUID Properties
			Bundle bundle = Rtd_oil_corePlugin.getDefault().getBundle();
			InputStream input = bundle == null ? null : FileLocator.openStream(bundle, new Path("/about.mappings"), false);
			
			if (input != null) {
				// read Version
				currentVersion.load(input);
			}
			
		} catch (IOException e) {
			RtdruidLog.log(e);
		}
	}
	
	public static String getRTDruidConfiguratorNumber() {
		
		return currentVersion.containsKey(RTDRUID_CONFIGURATOR_NUMBER_ID) ?
				currentVersion.getProperty(RTDRUID_CONFIGURATOR_NUMBER_ID) : 
					(currentVersion.containsKey(RTDRUID_CONFIGURATOR_NUMBER) ?
							currentVersion.getProperty(RTDRUID_CONFIGURATOR_NUMBER) : "");
	}
	
	public static String getRTDruidBuildNumber() {
		
		return currentVersion.containsKey(RTDRUID_CONFIGURATOR_BUILD_NUMBER_ID) ?
				currentVersion.getProperty(RTDRUID_CONFIGURATOR_BUILD_NUMBER_ID) : "";
	}
}
