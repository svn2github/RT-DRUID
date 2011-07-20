package com.eu.evidence.rtdruid.internal.modules.jscan.cachecost;

/**
 * 
 * @author Nicola Serreli
 *
 */
public interface IFreeCpuTimeFunction {

	/**
	 * This function compute the real instant when there are the specified of
	 * free unit of time.
	 * 
	 * @param freeTime
	 *            the required free unit of time. Cannot be negative
	 * 
	 * @return the instant when the specified amount of free time is available
	 * 
	 * @throws IllegalArgumentException
	 *             if freeTime is negative
	 */
	public abstract double getRealTime(double freeTime)
			throws IllegalArgumentException;

	

	/**
	 * This function compute the amount of free time at a specific instant.
	 * 
	 * @param freeTime
	 *            the required free unit of time. Cannot be negative
	 * 
	 * @return the instant when the specified amount of free time is available
	 * 
	 * @throws IllegalArgumentException
	 *             if freeTime is negative
	 */
	public abstract double getFreeTimeAt(double realTime)
			throws IllegalArgumentException;

	
	/**
	 * This function compute the number of preemption before get the required
	 * amount of free unit of time.
	 * 
	 * @param freeTime
	 *            the required free unit of time. Cannot be negative
	 * 
	 * @return the number of preemption
	 * 
	 * @throws IllegalArgumentException
	 *             if freeTime is negative
	 */
	public abstract int getPreemptions(double freeTime)
			throws IllegalArgumentException;

}