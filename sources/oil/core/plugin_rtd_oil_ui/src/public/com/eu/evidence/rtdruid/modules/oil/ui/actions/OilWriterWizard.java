/*
 * Created on Jul 14, 2004
 *
 * $Id: OilWriterWizard.java,v 1.4 2008/03/26 18:23:55 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.ui.actions;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ContainerGenerator;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.eclipse.ui.dialogs.WizardResourceImportPage;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilReaderFactory;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.RtosFactory;
import com.eu.evidence.rtdruid.modules.oil.ui.Rtd_oil_uiPlugin;
import com.eu.evidence.rtdruid.ui.common.RTDConsole;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

/**
 * TODO commentare
 * 
 * 
 * @author Nicola Serreli
 */
public class OilWriterWizard extends Wizard {

	// Output Options
	
	final static int OUT_OVERWRITE = 0;
	final static int OUT_IGNORE = 1;
	final static int OUT_CANCEL = 2;
	
	// ---------------
	
	protected InputPage inPage;
	protected OutputPage oPage;
	
	protected IVarTree vt;
	final protected boolean enableInput;
	
	// ---------------
	
	public OilWriterWizard() {
		super();
		
		enableInput = true;
		
		commonConstructor();
	}
	public OilWriterWizard(boolean enableInput) {
		super();
		
		this.enableInput = enableInput;
		
		commonConstructor();
	}
	
