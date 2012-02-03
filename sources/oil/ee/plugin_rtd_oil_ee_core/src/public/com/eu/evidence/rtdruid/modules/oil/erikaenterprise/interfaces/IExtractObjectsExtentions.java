/**
 * 
 */
package com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces;

import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.modules.oil.interfaces.ISectionWriter;

public interface IExtractObjectsExtentions extends ISectionWriter {
	void updateObjects() throws OilCodeWriterException;
}