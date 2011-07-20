package com.eu.evidence.rtdruid.vartree.variables;

import com.eu.evidence.rtdruid.vartree.IVariable;

/** This class implements a "Float" multivalues variable.
*
*	@see com.eu.evidence.rtdruid.vartree.IVariable
*
*@author Nicola Serreli
*/
public class FloatMVar extends MultiValues {

	/**	Default constructor
	*/
	public FloatMVar() {}

	/**	This method is a frontend to default constructor
	*
	*	@return a new instance of this FloatMVar
	*/
	public IVariable instance() {
		return new FloatMVar();
	}

	/** Convert a string into a Float (return null for a null value)
	 */
	protected Object convert(String value) {
		return value == null ? null : Float.valueOf(value);
	}
}

