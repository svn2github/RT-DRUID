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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.junit.Test;

import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.VarTreePointerEMF;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.variables.StringMVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;


/**
 * @author Nicola Serreli
 */
public abstract class VarTreePointerEMFTest {

	
	private final static String S = "" + IVarTree.SEPARATOR;

	private EditingDomain editingDomain;
	
	private Map<String, Integer> nodeChildren = new HashMap<String, Integer>();

	/* Values set by the effective class */
	protected String NAME_SYSTEM;
	protected String NAME_TASK;
	protected String NAME_PROC;
	protected String NAME_VAR;
	protected String NAME_TIME_CONST_ELEMENT;
	protected String[] tceId;

	protected String VALUE_NEW_NAME;

	/* Shared Values */
	private String RNAME_SYSTEM;
	private String RNAME_TASK;
	private String RNAME_PROC;
	private String RNAME_VAR;
	private String RNAME_TIME_CONST_ELEMENT;

	private final static String NAME_NAME = "Name";
	private final static String NAME_PROPERTIES = "properties";
	private final static String NAME_ANNOTATION = "Annotation";
	private final static String NAME_ARCHITECTURAL = "Architectural";
	private final static String NAME_FUNCTIONAL = "Functional";
	private final static String NAME_IMPLEMENTATION = "Implementation";
	private final static String NAME_MAPPING = "Mapping";
	private final static String NAME_MODES = "Modes";
	private final static String NAME_TASK_LIST = "TaskList";
	private final static String NAME_SCHEDULABILITY = "Schedulability";
	private final static String NAME_TIME_CONST_LIST = "TimeConstList";
	private final static String NAME_TIME_CONST_ELEMENT_LIST = "TimeConstElementList";

	private final static String TYPE_SYSTEM = "System";
	private final static String TYPE_ANNOTATION = NAME_ANNOTATION;
	private final static String TYPE_ARCHITECTURAL = NAME_ARCHITECTURAL;
	private final static String TYPE_FUNCTIONAL = NAME_FUNCTIONAL;
	private final static String TYPE_IMPLEMENTATION = NAME_IMPLEMENTATION;
	private final static String TYPE_PROC = "Proc";
	private final static String TYPE_VAR = "Var";
	private final static String TYPE_MAPPING = NAME_MAPPING;
	private final static String TYPE_MODES = NAME_MODES;
	private final static String TYPE_TASK = "Task";
	private final static String TYPE_TASK_LIST = NAME_TASK_LIST;
	private final static String TYPE_SCHEDULABILITY = NAME_SCHEDULABILITY;
	private final static String TYPE_TIME_CONST_LIST = NAME_TIME_CONST_LIST;
	private final static String TYPE_TIME_CONST = "TimeConst";
	
	
	protected void completePaths() {
		RNAME_SYSTEM = DataPath.makeSlashedId(NAME_SYSTEM);
		RNAME_TASK = DataPath.makeSlashedId(NAME_TASK);
		RNAME_PROC = DataPath.makeSlashedId(NAME_PROC);
		RNAME_VAR = DataPath.makeSlashedId(NAME_VAR);
		RNAME_TIME_CONST_ELEMENT = DataPath.makeSlashedId(NAME_TIME_CONST_ELEMENT);
		
		editingDomain = VarTreeUtil.newVarTree();
	}
	
	private void initExpectedChildrenNumber(String type, int value) {
		nodeChildren.put(type, new Integer(value));
	}
	
