/*
 * Created on 18-mar-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.eu.evidence.rtdruid.internal.vartree.tools.test;

// progect package

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.eu.evidence.rtdruid.tests.vartree.data.SimpleExamples;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.tools.IncompleteMappingException;
import com.eu.evidence.rtdruid.vartree.tools.Mapping;
import com.eu.evidence.rtdruid.vartree.tools.Utility;

// exceptions


/**
 * @author  Nicola Serreli
 */
public class MappingTest2 {
	
	protected final static String S = "" + DataPath.SEPARATOR;
	protected IVarTree vt;

/*	private String[] cpuList = {
		"ECU1/CPU_0",
		"ECU2/CPU_0",
		"ECU3/CPU_0",
		"ECU4/CPU_0"
	};*/

	private String[] rtosList = {
		"OSEK1",
		"OSEK2",
		"OSEK3",
		"OSEK4"
	};

	private String[] taskList = {
		 		"/Architecture/ECU4/OSEK/Timer10ms",
				"/Architecture/ECU3/OSEK/Init",
				"/Architecture/ECU3/OSEK/Task_2msec",
				"/Architecture/ECU3/OSEK/Task_10msec",
				"/Architecture/ECU3/OSEK/SW_IRQ1",
				"/Architecture/ECU3/OSEK/Prc_count",
				"/Architecture/ECU2/OSEK/Init",
				"/Architecture/ECU2/OSEK/Task_1msec",
				"/Architecture/ECU2/OSEK/Task_10msec",
				"/Architecture/ECU2/OSEK/Init_bis",
				"/Architecture/ECU2/OSEK/Task_4msec",
				"/Architecture/ECU1/OSEK1/Init",
				"/Architecture/ECU1/OSEK1/Task_2msec",
				"/Architecture/ECU1/OSEK1/Task_10msec"
	};

