/*
 * Created on Feb 21, 2005
 *
 * $Id: FunctionalFlowViewer.java,v 1.2 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.mapping.functionalviewer.ui;


import java.util.EventObject;
import java.util.HashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.DirectEditAction;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;

import com.eu.evidence.rtdruid.io.IVTResource;
import com.eu.evidence.rtdruid.io.RTD_XMI_Factory;
import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.GSystem;
import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.model.ModelLoader;
import com.eu.evidence.rtdruid.modules.mapping.functionalviewer.parts.ActivityPartFactory;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;

/**
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public class FunctionalFlowViewer extends GraphicalEditor {

	IVarTree vt = null;

	GSystem diagram;

	private KeyHandler sharedKeyHandler;

	public FunctionalFlowViewer() {
		DefaultEditDomain defaultEditDomain = new DefaultEditDomain(this);
		//	defaultEditDomain.setActiveTool(new ConnectionCreationTool());
		setEditDomain(defaultEditDomain);
	}

	public FunctionalFlowViewer(IVarTree vt) {
		DefaultEditDomain defaultEditDomain = new DefaultEditDomain(this);
		//	defaultEditDomain.setActiveTool(new ConnectionCreationTool());
		setEditDomain(defaultEditDomain);
		this.vt = vt;
	}
	
	/**
	 * OverWrite parent method to improve SelectionChange
	 * @param parent the parent composite
	 */
	protected void createGraphicalViewer(Composite parent) {
		GraphicalViewer viewer = new ScrollingGraphicalViewer() {
			/* (non-Javadoc)
			 * @see org.eclipse.gef.ui.parts.AbstractEditPartViewer#setSelection(org.eclipse.jface.viewers.ISelection)
			 */
			public void setSelection(ISelection newSelection) {
				if (newSelection instanceof IStructuredSelection) {
					
					Object first = ((IStructuredSelection)newSelection).getFirstElement();
					
					if (first != null && !(first instanceof EditPart)) {
						return;
					}
					
					super.setSelection(newSelection);
				}
			}
		};
		viewer.createControl(parent);
		setGraphicalViewer(viewer);
		configureGraphicalViewer();
		hookGraphicalViewer();
		initializeGraphicalViewer();
	}
	
	

	/**
	 * @see org.eclipse.gef.commands.CommandStackListener#commandStackChanged(java.util.EventObject)
	 */
	public void commandStackChanged(EventObject event) {
		/*
		 * if (isDirty()) { if (!savePreviouslyNeeded()) {
		 * setSavePreviouslyNeeded(true);
		 * firePropertyChange(IEditorPart.PROP_DIRTY); } } else {
		 * setSavePreviouslyNeeded(false);
		 * firePropertyChange(IEditorPart.PROP_DIRTY); }
		 */
		super.commandStackChanged(event);
	}

	/**
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#createActions()
	 */
	protected void createActions() {
		super.createActions();
		ActionRegistry registry = getActionRegistry();
		IAction action;

		action = new DirectEditAction((IWorkbenchPart) this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
	}

	/**
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#configureGraphicalViewer()
	 */
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		getGraphicalViewer().setRootEditPart(new ScalableRootEditPart());
		getGraphicalViewer().setEditPartFactory(new ActivityPartFactory());
		getGraphicalViewer().setKeyHandler(
				new GraphicalViewerKeyHandler(getGraphicalViewer())
						.setParent(getCommonKeyHandler()));

	}

	/**
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#initializeGraphicalViewer()
	 */
	protected void initializeGraphicalViewer() {
		getGraphicalViewer().setContents(diagram);

	}

	/**
	 * @see org.eclipse.ui.ISaveablePart#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void doSave(IProgressMonitor monitor) {
		// nothing
	}

	/**
	 * @see org.eclipse.ui.ISaveablePart#doSaveAs()
	 */
	public void doSaveAs() {
		// nothing
	}

	protected KeyHandler getCommonKeyHandler() {
		if (sharedKeyHandler == null) {
			sharedKeyHandler = new KeyHandler();
		}
		return sharedKeyHandler;
	}

	public void gotoMarker(IMarker marker) {
	}

	/**
	 * @see org.eclipse.ui.ISaveablePart#isDirty()
	 */
	public boolean isDirty() {
		return false; //return isSaveOnCloseNeeded();
	}

	/**
	 * @see org.eclipse.ui.ISaveablePart#isSaveAsAllowed()
	 */
	public boolean isSaveAsAllowed() {
		return false; //return true;
	}

	/**
	 * @see org.eclipse.ui.ISaveablePart#isSaveOnCloseNeeded()
	 */
	public boolean isSaveOnCloseNeeded() {
		return false; // return getCommandStack().isDirty();
	}

	private boolean savePreviouslyNeeded() {
		return false; //return savePreviouslyNeeded;
	}

	/**
	 * @see org.eclipse.ui.part.EditorPart#setInput(org.eclipse.ui.IEditorInput)
	 */
	protected void setInput(IEditorInput input) {
		super.setInput(input);
		
		if (vt == null) {
			vt = VarTreeUtil.newVarTree();
	
			// get data
			IFile file = ((IFileEditorInput) input).getFile();
	
			// set the title of current editor
			setPartName(file.getName());
	
			// load resource
			IVTResource res = (IVTResource) new RTD_XMI_Factory().createResource();
			try {
				res.load(file.getContents(), new HashMap());
			} catch (Exception e) {
				e.printStackTrace();
	
				throw new RuntimeException(e.getMessage());
			}
	
			EObject root = res.getContents().get(0);
	
			vt.setRoot(root);
			res.getContents().clear();
		}
		
		// prepare graphics
		diagram = (new ModelLoader()).loadFunctionalFlow(vt);

		
	}

	
	public void setSelection(SelectionChangedEvent newSelection) {

	}
}