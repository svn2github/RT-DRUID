/**
 * 31/mag/2012
 */
package com.eu.evidence.rtdruid.modules.oil.cdt.ui.project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import com.eu.evidence.rtdruid.modules.oil.cdt.ui.CompilerData;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.CompilerData.CompilerPath;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.preferences.CompilerPreferencePageHelper;
import com.eu.evidence.rtdruid.tests.ui.swtbot.AbstractSwtBotTest;
import com.eu.evidence.rtdruid.tests.ui.swtbot.BuildHelper;
import com.eu.evidence.rtdruid.tests.ui.swtbot.ProjectExplorerHelper;
import com.eu.evidence.rtdruid.tests.ui.swtbot.StandardWidgetTexts;
import com.eu.evidence.rtdruid.tests.ui.swtbot.TextEditorHelper;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class RtdOilProjectCompilerPathTest extends AbstractSwtBotTest implements StandardWidgetTexts {
	

	protected RtdOilProjectHelper project;
	protected CompilerPreferencePageHelper preference;

	
	@Before
	@Override
	public void setup() {
		super.setup();
		assertNotNull(bot);
		(new BuildHelper(bot)).disableAutoBuild();
	}
	

	@After
	public void cleanUp() {
		if (project != null) {
			project.forceClose();
			project = null;
		}
		if (preference != null) {
			preference.forceClose();
			preference = null;
		}

	}
	
	
	protected void newProject(final String projectName, final String oilText, final CompilerData data, String expectedValue) {
		
		// delete existing project
		{ // build
			ProjectExplorerHelper peh = new ProjectExplorerHelper(bot);
			peh.deleteProjectElement(projectName);
			assertNull(peh.getProjectElement(projectName));
		}
		
		
		// create a new project
		project = new RtdOilProjectHelper(bot);
		project.newRtdProject().pressNext();
		assertFalse(project.isFinishAvailable());
		assertFalse(project.isNextAvailable());
		project.setProjectName(projectName);
		assertTrue(project.isFinishAvailable());
		assertTrue(project.isNextAvailable());
		project.pressFinish();
		
		{ // open editor
			TextEditorHelper teh = new TextEditorHelper(bot, FILE_CONF_OIL);
			teh.closeEditors();
			assertFalse(teh.isEditorOpen());
			
			teh.openWorkspaceFile(projectName, FILE_CONF_OIL);
			assertTrue(teh.isEditorOpen());
			
			// set content
			teh.setContent(oilText);
			teh.saveEditors();
		}
		
		// set compiler
		{
			preference = new CompilerPreferencePageHelper(bot, data.getPreferenceTreePath());
			// open preference window
			preference.openCompilerPreferencePage().restoreDefaults();
			
			// for each compiler
			for (CompilerPath elem: data.getCompilerSet()) {
				// set the test value
				preference.setCompilerPath(elem.getTestValue(), elem.getID());
			}
		
			// save every thing
			preference.pressOk();
	
			// close
			preference = null;
		}
		
		{ // build
			ProjectExplorerHelper peh = new ProjectExplorerHelper(bot);
			BuildHelper bh = new BuildHelper(bot);
			assertFalse(bh.isAutoBuildEnable());
			assertNull(peh.getProjectElement(projectName, FOLDER_DEBUG));
			bh.cleanProject(projectName);
			bot.sleep(100);
			assertNull(peh.getProjectElement(projectName, FOLDER_DEBUG));
	
			bh.buildProject(projectName);
			bot.sleep(100);
			assertNotNull(peh.getProjectElement(projectName, FOLDER_DEBUG));
		}

		{ // open editor
			TextEditorHelper teh = new TextEditorHelper(bot, FILE_MAKEFILE);
			teh.closeEditors();
			assertFalse(teh.isEditorOpen());
			
			teh.openWorkspaceFile(projectName, FOLDER_DEBUG, FILE_MAKEFILE);
			assertTrue(teh.isEditorOpen());
			
			assertThat(teh.getContent(), Matchers.containsString(expectedValue));
		}
	}
	
	
	protected void genericTest(CompilerData data) {
		boolean worked = false;
		for (CompilerData.CompilerPath path : data.getCompilerSet()) {
			if (path.getOilTest() != null) {
				newProject(data.getID() + " - " + path.getID() + " project", path.getOilTest(), data, path.getTestValue());
				worked = true;
			}
		}
		// the test is real only if there was something to do
		Assume.assumeTrue(worked);
	}
	
	
	@Test
	public void arm7() {
		genericTest( CompilerData.AllCompilerData.get(CompilerData.ARM7));
	}
	
	@Test
	public void avr5() {
		genericTest( CompilerData.AllCompilerData.get(CompilerData.AVR5));
	}

	@Test
	public void cortex() {
		genericTest( CompilerData.AllCompilerData.get(CompilerData.CORTEX));
	}

	@Test
	public void dsPic() {
		genericTest( CompilerData.AllCompilerData.get(CompilerData.DS_PIC));
	}

	@Test
	public void e200zx() {
		genericTest( CompilerData.AllCompilerData.get(CompilerData.E200Zx));
	}

	@Test
	public void s12() {
		genericTest( CompilerData.AllCompilerData.get(CompilerData.S12));
	}

	@Test
	public void pic32() {
		genericTest( CompilerData.AllCompilerData.get(CompilerData.PIC32));
	}

	@Test
	public void renesas() {
		genericTest( CompilerData.AllCompilerData.get(CompilerData.RENESAS));
	}
}