	protected int expectedChildrenNumber(String type) {
		assertTrue(nodeChildren.containsKey(type));
		return nodeChildren.get(type).intValue();
	}
	
	
	/**
	 */
	private IVarTreePointer populate() {
		IVarTreePointer vtp = new VarTreePointerEMF(new BasicEList<EObject>(), editingDomain);

		assertEquals(RNAME_SYSTEM, vtp.add(NAME_SYSTEM, TYPE_SYSTEM));
		assertTrue(vtp.go(RNAME_SYSTEM));

		assertEquals(NAME_ARCHITECTURAL, vtp.add(NAME_ARCHITECTURAL, TYPE_ARCHITECTURAL));
		assertEquals(NAME_MAPPING, vtp.add(NAME_MAPPING,TYPE_MAPPING));
		assertEquals(NAME_FUNCTIONAL, vtp.add(NAME_FUNCTIONAL,TYPE_FUNCTIONAL));

		assertTrue(vtp.go(NAME_ARCHITECTURAL));
		assertTrue(vtp.go(NAME_TASK_LIST));

		assertEquals(RNAME_TASK, vtp.add(NAME_TASK,TYPE_TASK));
		
		assertTrue(vtp.goAbsolute(S + RNAME_SYSTEM + S + NAME_FUNCTIONAL));
		assertTrue(vtp.go(NAME_IMPLEMENTATION));

		assertEquals(RNAME_PROC, vtp.add(NAME_PROC,TYPE_PROC));
		assertEquals(RNAME_VAR, vtp.add(NAME_VAR,TYPE_VAR));

		assertTrue(vtp.goAbsolute(null));

		EPackage epkg = editingDomain.getResourceSet().getPackageRegistry().getEPackage(DataPackage.eNS_URI);

		nodeChildren.clear();
		initExpectedChildrenNumber(TYPE_SYSTEM, count(epkg, TYPE_SYSTEM) + 3); // attributes + 3 references
		initExpectedChildrenNumber(TYPE_ARCHITECTURAL, count(epkg, TYPE_ARCHITECTURAL)); 
		initExpectedChildrenNumber(TYPE_TASK_LIST, 1); // 1 Task
		
		initExpectedChildrenNumber(TYPE_MAPPING, count(epkg, TYPE_MAPPING)); 
		initExpectedChildrenNumber(TYPE_FUNCTIONAL, count(epkg, TYPE_FUNCTIONAL));
		initExpectedChildrenNumber(TYPE_TASK, count(epkg, TYPE_TASK) ); 
		

		return vtp;
	}

	private int count(EPackage epkg, String type) {
		int answer = 0;
		EClass ecl = ((EClass) epkg.getEClassifier(type)); 
		answer += ecl.getEAllAttributes().size();
		
		for (EReference ref: ecl.getEAllReferences()) {
			if (ref.isMany()) {
				answer++;
			}
		}
		return answer;
	}
	

	@Test
	public void testClone() {
		IVarTreePointer vtp = new VarTreePointerEMF(new BasicEList<EObject>(), editingDomain);

		assertEquals(RNAME_SYSTEM, vtp.add(NAME_SYSTEM, TYPE_SYSTEM));
		assertTrue(vtp.go(RNAME_SYSTEM));

		assertEquals(NAME_ARCHITECTURAL, vtp.add(NAME_ARCHITECTURAL, TYPE_ARCHITECTURAL));
		assertEquals(NAME_MODES, vtp.add(NAME_MODES,TYPE_MODES));

		IVarTreePointer vtp2 = (IVarTreePointer) vtp.clone();
		assertTrue(vtp.go(NAME_ARCHITECTURAL));
		assertFalse(vtp.go("Architectural2"));
		assertFalse(vtp.go(NAME_MODES));

		assertFalse(vtp.go(TYPE_TASK));
		assertTrue(vtp.go(NAME_TASK_LIST));

		assertEquals(RNAME_SYSTEM, vtp2.getName());
		
	}
	
