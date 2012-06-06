package com.eu.evidence.rtdruid.internal.modules.jscan.common;

// project package

// standard java package


import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;

import com.eu.evidence.rtdruid.internal.modules.jscan.Schedulability;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Cpu;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenRes;


// exceptions

/**
 * This class implements the Fixed Priority (either Rate Monotonic or
 * other fixed priority assignment) Analysis using the Hyperplanes
 * theory. This analysis may be applied in the following hypothesis:
 * <UL>
 * <LI>deadlines smaller than or equal to the periods;
 * <LI>presence of blocking time (possibly equal to zero), due to
 * critical sections;
 * <LI>generic fixed priority assignment possibly not RM;
 * </UL>
 * In the internal data structure of the object, tasks are ordered by
 * decreasing priority. <BR>An important restriction applies: <B>the
 * number of tasks must be smaller than the number of bits used to
 * represent an <CODE>int</CODE></B>, otherwise some, not tested,
 * misbehaviour may happen.<br>
 *<br>
 *For each task is required:
 *<ul>
 * <li>Period</li>
 * <li>DeadLine</li>
 * <li>wcet</li>
 * <li>Utilization      (calculated)</li>
 * <li>schedulable      (calculated)</li>

 * <li>dline-utilization</li>
 * <li>priority         (calculated)</li>
 * <li>preemption level (calculated)</li>
 * <li>Blocking         (calculated)</li>
 * <li>List of reources with wcet for each resource</li>
 *</ul>
 *For each resource is required:
 *<ul>
 * <li>ceiling          (calculated)</li>
 *</ul>
 
 * @author  <A href="http://feanor.sssup.it/~bini/">Enrico Bini</A> && Nicola Serreli
 * @see <A href="http://feanor.sssup.it/~bini/papers/2002BinBut.html">The Space of Rate Monotonic Schedulability</A>
 */

public class HyperplanesAnalysis extends Schedulability {
	
	protected void addSteps() {}

    public boolean isSchedulable(int cpuId) {
		// sets the rigth tasks 
		if (!init(cpuId)) 
			return true;	// tasks.size == 0
		
		//assignDMPriorities();
		return isFPSchedulable();
	}
	
	/**
	 * The number of tasks in the set.
	 */
	protected int numTasks;
	/**
	 * The total utilization of the task set.
	 */
	protected double totalU;
	/**
	 * The periods of the tasks. Its length is <CODE>numTasks</CODE>.
	 */
	protected double period[];
	/**
	 * The worst-case execution times of the tasks. Its length is
	 * <CODE>numTasks</CODE>.
	 */
	protected double wcet[];
	/**
	 * The relative deadlines of the tasks. This deadline value is
	 * relative to the activation of every job in the task. The
	 * performed analysis is proved to work only when the relative
	 * deadline is smaller than or equal to the period. Its length is
	 * <CODE>numTasks</CODE>.
	 */
	protected double deadline[];
	/**
	 * The utilization factors od the tasks. It corresponds to the
	 * ratio between the WCET and the period. Its length is
	 * <CODE>numTasks</CODE>.
	 */
	protected double utilization[];
	/**
	 * The blocking times of the tasks. This value is due to the
	 * longest critical section among the lower priority tasks,
	 * sharing the same resource of the considered task. Its length is
	 * <CODE>numTasks</CODE>.
	 */
	protected double blocking[];
	/**
	 * A vector of set of constraints. The constraints are implemented
	 * by the class {@link PlaneConstraint}. Due to the nature of the
	 * Fixed Priority schedulability, all the constraints in every set
	 * must be ORed to produce the constraint for the selected
	 * task. All the <CODE>numTasks</CODE> constraints of the tasks
	 * must be ANDed in order to guarantee the schedulability of the
	 * whole tasks set. The length of the vector
	 * <CODE>constraints</CODE> is <CODE>numTasks</CODE>.
	 */
	protected Vector constraints;

	/**
	 * Complete constructor of the object.
	 *  The field <CODE>numTasks</CODE> of the object is set equal to the minimum
	 * of the length of the four vectors passed as parameters.
	 */
	public HyperplanesAnalysis() {
		constraints = new Vector();
		totalU = 0;
	}

