/*
 * Created on Jul 14, 2004
 *
 * $Id: AnalysisWizard.java,v 1.2 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.data.presentation;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeEditor;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.FileEditorInput;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.jscan.JScan;
import com.eu.evidence.rtdruid.internal.modules.jscan.ValueNotFoundException;
import com.eu.evidence.rtdruid.io.IVTResource;
import com.eu.evidence.rtdruid.io.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.modules.jscan.ui.rtd_jscan_ui.Rtd_jscan_uiPlugin;
import com.eu.evidence.rtdruid.ui.common.RTDConsole;
import com.eu.evidence.rtdruid.ui.common.ShowLogo;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenRes;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Task;
import com.eu.evidence.rtdruid.vartree.abstractions.old.TaskSet;
import com.eu.evidence.rtdruid.vartree.tools.CheckReferences;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

/**
 * @author Nicola Serreli
 */
public class AnalysisWizard extends Wizard {

	protected InputPage inPage;
	protected ModePage mPage;
	protected AnalysisPage aPage;
	protected OutputPage oPage;
	
	protected DataEditor de;
	protected IVarTree vt;
	protected String systemPath;
	protected TaskSet taskSet;
	protected LinkedList VTListenerList;
	
	protected final static int CH_RESOURCE_LIST  = 1<<1;
	protected final static int CH_PRIORITY_TYPE  = 1<<2;
	protected final static int CH_PRIORITY_VALUE = 1<<3;
	protected final static int CH_MODE_VALUE     = 1<<4;
	protected final static int CH_OFFSET_VALUE   = 1<<5;
	
