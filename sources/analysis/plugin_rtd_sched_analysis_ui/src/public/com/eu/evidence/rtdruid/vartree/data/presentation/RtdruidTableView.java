package com.eu.evidence.rtdruid.vartree.data.presentation;



import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.jscan.JScan;
import com.eu.evidence.rtdruid.internal.modules.jscan.ValueNotFoundException;
import com.eu.evidence.rtdruid.modules.jscan.ui.rtd_jscan_ui.Rtd_jscan_uiPlugin;
import com.eu.evidence.rtdruid.ui.common.Abstract_VT_View;
import com.eu.evidence.rtdruid.ui.common.RTDConsole;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreeProvider;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Task;
import com.eu.evidence.rtdruid.vartree.abstractions.old.TaskSet;
import com.eu.evidence.rtdruid.vartree.data.actions.AddCPUAction;
import com.eu.evidence.rtdruid.vartree.data.actions.AddTaskAction;
import com.eu.evidence.rtdruid.vartree.tools.CheckReferences;
import com.eu.evidence.rtdruid.vartree.tools.Mapping;
import com.eu.evidence.rtdruid.vartree.tools.Search;
import com.eu.evidence.rtdruid.vartree.tools.Utility;
import com.eu.evidence.rtdruid.vartree.tools.WcetCommon;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

/**
 * This class show all result of schedulability analysis
 * 
 * @author Nicola Serreli
 */

public class RtdruidTableView extends Abstract_VT_View implements IVarTreeProvider {
	final static String TIME_EDITOR = "timeEditor";
	final static String INTEGER_EDITOR = "integerEditor";
	
	static final protected String[][] taskP = {
			{ Task.STR_ACT_TYPE,    "__see_task__"},
			{ "wcet",    "__see_task__"},
			{ "period",  "__see_task__"},
			{ "deadline","__see_task__"},
			{ "priority","__see_task__"},
			{ "threshold","__see_task__"},
			{ "stack","__see_task__"},
			{ "priority","__see_task__"},
			{ "resource",      "__see_task__"  },
			{ "offset",            "__see_task__"            },
			{ "ResponseTime",          "__see_task__"          },
//			{ "PreemptionGroupName",  "__see_task__"  },
//			{ "blocking",          "__see_task__"          },
			{ "schedulable",       "__see_task__"       },
			{ "utilization",       "__see_task__"       },
			{ "cDelta",              "__see_task__"              }
	};
	
	static final protected Object[][] columns = new Object[][] {
			{"RTOS",      null, null},
			{"Task Name", null, null},
			{"Priority",  "priority", INTEGER_EDITOR},
			{"Threshold",  "threshold", INTEGER_EDITOR},
			{"Stack",  "stack", INTEGER_EDITOR},
			{"WCET",      "wcet",     TIME_EDITOR},
			{"Period",    "period",   TIME_EDITOR},
			{"Deadline",  "deadline", TIME_EDITOR},
			{ "Offset",   "offset",   TIME_EDITOR},
			
			{ "Resource", "resource", null},
			{ "ResponseTime",      "ResponseTime", null },
//			{ "PreemptionGroupName","PreemptionGroupName", null },
//			{ "blocking",           "blocking", null },
			{ "Schedulable",        "schedulable", null },
			{ "CDelta",             "cDelta", null },
			{ "Utilization",        "utilization", null }	
	};
	
	protected int STACK_COL = 4;
	protected int currentColumn;
	protected TreeItem currentItem = null;
	protected String newValue;

	protected Tree prioritiesTableTree;
	protected TreeEditor editor;
	protected String errMesg = null;
	
	protected Combo modeText;
    
	protected TaskSet tasks;
	protected String systemPath = null;
	protected String mode = null;

	protected Action addTask, addCPU;
			

	protected static final DecimalFormat nf = new DecimalFormat(); //"##0.#####E0");
	protected static final DecimalFormat nf2 = new DecimalFormat("##0.#####E0");
	
	static {
		nf.setMaximumFractionDigits(5);
		nf2.setMaximumFractionDigits(4);
		
		DecimalFormatSymbols dfs = nf.getDecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		nf.setDecimalFormatSymbols(dfs);
		
		DecimalFormatSymbols dfs2 = nf.getDecimalFormatSymbols();
		dfs2.setDecimalSeparator('.');
		nf2.setDecimalFormatSymbols(dfs2);
		//    	nf2.getDecimalFormatSymbols().setDecimalSeparator('.');

	}
	
	
	/**
	 * This listens for when the outline becomes active
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IPartListener partListener =
		new IPartListener() {
			public void partActivated(IWorkbenchPart p) {
				if (p instanceof IVarTreeProvider && p instanceof IEditorPart) {
					IVarTree vt = ((IVarTreeProvider) p).getVarTree();
					setVarTree(vt, (String) vt.getProperties().get("LastMode"));
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

	
	
	
	private boolean packColumns = false;

    /**
     * The constructor.
     */
    public RtdruidTableView() {
    }
    
    /**
     * This is a callback that will allow us to create the viewer and initialize
     * it.
     */
    protected void doCreatePartControl() {
    	
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 1;
			layout.verticalSpacing = 12;
			rootComposite.setLayout(layout);
		}

		//  ------------------------------ ROW 1 ------------------------------ 
		{
			Composite row_1 = new Composite(rootComposite, SWT.LEFT);
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				row_1.setLayoutData(data);

				
				GridLayout layout = new GridLayout();
				layout.numColumns = 5;
				layout.verticalSpacing = 12;
				row_1.setLayout(layout);
			}
		

