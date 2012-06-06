/*
 * Created on Jun 21, 2004
 */
package com.eu.evidence.rtdruid.internal.modules.jscan.offset;

//import java.text.DecimalFormat;


import com.eu.evidence.rtdruid.internal.modules.jscan.JScan;
import com.eu.evidence.rtdruid.internal.modules.jscan.Schedulability;
import com.eu.evidence.rtdruid.internal.modules.jscan.common.RMSchedulability;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Cpu;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenRes;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Task;
import com.eu.evidence.rtdruid.vartree.abstractions.old.TaskSet;


/**
 * OffsetDMSchedulabilityComplete class performs the Exact analysis on the Task
 * set scheduled usiing DM fixed priority order. Class implements
 * RMSchedulability cos it uses some functions of Sorting the task and assigning
 * the Ceilings to the resources.
 * 
 * <br>
 * <br>
 * 
 * some Assumptions about the Test. So if task misses the deadline it continues
 * the execute uptil completion. This assumption helps us to find the Worst case
 * Response Time of the Task set.
 * <br>
 * <br>
 * The core of this analysis is the function {@link #checkTask checkTask}. See also the design document 
 * offset_analysis/exactAnalysis_01.lyx
 * @author Sachin Kaire, Nicola Serreli
 */

public class OffsetDMSchedulabilityComplete extends Schedulability {

	/** Total Number of tasks */
	protected int NumTasks;

	protected double TotalUtilization;

	protected long Period[];

	protected double Wcet[];

	protected double Utilization[];

	protected double Blocking[];

	protected double Deadline[];

	protected double Offset[];
	protected boolean IsPeriodic[];

	/** Schedulability information about each task */
	protected boolean[] IsSchedulable;

	/* *
	 * Worst case i level busy periods. WorstCaseBusyPeriod[i] indicates i-level
	 * busy period for single instance of task i.
	 */
//	private double WorstCaseBusyPeriod[];

	/**
	 * Worst case response time for each task indicates maximum distance between
	 * the completion of task and the release of task.
	 */
	private double WorstCaseResponceTime[];

	/**
	 * If the Task is not schedulable the CriticalActivation gives the time of
	 * the first unschedulable instance.
	 */
	private double CriticalActivation[];

	/** Cdelta */
	private double WcetSensitivity[];

	/**
	 * Used for the Multiprocessor configuration. Scedulable[i] gives the
	 * schedulability information about the CPU i.
	 */
	private boolean Schedulable[];

	/** Computed[i] gives the computed status for the CPU i. */
	private boolean Computed[];

	public OffsetDMSchedulabilityComplete() {
	}

	protected void addSteps() {
		long totSteps = 0;
		for (int i = 1; i < tasks.getPrefixNumber(); i++) {
			long period = new Double(tasks.getItem(i,0).getDouble("period")*1000).longValue();
			long wcet = new Double(tasks.getItem(i,0).getDouble("wcet")*1000).longValue();
			double TotalUtilization = (0.0 + wcet)/period;

			long hp = period;
			long maxOffset = new Double(tasks.getItem(i,0).getDouble("offset")*1000).longValue();
			totSteps += hp;
			for (int j = 1; j < tasks.getSize(i); j++) {
				period = new Double(tasks.getItem(i,j).getDouble("period")*1000).longValue();
				wcet = new Double(tasks.getItem(i,j).getDouble("wcet")*1000).longValue();
				
				TotalUtilization += (0.0+wcet)/period;
				if (TotalUtilization > 1) { // it never will be schedulable
					break;
				}

				
				maxOffset = StrictMath.max(maxOffset, new Double(tasks.getItem(i,j).getDouble("offset")*1000).longValue());
				long sat = gcd(hp, period);
				hp = (hp * period) / sat;
				totSteps += 2*hp + maxOffset;
			}
		}
		progress.addSteps(totSteps);
	}

