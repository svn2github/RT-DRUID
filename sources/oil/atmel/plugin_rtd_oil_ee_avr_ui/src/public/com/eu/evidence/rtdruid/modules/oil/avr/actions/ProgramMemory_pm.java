/*
 * Created on 16/lug/07
 *
 * $Id: ProgramMemory_pm.java,v 1.1 2007/07/20 06:57:06 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.avr.actions;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.desk.RtdruidLog;

public class ProgramMemory_pm implements IObjectActionDelegate {

	/** Remembers the previous selection */
	protected static IResource element;

	/** Remembers the previous choosed file */
	protected static IFile previous = null;
	
	/** The shell */
	private Shell shell;

	/**
	 * The constructor.
	 */
	public ProgramMemory_pm() {
	}

	/**
	 * The action has been activated. The argument of the method represents the
	 * 'real' action sitting in the workbench UI.
	 * 
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {

		try {
			IRunnableWithProgress op = new CommonActions.ProgrFlashAct() {

				void getBinImage() {
					// searc the binary image

					if (element instanceof IProject) {
						IFile[] files = CommonActions.searchSRec((IProject) element, intMonitor);
						if (intMonitor.isCanceled()) {
							return;  // ---> EXIT
						}

						if (files.length == 0) {
							// no file found

							// Show an error message
							try {

								final Display display = shell.getDisplay();
								display.syncExec(new Runnable() {
									public void run() {
										MessageDialog.openError(shell,
												"Avr5 Memory Programmer",
												"No *.srec file found in " + element.getName());
									}
								});
							} catch (Throwable e) {
								RtdruidLog.log(e);
							}
							
							Messages.sendErrorNl("No *.srec file found in " + element.getName(),
									null, null, null);

							abort = true;
							return; // ---> EXIT

						} else if (files.length > 1) {
							// too many files
							binImg = CommonActions.askBinImage(shell, files, previous);

							if (binImg == null) {
								abort = true;
								return; // ---> EXIT
							}

						} else {
							binImg = files[0];
						}

					} else if (element instanceof IFile) {
						binImg = (IFile) element;
					}
					
					previous = binImg;
				}

			};
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
		element = null;
		if (!selection.isEmpty() && selection instanceof IStructuredSelection) {
			Object o = ((IStructuredSelection) selection).getFirstElement();
			if (o instanceof IResource) {
				element = (IResource) o;
			}
		}
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

}
