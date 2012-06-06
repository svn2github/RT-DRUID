/*
 * Created on 13-dic-2006
 *
 */
package com.eu.evidence.rtdruid.vartree.data.presentation;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.eu.evidence.rtdruid.ui.common.Abstract_VT_View;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IMultiValues;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVarTreeProvider;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * @author mvc
 * @author Ni
 */
public class CPUDialog extends Dialog {

	private IVarTreeProvider viewPart;
	private IVarTree vt;
	private String sysName;
	final private DataPackage DPKG = DataPackage.eINSTANCE;
	final private char S = IVarTree.SEPARATOR;

	final protected String[] typePath = new String[] {
			DPKG.getSystem().getName(),
			DPKG.getSystem_Architectural().getName(),
			DPKG.getArchitectural_EcuList().getName(), DPKG.getEcu().getName(),
			DPKG.getEcu_CpuList().getName(), DPKG.getCpu().getName(),
			DPKG.getCpu_Rtos().getName() };

	private Text cpuName, cpuType;

	public CPUDialog(Shell parentShell, IVarTreeProvider viewPart) {
		super(parentShell);
		this.viewPart = viewPart;
		this.vt = this.viewPart.getVarTree();
		refreshSystemName();
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);

		shell.setText("Add CPU");
	}

	protected Control createDialogArea(Composite parent) {

		Composite cpuComposite = (Composite) super.createDialogArea(parent);
		setLayout(cpuComposite);

		{
			Label message = new Label(cpuComposite, SWT.SIMPLE);
			message.setText("Please specify the CPU name. Optionally you may provide the cpu type.");
			GridData gd = new GridData(GridData.FILL_HORIZONTAL
					| GridData.VERTICAL_ALIGN_BEGINNING);
			gd.horizontalSpan = 2;
			message.setLayoutData(gd);

			Label blank = new Label(cpuComposite, SWT.SIMPLE);
			blank.setText("");
			GridData gd2 = new GridData(GridData.FILL_HORIZONTAL
					| GridData.VERTICAL_ALIGN_BEGINNING);
			gd2.horizontalSpan = 2;
			blank.setLayoutData(gd2);
		}
			
		new Label(cpuComposite, SWT.SIMPLE).setText("CPU Name: ");
		setGridData(cpuName = new Text(cpuComposite, SWT.BORDER));
		cpuName.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				String name = cpuName != null ? cpuName.getText() : null;
				if (name == null || name.length() == 0) {
					Button b = getButton(OK);
					if (b != null && b.isEnabled()) {
						b.setEnabled(false);
					}
				} else {
					Button b = getButton(OK);
					if (b != null && !b.isEnabled()) {
						b.setEnabled(true);
					}
				}

			}
		});

		
		new Label(cpuComposite, SWT.SIMPLE).setText("CPU Type: ");
		setGridData(cpuType = new Text(cpuComposite, SWT.BORDER));

		return cpuComposite;
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

	private void setLayout(Composite folder) {

		GridLayout glayout = new GridLayout();
		glayout.marginWidth = glayout.marginHeight = 5;
		glayout.horizontalSpacing = glayout.verticalSpacing = 10;
		glayout.numColumns = 2;
		folder.setLayout(glayout);

		folder.pack();
	}

	protected void setGridData(Control control) {
		GridData gd = new GridData(GridData.FILL_HORIZONTAL
				| GridData.VERTICAL_ALIGN_BEGINNING);
		control.setLayoutData(gd);
	}

	protected void okPressed() {
		// MessageDialog.openInformation(
		// this.getShell(),"Readme Editor","View Action executed");

		// storeTask();
		String cpu = cpuName.getText();
		if (cpu == null || cpu.length() == 0) {

			MessageDialog.openError(getShell(), "Missing cpu name",
					"please provide at least a name for the CPU");
			return;
		}

		addCPU(cpu, cpuType.getText());

		setReturnCode(OK);
		close();
	}

	private void addCPU(String cpuName, String cpuType) {

		final boolean aNewTransaction = vt.getCurrentTransaction() == null;
		IVarTreePointer vtp = null;
		final ITreeInterface ti = vt.newTreeInterface();

		String ecuPath = sysName + S + DPKG.getSystem_Architectural().getName()
				+ S + DPKG.getArchitectural_EcuList().getName();

		String[] ecuNames = ti.getAllName(ecuPath, DPKG.getEcu().getName());

		if (ecuNames.length == 0) {
			ecuNames = new String[] { "defaultEcu" };
		}

		String path = sysName + S + DPKG.getSystem_Architectural().getName()
				+ S + DPKG.getArchitectural_EcuList().getName() + S
				+ ecuNames[0] + S + DPKG.getEcu_CpuList().getName() + S
				+ DataPath.addSlash(cpuName) + S + DPKG.getCpu_Rtos().getName();

		if (aNewTransaction) {
			vt.beginTransaction();
		}
		boolean everythingFine = true;
		try {

			// make the path
			vtp = vt.newVarTreePointer();

			// check the path

			String[] pathSplit = DataPath.splitPath(path);
			vtp = vt.newTreeInterface().makePath(vtp, pathSplit, typePath);

			IVarTreePointer curr = vt.newVarTreePointer();
			curr.goAbsolute(path);

			storeAVar(curr, DPKG.getRtos_Name().getName(),
					DataPath.addSlash(cpuName));// makeRtosId(cpuName, "EE"));
			storeAVar(curr, DPKG.getRtos_Type().getName(), "EE");
			//
			// Store all properties
			// storeProperties();

		} catch (RuntimeException e) {
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

	protected void storeAVar(IVarTreePointer parent, String varName,
			String value) {

		IVarTreePointer curr = (IVarTreePointer) parent.clone();
		if (!curr.go(varName)) {
			curr.add(varName, new StringVar(value));
		} else {
			IVariable var = curr.getVar();
			if (var != null && var.get() != null) {
				if (var instanceof IMultiValues) {
					if (value != null) {
						((IMultiValues) var).appendValue(value);
					}
				}
			} else {
				IVariable tmpVar = curr.getNewVar(value);
				curr.setVar(tmpVar);
			}
		}
	}

	// private String makeRtosId(String cpu, String rtos) {
	// return DataPath.makeSlashedId(new String[] {cpu, rtos});
	// }

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
}