	/**
	 * Override parent method: first set Task set and then set all arrays,
	 * Computed and Schedulable data structure.
	 */
	public void setTaskSet(TaskSet t) {

		int totalcpus;
		super.setTaskSet(t);

		totalcpus = tasks.getPrefixNumber();
		Computed = new boolean[totalcpus];
		Schedulable = new boolean[totalcpus];

		for (int i = 0; i < totalcpus; i++) {
			Computed[i] = false;
			Schedulable[i] = true;
		}
	}

	/**
	 * computes the Schedulability of task set , response times , worst case
	 * i-level busy periods and sensitivity for task set on the CPU i.
	 */
	public void compute(int cpuid) {
		if (!Computed[cpuid]) {
			if (!init(cpuid))
				return;
			checkTask(NumTasks - 1, IsSchedulable, //WorstCaseBusyPeriod,
					CriticalActivation, WorstCaseResponceTime, WcetSensitivity);

			Schedulable[cpuid] = true;
			for (int i = 0; i < NumTasks; i++) {
				if (IsSchedulable[i] == false) {
					Schedulable[cpuid] = false;
					break;
				}
			}
			storeData(cpuid);
			Computed[cpuid] = true;
		}
	}

	/**
	 * Gives the schedulability informatuon about the CPU i.
	 */
	public boolean isSchedulable(int cpuid) {
		compute(cpuid);
		return Schedulable[cpuid];
	}

	/**
	 * Initializes the Data structure reading from the Tree. And Calculates the
	 * blocking times according to PCP. Stores blocking times on the Tree.
	 */
	public boolean init(int cpuId) {
		if (tasks == null) {
			throw new IllegalStateException(
					"Set a taskList before compute something!");
		}
		if (tasks.getPrefixNumber() <= cpuId) {
			throw new IndexOutOfBoundsException(
					"Required a non-existent cpuId : max id ="
							+ tasks.getPrefixNumber() + " , required id = "
							+ cpuId);
		}
		if (tasks.getSize(cpuId) == 0) {
			return false;
		}

		if (risorse == null) {
			throw new IllegalStateException(
					"Set a resourceList before compute something!");
		}
		if (risorse.getPrefixNumber() == 0) {
			throw new IllegalStateException(
					"Set a not empty resourceList before compute something!");
		}

		{
			//			compute Resource Ceiling and Blocking times
			RMSchedulability tmpSched = new RMSchedulability();
			tmpSched.setTaskSet(tasks);
			tmpSched.setResourceSet(risorse);
			tasks.sortByPriority();

			tmpSched.computeCeilings(cpuId);
			tmpSched.computeBlockingTimes(cpuId);
		}

		
		GenRes cpu = tasks.getCpuItem(cpuId);	  
		final double context_switch = cpu != null && cpu.existProperty(Cpu.SCHED_CONTEXT_SWITCH_COST) ?
				2*cpu.getDouble(Cpu.SCHED_CONTEXT_SWITCH_COST) : 0;
		final double task_activation = cpu != null && cpu.existProperty(Cpu.SCHED_ACTIVATION_COST) ?
				cpu.getDouble(Cpu.SCHED_ACTIVATION_COST) : 0;
		final double task_termination = cpu != null && cpu.existProperty(Cpu.SCHED_TERMINATION_COST) ?
				cpu.getDouble(Cpu.SCHED_TERMINATION_COST) : 0;
		
		//          INIT internal structure

		NumTasks = tasks.getSize(cpuId);
		Period = new long[NumTasks];
		Wcet = new double[NumTasks];
		Utilization = new double[NumTasks];
		Blocking = new double[NumTasks];
		Deadline = new double[NumTasks];
		Offset = new double[NumTasks];
//		WorstCaseBusyPeriod = new double[NumTasks];
		IsSchedulable = new boolean[NumTasks];
		CriticalActivation = new double[NumTasks];
		WorstCaseResponceTime = new double[NumTasks];
		WcetSensitivity = new double[NumTasks];
		IsPeriodic = new boolean[NumTasks];

		TotalUtilization = 0;

		for (int iTask = 0; iTask < NumTasks; iTask++) {
			GenRes t = tasks.getItem(cpuId, iTask);

			if (!t.existProperty("period"))
				throw new IllegalStateException(
						"Period should Exists for Each Task");
			else if (t.getDouble("period") <= 0.0)
				throw new IllegalArgumentException(
						"Period argument should be set and should not be Zero");
			else
				Period[iTask] = (new Double(t.getDouble("period") * 1000))
						.longValue();

			/* WCETs set to zero when not specified */
			if (t.existProperty("wcet")) {
				Wcet[iTask] = t.getProperty("wcet") == "" ? 0 : t
						.getDouble("wcet")
						+ context_switch + task_activation + task_termination;
				Wcet[iTask] *= 1000;
			} else {
				Wcet[iTask] = 0;
				// throw new IllegalStateException(
				//     "Worst Case Execution Time is not Present");
			}

			/* Deadlines are equal to periods, when not specified */
			if (t.existProperty("deadline")) {
				Deadline[iTask] = t.getProperty("deadline") == "" ? t
						.getDouble("period") : t.getDouble("deadline");
				Deadline[iTask] *= 1000;
			} else {
				Deadline[iTask] = Period[iTask];
			}

			/* Blocking times set to zero when not specified */
			if (t.existProperty("blocking")) {
				Blocking[iTask] = t.getProperty("blocking") == "" ? 0 : t
						.getDouble("blocking");
				Blocking[iTask] *= 1000;
			} else {
				Blocking[iTask] = 0;
			}

			if (t.existProperty("offset")) {
				Offset[iTask] = t.getProperty("offset") == "" ? 0 : t
						.getDouble("offset");
				Offset[iTask] *= 1000;
			} else {
				Offset[iTask] = 0;
			}

			/* Set utilization */
			Utilization[iTask] = Wcet[iTask] / Period[iTask];
			t.setProperty("utilization", Utilization[iTask]);

			// set sporadic 
			if (t.existProperty(Task.STR_ACT_TYPE)) {
				String type = "" + t.getProperty(Task.STR_ACT_TYPE);
				IsPeriodic[iTask] =("periodic".equalsIgnoreCase(type));
			} else {
				IsPeriodic[iTask] = false;
			}
			
//			TotalUtilization += Utilization[iTask];
		}
		return true;
	}

