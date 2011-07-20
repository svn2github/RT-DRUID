/*
 * Created on 10-jun-2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.desk;

import java.util.Collection;

/**
 * This interface is the element used by the RTDFactory to build common objects
 * 
 * Nicola Serreli
 */
public interface IRTDSubFactory {

	/**
	 * Used to build a generic object
	 * 
	 * @param type
	 *            identifies the type that have to be build
	 * 
	 * @return a new object or null if this factory doesn't support the required
	 *         type
	 */
	public Object get(Class<?> type);

	/**
	 * Used to build an object with specified parameters
	 * 
	 * @param type
	 *            identifies the type that have to be build
	 * 
	 * @param values
	 *            contains every datum passed to the constructor
	 * 
	 * @return a new object or null if this factory doesn't support the required
	 *         type
	 */
	public Object get(Class<?> type, Object[] values);


	/**
	 * Used to build an object with specified parameters
	 * 
	 * @param type
	 *            identifies the type that have to be build
	 * 
	 * @param values
	 *            contains every datum passed to the constructor
	 * 
	 * @return a new object or null if this factory doesn't support the required
	 *         type
	 */
	public Object get(Class<?> type, Class<?>[] value_types, Object[] values);

	/**
	 * Returns the list of supported types
	 * 
	 * @return a list of supported types
	 */
	public Collection<Class<?>> getTypes();

	/**
	 * This method helps to understand if a type is supported or not by this
	 * factory
	 * 
	 * @param type
	 *            identifies the type that have to be build
	 * 
	 * @return true if this type is supported
	 */
	public boolean isSupported(Class<?> type);

	/**
	 * This method helps to understand if this factory is able to build an
	 * object of specified type using the vector "values" during the
	 * construction phase
	 * 
	 * @param type
	 *            identifies the type that have to be build
	 * 
	 * @param values
	 *            contains every datum passed to the constructor
	 * 
	 * @return true if this type is supported
	 */
	public boolean isSupported(Class<?> type, Object[] values);

	/**
	 * This method helps to understand if this factory is able to build an
	 * object of specified type using a vector of "values" during the
	 * construction phase
	 * 
	 * @param type
	 *            identifies the type that have to be build
	 * 
	 * @param value_types
	 *            the type of each parameter
	 * 
	 * @return true if this type is supported
	 */
	public boolean isSupported(Class<?> type, Class<?>[] value_types);

}
