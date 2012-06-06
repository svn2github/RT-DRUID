package com.eu.evidence.rtdruid.internal.modules.jscan.procdeadlines;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Stack;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.jscan.Schedulability;
import com.eu.evidence.rtdruid.internal.modules.jscan.common.RMSchedulability;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Cpu;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenRes;
import com.eu.evidence.rtdruid.vartree.abstractions.old.IGeneralMultiframeTaskWcet;
import com.eu.evidence.rtdruid.vartree.abstractions.old.IProcBasedTaskWcet;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Task;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Task.ProcData;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.tools.Search;
import com.eu.evidence.rtdruid.vartree.tools.Utility;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

// project package

// standard java package

// exceptions

/**
 * Compute "proc" schedulability of a system where proc runs once every k
 * activations of the task <br>
 *<br>
 *For each task is required:
 *<ul>
 * <li>Period</li>
 * <li>DeadLine</li>
 * <li>dline-utilization</li>
 * <li>generic_wcet<br>
 * - Proc_list (for each task)</br> - Proc's wcet</br> - Proc frequency (once
 * every k activations of the task)</li>
 * 
 * <li>wcet (calculated)</li>
 * <li>schedulable (calculated)</li>
 * <li>priority (calculated)</li>
 * <li>preemption level (calculated)</li>
 * <li>Utilization (calculated)</li>
 * <li>Blocking (calculated)</li>
 * <li>List of reources with wcet for each resource</li>
 *</ul>
 *For each resource is required:
 *<ul>
 * <li>ceiling (calculated)</li>
 *</ul>
 * 
 * @author Giuseppe Lipari && Nicola Serreli
 */

public class ProcDeadlineAnalysis extends Schedulability {

	public static final String AVERAGE_UTILIZATION = "average_utilization";
	public static final String PROC_RESPONSE_TIME = "proc_response_time";
	public static final String PROC_SCHEDULABILITY = "proc_schedulability";
	public static final String STR_PROC_CDELTA = "proc_cdeltas";

	/**
	 * A Proc property that contains the chain of refered procs (ArrayList of
	 * ProcData)
	 */
	public static final String PROC_REFERED_PROCS = "proc__refered_procs";
	/** Mapped task (String) */
	public static final String PROC_MAPPED_TASK_NAME = "proc__mapped_task_name";
	/** Parent (GenRes, Task) */
	public static final String PROC_PARENT_TASK = "proc__parent_task";

	public static final int OVERFLOW_LIMIT = 10;

	/**
	 * Data are ready only at the end of the task. This means that the full task
	 * response time is added to the chain, not only the response of procs involves
	 * in the chain.
	 */
	protected boolean data_ready_at_the_end_of_a_task = true;

	
	
	protected ArrayList<DeadlineData>[] allDeadlines = new ArrayList[0];

	/**
  */
	public ProcDeadlineAnalysis() {
	}

	protected void addSteps() {
		for (int i = 1; i < tasks.getPrefixNumber(); i++) {
			progress.addSteps(tasks.getSize(i));
		}
	}

	// -------------------- SCHEDULABLE

	protected void checkCpuTaskSet(int cpuId) {
		if (tasks == null) {
			throw new IllegalStateException(
					"Set a taskList before do something!");
		}
		if (tasks.getPrefixNumber() <= cpuId) {
			throw new IndexOutOfBoundsException(
					"Required a non-existent cpuId : max id ="
							+ tasks.getPrefixNumber() + " , required id = "
							+ cpuId);
		}
	}

	protected void checkResources() {
		if (risorse == null) {
			throw new IllegalStateException(
					"Set a resourceList before do something!");
		}
		if (risorse.getPrefixNumber() == 0) {
			throw new IllegalStateException(
					"Set a not empty resourceList before do something!");
		}
	}

	/***/
	public boolean isSchedulable(int cpuId) {
		checkCpuTaskSet(cpuId);
		if (tasks.getSize(cpuId) == 0) {
			return true;
		}

		boolean flag = true;
		for (int i = 0; i < tasks.getSize(cpuId); i++) {
			flag &= (tasks.getItem(cpuId, i).getDouble(Task.STR_RESPONSE_TIME) <= tasks
					.getItem(cpuId, i).getDouble("deadline"));
		}
		return flag;
	}

