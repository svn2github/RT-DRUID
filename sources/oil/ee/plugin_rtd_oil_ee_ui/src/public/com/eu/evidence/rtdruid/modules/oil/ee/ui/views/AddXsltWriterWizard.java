/*
 * Created on Jul 14, 2004
 *
 * $Id: ExportXtcWizard.java,v 1.4 2007/11/26 13:32:18 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.ee.ui.views;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import com.eu.evidence.rtdruid.desk.RtdruidLog;

/**
 * @author Nicola Serreli
 */
public class AddXsltWriterWizard extends Wizard {

	protected AddXsltWriterPage inPage;
	
	
	private boolean result;

	public AddXsltWriterWizard() {
		super();

		setWindowTitle("Define a new Xslt writer");
		// setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(DataEditorPlugin.INSTANCE.getImage("full/wizban/NewData")));
		// setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(DataEditorPlugin.INSTANCE.getImage("full/wizban/analysis2")));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.IWizard#addPages()
	 */
	public void addPages() {
		{
			inPage = new AddXsltWriterPage("EXPORT_ID");
			inPage.setTitle("Select xslt writer ID");
			inPage.setDescription("Choose an ID for the new xslt code generator");
			addPage(inPage);
		}
	}

	/**
	 * Start analysis
	 */
	public boolean performFinish() {

		// Do the work within an operation because this is a long running
		// activity that modifies the workbench.
		//
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			public void execute(IProgressMonitor monitor) {
				monitor.beginTask("Updating code generators repository", IProgressMonitor.UNKNOWN);
				try {
					result = inPage.run();
				} catch (Throwable e) {
					RtdruidLog.log(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			new ProgressMonitorDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell()).run(true, true, operation);
		} catch (InvocationTargetException e) {
			RtdruidLog.log(e);
		} catch (InterruptedException e) {
			RtdruidLog.log(e);
		}

		return result;
	}
}