	public AnalysisWizard() {
		super();
		
		VTListenerList = new LinkedList();
		
		setWindowTitle("Schedulability Analysis");
//		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(DataEditorPlugin.INSTANCE.getImage("full/wizban/NewData")));
		try {
			setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(Rtd_jscan_uiPlugin.getDefault().getImage("full/wizban/analysis2")));
		} catch (IOException e) {
			RtdruidLog.log(e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#addPages()
	 */
	public void addPages() {
		{
			inPage = new InputPage("INPUT_ID");
			inPage.setTitle(Rtd_jscan_uiPlugin.getResourceString("_UI_AW_Input_Title"));
			inPage.setDescription("Select the file to analyze");
			addPage(inPage);
		}
		{
			mPage = new ModePage("MODE_ID");
			mPage.setTitle(Rtd_jscan_uiPlugin.getResourceString("_UI_AW_Priority_Protocol_Title"));
			mPage.setDescription("Select the mode to analyze");
			addPage(mPage);
		}
/*		{
			PriorityPage page = new PriorityPage("PRIORITY_PROTOCOL_ID");
			page.setTitle(DataEditorPlugin.INSTANCE.getString("_UI_AW_Priority_Protocol_Title"));
			page.setDescription("Description 2");
			addPage(page);
		}
		{
			ResourceProtocolPage page = new ResourceProtocolPage("RESOURCE_PROTOCOL_ID");
			page.setTitle(DataEditorPlugin.INSTANCE.getString("_UI_AW_Resource_Protocol_Title"));
			page.setDescription("Description 2");
			addPage(page);
		}
*/		{
			PriorityAssignmentPage page = new PriorityAssignmentPage("PRIORITY_ASSIGNMENT_ID");
			page.setTitle(Rtd_jscan_uiPlugin.getResourceString("_UI_AW_Priority_Assignment_Title"));
			page.setDescription("Assign priorities");
			addPage(page);
		}
		{
			OffsetAssignmentPage page = new OffsetAssignmentPage("OFFSET_ASSIGNMENT_ID");
			page.setTitle(Rtd_jscan_uiPlugin.getResourceString("_UI_AW_Offset_Assignment_Title"));
			page.setDescription("Assign offsets");
			addPage(page);
		}
		{
			aPage = new AnalysisPage("ANALYSIS_ID");
			aPage.setTitle(Rtd_jscan_uiPlugin.getResourceString("_UI_AW_Analysis_Title"));
			aPage.setDescription("Select the type of analysis");
			addPage(aPage);
		}
		{
			oPage = new OutputPage("OUTPUT_ID");
			oPage.setTitle(Rtd_jscan_uiPlugin.getResourceString("_UI_AW_Output_Title"));
			oPage.setDescription("Description 6");
		//	addPage(oPage);
		}
		
		
		// update pages?
	/*	if (inPage.getResources().length != 0) {
			vtNotify(CH_RESOURCE_LIST);
		}*/
		
	}
	
	
	/**
	 * Start analysis
	 */
	public boolean performFinish() {

		IWorkbenchWindow iww = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage iwpage = iww == null ? null : iww.getActivePage();
		
		
    	class SchedulabilityAnalysisOperation extends WorkspaceModifyOperation {
    		final String setPrioCommTXT = "Set Priorities and offsets";

    		protected boolean allDone = false;
    		
    		public SchedulabilityAnalysisOperation() {
    		}
    		
    		// This is the method that gets invoked when the operation runs.
    		//
    		public void execute(IProgressMonitor monitor) {
    			monitor.beginTask("Schedulability analysis", 107);
    			try {

    				/*
    				 * Prepare properties
    				 */
    				Properties options = new Properties();
    				{
    					String mode = mPage.getMode();
    					options.setProperty(JScan.MODE_STR, mode == null ? "" : mode);

    					int pValue = JScan.USER_PRIORITIES;
    					options.setProperty(JScan.PRIORITIES_STR, "" + pValue);

    					options.setProperty(JScan.F_STR, "" + aPage.getFValue());
    				}
    				monitor.worked(1);
    				if (monitor.isCanceled()) {
    					return;
    				}
    				
    				/*
					 * first step : load resources
					 */
					{
						// already loaded in loadResources
					}
					
					{ // look for editor 
					// (open it here, before computing: in this way the editor recives all notifies and update itself)
//						try {
/*							IFile fPath = ResourcesPlugin.getWorkspace().getRoot()
									.getFile(new Path(inPage.getResources()[0]));
							IEditorPart idp = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
									.getActivePage().openEditor(
											new FileEditorInput(fPath),
											PlatformUI.getWorkbench().getEditorRegistry()
													.getDefaultEditor(
															fPath.getFullPath()
																	.toString())
													.getId());
							 
							if ( idp != null && !(idp instanceof DataEditor)) {
								MessageDialog.openError(getShell(),
										"Unable to open default editor", "Selected resource is already open with another editor.\n" +
												"Close it and try again.");

								
								return;
							}
							DataEditor de = (DataEditor) idp;
*/							if (de != null) {
								/*
								 * put new priority and offsets in old tree
								 * 
								 * 1. make a taskset using modified tree
								 * 2. make a taskset using original tree
								 * 3. copy from modified taskset to original taskset
								 */
								
								String[][] taskP = {
										{ Task.STR_ACT_TYPE,    "__see_task__"},

										// scheduling
			//							{ "ModeRef",    "__see_task__"},
										{ "PreemptionGroupName",    "__see_task__"},
										{ "Priority",    "__see_task__"},
										{ "Threshold",    "__see_task__"},
										
										// activation
										{ "ActNumber",    "__see_task__"},
										{ "ActivationClass",    "__see_task__"},
										{ "Deadline",    "__see_task__"},
			//							{ "ModeRef",    "__see_task__"},
										{ "Offset",    "__see_task__"},
										{ "Period",    "__see_task__"}
								};
			
								// 1. prepare a first TaskSet
	
								TaskSet tasksModif = getTaskSet();
/*								TaskSet tasksModif = new TaskSet(vt, getSystemPath(), mPage.getMode());
								for (int i=0; i<taskP.length; i++) {
									tasksModif.setProperty(taskP[i][0], taskP[i][1], false);
								}
								tasksModif.onlyPeriodicTasks();
*/
								// 2. prepare second TaskSet
								//Resource res = (Resource) de.getEditingDomain().getResourceSet().getResources().get(0);
								//vt.setRoot(res.getContents());
								vt = (IVarTree) de.getEditingDomain();
								
								TaskSet tasksOrig = new TaskSet(vt, getSystemPath(), mPage.getMode());
								tasksOrig.setSave(true);
								for (int i=0; i<taskP.length; i++) {
									tasksOrig.setProperty(taskP[i][0], taskP[i][1], false);
								}
								tasksOrig.onlyPeriodicTasks();
			
								vt.beginTransaction().setLabel(setPrioCommTXT);
								try {
									for (int cpuId=1; cpuId<tasksOrig.getPrefixNumber(); cpuId++) {
										String prefOrig = tasksOrig.getPrefix(cpuId);
										String prefModif = tasksModif.getPrefix(cpuId);
										boolean prefOk = prefOrig == null ? prefModif == null : prefOrig.equals(prefModif);
										if (!prefOk) {
											throw new RuntimeException("Very Strange Exception !!! (134132413254355)");
										}
										for (int taskId=0; taskId<tasksOrig.getSize(cpuId); taskId++) {
											GenRes t1 = tasksOrig.getItem(cpuId,taskId);
											// search the modified task with the same id
											GenRes t2 = null;
											String nameOrig = t1.getName();
											for (int sId=0; sId<tasksModif.getSize(cpuId); sId++) {
												GenRes temp = tasksModif.getItem(cpuId,sId);
											
												String nameModif = temp.getName();
												boolean nameOk = nameOrig == null ? nameModif == null : nameOrig.equals(nameModif);
												if (nameOk) {
													t2 = temp;
													break;
												}
											}
											
											if (t2 == null) {
												throw new RuntimeException("Very Strange Exception !!! (08795437845623746)");
											}
											
											for (int i=1; i<taskP.length; i++) {
												t1.setProperty(taskP[i][0], "" + t2.getProperty(taskP[i][0]));
											}
										}
									}
								} catch (RuntimeException e) {
									vt.rollbackTransaction();
									
									throw e;
								}
								vt.commitTransaction();
							}
/*						} catch (PartInitException e) {
							MessageDialog.openError(getShell(),
									"Unable to open default editor", e.getMessage());
							return;
						}*/
					}
    				monitor.worked(1);
    				if (monitor.isCanceled()) {
    					Command com = vt.getCommandStack().getUndoCommand();
    					if (setPrioCommTXT.equals(com.getLabel())) {
    						vt.getCommandStack().undo();
    					}
    					return;
    				}

					/*
					 * check for system and mode
					 */
					String system = getSystemPath();
					{
		
						CheckReferences cr = new CheckReferences(vt, system);
						{
							String mode = options.getProperty(JScan.MODE_STR);
							if ("".equals(mode)) {
								mode = null;
							}
							if (!cr.existMode(mode)) {
								MessageDialog
										.openError(getShell(), "Invalid mode",
												"Given mode isn't a valid mode for given resources");
								return;
							}
						}
		
						cr.checkAll();
						if (Messages.getErrorNumber() > 0 || Messages.getWarningNumber() > 0) {
							return;
						}
						monitor.worked(1);
					}
		
					
					/*
					 * compute
					 */
					int analysis = aPage.getAnalysis();
	    			IProgressMonitorWatcher watcher = new IProgressMonitorWatcher(Thread.currentThread(), monitor, vt );
	    			String report = null;
	    			try {
		    			(new Thread(watcher)).start();
			            // compute
						
		    			report = JScan.startTest(vt, system, analysis, options, watcher);
		    			//report = JScan.startTest(vt, system, analysis, options);

						watcher.end();
	    			} catch (ThreadDeath e) {
	    				
	    				// if report contains something is too late to stop computation
	    				// else return and end this thread
	    				if (report == null) {
	    					Command com = vt.getCommandStack().getUndoCommand();
	    					if (setPrioCommTXT.equals(com.getLabel())) {
	    						vt.getCommandStack().undo();
	    					}
	    					return;
	    				}
	    			}
    				monitor.worked(1);

					/*
					 * Output
					 */
					if (report != null && oPage.getRTDOutput()) {
							Messages.sendText(report);
					}
    				monitor.worked(1);
						
			
/*				}
				catch (Exception exception) {
					DataEditorPlugin.INSTANCE.log(exception);
*/				} finally {
					monitor.done();
				}
			}
		}

    	if (de == null) {
			IFile fPath = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(inPage.getResources()[0]));
			try {
				IEditorPart idp = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().openEditor(
							new FileEditorInput(fPath),
							PlatformUI.getWorkbench().getEditorRegistry()
									.getDefaultEditor(
											fPath.getFullPath()
													.toString())
									.getId());
				if (idp instanceof DataEditor) {
					de = (DataEditor) idp;
				}
		
			} catch (PartInitException e) {
				RtdruidLog.log(e);
				return true;
			}

    	}
		/*
		 * enable output if required
		 */
    	RTDConsole view = null;
		if (oPage.getRTDOutput()) {
			try {
				view = RTDConsole.getConsole();
				if (view != null) {
					Messages.setCurrent(view.getMessages());
				}
			} catch (Exception exception) {
			    RtdruidLog.log(exception);
			}
		}
		// reset all counters
		Messages.clearNumbers();


		boolean forceOutput = false;
		try {

			// Do the work within an operation because this is a long running activity that modifies the workbench.
			//
			WorkspaceModifyOperation operation = new SchedulabilityAnalysisOperation();
	
			try {
				// This runs the options, and shows progress.
				//
				new ProgressMonitorDialog(getShell()).run(true, true, operation);
			} catch (InterruptedException e) {
				return false;
			} catch (InvocationTargetException e) {
				return false;
			} catch (ValueNotFoundException e) {
				forceOutput = true;
				
				if (view == null) {
					try {
						forceOutput = true;
						view =  RTDConsole.getConsole();
						if (view != null) {
							Messages.setCurrent(view.getMessages());
						}
					} catch (Exception exception) {
					    RtdruidLog.log(exception);
					}
				}
	
				Messages.sendError(e.getMessage(), null, null, new Properties());
			} catch (RuntimeException e) {
				
				if (view != null) {
					Messages.setPrevious();
				}
	
				MessageDialog.openError(getShell(), "Errors",
						"There are some errors ...\n\t" + e.getMessage());
	
				return false;
			}
	
			// Open RT-Druid Table View
			if (oPage.getRTDOutput()) {
				try {
					RtdruidTableView rtv = (RtdruidTableView) 	iwpage.showView(
									"com.eu.evidence.rtdruid.vartree.data.presentation.RtdruidTableViewID");
					if (rtv != null) {
						rtv.setVarTree(vt, mPage.getMode());
					}
				} catch (PartInitException exception) {
				    RtdruidLog.log(exception);
				}
			}
	
			if (forceOutput && view != null) {
				view.activate();
				//iwpage.activate(view);
			}
			
		} finally {
			
			/*
			 * restore output if changed and stop if there are errors
			 */
			if (view != null && Messages.getErrorNumber() > 0) {
 				MessageDialog.openError(getShell(), "Errors",
						"There are some errors ...");
	 				return false;
				}
				if (view != null) {
					Messages.setPrevious();
				}
		}

		return true;
	}
	
	/**
	 * Load all resources
	 */
	public boolean loadResources(String[] resources) {
		if (resources == null || resources.length == 0) {
			return false;
		}
		
		de = null;
		taskSet = null;
		vt = VarTreeUtil.newVarTree();
		/*
		ObjectWithID[] roots = new ObjectWithID[resources.length];
		for (int i = 0; i < resources.length; i++) {
			String fname = resources[i];
			//        	Mess("Loading", fname);
			MyXMIReaderImpl res = null;
			try {
				res = new MyXMIReaderImpl(URI
						.createPlatformResourceURI(fname));
				try {
					res.load(new HashMap());
				} catch (IOException e) {
					MessageDialog.openError(getShell(), "Error",
							"Unable to load \"" + fname + "\".\n"
									+ e.getMessage());
					return false;
				}

				//		            	res = Util.loadData(fPath.getFullPath()..toOSString());
			} catch (RuntimeException e) {
				MessageDialog.openError(getShell(), "Error",
						"Unable to load \"" + fname + "\".");
				return false;
			}
			if (res.getContents().size() == 0) {
				MessageDialog.openWarning(getShell(), "No data", fname
						+ " doesn't contain data");
			}
			roots[i] = (ObjectWithID) res.getContents().get(0);
		}

		// merge loaded files (throw exceptions if they aren't compatible,
		// like different System name)
		ObjectWithID root = (ObjectWithID) roots[0].clone();
		for (int i = 1; i < roots.length; i++) {
			//myLog("Merging",(String) allFiles.get(i));
			try {
				root.merge(roots[i], "");
			} catch (RuntimeException e) {
				MessageDialog.openError(getShell(),
						"Incompatible resources",
						"Given resources are not compatible:\n"
								+ e.getMessage());
				return false;
			}
		}*/
		
		EObject root =null;
		String fname = resources[0];

		
		IFile fPath = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(inPage.getResources()[0]));
		IEditorPart idp = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().findEditor(new FileEditorInput(fPath));
		if (idp != null) {
			if (idp instanceof DataEditor) {
				de = (DataEditor) idp;
				
				Resource res = (Resource) ((DataEditor) idp).getEditingDomain().getResourceSet().getResources().get(0);
				root = res.getContents().get(0);

			} else {
				String openResourceMessage = "Selected resource is already open with another editor.\n" +
					"Close it and try again.";
			//	MessageDialog.openError(getShell(),
			//			"Unable to open resource", openResourceMessage);
			
				inPage.setOpenErrorMessage(openResourceMessage);
				return false;
			}
		}
		
		if (root == null) {
			
			//        	Mess("Loading", fname);
			IVTResource res = null;
			try {
				res = (IVTResource) new RTD_XMI_Factory()
						.createResource(URI
						.createPlatformResourceURI(fname));
				try {
					res.load(new HashMap());
				} catch (IOException e) {
					MessageDialog.openError(getShell(), "Error",
							"Unable to load \"" + fname + "\".\n"
									+ e.getMessage());
					return false;
				}

			} catch (RuntimeException e) {
				MessageDialog.openError(getShell(), "Error",
						"Unable to load \"" + fname + "\".");
				return false;
			}
			if (res.getContents().size() == 0) {
				MessageDialog.openWarning(getShell(), "No data", fname
						+ " doesn't contain data");
			}
			root = res.getContents().get(0);

		} else {
			root = VarTreeUtil.copy(root);
		}
		
		
		{ // store all in VarTree
			vt.setRoot(root);
		}
		
		systemPath = null;
		vtNotify(CH_RESOURCE_LIST);
		return true;
	}
	
