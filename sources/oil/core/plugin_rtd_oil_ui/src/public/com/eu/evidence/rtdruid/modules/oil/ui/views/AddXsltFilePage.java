/*
 * Created on 13/set/07
 *
 * $Id: ExportXtcPage.java,v 1.5 2008/01/09 17:50:20 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.ui.views;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;

import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.XsltWriterTransfFactory;
import com.eu.evidence.rtdruid.ui.common.Common;

public class AddXsltFilePage extends WizardPage {

	SelectionListener listener = new SelectionListener() {
		public void widgetDefaultSelected(SelectionEvent e) {
			perform(e);
		}

		public void widgetSelected(SelectionEvent e) {
			perform(e);
		}

		private void perform(SelectionEvent e) {
			if (e.getSource() == browseInput) {

				// LOAD FROM RESOURCE (inside workspace)
				ResourceSelectionDialog dialog = new ResourceSelectionDialog(
						getShell(), ResourcesPlugin.getWorkspace()
								.getRoot(), "Select an existing xsl file");
				// dialog.setInitialSelections(null);
				dialog.open();
				Object[] results = dialog.getResult();
				if (results == null) {
					return;
				}
				for (int i = 0; i < results.length; i++) {
					if (results[i] instanceof IFile) {
						String ext = ((IFile) results[i])
								.getFullPath().getFileExtension();
						if ("xsl".equalsIgnoreCase(ext)
								|| "xslt".equalsIgnoreCase(ext)) {
							txtInput.setText(((IFile) results[i])
									.getFullPath().toOSString());
							txtInput.setData(results[i]);
						}
					}
				}

				// clear cache and check values
				enableOk();
				return;

			} else if (e.getSource() == browseXtc) {
				
				// LOAD FROM RESOURCE (inside workspace)
				FileDialog dialog = new FileDialog(
						getShell(), SWT.OPEN);
				dialog.setText("Select an existing xsl file");
				dialog.setFilterNames(new String[] {"xsl", "xslt"});
				
				
				// dialog.setInitialSelections(null);
				dialog.open();
				String results = dialog.getFilterPath() + File.separatorChar + dialog.getFileName();
				if (results == null) {
					return;
				}
//				for (int i = 0; i < results.length; i++) {
//					if (results[i] instanceof IFile) {
//						String ext = ((IFile) results[i])
//								.getFullPath().getFileExtension();
//						if ("xtc".equalsIgnoreCase(ext)) {
//							txtXtc.setText(((IFile) results[i])
//									.getFullPath().toOSString());
//							txtXtc.setData(results[i]);
//							break;
//						}
//					}
//				}
				File f = new File(results);
				txtInput.setText(results);
				txtInput.setData(f);
				
				// check values
				enableOk();
				return;

			}
		}
	};
	
	/** Used in "checkOK" method */
	private final IPath stubPath = new Path("");

	protected Button browseXtc;
	protected Button browseInput;

	protected Text txtId;
	protected static String strId;

	protected Text txtInput;
	protected static String strInput;

	protected static File inputFile;
	
	/**
	 * Make a new Page
	 */
	public AddXsltFilePage(String pageId) {
		super(pageId);
	}

	/**
	 * Create all widgets
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		{
			GridLayout layout = new GridLayout(2, false);
			layout.marginHeight = 10;
			layout.marginWidth = 10;
			composite.setLayout(layout);
		}

		// ---- INPUT FILE (RTD / OIL ) ----

		{
			Label containerLabel = new Label(composite, SWT.LEFT);
			containerLabel.setText("Xslt ID");
			containerLabel.setLayoutData(new GridData());
		}
		{
			txtId= new Text(composite, SWT.BORDER);
			txtId.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
					| GridData.GRAB_HORIZONTAL));
			txtId.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					enableOk();
				}
			});
		}

		
		{
			Label containerLabel = new Label(composite, SWT.LEFT);
			containerLabel.setText("Input file");

			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.horizontalSpan = 2;
			containerLabel.setLayoutData(data);
		}

		{
			txtInput = new Text(composite, SWT.READ_ONLY | SWT.BORDER);
			GridData data = new GridData(GridData.FILL_HORIZONTAL
					| GridData.GRAB_HORIZONTAL);
			data.verticalSpan = 2;
			txtInput.setLayoutData(data);
		}

		{ // browse
			browseInput = Common.createButton(composite, "browse ws");
			browseInput.setToolTipText("Browse workspace");
			browseInput.addSelectionListener(listener);
		}

		{ // browse
			browseXtc = Common.createButton(composite, "browse fs");
			browseXtc.setToolTipText("Browse filesystem");
			browseXtc.addSelectionListener(listener);
		}

		
		super.setControl(composite);

		// before exit initialize all values
		init();
	}

	/**
	 * enable / disable the "next" button and show some "Error messages"
	 */
	protected void enableOk() {
		String errMessg = null;
		String warnMessg = null;

		setErrorMessage(null);
		setMessage(null, WARNING);
		
		if ("".equals(txtId.getText())) {
			errMessg = (errMessg == null ? "" : errMessg + "\n")
				+ "Choose a not empty ID";
		} else if (XsltWriterTransfFactory.get(txtId.getText()) != null) {
			errMessg = (errMessg == null ? "" : errMessg + "\n")
				+ "Specified ID aready exist";
		}
		
		// CHECK INPUT
		if ("".equals(txtInput.getText())) {
			errMessg = (errMessg == null ? "" : errMessg + "\n")
					+ "Choose the input resource";
		} else if (txtInput.getData() instanceof IFile) {
			
			if (!stubPath.isValidPath(txtInput.getText())) {
				errMessg = (errMessg == null ? "" : errMessg + "\n")
					+ "The input resource path is not valid";
			
			} else if (!getInputFile().isAccessible()) {
				errMessg = (errMessg == null ? "" : errMessg + "\n")
					+ "The input resource cannot be found";
			}
		} else if (txtInput.getData() instanceof File) {
			File f = (File) txtInput.getData();
			if (!f.isFile()) {
				errMessg = (errMessg == null ? "" : errMessg + "\n")
					+ "The input is not a file";
			
			} else if (!f.canRead()) {
				errMessg = (errMessg == null ? "" : errMessg + "\n")
				+ "The input cannot be read";
			}

		} 
		
		
		
		if ( errMessg != null) setErrorMessage(errMessg);
		else {
			if (warnMessg != null) setMessage(warnMessg, WARNING);
			
			strId = txtId.getText();
			strInput = txtInput.getText();
			
			if (txtInput.getData() instanceof File) {
				inputFile = (File) txtInput.getData();
			} else if (txtInput.getData() instanceof IFile) {
				inputFile = ((IFile) txtInput.getData()).getLocation().toFile();
			}
		}
		
		setPageComplete(errMessg == null && inputFile != null);
	}

	/**
	 * Initialize all values
	 */
	public void init() {
		if (strInput != null) txtInput.setText(strInput);
		if (strId != null) txtId.setText(strId);
		
		enableOk();
	}
	
	/**
	 * Return all choosen resources
	 */
	public boolean run() {
		
		XsltWriterTransfFactory.add(new XsltWriterTransfFactory.FileXsltWriterTransgormation(strId, inputFile.getAbsolutePath()));
		
		
		
		return true;
	}
	
	private IFile getInputFile() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(txtInput.getText()));
	}

}
