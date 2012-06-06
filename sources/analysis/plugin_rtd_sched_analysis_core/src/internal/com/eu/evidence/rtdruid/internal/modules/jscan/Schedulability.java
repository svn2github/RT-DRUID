package com.eu.evidence.rtdruid.internal.modules.jscan;

// project package


import java.util.ArrayList;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenResList;
import com.eu.evidence.rtdruid.vartree.abstractions.old.TaskSet;

// exceptions

/**
 *	Common class for all Schedulability tests
 *
 * @author Giuseppe Lipari && Nicola Serreli
 * @version 0.2
 */
public abstract class Schedulability  {
	static final protected Progress DEFAULT_PROGRESS = new Progress() {
		public void addSteps(long steps) {}
		public void worked(long steps) {}
		public void done() {}
		public boolean stoped() {return false;}
	};
	protected Progress progress = DEFAULT_PROGRESS; 
	
	
	/** Abbreviation for VarTree.SEPARATOR */
	private final static char S = IVarTree.SEPARATOR;
	
	/**
	 * Contains the list of tasks. It is a list of sets of Tasks (one for each CPU).
	 * Task set of index 0 contains the tasks that have not been mapped yet. 
	 */
	protected TaskSet tasks;
	
	/**
	 * Contains the list of resources.
	 */
	protected GenResList risorse;
	
	/**
	 * Contains the schedulability report for each CPU 
	 * (values, i.e. load, true/false, deltaspeed, etc.)
	 * TODO probably will become private
	 */
	protected ArrayList<String[][]> cpuSched;
	
	/**
	 * Contains the complete schedulability report for each CPU.
	 * TODO to be removed.
	 */
	protected ArrayList<String[]> reports;

	protected  Schedulability() {
		cpuSched = new ArrayList<String[][]>();
		reports = new ArrayList<String[]>();
	}

	/**
	 * set a task 
	 */
	public void setTaskSet(TaskSet t) { tasks = t; }
	/**
	*/
	public void setResourceSet(GenResList r) { risorse = r; }

	/**
	*/
	public TaskSet getTaskSet() { return tasks; }
	/**
	*/
	public GenResList getResourceSet() { return risorse; }

	/**
	 * Set the save state. If the save state is true, 
	 * it means that from now on, all data  
	 * will be saved on the data tree (if they have been modified or not).  
	 */
	public void setSave(boolean value) {
		tasks.setSave(value);
		risorse.setSave(value);
		
		// store all cpuSched
		if (value) {
			storeCpuSched();
			storeReports();
			cpuSched.clear();
			reports.clear();
		}
	}

    /////////////////////////////////////////////////
	/**
	 * Compute the schedulability. Recursively, invokes the computation 
	 * on each task set (CPU). Ignores the task set with index 0 (they have not been mapped yet).  
	 */
	public void compute() {
		if (tasks == null) return;
		for (int i=1; i<tasks.getPrefixNumber(); i++) {
			compute(i);
		}
	}
	/**
	 * Compute the schedulability analysis on the specified cpu. 
	 * Abstract, must be redefined in the specific schedulability analysis class.
	 */
    public abstract void compute(int cpuId);

	/**
	 * Returns the schedulability analysis report.
	 * 
	 * Note : this method will be removed?
	 */
	public String getReport() {
		if (tasks == null) return "No data";
		
		StringBuffer risp = new StringBuffer();
		// add not mapped tasks
		if (tasks.getPrefixNumber() >0 && tasks.getSize(0)>0) {
			risp.append("\nNon mapped tasks: \n");
			for (int j=0; j<tasks.getSize(0); j++) {
				risp.append("\t"+tasks.getItem(0,j).getName() + "\n");
			}
			risp.append("\n");
		}
		
		for (int i=1; i<tasks.getPrefixNumber(); i++) {
			risp.append("\nReport cpu " + tasks.getPrefix(i) + "\n" + getReport(i) + "\n") ;
		}
		return risp.toString();
	}
	
