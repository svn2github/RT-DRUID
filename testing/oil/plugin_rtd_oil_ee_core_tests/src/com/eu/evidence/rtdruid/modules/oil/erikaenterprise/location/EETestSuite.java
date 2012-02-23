/**
 * 23/feb/2012
 */
package com.eu.evidence.rtdruid.modules.oil.erikaenterprise.location;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ EEBaseDynamicVariableResolverTest.class, EEPathsTest.class, EETestSuite.SubTes.class })
public class EETestSuite {

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
			new EETestSuite();
		}
	}
}
