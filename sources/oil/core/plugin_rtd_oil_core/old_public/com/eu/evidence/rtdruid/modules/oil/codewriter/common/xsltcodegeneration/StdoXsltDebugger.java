package com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration;

import java.io.ByteArrayOutputStream;

import org.w3c.dom.Document;

public class StdoXsltDebugger implements IXsltDebugger {

	public void log(String txt) {
		System.out.println(txt);
	}

	public void log(XsltComponent transformation, Document input,
			Document output) {
		if (output != null) {
			ByteArrayOutputStream outBuff = new ByteArrayOutputStream();
			XsltUtils.writeXml(output, outBuff);
			System.out.println(outBuff.toString());
		}
	}

	public void logError(String txt) {
		log(txt);

	}

	public void logWarning(String txt) {
		log(txt);
	}

}