	/**
	 * Return the current tree
	 */
	protected IVarTree getVarTree() {
		return vt;
	}
	
	/**
	 * Return the current system
	 */
	protected String getSystemPath() {
		if (systemPath == null && vt != null) {
			String[] systems = (vt.newTreeInterface()).getAllName(null, "System");
			if (systems.length != 0) {
				systemPath = systems[0];
			}
		}
		return systemPath;
	}
	
	protected TaskSet getTaskSet() {
		
		if (taskSet == null && systemPath!= null) {
			taskSet = new TaskSet(vt, systemPath, mPage.getMode());
			taskSet.setSave(true);
			/* prepare a task set with all required properties
			 * (required by:
			 *    assign Priorities
			 *    assign offsets
			 *    perform finish (copy all values)
			 */
			
			String[][] taskP = {
					{ Task.STR_ACT_TYPE,    "__see_task__"},
					{ "wcet",    "__see_task__"},
					
//					{ "ModeRef",    "__see_task__"},
					{ "PreemptionGroupName",    "__see_task__"},
					{ "Priority",    "__see_task__"},
					{ "Threshold",    "__see_task__"},
					
					// activation
					{ "ActNumber",    "__see_task__"},
					{ "ActivationClass",    "__see_task__"},
					{ "Deadline",    "__see_task__"},
//					{ "ModeRef",    "__see_task__"},
					{ "Offset",    "__see_task__"},
					{ "Period",    "__see_task__"},
					{ Task.STR_ACT_TYPE,    "__see_task__"}
			};
			for (int i=0; i<taskP.length; i++) {
				taskSet.setProperty(taskP[i][0],taskP[i][1],false);
			}
			taskSet.onlyPeriodicTasks();
	
		}
		return taskSet;
	}
	
	/**
	 * An abstract class that wait for change in vartree
	 */
	protected abstract class VTListner {
		public abstract void notify(int event);
	}
	/**
	 * Ask for notify any change in VarTree
	 */
	protected void addListner(VTListner newListner) {
		if (!VTListenerList.contains(newListner)) {
			VTListenerList.add(newListner);
		}
	}
	/**
	 * remove a VT listner
	 */
	protected void removeListner(VTListner oldListner) {
		VTListenerList.remove(oldListner);
	}
	/**
	 * remove a VT listner
	 */
	protected void vtNotify(int event) {
		Iterator iter = VTListenerList.iterator();
		while(iter.hasNext()) {
			((VTListner) iter.next()).notify(event);
		}
	}
	
	/*
	 * All pages
	 */
	/**
	 */
	public class InputPage extends WizardPage {
		
	    //  INPUT TAB
	    //protected Button add;
	    //protected Button remove;
	    //protected List fileList;
	    protected Button browse;
	    protected Text fileTxt;
	    protected String[] allFiles;
	    
	    protected String openResourceMessage = null;
	    
		/**
		 * Make a new Page
		 */
		public InputPage(String pageId) {
			super(pageId);
		}

		/**
		 * Create all widgets
		 */
		public void createControl(Composite parent) {
		    Composite composite = new Composite (parent, SWT.NONE);
		    {
		        GridLayout layout = new GridLayout (2, false);
		        layout.marginHeight = 10;
		        layout.marginWidth = 10;
			    composite.setLayout (layout);
		    }

			Label containerLabel = new Label(composite, SWT.LEFT);
			{
				containerLabel.setText("Input file");

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalSpan = 2;
				containerLabel.setLayoutData(data);
			}

		    
/*		    fileList = new List(composite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		    {
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.verticalAlignment = GridData.FILL;
				data.verticalSpan = 4;
				data.grabExcessVerticalSpace = true;
				data.grabExcessHorizontalSpace = true;
				fileList.setLayoutData(data);
		    }
*/
		    fileTxt = new Text(composite, SWT.READ_ONLY | SWT.BORDER);
		    {
				fileTxt.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
		    }
			
		    { // ADD
		    	browse = createButton(composite, "browse");
			    //add.setToolTipText(DataEditorPlugin.INSTANCE.getString("_UI_AW_Add_Resource_Tooltip"));
		    	browse.addSelectionListener( new SelectionListener() {
			        public void widgetDefaultSelected(SelectionEvent e) {
			            perform(e);
			        }
			        public void widgetSelected(SelectionEvent e) {
			            perform(e);
			        }
			        
			        private void perform(SelectionEvent e) {
			            if (e.getSource() == browse) {
			                
			                // LOAD FROM RESOURCE (inside workspace)
			                if (true) {
				                ResourceSelectionDialog dialog =
				            		new ResourceSelectionDialog(getShell(), 
				            		        ResourcesPlugin.getWorkspace().getRoot()
				            		        , "testo");
				            	//dialog.setInitialSelections(null);
				            	dialog.open();
				            	Object[] results =  dialog.getResult();
				            	if (results == null) {
				            	    return;
				            	}
				            	for (int i=0; i<results.length; i++) {
					            	if (results[i] instanceof IFile) {
					            	    String ext = ((IFile) results[i]).getFullPath().getFileExtension();
					            	    if ("rtd".equalsIgnoreCase(ext) || "ertd".equalsIgnoreCase(ext)) { 
					            	        fileTxt.setText(((IFile) results[i]).getFullPath().toOSString());
					            	    }
					            	}
				            	}
				                
				                // clear cache and check values
				                allFiles = null;
				                enableOk();
				            	return;
			            	}
			                
	/*		                // LOAD FROM FILESYSTEM (inside or not of workspace)
			                
			        		// Get the user to choose an image file.
			        		FileDialog fileChooser = new FileDialog(getShell(), SWT.OPEN);
			        		if (lastPath != null)
			        			fileChooser.setFilterPath(lastPath);
			        		fileChooser.setFilterExtensions(new String[] { "*.rtd; *.ertd", "*.rtd", "*.ertd" });
			        		fileChooser.setFilterNames(new String[] { "All RT-Druid files" + " (rtd, ertd)",
			        		                                          "Evidence syntax (*.rtd)", "EMF syntax (*.ertd)" });
			        		String filename = fileChooser.open();
			        		if (filename == null)
			        			return;
			        		lastPath = fileChooser.getFilterPath();

			        		if (filename.endsWith(".rtd") || filename.endsWith(".ertd")) {
			        		    if (fileList.indexOf(filename) != -1) {
				                    MessageDialog.openWarning(
				        					getShell(),
				        					"Warning",
				        					"The file \"" + filename + "\" was already added to the list.");
			        		    } else {
				        		    fileList.add(filename);

			                
					                // clear cache and check values
					                allFiles = null;
					                enableOk();
			        		    }
			        		    
			        		} else {
			                    MessageDialog.openWarning(
			        					getShell(),
			        					"Warning",
			        		    		"Choose a valid RT-Druid file");
			        		}
	*/		            }
			        }
			    });
		    }
	/*	    { // REMOVE
			    remove = createButton(composite, "Remove");
			    remove.setToolTipText(DataEditorPlugin.INSTANCE.getString("_UI_AW_Remove_Resource_Tooltip"));
			    remove.addSelectionListener( new SelectionListener() {
			        public void widgetDefaultSelected(SelectionEvent e) { perform(e); }
			        public void widgetSelected(SelectionEvent e) { perform(e); }
			        
			        private void perform(SelectionEvent e) {
			            if (e.getSource() == remove) {
			                String[] names = fileList.getSelection();
			                if ( names.length == 0) {
			                    MessageDialog.openWarning(
			        					getShell(),
			        					"Warning",
			        					"First select one or more resources");
			                    return;
			                }
			                for (int i=0; i < names.length; i++) {
			                    fileList.remove(names[i]);
			                }
			                
			                // clear cache and check values
			                allFiles = null;
			                enableOk();
			            }
			        }
			    });
		    }
	*/	    
			super.setControl(composite);
			
			//before exit initialize all values
			init();
		}
		
