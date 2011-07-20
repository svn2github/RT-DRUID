/*
 * Created on 20/set/07
 *
 * $Id: IProcData.java,v 1.1 2007/09/28 11:15:40 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.tools;

public interface IProcData extends IData {

	/**
	 * @param cpu
	 *            the cpu where this proc is mapped or null if this proc is not
	 *            mapped
	 * 
	 */
	void setCpuID(String cpu);

	/**
	 * @param task
	 *            the task where this proc is mapped or null if this proc is not
	 *            mapped
	 */
	void setTask(String task);

	/**
	 * @return the cpu where this proc is mapped (if any, otherwise returns
	 *         null)
	 */
	String getCpuID();

	/**
	 * @return the task where this proc is mapped (if any, otherwise returns
	 *         null)
	 */
	String getTask();

	/** @return the full name of this proc (Subsystem/.../name) */
	String getFullName();

}
