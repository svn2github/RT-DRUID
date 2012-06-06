/*
 * Created on 22-giu-2005
 *
 * $Id: rtdOilProjectWizard.java,v 1.5 2008/04/18 11:06:50 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.cdt.ui.project;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.cdt.managedbuilder.ui.wizards.STDWizardHandler;
import org.eclipse.cdt.ui.CUIPlugin;
import org.eclipse.cdt.ui.wizards.CDTMainWizardPage;
import org.eclipse.cdt.ui.wizards.CProjectWizard;
import org.eclipse.cdt.ui.wizards.EntryDescriptor;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ContainerGenerator;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import com.eu.evidence.rtdruid.Rtd_corePlugin;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.project.templates.ExampleTemplate;
import com.eu.evidence.rtdruid.internal.modules.project.templates.SearchTemplates;
import com.eu.evidence.rtdruid.internal.modules.project.templates.XmlToPlainText;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.Rtd_oil_cdt_Plugin;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.builder.OilBuilder;
import com.eu.evidence.rtdruid.modules.oil.cdt.ui.project.templates.ConfigFileTemplate;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;

/**
 * A little wizard to build a new Nios C/C++ Project
 * 
 * @author Nicola Serreli
 */
public class RTDOilProjectWizardNew extends CProjectWizard {
	
    private static final String DEFAULT_CONF_FILE = "conf.oil";
    
    private static final String DEFAULT_TITLE = Rtd_oil_cdt_Plugin
			.getString("rtdOilProjectWizard.name");
    private static final String DEFAULT_DESCRIPTION = Rtd_oil_cdt_Plugin
	.getString("rtdOilProjectWizard.description");

    private class RTDNiosWizardPage extends WizardPage {

        /**
         * Contains the Config File Name
         */
        private String configFile = DEFAULT_CONF_FILE;
        private Text textConfigFile;
        /** 
         * Contains a string that describes an error inside the Config File name, 
         * or null if it's all ok.
         */
        private String configFileError = null;
        
        /** 
         * Contains a string that describes an error inside the Template choiche, 
         * or null if it's all ok.
         */
        private String configTemplateError = null;

        /** 
         * Contains a string that describes an error inside the Template choiche, 
         * or null if it's all ok.
         */
        private boolean useATemplate;

        /**
		 * The list of availables templates (NOTE : it's computed every time
		 * that this class is created)
		 */
        private final ExampleTemplate[] templates;
        
        /**
         * The current selection
         */
        private ExampleTemplate template;
        
        
        /**
         * 
         */
        public RTDNiosWizardPage() {
            super("RT-Druid");
            
            // fill the list of templates
            templates = SearchTemplates.getConfigTemplates();
        }
        
        /* (non-Javadoc)
         * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
         */
        public void createControl(Composite parent) {
            
            // default description
            //setDescription("Choose the name of configuration file");
            //setTitle("Configuration file");
			setTitle(DEFAULT_TITLE);
			setDescription(DEFAULT_DESCRIPTION);

            /*
             * Prepare all compontens
             */
    		Composite current = new Composite(parent, SWT.NONE);
    		{
        		GridLayout layout = new GridLayout();
	    		layout.numColumns = 1;
	    		layout.makeColumnsEqualWidth = true;
		        layout.marginHeight = 10;
		        layout.marginWidth = 10;
	    		layout.horizontalSpacing = 5;
	    		layout.verticalSpacing = 5;
	    		current.setLayout(layout);
    		}
            
			createExampleControl(current);
//			createOilFileControl(current);
    		
    		setControl(current);
        }
        
