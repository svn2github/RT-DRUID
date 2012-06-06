package com.eu.evidence.rtdruid.internal.modules.jscan.common;



import java.util.ArrayList;
import java.util.Properties;

import com.eu.evidence.rtdruid.Rtd_corePlugin;
import com.eu.evidence.rtdruid.internal.modules.jscan.JScan;
import com.eu.evidence.rtdruid.internal.modules.jscan.MutexSet;
import com.eu.evidence.rtdruid.internal.modules.jscan.Progress;
import com.eu.evidence.rtdruid.internal.modules.jscan.Schedulability;
import com.eu.evidence.rtdruid.internal.modules.jscan.ValueNotFoundException;
import com.eu.evidence.rtdruid.internal.modules.jscan.cachecost.CacheCostSchedulability;
import com.eu.evidence.rtdruid.internal.modules.jscan.multiframe.MultiFrameTaskSchedulability;
import com.eu.evidence.rtdruid.internal.modules.jscan.offset.OffSetSchedulability;
import com.eu.evidence.rtdruid.internal.modules.jscan.offset.OffSetSchedulabilityAssignment;
import com.eu.evidence.rtdruid.internal.modules.jscan.offset.OffsetDMSchedulabilityComplete;
import com.eu.evidence.rtdruid.internal.modules.jscan.offset.OffsetEDFSchedulabilityComplete;
import com.eu.evidence.rtdruid.internal.modules.jscan.offset.OffsetSchedulabilityEDF;
import com.eu.evidence.rtdruid.internal.modules.jscan.offset.OffsetSchedulabilityHyperplanesAnalysis;
import com.eu.evidence.rtdruid.internal.modules.jscan.offset.OffsetSchedulabilityRTA;
import com.eu.evidence.rtdruid.internal.modules.jscan.partialorder.PartialOrderData;
import com.eu.evidence.rtdruid.internal.modules.jscan.partialorder.StandarOutputReporter;
import com.eu.evidence.rtdruid.internal.modules.jscan.procdeadlines.ProcDeadlineAnalysis;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Cpu;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenResList;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Task;
import com.eu.evidence.rtdruid.vartree.abstractions.old.TaskSet;




/**	Takes all data from VarTree and shows them
 * 
 *   @author  Nicola Serreli
*/
public class JScanImpl extends JScan {
	
	/** Note: this entry is only for debug purposes */
	public final static String EXPORT_SCHEDULING_DATA = "DEBUGGING_export_scheduling_data";

// ----------------------   CONSTRUCTOR    ----------------------

	/**	Constructor
	*/
    public JScanImpl () {   }

// ----------------------   Start Schedulability test    ----------------------

	private static Schedulability prepare(IVarTree vt, String prefix,String[][] taskP, String[][] resourceP, Schedulability sched, String mode, Properties options) {
		GenResList risorse = new MutexSet(vt, prefix);
		for (int i=0; i<resourceP.length; i++) {
			risorse.setProperty(resourceP[i][0],resourceP[i][1], false);
		}
		
		TaskSet tasks = new TaskSet(vt, prefix, mode);
		
		for (int i=0; i<taskP.length; i++) {
			tasks.setProperty(taskP[i][0], taskP[i][1], taskP[i][2] != null);
		}

		sched.setTaskSet(tasks);
		sched.setResourceSet(risorse);
		
		
		if (options != null) {
			if ("true".equalsIgnoreCase(options.getProperty(USE_OS_OVERHEAD))) {
				tasks.setCpuProperty(Cpu.SCHED_ACTIVATION_COST, "", false);
				tasks.setCpuProperty(Cpu.SCHED_TERMINATION_COST, "", false);
				tasks.setCpuProperty(Cpu.SCHED_CONTEXT_SWITCH_COST, "", false);
				
			} else if ("true".equalsIgnoreCase(options.getProperty(USE_OS_OVERHEAD))) {
				tasks.setCpuProperty(Cpu.SCHED_CONTEXT_SWITCH_COST, "", false);
			}  
		}
		
		return sched; 
	}

