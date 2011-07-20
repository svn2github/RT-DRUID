/*
 * Created on 19-mar-2004
 *
 * $Id: SearchTest.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.vartree.tools.test;

//import rtdruid.vartree.VarTree;
//import rtdruid.vartree.data.ObjectWithID;
//import rtdruid.vartree.data.init.DataPath;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.eu.evidence.rtdruid.desk.RTDFactory;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.tools.Search;

/**
 *  @author  Nicola Serreli
 */
public class SearchTest extends TestCase {

	/**
	 * Constructor for MappingTest.
	 * @param arg0
	 */
	public SearchTest(String arg0) {
		super(arg0);
	}

	public static Test suite() {
		TestSuite tests = new TestSuite("Evidence Search Test Suite");

		tests.addTest( new TestSuite(SearchTest1.class) );
		tests.addTest( new TestSuite(SearchTest2.class) );

		tests.addTest( new TestSuite(SearchTest.class) );
		
		return tests;
	}

	
	public void testARtos() {
		
		boolean ok = false;
		try {
			Search.aRtos(null, "a", "b");
		} catch (NullPointerException e) {
			ok = true;
		}
		assertTrue(ok);
		
		{
			ITreeInterface ti = ((IVarTree) RTDFactory.get(IVarTree.class)).newTreeInterface();
			ok =true;
			try {
				Search.aRtos(ti, "a", null);
			} catch (NullPointerException e) {
				ok = true;
			}
			assertTrue(ok);
		}

		{
			ITreeInterface ti = ((IVarTree) RTDFactory.get(IVarTree.class)).newTreeInterface();
			ok =true;
			try {
				Search.aRtos(ti, null, "a");
			} catch (NullPointerException e) {
				ok = true;
			}
			assertTrue(ok);
		}
	}

	public void testAEventForMethod() {
		fail("test not implemented");
	}
	
	public void testAEvent() {
		
		boolean ok = false;
		try {
			Search.anEvent(null, "a", "b");
		} catch (NullPointerException e) {
			ok = true;
		}
		assertTrue(ok);
		
		{
			ITreeInterface ti = ((IVarTree) RTDFactory.get(IVarTree.class)).newTreeInterface();
			ok =true;
			try {
				Search.anEvent(ti, "a", null);
			} catch (NullPointerException e) {
				ok = true;
			}
			assertTrue(ok);
		}

		{
			ITreeInterface ti = ((IVarTree) RTDFactory.get(IVarTree.class)).newTreeInterface();
			ok =true;
			try {
				Search.anEvent(ti, null, "a");
			} catch (NullPointerException e) {
				ok = true;
			}
			assertTrue(ok);
		}
	}
	
	public void testAllTriggersForAMethod() {
		fail("test not implemented");
	}

	
/* NOT WORK because it tries to merge two systems with different name 
	
	// @see TestCase#setUp()
	protected void setUp() throws Exception {
		super.setUp();
		s1 = new SearchTest1();
		s2 = new SearchTest2();
		
//		ProjectManager.instance().newProject();
		VarTree vt = VarTree.instance();
		(new EvidenceTest()).testLoadExample1();
		ObjectWithID root1 = (ObjectWithID) vt.getRoot().get(0);
		(new EvidenceTest()).testLoadExample2();
		ObjectWithID root2 = (ObjectWithID) vt.getRoot().get(0);
		root2.merge(root1, "" + DataPath.SEPARATOR);
	}

	public void testAVar() {
		s1.testAVar();
		s2.testAVar();
	}

	public void testALocalVar() {
		s1.testALocalVar();
		s2.testALocalVar();
	}

	public void testAProc() {
		s1.testAProc();
		s2.testAProc();
	}

	public void testALocalProc() {
		s1.testALocalProc();
		s2.testALocalProc();
	}

	public void testProcPrefix() {
		s1.testProcPrefix();
		s2.testProcPrefix();
	}

	/*public void testAMethod() {
		s1.testAMethod();
		s2.testAMethod();
	}

	public void testAGlobalMethod() {
		s1.testAGlobalMethod();
		s2.testAGlobalMethod();
	}

	public void testALocalMethod() {
		s1.testALocalMethod();
		s2.testALocalMethod();
	}

	public void testAMethodRef() {
		s1.testAMethodRef();
		s2.testAMethodRef();
	}*/

}
