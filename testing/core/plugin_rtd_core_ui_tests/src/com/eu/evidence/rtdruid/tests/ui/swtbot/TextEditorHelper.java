/**
 * 01/giu/2012
 */
package com.eu.evidence.rtdruid.tests.ui.swtbot;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class TextEditorHelper extends EditorHelper {
	
	/**
	 * 
	 */
	public TextEditorHelper(SWTWorkbenchBot bot, String editorName) {
		super(bot, editorName);
	}

	/**
	 * @return the content of this text editor
	 */
	public String getContent() {
		return getEditor().bot().styledText().getText();
	}
	
	/**
	 * @return the content of this text editor
	 */
	public TextEditorHelper setContent(String text) {
		getEditor().bot().styledText().setText(text);
		return this;
	}

}
