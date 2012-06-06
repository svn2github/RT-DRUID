package com.eu.evidence.rtdruid.internal.modules.jscan;



import java.util.Enumeration;
import java.util.Properties;

import com.eu.evidence.rtdruid.internal.modules.jscan.common.JScanImpl;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenResList;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Task;
import com.eu.evidence.rtdruid.vartree.abstractions.old.TaskSet;



/**	
 * This class is the factory class for the Schedulability analysis classes.
 *  
 * @author  Nicola Serreli
*/
public abstract class JScan {
	
	private static final JScan INSTANCE = new JScanImpl();
	
	/**
	 * These constants code the type of schedulability analysis
	 */
	public static final int NO_OFFSET_ID  = 0;

	public static final int ASSIGNMENT_ID = 1;
	public static final int PERIOD_SENSITIVITY_ID = 2;

	public static final int FLEASIBLE_ID   = 3;
	public static final int FLEASIBLE_EDF_ID   = 4;
	public static final int FLEASIBLE_RT_ID   = 5;

	public static final int EXACT_ID      = 6;
    public static final int EXACT_FP_ID      = 7;
    public static final int EXACT_EDF_ID      = 8;

    public static final int MULTIFRAME_FP_ID      = 9;
    public static final int PROC_SCHED_MULTIFRAME_FP_ID      = 10;
    public static final int CACHE_COST_FP_ID      = 11;

    
    public static final int STACK_SIZE = 12;

//  public static final int ANALYSIS_NUMBER = 11;

    /*
     * List of valid parameters of the schedulability analysis 
     */
    public static final String MODE_STR   = "Mode";
    public static final String PRIORITIES_STR = "Priorities";
    public static final String F_STR = "F";
    public static final String CDELTA_COMPUTATION_STR = "CDeltaComputation";
    public static final String VALUE_NOT_FOUND_PREFIX = "Some required values are missed\n";
    
    public final static String USE_OS_CONTEXT_SWITCH = "use_os_context_switch_cost";
    public final static String USE_OS_OVERHEAD = "use_os_overhead";

    
    /** List of parameters required by each analysis */
    public static final String[][] usedProperties = {
			{MODE_STR, PRIORITIES_STR},       //NO_OFFSET_ID
			{MODE_STR, PRIORITIES_STR},        //ASSIGNMENT_ID			
			{MODE_STR, PRIORITIES_STR},       //PERIOD_SENSITIVITY_ID
			{MODE_STR, PRIORITIES_STR, F_STR},//FLEASIBLE_ID
			{MODE_STR, PRIORITIES_STR, F_STR},//FLEASIBLE_EDF_ID
			{MODE_STR, PRIORITIES_STR, F_STR}, //FLEASIBLE_RT_ID
			{MODE_STR, PRIORITIES_STR},       //EXACT_ID
			{MODE_STR, PRIORITIES_STR},       //EXACT_FP_ID
			{MODE_STR, PRIORITIES_STR}       //EXACT_EDF_ID
	};
	
	//
	/** 
	 * How to assign priorities
	 */
	public final static int USER_PRIORITIES = 0;
	public final static int PRIORITIES_BY_DEADLINE = 1;
	public final static int PRIORITIES_BY_PERIOD = 2;


	/**
	 * Properties needed by the analysis.
	 */
	protected final static String[][] tasksRTASchedulability = {
		{ Task.STR_ACT_TYPE,    "__see_task__", "REQUIRED" },
		{ "resource",           "__see_task__", null },
		{ "period",             "__see_task__", "REQUIRED" },
		{ "wcet",               "__see_task__", "REQUIRED" },
		{ "deadline",           "__see_task__", null       },
		{ "offset",             "__see_task__", null       },
		{ "priority",           "__see_task__", "REQUIRED" },
		{ "ResponseTime",       "__see_task__", null       },
//		{ "PreemptionGroupName","__see_task__", null       },
		{ "blocking",           "__see_task__", null       },
		{ "schedulable",        "__see_task__", null       }
	};

