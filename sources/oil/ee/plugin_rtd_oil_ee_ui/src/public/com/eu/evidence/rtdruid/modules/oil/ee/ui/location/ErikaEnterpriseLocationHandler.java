package com.eu.evidence.rtdruid.modules.oil.ee.ui.location;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Properties;

import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.Activator;

public class ErikaEnterpriseLocationHandler {
	
	public interface IEELocationListener {
		/**
		 * Small values means high priority
		 * 
		 * @return
		 */
		public int getPriority();
		public void locationChanged(IProgressMonitor monitor);
	}
	
	protected static class ListenerComparator implements Comparator<IEELocationListener> {

		@Override
		public int compare(IEELocationListener o1, IEELocationListener o2) {
			return o1.getPriority() - o2.getPriority();
		}
		
	}
	
	
	public static enum Choice {
		AUTO("auto"), USER_VALUE("user_value"), CONF_FILE("configuration_file"), ERIKA_FILES("erika_files"), PLUGINS("plugins");
		
		protected final String value;
		private Choice(String s) {
			value = s;
		}
		
		public static Choice getChoice(String enabledID) {
			
			for (Choice c: values()) {
				if (c.value.equalsIgnoreCase(enabledID)) {
					return c;
				}
			}
			
			return AUTO;
		}
		
		@Override
		public String toString() {
			return value;
		}

	}
		
		
	protected static ErikaEnterpriseLocationHandler instance = null; 
	
	protected ErikaEnterpriseLocationContainer container = null;
	protected File storeFile = null;
	protected static LinkedList<IEELocationListener> listeners = loadDefaultListeners();
	
	
	public static ErikaEnterpriseLocationHandler getDefault() {
		if (instance == null) {
			instance = new ErikaEnterpriseLocationHandler();
		}
		return instance;
	}

	public static IErikaEnterpriseLocationWorkingCopy getWorkingCopy() {
		if (instance == null) {
			instance = new ErikaEnterpriseLocationHandler();
		}
		return new ErikaEnterpriseLocationContainer(instance.container.getStore());
	}

	protected ErikaEnterpriseLocationHandler() {
		container = new ErikaEnterpriseLocationContainer();
		initPreferenceStore();
		
	}
	
	private static LinkedList<IEELocationListener> loadDefaultListeners() {

		LinkedList<IEELocationListener> answer = new LinkedList<IEELocationListener>();

		for (IConfigurationElement config : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						"com.eu.evidence.rtdruid.oil.ee.ui.erikaLocationListener")) {

			if ("listener".equals(config.getName())) {
				
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
		        	if (o instanceof IEELocationListener) {
		        		answer.add((IEELocationListener) o);
		        	} else {
			        	RtdruidLog.log(new RuntimeException("The class " + config.getAttribute("class") + " isn't an IEELocationListener"));
		        	}
		        }
			}
		}
		
		Collections.sort(answer, new ListenerComparator());

		return answer;
	}

	protected void initPreferenceStore() {
		IPath path = Platform.getStateLocation(Activator.getDefault().getBundle());
		Properties store = container.getStore();
		if (path != null) {
			storeFile = new File (path + File.pathSeparator + "erika_location.properties");
			if (storeFile.exists() && storeFile.canRead() && storeFile.isFile()) {
				try {
					store.load(new FileInputStream(storeFile));
				} catch (FileNotFoundException e) {
					RtdruidLog.log(e);
				} catch (IOException e) {
					RtdruidLog.log(e);
				}
			}
		}
	}
	
	
	public boolean save(IErikaEnterpriseLocationWorkingCopy copy) {
		boolean answer = false;
		if (storeFile != null) {
			try {
				String oldPath = getGlobalErikaEnterpriseLocation();
				
				Properties prop = container.getStore(); 
				prop.clear();
				prop.putAll(((ErikaEnterpriseLocationContainer) copy).getStore());
				prop.store(new FileOutputStream(storeFile), "");
				answer = true;

				String newPath = getGlobalErikaEnterpriseLocation();

				boolean changed = oldPath == null ? newPath != null : !oldPath.equals(newPath); 
				if (changed) {
					notifyListeners();
				}
			} catch (FileNotFoundException e) {
				RtdruidLog.log(e);
			} catch (IOException e) {
				RtdruidLog.log(e);
			}
		}
		
		return answer;
	}

	// -----------------------------------------------
	// -----------------  GET   ----------------------
	// -----------------------------------------------

	public String getGlobalErikaEnterpriseLocation() {
		return container.getChoosedErikaEnterpriseLocation();
	}
	
	
	// -----------------------------------------------
	// --------------  LISTENERS  --------------------
	// -----------------------------------------------

	public static void addListener(IEELocationListener l) {
		if (!listeners.contains(l)) {
			listeners.add(l);
			Collections.sort(listeners, new ListenerComparator());
		}
	}
	public static void removeListener(IEELocationListener l) {
		listeners.remove(l);
	}

	
	protected void notifyListeners() {
		
		final IStatus[] errorStatus = new IStatus[1];
		errorStatus[0] = Status.OK_STATUS;
		final WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
	           protected void execute(IProgressMonitor monitor) throws CoreException {
	        	   for (IEELocationListener l: listeners) {
						try {
							l.locationChanged(monitor);
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