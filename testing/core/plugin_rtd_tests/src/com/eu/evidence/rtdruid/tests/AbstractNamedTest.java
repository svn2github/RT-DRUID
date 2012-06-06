/**
 * 05/mag/2012
 */
package com.eu.evidence.rtdruid.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

/**
 * This class just print The name of the test in the std output before the run the test 
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public abstract class AbstractNamedTest {

	@Rule public TestName name = new TestName();
	
	@Before
	public void setUp() throws Exception {
		System.err.flush();
		System.out.println("\n\n************\n TEST " + getClass().getName() + " - " + name.getMethodName() + "\n************\n\n");
		System.out.flush();
	}
	
	@After
	public void setDown() throws Exception {
		System.err.flush();
		System.out.flush();
	}

}
