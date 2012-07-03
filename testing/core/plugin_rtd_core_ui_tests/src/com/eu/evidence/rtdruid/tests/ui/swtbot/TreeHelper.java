/**
 * 31/mag/2012
 */
package com.eu.evidence.rtdruid.tests.ui.swtbot;

import java.util.ArrayList;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public class TreeHelper {

	protected final SWTBotTree tree;

	/**
	 * 
	 */
	public TreeHelper(SWTBotTree tree) {
		this.tree = tree;
	}
	
	/**
	 * @return the tree
	 */
	public SWTBotTree getTree() {
		return tree;
	}

	public boolean isValid() {
		return tree.widget.isDisposed();
	}

	/**
	 * This method does not expand or select the TreeItem. It does not throw
	 * exception if the element is not found.
	 * 
	 * @param path
	 * @return the tree element, or null if the path is empty
	 */
	public SWTBotTreeItem getElementSafe(String... path) {
		SWTBotTreeItem answer = null;
		
		// label to identify the external cycle
		next_path_element:
		for (String s : path) {
			SWTBotTreeItem[] elements;
			if (answer == null) {
				elements = tree.getAllItems();
			} else {
				elements = answer.getItems();
			}
			for (SWTBotTreeItem item : elements) {
				if (item.getText().equals(s)) {
					answer = item;
					// next element
					continue next_path_element;
				}
			}

			// if the cycle failed, return null
			return null;
		}
		return answer;
	}

	/**
	 * Selects one or more Elements in the tree
	 * 
	 * @param paths
	 * @return
	 */
	public ArrayList<SWTBotTreeItem> selectProjectElements(String[][] paths) {
		ArrayList<SWTBotTreeItem> items = new ArrayList<SWTBotTreeItem>(paths.length);
		for (String[] path : paths) {
			items.add(tree.expandNode(path));
		}
		tree.select((SWTBotTreeItem[]) items.toArray(new SWTBotTreeItem[items.size()]));
		return items;
	}

	public SWTBotTreeItem selectProjectElement(String... path) {
		return tree.expandNode(path).select();
	}

	public TreeHelper clickProjectElement(String... path) {
		tree.expandNode(path).select().click();
		return this;
	}
	
	public int getChildrenNumber(String... path) {
		if (path.length == 0) {
			return tree.getAllItems().length;
		} else {
			return tree.expandNode(path).getItems().length;
		}
	}
	
	public SWTBotTreeItem[] getChildren(String... path) {
		if (path.length == 0) {
			return tree.getAllItems();
		} else {
			return tree.expandNode(path).getItems();
		}
	}
	

	public String[] getChildrenNames(String... path) {
		SWTBotTreeItem[] items = getChildren(path);
		String[] answer = new String[items.length];
		for (int i=0; i<items.length; i++) {
			answer[i] = items[i].getText();
		}
		return answer;
	}
}
