/*
 * Created on 21-giu-2005
 *
 * $Id: OilBuilder.java,v 1.19 2008/02/05 10:15:40 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.cdt.ui.builder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.io.IVTResource;
import com.eu.evidence.rtdruid.io.MultiSourceImporterFactory;
import com.eu.evidence.rtdruid.io.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.Rtd_oil_cdt_Plugin;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.cygwin.MyMakeBuilder;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.project.EELocationLinkVar;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.project.OilProjectProperties;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.project.RTDOilProjectNature;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.RtosFactory;
import com.eu.evidence.rtdruid.modules.oil.codewriter.options.OptionsManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.options.PreferenceStorage;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.location.ErikaEnterpriseLocationProjectHandler;
import com.eu.evidence.rtdruid.ui.common.RTDConsole;
import com.eu.evidence.rtdruid.ui.common.ResourceUtility;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.ObjectWithID;
import com.eu.evidence.rtdruid.vartree.tools.Mapping;
import com.eu.evidence.rtdruid.vartree.tools.Search;


/**
 * A builder, that parses an Oil file and writes all missing files for a C/C++
 * projects
 * 
 * @author Nicola Serreli
 */
public class OilBuilder extends IncrementalProjectBuilder {
    
//    final public static String ATTR_CONFIG_FILE = "ConfigFileName";
	final public static String ATTR_CONFIG_FILES = "ConfigFileName";
    
    final public static String BUILDER_ID =Rtd_oil_cdt_Plugin.PLUGIN_ID + ".oil_builder";
    
    
	/**
	 * Runs this builder in the specified manner. See parent class for more
	 * details
	 * 
	 * 
	 * @param kind
	 *            the kind of build being requested. Valid values are
	 *            <ul>
	 *            <li><code>FULL_BUILD</code>- indicates a full build.</li>
	 *            <li><code>INCREMENTAL_BUILD</code>- indicates an
	 *            incremental build.</li>
	 *            <li><code>AUTO_BUILD</code>- indicates an automatically
	 *            triggered incremental build (auto-building on).</li>
	 *            </ul>
	 * @param args
	 *            a table of builder-specific arguments keyed by argument name
	 *            (key type: <code>String</code>, value type:
	 *            <code>String</code>);<code>null</code> is equivalent to
	 *            an empty map
	 * @param monitor
	 *            a progress monitor, or <code>null</code> if progress
	 *            reporting and cancellation are not desired
	 * @return the list of projects for which this builder would like deltas the
	 *         next time it is run or <code>null</code> if none
	 * @exception CoreException
	 *                if this build fails.
	 * @see IProject#build(int, String, Map, IProgressMonitor)
	 */

    public IProject[] build(int kind, Map args, IProgressMonitor monitor)
          throws CoreException {
    	
    	/*
    	 * Enable the console 
    	 */
    	boolean outputEnable = false;
    	{
			RTDConsole console = RTDConsole.getConsole();
			if (console != null && console.getMessages() != null) {
				Messages.setCurrent(console.getMessages());
				Messages.clearNumbers();
				//console.clear();
				outputEnable = true;
			}
    	}

		try {
			
	       // add your build logic here
	        //System.err.println("Build \n\ttype = " + kind + "\n\targs = " + args);
	        
	        if (kind == AUTO_BUILD) {
//	            System.err.println(">> AUTO ");
	            if (getDelta(getProject()) == null) {
	            	(new DeltaBuilder()).fullBuild(monitor);
	            } else {
	            	(new DeltaBuilder()).incrementalBuild(getDelta(getProject()), monitor);
	            }
	        }
	        if (kind == FULL_BUILD) {
//	            System.err.println(">> FULL ");
	            (new DeltaBuilder()).fullBuild(monitor);
	        }
	        if (kind == INCREMENTAL_BUILD) {
//	            System.err.println(">> INCREMENTAL ");
	            (new DeltaBuilder()).incrementalBuild(getDelta(getProject()), monitor);
	        }
	        if (kind == CLEAN_BUILD) {
//	            System.err.println(">> CLEAN ");
	        }
		} catch (Exception e) {
			RtdruidLog.log(e);
			Messages.sendErrorNl(e.getMessage(), null, "ASDASDASD", null);
		} finally {
			if (outputEnable) {
				if (Messages.getErrorNumber() >0) {
					Messages.sendTextNl("\nThere are some Errors.\n");

					// force to build again all the next time
					//forgetLastBuiltState();

					// try to stop build (It's the best way?)
					if (monitor != null) {
						monitor.setCanceled(true);
					}

				} else if (Messages.getWarningNumber() >0) {
					Messages.sendTextNl("\nThere are some Warnings.\n");
				} else {
					Messages.sendTextNl("\nGood, it's all ok.\n");
				}
				Messages.setPrevious();
			}
	
		}
        
       return null;
    }
    protected void startupOnInitialize() {
       // add builder init logic here
        //System.err.println("Start up");
    }
    protected void clean(IProgressMonitor monitor) {
       // add builder clean logic here
        //System.err.println("Clean");
        
    	boolean outputEnable = false;
    	{
			RTDConsole console = RTDConsole.getConsole();
			if (console != null && console.getMessages() != null) {
				Messages.setCurrent(console.getMessages());
				Messages.clearNumbers();
				Messages.sendTextNl("Clear project " + getProject().getName());
				//console.clear();
				outputEnable = true;
			}
    	}
    	
    	try {
	        IProject project = getProject();
    		
    		
	        /* ------------ get the config file ------------ */
	        String[] configFiles = OilProjectProperties.getConfigFile(project);
	        
	        if (configFiles == null || configFiles.length == 0) {
	        	return;
	        }
	        
			if (!checkFiles(project, Arrays.asList(configFiles))) {
				// RtdruidLog.log("The project " + project.getName() +
				// " doesn't contains the RT-Druid config file " + configFile);
				return; // next
	        }
    		
    		
    		
	    	/*
	    	 * Disable output 
	    	 */
	    	{
				Messages.setCurrent(ProjectBuilder.NULL_OUTPUT);
	    	}
	    	IPath filePath = null;
	        try {
	            ArrayList<IPath> paths = new ArrayList<IPath>();
            	for (String configFile : configFiles) {
    	        	IFile file = project.getFile(configFile);
    	        	paths.add(file.getFullPath());
            	}

                
                // build internally the project
                IProjectBuilder builder = getProjectBuilder(paths.toArray(new IPath[paths.size()]), project);
		        builder.disableSignature(true);
		        filePath = builder.getOutputFolder();
	        } finally {
	        	//enable again output
	        	Messages.setPrevious();
	        }
	
	        if (filePath != null) {
	
				IResource res = project.getParent().findMember(filePath);
				
				if (res != null && res.getType() == IResource.FOLDER) {
					try {
						res.delete(IResource.NONE, monitor);
					} catch (CoreException e) {
						RtdruidLog.log(e);
					}
					Messages.sendTextNl("\tRemove the output folder " + filePath);
				} else if (res != null && res.getType() == IResource.PROJECT) {
					// cannot drop the project
					Messages.sendWarningNl("The output folder is a project. I cannot remove it ( " + filePath + ")", null, "ouewhroqiu", new Properties());
				}
	
	        }
	
        } finally {
        	//reset Console
        	if (outputEnable) {
        		Messages.setPrevious();
        	}
        }
        
        
    }
    