	/**
	 * Note : this method will be removed?
	 */
	public abstract String getReport(int cpuId);

	/**
	 * Check is every task is schedulable. 
	 */
	public boolean isSchedulable() {
		if (tasks == null) return true;
		boolean risp =true;
		// do all test (they could change some values)
		for (int i=1; i<tasks.getPrefixNumber(); i++) {
			risp &= isSchedulable(i);
		}
		return risp;
	}
	
	/**
	 * Check if a CPU is schedulable
	 */
    public abstract boolean isSchedulable(int cpuId);
	
	
	// ------------------------------- CPUSCHED && REPORTS-------------------------------
	
	/**
	 * Store the report. Used to incrementally build a report.
	 */
	public void addReport(String system, String mode, String report) {
		if (system == null) 
			throw new NullPointerException("Required a not null System");
		String[] dati = { system, mode, report };
		reports.add(dati);
	}
	
	/**
	 * Store the specified parameters on the CPU report.
	 * @param system
	 * @param cpu
	 * @param mode
	 * @param utilization
	 * @param speedFactor
	 * @param boundary
	 * @param schedulable
	 */
	public void addCpuSched(String system, String cpu, String mode, Double utilization, Double speedFactor, Double boundary, boolean schedulable ){
		if (system == null) {
		   throw new NullPointerException("Required a not null system.");
		}
	   if (cpu== null) {
		  throw new NullPointerException("Required a not null cpu ref.");
	   }

	   String[][] dati = new String[7][];
	   { 
			dati[0] =  new String[] { "System", system }; 
			dati[1] =  new String[] { "CpuRef", cpu }; 
			dati[2] =  new String[] { "ModeRef", mode }; 
			dati[3] =  new String[] { "Utilization", utilization == null ? null : utilization.toString() }; 
			dati[4] =  new String[] { "SpeedFactor", speedFactor == null ? null : speedFactor.toString() }; 
			dati[5] =  new String[] { "Boundary", boundary == null ? null : boundary.toString() }; 
			dati[6] =  new String[] { "Schedulable", "" + schedulable }; 
	   }
//	   { 
//			new String[] { "System", system }, 
//			new String[] { "CpuRef", cpu }, 
//			new String[] { "ModeRef", mode }, 
//			new String[] { "Utilization", utilization == null ? null : utilization.toString() }, 
//			new String[] { "SpeedFactor", speedFactor == null ? null : speedFactor.toString() }, 
//			new String[] { "Boundary", boundary == null ? null : boundary.toString() }, 
//			new String[] { "Schedulable", "" + schedulable } 
//	   };
	   cpuSched.add(dati);

	}
	
	/**
	 * Gets a list of Strings that compose the report for a certain CPU.
	 * @param id
	 * @return
	 * TODO check if it must be public
	 */
	public String[][] getCpuSched(int id) {
		
		if (id >= cpuSched.size()) {
			return null;
		}
		
		String[][] orig = (String[][]) cpuSched.get(id);
		String[][] answer = new String[orig.length][];
		for (int i=0; i<answer.length; i++) {
			answer[i] = new String[] {orig[i][0], orig[i][1]};
		}
		return answer;
	}

