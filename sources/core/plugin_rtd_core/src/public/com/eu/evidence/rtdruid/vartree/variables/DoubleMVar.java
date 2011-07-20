package com.eu.evidence.rtdruid.vartree.variables;

import com.eu.evidence.rtdruid.vartree.IVariable;

/** This class implements a "Double" multivalues variable.
*
*	@see com.eu.evidence.rtdruid.vartree.IVariable
*
*@author Nicola Serreli
*/
public class DoubleMVar extends MultiValues {

// ----------------------   CONSTRUCTOR   ----------------------

	/**	Default constructor
	*/
	public DoubleMVar() {}

	/**	This method is a frontend to default constructor
	*
	*	@return a new instance of this DoubleMVar
	*/
	public IVariable instance() {
		return new DoubleMVar();
	}

	/** Convert a string into a Double (return null for a null value)
	 */
	protected Object convert(String value) {
		return value == null ? null : Double.valueOf(value);
	}
}

