/**
 * 01/giu/2012
 */
package com.eu.evidence.rtdruid.tests.ui.swtbot;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class BuildHelper implements StandardWidgetTexts {

	protected final SWTWorkbenchBot bot;
	
	protected final SWTBotShell mainShell;

	public BuildHelper(SWTWorkbenchBot bot) {
		this.bot = bot;
		mainShell = bot.activeShell();
	}


	/*
	 * Auto build
	 */
	private SWTBotMenu getAutoBuildMenuItem() {
		return bot.
				//menu(MENU_PROJECT).
				menu(MENU_BUILD_AUTOMATICALLY);
	}

	public BuildHelper enableAutoBuild() {
		SWTBotMenu menu = getAutoBuildMenuItem();
		if (!menu.isChecked()) {
			menu.click();
		}
		return this;
	}

	public BuildHelper disableAutoBuild() {
		SWTBotMenu menu = getAutoBuildMenuItem();
		if (menu.isChecked()) {
			menu.click();
		}
		return this;
	}

	public boolean isAutoBuildEnable() {
		return  getAutoBuildMenuItem().isChecked();
	}

	/**
	 * Build the specified project. Uses {@link ProjectExplorerHelper}
	 * 
	 * @param projectName
	 * @return
	 */
	public BuildHelper buildProject(String projectName) {
		SWTBotTreeItem item = (new ProjectExplorerHelper(bot)).showView().selectProjectElement(projectName);
		item.contextMenu(CMENU_BUILD_PROJECT).click();
		
		SWTBotShell progressShell = null;
		try {
			progressShell = new SWTBotShell (bot.widget(RtdMatchers.getShell("Build Project")));
		} catch (WidgetNotFoundException e) {
			// do nothing: the widget may be opened and closed too fast
			progressShell = null;
		}
		if (progressShell != null) {
			bot.waitUntil(Conditions.shellCloses(progressShell), LONG_BUILD_TIMEOUT);
		}
			
		return this;
	}

	/**
	 * Clean the specified project. Uses {@link ProjectExplorerHelper}
	 * 
	 * @param projectName
	 * @return
	 */
	public BuildHelper cleanProject(String projectName) {
		SWTBotTreeItem item = (new ProjectExplorerHelper(bot)).showView().selectProjectElement(projectName);
		item.contextMenu(CMENU_CLEAN_PROJECT).click();
		SWTBotShell progressShell = null;
		try {
			progressShell = new SWTBotShell (bot.widget(RtdMatchers.getShell("Clean Project")));
		} catch (WidgetNotFoundException e) {
			// do nothing: the widget may be opened and closed too fast
			progressShell = null;
		}
		if (progressShell != null) {
			bot.waitUntil(Conditions.shellCloses(progressShell), LONG_BUILD_TIMEOUT);
		}
		return this;
	}


}
