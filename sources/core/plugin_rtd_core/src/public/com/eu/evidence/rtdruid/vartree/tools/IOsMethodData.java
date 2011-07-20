/*
 * Created on 08/set/10
 *
 * $Id: IProcData.java,v 1.1 2007/09/28 11:15:40 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.tools;

public interface IOsMethodData extends IData {

	/**
	 * @param cpu
	 *            the cpu where this method is executed or null if the method's owner is not
	 *            mapped
	 * 
	 */
	void setCpuID(String cpu);

	/**
	 * @return the cpu where this method is executed (if any, otherwise returns
	 *         null)
	 */
	String getCpuID();

	/** @return the full name of this method (osname/method_name) */
	String getFullName();

}
