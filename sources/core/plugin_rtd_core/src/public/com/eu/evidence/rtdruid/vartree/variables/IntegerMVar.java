package com.eu.evidence.rtdruid.vartree.variables;

import com.eu.evidence.rtdruid.vartree.IVariable;

/** This class implements a "Integer" multivalues variable.
*
*	@see com.eu.evidence.rtdruid.vartree.IVariable
*
*@author Nicola Serreli
*/
public class IntegerMVar extends MultiValues {

	/**	Default constructor
	*/
	public IntegerMVar() { }

	/**	This method is a frontend to default constructor
	*
	*	@return a new instance of this IntegerMVar
	*/
	public IVariable instance() {
		return new IntegerMVar();
	}

	/** Convert a string into a Integer (return null for a null value)
	 */
	protected Object convert(String value) {
		return value == null ? null : Integer.valueOf(value);
	}
}

