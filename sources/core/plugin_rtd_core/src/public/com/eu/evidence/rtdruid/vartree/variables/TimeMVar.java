package com.eu.evidence.rtdruid.vartree.variables;

import java.util.Iterator;

import com.eu.evidence.rtdruid.vartree.IVariable;

/**
 *  This class implements a "Time" multivalues object : &lt;double number&gt;&lt;symbol of time's unit&gt;
 *  <br>For time's unit see {@link TimeVar TimeVar}. 
*
*	@see com.eu.evidence.rtdruid.vartree.IVariable
*
*@author Nicola Serreli
*/
public class TimeMVar extends DoubleMVar {
	
	private int type;

// ----------------------   COSTRUTTORE   ----------------------

	/**	Default constructor
	*/
	public TimeMVar() {
		super();
		type = TimeVar.MILLI_SECOND;
	}

	/**	This method is a frontend to default constructor
	*
	*	@return a new instance of this TimeMVar
	*/
	public IVariable instance() {
		return new TimeMVar();
	}

	/**	Makes a indipendent copy of this TimeMVar
	*
	*	@return a copy of this TimeMVar
	*/
	public Object clone() {
		TimeMVar risp = (TimeMVar) super.clone();
		risp.type = type;
		return risp;
	}

	/**	Destroys all data in this TimeMVar.
	*/
	public void dispose() {
		super.dispose();
		type = TimeVar.MILLI_SECOND;
	}
	
// ----------------------   SET & GET   ----------------------
	
	/**	<b>Clears</b> all data and sets the given value as unique value of this IVariable.
	*	A null value, clear all data. <br> (number[time's unit])
	*
	*	@param	value	the datum (it can be null)
	*
	*	@throws	NumberFormatException	if the given String isn't a number (number[time's unit]).
	*/
	public void set(String value) {

		int tipo = type;
		// set to null void values 
		if (("").equals(value)) {
			value = null;
		}
		if (value != null ) {
			boolean ok = false;
			// start with symbols with 2 chars
			for (int i=TimeVar.SYMBOLS.length -1 ; i>=0 && (!ok); i--) {
				if (value.endsWith(TimeVar.SYMBOLS[i])) {
					tipo = i;
					// remove the symbol
					value = value.substring(0, value.length() - TimeVar.SYMBOLS[i].length());
					ok  = true;
				}
			}
		}

		// try to set value an then set type
		super.set(value);
		type = tipo;
	}
	
	/** Sets the time's unit .
	 * 
	 *   @param typeId one of constants defined above (hour, second, ...)
	 * 
	 *   @throws IllegalArgumentException if typeId isn't a valid time's unit  
	 */
	public void setType(int typeId) {
		if (typeId<0 || typeId>=TimeVar.SYMBOLS.length) {
			throw new IllegalArgumentException("Type id must be a valid ID");
		}
		double ratio = TimeVar.ratio(type, typeId);
		// adjust values
		if (valore != null) {
			for (int i=0; i<valore.size(); i++) {
				Double val = (Double) valore.get(i);
				if (val !=null) {
					valore.set(i, new Double(val.doubleValue() * ratio));
				}
			}
		}

		type = typeId;
	}
	
	/** Gets the time's unit ID.
	 */
	public int getType() {	return type;	}

	/** Gets the time's unit.
	 */
	public String getStringType() {	return TimeVar.SYMBOLS[type];	}
	
// ----------------------   CONVERSIONI   ----------------------
	
	/**	Returns a string that contains the data stored in this TimeMVar
	*
	*	@return a string that contains the data stored in this TimeMVar 
	*/
	public String toString() {
		StringBuffer sb = new StringBuffer("[");
		String pre = "";
		for (int i =0; i< valore.size(); i++) {
			Double tval = (Double) valore.get(i);
			String tmp = tval == null ? "" : tval.toString().equalsIgnoreCase("Infinity") ? "" : TimeVar.SYMBOLS[type];
			sb.append(pre + tval + tmp );
			pre = ", ";
		}
		sb.append("]");
		return sb.toString();
	}
	
	public boolean equals(Object o) {
		if (o instanceof TimeMVar) {
			return super.equals(o) && (this.type == ((TimeMVar) o).type );
		}
		return false;
	}

	
// ----------------------   Multi Values   ----------------------
	
	/**	 Appends a Value at last position.
	*
	*	@param	value a new value (Not null)
	*
	*	@throws NullPointerException	if value is null
	*  @throws NumberFormatException if value is a void value or not a number
	*/
	public void appendValue(String value) {
		if (value == null)
			throw new NullPointerException("TimeMVar: try to append a null value");

		if (("").equals(value))
			throw new NumberFormatException("TimeMVar: try to append a void value");

		int tipo = type;
		boolean ok = false;
		for (int i=0; i<TimeVar.SYMBOLS.length && (!ok); i++) {
			if (value.endsWith(TimeVar.SYMBOLS[i])) {
				tipo = i;
				// remove the symbol
				value = value.substring(0, value.length() - TimeVar.SYMBOLS.length);
				if (("").equals(value))
					throw new NumberFormatException("TimeMVar: try to append a void value");
				ok  = true;
			}
		}

		Double tmp = Double.valueOf(value);
		setType(tipo);
		
		valore.add(tmp);
	}

