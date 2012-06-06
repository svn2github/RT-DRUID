package com.eu.evidence.rtdruid.internal.modules.jscan.partialorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

public class ProcData {

	private String procName;
	
	private String procPath;

	private TimeVar procPeriod;

	private boolean periodic;
	private String eventProvider;
	
	private TaskData task;
	
	private Integer order;
	private Integer onceEveryK;
	
	
	/**
	 * Contains the list of procs that follow this one.
	 */
	private List<ProcData> followProcs = new ArrayList<ProcData>();

	/**
	 * Contains the list of procs that precede this one.
	 */
	private List<ProcData> precedentProcs = new ArrayList<ProcData>();

	// ---------------------------------
	
	public ProcData(String name, String path) {
		procName = name;
		procPath = path;
	}

	/**
	 * @return an unmodifiable list of procs that follow this one
	 */
	public List<ProcData> getFollowingProcs() {
		return Collections.unmodifiableList(followProcs);
	}

	/**
	 * @return an unmodifiable list of procs that preced this one
	 */
	public List<ProcData> getPrecedingProcs() {
		return Collections.unmodifiableList(precedentProcs);
	}

	/**
	 * @return the name of this proc
	 */
	public String getProcName() {
		return procName;
	}

	public String getProcPath() {
		return procPath;
	}
	
	public Integer getOrder() {
		return order;
	}
	
	/**
	 * @return the period of this proc
	 */
	public TimeVar getProcPeriod() {
		return procPeriod == null ? null : (TimeVar) procPeriod.clone();
	}

	/**
	 * @return the task related to this proc
	 */
	public TaskData getTask() {
		return task;
	}

	/**
	 * @return the position inside the task
	 */
	public int getTaskPosition() {
		return task == null ? -1 : task.getProcPosition(this);
	}


	/**
	 * This method returns the priority of the associated task. If
	 * no task is set, returns -1.
	 * 
	 * @return the priority of related task
	 */
	public int getTaskPriority() {
		return task == null ? -1 : task.getTaskPrio();
	}

	
	/**
	 * This method returns if this proc is periodic or not.
	 * return false also if period is not set.
	 * 
	 * @return true if this proc is periodic, false otherwise.
	 */
	public boolean isPeriodic() {
		return periodic && procPeriod != null;
	}
	
	public String getEventProvider() {
		return eventProvider;
	}
	
	/**
	 * @return the onceEveryK
	 */
	public Integer getOnceEveryK() {
		return onceEveryK;
	}
	
	// -------------------------------------

	/**
	 * This method set a new relation between this proc and the specified task.
	 * If this proc was already mapped to a task, this method removes that
	 * relation.
	 * 
	 * @param task
	 *            the task where is mapped this proc
	 */
	void setTask(TaskData task) {
		if (this.task != null && this.task != task) {
			TaskData tmp = this.task;
			this.task = null;
			// without the precede line, this call can init an infinite loop
			tmp.removeMapping(this);
		}
		this.task = task;
	}

	public void setPeriod(TimeVar period) {
		procPeriod = period;
	}
	
	// ------------------------------
	
	public void addFollowing(ProcData proc) {
		if (proc != this) {
			if (!followProcs.contains(proc)) {
				followProcs.add(proc);
			}
		}
	}
	
	public void removeFollowing(ProcData proc) {
		if (proc != this) {
			followProcs.remove(proc);
		}
	}
	
	public void addPrecedent(ProcData proc) {
		if (proc != this) {
			if (!precedentProcs.contains(proc)) {
				precedentProcs.add(proc);
			}
		}
	}
	
	public void removePrecedent(ProcData proc) {
		if (proc != this) {
			precedentProcs.remove(proc);
		}
	}
	
	

	public void setOrder(Integer order) {
		this.order = order;
	}
	
	public void setPeriodic(boolean periodic) {
		this.periodic = periodic;
	}
	
	public void setEventProvider(String eventProvider) {
		this.eventProvider = eventProvider;
	}
	
	/**
	 * @param onceEveryK the onceEveryK to set
	 */
	public void setOnceEveryK(Integer onceEveryK) {
		this.onceEveryK = onceEveryK;
	}
	// ------------------------------
	
	@Override
	public String toString() {
		StringBuffer answer = new StringBuffer("Proc{ " + procName 
			+ ": period= " + procPeriod 
			+ "; mapped to= " + ( task == null ? " NOT MAPPED " : task.getTaskName()) 
			+ "; precedents= [");
		
		if (precedentProcs != null) {
			String space = "";
			for (ProcData proc : precedentProcs) {
				answer.append(space + proc.getProcName());
				space = ", ";
			}
		}
		answer.append("]; following= [");

		if (followProcs != null) {
			String space = "";
			for (ProcData proc : followProcs) {
				answer.append(space + proc.getProcName());
				space = ", ";
			}
		}
		answer.append("]}");

		return answer.toString();
	}
}
