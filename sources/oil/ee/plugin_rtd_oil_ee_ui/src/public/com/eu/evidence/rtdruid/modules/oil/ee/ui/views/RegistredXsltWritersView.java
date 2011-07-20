package com.eu.evidence.rtdruid.modules.oil.ee.ui.views;

import java.util.Map;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
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

import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.EESectionWritersFactory;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.XsltComponent;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.XsltMainComponent;


/**
 * This class show all result of schedulability analysis
 * 
 * @author Nicola Serreli
 */

public class RegistredXsltWritersView extends ViewPart {
	
	private static final String STANDARD_ITEM_KEY = "Standard_item_key";
	

	private ScrolledForm form;
	private ScrolledPropertiesBlock block;

	/**
	 * The constructor.
	 */
	public RegistredXsltWritersView() {
		block = new ScrolledPropertiesBlock();
	}

	public void createPartControl(Composite parent) {

		ManagedForm managedForm = new ManagedForm(parent);
		form = managedForm.getForm();
		//FormToolkit toolkit = managedForm.getToolkit();
		form.setText("Available xslt writers for code generation"); //$NON-NLS-1$
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

	
	
	
	
	// -------------------------------------------------------
	
	
	
	/**
	 *
	 */
	class ScrolledPropertiesBlock extends MasterDetailsBlock {
		
		protected TableViewer viewer;
		
		EESectionWritersFactory.IModelListener listener = new EESectionWritersFactory.IModelListener() {
		
			public void modelChanged(Map<String, XsltMainComponent> objects, String type,
					String property) {
				
				PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {

					public void run() {
						viewer.refresh();
					}
				});

			}
		};
		
		
		//private FormPage page;
		public ScrolledPropertiesBlock() {
		}


		class MasterContentProvider implements IStructuredContentProvider {
			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof EESectionWritersFactory) {
					return EESectionWritersFactory.getXsltWriters().entrySet().toArray();
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
				if (obj instanceof Map.Entry) { // <String, XsltComponent>
					Map.Entry entry = (Map.Entry) obj;
					if (entry.getKey() instanceof String &&
							entry.getValue() instanceof XsltComponent) {
						return (String) entry.getKey();
					}
					
					return "" + entry.getKey();
				}
				return obj.toString();
			}
			public Image getColumnImage(Object obj, int index) {
				return null;
			}
		}
		protected void createMasterPart(final IManagedForm managedForm,
				Composite parent) {
			//final ScrolledForm form = managedForm.getForm();
			FormToolkit toolkit = managedForm.getToolkit();
			Section section = toolkit.createSection(parent, Section.DESCRIPTION|Section.TITLE_BAR);
			section.setText("All Xslt writer"); //$NON-NLS-1$
//			section
//					.setDescription("ScrolledPropertiesBlock.sdesc"); //$NON-NLS-1$
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
					WizardDialog dialog = new WizardDialog(b.getShell(), new AddXsltWriterWizard());
					dialog.open();
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
			viewer.setInput(EESectionWritersFactory.getDefaultInstance());
			EESectionWritersFactory.getDefaultInstance().addModelListener(listener);
		}
		protected void createToolBarActions(IManagedForm managedForm) {
//			final ScrolledForm form = managedForm.getForm();
//			Action haction = new Action("hor", Action.AS_RADIO_BUTTON) { //$NON-NLS-1$
//				public void run() {
//					sashForm.setOrientation(SWT.HORIZONTAL);
//					form.reflow(true);
//				}
//			};
//			haction.setChecked(true);
//			haction.setToolTipText("hor"); //$NON-NLS-1$
////			haction.setImageDescriptor(FormArticlePlugin.getDefault()
////					.getImageRegistry()
////					.getDescriptor(FormArticlePlugin.IMG_HORIZONTAL));
//			Action vaction = new Action("ver", Action.AS_RADIO_BUTTON) { //$NON-NLS-1$
//				public void run() {
//					sashForm.setOrientation(SWT.VERTICAL);
//					form.reflow(true);
//				}
//			};
//			vaction.setChecked(false);
//			vaction.setToolTipText("ver"); //$NON-NLS-1$
////			vaction.setImageDescriptor(FormArticlePlugin.getDefault()
////					.getImageRegistry().getDescriptor(FormArticlePlugin.IMG_VERTICAL));
//			form.getToolBarManager().add(haction);
//			form.getToolBarManager().add(vaction);
		}
		protected void registerPages(DetailsPart detailsPart) {
			detailsPart.setPageProvider(new IDetailsPageProvider() {
			
				public Object getPageKey(Object object) {
					if (object instanceof Map.Entry) { // <String, XsltComponent>
						Map.Entry entry = (Map.Entry) object;
						if (entry.getKey() instanceof String &&
								entry.getValue() instanceof XsltComponent) {
							return STANDARD_ITEM_KEY;
						}
					}
					return object.getClass();
				}
			
				public IDetailsPage getPage(Object key) {
					if (STANDARD_ITEM_KEY.equals(key)) {
						return new XsltWriterPage();
					}
					return null;
				}
			});
			detailsPart.registerPage(STANDARD_ITEM_KEY, new XsltWriterPage());
		}
		
		public void dispose(){
			EESectionWritersFactory.getDefaultInstance().removeModelListener(listener);
		}
	}
}


