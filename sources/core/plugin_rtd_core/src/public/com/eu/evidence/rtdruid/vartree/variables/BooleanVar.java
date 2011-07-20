package com.eu.evidence.rtdruid.vartree.variables;

import com.eu.evidence.rtdruid.vartree.IVariable;


/** This class implements a "boolean" IVariable.
*
*	@see rtdruid.vartree.variables.IVariable
*
*@author Nicola Serreli
*/
public class BooleanVar extends ObjectVar {
	
	public BooleanVar() {}
	
	public BooleanVar(String value) {
		set(value);
	}
	
	/**	This method is a frontend to default constructor
	*
	*	@return a new instance of this BooleanVar
	*/
	public IVariable instance() {
		return new BooleanVar();
	}
	
// ----------------------   SET & GET   ----------------------
	
	/**	Sets the value of this IVariable
	*
	*	@param	value	the datum
	*/
	public void set(boolean value) { super.value = Boolean.valueOf(value); }

	/**	Sets the value of this IVariable
	*
	*	@param	value	the datum: only "true"  means true (case insensitive); all other values means false.
	*/
	public void set(String value) {
		super.value = value == null ? (Boolean) null : Boolean.valueOf(value);
	}

}

