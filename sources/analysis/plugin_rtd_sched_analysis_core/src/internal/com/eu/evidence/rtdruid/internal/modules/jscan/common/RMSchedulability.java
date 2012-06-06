package com.eu.evidence.rtdruid.internal.modules.jscan.common;


import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.jscan.Schedulability;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Cpu;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenRes;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Task;

// project package

// standard java package

// exceptions

/**
 * Compute RM and EDF schedulability.
 *<br>
 *<br>
 *For each task is required:
 *<ul>
 * <li>Period</li>
 * <li>DeadLine</li>
 * <li>wcet</li>
 * <li>dline-utilization</li>
 * <li>schedulable      (calculated)</li>
 * <li>priority         (calculated)</li>
 * <li>preemption level (calculated)</li>
 * <li>Utilization      (calculated)</li>
 * <li>Blocking         (calculated)</li>
 * <li>List of reources with wcet for each resource</li>
 *</ul>
 *For each resource is required:
 *<ul>
 * <li>ceiling          (calculated)</li>
 *</ul>
 *
 * @author  Giuseppe Lipari && Nicola Serreli
 */

public class RMSchedulability extends Schedulability {

  /**
  */
  public RMSchedulability() {}

	protected void addSteps() {
	    for (int i=1; i<tasks.getPrefixNumber(); i++) {
	        progress.addSteps(tasks.getSize(i));
	    }
	}
	
  // -------------------- SCHEDULABLE
  
 protected void checkCpuTaskSet(int cpuId) {
	if (tasks == null) {
		throw new IllegalStateException("Set a taskList before do something!");
	}
	if (tasks.getPrefixNumber() <= cpuId) {
		throw new IndexOutOfBoundsException("Required a non-existent cpuId : max id =" + tasks.getPrefixNumber() + " , required id = " + cpuId);
	}
 }
 
 protected void checkResources() {
	  if (risorse == null) {
		  throw new IllegalStateException("Set a resourceList before do something!");
	  }
	  if (risorse.getPrefixNumber() == 0) {
		  throw new IllegalStateException("Set a not empty resourceList before do something!");
	  }
 }
	
  /***/
  public boolean isSchedulable(int cpuId)
  {
  	checkCpuTaskSet(cpuId);
	if (tasks.getSize(cpuId) == 0) {
		return true;
	}

	boolean flag = true;
    for (int i=0; i<tasks.getSize(cpuId); i++) {
      flag = flag && isSchedulable(i+1, cpuId);
    }
    return flag;
  }

  /***/
  protected boolean isSchedulable(int liv, int cpuId)
  {
    boolean ok = false;
    if (getUtilization(liv, cpuId) <= getRMBound(liv)) ok = true;
    else ok = false;

    if (ok) tasks.getItem(cpuId,liv-1).setProperty("schedulable","true");
    else tasks.getItem(cpuId,liv-1).setProperty("schedulable","false");

    return ok;
  }

  /***/
  public boolean isEDFSchedulable(int liv, int cpuId)
  {
  	checkCpuTaskSet(cpuId);
	  if (tasks.getSize(cpuId) == 0) {
		  return true;
	  }

	if (getUtilization(liv, cpuId) <= 1.0) return true;
    else return false;
  }
  
  // -------------------- COMPUTE && REPORT

  /***/
  public void compute(int cpuId)
  {
  	  checkCpuTaskSet(cpuId);
	  if (tasks.getSize(cpuId) == 0) {
		  return;
	  }

	  checkResources();

      //tasks.computeRMPriorities(cpuId);	// tasks are sorted by period
	  tasks.sortByPriority();
      computeCeilings(cpuId);
      computeBlockingTimes(cpuId);

	  GenRes cpu = tasks.getCpuItem(cpuId);	  
	  final double context_switch = cpu != null && cpu.existProperty(Cpu.SCHED_CONTEXT_SWITCH_COST) ?
			  2*cpu.getDouble(Cpu.SCHED_CONTEXT_SWITCH_COST) : 0;
	  final double task_activation = cpu != null && cpu.existProperty(Cpu.SCHED_ACTIVATION_COST) ?
			  cpu.getDouble(Cpu.SCHED_ACTIVATION_COST) : 0;
	  final double task_termination = cpu != null && cpu.existProperty(Cpu.SCHED_TERMINATION_COST) ?
			  cpu.getDouble(Cpu.SCHED_TERMINATION_COST) : 0;

      // calculate computazion
      for (int i=0; i<tasks.getSize(cpuId); ++i) {
        GenRes t = tasks.getItem(cpuId,i);
        double u = (t.getDouble("wcet") +context_switch +task_activation +task_termination)/ t.getDouble("period");
        t.setProperty("utilization", u);
//       double ud = t.getDouble("wcet") / t.getDouble("deadline");
//       t.setProperty("dline-utilization", ud);

      }
	  
	  boolean isCpuSched = isSchedulable(cpuId);
	  addCpuSched(tasks.getSystem(), DataPath.removeSlash(tasks.getPrefix(cpuId)), tasks.getMode(),
				new Double(getUtilization(tasks.getSize(cpuId), cpuId)), null,
				new Double(getRMBound(tasks.getSize(cpuId))), 
  				isCpuSched);
	  
	  progress.worked(tasks.getSize(cpuId));
  }
  
