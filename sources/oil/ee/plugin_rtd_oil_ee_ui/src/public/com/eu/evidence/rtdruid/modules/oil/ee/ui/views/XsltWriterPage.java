/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.eu.evidence.rtdruid.modules.oil.ee.ui.views;

import com.eu.evidence.rtdruid.modules.oil.ui.views.RegistredXsltStepsView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilReaderFactory;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.HistoryXsltDebugger;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.XsltComponent;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.HistoryXsltDebugger.IntermediateOutput;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.DebugErikaEnterpriseXsltWriter;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.VarTreeUtil;

/**
 * @author dejan
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class XsltWriterPage implements IDetailsPage {
	private IManagedForm mform;
	private Map.Entry<String, XsltComponent> input;
	private FormText inputText;
	private FormText outputText;
	private TreeViewer viewer;

	private Text oilFile;
	private Composite mainComposite;
	
	private Tree xsltComponets;
	private HistoryXsltDebugger history;
	
	
	class MasterContentProvider implements ITreeContentProvider {

		@SuppressWarnings("unchecked")
		public Object[] getChildren(Object parentElement) {
			ArrayList<Object> answer = new ArrayList<Object>();
			Object value = parentElement;
			if (parentElement instanceof Map.Entry) {
				value = ((Map.Entry) parentElement).getValue();
				answer.add("Writer root");
			}
			if (value instanceof XsltComponent) {
				answer.addAll(((XsltComponent) value).getFurtherTransformations());
			}
				
			return answer.toArray();
		}

		public Object getParent(Object element) {
			if (input != null) {
				XsltComponent current = input.getValue();
				if (current != element) {
					return search(current, element);
				}
			}
			
			return null;
		}
		
		protected XsltComponent search(XsltComponent parent, Object element) {
			ArrayList<XsltComponent> children = parent.getFurtherTransformations();
			
			for( XsltComponent current : children) {
				if (current == element) {
					return parent;
				} else {
					XsltComponent tmp = search(current, element);
					if (tmp != null) {
						return tmp;
					}
				}
			}
			return null;
		}

		public boolean hasChildren(Object element) {
			Object value = element;
			if (element instanceof Map.Entry) {
				//value = ((Map.Entry) element).getValue();
				return true;
			}
			if (value instanceof XsltComponent) {
				return !((XsltComponent) value).getFurtherTransformations().isEmpty();
			}
			return false;
		}

		@SuppressWarnings("unchecked")
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Map.Entry) {
				
				ArrayList<Object> answer = new ArrayList<Object>();
				answer.add("Writer root");
				Object value = ((Map.Entry) inputElement).getValue();
				if (value instanceof XsltComponent) {
					answer.addAll(((XsltComponent) value).getFurtherTransformations());
				}

				return answer.toArray();
			}
			return new Object[0];
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
		
	}
	class MasterLabelProvider extends LabelProvider
			implements
				ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return getText(obj);
		}
			
		@SuppressWarnings("unchecked")
		public String getText(Object obj) {

			if (obj instanceof Map.Entry) { // <String, XsltComponent>
				Map.Entry entry = (Map.Entry) obj;
				if (entry.getKey() instanceof String &&
						entry.getValue() instanceof XsltComponent) {
					return "Writer root";
//					return (String) entry.getKey();
				}
				
				return "" + entry.getKey();
			} else if (obj instanceof XsltComponent) {
				return ((XsltComponent) obj).getLocalTransformationId();
			}
			return obj.toString();
		}
		public Image getColumnImage(Object obj, int index) {
			return null;
		}
	}

	
	
	
	public XsltWriterPage() {
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#initialize(org.eclipse.ui.forms.IManagedForm)
	 */
	public void initialize(IManagedForm mform) {
		this.mform = mform;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	public void createContents(Composite parent) {
		{
			TableWrapLayout layout = new TableWrapLayout();
			layout.topMargin = 5;
			layout.leftMargin = 5;
			layout.rightMargin = 2;
			layout.bottomMargin = 2;
			parent.setLayout(layout);
		}
		mainComposite = parent;

		FormToolkit toolkit = mform.getToolkit();
		
		
		Section s0 = toolkit.createSection(parent, 
				Section.COMPACT |
				Section.TWISTIE | Section.EXPANDED | 
				Section.DESCRIPTION|Section.TITLE_BAR);
		s0.marginWidth = 10;
		s0.setText("Structure"); //$NON-NLS-1$
//		s1.setDescription("Xslt transformation details"); //$NON-NLS-1$
		{
			TableWrapData td0 = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP);
			td0.grabHorizontal = true;
	//		td0.grabVertical = true;
			s0.setLayoutData(td0);
		}
		Composite client0 = toolkit.createComposite(s0);
//		{
//			GridLayout glayout = new GridLayout();
//			glayout.marginWidth = glayout.marginHeight = 0;
//			glayout.numColumns = 1;
//			client0.setLayout(glayout);
//		}
		{
			TableWrapLayout layout = new TableWrapLayout();
			layout.numColumns = 2;
			client0.setLayout(layout);
		}
	
		xsltComponets = toolkit.createTree(client0, SWT.NULL);
//		GridData gd = new GridData(GridData.FILL_BOTH);
//		gd.heightHint = 40;
//		gd.widthHint = 100;
////		gd.grabExcessVerticalSpace = true;
//		t.setLayoutData(gd);
		{
			TableWrapData td = new TableWrapData(TableWrapData.FILL, TableWrapData.TOP);
			td.grabHorizontal = true;
			td.grabVertical = true;
			td.heightHint = 80;
			td.rowspan = 4;
			xsltComponets.setLayoutData(td);
		}


		viewer = new TreeViewer(xsltComponets);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				updateTexts();
				forceRefresh();
			}
		});
		viewer.addDoubleClickListener(new IDoubleClickListener() {
		
			public void doubleClick(DoubleClickEvent event) {
				
				ISelection sel = event.getSelection();
				if (sel.isEmpty()) {
					return;
				}
				
				if (sel instanceof StructuredSelection) {
					
				
				
					try {
						IViewPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("com.eu.evidence.rtdruid.modules.oil.views.XsltCodeGenStepsID");
						if (part != null && part instanceof RegistredXsltStepsView) {
							RegistredXsltStepsView xsltStepView = (RegistredXsltStepsView) part;
							xsltStepView.setSelection(((StructuredSelection) sel).getFirstElement());
						}
					} catch (PartInitException exception) {
					    RtdruidLog.log(exception);
					}
				}
			}
		});
		viewer.setContentProvider(new MasterContentProvider());
		viewer.setLabelProvider(new MasterLabelProvider());
		
		final Button add = toolkit.createButton(client0, "add", SWT.PUSH); //$NON-NLS-1$
		add.addSelectionListener(new SelectionListener() {
		
			public void widgetSelected(SelectionEvent e) {
				doJob(e);
			}
		
			public void widgetDefaultSelected(SelectionEvent e) {
				doJob(e);
			}
			void doJob(SelectionEvent e) {
				
				
				XsltComponent parentStep = null;
				TreeItem[] selecteditems = xsltComponets.getSelection();
				if (selecteditems.length >0) {
					Object data = selecteditems[0].getData();
					if (data instanceof XsltComponent) {
						parentStep = (XsltComponent) data;
					}
				} 
				if (parentStep == null) {
					parentStep = input.getValue();
				}
				
				WizardDialog dialog = new WizardDialog(add.getShell(), new ChooseXsltStepWizard(parentStep));
				dialog.open();
				viewer.refresh();
			}
		});
		{
			TableWrapData td = new TableWrapData(TableWrapData.FILL, TableWrapData.TOP);
			add.setLayoutData(td);
		}
		
		
		final Button remove = toolkit.createButton(client0, "remove", SWT.PUSH); //$NON-NLS-1$
		remove.addSelectionListener(new SelectionListener() {
		
			public void widgetSelected(SelectionEvent e) {
				doJob(e);
			}
		
			public void widgetDefaultSelected(SelectionEvent e) {
				doJob(e);
			}
			
			protected void search(XsltComponent current, Set<XsltComponent> toBeRemoved) {
				
				XsltComponent[] children = current.getFurtherTransformations().toArray(new XsltComponent[0]);
				for (XsltComponent child : children) {
					if (toBeRemoved.contains(child)) {
						current.removeTransformation(child);
					} else {
						search(child, toBeRemoved);
					}
				}
			}
			
			protected void doJob(SelectionEvent e) {
				if (viewer.getSelection().isEmpty()) {
					MessageDialog.openWarning(remove.getShell(), "", "Select a step before press remove button");
					return;
				}
				TreeItem[] selecteditems = xsltComponets.getSelection();
				if (selecteditems.length == 1 && selecteditems[0].getData() instanceof String) {
					MessageDialog.openError(remove.getShell(), "", "Cannot remove writer root");
					return;
				}
				if (MessageDialog.openConfirm(remove.getShell(), "Remove step", "Are you sure to remove selected step?")) {
					XsltComponent root = input.getValue();
					selecteditems = xsltComponets.getSelection();
					if (selecteditems.length >0) {
						Set<XsltComponent> toBeRemoved = new HashSet<XsltComponent>();

						for (TreeItem item: selecteditems) {
							Object data = item.getData();
							if (data instanceof XsltComponent) {
								toBeRemoved.add((XsltComponent) data);
							}
						}
						
						XsltComponent[] children = root.getFurtherTransformations().toArray(new XsltComponent[0]);
						for (XsltComponent child : children) {
							if (toBeRemoved.contains(child)) {
								root.removeTransformation(child);
							} else {
								search(child, toBeRemoved);
							}
						}
						
					}
					
					
					viewer.refresh();
				}
			}
		});
		{
			TableWrapData td = new TableWrapData(TableWrapData.FILL, TableWrapData.TOP);
			remove.setLayoutData(td);
		}
		
		//toolkit.paintBordersFor(s0);
		s0.setClient(client0);

