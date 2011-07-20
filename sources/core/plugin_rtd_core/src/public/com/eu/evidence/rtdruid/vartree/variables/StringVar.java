package com.eu.evidence.rtdruid.vartree.variables;

import com.eu.evidence.rtdruid.vartree.IVariable;

/** This class implements a "String" variable.
*
*	@see rtdruid.vartree.variables.IVariable
*
*@author Nicola Serreli
*/
public class StringVar extends ObjectVar {

	public StringVar() {}

	public StringVar(String value) {
		super.value = value;
	}

	/**	This method is a frontend to default constructor
	*
	*	@return a new instance of this StringVar
	*/
	public IVariable instance() {
		return new StringVar();
	}

// ----------------------   SET & GET   ----------------------
	
	/**	Sets the value of this IVariable
	*
	*	@param	value	the datum (it can be null)
	*/
	public void set(String value) {
		super.value = value;
	}
}

