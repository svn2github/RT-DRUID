package com.eu.evidence.rtdruid.modules.oil.interfaces;

public interface IReferenceRes {

	public void addReference(String key, Object obj);

	public Object getReference(String key);

	/**
	 * Identify the refered List of Objects
	 * 
	 * @return Array of names
	 */
	public String[] getReferenceGenRes(String property);

}