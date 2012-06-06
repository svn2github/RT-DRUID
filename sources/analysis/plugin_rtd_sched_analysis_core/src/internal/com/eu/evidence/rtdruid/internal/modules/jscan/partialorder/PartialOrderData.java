package com.eu.evidence.rtdruid.internal.modules.jscan.partialorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenRes;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Task;
import com.eu.evidence.rtdruid.vartree.abstractions.old.TaskSet;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.tools.Mapping;
import com.eu.evidence.rtdruid.vartree.tools.Search;
import com.eu.evidence.rtdruid.vartree.tools.Utility;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

public class PartialOrderData {

	private final static String FIRST_EVENT_NAME = DataPackage.eINSTANCE.getOrder_FirstEvent().getName();
	private final static String SECOND_EVENT_NAME = DataPackage.eINSTANCE.getOrder_SecondEvent().getName();
	
	private final static String EVENT_METHODREF_NAME = DataPackage.eINSTANCE.getEvent_MethodRefName().getName();
	private final static String EVENT_TYPE = DataPackage.eINSTANCE.getEvent_Type().getName();

	private final static String EVENT_TYPE_ACTIVATION = "activation";
	private final static String EVENT_TYPE_BEGIN = "begin";
	private final static String EVENT_TYPE_END = "end";
	
	
	private final static String TRIGGER_TYPE = DataPackage.eINSTANCE.getTrigger().getName();
	private final static String TRIGGER_METHODREF_LIST = DataPackage.eINSTANCE.getTrigger_MethodRefList().getName();
	
	private final static String TCONST_TYPE  = DataPackage.eINSTANCE.getTimeConstElement_BoundType().getName();
	private final static String TCONST_VALUE = DataPackage.eINSTANCE.getTimeConstElement_BoundValue().getName();
	private final static String TCONST_FEVENT = DataPackage.eINSTANCE.getTimeConstElement_FirstEvent().getName();
//	private final static String TCONST_SEVENT = DataPackage.eINSTANCE.getTimeConstElement_SecondEvent().getName();

	private final static String PROC_TYPE = DataPackage.eINSTANCE.getProc().getName();
	private final static String PROC_METHODREF_LIST = DataPackage.eINSTANCE.getProc_MethodRefList().getName();
//	private final static String VAR_METHODREF_LIST = DataPackage.eINSTANCE.getTrigger_MethodRefList().getName();
	private final static String METHODREF = DataPackage.eINSTANCE.getMethodRef().getName();
	private final static String METHODREF_METHOD = DataPackage.eINSTANCE.getMethodRef_MethodName().getName();
	
	private final static String S = "" + DataPath.SEPARATOR;

	
	private IReport reporter;
	/**
	 * All procs
	 */
	private List<ProcData> procs = new ArrayList<ProcData>();
	private HashMap<String, ProcData> fastProcs = new HashMap<String, ProcData>();

	/**
	 * All tasks
	 */
	private List<TaskData> tasks = new ArrayList<TaskData>();
	private HashMap<String, TaskData> fastTasks = new HashMap<String, TaskData>();

	/** The tree */
	private IVarTree vt;
	
	// -----

	/**
	 * Builds a new Partial Order Data Container.
	 * This method searches immediately everything it need in the specified IVarTree.
	 */
	public PartialOrderData(IVarTree vt, IReport reporter) {
		this.reporter = reporter;
		this.vt = vt;
		load();
	}
	
