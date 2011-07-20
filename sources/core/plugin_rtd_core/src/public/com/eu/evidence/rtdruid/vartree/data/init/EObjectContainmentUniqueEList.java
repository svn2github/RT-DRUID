/*
 * Created on May 7, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.eu.evidence.rtdruid.vartree.data.init;



import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

import com.eu.evidence.rtdruid.vartree.data.ObjectWithID;


/**
 * @author durin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
@SuppressWarnings("serial")
public class EObjectContainmentUniqueEList<E> extends EObjectContainmentEList<E> {
	
	public static int cont = 0;
	
	/** Contains the map to all objects, except for "new objects" (unused and without ID) */
	HashMap<String, Integer> fastSearch = new HashMap<String, Integer>();
	/** Contains the map to all objects that are only created but never used and without any ID */
	HashMap<E, Integer> fastSearch_nullID = new HashMap<E, Integer>();
	public static int count_add = 0;
	public static int count_set = 0;
	public static int count_remove = 0;
	public static int count_contains = 0;
	public static int count_index = 0;
	public static int count_index_by = 0;

	final static boolean use_fast_code = true;

	public EObjectContainmentUniqueEList(Class<?> dataClass, InternalEObject owner, int featureID) {
		super(dataClass, owner, featureID);
 		cont ++;
    	//System.err.println(this.getClass().getName() + " creata numero " + cont + "");
	}

