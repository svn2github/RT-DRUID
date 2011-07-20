package com.eu.evidence.rtdruid.vartree.variables;

import java.util.ArrayList;
import java.util.Iterator;

import com.eu.evidence.rtdruid.vartree.IMultiValues;
import com.eu.evidence.rtdruid.vartree.IVariable;


/**	This interface is used to define IVariable with more than one value.
*
*	@see	com.eu.evidence.rtdruid.internal.vartree.VariableFactory VariableFactory
*
*@author Nicola Serreli
*/
public abstract class MultiValues implements IVariable, IMultiValues {

	/** The datum */
	protected ArrayList valore;
	
//	 ----------------------   CONSTRUCTOR   ----------------------

	/**	Default constructor
	*/
	public MultiValues() {
		valore = new ArrayList();
	}

	/**	This method is a frontend to default constructor
	*
	*	@return a new instance
	*/
	public abstract IVariable instance();

	/**	Makes a indipendent copy of this MultiValues IVariable
	*
	*	@return a copy of this MultiValues IVariable
	*/
	public Object clone() {
		MultiValues answer = (MultiValues) instance();
		answer.valore = (ArrayList) valore.clone();
		return answer;
	}

	/**	Destroys all data in this variable.
	*/
	public void dispose() {
		valore = null;
	}
	
//	 ----------------------   SET & GET   ----------------------

	/**	<b>Clears</b> all data and sets the given value as unique value of this IVariable.
	*	A null value, clear all data.
	*
	*	@param	value	the datum.
	*/
	public void set(String value) {
		if (value == null) {
			valore.clear();
			return;
		}
		
		Object tmp = convert(value);

		valore.clear();
		valore.add(tmp);
	}

	/**	Gets the value of this IVariable.
	 *  It's a ArrayList of objects and could be null.
	 * 
	 * @return the datum, or null if no one is set
	*/
	public Object get() {
		return valore == null ? null : valore.clone();
	}
	
	/**	Returns a string that contains the data stored in this MultiValues IVariable
	*
	*	@return a string that contains the data stored in this MultiValues IVariable 
	*/
	public String toString() {
		StringBuffer sb = new StringBuffer("[");
		String pre = "";
		for (int i =0; i< valore.size(); i++) {
			sb.append(pre + valore.get(i));
			pre = ", ";
		}
		sb.append("]");
		return sb.toString();
	}

//	 ----------------------   Multi Values   ----------------------
	
	/**	 Appends a Value at last position.
	*
	*	@param	value a new value (Not null)
	*
	*	@throws NullPointerException	if value is null
	*/
	public void appendValue(String value) throws NotValidValueException{
		if ( value == null ) {
			throw new NullPointerException(getClass().getName() + ": Append a null value.\n");
		}
		valore.add(convert(value));
	}

	/**	Returns all stored values
	*
	*	@return		all values.
	*/
	public String[] getValues() {
		String[] tmp = new String[valore.size()];
		
		Iterator iter = valore.iterator();
		int i=0;
		while (iter.hasNext()) {
			tmp[i++] = "" + iter.next();
		}
		return tmp;
	}
	
	/**	 Returns only the value in the given position.
	*
	*	@param	index	the position of request data in the internal list
	*
	*	@return	the value stored in the given position
	*
	*	@throws IndexOutOfBoundsException if index is negative or is larger than the size of internal list.
	*/
	public String getValues(int index) {
		if (index <0 || index >= valore.size())
			throw new IndexOutOfBoundsException(getClass().getName() + ": illegal index.\n");

		return "" + valore.get(index);
	}

	/**	 Clears internal list and stores all given values.
	*
	*	@param	valuesList a list of new values
	*
	*	@throws NullPointerException	if valuesList is null or one value is null
	*/
	public void setValues(String[] valuesList) {
		// clear all
		if ( valuesList == null) {
			throw new NullPointerException(getClass().getName() + ": try to set a null list of values.");
		}
		
		// first check
		ArrayList tmpList = new ArrayList();
		for (int i=0; i<valuesList.length; i++) {
			if (valuesList[i] == null)
				throw new NullPointerException(getClass().getName() + ": try to set a null value");

			tmpList.add( convert(valuesList[i]) );
		}
		
		// all ok
		valore = tmpList;
	}
	
	/** Changes the value stored in the given position.
	*
	*	@param	value  a new value
	*	@param	index	the position of request data in the internal list
	*
	*	@throws IndexOutOfBoundsException if index is negative or is larger than the size of internal list.
	*	@throws NullPointerException	if value is null
	*/
	public void setValue(String value, int index) throws NotValidValueException{
		if (value == null)
			throw new NullPointerException(getClass().getName() + ": try to set a null value in the internal list");
		
		if (index <0 || index >= valore.size())
			throw new IndexOutOfBoundsException(getClass().getName() + ": illegal index");

		valore.set(index, convert(value));
	}

	
	/**	Returns the size of internal list
	*
	*	@return size of internal list 
	*/
	public int sizeValues() {
		return valore.size();
	}
	
	/**	Removes all stored data.
	*/
	public void clearValues() {
		valore.clear();
	}
	
	/**	Removes the element at the specified position in this list.
	*	Shifts any subsequent elements to the left (subtracts one from their indices). 
	*
	*	@param	index	the position of datum to drop
	*
	*	@throws IndexOutOfBoundsException if index is negative or is larger than the size of internal list.
	*/
	public void removeValue(int index) {
		if (index <0 || index >= valore.size())
			throw new IndexOutOfBoundsException(getClass().getName() + ": illegal index");

		valore.remove(index);
	}

	/**
	 * Convert a String to the correct type 
	 */
	protected abstract Object convert(String value);

	
	public boolean equals(Object o) {
		if (o instanceof IMultiValues) {
			ArrayList oList = ((MultiValues) o).valore;

			if (valore == null && oList == null) { 
				return true;
			}
			
			if (valore == null || oList == null || valore.size() != oList.size()) {
				return false;
			}
			
			boolean ok = true;
			for (int i=0; i<valore.size() && ok; i++) {
				ok = valore.get(i).equals(oList.get(i));
			}
			return ok;
		}
		
		return false;

	}
}

