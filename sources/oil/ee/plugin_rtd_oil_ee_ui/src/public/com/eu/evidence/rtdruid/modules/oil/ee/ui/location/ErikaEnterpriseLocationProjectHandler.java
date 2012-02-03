package com.eu.evidence.rtdruid.modules.oil.ee.ui.location;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.location.ErikaEnterpriseLocationHandler.Choice;
import com.eu.evidence.rtdruid.modules.oil.ui.builder.OilBuilderParameters;

public class ErikaEnterpriseLocationProjectHandler {

	public interface IEEProjectLocationListener {
		public void locationChanged(IProject project, IProgressMonitor monitor);
	}
	
	static class LocalWoringCopy extends ErikaEnterpriseLocationContainer {
		final static String PROJECT_SPECIFIED_PATH = PREFIX + "project_specific_ee_location";
		
		final static List<String> parametersNames = Collections.unmodifiableList(
				Arrays.asList(new String[] {
					PROJECT_SPECIFIED_PATH,
					ENABLED,
					USER_SPECIFIED_PATH
		}));
		
		
		// -----------------------------------------------
		// -----------------  GET   ----------------------
		// -----------------------------------------------
		
		public boolean isProjectValues() {
			return store.containsKey(PROJECT_SPECIFIED_PATH) ?
					Boolean.parseBoolean(store.getProperty(PROJECT_SPECIFIED_PATH)) : false; 
		}
		
		@Override
		public String getChoosedErikaEnterpriseLocation() {
			if (isProjectValues()) {
				return super.getChoosedErikaEnterpriseLocation();
			}
			return ErikaEnterpriseLocationHandler.getDefault().getGlobalErikaEnterpriseLocation();
		}
		
		// -----------------------------------------------
		// -----------------  SET   ----------------------
		// -----------------------------------------------

		/**
		 * @param c
		 *            null means 'use workspace preferences', otherwise
		 *            identifies the user choice
		 * 
		 */
		@Override
		public void setCurrentChoice(Choice c) {
			setProjectValues(c != null);
			if (c != null) {
				super.setCurrentChoice(c);
			}
		}
		
		public void setProjectValues(boolean c) {
			store.setProperty(PROJECT_SPECIFIED_PATH, Boolean.toString(c));
		}
	}
	
	
	protected final IProject project;
	protected LocalWoringCopy container;
	protected String lastSavedPath = null;
	
	public ErikaEnterpriseLocationProjectHandler(IProject prj) {
		this.project = prj;
		
		reload();
	}
	
	public void reload() {
		container = new LocalWoringCopy();
		Properties store = container.getStore();
		OilBuilderParameters obp = new OilBuilderParameters(project);
		obp.getParameters(store);
		lastSavedPath = container.getChoosedErikaEnterpriseLocation();
	}
	
	public boolean saveStore() {
		Properties store = container.getStore();
		OilBuilderParameters obp = new OilBuilderParameters(project);
		
		if (obp.canSave()) {
			// check if something changed
			String newPath = container.getChoosedErikaEnterpriseLocation();
			boolean changed = lastSavedPath == null ? newPath != null : !lastSavedPath.equals(newPath);

			// save
			obp.setParameters(store, LocalWoringCopy.parametersNames);
			
			// notify changes
			if (changed) {
				lastSavedPath = newPath; 
				notifyListeners();
			}
			return true;
		}
		return false;
	}

	// -----------------------------------------------
	// -----------------  GET   ----------------------
	// -----------------------------------------------
	
	/**
	 * 
	 * @return null if the project follows the Workspace preferences, otherwise
	 *         returns the option choosed for this project
	 */
	public Choice getCurrentChoice() {
		if (container.isProjectValues()) {
			return container.getCurrentChoice();
		}
		return null;
	}

	public String getUserPath() {
		return container.getUserPath();
	}
	
	public String getProjectErikaEnterpriseLocation() {
		return container.getChoosedErikaEnterpriseLocation();
	}

	public IErikaEnterpriseLocationWorkingCopy getWorkingCopy() {
		return container;
	}
	
	// -----------------------------------------------
	// -----------------  SET   ----------------------
	// -----------------------------------------------
	
	/**
	 * 
	 * @param c
	 *            is null if this project follows Workspace preferences,
	 *            otherwise identifies the user's choice
	 */
	public void setCurrentChoice(Choice c) {
		container.setCurrentChoice(c);
	}

	public void setUserPath(String path) {
		container.setUserPath(path);
	}
	
	public void setProjectValues(boolean c) {
		container.setProjectValues(c);
	}

	// -----------------------------------------------
	// --------------  LISTENERS   -------------------
	// -----------------------------------------------

	protected static ListenerList listeners = loadDefaultListeners();

	public static void addListener(IEEProjectLocationListener l) {
		listeners.add(l);
	}
	public static void removeListener(IEEProjectLocationListener l) {
		listeners.remove(l);
	}

	private static ListenerList loadDefaultListeners() {

		ListenerList answer = new ListenerList();
		
		for (IConfigurationElement config : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						"com.eu.evidence.rtdruid.oil.ee.ui.erikaLocationListener")) {

			if ("projectListener".equals(config.getName())) {
				
				Object o = null;
		        try {
		            o = config.createExecutableExtension("class");
		        } catch (Exception e) {
					RtdruidLog.log("Unable to get the specified Erika Enterprise Location listener: " + 
							config.getAttribute("class"),
							e);
		        }
		        
		        // check if current tmpClass extend IAdapterFactoryLoader
		        if ( o != null) {
		        	if (o instanceof IEEProjectLocationListener) {
		        		answer.add(o);
		        	} else {
			        	RtdruidLog.log(new RuntimeException("The class " + config.getAttribute("class") + " isn't an IEELocationListener"));
		        	}
		        }
			}
		}

		return answer;
	}
	
	protected void notifyListeners() {
		
		final IStatus[] errorStatus = new IStatus[1];
		errorStatus[0] = Status.OK_STATUS;
		final WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
	           protected void execute(IProgressMonitor monitor) throws CoreException {
	        	   for (Object l: listeners.getListeners()) {
						try {
							((IEEProjectLocationListener) l).locationChanged(project, monitor);
						} catch (Exception e) {
							RtdruidLog.log(e);
						}
					}
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
		
	}


}
