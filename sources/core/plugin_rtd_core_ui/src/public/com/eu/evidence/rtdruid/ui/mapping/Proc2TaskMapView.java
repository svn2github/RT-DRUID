package com.eu.evidence.rtdruid.ui.mapping;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreePathContentProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreePathViewerSorter;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

import com.eu.evidence.rtdruid.ui.common.Abstract_VT_View;
import com.eu.evidence.rtdruid.ui.common.StringVTransfer;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.tools.IncompleteMappingException;
import com.eu.evidence.rtdruid.vartree.tools.Mapping;
import com.eu.evidence.rtdruid.vartree.tools.Search;
import com.eu.evidence.rtdruid.vartree.tools.TaskUtility;
import com.eu.evidence.rtdruid.vartree.tools.Search.ArchElement;

/**
 * This class show all result of schedulability analysis
 * 
 * @author Nicola Serreli
 */

public class Proc2TaskMapView extends Abstract_VT_View {
		
	
	protected Tree taskTable;
	protected TreeViewer v;
	protected final boolean enable_v = false;
	protected Table procTable;
	
	protected Mapping map;

    protected String systemPath;
	
	private boolean packColumns = false;

	protected int currentColumn;
	protected TreeItem currentItem;
	protected TreeEditor editor;
	protected Integer newValue;
	protected String errMesg;
	protected Action addTask = new Action("New task") {
	
		public void run() {
			
			InputDialog diag = new InputDialog(getSite().getShell(), "Create a new task" , "Insert the name of new task", "", new IInputValidator() {
			
				public String isValid(String newText) {
					if (Search.aTasks(vt, newText) != null) {
						return "already exist a task with this name";
					}
					
					return null;
				}
			
			});
			
			if (diag.open() == InputDialog.OK) {
				(new TaskUtility(vt)).createTask(diag.getValue());
				doUpdateVarTree();
			}
		}
	
	};
	protected Action removeTask = new Action("Remove tasks") {
		
		public void run() {
			
			String txt = "Remove :";
			TreeItem[] items = taskTable.getSelection();
			for (int i=0; i<items.length; i++) {
           		 if (StringVTransfer.TASK_ID.equals(items[i].getData())) {
           			 txt += "\n" + items[i].getText(0);
            	}
            }
			
			boolean ok = MessageDialog.openConfirm(getSite().getShell(), "Remove task" , txt);
			if (ok) {
				ArrayList<String> names = new ArrayList<String>();
				for (int i=0; i<items.length; i++) {
	           		 if (StringVTransfer.TASK_ID.equals(items[i].getData())) {
	           			 names.add(items[i].getText(0));
	            	}
	            }
				(new TaskUtility(vt)).removeTasks(names);
				doUpdateVarTree();
			}
		}
	
	};
	

	/**
     * The constructor.
     */
    public Proc2TaskMapView() {
    }
    
    /**
     * This is a callback that will allow us to create the viewer and initialize
     * it.
     */
    protected void doCreatePartControl() {
    	
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 2;
			layout.makeColumnsEqualWidth = true;
			layout.verticalSpacing = 12;
			layout.horizontalSpacing = 30;
			rootComposite.setLayout(layout);
		}

		{
			Label containerLabel = new Label(rootComposite, SWT.LEFT);
			containerLabel.setText("Tasks");
			containerLabel.setLayoutData(new GridData());
		}
		
		{
			Label containerLabel = new Label(rootComposite, SWT.LEFT);
			containerLabel.setText("Procs");
			containerLabel.setLayoutData(new GridData());
		}
		