	protected void commonConstructor() {
		setWindowTitle("Oil configurator");
		try {
		    setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(
		            Rtd_oil_uiPlugin.getDefault().getImage("full/oil2")));
		} catch (IOException e) {
		    //
		}
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.IWizard#addPages()
	 */
	public void addPages() {
		{
			inPage = new InputPage("INPUT_ID");
			inPage.setTitle("Source");
			inPage.setDescription("Select the oil file");
			addPage(inPage);
		}
		{
			oPage = new OutputPage("OUTPUT_ID", new StructuredSelection());
			oPage.setTitle("Output folder");
			oPage.setDescription("Select the output folder");
			addPage(oPage);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#getStartingPage()
	 */
	public IWizardPage getStartingPage() {
		return enableInput ? super.getStartingPage() : oPage;
	}
	
	
	/**
	 * Start analysis
	 */

	
	public boolean performFinish() {
		
		
		// use, if available, rtdruidOutput
		boolean outputEnable = false;
			
		RTDConsole console = RTDConsole.getConsole();
		if (console != null && console.getMessages() != null) {
			Messages.setCurrent(console.getMessages());
			Messages.clearNumbers();
			// console.clear();
			outputEnable = true;
		}

		try {
			/***********************************************************************
			 * PREPARE A MONITOR
			 **********************************************************************/
			
			IProgressMonitor monitor = null;
			
			/***********************************************************************
			 * LOAD
			 **********************************************************************/
			// already loaded
	        //if (!loadOilFile(inPage.getResources())) {
	        //	return false;
	        //}
	        
	        /***********************************************************************
			 * SEARCH ALL RT-OS
			 **********************************************************************/
			String[] rtosPath = searchRtos();
			if (rtosPath == null) {
				return false;
			}
	        
	        if (rtosPath.length == 0) {
	        	MessageDialog.openError(getShell(), "Errors", "No RT-OS found");
	        	return false;
	        }
	        
	        /***********************************************************************
			 * PARSE FILES AND PREPARE BUFFERS
			 **********************************************************************/
	        Messages.sendTextNl("Compute configuration's files\n");
	        IOilWriterBuffer[] buffers = null;
	        try {
	        	buffers = RtosFactory.INSTANCE.write(vt, rtosPath, getWriterProperties());
	        } catch (OilCodeWriterException e) {
				e.printStackTrace();
				MessageDialog.openError(getShell(), "Errors", e.getMessage());
				return false;
	        }
	
	        /***********************************************************************
			 * PREPARE FOLDER INSIDE THE WORKSPACE)
			 * 
			 * &&
			 * 
			 * SAVE (as RESOURCES inside the WORKSPACE)
			 **********************************************************************/
	        return store(monitor, buffers);
		} finally {
			if (outputEnable) {
				if (Messages.getErrorNumber() >0) {
					Messages.sendTextNl("\nThere are some Errors.");
				} else if (Messages.getWarningNumber() >0) {
					Messages.sendTextNl("\nThere are some Warnings.");
				} else {
					Messages.sendTextNl("\nGood, it's all ok.");
				}
				Messages.setPrevious();
			}
		}
	}

	
	/**
	 * Load the Oil File
	 */
	public boolean loadOilFile(String inputFile) {
		if (inputFile == null) {
			return false;
		}
		
		IFile fPath = ResourcesPlugin.getWorkspace().getRoot()
		.getFile(new Path(inputFile));
		
		vt = VarTreeUtil.newVarTree();
        try {
        	(OilReaderFactory.getAnOilReader()).load(fPath.getContents(), vt);

        	IProject project = fPath.getProject();
        	
        	if (project != null) {
        	    vt.getProperties().put(IWritersKeywords.VTProperty_OilProjectName, project.getName());
        	    IPath path = project.getLocation();
        	    
       	        vt.getProperties().put(IWritersKeywords.VTProperty_OilProjectPath,
       	                path == null ? project.getName() : path.toString());
        	}
        } catch (Exception e) {
			//e.printStackTrace();
			MessageDialog.openError(getShell(), "Error",
					"Unable to load \"" + inputFile + "\".\n"
							+ e.getMessage());
			return false;
        }

		return true;
	}
	
	/**
	 * 
	 * */
	protected String[] searchRtos() {
        DataPackage dpkg = DataPackage.eINSTANCE;
        String S = "" +DataPath.SEPARATOR;
        
        ITreeInterface ti = vt.newTreeInterface();
        
        String prefix = null;
        String[] tmp = ti.getAllName(prefix, dpkg.getSystem().getName());
        if (tmp.length==0) {
        	MessageDialog.openError(getShell(), "Errors",
        		"No System found");
        	return null;
        }
        
        prefix = tmp[0] 
        	+S+ dpkg.getSystem_Architectural().getName()
			+S+ dpkg.getArchitectural_EcuList().getName();
        
        tmp = ti.getAllName(prefix, dpkg.getEcu().getName());
        if (tmp.length==0) {
        	MessageDialog.openError(getShell(), "Errors", "No Ecu found");
        	return null;
        }
        
        // store all rtos
        ArrayList rtosPath = new ArrayList();
        
        // search all ecu
        for (int i=0; i<tmp.length; i++ ) {
        	
	        String currPrefix = prefix+ S+ tmp[i]
				+S+ dpkg.getEcu_CpuList().getName();
	        
	        
	        String[] tmp2 = ti.getAllName(currPrefix, dpkg.getCpu().getName());
	        if (tmp2.length==0) {
	        	continue;
	        }
	        
	        // search all cpu
	        for (int l=0; l<tmp2.length; l++ ) {
	        	
		        String currRtosPrefix = currPrefix+ S+ tmp2[l]
				+S+ dpkg.getCpu_Rtos().getName();
		        if (ti.exist(currRtosPrefix, null)) {
		        	rtosPath.add(currRtosPrefix);
		        }
	        }
        }

        return (String[]) rtosPath.toArray(new String[rtosPath.size()]);
	}

	/**
	 * Store buffers inside the workspace
	 */
	protected boolean store(IProgressMonitor monitor, IOilWriterBuffer[] buffers) {
        /***********************************************************************
		 * PREPARE FOLDER INSIDE THE WORKSPACE)
		 **********************************************************************/
        Messages.sendTextNl("Prepare folders\n");
        final IPath path = oPage.getOutputDir();
        
        if (path == null) {
        	return false;
        }
                
        final ContainerGenerator cg = new ContainerGenerator(path);
        final IContainer container; 
		try {
			container = cg.generateContainer(monitor);
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(getShell(), "Errors", e.getMessage());
			return false;
		}
        
		if (!(container instanceof IFolder)) {
			MessageDialog.openError(getShell(), "Errors", "Expected an folder.");
			return false;
		}
		
        /***********************************************************************
		 * SAVE (as RESOURCES inside the WORKSPACE)
		 **********************************************************************/
        Messages.sendTextNl("Save files\n");
		final int outOption = oPage.getOutputOption(); 
		for (int bi=0; bi<buffers.length; bi++) {
			String[] keys = buffers[bi].getKeys();
			
			
			for (int ki=0; ki<keys.length; ki++) {
				String fileName = buffers[bi].getFileName(keys[ki]);
				IFile newFile = ((IFolder) container).getFile(fileName);
				
		        final String messagePrefix = "\t" + fileName;
				
				// the current file already exist
				if (newFile.exists()) {
					switch (outOption) {
						case OUT_CANCEL :
							Messages.sendTextNl(messagePrefix+"\tERROR : Already exist");
							MessageDialog.openError(getShell(), "Errors", "'"+newFile.getFullPath()+"' already exist.");
							return false;

						case OUT_IGNORE :
							// next file
							Messages.sendTextNl(messagePrefix+"\tnot saved : Already exist");
							break;

						case OUT_OVERWRITE :
							try {
								InputStream fileStream = new ByteArrayInputStream(
										buffers[bi].get(keys[ki]).toString().getBytes());
								newFile.setContents(fileStream, IFile.FORCE, monitor);
							} catch (CoreException e) {
								e.printStackTrace();
								MessageDialog.openError(getShell(), "Errors", e.getMessage());
								return false;
							}
							Messages.sendTextNl(messagePrefix+"\tOK (overwrite)");
							break;
					}
				} else {
					try {
						InputStream fileStream = new ByteArrayInputStream(
								buffers[bi].get(keys[ki]).toString().getBytes());
						newFile.create(fileStream, IFile.FORCE, monitor);
					} catch (CoreException e) {
						e.printStackTrace();
						MessageDialog.openError(getShell(), "Errors", e.getMessage());
						Messages.sendTextNl(messagePrefix+"\tERROR");
						return false;
					}
					Messages.sendTextNl(messagePrefix+"\tOK");
				}
			}
		}
		
		return true;
	}
	
	/** Returns some properties required/used by Configuration's writer */
	protected HashMap getWriterProperties() {
		return null;
	}

	/***************************************************************************
	 * All pages
	 **************************************************************************/
	
	/**
	 */
	public class InputPage extends WizardPage {
		
	    protected Button browse;
	    protected Text fileTxt;
	    protected String inputFile;
	    
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
		        GridLayout layout = new GridLayout (3, false);
		        layout.marginHeight = 10;
		        layout.marginWidth = 10;
			    composite.setLayout (layout);
		    }

			Label containerLabel = new Label(composite, SWT.LEFT);
			{
				containerLabel.setText("Input file: ");
				containerLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			}

		    fileTxt = new Text(composite, SWT.READ_ONLY | SWT.BORDER);
		    {
				fileTxt.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
		    }
			
		    { // ADD
		    	browse = createButton(composite, "Browse" /*IDEWorkbenchMessages.getString("WizardImportPage.browse2")*/);
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
				            		        , "Choose the oil file that describes the system");
				            	//dialog.setInitialSelections(null);
				            	dialog.open();
				            	Object[] results =  dialog.getResult();
				            	if (results == null) {
				            	    return;
				            	}
				            	for (int i=0; i<results.length; i++) {
					            	if (results[i] instanceof IFile) {
					            	    String ext = ((IFile) results[i]).getFullPath().getFileExtension();
					            	    if ("oil".equalsIgnoreCase(ext)) { 
					            	        fileTxt.setText(((IFile) results[i]).getFullPath().toOSString());
					            	    }
					            	}
				            	}
				                
				                // clear cache and check values
				                inputFile = null;
				                enableOk();
				            	return;
			                }
			            }
			        }
			    });
		    }

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
	        	boolean loaded = loadOilFile(getResources());
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
		protected void init() {

			// no default values
			inputFile = null;
			
			{ // check if the current editor is working on a Oil File
				IWorkbench iw = PlatformUI.getWorkbench();
				IWorkbenchWindow iww = (iw == null ? null : iw.getActiveWorkbenchWindow());
				IWorkbenchPage iwp = (iww == null ? null : iww.getActivePage());
				iw.getDisplay().getActiveShell();
				
				IEditorPart activeEditor = (iwp == null ? null : iwp.getActiveEditor()); 
				if (activeEditor != null && activeEditor.getEditorInput() instanceof IFileEditorInput) {
					String tmp = ((IFileEditorInput) activeEditor.getEditorInput()).getFile().getFullPath().toString();
					if (tmp.endsWith(".oil")) {
						fileTxt.setText(tmp);
					}
				}
			}
			
			enableOk();
 		}
		
		/**
		 * Return all choosen resources
		 */
		public String getResources() {
			if (inputFile == null) {
				if (!"".equals(fileTxt.getText())) {
					inputFile = fileTxt.getText();
				}
			}
			return inputFile;
		}
	}

	/**
	 * 
	 */
	public class OutputPage extends WizardResourceImportPage {
		private String currentProblem = null;
		
		final static String ERROR_MSG = "Choose the folder in which store all results";
		
		public OutputPage(String pageId, IStructuredSelection selection) {
			super(pageId, selection);
		}
		
		// ---------------------------------------------
		
		/* (non-Javadoc)
		 * @see org.eclipse.ui.dialogs.WizardDataTransferPage#createOptionsGroup(org.eclipse.swt.widgets.Composite)
		 */
		protected void createOptionsGroup(Composite parent) {
			// disable option sections
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.ui.dialogs.WizardResourceImportPage#createSourceGroup(org.eclipse.swt.widgets.Composite)
		 */
		protected void createSourceGroup(Composite parent) {
			// Nothing
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.ui.dialogs.WizardResourceImportPage#getFileProvider()
		 */
		protected ITreeContentProvider getFileProvider() {
			// nothing
			return null;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.ui.dialogs.WizardResourceImportPage#getFolderProvider()
		 */
		protected ITreeContentProvider getFolderProvider() {
			// nothing
			return null;
		}
		
		//---------------------------------------
		
		/**
		 * Opens a container selection dialog and displays the user's subsequent
		 * container resource selection in this page's container name field.
		 */
		protected void handleContainerBrowseButtonPressed() {
			// see if the user wishes to modify this container selection
			IPath containerPath =
				queryForContainer(
					getSpecifiedContainer(), 
					"Choose the output folder",
					"Output folder");

			// if a container was selected then put its name in the container name field
			if (containerPath != null) { // null means user cancelled
				setErrorMessage(null);
				setContainerFieldValue(containerPath.makeRelative().toString());
			}
		}

		/**
		 * Returns the container resource specified in the container name entry field,
		 * or <code>null</code> if such a container does not exist in the workbench.
		 *
		 * @return the container resource specified in the container name entry field,
		 *   or <code>null</code>
		 */
		protected IContainer getSpecifiedContainer() {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IPath path = getContainerFullPath();
			if (workspace.getRoot().exists(path)) {
				
				IResource res = workspace.getRoot().findMember(path);
				if (res instanceof IContainer) {
					return (IContainer) workspace.getRoot().findMember(path);
				}
				
				currentProblem = "Specified path identifies a file, not a folder.";
				return null;
			}

			return null;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.ui.dialogs.WizardDataTransferPage#validateOptionsGroup()
		 */
		protected boolean validateOptionsGroup() {
			if (currentProblem != null) {
				setErrorMessage(currentProblem);
				currentProblem = null;
				return false;
			}
			return true;
		}
		
		// -----------------------------------------------------

		public IPath getOutputDir() {
			return getContainerFullPath();
		}
		
		public int getOutputOption() {
			return OUT_OVERWRITE;
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
}
