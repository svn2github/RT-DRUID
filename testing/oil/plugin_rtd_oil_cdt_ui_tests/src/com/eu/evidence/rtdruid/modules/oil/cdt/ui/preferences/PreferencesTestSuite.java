/**
 * 30/mag/2012
 */
package com.eu.evidence.rtdruid.modules.oil.cdt.ui.preferences;

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
	RtdChangeArm7PreferencesTest.class,
	RtdChangeAvr5PreferencesTest.class,
	RtdChangeCortexPreferencesTest.class,
	RtdChangeDsPicPreferencesTest.class,
	RtdChangePic32PreferencesTest.class,
	RtdChangeRenesasPreferencesTest.class,
	RtdChangeS12PreferencesTest.class
})
public class PreferencesTestSuite {
	
	public static PreferencesTestSuite instance = new PreferencesTestSuite();

}
