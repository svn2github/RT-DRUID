/*
 * Created on 18-giu-2004
 *
 * $Id: EclipseViewMessages.java,v 1.2 2007/07/18 07:12:34 durin Exp $
 */
package com.eu.evidence.rtdruid.ui.common;

import java.util.Properties;

import com.eu.evidence.rtdruid.desk.Messages;


/**
 * @author Nicola Serreli
 *
 * This class send messages to ant output
 */
class EclipseViewMessages extends Messages {
	private IRtdruidOutputView outputView;
	
	public EclipseViewMessages(IRtdruidOutputView view) {
		if (view == null) {
			throw new NullPointerException("Required a not null RT-Druid viewer");
		}
		outputView = view;
	}
	
	private static boolean DETAILED = false; //true;

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
							print(t);
							break;
				case OUTPUT | AUTO_NL:
							printNl(t);
							break;
						
				case WARNING :
							print("WARNING > " + t);
							break;
				case WARNING | AUTO_NL:
							printNl("WARNING > " + t);
							break;

				case DEBUG :
							print("DEBUG > " + t);
							break;
				case DEBUG | AUTO_NL:
							printNl("DEBUG > " + t);
							break;

				case ERROR :
							print(text);
							break;
				case ERROR | AUTO_NL:
				default :
							printNl("ERROR > " + text);
							break;
			}
	}

	private void print(String message) {
		outputView.appendMessage(message);
	}
	private void printNl(String message) {
		outputView.appendMessage(message+"\n");
	}
	

}
