/*
 * Created on 17-giu-2004
 *
 * $Id: Assignment.java,v 1.1 2007/05/10 07:55:48 durin Exp $
 */
package com.eu.evidence.rtdruid.ant.jscan;

//import java.util.Properties;

import org.apache.tools.ant.BuildException;
/*
import rtdruid.desk.AntMessages;
import rtdruid.desk.Messages;
import rtdruid.modules.evidence.CheckReferences;
import com.eu.evidence.rtdruid.internal.modules.jscan.JScan;
import rtdruid.vartree.VarTree;

/**
 * @author NicolaSerreli
 */
public class Assignment extends JScanTask {
	
	public void execute() throws BuildException {
		// disabled
/*		
		
		Messages.setCurrent(new AntMessages(this));
		try {
			VarTree vt = loadFiles();
	        
	        String[] system = (vt.newTreeInterface()).getAllName(null, null);
	        if (system.length == 0) {
	        	throw new BuildException("Nothing to do: there isn't any System!");
	        }
	        
	        for (int i=0; i<system.length; i++) {
	        	try {
	    			(new CheckReferences(vt, system[i])).checkAll();
	    			if (Messages.getErrorNumber() > 0) {
	    			    return;
	    			}
	    			
	    			Properties options = new Properties();
	    			{
	    				options.setProperty(JScan.MODE_STR, mode == null ? "" : mode);
	    				options.setProperty(JScan.PRIORITIES_STR, "" + priorities);
	    			}

	    			String report = JScan.startTest(vt, system[i], JScan.ASSIGNMENT_ID, options);
	    			
		        	log(report);
		        } catch (RuntimeException e) {
		        	throw new BuildException(e.getMessage());
		        }
	        }
	        
	        saveFile(vt);
		} finally {
			Messages.setPrevious();
		}
*/		
	}

}
