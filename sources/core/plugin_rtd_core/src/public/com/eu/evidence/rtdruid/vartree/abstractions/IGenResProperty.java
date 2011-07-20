/*
 * Created on 10-gen-2006
 *
 * $id$
 */
package com.eu.evidence.rtdruid.vartree.abstractions;

import java.util.List;

/**
 * This object contains one propery of a GenRes element. Also, this object
 * contains methods to read and store values from and inside the tree.
 * 
 * If AutoSave is true and this element implements store() method, the new value
 * is stored during the running of a "set(...) method". Otherwise, the new value
 * is not saved until the method store or the method setSave(true) is called.
 * 
 * 
 * @author Nicola Serreli
 */
public interface IGenResProperty {

	/***************************************************************************
	 * 
	 * Set
	 *  
	 **************************************************************************/

	/**
	 * Sets the value. The old value is dropped.
	 * 
	 * @param value
	 *            the new value
	 */
	void set(int value);

	/**
	 * Sets the value. The old value is dropped.
	 * 
	 * @param value
	 *            the new value
	 */
	void set(long value);

	/**
	 * Sets the value. The old value is dropped.
	 * 
	 * @param value
	 *            the new value
	 */
	void set(double value);

	/**
	 * Sets the value. The old value is dropped.
	 * 
	 * @param value
	 *            the new value
	 */
	void set(float value);

	/**
	 * Sets the value. The old value is dropped.
	 * 
	 * @param value
	 *            the new value
	 */
	void set(Object value);

	/***************************************************************************
	 * 
	 * Get
	 *  
	 **************************************************************************/

	/**
	 * Gets the value.
	 */
	Object get();

	/**
	 * Gets the String rapresentation of the current value.
	 * If the property is null, returns the string "null", not a null object.
	 */
	String getString();

	/**
	 * Gets the value, casting it to a long.
	 * 
	 * @throws NumberFormatException
	 *             if the values isn't a valid long
	 */
	long getLong() throws NumberFormatException;

	/**
	 * Gets the value, casting it to an int.
	 * 
	 * @throws NumberFormatException
	 *             if the values isn't a valid int
	 */
	int getInt() throws NumberFormatException;

	/**
	 * Gets the value, casting it to a double.
	 * 
	 * @throws NumberFormatException
	 *             if the values isn't a valid int
	 */
	double getDouble() throws NumberFormatException;

	/**
	 * Gets the value, casting it to a float.
	 * 
	 * @throws NumberFormatException
	 *             if the values isn't a valid float
	 */
	float getFloat() throws NumberFormatException;

	/***************************************************************************
	 * 
	 * Load / Store
	 *  
	 **************************************************************************/

	/**
	 * Loads the value from the tree
	 */
	void load();

	/**
	 * Stores the value inside the tree
	 * 
	 * @return false if there was some problems
	 */
	boolean store();

	/**
	 * @return true if autoSave is already enable
	 */
	boolean getSave();

	/**
	 * Enable or disable the autoSave function. If the newValue is true and this
	 * element contains a not-saved value, this method tries to store it inside the tree.
	 * 
	 * @param newValue the new setting for AutoSave
	 */
	void setSave(boolean newValue);

	/**
	 * @return true if the value was modified
	 */
	boolean isModified();
	
	/**
	 * Clone this property, disabling the saveAttribute 
	 */
	Object clone();
	
	
	/**
	 * This interface is used to identify all properties that rapresents an
	 * Single Value Enum.
	 * 
	 * An enum usually has more than one type.
	 * All enumerators are stored as IGenRes.
	 * 
	 * Methods "get" and "getString" are a little differents from
	 * IGenResProperty: <br>
	 * <b>get </b> returns the current element (as IGenRes) <br>
	 * <b>getString </b> returns the current type
	 */
	public interface ISingleValueEnumGenResProperties extends IGenResProperty {
		/**
		 * this method returns all valid enumerator types.
		 * 
		 * @return all enumerator types 
		 */
		String[] getTypes();
		/**
		 * This method return the current enumerator.
		 * If there isn't any enumerator set, returns null.
		 * 
		 * @return type of the current enumerator, or null if none is set
		 */
		String getCurrent();
		/**
		 * Gets the current enumerator: a IGenRes element.
		 */
		Object get();
		/**
		 * Returns all enumerator, not only the current one. 
		 */
		List<?> getAll();
		/**
		 * Gets the type of current enumerator. If no enumerator is set, returns the
		 * string "null", not a null object. (compliance with IGenResProperty
		 * syntax)
		 */
		String getString();
	}

	/**
	 * This interface is used to identify all properties that rapresents an
	 * Multiple Value Enum.
	 * 
	 * An enum usually has more than one type.
	 * All enumerators are stored as IGenRes.
	 * 
	 * Methods "get" and "getString" are a little differents from
	 * IGenResProperty: <br>
	 * <b>get </b> returns the current element (as IGenRes) <br>
	 * <b>getString </b> returns the current type
	 */
	public interface IMultipleValueEnumGenResProperties extends IGenResProperty {
		/**
		 * this method returns all valid enumerator types.
		 * 
		 * @return all enumerator types 
		 */
		String[] getTypes();
		/**
		 * This method return the current enumerator.
		 * If there isn't any enumerator set, returns null.
		 * 
		 * @return type of the current enumerator, or null if none is set
		 */
		String[] getCurrent();
		/**
		 * Gets the current enumerator: a IGenRes element.
		 */
		Object get();
		/**
		 * Returns all enumerator, not only the current one. 
		 */
		List<?> getAll();
		/**
		 * Gets the type of current enumerator. If no enumerator is set, returns the
		 * string "null", not a null object. (compliance with IGenResProperty
		 * syntax)
		 */
		String getString();
		
		void remove(String value);
	}

	
	/**
	 * This interface is used to identify all properties that rapresents an
	 * Single Value Enum.
	 * 
	 * An enum usually has more than one type.
	 * All enumerators are stored as IGenRes.
	 * 
	 * Methods "get" and "getString" are a little differents from
	 * IGenResProperty: <br>
	 * <b>get </b> returns the current element (as IGenRes) <br>
	 * <b>getString </b> returns the current type
	 */
	public interface IComponentGenRes extends IGenResProperty {
		/**
		 * this method returns all valid enumerator types.
		 * 
		 * @return all enumerator types 
		 */
		void setEnumeratorName();
		/**
		 * This method return the current enumerator.
		 * If there isn't any enumerator set, returns null.
		 * 
		 * @return type of the current enumerator, or null if none is set
		 */
		String getCurrent();
		/**
		 * Gets the current enumerator: a IGenRes element.
		 */
		Object get();
		/**
		 * Returns all enumerator, not only the current one. 
		 */
		List<?> getAll();
		/**
		 * Gets the type of current enumerator. If no enumerator is set, returns the
		 * string "null", not a null object. (compliance with IGenResProperty
		 * syntax)
		 */
		String getString();
	}

	/** Extention to IGenResList to handle the path */
	interface IGRLWithPath extends IGenResList {
		/**
		 * Set the path of the System
		 */
		void setSystemPath(String sysName);
	}

}