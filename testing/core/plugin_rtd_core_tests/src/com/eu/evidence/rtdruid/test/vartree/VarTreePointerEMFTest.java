/*
 * Created on May 11, 2004
 * 
 */
package com.eu.evidence.rtdruid.test.vartree;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.eu.evidence.rtdruid.internal.vartree.data.provider.DataItemProviderAdapterFactory;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVariable.NotValidValueException;
import com.eu.evidence.rtdruid.vartree.VarTreePointerEMF;
import com.eu.evidence.rtdruid.vartree.variables.StringMVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;


/**
 * @author Nicola Serreli
 */
public class VarTreePointerEMFTest {
	private final static String S = "" + IVarTree.SEPARATOR;

	private AdapterFactoryEditingDomain editingDomain;
	private ComposedAdapterFactory adapterFactory;
	
	private class MyVTPEMF extends VarTreePointerEMF {
		
		public MyVTPEMF(EList<EObject> root, EditingDomain editingDomain) {
			super(root, editingDomain);
		}
		
		public IVarTreePointer clone() {
			MyVTPEMF answer = new MyVTPEMF(root, editingDomain);
			answer.point = (LittlePointer) this.point.clone();
			
			return answer;
		}
	};
	

	@Before
	public void setup() {
	
		// Create an adapter factory that yields item providers.
		//
		List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new DataItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());

		adapterFactory = new ComposedAdapterFactory(factories);

		// Create the command stack that will notify this editor as commands are executed.
		//
		BasicCommandStack commandStack = new BasicCommandStack();

