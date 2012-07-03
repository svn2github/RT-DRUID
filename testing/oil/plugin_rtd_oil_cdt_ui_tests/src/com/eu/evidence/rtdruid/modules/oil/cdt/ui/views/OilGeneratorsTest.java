/**
 * 08/giu/2012
 */
package com.eu.evidence.rtdruid.modules.oil.cdt.ui.views;

import static org.junit.Assert.assertThat;

import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.hamcrest.Matchers;
import org.junit.Test;

import com.eu.evidence.rtdruid.tests.ui.swtbot.AbstractSwtBotTest;
import com.eu.evidence.rtdruid.tests.ui.swtbot.ViewHelper;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class OilGeneratorsTest extends AbstractSwtBotTest {

	/**
	 * 
	 */
	private static final String VIEW_NAME = "Oil Generators";

	@Test
	public void openView() {
		
		ViewHelper helper = new ViewHelper(bot, VIEW_NAME, new String[] {"RT-Druid", VIEW_NAME});
		helper.closeViews();
		
		SWTBotView view = helper.openView().getView();
		SWTBotTreeItem[] values = view.bot().tree().getAllItems();
		assertThat(values.length, Matchers.greaterThan(0));
		helper.closeViews();
	}
	
}