	/* WITHOUT OFFSET */
	/***/
	protected static RMSchedulability prepareRM(IVarTree vt, String prefix, String mode, Properties options) {
		return (RMSchedulability) prepare(vt, prefix, tasksRMSchedulability, risorseAnalysis, new RMSchedulability(), mode, options);
	}
	/***/
	protected static RTASchedulability prepareRTA(IVarTree vt, String prefix, String mode, Properties options) {
		return (RTASchedulability) prepare(vt, prefix, tasksRTASchedulability, risorseAnalysis, new RTASchedulability(), mode, options);
	}
	/***/
	protected static HyperplanesAnalysis prepareHPA(IVarTree vt, String prefix, String mode, Properties options) {
		return (HyperplanesAnalysis) prepare(vt, prefix, tasksHyperplanesAnalysis, risorseAnalysis, new HyperplanesAnalysis(), mode, options);
	}
	/***/
	protected static MultiFrameTaskSchedulability prepareMultiFrame(IVarTree vt, String prefix, String mode, Properties options) {
		PartialOrderData pdata = new PartialOrderData(vt, new StandarOutputReporter());
		pdata.computeAndUpdateOnceEveryK();
		return (MultiFrameTaskSchedulability) prepare(vt, prefix, tasksMultiFrameSchedulability, risorseAnalysis, new MultiFrameTaskSchedulability(), mode, options);
	}
	/***/
	protected static ProcDeadlineAnalysis prepareProcDeadline(IVarTree vt, String prefix, String mode, Properties options) {
		PartialOrderData pdata = new PartialOrderData(vt, new StandarOutputReporter());
		pdata.computeAndUpdateOnceEveryK();
		return (ProcDeadlineAnalysis) prepare(vt, prefix, tasksMultiFrameSchedulability, risorseAnalysis, new ProcDeadlineAnalysis(), mode, options);
	}
	/***/
	protected static CacheCostSchedulability prepareCacheMissCost(IVarTree vt, String prefix, String mode, Properties options) {
		return (CacheCostSchedulability) prepare(vt, prefix, tasksCacheCostSchedulability, risorseAnalysis, new CacheCostSchedulability(), mode, options);
	}
	
	/* WITH OFFSET */
	/***/
	protected static OffSetSchedulability prepareOSEDF(IVarTree vt, String prefix, String mode, Properties options) {
		return (OffSetSchedulability) prepare(vt, prefix, tasksOffSetSchedulability, risorseAnalysis, new OffsetSchedulabilityEDF(), mode, options);
	}


	protected static OffSetSchedulability prepareOSRT(IVarTree vt, String prefix, String mode, Properties options) {
		return (OffSetSchedulability) prepare(vt, prefix, tasksOffSetSchedulability, risorseAnalysis, new OffsetSchedulabilityRTA(), mode, options);
	}
	protected static OffSetSchedulability prepareOSHP(IVarTree vt, String prefix, String mode, Properties options) {
		return (OffSetSchedulability) prepare(vt, prefix, tasksOffSetSchedulability, risorseAnalysis, new OffsetSchedulabilityHyperplanesAnalysis(), mode, options);
	}
	protected static OffSetSchedulabilityAssignment prepareOSA(IVarTree vt, String prefix, String mode, Properties options) {
		return (OffSetSchedulabilityAssignment) prepare(vt, prefix, tasksOffSetSchedulability, risorseAnalysis, new OffSetSchedulabilityAssignment(), mode, options);
	}
	protected static OffsetDMSchedulabilityComplete prepareOSDM(IVarTree vt, String prefix, String mode, Properties options) {
		return (OffsetDMSchedulabilityComplete) prepare(vt, prefix, tasksOffSetSchedulability, risorseAnalysis, new OffsetDMSchedulabilityComplete(), mode, options);
	}
	
	protected static OffsetEDFSchedulabilityComplete prepareOSEDFC(IVarTree vt, String prefix, String mode, Properties options) {
		return (OffsetEDFSchedulabilityComplete) prepare(vt, prefix, tasksOffSetSchedulability, risorseAnalysis, new OffsetEDFSchedulabilityComplete(), mode, options);
	}
	
	/////////////////////////////////////////////////////////////////
	
