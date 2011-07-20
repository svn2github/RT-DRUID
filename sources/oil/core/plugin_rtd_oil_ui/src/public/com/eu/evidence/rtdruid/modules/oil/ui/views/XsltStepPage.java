/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.eu.evidence.rtdruid.modules.oil.ui.views;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.IXsltWriterTransformation;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.XsltWriterTransfFactory.AXsltWriterTransgormation;

/**
 * @author dejan
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class XsltStepPage implements IDetailsPage {
	private IManagedForm mform;
	private IXsltWriterTransformation input;
	private FormText text;

	
	public XsltStepPage() {
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#initialize(org.eclipse.ui.forms.IManagedForm)
	 */
	public void initialize(IManagedForm mform) {
		this.mform = mform;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	public void createContents(Composite parent) {
		TableWrapLayout layout = new TableWrapLayout();
		layout.topMargin = 5;
		layout.leftMargin = 5;
		layout.rightMargin = 2;
		layout.bottomMargin = 2;
		parent.setLayout(layout);
//		
//		{
//			GridLayout glayout = new GridLayout();
//			glayout.marginWidth = glayout.marginHeight = 5;
//			glayout.numColumns = 1;
//			parent.setLayout(glayout);
//		}


		FormToolkit toolkit = mform.getToolkit();
		Section s1 = toolkit.createSection(parent, Section.DESCRIPTION|Section.TITLE_BAR);
		s1.marginWidth = 10;
		s1.setText("Details"); //$NON-NLS-1$
		s1.setDescription("Xslt transformation details"); //$NON-NLS-1$
		TableWrapData td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP);
		td.grabHorizontal = true;
		s1.setLayoutData(td);
//		s1.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL | GridData.FILL_BOTH));


		
		Composite client = toolkit.createComposite(s1);
//		GridLayout glayout = new GridLayout();
//		glayout.marginWidth = glayout.marginHeight = 0;
//		glayout.numColumns = 1;
//		client.setLayout(glayout);
		client.setLayout(new TableWrapLayout());
//		client.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));
		
		toolkit.createLabel(client, "Xslt content"); //$NON-NLS-1$
		
		text = toolkit.createFormText(client, true);
		text.setWhitespaceNormalized(false);
		text.setParagraphsSeparated(false);
		
		text.setText(getText(), false, false);
		td = new TableWrapData(TableWrapData.FILL, TableWrapData.TOP);
		td.grabHorizontal = true;
		text.setLayoutData(td);
//		{
//			GridData gd = new GridData(GridData.FILL_BOTH);
//			gd.heightHint = 40;
//			gd.widthHint = 100;
//			gd.grabExcessVerticalSpace = true;
//			text.setLayoutData(gd);
//		}
		
		
		toolkit.paintBordersFor(s1);
		s1.setClient(client);
	}
//	private void createSpacer(FormToolkit toolkit, Composite parent, int span) {
//		Label spacer = toolkit.createLabel(parent, ""); //$NON-NLS-1$
//		GridData gd = new GridData();
//		gd.horizontalSpan = span;
//		spacer.setLayoutData(gd);
//	}
	
	private String getText() {
		StringBuffer buff = new StringBuffer();
		if (input != null) {
			if (input instanceof AXsltWriterTransgormation) {
				InputStream data = new BufferedInputStream(((AXsltWriterTransgormation) input).getTransformation());
				try {
					int c;
					while ((c=data.read()) >-1) {
						buff.append((char)c); 
					}
				} catch (IOException e) {
					RtdruidLog.showDebug(e);
				}
			} else {
				buff.append("Text not available");
			}
		}
		return buff.toString();
	}
	
	private void update() {
		text.setWhitespaceNormalized(false);
		text.setText(getText(), false, false); //$NON-NLS-1$
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#inputChanged(org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void selectionChanged(IFormPart part, ISelection selection) {
		IStructuredSelection ssel = (IStructuredSelection)selection;
		if (ssel.size()==1) {
			input = (IXsltWriterTransformation)ssel.getFirstElement();
		}
		else
			input = null;
		update();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#commit()
	 */
	public void commit(boolean onSave) {
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#setFocus()
	 */
	public void setFocus() {
		text.setFocus();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#dispose()
	 */
	public void dispose() {
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#isDirty()
	 */
	public boolean isDirty() {
		return false;
	}
	public boolean isStale() {
		return false;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#refresh()
	 */
	public void refresh() {
		update();
	}
	public boolean setFormInput(Object input) {
		return false;
	}
}
