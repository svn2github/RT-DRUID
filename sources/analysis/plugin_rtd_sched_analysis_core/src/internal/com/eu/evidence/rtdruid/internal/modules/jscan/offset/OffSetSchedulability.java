package com.eu.evidence.rtdruid.internal.modules.jscan.offset;

import com.eu.evidence.rtdruid.internal.modules.jscan.Schedulability;
import com.eu.evidence.rtdruid.internal.modules.jscan.common.RMSchedulability;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Cpu;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenRes;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Task;
import com.eu.evidence.rtdruid.vartree.abstractions.old.TaskSet;


/**
 * Compute Sufficent schedulability with Offset assignments. <br>
 * <br>
 * For each task is required:
 * <ul>
 * <li>Period</li>
 * <li>DeadLine</li>
 * <li>wcet</li>
 * <li>dline-utilization</li>
 * <li>schedulable (calculated)</li>
 * <li>priority (calculated)</li>
 * <li>preemption level (calculated)</li>
 * <li>Utilization (calculated)</li>
 * <li>Blocking (calculated)</li>
 * <li>List of reources with wcet for each resource</li>
 * </ul>
 * For each resource is required:
 * <ul>
 * <li>ceiling (calculated)</li>
 * </ul>
 * 
 * @author Giuseppe Lipari && Nicola Serreli && Sachin Khaire
 */

public abstract class OffSetSchedulability extends Schedulability {
	protected boolean Schedulable[];

	protected boolean Computed[];

	protected int NumTasks;

	/**
	 * The total utilization of the task set.
	 */
	protected double TotalUtilization;

	/**
	 * The periods of the tasks. Its length is <CODE>numTasks</CODE>.
	 */
	protected long Period[];

	/**
	 * The worst-case execution times of the tasks. Its length is <CODE>
	 * numTasks</CODE>.
	 */
	protected double Wcet[];

	/**
	 * The relative deadlines of the tasks. This deadline value is relative to
	 * the activation of every job in the task. The performed analysis is proved
	 * to work only when the relative deadline is smaller than or equal to the
	 * period. Its length is <CODE>numTasks</CODE>.
	 */
	protected double Deadline[];

	/**
	 * The utilization factors od the tasks. It corresponds to the ratio between
	 * the WCET and the period. Its length is <CODE>numTasks</CODE>.
	 */
	protected double Utilization[];

	/**
	 * The blocking times of the tasks. This value is due to the longest
	 * critical section among the lower priority tasks, sharing the same
	 * resource of the considered task. Its length is <CODE>numTasks</CODE>.
	 */
	protected double Blocking[];

	/** Task's offsets stored in vartree */
	protected double RealOffset[];

	/*
	 * 
	 * Now Data Structure useful for the Analysis for the given problem
	 *  
	 */

	/** Number of Fixed Tasks */
	protected int F;

	/* Give the system to select the fixed tasks and analyse it autmatically. */
	// private boolean auto ;

	/** Indexes of Fixed Tasks in the System */
	protected int FixedTask[];

	/** The calculated offset for all task while each iteration */
	protected double Offset[];

	/** indexes of the Interferences of the fixed tasks */
	private long Interference[];

	/**
	 * indexes of the Maximum Interferences of the given fix tasks on the basis
	 * of the Hyper period.
	 */
	private long MaxInterference[];

	/** Period of the HyperTask for the other tasks */
	private long HyperTaskPeriod[];

	/** For each task, contains if a task is fixed or not */
	private boolean IsFixed[];

	/** Hyper Task Offsets used to reduce the same caluclation again again */
	private double HyperTaskOffset[];

	/** It stores Gcds which are temporaly required by the method shiftOffsets */
	private long ShortestActivationPeriod[];

	/** For each task, contains if a task is periodic (true) or sporadic (false)  */
	protected boolean IsPeriodic[];

	/*
	 * 
	 * Abstract functions
	 *  
	 */

	public abstract String getReport(int cpuId);

	public abstract void compute(int cpuid);

