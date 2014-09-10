/*
 * $Id: Task.java,v 1.4 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.abstractions.old;

// project package


import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.tools.CacheMissCostCommon;
import com.eu.evidence.rtdruid.vartree.tools.Mapping;
import com.eu.evidence.rtdruid.vartree.tools.Search;
import com.eu.evidence.rtdruid.vartree.tools.Utility;
import com.eu.evidence.rtdruid.vartree.tools.WcetCommon;
import com.eu.evidence.rtdruid.vartree.variables.TimeMVar;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

/**
 * Add resources to common GenRes
 * 
 * This class models a real-time task (cyclic or sporadic)
 * 
 * @author Giuseppe Lipari && Nicola Serreli
 * @version 0.3
 */
public class Task extends ModeRes {

	protected final static DataPackage DPKG = DataPackage.eINSTANCE;
	
	public static class ProcData {
		private final String name;
		private int position;
		private int onceEveryK;
		
		private HashMap<String, Object> tempProperties = new HashMap<String, Object>();
		
		public ProcData(String name) {
			this.name = name;
		}
		
		public void setOnceEveryK(int onceEveryK) {
			this.onceEveryK = onceEveryK;
		}
		
		public void setPosition(int position) {
			this.position = position;
		}
		
		public String getName() {
			return name;
		}
		
		public int getOnceEveryK() {
			return onceEveryK;
		}
		
		public int getPosition() {
			return position;
		}
		
		@Override
		public String toString() {
			return "{Proc " + name + ", pos " + position + " every " + onceEveryK + "}";
		}

		public void setProperty(String key, Object value) {
			tempProperties.put(key, value);
		}
		
		public Object getProperty(String key) {
			return tempProperties.get(key);
		}
	}
	
	
	public final static int COMMON_TIME_TYPE = TimeVar.MILLI_SECOND;

	/** task type (task, isr) */
	public final static String STR_TASK_TYPE = "task_type";

	/** activation type (periodic, sporadic) */
	public final static String STR_ACT_TYPE = "act_type";

	/** Priority */
	public final static String STR_PRIORITY = "priority";

	/** Period */
	public final static String STR_PERIOD = "period";
	/** Offset */
	public final static String STR_OFFSET = "offset";

	/** List of all resources */
	public final static String STR_RESOURCE_LIST = "resource";

	/** Maximum number of activation at the same time */
	public final static String STR_ACT_NUMBER = "actNumber";

	/** All mapped procs ( ArrayList of ProcData )*/
	public final static String STR_PROC_LIST = "proc_list";
	
	/** A class to easily handle the wcet of a task (IGenericMultiframeTaskWcet) */
	public final static String STR_GENERIC_WCET = "generic_wcet";

	/** The cost of a preemption of this task */
	public final static String STR_TASK_PREEMPTION_COST = "task_preemption_cost";

	/** wcet */
	public final static String STR_WCET = "wcet";
	
	/** Cache miss cost */
	public final static String STR_CACHE_MISS_COST = "cache_miss_cost";
	
	/** Response time */
	public final static String STR_RESPONSE_TIME = "ResponseTime";
	

	/**
	 * Association btw resource name and WCET
	 */
	private HashMap<String, Double> resources;

	/** used to store the order of insertion of all resources */
	private ArrayList<String> resNames;

	private String sys;

	private String rtosName;

	private Color color;

	private boolean wcet_is_computed = false;

	public Task(GenResList parent, String name, String prefix, String modeRef,
			String RTOS) {
		super(parent, name, prefix, modeRef);

		rtosName = RTOS;
		resources = new HashMap<String, Double>();
		resNames = new ArrayList<String>();
		sys = "" + S + (DataPath.splitPath(pref))[0];
	}

	public Task(GenResList parent, String name, String prefix, String RTOS) {
		super(parent, name, prefix);

		rtosName = RTOS;
		resources = new HashMap<String, Double>();
		resNames = new ArrayList<String>();
		sys = "" + S + (DataPath.splitPath(pref))[0];
	}