	/*
	 * Class to test for String add(String, String)
	 */
	@Test
	public void testAddStringString() {
		IVarTreePointer vtp = new VarTreePointerEMF(new BasicEList<EObject>(), editingDomain);

		assertEquals(RNAME_SYSTEM, vtp.add(NAME_SYSTEM, TYPE_SYSTEM));
		assertTrue(vtp.go(RNAME_SYSTEM));
		assertFalse(vtp.go(NAME_FUNCTIONAL));

		String[][] elems = {
			{NAME_ARCHITECTURAL, TYPE_ARCHITECTURAL},
			{NAME_FUNCTIONAL, TYPE_FUNCTIONAL},
			{NAME_MODES, TYPE_MODES},
			{NAME_ANNOTATION, TYPE_ANNOTATION},
			{NAME_MAPPING, TYPE_MAPPING},
			{NAME_SCHEDULABILITY, TYPE_SCHEDULABILITY}
		};
		
		for (int i=0; i< elems.length; i++) {
			assertEquals(elems[i][0], vtp.add(elems[i][0],elems[i][1]));
		}
		for (int i=0; i< elems.length; i++) {
			assertEquals(elems[i][0], vtp.add(elems[i][0],elems[i][1]));
		}
		
		boolean risp = false;
		try {
       		vtp.add(NAME_NAME,TYPE_MODES);
		} catch (RuntimeException e) { risp = true; } assertTrue(risp);
		

		// add a node with an composed ID
		assertTrue(vtp.go(NAME_FUNCTIONAL));
		assertEquals(NAME_TIME_CONST_LIST, vtp.add(NAME_TIME_CONST_LIST,TYPE_TIME_CONST_LIST));
		assertTrue(vtp.go(NAME_TIME_CONST_LIST));
		assertEquals(RNAME_TIME_CONST_ELEMENT, vtp.add(NAME_TIME_CONST_ELEMENT, TYPE_TIME_CONST));
		assertTrue(vtp.go(DataPath.makeSlashedId(NAME_TIME_CONST_ELEMENT)));
		assertTrue(vtp.go(NAME_TIME_CONST_ELEMENT_LIST));
		
		
		assertEquals(DataPath.makeSlashedId(tceId), vtp.add(DataPath.makeId(tceId), "TimeConstElement"));
		assertTrue(vtp.go(DataPath.makeSlashedId(tceId)));
	}
	
	@Test
	public void testAddLeaf() {
		
		IVarTreePointer vtp = populate();
		
		assertTrue(vtp.goAbsolute(S + RNAME_SYSTEM));
		assertEquals(NAME_NAME, vtp.add(NAME_NAME, new StringVar(VALUE_NEW_NAME)));
		assertEquals(DataPath.makeSlashedId(VALUE_NEW_NAME), vtp.getName());
		assertTrue(vtp.go(NAME_NAME));
		assertEquals(VALUE_NEW_NAME, vtp.getVar().get());
		assertTrue(vtp.goParent());
		assertTrue(vtp.go(NAME_FUNCTIONAL +S+ NAME_IMPLEMENTATION +S+ RNAME_PROC));
		
		assertTrue(vtp.goAbsolute(S + DataPath.makeSlashedId(VALUE_NEW_NAME)));
		
		assertTrue(vtp.go(NAME_FUNCTIONAL +S+ NAME_IMPLEMENTATION +S+ RNAME_PROC));
		
		StringMVar smv = new StringMVar();
//		try {
			smv.appendValue("a");
			smv.appendValue("b");
			smv.appendValue("c");
//		} catch (NotValidValueException e) { assertTrue(false); }
		assertEquals("Methods", vtp.add("Methods", smv));
	}

	@Test
	public void testGoAbsolute() {
		IVarTreePointer vtp = new VarTreePointerEMF(new BasicEList<EObject>(), editingDomain);

		assertFalse(vtp.goAbsolute(S+ RNAME_SYSTEM));

		assertFalse(vtp.goAbsolute(S+ RNAME_SYSTEM +S+ NAME_ARCHITECTURAL));
		assertFalse(vtp.goAbsolute(S+ RNAME_SYSTEM +S+ "Architectural2"));
		assertFalse(vtp.goAbsolute(S+ RNAME_SYSTEM +S+ NAME_MODES));

		vtp = populate();
		
		assertTrue(vtp.goAbsolute(S +RNAME_SYSTEM));
		assertEquals(RNAME_SYSTEM, vtp.getName());

		assertFalse(vtp.goAbsolute(S +RNAME_SYSTEM +S+ NAME_MODES));
		assertEquals(RNAME_SYSTEM, vtp.getName());

		assertTrue(vtp.goAbsolute(S +RNAME_SYSTEM));
		assertEquals(NAME_MODES, vtp.add(NAME_MODES,TYPE_MODES));
		assertTrue(vtp.goAbsolute(S +RNAME_SYSTEM +S+ NAME_MODES));
		assertEquals(NAME_MODES, vtp.getName());

		assertTrue(vtp.goAbsolute(S + RNAME_SYSTEM +S+ NAME_ARCHITECTURAL +S+ NAME_TASK_LIST +S+ RNAME_TASK));
		assertEquals(RNAME_TASK, vtp.getName());
		
		assertTrue(vtp.goAbsolute(S + RNAME_SYSTEM +S+ NAME_ARCHITECTURAL +S+S+ NAME_TASK_LIST));
		assertEquals(NAME_TASK_LIST, vtp.getName());
	}
	
