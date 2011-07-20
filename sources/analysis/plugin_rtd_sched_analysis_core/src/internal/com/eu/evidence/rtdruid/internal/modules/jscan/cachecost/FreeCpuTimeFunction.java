package com.eu.evidence.rtdruid.internal.modules.jscan.cachecost;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FreeCpuTimeFunction implements IFreeCpuTimeFunction {

	/**
	 * This tiny class identifies the real time where there is a specific free
	 * cpu time
	 * 
	 * @author Nicola Serreli
	 * 
	 */
	protected static class Point {
		protected final double freeTime;
		protected final double realTime;

		public Point(double free, double real) {
			this.freeTime = free;
			this.realTime = real;
		}

		
		public String toString() {
			return "{" + freeTime + " free at " + realTime + " }";
		}

		public double getFreeTime() {
			return freeTime;
		}

		public double getRealTime() {
			return realTime;
		}
	}

	/**
	 * This class compares the free time of two point
	 * 
	 * @author Nicola Serreli
	 * 
	 */
	protected static class FreeTimeComparator implements Comparator<Point> {
		
		public int compare(Point o1, Point o2) {
			if (o1 == null) {
				return o2 == null ? 0 : Integer.MAX_VALUE;
			} else if (o2 == null) {
				return Integer.MIN_VALUE;
			}

			Double d1 = new Double(o1.freeTime);
			Double d2 = new Double(o2.freeTime);
			return d1.compareTo(d2);
		}
	}

	protected ArrayList<Point> elements = new ArrayList<Point>();
	protected double period;

	/**
	 * Builds an empty function with an infinite period
	 */
	public FreeCpuTimeFunction() {
		this.period = Double.POSITIVE_INFINITY;
		elements.add(new Point(0, 0));
	}

	/**
	 * Builds an empty function with an specified period
	 * 
	 * @param period
	 *            the period of this function
	 * 
	 * @throws IllegalArgumentException
	 *             if the period is zero o less.
	 */
	public FreeCpuTimeFunction(double period) throws IllegalArgumentException {
		this();
		if (period <= 0) {
			throw new IllegalArgumentException(
					"Period cannot be less or equal 0");
		}
		this.period = period;

	}

	/**
	 * This method allow to add a new point, i.e. add the information that there
	 * are a specified free unit of time after the given real time. Clearly free
	 * cannot be bigger then real. Both cannot be negative.
	 * 
	 * It's possible to add points only if the free time is equal or bigger then
	 * last added free time.
	 * 
	 * Adding the same (last) free time more than once is admitted only if the
	 * real time is equal or bigger. In this case, the real time is updated.
	 * 
	 * @param free
	 *            free cpu time. cannot be negative
	 * @param real
	 *            the instant in the real clock when the specified free time
	 *            unit are available. cannot be negative
	 * 
	 * @throws IllegalArgumentException
	 *             if free is bigger than real, if one parameter is negative, or
	 *             if the specified free time is smaller than the last added
	 *             free time.
	 * 
	 */
	public void addAPoint(double free, double real)
			throws IllegalArgumentException {

		// checks
		if (free < 0 || real < 0) {
			throw new IllegalArgumentException("Negative parameter");
		}
		if (free > real) {
			throw new IllegalArgumentException(
					"Free time cannot be greater than real time");
		}

		Point last = elements.get(elements.size() - 1);
		if (last.freeTime > free) {
			throw new IllegalArgumentException(
					"Too small free time (already added a bigger one)");
		} else if (last.freeTime == free && last.realTime > real) {
			throw new IllegalArgumentException(
					"Too small real time (already added a point with the same free time and a bigger real time)");
		}

		if (free - last.freeTime > real - last.realTime) {
			throw new IllegalArgumentException(
					"Delta free time is bigger than the delta of real times");
		}

		// add or update
		if (last.freeTime == free && last.realTime < real) {
			elements.remove(elements.size() - 1);
		}

		elements.add(new Point(free, real));
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.hidden.modules.jscan.cachecost.IFreeCpuTimeFunction#getRealTime(double)
	 */
	public double getRealTime(double freeTime) throws IllegalArgumentException {

		if (freeTime < 0) {
			throw new IllegalArgumentException("Negative parameter");
		}

		double answer = -1;

		Point last = elements.get(elements.size() - 1);
		if (last.realTime <= period) {
			// there isn't any overlap among periods
			double periodicFreeTime = last.freeTime + (period - last.realTime);
			answer = (period == Double.POSITIVE_INFINITY ? 0 : period
					* (Math.floor(freeTime / periodicFreeTime)))
					+ computeRealTime(freeTime % periodicFreeTime);

		} else {
			// we have to consider also overlap among periods !!

		}

		return answer;
	}

	/**
	 * This function compute the real instant when there are the specified of
	 * free unit of time, based only on one instance (doesn't take care of
	 * periods)
	 * 
	 * @param freeTime
	 *            the required free unit of time. Cannot be negative
	 * 
	 * @return the instant when the specified amount of free time is available,
	 *         without considering periods
	 */
	private double computeRealTime(double freeTime) {
		double answer = 0;

		int index = Collections.binarySearch(elements, new Point(freeTime,
				freeTime), new FreeTimeComparator());
		if (index >= 0) {
			answer = elements.get(index).realTime;
		} else {
			Point p = elements.get((-index) - 2);
			answer = p.realTime + (freeTime - p.freeTime);
		}
		return answer;
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.hidden.modules.jscan.cachecost.IFreeCpuTimeFunction#getPreemptions(double)
	 */
	public int getPreemptions(double freeTime) throws IllegalArgumentException {

		if (freeTime < 0) {
			throw new IllegalArgumentException("Negative parameter");
		}

		int answer = -1;

		Point last = elements.get(elements.size() - 1);
		if (last.realTime <= period) {
			// there isn't any overlap among periods
			double periodicFreeTime = last.freeTime + (period - last.realTime);
			answer = (period == Double.POSITIVE_INFINITY ? 0
					: (elements.size() * ((int) Math.floor(freeTime
							/ periodicFreeTime))))
					+ computeLocalPreemption(freeTime % periodicFreeTime);

		} else {
			// we have to consider also overlap among periods !!

		}

		return answer;
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
		int index = Collections.binarySearch(elements, new Point(freeTime,
				freeTime), new FreeTimeComparator());
		
		return index < 0 ? (-index) - 1 : index + 1; 
	}
	
	
	public double getFreeTimeAt(double realTime)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not finished jet");
	}
}
