/**
 * 07/giu/2012
 */
package com.eu.evidence.rtdruid.jscan.ui.tests.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Ignore;
import org.junit.Test;

import com.eu.evidence.rtdruid.jscan.ui.tests.examples.RtdModelTreeEditorHelper;
import com.eu.evidence.rtdruid.tests.ui.swtbot.StandardWidgetTexts;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class CreateFileTest extends AbstractFileTest implements StandardWidgetTexts {
	
	@Test
	public void newProject() {
		final String projectName = "new jscan project";
		final String fileName = "testFile.ertd";

		createProject(projectName, fileName);
		
		// open editor
		{ 
			RtdModelTreeEditorHelper teh = new RtdModelTreeEditorHelper(bot, fileName);
		
			assertTrue(teh.isEditorOpen());
			assertTrue(teh.isEditorOpen());
			teh.closeEditors();
			assertFalse(teh.isEditorOpen());
			assertFalse(teh.isEditorOpen());
			teh.closeEditors();
			assertFalse(teh.isEditorOpen());
			
			teh.openWorkspaceFile(projectName, fileName);
			
			// set content
			assertEquals(1, teh.getChildrenNumber());
			teh.saveEditors();
			teh.closeEditors();
		}
	}

	
	@Test
	@Ignore
	public void addElements() {
		final String projectName = "new jscan project";
		final String fileName = "testFile.ertd";

		createProject(projectName, fileName);
		
		// open editor
		final RtdModelTreeEditorHelper teh = new RtdModelTreeEditorHelper(bot, fileName);
		final String baseName;
		final String expectedSystemName = "System default system";
		{ 
			teh.closeEditors();
			assertFalse(teh.isEditorOpen());
			teh.openWorkspaceFile(projectName, fileName);
			
			// set content
			assertEquals(1, teh.getChildrenNumber());
			baseName = teh.getChildrenNames()[0];
			
			assertEquals(1, teh.getChildrenNumber(baseName));
			assertEquals(expectedSystemName, teh.getChildrenNames(baseName)[0]);
		}
		{ // add system	
			assertEquals(0, teh.getChildrenNumber(baseName, expectedSystemName));
			teh.addElement("Architectural Architectural", baseName, expectedSystemName);
			assertEquals(1, teh.getChildrenNumber());
			assertEquals(1, teh.getChildrenNumber(baseName));
			assertEquals(1, teh.getChildrenNumber(baseName, expectedSystemName));
			teh.saveEditors();
			teh.closeEditors();
			assertFalse(teh.isEditorOpen());
		}
		
		{ // check element after save
			teh.openWorkspaceFile(projectName, fileName);
			
			assertEquals(1, teh.getChildrenNumber());
			assertEquals(1, teh.getChildrenNumber(baseName));
			assertEquals(1, teh.getChildrenNumber(baseName, expectedSystemName));
			teh.saveEditors();
			teh.saveEditors();
			teh.closeEditors();
		}
	}
	
}