        /** This method prepares the box that contains the name of oil file */
        protected void createOilFileControl(Composite parent) {
    		
        	/*
             * Prepare all compontens
             */
    		Composite current = new Composite(parent, SWT.NONE);
    		{
        		GridLayout layout = new GridLayout();
	    		layout.numColumns = 1;
	    		layout.makeColumnsEqualWidth = true;
		        layout.marginHeight = 10;
		        layout.marginWidth = 10;
	    		layout.horizontalSpacing = 5;
	    		layout.verticalSpacing = 5;
	    		current.setLayout(layout);
	    		current.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    		}
    		
            
    		// Label
    		Label label = new Label(current, SWT.LEFT);
			{
	    		label.setText("Configuration file");
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalSpan = 2;
	    		label.setLayoutData(data);
			}

			// Text
    		textConfigFile = new Text(current, SWT.SINGLE | SWT.BORDER);
    		{
    			textConfigFile.setText(DEFAULT_CONF_FILE);
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalSpan = 2;
				textConfigFile.setLayoutData(data);
	    		
				textConfigFile.addModifyListener(new ModifyListener() {
	                public void modifyText(ModifyEvent e) {
	                    if (e.getSource() == textConfigFile) {
	                        
	                    	/*
	                    	 * Check if specified text is a valid filename 
	                    	 */
	                    	configFileError = CommonUtils.checkConfigFileName(textConfigFile.getText());
	                    	if (configFileError == null) {
	                    		configFile = textConfigFile.getText();
	                    	}
	                        // update the status of this page 
	                        enableOk();
	                    }
	                }
	            });
    		}        	
    		
        }

        /** This code prepares the widgets used to show availables Examples */
        protected void createExampleControl(Composite parent) {
    		
        	final Tree exampleTree;
        	final Browser exampleDescr__browser;
        	final Text exampleDescr__text;
        	final FormText exampleDescr__form;
        	final Object exampleDescr;
        	Object exampleDescr_tmp;
        	final Button enableExamples;
        	final Color GRAY_COLOR = new Color(parent.getDisplay(), 204, 204, 204);

        	final String txt_error = "Select a template";
        	
        	{
        	/*
             * Prepare all compontens
             */
    		Composite current = new Composite(parent, SWT.NONE);
    		{
        		GridLayout layout = new GridLayout();
	    		layout.numColumns = 2;
	    		layout.makeColumnsEqualWidth = false;
	    		current.setLayout(layout);
	    		current.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    		}
    		
    		// Check box
    		enableExamples = new Button(current, SWT.CHECK);
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.BEGINNING;
				data.horizontalSpan = 1;
				enableExamples.setLayoutData(data);
				useATemplate = enableExamples.getSelection();
			}

    		// Label
    		Label label = new Label(current, SWT.LEFT);
			{
	    		label.setText("Create a project using one of these templates");
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalSpan = 1;
	    		label.setLayoutData(data);
			}
        	}
			/*
             * Prepare all compontens
             */
    		Composite current = new Composite(parent, SWT.NONE);
    		{
        		GridLayout layout = new GridLayout();
	    		layout.numColumns = 2;
	    		layout.makeColumnsEqualWidth = true;
		        layout.marginHeight = 10;
		        layout.marginWidth = 10;
	    		layout.horizontalSpacing = 5;
	    		layout.verticalSpacing = 5;
	    		current.setLayout(layout);
	    		current.setLayoutData(new GridData(GridData.FILL_BOTH));
    		}
    		
    		

			exampleTree = new Tree(current, SWT.SINGLE | SWT.BORDER);
			{
				HashMap categories = new HashMap();
				// fill
				for (int i=0; i<templates.length; i++) {
					
					TreeItem treeItem;
					String category = templates[i].getCategory();
					if (category == null || category.length() == 0) {
						treeItem = new TreeItem(exampleTree, SWT.DEFAULT);
					} else {
						
						// build the "treeItem path"
						TreeItem parentItem = createATreePath(categories, category, exampleTree);
						treeItem = new TreeItem(parentItem, SWT.DEFAULT);
					}

					treeItem.setText(templates[i].getTitle());
					treeItem.setData(templates[i]);
				}
				exampleTree.setEnabled(false);
				exampleTree.setBackground(GRAY_COLOR);

				// set size and place
				exampleTree.setLayoutData(new GridData(GridData.FILL_BOTH));
			}
		
