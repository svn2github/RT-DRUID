package com.eu.evidence.rtdruid.internal.modules.jscan.cachecost;

import java.util.ArrayList;

/**
 * This class represent a function of Cpu Free Time, computed as composition of
 * other IFreeCpuTimeFunction.
 * 
 * @author Nicola Serreli
 * 
 */
public class ComposedFreeCpuTimeFunction implements IFreeCpuTimeFunction {

	/** Ordered subFunction. smaller indexes correspond to higher priorities */
	protected ArrayList<IFreeCpuTimeFunction> subFunctions = new ArrayList<IFreeCpuTimeFunction>();

	/**
	 * Builds an empty function with an infinite period
	 */
	public ComposedFreeCpuTimeFunction() {
	}

	/**
	 * Adds a new function with the lowest priority. Does nothing if the
	 * parameter is null
	 */
	public void addSubFunction(IFreeCpuTimeFunction function) {
		if (function != null) {
			subFunctions.add(function);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eu.evidence.rtdruid.hidden.modules.jscan.cachecost.IFreeCpuTimeFunction
	 * #getRealTime(double)
	 */
	public double getRealTime(double freeTime) throws IllegalArgumentException {
		

		if (freeTime < 0) {
			throw new IllegalArgumentException("Negative parameter");
		} 
		
		if (true) {
			throw new UnsupportedOperationException("Not finished jet");
		}

		double answer = freeTime;

		if (subFunctions.size() == 1) {
			answer = subFunctions.get(0).getRealTime(freeTime);
		} else if (subFunctions.size() > 1) {

			int size = subFunctions.size();

			int iterations = 0;
			double required = freeTime;

			// contains all found free times
			double[][] found_free = { new double[size], new double[size] };
			int pfv = 1; // previous free times vector
			int cfv = (pfv + 1) % 2; // current free times vector

			boolean needAnotherStep;

			do {
				pfv = cfv; // update previous free times vector
				cfv = (pfv + 1) % 2; // update current free times vector

				for (int i = 0; i < size; i++) {
					IFreeCpuTimeFunction func = subFunctions.get(i);

					required = found_free[cfv][i] = func.getRealTime(required);
				}

				needAnotherStep = false;
				for (int i = 0; i < size; i++) {
					IFreeCpuTimeFunction func = subFunctions.get(i);

					// check if there is something between the final required
					// time and the time computed for this function
					
//					if (func.getFreeTimeAt(required) )
//						required = found_free[cfv][i] = func
//								.getRealTime(required);
				}

				iterations++; // completed one iteration
			} while (needAnotherStep || iterations > 1000);

		}

		return answer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eu.evidence.rtdruid.hidden.modules.jscan.cachecost.IFreeCpuTimeFunction
	 * #getPreemptions(double)
	 */
	public int getPreemptions(double freeTime) throws IllegalArgumentException {

		if (freeTime < 0) {
			throw new IllegalArgumentException("Negative parameter");
		}

		int answer = -1;

		return answer;
	}

	
	public double getFreeTimeAt(double realTime)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not finished jet");
	}
	
	/**
	 * This function compute the number of preemption, based only on one
	 * instance (doesn't take care of periods)
	 * 
	 * @param freeTime
	 *            the required free unit of time. Cannot be negative
	 * 
	 * @return the number of preemption, without considering periods
	 */
	private int computeLocalPreemption(double freeTime) {
		int index = -1;

		return index < 0 ? (-index) - 1 : index + 1;
	}
}
