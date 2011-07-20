package com.eu.evidence.rtdruid.vartree.abstractions.old;

/**
 * This interface is used to get the wcet of a General MultiFrame Task
 * 
 * @author Nicola Serreli
 * 
 */
public interface IGeneralMultiframeTaskWcet {

	/**
	 * Returns the wcet of a specific instance of a General multiframe task
	 * 
	 * @param instance
	 *            identifies the instance of task for which compute the wcet
	 * 
	 * @return the wcet of a specific instance of a General multiframe task
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if instance is smaller than 0
	 */
	double getWcet(int instance) throws IndexOutOfBoundsException;


	/**
	 * Returns the wcet of a first instances of a General multiframe task
	 * 
	 * @param instances
	 *            identifies the instance of task for which compute the wcet
	 * 
	 * @return the cumulative wcet of task instances between 0 and instances
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if instance is smaller than 0
	 */
	double getCumulativeWcet(int instances) throws IndexOutOfBoundsException;


	/**
	 * Returns the average wcet of a General multiframe task
	 * 
	 * @return the average wcet of task instances between 0 and instances
	 */
	double getAverageWcet();

	
	/**
	 * @return true if this object doesn't have any (or enough)information to compute wcet 
	 */
	boolean isEmpty();
}