		public void setOpenErrorMessage(String msg) {
			openResourceMessage = msg;
		}
		
		/**
		 * enable / disable the "next" button and show some "Error messages"
		 */
		protected void enableOk() {
	    	String messg = null;
	    	boolean enableNext = true;
	    	
	        if ("".equals(fileTxt.getText())) {
	        	enableNext = false;
	        	messg = (messg == null ? "" : messg + "\n") + "Choose the input resource";//"Add at least one resource as input";
	        } else {
	        	boolean loaded = loadResources(getResources());
	        	enableNext &= loaded;
	        	if (!loaded && openResourceMessage != null) {
	        		messg = openResourceMessage;
	        	}
	        }
	        setErrorMessage(messg);
	        setPageComplete(enableNext);
		}
		
		/**
		 * Initialize all values
		 */
		public void init() {
			// no default values
			allFiles = null;
			
			{
				IEditorPart idp = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if (idp instanceof DataEditor) {
					Resource res = (Resource) ((DataEditor) idp).getEditingDomain().getResourceSet().getResources().get(0);
					String[] tmp = res.getURI().segments();
					if (tmp.length != 0) {
						String[] tmp2 = new String[tmp.length-1];
						System.arraycopy(tmp,1,tmp2,0,tmp2.length);
						URI newUri = URI.createURI("/").appendSegments(tmp2);
						fileTxt.setText(newUri.path());
					}
				}
			}
			/*
			IWorkbenchPage[] wPages = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages();
			for (int i=0; i<wPages.length; i++) {
				IEditorReference[] ier = wPages[i].getEditorReferences();
				for (int j=0; j<ier.length; j++) {
					IEditorPart idp = ier[j].getEditor(false);
					if (idp instanceof DataEditor) {
						Resource res = (Resource) ((DataEditor) idp).getEditingDomain().getResourceSet().getResources().get(0);
						String[] tmp = res.getURI().segments();
						if (tmp.length == 0) {
							continue;
						}
						String[] tmp2 = new String[tmp.length-1];
						System.arraycopy(tmp,1,tmp2,0,tmp2.length);
						URI newUri = URI.createURI("/").appendSegments(tmp2);
						fileList.add(newUri.path());
					}
				}
			}*/
			
			enableOk();
 		}
		
		/**
		 * Return all choosen resources
		 */
		public String[] getResources() {
			if (allFiles == null) {
				if (!"".equals(fileTxt.getText())) {
					allFiles = new String[] { fileTxt.getText() };
				} else {
					allFiles = new String[0];
				}
			}
			return allFiles;
		}
	}

	/**
	 */
	public class PriorityPage extends WizardPage {

	    protected Button edfBut;
	    protected Button fpBut;

	    public final static int EDF_ID = 0;
	    public final static int FP_ID = 1;

	    protected int currPriority = EDF_ID;
	    
		/**
		 * Make a new Page
		 */
		public PriorityPage(String pageId) {
			super(pageId);
		}

		/**
		 * Create all widgets
		 */
		public void createControl(Composite parent) {

	        // Create a common listner that uptade properties
	        SelectionListener commonListner =  new SelectionListener() {
		        public void widgetDefaultSelected(SelectionEvent e) { perform(e); }
		        public void widgetSelected(SelectionEvent e) { perform(e); }
		        
		        private void perform(SelectionEvent e) {
		            if (e.getSource() == edfBut) {
		            	currPriority = EDF_ID;
		            } else if (e.getSource() == fpBut) {
		            	currPriority = FP_ID;
		            } else {
		                return;
		            }
		            
		            // notify that something is change
		            enableOk();
		        }
		    };
	        
		    
	        Composite composite = new Composite (parent, SWT.NONE);
		    {
		        GridLayout layout = new GridLayout (2, false);
		        layout.marginHeight = 10;
		        layout.marginWidth = 10;
		        composite.setLayout (layout);
		    }
		    
			Label containerLabel = new Label(composite, SWT.LEFT);
			{
				containerLabel.setText("Priority type");

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalSpan = 2;
				containerLabel.setLayoutData(data);
			}

			// EDF
			edfBut = new Button(composite, SWT.RADIO);
			{
			    edfBut.setText("Earliest Deadline First");
			    //edfBut.setToolTipText(NO_OFFSET_TT);
				edfBut.addSelectionListener(commonListner);
				
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalSpan = 2;
				edfBut.setLayoutData(data);
			}
			
			
			// FP
			fpBut = new Button(composite, SWT.RADIO);
			{
			    fpBut.setText("Fixed Priority");
			    //fpBut.setToolTipText(EXACT_TT);
				fpBut.addSelectionListener(commonListner);

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalSpan = 2;
				fpBut.setLayoutData(data);
			}
		    
			super.setControl(composite);
			
			init();
		}
		
		/**
		 * enable / disable the "next" button and show some "Error messages"
		 */
		protected void enableOk() {
	        setPageComplete(true);
		}
		
		/**
		 * Initialize all values 
		 */
		public void init() {
			
			switch (currPriority) {
			default : // default = NO OFFSET
				
			case EDF_ID:
				edfBut.setSelection(true);
				break;
			case FP_ID:
				fpBut.setSelection(true);
				break;
		}

			enableOk();
		}
		
		/**
		 * Return current priority protocol
		 */
		public int getPriority() {
			return currPriority;
		}
	}

	/**
	 */
	public class ModePage extends WizardPage {

	    protected Combo modeText;
	    
	    protected Button defaultBut;
	    protected Button chooseBut;

	    protected String currMode = null;
	    protected boolean cached = false;
	    
	    protected boolean defaultMode; 
	    
		/**
		 * Make a new Page
		 */
		public ModePage(String pageId) {
			super(pageId);
		}

		/**
		 * Create all widgets
		 */
		public void createControl(Composite parent) {

	        // Create a common listner that uptade properties
	        SelectionListener commonListner =  new SelectionListener() {
		        public void widgetDefaultSelected(SelectionEvent e) { perform(e); }
		        public void widgetSelected(SelectionEvent e) { perform(e); }
		        
		        private void perform(SelectionEvent e) {
		        	if (e.getSource() == modeText) {
		            	cached = false;
		            } else if (e.getSource() == defaultBut) {
		            	defaultMode = true;
		            } else if (e.getSource() == chooseBut) {
		            	defaultMode = false;
		            } else {
		                return;
		            }
		            
		            // notify that something is change
					vtNotify(CH_MODE_VALUE);
		            enableOk();
		        }
		    };
	        
		    
	        Composite composite = new Composite (parent, SWT.NONE);
		    {
		        GridLayout layout = new GridLayout (2, false);
		        layout.marginHeight = 10;
		        layout.marginWidth = 10;
		        composite.setLayout (layout);
		    }
		    
			Label containerLabel = new Label(composite, SWT.LEFT);
			{
				containerLabel.setText("Mode");

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalSpan = 2;
				containerLabel.setLayoutData(data);
			}

			// Default mode
			defaultBut = new Button(composite, SWT.RADIO);
			{
				defaultBut.setText("Default mode");
			    //edfBut.setToolTipText(NO_OFFSET_TT);
				defaultBut.addSelectionListener(commonListner);
				
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalSpan = 2;
				defaultBut.setLayoutData(data);
			}
			
			// Choose mode
			chooseBut = new Button(composite, SWT.RADIO);
			{
				chooseBut.setText("Choose mode");
			    //fpBut.setToolTipText(EXACT_TT);
				chooseBut.addSelectionListener(commonListner);

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				chooseBut.setLayoutData(data);
			}

			// MODE
			modeText = new Combo(composite, SWT.READ_ONLY | SWT.DROP_DOWN);
			{
				modeText.addSelectionListener(commonListner);
				
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				modeText.setLayoutData(data);
			}
			
			super.setControl(composite);
			
			init();
			addListner(new VTListner() {
				public void notify(int event) {
					/*
					 * 1. clear all old values
					 * 2. load all values from VarTree
					 * 3a. if there isn't any mode
					 *        -> disable "choose mode"
					 * 3b. else
					 *        -> enable "choose mode"
					 *        -> fill combo box
					 * 4. update errorMessage and completePage
					 */
					if (event == CH_RESOURCE_LIST) {
						updateModeList();
					}
				}
			});
		}
		
