/**
 * <copyright>
 * </copyright>
 *
 * $Id: DataModelWizard.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.data.presentation;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.modules.jscan.ui.rtd_jscan_ui.Rtd_jscan_uiPlugin;
import com.eu.evidence.rtdruid.ui.Rtd_core_uiPlugin;
import com.eu.evidence.rtdruid.vartree.VarTreeIdHandler;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;




/**
 * This is a simple wizard for creating a new model file.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DataModelWizard extends Wizard implements INewWizard {
	/**
	 * This caches an instance of the model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataPackage dataPackage = DataPackage.eINSTANCE;

//	/**
//	 * This caches an instance of the model factory.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	protected DataFactory dataFactory = dataPackage.getDataFactory();

	/**
	 * This is the file creation page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataModelWizardNewFileCreationPage newFileCreationPage;

	/**
	 * This is the file creation page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataModelWizardInitialObjectCreationPage initialObjectCreationPage;

	/**
	 * Remember the selection during initialization for populating the default container.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IStructuredSelection selection;

	/**
	 * Remember the workbench during initialization.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IWorkbench workbench;

	/**
	 * This just records the information.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(Rtd_jscan_uiPlugin.getResourceString("_UI_Wizard_label"));
		try {
			setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(Rtd_jscan_uiPlugin.getDefault().getImage("full/wizban/NewData")));
		} catch (IOException e) {
			RtdruidLog.log(e);
		}
	}

	/**
	 * Create a new model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EObject createInitialModel() {
//		EClass eClass = (EClass)dataPackage.getEClassifier(initialObjectCreationPage.getInitialObjectName());
//		EObject rootObject = dataFactory.create(eClass);
		EObject rootObject = VarTreeUtil.newVarTreeRoot(VarTreeUtil.newVarTree());
		VarTreeIdHandler.setId(rootObject, "default system");
		return rootObject;
	}

	/**
	 * Do the work after everything is specified.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean performFinish() {
		try {
			// Remember the file.
			//
			final IFile modelFile = getModelFile();

			// Do the work within an operation.
			//
			WorkspaceModifyOperation operation =
				new WorkspaceModifyOperation() {
					protected void execute(IProgressMonitor progressMonitor) {
						try {
							// Create a resource set
							//
							ResourceSet resourceSet = new ResourceSetImpl();

							// Get the URI of the model file.
							//
							URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString());

							// Create a resource for this file.
							//
							Resource resource = resourceSet.createResource(fileURI);

							// Add the initial model object to the contents.
							//
							EObject rootObject = createInitialModel();
							if (rootObject != null) {
								resource.getContents().add(rootObject);
							}

							// Save the contents of the resource to the file system.
							//
							Map options = new HashMap();
							options.put(XMLResource.OPTION_ENCODING, initialObjectCreationPage.getEncoding());
							resource.save(options);
						}
						catch (Exception exception) {
						    RtdruidLog.log(exception);
						}
						finally {
							progressMonitor.done();
						}
					}
				};

			getContainer().run(false, false, operation);

			// Select the new file resource in the current view.
			//
			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = workbenchWindow.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if (activePart instanceof ISetSelectionTarget) {
				final ISelection targetSelection = new StructuredSelection(modelFile);
				getShell().getDisplay().asyncExec
					(new Runnable() {
						 public void run() {
							 ((ISetSelectionTarget)activePart).selectReveal(targetSelection);
						 }
					 });
			}

			// Open an editor on the new file.
			//
			try {
				page.openEditor
					(new FileEditorInput(modelFile),
					 workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());
			}
			catch (PartInitException exception) {
				MessageDialog.openError(workbenchWindow.getShell(), Rtd_core_uiPlugin.getResourceString("_UI_OpenEditorError_label"), exception.getMessage());
				return false;
			}

			return true;
		}
		catch (Exception exception) {
			RtdruidLog.log(exception);
			return false;
		}
	}

	/**
	 * This is the one page of the wizard.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public class DataModelWizardNewFileCreationPage extends WizardNewFileCreationPage {
		/**
		 * Remember the model file.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected IFile modelFile;

		/**
		 * Pass in the selection.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public DataModelWizardNewFileCreationPage(String pageId, IStructuredSelection selection) {
			super(pageId, selection);
		}

		/**
		 * The framework calls this to see if the file is correct.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated NOT
		 */
		protected boolean validatePage() {
			if (super.validatePage()) {
				// Make sure the file ends in ".ertd" or in ".rtd".
				//
				String requiredExt1 = Rtd_core_uiPlugin.getResourceString("_UI_DataEditorFilenameExtension1");
				String requiredExt2 = Rtd_core_uiPlugin.getResourceString("_UI_DataEditorFilenameExtension2");
				String enteredExt = new Path(getFileName()).getFileExtension();
				if (enteredExt == null || !(enteredExt.equals(requiredExt1) || enteredExt.equals(requiredExt2) ) ) {
					setErrorMessage(Rtd_core_uiPlugin.getDefault().getString("_WARN_FilenameExtension", new Object [] { requiredExt1, requiredExt2 }));
					return false;
				}
				else {
					return true;
				}
			}
			else {
				return false;
			}
		}

		/**
		 * Store the dialog field settings upon completion.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public boolean performFinish() {
			modelFile = getModelFile();
			return true;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public IFile getModelFile() {
			return
				modelFile == null ?
					ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName())) :
					modelFile;
		}
	}

	/**
	 * This is the page where the type of object to create is selected.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public class DataModelWizardInitialObjectCreationPage extends WizardPage {
		/**
		 * @generated NOT
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 */
		protected String initialObjectName = "System";

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected Combo initialObjectField;

		/**
		 * @generated NOT
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 */
		protected String encoding = "UTF-8";

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected Combo encodingField;

		/**
		 * Pass in the selection.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public DataModelWizardInitialObjectCreationPage(String pageId) {
			super(pageId);
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated NOT
		 */
		public void createControl(Composite parent) {
/*			Composite composite = new Composite(parent, SWT.NONE);
			{
				GridLayout layout = new GridLayout();
				layout.numColumns = 1;
				layout.verticalSpacing = 12;
				composite.setLayout(layout);

				GridData data = new GridData();
				data.verticalAlignment = GridData.FILL;
				data.grabExcessVerticalSpace = true;
				data.horizontalAlignment = GridData.FILL;
				composite.setLayoutData(data);
			}

			Label containerLabel = new Label(composite, SWT.LEFT);
			{
				containerLabel.setText(DataEditorPlugin.INSTANCE.getString("_UI_ModelObject"));

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				containerLabel.setLayoutData(data);
			}

			initialObjectField = new CCombo(composite, SWT.BORDER);
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				initialObjectField.setLayoutData(data);
			}

			List objectNames = new ArrayList();
			for (Iterator classifier = dataPackage.getEClassifiers().iterator(); classifier.hasNext(); ) {
				EClassifier eClassifier = (EClassifier)classifier.next();
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass)eClassifier;
					if (!eClass.isAbstract()) {
						objectNames.add(eClass.getName());
					}
				}
			}

			Collections.sort(objectNames, java.text.Collator.getInstance());
			for (Iterator i = objectNames.iterator(); i.hasNext(); ) {
				String objectName = (String)i.next();
				initialObjectField.add(objectName);
			}

			initialObjectField.addSelectionListener
				(new SelectionAdapter() {
					 public void widgetSelected(SelectionEvent e) {
						 setPageComplete(isPageComplete());
					 }
				 });

			Label encodingLabel = new Label(composite, SWT.LEFT);
			{
				encodingLabel.setText(DataEditorPlugin.INSTANCE.getString("_UI_XMLEncoding"));

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				encodingLabel.setLayoutData(data);
			}
			encodingField = new CCombo(composite, SWT.BORDER);
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				encodingField.setLayoutData(data);
			}

			for (StringTokenizer stringTokenizer = new StringTokenizer(DataEditorPlugin.INSTANCE.getString("_UI_XMLEncodingChoices")); stringTokenizer.hasMoreTokens(); ) {
				encodingField.add(stringTokenizer.nextToken());
			}
			encodingField.select(0);

			setControl(composite);
*/		}

		/**
		 * The framework calls this to see if the file is correct.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated NOT
		 */
		public boolean isPageComplete() {
			if (true) {
				throw new UnsupportedOperationException();
			}
			if (super.isPageComplete()) {
				return initialObjectField.getSelectionIndex() != -1;
			}
			else {
				return false;
			}
		}

		/**
		 * Store the dialog field settings upon completion.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public boolean performFinish() {
			initialObjectName = getInitialObjectName();
			encoding = getEncoding();
			return true;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public String getInitialObjectName() {
			return
				initialObjectName == null ?
					initialObjectField.getText() :
					initialObjectName;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public String getEncoding() {
			return
				encoding == null ?
					encodingField.getText() :
					encoding;
		}
	}

	/**
	 * The framework calls this to create the contents of the wizard.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addPages() {
		// Create a page, set the title, and the initial model file name.
		//
		newFileCreationPage = new DataModelWizardNewFileCreationPage("Whatever", selection);
		newFileCreationPage.setTitle(Rtd_jscan_uiPlugin.getResourceString("_UI_DataModelWizard_label"));
		newFileCreationPage.setDescription(Rtd_jscan_uiPlugin.getResourceString("_UI_DataModelWizard_description"));
		newFileCreationPage.setFileName(Rtd_core_uiPlugin.getResourceString("_UI_DataEditorFilenameDefaultBase") + "." + Rtd_core_uiPlugin.getResourceString("_UI_DataEditorFilenameExtension1"));
		addPage(newFileCreationPage);

		// Try and get the resource selection to determine a current directory for the file dialog.
		//
		if (selection != null && !selection.isEmpty()) {
			// Get the resource...
			//
			Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file.
				//
				IResource selectedResource = (IResource)selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}

				// This gives us a directory...
				//
				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container.
					//
					//String currentDirectory =
							selectedResource.getLocation().toOSString();
					newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

					// Make up a unique new name here.
					//
					String defaultModelBaseFilename = Rtd_core_uiPlugin.getResourceString("_UI_DataEditorFilenameDefaultBase");
					String defaultModelFilenameExtension = Rtd_core_uiPlugin.getResourceString("_UI_DataEditorFilenameExtension1");
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
					}
					newFileCreationPage.setFileName(modelFilename);
				}
			}
		}
		initialObjectCreationPage = new DataModelWizardInitialObjectCreationPage("Whatever2");
		initialObjectCreationPage.setTitle(Rtd_jscan_uiPlugin.getResourceString("_UI_DataModelWizard_label"));
		initialObjectCreationPage.setDescription(Rtd_jscan_uiPlugin.getResourceString("_UI_Wizard_initial_object_description"));
/*		addPage(initialObjectCreationPage); */
	}

	/**
	 * Get the file from the page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFile getModelFile() {
		return newFileCreationPage.getModelFile();
	}

}
