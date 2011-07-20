package com.eu.evidence.rtdruid.vartree.data.presentation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationListener;
import org.eclipse.jface.viewers.ColumnViewerEditorDeactivationEvent;
import org.eclipse.jface.viewers.ICellEditorListener;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

/**
 * This class shows a table filled with the name and the wcet of all procs that
 * are mapped to a specific Task. It's possible to modify the wcet of each proc
 * and check if the sum is different from required value (as Task wcet).
 * 
 * @author Nicola Serreli
 */
public class TaskProcWcetDialog extends Dialog {

	/** The collection of proc mapped to a specific task */
	protected final ArrayList<ProcWcet> values;

	/** A constant that identifies the property Name (of a proc) */
	protected static final String PROC_NAME = "Name";
	/** A constant that identifies the property Wcet (of a proc) */
	protected static final String PROC_WCET = "wcet";
	/** The property of each column */
	public static final String[] PROPS = { PROC_NAME, PROC_WCET };

	/** Means that everything is ok (all values are valid and the sum is ok) */
	protected static final int NONE = 0;
	/**
	 * Means that something is wrong but still acceptable (like the sum is
	 * different form required value)
	 */
	protected static final int WARNING = 1;
	/**
	 * Means that something is wrong and must be solved
	 */
	protected static final int ERROR = 2;

	/**
	 * Stores the image used when everything is ok (all values are valid and the
	 * sum is ok)
	 */
	protected static final Image IMG_NONE = null;
	/**
	 * Stores the image used when something is wrong but still acceptable (like
	 * the sum is different form required value)
	 */
	protected static final Image IMG_WARNING;
	/**
	 * Stores the image used when something is wrong wrong and must be solved
	 */
	protected static final Image IMG_ERROR;

	/**
	 * The element that is connected to the current editor. If the editor is not
	 * active, this element is null
	 */
	protected ProcWcet changingProc;

	/** The graphic widget that shows the sum of wcets */
	protected Text total;
	/** The graphic widget that shows the current message */
	protected Label messages;
	/** The graphic widget that shows the icon related to the current message */
	protected Label icon;
	/** The wcet editor */
	protected TextCellEditor wcetEditor;

	/** The expected sum of wcets */
	protected final double taskWcet;

	/** Init the cache of images */
	static {
		// try to load Images
		Image tmp_w = null;
		Image tmp_e = null;
		try {
			tmp_w = PlatformUI.getWorkbench().getSharedImages().getImage(
					ISharedImages.IMG_OBJS_WARN_TSK);
			tmp_e = PlatformUI.getWorkbench().getSharedImages().getImage(
					ISharedImages.IMG_OBJS_ERROR_TSK);
		} catch (Exception e) {
			RtdruidLog.log(e);
		}
		IMG_WARNING = tmp_w;
		IMG_ERROR = tmp_e;
	}

	/**
	 * Build a new dialog
	 * 
	 * @param parentShell
	 *            a shell
	 * 
	 * @param values
	 *            the list of proc that will be showed inside the tab
	 * 
	 * @param taskWcet
	 *            the expected sum o wcets (equals to the task wcet)
	 */
	@SuppressWarnings("unchecked")
	public TaskProcWcetDialog(Shell parentShell, ArrayList<ProcWcet> values,
			TimeVar taskWcet) {
		super(parentShell);
		this.values = (ArrayList<ProcWcet>) values.clone();
		if (taskWcet == null) {
			this.taskWcet = 0;
		} else {
			taskWcet.setType(TimeVar.MILLI_SECOND);
			Double d = (Double) taskWcet.get();
			this.taskWcet = d == null ? 0 : d.doubleValue();
		}

		if (values == null) {
			throw new NullPointerException(
					"Expected a not null list of proc's wcet");
		}
	}

	/**
	 * Force this window to be resizable
	 * 
	 * @return always true
	 */
	protected boolean isResizable() {
		return true;
	}

