/*
 * Created on 13-giu-2005
 *
 * $Id: OSConfigurator.java,v 1.4 2008/03/26 18:23:55 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.ee.ui.preferencepages;


import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

import com.eu.evidence.rtdruid.desk.CheckFileName;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.Activator;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.IOPPConstants;
import com.eu.evidence.rtdruid.ui.common.OneResourceSelectionDialog;
import com.eu.evidence.rtdruid.ui.preferencepages.AbstractPage;

/**
 * This class implements a preference page about OS Configuration.
 * 
 * @author Nicola Serreli
 */
public class OSConfigurator extends AbstractPage {
	private Button radioButtonSource;

	private Button radioButtonBinary;
	
	private Text signFile;
	private Button browseForConfFileButton; 
	private String signFileError = null;
    private int problemType = OSConfigurator.NONE;
//	private Button checkBinForceAlarm;
//	private Button checkBinForceResource;
//	private Button checkBinForceTask;

	/**
	 * (non-Javadoc) Method declared on PreferencePage
	 */
	protected Control createContents(Composite parent) {
//		WorkbenchHelp.setHelp(parent, IOPPConstants.OS_CONF_CONTEXT);

		//composite_tab << parent
		Composite composite_tab = createComposite(parent, 1);
		composite_tab.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL));
		createLabel(composite_tab, "Erika Enterprise distribution", 2); //$NON-NLS-1$

		//
		//tabForward(composite_tab);
		//radio button composite << tab composite
		Composite composite_radioButton = createComposite(composite_tab, 1);
		composite_tab.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL));
		radioButtonSource = createRadioButton(composite_radioButton,
				"Source distribution");
		radioButtonBinary = createRadioButton(composite_radioButton,
				"Binary distribution");
		
		createSignFile(composite_tab);
