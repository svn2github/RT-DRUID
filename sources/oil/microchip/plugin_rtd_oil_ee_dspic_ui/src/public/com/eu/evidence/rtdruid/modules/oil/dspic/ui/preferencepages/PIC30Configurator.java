/*
 * Created on 13-giu-2005
 *
 * $Id: PIC30Configurator.java,v 1.4 2008/03/26 18:23:55 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.dspic.ui.preferencepages;



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

import com.eu.evidence.modules.oil.dspic.constants.PicConstants;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.IOPPConstants;
import com.eu.evidence.rtdruid.ui.preferencepages.AbstractPage;

/**
 * This class implements a preference page about PIC30 Configuration.
 * 
 * @author Nicola Serreli
 */
public class PIC30Configurator extends AbstractPage {

	private Text paramGcc = null;
    private Text paramAsm = null;
//    private Button useEEgcc_deps = null;
//    private Button useEEgcc_comp = null;
    
	/**
	 * (non-Javadoc) Method declared on PreferencePage
	 */
	protected Control createContents(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, IOPPConstants.OS_CONF_CONTEXT);

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
		
		createLabel(composite_tab, "Asm path", 1); //$NON-NLS-1$
		paramAsm = createTextField(composite_tab); //$NON-NLS-1$
		Button asmButton = createPushButton(composite_tab, "Browse"); //$NON-NLS-1$
		asmButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {	work(e);	}
			public void widgetDefaultSelected(SelectionEvent e) {	work(e);	}
			protected void work(SelectionEvent e) {
				DirectoryDialog dia = new DirectoryDialog(getShell());
				String path = dia.open();
				if (path!=null) {
					paramAsm.setText(path);
				}
			}
		});

//		{
//			createLabel(composite_tab, "Use EE gcc to resolve dependecies", 1); //$NON-NLS-1$
//			useEEgcc_deps = createCheckBox(composite_tab, ""); //$NON-NLS-1$
//			GridData data = new GridData();
//			data.horizontalSpan = 2;
//			useEEgcc_deps.setLayoutData(data);
//		}
//
//		{
//			createLabel(composite_tab, "Use EE gcc to compile", 1); //$NON-NLS-1$
//			useEEgcc_comp = createCheckBox(composite_tab, ""); //$NON-NLS-1$
//			GridData data = new GridData();
//			data.horizontalSpan = 2;
//			useEEgcc_comp.setLayoutData(data);
//		}

		
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
		paramAsm.setText(Options.INSTANCE.getUiDeafultValue(Options.PIC30_CONF_ASM));
		paramGcc.setText(Options.INSTANCE.getUiDeafultValue(Options.PIC30_CONF_GCC));
		
//		useEEgcc_deps.setSelection(PicConstants.DEFAULT_PIC30_CONF_USE_EE_GCC_DEPS);
//		useEEgcc_comp.setSelection(PicConstants.DEFAULT_PIC30_CONF_USE_EE_GCC_COMP);

		enableOk();
	}

	/**
	 * Initializes states of the controls from the preference store.
	 */
	private void initializeValues() {
		Map<String, String> values = Options.INSTANCE.getUiOptions();

//		boolean use_ee_d = values.containsKey(Options.PIC30_CONF_USE_EE_GCC_DEPS) ? 
//				(""+true).equals(values.get(Options.PIC30_CONF_USE_EE_GCC_DEPS)) : PicConstants.DEFAULT_PIC30_CONF_USE_EE_GCC_DEPS;
//		useEEgcc_deps.setSelection(use_ee_d);
//
//		boolean use_ee_c = values.containsKey(Options.PIC30_CONF_USE_EE_GCC_COMP) ? 
//				(""+true).equals(values.get(Options.PIC30_CONF_USE_EE_GCC_COMP)) : PicConstants.DEFAULT_PIC30_CONF_USE_EE_GCC_COMP;
//		useEEgcc_comp.setSelection(use_ee_c);
		
		String asm = values.containsKey(Options.PIC30_CONF_ASM) ?
				values.get(Options.PIC30_CONF_ASM) 
				: PicConstants.DEFAULT_PIC30_CONF_ASM;

		paramAsm.setText(asm);
		
		String gcc = values.containsKey(Options.PIC30_CONF_GCC) ?
				values.get(Options.PIC30_CONF_GCC) 
				: PicConstants.DEFAULT_PIC30_CONF_GCC;
		paramGcc.setText(gcc);

		enableOk();
	}

	
    /**
     * Check all possible errors and then  enable next button if it's all ok
     * or disable it and print an error message if there is at least one error   
     */
	protected void enableOk() {
		
		// disable previous Error and warning messages
        setMessage(null, PIC30Configurator.WARNING);
        setMessage(null, PIC30Configurator.ERROR);
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

//		store.setValue(Options.PIC30_CONF_USE_EE_GCC_DEPS, "" + useEEgcc_deps.getSelection());
//		store.setValue(Options.PIC30_CONF_USE_EE_GCC_COMP, "" + useEEgcc_comp.getSelection());

		store.setValue(Options.PIC30_CONF_ASM, paramAsm.getText());
		
		store.setValue(Options.PIC30_CONF_GCC, paramGcc.getText());
	}

}