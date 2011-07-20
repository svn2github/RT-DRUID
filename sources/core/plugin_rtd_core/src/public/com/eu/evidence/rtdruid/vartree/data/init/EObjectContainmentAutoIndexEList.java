/*
 * Created on Oct 4, 2004
 *
 * $Id: EObjectContainmentAutoIndexEList.java,v 1.2 2008/05/14 17:08:46 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.data.init;



import org.eclipse.emf.ecore.InternalEObject;

import com.eu.evidence.rtdruid.vartree.data.ObjectWithID;

/** An extention of {@link rtdruid.vartree.data.init.EObjectContainmentUniqueEList EObjectContainmentUniqueEList}
 *  that sets a number as unique id for all objects added with an null id  
 * 
 * @author Nicola Serreli
 */
@SuppressWarnings("serial")
public class EObjectContainmentAutoIndexEList<E> extends
		EObjectContainmentUniqueEList<E> {
	
	private int counter = 0;

	public EObjectContainmentAutoIndexEList(Class<?> dataClass, InternalEObject owner, int featureID) {
		super(dataClass, owner, featureID);
	}

	/**
	 * This function checks if the object already added has a not null id,
	 * and, if it's true, sets its id using an internal counter*/
	protected void didAdd(int index, E newObject) {
		
		// first search and set the ID ..
		if (newObject instanceof ObjectWithID) {
			ObjectWithID o = (ObjectWithID) newObject;
			
			if (DataPath.NULL_ID.equals(o.getObjectID())) {
				
				// search an unused id
				String newId = null;
				do {
					newId =  "" + counter;
					counter ++;	
				} while (indexOfById(newId)>=0);
				
				// set the id
				( (ObjectWithID) newObject).setObjectID(newId);
				
			}
		}
		
		// ... than update hashMap
		super.didAdd(index, newObject);

	}
	
	/** Return the next id */
	public int getNextId() {
		return counter;
	}
}