//		if (true) return;
		
		
		
		Section s1 = toolkit.createSection(parent,
				Section.COMPACT |
				Section.TWISTIE | Section.DESCRIPTION|Section.TITLE_BAR);
		s1.marginWidth = 10;
		s1.setText("Transformation test"); //$NON-NLS-1$
//		s1.setDescription("Xslt transformation details"); //$NON-NLS-1$
		{
			TableWrapData td = new TableWrapData(TableWrapData.FILL, TableWrapData.TOP);
			td.grabHorizontal = true;
			td.grabVertical = true;
			s1.setLayoutData(td);
		}
		Composite client = toolkit.createComposite(s1);
		{
			TableWrapLayout layout = new TableWrapLayout();
			layout.topMargin = 0;
			layout.leftMargin = 0;
			layout.rightMargin = 0;
			layout.bottomMargin = 5;

//			GridLayout layout = new GridLayout();
//			layout.marginWidth = layout.marginHeight = 0;
//			layout.numColumns = 1;
			client.setLayout(layout);
		}
		
		{
			// -----------------
			Composite chooser = toolkit.createComposite(client);
			{
				TableWrapData td = new TableWrapData(TableWrapData.FILL, TableWrapData.TOP);
				td.grabHorizontal = true;
				td.grabVertical = true;
				chooser.setLayoutData(td);
			}
			{
				TableWrapLayout layout = new TableWrapLayout();
				layout.topMargin = 0;
				layout.leftMargin = 0;
				layout.rightMargin = 0;
				layout.bottomMargin = 5;
				
//				GridLayout glayout = new GridLayout();
//				glayout.marginWidth = glayout.marginHeight = 0;
				
				layout.numColumns = 3;
				chooser.setLayout(layout);
			}
			{
				Label l = toolkit.createLabel(chooser, "Select the oil file to transform"); //$NON-NLS-1$
				

				TableWrapData data = new TableWrapData(TableWrapData.FILL, TableWrapData.TOP);
				data.colspan = 2;
				l.setLayoutData(data);
				
//				GridData data = new GridData();
//				data.horizontalSpan = 2;
//				l.setLayoutData(data);
			}
			
			{
				final Button b = toolkit.createButton(chooser, "Run", SWT.PUSH);
				
				TableWrapData td = new TableWrapData(TableWrapData.FILL, TableWrapData.TOP);
				td.rowspan = 2;
				b.setLayoutData(td);
				
//				GridData data = new GridData();
//				data.verticalSpan = 2;
//				b.setLayoutData(data);
				
				b.addSelectionListener( new SelectionListener() {
					
					public void widgetSelected(SelectionEvent e) {
						run(e);
					}
				
					public void widgetDefaultSelected(SelectionEvent e) {
						run(e);
					}
					
					protected void run(SelectionEvent e) {
						
						
						if (oilFile.getText().length() ==0) {
							MessageDialog.openError(b.getShell(), "Select an oil file", 
									"Please, select an oil file to analize, either using the browse  button or writing directly the workspace path of the oil file.");
							return;
						}
						
						
						final IFile f = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(oilFile.getText()));
						if (f == null || !f.exists() || !f.isAccessible()) {
							MessageDialog.openError(b.getShell(), "Oil file", 
									"The specified oil file doesn't exist or cannot be read.");
							return;
						}
						
						WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
							public void execute(IProgressMonitor monitor) {
								monitor.beginTask("Run xslt writer", IProgressMonitor.UNKNOWN);
								try {
									
									
									IVarTree vt = VarTreeUtil.newVarTree();
									OilReaderFactory.getAnOilReader().load(f.getContents(), vt, f.getName(), f.getProjectRelativePath().toString());
									
									DebugErikaEnterpriseXsltWriter writer = new DebugErikaEnterpriseXsltWriter("", vt);
									writer.setTransformation(input.getValue());
									history = (HistoryXsltDebugger) writer.getDebugger();
									//IOilWriterBuffer[] buffers = 
										writer.write(vt);
									
									
									//inputText.setText(result.toString(), false, false);
									//text.pack();
		
									updateTexts();
									forceRefresh();
		
								} catch (Throwable ex) {
									StringBuffer buff = new StringBuffer();
								
									for( ; ex != null; ex = ex.getCause()) {
										buff.append(ex.getMessage() + "\n\n");
									}
										
									inputText.setText(buff.toString(), false, false);
								}
							}
						};
						
						try {

							new ProgressMonitorDialog(b.getShell()).run(false, false, operation);

						} catch (Exception ex) {
							RtdruidLog.log(ex);
						}

					}
				});

			}
			
			{
				oilFile = toolkit.createText(chooser, "");
				TableWrapData td = new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP);
				td.grabHorizontal = true;
				oilFile.setLayoutData(td);

