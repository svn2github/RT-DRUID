/*
 * Created on 16/lug/07
 *
 * $Id: ProgramMemory.java,v 1.2 2007/07/20 07:02:08 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.avr.actions;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.desk.RtdruidLog;

public class ProgramMemory implements IWorkbenchWindowActionDelegate {

	/** Remembers the previous choosed file */
	protected static IFile previous = null;

	private IWorkbenchWindow window;

	/**
	 * The constructor.
	 */
	public ProgramMemory() {
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
					IWorkspaceRoot root = ResourcesPlugin.getWorkspace()
							.getRoot();

					IFile[] files = CommonActions.searchSRec(root,
							intMonitor);
					
					if (intMonitor.isCanceled()) {
						return; // ---> EXIT
					}
					if (files.length == 0) {
						// no file found

						// Show an error message
						try {

							final Display display = window.getShell()
									.getDisplay();
							display.syncExec(new Runnable() {
								public void run() {
									MessageDialog
											.openError(window.getShell(),
													"Avr5 Memory Programmer",
													"No *.srec file found in the workspace");
								}
							});
						} catch (Throwable e) {
							RtdruidLog.log(e);
						}

						Messages.sendErrorNl(
								"No *.srec file found in the workspace", null,
								null, null);

						abort = true;
						return; // ---> EXIT

					} else { // if (files.length > 1) { ALWAYS ASK
						// too many files
						
						binImg = CommonActions.askBinImage(window.getShell(),
								files, previous);

						if (binImg == null) {
							abort = true;
							return; // ---> EXIT
						}

					}

				}

			};
			new ProgressMonitorDialog(window.getShell()).run(true, true, op);
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
	}

	/**
	 * We can use this method to dispose of any system resources we previously
	 * allocated.
	 * 
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}

	/**
	 * We will cache window object in order to be able to provide parent shell
	 * for the message dialog.
	 * 
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}
