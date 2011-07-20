package com.eu.evidence.rtdruid.internal.modules.jscan.partialorder;

import java.util.HashMap;
import java.util.Iterator;

import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

public class PartialOrderChecker {
	private static final double ALLOWED_ERROR = 1e-10;

	private final PartialOrderData data;
	
	private HashMap<String, String> task2Event = new HashMap<String, String>();

	/**
	 * Builds a new ckecker bases on specified data.
	 */
	public PartialOrderChecker(PartialOrderData data) {
		this.data = data;
	}

	/**
	 * This method checks that everything is fine and correct.
	 * 
	 * @return true if everything is correct.
	 */
	public boolean checkAll() {
		boolean answer = true;

		for (Iterator<ProcData> iter = data.getProcs().iterator(); iter
				.hasNext()
				//&& answer
				;) {
			ProcData proc = iter.next();
			data.getReporter().message("Checking ... " + proc);
			answer &= checkProc(proc);
		}

		return answer;
	}

	// **********************************************

	/**
	 * This method checks if a proc is correctly mapped to a task and if the
	 * relations with preceding and following procs are correct.
	 * 
	 * @param proc
	 *            the proc under test
	 * 
	 * @return true if everything is correct
	 */
	private boolean checkProc(ProcData proc) {

		if (proc.getProcPeriod() == null) {
			data.getReporter().error(proc, "Period is missing for procs " + proc.getProcName());
			return false;
		}
		
		boolean answer = true;
		TaskData task = proc.getTask();

		{ // check proc to task mapping
			if (task == null) {
				return answer;
			}
			boolean tmp = false;
			
			if (task2Event.containsKey(task.getTaskName())) {
				
				String tEvent = task2Event.get(task.getTaskName()); // == null if proc.isPeriodic()
				String pEvent = proc.getEventProvider(); // == null if task.isPeriodic()
				
				if (tEvent == null && pEvent != null) {
					data.getReporter().error(proc, "An sporadic proc ("+proc.getProcName()+") is mapped to a periodic task (" + task.getTaskName() + ")" );
					return false;
				} else if (tEvent != null && pEvent == null) {
					data.getReporter().error(proc, "An periodic proc ("+proc.getProcName()+") is mapped to a sporadic task (" + task.getTaskName() + ")" );
					return false;
				} else if (tEvent != null && !tEvent.equals(pEvent)) {
					data.getReporter().error(proc, "An sporadic proc ("+proc.getProcName()+") is mapped to a sporadic task (" + task.getTaskName() + ") related to a different event\n" +
							"ProcEvent " + pEvent + " - TaskEvent " + tEvent );
					return false;
				}
				
			} else {
				task2Event.put(task.getTaskName(), proc.getEventProvider());
			}
			
			
			if (proc.isPeriodic() && task.isPeriodic()) {
				
				tmp = checkPeriods(proc.getProcPeriod(), task.getTaskPeriod());
				
				if (!tmp) {
					// check if is the case "one activation every q"
					TimeVar procP = proc.getProcPeriod();
					TimeVar taskP = task.getTaskPeriod();
					
					tmp = checkPeriodsRatio(procP, taskP) > 0;
				}
				
				if (!tmp) {
					data.getReporter().error(proc, "Uncompatible periods among proc " + proc.getProcName()
							+ " and task " + task.getTaskName());
				}
			} else if (!proc.isPeriodic() && !task.isPeriodic()) {
				
				tmp = checkPeriods(proc.getProcPeriod(), task.getTaskPeriod());
			}
			
			answer &= tmp;
		}

		// check relation between this proc and following ones.
		for (Iterator<ProcData> iter = proc.getFollowingProcs().iterator(); iter
				.hasNext();) {
			
			ProcData nextProc = iter.next();
			TaskData nextTask = nextProc.getTask();
			
			if (task == nextTask) {
				boolean tmp = proc.getTaskPosition() < nextProc.getTaskPosition();
				answer &= tmp;
				if (!tmp) {
					data.getReporter().error(proc, "Uncompatible position among proc " + proc.getProcName() 
							+ " and proc " + nextProc.getProcName());
				}

			} else {
				
				boolean tmp1_a = checkPeriods(proc.getProcPeriod(), task.getTaskPeriod());
				boolean tmp1_b = checkPeriods(nextProc.getProcPeriod(), nextTask.getTaskPeriod());
				boolean tmp1 = tmp1_a && tmp1_b; 
				if (!tmp1_a) {
					data.getReporter().error(proc, "Partial order among procs mapped in differents tasks requires that this proc has the same period of the task");
				}
				if (!tmp1_b) {
					data.getReporter().error(nextProc, "Partial order among procs mapped in differents tasks requires that this proc has the same period of the task");
				}
				
				TimeVar cPeriod = proc.getProcPeriod();
				TimeVar nPeriod = nextProc.getProcPeriod();
				
				boolean tmp2 = true;
				final int periodRelation = cPeriod.compareTo(nPeriod); 
				if ( periodRelation == 0) { // same period
					
					if (checkHigherPriority(proc.getTaskPriority(), nextProc.getTaskPriority())) {
						TimeVar cOffset = task.getTaskOffset();
						TimeVar nOffset = nextTask.getTaskOffset();
						
						tmp2 &= cOffset == null || cOffset.get() == null ? 
								( true ) : //assuming null offset== 0
								( nOffset == null || nOffset.get() == null ?
										((Double) cOffset.get()).doubleValue() == 0 : // ok only if current offset is 0
										 cOffset.compareTo(nOffset)	< 0 );
						
						
						
						
					} else if (checkHigherPriority(nextProc.getTaskPriority(), proc.getTaskPriority())) {
						// disabled because is much complex and much rare

						// This case requires that the response time of current proc is smaller than the
						// offset time of the following proc (or generically, task)

						tmp2 = false;

						
						
//						TimeVar cOffset = task.getTaskOffset();
//						TimeVar nOffset = nextTask.getTaskOffset();
//						
//						tmp2 &= task.getTaskOffset() 
//						
					} else {
						tmp2 = false;
					}

					if (!tmp2) {
						data.getReporter().error(proc, "Uncompatible priority and offsets among proc " + proc.getProcName() 
								+ " and proc " + nextProc.getProcName());
					}

					answer &= tmp1 && tmp2;
					
				} else if ( periodRelation == 0) { // current proc with larger period
					
					
					if (checkHigherPriority(proc.getTaskPriority(), nextProc.getTaskPriority())) {
						TimeVar cOffset = task.getTaskOffset();
						TimeVar nOffset = nextTask.getTaskOffset();
						
						tmp2 &= cOffset == null || cOffset.get() == null ? 
								( true ) : //assuming null offset== 0
								( nOffset == null || nOffset.get() == null ?
										((Double) cOffset.get()).doubleValue() == 0 : // ok only if current offset is 0
										 cOffset.compareTo(nOffset)	< 0 );
						
						
						
						
					} else if (checkHigherPriority(nextProc.getTaskPriority(), proc.getTaskPriority())) {
						// disabled because is much complex and much rare

						// This case requires that the response time of current proc is smaller than the
						// offset time of the following proc (or generically, task)

						tmp2 = false;

						
						
//						TimeVar cOffset = task.getTaskOffset();
//						TimeVar nOffset = nextTask.getTaskOffset();
//						
//						tmp2 &= task.getTaskOffset() 
//						
					} else {
						tmp2 = false;
					}

					if (!tmp2) {
						data.getReporter().error(proc, "Uncompatible priority and offsets among proc " + proc.getProcName() 
								+ " and proc " + nextProc.getProcName());
					}

					answer &= tmp1 && tmp2;
					
					
					
				} else { // current proc with small period
					
					if (checkHigherPriority(proc.getTaskPriority(), nextProc.getTaskPriority())) {
						TimeVar cOffset = task.getTaskOffset();
						TimeVar nOffset = nextTask.getTaskOffset();
						
						tmp2 &= cOffset == null || cOffset.get() == null ? 
								( true ) : //assuming null offset== 0
								( nOffset == null || nOffset.get() == null ?
										((Double) cOffset.get()).doubleValue() == 0 : // ok only if current offset is 0
										 cOffset.compareTo(nOffset)	< 0 );
						
						
						
						
					} else if (checkHigherPriority(nextProc.getTaskPriority(), proc.getTaskPriority())) {
						// disabled because is much complex and much rare

						// This case requires that the response time of current proc is smaller than the
						// offset time of the following proc (or generically, task)

						tmp2 = false;

						
						
//						TimeVar cOffset = task.getTaskOffset();
//						TimeVar nOffset = nextTask.getTaskOffset();
//						
//						tmp2 &= task.getTaskOffset() 
//						
					} else {
						tmp2 = false;
					}

					if (!tmp2) {
						data.getReporter().error(proc, "Uncompatible priority and offsets among proc " + proc.getProcName() 
								+ " and proc " + nextProc.getProcName());
					}

					data.getReporter().warning(proc, "The flow among proc " + proc.getProcName() 
							+ " and proc " + nextProc.getProcName() 
							+ " may be not deterministic");

					answer &= tmp1 && tmp2;
					
				}
				
			}
			
			
			

		}

		return answer;
	}

