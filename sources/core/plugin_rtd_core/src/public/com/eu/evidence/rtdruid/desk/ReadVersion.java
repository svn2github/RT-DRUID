/*
 * Created on 2-feb-2007
 *
 * $Id: ReadVersion.java,v 1.3 2007/03/14 13:37:51 durin Exp $
 */
package com.eu.evidence.rtdruid.desk;

import java.util.Dictionary;

import org.osgi.framework.Version;

import com.eu.evidence.rtdruid.Rtd_corePlugin;


/**
 * This class reads a Property file in the "rtd_core plugin directory" to
 * understand the current version ID
 * 
 * @author Nicola Serreli
 */
public class ReadVersion {
	
	private final static Version RTDRUID_VERSION;

	static {
		Version v = null;
		
		try {
			Dictionary<String, String> dict = Rtd_corePlugin.getDefault().getBundle().getHeaders();
			Object version = dict.get("Bundle-Version");
			if (version instanceof Version) {
				v = (Version) version;
			} else {
				v = Version.parseVersion("" + version);
			}
		} catch (Throwable e){
			RtdruidLog.log(e);
		}
		RTDRUID_VERSION = v;
		
	}
	
	public static String getRTDruidVersion() {
		return RTDRUID_VERSION != null ? RTDRUID_VERSION.toString() : "";
	}
}
