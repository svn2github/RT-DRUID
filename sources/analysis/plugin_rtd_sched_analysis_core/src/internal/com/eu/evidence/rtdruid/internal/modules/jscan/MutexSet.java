/*
 * Created on 22-mar-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.eu.evidence.rtdruid.internal.modules.jscan;

// project package


import java.util.ArrayList;
import java.util.Properties;

import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenRes;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenResList;

// exceptions

/** A List of Mutex stored at systemName/architectural/mutexList/*.
 * 
 *  @author  Nicola Serreli
 */
public class MutexSet extends GenResList {

	/** Abbreviation for VarTree.SEPARATOR */
	private final static char S = IVarTree.SEPARATOR;

	/**	Searchs all objects stored in given prefix and store them as a list of {@link GenRes GenRes}.
	*<br>
	*	@param	prefix	contains the name of current system
	*
	*	@throws NullPointerException if at least one of prefix and type is null
	*/
	public MutexSet(IVarTree vt, String prefix) {
		super(vt);
		if (prefix == null)
			throw new NullPointerException("Try to make a new GenRes list with a null prefix.");
		
		parametri = new Properties();

		// copy all prefix
		prefix = (prefix.startsWith("" + S) ? prefix : "" + S + prefix);
		prefissi = new String[1];
		prefissi[0] = DataPath.splitPath(prefix)[0];
		
		ITreeInterface ti = vt.newTreeInterface();

		String[] mutexName;
		elenco = new ArrayList[1];
		
		// get all Var names
		String tmpPref = prefix + S + "Architectural" + S + "MutexList";
		mutexName = ti.getAllName(tmpPref, "Mutex");
		elenco[0] = new ArrayList(mutexName.length);

		for (int i=0; i<mutexName.length; i++) {
			elenco[0].add( new Mutex(this, DataPath.removeSlash(mutexName[i]), tmpPref));
		}
	}

	/** A little mutex
	 *  @author  Nicola Serreli 
	 */
	public class Mutex extends GenRes {
		public Mutex(GenResList parent, String name, String prefix) {
			  super(parent, name, prefix);
		}
		
		protected boolean doStore(String key, Object o) {
			if ("Ceiling".equalsIgnoreCase(key) && o != null && "".equals("" + o)) {
				//return true;
				o =null;
			}
			return super.doStore(key, o);
		}
		
	}
}
