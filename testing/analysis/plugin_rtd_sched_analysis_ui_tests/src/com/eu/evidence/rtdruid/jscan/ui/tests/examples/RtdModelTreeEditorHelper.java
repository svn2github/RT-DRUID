/**
 * 01/giu/2012
 */
package com.eu.evidence.rtdruid.jscan.ui.tests.examples;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;

import com.eu.evidence.rtdruid.tests.ui.swtbot.EditorHelper;
import com.eu.evidence.rtdruid.tests.ui.swtbot.ProjectExplorerHelper;
import com.eu.evidence.rtdruid.tests.ui.swtbot.TreeHelper;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class RtdModelTreeEditorHelper extends EditorHelper {
	
	protected TreeHelper tree = null;
	
	/**
	 * 
	 */
	public RtdModelTreeEditorHelper(SWTWorkbenchBot bot, String editorName) {
		super(bot, editorName);
	}

	
	/**
	 * 
	 */
	public boolean existElement(String ... path) {
		return getTreeHelper().getElementSafe(path) != null;
	}
	
	
	public RtdModelTreeEditorHelper addElement(String element, String ... path) {
		SWTBotTreeItem item = getTreeHelper().selectProjectElement(path);
//		item.contextMenu("_UI_ShowPropertiesView_menu_item").click();
		item.contextMenu("New Child").menu(element).click();

		return this;
	}
	
	/**
	 * 
	 */
	public int getChildrenNumber(String ... path) {
		return getTreeHelper().getChildrenNumber(path);
	}
	
	public String[] getChildrenNames(String ... path) {
		return getTreeHelper().getChildrenNames(path);
	}
	
	public SWTBotTree getTree() {
		return getEditor().bot().tree();
	}
	
	protected TreeHelper getTreeHelper() {
		if (tree == null) {
			tree = new TreeHelper(getTree());
		}
		return tree;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eu.evidence.rtdruid.tests.ui.swtbot.ViewHelper#closeViews()
	 */
	@Override
	public EditorHelper closeEditors() {
		tree = null;
		return super.closeEditors();
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.tests.ui.swtbot.EditorHelper#closeAllEditors()
	 */
	@Override
	public EditorHelper closeAllEditors() {
		tree = null;
		return super.closeAllEditors();
	}
	
}
