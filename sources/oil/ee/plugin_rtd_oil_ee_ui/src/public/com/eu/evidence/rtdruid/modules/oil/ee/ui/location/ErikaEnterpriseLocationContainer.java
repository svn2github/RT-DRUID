package com.eu.evidence.rtdruid.modules.oil.ee.ui.location;

import java.util.List;
import java.util.Properties;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.variables.VariablesPlugin;

import com.eu.evidence.rtdruid.modules.oil.ee.ui.Activator;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.location.ErikaEnterpriseLocationHandler.Choice;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.location.EEPaths;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.location.EE_src_distr;

public class ErikaEnterpriseLocationContainer implements IErikaEnterpriseLocationWorkingCopy {
	final static String ERIKA_FILES_ENV_VARIABLE_ID = "ERIKA_FILES";

	final static String PREFIX = Activator.PLUGIN_ID + ".";

	final static String ENABLED = PREFIX + "enabled";

	final static String USER_SPECIFIED_PATH = PREFIX + "user_location";

	
	protected Properties initValues = null;
	protected Properties store = null;

	public ErikaEnterpriseLocationContainer() {
		this(null);
	}

	
	public ErikaEnterpriseLocationContainer(Properties prop) {
		initValues = new Properties();
		store = new Properties();
		if (prop != null) {
			initValues.putAll(prop);
			store.putAll(prop);
		}
	}
	
	
	Properties getStore() {
		return store;
	}
	
	

	// -----------------------------------------------
	// -----------------  GET   ----------------------
	// -----------------------------------------------
	
	public Choice getCurrentChoice() {
		String enabledID = store.containsKey(ENABLED) ? store.getProperty(ENABLED) : null;
		return Choice.getChoice(enabledID);
	}

	public String getUserPath() {
		return store.containsKey(USER_SPECIFIED_PATH) ? store.getProperty(USER_SPECIFIED_PATH) : "";
	}
	
	public static IStatus isValidUserPath(String path) {
		if (path.contains("${"+EEBaseDynamicVariableResolver.DYNVAR_ERIKA_ENTERPRISE_LOCATION+ "}") ||
				path.contains("${"+EEBaseDynamicVariableResolver.DYNVAR_ERIKA_ENTERPRISE_LOCATION+ ":") ) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "User path cannot contain references to " + EEBaseDynamicVariableResolver.DYNVAR_ERIKA_ENTERPRISE_LOCATION + " variable.");
		}
		
		try {
			path = VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution(path);
		} catch (CoreException e) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "User path is not valid: " + e.getMessage());
		}
		
		return new Status(IStatus.OK, Activator.PLUGIN_ID, path);
	}
	
	public String getResolvedUserPath() {
		IStatus status = isValidUserPath(getUserPath());
		if (status.isOK()) {
			return status.getMessage();
		}
		return "";
	}


	public String getConfigFileEeLocation() {
		String answer = "";
		List<EE_src_distr> paths = EEPaths.getAllEe_base();
		for (EE_src_distr path : paths) {
			if (path.reported_by == EE_src_distr.Reporter.RTD_CONFIGURATION && path.erikaFilesLocation != null) {
				answer = path.erikaFilesLocation;
				break; // stop at the first value
			}
		}
		return answer;
	}
	public String getPluginEeLocation() {
		String answer = "";
		List<EE_src_distr> paths = EEPaths.getAllEe_base();
		for (EE_src_distr path : paths) {
			if ( path.erikaFilesLocation != null &&
					(path.reported_by == EE_src_distr.Reporter.EXTPOINT_PLUGIN_SOURCES
					 || path.reported_by == EE_src_distr.Reporter.EXTPOINT_FILESYSTEM_SOURCES)) {
				answer = path.erikaFilesLocation;
				break; // stop at the first value
			}
		}
		return answer;
	}

	public String getErikaFilesEnv() {
		return System.getenv().containsKey(ERIKA_FILES_ENV_VARIABLE_ID) ? System.getenv().get(ERIKA_FILES_ENV_VARIABLE_ID) : "";
	}

	public String getAutoPath() {
		String answer = getErikaFilesEnv();
		answer = answer.length() > 0 ? answer : getConfigFileEeLocation();
		answer = answer.length() > 0 ? answer : getPluginEeLocation();
		return answer;
}

	public String getChoosedErikaEnterpriseLocation() {
		switch (getCurrentChoice()) {
			case AUTO: return getAutoPath();
			
			case USER_VALUE: return getResolvedUserPath();

			case ERIKA_FILES: return getErikaFilesEnv();

			case CONF_FILE: return getConfigFileEeLocation();
				
			case PLUGINS: return getPluginEeLocation();
		}
		return "";
	}
	
	// -----------------------------------------------
	// -----------------  SET   ----------------------
	// -----------------------------------------------
	
	public void setCurrentChoice(Choice c) {
		store.setProperty(ENABLED, c.toString());
	}

	public void setUserPath(String path) {
		if (path == null) {
			store.remove(USER_SPECIFIED_PATH);
		} else {
			store.setProperty(USER_SPECIFIED_PATH, path);
		}
	}

	@Override
	public void setDefaults() {
		store.clear();
	}

	
	public void reload() {
		store.putAll(initValues);
	}

}