    // ------------------------- INCREMENTATL -------------------------

    protected class DeltaBuilder {
        protected HashMap<IProject, Set<String>> rebuild = new HashMap<IProject, Set<String>>();
        protected HashMap<IProject, Object> confBuffer = new HashMap<IProject, Object>();
        protected HashMap<IProject, Set<String>> visited = new HashMap<IProject, Set<String>>();
        
        //protected IProjectBuilder builder;// = getProjectBuilder();
        protected boolean rebuilded = false;
        
        protected class MyVisitor implements IResourceDeltaVisitor,
        	IResourceVisitor {
        	
            public boolean visit(IResource res) {
                //System.err.println(">>" + res);
                
                IProject project = res.getProject();
                Set<String> confFile;
                {
	                String[] tmp = getConfigFile(project);
	                if (tmp == null) {
	                	return true;
	                }
	                confFile = new LinkedHashSet<String>(Arrays.asList(tmp));
                }
                
                // if rebuild already contains this project, continue with the next resource
                //IProjectBuilder builder = getProjectBuilder();
                if (rebuild.containsKey(project) || confFile.size() == 0) {
                    return true;
                }
                
                
                
                boolean build = false;
                
                String resName = res.getProjectRelativePath().toString();
                build |= ".project".equals(resName);
                build |= ".cproject".equals(resName);
                
                
                
                build |= confFile.contains(resName);
                //System.err.println("\t>>rebuild = " + build);

                if (build) {
                	visited.remove(project);
                    rebuild.put(project, confFile);
                } else {
                	visited.put(project, confFile);
                }
                
                return true;
            }

            public boolean visit(IResourceDelta res) {
                return visit(res.getResource());
            }
         }
        
        public void incrementalBuild(IResourceDelta delta,
                IProgressMonitor monitor) throws CoreException {
            
            // check if is change something important
            delta.accept(new MyVisitor());
            rebuild();
            
        }
        
