package com.eu.evidence.rtdruid.internal.modules.jscan.partialorder;


/**
 * This interface is used to manage the output of Partial Order test 
 */
public interface IReport {

	public void message(String text);

	public void warning(String text);
	
	public void warning(ProcData pdata, String text);
	
	public void warning(TaskData tdata, String text);

	public void error(String text);

	public void error(ProcData pdata, String text);
	
	public void error(TaskData tdata, String text);
}