		{// Task Table
			taskTable = new Tree(rootComposite, SWT.LEFT | SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);

			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.verticalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			data.grabExcessVerticalSpace = true;
			taskTable.setLayoutData(data);
			
			{
				Tree pt = taskTable;
				String[] columns = {"Task", "Order" };
				for (int i=0; i<columns.length; i++) {
				    TreeColumn a = new TreeColumn(pt, SWT.LEFT);
					a.setWidth(100);
				    a.setText((String) columns[i]);
				}
			    
				pt.setLinesVisible(true);
				pt.setHeaderVisible(true);
			}
			
			if (enable_v){
				v = new TreeViewer(rootComposite);
				Tree pt = v.getTree();
				
				GridData data_1 = new GridData();
				data_1.horizontalAlignment = GridData.FILL;
				data_1.verticalAlignment = GridData.FILL;
				data_1.grabExcessHorizontalSpace = true;
				data_1.grabExcessVerticalSpace = true;
				pt.setLayoutData(data_1);
				String[] columns = {"Task", "Order" };
				for (int i=0; i<columns.length; i++) {
				    TreeColumn a = new TreeColumn(pt, SWT.LEFT);
					a.setWidth(100);
				    a.setText((String) columns[i]);
				}
			    
				pt.setLinesVisible(true);
				pt.setHeaderVisible(true);
				
				v.setComparator(new TreePathViewerSorter() {
					//@Override
					public int compare(Viewer viewer, Object e1, Object e2) {
						if (e1 instanceof ArchElement && e2 instanceof ArchElement) {
							String name1 = ((ArchElement) e1).name;
							String name2 = ((ArchElement) e2).name;
							
							if (name1 == null) {
								return name2==null ? 0 : 1;
							} 
							return name1.compareTo(name2);
						}
						// else
						return 0;//super.compare(viewer, e1, e2);
					}
				});
				v.setLabelProvider(new ITableLabelProvider() {
				
					//@Override
					public void removeListener(ILabelProviderListener listener) {
						// TODO Auto-generated method stub
						System.out.println("_removeListener__" + listener);
				
					}
				
					//@Override
					public boolean isLabelProperty(Object element, String property) {
						// TODO Auto-generated method stub
						System.out.println("_isLabel__" + element+ " - " + property);

						return false;
					}
				
					//@Override
					public void dispose() {
						// TODO Auto-generated method stub
				
					}
				
					//@Override
					public void addListener(ILabelProviderListener listener) {
						// TODO Auto-generated method stub
						System.out.println("_removeListener__" + listener);
					}
					//@Override
					public Image getColumnImage(Object element, int columnIndex) {
//						System.out.println("_getImage__" + element + " - " + columnIndex);
						return null;
					}
					//@Override
					public String getColumnText(Object element, int columnIndex) {
//						System.out.println("_getText__" + element + " - " + columnIndex);
						if (columnIndex == 0 && element instanceof ArchElement) {
							return ((ArchElement) element).name;
							
						} else if (element instanceof String) {
							
							String t = ((String) element);
							if (columnIndex == 0) {
								return t;
							} else if (columnIndex == 1) {
								Integer i = map.procToTaskOrder(t);
								return i == null ? "" : i.toString();
							}
						}
						return null;
					}
					
				
				});
				v.setContentProvider(new ITreePathContentProvider() {
					IVarTree vt;
					Mapping map;
				
					//@Override
					public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
						vt = null;
						if (newInput instanceof IVarTree) {
							vt = (IVarTree) newInput;
							map = new Mapping(vt, Search.systemName(vt));

						}

						System.out.println("_inputChanged__" + oldInput + " - " + newInput);

					}
				
					//@Override
					public void dispose() {
						vt = null;
						System.out.println("_dispose__");

					}
				
					//@Override
					public Object[] getElements(Object inputElement) {
						// TODO Auto-generated method stub
						System.out.println("_getElements__" + inputElement);
						return null;
					}
				
					//@Override
					public boolean hasChildren(TreePath path) {
//						System.out.println("_hasChildren__" + path);
						Object segment = path.getFirstSegment(); 
						if (segment instanceof ArchElement && path.getSegmentCount() == 1) {
							
							return map.taskToProc(((ArchElement) segment).name).length != 0;
						}
						return false;
					}
				
					//@Override
					public TreePath[] getParents(Object element) {
						// TODO Auto-generated method stub
						System.out.println("_getParents__" + element);
						return null;
					}
				
					//@Override
					public Object[] getChildren(TreePath parentPath) {
						if (parentPath.getSegmentCount()==0) {
							return null;
						}
						
						Object segment = parentPath.getFirstSegment();
						if (segment == vt) {
							return Search.allTasksNames(vt.newTreeInterface());
							
						}
						if (segment instanceof ArchElement) {
							
							return map.taskToProc(((ArchElement) segment).name);
						}
						
						// TODO Auto-generated method stub
						System.out.println("_getChildren__" + parentPath.getFirstSegment());
						return null;
					}
				
				});
				v.setInput(vt);
				
			}