			{
				//FormText exampleDescr = new FormText(current, SWT.DEFAULT);
				try { // first try.... somethimes doesn't work under linux for problems with mozilla extensions 
					exampleDescr_tmp = exampleDescr__browser = new Browser(current, SWT.NONE);
					{
						// set size and place
						exampleDescr__browser.setLayoutData(new GridData(GridData.FILL_BOTH));
			    		
						exampleDescr__browser.setEnabled(false);
						exampleDescr__browser.setText("");
					}
				} catch (Throwable e) {
					// ignore it
					exampleDescr_tmp = null;
				}
				
//				try { // first try.... somethimes doesn't work under linux for problems with mozilla extensions 
//					exampleDescr_tmp = exampleDescr__form = new FormText(current, SWT.NONE);
//					{
//						// set size and place
//						exampleDescr__form.setLayoutData(new GridData(GridData.FILL_BOTH));
//			    		
//						exampleDescr__form.setEnabled(false);
//						exampleDescr__form.setText("",false,false);
//					}
//				} catch (Throwable e) {
//					// ignore it
//					exampleDescr_tmp = null;
//				}
				
				if (exampleDescr_tmp == null) {
					exampleDescr_tmp = exampleDescr__text = new Text(current, SWT.MULTI | SWT.WRAP | SWT.READ_ONLY | SWT.LEFT);
					{
						// set size and place
						exampleDescr__text.setLayoutData(new GridData(GridData.FILL_BOTH));
			    		
						exampleDescr__text.setEnabled(false);
						exampleDescr__text.setText("");
					}
				}
	
				exampleDescr = exampleDescr_tmp;
	        }
			

			// add SelectionListener
			enableExamples.addSelectionListener(new SelectionListener() {
				public void widgetSelected(SelectionEvent e) {
					work(e);
				}

				public void widgetDefaultSelected(SelectionEvent e) {
					work(e);
				}
				protected void work(SelectionEvent e) {					
					
					Color color = enableExamples.getSelection() ?
							  null // default color							
							: GRAY_COLOR ;
					
					useATemplate = enableExamples.getSelection();

					if (exampleDescr instanceof  Browser) {
						((Browser) exampleDescr).setEnabled(useATemplate);
						((Browser) exampleDescr).setBackground(color);
					} else if (exampleDescr instanceof  FormText) {
						((FormText) exampleDescr).setEnabled(useATemplate);
						((FormText) exampleDescr).setBackground(color);
					} else if (exampleDescr instanceof  Text) {
						((Text) exampleDescr).setEnabled(useATemplate);
						((Text) exampleDescr).setBackground(color);
					}
					exampleTree.setEnabled(useATemplate);
					exampleTree.setBackground(color);
					
					// enable/disable template
					template = null;
					if (useATemplate) {
						TreeItem[] items = exampleTree.getSelection();
						if (items.length>0) {
							Object o = items[0].getData();
							if (o != null && o instanceof ExampleTemplate) {
								template = (ExampleTemplate) o; 
							}
						}
//						configTemplateError = null;
//					} else {
//						configTemplateError = "Select a template";
//						template = null;
					}

					// disable "the choice of config name"
					if (textConfigFile != null) {
						configFile = useATemplate ? DEFAULT_CONF_FILE : textConfigFile.getText();
						textConfigFile.setEnabled( !useATemplate );
						textConfigFile.setEditable( !useATemplate );
					}
					
					enableOk();
					
				}
			});

			exampleTree.addSelectionListener(new SelectionListener() {
				XmlToPlainText converter = new XmlToPlainText();
				
				public void widgetSelected(SelectionEvent e) {
					work(e);
				}

				public void widgetDefaultSelected(SelectionEvent e) {
					work(e);
				}
				protected void work(SelectionEvent e) {
					String txt = "";
					TreeItem[] items = exampleTree.getSelection();
					template = null;
					if (items.length>0) {
						Object o = items[0].getData();
						if (o != null && o instanceof ExampleTemplate) {
							template = (ExampleTemplate) o;
							txt = template.getLongDescr();
//							configTemplateError = null;
//						} else {
//							configTemplateError = "Select a template";
						}
					}
					
					if (exampleDescr instanceof  Browser) {
						((Browser) exampleDescr).setText(txt);
					} else if (exampleDescr instanceof  FormText) {
						try {
							((FormText) exampleDescr).setText(txt, true, true);
						} catch (Exception ex) {
							((FormText) exampleDescr).setText(converter.convert(txt), false, false);
						}
					} else if (exampleDescr instanceof  Text) {
						txt = converter.convert(txt);
						((Text) exampleDescr).setText(txt);
					}
					
					enableOk();
				}
			});
			
        }

