/**
 * 30/mag/2012
 */
package com.eu.evidence.rtdruid.modules.oil.cdt.ui;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.eu.evidence.rtdruid.modules.oil.cdt.ui.cygwin.AutoCygwindSearchTest;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.cygwin.MyMakeBuilderTest;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.linkvariable.LinkVariableTest;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.preferences.PreferencesTestSuite;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.project.ProjectTestSuite;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.views.ActiveOilImplementationsTest;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.views.OilGeneratorsTest;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( {
	PreferencesTestSuite.class,
	ProjectTestSuite.class,
	ActiveOilImplementationsTest.class,
	OilGeneratorsTest.class,
	
	// pure junit tests
	AutoCygwindSearchTest.class,
	MyMakeBuilderTest.class,
	LinkVariableTest.class
})
public class RtdOilCdtUiTestSuite {
	public static RtdOilCdtUiTestSuite instance = new RtdOilCdtUiTestSuite();
}
