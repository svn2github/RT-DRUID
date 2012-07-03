/**
 * 31/mag/2012
 */
package com.eu.evidence.rtdruid.tests.ui.swtbot;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;

import com.eu.evidence.rtdruid.tests.ui.swtbot.RtdProjectHelper;

/**
 * This class does common actions on a project, like open, new, delete ...
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class SimpleProjectHelper extends RtdProjectHelper  {

	public SimpleProjectHelper(SWTWorkbenchBot bot) {
		super(bot);
	}
	
	public SimpleProjectHelper newRtdProject() {
		bot.menu("File").menu("New").menu("Project...").click();
		bot.tree().expandNode("General", "Project").select();
		setWizardShell(bot.shell("New Project"));
		return this;
	}
	
}
