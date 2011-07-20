package com.eu.evidence.rtdruid.modules.oil.ui.views;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IDetailsPageProvider;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.ManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.ViewPart;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.IModelListener;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.IXsltWriterTransformation;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.XsltComponent;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.XsltWriterTransfFactory;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.XsltWriterTransfFactory.AXsltWriterTransgormation;

/**
 * This class show all result of schedulability analysis
 * 
 * @author Nicola Serreli
 */

public class RegistredXsltStepsView extends ViewPart {

	private ScrolledForm form;
	private ScrolledPropertiesBlock block;
	
	protected TableViewer viewer;

	/**
	 * The constructor.
	 */
	public RegistredXsltStepsView() {
		block = new ScrolledPropertiesBlock();
	}

	public void createPartControl(Composite parent) {

		ManagedForm managedForm = new ManagedForm(parent);
		form = managedForm.getForm();
		//FormToolkit toolkit = managedForm.getToolkit();
		form.setText("Available xslt transformations for code generation"); //$NON-NLS-1$
//		form.setBackgroundImage(FormArticlePlugin.getDefault().getImage(
//				FormArticlePlugin.IMG_FORM_BG));
		block.createContent(managedForm);
	}

	
	/**
	 * Passing the focus request to the form.
	 */
	public void setFocus() {
		form.setFocus();
	}

	/**
	 * Disposes the toolkit
	 */
	public void dispose() {
		super.dispose();
	}

	
	