	@Test
	public void testGo() {		
		IVarTreePointer vtp = new VarTreePointerEMF(new BasicEList<EObject>(), editingDomain);

		assertFalse(vtp.go(S+ RNAME_SYSTEM));
		assertFalse(vtp.go(RNAME_SYSTEM));
		assertFalse(vtp.go(NAME_ARCHITECTURAL));

		assertEquals(RNAME_SYSTEM, vtp.add(NAME_SYSTEM, TYPE_SYSTEM));
		assertTrue(vtp.go(RNAME_SYSTEM));

		assertFalse(vtp.go(NAME_ARCHITECTURAL));
		assertFalse(vtp.go("Architectural2"));
		assertFalse(vtp.go(NAME_MODES));

		assertEquals(NAME_ARCHITECTURAL, vtp.add(NAME_ARCHITECTURAL, TYPE_ARCHITECTURAL));
		assertTrue(vtp.go(NAME_ARCHITECTURAL));

		vtp = populate();

		assertFalse(vtp.go("Architectural2"));
		assertFalse(vtp.go(NAME_MODES));

		assertTrue(vtp.go(RNAME_SYSTEM));
		assertEquals(RNAME_SYSTEM, vtp.getName());
		
		assertTrue(vtp.go(NAME_ARCHITECTURAL));
		assertEquals(NAME_ARCHITECTURAL, vtp.getName());

		assertFalse(vtp.go("task2"));
		assertEquals(NAME_ARCHITECTURAL, vtp.getName());
		assertEquals(NAME_ARCHITECTURAL, vtp.getType());

		assertTrue(vtp.go(NAME_TASK_LIST));
		assertEquals(NAME_TASK_LIST, vtp.getName());
		assertEquals(TYPE_TASK_LIST, vtp.getType());

		assertEquals(RNAME_TASK, vtp.add(NAME_TASK,TYPE_TASK));
		assertEquals(RNAME_TASK, vtp.add(NAME_TASK,TYPE_TASK));
		
		assertTrue(vtp.go(RNAME_TASK));
	}
	
	@Test
	public void testExistAbsolute() {
		IVarTreePointer vtp = populate();

		assertFalse(vtp.existAbsolute(S+RNAME_SYSTEM +S+ "Architectural2"));

		assertTrue(vtp.existAbsolute(S+RNAME_SYSTEM +S+ NAME_ARCHITECTURAL));
		assertNull(vtp.getName());
		assertEquals("root_Node's_Type", vtp.getType());

		assertTrue(vtp.go(RNAME_SYSTEM));
		
		assertTrue(vtp.existAbsolute(null));
		assertEquals(RNAME_SYSTEM, vtp.getName());
		assertEquals( TYPE_SYSTEM, vtp.getType());

		assertFalse(vtp.go(TYPE_TASK));
		assertTrue(vtp.existAbsolute(S+RNAME_SYSTEM+S+NAME_ARCHITECTURAL +S+ NAME_TASK_LIST +S+ RNAME_TASK));
		assertEquals(RNAME_SYSTEM, vtp.getName());
		assertEquals( TYPE_SYSTEM, vtp.getType());
	}
	
	@Test
	public void testExist() {
		IVarTreePointer vtp = populate();

		assertFalse(vtp.exist("Architectural2"));

		assertFalse(vtp.exist(NAME_ARCHITECTURAL));
		assertTrue(vtp.exist(RNAME_SYSTEM));
		assertNull(vtp.getName());
		assertEquals("root_Node's_Type", vtp.getType());

		assertTrue(vtp.go(RNAME_SYSTEM));
		
		assertTrue(vtp.exist(NAME_ARCHITECTURAL));
		assertTrue(vtp.exist(NAME_MAPPING));
		assertEquals(RNAME_SYSTEM, vtp.getName());
		assertEquals( TYPE_SYSTEM, vtp.getType());

		assertTrue(vtp.exist(NAME_FUNCTIONAL +S+ NAME_IMPLEMENTATION));

		assertTrue(vtp.go(NAME_FUNCTIONAL));
		assertEquals(NAME_FUNCTIONAL, vtp.getName());
		assertEquals(TYPE_FUNCTIONAL, vtp.getType());

		assertTrue(vtp.exist(NAME_IMPLEMENTATION));
		assertTrue(vtp.exist("EventList"));
		assertTrue(vtp.exist(NAME_IMPLEMENTATION));
		assertEquals(NAME_FUNCTIONAL, vtp.getName());
		assertEquals(TYPE_FUNCTIONAL, vtp.getType());
	}
	
