package com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration;

import org.w3c.dom.Document;

/**
 * This is the standard interface used by XsltWriterTransfFactory 
 * to produce transformations used during the code generation done by
 * a xslt writer   
 * 
 * 
 *
 */
public interface IXsltWriterTransformation {

	/**
	 * @return the identifier of this transformation
	 */
	String getId();
	
	/**
	 * This method converts a document into a new one.
	 * the passed document is not modified. 
	 * 
	 * @param doc input document
	 * 
	 * @return a new document that is the result of the transformation of the original document
	 */
	Document transform(Document doc);
}
