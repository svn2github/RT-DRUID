/**
 * 07/giu/2012
 */
package com.eu.evidence.rtdruid.jscan.ui.tests.examples;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;

import com.eu.evidence.rtdruid.tests.ui.swtbot.StandardWidgetTexts;
import com.eu.evidence.rtdruid.tests.ui.swtbot.WizardHelper;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public class RtdFileHelper extends WizardHelper implements StandardWidgetTexts {

	
	public RtdFileHelper(SWTWorkbenchBot bot) {
		super(bot);
	}

	public RtdFileHelper newRtdFile() {
		bot.menu("File").menu("New").menu("Other...").click();
		setWizardShell(bot.shell("New"));
		shellBot.tree().expandNode("Evidence", "RT-Druid Data Model").select();
		return this;
	}
	
	public RtdFileHelper setFileName(String name, String workspacePath) {
		shellBot.textWithLabel("Enter or select the parent folder:").setText(workspacePath);
		shellBot.textWithLabel("File name:").setText(name);
		return this;
	}
}
