package com.eu.evidence.rtdruid.internal.modules.jscan.procdeadlines;

import com.eu.evidence.rtdruid.vartree.abstractions.old.Task.ProcData;

public class DeadlineData {

	protected ProcData start;
	protected ProcData end;
	protected double value;
	
	protected double chainResponse;
	
	public DeadlineData(ProcData start, ProcData end, double value) {
		this.start = start;
		this.end = end;
		this.value = value;
	}
	
	public ProcData getStart() {
		return start;
	}
	
	public ProcData getEnd() {
		return end;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setChainResponse(double chainResponse) {
		this.chainResponse = chainResponse;
	}
	
	public double getChainResponse() {
		return chainResponse;
	}
}
