/*
 * Created on 21-giu-2005
 *
 * $Id: OilProjectProperties.java,v 1.3 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.cdt.ui.project;

/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */


import java.lang.reflect.InvocationTargetException;

import org.eclipse.cdt.core.CCorePlugin;
import org.eclipse.cdt.core.model.ICProject;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.dialogs.PropertyPage;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.location.ErikaEnterpriseLocationProjectHandler;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.ErikaSourcesPreferenceBody;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.ErikaSourcesPreferenceBody.IListener;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.preferencepages.IOPPConstants;

public class EELocationProjectProperties extends PropertyPage implements IListener {
	
	class ErikaLinksBody implements SelectionListener {

		
		protected boolean oldEnableInclude;
		protected boolean newEnableInclude;
		protected String oldPath;
		
		protected boolean oldEnableSources;
		protected boolean newEnableSources;
		
		protected Button includeButton;
		protected Button sourceButton;
		
		public ErikaLinksBody(ErikaEnterpriseLocationProjectHandler handler) {
			oldPath = handler.getCurrentChoice() == null ? null : handler.getProjectErikaEnterpriseLocation();
			newEnableInclude = oldEnableInclude = EELocationLinkVar.checkEEIncludePaths(project, oldPath);
			newEnableSources = oldEnableSources = EELocationLinkVar.checkEESourcePaths(project);
		}
		
		public Composite createContents(Composite parent)  {
			noDefaultAndApplyButton();
			
			Group composite = new Group(parent, SWT.SHADOW_ETCHED_IN);
			composite.setText("Project links");
			composite.setLayout(new GridLayout());
			composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));

			includeButton = createCheckButton(composite, "Link Erika Enterprise Includes");
			includeButton.setSelection(oldEnableInclude);
			sourceButton = createCheckButton(composite, "Link Erika Enterprise Sources");
			((GridData)sourceButton.getLayoutData()).horizontalIndent=30;
			sourceButton.setSelection(oldEnableSources);
			sourceButton.setEnabled(oldEnableInclude);
			
			return composite;
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
			
			if (includeButton == event.getSource()) {
				newEnableInclude = includeButton.getSelection();

				sourceButton.setEnabled(newEnableInclude);

				if (newEnableInclude) {
					newEnableSources = sourceButton.getSelection();
				} else {
					newEnableSources = false;
				}
				
			} else if (sourceButton == event.getSource()) {
				newEnableSources = sourceButton.getSelection();
			}
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
		protected Button createCheckButton(Composite parent, String label) {
			Button button = new Button(parent, SWT.CHECK | SWT.LEFT);
			button.setText(label);
			button.addSelectionListener(this);
			button.setLayoutData( new GridData());
			return button;
		}
		
		
		public void performOk(IProgressMonitor monitor) {
			boolean update = false;
			String path = handler.getCurrentChoice() == null ? null : handler.getProjectErikaEnterpriseLocation();
			boolean path_diffs = path == null ? oldPath != null : !path.equals(oldPath);
			
			if (monitor.isCanceled()) return; // stop everything???
			if (newEnableInclude) {
				if (oldEnableInclude && path_diffs ) { // remove old
					update |= EELocationLinkVar.removeEEIncludePaths(project, oldPath);
					if (monitor.isCanceled()) return; // stop everything???
				}
				if (!oldEnableInclude || path_diffs ) { 
					update |= EELocationLinkVar.setEEIncludePaths(project, path);
					if (monitor.isCanceled()) return; // stop everything???
				}
				
			} else if (!newEnableInclude && oldEnableInclude) {
				update |= EELocationLinkVar.removeEEIncludePaths(project, oldPath);
			}
			oldEnableInclude = newEnableInclude;
			oldPath = path;
			
			if (monitor.isCanceled()) return; // stop everything???
			
			if (newEnableSources) {
				if (!oldEnableSources) {
					update |= EELocationLinkVar.setEESourcePaths(project);
					if (monitor.isCanceled()) return; // stop everything???
				} else {
					update |= path_diffs;
				}
			} else if (!newEnableSources && oldEnableSources) {
				update |= EELocationLinkVar.removeEESourcePaths(project);
				if (monitor.isCanceled()) return; // stop everything???
			}
			oldEnableSources = newEnableSources;
			
			
			try {
				
				if (update) {
					CCorePlugin.getDefault().updateProjectDescriptions(new IProject[] {project}, monitor);
					project.refreshLocal(IResource.DEPTH_INFINITE, monitor); // update the content of link folders
					EELocationLinkVar.reindex(project);
				}
			} catch (CoreException e) {
				RtdruidLog.log(e);
			}
		}
		