	/**
	 * Used to add one or more dynamic sublevel in the path of a property. es.
	 * &lt;path of current element&gt &lt;dynamic nodes&gt; &lt;path stored in
	 * the parent GenResList&gt
	 */
	protected String getPath(String what) {

		// Scheduling && Activation List
		String[][] modeRefList = { { "Priority", "SchedulingList" },
				{ "Blocking", "SchedulingList" },
				{ "Threshold", "SchedulingList" },
				{ "Stack", "SchedulingList" },
				{ "PreemptionGroupName", "SchedulingList" },

				{ STR_ACT_TYPE, "Type", "ActivationList" },
				{ "ActNumber", "ActivationList" },
				{ "ActivationClass", "ActivationList" },
				{ "Class", "ActivationList" }, { "Period", "ActivationList" },
				{ "Offset", "ActivationList" },
				{ "Deadline", "ActivationList" } };
		for (int i = 0; i < modeRefList.length; i++) {
			if (modeRefList[i][0].equalsIgnoreCase(what)) {
				int delta = modeRefList[i].length - 2;
				return chooseModeRef(getPath() + S + modeRefList[i][1+delta]) + S
						+ modeRefList[i][0+delta];
			}
		}

		
		if (what.equalsIgnoreCase(STR_TASK_TYPE)) {
			return getPath()+S+DPKG.getTask_Type().getName();
		}
		
		// CPU id
		if (what.equalsIgnoreCase("cpuId")) {
			String[] tmp = { nome, modeRef };
			return chooseModeRef(sys + S + "Mapping" + S + "TaskMapList", tmp,
					1)
					+ S + "cpuRef";
		}

		// Annotation
		String[][] annotation = { { "wcet", "Worst" }, { "Best", "Best" },
				{ "DistributionType", "Distribution" + S + "Type" },
				{ "DistributionAvg", "Distribution" + S + "Avg" },
				{ "DistributionVariance", "Distribution" + S + "Variance" } };
		for (int i = 0; i < annotation.length; i++) {
			if (annotation[i][0].equalsIgnoreCase(what)) {
				return Search.anExecTime(ti, sys, Utility
						.pathToEvidence(nome), "TASK",
//						.pathToEvidence(DataPath.addSlash(nome)), "TASK",
						modeRef)
						+ S + annotation[i][1];
			}
		}

		// Schedulability
		String[][] schedulability = { { "Utilization", "Utilization" },
				{ "CDelta", "CDelta" }, { "TDelta", "TDelta" },
				{ "ResponseTime", "ResponseTime" },
				{ "Schedulable", "Schedulable" } };
		for (int i = 0; i < schedulability.length; i++) {
			if (schedulability[i][0].equalsIgnoreCase(what)) {
				//boolean aper = ("aperiodic").equalsIgnoreCase((String)
				// prop.get("type"));

				// search required node ...
				// ... first SchedulingScenario node
				String ttpref = sys;
				String ttnew = "Schedulability";
				if (!ti.exist(ttpref + S + ttnew, "Schedulability")) {
					return null;
				}

				ttpref += S + ttnew + S + "SchedulingScenarioList"; // sys +
																	// sched +
																	// list
				ttnew = modeRef;
				String stnew = DataPath.makeSlashedId(modeRef);
				if (!ti.exist(ttpref + S + stnew, "SchedulingScenario")) {
					return null;
				}

				ttpref += S + stnew + S + "TaskSchedList"; // sys + sched + list
														   // + scenario +
														   // taskList
				ttnew = Utility.pathToEvidence(nome); //DataPath.addSlash(nome));
				stnew = DataPath.makeSlashedId(ttnew);
				if (!ti.exist(ttpref + S + stnew, "TaskSched")) {
					return null;
				}

				return sys + S + "Schedulability" + S
						+ "SchedulingScenarioList" + S
						+ DataPath.makeSlashedId(modeRef) + S + "TaskSchedList"
						+ S + stnew + S + schedulability[i][1];

			}
		}

		return getPath() + S + padre.getProperty(what);
	}

