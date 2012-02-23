/**
 * 23/feb/2012
 */
package com.eu.evidence.rtdruid.test.modules.jscan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.eu.evidence.rtdruid.internal.modules.jscan.GeneralTests;
import com.eu.evidence.rtdruid.internal.modules.jscan.offset.OffsetTests;
import com.eu.evidence.rtdruid.test.modules.jscan.cachecost.CacheTests;
import com.eu.evidence.rtdruid.test.modules.jscan.common.CommonTests;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
	GeneralTests.class,
	OffsetTests.class,
	CacheTests.class,
	CommonTests.class,
	JscanTestSuite.SubTes.class
})
public class JscanTestSuite {

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
			new JscanTestSuite();
			new GeneralTests();
			new OffsetTests();
			new CacheTests();
			new CommonTests();
		}
	}
	
}