	/* Create graphical widgets */
	protected Control createDialogArea(Composite parent_root) {

		Composite parent = (Composite) super.createDialogArea(parent_root);
		{
			GridLayout layout = new GridLayout();
			// layout.numColumns = 1;
			// layout.verticalSpacing = 12;
			parent.setLayout(layout);
		}

		{
			Label title = new Label(parent, SWT.LEFT);
			title.setText("Task's wcet is computed from procs' wcet : "
					+ RtdruidTableView.formatTimes(new Double(taskWcet)));
			title.setLayoutData(new GridData());
		}

		// TABLE

		{
			final TableViewer tv = new TableViewer(parent, SWT.FULL_SELECTION);
			Table table = tv.getTable();
			table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			new TableColumn(table, SWT.CENTER).setText(PROC_NAME);
			new TableColumn(table, SWT.CENTER).setText(PROC_WCET);

			tv.setContentProvider(new WcetContentProvider());
			tv.setLabelProvider(new WcetLabelProvider());
			tv.setInput(values);

			// editors
			CellEditor[] editors = new CellEditor[2];
			editors[0] = null;
			editors[1] = wcetEditor = new TextCellEditor(table);

			/* Editor Validator */
			wcetEditor.setValidator(new ICellEditorValidator() {

				/**
				 * A number is valid if is empty or if its a valid time (number
				 * or number+time unit)
				 */
				
				public String isValid(Object value) {
					if (value == null || "".equals(value))
						return null;

					try {
						new TimeVar("" + value);
					} catch (Exception e) {
						return "The new values is not a valid time";
					}
					return null;
				}
			});

			/*
			 * Editor state listener: Used to update messages if value is
			 * changed, if the editing is aborted or if the new value is set
			 */
			wcetEditor.addListener(new ICellEditorListener() {
				public void editorValueChanged(boolean oldValidState,
						boolean newValidState) {
					/* update the messages */
					updateMessage();
				}

				public void cancelEditor() {
					/* update the messages */
					updateMessage();
				}

				
				public void applyEditorValue() {
					/* update the messages */
					updateMessage();
				}
			});

			tv.setColumnProperties(PROPS);
			tv.setCellModifier(new WcetCellModifier(tv));
			tv.setCellEditors(editors);

			for (int i = 0, n = table.getColumnCount(); i < n; i++) {
				table.getColumn(i).pack();
			}
			table.setHeaderVisible(true);
			table.setLinesVisible(true);
			

			/*
			 * Add a listener to the activation and deactivation of the editor,
			 * in order to save the pointer to the item that the user want to
			 * modify
			 */
			tv.getColumnViewerEditor().addEditorActivationListener(
					new ColumnViewerEditorActivationListener() {

						
						public void beforeEditorActivated(
								ColumnViewerEditorActivationEvent event) {
							/*
							 * Enable the exception for the compute of the sum
							 * of wcet of each proc
							 */
							changingProc = null;
							Object source = event.getSource();
							if (source instanceof ViewerCell) {
								ViewerCell cell = (ViewerCell) source;
								Object element = cell.getElement();

								if (element instanceof ProcWcet) {
									changingProc = (ProcWcet) element;
								}
							}
						}

						
						public void afterEditorActivated(
								ColumnViewerEditorActivationEvent event) {
							/* do nothing */

						}

						
						public void beforeEditorDeactivated(
								ColumnViewerEditorDeactivationEvent event) {
							/* do nothing */
						}

						
						public void afterEditorDeactivated(
								ColumnViewerEditorDeactivationEvent event) {
							/*
							 * Disable the exception for the compute of the sum
							 * of wcet of each proc
							 */
							changingProc = null;
						}

					});

		}

		// Total wcet section
		{
			Composite totWcetParent = new Composite(parent, SWT.NONE);
			{
				GridLayout layout = new GridLayout();
				layout.numColumns = 2;
				// layout.verticalSpacing = 12;
				totWcetParent.setLayout(layout);
				totWcetParent.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
						false, false));
			}

			Label title = new Label(totWcetParent, SWT.LEFT);
			title.setText("Total wcet is ");
			title.setLayoutData(new GridData());

