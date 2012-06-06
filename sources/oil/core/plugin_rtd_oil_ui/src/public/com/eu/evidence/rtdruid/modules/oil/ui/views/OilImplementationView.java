package com.eu.evidence.rtdruid.modules.oil.ui.views;



import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.ViewPart;

import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplFactory;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplID;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplementation;
import com.eu.evidence.rtdruid.modules.oil.ui.Rtd_oil_uiPlugin;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;

/**
 * This class show all result of schedulability analysis
 * 
 * @author Nicola Serreli
 */

public class OilImplementationView extends ViewPart {

	public class DemoAction extends Action {
		
		private IViewPart view;
		
		public DemoAction(String ActionName, IViewPart view){
			super(ActionName);
			this.view = view;
		}
		
		public void run(){
			System.out.println("Demo action");
		}

	}

	private DemoAction demoAction;
	
    /**
     * The constructor.
     */
    public OilImplementationView() {
    }
    
    /**
     * This is a callback that will allow us to create the viewer and initialize
     * it.
     */
    protected void doCreatePartControl() {
    	
    	
		//  	hookContextMenu();
		//    contributeToActionBars();
		createActions();
		createMenu();
        createToolbar();
        createContextMenu();
		
	}

    private void createActions(){
    	demoAction = new DemoAction("Add Task", this);
    	demoAction.setImageDescriptor(getImageDescriptor("full/obj16/AddTask.gif"));
    	
    }
    
    /**
     * Create menu.
     */
    private void createMenu() {
            IMenuManager mgr = getViewSite().getActionBars().getMenuManager();
            mgr.add(demoAction);
    }
    
    /**
     * Create toolbar.
     */
    private void createToolbar() {
            IToolBarManager mgr = getViewSite().getActionBars().getToolBarManager();
            mgr.add(demoAction);
    }
    
    private void createContextMenu() {
        // Create menu manager.
    	MenuManager menuMgr = new MenuManager();
        menuMgr.setRemoveAllWhenShown(true);
        menuMgr.addMenuListener(new IMenuListener() {
                public void menuAboutToShow(IMenuManager mgr) {
                        fillContextMenu(mgr);
                }
        });
        
        // Create menu.
//        Menu menu = menuMgr.createContextMenu(prioritiesTableTree);
//        prioritiesTableTree.setMenu(menu);
        
        // Register menu for extension.
        //getSite().registerContextMenu(menuMgr, prioritiesTableTree);
    }
    
    private void fillContextMenu(IMenuManager mgr) {
        mgr.add(demoAction);
        mgr.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));        
    }
    
    /**
     * Returns the image descriptor with the given relative path.
     */
    private ImageDescriptor getImageDescriptor(String relativePath) {
            String iconPath = "icons/";
            try {
                    Rtd_oil_uiPlugin plugin = Rtd_oil_uiPlugin.getDefault();
                    URL installURL = plugin.getDescriptor().getInstallURL();
                    URL url = new URL(installURL, iconPath + relativePath);
                    return ImageDescriptor.createFromURL(url);
            }
            catch (MalformedURLException e) {
                    // should not happen
                    return ImageDescriptor.getMissingImageDescriptor();
            }
    }
    
//    private void hookContextMenu() {
//        MenuManager menuMgr = new MenuManager("#PopupMenu");
//        menuMgr.setRemoveAllWhenShown(true);
//        menuMgr.addMenuListener(new IMenuListener() {
//            public void menuAboutToShow(IMenuManager manager) {
//                RtdruidTableView.this.fillContextMenu(manager);
//            }
//        });
//        Menu menu = menuMgr.createContextMenu(rootComposite.getControl());
//        rootComposite.getControl().setMenu(menu);
//        getSite().registerContextMenu(menuMgr, rootComposite);
//    }

//    private void contributeToActionBars() {
//        IActionBars bars = getViewSite().getActionBars();
//        fillLocalPullDown(bars.getMenuManager());
//        fillLocalToolBar(bars.getToolBarManager());
//    }

//    private void fillLocalPullDown(IMenuManager manager) {
//        //		manager.add(new Separator());
////        manager.add(clear);
//    }
//
//
//    private void fillLocalToolBar(IToolBarManager manager) {
////        manager.add(clear);
//    }


	///
	protected Button createButton(Composite parent, String label) {
		Button button = new Button(parent, SWT.PUSH);
		button.setText(label);
		button.setFont(JFaceResources.getDialogFont());

		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
//		data.heightHint = IDialogConstants.BUTTON_HEIGHT;
		int widthHint = IDialogConstants.BUTTON_WIDTH;
		data.widthHint = Math.max(widthHint, button.computeSize(SWT.DEFAULT,
				SWT.DEFAULT, true).x);
		button.setLayoutData(data);
		return button;
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		
		Composite rootComposite = new Composite(parent, SWT.NONE);
		{
			rootComposite.setLayout(new GridLayout());

			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.grabExcessHorizontalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			rootComposite.setLayoutData(data);
		}
		
		TextViewer body = new TextViewer(rootComposite, SWT.READ_ONLY | SWT.SEARCH | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		body.getControl().setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));
//		Text body = new Text(rootComposite, SWT.READ_ONLY | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
//		body.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));
		
		
		try {
			
			OilImplFactory factory = OilImplFactory.getAnInstance(VarTreeUtil.newVarTree());
			factory.reloadDefault();
			IOilImplID[] ids = factory.getImplNames();
			if (ids.length >0) {
				IOilImplementation impls = factory.getImpl(ids[0]);
				String oiltxt = impls.toOil();
				body.setDocument(new Document(oiltxt));
//				body.setText(oiltxt);
			}
		} catch (Exception e) {
			e.printStackTrace();
			body.setDocument(new Document(e.getMessage()));
//			body.setText(e.getMessage());;
		}
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

}