        public void fullBuild(final IProgressMonitor monitor) throws CoreException {
           getProject().accept(new MyVisitor());
           rebuild();
         }

        
        protected void rebuild() {
long a1 = System.currentTimeMillis();

            // rebuild output dir
            if (rebuild.size() > 0) {
                
                Set<IProject> keys = rebuild.keySet();
                for (Iterator<IProject> iter = keys.iterator(); iter.hasNext();) {
                    
                    IProject project = (IProject) iter.next();
                    Set<String> configFiles = rebuild.get(project);
                    
                    if (!checkFiles(project,  configFiles)) {
	//                      RtdruidLog.log("The project " + project.getName() + " doesn't contains the RT-Druid config file " + configFile);
	                  	continue; // next
	                }
                    
                    ArrayList<IPath> paths = new ArrayList<IPath>();
                	for (String configFile : configFiles) {
                    IFile file = project.getFile(configFile);
        	        	paths.add(file.getFullPath());
                	}
                        
                    
                    // build internally the project
                    IProjectBuilder builder = getProjectBuilder(paths.toArray(new IPath[paths.size()]), project);
                    try {
                    	rebuilded = builder.store();
                    	EELocationLinkVar.reindex(project);
            		} catch (/*NotFoundSignature*/Exception e) {
            			RtdruidLog.log(e);
            			//activeSignaturesView(file);
            			return;
            		}

//                    try {
//                    	NiosProjectBuilder.setCDTWorkFolder(project, npb.getWorkFolder());
//                    } catch (CoreException e) {
//                    	RtdruidLog.log(e);
//                    	// continue
//                    }
            		
            		
            		// try to build myMake file
    	        	MyMakeBuilder myMakeBuilder = new MyMakeBuilder(getProject(), builder.getOptions());
    	        	try {
    	    			myMakeBuilder.buildFile();
    	    		} catch (IOException e) {
    	    			RtdruidLog.log(e);
    	    		}

                }
            }
            
            // check other visited projects
            if (visited.size() > 0) {
                
                Set<IProject> allVisistedProjects = visited.keySet();
                for (Iterator<IProject> iter = allVisistedProjects.iterator(); iter.hasNext();) {
                    
                	// check the configFile
                    IProject project = (IProject) iter.next();
                    Set<String> confFiles = visited.get(project);
                    if (!checkFiles(project,  confFiles)) {
//                        RtdruidLog.log("The project " + project.getName() + " doesn't contains the RT-Druid config file " + configFile);
                    	continue; // next
                    }
                    long configFileTimeStamp = 0;
                    ArrayList<IPath> paths = new ArrayList<IPath>();
                	for (String configFile : confFiles) {
                    IFile file = project.getFile(configFile);
        	        	paths.add(file.getFullPath());
        	        	long newtimeStamp = file.getLocalTimeStamp();
        	        	if (configFileTimeStamp<newtimeStamp) {
        	        		configFileTimeStamp = newtimeStamp;
        	        	}
                    }

                    
                    // build internally the project
                    //NiosProjectBuilder builder = new NiosProjectBuilder(file.getFullPath(), project); 
                    IProjectBuilder builder = getProjectBuilder(paths.toArray(new IPath[paths.size()]), project);
                    try {
                        builder.build();
            		} catch (/*NotFoundSignature*/Exception e) {
//            			Messages.sendErrorNl("For more details, use \"E.E. Library problems solver\" View", null, "ASDASDASghjD", null);

//            			activeSignaturesView(file);
            			return;
            		}
            		
                    IOilWriterBuffer[] buffers = builder.getWriterBuffers();
                    if (buffers == null) {
                    	continue;
                    }
                    
                    // check each file
                    boolean forceRebuild = false;
//                    Properties folderCache = new Properties();
                    final IContainer workspace = project.getParent();
                    final IPath basePath = builder.getOutputFolder();
                    for (int bi=0; bi<buffers.length && !forceRebuild; bi++) {
            			String[] keys = buffers[bi].getKeys();
            			
            			for (int ki=0; ki<keys.length && !forceRebuild; ki++) {
            				
            				final String fileName = buffers[bi].getFileName(keys[ki]);
            				final String filePath = buffers[bi].getFilePath(keys[ki]);

            				
            				IPath path = basePath.append(filePath+IPath.SEPARATOR+fileName);

            				// rebuild is required if the file doesn't exist
            				// project.getParent() cannot be null !!!
            				forceRebuild |= !workspace.exists(path);

            				// or is older than config File
            				forceRebuild |= configFileTimeStamp > workspace.getFile(path).getLocalTimeStamp();
            			}
                    }

                    
                    if (forceRebuild) {
                    	rebuilded = builder.store();
                    	EELocationLinkVar.reindex(project);
                    	
//                        try {
//                        	NiosProjectBuilder.setCDTWorkFolder(project, builder.getWorkFolder());
//                        } catch (CoreException e) {
//                        	RtdruidLog.log(e);
//                        	// continue
//                        }
                    	
                    	// try to build myMake file
        	        	MyMakeBuilder myMakeBuilder = new MyMakeBuilder(getProject(), builder.getOptions());
        	        	try {
        	    			myMakeBuilder.buildFile();
        	    		} catch (IOException e) {
        	    			RtdruidLog.log(e);
        	    		}


                    } else {
                    	Messages.sendTextNl("\nAll files are up-to-date.");
                    }
    
                }
            }
            if (false) {
	            long b1 = System.currentTimeMillis();
	            System.err.println("\nRebuild List = " + rebuild);
	            System.err.println("visited   List = " + visited);
	            System.err.println("\tdelta   .. " + (b1-a1));
            }
            
        }
        

		/** Returns the config file of specified project. Uses a buffer to cache already computed projects */
        protected String[] getConfigFile(IProject project) {
            
            // specified project is already visited 
            if (confBuffer.containsKey(project)) {
                Object o = confBuffer.get(project);
                if (o instanceof String[]) {
                    return (String[]) o;
                } else {
                    return null;
                }
            }
            
            // Check if this project is valid and contains the required attribute 
            String[] tmp = OilProjectProperties.getConfigFile(project);
    	    
    	    if (tmp == null) {
    	        // some error : disable this project
    	        confBuffer.put(project, new Integer(-1));
    	    }
    	    
    	    return tmp;
        }

//        /**
//		 * This method tries to open an Oil Editor for specified file and then
//		 * open the RT-Druid Signatures View
//		 */
//        protected void activeSignaturesView(final IFile file) {
//        	PlatformUI.getWorkbench().getDisplay().asyncExec
//			(new Runnable() {
//
//				public void run() {
//					// open the Signature View
//					IWorkbench iw = PlatformUI.getWorkbench();
//					IWorkbenchWindow iww = iw == null ? null : iw.getActiveWorkbenchWindow();
//					IWorkbenchPage iwp = iww == null ? null : iww.getActivePage();
//		
//					if (iwp != null) {
//					
//						/* Open the oil file */
//						IEditorPart idp = iwp.findEditor(new FileEditorInput(file));
//						if (idp == null) {
//						try {
//								idp = iwp.openEditor(
//											new FileEditorInput(file),
//											iw.getEditorRegistry()
//													.getDefaultEditor(
//															file.getFullPath()
//																	.toString())
//													.getId());
//							} catch (PartInitException e1) {
//								RtdruidLog.log(e1);
//							}
//						}
//		
//						if (idp != null) {
//							iwp.activate(idp);
//						}
//					
////						try {
////							IViewPart view = iwp.showView("com.eu.evidence.rtdruid.modules.oil.ui.editor.form.SignaturesViewID");
////							if (view != null && view instanceof SignaturesView) {
////								((SignaturesView) view).searchEditor();
////							}
////						}
////						catch (PartInitException exception) {
////							RtdruidLog.log(exception);
////						}
//					}
//				}
//			});
//
//						}
					}
    
    // --------------------------
    
