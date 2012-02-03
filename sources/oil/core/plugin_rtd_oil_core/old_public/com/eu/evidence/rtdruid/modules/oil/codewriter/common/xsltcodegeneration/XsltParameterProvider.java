package com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A simple parameter provider
 * 
 * @author Nicola Serreli
 * 
 */
public class XsltParameterProvider implements IXsltParameterProvider {
	
	protected HashMap<String, Object> options = new HashMap<String, Object>();

	private LinkedHashMap<String, IXsltParameter> parameters = new LinkedHashMap<String, IXsltParameter>();

	/**
	 * Add some options
	 */
	public void setOptions(Map<String, Object> options) {
		if (options != null) {
			this.options.clear();
			this.options.putAll(options);
		}
	}
	
	/**
	 * Add a new parameter. If there is already a parameter with the same ID; it
	 * is replaced
	 * 
	 * @param parameter
	 *            cannot be null
	 */
	public void set(IXsltParameter parameter) {
		parameters.put(parameter.getID(), parameter);
	}

	/**
	 * Remove the specified parameter
	 * 
	 * @param ID
	 *            cannot be null
	 */
	public void unset(String ID) {
		parameters.remove(ID);
	}

	@Override
	public IXsltParameter[] getAll() {
		return parameters.values().toArray(
				new IXsltParameter[parameters.size()]);
	}
	
	@Override
	public Map<String, IXsltParameter> getAllAsMap() {
		return new LinkedHashMap<String, IXsltParameter>(parameters);
	}

	@Override
	public String[] getAvailableIDs() {
		return parameters.keySet().toArray(new String[parameters.size()]);
	}

	@Override
	public IXsltParameter getParameter(String ID) {
		return parameters.get(ID);
	}

	
}
