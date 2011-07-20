/*
 * Created on 10-gen-2006
 *
 * $id$
 */
package com.eu.evidence.rtdruid.vartree.abstractions;

import java.util.Iterator;
import java.util.List;

/**
 * Contains the list of objects of the same type and refered to the same RT-OS
 * 
 * @author Nicola Serreli
 */
public interface IGenResList {

	/**
	 * The size of this list
	 */
	public int size();

	/**
	 * @return true, if this list is modificable
	 */
	public boolean modificable();

	/***************************************************************************
	 * 
	 * Access to list
	 *  
	 **************************************************************************/

	/**
	 * Returns an element of the list
	 * 
	 * @param index
	 *            identify the element
	 * 
	 * @return the required element
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if specified index is out of range 0..size-1
	 */
	public IGenRes get(int index);

	/**
	 * @return an iterator
	 */
	public Iterator<IGenRes> interator();

	/**
	 * Returns the list of elements. This list isn't a copy and all changes to
	 * this list is done inside this IGenResList.
	 * 
	 * Returned list, accept only IGenRes objects.
	 * 
	 * It is useful to sort elements and search.
	 * 
	 * @return the list of elements
	 */
	public List<IGenRes> asList();

	/***************************************************************************
	 * 
	 * NEW ELEMENTS
	 *  
	 **************************************************************************/

	/**
	 * This method creates a new element (doesn't add it to list)
	 */
	public IGenRes newObject(String name);

	/**
	 * This method removes an element
	 */
	public void removeObject(IGenRes gr);

	/***************************************************************************
	 * 
	 * Utilities
	 *  
	 **************************************************************************/

	/**
	 * Checks if there are new elements inside the tree, drop all elements that
	 * aren't in the tree and force others IGenRes to reload their values form
	 * VarTree.
	 * 
	 * IMPORTANT : All unsaved changes will be dropped.
	 */
	void load();

	/**
	 * Changes the property "save values into the VarTree" of all IGenRes. All
	 * IGenRes that contains modified values, will store them.
	 * 
	 * @param newValue
	 *            conains the new value of parameter "save values into the
	 *            VarTree"
	 */
	void setSave(boolean newValue);

	/**
	 * Forces all IGenRes to store theris value insied the VarTree, remove all
	 * removed elements and add all new elemens.
	 * 
	 * @return false if there was some errors
	 */
	boolean store();
	
	String getType();
}