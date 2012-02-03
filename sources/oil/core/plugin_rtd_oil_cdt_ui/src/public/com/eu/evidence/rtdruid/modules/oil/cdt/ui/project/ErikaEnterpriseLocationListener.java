package com.eu.evidence.rtdruid.modules.oil.cdt.ui.project;

import java.util.LinkedList;

import org.eclipse.cdt.core.CCorePlugin;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.location.ErikaEnterpriseLocationHandler.IEELocationListener;

public class ErikaEnterpriseLocationListener implements IEELocationListener {
	
	public ErikaEnterpriseLocationListener() {
	}

	@Override
	public int getPriority() {
		return 10;
	}
	
	@Override
	public void locationChanged(IProgressMonitor monitor) {
		
		LinkedList<IProject> projects = new LinkedList<IProject>();
		for (IProject project: ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			try {
				if (project.isOpen() 
						&& project.hasNature(RTDOilProjectNature.NATURE_ID)
						&& RTDOilProjectNature.usesGlobalEELocation(project)) {
					projects.add(project);
				}
			} catch (CoreException e) {
				RtdruidLog.log(e);
			}
		}
		try {
			CCorePlugin.getDefault().updateProjectDescriptions(projects.toArray(new IProject[projects.size()]), monitor);
			for (IProject prj: projects) {
				if (monitor.isCanceled()) {
					return;
				}
				prj.touch(monitor); // is used to force the Project Browser to refresh the view
				prj.refreshLocal(IResource.DEPTH_INFINITE, monitor); // update the content of link folders
				EELocationLinkVar.reindex(prj); // ask cdt to re-index the project
			}
		} catch (CoreException e) {
			RtdruidLog.log(e);
		}
	
	}
}
