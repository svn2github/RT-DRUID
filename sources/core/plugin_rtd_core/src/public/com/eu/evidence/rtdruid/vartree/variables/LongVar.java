package com.eu.evidence.rtdruid.vartree.variables;

import com.eu.evidence.rtdruid.vartree.IVariable;

/** This class implements a "long" number
*
*	@see rtdruid.vartree.variables.IVariable
*
*@author Nicola Serreli
*/
public class LongVar extends ObjectVar {

	public LongVar() {}
	
	public LongVar(String value) {
		set(value);
	}
	
	/**	This method is a frontend to default constructor
	*
	*	@return a new instance of this FloarVar
	*/
	public IVariable instance() {
		return new LongVar();
	}

// ----------------------   SET & GET   ----------------------
	
	/**	Sets the value of this IVariable
	*
	*	@param	value	the datum (it can be null)
	*/
	public void set(Long value) {
		super.value = value;
	}

	/**	Sets the value of this IVariable.  Accepts decimal, hexadecimal, and octal numbers given by the grammar
	*	specified in java.lang.Long.decode.
	*
	*	@param	value	the datum (it can be null)
	*
	*	@throws NotValidValueException
	*	@throws	NumberFormatException	if the given String isn't a number.
	*/
	public void set(String value) throws NotValidValueException {
		set( value == null ? (Long) null : Long.decode(value) );
	}

}