	/**
	 * Adds or update a property
	 * 
	 * TODO should be refactored (delegate to anothe class)
	 * @return false if there was an error
	 */
	public boolean load(String name, boolean required) {
		
		if (STR_PROC_LIST.equals(name) || STR_GENERIC_WCET.equals(name)) {
			return loadProcs(name, required);
		}
		

		// check for aperiodic Tasks
		if (("aperiodic").equalsIgnoreCase((String) prop.get(STR_ACT_TYPE))) {
			String[] disabled = { "period", "wcet", "deadline", "offset",
					"priority", "ResponseTime", "PreemptionGroupName",
					"blocking", "schedulable", "utilization", "cDelta" };

			// search if this property is disabled
			for (int i = 0; i < disabled.length; i++) {
				if (disabled[i].equalsIgnoreCase(name)) {
					String path = getPath(name);
					// set a void value
					if (path == null || !ti.exist(path, null)) {
						prop.put(name, "");
						return true;
					}
					// continue with normal methods
					break;
				}
			}
		}

		// disable errors for "schedulability"
		//if (rtosName.equalsIgnoreCase(TaskSet.NOT_MAPPED)) {
		{
			String[] schedulability = { "Utilization", "CDelta", "TDelta",
					"ResponseTime", "Schedulable" };
			for (int i = 0; i < schedulability.length; i++) {
				if (schedulability[i].equalsIgnoreCase(name)) {

					String path = getPath(name);
					// set a void value
					if (path == null || !ti.exist(path, null)) {
						prop.put(name, "");
						return true;
					}
				}
			}
		}

		// The list of Vars
		if (("Resource").equalsIgnoreCase(name)) {
			computeResources(nome, padre.getVarTree(), modeRef, resources, resNames);

			/*
			 * // look over each method ref String[] resourceRef =
			 * ti.getAllName(tmpPref, "ResourceRef"); for (int i=0; i
			 * <resourceRef.length; i++) {
			 * 
			 * if (!ti.exist(tmpPref + S + resourceRef[i] + S + "MethodRef",
			 * DataPath.STRING_TYPE) ) continue; // no data !!!!! String
			 * methName= (String) ti.getValue(tmpPref + S + resourceRef[i] + S +
			 * "MethodRef").get(); if (methName == null ||
			 * ("").equals(methName)) continue; // no resource or method name
			 *  // search the resource String resPath =
			 * Search.aResourceMethod(sys, methName); if (resPath == null) {
			 * Messages.sendWarning("Required a resource with '"+methName+"'
			 * method by Task '"+nome+"", null, "Task", null); continue; //
			 * Warning !!! }
			 * 
			 * String[] idList2 = {modeRef}; String tmpPath =
			 * Utility.chooseModeRef(resPath + S + "MutexRefList", idList2, 0,
			 * modeRef);
			 * 
			 * if (tmpPath == null || !ti.exist(tmpPath + S + "MutexName",
			 * DataPath.STRING_TYPE)) { continue; // no mapping to mutex }
			 * 
			 * String mutexName = (String) ti.getValue(tmpPath + S +
			 * "MutexName").get(); if (mutexName == null) { continue; // no
			 * mutex name }
			 *  // check for mutex tmpPath = sys + S + "Architectural" + S +
			 * "MutexList" + S + VarTree.addSlash(mutexName); if
			 * (!ti.exist(tmpPath, "Mutex")) { // no annotation about this
			 * method. // Is it a good thing? Messages.sendWarning("Mutex not
			 * found: "+mutexName+", required by task " + nome, null, "Task",
			 * null); continue; // next method ref }
			 *  // search annotation String[] idList3 = {methName,
			 * "RESOURCE_METHOD", modeRef}; tmpPath = Utility.chooseModeRef(sys +
			 * S + "Annotation", idList3, 2, modeRef); if (!ti.exist(tmpPath,
			 * "ExecTime")) { // no annotation about this method. // Is it a
			 * good thing? Messages.sendWarning("Not found ExecTime for
			 * '"+methName+"' method, required by task " + nome , null, "Task",
			 * null); continue; // next method ref }
			 *  // set time to milli_seconds IVariable var = ti.getValue(tmpPath +
			 * S + "Worst"); if (var instanceof TimeVar) { ((TimeVar)
			 * var).setType(COMMON_TIME_TYPE); } else if (var instanceof
			 * TimeMVar) { ((TimeMVar) var).setType(COMMON_TIME_TYPE); }
			 * Double time = (Double) var.get(); if (time == null) continue; //
			 * no value, next method ref
			 * 
			 * if (getResourceUsage(mutexName) < time.doubleValue()) {
			 * useResource(mutexName, time.doubleValue()); } // next method ref } }
			 *  }
			 */
			name = name.toLowerCase();
			prop.put(name, Collections.list(getAllResources()));

			return true;
		}

		if (("wcet").equalsIgnoreCase(name)) {
			double valore = 0.0;

			WcetCommon wcetManager = new WcetCommon(padre.getVarTree());

			// there is a mapping between proc and task?
			String[] procNames = (new Mapping(padre.getVarTree(), sys, modeRef))
					.taskToProc(Utility.pathToEvidence(DataPath.addSlash(nome)));
			if (procNames.length > 0) {
				// first search all procs ... (procNames)

				for (int i = 0; i < procNames.length; i++) {
					// ... for each search all used method ...
					String procPath = Search.aProc(ti, sys, procNames[i]);
					if (procPath == null) {
						// warning : proc not found
						Messages.sendWarningNl("Proc not found : " + procNames[i]
								+ " , required by task " + nome, null, "Task",
								null);
						continue; // next proc
					}

					TimeVar var = wcetManager.getProcWcet(procPath, procNames[i]);
					
					if (var != null) {
						var.setType(COMMON_TIME_TYPE);

					Double time = (Double) var.get();
					if (time == null)
						continue; // no value, next method ref

					valore += time.doubleValue();
					// next method ref
				}
					
				}
			}

			// if no value, try to use task annotation
			if (valore == 0) {
				wcet_is_computed = false;
				return super.load(name, required);
			} else {
				name = name.toLowerCase();
				prop.put(name, new Double(valore));

				wcet_is_computed = true;
				
				return true;
			}
		}
		
		if (STR_CACHE_MISS_COST.equalsIgnoreCase(name)) {
			TimeVar value = null;
			boolean answer = false;

			try {
				CacheMissCostCommon ccommon = new CacheMissCostCommon(padre.getVarTree());
				value = ccommon.getTaskCost(Utility.pathToEvidence(DataPath.addSlash(nome)));
				
			} catch (Exception e) {
				RtdruidLog.log(e);
				return false;
			}
			
			if (value == null || value.get() == null) {
				notFoundValues.add(name, required);
			} else {
				value.setType(COMMON_TIME_TYPE);
				prop.put(name,  (Double) value.get());
				answer = true;
			}

			return answer;
		
		}

		if (("Deadline").equalsIgnoreCase(name)) {
			name = name.toLowerCase();
			boolean risp = true;
			Object dl = ti.exist(getPath(name), null) ? ti.getValue(
					getPath(name)).get() : null;
			if (dl == null) {
				// store DeadLine = Period
				try {
					IVariable var = ti.getValue(getPath("Period"));
					if (var instanceof TimeVar) {
						((TimeVar) var).setType(COMMON_TIME_TYPE);
					} else if (var instanceof TimeMVar) {
						((TimeMVar) var).setType(COMMON_TIME_TYPE);
					}
					dl = (Double) var.get();

				} catch (Exception e) {

					notFoundValues.add(name, required);
					/*
					 * String txt = "Value not loaded:" + "\n\twhere =" +
					 * getPath(name) + " ( "+ getPath("Period")+" )" + "\n\twhat
					 * (property)=" + name + " ( Period )";
					 * Messages.sendWarning(txt, "Task " + nome + " - " + txt +
					 * "\n\twhy:" + e.toString(), "TASK" , null);
					 */
					risp = false;
				}
				if (dl == null) {
					dl = "";
				}

				prop.put(name, dl);
				return risp;
			}
			// continue as default
		}

		if (("Blocking").equalsIgnoreCase(name)) { // disable loading of
												   // Blocking
			return true;
		}

		//	if (("Blocking").equalsIgnoreCase(name)) {
		//		Double valore = new Double(0);
		//		name = name.toLowerCase();
		//		prop.put(name,valore);
		//		return true;
		//	}

		return super.load(name, required);
	}

