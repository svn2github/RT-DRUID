/*
 * Created on 5-gen-2005
 *
 * $Id: OilExampleWriter.java,v 1.3 2007/03/29 11:54:36 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.ant;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

import com.eu.evidence.rtdruid.desk.Logger;
import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.OilWorkerException;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.WorkerExampleWriter;

/**
 * An Ant Task that write an example inside a directory.
 * 
 * @author Nicola Serreli
 *  
 */
public class OilExampleWriter extends Task {
	
	protected WorkerExampleWriter worker = new WorkerExampleWriter(new Logger() {
	
		public void log(String txt) {
			myLog(txt);
		}
	
	});
	
	/**
	 * Enable the Source Distribution
	 * 
	 * @param fileName
	 *            contains the name of file that will contains the description
	 *            of Source Distribution
	 */
	public void setExampleID(String name) {
		worker.setExampleID(name);
	}

	/**
	 * Specifies the absolute path of directory that will contains the output
	 * 
	 * @param value
	 *            the output directory name
	 */
	public void setOutputDirectory(String value) {
		worker.setOutputDirectory(value);
	}

	/**
	 * Start works. Check specified parameters, load file, compute buffers and
	 * write all outputs
	 * 
	 * @throws BuildException
	 *             if there is an error.
	 */
	public void execute() throws BuildException {
		try {
			worker.execute();
		} catch (OilWorkerException e) {
			throw new BuildException(e.getMessage());
		}
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

		if (Messages.LogLevel.info.enabled())
			log("["
					+ left
					+ ("                 ".substring(0,
							(left.length() > LEFT_SIZE - 1 ? 1 : LEFT_SIZE
									- left.length()))) + right + "]");
	}
	protected void myLog(String txt) {
		log(txt);
	}

}