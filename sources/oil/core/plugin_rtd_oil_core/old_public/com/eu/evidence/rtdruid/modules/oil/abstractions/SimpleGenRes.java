/*
 * Created on Dec 7, 2004
 *
 * $Id: SimpleGenRes.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.abstractions;


import java.util.HashMap;



/**
 * A simple class that store a name, a path and a group of properties
 * 
 * @author Nicola Serreli
 */
public class SimpleGenRes implements ISimpleGenRes {

	/** The object name */
	protected String name;

	/** The path of current object inside the tree */
	protected String path;

	/** All properties */
	protected HashMap<String, Object> properties = new HashMap<String, Object>();

	/**
	 * Constructor
	 * 
	 * @param name
	 *            is the name of this object
	 * @param path
	 *            where this object is located inside the tree
	 */
	public SimpleGenRes(String name, String path) {
		this.name = name;
		this.path = path;
	}

	//--------------------------------------------------

	/**
	 * Remove a property
	 * 
	 * @param pName
	 *            the property identifier
	 * @param value
	 *            the property value
	 * 
	 * @return the old value, or null if no value was setted
	 */
	public Object removeAProperty(String pName) {
		return properties.remove(pName.toLowerCase());
	}
	
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
	public Object setProperty(String pName, String value) {
		return properties.put(pName.toLowerCase(), value);
	}

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
	public Object setObject(String pName, Object value) {
		return properties.put(pName.toLowerCase(), value);
	}
	
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
	public String getString(String pName) {
		return (String) properties.get(check(pName));
	}

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
	public int getInt(String pName) {
		return Integer.decode(properties.get(check(pName)).toString()).intValue();
	}

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
	public long getLong(String pName) {
		return Long.decode(properties.get(check(pName)).toString()).intValue();
	}

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
	public double getDouble(String pName) {
		return Double.parseDouble(properties.get(check(pName)).toString());
	}
	
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
	public Object getObject(String pName) {
		return properties.get(check(pName));
	}
	
	/**
	 * Returns the name of this object
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the path of this object
	 * 
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
		

	// ----------------------------------

	/**
	 * Returns a copy of all properties of current object
	 * 
	 * @return a copy of all properties of current object
	 */
	public HashMap<String, Object> getAllProperties() {
		return (HashMap<String, Object>) properties.clone();
	}

	/**
	 * Returns true if this object contains the specified property
	 * 
	 * @param pName
	 *            identifies the property
	 * 
	 * @return true if this object contains the specified property, false
	 *         otherwise
	 */
	public boolean containsProperty(String pName) {
		return properties.containsKey(pName.toLowerCase());
	}

	/**
	 * Check if a property exist and, if true, returns the property name.
	 * 
	 * @param pName
	 *            identifies the property
	 * 
	 * @return the property name
	 * 
	 * @throws IllegalArgumentException
	 *             if the property doesn't exist
	 */
	protected String check(String pName) {
		pName = pName.toLowerCase();
		if (!properties.containsKey(pName)) {
			throw new IllegalArgumentException("Property not found:\n" + pName
					+ "\n" + properties);
		}
		return pName;
	}

	/**
	 * Returns a String rapresentation of this object
	 * 
	 * @return a String rapresentation of this object
	 */
	public String toString() {
		return "Simple Gen Res (name = " + name + "; path = " + path + ")\n"
				+ properties;
	}
	
	// ------------------------------------
	
	public ISimpleGenRes clone() {
		SimpleGenRes answer = new SimpleGenRes(name, path);
		answer.properties = (HashMap<String, Object>) properties.clone();
		
		return answer;
	}
}