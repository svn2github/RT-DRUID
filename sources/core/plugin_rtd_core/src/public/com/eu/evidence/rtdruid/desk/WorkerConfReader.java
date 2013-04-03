/*
 * Created on 8-giu-2004
 *
 * $Id: WorkerOilConfWriter.java,v 1.6 2008/01/25 15:58:04 durin Exp $
 */
package com.eu.evidence.rtdruid.desk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.eu.evidence.rtdruid.io.IVTResource;
import com.eu.evidence.rtdruid.io.MultiSourceImporterFactory;
import com.eu.evidence.rtdruid.io.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;

/**
 * An Class that loads one or more configuration files.
 * 
 * @author Nicola Serreli
 * 
 */
public class WorkerConfReader {
	
	public static class VtReaderException extends Exception {
		
	    /**
		 * 
		 */
		private static final long serialVersionUID = -5469289117119670250L;

	    public VtReaderException() {
	    	super();
	    }

	    public VtReaderException(String message) {
	    	super(message);
	    }

	    public VtReaderException(String message, Throwable cause) {
	        super(message, cause);
	    }

	    public VtReaderException(Throwable cause) {
	        super(cause);
	    }

	}
	

	/** The input file (oil) */
	protected ArrayList<String> inputFiles;

	protected Logger logger;
	
	private IModelValidator validator = null;
	private boolean failOnValidatorError = false;

	public WorkerConfReader(Logger logger) {
		this.logger = logger;
		this.inputFiles = new ArrayList<String>();
	}

	/**
	 * Specifies the input file (if there was already specified one or more
	 * input file, only this one is considered)
	 * 
	 * @param fileName
	 *            contains the name of Oil file
	 */
	public void setInputfile(String fileName) {
		inputFiles.clear();
		if (fileName != null) {
			inputFiles.add(fileName);
		}
	}
	
	/**
	 * @param validator the validator to set
	 */
	public void setValidator(IModelValidator validator) {
		this.validator = validator;
	}
	
	/**
	 * @return the validator
	 */
	public IModelValidator getValidator() {
		return validator;
	}
	
	/**
	 * @param failOnValidatorError the failOnValidatorError to set
	 */
	public void setFailOnValidatorError(boolean failOnValidatorError) {
		this.failOnValidatorError = failOnValidatorError;
	}
	
	/**
	 * @return the failOnValidatorError
	 */
	public boolean isFailOnValidatorError() {
		return failOnValidatorError;
	}
	
	/**
	 * Add the specified file in the input list
	 * 
	 * @param fileName
	 *            contains the name of Oil file
	 */
	public void addInputfile(String fileName) {
		if (fileName != null && !inputFiles.contains(fileName)) {
			inputFiles.add(fileName);
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
	 * @throws VtReaderException
	 */
	public IVarTree load() throws VtReaderException {
		if (validator != null && inputFiles.size() == 1) {
			try {
				if (!validator.validate(new FileInputStream(inputFiles.get(0)))) {
					logger.log(validator.getReport());
					if (failOnValidatorError) {
						throw new VtReaderException("Input file validation fail. (" + inputFiles.get(0) + ")" );
					}
				}
			} catch (IOException e) {
				throw new VtReaderException(e);
			}
		}
		
		
		IVarTree vt = VarTreeUtil.newVarTree();

		try {

			// prepare
			ArrayList<MultiSourceImporterFactory.LoadHelper> helpers = new ArrayList<MultiSourceImporterFactory.LoadHelper>();
			ArrayList<String> simpleLoad = new ArrayList<String>();
			for (String inputFile : inputFiles) {

				InputStream input;
				try {
					input = new FileInputStream(inputFile);
				} catch (FileNotFoundException e) {
					throw new VtReaderException(e.getMessage());
				}

				boolean found = false;
				// check already existing helpers
				for (MultiSourceImporterFactory.LoadHelper helper : helpers) {
					if (helper.add(inputFile, input)) {
						found = true;
						break;
					}
				}

				if (!found) {
					// check a new helper
					MultiSourceImporterFactory.LoadHelper helper = new MultiSourceImporterFactory.LoadHelper();
					if (helper.add(inputFile, input)) {
						found = true;
						helpers.add(helper);
					}
				}

				if (!found) {
					// ok. it should be handled as single file
					simpleLoad.add(inputFile);
				}
			}

			// load
			for (MultiSourceImporterFactory.LoadHelper helper : helpers) {

				for (String s: helper.getNames()) {
					s = formatFileName(s);
					myLog("LOAD", s);
				}
				
				try {
					EObject root = helper.load();
					mergeInput(vt, root);
				} catch (Exception e) {
					throw new VtReaderException(e.getMessage());
				}

			}
			
			// load
			for (String inputFile : simpleLoad) {
				inputFile = formatFileName(inputFile);
				myLog("LOAD", inputFile);
				// load and parse the input file
				IVTResource res = (IVTResource) new RTD_XMI_Factory()
						.createResource(URI.createFileURI(inputFile));
				try {
					res.load(new FileInputStream(inputFile), null);
					mergeInput(vt, res);
				} catch (Exception e) {
					throw new VtReaderException("Unable to load \""
							+ inputFile + "\" caused by :" + e.getMessage(), e);
				}
			}

		} catch (RuntimeException e) {
			// e.printStackTrace();
			throw new VtReaderException(e.getMessage());
		}

		return vt;
	}

	protected void mergeInput(IVarTree vt, IVTResource res) {
		EList<EObject> objList = res.getContents();
		if (objList.size() > 0) {
			IVarTree vtt = VarTreeUtil.newVarTree();
			vtt.setRoot(res);
//			
//			System.out.println("\t------------OI1L------------\n\n");
//			System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.writeString(vtt, "ertd")));
//			System.out.println("\t------------FINE OI1L------------\n\n");

			
			mergeInput(vt, objList.get(0));
		}
	}
	
	protected void mergeInput(IVarTree vt, EObject root) {
		// get the old root
		EList<Resource> resList = vt.getResourceSet().getResources();
		if (resList.size() == 0) {
			resList.add((new RTD_XMI_Factory()).createResource());
		}
		EList<EObject> objList = resList.get(0).getContents();
		if (objList.size() == 0) {
			// set the new root
			objList.add(root);
		} else {
			// merge old and new root
			VarTreeUtil.merge((objList.get(0)), root, null, false);
		}
//		System.out.println("\t------------ERTD------------\n\n");
//		System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.writeString(vt, "ertd")));
//		System.out.println("\t------------FINE ERTD------------\n\n");
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
				+ ("                 ".substring(
						0,
						(left.length() > LEFT_SIZE - 1 ? 1 : LEFT_SIZE
								- left.length()))) + right + "]");
	}

	public static String formatFileName(String name) {
		IPath f = new Path(name);
		return f.toOSString();
	}
}