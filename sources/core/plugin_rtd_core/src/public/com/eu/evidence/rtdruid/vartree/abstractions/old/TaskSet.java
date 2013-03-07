/*
 * $Id: TaskSet.java,v 1.3 2008/01/09 17:36:27 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.abstractions.old;

// project package


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Properties;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.tools.Mapping;
import com.eu.evidence.rtdruid.vartree.tools.Search;
import com.eu.evidence.rtdruid.vartree.tools.Search.ArchElement;


/**
 * TaskSet
 * 
 * @author Giuseppe Lipari && Nicola Serreli
 * 
 * TODO probably to be refactored.
 */
public class TaskSet extends ModeResList {
	/** Abbreviation for VarTree.SEPARATOR */
	private final static char S = IVarTree.SEPARATOR;

	public final static String NOT_MAPPED = "\"Non mapped Tasks\"";

	/**
	 * Actual ceiling
	 * TODO check this!! 
	 */
	private int act_ceil = 0;

	/**
	 * Name of the system
	 * TODO probably to be removed.
	 */
	private String system;
	
	/** All cpu suffix */
	protected Properties parametri_cpu;
	
	/** All cpu objects */
	protected GenRes[] elenco_cpu;

	public TaskSet(IVarTree vt, String prefix) {
		this(vt, prefix, null);//rtdruid.modules.evidence.Utility.DEFAULT_MODE);
	}

	/**
	 * Searchs all task stored in given prefix and store them as a list of
	 * {@link Task Task}.
	 * 
	 * @param prefix
	 *            contains all path in witch look for "Task" containers.
	 * 
	 * @throws NullPointerException
	 *             if at least one of prefix and type is null
	 */
	public TaskSet(IVarTree vt, String prefix, String mode) {
		this(vt, prefix, mode, false);
	}

	
	public TaskSet(IVarTree vt, String prefix, String mode, boolean emptyCpu) {
		super(vt, mode);

		if (prefix == null)
			throw new NullPointerException(
					"Try to make a new GenRes list with a null prefix.");

		system = prefix = (prefix.startsWith("" + S) ? prefix : S + prefix);
		parametri = new Properties();
		parametri_cpu = new Properties();
		elenco_cpu = null;// waiting ....

		ITreeInterface ti = vt.newTreeInterface();

		ArrayList<String> tmpCpu = new ArrayList<String>();
		ArrayList<ArrayList<Task>> tmpTask = new ArrayList<ArrayList<Task>>();
		ArrayList<Task> tmpFreeTask = new ArrayList<Task>();
		
		if (emptyCpu) {
			ArchElement[] elems = Search.allRtosNames(ti);
			for (ArchElement elem : elems) {
				tmpCpu.add(elem.name);
				tmpTask.add(new ArrayList<Task>());
			}
			Collections.sort(tmpCpu);
		}
		
		

		// get all Var names
		String tmpPref = prefix + S + "Architectural" + S + "TaskList";
		Search.ArchElement[] taskName = Search.allTasksNames(ti);

		if (taskName != null) {
			Mapping map = new Mapping(vt, system, mode);
	
			// store temp data
			for (int i = 0; i < taskName.length; i++) {
				String tName = taskName[i].name;
				String cpuId = map.taskToRTOS(tName);
				if (cpuId == null) {
					tmpFreeTask
							.add(new Task(this, DataPath.addSlash(tName), tmpPref, mode, NOT_MAPPED));
					continue; // next task
				}
	
				int pos = Collections.binarySearch(tmpCpu, cpuId);
				if (pos < 0) { // new cpu id
					pos = -pos - 1;
					tmpCpu.add(pos, cpuId);
					tmpTask.add(pos, new ArrayList<Task>());
				}
				tmpTask.get(pos).add(new Task(this, DataPath.addSlash(tName), tmpPref,
						mode, cpuId));
			}
		}

		// store all data
		tmpCpu.add(0, NOT_MAPPED);
		prefissi = tmpCpu.toArray(new String[0]);

		tmpTask.add(0, tmpFreeTask);
		elenco = (ArrayList[]) tmpTask.toArray(new ArrayList[0]);

		
		elenco_cpu = new GenRes[prefissi.length];
		for (int i=1; i<prefissi.length; i++) {
			elenco_cpu[i] = new Cpu(this, prefissi[i], system);
		}
	}

	/**
	 * @return
	 */
	public String getSystem() {
		return system;
	}

	/**
	 * 
	 */
	protected GenRes makeNewElement(String name, String prefix) {
		throw new UnsupportedOperationException(
				"TaskSet doesn't use this method");
	}

	//	public void assignTaskToCpus() {}

