/*
 * Created on 22-giu-2005
 *
 * $Id: RTDNiosProjectNature.java,v 1.4 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.cdt.ui.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;

import org.eclipse.cdt.core.CCorePlugin;
import org.eclipse.cdt.core.model.CoreModel;
import org.eclipse.cdt.core.settings.model.COutputEntry;
import org.eclipse.cdt.core.settings.model.ICBuildSetting;
import org.eclipse.cdt.core.settings.model.ICConfigurationDescription;
import org.eclipse.cdt.core.settings.model.ICOutputEntry;
import org.eclipse.cdt.core.settings.model.ICProjectDescription;
import org.eclipse.cdt.make.core.MakeBuilder;
import org.eclipse.cdt.make.core.MakeCorePlugin;
import org.eclipse.cdt.managedbuilder.core.IBuilder;
import org.eclipse.cdt.managedbuilder.core.IConfiguration;
import org.eclipse.cdt.managedbuilder.core.IMultiConfiguration;
import org.eclipse.cdt.managedbuilder.core.IToolChain;
import org.eclipse.cdt.managedbuilder.core.ManagedBuildManager;
import org.eclipse.cdt.managedbuilder.core.ManagedBuilderCorePlugin;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Version;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.cygwin.MyMakeBuilder;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.cygwin.MyMakeBuilder.MyMakeEclipseRelativePath;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.cygwin.MyMakeBuilder.MyMakePath;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.location.ErikaEnterpriseLocationProjectHandler;

/**
 * A class that implements an Oil Project
 * 
 * @author Nicola Serreli
 */
public class RTDOilProjectNature implements IProjectNature {

	private IProject fProject;

	public final static String NATURE_ID = "com.eu.evidence.rtdruid.oil.niossupport.natureID";

	public final static Version CDT_VERS_LESS_THAN_34 = new Version("4.0");
	public final static Version CDT_VERS_MORE_THAN_36 = new Version("6.0");
	public final static Version CDT_VERS_UNKNOWN = Version.emptyVersion;
	
	public final static Version CDT_VERS_34 = new Version("5.0");
	public final static Version CDT_VERS_35 = new Version("5.1");
	public final static Version CDT_VERS_36 = new Version("5.2");
	
	public final static Version CURRENT_CDT_VERS;
	public final static String V_OLD_KEY_BUILD_LOCATION;
	public final static String V_OLD_KEY_BUILD_COMMAND;
	public final static String V_OLD_KEY_BUILD_ID;

//	public final static String V_NEW_KEY_BUILD_LOCATION;
//	public final static String V_NEW_KEY_BUILD_COMMAND;
//	public final static String V_NEW_KEY_BUILD_ID;

	
	static {
		
		Version v = Version.emptyVersion;
		try {
			// init CDT keywords
			// = CCorePlugin.getDefault().getBundle().getVersion();
			Dictionary<String, String> dict = CCorePlugin.getDefault().getBundle().getHeaders();
			Object version = dict.get("Bundle-Version");
			if (version instanceof Version) {
				v = (Version) version;
			} else {
				v = Version.parseVersion("" + version);
			}
		} catch (Throwable e){
			RtdruidLog.log(e);
		}

		if (v.getMajor() == CDT_VERS_34.getMajor() && v.getMinor() == CDT_VERS_34.getMinor()) {
			v = CDT_VERS_34;
		} else if (v.getMajor() == CDT_VERS_35.getMajor() && v.getMinor() == CDT_VERS_35.getMinor()) {
			v = CDT_VERS_35;
		} else if (v.getMajor() == CDT_VERS_36.getMajor() && v.getMinor() == CDT_VERS_36.getMinor()) {
			v = CDT_VERS_36;
		} else if (v.getMajor() < CDT_VERS_34.getMajor()) {
			v = CDT_VERS_LESS_THAN_34;
		} else if (
				((v.getMajor() == CDT_VERS_36.getMajor() ) 
				|| ((v.getMajor() == CDT_VERS_36.getMajor() && v.getMinor() > CDT_VERS_36.getMinor())))) {
			v = CDT_VERS_MORE_THAN_36;
		} else {
			v = CDT_VERS_UNKNOWN;
		}
		CURRENT_CDT_VERS = v;
		//if (CURRENT_CDT_VERS == CDT_VERS_34) 
		{
			V_OLD_KEY_BUILD_LOCATION  = MakeCorePlugin.getUniqueIdentifier()+".build.location";
			V_OLD_KEY_BUILD_COMMAND = MakeCorePlugin.getUniqueIdentifier()+".build.command";
			V_OLD_KEY_BUILD_ID = MakeBuilder.BUILDER_ID;
		} //else 
//		{
//			V_NEW_KEY_BUILD_COMMAND = MakeCorePlugin.getUniqueIdentifier()+".buildCommand";
//			V_NEW_KEY_BUILD_LOCATION  = MakeCorePlugin.getUniqueIdentifier()+".buildLocation";
//			V_NEW_KEY_BUILD_ID = ManagedBuilderCorePlugin.getUniqueIdentifier() + ".genmakebuilder"; 
//		}

	}
	
