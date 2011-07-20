/*
 * Created on 16-mar-2004
 *
 * $Id: EvidenceTest.java,v 1.2 2007/09/28 11:16:27 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.vartree.tools.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author  Nicola Serreli
 */
public class EvidenceTest extends TestCase {

	/**
	 * Constructor for EvidenceTest.
	 * @param arg0
	 */
	public EvidenceTest(String arg0) {
		super(arg0);
	}

	public EvidenceTest() {
	}
	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		//(VarTree.instance()).clear();
	}

	public static Test suite() {
		TestSuite tests = new TestSuite(" Evidence Test Suite" );
		//tests.addTest( new TestSuite(EvidenceTest.class) );

		tests.addTest( DataPathTest.suite() );

		tests.addTest( SearchTest.suite() );
		
		tests.addTest( MappingTest.suite() );

		return tests;
	}
}
