/*
 * Created on 5-sept-2008
 *
 * $Id: WcetCommon.java,v 1.1 2008/09/15 14:02:26 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.tools;

import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;


/**
 * A class that collect standard commands to manage wcets
 *  
 * @author Nicola Serreli  
 */
public class WcetCommon {
	
	private final static char S = DataPath.SEPARATOR;
	private final static DataPackage dpkg = DataPackage.eINSTANCE;
	
	
	private final static String[] wcetTypePath = {
		dpkg.getSystem().getName(),
		dpkg.getAnnotation().getName(),
		dpkg.getAnnotation_ExecTimeLists().getName(),
		dpkg.getExecTimeList().getName(),
		dpkg.getExecTimeList_ExecTimeItemsList().getName(),
		dpkg.getExecTime().getName(),
//		dpkg.getExe().getName(),
		
	};
	
	private final IVarTree vt;
	private final ITreeInterface ti;
	private String modeRef = null;
	

	public WcetCommon(IVarTree vt) {
		this.vt = vt;
		this.ti = vt.newTreeInterface();
	}

	public void setModeRef(String modeRef) {
		this.modeRef = modeRef;
	}
	
	protected String getSystemName() {
		IVarTreePointer vtp = vt.newVarTreePointer();
		if (vtp.goFirstChild())
			return vtp.getName();
			
		return null;
	}
	
	
	/**
	 * this method searches the wcet of a specified Proc
	 * 
	 * @return the wcet value or null if the wcet is not found. 
	 */
	public TimeVar getProcWcet(String procPath, String procName) {
		String sys = getSystemName();

		// search annotation
		String[] idList = { procName, "PROC" };
		String tmpPath = sys + S + "Annotation" + S
				+ "ExecTimeLists" + S
				+ DataPath.makeSlashedId(modeRef) + S
				+ "ExecTimeItemsList" + S
				+ DataPath.makeSlashedId(idList);
		if (!ti.exist(tmpPath, "ExecTime")) {
			tmpPath = sys + S + "Annotation" + S + "ExecTimeLists"
					+ S + DataPath.makeSlashedId((String) null) + S
					+ "ExecTimeItemsList" + S
					+ DataPath.makeSlashedId(idList);
			if (!ti.exist(tmpPath, "ExecTime")) {
				// no annotation about this method.
				// Is it a good thing?
				return null; // next method ref
			}
		}

		// set time to milli_seconds
		IVariable var = ti.getValue(tmpPath + S + "Worst");
		if (var instanceof TimeVar && var != null) {
			return ((TimeVar) var);
		} /// else 
			
		return null;
	}
	
	/**
	 * this method stores the specified value as wcet of specified Proc.
	 * 
	 * 
	 */
	public void setProcWcet(String procPath, String procName, TimeVar value) {
		String sys = getSystemName();

		// search annotation
		boolean buildPath = false;
		String[] idList = { procName, "PROC" };
		String tmpPath = sys + S + "Annotation" + S
				+ "ExecTimeLists" + S
				+ DataPath.makeSlashedId(modeRef) + S
				+ "ExecTimeItemsList" + S
				+ DataPath.makeSlashedId(idList);
		if (!ti.exist(tmpPath, "ExecTime")) {
			tmpPath = sys + S + "Annotation" + S + "ExecTimeLists"
					+ S + DataPath.makeSlashedId((String) null) + S
					+ "ExecTimeItemsList" + S
					+ DataPath.makeSlashedId(idList);
			if (!ti.exist(tmpPath, "ExecTime")) {
				// make the path
				buildPath = true;
			}
		}
		if (buildPath) {
			ti.makePath(vt.newVarTreePointer(), tmpPath.split("" +S), wcetTypePath);
		}

		// set time to milli_seconds
		ti.setValue(tmpPath + S + "Worst", value);
	}
}