	@Test	
	public void testGoFirstChild() {
		IVarTreePointer vtp = populate();
		
		// system
		assertTrue(vtp.goFirstChild());
		assertEquals(RNAME_SYSTEM, vtp.getName());
		assertEquals(TYPE_SYSTEM, vtp.getType());
		
		assertTrue(vtp.goFirstChild());
		assertEquals(vtp.getName(), NAME_PROPERTIES, vtp.getName());
		
		assertTrue(vtp.goParent());
		
		{ // architectural
			assertTrue(vtp.go(NAME_ARCHITECTURAL));
			assertEquals(vtp.getName(), NAME_ARCHITECTURAL, vtp.getName());
			assertEquals(NAME_ARCHITECTURAL, vtp.getType());

			assertTrue(vtp.goFirstChild());
			{ // bus
				assertEquals(NAME_PROPERTIES, vtp.getName());
				//assertEquals("BusList", vtp.getType());
			
				assertTrue(vtp.goParent());
			}
			
			// architectural
			assertTrue(vtp.go(NAME_TASK_LIST));
			
			
			{ // task
				assertEquals(NAME_TASK_LIST, vtp.getName());
				assertEquals(TYPE_TASK_LIST, vtp.getType());
			
				assertTrue(vtp.goFirstChild());
				
				{ // myTask
					assertEquals(RNAME_TASK, vtp.getName());
					assertEquals(TYPE_TASK, vtp.getType());
				}
				
			}
			
		}
	}
	@Test
	public void testGetChildrenNumber() {
		IVarTreePointer vtp = populate();

		assertEquals(1, vtp.getChildrenNumber());
		assertTrue(vtp.go(RNAME_SYSTEM));

		assertEquals(expectedChildrenNumber(TYPE_SYSTEM), vtp.getChildrenNumber());
		
		assertTrue(vtp.go(NAME_MAPPING));
		assertEquals(expectedChildrenNumber(NAME_MAPPING), vtp.getChildrenNumber()); // taskMap, procMap, varMap, FastTaskToProcMap

		assertTrue(vtp.goAbsolute(S+RNAME_SYSTEM+S+NAME_NAME));
		assertEquals(0, vtp.getChildrenNumber()); // variable
		
		assertTrue(vtp.goAbsolute(S+RNAME_SYSTEM+S+NAME_ARCHITECTURAL +S+ NAME_TASK_LIST +S+ RNAME_TASK));
		assertEquals(expectedChildrenNumber(TYPE_TASK), vtp.getChildrenNumber()); // variable

		assertTrue(vtp.goAbsolute(S+RNAME_SYSTEM+S+NAME_FUNCTIONAL));
		assertEquals(expectedChildrenNumber(TYPE_FUNCTIONAL), vtp.getChildrenNumber()); // variable
	}
	