		// Create the editing domain with a special command stack.
		//
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack);

		
	}

	/**
	 */
	private IVarTreePointer populate1() {
		IVarTreePointer vtp = new MyVTPEMF(new BasicEList<EObject>(), editingDomain);

		assertTrue("MySystem".equals(vtp.add("MySystem","System")));
		assertTrue(vtp.go("MySystem"));

		assertTrue("Architectural".equals(vtp.add("Architectural","Architectural")));
		assertTrue("Mapping".equals(vtp.add("Mapping","Mapping")));
		assertTrue("Functional".equals(vtp.add("Functional","Functional")));

		assertTrue(vtp.go("Architectural"));
		assertTrue(vtp.go("TaskList"));

		assertTrue("myTask".equals(vtp.add("myTask","Task")));
		
		assertTrue(vtp.goAbsolute(S + "MySystem" + S + "Functional"));
		assertTrue(vtp.go("Implementation"));

		assertTrue("myProc".equals(vtp.add("myProc","Proc")));
		assertTrue("myVar".equals(vtp.add("myVar","Var")));

		assertTrue(vtp.goAbsolute(null));

		return vtp;
	}

	@Test
	public void testClone() {
		IVarTreePointer vtp = new MyVTPEMF(new BasicEList<EObject>(), editingDomain);

		assertTrue("MySystem".equals(vtp.add("MySystem","System")));
		assertTrue(vtp.go("MySystem"));

		assertTrue("Architectural".equals(vtp.add("Architectural","Architectural")));
		assertTrue("Modes".equals(vtp.add("Modes","Modes")));

		IVarTreePointer vtp2 = (IVarTreePointer) vtp.clone();
		assertTrue(vtp.go("Architectural"));
		assertFalse(vtp.go("Architectural2"));
		assertFalse(vtp.go("Modes"));

		assertFalse(vtp.go("Task"));
		assertTrue(vtp.go("TaskList"));

		assertTrue("MySystem".equals(vtp2.getName()));
		
	}
	
	/*
	 * Class to test for String add(String, String)
	 */
	@Test
	public void testAddStringString() {
		IVarTreePointer vtp = new MyVTPEMF(new BasicEList<EObject>(), editingDomain);

		assertTrue("MySystem".equals(vtp.add("MySystem","System")));
		assertTrue(vtp.go("MySystem"));
		
		assertFalse(vtp.go("Functional"));

		String[][] elems = {
			{"Architectural", "Architectural"},
			{"Functional", "Functional"},
			{"Modes", "Modes"},
			{"Annotation", "Annotation"},
			{"Mapping", "Mapping"},
			{"Schedulability", "Schedulability"}
		};
		
		for (int i=0; i< elems.length; i++) {
			assertTrue(elems[i][0].equals(vtp.add(elems[i][0],elems[i][1])));
		}
		for (int i=0; i< elems.length; i++) {
			assertTrue(elems[i][0].equals(vtp.add(elems[i][0],elems[i][1])));
		}
		
		boolean risp = false;
		try {
       		vtp.add("Name","Modes");
		} catch (RuntimeException e) { risp = true; } assertTrue(risp);
		

		// add a node with an composed ID
		assertTrue(vtp.go("Functional"));
		assertTrue("TimeConstList".equals(vtp.add("TimeConstList","TimeConstList")));
		assertTrue(vtp.go("TimeConstList"));
		assertTrue("abc".equals(vtp.add("abc", "TimeConst")));
		assertTrue(vtp.go("abc"));
		assertTrue(vtp.go("TimeConstElementList"));
		
		String[] tceId = {
				"a", "b" , "c"
		};
		assertTrue(DataPath.makeSlashedId(tceId).equals(vtp.add(DataPath.makeId(tceId), "TimeConstElement")));
		assertTrue(vtp.go(DataPath.makeSlashedId(tceId)));
	}
	
	@Test
	public void testAddLeaf() {
		
		IVarTreePointer vtp = populate1();
		
		vtp.goAbsolute(S + "MySystem");
		vtp.add("Name", new StringVar("Nome"));
		assertTrue("Nome".equals(vtp.getName()));
		assertTrue(vtp.go("Name"));
		assertTrue("Nome".equals(vtp.getVar().get()));
		assertTrue(vtp.goParent());
		
		assertTrue(vtp.go("Functional" +S+ "Implementation" +S+ "myProc"));
		
		StringMVar smv = new StringMVar();
			smv.appendValue("a");
			smv.appendValue("b");
			smv.appendValue("c");
		assertTrue("Methods".equals(vtp.add("Methods", smv)));
	}

	@Test
	public void testGoAbsolute() {
		MyVTPEMF vtp = new MyVTPEMF(new BasicEList<EObject>(), editingDomain);

		assertTrue("MySystem".equals(vtp.add("MySystem","System")));
		assertTrue(vtp.go("MySystem"));

		assertFalse(vtp.go("Architectural"));
		assertFalse(vtp.go("Architectural2"));
		assertFalse(vtp.go("Modes"));

		assertTrue("Architectural".equals(vtp.add("Architectural","Architectural")));
		assertTrue("Modes".equals(vtp.add("Modes","Modes")));

		assertTrue(vtp.go("Architectural"));
		assertFalse(vtp.go("Architectural2"));
		assertFalse(vtp.go("Modes"));

		assertTrue(vtp.go("TaskList"));

		assertTrue("myTask".equals(vtp.add("myTask","Task")));
		assertTrue("myTask".equals(vtp.add("myTask","Task")));
		
		assertTrue(vtp.go("myTask"));
		
		assertTrue(vtp.goAbsolute(S +"MySystem" +S+ "Modes"));
		assertTrue("Modes".equals(vtp.getName()));

		assertTrue(vtp.goAbsolute(S + "MySystem" +S+ "Architectural" +S+ "TaskList" +S+ "myTask"));
		assertTrue("myTask".equals(vtp.getName()));
		
		assertTrue(vtp.goAbsolute(S + "MySystem" +S+ "Architectural" +S+S+ "TaskList"));
		assertTrue("TaskList".equals(vtp.getName()));
	}
	
	@Test
	public void testGo() {		
		IVarTreePointer vtp = new MyVTPEMF(new BasicEList<EObject>(), editingDomain);
		assertFalse(vtp.go("Architectural"));

		vtp = populate1();

		assertFalse(vtp.go("Architectural2"));
		assertFalse(vtp.go("Modes"));

		assertTrue(vtp.go("MySystem"));
		assertTrue("MySystem".equals(vtp.getName()));
		
		assertTrue(vtp.go("Architectural"));
		assertTrue("Architectural".equals(vtp.getName()));

		assertFalse(vtp.go("task2"));
		assertTrue("Architectural".equals(vtp.getName()));
		assertTrue("Architectural".equals(vtp.getType()));

		assertTrue(vtp.go("TaskList"));
		assertTrue("TaskList".equals(vtp.getName()));
		assertTrue("TaskList".equals(vtp.getType()));

		assertTrue("myTask".equals(vtp.add("myTask","Task")));
		assertTrue("myTask".equals(vtp.add("myTask","Task")));
		
		assertTrue(vtp.go("myTask"));
	}
	
	@Test
	public void testExistAbsolute() {
		IVarTreePointer vtp = populate1();

		assertFalse(vtp.existAbsolute(S+"MySystem" +S+ "Architectural2"));

		assertTrue(vtp.existAbsolute(S+"MySystem" +S+ "Architectural"));
		assertNull(vtp.getName());
		assertTrue("root_Node's_Type".equals(vtp.getType()));

		assertTrue(vtp.go("MySystem"));
		
		assertTrue(vtp.existAbsolute(null));
		assertTrue("MySystem".equals(vtp.getName()));
		assertTrue("System".equals(vtp.getType()));

		assertFalse(vtp.go("Task"));
		assertTrue(vtp.existAbsolute(S+"MySystem"+S+"Architectural" +S+ "TaskList" +S+ "myTask"));
		assertTrue("MySystem".equals(vtp.getName()));
		assertTrue("System".equals(vtp.getType()));
	}
	
	@Test
	public void testExist() {
		IVarTreePointer vtp = populate1();

		assertFalse(vtp.exist("Architectural2"));

		assertFalse(vtp.exist("Architectural"));
		assertNull(vtp.getName());
		assertTrue("root_Node's_Type".equals(vtp.getType()));

		assertTrue(vtp.go("MySystem"));
		
		assertTrue(vtp.exist("Architectural"));
		assertTrue(vtp.exist("Mapping"));
		assertTrue("MySystem".equals(vtp.getName()));
		assertTrue("System".equals(vtp.getType()));

		assertTrue(vtp.go("Functional"));
		assertTrue("Functional".equals(vtp.getName()));
		assertTrue("Functional".equals(vtp.getType()));

		assertTrue(vtp.exist("Implementation"));
		assertTrue(vtp.exist("EventList"));
		assertTrue(vtp.exist("Implementation"));
		assertTrue("Functional".equals(vtp.getName()));
		assertTrue("Functional".equals(vtp.getType()));
	}
	
	@Test
	@Ignore
	public void testGoFirstChild() {
		IVarTreePointer vtp = populate1();
		
		// system
		assertTrue(vtp.goFirstChild());
		assertTrue("MySystem".equals(vtp.getName()));
		assertTrue("System".equals(vtp.getType()));
		
		assertTrue(vtp.goFirstChild());
		{ // architectural
			
			assertTrue("Architectural".equals(vtp.getName()));
			assertTrue("Architectural".equals(vtp.getType()));

			assertTrue(vtp.goFirstChild());
			{ // bus
				assertTrue("BusList".equals(vtp.getName()));
				assertTrue("BusList".equals(vtp.getType()));
			
				assertTrue(vtp.goParent());
			}
			
			// architectural
			assertTrue(vtp.go("TaskList"));
			
			
			{ // task
				assertTrue("TaskList".equals(vtp.getName()));
				assertTrue("TaskList".equals(vtp.getType()));
			
				assertTrue(vtp.goFirstChild());
				
				{ // myTask
					assertTrue("myTask".equals(vtp.getName()));
					assertTrue("Task".equals(vtp.getType()));
				}
				
			}
			
		}
	}
	@Test
	@Ignore
	public void testGetChildrenNumber() {
		IVarTreePointer vtp = populate1();

		assertEquals(vtp.getChildrenNumber(), 1);
		assertTrue(vtp.go("MySystem"));

		assertEquals(vtp.getChildrenNumber(), 6);
		
		assertTrue(vtp.go("Mapping"));
		assertEquals(vtp.getChildrenNumber(), 5); // taskMap, procMap, varMap, FastTaskToProcMap

		assertTrue(vtp.goAbsolute(S+"MySystem"+S+"Name"));
		assertEquals(vtp.getChildrenNumber(), 0); // variable
		
		assertTrue(vtp.goAbsolute(S+"MySystem"+S+"Architectural" +S+ "TaskList" +S+ "myTask"));
		assertEquals(vtp.getChildrenNumber(), 7); // variable

		assertTrue(vtp.goAbsolute(S+"MySystem"+S+"Functional"));
		assertEquals(vtp.getChildrenNumber(), 5); // variable
	}
	
	@Test
	@Ignore
	public void testGoNextSibling() {
		IVarTreePointer vtp = populate1();
		
		assertTrue(vtp.goFirstChild());
		assertFalse(vtp.goNextSibling());
		// system
		assertTrue(vtp.goFirstChild());
		{ // architectural
			assertTrue("Architectural".equals(vtp.getName()));
			assertTrue("Architectural".equals(vtp.getType()));

			assertTrue(vtp.goNextSibling());
		}
		
		{ // functional
			assertTrue("Functional".equals(vtp.getName()));
			assertTrue("Functional".equals(vtp.getType()));

			assertTrue(vtp.goNextSibling());
		}
		{ // mapping
			assertTrue("Mapping".equals(vtp.getName()));
			assertTrue("Mapping".equals(vtp.getType()));

			assertTrue(vtp.goNextSibling());
		}
		{ // name
			assertTrue("Name".equals(vtp.getName()));
			assertTrue("StringVar".equals(vtp.getType()));

			assertTrue(vtp.goNextSibling());
		}
		{ // xtc
			assertTrue("XTC_Cookie".equals(vtp.getName()));
			assertTrue("StringVar[]".equals(vtp.getType()));

			assertFalse(vtp.goNextSibling());
		}

		
		assertTrue(vtp.goAbsolute(S+"MySystem"+S+ "Architectural" +S+ "TaskList"));
		assertEquals(vtp.getChildrenNumber(), 1);

		assertTrue("aaa".equals(vtp.add("aaa","Task")));
		assertEquals(vtp.getChildrenNumber(), 2);

		assertTrue("zzz".equals(vtp.add("zzz","Task")));
		assertEquals(vtp.getChildrenNumber(), 3);

		
		{ // task
			assertTrue("TaskList".equals(vtp.getName()));
			assertTrue("TaskList".equals(vtp.getType()));
		
			assertTrue(vtp.goFirstChild());
			
			{ // myTask
				assertTrue("myTask".equals(vtp.getName()));
				assertTrue("Task".equals(vtp.getType()));
				
				assertTrue(vtp.goNextSibling());
			}
			{ // aaa
				assertTrue("aaa".equals(vtp.getName()));
				assertTrue("Task".equals(vtp.getType()));
				
				assertTrue(vtp.goNextSibling());
			}
			{ // zzz
				assertTrue("zzz".equals(vtp.getName()));
				assertTrue("Task".equals(vtp.getType()));
				
				assertFalse(vtp.goNextSibling());
			}
			
		}
		
		
		assertTrue(vtp.goAbsolute(S+"MySystem"+S+ "Functional"));
		assertEquals(vtp.getChildrenNumber(), 4);
		{

			assertTrue(vtp.goFirstChild());
			
			{ // eventList
				assertTrue("EventList".equals(vtp.getName()));
				assertTrue("EventList".equals(vtp.getType()));
				
				assertTrue(vtp.goNextSibling());
			}
			{ // partialOrderList
				assertTrue("PartialOrderList".equals(vtp.getName()));
				assertTrue("PartialOrderList".equals(vtp.getType()));
				
				assertTrue(vtp.goNextSibling());
			}
			{ // systemImplementation
				assertTrue("Implementation".equals(vtp.getName()));
				assertTrue("Implementation".equals(vtp.getType()));
				
				assertTrue(vtp.goNextSibling());
			}
			{ // timeConstList
				assertTrue("TimeConstList".equals(vtp.getName()));
				assertTrue("TimeConstList".equals(vtp.getType()));

				assertFalse(vtp.goNextSibling());
			}

		}

	}
	
	@Test
	public void testGoParent() {
		IVarTreePointer vtp = populate1();
		
		assertTrue(vtp.goAbsolute(S+"MySystem"+S+ "Architectural" +S+ "TaskList" +S+ "myTask"));
		assertTrue("myTask".equals(vtp.getName()));
		assertTrue("Task".equals(vtp.getType()));
		
		assertTrue(vtp.goParent());
		assertTrue("TaskList".equals(vtp.getName()));
		assertTrue("TaskList".equals(vtp.getType()));

		assertTrue(vtp.goParent());
		assertTrue("Architectural".equals(vtp.getName()));
		assertTrue("Architectural".equals(vtp.getType()));

		assertTrue(vtp.goParent());
		assertTrue("MySystem".equals(vtp.getName()));
		assertTrue("System".equals(vtp.getType()));

		assertTrue(vtp.goParent());
		assertFalse(vtp.goParent());
	}
	
	@Test
	public void testGetVar() {
		IVarTreePointer vtp = populate1();
		
		assertTrue(vtp.go("MySystem"));
		StringVar sv = new StringVar("Nome");
		vtp.add("Name", sv);
		assertTrue(vtp.go("Name"));
		StringVar svr = (StringVar) vtp.getVar();
		assertNotSame(svr, sv);
		assertTrue("Nome".equals(svr.get()));
		assertSame("Nome", svr.get()); // NB !!!
		
		sv.set("Ciao");
		StringVar svr2 = (StringVar) vtp.getVar();
		assertNotSame(svr2, sv);
		assertTrue("Nome".equals(svr.get()));
		assertSame("Nome", svr.get()); // NB !!!
		assertTrue("Nome".equals(svr2.get()));
		assertSame("Nome", svr2.get()); // NB !!!
		
		//---------
		
		assertTrue(vtp.goAbsolute(S+"Nome"+S+ "Functional" +S+ "Implementation" +S+ "myProc"));
		StringMVar smv = new StringMVar();
		{
			smv.appendValue("a");
			smv.appendValue("b");
			smv.appendValue("c");
			smv.appendValue("a");
			smv.appendValue("b");
			smv.appendValue("c");
		} 

		{
			assertEquals(smv.sizeValues(), 6);
			String[] val = smv.getValues();
			assertTrue("a".equals(val[0]));
			assertTrue("b".equals(val[1]));
			assertTrue("c".equals(val[2]));
			assertTrue("a".equals(val[3]));
			assertTrue("b".equals(val[4]));
			assertTrue("c".equals(val[5]));
		}
		
		assertTrue("Methods".equals(vtp.add("Methods", smv)));
		assertTrue(vtp.go("Methods"));
		
		StringMVar smvr = (StringMVar) vtp.getVar();
		assertNotSame(smv, smvr);

		for (int i=0; i<2; i++) {
			smvr = (StringMVar) vtp.getVar();
			
			// NB! proc.getMethods use Unique Data Type 
			assertEquals(smvr.sizeValues(), 3);
			String[] val = smvr.getValues();
			assertTrue("a".equals(val[0]));
			assertTrue("b".equals(val[1]));
			assertTrue("c".equals(val[2]));
			
			smv.clearValues();
		}

		// -------------
		
		assertTrue(vtp.goAbsolute(S+ "Nome" +S+ "Architectural" +S+ "TaskList" +S+ "myTask" +S+ "Type"));
		StringVar type = (StringVar) vtp.getVar();
		assertTrue(type == null || type.get() == null );
		//assertTrue(type.get() == null);
	}

	@Test
	public void testSetVar() {
		IVarTreePointer vtp = populate1();
		
		assertTrue(vtp.go("MySystem" +S+  "Name"));
		StringVar sv = new StringVar("Nome");
		vtp.setVar(sv);

		assertFalse(vtp.exist("MySystem"));
		assertFalse(vtp.exist("MySystem" +S+  "Name"));

		StringVar svr = (StringVar) vtp.getVar();
		assertNotSame(svr, sv);
		assertTrue("Nome".equals(svr.get()));
		assertSame("Nome", svr.get()); // NB !!!
		
		sv.set("Ciao");
		StringVar svr2 = (StringVar) vtp.getVar();
		assertNotSame(svr2, sv);
		assertTrue("Nome".equals(svr.get()));
		assertSame("Nome", svr.get()); // NB !!!
		
		//---------
		
		assertTrue(vtp.goAbsolute(S+ "Nome" +S+ "Functional" +S+ "Implementation" +S+ "myProc" +S+ "Methods"));
		StringMVar smv = new StringMVar();
		try {
			smv.appendValue("a");
			smv.appendValue("b");
			smv.appendValue("c");
			smv.appendValue("a");
			smv.appendValue("b");
			smv.appendValue("c");
		} catch (NotValidValueException e) { assertTrue(false); }
		vtp.setVar(smv);
		
		StringMVar smvr = (StringMVar) vtp.getVar();
		assertNotSame(smv, smvr);

		for (int i=0; i<2; i++) {
			smvr = (StringMVar) vtp.getVar();

			// NB! proc.getMethods use Unique Data Type 
			assertEquals(smvr.sizeValues(), 3);
			String[] val = smvr.getValues();
			assertTrue("a".equals(val[0]));
			assertTrue("b".equals(val[1]));
			assertTrue("c".equals(val[2]));
			
			smv.clearValues();
		}

	}

	// checked in all functions
	//public void testGetName() {}

	// checked in all functions
	// public void testGetType() {}

	@Test
	public void testIsContainer() {
		IVarTreePointer vtp = populate1();
	
		assertTrue(vtp.isContainer());
		
		assertTrue(vtp.go("MySystem"+S+"Name"));
		assertFalse(vtp.isContainer());

		assertTrue(vtp.goAbsolute(S+ "MySystem"+S+"Architectural"));
		assertTrue(vtp.isContainer());

		assertTrue(vtp.go("TaskList"));
		assertTrue(vtp.isContainer());
		
		assertTrue(vtp.go("myTask"));
		assertTrue(vtp.isContainer());
		
		assertTrue(vtp.go("Type"));
		assertFalse(vtp.isContainer());
	}

	@Test
	@Ignore
	public void testDestroy() {
		IVarTreePointer vtp = populate1();
		
		assertTrue(vtp.go("MySystem"));
		assertTrue("MySystem".equals(vtp.getName()));
		assertTrue("System".equals(vtp.getType()));
		
		assertTrue(vtp.go("Architectural"));
		vtp.destroy();

		assertTrue(vtp.go("Functional"));
		assertTrue("TimeConstList".equals(vtp.add("TimeConstList","TimeConstList")));
		assertTrue(vtp.go("TimeConstList"));
		assertTrue("abc".equals(vtp.add("abc", "TimeConst")));
		assertTrue("efg".equals(vtp.add("efg", "TimeConst")));
		assertEquals(vtp.getChildrenNumber(), 2);
		vtp.destroy();
		assertTrue(vtp.exist("TimeConstList")); // !!!!!
		assertTrue(vtp.go("TimeConstList"));
		assertEquals(vtp.getChildrenNumber(), 0);
		assertFalse(vtp.exist("abc"));
		assertFalse(vtp.exist("efg"));
		vtp.destroy();
		vtp.goParent();
		
		assertTrue("MySystem".equals(vtp.getName()));
		assertTrue("System".equals(vtp.getType()));
		
		assertFalse(vtp.go("Architectural"));
		assertEquals(vtp.getChildrenNumber(), 4);

		// -------
		assertTrue("Name".equals(vtp.add("Name", new StringVar("Ciao"))));
		assertEquals(vtp.getChildrenNumber(), 4);
		assertTrue("Ciao".equals(vtp.getName()));
		assertTrue("System".equals(vtp.getType()));
		
		assertTrue(vtp.go("Name"));
		vtp.destroy();

		assertTrue(DataPath.makeSlashedId((String) null).equals(vtp.getName()));
		assertTrue("System".equals(vtp.getType()));
		
		assertFalse(vtp.go("Architectural"));
		assertEquals(vtp.getChildrenNumber(), 4);
		
		// -------
		vtp.destroy();
		assertNull(vtp.getName());
		assertTrue("root_Node's_Type".equals(vtp.getType()));
		
		assertEquals(vtp.getChildrenNumber(), 0);
		assertFalse(vtp.go("Architectural"));
		assertFalse(vtp.go("Functional"));
		assertFalse(vtp.go("Mapping"));
		
	}
