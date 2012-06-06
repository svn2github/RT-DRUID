/**
 * 31/mag/2012
 */
package com.eu.evidence.rtdruid.tests.ui.swtbot.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.eu.evidence.rtdruid.tests.ui.swtbot.AbstractSwtBotTest;
import com.eu.evidence.rtdruid.tests.ui.swtbot.BuildHelper;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public class RtdProjectHelperTest extends AbstractSwtBotTest {

	/**
	 * Test method for
	 * {@link com.eu.evidence.rtdruid.tests.ui.swtbot.RtdProjectHelper#enableAutoBuild()}
	 * .
	 */
	@Test
	public void testEnableAutoBuild() {
		BuildHelper project = new BuildHelper(bot);
		project.enableAutoBuild();
		assertTrue(project.isAutoBuildEnable());
		assertTrue(project.isAutoBuildEnable());
		project.disableAutoBuild();
		assertFalse(project.isAutoBuildEnable());
		assertFalse(project.isAutoBuildEnable());
		project.enableAutoBuild();
		assertTrue(project.isAutoBuildEnable());
		assertTrue(project.isAutoBuildEnable());
		project.enableAutoBuild();
		assertTrue(project.isAutoBuildEnable());
		assertTrue(project.isAutoBuildEnable());
		project.disableAutoBuild();
		assertFalse(project.isAutoBuildEnable());
		assertFalse(project.isAutoBuildEnable());
		project.disableAutoBuild();
		assertFalse(project.isAutoBuildEnable());
		assertFalse(project.isAutoBuildEnable());
	}

}
