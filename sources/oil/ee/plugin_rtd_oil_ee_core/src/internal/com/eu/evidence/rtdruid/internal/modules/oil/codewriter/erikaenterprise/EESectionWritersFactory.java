/*
 * Created on 8-nov-2004
 *
 * $Id: VarTreeRequiredFactories.java,v 1.5 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;


import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.sectionwriter.SectionWriterCommonKernelDefs;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.sectionwriter.SectionWriterMakefile_MP;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.sectionwriter.SectionWriterMakefile_SP;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.sectionwriter.SectionWriterRemoteNotification;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.XsltComponent;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.XsltMainComponent;
import com.eu.evidence.rtdruid.modules.oil.interfaces.ISWCategory;
import com.eu.evidence.rtdruid.modules.oil.interfaces.ISectionWriter;



/**
 * Contains the names of all required adapter factories, that will be loaded
 * (using the method class.forName) each time that is called the method
 * getFactoies
 * 
 * @author Nicola Serreli
 */
public final class EESectionWritersFactory {
	
	protected static class CatComparator implements Comparator<ISectionWriter> {
		public int compare(ISectionWriter o1, ISectionWriter o2) {
			ISWCategory c1 = null;
			ISWCategory c2 = null;
			if (o1!= null && o2 !=null) {
				c1 = o1.getCategory();
				c2 = o2.getCategory();
			}
			
			return
				c1 == null ? 
						(c2 == null ? 0 : -1) : 
						(c2 == null ? 1 :  c1.compareTo(c2));
		}
	}
	
	// UPDRTD dividere i writer in funzione di alcune tipologie (HW, OS, Addons, Dipendenze...)
    
    public static final String PLUGIN_ID = "com.eu.evidence.rtdruid.oil.ee.core";
    public static final String SECTION_WRITER_EXTENSION_POINT = "eeSectionWriter";
    public static final String XSLT_WRITER_EXTENSION_POINT = "eeXsltSectionWriter";
    public static final Boolean mutex = new Boolean(true);

    /** Contains the names of all required adapter factories*/
    private static List<Class<? extends ISectionWriter>> factories = null;
    private static Map<String, XsltMainComponent> xsltWriters = null;

    private static ArrayList<String> disabledIds = new ArrayList<String>();
    
    private static EESectionWritersFactory defaultInstance = new EESectionWritersFactory();
    
    public static EESectionWritersFactory getDefaultInstance() {
    	if (factories == null || xsltWriters == null) {
    		getFactories(null);
    	}
		return defaultInstance;
	}
    
    /*
     * public interface
     */
    /**
     * Add a SectionWriter
	 */
    public void pAddFactory(Class<ISectionWriter> factories) {
    	EESectionWritersFactory.addFactory(factories);
    }
    /**
     * Add a SectionWriter
	 */
    public void pAddFactory(ISectionWriter factories) {
    	EESectionWritersFactory.addFactory(factories);
    }
    /**
     * Reload all extentions
	 */
    public void pReload() {
    	EESectionWritersFactory.reloadExtensions();
    }
    
    
    /* **************************
     * 
     * GET FACTORIES
     *
     * **************************/

