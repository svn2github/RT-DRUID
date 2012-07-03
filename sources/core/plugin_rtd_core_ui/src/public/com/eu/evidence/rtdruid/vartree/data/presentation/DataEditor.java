/**
 * <copyright>
 * </copyright>
 *
 * $Id: DataEditor.java,v 1.4 2007/09/12 15:58:30 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.data.presentation;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.command.DragAndDropCommand;
import org.eclipse.emf.edit.command.PasteFromClipboardCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPathEditorInput;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.part.MultiPageSelectionProvider;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.eu.evidence.rtdruid.desk.Messages;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.io.IVTResource;
import com.eu.evidence.rtdruid.io.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.ui.Rtd_core_uiPlugin;
import com.eu.evidence.rtdruid.ui.common.ShowLogo;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreeProvider;
import com.eu.evidence.rtdruid.vartree.IllegalIDException;
import com.eu.evidence.rtdruid.vartree.VarTreeIdHandler;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.data.Activation;
import com.eu.evidence.rtdruid.vartree.data.CacheMissCostList;
import com.eu.evidence.rtdruid.vartree.data.CpuSched;
import com.eu.evidence.rtdruid.vartree.data.ExecTimeList;
import com.eu.evidence.rtdruid.vartree.data.MutexRef;
import com.eu.evidence.rtdruid.vartree.data.PartialOrder;
import com.eu.evidence.rtdruid.vartree.data.ResourceRef;
import com.eu.evidence.rtdruid.vartree.data.Rtos;
import com.eu.evidence.rtdruid.vartree.data.Sample;
import com.eu.evidence.rtdruid.vartree.data.Scheduling;
import com.eu.evidence.rtdruid.vartree.data.SchedulingScenario;
import com.eu.evidence.rtdruid.vartree.data.TaskSched;
import com.eu.evidence.rtdruid.vartree.data.TimeConst;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;


/**
 * This is an example of a Data model editor.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DataEditor
	extends MultiPageEditorPart
	implements IEditingDomainProvider, IMenuListener, IViewerProvider, IGotoMarker,
	 IVarTreeProvider {
	
	/**
	 * This keeps track of the editing domain that is used to track all changes to the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	//protected AdapterFactoryEditingDomain editingDomain;
    protected IVarTree editingDomain;

	/**
	 * This is the one adapter factory used for providing views of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory adapterFactory;

	/**
	 * This is the content outline page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IContentOutlinePage contentOutlinePage;

	/**
	 * This is a kludge...
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IStatusLineManager contentOutlineStatusLineManager;

	/**
	 * This is the content outline page's viewer.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeViewer contentOutlineViewer;

	/*protected ISelectionChangedListener contentOutlineListener = new ISelectionChangedListener() {
		 // This ensures that we handle selections correctly.
		 //
		 public void selectionChanged(SelectionChangedEvent event) {
//			 handleContentOutlineSelection(event.getSelection());
		 }
	 };*/
	 
	/**
	 * This is the property sheet page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertySheetPage propertySheetPage;

	
//	protected FunctionalFlowViewer functionalFlowViewer;
	
	/**
	 * This is the viewer that shadows the selection in the content outline.
	 * The parent relation must be correctly defined for this to work.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeViewer selectionViewer;

	/**
	 * This inverts the roll of parent and child in the content provider and show parents as a tree.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	//protected TreeViewer parentViewer;

	/**
	 * This shows how a tree view works.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	//protected TreeViewer treeViewer;

	/**
	 * This shows how a list view works.
	 * A list viewer doesn't support icons.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	//protected ListViewer listViewer;

	/**
	 * This shows how a table view works.
	 * A table can be used as a list with icons.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	//protected TableViewer tableViewer;

	/**
	 * This shows how a table view works.
	 * A table can be used as a list with icons.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	//protected TableTreeViewer tableTreeViewer;

	/**
	 * This keeps track of the active viewer pane, in the book.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewerPane currentViewerPane;

	/**
	 * This keeps track of the active content viewer, which may be either one of the viewers in the pages or the content outline viewer.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Viewer currentViewer;

	/**
	 * This listens to which ever viewer is active.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ISelectionChangedListener selectionChangedListener;

	protected MultiPageSelectionProvider multiPageSelectionProvider;
	
	/**
	 * This keeps track of all the {@link org.eclipse.jface.viewers.ISelectionChangedListener}s that are listening to this editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	//protected Collection selectionChangedListeners = new ArrayList();

	/**
	 * This keeps track of the selection of the editor as a whole.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	//protected ISelection lastSelection= StructuredSelection.EMPTY;

	/**
	 * For each page, store the appropriate IPropertySourceProvider
	 **/
	IPropertySourceProvider[] pagePropertySourceProvider;
	
	/**
	 * This listens for when the outline becomes active
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IPartListener partListener =
		new IPartListener() {
			public void partActivated(IWorkbenchPart p) {
				if (p instanceof ContentOutline) {
					if (((ContentOutline)p).getCurrentPage() == contentOutlinePage &&
							getActionBarContributor() != null) {
						getActionBarContributor().setActiveEditor(DataEditor.this);

						if (propertySheetPage != null) {
							propertySheetPage.setPropertySourceProvider(pagePropertySourceProvider[0]);
						}

						setCurrentViewer(contentOutlineViewer);
					}
				}
				else if (p instanceof PropertySheet) {
					if (((PropertySheet)p).getCurrentPage() == propertySheetPage) {
						getActionBarContributor().setActiveEditor(DataEditor.this);

						handleActivate();
					}
				}
				else if (p == DataEditor.this) {
					
					if (propertySheetPage != null) {
						propertySheetPage.setPropertySourceProvider(getPagePropertySourceProvider());
					}
					
					handleActivate();
				}
			}
			public void partBroughtToTop(IWorkbenchPart p) {
			}
			public void partClosed(IWorkbenchPart p) {
			}
			public void partDeactivated(IWorkbenchPart p) {
			}
			public void partOpened(IWorkbenchPart p) {
			}
		};

	/**
	 * Resources that have been removed since last activation.
	 * @generated
	 */
	Collection removedResources = new ArrayList();

	/**
	 * Resources that have been changed since last activation.
	 * @generated
	 */
	Collection changedResources = new ArrayList();

	/**
	 * Resources that have been saved.
	 * @generated
	 */
	Collection savedResources = new ArrayList();

	/**
	 * This listens for workspace changes.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IResourceChangeListener resourceChangeListener =
		new IResourceChangeListener() {
			public void resourceChanged(IResourceChangeEvent event) {
				//ResourceSet resourceSet = editingDomain.getResourceSet();
				// Only listening to these.
				// if (event.getType() == IResourceDelta.POST_CHANGE)
				{
					IResourceDelta delta = event.getDelta();
					try {
						class ResourceDeltaVisitor implements IResourceDeltaVisitor {
							protected ResourceSet resourceSet = editingDomain.getResourceSet();
							protected Collection changedResources = new ArrayList();
							protected Collection removedResources = new ArrayList();

							public boolean visit(IResourceDelta delta) {
								if (delta.getFlags() != IResourceDelta.MARKERS &&
								      delta.getResource().getType() == IResource.FILE) {
									if ((delta.getKind() & (IResourceDelta.CHANGED | IResourceDelta.REMOVED)) != 0) {
										Resource resource = resourceSet.getResource(URI.createURI(delta.getFullPath().toString()), false);
										if (resource != null) {
											if ((delta.getKind() & IResourceDelta.REMOVED) != 0) {
												removedResources.add(resource);
											}
											else {
												changedResources.add(resource);
											}
										}
									}
								}

								return true;
							}

							public Collection getChangedResources() {
								return changedResources;
							}

							public Collection getRemovedResources() {
								return removedResources;
							}
						}

						ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
						delta.accept(visitor);

						removedResources.addAll(visitor.getRemovedResources());
						if (!visitor.getRemovedResources().isEmpty() && !isDirty()) {
							getSite().getShell().getDisplay().asyncExec
								(new Runnable() {
									public void run() {
										getSite().getPage().closeEditor(DataEditor.this, false);
										DataEditor.this.dispose();
									}
								 });
						}

						changedResources.addAll(visitor.getChangedResources());
					}
					catch (CoreException exception) {
					    RtdruidLog.log(exception);
					}
				}
			}
		};

	/**
	 * Handles activation of the editor or it's associated views.
	 * @generated
	 */
	protected void handleActivate() {
		// Recompute the read only state.
		//
		if (editingDomain.getResourceToReadOnlyMap() != null) {
		  editingDomain.getResourceToReadOnlyMap().clear();

		  // Refresh any actions that may become enabled or disabled.
		  //
		  setSelection(getSelection());
		}

		if (!removedResources.isEmpty()) {
			if (handleDirtyConflict()) {
				getSite().getPage().closeEditor(DataEditor.this, false);
				DataEditor.this.dispose();
			}
			else {
				removedResources.clear();
				changedResources.clear();
				savedResources.clear();
			}
		}
		else if (!changedResources.isEmpty()) {
			changedResources.removeAll(savedResources);
			handleChangedResources();
			changedResources.clear();
			savedResources.clear();
		}
	}


	/**
	 * Handles what to do with changed resources on activation.
	 * @generated
	 */
	protected void handleChangedResources() {
		if (!changedResources.isEmpty() && (!isDirty() || handleDirtyConflict())) {
		  editingDomain.getCommandStack().flush();

			for (Iterator i = changedResources.iterator(); i.hasNext(); ) {
				Resource resource = (Resource)i.next();
				if (resource.isLoaded()) {
					resource.unload();
					try {
						resource.load(Collections.EMPTY_MAP);
					}
					catch (IOException exception) {
						RtdruidLog.log(exception);
					}
				}
			}
		}
	}

	/**
	 * Shows a dialog that asks if conflicting changes should be discarded.
	 * @generated
	 */
	protected boolean handleDirtyConflict() {
		return
			MessageDialog.openQuestion
				(getSite().getShell(),
				 getString("_UI_FileConflict_label"),
				 getString("_WARN_FileConflict"));
	}

	/**
	 * This creates a model editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DataEditor() {
		super();

		// Create the command stack that will notify this editor as commands are executed.
		//
		BasicCommandStack commandStack = new BasicCommandStack() {
			
				/** Try to send a message to user
				 * */
				private void sendMessage(String message) {
					IStatusLineManager statusLineManager = getActionBars().getStatusLineManager();
					if (currentViewer == contentOutlineViewer && contentOutlineStatusLineManager != null) {
						statusLineManager = contentOutlineStatusLineManager;
					}
					
					if (statusLineManager != null) {
						statusLineManager.setMessage(PlatformUI.getWorkbench().getSharedImages().
								getImageDescriptor(ISharedImages.IMG_OBJS_ERROR_TSK).createImage(), message);
					}
					if (propertySheetPage != null) {
						propertySheetPage.getSite().getActionBars().getStatusLineManager().
							setMessage(PlatformUI.getWorkbench().getSharedImages().
								getImageDescriptor(ISharedImages.IMG_OBJS_ERROR_TSK).createImage(),message);
					}
					
				}
			
			 /*
			   * Javadoc copied from interface.
			   */
			  public void execute(Command command) 
			  {
			    // If the command is executable, record and execute it.
			    //
			    if (command != null && command.canExecute())
			    {
			      // Clear the list past the top.
			      //
			      for (ListIterator commands = commandList.listIterator(top + 1); commands.hasNext(); commands.remove())
			      {
			        Command otherCommand = (Command)commands.next();
			        otherCommand.dispose();
			      }
			      
			      /** Little class used to restore an object id
			       * */
			      class RestoreObjectId {
			      	public EObject obj;
			      	public String oldId;
			      	
			      	public RestoreObjectId(EObject o, String id) {
			      		obj = o;
			      		oldId = id;
			      	}
			      	public void restore() {
			      		VarTreeIdHandler.setId(obj, oldId);
			      	}
			      }
			      ArrayList restoreObjects = new ArrayList();
			      
			      
			      /*************************************************************
				   * PASTE FROM CLIPBOARD COMMAND
				   * 
				   * Check if one of new children is already on the tree. In
				   * this case, notifies it to user and drop command
				   ************************************************************/
			      if (command instanceof PasteFromClipboardCommand) {
			      	
			      	if (!(((PasteFromClipboardCommand) command).getOwner() instanceof EObject)) {
				      	sendMessage("Not valid past from Clipboard");
						
				        mostRecentCommand = null;
				        command.dispose();
				        return;
			      	}
			      	EObject dest = (EObject) ((PasteFromClipboardCommand) command).getOwner(); // destination
			      	Collection source = editingDomain.getClipboard(); // element to copy
			      	ArrayList references = new ArrayList(source.size());
			      	
		      		/* 
		      		 *   Try to get the EReference where store new objects
		      		 */
			      	AdapterFactory af = editingDomain.getAdapterFactory();
			      	Adapter a = af.adapt(dest, dest);
//			      	if (!(a instanceof ObjectWithIDItemProvider)) {
//				      	sendMessage("Not valid past from Clipboard");
//						
//				        mostRecentCommand = null;
//				        command.dispose();
//				        return;
//			      	}
//			      	
//			      	ObjectWithIDItemProvider owiip = (ObjectWithIDItemProvider) a;
			      	Adapter owiip = a;
			      	boolean next = false;
			      	Iterator iter = source.iterator();
			      	while(iter.hasNext()) {
			      		Object o = iter.next();
			      		if (!(o instanceof EObject)) {
					      	sendMessage("Not valid past from Clipboard");
							
					        mostRecentCommand = null;
					        command.dispose();
					        return;
			      		}
				      	
			      		EStructuralFeature ref = null; //owiip.getChildFeatureContainer(dest, o);
			      		if ( ref == null || !(ref instanceof EReference)) {
			      			next = true;
			      			break;
			      		}
			      		references.add(ref);
			      	}
			      	if (next) {
			      		references.clear();
			      		
			      		dest = (EObject) dest.eContainer();
			      		next = false || (dest ==null);

				      	if (!next) {
				      		owiip = /*(PublicObjectWithIDItemProvider)*/ af.adapt(dest, dest);
				      	}
				      	iter = source.iterator();
				      	while(iter.hasNext() && !next) {
				      		EObject o1 = (EObject) iter.next();
				      		EStructuralFeature ref = null; // owiip.getChildFeatureContainer(dest, o1);
				      		if ( ref == null || !(ref instanceof EReference)) {
				      			next = true;
				      		}
				      		references.add(ref);
				      	}			      		
			      	}
			      	
			      	if (next) {
			      		
				      	sendMessage("Not valid past from Clipboard");
						
				        mostRecentCommand = null;
				        command.dispose();
				        return;
			      	}
			      	
			      	if (references.size() != source.size()) {
			      		throw new RuntimeException("Wrong reference size !!");
			      	}
			      	
			      	HashMap usedID = new HashMap();
			      	iter = source.iterator();
			      	Iterator refIter = references.iterator();
			      	while(iter.hasNext()) {
			      		EObject o1 = (EObject) iter.next();
			      		EReference ref = (EReference) refIter.next();;
			      		
			      		if (ref.isMany()) {
				      		
			      			ArrayList ids; 
				      		if (usedID.containsKey(ref)) {
				      			ids = (ArrayList) usedID.get(ref);
				      		} else {
				      			ids = new ArrayList();
				      			usedID.put(ref, ids);
				      		}
			      			
			      			EList lista = (EList) dest.eGet(ref);
			      			if ( lista.contains(o1) || ids.contains(VarTreeIdHandler.getId(o1))) {
			      				
			      				final String origId = VarTreeIdHandler.getId(o1);
			      				String tmpId = origId;
			      				String[] splitId = DataPath.resolveId(tmpId);
			      				if (splitId.length == 1) {
				      				if (splitId[0] == null ) {
				      					if (DataPath.NULL_ID != "\\0") {
				      						throw new RuntimeException("Check the value of NULL_ID");
				      					}
				      					tmpId = "empty " + tmpId.substring(2);
				      				}
				      				String newId = "Copy of " + tmpId;
				      				int count =0;
				      				while (lista.contains(newId) || ids.contains(newId)) {
				      					count++;
				      					newId = "Copy (" + count + ") of " + tmpId;
				      					if (count == 1000) {
				      						// error
									        mostRecentCommand = null;
									        command.dispose();
									        return;
				      					}
				      				}
				      				
				      				VarTreeIdHandler.getId(o1);
				      				
				      				restoreObjects.add( new RestoreObjectId(o1, origId));
				      				
			      				} else {
	  			      				ArrayList tmp = new ArrayList();
									tmp.add(lista.get(lista.indexOf(o1)));
						      		setSelectionToViewer(tmp);
							      	sendMessage("Try to overwrite an existent node with the same ID ("+VarTreeIdHandler.getId(o1)+"). Remove it first.");
									
							        mostRecentCommand = null;
							        command.dispose();
							        return;

			      				}
			      			}

/*			      			if ( ids.contains(o1.getObjectID())) {
						      	sendMessage("Try to past more than one node with the same ID ("+o1.getObjectID()+")");
								
						        mostRecentCommand = null;
						        command.dispose();
						        return;
			      			}
*/
			      			ids.add(VarTreeIdHandler.getId(o1));
			      			
			      		} else {
			      			if (dest.eGet(ref) != null) {
			      				ArrayList tmp = new ArrayList();
								tmp.add(dest.eGet(ref));
					      		setSelectionToViewer(tmp);
						      	sendMessage("Try to overwrite an existent node with the same ID ("+VarTreeIdHandler.getId(o1)+"). Remove it first.");
								
						        mostRecentCommand = null;
						        command.dispose();
						        return;
			      			}
			      		}
			      	}			      		
			      }
			      
			      /*************************************************************
				   * CREATE CHILD COMMAND
				   * 
				   * Check if one of new children is already on the tree. In
				   * this case, notifies it to user and drop command
				   ************************************************************/
			      else if (command instanceof CreateChildCommand 
			      		&& (
			      		  ((CreateChildCommand) command).getCommand() instanceof AddCommand
						||((CreateChildCommand) command).getCommand() instanceof SetCommand)) {
		
			      	
			      	if (((CreateChildCommand) command).getCommand() instanceof AddCommand) {
				      	AddCommand tmp = (AddCommand) ((CreateChildCommand) command).getCommand();
				      	Collection newChilds = new ArrayList();
				      	newChilds.addAll(tmp.getCollection());
				      	EList ownerList = tmp.getOwnerList();
				      	
				      	Collection others = new ArrayList();
				      	
				      	Iterator iter = newChilds.iterator();
				      	while (iter.hasNext()) {
				      		EObject o = (EObject) iter.next();
		      				
		      				String[] splitId = DataPath.resolveId(VarTreeIdHandler.getId(o));
		      				
		      				boolean classType =
		      					   (o instanceof Activation)
								|| (o instanceof ExecTimeList)
								|| (o instanceof CacheMissCostList)
								|| (o instanceof Scheduling)
								|| (o instanceof ResourceRef)
								|| (o instanceof Sample)
								|| (o instanceof PartialOrder)
								|| (o instanceof TimeConst)
								|| (o instanceof SchedulingScenario)
								|| (o instanceof CpuSched)
								|| (o instanceof TaskSched)
								|| (o instanceof MutexRef);
		      				
		      				if (splitId.length == 1 && !classType) {
			      				splitId[0] = o.eClass().getName();
			      				String newId = DataPath.makeId(splitId);
			      				int count =0;
			      				while (ownerList.contains(newId)) {
			      					count++;
				      				splitId[0] = o.eClass().getName() + " " + count;
				      				newId = DataPath.makeId(splitId);
			      					if (count == 1000) {
			      						// error
								        mostRecentCommand = null;
								        command.dispose();
								        return;
			      					}
			      				}
			      				
			      				VarTreeIdHandler.setId(o, newId);
		      				} else {
		      					if (ownerList.contains(o)) {
		      						iter.remove();
                                    others.add(ownerList.get(ownerList.indexOf(o)));
		      					}
		      				}

				      	}
				      	
				      	if (others.size() != 0) {
                            
                            setSelectionToViewer(others);
                            sendMessage("Try to add a new object with an already used ID");
                            
                            mostRecentCommand = null;
                            command.dispose();
                            return;
				      	}
				      	
			      	} else if (((CreateChildCommand) command).getCommand() instanceof SetCommand) {
				    	// used on "single value" child
		      			
				      	SetCommand tmp = (SetCommand) ((CreateChildCommand) command).getCommand();
				      	EObject o = (EObject) tmp.getValue();
//				      	Object parent = tmp.getOwner();
				      	
	      				String[] splitId = DataPath.resolveId(VarTreeIdHandler.getId(o));
	      				splitId[0] = o.eClass().getName();
	      				String newId = DataPath.makeId(splitId);

	      				VarTreeIdHandler.setId(o, newId);
	      				
	      				// only for RTOS element
	      				if (o instanceof Rtos) {
	      					((Rtos) o).setName(new StringVar("Rtos"));
	      				}
				    }
				      	
				      	
			      }
			      
			      /*************************************************************
				   * DRAG AND DROP COMMAND
				   * 
				   * Check if one of new children is already on the tree. In
				   * this case, notifies it to user and drop command
				   ************************************************************/
			      else if (command instanceof DragAndDropCommand) {
			      	
			      	if (!(((DragAndDropCommand) command).getOwner() instanceof EObject)) {
				      	sendMessage("Not valid Drag and Drop");
						
				        mostRecentCommand = null;
				        command.dispose();
				        return;
			      	}
			      	EObject dest = (EObject) ((DragAndDropCommand) command).getOwner(); // destinazione
			      	Collection source = ((DragAndDropCommand) command).getCollection(); // destinazione
			      	
			      	boolean next = false;
			      	Iterator iter = source.iterator();
			      	while(iter.hasNext()) {
			      		Object o = iter.next();
			      		if (!(o instanceof EObject)) {
					      	sendMessage("Not valid Drag and Drop");
							
					        mostRecentCommand = null;
					        command.dispose();
					        return;
			      		}
			      		EObject o1 = (EObject) o;
			      		if (o1.eContainer().getClass() != dest.getClass()) {
			      			next = true;
			      			break;
			      		}
			      	}
			      	if (next) {
			      		
			      		dest = (EObject) dest.eContainer();
			      		next = false || (dest ==null);
			      		
				      	iter = source.iterator();
				      	while(iter.hasNext() && !next) {
				      		EObject o1 = (EObject) iter.next();
				      		if (o1.eContainer().getClass() != dest.getClass()) {
				      			next = true;
				      		}
				      	}			      		
			      	}
			      	
			      	if (next) {
			      		
				      	sendMessage("Not valid Drag and Drop");
						
				        mostRecentCommand = null;
				        command.dispose();
				        return;
			      	}
			      	
			      	HashMap usedID = new HashMap();
			      	iter = source.iterator();
			      	while(iter.hasNext()) {
			      		EObject o1 = (EObject) iter.next();
			      		
			      		EReference ref = o1.eContainmentFeature();
			      		if (ref.isMany()) {
			      			EList lista = (EList) dest.eGet(ref);
			      			if ( lista.contains(o1)) {
			      				ArrayList tmp = new ArrayList();
								tmp.add(lista.get(lista.indexOf(o1)));
					      		setSelectionToViewer(tmp);
						      	sendMessage("Try to overwrite an existent node with the same ID ("+VarTreeIdHandler.getId(o1)+"). Remove it first.");
								
						        mostRecentCommand = null;
						        command.dispose();
						        return;
			      			}
			      			ArrayList ids; 
				      		if (usedID.containsKey(ref)) {
				      			ids = (ArrayList) usedID.get(ref);
				      		} else {
				      			ids = new ArrayList();
				      			usedID.put(ref, ids);
				      		}
			      			if ( ids.contains(VarTreeIdHandler.getId(o1))) {
						      	sendMessage("Try to past more than one node with the same ID ("+VarTreeIdHandler.getId(o1)+")");
								
						        mostRecentCommand = null;
						        command.dispose();
						        return;
			      			}
			      			ids.add(VarTreeIdHandler.getId(o1));			      			
			      		} else {
			      			if (dest.eGet(ref) != null) {
			      				ArrayList tmp = new ArrayList();
								tmp.add(dest.eGet(ref));
					      		setSelectionToViewer(tmp);
						      	sendMessage("Try to overwrite an existent node with the same ID ("+VarTreeIdHandler.getId(o1)+"). Remove it first.");
								
						        mostRecentCommand = null;
						        command.dispose();
						        return;
			      			}
			      		}
			      	}			      		
			      	
			      }

			      try
			      {
			        command.execute();
			        mostRecentCommand = command;
			        commandList.add(command);
			        ++top;
			      }
			      catch (IllegalIDException e) {
			      	sendMessage(e.getMessage());
					
			        mostRecentCommand = null;
			        command.dispose();
			        return;
			      }
			      catch (RuntimeException exception)
			      {
			      	RtdruidLog.log
			          (new WrappedException
			            (CommonPlugin.INSTANCE.getString("_UI_IgnoreException_exception"), exception));

			        mostRecentCommand = null;
			        command.dispose();
			      } finally {
			      	for (int i=0; i<restoreObjects.size(); i++) {
			      		((RestoreObjectId) restoreObjects.get(i)).restore();
			      	}
			      }

			      // This is kind of tricky.
			      // If the saveIndex was in the redo part of the command list which has now been wiped out,
			      // then we can never reach a point where a save is not necessary, not even if we undo all the way back to the beginning.
			      //
			      if (saveIndex >= top)
			      {
			        // This forces isSaveNeded to always be true.
			        //
			        saveIndex = -2;
			      }

			      notifyListeners();
			    }
			    else
			    {
			      command.dispose();
			    }
			  }
		};

		// Add a listener to set the most recent command's affected objects to be the selection of the viewer with focus.
		//
		commandStack.addCommandStackListener
			(new CommandStackListener() {
				 public void commandStackChanged(final EventObject event) {
					 getContainer().getDisplay().asyncExec
						 (new Runnable() {
							  public void run() {
								  firePropertyChange(IEditorPart.PROP_DIRTY);

								  // Try to select the affected objects.
								  //
								  Command nextUndoCommand = ((CommandStack)event.getSource()).getUndoCommand();
								  Command mostRecentCommand = ((CommandStack)event.getSource()).getMostRecentCommand();
								  if (mostRecentCommand != null) {
								  	
									  boolean ok = true;
									  if (mostRecentCommand instanceof RemoveCommand) {
									  	ok &= mostRecentCommand != nextUndoCommand;

									  } else if (mostRecentCommand instanceof SetCommand
									  		&& isCurrentActivePart()) {
									  	ok &= mostRecentCommand != nextUndoCommand;
									  	
									  } else if (mostRecentCommand instanceof CommandWrapper
									  		&& (((CommandWrapper) mostRecentCommand).getCommand() instanceof SetCommand)
									  		&& isCurrentActivePart()) {
									  	ok &= mostRecentCommand != nextUndoCommand;
									  }
									  if (ok) {
									  	setSelectionToViewer(mostRecentCommand.getAffectedObjects());
									  }
								  }
								  if (propertySheetPage != null) {
									  propertySheetPage.refresh();
								  }
							  }
						  });
				 }
			 });

		// Create the editing domain with a special command stack.
		//
