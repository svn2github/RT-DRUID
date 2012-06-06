package com.eu.evidence.rtdruid.modules.oil.cdt.ui.project;

import java.util.ArrayList;

import org.eclipse.cdt.core.CCorePlugin;
import org.eclipse.cdt.core.model.CoreModel;
import org.eclipse.cdt.core.model.ICProject;
import org.eclipse.cdt.core.settings.model.CIncludePathEntry;
import org.eclipse.cdt.core.settings.model.CSourceEntry;
import org.eclipse.cdt.core.settings.model.ICConfigurationDescription;
import org.eclipse.cdt.core.settings.model.ICFolderDescription;
import org.eclipse.cdt.core.settings.model.ICLanguageSetting;
import org.eclipse.cdt.core.settings.model.ICLanguageSettingEntry;
import org.eclipse.cdt.core.settings.model.ICProjectDescription;
import org.eclipse.cdt.core.settings.model.ICSettingEntry;
import org.eclipse.cdt.core.settings.model.ICSourceEntry;
import org.eclipse.cdt.managedbuilder.core.ManagedBuilderCorePlugin;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.location.EEBaseDynamicVariableResolver;

public class EELocationLinkVar {
	
	protected final static String EE_BASE_VARIABLE_NAME = EEBaseDynamicVariableResolver.DYNVAR_ERIKA_ENTERPRISE_LOCATION;
	protected final static String LINK_VARIABLE_NAME = ErikaEnterpriseProjectLocationLinkResolver.LINK_VARIABLE_NAME;
	

	public static void reindex(IProject prj) {
		ICProject c = CoreModel.getDefault().create(prj);
		if (c != null) {
			CCorePlugin.getIndexManager().reindex(c);
		}
	}

	/*
	 * 
	 * 
	 * Check Source and Include links
	 * 
	 * 
	 */
	public static boolean checkEEIncludePaths(IProject project, String basePath) {
		ICProjectDescription cpd = CCorePlugin.getDefault()
				.getProjectDescription(project, true);
		
		if (ManagedBuilderCorePlugin.getDefault().isOldStyleMakeProject(project) || cpd == null) {
			return false; // currently work only with new cdt projects
		}
		
		basePath = basePath == null ? "${"+EE_BASE_VARIABLE_NAME+"}" : basePath;
		
		final String ee_pkg_str = basePath + "/pkg";

		if (cpd != null) {
			ICConfigurationDescription[] cpds = cpd.getConfigurations();
			for (ICConfigurationDescription cc : cpds) {
			
				ICFolderDescription folderDescription = cc.getRootFolderDescription();
				ICLanguageSetting[] languageSettings = folderDescription.getLanguageSettings();
				for (ICLanguageSetting lang : languageSettings) {
					if (isValidLanguage(lang)) {

						ICLanguageSettingEntry[] includePathSettings = lang
								.getSettingEntries(ICSettingEntry.INCLUDE_PATH);
						for (ICLanguageSettingEntry entry : includePathSettings) {
							String val = entry.getValue();
						
							if (ee_pkg_str.equals(val)) {
								return true;
							}
						}
					}
	
				}
			}
		}

		return false; 
	}
	
	public static boolean checkEESourcePaths(IProject project) {
		ICProjectDescription cpd = CCorePlugin.getDefault()
				.getProjectDescription(project, true);
		
		if (ManagedBuilderCorePlugin.getDefault().isOldStyleMakeProject(project) || cpd == null) {
			return false; // currently work only with new cdt projects
		}
		
		IFolder link = project.getFolder("ErikaEnterprise");
		if (link.exists()) {
			IPath fullPath = link.getFullPath();
			
			ICConfigurationDescription[] cpds = cpd.getConfigurations();
			for (ICConfigurationDescription cc : cpds) {
				
				ICSourceEntry[] bset = cc.getSourceEntries();
				for (ICSourceEntry entry: bset) {
					if (fullPath.equals(entry.getFullPath())) {
						return true;
					}
				}
			}

		}
		return false;
	}

	
	/*
	 * 
	 * 
	 * Add Source and Include links
	 * 
	 * 
	 */
	public static boolean setEEIncludePaths(IProject project, String basePath) {
		String  output = RTDOilProjectNature.getCDTWorkFolder(project);
		return setEEIncludePaths(project, basePath, output);
	}

