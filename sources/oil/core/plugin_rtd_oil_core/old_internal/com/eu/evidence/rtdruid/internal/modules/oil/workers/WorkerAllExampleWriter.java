/*
 * Created on 5-gen-2005
 *
 * $Id: WorkerExampleWriter.java,v 1.4 2007/05/11 16:09:42 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.workers;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.eu.evidence.rtdruid.desk.Logger;
import com.eu.evidence.rtdruid.internal.modules.project.templates.ExampleTemplate;
import com.eu.evidence.rtdruid.internal.modules.project.templates.SearchTemplates;


/**
 * An Ant Task that write an example inside a directory.
 * 
 * @author Nicola Serreli
 *  
 */
public class WorkerAllExampleWriter implements IWorkerExampleWriter {
		/** The file where store all outputs */
	protected String outputDirectory = null;
	
	/** One or more options for Code Generator */
	protected HashMap<String, ? extends Object> options = new HashMap<String, Object>();

	protected Logger logger;
	
	public WorkerAllExampleWriter(Logger logger) {
		this.logger = logger;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setOptions(HashMap<String, ? extends Object> opt) {
		this.options.putAll((Map) opt);	
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.internal.modules.oil.workers.IWorkerExampleWriter#setOutputDirectory(java.lang.String)
	 */
	@Override
	public void setOutputDirectory(String value) {
		outputDirectory = value;
		if (value.length()>0 && !value.endsWith(File.separator)) {
			outputDirectory += File.separatorChar;
		}
	}



	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.internal.modules.oil.workers.IWorkerExampleWriter#execute()
	 */
	@Override
	public void execute() throws OilWorkerException {
		// ------------- make all checks ----------------
		if (outputDirectory == null) {
			throw new RuntimeException("Required an output directory");
		}

		logger.log(""); // empty line
		

		// --------------- Load example ------------------
		ExampleTemplate[] templates = SearchTemplates.getConfigTemplates();

		// --------------- Store files -------------------
		for (int i=0; i<templates.length; i++) {
			WorkerExampleWriter worker = new WorkerExampleWriter(logger);
			worker.setExampleID(templates[i].getExampleID());
			worker.setExampleTemplate(templates[i]);
			worker.setOutputDirectory(outputDirectory);
			worker.setOptions(options);
			worker.execute();
		}
	}

}