//		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack);
		
		editingDomain = VarTreeUtil.newVarTree(commandStack);
		
		adapterFactory = (ComposedAdapterFactory) editingDomain.getAdapterFactory();
	}

	/**
	 * This is here for the listener to be able to call it.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void firePropertyChange(int action) {
		super.firePropertyChange(action);
	}

	
	private boolean isCurrentActivePart() {
		IWorkbenchPart iwp = getEditorSite().getPage().getActivePart();
		
		return iwp == this || iwp instanceof ContentOutline;
	}
	/**
	 * This sets the selection into whichever viewer is active.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelectionToViewer(Collection collection) {
		final Collection theSelection = collection;
		// Make sure it's okay.
		//
//		boolean ok = getEditorSite().getPage().getActivePart() == this;
//		if (theSelection != null && !theSelection.isEmpty() && !ok) {
		if (theSelection != null && !theSelection.isEmpty()) {
			// I don't know if this should be run this deferred
			// because we might have to give the editor a chance to process the viewer update events
			// and hence to update the views first.
			//
			//
			Runnable runnable =
				new Runnable() {
					public void run() {
						
						// Try to select the items in the current content viewer of the editor.
						//
						if (currentViewer != null) {
//							currentViewer.setSelection(new StructuredSelection(theSelection.toArray()), true);
						}
					}
				};
			runnable.run();
		}
	}

	/**
	 * This returns the editing domain as required by the {@link IEditingDomainProvider} interface.
	 * This is important for implementing the static methods of {@link AdapterFactoryEditingDomain}
	 * and for supporting {@link org.eclipse.emf.edit.ui.action.CommandAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public class ReverseAdapterFactoryContentProvider extends AdapterFactoryContentProvider {
		public ReverseAdapterFactoryContentProvider(AdapterFactory adapterFactory) {
			super(adapterFactory);
		}

		public Object [] getElements(Object object) {
			Object parent = super.getParent(object);
			return (parent == null ? Collections.EMPTY_SET : Collections.singleton(parent)).toArray();
		}

		public Object [] getChildren(Object object) {
			Object parent = super.getParent(object);
			return (parent == null ? Collections.EMPTY_SET : Collections.singleton(parent)).toArray();
		}

		public boolean hasChildren(Object object) {
			Object parent = super.getParent(object);
			return parent != null;
		}

		public Object getParent(Object object) {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentViewerPane(ViewerPane viewerPane) {
		if (currentViewerPane != viewerPane) {
			if (currentViewerPane != null) {
				currentViewerPane.showFocus(false);
			}
			currentViewerPane = viewerPane;
		}
		setCurrentViewer(currentViewerPane.getViewer());
	}

	/**
	 * This makes sure that one content viewer, either for the current page or the outline view, if it has focus,
	 * is the current one.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentViewer(Viewer viewer) {
		// If it is changing...
		//
		if (currentViewer != viewer) {
			if (selectionChangedListener == null) {
				// Create the listener on demand.
				//
				selectionChangedListener =
					new ISelectionChangedListener() {
						// This just notifies those things that are affected by the section.
						//
						public void selectionChanged(SelectionChangedEvent selectionChangedEvent) {
							setSelection(selectionChangedEvent.getSelection());
						}
					};
			}

			// Stop listening to the old one.
			//
			if (currentViewer != null) {
				currentViewer.removeSelectionChangedListener(selectionChangedListener);
			}

			// Start listening to the new one.
			//
			if (viewer != null) {
				viewer.addSelectionChangedListener(selectionChangedListener);
			}

			// Remember it.
			//
			currentViewer = viewer;

			// Set the editors selection based on the current viewer's selection.
			//
			setSelection(currentViewer == null ? StructuredSelection.EMPTY : currentViewer.getSelection());
		}
	}

	/**
	 * This returns the viewer as required by the {@link IViewerProvider} interface.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Viewer getViewer() {
		return currentViewer;
	}

	/**
	 * This creates a context menu for the viewer and adds a listener as well registering the menu for extension.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createContextMenuFor(StructuredViewer viewer) {
		MenuManager contextMenu = new MenuManager("#PopUp");
		contextMenu.add(new Separator("additions"));
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);
		Menu menu= contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu, viewer);

		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
		viewer.addDropSupport(dndOperations, transfers, new EditingDomainViewerDropAdapter(editingDomain, viewer));
	}

	/**
	 * This is the method called to load a resource into the editing domain's resource set based on the editor's input.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createModel() {
		// I assume that the input is a file object.
		//
		IEditorInput input = getEditorInput();
		//IFileEditorInput modelFile = (IFileEditorInput)getEditorInput();

		try {
			//String path = null;
			URI path = null;
//			boolean systemPath = true;//false;
			if (input instanceof IStorageEditorInput) {
				IPath sPath = ((IStorageEditorInput) input).getStorage().getFullPath();
				if (sPath != null) {
					path = URI.createPlatformResourceURI(sPath.toString(), false);
//					systemPath = sPath.getDevice() != null;
				}
			} else 
				if (input instanceof IPathEditorInput) {
					path = URI.createFileURI(((IPathEditorInput) input).getPath().toString());
//					systemPath = ((IPathEditorInput) input).getPath().toOSString().equals(path);
				} //

			
			// Load the resource through the editing domain.
			//
			//Resource resource =
			//if (systemPath) 
			{
				
			    IVTResource res = (IVTResource) new RTD_XMI_Factory().createResource(path); //URI.createFileURI(path));
				try {
					res.setLoadHandler(new ErrorHandler() {
						public void error(SAXParseException e) throws SAXException {
							Messages.sendErrorNl("syntax error at line " + e.getLineNumber() 
									+ " : " + e.getMessage()+ " \n",null,"", new Properties());
						}

						public void fatalError(SAXParseException e) throws SAXException {
							Messages.sendErrorNl("fatal error at line " + e.getLineNumber()
									+ " : " + e.getMessage() + " \n",null,"", new Properties());
						}

						public void warning(SAXParseException e) throws SAXException {
							Messages.sendWarningNl("syntax warning at line " + e.getLineNumber() 
									+ " : " + e.getMessage()+" \n",null,"", new Properties());
						}

					});
					res.load(new HashMap());
				} catch (IOException e) {
					
					throw new RuntimeException(e.getMessage(),e);
				}

				EList<Resource> resources = editingDomain.getResourceSet().getResources();
				if (resources.size()==0) {
					resources.add(res);
				} else {
					resources.set(0, res);
				}
					
//			} else {
//				editingDomain.loadResource(path.toFileString());
//					(URI.createPlatformResourceURI(path, true).toString());
			}
		}
		catch (Exception exception) {
			RtdruidLog.log(exception);
		}
	}

	/**
	 * This is the method used by the framework to install your own controls.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void createPages() {
		// Creates the model from the editor input
		//
		createModel();

		pagePropertySourceProvider = new IPropertySourceProvider[3];
		
		// Create a page for the selection tree view.
		//
		{
			 class MyEditor extends EditorPart {
			 	
			 	protected Tree tree;
			 	protected TreeViewer treeViewer;
			 	protected String title = "";
			 	
			 	// implementation of abstract methods
			 	
				public void doSave(IProgressMonitor monitor) {
					DataEditor.this.doSave(monitor);
				}

				public void doSaveAs() {
					DataEditor.this.doSaveAs();
				}

				public void init(IEditorSite site, IEditorInput input)
						throws PartInitException {
					this.setSite(site);
					setInput(input);
					
				}

				public boolean isDirty() {
					return DataEditor.this.isDirty();
				}

				public boolean isSaveAsAllowed() {
					return DataEditor.this.isSaveAsAllowed();
				}

				public void createPartControl(Composite parent) {
					tree = new Tree(parent, SWT.MULTI);
					treeViewer = new TreeViewer(tree);
					treeViewer.addDoubleClickListener( new IDoubleClickListener() {
						public void doubleClick(DoubleClickEvent dce) {
							try {
								getSite().getPage().showView("org.eclipse.ui.views.PropertySheet");
							}
							catch (PartInitException exception) {
								RtdruidLog.log(exception);
							}
						}
					});
					treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
						public void selectionChanged(SelectionChangedEvent event) {
							if (event.getSource() == treeViewer) {
							    try {
							        DataEditor.this.multiPageSelectionProvider.fireSelectionChanged(event);
							    } catch (RuntimeException e) {
							        RtdruidLog.log(e);
							    }
							}
						}
					});
					getSite().setSelectionProvider(treeViewer);


				}

				public void setFocus() {
					// nothing
				}
				
				/* (non-Javadoc)
				 * @see org.eclipse.ui.IWorkbenchPart#getTitle()
				 */
				public String getTitle() {
					return title;
				}

				// --------------------------
				
				public TreeViewer getViewer() {
					return treeViewer;
				}
				
				public void setTitle(String newTitle) {
					title = newTitle;
				}
				
				/* (non-Javadoc)
				 * @see org.eclipse.ui.IWorkbenchPart#dispose()
				 */
				public void dispose() {
					super.dispose();
					
					if (tree != null && !tree.isDisposed()) {
						tree.dispose();
					}

				}
			};
			MyEditor viewerPane = new MyEditor();
			
			try {
				int pageIndex = addPage(viewerPane, getEditorInput());
				setPageText(pageIndex, getString("_UI_SelectionPage_label"));
				
				pagePropertySourceProvider[pageIndex] = new AdapterFactoryContentProvider(adapterFactory);
			} catch (Exception e) {
			}

			//viewerPane.createPartControl(getContainer());

			selectionViewer = viewerPane.getViewer();
			selectionViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));

			selectionViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
			selectionViewer.setInput(editingDomain.getResourceSet());
			//viewerPane.setTitle(editingDomain.getResourceSet());

			new AdapterFactoryTreeEditor(selectionViewer.getTree(), adapterFactory);

			createContextMenuFor(selectionViewer);
			
			multiPageSelectionProvider.addSelectionChangedListener(new ISelectionChangedListener() {
				public void selectionChanged(SelectionChangedEvent event) {
					if (event.getSource() != selectionViewer) {
						selectionViewer.setSelection(toEObjectSelection(event.getSelection()));
					}

				}
			});
			

			
			/*
			ViewerPane viewerPane =
				new ViewerPane(getSite().getPage(), DataEditor.this) {
					public Viewer createViewer(Composite composite) {
						Tree tree = new Tree(composite, SWT.MULTI);
						TreeViewer newTreeViewer = new TreeViewer(tree);
						newTreeViewer.addDoubleClickListener( new IDoubleClickListener() {
							public void doubleClick(DoubleClickEvent dce) {
								try {
									getSite().getPage().showView("org.eclipse.ui.views.PropertySheet");
								}
								catch (PartInitException exception) {
									RtdruidLog.log(exception);
								}
							}
						});
						return newTreeViewer;
					}
					public void requestActivation() {
						super.requestActivation();
						setCurrentViewerPane(this);
					}
					
					
				};
			viewerPane.createPartControl(getContainer());

			selectionViewer = (TreeViewer)viewerPane.getViewer();
			selectionViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));

			selectionViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
			selectionViewer.setInput(editingDomain.getResourceSet());
			viewerPane.setTitle(editingDomain.getResourceSet());

			new AdapterFactoryTreeEditor(selectionViewer.getTree(), adapterFactory);

			createContextMenuFor(selectionViewer);
			int pageIndex = addPage(viewerPane.getControl());
			setPageText(pageIndex, getString("_UI_SelectionPage_label"));
			
			pagePropertySourceProvider[pageIndex] = new AdapterFactoryContentProvider(adapterFactory);
			*/
		}

		// create a page for the Functional Flow View
		{
		/*	
			final GraphicalViewer viewer = new ScrollingGraphicalViewer();
			Control page = viewer.createControl(getContainer());
			page.setBackground(ColorConstants.white);
			viewer.setRootEditPart(new ScalableRootEditPart());
			viewer.setEditPartFactory(new ActivityPartFactory());
			
			viewer.setContents((new ModelLoader()).load((VarTree) editingDomain));

			getSite().setSelectionProvider(viewer);
			page.addMouseListener(new MouseListener() {
				
				protected ArrayList previous = new ArrayList();
				
				public void mouseDoubleClick(MouseEvent e) {
					// TODO Auto-generated method stub
					System.err.println("Doppio click ("+e.button+", "+e.stateMask+") su " + e.x + "-"+e.y);
					
					EditPart ep = viewer.findObjectAt(new org.eclipse.draw2d.geometry.Point(e.x, e.y));
					viewer.deselectAll();
					if (ep!= null) {
						viewer.select(ep);
					}
					
				}

				public void mouseDown(MouseEvent e) {
					System.err.println("Pressione ("+e.button+", "+e.stateMask+") su " + e.x + "-"+e.y);

					
					EditPart ep = viewer.findObjectAt(new org.eclipse.draw2d.geometry.Point(e.x, e.y));
					viewer.deselectAll();
					if (ep!= null) {
						viewer.select(ep);
					}

				}

				public void mouseUp(MouseEvent e) {
					System.err.println("Rilascio ("+e.button+", "+e.stateMask+") su " + e.x + "-"+e.y );
					
					
				}
			});
			
			int index = addPage(page);
			setPageText(index, "Properties");

			setPageText(index, getString("_UI_FunctionalFlowPage_label"));*/
			
		}

