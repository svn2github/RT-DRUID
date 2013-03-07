/*
 * Created on Sep 7, 2005
 *
 * $Id: ISimpleGenRes.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.abstractions;

import java.util.HashMap;

/**
 * TODO Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public interface ISimpleGenRes extends Cloneable {
	//--------------------------------------------------
	Object removeAProperty(String pName);

	/**
	 * Sets a property
	 * 
	 * @param pName
	 *            the property identifier
	 * @param value
	 *            the property value
	 * 
	 * @return the old value, or null if no value was setted
	 */
	Object setProperty(String pName, String value);

	/**
	 * Sets an object
	 * 
	 * @param pName
	 *            the identifier
	 * @param value
	 *            the value
	 * 
	 * @return the old value, or null if no value was setted
	 */
	Object setObject(String pName, Object value);

	/**
	 * Returns a property as a String
	 * 
	 * @param pName
	 *            identifies the property
	 * 
	 * @return a property
	 * 
	 * @throws IllegalArgumentException
	 *             if the property doesn't exist
	 */
	String getString(String pName);

	/**
	 * Returns a property as an int
	 * 
	 * @param pName
	 *            identifies the property
	 * 
	 * @return a property
	 * 
	 * @throws IllegalArgumentException
	 *             if the property doesn't exist
	 */
	int getInt(String pName);

	/**
	 * Returns a property as a long
	 * 
	 * @param pName
	 *            identifies the property
	 * 
	 * @return a property
	 * 
	 * @throws IllegalArgumentException
	 *             if the property doesn't exist
	 */
	long getLong(String pName);

	/**
	 * Returns a property as a double
	 * 
	 * @param pName
	 *            identifies the property
	 * 
	 * @return a property
	 * 
	 * @throws IllegalArgumentException
	 *             if the property doesn't exist
	 */
	double getDouble(String pName);

	/**
	 * Returns a property as a object
	 * 
	 * @param pName
	 *            identifies the property
	 * 
	 * @return a property
	 * 
	 * @throws IllegalArgumentException
	 *             if the property doesn't exist
	 */
	Object getObject(String pName);

	/**
	 * Returns the name of this object
	 * 
	 * @return the name
	 */
	String getName();

	/**
	 * Returns the path of this object
	 * 
	 * @return the path
	 */
	String getPath();

	// ----------------------------------
	HashMap<String, ? extends Object> getAllProperties();

	/**
	 * Returns true if this object contains the specified property
	 * 
	 * @param pName
	 *            identifies the property
	 * 
	 * @return true if this object contains the specified property, false
	 *         otherwise
	 */
	boolean containsProperty(String pName);

	// ------------------------------------
	
	/**
	 * Clones this object
	 */
	ISimpleGenRes clone();
	

	/**
	 * Add all properties in the source
	 */
	void merge(ISimpleGenRes source);
}