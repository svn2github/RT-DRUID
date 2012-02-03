/**
 * <copyright>
 * </copyright>
 *
 * $Id: DataActionBarContributor.java,v 1.5 2008/01/09 17:40:54 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.data.presentation;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.emf.edit.ui.action.CreateSiblingAction;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.SubContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.ui.Rtd_core_uiPlugin;

/**
 * This is the action bar contributor for the Data model editor.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DataActionBarContributor
	extends EditingDomainActionBarContributor
	implements ISelectionChangedListener {
	
	protected IMenuManager submenuManager = null;
	
	/**
	 * This keeps track of the active editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IEditorPart activeEditorPart;

	/**
	 * This keeps track of the current selection provider.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ISelectionProvider selectionProvider;
	
	/**
	 * This action opens the Properties view.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IAction showPropertiesViewAction =
		new Action(Rtd_core_uiPlugin.getResourceString("_UI_ShowPropertiesView_menu_item")) {
			public void run() {
				try {
					getPage().showView("org.eclipse.ui.views.PropertySheet");
				}
				catch (PartInitException exception) {
					RtdruidLog.log(exception);
				}
			}
		};

	/**
	 * This action refreshes the viewer of the current editor if the editor
	 * implements {@link org.eclipse.emf.common.ui.viewer.IViewerProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IAction refreshViewerAction =
		new Action(Rtd_core_uiPlugin.getResourceString("_UI_RefreshViewer_menu_item")) {
			public boolean isEnabled() {
				return activeEditorPart instanceof IViewerProvider;
			}

			public void run() {
				if (activeEditorPart instanceof IViewerProvider) {
					Viewer viewer = ((IViewerProvider)activeEditorPart).getViewer();
					if (viewer != null) {
						viewer.refresh();
					}
				}
			}
		};

	/**
	 * This will contain one {@link org.eclipse.emf.edit.ui.action.CreateChildAction} corresponding to each descriptor
	 * generated for the current selection by the item provider.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection createChildActions;

	/**
	 * This is the menu manager into which menu contribution items should be added for "Schedulability analisys" actions.
	 */
	protected IMenuManager schedulabilityAnalysisMenuManager;

	/**
	 * This is the menu manager into which menu contribution items should be added for CreateChild actions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IMenuManager createChildMenuManager;

	/**
	 * This will contain one {@link org.eclipse.emf.edit.ui.action.CreateSiblingAction} corresponding to each descriptor
	 * generated for the current selection by the item provider.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection createSiblingActions;

	/**
	 * This is the menu manager into which menu contribution items should be added for CreateSibling actions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IMenuManager createSiblingMenuManager;

	
	/*** useful with more than one resource
	private ArrayList selectedResources = new ArrayList(); */
	
