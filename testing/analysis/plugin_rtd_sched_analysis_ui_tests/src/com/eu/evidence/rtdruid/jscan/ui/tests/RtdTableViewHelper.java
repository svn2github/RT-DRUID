package com.eu.evidence.rtdruid.jscan.ui.tests;

import static org.eclipse.swtbot.eclipse.finder.matchers.WidgetMatcherFactory.withPartId;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.ui.IViewReference;
import org.hamcrest.Matcher;

import com.eu.evidence.rtdruid.tests.ui.swtbot.ProgressBarHelper;
import com.eu.evidence.rtdruid.tests.ui.swtbot.ViewHelper;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class RtdTableViewHelper extends ViewHelper {
	
	public static enum AnalysisType {
		none("Select an analysis"),
		fp("Analysis without offsets (FP)"),
		fp_offset("Exact Analysis with offset (FP)"),
		fp_offset_suff("Sufficient analysis with offset (FP)"),
		stack("Stack Size"),
		multi_frame_fp("MultiFrame Task analysis (FP)"),
		proc_responsetime_fp("Proc Responsetime analysis (FP)"),
		cache_fp("Cache Miss Cost analysis (FP)");
		
		private final String text;
		
		/**
		 * 
		 */
		private AnalysisType(String s) {
			this.text = s;
		}

		/**
		 * @return the text
		 */
		public String getText() {
			return text;
		}
	}
	
	
	private static final String VIEW_NAME = "Task Table";

	/**
	 * @param bot
	 * @param viewName
	 * @param viewCategory
	 */
	public RtdTableViewHelper(SWTWorkbenchBot bot) {
		super(bot, VIEW_NAME, new String[] {"RT-Druid", "RT-Druid Table"});
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.tests.ui.swtbot.ViewHelper#getMatcher()
	 */
	@Override
	protected Matcher<IViewReference> getMatcher() {
		Matcher<IViewReference> matcher = withPartId("com.eu.evidence.rtdruid.vartree.data.presentation.RtdruidTableViewID");
		return matcher;
	}
	
	public SWTBotTree getTree() {
		return getView().bot().tree();
	}
	
	public RtdTableViewHelper setAnalysis(AnalysisType analysis) {
		getView().bot().comboBox(1).setSelection(analysis.getText());
		return this;
	}
	
	public RtdTableViewHelper runAnalysis() {
		getView().bot().button("Run Analysis").click();
		
		(new ProgressBarHelper(bot, "Progress Information")).setTimeout(LONG_BUILD_TIMEOUT).waitProgressBar();
		return this;
	}
	
	public RtdTableViewHelper addCpu(String cpuName) {
		getView().bot().tree().contextMenu("Add CPU").click();
		SWTBotShell shell = null;
		try {
			shell = bot.shell("Add CPU");
			shell.bot().textWithLabel("CPU Name: ").setText(cpuName);
//			shell.bot().textWithLabel();
			shell.bot().button(BTN_TXT_OK).click();
			
			shell = null;
		} finally {
			if (shell != null && shell.isOpen()) {
				shell.close();
			}
		}
		return this;
	}
	
	public RtdTableViewHelper addTask(String cpuName, String taskName) {
		getView().bot().tree().contextMenu("Add Task").click();
		SWTBotShell shell = null;
		try {
			shell = bot.shell("Add Task");
			shell.bot().textWithLabel("Task Name: ").setText(taskName);
			shell.bot().comboBoxWithLabel("CPU Name: ").setSelection(cpuName);
			
			
			shell.bot().button(BTN_TXT_OK).click();
			
			shell = null;
		} finally {
			if (shell != null && shell.isOpen()) {
				shell.close();
			}
		}
		return this;
	}
}