	/**
	 * 
	 */
	public static void computeResources(String nome, IVarTree vt, String modeRef, HashMap<String, Double> resourceUsage, ArrayList<String> resourceNames) {
		String sys = Search.systemName(vt);
		ITreeInterface ti = vt.newTreeInterface();
		Mapping map = new Mapping(vt, sys, modeRef);

		// there is a mapping between proc and task?
		String[] procNames = map.taskToProc(Utility.pathToEvidence(DataPath
				.addSlash(nome)));
		if (procNames.length > 0) {
			// first search all procs ... (procNames)

			for (int i = 0; i < procNames.length; i++) {
				// ... for each search all used method ...
				String procPath = Search.aProc(ti, sys, procNames[i]);
				if (procPath == null) {
					// warning : proc not found
					Messages.sendWarningNl("Proc not found : " + procNames[i]
							+ " , required by task " + nome, null, "Task",
							null);
					continue; // next proc
				}
				String subSystemPath = Search.procPrefix(ti, sys,
						procNames[i]);

				ITreeInterface.TiInfo[] objs = ti.getAll(procPath + S
						+ "MethodRefList" + S + ITreeInterface.SPECIAL + S
						+ "MethodName", "MethodRef");

				if (objs == null)
					continue; // no method ref : next proc

				for (int j = 0; j < objs.length; j++) {
					// reset the first value
					String tmpSubSystemPath = subSystemPath;

					// ... check if the reference is to a Var
					if (objs[j] == null
							|| objs[j].getVariable().get() == null)
						continue; // ???? No MethodName: is not a good thing

					String methId = objs[j].getVariable().toString();

					//Messages.sendDebug("\nInizio Metodo = " + methId + "
					// - SubSystem = " +
					// Utility.makeEvidenceID(tmpSubSystemPath) + " - Proc =
					// " + procNames[i]);
					int stato = 0;
					StringBuffer chain = new StringBuffer(
							", required by :\n\tproc : " + procNames[i]
									+ " (task " + nome + ")");
					for (; stato < 1000; stato++) {
						chain.append("\n\tmethodRef : " + methId);

						//Messages.sendDebug("\tMetodo = " + methId + " -
						// SubSystem = " +
						// Utility.makeEvidenceID(tmpSubSystemPath));
						// search objName (with protection!!) and objPath
						String objPath = null; // with VarTreeNotation

						//						String objName = null; // with Evidence notation
						//						String methodName = null;// with Evidence
						// notation

						String objVTP = null; // with VarTreeNotation
						String methodVTP = null; // with VarTreeNotation
						{
							try {
								objPath = Search.aLocalMethod(ti,
										tmpSubSystemPath, methId);
							} catch (Exception e) {
								// do nothing
								objPath = null;
							}
							if (objPath == null) {
								Messages.sendWarningNl(
										"Method not found : " + methId
												+ chain.toString(), null,
										"Task", null);

								break; // next proc
							}

							String[] t = DataPath.splitPath(Utility
									.pathToVarTree(methId));
							methodVTP = t[t.length - 1];
							objVTP = t[t.length - 2];
						}

						/*
						 * 
						 * REQUIRED INTERFACE !!!
						 *  
						 */

						// is it a reference to a local subSystem?
						if (ti.exist(objPath, Utility.T_SUBSYSTEM)
								&& objPath.equals(tmpSubSystemPath)) {
							chain.append(" -> Required Interface");
							//Messages.sendDebug("\trequired interface
							// objPath = " +
							// Utility.makeEvidenceID(objPath));
							//search a required interface
							String ttmpath = tmpSubSystemPath + S
									+ "RequiredInterfaceList" + S
									+ methodVTP;
							if (!ti.exist(ttmpath, "RequiredInterface")) {
								// warning : proc not found
								Messages
										.sendWarningNl(
												"Required interface not found : "
														+ DataPath
																.removeSlash(methodVTP)
														+ ", subsystem "
														+ DataPath
																.removeSlash(objVTP)
														+ chain.toString(),
												null, "Task", null);
								break;
							}

							// search a method ref and get methodName
							/*
							 * String[] mRefNames = ti.getAllName(ttmpath,
							 * "MethodRef"); if (mRefNames.length == 0) {
							 * Messages.sendWarning("Required interface
							 * found but without methodRef: "
							 * +VarTree.removeSlash(methodVTP) + ",
							 * subsystem "+ VarTree.removeSlash(objVTP)
							 * +chain.toString(), null, "Task", null);
							 * break; } if (mRefNames.length > 1) {
							 * Messages.sendWarning("Required interface
							 * found with more than one methodRef: "
							 * +VarTree.removeSlash(methodVTP) + ",
							 * subsystem "+ VarTree.removeSlash(objVTP) +
							 * chain.toString(), null, "Task", null); break; }
							 */
							//ttmpath += S + mRefNames[0];
							methId = (String) ti.getValue(
									ttmpath + S + "ExternalMethodRef")
									.get();
							if (methId == null) {
								// nothing to do (Not mapped??)
								break;
							}

							// correct path and make a new loop
							tmpSubSystemPath = Mapping.parentSubSystemPath(
									vt, tmpSubSystemPath);
							continue;
						}

						/*
						 * 
						 * PROVIDED INTERFACE
						 *  
						 */
						// obj is a local subSystem ?
						if (ti.exist(objPath, Utility.T_SUBSYSTEM)) {
							chain.append(" -> Provided Interface");
							//Messages.sendDebug("\tprovided interface
							// objPath = " +
							// Utility.makeEvidenceID(objPath));

							String tp = objPath + S
									+ "ProvidedInterfaceList" + S
									+ methodVTP;

							// search the correct provided interface
							if (!ti.exist(tp, "ProvidedInterface")) {
								// warning : proc not found
								Messages
										.sendWarningNl(
												"Provided interface not found : "
														+ DataPath
																.removeSlash(methodVTP)
														+ ", SubSystem "
														+ DataPath
																.removeSlash(objVTP)
														+ chain.toString(),
												null, "Task", null);
								break;
							}

							String objName = (String) ti.getValue(
									tp + S + "LocalObjectRef").get();
							String methodName = (String) ti.getValue(
									tp + S + "LocalMethodRef").get();
							if (objName == null || methodName == null) {
								// nothing to do (Not mapped??)
								break;
							}

							// compose a method identificator and make a new
							// loop
							methId = objName + S + methodName;

							// correct path and make a new loop
							tmpSubSystemPath = objPath;
							continue;
						}

						/*
						 * 
						 * VAR
						 *  
						 */
						// search a local var in current zone
						String varPath = Search.aLocalVar(ti,
								tmpSubSystemPath, DataPath
										.removeSlash(objVTP));
						if (varPath != null) {
							chain.append(" -> Var");
							//Messages.sendDebug("\tvar varjPath = " +
							// Utility.makeEvidenceID(varPath));

							// remove protection from objName and methName

							// search a mapping to a mutex
							String mutexName = map.varToMutex(Mapping
									.makeVarName(vt,
											tmpSubSystemPath, DataPath
													.removeSlash(objVTP)));
							if (mutexName == null)
								break; // not mapped var -> not shared
								//Messages.sendDebug("\tmutexName = " +
								// mutexName);

							{ //	check for mutex
								String tmpPath = sys
										+ S
										+ "Architectural"
										+ S
										+ "MutexList"
										+ S
										+ Utility.pathToVarTree(DataPath
												.addSlash(mutexName));
								if (!ti.exist(tmpPath, "Mutex") && !("RES_SCHEDULER".equals(mutexName))) {
									// no annotation about this method.
									// Is it a good thing?
									Messages.sendWarningNl(
											"Mutex not found: " + mutexName
													+ chain.toString(),
											null, "Task", null);
									break; // next method ref
								}
							}

							// Check method name
							ArrayList<?> elencoMethod = (ArrayList<?>) ti
									.getValue(varPath + S + "Methods")
									.get();
							String tmpMethod = DataPath
									.removeSlash(methodVTP);

							boolean ok = false;
							for (int jj = 0; jj < elencoMethod.size()
									&& !ok; jj++) {
								if (tmpMethod.equals(elencoMethod.get(jj)))
									ok = true;
							}
							if (!ok) {
								ok |= tmpMethod.equalsIgnoreCase("read");
								ok |= tmpMethod.equalsIgnoreCase("write");
							}
							if (!ok) {
								Messages
										.sendWarningNl(
												"The proc "
														+ procNames[i]
														+ " (task "
														+ nome
														+ ") required an illegal resource method."
														+ "\n\tResource = "
														+ DataPath
																.removeSlash(objVTP)
														+ ",  method = "
														+ tmpMethod
														+ chain.toString(),
												null, "Task", null);
								break;
							}

							// search annotation
							String tmpMethodName = Mapping.makeVarName(
									vt, tmpSubSystemPath,
									DataPath.removeSlash(objVTP))
									+ S + Utility.pathToEvidence(methodVTP);

							String tmpPath = Search.anExecTime(ti, sys,
									tmpMethodName, "METHOD", modeRef);

							if (tmpPath == null) {
								// no annotation about this method.
								// Is it a good thing?
								Messages.sendWarningNl(
										"Not found ExecTime for '"
												+ tmpMethod + "' method"
												+ chain.toString(), null,
										"Task", null);
								break; // next method ref
							}
							//Messages.sendDebug("\tExecTime ok");

							// set time to milli_seconds
							IVariable var = ti.getValue(tmpPath + S
									+ "Worst");
							if (var instanceof TimeVar) {
								((TimeVar) var)
										.setType(COMMON_TIME_TYPE);
							} else if (var instanceof TimeMVar) {
								((TimeMVar) var)
										.setType(COMMON_TIME_TYPE);
							}
							Double time = (Double) var.get();
							if (time == null)
								break; // no value, next method ref

							mutexName = DataPath.removeSlash(mutexName);
							if (getResourceUsage(resourceUsage, mutexName) < time
									.doubleValue()) {
								useResource(resourceUsage, resourceNames, mutexName, time.doubleValue());
							}
							// next method ref

							// end. Next method ref
							break;
						}

						// stato = EXIT
						break;
					}

					if (stato == 100) {
						Messages.sendWarningNl("Found a infinity loop"
								+ chain.toString(), null, "Task", null);
						// continue
					}

					// next method ref
				}
				// next proc ref
			}

		} else { // use data stored into Architectural

			// first search all used resources ...
			String tmpPref = sys + S + "Architectural" + S + "TaskList" + S
					+ DataPath.addSlash(nome) + S + "ResourceRefList";
			String[] idList = { modeRef };
			tmpPref = Utility
					.chooseModeRef(ti, tmpPref, idList, 0, modeRef);

			// if tmpPref == null, nothing to do
			if (tmpPref != null
					&& ti.exist(tmpPref + S + "ResourceMethodRef",
							DataPath.STRING_M_TYPE)) {

				ArrayList<?> methNames = (ArrayList<?>) ti.getValue(
						tmpPref + S + "ResourceMethodRef").get();
				if (methNames == null)
					methNames = new ArrayList<String>(); // no resource or method
												 // name

				// only one cicle
				for (int i = 0; i < methNames.size(); i++) {
					String methName = (String) methNames.get(i);

					// search the resource
					String resPath = Search.aResourceMethod(ti, sys,
							methName);
					if (resPath == null) {
						Messages.sendWarningNl("Required a resource with '"
								+ methName + "' method by Task '" + nome
								+ "", null, "Task", null);
						continue; // Warning !!!
					}

					String[] idList2 = { modeRef };
					String tmpPath = Utility.chooseModeRef(ti, resPath + S
							+ "MutexRefList", idList2, 0, modeRef);

					if (tmpPath == null
							|| !ti.exist(tmpPath + S + "MutexName",
									DataPath.STRING_TYPE)) {
						continue; // no mapping to mutex
					}

					String mutexName = (String) ti.getValue(
							tmpPath + S + "MutexName").get();
					if (mutexName == null) {
						continue; // no mutex name
					}

					// check for mutex
					tmpPath = sys
							+ S
							+ "Architectural"
							+ S
							+ "MutexList"
							+ S
							+ Utility.pathToVarTree(DataPath
									.addSlash(mutexName));
					if (!ti.exist(tmpPath, "Mutex")  && !("RES_SCHEDULER".equals(mutexName))) {
						// no annotation about this method.
						// Is it a good thing?
						Messages.sendWarningNl("Mutex not found: "
								+ mutexName + ", required by task " + nome,
								null, "Task", null);
						continue; // next method ref
					}

					tmpPath = Search.anExecTime(ti, sys, methName,
							"RESOURCE_METHOD", modeRef);

					Double time = new Double(0);
					if (tmpPath == null) {
						// no annotation about this method.
						// Is it a good thing?

						// it's ok for Oil Configuration

						//Messages.sendWarning("Not found ExecTime for
						// '"+methName+"' method, required by task " + nome
						//		, null, "Task", null);
						//continue; // next method ref
					} else {

						// set time to milli_seconds
						IVariable var = ti.getValue(tmpPath + S + "Worst");
						if (var instanceof TimeVar) {
							((TimeVar) var).setType(COMMON_TIME_TYPE);
						} else if (var instanceof TimeMVar) {
							((TimeMVar) var).setType(COMMON_TIME_TYPE);
						}
						time = (Double) var.get();
						if (time == null) {
							time = new Double(0);
							//continue; // no value, next method ref
						}
					}

					mutexName = DataPath.removeSlash(mutexName);
					if (getResourceUsage(resourceUsage, mutexName) < time.doubleValue()) {
						useResource(resourceUsage, resourceNames, mutexName, time.doubleValue());
					}
					// next method ref
				}
			}
		}
	}

