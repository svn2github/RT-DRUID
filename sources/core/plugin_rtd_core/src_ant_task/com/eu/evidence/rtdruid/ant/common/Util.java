/*
 * Created on 9-giu-2004
 */
package com.eu.evidence.rtdruid.ant.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.tools.ant.BuildException;
import org.eclipse.emf.common.util.URI;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.io.IVTResource;
import com.eu.evidence.rtdruid.io.RTD_XMI_Factory;

/**
 * @author ni
 *
 */
public class Util {
	
	public static IVTResource loadData(String fileName) {

		//String tmp = "file://" + fileName;
	    IVTResource res = (IVTResource) new RTD_XMI_Factory().createResource(URI.createFileURI(fileName));
		try {
			res.setLoadHandler(new ErrorHandler() {
				public void error(SAXParseException e) throws SAXException {
					Messages.sendErrorNl("syntax error at line " + e.getLineNumber() 
							+ " : " + e.getMessage()+ " \n",null,"", new Properties());
				}

				public void fatalError(SAXParseException e) throws SAXException {
					Messages.sendErrorNl("fatal error at line " + e.getLineNumber()
							+ " : " + e.getMessage() + " \n",null,"", new Properties());
				}

				public void warning(SAXParseException e) throws SAXException {
					Messages.sendWarningNl("syntax warning at line " + e.getLineNumber() 
							+ " : " + e.getMessage()+" \n",null,"", new Properties());
				}

			});
			res.load(new HashMap());
		} catch (IOException e) {
			throw new BuildException(e.getMessage());
		}
		
		return res;
	}

}
