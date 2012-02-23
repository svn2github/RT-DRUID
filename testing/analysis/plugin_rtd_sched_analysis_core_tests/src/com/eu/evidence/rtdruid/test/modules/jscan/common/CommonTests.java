/**
 * 23/feb/2012
 */
package com.eu.evidence.rtdruid.test.modules.jscan.common;

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
@SuiteClasses({ JScanMultiFrameTest.class, MultiFrameTaskSchedulabilityTest.class, PartialOrderDataTest.class,
		PeriodSensitivityTest.class, ProcDeadlinesTest.class, StackOptimizationTest.class })
public class CommonTests {

}
