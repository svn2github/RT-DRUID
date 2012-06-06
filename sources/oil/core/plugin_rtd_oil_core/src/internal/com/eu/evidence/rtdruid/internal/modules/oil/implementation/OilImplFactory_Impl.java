/*
 * Created on Aug 25, 2004
 *
 * $Id: OilImplFactory_Impl.java,v 1.1 2008/03/27 12:16:21 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.implementation;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import org.w3c.dom.Document;

import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplFactory;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplID;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplementation;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * This factory contains all Implementation currently loaded
 * 
 * @author Nicola Serreli
 */
public class OilImplFactory_Impl extends OilImplFactory {
	/** The unique instance of this Factory */
	//public final static OilImplFactory INSTANCE = new OilImplFactory();
	//protected final IVarTree vt;

	// ----------------------------

	/** All implementations */
	protected LinkedList<IOilImplementation> descrList;

	/** Contruct a new factory */
//	private OilImplFactory_Impl(IVarTree vt) {
	private OilImplFactory_Impl() {
		descrList = new LinkedList<IOilImplementation>();
//		this.vt = vt;
	}
	
	public static OilImplFactory getAnInstance(IVarTree vt) {
		final OilImplFactory answer;
		
		if (vt != null) {
			HashMap<String, Object> properties = vt.getProperties();
			
			if (properties.containsKey(VT_IMPLEMENTATION_FACTORY)) {
				answer = (OilImplFactory) properties.get(VT_IMPLEMENTATION_FACTORY);
			} else {
				answer = new OilImplFactory_Impl();
				properties.put(VT_IMPLEMENTATION_FACTORY, answer);
			}
		} else {
			answer = new OilImplFactory_Impl();
		}
		return answer;
	}

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
	public boolean add(IOilImplID id, Document data) {
		return add(new OilImplementation(id, data));
	}

	/**
	 * Add a new Implementation
	 * 
	 * @param data
	 *            contains all data about Oil Implementation Section
	 * 
	 * @return true if specified data are correctly added, false if there was a
	 *         previous OilImplementation with the same id and different data.
	 */
	public boolean add(IOilImplementation data) {

		// check for unique id
		int pos = Collections.binarySearch(descrList, data.getId());

		IOilImplementation newImpl = data.clone();
		if (pos < 0) {
			descrList.add(-pos - 1, newImpl);
			return true;
		}

		// check if old Implementation is equals to new Implementation
		IOilImplementation old = (IOilImplementation) descrList.get(pos);
		if (old.equalsImpl(newImpl)) {
			old.incrCounter();
			return true;
		}

		return false;
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplFactory#remove(com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplID)
	 */
	@Override
	public IOilImplementation remove(IOilImplID id) {
		int pos = Collections.binarySearch(descrList, id);
		if (pos >= 0) {
			return descrList.remove(pos);
		}
		return null;
	}

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
	public boolean merge(IOilImplID id, Document data) {
		return merge(new OilImplementation(id, data));
	}

	/**
	 * Add a new Implementation. If already exist an Implementation with the same ID,
	 * tries to merge them.
	 * 
	 * @param data
	 *            contains all data about Oil Implementation Section
	 * 
	 * @return true if specified data are correctly added.
	 */
	public boolean merge(IOilImplementation data) {

		// check for unique id
		int pos = Collections.binarySearch(descrList, data.getId());

		IOilImplementation newImpl = data.clone();
		if (pos < 0) {
			descrList.add(-pos - 1, newImpl);
			return true;
		}

		// check if old Implementation is equals to new Implementation
		IOilImplementation old = (IOilImplementation) descrList.get(pos);
		if (old.mergeImpl(newImpl)) {
			old.incrCounter();
			return true;
		}

		return false;
	}
	
	/**
	 * Returns identifiers of all stored OilImplementation
	 * 
	 * @return an id for each stored OilImplementation object
	 */
	public IOilImplID[] getImplNames() {
		ArrayList<IOilImplID> names = new ArrayList<IOilImplID>(descrList.size());
		Iterator<IOilImplementation> iter = descrList.iterator();
		while (iter.hasNext()) {
			names.add(((IOilImplementation) iter.next()).getId());
		}

		return (IOilImplID[]) names.toArray(new IOilImplID[0]);
	}

	/**
	 * Returns the OilImplementation idenfied by specified id
	 * 
	 * @param id
	 *            identifies an OilImplementation
	 * 
	 * @return the required OilImplementation or null if not found.
	 */
	public IOilImplementation getImpl(IOilImplID id) {
		Iterator<IOilImplementation> iter = descrList.iterator();
		while (iter.hasNext()) {
			IOilImplementation curr = (IOilImplementation) iter.next();
			if (id.equals((curr).getId())) {
				return curr;
			}
		}
		// not found
//		return  new OilImplFactory_Impl();
	
		
//		if ("ee".equalsIgnoreCase(id.getRtos())) {
//			
//			setEEImplDefault();
//			
//			// search again
//			iter = descrList.iterator();
//			while (iter.hasNext()) {
//				IOilImplementation curr = (IOilImplementation) iter.next();
//				if (id.equals((curr).getId())) {
//					return curr;
//				}
//			}
//		}
		return null;
	}

//	
//	protected void setEEImplDefault() {
//		(new OilReader()).storeDefaultEEImpl(vt);
//	}
	
	/**
	 * Removes all OilImplementation
	 */
	public void clear() {
		descrList.clear();
	}

	@Override
	public void reloadDefault() {
		clear();
		for (IOilImplementation impl : OilImplCollector.getAllOilImplementation()) {
			merge(impl);
		}
	}
}