	private String[] procList = {
		"/Behavior/Project_Car_v06/Plant_steer/Plant_steer_init",
		"/Behavior/Project_Car_v06/Car_brake/Car_brake_reset",
		"/Behavior/Project_Car_v06/Car_steer/Car_steer_reset",
		"/Behavior/Project_Car_v06/Plant_brake/Plant_brake_init",
		"/Behavior/Project_Car_v06/Car_brake/Car_brake_process",
		"/Behavior/Project_Car_v06/Car_steer/Car_steer_process",
		"/Behavior/Project_Car_v06/Plant_steer/Plant_steer_process",
		"/Behavior/Project_Car_v06/Plant_brake/Plant_brake_process",
		"/Behavior/Project_Driver_v06/Driver/Driver_init",
		"/Behavior/Project_Driver_v06/Driver/Driver_process",
		"/Behavior/Project_Brake_Control_v06/Control_brake/Control_brake_init",
		"/Behavior/Project_Brake_Control_v06/Vote_brake/Vote_brake_init",
		"/Behavior/Project_Brake_Control_v06/Vote_brake/Vote_brake_process",
		"/Behavior/Project_Brake_Control_v06/Control_brake/Control_brake_process",
		"/Behavior/Project_SFA_v06/Lenkfunktion_Int/Lenkfunktion_Int_CalcProcess",
		"/Behavior/Project_SFA_v06/CAN_Input/CAN_Input_GetFromCAN",
		"/Behavior/Project_SFA_v06/Lenkfunktion_Float/Lenkfunktion_Float_CalcProcess",
		"/Behavior/Project_Steer_Control_v06/Vote_steer/Vote_steer_init",
		"/Behavior/Project_Steer_Control_v06/Interrupt_Counter/Interrupt_Counter_init",
		"/Behavior/Project_Steer_Control_v06/Control_steer/Control_steer_init",
		"/Behavior/Project_Steer_Control_v06/Vote_steer/Vote_steer_process",
		"/Behavior/Project_Steer_Control_v06/Control_steer/Control_steer_process",
		"/Behavior/Project_Steer_Control_v06/Interrupt_Counter/Interrupt_Counter_sw_irq1",
		"/Behavior/Project_Steer_Control_v06/Vote_steer/Vote_steer_process_count_B",
		"/Behavior/Project_Steer_Control_v06/Control_steer/Control_steer_process_count_A"
	};
	
/*
	0	"/Architecture/ECU4/OSEK/Timer10ms", 
	1	"/Architecture/ECU3/OSEK/Init", 
	2	"/Architecture/ECU3/OSEK/Task_2msec",
	3	"/Architecture/ECU3/OSEK/Task_10msec",
	4	"/Architecture/ECU3/OSEK/SW_IRQ1",
	5	"/Architecture/ECU3/OSEK/Prc_count",
	6	"/Architecture/ECU2/OSEK/Init",
	7	"/Architecture/ECU2/OSEK/Task_1msec", 
	8	"/Architecture/ECU2/OSEK/Task_10msec",
	9	"/Architecture/ECU2/OSEK/Init_bis",
  10	"/Architecture/ECU2/OSEK/Task_4msec",
  11	"/Architecture/ECU1/OSEK1/Init",
  12	"/Architecture/ECU1/OSEK1/Task_2msec",
  13	"/Architecture/ECU1/OSEK1/Task_10msec"
	

0	"<PROCMAP procref=\"/Behavior/Project_SFA_v06/Lenkfunktion_Int/Lenkfunktion_Int_CalcProcess\"  taskref=\"/Architecture/ECU4/OSEK/Timer10ms\" order=\"1\"/>" +
0	"<PROCMAP procref=\"/Behavior/Project_SFA_v06/CAN_Input/CAN_Input_GetFromCAN\"  taskref=\"/Architecture/ECU4/OSEK/Timer10ms\" order=\"0\"/>" +
0	"<PROCMAP procref=\"/Behavior/Project_SFA_v06/Lenkfunktion_Float/Lenkfunktion_Float_CalcProcess\" taskref=\"/Architecture/ECU4/OSEK/Timer10ms\" order=\"2\"/>" +

1	"<PROCMAP procref=\"/Behavior/Project_Steer_Control_v06/Vote_steer/Vote_steer_init\"  taskref=\"/Architecture/ECU3/OSEK/Init\" order=\"2\"/>" +
1	"<PROCMAP procref=\"/Behavior/Project_Steer_Control_v06/Interrupt_Counter/Interrupt_Counter_init\"  taskref=\"/Architecture/ECU3/OSEK/Init\" order=\"0\"/>" +
1	"<PROCMAP procref=\"/Behavior/Project_Steer_Control_v06/Control_steer/Control_steer_init\"  taskref=\"/Architecture/ECU3/OSEK/Init\" order=\"1\"/>" +

2	"<PROCMAP procref=\"/Behavior/Project_Steer_Control_v06/Vote_steer/Vote_steer_process\"  taskref=\"/Architecture/ECU3/OSEK/Task_2msec\" order=\"0\"/>" +

3	"<PROCMAP procref=\"/Behavior/Project_Steer_Control_v06/Control_steer/Control_steer_process\"  taskref=\"/Architecture/ECU3/OSEK/Task_10msec\" order=\"0\"/>" +
4	"<PROCMAP procref=\"/Behavior/Project_Steer_Control_v06/Interrupt_Counter/Interrupt_Counter_sw_irq1\"  taskref=\"/Architecture/ECU3/OSEK/SW_IRQ1\" order=\"0\"/>" +
5	"<PROCMAP procref=\"/Behavior/Project_Steer_Control_v06/Vote_steer/Vote_steer_process_count_B\"  taskref=\"/Architecture/ECU3/OSEK/Prc_count\" order=\"1\"/>" +
5	"<PROCMAP procref=\"/Behavior/Project_Steer_Control_v06/Control_steer/Control_steer_process_count_A\"  taskref=\"/Architecture/ECU3/OSEK/Prc_count\" order=\"0\"/>" +

6	"<PROCMAP procref=\"/Behavior/Project_Car_v06/Plant_steer/Plant_steer_init\"  taskref=\"/Architecture/ECU2/OSEK/Init\" order=\"3\"/>" +
6	"<PROCMAP procref=\"/Behavior/Project_Car_v06/Car_brake/Car_brake_reset\"  taskref=\"/Architecture/ECU2/OSEK/Init\" order=\"0\"/>" +
6	"<PROCMAP procref=\"/Behavior/Project_Car_v06/Car_steer/Car_steer_reset\"  taskref=\"/Architecture/ECU2/OSEK/Init\" order=\"1\"/>" +
6	"<PROCMAP procref=\"/Behavior/Project_Car_v06/Plant_brake/Plant_brake_init\"  taskref=\"/Architecture/ECU2/OSEK/Init\" order=\"2\"/>" +


7	"<PROCMAP procref=\"/Behavior/Project_Car_v06/Car_brake/Car_brake_process\"  taskref=\"/Architecture/ECU2/OSEK/Task_1msec\" order=\"0\"/>" +
7	"<PROCMAP procref=\"/Behavior/Project_Car_v06/Car_steer/Car_steer_process\"  taskref=\"/Architecture/ECU2/OSEK/Task_1msec\" order=\"1\"/>" +

8	"<PROCMAP procref=\"/Behavior/Project_Car_v06/Plant_steer/Plant_steer_process\"  taskref=\"/Architecture/ECU2/OSEK/Task_10msec\" order=\"1\"/>" +
8	"<PROCMAP procref=\"/Behavior/Project_Car_v06/Plant_brake/Plant_brake_process\"  taskref=\"/Architecture/ECU2/OSEK/Task_10msec\" order=\"0\"/>" +

10	"<PROCMAP procref=\"/Behavior/Project_Driver_v06/Driver/Driver_init\"  taskref=\"/Architecture/ECU2/OSEK/Task_4msec\" order=\"0\"/>" +
10	"<PROCMAP procref=\"/Behavior/Project_Driver_v06/Driver/Driver_process\"  taskref=\"/Architecture/ECU2/OSEK/Task_4msec\" order=\"1\"/>" +

11	"<PROCMAP procref=\"/Behavior/Project_Brake_Control_v06/Control_brake/Control_brake_init\"  taskref=\"/Architecture/ECU1/OSEK1/Init\" order=\"0\"/>" +
11	"<PROCMAP procref=\"/Behavior/Project_Brake_Control_v06/Vote_brake/Vote_brake_init\"  taskref=\"/Architecture/ECU1/OSEK1/Init\" order=\"1\"/>" +

12	"<PROCMAP procref=\"/Behavior/Project_Brake_Control_v06/Vote_brake/Vote_brake_process\"  taskref=\"/Architecture/ECU1/OSEK1/Task_2msec\" order=\"0\"/>" +
13	"<PROCMAP procref=\"/Behavior/Project_Brake_Control_v06/Control_brake/Control_brake_process\" taskref=\"/Architecture/ECU1/OSEK1/Task_10msec\" order=\"0\"/>" +
*/


