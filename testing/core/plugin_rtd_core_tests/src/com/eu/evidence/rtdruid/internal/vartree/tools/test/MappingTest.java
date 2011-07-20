/*
 * Created on 19-mar-2004
 *
 * $Id: MappingTest.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.vartree.tools.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * @author  Nicola Serreli
 */
public class MappingTest extends TestCase {

	/**
	 * Constructor for MappingTest.
	 * @param arg0
	 */
	public MappingTest(String arg0) {
		super(arg0);
	}

	public static Test suite() {
		TestSuite tests = new TestSuite("Evidence Mapping Test Suite");

		tests.addTest( new TestSuite(MappingTest1.class) );
		tests.addTest( new TestSuite(MappingTest2.class) );

		//tests.addTest( new TestSuite(MappingTest.class) );
		
		return tests;
	}

	 
/* NOT WORK because it tries to merge two systems with different name 
 
	// @see TestCase#setUp()
  	protected void setUp() throws Exception {
		super.setUp();
		m1 = new MappingTest1();
		m2 = new MappingTest2();
		
//		ProjectManager.instance().newProject();
		(new EvidenceTest()).testLoadExample1();
		(new EvidenceTest()).testLoadExample2();
	}

	// Test for void Mapping(String)
	public void testMappingString() {
		m1.testMappingString();
		m2.testMappingString();
	}

	// Test for void Mapping(String, String)
	public void testMappingStringString() {
		m1.testMappingStringString();
		m2.testMappingStringString();
	}

	public void testSetMode() {
		m1.testSetMode();
		m2.testSetMode();
	}

	public void testProcToTask() {
		m1.testProcToTask();
		m2.testProcToTask();
	}

	public void testTaskToProc() {
		m1.testTaskToProc();
		m2.testTaskToProc();
	}

	public void testTaskToRTOS() {
		m1.testTaskToRTOS();
		m2.testTaskToRTOS();
	}

	public void testRtosToTask() {
		m1.testRtosToTask();
		m2.testRtosToTask();
	}


	 // TEST: Aggiustare i test di TaskToCpu e CpuToTask
	
	public void testTaskToCpu() {
		m1.testTaskToCpu();
		m2.testTaskToCpu();
	}

	public void testCpuToTask() {
		m1.testCpuToTask();
		m2.testCpuToTask();
	}

	public void testVarToMutex() {
		m1.testVarToMutex();
//		m2.testMutexToVar();
	}

	public void testMutexToVar() {
		m1.testMutexToVar();
//		m2.testMutexToVar();
	}*/
}