		public void performDefaults() {
			
			includeButton.setSelection(false);
			sourceButton.setSelection(false);
			
		}
	}

    /**
     * Current project
     */
    private IProject project;
    
    

	protected ErikaEnterpriseLocationProjectHandler handler;
	protected ErikaSourcesPreferenceBody body;
    protected ErikaLinksBody elb;
    protected Button useProjectPref;
    
	public EELocationProjectProperties() {
		super();
	}
	
	protected void init() {
	    // nothing to do if project is null
	    if (project == null) {
	        return;
	    }
	    
	    handler = new ErikaEnterpriseLocationProjectHandler(project);
	    body = new ErikaSourcesPreferenceBody(handler.getWorkingCopy());
	    body.addListener(this);
	    
		elb = new ErikaLinksBody(handler);

	}
	
	@Override
	public void dispose() {
		super.dispose();
		if (body != null) 
			body.removeListener(this);
	}
	
		
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE | SWT.FLAT);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.makeColumnsEqualWidth = false;
        layout.marginHeight = 10;
        layout.marginWidth = 10;
		layout.horizontalSpacing = 5;
		layout.verticalSpacing = 5;
		composite.setLayout(layout);

		if (project == null || !project.isOpen()) {
			contentForClosedProject(composite);
		} else {
			contentForCProject(composite);
		}

		return composite;
	}

	private void contentForCProject(Composite parent) {
		
		boolean enableProjSpecs = handler.getCurrentChoice() != null;

		{
			Composite composite = new Composite(parent, SWT.NONE | SWT.FLAT);
			GridLayout layout = new GridLayout();
			layout.numColumns = 3;
			layout.makeColumnsEqualWidth = false;
	        layout.marginHeight = 0;
	        layout.marginWidth = 0;
			layout.horizontalSpacing = 5;
			layout.verticalSpacing = 5;
			composite.setLayout(layout);
			composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
			
			useProjectPref = new Button(composite, SWT.CHECK);
			useProjectPref.setText("Enable project specific settings");
			useProjectPref.setLayoutData(new GridData());
	        useProjectPref.setSelection(enableProjSpecs); 
			useProjectPref.addSelectionListener(new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					doSelect(e);
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					doSelect(e);
				}
				
				protected void doSelect(SelectionEvent e) {
					boolean selection = ((Button)e.getSource()).getSelection();
					body.enableAll(selection);

					handler.setProjectValues(selection);
					enableOk();
				}
			});

			{
				Label filler = new Label(composite, SWT.NONE);
				filler.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
			}
			
			Link link= new Link(composite, SWT.NONE);
			link.setText("<a>Configure Workspace Settings ...</a>");
			link.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					openStaticImportFavoritesPage();
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					openStaticImportFavoritesPage();
				}
			});
			
			link.setLayoutData(new GridData());
			

		}
		
		{
			Control bodyC = body.createContents(parent);
			bodyC.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			body.enableAll(enableProjSpecs);
		}
		
		
		{ // links
			{
				Label filler = new Label(parent, SWT.NONE);
				filler.setLayoutData(new GridData());	
			}

			elb.createContents(parent);
		}

		enableOk();
	}
	
	
	private void contentForClosedProject(Composite parent) {
		//Label label = new Label(parent, SWT.LEFT);
		//label.setText("Label text");

		noDefaultAndApplyButton();
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

	public boolean performOk() {
		
		boolean answer = handler.saveStore();

		final IStatus[] errorStatus = new IStatus[1];
		errorStatus[0] = Status.OK_STATUS;

		if (answer) {
			final WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
				protected void execute(IProgressMonitor monitor)
						throws CoreException {
	
					elb.performOk(monitor);
				}
			};
			WorkspaceJob job = new WorkspaceJob("refresh") { //$NON-NLS-1$
	
				public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
					try {
						op.run(monitor);
					} catch (InvocationTargetException e) {
						RtdruidLog.log(e);
					} catch (InterruptedException e) {
						return Status.CANCEL_STATUS;
					}
					return errorStatus[0];
				}
			};
			
			ISchedulingRule rule = op.getRule();
			if (rule != null) {
				job.setRule(rule);
			}
			job.setUser(true);
			job.schedule();

		} else {
			errorStatus[0] = Status.CANCEL_STATUS;
		}
		
		
		return errorStatus[0]==Status.OK_STATUS;
	}
	
	/* (non-Javadoc)
     * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
     */
    protected void performDefaults() {
        super.performDefaults();

        body.performDefaults(); // note: this function also updates the handler
        
        boolean enableProjSpecs = handler.getCurrentChoice() != null;
        body.enableAll(enableProjSpecs);
        useProjectPref.setSelection(enableProjSpecs);
        
        elb.performDefaults();
        enableOk();
    }
	
	/* (non-Javadoc)
     * @see org.eclipse.ui.dialogs.PropertyPage#setElement(org.eclipse.core.runtime.IAdaptable)
     */
    public void setElement(IAdaptable element) {
        super.setElement(element);
		if (element instanceof IProject) {
			project = (IProject) element;
		} else if (element instanceof ICProject) {
			project = ((ICProject) element).getProject();
		}
        
        init();
    }

    
	protected final void openStaticImportFavoritesPage() {
		PreferencesUtil.createPreferenceDialogOn(getShell(), IOPPConstants.EE_LOCATION_PREFERENCE_PAGE_ID, null, null).open();
	}

	@Override
	public void somethingChanged() {
		enableOk();
	}
}