	@Test
	public void testGoNextSibling() {
		IVarTreePointer vtp = populate();
		
		assertTrue(vtp.goFirstChild());
		assertFalse(vtp.goNextSibling());
		// system
		assertTrue(vtp.goFirstChild());
		{ // properties
			assertEquals(NAME_PROPERTIES, vtp.getName());

			assertTrue(vtp.goNextSibling());
		}

		{ // architectural
			assertEquals(NAME_ARCHITECTURAL, vtp.getName());
			assertEquals(TYPE_ARCHITECTURAL, vtp.getType());

			assertTrue(vtp.goNextSibling());
		}
		
		{ // functional
			assertEquals(NAME_FUNCTIONAL, vtp.getName());
			assertEquals(TYPE_FUNCTIONAL, vtp.getType());

			assertTrue(vtp.goNextSibling());
		}
		{ // mapping
			assertEquals(NAME_MAPPING, vtp.getName());
			assertEquals(TYPE_MAPPING, vtp.getType());

			assertTrue(vtp.goNextSibling());
		}
		{ // name
			assertEquals(NAME_NAME, vtp.getName());
			assertEquals("StringVar", vtp.getType());

			assertTrue(vtp.goNextSibling());
		}
		{ // xtc
			assertEquals("XTC_Cookie", vtp.getName());
			assertEquals("StringVar[]", vtp.getType());

			assertFalse(vtp.goNextSibling());
		}

		
		assertTrue(vtp.goAbsolute(S+RNAME_SYSTEM+S+ NAME_ARCHITECTURAL +S+ NAME_TASK_LIST));
		assertEquals(vtp.getChildrenNumber(), 1);

		assertEquals("aaa", vtp.add("aaa",TYPE_TASK));
		assertEquals(vtp.getChildrenNumber(), 2);

		assertEquals("zzz", vtp.add("zzz",TYPE_TASK));
		assertEquals(vtp.getChildrenNumber(), 3);

		
		{ // task
			assertEquals(NAME_TASK_LIST, vtp.getName());
			assertEquals(TYPE_TASK_LIST, vtp.getType());
		
			assertTrue(vtp.goFirstChild());
			
			{ // myTask
				assertEquals(RNAME_TASK, vtp.getName());
				assertEquals(TYPE_TASK, vtp.getType());
				
				assertTrue(vtp.goNextSibling());
			}
			{ // aaa
				assertEquals("aaa", vtp.getName());
				assertEquals(TYPE_TASK, vtp.getType());
				
				assertTrue(vtp.goNextSibling());
			}
			{ // zzz
				assertEquals("zzz", vtp.getName());
				assertEquals(TYPE_TASK, vtp.getType());
				
				assertFalse(vtp.goNextSibling());
			}
			
		}
		
		
		assertTrue(vtp.goAbsolute(S+RNAME_SYSTEM+S+ NAME_FUNCTIONAL));
		assertEquals(expectedChildrenNumber(TYPE_FUNCTIONAL), vtp.getChildrenNumber());
		{

			assertTrue(vtp.goFirstChild());
			{ // properties
				assertEquals(NAME_PROPERTIES, vtp.getName());

				assertTrue(vtp.goNextSibling());
			}

			{ // eventList
				assertEquals("EventList", vtp.getName());
				assertEquals("EventList", vtp.getType());
				
				assertTrue(vtp.goNextSibling());
			}
			{ // partialOrderList
				assertEquals("PartialOrderList", vtp.getName());
				assertEquals("PartialOrderList", vtp.getType());
				
				assertTrue(vtp.goNextSibling());
			}
			{ // systemImplementation
				assertEquals(NAME_IMPLEMENTATION, vtp.getName());
				assertEquals(TYPE_IMPLEMENTATION, vtp.getType());
				
				assertTrue(vtp.goNextSibling());
			}
			{ // timeConstList
				assertEquals(NAME_TIME_CONST_LIST, vtp.getName());
				assertEquals(TYPE_TIME_CONST_LIST, vtp.getType());

				assertTrue(vtp.goNextSibling());
			}
			{ // timeConstList
				assertEquals(vtp.getName(), "TypeList", vtp.getName());
				assertEquals("TypeList", vtp.getType());

				assertFalse(vtp.goNextSibling());
			}

		}

	}
	
	@Test
	public void testGoParent() {
		IVarTreePointer vtp = populate();
		
		assertTrue(vtp.goAbsolute(S+RNAME_SYSTEM+S+ NAME_ARCHITECTURAL +S+ NAME_TASK_LIST +S+ RNAME_TASK));
		assertEquals(RNAME_TASK, vtp.getName());
		assertEquals(TYPE_TASK, vtp.getType());
		
		assertTrue(vtp.goParent());
		assertEquals(NAME_TASK_LIST, vtp.getName());
		assertEquals(TYPE_TASK_LIST, vtp.getType());

		assertTrue(vtp.goParent());
		assertEquals(NAME_ARCHITECTURAL, vtp.getName());
		assertEquals(TYPE_ARCHITECTURAL, vtp.getType());

		assertTrue(vtp.goParent());
		assertEquals(RNAME_SYSTEM, vtp.getName());
		assertEquals( TYPE_SYSTEM, vtp.getType());

		assertTrue(vtp.goParent());
		assertFalse(vtp.goParent());
	}
	
