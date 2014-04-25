package com.eu.evidence.rtdruid.modules.oil.s12.ui.preferencepages;
/*
 * Created on 13-giu-2005
 *
 * $Id: PIC30Configurator.java,v 1.4 2008/03/26 18:23:55 durin Exp $
 */




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
import com.eu.evidence.rtdruid.modules.oil.s12.constants.S12Constants;
import com.eu.evidence.rtdruid.ui.preferencepages.AbstractPage;

/**
 * This class implements a preference page about S12 Configuration.
 * 
 * @author Nicola Serreli
 */
public class S12Configurator extends AbstractPage {

	private Text paramGcc = null;
    private Text paramCodeWarriorPath = null;
    
	/**
	 * (non-Javadoc) Method declared on PreferencePage
	 */
	protected Control createContents(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, IOPPConstants.OS_CONF_CONTEXT);

		//composite_tab << parent
		Composite composite_tab = createComposite(parent, 3);
		composite_tab.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL));

		createLabel(composite_tab, "Cosmic Compiler Path", 1); //$NON-NLS-1$
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
		
		createLabel(composite_tab, "Codewarrior Compiler Path", 1); //$NON-NLS-1$
		paramCodeWarriorPath = createTextField(composite_tab); //$NON-NLS-1$
		Button cwButton = createPushButton(composite_tab, "Browse"); //$NON-NLS-1$
		cwButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {	work(e);	}
			public void widgetDefaultSelected(SelectionEvent e) {	work(e);	}
			protected void work(SelectionEvent e) {
				DirectoryDialog dia = new DirectoryDialog(getShell());
				String path = dia.open();
				if (path!=null) {
					paramCodeWarriorPath.setText(path);
				}
			}
		});

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
		paramCodeWarriorPath.setText(Options.INSTANCE.getUiDeafultValue(Options.S12_CODEWARRIOR_CONF_GCC));
		paramGcc.setText(Options.INSTANCE.getUiDeafultValue(Options.S12_CONF_GCC));

		enableOk();
	}

	/**
	 * Initializes states of the controls from the preference store.
	 */
	private void initializeValues() {
		Map<String, String> values = Options.INSTANCE.getUiOptions();

		String cwPath = values.containsKey(Options.S12_CODEWARRIOR_CONF_GCC) ?
				values.get(Options.S12_CODEWARRIOR_CONF_GCC) 
				: S12Constants.DEFAULT_S12_CODEWARRIOR_CONF_GCC;

		paramCodeWarriorPath.setText(cwPath);
		
		String gcc = values.containsKey(Options.S12_CONF_GCC) ?
				values.get(Options.S12_CONF_GCC) 
				: S12Constants.DEFAULT_S12_COSMIC_CONF_GCC;
		paramGcc.setText(gcc);

		enableOk();
	}

	
    /**
     * Check all possible errors and then  enable next button if it's all ok
     * or disable it and print an error message if there is at least one error   
     */
	protected void enableOk() {
		
		// disable previous Error and warning messages
        setMessage(null, S12Configurator.WARNING);
        setMessage(null, S12Configurator.ERROR);
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

		store.setValue(Options.S12_CODEWARRIOR_CONF_GCC, paramCodeWarriorPath.getText());
		
		store.setValue(Options.S12_CONF_GCC, paramGcc.getText());
	}

}