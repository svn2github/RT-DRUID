/*
 * $Id$
 */
package com.eu.evidence.rtdruid.vartree.abstractions.old;

// project package


import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.tools.Search;
import com.eu.evidence.rtdruid.vartree.tools.SearchObjects;

/**
 * 
 * This class contains cpu specific parameters
 * 
 */
public class Cpu extends ModeRes {
	
	
	/** type */
	public final static String SCHED_ACTIVATION_COST = "__scheduler_activation_cost";

	/** Priority */
	public final static String SCHED_TERMINATION_COST = "__scheduler_termination_cost";

	/** Period */
	public final static String SCHED_CONTEXT_SWITCH_COST = "__scheduler_context_switch_cost";


	private static final String et_WORST = S+DataPackage.eINSTANCE.getExecTime_Worst().getName();
//	private static final String cc_WORST = S+DataPackage.eINSTANCE.getCacheMissCost_Worst().getName();

	private static final String[][] annotation = {
		{ SCHED_ACTIVATION_COST, Search.OS_ACTIVATE_TASK , et_WORST }, 
		{ SCHED_TERMINATION_COST, Search.OS_TERMINATE_TASK, et_WORST },
		{ SCHED_CONTEXT_SWITCH_COST, Search.OS_CONTEXT_SWITCH, et_WORST}
	};
	
	
	
	private String sys;


	public Cpu(GenResList parent, String name, String prefix, String modeRef) {
		super(parent, name, prefix, modeRef);
		sys = "" + S + (DataPath.splitPath(pref))[0];
	}

	public Cpu(GenResList parent, String name, String prefix) {
		super(parent, name, prefix);
		sys = "" + S + (DataPath.splitPath(pref))[0];
	}

	/**
	 * Used to add one or more dynamic sublevel in the path of a property. es.
	 * &lt;path of current element&gt &lt;dynamic nodes&gt; &lt;path stored in
	 * the parent GenResList&gt
	 */
	protected String getPath(String what) {

		// Annotation
		
		for (int i = 0; i < annotation.length; i++) {
			if (annotation[i][0].equalsIgnoreCase(what)) {
				String base = Search.anExecTime(ti, sys, 
						SearchObjects.osMethodFullName(nome, nome, annotation[i][1]), "OS-METHOD",
						modeRef); 
				return base == null? null : base + S + annotation[i][2];
			}
		}


		return getPath() + S + padre.getProperty(what);
	}
	

	protected boolean doStore(String key, Object o) {


		for (int i = 0; i < annotation.length; i++) {
			if (annotation[i][0].equalsIgnoreCase(key)) {

				String[] tmp = {
						SearchObjects.osMethodFullName(nome, nome, annotation[i][1]), "OS-METHOD" };

				String firstPrefix = sys + S + "Annotation" + S
						+ "ExecTimeLists";
				String first = firstPrefix + S
						+ DataPath.makeSlashedId(modeRef);
				String secondPrefix = first + S + "ExecTimeItemsList";
				String second = secondPrefix + S + DataPath.makeSlashedId(tmp);

				try {
					if (!ti.exist(sys + S + "Annotation", "Annotation")) {
						ti.addElement("Annotation", "Annotation", sys);
					}
					if (!ti.exist(first, "ExecTimeList")) {
						ti.addElement(modeRef, "ExecTimeList", firstPrefix);
					}

					if (!ti.exist(second, "ExecTime")) {
						ti.addElement(DataPath.makeId(tmp), "ExecTime",
								secondPrefix);
						// set task name and type (not useful: already set by
						// addElement->setID)
						//ti.setValue(second + S + "Ref",
						// Utility.pathToEvidence(DataPath.addSlash(nome)));
						//ti.setValue(second + S + "Type", "TASK");
					}
				} catch (ITreeInterface.AddElementException e) {
					e.printStackTrace();
					return false;
				}

				return super.doStore(key, o);
			}
		}

		return super.doStore(key, o);
	}


}

