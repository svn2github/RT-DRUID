package com.eu.evidence.rtdruid.vartree.variables;

import com.eu.evidence.rtdruid.vartree.IVariable;

/** This class implements a "Long" multivalues variable.
*
*	@see com.eu.evidence.rtdruid.vartree.IVariable
*
*@author Nicola Serreli
*/
public class LongMVar extends MultiValues {

	/**	Default constructor
	*/
	public LongMVar() { }

	/**	This method is a frontend to default constructor
	*
	*	@return a new instance of this LongMVar
	*/
	public IVariable instance() {
		return new LongMVar();
	}

	/** Convert a string into a Long (return null for a null value)
	 */
	protected Object convert(String value) {
		return value == null ? null : Long.valueOf(value);
	}
}

