/*
 * Created on May 6, 2004
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
public abstract class ObjectVar implements IVariable {

	protected Object value;

	protected ObjectVar() {
		value = null;
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.variables.IVariable#instance()
	 */
	abstract public IVariable instance();

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		ObjectVar answer = (ObjectVar) instance();
		answer.value = value; 
		return answer;
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.variables.IVariable#dispose()
	 */
	public void dispose() {
		value = null;
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.variables.IVariable#set(java.lang.String)
	 */
	abstract public void set(String value);

	/* (non-Javadoc)
	 * @see rtdruid.vartree.variables.IVariable#get()
	 */
	public Object get() {
		return value;
	}
	
	public String toString() {
		return value == null ? "null" : value.toString();
	}
	
	@Override
	public int hashCode() {
		return value == null ? 0 : value.hashCode();
	}
	
	public boolean equals(Object o) {
		if (o instanceof ObjectVar) {
			return this.value == null ? 
					( (ObjectVar) o).value == null :
					this.value.equals(( (ObjectVar) o).value);
		}
		
		return false;
	}

}
