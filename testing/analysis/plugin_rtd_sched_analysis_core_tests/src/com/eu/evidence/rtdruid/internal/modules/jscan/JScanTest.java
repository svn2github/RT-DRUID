/*
 * Created on 16-mar-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.eu.evidence.rtdruid.internal.modules.jscan;

// progect package

// standard java package

// junit package
import junit.framework.Test;
import junit.framework.TestSuite;

import com.eu.evidence.rtdruid.internal.modules.jscan.offset.OffsetTests;

// exceptions

/**
 * @author Nicola Serreli
 */
public class JScanTest {

	/**
	 * Constructor for JScanTest.
	 * @param arg0
	 */
//	public JScanTest(String arg0) {
//		super(arg0);
//	}
	
	public static Test suite() {
		TestSuite tests = new TestSuite("JScan Test Suite");
//		tests.addTest( new TestSuite(JScanTest.class) );
		tests.addTest( TaskSetTest.suite() );
		
		tests.addTest( OffsetTests.suite() );
		
		tests.addTest( new TestSuite(CompleteTest1.class) );
		tests.addTest( new TestSuite(CompleteTest2.class) );
//		tests.addTest( new TestSuite(CompleteTest3.class) );
		return tests;
	}


}