	/***/
	protected boolean isSchedulable(int i, int cpuId) {
		boolean ok = false;
		if (tasks.getItem(cpuId, i).getDouble(Task.STR_RESPONSE_TIME) > tasks
				.getItem(cpuId, i).getDouble("deadline"))
			ok = false;
		else
			ok = true;

		if (ok)
			tasks.getItem(cpuId, i).setProperty("schedulable", "true");
		else
			tasks.getItem(cpuId, i).setProperty("schedulable", "false");

		return ok;
	}

	// -------------------- COMPUTE && REPORT

	public boolean isAccumulativelyMonotonic(double[] values) {

		if (values == null || values.length == 0) {
			return true;
		}

		// searching the max
		int maxId = 0;
		for (int i = 1; i < values.length; i++) {
			if (values[i] > values[maxId]) {
				maxId = i;
			}
		}

		for (int start = 0; start < values.length; start++) {
			double sumA = 0;
			double sumB = 0;
			for (int index = 0; index < values.length; index++) {
				sumA += values[(maxId + index) % values.length];
				sumB += values[(start + index) % values.length];

				if (sumA < sumB) {
					return false;
				}
			}
		}

		return true;
	}

	/***/
	public void compute(int cpuId) {
		checkCpuTaskSet(cpuId);
		if (tasks.getSize(cpuId) == 0) {
			return;
		}

		checkResources();

		// tasks.computeRMPriorities(cpuId); // tasks are sorted by period
		tasks.sortByPriority();
		computeCeilings(cpuId);
		computeBlockingTimes(cpuId);

		// calculate computazion
		peakUtilizations(cpuId);
		averageUtilizations(cpuId);
		responseTime(cpuId);

		HashMap<String, ProcData> foundProcs = getProcs(cpuId);

		loadProcRelations(cpuId, foundProcs);
		ArrayList<DeadlineData> deadlines = getProcDeadlines(cpuId, foundProcs);
		checkProcDeadlines(cpuId, deadlines);
		addDl(deadlines, cpuId);
		
		boolean isCpuSched = isSchedulable(cpuId);
		addCpuSched(tasks.getSystem(), DataPath.removeSlash(tasks
				.getPrefix(cpuId)), tasks.getMode(), new Double(getUtilization(
				tasks.getSize(cpuId), cpuId)), null, new Double(
				RMSchedulability.getRMBound(tasks.getSize(cpuId))), isCpuSched);

		progress.worked(tasks.getSize(cpuId));
	}

	protected HashMap<String, ProcData> getProcs(int cpuId) {

		HashMap<String, ProcData> foundProcs = new HashMap<String, ProcData>();

		// get all procs
		for (int i = 0; i < tasks.getSize(cpuId); ++i) {
			GenRes t = tasks.getItem(cpuId, i);
			ArrayList<ProcData> procs = (ArrayList<ProcData>) t
					.getProperty(Task.STR_PROC_LIST);

			// add mapping
			for (ProcData proc : procs) {
				foundProcs.put(proc.getName(), proc);

				proc.setProperty(PROC_MAPPED_TASK_NAME, t.getName());
				proc.setProperty(PROC_PARENT_TASK, t);
			}
		}

		return foundProcs;
	}

	private double getCumulativeWcet(GenRes task, String procName,
			int numInstances) {
		double answer = -1;
		if (task.existProperty(Task.STR_GENERIC_WCET)) {
			IGeneralMultiframeTaskWcet genWcet = (IGeneralMultiframeTaskWcet) task
					.getProperty(Task.STR_GENERIC_WCET);

			if (!genWcet.isEmpty()) {
				if (procName == null
						|| !(genWcet instanceof IProcBasedTaskWcet)) {
					answer = genWcet.getCumulativeWcet(numInstances);
				} else {
					// Reset wcet
					answer = 0;
					if (numInstances > 1) {
						answer += genWcet.getCumulativeWcet(numInstances - 1);
					}
					answer += ((IProcBasedTaskWcet) genWcet)
							.getWcetToCompleteProc(procName, numInstances);

				}
			}
		}

		if (answer < 0) {
			answer = task.getDouble(Task.STR_WCET) * numInstances;
		}

		return answer;
	}

