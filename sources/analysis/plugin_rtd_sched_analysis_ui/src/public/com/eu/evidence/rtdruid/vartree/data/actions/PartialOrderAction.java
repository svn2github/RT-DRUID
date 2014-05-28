package com.eu.evidence.rtdruid.vartree.data.actions;

import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.jscan.partialorder.MessagesReporter;
import com.eu.evidence.rtdruid.internal.modules.jscan.partialorder.PartialOrderChecker;
import com.eu.evidence.rtdruid.internal.modules.jscan.partialorder.PartialOrderData;
import com.eu.evidence.rtdruid.internal.modules.jscan.partialorder.ProcData;
import com.eu.evidence.rtdruid.internal.modules.jscan.partialorder.TaskData;
import com.eu.evidence.rtdruid.ui.common.RTDConsole;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreeProvider;

public class PartialOrderAction implements IWorkbenchWindowActionDelegate {

	private IWorkbenchWindow window;
	
	
	public void dispose() {
		// do nothing
	}

	
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}

	
	public void run(IAction action) {
		IWorkbenchPage iwp = window.getActivePage();
		IEditorPart iep = iwp == null ? null : iwp.getActiveEditor();
		if (iep == null || !(iep instanceof IVarTreeProvider)) {
			MessageDialog.openError(window.getShell(), "Partial Order check", "Open an editor able to manage RT-Druid files");
		}
		
		boolean outputEnable = false;
		RTDConsole console = RTDConsole.getConsole();
		if (console != null && console.getMessages() != null) {
			Messages.setCurrent(console.getMessages());
			Messages.clearNumbers();
			// console.clear();
			outputEnable = true;
		}

		
		
		try {
			IVarTree vt = ((IVarTreeProvider) iep).getVarTree();
			PartialOrderData pod = new PartialOrderData(vt, new MessagesReporter());
			pod.computeAndUpdateOnceEveryK();
			PartialOrderChecker checker = new PartialOrderChecker(pod);
			
			
			System.out.println("\nResult ..");
			List<TaskData> tasks = pod.getTasks();
			System.out.println("  .. tasks:");
			for (TaskData t : tasks)
				System.out.println(t);
	
			List<ProcData> procs = pod.getProcs();
			System.out.println("  .. procs:");
			for (ProcData t : procs)
				System.out.println(t);
			
			
	boolean result = checker.checkAll();
			
			pod.getReporter().message("The result of check is : " + result);
		} finally {
			if (outputEnable) {
				Messages.clearNumbers();
				Messages.setPrevious();
			}
		}
	}

	
	public void selectionChanged(IAction action, ISelection selection) {
		// do nothing
	}

}
