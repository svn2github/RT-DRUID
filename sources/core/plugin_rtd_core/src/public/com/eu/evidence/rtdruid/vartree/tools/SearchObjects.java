/*
 * Created on 20/set/07
 *
 * $Id: SearchObjects.java,v 1.4 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.tools;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IMultiValues;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.tools.Search.ArchElement;

public class SearchObjects {

	
	private final static char S = IVarTree.SEPARATOR;

	private final static DataPackage DPKG = DataPackage.eINSTANCE;

	
	private static final String OS_MODEL_METHODS = DPKG.getRtos_Methods().getName();
	private static final String RTOS_NAME = DPKG.getRtos_Name().getName();
	

	
	
	/**
	 * This comparator orders a list of <b>IData</b> object by a list of rules:
	 * 
	 * 1) first of all, order by cpuID. If cpuID is null, the related object is
	 * moved to the end of the list.
	 * 
	 * 2) each grup with the same cpu, is order by TaskName. For ITaskData, is
	 * the name and for IProcData is the related Task. Also here, null names are
	 * at the end of the group.
	 * 
	 * 3) each grup with the same cpu and task, is order in this way: first the
	 * TaskData then every ProcData order by ProcName.
	 * 
	 * Note : If you want to search, use DataComparatorSearch
	 */
	public static class DataComparatorSort implements Comparator<Object> {

		public int compare(Object arg0, Object arg1) {

			IData a = (IData) arg0;
			IData b = (IData) arg1;
			// compare cpus
			int answer = compareNull(a.getCpuID(), b.getCpuID());

			if (answer == 0) { // same cpu

				if (a instanceof IProcData && b instanceof IProcData) {
					answer = compareNull(((IProcData) a).getTask(),
							((IProcData) b).getTask());

					// if they are related to the same task, compare the proc
					// name
					if (answer == 0) {
						answer = compareNull(((IProcData) a).getName(),
								((IProcData) b).getName());
					}

				} else if (a instanceof IProcData && b instanceof ITaskData) {
					answer = compareNull(((IProcData) a).getTask(),
							((ITaskData) b).getName());

					if (answer == 0) { // if they have the same "task id",
						// first the Task
						answer = Integer.MAX_VALUE;
					}

				} else if (a instanceof ITaskData && b instanceof IProcData) {
					answer = compareNull(((ITaskData) a).getName(),
							((IProcData) b).getTask());

					if (answer == 0) { // if they have the same "task id",
						// first the Task
						answer = Integer.MIN_VALUE;
					}

				} else { // if (a instanceof ITaskData && b instanceof
					// ITaskData) {
					answer = compareNull(((ITaskData) a).getName(),
							((ITaskData) b).getName());
				}

			}

			return answer;
		}

		/**
		 * @return the value <code>0</code> if the <b>a</b> string is equal
		 *         to <b>b</b> string; a value less than <code>0</code> if
		 *         <b>a</b> string is lexicographically less than the <b>b</b>
		 *         string ; and a value greater than <code>0</code> if <b>a</b>
		 *         string is lexicographically greater than the <b>b</b>
		 *         string.
		 */
		private int compareNull(String a, String b) {
			if (a == null) {
				return b == null ? 0 : Integer.MIN_VALUE;
			} else if (b == null) {
				return Integer.MAX_VALUE;
			}
			// else
			return a.compareTo(b);
		}
	};

	/**
	 * This comparator orders a list of <b>IData</b> object by a list of rules:
	 * 
	 * 1) first of all, order by cpuID. If cpuID is null, the related object is
	 * moved to the end of the list.
	 * 
	 * 2) each grup with the same cpu, is order by Task_name and Proc_fullName.
	 * Also here, null names are at the end of the group.
	 * 
	 * This comparator is useful to search a runnable using String[3] {cpuId,
	 * taskName/Proc_fullName, "TASK"/"PROC"/null}. The last element is used to
	 * specify if is required a TaskData or a ProcData, or any if null.
	 */
	public static class DataComparatorSearch implements Comparator<Object> {

		public final static String PROC_ID = "PROC";
		public final static String TASK_ID = "TASK";
		
		public int compare(Object arg0, Object arg1) {

			// Check if one of two elements is a string[2]
			if (arg0 instanceof String[]) {
				return compareVD((String[]) arg0, (IData) arg1);

			} else if (arg1 instanceof String[]) {
				return compareDV((IData) arg0, (String[]) arg1);
			}

			IData a = (IData) arg0;
			IData b = (IData) arg1;
			// compare cpus
			int answer = compareNull(a.getCpuID(), b.getCpuID());

			if (answer == 0) { // same cpu

				if (a instanceof IProcData && b instanceof IProcData) {
					answer = compareNull(((IProcData) a).getFullName(),
							((IProcData) b).getFullName());

				} else if (a instanceof IProcData && b instanceof ITaskData) {
					answer = compareNull(((IProcData) a).getFullName(),
							((ITaskData) b).getName());

					if (answer == 0) { // if they have the same "id",
						// first the Task
						answer = Integer.MAX_VALUE;
					}

				} else if (a instanceof ITaskData && b instanceof IProcData) {
					answer = compareNull(((ITaskData) a).getName(),
							((IProcData) b).getFullName());

					if (answer == 0) { // if they have the same "task id",
						// first the Task
						answer = Integer.MIN_VALUE;
					}

				} else { // if (a instanceof ITaskData && b instanceof
					// ITaskData) {
					answer = compareNull(((ITaskData) a).getName(),
							((ITaskData) b).getName());
				}

			}

			return answer;
		}

		public int compareVD(String[] a, IData b) {

			// compare cpus
			int answer = compareNull(a[0], b.getCpuID());

			if (answer == 0) { // same cpu

				if (b instanceof IProcData) {
					answer = compareNull(a[1], ((IProcData) b).getFullName());

					if (answer == 0 && TASK_ID.equalsIgnoreCase(a[2])) { // if they have the same "id",
						// but is required a task
						answer = Integer.MAX_VALUE;
					}

				} else { // if (a instanceof ITaskData && b instanceof
					// ITaskData) {
					answer = compare(a[1], b.getName());

					if (answer == 0 && PROC_ID.equalsIgnoreCase(a[2])) { // if they have the same "id",
						// but is required a task
						answer = Integer.MIN_VALUE;
					}
				}
			}
			return answer;
		}

		public int compareDV(IData a, String[] b) {

			// compare cpus
			int answer = compareNull(a.getCpuID(), b[0]);

			if (answer == 0) { // same cpu

				if (a instanceof IProcData) {
					answer = compareNull(((IProcData) a).getFullName(), b[1]);

					if (answer == 0 && TASK_ID.equalsIgnoreCase(b[2])) { // if they have the same "id",
						// but is required a task
						answer = Integer.MIN_VALUE;
					}
				} else { // if (a instanceof ITaskData && b instanceof
					// ITaskData) {
					answer = compareNull(a.getName(), b[1]);

					if (answer == 0 && PROC_ID.equalsIgnoreCase(b[2])) { // if they have the same "id",
						// but is required a task
						answer = Integer.MAX_VALUE;
					}
				}
			}
			return answer;
		}

		/**
		 * @return the value <code>0</code> if the <b>a</b> string is equal
		 *         to <b>b</b> string; a value less than <code>0</code> if
		 *         <b>a</b> string is lexicographically less than the <b>b</b>
		 *         string ; and a value greater than <code>0</code> if <b>a</b>
		 *         string is lexicographically greater than the <b>b</b>
		 *         string.
		 */
		private int compareNull(String a, String b) {
			if (a == null) {
				return b == null ? 0 : Integer.MIN_VALUE;
			} else if (b == null) {
				return Integer.MAX_VALUE;
			}
			// else
			return a.compareTo(b);
		}
	};

	

	private static class OsMethodData implements IOsMethodData {

		protected final String name;

		protected final String fullName;

		protected final String vtpath;

		protected String cpu = null;

		public OsMethodData(String name, String fullName, String vpath) {
			this.name = name;
			this.vtpath = vpath;
			this.fullName = fullName;

		}

		public void setCpuID(String cpu) {
			this.cpu = cpu;
		}
		public String getCpuID() {
			return cpu;
		}

		public String getName() {
			return name;
		}

		public String getFullName() {
			return fullName;
		}

		public String getVtPath() {
			return vtpath;
		}

		public String toString() {
			return "{OsMethod Name = " + name + ";\n\t Full Name = " + fullName
					+ ";\n\t vt Path = " + vtpath 
					+ ";\n\t Cpu  = " + cpu + "}";
		}
		
		public Object clone() {
			ProcData answer = new ProcData(name, fullName, vtpath);
			answer.cpu = this.cpu;
			return answer;
		}

	}

	
	private static class ProcData implements IProcData {

		protected final String name;

		protected final String fullName;

		protected final String vtpath;

		protected String cpu = null;

		protected String task = null;

		public ProcData(String name, String fullName, String vpath) {
			this.name = name;
			this.vtpath = vpath;
			this.fullName = fullName;

		}

		public void setCpuID(String cpu) {
			this.cpu = cpu;
		}

		public void setTask(String task) {
			this.task = task;
		}

		public String getCpuID() {
			return cpu;
		}

		public String getTask() {
			return task;
		}

		public String getName() {
			return name;
		}

		public String getFullName() {
			return fullName;
		}

		public String getVtPath() {
			return vtpath;
		}

		public String toString() {
			return "{Proc Name = " + name + ";\n\t Full Name = " + fullName
					+ ";\n\t vt Path = " + vtpath + ";\n\t Task = " + task
					+ ";\n\t Cpu  = " + cpu + "}";
		}
		
		public Object clone() {
			ProcData answer = new ProcData(name, fullName, vtpath);
			answer.cpu = this.cpu;
			answer.task = this.task;
			return answer;
		}

	}

	private static class TaskData implements ITaskData {

		protected final String name;

		protected final String vtpath;

		protected String cpu = null;

		public TaskData(String name, String vpath) {
			this.name = name;
			this.vtpath = vpath;
		}

		public void setCpuID(String cpu) {
			this.cpu = cpu;
		}

		public String getCpuID() {
			return cpu;
		}

		public String getName() {
			return name;
		}

		public String getVtPath() {
			return vtpath;
		}

		public String toString() {
			return "{Task Name = " + name + ";\n\t vt Path = " + vtpath
					+ ";\n\t Cpu  = " + cpu + "}";
		}
		
		public Object clone() {
			TaskData answer = new TaskData(name, vtpath);
			answer.cpu = this.cpu;
			return answer;
		}

	}

	final IVarTree vt;

	public SearchObjects(IVarTree vt) {
		this.vt = vt;
	}

	public IOsMethodData[] getAllOsMethods() {

		// search the System Name
		IVarTreePointer vtp = vt.newVarTreePointer();
		ITreeInterface ti = vt.newTreeInterface();
		boolean ok = vtp.goFirstChild();
		if (!ok) {
			return new IOsMethodData[0];
		}

		// search every proc and fill each IProcData object
		String[] rtos = Search.allRtos(ti);
		ArrayList<IOsMethodData> data = new ArrayList<IOsMethodData>();

		for (int i = 0; i < rtos.length; i++) {
			final String vtPath = rtos[i];

//			String[] segments = DataPath.splitPath(vtPath);

			// to make a subsystem/.../object path, I need to remove System &
			// Functional nodes
			// and then use vt-2-evidence_path
			final String rtosName = getRtOsName(vt, vtPath);

			
			Set<String> found_methods = new LinkedHashSet<String>();
			
			found_methods.add(Search.OS_ACTIVATE_TASK);
			found_methods.add(Search.OS_TERMINATE_TASK);
			found_methods.add(Search.OS_CONTEXT_SWITCH);
			found_methods.add(Search.OS_CONTEXT_SWITCH_cachePenalty);
			
			IVariable var = ti.getValue(vtPath + S + OS_MODEL_METHODS);
			if (var != null) {
				if (var instanceof IMultiValues) {
					IMultiValues mvar = (IMultiValues) var;
					
					String[] vals = mvar == null || mvar.sizeValues() == 0 ? new String[0] : mvar.getValues();
					for (String s:vals) {
						found_methods.add(s);
					}
				} else {
					Object o = var.get();
					if (o != null)
						found_methods.add(var.toString());
				}
			}
			
			for (String method : found_methods) {
				data.add(new OsMethodData(method, SearchObjects.osMethodFullName((String) null, rtosName, method), vtPath));	
			}
			
		}

		return (IOsMethodData[]) data.toArray(new IOsMethodData[data.size()]);
	}

	
	public IProcData[] getAllProcs() {

		// search the System Name
		IVarTreePointer vtp = vt.newVarTreePointer();
		boolean ok = vtp.goFirstChild();
		if (!ok) {
			return new IProcData[0];
		}
		// prepare the mapping utility class
		Mapping map = new Mapping(vt, vtp.getName());

		// search every proc and fill each IProcData object
		String[] procs = Search.allProcs(vt);
		IProcData[] data = new ProcData[procs.length];
		for (int i = 0; i < procs.length; i++) {

			String[] segments = DataPath.splitPath(procs[i]);

			// to make a subsystem/.../object path, I need to remove System &
			// Functional nodes
			// and then use vt-2-evidence_path
			String full_name = Utility.makeFunctionalPath(procs[i]);

			String procName = DataPath.removeSlash(DataPath
					.removeSlash(segments[segments.length - 1]));

			data[i] = new ProcData(procName, full_name, procs[i]);

			String taskMap = null;
			try {
				taskMap = map.procToTask(full_name);
			} catch (IncompleteMappingException e) {
				// just don't set taskMap value
			}

			if (taskMap != null) {
				data[i].setTask(DataPath.removeSlash(taskMap));
				data[i].setCpuID(DataPath.removeSlash(map.taskToRTOS(taskMap)));

			}
		}

		return data;
	}

	public ITaskData[] getAllTasks() {

		// search the System Name
		IVarTreePointer vtp = vt.newVarTreePointer();
		boolean ok = vtp.goFirstChild();
		if (!ok) {
			return new ITaskData[0];
		}
		// prepare the mapping utility class
		Mapping map = new Mapping(vt, vtp.getName());

		// search every proc and fill each IProcData object
		ArchElement[] tasks = Search.allTasksNames(vt.newTreeInterface());
		TaskData[] data = new TaskData[tasks.length];
		for (int i = 0; i < tasks.length; i++) {

			//String[] segments = DataPath.splitPath(tasks[i]);

			String name = tasks[i].name; 
				//DataPath.removeSlash(DataPath
				//	.removeSlash(segments[segments.length - 1]));

			data[i] = new TaskData(name, tasks[i].vtPath);

			data[i].setCpuID(map.taskToRTOS(name));
		}

		return data;
	}


	protected static String getRtOsName(IVarTree vt, String rtosPath) {
		IVariable v = vt.newTreeInterface().getValue(rtosPath+S+RTOS_NAME);
		return v == null || v.get() == null ? null : v.toString();
	}

	public static String osMethodFullName(String cpu, String os, String method) {
		return DataPath.makePath(new String[] {/*cpu,*/ os, method});
	}
	
	public static String osMethodFullName(IVarTree vt, String rtosPath, String method) {

		String rtosName = getRtOsName(vt, rtosPath);
		
		String[] segments = DataPath.splitPath(rtosPath);
		// segment[0] = System Name
		// segment[1] = architectural
		// segment[2] = cpu list
		// segment[3] = cpu name
		// segment[4] = rtos
		
		String cpuName = segments != null && segments.length >4 ? segments[3] : null;
		
		return osMethodFullName(cpuName, rtosName, method);
	}

}