	/*
	 * @see TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		vt = Vt2StringUtilities.loadString(SimpleExamples.testLoadExample2());
	}

	/*
	 * Test for void Mapping(String)
	 */
	@Test
	public void testMappingString() {
		Mapping m = new Mapping(vt, "Nome/");
		assertTrue(m.getSystem().equals("Nome/"));
		if (Utility.DEFAULT_MODE == null) {
			assertTrue(m.getMode() == Utility.DEFAULT_MODE);
		} else {
			assertTrue(m.getMode().equals( Utility.DEFAULT_MODE));
		}
		
		m = new Mapping(vt, DataPath.addSlash("root/"));
		assertTrue(m.getSystem().equals("root/"));
		
		m = new Mapping(vt, S+DataPath.addSlash("root/"));
		assertTrue(m.getSystem().equals(S+"root/"));

		
  		boolean ok = false;
		try {
			new Mapping(vt, null);
		} catch (NullPointerException e) { ok = true; } assertTrue( ok );

		ok = false;
		try {
			new Mapping(null, "");
		} catch (NullPointerException e) { ok = true; } assertTrue( ok );

		m = new Mapping(vt, DataPath.makeSlashedId((String) null));
		assertTrue(m.getSystem() == null);
		if (Utility.DEFAULT_MODE == null) {
			assertTrue(m.getMode() == Utility.DEFAULT_MODE);
		} else {
			assertTrue(m.getMode().equals( Utility.DEFAULT_MODE));
		}
	}

	/*
	 * Test for void Mapping(String, String)
	 */
	@Test
	public void testMappingStringString() {
		Mapping m = new Mapping(vt, "Nome", DataPath.addSlash("modo/"));
		assertTrue(m.getSystem().equals("Nome"));
		assertTrue(m.getMode().equals(DataPath.addSlash("modo/")));
		
		m = new Mapping(vt, "", "");
		assertTrue(m.getSystem().equals(""));
		assertTrue(m.getMode().equals(""));
		
		m = new Mapping(vt, "abc", null);
		assertTrue(m.getSystem().equals("abc"));
		assertTrue(m.getMode() == null);

		boolean ok = false;
		try {
			new Mapping(vt, null, "abc");
		} catch (NullPointerException e) { ok = true; } assertTrue( ok );

		ok = false;
		try {
			new Mapping(null, null, "abc");
		} catch (NullPointerException e) { ok = true; } assertTrue( ok );

		ok = false;
		try {
			new Mapping(null, "abc", "abc");
		} catch (NullPointerException e) { ok = true; } assertTrue( ok );

		m = new Mapping(vt, DataPath.makeSlashedId((String) null), "abc");
		assertTrue(m.getSystem() == null);
		assertTrue(m.getMode().equals("abc"));

		m = new Mapping(vt, DataPath.makeSlashedId((String) null), null);
		assertTrue(m.getSystem() == null);
		assertTrue(m.getMode() == null);
	}

	@Test
	public void testSetMode() {
		Mapping m = new Mapping(vt, "Nome", "Modo");
		assertTrue(m.getSystem().equals("Nome"));
		assertTrue(m.getMode().equals("Modo"));
		
		assertTrue(m.setMode( DataPath.addSlash("abc/")).equals("Modo"));
		assertTrue(m.getMode().equals( DataPath.addSlash("abc/")));
		
		assertTrue(m.setMode(null).equals( DataPath.addSlash("abc/")));
		assertTrue(m.getMode() == null);

		assertTrue(m.setMode(null) == null);
		assertTrue(m.getMode() == null);

		assertTrue(m.setMode("orig") == null);
		assertTrue(m.getMode().equals("orig"));
		
		m = new Mapping(vt, "Nome", null);
		assertTrue(m.setMode("") == null);
		assertTrue(m.getMode().equals(""));

		m = new Mapping(vt, "Nome");
		if (Utility.DEFAULT_MODE == null) {
			assertTrue(m.setMode("1") == Utility.DEFAULT_MODE);
		} else {
			assertTrue(m.setMode("1").equals( Utility.DEFAULT_MODE));
		}
		assertTrue(m.getMode().equals("1"));
	}