	protected boolean doStore(String key, Object o) {

		if (storeProcs(key, o)) {
			return true;
		}
		
		// check for aperiodic Tasks
		if (("aperiodic").equalsIgnoreCase((String) prop.get(STR_ACT_TYPE))) {
			String[] disabled = { "period", "wcet", "deadline", "offset",
					"priority", "ResponseTime", "PreemptionGroupName",
					"blocking", "schedulable", "utilization", "cDelta" };

			// search if this property is disabled
			for (int i = 0; i < disabled.length; i++) {
				if (disabled[i].equalsIgnoreCase(key)) {

					// don't try to store a void value
					if (o != null && o instanceof String && "".equals(o)) {
						return true;
					}

					// don't use void path
					String path = getPath(key);
					if (path == null || !ti.exist(path, null)) {
						return true;
					}

					// continue with normal methods
					break;
				}
			}
		}

		// disable "schedulability" for "not mapped tasks"
		if (rtosName.equalsIgnoreCase(TaskSet.NOT_MAPPED)) {
			// don't try to store a void value
			if (o != null && "".equals("" + o)) {
				return true;
			}

			String[] schedulability = { "Utilization", "CDelta", "TDelta",
					"ResponseTime", "Schedulable" };
			for (int i = 0; i < schedulability.length; i++) {
				if (schedulability[i].equalsIgnoreCase(key)) {
					return true; // disabel store
				}
			}
		}

		if (("Resource").equalsIgnoreCase(key)
				|| ("Blocking").equalsIgnoreCase(key)) { // disable also
														 // Blocking
			return true;
		}

		//make a new node?
		String[][] modeRefList = {
				{ "Priority", "SchedulingList", "Scheduling" },
				//		{"Blocking", "SchedulingList", "Scheduling"},
				{ "Threshold", "SchedulingList", "Scheduling" },
				{ "Stack", "SchedulingList", "Scheduling" },
				{ "PreemptionGroupName", "SchedulingList", "Scheduling" },

				{ "Type", "ActivationList", "Activation" },
				{ "ActNumber", "ActivationList", "Activation" },
				{ "Class", "ActivationList", "Activation" },
				{ "Period", "ActivationList", "Activation" },
				{ "Offset", "ActivationList", "Activation" },
				{ "Deadline", "ActivationList", "Activation" } };
		for (int i = 0; i < modeRefList.length; i++) {
			if (modeRefList[i][0].equalsIgnoreCase(key)) {
				if (!ti.exist(getPath() + S + modeRefList[i][1] + S
						+ DataPath.makeSlashedId(modeRef), modeRefList[i][2])) {
					try {
						ti.addElement(modeRef, modeRefList[i][2], getPath() + S
								+ modeRefList[i][1]);
					} catch (ITreeInterface.AddElementException e) {
						// why??? only if BuilderXML wasn't load
						e.printStackTrace();
						return false;
					}
				}

				return super.doStore(key, o);
			}
		}

		String[] annotation = { "wcet", "Best", "DistributionType",
				"DistributionAvg", "DistributionVariance", };
		for (int i = 0; i < annotation.length; i++) {
			if (annotation[i].equalsIgnoreCase(key)) {

				String[] tmp = {
						Utility.pathToEvidence(nome
//								DataPath.addSlash(nome)
								), "TASK" };

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
					// why??? only if BuilderXML wasn't load
					e.printStackTrace();
					return false;
				}

				return super.doStore(key, o);
			}
		}

