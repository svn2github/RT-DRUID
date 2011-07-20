/*
 * Created on 17-giu-2004
 */
package com.eu.evidence.rtdruid.ant.jscan;


import java.util.Properties;

import org.apache.tools.ant.BuildException;

import com.eu.evidence.rtdruid.ant.common.AntMessages;
import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.jscan.JScan;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * An ANT TASK to perform a sufficient analysis with offset
 * 
 * @author Nicola Serreli
 */
public class Sufficient extends JScanTask {
	protected static int EDF = 0;

	protected static int RT = 1;

	protected int F = 1;

	protected int type = RT;

	public void setF(int newF) {
		if (newF < 1) {
			throw new BuildException("F must be greater than zero");
		}
		F = newF;
	}
/*
	public void setType(String newType) {
		if ("edf".equalsIgnoreCase(newType)) {
			type = EDF;
		} else if ("rt".equalsIgnoreCase(newType)) {
			type = RT;
		} else {
			throw new BuildException("Not valid type : " + newType);
		}
	}*/

	public void execute() throws BuildException {
		Messages.setCurrent(new AntMessages(this));
		try {
			IVarTree vt = loadFiles();

			String[] system = (vt.newTreeInterface()).getAllName(null, null);
			if (system.length == 0) {
				throw new BuildException(
						"Nothing to do: there isn't any System!");
			}

			for (int i = 0; i < system.length; i++) {
				try {

	        		check(vt, system[i]);

	    			Properties options = new Properties();
	    			{
	    				options.setProperty(JScan.MODE_STR, mode == null ? "" : mode);
	    				options.setProperty(JScan.PRIORITIES_STR, "" + priorities);
	    				options.setProperty(JScan.F_STR, "" + F);
	    			}

	    			String report = null;
	    			
//					if (type == EDF) {
//		    			report = JScan.startTest(vt, system[i], JScan.FLEASIBLE_EDF_ID, options);
//					} else {
		    			report = JScan.startTest(vt, system[i], JScan.FLEASIBLE_RT_ID, options);
//					}

					log(report);
				} catch (RuntimeException e) {
					//e.printStackTrace();
					throw new BuildException(e.getMessage());
				}
			}

			saveFile(vt);
		} finally {
			Messages.setPrevious();
		}
	}

}