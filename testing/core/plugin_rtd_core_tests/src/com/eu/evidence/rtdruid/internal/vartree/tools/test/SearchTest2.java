/*
 * Created on 18-mar-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.eu.evidence.rtdruid.internal.vartree.tools.test;

// progect package
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.eu.evidence.rtdruid.tests.vartree.data.SimpleExamples;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.data.init.DataPath;
import com.eu.evidence.rtdruid.vartree.data.init.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.tools.Search;
import com.eu.evidence.rtdruid.vartree.tools.Utility;

// exceptions

/**
 *  @author  Nicola Serreli
 */
public class SearchTest2 extends TestCase {
	/** Abbreviation for VarTree.SEPARATOR */
	private final static char S = IVarTree.SEPARATOR;
	
	private IVarTree vt;
	private ITreeInterface ti;

	private String[] globalProcName = {
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
		"/Behavior/Project_Brake_Control_v06/Control_brake/Control_brake_process"
	};

	private String[] sub1ProcName = {
		"/Behavior/Project_SFA_v06/Lenkfunktion_Int/Lenkfunktion_Int_CalcProcess",
		"/Behavior/Project_SFA_v06/CAN_Input/CAN_Input_GetFromCAN",
		"/Behavior/Project_SFA_v06/Lenkfunktion_Float/Lenkfunktion_Float_CalcProcess"
	};

	private String[] sub2ProcName = {
		"/Behavior/Project_Steer_Control_v06/Vote_steer/Vote_steer_init",
		"/Behavior/Project_Steer_Control_v06/Interrupt_Counter/Interrupt_Counter_init",
		"/Behavior/Project_Steer_Control_v06/Control_steer/Control_steer_init",
		"/Behavior/Project_Steer_Control_v06/Vote_steer/Vote_steer_process",
		"/Behavior/Project_Steer_Control_v06/Control_steer/Control_steer_process",
		"/Behavior/Project_Steer_Control_v06/Interrupt_Counter/Interrupt_Counter_sw_irq1",
		"/Behavior/Project_Steer_Control_v06/Vote_steer/Vote_steer_process_count_B",
		"/Behavior/Project_Steer_Control_v06/Control_steer/Control_steer_process_count_A"
	};

	/**
	 * Constructor for SearchTest.
	 * @param arg0
	 */
	public SearchTest2(String arg0) {
		super(arg0);
	}

	public SearchTest2() {}

	public static Test suite() {
		return new TestSuite(SearchTest2.class);
	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
//		ProjectManager.instance().newProject();
		vt = Vt2StringUtilities.loadString(SimpleExamples.testLoadExample2());
		ti = vt.newTreeInterface();
	}

	public void testAVar() {
		// TEST: example 2 non ha var
	}

	public void testALocalVar() {
		// TEST: example 2 non ha var
	}

