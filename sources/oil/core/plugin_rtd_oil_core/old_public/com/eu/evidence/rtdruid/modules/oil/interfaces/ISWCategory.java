package com.eu.evidence.rtdruid.modules.oil.interfaces;

/**
 * This interface is used to categorize section writers.
 * 
 * Each section writer can cover more than one category and each category is
 * identified by an ID. Moreover, it has a priority that it is used to sort the
 * section writer inside the most important category covered by the section
 * writer
 * 
 * @author Nicola Serreli
 */
public interface ISWCategory extends Comparable<ISWCategory> {

	/**
	 * @return all categories (as IDs) covered by this object
	 */
	String[] getKeys();

	/**
	 * @return the priority of this object, related to the covered categories
	 */
	int getPriority();

	/**
	 * This method checks if this ISWCategory object is equal to another one,
	 * i.e. if they contains the same list of ids and the same priority
	 * 
	 * @return true if this object is equal to another
	 */
	boolean equals(Object arg0);

	/**
	 * Compares this object with the specified object for order. Returns a
	 * negative integer, zero, or a positive integer as this object is less
	 * than, equal to, or greater than the specified object.
	 * 
	 * @param arg0
	 *            the object to be compared.
	 * @return a negative integer, zero, or a positive integer as this object is
	 *         less than, equal to, or greater than the specified object.
	 */
	int compareTo(ISWCategory arg0);
}
