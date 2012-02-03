package com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
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
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.location.ErikaEnterpriseLocationHandler.Choice;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.location.ErikaEnterpriseLocationContainer;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.location.IErikaEnterpriseLocationWorkingCopy;

public class ErikaSourcesPreferenceBody implements SelectionListener, ModifyListener {
	
	
	public interface IListener {
		public void somethingChanged();
	}
	
	protected final static boolean enableVariableSupport = false;
	
	private Composite root;
	
	private Button autoButton;
	private Text autoValue;
	private Button userButton;
	private Text userValue;
	private Button fileSystemButton;
	private Button variablesButton;
	private Button confButton;
	private Text confValue;
	private Button erikaFilesButton;
	private Text erikaFilesValue;
	private Button pluginsButton;
	private Text pluginsValue;
	
	private List<IListener> listeners;

	
	private IErikaEnterpriseLocationWorkingCopy handler;
	protected boolean initPhase = true;
	
	public ErikaSourcesPreferenceBody(IErikaEnterpriseLocationWorkingCopy handler) {
		this.handler = handler;
		listeners = new LinkedList<ErikaSourcesPreferenceBody.IListener>();
	}
	
	public void addListener(IListener l) {
		if (!listeners.contains(l)) {
			listeners.add(l);
		}
	}
	public void removeListener(IListener l) {
		listeners.remove(l);
	}
	
	public void performDefaults() {
		initPhase = true;
		handler.setDefaults();
		initializeValues();
		initPhase = false;
		notifyListeners();
	}
	protected void notifyListeners() {
		for (IListener l: listeners) {
			try {
				l.somethingChanged();
			} catch (Exception e) {
				RtdruidLog.log(e);
			}
		}
	}
	
	
	public Composite createContents(Composite parent) {
		final int incr = enableVariableSupport ? 1 : 0;
		
		Group composite_tab = createGroup(parent, "Erika Enterprise source location", 3+incr);
		root = composite_tab;
		composite_tab.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
		
		
		/*
		 * Auto
		 */
		autoButton = createRadioButton(composite_tab, "Auto");
		autoValue = createTextField(composite_tab);
		autoValue.setEditable(false);
		((GridData)autoValue.getLayoutData()).horizontalSpan=2+incr;
		
		
		
		/*
		 * Manual
		 */
		{
			Composite user_tab = composite_tab;//new Composite(composite_tab, SWT.NONE);
//			GridData gd = new GridData(GridData.FILL | GridData.GRAB_HORIZONTAL);
//			gd.horizontalSpan = 2;
//			user_tab.setLayoutData(gd);
//			//GridLayout
//			GridLayout layout = new GridLayout();
//			layout.numColumns = 4;
//			user_tab.setLayout(layout);

			userButton = createRadioButton(user_tab, "Manual");
			userValue = createTextField(user_tab);
			
			fileSystemButton = createPushButton(user_tab, "File system...");
			if (enableVariableSupport) {
				variablesButton = createPushButton(user_tab, "Variables...");
			}
			
		}

		/*
		 * Erika files
		 */
		erikaFilesButton = createRadioButton(composite_tab, "ERIKA_FILES variable");
		erikaFilesValue = createTextField(composite_tab);
		erikaFilesValue.setEditable(false);
		((GridData)erikaFilesValue.getLayoutData()).horizontalSpan=2+incr;

		/*
		 * Configuration
		 */
		confButton = createRadioButton(composite_tab, "Common_oil.pref");
		confValue = createTextField(composite_tab);
		confValue.setEditable(false);
		((GridData)confValue.getLayoutData()).horizontalSpan=2+incr;
		
		/*
		 * Plugins
		 */
		pluginsButton = createRadioButton(composite_tab, "Plugins");
		pluginsValue = createTextField(composite_tab);
		pluginsValue.setEditable(false);
		((GridData)pluginsValue.getLayoutData()).horizontalSpan=2+incr;
		
		initializeValues();

		initPhase = false;
	
		//font = null;
		return root;
	}

	private void initializeValues() {
		Choice enabled = handler.getCurrentChoice(); 

		autoButton.setSelection(false);
		userButton.setSelection(false);
		erikaFilesButton.setSelection(false);
		confButton.setSelection(false);
		pluginsButton.setSelection(false);

		
		switch (enabled) {
			case AUTO:
			default:
				autoButton.setSelection(true);
				break;
			case USER_VALUE:
				userButton.setSelection(true);
				break;
			case ERIKA_FILES:
				erikaFilesButton.setSelection(true);
				break;
			case CONF_FILE:
				confButton.setSelection(true);
				break;
			case PLUGINS:
				pluginsButton.setSelection(true);
				break;
		}
		
				
		autoValue.setText(handler.getAutoPath());
		userValue.setText(handler.getUserPath());
		erikaFilesValue.setText(handler.getErikaFilesEnv());
		confValue.setText(handler.getConfigFileEeLocation());
		pluginsValue.setText(handler.getPluginEeLocation());
	}
	
	

