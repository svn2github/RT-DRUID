/*
 * Created on 7-dic-2006
 */
package com.eu.evidence.rtdruid.vartree.data.presentation;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.eu.evidence.rtdruid.ui.common.Abstract_VT_View;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVarTreeProvider;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Task;
import com.eu.evidence.rtdruid.vartree.abstractions.old.TaskSet;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.tools.Search;
import com.eu.evidence.rtdruid.vartree.tools.Search.ArchElement;

/**
 * @author mvc
 * @author Ni
 */
public class TaskDialog extends Dialog {
	private IVarTreeProvider viewPart;
	private IVarTree vt;
	private String sysName;

	final private DataPackage DPKG = DataPackage.eINSTANCE;
	final private String[] taskTypePath = new String[] {
			DPKG.getSystem().getName(),
			DPKG.getSystem_Architectural().getName(),
			DPKG.getArchitectural_TaskList().getName(),
			DPKG.getTask().getName(), };
	final private char S = IVarTree.SEPARATOR;

	static final protected String[][] taskP = {
			{ Task.STR_ACT_TYPE, "__see_task__" }, { "wcet", "__see_task__" },
			{ "period", "__see_task__" }, { "deadline", "__see_task__" },
			{ "priority", "__see_task__" }, { "threshold", "__see_task__" },
			{ "stack", "__see_task__" }, { "priority", "__see_task__" },
			{ "resource", "__see_task__" },
			{ "offset", "__see_task__" },
			{ "ResponseTime", "__see_task__" },
			// { "PreemptionGroupName", "__see_task__" },
			// { "blocking", "__see_task__" },
			{ "schedulable", "__see_task__" },
			{ "utilization", "__see_task__" }, { "cDelta", "__see_task__" } };

	private Text taskName;
	private Combo cpuName;
//	private Text actClass, actNumber, preemptionGroupName, modeRef, threshold, type;
	private Text deadline, priority, stack, offSet, period, wcet;
	private Text resourceMethodRef;

	public TaskDialog(Shell parentShell, IVarTreeProvider viewPart) {
		super(parentShell);
		this.viewPart = viewPart;
		this.vt = this.viewPart.getVarTree();
		refreshSystemName();
	}

	protected Control createDialogArea(Composite parent) {

		Composite taskComposite = (Composite) super.createDialogArea(parent);

		final CTabFolder folder = new CTabFolder(taskComposite, SWT.BORDER);

		final CTabItem taskItem = new CTabItem(folder, SWT.NONE);
		taskItem.setText("Task");
		createTaskControl(folder, taskItem);
		// taskItem.setImage(image);

		final CTabItem activationItem = new CTabItem(folder, SWT.NONE);
		activationItem.setText("Activation");
		createActivationControl(folder, activationItem);

		final CTabItem schedulingItem = new CTabItem(folder, SWT.NONE);
		schedulingItem.setText("Scheduling");
		createSchedulingControl(folder, schedulingItem);

		final CTabItem resourceItem = new CTabItem(folder, SWT.NONE);
		resourceItem.setText("Resource");
		createResourceRefControl(folder, resourceItem);

		return taskComposite;
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);

