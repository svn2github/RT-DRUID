package com.eu.evidence.rtdruid.vartree.abstractions.old;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.data.init.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.tools.Search;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

public class CpuTest {

	@Test
	public void testGetPathString() {

		String xmlInput1 =
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">\n" +
			"<SYSTEM Name=\"defaultSystem\">\n" +
			"	<ARCHITECTURAL>\n" +
			"		<ECU Name=\"ECU0\">\n" +
			"			<CPU Name=\"CPU0\" Model=\"ARM7\">\n" +
			"				<RTOS Name=\"mpc5554\">\n" +
			"				</RTOS>\n" +
			"			</CPU>\n" +
			"		</ECU>\n" +
			"\n" +
			"		<!-- Elenco task -->\n" +
			"		<TASK Name=\"Task1\" Type=\"task\">\n" +
			"\n" +
			"			<SCHEDULING Priority=\"1\" />\n" +
			"\n" +
			"			<ACTIVATION Type=\"periodic\" Period=\"40ms\" Deadline=\"35ms\" />\n" +
			"		</TASK>\n" +
			"\n" +
			"		<TASK Name=\"Task2\" Type=\"task\">\n" +
			"			<SCHEDULING Priority=\"2\" />\n" +
			"			<ACTIVATION Type=\"periodic\" Period=\"5ms\" Deadline=\"5ms\" />\n" +
			"		</TASK>\n" +
			"		<!-- Elenco mutex -->\n" +
			"		<MUTEX Name=\"Mutex1\"/>\n" +
			"	</ARCHITECTURAL>\n" +
			"<!--\n" +
			"-->\n" +
			"	<MAPPING>\n" +
			"		<TASKMAP rtosRef =\"mpc5554\"    TaskRef=\"Task1\"/>\n" +
			"		<TASKMAP rtosRef =\"mpc5554\"    TaskRef=\"Task2\"/>\n" +
			"		<TASKMAP rtosRef =\"mpc5554\"    TaskRef=\"TaskISR1\"/>\n" +
			"		<TASKMAP rtosRef =\"mpc5554\"    TaskRef=\"TaskISR2\"/>\n" +
			"	</MAPPING>\n" +
			"\n" +
			"</SYSTEM>";
		IVarTree vt = Vt2StringUtilities.loadString(xmlInput1);
		
		
		// print all
		System.out.println(Vt2StringUtilities.varTreeToStringErtd(vt));
		
		TaskSet ts = new TaskSet(vt, Search.systemName(vt));
		Cpu cpu = new Cpu(ts, "mpc5554", Search.systemName(vt));
		
		String act_path = cpu.getPath(Cpu.SCHED_ACTIVATION_COST);
		System.out.println(act_path);
		
		assertTrue(act_path == null);
		
		ts.setCpuProperty(Cpu.SCHED_ACTIVATION_COST, "", false);
		cpu.setProperty(Cpu.SCHED_ACTIVATION_COST, 1);
		cpu.setSave(true);
		
		act_path = cpu.getPath(Cpu.SCHED_ACTIVATION_COST);
		System.out.println(act_path);
		
		assertTrue(act_path != null);

		System.out.println(Vt2StringUtilities.varTreeToStringErtd(vt));
	}
	

