/**
 * 31/mag/2012
 */
package com.eu.evidence.rtdruid.modules.oil.cdt.ui.project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
public class RtdOilProjectTest extends AbstractSwtBotTest implements StandardWidgetTexts {
	

	public final String simpleDspicExample =
			"CPU mySystem {\n" + 
			"	OS myOs {\n" + 
			"        STATUS = EXTENDED;\n" + 
			"        STARTUPHOOK = TRUE;\n" + 
			"        USERESSCHEDULER = TRUE;\n" + 
			"        CPU_DATA = PIC30 {\n" + 
			"			APP_SRC = \"code.c\";\n" + 
			"			APP_SRC = \"T1.S\";\n" + 
			"			MULTI_STACK = TRUE {\n" + 
			"				IRQ_STACK = TRUE {\n" + 
			"					SYS_SIZE=64;\n" + 
			"				};\n" + 
			"			};\n" + 
			"			ICD2 = TRUE;\n" + 
			"		};\n" + 
			"		KERNEL_TYPE = BCC1;\n" + 
			"		BOARD_DATA = EE_FLEX {\n" + 
			"			TYPE = STANDARD {" +
			"				OPTIONS = LEDS;\n" + 
			"				OPTIONS = LCD;\n" + 
			"			};\n" + 
			"		};\n" + 
			"	};\n" + 
			"    TASK Task0 {\n" + 
			"        PRIORITY = 1;\n" + 
			"        ACTIVATION = 4;\n" + 
			"        STACK = PRIVATE {\n" + 
			"			SYS_SIZE = 64;\n" + 
			"		};\n" + 
			"		SCHEDULE = FULL;\n" + 
			"	};\n" + 
			"    TASK Task1 {\n" + 
			"        PRIORITY = 2;\n" + 
			"        ACTIVATION = 4;\n" + 
			"        STACK = SHARED;\n" + 
			"        SCHEDULE = FULL;\n" + 
			"    };\n" + 
			"};\n";
	
	protected RtdOilProjectHelper project;
	
	
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
	}
	
	
	@Test
	public void newProject() {
		final String projectName = "new project";
		
		// create a new project
		project = new RtdOilProjectHelper(bot);
		project.newRtdProject().pressNext();
		assertFalse(project.isFinishAvailable());
		assertFalse(project.isNextAvailable());
		project.setProjectName(projectName);
		assertTrue(project.isFinishAvailable());
		assertTrue(project.isNextAvailable());
		project.pressFinish();
		
		// open editor
		TextEditorHelper teh = new TextEditorHelper(bot, FILE_CONF_OIL);
		assertTrue(teh.isEditorOpen());
		assertTrue(teh.isEditorOpen());
		teh.closeEditors();
		assertFalse(teh.isEditorOpen());
		assertFalse(teh.isEditorOpen());
		teh.closeEditors();
		assertFalse(teh.isEditorOpen());
		
		teh.openWorkspaceFile(projectName, FILE_CONF_OIL);
		
		// set content
		teh.setContent(simpleDspicExample);
		teh.saveEditors();
		teh.closeEditors();
		
		// build
		ProjectExplorerHelper peh = new ProjectExplorerHelper(bot);
		BuildHelper bh = new BuildHelper(bot);
		assertFalse(bh.isAutoBuildEnable());
		assertNull(peh.getProjectElement(projectName, FOLDER_DEBUG));
		bh.cleanProject(projectName);
		bot.sleep(100);
		assertNull(peh.getProjectElement(projectName, FOLDER_DEBUG));

		bh.buildProject(projectName);
//		bot.sleep(10000);
		assertNotNull(peh.getProjectElement(projectName, FOLDER_DEBUG));

		bh.cleanProject(projectName);
		bot.sleep(100);
		assertNull(peh.getProjectElement(projectName, FOLDER_DEBUG));
		
		assertNotNull(peh.getProjectElement(projectName));
		assertNotNull(peh.getProjectElement(projectName, FILE_CONF_OIL));
		peh.deleteProjectElement(projectName, FILE_CONF_OIL);
		assertNotNull(peh.getProjectElement(projectName));
		assertNull(peh.getProjectElement(projectName, FILE_CONF_OIL));
		peh.deleteProjectElement(projectName);
		assertNull(peh.getProjectElement(projectName));
		assertNull(peh.getProjectElement(projectName, FILE_CONF_OIL));
	}
	
}
