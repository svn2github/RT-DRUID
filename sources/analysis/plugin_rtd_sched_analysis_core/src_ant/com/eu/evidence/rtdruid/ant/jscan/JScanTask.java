/*
 * Created on 8-giu-2004
 *
 */
package com.eu.evidence.rtdruid.ant.jscan;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.FileList;
import org.apache.tools.ant.types.FileSet;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.eu.evidence.rtdruid.ant.common.Util;
import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.jscan.JScan;
import com.eu.evidence.rtdruid.io.IVTResource;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.tools.CheckReferences;

/**
 * @author Nicola Serreli
 *
 *
 */
public class JScanTask extends Task {
	
	protected ArrayList allFiles = new ArrayList();
	protected String store = null;
//	protected boolean verbose = false;
//	protected String testType = "auto";
	protected String mode = null;
	protected int priorities = JScan.USER_PRIORITIES;
	protected boolean stopOnWarning = true;
	
	
	public JScanTask() {
	}
	
	public void addConfigured(FileList files) {
		String dir = files.getDir(getProject()).getPath();
		if (dir == null) {
			dir = "";
		} else if (!dir.endsWith(System.getProperty("file.separator"))) {
			dir += System.getProperty("file.separator");
		}
		
		String[] elFiles = files.getFiles(getProject());
		for(int i=0; i<elFiles.length; i++) {
			allFiles.add(dir + elFiles[i]);
		}
	}
	
	public void addConfigured(FileSet files) {
	    String dir = files.getDir(getProject()).getPath();
		if (dir == null) {
			dir = "";
		} else if (!dir.endsWith(System.getProperty("file.separator"))) {
			dir += System.getProperty("file.separator");
		}

		String[] elFiles = files.getDirectoryScanner(getProject()).getIncludedFiles();
		for(int i=0; i<elFiles.length; i++) {
			allFiles.add(dir + elFiles[i]);
//        	myLog("FILE SET ", elFiles[i]);
		}
	}
	
	public void setStore(String fileName) {
		store = fileName;
	}
	
	public void setMode(String value) {
		mode = value;
	}

	public void setPriorities(String value) {
		if ("user".equalsIgnoreCase(value) ) {
			priorities = JScan.USER_PRIORITIES;
		} else if ("byDeadline".equalsIgnoreCase(value) ) {
			priorities = JScan.PRIORITIES_BY_DEADLINE;
		} else if ("byPeriod".equalsIgnoreCase(value) ) {
			priorities = JScan.PRIORITIES_BY_PERIOD;
		} else {
			throw new BuildException("Try to set an Unsupported priority type : " + value);
		}
	}

	protected IVarTree loadFiles() {
        if (allFiles.size() == 0) {
        	throw new BuildException("At least one input file is required");
        }
        
        IVarTree vt = VarTreeUtil.newVarTree();
        
        // load files
        EObject[] roots = new EObject[allFiles.size()];
        for (int i=0; i<allFiles.size(); i++) {
        	String fname = (String) allFiles.get(i);
        	//fname = fname.replace('\\', '/');
        	myLog("Loading", fname);
        	IVTResource res = null;
            try {
            	res = Util.loadData(fname);
            } catch (RuntimeException e) {
            	throw new BuildException(e.getMessage());
            }
	        if (res.getContents().size() == 0) {
	        	throw new BuildException(fname + " doesn't have data");
	        }
	        roots[i] = res.getContents().get(0);
        }
        
/*		if (Messages.getErrorNumber() > 0
				|| (Messages.getWarningNumber() > 0 && stopOnWarning)) {
			
//			throw new BuildException("Some problems with input files");
		}
*/
        Messages.clearNumbers();

        // merge loaded files (throw exceptions if they aren't compatible,
        // like different System name) 
        EObject root = VarTreeUtil.copy(roots[0]);
        { // store all in VarTree (to enable merge is required that a resource contains the "root" object)
	        vt.setRoot(root);
        }
        for (int i=1; i<roots.length; i++) {
        	myLog("Merging",(String) allFiles.get(i));
        	try {
        		VarTreeUtil.merge(root, roots[i]);
        	} catch (RuntimeException e) {
        		throw new BuildException(e.getMessage());
        	}
        }
        
        
        return vt;
	}

	protected void saveFile(IVarTree vt) {
        if (store == null) {
        	return;
        }

    	myLog("Storing", store);
        try {
	        Resource res = (Resource) vt.getResourceSet().getResources().get(0);
	        res.setURI(URI.createFileURI(store));
	        
        	res.save(new HashMap());
        } catch (IOException e) {
        	throw new BuildException(e.getMessage());
        } catch (RuntimeException e) {
        	throw new BuildException(e.getMessage());
        }
	}

	
	public void execute() throws BuildException {
		throw new UnsupportedOperationException();
	}
	
	protected void myLog(String left, String right) {
		final int LEFT_SIZE = 10;
		
		log("[" + left 
				+ ("                 ".substring(0,
						(left.length()> LEFT_SIZE-1 ? 1 : LEFT_SIZE-left.length()))
				) + right + "]");	
	}
	
	protected void check(IVarTree vt, String system) {
		Messages.clearNumbers();
		(new CheckReferences(vt, system)).checkAll();
		if (Messages.getErrorNumber() > 0
				|| (Messages.getWarningNumber() > 0 && stopOnWarning)) {
			
			throw new BuildException("Some wrong references");
		}
		Messages.clearNumbers();

	}
}