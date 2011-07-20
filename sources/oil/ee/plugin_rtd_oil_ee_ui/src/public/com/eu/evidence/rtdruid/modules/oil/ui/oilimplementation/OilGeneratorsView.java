package com.eu.evidence.rtdruid.modules.oil.ui.oilimplementation;



import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.ViewPart;

import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.EESectionWritersFactory;
import com.eu.evidence.rtdruid.modules.oil.ee.ui.Activator;
import com.eu.evidence.rtdruid.modules.oil.interfaces.ISectionWriter;

/**
 * This class show all result of schedulability analysis
 * 
 * @author Nicola Serreli
 */

public class OilGeneratorsView extends ViewPart {

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
    public OilGeneratorsView() {
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
                    Activator plugin = Activator.getDefault();
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
		Composite composite = new Composite(parent, SWT.NONE );
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

		// TABLE OF PRIORITIES
		Tree generatorsTable = new Tree(composite, SWT.FULL_SELECTION | SWT.SINGLE | SWT.BORDER | SWT.HIDE_SELECTION | SWT.CHECK);
		{
		    GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.grabExcessHorizontalSpace = true;
			generatorsTable.setLayoutData(data);

			{
				TreeColumn column = new TreeColumn(generatorsTable, SWT.DEFAULT);
				column = new TreeColumn(generatorsTable, SWT.DEFAULT);
				column = new TreeColumn(generatorsTable, SWT.DEFAULT);
			}
			
//			cpuTable.addSelectionListener(new SelectionListener(){
//			
//				public void widgetSelected(SelectionEvent e) {
//					// TODO Auto-generated method stub
//					System.out.println("Selection w");
//				}
//			
//				public void widgetDefaultSelected(SelectionEvent e) {
//					// TODO Auto-generated method stub
//					System.out.println("Selection d");
//				}
//			});
//
//			cpuTable.addMouseListener( new MouseListener() {
//			
//				public void mouseUp(MouseEvent e) {
//					// TODO Auto-generated method stub
//					System.out.println("mouse up");
//				}
//			
//				public void mouseDown(MouseEvent e) {
//					// TODO Auto-generated method stub
//					System.out.println("mouse down");			
//				}
//			
//				public void mouseDoubleClick(MouseEvent e) {
//					// TODO Auto-generated method stub
//					System.out.println("mouse double");
//				}
//			});
//			cpuTable.addSelectionListener(new SelectionListener(){
//				
//				public void widgetSelected(SelectionEvent e) {
//					// TODO Auto-generated method stub
//					System.out.println("Selection w");
//				}
//			
//				public void widgetDefaultSelected(SelectionEvent e) {
//					// TODO Auto-generated method stub
//					System.out.println("Selection d");
//				}
//			});

			generatorsTable.addSelectionListener( new SelectionListener() {
			
				public void widgetSelected(SelectionEvent e) {
					select(e);
				}
				public void widgetDefaultSelected(SelectionEvent e) {
					select(e);
				}

				protected void select(SelectionEvent e) {
					TreeItem selection= null;// = cpuTable.getSelection();
					if (e.item instanceof TreeItem) {
						selection = (TreeItem)e.item;
					}

					if (selection != null) {

						EESectionWritersFactory.setDisabledId((String)selection.getData(), !selection.getChecked());
					
					}
			
				}

			});
		}
		
		init(generatorsTable);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

	
	protected void init(Tree table) {
		
		ISectionWriter[] writers = EESectionWritersFactory.getAllFactories(null);
		
		List<String> disabled = EESectionWritersFactory.getDisabledIds();
		
		for (ISectionWriter val : writers) {
			TreeItem item = new TreeItem(table, SWT.NONE);
			item.setText(0, val.getId());
			String cat = "";
			for (String s : val.getCategory().getKeys()) {
				cat += s +" ";
			}
			item.setText(1, cat);
			item.setText(2, val.getClass().getName());
			item.setData(val.getId());
			
			item.setChecked(!disabled.contains(val.getId()));
		}
		
		for( TreeColumn column : table.getColumns()) {
			column.pack();
		}
	}
}