	private void peakUtilizations(int cpuId) {
		
		GenRes cpu = tasks.getCpuItem(cpuId);
		final double context_switch = cpu != null && cpu.existProperty(Cpu.SCHED_CONTEXT_SWITCH_COST) 
				? 2 * cpu.getDouble(Cpu.SCHED_CONTEXT_SWITCH_COST) : 0;
		final double task_activation = cpu != null && cpu.existProperty(Cpu.SCHED_ACTIVATION_COST) 
				? cpu.getDouble(Cpu.SCHED_ACTIVATION_COST) : 0;
		final double task_termination = cpu != null && cpu.existProperty(Cpu.SCHED_TERMINATION_COST) 
				? cpu.getDouble(Cpu.SCHED_TERMINATION_COST) : 0;
		
		for (int i = 0; i < tasks.getSize(cpuId); ++i) {
			GenRes t = tasks.getItem(cpuId, i);
			double u = (t.getDouble(Task.STR_WCET) + context_switch + task_activation + task_termination)
					/ t.getDouble(Task.STR_PERIOD);
			t.setProperty("utilization", u);
			// double ud = t.getDouble(Task.STR_WCET) / t.getDouble("deadline");
			// t.setProperty("dline-utilization", ud);

		}
	}

	private void averageUtilizations(int cpuId) {
		GenRes cpu = tasks.getCpuItem(cpuId);
		final double context_switch = cpu != null && cpu.existProperty(Cpu.SCHED_CONTEXT_SWITCH_COST) 
				? 2 * cpu.getDouble(Cpu.SCHED_CONTEXT_SWITCH_COST) : 0;
		final double task_activation = cpu != null && cpu.existProperty(Cpu.SCHED_ACTIVATION_COST) 
				? cpu.getDouble(Cpu.SCHED_ACTIVATION_COST) : 0;
		final double task_termination = cpu != null && cpu.existProperty(Cpu.SCHED_TERMINATION_COST) 
				? cpu.getDouble(Cpu.SCHED_TERMINATION_COST) : 0;	
		
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

			double u = (twcet + context_switch + task_activation + task_termination) 
					/ t.getDouble(Task.STR_PERIOD);
			t.setTempProperty(AVERAGE_UTILIZATION, u);
		}
	}

	private void responseTime(int cpuId) {

		boolean overflow = false;
		// tasks.computeDMPriorities(); // tasks are sorted by priority
		tasks.sortByPriority();
		computeCeilings(cpuId);
		computeBlockingTimes(cpuId);

		for (int i = 0; i < tasks.getSize(cpuId); ++i) {
			GenRes t = tasks.getItem(cpuId, i);

			double taskDeadline = tasks.getItem(cpuId, i).getDouble("deadline");
			double task_max_rt = 0;

			ArrayList<ProcData> procs = (ArrayList<ProcData>) t
					.getProperty(Task.STR_PROC_LIST);
			Properties procResponse = new Properties();
			Properties procSchedulable = new Properties();
			for (ProcData proc : procs) {

				String procName = proc.getName();

				double max_rt = overflow ? Double.POSITIVE_INFINITY : procResponseTime(cpuId, i, proc);
				overflow =  max_rt == Double.POSITIVE_INFINITY;

				proc.setProperty(PROC_RESPONSE_TIME, new Double(max_rt));

				procResponse.setProperty(procName, ""
						+ max_rt);
				procSchedulable
						.setProperty(
								procName,
								""+ (max_rt <= taskDeadline));

				task_max_rt = max_rt;
			}

			// using last proc response time
			t.setProperty(Task.STR_RESPONSE_TIME, StrictMath
					.rint(task_max_rt * 1E7) / 1E7);
			t.setTempProperty(PROC_RESPONSE_TIME, procResponse);
			t.setTempProperty(PROC_SCHEDULABILITY, procSchedulable);
			isSchedulable(i, cpuId);

			progress.worked(1);
		}

	}

	private double procResponseTime(int cpuId, int taskId, ProcData proc) {

		String procName = proc.getName();
		GenRes t = tasks.getItem(cpuId, taskId);


		GenRes cpu = tasks.getCpuItem(cpuId);	  
		final double context_switch = cpu != null && cpu.existProperty(Cpu.SCHED_CONTEXT_SWITCH_COST) ?
				2*cpu.getDouble(Cpu.SCHED_CONTEXT_SWITCH_COST) : 0;
		final double task_activation = cpu != null && cpu.existProperty(Cpu.SCHED_ACTIVATION_COST) ?
				cpu.getDouble(Cpu.SCHED_ACTIVATION_COST) : 0;
		final double task_termination = cpu != null && cpu.existProperty(Cpu.SCHED_TERMINATION_COST) ?
				cpu.getDouble(Cpu.SCHED_TERMINATION_COST) : 0;
		
				
		boolean overflow = false;
		double rt;
		double off_rt = 0;
		double max_rt = 0;
		int ist_num = 1;
		double new_rt = getCumulativeWcet(t, procName, ist_num)
				+ t.getDouble("blocking")
				+ context_switch + task_activation + task_termination;

		// main cycle
		do {
			// compute the response time of instance ist_num;
			do {
				rt = new_rt;
				new_rt = getCumulativeWcet(t, procName, ist_num)
						+ t.getDouble("blocking")
						+ context_switch + task_activation + task_termination;
				for (int j = 0; j < taskId; ++j) {
					GenRes th = tasks.getItem(cpuId, j);
					int nt = (int) Math.ceil(rt
							/ th.getDouble(Task.STR_PERIOD));
					new_rt += getCumulativeWcet(th, null, nt)
							+ context_switch + task_activation + task_termination;
				}
				if ((new_rt - off_rt) > OVERFLOW_LIMIT
						* t.getDouble(Task.STR_PERIOD))
					overflow = true;
			} while (new_rt > rt && !overflow);

			// if it is too high
			if (overflow) {
				max_rt = Double.POSITIVE_INFINITY;
				break;
			} else {
				// store max response time
				max_rt = max_rt > (new_rt - off_rt) ? max_rt
						: (new_rt - off_rt);

				// look the next instance? yes if current instance
				// interferces with the next one
				if ((new_rt - off_rt) > t.getDouble(Task.STR_PERIOD)) {
					ist_num++;
					off_rt += t.getDouble(Task.STR_PERIOD);
				} else
					break;
			}
		} while (true);

		
		return StrictMath.rint(max_rt * 1E7) / 1E7;
	}
	
	
	private boolean areAllProcSchedulables(int cpuId) {
		boolean answer = true;
		for (int i = 0; i < tasks.getSize(cpuId) && answer; ++i) {
			GenRes t = tasks.getItem(cpuId, i);
			final double deadline = t.getDouble("deadline");
			ArrayList<ProcData> procs = (ArrayList<ProcData>) t
					.getProperty(Task.STR_PROC_LIST);

			for (ProcData proc : procs) {

				String procName = proc.getName();

				double max_rt = procResponseTime(cpuId, i, proc);

				answer = max_rt < deadline;
				if (!answer)
					break;
			}
		}

		return answer;
	}

	

	protected void computeSensitivity(int cpuId) {
		

		// tasks.computeDMPriorities(); // tasks are sorted by priority
		tasks.sortByPriority();
		computeCeilings(cpuId);
		computeBlockingTimes(cpuId);
		boolean overflow = false;

		for (int taskId = 0; taskId < tasks.getSize(cpuId); ++taskId) {
			GenRes t = tasks.getItem(cpuId, taskId);
			final double deadline = t.getDouble("deadline");
			
			IProcBasedTaskWcet procWcets = null;
			{
				IGeneralMultiframeTaskWcet genWcet = (IGeneralMultiframeTaskWcet) t
							.getProperty(Task.STR_GENERIC_WCET);
	
				if (genWcet instanceof IProcBasedTaskWcet) {
					procWcets = (IProcBasedTaskWcet) genWcet;
				} else {
					Messages.sendDebug("Cannot compute proc sensitivity if there is no informations about proc wcets");
					continue;
				}
			}
			
			String[] procNames = procWcets.getProcList();
			double[] cdeltas = new double[procNames.length];
			
			for (int i=0; i<procNames.length; i++) {
				String procName = procNames[i];
				
				double initialWcet = procWcets.getProcWcet(procName);
				
				// search initial values
				double min = 0;
				double max = Double.POSITIVE_INFINITY;
				
			
				if (new Boolean(""+ t.getProperty("schedulable"))) {
//					min = procWcets.getProcWcet(procName); // this is true if the system is schedulable
				} else {
					max = t.getDouble(Task.STR_RESPONSE_TIME);
				}
				
				if (max == Double.POSITIVE_INFINITY) {
					
					// check if 0 is schedulable
					procWcets.updateProcWcet(procName, min);
					
					if (!areAllProcSchedulables(cpuId)) {
						cdeltas[i] = Double.NEGATIVE_INFINITY;
						continue;
					}
				
					// search a finite max value
					
					double prev_value;
					max = min;
					do {
						prev_value = max;
						max = (prev_value + 1) * 100;
						procWcets.updateProcWcet(procName, max);
					} while (areAllProcSchedulables(cpuId));
					min = prev_value;
				}
				
				
				// searching the value
				do {
					double test = ( min + max) / 2;
					procWcets.updateProcWcet(procName, test);
					
//					double rtime = responseTime(cpuId, taskId);
//					double diff = deadline - rtime;
//					if (diff > 0 ) {
//						min = test;
//					} else {
//						max = test;
//					}

					if (areAllProcSchedulables(cpuId) ) {
						min = test;
					} else {
						max = test;
					}

				} while ((max - min) > 1E-7);

				cdeltas[i] = min - initialWcet;
				
				procWcets.updateProcWcet(procName, initialWcet);
			}

			ArrayList<Double> d = new ArrayList<Double>();
			for (double v : cdeltas){
				d.add(v);
			}
			t.setTempProperty(STR_PROC_CDELTA, d);

			progress.worked(1);
		}


	}

	
	
	protected void loadProcRelations(int cpuId,
			HashMap<String, ProcData> foundProcs) {

		IVarTree vt = tasks.getVarTree();
		ITreeInterface ti = vt.newTreeInterface();
		final char S = DataPath.SEPARATOR;
		final String sysName = Search.systemName(vt);
		final String PROC_METHODREF_LIST = DataPackage.eINSTANCE
				.getProc_MethodRefList().getName();

		// compute refered procs
		for (ProcData proc : foundProcs.values()) {
			ArrayList<ProcData> referedProcs = new ArrayList<ProcData>();

			String procPath = Search.aProc(ti, sysName, proc.getName());
			
			IVariable[] methods = ti.getAllValues(procPath + S
					+ PROC_METHODREF_LIST + S +"*" + S + DataPackage.eINSTANCE.getMethodRef_MethodName().getName(), null);
			
			for (IVariable method_ref_Var : methods) {

				if (method_ref_Var.get() == null) {
					continue;
				}

				String method_ref = method_ref_Var.toString();
				String methodOwnerPath = Search.aMethod(ti, sysName, method_ref);
				String referedProc = null;
				if (methodOwnerPath != null) {
					referedProc = Utility.makeFunctionalPath(methodOwnerPath);
				} else {
					Messages.sendWarningNl("Cannot find the method " + method_ref + ", required by " + proc.getName());
					continue;
				}

				boolean isAProc = referedProc != null && Search.aProc(ti, sysName, referedProc) != null;
				if (isAProc) {

					ProcData refProc = foundProcs.get(referedProc);
					if (refProc == null) {

						Messages
								.sendWarning(
										"Proc "
												+ proc.getName()
												+ " has a reference to proc "
												+ referedProc
												+ " that is not mapped to any task of the same cpu",
										null, "pda_000001", null);

						continue;
					}

					if (refProc != proc) {
						referedProcs.add(refProc);
					}
				}

				
			}

			proc.setProperty(PROC_REFERED_PROCS, referedProcs);

		}

	}

	protected ArrayList<DeadlineData> getProcDeadlines(int cpuId,
			HashMap<String, ProcData> foundProcs) {

		IVarTree vt = tasks.getVarTree();
		ITreeInterface ti = vt.newTreeInterface();
		final char S = DataPath.SEPARATOR;
		final String EVENT_METHODREF_NAME = DataPackage.eINSTANCE
				.getEvent_MethodRefName().getName();
		final String EVENT_TYPE = DataPackage.eINSTANCE.getEvent_Type()
				.getName();

		final String EVENT_TYPE_ACTIVATION = "activation";
		final String EVENT_TYPE_BEGIN = "begin";
		final String EVENT_TYPE_END = "end";

		ArrayList<DeadlineData> deadlines = new ArrayList<DeadlineData>();

		Search.TimeConstraintElement[] elements = Search.allTimeConstsData(ti,
				null, "deadline");
		String system = Search.systemName(vt);

		for (Search.TimeConstraintElement element : elements) {

			if (element.value != null && element.firstEvent != null
					&& element.secondEvent != null) {

				TimeVar value = null;
				try {
					value = new TimeVar(element.value);
				} catch (Exception e) {
					RtdruidLog.log(e);
					continue;
				}
				if (value.get() == null) {
					// no value set
					continue;
				}
				value.setType(Task.COMMON_TIME_TYPE);

				// search firt event
				String firstPath = Search.anEvent(ti, system,
						element.firstEvent);
				String secondPath = Search.anEvent(ti, system,
						element.secondEvent);

				// need two events
				if (firstPath == null || secondPath == null) {
					continue;
				}

				// / FIRST PROC

				String firstMethodRef = Search.getString(ti, firstPath + S
						+ EVENT_METHODREF_NAME);

				System.out.println(" ... first methodref : " + firstMethodRef);
				String firstType = Search.getString(ti, firstPath + S
						+ EVENT_TYPE);
				;

				if (!EVENT_TYPE_ACTIVATION.equalsIgnoreCase(firstType)) {
					continue; // next timeconst
				}

				// String freferedMethod_1 = Search.aMethodRef(ti, system,
				// firstMethodRef);
				// boolean triggered = Search.aTrigger(ti, system,
				// Utility.makeFunctionalPath(freferedMethod_1)) != null;

				String freferedMethod = Search.aMethodRefMethod(ti, system,
						firstMethodRef);
				// System.out.println(" ... first referenced method : " +
				// freferedMethod_1);
				// System.out.println(" ... \t\t : " + freferedMethod);

				String fpath = Search.aMethod(ti, system, freferedMethod);

				String firstProcName = fpath == null ? null : Utility
						.makeFunctionalPath(fpath);

				// / SECOND PROC

				String secondMethodRef = Search.getString(ti, secondPath + S
						+ EVENT_METHODREF_NAME);

				System.out
						.println(" ... second methodref : " + secondMethodRef);
				String secondType = Search.getString(ti, secondPath + S
						+ EVENT_TYPE);
				;

				if (!EVENT_TYPE_END.equalsIgnoreCase(secondType)) {
					continue; // next timeconst
				}

				String sreferedMethod = Search.aMethodRefMethod(ti, system,
						secondMethodRef);
				System.out.println(" ... second referenced method : "
						+ sreferedMethod);
				String spath = Search.aMethod(ti, system, sreferedMethod);
				String secondProcName = spath == null ? null : Utility
						.makeFunctionalPath(spath);

				// need two procs

				ProcData firstProc = foundProcs.get(firstProcName);
				ProcData secondProc = foundProcs.get(secondProcName);

				if (firstProc == null) {
					if (secondProc != null) {
						Messages
								.sendWarning(
										"Deadline constraint "
												+ element.firstEvent
												+ " - "
												+ element.secondEvent
												+ ": the first proc is missing or mapped to cpu different from the one related to the end event",
										null, "pda__00002", null);
					}
					continue;
				}

				if (secondProc == null) {
					if (firstProc != null) {
						Messages
								.sendWarning(
										"Deadline constraint "
												+ element.firstEvent
												+ " - "
												+ element.secondEvent
												+ ": the second proc is missing or mapped to cpu different from the one related to the starting event",
										null, "pda__00003", null);
					}
					continue;
				}

				deadlines.add(new DeadlineData(firstProc, secondProc,
						((Double) value.get()).doubleValue()));
			}

		}

		return deadlines;
	}

	protected void checkProcDeadlines(int cpuId, ArrayList<DeadlineData> deadlines) {
	  
	  for (DeadlineData dl : deadlines) {
		  
		  System.out.println("\n ... DL : " + dl.start + " -> " + dl.end);
		  
		  double chainResponse = computeResponse(dl.start, new Stack<ProcData>(), dl.end);
		  if (chainResponse == -1) {
			  Messages.sendWarningNl("Cannot find a path of methodRef that connect " + dl.start.getName() + " with " + dl.end.getName());
		  }
		  try {
			  dl.setChainResponse(chainResponse);
		  } catch (Exception e){
			  Messages.sendError(e.getMessage(), null, "pda__01000", null);
			  dl.setChainResponse(Double.POSITIVE_INFINITY);
		  }
	  }
  }

	protected double computeResponse(ProcData current, Stack<ProcData> path,
			ProcData end) {

		System.out.println("\n\tpath: " + path);

		
		if (path.contains(current)) {
			Messages.sendWarningNl("found a cycle of proc references");
			//throw new RuntimeException("found a cycle of proc references");
			return 0;
		}

		if (end == current) {
			return (Double) current.getProperty(PROC_RESPONSE_TIME);	
		}
		
		path.add(current);

		Task currentTask = (Task) current.getProperty(PROC_PARENT_TASK);
		double max_rt = -1;

		ArrayList<ProcData> refered = (ArrayList<ProcData>) current
				.getProperty(PROC_REFERED_PROCS);
		for (ProcData ref : refered) {

			Task refTask = (Task) ref.getProperty(PROC_PARENT_TASK);

			double refResp = computeResponse(ref, path, end);
			
			if (refResp == -1) {
				// that sub chain does not end with the required proc
				System.out.println("\n\t\t sub: " + ref + " -1");
				continue;
			}

			if (refTask != currentTask) {
				refResp += data_ready_at_the_end_of_a_task ?
						new Double("" + currentTask.getProperty(Task.STR_RESPONSE_TIME)) :
							(Double) current.getProperty(PROC_RESPONSE_TIME);
			}
			
			if (refResp > max_rt) {
				max_rt = refResp;
			}
			System.out.println("\n\t\t sub: " + ref + " " + refResp);
		}

		path.pop();
		return max_rt;
	}

	/***/
	public String getReport(int cpuId) {
		checkCpuTaskSet(cpuId);
		if (tasks.getSize(cpuId) == 0) {
			return "No task";// throw new
								// IllegalStateException("Set a not empty taskList before get utilization!");
		}

		String rep = new String("Proc schedulability of MultiFrame task\n");
		rep += "Blocking times have been computed according to the Priority Ceiling\n";
		rep += "Protocol.\n";

		int i;
		for (i = 0; i < tasks.getSize(cpuId); i++) {

			String procs = "";
			if (tasks.getItem(cpuId, i).existProperty(Task.STR_GENERIC_WCET)) {
				IGeneralMultiframeTaskWcet genWcet = (IGeneralMultiframeTaskWcet) tasks
						.getItem(cpuId, i).getProperty(Task.STR_GENERIC_WCET);
				procs = "\t Model               : " + genWcet + "\n";
				// procs += "\t Proc response time  : " +
				// tasks.getItem(cpuId,i).getTempProperty(PROC_RESPONSE_TIME) +
				// "\n";
				// procs += "\t Proc schedulability : " +
				// tasks.getItem(cpuId,i).getTempProperty(PROC_SCHEDULABILITY) +
				// "\n";
			}

			rep += "Task " + tasks.getItem(cpuId, i).getName() + ":\n";
			rep += "\t Peak Utilization   : "
					+ tasks.getItem(cpuId, i).getProperty("utilization") + "\n";
			rep += "\t Average Utilization: "
					+ tasks.getItem(cpuId, i).getTempProperty(
							AVERAGE_UTILIZATION) + "\n";
			rep += "\t Blocking factor    : "
					+ tasks.getItem(cpuId, i).getProperty("blocking") + "\n";
			rep += procs;
			if (isSchedulable(i, cpuId))
				rep += "SCHEDULABLE\n";
			else
				rep += "NOT SCHEDULABLE\n\n";
		}
		
		
		// deadlines
		rep += "\nChain deadlines:\n";
		
		ArrayList<DeadlineData> deadlines = allDeadlines.length > cpuId ? allDeadlines[cpuId] : new ArrayList<DeadlineData>();
		for (DeadlineData dl : deadlines) {
			rep += "  " + dl.getStart() + " -> " + dl.getEnd()
				+ "\n\tresp     = " + dl.getChainResponse()
				+ "\n\tdeadline = " + dl.getValue() + "\n";
		}
		
		
		rep += "\nIn dettaglio\n\n";
		for (i = 0; i < tasks.getSize(cpuId); i++) {
			rep += tasks.getItem(cpuId, i).toString() + "\n";
		}
		for (i = 0; i < risorse.getSize(0); i++) {
			rep += risorse.getItem(0, i).toString() + "\n";
		}

		rep += "--------------------------------------------------\n";
		return rep;
	}

	// -------------------- UTILITY

	/***/
	public double getUtilization(int liv, int cpuId) {
		return 0;
		// throw new UnsupportedOperationException();
	}

	/***/
	public void computeCeilings(int cpuId) {
		// tasks are assumed to be sorted by priority (therefore, they
		// should have a priority
		// computePreemptionLevels(cpuId);
		for (int j = 0; j < risorse.getSize(0); ++j) {
			GenRes r = risorse.getItem(0, j);
			int i = 0;
			boolean fine = false;
			while (i < tasks.getSize(cpuId) && !fine) {
				if (((Task) tasks.getItem(cpuId, i)).getResourceUsage(r
						.getName()) > 0)
					fine = true;
				else
					i++;
			}
			if (i == tasks.getSize(cpuId))
				// r.setTempProperty("ceiling",
				// tasks.getItem(cpuId,i-1).getInt("priority") + 1);
				r.setTempProperty("ceiling", 0);
			else
				r.setTempProperty("ceiling", tasks.getItem(cpuId, i).getInt(
						"priority"));
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
		for (int i = 0; i < tasks.getSize(cpuId); ++i) {
			double maxblock = 0;
			GenRes t = tasks.getItem(cpuId, i);
			for (int j = 0; j < risorse.getSize(0); ++j) {
				if (risorse.getItem(0, j).getTempInt("ceiling") >= t
						.getInt("priority")) {
					GenRes r = risorse.getItem(0, j);
					for (int k = i + 1; k < tasks.getSize(cpuId); ++k) {
						Task t2 = (Task) tasks.getItem(cpuId, k);
						maxblock = Math.max(maxblock, t2.getResourceUsage(r
								.getName())+ context_switch);
					}
				}
			}
			t.setProperty("blocking", maxblock);
		}
	}
	
	protected void addDl(ArrayList<DeadlineData> deadlines, int index) {		
		if (allDeadlines.length < index) {
			ArrayList<DeadlineData>[] tmp = new ArrayList[index+1];
			System.arraycopy(allDeadlines, 0, tmp, 0, allDeadlines.length);
			allDeadlines = tmp;
		}
		allDeadlines[index] = deadlines;
	}
}