    /** Creates a new instances each required factory */
    static public ISectionWriter[] getFactories(ErikaEnterpriseWriter parent) {
    	return getFactories(parent, disabledIds);
    }
    static public ISectionWriter[] getAllFactories(ErikaEnterpriseWriter parent) {
    	return getFactories(parent, new ArrayList<String>());
    }
    static protected synchronized ISectionWriter[] getFactories(ErikaEnterpriseWriter parent, List<String> disabledIds) {
        @SuppressWarnings("unused")
		final int factories = 1; // disable global factories inside this method !!
        List<Class<? extends ISectionWriter>> localFactories;
        
        // get factory list
        synchronized (mutex) {
            localFactories = EESectionWritersFactory.factories;
            if (localFactories == null) {
                reloadExtensions();
                localFactories = EESectionWritersFactory.factories;
            }
        }
        
        ArrayList<ISectionWriter> answer = new ArrayList<ISectionWriter>();
	    for (Iterator<Class<? extends ISectionWriter>> iter = localFactories.iterator(); iter.hasNext(); ) {
	        Class<ISectionWriter> tmpClass = (Class<ISectionWriter>) iter.next();
	        ISectionWriter af = null;
	        try {
	        	Constructor<ISectionWriter> construct = tmpClass.getConstructor(ErikaEnterpriseWriter.class);
	        	if (construct != null) {
	        		af = (ISectionWriter) construct.newInstance(parent);
	        	} else {
	        		construct = tmpClass.getConstructor();

		        	if (construct != null) {
		        		af = (ISectionWriter) construct.newInstance();
		        	}

	        	}
	        	
	        	if (af == null) {
	        		RtdruidLog.log(new RuntimeException("Cannot find a valid constructor for " + tmpClass.getName()));
	        		continue;
	        	}
	        } catch (Exception e) {
	            RtdruidLog.log(e);
	            continue; // next child
	        }
	        if (!disabledIds.contains(af.getId())) {
	        	answer.add(af);
	        }
	    }
	    Set<Map.Entry<String, XsltMainComponent>> xsltws = EESectionWritersFactory.xsltWriters.entrySet();
	    for (Map.Entry<String, XsltMainComponent> value : xsltws) {
	        if (!disabledIds.contains(value.getKey())) {
	        	
	        	ErikaEnterpriseXsltWriter writer = new ErikaEnterpriseXsltWriter(value.getKey(), parent, value.getValue().getCategory());
	        	writer.setTransformation(value.getValue());
	        	answer.add(writer);
	        }
	    }
    	
	    // sort
	    Collections.sort(answer, new CatComparator());
	    
	    
        return (ISectionWriter[]) answer.toArray(new ISectionWriter[answer.size()]);
    }

    /**
     * Add a specific Factory
     */
    static public synchronized void addFactory(Class<ISectionWriter> element) {
        List<Class<? extends ISectionWriter>> localFactories;
    	
        synchronized (mutex) {
            localFactories = EESectionWritersFactory.factories;
            if (localFactories == null) {
                localFactories = new ArrayList<Class<? extends ISectionWriter>>();
            } else {
            	localFactories = new ArrayList<Class<? extends ISectionWriter>>(localFactories);
            }
            localFactories.add(element);
            EESectionWritersFactory.factories = Collections.unmodifiableList(localFactories);
        }
    }
    /**
     * Add a specific Factory
     */
    @SuppressWarnings("unchecked")
	static public synchronized void addFactory(ISectionWriter element) {
        List<Class<? extends ISectionWriter>> localFactories;
    	
        synchronized (mutex) {
            localFactories = EESectionWritersFactory.factories;
            if (localFactories == null) {
                localFactories = new ArrayList<Class<? extends ISectionWriter>>();
            } else {
            	localFactories = new ArrayList<Class<? extends ISectionWriter>>(localFactories);
            }
        	localFactories.add((Class<ISectionWriter>) element.getClass());

        	EESectionWritersFactory.factories = Collections.unmodifiableList(localFactories);
        }
    }    
    
	static public synchronized void addXsltFactory(String id, XsltMainComponent steps) {
        Map<String, XsltMainComponent> localXsltWriters;
    	
        synchronized (mutex) {
        	localXsltWriters = EESectionWritersFactory.xsltWriters;
            if (localXsltWriters == null) {
            	localXsltWriters = new HashMap<String, XsltMainComponent>();
            } else {
            	localXsltWriters = new HashMap<String, XsltMainComponent>(EESectionWritersFactory.xsltWriters);
            }
            localXsltWriters.put(id, steps);

        	EESectionWritersFactory.xsltWriters = Collections.unmodifiableMap(localXsltWriters);

        	defaultInstance.fireModelChanged(xsltWriters, IModelListener.ADDED, "");
        }
    }    
    
    /* **************************
     * 
     * RELOAD EXTENTIONS
     *
     * **************************/
    
