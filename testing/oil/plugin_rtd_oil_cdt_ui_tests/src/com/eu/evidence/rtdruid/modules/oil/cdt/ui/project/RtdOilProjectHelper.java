/**
 * 31/mag/2012
 */
package com.eu.evidence.rtdruid.modules.oil.cdt.ui.project;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;

import com.eu.evidence.rtdruid.tests.ui.swtbot.RtdProjectHelper;

/**
 * This class does common actions on a project, like open, new, delete ...
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class RtdOilProjectHelper extends RtdProjectHelper  {

	public RtdOilProjectHelper(SWTWorkbenchBot bot) {
		super(bot);
	}
	
	public RtdOilProjectHelper newRtdProject() {
		bot.menu("File").menu("New").menu("Project...").click();
		bot.tree().expandNode("Evidence", "RT-Druid Oil and C/C++ Project").select();
		setNewProjectShell(bot.shell("New Project"));
		
		captureScreenshot("Rtd_New_project.png");
		
		bot.button(BTN_TXT_NEXT).click();
		return this;
	}
	
}