	/**
	 * Utility method for adding a nature to a project.
	 * 
	 * @param proj
	 *            the project to add the nature
	 * @param monitor
	 *            a progress monitor to indicate the duration of the operation,
	 *            or <code>null</code> if progress reporting is not required.
	 *  
	 */
	public static void addNature(IProject project, IProgressMonitor monitor)
			throws CoreException {
		IProjectDescription description = project.getDescription();
		String[] prevNatures = description.getNatureIds();
		for (int i = 0; i < prevNatures.length; i++) {
			if (NATURE_ID.equals(prevNatures[i]))
				return;
		}
		String[] newNatures = new String[prevNatures.length + 1];
		System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
		newNatures[prevNatures.length] = NATURE_ID;
		description.setNatureIds(newNatures);
		project.setDescription(description, monitor);
	}

	/**
	 * Utility method for removing a project nature from a project.
	 * 
	 * @param proj
	 *            the project to remove the nature from
	 * @param monitor
	 *            a progress monitor to indicate the duration of the operation,
	 *            or <code>null</code> if progress reporting is not required.
	 */
	public static void removeNature(IProject project, IProgressMonitor monitor)
			throws CoreException {
		IProjectDescription description = project.getDescription();
		String[] prevNatures = description.getNatureIds();
		List<String> newNatures = new ArrayList<String>(Arrays.asList(prevNatures));
		newNatures.remove(NATURE_ID);
		description.setNatureIds((String[]) newNatures
				.toArray(new String[newNatures.size()]));
		project.setDescription(description, monitor);
	}

	/**
	 *  
	 */
	public RTDOilProjectNature() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#configure()
	 */
	public void configure() throws CoreException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#deconfigure()
	 */
	public void deconfigure() throws CoreException {
	}

	/**
	 * @see IProjectNature#getProject
	 */
	public IProject getProject() {
		return fProject;
	}

	/**
	 * @see IProjectNature#setProject
	 */
	public void setProject(IProject project) {
		fProject = project;
	}

	// --------------------------------------------------

