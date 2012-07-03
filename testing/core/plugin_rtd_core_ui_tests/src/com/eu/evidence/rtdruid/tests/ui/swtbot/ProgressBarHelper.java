/**
 * 08/giu/2012
 */
package com.eu.evidence.rtdruid.tests.ui.swtbot;

import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class ProgressBarHelper {
	
	protected long timeout = -1;
	protected final String title;
	protected final SWTBot bot;
	
	/**
	 * 
	 */
	public ProgressBarHelper(SWTBot bot, String title) {
		this.title = title;
		this.bot = bot;
	}
	
	/**
	 * @param timeout the timeout to set
	 */
	public ProgressBarHelper setTimeout(long timeout) {
		this.timeout = timeout;
		return this;
	}

	public void waitProgressBar() {
		SWTBotShell progressShell = null;
		try {
			progressShell = new SWTBotShell (bot.widget(RtdMatchers.getShell(title)));
		} catch (WidgetNotFoundException e) {
			// do nothing: the widget may be opened and closed too fast
			progressShell = null;
		}
		if (progressShell != null) {
			if (timeout>-1) {
				bot.waitUntil(Conditions.shellCloses(progressShell), timeout);
			} else {
				bot.waitUntil(Conditions.shellCloses(progressShell));
			}
		}

	}
	
}
