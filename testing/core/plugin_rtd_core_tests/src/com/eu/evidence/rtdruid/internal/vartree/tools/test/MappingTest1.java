/*
 * Created on 17-mar-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.eu.evidence.rtdruid.internal.vartree.tools.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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

/**
 * @author  Nicola Serreli
 */
public class MappingTest1 {
	protected final static char S = IVarTree.SEPARATOR;

	protected IVarTree vt;

	@Before
	public void setUp() throws Exception {
		vt = Vt2StringUtilities.loadString(SimpleExamples.testLoadExample1());
	}

	/*
	 * Test for void Mapping(String)
	 */
	@Test
	public void testMappingString() {
		Mapping m = new Mapping(vt, "Nome");
		assertTrue(m.getSystem().equals("Nome"));
		assertEquals(Utility.DEFAULT_MODE, m.getMode());
		
		m = new Mapping(vt, "");
		assertTrue(m.getSystem().equals(""));

		m = new Mapping(vt, S+"abc");
		assertTrue(m.getSystem().equals(S+"abc"));
		
  		boolean ok = false;
		try {
			new Mapping(vt, null);
		} catch (NullPointerException e) { ok = true; } assertTrue( ok );

		ok = false;
		try {
			new Mapping(null, "");
		} catch (NullPointerException e) { ok = true; } assertTrue( ok );

		m = new Mapping(vt, DataPath.makeSlashedId((String) null));
		assertNull(m.getSystem() );
		assertEquals(Utility.DEFAULT_MODE, m.getMode());

	}

	/*
	 * Test for void Mapping(String, String)
	 */
	@Test
	public void testMappingStringString() {
		Mapping m = new Mapping(vt, "Nome", "Modo");
		assertTrue(m.getSystem().equals("Nome"));
		assertTrue(m.getMode().equals("Modo"));
		
		m = new Mapping(vt, "", "");
		assertTrue(m.getSystem().equals(""));
		assertTrue(m.getMode().equals(""));
		
		m = new Mapping(vt, "abc", null);
		assertTrue(m.getSystem().equals("abc"));
		assertNull(m.getMode() );

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
		assertNull(m.getSystem() );
		assertTrue(m.getMode().equals("abc"));

		m = new Mapping(vt, DataPath.makeSlashedId((String) null), null);
		assertNull(m.getSystem() );
		assertNull(m.getMode() );

	}

