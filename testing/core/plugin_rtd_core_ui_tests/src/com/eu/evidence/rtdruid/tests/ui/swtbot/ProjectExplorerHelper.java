/**
 * 31/mag/2012
 */
package com.eu.evidence.rtdruid.tests.ui.swtbot;

import java.util.ArrayList;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public class ProjectExplorerHelper extends ViewHelper {

	protected TreeHelper tree = null;

	/**
	 * 
	 */
	public ProjectExplorerHelper(SWTWorkbenchBot bot) {
		super(bot, "Project Explorer", new String[] { "General", "Project Explorer" });
	}

	public SWTBotTree getProjectTree() {
		return getView().bot().tree();
	}

	/**
	 * Build the specified project.
	 * 
	 * @param projectName
	 * @return
	 */
	public ProjectExplorerHelper buildProject(String projectName) {
		SWTBotTreeItem item = selectProjectElement(projectName);
		item.contextMenu(CMENU_BUILD_PROJECT);
		return this;
	}

	/**
	 * Clean the specified project.
	 * 
	 * @param projectName
	 * @return
	 */
	public ProjectExplorerHelper cleanProject(String projectName) {
		SWTBotTreeItem item = selectProjectElement(projectName);
		item.contextMenu(CMENU_CLEAN_PROJECT);
		return this;
	}

	/**
	 * This method does not expand or select the TreeItem. It does not throw
	 * exception if the element is not found.
	 * 
	 * 
	 * @param path
	 * @return the tree element, or null if the path is empty
	 */
	public SWTBotTreeItem getProjectElement(String... path) {
		return getTreeHelper().getElementSafe(path);
	}

	/**
	 * Selects one or more Elements in the tree
	 * 
	 * @param paths
	 * @return
	 */
	public ArrayList<SWTBotTreeItem> selectProjectElements(String[][] paths) {
		return getTreeHelper().selectProjectElements(paths);
	}

	public SWTBotTreeItem selectProjectElement(String... path) {
		return getTreeHelper().selectProjectElement(path);
	}

	public ProjectExplorerHelper clickProjectElement(String... path) {
		getTreeHelper().clickProjectElement(path);
		return this;
	}
	
	public ProjectExplorerHelper deleteProjectElement(String... path) {
		SWTBotTreeItem item = getProjectElement(path);
		if (item != null) {
			item.contextMenu("Delete").click();

			SWTBotShell view = new SWTBotShell (bot.widget(RtdMatchers.getShell("Delete Resources", "Confirm Delete")));
			if (path.length==1) {
				// for projects, check "remove from filesystem" flag 
				view.bot().checkBox().click();
			}
			view.bot().button(BTN_TXT_OK).click();
			bot.waitUntil(Conditions.shellCloses(view));
		}
		return this;
	}

	protected TreeHelper getTreeHelper() {
		if (tree == null) {
			tree = new TreeHelper(getProjectTree());
		}
		return tree;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eu.evidence.rtdruid.tests.ui.swtbot.ViewHelper#closeViews()
	 */
	@Override
	public ProjectExplorerHelper closeViews() {
		tree = null;
		return (ProjectExplorerHelper) super.closeViews();
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.tests.ui.swtbot.ViewHelper#showView()
	 */
	@Override
	public ProjectExplorerHelper showView() {
		return (ProjectExplorerHelper) super.showView();
	}
}
