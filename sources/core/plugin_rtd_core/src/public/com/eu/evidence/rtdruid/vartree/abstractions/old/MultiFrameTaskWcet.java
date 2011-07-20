package com.eu.evidence.rtdruid.vartree.abstractions.old;

import java.util.ArrayList;

/**
 * This class models a simple multiframe task
 * 
 * @author Nicola Serreli
 * 
 */
public class MultiFrameTaskWcet implements IGeneralMultiframeTaskWcet, IProcBasedTaskWcet {
	

	public static class ProcDescription {
		private String procName;
		private int onceEveryK = 1;
		private double wcet;

		public ProcDescription(String name, double wcet, int onceEveryK) throws IllegalArgumentException {
			if (onceEveryK <1) {
				throw new IllegalArgumentException("OnceEveryK parameter cannot be smaller than 1");
			}
			
			this.procName = name;
			this.wcet = wcet;
			this.onceEveryK = onceEveryK;
		}

		/**
		 * Returns the contribution of this proc to the specified task instance.
		 * Note that the first instance is the number 0 (zero)
		 * 
		 * @param instance
		 *            identified a task instance
		 * 
		 * @return the wcet of this proc, if the proc is active in the specified
		 *         instance. Otherwise returns 0 (zero).
		 * 
		 * @throws IndexOutOfBoundsException
		 *             if instance is smaller than 1
		 */
		public double contributionOnInstanceK(int instance)
				throws IndexOutOfBoundsException {
			if (instance < 1)
				throw new IndexOutOfBoundsException(
						"Instance id cannot be smaller than one");

			return wcet * (((instance -1) % onceEveryK) == 0 ? 1 : 0);
		}

		/**
		 * Returns the contribution of this proc to the set of task instance.
		 * Note that the first instance is the number 0 (zero)
		 * 
		 * @param instance
		 *            identified a task instance
		 * 
		 * @return the sum of wcet contributions of this proc to all task
		 *         instances between 0 and instance.
		 * 
		 * @throws IndexOutOfBoundsException
		 *             if instance is smaller than 1
		 */
		public double contributionOnFirstKInstances(int instance)
				throws IndexOutOfBoundsException {
			if (instance < 1)
				throw new IndexOutOfBoundsException(
						"Instance id cannot be smaller than one");

			return wcet * (Math.ceil((instance +0.0)/ onceEveryK));
		}
		
		public int getOnceEveryK() {
			return onceEveryK;
		}
		
		public double getWcet() {
			return wcet;
		}
		
		public String getProcName() {
			return procName;
		}
		
		public void setWcet(double wcet) {
			this.wcet = wcet;
		}
		
		@Override
		public String toString() {
			return "{Proc = "+procName + ". wcet = " + wcet + " every " + onceEveryK + " instances}";
		}
	}
	
	
	private ArrayList<ProcDescription> procs = new ArrayList<ProcDescription>();
	private double average = -1;

	
	public void addAProc(ProcDescription proc) {
		procs.add(proc);
		average = -1;
	}
	
	public void addAProc(String name, double wcet, int onceEveryK) throws IllegalArgumentException {
		procs.add(new ProcDescription(name, wcet, onceEveryK));
		average = -1;
	}

	
	public double getWcet(int instance) throws IndexOutOfBoundsException {
		double answer = 0;
		
		for (ProcDescription proc : procs) {
			answer += proc.contributionOnInstanceK(instance);
		}

		return answer;
	}

	
	public double getCumulativeWcet(int instance) throws IndexOutOfBoundsException {
		double answer = 0;
		
		for (ProcDescription proc : procs) {
			answer += proc.contributionOnFirstKInstances(instance);
		}

		return answer;
	}

	/**
	 * Calculates the gcd using the Eulers method
	 */
	protected int gcd(int m, int n) {
		while ((m > 0) && (n > 0))
			if (m > n)
				m %= n;
			else
				n %= m;
		return m + n;
	}
	/**
	 * Calculates the lcm
	 */
	protected int lcm(int m, int n) {
		int gcd = gcd(m,n);
		return (m/gcd)*n;
	}
	
	public double getAverageWcet() {
		if (average >= 0) {
			return average;
		}
		
		
		// searching the number of elements
		int num = 1;
		for (ProcDescription proc : procs) {
			num = lcm(num,  proc.getOnceEveryK());
		}
		
		double answer = 0;
		
		// searching the number of elements
		for (ProcDescription proc : procs) {
			answer += proc.contributionOnFirstKInstances(num);
		}

		return answer/num;
	}
	
	public boolean isEmpty() {
		return procs.isEmpty();
	}

	
	public double getWcetToCompleteProc(String procName, int instance) {
		
		if (procName == null) {
			throw new IllegalArgumentException("Cannot accept null names");
		}
		if (instance == 0) {
			throw new IllegalArgumentException("First instance is 1");
		}
		
		if (instance < -1) {
			return 0;
		}

		if (instance == -1) {
			// here we consider that the worst condition is at the instance 0
			instance = 1;
		}
		
		double answer = 0;
		boolean found = false;
		
		for (ProcDescription proc : procs) {
			answer += proc.contributionOnInstanceK(instance);
			if (procName.equals(proc.getProcName())) {
				found = true;
				break;
			}
		}
		
		if (!found) {
			throw new IllegalArgumentException("Cannot find the specified proc name");
		}

		return answer;
	}
	

	public String[] getProcList() {
		String[] names = new String[procs.size()];
		for (int i=0; i<procs.size(); i++) {
			names[i] = procs.get(i).getProcName();
		}

		return names;
	}
	
	public double getProcWcet(String procName) {
		for (ProcDescription proc : procs) {
			if (procName.equals(proc.getProcName())) {
				return proc.getWcet();
			}
		}
		return 0;
	}
	
	public void updateProcWcet(String procName, double newValue) {
		for (ProcDescription proc : procs) {
			if (procName.equals(proc.getProcName())) {
				proc.setWcet(newValue);
			}
		}
	}
	
	
	public double forceAverage() {
		average = -1;
		return getAverageWcet();
	}
	
	@Override
	public String toString() {
		return "MultiFrame Task: proc list " + procs;
	}
	
}