	/**
	 * It checks the given task as it is schedulable or not with respect to all
	 * higher priority task set. <br>
	 * It is recursive so test starts from the first task and ends at the last
	 * task. <br>
	 * It genrates the worst case analysis for the given task as worst case busy
	 * period and critical activation time when worst case busy period is
	 * happened.
	 * 
	 * @param criticalActivation
	 *            If the Task is not schedulable the CriticalActivation gives
	 *            the time of the first unschedulable instance.
	 * 
	 * @param isSchedulable
	 *            contains the schedulability value of each task
	 * 
	 * @param taskid
	 *            id of current task (0..TaskNumber-1)
	 * 
	 * @param wcetSensitivity
	 *            Cdelta
	 * 
	 * @param worstCaseBusyPeriod
	 *            Worst case i level busy periods. WorstCaseBusyPeriod[i]
	 *            indicates i-level busy period for single instance of task i
	 * 
	 * @param worstCaseResponceTime
	 *            Worst case response time for each task indicates maximum
	 *            distance between the completion of task and the release of
	 *            task.
	 * 
	 * @return current hyper period
	 */
	public long checkTask(int taskid, boolean[] isSchedulable,
			//double[] worstCaseBusyPeriod,
			double[] criticalActivation,
			double[] worstCaseResponceTime, double[] wcetSensitivity) {

		long hp;

		isSchedulable[taskid] = true;
//		worstCaseBusyPeriod[taskid] = 0;
		criticalActivation[taskid] = -1;
		worstCaseResponceTime[taskid] = 0;
		wcetSensitivity[taskid] = Double.MIN_VALUE;

		/*
		 *   Highest priority task --> stop recursion
		 */
		if (taskid == 0) {
			final double requiredTime = Wcet[taskid] + Blocking[taskid];
			
			if (requiredTime > Period[taskid]) {
				isSchedulable[taskid] = false;
				criticalActivation[taskid] = Offset[taskid];
				wcetSensitivity[taskid] = requiredTime - Period[taskid];
			} else {
				isSchedulable[taskid] = true;
				wcetSensitivity[taskid] = Period[taskid] - requiredTime;
			}

			TotalUtilization = Utilization[taskid];
			
//			worstCaseBusyPeriod[taskid] = Wcet[taskid];
			worstCaseResponceTime[taskid] = requiredTime;
			
			progress.worked(Period[taskid]);
			return Period[taskid];
		}

		/*
		 *   Higher priority tasks
		 */
		hp = checkTask(taskid - 1, isSchedulable, //worstCaseBusyPeriod,
				criticalActivation, worstCaseResponceTime, wcetSensitivity);

		
		{	// Update HyperPeriod
			long sat; /* Shortest Activation Time */
			sat = gcd(hp, Period[taskid]);
			hp = (hp * Period[taskid]) / sat;
		}

		/*
		 *   current tasks
		 */
		isSchedulable[taskid] = true;
		
		
		// check total utilization before do test
		TotalUtilization += Utilization[taskid];
		if (TotalUtilization > 1) { // it never will be schedulable
			worstCaseResponceTime[taskid] = Double.POSITIVE_INFINITY;
			criticalActivation[taskid] = Double.POSITIVE_INFINITY;
			isSchedulable[taskid] = false;
			return hp;
		}

		if (Wcet[taskid] <= 0) {
			return hp;
		}

		/*
		 * Local variables 
		 */
		
		double sporadicOffset = 0;
		double bps; // Busy period Starter
		double bpe; // Busy period end
		double release; /*
						 * release time of the current instance (considering
						 * also offset)
						 */
		double maxoffset = 0; // Maximum offset within the task set.
		int currentinstance = 1; /*
									 * 'i' level busy period is calculated for
									 * the particular instance of the task i. In
									 * each 'i' level busy period, there is only
									 * one or zero instance present.
									 */
		boolean noBlocking = false;
/*		int noBlocking = -1; /*
							 * used when an Busy Period start exactly when the previous end:
							 * contains the lower priority task
							 */
/*		double minTaskBlock; /*
							  * Blocking time of the lowest priority task
							  */
		double currTaskReq; /*
							 * computation time required by taskid
							 */
		boolean isvalidinstance = false; /*
										  * This flag indicates that current
										  * instance is included in the
										  * currentbusyperiod or not.
										  */
		int bpsid = 0; /*
					    * ID of the busy period starter( one whose activates at
					    * the bps )
					    */
		//double nextidletime; // idle time from the bpe
		double worked = 0; /*
						    * used for Progress Monitor
						    */

		
		/** Start computation  */

		/*
		 * Calculation of the Max Offset (maxoffset) that is used to limit the
		 * iterations. (2*hp + maxoffset) is the limit of the bpe
		 */
		maxoffset = Offset[0];
		for (int i = 1; i <= taskid; i++)
			if (Offset[i] > maxoffset) {
				maxoffset = Offset[i];
			}

		/* Calculation of the Min Offset and put that min Offset as the bps */
		bps = Double.MAX_VALUE;
		for (int i = 0; i <= taskid; i++) {
			if (Offset[i] < bps && Wcet[i] >= 0) {
				bps = Offset[i];
				bpsid = i;
			}
		}
		
		// if all tasks has Wcet =< 0 is an error but bps could be == Double.MAX_VALUE
		// do nothing and return hp
		if (bps == Double.MAX_VALUE) {
			return hp;
		}
		

		// busy period at first iteration
//		minTaskBlock = Blocking[bpsid];
		bpe = bps + Wcet[bpsid] + Blocking[bpsid];
		
		currTaskReq = Wcet[taskid] + Blocking[taskid];
		
		/*
		 * 			EXTERNAL LOOP
		 * 
		 * Search all i-level busy period between 
		 *  0 and 2*hp+maxoffsets   
		 */
		do {
			double l;
			
			
			release = activationof(taskid, currentinstance);
			
			/*
			 *		INTERNAL LOOP 
			 * 
			 * search the finish time of current instance computation
			 * (like Response Time Analysis)
			 */
			do {
				l = bpe;

				/*
				 * At each increment of busy period we check that current
				 * instance is included in the current busy period or not.
				 * 
				 * recompute the bpe base
				 */
				if (isvalidinstance) {
					// already know that this busy period contains an instance
					bpe = bps + currTaskReq;
				} else {
					
					// check if "new" busy period contains an instance
					if (release < bpe) { // NB "<=" correct a problem with blocking time
						bpe = bps + currTaskReq;
						isvalidinstance = true;
						noBlocking = true;
						sporadicOffset = bps;
						//noBlocking = taskid;
					} else {
						bpe = bps;// + minTaskBlock;
					}
				}

				/*
				 * If the computed Response Time is greater than the ten task
				 * periods then it is good idea to stop to save the computation
				 */
				if ((l - release) > 10 * Period[taskid]) {
					//worstCaseBusyPeriod[taskid] = -1;
					worstCaseResponceTime[taskid] = Double.POSITIVE_INFINITY;
					criticalActivation[taskid] = release;
					isSchedulable[taskid] = false;
					return hp;
				}

				// minTaskBlock = 0;
				
				// Reprsents excecution time of the individual task in the busy
				// period. Check only higher priority tasks
				for (int i = 0; i < taskid; i++) {
					long nib = IsPeriodic[i] ?
								InstanceBetween(l, bps, i)
								: SporadicInstanceBetween(isvalidinstance, l, bps, sporadicOffset, i);
					bpe += nib * Wcet[i];
					
					/*// if needed, store the blocking time of the lower priority task
					if (i>noBlocking && nib >0) {
						minTaskBlock = Blocking[i];
						noBlocking = i;
					}*/
				}

				//System.out.println("I am here BPS = " + (bps/1000) + "\t BPE = "
				// 		+ (bpe/1000) + "\tl = " + (l/1000) );
			} while (bpe != l);
			
			{	/* Update Progress Monitor */
				long work =0;
				if (bpe > (2*hp + maxoffset)) {
					work = new Double((2*hp + maxoffset) - worked).longValue();
				} else {
					work = new Double(bpe - worked).longValue();
				}
				worked += work;
				progress.worked(work);
			}
			
			
			//System.out.println("T = " + taskid + "\t Busy Period = "
			//		+ (bpe - bps)/1000 ) ;

/*			if (worstCaseBusyPeriod[taskid] < (bpe - bps)) {
				worstCaseBusyPeriod[taskid] = bpe - bps;
			}
*/
			/*
			 * If the current busy period includes the currentinstance then we
			 * should provide some recaculation on the response time. When the
			 * utilization is low then, then there are many busy periods are
			 * possible where currentinstance is not included.
			 */
			if (isvalidinstance) {

				if (bpe > release + Deadline[taskid]) {
					isSchedulable[taskid] = false;
					criticalActivation[taskid] = release;
					//  System.out.println("DeadLine Miss :: Release Time = "
					// 			+ release );
				}

				// store the Worst Case Response Time
				if ((bpe - release) > worstCaseResponceTime[taskid]) {
					worstCaseResponceTime[taskid] = bpe - release;
				}

				// Prepare to Check the next instance
				currentinstance++;
				isvalidinstance = false;
				
				/*
				 *  NB: Is required to compute again the new release time
				 */
				release = activationof(taskid, currentinstance);
			}

			
			/*
			 * 			SEARCH THE NEXT BUSY PERIOD
			 */

			
			/*
			 *  Check the currentinstance is less than the bpe. It indicates that
			 *  one instance is interfering in the other instance.
			 */
			if (release <= bpe ){

				bps = bpe;
				bpe = bps + Wcet[taskid];
				currTaskReq = Wcet[taskid];
				isvalidinstance = true;

			} else {
				
				/*
				 *  Calculate the next/nearest busy instance from the bpe.
				 */
				double temp = Double.MAX_VALUE;
				for (int j = 0; j <= taskid; j++) {
					if (Wcet[j] > 0 && (IsPeriodic[j] || j==taskid) && (nextActivation(bpe, j) < temp) ) {
						temp = nextActivation(bpe, j);
						bpsid = j;
					}
				}
				
				/*
				 *  the new busy period start exactly when the previous end,
				 *  don't consider Blocking time
				 */
				if (temp != bpe) {
					noBlocking = false; // reset
					//noBlocking = -1; // reset
				}
				//minTaskBlock = noBlocking >= bpsid ? 0 : Blocking[bpsid];
				
				/*
				 * INIT NEW BUSY PERIOD 
				 */
				bps = temp;
				bpe = bps + Wcet[bpsid];// + minTaskBlock;

				// refresh value
				currTaskReq = Wcet[taskid] + (noBlocking ? 0 : Blocking[taskid]);
				//currTaskReq = Wcet[taskid] + //(noBlocking >= taskid ? 0 : Blocking[taskid]);
			}

			// loop again if the current instance interference with the next one
		} while (bpe < (2*hp + maxoffset));
		
		// commit last works
		if (worked <(2*hp + maxoffset)) {
			progress.worked(new Double((2*hp + maxoffset) - worked).longValue());			
		}
		
		// return the hyper-period of current task
		return hp;
	}