			/*
			 * DROP
			 * 
			 */
			
			// Allow data to be copied or moved to the drop target
			int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;
			DropTarget target = new DropTarget(taskTable, operations);
			
			// Receive data in Text
			final Transfer[] types = new Transfer[] {StringVTransfer.getInstance()};
			//final Transfer[] types = new Transfer[] {TextTransfer.getInstance()};
			target.setTransfer(types);
			target.addDropListener(new DropTargetListener() {
				public void dragEnter(DropTargetEvent event) {
					System.out.println(">>Drop enter");
					if ((event.operations & DND.DROP_MOVE) != 0) {

						event.feedback = DND.FEEDBACK_SELECT
								| DND.FEEDBACK_SCROLL | DND.FEEDBACK_EXPAND;

						event.detail = DND.DROP_MOVE;
					} else {
						event.detail = DND.DROP_NONE;
					}
				}

				public void dragOver(DropTargetEvent event) {
					// System.out.println("Drop over");

					// last check of dropped element
					if ((event.item != null)
							&& (event.item instanceof TreeItem)
							&& (StringVTransfer.TASK_ID
									.equals(((TreeItem) event.item).getData()))
							&& ((event.operations & DND.DROP_MOVE) != 0)) {

						event.detail = DND.DROP_MOVE;
			//			System.out.println(">>Drop over move");
					} else {
						event.detail = DND.DROP_NONE;
				//		 System.out.println(">>Drop over none");
					}

					event.feedback = DND.FEEDBACK_SELECT
						| DND.FEEDBACK_SCROLL | DND.FEEDBACK_EXPAND;
				}

				public void dragOperationChanged(DropTargetEvent event) {
				}

				public void dragLeave(DropTargetEvent event) { }

				public void dropAccept(DropTargetEvent event) {
/*
					// last check of dropped element
					if ((event.item == null)
							|| !(event.item instanceof TreeItem)
							|| (TASK_ID
									.equals(((TreeItem) event.item).getData()))) {
						event.detail = DND.DROP_NONE;
					}
*/
				}

				public void drop(DropTargetEvent event) {
					System.out.println(">>Drop finish");

					if (event.data instanceof String) {
						
						String text = (String) event.data;

						TreeItem parent = ((TreeItem) event.item);
						TreeItem item = new TreeItem(parent, SWT.NONE);
						item.setText(text);
						
						updateProcTaskMapping(parent.getText(), text);
					}
					else if (event.data instanceof String[]) {

						String[] texts = (String[]) event.data;
						for (int i=0; i<texts.length-1; i++) {
						
							TreeItem parent = ((TreeItem) event.item);
							TreeItem item = new TreeItem(parent, SWT.NONE);
							item.setText(texts[i]);

							updateProcTaskMapping(parent.getText(), texts[i]);

							Integer ord = map.procToTaskOrder(texts[i]);
							item.setText(1, ord == null ? "" : ""+ord);

						}

					}
				}
			});
			
