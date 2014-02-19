/*
 * Created on 8-giu-2004
 *
 * $Id: WorkerOilConfWriter.java,v 1.6 2008/01/25 15:58:04 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.workers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.eu.evidence.rtdruid.desk.Logger;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.desk.WorkerConfReader;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.RtosFactory;
import com.eu.evidence.rtdruid.oil.xtext.services.OilModelValidator;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.tools.Search;

/**
 * An Ant Task that perform Code Configuration of a system described by an Oil
 * File.
 * 
 * @author Nicola Serreli
 *  
 */
public class WorkerOilConfWriter extends WorkerConfReader {

	/** The default left part of an output. See {@link #myLog myLog}. */
	private final static String LEFT = "OIL WRITER";

	/** The directory where store all outputs */
	protected String outputDir = null;

	/** One or more options for Code Generator */
	protected HashMap<String, Object> options = new HashMap<String, Object>();

	/** The default separator for current OS */
	private static final String dirSep = System.getProperty("file.separator");
	
	public WorkerOilConfWriter(Logger logger) {
		super(logger);
		
		if ("TRUE".equalsIgnoreCase(System.getenv("enableValidation"))) {
			setValidator(new OilModelValidator());
			if ("TRUE".equalsIgnoreCase(System.getenv("failOnValidationError"))) {
				setFailOnValidatorError(true);
			}
		}
	}
	
	/**
	 * Add a new option of the writer
	 * 
	 * @param option
	 *            the ID of the option
	 * @param value
	 *            the current value
	 * 
	 */
	public void addOption(String option, String value) {
		options.put(option, value);
	}
	
	/**
	 * Add a new option of the writer
	 * 
	 * @param option
	 *            the ID of the option
	 * @param value
	 *            the current value
	 * 
	 */
	public void addOptions(HashMap<String, ? extends Object> values) {
		options.putAll(values);
	}
	
	/**
	 * Specifies the absolute path of directory that will contains the output
	 * 
	 * @param value
	 *            the output directory name
	 */
	public void setOutputdir(String value) {
		outputDir = value;
		if (outputDir == null || outputDir.length() == 0) {
			outputDir = "";
//		} else if (!outputDir.endsWith(dirSep)) {
//			outputDir += dirSep;
		}

	}

	/**
	 * Stores all buffers inside the specified directory.
	 * 
	 * @throws OilWorkerException
	 *             if there is one or more errors during store operation
	 *  
	 */
	protected void save(IOilWriterBuffer[] buffers) throws OilWorkerException {

		if (!outputDir.endsWith(dirSep)) {
			outputDir += dirSep;
		}
		for (int bi = 0; bi < buffers.length; bi++) {
			String[] keys = buffers[bi].getKeys();
			for (int ki = 0; ki < keys.length; ki++) {

				// get the output file name for current Buffer
				String fileName = buffers[bi].getFileName(keys[ki]);
				String filePath = buffers[bi].getFilePath(keys[ki]);

				if (!filePath.endsWith(System.getProperty("file.separator"))) {
					filePath += System.getProperty("file.separator");
				}
				
				myLog("WRITE", formatFileName(outputDir + filePath + fileName));
				try {
					// build the directory
					File dirs = new File(outputDir + filePath);
					dirs.mkdirs();

					// write the file
					FileOutputStream file = new FileOutputStream(outputDir
							+ filePath + fileName);
					file.write(buffers[bi].get(keys[ki]).toString().getBytes());
					file.close();
				} catch (IOException e) {
					//e.printStackTrace();
					throw new OilWorkerException(e.getMessage());
				}
			}
		}
	}

	/**
	 * Start works. Check specified parameters, load file, compute buffers and
	 * write all outputs
	 * 
	 * @throws OilWorkerException
	 *             if there is an error.
	 */
	public void execute() throws OilWorkerException {
		// ------------- make all checks ----------------
		if (inputFiles.isEmpty()) {
			throw new OilWorkerException("Required an input file");
		}
		if (outputDir == null) {
			throw new OilWorkerException("Required an output dir");
		}

		logger.log(""); // empty line
		
		{
			String tmp = outputDir;
			char c = dirSep.charAt(0);
			int pos = outputDir.lastIndexOf(c);
			int pos2 = 0;
			
			if (pos == -1) {
				// do nothing
			} else if (pos == (outputDir.length() -1)) {
				pos2 = tmp.lastIndexOf(c, pos-1);
				
				if (pos2 == -1) {
					tmp = tmp.substring(0,pos);
				} else {
					tmp = tmp.substring(pos2+1,pos);
				}
			} else {
				tmp = tmp.substring(pos);
			}

			options.put(IWritersKeywords.WRITER_OUTPUT_DIR_SET, Boolean.TRUE);
			options.put(IWritersKeywords.WRITER_FS_PATH_OUTPUT_DIR, outputDir);
			options.put(IWritersKeywords.WRITER_WS_OUTPUT_projectbase_DIR, "..");
			options.put(IWritersKeywords.WRITER_LAST_OUTPUT_DIR, tmp);
			
			if (System.getenv("EE_DISABLE_RULES") != null) {
				options.put(IWritersKeywords.WRITER_DISABLE_EE_RULES, "true".equalsIgnoreCase(System.getenv("EE_DISABLE_RULES")));
			}
		}

		// --------------- Load data ------------------

		IVarTree vt;
		try {
			vt = load();
		} catch (VtReaderException e1) {
			throw new OilWorkerException(e1);
		}
		final ITreeInterface ti = vt.newTreeInterface();

		// Prepare to store all rtos
		ArrayList<String> rtosPath = new ArrayList<String>();
		{
			String[] tmp = Search.allRtos(ti);
			if (tmp == null) {
				myLog(LEFT, "No Ecu found");
				return;
			}
			rtosPath.addAll(Arrays.asList(tmp));
		}

		//myLog("ELENCO", ""+rtosPath);
		if (rtosPath.size() == 0) {
			myLog(LEFT, "No RT-OS found");
			return;
		}

		// --------------- Set nios' app_dir and project variables -----------

		vt.getProperties().put(IWritersKeywords.VTProperty_OilProjectName,
				"myProject");

		{
			String stmp = outputDir;
			//stmp = stmp.replace('\\','/');
			if (stmp.endsWith("/") || stmp.endsWith("\\")) {
				stmp = stmp.substring(0, stmp.length()-1);
			}
			vt.getProperties().put(IWritersKeywords.VTProperty_OilProjectPath,
					stmp);
			
		}

		// --------------- Compute -------------------

		myLog("WORKING", "Prepare configuration's files");
		IOilWriterBuffer[] buffers = null;
		try {
			buffers = RtosFactory.INSTANCE.write(vt,
					(String[]) rtosPath.toArray(new String[rtosPath.size()]),
					options);
		} catch (OilCodeWriterException e) {
			RtdruidLog.showDebug(e);
			throw new OilWorkerException(e.getMessage());
		}
		myLog("      ", "Start to save");

		// ---------------- Store files -------------------
		save(buffers);
	}
}