	public void testAProc() {
		// innesistente
		assertTrue(Search.aProc(ti, S+"DefaultSystem", "nessuno") == null);
		assertTrue(Search.aProc(ti, S+"DefaultSystem", "") == null);

		// nome "errato"
		assertTrue(Search.aProc(ti, S+"defaultSystem", "/Behavior/Project_Car_v06/Plant_steer/Plant_steer_init") == null);

		// path "errato"
		assertTrue(Search.aProc(ti, S+"DefaultSystem", Utility.pathToEvidence(DataPath.addSlash("/Behavior/Project_Car_v06/Plant_steer/Plant_steer_init"))) == null);
		assertTrue(Search.aProc(ti, S+"Ciaooooo", "/Behavior/Project_Car_v06/Plant_steer/Plant_steer_init") == null);
		assertTrue(Search.aProc(ti, S+"", "/Behavior/Project_Car_v06/Plant_steer/Plant_steer_init") == null);
		
		String sys = S+ DataPath.makeSlashedId("Root/");
		{//globale
			String global = sys + S + "Functional" + S + "Implementation";

		
			for (int i=0; i<globalProcName.length; i++) {
				String procName = Utility.pathToEvidence(DataPath.addSlash( globalProcName[i]));
				assertTrue(Search.aProc(ti, sys, procName).equals( global + S + DataPath.makeSlashedId(globalProcName[i]) ));
			}
		}
		
		{//locali a sub1
			String sub1= sys + S + "Functional" + S + "Implementation" + S +  "Sub1" + S + "Implementation";
			
			for (int i=0; i<sub1ProcName .length; i++) {
				String procName = "Sub1" +S+ Utility.pathToEvidence(DataPath.addSlash( sub1ProcName[i]));
				assertTrue(Search.aProc(ti, sys, procName).equals( sub1 + S + DataPath.makeSlashedId(sub1ProcName[i]) ));
			}
		}

		{//locali a sub2
			String sub2= sys + S + "Functional" + S + "Implementation" + S +  "Sub2" + S + "Implementation";
			
			for (int i=0; i<sub2ProcName .length; i++) {
				String procName = "Sub2" +S+ Utility.pathToEvidence(DataPath.addSlash( sub2ProcName[i]));
				assertTrue(Search.aProc(ti, sys, procName).equals( sub2 + S + DataPath.makeSlashedId(sub2ProcName[i]) ));
			}
		}

		// eccezioni
		boolean ok= false;
		try {
			Search.aProc(ti, S+"DefaultSystem", null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);

		ok= false;
		try {
			Search.aProc(ti, null, "qualsiasi");
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);

		ok= false;
		try {
			Search.aProc(ti, null, null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
	}

	public void testALocalProc() {
		// innesistente
		assertTrue(Search.aLocalProc(ti, S+"DefaultSystem", "nessuno") == null);
		assertTrue(Search.aLocalProc(ti, S+"DefaultSystem", "") == null);

		// nome "errato"
		assertTrue(Search.aLocalProc(ti, S+"defaultSystem", "/Behavior/Project_Car_v06/Plant_steer/Plant_steer_init") == null);

		// path "errato"
		assertTrue(Search.aLocalProc(ti, S+"DefaultSystem", Utility.pathToEvidence(DataPath.addSlash("/Behavior/Project_Car_v06/Plant_steer/Plant_steer_init"))) == null);
		assertTrue(Search.aLocalProc(ti, S+"Ciaooooo", "/Behavior/Project_Car_v06/Plant_steer/Plant_steer_init") == null);
		assertTrue(Search.aLocalProc(ti, S+"", "/Behavior/Project_Car_v06/Plant_steer/Plant_steer_init") == null);
 		
		String sys = S+ DataPath.makeSlashedId("Root/");
		{//globale
			for (int i=0; i<globalProcName.length; i++) {
				String procName = Utility.pathToEvidence(DataPath.addSlash( globalProcName[i]));
				assertTrue(Search.aLocalProc(ti, sys, procName) == null);
			}
		}
		
		{//locali a sub1
			String sub1= sys + S + "Functional" + S + "Implementation" + S +  "Sub1";
			
			for (int i=0; i<sub1ProcName .length; i++) {
				String procName = Utility.pathToEvidence(DataPath.addSlash( sub1ProcName[i]));
				assertTrue(Search.aLocalProc(ti, sub1, procName).equals( sub1 + S + "Implementation" + S + DataPath.makeSlashedId(sub1ProcName [i]) ));
			}
		}

		{//locali a sub2
			String sub2= sys + S + "Functional" + S + "Implementation" + S +  "Sub2";
			
			for (int i=0; i<sub2ProcName .length; i++) {
				String procName = Utility.pathToEvidence(DataPath.addSlash( sub2ProcName[i]));
				assertTrue(Search.aLocalProc(ti, sub2, procName).equals( sub2  + S + "Implementation" + S + DataPath.makeSlashedId(sub2ProcName [i]) ));
			}
		}

		// eccezioni
		boolean ok= false;
		try {
			Search.aLocalProc(ti, "DefaultSystem", null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);

		ok= false;
		try {
			Search.aLocalProc(ti, null, "qualsiasi");
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);

		ok= false;
		try {
			Search.aLocalProc(ti, null, null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
	}

	public void testProcPrefix() {
		// innesistente
		assertTrue(Search.procPrefix(ti, S+"DefaultSystem", "nessuno") == null);
		assertTrue(Search.procPrefix(ti, S+"DefaultSystem", "") == null);

		// path "errato"
		assertTrue(Search.procPrefix(ti, S+"defaultSystem", "/Behavior/Project_Car_v06/Plant_steer/Plant_steer_init") == null);
		assertTrue(Search.procPrefix(ti, S+"Ciaooooo", "/Behavior/Project_Car_v06/Plant_steer/Plant_steer_init") == null);
		assertTrue(Search.procPrefix(ti, S+"", "/Behavior/Project_Car_v06/Plant_steer/Plant_steer_init") == null);
		
		String sys = S+ DataPath.makeSlashedId("Root/");
		{//globale
			String global = sys + S + "Functional";
		
			for (int i=0; i<globalProcName.length; i++) {
				String procName = Utility.pathToEvidence(DataPath.addSlash( globalProcName[i]));
				assertTrue(Search.procPrefix(ti, sys, procName).equals( global ));
			}
		}
		
		{//locali a sub1
			String sub1= sys + S + "Functional" + S + "Implementation" + S +  "Sub1";
			
			for (int i=0; i<sub1ProcName .length; i++) {
				String procName = "Sub1" +S+ Utility.pathToEvidence(DataPath.addSlash( sub1ProcName[i]));
				assertTrue(Search.procPrefix(ti, sys, procName).equals( sub1 ));
			}
		}

		{//locali a sub2
			String sub2= sys + S + "Functional" + S + "Implementation" + S +  "Sub2";
			
			for (int i=0; i<sub2ProcName .length; i++) {
				String procName = "Sub2" +S+ Utility.pathToEvidence(DataPath.addSlash( sub2ProcName[i]));
				assertTrue(Search.procPrefix(ti, sys, procName).equals( sub2 ));
			}
		}

		// eccezioni
		boolean ok= false;
		try {
			Search.procPrefix(ti, S+"DefaultSystem", null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);

		ok= false;
		try {
			Search.procPrefix(ti, null, "qualsiasi");
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);

		ok= false;
		try {
			Search.procPrefix(ti, null, null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
	}

	public void testARtos() {
		String source = 
		"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
		"<SYSTEM Name=\"defaultSystem\">" +
		"<ARCHITECTURAL>" +
		"\n<ECU Name=\"EC/0\" >" +
			"<CPU Name=\"CP/U0\"  Model=\"ARM7\" >" +
				"<RTOS Name=\"rtos/_0\"/>" +
			"</CPU>" +
		"</ECU>" +
		"\n<ECU Name=\"ECU/1\" >" +
			"<CPU Name=\"CP/U0\"  Model=\"ARM7\" >" +
				"<RTOS Name=\"rtos/_0\"/>" +
			"</CPU>" +
			"<CPU Name=\"C/PU1\"  Model=\"ARM7\" >" +
				"<RTOS Name=\"rtos\\_1\"/>" +
			"</CPU>" +
		"</ECU>" +
		"\n<ECU Name=\"ECU\\*2\" >" +
			"<CPU Name=\"C**PU2\"  Model=\"ARM7\" >" +
				"<RTOS Name=\"rtos\\_2\"/>" +
			"</CPU>" +
		"</ECU>" +
		"\n<ECU Name=\"EC\\U3\" >" +
			"<CPU Name=\"C\\PU3\"  Model=\"ARM7\" >" +
				"<RTOS Name=\"rtos\\_2\"/>" +
			"</CPU>" +
		"</ECU>" +
		"\n<ECU Name=\"EC*U4\" >" +
			"<CPU Name=\"CPUa1\"  Model=\"ARM7\" >" +
				"<RTOS Name=\"rtos/_a\"/>" +
			"</CPU>" +
			"<CPU Name=\"C\\/PUb1\"  Model=\"ARM7\" >" +
				"<RTOS Name=\"rtos/_a\"/>" +
			"</CPU>" +
			"<CPU Name=\"C\\PUa2\"  Model=\"ARM7\" >" +
				"<RTOS Name=\"rtos*_b\"/>" +
			"</CPU>" +
			"<CPU Name=\"C/PUb2\"  Model=\"ARM7\" >" +
				"<RTOS Name=\"rtos*_b\"/>" +
			"</CPU>" +
		"\n</ECU>" +
		"<TASK Name=\"a\"/>" +
		"</ARCHITECTURAL>" +
		"</SYSTEM>";

//		System.out.println(source);

		IVarTree vt = Vt2StringUtilities.loadString(source);
		
		String prefix = S+"defaultSystem"+S+"Architectural"+S+"EcuList"+S;
		String[] ecu = {
				DataPath.makeSlashedId("EC/0"),
				DataPath.makeSlashedId("ECU/1"),
				DataPath.makeSlashedId("ECU\\*2"),
				DataPath.makeSlashedId("EC\\U3"),
				DataPath.makeSlashedId("EC*U4")
		};
		String[] cpu = {
				DataPath.makeSlashedId("CP/U0"),// 0
				DataPath.makeSlashedId("CP/U0"),// 1
				DataPath.makeSlashedId("C/PU1"),// 2
				DataPath.makeSlashedId("C**PU2"),// 3
				DataPath.makeSlashedId("C\\PU3"),// 4
				DataPath.makeSlashedId("CPUa1"),// 5
				DataPath.makeSlashedId("C\\/PUb1"),// 6
				DataPath.makeSlashedId("C\\PUa2"),// 7
				DataPath.makeSlashedId("C/PUb2")// 8
		};
		
		String[][] test = {
				{"rtos/_0", prefix+ecu[0]+S+"CpuList"+S+cpu[0], prefix+ecu[1]+S+"CpuList"+S+cpu[1]},
				{"rtos\\_1", prefix+ecu[1]+S+"CpuList"+S+cpu[2]},
				{"rtos\\_2", prefix+ecu[2]+S+"CpuList"+S+cpu[3], prefix+ecu[3]+S+"CpuList"+S+cpu[4]},
				{"rtos/_a", prefix+ecu[4]+S+"CpuList"+S+cpu[5], prefix+ecu[4]+S+"CpuList"+S+cpu[6]},
				{"rtos*_b", prefix+ecu[4]+S+"CpuList"+S+cpu[7], prefix+ecu[4]+S+"CpuList"+S+cpu[8]}
		};
		
		for (int i=0; i<test.length; i++) {
//			System.out.println(test[i][0]);
			String[] answer = Search.aRtos(vt.newTreeInterface(), S+"defaultSystem", test[i][0]);
			
			assertTrue(answer.length == (test[i].length-1));
			for (int j=0; j< answer.length; j++) {
//				System.out.println("\t"+answer[j] + "\t" +test[i][j+1]);
				
				assertTrue(answer[j] == null ? test[i][j+1] == null : answer[j].equals(test[i][j+1]));
			}
		}
		
	}
	
	public void testAEvent() {
		String source = 
		"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
		"<SYSTEM Name=\"defaultSystem\">" +
		"<FUNCTIONAL>" +
		"\n<EVENT Name=\"e\\v1\"/>" +
		"\n<EVENT Name=\"e/v2\"/>" +
		"\n<EVENT Name=\"ev*3\"/>" +
		"</FUNCTIONAL>" +
		"</SYSTEM>";

//		System.out.println(source);
		IVarTree vt = Vt2StringUtilities.loadString(source);
		
		String prefix = S+"defaultSystem"+S+"Functional"+S+"EventList"+S;
		
		String[][] test = {
				{"e\\\\v1", prefix+DataPath.makeSlashedId("e\\v1")},
				{"e\\/v2", prefix+DataPath.makeSlashedId("e/v2")},
				{"ev*3", prefix+DataPath.makeSlashedId("ev*3")},
				{"abc", null}
		};
		
		for (int i=0; i<test.length; i++) {
			System.out.println(test[i][0]);
			String answer = Search.anEvent(vt.newTreeInterface(), S+"defaultSystem", test[i][0]);
			
			System.out.println("\t"+answer+"\t"+test[i][1]);
			assertTrue(answer == null ? test[i][1] == null : answer.equals(test[i][1]));
		}
		
	}
	
	public void testALlProcs() {
		
		String[] procs = Search.allProcs(vt);

		assertTrue(procs != null);
		
		for (int i=0; i<procs.length; i++) {
			System.err.println(procs[i]);
		}
		assertTrue(procs.length == (globalProcName.length + sub1ProcName.length + sub2ProcName.length));
	}
	

	public void testAllTasks() {
		
		String[] tasks = Search.allTasks(vt.newTreeInterface());

		assertTrue(tasks != null);
		
		for (int i=0; i<tasks.length; i++) {
			System.err.println(tasks[i]);
		}
		assertTrue(tasks.length == 14);
	}

/*	public void testAMethod() {
	}

	public void testAGlobalMethod() {
	}

	public void testALocalMethod() {
	}

	public void testAMethodRef() {
	}
*/
}