//		{
//				
//			final DataFlowViewer viewer = new DataFlowViewer((IVarTree) editingDomain);
//			
//
//			
//			try {
//				int index = addPage(viewer, getEditorInput());
//				
//				setPageText(index, "Properties");
//				setPageText(index, getString("_UI_DataFlowPage_label"));
//				
//				pagePropertySourceProvider[index] = null;
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//			
//			multiPageSelectionProvider.addSelectionChangedListener(new ISelectionChangedListener() {
//				public void selectionChanged(SelectionChangedEvent event) {
//					if (event.getSource() != viewer) {
//						viewer.setSelection(event);
//					}
//
//				}
//			});
//
//		}
			
		{
			
//		final FunctionalFlowViewer viewer = new FunctionalFlowViewer((IVarTree) editingDomain);
//		
//
//		
//		try {
//			int index = addPage(viewer, getEditorInput());
//			
//			setPageText(index, "Properties");
//			setPageText(index, getString("_UI_FunctionalFlowPage_label"));
//			
//			pagePropertySourceProvider[index] = null;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
//		multiPageSelectionProvider.addSelectionChangedListener(new ISelectionChangedListener() {
//			public void selectionChanged(SelectionChangedEvent event) {
//				if (event.getSource() != viewer) {
//					viewer.setSelection(event);
//				}
//
//			}
//		});

	}
	
		
		
		// Create a page for the parent tree view.
		//
