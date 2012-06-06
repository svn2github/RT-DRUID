/*
 * Created on 13/set/07
 *
 * $Id: Common.java,v 1.2 2007/10/03 13:10:55 durin Exp $
 */
package com.eu.evidence.rtdruid.ui.common;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.ResourceUtil;

import com.eu.evidence.rtdruid.io.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreeProvider;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;

public class Common {

	public static Button createButton(Composite parent, String label) {
		Button button = new Button(parent, SWT.PUSH);
		button.setText(label);
		button.setFont(JFaceResources.getDialogFont());

		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);

		if (true) {
			GC gc = new GC(parent);
			gc.setFont(JFaceResources.getDialogFont());
			FontMetrics fontMetrics = gc.getFontMetrics();
			gc.dispose();

			// data.heightHint = Dialog.convertVerticalDLUsToPixels(fontMetrics,
			// IDialogConstants.BUTTON_HEIGHT);
			int widthHint = Dialog.convertHorizontalDLUsToPixels(fontMetrics,
					IDialogConstants.BUTTON_WIDTH);
			data.widthHint = Math.max(widthHint, button.computeSize(
					SWT.DEFAULT, SWT.DEFAULT, true).x);
		} else {
			// data.heightHint = IDialogConstants.BUTTON_HEIGHT;
			int widthHint = IDialogConstants.BUTTON_WIDTH;
			data.widthHint = Math.max(widthHint, button.computeSize(
					SWT.DEFAULT, SWT.DEFAULT, true).x);

		}
		button.setLayoutData(data);
		return button;

	}

	/**
	 * This class contains the result of getVtWS function: the VarTree and the
	 * current Editor that is used to modify it (or null if the file is not
	 * open)
	 */
	public static class VT_WS {
		/** The tree */
		public IVarTree vt = null;
		/** The editor open on this tree (or null if none)*/
		public IEditorPart editor = null;
	}

	/**
	 * This method searches the specified file in the current workspace. If the
	 * file is already open, returns that tree.
	 * 
	 * IMPORTANT: this method doesn't check if the path is valid and if it
	 * identifies a file.
	 */
	public static VT_WS getVtWS(String workspacePath) {

		VT_WS answer = new VT_WS();
		
		IFile f = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(workspacePath));

		{ // load the input data

			IWorkbench wb = PlatformUI.getWorkbench();
			IWorkbenchWindow wbw = (wb == null ? null : wb
					.getActiveWorkbenchWindow());
			IWorkbenchPage wbp = (wbw == null ? null : wbw.getActivePage());
			IEditorPart ep = (wbp == null ? null : ResourceUtil.findEditor(wbp,f));

			if (ep != null && ep instanceof IVarTreeProvider) {
				answer.vt = ((IVarTreeProvider) ep).getVarTree();
				answer.editor = ep ;
			} else {
				URI fileURI = URI.createPlatformResourceURI(workspacePath);
				answer.vt = VarTreeUtil.newVarTree();
				Resource res = new RTD_XMI_Factory()
						.createResource(fileURI);
				try {
					res.load(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
				answer.vt.setRoot(res);
			}
		}

		//System.out.println(Utility.varTreeToString(answer.vt));

		return answer;
	}
}