	public abstract boolean isSchedulable(int cpuid);

	/**
	 * Override parent method: first set Task set and then set all arrays
	 */
	public void setTaskSet(TaskSet t) {
		super.setTaskSet(t);

		int i = 0;
		int totalcpus = tasks.getPrefixNumber();

		Computed = new boolean[totalcpus];
		Schedulable = new boolean[totalcpus];

		for (i = 0; i < totalcpus; i++) {
			Computed[i] = false;
			Schedulable[i] = false;
		}
	}

	/** Set the number of fixed tasks */
	public void setTotalFixedTask(int n) {
		F = n;
	}

	/**
	 * It initializes the analysis for the Suffient test.
	 */
	public void initAnalysis() {
		FixedTask = new int[F];

		for (int i = 0; i < F; i++) {
			FixedTask[i] = i;
		}

		Interference = new long[F - 1];
		MaxInterference = new long[F - 1];
		Offset = new double[NumTasks];
		HyperTaskPeriod = new long[F];
		HyperTaskOffset = new double[F];
		ShortestActivationPeriod = new long[NumTasks];
		IsFixed = new boolean[NumTasks];

		Offset[FixedTask[0]] = 0;
		HyperTaskOffset[0] = RealOffset[FixedTask[0]];

		for (int i = 0; i < NumTasks; i++) {
			IsFixed[i] = false;
		}

		for (int i = 0; i < F; i++) {
			IsFixed[FixedTask[i]] = true;
		}
	}

	// ------------------- Next permutation -----------------------------

	/**
	 * Calculates new task perutation for the task set as next Fixed Tasks
	 */
	protected boolean nextFixedTaskPermutation() {

		/*
		 * System.out.print("\n------------------------------------------------------------" +
		 * "\n\t\tNext Permutation" +
		 * "\n------------------------------------------------------------");
		 */

		// search the next valid permutation of task's index
		if (!nextPermutation(FixedTask, NumTasks, F))
			return false;

		// init basic structure
		Offset[FixedTask[0]] = 0;

		HyperTaskOffset[0] = RealOffset[FixedTask[0]];

		for (int i = 0; i < NumTasks; i++)
			IsFixed[i] = false;
		for (int i = 0; i < F; i++)
			IsFixed[FixedTask[i]] = true;

		return true;
	}

	/**
	 * Computes next Permutation of the given Array in P
	 * 
	 * @param P   an array of integer between 0 and N-1
	 * @param N   the number of distinc integer (0 ... N-1)
	 * @param C   length of the array P (number of distinct integer)
	 */
	private boolean nextPermutation(int[] P, int N, int C) {
		// the current level of permutation : always start from lower level
		int currLevel = C - 1;

		while (true) {
			// the current element contains the last valid integer ?
			if (P[currLevel] != N - 1) {
				// no : increment this value and check if it is already used
				//      (if no, the array contains a valid permutation)
				P[currLevel]++;
				if (isValidPermutation(P, currLevel))
					break;
			} else {
				// yes : all permutation of this "level" are already checked,
				//       then go to the previous level and make a new loop
				currLevel--;
			}

			// 0 is the higer level, then a level<0 means that all permutation
			// are checked
			if (currLevel < 0) {
				return false;
			}
		}

		// if current level isn't the lower one, for each level search the lower
		// integer that make this "sub-array" a valid permutation
		for (int j = currLevel + 1; j < C; j++) {
			for (P[j] = 0; !isValidPermutation(P, j); P[j]++) {
				// do nothing
			}
		}

		return true;
	}

	/**
	 * Check if given array contains a valid permutation. A permutation is valid
	 * if it contains only distinct integers and this function check that the
	 * value contained in the element <b>idx </b> is different from all others
	 * elements between index <b>0 </b> to index <b>idx-1 </b>
	 * 
	 * @param P   the array
	 * @param idx the lower level
	 */
	private boolean isValidPermutation(int[] P, int idx) {
		
		// value stored in the lower level 
		int value = P[idx];
		
		// check if that value is stored in one of higer level
		for (int level = idx - 1; level >= 0; level--) {
			if (value == P[level]) {
				return false;
			}
		}
		return true;
	}

