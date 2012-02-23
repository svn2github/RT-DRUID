/**
 * 22/feb/2012
 */
package com.eu.evidence.rtdruid.io;

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
	RTD_XMI_FactoryTest.class,
	RTDResourceManagerFactoryTest.class,
	XMI2XMLlTest.class,
	XsltTransformThreadTest.class })
public class RtdIOTestSuite {
	
}
