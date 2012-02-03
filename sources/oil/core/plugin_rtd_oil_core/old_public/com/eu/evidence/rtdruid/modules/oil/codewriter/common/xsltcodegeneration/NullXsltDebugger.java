package com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration;

import org.w3c.dom.Document;

public class NullXsltDebugger implements IXsltDebugger {

	public void log(String txt) {
		// null
	}

	public void log(XsltComponent transformation, Document input,
			Document output) {
		// null
	}

	public void logError(String txt) {
		// null

	}

	public void logWarning(String txt) {
		// null

	}

}