	// ------------------- Interferences -----------------------------

	/**
	 * Initilizes the inference pattern for the given task set Interfernces for
	 * given Fixed Task configuration
	 */
	protected void initInterference() {
		// contains the "hyper-period" of fixed tasks  
		long past_lcm = Period[FixedTask[0]];

		// for each fixed task, compute the max interference and set to 0 the current interference
		for (int i = 0; i < F - 1; i++) {
			// store hyper-period and current interference
			HyperTaskPeriod[i] = past_lcm;
			Interference[i] = 0;
			
			// compute next hyper-period and max interference
			long new_gcd = gcd(Period[FixedTask[i + 1]], past_lcm);
			past_lcm = (Period[FixedTask[i + 1]] * past_lcm) / new_gcd;
			MaxInterference[i] = (int) (Period[FixedTask[i + 1]] / new_gcd) - 1;
		}

		// store the last one
		HyperTaskPeriod[F - 1] = past_lcm;

		// for all not fixed tasks, store all gcd
		for (int j = 0; j < NumTasks; j++) {
			if (!IsFixed[j]) {
				ShortestActivationPeriod[j] = gcd(Period[j], past_lcm);
			}
		}

	}

	/**
	 * Calculates all parameters (indexes) of the next interferences for the Fixed Task Set.
	 * 
	 * @return the higer index of changed elements, or -1 if there is no more interferences
	 */
	protected int nextInterference() {
		/*
		 * Index F-2 indicates last element of the Interference array
		 */
		for (int i = F - 2; i >= 0; i--) {

			// if the interference for this level is already the last, continue
			// with the higher level
			if (Interference[i] == MaxInterference[i]) {
				continue;
			}
			Interference[i]++;

			// before return, reset all interferences of lower levels
			for (int j = i + 1; j < F - 1; j++) {
				Interference[j] = 0;
			}

			return i;

		}
		
		// there is no more interferences for given Fixed Task Set 
		return -1;
	}

	/**
	 * On the Basis of current interference of the Fixed Task it shifts other
	 * tasks by assiging then new offset value. Offset value assigned to task
	 * with two differt method according to the task is Fix or not.
	 */
	protected void shiftOffsets(int interferenceIndex) {
		
		/*
		 * compute the new offset for all fixed tasks with index higer than
		 * interferenceIndex
		 * 
		 * NB : each loop compute the new offset for the fixed task with the
		 * next index
		 */
		for (int i = interferenceIndex; i < F - 1; i++) {
			
			// temp values : used to reduce computations
			HyperTaskOffset[i + 1] = HyperTaskOffset[i] + Interference[i]
					* HyperTaskPeriod[i];
			double duration = HyperTaskOffset[i + 1]
					- RealOffset[FixedTask[i + 1]];
			
			// new offset for the next Fixed Task
			Offset[FixedTask[i + 1]] = Math.ceil(duration
					/ Period[FixedTask[i + 1]])
					* Period[FixedTask[i + 1]] - duration;

		}
		
		/*
		 *  compute the new offsets for all not fixed tasks
		 */
		for (int j = 0; j < NumTasks; j++) {
			if (!IsFixed[j]) {
				// compute and store
				double duration = HyperTaskOffset[F - 1] - RealOffset[j];
				Offset[j] = Math.ceil(duration / ShortestActivationPeriod[j])
						* ShortestActivationPeriod[j] - duration;
			}
		}

		/*
		 * System.out.print("\nFixed Tasks :: ");
		 * 
		 * for(i = 0 ; i < F ; i++){ System.out.print("\t" + FixedTask[i]); }
		 * 
		 * System.out.print("\n");
		 * 
		 * for(i = 0 ; i < NumTasks; i++){ System.out.print("\t" + Offset[i]); }
		 */

		return;
	}

