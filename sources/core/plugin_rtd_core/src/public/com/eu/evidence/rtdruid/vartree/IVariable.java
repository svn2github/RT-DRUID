package com.eu.evidence.rtdruid.vartree;



/**	This interface is used to define class to implement a abstract type for shared variables.
*
*	<br><br><b> If a class implements a type and if you want to store it in VariableFactory, this class MUST implement public default constructor.</b><br> 
*	It's possible to create a new instace from another instance. Sometimes it's useful to have
*	a method to destroy a type.
*
*	@see	rtdruid.vartree.VariableFactory	VariableFactory stores a list of types and gives a method to make a
*	new instance of one IVariable of these types
*	@see	rtdruid.vartree.IVarTree 	VarTree stores all shared variables.
*
*@author Nicola Serreli
*/
public interface IVariable extends Cloneable {

// ----------------------   COSTRUTTORE   ----------------------

	/**	This method is a frontend to default constructor. If the type is a single
	*
	*	@return a new instance of this StringVar
	*/
	public IVariable instance();

	/**	Makes a indipendent copy of this IVariable or returns the same object if it's a single tone.
	*
	*	@return a copy of this IVariable
	*/
	public Object clone();

	/**	Destroys all data in this IVariable.
	*/
	public void dispose();

// ----------------------   SET & GET   ----------------------
	
	/**	Sets the value of this IVariable
	*
	*	@param	value	the datum
	*/
	public void set(String value);

	/**	Gets the value of this IVariable.
	 *  It's an object (String, Double, ...) and could be null
	 * 
	 * @return the datum, or null if no one is set
	*/
	public Object get();

// ----------------------   CONVERSIONI   ----------------------
	
	/**	Returns a string that contains the data stored in this IVariable
	*
	*	@return a string that contains the data stored in this IVariable 
	*/
	public String toString();
	
// ----------------------   Exceptions   ----------------------

	/**	This exception is throw if the value of a {@link rtdruid.vartree.variables.IVariable IVariable} in not
	*	contained in the given list of valids values.
	*/
	public static class NotValidValueException extends RuntimeException {
		/**
		 * 
		 */
		private static final long serialVersionUID = -4533669355508901080L;

		public NotValidValueException(String msg) {
			super(msg);
		} 
	}
}
