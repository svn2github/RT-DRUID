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
 * A class that collect standard commands to manage cache miss cost
 *  
 * @author Nicola Serreli  
 */
public class CacheMissCostCommon {
	
	private final static char S = DataPath.SEPARATOR;
	private final static DataPackage dpkg = DataPackage.eINSTANCE;
	
	
	/** Cache Miss Cost path */
	private final static String[] cacheMCTypePath = {
		dpkg.getSystem().getName(), // 0
		dpkg.getAnnotation().getName(), // 1
		dpkg.getAnnotation_CacheMissCostLists().getName(), // 2 
		dpkg.getCacheMissCostList().getName(), // 3
		dpkg.getCacheMissCostList_CacheMissCostItemsList().getName(), // 4
		dpkg.getCacheMissCost().getName(), // 5
//		dpkg.getExe().getName(),
		
	};
	
	private final IVarTree vt;
	private final ITreeInterface ti;
	private String modeRef = null;
	

	public CacheMissCostCommon(IVarTree vt) {
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
	 * this method searches the Cache Miss Cost of a specified Task
	 * 
	 * @return the Cache Miss Cost value or null if the Cache Miss Cost is not found. 
	 */
	public TimeVar getTaskCost(String taskName) {
		String sys = getSystemName();

		// search annotation
		String[] idList = { taskName, "TASK" };
		String tmpPath = sys + S + cacheMCTypePath[1] + S
				+ cacheMCTypePath[2] + S
				+ DataPath.makeSlashedId(modeRef) + S
				+ cacheMCTypePath[4] + S
				+ DataPath.makeSlashedId(idList);
		if (!ti.exist(tmpPath, cacheMCTypePath[5])) {
			tmpPath = sys + S + cacheMCTypePath[1] + S +cacheMCTypePath[2]
					+ S + DataPath.makeSlashedId((String) null) + S
					+ cacheMCTypePath[4] + S
					+ DataPath.makeSlashedId(idList);
			if (!ti.exist(tmpPath, cacheMCTypePath[5])) {
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
	 * this method stores the specified value as wcet of specified Task.
	 * 
	 * 
	 */
	public void setTaskCost(String taskName, TimeVar value) {
		String sys = getSystemName();

		// search annotation
		boolean buildPath = false;
		String[] idList = { taskName, "TASK" };
		String tmpPath = sys + S + cacheMCTypePath[1] + S
				+ cacheMCTypePath[2] + S
				+ DataPath.makeSlashedId(modeRef) + S
				+ cacheMCTypePath[4] + S
				+ DataPath.makeSlashedId(idList);
		if (!ti.exist(tmpPath, cacheMCTypePath[5])) {
			tmpPath = sys + S + cacheMCTypePath[1] + S +cacheMCTypePath[2]
					+ S + DataPath.makeSlashedId((String) null) + S
					+ cacheMCTypePath[4] + S
					+ DataPath.makeSlashedId(idList);
			if (!ti.exist(tmpPath, cacheMCTypePath[5])) {

				// make the path
				buildPath = true;
			}
		}
		if (buildPath) {
			ti.makePath(vt.newVarTreePointer(), tmpPath.split("" +S), cacheMCTypePath);
		}

		// set time to milli_seconds
		ti.setValue(tmpPath + S + "Worst", value);
	}
	
	/**
	 * this method searches the Cache Miss Cost of a specified Proc
	 * 
	 * @return the Cache Miss Cost value or null if the Cache Miss Cost is not found. 
	 */
	public TimeVar getProcCost(String procName) {
		String sys = getSystemName();

		// search annotation
		String[] idList = { procName, "PROC" };
		String tmpPath = sys + S + cacheMCTypePath[1] + S
				+ cacheMCTypePath[2] + S
				+ DataPath.makeSlashedId(modeRef) + S
				+ cacheMCTypePath[4] + S
				+ DataPath.makeSlashedId(idList);
		if (!ti.exist(tmpPath, cacheMCTypePath[5])) {
			tmpPath = sys + S + cacheMCTypePath[1] + S +cacheMCTypePath[2]
					+ S + DataPath.makeSlashedId((String) null) + S
					+ cacheMCTypePath[4] + S
					+ DataPath.makeSlashedId(idList);
			if (!ti.exist(tmpPath, cacheMCTypePath[5])) {
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
	public void setProcCost(String procName, TimeVar value) {
		String sys = getSystemName();

		// search annotation
		boolean buildPath = false;
		String[] idList = { procName, "PROC" };
		String tmpPath = sys + S + cacheMCTypePath[1] + S
				+ cacheMCTypePath[2] + S
				+ DataPath.makeSlashedId(modeRef) + S
				+ cacheMCTypePath[4] + S
				+ DataPath.makeSlashedId(idList);
		if (!ti.exist(tmpPath, cacheMCTypePath[5])) {
			tmpPath = sys + S + cacheMCTypePath[1] + S +cacheMCTypePath[2]
					+ S + DataPath.makeSlashedId((String) null) + S
					+ cacheMCTypePath[4] + S
					+ DataPath.makeSlashedId(idList);
			if (!ti.exist(tmpPath, cacheMCTypePath[5])) {

				// make the path
				buildPath = true;
			}
		}
		if (buildPath) {
			ti.makePath(vt.newVarTreePointer(), tmpPath.split("" +S), cacheMCTypePath);
		}

		// set time to milli_seconds
		ti.setValue(tmpPath + S + "Worst", value);
	}
}