	public static boolean setEEIncludePaths(IProject project, String basePath, String output_folder) {
		ICProjectDescription cpd = CCorePlugin.getDefault()
				.getProjectDescription(project, true);
		
		if (ManagedBuilderCorePlugin.getDefault().isOldStyleMakeProject(project) || cpd == null) {
			return false; // currently work only with new cdt projects
		}
		
		boolean somethingChanged = false;
		
		basePath = basePath == null ? "${"+EE_BASE_VARIABLE_NAME+"}" : basePath;
		final String ee_pkg_str = basePath+ "/pkg";
		final String ee_contrib_str = basePath+ "/contrib";

		
		ICConfigurationDescription[] cpds = cpd.getConfigurations();
		for (ICConfigurationDescription cc : cpds) {
			
			ICFolderDescription folderDescription = cc.getRootFolderDescription();
			ICLanguageSetting[] languageSettings = folderDescription.getLanguageSettings();
			for (ICLanguageSetting lang : languageSettings) {
				if (isValidLanguage(lang)) {

					boolean ee_pkg = true;
					boolean ee_contrib = true;
					boolean ENABLE_DEBUG_DIR = output_folder != null;
					
					ICLanguageSettingEntry[] includePathSettings = lang
							.getSettingEntries(ICSettingEntry.INCLUDE_PATH);
					for (ICLanguageSettingEntry entry : includePathSettings) {
						String val = entry.getValue();
						
						if (ee_pkg_str.equals(val)) {
							ee_pkg = false;
						} else if (ee_contrib_str.equals(val)) {
							ee_contrib = false;
						} else if (output_folder != null && output_folder.equals(val)) {
							ENABLE_DEBUG_DIR = false;
						}
					}


					ICLanguageSettingEntry[] newIncludePathSettings = new ICLanguageSettingEntry[includePathSettings.length
							+ (ee_pkg ? 1 : 0)
							+ (ee_contrib ? 1 : 0)
							+ (ENABLE_DEBUG_DIR ? 1 : 0)];

					System.arraycopy(includePathSettings, 0,
							newIncludePathSettings, 0,
							includePathSettings.length);
					int pos = includePathSettings.length;
					if (ENABLE_DEBUG_DIR) {
						newIncludePathSettings[pos] = new CIncludePathEntry(
								output_folder, ICSettingEntry.BUILTIN
										| ICSettingEntry.READONLY
										| ICSettingEntry.VALUE_WORKSPACE_PATH);
						pos++;
					}
					if (ee_pkg) {
						newIncludePathSettings[pos] = new CIncludePathEntry(
								ee_pkg_str, ICSettingEntry.BUILTIN
										| ICSettingEntry.READONLY);
						pos++;
					}
					if (ee_contrib) {
						newIncludePathSettings[pos] = new CIncludePathEntry(
								ee_contrib_str, ICSettingEntry.BUILTIN
										| ICSettingEntry.READONLY);
						pos++;
					}

					lang.setSettingEntries(ICSettingEntry.INCLUDE_PATH,
							newIncludePathSettings);
					
					somethingChanged |= ENABLE_DEBUG_DIR || ee_pkg || ee_contrib; 
				}
			}

		}
		try {
			if (somethingChanged) {
				CCorePlugin.getDefault().setProjectDescription(project, cpd);
			}
		} catch (CoreException e) {
			RtdruidLog.log(e);
		}

		return somethingChanged; 
	}
	
	private static boolean isValidLanguage(ICLanguageSetting lang) {
		return true;
		/*if ("GNU C".equalsIgnoreCase(lang.getName())
		|| "C".equalsIgnoreCase(lang.getName())
		|| "C,c".equalsIgnoreCase(lang.getName())
		|| lang.getName().endsWith(" C")) */
	}
	
	public static boolean setEESourcePaths(IProject project) {
		ICProjectDescription cpd = CCorePlugin.getDefault()
				.getProjectDescription(project, true);
		
		if (ManagedBuilderCorePlugin.getDefault().isOldStyleMakeProject(project) || cpd == null) {
			return false; // currently work only with new cdt projects
		}
		
		boolean linkcreated = false;
		boolean sourcesUpdated = false;
		
		try {
			IFolder link = project.getFolder("ErikaEnterprise");
			IPath location = new Path(LINK_VARIABLE_NAME);
			IStatus st = project.getWorkspace().validateLinkLocation(link, location);
			if (!link.exists() && (st.isOK() || st.getSeverity() == IStatus.WARNING) ) {
				link.createLink(location, IResource.NONE, null);
				linkcreated = true;
			}
			
			if (link.exists()) {
				
				IPath fullPath = link.getFullPath();
				
				ICConfigurationDescription[] cpds = cpd.getConfigurations();
				for (ICConfigurationDescription cc : cpds) {
					boolean found = false;
					
					ICSourceEntry[] bset = cc.getSourceEntries();
					for (ICSourceEntry entry: bset) {
						if (fullPath.equals(entry.getFullPath())) {
							found = true;
							break;
						}
					}
					
					if (!found) {
						ICSourceEntry[] nset= new ICSourceEntry[bset.length +1];
						System.arraycopy(bset, 0, nset, 0, bset.length);
						nset[nset.length-1] = new CSourceEntry(link, new IPath[0], 0); 
						
						cc.setSourceEntries(nset);
						sourcesUpdated = true;
						
					}
					
				}
				
				if (sourcesUpdated) {
					CCorePlugin.getDefault().setProjectDescription(project, cpd);
					
				}
	
			} // else do nothing
		} catch (CoreException e) {
			RtdruidLog.log(e);
		}
		return linkcreated || sourcesUpdated;
	}

	
	/*
	 * 
	 * 
	 * Remove Source and Include links
	 * 
	 * 
	 */
	public static boolean removeEEIncludePaths(IProject project, String basePath) {
		String  output = RTDOilProjectNature.getCDTWorkFolder(project);
		return removeEEIncludePaths(project, basePath, output);
	}

