package com.eu.evidence.rtdruid.tests.ui.swtbot;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
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
		getMainShell(bot);
		
		(new ViewHelper(bot, "Welcome")).closeViews();
		(new ViewHelper(bot, "CDO Sessions")).closeViews();
		bot = new SWTWorkbenchBot();
		
		bot.sleep(500);
	}
	
	
	/**
	 * @param bot
	 */
	public static SWTBotShell getMainShell(SWTWorkbenchBot bot) {
		SWTBotShell tmp = null;
		for (SWTBotShell s: bot.shells()) {
			if (s.getText() != null && s.getText().length()>0) {
				tmp = s;
				break;
			}
		}
		tmp.activate();
		return tmp;
	}
}