/*
 * Created on Jul 12, 2005
 *
 * $Id: OneResourceSelectionDialog.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.ui.common;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * TODO Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public class MultipleResourceSelectionDialog {

	protected ElementTreeSelectionDialog dialog;

	/**
	 * Constructs an instance of <code>OneResourceSelectionDialog</code>.
	 * 
	 * @param parent
	 *            The parent shell for the dialog
	 * @param labelProvider
	 *            the label provider to render the entries
	 * @param contentProvider
	 *            the content provider to evaluate the tree structure
	 */
	public MultipleResourceSelectionDialog(Shell shell, String title,
			String message, IContainer root, ISelectionStatusValidator validator) {

		WorkbenchLabelProvider labelProvider = new WorkbenchLabelProvider();
		WorkbenchContentProvider contentProvider = new WorkbenchContentProvider();

		dialog = new ElementTreeSelectionDialog(shell, labelProvider,
				contentProvider);
		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.setBlockOnOpen(true);
		dialog.setAllowMultiple(true);
		dialog.setInput(root);
		dialog.setValidator(validator);
	}

	public ElementTreeSelectionDialog getDialog() {
		return dialog;
	}
	
	// -----------------------

	public static ISelectionStatusValidator getStandardValidator(
			String pluginID, String[] validSuffix) {

		return new StandardStatusValidator(pluginID, validSuffix);
	}

	/**
	 * A StatusValidator that accept some suffix
	 */
	protected static class StandardStatusValidator implements
			ISelectionStatusValidator {
		protected String SELECT_A_FILE = "Selection must be a file";
		protected String SELECT_ERROR = SELECT_A_FILE;
		protected String SUFFIX_ERROR = "";

		/** Plugin identifier that will be used for */
		protected String pluginID;

		protected String[] validSuffix;

		/**
		 * Create a new StandardValidator with specified plugin, validSuffix and
		 * project
		 * 
		 * @param pluginID
		 *            identifies the plugin and it's used for Validate method
		 * @param validSuffix
		 *            contains all suffix of valid files (without dot)
		 */
		public StandardStatusValidator(String pluginID, String[] validSuffix) {
			if (pluginID == null) {
				throw new NullPointerException("pluginID cannot be null");
			}
			this.pluginID = pluginID;
			this.validSuffix = validSuffix == null ? new String[0]
					: validSuffix;

			// prepare the SUFFIX_ERROR String
			StringBuffer tmp = new StringBuffer(
					"The extention of selected file must be "
							+ (this.validSuffix.length > 1 ? "one of " : ""));
			for (int i = 0; i < this.validSuffix.length; i++) {
				tmp.append((i > 0 ? ", " : "") + this.validSuffix[i]);
			}
			SUFFIX_ERROR = tmp.toString();
		}

		/**
		 * Validates an array of elements and returns the resulting status.
		 * 
		 * @param selection
		 *            The elements to validate
		 * @return The resulting status
		 */
		public IStatus validate(Object[] selection) {
			if (selection.length == 0) {
				return new Status(IStatus.ERROR, pluginID, 1, SELECT_A_FILE,
						null);
			}
			for (Object obj: selection) {
				 if (!(obj instanceof IFile)) {
						return new Status(IStatus.ERROR, pluginID, 1, SELECT_A_FILE,
								null);
				 }
				try {
					IProject project = ((IFile) obj).getProject();
					IResource element = project.findMember(((IFile) obj)
							.getProjectRelativePath());
	
					// the file exist? it's a IResource.FILE?
					boolean ok = element != null
							&& element.getType() == IResource.FILE;
					if (!ok) {
						return new Status(IStatus.ERROR, pluginID, 1, SELECT_ERROR,
								null);
					}
	
					// check all suffix
					ok = validSuffix.length == 0;
					for (int i = 0; !ok && i < validSuffix.length; i++) {
						ok = validSuffix[i].equals(element.getFileExtension());
					}
					if (!ok) {
						return new Status(IStatus.ERROR, pluginID, 1, SUFFIX_ERROR,
								null);
					}
	
				} catch (Exception ex) {
					return new Status(IStatus.ERROR, pluginID, 1, SUFFIX_ERROR,
							null); //$NON-NLS-1$
				}
			}
			return new Status(IStatus.OK, pluginID, IStatus.OK, null, null);
		}

	}

}