/*
 * Created on 16-ott-2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.eu.evidence.rtdruid.test.modules.jscan.common;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import com.eu.evidence.rtdruid.internal.modules.jscan.AbstractCompleteTest;
import com.eu.evidence.rtdruid.internal.modules.jscan.common.StackOptimization;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.abstractions.old.TaskSet;

/**
 * @author mvc
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class StackOptimizationTest extends AbstractCompleteTest{
	
	String[] example1 = {
			// input
			"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
			"<SYSTEM Name=\"strano\">" +
		"<ARCHITECTURAL>" +
			"<ECU Name=\"ECU0\">" +
				"<CPU Name=\"CPU0\" Model=\"ARM7\">" +
					"<RTOS Name=\"CPU0.erika\">" +
					"</RTOS>" +
				"</CPU>" +
				"<CPU Name=\"CPU1\" Model=\"ARM7\">" +
					"<RTOS Name=\"CPU1.erika\">" +
					"</RTOS>" +
			    "</CPU>" +
			"</ECU>" +

			"<!-- Elenco task -->" +
			"<TASK Name=\"DeviceReader\" Type=\"task\">" +

				"<SCHEDULING Priority=\"4\" />" +
				"<SCHEDULING Threshold=\"4\" />" +
				
				"<ACTIVATION Type=\"periodic\" Period=\"40ms\" />" +

				"<RESOURCEREF>" +
					"<METHODREF Name=\"Res8.read\" MethodName=\"Res8/read\" />" +
				"</RESOURCEREF>" +

			"</TASK>" +

			"<TASK Name=\"QueueHandler\" Type=\"task\">" +
				"<SCHEDULING Priority=\"3\" />" +
				"<SCHEDULING Threshold=\"4\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"45ms\" />" +

				"<RESOURCEREF>" +
					"<METHODREF Name=\"Res12.read\" MethodName=\"Res12/read\" />" +
				"</RESOURCEREF>" +

			"</TASK>" +

			"<TASK Name=\"Writer\" Type=\"task\">" +
				"<SCHEDULING Priority=\"2\" />" +
				"<SCHEDULING Threshold=\"2\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"45ms\" />" +

				"<RESOURCEREF>" +
					"<METHODREF Name=\"Res8.write\"  MethodName=\"Res8/write\" />" +
					"<METHODREF Name=\"Res12.write\" MethodName=\"Res12/write\" />" +
					"<METHODREF Name=\"Res6.read\"   MethodName=\"Res6/read\" />" +
				"</RESOURCEREF>" +

			"</TASK>" +
			"<TASK Name=\"Driver\" Type=\"task\">" +
				"<SCHEDULING Priority=\"1\" />" +
				"<SCHEDULING Threshold=\"3\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"100ms\" />" +

				"<RESOURCEREF>" +
					"<METHODREF Name=\"Res6.write\" MethodName=\"Res6/write\" />" +
				"</RESOURCEREF>" +
			"</TASK>" +			
			
			"<!-- Elenco task -->" +
			"<TASK Name=\"Task0\" Type=\"task\">" +

				"<SCHEDULING Priority=\"4\" />" +
				"<SCHEDULING Threshold=\"4\" />" +
				
				"<ACTIVATION Type=\"periodic\" Period=\"40ms\" />" +

				"<RESOURCEREF>" +
					"<METHODREF Name=\"Res8.read\" MethodName=\"Res8/read\" />" +
				"</RESOURCEREF>" +

			"</TASK>" +

			"<TASK Name=\"Task1\" Type=\"task\">" +
				"<SCHEDULING Priority=\"3\" />" +
				"<SCHEDULING Threshold=\"4\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"45ms\" />" +

				"<RESOURCEREF>" +
					"<METHODREF Name=\"Res12.read\" MethodName=\"Res12/read\" />" +
				"</RESOURCEREF>" +

			"</TASK>" +

			"<TASK Name=\"Task2\" Type=\"task\">" +
				"<SCHEDULING Priority=\"2\" />" +
				"<SCHEDULING Threshold=\"2\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"45ms\" />" +

				"<RESOURCEREF>" +
					"<METHODREF Name=\"Res8.write\"  MethodName=\"Res8/write\" />" +
					"<METHODREF Name=\"Res12.write\" MethodName=\"Res12/write\" />" +
					"<METHODREF Name=\"Res6.read\"   MethodName=\"Res6/read\" />" +
				"</RESOURCEREF>" +

			"</TASK>" +
			"<TASK Name=\"Task3\" Type=\"task\">" +
				"<SCHEDULING Priority=\"1\" />" +
				"<SCHEDULING Threshold=\"3\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"100ms\" />" +

				"<RESOURCEREF>" +
					"<METHODREF Name=\"Res6.write\" MethodName=\"Res6/write\" />" +
				"</RESOURCEREF>" +
			"</TASK>" +
			
			"<RESOURCE Name=\"Res2\">" +
			"<MUTEXREF MutexName=\"Mutex2\"/>" +
		"</RESOURCE>" +

		"<RESOURCE Name=\"Res6\">" +
			"<MUTEXREF MutexName=\"Mutex6\"/>" +
		"</RESOURCE>" +

		"<RESOURCE Name=\"Res6b\">" +
			"<MUTEXREF MutexName=\"Mutex6b\"/>" +
		"</RESOURCE>" +

		"<RESOURCE Name=\"Res8\">" +
			"<MUTEXREF MutexName=\"Mutex8\"/>" +
		"</RESOURCE>" +

		"<RESOURCE Name=\"Res12\">" +
			"<MUTEXREF MutexName=\"Mutex12\"/>" +
		"</RESOURCE>" +
		
			"<!-- Elenco mutex -->" +
			"<MUTEX Name=\"Mutex1\"/>" +
			"<MUTEX Name=\"Mutex2\"/>" +
			"<MUTEX Name=\"Mutex6\"/>" +
			"<MUTEX Name=\"Mutex6b\"/>" +
			"<MUTEX Name=\"Mutex8\"/>" +
			"<MUTEX Name=\"Mutex12\"/>" +

		"</ARCHITECTURAL>" +
	"<!-- " +
	"-->" +

		"<MAPPING>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"DeviceReader\"/>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"QueueHandler\"/>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"Writer\"/>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"Driver\"/>" +
			"<TASKMAP rtosRef =\"CPU1.erika\"    TaskRef=\"Task0\"/>" +
			"<TASKMAP rtosRef =\"CPU1.erika\"    TaskRef=\"Task1\"/>" +
			"<TASKMAP rtosRef =\"CPU1.erika\"    TaskRef=\"Task2\"/>" +
			"<TASKMAP rtosRef =\"CPU1.erika\"    TaskRef=\"Task3\"/>" +
		"</MAPPING>" +

		"<ANNOTATION>" +
		"<!-- TASK wcet -->" +
			"<EXECTIME Ref=\"DeviceReader\" Type=\"TASK\">" +
				"<WORST Value=\"13ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"QueueHandler\" Type=\"TASK\">" +
				"<WORST Value=\"6ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"Writer\" Type=\"TASK\">" +
				"<WORST Value=\"12ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"Driver\" Type=\"TASK\">" +
				"<WORST Value=\"21ms\" />" +
			"</EXECTIME>" +

			"<!-- Resource wcet -->" +

			"<EXECTIME Ref=\"Res6/write\" Type=\"RESOURCE_METHOD\">" +
				"<WORST Value=\"6ms\" />" +
			"</EXECTIME>" +
			"<EXECTIME Ref=\"Res6/read\" Type=\"RESOURCE_METHOD\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"Res6b/read\" Type=\"RESOURCE_METHOD\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +
			"<EXECTIME Ref=\"Res6b/write\" Type=\"RESOURCE_METHOD\">" +
				"<WORST Value=\"6ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"Res2/read\" Type=\"RESOURCE_METHOD\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +
			"<EXECTIME Ref=\"Res2/write\" Type=\"RESOURCE_METHOD\">" +
				"<WORST Value=\"2ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"Res12/read\" Type=\"RESOURCE_METHOD\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +
			"<EXECTIME Ref=\"Res12/write\" Type=\"RESOURCE_METHOD\">" +
				"<WORST Value=\"12ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"Res8/read\" Type=\"RESOURCE_METHOD\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +
			"<EXECTIME Ref=\"Res8/write\" Type=\"RESOURCE_METHOD\">" +
				"<WORST Value=\"8ms\" />" +
			"</EXECTIME>" +

		"</ANNOTATION>" +

	"</SYSTEM>",
			
			// results
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
			"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
			"<SYSTEM xmlns:rtdruid.vartree.data=\"http://rtdruid.vartree.data\" Name=\"strano\">" +
			"<ARCHITECTURAL>" +
			"<ECU Name=\"ECU0\">" +
			"<CPU Name=\"CPU0\" Model=\"ARM7\">" +
			"<RTOS Name=\"CPU0.erika\"/>" +
			"</CPU>" +
			"</ECU>" +
			"<TASK Name=\"DeviceReader\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"4\" Priority=\"4\"/>" +
			"<SCHEDULING Priority=\"4\"/>" +
			"<ACTIVATION Deadline=\"40.0ms\" Period=\"40.0ms\" Type=\"periodic\"/>" +
			"<RESOURCEREF>" +
			"<METHODREF Name=\"unused\" MethodName=\"Res8/read\"/>" +
			"</RESOURCEREF>" +
			"</TASK>" +
			"<TASK Name=\"QueueHandler\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"3\" Priority=\"3\"/>" +
			"<SCHEDULING Priority=\"3\"/>" +
			"<ACTIVATION Deadline=\"45.0ms\" Period=\"45.0ms\" Type=\"periodic\"/>" +
			"<RESOURCEREF>" +
			"<METHODREF Name=\"unused\" MethodName=\"Res12/read\"/>" +
			"</RESOURCEREF>" +
			"</TASK>" +
			"<TASK Name=\"Writer\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"2\" Priority=\"2\"/>" +
			"<SCHEDULING Priority=\"2\"/>" +
			"<ACTIVATION Deadline=\"45.0ms\" Period=\"45.0ms\" Type=\"periodic\"/>" +
			"<RESOURCEREF>" +
			"<METHODREF Name=\"unused\" MethodName=\"Res8/write\"/>" +
			"<METHODREF Name=\"unused\" MethodName=\"Res12/write\"/>" +
			"<METHODREF Name=\"unused\" MethodName=\"Res6/read\"/>" +
			"</RESOURCEREF>" +
			"</TASK>" +
			"<TASK Name=\"Driver\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"1\" Priority=\"1\"/>" +
			"<SCHEDULING Priority=\"1\"/>" +
			"<ACTIVATION Deadline=\"100.0ms\" Period=\"100.0ms\" Type=\"periodic\"/>" +
			"<RESOURCEREF>" +
			"<METHODREF Name=\"unused\" MethodName=\"Res6/write\"/>" +
			"</RESOURCEREF>" +
			"</TASK>" +
			"<RESOURCE Name=\"Res2\">" +
			"<MUTEXREF MutexName=\"Mutex2\"/>" +
			"</RESOURCE>" +
			"<RESOURCE Name=\"Res6\">" +
			"<MUTEXREF MutexName=\"Mutex6\"/>" +
			"</RESOURCE>" +
			"<RESOURCE Name=\"Res6b\">" +
			"<MUTEXREF MutexName=\"Mutex6b\"/>" +
			"</RESOURCE>" +
			"<RESOURCE Name=\"Res8\">" +
			"<MUTEXREF MutexName=\"Mutex8\"/>" +
			"</RESOURCE>" +
			"<RESOURCE Name=\"Res12\">" +
			"<MUTEXREF MutexName=\"Mutex12\"/>" +
			"</RESOURCE>" +
			"<MUTEX Name=\"Mutex1\"/>" +
			"<MUTEX Name=\"Mutex2\"/>" +
			"<MUTEX Name=\"Mutex6\"/>" +
			"<MUTEX Name=\"Mutex6b\"/>" +
			"<MUTEX Name=\"Mutex8\"/>" +
			"<MUTEX Name=\"Mutex12\"/>" +
			"</ARCHITECTURAL>" +
			"<MAPPING>" +
			"<TASKMAP rtosRef=\"CPU0.erika\" TaskRef=\"DeviceReader\"/>" +
			"<TASKMAP rtosRef=\"CPU0.erika\" TaskRef=\"QueueHandler\"/>" +
			"<TASKMAP rtosRef=\"CPU0.erika\" TaskRef=\"Writer\"/>" +
			"<TASKMAP rtosRef=\"CPU0.erika\" TaskRef=\"Driver\"/>" +
			"</MAPPING>" +
			"<ANNOTATION>" +
			"<EXECTIME Type=\"TASK\" Ref=\"DeviceReader\">" +
			"<WORST Value=\"13.0ms\"/>" +
			"</EXECTIME>" +
			"<EXECTIME Type=\"TASK\" Ref=\"QueueHandler\">" +
			"<WORST Value=\"6.0ms\"/>" +
			"</EXECTIME>" +
			"<EXECTIME Type=\"TASK\" Ref=\"Writer\">" +
			"<WORST Value=\"12.0ms\"/>" +
			"</EXECTIME>" +
			"<EXECTIME Type=\"TASK\" Ref=\"Driver\">" +
			"<WORST Value=\"21.0ms\"/>" +
			"</EXECTIME>" +
			"<EXECTIME Type=\"RESOURCE_METHOD\" Ref=\"Res6/write\">" +
			"<WORST Value=\"6.0ms\"/>" +
			"</EXECTIME>" +
			"<EXECTIME Type=\"RESOURCE_METHOD\" Ref=\"Res6/read\">" +
			"<WORST Value=\"1.0ms\"/>" +
			"</EXECTIME>" +
			"<EXECTIME Type=\"RESOURCE_METHOD\" Ref=\"Res6b/read\">" +
			"<WORST Value=\"1.0ms\"/>" +
			"</EXECTIME>" +
			"<EXECTIME Type=\"RESOURCE_METHOD\" Ref=\"Res6b/write\">" +
			"<WORST Value=\"6.0ms\"/>" +
			"</EXECTIME>" +
			"<EXECTIME Type=\"RESOURCE_METHOD\" Ref=\"Res2/read\">" +
			"<WORST Value=\"1.0ms\"/>" +
			"</EXECTIME>" +
			"<EXECTIME Type=\"RESOURCE_METHOD\" Ref=\"Res2/write\">" +
			"<WORST Value=\"2.0ms\"/>" +
			"</EXECTIME>" +
			"<EXECTIME Type=\"RESOURCE_METHOD\" Ref=\"Res12/read\">" +
			"<WORST Value=\"1.0ms\"/>" +
			"</EXECTIME>" +
			"<EXECTIME Type=\"RESOURCE_METHOD\" Ref=\"Res12/write\">" +
			"<WORST Value=\"12.0ms\"/>" +
			"</EXECTIME>" +
			"<EXECTIME Type=\"RESOURCE_METHOD\" Ref=\"Res8/read\">" +
			"<WORST Value=\"1.0ms\"/>" +
			"</EXECTIME>" +
			"<EXECTIME Type=\"RESOURCE_METHOD\" Ref=\"Res8/write\">" +
			"<WORST Value=\"8.0ms\"/>" +
			"</EXECTIME>" +
			"</ANNOTATION>" +
			"<SCHEDULABILITY>" +
			"<SCHEDULINGSCENARIO>" +
			"<CPUSCHED CpuRef=\"CPU0.erika\" Utilization=\"0.935\" SpeedFactor=\"1.0375\" Boundary=\"0.7568284600108841\" Schedulable=\"false\"/>" +
			"<TASKSCHED TaskRef=\"DeviceReader\" Utilization=\"0.325\" CDelta=\"-1.5\" Schedulable=\"true\" ResponseTime=\"21.0ms\"/>" +
			"<TASKSCHED TaskRef=\"QueueHandler\" Utilization=\"0.13333333333333333\" CDelta=\"-1.5\" Schedulable=\"true\" ResponseTime=\"31.0ms\"/>" +
			"<TASKSCHED TaskRef=\"Writer\" Utilization=\"0.26666666666666666\" CDelta=\"-1.5\" Schedulable=\"true\" ResponseTime=\"37.0ms\"/>" +
			"<TASKSCHED TaskRef=\"Driver\" Utilization=\"0.21\" CDelta=\"-3.0\" Schedulable=\"false\" ResponseTime=\"114.0ms\"/>" +
			"</SCHEDULINGSCENARIO>" +
			"</SCHEDULABILITY>" +
			"</SYSTEM>"
		};

		
		@Test
		@Ignore("Missing stack informations in the input example")
		public void test1() throws IOException {
			IVarTree vt =Vt2StringUtilities.loadString(example1[0]);
			
			String system = (vt.newTreeInterface()).getAllName(null, "System")[0];
			
			TaskSet tset = new TaskSet(vt, system, null);

			StackOptimization opt = new StackOptimization(tset);
			
			int[] maxStack = opt.calculateMaximumStackSize();
			opt.print();
		}

}
