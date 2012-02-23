/**
 * 23/feb/2012
 */
package com.eu.evidence.rtdruid.internal.modules.jscan.offset;

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
@SuiteClasses({ OffsetDMSchedulabilityCompleteTest.class, OffsetEDFSchedulabilityCompleteTest.class,
		OffSetSchedulabilityAssignmentTest.class, OffsetSchedulabilityEDFTest.class,
		OffSetSchedulabilityHyperplanesAnalysisTest.class, OffsetSchedulabilityRTATest.class })
public class OffsetTests {

}