	@Test
	public void testSetMode() {
		Mapping m = new Mapping(vt, "Nome", "Modo");
		assertTrue(m.getSystem().equals("Nome"));
		assertTrue(m.getMode().equals("Modo"));
		
		assertTrue(m.setMode("Nuovo").equals("Modo"));
		assertTrue(m.getMode().equals("Nuovo"));
		
		assertTrue(m.setMode(null).equals("Nuovo"));
		assertNull(m.getMode() );

		assertNull(m.setMode(null) );
		assertNull(m.getMode() );

		assertNull(m.setMode("orig") );
		assertTrue(m.getMode().equals("orig"));
		
		m = new Mapping(vt, "Nome", null);
		assertNull(m.setMode("") );
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
		Mapping m = new Mapping(vt, "defaultSystem");
		try {
		// senza indicare il modo
		assertTrue(m.procToTask("filter1").equals("Task1"));
		assertTrue(m.procToTask("der1").equals("Task1"));
		assertTrue(m.procToTask("filter2").equals("Task2"));
		assertTrue(m.procToTask("der2").equals("Task2"));
		assertTrue(m.procToTask("mat").equals("Task2"));
		assertNull(m.procToTask("_") );

		// indicando un modo qualsiasi (con example 1 e' equivalente al caso precedente) 
		m = new Mapping(vt, "defaultSystem", "Modo");
		assertTrue(m.procToTask("filter1").equals("Task1"));
		assertTrue(m.procToTask("der1").equals("Task1"));
		assertTrue(m.procToTask("filter2").equals("Task2"));
		assertTrue(m.procToTask("der2").equals("Task2"));
		assertTrue(m.procToTask("mat").equals("Task2"));
		assertNull(m.procToTask("a") );

		// indicando il modo null 
		m = new Mapping(vt, "defaultSystem", null);
		assertTrue(m.procToTask("filter1").equals("Task1"));
		assertTrue(m.procToTask("der1").equals("Task1"));
		assertTrue(m.procToTask("filter2").equals("Task2"));
		assertTrue(m.procToTask("der2").equals("Task2"));
		assertTrue(m.procToTask("mat").equals("Task2"));
		assertNull(m.procToTask("?") );
		
		// utilizzando un path errato
		m = new Mapping(vt, "abc", null);
		assertNull(m.procToTask("filter1") );
		assertNull(m.procToTask("der1") );
		assertNull(m.procToTask("filter2") );
		assertNull(m.procToTask("der2") );
		assertNull(m.procToTask("mat") );

		} catch (IncompleteMappingException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		// eccezioni
		m = new Mapping(vt, "defaultSystem");
		boolean ok = false;
		try {
			m.procToTask(null);
		} catch (IncompleteMappingException e) { fail(e.getMessage()); 
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
	}


	@Test
	public void testRtosToTask_modify() {
		// senza indicare il modo
		
		final boolean print_debug = true;
		Mapping m = new Mapping(vt, "defaultSystem");
		try {
		assertTrue(m.procToTask("filter1").equals("Task1"));
		} catch (IncompleteMappingException ex) { fail(ex.getMessage()); }
		
		int size_1_before = m.taskToProc("Task1").length;
		int size_2_before = m.taskToProc("Task2").length;
		if (print_debug) {
			System.out.print( "\nTask 1= ");
			for (String t : m.taskToProc("Task1")) {
				System.out.print(t + " ");
			}
			System.out.print( "\nTask 2= ");
			for (String t : m.taskToProc("Task2")) {
				System.out.print(t + " ");
			}
			System.out.println();
		}
		
		m.setProcToTask("filter1","Task2");
		try {
		assertTrue(m.procToTask("filter1").equals("Task2"));
		} catch (IncompleteMappingException ex) { fail(ex.getMessage()); }

		
		int size_1_after = m.taskToProc("Task1").length;
		int size_2_after = m.taskToProc("Task2").length;
		
		if (print_debug) {
			System.out.print( "\nTask 1= ");
			for (String t : m.taskToProc("Task1")) {
				System.out.print(t + " ");
			}
			System.out.print( "\nTask 2= ");
			for (String t : m.taskToProc("Task2")) {
				System.out.print(t + " ");
			}
			System.out.println();
		}
		assertTrue(size_1_before == size_1_after +1);
		assertTrue(size_2_before == size_2_after -1);
		
		m.setProcToTask("filter1",null);
		try {
		assertNull(m.procToTask("filter1") );
		} catch (IncompleteMappingException ex) { fail(ex.getMessage()); }

		int size_1_after_delete = m.taskToProc("Task1").length;
		int size_2_after_delete = m.taskToProc("Task2").length;
		
		if (print_debug) {
			System.out.print( "\nTask 1= ");
			for (String t : m.taskToProc("Task1")) {
				System.out.print(t + " ");
			}
			System.out.print( "\nTask 2= ");
			for (String t : m.taskToProc("Task2")) {
				System.out.print(t + " ");
			}
			System.out.println();
		}
		
		assertTrue(size_1_after == size_1_after_delete);
		assertTrue(size_2_after == size_2_after_delete +1);
		
		
		
	}

	
	@Test
	public void testTaskToProc() {
		// senza indicare il modo
		Mapping m = new Mapping(vt, "defaultSystem");
		String[] risp = m.taskToProc("Task1");
		assertTrue(risp != null);
		assertTrue(risp.length == 2);
		List<String> risp2 = Arrays.asList(risp);
		Collections.sort(risp2);
		assertTrue(risp2.get(0).equals("der1"));
		assertTrue(risp2.get(1).equals("filter1"));

		risp = m.taskToProc("Task2");
		assertTrue(risp != null);
		assertTrue(risp.length == 3);
		risp2 = Arrays.asList(risp);
		Collections.sort(risp2);
		assertTrue(risp2.get(0).equals("der2"));
		assertTrue(risp2.get(1).equals("filter2"));
		assertTrue(risp2.get(2).equals("mat"));
		
		risp = m.taskToProc("?");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);

		// indicando un modo qualsiasi (con example 1 e' equivalente al caso precedente) 
		m = new Mapping(vt, "defaultSystem", "Modo");
		risp = m.taskToProc("Task1");
		assertTrue(risp != null);
		assertTrue(risp.length == 2);
		risp2 = Arrays.asList(risp);
		Collections.sort(risp2);
		assertTrue(risp2.get(0).equals("der1"));
		assertTrue(risp2.get(1).equals("filter1"));

		risp = m.taskToProc("Task2");
		assertTrue(risp != null);
		assertTrue(risp.length == 3);
		risp2 = Arrays.asList(risp);
		Collections.sort(risp2);
		assertTrue(risp2.get(0).equals("der2"));
		assertTrue(risp2.get(1).equals("filter2"));
		assertTrue(risp2.get(2).equals("mat"));

		risp = m.taskToProc("");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);

		// indicando il modo null 
		m = new Mapping(vt, "defaultSystem", null);
		risp = m.taskToProc("Task1");
		assertTrue(risp != null);
		assertTrue(risp.length == 2);
		risp2 = Arrays.asList(risp);
		Collections.sort(risp2);
		assertTrue(risp2.get(0).equals("der1"));
		assertTrue(risp2.get(1).equals("filter1"));

		risp = m.taskToProc("Task2");
		assertTrue(risp != null);
		assertTrue(risp.length == 3);
		risp2 = Arrays.asList(risp);
		Collections.sort(risp2);
		assertTrue(risp2.get(0).equals("der2"));
		assertTrue(risp2.get(1).equals("filter2"));
		assertTrue(risp2.get(2).equals("mat"));
		
		risp = m.taskToProc("abc");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);