	/**
	 * @return the message reporter associated to this Partial Order Container
	 */
	public IReport getReporter() {
		return reporter;
	}

	
	/**
	 * Loads every thing
	 */
	protected void load() {
		final String sysName = Search.systemName(vt); 
		if (sysName == null) {
			return;
		}
		
		
		// load all tasks
		Mapping map = new Mapping(vt, sysName);
		TaskSet tset = new TaskSet(vt, sysName);
		tset.setProperty(Task.STR_ACT_TYPE, "", true);
		tset.setProperty(Task.STR_PERIOD, "", true);
		tset.setProperty(Task.STR_OFFSET, "", false);
		tset.setProperty(Task.STR_PRIORITY, "", true);
		final int cpuNumber = tset.getPrefixNumber();
		for (int cpu = 0; cpu < cpuNumber; cpu++) {
			final int cpuTasks = tset.getSize(cpu);
			for (int i =0; i< cpuTasks; i++) {
				// delegate the construction of each TaskData
				TaskData tdata = loadTaskData(tset.getItem(cpu, i));
				this.tasks.add(tdata);
				this.fastTasks.put(tdata.getTaskName(), tdata);
				
				// seaching all mapped procs
				String[] nprocs = map.taskToProc(tdata.getTaskName());
				for (String nproc: nprocs) {
					// delegate the construction of each ProcData
					ProcData pdata = loadProcData(nproc);
					pdata.setOrder(map.procToTaskOrder(nproc));
					pdata.setOnceEveryK(map.procToTaskFrequency(nproc));
					this.procs.add(pdata);
					this.fastProcs.put(nproc, pdata);
					tdata.addMapping(pdata);

					// posponing the period load
				}
				tdata.sortProcs();
			}
			
		}
	
		loadPeriods();
		
		loadPartialOrder();
		
		
//		faster (and safer) to use the already working old Task class 
//		ITreeInterface ti = vt.newTreeInterface();
//		String[] tasks = Search.allTasks(ti);
//		for (String task : tasks) {
//			System.out.println("Task : " + task);
//			TaskData tdata = loadTaskData(task);
//			this.tasks.add(tdata);
//			this.fastTasks.put(tdata.getTaskName(), tdata);
//		}
		
		
	}

		
	protected void loadPeriods() {
		final String sysName = Search.systemName(vt); 
		ITreeInterface ti = vt.newTreeInterface();

		
		
		
		// This map contains all triggers
		HashMap<String, String> triggers = new HashMap<String, String>();

		Search.FunctElement[] triggersArr = Search.allTrigger(ti, sysName);
		System.out.println("Triggers : ");
		for (Search.FunctElement trigger : triggersArr) {
			System.out.println("\t"+trigger.eviPath + " -> " + trigger.vtPath);
			triggers.put(trigger.eviPath, trigger.vtPath);
		}

		// the keyword is the proc ID
		HashMap<String, TempPeriodData> mainPeriods = loadPeriodicTimeConstraint();
		HashMap<String, TempPeriodData> allPeriods = new HashMap<String, TempPeriodData>();
		
		System.out.println("\n all periods : " + mainPeriods);
		
		
		// start to parse all elements. Store them in a separate vector because allPeriods is updated during the loop
		TempPeriodData[] mainObjects =  mainPeriods.values().toArray(new TempPeriodData[allPeriods.size()]);
		for (TempPeriodData mainObject : mainObjects) {
			
			computePeriod(null, mainObject, mainPeriods, allPeriods);
		}
		
		// copy all periods to each proc
		for (ProcData proc : procs) {
			
			if (allPeriods.containsKey(proc.getProcName())) {
				TempPeriodData temp = allPeriods.get(proc.getProcName());
			
				if (temp != null && temp.period != null) {
					proc.setPeriod((TimeVar) temp.period.clone());
					proc.setPeriodic(temp.periodic);
					proc.setEventProvider(temp.periodic ? null : temp.providerId);
				}
			}
			
			
//			// check period
			if (proc.getProcPeriod() == null) {
				if (proc.getTask() != null) {
					reporter.warning(proc, "unknown period. Using the one related to the task");
					
					int k = proc.getOnceEveryK() == null ? 1 : proc.getOnceEveryK().intValue();
					TimeVar period = proc.getTask().getTaskPeriod();
					if (k>0) {
						Double d = (Double) period.get();
						if (d != null) {
							d = d * k;
							period.set(d);
						}
					}
					
					proc.setPeriod(period);
					proc.setPeriodic(proc.getTask().isPeriodic());
				} else {
					reporter.error(proc, "unknown period.");
				}
			}
		}
		
	}
	