//		//radio button composite << composite_radioButton
//		Composite composite_binaryCheckButton = createComposite(composite_radioButton, 1);
//		horizontalIndent(composite_binaryCheckButton);
//		checkBinForceAlarm = createCheckBox(composite_binaryCheckButton, "Has always Alarms");
//		checkBinForceResource = createCheckBox(composite_binaryCheckButton, "Has always Mutexs");
//		checkBinForceTask = createCheckBox(composite_binaryCheckButton, "Has always Tasks");

		initializeValues();

		//font = null;
		return new Composite(parent, SWT.NULL);
	}

	private void createSignFile(Composite parent) {
        /*
         * Prepare all compontens
         */
		Group current = new Group(parent, SWT.NONE);
		{
		    current.setText("Signature file");
    		GridLayout layout = new GridLayout();
    		layout.numColumns = 2;
    		layout.makeColumnsEqualWidth = false;
	        layout.marginHeight = 10;
	        layout.marginWidth = 10;
    		layout.horizontalSpacing = 5;
    		layout.verticalSpacing = 5;
    		current.setLayout(layout);
    		GridData data = new GridData(GridData.FILL_HORIZONTAL| GridData.GRAB_HORIZONTAL);
    		data.horizontalIndent = 25;
    		current.setLayoutData(data);
		}
		

		// Label
		Label label = new Label(current, SWT.LEFT);
		{
    		label.setText("File name");
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.horizontalSpan = 2;
    		label.setLayoutData(data);
		}

		// Text
		signFile = new Text(current, SWT.SINGLE | SWT.BORDER);
		{
			signFile.setText("");
			signFile.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
    		
			signFile.addModifyListener(new ModifyListener() {
                public void modifyText(ModifyEvent e) {
                    if (e.getSource() == signFile) {
                    	
                    	final String newName = signFile.getText();
                    	
                    	problemType = OSConfigurator.NONE;
                        /*
                         * Check if file path is valid
                         */
                    	signFileError = newName.length() == 0 ? null : (new CheckFileName(null)).checkFileName(newName);
                    	
                    	if (signFileError != null) {
                    		problemType = OSConfigurator.ERROR;
                    	} else {
                    	
	                    	/*
	                    	 * Check if exist 
	                    	 */
	                    	IResource res = ResourcesPlugin.getWorkspace().getRoot()
								.findMember(new Path(newName));
	                    	if (newName.length() == 0 || res == null) {
	                    		
	                    		signFileError = "Specified file doesn't exist";
	                    		problemType = OSConfigurator.WARNING;
	                    		
	                    	} else if (res.getType() != IResource.FILE){
	                    		signFileError = "Specified file identifies a folder";
	                    		problemType = OSConfigurator.ERROR;
	                    		
	                    	}
                    	}
	                        
                        // update the status of this page 
                        enableOk();
                    }
                }
            });
		}
		
		browseForConfFileButton = new Button(current,SWT.PUSH);
		browseForConfFileButton.setText(
				"Browse" /*IDEWorkbenchMessages.getString("WizardImportPage.browse2")*/);
				//Rtdruid_module_oil_niosPlugin.getString("OilProjectProperties.common.Browse"));
		browseForConfFileButton.setLayoutData(new GridData());
		browseForConfFileButton.addSelectionListener(new SelectionListener() {
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetDefaultSelected(SelectionEvent e) {
				handleBinaryBrowseButtonSelected();
			}
			
			public void widgetSelected(SelectionEvent evt) {
				handleBinaryBrowseButtonSelected();
			}
		});


		
		// Label
		label = new Label(parent, SWT.LEFT);
		{
    		label.setText("");
    		label.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_VERTICAL | GridData.GRAB_HORIZONTAL));
		}
	}

	/**
	 * Show a dialog that lets the user select an oil file, from current project
	 */
	protected void handleBinaryBrowseButtonSelected() {

		ElementTreeSelectionDialog dialog = new OneResourceSelectionDialog(
				getShell(),
				"Erika Enterprise Signature's file ",
				"Choose the file that contains all Erika Enterprise signatures",
				ResourcesPlugin.getWorkspace().getRoot(),
				OneResourceSelectionDialog.getStandardValidator(
						Activator.PLUGIN_ID, null)
			).getDialog();

		if (dialog.open() == Window.CANCEL) {
			return;
		}

		Object[] results = dialog.getResult();

		try {
			signFile.setText(((IResource) results[0]).getFullPath().toString());
		} catch (Exception ex) {
			/* Why ?? */
			RtdruidLog.log(ex);
		}

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
		if (event.getSource() == radioButtonBinary 
				|| event.getSource() == radioButtonSource) {
			enableBinCheckBox();
		}
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
		radioButtonSource.setSelection(true);
		radioButtonBinary.setSelection(false);
		
		signFile.setText(IOPPConstants.OS_CONF_SIGNATURE_FILE_DEFAULT);
		enableBinCheckBox();
	}

	/**
	 * Initializes states of the controls from the preference store.
	 */
	private void initializeValues() {
		IPreferenceStore store = getPreferenceStore();

		int choice = store.contains(IOPPConstants.OS_CONF_DISTRIBUTION_CHOICE) ? 
				store.getInt(IOPPConstants.OS_CONF_DISTRIBUTION_CHOICE):
					IOPPConstants.OS_CONF_DISTRIBUTION_CHOICE_SOURCE;
		switch (choice) {
		case IOPPConstants.OS_CONF_DISTRIBUTION_CHOICE_SOURCE:
			radioButtonSource.setSelection(true);
			break;
			
		case IOPPConstants.OS_CONF_DISTRIBUTION_CHOICE_BINARY:
		default :
			radioButtonBinary.setSelection(true);
			break;
		}

		String sign = store.contains(IOPPConstants.OS_CONF_SIGNATURE_FILE) ?
				store.getString(IOPPConstants.OS_CONF_SIGNATURE_FILE) 
				: IOPPConstants.OS_CONF_SIGNATURE_FILE_DEFAULT;
		signFile.setText(sign);

		enableBinCheckBox();
	}
	
	private void enableBinCheckBox() {
		boolean enable = radioButtonBinary.getSelection();
		signFile.setEnabled(enable);
		browseForConfFileButton.setEnabled(enable);
		
		enableOk();
	}

	
    /**
     * Check all possible errors and then  enable next button if it's all ok
     * or disable it and print an error message if there is at least one error   
     */
	protected void enableOk() {
		
		// disable previous Error and warning messages
        setMessage(null, OSConfigurator.WARNING);
        setMessage(null, OSConfigurator.ERROR);

		
		String messg = null;
		
		/* 
		 * check all strings ...
		 */
		
		// ... config ...
		if (radioButtonBinary.getSelection() && signFileError != null) {
		    messg = signFileError;
		}
        
		/*
		 * Update "next" button and "Error message"
		 */
		
		// enable next only if it's all ok
		setValid(messg == null || problemType != OSConfigurator.ERROR);
    	
        // print error message 
        setMessage(messg, problemType);
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

		int choice = IOPPConstants.OS_CONF_DISTRIBUTION_CHOICE_SOURCE;

		if (radioButtonBinary.getSelection())
			choice = IOPPConstants.OS_CONF_DISTRIBUTION_CHOICE_BINARY;
		

		store.setValue(IOPPConstants.OS_CONF_DISTRIBUTION_CHOICE, choice);
		store.setValue(IOPPConstants.OS_CONF_SIGNATURE_FILE, signFile.getText());
	}
	
	// ------------------------------------

}