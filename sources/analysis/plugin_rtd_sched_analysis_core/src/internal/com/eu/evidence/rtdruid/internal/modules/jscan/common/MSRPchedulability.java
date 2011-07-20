package com.eu.evidence.rtdruid.internal.modules.jscan.common;

import com.eu.evidence.rtdruid.internal.modules.jscan.JScan;

/**
 * MSPR Schedulability Analysis. <br>
 * <p>
 * For each task is required:
 * <ul>
 * <li>Period</li>
 * <li>DeadLine</li>
 * <li>wcet</li>
 * </ul>
 * </p>
 * <p>
 * For each task is computed:
 * <ul>
 * <li>schedulable (calculated)</li>
 * <li>priority (calculated)</li>
 * <li>ResponseTime (calculated)</li>
 * <li>Blocking (calculated)</li>
 * <li>List of reources with wcet for each resource</li>
 * </ul>
 * </p>
 * <p>
 * For each resource is computed:
 * <ul>
 * <li>ceiling (calculated)</li>
 * </ul>
 * </p>
 * 
 * @author Giuseppe Lipari && Nicola Serreli
 */

public class MSRPchedulability extends RMSchedulability {
	public static final int OVERFLOW_LIMIT = 10;

	protected boolean schedulabilityComputed = false;

	/**
	 */
	public MSRPchedulability() {
	}

	/*-----------------------------------------------------
	 * 
	 * SCHEDULABLE's methods
	 * 
	 *-----------------------------------------------------*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eu.evidence.rtdruid.internal.modules.jscan.Schedulability#compute()
	 */
	public void compute() {
		if (schedulabilityComputed) {
			return;
		}

		// Checks
		if (tasks == null) {
			throw new IllegalStateException(
					"Set a taskList before do something!");
		}

		if (risorse == null) {
			throw new IllegalStateException(
					"Set a resourceList before do something!");
		}

		
		// Compute Blocking Time
		computeBlockingTimes();

		// do schedulability analysis
		for (int i=1; i<tasks.getPrefixNumber(); i++) {
			compute(i);
		}

		// end
		schedulabilityComputed = true;
	}

	/**
	 * Check if a specific cpu is schedulable
	 */
	public boolean isSchedulable(int cpuId) {
		// check if taskSet and cpuNumber are valid
		checkCpuTaskSet(cpuId);
		// compute schedulability analysis if required
		compute();

		// Prepare the answer
		// boolean flag = true;

		//		for (int i = 0; i < tasks.getSize(cpuId); i++) {
		//			flag &= (tasks.getItem(cpuId, i).getDouble("ResponseTime") <= tasks
		//					.getItem(cpuId, i).getDouble("deadline"));
		//		}

		// end
		// return flag;
		
		throw new UnsupportedOperationException("FINIRE");
	}

	/**
	 * This method uses JScan.printReport to print the report!
	 */
	public String getReport(int cpuId) {
		checkCpuTaskSet(cpuId);
		compute();

		return JScan.printReport(this, cpuId);
	}

	/*-----------------------------------------------------
	 * 
	 * Blocking Time  
	 * 
	 *-----------------------------------------------------*/

	/**
	 *  
	 */
	protected void computeBlockingTimes() {
		throw new UnsupportedOperationException("FINIRE");
	}

	// -------------------- COMPUTE && REPORT

	/***/
	public void compute(int cpuId) {
		// CHECKS
		if (schedulabilityComputed) {
			return;
		}
		
		checkCpuTaskSet(cpuId);
		if (tasks.getSize(cpuId) == 0) {
			return;
		}

		checkResources();
		
		// WORK
		throw new UnsupportedOperationException("FINIRE");
	}

}