	protected void loadPartialOrder() {
		final String sysName = Search.systemName(vt); 

		
		// load partial orders
		// NOTE : doesn't support subsystems methods !!
		ITreeInterface ti = vt.newTreeInterface();
		String[] pOrderPaths = Search.allPartialOrders(ti);
		for (String poPath : pOrderPaths) {
			System.out.println(">> Found Partial Order at " + poPath);

			
			IVarTreePointer vtp_first = vt.newVarTreePointer();
			boolean ok = vtp_first.goAbsolute(poPath);
			IVarTreePointer vtp_second = (IVarTreePointer) vtp_first.clone();
			ok &= vtp_first.go(FIRST_EVENT_NAME);
			ok &= vtp_second.go(SECOND_EVENT_NAME);
			
			if (ok) {
				String first  = "" + vtp_first.getVar();
				String second = "" + vtp_second.getVar();

				System.out.println("Found Partial Order " + first + " -> " + second);
				
				final String firstPath  = Search.anEvent(ti, sysName, first);
				final String secondPath = Search.anEvent(ti, sysName, second);
				
				System.out.println("     1) " + firstPath + "\n"
						         + "     2) " + secondPath);
				
				String firstProc  = null;
				String secondProc = null;
				
				String firstMethodRef = null;
				String secondMethodRef = null;
				
				int first_weight = -1;
				int second_weight = -2;

				if (firstPath != null) {
					if (vtp_first.goAbsolute(firstPath + S + EVENT_METHODREF_NAME )) {
						firstMethodRef = "" + vtp_first.getVar();

						System.out.println(" ... first methodref : " + firstMethodRef);

						String firstType = null;
						
						// check the type
						if (vtp_first.goAbsolute(firstPath + S + EVENT_TYPE )) {
							firstType = "" + vtp_first.getVar();
						} else {
							reporter.error("Found an event without a type: " + first);
						}
						
						if (EVENT_TYPE_ACTIVATION.equalsIgnoreCase(firstType)) {
							first_weight = 1;
						} else if (EVENT_TYPE_BEGIN.equalsIgnoreCase(firstType)) {
							first_weight = 2;
						} else if (EVENT_TYPE_END.equalsIgnoreCase(firstType)) {
							first_weight = 3;
						} else {
							reporter.error("Found an event with a wrong type: " + first);
							continue;
						}
						
						String referedMethod = Search.aMethodRefMethod(ti, sysName, firstMethodRef);
						
						String path = Search.aMethod(ti, sysName, referedMethod);
						if (path == null) {
							String subSystemName = Search.methodPrefix(ti, sysName, referedMethod);
							path = subSystemName != null ? Search.aLocalMethod(ti, subSystemName, referedMethod) : null;
						}
						
						if (path != null) {
							firstProc = Utility.makeFunctionalPath(path);
						}
					} else {
						reporter.error("Found an event without method ref: " + first);
					}

				} else {
					reporter.error("Cannot find event " + first);
				}

				if (secondPath != null) {
					if (vtp_second.goAbsolute(secondPath + S + EVENT_METHODREF_NAME )) {
						secondMethodRef = "" + vtp_second.getVar();

						System.out.println(" ... second methodref : " + secondMethodRef);

						String secondType = null;
						if (vtp_second.goAbsolute(secondPath + S + EVENT_TYPE )) {
							secondType = "" + vtp_second.getVar();
						} else {
							reporter.error("Found an event without a type: " + second);
							continue;
						}
						if (EVENT_TYPE_ACTIVATION.equalsIgnoreCase(secondType)) {
							second_weight = 1;
						} else if (EVENT_TYPE_BEGIN.equalsIgnoreCase(secondType)) {
							second_weight = 2;
						} else if (EVENT_TYPE_END.equalsIgnoreCase(secondType)) {
							second_weight = 3;
						} else {
							reporter.error("Found an event with a wrong type: " + second);
							continue;
						}

						String referedMethod = Search.aMethodRefMethod(ti, sysName, secondMethodRef);
						
						String path = Search.aMethod(ti, sysName, referedMethod);
						if (path == null) {
							String subSystemName = Search.methodPrefix(ti, sysName, secondMethodRef);
							path = subSystemName != null ? Search.aLocalMethod(ti, subSystemName, secondMethodRef) : null;
						}

						if (path != null) {
							secondProc = Utility.makeFunctionalPath(path);
						}
					} else {
						reporter.error("Found an event without method ref: " + second);
					}

				} else {
					reporter.error("Cannot find event " + second);
				} 

				if (firstProc == null) {
					reporter.error("Cannot find the proc required by event " +first);;
				}
				
				if (secondProc == null) {
					reporter.error("Cannot find the proc required by event " +second);;
				}
				
				if (firstMethodRef != null && firstMethodRef.equals(secondMethodRef)
						&& first_weight >0 && second_weight >0) {
					
					if (first_weight < second_weight ) {
						reporter.warning("Explicited an implicit partial order: " + first + " -> " + second);
					} else {
						reporter.error("Imposed a not valid partial order: " + first + " -> " + second);
					}
				}
				
				System.out.println(" ... first proc : " + firstProc);
				System.out.println(" ... second proc : " + secondProc);
				
				ProcData fData = fastProcs.get(firstProc);
				ProcData sData = fastProcs.get(secondProc);
				
				if (fData == null && firstProc != null) {
					// check if it is a trigger
					if (Search.aTrigger(ti, sysName, firstProc) == null) {
						reporter.error("Cannot find a proc or trigger required by event " +firstProc);;
					} else {
						// debug message
						//System.out.println("FOUND a trigger for event " +first);							
					}
				}
				if (sData == null && secondProc != null) {
					// check if it is a trigger
					if (Search.aTrigger(ti, sysName, secondProc) == null) {
						reporter.error("Cannot find a proc or trigger required by event " +secondProc);;
					} else {
						// debug message
						//reporter.error("FOUND a trigger for event " +second);							
					}
				}

				if (fData != null && sData != null) {
					fData.addFollowing(sData);
					sData.addPrecedent(fData);
				}
				
			} else {
				reporter.error("Found a partial order without first or second event, at " + poPath);
			}
		}
	}
	
	
	/**
	 * @return a task data that contains all information about the specified task 
	 */
	protected TaskData loadTaskData(GenRes task) {
		TaskData answer = new TaskData(task.getName());
		answer.setTaskPeriod(new TimeVar("" + task.getProperty(Task.STR_PERIOD)));
		answer.setTaskOffset(new TimeVar("" + task.getProperty(Task.STR_OFFSET)));
		answer.setTaskPrio(task.getInt(Task.STR_PRIORITY));
		answer.setPeriodic("periodic".equals(task.getString(Task.STR_ACT_TYPE)));
		return answer;
	}

	
	/**
	 * @return a task data that contains all information about the specified task 
	 */
	protected TaskData loadTaskData(String taskPath) {
		String name;
		{
			String[] tmp = DataPath.splitPath(taskPath);
			name = tmp[tmp.length-1];
		}
		TaskData answer = new TaskData(name); 
		return answer;
	}
	