/*
	public void testTypePath() {
	}


	public void testHandler() {
	}
	public void testAddObserver() {
	}
	public void testRemObserver() {
	}
	public void testRemAllObserver() {
	}
	public void testGetAllObserver() {
	}
	*/
	/*
	 * Deprecated
	 * 
	 *

	public void testAddList() {}
	public void testAddReference() {}
	public void testAddStringStringVariableString() {}
	public void testAddStringStringString() {}
	public void testIsList() {}
	public void testIsReference() {}
	public void testSetDefined() {}
	public void testSetValid() {}
	public void testIsDefined() {}
	public void testIsValid() {}
	public void testSetWithAuto() {}
	public void testGetWithAuto() {}
	public void testGetMultipleValuesList() {}
	public void testGetSerialNumber() {}
	public void testExtractChild() {}
	public void testAttachChild() {}
	public void testGetDescription() {}
	public void testSetDescr() {}

	 */
	
	
/*
 * Test with slash
 */
	private String sh_system = "My\\S/y\\/\\st**em";
	private String sh_system_path = DataPath.makeSlashedId(sh_system);
	private String sh_task_path = DataPath.makeSlashedId("m*/*\\yTask");
	private String sh_proc_path = DataPath.makeSlashedId("m\\yPro/c*");
	private String sh_var_path = DataPath.makeSlashedId("m*yV/ar");
	
	/**
	 */
	private IVarTreePointer populate2() {
		IVarTreePointer vtp = new MyVTPEMF(new BasicEList<EObject>(), editingDomain);

		assertTrue(sh_system_path.equals(vtp.add("My\\S/y\\/\\st**em","System")));
		assertTrue(vtp.go(sh_system_path));

		assertTrue("Architectural".equals(vtp.add("Architectural","Architectural")));
		assertTrue("Mapping".equals(vtp.add("Mapping","Mapping")));
		assertTrue("Functional".equals(vtp.add("Functional","Functional")));

		assertTrue(vtp.go("Architectural"));
		assertTrue(vtp.go("TaskList"));

		assertTrue(sh_task_path.equals(vtp.add("m*/*\\yTask","Task")));
		
		assertTrue(vtp.goAbsolute(S + sh_system_path + S + "Functional"));
		assertTrue(vtp.go("Implementation"));

		assertTrue(sh_proc_path.equals(vtp.add("m\\yPro/c*","Proc")));
		assertTrue(sh_var_path.equals(vtp.add("m*yV/ar","Var")));

		assertTrue(vtp.goAbsolute(null));

		return vtp;
	}

