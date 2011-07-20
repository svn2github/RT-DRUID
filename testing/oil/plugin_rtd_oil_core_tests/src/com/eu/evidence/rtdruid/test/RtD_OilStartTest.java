/*
 * Created on Jul 13, 2004
 *
 * $Id: RtD_OilStartTest.java,v 1.3 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.eu.evidence.rtdruid.hidden.modules.oil.reader.OilReaderTest;
import com.eu.evidence.rtdruid.hidden.modules.oil.reader.SimpleTransformTest;
import com.eu.evidence.rtdruid.hidden.modules.oil.vtextensions.pointer.OilApplPointerTest;
import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilImplIDTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWritertMPTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.CodeWritertTest;
import com.eu.evidence.rtdruid.vartree.variables.OilVarMPTest;

/**
 * @author Nicola Serreli
 */
public class RtD_OilStartTest extends TestCase {


	/**
	 */
	public RtD_OilStartTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		TestSuite tests = new TestSuite("RT-Druid Oil Test Suite");

		{
			TestSuite oilVarTs = new TestSuite("Tests about Oil Var ");
			oilVarTs.addTest(new TestSuite(OilVarMPTest.class));

			tests.addTest( oilVarTs );
		}
		{
			TestSuite implFactTs = new TestSuite("Tests about Oil Implementation Factory");
			implFactTs.addTest(new TestSuite(OilImplIDTest.class));

			tests.addTest( implFactTs );
		}
		{
			TestSuite applPointTs = new TestSuite("Tests about Oil Application Pointer");
			applPointTs.addTest(new TestSuite(OilApplPointerTest.class));

			tests.addTest( applPointTs );
		}
		{
			TestSuite applPointTs = new TestSuite("Complete tests about Readers");
			applPointTs.addTest(new TestSuite(OilReaderTest.class));

			tests.addTest( applPointTs );
		}
		{
			TestSuite codeWriterTs = new TestSuite("Tests about Writers of Configuration's Files");
			codeWriterTs.addTest(new TestSuite(CodeWritertTest.class));
			codeWriterTs.addTest(new TestSuite(CodeWritertMPTest.class));
//			codeWriterTs.addTest(new TestSuite(EESignatureReaderTest.class));

			tests.addTest( codeWriterTs );
		}
		{
			TestSuite oilWriterTs = new TestSuite("Tests about Writers of Oil Files");
			oilWriterTs.addTest(new TestSuite(SimpleTransformTest.class));

			tests.addTest( oilWriterTs );
		}
		{
//			TestSuite oilWriterTs = new TestSuite("Tests about Trace");
//			oilWriterTs.addTest(new TestSuite(TraceReaderTest.class));

//			tests.addTest( oilWriterTs );
		}
				
		return tests;
	}


}
