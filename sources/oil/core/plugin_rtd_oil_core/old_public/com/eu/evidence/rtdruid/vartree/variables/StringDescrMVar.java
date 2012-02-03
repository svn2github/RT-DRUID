/*
 * Created on Sep 30, 2004
 *
 * $Id: StringDescrMVar.java,v 1.2 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.variables;


import com.eu.evidence.rtdruid.vartree.IVariable;

/**
 * @author Nicola Serreli
 */
public class StringDescrMVar extends MultiValues {

	/**	Default constructor
	*/
	public StringDescrMVar() {}

	/**	This method is a frontend to default constructor
	*
	*	@return a new instance of this LongMVar
	*/
	public IVariable instance() {
		return new StringDescrMVar();
	}

	/** Convert a string into a String with a (empty) description (return null for a null value)
	 */
	protected Object convert(String value) {
		return value == null ? null : value;
	}
}
