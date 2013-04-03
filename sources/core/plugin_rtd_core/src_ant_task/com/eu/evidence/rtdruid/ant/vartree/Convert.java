/*
 * Created on 8-giu-2004
 *
 * $Id: Convert.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.ant.vartree;


import java.io.IOException;
import java.util.Iterator;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.types.FileList;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.types.resources.FileResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import com.eu.evidence.rtdruid.ant.common.AntMessages;
import com.eu.evidence.rtdruid.desk.Logger;
import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.desk.WorkerConfReader;
import com.eu.evidence.rtdruid.desk.WorkerConfReader.VtReaderException;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * @author Nicola Serreli
 *
 *
 */
public class Convert extends Task {
	
	protected WorkerConfReader worker = new WorkerConfReader(new Logger() {
		
		public void log(String txt) {
			Convert.this.log(txt);
		}
	});

	protected String store = null;
	
	
	public void addConfigured(FileList files) {
		String dir = files.getDir(getProject()).getPath();
		if (dir == null) {
			dir = "";
		} else if (!dir.endsWith(System.getProperty("file.separator"))) {
			dir += System.getProperty("file.separator");
		}
		
		String[] elFiles = files.getFiles(getProject());
		for(int i=0; i<elFiles.length; i++) {
			worker.addInputfile(dir + elFiles[i]);
		}
	}
	
	public void addConfigured(FileSet fileSet) {
		for (Iterator iter= fileSet.iterator(); iter.hasNext(); ) {
			Object o = iter.next();
			if (o instanceof FileResource) {
				FileResource fres = (FileResource) o;
				worker.addInputfile(fres.getFile().getAbsolutePath());
		}
		}
	}
	
	public void setStore(String fileName) {
		store = fileName;
	}
	
	protected IVarTree loadFiles() throws VtReaderException {
		return worker.load();
	}

	protected void saveFile(IVarTree vt) {
        if (store == null) {
        	return;
        }

    	myLog("Storing", store);
        try {
	        Resource res = (Resource) vt.getResourceSet().getResources().get(0);
	        res.setURI(URI.createFileURI(store));
	        
        	res.save(null);
        } catch (IOException e) {
        	throw new BuildException(e.getMessage());
        } catch (RuntimeException e) {
        	throw new BuildException(e.getMessage());
        }
	}

	
	public void execute() throws BuildException {
		
		Messages.setCurrent(new AntMessages(this));
		try {
			saveFile(loadFiles());
        } catch (VtReaderException e) {
        	throw new BuildException(e.getMessage());
		} finally {
			Messages.setPrevious();
		}
	}
	
	protected void myLog(String left, String right) {
		final int LEFT_SIZE = 10;
		
		if (Messages.LogLevel.info.enabled())
			log("[" + left 
					+ ("                 ".substring(0,
							(left.length()> LEFT_SIZE-1 ? 1 : LEFT_SIZE-left.length()))
					) + right + "]");	
	}
}