/*
 * Created on 13-giu-2005
 *
 * $Id: PIC30Configurator.java,v 1.4 2008/03/26 18:23:55 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.renesas.ui.preferencepages;



import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.IOPPConstants;
import com.eu.evidence.rtdruid.modules.oil.renesas.interfaces.RenesasConstants;
import com.eu.evidence.rtdruid.ui.preferencepages.AbstractPage;

/**
 * This class implements a preference page about Renesas Configuration.
 * 
 * @author Nicola Serreli
 */
public class RenesasConfigurator extends AbstractPage {

	private Text paramCCrx = null;
	private Text paramCCrl = null;
	private Text paramE2Studio = null;
    
	/**
	 * (non-Javadoc) Method declared on PreferencePage
	 */
	protected Control createContents(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, IOPPConstants.OS_CONF_CONTEXT);

		//composite_tab << parent
		Composite composite_tab = createComposite(parent, 3);
		composite_tab.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL));

		createLabel(composite_tab, "CCRL path", 1); //$NON-NLS-1$
		paramCCrl = createTextField(composite_tab); //$NON-NLS-1$
		Button ccrlButton = createPushButton(composite_tab, "Browse"); //$NON-NLS-1$
		ccrlButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {	work(e);	}
			public void widgetDefaultSelected(SelectionEvent e) {	work(e);	}
			protected void work(SelectionEvent e) {
				DirectoryDialog dia = new DirectoryDialog(getShell());
				String path = dia.open();
				if (path!=null) {
					paramCCrl.setText(path);
				}
			}
		});
		
		createLabel(composite_tab, "CCRX path", 1); //$NON-NLS-1$
		paramCCrx = createTextField(composite_tab); //$NON-NLS-1$
		Button ccrxButton = createPushButton(composite_tab, "Browse"); //$NON-NLS-1$
		ccrxButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {	work(e);	}
			public void widgetDefaultSelected(SelectionEvent e) {	work(e);	}
			protected void work(SelectionEvent e) {
				DirectoryDialog dia = new DirectoryDialog(getShell());
				String path = dia.open();
				if (path!=null) {
					paramCCrx.setText(path);
				}
			}
		});

		createLabel(composite_tab, "E2Studio path", 1); //$NON-NLS-1$
		paramE2Studio = createTextField(composite_tab); //$NON-NLS-1$
		Button e2studioButton = createPushButton(composite_tab, "Browse"); //$NON-NLS-1$
		e2studioButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {	work(e);	}
			public void widgetDefaultSelected(SelectionEvent e) {	work(e);	}
			protected void work(SelectionEvent e) {
				DirectoryDialog dia = new DirectoryDialog(getShell());
				String path = dia.open();
				if (path!=null) {
					paramE2Studio.setText(path);
				}
			}
		});

		initializeValues();

		//font = null;
		return new Composite(parent, SWT.NULL);
	}

	
	//--------------------------------------------------
	
	/**
	 * (non-Javadoc) Method declared on SelectionListener
	 */
	public void widgetDefaultSelected(SelectionEvent event) {
		widgetSelected(event);
	}

	/**
	 * (non-Javadoc) Method declared on SelectionListener
	 */
	public void widgetSelected(SelectionEvent event) {
	}
	
	// --------------------------------------------------
	
	/*
	 * (non-Javadoc) Method declared on IWorkbenchPreferencePage
	 */
	public void init(IWorkbench workbench) {
	}

	/**
	 * Initializes states of the controls using default values in the preference
	 * store.
	 */
	private void initializeDefaults() {
		paramCCrl.setText(Options.INSTANCE.getUiDeafultValue(Options.RENESAS_CONF_CCRL));
		paramCCrx.setText(Options.INSTANCE.getUiDeafultValue(Options.RENESAS_CONF_CCRX));
		paramE2Studio.setText(Options.INSTANCE.getUiDeafultValue(Options.RENESAS_CONF_E2STUDIO));
		
		enableOk();
	}

	/**
	 * Initializes states of the controls from the preference store.
	 */
	private void initializeValues() {
		Map<String, String> values = Options.INSTANCE.getUiOptions();
		String ccrx = values.containsKey(Options.RENESAS_CONF_CCRX) ?
				values.get(Options.RENESAS_CONF_CCRX) 
				: RenesasConstants.DEFAULT_RX200_CONF_CCRX_CC;
		paramCCrx.setText(ccrx);

		String ccrl = values.containsKey(Options.RENESAS_CONF_CCRL) ?
				values.get(Options.RENESAS_CONF_CCRL) 
				: RenesasConstants.DEFAULT_RL78_CONF_CCRL_CC;
		paramCCrl.setText(ccrl);

		String e2s = values.containsKey(Options.RENESAS_CONF_E2STUDIO) ?
				values.get(Options.RENESAS_CONF_E2STUDIO) 
				: RenesasConstants.DEFAULT_RL78_CONF_E2STUDIO;
		paramE2Studio.setText(e2s);
		
		enableOk();
	}

	
    /**
     * Check all possible errors and then  enable next button if it's all ok
     * or disable it and print an error message if there is at least one error   
     */
	protected void enableOk() {
		
		// disable previous Error and warning messages
        setMessage(null, RenesasConfigurator.WARNING);
        setMessage(null, RenesasConfigurator.ERROR);
	}

	/*
	 * (non-Javadoc) Method declared on PreferencePage
	 */
	protected void performDefaults() {
		super.performDefaults();
		initializeDefaults();
	}

	/**
	 * Stores the values of the controls back to the preference store.
	 */
	protected void storeValues() {
		IPreferenceStore store = getPreferenceStore();

		store.setValue(Options.RENESAS_CONF_CCRL, paramCCrl.getText());
		store.setValue(Options.RENESAS_CONF_CCRX, paramCCrx.getText());
		store.setValue(Options.RENESAS_CONF_E2STUDIO, paramE2Studio.getText());
	}

}