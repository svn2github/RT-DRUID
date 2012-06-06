/**
 * 30/mag/2012
 */
package com.eu.evidence.rtdruid.modules.oil.cdt.ui.project;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( {
	RtdOilProjectTest.class,
	RtdOilProjectCompilerPathTest.class
})
public class ProjectTestSuite {
	public static ProjectTestSuite instance = new ProjectTestSuite();
}
