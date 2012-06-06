package com.eu.evidence.rtdruid.internal.modules.jscan.cachecost;


import com.eu.evidence.rtdruid.internal.modules.jscan.Schedulability;
import com.eu.evidence.rtdruid.internal.modules.jscan.common.RMSchedulability;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Cpu;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenRes;
import com.eu.evidence.rtdruid.vartree.abstractions.old.IGeneralMultiframeTaskWcet;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Task;

// project package

// standard java package

// exceptions

/**
 * Compute schedulability of a system where proc runs once every k activations of the task
 *<br>
 *<br>
 *For each task is required:
 *<ul>
 * <li>Period</li>
 * <li>DeadLine</li>
 * <li>dline-utilization</li>
 * <li>Task's specific cache cost<br>
 * <li>Os's context switch cost<br>
 * 
 * <li>wcet             (calculated)</li>
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

public class CacheCostSchedulability extends Schedulability {
	
	public static final String AVERAGE_UTILIZATION = "average_utilization";
	
	public static final int OVERFLOW_LIMIT = 10;
	

  /**
  */
  public CacheCostSchedulability() {}

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
     flag &= (tasks.getItem(cpuId,i).getDouble(Task.STR_RESPONSE_TIME) <= tasks.getItem(cpuId,i).getDouble("deadline"));
   }
   return flag;
 }


 /***/
 protected boolean isSchedulable(int i, int cpuId)
 {
  boolean ok = false;
     if (tasks.getItem(cpuId,i).getDouble(Task.STR_RESPONSE_TIME) > tasks.getItem(cpuId,i).getDouble("deadline"))
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

      //tasks.computeRMPriorities(cpuId);	// tasks are sorted by period
	  tasks.sortByPriority();
      computeCeilings(cpuId);
      computeBlockingTimes(cpuId);

      // calculate computazion
      peakUtilizations(cpuId);
      responseTime(cpuId);
	  
	  boolean isCpuSched = isSchedulable(cpuId);
	  addCpuSched(tasks.getSystem(), DataPath.removeSlash(tasks.getPrefix(cpuId)), tasks.getMode(),
				new Double(getUtilization(tasks.getSize(cpuId), cpuId)), null,
				new Double(RMSchedulability.getRMBound(tasks.getSize(cpuId))), 
  				isCpuSched);
	  
	  progress.worked(tasks.getSize(cpuId));
  }
  
 
  /**
   * for each element,
   * cost[i] = max_{j = i+1 ... taskID} 
   * 
   */
  private double[] updatePreemptionCost(int cpuId, int taskID) {
	  
	  double[] answer = new double[tasks.getSize(cpuId)];
//	  int size = tasks.getSize(cpuId);
	  
//	  // MAX should be:
//	  double[] debug = new double[tasks.getSize(cpuId)];
//	  for (int i=0; i<size; ++i) {
//          for (int j=i+1; j<=taskID; ++j) {
//        	  double v = tasks.getItem(cpuId,j).getDouble(Task.STR_CACHE_MISS_COST);
//        	  if (debug[i] < v) {
//        		  debug[i] = v;
//        	  }
//          }
//	  }
	  
	  
	  // inverted to save time getting the property
	  for (int j=1; j<=taskID; ++j) {
          double v = tasks.getItem(cpuId,j).getDouble(Task.STR_CACHE_MISS_COST);
          for (int i=0; i<j; i++) {
        	  if (answer[i] < v) {
        		  answer[i] = v;
        	  }
          }
	  }
	  
//	  if (!Arrays.equals(debug, answer)) {
//		  RtdruidLog.log("Warring: max is different ... ");
//	  }
//	  
	  return answer;
  }
  
  private double getTaskOverhead(double time, int cpuId, int taskId, double[] costs) {
	  double answer = 0;
	  
	  // int preemptions = 0;
	  for (int i=0; i<taskId; ++i) {
			GenRes t = tasks.getItem(cpuId,i);
		  
			int local_preemptions = (int) Math.ceil(time / t.getDouble(Task.STR_PERIOD));
			
			answer = local_preemptions * costs[i];
			//preemptions += Math.ceil(time / t.getDouble(Task.STR_PERIOD));
	  }
	  // too pessimistic
	  //answer = preemptions * tasks.getItem(cpuId,taskId).getDouble(Task.STR_CACHE_MISS_COST); 
	  
	 
	  
	  return answer;
  }
  
  private void peakUtilizations(int cpuId) {
	  GenRes cpu = tasks.getCpuItem(cpuId);	  
		final double context_switch = cpu != null && cpu.existProperty(Cpu.SCHED_CONTEXT_SWITCH_COST) ?
				2*cpu.getDouble(Cpu.SCHED_CONTEXT_SWITCH_COST) : 0;
		final double task_activation = cpu != null && cpu.existProperty(Cpu.SCHED_ACTIVATION_COST) ?
				cpu.getDouble(Cpu.SCHED_ACTIVATION_COST) : 0;
		final double task_termination = cpu != null && cpu.existProperty(Cpu.SCHED_TERMINATION_COST) ?
				cpu.getDouble(Cpu.SCHED_TERMINATION_COST) : 0;
	  
	  
      for (int i=0; i<tasks.getSize(cpuId); ++i) {
          GenRes t = tasks.getItem(cpuId,i);
          double u = (t.getDouble(Task.STR_WCET) + context_switch + task_activation + task_termination)
					/ t.getDouble(Task.STR_PERIOD);
          t.setProperty("utilization", u);
//         double ud = t.getDouble(Task.STR_WCET) / t.getDouble("deadline");
//         t.setProperty("dline-utilization", ud);

        }
  }
  

  
  private void responseTime(int cpuId) {

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

//      for (int j=0; j<tasks.getSize(cpuId); ++j) {
//    	  double v = tasks.getItem(cpuId,j).getDouble(Task.STR_CACHE_MISS_COST);
//  		System.out.println("DEBUG >> Cost t " + j +"= " + v);
//    	  
//      }

	  for (int i=0; i<tasks.getSize(cpuId); ++i) {
		GenRes t = tasks.getItem(cpuId,i);
		double rt;
		double off_rt = 0;
		double max_rt = 0;
		int ist_num = 1;
		double[] costs = updatePreemptionCost(cpuId, i);
//		
//		System.out.print("DEBUG >> Cost t " + i +": ");
//		for (double c:costs)
//			System.out.print(c + "  ");
//		System.out.println("\n");
		
		double new_rt = t.getDouble(Task.STR_WCET) * ist_num + t.getDouble("blocking") 
					+ context_switch + task_activation + task_termination;
		new_rt += getTaskOverhead(new_rt, cpuId, i, costs);

		// main cycle
		do {
			// compute the response time of instance ist_num;
			do {
				rt = new_rt;
				new_rt = t.getDouble(Task.STR_WCET) * ist_num + t.getDouble("blocking")
						+ context_switch + task_activation + task_termination
						+ getTaskOverhead(rt, cpuId, i, costs);
				for (int j=0; j < i; ++j) {
					GenRes th = tasks.getItem(cpuId,j);
					double nt = Math.ceil(rt / th.getDouble("period"));
					new_rt += nt * th.getDouble(Task.STR_WCET)
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
	  
  }
  
  /***/
  public String getReport(int cpuId)
  {
  	checkCpuTaskSet(cpuId);
	  if (tasks.getSize(cpuId) == 0) {
		  return "No task";//throw new IllegalStateException("Set a not empty taskList before get utilization!");
	  }

	String rep = new String("Cache Miss Cost Schedulability analysis Test (FP) \n");
    rep += "Blocking times have been computed according to the Priority Ceiling\n";
    rep += "Protocol\n";

    int i;
    for (i=0; i<tasks.getSize(cpuId);i++) {

        String procs = "";
    	if (tasks.getItem(cpuId,i).existProperty(Task.STR_GENERIC_WCET)) {
    		IGeneralMultiframeTaskWcet genWcet = (IGeneralMultiframeTaskWcet) tasks.getItem(cpuId,i)
    				.getProperty(Task.STR_GENERIC_WCET);
    		procs = "\t Model              : " + genWcet + "\n";
    	}

    	
      rep += "Task " + tasks.getItem(cpuId,i).getName() + ":\n";
      rep += "\t Utilization   : " + tasks.getItem(cpuId,i).getProperty("utilization") + "\n";
      rep += "\t Blocking factor    : " + tasks.getItem(cpuId,i).getProperty("blocking") + "\n";
      rep += "\t Response    : " + tasks.getItem(cpuId,i).getProperty("ResponseTime") + "\n";
      rep += "\t Deadline    : " + tasks.getItem(cpuId,i).getProperty("deadline") + "\n";
      rep += procs;
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
	
	
  // -------------------- UTILITY

  /***/
  public double getUtilization(int liv, int cpuId)
  {
	    return 0;
	    //throw new UnsupportedOperationException();
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

  /***/
  public void computeBlockingTimes(int cpuId) {
		GenRes cpu = tasks.getCpuItem(cpuId);
		final double context_switch = cpu != null
				&& cpu.existProperty(Cpu.SCHED_CONTEXT_SWITCH_COST) ? 2 * cpu
				.getDouble(Cpu.SCHED_CONTEXT_SWITCH_COST) : 0;
	  
	  
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
            maxblock = Math.max(maxblock,t2.getResourceUsage(r.getName()) +context_switch);
          }
        }
      }
      t.setProperty("blocking", maxblock);
    }
  }
}