	@Test
	public void testDoStore() {
		String xmlInput1 =
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">\n" +
			"<SYSTEM Name=\"defaultSystem\">\n" +
			"	<ARCHITECTURAL>\n" +
			"		<ECU Name=\"ECU0\">\n" +
			"			<CPU Name=\"CPU0\" Model=\"ARM7\">\n" +
			"				<RTOS Name=\"mpc5554\">\n" +
			"				</RTOS>\n" +
			"			</CPU>\n" +
			"		</ECU>\n" +
			"\n" +
			"		<!-- Elenco task -->\n" +
			"		<TASK Name=\"Task1\" Type=\"task\">\n" +
			"\n" +
			"			<SCHEDULING Priority=\"1\" />\n" +
			"\n" +
			"			<ACTIVATION Type=\"periodic\" Period=\"40ms\" Deadline=\"35ms\" />\n" +
			"		</TASK>\n" +
			"\n" +
			"		<TASK Name=\"Task2\" Type=\"task\">\n" +
			"			<SCHEDULING Priority=\"2\" />\n" +
			"			<ACTIVATION Type=\"periodic\" Period=\"5ms\" Deadline=\"5ms\" />\n" +
			"		</TASK>\n" +
			"		<!-- Elenco mutex -->\n" +
			"		<MUTEX Name=\"Mutex1\"/>\n" +
			"	</ARCHITECTURAL>\n" +
			"<!--\n" +
			"-->\n" +
			"	<MAPPING>\n" +
			"		<TASKMAP rtosRef =\"mpc5554\"    TaskRef=\"Task1\"/>\n" +
			"		<TASKMAP rtosRef =\"mpc5554\"    TaskRef=\"Task2\"/>\n" +
			"		<TASKMAP rtosRef =\"mpc5554\"    TaskRef=\"TaskISR1\"/>\n" +
			"		<TASKMAP rtosRef =\"mpc5554\"    TaskRef=\"TaskISR2\"/>\n" +
			"	</MAPPING>\n" +
			"\n" +
			"</SYSTEM>";
		IVarTree vt = Vt2StringUtilities.loadString(xmlInput1);
		
		
		// print all
		System.out.println(Vt2StringUtilities.varTreeToStringErtd(vt));
		
		{ // write
			TaskSet ts = new TaskSet(vt, Search.systemName(vt));
			GenRes cpu = ts.getCpuItem(1);
			assertTrue( cpu != null);
			assertTrue( cpu instanceof Cpu);
			
			assertTrue("mpc5554".equals(cpu.getName()));
			
			String act_path = cpu.getPath(Cpu.SCHED_ACTIVATION_COST);
			
			assertTrue(act_path == null);
			
			ts.setCpuProperty(Cpu.SCHED_ACTIVATION_COST, "", false);
			
			act_path = cpu.getPath(Cpu.SCHED_ACTIVATION_COST);
			assertTrue(act_path == null);
			
			
			
			cpu.setProperty(Cpu.SCHED_ACTIVATION_COST, "1us");
			cpu.setSave(true);
			
			act_path = cpu.getPath(Cpu.SCHED_ACTIVATION_COST);
			assertTrue(act_path != null);
		}
		
		{ // read
			TaskSet ts = new TaskSet(vt, Search.systemName(vt));
			GenRes cpu = ts.getCpuItem(1);
			assertTrue( cpu != null);
			assertTrue( cpu instanceof Cpu);
			
			assertTrue("mpc5554".equals(cpu.getName()));
			
			String act_path = cpu.getPath(Cpu.SCHED_ACTIVATION_COST);
			assertTrue(act_path != null);
			
			boolean ok = false;
			try {
				cpu.getProperty(Cpu.SCHED_ACTIVATION_COST);
			} catch (Exception e) {
				ok = true;
			}
			assertTrue(ok);
			
			ts.setCpuProperty(Cpu.SCHED_ACTIVATION_COST, "", false);
			
			act_path = cpu.getPath(Cpu.SCHED_ACTIVATION_COST);
			assertTrue(act_path != null);
			
			
			
			Object value = cpu.getProperty(Cpu.SCHED_ACTIVATION_COST);
			System.out.println(Vt2StringUtilities.varTreeToStringErtd(vt));
			assertTrue(value != null);
			TimeVar expected = new TimeVar("1us");
			expected.setType(Task.COMMON_TIME_TYPE);
			assertTrue((""+expected.get()).equals("" + value));
		}
		

		System.out.println(Vt2StringUtilities.varTreeToStringErtd(vt));
	}

