/*
 * Created on 16/lug/07
 *
 * $Id: JTagEnable_pm.java,v 1.1 2007/07/20 06:57:06 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.avr.actions;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class JTagEnable_pm implements IObjectActionDelegate {

	private Shell shell;

	/**
	 * The constructor.
	 */
	public JTagEnable_pm() {
	}

	/**
	 * The action has been activated. The argument of the method represents the
	 * 'real' action sitting in the workbench UI.
	 * 
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {

		try {
			IRunnableWithProgress op = new CommonActions.JTagEnableAct();
			new ProgressMonitorDialog(shell).run(true, false, op);
		} catch (InvocationTargetException e) {
			// handle exception
		} catch (InterruptedException e) {
			// handle cancelation
		}
	}

	/**
	 * Selection in the workbench has been changed. We can change the state of
	 * the 'real' action here if we want, but this can only happen after the
	 * delegate has been created.
	 * 
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		// do nothing
	}
	
	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}
}