	/**
	 * Calculates teh gcd using the Eulers method
	 */
	public long gcd(long m, long n) {
		while ((m > 0) && (n > 0))
			if (m > n)
				m %= n;
			else
				n %= m;
		return m + n;
	}

	/**
	 * Calculates the instances of task i between the t1 and t2. If release of
	 * task i coincides with the t1 then this instance is considered to be
	 * inside the t1 and t2. If relase of task i coincides with the t2 then it
	 * is considered as outside the t2.
	 */
	private long InstanceBetween(double t2, double t1, int i) {
		double all, nottoconsider;

		if (t1 > t2) {
			double temp;
			temp = t2;
			t2 = t1;
			t1 = temp;
		}

		if (t1 < Offset[i])
			nottoconsider = 0;
		else
			nottoconsider = Math.ceil((t1 - Offset[i]) / Period[i]);

		if (t2 < Offset[i])
			all = 0;
		else
			all = Math.ceil((t2 - Offset[i]) / Period[i]);

		return (new Double(all - nottoconsider)).longValue();
	}

	/**
	 * Calculates the instances of a sporadic task i between the <b>localStart</b> and <b>end</b>, considering an offset. The release of
	 * task i allways coincides with the <b>localStart</b> and this instance is considered to be
	 * inside the <b>localStart</b> and <b>end</b>. If relase of task i coincides with the <b>end</b> then it
	 * is considered as outside the <b>end</b>.
	 */
	private long SporadicInstanceBetween(boolean isValidInstance, double end, double localStart, double localOffset, int i) {
		if (!isValidInstance) {
			return 0;
		}
		if (localStart == localOffset) {
			return (new Double(StrictMath.ceil((end-localStart)/Period[i]))).longValue();
		}
		// else
		return (new Double(
				StrictMath.ceil((end - localOffset) / Period[i]) 			// all
				- StrictMath.ceil((localStart - localOffset) / Period[i])	// olds
			)).longValue();
	}