			{
				Label containerLabel = new Label(row_1, SWT.LEFT);
				containerLabel.setText("Mode");

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				containerLabel.setLayoutData(data);
			}
			
			// MODE
			modeText = new Combo(row_1, SWT.READ_ONLY | SWT.DROP_DOWN);
			{
				modeText.addSelectionListener( new SelectionListener() {
			        public void widgetDefaultSelected(SelectionEvent e) { perform(e); }
			        public void widgetSelected(SelectionEvent e) { perform(e); }
			        
			        private void perform(SelectionEvent e) {
			        	if (e.getSource() == modeText) {
			            	mode = modeText.getSelectionIndex() == 0 ? null : modeText.getText();
			    			if (mode == null) {
			    				vt.getProperties().remove("LastMode");
			    			} else {
			    				vt.getProperties().put("LastMode", mode);
			    			}
			            } else {
			                return;
			            }
			            
			        	// change table values
			            fillTable();
			        }
			    });

				
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.minimumWidth = 150;
//				data.grabExcessHorizontalSpace = true;
				modeText.setLayoutData(data);
			}
			{
				Label containerLabel = new Label(row_1, SWT.LEFT);
				//containerLabel.setText("void space");

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				containerLabel.setLayoutData(data);
			}


			final String[] analysisTitles = new String[] {
					"Select an analysis",
					"Analysis without offsets (FP)",
					"Exact Analysis with offset (FP)",
					"Sufficient analysis with offset (FP)",
					"Stack Size",
					"MultiFrame Task analysis (FP)",
					"Proc Responsetime analysis (FP)",
					"Cache Miss Cost analysis (FP)",};
			final int[] analysisIds = new int[] {
					-1,
					JScan.NO_OFFSET_ID,
					JScan.EXACT_FP_ID,
    				JScan.FLEASIBLE_RT_ID,
					JScan.STACK_SIZE,
					JScan.MULTIFRAME_FP_ID,
					JScan.PROC_SCHED_MULTIFRAME_FP_ID,
					JScan.CACHE_COST_FP_ID,
					
			};
			boolean abc = true;
			if (abc) {
			final Combo analysisSelector = new Combo(row_1, SWT.DROP_DOWN | SWT.READ_ONLY);
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				analysisSelector.setLayoutData(data);

				for (String title: analysisTitles) {
					analysisSelector.add(title);
				}
				
				analysisSelector.select(0);

			}
			//Fleasible
			final Button runAnalysis = createButton(row_1, "Run analysis");

			
		    SelectionListener comonListner = new SelectionListener() {
		    	
		    	class SchedulabilityAnalysisOperation extends WorkspaceModifyOperation {
		    		
		    		//protected VarTree vt;
		    		protected String sys;
		    		protected int analysis;
		    		protected Properties properties;
		    		
		    		public SchedulabilityAnalysisOperation(IVarTree vt, String systemPath, int analysisId, Properties prop) {
		    			//this.vt = vt;
		    			this.sys = systemPath;
		    			this.analysis = analysisId;
		    			this.properties = prop;
		    			RtdruidLog.showDebug("Run sched");
		    		}
		    		
		    		// This is the method that gets invoked when the operation runs.
		    		//
		    		public void execute(IProgressMonitor monitor) {
		    			RtdruidLog.showDebug("exec sched");
		    			try {
		    				Messages.clearNumbers();
			    			monitor.beginTask("Schedulability analysis", 102);
		
			    			// prepare to compute
							// check all references
			    			(new CheckReferences(vt, sys)).checkAll();
			    			if (Messages.getErrorNumber() > 0 || Messages.getWarningNumber() > 0) {
			    			   // return;
			    			}
			    			monitor.worked(1);
		
			    			IProgressMonitorWatcher watcher = new IProgressMonitorWatcher(Thread.currentThread(), monitor, vt );
			    			String report = null;
			    			try {
				    			(new Thread(watcher)).start();
					            // compute
				    			System.err.println("Start  " + System.currentTimeMillis());
								report = JScan.startTest(vt, sys, analysis, properties, watcher);
								System.err.println("end " + System.currentTimeMillis());
								watcher.end();
			    			} catch (ThreadDeath e) {
			    				RtdruidLog.showDebug(e);
			    				// if report contains something is too late to stop computation
			    				// else return and end this thread
			    				if (report == null) {
			    					return;
			    				}
			    			} catch (Throwable e) {
			    				RtdruidLog.log(e);
			    			}
		
							monitor.worked(1);
							
							// Output
							if (report != null) {
								Messages.sendText(report);
							}
		    			} catch (Throwable e) {
		    				RtdruidLog.showDebug(e);
		    			} finally {
		    				monitor.done();
		    			}
		    		}
		    	}
		    	
		    	
			    private int F = 1;
			    private boolean computeCDelta = false;
	
			    public void widgetDefaultSelected(SelectionEvent e) {
		            perform(e);
		        }
		        public void widgetSelected(SelectionEvent e) {
		            perform(e);
		        }
		        
		        private void perform(SelectionEvent e) {
	
		        	// exit if there isn't any tree
		        	if (vt == null) {
						return;
					}
		        	
		        	// before compute, store old values
					storeValue();
					deactivateCellEditor();
		        	
					Properties options = new Properties();
					if (mode != null) {
						options.setProperty(JScan.MODE_STR, mode);
					}
		        	
					
					int index = analysisSelector.getSelectionIndex();
					if (index <1) {
						MessageDialog.openInformation(getSite().getShell(), "Warning", "Select an analysis to run");
						return;
					}
					
					
					int currAnalysis = analysisIds[index];
		            if (currAnalysis == JScan.FLEASIBLE_RT_ID) {
	
		            	class MyInputDialog extends InputDialog {
		            		
		            		public MyInputDialog(Shell parentShell,
		                            String dialogTitle,
					                   String dialogMessage,
					                   String initialValue,
					                   IInputValidator validator) {
		            			super(parentShell, dialogTitle, dialogMessage, initialValue, validator);
		            		}
	    			    	
	
		            		/**
		            		 * Add the check button to default layout (enable/disable CDelta computation)
		            		 */
	    			    	protected Control createDialogArea(Composite parent) {
	    						Composite composite = (Composite) super.createDialogArea(parent);
	    						
	        			    	//add controls to composite as necessary
	    						Button enableCDeltaChk = new Button(composite, SWT.CHECK);
	    						{
	    						    enableCDeltaChk.setText("Enable CDelta computation");
	    						    enableCDeltaChk.setSelection(computeCDelta);
	    						    enableCDeltaChk.addSelectionListener(new SelectionListener() {
	    						        public void widgetDefaultSelected(SelectionEvent e) { perform(e); }
	    						        public void widgetSelected(SelectionEvent e) { perform(e); }
	    						        
	    						        private void perform(SelectionEvent e) {
	    						        	computeCDelta = !computeCDelta;
	    						        }
	    							    
	    							});
	
	    							GridData data = new GridData();
	    							data.horizontalAlignment = GridData.FILL;
	    							data.horizontalIndent = 20;
	    							enableCDeltaChk.setLayoutData(data);
	    						}
	
	        			    	return composite;
	    			    	}
	    			    	
	//    			    	public boolean getEnableCDelta() {
	//   			    		return computeCDelta;
	//    			    	}
	    			    };
	    			    
	    			    MyInputDialog inputF = new MyInputDialog(
	    			    		getSite().getShell(),
	    			            "Fleasible analysis",
	    			            "Number of fixed task :",
	    			            "" + F,
	    			            new IInputValidator() {
	    			                public String isValid(String newText) {
	    			    				// check (step 1)
	    			    				int i = -1;
	    			    				try {
	    			    					i = Integer.parseInt(newText);
	    			    				} catch (NumberFormatException exception) {
	    			    				}
	    			    				// check (step 2)
	    			    				int nTask = Integer.MAX_VALUE;
	    			    				if (tasks == null) {
	    			    					nTask = 0;
	    			    				} else {
	    			    					for (int l=1; l<tasks.getPrefixNumber(); l++ ) {
	    			    						nTask = Math.min(nTask, tasks.getSize(l));
	    			    					}
	    			    				}
	    			    				if ( i < 1 || i >= nTask) {
	    			    					return "F must be an integer greater than 0 and littler than number of task ("
	    			    							+ nTask + ")" ;
	    			    				}
	    			    				return null;
	    			                }
	    			            }
	    			    );
	
	    			    if (inputF.open() != IDialogConstants.OK_ID) {
	    			        return;
	    			    }
	    			    
	    			    F = Integer.parseInt(inputF.getValue());
	    				options.setProperty(JScan.F_STR, "" + F);
	    				options.setProperty(JScan.CDELTA_COMPUTATION_STR, "" + computeCDelta);
		            }
					
	
					boolean output = false;
					
					{
						RTDConsole view = null;
						try {
							view = RTDConsole.getConsole();
							if (view != null) {
								Messages.setCurrent(view.getMessages());
								output = true;
							}
						} catch (Exception exception) {
						    RtdruidLog.log(exception);
						}
					}
	
					
					// Do the work within an operation because this is a long running activity that modifies the workbench.
					//
					WorkspaceModifyOperation operation;
					try {

					operation = new SchedulabilityAnalysisOperation(
							vt, getSystemPath(), currAnalysis, options);
					} catch (Throwable itexception) {
						RtdruidLog.log(itexception);
						return;
					}
	
					try {
						// This runs the options, and shows progress.
						//
						new ProgressMonitorDialog(getSite().getShell()).run(true, true, operation);
	
						// after work refresh graphics
						fillTable();
					} catch (InvocationTargetException itexception) {
						if (itexception.getTargetException() instanceof ValueNotFoundException) {
							if (!output) {
								RTDConsole view = null;
								try {
									view = RTDConsole.getConsole();
									if (view != null) {
										Messages.setCurrent(view.getMessages());
										output = true;
									}
								} catch (Exception exception) {
								    RtdruidLog.log(exception);
								}
							}
							Messages.sendError(itexception.getTargetException().getMessage(), null, null, new Properties());
						}
	
					} catch (Exception exception) {
						// Something went wrong that shouldn't.
						//
					    RtdruidLog.log(exception);
						
					} finally { // restore output
						if (output) {
							Messages.setPrevious();
						}
					}
					
		        }
		    };