		/**
		 * enable / disable the "next" button and show some "Error messages"
		 */
		protected void enableOk() {
			modeText.setEnabled(!defaultMode);

			String errMesg = null;
			if (!defaultMode) {
				if (modeText.getText().length() == 0) {
					errMesg = "Select a mode";
				}
			}
			setErrorMessage(errMesg);
			
	        setPageComplete(errMesg == null);
		}
		
		/**
		 * Initialize all values 
		 */
		public void init() {
			defaultMode = true;
			defaultBut.setSelection(defaultMode);

			updateModeList();
		}
		
		/**
		 * Reload all mode form tree and put them into ModeText
		 */
		protected void updateModeList() {
			modeText.removeAll();
			modeText.setText("");
			
			String system = getSystemPath();
			if (system == null) {
				return;
			}
			char S = DataPath.SEPARATOR;
			String[] modes = (vt.newTreeInterface()).getAllName( S+system 
					+ S + "Modes" +S+ "ModeList", "Mode" );

			for (int i=0; i<modes.length; i++) {
				String tmpMode = DataPath.removeSlash(DataPath.removeSlash(modes[i]));
				modeText.add(tmpMode == null ? "" : tmpMode);
			}
			

			if (modes.length == 0) {
				defaultMode = true;
				defaultBut.setSelection(defaultMode);
				chooseBut.setSelection(!defaultMode);
				
				chooseBut.setEnabled(false);
			} else {
				chooseBut.setEnabled(true);
			}
			
			vtNotify(CH_MODE_VALUE);

			enableOk();
		}
		/**
		 * Return current priority protocol
		 */
		public String getMode() {
			if (defaultMode) {
				return null;
			}
			if (!cached) {
				currMode = modeText.getText();
				currMode = currMode.length() == 0 ? null : currMode;
				cached = true;
			}
			return currMode;
		}
		

	}

	/**
	 */
	public class ResourceProtocolPage extends WizardPage {
	    protected Button ipcBut;

	    public final static int IPC_ID = 0;

	    protected int currProtocol = IPC_ID;

	    /**
		 * Make a new Page
		 */
		public ResourceProtocolPage(String pageId) {
			super(pageId);
		}

		/**
		 * Create all widgets
		 */
		public void createControl(Composite parent) {

	        // Create a common listner that uptade properties
	        SelectionListener commonListner =  new SelectionListener() {
		        public void widgetDefaultSelected(SelectionEvent e) { perform(e); }
		        public void widgetSelected(SelectionEvent e) { perform(e); }
		        
		        private void perform(SelectionEvent e) {
		            if (e.getSource() == ipcBut) {
		            	currProtocol = IPC_ID;
		            } else {
		                return;
		            }
		            
		            // notify that something is change
		            enableOk();
		        }
		    };
	        
		    
	        Composite composite = new Composite (parent, SWT.NONE);
		    {
		        GridLayout layout = new GridLayout (2, false);
		        layout.marginHeight = 10;
		        layout.marginWidth = 10;
		        composite.setLayout (layout);
		    }
		    
			Label containerLabel = new Label(composite, SWT.LEFT);
			{
				containerLabel.setText("Resource Protocol");

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalSpan = 2;
				containerLabel.setLayoutData(data);
			}

			// IPC
			ipcBut = new Button(composite, SWT.RADIO);
			{
				ipcBut.setText("Immediate Priority Ceiling");
			    //edfBut.setToolTipText(NO_OFFSET_TT);
				ipcBut.addSelectionListener(commonListner);
				
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalSpan = 2;
				ipcBut.setLayoutData(data);
			}
		    
			super.setControl(composite);
			
			init();
		}

		/**
		 * enable / disable the "next" button and show some "Error messages"
		 */
		protected void enableOk() {
	        setPageComplete(true);
		}
		
		/**
		 * Initialize all values 
		 */
		public void init() {
			
			switch (currProtocol) {
			default : // default = NO OFFSET
				
			case IPC_ID:
				ipcBut.setSelection(true);
				break;
		}

			enableOk();
		}
		
		/**
		 * Return current priority protocol
		 */
		public int getResourceProtocol() {
			return currProtocol;
		}
		
	}
	
	/**
	 */
	public class PriorityAssignmentPage extends WizardPage {
		protected TableTree prioritiesTableTree;
		protected TableTreeEditor editor;
		protected String errMesg = null;
		
		protected TaskSet tasks;
		/**
		 * Make a new Page
		 */
		public PriorityAssignmentPage(String pageId) {
			super(pageId);
		}

		/**
		 * Create all widgets
		 */
		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			{
				GridLayout layout = new GridLayout();
				layout.numColumns = 4;
				layout.verticalSpacing = 12;
				composite.setLayout(layout);

				GridData data = new GridData();
				data.verticalAlignment = GridData.FILL;
				data.grabExcessVerticalSpace = true;
				data.horizontalAlignment = GridData.FILL;
				composite.setLayoutData(data);
			}

			{
				Label containerLabel = new Label(composite, SWT.LEFT);
				containerLabel.setText("Priority Assignment Page");

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalSpan = 4;
				containerLabel.setLayoutData(data);
			}
			
			// TABLE OF PRIORITIES
			prioritiesTableTree = new TableTree(composite, SWT.FULL_SELECTION | SWT.SINGLE |SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.HIDE_SELECTION);
			{
				{
					Table pt = prioritiesTableTree.getTable();
					String[] columns = new String[] {
							"RTOS",
							"Task Name",
							"Priority",
							"wcet",
							"Period",
							"Deadline"
					};
					for (int i=0; i<columns.length; i++) {
					    TableColumn a = new TableColumn(pt, SWT.LEFT);
						a.setWidth(100);
					    a.setText(columns[i]);
					}
				    
					pt.setLinesVisible(true);
					pt.setHeaderVisible(true);
				}

				
				editor = new TableTreeEditor(prioritiesTableTree);//new ValidatorTableEditor(properties); 
				editor.horizontalAlignment = SWT.LEFT;
				editor.grabHorizontal = true;
				final int EDITABLECOLUMN = 2;
				
				prioritiesTableTree.addSelectionListener(new SelectionAdapter() {
					String oldValue = null;
					public void widgetSelected(SelectionEvent e) {

						// clear all error messages and check for OK button
						errMesg = null;
						enableOk();

						// Clean up any previous editor control
						Control oldEditor = editor.getEditor();
						if (oldEditor != null) {
							oldEditor.dispose();
						}

						// Identify the selected row
						// exit if the item is null or 
						// if the item is a rtos row
						TableTreeItem item = (TableTreeItem)e.item;
						if (item == null || item.getText(0) != null ) {
							return;
						}
				
						oldValue = item.getText(EDITABLECOLUMN);
						
						{ // priority editor
							Text newEditor = new Text(prioritiesTableTree.getTable(), SWT.NONE);
							newEditor.setText(item.getText(EDITABLECOLUMN));
							newEditor.addModifyListener(new ModifyListener() {
								public void modifyText(ModifyEvent e) {
									// clear all
									errMesg = null;

									String newTxt = ((Text) editor.getEditor()).getText();
									
									// check (step 1)
									boolean ok = true;
									try {
										Integer.parseInt(newTxt);
									} catch (NumberFormatException exception) {
										ok = false;
									}
									// check (step 2)
									if ( !ok ) {
										errMesg = "The priority of task " 
											+ editor.getItem().getText(1)
											+ " must be an integer";
										newTxt = oldValue;

									} 

									// store / reset value
									editor.getItem().setText(EDITABLECOLUMN, newTxt);

									{ // store data in VarTree
										int[] pos =  (int[]) editor.getItem().getData();
										
										tasks.getItem(pos[0], pos[1]).setProperty("priority", newTxt);
										vtNotify(CH_PRIORITY_VALUE);
									}

									// before end, check for OK button
									enableOk();
								}
							});
							newEditor.selectAll();
							newEditor.setFocus();
							editor.setEditor(newEditor, item, EDITABLECOLUMN);
							
						}
					}
				});

			    GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.verticalAlignment = GridData.FILL;
				data.horizontalSpan = 4;
				data.verticalSpan = 5;
				data.grabExcessVerticalSpace = true;
				data.grabExcessHorizontalSpace = true;
				prioritiesTableTree.setLayoutData(data);
			}
			
