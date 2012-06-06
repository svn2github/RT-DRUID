package com.eu.evidence.rtdruid.internal.modules.jscan.common;


import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Cpu;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenRes;



// project package

// standard java package

// exceptions

/**
 * Compute RTA schedulability.
 *<br>
 *<br>
 *For each task is required:
 *<ul>
 * <li>Period</li>
 * <li>DeadLine</li>
 * <li>wcet</li>
 * <li>schedulable      (calculated)</li>
 * <li>priority         (calculated)</li>
 * <li>ResponseTime         (calculated)</li>
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

public class RTASchedulability extends RMSchedulability {
	public static final int OVERFLOW_LIMIT = 10;

  /**
  */
  public RTASchedulability() {}
  
  // -------------------- SCHEDULABLE
  
  /***/
  public boolean isSchedulable(int cpuId)
  {
  	checkCpuTaskSet(cpuId);
	if (tasks.getSize(cpuId) == 0) {
		return true;
	}

	boolean flag = true;
    for (int i=0; i<tasks.getSize(cpuId); i++) {
      flag &= (tasks.getItem(cpuId,i).getDouble("ResponseTime") <= tasks.getItem(cpuId,i).getDouble("deadline"));
    }
    return flag;
  }


  /***/
  protected boolean isSchedulable(int i, int cpuId)
  {
   boolean ok = false;
      if (tasks.getItem(cpuId,i).getDouble("ResponseTime") > tasks.getItem(cpuId,i).getDouble("deadline"))
        ok = false;
      else ok = true;

    if (ok) tasks.getItem(cpuId,i).setProperty("schedulable","true");
    else tasks.getItem(cpuId,i).setProperty("schedulable","false");

    return ok;
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

	  boolean overflow = false;
	  //tasks.computeDMPriorities();	// tasks are sorted by priority
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
	  
	  for (int i=0; i<tasks.getSize(cpuId); ++i) {
		GenRes t = tasks.getItem(cpuId,i);
		double rt;
		double off_rt = 0;
		double max_rt = 0;
		double ist_num = 1;
		double new_rt = t.getDouble("wcet") * ist_num + t.getDouble("blocking")
					+ context_switch + task_activation + task_termination;

		// main cycle
		do {
			// compute the response time of instance ist_num;
			do {
				rt = new_rt;
				new_rt = t.getDouble("wcet") * ist_num + t.getDouble("blocking") 
						+ context_switch + task_activation + task_termination;
				for (int j=0; j < i; ++j) {
					GenRes th = tasks.getItem(cpuId,j);
					double nt = Math.ceil(rt / th.getDouble("period"));
					new_rt += nt * th.getDouble("wcet")  
							+ context_switch + task_activation + task_termination;
				}
				if ( (new_rt - off_rt) > OVERFLOW_LIMIT * t.getDouble("period")) overflow = true;
			} while (new_rt > rt && !overflow);

			// if it is too high
			if (overflow) {
				max_rt = Double.POSITIVE_INFINITY;
				break;
			}
			else {
				// store max response time
				max_rt = max_rt > (new_rt - off_rt) ? max_rt : (new_rt - off_rt);
				
				// look the next instance? yes if current instance interferces with the next one
				if ((new_rt - off_rt) > t.getDouble("period")) {
					ist_num++;
					off_rt += t.getDouble("period");
				}
				else break;
			}
		} while (true);
		t.setProperty("ResponseTime", StrictMath.rint(max_rt*1E7)/1E7);
		isSchedulable(i, cpuId);
		
		progress.worked(1);
	  }
	  
	  boolean isCpuSched = isSchedulable(cpuId);
	  addCpuSched(tasks.getSystem(), DataPath.removeSlash(tasks.getPrefix(cpuId)), tasks.getMode(),
  				null, //new Double(getUtilization(tasks.getSize(cpuId), cpuId)),
				null, // speedFactor
				null, //new Double(getRMBound(tasks.getSize(cpuId))),
				isCpuSched);

  }
  
  /***/
  public String getReport(int cpuId)
  {
  	checkCpuTaskSet(cpuId);
	if (tasks.getSize(cpuId) == 0) {
		return "No task";//throw new IllegalStateException("Set a not empty taskList before get utilization!");
	}

    String rep = new String("Response Time Analysis");
    rep += "Priorities have been assigned according to the Deadline Monotonic Order:\n";
    rep += "Blocking times have been computed according to the Priority Ceiling\n";
    rep += "Protocol\n";
    int i;
    for (i=0; i<tasks.getSize(cpuId);i++) {
      rep += "Task " + tasks.getItem(cpuId,i).getName() + ":\n";
      rep += "\t Response Time: " + tasks.getItem(cpuId,i).getProperty("ResponseTime") + "\n";
      rep += "\t Deadline: " + tasks.getItem(cpuId,i).getProperty("deadline") + "\n";
      if (isSchedulable(i, cpuId)) rep += "SCHEDULABLE\n";
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
}
