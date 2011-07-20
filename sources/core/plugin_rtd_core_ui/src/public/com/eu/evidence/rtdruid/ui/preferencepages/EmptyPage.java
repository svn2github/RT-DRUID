/*
 * Created on 13-giu-2005
 *
 * $Id: EmptyPage.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.ui.preferencepages;

/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This class implements an Empty preference page that is added to the
 * preference dialog based on the registration.
 * 
 * Also disable Default and Apply buttons.
 */
public class EmptyPage extends PreferencePage implements
		IWorkbenchPreferencePage {

	/** */
	public EmptyPage() {
		noDefaultAndApplyButton();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createContents(Composite parent) {
		new Label(parent, SWT.LEFT);

		return new Composite(parent, SWT.NULL);
	}

	/*
	 * (non-Javadoc) Method declared on IWorkbenchPreferencePage
	 */
	public void init(IWorkbench workbench) {
	}
}