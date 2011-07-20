/*
 * Created on Jan 27, 2005
 *
 * $Id: OilWriteAction.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.ui.editor.text;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import com.eu.evidence.rtdruid.modules.oil.ui.actions.OilWriterWizard;


/**
 *
 * TODO : Commentare && Tradurre  
 *
 * @author Nicola Serreli
 */
public class OilWriteAction extends Action {
	
	protected IEditorPart activeEditor;
	protected Shell activeShell;
	
	/***************************************************************************
	 * all constructors
	 **************************************************************************/
	
	
	
	public OilWriteAction() {
		super();
	}
	public OilWriteAction(String label) {
		super(label);
	}
	public OilWriteAction(String label, ImageDescriptor image) {
		super(label, image);
	}
	public OilWriteAction(String label, int style) {
		super(label, style);
	}
	
	
	/***************************************************************************
	 * Public methods
	 **************************************************************************/

	/* (non-Javadoc)
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		IWorkbench iw = PlatformUI.getWorkbench();
		Display disp = iw == null ? null : iw.getDisplay(); 
		activeShell = disp == null ? null : disp.getActiveShell();

		if (activeShell != null) {
			new WizardDialog(activeShell.getShell(), new OilWriterWizard(false)).open();
		}
	}
}