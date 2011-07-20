/*
 * Created on 10-gen-2006
 *
 * $id$
 */
package com.eu.evidence.rtdruid.vartree.abstractions;

/**
 * This interface describes an Object that group thogether all properties of
 * logical element of tree (like a Task or a Resource).
 * 
 * @author Nicola Serreli
 */
public interface IGenRes {

	/***************************************************************************
	 * 
	 * Properties
	 *  
	 **************************************************************************/

	/**
	 * @return the name of this element
	 */
	String getName();

	/**
	 * @return where this element is stored inside the VarTree
	 */
	String getPath();
	
	IGenResList getParent();
	/**
	 * @return true if autoSave is already enable
	 */
	boolean getSave();
	
	/**
	 * Identify the parent RT-OS
	 * 
	 * @return the identifier of the RT-OS 
	 */
	String getRTOS();

	/**
	 * Identify the refered List of Objects
	 * 
	 * @return Array of names
	 */
	String[] getReferenceGenRes(String property);
	/**
     * Sets that current object is a "new object"
     */
    void setStatusNew();
    
    /**
     * Sets that current object has to be removed  
     */
    void setStatusRemoved();
    
    /**
     * Sets that current object is already stored  
     */
    void setStatusStored();
    
    /**
     * @return Returns the status.
     */
    int getStatus();
	
	/***************************************************************************
	 * 
	 * Properties from tree
	 *  
	 **************************************************************************/

	/**
	 * This method adds a GenResProperty to this element. If already exist a
	 * property with specified id, drop the old one. A null value, only remove
	 * the old value.
	 * 
	 * @param key
	 *            identifies the new property
	 * @param value
	 *            the new property (accept null values)
	 * 
	 * @return the old value, or null (if no value was set)
	 */
	IGenResProperty addGenResProperty(String key, IGenResProperty value);

	/**
	 * Returns the specified property, or throws an exception if no value was
	 * set.
	 * 
	 * @param key
	 *            identifies the property
	 * 
	 * @return the specified property.
	 * 
	 * @throws IllegalArgumentException
	 *             if this element doesn't contains the specified Property
	 */
	IGenResProperty getGenResProperty(String key)
			throws IllegalArgumentException;

	/**
	 * Returns true if this element contains the specified property, false
	 * otherwise.
	 * 
	 * @param key
	 *            identifies the property
	 * 
	 * @return if this element contains (true) or not (false) the specified
	 *         property.
	 */
	boolean existGenResProperty(String key);
	
	/**
	 * Save the name for the object
	 * 
	 * @param name
	 *            new Name
	 * 
	 * @return void
	 */
	void setName(String name);

	/***************************************************************************
	 * 
	 * Direct access to tree's Properties
	 *  
	 **************************************************************************/

	/**
	 * Sets the value of a GenResProperty. The old value is dropped.
	 * 
	 * @param key
	 *            identifies the property
	 * @param value
	 *            the new value
	 * 
	 * @throws IllegalArgumentException
	 *             if this element doesn't contains the specified Property
	 */
	void set(String key, int value) throws IllegalArgumentException;

	/**
	 * Sets the value of a GenResProperty. The old value is dropped.
	 * 
	 * @param key
	 *            identifies the property
	 * @param value
	 *            the new value
	 * 
	 * @throws IllegalArgumentException
	 *             if this element doesn't contains the specified Property
	 */
	void set(String key, long value) throws IllegalArgumentException;

	/**
	 * Sets the value of a GenResProperty. The old value is dropped.
	 * 
	 * @param key
	 *            identifies the property
	 * @param value
	 *            the new value
	 * 
	 * @throws IllegalArgumentException
	 *             if this element doesn't contains the specified Property
	 */
	void set(String key, double value) throws IllegalArgumentException;

	/**
	 * Sets the value of a GenResProperty. The old value is dropped.
	 * 
	 * @param key
	 *            identifies the property
	 * @param value
	 *            the new value
	 * 
	 * @throws IllegalArgumentException
	 *             if this element doesn't contains the specified Property
	 */
	void set(String key, float value) throws IllegalArgumentException;

	/**
	 * Sets the value of a GenResProperty. The old value is dropped.
	 * 
	 * @param key
	 *            identifies the property
	 * @param value
	 *            the new value
	 * 
	 * @throws IllegalArgumentException
	 *             if this element doesn't contains the specified Property
	 */
	void set(String key, Object value) throws IllegalArgumentException;

	/**
	 * Gets the value of a GenResProperty.
	 * 
	 * @param key
	 *            identifies the property
	 * 
	 * @throws IllegalArgumentException
	 *             if this element doesn't contains the specified Property
	 */
	Object get(String key) throws IllegalArgumentException;

	/**
	 * Gets the String rapresentation of the current value of a GenResProperty.
	 * If the property is null, returns the string "null", not a null object.
	 * 
	 * @param key
	 *            identifies the property
	 * 
	 * @throws IllegalArgumentException
	 *             if this element doesn't contains the specified Property
	 */
	String getString(String key) throws IllegalArgumentException;

