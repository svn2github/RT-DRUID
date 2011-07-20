/*
 * Created on 2-feb-2007
 *
 * $Id: ReadVersion.java,v 1.3 2007/03/14 13:37:51 durin Exp $
 */
package com.eu.evidence.rtdruid.desk;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * This class reads a Property file in the "rtd_core plugin directory" to
 * understand the current version ID
 * 
 * @author Nicola Serreli
 * 
 * @deprecated EE_VERSION in no more supported
 */
public class ReadVersion {
	
	public final static String RTDRUID_VERSION = "RTDruid_version";
	public final static String RTDRUID_BUILD = "RTDruid_build";
	public final static String EE_VERSION = "EE_version";
	
	public final static Properties currentVersion = new Properties();


	static {
		try {
			// RTDRUID Properties
			InputStream input = ReadVersion.class.getResourceAsStream("/version.properties");
			
			if (input != null) {
				// read Version
				currentVersion.load(input);
			}
			
			
		} catch (IOException e) {
			RtdruidLog.log(e);
		}

		try {
			// EE Properties
	    	final String eclisePath = CommonPaths.getEVIDENCE_BASE();

	    	FileInputStream input = new FileInputStream(eclisePath+File.separatorChar+"ee"+File.separatorChar+"version");
//			InputStream input = ReadVersion.class.getResourceAsStream("/version.properties");
			
			if (input != null) {
				// read Version
				Properties p = new Properties();
				p.load(input);
				currentVersion.putAll(p);
			}

		} catch (IOException e) {
			//RtdruidLog.showDebug(e);
		}

		//System.out.println(currentVersion);
	}
	
	public static String getRTDruidVersion() {
		return currentVersion.contains(RTDRUID_VERSION) ?
				currentVersion.getProperty(RTDRUID_VERSION) : "";
	}
}
