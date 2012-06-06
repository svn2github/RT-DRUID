/*
 * Created on Jul 12, 2004
 *
 * $ID$
 */
package com.eu.evidence.rtdruid.internal.modules.jscan;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;


import java.io.IOException;

import org.eclipse.emf.common.command.CompoundCommand;
import org.junit.Test;

import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;

/**
 * @author Nicola Serreli
 */
public class CompleteTest1 extends AbstractCompleteTest {
	
	public final static String[] example1 = {
		// input
		"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
		"<SYSTEM Name=\"strano\">" +
	"<ARCHITECTURAL>" +
		"<ECU Name=\"ECU0\">" +
			"<CPU Name=\"CPU0\" Model=\"ARM7\">" +
				"<RTOS Name=\"CPU0.erika\">" +
				"</RTOS>" +
			"</CPU>" +
		"</ECU>" +

		"<!-- Elenco task -->" +
		"<TASK Name=\"DeviceReader\" Type=\"task\">" +

			"<SCHEDULING Priority=\"4\" />" +

			"<ACTIVATION Type=\"periodic\" Period=\"40ms\" />" +

			"<RESOURCEREF>" +
				"<METHODREF Name=\"Res8.read\" MethodName=\"Res8/read\" />" +
			"</RESOURCEREF>" +

		"</TASK>" +

		"<TASK Name=\"QueueHandler\" Type=\"task\">" +
			"<SCHEDULING Priority=\"3\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"45ms\" />" +

			"<RESOURCEREF>" +
				"<METHODREF Name=\"Res12.read\" MethodName=\"Res12/read\" />" +
			"</RESOURCEREF>" +

		"</TASK>" +

		"<TASK Name=\"Writer\" Type=\"task\">" +
			"<SCHEDULING Priority=\"2\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"45ms\" />" +

			"<RESOURCEREF>" +
				"<METHODREF Name=\"Res8.write\"  MethodName=\"Res8/write\" />" +
				"<METHODREF Name=\"Res12.write\" MethodName=\"Res12/write\" />" +
				"<METHODREF Name=\"Res6.read\"   MethodName=\"Res6/read\" />" +
			"</RESOURCEREF>" +

		"</TASK>" +
		"<TASK Name=\"Driver\" Type=\"task\">" +
			"<SCHEDULING Priority=\"1\" />" +
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
//		"<SCHEDULING PreemptionGroupName=\"4\" Priority=\"4\"/>" +
		"<SCHEDULING Priority=\"4\"/>" +
		"<ACTIVATION Deadline=\"40.0ms\" Period=\"40.0ms\" Type=\"periodic\"/>" +
		"<RESOURCEREF>" +
		"<METHODREF Name=\"unused\" MethodName=\"Res8/read\"/>" +
		"</RESOURCEREF>" +
		"</TASK>" +
		"<TASK Name=\"QueueHandler\" Type=\"task\">" +
//		"<SCHEDULING PreemptionGroupName=\"3\" Priority=\"3\"/>" +
		"<SCHEDULING Priority=\"3\"/>" +
		"<ACTIVATION Deadline=\"45.0ms\" Period=\"45.0ms\" Type=\"periodic\"/>" +
		"<RESOURCEREF>" +
		"<METHODREF Name=\"unused\" MethodName=\"Res12/read\"/>" +
		"</RESOURCEREF>" +
		"</TASK>" +
		"<TASK Name=\"Writer\" Type=\"task\">" +
//		"<SCHEDULING PreemptionGroupName=\"2\" Priority=\"2\"/>" +
		"<SCHEDULING Priority=\"2\"/>" +
		"<ACTIVATION Deadline=\"45.0ms\" Period=\"45.0ms\" Type=\"periodic\"/>" +
		"<RESOURCEREF>" +
		"<METHODREF Name=\"unused\" MethodName=\"Res8/write\"/>" +
		"<METHODREF Name=\"unused\" MethodName=\"Res12/write\"/>" +
		"<METHODREF Name=\"unused\" MethodName=\"Res6/read\"/>" +
		"</RESOURCEREF>" +
		"</TASK>" +
		"<TASK Name=\"Driver\" Type=\"task\">" +
//		"<SCHEDULING PreemptionGroupName=\"1\" Priority=\"1\"/>" +
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
	public void test1() throws IOException {
		IVarTree vt =Vt2StringUtilities.loadString(example1[0]);
		
		String system = (vt.newTreeInterface()).getAllName(null, "System")[0];

		JScan.startTest(vt, system, JScan.NO_OFFSET_ID, null);
		
		vt.newTreeInterface().setValue(system+IVarTree.SEPARATOR
				+"Schedulability"+IVarTree.SEPARATOR
				+"SchedulingScenarioList"+IVarTree.SEPARATOR
				+DataPath.makeSlashedId((String)null)+IVarTree.SEPARATOR
				+"Reports"+IVarTree.SEPARATOR
				, (IVariable) null);
		check(vt, Vt2StringUtilities.loadString(example1[1]));
	}

	@Test
	public void test1Undo() throws IOException {
		IVarTree vt =Vt2StringUtilities.loadString(example1[0]);
		
		String system = (vt.newTreeInterface()).getAllName(null, "System")[0];

		//vt.startComp();
		assertNull(vt.getCommandStack().getMostRecentCommand());
		assertNull(vt.getCommandStack().getUndoCommand());
		assertNull(vt.getCommandStack().getRedoCommand());

		JScan.startTest(vt, system, JScan.NO_OFFSET_ID, null);

		assertNull(vt.getCurrentTransaction());
		CompoundCommand com = (CompoundCommand) vt.getCommandStack().getMostRecentCommand();
		assertNotNull(com);
		assertSame(vt.getCommandStack().getUndoCommand() , com);
		assertNull(vt.getCommandStack().getRedoCommand());

		vt.newTreeInterface().setValue(system+IVarTree.SEPARATOR
				+"Schedulability"+IVarTree.SEPARATOR
				+"SchedulingScenarioList"+IVarTree.SEPARATOR
				+DataPath.makeSlashedId((String)null)+IVarTree.SEPARATOR
				+"Reports"+IVarTree.SEPARATOR
				, (IVariable) null);
		check(vt, Vt2StringUtilities.loadString(example1[1]));
		
		vt.getCommandStack().undo();
		vt.getCommandStack().undo();
		check(vt, Vt2StringUtilities.loadString(example1[0]));
		assertNull(vt.getCommandStack().getUndoCommand());
		assertSame(vt.getCommandStack().getRedoCommand() , com);
	}

	
	@Test
	public void test1AutoUndo() throws IOException {
		String example1bis =
			"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
			"<SYSTEM Name=\"strano\">" +
			"<ARCHITECTURAL>" +
				"<ECU Name=\"ECU0\">" +
					"<CPU Name=\"CPU0\" Model=\"ARM7\">" +
						"<RTOS Name=\"CPU0.erika\">" +
						"</RTOS>" +
					"</CPU>" +
				"</ECU>" +
	
				"<!-- Elenco task -->" +
				"<TASK Name=\"DeviceReader\" Type=\"task\">" +
					"<SCHEDULING Priority=\"4\" />" +
					"<ACTIVATION Type=\"periodic\" Period=\"40ms\" />" +
				"</TASK>" +
	
				"<TASK Name=\"QueueHandler\" Type=\"task\">" +
					"<SCHEDULING Priority=\"3\" />" +
					"<ACTIVATION Type=\"periodic\" Period=\"45ms\" />" +
				"</TASK>" +
	
				"<TASK Name=\"Writer\" Type=\"task\">" +
					"<SCHEDULING Priority=\"2\" />" +
					"<ACTIVATION Type=\"periodic\" Period=\"45ms\" />" +
				"</TASK>" +
				"<TASK Name=\"Driver\" Type=\"task\">" +
					"<SCHEDULING Priority=\"1\" />" +
					"<ACTIVATION Type=\"periodic\" Period=\"100ms\" />" +
				"</TASK>" +
			"</ARCHITECTURAL>" +
	
			"<MAPPING>" +
				"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"DeviceReader\"/>" +
				"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"QueueHandler\"/>" +
				"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"Writer\"/>" +
				"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"Driver\"/>" +
			"</MAPPING>" +
	
		"</SYSTEM>";
		
			IVarTree vt =Vt2StringUtilities.loadString(example1bis);
			
			String system = (vt.newTreeInterface()).getAllName(null, "System")[0];

			//vt.startComp();
			assertNull(vt.getCommandStack().getMostRecentCommand());
			assertNull(vt.getCommandStack().getUndoCommand());
			assertNull(vt.getCommandStack().getRedoCommand());

			boolean ok = false;
			try {
				JScan.startTest(vt, system, JScan.NO_OFFSET_ID, null);
			} catch (Exception e) {
				ok = true;
			}
			assertTrue(ok);

			assertNull(vt.getCurrentTransaction());
			assertNull(vt.getCommandStack().getUndoCommand());
			assertNull(vt.getCommandStack().getRedoCommand());
			assertNull(vt.getCommandStack().getMostRecentCommand());

			check(vt, Vt2StringUtilities.loadString(example1bis));
		}

	/****/
	String[] example2 = {
			// input
			"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
			"<SYSTEM Name=\"strano\">" +
		"<ARCHITECTURAL>" +
			"<ECU Name=\"ECU0\">" +
				"<CPU Name=\"CPU0\" Model=\"ARM7\">" +
					"<RTOS Name=\"CPU0.erika\">" +
					"</RTOS>" +
				"</CPU>" +
			"</ECU>" +

			"<!-- Elenco task -->" +
			"<TASK Name=\"DeviceReader\" Type=\"task\">" +

				"<SCHEDULING Priority=\"4\" />" +

				"<ACTIVATION Type=\"periodic\" Period=\"40ms\" />" +

				"<RESOURCEREF>" +
					"<METHODREF Name=\"Res8.read\" MethodName=\"Res8/read\" />" +
				"</RESOURCEREF>" +

			"</TASK>" +

			"<TASK Name=\"QueueHandler\" Type=\"task\">" +
				"<SCHEDULING Priority=\"3\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"45ms\" />" +

				"<RESOURCEREF>" +
					"<METHODREF Name=\"Res12.read\" MethodName=\"Res12/read\" />" +
				"</RESOURCEREF>" +

			"</TASK>" +

			"<TASK Name=\"Writer\" Type=\"task\">" +
				"<SCHEDULING Priority=\"2\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"45ms\" />" +

				"<RESOURCEREF>" +
					"<METHODREF Name=\"Res8.write\"  MethodName=\"Res8/write\" />" +
					"<METHODREF Name=\"Res12.write\" MethodName=\"Res12/write\" />" +
					"<METHODREF Name=\"Res6.read\"   MethodName=\"Res6/read\" />" +
				"</RESOURCEREF>" +

			"</TASK>" +
			"<TASK Name=\"Driver\" Type=\"task\">" +
				"<SCHEDULING Priority=\"1\" />" +
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
		"</MAPPING>" +

		"<ANNOTATION>" +
		"<!-- TASK wcet -->" +
			"<EXECTIME Ref=\"DeviceReader\" Type=\"TASK\">" +
				"<WORST Value=\"12ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"QueueHandler\" Type=\"TASK\">" +
				"<WORST Value=\"6ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"Writer\" Type=\"TASK\">" +
				"<WORST Value=\"11.5ms\" />" +
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
			"<WORST Value=\"12.0ms\"/>" +
			"</EXECTIME>" +
			"<EXECTIME Type=\"TASK\" Ref=\"QueueHandler\">" +
			"<WORST Value=\"6.0ms\"/>" +
			"</EXECTIME>" +
			"<EXECTIME Type=\"TASK\" Ref=\"Writer\">" +
			"<WORST Value=\"11.5ms\"/>" +
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
			"<CPUSCHED CpuRef=\"CPU0.erika\" Utilization=\"0.8988888888888888\" SpeedFactor=\"1.0\" Boundary=\"0.7568284600108841\" Schedulable=\"true\"/>" +
			"<TASKSCHED TaskRef=\"DeviceReader\" Utilization=\"0.3\" CDelta=\"-0.0\" Schedulable=\"true\" ResponseTime=\"20.0ms\"/>" +
			"<TASKSCHED TaskRef=\"QueueHandler\" Utilization=\"0.13333333333333333\" CDelta=\"-0\" Schedulable=\"true\" ResponseTime=\"30.0ms\"/>" +
			"<TASKSCHED TaskRef=\"Writer\" Utilization=\"0.25555555555555554\" CDelta=\"-0.0\" Schedulable=\"true\" ResponseTime=\"35.5ms\"/>" +
			"<TASKSCHED TaskRef=\"Driver\" Utilization=\"0.21\" CDelta=\"-0.0\" Schedulable=\"true\" ResponseTime=\"80.0ms\"/>" +
			"</SCHEDULINGSCENARIO>" +
			"</SCHEDULABILITY>" +
			"</SYSTEM>"
		};

	@Test
	public void test2() throws IOException {
		IVarTree vt = Vt2StringUtilities.loadString(example2[0]);
		
		String system = (vt.newTreeInterface()).getAllName(null, "System")[0];

		JScan.startTest(vt, system, JScan.NO_OFFSET_ID, null);
		
		vt.newTreeInterface().setValue(system+IVarTree.SEPARATOR
				+"Schedulability"+IVarTree.SEPARATOR
				+"SchedulingScenarioList"+IVarTree.SEPARATOR
				+DataPath.makeSlashedId((String)null)+IVarTree.SEPARATOR
				+"Reports"+IVarTree.SEPARATOR
				, (IVariable) null);
		check(vt, Vt2StringUtilities.loadString(example2[1]));
	}
	
	/**
	 * Example in bug 223
	 */
	String[] example3 = {
			// input
			"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
			"<SYSTEM Name=\"hp_test1 (bug 223)\">" +
		"<ARCHITECTURAL>" +
			"<ECU Name=\"ECU0\">" +
				"<CPU Name=\"CPU0\" Model=\"ARM7\">" +
					"<RTOS Name=\"CPU0.erika\">" +
					"</RTOS>" +
				"</CPU>" +
			"</ECU>" +

			"<!-- Elenco task -->" +
			"<TASK Name=\"t1\" Type=\"task\">" +
				"<SCHEDULING Priority=\"3\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"4ms\" />" +
			"</TASK>" +

			"<TASK Name=\"t2\" Type=\"task\">" +
				"<SCHEDULING Priority=\"2\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"5ms\" Deadline=\"3ms\"/>" +
			"</TASK>" +

			"<TASK Name=\"t3\" Type=\"task\">" +
				"<SCHEDULING Priority=\"4\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"6ms\" />" +
			"</TASK>" +
			
			"<TASK Name=\"t4\" Type=\"task\">" +
				"<SCHEDULING Priority=\"1\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"8ms\" />" +
			"</TASK>" +
			
		"</ARCHITECTURAL>" +
	"<!-- " +
	"-->" +

		"<MAPPING>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t1\"/>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t2\"/>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t3\"/>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t4\"/>" +
		"</MAPPING>" +

		"<ANNOTATION>" +
		"<!-- TASK wcet -->" +
			"<EXECTIME Ref=\"t1\" Type=\"TASK\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"t2\" Type=\"TASK\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"t3\" Type=\"TASK\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"t4\" Type=\"TASK\">" +
				"<WORST Value=\"2ms\" />" +
			"</EXECTIME>" +

		"</ANNOTATION>" +

	"</SYSTEM>",
			
			// results
	"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
	"<SYSTEM Name=\"hp_test1 (bug 223)\">" +
	"<ARCHITECTURAL>" +
		"<ECU Name=\"ECU0\">" +
			"<CPU Name=\"CPU0\" Model=\"ARM7\">" +
				"<RTOS Name=\"CPU0.erika\">" +
				"</RTOS>" +
			"</CPU>" +
		"</ECU>" +

		"<!-- Elenco task -->" +
		"<TASK Name=\"t1\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"3\" Priority=\"3\" />" +
			"<SCHEDULING Priority=\"3\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"4ms\" Deadline=\"4ms\" />" +
		"</TASK>" +

		"<TASK Name=\"t2\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"2\" Priority=\"2\" />" +
			"<SCHEDULING Priority=\"2\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"5ms\" Deadline=\"3ms\"/>" +
		"</TASK>" +

		"<TASK Name=\"t3\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"4\" Priority=\"4\" />" +
			"<SCHEDULING Priority=\"4\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"6ms\" Deadline=\"6ms\"/>" +
		"</TASK>" +
		
		"<TASK Name=\"t4\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"1\" Priority=\"1\" />" +
			"<SCHEDULING Priority=\"1\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"8ms\" Deadline=\"8ms\"/>" +
		"</TASK>" +
		
	"</ARCHITECTURAL>" +

	"<MAPPING>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t1\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t2\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t3\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t4\"/>" +
	"</MAPPING>" +

	"<ANNOTATION>" +
	"<!-- TASK wcet -->" +
		"<EXECTIME Ref=\"t1\" Type=\"TASK\">" +
			"<WORST Value=\"1ms\" />" +
		"</EXECTIME>" +

		"<EXECTIME Ref=\"t2\" Type=\"TASK\">" +
			"<WORST Value=\"1ms\" />" +
		"</EXECTIME>" +

		"<EXECTIME Ref=\"t3\" Type=\"TASK\">" +
			"<WORST Value=\"1ms\" />" +
		"</EXECTIME>" +

		"<EXECTIME Ref=\"t4\" Type=\"TASK\">" +
			"<WORST Value=\"2ms\" />" +
		"</EXECTIME>" +

	"</ANNOTATION>" +

	"<SCHEDULABILITY>" +
	"<SCHEDULINGSCENARIO>" +
	"<CPUSCHED CpuRef=\"CPU0.erika\" Utilization=\"0.8666666666666667\" SpeedFactor=\"1.0\" Boundary=\"0.7568284600108841\" Schedulable=\"true\"/>" +
	"<TASKSCHED TaskRef=\"t1\" Utilization=\"0.25\" CDelta=\"-0.0\" Schedulable=\"true\" ResponseTime=\"2ms\"/>" +
	"<TASKSCHED TaskRef=\"t2\" Utilization=\"0.2\" CDelta=\"-0\" Schedulable=\"true\" ResponseTime=\"3ms\"/>" +
	"<TASKSCHED TaskRef=\"t3\" Utilization=\"0.16666666666666666\" CDelta=\"-0.0\" Schedulable=\"true\" ResponseTime=\"1ms\"/>" +
	"<TASKSCHED TaskRef=\"t4\" Utilization=\"0.25\" CDelta=\"-0.0\" Schedulable=\"true\" ResponseTime=\"8.0ms\"/>" +
	"</SCHEDULINGSCENARIO>" +
	"</SCHEDULABILITY>" +
	"</SYSTEM>"
		};

	@Test
	public void test3() throws IOException {
		IVarTree vt =Vt2StringUtilities.loadString(example3[0]);
		
		String system = (vt.newTreeInterface()).getAllName(null, "System")[0];

		JScan.startTest(vt, system, JScan.NO_OFFSET_ID, null);
		
		vt.newTreeInterface().setValue(system+IVarTree.SEPARATOR
				+"Schedulability"+IVarTree.SEPARATOR
				+"SchedulingScenarioList"+IVarTree.SEPARATOR
				+DataPath.makeSlashedId((String)null)+IVarTree.SEPARATOR
				+"Reports"+IVarTree.SEPARATOR
				, (IVariable) null);
		check(vt, Vt2StringUtilities.loadString(example3[1]));
	}

	/**
	 * Example in bug 223
	 */
	String[] example4 = {
			// input
			"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
			"<SYSTEM Name=\"hp_test2 (bug 223)\">" +
		"<ARCHITECTURAL>" +
			"<ECU Name=\"ECU0\">" +
				"<CPU Name=\"CPU0\" Model=\"ARM7\">" +
					"<RTOS Name=\"CPU0.erika\">" +
					"</RTOS>" +
				"</CPU>" +
			"</ECU>" +

			"<!-- Elenco task -->" +
			"<TASK Name=\"t1\" Type=\"task\">" +
				"<SCHEDULING Priority=\"3\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"4ms\" />" +
			"</TASK>" +

			"<TASK Name=\"t2\" Type=\"task\">" +
				"<SCHEDULING Priority=\"2\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"5ms\" Deadline=\"3ms\"/>" +
			"</TASK>" +

			"<TASK Name=\"t3\" Type=\"task\">" +
				"<SCHEDULING Priority=\"4\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"6ms\" />" +
			"</TASK>" +
			
			"<TASK Name=\"t4\" Type=\"task\">" +
				"<SCHEDULING Priority=\"1\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"7ms\" />" +
			"</TASK>" +
			
		"</ARCHITECTURAL>" +
	"<!-- " +
	"-->" +

		"<MAPPING>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t1\"/>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t2\"/>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t3\"/>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t4\"/>" +
		"</MAPPING>" +

		"<ANNOTATION>" +
		"<!-- TASK wcet -->" +
			"<EXECTIME Ref=\"t1\" Type=\"TASK\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"t2\" Type=\"TASK\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"t3\" Type=\"TASK\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"t4\" Type=\"TASK\">" +
				"<WORST Value=\"2ms\" />" +
			"</EXECTIME>" +

		"</ANNOTATION>" +

	"</SYSTEM>",
			
			// results
	"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
	"<SYSTEM Name=\"hp_test2 (bug 223)\">" +
	"<ARCHITECTURAL>" +
		"<ECU Name=\"ECU0\">" +
			"<CPU Name=\"CPU0\" Model=\"ARM7\">" +
				"<RTOS Name=\"CPU0.erika\">" +
				"</RTOS>" +
			"</CPU>" +
		"</ECU>" +

		"<!-- Elenco task -->" +
		"<TASK Name=\"t1\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"3\" Priority=\"3\" />" +
			"<SCHEDULING Priority=\"3\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"4ms\" Deadline=\"4ms\" />" +
		"</TASK>" +

		"<TASK Name=\"t2\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"2\" Priority=\"2\" />" +
			"<SCHEDULING Priority=\"2\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"5ms\" Deadline=\"3ms\"/>" +
		"</TASK>" +

		"<TASK Name=\"t3\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"4\" Priority=\"4\" />" +
			"<SCHEDULING Priority=\"4\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"6ms\" Deadline=\"6ms\"/>" +
		"</TASK>" +
		
		"<TASK Name=\"t4\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"1\" Priority=\"1\" />" +
			"<SCHEDULING Priority=\"1\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"7ms\" Deadline=\"7ms\"/>" +
		"</TASK>" +
		
	"</ARCHITECTURAL>" +

	"<MAPPING>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t1\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t2\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t3\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t4\"/>" +
	"</MAPPING>" +

	"<ANNOTATION>" +
	"<!-- TASK wcet -->" +
		"<EXECTIME Ref=\"t1\" Type=\"TASK\">" +
			"<WORST Value=\"1ms\" />" +
		"</EXECTIME>" +

		"<EXECTIME Ref=\"t2\" Type=\"TASK\">" +
			"<WORST Value=\"1ms\" />" +
		"</EXECTIME>" +

		"<EXECTIME Ref=\"t3\" Type=\"TASK\">" +
			"<WORST Value=\"1ms\" />" +
		"</EXECTIME>" +

		"<EXECTIME Ref=\"t4\" Type=\"TASK\">" +
			"<WORST Value=\"2ms\" />" +
		"</EXECTIME>" +

	"</ANNOTATION>" +

	"<SCHEDULABILITY>" +
	"<SCHEDULINGSCENARIO>" +
	"<CPUSCHED CpuRef=\"CPU0.erika\" Utilization=\"0.9023809523809524\" SpeedFactor=\"1.1428571428571428\" Boundary=\"0.7568284600108841\" Schedulable=\"false\"/>" +
	"<TASKSCHED TaskRef=\"t1\" Utilization=\"0.25\" CDelta=\"-0.5\" Schedulable=\"true\" ResponseTime=\"2ms\"/>" +
	"<TASKSCHED TaskRef=\"t2\" Utilization=\"0.2\" CDelta=\"-0.5\" Schedulable=\"true\" ResponseTime=\"3ms\"/>" +
	"<TASKSCHED TaskRef=\"t3\" Utilization=\"0.16666666666666666\" CDelta=\"-0.5\" Schedulable=\"true\" ResponseTime=\"1ms\"/>" +
	"<TASKSCHED TaskRef=\"t4\" Utilization=\"0.2857142857142857\" CDelta=\"-1.0\" Schedulable=\"false\" ResponseTime=\"8.0ms\"/>" +
	"</SCHEDULINGSCENARIO>" +
	"</SCHEDULABILITY>" +
	"</SYSTEM>"
		};

	@Test
	public void test4() throws IOException {
		IVarTree vt =Vt2StringUtilities.loadString(example4[0]);
		
		String system = (vt.newTreeInterface()).getAllName(null, "System")[0];

		JScan.startTest(vt, system, JScan.NO_OFFSET_ID, null);
		
		vt.newTreeInterface().setValue(system+IVarTree.SEPARATOR
				+"Schedulability"+IVarTree.SEPARATOR
				+"SchedulingScenarioList"+IVarTree.SEPARATOR
				+DataPath.makeSlashedId((String)null)+IVarTree.SEPARATOR
				+"Reports"+IVarTree.SEPARATOR
				, (IVariable) null);
		check(vt, Vt2StringUtilities.loadString(example4[1]));
	}
	
	/**
	 * Example in bug 223
	 */
	String[] example5 = {
			// input
			"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
		"<SYSTEM Name=\"hp_test3 (bug 223)\">" +
		"<ARCHITECTURAL>" +
			"<ECU Name=\"ECU0\">" +
				"<CPU Name=\"CPU0\" Model=\"ARM7\">" +
					"<RTOS Name=\"CPU0.erika\">" +
					"</RTOS>" +
				"</CPU>" +
			"</ECU>" +

			"<!-- Elenco task -->" +
			"<TASK Name=\"t1\" Type=\"task\">" +
				"<SCHEDULING Priority=\"5\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"8ms\" />" +
			"</TASK>" +

			"<TASK Name=\"t2\" Type=\"task\">" +
				"<SCHEDULING Priority=\"4\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"5ms\"/>" +
			"</TASK>" +

			"<TASK Name=\"t3\" Type=\"task\">" +
				"<SCHEDULING Priority=\"3\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"7ms\" />" +
			"</TASK>" +
			
			"<TASK Name=\"t4\" Type=\"task\">" +
				"<SCHEDULING Priority=\"2\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"6ms\" />" +
			"</TASK>" +
			
			"<TASK Name=\"t5\" Type=\"task\">" +
				"<SCHEDULING Priority=\"1\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"10ms\" />" +
			"</TASK>" +

		"</ARCHITECTURAL>" +
	"<!-- " +
	"-->" +

		"<MAPPING>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t1\"/>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t2\"/>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t3\"/>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t4\"/>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t5\"/>" +
		"</MAPPING>" +

		"<ANNOTATION>" +
		"<!-- TASK wcet -->" +
			"<EXECTIME Ref=\"t1\" Type=\"TASK\">" +
				"<WORST Value=\"2ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"t2\" Type=\"TASK\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"t3\" Type=\"TASK\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"t4\" Type=\"TASK\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +
	
			"<EXECTIME Ref=\"t5\" Type=\"TASK\">" +
				"<WORST Value=\"3ms\" />" +
			"</EXECTIME>" +
	
		"</ANNOTATION>" +

	"</SYSTEM>",
			
			// results
	"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
	"<SYSTEM Name=\"hp_test3 (bug 223)\">" +
	"<ARCHITECTURAL>" +
		"<ECU Name=\"ECU0\">" +
			"<CPU Name=\"CPU0\" Model=\"ARM7\">" +
				"<RTOS Name=\"CPU0.erika\">" +
				"</RTOS>" +
			"</CPU>" +
		"</ECU>" +
	
		"<!-- Elenco task -->" +
		"<TASK Name=\"t1\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"5\" Priority=\"5\" />" +
			"<SCHEDULING Priority=\"5\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"8ms\"  Deadline=\"8ms\"/>" +
		"</TASK>" +
	
		"<TASK Name=\"t2\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"4\" Priority=\"4\" />" +
			"<SCHEDULING Priority=\"4\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"5ms\" Deadline=\"5ms\"/>" +
		"</TASK>" +
	
		"<TASK Name=\"t3\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"3\" Priority=\"3\" />" +
			"<SCHEDULING Priority=\"3\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"7ms\"  Deadline=\"7ms\"/>" +
		"</TASK>" +
		
		"<TASK Name=\"t4\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"2\" Priority=\"2\" />" +
			"<SCHEDULING Priority=\"2\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"6ms\"  Deadline=\"6ms\"/>" +
		"</TASK>" +
		
		"<TASK Name=\"t5\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"1\" Priority=\"1\" />" +
			"<SCHEDULING Priority=\"1\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"10ms\"  Deadline=\"10ms\"/>" +
		"</TASK>" +
	
	"</ARCHITECTURAL>" +
	"<!-- " +
	"-->" +
	
	"<MAPPING>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t1\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t2\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t3\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t4\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t5\"/>" +
	"</MAPPING>" +
	
	"<ANNOTATION>" +
	"<!-- TASK wcet -->" +
		"<EXECTIME Ref=\"t1\" Type=\"TASK\">" +
			"<WORST Value=\"2ms\" />" +
		"</EXECTIME>" +
	
		"<EXECTIME Ref=\"t2\" Type=\"TASK\">" +
			"<WORST Value=\"1ms\" />" +
		"</EXECTIME>" +
	
		"<EXECTIME Ref=\"t3\" Type=\"TASK\">" +
			"<WORST Value=\"1ms\" />" +
		"</EXECTIME>" +
	
		"<EXECTIME Ref=\"t4\" Type=\"TASK\">" +
			"<WORST Value=\"1ms\" />" +
		"</EXECTIME>" +
	
		"<EXECTIME Ref=\"t5\" Type=\"TASK\">" +
			"<WORST Value=\"3ms\" />" +
		"</EXECTIME>" +
	
	"</ANNOTATION>" +
	
	"<SCHEDULABILITY>" +
	"<SCHEDULINGSCENARIO>" +
	"<CPUSCHED CpuRef=\"CPU0.erika\" Utilization=\"1.0595238095238095\" SpeedFactor=\"1.3\" Boundary=\"0.7434917749851744\" Schedulable=\"false\"/>" +
	"<TASKSCHED TaskRef=\"t1\" Utilization=\"0.25\" CDelta=\"-1.5\" Schedulable=\"true\" ResponseTime=\"2ms\"/>" +
	"<TASKSCHED TaskRef=\"t2\" Utilization=\"0.2\" CDelta=\"-1.5\" Schedulable=\"true\" ResponseTime=\"3ms\"/>" +
	"<TASKSCHED TaskRef=\"t3\" Utilization=\"0.14285714285714285\" CDelta=\"-1.5\" Schedulable=\"true\" ResponseTime=\"4ms\"/>" +
	"<TASKSCHED TaskRef=\"t4\" Utilization=\"0.16666666666666666\" CDelta=\"-1.5\" Schedulable=\"true\" ResponseTime=\"5.0ms\"/>" +
	"<TASKSCHED TaskRef=\"t5\" Utilization=\"0.3\" CDelta=\"-3.0\" Schedulable=\"false\" ResponseTime=\"Infinity\"/>" +
	"</SCHEDULINGSCENARIO>" +
	"</SCHEDULABILITY>" +
	"</SYSTEM>"
		};

	@Test
	public void test5() throws IOException {
		IVarTree vt =Vt2StringUtilities.loadString(example5[0]);
		
		String system = (vt.newTreeInterface()).getAllName(null, "System")[0];

		JScan.startTest(vt, system, JScan.NO_OFFSET_ID, null);
		
		vt.newTreeInterface().setValue(system+IVarTree.SEPARATOR
				+"Schedulability"+IVarTree.SEPARATOR
				+"SchedulingScenarioList"+IVarTree.SEPARATOR
				+DataPath.makeSlashedId((String)null)+IVarTree.SEPARATOR
				+"Reports"+IVarTree.SEPARATOR
				, (IVariable) null);
		check(vt, Vt2StringUtilities.loadString(example5[1]));
	}

	/**
	 * Example in bug 223
	 */
	String[] example6 = {
			// input
			"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
		"<SYSTEM Name=\"hp_test4 (bug 223)\">" +
		"<ARCHITECTURAL>" +
			"<ECU Name=\"ECU0\">" +
				"<CPU Name=\"CPU0\" Model=\"ARM7\">" +
					"<RTOS Name=\"CPU0.erika\">" +
					"</RTOS>" +
				"</CPU>" +
			"</ECU>" +

			"<!-- Elenco task -->" +
			"<TASK Name=\"t1\" Type=\"task\">" +
				"<SCHEDULING Priority=\"5\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"8ms\" />" +
			"</TASK>" +

			"<TASK Name=\"t2\" Type=\"task\">" +
				"<SCHEDULING Priority=\"4\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"5ms\"/>" +
			"</TASK>" +

			"<TASK Name=\"t3\" Type=\"task\">" +
				"<SCHEDULING Priority=\"3\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"7ms\" />" +
			"</TASK>" +
			
			"<TASK Name=\"t4\" Type=\"task\">" +
				"<SCHEDULING Priority=\"2\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"6ms\" />" +
			"</TASK>" +
			
			"<TASK Name=\"t5\" Type=\"task\">" +
				"<SCHEDULING Priority=\"1\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"10ms\" />" +
			"</TASK>" +

		"</ARCHITECTURAL>" +
	"<!-- " +
	"-->" +

		"<MAPPING>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t1\"/>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t2\"/>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t3\"/>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t4\"/>" +
			"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t5\"/>" +
		"</MAPPING>" +
	
		"<ANNOTATION>" +
		"<!-- TASK wcet -->" +
			"<EXECTIME Ref=\"t1\" Type=\"TASK\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"t2\" Type=\"TASK\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"t3\" Type=\"TASK\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"t4\" Type=\"TASK\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +
	
			"<EXECTIME Ref=\"t5\" Type=\"TASK\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +
	
		"</ANNOTATION>" +

	"</SYSTEM>",
			
			// results
	"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
	"<SYSTEM Name=\"hp_test4 (bug 223)\">" +
	"<ARCHITECTURAL>" +
		"<ECU Name=\"ECU0\">" +
			"<CPU Name=\"CPU0\" Model=\"ARM7\">" +
				"<RTOS Name=\"CPU0.erika\">" +
				"</RTOS>" +
			"</CPU>" +
		"</ECU>" +
	
		"<!-- Elenco task -->" +
		"<TASK Name=\"t1\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"5\" Priority=\"5\" />" +
			"<SCHEDULING Priority=\"5\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"8ms\"  Deadline=\"8ms\"/>" +
		"</TASK>" +
	
		"<TASK Name=\"t2\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"4\" Priority=\"4\" />" +
			"<SCHEDULING Priority=\"4\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"5ms\" Deadline=\"5ms\"/>" +
		"</TASK>" +
	
		"<TASK Name=\"t3\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"3\" Priority=\"3\" />" +
			"<SCHEDULING Priority=\"3\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"7ms\"  Deadline=\"7ms\"/>" +
		"</TASK>" +
		
		"<TASK Name=\"t4\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"2\" Priority=\"2\" />" +
			"<SCHEDULING Priority=\"2\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"6ms\"  Deadline=\"6ms\"/>" +
		"</TASK>" +
		
		"<TASK Name=\"t5\" Type=\"task\">" +
//			"<SCHEDULING PreemptionGroupName=\"1\" Priority=\"1\" />" +
			"<SCHEDULING Priority=\"1\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"10ms\"  Deadline=\"10ms\"/>" +
		"</TASK>" +
	
	"</ARCHITECTURAL>" +
	"<!-- " +
	"-->" +
	
	"<MAPPING>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t1\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t2\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t3\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t4\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t5\"/>" +
	"</MAPPING>" +
	
	"<ANNOTATION>" +
	"<!-- TASK wcet -->" +
		"<EXECTIME Ref=\"t1\" Type=\"TASK\">" +
			"<WORST Value=\"1ms\" />" +
		"</EXECTIME>" +
	
		"<EXECTIME Ref=\"t2\" Type=\"TASK\">" +
			"<WORST Value=\"1ms\" />" +
		"</EXECTIME>" +
	
		"<EXECTIME Ref=\"t3\" Type=\"TASK\">" +
			"<WORST Value=\"1ms\" />" +
		"</EXECTIME>" +
	
		"<EXECTIME Ref=\"t4\" Type=\"TASK\">" +
			"<WORST Value=\"1ms\" />" +
		"</EXECTIME>" +
	
		"<EXECTIME Ref=\"t5\" Type=\"TASK\">" +
			"<WORST Value=\"1ms\" />" +
		"</EXECTIME>" +
	
	"</ANNOTATION>" +

	"<SCHEDULABILITY>" +
	"<SCHEDULINGSCENARIO>" +
	"<CPUSCHED CpuRef=\"CPU0.erika\" Utilization=\"0.7345238095238095\" SpeedFactor=\"0.9\" Boundary=\"0.7434917749851744\" Schedulable=\"true\"/>" +
	"<TASKSCHED TaskRef=\"t1\" Utilization=\"0.125\" CDelta=\"0.5\" Schedulable=\"true\" ResponseTime=\"1ms\"/>" +
	"<TASKSCHED TaskRef=\"t2\" Utilization=\"0.2\" CDelta=\"0.5\" Schedulable=\"true\" ResponseTime=\"2ms\"/>" +
	"<TASKSCHED TaskRef=\"t3\" Utilization=\"0.14285714285714285\" CDelta=\"0.5\" Schedulable=\"true\" ResponseTime=\"3ms\"/>" +
	"<TASKSCHED TaskRef=\"t4\" Utilization=\"0.16666666666666666\" CDelta=\"0.5\" Schedulable=\"true\" ResponseTime=\"4.0ms\"/>" +
	"<TASKSCHED TaskRef=\"t5\" Utilization=\"0.1\" CDelta=\"1.0\" Schedulable=\"true\" ResponseTime=\"5ms\"/>" +
	"</SCHEDULINGSCENARIO>" +
	"</SCHEDULABILITY>" +
	"</SYSTEM>"
		};

	@Test
	public void test6() throws IOException {
		IVarTree vt =Vt2StringUtilities.loadString(example6[0]);
		
		String system = (vt.newTreeInterface()).getAllName(null, "System")[0];

		JScan.startTest(vt, system, JScan.NO_OFFSET_ID, null);
		
		vt.newTreeInterface().setValue(system+IVarTree.SEPARATOR
				+"Schedulability"+IVarTree.SEPARATOR
				+"SchedulingScenarioList"+IVarTree.SEPARATOR
				+DataPath.makeSlashedId((String)null)+IVarTree.SEPARATOR
				+"Reports"+IVarTree.SEPARATOR
				, (IVariable) null);
		check(vt, Vt2StringUtilities.loadString(example6[1]));
	}

	/**
	 * Example in bug 223
	 */
	String[] example7 = {
			// input
			"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
		"<SYSTEM Name=\"hp_test5 (bug 223)\">" +
		"<ARCHITECTURAL>" +
			"<ECU Name=\"ECU0\">" +
				"<CPU Name=\"CPU0\" Model=\"ARM7\">" +
					"<RTOS Name=\"CPU0.erika\">" +
					"</RTOS>" +
				"</CPU>" +
			"</ECU>" +

			"<!-- Elenco task -->" +
			"<TASK Name=\"t1\" Type=\"task\">" +
				"<SCHEDULING Priority=\"6\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"9ms\" />" +
			"</TASK>" +

			"<TASK Name=\"t2\" Type=\"task\">" +
				"<SCHEDULING Priority=\"5\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"4ms\"/>" +
			"</TASK>" +

			"<TASK Name=\"t3\" Type=\"task\">" +
				"<SCHEDULING Priority=\"4\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"8ms\" />" +
			"</TASK>" +
			
			"<TASK Name=\"t4\" Type=\"task\">" +
				"<SCHEDULING Priority=\"3\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"5ms\" />" +
			"</TASK>" +
			
			"<TASK Name=\"t5\" Type=\"task\">" +
				"<SCHEDULING Priority=\"2\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"12ms\" />" +
			"</TASK>" +
			
			"<TASK Name=\"t6\" Type=\"task\">" +
				"<SCHEDULING Priority=\"1\" />" +
				"<ACTIVATION Type=\"periodic\" Period=\"7ms\" />" +
			"</TASK>" +

		"</ARCHITECTURAL>" +
	"<!-- " +
	"-->" +

	"<MAPPING>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t1\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t2\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t3\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t4\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t5\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t6\"/>" +
	"</MAPPING>" +

		"<ANNOTATION>" +
			"<EXECTIME Ref=\"t1\" Type=\"TASK\">" +
				"<WORST Value=\"2ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"t2\" Type=\"TASK\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"t3\" Type=\"TASK\">" +
				"<WORST Value=\"2ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"t4\" Type=\"TASK\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"t5\" Type=\"TASK\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +

			"<EXECTIME Ref=\"t6\" Type=\"TASK\">" +
				"<WORST Value=\"1ms\" />" +
			"</EXECTIME>" +
	
		"</ANNOTATION>" +

	"</SYSTEM>",
			
			// results
	"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
	"<SYSTEM Name=\"hp_test5 (bug 223)\">" +
	"<ARCHITECTURAL>" +
		"<ECU Name=\"ECU0\">" +
			"<CPU Name=\"CPU0\" Model=\"ARM7\">" +
				"<RTOS Name=\"CPU0.erika\">" +
				"</RTOS>" +
			"</CPU>" +
		"</ECU>" +
	
		"<!-- Elenco task -->" +
		"<TASK Name=\"t1\" Type=\"task\">" +
//			"<SCHEDULING Priority=\"6\" PreemptionGroupName=\"6\"/>" +
			"<SCHEDULING Priority=\"6\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"9ms\" Deadline=\"9ms\"/>" +
		"</TASK>" +
	
		"<TASK Name=\"t2\" Type=\"task\">" +
//			"<SCHEDULING Priority=\"5\" PreemptionGroupName=\"5\"/>" +
			"<SCHEDULING Priority=\"5\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"4ms\" Deadline=\"4ms\"/>" +
		"</TASK>" +
	
		"<TASK Name=\"t3\" Type=\"task\">" +
//			"<SCHEDULING Priority=\"4\" PreemptionGroupName=\"4\"/>" +
			"<SCHEDULING Priority=\"4\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"8ms\" Deadline=\"8ms\"/>" +
		"</TASK>" +
		
		"<TASK Name=\"t4\" Type=\"task\">" +
//			"<SCHEDULING Priority=\"3\" PreemptionGroupName=\"3\"/>" +
			"<SCHEDULING Priority=\"3\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"5ms\" Deadline=\"5ms\"/>" +
		"</TASK>" +
		
		"<TASK Name=\"t5\" Type=\"task\">" +
//			"<SCHEDULING Priority=\"2\" PreemptionGroupName=\"2\"/>" +
			"<SCHEDULING Priority=\"2\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"12ms\" Deadline=\"12ms\"/>" +
		"</TASK>" +
		
		"<TASK Name=\"t6\" Type=\"task\">" +
//			"<SCHEDULING Priority=\"1\" PreemptionGroupName=\"1\"/>" +
			"<SCHEDULING Priority=\"1\" />" +
			"<ACTIVATION Type=\"periodic\" Period=\"7ms\" Deadline=\"7ms\"/>" +
		"</TASK>" +
	
	"</ARCHITECTURAL>" +
	"<!-- " +
	"-->" +
	
	"<MAPPING>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t1\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t2\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t3\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t4\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t5\"/>" +
		"<TASKMAP rtosRef =\"CPU0.erika\"    TaskRef=\"t6\"/>" +
	"</MAPPING>" +
	
	"<ANNOTATION>" +
		"<EXECTIME Ref=\"t1\" Type=\"TASK\">" +
			"<WORST Value=\"2ms\" />" +
		"</EXECTIME>" +
		
		"<EXECTIME Ref=\"t2\" Type=\"TASK\">" +
			"<WORST Value=\"1ms\" />" +
		"</EXECTIME>" +
		
		"<EXECTIME Ref=\"t3\" Type=\"TASK\">" +
			"<WORST Value=\"2ms\" />" +
		"</EXECTIME>" +
		
		"<EXECTIME Ref=\"t4\" Type=\"TASK\">" +
			"<WORST Value=\"1ms\" />" +
		"</EXECTIME>" +
		
		"<EXECTIME Ref=\"t5\" Type=\"TASK\">" +
			"<WORST Value=\"1ms\" />" +
		"</EXECTIME>" +
		
		"<EXECTIME Ref=\"t6\" Type=\"TASK\">" +
			"<WORST Value=\"1ms\" />" +
		"</EXECTIME>" +
	
	"</ANNOTATION>" +

	"<SCHEDULABILITY>" +
	"<SCHEDULINGSCENARIO>" +
	"<CPUSCHED CpuRef=\"CPU0.erika\" Utilization=\"1.1484126984126983\" SpeedFactor=\"1.4285714285714286\" Boundary=\"0.7347722898562381\" Schedulable=\"false\"/>" +
	"<TASKSCHED TaskRef=\"t1\" Utilization=\"0.22222222222222222\" CDelta=\"-3\" Schedulable=\"true\" ResponseTime=\"2ms\"/>" +
	"<TASKSCHED TaskRef=\"t2\" Utilization=\"0.25\" CDelta=\"-1.5\" Schedulable=\"true\" ResponseTime=\"3ms\"/>" +
	"<TASKSCHED TaskRef=\"t3\" Utilization=\"0.25\" CDelta=\"-3\" Schedulable=\"true\" ResponseTime=\"6ms\"/>" +
	"<TASKSCHED TaskRef=\"t4\" Utilization=\"0.2\" CDelta=\"-2\" Schedulable=\"false\" ResponseTime=\"7ms\"/>" +
	"<TASKSCHED TaskRef=\"t5\" Utilization=\"0.08333333333333333\" CDelta=\"-3\" Schedulable=\"false\" ResponseTime=\"Infinity\"/>" +
	"<TASKSCHED TaskRef=\"t6\" Utilization=\"0.14285714285714285\" CDelta=\"-3\" Schedulable=\"false\" ResponseTime=\"Infinity\"/>" +
	"</SCHEDULINGSCENARIO>" +
	"</SCHEDULABILITY>" +
	"</SYSTEM>"
		};

	@Test
	public void test7() throws IOException {
		IVarTree vt =Vt2StringUtilities.loadString(example7[0]);
		
		String system = (vt.newTreeInterface()).getAllName(null, "System")[0];

		JScan.startTest(vt, system, JScan.NO_OFFSET_ID, null);
		
		vt.newTreeInterface().setValue(system+IVarTree.SEPARATOR
				+"Schedulability"+IVarTree.SEPARATOR
				+"SchedulingScenarioList"+IVarTree.SEPARATOR
				+DataPath.makeSlashedId((String)null)+IVarTree.SEPARATOR
				+"Reports"+IVarTree.SEPARATOR
				, (IVariable) null);
		check(vt, Vt2StringUtilities.loadString(example7[1]));
	}


}