	@Test
	public void testDoStoreAll() {
		String xmlInput1 =
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">\n" +
			"<SYSTEM Name=\"defaultSystem\">\n" +
			"	<ARCHITECTURAL>\n" +
			"		<ECU Name=\"ECU0\">\n" +
			"			<CPU Name=\"CPU0\" Model=\"ARM7\">\n" +
			"				<RTOS Name=\"mpc5554\">\n" +
			"				</RTOS>\n" +
			"			</CPU>\n" +
			"		</ECU>\n" +
			"\n" +
			"		<!-- Elenco task -->\n" +
			"		<TASK Name=\"Task1\" Type=\"task\">\n" +
			"\n" +
			"			<SCHEDULING Priority=\"1\" />\n" +
			"\n" +
			"			<ACTIVATION Type=\"periodic\" Period=\"40ms\" Deadline=\"35ms\" />\n" +
			"		</TASK>\n" +
			"\n" +
			"		<TASK Name=\"Task2\" Type=\"task\">\n" +
			"			<SCHEDULING Priority=\"2\" />\n" +
			"			<ACTIVATION Type=\"periodic\" Period=\"5ms\" Deadline=\"5ms\" />\n" +
			"		</TASK>\n" +
			"		<!-- Elenco mutex -->\n" +
			"		<MUTEX Name=\"Mutex1\"/>\n" +
			"	</ARCHITECTURAL>\n" +
			"<!--\n" +
			"-->\n" +
			"	<MAPPING>\n" +
			"		<TASKMAP rtosRef =\"mpc5554\"    TaskRef=\"Task1\"/>\n" +
			"		<TASKMAP rtosRef =\"mpc5554\"    TaskRef=\"Task2\"/>\n" +
			"		<TASKMAP rtosRef =\"mpc5554\"    TaskRef=\"TaskISR1\"/>\n" +
			"		<TASKMAP rtosRef =\"mpc5554\"    TaskRef=\"TaskISR2\"/>\n" +
			"	</MAPPING>\n" +
			"\n" +
			"</SYSTEM>";
		IVarTree vt = Vt2StringUtilities.loadString(xmlInput1);
		
		
		// print all
		System.out.println(Vt2StringUtilities.varTreeToStringErtd(vt));
		
		{ // write
			TaskSet ts = new TaskSet(vt, Search.systemName(vt));
			GenRes cpu = ts.getCpuItem(1);
			assertTrue( cpu != null);
			assertTrue( cpu instanceof Cpu);
			
			assertTrue("mpc5554".equals(cpu.getName()));
			
			assertTrue(cpu.getPath(Cpu.SCHED_ACTIVATION_COST) == null);
			assertTrue(cpu.getPath(Cpu.SCHED_TERMINATION_COST) == null);
			assertTrue(cpu.getPath(Cpu.SCHED_CONTEXT_SWITCH_COST) == null);
			
			ts.setCpuProperty(Cpu.SCHED_ACTIVATION_COST, "", false);
			ts.setCpuProperty(Cpu.SCHED_TERMINATION_COST, "", false);
			ts.setCpuProperty(Cpu.SCHED_CONTEXT_SWITCH_COST, "", false);
			
			assertTrue(cpu.getPath(Cpu.SCHED_ACTIVATION_COST) == null);
			assertTrue(cpu.getPath(Cpu.SCHED_TERMINATION_COST) == null);
			assertTrue(cpu.getPath(Cpu.SCHED_CONTEXT_SWITCH_COST) == null);
			
			
			cpu.setSave(true);
			
			cpu.setProperty(Cpu.SCHED_ACTIVATION_COST, "1us");
			cpu.setProperty(Cpu.SCHED_TERMINATION_COST, "2us");
			cpu.setProperty(Cpu.SCHED_CONTEXT_SWITCH_COST, "3us");
			
			assertTrue(cpu.getPath(Cpu.SCHED_ACTIVATION_COST) != null);
			assertTrue(cpu.getPath(Cpu.SCHED_TERMINATION_COST) != null);
			assertTrue(cpu.getPath(Cpu.SCHED_CONTEXT_SWITCH_COST) != null);
		}
		
		{ // read
			TaskSet ts = new TaskSet(vt, Search.systemName(vt));
			GenRes cpu = ts.getCpuItem(1);
			assertTrue( cpu != null);
			assertTrue( cpu instanceof Cpu);
			
			assertTrue("mpc5554".equals(cpu.getName()));
			
			assertTrue(cpu.getPath(Cpu.SCHED_ACTIVATION_COST) != null);
			assertTrue(cpu.getPath(Cpu.SCHED_TERMINATION_COST) != null);
			assertTrue(cpu.getPath(Cpu.SCHED_CONTEXT_SWITCH_COST) != null);
			
			boolean ok = false;
			try {
				cpu.getProperty(Cpu.SCHED_ACTIVATION_COST);
			} catch (Exception e) {
				ok = true;
			}
			assertTrue(ok);

			ok = false;
			try {
				cpu.getProperty(Cpu.SCHED_TERMINATION_COST);
			} catch (Exception e) {
				ok = true;
			}
			assertTrue(ok);

			ok = false;
			try {
				cpu.getProperty(Cpu.SCHED_CONTEXT_SWITCH_COST);
			} catch (Exception e) {
				ok = true;
			}
			assertTrue(ok);

			ts.setCpuProperty(Cpu.SCHED_ACTIVATION_COST, "", false);
			ts.setCpuProperty(Cpu.SCHED_TERMINATION_COST, "", false);
			ts.setCpuProperty(Cpu.SCHED_CONTEXT_SWITCH_COST, "", false);
			
			
			
			{
				Object value = cpu.getProperty(Cpu.SCHED_ACTIVATION_COST);
				System.out.println(Vt2StringUtilities.varTreeToStringErtd(vt));
				assertTrue(value != null);
				TimeVar expected = new TimeVar("1us");
				expected.setType(Task.COMMON_TIME_TYPE);
				assertTrue((""+expected.get()).equals("" + value));
			}
			{
				Object value = cpu.getProperty(Cpu.SCHED_TERMINATION_COST);
				System.out.println(Vt2StringUtilities.varTreeToStringErtd(vt));
				assertTrue(value != null);
				TimeVar expected = new TimeVar("2us");
				expected.setType(Task.COMMON_TIME_TYPE);
				assertTrue((""+expected.get()).equals("" + value));
			}
			{
				Object value = cpu.getProperty(Cpu.SCHED_CONTEXT_SWITCH_COST);
				System.out.println(Vt2StringUtilities.varTreeToStringErtd(vt));
				assertTrue(value != null);
				TimeVar expected = new TimeVar("3us");
				expected.setType(Task.COMMON_TIME_TYPE);
				assertTrue((""+expected.get()).equals("" + value));
			}
			
		}
		

		System.out.println(Vt2StringUtilities.varTreeToStringErtd(vt));
	}

}
