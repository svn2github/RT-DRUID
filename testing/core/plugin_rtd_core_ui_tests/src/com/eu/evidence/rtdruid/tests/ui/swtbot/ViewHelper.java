/**
 * 31/mag/2012
 */
package com.eu.evidence.rtdruid.tests.ui.swtbot;

import static org.eclipse.swtbot.eclipse.finder.matchers.WithPartName.withPartName;

import java.util.Arrays;
import java.util.List;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.utils.SWTUtils;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.ui.IViewReference;
import org.hamcrest.Matcher;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public class ViewHelper implements StandardWidgetTexts {

	/**
	 * A path where store a screen-shot of "Open View" window. The screen-shot
	 * is captured only if this variable is not null
	 */
	protected String openViewScreenshot = null;

	protected final SWTWorkbenchBot bot;

	protected final String viewName;

	/**
	 * The full path in the tree of OpenView window of the view to open. This
	 * vector can be null.
	 */
	protected final String[] viewCategory;

	/**
	 * A new ViewHeleper with an empty category
	 * 
	 * @param bot
	 *            the swtbot
	 * @param viewName
	 *            the name of the view
	 * 
	 */
	public ViewHelper(SWTWorkbenchBot bot, String viewName) {
		this(bot, viewName, null);
	}

	/**
	 * A new ViewHeleper
	 * 
	 * @param bot
	 *            the swtbot
	 * @param viewName
	 *            the name of the view
	 * @param viewCategory
	 *            the path in the openView tree, including the view element. Can
	 *            be null
	 * 
	 */
	public ViewHelper(SWTWorkbenchBot bot, String viewName, String[] viewCategory) {
		this.bot = bot;
		this.viewName = viewName;
		if (viewCategory == null || viewCategory.length == 0) {
			this.viewCategory = null;
		} else {
			this.viewCategory = Arrays.copyOf(viewCategory, viewCategory.length);
		}
	}

	/**
	 * Set the path of "Open View" window screen-shot. If null, the screen-shot
	 * is disabled
	 * 
	 * @param openViewScreenshot
	 *            the new Open View file path to set
	 */
	public void setOpenViewScreenshot(String openViewScreenshot) {
		this.openViewScreenshot = openViewScreenshot;
	}

	/**
	 * Uses the eclipse menu to open a new view. If the screen-shot path is set,
	 * it takes also a screen-shot
	 * 
	 * @return this helper
	 */
	public ViewHelper openView() {
		bot.menu(MENU_WINDOW).menu(MENU_SHOW_VIEW).menu("Other...").click();
		SWTBotShell openViewShell = bot.shell(WINDOW_SHOW_VIEW);
		if (viewCategory == null) {
			// bot.text().setText(viewName);
			bot.tree().getTreeItem(viewName).expand().select();
		} else {
			bot.tree().expandNode(viewCategory).select();
		}

		if (openViewScreenshot != null) {
			openViewShell.activate();
			bot.sleep(100);
			SWTUtils.captureScreenshot(openViewScreenshot, openViewShell.widget);
		}

		bot.button(BTN_TXT_OK).click();

		return this;
	}

	/**
	 * Returns the view with provided name, or throw an exception if not found
	 * after waiting a while (depending on timeout settings).
	 * 
	 * @return the opened view (if exist)
	 */
	public SWTBotView getView() {
		return bot.view(getMatcher());
	}

	/**
	 * Returns the list of views with provided name that are currently open,
	 * without waiting and without throwing an exception if there is no one).
	 * 
	 * @return the list of all opened view with the provided name
	 */
	public List<SWTBotView> getViews() {
		return bot.views(getMatcher());
	}
	
	
	/**
	 * This method ensure that the view is visible. 
	 * If needed, it open the view through openView sequence and then active it 
	 * 
	 * @return this
	 */
	public ViewHelper showView() {
		List<SWTBotView> views = getViews();
		if (views.size() == 0) {
			openView();
		}
		getView().setFocus();
		return this;
	}

	/**
	 * Close all instances of view with provided name
	 * 
	 * @return this helper
	 */
	public ViewHelper closeViews() {
		for (SWTBotView view : getViews()) {
			view.close();
		}
		return this;
	}
	
	protected Matcher<IViewReference> getMatcher() {
		Matcher<IViewReference> match = withPartName(viewName);
		return match;
	}
}