	/**
	 * Removes the aperiodic tasks from the list.
	 */
	public void onlyPeriodicTasks() {
		for (int i = 1; i < elenco.length; i++) {
			//search and drop all tasks with a null or a different type
			for (int j = elenco[i].size() - 1; j >= 0; j--) {
				String tipo = (((Task) elenco[i].get(j)).existProperty(Task.STR_ACT_TYPE) ? (String) ((Task) elenco[i]
						.get(j)).getProperty(Task.STR_ACT_TYPE)
						: (String) null);
				if (!("Periodic").equalsIgnoreCase(tipo)
						&& !("Sporadic").equalsIgnoreCase(tipo)) {
					elenco[i].remove(j);
				}
			}
		}
	}

	// ------------- CPU elements
	
	/** Returns the description of a task found in specified prefix
	*
	*	@param	prefixId	identifies the prefix, in the list of prefix given to contructor
	*	@param	pos		identifies the task from others in the same prefix
	*
	*	@return  the description
	*
	*	@throws	IndexOutOfBoundsException if one of "cpuId" or "pos" index is either negative or greater than or equal to the number of prefix stored. 
	*/
	public GenRes getCpuItem(int prefixId) {   return (GenRes) elenco_cpu[prefixId]; }

	
	/** Tries to get a new property to all objects (or to change the suffix of an older one)
	*
	*
	*	@return the older value or null if there wasn't one
	*/
	public String setCpuProperty(String name, String suffix, boolean required) {
		if (suffix == null)
			throw new IllegalArgumentException("Try to set a null property.");
		
		if (parametri.contains(name)) {
			RtdruidLog.showDebug("Using the same parameter ID for both cpu and tasks, " + name);
		}
		
		name = name.toLowerCase();
		String tmp = (String) parametri_cpu.setProperty(name, suffix);
		
		// update all objects
		for (int j =0; j< elenco_cpu.length; j++) {
			if (elenco_cpu[j] != null)
				elenco_cpu[j].load(name, required);
//			for (int i=0; i<elenco_cpu[j].size(); i++) {
//				((GenRes) elenco_cpu[j].get(i)).load(name, required);
//			}
		}
		return tmp;
	}
	
	/** Tries to get a the value (suffix) of an already stored property.
	*
	*	@return the value or null if there wasn't one
	*/
	public String getCpuProperty(String name) {
		return parametri_cpu.getProperty(name.toLowerCase());
	}
	
	@Override
	public String setProperty(String name, String suffix, boolean required) {
		
		if (parametri_cpu.contains(name)) {
			RtdruidLog.showDebug("Using the same parameter ID for both cpu and tasks, " + name);
		}

		return super.setProperty(name, suffix, required);
	}
	
	/** Tries to get a the value (suffix) of an already stored property.
	*
	*	@return the value or null if there wasn't one
	*/
	public String getProperty(String name) {
		if (parametri.containsKey(name))
			return parametri.getProperty(name.toLowerCase());
		else 
			return parametri_cpu.getProperty(name.toLowerCase());
	}
	// ------------- SORT

	/** 
	 * Sorts the task set by increasing relative deadline
	 */
	public void sortByDeadline() {
		for (int i = 0; i < elenco.length; i++) {
			Collections.sort(elenco[i], new IncrDeadlineComparator());
		}
	}

	/**
	 * Sorts the task set by increasing period
	 *
	 */
	public void sortByPeriod() {
		for (int i = 0; i < elenco.length; i++) {
			Collections.sort(elenco[i], new IncrPeriodComparator());
		}
	}

	/**
	 * Sorts the task set by increasing priority
	 *
	 */
	public void sortByPriority() {
		for (int i = 0; i < elenco.length; i++) {
			Collections.sort(elenco[i], new IncrPriorityComparator());
		}
	}

	// ------------- COMPUTE

	/** 
	 * Assigns priorities according to DM
	 * TODO to be removed
	 */
	public void computeDMPriorities() {
		sortByDeadline();
		for (int i = 0; i < elenco.length; i++) {
			for (int j = 0; j < elenco[i].size(); ++j) {
				GenRes t = (GenRes) elenco[i].get(j);
				t.setProperty("priority", elenco[i].size() - j);
			}
		}
	}

	/** 
	 * Assigns priorities according to RM
	 * TODO to be removed
	 */
	public void computeRMPriorities() {
		sortByPeriod();
		for (int i = 0; i < elenco.length; i++) {
			for (int j = 0; j < elenco[i].size(); ++j) {
				GenRes t = (GenRes) elenco[i].get(j);
				t.setProperty("priority", elenco[i].size() - j);
			}
		}
	}