		String[] cache_miss = { STR_CACHE_MISS_COST};
		for (int i = 0; i < cache_miss.length; i++) {
			if (cache_miss[i].equalsIgnoreCase(key)) {


				try {
					CacheMissCostCommon ccommon = new CacheMissCostCommon(padre.getVarTree());
					TimeVar value = null;
					if (o != null) {
						if (o instanceof TimeVar) {
							value = (TimeVar) ((TimeVar) o).clone();
						} else {
							value = new TimeVar("" + o);
						}
						
					}
					ccommon.setTaskCost(Utility.pathToEvidence(DataPath.addSlash(nome)), value);
					
				} catch (Exception e) {
					RtdruidLog.log(e);
					return false;
				}

				return true;
			}
		}
		
		
		// Schedulability
		String[][] schedulability = { { "Utilization", "Utilization" },
				{ "CDelta", "CDelta" }, { "TDelta", "TDelta" },
				{ "ResponseTime", "ResponseTime" },
				{ "Schedulable", "Schedulable" } };
		for (int i = 0; i < schedulability.length; i++) {
			if (schedulability[i][0].equalsIgnoreCase(key)) {

				// search required node ...
				// ... first SchedulingScenario node
				try {
					String ttpref = sys;
					String ttnew = "Schedulability";
					if (!ti.exist(ttpref + S + ttnew, "Schedulability")) {
						ti.addElement(ttnew, "Schedulability", ttpref);
					}

					ttpref += S + ttnew + S + "SchedulingScenarioList"; // sys +
																		// sched
																		// +
																		// list
					ttnew = modeRef;
					String stnew = DataPath.makeSlashedId(modeRef);
					if (!ti.exist(ttpref + S + stnew, "SchedulingScenario")) {
						ti.addElement(ttnew, "SchedulingScenario", ttpref);
					}

					ttpref += S + stnew + S + "TaskSchedList"; // sys + sched +
															   // list +
															   // scenario +
															   // taskList
					ttnew = Utility.pathToEvidence(nome); //DataPath.addSlash(nome));
					stnew = DataPath.makeSlashedId(ttnew);
					if (!ti.exist(ttpref + S + stnew, "TaskSched")) {
						ti.addElement(ttnew, "TaskSched", ttpref);
					}

				} catch (ITreeInterface.AddElementException e) {
					// why??? only if BuilderXML wasn't load
					//				e.printStackTrace();
					//				return null;
				} catch (RuntimeException e) {
					// why??? only if BuilderXML wasn't load
					//				e.printStackTrace();
					//				return null;
				}
			}
		}

