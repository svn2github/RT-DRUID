/**
 * 
 */
package com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces;

import java.util.ArrayList;

import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.modules.oil.interfaces.ISectionWriter;

public interface IExtractKeywordsExtentions extends ISectionWriter {
	/**
	 * This method add new keywords or remove old keywords.
	 * 
	 * Be carefull when remove a keyword.
	 * */
	void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix) throws OilCodeWriterException;
}