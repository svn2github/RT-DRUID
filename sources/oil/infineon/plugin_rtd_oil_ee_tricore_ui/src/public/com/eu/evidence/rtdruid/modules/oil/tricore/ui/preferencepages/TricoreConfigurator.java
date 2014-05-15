/*
 * Created on 13-giu-2005
 *
 * $Id: PIC30Configurator.java,v 1.4 2008/03/26 18:23:55 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.tricore.ui.preferencepages;



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
 * This class implements a preference page about PIC30 Configuration.
 * 
 * @author Nicola Serreli
 */
public class TricoreConfigurator extends AbstractPage {

	private Text paramTasking = null;
    private Text paramGnu = null;
    private Text paramDiab = null;
    
	/**
	 * (non-Javadoc) Method declared on PreferencePage
	 */
	protected Control createContents(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, IOPPConstants.OS_CONF_CONTEXT);

		//composite_tab << parent
		Composite composite_tab = createComposite(parent, 3);
		composite_tab.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL));

		createLabel(composite_tab, "Tasking path", 1); //$NON-NLS-1$
		paramTasking = createTextField(composite_tab); //$NON-NLS-1$
		Button gccButton = createPushButton(composite_tab, "Browse"); //$NON-NLS-1$
		gccButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {	work(e);	}
			public void widgetDefaultSelected(SelectionEvent e) {	work(e);	}
			protected void work(SelectionEvent e) {
				DirectoryDialog dia = new DirectoryDialog(getShell());
				String path = dia.open();
				if (path!=null) {
					paramTasking.setText(path);
				}
			}
		});

		createLabel(composite_tab, "Gnu path", 1); //$NON-NLS-1$
		paramGnu = createTextField(composite_tab); //$NON-NLS-1$
		gccButton = createPushButton(composite_tab, "Browse"); //$NON-NLS-1$
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
		
		createLabel(composite_tab, "Diab path", 1); //$NON-NLS-1$
		paramDiab = createTextField(composite_tab); //$NON-NLS-1$
		Button asmButton = createPushButton(composite_tab, "Browse"); //$NON-NLS-1$
		asmButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {	work(e);	}
			public void widgetDefaultSelected(SelectionEvent e) {	work(e);	}
			protected void work(SelectionEvent e) {
				DirectoryDialog dia = new DirectoryDialog(getShell());
				String path = dia.open();
				if (path!=null) {
					paramDiab.setText(path);
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
		paramTasking.setText(Options.INSTANCE.getUiDeafultValue(Options.TRICORE_CONF_TASKING_CC_PATH));
		paramGnu.setText(    Options.INSTANCE.getUiDeafultValue(Options.TRICORE_CONF_GNU_CC_PATH));
		paramDiab.setText(   Options.INSTANCE.getUiDeafultValue(Options.TRICORE_CONF_DIAB_CC_PATH));

		enableOk();
	}

	/**
	 * Initializes states of the controls from the preference store.
	 */
	private void initializeValues() {
		Map<String, String> values = Options.INSTANCE.getUiOptions();
		
		String tasking = values.containsKey(Options.TRICORE_CONF_TASKING_CC_PATH) ?
				values.get(Options.TRICORE_CONF_TASKING_CC_PATH) 
				: "";
		paramTasking.setText(tasking);
		
		String gnu = values.containsKey(Options.TRICORE_CONF_GNU_CC_PATH) ?
				values.get(Options.TRICORE_CONF_GNU_CC_PATH) 
				: "";

		paramGnu.setText(gnu);
		
		String diab = values.containsKey(Options.TRICORE_CONF_DIAB_CC_PATH) ?
				values.get(Options.TRICORE_CONF_DIAB_CC_PATH) 
				: "";
		paramDiab.setText(diab);

		enableOk();
	}

	
    /**
     * Check all possible errors and then  enable next button if it's all ok
     * or disable it and print an error message if there is at least one error   
     */
	protected void enableOk() {
		
		// disable previous Error and warning messages
        setMessage(null, TricoreConfigurator.WARNING);
        setMessage(null, TricoreConfigurator.ERROR);
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

		store.setValue(Options.TRICORE_CONF_TASKING_CC_PATH, paramTasking.getText());
		store.setValue(Options.TRICORE_CONF_GNU_CC_PATH, paramGnu.getText());
		store.setValue(Options.TRICORE_CONF_DIAB_CC_PATH, paramDiab.getText());
	}

}