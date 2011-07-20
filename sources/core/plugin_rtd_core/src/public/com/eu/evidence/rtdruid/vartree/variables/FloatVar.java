package com.eu.evidence.rtdruid.vartree.variables;

import com.eu.evidence.rtdruid.vartree.IVariable;


/** This class implements a "float" number
*
*	@see rtdruid.vartree.variables.IVariable
*
*@author Nicola Serreli
*/
public class FloatVar extends ObjectVar {

	public FloatVar() {}
	
	public FloatVar(String value) {
		set(value);
	}
	
	/**	This method is a frontend to default constructor
	*
	*	@return a new instance of this FloarVar
	*/
	public IVariable instance() {
		return new FloatVar();
	}

// ----------------------   SET & GET   ----------------------
	
	/**	Sets the value of this IVariable
	*
	*	@param	value	the datum (it can be null)
	*/
	public void set(Float value) {
		super.value = value;
	}

	/**	Sets the value of this IVariable
	*
	*	@param	value	the datum (it can be null)
	*
	*	@throws NotValidValueException
	*	@throws	NumberFormatException	if the given String isn't a number.
	*/
	public void set(String value) throws NotValidValueException {
		set( value == null ? (Float) null : Float.valueOf(value) );
	}
	
}

