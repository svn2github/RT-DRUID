package com.eu.evidence.rtdruid.modules.oil.cdt.ui.cygwin;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This class is used to allow the user to choose the cygwin installation path. 
 * 
 * @author Nicola Serreli
 */
public class CygPathPreference extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	
	/**
	 * 
	 * 
	 * @author Nicola Serreli
	 */
	private class Search implements SelectionListener {
		
		public void widgetSelected(SelectionEvent e) {
			doRun();
		}
	
		public void widgetDefaultSelected(SelectionEvent e) {
			doRun();	
		}
		
		protected void doRun() {
			String txt = AutoCygwindSearch.search();
			if (txt == null) {
				MessageDialog.openError(getShell(), "No cygwin found", "Sorry. I cannot find any cygwin installation");
			} else {
				if (MessageDialog.openConfirm(getShell(), "Cygwin found", "I found this path:\n"+txt+ "\n\nDo you want update the path?")) {
					cygpath.setStringValue(txt);
				}
			}
		}
	}
	
	DirectoryFieldEditor cygpath;
	

	public CygPathPreference() {
		super(GRID);
		setPreferenceStore(CygwinProperties.getPreferenceStore());
	}
	
	@Override
	protected void createFieldEditors() {
		Composite parent = getFieldEditorParent();
		
		cygpath = new DirectoryFieldEditor(CygwinProperties.CYGWIN_ROOT, "Cygwin installation", parent);
		addField(cygpath);
		
		Button search = new Button(parent, SWT.PUSH);
		search.setText("Automatic");
		search.addSelectionListener(new Search());
        GridData gd = new GridData();
        gd.horizontalAlignment = GridData.END;
		search.setLayoutData(gd);
		
	}

	public void init(IWorkbench workbench) {
	}
	
	
}
