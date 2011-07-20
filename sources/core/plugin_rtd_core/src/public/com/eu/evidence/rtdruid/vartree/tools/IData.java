/*
 * Created on 26/set/07
 *
 * $Id: IData.java,v 1.2 2007/10/03 10:17:33 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.tools;

public interface IData extends Cloneable {

	/** @return the proc's name */
	public String getName();

	/** @return the location of this proc inside the VarTree */
	public String getVtPath();
	
	/** @return the mapping to the cpu (or null if none) */
	public String getCpuID();
	
	public Object clone();
}