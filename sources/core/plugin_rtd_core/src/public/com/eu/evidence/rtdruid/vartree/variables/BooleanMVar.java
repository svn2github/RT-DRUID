package com.eu.evidence.rtdruid.vartree.variables;

import com.eu.evidence.rtdruid.vartree.IVariable;

/** This class implements a "Boolean" multiValues variable.
*
*	@see com.eu.evidence.rtdruid.vartree.IVariable
*
*@author Nicola Serreli
*/
public class BooleanMVar extends MultiValues {

// ----------------------   CONSTRUCTOR   ----------------------

	/**	Default constructor
	*/
	public BooleanMVar() {}

	/**	This method is a frontend to default constructor
	*
	*	@return a new instance of this BooleanMVar
	*/
	public IVariable instance() {
		return new BooleanMVar();
	}
	
	/** Convert a string into a boolean (return null for a null value)
	 */
	protected Object convert(String value) {
		return value == null ? null : Boolean.valueOf(value);
	}
}