//	public void testMyVTPEMF() {}
	/*
	 * Class to test for Object clone()
	 */
	@Test
	@Ignore
	public void testCloneSlash() {
		IVarTreePointer vtp = new MyVTPEMF(new BasicEList<EObject>(), editingDomain);

		assertTrue(sh_system_path.equals(vtp.add(sh_system,"System")));
		assertTrue(vtp.go(sh_system_path));

		assertTrue("Architectural".equals(vtp.add("Architectural","Architectural")));
		assertTrue("Modes".equals(vtp.add("Modes","Modes")));

		IVarTreePointer vtp2 = (IVarTreePointer) vtp.clone();
		assertTrue(vtp.go("Architectural"));
		assertFalse(vtp.go("Architectural2"));
		assertFalse(vtp.go("Modes"));

		assertFalse(vtp.go("Task"));
		assertTrue(vtp.go("TaskList"));

		assertTrue(sh_system_path.equals(vtp2.getName()));
		
	}
	
	/*
	 * Class to test for String add(String, String)
	 */
	@Test
	@Ignore
	public void testAddStringStringSlash() {
		IVarTreePointer vtp = new MyVTPEMF(new BasicEList<EObject>(), editingDomain);

		assertTrue(sh_system_path.equals(vtp.add(sh_system,"System")));
		assertTrue(vtp.go(sh_system_path));
		
		String[][] elems = {
			{"Architectural", "Architectural"},
			{"Functional", "Functional"},
			{"Modes", "Modes"},
			{"Annotation", "Annotation"},
			{"Mapping", "Mapping"},
			{"Schedulability", "Schedulability"}
		};
		
		for (int i=0; i< elems.length; i++) {
			assertTrue(elems[i][0].equals(vtp.add(elems[i][0],elems[i][1])));
		}
		for (int i=0; i< elems.length; i++) {
			assertTrue(elems[i][0].equals(vtp.add(elems[i][0],elems[i][1])));
		}
		
		boolean risp = false;
		try {
       		vtp.add("Name","Modes");
		} catch (RuntimeException e) { risp = true; } assertTrue(risp);
		

		// add a node with an composed ID
		assertTrue(vtp.go("Functional"));
		assertTrue(vtp.go("TimeConstList"));
		assertTrue(DataPath.makeSlashedId("a/b*c").equals(vtp.add("a/b*c", "TimeConst")));
		assertTrue(vtp.go(DataPath.makeSlashedId("a/b*c")));
		assertTrue(vtp.go("TimeConstElementList"));
		
		String[] tceId = {
				"a/", "b\\" , "****c****"
		};
		assertTrue(DataPath.makeSlashedId(tceId).equals(vtp.add(DataPath.makeId(tceId), "TimeConstElement")));
		assertTrue(vtp.go(DataPath.makeSlashedId(tceId)));
		
	}
	
	@Test
	@Ignore
	public void testAddLeafSlash() {
		
		IVarTreePointer vtp = populate2();
		
		assertTrue(vtp.goAbsolute(S + sh_system_path));
		assertTrue("Name".equals(vtp.add("Name", new StringVar("N*ome"))));
		assertTrue(DataPath.makeSlashedId("N*ome").equals(vtp.getName()));
		assertTrue(vtp.go("Name"));
		assertTrue("N*ome".equals(vtp.getVar().get()));
		assertTrue(vtp.goParent());
		
		assertTrue(vtp.goAbsolute(S + DataPath.makeSlashedId("N*ome")));

		assertTrue(vtp.go("Functional" +S+ "Implementation" +S+ sh_proc_path));
		
		StringMVar smv = new StringMVar();
		try {
			smv.appendValue("a");
			smv.appendValue("b");
			smv.appendValue("c");
		} catch (NotValidValueException e) { assertTrue(false); }
		assertTrue("Methods".equals(vtp.add("Methods", smv)));
	}

	@Test
	@Ignore
	public void testGoAbsoluteSlash() {
		IVarTreePointer vtp = new MyVTPEMF(new BasicEList<EObject>(), editingDomain);

		assertFalse(vtp.goAbsolute(S+ sh_system_path));

		assertFalse(vtp.goAbsolute(S+ sh_system_path +S+ "Architectural"));
		assertFalse(vtp.goAbsolute(S+ sh_system_path +S+ "Architectural2"));
		assertFalse(vtp.goAbsolute(S+ sh_system_path +S+ "Modes"));

		vtp = populate2();
		
		assertTrue(vtp.goAbsolute(S +sh_system_path));
		assertTrue(sh_system_path.equals(vtp.getName()));

		assertFalse(vtp.goAbsolute(S +sh_system_path +S+ "Modes"));
		assertTrue(sh_system_path.equals(vtp.getName()));

		assertTrue(vtp.goAbsolute(S + sh_system_path +S+ "Architectural" +S+ "TaskList" +S+ sh_task_path));
		assertTrue(sh_task_path.equals(vtp.getName()));
		
		assertTrue(vtp.goAbsolute(S + sh_system_path +S+ "Architectural" +S+S+ "TaskList"));
		assertTrue("TaskList".equals(vtp.getName()));
	}
	
	@Test
	@Ignore
	public void testGoSlash() {		
		IVarTreePointer vtp = new MyVTPEMF(new BasicEList<EObject>(), editingDomain);
		assertFalse(vtp.go("Architectural"));

		vtp = populate2();

		assertFalse(vtp.go("Architectural2"));
		assertFalse(vtp.go("Modes"));

		assertTrue(vtp.go(sh_system_path));
		assertTrue(sh_system_path.equals(vtp.getName()));
		
		assertTrue(vtp.go("Architectural"));
		assertTrue("Architectural".equals(vtp.getName()));

		assertFalse(vtp.go("task2"));
		assertTrue("Architectural".equals(vtp.getName()));
		assertTrue("Architectural".equals(vtp.getType()));

		assertTrue(vtp.go("TaskList"));
		assertTrue("TaskList".equals(vtp.getName()));
		assertTrue("TaskList".equals(vtp.getType()));

		assertTrue(DataPath.makeSlashedId("m*yTask2").equals(vtp.add("m*yTask2","Task")));
		assertTrue(DataPath.makeSlashedId("m*yTask2").equals(vtp.add("m*yTask2","Task")));
		
		assertTrue(vtp.go(DataPath.makeSlashedId("m*yTask2")));
	}
	
	@Test
	@Ignore
	public void testExistAbsoluteSlash() {
		IVarTreePointer vtp = populate2();

		assertFalse(vtp.existAbsolute(S+ sh_system_path +S+ "Architectural2"));

		assertTrue(vtp.existAbsolute(S+sh_system_path +S+ "Architectural"));
		assertNull(vtp.getName());
		assertTrue("root_Node's_Type".equals(vtp.getType()));

		assertTrue(vtp.go(sh_system_path));
		
		assertTrue(vtp.existAbsolute(null));
		assertTrue(sh_system_path.equals(vtp.getName()));
		assertTrue("System".equals(vtp.getType()));

		assertFalse(vtp.go("Task"));
		assertTrue(vtp.existAbsolute(S+sh_system_path+S+"Architectural" +S+ "TaskList" +S+ sh_task_path));
		assertTrue(sh_system_path.equals(vtp.getName()));
		assertTrue("System".equals(vtp.getType()));
	}
	
	@Test
	@Ignore
	public void testExistSlash() {
		IVarTreePointer vtp = populate2();

		assertFalse(vtp.exist("Architectural2"));

		assertFalse(vtp.exist("Architectural"));
		assertTrue(vtp.exist(sh_system_path));
		assertNull(vtp.getName());
		assertTrue("root_Node's_Type".equals(vtp.getType()));

		assertTrue(vtp.go(sh_system_path));
		
		assertTrue(vtp.exist("Architectural"));
		assertTrue(vtp.exist("Mapping"));
		assertTrue(sh_system_path.equals(vtp.getName()));
		assertTrue("System".equals(vtp.getType()));

		assertTrue(vtp.exist("Functional" +S+ "Implementation"));

		assertTrue(vtp.go("Functional"));
		assertTrue("Functional".equals(vtp.getName()));
		assertTrue("Functional".equals(vtp.getType()));

		assertTrue(vtp.exist("Implementation"));
		assertTrue(vtp.exist("EventList"));
		assertTrue(vtp.exist("Implementation"));
		assertTrue("Functional".equals(vtp.getName()));
		assertTrue("Functional".equals(vtp.getType()));
	}
	
	@Test
	@Ignore
	public void testGoFirstChildSlash() {
		IVarTreePointer vtp = populate2();
		
		// system
		assertTrue(vtp.goFirstChild());
		assertTrue(sh_system_path.equals(vtp.getName()));
		assertTrue("System".equals(vtp.getType()));
		
		assertTrue(vtp.goFirstChild());
		{ // architectural
			assertTrue("Architectural".equals(vtp.getName()));
			assertTrue("Architectural".equals(vtp.getType()));

			assertTrue(vtp.goFirstChild());
			{ // bus
				assertTrue("BusList".equals(vtp.getName()));
				assertTrue("BusList".equals(vtp.getType()));
			
				assertTrue(vtp.goParent());
			}
			
			// architectural
			assertTrue(vtp.go("TaskList"));
			
			
			{ // task
				assertTrue("TaskList".equals(vtp.getName()));
				assertTrue("TaskList".equals(vtp.getType()));
			
				assertTrue(vtp.goFirstChild());
				
				{ // myTask
					assertTrue(sh_task_path.equals(vtp.getName()));
					assertTrue("Task".equals(vtp.getType()));
				}
				
			}
			
		}
	}
	@Test
	@Ignore
	public void testGetChildrenNumberSlash() {
		IVarTreePointer vtp = populate2();

		assertEquals(vtp.getChildrenNumber(), 1);
		assertTrue(vtp.go(sh_system_path));

		assertEquals(vtp.getChildrenNumber(), 5);
		
		assertTrue(vtp.go("Mapping"));
		assertEquals(vtp.getChildrenNumber(), 4); // taskMap, procMap, varMap, FastTaskToProcMap

		assertTrue(vtp.goAbsolute(S+sh_system_path+S+"Name"));
		assertEquals(vtp.getChildrenNumber(), 0); // variable
		
		assertTrue(vtp.goAbsolute(S+sh_system_path+S+"Architectural" +S+ "TaskList" +S+ sh_task_path));
		assertEquals(vtp.getChildrenNumber(), 6); // variable

		assertTrue(vtp.goAbsolute(S+sh_system_path+S+"Functional"));
		assertEquals(vtp.getChildrenNumber(), 4); // variable
	}
	
	@Test
	@Ignore
	public void testGoNextSiblingSlash() {
		IVarTreePointer vtp = populate2();
		
		assertTrue(vtp.goFirstChild());
		assertFalse(vtp.goNextSibling());
		// system
		assertTrue(vtp.goFirstChild());
		{ // architectural
			assertTrue("Architectural".equals(vtp.getName()));
			assertTrue("Architectural".equals(vtp.getType()));

			assertTrue(vtp.goNextSibling());
		}
		
		{ // functional
			assertTrue("Functional".equals(vtp.getName()));
			assertTrue("Functional".equals(vtp.getType()));

			assertTrue(vtp.goNextSibling());
		}
		{ // mapping
			assertTrue("Mapping".equals(vtp.getName()));
			assertTrue("Mapping".equals(vtp.getType()));

			assertTrue(vtp.goNextSibling());
		}
		{ // name
			assertTrue("Name".equals(vtp.getName()));
			assertTrue("StringVar".equals(vtp.getType()));

			assertTrue(vtp.goNextSibling());
		}
		{ // xtc
			assertTrue("XTC_Cookie".equals(vtp.getName()));
			assertTrue("StringVar[]".equals(vtp.getType()));

			assertFalse(vtp.goNextSibling());
		}

		
		assertTrue(vtp.goAbsolute(S+sh_system_path+S+ "Architectural" +S+ "TaskList"));
		assertEquals(vtp.getChildrenNumber(), 1);

		assertTrue("aaa".equals(vtp.add("aaa","Task")));
		assertEquals(vtp.getChildrenNumber(), 2);

		assertTrue("zzz".equals(vtp.add("zzz","Task")));
		assertEquals(vtp.getChildrenNumber(), 3);

		
		{ // task
			assertTrue("TaskList".equals(vtp.getName()));
			assertTrue("TaskList".equals(vtp.getType()));
		
			assertTrue(vtp.goFirstChild());
			
			{ // myTask
				assertTrue(sh_task_path.equals(vtp.getName()));
				assertTrue("Task".equals(vtp.getType()));
				
				assertTrue(vtp.goNextSibling());
			}
			{ // aaa
				assertTrue("aaa".equals(vtp.getName()));
				assertTrue("Task".equals(vtp.getType()));
				
				assertTrue(vtp.goNextSibling());
			}
			{ // zzz
				assertTrue("zzz".equals(vtp.getName()));
				assertTrue("Task".equals(vtp.getType()));
				
				assertFalse(vtp.goNextSibling());
			}
			
		}
		
		
		assertTrue(vtp.goAbsolute(S+sh_system_path+S+ "Functional"));
		assertEquals(vtp.getChildrenNumber(), 4);
		{

			assertTrue(vtp.goFirstChild());
			
			{ // eventList
				assertTrue("EventList".equals(vtp.getName()));
				assertTrue("EventList".equals(vtp.getType()));
				
				assertTrue(vtp.goNextSibling());
			}
			{ // partialOrderList
				assertTrue("PartialOrderList".equals(vtp.getName()));
				assertTrue("PartialOrderList".equals(vtp.getType()));
				
				assertTrue(vtp.goNextSibling());
			}
			{ // systemImplementation
				assertTrue("Implementation".equals(vtp.getName()));
				assertTrue("Implementation".equals(vtp.getType()));
				
				assertTrue(vtp.goNextSibling());
			}
			{ // timeConstList
				assertTrue("TimeConstList".equals(vtp.getName()));
				assertTrue("TimeConstList".equals(vtp.getType()));

				assertFalse(vtp.goNextSibling());
			}

		}

	}
	
	@Test
	@Ignore
	public void testGoParentSlash() {
		IVarTreePointer vtp = populate2();
		
		assertTrue(vtp.goAbsolute(S+sh_system_path+S+ "Architectural" +S+ "TaskList" +S+ sh_task_path));
		assertTrue(sh_task_path.equals(vtp.getName()));
		assertTrue("Task".equals(vtp.getType()));
		
		assertTrue(vtp.goParent());
		assertTrue("TaskList".equals(vtp.getName()));
		assertTrue("TaskList".equals(vtp.getType()));

		assertTrue(vtp.goParent());
		assertTrue("Architectural".equals(vtp.getName()));
		assertTrue("Architectural".equals(vtp.getType()));

		assertTrue(vtp.goParent());
		assertTrue(sh_system_path.equals(vtp.getName()));
		assertTrue("System".equals(vtp.getType()));

		assertTrue(vtp.goParent());
		assertFalse(vtp.goParent());
	}
	
	@Test
	@Ignore
	public void testGetVarSlash() {
		IVarTreePointer vtp = populate2();
		
		assertTrue(vtp.go(sh_system_path));
		StringVar sv = new StringVar("N*ome");
		vtp.add("Name", sv);
		assertTrue(vtp.go("Name"));
		StringVar svr = (StringVar) vtp.getVar();
		assertNotSame(svr, sv);
		assertTrue("N*ome".equals(svr.get()));
		assertSame("N*ome", svr.get()); // NB !!!
		
		sv.set("Ciao");
		StringVar svr2 = (StringVar) vtp.getVar();
		assertNotSame(svr2, sv);
		assertTrue("N*ome".equals(svr.get()));
		assertSame("N*ome", svr.get()); // NB !!!
		assertTrue("N*ome".equals(svr2.get()));
		assertSame("N*ome", svr2.get()); // NB !!!
		
		//---------
		
		assertTrue(vtp.goAbsolute(S+DataPath.makeSlashedId("N*ome")+S+ "Functional" +S+ "Implementation" +S+ sh_proc_path));
		StringMVar smv = new StringMVar();
		try {
			smv.appendValue("a");
			smv.appendValue("b");
			smv.appendValue("c");
			smv.appendValue("a");
			smv.appendValue("b");
			smv.appendValue("c");
		} catch (NotValidValueException e) { assertTrue(false); }
		assertTrue("Methods".equals(vtp.add("Methods", smv)));
		assertTrue(vtp.go("Methods"));
		
		StringMVar smvr = (StringMVar) vtp.getVar();
		assertNotSame(smv, smvr);

		for (int i=0; i<2; i++) {
			smvr = (StringMVar) vtp.getVar();

			// NB! proc.getMethods use Unique Data Type 
			assertEquals(smvr.sizeValues(), 3);
			String[] val = smvr.getValues();
			assertTrue("a".equals(val[0]));
			assertTrue("b".equals(val[1]));
			assertTrue("c".equals(val[2]));
			
			smv.clearValues();
		}

		// -------------
		
		assertTrue(vtp.goAbsolute(S+ DataPath.makeSlashedId("N*ome") +S+ "Architectural" +S+ "TaskList" +S+ sh_task_path +S+ "Type"));
		StringVar type = (StringVar) vtp.getVar();
		assertTrue(type == null || type.get() == null );
		//assertTrue(type.get() == null);
	}

	@Test
	@Ignore
	public void testSetVarSlash() {
		IVarTreePointer vtp = populate2();
		
		assertTrue(vtp.go(sh_system_path +S+  "Name"));
		StringVar sv = new StringVar("N*ome");
		vtp.setVar(sv);

		assertFalse(vtp.existAbsolute(sh_system_path));
		assertFalse(vtp.exist(sh_system_path +S+  "Name"));

		StringVar svr = (StringVar) vtp.getVar();
		assertNotSame(svr, sv);
		assertTrue("N*ome".equals(svr.get()));
		assertSame("N*ome", svr.get()); // NB !!!
		
		sv.set("Ciao");
		StringVar svr2 = (StringVar) vtp.getVar();
		assertNotSame(svr2, sv);
		assertTrue("N*ome".equals(svr.get()));
		assertSame("N*ome", svr.get()); // NB !!!
		
		//---------
		
		assertTrue(vtp.goAbsolute(S+ DataPath.makeSlashedId("N*ome") +S+ "Functional" +S+ "Implementation" +S+ sh_proc_path +S+ "Methods"));
		StringMVar smv = new StringMVar();
		try {
			smv.appendValue("a");
			smv.appendValue("b");
			smv.appendValue("c");
			smv.appendValue("a");
			smv.appendValue("b");
			smv.appendValue("c");
		} catch (NotValidValueException e) { assertTrue(false); }
		vtp.setVar(smv);
		
		StringMVar smvr = (StringMVar) vtp.getVar();
		assertNotSame(smv, smvr);

		for (int i=0; i<2; i++) {
			smvr = (StringMVar) vtp.getVar();

			// NB! proc.getMethods use Unique Data Type 
			assertEquals(smvr.sizeValues(), 3);
			String[] val = smvr.getValues();
			assertTrue("a".equals(val[0]));
			assertTrue("b".equals(val[1]));
			assertTrue("c".equals(val[2]));
			
			smv.clearValues();
		}

	}

	// checked in all functions
	//public void testGetName() {}

	// checked in all functions
	// public void testGetType() {}

	@Test
	@Ignore
	public void testIsContainerSlash() {
		IVarTreePointer vtp = populate2();
	
		assertTrue(vtp.isContainer());
		
		assertTrue(vtp.go(sh_system_path+S+"Name"));
		assertFalse(vtp.isContainer());

		assertTrue(vtp.goAbsolute(S+ sh_system_path+S+"Architectural"));
		assertTrue(vtp.isContainer());

		assertTrue(vtp.go("TaskList"));
		assertTrue(vtp.isContainer());
		
		assertTrue(vtp.go(sh_task_path));
		assertTrue(vtp.isContainer());
		
		assertTrue(vtp.go("Type"));
		assertFalse(vtp.isContainer());
	}

	@Test
	@Ignore
	public void testDestroySlash() {
		IVarTreePointer vtp = populate2();
		
		assertTrue(vtp.go(sh_system_path));
		assertTrue(sh_system_path.equals(vtp.getName()));
		assertTrue("System".equals(vtp.getType()));
		
		assertEquals(vtp.getChildrenNumber(), 5);

		assertTrue(vtp.go("Architectural"));
		vtp.destroy();
		
		assertTrue(sh_system_path.equals(vtp.getName()));
		assertTrue("System".equals(vtp.getType()));
		
		assertFalse(vtp.go("Architectural"));
		assertEquals(vtp.getChildrenNumber(), 4);

		// -------
		assertTrue("Name".equals(vtp.add("Name", new StringVar("Ciao"))));
		assertEquals(vtp.getChildrenNumber(), 4);
		assertTrue("Ciao".equals(vtp.getName()));
		assertTrue("System".equals(vtp.getType()));
		
		assertTrue(vtp.go("Name"));
		vtp.destroy();

		assertTrue(DataPath.makeSlashedId((String) null).equals(vtp.getName()));
		assertTrue("System".equals(vtp.getType()));
		
		assertFalse(vtp.go("Architectural"));
		assertEquals(vtp.getChildrenNumber(), 4);
		
		// -------
		vtp.destroy();
		assertSame(null, vtp.getName());
		assertTrue("root_Node's_Type".equals(vtp.getType()));
		
		assertEquals(vtp.getChildrenNumber(), 0);
		assertFalse(vtp.go("Architectural"));
		assertFalse(vtp.go("Functional"));
		assertFalse(vtp.go("Mapping"));
		
	}

}
