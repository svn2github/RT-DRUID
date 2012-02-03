package com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * This class can be used to collect together many parameter providers. Note
 * that there isn't any check about collision among providers, and if there is
 * more than one parameter with the same id, the first one is the one returned.
 * 
 * @author Nicola Serreli
 * 
 */
public class ComposedXsltParameterProvider implements IXsltParameterProvider {

	private ArrayList<IXsltParameterProvider> providers = new ArrayList<IXsltParameterProvider>();

	protected HashMap<String, Object> options = new HashMap<String, Object>();

	/**
	 * Add some options
	 */
	public void setOptions(Map<String, Object> options) {
		if (options != null) {
			this.options.clear();
			this.options.putAll(options);
			for (IXsltParameterProvider pp: providers) {
				pp.setOptions(options);
			}
		}
	}
	
	/**
	 * Add a new parameter provider.
	 * 
	 * @param provider
	 */
	public void add(IXsltParameterProvider provider) {
		if (provider != null && !providers.contains(provider)) {
			providers.add(provider);
			provider.setOptions(options);
		}
	}

	/**
	 * Remove the specified parameter provider
	 * 
	 * @param ID
	 */
	public void remove(IXsltParameterProvider provider) {
		providers.remove(provider);
	}

	/**
	 * @return all paramter providers stored here
	 */
	public IXsltParameterProvider[] getAllProvider() {
		return providers.toArray(new IXsltParameterProvider[providers.size()]);
	}

	@Override
	public IXsltParameter[] getAll() {
		ArrayList<IXsltParameter> answer = new ArrayList<IXsltParameter>();
		for (IXsltParameterProvider p : providers) {
			answer.addAll(Arrays.asList(p.getAll()));
		}
		return answer.toArray(new IXsltParameter[answer.size()]);
	}

	@Override
	public Map<String, IXsltParameter> getAllAsMap() {
		LinkedHashMap<String, IXsltParameter> answer = new LinkedHashMap<String, IXsltParameter>();
		for (int i = providers.size() - 1; i >= 0; i--) {
			answer.putAll(providers.get(i).getAllAsMap());
		}
		return answer;
	}

	@Override
	public String[] getAvailableIDs() {
		LinkedHashSet<String> answer = new LinkedHashSet<String>();
		for (IXsltParameterProvider p : providers) {
			answer.addAll(Arrays.asList(p.getAvailableIDs()));
		}
		return answer.toArray(new String[answer.size()]);
	}

	@Override
	public IXsltParameter getParameter(String ID) {
		IXsltParameter answer = null;
		for (IXsltParameterProvider p : providers) {
			answer = p.getParameter(ID);
			if (answer != null) {
				return answer;
			}
		}
		return null;
	}
}
