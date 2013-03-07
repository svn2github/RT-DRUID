/*
 * Created on Nov 30, 2004
 *
 * $Id: OilObjectList.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.common;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;



/**
* This class contains all OSEK objects defined for a specified CPU
* 
* @author Nicola Serreli
*/
public class OilObjectList implements IOilObjectList {

	/**
	 * Contains all OSEK objects defined in a specific OS. 
	 */
	@SuppressWarnings("unchecked")
	private List<ISimpleGenRes>[] objectLists = new List[OBJECT_NUMBER];

	// ------------------------------------------------------------------
	/**
	 * Stores a list of specific OSEK objects. <br>
	 * Each Object is identifed by a String (the path of that object in the
	 * owner VarTree).
	 * 
	 * @param id
	 *            identifies the type of objects
	 * @param list
	 *            the objects
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if id isn't a valid identifer (see contants declared above).
	 */
	public void setList(int id, List<? extends ISimpleGenRes> list) {
		if (list == null) {
			list = new ArrayList<ISimpleGenRes>();
		}
		objectLists[id] = Collections
				.unmodifiableList(new ArrayList<ISimpleGenRes>(list));
	}

	/**
	 * Stores a list of specific OSEK objects. <br>
	 * Each Object is identifed by a String (the path of that object in the
	 * owner VarTree).
	 * 
	 * @param id
	 *            identifies the type of objects
	 * @param list
	 *            the objects
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if id isn't a valid identifer (see contants declared above).
	 */
	public void setList(int id, ISimpleGenRes[] list) {
		objectLists[id] = list == null ?
				Collections.unmodifiableList(new ArrayList<ISimpleGenRes>()) :
				Collections.unmodifiableList(Arrays.asList(list));
	}
	/**
	 * Returns an unmodificable list of specific OSEK objects. <br>
	 * Each Object is identifed by a SimpleGenRes.
	 * 
	 * @param id
	 *            identifies the type of objects
	 * 
	 * @return an unmodificable list of specific OSEK objects.
	 */
	public List<ISimpleGenRes> getList(int id) {
		return objectLists[id];
	}
	
	public String toString() {
		return objectLists == null ? "empty" : Arrays.asList(objectLists).toString();
	}

	@Override
	public void merge(IOilObjectList ool, boolean doCopy) {
		for (int i=0; i<OBJECT_NUMBER; i++) {
			Set<ISimpleGenRes> tot = new LinkedHashSet<ISimpleGenRes>();
			tot.addAll(objectLists[i]);
			
			if (doCopy) {
				for (ISimpleGenRes sgr: ool.getList(i)) {
					if (!tot.contains(sgr)) {
						tot.add(sgr.clone());
					}
				}
				
			} else {
				tot.addAll(ool.getList(i));
			}
			setList(i, tot.toArray(new ISimpleGenRes[tot.size()]));
		}
		
	}

}