package com.eu.evidence.rtdruid.ui.common;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.part.ViewPart;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreeProvider;
import com.eu.evidence.rtdruid.vartree.IVarTreeViewer;

/**
 * This class is an abstract viewer that update itself if the VarTree is changed
 * or if the active editor (VarTreeProvider) is changed
 * 
 * @author Nicola Serreli
 */

public abstract class Abstract_VT_View extends ViewPart implements
		IVarTreeViewer {

	protected IVarTree vt;

	protected INotifyChangedListener vtChListener = new INotifyChangedListener() {

		/**
		 * 3 state : 0 = free 1 = busy 2 = busy and someone ask for more updates
		 */
		private int active = 0;

		/**
		 * Check if the state is free
		 * 
		 * @return true if the state is free
		 */
		protected synchronized boolean go() {
			if (isActive()) {
				return false;
			}
			// no listener active
			if (active == 0) {
				active = 1;
				return true;
			}

			active = 2;
			return false;
		}

		/**
		 * Check if is required a new cicle (state is 2)
		 * 
		 * @return true if is required a new cicle (state is 2)
		 */
		protected synchronized boolean again() {
			if (active == 1) {
				active = 0;
				return false;
			}

			active = 1;
			return true;
		}

		/**
		 * Try to update the table (see also go and again)
		 */
		public void notifyChanged(Notification notification) {
			/*
			 * if (notification.getEventType() == Notification.SET) { Object
			 * newValue = notification.getNewValue(); Object oldValue =
			 * notification.getOldValue(); if ( newValue == null ? oldValue ==
			 * null : !(newValue instanceof ObjectWithID) &&
			 * newValue.equals(oldValue) ) { return; } }
			 * 
			 */
			if (go()) {
				getSite().getShell().getDisplay().asyncExec(new Runnable() {

					public void run() {

						do {
							doUpdateVarTree(); // refresh the window
						} while (again());
					}
				});
			}
		}

	};

	
	/**
	 * This listens for when the outline becomes active <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IPartListener partListener = new IPartListener() {
		public void partActivated(IWorkbenchPart p) {
			if (p instanceof IVarTreeProvider && p instanceof IEditorPart) {
				IVarTree vt = ((IVarTreeProvider) p).getVarTree();
				setVarTree(vt, vt == null ? null : (String) vt.getProperties().get("LastMode"));
			}
		}

		public void partBroughtToTop(IWorkbenchPart p) {
		}

		public void partClosed(IWorkbenchPart p) {
			if (p instanceof IVarTreeProvider && p instanceof IEditorPart) {

				IVarTree vt_p = ((IVarTreeProvider) p).getVarTree();
				if (vt_p == vt) {
					setVarTree(null, null);
				}
			}
		}

		public void partDeactivated(IWorkbenchPart p) {
		}

		public void partOpened(IWorkbenchPart p) {
		}
	};

	protected Composite rootComposite;

	/**
	 * The constructor.
	 */
	public Abstract_VT_View() {
	}

	public void dispose() {

		if (this.vt != null) {
			((ComposedAdapterFactory) this.vt.getAdapterFactory())
					.removeListener(vtChListener);
			this.vt = null;
		}

		getSite().getPage().removePartListener(partListener);

		super.dispose();
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public final void createPartControl(Composite parent) {

		rootComposite = new Composite(parent, SWT.NONE);
		{
			rootComposite.setLayout(new GridLayout());

			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.grabExcessHorizontalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			rootComposite.setLayoutData(data);
		}

		doCreatePartControl();

		{ // init
			IWorkbenchPartSite site = getSite();
			IWorkbenchPage iwp2 = site == null ? null : site.getPage();
			IEditorPart idp = iwp2 == null ? null : iwp2.getActiveEditor();
			
			if (idp != null && idp instanceof IVarTreeProvider) {
				IVarTree tmp = ((IVarTreeProvider) idp).getVarTree();
				setVarTree(tmp, tmp == null  ? null : (String) tmp.getProperties().get("LastMode"));
			}

			if (iwp2 != null) {
//				System.err
//						.println(">>> init " + getClass().getName() + " partlistener using iwp2");
				iwp2.addPartListener(partListener);
				
//			} else {
//				System.err.println(">>> CANNOT init " + getClass().getName() + " partlistener");
			}
		}
		
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		rootComposite.setFocus();
	}

	// ---------------------------------------------------------

	protected boolean isActive() {
		IWorkbenchPartSite site = getSite();
		IWorkbenchWindow iww = site == null ? null : site.getWorkbenchWindow();
		IWorkbenchPage iwp = iww == null ? null : iww.getActivePage();  
		return this == (iwp == null ? null : iwp.getActivePart());
	}

	/**
	 * Change all data and add the listener into the new Tree
	 */
	public final void setVarTree(IVarTree nvt, String newMode) {
		if (this.vt == nvt) {
			return;
		}

		// try to remove the old listener
		if (this.vt != null) {
			try {
				if (vtChListener != null) {
					((ComposedAdapterFactory) this.vt.getAdapterFactory())
							.removeListener(vtChListener);
				}
			} catch (RuntimeException e) {
				RtdruidLog.log(e);
			}

		}
		
		this.vt = nvt;
		
		if (nvt != null) {
			if (newMode == null) {
				nvt.getProperties().remove("LastMode");
			} else {
				nvt.getProperties().put("LastMode", newMode);
			}
			
			// add the new listener
			((ComposedAdapterFactory) this.vt.getAdapterFactory()).addListener(vtChListener);
		}


		doSetVarTree(newMode);
	}

	public void forceUpdate() {
		doUpdateVarTree();
	}
	/**
	 * This method is called if the something stored in the current VT is changed  
	 */
	protected abstract void doUpdateVarTree();
	/**
	 * This method is called if a new VT is setted  
	 */
	protected abstract void doSetVarTree(String newMode);
	
	/**
	 * This method is called to complete the creation of partControl  
	 */
	protected abstract void doCreatePartControl();
	
}