	/**
	 * Get a Builder command from the build spec (return null if specified
	 * buildID doesn't existing).
	 */
	public static ICommand getBuildSpec(IProject project, String builderID)
			throws CoreException {
		IProjectDescription description = project.getDescription();
		ICommand[] commands = description.getBuildSpec();
		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].getBuilderName().equals(builderID)) {
				return commands[i];
			}
		}
		return null;
	}

	/**
	 * Update the Builder command in the build spec (replace existing one if
	 * present, add one first if none).
	 */
	public static void setBuildSpec(IProject project, ICommand newCommand)
			throws CoreException {

		IProjectDescription description = project.getDescription();
		ICommand[] oldCommands = description.getBuildSpec();
		ICommand oldCommand = getBuildSpec(project, newCommand.getBuilderName());
		ICommand[] newCommands;

		if (oldCommand == null) {
			// Add a build spec before other builders
			newCommands = new ICommand[oldCommands.length + 1];
			System
					.arraycopy(oldCommands, 0, newCommands, 1,
							oldCommands.length);
			newCommands[0] = newCommand;
		} else {
			for (int i = 0, max = oldCommands.length; i < max; i++) {
				if (oldCommands[i].getBuilderName().equals(
						oldCommand.getBuilderName())) {
					oldCommands[i] = newCommand;
					break;
				}
			}
			newCommands = oldCommands;
		}

		// Commit the spec change into the project
		description.setBuildSpec(newCommands);
		project.setDescription(description, null);
	}
	
	/**
	 * Set CDT work folder
	 */
	public static void setCDTOutputFolder(IProject project, String newFolder) throws CoreException {
		
		if (newFolder == null) {
			return;
		}
		
		final boolean old_style = ManagedBuilderCorePlugin.getDefault().isOldStyleMakeProject(project);
		
		//if (CURRENT_CDT_VERS == CDT_VERS_34) {
		if (old_style) {
		
		
		    IProjectDescription description = project.getDescription();
			ICommand[] commands = description.getBuildSpec();
			
			for (int i=0; i<commands.length; i++) {
				if (commands[i].getBuilderName().equals(V_OLD_KEY_BUILD_ID)) {
					Map<String, String> arguments = commands[i].getArguments();
					final String key = V_OLD_KEY_BUILD_LOCATION;
		
					// always enabled
	//				if (arguments.containsKey(key)
	//						&& !newFolder.equals(arguments.get(key))) {
						arguments.put(key, newFolder);
						commands[i].setArguments(arguments);
						description.setBuildSpec(commands);
						project.setDescription(description, null);
	//				}
					return;
				}
			}	
		} else {
			
			ICProjectDescription cpd = CCorePlugin.getDefault().getProjectDescription(project, true);
			ICConfigurationDescription[] cpds = cpd.getConfigurations();
			for (ICConfigurationDescription cc : cpds) {
				ICBuildSetting bset = cc.getBuildSetting();
				COutputEntry output = new COutputEntry(newFolder, new IPath[0], 0);
				bset.setOutputDirectories(new ICOutputEntry[] {output});
			
			}
			CCorePlugin.getDefault().setProjectDescription(project, cpd);
			
			EELocationLinkVar.setEEIncludePaths(project, null);
		}
	}
	
	
	
	
	/**
	 * Set CDT work folder
	 */
	public static void setCDTWorkFolder(IProject project, String newFolder) throws CoreException {
		
		if (newFolder == null) {
			return;
		}
		
		final boolean old_style = ManagedBuilderCorePlugin.getDefault().isOldStyleMakeProject(project);
		
		//if (CURRENT_CDT_VERS == CDT_VERS_34) {
		if (old_style) {
		
		
		    IProjectDescription description = project.getDescription();
			ICommand[] commands = description.getBuildSpec();
			
			for (int i=0; i<commands.length; i++) {
				if (commands[i].getBuilderName().equals(V_OLD_KEY_BUILD_ID)) {
					Map<String, String> arguments = commands[i].getArguments();
					final String key = V_OLD_KEY_BUILD_LOCATION;
		
					// always enabled
	//				if (arguments.containsKey(key)
	//						&& !newFolder.equals(arguments.get(key))) {
						arguments.put(key, newFolder);
						commands[i].setArguments(arguments);
						description.setBuildSpec(commands);
						project.setDescription(description, null);
	//				}
					return;
				}
			}	
		} else {
			
			ICProjectDescription cpd = CCorePlugin.getDefault().getProjectDescription(project, true);
			ICConfigurationDescription[] cpds = cpd.getConfigurations();
			for (ICConfigurationDescription cc : cpds) {
				ICBuildSetting bset = cc.getBuildSetting();
				bset.setBuilderCWD(new Path(newFolder));
				
			}
			CCorePlugin.getDefault().setProjectDescription(project, cpd);
			
			
			
		}
/*		
		ICDescriptor descriptor = CCorePlugin.getDefault().getCProjectDescription(project, false);
		if (descriptor == null) {
			return;
		}
		
		Element element = descriptor.getProjectData("org.eclipse.cdt.core.pathentry");
*/
	}
	
	/**
	 * Set CDT work folder
	 */
	public static void addRtduidBuildConfiguration(IProject project, String outputFolder) throws CoreException {
		
		if (outputFolder == null) {
			outputFolder = project.getFullPath().toOSString();
		}
		
		final boolean old_style = ManagedBuilderCorePlugin.getDefault().isOldStyleMakeProject(project);
		
		//if (CURRENT_CDT_VERS == CDT_VERS_34) {
		if (!old_style) {
			ICProjectDescription cpd = CCorePlugin.getDefault().getProjectDescription(project, true);
			ICConfigurationDescription rtdConf;
			
			{ // first step
				rtdConf = cpd.createConfiguration("com.eu.evidence.rtdruid.code_gen.defaultconf", "RT-Druid", cpd.getActiveConfiguration());
				cpd.setActiveConfiguration(rtdConf);
				
				ICBuildSetting bset = rtdConf.getBuildSetting();
				bset.setBuilderCWD(new Path(outputFolder));
				COutputEntry output = new COutputEntry(outputFolder, new IPath[0], 0);
				bset.setOutputDirectories(new ICOutputEntry[] {output});
				
	    		IConfiguration icfg = ManagedBuildManager.getConfigurationForDescription(rtdConf);
	    		IToolChain tool = icfg.getToolChain();
	    		if (tool != null) {
	    			IBuilder builder = tool.getBuilder();
	    			if (builder != null) {
	    				builder.setManagedBuildOn(false);
	    			}
	    		}
				
				// set ProjectDescription (it is used later to build the "make command")
				CCorePlugin.getDefault().setProjectDescription(project, cpd);
			}
			
			{ // second step
				String newCommand;
				{
			    	MyMakeBuilder myMakeBuilder = new MyMakeBuilder(project, null);
			    	MyMakePath mmp = myMakeBuilder.getLocation();
			    	newCommand = mmp instanceof MyMakeEclipseRelativePath ? 
			    			((MyMakeEclipseRelativePath) mmp).fsPath : mmp.osPath;
			    			
			    	if (Platform.OS_WIN32.equals(Platform.getOS())) {
	//		    	        	if (newCommand.indexOf(' ')>-1) {
		        		newCommand = '\"' + newCommand + '\"';
		        	}
	
				}

	    		IConfiguration icfg = ManagedBuildManager.getConfigurationForDescription(rtdConf);
	
	    		if (icfg instanceof IMultiConfiguration) {
	    			IConfiguration[] cfs = (IConfiguration[])((IMultiConfiguration)icfg).getItems();
	    			for (int i=0; i<cfs.length; i++) {
	    				IBuilder b = cfs[i].getEditableBuilder();
	    				b.setCommand(newCommand);
	    			}
	    		} else {
	    			icfg.getEditableBuilder().setCommand(newCommand);
	    		}
    		
	    		CCorePlugin.getDefault().setProjectDescription(project, cpd);
			}
		}
	}

	
	/**
	 * Set CDT work folder
	 */
	public static void setCDTBuildCommand(IProject project, String newCommand) throws CoreException {
		
		if (newCommand == null) {
	    	MyMakeBuilder myMakeBuilder = new MyMakeBuilder(project, null);
	    	MyMakePath mmp = myMakeBuilder.getLocation();
	    	newCommand = mmp instanceof MyMakeEclipseRelativePath ? 
	    			((MyMakeEclipseRelativePath) mmp).fsPath : mmp.osPath;
	    			
	    	if (Platform.OS_WIN32.equals(Platform.getOS())) {
//	    	        	if (newCommand.indexOf(' ')>-1) {
        		newCommand = '\"' + newCommand + '\"';
        	}

		}
    			

    	final boolean old_style = ManagedBuilderCorePlugin.getDefault().isOldStyleMakeProject(project);
		
		//if (CURRENT_CDT_VERS == CDT_VERS_34) {
		if (old_style) {
			
		    IProjectDescription description = project.getDescription();
			ICommand[] commands = description.getBuildSpec();
			
			for (int i=0; i<commands.length; i++) {
				if (commands[i].getBuilderName().equals(V_OLD_KEY_BUILD_ID)) {
					Map<String, String> arguments = commands[i].getArguments();
					{	final String key= V_OLD_KEY_BUILD_COMMAND;
											
						if (arguments.containsKey(key)
								&& !newCommand.equals(arguments.get(key))) {
							arguments.put(key, newCommand);
							commands[i].setArguments(arguments);
							description.setBuildSpec(commands);
							project.setDescription(description, null);
						}
					}
					{
						final String key = MakeCorePlugin.getUniqueIdentifier()+".useDefaultBuildCmd";
						
						if (arguments.containsKey(key)
								&& !newCommand.equals(arguments.get(key))) {
							arguments.put(key, "false");
							commands[i].setArguments(arguments);
							description.setBuildSpec(commands);
							project.setDescription(description, null);
						}
					}
					return;
				}
			}	
   			
   		} else {


    		ICProjectDescription cpd = CoreModel.getDefault().getProjectDescription(project);
    		ICConfigurationDescription[] cfgdv = cpd.getConfigurations();
    		for (ICConfigurationDescription cfgd : cfgdv) {
	    		IConfiguration icfg;
	   			icfg = ManagedBuildManager.getConfigurationForDescription(cfgd);
	
	    		if (icfg instanceof IMultiConfiguration) {
	    			IConfiguration[] cfs = (IConfiguration[])((IMultiConfiguration)icfg).getItems();
	    			for (int i=0; i<cfs.length; i++) {
	    				IBuilder b = cfs[i].getEditableBuilder();
	    				b.setCommand(newCommand);
	    			}
	    		} else {
	    			icfg.getEditableBuilder().setCommand(newCommand);
	    		}
	    		CCorePlugin.getDefault().setProjectDescription(project, cpd);
    		}
   		}
    	
	}

	
	/**
	 * Get the output folder setted inside the CDT options 
	 */
	public static String getCDTWorkFolder(IProject project) {
		
		try {
	
			final boolean old_style = ManagedBuilderCorePlugin.getDefault().isOldStyleMakeProject(project);
			
			//if (CURRENT_CDT_VERS == CDT_VERS_34) {
			if (old_style) {
			    IProjectDescription description = project.getDescription();
				ICommand[] commands = description.getBuildSpec();
				
				for (int i=0; i<commands.length; i++) {
					if (commands[i].getBuilderName().equals(V_OLD_KEY_BUILD_ID)) {
						Map<String, String> arguments = commands[i].getArguments();
						
						if (arguments.containsKey(V_OLD_KEY_BUILD_LOCATION)) {
							return arguments.get(V_OLD_KEY_BUILD_LOCATION);
						}
					}
				}
			} else {
				
				ICProjectDescription cpd = CCorePlugin.getDefault().getProjectDescription(project, false);
				if (cpd != null) {
					ICConfigurationDescription[] cpds = cpd.getConfigurations();
								
					for (ICConfigurationDescription cc : cpds) {
						if (cc.isActive()) {
							ICBuildSetting bset = cc.getBuildSetting();
					
							ICOutputEntry[] outputs = bset.getOutputDirectories();
							if (outputs.length >0) {
			//					cc.getConfigurationData()
			//					cc.getChildSettings()
								IPath loc  = outputs[0].getLocation();
								IPath full = outputs[0].getFullPath();
						
//								System.out.println("loc  " + loc);
//								System.out.println("full " + full);
						
						
								return "" + full;
							}
							// else
							return "" +bset.getBuilderCWD();
						}
					}
				} {
					return "/"+project.getFullPath()+"/output";
				}
				
			}

	
			return null;
/*		
		ICDescriptor descriptor = CCorePlugin.getDefault().getCProjectDescription(project, false);
		if (descriptor == null) {
			return;
		}
		
		Element element = descriptor.getProjectData("org.eclipse.cdt.core.pathentry");
*/		
		} catch (CoreException e) {
			return null;
		}
	}
	
	
	public static boolean usesGlobalEELocation(IProject project) {
		return (new ErikaEnterpriseLocationProjectHandler(project)).getCurrentChoice() == null; 
	}

}