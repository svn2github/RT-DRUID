package com.eu.evidence.rtdruid.modules.oil.cdt.ui.project;

import java.io.File;
import java.net.URI;
import java.util.HashMap;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.variableresolvers.PathVariableResolver;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.variables.VariablesPlugin;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.location.EEBaseDynamicVariableResolver;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.location.ErikaEnterpriseLocationHandler.IEELocationListener;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.location.ErikaEnterpriseLocationProjectHandler.IEEProjectLocationListener;

public class ErikaEnterpriseProjectLocationLinkResolver extends
		PathVariableResolver implements IEELocationListener, IEEProjectLocationListener {
	
	public final static String LINK_VARIABLE_NAME = "ERIKA_ENTERPRISE_LOC";
	protected final static String EE_BASE_VARIABLE_NAME = EEBaseDynamicVariableResolver.DYNVAR_ERIKA_ENTERPRISE_LOCATION;

	/**
	 * This cache is shared among all instances of this resolved. This is
	 * required also to work together with the listeners of EE location changes
	 */
	protected static HashMap<IProject, String> cache = new HashMap<IProject, String>();

	public ErikaEnterpriseProjectLocationLinkResolver() {
	}
	

	public String[] getVariableNames(String variable, IResource resource) {
		return new String[] {LINK_VARIABLE_NAME};
	}


	@Override
	public String getValue(String variable, IResource resource) {
		if (LINK_VARIABLE_NAME.equalsIgnoreCase(variable)) {
			
			IProject project = resource != null ? resource.getProject() : null;

			if (cache.containsKey(project)) {
				return cache.get(project);
			}

			String query = "";
			if (resource == null) {
				query = "${"+EE_BASE_VARIABLE_NAME+"}";
			} else {
				query = "${"+EE_BASE_VARIABLE_NAME+":"+resource.getFullPath()+"}";
			}
			
			try {
				String value = VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution(query);
				if (value.length()>0) {
					File f = new File(value);
					URI uri = f.toURI();
					value = uri.toASCIIString();
				} // else

				cache.put(project, value);
				return value;
			} catch (CoreException e) {
				RtdruidLog.log(e);
				return null;
			}

		}
		return null;
	}
	
	@Override
	public int getPriority() {
		return 0;
	}

	@Override
	public void locationChanged(IProgressMonitor monitor) {
		// "global" settings may affect every project. clear the whole cache
		cache.clear();
	}
	
	@Override
	public void locationChanged(IProject project, IProgressMonitor monitor) {
		// clear cache for a specific project
		if (project != null) {
			cache.remove(project);
		}
	}
}