	/**
	 * Gets the value of a GenResProperty, casting it to a long.
	 * 
	 * @param key
	 *            identifies the property
	 * 
	 * @throws IllegalArgumentException
	 *             if this element doesn't contains the specified Property
	 * @throws NumberFormatException
	 *             if the values isn't a valid long
	 */
	long getLong(String key) throws IllegalArgumentException,
			NumberFormatException;

	/**
	 * Gets the value of a GenResProperty, casting it to an int.
	 * 
	 * @param key
	 *            identifies the property
	 * 
	 * @throws IllegalArgumentException
	 *             if this element doesn't contains the specified Property
	 * @throws NumberFormatException
	 *             if the values isn't a valid int
	 */
	int getInt(String key) throws IllegalArgumentException,
			NumberFormatException;

	/**
	 * Gets the value of a GenResProperty, casting it to a double.
	 * 
	 * @param key
	 *            identifies the property
	 * 
	 * @throws IllegalArgumentException
	 *             if this element doesn't contains the specified Property
	 * @throws NumberFormatException
	 *             if the values isn't a valid int
	 */
	double getDouble(String key) throws IllegalArgumentException,
			NumberFormatException;

	/**
	 * Gets the value of a GenResProperty, casting it to a float.
	 * 
	 * @param key
	 *            identifies the property
	 * 
	 * @throws IllegalArgumentException
	 *             if this element doesn't contains the specified Property
	 * @throws NumberFormatException
	 *             if the values isn't a valid float
	 */
	float getFloat(String key) throws IllegalArgumentException,
			NumberFormatException;

	/***************************************************************************
	 * 
	 * Temporary Properties
	 *  
	 **************************************************************************/

	/**
	 * Sets the value of a property that will be not saved into the VarTree. The
	 * old value is dropped.
	 * 
	 * @param key
	 *            identifies the property
	 * @param value
	 *            the new value
	 */
	void setTempProperty(String key, int value);

	/**
	 * Sets the value of a property that will be not saved into the VarTree. The
	 * old value is dropped.
	 * 
	 * @param key
	 *            identifies the property
	 * @param value
	 *            the new value
	 */
	void setTempProperty(String key, long value);

	/**
	 * Sets the value of a property that will be not saved into the VarTree. The
	 * old value is dropped.
	 * 
	 * @param key
	 *            identifies the property
	 * @param value
	 *            the new value
	 */
	void setTempProperty(String key, double value);

	/**
	 * Sets the value of a property that will be not saved into the VarTree. The
	 * old value is dropped.
	 * 
	 * @param key
	 *            identifies the property
	 * @param value
	 *            the new value
	 */
	void setTempProperty(String key, float value);

	/**
	 * Sets the value of a property that will be not saved into the VarTree. The
	 * old value is dropped.
	 * 
	 * @param key
	 *            identifies the property
	 * @param value
	 *            the new value
	 */
	void setTempProperty(String key, Object value);

	/**
	 * Gets the value of a Temporary Property.
	 * 
	 * @param key
	 *            identifies the property
	 * 
	 * @return the value of a Temporary Property, or null if it was not set
	 */
	Object getTempProperty(String key);

	/**
	 * Gets the String rapresentation of the current value of a Temporary
	 * Property. If the property is null, returns the string "null", not a null
	 * object.
	 * 
	 * @param key
	 *            identifies the property
	 * 
	 * @return the value of a Temporary Property, or null if it was not set
	 */
	String getTempString(String key);

	/**
	 * Gets the value of a Temporary Property, casting it to an int.
	 * 
	 * @param key
	 *            identifies the property
	 * 
	 * @throws NumberFormatException
	 *             if the values isn't a valid int
	 */
	int getTempInt(String key);

	/**
	 * Gets the value of a Temporary Property, casting it to a double.
	 * 
	 * @param key
	 *            identifies the property
	 * 
	 * @throws NumberFormatException
	 *             if the values isn't a valid double
	 */
	double getTempDouble(String key);

	/**
	 * Gets the value of a Temporary Property, casting it to a float.
	 * 
	 * @param key
	 *            identifies the property
	 * 
	 * @throws NumberFormatException
	 *             if the values isn't a valid float
	 */
	float getTempFloat(String key);

	/**
	 * Returns true if this element contains the specified property, false
	 * otherwise.
	 * 
	 * @param key
	 *            identifies the property
	 * 
	 * @return if this element contains (true) or not (false) the specified
	 *         property.
	 */
	boolean existTempProperty(String name);

	/***************************************************************************
	 * 
	 * Utilities
	 *  
	 **************************************************************************/

	/**
	 * Force all GenResProperties to reload their values form VarTree. All
	 * unsaved changes will be dropped.
	 */
	void load();

	/**
	 * Changes the property "save values into the VarTree" of all
	 * GenResProperties. All GenResProperties that contains a modified value,
	 * will store the new value.
	 * 
	 * @param newValue
	 *            conains the new value of parameter "save values into the
	 *            VarTree"
	 */
	void setSave(boolean newValue);

	/**
	 * Forces all GenResProperties to store theris value insied the VarTree.
	 * 
	 * @return false if there was some errors
	 */
	boolean store();
	
	/**
	 * Clone 
	 */
	Object clone();
}