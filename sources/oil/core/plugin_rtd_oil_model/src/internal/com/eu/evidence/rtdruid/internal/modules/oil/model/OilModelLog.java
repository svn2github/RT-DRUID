/*
 * Created on May 9, 2005
 *
 * $Id: RtdruidLog.java,v 1.3 2008/01/24 15:57:10 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.model;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

import com.eu.evidence.rtdruid.modules.oil.model.Activator;


/**
 *
 * This class is a wrapper to Eclipse Log  
 *
 * @author Nicola Serreli
 */
public class OilModelLog {
	
	private static boolean FINAL = false; 

	/** This method logs a String as an Exception */
	public static void log(String txt) {
		if (txt == null) {
			txt = "";
		}
		OilModelLog.log(new RuntimeException(txt));
	}

	/** This method logs a String with an Exception */
	public static void log(String txt, Throwable e) {
		if (e == null) {
			log(txt);
			return;
		}
		if (txt == null)
			txt = "null";
		OilModelLog.log(new RuntimeException(txt, e));
		return;
	}

	/**
     * This method works like "e.printStackTrace()" during testing and software
     * prodution, and does nothing in final version (FINAL == true).
     */
	public static void showDebug(Throwable e) {
		
		if (!FINAL) {
			// print the stack trace
			System.err.print(">>> ");
			e.printStackTrace();
			log(e);
			System.err.println("<<<");
		}
	}

	/**
     * This method works like "e.printStackTrace()" during testing and software
     * prodution, and does nothing in final version (FINAL == true).
     */
	public static void showDebug(String txt) {
		if (!FINAL) {
			// print the stack trace
			System.err.print(">>> " + txt + "<<<");
		}
	}

	/** This method logs Exceptions and Errors */
	public static void log(Throwable e) {
        if ( e instanceof CoreException ) {
            log(((CoreException)e).getStatus());
	    } else {
	            log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.ERROR, e.getMessage() == null ? "" : e.getMessage(), e));
	    }
	}
	
	public static void log(IStatus status) {
		ILog logger = Activator.getBundle() == null ? null: Platform.getLog(Activator.getBundle());
		
        if (logger != null) {
        	logger.log(status);
        } else {
        	status.getException().printStackTrace();
        }
	}
}
