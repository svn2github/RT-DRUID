package com.eu.evidence.rtdruid.ui.mapping;



import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.ui.common.Abstract_VT_View;
import com.eu.evidence.rtdruid.ui.common.StringVTransfer;
import com.eu.evidence.rtdruid.vartree.tools.Mapping;
import com.eu.evidence.rtdruid.vartree.tools.Search;

/**
 * This class show all result of schedulability analysis
 * 
 * @author Nicola Serreli
 */

public class Task2RtosMapView extends Abstract_VT_View {
		
	
	protected Tree rtosTable;
	protected Table taskTable;
	
    protected Mapping map;

    protected String systemPath;
    	
	
	private boolean packColumns = false;

	/**
     * The constructor.
     */
    public Task2RtosMapView() {
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
			containerLabel.setText("Mapping RT-OS & Tasks");
			containerLabel.setLayoutData(new GridData());
		}
		
		{
			Label containerLabel = new Label(rootComposite, SWT.LEFT);
			containerLabel.setText("Not mapped task");
			containerLabel.setLayoutData(new GridData());
		}
		
		{// RT-OS Tree
			rtosTable = new Tree(rootComposite, SWT.LEFT | SWT.BORDER | SWT.MULTI);

			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.verticalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			data.grabExcessVerticalSpace = true;
			rtosTable.setLayoutData(data);
			
			{
				Tree pt = rtosTable;
				String[] columns = {"Name" };
				for (int i=0; i<columns.length; i++) {
				    TreeColumn a = new TreeColumn(pt, SWT.LEFT);
					a.setWidth(100);
				    a.setText((String) columns[i]);
				}
			    
				//pt.setLinesVisible(true);
				pt.setHeaderVisible(true);
			}

			/*
			 * DROP
			 * 
			 */
			
			// Allow data to be copied or moved to the drop target
			int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;
			DropTarget target = new DropTarget(rtosTable, operations);
			
			// Receive data in Text
			final Transfer[] types = new Transfer[] {StringVTransfer.getInstance()};
			//final Transfer[] types = new Transfer[] {TextTransfer.getInstance()};
			target.setTransfer(types);
			target.addDropListener(new DropTargetListener() {
				public void dragEnter(DropTargetEvent event) {
					System.out.println(">>rtos Drop enter");
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
							&& (StringVTransfer.RTOS_ID
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
					System.out.println(">>rtos Drop finish");

					if (event.data instanceof String) {
						
						String text = (String) event.data;

						TreeItem parent = ((TreeItem) event.item);
						TreeItem item = new TreeItem(parent, SWT.NONE);
						item.setText(text);
						
						updateTaskRtosMapping(text, parent.getText());
					}
					else if (event.data instanceof String[]) {

						String[] texts = (String[]) event.data;
						for (int i=0; i<texts.length-1; i++) {
						
							TreeItem parent = ((TreeItem) event.item);
							TreeItem item = new TreeItem(parent, SWT.NONE);
							item.setText(texts[i]);
							
							updateTaskRtosMapping(texts[i], parent.getText());
						}

					}
				}
			});
			
			DragSource source = new DragSource(rtosTable, operations);
			source.setTransfer(types);
			source.addDragListener(new DragSourceListener() {
				public void dragStart(DragSourceEvent event) {
					// Only start the drag if there is actually text in the
					// label - this text will be what is dropped on the target.
					System.out.println(">>rtos Drag start");

					if (rtosTable.getSelectionCount() == 0) {
						event.doit = false;
					} else {
						TreeItem[] items = rtosTable.getSelection();						
						for (int i=0; i<items.length && event.doit; i++) {
							if (StringVTransfer.RTOS_ID.equals(items[i].getData())) {
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
					System.out.println(">>rtos Drag set Data");

					if (rtosTable.getSelectionCount() >= 1 ) { //&& types[0].isSupportedType(event.dataType)) {
						
						String[] texts = new String[rtosTable.getSelectionCount()+1];
						texts[texts.length-1] = StringVTransfer.RTOS_ID;
						
						TreeItem[] items = rtosTable.getSelection();
						for (int i=0; i<texts.length-1; i++) {
							texts[i] = items[i].getText();
						}
						event.data = texts;
					}
				}
				public void dragFinished(DragSourceEvent event) {
					// A Move operation has been performed so remove the data
					// from the source

					System.out.println(">>rtos Drag Finished");

					if (event.detail == DND.DROP_MOVE) {
						TreeItem[] items = rtosTable.getSelection();
						for (int i=0; i<items.length; i++)
							items[i].dispose();

						//label.setText("");
						System.out.println("Rimuovi elementi selezionati");
					}
				}
			});

		}

		{// Task Table
			taskTable = new Table(rootComposite, SWT.LEFT | SWT.MULTI | SWT.BORDER);

			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.verticalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			data.grabExcessVerticalSpace = true;
			taskTable.setLayoutData(data);
			
			{
				Table pt = taskTable;
				String[] columns = {"Task" };
				for (int i=0; i<columns.length; i++) {
				    TableColumn a = new TableColumn(pt, SWT.LEFT);
					a.setWidth(100);
				    a.setText((String) columns[i]);
				}
			    
				//pt.setLinesVisible(true);
				pt.setHeaderVisible(true);
			}
			
			
			// This example will allow text to be dragged
			final Transfer[] types = new Transfer[] {StringVTransfer.getInstance()};
			int operations = DND.DROP_MOVE;
			
			DragSource source = new DragSource(taskTable, operations);
			source.setTransfer(types);
			source.addDragListener(new DragSourceListener() {
				public void dragStart(DragSourceEvent event) {
					// Only start the drag if there is actually text in the
					// label - this text will be what is dropped on the target.
					System.out.println("task Drag start");

					if (taskTable.getSelectionCount() == 0) {
						event.doit = false;
					}
				};
				public void dragSetData(DragSourceEvent event) {
					System.out.println(">>task Drag set Data");

					if (taskTable.getSelectionCount() >= 0 ) { //&& types[0].isSupportedType(event.dataType)) {
						
						String[] texts = new String[taskTable.getSelectionCount()+1];
						texts[texts.length-1] = StringVTransfer.TASK_ID;
						
						TableItem[] items = taskTable.getSelection();
						for (int i=0; i<texts.length-1; i++) {
							texts[i] = items[i].getText();
						}
						event.data = texts;
					}
				}
				public void dragFinished(DragSourceEvent event) {
					// A Move operation has been performed so remove the data
					// from the source

					System.out.println(">>task Drag Finished");

					if (event.detail == DND.DROP_MOVE) {
						taskTable.remove(taskTable.getSelectionIndices());

						System.out.println("Rimuovi elementi selezionati");
					}
				}
			});

			DropTarget target = new DropTarget(taskTable, operations);
			target.setTransfer(types);
			target.addDropListener(new DropTargetListener() {
				public void dragEnter(DropTargetEvent event) {
					System.out.println(">>task Drop enter");
					if ((event.operations & DND.DROP_MOVE) != 0) {

						event.feedback = DND.FEEDBACK_SELECT
								| DND.FEEDBACK_SCROLL | DND.FEEDBACK_EXPAND;

						event.detail = DND.DROP_MOVE;
					} else {
						event.detail = DND.DROP_NONE;
					}
				}

				public void dragOver(DropTargetEvent event) {
					// System.out.println("task Drop over");

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
					System.out.println(">>task Drop finish");

					if (event.data instanceof String[]) {
						
						String[] texts = (String[]) event.data;
//						if (texts[texts.length-1])
						for (int i=0; i<texts.length-1; i++) {
						
							TableItem item = new TableItem(taskTable, SWT.NONE);
							item.setText(texts[i]);
							
							updateTaskRtosMapping(texts[i], null);
						}

					}
				}
			});

		}
	}

	/**
	 * Change all data and add the listener into the new Tree
	 */
	public void doSetVarTree(String newMode) {
		
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
		setPartName("RT-Druid RT-OS vs Task mapping" + (newName == null ? "" : " : " + newName ));
		setTitleToolTip(newTooltip == null ? null : "RT-Druid RT-OS vs Task mapping : " + newTooltip );
		fillTables();
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

	/**
	 * take all priorities from a task set and put them into the table
	 *
	 */
    protected void fillTables() {
    	
    	
    	rtosTable.setRedraw(false);
    	taskTable.setRedraw(false);
    	
    	try {
    		HashSet<String> closed = new HashSet<String>();
    		
    		// 0. store all closed cpus
    		for (int i=0; i<rtosTable.getItemCount(); i++) {
    			TreeItem item = rtosTable.getItem(i);
    			if (StringVTransfer.RTOS_ID == item.getData()) {
    				if (!item.getExpanded()) {
    					closed.add(item.getText(0));
    				}
    			}
    		}
    			
    		
	    	// 1. clear old table
    		rtosTable.removeAll();
    		taskTable.removeAll();
	
	        // 2. get system, tasks and procs
			String system = getSystemPath();
			
			if (system == null) {	
				//tasks = null;
				return;
			}

			map = new Mapping(vt, systemPath);

			Search.ArchElement[] rtosNames = Search.allRtosNames(vt.newTreeInterface());
			Search.ArchElement[] taskNames = Search.allTasksNames(vt.newTreeInterface());

			
			HashMap<String, TreeItem> mapping = new HashMap<String, TreeItem>();
			
			
			// 3. fill the table
			for (int i=0; i<rtosNames.length; i++) {
				
				
				TreeItem ti = new TreeItem(rtosTable, SWT.DEFAULT);
				ti.setText(rtosNames[i].name);
				ti.setData(StringVTransfer.RTOS_ID);
				//ti.setExpanded(!closed.containsKey(rtosNames[i].name));
				
				mapping.put(rtosNames[i].name, ti);
			}
			
			for (int i=0; i<taskNames.length; i++) {
				
				TreeItem taskItem = (TreeItem) mapping.get(map.taskToRTOS(taskNames[i].name));

				if (taskItem != null) {

					TreeItem item = new TreeItem(taskItem, SWT.NONE);
					item.setText(taskNames[i].name);

				} else {
					
					TableItem ti = new TableItem(taskTable, SWT.DEFAULT);
					ti.setText(taskNames[i].name);
				}
				
				
			}
	        
			// expand items
			for (int i=0; i<rtosNames.length; i++) {
				if (!closed.contains(rtosNames[i].name)) {
					((TreeItem) mapping.get(rtosNames[i].name)).setExpanded(true);
				}
			}
		    		    
		    // resize all columns
		    if (packColumns) {
		    	{
				    TreeColumn[] columns = rtosTable.getColumns();
					for (int i = 0; i < columns.length; i++) {
						columns[i].pack();
					}
		    	}

		    	{
					TableColumn[] columns = taskTable.getColumns();
					for (int i = 0; i < columns.length; i++) {
						columns[i].pack();
					}
		    	}
				packColumns = false;
			}
			
    	} finally {
        	rtosTable.setRedraw(true);
        	taskTable.setRedraw(true);
    	}
    }
    
    protected void updateTaskRtosMapping(String taskName, String rtosName) {

    	try {
    		map.setTaskToRTOS(taskName, rtosName);
    	} catch (Throwable t) {
    		RtdruidLog.log(t);
    		//t.printStackTrace();
    	}
    }
    
	protected void doUpdateVarTree() {
		systemPath = null;
		fillTables();
	}

}
