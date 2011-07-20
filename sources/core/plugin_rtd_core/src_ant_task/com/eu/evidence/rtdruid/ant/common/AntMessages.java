/*
 * Created on 17-giu-2004
 *
 * $Id: AntMessages.java,v 1.2 2007/07/18 07:12:34 durin Exp $
 */
package com.eu.evidence.rtdruid.ant.common;


import java.util.Properties;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;

import com.eu.evidence.rtdruid.desk.Messages;

/**
 * @author Nicola Serreli
 *
 * This class send messages to ant output
 */
public class AntMessages extends Messages {
	private Task parent;
	
	public AntMessages(Task antTask) {
		parent = antTask;
	}

	private static boolean DETAILED = false;//true;

	/* (non-Javadoc)
	 * @see rtdruid.desk.Messages#output(int, java.lang.String, java.lang.String, java.lang.String, java.util.Properties)
	 */
	protected void output(int type, String text, String detailedText,
			String errorCode, Properties otherInfo) {
		
		String t;
		if (DETAILED) {
			t = detailedText + 
				( errorCode != null ? ( errorCode.length() != 0 ? "\nCode = " +errorCode : "" ) : "" ) + 
				(otherInfo != null ? (otherInfo.size() != 0 ? "\n" + otherInfo : "" ) : "");
			
		} else {
			t = text;
		}

		switch (type) {
				case OUTPUT :
				case OUTPUT | AUTO_NL:
							parent.log(t);
							break;
						
				case WARNING :
				case WARNING | AUTO_NL:
							parent.log("WARNING > " + t, Project.MSG_WARN);
							break;

				case DEBUG :
				case DEBUG | AUTO_NL:
							parent.log("DEBUG > " + t, Project.MSG_DEBUG);
							break;

				case ERROR :
				case ERROR | AUTO_NL:
				default :
							parent.log("ERROR > " + t, Project.MSG_ERR);
							break;
			}

	}

}
