/**
 * 22/feb/2012
 */
package com.eu.evidence.rtdruid.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.eu.evidence.rtdruid.epackage.EPackageTestSuite;
import com.eu.evidence.rtdruid.internal.desk.ReadVersionTest;
import com.eu.evidence.rtdruid.internal.epackage.EPackageFactoryImplTest;
import com.eu.evidence.rtdruid.internal.vartree.tools.test.VTToolsTestSuite;
import com.eu.evidence.rtdruid.io.RtdIOTestSuite;
import com.eu.evidence.rtdruid.test.vartree.VtTestSuite;
import com.eu.evidence.rtdruid.test.vartree.data.DataTestSuite;
import com.eu.evidence.rtdruid.vartree.abstractions.old.CpuTest;
import com.eu.evidence.rtdruid.vartree.variables.VariablesTestSuite;

/**
 * The main suite containing all RT-Druid core tests
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( {
	// Suites
	EPackageTestSuite.class,
	VTToolsTestSuite.class,
	RtdIOTestSuite.class,
	VtTestSuite.class,
	DataTestSuite.class,
	VariablesTestSuite.class,
	
	// Single Classes
	EPackageFactoryImplTest.class,
	ReadVersionTest.class,	
	CpuTest.class,
	
	// Suite "coverage"
	CoreTestSuite.SubTes.class
})
public class CoreTestSuite {

	/**
	 * This stupid class just instantiates each suite, in order to "cover them"  
	 *
	 * @author Nicola Serreli
	 * @since 2.0
	 *
	 */
	public static class SubTes {
		
		@Test
		public void t() {
			new CoreTestSuite();
			new EPackageTestSuite();
			new EPackageFactoryImplTest();
			new ReadVersionTest();
			new VTToolsTestSuite();
			new RtdIOTestSuite();
			new VtTestSuite();
			new DataTestSuite();
			new VariablesTestSuite();
		}
	}
}
