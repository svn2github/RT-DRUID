/*
 * Created on 10-mar-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.eu.evidence.rtdruid.vartree.abstractions.old;

// projects package
import com.eu.evidence.rtdruid.vartree.tools.Utility;

// standard java package

// exceptions

/** This class adds to GenRes the information about mode 
 * @author  Nicola Serreli
 */
public class ModeRes extends GenRes {
	protected String modeRef;
	
	public ModeRes(GenResList parent, String name, String prefix) {
		super(parent, name, prefix);
		modeRef = Utility.DEFAULT_MODE;
	}
	
	public ModeRes(GenResList parent, String name, String prefix, String mode) {
		super(parent, name, prefix);
		modeRef = mode;
	}	
	// ----------------------------------

	/**
	 *  Sets the mode used in the mapping.
	 * 
	 *  @param moderef the new mode
	 * 
	 *  @return the old mode name
	 * 
	 *   @throws NullPointerException if moderef is null
	 * */
	public String setMode(String moderef) {
		if (moderef == null) {
			throw new NullPointerException("Required a not null Mode name");
		}
		String tmp = modeRef;
		modeRef = moderef;
		return tmp; 
	}

	/**
	 *  Gets the mode used in the mapping.
	 * 
	 *  @return the name of current mode
	 * */
	public String getMode() {
		return modeRef; 
	}
	
	/**
	 * Checks if the specified mode exists. 
	 * If so, then retreive the object specified by path; otherwise, use the default mode.
	 * @param path the object to retreive.
	 * @return
	 */
	protected String chooseModeRef(String path) {
		return  chooseModeRef(path, new String[1], 0);
	}

	/**
	 * Helper function of chooseModeRef.
	 * 
	 * @param path       absolute path to the object
	 * @param prefix     part of the mode string specification
	 * @param modeIndex  index of the part of the string "prefix" that contains the name of the mode
	 * @return
	 */
	protected String chooseModeRef(String path, String[] prefix, int modeIndex) {
		return Utility.chooseModeRef(padre.getVarTree().newTreeInterface(), path, prefix, modeIndex, modeRef);
	}
}
