/*
 * Created on Jul 13, 2004
 *
 * $Id: OffsetTests.java,v 1.2 2005/09/30 10:57:35 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.jscan.offset;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.eu.evidence.rtdruid.test.modules.jscan.common.PeriodSensitivityTest;

/**
 * @author Nicola Serreli
 */
public class OffsetTests extends TestCase {


	/**
	 */
	public OffsetTests(String name) {
		super(name);
	}
	
	public static Test suite() {
		TestSuite tests = new TestSuite("Sched. Analysis with Offsets Test Suite");
		
		tests.addTest( new TestSuite(PeriodSensitivityTest.class) );
		tests.addTest( new TestSuite(OffsetDMSchedulabilityCompleteTest.class) );
		tests.addTest( new TestSuite(OffSetSchedulabilityAssignmentTest.class) );
		
		tests.addTest( new TestSuite(OffSetSchedulabilityHyperplanesAnalysisTest.class) );
		

		return tests;
	}


}