    /**
     * Return a Map with all parameters setted in the specified project for this Builder.
     * If the project is closed or doesn't use this builder, returns a null map.
     *  */
    public static Map<String, String> getParameters(IProject project) {
        try {
            if (project != null && project.isOpen()) {
	            ICommand command = RTDOilProjectNature.getBuildSpec(project, BUILDER_ID);
	            if (command != null) {
	                
	                Map<String, String> answer = command.getArguments();
	                if (answer == null) {
	                    answer = new HashMap<String, String>();
	                }
	                return answer;
	            }
            }
            
        } catch (CoreException e) {
            RtdruidLog.log(e);
        }

        // some problems .. return null
        return null;
    }
    
    /**
     * Return a Map with all parameters setted in the specified project for this Builder.
     * If the project is closed or doesn't use this builder, returns a null map.
     *  */
    public static void setParameters(IProject project, Map<String, String> newAttributes) {
        try {
            if (project != null && project.isOpen()) {
	            ICommand command = RTDOilProjectNature.getBuildSpec(project, BUILDER_ID);
	            if (command != null) {
	                
	                command.setArguments(newAttributes);
	                RTDOilProjectNature.setBuildSpec(project, command);
	            }
            }
            
        } catch (CoreException e) {
            RtdruidLog.log(e);
        }
    }

    /**
     * Returns the most correct ProjectBuilder
     */
    protected IProjectBuilder getProjectBuilder(IPath[] confgiFilePath, IProject project) {
    	//return new NiosProjectBuilder(file.getFullPath(), project);
    	return new ProjectBuilder(confgiFilePath, project);
    }
    
    protected static boolean checkFiles(IProject project, Collection<String> files) {
    	boolean all = true;
    	for (String configFile : files) {
        	IFile file = project.getFile(configFile);
            if (!file.exists()) {
            	RtdruidLog.log("The project " + project.getName() + " doesn't contains the RT-Druid config file " + configFile);
            	all = false;
            }
    	}
    	return all;
    }
 }

interface IProjectBuilder {

	public abstract boolean disableSignature(boolean value);
	public abstract boolean build();
	public abstract boolean store();
	public abstract IOilWriterBuffer[] getWriterBuffers();
	public abstract IPath getOutputFolder();
	public abstract HashMap<String, Object> getOptions();

};

class ProjectBuilder implements IProjectBuilder {
	
	public static final Messages NULL_OUTPUT = new Messages() {
		/* (non-Javadoc)
		 * @see rtdruid.desk.Messages#output(int, java.lang.String, java.lang.String, java.lang.String, java.util.Properties)
		 */
		protected void output(int type, String text, String detailedText,
				String errorCode, Properties otherInfo) {
			// To std output
			System.out.println(text);
		}	
	}; 
	
	protected final IPath[] configFile;
	protected final IProject project;
	protected final String projectName;
	
	private  IOilWriterBuffer[] buffers;
	private  IOilObjectList[]   objects;
	
	
	private IVarTree vt;
	protected boolean disableSignature = false;
	
	protected HashMap<String, Object> options;
	
	
	public ProjectBuilder(IPath[] configFile, IProject project) {
		this.configFile = configFile;
		this.projectName = project.getName();
		this.project = project;
	}
	
	public boolean disableSignature(boolean value) {
		boolean old = disableSignature;
		disableSignature = value;
		return old;
	}
	
	protected IVarTree getVarTree() {
		if (vt == null) {
			vt = loadConfigFile(configFile); 
//			vt = loadOilFile(configFile);
		}
		return vt;
	}
		