		// utilizzando un path errato
		m = new Mapping(vt, "abc", null);
		risp = m.taskToProc("Task1");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);

		risp = m.taskToProc("Task2");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);

		// eccezioni
		m = new Mapping(vt, "defaultSystem");
		boolean ok = false;
		try {
			m.taskToProc(null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
	}

///////////////////////////////////////////

	@Test
	public void testTaskToRTOS() {
		// senza indicare il modo
		Mapping m = new Mapping(vt, "defaultSystem");
		assertTrue(m.taskToRTOS("Task1").equals("CPU0.erika"));
		assertTrue(m.taskToRTOS("Task2").equals("CPU0.erika"));
		assertNull(m.taskToRTOS("___") );

		// indicando un modo qualsiasi (con example 1 e' equivalente al caso precedente) 
		m = new Mapping(vt, "defaultSystem", "Modo");
		assertTrue(m.taskToRTOS("Task1").equals("CPU0.erika"));
		assertTrue(m.taskToRTOS("Task2").equals("CPU0.erika"));
		assertNull(m.taskToRTOS("abc") );

		// indicando il modo null 
		m = new Mapping(vt, "defaultSystem", null);
		assertTrue(m.taskToRTOS("Task1").equals("CPU0.erika"));
		assertTrue(m.taskToRTOS("Task2").equals("CPU0.erika"));
		assertNull(m.taskToRTOS("???") );
		
		// utilizzando un path errato
		m = new Mapping(vt, "abc", null);
		assertNull(m.taskToRTOS("Task1") );
		assertNull(m.taskToRTOS("Task1") );
		assertNull(m.taskToRTOS("") );

		// eccezioni
		m = new Mapping(vt, "DefaultSystem");
		boolean ok = false;
		try {
			m.taskToRTOS(null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
	}

	@Test
	public void testRtosToTask() {
		// senza indicare il modo
		Mapping m = new Mapping(vt, "defaultSystem");
		String[] risp = m.rtosToTask("CPU0.erika");
		assertTrue(risp != null);
		assertTrue(risp.length == 4);
		List<String> risp2 = Arrays.asList(risp);
		Collections.sort(risp2);
		assertTrue(risp2.get(0).equals("Task1"));
		assertTrue(risp2.get(1).equals("Task2"));
		assertTrue(risp2.get(2).equals("TaskISR1"));
		assertTrue(risp2.get(3).equals("TaskISR2"));

		risp = m.rtosToTask("???");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);

		// indicando un modo qualsiasi (con example 1 e' equivalente al caso precedente) 
		m = new Mapping(vt, "defaultSystem", "Modo");
		risp = m.rtosToTask("CPU0.erika");
		assertTrue(risp != null);
		assertTrue(risp.length == 4);
		risp2 = Arrays.asList(risp);
		Collections.sort(risp2);
		assertTrue(risp2.get(0).equals("Task1"));
		assertTrue(risp2.get(1).equals("Task2"));
		assertTrue(risp2.get(2).equals("TaskISR1"));
		assertTrue(risp2.get(3).equals("TaskISR2"));

		risp = m.rtosToTask("abc");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);

		// indicando il modo null 
		m = new Mapping(vt, "defaultSystem", null);
		risp = m.rtosToTask("CPU0.erika");
		assertTrue(risp != null);
		assertTrue(risp.length == 4);
		risp2 = Arrays.asList(risp);
		Collections.sort(risp2);
		assertTrue(risp2.get(0).equals("Task1"));
		assertTrue(risp2.get(1).equals("Task2"));
		assertTrue(risp2.get(2).equals("TaskISR1"));
		assertTrue(risp2.get(3).equals("TaskISR2"));

		risp = m.rtosToTask("");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);
		
		// utilizzando un path errato
		m = new Mapping(vt, "abc", null);
		risp = m.rtosToTask("erika");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);

		risp = m.rtosToTask("Task2");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);

		// eccezioni
		m = new Mapping(vt, "DefaultSystem");
		boolean ok = false;
		try {
			m.rtosToTask(null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
	}
	
	
/////////////////////////////////////////////

 
	@Test
	@Ignore
	public void testTaskToCpu() {
		/*
		 // TEST: Aggiustare i test di TaskToCpu e CpuToTask
		// senza indicare il modo
		Mapping m = new Mapping("DefaultSystem");
		assertTrue(m.taskToCpu("Task1").equals("erika"));
		assertTrue(m.taskToCpu("Task2").equals("erika"));
		assertNull(m.taskToCpu("___") );

		// indicando un modo qualsiasi (con example 1 e' equivalente al caso precedente) 
		m = new Mapping("DefaultSystem", "Modo");
		assertTrue(m.taskToCpu("Task1").equals("erika"));
		assertTrue(m.taskToCpu("Task2").equals("erika"));
		assertNull(m.taskToCpu("abc") );

		// indicando il modo null 
		m = new Mapping("DefaultSystem", null);
		assertTrue(m.taskToCpu("Task1").equals("erika"));
		assertTrue(m.taskToCpu("Task2").equals("erika"));
		assertNull(m.taskToCpu("???") );
		
		// utilizzando un path errato
		m = new Mapping("abc", null);
		assertNull(m.taskToCpu("Task1") );
		assertNull(m.taskToCpu("Task1") );
		assertNull(m.taskToCpu("") );

		// eccezioni
		m = new Mapping("DefaultSystem");
		boolean ok = false;
		try {
			m.taskToCpu(null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
		*/
	}

	@Test
	@Ignore
	public void testCpuToTask() {
		/*
		// senza indicare il modo
		Mapping m = new Mapping("DefaultSystem");
		String[] risp = m.cpuToTask("erika");
		assertTrue(risp != null);
		assertTrue(risp.length == 2);
		List risp2 = Arrays.asList(risp);
		Collections.sort(risp2);
		assertTrue(risp2.get(0).equals("Task1"));
		assertTrue(risp2.get(1).equals("Task2"));

		risp = m.cpuToTask("???");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);

		// indicando un modo qualsiasi (con example 1 e' equivalente al caso precedente) 
		m = new Mapping("DefaultSystem", "Modo");
		risp = m.cpuToTask("erika");
		assertTrue(risp != null);
		assertTrue(risp.length == 2);
		risp2 = Arrays.asList(risp);
		Collections.sort(risp2);
		assertTrue(risp2.get(0).equals("Task1"));
		assertTrue(risp2.get(1).equals("Task2"));

		risp = m.cpuToTask("abc");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);

		// indicando il modo null 
		m = new Mapping("DefaultSystem", null);
		risp = m.cpuToTask("erika");
		assertTrue(risp != null);
		assertTrue(risp.length == 2);
		risp2 = Arrays.asList(risp);
		Collections.sort(risp2);
		assertTrue(risp2.get(0).equals("Task1"));
		assertTrue(risp2.get(1).equals("Task2"));

		risp = m.cpuToTask("");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);
		
		// utilizzando un path errato
		m = new Mapping("abc", null);
		risp = m.cpuToTask("erika");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);

		risp = m.cpuToTask("Task2");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);

		// eccezioni
		m = new Mapping("DefaultSystem");
		boolean ok = false;
		try {
			m.cpuToTask(null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
		*/
	}

////////////////////////////

	@Test
	public void testVarToMutex() {
		// senza indicare il modo
		Mapping m = new Mapping(vt, "defaultSystem");
		assertTrue(m.varToMutex("x").equals("Mutex1"));
		assertTrue(m.varToMutex("dx").equals("Mutex1"));
		assertNull(m.varToMutex("___") );

		// indicando un modo qualsiasi (con example 1 e' equivalente al caso precedente) 
		m = new Mapping(vt, "defaultSystem", "Modo");
		assertTrue(m.varToMutex("x").equals("Mutex1"));
		assertTrue(m.varToMutex("dx").equals("Mutex1"));
		assertNull(m.varToMutex("abc") );

		// indicando il modo null 
		m = new Mapping(vt, "defaultSystem", null);
		assertTrue(m.varToMutex("x").equals("Mutex1"));
		assertTrue(m.varToMutex("dx").equals("Mutex1"));
		assertNull(m.varToMutex("???") );
		
		// utilizzando un path errato
		m = new Mapping(vt, "abc", null);
		assertNull(m.varToMutex("x") );
		assertNull(m.varToMutex("dx") );
		assertNull(m.varToMutex("") );

		// eccezioni
		m = new Mapping(vt, "defaultSystem");
		boolean ok = false;
		try {
			m.varToMutex(null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
	}

	@Test
	public void testMutexToVar() {
		// senza indicare il modo
		Mapping m = new Mapping(vt, "defaultSystem");
		String[] risp = m.mutexToVar("Mutex1");
		assertTrue(risp != null);
		assertTrue(risp.length == 2);
		List<String> risp2 = Arrays.asList(risp);
		Collections.sort(risp2);
		assertTrue(risp2.get(0).equals("dx"));
		assertTrue(risp2.get(1).equals("x"));

		risp = m.mutexToVar("???");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);

		// indicando un modo qualsiasi (con example 1 e' equivalente al caso precedente) 
		m = new Mapping(vt, "defaultSystem", "Modo");
		risp = m.mutexToVar("Mutex1");
		assertTrue(risp != null);
		assertTrue(risp.length == 2);
		risp2 = Arrays.asList(risp);
		Collections.sort(risp2);
		assertTrue(risp2.get(0).equals("dx"));
		assertTrue(risp2.get(1).equals("x"));

		risp = m.mutexToVar("abc");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);

		// indicando il modo null 
		m = new Mapping(vt, "defaultSystem", null);
		risp = m.mutexToVar("Mutex1");
		assertTrue(risp != null);
		assertTrue(risp.length == 2);
		risp2 = Arrays.asList(risp);
		Collections.sort(risp2);
		assertTrue(risp2.get(0).equals("dx"));
		assertTrue(risp2.get(1).equals("x"));

		risp = m.mutexToVar("");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);
		
		// utilizzando un path errato
		m = new Mapping(vt, "abc", null);
		risp = m.mutexToVar("Mutex1");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);

		risp = m.mutexToVar("Task2");
		assertTrue(risp != null);
		assertTrue(risp.length == 0);

		// eccezioni
		m = new Mapping(vt, "defaultSystem");
		boolean ok = false;
		try {
			m.mutexToVar(null);
		} catch (NullPointerException e) { ok = true; } assertTrue(ok);
	}

	
	
}
