package com.eu.evidence.rtdruid.vartree.abstractions.old;

// project package

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Properties;

import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/** Contains a list of objects with the same prefix and type.
*	Each object is described by {@link GenRes GenRes}
*<br> N.B. name of properties are all set as Lower Case
*
* @author  Giuseppe Lipari && Nicola Serreli
*/
public class GenResList {
	/** All suffix */
	protected Properties parametri;
	
	/** The list of prefix */
	protected String[] prefissi;

	/** All objects */
	protected ArrayList<GenRes>[] elenco;

	/** The current data repository */
	protected IVarTree vt;
	
	/**
	*/
	protected GenResList(IVarTree vt) { this.vt = vt; }
	
	/**	Searchs all objects stored in given prefix and store them as a list of {@link GenRes GenRes}.
	*<br>
	*	@param vt current data repository
	*	@param	prefix	contains all path in witch look for "Objects" containers.
	*	@param	type	type of required objects
	*	@throws NullPointerException if at least one of prefix and type is null
	*/
	public GenResList(IVarTree vt, String[] prefix, String type) {
		if (vt == null) { 
			throw new NullPointerException("Try to make a new GenRes list without a data repository.");
		}
		if (prefix == null) {
			throw new NullPointerException("Try to make a new GenRes list with a null prefix.");
		}
		if (type == null) {
			throw new NullPointerException("Try to make a new GenRes list with a null type.");
		}
		if (prefix.length ==0) {
			throw new IllegalArgumentException("Try to make a new GenRes list with a void prefix.");
		}
		
		this.vt = vt;
		
		parametri = new Properties();

		// copy all prefix
		prefissi = new String[prefix.length];
		for (int i=0; i< prefix.length; i++) {
			String tp = prefix[i];
			prefissi[i] = (tp == null ? "" + DataPath.SEPARATOR : ( tp.startsWith("" + DataPath.SEPARATOR) ? tp : "" + DataPath.SEPARATOR + tp) );
		}
		
		
		ITreeInterface ti = vt.newTreeInterface();

		int pNum = prefissi.length;
		String[] taskName;
		elenco = new ArrayList[pNum];
		
		// get all Task names
		for (int j =0; j< pNum; j++) {
			taskName = ti.getAllName(prefissi[j], type);
			elenco[j] = new ArrayList<GenRes>(taskName.length);

			for (int i=0; i<taskName.length; i++) {
				elenco[j].add(  makeNewElement( DataPath.removeSlash(taskName[i]), prefissi[j]));
			}
		}
	}
	
	/** Makes a new GenRes Element.
	 * <br> A subclass could overwrite this method to use different GenRes's subclass
	 * 
	 * */
	protected GenRes makeNewElement(String name, String prefix) {
		return new GenRes(this, name, prefix); 
	}
	
	/** Returns the number of distinct prefix (cpuId)
	*
	*	@return  the number of distinct prefix (cpuId)
	*/
	public int       getPrefixNumber()              {   return elenco.length;          }

	/** Returns the prefix given its index
	*
	*	@param	cpuId	identifies the prefix, in the list of prefix given to constructor
	*
	*	@return  the prefix
	*
	*	@throws	IndexOutOfBoundsException if cpuId index is either negative or greater than or equal to the number of prefix stored. 
	*/
	public String    getPrefix(int cpuId)        {   return prefissi[cpuId];   }

	/** Returns the index given its prefix
	*
	*	@param	prefix	the prefix
	*
	*	@return  the index that identifies the given prefix
	*
	*	@throws NoSuchElementException if given prefix wasn't given to constructor
	*/
	public int       getIndex(String prefix)     {
		for (int i=0; i<prefissi.length; i++) {
			if (prefissi[i]==null) {
				if (prefix == null) {
					return i;
				}
			} else {
				if (prefissi[i].equals(prefix)) {
					return i;
				}
			}
		}
		// not found
		throw new NoSuchElementException("Try to get the index of an non-existent prefix (" + prefix + ")");
	}

	/** Returns the number of task found in specified prefix
	*
	*	@param	prefixId	identifies the prefix, in the list of prefix given to contructor
	*
	*	@return  the number of task found in specified prefix
	*
	*	@throws	IndexOutOfBoundsException if cpuId index is either negative or greater than or equal to the number of prefix stored. 
	*/
	public int       getSize(int prefixId)          {   return elenco[prefixId].size();   }
	
	/** Returns the description of a task found in specified prefix
	*
	*	@param	prefixId	identifies the prefix, in the list of prefix given to contructor
	*	@param	pos		identifies the task from others in the same prefix
	*
	*	@return  the description
	*
	*	@throws	IndexOutOfBoundsException if one of "cpuId" or "pos" index is either negative or greater than or equal to the number of prefix stored. 
	*/
	public GenRes getItem(int prefixId, int pos) {   return (GenRes) elenco[prefixId].get(pos); }

	/** Returns all descriptions of a task found in specified prefix
	*
	*	@param	prefixId	identifies the prefix, in the list of prefix given to contructor
	*
	*	@return  all descriptions
	*
	*	@throws	IndexOutOfBoundsException if cpuId index is either negative or greater than or equal to the number of prefix stored. 
	*/
	public GenRes[] getAllItem(int prefixId)     {   return (GenRes[]) elenco[prefixId].toArray(new GenRes[0]); }

	/** Returns the position of an object in the given prefix
	*
	*	@param	prefixId	the prefix
	*	@param	name	the object's name 
	*
	*	@return  the index that identifies the given prefix, or -1 if not found
	*/
	public int       getIndex(int prefixId, String name)     {
		for (int i=0; i<elenco[prefixId].size(); i++) {
			if (((GenRes) elenco[prefixId].get(i)).getName().equals(name)) {
				return i;
			}
		}
		// not found
		return -1;
	}
	
	
	/** Tries to get a new property to all objects (or to change the suffix of an older one)
	*
	*
	*	@return the older value or null if there wasn't one
	*/
	public String setProperty(String name, String suffix, boolean required) {
		if (suffix == null)
			throw new IllegalArgumentException("Try to set a null property.");
		name = name.toLowerCase();
		String tmp = (String) parametri.setProperty(name, suffix);
		
		// update all objects
		for (int j =0; j< elenco.length; j++) {
			for (int i=0; i<elenco[j].size(); i++) {
				((GenRes) elenco[j].get(i)).load(name, required);
			}
		}
		return tmp;
	}
	
	/** Tries to get a the value (suffix) of an already stored property.
	*
	*	@return the value or null if there wasn't one
	*/
	public String getProperty(String name) {
		return parametri.getProperty(name.toLowerCase());
	}
		
		
	/**
	*/
	public void setSave(boolean value) {
		for (int j =0; j< elenco.length; j++) {
			for (int i=0; i<elenco[j].size(); i++) {
				((GenRes) elenco[j].get(i)).setSave(value);
			}
		}
	}
	

	/**
	 * Return the current data repository
	 *
	 */
	public IVarTree getVarTree() {
		return vt;
	}

}

