package com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration;

import java.util.Map;

public interface IXsltParameterProvider {

	/**
	 * 
	 * @return all available parameters
	 */
	Map<String, IXsltParameter> getAllAsMap();

	/**
	 * 
	 * @return all available parameters
	 */
	IXsltParameter[] getAll();

	/**
	 * 
	 * @return all ID supported by this Provider
	 */
	String[] getAvailableIDs();

	/**
	 * 
	 * @param ID
	 *            identifies a specific parameter
	 * @return the parameter identified by given ID or return null if this
	 *         Provider doesn't support the required parameter.
	 */
	IXsltParameter getParameter(String ID);
}
