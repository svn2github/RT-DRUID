/**
 * 08/giu/2012
 */
package com.eu.evidence.rtdruid.modules.oil.cdt.ui.views;

import static org.junit.Assert.assertThat;

import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
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
public class ActiveOilImplementationsTest extends AbstractSwtBotTest {

	/**
	 * 
	 */
	private static final String VIEW_NAME = "Active Oil Implementation";

	@Test
	public void openView() {
		
		ViewHelper helper = new ViewHelper(bot, VIEW_NAME, new String[] {"RT-Druid", VIEW_NAME});
		helper.closeViews();
		
		SWTBotView view = helper.openView().getView();
		String text = view.bot().styledText().getText();
		assertThat(text, Matchers.startsWith("IMPLEMENTATION ee {"));
		helper.closeViews();
	}
	
}