	/**
	 * (non-Javadoc) Method declared on SelectionListener
	 */
	public void widgetDefaultSelected(SelectionEvent event) {
		doWidget(event);
	}

	/**
	 * (non-Javadoc) Method declared on SelectionListener
	 */
	public void widgetSelected(SelectionEvent event) {
		doWidget(event);
	}
	
	protected void doWidget(SelectionEvent event) {
		if (initPhase) {
			return; // do nothing during init phases
		}
		
		
		Object o = event.getSource();

		Choice enabled = null;
		if (autoButton == o) {
			enabled = Choice.AUTO;
		} else if (userButton == o) {
			enabled = Choice.USER_VALUE;
		} else if (confButton == o) {
			enabled = Choice.CONF_FILE;
		} else if (erikaFilesButton == o) {
			enabled = Choice.ERIKA_FILES;
		} else if (pluginsButton == o) {
			enabled = Choice.PLUGINS;
		}
		if ( enabled != null ) {
			handler.setCurrentChoice(enabled);
		}
		
		
		
		if (fileSystemButton == o) {
			DirectoryDialog dia = new DirectoryDialog(fileSystemButton.getShell());
			String path = dia.open();
			if (path!=null) {
				userValue.setText(path);
			}
		}
		
		if (enableVariableSupport) {
			if (variablesButton == o) {
				
				
				
			}
		}
		
		notifyListeners();
	}
	
	
	/**
	 * (non-Javadoc) Method declared on ModifyListener
	 */
	public void modifyText(ModifyEvent event) {
		if (initPhase) {
			return; // do nothing during init phases
		}
	
		Object o = event.getSource();
		if (o == userValue) {
			String userPath = userValue.getText();
			boolean empty = userPath.length() == 0;
			handler.setUserPath(empty ? null : userPath);
			if (!empty) {
				handler.setCurrentChoice(Choice.USER_VALUE);
			}
		}
		
		notifyListeners();
	}
	
	
	public void enableAll(boolean enable) {
		
		root.setEnabled(enable);
		for (Control child: root.getChildren()) {
			child.setEnabled(enable);
		}
	}
	
	public String check() {
		if (handler.getCurrentChoice() == Choice.USER_VALUE) {
			String path = handler.getUserPath();
			if (path.length()==0) {
				return "Set the file system path to Erika Enterprise files";
			}
			IStatus status = ErikaEnterpriseLocationContainer.isValidUserPath(path);
			if (!status.isOK()) {
				return status.getMessage();
			}

			path = handler.getResolvedUserPath();
			
			File f = new File(path);
			if (!f.exists()) {
				return "Specified path does not exist";
			}
			if (!f.isDirectory()) {
				return "Specified path is not a directory";
			}
		}
		
		return null;
	}

	// -----------------------------------------------------
	// --------------  Utilities  --------------------------
	// -----------------------------------------------------

	/**
	 * Utility method that creates a push button instance and sets the default
	 * layout data.
	 * 
	 * @param parent
	 *            the parent for the new button
	 * @param label
	 *            the label for the new button
	 * @return the newly-created button
	 */
	protected Button createPushButton(Composite parent, String label) {
		Button button = new Button(parent, SWT.PUSH);
		button.setText(label);
		button.addSelectionListener(this);
		button.setLayoutData(new GridData());
		return button;
	}
	
	/**
	 * Creates composite control and sets the default layout data.
	 * 
	 * @param parent
	 *            the parent of the new composite
	 * @param numColumns
	 *            the number of columns for the new composite
	 * @return the newly-created coposite
	 */
	protected Group createGroup(Composite parent, String label, int numColumns) {
		Group composite = new Group(parent, SWT.SHADOW_ETCHED_IN);
		composite.setText(label);

		//GridLayout
		GridLayout layout = new GridLayout();
		layout.numColumns = numColumns;
		composite.setLayout(layout);

		//GridData
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
		return composite;
	}

	
	/**
	 * Utility method that creates a radio button instance and sets the default
	 * layout data.
	 * 
	 * @param parent
	 *            the parent for the new button
	 * @param label
	 *            the label for the new button
	 * @return the newly-created button
	 */
	protected Button createRadioButton(Composite parent, String label) {
		Button button = new Button(parent, SWT.RADIO | SWT.LEFT);
		button.setText(label);
		button.addSelectionListener(this);
		button.setLayoutData( new GridData());
		return button;
	}

	
	/**
	 * Create a text field specific for this application
	 * 
	 * @param parent
	 *            the parent of the new text field
	 * @return the new text field
	 */
	protected Text createTextField(Composite parent) {
		Text text = new Text(parent, SWT.SINGLE | SWT.BORDER);
		text.addModifyListener(this);
		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
		return text;
	}

	
}