		    runAnalysis.addSelectionListener(comonListner);
			}
		}
			

		//	  ------------------------------ ROW 2 ------------------------------ 
		
		// TABLE OF PROPERTIES
		//
		prioritiesTableTree = new Tree(rootComposite, SWT.FULL_SELECTION | SWT.SINGLE | SWT.BORDER | SWT.HIDE_SELECTION);
		{
			{
				Tree pt = prioritiesTableTree;
				for (int i=0; i<columns.length; i++) {
				    TreeColumn a = new TreeColumn(pt, SWT.LEFT);
					a.setWidth(100);
				    a.setText((String) columns[i][0]);
				}
			    
				pt.setLinesVisible(true);
				pt.setHeaderVisible(true);
			}

			
			editor = new TreeEditor(prioritiesTableTree);//new ValidatorTableEditor(properties); 
//			//The editor must have the same size as the cell
			editor.horizontalAlignment = SWT.LEFT;
			editor.grabHorizontal = true;
			
			prioritiesTableTree.addMouseListener(new MouseAdapter() {

				public void mouseDown(MouseEvent e) {

					// store the previous value, if one and without errors
					storeValue();

					// remove current editor
					deactivateCellEditor();

					// Identify the selected row
					// exit if the item is null or 
					// if the item is a rtos row
					TreeItem item = prioritiesTableTree.getItem(new Point(e.x, e.y));
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
					if (!(item.getData() != null && item.getData() instanceof int[])) {
						return;
					}
						
					for (int i=0; i<prioritiesTableTree.getColumnCount(); i++) {
//						System.err.println("\tcolonna " + i + " - " + prioritiesTableTree.getTable().getColumn(i).getText() + " : " +item.getBounds(i).toString() + " - " + item.getText(i));
						if (item.getBounds(i).contains(e.x, e.y)) {
//							System.err.println("\te' la colonna " + i + " - " + prioritiesTableTree.getTable().getColumn(i).getText());\
							currentColumn = columns[i][2] != null ? i : -1;
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

		    GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.verticalAlignment = GridData.FILL;
			//data.horizontalSpan = 4;
			//data.verticalSpan = 5;
			data.grabExcessVerticalSpace = true;
			data.grabExcessHorizontalSpace = true;
			prioritiesTableTree.setLayoutData(data);
		}

//		//	  ------------------------------ ROW 3 ------------------------------ 
//		
//		// replaced 
//		if (false ){
//			Composite row_3 = new Composite(rootComposite, SWT.LEFT);
//			{
//				GridLayout layout = new GridLayout();
//				layout.numColumns = 4;
//				layout.verticalSpacing = 12;
//				layout.makeColumnsEqualWidth = true;
//				row_3.setLayout(layout);
//			}
//	
//			final Combo analysisSelector = new Combo(row_3, SWT.DROP_DOWN | SWT.READ_ONLY);
//			
//		    // without offsets
//			final Button whitoutOffsetsButton = createButton(row_3, "Analysis without offsets (FP)");
//		    
//		    // Exact
//			final Button excatButton = createButton(row_3, "Exact Analysis with offset (FP)");
//		    
//		    // Fleasible
//			final Button fleasible = createButton(row_3, "sufficient analysis with offset (FP)");
//			
//			//Fleasible
//			final Button stackSize = createButton(row_3, "Stack Size");
//	
//		    SelectionListener comonListner = new SelectionListener() {
//		    	
//		    	class SchedulabilityAnalysisOperation extends WorkspaceModifyOperation {
//		    		
//		    		//protected VarTree vt;
//		    		protected String sys;
//		    		protected int analysis;
//		    		protected Properties properties;
//		    		
//		    		public SchedulabilityAnalysisOperation(IVarTree vt, String systemPath, int analysisId, Properties prop) {
//		    			//this.vt = vt;
//		    			this.sys = systemPath;
//		    			this.analysis = analysisId;
//		    			this.properties = prop;
//		    			RtdruidLog.showDebug("Run sched");
//		    		}
//		    		
//		    		// This is the method that gets invoked when the operation runs.
//		    		//
//		    		public void execute(IProgressMonitor monitor) {
//		    			RtdruidLog.showDebug("exec sched");
//		    			try {
//		    				Messages.clearNumbers();
//			    			monitor.beginTask("Schedulability analysis", 102);
//		
//			    			// prepare to compute
//							// check all references
//			    			(new CheckReferences(vt, sys)).checkAll();
//			    			if (Messages.getErrorNumber() > 0 || Messages.getWarningNumber() > 0) {
//			    			    return;
//			    			}
//			    			monitor.worked(1);
//		
//			    			IProgressMonitorWatcher watcher = new IProgressMonitorWatcher(Thread.currentThread(), monitor, vt );
//			    			String report = null;
//			    			try {
//				    			(new Thread(watcher)).start();
//					            // compute
//				    			System.err.println("Start  " + System.currentTimeMillis());
//								report = JScan.startTest(vt, sys, analysis, properties, watcher);
//								System.err.println("end " + System.currentTimeMillis());
//								watcher.end();
//			    			} catch (ThreadDeath e) {
//			    				RtdruidLog.showDebug(e);
//			    				// if report contains something is too late to stop computation
//			    				// else return and end this thread
//			    				if (report == null) {
//			    					return;
//			    				}
//			    			} catch (Throwable e) {
//			    				RtdruidLog.log(e);
//			    			}
//		
//							monitor.worked(1);
//							
//							// Output
//							if (report != null) {
//								Messages.sendText(report);
//							}
//		    			} catch (Throwable e) {
//		    				RtdruidLog.showDebug(e);
//		    			} finally {
//		    				monitor.done();
//		    			}
//		    		}
//		    	}
//		    	
//		    	
//			    private int F = 1;
//			    private boolean computeCDelta = false;
//	
//			    public void widgetDefaultSelected(SelectionEvent e) {
//		            perform(e);
//		        }
//		        public void widgetSelected(SelectionEvent e) {
//		            perform(e);
//		        }
//		        
//		        private void perform(SelectionEvent e) {
//	
//		        	// exit if there isn't any tree
//		        	if (vt == null) {
//						return;
//					}
//		        	
//		        	// before compute, store old values
//					storeValue();
//					deactivateCellEditor();
//		        	
//					Properties options = new Properties();
//					if (mode != null) {
//						options.setProperty(JScan.MODE_STR, mode);
//					}
//		        	
//					int currAnalysis;
//					if (e.getSource() == stackSize) {
//		            	currAnalysis = JScan.STACK_SIZE;
//		            }
//		            else if (e.getSource() == whitoutOffsetsButton) {
//		            	currAnalysis = JScan.NO_OFFSET_ID;
//		            } else if (e.getSource() == excatButton) {
//		            	currAnalysis = JScan.EXACT_FP_ID;
//		            } else if (e.getSource() == fleasible) {
//	
//		            	class MyInputDialog extends InputDialog {
//		            		
//		            		public MyInputDialog(Shell parentShell,
//		                            String dialogTitle,
//					                   String dialogMessage,
//					                   String initialValue,
//					                   IInputValidator validator) {
//		            			super(parentShell, dialogTitle, dialogMessage, initialValue, validator);
//		            		}
//	    			    	
//	
//		            		/**
//		            		 * Add the check button to default layout (enable/disable CDelta computation)
//		            		 */
//	    			    	protected Control createDialogArea(Composite parent) {
//	    						Composite composite = (Composite) super.createDialogArea(parent);
//	    						
//	        			    	//add controls to composite as necessary
//	    						Button enableCDeltaChk = new Button(composite, SWT.CHECK);
//	    						{
//	    						    enableCDeltaChk.setText("Enable CDelta computation");
//	    						    enableCDeltaChk.setSelection(computeCDelta);
//	    						    enableCDeltaChk.addSelectionListener(new SelectionListener() {
//	    						        public void widgetDefaultSelected(SelectionEvent e) { perform(e); }
//	    						        public void widgetSelected(SelectionEvent e) { perform(e); }
//	    						        
//	    						        private void perform(SelectionEvent e) {
//	    						        	computeCDelta = !computeCDelta;
//	    						        }
//	    							    
//	    							});
//	
//	    							GridData data = new GridData();
//	    							data.horizontalAlignment = GridData.FILL;
//	    							data.horizontalIndent = 20;
//	    							enableCDeltaChk.setLayoutData(data);
//	    						}
//	
//	        			    	return composite;
//	    			    	}
//	    			    	
//	//    			    	public boolean getEnableCDelta() {
//	//   			    		return computeCDelta;
//	//    			    	}
//	    			    };
//	    			    
//	    			    MyInputDialog inputF = new MyInputDialog(
//	    			    		getSite().getShell(),
//	    			            "Fleasible analysis",
//	    			            "Number of fixed task :",
//	    			            "" + F,
//	    			            new IInputValidator() {
//	    			                public String isValid(String newText) {
//	    			    				// check (step 1)
//	    			    				int i = -1;
//	    			    				try {
//	    			    					i = Integer.parseInt(newText);
//	    			    				} catch (NumberFormatException exception) {
//	    			    				}
//	    			    				// check (step 2)
//	    			    				int nTask = Integer.MAX_VALUE;
//	    			    				if (tasks == null) {
//	    			    					nTask = 0;
//	    			    				} else {
//	    			    					for (int l=1; l<tasks.getPrefixNumber(); l++ ) {
//	    			    						nTask = Math.min(nTask, tasks.getSize(l));
//	    			    					}
//	    			    				}
//	    			    				if ( i < 1 || i >= nTask) {
//	    			    					return "F must be an integer greater than 0 and littler than number of task ("
//	    			    							+ nTask + ")" ;
//	    			    				}
//	    			    				return null;
//	    			                }
//	    			            }
//	    			    );
//	
//	    			    if (inputF.open() != IDialogConstants.OK_ID) {
//	    			        return;
//	    			    }
//	    			    
//	    			    F = Integer.parseInt(inputF.getValue());
//	    				options.setProperty(JScan.F_STR, "" + F);
//	    				options.setProperty(JScan.CDELTA_COMPUTATION_STR, "" + computeCDelta);
//	    				
//	    				currAnalysis = JScan.FLEASIBLE_RT_ID;
//	
//		            } else {
//		            	return;
//		            }
//					
//	
//					boolean output = false;
//					
//					{
//						RTDConsole view = null;
//						try {
//							view = RTDConsole.getConsole();
//							if (view != null) {
//								Messages.setCurrent(view.getMessages());
//								output = true;
//							}
//						} catch (Exception exception) {
//						    RtdruidLog.log(exception);
//						}
//					}
//	
//					
//					// Do the work within an operation because this is a long running activity that modifies the workbench.
//					//
//					WorkspaceModifyOperation operation;
//					try {
//
//					operation = new SchedulabilityAnalysisOperation(
//							vt, getSystemPath(), currAnalysis, options);
//					} catch (Throwable itexception) {
//						RtdruidLog.log(itexception);
//						return;
//					}
//	
//					try {
//						// This runs the options, and shows progress.
//						//
//						new ProgressMonitorDialog(getSite().getShell()).run(true, true, operation);
//	
//						// after work refresh graphics
//						fillTable();
//					} catch (InvocationTargetException itexception) {
//						if (itexception.getTargetException() instanceof ValueNotFoundException) {
//							if (!output) {
//								RTDConsole view = null;
//								try {
//									view = RTDConsole.getConsole();
//									if (view != null) {
//										Messages.setCurrent(view.getMessages());
//										output = true;
//									}
//								} catch (Exception exception) {
//								    RtdruidLog.log(exception);
//								}
//							}
//							Messages.sendError(itexception.getTargetException().getMessage(), null, null, new Properties());
//						}
//	
//					} catch (Exception exception) {
//						// Something went wrong that shouldn't.
//						//
//					    RtdruidLog.log(exception);
//						
//					} finally { // restore output
//						if (output) {
//							Messages.setPrevious();
//						}
//					}
//					
//		        }
//		    };
//		    whitoutOffsetsButton.addSelectionListener( comonListner );
//		    excatButton.addSelectionListener( comonListner );
//		    fleasible.addSelectionListener( comonListner );
//		    stackSize.addSelectionListener( comonListner );
//		}
    	
		//  	hookContextMenu();
		//    contributeToActionBars();
		createActions();
		createMenu();
        createToolbar();
        createContextMenu();
		
	}

    private void createActions(){
    	addTask = new AddTaskAction("Add Task", this);
    	addTask.setImageDescriptor(getImageDescriptor("full/obj16/AddTask.gif"));
    	
    	addCPU = new AddCPUAction("Add CPU", this);
    	addCPU.setImageDescriptor(getImageDescriptor("full/obj16/AddCPU.gif"));
    }
    
    /**
     * Create menu.
     */
    private void createMenu() {
            IMenuManager mgr = getViewSite().getActionBars().getMenuManager();
            mgr.add(addCPU);
            mgr.add(addTask);
    }
    
    /**
     * Create toolbar.
     */
    private void createToolbar() {
            IToolBarManager mgr = getViewSite().getActionBars().getToolBarManager();
            mgr.add(addCPU);
            mgr.add(addTask);
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
        Menu menu = menuMgr.createContextMenu(prioritiesTableTree);
        prioritiesTableTree.setMenu(menu);
        
        // Register menu for extension.
        //getSite().registerContextMenu(menuMgr, prioritiesTableTree);
    }
    
    private void fillContextMenu(IMenuManager mgr) {
        mgr.add(addCPU);
        mgr.add(addTask);
        mgr.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));        
    }
    
    /**
     * Returns the image descriptor with the given relative path.
     */
    private ImageDescriptor getImageDescriptor(String relativePath) {
            String iconPath = "icons/";
            try {
                    Rtd_jscan_uiPlugin plugin = Rtd_jscan_uiPlugin.getDefault();
                    URL installURL = plugin.getBundle().getEntry("/");
                    URL url = new URL(installURL, iconPath + relativePath);
                    return ImageDescriptor.createFromURL(url);
            }
            catch (MalformedURLException e) {
                    // should not happen
                    return ImageDescriptor.getMissingImageDescriptor();
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
    	
		Control newEditor;
		if (INTEGER_EDITOR.equalsIgnoreCase((String) columns[currentColumn][2])) { // integer editor
			newEditor = new Text(prioritiesTableTree, SWT.NONE);
			((Text) newEditor).setText(currentItem.getText(currentColumn));
			((Text) newEditor).addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					// clear all
					errMesg = null;

					newValue = ((Text) editor.getEditor()).getText();
					
					// check (step 1)
					if (!"".equals(newValue)) {
						boolean ok = true;
						try {
							Integer.parseInt(newValue);
						} catch (NumberFormatException exception) {
							ok = false;
						}
						// check (step 2)
						if ( !ok ) {
							errMesg = "The " +  (String) columns[currentColumn][0]
								+ editor.getItem().getText(1)
								+ " must be an integer";
							newValue = null;
						}
					}

					// before end, check for OK button
					enableOk();
				}
			});
			((Text) newEditor).selectAll();
			
		} else if (TIME_EDITOR.equalsIgnoreCase((String) columns[currentColumn][2])) { // time editor
			newEditor = new Text(prioritiesTableTree, SWT.NONE);
			((Text) newEditor).setText(currentItem.getText(currentColumn));
			((Text) newEditor).addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					// clear all
					errMesg = null;

					newValue = ((Text) editor.getEditor()).getText();
					
					// check (step 1)
					if (!"".equals(newValue)) {
						boolean ok = true;
						try {
							new TimeVar(newValue);
						} catch (NumberFormatException exception) {
							ok = false;
						}
						// check (step 2)
						if ( !ok ) {
							errMesg = "The " +  (String) columns[currentColumn][0]
								+ editor.getItem().getText(1)
								+ " must be an time (double + timeUnit)";

							newValue = null;
						}
					}

					// before end, check for OK button
					enableOk();
				}
			});
			((Text) newEditor).selectAll();

		} else { // text editor
			newEditor = new Text(prioritiesTableTree, SWT.NONE);
			((Text) newEditor).setText(currentItem.getText(currentColumn));
			((Text) newEditor).addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					// clear all
					errMesg = null;

					newValue = ((Text) editor.getEditor()).getText();

					// before end, check for OK button
					enableOk();
				}
			});
			((Text) newEditor).selectAll();

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
    		|| editor == null
    		|| editor.getEditor() == null	// first time
			|| newValue == null) {		// no changes
    		return;
    	}
    	
		// store / reset value
    	String oldValue = editor.getItem().getText(currentColumn);
		editor.getItem().setText(currentColumn, newValue);


		// store data in VarTree
		int[] pos =  (int[]) editor.getItem().getData();
		
		// set all values for a new Activation element
		if ("wcet".equalsIgnoreCase((String) columns[currentColumn][1])) {
			
			/*
			 * Check if the wcet is computed.
			 * if Yes, ask to the user to choose the new values of 
			 *        proc's wcet, in order to achieve the required wcet
			 * if No, use the common procedure to store the value  
			 */
			Task t = (Task) tasks.getItem(pos[0], pos[1]);
			if (t.isWcet_is_computed()) {
			
				WcetCommon wcetManager = new WcetCommon(vt);

				
				String[] procNames = (new Mapping(vt, tasks.getSystem(), tasks.getMode()))
						.taskToProc(Utility.pathToEvidence(DataPath.addSlash(t.getName())));
				if (procNames.length == 0) {
					
					RtdruidLog.showDebug(new RuntimeException("task's wcet computed on 0 procs"));
				} else if (procNames.length == 1) {
					
					String procPath = Search.aProc(vt.newTreeInterface(), systemPath, procNames[0]);
					if (procPath != null) {
						// just update the proc's wcet
						wcetManager.setProcWcet(procPath, procNames[0], new TimeVar(newValue));
					}
					
				} else {
					 
					
					// first search all procs ... (procNames)
					ArrayList<ProcWcet> orig_values = new ArrayList<ProcWcet>(procNames.length);
					
					for (int i = 0; i < procNames.length; i++) {
						// ... for each search all used method ...
						String procPath = Search.aProc(vt.newTreeInterface(), systemPath, procNames[i]);
						if (procPath == null) {
							continue; // next proc
						}
		
						TimeVar var = wcetManager.getProcWcet(procPath, procNames[i]);
						
						if (var != null) {
							var.setType(TimeVar.MILLI_SECOND);
						}
						orig_values.add(new ProcWcet(procNames[i], procPath, var));

					}
					
try {
					
					TaskProcWcetDialog dialog = new TaskProcWcetDialog(getViewSite().getShell(), orig_values, new TimeVar(newValue));
					int result = dialog.open();
					
					if (result ==  Dialog.OK) {
						
						// store the new values
						ArrayList<ProcWcet> new_values = dialog.getValues();						
						
						for (ProcWcet proc : new_values) {
							// ... for each search all used method ...
							if (proc.procPath == null) {
								continue; // next proc
							}
			
							wcetManager.setProcWcet(proc.procPath, proc.procName, proc.wcet);
						}

						{ // update the graphic : reload the property and try to format it
							t.load("wcet", false);
							
							String txt;
					    	Object obj = t.getProperty((String) "wcet");
					    	if (obj instanceof Double) {
					    		txt = formatTimes((Double) obj);
					    	} else {
					    		txt = ""+ obj;
					    	}
					    	editor.getItem().setText(currentColumn, txt);
						}
						
					} else {
						// Undone the update of item
						editor.getItem().setText(currentColumn, oldValue);
					}
}catch (Exception e) { e.printStackTrace(); }				
				}

			} else {
				
				tasks.getItem(pos[0], pos[1]).setProperty(
						(String) columns[currentColumn][1], newValue);
			}
			
		} else if ("period".equalsIgnoreCase((String) columns[currentColumn][1]) 
			|| "deadline".equalsIgnoreCase((String) columns[currentColumn][1])
			|| "offset".equalsIgnoreCase((String) columns[currentColumn][1])
			|| "stack".equalsIgnoreCase((String) columns[currentColumn][1])) {
		
			vt.beginTransaction().setLabel("Set");
			try {
				String type =(String) tasks.getItem(pos[0], pos[1]).getProperty(Task.STR_ACT_TYPE);
				String period   = ""+ tasks.getItem(pos[0], pos[1]).getProperty("period");
				String deadline = ""+ tasks.getItem(pos[0], pos[1]).getProperty("deadline");
				String offset   = ""+ tasks.getItem(pos[0], pos[1]).getProperty("offset");
				String stack   = ""+ tasks.getItem(pos[0], pos[1]).getProperty("stack");
				
				// set the old values
				tasks.getItem(pos[0], pos[1]).setProperty(Task.STR_ACT_TYPE, type);
				tasks.getItem(pos[0], pos[1]).setProperty("period", period);
				tasks.getItem(pos[0], pos[1]).setProperty("deadline", deadline);
				tasks.getItem(pos[0], pos[1]).setProperty("offset", offset);
				tasks.getItem(pos[0], pos[1]).setProperty("stack", stack);
	
				// set the new values
				tasks.getItem(pos[0], pos[1]).setProperty(
						(String) columns[currentColumn][1], newValue);
			} catch (RuntimeException e) {
				vt.rollbackTransaction();
				throw e;
			} finally {
				vt.commitTransaction();
			}
			
		} else {
			tasks.getItem(pos[0], pos[1]).setProperty(
					(String) columns[currentColumn][1], newValue);
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
		Control oldEditor = editor == null ? null : editor.getEditor();
		if (oldEditor != null) {
			oldEditor.dispose();
		}
    }

 /*   private void hookContextMenu() {
        MenuManager menuMgr = new MenuManager("#PopupMenu");
        menuMgr.setRemoveAllWhenShown(true);
        menuMgr.addMenuListener(new IMenuListener() {
            public void menuAboutToShow(IMenuManager manager) {
                RtdruidTableView.this.fillContextMenu(manager);
            }
        });
        Menu menu = menuMgr.createContextMenu(rootComposite.getControl());
        rootComposite.getControl().setMenu(menu);
        getSite().registerContextMenu(menuMgr, rootComposite);
    }

    private void contributeToActionBars() {
        IActionBars bars = getViewSite().getActionBars();
        fillLocalPullDown(bars.getMenuManager());
        fillLocalToolBar(bars.getToolBarManager());
    }

    private void fillLocalPullDown(IMenuManager manager) {
        //		manager.add(new Separator());
        manager.add(clear);
    }

    private void fillContextMenu(IMenuManager manager) {
        manager.add(clear);
        // Other plug-ins can contribute there actions here
        //manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
    }

    private void fillLocalToolBar(IToolBarManager manager) {
        manager.add(clear);
    }

	/**
	 * enable / disable the "next" button and show some "Error messages"
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
	public void doSetVarTree(String newMode) {

		packColumns = vt != null;


		mode = newMode;
		systemPath = null;
		
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
		fillCombo();
		fillTable();
		
		if (addCPU != null) addCPU.setEnabled(vt != null);
		if (addTask != null) addTask.setEnabled(vt != null);
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
	 * fill "mode" combo
	 */
	protected void fillCombo() {
		modeText.removeAll();
		modeText.setText("");
		
		String system = getSystemPath();
		if (system == null) {
			modeText.setEnabled(false);
			return;
		}
		char S = DataPath.SEPARATOR;
		String[] modes = (vt.newTreeInterface()).getAllName( S+system 
				+ S + "Modes" +S+ "ModeList", "Mode" );

		modeText.add("-- default mode --");
		for (int i=0; i<modes.length; i++) {
			String tmpMode = DataPath.removeSlash(DataPath.removeSlash(modes[i]));
			if (tmpMode != null) {
				modeText.add(tmpMode);
			}
		}
		
		{ // select current mode
			int index = 0;
			if (mode != null) {
				String tmpMode = mode;
				mode = null;

				String[] items = modeText.getItems(); 
				for (int i=0; i<items.length; i++) {
					if (tmpMode.equals(items[i])) {
						index = i;
						mode = tmpMode;
						break;
					}
				}
				
			}
			modeText.select(index);
		}
		
		modeText.setEnabled(modeText.getItemCount() > 1);

	}
	/**
	 * take all priorities from a task set and put them into the table
	 *
	 */
    protected void fillTable() {
    	prioritiesTableTree.setRedraw(false);
    	try {
    		// 0. save old values and dispose old editor
			storeValue();
			deactivateCellEditor();
    		
	    	// 1. clear old table
	        prioritiesTableTree.removeAll();
	
	        // 2. get system and make a new TaskSet
			String system = getSystemPath();
			
			if (system == null) {	
				tasks = null;
				return;
			}
		
			tasks = new TaskSet(vt, system, mode, true);
			tasks.setSave(true);
	
			for (int i=0; i<taskP.length; i++) {
				tasks.setProperty(taskP[i][0],taskP[i][1],false);
			}
			tasks.onlyPeriodicTasks();
	
	        
			// 3. fill the table
		    
		    // add all items
		    for (int i=1; i<tasks.getPrefixNumber(); i++) {
		    	TreeItem tti = new TreeItem(prioritiesTableTree, SWT.NONE);
		    	tti.setText(0, tasks.getPrefix(i));
		    	tti.setText(STACK_COL, tasks.getStackSize(i));
		    	
		    	for (int j=0; j<tasks.getSize(i); j++) {
		    		Task t = (Task) tasks.getItem(i,j);
		    		
				    TreeItem ti = new TreeItem(tti, SWT.NONE);
				    ti.setText(1, t.getName());
				    for (int cc=2; cc<columns.length; cc++) {
				    	
				    	String txt;
				    	
				    	Object obj = t.getProperty((String) columns[cc][1]);
				    	if (obj instanceof Double) {
				    		txt = formatTimes((Double) obj);
				    	} else {
				    		txt = ""+ t.getProperty((String) columns[cc][1]);
				    	}
				    	ti.setText(cc, txt);
				    		
				    }
	
				    ti.setData(new int[] {i,j});
		    	}
		    	tti.setExpanded(true);
		    }
		    
		    // resize all columns
		    if (packColumns) {
			    TreeColumn[] columns = prioritiesTableTree.getColumns();
				for (int i = 0; i < columns.length; i++) {
					columns[i].pack();
				}
				packColumns = false;
			}
			
			{ // clear the previous cell
				Control oldEditor = editor == null ? null : editor.getEditor();
				if (oldEditor != null) oldEditor.dispose();
			}

			
			System.out.println(" ---- PROCS -----");
			String[] names = Search.allProcs(vt);
			ArrayList<String> anames = new ArrayList<String>(Arrays.asList(names));
			Collections.sort(anames);
			for(String s: anames) {
				System.out.println(s);
			}
			System.out.println(" ---- ENDPROCS -----");
			
			
    	} catch (Throwable e) {
    		RtdruidLog.log(e);
    	} finally {
        	prioritiesTableTree.setRedraw(true);
    	}
    }

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

	protected void doUpdateVarTree() {
	  		systemPath = null; // refresh also the system name
	  		
		  	fillCombo();
			fillTable();
	  	};

  	public IVarTree getVarTree() {
  		return vt;
  	}

  	
  	static String formatTimes(Double obj) {
  		String txt = null;
  		if (obj != null) {
	  		
	  		double val = ((Double) obj).doubleValue();
			if ( (val >1e-10 && val <1e-4) || (-val >1e-10 && -val <1e-4)) {
				txt = "" + nf2.format(val);
			} else {
				txt = "" + nf.format(val);
			}
  		}
  		
  		return txt;
  	}
}