	public boolean build() {
		if (buffers != null) {
			return true;
		}
		
		{
			StringBuffer conf_files = new StringBuffer();
			for (IPath p: configFile) {
				conf_files.append("\n\t"+p);
			}
			
		    Messages.sendTextNl("Rebuild the project " + projectName + ". Config file:"+conf_files);
		}
		/***********************************************************************
		 * PREPARE A MONITOR
		 **********************************************************************/
		
//		IProgressMonitor monitor = null;
		
		/***********************************************************************
		 * LOAD
		 **********************************************************************/
		getVarTree();
		if (vt == null) {
        	return false;
		}
        
        /***********************************************************************
		 * SEARCH ALL RT-OS
		 **********************************************************************/
		String[] rtosPath = Search.allRtos(vt.newTreeInterface());
		if (rtosPath == null || rtosPath.length == 0) {
		    Messages.sendErrorNl("No RT-OS found", null, "", null);
        	return false;
        }
        
        /***********************************************************************
		 * Check the mapping task-cpu
		 **********************************************************************/
		checkMapping();
		if (Messages.getErrorNumber()>0) {
			return false;
		}
		
        /***********************************************************************
		 * PARSE FILES AND PREPARE BUFFERS
		 **********************************************************************/
        Messages.sendTextNl("Compute configuration's files\n");
        try {
        	HashMap<String, Object> wrtierProperties = getWriterProperties(true, vt, rtosPath);
        	Messages.setCurrent(NULL_OUTPUT);
        	objects = RtosFactory.INSTANCE.extractObjects(vt, rtosPath, wrtierProperties);
        	
        } catch (Exception e) {
        	// Ignore all errors: they will appear again in the "write" call.
        	// then they will be also shown in the Output Console
        } finally {
        	Messages.setPrevious();
        }
        	
        try {
        	HashMap<String, Object> wrtierProperties = getWriterProperties(false, vt, rtosPath);
        	buffers = RtosFactory.INSTANCE.write(vt, rtosPath, wrtierProperties);
        } catch (OilCodeWriterException e) {
			RtdruidLog.log(e);
		    Messages.sendErrorNl("Some errors : " + e.getMessage(), null, "", null);
			return false;
        } catch (RuntimeException e) {
			RtdruidLog.log(e);
		    Messages.sendErrorNl("Some errors : " + e.getMessage(), null, "", null);
			return false;
        }

        return true;
	}

	
	/**
	 * Store buffers inside the workspace
	 */
	public boolean store() {
		//System.err.println("inizio .. " + System.currentTimeMillis());
        if (buffers == null) {
        	if (!build()) {
        		return false;
        	}
        }
        IProgressMonitor monitor = null;
        
        
        Messages.sendTextNl("");
        
        // contains all already done directories
//        HashMap containersCache = new HashMap();
        
        /***********************************************************************
		 * PREPARE FOLDER INSIDE THE SAME WORKSPACE OF INPUT FILE
		 * SAVE (as RESOURCES inside the WORKSPACE)
		 **********************************************************************/
        //IPath basePath = configFile;
        //basePath = basePath.removeLastSegments(1);
        //basePath = basePath.addTrailingSeparator();
        //IPath basePath = project.getFullPath();

        final IPath basePath = getOutputFolder();
//        final String cdtPath = NiosProjectBuilder.getCDTWorkFolder(project);
        
//        if (this instanceof NiosProjectBuilder) {
//        	Object o = ((NiosProjectBuilder) this).getWorkFolder();
//        }
//        String tmp = NiosProjectBuilder.getWorkFolder();
        
        ResourceUtility resUt = new ResourceUtility();
        resUt.setMonitor(monitor);
        
        for (int bi=0; bi<buffers.length; bi++) {
			String[] keys = buffers[bi].getKeys();
			
			for (int ki=0; ki<keys.length; ki++) {
				final String fileName = buffers[bi].getFileName(keys[ki]);
				final String filePath = buffers[bi].getFilePath(keys[ki]);
				
				resUt.saveResourceFile(filePath, fileName, basePath, 
						buffers[bi].get(keys[ki]).toString().getBytes());
				
//				
//				// Prepare folder
//		        final IContainer container; 
////				final String messagePrefix1 = "\t" + basePath.append(filePath).toString()+ "/"+ fileName;
//
//		        if (containersCache.containsKey(filePath)) {
//		            container = (IContainer) containersCache.get(filePath);
//		        } else {
//		        	IPath requiredFolder = basePath.append(filePath);
//		            final ContainerGenerator cg = new ContainerGenerator(requiredFolder);
//			        Messages.sendTextNl("Check and fill folder "+ requiredFolder.toString());
//
//					try {
//						container = cg.generateContainer(monitor);
//					} catch (Exception e) {
//						RtdruidLog.log(e);
//						
//						if (e instanceof ClassCastException) {
//							String[] segments = requiredFolder.segments();
//							IContainer current = ResourcesPlugin.getWorkspace().getRoot();
//							
//							IPath currPath = new Path("");
//							for (int i=0; i<segments.length; i++) {
//								currPath = currPath.append(segments[i]);
//								IResource res = current.findMember(segments[i]);
//								if (res == null) {
//									Messages.sendErrorNl(currPath + " doesn't exist and cannot be created", null, "adasdjasdfdgh;", null);
//									return false;
//								}
//								
//								if (res.getType() == IResource.FOLDER || res.getType() == IResource.PROJECT) {
//									current = (IContainer) res;
//								} else {
//									Messages.sendErrorNl(currPath + " exists and it isn't a folder", null, "jasdfsdfdgh;", null);
//									return false;
//									
//								}
//								
//							}
//						}
//						Messages.sendErrorNl(e.getMessage(), null, "rtjjasdfdgh;", null);
//
//						
//						return false;
//					}
//					containersCache.put(filePath, container);
//		        }
//		        
//				if (!(container instanceof IFolder) && !(container instanceof IProject)) {
//					RtdruidLog.log(filePath + " isn't a folder");
//					throw new RuntimeException(filePath + " isn't a folder");
//					//return false;
//				}
//				
//				// Save file
//				final IFile newFile = (container instanceof IFolder) ?
//					((IFolder) container).getFile(fileName) : ((IProject) container).getFile(fileName);
//				
//				InputStream fileStream = new ByteArrayInputStream(
//						buffers[bi].get(keys[ki]).toString().getBytes());
//
//				final String messagePrefix = "\t" + basePath.append(filePath).toString()+ "/"+ fileName;
//
//				// the current file already exist
//				if (newFile.exists()) {
//					try {
//						newFile.setContents(fileStream, IFile.FORCE, monitor);
//					} catch (CoreException e) {
//						RtdruidLog.log(e);
//						Messages.sendErrorNl(messagePrefix+"\tERROR", null, "jasdfdgh;", null);
//						return false;
//					}
//					Messages.sendTextNl(messagePrefix+"\tOK (overwritten)");
//				} else {
//					try {
//						newFile.create(fileStream, IFile.FORCE, monitor);
//					} catch (CoreException e) {
//						RtdruidLog.log(e);
//						Messages.sendErrorNl(messagePrefix+"\tERROR", null, "jasdh;", null);
//						return false;
//					}
//					Messages.sendTextNl(messagePrefix+"\tOK");
//				}
			}
		}
		return true;
	}
	
	// --------------------------------------------
	
	public IOilWriterBuffer[] getWriterBuffers() {
		if (buffers == null) {
			build();
		}
		return buffers;
	}
	
