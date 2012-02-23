/**
 * 22/feb/2012
 */
package com.eu.evidence.rtdruid.epackage;

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
@SuiteClasses({ 
	EcoreEpackageExtentionTest.class,
	EcoreEpackageProviderTest.class,
	EPackageEmfMergeTest.class,
	EPackageProviderExceptionTest.class,
	EPackageXmlMergeTest.class,
	RTDEPackageBuildExceptionTest.class
})
public class EPackageTestSuite {

}
