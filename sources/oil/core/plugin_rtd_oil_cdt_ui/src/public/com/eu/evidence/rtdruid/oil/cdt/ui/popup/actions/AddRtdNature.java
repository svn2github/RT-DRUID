package com.eu.evidence.rtdruid.oil.cdt.ui.popup.actions;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.builder.OilBuilder;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.project.EELocationLinkVar;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.project.RTDOilProjectNature;

public class AddRtdNature implements IObjectActionDelegate {

	private Shell shell;
	private IProject project;
	
	/**
	 * Constructor for Action1.
	 */
	public AddRtdNature() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		if (project != null) {
			try {
				RTDOilProjectNature.addNature(project, null);
				IProjectDescription desc = project.getDescription();
			    ICommand command = desc.newCommand();
			    Map<String, String> attributes = new HashMap<String, String>();
			    attributes.put(OilBuilder.ATTR_CONFIG_FILES, "conf.oil");
			    command.setArguments(attributes);
			    command.setBuilderName(OilBuilder.BUILDER_ID);
			    RTDOilProjectNature.setBuildSpec(project, command);
			    RTDOilProjectNature.addRtduidBuildConfiguration(project, project.getFullPath().append("rtdruidOutput").toOSString());
			    EELocationLinkVar.setEEIncludePaths(project, null);
			} catch (CoreException e) {
				RtdruidLog.log(e);
			}
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		project = null;
		if (!(selection.isEmpty()) && selection instanceof IStructuredSelection) {
			Object o = ((IStructuredSelection) selection).getFirstElement();
			if (o instanceof IProject) {
				project = (IProject) o;
			}
		}
	}

}
