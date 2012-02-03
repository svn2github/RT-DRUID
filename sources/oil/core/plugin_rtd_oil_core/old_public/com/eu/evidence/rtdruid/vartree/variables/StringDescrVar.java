/*
 * Created on Sep 30, 2004
 *
 * $Id: StringDescrVar.java,v 1.3 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.variables;


import com.eu.evidence.rtdruid.vartree.IVariable;

/**
 * @author Nicola Serreli
 */
public class StringDescrVar extends StringVar {
	public StringDescrVar() {}

	public StringDescrVar(String value) {
		super.value = value;
	}
	
	/**	This method is a frontend to default constructor
	*
	*	@return a new instance of this StringVar
	*/
	public IVariable instance() {
		return new StringDescrVar();
	}
}
