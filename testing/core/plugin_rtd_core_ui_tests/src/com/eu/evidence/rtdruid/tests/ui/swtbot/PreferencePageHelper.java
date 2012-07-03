/**
 * 30/mag/2012
 */
package com.eu.evidence.rtdruid.tests.ui.swtbot;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.utils.SWTUtils;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;


/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public class PreferencePageHelper implements StandardWidgetTexts {

	protected final SWTWorkbenchBot bot;
	protected SWTBotShell preferenceShell;

	/**
	 * 
	 */
	public PreferencePageHelper(SWTWorkbenchBot bot) {
		this.bot = bot;
	}

	/**
	 * @return the preferenceShell
	 */
	public SWTBotShell getPreferenceShell() {
		return preferenceShell;
	}

	/**
	 * Makes a screenshot of current preference window
	 * 
	 * @param fileName
	 *            the path where store the screenshot
	 * 
	 * @return this {@link PreferencePageHelper}
	 * 
	 * @throws NullPointerException
	 *             if called before {@link #openPreferences()} or after one of
	 *             {@link #close()} methods
	 */
	public PreferencePageHelper captureScreenshot(String fileName) {
		preferenceShell.activate();
		SWTUtils.captureScreenshot(fileName, preferenceShell.widget);
		return this;
	}

	/**
	 * Open and activate the Preference window
	 * 
	 * @return
	 */
	public PreferencePageHelper openPreferences() {
		SWTBotShell main = AbstractSwtBotTest.getMainShell(bot);
		SWTBotMenu menu = null;
		try {
			menu = main.bot().menu(MENU_WINDOW).menu("Preferences");
		} catch (WidgetNotFoundException e) {
			menu = main.bot().menu("Preferences");
		}
		menu.click();
		preferenceShell = bot.shell("Preferences");
		return this;
	}

	/**
	 * Select the preference page identifies by the specified path
	 * 
	 * @param path
	 */
	public PreferencePageHelper expandTreePath(String... path) {
		SWTBotTree tree = bot.tree();
		tree.expandNode(path).select();
		return this;
	}

	/**
	 * Save the content of Preference window (i.e. press apply)
	 * 
	 * @return
	 */
	public PreferencePageHelper pressApply() {
		bot.button(BTN_TXT_APPLY);
		return this;
	}

	/**
	 * SaveAndClose the Preference window (i.e. press ok)
	 * 
	 * @return
	 */
	public void pressOk() {
		bot.button(BTN_TXT_OK).click();
		bot.sleep(50);
		bot.waitUntil(Conditions.shellCloses(preferenceShell));
		preferenceShell = null;
	}

	/**
	 * Close the Preference window without save (i.e. press Cancel)
	 * 
	 * @return
	 */
	public void pressCancel() {
		bot.button(BTN_TXT_CANCEL).click();
		bot.waitUntil(Conditions.shellCloses(preferenceShell));
		preferenceShell = null;
	}

	/**
	 * Close the Preference window without save
	 * 
	 * @return
	 */
	public void forceClose() {
		if (preferenceShell != null && preferenceShell.isOpen()) {
			preferenceShell.close();
			bot.waitUntil(Conditions.shellCloses(preferenceShell));
		}
		preferenceShell = null;
	}

}
