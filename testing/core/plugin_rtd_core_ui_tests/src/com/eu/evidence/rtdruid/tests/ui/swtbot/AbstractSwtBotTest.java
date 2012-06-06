package com.eu.evidence.rtdruid.tests.ui.swtbot;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 * 29/mag/2012
 */

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public abstract class AbstractSwtBotTest {

	protected final static boolean ENABLE_SCREENSHOTS = false; 
	protected SWTWorkbenchBot bot;

	@Before
	public void setup() {
		System.out.println("------ AST setup ---------");
		bot = new SWTWorkbenchBot();
		
		(new ViewHelper(bot, "Welcome")).closeViews();
		(new ViewHelper(bot, "CDO Sessions")).closeViews();
		bot = new SWTWorkbenchBot();
		
		bot.sleep(500);
	}
}