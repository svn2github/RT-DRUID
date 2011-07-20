/*
 * Created on 13/set/07
 *
 * $Id: ExportXtcPage.java,v 1.5 2008/01/09 17:50:20 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.ee.ui.views;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.IXsltWriterTransformation;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.XsltComponent;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.XsltWriterTransfFactory;

public class ChooseXsltStepPage extends WizardPage {

	
	protected String strId;
	protected XsltComponent parentStep;
	
	/**
	 * Make a new Page
	 */
	public ChooseXsltStepPage(String pageId) {
		super(pageId);
	}
	
	public void setParentStep(XsltComponent parentStep) {
		this.parentStep = parentStep;
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

		// ---- ID ----

		{
			Label containerLabel = new Label(composite, SWT.LEFT);
			containerLabel.setText("Select Xslt step ID");
			containerLabel.setLayoutData(new GridData());
		}

		Table t = new Table(composite, SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL);
		t.setLayoutData(gd);

		TableViewer viewer = new TableViewer(t);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				strId = null;
				ISelection sel = event.getSelection();
				if (!sel.isEmpty() && sel instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) sel).getFirstElement();
					if (o instanceof TreeItem) {
						strId = ((TreeItem)o).getText();
					} else if (o instanceof IXsltWriterTransformation) {
						strId = ((IXsltWriterTransformation) o).getId();
					}
				}
				enableOk();
			}
		});
		viewer.setContentProvider(new MasterContentProvider());
		viewer.setLabelProvider(new MasterLabelProvider());
		viewer.setInput(XsltWriterTransfFactory.getDefaultInstance());
		

		
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
		
		if (strId == null) {
			errMessg = (errMessg == null ? "" : errMessg + "\n")
				+ "Choose a xslt transformation";
		}
				
		if ( errMessg != null) setErrorMessage(errMessg);
		else {
			if (warnMessg != null) setMessage(warnMessg, WARNING);
		}
		
		setPageComplete(errMessg == null);
	}

	/**
	 * Initialize all values
	 */
	public void init() {
		enableOk();
	}
	
	/**
	 * Return all choosen resources
	 */
	public boolean run() {
		parentStep.addTransformation(new XsltComponent(strId));
		return true;
	}
	
	
	
	
	// ----------------------
	
	private class MasterContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof XsltWriterTransfFactory) {
				return XsltWriterTransfFactory.getAll();
				
			} else if (inputElement instanceof String ) {
//				SimpleFormEditorInput input = (SimpleFormEditorInput) page
//						.getEditor().getEditorInput();
				return XsltWriterTransfFactory.getAllId();
			}
			return new Object[0];
		}
		public void dispose() {
		}
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}
	private class MasterLabelProvider extends LabelProvider
			implements
				ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			if (obj instanceof IXsltWriterTransformation) {
				return ((IXsltWriterTransformation) obj).getId();
			}
			return obj.toString();
		}
		public Image getColumnImage(Object obj, int index) {
			if (obj instanceof XsltWriterTransfFactory.AXsltWriterTransgormation) {
				return PlatformUI.getWorkbench().getSharedImages().getImage(
						ISharedImages.IMG_OBJ_ELEMENT);
			}
			if (obj instanceof IXsltWriterTransformation) {
				return PlatformUI.getWorkbench().getSharedImages().getImage(
						ISharedImages.IMG_OBJ_FILE);
			}
			return null;
		}
	}

}
