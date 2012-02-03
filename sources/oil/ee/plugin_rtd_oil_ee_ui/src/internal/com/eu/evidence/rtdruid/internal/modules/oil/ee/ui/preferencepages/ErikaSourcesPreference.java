package com.eu.evidence.rtdruid.internal.modules.oil.ee.ui.preferencepages;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;

import com.eu.evidence.rtdruid.modules.oil.ee.ui.location.ErikaEnterpriseLocationHandler;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.location.IErikaEnterpriseLocationWorkingCopy;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.ErikaSourcesPreferenceBody;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.ErikaSourcesPreferenceBody.IListener;
import com.eu.evidence.rtdruid.ui.preferencepages.AbstractPage;

public class ErikaSourcesPreference extends AbstractPage implements IListener {

	protected IErikaEnterpriseLocationWorkingCopy handler;
	protected ErikaSourcesPreferenceBody body;
	protected String path;

	public ErikaSourcesPreference() {
		handler = ErikaEnterpriseLocationHandler.getWorkingCopy();
		body = new ErikaSourcesPreferenceBody(handler);
		body.addListener(this);
		
		path = handler.getChoosedErikaEnterpriseLocation();
		if (path == null) {
			path = "";
		}
	}
	
	@Override
	public void dispose() {
		super.dispose();
		body.removeListener(this);
	}
	
	@Override
	public void init(IWorkbench workbench) {
	}

	
	@Override
	protected void performDefaults() {
		super.performDefaults();
		body.performDefaults();
	}
	
	@Override
	public boolean performOk() {
		boolean ending = super.performOk();
//		if (ending) {
//			if (MessageDialog.openQuestion(getShell(), "Refresh workspace", "After changing Erika Enterprise location you should refresh the workspace.\nDo you want do it now?")) {
//			}
//		}
		return ending;
	}
	
	@Override
	protected void storeValues() {
		ErikaEnterpriseLocationHandler.getDefault().save(handler);
	}

	@Override
	protected Control createContents(Composite parent) {
		Control c = body.createContents(parent);
		enableOk();
		return c;
	}
	
	
	@Override
	public void somethingChanged() {
		enableOk();
	}
	
	/**
     * Check all possible errors and then  enable next button if it's all ok
     * or disable it and print an error message if there is at least one error   
     */
	protected void enableOk() {
		// disable previous Error and warning messages
		setMessage(null, WARNING);
		setMessage(null, ERROR);

		
		String message = null;
		if (handler.getCurrentChoice() != null) {
			message = body.check();
		}

        // print error message 
        setMessage(message, WARNING);
	}
}
