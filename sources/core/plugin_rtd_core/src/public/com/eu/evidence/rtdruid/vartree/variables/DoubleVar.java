package com.eu.evidence.rtdruid.vartree.variables;

import com.eu.evidence.rtdruid.vartree.IVariable;

/** This class implements a "double" number
*
*	@see rtdruid.vartree.variables.IVariable
*
*@author Nicola Serreli
*/
public class DoubleVar extends ObjectVar {

	public DoubleVar() {}
	
	public DoubleVar(String value) {
		set(value);
	}

	/**	This method is a frontend to default constructor
	*
	*	@return a new instance of this DoubleVar
	*/
	public IVariable instance() {
		return new DoubleVar();
	}

// ----------------------   SET & GET   ----------------------
	
	/**	Sets the value of this IVariable
	*
	*	@param	value	the datum (it can be null)
	*/
	public void set(Double value) {
		super.value = value;
	}

	/**	Sets the value of this IVariable
	*
	*	@param	value	the datum (it can be null)
	*
	*	@throws	NumberFormatException	if the given String isn't a number.
	*/
	public void set(String value) {
		set ( value == null ? (Double) null : Double.valueOf(value) );
	}

}