//	protected HashMap<String, Integer> getFastSearch() {
//		return fastSearch;
//	}
//	protected HashMap<String, Integer> getFastSearch_nullID() {
//		return fastSearch;
//	}
	
	public boolean isUnique() {
		return true;
	}
	
	/** if set to false, all not work !!
	 * */
	public boolean useEquals() {
		return true;
	}
	
	protected void updateFastAdd(E newObject, Integer index, boolean use_null_map) {
		if (use_null_map){
			fastSearch_nullID.put(newObject, index);
		} else {
			String ID = ((ObjectWithID) newObject).getObjectID();
			fastSearch.put(ID, index);
		}
	}

	protected void updateFastRemove(E oldObject, String oldID, boolean use_null_map) {
		if (use_null_map){
			fastSearch_nullID.remove(oldObject);
		} else {
			fastSearch.remove(oldID);
		}
	}

	protected void updateFastRemove(E oldObject, boolean use_null_map) {
		if (use_null_map){
			fastSearch_nullID.remove(oldObject);
		} else {
			String ID = ((ObjectWithID) oldObject).getObjectID();		
			fastSearch.remove(ID);
		}
	}

	@Override
	protected void didAdd(int index, E newObject) {
		super.didAdd(index, newObject);
		
		if (newObject != null) {
			updateFastAdd(newObject, new Integer(index), ((ObjectWithID) newObject).isNew_object());
		}
		count_add++;
	}
	
	@Override
	protected void didSet(int index, E newObject, E oldObject) {
		super.didSet(index, newObject, oldObject);
		
		// update hashMaps
		
		if (newObject != null) {
			updateFastAdd(newObject, new Integer(index), ((ObjectWithID) newObject).isNew_object());
		}
		if (oldObject != null) {
			updateFastRemove(oldObject,((ObjectWithID) oldObject).isNew_object());
		}
		count_set++;
	}
	
	@Override
	protected void didRemove(int index, E oldObject) {
		super.didRemove(index, oldObject);
		
		if (oldObject != null) {
			
			updateFastRemove(oldObject,((ObjectWithID) oldObject).isNew_object());
			
			for (Entry<String, Integer> entry : fastSearch.entrySet()) {
				int v = entry.getValue().intValue(); 
				if (v > index) {
					entry.setValue(new Integer(v-1));
				}
			}
			for (Entry<E, Integer> entry : fastSearch_nullID.entrySet()) {
				int v = entry.getValue().intValue(); 
				if (v > index) {
					entry.setValue(new Integer(v-1));
				}
			}
			
		}
		count_remove++;
	}

	/** This function is called every time an object changes its ID */
	public void updateID(E object, String oldID, String newID) {
		
		Integer index;
		boolean was_null = ((ObjectWithID) object).isNew_object();
		if (was_null) {
			index = fastSearch_nullID.get(object);
		} else {
			index = fastSearch.get(oldID);
		}
		
		if (index != null) {
			updateFastRemove(object, oldID, was_null);

			fastSearch.put(newID, new Integer(index));
		}
		
		if (false) {
			
			/* IMPORTANT: This "Slow down" is required to solve a problem with emf clipboard commands */
			boolean use_slow = !(owner!= null && owner.eResource() != null);
			if (use_slow && object != null) {

				for (int i=0; i< super.size; i++) {
					if (super.data[i] == object) {

						fastSearch.put(newID, i);
						break;
					}
				}

			}
		}
	}

	public boolean contains(Object o ) {
		boolean risp = false;
		count_contains++;
		
		
		if (o instanceof String) {
			/** If it's a string, can be only an ID */
			risp = fastSearch.containsKey(o);
			
		} else if (o instanceof ObjectWithID && dataClass.isInstance(o) ){
			
			ObjectWithID owID = ((ObjectWithID) o);
			
			/** If this object is new, I have to use "null map" otherwise use fast_map */
			if (owID.isNew_object()) {
				risp = fastSearch_nullID.containsKey( o );
			} else {
				String key = ((ObjectWithID) o).getObjectID();
				risp = fastSearch.containsKey( key );
			}
		} else {
			// nothing
		}
		
		
		
		// ----------------------------
		if (false) {
		
		/* IMPORTANT: This "Slow down" is required to solve a problem with emf clipboard commands */
		boolean use_slow = !(owner!= null && owner.eResource() != null);
		
		if (use_fast_code && !use_slow) { // new code

			if (o instanceof String) {
				risp = fastSearch.containsKey(o);
				
			} else if (o instanceof ObjectWithID){
				String key = ((ObjectWithID) o).getObjectID();
				risp = fastSearch.containsKey( key );
			} else {
				// nothing
			}


		} else { // old code
			
		
		for (int i=0; i< super.size && !risp; i++) {
			if (super.data[i] == null && o == null) {
				risp = true;
			} else if (super.data[i] instanceof ObjectWithIDImpl
					&& owner!= null && owner.eResource() != null) {
				risp = ((ObjectWithIDImpl) super.data[i]).equalsByID(o);
			} else {
				risp = super.data[i].equals(o);
			}
		}
		
		}
		}
		return risp;
	}

	public int indexOf(Object o ) {
		count_index++;

		if (use_fast_code) { // new code

			Integer v = null;
			
			if (o instanceof String) {
				v = fastSearch.get(o);
				
			} else if (o instanceof ObjectWithID && dataClass.isInstance(o)){
				ObjectWithID owID = ((ObjectWithID) o);

				/** If this object is new, I have to use "null map" otherwise use fast_map */
				if (owID.isNew_object()) {
					v = fastSearch_nullID.get( o );
				} else {
					String key = ((ObjectWithID) o).getObjectID();
					v = fastSearch.get( key );
				}
			} else {
				// nothing
			}
			return v == null ? -1 : v.intValue();


		} else { // old code

		for (int i=0; i< super.size; i++) {
			if (super.data[i] == null && o == null) {
				return i;
				
			} else if (super.data[i] instanceof ObjectWithIDImpl
					&& owner!= null && owner.eResource() != null) {
				if (((ObjectWithIDImpl) super.data[i]).equalsByID(o))
					return i;
				
			} else {
				if ( super.data[i].equals(o))
					return i;
			}
		}
		
		}
		return -1;
	}

	public int indexOfById(Object o ) {
		count_index_by++;
		
		if (true) {
			// use the same code of indexOf
			return indexOf(o);
			
		}

		if (use_fast_code) { // new code

			
			Integer v = null;
			
			if (o instanceof String) {
				v = fastSearch.get(o);
				
			} else if (o instanceof ObjectWithID && dataClass.isInstance(o)){
				String key = ((ObjectWithID) o).getObjectID();
				v = fastSearch.get( key );
			} else {
				// nothing
			}
			return v == null ? -1 : v.intValue();

		} else { // old code

		for (int i=0; i< super.size; i++) {
			if (super.data[i] == null && o == null) {
				return i;
				
			} else if (super.data[i] instanceof ObjectWithIDImpl) {
				if (((ObjectWithIDImpl) super.data[i]).equalsByID(o))
					return i;
				
			} else {
				if ( super.data[i].equals(o))
					return i;
			}
		}
		}
		return -1;
	}

	
    protected void  finalize() {
    	cont --;
    	//System.err.println(this.getClass().getName() + " eliminata (altre " + cont + ")");
		for (int i=0; i< super.size ; i++) {
			super.data[i] = null;
		}
    }

}
