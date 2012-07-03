/**
 * 01/giu/2012
 */
package com.eu.evidence.rtdruid.tests.ui.swtbot;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
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
		mainShell = AbstractSwtBotTest.getMainShell(bot);
	}


	/*
	 * Auto build
	 */
	private SWTBotMenu getAutoBuildMenuItem() {
		SWTBotMenu menu = null;
		try {
			menu = mainShell.bot().menu(MENU_PROJECT).menu(MENU_BUILD_AUTOMATICALLY);
		} catch (WidgetNotFoundException e) {
			menu = mainShell.bot().menu(MENU_BUILD_AUTOMATICALLY);
		}
		return menu;
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
		
		(new ProgressBarHelper(bot, "Build Project")).setTimeout(LONG_BUILD_TIMEOUT).waitProgressBar();
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
		
		(new ProgressBarHelper(bot, "Clean Project")).setTimeout(LONG_BUILD_TIMEOUT).waitProgressBar();
		return this;
	}


}
