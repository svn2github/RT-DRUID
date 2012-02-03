/*
 * Created on 13-giu-2005
 *
 * $Id: AbstractPage.java,v 1.3 2007/07/18 06:59:35 durin Exp $
 */
package com.eu.evidence.rtdruid.ui.preferencepages;

/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.eu.evidence.rtdruid.ui.Rtd_core_uiPlugin;


/**
 * This class implements a sample preference page that is added to the
 * preference dialog based on the registration.
 */
abstract public class AbstractPage extends PreferencePage implements
		IWorkbenchPreferencePage, SelectionListener, ModifyListener {

	/**
	 * The <code>ReadmePreferencePage</code> implementation of this
	 * <code>PreferencePage</code> method returns preference store that
	 * belongs to the our plugin. This is important because we want to store our
	 * preferences separately from the desktop.
	 */
	protected IPreferenceStore doGetPreferenceStore() {

		return Rtd_core_uiPlugin.getDefault().getPreferenceStore();
	}

	/*
	 * (non-Javadoc) Method declared on PreferencePage
	 */
	public boolean performOk() {
		storeValues();
		return true;
	}

	/**
	 * Stores the values of the controls back to the preference store.
	 */
	abstract protected void storeValues();

	/*
	 * 
	 * Create "Something" methods
	 *  
	 */

	/**
	 * Creates an new checkbox instance and sets the default layout data.
	 * 
	 * @param group
	 *            the composite in which to create the checkbox
	 * @param label
	 *            the string to set into the checkbox
	 * @return the new checkbox
	 */
	protected Button createCheckBox(Composite group, String label) {
		Button button = new Button(group, SWT.CHECK | SWT.LEFT);
		button.setText(label);
		button.addSelectionListener(this);
		GridData data = new GridData();
		button.setLayoutData(data);
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
	protected Composite createComposite(Composite parent, int numColumns) {
		Composite composite = new Composite(parent, SWT.NULL);

		//GridLayout
		GridLayout layout = new GridLayout();
		layout.numColumns = numColumns;
		composite.setLayout(layout);

		//GridData
		GridData data = new GridData();
		data.verticalAlignment = GridData.FILL;
		data.horizontalAlignment = GridData.FILL;
		composite.setLayoutData(data);
		return composite;
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
		GridData data = new GridData();
		data.verticalAlignment = GridData.FILL;
		data.horizontalAlignment = GridData.FILL;
		composite.setLayoutData(data);
		return composite;
	}


	/**
	 * Utility method that creates a label instance and sets the default layout
	 * data.
	 * 
	 * @param parent
	 *            the parent for the new label
	 * @param text
	 *            the text for the new label
	 * @return the new label
	 */
	protected Label createLabel(Composite parent, String text, int span) {
		Label label = new Label(parent, SWT.LEFT);
		label.setText(text);
		GridData data = new GridData();
		data.horizontalSpan = span;
		data.horizontalAlignment = GridData.FILL;
		label.setLayoutData(data);
		return label;
	}

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
		GridData data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		button.setLayoutData(data);
		return button;
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
		GridData data = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);
		button.setLayoutData(data);
		return button;
	}

	/**
	 * Create a combo field specific for this application
	 * 
	 * @param parent
	 *            the parent of the new text field
	 * @return the new combo field
	 */
	protected Combo createComboField(Composite parent) {
		Combo combo = new Combo(parent, SWT.SINGLE | SWT.BORDER);
		combo.addModifyListener(this);
		GridData data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.grabExcessHorizontalSpace = true;
		data.verticalAlignment = GridData.CENTER;
		data.grabExcessVerticalSpace = false;
		combo.setLayoutData(data);
		return combo;
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
		GridData data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.grabExcessHorizontalSpace = true;
		data.verticalAlignment = GridData.CENTER;
		data.grabExcessVerticalSpace = false;
		text.setLayoutData(data);
		return text;
	}

	/**
	 * Creates a tab of one horizontal spans.
	 * 
	 * @param parent
	 *            the parent in which the tab should be created
	 */
	protected void tabForward(Composite parent) {
		Label vfiller = new Label(parent, SWT.LEFT);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.BEGINNING;
		gridData.grabExcessHorizontalSpace = false;
		gridData.verticalAlignment = GridData.CENTER;
		gridData.grabExcessVerticalSpace = false;
		vfiller.setLayoutData(gridData);
	}
	
	/** Set the left indentation to a default value (15) */
	protected void horizontalIndent(Control object) {
		((GridData) object.getLayoutData()).horizontalIndent = 15;
	}

	/*
	 * 
	 * Listener
	 * 
	 *  
	 */

	/**
	 * (non-Javadoc) Method declared on ModifyListener
	 */
	public void modifyText(ModifyEvent event) {
		//Default : Do nothing
	}

	/**
	 * (non-Javadoc) Method declared on SelectionListener
	 */
	public void widgetDefaultSelected(SelectionEvent event) {
		//Default : Do nothing
	}

	/**
	 * (non-Javadoc) Method declared on SelectionListener
	 */
	public void widgetSelected(SelectionEvent event) {
		//Default : Do nothing
	}
}