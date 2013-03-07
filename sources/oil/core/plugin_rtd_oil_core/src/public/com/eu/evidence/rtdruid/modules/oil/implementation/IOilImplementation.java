package com.eu.evidence.rtdruid.modules.oil.implementation;



public interface IOilImplementation extends Comparable<Object>, Cloneable {

	/**
	 * Return the id.
	 * 
	 * @return the identifier.
	 */
	public IOilImplID getId();

	/**
	 * Return the number of definition of current Implementation.
	 * 
	 * @return number of current definition.
	 */
	public int getCounter();

	/**
	 * Increment the number of definition of current Implementation.
	 */
	public void incrCounter();

	/**
	 * Decrement the number of definition of current Implementation.
	 * 
	 * @return the new number of current definition.
	 */
	public int decrCounter();

	/**
	 * Returns current implementation with Oil Syntax
	 * 
	 * @return a string that contains this Oil Implementation part writed with
	 *         Oil Syntax
	 */
	public String toOil();

	/**
	 * Returns an OilImplPointer to navigate this implementation.
	 * 
	 * @return an OilImplPointer to navigate this implementation.
	 */
	public IOilImplPointer getPointer();

	/**
	 * Checks if this OilImplementation contains the same data on another.
	 * 
	 * @param o
	 *            the Object to be compared.
	 * 
	 * @return true if the specified object contains the same data of this one.
	 */
	public boolean equalsImpl(IOilImplementation o);

	/**
	 * Tries to merge this Oil Implementation with the given one. 
	 * 
	 * @param o
	 *            the Object to be merged.
	 * 
	 * @return true if the merge was successful.
	 */
	public boolean mergeImpl(IOilImplementation o);

	/**
	 * 
	 * @return a clone of this object
	 */
	public IOilImplementation clone();
}