/*
 * Created on Aug 27, 2004
 *
 * $Id: ExtendVar.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.data;

/**
 * @author Nicola Serreli
 */
public interface ExtendVar {
	/**
	 * Creates a new instance of a var and init it with given string
	 * */
	Object createFromString(String initialValue);
	
	/**
	 * Returns a string rapresentation of data stored inside this instance value.
	 * <br> This method returns null if the object is null or if it doesn't contains something.
	 */
	String convertToString(Object instanceValue); 
}
