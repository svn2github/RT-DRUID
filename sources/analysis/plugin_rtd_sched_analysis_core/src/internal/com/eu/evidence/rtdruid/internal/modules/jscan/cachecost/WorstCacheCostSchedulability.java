package com.eu.evidence.rtdruid.internal.modules.jscan.cachecost;


import com.eu.evidence.rtdruid.internal.modules.jscan.Schedulability;
import com.eu.evidence.rtdruid.internal.modules.jscan.common.RMSchedulability;
import com.eu.evidence.rtdruid.vartree.DataPath;
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
 * <li>generic_wcet<br>
 * 		- Proc_list (for each task)</br>
 * 		- Proc's wcet</br>
 * 		- Proc frequency (once every k activations of the task)</li>
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

public class WorstCacheCostSchedulability extends Schedulability {
	
	public static final String AVERAGE_UTILIZATION = "average_utilization";
	
	public static final int OVERFLOW_LIMIT = 10;

  /**
  */
  public WorstCacheCostSchedulability() {}

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

  public boolean isAccumulativelyMonotonic(double[] values) {
	  
	  if (values == null || values.length == 0) {
		  return true;
	  }

	  // searching the max
	  int maxId = 0;
	  for (int i=1;i<values.length; i++){
		  if (values[i]>values[maxId]) {
			  maxId = i;
		  }
	  }
	  
	  for (int start=0;start<values.length; start++){
		  double sumA = 0;
		  double sumB = 0;
		  for (int index=0;index<values.length; index++){
			  sumA += values[( maxId + index)% values.length];
			  sumB += values[( start + index)% values.length];
			  
			  if (sumA<sumB) {
				  return false;
			  }
		  }
	  }

	  return true;
  }
  
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
      averageUtilizations(cpuId);
      responseTime(cpuId);
	  
	  boolean isCpuSched = isSchedulable(cpuId);
	  addCpuSched(tasks.getSystem(), DataPath.removeSlash(tasks.getPrefix(cpuId)), tasks.getMode(),
				new Double(getUtilization(tasks.getSize(cpuId), cpuId)), null,
				new Double(RMSchedulability.getRMBound(tasks.getSize(cpuId))), 
  				isCpuSched);
	  
	  progress.worked(tasks.getSize(cpuId));
  }
  
  private double getCumulativeWcet(GenRes task, int numInstances) {
	  double answer = -1;
	  if (task.existProperty(Task.STR_GENERIC_WCET)) {
		  IGeneralMultiframeTaskWcet genWcet = (IGeneralMultiframeTaskWcet) task.getProperty(Task.STR_GENERIC_WCET);
		  
		  if (!genWcet.isEmpty()) {
			  answer = genWcet.getCumulativeWcet(numInstances);
		  }
	  } 
	  
	  if (answer<0) {
		  answer = task.getDouble(Task.STR_WCET) * numInstances;
	  }
	  
	  return answer;
  }
  
  private void peakUtilizations(int cpuId) {
      for (int i=0; i<tasks.getSize(cpuId); ++i) {
          GenRes t = tasks.getItem(cpuId,i);
          double u = t.getDouble(Task.STR_WCET) / t.getDouble(Task.STR_PERIOD);
          t.setProperty("utilization", u);
//         double ud = t.getDouble(Task.STR_WCET) / t.getDouble("deadline");
//         t.setProperty("dline-utilization", ud);

        }
  }
  
  private void averageUtilizations(int cpuId) {
		for (int i = 0; i < tasks.getSize(cpuId); ++i) {
			GenRes t = tasks.getItem(cpuId, i);

			double twcet = 0;
			if (t.existProperty(Task.STR_GENERIC_WCET)) {
				IGeneralMultiframeTaskWcet genWcet = (IGeneralMultiframeTaskWcet) t
						.getProperty(Task.STR_GENERIC_WCET);
				twcet = genWcet.getAverageWcet();
			} else {
				twcet = t.getDouble(Task.STR_WCET);
			}

			double u = twcet / t.getDouble(Task.STR_PERIOD);
			t.setTempProperty(AVERAGE_UTILIZATION, u);
		}
	}

  
  private void responseTime(int cpuId) {

	  boolean overflow = false;
	  //tasks.computeDMPriorities();	// tasks are sorted by priority
	  tasks.sortByPriority();
	  computeCeilings(cpuId);
	  computeBlockingTimes(cpuId);

	  for (int i=0; i<tasks.getSize(cpuId); ++i) {
		GenRes t = tasks.getItem(cpuId,i);
		double rt;
		double off_rt = 0;
		double max_rt = 0;
		int ist_num = 1;
		double new_rt = getCumulativeWcet(t, ist_num) + t.getDouble("blocking");

		// main cycle
		do {
			// compute the response time of instance ist_num;
			do {
				rt = new_rt;
				new_rt = getCumulativeWcet(t, ist_num) + t.getDouble("blocking");
				for (int j=0; j < i; ++j) {
					GenRes th = tasks.getItem(cpuId,j);
					int nt = (int) Math.ceil(rt / th.getDouble(Task.STR_PERIOD));
					new_rt += getCumulativeWcet(th, nt);
				}
				if ( (new_rt - off_rt) > OVERFLOW_LIMIT * t.getDouble(Task.STR_PERIOD)) overflow = true;
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
				if ((new_rt - off_rt) > t.getDouble(Task.STR_PERIOD)) {
					ist_num++;
					off_rt += t.getDouble(Task.STR_PERIOD);
				}
				else break;
			}
		} while (true);
		t.setProperty(Task.STR_RESPONSE_TIME, StrictMath.rint(max_rt*1E7)/1E7);
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

	String rep = new String("MultiFrame task Test\n");
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
      rep += "\t Peak Utilization   : " + tasks.getItem(cpuId,i).getProperty("utilization") + "\n";
      rep += "\t Average Utilization: " + tasks.getItem(cpuId,i).getTempProperty(AVERAGE_UTILIZATION) + "\n";
      rep += "\t Blocking factor    : " + tasks.getItem(cpuId,i).getProperty("blocking") + "\n";
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
            maxblock = Math.max(maxblock,t2.getResourceUsage(r.getName()));
          }
        }
      }
      t.setProperty("blocking", maxblock);
    }
  }
}