/*		{
			ViewerPane viewerPane =
				new ViewerPane(getSite().getPage(), DataEditor.this) {
					public Viewer createViewer(Composite composite) {
						Tree tree = new Tree(composite, SWT.MULTI);
						TreeViewer newTreeViewer = new TreeViewer(tree);
						return newTreeViewer;
					}
					public void requestActivation() {
						super.requestActivation();
						setCurrentViewerPane(this);
					}
				};
			viewerPane.createControl(getContainer());

			parentViewer = (TreeViewer)viewerPane.getViewer();
			parentViewer.setAutoExpandLevel(30);
			parentViewer.setContentProvider(new ReverseAdapterFactoryContentProvider(adapterFactory));
			parentViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

			createContextMenuFor(parentViewer);
			int pageIndex = addPage(viewerPane.getControl());
			setPageText(pageIndex, getString("_UI_ParentPage_label"));
		}

		// This is the page for the list viewer
		//
		{
			ViewerPane viewerPane =
				new ViewerPane(getSite().getPage(), DataEditor.this) {
					public Viewer createViewer(Composite composite) {
						return new ListViewer(composite);
					}
					public void requestActivation() {
						super.requestActivation();
						setCurrentViewerPane(this);
					}
				};
			viewerPane.createControl(getContainer());
			listViewer = (ListViewer)viewerPane.getViewer();
			listViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
			listViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

			createContextMenuFor(listViewer);
			int pageIndex = addPage(viewerPane.getControl());
			setPageText(pageIndex, getString("_UI_ListPage_label"));
		}

		// This is the page for the tree viewer
		//
		{
			ViewerPane viewerPane =
				new ViewerPane(getSite().getPage(), DataEditor.this) {
					public Viewer createViewer(Composite composite) {
						return new TreeViewer(composite);
					}
					public void requestActivation() {
						super.requestActivation();
						setCurrentViewerPane(this);
					}
				};
			viewerPane.createControl(getContainer());
			treeViewer = (TreeViewer)viewerPane.getViewer();
			treeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
			treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

			new AdapterFactoryTreeEditor(treeViewer.getTree(), adapterFactory);

			createContextMenuFor(treeViewer);
			int pageIndex = addPage(viewerPane.getControl());
			setPageText(pageIndex, getString("_UI_TreePage_label"));
		}

		// This is the page for the table viewer.
		//
		{
			ViewerPane viewerPane =
				new ViewerPane(getSite().getPage(), DataEditor.this) {
					public Viewer createViewer(Composite composite) {
						return new TableViewer(composite);
					}
					public void requestActivation() {
						super.requestActivation();
						setCurrentViewerPane(this);
					}
				};
			viewerPane.createControl(getContainer());
			tableViewer = (TableViewer)viewerPane.getViewer();

			Table table = tableViewer.getTable();
			TableLayout layout = new TableLayout();
			table.setLayout(layout);
			table.setHeaderVisible(true);
			table.setLinesVisible(true);

			TableColumn objectColumn = new TableColumn(table, SWT.NONE);
			layout.addColumnData(new ColumnWeightData(3, 100, true));
			objectColumn.setText(getString("_UI_ObjectColumn_label"));
			objectColumn.setResizable(true);

			TableColumn selfColumn = new TableColumn(table, SWT.NONE);
			layout.addColumnData(new ColumnWeightData(2, 100, true));
			selfColumn.setText(getString("_UI_SelfColumn_label"));
			selfColumn.setResizable(true);

			tableViewer.setColumnProperties(new String [] {"a", "b"});
			tableViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
			tableViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

			createContextMenuFor(tableViewer);
			int pageIndex = addPage(viewerPane.getControl());
			setPageText(pageIndex, getString("_UI_TablePage_label"));
		}

		// This is the page for the table tree viewer.
		//
		{
			ViewerPane viewerPane =
				new ViewerPane(getSite().getPage(), DataEditor.this) {
					public Viewer createViewer(Composite composite) {
						return new TableTreeViewer(composite);
					}
					public void requestActivation() {
						super.requestActivation();
						setCurrentViewerPane(this);
					}
				};
			viewerPane.createControl(getContainer());

			tableTreeViewer = (TableTreeViewer)viewerPane.getViewer();

			TableTree tableTree = tableTreeViewer.getTableTree();
			TableLayout layout = new TableLayout();
			tableTree.getTable().setLayout(layout);
			tableTree.getTable().setHeaderVisible(true);
			tableTree.getTable().setLinesVisible(true);

			TableColumn objectColumn = new TableColumn(tableTree.getTable(), SWT.NONE);
			layout.addColumnData(new ColumnWeightData(3, 100, true));
			objectColumn.setText(getString("_UI_ObjectColumn_label"));
			objectColumn.setResizable(true);

			TableColumn selfColumn = new TableColumn(tableTree.getTable(), SWT.NONE);
			layout.addColumnData(new ColumnWeightData(2, 100, true));
			selfColumn.setText(getString("_UI_SelfColumn_label"));
			selfColumn.setResizable(true);

			tableTreeViewer.setColumnProperties(new String [] {"a", "b"});
			tableTreeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
			tableTreeViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

			createContextMenuFor(tableTreeViewer);
			int pageIndex = addPage(viewerPane.getControl());
			setPageText(pageIndex, getString("_UI_TableTreePage_label"));
		}
*/
		setActivePage(0);

		getContainer().addControlListener
			(new ControlAdapter() {
				boolean guard = false;
				public void controlResized(ControlEvent event) {
					if (!guard) {
						guard = true;
						hideTabs();
						guard = false;
					}
				}
			 });
	}

	/**
	 * If there is just one page in the multi-page editor part, this hides
	 * the single tab at the bottom.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void hideTabs() {
		if (getPageCount() <= 1) {
			setPageText(0, "");
			if (getContainer() instanceof CTabFolder) {
				((CTabFolder)getContainer()).setTabHeight(1);
				Point point = getContainer().getSize();
				getContainer().setSize(point.x, point.y + 6);
			}
		}
	}

	/**
	 * This is used to track the active viewer.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void pageChange(int pageIndex) {
		super.pageChange(pageIndex);

		// This is a temporary workaround... EATM
		//
		Control control = getControl(pageIndex);
		if (control != null) {
			control.setVisible(true);
			control.setFocus();
		}

		if (contentOutlinePage != null) {
			handleContentOutlineSelection(contentOutlinePage.getSelection());
		}
		
		if (propertySheetPage != null) {
			propertySheetPage.setPropertySourceProvider(getPagePropertySourceProvider());
		}
	}
	
	protected IPropertySourceProvider getPagePropertySourceProvider() {
		if (pagePropertySourceProvider == null) {
			return null;
		}
		int index = getActivePage();
		return index == -1 ? null : pagePropertySourceProvider[index];
	}

	/**
	 * This is how the framework determines which interfaces we implement.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAdapter(Class key) {
		if (key.equals(IContentOutlinePage.class)) {
			return getContentOutlinePage();
		}
		else if (key.equals(IPropertySheetPage.class)) {
			return getPropertySheetPage();
		}
		else if (key.equals(IGotoMarker.class)) {
			return this;
		}
		else {
			return super.getAdapter(key);
		}
	}

	/**
	 * This accesses a cached version of the content outliner.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IContentOutlinePage getContentOutlinePage() {
		if (contentOutlinePage == null) {
			// The content outline is just a tree.
			//
			class MyContentOutlinePage extends ContentOutlinePage {
				
				ISelectionChangedListener listner;
				
				public void createControl(Composite parent) {
					super.createControl(parent);
					contentOutlineViewer = getTreeViewer();
					contentOutlineViewer.addSelectionChangedListener(new ISelectionChangedListener() {
						public void selectionChanged(SelectionChangedEvent event) {
							if (event.getSource() == contentOutlineViewer) {
							    try {
							        DataEditor.this.multiPageSelectionProvider.fireSelectionChanged(event);
							    } catch (RuntimeException e) {
							        RtdruidLog.log(e);
							    }
							}
						}
					});
					
					contentOutlineViewer.addDoubleClickListener( new IDoubleClickListener() {
						public void doubleClick(DoubleClickEvent dce) {
							try {
								getSite().getPage().showView("org.eclipse.ui.views.PropertySheet");
							}
							catch (PartInitException exception) {
								RtdruidLog.log(exception);
							}
						}
					});


					// Set up the tree viewer.
					//
					contentOutlineViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
					contentOutlineViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
					contentOutlineViewer.setInput(editingDomain.getResourceSet());

					// Make sure our popups work.
					//
					createContextMenuFor(contentOutlineViewer);

					if (!editingDomain.getResourceSet().getResources().isEmpty()) {
					  // Select the root object in the view.
					  //
					  ArrayList selection = new ArrayList();
					  selection.add(editingDomain.getResourceSet().getResources().get(0));
					  contentOutlineViewer.setSelection(new StructuredSelection(selection), true);
					}
					
					if (multiPageSelectionProvider != null) {
						listner = new ISelectionChangedListener() {
							public void selectionChanged(
									SelectionChangedEvent event) {
								try {
									//System.err.println("evento : "+event);
									if (event.getSource() == contentOutlineViewer) {
										return;
									}
									
									IStructuredSelection strucSel = toEObjectSelection(event.getSelection());
									
									if (MyContentOutlinePage.this.getSelection().isEmpty() && strucSel.isEmpty()) {
										return;
									}
									
									
// TODO: removed to solve a problem with papyrous
//									MyContentOutlinePage.this.setSelection(strucSel);
								} catch (RuntimeException e) {
								    RtdruidLog.log(e);
								}

							}
						};
						multiPageSelectionProvider.addSelectionChangedListener(listner);
					}
				}

				public void makeContributions(IMenuManager menuManager, IToolBarManager toolBarManager, IStatusLineManager statusLineManager) {
					super.makeContributions(menuManager, toolBarManager, statusLineManager);
					contentOutlineStatusLineManager = statusLineManager;
				}

				public void setActionBars(IActionBars actionBars) {
					super.setActionBars(actionBars);
					try {
						getActionBarContributor().shareGlobalActions(this, actionBars);
					} catch (Exception e) {
						RtdruidLog.showDebug(e);
					}
				}
				
				/* (non-Javadoc)
				 * @see org.eclipse.ui.part.IPage#dispose()
				 */
				public void dispose() {
					super.dispose();

					if (listner != null && multiPageSelectionProvider != null) {
						multiPageSelectionProvider.removeSelectionChangedListener(listner);
					}
				}
			}

			contentOutlinePage = new MyContentOutlinePage();

			// Listen to selection so that we can handle it is a special way.
			//
			//contentOutlinePage.addSelectionChangedListener(contentOutlineListener);
		}

		return contentOutlinePage;
	}

	/**
	 * This accesses a cached version of the property sheet.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPropertySheetPage getPropertySheetPage() {
		if (propertySheetPage == null) {
			propertySheetPage =
				new PropertySheetPage() {
					public void makeContributions(IMenuManager menuManager, IToolBarManager toolBarManager, IStatusLineManager statusLineManager) {
						super.makeContributions(menuManager, toolBarManager, statusLineManager);
					}

					public void setActionBars(IActionBars actionBars) {
						super.setActionBars(actionBars);
						if (getActionBarContributor() != null)
							getActionBarContributor().shareGlobalActions(this, actionBars);
					}
				};
			propertySheetPage.setPropertySourceProvider(getPagePropertySourceProvider());
		}

		return propertySheetPage;
	}

	/**
	 * This deals with how we want selection in the outliner to affect the other views.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void handleContentOutlineSelection(ISelection selection) {
		if (currentViewerPane != null && !selection.isEmpty() && selection instanceof IStructuredSelection) {
			Iterator selectedElements = ((IStructuredSelection)selection).iterator();
			if (selectedElements.hasNext()) {
				// Get the first selected element.
				//
				Object selectedElement = selectedElements.next();

				// If it's the selection viewer, then we want it to select the same selection as this selection.
				//
				if (currentViewerPane.getViewer() == selectionViewer) {
					ArrayList selectionList = new ArrayList();
					selectionList.add(selectedElement);
					while (selectedElements.hasNext()) {
						selectionList.add(selectedElements.next());
					}

					// Set the selection to the widget.
					//
					selectionViewer.setSelection(new StructuredSelection(selectionList));
				}
				else {
					// Set the input to the widget.
					//
					if (currentViewerPane.getViewer().getInput() != selectedElement) {
						currentViewerPane.getViewer().setInput(selectedElement);
						currentViewerPane.setTitle(selectedElement);
					}
				}
			}
		}
	}

	/**
	 * This is for implementing {@link IEditorPart} and simply tests the command stack.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDirty() {
	    try {
	        return ((BasicCommandStack)editingDomain.getCommandStack()).isSaveNeeded();
	    } catch (RuntimeException e) {
	        RtdruidLog.log(e);
	        return false;
	    }
	}

	/**
	 * This is for implementing {@link IEditorPart} and simply saves the model file.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void doSave(IProgressMonitor progressMonitor) {
		// Do the work within an operation because this is a long running activity that modifies the workbench.
		//
		WorkspaceModifyOperation operation =
			new WorkspaceModifyOperation() {
				// This is the method that gets invoked when the operation runs.
				//
				public void execute(IProgressMonitor monitor) {
					try {
						// Save the resource to the file system.
						//
						Resource savedResource = (Resource)editingDomain.getResourceSet().getResources().get(0);
						savedResources.add(savedResource);
						savedResource.save(Collections.EMPTY_MAP);
					}
					catch (Exception exception) {
						RtdruidLog.log(exception);
					}
				}
			};

		try {
			// This runs the options, and shows progress.
			//
			new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);

			// Refresh the necessary state.
			//
			((BasicCommandStack)editingDomain.getCommandStack()).saveIsDone();
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}
		catch (Exception exception) {
			// Something went wrong that shouldn't.
			//
			RtdruidLog.log(exception);
		}
	}

	/**
	 * This always returns true because it is not currently supported.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSaveAsAllowed() {
		return true;
	}

	/**
	 * This also changes the editor's input.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void doSaveAs() {
		SaveAsDialog saveAsDialog= new SaveAsDialog(getSite().getShell());
		saveAsDialog.open();
		IPath path= saveAsDialog.getResult();
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				doSaveAs(URI.createPlatformResourceURI(file.getFullPath().toString()), new FileEditorInput(file));
			}
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void doSaveAs(URI uri, IEditorInput editorInput) {
		((Resource)editingDomain.getResourceSet().getResources().get(0)).setURI(uri);
		setInput(editorInput);
		setPartName(editorInput.getName());
		IProgressMonitor progressMonitor =
			getActionBars().getStatusLineManager() != null ?
				getActionBars().getStatusLineManager().getProgressMonitor() :
				new NullProgressMonitor();
		doSave(progressMonitor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void gotoMarker(IMarker marker) {
		try {
			if (marker.getType().equals(EValidator.MARKER)) {
				String uriAttribute = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
				if (uriAttribute != null) {
					URI uri = URI.createURI(uriAttribute);
					EObject eObject = editingDomain.getResourceSet().getEObject(uri, true);
					if (eObject != null) {
					  setSelectionToViewer(Collections.singleton(editingDomain.getWrapper(eObject)));
					}
				}
			}
		}
		catch (CoreException exception) {
			RtdruidLog.log(exception);
		}
	}

	/**
	 * This is called during startup.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void init(IEditorSite site, IEditorInput editorInput) throws PartInitException {
		super.init(site, editorInput);
		
		site.setSelectionProvider(new MultiPageSelectionProvider(this) {
			
			
			protected boolean enable = true;
			
			synchronized protected boolean lock() {
				if (enable) {
					enable = false;
					return true;
				}
				return false;
			}
			
			synchronized protected void unlock() {
				enable = true;
			}
			
			/* (non-Javadoc)
			 * @see org.eclipse.ui.part.MultiPageSelectionProvider#fireSelectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void fireSelectionChanged(SelectionChangedEvent event) {
				if (lock()) {
				    try {
				        super.fireSelectionChanged(event);
				    } catch (Throwable e) {
				        RtdruidLog.log(e);
				    }
					
					unlock();
				}
			}
		});

		multiPageSelectionProvider = (MultiPageSelectionProvider) site.getSelectionProvider();
		
		//setSite(site);
		//setInput(editorInput);
		setPartName(editorInput.getName());
		
		//multiPageSelectionProvider = new MultiPageSelectionProvider(this);
		//site.setSelectionProvider(multiPageSelectionProvider);
		//site.setSelectionProvider(this);
		
		site.getPage().addPartListener(partListener);
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener, IResourceChangeEvent.POST_CHANGE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFocus() {
		getControl(getActivePage()).setFocus();
	}


	/**
	 * Returns the current selection
	 */
	public ISelection getSelection() {
		return multiPageSelectionProvider.getSelection();
	}

	/**
	 * Make local change when is set a new selection
	 */
	public void setSelection(ISelection selection) {

		/*multiPageSelectionProvider.setSelection(selection);
		
		if (propertySheetPage != null) {
			propertySheetPage.selectionChanged(this, selection);
		}
		if (contentOutlinePage != null) {
			handleContentOutlineSelection(selection);
			// before set selection inside the contentOutlinePage, disable
			// Listner. Otherwise there is an endless loop
//			contentOutlinePage.removeSelectionChangedListener(contentOutlineListener);
//			contentOutlinePage.setSelection(selection);
//			contentOutlinePage.addSelectionChangedListener(contentOutlineListener);
		}
/*
		for (Iterator listeners = selectionChangedListeners.iterator(); listeners.hasNext(); ) {
			ISelectionChangedListener listener = (ISelectionChangedListener)listeners.next();
			listener.selectionChanged(new SelectionChangedEvent(this, selection));
		}*/
		setStatusLineManager(selection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatusLineManager(ISelection selection) {
		IStatusLineManager statusLineManager = getActionBars().getStatusLineManager();
		if (statusLineManager != null) {
			if (currentViewer == contentOutlineViewer) {
				statusLineManager = contentOutlineStatusLineManager;
			}
	
			if (selection instanceof IStructuredSelection) {
				Collection collection = ((IStructuredSelection)selection).toList();
				switch (collection.size()) {
					case 0: {
						statusLineManager.setMessage(getString("_UI_NoObjectSelected"));
						break;
					}
					case 1: {
						String text = new AdapterFactoryItemDelegator(adapterFactory).getText(collection.iterator().next());
						statusLineManager.setMessage(getString("_UI_SingleObjectSelected", text));
						break;
					}
					default: {
						statusLineManager.setMessage(getString("_UI_MultiObjectSelected", Integer.toString(collection.size())));
						break;
					}
				}
			}
			else {
				statusLineManager.setMessage("");
			}
		}
	}

	/**
	 * This looks up a string in the plugin's plugin.properties file.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static String getString(String key) {
		return Rtd_core_uiPlugin.getDefault().getResourceString(key);
	}

	/**
	 * This looks up a string in plugin.properties, making a substitution.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static String getString(String key, Object s1) {
		return Rtd_core_uiPlugin.getDefault().getString(key, new Object [] { s1 });
	}

	/**
	 * This implements {@link org.eclipse.jface.action.IMenuListener} to help fill the context menus with contributions from the Edit menu.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void menuAboutToShow(IMenuManager menuManager) {
		((IMenuListener)getEditorSite().getActionBarContributor()).menuAboutToShow(menuManager);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditingDomainActionBarContributor getActionBarContributor() {
		return (EditingDomainActionBarContributor)getEditorSite().getActionBarContributor();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IActionBars getActionBars() {
		return getActionBarContributor().getActionBars();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdapterFactory getAdapterFactory() {
		return adapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);

		getSite().getPage().removePartListener(partListener);

		adapterFactory.dispose();

		if (getActionBarContributor().getActiveEditor() == this) {
			getActionBarContributor().setActiveEditor(null);
		}

		if (propertySheetPage != null) {
			propertySheetPage.dispose();
		}

		if (contentOutlinePage != null) {
			contentOutlinePage.dispose();
		}

		super.dispose();
	}

	
	/**
	 * Check that an selection is a Structured Selection with only EObjects 
	 * */
	protected static IStructuredSelection toEObjectSelection(ISelection sel) {
		
		ArrayList newSel = new ArrayList();
		if (sel != null && sel instanceof IStructuredSelection) {
			for (Iterator iter = ((IStructuredSelection) sel).iterator(); iter.hasNext(); ){
				Object o = iter.next();
				
				// GEF
//				if (o instanceof EditPart && ((EditPart) o).getModel() instanceof IGComponent) {
//					EObject eo = ((IGComponent) ((EditPart) o).getModel()).getEmfObject();
//					if (eo != null) {
//						newSel.add(eo);
//					}
//				} else 
				if (o instanceof EObject) {
					newSel.add(o);
				}
			}
			
		} else {
			// ???
		}
		
		return new StructuredSelection(newSel);
	}
	
	
	/** Show logo */
	static {
	    new ShowLogo();
	}
	
	/* (non-Javadoc)
	 * @see rtdruid.vartree.IVarTreeProvider#getVarTree()
	 */
	public IVarTree getVarTree() {
		return (IVarTree) (editingDomain instanceof IVarTree ? editingDomain : null);
	}
}