	@Test
	public void testProcToTask() {
		int[] link = {
			  6,		//	"/Behavior/Project_Car_v06/Plant_steer/Plant_steer_init",
			  6,		//	"/Behavior/Project_Car_v06/Car_brake/Car_brake_reset",
			  6,		//	"/Behavior/Project_Car_v06/Car_steer/Car_steer_reset",
			  6,		//	"/Behavior/Project_Car_v06/Plant_brake/Plant_brake_init",
			  7,		//	"/Behavior/Project_Car_v06/Car_brake/Car_brake_process",
			  7,		//	"/Behavior/Project_Car_v06/Car_steer/Car_steer_process",
			  8,		//	"/Behavior/Project_Car_v06/Plant_steer/Plant_steer_process",
			  8,		//	"/Behavior/Project_Car_v06/Plant_brake/Plant_brake_process",
			10,		//	"/Behavior/Project_Driver_v06/Driver/Driver_init",
			10,		//	"/Behavior/Project_Driver_v06/Driver/Driver_process",
			11,		//	"/Behavior/Project_Brake_Control_v06/Control_brake/Control_brake_init",
			11,		//	"/Behavior/Project_Brake_Control_v06/Vote_brake/Vote_brake_init",
			12,		//	"/Behavior/Project_Brake_Control_v06/Vote_brake/Vote_brake_process",
			13,		//	"/Behavior/Project_Brake_Control_v06/Control_brake/Control_brake_process",
			  0,		//	"/Behavior/Project_SFA_v06/Lenkfunktion_Int/Lenkfunktion_Int_CalcProcess",
			  0,		//	"/Behavior/Project_SFA_v06/CAN_Input/CAN_Input_GetFromCAN",
			  0,		//	"/Behavior/Project_SFA_v06/Lenkfunktion_Float/Lenkfunktion_Float_CalcProcess",
			  1,		//	"/Behavior/Project_Steer_Control_v06/Vote_steer/Vote_steer_init",
			  1,		//	"/Behavior/Project_Steer_Control_v06/Interrupt_Counter/Interrupt_Counter_init",
			  1,		//	"/Behavior/Project_Steer_Control_v06/Control_steer/Control_steer_init",
			  2,		//	"/Behavior/Project_Steer_Control_v06/Vote_steer/Vote_steer_process",
			  3,		//	"/Behavior/Project_Steer_Control_v06/Control_steer/Control_steer_process",
			  4,		//	"/Behavior/Project_Steer_Control_v06/Interrupt_Counter/Interrupt_Counter_sw_irq1",
			  5,		//	"/Behavior/Project_Steer_Control_v06/Vote_steer/Vote_steer_process_count_B",
			  5		//	"/Behavior/Project_Steer_Control_v06/Control_steer/Control_steer_process_count_A"
		};

		// senza indicare il modo
		String sys = S+ DataPath.makeSlashedId("Root/");
		Mapping m = new Mapping(vt, sys);
		for (int i=0; i<procList.length; i++) {
			String prefix = "";
			switch (link[i]) {
				case 0: prefix = "Sub1" +S;
						break;
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
						prefix = "Sub2" +S;
						break;
				default : prefix = "";
			}
			String procName = prefix + Utility.pathToEvidence(DataPath.addSlash( procList[i]));
			String taskName = Utility.pathToEvidence(DataPath.addSlash( taskList[ link[i] ]));
//			System.err.println((m.procToTask(procName)));
			try {
			assertTrue(m.procToTask(procName).equals(taskName));
			} catch (IncompleteMappingException ex) { fail(ex.getMessage()); }
		}
		try {
		assertTrue(m.procToTask("_") == null);
		} catch (IncompleteMappingException ex) { fail(ex.getMessage()); }

		// indicando un modo qualsiasi (con example 1 e' equivalente al caso precedente) 
		m = new Mapping(vt, sys, "Modo");
		for (int i=0; i<procList.length; i++) {
			String prefix = "";
			switch (link[i]) {
				case 0: prefix = "Sub1" +S;
						break;
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
						prefix = "Sub2" +S;
						break;
				default : prefix = "";
			}
			String procName = prefix + Utility.pathToEvidence(DataPath.addSlash( procList[i]));
			String taskName = Utility.pathToEvidence(DataPath.addSlash( taskList[ link[i] ]));
//			System.err.println((m.procToTask(procName)));
			try {
			assertTrue(m.procToTask(procName).equals(taskName));
			} catch (IncompleteMappingException ex) { fail(ex.getMessage()); }
		}
		try {
		assertTrue(m.procToTask("a") == null);
		} catch (IncompleteMappingException ex) { fail(ex.getMessage()); }

		// indicando il modo null 
		m = new Mapping(vt, sys, null);
		for (int i=0; i<procList.length; i++) {
			String prefix = "";
			switch (link[i]) {
				case 0: prefix = "Sub1" +S;
						break;
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
						prefix = "Sub2" +S;
						break;
				default : prefix = "";
			}
			String procName = prefix + Utility.pathToEvidence(DataPath.addSlash( procList[i]));
			String taskName = Utility.pathToEvidence(DataPath.addSlash( taskList[ link[i] ]));
//			System.err.println((m.procToTask(procName)));
			try {
			assertTrue(m.procToTask(procName).equals(taskName));
			} catch (IncompleteMappingException ex) { fail(ex.getMessage()); }
		}
		try {
		assertTrue(m.procToTask("?") == null);
		} catch (IncompleteMappingException ex) { fail(ex.getMessage()); }
		
		// utilizzando un path errato
		m = new Mapping(vt, "DefaultSystem", null);
		for (int i=0; i<procList.length; i++) {
			String prefix = "";
			switch (link[i]) {
				case 0: prefix = "Sub1" +S;
						break;
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
						prefix = "Sub2" +S;
						break;
				default : prefix = "";
			}
			String procName = prefix + Utility.pathToEvidence(DataPath.addSlash( procList[i]));
			try {
			assertTrue(m.procToTask(procName) == null);
			} catch (IncompleteMappingException ex) { fail(ex.getMessage()); }
		}

		// eccezioni
		m = new Mapping(vt, sys);
		boolean ok = false;
		try {
			m.procToTask(null);
		} catch (IncompleteMappingException ex) { fail(ex.getMessage()); 
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);

		m = new Mapping(vt, "abc");
		ok = false;
		try {
			m.procToTask(null);
		} catch (IncompleteMappingException ex) { fail(ex.getMessage()); 
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
	}

	@Test
	public void testTaskToProc() {
		int[][] link = {
			{
				15,	//		0,		//	"/Behavior/Project_SFA_v06/CAN_Input/CAN_Input_GetFromCAN",
				16,	//		0,		//	"/Behavior/Project_SFA_v06/Lenkfunktion_Float/Lenkfunktion_Float_CalcProcess",
				14	//		0,		//	"/Behavior/Project_SFA_v06/Lenkfunktion_Int/Lenkfunktion_Int_CalcProcess",
			},{
				19,	//		1,		//	"/Behavior/Project_Steer_Control_v06/Control_steer/Control_steer_init",
				18,	//		1,		//	"/Behavior/Project_Steer_Control_v06/Interrupt_Counter/Interrupt_Counter_init",
				17	//		1,		//	"/Behavior/Project_Steer_Control_v06/Vote_steer/Vote_steer_init",
			}, {
				20	//		2,		//	"/Behavior/Project_Steer_Control_v06/Vote_steer/Vote_steer_process",
			}, {
				21	//		3,		//	"/Behavior/Project_Steer_Control_v06/Control_steer/Control_steer_process",
			}, {
				22	//		4,		//	"/Behavior/Project_Steer_Control_v06/Interrupt_Counter/Interrupt_Counter_sw_irq1",
			},{
				24,	//		5		//	"/Behavior/Project_Steer_Control_v06/Control_steer/Control_steer_process_count_A"
				23	//		5,		//	"/Behavior/Project_Steer_Control_v06/Vote_steer/Vote_steer_process_count_B",
			}, {
				1,	//		6,		//	"/Behavior/Project_Car_v06/Car_brake/Car_brake_reset",
				2,	//		6,		//	"/Behavior/Project_Car_v06/Car_steer/Car_steer_reset",
				3,	//		6,		//	"/Behavior/Project_Car_v06/Plant_brake/Plant_brake_init",
				0	//		6,		//	"/Behavior/Project_Car_v06/Plant_steer/Plant_steer_init",
			}, {
				4,	//		7,		//	"/Behavior/Project_Car_v06/Car_brake/Car_brake_process",
				5	//		7,		//	"/Behavior/Project_Car_v06/Car_steer/Car_steer_process",
			}, {
				7,	//		8,		//	"/Behavior/Project_Car_v06/Plant_brake/Plant_brake_process",
				6	//		8,		//	"/Behavior/Project_Car_v06/Plant_steer/Plant_steer_process",
			},
			null, // 9
			{
				8,	//	  10,		//	"/Behavior/Project_Driver_v06/Driver/Driver_init",
				9	//	  10,		//	"/Behavior/Project_Driver_v06/Driver/Driver_process",
			}, {
				10,	//	  11,		//	"/Behavior/Project_Brake_Control_v06/Control_brake/Control_brake_init",
				11	//	  11,		//	"/Behavior/Project_Brake_Control_v06/Vote_brake/Vote_brake_init",
			}, {
				12	//	  12,		//	"/Behavior/Project_Brake_Control_v06/Vote_brake/Vote_brake_process",
			}, {
				13	//	  13,		//	"/Behavior/Project_Brake_Control_v06/Control_brake/Control_brake_process",
			}
		};
		// senza indicare il modo
		String sys = S+ DataPath.makeSlashedId("Root/");
		Mapping m = new Mapping(vt, sys);
		for (int i=0; i<taskList.length; i++) {
			String taskName = Utility.pathToEvidence(DataPath.addSlash( taskList[i]));
			String[] risp = m.taskToProc(taskName);
			
			assertTrue(risp != null);
			if (link[i] == null) {
				assertTrue(risp.length == 0);
			} else {
				assertEquals(link[i].length, risp.length);
				List<String> risp2 = Arrays.asList(risp);
				Collections.sort(risp2);
				for (int j=0; j<link[i].length; j++) {
					String prefix = "";
					switch (i) {
						case 0: prefix = "Sub1" +S;
								break;
						case 1:
						case 2:
						case 3:
						case 4:
						case 5:
								prefix = "Sub2" +S;
								break;
						default : prefix = "";
					}
					String procName = prefix + Utility.pathToEvidence(DataPath.addSlash( procList[link[i][j]]));
					assertTrue(risp2.get(j).equals(procName));
				}
			}
		}
		
		{ // tast innesistente
			String[] risp = m.taskToProc("?");
			assertTrue(risp != null);
			assertTrue(risp.length == 0);
		}

		// indicando un modo qualsiasi (con example 1 e' equivalente al caso precedente) 
		m = new Mapping(vt, sys, "Modo");
		for (int i=0; i<taskList.length; i++) {
			String taskName = Utility.pathToEvidence(DataPath.addSlash( taskList[i]));
			String[] risp = m.taskToProc(taskName);
			
			assertTrue(risp != null);
			if (link[i] == null) {
				assertTrue(risp.length == 0);
			} else {
				assertTrue(risp.length == link[i].length);
				List<String> risp2 = Arrays.asList(risp);
				Collections.sort(risp2);
				for (int j=0; j<link[i].length; j++) {
					String prefix = "";
					switch (i) {
						case 0: prefix = "Sub1" +S;
								break;
						case 1:
						case 2:
						case 3:
						case 4:
						case 5:
								prefix = "Sub2" +S;
								break;
						default : prefix = "";
					}
					String procName = prefix + Utility.pathToEvidence(DataPath.addSlash( procList[link[i][j]]));
					assertTrue(risp2.get(j).equals(procName));
				}
			}
		}
		
		{ // tast innesistente
			String[] risp = m.taskToProc("");
			assertTrue(risp != null);
			assertTrue(risp.length == 0);
		}
		// indicando il modo null 
		m = new Mapping(vt, sys, null);
		for (int i=0; i<taskList.length; i++) {
			String taskName = Utility.pathToEvidence(DataPath.addSlash( taskList[i]));
			String[] risp = m.taskToProc(taskName);
			
			assertTrue(risp != null);
			if (link[i] == null) {
				assertTrue(risp.length == 0);
			} else {
				assertTrue(risp.length == link[i].length);
				List<String> risp2 = Arrays.asList(risp);
				Collections.sort(risp2);
				for (int j=0; j<link[i].length; j++) {
					String prefix = "";
					switch (i) {
						case 0: prefix = "Sub1" +S;
								break;
						case 1:
						case 2:
						case 3:
						case 4:
						case 5:
								prefix = "Sub2" +S;
								break;
						default : prefix = "";
					}
					String procName = prefix + Utility.pathToEvidence(DataPath.addSlash( procList[link[i][j]]));
					assertTrue(risp2.get(j).equals(procName));
				}
			}
		}
		
		{ // tast innesistente
			String[] risp = m.taskToProc("abc");
			assertTrue(risp != null);
			assertTrue(risp.length == 0);
		}
		// utilizzando un path errato
		m = new Mapping(vt, "DefaultSystem", null);
		for (int i=0; i<taskList.length; i++) {
			String taskName = Utility.pathToEvidence(DataPath.addSlash( taskList[i]));
			String[] risp = m.taskToProc(taskName);
			assertTrue(risp != null);
			assertTrue(risp.length == 0);
		}
		
		// eccezioni
		m = new Mapping(vt, "DefaultSystem");
		boolean ok = false;
		try {
			m.taskToProc(null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);

		m = new Mapping(vt, sys);
		ok = false;
		try {
			m.taskToProc(null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
	}
	
	///////////////////////////////////

	@Test
	public void testTaskToRTOS() {
		int[] link = {
			3,		//		"/Architecture/ECU4/OSEK/Timer10ms",
			2,		//		"/Architecture/ECU3/OSEK/Init",
			2,		//		"/Architecture/ECU3/OSEK/Task_2msec",
			2,		//		"/Architecture/ECU3/OSEK/Task_10msec",
			2,		//		"/Architecture/ECU3/OSEK/SW_IRQ1",
			2,		//		"/Architecture/ECU3/OSEK/Prc_count",
			1,		//		"/Architecture/ECU2/OSEK/Init",
			1,		//		"/Architecture/ECU2/OSEK/Task_1msec",
			1,		//		"/Architecture/ECU2/OSEK/Task_10msec",
			-1,	//		"/Architecture/ECU2/OSEK/Init_bis",
			1,		//		"/Architecture/ECU2/OSEK/Task_4msec",
			0,		//		"/Architecture/ECU1/OSEK1/Init",
			0,		//		"/Architecture/ECU1/OSEK1/Task_2msec",
			0		//		"/Architecture/ECU1/OSEK1/Task_10msec"
		};
		
		// senza indicare il modo
		String sys = S+ DataPath.makeSlashedId("Root/");
		Mapping m = new Mapping(vt, sys);
		for (int i=0; i<taskList.length; i++) {
			String taskName = Utility.pathToEvidence(DataPath.addSlash( taskList[i]));
			if (i ==9) {
				assertTrue(m.taskToRTOS(taskName) == null);
			} else {
				assertTrue(m.taskToRTOS(taskName).equals(rtosList[ link[i] ]));
			}
		}
		assertTrue(m.taskToRTOS("___") == null);

		// indicando un modo qualsiasi (con example 1 e' equivalente al caso precedente) 
		m = new Mapping(vt, sys, "Modo");
		for (int i=0; i<taskList.length; i++) {
			String taskName = Utility.pathToEvidence(DataPath.addSlash( taskList[i]));
			if (i ==9) {
				assertTrue(m.taskToRTOS(taskName) == null);
			} else {
				assertTrue(m.taskToRTOS(taskName).equals(rtosList[ link[i] ]));
			}
		}
		assertTrue(m.taskToRTOS("abc") == null);

		// indicando il modo null 
		m = new Mapping(vt, sys, null);
		for (int i=0; i<taskList.length; i++) {
			String taskName = Utility.pathToEvidence(DataPath.addSlash( taskList[i]));
			if (i ==9) {
				assertTrue(m.taskToRTOS(taskName) == null);
			} else {
				assertTrue(m.taskToRTOS(taskName).equals(rtosList[ link[i] ]));
			}
		}
		assertTrue(m.taskToRTOS("???") == null);
		
		// utilizzando un path errato
		m = new Mapping(vt, "DefaultSystem", null);
		for (int i=0; i<taskList.length; i++) {
			String taskName = Utility.pathToEvidence(DataPath.addSlash( taskList[i]));
			assertTrue(m.taskToRTOS(taskName) == null);
		}
		assertTrue(m.taskToRTOS("") == null);

		// eccezioni
		m = new Mapping(vt, "DefaultSystem");
		boolean ok = false;
		try {
			m.taskToRTOS(null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);

		m = new Mapping(vt, sys);
		ok = false;
		try {
			m.taskToRTOS(null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
	}

	@Test
	public void testRtosToTask() {
		int[][] link = {
			{
				11,		//	"/Architecture/ECU1/OSEK1/Init",
				13,		//	"/Architecture/ECU1/OSEK1/Task_10msec"
				12		//	"/Architecture/ECU1/OSEK1/Task_2msec",
			}, {
				6,		//	"/Architecture/ECU2/OSEK/Init",
//				Not mapped				9,		//	"/Architecture/ECU2/OSEK/Init_bis",
				8,		//	"/Architecture/ECU2/OSEK/Task_10msec",
				7,		//	"/Architecture/ECU2/OSEK/Task_1msec", 
			  10		//	"/Architecture/ECU2/OSEK/Task_4msec",
			}, {
				1,		//	"/Architecture/ECU3/OSEK/Init", 
				5,		//	"/Architecture/ECU3/OSEK/Prc_count",
				4,		//	"/Architecture/ECU3/OSEK/SW_IRQ1",
				3,		//	"/Architecture/ECU3/OSEK/Task_10msec",
				2		//	"/Architecture/ECU3/OSEK/Task_2msec",
			}, {
				0		//	"/Architecture/ECU4/OSEK/Timer10ms", 
			}
		};
		
		// senza indicare il modo
		String[] risp=null;
		String sys = S+ DataPath.makeSlashedId("Root/");
		Mapping m = new Mapping(vt, sys);
		for (int i=0; i<rtosList.length; i++) {
			risp = m.rtosToTask(rtosList[i]);
			assertTrue(risp != null);
			assertTrue(risp.length == link[i].length);
			List<String> risp2 = Arrays.asList(risp);
			Collections.sort(risp2);
			for (int j=0; j<link[i].length; j++) {
				String taskName = Utility.pathToEvidence(DataPath.addSlash( taskList[link[i][j]]));
				assertTrue(risp2.get(j).equals(taskName));
			}
		}
		
		risp = m.rtosToTask("???");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);

		// indicando un modo qualsiasi (con example 1 e' equivalente al caso precedente) 
		m = new Mapping(vt, sys, "Modo");
		for (int i=0; i<rtosList.length; i++) {
			risp = m.rtosToTask(rtosList[i]);
			assertTrue(risp != null);
			assertTrue(risp.length == link[i].length);
			List<String> risp2 = Arrays.asList(risp);
			Collections.sort(risp2);
			for (int j=0; j<link[i].length; j++) {
				String taskName = Utility.pathToEvidence(DataPath.addSlash( taskList[link[i][j]]));
				assertTrue(risp2.get(j).equals(taskName));
			}
		}

		risp = m.rtosToTask("abc");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);

		// indicando il modo null 
		m = new Mapping(vt, sys, null);
		for (int i=0; i<rtosList.length; i++) {
			risp = m.rtosToTask(rtosList[i]);
			assertTrue(risp != null);
			assertTrue(risp.length == link[i].length);
			List<String> risp2 = Arrays.asList(risp);
			Collections.sort(risp2);
			for (int j=0; j<link[i].length; j++) {
				String taskName = Utility.pathToEvidence(DataPath.addSlash( taskList[link[i][j]]));
				assertTrue(risp2.get(j).equals(taskName));
			}
		}

		risp = m.rtosToTask("");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);
		
		// utilizzando un path errato
		m = new Mapping(vt, "DefaultSystem", null);
		for (int i=0; i<rtosList.length; i++) {
			risp = m.rtosToTask(rtosList[i]);
			assertTrue(risp != null);
			assertTrue(risp.length == 0);
		}

		// eccezioni
		m = new Mapping(vt, "DefaultSystem");
		boolean ok = false;
		try {
			m.rtosToTask(null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
		
		m = new Mapping(vt, sys);
		ok = false;
		try {
			m.rtosToTask(null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
	}
	
	///////////////////////////////////

 
	@Test
	@Ignore
	public void testTaskToCpu() {
	/*
   // TEST: Aggiustare i test di TaskToCpu e CpuToTask
		int[] link = {
			3,		//		"/Architecture/ECU4/OSEK/Timer10ms",
			2,		//		"/Architecture/ECU3/OSEK/Init",
			2,		//		"/Architecture/ECU3/OSEK/Task_2msec",
			2,		//		"/Architecture/ECU3/OSEK/Task_10msec",
			2,		//		"/Architecture/ECU3/OSEK/SW_IRQ1",
			2,		//		"/Architecture/ECU3/OSEK/Prc_count",
			1,		//		"/Architecture/ECU2/OSEK/Init",
			1,		//		"/Architecture/ECU2/OSEK/Task_1msec",
			1,		//		"/Architecture/ECU2/OSEK/Task_10msec",
			-1,	//		"/Architecture/ECU2/OSEK/Init_bis",
			1,		//		"/Architecture/ECU2/OSEK/Task_4msec",
			0,		//		"/Architecture/ECU1/OSEK1/Init",
			0,		//		"/Architecture/ECU1/OSEK1/Task_2msec",
			0		//		"/Architecture/ECU1/OSEK1/Task_10msec"
		};
		
		// senza indicare il modo
		Mapping m = new Mapping(vt, "Root/");
		for (int i=0; i<taskList.length; i++) {
			if (i ==9) {
				assertTrue(m.taskToCpu(taskList[i]) == null);
			} else {
				assertTrue(m.taskToCpu(taskList[i]).equals(cpuList[ link[i] ]));
			}
		}
		assertTrue(m.taskToCpu("___") == null);

		// indicando un modo qualsiasi (con example 1 e' equivalente al caso precedente) 
		m = new Mapping(vt, "Root/", "Modo");
		for (int i=0; i<taskList.length; i++) {
			if (i ==9) {
				assertTrue(m.taskToCpu(taskList[i]) == null);
			} else {
				assertTrue(m.taskToCpu(taskList[i]).equals(cpuList[ link[i] ]));
			}
		}
		assertTrue(m.taskToCpu("abc") == null);

		// indicando il modo null 
		m = new Mapping(vt, "Root/", null);
		for (int i=0; i<taskList.length; i++) {
			if (i ==9) {
				assertTrue(m.taskToCpu(taskList[i]) == null);
			} else {
				assertTrue(m.taskToCpu(taskList[i]).equals(cpuList[ link[i] ]));
			}
		}
		assertTrue(m.taskToCpu("???") == null);
		
		// utilizzando un path errato
		m = new Mapping(vt, "DefaultSystem", null);
		for (int i=0; i<taskList.length; i++) {
			assertTrue(m.taskToCpu(taskList[i]) == null);
		}
		assertTrue(m.taskToCpu("") == null);

		// eccezioni
		m = new Mapping(vt, "DefaultSystem");
		boolean ok = false;
		try {
			m.taskToCpu(null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);

		m = new Mapping(vt, "Root/");
		ok = false;
		try {
			m.taskToCpu(null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
		*/
	}

	@Test
	@Ignore
	public void testCpuToTask() {
		/*
		int[][] link = {
			{
				11,		//	"/Architecture/ECU1/OSEK1/Init",
				13,		//	"/Architecture/ECU1/OSEK1/Task_10msec"
				12		//	"/Architecture/ECU1/OSEK1/Task_2msec",
			}, {
				6,		//	"/Architecture/ECU2/OSEK/Init",
//				Not mapped				9,		//	"/Architecture/ECU2/OSEK/Init_bis",
				8,		//	"/Architecture/ECU2/OSEK/Task_10msec",
				7,		//	"/Architecture/ECU2/OSEK/Task_1msec", 
			  10		//	"/Architecture/ECU2/OSEK/Task_4msec",
			}, {
				1,		//	"/Architecture/ECU3/OSEK/Init", 
				5,		//	"/Architecture/ECU3/OSEK/Prc_count",
				4,		//	"/Architecture/ECU3/OSEK/SW_IRQ1",
				3,		//	"/Architecture/ECU3/OSEK/Task_10msec",
				2		//	"/Architecture/ECU3/OSEK/Task_2msec",
			}, {
				0		//	"/Architecture/ECU4/OSEK/Timer10ms", 
			}
		};
		
		// senza indicare il modo
		String[] risp=null;
		Mapping m = new Mapping(vt, "Root/");
		for (int i=0; i<cpuList.length; i++) {
			risp = m.cpuToTask(cpuList[i]);
			assertTrue(risp != null);
			assertTrue(risp.length == link[i].length);
			List risp2 = Arrays.asList(risp);
			Collections.sort(risp2);
			for (int j=0; j<link[i].length; j++) {
				assertTrue(risp2.get(j).equals(taskList[link[i][j]]));
			}
		}
		
		risp = m.cpuToTask("???");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);

		// indicando un modo qualsiasi (con example 1 e' equivalente al caso precedente) 
		m = new Mapping(vt, "Root/", "Modo");
		for (int i=0; i<cpuList.length; i++) {
			risp = m.cpuToTask(cpuList[i]);
			assertTrue(risp != null);
			assertTrue(risp.length == link[i].length);
			List risp2 = Arrays.asList(risp);
			Collections.sort(risp2);
			for (int j=0; j<link[i].length; j++) {
				assertTrue(risp2.get(j).equals(taskList[link[i][j]]));
			}
		}

		risp = m.cpuToTask("abc");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);

		// indicando il modo null 
		m = new Mapping(vt, "Root/", null);
		for (int i=0; i<cpuList.length; i++) {
			risp = m.cpuToTask(cpuList[i]);
			assertTrue(risp != null);
			assertTrue(risp.length == link[i].length);
			List risp2 = Arrays.asList(risp);
			Collections.sort(risp2);
			for (int j=0; j<link[i].length; j++) {
				assertTrue(risp2.get(j).equals(taskList[link[i][j]]));
			}
		}

		risp = m.cpuToTask("");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);
		
		// utilizzando un path errato
		m = new Mapping(vt, "DefaultSystem", null);
		for (int i=0; i<cpuList.length; i++) {
			risp = m.cpuToTask(cpuList[i]);
			assertTrue(risp != null);
			assertTrue(risp.length == 0);
		}

		// eccezioni
		m = new Mapping(vt, "DefaultSystem");
		boolean ok = false;
		try {
			m.cpuToTask(null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
		
		m = new Mapping(vt, "Root/");
		ok = false;
		try {
			m.cpuToTask(null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
		*/
	}
}