	/**
	 * TODO check if it must be public
	 *
	 */
	public void storeCpuSched(){
		ITreeInterface ti = tasks.getVarTree().newTreeInterface();
		for (int cpuId=0; cpuId<cpuSched.size(); cpuId++) {
			String[][] dati = (String[][]) cpuSched.get(cpuId);
			
			String system = dati[0][1]; dati[0][1] = null;
			String cpu = dati[1][1];
			String mode = dati[2][1];  dati[2][1] = null;
			// search CpuSched node or make a new one
			
			String path = null;
			
			if (!ti.exist(system, "System")) {
				Messages.sendWarning("Store a report of a not existent System (" + system + ")"
						, null, "Schedulability analysis", null);
				return;
			}
			try {
				// 1) search scheduling
				String ttpref = system;
				String ttnew = "Schedulability";
				if (!ti.exist(ttpref + S + ttnew, "Schedulability")) {
					ti.addElement(ttnew, "Schedulability", ttpref);
				}
				
				// 2) search scheduling scenario
				ttpref += S + ttnew + S +"SchedulingScenarioList"; // sys + sched + list
				ttnew = mode;
				String stnew = DataPath.makeSlashedId(mode);
				if (!ti.exist(ttpref + S + stnew, "SchedulingScenario")) {
					ti.addElement(ttnew, "SchedulingScenario", ttpref);
				}
				
				// 3) search CpuSched
				ttpref += S + stnew + S +"CpuSchedList"; // sys + sched + list + scenario + taskList
				ttnew = cpu;
				stnew = DataPath.makeSlashedId(cpu);
				if (!ti.exist(ttpref + S + stnew, "CpuSched")) {
					ti.addElement(ttnew, "CpuSched", ttpref);
				}
				
				path = ttpref + S + stnew;
				
			} catch (ITreeInterface.AddElementException e) {
				// why??? only if BuilderXML wasn't load
				e.printStackTrace();
				return;
			} catch (RuntimeException e) {
				// why??? only if BuilderXML wasn't load
				e.printStackTrace();
				return;
			}
		
			// store data
			for (int i=0; i<dati.length; i++) {
				if (dati[i][1] == null) continue; // next datum
				try {
					ti.setValue(path + S + dati[i][0], dati[i][1]);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		cpuSched.clear();
	}

	/**
	 * TODO check if it is public
	 *
	 */
	public void storeReports(){
		ITreeInterface ti = tasks.getVarTree().newTreeInterface();
		for (int cpuId=0; cpuId<reports.size(); cpuId++) {
			String[] dati = (String[]) reports.get(cpuId);
			
			String system = dati[0].startsWith("" + S) ? dati[0] : "" + S + dati[0];
			String mode= dati[1];
			
			// search SchedulingScenario node or make a new one
			
			if (!ti.exist(system, "System")) {
				Messages.sendWarning("Store a report of a not existent System (" + system + ")"
						, null, "Schedulability analysis", null);
				return;
			}
			try {
				// 1) search scheduling
				String ttpref = system;
				String ttnew = "Schedulability";
				if (!ti.exist(ttpref + S + ttnew, "Schedulability")) {
					ti.addElement(ttnew, "Schedulability", ttpref);
				}
				
				// 2) search scheduling scenario
				ttpref += S + ttnew + S +"SchedulingScenarioList"; // sys + sched + list
				ttnew = mode;
				String stnew = DataPath.makeSlashedId(mode);
				if (!ti.exist(ttpref + S + stnew, "SchedulingScenario")) {
					ti.addElement(ttnew, "SchedulingScenario", ttpref);
				}
				
				
				// 3) store value
				String path = ttpref + S + stnew + S + "Reports";

				/*
				MultiValues var = (MultiValues) ti.getValue(path);
				if (dati[2] != null) {
					var.appendValue(dati[2]);
					ti.setValue(path, var);
				}
				*/
				IVariable var =  ti.getValue(path);
				if (dati[2] != null) {
					var.set(dati[2]);
					ti.setValue(path, var);
				}
				

			} catch (ITreeInterface.AddElementException e) {
				// why??? only if BuilderXML wasn't load
				e.printStackTrace();
				return;
			} catch (RuntimeException e) {
				// why??? only if BuilderXML wasn't load
				e.printStackTrace();
				return;
			}
			
		}
	}

	
	/**
	 * To set the progress bar.
	 */
	public void setProgress(Progress newProgress) {
		if (newProgress == null) {
			progress = DEFAULT_PROGRESS;
		} else {
			progress = newProgress;
		}
		addSteps();
	}

	/**
	 * For the progress bar: sets the number of steps 
	 * the analysis must go through. 
	 *
	 */
	abstract protected void addSteps();
}