			{
				Label containerLabel = new Label(composite, SWT.LEFT);
				containerLabel.setText("Automatic assignment");

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				containerLabel.setLayoutData(data);
			}

			{
				final Button deadlineButton = createButton(composite, "by Deadline");
				deadlineButton.addSelectionListener(new SelectionListener() {
			        public void widgetDefaultSelected(SelectionEvent e) { perform(e); }
			        public void widgetSelected(SelectionEvent e) { perform(e); }
			        
			        private void perform(SelectionEvent e) {
			            if (e.getSource() == deadlineButton && tasks!= null) {
			                tasks.computeDMPriorities();
			                fillPrioritiesTable();
							vtNotify(CH_PRIORITY_VALUE);
			            }
			        }
				    
				});

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalIndent = 20;
				deadlineButton.setLayoutData(data);
			}

			{
				final Button periodButton = createButton(composite, "by Period");
				periodButton.addSelectionListener(new SelectionListener() {
			        public void widgetDefaultSelected(SelectionEvent e) { perform(e); }
			        public void widgetSelected(SelectionEvent e) { perform(e); }
			        
			        private void perform(SelectionEvent e) {
			            if (e.getSource() == periodButton && tasks!= null) {
			                tasks.computeRMPriorities();
			                fillPrioritiesTable();
							vtNotify(CH_PRIORITY_VALUE);
			            }
			        }
				    
				});

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalIndent = 20;
				periodButton.setLayoutData(data);
			}

			super.setControl(composite);
			
			addListner(new VTListner() {
				public void notify(int event) {
					if (event == CH_RESOURCE_LIST ||
							event == CH_MODE_VALUE) {
						fillPrioritiesTable();
					}
				}
			});
			
			init();
		}
		
		/**
		 * Initialize all values 
		 */
		public void init() {
			
			fillPrioritiesTable();

			enableOk();
		}

		/**
		 * take all priorities from a task set and put them into the table
		 *
		 */
	    protected void fillPrioritiesTable() {
	    	//  1. clear old table
	        prioritiesTableTree.removeAll();
	        
	        // 2. get system and make a new TaskSet
			String system = getSystemPath();
			if (system == null) {
				tasks = null;
				return;
			}
	        
			tasks = getTaskSet();
			if (tasks == null) {
				return;
			}
	        
			// 3. fill the table

		    // add all items
		    for (int i=1; i<tasks.getPrefixNumber(); i++) {
		    	TableTreeItem tti = new TableTreeItem(prioritiesTableTree, SWT.NONE);
		    	tti.setText(0, tasks.getPrefix(i));
		    	for (int j=0; j<tasks.getSize(i); j++) {
		    		Task t = (Task) tasks.getItem(i,j);
		    		
				    TableTreeItem ti = new TableTreeItem(tti, SWT.NONE);
				    ti.setText(1, t.getName());
				    ti.setText(2, "" + t.getProperty("priority"));
				    ti.setText(3, "" + t.getProperty("wcet"));
				    ti.setText(4, "" + t.getProperty("period"));
				    ti.setText(5, "" + t.getProperty("deadline"));

				    ti.setData(new int[] {i,j});
		    	}
		    	tti.setExpanded(true);
		    }
		    
		    // resize all columns
		    TableColumn[] columns = prioritiesTableTree.getTable().getColumns();
			for (int i = 0; i < columns.length; i++) {
				columns[i].pack();
			}
			
			{ // clear the previous cell
				Control oldEditor = editor.getEditor();
				if (oldEditor != null) oldEditor.dispose();
			}

	    }

