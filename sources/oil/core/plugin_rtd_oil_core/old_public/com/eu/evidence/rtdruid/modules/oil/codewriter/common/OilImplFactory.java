package com.eu.evidence.rtdruid.modules.oil.codewriter.common;

import org.w3c.dom.Document;

import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilImplFactory_Impl;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplID;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplementation;
import com.eu.evidence.rtdruid.vartree.IVarTree;

public abstract class OilImplFactory {

	public final static String VT_IMPLEMENTATION_FACTORY = "VarTree's implementation factory property";


	/**
	 * @return an instance of this Factory 
	 */
	public static OilImplFactory getAnInstance(IVarTree vt) {
		return OilImplFactory_Impl.getAnInstance(vt);
	}
	
	/**
	 * Remove any existent Oil Implementation and reload all default ones
	 */
	public abstract void reloadDefault();

	/**
	 * Add a new Implementation
	 * 
	 * @param id
	 *            identifies the new Oil Implementation
	 * @param data
	 *            contains all data about Oil Implementation Section
	 * 
	 * @return true if specified data are correctly added, false if there was a
	 *         previous OilImplementation with the same id and different data.
	 */
	public abstract boolean add(IOilImplID id, Document data);

	/**
	 * Add a new Implementation
	 * 
	 * @param data
	 *            contains all data about Oil Implementation Section
	 * 
	 * @return true if specified data are correctly added, false if there was a
	 *         previous OilImplementation with the same id and different data.
	 */
	public abstract boolean add(IOilImplementation data);

	/**
	 * Add a new Implementation. If already exist an Implementation with the same ID,
	 * tries to merge them.
	 * 
	 * @param id
	 *            identifies the new Oil Implementation
	 * @param data
	 *            contains all data about Oil Implementation Section
	 * 
	 * @return true if specified data are correctly added.
	 */
	public abstract boolean merge(IOilImplID id, Document data);

	/**
	 * Add a new Implementation. If already exist an Implementation with the same ID,
	 * tries to merge them.
	 * 
	 * @param data
	 *            contains all data about Oil Implementation Section
	 * 
	 * @return true if specified data are correctly added.
	 */
	public abstract boolean merge(IOilImplementation data);

	/**
	 * Remove an Implementation
	 * 
	 * @param id
	 *            identifies the Oil Implementation that should be removed
	 * 
	 * @return the removed IOilImplementation, or null if there was not any OilImplementation with given ID.
	 */
	public abstract IOilImplementation remove(IOilImplID id);

	
	/**
	 * Returns identifiers of all stored OilImplementation
	 * 
	 * @return an id for each stored OilImplementation object
	 */
	public abstract IOilImplID[] getImplNames();

	/**
	 * Returns the OilImplementation idenfied by specified id
	 * 
	 * @param id
	 *            identifies an OilImplementation
	 * 
	 * @return the required OilImplementation or null if not found.
	 */
	public abstract IOilImplementation getImpl(IOilImplID id);

	/**
	 * Removes all OilImplementation
	 */
	public abstract void clear();

}