	protected final static String[][] tasksOffSetSchedulability = {
		{ Task.STR_ACT_TYPE,    "__see_task__", "REQUIRED"},
//		{ "fixed",      ""  },
		{ "resource",           "__see_task__", null      },
//		{ "PreemptionGroupName","__see_task__", null      },
		{ "utilization",        "__see_task__", null      },
		{ "ResponseTime",       "__see_task__", null      },

		{ "priority",           "__see_task__", "REQUIRED"},
		{ "period",             "__see_task__", "REQUIRED"},
		{ "wcet",               "__see_task__", "REQUIRED"},
		{ "deadline",           "__see_task__", null      },
		{ "offset",             "__see_task__", "REQUIRED"},
		{ "blocking",           "__see_task__", null      },
		{ "schedulable",        "__see_task__", null      },
		{ "cDelta",             "__see_task__", null      }
		
	};

	protected final static String[][] tasksRMSchedulability = 
	{
		{ Task.STR_ACT_TYPE,    "__see_task__", "REQUIRED"},
		{ "resource",           "__see_task__", null      },
		{ "period",             "__see_task__", "REQUIRED"},
		{ "wcet",               "__see_task__", "REQUIRED"},
		{ "deadline",           "__see_task__", null      },
		{ "offset",             "__see_task__", null      },
		{ "priority",           "__see_task__", "REQUIRED"},
		{ "utilization",        "__see_task__", null      },
//		{ "PreemptionGroupName","__see_task__", null      },
		{ "blocking",           "__see_task__", null      },
		{ "schedulable",        "__see_task__", null      }
	};
	
	protected final static String[][] tasksCacheCostSchedulability = {
		{ Task.STR_ACT_TYPE,    "__see_task__", "REQUIRED" },
		{ "resource",           "__see_task__", null },
		{ "period",             "__see_task__", "REQUIRED" },
		{ "wcet",               "__see_task__", "REQUIRED" },
		{ Task.STR_CACHE_MISS_COST, "__see_task__", "REQUIRED" },
		{ "deadline",           "__see_task__", null       },
		{ "offset",             "__see_task__", null       },
		{ "priority",           "__see_task__", "REQUIRED" },
		{ "ResponseTime",       "__see_task__", null       },
		{ "utilization",        "__see_task__", null      },
//		{ "PreemptionGroupName","__see_task__", null       },
		{ "blocking",           "__see_task__", null       },
		{ "schedulable",        "__see_task__", null       }
	};

	protected final static String[][] tasksMultiFrameSchedulability = 
	{
		{ Task.STR_ACT_TYPE,    "__see_task__", "REQUIRED"},
		{ "resource",           "__see_task__", null      },
		{ "period",             "__see_task__", "REQUIRED"},
		{ "wcet",               "__see_task__", "REQUIRED"},
		{ "deadline",           "__see_task__", null      },
		{ "offset",             "__see_task__", null      },
		{ "priority",           "__see_task__", "REQUIRED"},
		{ "utilization",        "__see_task__", null      },
		{ "ResponseTime",       "__see_task__", null       },
//		{ "PreemptionGroupName","__see_task__", null      },
		{ Task.STR_PROC_LIST,   "__see_task__", null      },
		{ Task.STR_GENERIC_WCET,"__see_task__", null      },
		{ "blocking",           "__see_task__", null      },
		{ "schedulable",        "__see_task__", null      }
	};

	protected final static String[][] tasksHyperplanesAnalysis = 
	{
		{ Task.STR_ACT_TYPE,    "__see_task__", "REQUIRED"},
//		{ "PreemptionGroupName","__see_task__", null      },
		{ "resource",           "__see_task__", null      },
		{ "priority",           "__see_task__", "REQUIRED"},
		{ "wcet",               "__see_task__", "REQUIRED"},
		{ "period",             "__see_task__", "REQUIRED"},
		{ "deadline",           "__see_task__", null      },
		{ "blocking",           "__see_task__", null      },
		{ "utilization",        "__see_task__", null      },
		{ "cDelta",             "__see_task__", null      }
	};

