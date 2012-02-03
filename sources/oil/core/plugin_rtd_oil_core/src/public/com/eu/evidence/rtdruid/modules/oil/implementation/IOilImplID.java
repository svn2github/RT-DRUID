package com.eu.evidence.rtdruid.modules.oil.implementation;

public interface IOilImplID extends Cloneable, Comparable<IOilImplID> {

	/**
	 * Returns the Implementation Name
	 * 
	 * @return the implementation name
	 */
	public String getImplementationName();

	/**
	 * Construct a new copy of this IOilImplID.
	 * 
	 */
	public IOilImplID clone();
}