	/**
	 *  Euclidean method to Find GCD of the Number
	 */
	protected long gcd(long m, long n) {
		while ((m > 0) && (n > 0))
			if (m > n)
				m %= n;
			else
				n %= m;
		return m + n;
	}

	/**
	 * Initilizes parameters read from the Task Tree <br>
	 * <br>
	 * Priority ceiling protocol is used to calculate the ceiling of the
	 * resources
	 * 
	 * Tasks are sorted by priority
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

		if (F > tasks.getSize(cpuId) || F < 1) {
			throw new IllegalStateException(
					"Fixed Task should be within 1 and TotalTasks-1 ("
							+ tasks.getSize(cpuId) + ")");
		}

		{

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

		int iTask;

		NumTasks = tasks.getSize(cpuId);
		Period = new long[NumTasks];
		Wcet = new double[NumTasks];
		Deadline = new double[NumTasks];
		Utilization = new double[NumTasks];
		Blocking = new double[NumTasks];
		RealOffset = new double[NumTasks];
		IsPeriodic = new boolean[NumTasks];
		TotalUtilization = 0;

		for (iTask = 0; iTask < NumTasks; iTask++) {
			GenRes t = tasks.getItem(cpuId, iTask);

			Period[iTask] = (new Double(t.getDouble("period") * 1000))
					.longValue();
			/* Deadlines are equal to periods, when not specified */
			if (t.existProperty("deadline")) {
				Deadline[iTask] = t.getProperty("deadline") == "" ? Period[iTask]
						: t.getDouble("deadline");
				Deadline[iTask] *= 1000;
			} else {
				Deadline[iTask] = Period[iTask];
			}
			/* WCETs set to zero when not specified */
			if (t.existProperty("wcet")) {
				Wcet[iTask] = t.getProperty("wcet") == "" ? 0 : t
						.getDouble("wcet")
						+ context_switch + task_activation + task_termination;
				Wcet[iTask] *= 1000;
			} else {
				Wcet[iTask] = 0;
			}
			/* Blocking times set to zero when not specified */
			if (t.existProperty("blocking")) {
				Blocking[iTask] = t.getProperty("blocking") == "" ? 0 : t
						.getDouble("blocking");
				Blocking[iTask] *= 1000;
			} else {
				Blocking[iTask] = 0.0;
			}

			if (t.existProperty("offset")) {
				RealOffset[iTask] = t.getProperty("offset") == "" ? 0 : t
						.getDouble("offset");
				RealOffset[iTask] *= 1000;
			} else {
				RealOffset[iTask] = 0;
			}

			// set sporadic 
			if (t.existProperty(Task.STR_ACT_TYPE)) {
				String type = "" + t.getProperty(Task.STR_ACT_TYPE);
				IsPeriodic[iTask] =("periodic".equalsIgnoreCase(type));
			} else {
				IsPeriodic[iTask] = false;
			}

			/* Set utilization */
			Utilization[iTask] = Wcet[iTask] / Period[iTask];
			TotalUtilization += Utilization[iTask];
		}

		return true;
	}

	/** *********************************************************************************** */
	/**
	 * *************** Testing of the Algorithm from random inputs
	 * ***********************
	 */
	/** *********************************************************************************** */

	void initTest(long[] P, double[] D, double[] B, double[] W, double[] O) {
		NumTasks = P.length;
		Period = (long[]) P.clone();
		Deadline = (double[]) D.clone();
		Blocking = (double[]) B.clone();
		Wcet = (double[]) W.clone();
		RealOffset = (double[]) O.clone();
		IsPeriodic = new boolean[NumTasks];

		Utilization = new double[NumTasks];
		TotalUtilization = 0;
		int iTask;
		for (iTask = 0; iTask < NumTasks; iTask++) {

			/* Set utilization */
			Utilization[iTask] = Wcet[iTask] / Period[iTask];
			TotalUtilization += Utilization[iTask];
			IsPeriodic[iTask] = true;
		}
	}

	void setRunTimeTestOffset(double[] o) {
		Offset = (double[]) o.clone();
	}
}