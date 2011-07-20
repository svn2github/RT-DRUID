package com.eu.evidence.rtdruid.modules.oil.cdt.ui.project;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.eclipse.ui.INewWizard;
import org.osgi.framework.Version;

public class RTDOilProjectWizardProxy implements IExecutableExtensionFactory {
	
	public Object create() throws CoreException {
		INewWizard wiz;
		Version cdt_ver = RTDOilProjectNature.CURRENT_CDT_VERS;
		if (cdt_ver == RTDOilProjectNature.CDT_VERS_34
				|| cdt_ver == RTDOilProjectNature.CDT_VERS_LESS_THAN_34) {

			wiz = new RTDOilProjectWizard();
		} else {
			wiz = new RTDOilProjectWizardNew();
		}
		return wiz;
	}
}
