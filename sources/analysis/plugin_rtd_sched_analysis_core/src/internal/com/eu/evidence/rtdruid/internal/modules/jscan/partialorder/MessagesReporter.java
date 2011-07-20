package com.eu.evidence.rtdruid.internal.modules.jscan.partialorder;

import com.eu.evidence.rtdruid.desk.Messages;

public class MessagesReporter implements IReport {

	
	public void message(String text) {
		Messages.sendTextNl(text);
	}

	
	public void error(String text) {
		Messages.sendErrorNl(text, null, "", null);
	}
	
	
	public void error(ProcData pdata, String text) {
		Messages.sendErrorNl(pdata+ ": " + text, null, "", null);
	}

	
	public void error(TaskData tdata, String text) {
		Messages.sendErrorNl(tdata+ ": " + text, null, "", null);
	}
	
	
	public void warning(String text) {
		Messages.sendWarningNl(text, null, "", null);
	}

	
	public void warning(ProcData pdata, String text) {
		Messages.sendWarningNl(pdata+ ": " + text, null, "", null);
	}

	
	public void warning(TaskData tdata, String text) {
		Messages.sendWarningNl(tdata+ ": " + text, null, "", null);
	}

}
