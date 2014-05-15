/*
 * Created on 13-giu-2005
 *
 * $Id: Avr5Configurator.java,v 1.2 2008/03/26 18:23:52 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.avr.preferencepages;


import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import com.eu.evidence.rtdruid.ui.preferencepages.AbstractPage;

/**
 * This class implements a preference page about PIC30 Configuration.
 * 
 * @author Nicola Serreli
 */
public class Avr5Configurator extends AbstractPage {

    private Text paramGcc = null;
    private Text paramUisp = null;
    private Combo paramSerial = null;
    
	/**
	 * (non-Javadoc) Method declared on PreferencePage
	 */
	protected Control createContents(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, IAvrPPConstants.OS_CONF_CONTEXT);

		//composite_tab << parent
		Composite composite_tab = createComposite(parent, 3);
		composite_tab.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL));

		createLabel(composite_tab, "Gcc path", 1); //$NON-NLS-1$
		paramGcc = createTextField(composite_tab); //$NON-NLS-1$
		Button gccButton = createPushButton(composite_tab, "Browse"); //$NON-NLS-1$
		gccButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {	work(e);	}
			public void widgetDefaultSelected(SelectionEvent e) {	work(e);	}
			protected void work(SelectionEvent e) {
				DirectoryDialog dia = new DirectoryDialog(getShell());
				String path = dia.open();
				if (path!=null) {
					paramGcc.setText(path);
				}
			}
		});

		createLabel(composite_tab, "", 3); //$NON-NLS-1$

		
		createLabel(composite_tab, "Uisp path", 1); //$NON-NLS-1$
		paramUisp = createTextField(composite_tab); //$NON-NLS-1$
		Button uispButton = createPushButton(composite_tab, "Browse"); //$NON-NLS-1$
		uispButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {	work(e);	}
			public void widgetDefaultSelected(SelectionEvent e) {	work(e);	}
			protected void work(SelectionEvent e) {
				FileDialog dia = new FileDialog(getShell(), SWT.OPEN);
				String path = dia.open();
				if (path!=null) {
					paramUisp.setText(path);
				}
			}
		});
		
		createLabel(composite_tab, "Serial port device", 1); //$NON-NLS-1$
		paramSerial = createComboField(composite_tab); //$NON-NLS-1$
		
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
		paramSerial.removeAll();
		for (int i=0; i<20; i++) {
			paramSerial.add("/dev/ttyS"+i);
		}
		paramSerial.select(0);

		paramGcc.setText(Options.INSTANCE.getUiDeafultValue(Options.AVR5_CONF_GCC_PATH));
		paramUisp.setText(Options.INSTANCE.getUiDeafultValue(Options.AVR_CONF_UISP_PATH));
		
		enableOk();
	}

	/**
	 * Initializes states of the controls from the preference store.
	 */
	private void initializeValues() {
		paramSerial.removeAll();
		for (int i=0; i<20; i++) {
			paramSerial.add("/dev/ttyS"+i);
		}
		
		Map<String, String> values = Options.INSTANCE.getUiOptions();

		String gcc = values.containsKey(Options.AVR5_CONF_GCC_PATH) ?
				values.get(Options.AVR5_CONF_GCC_PATH) 
				: Options.DEFAULT_AVR_CONF_GCC_PATH;
		paramGcc.setText(gcc);

		String uisp = values.containsKey(Options.AVR_CONF_UISP_PATH) ?
				values.get(Options.AVR_CONF_UISP_PATH) 
				: Options.DEFAULT_AVR_CONF_UISP_PATH;
		paramUisp.setText(uisp);

		String serial = values.containsKey(Options.AVR_CONF_SERIAL_DEVICE) ?
				values.get(Options.AVR_CONF_SERIAL_DEVICE) 
				: "";

		paramSerial.setText(serial);

		enableOk();
	}

	
    /**
     * Check all possible errors and then  enable next button if it's all ok
     * or disable it and print an error message if there is at least one error   
     */
	protected void enableOk() {
		
		// disable previous Error and warning messages
        setMessage(null, Avr5Configurator.WARNING);
        setMessage(null, Avr5Configurator.ERROR);
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

		store.setValue(Options.AVR5_CONF_GCC_PATH, paramGcc.getText());
		store.setValue(Options.AVR_CONF_UISP_PATH, paramUisp.getText());
		store.setValue(Options.AVR_CONF_SERIAL_DEVICE, paramSerial.getText());
	}

}