		shell.setText("Add Task");
	}

	private void setLayout(Composite folder) {

		GridLayout glayout = new GridLayout();
		glayout.marginWidth = glayout.marginHeight = 5;
		glayout.horizontalSpacing = glayout.verticalSpacing = 10;
		glayout.numColumns = 2;
		folder.setLayout(glayout);

		folder.pack();
	}

	private void setEnableOK(boolean value) {
		Button b = getButton(OK);
		if (b != null) {
			if (value && !b.isEnabled()) {
				b.setEnabled(true);

			} else if (!value && b.isEnabled()) {
				b.setEnabled(false);
			}
		}
	}
	
	protected Control createButtonBar(Composite parent) {
		Control answer = super.createButtonBar(parent);
		{
			Button b = getButton(OK);
			if (b != null && b.isEnabled()) {
				b.setEnabled(false);
			}
		}
		return answer;
	}

	private void createTaskControl(CTabFolder folder, CTabItem item) {

		Composite tabItemComposite = new Composite(folder, SWT.NONE);
		setLayout(tabItemComposite);

		new Label(tabItemComposite, SWT.SIMPLE).setText("Task Name: ");
		setGridData(taskName = new Text(tabItemComposite, SWT.BORDER));
		
		new Label(tabItemComposite, SWT.SIMPLE).setText("CPU Name: ");
		setGridData(cpuName = new Combo(tabItemComposite, SWT.BORDER | SWT.READ_ONLY));
		{
			ArchElement[] elems = Search.allRtosNames(vt.newTreeInterface());
			for (ArchElement elem : elems) {
				cpuName.add(elem.name);
			}
		}

		ModifyListener modList = new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setEnableOK(
						taskName.getText().length() != 0 
						&& cpuName.getText().length() != 0);
			}
		};
		taskName.addModifyListener(modList);
		cpuName.addModifyListener(modList);
		
		item.setControl(tabItemComposite);
	}

	private void createActivationControl(CTabFolder folder, CTabItem item) {
		Composite tabItemComposite = new Composite(folder, SWT.NONE);
		setLayout(tabItemComposite);

		// new Label(tabItemComposite,
		// SWT.SIMPLE).setText("Activation Class: ");
		// setGridData(actClass = new Text(tabItemComposite, SWT.BORDER));

		// new Label(tabItemComposite, SWT.SIMPLE).setText("Act Number: ");
		// setGridData(actNumber = new Text(tabItemComposite, SWT.BORDER));

		new Label(tabItemComposite, SWT.SIMPLE).setText("Deadline: ");
		setGridData(deadline = new Text(tabItemComposite, SWT.BORDER));

		// new Label(tabItemComposite, SWT.SIMPLE).setText("ModeRef: ");
		// setGridData(modeRef = new Text(tabItemComposite, SWT.BORDER));

		new Label(tabItemComposite, SWT.SIMPLE).setText("OffSet: ");
		setGridData(offSet = new Text(tabItemComposite, SWT.BORDER));

		new Label(tabItemComposite, SWT.SIMPLE).setText("Period: ");
		setGridData(period = new Text(tabItemComposite, SWT.BORDER));

		// new Label(tabItemComposite, SWT.SIMPLE).setText("Type: ");
		// setGridData(type = new Text(tabItemComposite, SWT.BORDER));

		item.setControl(tabItemComposite);
	}

	private void createSchedulingControl(CTabFolder folder, CTabItem item) {
		Composite tabItemComposite = new Composite(folder, SWT.NONE);
		setLayout(tabItemComposite);
		;

		// new Label(tabItemComposite,
		// SWT.SIMPLE).setText("PreemptionGroupName: ");
		// setGridData(preemptionGroupName = new Text(tabItemComposite,
		// SWT.BORDER));

		new Label(tabItemComposite, SWT.SIMPLE).setText("Priority: ");
		setGridData(priority = new Text(tabItemComposite, SWT.BORDER));

		new Label(tabItemComposite, SWT.SIMPLE).setText("Stack: ");
		setGridData(stack = new Text(tabItemComposite, SWT.BORDER));

//		new Label(tabItemComposite, SWT.SIMPLE).setText("Threshold: ");
//		setGridData(threshold = new Text(tabItemComposite, SWT.BORDER));

		new Label(tabItemComposite, SWT.SIMPLE).setText("WCET: ");
		setGridData(wcet = new Text(tabItemComposite, SWT.BORDER));

		item.setControl(tabItemComposite);
	}

	private void createResourceRefControl(CTabFolder folder, CTabItem item) {
		Composite tabItemComposite = new Composite(folder, SWT.NONE);
		setLayout(tabItemComposite);

		new Label(tabItemComposite, SWT.SIMPLE).setText("ResourceMethodRef: ");
		setGridData(resourceMethodRef = new Text(tabItemComposite, SWT.BORDER));

		item.setControl(tabItemComposite);
	}

	protected void setGridData(Control control) {
		GridData gd = new GridData(GridData.FILL_HORIZONTAL
				| GridData.VERTICAL_ALIGN_BEGINNING);
		control.setLayoutData(gd);
	}

	protected void okPressed() {
		// MessageDialog.openInformation(
		// this.getShell(),"Readme Editor","View Action executed");

		String tName = taskName.getText();
		if (tName == null || tName.length() == 0) {
			MessageDialog.openError(getShell(), "Missing task name",
					"please provide a name for the task");
			return;
		}
		String cName = cpuName.getText();
		if (cName == null || cName.length() == 0) {
			MessageDialog.openError(getShell(), "Missing cpu name",
					"please provide a name for the cpu");
			return;
		}
		boolean all_ok = true;
		try {
			storeTask();
		} catch (Exception e) {
			MessageDialog.openError(getShell(), "Error", e.getMessage());
			all_ok = false;
		}

		if (all_ok) {
			setReturnCode(OK);
			close();
		}
	}

	private void storeTask() throws Exception {

		final boolean aNewTransaction = vt.getCurrentTransaction() == null;
		IVarTreePointer vtp = null;

		String tName = taskName.getText();

		String path = sysName + S + DPKG.getSystem_Architectural().getName()
				+ S + DPKG.getArchitectural_TaskList().getName() + S + tName
				+ S;
		if (aNewTransaction) {
			vt.beginTransaction();
		}
		boolean everythingFine = true;
		try {

			// make the path
			vtp = vt.newVarTreePointer();

			// check the path

			String[] pathSplit = DataPath.splitPath(path);
			vtp = makePath(vtp, pathSplit, taskTypePath);

			//
			// Store all properties
			// storeProperties();

			storeTaskMap(vt.newVarTreePointer(), tName,
					DataPath.addSlash(cpuName.getText())); // makeRtosId(cpuName.getText(),
															// "ee"));

			makeTaskPeriodic(vt.newVarTreePointer(),
					DataPath.makePath(taskTypePath), path);

			addTaskProperties(tName, null);

		} catch (Exception e) {
			everythingFine = false;
			
			if (aNewTransaction) {
				vt.rollbackTransaction();
			}
			throw e;

		} finally {
			if (everythingFine) {
				if (aNewTransaction) {
					vt.commitTransaction();
				}
				if (viewPart instanceof Abstract_VT_View) {
					((Abstract_VT_View) viewPart).forceUpdate();
				}
			}
		}
	}
	
	private void updateProp(Task t, String propName, String value) {
		if (value != null && value.length() >0)
			t.setProperty(propName, value);
	}

	private void addTaskProperties(String taskName, String mode) {
		TaskSet tasks = new TaskSet(vt, sysName, mode);
		tasks.setSave(true);

		for (int i = 0; i < taskP.length; i++) {
			tasks.setProperty(taskP[i][0], taskP[i][1], false);
		}
		tasks.onlyPeriodicTasks();

		for (int i = 1; i < tasks.getPrefixNumber(); i++) {

			/*
			 * private Text actClass, actNumber, deadline, modeRef, offSet,
			 * period, type; private Text preemptionGroupName, priority, stack,
			 * threshold; private Text resourceMethodRef;
			 */

			for (int j = 0; j < tasks.getSize(i); j++) {
				Task t = (Task) tasks.getItem(i, j);
				if (t.getName().equals(taskName)) {

					updateProp(t, "Deadline", deadline.getText());
					updateProp(t, "Offset", offSet.getText());
					updateProp(t, "Period", period.getText());
					updateProp(t, "Priority", priority.getText());
					updateProp(t, "Threshold", priority.getText());
					updateProp(t, "Stack", stack.getText());
					updateProp(t, "wcet", wcet.getText());
					updateProp(t, "resource", resourceMethodRef.getText());
				}
			}
		}
	}

	// private String makeRtosId(String cpu, String rtos) {
	// return DataPath.makeSlashedId(new String[] {cpu, rtos});
	// }

	protected void makeTaskPeriodic(IVarTreePointer vtp, String type,
			String path) {

		type = type + S + DPKG.getTask_ActivationList().getName() + S
				+ DPKG.getActivation().getName() + S
				+ DPKG.getActivation_Type().getName();

		path = path + DPKG.getTask_ActivationList().getName() + S
				+ DataPath.NULL_ID + S + DPKG.getActivation_Type().getName();

		IVarTreePointer curr = makePath(vtp, DataPath.splitPath(path),
				DataPath.splitPath(type));
		{
			IVariable v = curr.getNewVar("periodic");
			curr.setVar(v);
		}

	}

	protected void storeTaskMap(IVarTreePointer vtp, String taskName,
			String rtosName) throws CheckException {
		String[] mapNamePath = { sysName, DPKG.getSystem_Mapping().getName(),
				DPKG.getMapping_TaskMapList().getName(),
				DataPath.makeId(new String[] { null, taskName }), //
				DPKG.getTaskMap_RtosRef().getName() };
		String[] mapTypePath = { sysName, DPKG.getSystem_Mapping().getName(),
				DPKG.getMapping_TaskMapList().getName(),
				DPKG.getTaskMap().getName(),
				DPKG.getTaskMap_RtosRef().getName() };

		IVarTreePointer curr = makePathMapping(vtp, mapNamePath, mapTypePath);
		if (curr.getVar() != null && curr.getVar().get() != null) {
			checkTrue(checkStrings(curr.getVar().toString(), rtosName),
					"Task " + taskName + " is already mapped to "
							+ curr.getVar().toString()
							+ " and cannot be mapped to a different rtos ("
							+ rtosName + ")");
		} else {
			IVariable v = curr.getNewVar(rtosName);
			curr.setVar(v);
		}

	}

	protected boolean checkStrings(String a, String b) {
		return a == null ? b == null : a.equals(b);
	}

	protected void checkTrue(boolean value, String msg) throws CheckException {
		if (!value) {
			throw new CheckException(msg);
		}
	}

	protected IVarTreePointer makePathMapping(IVarTreePointer vtp,
			String[] names, String[] types) throws CheckException {
		// if vtp, names or types is null it will throw an NullPointerException;
		// If the code is correct, it will never throw that exception.
		// Otherwise I need to add a check for array's lengths
		Assert.isLegal(names.length == types.length);

		// System.out.println("Path");
		// for (int i=0; i< names.length; i++) {
		// System.out.println("\t" +names[i] + "-" + types[i]);
		// }
		// use a copy !
		vtp = (IVarTreePointer) vtp.clone();

		for (int i = 0; i < names.length; i++) {
			// try to go into the required node
			if (!vtp.go(DataPath.addSlash(names[i]))) {

				// try to add it
				try {
					vtp.add(names[i], types[i]);
				} finally {

				}
				// try again to go in the new node
				checkTrue(vtp.go(DataPath.addSlash(names[i])),
						"Error when try to add a node :\n\t" + "name = "
								+ names[i] + " ,type = " + types[i]);
			}
		}
		return vtp;
	}

	static IVarTreePointer makePath(IVarTreePointer vtp, String[] names,
			String[] types) {
		// if vtp, names or types is null it will throw an NullPointerException;
		// If the code is correct, it will never throw that exception.
		// Otherwise I need to add a check for array's lengths
		Assert.isLegal(names.length == types.length);

		// System.out.println("Path");
		// for (int i=0; i< names.length; i++) {
		// System.out.println("\t" +names[i] + "-" + types[i]);
		// }
		// use a copy !
		vtp = (IVarTreePointer) vtp.clone();

		for (int i = 0; i < names.length; i++) {
			// try to go into the required node

			if (!vtp.go(names[i]/* DataPath.addSlash(names[i]) */)) {

				// try to add it
				try {
					vtp.add(DataPath.removeSlash(names[i]), types[i]);
				} catch (Exception e) {
				}

				// try again to go in the new node
				if (!vtp.go(names[i]/* DataPath.addSlash(names[i]) */)) {
					if (vtp.getVar() == null) {
						throw new RuntimeException(
								"Error when try to add a node :\n\t"
										+ "name = " + names[i] + " ,type = "
										+ types[i]);
					}
				}
			}
		}
		return vtp;
	}

	protected void refreshSystemName() {
		final ITreeInterface ti = vt.newTreeInterface();

		// search System ...
		String prefix = null;
		String[] tmp = ti.getAllName(prefix, DataPackage.eINSTANCE.getSystem()
				.getName());
		if (tmp.length == 0) {
			sysName = null;
			return;
		}
		sysName = tmp[0];
	}

	
	class CheckException extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 252619551309928214L;
		public CheckException() {
			super();
		}
		public CheckException(String txt) {
			super(txt);
		}
	}
}
