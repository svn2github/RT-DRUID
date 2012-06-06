/**
 * 31/mag/2012
 */
package com.eu.evidence.rtdruid.tests.ui.swtbot;

import static org.eclipse.swtbot.eclipse.finder.matchers.WithPartName.withPartName;

import java.util.List;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.ui.IViewReference;
import org.hamcrest.Matcher;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public class EditorHelper implements StandardWidgetTexts {

	protected final SWTWorkbenchBot bot;

	protected final String editorName;

	/**
	 * A new EditorHeleper
	 * 
	 * @param bot
	 *            the swtbot
	 * @param editorName
	 *            the name of the file opened by the editor
	 * 
	 */
	public EditorHelper(SWTWorkbenchBot bot, String editorName) {
		this.bot = bot;
		this.editorName = editorName;
	}

	/**
	 * Capture a screen-shot of current editor
	 * 
	 * @param openViewScreenshot
	 *            the path of the screen-shot file
	 */
	public EditorHelper captureScreenshot(String openViewScreenshot) {
		getEditor().bot().captureScreenshot(openViewScreenshot);
		return this;
	}

	/**
	 * Open a file using the default editor. The action is perform through the
	 * Project Explorer view and the file is identified using a path in
	 * the project explorer tree, i.e. the absolute path of the file in the
	 * workspace.
	 * 
	 * @param projectExporerFilePath
	 *            the absolute path of the file in the workspace
	 * 
	 * @return this helper
	 */
	public EditorHelper openWorkspaceFile(String... projectExporerFilePath) {

		ProjectExplorerHelper peh = new ProjectExplorerHelper(bot);
		peh.showView();
		peh.selectProjectElement(projectExporerFilePath).doubleClick();
		return this;
	}

	/**
	 * Returns the editor with provided name, or throw an exception if not found
	 * after waiting a while (depending on timeout settings).
	 * 
	 * @return the opened editor (if exist)
	 */
	public SWTBotEditor getEditor() {
		return bot.editorByTitle(editorName);
	}

	/**
	 * Returns the list of editors with provided name that are currently open,
	 * without waiting and without throwing an exception if there is no one).
	 * 
	 * @return the list of all opened editors with the provided name
	 */
	public List<SWTBotEditor> getEditors() {
		Matcher<IViewReference> match = withPartName(editorName);
		return bot.editors(match);
	}
	
	/**
	 * This method checks if there is an open editor with provided name
	 * 
	 * @return this helper
	 */
	public boolean isEditorOpen() {
		return getEditors().size() > 0;
	}

	/**
	 * This method ensure that the view is visible, if already open.
	 * 
	 * @return this helper
	 */
	public EditorHelper showEditor() {
		getEditor().show();
		getEditor().setFocus();
		return this;
	}

	/**
	 * Close all instances of editor with provided name
	 * 
	 * @return this helper
	 */
	public EditorHelper closeEditors() {
		for (SWTBotEditor editor : getEditors()) {
			editor.close();
		}
		return this;
	}
	
	/**
	 * Close all editors
	 * 
	 * @return this helper
	 */
	public EditorHelper closeAllEditors() {
		for (SWTBotEditor editor : bot.editors()) {
			editor.close();
		}
		return this;
	}


	/**
	 * Saves the content of current editor
	 * 
	 * @return this helper
	 */
	public EditorHelper saveEditors() {
		for (SWTBotEditor editor : getEditors()) {
			editor.save();
		}
		return this;
	}
	
	
}
