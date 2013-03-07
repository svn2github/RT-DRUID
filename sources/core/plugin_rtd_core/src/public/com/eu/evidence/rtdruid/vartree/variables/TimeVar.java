package com.eu.evidence.rtdruid.vartree.variables;

import com.eu.evidence.rtdruid.vartree.IVariable;

/** This class implements a "Time" object : &lt;double number&gt;&lt;symbol of time's unit&gt;
*
*	@see rtdruid.vartree.variables.IVariable
*
*@author Nicola Serreli
*/
public class TimeVar extends DoubleVar implements Comparable<TimeVar> {
	public static final int HOUR = 0;
	public static final int MINUTE = 1;
	public static final int SECOND = 2;
	public static final int MILLI_SECOND = 3;
	public static final int MICRO_SECOND = 4; 
	public static final int NANO_SECOND = 5;
	
	/**
	 * <b>IMPORTANT</b> : convertion from cpu cycles to other "times" (and
	 * viceversa) are non computed automaticaly. i.e. setType changes only the
	 * type but not the value, if before or after the type is cycles.
	 */
	public static final int CYCLES = 6;
	public static final String[] SYMBOLS = {  "h",  "m", "s", "ms", "us", "ns", "cycles"};
	
	private int type;

// ----------------------   CONSTRUCTOR   ----------------------

	/**	Default constructor
	*/
	public TimeVar () {
		type = MILLI_SECOND;
	}
	
	public TimeVar(String value) {
		super();
		type = MILLI_SECOND;
		set(value);
	}
	/**	This method is a frontend to default constructor
	*
	*	@return a new instance of this TimeVar
	*/
	public IVariable instance() {
		return new TimeVar();
	}

	/**	Makes a indipendent copy of this TimeVar
	*
	*	@return a copy of this TimeVar
	*/
	public Object clone() {
		TimeVar answer = (TimeVar) super.clone();
		answer.type = type;
		return answer;
	}

	/**	Destroys all data in this TimeVar.
	*/
	public void dispose() {
		type = MILLI_SECOND;
		super.dispose();
	}

// ----------------------   SET & GET   ----------------------

	/**	Sets the value of this IVariable (number[time's unit])
	*
	*	@param	value	the datum (it can be null)
	*
	*	@throws NotValidValueException
	*	@throws	NumberFormatException	if the given String isn't a number (number[time's unit]).
	*/
	public void set(String value) throws NotValidValueException {
		int tipo = type;
		// set to null void values 
//		if (("").equals(value)) {
//			value = null;
//		}
		if (value != null ) {
			boolean ok = false;
			// start with symbols with 2 chars
			for (int i=SYMBOLS.length -1 ; i>=0 && (!ok); i--) {
				if (value.endsWith(SYMBOLS[i])) {
					tipo = i;
					// remove the symbol
					value = value.substring(0, value.length() - SYMBOLS[i].length());
					ok  = true;
				}
			}
		}
		
		super.set ( value == null  || "".equals(value)? (Double) null : new Double(value) );
		type = tipo;
	}

	/**
	 * Sets the time's unit and updates the value.
	 * 
	 * <b>IMPORTANT</b> : convertion from cpu cycles to other "times" (and
	 * viceversa) are non computed automaticaly. i.e. setType changes only the
	 * type but not the value, if before or after the type is cycles.
	 * 
	 * @param typeId
	 *            one of constants defined above (hour, second, ...)
	 * 
	 * @throws IllegalArgumentException
	 *             if typeId isn't a valid time's unit
	 */
	public void setType(int typeId) {
		if (typeId<0 || typeId>=SYMBOLS.length) {
			throw new IllegalArgumentException("Type id must be a valid ID");
		}
		double ratio = TimeVar.ratio(type, typeId);
		// adjust value
		if (super.value != null) {
			super.value = new Double(((Double) super.value).doubleValue() * ratio);
		}
		
		type = typeId;
	}
	
	/** Gets the time's unit ID.
	 */
	public int getType() {	return type;	}

	/** Gets the time's unit.
	 */
	public String getStringType() {	return SYMBOLS[type];	}
	
	/**
	 */
	public String toString() {
		return (super.value == null ? "null" : 
			super.value.toString() +  (((Double) super.value).isInfinite() || ((Double) super.value).isNaN() ? "" : getStringType() ));
	}

	
	public boolean equals(Object o) {
		if (o instanceof TimeVar) {
			return super.equals(o) && (this.type == ((TimeVar) o).type );
		}
		return false;
	}
// ------------- UTILITY ------------------	

	/**
	 * Returns the ratio between two time units.
	 * 
	 * IMPORTANT : the ratio from cpu cycles to oder "times" (and viceversa) is
	 * always 1.
	 * 
	 * @param oldType
	 *            the old time unit
	 * @param newType
	 *            the new time unit
	 * 
	 * @return the ratio
	 * 
	 * @throws ArrayIndexOutOfBoundsException
	 *             if used an illegal time unit
	 */
	public static double ratio(int oldType, int newType) {
		final double[][] valori = {
				{       1,     60, 3600,  3.600E6,  3.600E9, 3.600E12, 1 }, // old = hour
				{    1/60,      1,   60,     60E3,     60E6,     60E9, 1 }, // old = min
				{ 1/3.6e3,   1/60,    1,    1.0E3,    1.0E6,    1.0E9, 1 }, // old = sec
				{ 1/3.6e6,  1/6e4, 1e-3,    1.0E0,    1.0E3,    1.0E6, 1 }, // old = msec
				{ 1/3.6e9,  1/6e7, 1e-6,   1.0E-3,    1.0E0,    1.0E3, 1 }, // old = usec
				{1/3.6e12, 1/6e10, 1e-9,   1.0E-6,   1.0E-3,    1.0E0, 1 }, // old = psec
				{       1,      1,    1,        1,        1,        1, 1 }, // old = cycles
		};
		
		return valori[oldType][newType];
	}
	
	
//	@Override
	public int compareTo(TimeVar arg0) {
		if (super.value == null) 
			return arg0 == null || arg0.value == null ? 0 : Integer.MAX_VALUE;
		
		if (arg0 == null || arg0.value == null)
			return -1;
		
		return ((Double) super.value).compareTo( ((Double) arg0.value).doubleValue()  * ratio(arg0.type, type));
	}
}