//				oilFile.setLayoutData(new GridData(GridData.FILL | GridData.GRAB_HORIZONTAL));
			}
			{
				final Button b = toolkit.createButton(chooser, "Browse", SWT.PUSH);
				
				//GridData data = new GridData();
				TableWrapData data = new TableWrapData(TableWrapData.FILL, TableWrapData.TOP);
				b.setLayoutData(data);
				
				b.addSelectionListener( new SelectionListener() {
				
					public void widgetSelected(SelectionEvent e) {
						run(e);
					}
				
					public void widgetDefaultSelected(SelectionEvent e) {
						run(e);
					}
					
					protected void run(SelectionEvent e) {
						// LOAD FROM RESOURCE (inside workspace)
						ResourceSelectionDialog dialog = new ResourceSelectionDialog(
								b.getShell(), ResourcesPlugin.getWorkspace()
										.getRoot(), "Select an existing xsl file");
						// dialog.setInitialSelections(null);
						dialog.open();
						Object[] results = dialog.getResult();
						if (results == null) {
							return;
						}
						for (int i = 0; i < results.length; i++) {
							if (results[i] instanceof IFile) {
								String ext = ((IFile) results[i])
										.getFullPath().getFileExtension();
								if ("oil".equalsIgnoreCase(ext)) {
									oilFile.setText(((IFile) results[i])
											.getFullPath().toOSString());
									oilFile.setData(results[i]);
								}
							}
						}

					}
				});
			}
		}
		
		
		
		{
			// -----------------
			Composite writer = toolkit.createComposite(client);
			{
				TableWrapLayout layout = new TableWrapLayout();
				layout.topMargin = 0;
				layout.leftMargin = 0;
				layout.rightMargin = 0;
				layout.bottomMargin = 5;


//				GridLayout glayout = new GridLayout();
//				glayout.marginWidth = glayout.marginHeight = 0;
				
				layout.horizontalSpacing = 3;
				layout.verticalSpacing = 5;
				layout.numColumns = 2;
				writer.setLayout(layout);
			}

			{
				Label l = toolkit.createLabel(writer, "Input"); //$NON-NLS-1$
				//GridData data = new GridData();
				TableWrapData data = new TableWrapData(TableWrapData.FILL, TableWrapData.TOP);
				l.setLayoutData(data);
			}
		
			inputText = toolkit.createFormText(writer, true);
			inputText.setWhitespaceNormalized(false);
			inputText.setParagraphsSeparated(false);
			
			
			inputText.setText(getText(), false, false);
			{
	//			td = new TableWrapData(TableWrapData.FILL, TableWrapData.TOP);
	//			td.grabHorizontal = true;
				
				TableWrapData data = new TableWrapData(TableWrapData.FILL, TableWrapData.TOP);
				inputText.setLayoutData(data);
			}
			
			

			{
				Label l = toolkit.createLabel(writer, "Output"); //$NON-NLS-1$
//				GridData data = new GridData();
				TableWrapData data = new TableWrapData(TableWrapData.FILL, TableWrapData.TOP);
				l.setLayoutData(data);
			}
		
			outputText = toolkit.createFormText(writer, true);
			outputText.setWhitespaceNormalized(false);
			outputText.setParagraphsSeparated(false);
			
			
			outputText.setText(getText(), false, false);
			{
				TableWrapData data = new TableWrapData(TableWrapData.FILL, TableWrapData.TOP);
				data.grabHorizontal = true;
				outputText.setLayoutData(data);
			}
		}
		
		toolkit.paintBordersFor(s1);
		s1.setClient(client);
	
	}