	/**
	 * This function checks if two times are the same. In order to return true,
	 * it also requires that both are not null.
	 * 
	 * @param time1
	 *            the first time to check
	 * @param time2
	 *            the second time to check
	 * 
	 * @return true if both times are equals and not null.
	 * */
	public static boolean checkPeriods(TimeVar time1, TimeVar time2) {
		boolean answer = true;

		answer &= time1 != null && time2 != null;

		if (answer) {
			TimeVar temp = (TimeVar) time2.clone();
			temp.setType(time1.getType());

			answer &= time1.equals(temp);
		}

		return answer;
	}
	
	/**
	 * This function checks if the first time is a multiple of the second.
	 * returns -1 if time1 is not a multiple of time2, otherwise returns q : time1 * q = time2
	 * 
	 * 
	 * @param time1
	 *            the first time to check
	 * @param time2
	 *            the second time to check
	 * 
	 * @return true if both times are equals and not null.
	 * */
	public static long checkPeriodsRatio(TimeVar time1, TimeVar time2) {
		long answer = -1;
		
		// ensure that there is a not null value
		boolean tmp  = time1 != null && time1.get() != null; 
		tmp &= time2 != null && time2.get() != null;
		
		if (tmp) {
			double procValue = ((Double) time1.get()).doubleValue();

			time2 = (TimeVar) time2.clone();
			time2.setType(time1.getType());
			double taskValue = ((Double) time2.get()).doubleValue();
			
			double ratio = procValue / taskValue;
			long iratio  = Math.round(ratio);
			
			tmp = Math.abs( iratio - ratio) < ALLOWED_ERROR;
			if (tmp) {
				answer = iratio;
			}
		}

		return answer;
	}

	/**
	 * This function checks if the first priority is bigger than the second. We
	 * suggest to use this function in order to correctly handle the meaning of
	 * "higher" priority. For some systems, higher priority corresponds to
	 * bigger values, for other systems is the opposite.
	 * 
	 * @param prio_1
	 *            the first priority (the one that should be greater)
	 * @param prio_2
	 *            the second priority (the one that should be smaller)
	 * 
	 * @return true if prio_1 is greater than prio_2.
	 * */
	private boolean checkHigherPriority(int prio_1, int prio_2) {
		final boolean higher_bigvalues = false;
		return higher_bigvalues ? prio_1 > prio_2 : prio_1 < prio_2;
	}
}