			DragSource source = new DragSource(taskTable, operations);
			source.setTransfer(types);
			source.addDragListener(new DragSourceListener() {
				public void dragStart(DragSourceEvent event) {
					// Only start the drag if there is actually text in the
					// label - this text will be what is dropped on the target.
					System.out.println(">>Drag start");

					if (taskTable.getSelectionCount() == 0) {
						event.doit = false;
					} else {
						TreeItem[] items = taskTable.getSelection();						
						for (int i=0; i<items.length && event.doit; i++) {
							if (StringVTransfer.TASK_ID.equals(items[i].getData())) {
								event.doit = false;
							}
							
						}
					}
				};
				public void dragSetData(DragSourceEvent event) {
					// A drop has been performed, so provide the data of the 
					// requested type.
					// (Checking the type of the requested data is only 
					// necessary if the drag source supports more than 
					// one data type but is shown here as an example).
					System.out.println(">>Drag set Data");

					if (taskTable.getSelectionCount() > 0 ) { //&& types[0].isSupportedType(event.dataType)) {
						
						String[] texts = new String[taskTable.getSelectionCount()+1];
						texts[texts.length-1] = StringVTransfer.TASK_ID;
						
						TreeItem[] items = taskTable.getSelection();
						for (int i=0; i<texts.length-1; i++) {
							texts[i] = items[i].getText();
						}
						event.data = texts;
					}
				}
				public void dragFinished(DragSourceEvent event) {
					// A Move operation has been performed so remove the data
					// from the source

					System.out.println(">>Drag Finished");

					if (event.detail == DND.DROP_MOVE) {
						TreeItem[] items = taskTable.getSelection();
						for (int i=0; i<items.length; i++)
							items[i].dispose();

						//label.setText("");
						System.out.println("Rimuovi elementi selezionati");
					}
				}
			});



			editor = new TreeEditor(taskTable); 
			//The editor must have the same size as the cell
			editor.horizontalAlignment = SWT.LEFT;
			editor.grabHorizontal = true;
			
