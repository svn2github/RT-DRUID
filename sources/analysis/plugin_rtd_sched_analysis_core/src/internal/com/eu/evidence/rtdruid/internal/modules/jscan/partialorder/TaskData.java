package com.eu.evidence.rtdruid.internal.modules.jscan.partialorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

public class TaskData {

	/** Name */
	protected String taskName;

	/** Period */
	protected TimeVar taskPeriod;
	
	/** Offset */
	protected TimeVar taskOffset;
	
	/** Priority */
	protected int taskPrio;

	/** Is periodic or sporadic */
	protected boolean periodic;
	
	/**
	 * Ordered list of procs
	 */
	protected ArrayList<ProcData> procs = new ArrayList<ProcData>();;

	// --------------------------------------
	
	public TaskData(String name) {
		taskName = name;
	}
	
	/**
	 * @return an unmodifiable list of mapped procs
	 */
	public List<ProcData> getProcs() {
		return Collections.unmodifiableList(procs);
	}
	
	public int getProcPosition(ProcData proc) {
		return procs.indexOf(proc);
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public TimeVar getTaskPeriod() {
		return taskPeriod == null ? null : (TimeVar) taskPeriod.clone();
	}

	public TimeVar getTaskOffset() {
		return taskOffset == null ? null : (TimeVar) taskOffset.clone();
	}
	
	public int getTaskPrio() {
		return taskPrio;
	}

	/**
	 * This method returns if this proc is periodic or not.
	 * return false also if period is not set.
	 * 
	 * @return true if this proc is periodic, false otherwise.
	 */
	public boolean isPeriodic() {
		return periodic && taskPeriod != null;
	}
	
	public void setTaskPeriod(TimeVar period) {
		taskPeriod = (TimeVar) period.clone();
	}
	
	public void setTaskOffset(TimeVar offset) {
		taskOffset = (TimeVar) offset.clone();
	}
	
	public void setTaskPrio(int taskPrio) {
		this.taskPrio = taskPrio;
	}
	
	public void setPeriodic(boolean periodic) {
		this.periodic = periodic;
	}

	// --------------------------------------
	
	/**
	 * This method adds a mapping from the given proc to this task, at the end
	 * of the list. Throws an AlreadyMappedProcException if the specified proc
	 * is already mapped to this task.
	 * 
	 * @param proc
	 *            the proc to be added
	 * 
	 * @throws AlreadyMappedProcException
	 *             if the specified proc is already mapped to this task.
	 */
	public void addMapping(ProcData proc) throws AlreadyMappedProcException {
		if (procs.contains(proc)) {
			throw new AlreadyMappedProcException(proc.getProcName());
		}

		procs.add(proc);
		proc.setTask(this);
	}
	

	/**
	 * This method adds a mapping from the given proc to this task, just after
	 * the second proc. Throws WrongMappingException if the second proc is not
	 * mapped here. Throws an AlreadyMappedProcException if the specified proc
	 * is already mapped to this task.
	 * 
	 * @param proc
	 *            the proc to be added
	 * 
	 * @param afterThis
	 *            the proc that precede the new one
	 * 
	 * @throws AlreadyMappedProcException
	 *             if the second proc is not mapped here
	 * @throws WrongMappingException
	 *             if the second proc is not mapped here
	 */
	public void addMappingAfter(ProcData proc, ProcData afterThis)
			throws AlreadyMappedProcException, WrongMappingException {

		if (procs.contains(proc)) {
			throw new AlreadyMappedProcException(proc.getProcName());
		}

		int index = procs.indexOf(afterThis);
		if (index < 0) {
			throw new WrongMappingException(afterThis.getProcName());
		}

		procs.add(index + 1, proc);
		proc.setTask(this);

	}

	/**
	 * This method adds a mapping from the given proc to this task, at the end
	 * of the list. Throws WrongMappingException if the second proc is not
	 * mapped here. Throws an AlreadyMappedProcException if the specified proc
	 * is already mapped to this task.
	 * 
	 * @param proc
	 *            the proc to be added
	 * 
	 * @param afterThis
	 *            the proc that follow the new one
	 * 
	 * @throws AlreadyMappedProcException
	 *             if the second proc is not mapped here
	 * @throws WrongMappingException
	 *             if the second proc is not mapped here
	 */
	public void addMappingBefore(ProcData proc, ProcData beforeThis)
			throws AlreadyMappedProcException, WrongMappingException {

		if (procs.contains(proc)) {
			throw new AlreadyMappedProcException(proc.getProcName());
		}

		int index = procs.indexOf(beforeThis);
		if (index < 0) {
			throw new WrongMappingException(beforeThis.getProcName());
		}

		procs.add(index, proc);
		proc.setTask(this);
	}

	/**
	 * This method adds a mapping from the given proc to this task, at the end
	 * of the list. Throws WrongMappingException if the index is smaller than
	 * zero or bigger then the current mapping list size. Throws an
	 * AlreadyMappedProcException if the specified proc is already mapped to
	 * this task.
	 * 
	 * @param proc
	 *            the proc to be added
	 * 
	 * @param atIndex
	 *            the position where add the new proc
	 * 
	 * @throws AlreadyMappedProcException
	 *             if the second proc is not mapped here
	 * @throws WrongMappingException
	 *             if the index is smaller than zero or bigger then the current
	 *             mapping list size
	 */
	public void addMapping(ProcData proc, int atIndex)
			throws AlreadyMappedProcException, WrongMappingException {

		if (procs.contains(proc)) {
			throw new AlreadyMappedProcException(proc.getProcName());
		}

		if (atIndex < 0 || atIndex > procs.size()) {
			throw new WrongMappingException("Specified index " + atIndex
					+ " is not in range [0, " + procs.size() + "]");
		}

		procs.add(atIndex, proc);
		proc.setTask(this);
	}

	/**
	 * This method remove a mapping from the given proc to this task.
	 * 
	 * @param proc
	 */
	public void removeMapping(ProcData proc) {
		int index = procs.indexOf(proc);
		if (index > -1) {
			procs.remove(index);
			proc.setTask(null);
		}

	}
	
	private class CompareProcOrder implements Comparator<ProcData> {
		
		public int compare(ProcData o1, ProcData o2) {
			if (o1 == null) {
				return o2 == null ? 0 : Integer.MIN_VALUE;
			} else if (o2 == null) {
				return Integer.MAX_VALUE;
			}
			
			// both not null
			Integer i1 = o1.getOrder();
			Integer i2 = o2.getOrder();
			if (i1 == null) {
				return i2 == null ? 0 : Integer.MIN_VALUE;
			} else if (i2 == null) {
				return Integer.MAX_VALUE;
			}

			return i1.intValue() - i2.intValue();
		}
	}

	public void sortProcs() {
		Collections.sort(procs, new CompareProcOrder());
	}
	// ------------------------------
	
	
	public String toString() {
		StringBuffer answer = new StringBuffer("Task{ " + taskName 
			+ ": period= " + taskPeriod 
			+ "; offset= " + taskOffset
			+ "; priority= " + taskPrio 
			+ "; procs=[");

		if (procs != null) {
			String space = "";
			for (ProcData proc : procs) {
				answer.append(space + proc.getProcName());
				space = ", ";
			}
		}
		answer.append("]}");

		return answer.toString();
	}
}

