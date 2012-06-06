/**
 * 31/mag/2012
 */
package com.eu.evidence.rtdruid.tests.ui.swtbot;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.utils.SWTUtils;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public class RtdProjectHelper implements StandardWidgetTexts {

	protected boolean enableScreenshots = false;

	protected final SWTWorkbenchBot bot;

	private SWTBotShell newProjectShell = null;

	public RtdProjectHelper(SWTWorkbenchBot bot) {
		this.bot = bot;
	}
	
	/**
	 * @param newProjectShell the newProjectShell to set
	 */
	protected void setNewProjectShell(SWTBotShell newProjectShell) {
		this.newProjectShell = newProjectShell;
	}
	
	/**
	 * @param enableScreenshots the enableScreenshots to set
	 */
	public void setEnableScreenshots(boolean enableScreenshots) {
		this.enableScreenshots = enableScreenshots;
	}

	public RtdProjectHelper setProjectName(String projectName) {
		bot.textWithLabel("Project name:").setText(projectName);
		return this;
	}

	/*
	 * BUTTONS
	 */

	public boolean isNextAvailable() {
		return bot.button(BTN_TXT_NEXT).isEnabled();
	}

	public boolean isFinishAvailable() {
		return bot.button(BTN_TXT_FINISH).isEnabled();
	}

	public RtdProjectHelper pressNext() {
		bot.button(BTN_TXT_NEXT).click();
		return this;
	}

	public void pressCancel() {
		bot.button(BTN_TXT_CANCEL).click();
		if (newProjectShell != null) {
			bot.waitUntil(Conditions.shellCloses(newProjectShell));
			newProjectShell = null;
		}
	}

	public void pressFinish() {
		bot.button(BTN_TXT_FINISH).click();
		if (newProjectShell != null) {
			bot.waitUntil(Conditions.shellCloses(newProjectShell));
			newProjectShell = null;
		}
	}

	/*
	 * Close window
	 */

	public void forceClose() {
		if (newProjectShell != null && newProjectShell.isOpen()) {
			newProjectShell.close();
			bot.waitUntil(Conditions.shellCloses(newProjectShell));
		}
		newProjectShell = null;
	}

	public void captureScreenshot(String screenshotPath) {
		if (newProjectShell != null && enableScreenshots) {
			newProjectShell.activate();
			bot.sleep(100);
			SWTUtils.captureScreenshot(screenshotPath, newProjectShell.widget);
		}
	}

}