	/**
	 * Give the timeofnext activation of task i from the time t. It is necessary
	 * to compair offset for this function.
	 */
	private double nextActivation(double t, int i) {

		if (t < Offset[i])
			return Offset[i];

		else
			return (Math.ceil((t - Offset[i]) / Period[i]) * Period[i] + Offset[i]);
	}

	/* *
	 * Give the time of previos activation of task i from the time t. It is
	 * necessary to compair offsets for this function.
	 */
/*	private double previousActivation(double t, int i) {

		if (t < Offset[i])
			return -1;
		else
			return (Math.floor((t - Offset[i]) / Period[i]) * Period[i] + Offset[i]);
	}*/

	/**
	 * Gives the time of the activation of task instance.
	 */
	private double activationof(int taskid, double instance) {
		return ((instance - 1) * Period[taskid] + Offset[taskid]);
	}


	/**
	 * It stores the data on the GenResList regarding the Scheduling of the Task
	 * set.
	 */
	public void storeData(int cpuId) {

		for (int i = 0; i < tasks.getSize(cpuId); i++) {

//			tasks.getItem(cpuId, i).setTempProperty("WorstCaseBusyPeriod",
//					WorstCaseBusyPeriod[i] / 1000);
			tasks.getItem(cpuId, i).setTempProperty("CriticalActivation",
					CriticalActivation[i] / 1000);
			tasks.getItem(cpuId, i).setTempProperty("WorstCaseResponceTime",
					WorstCaseResponceTime[i] / 1000);
			tasks.getItem(cpuId, i).setTempProperty("WcetSensitivity",
					WcetSensitivity[i] / 1000);
			tasks.getItem(cpuId, i).setTempProperty("CDelta",
					WcetSensitivity[i] / 1000);

			// In the Current Version the CDelta is not yet calculated.
			tasks.getItem(cpuId, i).setProperty("CDelta", "");

			if (IsSchedulable[i]) {
				tasks.getItem(cpuId, i).setTempProperty("schedulable", 1);
				tasks.getItem(cpuId, i).setProperty("schedulable", "true");
			} else {
				tasks.getItem(cpuId, i).setTempProperty("schedulable", 0);
				tasks.getItem(cpuId, i).setProperty("schedulable", "false");
			}

			tasks.getItem(cpuId, i).setProperty("blocking", Blocking[i] / 1000);
			tasks.getItem(cpuId, i).setProperty("utilization", Utilization[i]);
			tasks.getItem(cpuId, i).setProperty("ResponseTime",
					WorstCaseResponceTime[i] / 1000);

		}
		//	setSave(true);

		addCpuSched(tasks.getSystem(), DataPath.removeSlash(tasks
				.getPrefix(cpuId)), tasks.getMode(), new Double(
				TotalUtilization), null, null, Schedulable[cpuId]);
	}