		/**
		 * enable / disable the "next" button and show some "Error messages"
		 */
		protected void enableOk() {
			setErrorMessage(errMesg);
			
	        setPageComplete(errMesg == null);
		}

	}
	
	/**
	 */
	public class OffsetAssignmentPage extends WizardPage {
		protected TableTree offsetTableTree;
		protected TableTreeEditor editor;
		protected String errMesg = null;
		
		protected TaskSet tasks;

		/**
		 * Make a new Page
		 */
		public OffsetAssignmentPage(String pageId) {
			super(pageId);
		}

		/**
		 * Create all widgets
		 */
		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			{
				GridLayout layout = new GridLayout();
				layout.numColumns = 3;
				layout.verticalSpacing = 12;
				composite.setLayout(layout);

				GridData data = new GridData();
				data.verticalAlignment = GridData.FILL;
				data.grabExcessVerticalSpace = true;
				data.horizontalAlignment = GridData.FILL;
				composite.setLayoutData(data);
			}

			{
				Label containerLabel = new Label(composite, SWT.LEFT);
				containerLabel.setText("Offset Assignment Page");

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalSpan = 3;
				containerLabel.setLayoutData(data);
			}
			
			// TABLE OF OFFSETS
			offsetTableTree = new TableTree(composite, SWT.FULL_SELECTION | SWT.SINGLE |SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.HIDE_SELECTION);
			{
				{
					Table offsetTable = offsetTableTree.getTable();
					String[] columns = new String[] {
							"RTOS",
							"Task Name",
							"Offset",
							"wcet",
							"Period",
							"Deadline",
							"Priority"
					};
					for (int i=0; i<columns.length; i++) {
					    TableColumn a = new TableColumn(offsetTable, SWT.LEFT);
						a.setWidth(100);
					    a.setText(columns[i]);
					}
				    
					offsetTable.setLinesVisible(true);
					offsetTable.setHeaderVisible(true);
				}

				
				editor = new TableTreeEditor(offsetTableTree); 
				editor.horizontalAlignment = SWT.LEFT;
				editor.grabHorizontal = true;
				// editing the second column
				final int EDITABLECOLUMN = 2;
				
				offsetTableTree.addSelectionListener(new SelectionAdapter() {
					String oldValue = null;
					public void widgetSelected(SelectionEvent e) {

						// clear all error messages and check for OK button
						errMesg = null;
						enableOk();

						// Clean up any previous editor control
						Control oldEditor = editor.getEditor();
						if (oldEditor != null) {
							oldEditor.dispose();
						}

						// Identify the selected row
						TableTreeItem item = (TableTreeItem)e.item;
						if (item == null || item.getText(0) != null) {
							return;
						}
				
						oldValue = item.getText(EDITABLECOLUMN);
						
						{ // priority editor
							Text newEditor = new Text(offsetTableTree.getTable(), SWT.NONE);
							newEditor.setText(item.getText(EDITABLECOLUMN));
							newEditor.addModifyListener(new ModifyListener() {
								public void modifyText(ModifyEvent e) {
									// clear all
									errMesg = null;

									String newTxt = ((Text) editor.getEditor()).getText();
									
									// check (step 1)
									boolean ok = true;
									
									try {
										new TimeVar(newTxt);
									} catch (NumberFormatException exception) {
										ok = false;
									}
									// check (step 2)
									if ( !ok ) {
										errMesg = "The offset of task " 
											+ editor.getItem().getText(1)
											+ " must be a time (double + time unit)";
										newTxt = oldValue;

									} 

									// store / reset value
									editor.getItem().setText(EDITABLECOLUMN, newTxt);

									{ // store data in VarTree
										int[] pos =  (int[]) editor.getItem().getData();
										
										tasks.getItem(pos[0], pos[1]).setProperty("offset", newTxt);
									}

									// before end, check for OK button
									enableOk();
								}
							});
							newEditor.selectAll();
							newEditor.setFocus();
							editor.setEditor(newEditor, item, EDITABLECOLUMN);
							
						}
					}
				});

			    GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.verticalAlignment = GridData.FILL;
				data.verticalSpan = 5;
				data.horizontalSpan = 3;
				data.grabExcessVerticalSpace = true;
				data.grabExcessHorizontalSpace = true;
				offsetTableTree.setLayoutData(data);
			}

			super.setControl(composite);
			
			addListner(new VTListner() {
				public void notify(int event) {
					if (event == CH_RESOURCE_LIST ||
							event == CH_MODE_VALUE ||
							event == CH_PRIORITY_VALUE) {
						fillOffsetTable();
					}
				}
			});
			
			init();
		}
		
		/**
		 * Initialize all values 
		 */
		public void init() {
			
			fillOffsetTable();

			enableOk();
		}

		/**
		 * take all priorities from a task set and put them into the table
		 *
		 */
	    protected void fillOffsetTable() {
	    	//  1. clear old table
	        offsetTableTree.removeAll();
	        
	        // 2. get system and make a new TaskSet
			String system = getSystemPath();
			if (system == null) {
				tasks = null;
				return;
			}
	        
			tasks = getTaskSet();
			if (tasks == null) {
				return;
			}
	        
			// 3. fill the table
		    
		    // add all items
		    for (int i=1; i<tasks.getPrefixNumber(); i++) {
		    	TableTreeItem tti = new TableTreeItem(offsetTableTree, SWT.NONE);
		    	tti.setText(0, tasks.getPrefix(i));
		    	for (int j=0; j<tasks.getSize(i); j++) {
		    		Task t = (Task) tasks.getItem(i,j);
		    		
				    TableTreeItem ti = new TableTreeItem(tti, SWT.NONE);
				    ti.setText(1, t.getName());
				    ti.setText(2, "" + t.getProperty("offset"));
				    ti.setText(3, "" + t.getProperty("wcet"));
				    ti.setText(4, "" + t.getProperty("period"));
				    ti.setText(5, "" + t.getProperty("deadline"));
				    ti.setText(6, "" + t.getProperty("priority"));

				    ti.setData(new int[] {i,j});
		    	}
		    	tti.setExpanded(true);
		    }
		    
		    // resize all columns
		    TableColumn[] columns = offsetTableTree.getTable().getColumns();
			for (int i = 0; i < columns.length; i++) {
				columns[i].pack();
			}
			
			{ // clear the previous cell
				Control oldEditor = editor.getEditor();
				if (oldEditor != null) oldEditor.dispose();
			}

	    }
		/**
		 * enable / disable the "next" button and show some "Error messages"
		 */
		protected void enableOk() {
			setErrorMessage(errMesg);
			
	        setPageComplete(errMesg == null);
		}

	}

	/**
	 */
	public class AnalysisPage extends WizardPage {
	    public static final int NO_OFFSET_ID          = JScan.NO_OFFSET_ID;
	    public static final int EXACT_FP_ID           = JScan.EXACT_FP_ID;
	    public static final int FLEASIBLE_ID          = JScan.FLEASIBLE_RT_ID;
	    public static final int PERIOD_SENSITIVITY_ID = JScan.PERIOD_SENSITIVITY_ID;

	    protected Button noOffset;
	    protected Button exact;
	    protected Button fleasible;
	    protected Text FText;
		
		protected int currentAnalysis;
		protected int Fvalue = 1;
		protected String validProperty;

		protected TaskSet tasks;

		/**
		 * Make a new Page
		 */
		public AnalysisPage(String pageId) {
			super(pageId);

		}

		/**
		 * Create all widgets
		 */
		public void createControl(Composite parent) {

	        // Create a common listner that uptade properties
	        SelectionListener commonListner =  new SelectionListener() {
		        public void widgetDefaultSelected(SelectionEvent e) { perform(e); }
		        public void widgetSelected(SelectionEvent e) { perform(e); }
		        
		        private void perform(SelectionEvent e) {
		            if (e.getSource() == noOffset) {
		                currentAnalysis = NO_OFFSET_ID;
		            } else if (e.getSource() == exact) {
		                currentAnalysis = EXACT_FP_ID;
		            } else if (e.getSource() == fleasible) {
		                currentAnalysis = FLEASIBLE_ID;
		            } else {
		                return;
		            }
		            
		            checkFValue();
		        }
		    };
	        
		    
	        Composite composite = new Composite (parent, SWT.NONE);
		    {
		        GridLayout layout = new GridLayout (2, false);
		        layout.marginHeight = 10;
		        layout.marginWidth = 10;
		        composite.setLayout (layout);
		    }
		    
			Label containerLabel = new Label(composite, SWT.LEFT);
			{
				containerLabel.setText("Analysis type");

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalSpan = 2;
				containerLabel.setLayoutData(data);
			}

			// WITHOUT OFFSETS
			noOffset = new Button(composite, SWT.RADIO);
			{
			    noOffset.setText("without offset (only sufficient)");
			    //noOffset.setToolTipText(NO_OFFSET_TT);
				noOffset.addSelectionListener(commonListner);
				
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalSpan = 2;
				noOffset.setLayoutData(data);
			}
			
			// WITH OFFSETS : EXACT
			exact = new Button(composite, SWT.RADIO);
			{
			    exact.setText("with offsets (necessary and sufficient)");
			    //exact.setToolTipText(EXACT_TT);
				exact.addSelectionListener(commonListner);

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalSpan = 2;
				exact.setLayoutData(data);
			}
			// WITHOUT OFFSETS : FLEASIBLE
			fleasible = new Button(composite, SWT.RADIO);
			{
			    fleasible.setText("with offsets (only sufficient)");
			    //flesible.setToolTipText(FLEASIBLE_TT);
				fleasible.addSelectionListener(commonListner);

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				fleasible.setLayoutData(data);
			}

			{
				FText = new Text(composite, SWT.LEFT | SWT.BORDER);
				FText.addModifyListener(new ModifyListener() {
					public void modifyText(ModifyEvent e) {
						checkFValue();
					}
				});

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				FText.setLayoutData(data);
			}
			
			super.setControl(composite);
			init();
			
			addListner(new VTListner() {
				public void notify(int event) {
					if (event == CH_RESOURCE_LIST) {

						loadTaskSet();
					}
				}
			});

		}
	    
		/**
		 * enable / disable the "next" button and show some "Error messages"
		 */
		protected void enableOk() {
			FText.setEnabled(currentAnalysis == FLEASIBLE_ID);
			
	        setPageComplete(validProperty == null);
	        setErrorMessage(validProperty);
		}
		
		/**
		 * Initialize all values 
		 */
		public void init() {
			FText.setText("" + Fvalue);

			switch (currentAnalysis) {
				default : // default = NO OFFSET
					
				case NO_OFFSET_ID:
					noOffset.setSelection(true);
					break;
				case EXACT_FP_ID:
					exact.setSelection(true);
					break;
				case FLEASIBLE_ID:
					fleasible.setSelection(true);
					break;
			}
			
			loadTaskSet();
			checkFValue();
		}
		
		/**
		 * Compute the right value for the taskset 
		 */
		protected void loadTaskSet() {
			String system = getSystemPath();
			if (system == null) {
				tasks = null;
				return;
			}
	        
			tasks = new TaskSet(vt, system, mPage.getMode());
			tasks.setProperty(Task.STR_ACT_TYPE,"__see_task__",false);
			tasks.onlyPeriodicTasks();
		}
		
		/**
		 * Check the value of F and set error message (if F is required)
		 */
		protected void checkFValue() {
			// clear all
			validProperty = null;
			
			if (currentAnalysis == FLEASIBLE_ID) {
				String newTxt = FText.getText();
				
				// check (step 1)
				int i = -1;
				try {
					i = Integer.parseInt(newTxt);
				} catch (NumberFormatException exception) {
				}
				// check (step 2)
				int nTask = Integer.MAX_VALUE;
				if (tasks == null) {
					nTask = 0;
				} else {
					for (int l=1; l<tasks.getPrefixNumber(); l++ ) {
						nTask = Math.min(nTask, tasks.getSize(l));
					}
				}
				if ( i < 1 || i >= nTask) {
					validProperty = "F must be an integer greater than 0 and littler than number of task less one (for each rtos)";
				} else {
					Fvalue = i;
				}
			}

			// before end, check for OK button
			enableOk();
		}
		
		/**
		 * Return the current analysis type
		 */
		public int getAnalysis() {
			return currentAnalysis;
		}
		
		/**
		 * Return all setted properties
		 */
		public int getFValue() {
			return Fvalue;
		}
	}
	
	/**
	 */
	public class OutputPage extends WizardPage {
		protected Button rtdViewChk;
		protected Button storeChk;
		protected Button openEditorChk;
		protected Button chooseResource;
		protected Text resourceName;
		
		protected boolean rtdViewValue = true;//true;
		protected boolean storeChkValue = false;
		protected boolean openEditorChkValue = true;
		protected String destName;

		/**
		 * Make a new Page
		 */
		public OutputPage(String pageId) {
			super(pageId);
		}

		/**
		 * Create all widgets
		 */
		public void createControl(Composite parent) {

	        Composite composite = new Composite (parent, SWT.NONE);
		    {
		        GridLayout layout = new GridLayout (3, false);
		        layout.marginHeight = 10;
		        layout.marginWidth = 10;
		        composite.setLayout (layout);
		    }

			Label containerLabel = new Label(composite, SWT.LEFT);
			{
				containerLabel.setText("Output");

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalSpan = 3;
				containerLabel.setLayoutData(data);
			}

			// SHOW RESULTS in RT-DRUID VIEWER?
			rtdViewChk = new Button(composite, SWT.CHECK);
			{
				rtdViewChk.setText("Results in RT-Druid View");
				rtdViewChk.addSelectionListener(new SelectionListener() {
			        public void widgetDefaultSelected(SelectionEvent e) { perform(e); }
			        public void widgetSelected(SelectionEvent e) { perform(e); }
			        
			        private void perform(SelectionEvent e) {
			            if (e.getSource() == rtdViewChk) {
			                rtdViewValue = !rtdViewValue;
			            }
			        }
				    
				});
				
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalSpan = 3;
				rtdViewChk.setLayoutData(data);
			}

			// Store data in a resource
			storeChk = new Button(composite, SWT.CHECK);
			{
			    storeChk.setText("Store as Resource");
			    storeChk.addSelectionListener(new SelectionListener() {
			        public void widgetDefaultSelected(SelectionEvent e) { perform(e); }
			        public void widgetSelected(SelectionEvent e) { perform(e); }
			        
			        private void perform(SelectionEvent e) {
			            if (e.getSource() == storeChk) {
			                storeChkValue = !storeChkValue;

			                openEditorChk.setEnabled(storeChkValue);
			                resourceName.setEnabled(storeChkValue);
			                chooseResource.setEnabled(storeChkValue);

			                enableOk();
			            }
			        }
				    
				});

				storeChk.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
			}

			resourceName = new Text(composite, SWT.READ_ONLY | SWT.LEFT | SWT.BORDER);
			{
			    resourceName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			}

			chooseResource = createButton(composite, "Choose");
			{
			    chooseResource.addSelectionListener(new SelectionListener() {
			        public void widgetDefaultSelected(SelectionEvent e) { perform(e); }
			        public void widgetSelected(SelectionEvent e) { perform(e); }
			        
			        private void perform(SelectionEvent e) {
			            if (e.getSource() == chooseResource) {
			                
			                if (false) {
			                    
			                    WizardNewFileCreationPage wnfc = new WizardNewFileCreationPage("Testo", null);
			                    
			                    SaveAsDialog sad = new SaveAsDialog(getShell());
			                    sad.open();
			                    IPath results =  sad.getResult();
			                }
			                
			                // LOAD FROM RESOURCE (inside workspace)
			                if (true) {
				                ResourceSelectionDialog dialog = 
				            		new ResourceSelectionDialog(getShell(), 
				            		        ResourcesPlugin.getWorkspace().getRoot()
				            		        , "testo");
				            	//dialog.setInitialSelections(null);
				            	dialog.open();
				            	Object[] results =  dialog.getResult();
				            	if (results == null || results.length == 0) {
				            	    return;
				            	}
				            	if (results[0] instanceof IFile) {
				            	    String ext = ((IFile) results[0]).getFullPath().getFileExtension();
				            	    if ("rtd".equalsIgnoreCase(ext) || "ertd".equalsIgnoreCase(ext)) { 
				            	        resourceName.setText(((IFile) results[0]).getFullPath().toOSString());

				            	    } else {
				        		        resourceName.setText("");
					                    MessageDialog.openWarning(
					        					getShell(),
					        					"Warning",
					        		    		"Choose a valid RT-Druid file");
				            	    }
				            	}

				            	destName = null;
					            enableOk();
				            	return;
			            	}
			                
	/*		                // LOAD FROM FILESYSTEM (inside or not of workspace)
			                
			        		// Get the user to choose an image file.
			        		FileDialog fileChooser = new FileDialog(getShell(), SWT.SAVE);
			        		if (lastPath != null)
			        			fileChooser.setFilterPath(lastPath);
			        		fileChooser.setFilterExtensions(new String[] { "*.rtd; *.ertd", "*.rtd", "*.ertd" });
			        		fileChooser.setFilterNames(new String[] { "All RT-Druid files" + " (rtd, ertd)",
			        		                                          "Evidence syntax (*.rtd)", "EMF syntax (*.ertd)" });
			        		String filename = fileChooser.open();
			        		if (filename == null)
			        			return;
			        		lastPath = fileChooser.getFilterPath();

//			        		filename = "";
			        		if (filename.endsWith(".rtd") || filename.endsWith(".ertd")) {
		        		        resourceName.setText(filename);

			        		} else {
		        		        resourceName.setText("");
			                    MessageDialog.openWarning(
			        					getShell(),
			        					"Warning",
			        		    		"Choose a valid RT-Druid file");
			        		}

							destName = null;
			        		enableOk();
	*/		            }
			        }
				    
				});
			}
			
			// open editor after analysis
			openEditorChk = new Button(composite, SWT.CHECK);
			{
			    openEditorChk.setText("Open with Editor");
			    openEditorChk.addSelectionListener(new SelectionListener() {
			        public void widgetDefaultSelected(SelectionEvent e) { perform(e); }
			        public void widgetSelected(SelectionEvent e) { perform(e); }
			        
			        private void perform(SelectionEvent e) {
			            if (e.getSource() == openEditorChk) {
			                openEditorChkValue = !openEditorChkValue;
			            }
			        }
				    
				});

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalIndent = 20;
				openEditorChk.setLayoutData(data);
			}

			
			super.setControl(composite);
			init();
		}
		

		/**
		 * enable / disable the "next" button and show some "Error messages"
		 */
		protected void enableOk() {
			String messg = null;
			boolean enableNext = true;
			
	        if (storeChkValue && (
	        		resourceName.getText() == null || resourceName.getText().length()==0)
				) {
	        	messg = (messg == null ? "" : messg + "\n") + "Choose the resource in which store all results";

	        	enableNext = false;
	        }
	        
        	setPageComplete(enableNext);
        	
	        // print error message 
	        setErrorMessage(messg);
		}
		
		/**
		 * Initialize all values 
		 */
		public void init() {
			
			rtdViewChk.setSelection(rtdViewValue);
			storeChk.setSelection(storeChkValue);
			openEditorChk.setSelection(openEditorChkValue);

		    { // update enable
		        openEditorChk.setEnabled(storeChkValue);
		        resourceName.setEnabled(storeChkValue);
		        chooseResource.setEnabled(storeChkValue);
		    }
		    
			enableOk();
		}
		
		/**
		 * Return if show output in RT-Druid output
		 */
		public boolean getRTDOutput() {
			return rtdViewValue;
		}

		/**
		 * Return where store output (null if none)
		 */
		public String getStore() {
			if (storeChkValue) {
				if (destName == null) {
					destName = resourceName.getText();
				}
				return destName;	
			}
			return null;
		}

		/**
		 * Return if show output in RT-Druid output
		 */
		public boolean getOpenEditort() {
			return openEditorChkValue;
		}

	}
	
	
	///
	protected Button createButton(Composite parent, String label) {
		Button button = new Button(parent, SWT.PUSH);
		button.setText(label);
		button.setFont(JFaceResources.getDialogFont());

		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		
		if (true) {
			GC gc = new GC(parent);
			gc.setFont(JFaceResources.getDialogFont());
			FontMetrics fontMetrics = gc.getFontMetrics();
			gc.dispose();
			
			data.heightHint = Dialog.convertVerticalDLUsToPixels(fontMetrics, IDialogConstants.BUTTON_HEIGHT);
			int widthHint = Dialog.convertHorizontalDLUsToPixels(fontMetrics, IDialogConstants.BUTTON_WIDTH);
			data.widthHint = Math.max(widthHint, button.computeSize(SWT.DEFAULT,
					SWT.DEFAULT, true).x);
		} else {
//			data.heightHint = IDialogConstants.BUTTON_HEIGHT;
			int widthHint = IDialogConstants.BUTTON_WIDTH;
			data.widthHint = Math.max(widthHint, button.computeSize(SWT.DEFAULT,
					SWT.DEFAULT, true).x);
			
		}
		button.setLayoutData(data);
		return button;

	}
	
	/** Show logo */
	static {
	    new ShowLogo();
	}
}
