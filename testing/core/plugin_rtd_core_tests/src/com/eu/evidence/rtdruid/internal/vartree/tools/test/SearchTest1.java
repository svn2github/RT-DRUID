/*
 * Created on 17-mar-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.eu.evidence.rtdruid.internal.vartree.tools.test;

// progect package

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.eu.evidence.rtdruid.tests.vartree.data.SimpleExamples;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.Vt2StringUtilities;
import com.eu.evidence.rtdruid.vartree.tools.Search;

// exceptions

/**
 *  @author  Nicola Serreli
 */
public class SearchTest1 {
	/** Abbreviation for VarTree.SEPARATOR */
	private final static char S = IVarTree.SEPARATOR;
	
	private final static String SYSTEM_PATH = S+"defaultSystem";
	
	private IVarTree vt;
	private ITreeInterface ti;


	/*
	 * @see TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		vt = Vt2StringUtilities.loadString(SimpleExamples.testLoadExample1());
		ti = vt.newTreeInterface();
	}

	@Test 
	public void testAVar() {
		// innesistente
		assertNull(Search.aVar(ti, SYSTEM_PATH, "nessuna") );
		assertNull(Search.aVar(ti, SYSTEM_PATH, "") );

		// path "errato"
		assertNull(Search.aVar(ti, S+"DefaultSystem", "image") );
		assertNull(Search.aVar(ti, S+"Ciaooooo", "image") );
		assertNull(Search.aVar(ti, S+"", "image") );

		// locale
		// example 1 non ha subsystem
		
		//globale
		assertTrue(Search.aVar(ti, SYSTEM_PATH, "image").equals(
			SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "image"
		));
		assertTrue(Search.aVar(ti, SYSTEM_PATH, "x").equals(
			SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "x"
		));
		assertTrue(Search.aVar(ti, SYSTEM_PATH, "dx").equals(
			SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "dx"
		));
		assertTrue(Search.aVar(ti, SYSTEM_PATH, "teta").equals(
			SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "teta"
		));
		assertTrue(Search.aVar(ti, SYSTEM_PATH, "dteta").equals(
			SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "dteta"
		));
		assertTrue(Search.aVar(ti, SYSTEM_PATH, "angle").equals(
			SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "angle"
		));
		assertTrue(Search.aVar(ti, SYSTEM_PATH, "f").equals(
			SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "f"
		));

		// eccezioni
		boolean ok= false;
		try {
			Search.aVar(ti, SYSTEM_PATH, null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);

		ok= false;
		try {
			Search.aVar(ti, null, "qualsiasi");
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);

		ok= false;
		try {
			Search.aVar(ti, null, null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
		
	}

	@Test 
	public void testALocalVar() {
		// innesistente
		assertNull(Search.aLocalVar(ti, SYSTEM_PATH, "nessuna") );
		assertNull(Search.aLocalVar(ti, SYSTEM_PATH, "") );

		// path "errato"
		assertNull(Search.aLocalVar(ti, SYSTEM_PATH, "image") );
		assertNull(Search.aLocalVar(ti, S+"Ciaooooo", "image") );
		assertNull(Search.aLocalVar(ti, S+"", "image") );
		
		//globale , quindi innesistenti nel path fornito (manca Functional)
		assertNull(Search.aLocalVar(ti, SYSTEM_PATH, "image") );
		assertNull(Search.aLocalVar(ti, SYSTEM_PATH, "x") );
		assertNull(Search.aLocalVar(ti, SYSTEM_PATH, "dx") );
		assertNull(Search.aLocalVar(ti, SYSTEM_PATH, "teta") );
		assertNull(Search.aLocalVar(ti, SYSTEM_PATH, "dteta") );
		assertNull(Search.aLocalVar(ti, SYSTEM_PATH, "angle") );
		assertNull(Search.aLocalVar(ti, SYSTEM_PATH, "f") );

		//locali (specificando anche "functional", quindi come se fossi dentro un subSystem)
		final String localPrefix = SYSTEM_PATH + S + "Functional";
		assertTrue(Search.aLocalVar(ti, localPrefix, "image").equals(
				SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "image"));
		assertTrue(Search.aLocalVar(ti, localPrefix, "x").equals(
				SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "x"));
		assertTrue(Search.aLocalVar(ti, localPrefix, "dx").equals(
				SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "dx"));
		assertTrue(Search.aLocalVar(ti, localPrefix, "teta").equals(
				SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "teta"));
		assertTrue(Search.aLocalVar(ti, localPrefix, "dteta").equals(
				SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "dteta"));
		assertTrue(Search.aLocalVar(ti, localPrefix, "f").equals(
				SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "f"));

		// eccezioni
		boolean ok= false;
		try {
			Search.aLocalVar(ti, SYSTEM_PATH, null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);

		ok= false;
		try {
			Search.aLocalVar(ti, null, "qualsiasi");
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);

		ok= false;
		try {
			Search.aLocalVar(ti, null, null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
	}

	@Test 
	public void testAProc() {
		// innesistente
		assertNull(Search.aProc(ti, SYSTEM_PATH, "nessuno") );
		assertNull(Search.aProc(ti, SYSTEM_PATH, "") );

		// path "errato"
		assertNull(Search.aProc(ti, S+"DefaultSystem", "filter1") );
		assertNull(Search.aProc(ti, S+"Ciaooooo", "filter1") );
		assertNull(Search.aProc(ti, S+"", "filter1") );

		// locale
		// example 1 non ha subsystem
		
		//globale
		assertTrue(Search.aProc(ti, SYSTEM_PATH, "filter1").equals(
			SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "filter1"
		));
		assertTrue(Search.aProc(ti, SYSTEM_PATH, "filter2").equals(
			SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "filter2"
		));
		assertTrue(Search.aProc(ti, SYSTEM_PATH, "der1").equals(
			SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "der1"
		));
		assertTrue(Search.aProc(ti, SYSTEM_PATH, "der2").equals(
			SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "der2"
		));
		assertTrue(Search.aProc(ti, SYSTEM_PATH, "mat").equals(
			SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "mat"
		));

		// eccezioni
		boolean ok= false;
		try {
			Search.aProc(ti, SYSTEM_PATH, null);
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

	@Test 
	public void testALocalProc() {
		// innesistente
		assertNull(Search.aLocalProc(ti, SYSTEM_PATH, "nessuno") );
		assertNull(Search.aLocalProc(ti, SYSTEM_PATH, "") );

		// path "errato"
		assertNull(Search.aLocalProc(ti, SYSTEM_PATH, "filter1") );
		assertNull(Search.aLocalProc(ti, S+"Ciaooooo", "filter1") );
		assertNull(Search.aLocalProc(ti, S+"", "filter1") );

		// locale
		// example 1 non ha subsystem
		
		//path errato (manca Functional), quindi == null
		assertNull(Search.aLocalProc(ti, SYSTEM_PATH, "filter1") );
		assertNull(Search.aLocalProc(ti, SYSTEM_PATH, "filter2") );
		assertNull(Search.aLocalProc(ti, SYSTEM_PATH, "der1") );
		assertNull(Search.aLocalProc(ti, SYSTEM_PATH, "der2") );
		assertNull(Search.aLocalProc(ti, SYSTEM_PATH, "mat") );

		//path corretto
		assertTrue(Search.aLocalProc(ti, SYSTEM_PATH+S+"Functional", "filter1").equals(
				SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "filter1"
		));
		assertTrue(Search.aLocalProc(ti, SYSTEM_PATH+S+"Functional", "filter2").equals(
				SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "filter2"
		));
		assertTrue(Search.aLocalProc(ti, SYSTEM_PATH+S+"Functional", "der1").equals(
				SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "der1"
		));
		assertTrue(Search.aLocalProc(ti, SYSTEM_PATH+S+"Functional", "der2").equals(
				SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "der2"
		));
		assertTrue(Search.aLocalProc(ti, SYSTEM_PATH+S+"Functional", "mat").equals(
				SYSTEM_PATH + S + "Functional" + S + "Implementation" + S + "mat"
		));

		// eccezioni
		boolean ok= false;
		try {
			Search.aLocalProc(ti, SYSTEM_PATH, null);
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

	@Test 
	public void testProcPrefix() {
		// innesistente
		assertNull(Search.procPrefix(ti, SYSTEM_PATH, "nessuno") );
		assertNull(Search.procPrefix(ti, SYSTEM_PATH, "") );

		// path "errato"
		assertNull(Search.procPrefix(ti, S+"DefaultSystem", "filter1") );
		assertNull(Search.procPrefix(ti, S+"Ciaooooo", "filter1") );
		assertNull(Search.procPrefix(ti, S+"", "filter1") );

		// locale
		// example 1 non ha subsystem
		
		//
		assertTrue(Search.procPrefix(ti, SYSTEM_PATH, "filter1").equals(
				SYSTEM_PATH + S + "Functional"
		));
		assertTrue(Search.procPrefix(ti, SYSTEM_PATH, "filter2").equals(
				SYSTEM_PATH + S + "Functional"
		));
		assertTrue(Search.procPrefix(ti, SYSTEM_PATH, "der1").equals(
				SYSTEM_PATH + S + "Functional"
		));
		assertTrue(Search.procPrefix(ti, SYSTEM_PATH, "der2").equals(
				SYSTEM_PATH + S + "Functional"
		));
		assertTrue(Search.procPrefix(ti, SYSTEM_PATH, "mat").equals(
				SYSTEM_PATH + S + "Functional"
		));

		
		// eccezioni
		boolean ok= false;
		try {
			Search.procPrefix(ti, SYSTEM_PATH, null);
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
	
	@Test 
	public void testARtos() throws IOException {
		String source = 
		"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
		"<SYSTEM Name=\"defaultSystem\">" +
		"<ARCHITECTURAL>" +
		"\n<ECU Name=\"ECU0\" >" +
			"<CPU Name=\"CPU0\"  Model=\"ARM7\" >" +
				"<RTOS Name=\"rtos_0\"/>" +
			"</CPU>" +
		"</ECU>" +
		"\n<ECU Name=\"ECU1\" >" +
			"<CPU Name=\"CPU0\"  Model=\"ARM7\" >" +
				"<RTOS Name=\"rtos_0\"/>" +
			"</CPU>" +
			"<CPU Name=\"CPU1\"  Model=\"ARM7\" >" +
				"<RTOS Name=\"rtos_1\"/>" +
			"</CPU>" +
		"</ECU>" +
		"\n<ECU Name=\"ECU2\" >" +
			"<CPU Name=\"CPU2\"  Model=\"ARM7\" >" +
				"<RTOS Name=\"rtos_2\"/>" +
			"</CPU>" +
		"</ECU>" +
		"\n<ECU Name=\"ECU3\" >" +
			"<CPU Name=\"CPU3\"  Model=\"ARM7\" >" +
				"<RTOS Name=\"rtos_2\"/>" +
			"</CPU>" +
		"</ECU>" +
		"\n<ECU Name=\"ECU4\" >" +
			"<CPU Name=\"CPUa1\"  Model=\"ARM7\" >" +
				"<RTOS Name=\"rtos_a\"/>" +
			"</CPU>" +
			"<CPU Name=\"CPUb1\"  Model=\"ARM7\" >" +
				"<RTOS Name=\"rtos_a\"/>" +
			"</CPU>" +
			"<CPU Name=\"CPUa2\"  Model=\"ARM7\" >" +
				"<RTOS Name=\"rtos_b\"/>" +
			"</CPU>" +
			"<CPU Name=\"CPUb2\"  Model=\"ARM7\" >" +
				"<RTOS Name=\"rtos_b\"/>" +
			"</CPU>" +
		"\n</ECU>" +
		"<TASK Name=\"a\"/>" +
		"</ARCHITECTURAL>" +
		"</SYSTEM>";

//		System.out.println(source);
		IVarTree vt = Vt2StringUtilities.loadString(source);
		
		String prefix = S+"defaultSystem"+S+"Architectural"+S+"EcuList"+S;
		
		String[][] test = {
				{"rtos_0", prefix+"ECU0"+S+"CpuList"+S+"CPU0", prefix+"ECU1"+S+"CpuList"+S+"CPU0"},
				{"rtos_1", prefix+"ECU1"+S+"CpuList"+S+"CPU1"},
				{"rtos_2", prefix+"ECU2"+S+"CpuList"+S+"CPU2", prefix+"ECU3"+S+"CpuList"+S+"CPU3"},
				{"rtos_a", prefix+"ECU4"+S+"CpuList"+S+"CPUa1", prefix+"ECU4"+S+"CpuList"+S+"CPUb1"},
				{"rtos_b", prefix+"ECU4"+S+"CpuList"+S+"CPUa2", prefix+"ECU4"+S+"CpuList"+S+"CPUb2"},
				{"rtos"}
		};
		
		for (int i=0; i<test.length; i++) {
			//System.out.println(test[i][0]);
			String[] answer = Search.aRtos(vt.newTreeInterface(), S+"defaultSystem", test[i][0]);
			
			assertTrue(answer.length == (test[i].length-1));
			for (int j=0; j< answer.length; j++) {
				//System.out.println("\t"+answer[j] + "\t" +test[i][j+1]);
				
				assertTrue(answer[j] == null ? test[i][j+1] == null : answer[j].equals(test[i][j+1]));
			}
		}
	}
	
	@Test 
	public void testAEvent() throws IOException {
		String source = 
		"<!DOCTYPE SYSTEM SYSTEM \"evidence_0.2.dtd\">" +
		"<SYSTEM Name=\"defaultSystem\">" +
		"<FUNCTIONAL>" +
		"\n<EVENT Name=\"ev1\"/>" +
		"\n<EVENT Name=\"ev2\"/>" +
		"</FUNCTIONAL>" +
		"</SYSTEM>";

//		System.out.println(source);
		IVarTree vt = Vt2StringUtilities.loadString(source);
		
		String prefix = S+"defaultSystem"+S+"Functional"+S+"EventList"+S;
		
		String[][] test = {
				{"ev1", prefix+"ev1"},
				{"ev2", prefix+"ev2"},
				{"abc", null}
		};
		
		for (int i=0; i<test.length; i++) {
			System.out.println(test[i][0]);
			String answer = Search.anEvent(vt.newTreeInterface(), S+"defaultSystem", test[i][0]);
			
			System.out.println("\t"+answer+"\t"+test[i][1]);
			assertTrue(answer == null ? test[i][1] == null : answer.equals(test[i][1]));
		}
		
	}



	@Test 
	public void testAllProcs() {
		
		String[] procs = Search.allProcs(vt);

		assertNotNull(procs);
		
		for (int i=0; i<procs.length; i++) {
			System.err.println(procs[i]);
		}
		assertTrue(procs.length == 5);
	}

	@Test 
	public void testAllTasks() {
		
		String[] tasks = Search.allTasks(vt.newTreeInterface());

		assertNotNull(tasks);
		
		for (int i=0; i<tasks.length; i++) {
			System.err.println(tasks[i]);
		}
		assertTrue(tasks.length == 4);
	}

	@Test
	@Ignore
	public void testAMethod() {
	}

	@Test
	@Ignore
	public void testAGlobalMethod() {
	}

	@Test
	@Ignore
	public void testALocalMethod() {
	}

	@Test
	@Ignore
	public void testAMethodRef() {
	}

}
