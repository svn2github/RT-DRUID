/*
 * Created on 5-gen-2005
 *
 * $Id: WorkerExampleWriter.java,v 1.4 2007/05/11 16:09:42 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.workers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.eu.evidence.rtdruid.desk.Logger;
import com.eu.evidence.rtdruid.desk.WorkerConfReader;
import com.eu.evidence.rtdruid.internal.modules.project.templates.ExampleTemplate;
import com.eu.evidence.rtdruid.internal.modules.project.templates.SearchTemplates;

/**
 * An Ant Task that write an example inside a directory.
 * 
 * @author Nicola Serreli
 *  
 */
public class WorkerExampleWriter implements IWorkerExampleWriter {
	
	/** The default left part of an output. See {@link #myLog myLog}. */
	private final static String LEFT = "EXAMPLE WRITER";

	/** The example ID */
	protected String exampleID = null;

	/** The example */
	protected ExampleTemplate example = null;

	/** The file where store all outputs */
	protected String outputDirectory = null;
	
	/** One or more options for Code Generator */
	protected HashMap<String, ? extends Object> options = new HashMap<String, Object>();

	protected Logger logger;
	
	public WorkerExampleWriter(Logger logger) {
		this.logger = logger;
	}

	@Override
	public void setOptions(HashMap<String, ? extends Object> opt) {
		this.options.putAll((Map) opt);	
	}
	
	/**
	 * Set the example ID
	 * 
	 * @param name
	 *            contains the ID of example/template that have to be stored in the output dir
	 */
	public void setExampleID(String name) {
		
//		if (name.indexOf(' ') >=0) {
//			throw new BuildException("Example ID cannot contain a white space : '" + name + "'" );
//		}
		
		exampleID = name;
	}

	/**
	 * Set directly the example template 
	 * 
	 * @param template
	 *            All data of choosed example (it set also the example ID)
	 */
	public void setExampleTemplate(ExampleTemplate template) {
		example = template;
		if (example != null) {
			exampleID = example.getExampleID();
		}
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


	protected ExampleTemplate searchTemplate() throws OilWorkerException {
		myLog(LEFT, "Search Template (ID = " + exampleID + ") ... "); // empty line
		ExampleTemplate[] templates = SearchTemplates.getConfigTemplates();
		
		ArrayList<String> names = new ArrayList<String>();
		for (int i=0; i<templates.length; i++) {
			if (exampleID.equals(templates[i].getExampleID())) {
				myLog(""," ... FOUND at '" + templates[i].getFs_path() + "'"); // empty line
				return templates[i];
			}
			names.add(templates[i].getExampleID());
		}
		myLog(""," ... NOT FOUND"); // empty line
		throw new OilWorkerException("The specified example is not found.\n Availables are :" + names);
	}
	/**
	 * Stores all buffers inside the specified directory.
	 * 
	 * @throws OilWorkerException
	 *             if there is one or more errors during store operation
	 *  
	 */
	protected void save(ExampleTemplate template) throws OilWorkerException {

		myLog("TEMPLATE", template.getCategory() + " - " + template.getExampleID());

		ExampleTemplate.ExampleFile[] files = template.getExampleFiles();
		
		for (int i=0; i<files.length; i++) {
			ExampleTemplate.ExampleFile f = files[i];
			InputStream is = f.getContent();

			String outputFile = WorkerConfReader.formatFileName(outputDirectory +f.getName());
			myLog("COPY", outputFile);

//			new File(outputDirectory).mkdirs();
			// build the directory
			File dirs = new File(outputFile);
			dirs = dirs.getParentFile();
			if (dirs != null) dirs.mkdirs();

			try {
				if (is!= null) {
					// write the file
					FileOutputStream file = new FileOutputStream(outputFile, false);
					byte[] buffer = new byte[4096];
					int num = 0;
					while ((num = is.read(buffer)) !=-1) {
						file.write(buffer, 0, num);
					}
					
					file.close();
					is.close();
				}
			} catch (IOException e) {
				throw new OilWorkerException("Cannot copy the file " + outputFile + "\n -> " + e.getMessage()) ;
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.internal.modules.oil.workers.IWorkerExampleWriter#execute()
	 */
	@Override
	public void execute() throws OilWorkerException {
		// ------------- make all checks ----------------
		if (exampleID == null) {
			throw new RuntimeException("Required an example ID");
		}
		if (outputDirectory == null) {
			throw new RuntimeException("Required an output directory");
		}

		logger.log(""); // empty line
		

		// --------------- Load example ------------------
		ExampleTemplate template = example;
		if (template == null) {
			template = searchTemplate();
		}

		// --------------- Store files -------------------
		save(template);
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

		logger.log("["
				+ left
				+ ("                 ".substring(0,
						(left.length() > LEFT_SIZE - 1 ? 1 : LEFT_SIZE
								- left.length()))) + right + "]");
	}

}