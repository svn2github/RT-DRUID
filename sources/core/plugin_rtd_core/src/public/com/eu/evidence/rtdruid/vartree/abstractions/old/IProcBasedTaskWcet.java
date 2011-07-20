package com.eu.evidence.rtdruid.vartree.abstractions.old;

/**
 * This interface is used to get the wcet of a Task computed as composition of
 * Procs
 * 
 * @author Nicola Serreli
 * 
 */
public interface IProcBasedTaskWcet {

	/**
	 * This method returns the wcet of a task considering only all procs that
	 * are mapped before the specified proc and the proc itself.
	 * First instance is number 1. instance -1 means "worst condition".
	 * 
	 * @param procName
	 *            the last proc to considered
	 *            
	 * @param instance
	 *            the instance that should be considered. -1 looks for the worst condition
	 * 
	 * @return the wcet of a subsection of a task, composed by a proc and all
	 *         procs that precedes it
	 *         
	 */
	public double getWcetToCompleteProc(String procName, int instance);
	
	public String[] getProcList();
	
	public double getProcWcet(String procName);
	
	public void updateProcWcet(String procName, double newValue);
}