	@Test
	public void testGetVar() {
		IVarTreePointer vtp = populate();
		
		assertTrue(vtp.go(RNAME_SYSTEM));
		StringVar sv = new StringVar(VALUE_NEW_NAME);
		vtp.add(NAME_NAME, sv);
		assertTrue(vtp.go(NAME_NAME));
		StringVar svr = (StringVar) vtp.getVar();
		assertNotSame(svr, sv);
		assertEquals(VALUE_NEW_NAME, svr.get());
		assertSame(VALUE_NEW_NAME, svr.get()); // NB !!!
		
		sv.set("Ciao");
		StringVar svr2 = (StringVar) vtp.getVar();
		assertNotSame(svr2, sv);
		assertEquals(VALUE_NEW_NAME, svr.get());
		assertSame(VALUE_NEW_NAME, svr.get()); // NB !!!
		assertEquals(VALUE_NEW_NAME, svr2.get());
		assertSame(VALUE_NEW_NAME, svr2.get()); // NB !!!
		
		//---------
		
		assertTrue(vtp.goAbsolute(S+DataPath.makeSlashedId(VALUE_NEW_NAME)+S+ NAME_FUNCTIONAL +S+ NAME_IMPLEMENTATION +S+ RNAME_PROC));
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
			assertEquals("a", val[0]);
			assertEquals("b", val[1]);
			assertEquals("c", val[2]);
			assertEquals("a", val[3]);
			assertEquals("b", val[4]);
			assertEquals("c", val[5]);
		}
		
		assertEquals("Methods", vtp.add("Methods", smv));
		assertTrue(vtp.go("Methods"));
		
		StringMVar smvr = (StringMVar) vtp.getVar();
		assertNotSame(smv, smvr);

		for (int i=0; i<2; i++) {
			smvr = (StringMVar) vtp.getVar();
			
			// NB! proc.getMethods use Unique Data Type 
			assertEquals(smvr.sizeValues(), 3);
			String[] val = smvr.getValues();
			assertEquals("a", val[0]);
			assertEquals("b", val[1]);
			assertEquals("c", val[2]);
			
			smv.clearValues();
		}

		// -------------
		
		assertTrue(vtp.goAbsolute(S+ DataPath.makeSlashedId(VALUE_NEW_NAME) +S+ NAME_ARCHITECTURAL +S+ NAME_TASK_LIST +S+ RNAME_TASK +S+ "Type"));
		StringVar type = (StringVar) vtp.getVar();
		
