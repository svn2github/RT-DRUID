/**
 * 23/feb/2012
 */
package com.eu.evidence.rtdruid.modules.oil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilEPackageProviderTest;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManagerTest;
import com.eu.evidence.rtdruid.modules.oil.codewriter.options.PreferenceStorageTest;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilImplTests;
import com.eu.evidence.rtdruid.modules.oil.implementations.components.mp_oil_Test;
import com.eu.evidence.rtdruid.modules.oil.reader.ReaderTests;
import com.eu.evidence.rtdruid.modules.oil.reader.inclusion.IncludeSupportTest;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.AllWriteTests;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.AutosarOilWriterTests;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.CodeWriterAutosar;
import com.eu.evidence.rtdruid.test.modules.oil.codewriter.autosar.CodeWriterSplitted;
import com.eu.evidence.rtdruid.test.modules.oil.xtext.TestSuite;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
	OilEPackageProviderTest.class,
	SWCategoryManagerTest.class,
	PreferenceStorageTest.class,
	OilImplTests.class,
	mp_oil_Test.class,
	ReaderTests.class,
	IncludeSupportTest.class,
	AllWriteTests.class,
	CodeWriterAutosar.class,
	CodeWriterSplitted.class,
	AutosarOilWriterTests.class,
	OilTestSuite.SubTes.class,
	TestSuite.class
})
public class OilTestSuite {

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
			new OilTestSuite();
			new OilImplTests();
			new ReaderTests();
			new AllWriteTests();
			new TestSuite();
		}
	}
}