		// if (wcet) -> store into task annotation

		//	if (("Blocking").equalsIgnoreCase(key)) {
		//		return true;
		//	}
		return super.doStore(key, o);
	}

	// -------------- RESOURCES

	/**
	 * Specifies that this task uses resource r with a critical section that has
	 * a worst case execution time w
	 * 
	 * @param r
	 *            resource
	 * @param w
	 *            worst case duration of the critical section
	 */
	public void useResource(String r, double w) {
		useResource(resources, resNames, r, w);
	}
	
	/**
	 * Specifies that this task uses resource r with a critical section that has
	 * a worst case execution time w
	 * 
	 * @param r
	 *            resource
	 * @param w
	 *            worst case duration of the critical section
	 */
	private static void useResource(HashMap<String, Double> resUsage, ArrayList<String> names, String r, double w) {
		if (!resUsage.containsKey(r)) {
			names.add(r);
		}
		resUsage.put(r, new Double(w));
	}

	/**
	 * Returns the worst case duration of the longest critical section of this
	 * task on resource r. If the resource isn't found, return -1
	 * 
	 * @param r
	 *            resource
	 */
	public double getResourceUsage(String r) {
		return getResourceUsage(resources, r);
	}
	
	/**
	 * Returns the worst case duration of the longest critical section of this
	 * task on resource r. If the resource isn't found, return -1
	 * 
	 * @param r
	 *            resource
	 */
	private static double getResourceUsage(HashMap<String, Double> resUsage, String r) {
		Double w = (Double) resUsage.get(r);
		if (w != null) {
			return w.doubleValue();
		} else
			return -1;
	} 

	public Enumeration<String> getAllResources() {
		return Collections.enumeration(resNames);
	}

	// -------------- PROCESS
	// see Mapping.taskToProc()

	/*
	 * public void addProcess(TaskProcess p) { proclist.addElement(p);
	 * Collections.sort(proclist, p.getProcessComparator()); }
	 * 
	 * public TaskProcess getProcess(int index) { return
	 * (TaskProcess)proclist.elementAt(index); }
	 * 
	 * public Enumeration getAllProcesses() { return proclist.elements(); }
	 */
	
	
	public boolean loadProcs(String name, boolean required) {
		
		boolean answer = false;
		
		if (STR_PROC_LIST.equalsIgnoreCase(name)) {
			ArrayList<ProcData> procs = new ArrayList<ProcData>();

			Mapping map = new Mapping(padre.getVarTree(), sys, modeRef);
			
			String[] procNames = map.taskToProc(Utility.pathToEvidence(DataPath.addSlash(nome)));
			for (int i = 0; i < procNames.length; i++) {
				// ... for each search all used method ...
				String procPath = Search.aProc(ti, sys, procNames[i]);
				if (procPath == null) {
					// warning : proc not found
					Messages.sendWarningNl("Proc not found : " + procNames[i]
							+ " , required by task " + nome, null, "Task",
							null);
					continue; // next proc
				}

				Integer position = map.procToTaskOrder(procNames[i]);
				Integer onceEveryK = map.procToTaskFrequency(procNames[i]);
				
				ProcData p = new ProcData(procNames[i]);
				if (onceEveryK != null) p.setOnceEveryK(onceEveryK.intValue());
				if (position != null) p.setPosition(position.intValue());
				procs.add(p);
			}
			
			prop.put(name, procs);
			
			answer = true;
			
		} else if (STR_GENERIC_WCET.equalsIgnoreCase(name)) {
			MultiFrameTaskWcet wcets = new MultiFrameTaskWcet();
			WcetCommon wcetManager = new WcetCommon(padre.getVarTree());
			Mapping map = new Mapping(padre.getVarTree(), sys, modeRef);

			// there is a mapping between proc and task?
			String[] procNames = map.taskToProc(Utility.pathToEvidence(DataPath.addSlash(nome)));
			
			for (int i = 0; i < procNames.length; i++) {
					// ... for each search all used method ...
				String procPath = Search.aProc(ti, sys, procNames[i]);
				if (procPath == null) {
					// warning : proc not found
					Messages.sendWarningNl("Proc not found : " + procNames[i]
							+ " , required by task " + nome, null, "Task",
							null);
					continue; // next proc
				}

				TimeVar var = wcetManager.getProcWcet(procPath, procNames[i]);
				double valore = 0;
				if (var != null) {
					var.setType(COMMON_TIME_TYPE);

					Double time = (Double) var.get();
					if (time == null)
						continue; // no value, next method ref
	
					valore += time.doubleValue();
					// next method ref
				}
					
				Integer onceEveryK = map.procToTaskFrequency(procNames[i]);

				if (onceEveryK == null) onceEveryK = new Integer(1); // default value
				
				wcets.addAProc(procNames[i], valore, onceEveryK);

			}

			prop.put(name, wcets);
			answer = true;	
		}

		return answer;
	}

	public boolean storeProcs(String name, Object o) {
		
		boolean answer = STR_PROC_LIST.equalsIgnoreCase(name) ||
			STR_GENERIC_WCET.equalsIgnoreCase(name);
		
		return answer;
	}

	
	
	// -------------- COLOR
	public void setColor(Color c) {
		color = c;
	}

	public Color getColor() {
		return color;
	}

	// -------------- PRINT

	public String toString() {
		StringBuffer risp = new StringBuffer(super.toString());

		risp.append("\nResources:");
		for (String k : resources.keySet()) {
			risp.append("\n name = " + k + " \tvalue = " + resources.get(k));
		}

		return risp.toString();
	}

	// ---------------
	public void setRtos(String name) {
		if (name == null) {
			rtosName = TaskSet.NOT_MAPPED;
		} else {
			rtosName = name;
		}
	}
	
	public boolean isWcet_is_computed() {
		return wcet_is_computed;
	}
}

