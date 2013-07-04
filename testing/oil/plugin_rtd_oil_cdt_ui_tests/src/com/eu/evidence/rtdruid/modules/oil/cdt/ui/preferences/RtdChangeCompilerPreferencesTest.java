package com.eu.evidence.rtdruid.modules.oil.cdt.ui.preferences;

import org.junit.After;
import org.junit.Test;

import com.eu.evidence.rtdruid.modules.oil.cdt.ui.CompilerData;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.CompilerData.CompilerPath;
import com.eu.evidence.rtdruid.tests.ui.swtbot.AbstractSwtBotTest;

/**
 * 29/mag/2012
 */

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public abstract class RtdChangeCompilerPreferencesTest extends AbstractSwtBotTest {

	protected final CompilerData data;
	protected CompilerPreferencePageHelper preference;

	protected RtdChangeCompilerPreferencesTest(CompilerData data) {
		this.data = data;
	}
	
	@After
	public void cleanUp() {
		if (preference != null) {
			preference.forceClose();
			preference = null;
		}
	}

	@Test
	public void testSetCompilerPaths() throws Exception {
		preference = new CompilerPreferencePageHelper(bot, data.getPreferenceTreePath());
		// open preference window
		preference.openCompilerPreferencePage().restoreDefaults();

		// screenshot
		if (ENABLE_SCREENSHOTS) {
			bot.sleep(100);
			preference.captureScreenshot("e:/preferences_" + data.getID() + ".png");
		}
		
		// for each compiler
		for (CompilerPath elem: data.getCompilerSet()) {
			String elemPath = elem.getID();
			// check default value
			preference.checkCompilerPath(elem.getDefaultValue(), elemPath);
//			if (HostOsUtils.common.getCurrentSystem() == OsType.Cygwin) {
//				// use the browser button
//				preference.clickBroswer(elemPath);
//				// check that the value is changed
//				assertThat(preference.getCompilerPath(elemPath), not(equalTo(elem.getDefaultValue())));
//			}
			// set the test value
			preference.setCompilerPath(elem.getTestValue(), elemPath);
		}
	
		// save every thing
		preference.pressOk();
		
		
		// open again the preference window
		preference.openCompilerPreferencePage();
		
		// for each compiler
		for (CompilerPath elem: data.getCompilerSet()) {
			// check if the compiler value is the test one
			preference.checkCompilerPath(elem.getTestValue(), elem.getID());
		}
		
		preference.pressCancel();
		
	}
}