			taskTable.addMouseListener(new MouseAdapter() {

				public void mouseDown(MouseEvent e) {

					// store the previous value, if one and without errors
					storeValue();

					// remove current editor
					deactivateCellEditor();

					// Identify the selected row
					// exit if the item is null or 
					// if the item is a rtos row
					TreeItem item = taskTable.getItem(new Point(e.x, e.y));
					if (item == null) {
						return;
					}
/*					// expande rows ?
					if (item.getImage()!= null) {
						if (item.getImage().getBounds().contains(e.x, e.y)) {
							item.setExpanded(!item.getExpanded());
						}
						return;
					}
*/
					if (StringVTransfer.TASK_ID.equals(item.getData())) { ///getText(0) != null) {
						return;
					}
						
					currentColumn = -1;
					for (int i=0; i<taskTable.getColumnCount(); i++) {
//						System.err.println("\tcolonna " + i + " - " + prioritiesTableTree.getTable().getColumn(i).getText() + " : " +item.getBounds(i).toString() + " - " + item.getText(i));
						if (i == 1 && item.getBounds(i).contains(e.x, e.y)) {
//							System.err.println("\te' la colonna " + i + " - " + prioritiesTableTree.getTable().getColumn(i).getText());\
							currentColumn = i;
							break;
						}
					}
					
					if (currentColumn == -1) {
						return;
					}
			
					currentItem = item;
					
					createEditor();

				}
			});

			
			{  // Create menu POP-UP
		    	MenuManager menuMgr = new MenuManager();
		        menuMgr.setRemoveAllWhenShown(true);
		        menuMgr.addMenuListener(new IMenuListener() {
		                public void menuAboutToShow(IMenuManager mgr) {

	                		mgr.add(addTask);

		                	TreeItem[] items = taskTable.getSelection();
		                	boolean ok = true;
		                	for (int i=0; i<items.length && ok; i++) {
		                		ok &= StringVTransfer.TASK_ID.equals(items[i].getData());
		                	}
		                	if (ok) {
		                		mgr.add(removeTask);
		                	}
		                }
		        });
		        
		        // Create menu.
		        Menu menu = menuMgr.createContextMenu(taskTable);
		        taskTable.setMenu(menu);
	        
			}
			
			
		}

		{// Proc Table
			procTable = new Table(rootComposite, SWT.LEFT | SWT.MULTI | SWT.BORDER);

			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.verticalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			data.grabExcessVerticalSpace = true;
			procTable.setLayoutData(data);
			
			{
				Table pt = procTable;
				String[] columns = {"Proc" };
				for (int i=0; i<columns.length; i++) {
				    TableColumn a = new TableColumn(pt, SWT.LEFT);
					a.setWidth(100);
				    a.setText((String) columns[i]);
				}
			    
				pt.setLinesVisible(true);
				pt.setHeaderVisible(true);
			}
			
			
			// This example will allow text to be dragged
			final Transfer[] types = new Transfer[] {StringVTransfer.getInstance()};
			//final Transfer[] types = new Transfer[] {TextTransfer.getInstance()};

			// This example will allow the text to be copied or moved to the drop target
			int operations = DND.DROP_MOVE;
			
			DragSource source = new DragSource(procTable, operations);
			source.setTransfer(types);
			source.addDragListener(new DragSourceListener() {
				public void dragStart(DragSourceEvent event) {
					// Only start the drag if there is actually text in the
					// label - this text will be what is dropped on the target.
					System.out.println("Drag start");

					if (procTable.getSelectionCount() == 0) {
						//if (procTable.getSelection()[0].getText().length() == 0) {
							event.doit = false;
						//}
					}
				};
				public void dragSetData(DragSourceEvent event) {
					// A drop has been performed, so provide the data of the 
					// requested type.
					// (Checking the type of the requested data is only 
					// necessary if the drag source supports more than 
					// one data type but is shown here as an example).
					System.out.println(">>Drag set Data");

					if (procTable.getSelectionCount() >= 0 ) { //&& types[0].isSupportedType(event.dataType)) {
						
						String[] texts = new String[procTable.getSelectionCount()+1];
						texts[texts.length-1] = StringVTransfer.PROC_ID;
						
						TableItem[] items = procTable.getSelection();
						for (int i=0; i<texts.length-1; i++) {
							texts[i] = items[i].getText();
						}
						event.data = texts;
					}
				}
				public void dragFinished(DragSourceEvent event) {
					// A Move operation has been performed so remove the data
					// from the source

					System.out.println(">>Drag Finished");

					if (event.detail == DND.DROP_MOVE) {
						procTable.remove(procTable.getSelectionIndices());

						//label.setText("");
						System.out.println("Rimuovi elementi selezionati");
					}
				}
			});

			DropTarget target = new DropTarget(procTable, operations);
			target.setTransfer(types);
			target.addDropListener(new DropTargetListener() {
				public void dragEnter(DropTargetEvent event) {
					System.out.println(">>Drop enter");
					if ((event.operations & DND.DROP_MOVE) != 0) {

						event.feedback = DND.FEEDBACK_SELECT
								| DND.FEEDBACK_SCROLL | DND.FEEDBACK_EXPAND;

						event.detail = DND.DROP_MOVE;
					} else {
						event.detail = DND.DROP_NONE;
					}
				}

				public void dragOver(DropTargetEvent event) {
					// System.out.println("Drop over");

					// last check of dropped element
					if ((event.operations & DND.DROP_MOVE) != 0) {

						event.detail = DND.DROP_MOVE;
			//			System.out.println(">>Drop over move");
					} else {
						event.detail = DND.DROP_NONE;
				//		 System.out.println(">>Drop over none");
					}

					event.feedback = DND.FEEDBACK_SELECT
						| DND.FEEDBACK_SCROLL | DND.FEEDBACK_EXPAND;
				}

				public void dragOperationChanged(DropTargetEvent event) {
				}

				public void dragLeave(DropTargetEvent event) { }

				public void dropAccept(DropTargetEvent event) {
/*
					// last check of dropped element
					if ((event.item == null)
							|| !(event.item instanceof TreeItem)
							|| (TASK_ID
									.equals(((TreeItem) event.item).getData()))) {
						event.detail = DND.DROP_NONE;
					}
*/
				}

				public void drop(DropTargetEvent event) {
					System.out.println(">>Drop finish");

					if (event.data instanceof String) {
						
						String text = (String) event.data;

						TreeItem parent = ((TreeItem) event.item);
						TreeItem item = new TreeItem(parent, SWT.NONE);
						item.setText(text);
						
						updateProcTaskMapping(parent.getText(), text);
					}
					else if (event.data instanceof String[]) {

						
						String[] texts = (String[]) event.data;
//						if (texts[texts.length-1])
						for (int i=0; i<texts.length-1; i++) {
						
							TableItem item = new TableItem(procTable, SWT.NONE);
							item.setText(texts[i]);
							
							updateProcTaskMapping(null, texts[i]);
						}

					}
				}
			});

		}
		
	}

    
    private void createEditor() {

    	{	// NOT use deactivate !!!
			Control oldEditor = editor.getEditor();
			if (oldEditor != null) {
				oldEditor.dispose();
		    	// reset the value
		    	newValue = null;
			}
    	}
   System.out.println(">>> task bounds" + 			rootComposite.getBounds());
    	
    	Text newEditor;
		{ // INTEGER
			newEditor = new Text(taskTable, SWT.NONE);
			newEditor.setText(currentItem.getText(currentColumn));
			newEditor.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					// clear all
					errMesg = null;

					String ttmp = ((Text) editor.getEditor()).getText();
					
					// check (step 1)
					if (!"".equals(ttmp)) {
						boolean ok = true;
						try {
							newValue = new Integer(Integer.parseInt(ttmp));
						} catch (NumberFormatException exception) {
							ok = false;
						}
						// check (step 2)
						if ( !ok ) {
							errMesg = "The order of " 
								+ editor.getItem().getText(1)
								+ " inside " 
								+ editor.getItem().getParentItem().getText(1) + " must be an integer";
							newValue = null;
						}
					} else {
						newValue = new Integer(0);
					}

					// before end, check for OK button
					enableOk();
				}
			});
			newEditor.selectAll();

		}
		newEditor.setFocus();
		newEditor.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (e.character == SWT.ESC) {
					deactivateCellEditor();
				}
				else if (e.keyCode == SWT.F5) {
					// The following will simulate a reselect
					createEditor();
				}
				else if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR) {
					storeValue();
					deactivateCellEditor();
				}
			}
		});
		editor.setEditor(newEditor, currentItem, currentColumn);

    }
    private void storeValue() {
    	if (errMesg != null	// new value contains errors
    		|| editor.getEditor() == null	// first time
			|| newValue == null) {		// no changes
    		return;
    	}
    	
		// store / reset value
		editor.getItem().setText(currentColumn, "" + newValue);

		
		String proc = editor.getItem().getText(0);
		String task = editor.getItem().getParentItem().getText(0);

		vt.beginTransaction().setLabel("Set");
		try {
			String ttmp = ((Text) editor.getEditor()).getText();

			if ("".equals(ttmp)){
				newValue = null;
			}
			
			map.setProcToTask(proc, task, newValue);
		} catch (RuntimeException e) {
			vt.rollbackTransaction();
			throw e;
		} finally {
			vt.commitTransaction();
		}
		
    }
    private void deactivateCellEditor() {
		currentColumn = -1;
		currentItem = null;
		newValue = null;

		//System.err.println("punto = " +e.x + ", " +e.y);

		// clear all error messages and check for OK button
		errMesg = null;
		enableOk();

		// Clean up any previous editor control
		Control oldEditor = editor.getEditor();
		if (oldEditor != null) {
			oldEditor.dispose();
		}
    }

	/**
	 * show some "Error messages"
	 */
	protected void enableOk() {
/*		IStatusLineManager statusLineManager = getStatusLineManager();
		if (currentViewer == contentOutlineViewer) {
			statusLineManager = contentOutlineStatusLineManager;
		}

		statusLineManager.setMessage(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_ERROR_TSK).createImage(), message);
		if (propertySheetPage != null) {
			propertySheetPage.getSite().getActionBars().getStatusLineManager().
				setMessage(PlatformUI.getWorkbench().getSharedImages().
					getImageDescriptor(ISharedImages.IMG_OBJS_ERROR_TSK).createImage(),message);
		}
		*/
		
		
		//        setPageComplete(errMesg == null);
		if (errMesg != null ) {
			System.err.println(errMesg);
		}
	}

	
	/**
	 * Change all data and add the listener into the new Tree
	 */
	protected void doSetVarTree(String newMode) {
		
		packColumns = vt != null;

		//mode = newMode;
		systemPath = null;
		map = null;
		
		// set label and tooltip
		String newName = null;
		String newTooltip = null;
		if (vt != null && vt.getResourceSet().getResources().size() > 0) {
			Resource res = (Resource) vt.getResourceSet().getResources().get(0);
			URI uri = res.getURI();
			if (uri != null) {
				newName = uri.lastSegment();
				newTooltip = uri.path();
			}
		}
		setPartName("RT-Druid task table" + (newName == null ? "" : " : " + newName ));
		setTitleToolTip(newTooltip == null ? null : "RT-Druid task table : " + newTooltip );
		fillTables();
		if (enable_v) {
			v.setInput(vt);
		}
	}

	
	/**
	 * Get the system path 
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

	protected void doUpdateVarTree() {
		systemPath = null;
		fillTables();
	}
	/**
	 * take all priorities from a task set and put them into the table
	 *
	 */
    protected void fillTables() {
    	
    	
    	taskTable.setRedraw(false);
    	procTable.setRedraw(false);
    	
    	try {
    		HashSet<String> closed = new HashSet<String>();
    		
    		// 0. store all closed cpus
    		for (int i=0; i<taskTable.getItemCount(); i++) {
    			TreeItem item = taskTable.getItem(i);
    			if (StringVTransfer.TASK_ID == item.getData()) {
    				if (!item.getExpanded()) {
    					closed.add(item.getText(0));
    				}
    			}
    		}
    			
    		
	    	// 1. clear old table
    		taskTable.removeAll();
    		procTable.removeAll();
	
	        // 2. get system, tasks and procs
			String system = getSystemPath();
			
			if (system == null) {	
				//tasks = null;
				return;
			}

			map = new Mapping(vt, systemPath);

			long tot_1 = System.currentTimeMillis();
			Search.ArchElement[] taskNames = Search.allTasksNames(vt.newTreeInterface());
			Search.FunctElement[] procNames = Search.allProcsName(vt);

			long tot_2 = System.currentTimeMillis();
			System.out.println("\ntot time = " + (tot_2-tot_1)+"\n\n");


			final boolean a = true;
			
			if (a) {
				
				class SortProcElement implements Comparable<SortProcElement>{
					public final int position;
					public final String name;
					
					public SortProcElement(String name, int position) {
						this.name = name;
						this.position = position;
					}
					
					//@Override
					public int compareTo(SortProcElement o) {
						return position == o.position ? 
								(name.compareTo(o.name)) :
								(position > o.position ? 1 : -1); 
					}
				}
				// seems to be a little faster
				tot_1 = System.currentTimeMillis();
				// Mapping
				Mapping map = new Mapping(vt, system);
				HashSet<String> mappedProcs = new HashSet<String>();
					
				// sort tasks
				TreeSet<String> tasks_sorted = new TreeSet<String>();
				for (Search.ArchElement taskName : taskNames) {
					tasks_sorted.add(taskName.name);
				}
				
				// create a TreeItem for each task
				for (String taskName : tasks_sorted) {

					TreeItem ti = new TreeItem(taskTable, SWT.DEFAULT);
					ti.setText(taskName);
					ti.setData(StringVTransfer.TASK_ID);

					// sort procs
					
					//ArrayList<SortProcElement> proc_sorted = new ArrayList<SortProcElement>();
					TreeSet<SortProcElement> proc_sorted = new TreeSet<SortProcElement>();
					for (String proc : map.taskToProc(taskName)) {
						Integer ord = map.procToTaskOrder(proc);
						proc_sorted.add(new SortProcElement(proc, ord == null ? -1 : ord.intValue()));
					}
					//Collections.sort(proc_sorted);
					
					for (SortProcElement proc : proc_sorted) {						
						mappedProcs.add(proc.name);

						TreeItem item = new TreeItem(ti, SWT.NONE);
						item.setText(proc.name);
						item.setText(1, proc.position == -1 ? "" : "" + proc.position);

					}
					
					if (!closed.contains(taskName)) {
						ti.setExpanded(true);
					}
				}
				
				for (Search.FunctElement procName : procNames) {
					
					if (!mappedProcs.contains(procName.eviPath)) {
						TableItem ti = new TableItem(procTable, SWT.DEFAULT);
						ti.setText(procName.eviPath);
					}
				}
				
				tot_2 = System.currentTimeMillis();
				
				

			} else {

				tot_1 = System.currentTimeMillis();
				HashMap<String, TreeItem> mapping = new HashMap<String, TreeItem>();
				
				// 3. fill the table
				for (int i=0; i<taskNames.length; i++) {
					TreeItem ti = new TreeItem(taskTable, SWT.DEFAULT);
					ti.setText(taskNames[i].name);
					ti.setData(StringVTransfer.TASK_ID);
//					boolean exp = !closed.containsKey(taskNames[i].name);
//					ti.setExpanded(exp);
					
					mapping.put(taskNames[i].name, ti);
				}

				

				for (int i = 0; i < procNames.length; i++) {

					String taskName = null;
					try {
						taskName = map.procToTask(procNames[i].eviPath);
					} catch (IncompleteMappingException e) {
						// do nothing
					}
					TreeItem taskItem = taskName != null ? (TreeItem) mapping.get(taskName) : null;

					if (taskItem != null) {

						TreeItem item = new TreeItem(taskItem, SWT.NONE);
						item.setText(procNames[i].eviPath);

						Integer ord = map.procToTaskOrder(procNames[i].eviPath);
						item.setText(1, ord == null ? "a" : "" + ord);

					} else {

						TableItem ti = new TableItem(procTable, SWT.DEFAULT);
						ti.setText(procNames[i].eviPath);
					}

				}
				System.out.println("\ntot time = " + (tot_2-tot_1)+"\n\n");
				
				// expand items
				for (int i=0; i<taskNames.length; i++) {
					if (!closed.contains(taskNames[i].name)) {
						((TreeItem) mapping.get(taskNames[i].name)).setExpanded(true);
					}
				}
				tot_2 = System.currentTimeMillis();
			}
	        
			System.out.println("\ntot time proc2Task = " + (tot_2-tot_1)+"\n\n");
			
		    		    
		    // resize all columns
		    if (packColumns) {
		    	{
				    TreeColumn[] columns = taskTable.getColumns();
					for (int i = 0; i < columns.length; i++) {
						columns[i].pack();
					}
		    	}

		    	{
					TableColumn[] columns = procTable.getColumns();
					for (int i = 0; i < columns.length; i++) {
						columns[i].pack();
					}
		    	}
				packColumns = false;
			}
			
    	} finally {
        	taskTable.setRedraw(true);
        	procTable.setRedraw(true);
    	}
    }
    
    protected void updateProcTaskMapping(String task, String proc) {

    	map.setProcToTask(proc, task);    	
    }
}