	/**
	 *
	 */
	class ScrolledPropertiesBlock extends MasterDetailsBlock {
		
		
		IModelListener listener = new IModelListener(){
			
			public void modelChanged(IXsltWriterTransformation[] objects, String type,
					String property) {
				
				PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {

					public void run() {
						try {
							viewer.refresh();
						} catch (Throwable e) {
							RtdruidLog.log(e);
						}
					}
				});

				
			}
		};
		
		
		//private FormPage page;
		public ScrolledPropertiesBlock() {
		}
		/**
		 * @param id
		 * @param title
		 */
		class MasterContentProvider implements IStructuredContentProvider {
			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof XsltWriterTransfFactory) {
					return XsltWriterTransfFactory.getAll();
					
				} else if (inputElement instanceof String ) {
//					SimpleFormEditorInput input = (SimpleFormEditorInput) page
//							.getEditor().getEditorInput();
					return XsltWriterTransfFactory.getAllId();
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
				if (obj instanceof IXsltWriterTransformation) {
					return ((IXsltWriterTransformation) obj).getId();
				}
				return obj.toString();
			}
			public Image getColumnImage(Object obj, int index) {
				if (obj instanceof XsltWriterTransfFactory.AXsltWriterTransgormation) {
					return PlatformUI.getWorkbench().getSharedImages().getImage(
							ISharedImages.IMG_OBJ_ELEMENT);
				}
				if (obj instanceof IXsltWriterTransformation) {
					return PlatformUI.getWorkbench().getSharedImages().getImage(
							ISharedImages.IMG_OBJ_FILE);
				}
				return null;
			}
		}
		protected void createMasterPart(final IManagedForm managedForm,
				Composite parent) {
			//final ScrolledForm form = managedForm.getForm();
			FormToolkit toolkit = managedForm.getToolkit();
			Section section = toolkit.createSection(parent, Section.DESCRIPTION|Section.TITLE_BAR);
			section.setText("ScrolledPropertiesBlock.sname"); //$NON-NLS-1$
			section
					.setDescription("ScrolledPropertiesBlock.sdesc"); //$NON-NLS-1$
			section.marginWidth = 10;
			section.marginHeight = 5;
			
			Composite client = toolkit.createComposite(section, SWT.WRAP);
			GridLayout layout = new GridLayout();
			layout.numColumns = 2;
			layout.marginWidth = 2;
			layout.marginHeight = 2;
			client.setLayout(layout);
			Table t = toolkit.createTable(client, SWT.NULL);
			GridData gd = new GridData(GridData.FILL_BOTH);
			gd.heightHint = 20;
			gd.widthHint = 100;
			t.setLayoutData(gd);
			toolkit.paintBordersFor(client);
			
			final Button b = toolkit.createButton(client, "add", SWT.PUSH); //$NON-NLS-1$
			b.addSelectionListener(new SelectionListener() {
			
				public void widgetSelected(SelectionEvent e) {
					doJob(e);
				}
			
				public void widgetDefaultSelected(SelectionEvent e) {
					doJob(e);
				}
				void doJob(SelectionEvent e) {
					try {
						WizardDialog dialog = new WizardDialog(b.getShell(), new AddXsltFileWizard());
						dialog.open();
					} catch (Throwable ex) {
						RtdruidLog.log(ex);
					}
				}
			});
			gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
			b.setLayoutData(gd);
			section.setClient(client);
			final SectionPart spart = new SectionPart(section);
			managedForm.addPart(spart);
			viewer = new TableViewer(t);
			viewer.addSelectionChangedListener(new ISelectionChangedListener() {
				public void selectionChanged(SelectionChangedEvent event) {
					managedForm.fireSelectionChanged(spart, event.getSelection());
				}
			});
			viewer.setContentProvider(new MasterContentProvider());
			viewer.setLabelProvider(new MasterLabelProvider());
			viewer.setInput(XsltWriterTransfFactory.getDefaultInstance());
			XsltWriterTransfFactory.getDefaultInstance().addModelListener(listener);
		}
		protected void createToolBarActions(IManagedForm managedForm) {
			final ScrolledForm form = managedForm.getForm();
			Action haction = new Action("hor", Action.AS_RADIO_BUTTON) { //$NON-NLS-1$
				public void run() {
					sashForm.setOrientation(SWT.HORIZONTAL);
					form.reflow(true);
				}
			};
			haction.setChecked(true);
			haction.setToolTipText("hor"); //$NON-NLS-1$
//			haction.setImageDescriptor(FormArticlePlugin.getDefault()
//					.getImageRegistry()
//					.getDescriptor(FormArticlePlugin.IMG_HORIZONTAL));
			Action vaction = new Action("ver", Action.AS_RADIO_BUTTON) { //$NON-NLS-1$
				public void run() {
					sashForm.setOrientation(SWT.VERTICAL);
					form.reflow(true);
				}
			};
			vaction.setChecked(false);
			vaction.setToolTipText("ver"); //$NON-NLS-1$
//			vaction.setImageDescriptor(FormArticlePlugin.getDefault()
//					.getImageRegistry().getDescriptor(FormArticlePlugin.IMG_VERTICAL));
			form.getToolBarManager().add(haction);
			form.getToolBarManager().add(vaction);
		}
		protected void registerPages(DetailsPart detailsPart) {
			detailsPart.setPageProvider(new IDetailsPageProvider() {
			
				public Object getPageKey(Object object) {
					if (object instanceof AXsltWriterTransgormation) {
						return AXsltWriterTransgormation.class;
					}
					if (object instanceof IXsltWriterTransformation) {
						return IXsltWriterTransformation.class;
					}
					return object.getClass();
				}
			
				public IDetailsPage getPage(Object key) {
					if (key == AXsltWriterTransgormation.class ) {
						return new XsltStepPage();
					}
					if (key == IXsltWriterTransformation.class ) {
						return new XsltStepPage();
					}
					return null;
				}
			});
			detailsPart.registerPage(AXsltWriterTransgormation.class, new XsltStepPage());
			detailsPart.registerPage(IXsltWriterTransformation.class, new XsltStepPage());
		}
		
		public void dispose(){
			XsltWriterTransfFactory.getDefaultInstance().removeModelListener(listener);
		}
	}



	public void setSelection(Object sel) {
		if (viewer == null) {
			return;
		}
		if (sel instanceof IXsltWriterTransformation) {
			TableItem[] items = viewer.getTable().getItems();
			for (int i=0; i<items.length; i++) {
				TableItem item = items[i];
				if (item.getData() == sel) {
					viewer.getTable().select(i);
				}
			}
		} else if (sel instanceof XsltComponent) {
			String value = ((XsltComponent) sel).getLocalTransformationId();
			if (value == null) {
				return;
			}
			TableItem[] items = viewer.getTable().getItems();
			
			for (int i=0; i<items.length; i++) {
				TableItem item = items[i];
				if (value.equals(item.getText())) {
					viewer.setSelection(new StructuredSelection(item.getData()));
					//viewer.getTable().select(i);
//					viewer.getTable().setSelection(i);
//					ISelection abc = viewer.getSelection();
					
					
					return;
				}
			}
		}

	}
}