	/** Start all test and make a global report (just analysis without offset)
	 *
	 *  @param vt current data repository 
	 *  @param system identifies the system to use  (without protection, see {@link rtdruid.vartree.IVarTree#addSlash rtdruid.vartree.VarTree.addSlash()})
	 *  @param priorities is one of static int above : USER_PRIORITIES, PRIORITIES_BY_DEADLINE and PRIORITIES_BY_PERIOD.; 
	 * */
	private static String globalReport(IVarTree vt, String system, String mode, Progress progress, Properties options) {
//Messages.sendDebug("Start globalReport");
		
		// Make TaskSet and MutexSet		
		GenResList mutex = new MutexSet(vt, system);
		for (int i=0; i<risorseAnalysis.length; i++) {
			mutex.setProperty(risorseAnalysis[i][0],risorseAnalysis[i][1], false);
		}
		
		TaskSet tasks = new TaskSet(vt, system, mode);
		
		// add all required properties  
		for (int i=0; i<globalReportProp.length; i++) {
//Messages.sendDebug("Set Task property : " + globalReportProp[i][0] + " - " + globalReportProp[i][1]);
			tasks.setProperty(globalReportProp[i][0], globalReportProp[i][1], globalReportProp[i][2] != null);
		}
		tasks.onlyPeriodicTasks();
		{ // check for not found values
			checkNotFoundValues(tasks); 
		}

//Messages.sendDebug("Set tests");

		Schedulability testRTA = new RTASchedulability();
		testRTA.setTaskSet(tasks);
		testRTA.setResourceSet(mutex);
		testRTA.setProgress(progress);

		Schedulability testHPA = new HyperplanesAnalysis();
		testHPA.setTaskSet(tasks);
		testHPA.setResourceSet(mutex);
		testHPA.setProgress(progress);

		
		if (options != null) {
			if ("true".equalsIgnoreCase(options.getProperty(USE_OS_OVERHEAD))) {
				tasks.setCpuProperty(Cpu.SCHED_ACTIVATION_COST, "", false);
				tasks.setCpuProperty(Cpu.SCHED_TERMINATION_COST, "", false);
				tasks.setCpuProperty(Cpu.SCHED_CONTEXT_SWITCH_COST, "", false);
				
			} else if ("true".equalsIgnoreCase(options.getProperty(USE_OS_OVERHEAD))) {
				tasks.setCpuProperty(Cpu.SCHED_CONTEXT_SWITCH_COST, "", false);
			}  
		}
		
//Messages.sendDebug("Start output");

		for (int rtosId=1; rtosId< tasks.getPrefixNumber(); rtosId++) {
			testHPA.compute(rtosId);
			testRTA.compute(rtosId);  

			if (tasks.getSize(rtosId) == 0)
				continue;	// next rtos
			// complete report
			//testHPA.addReport(system, mode, risp.toString());
			testHPA.addReport(system, mode, printReport(testHPA, rtosId));
			//totalRisp.append("\n" + risp);
		}
		
		// store all into VarTree
		String answer = printReport(testHPA); 
		testHPA.storeCpuSched();
		testHPA.storeReports();
		testRTA.storeCpuSched();
		testRTA.setSave(true);
//		testHPA.setSave(true);
		//return totalRisp.toString();
		return answer;
	}
	
	/**
	 * 
	 * @param ts
	 * @return true if there is one or more "Required values" not found
	 */
	private static void checkNotFoundValues(TaskSet ts) {
		StringBuffer buff = new StringBuffer();
		boolean ok = false;
		
		String sys = DataPath.removeSlash(DataPath.removeSlash(DataPath.splitPath(ts.getSystem())[0]));
		
		
		buff.append(VALUE_NOT_FOUND_PREFIX 
				+ "System \"" + sys + "\" and Mode \"" + ts.getMode() + "\"\n");
		for (int rtosId=1; rtosId< ts.getPrefixNumber(); rtosId++) {

			buff.append("  Rtos: " + DataPath.removeSlash(ts.getPrefix(rtosId)) + "\n");
			
			for (int j =0; j<ts.getSize(rtosId); j++) {
				Task task = (Task) ts.getItem(rtosId, j);

				String[] values = task.getNotFoundValues(Task.REQUIRED);
				if (values.length >0) {
					buff.append("    Task " + task.getName() + " ... require ");
					for (int i=0; i<values.length; i++) {
						buff.append((i==0 ? "" : (i <values.length-1 ? ", " : " and ")) +values[i]);
					}
					buff.append("\n");
					ok = true;
				} else {
					buff.append("    Task " + task.getName() + " ... OK\n");
					
				}
				
			}
		}

		if (ok) {
			throw new ValueNotFoundException(buff.toString());
		}
	}
	