	/**
	 *  Generates the Report
	 */
	public String getReport(int cpuId) {
//		final String SPAZI = "                              ";

		if (tasks == null) {
			throw new IllegalStateException("Set a taskList before get Report!");
		}
		if (tasks.getPrefixNumber() <= cpuId) {
			throw new IndexOutOfBoundsException(
					"Required a non-existent cpuId : max id ="
							+ tasks.getPrefixNumber() + " , required id = "
							+ cpuId);
		}
		if (tasks.getSize(cpuId) == 0) {
			return "No task";//throw new IllegalStateException("Set a not empty
			// taskList before get utilization!");
		}

		String rep = new String(
				"Exact Schedulability Analysis : Fixed Priority with Offsets\n");

//		DecimalFormat d = new DecimalFormat("##0.000");
/*
		if (TotalUtilization <= 0) {
			rep += "\nUtilization of the Task Set is Less Than or equal to Zero. Analysis is not performed.   \nTotalUtilization = "
					+ d.format(TotalUtilization) + "\n";
		}

		if (TotalUtilization > 1) {
			rep += "\nUtilization of the Task Set is greater than 1\nTotalUtilization = "
					+ d.format(TotalUtilization) + "\n";
		}

		int i;
		rep += "\n\nFollowing Report Shows the Actual Parameters in the \nMilliseconds but Test is carried our in";
		rep += "MicroSeconds to improve the precison.\n";
		rep += "\nNote :: When the task is not schedulable Response Time "
				+ " is limited by the 3 times Task Period And it is indicated by the Infinity\n";

		rep += "\n\nGeneral results\n\n"
				+ "Schedulable : "
				+ (isSchedulable(cpuId) ? "YES" : "NO")
				+ "\n"
				+ "Speed factor: "
				+ "?"
				+ "\n"
				+ "Load        : "
				+ TotalUtilization
				+ "\n"
				+ "\nSummary of results for each task:\n\n"
				+ "TASK,              WCET, PERIOD, DEADLINE, PRIORITY, Resp. Time, CDELTA, Sched.\n";

		for (int j = 0; j < tasks.getSize(cpuId); j++) {
			Task task = (Task) tasks.getItem(cpuId, j);
			String pad = task.getName().length() < 17 ? SPAZI.substring(0,
					17 - task.getName().length()) : "";
			rep += task.getName() + ", " + pad + task.getProperty("wcet")
					+ ", " + task.getProperty("period") + ", "
					+ task.getProperty("deadline") + ", "
					+ task.getProperty("priority") + ", "
					+ task.getProperty("ResponseTime") + ", " + "?" + ", "
					+ task.getProperty("schedulable");
			rep += "\n";
		}

		rep += "\n\nDetailed results\n\n";
		boolean sch = true;

		for (i = 0; i < tasks.getSize(cpuId); i++) {
			if (tasks.getItem(cpuId, i).getTempInt("schedulable") != 1) {
				sch = false;
				break;
			}
		}

		if (sch)
			rep += "\nTask Set is Schedulable \n\n";
		else
			rep += "\nTask Set is not Schedulable \n\n";

		for (i = 0; i < tasks.getSize(cpuId); i++) {

			rep += "Task " + tasks.getItem(cpuId, i).getName() + "\t";

			if (tasks.getItem(cpuId, i).getTempInt("schedulable") == 1) {
				rep += "SCHEDULABLE\n";
			} else {
				rep += "NOT SCHEDULABLE     ....  ";
				rep += "Critical Activation of Task at "
						+ tasks.getItem(cpuId, i).getTempProperty(
								"CriticalActivation") + "\n\n";
			}
			rep += "\tPeriod \t\t\t"
					+ tasks.getItem(cpuId, i).getProperty("period") + ":\n";
			rep += "\tWcet \t\t\t"
					+ tasks.getItem(cpuId, i).getProperty("wcet") + ":\n";
			rep += "\tOffset \t\t\t"
					+ tasks.getItem(cpuId, i).getProperty("offset") + "\n";
			rep += "\tDeadline \t\t\t"
					+ tasks.getItem(cpuId, i).getProperty("deadline") + "\n";

			rep += "\tUtilization \t\t\t"
					+ d
							.format(tasks.getItem(cpuId, i).getDouble(
									"utilization")) + "\n";

			rep += "\tBlocking Time\t\t\t"
					+ tasks.getItem(cpuId, i).getProperty("blocking") + "\n";

			//      rep += "\tWorst Case Busy Period \t\t" + tasks.getItem(cpuId,
			// i).getTempProperty("WorstCaseBusyPeriod") ;
			//      rep += "\n" ;

			rep += "\tWorst Case Response Time \t\t"
					+ d.format(tasks.getItem(cpuId, i).getTempDouble(
							"WorstCaseResponceTime"));
			rep += "\n";

			//      if(sch)
			//    		rep += "\tCdelta\t\t" +tasks.getItem(cpuId,
			// i).getTempProperty("WcetSensitivity");
			//      else
			rep += "\tCdelta\t\t ?? ";

			rep += "\n";
		}

		rep += "--------------------------------------------------\n";

		return rep;
		*/
		return rep + JScan.printReport(this, cpuId);
	}

	/** **************************************************************** */
	/** ************** For Testing ************************************* */
	/** **************************************************************** */
	public void setTestParameters(long p[], double d[], double[] b, double[] w,
			double[] o) {

		NumTasks = p.length;
		Period = (long[]) (p.clone());
		Wcet = (double[]) (w.clone());
		Blocking = (double[]) (b.clone());
		Deadline = (double[]) (d.clone());
		Offset = (double[]) (o.clone());
		Utilization = new double[NumTasks];
		IsPeriodic = new boolean[NumTasks];
		for (int i=0; i<NumTasks; i++) {
			Utilization[i] = Wcet[i] / Period[i];
			IsPeriodic[i] = true;
		}
	}

}