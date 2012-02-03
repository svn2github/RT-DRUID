package com.eu.evidence.rtdruid.desk;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.service.datalocation.Location;

/**
 * 
 * 
 * @author Nicola Serreli
 *
 * @deprecated this class is replaced by EEPaths (inside rtdruid.ee.core plugin)
 */
public class CommonPaths {

	
	protected static CommonPaths Default = new CommonPaths();
	
	/** The eclipse path base.
	 * Note The path doen't contains the last "separator"*/
	protected String ECLIPSE_BASE;
	
	/** The eclipse path base.
	 * Note The path doen't contains the last "separator"*/
	protected String EVIDENCE_BASE;
	
	public CommonPaths() {
		String eclisePath = "";
		try {
	    	Location path = Platform.getInstallLocation();		    	
			URL url = path != null ? path.getURL() : null;
			//System.err.println("URL eclipse = " + url);
	    	if (url != null) {
	    		String tmp = url.getFile();
	    		// ususally the path is
	    		//      /C:/Programms/eclipse/
	    		tmp = tmp.startsWith("/") ? tmp.substring(1) : tmp;
	    		
	    		// ???????????????????????
	    		
	    		// converts all / into \
	    		tmp = tmp.replace('/', '\\');
	    		// remove last \
	    		tmp = tmp.endsWith("\\") ? tmp.substring(0, tmp.length()-1) : tmp;
	    		
	    		
	    		eclisePath = tmp; 
	    	}
		} catch (RuntimeException e) {
//			RtdruidLog.log(e);
		}
    	
    	ECLIPSE_BASE = eclisePath;
    	EVIDENCE_BASE = eclisePath + "\\..";

	}
	
	/** Note The path doen't contains the last "separator"*/
	public static String getECLIPSE_BASE() {
		return Default.ECLIPSE_BASE;
	}
	
	/** Overwrite the eclipse path.
	 *  Note The path doen't contains the last "separator"*/
	public static void setECLIPSE_BASE(String eclipse_base) {
		if (eclipse_base != null) {
			eclipse_base = eclipse_base.endsWith("\\") 
				? eclipse_base.substring(0, eclipse_base.length()-1) : eclipse_base;
		}
		Default.ECLIPSE_BASE  = eclipse_base;
	}

	/** Note The path doen't contains the last "separator"*/
	public static String getEVIDENCE_BASE() {
		return Default.EVIDENCE_BASE;
	}
	
	/** Overwrite the evidence base path.
	 *  Note The path doen't contains the last "separator"*/
	public static void setEVIDENCE_BASE(String evidence_base) {
		if (evidence_base != null) {
			evidence_base = evidence_base.endsWith("\\") 
				? evidence_base.substring(0, evidence_base.length()-1) : evidence_base;
		}
		Default.EVIDENCE_BASE  = evidence_base;
	}
}