	/**
	 */
	public String startTestImpl(IVarTree vt, String system, int testID, Properties options, Progress progress) {
		String mode = null;
		int pValue = JScanImpl.USER_PRIORITIES;
		int fVal = 2;
		
		if (options != null) {
			mode = options.getProperty(MODE_STR);
			mode = mode == "" ? null : mode;
	
			String priorities = options.getProperty(PRIORITIES_STR);
			if (("" + JScanImpl.USER_PRIORITIES).equals(priorities)) {
				pValue = JScanImpl.USER_PRIORITIES;
			} else if (("" + JScanImpl.PRIORITIES_BY_DEADLINE).equals(priorities)) {
				pValue = JScanImpl.PRIORITIES_BY_DEADLINE;
			} else if (("" + JScanImpl.PRIORITIES_BY_PERIOD).equals(priorities)) {
				pValue = JScanImpl.PRIORITIES_BY_PERIOD;
			} else {
				pValue = JScanImpl.USER_PRIORITIES;
//				throw new IllegalArgumentException("Not valid priority");
			}
			
			if (options.getProperty(F_STR) != null) {
				fVal = Integer.parseInt(options.getProperty(F_STR));
			}
		}


		/*
		 *  compute
		 */
		String report = null;
		vt.beginTransaction(); // start to group all commands
		vt.getCurrentTransaction().setLabel("Schedulability Analysis"); // start to group all commands
		ArrayList<Schedulability> schedulers = new ArrayList<Schedulability>();
		try {

			// set priorities
			if (pValue != JScanImpl.USER_PRIORITIES) {
				
				TaskSet tasks = new TaskSet(vt, system, mode);
				tasks.setSave(true);
				
				// add all required properties  
				tasks.setProperty(Task.STR_ACT_TYPE,"", true);
				tasks.setProperty("deadline","", true);
				tasks.setProperty("period","", true);
				tasks.setProperty("priority","", true);
				tasks.onlyPeriodicTasks();

				{ // check for not found values
					checkNotFoundValues(tasks); 
				}
				
				switch (pValue) {
					case PRIORITIES_BY_DEADLINE:  tasks.computeDMPriorities(); break;
					case PRIORITIES_BY_PERIOD:    tasks.computeRMPriorities(); break; 
				}
			}

			
			switch (testID) {
				default : // default = NO OFFSET
					throw new UnsupportedOperationException("Try to start an unsupported Test");
					//break;
				case STACK_SIZE:
				{
					TaskSet tasks = new TaskSet(vt, system, mode);
					tasks.setSave(true);
					StackOptimization stackOptimizer = new StackOptimization(tasks);
					stackOptimizer.setProgress(progress);
					//int stackSize[] = 
						stackOptimizer.calculateMaximumStackSize();
					stackOptimizer.print();
				}
				break;
				case NO_OFFSET_ID:
					{
						// used : analysis without offsets

						report = JScanImpl.globalReport(vt, system, mode, progress, options);
					}
					break;
					
				case EXACT_ID:
					{
						Schedulability sc = JScanImpl.prepareOSDM(vt, system, mode, options);
						Schedulability sc1 = JScanImpl.prepareOSEDFC(vt, system, mode, options);
						
						schedulers.add(sc);
						schedulers.add(sc1);
						
						// clear all aperiodic and sporadic tasks
						sc.getTaskSet().onlyPeriodicTasks(); 
						{ // check for not found values
							checkNotFoundValues(sc.getTaskSet()); 
						}
						
						// clear all aperiodic and sporadic tasks
						sc1.getTaskSet().onlyPeriodicTasks(); 
						{ // check for not found values
							checkNotFoundValues(sc1.getTaskSet()); 
						}

						sc.setProgress(progress);
						sc1.setProgress(progress);
						
						sc.compute();
						report = sc.getReport();
						sc.setSave(true);

						sc1.compute();
						report += sc1.getReport();
						sc1.setSave(true);
	
					}
					break;
	
					
				case EXACT_FP_ID:
				{
					// used : exact analysis with offsets

					Schedulability sc = JScanImpl.prepareOSDM(vt, system, mode, options);
					schedulers.add(sc);
					
					// clear all aperiodic and sporadic tasks
					sc.getTaskSet().onlyPeriodicTasks(); 
					{ // check for not found values
						checkNotFoundValues(sc.getTaskSet()); 
					}

					sc.setProgress(progress);

					sc.compute();
					report = sc.getReport();
					sc.addReport(system, mode, report);
					sc.setSave(true);
				}
				break;
	
						
				case EXACT_EDF_ID:
				{
					Schedulability sc = JScanImpl.prepareOSEDFC(vt, system, mode, options);
					schedulers.add(sc);
					
					// clear all aperiodic and sporadic tasks
					sc.getTaskSet().onlyPeriodicTasks(); 
					{ // check for not found values
						checkNotFoundValues(sc.getTaskSet()); 
					}
	
					sc.setProgress(progress);
					
					sc.compute();
					report = sc.getReport();
					sc.setSave(true);
				}
				break;
	
					
				case FLEASIBLE_ID:
					{   
	/*					Schedulability sc = JScan.prepareOSEDF(system, mode);
						((OffSetSchedulability) sc).setTotalFixedTask(fVal);
						
						// clear all aperiodic and sporadic tasks
						sc.getTaskSet().onlyPeriodicTasks(); 
	
		*/				
						OffsetSchedulabilityRTA os = (OffsetSchedulabilityRTA) JScanImpl.prepareOSRT(vt, system, mode, options)	;
						OffsetSchedulabilityEDF os2 = (OffsetSchedulabilityEDF) JScanImpl.prepareOSEDF(vt, system, mode, options)	;
						os.setTotalFixedTask(fVal);
						os2.setTotalFixedTask(fVal);
						schedulers.add(os);
						schedulers.add(os2);

						// clear all aperiodic and sporadic tasks
						os.getTaskSet().onlyPeriodicTasks(); 
						{ // check for not found values
							checkNotFoundValues(os.getTaskSet()); 
						}
						
						// clear all aperiodic and sporadic tasks
						os2.getTaskSet().onlyPeriodicTasks(); 
						{ // check for not found values
							checkNotFoundValues(os2.getTaskSet()); 
						}

						os.setProgress(progress);
						os2.setProgress(progress);

						// OS RT Test
						os.compute();
						report += os.getReport();
						os.setSave(true);
						// OS RT Test
						os2.compute();
						report += os2.getReport();
						os2.setSave(true);
						
					}
					break;
	
				case FLEASIBLE_EDF_ID:
				{   
					Schedulability sc = JScanImpl.prepareOSEDF(vt, system, mode, options);
					((OffSetSchedulability) sc).setTotalFixedTask(fVal);
					schedulers.add(sc);
					
					// clear all aperiodic and sporadic tasks
					sc.getTaskSet().onlyPeriodicTasks(); 
					{ // check for not found values
						checkNotFoundValues(sc.getTaskSet()); 
					}
	
					sc.setProgress(progress);
					
					// OS EDF test
					sc.compute();
					report = sc.getReport();
					sc.setSave(true);
					sc.setSave(false);
				}
				break;
				case MULTIFRAME_FP_ID:
				{   
					Schedulability sc = JScanImpl.prepareMultiFrame(vt, system, mode, options);
					schedulers.add(sc);
					
					// clear all aperiodic and sporadic tasks
					sc.getTaskSet().onlyPeriodicTasks(); 
					{ // check for not found values
						checkNotFoundValues(sc.getTaskSet()); 
					}
	
					sc.setProgress(progress);
					
					// OS EDF test
					sc.compute();
					report = sc.getReport();
					sc.setSave(true);
					sc.setSave(false);
				}
				break;
				case PROC_SCHED_MULTIFRAME_FP_ID:
				{   
					Schedulability sc = JScanImpl.prepareProcDeadline(vt, system, mode, options);
					schedulers.add(sc);
					
					// clear all aperiodic and sporadic tasks
					sc.getTaskSet().onlyPeriodicTasks(); 
					{ // check for not found values
						checkNotFoundValues(sc.getTaskSet()); 
					}
	
					sc.setProgress(progress);
					
					// OS EDF test
					sc.compute();
					report = sc.getReport();
					sc.setSave(true);
					sc.setSave(false);
				}
				break;
				case CACHE_COST_FP_ID:
				{   
					Schedulability sc = JScanImpl.prepareCacheMissCost(vt, system, mode, options);
					schedulers.add(sc);
					
					// clear all aperiodic and sporadic tasks
					sc.getTaskSet().onlyPeriodicTasks(); 
					{ // check for not found values
						checkNotFoundValues(sc.getTaskSet()); 
					}
	
					sc.setProgress(progress);
					
					// OS EDF test
					sc.compute();
					report = sc.getReport();
					sc.setSave(true);
					sc.setSave(false);
				}
				break;
				case FLEASIBLE_RT_ID:
					{   
					// used : sufficient analysis with offsets

	/*				Schedulability sc = prepare(
								system,
								tasksOffSetSchedulability,
								risorseAnalysis,
								new OffSetSchedulabilityRTA(),
								mode);
	*/
						boolean enableCDelta = false;
						{
							String tmp = options.getProperty(CDELTA_COMPUTATION_STR);
							enableCDelta = tmp == null ? false : "true".equalsIgnoreCase(tmp);
						}
						
						{
							Schedulability sc = JScanImpl.prepareOSRT(vt, system, mode, options);
							((OffSetSchedulability) sc).setTotalFixedTask(fVal);
							schedulers.add(sc);
						
							// clear all aperiodic and sporadic tasks
							sc.getTaskSet().onlyPeriodicTasks(); 
							{ // check for not found values
								checkNotFoundValues(sc.getTaskSet()); 
							}
		
							sc.setProgress(progress);
							
							Schedulability sc1 = null;
							if (enableCDelta) {
								//System.err.println("\nStart Second analysis\n");
								sc1 = JScanImpl.prepareOSHP(vt, system, mode, options);
								((OffSetSchedulability) sc1).setTotalFixedTask(fVal);
								((OffsetSchedulabilityHyperplanesAnalysis) sc1).setSensitivityPrecision(0.00000001);
								sc1.setTaskSet(sc.getTaskSet());
								
								sc1.setProgress(progress);
								sc1.compute();
							} else {
								//clear CDelta
								TaskSet tasks = sc.getTaskSet();
								for (int cpuId = 0; cpuId < tasks.getPrefixNumber(); cpuId++) {
									for (int i = 0; i < tasks.getSize(cpuId); i++) {
										tasks.getItem(cpuId, i).setProperty("CDelta", "");
									}
									
								}

							}
							
							sc.compute();
							report = sc.getReport();
							sc.addReport(system, mode, report);
							sc.setSave(true);
							sc.setSave(false);
							
							//System.err.println("\nend first analysis\n");
						}


					}
					break;
				case ASSIGNMENT_ID:
					{
						Schedulability sc = JScanImpl.prepareOSA(vt, system, mode, options);
						schedulers.add(sc);
						
						// clear all aperiodic and sporadic tasks
						sc.getTaskSet().onlyPeriodicTasks(); 
						{ // check for not found values
							checkNotFoundValues(sc.getTaskSet()); 
						}
						sc.setProgress(progress);
	
						sc.compute();
						report = sc.getReport();
						sc.setSave(true);
					}
					break;
				case PERIOD_SENSITIVITY_ID:
					{
						Schedulability sc = prepare(vt, system, tasksPeriodSensitivity, risorseAnalysis, new PeriodSensitivity(), mode, options);
						schedulers.add(sc);
						
						// clear all aperiodic and sporadic tasks
						sc.getTaskSet().onlyPeriodicTasks(); 
						{ // check for not found values
							checkNotFoundValues(sc.getTaskSet()); 
						}
		
						sc.setProgress(progress);
						sc.compute();
						report = sc.getReport();
	//					sc.setSave(true);
					}
					break;
			}
/*		} catch (ValueNotFoundException e) {
			
			// undo all ..
			vt.rollbackTransaction();
			// return message
			return e.getMessage();
*/			
		} catch (ThreadDeath e) {
			// undo all ..
			vt.rollbackTransaction();
			// .. and trhrow again the exception
			Rtd_corePlugin.log(e);
			throw e;
		} catch (RuntimeException e) {
			// undo all ..
			vt.rollbackTransaction();
			// .. and trhrow again the exception
			Rtd_corePlugin.log(e);
			throw e;
		} catch (Throwable e) {
		    Rtd_corePlugin.log(e);
		    throw new RuntimeException(e);
		} finally {
			vt.commitTransaction(); // commit all commands
			
			if (options != null && options.containsKey(EXPORT_SCHEDULING_DATA)) {
				Object o = options.get(EXPORT_SCHEDULING_DATA);
				if ("true".equals(o)) {
					options.put(EXPORT_SCHEDULING_DATA, schedulers);
				}
			}
			
		}

		return report;
	}
	
}
