/* 
 * Created on Jun 17, 2004
 * 
 * $Id: OffsetSchedulabilityRTA.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */

/**
 * In this Schedulability analysis We perform Responce Time analysis where taks
 * are sorted on the basis of priority
 * 
 * @author Sachin Khaire, Nicola Serreli
 */
package com.eu.evidence.rtdruid.internal.modules.jscan.offset;

import com.eu.evidence.rtdruid.internal.modules.jscan.JScan;
import com.eu.evidence.rtdruid.vartree.DataPath;


public class OffsetSchedulabilityRTA extends OffSetSchedulability {

	private boolean IsTaskSchedulable[];

	/**
	 * Data structure which stores the worst case analysis. Here
	 * worstcaseanalysis indicates the worst case response time.
	 */
	private double WorstCaseAnalysis[];

	public OffsetSchedulabilityRTA() {
	}
	protected void addSteps() {
		for (int cpuid=1; cpuid<tasks.getPrefixNumber(); cpuid++) {
			
			long fatt = 1;
			int ntask = tasks.getSize(cpuid); 
			for (int i=0; i<F; i++) {
				fatt *= ntask;
				ntask--;
			}
			progress.addSteps(fatt);
		}
	}

	public String getReport(int cpuId) {

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
			return "Hyperplane Analysis:\n\tNo tasks\n";
		}

		if (risorse == null) {
			throw new IllegalStateException(
					"Set a resourceList before compute something!");
		}
		if (risorse.getPrefixNumber() == 0) {
			throw new IllegalStateException(
					"Set a not empty resourceList before compute something!");
		}

