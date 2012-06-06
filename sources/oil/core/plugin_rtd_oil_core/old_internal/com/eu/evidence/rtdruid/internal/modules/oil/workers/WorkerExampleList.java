/*
 * Created on 5-gen-2005
 *
 * $Id: WorkerExampleWriter.java,v 1.4 2007/05/11 16:09:42 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.workers;

import java.util.HashMap;

import com.eu.evidence.rtdruid.desk.Logger;
import com.eu.evidence.rtdruid.internal.modules.project.templates.ExampleTemplate;
import com.eu.evidence.rtdruid.internal.modules.project.templates.SearchTemplates;

/**
 * An Ant Task that write an example inside a directory.
 * 
 * @author Nicola Serreli
 *  
 */
public class WorkerExampleList implements IWorkerExampleWriter {
	
	protected Logger logger;
	
	public WorkerExampleList(Logger logger) {
		this.logger = logger;
	}
	
	@Override
	public void setOptions(HashMap<String, ? extends Object> opt) {
		// do nothing	
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.internal.modules.oil.workers.IWorkerExampleWriter#setOutputDirectory(java.lang.String)
	 */
	@Override
	public void setOutputDirectory(String value) {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.internal.modules.oil.workers.IWorkerExampleWriter#execute()
	 */
	@Override
	public void execute() throws OilWorkerException {
		ExampleTemplate[] templates = SearchTemplates.getConfigTemplates();

		// search all templates
		final String wsp = "    ";
		for (int i=0; i<templates.length; i++) {
			ExampleTemplate ex = templates[i];
			
			String buff = ""+i+") "
					+       "Title = " + ex.getTitle()+"\n"
					+ wsp + "Cat.  = " + ex.getCategory() + "\n"
					+ wsp + "ID    = " + ex.getExampleID() + "\n"
					+ wsp + "Path  = " + ex.getFs_path() + "\n"
					+ wsp + "Descr.= " + ex.getShortDescr();
			myLog("", buff);
		}
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