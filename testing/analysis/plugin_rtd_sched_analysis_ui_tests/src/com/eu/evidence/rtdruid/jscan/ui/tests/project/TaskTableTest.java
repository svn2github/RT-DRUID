/**
 * 07/giu/2012
 */
package com.eu.evidence.rtdruid.jscan.ui.tests.project;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Test;

import com.eu.evidence.rtdruid.jscan.ui.tests.RtdTableViewHelper;
import com.eu.evidence.rtdruid.jscan.ui.tests.examples.RtdModelTreeEditorHelper;
import com.eu.evidence.rtdruid.tests.ui.swtbot.StandardWidgetTexts;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class TaskTableTest extends AbstractFileTest implements StandardWidgetTexts {

	protected RtdModelTreeEditorHelper teh;


	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.jscan.ui.tests.project.AbstractFileTest#cleanUp()
	 */
	@Override
	@After
	public void cleanUp() {
		super.cleanUp();
		
		if (teh != null) {
			teh.saveEditors();
			teh.closeEditors();
		}
	}
	
	@Test
	public void taskTableChanges() {
		final String projectName = "new jscan project";
		final String fileName = "testFile.ertd";

		createProject(projectName, fileName);
		
		{// open editor 
			teh = new RtdModelTreeEditorHelper(bot, fileName);
			teh.closeEditors();
			teh.openWorkspaceFile(projectName, fileName);
		}
			
		// open view
		RtdTableViewHelper helper = new RtdTableViewHelper(bot);
		helper.closeViews().openView();
		helper.getView().setFocus();
		helper.addCpu("myCpu").addTask("myCpu", "task1").addTask("myCpu", "task2");
		final int colunms = helper.getTree().columnCount();
		for (SWTBotTreeItem item : helper.getTree().getAllItems()) {
			System.out.println("item " + item.getText());
			
			for (int i = 0; i<colunms; i++)  {
				System.out.println("\tcol " + i + " " + item.cell(i));
			}
		}
	}
}
