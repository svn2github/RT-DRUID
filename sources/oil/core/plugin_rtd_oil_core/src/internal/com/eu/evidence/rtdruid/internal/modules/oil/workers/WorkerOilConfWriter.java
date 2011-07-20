/*
 * Created on 8-giu-2004
 *
 * $Id: WorkerOilConfWriter.java,v 1.6 2008/01/25 15:58:04 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.workers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.desk.RTDFactory;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.RtosFactory;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.data.init.IVTResource;
import com.eu.evidence.rtdruid.vartree.data.init.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.vartree.tools.Search;

/**
 * An Ant Task that perform Code Configuration of a system described by an Oil
 * File.
 * 
 * @author Nicola Serreli
 *  
 */
public class WorkerOilConfWriter {

	/** The default left part of an output. See {@link #myLog myLog}. */
	private final static String LEFT = "OIL WRITER";

	/** The input file (oil) */
	protected String inputFile = null;

	/** The directory where store all outputs */
	protected String outputDir = null;

	/** One or more options for Code Generator */
	protected HashMap<String, Object> options = new HashMap<String, Object>();

	/** The default separator for current OS */
	static final String dirSep = System.getProperty("file.separator");
	
	protected Logger logger;
	
	public WorkerOilConfWriter(Logger logger) {
		this.logger = logger;
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
	 * Specifies the input oil file
	 * 
	 * @param fileName
	 *            contains the name of Oil file
	 */
	public void setInputfile(String fileName) {
		inputFile = fileName;
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
	 * Returns the logger
	 */
	public Logger getLogger() {
		return logger;
	}
	
	/**
	 * This method loads the specified oil file.
	 * 
	 * @return the VarTree that contains the loaded file.
	 * 
	 * @throws OilWorkerException
	 */
	protected IVarTree load() throws OilWorkerException {
		IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);

		myLog("LOAD", inputFile);
		try {
			// load and parse the input file
			IVTResource res = (IVTResource) new RTD_XMI_Factory().createResource(URI.createFileURI(inputFile));
			try {
				res.load(new FileInputStream(inputFile), new HashMap());
			} catch (Exception e) {
				
				RtdruidLog.log("Unable to load \"" + inputFile + "\".");
				RtdruidLog.log(e);
				Messages.sendErrorNl("Unable to load \"" + inputFile
						+ "\" caused by :", "", "ASDASDAS", null);
				Messages.sendErrorNl(e.getMessage(), "", "ASDASDAS", null);
				return null;
			}
			vt.setRoot(res);
		} catch (RuntimeException e) {
			//e.printStackTrace();
			throw new OilWorkerException(e.getMessage());
		}

		return vt;
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
				myLog("WRITE", outputDir + filePath + fileName);
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
		if (inputFile == null) {
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
		}

		// --------------- Load data ------------------

		final IVarTree vt = load();
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
			buffers = RtosFactory.INSTANCE.write(vt, (String[]) rtosPath
					.toArray(new String[rtosPath.size()]), options);
		} catch (OilCodeWriterException e) {
			RtdruidLog.showDebug(e);
			throw new OilWorkerException(e.getMessage());
		}
		myLog("      ", "Start to save");

		// ---------------- Store files -------------------
		save(buffers);
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