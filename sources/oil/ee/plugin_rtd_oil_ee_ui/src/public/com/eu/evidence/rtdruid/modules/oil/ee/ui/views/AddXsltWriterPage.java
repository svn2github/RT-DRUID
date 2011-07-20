/*
 * Created on 13/set/07
 *
 * $Id: ExportXtcPage.java,v 1.5 2008/01/09 17:50:20 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.ee.ui.views;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.EESectionWritersFactory;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.XsltMainComponent;

public class AddXsltWriterPage extends WizardPage {

	
	protected Text txtId;
	protected static String strId;
	
	/**
	 * Make a new Page
	 */
	public AddXsltWriterPage(String pageId) {
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

		// ---- ID ----

		{
			Label containerLabel = new Label(composite, SWT.LEFT);
			containerLabel.setText("Xslt Writer ID");
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
		} else if (EESectionWritersFactory.containsId(txtId.getText())) {
			errMessg = (errMessg == null ? "" : errMessg + "\n")
				+ "Specified ID aready exist";
		}
				
		
		if ( errMessg != null) setErrorMessage(errMessg);
		else {
			if (warnMessg != null) setMessage(warnMessg, WARNING);
			strId = txtId.getText();
		}
		
		setPageComplete(errMessg == null);
	}

	/**
	 * Initialize all values
	 */
	public void init() {
		if (strId != null) txtId.setText(strId);
		
		enableOk();
	}
	
	/**
	 * Return all choosen resources
	 */
	public boolean run() {
		EESectionWritersFactory.addXsltFactory(strId, new XsltMainComponent(null, null));
		return true;
	}
	

}
