/**
 * 30/mag/2012
 */
package com.eu.evidence.rtdruid.jscan.ui.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.eu.evidence.rtdruid.jscan.ui.tests.project.CreateFileTest;
import com.eu.evidence.rtdruid.jscan.ui.tests.project.TaskTableTest;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( {
	CreateFileTest.class,
	TaskTableTest.class
})
public class RtdJscanUiTestSuite {
	public static RtdJscanUiTestSuite instance = new RtdJscanUiTestSuite();
}