	/**
	 * @return a proc data that contains all information about the specified proc 
	 */
	protected ProcData loadProcData(String procName) {
		ProcData answer = new ProcData(procName, Search.aProc(vt.newTreeInterface(), Search.systemName(vt), procName));

		return answer;
	}
	
	
	
	
	
	///////////////////////////////////////////////////////////////
	
	
	/**
	 * @return an unmodifiable list of all procs defined
	 */
	public List<ProcData> getProcs() {
		return Collections.unmodifiableList(procs);
	}

	/**
	 * @return an unmodifiable list of all tasks defined
	 */
	public List<TaskData> getTasks() {
		return Collections.unmodifiableList(tasks);
	}

	/**
	 * This method checks if the required proc already exist.
	 * 
	 * @param procName
	 *            the full name of the proc
	 * 
	 * @return true if exists a proc with the specified name.
	 */
	public boolean checkProc(String procName) {
		return fastProcs.containsKey(procName);
	}

//
//	/**
//	 * This method checks if the required proc already exist. If yes, it return
//	 * that proc, otherwise it builds a new proc.
//	 * 
//	 * @param procName
//	 *            the full name of the proc
//	 * 
//	 * @return a proc with the specified name.
//	 */
//	public ProcData getProc(String procName) {
//		ProcData answer = fastProcs.get(procName);
//
//		if (answer == null) {
//			answer = new ProcData(procName);
//			fastProcs.put(procName, answer);
//			procs.add(answer);
//		}
//
//		return answer;
//	}

	/**
	 * This method checks if the required task already exist.
	 * 
	 * @param taskName
	 *            the full name of the task
	 * 
	 * @return true if exists a task with the specified name.
	 */
	public boolean checkTask(String taskName) {
		return fastTasks.containsKey(taskName);
	}
	