	/**
	 * Assigns priorities according to RM for the specified CPU
	 * @param cpuId
	 */
	public void computeRMPriorities(int cpuId) {
		if (elenco.length < cpuId) {
			throw new IndexOutOfBoundsException(
					"Required a non-existent cpuId : max id =" + elenco.length
							+ " , required id = " + cpuId);
		}
		sortByPeriod();

		for (int j = 0; j < elenco[cpuId].size(); ++j) {
			GenRes t = (GenRes) elenco[cpuId].get(j);
			t.setProperty("priority", elenco[cpuId].size() - j);
		}
	}
	
	/**
	 * Retrieves the Stack Size for the CPU.
	 * @param cpuId
	 */
	public String getStackSize(int cpuId) {
		if (elenco.length < cpuId) {
			throw new IndexOutOfBoundsException(
					"Required a non-existent cpuId : max id =" + elenco.length
							+ " , required id = " + cpuId);
		}
		ITreeInterface ti = this.getVarTree().newTreeInterface();		
		String path = null;	
		IVariable var = null;
		
		try {
			// 1) search scheduling
			String ttpref = system;
			String ttnew = "Schedulability";
			if (!ti.exist(ttpref + S + ttnew, "Schedulability")) {
				ti.addElement(ttnew, "Schedulability", ttpref);
			}
			
			// 2) search scheduling scenario
			ttpref += S + ttnew + S +"SchedulingScenarioList"; // sys + sched + list
			ttnew = getMode();
			String stnew = DataPath.makeSlashedId(getMode());
			if (!ti.exist(ttpref + S + stnew, "SchedulingScenario")) {
				ti.addElement(ttnew, "SchedulingScenario", ttpref);
			}
			
			// 3) search CpuSched
			ttpref += S + stnew + S +"CpuSchedList"; // sys + sched + list + scenario + taskList
			ttnew = getPrefix(cpuId);
			stnew = DataPath.makeSlashedId(getPrefix(cpuId));
			if (!ti.exist(ttpref + S + stnew, "CpuSched")) {
				ti.addElement(ttnew, "CpuSched", ttpref);
			}
			
			path = ttpref + S + stnew;
			
		} catch (ITreeInterface.AddElementException e) {
			// why??? only if BuilderXML wasn't load
			e.printStackTrace();
			return "";
		} catch (RuntimeException e) {
			// why??? only if BuilderXML wasn't load
			e.printStackTrace();
			return "";
		}
//		Store maxStackSize
		try {
			var = ti.getValue(path + S + "MaxStackSize");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(var != null && var.get() != null) {
			return var.toString();
		}
		else{
			return "";
		}
	}
} // TaskSet

/**
 * Compare first Deadline then Period
 */
class IncrDeadlineComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		GenRes t1 = (GenRes) o1;
		GenRes t2 = (GenRes) o2;
		double d1 = 0;
		double d2 = 0;
		double p1;
		double p2;

		try {
			d1 = t1.getDouble("deadline");
			d2 = t2.getDouble("deadline");
			p1 = t1.getDouble("period");
			p2 = t2.getDouble("period");
		} catch (Exception e) {
			throw new ClassCastException("Can't compare because:\n\t"
					+ e.getMessage());
		}
		if (d1 < d2)
			return -1;
		else if (d1 == d2) {
			if (p1 < p2)
				return -1;
			else if (p1 == p2)
				return 0;
			else
				return 1;
		} else
			return 1;
	}
}

/**
 * Compare first Period then Deadline
 */

class IncrPeriodComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		GenRes t1 = (GenRes) o1;
		GenRes t2 = (GenRes) o2;
		double d1 = 0;
		double d2 = 0;
		double p1 = 0;
		double p2 = 0;

		try {
			d1 = t1.getDouble("deadline");
			d2 = t2.getDouble("deadline");
			p1 = t1.getDouble("period");
			p2 = t2.getDouble("period");
		} catch (Exception e) {
			throw new ClassCastException("Can't compare because:\n\t"
					+ e.getMessage());
		}
		if (p1 < p2)
			return -1;
		else if (p1 == p2) {
			if (d1 < d2)
				return -1;
			else if (d1 == d2)
				return 0;
			else
				return 1;
		} else
			return 1;
	}
}

/**
 * Compare only Priority
 */

class IncrPriorityComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		GenRes t1 = (GenRes) o1;
		GenRes t2 = (GenRes) o2;
		int p1 = 0;
		int p2 = 0;

		try {
			p1 = t1.getInt("priority");
			p2 = t2.getInt("priority");
		} catch (Exception e) {
			throw new ClassCastException("Can't compare because:\n\t"
					+ e.getMessage());
		}
		if (p1 > p2)
			return -1;
		else if (p1 == p2)
			return 0;
		else
			return 1;
	}
}