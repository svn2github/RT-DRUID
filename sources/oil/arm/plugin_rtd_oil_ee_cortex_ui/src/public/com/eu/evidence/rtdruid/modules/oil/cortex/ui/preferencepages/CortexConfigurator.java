/*
 * Created on 13-giu-2005
 *
 * $Id: PIC30Configurator.java,v 1.4 2008/03/26 18:23:55 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.cortex.ui.preferencepages;



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
import com.eu.evidence.rtdruid.ui.preferencepages.AbstractPage;

/**
 * This class implements a preference page about cortex Configuration.
 * 
 * @author Nicola Serreli
 */
public class CortexConfigurator extends AbstractPage {

	private Text paramIar = null;
	private Text paramCcs = null;
	private Text paramKeil = null;
	private Text paramGnu = null;
    
	/**
	 * (non-Javadoc) Method declared on PreferencePage
	 */
	protected Control createContents(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, IOPPConstants.OS_CONF_CONTEXT);

		//composite_tab << parent
		Composite composite_tab = createComposite(parent, 3);
		composite_tab.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL));

		createLabel(composite_tab, "IAR Compiler path", 1); //$NON-NLS-1$
		paramIar = createTextField(composite_tab); //$NON-NLS-1$
		{
			Button gccButton = createPushButton(composite_tab, "Browse"); //$NON-NLS-1$
			gccButton.addSelectionListener(new SelectionListener() {
				public void widgetSelected(SelectionEvent e) {	work(e);	}
				public void widgetDefaultSelected(SelectionEvent e) {	work(e);	}
				protected void work(SelectionEvent e) {
					DirectoryDialog dia = new DirectoryDialog(getShell());
					String path = dia.open();
					if (path!=null) {
						paramIar.setText(path);
					}
				}
			});
		}

		createLabel(composite_tab, "CCS Compiler path", 1); //$NON-NLS-1$
		paramCcs = createTextField(composite_tab); //$NON-NLS-1$
		{
			Button gccButton = createPushButton(composite_tab, "Browse"); //$NON-NLS-1$
			gccButton.addSelectionListener(new SelectionListener() {
				public void widgetSelected(SelectionEvent e) {	work(e);	}
				public void widgetDefaultSelected(SelectionEvent e) {	work(e);	}
				protected void work(SelectionEvent e) {
					DirectoryDialog dia = new DirectoryDialog(getShell());
					String path = dia.open();
					if (path!=null) {
						paramCcs.setText(path);
					}
				}
			});
		}

		createLabel(composite_tab, "Keil Compiler path", 1); //$NON-NLS-1$
		paramKeil = createTextField(composite_tab); //$NON-NLS-1$
		{
			Button gccButton = createPushButton(composite_tab, "Browse"); //$NON-NLS-1$
			gccButton.addSelectionListener(new SelectionListener() {
				public void widgetSelected(SelectionEvent e) {	work(e);	}
				public void widgetDefaultSelected(SelectionEvent e) {	work(e);	}
				protected void work(SelectionEvent e) {
					DirectoryDialog dia = new DirectoryDialog(getShell());
					String path = dia.open();
					if (path!=null) {
						paramKeil.setText(path);
					}
				}
			});
		}

		createLabel(composite_tab, "Gnu Compiler path", 1); //$NON-NLS-1$
		paramGnu = createTextField(composite_tab); //$NON-NLS-1$
		{
			Button gccButton = createPushButton(composite_tab, "Browse"); //$NON-NLS-1$
			gccButton.addSelectionListener(new SelectionListener() {
				public void widgetSelected(SelectionEvent e) {	work(e);	}
				public void widgetDefaultSelected(SelectionEvent e) {	work(e);	}
				protected void work(SelectionEvent e) {
					DirectoryDialog dia = new DirectoryDialog(getShell());
					String path = dia.open();
					if (path!=null) {
						paramGnu.setText(path);
					}
				}
			});
		}

		initializeValues();

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
		paramIar.setText(Options.INSTANCE.getUiDeafultValue(Options.CORTEX_CONF_IAR));
		paramCcs.setText(Options.INSTANCE.getUiDeafultValue(Options.CORTEX_CONF_CCS));
		paramKeil.setText(Options.INSTANCE.getUiDeafultValue(Options.CORTEX_CONF_KEIL));
		paramGnu.setText(Options.INSTANCE.getUiDeafultValue(Options.CORTEX_CONF_GNU));
		
		enableOk();
	}

	/**
	 * Initializes states of the controls from the preference store.
	 */
	private void initializeValues() {
		Map<String, String> values = Options.INSTANCE.getUiOptions();
		
		{
			String gcc = values.containsKey(Options.CORTEX_CONF_CCS) ?
					values.get(Options.CORTEX_CONF_CCS) 
					: Options.DEFAULT_CORTEX_CONF_CCS;
			paramCcs.setText(gcc);
		}
		{
			String gcc = values.containsKey(Options.CORTEX_CONF_IAR) ?
					values.get(Options.CORTEX_CONF_IAR) 
					: Options.DEFAULT_CORTEX_CONF_IAR;
			paramIar.setText(gcc);
		}
		{
			String gcc = values.containsKey(Options.CORTEX_CONF_KEIL) ?
					values.get(Options.CORTEX_CONF_KEIL) 
					: Options.DEFAULT_CORTEX_CONF_KEIL;
			paramKeil.setText(gcc);
		}
		{
			String gcc = values.containsKey(Options.CORTEX_CONF_GNU) ?
					values.get(Options.CORTEX_CONF_GNU) 
					: Options.DEFAULT_CORTEX_CONF_GNU;
			paramGnu.setText(gcc);
		}

		enableOk();
	}

	
    /**
     * Check all possible errors and then  enable next button if it's all ok
     * or disable it and print an error message if there is at least one error   
     */
	protected void enableOk() {
		
		// disable previous Error and warning messages
        setMessage(null, CortexConfigurator.WARNING);
        setMessage(null, CortexConfigurator.ERROR);
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

		store.setValue(Options.CORTEX_CONF_CCS, paramCcs.getText());
		store.setValue(Options.CORTEX_CONF_IAR, paramIar.getText());
		store.setValue(Options.CORTEX_CONF_KEIL, paramKeil.getText());
		store.setValue(Options.CORTEX_CONF_GNU, paramGnu.getText());
	}

}