		String rep = new String(
				"\nSufficient Feasibility Analysis With Offset .. Fixed Priority \n");
		rep += "Using Response Time Calculation\nFixed Task = " + F+"\n";

/*		DecimalFormat d = new DecimalFormat("##0.000");
		DecimalFormat d1 = new DecimalFormat("000.00000");
		if (TotalUtilization > 1)
			rep += "\nUtilization of the Task Set is greater than 1\nTotalUtilization ="
					+ d.format(TotalUtilization) + "\n";

		if (isSchedulable(cpuId))
			rep += "\n\nTASK SET IS SCHEDULABLE WITH   " + F
					+ "  Fixed Tasks\n ";
		else
			rep += "\n\nTASK SET IS NOT SCHEDULABLE WITH "
					+ F
					+ "Fixed Tasks.\nBut Task set may be schedulable with More Number of Tasks.  ";

		rep += "\nWorst Case Responce Time of the Task is limited by the 10 times Period of the Task \n";

		rep += "\n\nTask Summary ------------------------------------------------\n";

		rep += "\n\nGeneral results\n\n"
				+ "Schedulable : "
				+ (isSchedulable(cpuId) ? "YES" : "NO")
				+ "\n"
				+ "Speed factor: "
				+ "N/A"
				+ "\n"
				+ "Load        : "
				+ TotalUtilization
				+ "\n"
				+ "\nSummary of results for each task:\n\n"
				+ "TASK,              WCET, PERIOD, DEADLINE, PRIORITY, OFFSETS, Resp. Time, CDELTA, Sched.\n";

		for (int j = 0; j < tasks.getSize(cpuId); j++) {
			Task task = (Task) tasks.getItem(cpuId, j);
			String pad = task.getName().length() < 17 ? SPAZI.substring(0,
					17 - task.getName().length()) : "";
			String cdelta = "" + task.getProperty("cdelta");

			rep += task.getName() + ", " + pad + task.getProperty("wcet")
					+ ", " + task.getProperty("period") + ", "
					+ task.getProperty("deadline") + ", "
					+ task.getProperty("priority") + ", "
					+ task.getProperty("offset") + ", "
					+ task.getProperty("ResponseTime") + ", "
					+ ("".equals(cdelta) ? "N/A" : cdelta) + ", "
					+ task.getProperty("schedulable");
			rep += "\n";
		}

		rep += "\n\nDetailed results\n\n";

		for (i = 0; i < tasks.getSize(cpuId); i++) {
			rep += "Task " + tasks.getItem(cpuId, i).getName() + " : ";
			if (tasks.getItem(cpuId, i).getTempInt("schedulable") == 1)
				rep += "SCHEDULABLE\n";
			else
				rep += "NOT SCHEDULABLE\n";

			rep += "\tPeriod: " + tasks.getItem(cpuId, i).getProperty("period")
					+ "\n";
			rep += "\tDeadline: "
					+ tasks.getItem(cpuId, i).getProperty("deadline") + "\n";
			rep += "\tWcet " + tasks.getItem(cpuId, i).getProperty("wcet")
					+ "\n";
			rep += "\tOffset: " + tasks.getItem(cpuId, i).getProperty("offset")
					+ "\n";

			rep += "\tUtilization \t\t\t"
					+ d
							.format(tasks.getItem(cpuId, i).getDouble(
									"utilization")) + "\n";
			rep += "\tBlocking Time: "
					+ tasks.getItem(cpuId, i).getProperty("blocking") + "\n";
			rep += "\tWorst Case Response Time :"
					+ d1.format(tasks.getItem(cpuId, i).getTempDouble(
							"WorstCaseResponceTime")) + "\n";
			String cdelta = "" + tasks.getItem(cpuId, i).getProperty("cdelta");
			rep += "\tCDelta : " + ("".equals(cdelta) ? "N/A" : cdelta);
			rep += "\n\n";
		}

		//	    System.out.print(rep);
*/
		return rep + JScan.printReport(this, cpuId);
	}

	/**
	 * computes the Schedulability of task set , response times , worst case i
	 * level busy periods and sensitivity for task set on the CPU i.
	 */
	public void compute(int cpuid) {
		if (!Computed[cpuid]) {

			if (!init(cpuid))
				return;

			Schedulable[cpuid] = isTaskSetSchedulable();
			//		System.out.print("\n" + Schedulable[cpuid] );
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
	 * It stores the data on the GenResList regarding the Scheduling of the Task
	 * set.
	 */
	public void storeData(int cpuId) {

		for (int i = 0; i < tasks.getSize(cpuId); i++) {
			tasks.getItem(cpuId, i).setProperty("utilization", Utilization[i]);
			tasks.getItem(cpuId, i).setTempProperty("schedulable",
					IsTaskSchedulable[i] ? 1 : 0);
			tasks.getItem(cpuId, i).setTempProperty("WorstCaseResponceTime",
					WorstCaseAnalysis[i] / 1000);

			if (IsTaskSchedulable[i]) {
				tasks.getItem(cpuId, i).setProperty("schedulable", "true");
			} else {
				tasks.getItem(cpuId, i).setProperty("schedulable", "false");
			}

			tasks.getItem(cpuId, i).setProperty("ResponseTime",
					WorstCaseAnalysis[i] / 1000);
			//			In the Current Version the CDelta is not yet calculated.

			//tasks.getItem(cpuId, i).setProperty("CDelta", "");

			//		rtdruid.desk.Messages.sendDebug(tasks.getItem(cpuId,i).toString());
		}

		addCpuSched(tasks.getSystem(), DataPath.removeSlash(tasks
				.getPrefix(cpuId)), tasks.getMode(), new Double(
				TotalUtilization), null, null, Schedulable[cpuId]);
	}

	/**
	 * This is the new version of the code. In this version of the code we are
	 * going to check schedulability of each task only once. So in each
	 * combination of the task set we are going to calculate the Response time
	 * of only one task.
	 * 
	 * @deprecated non e' al momento usata e va controllata
	 */
	public boolean isTaskSetSchedulablenew() {

		boolean schedulable = true;

		IsTaskSchedulable = new boolean[NumTasks];
		WorstCaseAnalysis = new double[NumTasks];

		final int originalNumTasks = NumTasks;
		/*
		 * int originalFixedTasks = F; int currentFixedTasks;
		 */

		for (int i = 0; i < originalNumTasks; i++) {
			IsTaskSchedulable[i] = true;
			WorstCaseAnalysis[i] = 0.0;
		}

		for (int currentNumTasks = 1; currentNumTasks <= originalNumTasks; currentNumTasks++) {
			int currenttask = currentNumTasks - 1;
			boolean takenexttask = false;
			/*
			 * if (currentNumTasks < originalFixedTasks) {
			 *     currentFixedTasks = currentNumTasks;
			 * } else {
			 *     currentFixedTasks = originalFixedTasks;
			 * }
			 * 
			 * // NumTasks = currentNumTasks;
			 * // F = currentFixedTasks ;
			 */

			initAnalysis();

			//int busyperiodstarter;
			int temp;
			do {
				initInterference();
				temp = 0;
				do {
					shiftOffsets(temp);

					// r is the response time which is calculated from the time
					// 0.
					double r = responceTimeofTaskwithOffsets(FixedTask[0], currenttask);
					// System.out.println("\nResponce :: " + r/1000) ;

					if (r > WorstCaseAnalysis[currenttask]) {
						WorstCaseAnalysis[currenttask] = r;
					}

					if (r > Deadline[currenttask]) {
						IsTaskSchedulable[currenttask] = false;
						schedulable = false;
					}

					if (r == Double.POSITIVE_INFINITY) {
						takenexttask = true;
						break;
					}

				} while ((temp = nextInterference()) != -1);

				if (takenexttask) {
					break;
				}

			} while (nextFixedTaskPermutation());
		}

		return schedulable;
	}

	/**
	 * ***** Checks Task set is schedulable or not on the Given CPU
	 * **************
	 */
	/**
	 * This version of the function is similar to the EDFOffsetSChedulability.
	 * Means we are going to check all the combinations of the fixed tasks and
	 * for each combination we are going to calculate the Response time
	 * calculation. Which is not necessary in the Fixed prioiry.
	 */
	public boolean isTaskSetSchedulable() {
		int temp;
		boolean schedulable = true;

		// init
		IsTaskSchedulable = new boolean[NumTasks];
		WorstCaseAnalysis = new double[NumTasks];
		for (int i = 0; i < NumTasks; i++) {
			IsTaskSchedulable[i] = true;
			WorstCaseAnalysis[i] = 0.0;
		}

		// init global structures used to perform analysis
		initAnalysis();

		/*
		 * EXTERNAL LOOP 
		 * 
		 * test all Fixed Task Set permutation 
		 */
		do {
			// init interference for current Task permutation
			initInterference();
			temp = 0;
			
			/*
			 * INTERNAL LOOP
			 * 
			 * test all offsets for current Fixed Task Set 
			 */
			do {
				// compute new offsets
				shiftOffsets(temp);
				
				// System.out.print("\nFixed Tasks ::: ");
				// for( i = 0 ; i < F ; i++)
				//     System.out.print(" " + FixedTask[i]);

				
				if (!isSchedulableWithCurrentOffsets(FixedTask[0],
						IsTaskSchedulable, WorstCaseAnalysis)) {
					//					System.out.println("\nNot Schedulable");

					schedulable = false;
				} else {
					//	System.out.println("\nSchedulable");
				}

			} while ((temp = nextInterference()) != -1);

			progress.worked(1);
		} while (nextFixedTaskPermutation());
		return schedulable;
	}

	/**
	 *  Checks the schedulability of the first instance of all tasks.
	 */
	protected boolean isSchedulableWithCurrentOffsets(int busyperiodstarter,
			boolean[] IsTaskSchedulable, double[] WorstCaseResponceTime) {

		boolean schedulable = true;
		double r;

		for (int i = 0; i < NumTasks; i++) {
			// r is the response time which is calculated from the time 0.
			r = responceTimeofTaskwithOffsets(busyperiodstarter, i);
			// System.out.println("\nResponce :: " + r/1000) ;
			
			if (r > WorstCaseResponceTime[i]) {
				WorstCaseResponceTime[i] = r;
			}

			if (r > Deadline[i]) {
				
				/*
				System.out.println("\nUnSchedulable Task :: " + i
						+ "\tResponse Time :: " + (r - Offset[i]));

				for (int j = 0; j < NumTasks; j++) {
					System.out.println("\tOffset ::" + j + " = " + Offset[j]
							+ "\tWcet=" + Wcet[j] + "\tPeriod = " + Period[j]
							+ "\tDeadline = " + Deadline[j]);
				}

				System.out.println("\tBusy Period Starter = " + FixedTask[0]);
				*/
				
				IsTaskSchedulable[i] = false;
				schedulable = false;
			}
		}

		return schedulable;
	}

	/**
	 * Testing Function For the Sensitivity Analysis .. It Checks it current
	 * task is schedulable and all the lower priority tasks are schedulable
	 */
	public boolean isLowerPriorityTasksSchedulableWithCurrentOffsets(int iTask) {
		int temp;

		boolean schedulable = true;
		double r;

		initAnalysis();

		do {
			initInterference();
			temp = 0;
			do {
				shiftOffsets(temp);

				for (int i = iTask; i < NumTasks; i++) {

					r = responceTimeofTaskwithOffsets(FixedTask[0], i);
					if (r > (Deadline[i])) {

						/*
						System.out.println("\nUnSchedulable Task :: " + i
								+ "\tResponse Time :: " + (r - Offset[i]));
						for (int j = 0; j < NumTasks; j++) {
							System.out.println("\tOffset ::" + j + " = "
									+ Offset[j] + "\tWcet=" + Wcet[j]
									+ "\tPeriod = " + Period[j]
									+ "\tDeadline = " + Deadline[j]);
						}

						System.out.println("\tBusy Period Starter = "
								+ FixedTask[0]);
						*/

						return false;
					}

				}

			} while ((temp = nextInterference()) != -1);

		} while (nextFixedTaskPermutation());

		return schedulable;
	}

	/* *
	 * Calculate the responce time of Task i with given offsets. <br>
	 * <br>
	 * This function give true response time only when there is strict busy
	 * period from the start upto the completion of the task i
	 * /
	public double responceTimeofTaskwithOffsets(int i) {

		double rnew, r;

		rnew = Wcet[i] + Blocking[i] + Offset[i];

		do {
			r = rnew;
			rnew = Wcet[i] + Blocking[i];

			double c;
			for (int j = 0; j < i; j++) {
				c = Math.ceil((r - Offset[j]) / Period[j]);
				if (c > 0)
					rnew += c * Wcet[j];
			}

			if (rnew > (Deadline[i] + Offset[i]))
				return rnew;

			if (rnew < r) {
				return rnew;
			}
		} while (rnew != r);

		// System.out.println("\nResponce :: " + r) ;
		return r;
	}*/

	/**
	 * Calculates the respnose time of the task i when there are idle times
	 * between time 0 and completion of the execution of task i
	 * 
	 * @param busyperiodstarter the id of task that executes as first in the busy period
	 * @param iTask index of task for whitch is required the response time
	 * 
	 * @return the response time for this task
	 */
	protected double responceTimeofTaskwithOffsets(int busyperiodstarter, int iTask) {

		double start;

		// System.out.println("\nBusy Period Starter :: " + busyperiodstarter) ;

		//Limiting Condition ..... When Wcet is zero
		if (Wcet[iTask] <= 0) {
			return Blocking[iTask];
		}

		if (busyperiodstarter > iTask) {

			// search the minimum offset of tasks with an higher priority than iTask 
			start = Offset[0];
			busyperiodstarter = 0;

			for (int j = 1; j <= iTask; j++) {
				if (Offset[j] < start && Wcet[j] > 0) {
					start = Offset[j];
					busyperiodstarter = j;
				}
			}
		} else {
			start = Offset[busyperiodstarter];
		}

		//  System.out.println("\nStart ::: " + start + "Current Task ::: " +
		// iTask);

		double bps = start;
		double bpe = bps + Wcet[busyperiodstarter] + Blocking[busyperiodstarter];
		double maxResponseTime = 0;
		double currTaskReq = Wcet[iTask] + Blocking[iTask];
		double currTaskRelease = Offset[iTask];
		double sporadicOffset = -1;
//		boolean noBlocking = false;
//		double minTaskBlock = Blocking[busyperiodstarter];
		
		/*
		 * 			EXTERNAL LOOP
		 * 
		 * Search an i-level busy period that contain an istance of task i
		 */
		do {

			double previous_bpe;
			/*
			 *		INTERNAL LOOP 
			 * 
			 * search the finish time of current busy period
			 * (like Response Time Analysis)
			 */
			do {
				previous_bpe = bpe;
				boolean isValidInstance = false;
				/*
				 * At each increment of busy period we check that current
				 * instance is included in the current busy period or not.
				 * 
				 * recompute the bpe base
				 */
				if (previous_bpe >= currTaskRelease) {
					// already know that this busy period contains an instance
					bpe = bps + currTaskReq;
					isValidInstance = true;
					if (sporadicOffset == -1) {
						sporadicOffset = bps;
					}
				} else {
					
					bpe = bps;// + minTaskBlock;
				}

				//minTaskBlock = 0;
				// Reprsents excecution time of the individual task in the busy
				// period. Check only higher priority tasks
				for (int i = 0; i < iTask; i++) {
					double nib = IsPeriodic[i] ?
							InstanceBetween(previous_bpe, bps, i)
							: SporadicInstanceBetween(isValidInstance, previous_bpe, bps, sporadicOffset, i);
					bpe += nib * Wcet[i];
					
					/*// if needed, store the blocking time of the lower priority task
					if (!noBlocking && nib >0) {
						minTaskBlock = Blocking[i];
					}*/
				}

				/*
				 * If the computed Response Time is greater than the ten task
				 * periods then it is good idea to stop to save the computation
				 */
				if ( (bpe - currTaskRelease) > (10 * Period[iTask])) {
					return Double.POSITIVE_INFINITY;
				}

			} while (previous_bpe != bpe);

			
			
			/*
			 * If the current busy period includes the currentinstance then we
			 * should provide some recaculation on the response time. When the
			 * utilization is low then, then there are many busy periods are
			 * possible where currentinstance is not included.
			 */
			if (bpe > currTaskRelease) {

				// store the Worst Case Response Time
				if ((bpe - currTaskRelease) > maxResponseTime) {
					maxResponseTime = bpe - currTaskRelease;
				}

				// Prepare to Check the next instance
				currTaskRelease+= Period[iTask];
			}

			
			/*
			 * 			SEARCH THE NEXT BUSY PERIOD
			 */

			
			/*
			 *  Check the currentinstance is less than the bpe. It indicates that
			 *  one instance is interfering in the other instance.
			 */
			if (bpe > currTaskRelease ){

				bps = bpe;
				bpe = bps + Wcet[iTask];
				currTaskReq = Wcet[iTask];
//				noBlocking = true;
				
			} else {
				
				/*
				 * stop computation ?
				 * 
				 * Only if the first relase is already checked and the last
				 * computed instance doesn't interference with the next one
				 */
				if (currTaskRelease != Offset[iTask] ) {
					// && bpe < currTaskRelease){ always true 
				
					return maxResponseTime;
				}
				
				/*
				 *  Calculate the next/nearest busy instance from the bpe.
				 */
				// 		Now here arrange the bps and bpe for next iteration
				// **********************
				double temp = Double.MAX_VALUE;
				for (int j = 0; j <= iTask; j++) {
					if (Wcet[j] > 0 && (IsPeriodic[j] || j==iTask) && (nextActivation(bpe, j) < temp) ) {
						temp = nextActivation(bpe, j);
						busyperiodstarter = j;
					}
				}
				
				/*
				 *  the new busy period start exactly when the previous end,
				 *  don't consider Blocking time
				 */
//				noBlocking = (temp == bpe);
//				minTaskBlock = noBlocking ? 0 : Blocking[busyperiodstarter];
				
				/*
				 * INIT NEW BUSY PERIOD 
				 */
				bps = temp;
				bpe = bps + Wcet[busyperiodstarter];// + minTaskBlock;

				// refresh value
				//currTaskReq = Wcet[iTask] + (noBlocking ? 0 : Blocking[iTask]);
			}


		} while (true);
	}

	/**
	 * Calculates the instances of task i between the t1 and t2. If release of
	 * task i coincides with the t1 then this instance is considered to be
	 * inside the t1 and t2. If relase of task i coincides with the t2 then it
	 * is considered as outside the t2.
	 */
	private double InstanceBetween(double t2, double t1, int i) {
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

		return (all - nottoconsider);
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

	/**
	 * Gives the time of the activation of task instance.
	 */
	private double previousActivation(double t, int i) {

		if (t < Offset[i])
			return -1;
		else
			return (Math.floor((t - Offset[i]) / Period[i]) * Period[i] + Offset[i]);
	}

	/** *** ***** ***** ***** Testing Function ***** ***** ***** **** */
	void getResult(double[] rs) {
		int j;
		for (j = 0; j < this.NumTasks; j++) {
			rs[j] = WorstCaseAnalysis[j];
		}
	}

}