  /***/
  public String getReport(int cpuId)
  {
  	checkCpuTaskSet(cpuId);
	  if (tasks.getSize(cpuId) == 0) {
		  return "No task";//throw new IllegalStateException("Set a not empty taskList before get utilization!");
	  }

	String rep = new String("Rate Monotonic Utilization Test\n");
    rep += "Priorities have been assigned according to the Rate Monotonic Order:\n";
    rep += "tasks with shorter periods have higher priority.\n";
    rep += "Blocking times have been computed according to the Priority Ceiling\n";
    rep += "Protocol\n";

    int i;
    for (i=0; i<tasks.getSize(cpuId);i++) {
      rep += "Task " + tasks.getItem(cpuId,i).getName() + ":\n";
      rep += "\t Utilization: " + tasks.getItem(cpuId,i).getProperty("utilization") + "\n";
      rep += "\t Blocking factor: " + tasks.getItem(cpuId,i).getProperty("blocking") + "\n";
      if (isSchedulable(i+1, cpuId)) rep += "SCHEDULABLE\n";
      else rep += "NOT SCHEDULABLE\n\n";
    }
	rep += "\nIn dettaglio\n\n";
	for (i=0; i<tasks.getSize(cpuId);i++) {
	  rep += tasks.getItem(cpuId,i).toString() + "\n";
	}
	for (i=0; i<risorse.getSize(0);i++) {
	  rep += risorse.getItem(0,i).toString() + "\n";
	}
	
        
    rep += "--------------------------------------------------\n";
    return rep;
  }
	
	
  // -------------------- UTILITY
  
/**
  */
  public static double getRMBound(int n)
  {
    double rm_limit = Math.exp(1/(double)(n) * Math.log(2));
    rm_limit = n * (rm_limit - 1);
    return rm_limit;
  }

  /***/
  public double getUtilization(int liv, int cpuId)
  {
	  
    int i;
    double u = 0;
    liv = liv < tasks.getSize(cpuId) ? liv : tasks.getSize(cpuId);
    try {
      for (i=0; i<liv; i++) {
        u += tasks.getItem(cpuId,i).getDouble("utilization");
      }
      u += tasks.getItem(cpuId,liv-1).getDouble("blocking")/
           tasks.getItem(cpuId,liv-1).getDouble("period");
    } catch(IllegalStateException ue) {
		Messages.sendWarning(ue.getMessage(), null, "RM analysis", null);
    }
    return u;
  }

  /***/
  public void computeCeilings(int cpuId)
  {
	// tasks are assumed to be sorted by priority (therefore, they
    // should have a priority
    //computePreemptionLevels(cpuId);
    for (int j=0; j<risorse.getSize(0); ++j) {
      GenRes r = risorse.getItem(0,j);
      int i = 0;
      boolean fine = false;
      while (i<tasks.getSize(cpuId) && !fine) {
        if (((Task) tasks.getItem(cpuId,i)).getResourceUsage(r.getName()) > 0)
          fine = true;
        else i++;
      }
      if (i == tasks.getSize(cpuId))
        //r.setTempProperty("ceiling", tasks.getItem(cpuId,i-1).getInt("priority") + 1);
		r.setTempProperty("ceiling", 0);
      else r.setTempProperty("ceiling", tasks.getItem(cpuId,i).getInt("priority"));
    }
  }

/* @deprecated
  public void computePreemptionLevelss(int cpuId) {
    for (int i=0; i<tasks.getSize(cpuId); ++i) {
      Task t = (Task) tasks.getItem(cpuId,i);
      t.setProperty("PreemptionGroupName", t.getInt("priority"));
    }
  }*/

  /***/
  public void computeBlockingTimes(int cpuId) {
	  
	  GenRes cpu = tasks.getCpuItem(cpuId);
	  final double context_switch = cpu != null && cpu.existProperty(Cpu.SCHED_CONTEXT_SWITCH_COST) ?
			  2*cpu.getDouble(Cpu.SCHED_CONTEXT_SWITCH_COST) : 0;
	  
    // tasks are assumed to be sorted in some order (algorithm's
    // dependent)
    // moreover, we suppose that the ceilings have been computed already!
    for (int i=0; i<tasks.getSize(cpuId); ++i) {
      double maxblock = 0;
      GenRes t = tasks.getItem(cpuId,i);
      for (int j=0; j < risorse.getSize(0); ++j) {
        if (risorse.getItem(0,j).getTempInt("ceiling") >= t.getInt("priority")) {
          GenRes r = risorse.getItem(0,j);
          for (int k = i+1; k <tasks.getSize(cpuId); ++k) {
            Task t2 = (Task) tasks.getItem(cpuId,k);
            maxblock = Math.max(maxblock,t2.getResourceUsage(r.getName()) + context_switch);
          }
        }
      }
      t.setProperty("blocking", maxblock);
    }
  }
}

