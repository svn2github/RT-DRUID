/**
 * 01/giu/2012
 */
package com.eu.evidence.rtdruid.tests.ui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.eu.evidence.rtdruid.tests.ui.swtbot.test.RtdProjectHelperTest;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( {
	// single tests
	RtdProjectHelperTest.class,
	
	// Suite "coverage"
	RtdCoreUiTestSuite.SubTes.class
})
public class RtdCoreUiTestSuite {

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
			new RtdCoreUiTestSuite();
		}
	}

}
