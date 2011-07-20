package com.eu.evidence.rtdruid.vartree.variables;

import com.eu.evidence.rtdruid.vartree.IVariable;

/** This class implements a "String" variable.
*
*	@see com.eu.evidence.rtdruid.vartree.IVariable
*
*@author Nicola Serreli
*/
public class StringMVar extends MultiValues {

	/**	Default constructor
	*/
	public StringMVar() {}

	/**	This method is a frontend to default constructor
	*
	*	@return a new instance of this StringMVar
	*/
	public IVariable instance() {
		return new StringMVar();
	}

	/** Convert a string into a boolean (return null for a null value)
	 */
	protected Object convert(String value) {
		return value;
	}
}