	/**
	 * This method checks if the required task already exist. If yes, it return
	 * that task, otherwise it builds a new task.
	 * 
	 * @param taskName
	 *            the full name of the task
	 * 
	 * @return a task with the specified name.
	 */
	public TaskData getTask(String taskName) {
		TaskData answer = fastTasks.get(taskName);

		if (answer == null) {
			answer = new TaskData(taskName);
			fastTasks.put(taskName, answer);
			tasks.add(answer);
		}

		return answer;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

	// ------------------------------------------------------------
	
	
	

	private enum PeriodProviderType {
		UNDEFINED,
		CURRENT_PROC,
		CURRENT_TRIGGER,
		A_PROC,
		A_TRIGGER,
		MERGE
	};

	/**
	 * This class contains some info about periods of elements.
	 * They can be procs and triggers.
	 * */
	private class TempPeriodData {
		final ProcData proc; // can be null
		
		final String path; // cannot be null
		final String ID; // cannot be null
		
		TimeVar period = null;
		boolean periodic = true;
		
		PeriodProviderType periodProvider = PeriodProviderType.UNDEFINED;
		String providerId;
		
		public TempPeriodData(ProcData proc, String path, String ID) {
			this.proc = proc;
			if (path == null) {
				throw new NullPointerException();
			}
			this.path = path;
			this.ID = ID;
		}
		
		@Override
		public String toString() {
			return periodProvider == PeriodProviderType.CURRENT_TRIGGER ?
					"TRIGGER " + providerId + "{" + ID + ": " + (periodic ? "period " : "mit ") + period+  " -> " + path + "} ":
					"PROC_" + (proc == null ? "missing": "found")+ " from " + providerId + "{" + ID + ": " + (periodic ? "period " : "mit ") + period+  " -> " + path + "} ";
		}
	}

	
	private HashMap<String, TempPeriodData> loadPeriodicTimeConstraint() {
		final String sysName = Search.systemName(vt); 
		ITreeInterface ti = vt.newTreeInterface();


		// the keyword is the proc ID
		HashMap<String, TempPeriodData> allPeriods = new HashMap<String, TempPeriodData>();
		
		
		String[] constranints = Search.allTimeConstraints(ti, DataPath.NULL_ID);
		IVarTreePointer vtp_base = vt.newVarTreePointer();
		System.out.println("Contraints : ");
		for (String constraint : constranints) {
			System.out.println("\t"+constraint);
			
			boolean ok = vtp_base.goAbsolute(constraint);
			
			if (!ok) {
				// quite strange error ... infact first we found an element and then we are not able to go to it
				System.out.println("\t\t ERROR");
				continue;
			}
			
			IVarTreePointer vtp = (IVarTreePointer) vtp_base.clone();
			ok = vtp.go(TCONST_TYPE);
			String type = ok ? "" + vtp.getVar() : null;

			if (!"period".equalsIgnoreCase(type) && !"mit".equalsIgnoreCase(type)) {
			
				if (!"deadline".equalsIgnoreCase(type) && !"jitter".equalsIgnoreCase(type) && !"offset".equalsIgnoreCase(type)) {
					reporter.warning("Found an unknown time constraint type: " + type);
				}
				// we are only looking for periods and mit 
				continue;
			}
			

			vtp = (IVarTreePointer) vtp_base.clone();
			ok 
			= vtp.go(TCONST_VALUE);
			IVariable value = ok ? vtp.getVar() : null;
			
			System.out.println("\t\t Value : " + value + " - type : " + type);
			
			if (value == null || value.get() == null) {
				reporter.warning("Found an time constraint without a value");
			}

			
			
			vtp = (IVarTreePointer) vtp_base.clone();
			ok = vtp.go(TCONST_FEVENT);
			
			if (ok) {
				String first  = "" + vtp.getVar();
				

				System.out.println("\t time const event " + first);
				
				String firstPath  = Search.anEvent(ti, sysName, first);
				
				System.out.println("     1) " + firstPath);
				
				String firstProc  = null;
				if (firstPath != null) {
					if (vtp.goAbsolute(firstPath + S + EVENT_METHODREF_NAME )) {
						String methRef = "" + vtp.getVar();

						System.out.println(" ... first methodref : " + methRef);

						String path = Search.aMethodRef(ti, sysName, methRef);
						if (path != null) {
							firstProc = Utility.makeFunctionalPath(path);
							
							boolean isTrigger = vtp.goAbsolute(path);
							isTrigger &= TRIGGER_TYPE.equals(vtp.getType());
							
							TempPeriodData data = null;
							if (isTrigger) {
								data = new TempPeriodData(null , path, firstProc);
								data.period = value instanceof TimeVar ? (TimeVar) value : new TimeVar(""+value);
								data.periodic = "period".equalsIgnoreCase(type);
								data.periodProvider = PeriodProviderType.CURRENT_TRIGGER;
								data.providerId = firstProc;
								
							} else {
								ProcData fData = fastProcs.get(firstProc);
								
								if (fData == null) {
									reporter.warning("Cannot find a proc required by event: " +firstProc);;
								}
								

								data = new TempPeriodData(fData , path, firstProc);
								data.period = value instanceof TimeVar ? (TimeVar) value : new TimeVar(""+value);
								data.periodic = "period".equalsIgnoreCase(type);
								data.periodProvider = PeriodProviderType.CURRENT_PROC;
								data.providerId = firstProc;
							}
							
							if (data != null) {
								if (allPeriods.containsKey(firstProc)) {
									TempPeriodData old = allPeriods.get(firstProc);
									if (!(old.period.equals(data))) {
										reporter.error("Found more than one period lenght for a single element: " + firstProc);
									}
								} else {
									allPeriods.put(firstProc, data);
								}
							}
							
						}
					} else {
						reporter.error("Found an event without method ref: " + first);
					}

				} else {
					reporter.error("Cannot find event " + first);
				}
				
				System.out.println(" ... first proc : " + firstProc);
				
			}
		}
		
		return allPeriods;
	}

	/**
	 * This method recursiverlly the period for current object and all objects
	 * referenced by this one. If parent is null, parent is expected to have
	 * already a period.
	 */
	private void computePeriod(TempPeriodData parent, TempPeriodData current,
			HashMap<String, TempPeriodData> mainObjects,
			HashMap<String, TempPeriodData> allPeriods) {
		
System.out.println("-> " + current.ID);
		
		final String sysName = Search.systemName(vt); 
		ITreeInterface ti = vt.newTreeInterface();

		
		// this var is used to stop the recursion if the current node is already examinated
		// or if it's one of main objects
		boolean continueOnReferences = true;
		
		if (parent == null) {
			
			// just add this node to allPeriods map
			 if (!allPeriods.containsKey(current.ID)) {
				 allPeriods.put(current.ID, current);
			 }
			
		} else {
			
			// check if this node is a main object or if it has already a temp value for period
			TempPeriodData existing = null;
			if (mainObjects.containsKey(current.ID)) {
				existing = mainObjects.get(current.ID);
				continueOnReferences = false;

				 if (!allPeriods.containsKey(current.ID)) {
					 allPeriods.put(current.ID, current);
				 }
				
			} else  if (allPeriods.containsKey(current.ID)) {
				existing = allPeriods.get(current.ID);

// TODO gestire il caso sporadici
				if (parent.periodic != existing.periodic) {
					reporter.warning(current.proc, "Found a connection between a periodic and a sporadic proc:\n" +
							"    from -> " + parent + " " + (parent != null ? parent.proc : "" ) + "\n" +
							"    to -> " + existing + " " + existing.proc + "\n"
							);
					
					continueOnReferences = false;
				
				// check if is required to downgrade the period
				} else if (!parent.periodic && !existing.periodic) {
					
					if (parent.providerId != null && parent.providerId.equals(existing.providerId)) {

						continueOnReferences = false;
						
					} else {
						reporter.error(current.proc, "Found a connection between two sporadic procs related to different triggers" + current.ID + "\n" +
								"    from -> " + parent + " " + (parent != null ? parent.proc : "" ) + "\n" +
								"    to -> " + existing + " " + existing.proc + "\n"
								);
					
						continueOnReferences = false;
					}

					
					
				} else if (PartialOrderChecker.checkPeriodsRatio(parent.period, existing.period) >0 && parent.periodic && existing.periodic) {
					// do nothing
					continueOnReferences = false;
					current.periodProvider = PeriodProviderType.MERGE;
					
				} else if (PartialOrderChecker.checkPeriodsRatio(existing.period, parent.period) >0 && parent.periodic && existing.periodic) {
					existing.period = (TimeVar) parent.period.clone();
					current.periodProvider = PeriodProviderType.MERGE;
					
				} else {
					if (current.proc != null)
						reporter.error(current.proc, "Found more than one value as the period for this object " + current.ID + "\n" +
								"    old -> " + existing + " " + existing.proc + "\n" +
								"    new -> " + current + " " + current.proc + "\n" +
								"    par -> " + parent + " " + (parent != null ? parent.proc : "" ) + "\n"
								);
					else 
						reporter.error("Found more than one value as the period for this object " + current.ID);
					
					continueOnReferences = false;
				}
				
			} else {
				// just a new node

				switch (parent.periodProvider) {
				case A_TRIGGER :
				case CURRENT_TRIGGER :
					current.periodProvider = PeriodProviderType.A_TRIGGER;
					break;
				case A_PROC :
				case CURRENT_PROC :
					current.periodProvider = PeriodProviderType.A_PROC;
					break;
				case MERGE :
					current.periodProvider = PeriodProviderType.MERGE;
					break;
				case UNDEFINED:
				default :
					current.periodProvider = PeriodProviderType.UNDEFINED;
				}
				

				current.providerId = parent.providerId;
				current.period = (TimeVar) parent.period.clone(); // CANNOT BE NULL !!!
				current.periodic = parent.periodic;
				allPeriods.put(current.ID, current);
			}
			
			
			
		}
		
		
		if (continueOnReferences) {
		
			IVarTreePointer vtp_main = vt.newVarTreePointer();
			boolean ok = vtp_main.goAbsolute(current.path);
	System.out.println("\t -> " + ok + " " + current.path);
			String methodref_list = null;
			if (TRIGGER_TYPE.equalsIgnoreCase(vtp_main.getType())) {
				methodref_list = TRIGGER_METHODREF_LIST;
			} else if (PROC_TYPE.equalsIgnoreCase(vtp_main.getType())) {
				methodref_list = PROC_METHODREF_LIST;
			}
	System.out.println("\t\t type = " + methodref_list);
			if (ok && vtp_main.go(methodref_list)) {
	System.out.println("\t\t\t inside method ref list");
				for (ok = vtp_main.goFirstChild(); ok; ok = vtp_main.goNextSibling()) {
	System.out.println("\t\t\t child type = " + vtp_main.getType());
					if (!METHODREF.equalsIgnoreCase(vtp_main.getType())) {
						continue;
					}
					IVarTreePointer vtp = (IVarTreePointer) vtp_main.clone();
					String method_ref = vtp.go(METHODREF_METHOD) ? "" + vtp.getVar() : null;
					
	System.out.println("\t\t\t            = " + method_ref);

					String methodOwnerPath = Search.aMethod(ti, sysName, method_ref);
					String methodOwnerID = null;
					if (methodOwnerPath != null) {
						methodOwnerID = Utility.makeFunctionalPath(methodOwnerPath);
					} else {
						reporter.error("Cannot find the method " + method_ref + ", required by " + current.ID);
					}
					
					System.out.println(" ... first proc : " + methodOwnerID);
			
					ProcData fData = fastProcs.get(methodOwnerID);
					
					// ignore not proc object
					if (fData != null) {
						
						TempPeriodData child = new TempPeriodData(fData, methodOwnerPath, methodOwnerID);
						
						computePeriod(current, child, mainObjects, allPeriods);
						
					}

				}
			}
		}
	}

	
	/**
	 * This method tries to compute once every k parameter for all procs,
	 *  and tries to set it
	 */
	public void computeAndUpdateOnceEveryK() {
		Mapping mapping = new Mapping(vt);
		
		for (ProcData proc : procs) {
			TaskData task = proc != null ? proc.getTask() : null;
			
			long onceEveryK = 1;
			if (task != null) {
				onceEveryK = PartialOrderChecker.checkPeriodsRatio(
						proc.getProcPeriod(), task.getTaskPeriod());
			}
			
			if (onceEveryK >0) {
				mapping.setProcToTaskFreq(proc.getProcName(), task.getTaskName(), new Integer((int)onceEveryK));
			}
		}
	}
	
	/**
	 * This method tries to compute once every k parameter and tries to set it
	 * 
	 * @return true if it was possible to compute the onceEveryK attribute
	 */
	public boolean computeAndUpdateOnceEveryK(String procName) {
	
		if (fastProcs != null && fastProcs.containsKey(procName)) {
			
			ProcData proc = fastProcs.get(procName);
			
			TaskData task = proc != null ? proc.getTask() : null;
			
			long onceEveryK = 1;
			if (task != null) {
				onceEveryK = PartialOrderChecker.checkPeriodsRatio(
						proc.getProcPeriod(), task.getTaskPeriod());
			}
			
			if (onceEveryK >0) {
				(new Mapping(vt)).setProcToTaskFreq(procName, task.getTaskName(), new Integer((int)onceEveryK));
				return true;
			}
		}
		
		return false;
	}
	
	
}
