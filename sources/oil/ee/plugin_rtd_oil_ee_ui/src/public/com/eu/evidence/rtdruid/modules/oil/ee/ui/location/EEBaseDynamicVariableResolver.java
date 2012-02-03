package com.eu.evidence.rtdruid.modules.oil.ee.ui.location;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.variables.IDynamicVariable;
import org.eclipse.core.variables.IDynamicVariableResolver;

import com.eu.evidence.rtdruid.modules.oil.ee.ui.Activator;

public class EEBaseDynamicVariableResolver implements IDynamicVariableResolver {

	public final static String DYNVAR_ERIKA_ENTERPRISE_LOCATION = "erika_enterprise_location"; 
	
	
	@Override
	public String resolveValue(IDynamicVariable variable, String argument)
			throws CoreException {
		String path = "";
		if (DYNVAR_ERIKA_ENTERPRISE_LOCATION.equalsIgnoreCase(variable.getName())) {
			if (argument == null || argument.length()==0) {
				path =  ErikaEnterpriseLocationHandler.getDefault().getGlobalErikaEnterpriseLocation();
			} else {
				boolean isValid = Path.EMPTY.isValidPath(argument);
				if (isValid) {
					
					IPath argP = new Path(argument);
				
					IWorkspace ws = ResourcesPlugin.getWorkspace();
//					IResource res = ws == null ? null : (ws.getRoot().exists(argP) ? ws.getRoot().findMember(argP) : ws.getRoot().getFolder(argP));
//					IProject prj = res == null ? null : res.getProject();
					IProject prj = ws == null || argP.segmentCount() == 0 ? null : ws.getRoot().getProject(argP.segment(0));
					
					if (prj == null || !prj.exists()) {
						throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, DYNVAR_ERIKA_ENTERPRISE_LOCATION + " dynamic variable only accpets a workspace path as argument"));
					}

					ErikaEnterpriseLocationProjectHandler handler = new ErikaEnterpriseLocationProjectHandler(prj);
					path = handler.getProjectErikaEnterpriseLocation();
					
				} else {
					throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, DYNVAR_ERIKA_ENTERPRISE_LOCATION + " dynamic variable only accpets a workspace path as argument"));
				}
			}
			if (path == null) {
				path = "";
			}
		}
		
//		if (path.length()>0) {
//			File f = new File(path);
//			URI uri = f.toURI();
//			return uri.toASCIIString();
//		} // else
		
		
		return path;
	}

}