        /**
         * This method checks that a path exist
         */
        protected TreeItem createATreePath(HashMap categories, String path, Tree tree) {
        	TreeItem answer = (TreeItem) categories.get(path);
        	
        	if (answer == null) {
    
        		// build the parent's path
        		String base = ExampleTemplate.removeLastElement(path);
        		if (base == null) { // this node is the "root"
            		answer = new TreeItem(tree, SWT.DEFAULT);
            		answer.setText(path);
            		categories.put(path, answer);
            		
        			return answer;
        		} // else
        		
        	
        		// check and get the parent element
        		TreeItem parent = createATreePath(categories, base, tree);

        		answer = new TreeItem(parent, SWT.DEFAULT);
        		answer.setText(ExampleTemplate.lastElement(path));
        		categories.put(path, answer);
        	}
        	
        	return answer;
        }

        /**
         * Check all possible errors and then  enable next button if it's all ok
         * or disable it and print an error message if there is at least one error   
         */
		protected void enableOk() {
			String messg = null;
			
			/* 
			 * check all strings ...
			 */
			if (useATemplate) {
				// .. template ..
			
				if (template == null) {
					messg = "Select a template";
				}
				
			} else {
				// ... config ...
				if (configFileError != null) {
				    messg = configFileError;
				}
			}
	        
			/*
			 * Update "next" button and "Error message"
			 */
			
			// enable next only if it's all ok
        	setPageComplete(messg == null);
        	
	        // print error message 
	        setErrorMessage(messg);
		}
		
		/**
		 * @return Returns the template.
		 */
		public ExampleTemplate getTemplate() {
			return useATemplate ? template : null;
		}
    }
    
    
    RTDNiosWizardPage niosWizardPage = new RTDNiosWizardPage();
    