	/**
	 * Reads all extensions.
	 * <p>
	 * This method can be called more than once in
	 * order to reload from a changed extension registry.
	 * </p>
	 */
	public static void reloadExtensions() {
	    @SuppressWarnings("unused")
		final int factories = 1; // disable global factories inside this method !!
	    
	    disabledIds.clear();

		IExtensionRegistry registry= Platform.getExtensionRegistry();
		ArrayList<Class<? extends ISectionWriter>> list= new ArrayList<Class<? extends ISectionWriter>>();
		HashMap<String, XsltMainComponent> map   = new HashMap<String, XsltMainComponent>();

		{
			IConfigurationElement[] elements= registry.getConfigurationElementsFor(PLUGIN_ID, SECTION_WRITER_EXTENSION_POINT);
			for (int i= 0; i < elements.length; i++) {
				try {
				    Collection<Class<ISectionWriter>> classes = parseWriterElement(elements[i]);
				    for (Iterator<Class<ISectionWriter>> iter = classes.iterator(); iter.hasNext(); ) {
				    	Class<ISectionWriter> tmp = (Class<ISectionWriter>) iter.next();
				        if (!list.contains(tmp)) {
				            list.add(tmp);
				        }
				    }
				} catch (ClassCastException e) {
					
				}
			}
			
			{ // Common parts
				list.add(0, SectionWriterCommonKernelDefs.class);
				// remote notifications
				list.add(1, SectionWriterRemoteNotification.class);
			}
			
			
			{ // MAKEFILE
				list.add(SectionWriterMakefile_SP.class);
				list.add(SectionWriterMakefile_MP.class);
			}


			
			
			
		}

		{
			IConfigurationElement[] elements= registry.getConfigurationElementsFor(PLUGIN_ID, XSLT_WRITER_EXTENSION_POINT);
			for (int i= 0; i < elements.length; i++) {
			    Map<String, XsltMainComponent> xsltw = parseXsltElement(elements[i]);
			    map.putAll(xsltw);
			}
		}

		
		
        // set factory list
        synchronized (mutex) {
    		EESectionWritersFactory.factories = Collections.unmodifiableList(list);
    		EESectionWritersFactory.xsltWriters = Collections.unmodifiableMap(map);
        }
	}

	@SuppressWarnings("unchecked")
	private static Collection<Class<ISectionWriter>> parseWriterElement(IConfigurationElement element) {
	    Assert.isLegal(element != null);

	    ArrayList<Class<ISectionWriter>> answer = new ArrayList<Class<ISectionWriter>>();

	    // class IEESectionWriters
		    
	    final String S_WRITER = "writer";
	    final String S_WRITER_CLASS = "class";
	    
/*	    IConfigurationElement children[] = element.getChildren();
	    
	    
		for (int i= 0; i < children.length; i++) {
		    String chName = children[i].getName();*/
	    do {
	    	String chName = element.getName();
		    /*
		     * Parse an Loader element
		     */
		    if (S_WRITER.equalsIgnoreCase(chName)) {
		        String className = element.getAttribute(S_WRITER_CLASS);
		        // load directly the factory's class doen't wark always then
                // ask to eclipse framework to load the required class, and
                // store only the "Class" object
		        Class<?> tmpClass = null;
		        try {
		            Object o = element.createExecutableExtension(S_WRITER_CLASS);
		            tmpClass = o.getClass();
		        } catch (Exception e) {
		            RtdruidLog.log(new RuntimeException("Not found the section writer class " + className, e));
		            continue; // next child
		        }
		        
		        // check if current tmpClass extend IAdapterFactoryLoader
		        if ( !((ISectionWriter.class).isAssignableFrom(tmpClass))) {
		        	RtdruidLog.log(new RuntimeException("The class " + className + " isn't an ISectionWriter"));
		            continue; // next child
		        }
		        
	            answer.add( (Class<ISectionWriter>) tmpClass);
		    }
		} while (false);

	    return answer;

	}