	public static boolean removeEEIncludePaths(IProject project, String basePath, String output_folder) {
		ICProjectDescription cpd = CCorePlugin.getDefault()
				.getProjectDescription(project, true);
		
		if (ManagedBuilderCorePlugin.getDefault().isOldStyleMakeProject(project) || cpd == null) {
			return false; // currently work only with new cdt projects
		}
		
		boolean somethingChanged = false;
		
		basePath = basePath == null ? "${"+EE_BASE_VARIABLE_NAME+"}" : basePath;
		final String ee_pkg_str = basePath+ "/pkg";
		final String ee_contrib_str = basePath+ "/contrib";

		ICConfigurationDescription[] cpds = cpd.getConfigurations();
		for (ICConfigurationDescription cc : cpds) {
			
			ICFolderDescription folderDescription = cc.getRootFolderDescription();
			ICLanguageSetting[] languageSettings = folderDescription.getLanguageSettings();
			for (ICLanguageSetting lang : languageSettings) {
				if (isValidLanguage(lang)) {

					ArrayList<ICLanguageSettingEntry> newIncludePathSettings = new ArrayList<ICLanguageSettingEntry>();
					
					ICLanguageSettingEntry[] includePathSettings = lang
							.getSettingEntries(ICSettingEntry.INCLUDE_PATH);
					for (ICLanguageSettingEntry entry : includePathSettings) {
						String val = entry.getValue();
					
						
						if (ee_pkg_str.equals(val) || ee_contrib_str.equals(val) 
								|| (output_folder != null && output_folder.equals(val))) {
							somethingChanged = true;
						} else {
							newIncludePathSettings.add(entry);
						} 
					}

					lang.setSettingEntries(ICSettingEntry.INCLUDE_PATH,
							newIncludePathSettings);
				}
			}

		}
		try {
			if (somethingChanged) {
				CCorePlugin.getDefault().setProjectDescription(project, cpd);
			}
		} catch (CoreException e) {
			RtdruidLog.log(e);
		}

		return somethingChanged; 
	}
	
	public static boolean removeEESourcePaths(IProject project) {
		ICProjectDescription cpd = CCorePlugin.getDefault()
				.getProjectDescription(project, true);
		
		if (ManagedBuilderCorePlugin.getDefault().isOldStyleMakeProject(project) || cpd == null) {
			return false; // currently work only with new cdt projects
		}
		
		boolean linkdeleted = false;
		boolean sourcesUpdated = false;
		
		try {
			IFolder link = project.getFolder("ErikaEnterprise");
			IPath fullPath = link.getFullPath();
			{
				ICConfigurationDescription[] cpds = cpd.getConfigurations();
				for (ICConfigurationDescription cc : cpds) {
					int index = -1;
					
					ICSourceEntry[] bset = cc.getSourceEntries();
					for (int i=0; i< bset.length && index == -1; i++) {
						ICSourceEntry entry = bset[i];
						if (fullPath.equals(entry.getFullPath())) {
							index = i;;
						}
					}
					
					if (index != -1) {
						ICSourceEntry[] nset= new ICSourceEntry[bset.length -1];
						if (index != 0) {
							System.arraycopy(bset, 0, nset, 0, index);
						}
						if (index != nset.length) {
							System.arraycopy(bset, index+1, nset, index, nset.length-index);
						}
						
						cc.setSourceEntries(nset);
						sourcesUpdated = true;
						
					}
					
				}
				
				if (sourcesUpdated) {
					CCorePlugin.getDefault().setProjectDescription(project, cpd);
				}
			}
				
			if (link.exists()) {
				link.delete(true, new NullProgressMonitor());
				linkdeleted = true;
			}
				
		} catch (CoreException e) {
			RtdruidLog.log(e);
		}
		return linkdeleted || sourcesUpdated;
	}
}