//	/***/
//	private abstract class AnalysysAction extends Action {
//		
//		public AnalysysAction(String name, String id) {
//			super(name);
//			setId(id);
//		}
//		
//		public void run() {
//			
//			if (activeEditorPart == null || !(activeEditorPart instanceof DataEditor)) 
//				return;
//
//		/*	MessageDialog.openInformation(
//					activeEditorPart.getSite().getShell(),
//					"NOTA!!!",
//					"Ricordarsi di abilitare i modi");*/
//			
//			/*
//			 * Only one resource for editor 
//			 */
//			
//			IVarTree vt = (IVarTree) ((DataEditor) activeEditorPart).getEditingDomain();
//			
//			// ---- set output
//			
//			RTDConsole view = null;
//			try {
//				view = RTDConsole.getConsole();
//				if (view != null) {
//					Messages.setCurrent(view.getMessages());
//				}
//			}
//			catch (Exception exception) {
//				RtdruidLog.log(exception);
//			}
//
//			try { // compute
//				
//				String sys = ( vt.newTreeInterface()).getAllName(null, "System")[0];
//				
//				if (sys != null) {
//				    
//	    			(new CheckReferences(vt, sys)).checkAll();
//	    			if (Messages.getErrorNumber() > 0) {
//	    			    return;
//	    			}
//				    
//					String tmp = compute(vt, sys, null);
//					if (tmp != null) {
//						Messages.sendText(tmp);
//					}
//				}
//				
//				try {
//					RtdruidTableView rtv = (RtdruidTableView) Workbench
//							.getInstance()
//							.getActiveWorkbenchWindow()
//							.getActivePage()
//							.showView(
//									"com.eu.evidence.rtdruid.vartree.data.presentation.RtdruidTableViewID");
//					if (rtv != null) {
//						rtv.setVarTree(vt, null);
//					}
//				} catch (PartInitException exception) {
//					RtdruidLog.log(exception);
//				}
//
//			} finally { // restore output
//				if (view != null) {
//					Messages.setPrevious();
//				}
//			}
//		}
//
//		/** This function is call from run method to compute the schedulability test
//		 * */
//		protected abstract String compute(IVarTree vt, String system, String mode);
//		
//	}
//	
//	/**
//	 * */
//	private Action jscanAction = new AnalysysAction("Analysis without offset", "withoutOffsetID") {
//		
//		public String compute(IVarTree vt, String system, String mode) {
//			
//			Properties options = new Properties();
//			if (mode != null) {
//				options.setProperty(JScan.MODE_STR, mode);
//			}
//			
//			return JScan.startTest(vt, system, JScan.NO_OFFSET_ID, options);
//		}
//
//	};
//	/***/
//	private Action jscanOffsetAction = new AnalysysAction("Fleasible Analysis", "fleasibleID") {
//	    private int F = 2;
//		
//		public String compute(IVarTree vt, String system, String mode) {
//
//		    InputDialog inputF = new InputDialog(
//		            activeEditorPart.getSite().getShell(),
//		            "Fleasible analysis",
//		            "Number of fixed task :",
//		            "" + F,
//		            new IInputValidator() {
//		                public String isValid(String newText) {
//		                    try {
//		                        Integer.parseInt(newText);
//		                    } catch (Exception e) {
//		                        return "It must be a number";
//		                    }
//		                    return null;
//		                }
//		            });
//		    
//		    if (inputF.open() != IDialogConstants.OK_ID) {
//		        return null;
//		    }
//		    
//		    F = Integer.parseInt(inputF.getValue());
//		    
//			Properties options = new Properties();
//			if (mode != null) {
//				options.setProperty(JScan.MODE_STR, mode);
//			}
//			
//			options.setProperty(JScan.F_STR, "" + F);
//			
//			return JScan.startTest(vt, system, JScan.FLEASIBLE_RT_ID, options);
//		}
//
//	};
//
//	private Action eaDMAction = new AnalysysAction("Exact Analysis (DM)", "exactDMID") {
//		
//		public String compute(IVarTree vt, String system, String mode) {
//
//			Properties options = new Properties();
//			if (mode != null) {
//				options.setProperty(JScan.MODE_STR, mode);
//			}
//			
//			return JScan.startTest(vt, system, JScan.EXACT_FP_ID, options);
//
//		}
//
//	};
//
//	private Action eaEDFAction = new AnalysysAction("Exact Analysis (EDF)", "exactEdfID") {
//		
//		public String compute(IVarTree vt, String system, String mode) {
//
//			Properties options = new Properties();
//			if (mode != null) {
//				options.setProperty(JScan.MODE_STR, mode);
//			}
//			
//			return JScan.startTest(vt, system, JScan.EXACT_EDF_ID, options);
//
//		}
//
//	};
//
//	private Action OffsetAssigmentAction = new AnalysysAction("Offset Optimizer", "optimizerID") {
//		
//		public String compute(IVarTree vt, String system, String mode) {
//
//			Properties options = new Properties();
//			if (mode != null) {
//				options.setProperty(JScan.MODE_STR, mode);
//			}
//			
//			return JScan.startTest(vt, system, JScan.EXACT_ID, options);
//
//		}
//
//	};
//
//	/**
//	 * */
//	private Action periodSensAction = new AnalysysAction("Period sensitivity analysis", "periodSensitiveID") {
//		
//		public String compute(IVarTree vt, String system, String mode) {
//			Properties options = new Properties();
//			if (mode != null) {
//				options.setProperty(JScan.MODE_STR, mode);
//			}
//			
//			return JScan.startTest(vt, system, JScan.PERIOD_SENSITIVITY_ID, options);
//		}
//
//	};

	/**
	 * This creates an instance of the contributor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DataActionBarContributor() {
		loadResourceAction = null;// new LoadResourceAction();
		validateAction = null; //new ValidateAction();
	}

	/**
	 * This adds Separators for editor additions to the tool bar.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		toolBarManager.add(new Separator("data-settings"));
		toolBarManager.add(new Separator("data-additions"));
	}

	/**
	 * This adds to the menu bar a menu and some separators for editor additions,
	 * as well as the sub-menus for object creation items.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void contributeToMenu(IMenuManager menuManager) {
		super.contributeToMenu(menuManager);

		if (true) return;

		IMenuManager submenuManager = new MenuManager("Tmp Menu", "rtdruid.vartree.dataMenuID_tmp");
		menuManager.insertAfter("additions", submenuManager);
		submenuManager.add(new Separator("settings"));
		submenuManager.add(new Separator("actions"));
		submenuManager.add(new Separator("additions"));
		submenuManager.add(new Separator("additions-end"));

		// Prepare for CreateChild item addition or removal.
		//
//		createChildMenuManager = new MenuManager(DataEditorPlugin.INSTANCE.getString("_UI_CreateChild_menu_item"));
//		submenuManager.insertBefore("additions", createChildMenuManager);

		// Prepare for CreateSibling item addition or removal.
		//
//		createSiblingMenuManager = new MenuManager(DataEditorPlugin.INSTANCE.getString("_UI_CreateSibling_menu_item"));
//		submenuManager.insertBefore("additions", createSiblingMenuManager);
	/*	
		final MenuManager ViewMenuManager = new MenuManager("Views");
		submenuManager.insertBefore("actions", ViewMenuManager);		
		ViewMenuManager.add(new Action("Show RT-Druid Output") {
			public void run() {
				try {
					getPage().showView("com.eu.evidence.rtdruid.vartree.data.presentation.RtdruidViewID");
				}
				catch (PartInitException exception) {
					DataEditorPlugin.INSTANCE.log(exception);
				}
			}
		});
//*/
//		schedulabilityAnalysisMenuManager = new MenuManager("Quick analysis");
//		submenuManager.insertBefore("actions", schedulabilityAnalysisMenuManager);		
//		schedulabilityAnalysisMenuManager.add(eaEDFAction);
//		schedulabilityAnalysisMenuManager.add(periodSensAction);
//		
//		submenuManager.add(new Action("GC") {
//			public void run() {
//				for (int i=0; i<5; i++) {
//					System.gc();
//					System.runFinalization();
//					try {
//						Thread.sleep(100);
//					} catch (Exception e) {
//						// nothing
//					}
//				}
//				
//				MessageDialog.openInformation(
//						activeEditorPart.getSite().getShell(),
//						"NOTA!!!",
//						 "ObjectWithId = " + ObjectWithIDImpl.cont + "\n"
//						+"Object..List = " + EObjectContainmentUniqueEList.cont);
//	
//			}
//		});
//
/*		schedulabilityAnalysisMenuManager.add(jscanAction);		
		schedulabilityAnalysisMenuManager.add(jscanOffsetAction);
		schedulabilityAnalysisMenuManager.add(eaAction);
	/*	
		submenuManager.insertBefore("actions", OffsetAssigmentAction);
		
		submenuManager.add(new Action("Schedulability Analysis...") {
			public void run() {
				new WizardDialog(getPage().getWorkbenchWindow().getShell(), new AnalysisWizard()).open();
			}
		});


	/*
	  	Non Funzionante !!!
		* abilita e disabilita i menu' quando vuole
		* crea + copie dello stesso menu
		* talvolta non esegue nulla
	* /
				
		String menuId = "rtdruid.vartree.dataMenuID";
		IContributionItem[] ici = menuManager.getItems();
		if (submenuManager == null) {
			for (int i=0; i<ici.length; i++) {
				if (ici[i].getId().equals(menuId)){
					submenuManager = (IMenuManager) ((ActionSetContributionItem) ici[i]).getInnerItem();
					break;
				}
			}
			if (submenuManager == null) {
				submenuManager = new MenuManager(DataEditorPlugin.INSTANCE.getString("_UI_DataEditor_menu"), menuId);
				menuManager.insertAfter("additions", submenuManager);
				submenuManager.add(new Separator("settings"));
				submenuManager.add(new Separator("actions"));
				submenuManager.add(new Separator("additions"));
				submenuManager.add(new Separator("additions-end"));
			}
		
			setEnableMenu(true);
		}
		
		setEnableMenu(true);
		
		
	}

	protected void disposeMenu() {
		submenuManager.remove(schedulabilityAnalysisMenuManager);
		submenuManager.remove("optimizerID");
	}
	
	protected void setEnableMenu(boolean enable) {

		if (submenuManager.find("QuickAnalysisID") != null) {
			IContributionItem[] ici = ((MenuManager) submenuManager.find("QuickAnalysisID")).getItems();
			for (int i=0; i<ici.length; i++) {
				((ActionContributionItem) ici[i]).getAction().setEnabled(enable);
			}
		} else {
			schedulabilityAnalysisMenuManager = new MenuManager("Quick analysis", "QuickAnalysisID");
			submenuManager.insertBefore("actions", schedulabilityAnalysisMenuManager);		
			schedulabilityAnalysisMenuManager.add(jscanAction);		
			schedulabilityAnalysisMenuManager.add(jscanOffsetAction);
			schedulabilityAnalysisMenuManager.add(eaAction);
			schedulabilityAnalysisMenuManager.add(periodSensAction);
		}
		
		if (submenuManager.find("optimizerID") != null) {
			((ActionContributionItem) submenuManager.find("optimizerID")).getAction().setEnabled(enable);
		} else {
			submenuManager.insertBefore("actions", OffsetAssigmentAction);
		}
		
		*/
	}

	/**
	 * When the active editor changes, this remembers the change and registers with it as a selection provider.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActiveEditorGen(IEditorPart part) {
		super.setActiveEditor(part);
		activeEditorPart = part;

		// Switch to the new selection provider.
		//
		if (selectionProvider != null) {
			selectionProvider.removeSelectionChangedListener(this);
		}
		if (part == null) {
			selectionProvider = null;
		}
		else {
			selectionProvider = part.getSite().getSelectionProvider();
			selectionProvider.addSelectionChangedListener(this);

			// Fake a selection changed event to update the menus.
			//
			if (selectionProvider.getSelection() != null) {
				selectionChanged(new SelectionChangedEvent(selectionProvider, selectionProvider.getSelection()));
			}
		}
	}
	public void setActiveEditor(IEditorPart part) {
		setActiveEditorGen(part);
/*
		IWorkbenchPage actpage = Workbench.getInstance().getActiveWorkbenchWindow().getActivePage();
		RtdruidTableView rtv = actpage  == null ? null : (RtdruidTableView) actpage.findView(
						"com.eu.evidence.rtdruid.vartree.data.presentation.RtdruidTableViewID");
		if (rtv != null) {
			if (part == null || !(part instanceof IVarTreeProvider) ) {
				rtv.setVarTree(null, null);
			} else {
			    try {
					IVarTree vt = ((IVarTreeProvider) part).getVarTree();
					rtv.setVarTree(vt, (String) vt.getProperties().get("LastMode"));
			    } catch (RuntimeException e) {
			        RtdruidLog.log(e);
			    }
			}
		}
	*/	
	}
	
	/*** Useful with more than one resource for editor
	public void selectionChanged(SelectionChangedEvent event) {
		selectedResources.clear();
		
		ISelection selection = event.getSelection();
		if (selection instanceof IStructuredSelection) {
			
			for (Iterator iter = ((IStructuredSelection)selection).iterator(); iter.hasNext(); ) {
				Object object = iter.next();

				if (object instanceof ObjectWithIDImpl) {

					object = ((ObjectWithIDImpl) object).eResource();
					
					// continue and check if Resource is an MyXIMReaderImpl
				} 
				if (object instanceof MyXMIReaderImpl) {
					
					if ( !selectedResources.contains(object)) {
					
						selectedResources.add(object);
					}
					
				}
				
			}
		}
		
		selectionChangedGen(event);
	}*/
	

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionChangedListener},
	 * handling {@link org.eclipse.jface.viewers.SelectionChangedEvents} by querying for the children and siblings
	 * that can be added to the selected object and updating the menus accordingly.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		// Remove any menu items for old selection.
		//
		if (createChildMenuManager != null) {
			depopulateManager(createChildMenuManager, createChildActions);
		}
		if (createSiblingMenuManager != null) {
			depopulateManager(createSiblingMenuManager, createSiblingActions);
		}

		// Query the new selection for appropriate new child/sibling descriptors
		//
		Collection newChildDescriptors = null;
		Collection newSiblingDescriptors = null;

		ISelection selection = event.getSelection();
		if (selection instanceof IStructuredSelection && ((IStructuredSelection)selection).size() == 1) {
			Object object = ((IStructuredSelection)selection).getFirstElement();

			EditingDomain domain = ((IEditingDomainProvider)activeEditorPart).getEditingDomain();

			newChildDescriptors = domain.getNewChildDescriptors(object, null);
			newSiblingDescriptors = domain.getNewChildDescriptors(null, object);
		}

		// Generate actions for selection; populate and redraw the menus.
		//
		createChildActions = generateCreateChildActions(newChildDescriptors, selection);
		createSiblingActions = generateCreateSiblingActions(newSiblingDescriptors, selection);

		if (createChildMenuManager != null) {
			populateManager(createChildMenuManager, createChildActions, null);
			createChildMenuManager.update(true);
		}
		if (createSiblingMenuManager != null) {
			populateManager(createSiblingMenuManager, createSiblingActions, null);
			createSiblingMenuManager.update(true);
		}
	}

	/**
	 * This generates a {@link org.eclipse.emf.edit.ui.action.CreateChildAction} for each object in <code>descriptors</code>,
	 * and returns the collection of these actions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection generateCreateChildActions(Collection descriptors, ISelection selection) {
		Collection actions = new ArrayList();
		if (descriptors != null) {
			for (Iterator i = descriptors.iterator(); i.hasNext(); ) {
				actions.add(new CreateChildAction(activeEditorPart, selection, i.next()));
			}
		}
		return actions;
	}

	/**
	 * This generates a {@link org.eclipse.emf.edit.ui.action.CreateSiblingAction} for each object in <code>descriptors</code>,
	 * and returns the collection of these actions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection generateCreateSiblingActions(Collection descriptors, ISelection selection) {
		Collection actions = new ArrayList();
		if (descriptors != null) {
			for (Iterator i = descriptors.iterator(); i.hasNext(); ) {
				actions.add(new CreateSiblingAction(activeEditorPart, selection, i.next()));
			}
		}
		return actions;
	}

	/**
	 * This populates the specified <code>manager</code> with {@link org.eclipse.jface.action.ActionContributionItem}s
	 * based on the {@link org.eclipse.jface.action.IAction}s contained in the <code>actions</code> collection,
	 * by inserting them before the specified contribution item <code>contributionID</code>.
	 * If <code>ID</code> is <code>null</code>, they are simply added.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void populateManager(IContributionManager manager, Collection actions, String contributionID) {
		if (actions != null) {
			for (Iterator i = actions.iterator(); i.hasNext(); ) {
				IAction action = (IAction)i.next();
				if (contributionID != null) {
					manager.insertBefore(contributionID, action);
				}
				else {
					manager.add(action);
				}
			}
		}
	}
		
	/**
	 * This removes from the specified <code>manager</code> all {@link org.eclipse.jface.action.ActionContributionItem}s
	 * based on the {@link org.eclipse.jface.action.IAction}s contained in the <code>actions</code> collection.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void depopulateManager(IContributionManager manager, Collection actions) {
		if (actions != null) {
			IContributionItem[] items = manager.getItems();
			for (int i = 0; i < items.length; i++) {
				// Look into SubContributionItems
				//
				IContributionItem contributionItem = items[i];
				while (contributionItem instanceof SubContributionItem) {
					contributionItem = ((SubContributionItem)contributionItem).getInnerItem();
				}

				// Delete the ActionContributionItems with matching action.
				//
				if (contributionItem instanceof ActionContributionItem) {
					IAction action = ((ActionContributionItem)contributionItem).getAction();
					if (actions.contains(action)) {
						manager.remove(contributionItem);
					}
				}
			}
		}
	}

	/**
	 * This populates the pop-up menu before it appears.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void menuAboutToShow(IMenuManager menuManager) {
		super.menuAboutToShow(menuManager);
		MenuManager submenuManager = null;

		submenuManager = new MenuManager(Rtd_core_uiPlugin.getResourceString("_UI_CreateChild_menu_item"));
		populateManager(submenuManager, createChildActions, null);
		menuManager.insertBefore("additions", submenuManager);

		submenuManager = new MenuManager(Rtd_core_uiPlugin.getResourceString("_UI_CreateSibling_menu_item"));
		populateManager(submenuManager, createSiblingActions, null);
		menuManager.insertBefore("additions", submenuManager);
	}

	/**
	 * This inserts global actions before the "additions-end" separator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGlobalActions(IMenuManager menuManager) {
		menuManager.insertAfter("additions-end", new Separator("ui-actions"));
		menuManager.insertAfter("ui-actions", showPropertiesViewAction);

		refreshViewerAction.setEnabled(refreshViewerAction.isEnabled());		
		menuManager.insertAfter("ui-actions", refreshViewerAction);

		super.addGlobalActions(menuManager);
	}

}
