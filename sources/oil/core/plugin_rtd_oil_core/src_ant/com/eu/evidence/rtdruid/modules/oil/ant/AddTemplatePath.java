package com.eu.evidence.rtdruid.modules.oil.ant;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.oil.templates.DynamicTemplateProvider;

public class AddTemplatePath extends Task {
	
	protected String templatePath = null;

	/**
	 * Specifies the input oil file
	 * 
	 * @param fileName
	 *            contains the name of Oil file
	 */
	public void setPath(String fileName) {
		if (fileName.length()>0)
			templatePath = fileName;
	}

	/**
	 * Start works. Check specified parameters, load file, compute buffers and
	 * write all outputs
	 * 
	 * @throws BuildException
	 *             if there is an error.
	 */
	public void execute() throws BuildException {
		myLog("Template path", "Adding " + templatePath);
		DynamicTemplateProvider.addPath(templatePath);
	}

	/**
	 * This method shows a message.
	 * 
	 * The output looks like :<br>
	 * [LEFT &nbsp;&nbsp;&nbsp;RIGTH]
	 * 
	 * @param left
	 *            what write in the left side
	 * @param rigth
	 *            what write in the rigth side
	 */
	protected void myLog(String left, String right) {
		final int LEFT_SIZE = 10;

		if (Messages.LogLevel.info.enabled()) {
			log("["
					+ left
					+ ("                 ".substring(0,
							(left.length() > LEFT_SIZE - 1 ? 1 : LEFT_SIZE
									- left.length()))) + right + "]");
		}
	}

}