	private static Map<String, XsltMainComponent> parseXsltElement(IConfigurationElement element) {
	    Assert.isLegal(element != null);
	    
	    HashMap<String, XsltMainComponent> answer = new HashMap<String, XsltMainComponent>();
	    
	    // xslt transformations
	    
	    final String S_WRITER = "xsltWriter";
	    final String S_WRITER_ID = "id";
	    final String S_WRITER_ENABLED = "enabled";
	    final String S_WRITER_CATEGORY = "type";
	    final String S_WRITER_PRIORITY = "priority";
	    /*
	     * Parse root element
	     */
	    if (S_WRITER.equalsIgnoreCase(element.getName())) {
	    	
	    	String writerId = element.getAttribute(S_WRITER_ID);
	    	String writerEnabled = element.getAttribute(S_WRITER_ENABLED);
	    	String writerCategory = element.getAttribute(S_WRITER_CATEGORY);
	    	String writerPriority = element.getAttribute(S_WRITER_PRIORITY);
	    	
	    	int priority = SWCategoryManager.defaultPriority;
	    	if (writerPriority != null) {
	    		try {
	    			priority = Integer.parseInt(writerPriority);
	    		} catch (Exception e) {
					RtdruidLog.log("Wrong xslt writer priority. Writer = " + writerId, e);
				}
	    	}

	    	XsltMainComponent root = new XsltMainComponent(null, SWCategoryManager.defaultInstance.newCategory(writerCategory, priority));
	    	IConfigurationElement children[] = element.getChildren();
	    	for (IConfigurationElement child : children) {
	    		XsltComponent step = parseStep(child);
	    		if (step != null) {
	    			root.addTransformation(step);
	    		}
	    	}
	    	
	    	
            answer.put( writerId,  root);
            if (writerEnabled == null || !"true".equals(writerEnabled)) {
            	disabledIds.add(writerId);
            }
	    }
    

	    
	    return answer;
	}

	private static XsltComponent parseStep(IConfigurationElement element) {
	    Assert.isLegal(element != null);
	    
	    // xslt transformations
	    
	    final String S_WRITER_STEP = "xsltStep";
	    final String S_WRITER_STEP_ID = "xsltWriterStepId";

	    XsltComponent root = null;  
	    if (S_WRITER_STEP.equalsIgnoreCase(element.getName())) {
		    	
	    	String stepId = element.getAttribute(S_WRITER_STEP_ID);

	    	if (stepId != null) {
		    	root = new XsltComponent(stepId);
		    	IConfigurationElement children[] = element.getChildren();
		    	for (IConfigurationElement child : children) {
		    		XsltComponent step = parseStep(child);
		    		if (step != null) {
		    			root.addTransformation(step);
		    		}
		    	}
	    	}
		}
	    return root;
	}

	
	
	static public List<String> getDisabledIds() {
		return Collections.unmodifiableList((List) disabledIds.clone());
	}
	public static void setDisabledId(String id, boolean disable) {
		if (disable) {
			if (!disabledIds.contains(id)) {
				disabledIds.add(id);
			}
		} else {
			if (disabledIds.contains(id)) {
				disabledIds.remove(id);
			}
		}
		
	}
	
	public static Map<String, XsltMainComponent> getXsltWriters() {
		return xsltWriters;
	}
	
	
	public static boolean containsId(String id) {
		return xsltWriters.containsKey(id);
	}
	
	
	// --------------------------------------
	
	public static interface IModelListener {
		String ADDED = "__added";
		String REMOVED = "__removed";
		String CHANGED = "__changed";
		
		void modelChanged(Map<String, XsltMainComponent> objects, String type, String property);
	}
	
	private static ArrayList<IModelListener> modelListeners = new ArrayList<IModelListener>();

	public void addModelListener(IModelListener listener) {
		if (!modelListeners.contains(listener))
			modelListeners.add(listener);
	}
	public void removeModelListener(IModelListener listener) {
		modelListeners.remove(listener);
	}
	public void fireModelChanged(Map<String, XsltMainComponent> objects, String type, String property) {
		for (int i = 0; i < modelListeners.size(); i++) {
			((IModelListener) modelListeners.get(i)).modelChanged(objects,
					type, property);
		}
	}

}
