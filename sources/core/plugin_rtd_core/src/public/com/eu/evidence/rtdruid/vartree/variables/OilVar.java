/*
 * Created on May 5, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.eu.evidence.rtdruid.vartree.variables;

import com.eu.evidence.rtdruid.vartree.IVariable;

/**
 * @author durin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class OilVar extends StringVar {

	public OilVar() {}
	
	public OilVar(String value) {
		super(value);
	}
	
	/**	This method is a frontend to default constructor
	*
	*	@return a new instance of this OilVar
	*/
	public IVariable instance() {
		return new OilVar();
	}
}
