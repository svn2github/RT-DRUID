/*
 * Created on 8-giu-2004
 *
 * $Id: OilConfWriter.java,v 1.8 2007/03/29 11:54:36 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.ant;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

import com.eu.evidence.rtdruid.desk.Logger;
import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.OilWorkerException;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.WorkerOilConfWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.options.PreferenceStorage;

/**
 * An Ant Task that perform Code Configuration of a system described by an Oil
 * File.
 * 
 * @author Nicola Serreli
 *  
 */
public class ConfWriter extends Task {
	
	protected String preferenceFile = null;

	protected WorkerOilConfWriter worker = new WorkerOilConfWriter(new Logger() {
		
		public void log(String txt) {
			myLog(txt);
		}
	
	});

	/**
	 * Specifies the input oil file
	 * 
	 * @param fileName
	 *            contains the name of Oil file
	 */
	public void setPreferencefile(String fileName) {
		if (fileName.length()>0)
			preferenceFile = fileName;
	}

	/**
	 * Specifies the input oil file
	 * 
	 * @param fileName
	 *            contains the name of Oil file
	 */
	public void setInputfile(String fileName) {
		worker.setInputfile(fileName);
	}

	/**
	 * Specifies the absolute path of directory that will contains the output
	 * 
	 * @param value
	 *            the output directory name
	 */
	public void setOutputdir(String value) {
		worker.setOutputdir(value);
	}

	/**
	 * Start works. Check specified parameters, load file, compute buffers and
	 * write all outputs
	 * 
	 * @throws BuildException
	 *             if there is an error.
	 */
	public void execute() throws BuildException {
		// Prepare preferences
		PreferenceStorage prefs = PreferenceStorage.getCommonIstance();
		if (preferenceFile != null) {
			File f = new File(preferenceFile);
			if (!(f.exists() && f.isFile() && f.canRead())) {
				throw new BuildException("Cannot find or read " + preferenceFile);
			}
			
			prefs.setCurrentFile(f);
		}
		if (prefs.getCurrentFile() != null)
			prefs.load();
		worker.addOptions(prefs.getAllValue());
		
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