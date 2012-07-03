/**
 * 31/mag/2012
 */
package com.eu.evidence.rtdruid.tests.ui.swtbot;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public class RtdProjectHelper extends WizardHelper {

	public RtdProjectHelper(SWTWorkbenchBot bot) {
		super(bot);
	}
	
	public RtdProjectHelper setProjectName(String projectName) {
		shellBot.textWithLabel("Project name:").setText(projectName);
		return this;
	}
}