	/** set all values
	 * */
	protected boolean init(int cpuId) {
		if (tasks == null) {
			throw new IllegalStateException("Set a taskList before compute something!");
		}
		if (tasks.getPrefixNumber() <= cpuId) {
			throw new IndexOutOfBoundsException("Required a non-existent cpuId : max id =" + tasks.getPrefixNumber() + " , required id = " + cpuId);
		}
		if (tasks.getSize(cpuId) == 0) {
			return false;
		}

		if (risorse == null) {
			throw new IllegalStateException("Set a resourceList before compute something!");
		}
		if (risorse.getPrefixNumber() == 0) {
			throw new IllegalStateException("Set a not empty resourceList before compute something!");
		}
		{ // compute Resource Ceiling and  Blocking times
			RMSchedulability tmpSched = new RMSchedulability();
			tmpSched.setTaskSet(tasks);
			tmpSched.setResourceSet(risorse);
 
// 			tasks.computeDMPriorities();
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
//		double d[], c[], b[];

		numTasks = tasks.getSize(cpuId);
		constraints = new Vector(numTasks);
		period = new double[numTasks];
		wcet = new double[numTasks];
		deadline = new double[numTasks];
		utilization = new double[numTasks];
		blocking = new double[numTasks];
		totalU = 0;
		for (iTask = 0; iTask < numTasks; iTask++) {
			GenRes t = tasks.getItem(cpuId,iTask);

			SortedSet constrSet;

			period[iTask] = t.getDouble("period");
			/* Deadlines are equal to periods, when not specified */
			if (t.existProperty("deadline")) {
				deadline[iTask] = t.getProperty("deadline") == "" ? period[iTask] : t.getDouble("deadline");
				
				//if (deadline[iTask] > period[iTask]) {
				//	deadline[iTask] = period[iTask];
				//}
			} else {
				deadline[iTask] = period[iTask];
			}
			/* WCETs set to zero when not specified */
			if (t.existProperty("wcet")) {
				wcet[iTask] = t.getProperty("wcet") == "" ? 0 : t.getDouble("wcet")
						+ context_switch + task_activation + task_termination;
			} else {
				wcet[iTask] = 0;
			}
			/* Blocking times set to zero when not specified */
			if (t.existProperty("blocking")) {
				blocking[iTask] = t.getProperty("blocking") == "" ? 0 : t.getDouble("blocking");
			} else {
				blocking[iTask] = 0;
			}
			/* Set utilization */
			utilization[iTask] = wcet[iTask] / period[iTask];
			totalU += utilization[iTask];
			
			constrSet = new TreeSet();
			buildKeyPoints(iTask, deadline[iTask], iTask, 0, constrSet);
			constraints.add(iTask, constrSet);
			/* CORE */
		}
		return true;
	}
	/**
	 */
	public void compute(int cpuId) {
		if (!init(cpuId)) 
			return;	// tasks.size == 0
		storeData(cpuId);
	}

	/**
	 * Assign Deadline Monotonic priorities. The data structure is
	 * sorted according the new priority order. Deadline Monotonic,
	 * which becomes Rate Monotonic when deadlines are equal to the
	 * periods, is proved to be optimal among the static priority
	 * assignments. When two deadlines are equal, tie is arbitrarily
	 * broken.
	 */
	public int[] assignDMPriorities() {
		/*
		 * The i element of the vector is the index of the task with
		 * priority i. If priority aren't changed then taskWithPri[i]
		 * equals i.
		 */
		
		constraints.clear();
		
		int taskWithPri[];
		double toBeSort[];
		int i, j;
		boolean changed;
		double[] t, d, c, b;

		t = new double[numTasks];
		d = new double[numTasks];
		c = new double[numTasks];
		b = new double[numTasks];
		taskWithPri = new int[numTasks];
		toBeSort = new double[numTasks];
		for (i = 0; i < numTasks; i++) {
			t[i] = period[i];
			toBeSort[i] = d[i] = deadline[i];
			c[i] = wcet[i];
			b[i] = blocking[i];
		}
		changed = false;
		for (i = 0; i < numTasks; i++) {
			double curMin;

			curMin = Double.MAX_VALUE;
			for (j = 0; j < numTasks; j++) {
				if (curMin > toBeSort[j]) {
						taskWithPri[i] = j;
						curMin = toBeSort[j];
				}
			}
			toBeSort[taskWithPri[i]] = Double.MAX_VALUE;
			if (taskWithPri[i] != i)
				changed = true;

		}
		if (changed) {
			for (i = 0; i < numTasks; i++) {
//				SortedSet constrSet;

				period[i] = t[taskWithPri[i]];
				deadline[i] = d[taskWithPri[i]];
				wcet[i] = c[taskWithPri[i]];
				blocking[i] = b[taskWithPri[i]];
			}
		}
	
		for(i = 0; i < numTasks; i++) {
			SortedSet constrSet;
			constrSet = new TreeSet();
			buildKeyPoints(i, deadline[i], i, 0, constrSet);
			constraints.add(i, constrSet);
		}
		return taskWithPri;
	}

	/**
	 * Assign user-specified fixed priorities. The new priorities are
	 * specified by the vector passed as parameter. Low number means
	 * high priority. After the call of this method task indeces are
	 * changed following the new assigned priority. Tasks running on
	 * the same priority are not implemented yet. If the parameter
	 * <CODE>pri</CODE> is not in the [0,n-1] format, nothing is
	 * changed.
	 * @param pri the n-sized vector of integers in [0,n-1] specifying
	 * the priorities. The vector contains task indeces in current
	 * data structure. <CODE>prim[i]</CODE> is the task with priority
	 * <CODE>i</CODE> (low value, high priority), such that
	 * <CODE>prim[0]</CODE> is the index of the highest priority task.
	 */

	
public void assignExistingPriorities()
	{
		int i ;
		constraints.clear();
			
		for (i = 0; i < numTasks; i++) {
			SortedSet constrSet ;
			constrSet = new TreeSet();
			buildKeyPoints(i, deadline[i], i, 0, constrSet);
			constraints.add(i, constrSet);
		}
	}
	


public void assignMyPriorities(int[] pri) {
		int i, j;
		boolean badData;
		double[] t, d, c, b;

		constraints.clear();
		/*
		 * The input vector must be good.
		 */
		if (pri.length != numTasks)
			return;
		for (i = 0; i < numTasks; i++) {
			badData = true;
			for (j = 0; j < numTasks; j++)
				if (pri[j] == i)
					badData = false;
			if (badData)
				return;
		}

		t = new double[numTasks];
		d = new double[numTasks];
		c = new double[numTasks];
		b = new double[numTasks];
		for (i = 0; i < numTasks; i++) {
			t[i] = period[i];
			d[i] = deadline[i];
			c[i] = wcet[i];
			b[i] = blocking[i];
		}
		
		for (i = 0; i < numTasks; i++) {
			period[i] = t[ pri[i] ];
			deadline[i] = d[ pri[i] ];
			wcet[i] = c[pri[i]];
			blocking[i] = b[pri[i]];
			/* Update internal data structures */
		}
		
		for (i = 0; i < numTasks; i++) {
			SortedSet constrSet;
			constrSet = new TreeSet();
			buildKeyPoints(i, deadline[i], i, 0, constrSet);
			constraints.add(i, constrSet);
			}		
	}


	/**
	 * Check the schedulability of the tasks set.
	 * @return <CODE>true</CODE> if schedulable, <CODE>false</CODE>
	 * otherwise.
	 */
	public boolean isFPSchedulable() {
		return isFPSchedulable(-1, this.wcet, 0);
	}

	/**
	 * Check the schedulability of a particular task in the set.
	 * @param sel the index of the task to be checked.
	 */
	public boolean isFPSchedulable(int sel) {
		return isFPSchedulable(sel, this.wcet, 0);
	}

	/**
	 * Check the of a modified tasks set. New worst-case execution
	 * time are considered.
	 * @param v the vector of new WCET.
	 * @return <CODE>true</CODE> if schedulable <CODE>false</CODE>
	 * otherwise.
	 */
	public boolean isFPSchedulable(double[] v) {
		return isFPSchedulable(-1, v, 0);
	}

	/**
	 * Check the schedulability by the implicit fixed priority
	 * assignment. The priorities are implicitly assigned by the tasks
	 * orderding in all the internal data structures. The lowest task
	 * index has the highest priority.
	 * @param sel the task to be checked. If -1 then all the set is
	 * checked. If greater than or equal to<CODE>min(numTasks,
	 * v.length)</CODE>, <CODE>false</CODE> is returned.
	 * @param v the vector of comupation times. May be different than
	 * the vector <CODE>wcet</CODE>. If <CODE>sel</CODE> is between 0
	 * and <CODE>min(numTasks, v.length)</CODE>-1, only
	 * <CODE>v[sel]</CODE>is taken into account.
	 * @param contextSwitch the time for context switch in the system.
	 * @return <CODE>true</CODE> if the selected task (or the whole
	 * set) is schedulable, <CODE>false</CODE> otherwise.
	 */
	protected boolean isFPSchedulable(
		int sel,
		double[] v,
		double contextSwitch) {
		int iTask, n;
		boolean testOK;

		double[] modifiedWcet = new double[this.numTasks];

		n = Math.min(numTasks, v.length);
		if (sel >= n || sel < -1)
			return false;
		/* Modify wcet to take into account context switch */
		for (iTask = 0; iTask < n; iTask++) {
			modifiedWcet[iTask] = v[iTask] + contextSwitch * 2;
		}
		testOK = false;

		if (sel == -1) {
			/* Forall tasks in the set */
			for (iTask = 0; iTask < n; iTask++) {
				SortedSet constrSet;
				Iterator iterOnCx;
				double oldWcet;

				constrSet = (SortedSet) constraints.get(iTask);
				iterOnCx = constrSet.iterator();
				testOK = false;
				oldWcet = modifiedWcet[iTask];
				modifiedWcet[iTask] += this.blocking[iTask];

				/* For all constraints of iTask */
				while (iterOnCx.hasNext()) {
					PlaneConstraint myCx;

					myCx = (PlaneConstraint) iterOnCx.next();

					/* CORE */
					if (myCx.planeCheck(modifiedWcet)) {
						testOK = true;
						break;
					}
				}
				modifiedWcet[iTask] = oldWcet;
				if (!testOK) {
					break;
				}
			}
		} else {
			SortedSet constrSet;
			Iterator iterOnCx;

			constrSet = (SortedSet) constraints.get(sel);
			iterOnCx = constrSet.iterator();
			testOK = false;
			modifiedWcet[sel] += this.blocking[sel];

			/* For all constraints of iTask */
			while (iterOnCx.hasNext()) {
				PlaneConstraint myCx;

				myCx = (PlaneConstraint) iterOnCx.next();

				/* CORE */
				if (myCx.planeCheck(modifiedWcet)) {
					testOK = true;
					break;
				}
			}
		}
		return testOK;
	}

	/**
	 * Return a vector of the maximum allowed blocking times. The
	 * array is sorted by tasks priority as usual.
	 * @return the vector of blocking times.
	 */
	public double[] maxAllowedBlock() {
		return maxAllowedBlock(0);
	}

	/**
	 * Return a vector of the maximum allowed blocking times, in the
	 * case of context switch. The array is sorted by tasks priority
	 * as usual.
	 * @param contextSwitch the system context switch.
	 * @return the vector of blocking times.
	 */
	public double[] maxAllowedBlock(double contextSwitch) {
		int iTask;

		double[] modifiedWcet = new double[this.numTasks];
		double[] maxBlock = new double[this.numTasks];

		/* Modify wcet to take into account context switch */
		for (iTask = 0; iTask < this.numTasks; iTask++) {
			modifiedWcet[iTask] = this.wcet[iTask] + contextSwitch * 2;
		}

		/* Forall tasks in the set */
		for (iTask = 0; iTask < this.numTasks; iTask++) {
			SortedSet constrSet;
			Iterator iterOnCx;
			double curBlock;

			constrSet = (SortedSet) constraints.get(iTask);
			iterOnCx = constrSet.iterator();
			maxBlock[iTask] = Double.MIN_VALUE;

			/* For all constraints of iTask */
			while (iterOnCx.hasNext()) {
				PlaneConstraint myCx;

				myCx = (PlaneConstraint) iterOnCx.next();

				/* CORE */
				curBlock = -myCx.planeDistance(modifiedWcet);
				if (curBlock > maxBlock[iTask]) { /* MAX */
					maxBlock[iTask] = curBlock;
				}
			}
		}
		return maxBlock;
	}

	/**
	 * Return the minimum fraction of the total processor bandwidth
	 * which can still schedule the tasks set.
	 * @return the fraction of the bandwidth. If greater than 1, the
	 * task set is not schedulable.
	 */
	public double minAllowedSpeed() {
		return minAllowedSpeed(0);
	}

	/**
	 * Return the minimum fraction of the total processor bandwidth
	 * which can still schedule the tasks set, in case of context
	 * switch time different than zero.
	 * @param contextSwitch the context switch of the system.
	 * @return the fraction of the bandwidth. If greater than 1, the
	 * task set is not schedulable.
	 */
	public double minAllowedSpeed(double contextSwitch) {
		int iTask;
		double rightAlpha, minAlpha, curAlpha;

		double[] modifiedWcet = new double[this.numTasks];

		/* Modify wcet to take into account context switch */
		for (iTask = 0; iTask < this.numTasks; iTask++) {
			modifiedWcet[iTask] = this.wcet[iTask] + contextSwitch * 2;
		}
		rightAlpha = Double.MIN_VALUE;

		/* Forall tasks in the set */
		for (iTask = 0; iTask < this.numTasks; iTask++) {
			SortedSet constrSet;
			Iterator iterOnCx;
			double oldWcet;

			/* Take into account the blocking time and save last
			 * value */
			oldWcet = modifiedWcet[iTask];
			modifiedWcet[iTask] += this.blocking[iTask];

			constrSet = (SortedSet) constraints.get(iTask);
			iterOnCx = constrSet.iterator();
			minAlpha = Double.MAX_VALUE;

			/* For all constraints of iTask */
			while (iterOnCx.hasNext()) {
				PlaneConstraint myCx;

				myCx = (PlaneConstraint) iterOnCx.next();

				/* CORE */
				curAlpha = myCx.planeValue(modifiedWcet) / myCx.b;
				if (curAlpha < minAlpha) { /* MIN */
					minAlpha = curAlpha;
				}
			}
			if (minAlpha > rightAlpha) { /* MAX */
				rightAlpha = minAlpha;
			}
			modifiedWcet[iTask] = oldWcet;
		}
		return rightAlpha;
	}

	/**
	 * Returns a vector containing the maximum individual increment of
	 * the WCET which keeps the task set schedulable. The value in the
	 * i<SUP>th</SUP> position is relative to the i<SUP>th</SUP> task.
	 * @return the vector of increments.
	 */
	public double[] maxAllowedInc() {
		return maxAllowedInc(0);
	}

	/**
	 * Returns a vector containing the maximum individual increment of
	 * the WCET which keeps the task set schedulable, in the case of
	 * context switch different than zero. The value in the
	 * i<SUP>th</SUP> position is relative to the i<SUP>th</SUP> task.
	 * @param contextSwitch the system context switch.
	 * @return the vector of increments.
	 */
	public double[] maxAllowedInc(double contextSwitch) {
		int iTask, j;

		/* Init vectors */
		double[] modifiedWcet = new double[this.numTasks];
		for (iTask = 0; iTask < this.numTasks; iTask++) {
			modifiedWcet[iTask] = 0;
		}
		double[] rightInc = new double[this.numTasks];
		for (iTask = 0; iTask < this.numTasks; iTask++) {
			rightInc[iTask] = Double.POSITIVE_INFINITY;
		}
		double[] maxInc = new double[this.numTasks];

		for (iTask = 0; iTask < this.numTasks; iTask++) {
			SortedSet constrSet;
			Iterator iterOnCx;
			double numeratore, curInc;
			double oldWcet;

			modifiedWcet[iTask] = this.wcet[iTask] + contextSwitch * 2;
			/* Take into account the blocking time and save last
			 * value */
			oldWcet = modifiedWcet[iTask];
			modifiedWcet[iTask] += this.blocking[iTask];
			constrSet = (SortedSet) constraints.get(iTask);
			iterOnCx = constrSet.iterator();
			for (j = 0; j <= iTask; j++)
				maxInc[j] = Double.NEGATIVE_INFINITY;

			while (iterOnCx.hasNext()) {
				PlaneConstraint myCx;

				myCx = (PlaneConstraint) iterOnCx.next();

				/* CORE */
				numeratore = -myCx.planeDistance(modifiedWcet);
				for (j = 0; j <= iTask; j++) {
					curInc = numeratore / myCx.a[j];
					if (curInc > maxInc[j]) { /* MAX */
						maxInc[j] = curInc;
					}
				}
			}
			for (j = 0; j <= iTask; j++) {
				if (maxInc[j] < rightInc[j]) { /* MIN */
					rightInc[j] = maxInc[j];
				}
			}

			/*
			 * If current task is not schedulable set rightInc[>iTask]=-Infinity
			 * and exit.
			 */
			//             if (!this.isFPSchedulable(modifiedWcet)) {
			//                 for(iTask++; iTask < this.numTasks; iTask++) {
			//                     rightInc[iTask] = Double.NEGATIVE_INFINITY;
			//                 }
			//             }
			modifiedWcet[iTask] = oldWcet;
		}
		return rightInc;
	}

	/**
	 * Build the internal data structure of the object. For the
	 * details, please refer to the <A
	 * href="http://feanor.sssup.it/~bini/papers/2002BinBut.html">paper</A>.
	 * @param toBeSchedTask the task index, the whole
	 * <CODE>constrSet</CODE> belong to. It ranges from 0 to
	 * <CODE>numTasks</CODE>-1.
	 * @param tPoint the task must terminated not later than
	 * <CODE>tPoint</CODE>. It is the argument of the set
	 * <B>P</B><SUB>i</SUB>.
	 * @param iTask the higher priority task we are considering in the
	 * current execution.
	 * @param iPlane the index of the constraint/plane.
	 * @param constrSet the data structure containing all the
	 * constraints relative to the task <CODE>toBeSchedTask</CODE>.
	 */
	private void buildKeyPoints(
		int toBeSchedTask,
		double tPoint,
		int iTask,
		int iPlane,
		SortedSet constrSet) {

		/* Safety check */
		if (tPoint >= 0) {
			if (iTask == 0) {
				
				if(tPoint == 0) return ;
				
				int[] coef = new int[toBeSchedTask + 1];
				coef[toBeSchedTask] = 1;
				for (int i = toBeSchedTask - 1; i >= 0; i--)
					coef[i] = (int) Math.ceil(tPoint / period[i]);
				PlaneConstraint oneConstr =
					new PlaneConstraint(tPoint, coef, iPlane);
				constrSet.add(oneConstr);
			} else {

				/* If the constrain is already present, dont branch */
				if (!constrSet.contains(new PlaneConstraint(tPoint))) {

					/* CORE */
					buildKeyPoints(
						toBeSchedTask,
						Math.floor(tPoint / period[iTask - 1]) * period[iTask
							- 1],
						iTask - 1,
						iPlane << 1,
						constrSet);
					buildKeyPoints(
						toBeSchedTask,
						tPoint,
						iTask - 1,
						iPlane << 1 | 1,
						constrSet);
				}
			}
		}
	}

	/**
	 * Converts this object into a string. First it is printed the
	 * number of tasks and the total utilization of the whole
	 * set. Then for every tasks in the set, the first line shows
	 * respectively: period, deadline, worst-case execution time and
	 * blocking time. Finally, all the constraints are showed: the
	 * index in binary (useful to rebuild the path in the tree of
	 * recurrent calls), all the coefficients and the bound.
	 * @return the string.
	 */
	public String toString() {
		String s;
		SortedSet myS;
		int i;

		s = new String("Number of tasks: \t" + this.numTasks + "\n");
		s = s + "Total utilization: \t" + this.totalU;
		for (i = 0; i < this.numTasks; i++) {
			Iterator iterOnCx;

			s =
				s
					+ "\n\n"
					+ period[i]
					+ "\t"
					+ deadline[i]
					+ "\t"
					+ wcet[i]
					+ "\t"
					+ blocking[i]
					+ "\n\n";
			myS = (SortedSet) constraints.get(i);
			iterOnCx = myS.iterator();
			while (iterOnCx.hasNext()) {
				PlaneConstraint myCx;

				myCx = (PlaneConstraint) iterOnCx.next();
				s = s + myCx.toString() + "\n";
			}
		}
		return s;
	}

	/*
	 * by Peppe. Commented before integrating.
	 */
	public String getReport(int cpuId) {
		if (tasks == null) {
			throw new IllegalStateException("Set a taskList before compute something!");
		}
		if (tasks.getPrefixNumber() <= cpuId) {
			throw new IndexOutOfBoundsException("Required a non-existent cpuId : max id =" + tasks.getPrefixNumber() + " , required id = " + cpuId);
		}
		if (tasks.getSize(cpuId) == 0) {
			return "Hyperplane Analysis:\n\tNo tasks\n";
		}

		if (risorse == null) {
			throw new IllegalStateException("Set a resourceList before compute something!");
		}
		if (risorse.getPrefixNumber() == 0) {
			throw new IllegalStateException("Set a not empty resourceList before compute something!");
		}

		DecimalFormat dform = new DecimalFormat("###.#%");
		String rep = new String("Hyperplane Analysis");
		rep
			+= "Priorities have been assigned according to the Deadline Monotonic Order:\n";

		rep += "The system is ";
		if (isSchedulable(cpuId))
			rep += "SCHEDULABLE\nThe system can be slowed down of a factor of ";
		else
			rep
				+= "NOT SCHEDULABLE\nThe system should be accellerated by a factor of ";

		String perc = dform.format(minAllowedSpeed());
		rep += perc;
		
		double[] cdelta = maxAllowedInc();
		for (int i=0; i< tasks.getSize(cpuId); i++) {
			rep += "\n\tCDelta for " + tasks.getItem(cpuId,i).getName() + " = " +  cdelta[i];
		}
//		rep += perc + "\n" + toString() + "\n";
//		for (int i = 0; i < tset.size(); i++) {
//			rep += "Task "
//				+ tset.getTaskAt(i).getName()
//				+ " has a distance of "
//				+ tset.getTaskAt(i).getProperty("distance")
//				+ " from its contraint\n";
//		}
		rep += "\n--------------------------------------------------\n";
		return rep;
	}
	
	public void storeData(int cpuId) {
		double[] cdelta = maxAllowedInc();
		for (int i=0; i< tasks.getSize(cpuId); i++) {
			tasks.getItem(cpuId, i).setProperty("CDelta", cdelta[i]);
			tasks.getItem(cpuId, i).setProperty("wcet", wcet[i]);
			tasks.getItem(cpuId, i).setProperty("blocking", blocking[i]);
			tasks.getItem(cpuId, i).setProperty("utilization", utilization[i]);

//			rtdruid.desk.Messages.sendDebug(tasks.getItem(cpuId,i).toString());
		}
		addCpuSched(tasks.getSystem(), DataPath.removeSlash(tasks.getPrefix(cpuId)), tasks.getMode(),
				new Double(totalU), new Double(minAllowedSpeed()),
				new Double(RMSchedulability.getRMBound(tasks.getSize(cpuId))), 
				isSchedulable(cpuId));
	}
}
