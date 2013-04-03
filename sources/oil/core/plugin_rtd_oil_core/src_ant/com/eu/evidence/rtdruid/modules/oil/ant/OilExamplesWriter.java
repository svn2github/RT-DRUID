/*
 * Created on 5-gen-2005
 *
 * $Id: OilExamplesWriter.java,v 1.5 2007/05/30 12:33:29 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.ant;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

import com.eu.evidence.rtdruid.desk.Logger;
import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.OilWorkerException;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.WorkerExampleWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.WorkerOilConfWriter;
import com.eu.evidence.rtdruid.internal.modules.project.templates.ExampleTemplate;
import com.eu.evidence.rtdruid.internal.modules.project.templates.SearchTemplates;

/**
 * An Ant Task that write all examples inside a directory.
 * 
 * @author Nicola Serreli
 *  
 */
public class OilExamplesWriter extends Task {
	

	protected WorkerExampleWriter wWriter = new WorkerExampleWriter(new Logger() {
		public void log(String txt) {
			OilExamplesWriter.this.log(txt);
		}
	
	});

	protected WorkerOilConfWriter wOilConf = new WorkerOilConfWriter(new Logger() {
		public void log(String txt) {
			OilExamplesWriter.this.log(txt);
		}
	
	});

	/** The default left part of an output. See {@link #myLog myLog}. */
	//private final static String LEFT = "Oil Examples WRITER";

	/** The file where store all outputs */
	protected String outputDirectory = null;
	
	/** One or more options for Code Generator */
//	protected HashMap options = new HashMap();

	/** True if is required to run the configurator on each template. defualt= false */
	protected boolean runConf = false;


	/**
	 * Specifies the absolute path of directory that will contains the output
	 * 
	 * @param value
	 *            the output directory name
	 */
	public void setOutputDirectory(String value) {
		outputDirectory = value;
		if (value.length()>0 && !value.endsWith(File.separator)) {
			outputDirectory += File.separatorChar;
		}
	}

	/**
	 * Specifies if run the configurator on each template
	 * 
	 * @param value
	 *            true if is required to run the configurator
	 */
	public void setAlsoConfigure(String value) {
		runConf = "true".equalsIgnoreCase(value); 
	}


	protected ExampleTemplate[] searchTemplates() {
		log("Search Templates"); // empty line
		ExampleTemplate[] templates = SearchTemplates.getConfigTemplates();
		
		if (templates.length == 0) {
			log(" ...  No templates found."); // empty line
		}
		for (int i=0; i<templates.length; i++) {
			log(" ... FOUND " + templates[i].getExampleID()); // empty line
		}
		return templates;
	}
	/**
	 * Stores all buffers inside the specified directory.
	 * 
	 * @throws BuildException
	 *             if there is one or more errors during store operation
	 *  
	 */
	protected void save(ExampleTemplate template) {

		log("\n\nExample ID = " + template.getExampleID()); // empty line
//		log("\nExample ID = " + template.toString()); // empty line

		try {
			wWriter.setExampleTemplate(template);
			wWriter.setOutputDirectory(outputDirectory + template.getExampleID()+File.separatorChar );
			wWriter.execute();
			
			if (runConf) {
				wOilConf.setOutputdir(outputDirectory + template.getExampleID()+File.separatorChar+"Debug"+File.separatorChar);
				wOilConf.setInputfile(outputDirectory + template.getExampleID()+File.separatorChar+"conf.oil");
				wOilConf.execute();
			}
		} catch (OilWorkerException e) {
//			RtdruidLog.showDebug(e);
			throw new BuildException(e.getMessage());
		}
		
	}

	/**
	 * Start works. Check specified parameters, load file, compute buffers and
	 * write all outputs
	 * 
	 * @throws BuildException
	 *             if there is an error.
	 */
	public void execute() throws BuildException {
		// ------------- make all checks ----------------
		if (outputDirectory == null) {
			throw new BuildException("Required an output directory");
		}

		log(""); // empty line
		

		// --------------- Load example ------------------
		ExampleTemplate[] templates = searchTemplates();

		// --------------- Store files -------------------
		for (int i=0; i<templates.length; i++)
			save(templates[i]);
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