	public HashMap<String, Object> getOptions() {
		return options;
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.ui.actions.OilWriterWizard#getWriterProperties()
	 * TODO : VA standardizzato da qualche parte !!!
	 */
	protected HashMap<String, Object> getWriterProperties(boolean enableMessages, IVarTree vt, String[] rtosPath) {
		// get Parent properties
		options = new HashMap<String, Object>();
		
		{
			PreferenceStorage pref = PreferenceStorage.getCommonIstance();
			options.putAll(pref.getAllValue());
		}
		
		{
			// output dir 
			IPath path = getOutputFolder();
			if (path != null) {
				IPath outputPrjPath = path.segmentCount()>1 ? ResourcesPlugin.getWorkspace().getRoot().getFile(path).getProjectRelativePath() : new Path("");
				
				String last = path.lastSegment();
				if (last != null && last.length() != 0 && path.segmentCount()>1) {
					options.put(IWritersKeywords.WRITER_LAST_OUTPUT_DIR, last);
				}
				String base = "";
				for (int i=0; i<outputPrjPath.segmentCount(); i++) {
					if (i>0) base += "/";
					base += "..";
				}
				
				options.put(IWritersKeywords.WRITER_OUTPUT_DIR_SET, Boolean.TRUE);
				options.put(IWritersKeywords.WRITER_WS_OUTPUT_projectbase_DIR, base);
				
				//ResourcesPlugin.getWorkspace().getRoot().getFile(path).getLocation();
				options.put(IWritersKeywords.WRITER_WS_PATH_OUTPUT_DIR,
						outputPrjPath.toString());
						//ResourcesPlugin.getWorkspace().getRoot().getFile(path).getProjectRelativePath().toString());
						//ResourcesPlugin.getWorkspace().getRoot().getFile(path).getLocation().toOSString());
						//path.toFile().getAbsolutePath());
			}
		}
		
		{
			/*
			 * Erika Enterprise Files Location
			 */
			String path = (new ErikaEnterpriseLocationProjectHandler(project)).getProjectErikaEnterpriseLocation();
			if (path != null && path.length()>0) { 
				options.put(IWritersKeywords.ERIKA_ENTERPRISE_LOCATION, path);
			}
		}
		
		{	/*
		 	 * BuilderOptions Extentions
		 	 */
			options.putAll(OptionsManager.getOptions());
		}

		return options;
	}
	
	// --------------------------------------------------------------

	
	/**
	 * Load the Configuration File
	 */
	public static IVarTree loadConfigFile(IPath[] inputFiles) {
		if (inputFiles == null || inputFiles.length == 0) {
			return null;
		}
//		
//		IFile fPath = ResourcesPlugin.getWorkspace().getRoot()
//			.getFile(inputFile);
//		
//		
//		
//		IVTResource res = (IVTResource) new RTD_XMI_Factory().createResource(URI.createFileURI(fPath.getLocation().toString()));
//		try {
////			res.setLoadHandler(new ErrorHandler() {
////				public void error(SAXParseException e) throws SAXException {
////					Messages.sendErrorNl("syntax error at line " + e.getLineNumber() 
////							+ " : " + e.getMessage()+ " \n",null,"", new Properties());
////				}
////
////				public void fatalError(SAXParseException e) throws SAXException {
////					Messages.sendErrorNl("fatal error at line " + e.getLineNumber()
////							+ " : " + e.getMessage() + " \n",null,"", new Properties());
////				}
////
////				public void warning(SAXParseException e) throws SAXException {
////					Messages.sendWarningNl("syntax warning at line " + e.getLineNumber() 
////							+ " : " + e.getMessage()+" \n",null,"", new Properties());
////				}
////
////			});
//			{	
//				InputStream input = fPath.getContents();
//				int a;
//				while ( (a = input.read()) != -1) {
//					System.out.print((char)a);
//				}
//				input.close();
//			}
//			
//			res.load(fPath.getContents(), new HashMap());
//		} catch (Exception e) {
//			
//			RtdruidLog.log("Unable to load \"" + inputFile + "\".");
//			RtdruidLog.log(e);
//			Messages.sendErrorNl("Unable to load \"" + inputFile
//					+ "\" caused by :", "", "ASDASDAS", null);
//			Messages.sendErrorNl(e.getMessage(), "", "ASDASDAS", null);
//			return null;
//		}
//
//		
//		IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
//		vt.setRoot(res);
//		
////		
////		
////        try {
////        	String inputPath = null;
////        	IPath lPath = fPath.getLocation();
////        	if (lPath != null) {
////        		lPath = lPath.removeLastSegments(1);
////        		inputPath = lPath.toOSString();
////        	}
////
////       		(OilReaderFactory.getAnOilReader()).load(fPath.getContents(), vt, inputFile.toString(), inputPath);
////
////        	IProject project = fPath.getProject();
////        	
////        	if (project != null) {
////        	    vt.getProperties().put(IWritersKeywords.VTProperty_OilProjectName, project.getName());
////        	    IPath path = project.getLocation();
////        	    
////       	        vt.getProperties().put(IWritersKeywords.VTProperty_OilProjectPath,
////       	                path == null ? project.getName() : path.toString());
////        	}
////        } catch (Exception e) {
////			//e.printStackTrace();
////            
////            RtdruidLog.log("Unable to load \"" + inputFile + "\".");
////            RtdruidLog.log(e);
////            Messages.sendErrorNl("Unable to load \"" + inputFile + "\" caused by :", "", "ASDASDAS", null);
////            Messages.sendErrorNl(e.getMessage(), "", "ASDASDAS", null);
////			return null;
////        }
//
//		return vt;
		IVarTree vt = VarTreeUtil.newVarTree();

		try {
		
			// prepare
			ArrayList<MultiSourceImporterFactory.LoadHelper> helpers = new ArrayList<MultiSourceImporterFactory.LoadHelper>();
			ArrayList<String> simpleLoad = new ArrayList<String>();
			for (IPath inputFile : inputFiles) {

				InputStream input;
				String osPath;
				try {
		IFile fPath = ResourcesPlugin.getWorkspace().getRoot()
			.getFile(inputFile);
					osPath = fPath.getLocation().toOSString();
		
					input = new FileInputStream(fPath.getLocation().toFile());
				} catch (FileNotFoundException e) {
					Messages.sendErrorNl("Unable to load \"" + inputFile + "\" caused by :", "", "ASDASDAS", null);
		            Messages.sendErrorNl(e.getMessage(), "", "ASDASDAS", null);
					return null;
				}

				boolean found = false;
				// check already existing helpers
				for (MultiSourceImporterFactory.LoadHelper helper : helpers) {
					if (helper.add(osPath, input)) {
						found = true;
						break;
					}
				}
		
				if (!found) {
					// check a new helper
					MultiSourceImporterFactory.LoadHelper helper = new MultiSourceImporterFactory.LoadHelper();
					if (helper.add(osPath, input)) {
						found = true;
						helpers.add(helper);
					}
				}
		
				if (!found) {
					// ok. it should be handled as single file
					simpleLoad.add(osPath);
				}
			}

			// load
			for (MultiSourceImporterFactory.LoadHelper helper : helpers) {

//				for (String s: helper.getNames()) {
//					myLog("LOAD", s);
//				}
//
				try {
					EObject root = helper.load();
					mergeInput(vt, root);
				} catch (Exception e) {
					Messages.sendErrorNl("Unable to load \"" + helper.getNames() + "\" caused by :", "", "ASDASDAS", null);
		            Messages.sendErrorNl(e.getMessage(), "", "ASDASDAS", null);
					return null;
				}

			}
			
			// load
			for (String inputFile : simpleLoad) {

//				myLog("LOAD", inputFile);
				// load and parse the input file
				IVTResource res = (IVTResource) new RTD_XMI_Factory()
						.createResource(URI.createFileURI(inputFile));
				try {
					res.load(new FileInputStream(inputFile), null);
					mergeInput(vt, res);
		} catch (Exception e) {
					Messages.sendErrorNl("Unable to load \""
							+ inputFile + "\" caused by :" + e.getMessage(), "", "ASDASDAS", null);
					return null;
				}
			}
			
		} catch (RuntimeException e) {
			Messages.sendErrorNl(e.getMessage(), "", "ASDASDAS", null);
			return null;
		}

		return vt;
	}

	protected static void mergeInput(IVarTree vt, IVTResource res) {
		EList<EObject> objList = res.getContents();
		if (objList.size() > 0) {
			IVarTree vtt = VarTreeUtil.newVarTree();
			vtt.setRoot(res);
//			
//			System.out.println("\t------------OI1L------------\n\n");
//			System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.writeString(vtt, "ertd")));
//			System.out.println("\t------------FINE OI1L------------\n\n");

			
			mergeInput(vt, objList.get(0));
		}
	}
	
	protected static void mergeInput(IVarTree vt, EObject root) {
		// get the old root
		EList<Resource> resList = vt.getResourceSet().getResources();
		if (resList.size() == 0) {
			resList.add((new RTD_XMI_Factory()).createResource());
		}
		EList<EObject> objList = resList.get(0).getContents();
		if (objList.size() == 0) {
			// set the new root
			objList.add(root);
		} else {
			// merge old and new root
			VarTreeUtil.merge(((ObjectWithID) objList.get(0)), root, null, false);
		}
//		System.out.println("\t------------ERTD------------\n\n");
//		System.out.println(Vt2StringUtilities.explodeOilVar(Vt2StringUtilities.writeString(vt, "ertd")));
//		System.out.println("\t------------FINE ERTD------------\n\n");
	}
	
	
	
		
		
//		
//	/**
//	 * Load the Oil File
//	 */
//	public static IVarTree loadOilFile(IPath inputFile) {
//		if (inputFile == null) {
//			return null;
//		}
//		
//		IFile fPath = ResourcesPlugin.getWorkspace().getRoot()
//			.getFile(inputFile);
//		
//		IVarTree vt = (IVarTree) RTDFactory.get(IVarTree.class);
//        try {
//        	String inputPath = null;
//        	IPath lPath = fPath.getLocation();
//        	if (lPath != null) {
//        		lPath = lPath.removeLastSegments(1);
//        		inputPath = lPath.toOSString();
//        	}
//
//       		(OilReaderFactory.getAnOilReader()).load(fPath.getContents(), vt, inputFile.toString(), inputPath);
//
//        	IProject project = fPath.getProject();
//        	
//        	if (project != null) {
//        	    vt.getProperties().put(IWritersKeywords.VTProperty_OilProjectName, project.getName());
//        	    IPath path = project.getLocation();
//        	    
//       	        vt.getProperties().put(IWritersKeywords.VTProperty_OilProjectPath,
//       	                path == null ? project.getName() : path.toString());
//        	}
//        } catch (Exception e) {
//			//e.printStackTrace();
//            
//            RtdruidLog.log("Unable to load \"" + inputFile + "\".");
//            RtdruidLog.log(e);
//            Messages.sendErrorNl("Unable to load \"" + inputFile + "\" caused by :", "", "ASDASDAS", null);
//            Messages.sendErrorNl(e.getMessage(), "", "ASDASDAS", null);
//			return null;
//        }
//
//		return vt;
//	}

	
	/**
	 * This method doesn't check if the returned folder exist or if it's a folder, not a file.
	 * Use <code>ResourcesPlugin.getWorkspace().getRoot().findMember(getWorkFolder().getFullPath()))</code>
	 * to check if exist and it's type.
	 * 
	 * @return the work folder or null if not set or if there are some problems 
	 */
	public IPath getOutputFolder() {
		
    	/*
    	 * Disable output 
    	 */
    	{
			Messages.setCurrent(NULL_OUTPUT);
    	}

        try {

	    	final IOilObjectList ool = objects != null && objects.length>0 ? objects[0] : null;
	
			if (IWritersKeywords.CPU_NIOSII.equals(AbstractRtosWriter.getOsProperty(ool, ISimpleGenResKeywords.OS_CPU_TYPE))) {

				// Returns directly the folder path
				if (true) {
					return project.getFullPath();
				}
				
				
		        /***********************************************************************
				 * GET BUFFERS
				 **********************************************************************/
		        IOilWriterBuffer[] buffers = getWriterBuffers();
		        if (buffers == null) {
		        	return null;
		        }
		        
		        /***********************************************************************
				 * SEARCH MAKEFILE
				 **********************************************************************/
		        Properties folderCache = new Properties();
		        for (int bi=0; bi<buffers.length; bi++) {
					String[] keys = buffers[bi].getKeys();
					
					for (int ki=0; ki<keys.length; ki++) {
						
						if (IWritersKeywords.FILE_MAKEFILE.equals(buffers[bi].getFileName(keys[ki]))) {
	
							String path = buffers[bi].getFilePath(keys[ki]);
							
							return path != null && path.length() >0 ? project.getFolder(path).getFullPath() : null;
						}
					}
		        }
	
			} else {
				/***************************************************************
				 * GET THE CDT OUTPUT DIRECTORY
				 **************************************************************/
	    	
				final String path = getCDTWorkFolder(project);
				if (path != null && path.length()>0) {
//					IContainer cont = project.getWorkspace().getRoot();
					//return cont.getFolder(new Path(path));
					return new Path(path);
					
					//return path != null && path.length() >0 ? project.getParent().getFolder(path) : null;
				} else {
					throw new RuntimeException("It's required a not null output folder.\n" +
							"\tSet it in the project's properties' window, inside the \"Builder Directory\" of \"C/C++ Make Project\".");
				}
				
	        
			}
        } finally {
        	//enable again output
        	Messages.setPrevious();
        }
		return null;
	}

	
	//*********************************************
	

	/**
     * Checks if all tasks are mapped to valid cpus
     */
    protected void checkMapping() {
    	
    	IVarTree vt = getVarTree();
    	if (vt == null) {
    		return;
    	}
    	ITreeInterface ti = vt.newTreeInterface();
    	final String S = "" + DataPath.SEPARATOR; 
		final DataPackage dpkg = DataPackage.eINSTANCE;
    	
    	/*
    	 * SYSTEM
    	 */
    	final String systemName;
    	{
    		String path = null; 
            String[] tmp = ti.getAllName(path, dpkg.getSystem().getName());
            if (tmp.length==0) {
            	// nothing to do
                // Messages.sendWarning("No System found", null, "", null);
            	return;
            }
            
            systemName = tmp[0];
    	}
    	
    	/* 
    	 * get all TASKS
    	 */
    	String[] taskList;
    	{
            String path = systemName +S+ dpkg.getArchitectural().getName() 
					+S+ dpkg.getArchitectural_TaskList().getName();
    		
    		taskList = vt.newTreeInterface().getAllName(path, dpkg.getTask().getName());
    	}
    	
    	/*
    	 * check all mapping
    	 */
		Mapping map = new Mapping(vt, systemName);
    	for (int i=0; i<taskList.length; i++) {
    		String answer = map.taskToRTOS(taskList[i]);
    		if (answer == null) {
    			Messages.sendErrorNl("Task " + taskList[i] + " is not mapped",
    					null, " quahwfp;aushf", null);
    		}
    		
    		// search the cpu
    		if (Search.aRtos(ti, systemName, answer).length == 0) {
    			Messages.sendErrorNl("Task " + taskList[i] + " is mapped to a not valid cpu ("
    					+ answer + ")",
    					null, " quahwfp;aushf", null);
    		}
    	}
    }
	
	//***********************************
	// CDT UTILITIES
	//***********************************
	
	/**
	 * Get the output folder setted inside the CDT options 
	 */
	public static String getCDTWorkFolder(IProject project) {
		return RTDOilProjectNature.getCDTWorkFolder(project);
	}

	/**
	 * Set CDT work folder
	 */
	public static void setCDTWorkFolder(IProject project, IFolder newFolder) throws CoreException {
		if (newFolder != null) {
			RTDOilProjectNature.setCDTWorkFolder(project, newFolder.getFullPath().toString());
		}
	}

}

//class NiosProjectBuilder_old extends ProjectBuilder {
//	
//
//	public NiosProjectBuilder_old(IPath[] configFile, IProject project) {
//		super(configFile, project);
//	}
//	
//	/**
//	 * This method doesn't check if the returned folder exist or if it's a folder, not a file.
//	 * Use <code>ResourcesPlugin.getWorkspace().getRoot().findMember(getWorkFolder().getFullPath()))</code>
//	 * to check if exist and it's type.
//	 * 
//	 * @return the work folder or null if not set or if there are some problems 
//	 */
//	public IFolder getWorkFolder() {
//		
//    	/*
//    	 * Disable output 
//    	 */
//    	{
//			Messages.setCurrent(NULL_OUTPUT);
//    	}
//
//        try {
//
//	        /***********************************************************************
//			 * GET BUFFERS
//			 **********************************************************************/
//	        IOilWriterBuffer[] buffers = getWriterBuffers();
//	        if (buffers == null) {
//	        	return null;
//	        }
//	        
//	        /***********************************************************************
//			 * SEARCH MAKEFILE
//			 **********************************************************************/
//	        for (int bi=0; bi<buffers.length; bi++) {
//				String[] keys = buffers[bi].getKeys();
//				
//				for (int ki=0; ki<keys.length; ki++) {
//					
//					if (IWritersKeywords.FILE_MAKEFILE.equals(buffers[bi].getFileName(keys[ki]))) {
//
//						String path = buffers[bi].getFilePath(keys[ki]);
//						
//						return path != null && path.length() >0 ? project.getFolder(path) : null;
//					}
//				}
//	        }
//	        
//        } finally {
//        	//enable again output
//        	Messages.setPrevious();
//        }
//        
//		return null;
//	}
//	
//	/** Add some checks about mapping to standard build
//	 */
//	public boolean build() {
//		
//		
//
//		return super.build();
//	}
//	
//
//}