//	private void createSpacer(FormToolkit toolkit, Composite parent, int span) {
//		Label spacer = toolkit.createLabel(parent, ""); //$NON-NLS-1$
//		GridData gd = new GridData();
//		gd.horizontalSpan = span;
//		spacer.setLayoutData(gd);
//	}
	
	private String getText() {
		return 
"		StringBuffer buff = new StringBuffer();\n" +
"		if (input != null) {\n" +
"			if (input instanceof AXsltWriterTransgormation) {\n" +
"				InputStream data = new BufferedInputStream(((AXsltWriterTransgormation) input).getTransformation());\n" +
"				try {\n" +
"					int c;\n" +
"					while ((c=data.read()) >-1) {\n" +
"						buff.append((char)c); \n" +
"					}\n" +
"				} catch (IOException e) {\n" +
"					RtdruidLog.showDebug(e);\n" +
"				}\n" +
"			} else {\n" +
"				buff.append(\"Text not available\");\n" +
"			}\n" +
"		}\n" +
"		return buff.toString();\n";
//		return "";
	}
	
	private void update() {
		if (viewer != null) {
			viewer.setInput(input);
//			viewer.refresh();
		}
		
		updateTexts();
	}
	
	private void updateTexts() {

		String inputstr = "";
		String outputstr = "";
		
		
		{
			XsltComponent selected = null;
			HistoryXsltDebugger.IntermediateOutput step = null;
			if (xsltComponets != null) {
				TreeItem[] selecteditems = xsltComponets.getSelection();
				if (selecteditems.length == 1){
					Object data = selecteditems[0].getData();
					if (data instanceof XsltComponent) {
						selected = (XsltComponent) data;
					}
				}
			}

			if (selected != null) {
				Map<XsltComponent, IntermediateOutput> m = history == null ? null : history.getIntermediateOutputs();
				step = selected == null || m == null || !m.containsKey(selected) ?
						null : m.get(selected);
				
				inputstr = step == null ? "" : step.getInput();
				outputstr = step == null ? "" : step.getOutput();
			} else {
				IOilWriterBuffer[] buffers = history == null ? null : history.getOutputs();
				if (history != null && buffers != null) {
					StringBuffer result = new StringBuffer();
					for (IOilWriterBuffer buf : buffers) {
						result.append(buf.toString() + "\n\n");
					}

					outputstr = result.toString();
				}
			}
		
		}
		
		if (inputText != null) {
			inputText.setWhitespaceNormalized(false);
			
			inputText.setText(inputstr, false, false); //$NON-NLS-1$
		}
		if (outputText != null) {
			outputText.setWhitespaceNormalized(false);
			
			outputText.setText(outputstr, false, false); //$NON-NLS-1$
		}
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#inputChanged(org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@SuppressWarnings("unchecked")
	public void selectionChanged(IFormPart part, ISelection selection) {
		
		IStructuredSelection ssel = (IStructuredSelection)selection;
		if (ssel.size()==1) {
			Map.Entry tmp = (Map.Entry)ssel.getFirstElement();
			if (input == tmp) {
				return;
			}
			
			history = null;
			input = tmp;
		}
		else {
			input = null;
			history = null;
		}
		update();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#commit()
	 */
	public void commit(boolean onSave) {
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#setFocus()
	 */
	public void setFocus() {
		inputText.setFocus();
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#dispose()
	 */
	public void dispose() {
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#isDirty()
	 */
	public boolean isDirty() {
		return false;
	}
	public boolean isStale() {
		return false;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.IDetailsPage#refresh()
	 */
	public void refresh() {
		update();
	}
	public boolean setFormInput(Object input) {
		return false;
	}

	
	protected void forceRefresh() {
		// force refresh

		Composite c = mainComposite;
		c= c.getParent().getParent();
//							
		Point p = c.getSize();
		if (p.y >1) {
			p.y = p.y -1;
		}
//		c.pack();
		c.setSize(p);
		
		c.layout(new Composite[] {inputText});
		c.redraw();
	}
	
	// -----------------------------------------
	
	
	class XsltWriterExecutionLog {
		
		
		
		
	}
}
