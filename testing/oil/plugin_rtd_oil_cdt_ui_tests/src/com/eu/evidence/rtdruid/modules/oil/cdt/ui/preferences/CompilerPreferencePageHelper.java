/**
 * 30/mag/2012
 */
package com.eu.evidence.rtdruid.modules.oil.cdt.ui.preferences;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;

import com.eu.evidence.rtdruid.tests.ui.swtbot.PreferencePageHelper;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public class CompilerPreferencePageHelper extends PreferencePageHelper {

	/**
	 * the path in the preference window of current compiler preference page
	 */
	protected final String[] treePath;

	/**
	 * Makes a new Preference page utilty for a compiler
	 * 
	 * @param bot
	 *            the setbot
	 * @param treePath
	 *            the path in the preference window of current compiler
	 *            preference page
	 */
	public CompilerPreferencePageHelper(SWTWorkbenchBot bot, String[] treePath) {
		super(bot);
		this.treePath = treePath;
	}

	/**
	 * Open the preference page to the page related to this compiler
	 * 
	 * @return this object
	 */
	public CompilerPreferencePageHelper openCompilerPreferencePage() {
		openPreferences().expandTreePath(treePath);
		return this;
	}
	
	
	/**
	 * 
	 * 
	 * @param path
	 * @param compilerLabel
	 * @return
	 */
	public String getCompilerPath(String compilerLabel) {
		return bot.textWithLabel(compilerLabel).getText();
	}
	
	/**
	 * 
	 * 
	 * @param path
	 * @param compilerLabel
	 * @return
	 */
	public CompilerPreferencePageHelper checkCompilerPath(String path, String compilerLabel) {
		assertThat(bot.textWithLabel(compilerLabel).getText(), is(equalTo(path)));
		return this;
	}
	
	/**
	 * 
	 * 
	 * @param path
	 * @param compilerLabel
	 * @return
	 */
	public CompilerPreferencePageHelper setCompilerPath(String path, String compilerLabel) {
		bot.textWithLabel(compilerLabel).setText(path);
		return this;
	}
	
	/**
	 * 
	 * 
	 * @param path
	 * @param compilerLabel
	 * @return
	 */
	public CompilerPreferencePageHelper clickBroswer(String compilerLabel)  {
		// Important, the shell must be active before click on the "browser" button
		// otherwise the "enter key" may be not captured by the right window
		preferenceShell.activate();
		bot.buttonWithLabel(compilerLabel).click();
		bot.sleep(100);
		SWTBotShell browseShell = bot.activeShell();
		browseShell.pressShortcut(KEY_ENTER);
//		try {
//			bot.waitUntil(Conditions.shellCloses(browseShell));
//		} catch (TimeoutException e1) {
//			browseShell.pressShortcut(KEY_ENTER);
//			try {
//				bot.waitUntil(Conditions.shellCloses(browseShell));
//			} catch (TimeoutException e2) {
//
//				browseShell.pressShortcut(KEY_ESC);
//				bot.waitUntil(Conditions.shellCloses(browseShell));
//
//			}
//		}
		return this;
	}

	/**
	 * 
	 */
	public CompilerPreferencePageHelper restoreDefaults() {
		bot.button("Restore &Defaults").click();
		return this;
	}
}
