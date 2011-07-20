package com.eu.evidence.rtdruid.internal.modules.jscan.partialorder;

public class StandarOutputReporter implements IReport {

	
	public void message(String text) {
		System.out.println(text);
	}
	
	
	public void error(String text) {
		System.out.println("Err          : " + text);
	}
	
	
	public void error(ProcData pdata, String text) {
		System.out.println("Err for proc " + pdata+ ": " + text);
	}

	
	public void error(TaskData tdata, String text) {
		System.out.println("Err for task " + tdata+ ": " + text);
	}
	
	
	public void warning(String text) {
		System.out.println("Wrn          : " + text);
	}

	
	public void warning(ProcData pdata, String text) {
		System.out.println("Wrn for proc " + pdata+ ": " + text);
	}

	
	public void warning(TaskData tdata, String text) {
		System.out.println("Wrn for task " + tdata+ ": " + text);
	}

}
