package com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration;

import org.w3c.dom.Document;


public interface IXsltDebugger {
	
	void log(String txt);
	void logError(String txt);
	void logWarning(String txt);

	void log(XsltComponent transformation, Document input, Document output);
}
