/*
 * Created on 18-dic-2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.eu.evidence.rtdruid.vartree.data.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IViewPart;

import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreeProvider;
import com.eu.evidence.rtdruid.vartree.data.presentation.RtdruidTableView;
import com.eu.evidence.rtdruid.vartree.data.presentation.TaskDialog;
import com.eu.evidence.rtdruid.vartree.tools.Search;
import com.eu.evidence.rtdruid.vartree.tools.Search.ArchElement;

/**
 * @author mvc
 * @author Ni
 */
public class AddTaskAction extends Action {
	
	private IViewPart view;
	
	public AddTaskAction(String ActionName, IViewPart view){
		super(ActionName);
		this.view = view;
	}
	
	public void run(){
		
		IVarTree vt = null;
		if (view instanceof IVarTreeProvider) {
			vt = ((IVarTreeProvider) view).getVarTree();
		}
		if (vt != null) {
			String[] elems = Search.allRtos(vt.newTreeInterface());
			if (elems != null && elems.length >0) {
				Dialog taskDailog = new TaskDialog(view.getSite().getShell(), (RtdruidTableView)view);
				taskDailog.open();
			} else {
				MessageDialog.openWarning(view.getViewSite().getShell(), "No cpu found", "Please add a cpu before add a task");
			}
		} else {
			MessageDialog.openInformation(view.getSite().getShell(), "No RT-Druid file sected", "Please select an opened RT-Druid file in a RT-Druid editor");
		}
	}

}
