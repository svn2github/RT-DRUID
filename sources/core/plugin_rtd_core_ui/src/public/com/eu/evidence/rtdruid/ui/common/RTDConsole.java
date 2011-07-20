/*
 * Created on Jun 29, 2005
 *
 * $Id: RTDConsole.java,v 1.3 2007/07/18 07:11:53 durin Exp $
 */
package com.eu.evidence.rtdruid.ui.common;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IFindReplaceTarget;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.console.AbstractConsole;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.actions.ClearOutputAction;
import org.eclipse.ui.console.actions.TextViewerAction;
import org.eclipse.ui.console.actions.TextViewerGotoLineAction;
import org.eclipse.ui.part.IPageBookViewPage;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.texteditor.FindReplaceAction;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.IUpdate;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.ui.Rtd_core_uiPlugin;

/**
 * TODO Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public class RTDConsole extends AbstractConsole {
	
	protected EclipseViewMessages messages;
	protected RTDPageBookViewPage currentPage;
	
	protected class RTDPageBookViewPage extends Page 
		implements IRtdruidOutputView, IAdaptable {
		
		private IConsoleView view;
		
	    volatile private TextViewer viewer;

	    private Action clearAction;
	    private Action copyAction;
	    private Action selectAllAction;
	    //private Action copyAllAction;
	    private Action find;
	    private Action gotoLine;
	    private Action removeConsole;
	    private Clipboard clipboard;
	    
	    private Buffer docBuffer;
	    
	    private class Buffer {
	    	
	    	private LinkedList<String> buff = new LinkedList<String>();
	    	private boolean clear = false;
	    	
	    	private boolean work = false;
	    	private boolean enabled = false;
	    	
	    	synchronized public void append(String txt) {
	    		try {
		    		buff.addLast(txt);
		
		    		if (!work && enabled) {
		    			run();
		    		}
		    		
	    		} catch (ThreadDeath e) {
	    			// if some one use Send Messages without protect it,
	    			// clear buffer and log exception 
	    			buff = new LinkedList<String>();
	    			RtdruidLog.log(e);
	    			throw e;
	    		}
	    	}
	    	
	    	synchronized public void clear() {
	    		clear = true;
	    		buff.clear();

	    		if (!work && enabled) {
	    			run();
	    		}
	    	}
	    	
	    	synchronized public void enable(boolean value) {
	    		enabled = value;
	    		if (!work && enabled) {
	    			run();
	    		}
	    	}
	    	
	    	private void run() {
	    		work = true;
	    		
				getSite().getShell().getDisplay().asyncExec
				(new Runnable() {

					public void run() {
						try {
							// disable redraw
							viewer.setRedraw(false);

							// oldLenght contains the legnth of Document before changes
							// is set to 0 when the text is clear 
							// int oldNumberOfLines = viewer.getDocument().getNumberOfLines();
							
							
				    		for (Object[] obj = getWork(); obj != null; obj = getWork() ) {
				    			
				    			if (((Boolean) obj[1]).booleanValue()) {
				    				viewer.getDocument().set("");
				    				selectAllAction.setEnabled(false);
				    				//copyAllAction.setEnabled(false);
				    				clearAction.setEnabled(false);
				    				//oldNumberOfLines = 0;
				    				
				    			}
				
				    			Iterator<String> iter = ((LinkedList<String>) obj[0]).iterator();
				    			while (iter.hasNext()) {
				    				String message = (String) iter.next();
				    				
				        	        try {
				        	        	//oldNumberOfLines = viewer.getDocument().getNumberOfLines();
				        	            viewer.getDocument().replace(viewer.getDocument().getLength(), 0, message);
				        	        } catch (BadLocationException e) {
				        	            e.printStackTrace();
				        	        }
				    			}
				    			
				    		}
				    		
				    		{ // enable buttons
				    	        boolean enable = viewer.getDocument().getLength() > 0;
				    	        selectAllAction.setEnabled(enable);
				    	        //copyAllAction.setEnabled(enable);
				    	        clearAction.setEnabled(enable);
				    	        
				    	        // update find
				    	        if (find instanceof IUpdate) {
				    				((IUpdate)find).update();
				    	        }

				    		}

				    		{ // set the end of the current document
//								viewer.setRedraw(true);
//				    			viewer.setTopIndex(oldNumberOfLines-1);
				    			
		    					IDocument doc = viewer.getDocument();
		    					int lines = doc.getNumberOfLines();
		    					try {
		    						// lines are 0-based
		    						int lineStartOffset = doc.getLineOffset(lines - 1);
		    						StyledText widget = viewer.getTextWidget();
		    						if (lineStartOffset > 0) {
		    							widget.setCaretOffset(lineStartOffset);
		    							widget.showSelection();
		    						}
		    						int lineEndOffset = lineStartOffset + doc.getLineLength(lines - 1);
		    						if (lineEndOffset > 0) {
		    							widget.setCaretOffset(lineEndOffset);
		    						}
		    					} catch (BadLocationException e) {
		    					}
				    			
				    		}

						} finally  {
							viewer.setRedraw(true);
						}
					}
				});
	    	}
	    	
	    	/**
	    	 * This function return 2 objects :
	    	 * 		Object[0] = LinkedList(String) = all new strings
	    	 * 		Object[1] = Boolean = clear before store all
	    	 * 
	    	 * or null if there is no work
	    	 * 
	    	 * @return 
	    	 */
	    	private synchronized Object[] getWork() {
	    		
	    		// stop ? 
	    		if (!clear && buff.size() == 0) {
	    			work = false;
	    			return null;
	    		}
	    		
	    		// prepare answer
	    		Object[] answer = new Object[2];
	    		answer[0] = buff.clone();
	    		answer[1] = new Boolean(clear);
	    		
	    		// reset
	    		buff.clear();
	    		clear = false;
	    		
	    		
	    		return answer;
	    	}
	    	
	    }

	    /**
	     * The constructor.
	     */
	    public RTDPageBookViewPage() {
	    	docBuffer = new Buffer();
	    }
	    
	    public void setConsolView(IConsoleView view) {
	    	this.view = view;
	    }

	    /**
	     * This is a callback that will allow us to create the viewer and initialize
	     * it.
	     */
	    public void createControl(Composite parent) {

	        viewer = new TextViewer(parent, SWT.READ_ONLY | SWT.MULTI
	                | SWT.H_SCROLL | SWT.V_SCROLL) {
	        	/* (non-Javadoc)
				 * @see org.eclipse.jface.text.TextViewer#setDocument(org.eclipse.jface.text.IDocument)
				 */
				public void setDocument(IDocument document) {
					docBuffer.enable(document != null);
					super.setDocument(document);
				}
	        };
	        viewer.getTextWidget().setDoubleClickEnabled(true);
	        
	        //viewer.setInput(getSite());
	        viewer.setDocument(new Document());
	        
	        clipboard = new Clipboard(getSite().getShell().getDisplay());
	        //viewer.enableOperation(ITextOperationTarget.COPY, true);
	        makeActions();
	        hookContextMenu();
	        contributeToActionBars();

	        viewer.addSelectionChangedListener(new ISelectionChangedListener() {
	        	public void selectionChanged(SelectionChangedEvent event) {
	        		boolean active = false;
	        		ISelection sel = event.getSelection();
	            	if (sel != null && sel instanceof TextSelection && ((TextSelection) sel).getLength() != 0) {
	    				active = true;
	            	}
	            	copyAction.setEnabled(active);
	        	}
	        });

	        // disable actions (void document
	        selectAllAction.setEnabled(false);
	        //copyAllAction.setEnabled(false);
	        clearAction.setEnabled(false);
	        copyAction.setEnabled(false);

	        
	        // update screen
	        //docBuffer.enable();
	    }
	    
		/* (non-Javadoc)
		 * @see org.eclipse.ui.part.Page#getControl()
		 */
		public Control getControl() {
			return viewer.getControl();
		}


	    private void hookContextMenu() {
	        MenuManager menuMgr = new MenuManager("#PopupMenu");
	        menuMgr.setRemoveAllWhenShown(true);
	        menuMgr.addMenuListener(new IMenuListener() {
	            public void menuAboutToShow(IMenuManager manager) {
	            	RTDPageBookViewPage.this.fillContextMenu(manager);
	            }
	        });
	        Menu menu = menuMgr.createContextMenu(viewer.getControl());
	        viewer.getControl().setMenu(menu);
			IPageSite site = getSite();
			site.registerContextMenu(
					Rtd_core_uiPlugin.PLUGIN_ID + ".RTDConole",
					menuMgr,
					viewer); //$NON-NLS-1$
	    }

	    private void contributeToActionBars() {
	        IActionBars bars = getSite().getActionBars();
	        fillLocalPullDown(bars.getMenuManager());
	        fillLocalToolBar(bars.getToolBarManager());
	        
	        bars.setGlobalActionHandler(ITextEditorActionConstants.GOTO_LINE, gotoLine);
	        bars.setGlobalActionHandler(ActionFactory.FIND.getId(), find);
	        bars.setGlobalActionHandler(ActionFactory.COPY.getId(), copyAction);
	        bars.setGlobalActionHandler(ActionFactory.SELECT_ALL.getId(), selectAllAction);
	        
	    }

	    private void fillLocalPullDown(IMenuManager manager) {
	        //		manager.add(new Separator());
	        manager.add(copyAction);
	        manager.add(selectAllAction);
	        //manager.add(copyAllAction);
	        manager.add(new Separator());
	        manager.add(clearAction);
	        manager.add(new Separator());
	        manager.add(find);
	        manager.add(gotoLine);
	        manager.add(new Separator());
	        manager.add(removeConsole);
	    }

	    private void fillContextMenu(IMenuManager manager) {
	        manager.add(copyAction);
	        manager.add(selectAllAction);
	        //manager.add(copyAllAction);
	        manager.add(new Separator());
	        manager.add(clearAction);
	        manager.add(new Separator());
	        manager.add(find);
	        manager.add(gotoLine);
	        manager.add(new Separator());
	        manager.add(removeConsole);
	        // Other plug-ins can contribute there actions here
	        manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	    }

	    private void fillLocalToolBar(IToolBarManager manager) {
	    	manager.appendToGroup(IConsoleConstants.OUTPUT_GROUP, copyAction);
	    	manager.appendToGroup(IConsoleConstants.OUTPUT_GROUP, clearAction);
	    }

	    /**
	     * Passing the focus request to the viewer's control.
	     */
	    public void setFocus() {
	        viewer.getControl().setFocus();
	        if (find instanceof IUpdate) {
				((IUpdate)find).update();
	        }
	    }

	    // ---------- ACTIONS ------------------

	    private void makeActions() {
	    	/*if (false) {
		        copyAction = new Action() {
		            public void run() {
		            	String data = null;
		            	ISelection sel = viewer.getSelection();
		            	if (sel != null && sel instanceof TextSelection && ((TextSelection) sel).getLength() != 0) {
		    				data = ((TextSelection) sel).getText();
	
		            	}
		    			if (data != null && data.length() > 0) {
		    				clipboard.setContents(new Object[] {data}, new Transfer[] {TextTransfer.getInstance()});
		    			}
		            }
		        };
		        copyAction.setText("Copy");
		        copyAction.setToolTipText("Copy");
		        copyAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
		                .getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
	//	                .getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
	
//		        copyAllAction = new Action() {
//		            public void run() {
//		            	String data = null;
//		       			data = viewer.getDocument() != null ? viewer.getDocument().get() : null;
//	
//		       			if (data != null && data.length() > 0) {
//		    				clipboard.setContents(new Object[] {data}, new Transfer[] {TextTransfer.getInstance()});
//		    			}
//		            }
//		        };
//		        copyAllAction.setText("Copy all");
//		        copyAllAction.setToolTipText("Copy all");
//		        copyAllAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
//		                .getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
	    	}*/
	    	
			ResourceBundle bundle = Rtd_core_uiPlugin.getDefault().getResourceBundle();

	    	
			TextViewerAction action = new TextViewerAction(viewer, ITextOperationTarget.COPY);
			action.configureAction(bundle.getString("ConsolePage.&Copy@Ctrl+C"),
					bundle.getString("ConsolePage.Copy"), bundle.getString("ConsolePage.Copy"));
			action.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
			action.setDisabledImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_TOOL_COPY_DISABLED));
			action.setHoverImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
			copyAction = action;
			
			action = new TextViewerAction(viewer, ITextOperationTarget.SELECT_ALL);
			action.configureAction(bundle.getString("ConsolePage.Select_&All@Ctrl+A"), //$NON-NLS-1$
					bundle.getString("ConsolePage.Select_All"), //$NON-NLS-1$
					bundle.getString("ConsolePage.Select_All")); //$NON-NLS-1$
			selectAllAction = action;

	        
	        clearAction = new ClearOutputAction(viewer) {
	            public void run() {
	                clearText();
	            }
	        };
	        
	        find = new FindReplaceAction(bundle, "find_replace_action.", //$NON-NLS-1$
					view);
			gotoLine = new TextViewerGotoLineAction(viewer);
			
			removeConsole = new Action("Drop console") {
				public void run() {
					
			    	IConsoleManager consoleManager = ConsolePlugin.getDefault().getConsoleManager();

			    	consoleManager.removeConsoles(new IConsole[] {
			    		RTDConsole.this	
			    	});
				}
			};

	    }

	    // ----------- Text functions -----------

	    public void appendMessage(String message) {
	    	docBuffer.append(message);
	    }

	    public void clearText() {
	    	docBuffer.clear();
	    }

		/* (non-Javadoc)
		 * @see org.eclipse.ui.IWorkbenchPart#dispose()
		 */
		public void dispose() {
			clipboard.dispose();
			super.dispose();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
		 */
		public Object getAdapter(Class required) {
			if (IFindReplaceTarget.class.equals(required)) {
				return viewer.getFindReplaceTarget();
			}
			return null;
		}
		
	}
	
	/**
	 * Constructs a new console with the given name and image.
	 * 
	 * @param name console name, cannot be <code>null</code>
	 * @param imageDescriptor image descriptor, or <code>null</code> if none
	 */
	public RTDConsole(String name, ImageDescriptor imageDescriptor) {
		super(name, imageDescriptor);
		currentPage = new RTDPageBookViewPage();
		messages = new EclipseViewMessages(currentPage);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.console.IConsole#createPage(org.eclipse.ui.console.IConsoleView)
	 */
	public IPageBookViewPage createPage(IConsoleView view) {
		currentPage.setConsolView(view);
		return currentPage;
	}
	
	public Messages getMessages() {
		return messages;
	}
	
	public void clear() {
		currentPage.clearText();
	}

	// -------------------------------
	
    
    /** 
     * Check if console manager already contains an RTDConsole. If yes, return that instance, 
     * otherwise create a new instance of RTDConsole and add it to Console Manager.
     * 
     * Than returns the showed instance of RTDConsole;
     */
    public static RTDConsole getConsole() {

    	IConsoleManager consoleManager = ConsolePlugin.getDefault().getConsoleManager();

    	// search if already exist an instance
    	IConsole[] allConsoles = consoleManager.getConsoles();
    	for (int i=0; i<allConsoles.length; i++) {
    		if (allConsoles[i] instanceof RTDConsole) {
    	    	consoleManager.showConsoleView(allConsoles[i]);
    			return (RTDConsole) allConsoles[i];
    		}
    	}
    	
    	// create and store a new instance of RTDconsole
    	RTDConsole console = new RTDConsole("RT-Druid output", null);
    	consoleManager.addConsoles( new IConsole[] {console});

    	return console;
    }
}