		assertTrue(type == null || type.get() == null );
		//assertTrue(type.get() == null);
	}

	@Test
	public void testSetVar() {
		IVarTreePointer vtp = populate();
		
		assertTrue(vtp.go(RNAME_SYSTEM +S+  NAME_NAME));
		StringVar sv = new StringVar(VALUE_NEW_NAME);
		vtp.setVar(sv);

		assertFalse(vtp.existAbsolute(RNAME_SYSTEM));
		assertFalse(vtp.exist(RNAME_SYSTEM +S+  NAME_NAME));

		StringVar svr = (StringVar) vtp.getVar();
		assertNotSame(svr, sv);
		assertEquals(VALUE_NEW_NAME, svr.get());
		assertSame(VALUE_NEW_NAME, svr.get()); // NB !!!
		
		sv.set("Ciao");
		StringVar svr2 = (StringVar) vtp.getVar();
		assertNotSame(svr2, sv);
		assertEquals(VALUE_NEW_NAME, svr.get());
		assertSame(VALUE_NEW_NAME, svr.get()); // NB !!!
		
		//---------
		
		assertTrue(vtp.goAbsolute(S+ DataPath.makeSlashedId(VALUE_NEW_NAME) +S+ NAME_FUNCTIONAL +S+ NAME_IMPLEMENTATION +S+ RNAME_PROC +S+ "Methods"));
		StringMVar smv = new StringMVar();
		{
			smv.appendValue("a");
			smv.appendValue("b");
			smv.appendValue("c");
			smv.appendValue("a");
			smv.appendValue("b");
			smv.appendValue("c");
		}
		vtp.setVar(smv);
		
		StringMVar smvr = (StringMVar) vtp.getVar();
		assertNotSame(smv, smvr);

		for (int i=0; i<2; i++) {
			smvr = (StringMVar) vtp.getVar();

			// NB! proc.getMethods use Unique Data Type 
			assertEquals(smvr.sizeValues(), 3);
			String[] val = smvr.getValues();
			assertEquals("a", val[0]);
			assertEquals("b", val[1]);
			assertEquals("c", val[2]);
			
			smv.clearValues();
		}

	}

	// checked in all functions
	//public void testGetName() {}

	// checked in all functions
	// public void testGetType() {}

	@Test
	public void testIsContainer() {
		IVarTreePointer vtp = populate();
	
		assertTrue(vtp.isContainer());
		
		assertTrue(vtp.go(RNAME_SYSTEM+S+NAME_NAME));
		assertFalse(vtp.isContainer());

		assertTrue(vtp.goAbsolute(S+ RNAME_SYSTEM+S+NAME_ARCHITECTURAL));
		assertTrue(vtp.isContainer());

		assertTrue(vtp.go(NAME_TASK_LIST));
		assertTrue(vtp.isContainer());
		
		assertTrue(vtp.go(RNAME_TASK));
		assertTrue(vtp.isContainer());
		
		assertTrue(vtp.go("Type"));
		assertFalse(vtp.isContainer());
	}

	@Test
	public void testDestroy() {
		IVarTreePointer vtp = populate();
		
		assertTrue(vtp.go(RNAME_SYSTEM));
		assertEquals(RNAME_SYSTEM, vtp.getName());
		assertEquals( TYPE_SYSTEM, vtp.getType());
		
		assertTrue(vtp.go(NAME_ARCHITECTURAL));
		vtp.destroy();

		assertTrue(vtp.go(NAME_FUNCTIONAL));
		assertEquals(NAME_TIME_CONST_LIST, vtp.add(NAME_TIME_CONST_LIST,TYPE_TIME_CONST_LIST));
		assertTrue(vtp.go(NAME_TIME_CONST_LIST));
		assertEquals("abc", vtp.add("abc", "TimeConst"));
		assertEquals("efg", vtp.add("efg", "TimeConst"));
		assertEquals(vtp.getChildrenNumber(), 2);
		vtp.destroy();
		assertTrue(vtp.exist(NAME_TIME_CONST_LIST)); // !!!!!
		assertTrue(vtp.go(NAME_TIME_CONST_LIST));
		assertEquals(vtp.getChildrenNumber(), 0);
		assertFalse(vtp.exist("abc"));
		assertFalse(vtp.exist("efg"));
		vtp.destroy();
		vtp.goParent();
		
		assertEquals(RNAME_SYSTEM, vtp.getName());
		assertEquals( TYPE_SYSTEM, vtp.getType());
		
		assertFalse(vtp.go(NAME_ARCHITECTURAL));
		assertEquals(expectedChildrenNumber(TYPE_SYSTEM)-1, vtp.getChildrenNumber());

		// -------
		assertEquals(NAME_NAME, vtp.add(NAME_NAME, new StringVar("Ciao")));
		assertEquals(expectedChildrenNumber(TYPE_SYSTEM)-1, vtp.getChildrenNumber());
		assertEquals("Ciao", vtp.getName());
		assertEquals(TYPE_SYSTEM, vtp.getType());
		
		assertTrue(vtp.go(NAME_NAME));
		vtp.destroy();

		assertEquals(DataPath.makeSlashedId((String) null), vtp.getName());
		assertEquals( TYPE_SYSTEM, vtp.getType());
		
		assertFalse(vtp.go(NAME_ARCHITECTURAL));
		assertEquals(expectedChildrenNumber(TYPE_SYSTEM)-1, vtp.getChildrenNumber());
		
		// -------
		vtp.destroy();
		assertNull(vtp.getName());
		assertEquals("root_Node's_Type", vtp.getType());
		
		assertEquals(vtp.getChildrenNumber(), 0);
		assertFalse(vtp.go(NAME_ARCHITECTURAL));
		assertFalse(vtp.go(NAME_FUNCTIONAL));
		assertFalse(vtp.go(NAME_MAPPING));
		
	}
}