//    
//    @Override
//    public IWizardPage getStartingPage() {
////    	// TODO Auto-generated method stub
////    	if (fMainPage != null) {
////    		return fMainPage;
////    	}
//    	return super.getStartingPage();
//    }
//    
//    @Override
//    public IWizardPage getNextPage(IWizardPage page) {
//    	// TODO Auto-generated method stub
//    	return super.getNextPage(page);
//    }
//    
//    @Override
//    public IWizardPage getPage(String name) {
//    	// TODO Auto-generated method stub
//    	return super.getPage(name);
//    }
    
    
	public void addPages() {

		//super.addPages();
		
		{ // super
			fMainPage= new CDTMainWizardPage(CUIPlugin.getResourceString("CProjectWizard")) {
				
				@SuppressWarnings({ "unchecked", "rawtypes" })
				public List filterItems(List items) {
					List answer = new ArrayList();
					
					for (Iterator iter = items.iterator(); iter.hasNext();) {
						Object o = iter.next();
						if (o instanceof EntryDescriptor) {
							EntryDescriptor entry = (EntryDescriptor) o;
							
							if ((entry.getHandler() instanceof STDWizardHandler)) {
								answer.add(entry);
//								iter.remove();
							}
						}
					}
					return answer;
				};
				
			    /* (non-Javadoc)
			     * Method declared on IWizardPage.
			     * The default behavior is to ask the wizard for the next page.
			     */
			    public IWizardPage getNextPage() {
			        return RTDOilProjectWizardNew.this.getNextPage(this);
			    }

			};
//			fMainPage.setTitle("");
//			fMainPage.setDescription("");
			addPage(fMainPage);
			
		}

		addPage(niosWizardPage);

		

		// change the tilte of CDT's pages
		IWizardPage[] pages = getPages();
		for (int i=0; i<pages.length; i++) {
			pages[i].setTitle(DEFAULT_TITLE);
			pages[i].setDescription(DEFAULT_DESCRIPTION);
		}
		

	}

	/**
	 * 
	 */
	public RTDOilProjectWizardNew() {
		super();
	}

	
	@Override
	public String[] getNatures() {
		String[] parentNature = super.getNatures();
		String[] answer;
		if (parentNature != null && parentNature.length >0) {
			answer = new String[parentNature.length +1];
			System.arraycopy(parentNature, 0, answer, 0, parentNature.length);
		} else {
			answer = new String[1];
		}
		answer[answer.length -1] = RTDOilProjectNature.NATURE_ID;
		
		return answer;
	}


	@Override
	protected boolean setCreated() throws CoreException {
		boolean answer = super.setCreated(); 
		
		try {
			doRun(null);
		} catch (Throwable e) {
			RtdruidLog.log(e);
			return false;
		}
		return answer;
	}
	
	/**
	 * Complete the wizard 
	 */
	protected void doRun(IProgressMonitor monitor) throws CoreException {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		monitor.beginTask("Prepare a RT-Druid Project", 10); //$NON-NLS-1$
		
		IProject prj = newProject;
		
		//super.doRun(new SubProgressMonitor(monitor, 9));
		// Prepare the project
		if (prj != null) {

		    /* 
			 * Add RT-Druid Nature to the newly created project.
			 */
		    RTDOilProjectNature.addNature(prj, monitor);

			/*
			 * Add the output directory.
			 * 
			 * The first row is better but there is a kind of bug with
			 * "project_name" parameter that is releated to the last selected
			 * resource
			 */
		    RTDOilProjectNature.setCDTOutputFolder(prj, "/" + prj.getName() + "/Debug");
		    RTDOilProjectNature.setCDTWorkFolder(prj, "${ProjName}/Debug");
		    RTDOilProjectNature.setCDTBuildCommand(prj, "${ProjDirPath}/Debug/make_launcher.bat");
//		    RTDOilProjectNature.setCDTBuildCommand(prj, "make_launcher.bat");


		    /* 
		     * add Builder
		     */
		    IProjectDescription desc = prj.getDescription();
		    
		    ICommand command = desc.newCommand();
		    command.setBuilderName(OilBuilder.BUILDER_ID);
		    Map<String, String> attributes = new HashMap<String, String>();
		    attributes.put(OilBuilder.ATTR_CONFIG_FILES, niosWizardPage.configFile);
		    command.setArguments(attributes);
		    RTDOilProjectNature.setBuildSpec(prj, command);
		    
		    /*
		     * create config file's path 
		     */
		    IPath path = new Path(prj.getName()+IPath.SEPARATOR+niosWizardPage.configFile);
		    path = path.removeLastSegments(1);

		    new ContainerGenerator(path).generateContainer(monitor);

		    /*
		     * add the config file
		     */
		    IFile configFile = prj.getFile(niosWizardPage.configFile);
		    configFile.create(ConfigFileTemplate.asStream(ConfigFileTemplate.getDefaultTemplate()), true, monitor);

		    /*
		     * Copy files 
		     */
		    ExampleTemplate template = niosWizardPage.getTemplate();
		    if (template!= null) {
		    	SearchTemplates.CopyExampleFiles copyManager = new SearchTemplates.CopyExampleFiles(template);
		    	try {
		    		copyManager.copyIntoAProject(prj, monitor);
		    	} catch(Exception e) {
		    		Rtd_corePlugin.log(e);
		    		MessageBox mb = new MessageBox(this.getShell(), SWT.ICON_ERROR);
		    		mb.setMessage("Problems during the copy of template files.\n"+e.getMessage());
		    		mb.open();
		    	}
		    }
		    
			// Select the new file resource in the current view.
			//
		    IWorkbench workbench = PlatformUI.getWorkbench();
			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = workbenchWindow.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if (activePart instanceof ISetSelectionTarget) {
				final ISelection targetSelection = new StructuredSelection(configFile);
				getShell().getDisplay().asyncExec
					(new Runnable() {
						 public void run() {
							 ((ISetSelectionTarget)activePart).selectReveal(targetSelection);
						 }
					 });
			}

			// Open an editor on the new file.
			//
			try {
				IEditorDescriptor ied = workbench.getEditorRegistry().getDefaultEditor(configFile.getFullPath().toString());
				if (ied == null) {
					// try to open inside a text editor
					ied = workbench.getEditorRegistry().getDefaultEditor("name.txt");
				}
				if (ied != null) {
					page.openEditor
						(new FileEditorInput(configFile), ied.getId());
				}
			}
			catch (PartInitException exception) {
			    RtdruidLog.log(new RuntimeException("cannot open the Config File", exception));
			}
			catch (Exception exception) {
			    RtdruidLog.log(new RuntimeException("cannot open the Config File", exception));
			}

		}
		monitor.done();
	}

    
}