	protected final static String[][] tasksPeriodSensitivity = {
		{ Task.STR_ACT_TYPE,    "__see_task__", "REQUIRED"},
		{ "resource",           "__see_task__", null      },
//			{ "PreemptionGroupName","__see_task__", null      },
		{ "priority",           "__see_task__", "REQUIRED"},
		{ "wcet",               "__see_task__", "REQUIRED"},
		{ "period",             "__see_task__", "REQUIRED"},
		{ "deadline",           "__see_task__", null      },
		{ "blocking",           "__see_task__", null      },
		{ "utilization",        "__see_task__", null      },
		{ "cDelta",             "__see_task__", null      }
	};

	/** All task's property used by global report */
	protected final static String[][] globalReportProp = {
		{ Task.STR_ACT_TYPE,    "__see_task__", "REQUIRED"},
		{ "resource",           "__see_task__", null      },
		{ "period",             "__see_task__", "REQUIRED"},
		{ "wcet",               "__see_task__", "REQUIRED"},
		{ "deadline",           "__see_task__", null      },
		{ "offset",             "__see_task__", null      },
		{ "priority",           "__see_task__", "REQUIRED"},
		{ "ResponseTime",       "__see_task__", null      },
//			{ "PreemptionGroupName","__see_task__", null      },
		{ "blocking",           "__see_task__", null      },
		{ "schedulable",        "__see_task__", null      },
		{ "priority",           "__see_task__", null      },
		{ "utilization",        "__see_task__", null      },
		{ "cDelta",             "__see_task__", null      }
	};


	protected final static String[][] risorseAnalysis = { }; //{"ceiling", "Ceiling"} };
		
	/**
	 * Print report for all rtos
	 */
	public static String printReport(Schedulability sched) {
		TaskSet tasks = sched.getTaskSet();
		String system =	DataPath.removeSlash(DataPath.removeSlash(DataPath.splitPath(tasks.getSystem())[0]));

		StringBuffer totalRisp = new StringBuffer("\nSystem: " 
				+ system
				+ "\nMode: " + DataPath.removeSlash(tasks.getMode()));

		// add not mapped tasks
		if (tasks.getPrefixNumber() >0 && tasks.getSize(0)>0) {
			totalRisp.append("\n\nNot mapped tasks: \n");
			for (int j=0; j<tasks.getSize(0); j++) {
				totalRisp.append("\t"+tasks.getItem(0,j).getName() + "\n");
			}
			totalRisp.append("\n");
		}

		for (int rtosId=1; rtosId< tasks.getPrefixNumber(); rtosId++) {
			totalRisp.append("\n" + printReport(sched, rtosId));
		}
		return totalRisp.toString();
	}

