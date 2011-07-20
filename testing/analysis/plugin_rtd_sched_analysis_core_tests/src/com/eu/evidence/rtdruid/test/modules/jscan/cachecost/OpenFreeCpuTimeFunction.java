package com.eu.evidence.rtdruid.test.modules.jscan.cachecost;

import com.eu.evidence.rtdruid.internal.modules.jscan.cachecost.FreeCpuTimeFunction;

/**
 * This class is used to export internal state of this function
 * 
 * @author Nicola Serreli
 *
 */
public class OpenFreeCpuTimeFunction extends FreeCpuTimeFunction {

	public OpenFreeCpuTimeFunction() {
		super();
	}
	public OpenFreeCpuTimeFunction(double period) {
		super(period);
	}
	
	public double[] openGetFrees() {
		double[] answer = new double[elements.size()];
		for (int i=0; i<answer.length; i++) {
			answer[i] = elements.get(i).getFreeTime();
		}
			 
		return answer;
	}
	
	public double[] openGetReals() {
		double[] answer = new double[elements.size()];
		for (int i=0; i<answer.length; i++) {
			answer[i] = elements.get(i).getRealTime();
		}
			 
		return answer;
	}
	
	public double openGetPeriod() {
		return period;
	}
}
