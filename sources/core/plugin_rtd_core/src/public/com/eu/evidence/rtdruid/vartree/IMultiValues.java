/*
 * Created on 4-set-2005
 *
 * $Id: IMultiValues.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree;


/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public interface IMultiValues extends IVariable {
    //	 ----------------------   Multi Values   ----------------------
	
    public void appendValue(String value) throws IVariable.NotValidValueException;

    /**	Returns all stored values
     *
     *	@return		all values.
     */
    public String[] getValues();

    /**	 Returns only the value in the given position.
     *
     *	@param	index	the position of request data in the internal list
     *
     *	@return	the value stored in the given position
     *
     *	@throws IndexOutOfBoundsException if index is negative or is larger than the size of internal list.
     */
    public String getValues(int index);

    /**	 Clears internal list and stores all given values.
     *
     *	@param	valuesList a list of new values
     *
     *	@throws NullPointerException	if valuesList is null or one value is null
     */
    public void setValues(String[] valuesList);

    /** Changes the value stored in the given position.
     *
     *	@param	value  a new value
     *	@param	index	the position of request data in the internal list
     *
     *	@throws IndexOutOfBoundsException if index is negative or is larger than the size of internal list.
     *	@throws NullPointerException	if value is null
     */
    public void setValue(String value, int index) throws IVariable.NotValidValueException;

    /**	Returns the size of internal list
     *
     *	@return size of internal list 
     */
    public int sizeValues();

    /**	Removes all stored data.
     */
    public void clearValues();

    /**	Removes the element at the specified position in this list.
     *	Shifts any subsequent elements to the left (subtracts one from their indices). 
     *
     *	@param	index	the position of datum to drop
     *
     *	@throws IndexOutOfBoundsException if index is negative or is larger than the size of internal list.
     */
    public void removeValue(int index);
}