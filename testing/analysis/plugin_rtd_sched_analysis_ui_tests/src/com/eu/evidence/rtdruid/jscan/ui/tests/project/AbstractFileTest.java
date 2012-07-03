/**
 * 08/giu/2012
 */
package com.eu.evidence.rtdruid.jscan.ui.tests.project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;

import com.eu.evidence.rtdruid.jscan.ui.tests.examples.RtdFileHelper;
import com.eu.evidence.rtdruid.tests.ui.swtbot.AbstractSwtBotTest;
import com.eu.evidence.rtdruid.tests.ui.swtbot.BuildHelper;
import com.eu.evidence.rtdruid.tests.ui.swtbot.ProjectExplorerHelper;
import com.eu.evidence.rtdruid.tests.ui.swtbot.SimpleProjectHelper;
import com.eu.evidence.rtdruid.tests.ui.swtbot.WizardHelper;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public abstract class AbstractFileTest extends AbstractSwtBotTest {

	protected List<WizardHelper> helpers = new LinkedList<WizardHelper>();

	/**
	 * 
	 */
	public AbstractFileTest() {
		super();
	}

	@Before
	@Override
	public void setup() {
		super.setup();
		assertNotNull(bot);
		(new BuildHelper(bot)).disableAutoBuild();
	}

	@After
	public void cleanUp() {
		for (WizardHelper helper : helpers) {
			if (helper != null) {
				helper.forceClose();
			}
		}
		helpers.clear();
	}

	/**
	 * @param projectName
	 * @param fileName
	 */
	public void createProject(final String projectName, final String fileName) {
		{
			// Remove existing project
			ProjectExplorerHelper peh = new ProjectExplorerHelper(bot);
			peh.deleteProjectElement(projectName);
			assertNull(peh.getProjectElement(projectName));
		}
	
		{ // create a new project
			SimpleProjectHelper project = new SimpleProjectHelper(bot);
			helpers.add(project);
			project.newRtdProject().pressNext();
			assertFalse(project.isFinishAvailable());
			assertFalse(project.isNextAvailable());
			project.setProjectName(projectName);
			assertTrue(project.isFinishAvailable());
			project.pressFinish();
		}
		
		
		{ // create a new file
			RtdFileHelper file = new RtdFileHelper(bot);
			helpers.add(file);
			file.newRtdFile().pressNext();
			file.setFileName("", projectName);
			assertFalse(file.isFinishAvailable());
			assertFalse(file.isNextAvailable());
			file.setFileName(fileName, projectName);
			assertTrue(file.isFinishAvailable());
			file.pressFinish();
		}
	}

}