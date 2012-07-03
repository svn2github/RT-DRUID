/**
 * 07/giu/2012
 */
package com.eu.evidence.rtdruid.tests.ui.swtbot;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.utils.SWTUtils;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class WizardHelper implements StandardWidgetTexts {

	protected boolean enableScreenshots = false;
	protected final SWTWorkbenchBot bot;
	private SWTBotShell newWizardShell = null;
	
	protected SWTBot shellBot = null;

	/**
	 * 
	 */
	public WizardHelper(SWTWorkbenchBot bot) {
		this.bot = bot;
	}

	/**
	 * @param newProjectShell the newProjectShell to set
	 */
	protected void setWizardShell(SWTBotShell newWizardShell) {
		this.newWizardShell = newWizardShell;
		if (this.newWizardShell == null) {
			shellBot = null;
		} else {
			shellBot = this.newWizardShell.bot();
		}
	}

	/*
	 * BUTTONS
	 */

	public boolean isNextAvailable() {
		return shellBot != null && shellBot.button(BTN_TXT_NEXT).isEnabled();
	}

	public boolean isFinishAvailable() {
		return shellBot != null && shellBot.button(BTN_TXT_FINISH).isEnabled();
	}

	public WizardHelper pressNext() {
		shellBot.button(BTN_TXT_NEXT).click();
		return this;
	}

	public void pressCancel() {
		shellBot.button(BTN_TXT_CANCEL).click();
		bot.waitUntil(Conditions.shellCloses(newWizardShell));
		newWizardShell = null;
		shellBot = null;
	}

	public void pressFinish() {
		assertTrue(newWizardShell.isOpen());
		shellBot.button(BTN_TXT_FINISH).click();
		try {
			bot.waitUntil(Conditions.shellCloses(newWizardShell));
		} catch (TimeoutException e) {
			// too fast ?
		}
		assertFalse(newWizardShell.isOpen());
		newWizardShell = null;
		shellBot = null;
	}


	/*
	 * Close window
	 */

	
	public void forceClose() {
		if (newWizardShell != null && newWizardShell.isOpen()) {
			newWizardShell.close();
			bot.waitUntil(Conditions.shellCloses(newWizardShell));
		}
		newWizardShell = null;
		shellBot = null;
	}

	/*
	 * Screen shots
	 */


	/**
	 * @param enableScreenshots the enableScreenshots to set
	 */
	public void setEnableScreenshots(boolean enableScreenshots) {
		this.enableScreenshots = enableScreenshots;
	}



	public void captureScreenshot(String screenshotPath) {
		if (newWizardShell != null && enableScreenshots) {
			newWizardShell.activate();
			SWTUtils.captureScreenshot(screenshotPath, newWizardShell.widget);
		}
	}

}