	/**	Returns all stored values (&lt;double number&gt;&lt;symbol of time's unit&gt;)
	*
	*	@return		all values.
	*/
	public Double[] getDoubleValues() {
		Double[] tmp = new Double[valore.size()];
		
		Iterator iter = valore.iterator();
		int i=0;
		while (iter.hasNext()) {
			tmp[i++] = (Double) iter.next();
		}
		return tmp;
	}
	
	/**	 Returns only the value in the given position (&lt;double number&gt;&lt;symbol of time's unit&gt;).
	*
	*	@param	index	the position of request data in the internal list
	*
	*	@return	the value stored in the given position
	*
	*	@throws IndexOutOfBoundsException if index is negative or is larger than the size of internal list.
	*/
	public Double getDoubleValues(int index) {
		if (index <0 || index >= valore.size())
			throw new IndexOutOfBoundsException("TimeMVar: illegal index");

		return (Double) valore.get(index);
	}
	
	/**	Returns all stored values (&lt;double number&gt;&lt;symbol of time's unit&gt;)
	*
	*	@return		all values.
	*/
	public String[] getValues() {
		String[] tmp = new String[valore.size()];
		
		Iterator iter = valore.iterator();
		int i=0;
		while (iter.hasNext()) {
			tmp[i++] = ((Double) iter.next() ).toString()+ TimeVar.SYMBOLS[type];
		}
		return tmp;
	}
	
	/**	 Returns only the value in the given position (&lt;double number&gt;&lt;symbol of time's unit&gt;).
	*
	*	@param	index	the position of request data in the internal list
	*
	*	@return	the value stored in the given position
	*
	*	@throws IndexOutOfBoundsException if index is negative or is larger than the size of internal list.
	*/
	public String getValues(int index) {
		if (index <0 || index >= valore.size())
			throw new IndexOutOfBoundsException("TimeMVar: illegal index");

		return ((Double) valore.get(index)).toString() + TimeVar.SYMBOLS[type];
	}
	

	/**	 Clears internal list and stores all given values.
	*
	*	@param	valuesList a list of new values
	*
	*	@throws NullPointerException	if valuesList is null or one value is null
	*	@throws NumberFormatException	if value is a void value or not a number
	*/
	public void setValues(String[] valuesList) {
		// clear all
		if ( valuesList == null) {
			throw new NullPointerException("TimeMVar: try to set a null list of values.");
		}
		for (int i=0; i<valuesList.length; i++) {
			if (valuesList[i] == null) {
				throw new NullPointerException("TimeMVar: try to set a null value");
			}
		}
		valore.clear();
		for (int i=0; i<valuesList.length; i++) {
			appendValue(valuesList[i]);
		}
	}
	
	/** Changes the value stored in the given position.
	*
	*	@param	value  a new value
	*	@param	index	the position of request data in the internal list
	*
	*	@throws IndexOutOfBoundsException if index is negative or is larger than the size of internal list.
	*	@throws NumberFormatException	if value is a void value or not a number
	*	@throws NullPointerException	if value is null
	*/
	public void setValue(String value, int index) {

		if (value == null ) {
			throw new NullPointerException("TimeMVar: try to append a null value");
		}
		if (index <0 || index >= valore.size())
			throw new IndexOutOfBoundsException("TimeMVar: illegal index");

		int tipo = type;
		boolean ok = false;
		for (int i=0; i<TimeVar.SYMBOLS.length && (!ok); i++) {
			if (value.endsWith(TimeVar.SYMBOLS[i])) {
				tipo = i;
				// remove the symbol
				value = value.substring(0, value.length() - TimeVar.SYMBOLS.length);
				ok  = true;
			}
		}
		if (!ok) {
			char ch = value.charAt(value.length()-1);
			if (ch!='0' && ch!='1' && ch!='2' && ch!='3' && ch!='4'
					&& ch!='5' && ch!='6' && ch!='7' && ch!='8' && ch!='9') {
						throw new NumberFormatException("Given time = " + value); 
			}
		}
		
		Double tmp = Double.valueOf(value);
		setType(tipo);

		valore.set(index, tmp);
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
			throw new IndexOutOfBoundsException("TimeMVar: illegal index");

		valore.remove(index);
	}
	
	/**
	*	@throws UnsupportedOperationException
	 */
	protected Object convert(String value) {
		throw new UnsupportedOperationException();
	}
}