			total = new Text(totWcetParent, SWT.LEFT | SWT.READ_ONLY);
			total.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		}

		// Messages section
		{

			Composite msgParent = new Composite(parent, SWT.NONE);
			{
				GridLayout layout = new GridLayout();
				layout.numColumns = 2;
				// layout.verticalSpacing = 12;
				msgParent.setLayout(layout);
				msgParent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false,
						false));
			}

			icon = new Label(msgParent, SWT.LEFT);
			icon.setImage(null);
			icon.setText("");
			icon.setLayoutData(new GridData());

			messages = new Label(msgParent, SWT.LEFT);
			messages.setText("");
			messages
					.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		}

		{
			updateMessage();
		}
		return parent;
	}

	/**
	 * Computes the sum all wcets, using the value inside the editor, if there
	 * is an editor active
	 */
	protected double computeTotalWcet() {
		double d = 0;

		for (ProcWcet v : values) {
			if (changingProc == v) {
				// next proc : Removing the old value
				continue;
			}
			if (v.wcet != null && v.wcet.get() != null) {
				v.wcet.setType(TimeVar.MILLI_SECOND);
				d += ((Double) v.wcet.get()).doubleValue();
			}
		}

		if (changingProc != null && wcetEditor.isActivated()
				&& wcetEditor.isValueValid()) {
			// add the value of current editor
			try {
				TimeVar temp = new TimeVar((String) wcetEditor.getValue());
				temp.setType(TimeVar.MILLI_SECOND);
				Double editorValue = (Double) (temp).get();
				if (editorValue != null) {
					d += editorValue.doubleValue();
				}

			} catch (Exception e) {
				RtdruidLog.showDebug(e);
			}

		}

		return d;
	}

	/**
	 * @return a string that represent the total wcet
	 */
	protected String computeTotalWcetString() {
		return RtdruidTableView.formatTimes(computeTotalWcet()) + "ms";
	}

	/**
	 * @return the list of procs
	 */
	public ArrayList<ProcWcet> getValues() {
		return values;
	}

	/**
	 * This method tries to update the warning/error message and the related
	 * icon.
	 */
	protected void updateMessage() {

		{ // Update Total Value
			total.setText(computeTotalWcetString());
		}

		{ // Update the warning/error message
			String msg = "";
			Image type = IMG_NONE;

			if (wcetEditor.getErrorMessage() != null) {
				type = IMG_ERROR;
				msg = wcetEditor.getErrorMessage();
			} else if (Math.abs(taskWcet - computeTotalWcet()) > 1e-9) {
				System.out.println("Task wcet = " + taskWcet + " --- computed "
						+ computeTotalWcet());
				type = IMG_WARNING;
				msg = "Task's wcet is different from the sum of each proc's wcet";
			}

			icon.setImage(type);
			messages.setText(msg);
		}
	}

	/**
	 * This class is used by the Table (and editor) to modify a ProcWcet
	 * 
	 */
	class WcetCellModifier implements ICellModifier {
		/** The parent Table */
		private Viewer viewer;

		/**
		 * Builds a new Modifier
		 * 
		 * @param viewer
		 *            the parent table
		 */
		public WcetCellModifier(Viewer viewer) {
			this.viewer = viewer;
		}

		/*
		 * Returns true if it's possible to modify the specified property of the
		 * given element.
		 */
		public boolean canModify(Object element, String property) {
			return (PROC_WCET.equals(property));
		}

		/*
		 * Returns the value (if any) of the specified property of the given
		 * element.
		 */
		public Object getValue(Object element, String property) {
			ProcWcet p = (ProcWcet) element;
			if (PROC_NAME.equals(property))
				return p.procName;
			else if (PROC_WCET.equals(property))
				return p.getWcetString();
			else
				return null;
		}

		/*
		 * Set the new value of the specified property of the given element. It
		 * also ask to the parent table to refresh its cells.
		 */
		public void modify(Object element, String property, Object value) {

			System.out.println("Modify");

			if (element instanceof Item)
				element = ((Item) element).getData();

			ProcWcet p = (ProcWcet) element;
			if (PROC_NAME.equals(property))
				; // nothing
			else if (PROC_WCET.equals(property)) {
				try {
					p.wcet = value == null || "".equals(value) ? null
							: new TimeVar("" + value);
				} catch (Exception e) {
					// nothing
					RtdruidLog.showDebug(e);
				}
			}

			viewer.refresh();
		}
	}

	/**
	 * This class is used to fill the table with ProcWcet elements using a List
	 * as input
	 */
	class WcetContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object inputElement) {
			return ((List<?>) inputElement).toArray();
		}

		public void dispose() { /* do nothing */
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) { 
			/* do nothing */
		}
	}

	/**
	 * This class provides the text for each cell of a table of ProcWcets.
	 * 
	 */
	class WcetLabelProvider implements ITableLabelProvider {
		/* Returns the image: always null */
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		/*
		 * Returns the text for a specific cell. Column 0 -> Name Column 1 ->
		 * wcet
		 */
		public String getColumnText(Object element, int columnIndex) {
			ProcWcet elem = (ProcWcet) element;
			switch (columnIndex) {
			case 0:
				return elem.procName;
			case 1:
				return elem.getWcetString();
			}
			return null;
		}

		/* Do nothing */
		public void addListener(ILabelProviderListener listener) { 
			/* do nothing */
		}

		/* Do nothing */
		public void dispose() { /* do nothing */
		}

		/* Do nothing */
		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		/* Do nothing */
		public void removeListener(ILabelProviderListener listener) {
			/* do nothing */
		}
	}
}

/**
 * This class is used to store some informations related to a single proc: the
 * name, the path inside the tree and the wcet.
 */
class ProcWcet {
	/** The name of the proc */
	public final String procName;
	/** The path of the proc */
	public final String procPath;
	/** The wcet of the proc */
	public TimeVar wcet;

	/**
	 * Builds a new Container for a proc
	 * 
	 * @param procName
	 *            the name (should be not null)
	 * @param procPath
	 *            the path inside the tree (should be not null)
	 * @param wcet
	 *            the wcet of this proc. If null, it is showed as an empty
	 *            string and it is equivalent to 0 during the computation of
	 *            total wcet
	 */
	public ProcWcet(String procName, String procPath, TimeVar wcet) {
		this.procName = procName;
		this.procPath = procPath;
		this.wcet = wcet;
	}

	/**
	 * This method computes the string representation of current wcet. If the
	 * value is null, this method returns an empty string.
	 * 
	 * @return a string that represent the current wcet.
	 */
	public String getWcetString() {
		return wcet == null ? "" : RtdruidTableView.formatTimes((Double) wcet
				.get());
	}

	
	public String toString() {
		return "{ProcName = " + procName + " ; path = " + procPath
				+ " ; wcet = " + wcet + "}";
	}
}