	/**
	 * Print report for given rtos
	 */
	public static String printReport(Schedulability sched, int rtosId) {
		TaskSet tasks = sched.getTaskSet();
		GenResList mutex = sched.getResourceSet();
//		String system = DataPath.removeSlash(DataPath.removeSlash(DataPath.splitPath(tasks.getSystem())[0]));
		final String SPAZI = "                              "; 

		if (rtosId<1 || rtosId>tasks.getPrefixNumber() || tasks.getSize(rtosId) == 0) {
			return "";	// next rtos
		}
//		TreeInterface ti = tasks.getVarTree().newTreeInterface();
			
		StringBuffer risp = new StringBuffer();
		String rtos = DataPath.removeSlash(tasks.getPrefix(rtosId));

		//String schedPath = "" + S + system + S + "Schedulability" + S +"SchedulingScenarioList" + S + DataPath.makeSlashedId(tasks.getMode()) + S ; 
		//String cpuSchedPath = schedPath + "CpuSchedList" + S +  DataPath.makeSlashedId(rtos) + S;
		
		risp.append("\nRTOS: " + rtos + "\nTasks:");
		String pre = " ";
		for (int j =0; j<tasks.getSize(rtosId); j++) {
			risp.append(pre +tasks.getItem(rtosId, j).getName());
			pre = ", ";
		}
		
		String[][] cpu_info = sched.getCpuSched(rtosId-1);
/*
		0{ "System", system }, 
		1{ "CpuRef", cpu }, 
		2{ "ModeRef", mode }, 
		3{ "Utilization", utilization == null ? null : utilization.toString() }, 
		4{ "SpeedFactor", speedFactor == null ? null : speedFactor.toString() }, 
		5{ "Boundary", boundary == null ? null : boundary.toString() }, 
		6{ "Schedulable", "" + schedulable } 
*/		
		risp.append("\n\nGeneral results\n\n"
			+ "Schedulable : " + ("true".equalsIgnoreCase(cpu_info[6][1]) ? "YES" : "NO") + "\n"
			+ "Speed factor: " + (cpu_info[4][1] == null ? "N/A" : cpu_info[4][1] ) + "\n" 
			+ "Load        : " + (cpu_info[3][1] == null ? "N/A" : cpu_info[3][1] ) + "\n"
			+ "\nSummary of results for each task:\n\n" 
			+ "TASK,              WCET, PERIOD, DEADLINE, PRIORITY, OFFSET, Resp. Time, CDELTA, Sched.\n");
			
		// sort tasks before list them
		tasks.sortByPriority();
		// first short report
		for (int j =0; j<tasks.getSize(rtosId); j++) {
			Task task = (Task) tasks.getItem(rtosId, j);
			String pad = task.getName().length() < 17 ? SPAZI.substring(0,17- task.getName().length()) : "";
			String cdelta = "" + task.getProperty("cdelta");
			String offset = "" + task.getProperty("offset");
			risp.append(task.getName() + ", " + pad
					+ task.getProperty("wcet") + ", "
					+ task.getProperty("period") + ", "
					+ task.getProperty("deadline") + ", "
					+ task.getProperty("priority") + ", "
					+ ("".equals(offset) ? "N/A" : offset) + ", "
					+ task.getProperty("ResponseTime") + ", "
					+ ("".equals(cdelta) ? "N/A" : cdelta) + ", "
					+ task.getProperty("schedulable")
			);
			
			risp.append("\n");
		}

		risp.append("\nDetailed Results\n");
		// detailed report
		for (int j =0; j<tasks.getSize(rtosId); j++) {
			Task task = (Task) tasks.getItem(rtosId, j);
			String offset = "" + task.getProperty("offset");
			String cdelta = "" + task.getProperty("cdelta");
			risp.append("Task name: " + task.getName() + "\n\t"
					+ "Type: " + task.getProperty(Task.STR_ACT_TYPE) + "\n\t"
					+ "WCET: " + task.getProperty("wcet") + "\n\t"
					+ "Period: " + task.getProperty("Period") + "\n\t"
					+ "Utilization: " + task.getProperty("Utilization") + "\n\t"
					+ "Deadline: " + task.getProperty("Deadline") + "\n\t"
					+ "Priority: " + task.getProperty("Priority") + "\n\t"
					+ "Offset: " + ("".equals(offset) ? "N/A" : offset) + "\n\t"
					+ "Resource List: "
			);
			
			// resource List
			Enumeration<String> res = task.getAllResources();
			while (res.hasMoreElements()) {
				String resName = (String) res.nextElement();
				risp.append("\n\t\t" + resName + ", ceiling = " + mutex.getItem(0,(mutex.getIndex(0,resName))).getTempProperty("ceiling"));
			}
			
			
			risp.append("\n\t" +
					"Blocking Time: " + task.getProperty("blocking") + "\n\t"
					+ "Response Time: " + task.getProperty("ResponseTime") + "\n\t"
					+ "CDelta: " + ("".equals(cdelta) ? "N/A" : cdelta) + "\n\t"
					+ "Schedulable: " + task.getProperty("Schedulable") + "\n"
					+ "\n"
			);
							
		}
		return risp.toString();

	}
	
	/***/
	public static String startTest(IVarTree vt, String system, int testID, Properties options) {
		return startTest(vt, system, testID, options, null);
	}
	/***/
	public static String startTest(IVarTree vt, String system, int testID, Properties options, Progress progress) {
		return INSTANCE.startTestImpl(vt, system, testID, options, progress);
	}
	
	/**
	 * This function invokes the "real" sched analysis (implemented in anothe class).
	 * @param vt
	 * @param system
	 * @param testID
	 * @param options
	 * @param progress
	 * @return
	 */
	protected abstract String startTestImpl(IVarTree vt, String system, int testID, Properties options, Progress progress);
	
}
