/*
 * Created on 10-mar-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.eu.evidence.rtdruid.vartree.abstractions.old;


import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.tools.Utility;


/**
 *  @author  Nicola Serreli
 */
public class ModeResList extends GenResList {
	private String mode;

	protected ModeResList(IVarTree vt) {
		super(vt);
		mode = Utility.DEFAULT_MODE;
	}
	protected ModeResList(IVarTree vt, String modeRef) {
		super(vt);
		mode = modeRef;
	}
	
	public ModeResList(IVarTree vt, String[] prefix, String what, String modeRef) {
		super(vt, prefix, what);
		mode = modeRef;
	}

	protected GenRes makeNewElement(String name, String prefix) {
		return new ModeRes(this, name, prefix, mode); 
	}
	
	public String getMode() { return mode; }
}
