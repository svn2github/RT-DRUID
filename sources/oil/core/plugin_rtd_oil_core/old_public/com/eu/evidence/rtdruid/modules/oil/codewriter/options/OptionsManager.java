/**
 * Created on 12/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.codewriter.options;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import com.eu.evidence.rtdruid.desk.RtdruidLog;



/**
 * Contains the names of all required adapter factories, that will be loaded
 * (using the method class.forName) each time that is called the method
 * getFactoies
 * 
 * @author Nicola Serreli
 */
public final class OptionsManager {
    
    public static final String PLUGIN_ID = "com.eu.evidence.rtdruid.oil.core";
    public static final String EXTENSION_POINT = "builderOptions";
    public static final Object mutex = new Object();

    /** Contains the names of all required adapter factories*/
    private static List<Class<IBuildOptions>> factories = null;

    
    /*
     * public interface
     */
    /**
     * Add a SectionWriter
	 */
    public void pAddFactory(Class<IBuildOptions> factories) {
    	OptionsManager.addFactory(factories);
    }
    /**
     * Add a SectionWriter
	 */
    public void pAddFactory(IBuildOptions factories) {
    	OptionsManager.addFactory(factories);
    }
    /**
     * Reload all extentions
	 */
    public void pReload() {
    	OptionsManager.reloadExtensions();
    }
    
    
    /* **************************
     * 
     * GET FACTORIES
     *
     * **************************/

    /** Creates a new instances each required factory */
    static public synchronized IBuildOptions[] getFactories() {
        @SuppressWarnings("unused")
		final int factories = 1; // disable global factories inside this method !!
        List<Class<IBuildOptions>> localFactories;
        
        // get factory list
        synchronized (mutex) {
            localFactories = OptionsManager.factories;
            if (localFactories == null) {
                reloadExtensions();
                localFactories = OptionsManager.factories;
            }
        }
        
        ArrayList<IBuildOptions> answer = new ArrayList<IBuildOptions>();
	    for (Iterator<Class<IBuildOptions>> iter = localFactories.iterator(); iter.hasNext(); ) {
	        Class<IBuildOptions> tmpClass = (Class<IBuildOptions>) iter.next();
	        IBuildOptions af = null;
	        try {
	        	Constructor<IBuildOptions> construct = tmpClass.getConstructor();

	        	if (construct != null) {
	        		af = (IBuildOptions) construct.newInstance();
	        	} else {
	        		RtdruidLog.log(new RuntimeException("Cannot find a valid constructor for " + tmpClass.getName()));
	        		continue;
	        	}
	        } catch (Exception e) {
	            RtdruidLog.log(e);
	            continue; // next child
	        }
	        if (af != null)
	        	answer.add(af);
	    }
	    
//	    System.err.println("\n\nELENCO Options trovate :\n" +answer + "\n\n");
    	
        return (IBuildOptions[]) answer.toArray(new IBuildOptions[answer.size()]);
    }

    /**
     * Add a specific Factory
     */
    static public synchronized void addFactory(Class<IBuildOptions> element) {
        List<Class<IBuildOptions>> localFactories;
    	
        synchronized (mutex) {
            localFactories = OptionsManager.factories;
            if (localFactories == null) {
                localFactories = new ArrayList<Class<IBuildOptions>>();
            } else {
            	localFactories = new ArrayList<Class<IBuildOptions>>(localFactories);
            }
            localFactories.add(element);
            OptionsManager.factories = Collections.unmodifiableList(localFactories);
        }
    }
    /**
     * Add a specific Factory
     */
    @SuppressWarnings("unchecked")
	static public synchronized void addFactory(IBuildOptions element) {
        List<Class<IBuildOptions>> localFactories;
    	
        synchronized (mutex) {
            localFactories = OptionsManager.factories;
            if (localFactories == null) {
                localFactories = new ArrayList<Class<IBuildOptions>>();
            } else {
            	localFactories = new ArrayList<Class<IBuildOptions>>(localFactories);
            }
        	localFactories.add((Class<IBuildOptions>) element.getClass());

        	OptionsManager.factories = Collections.unmodifiableList(localFactories);
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

		IExtensionRegistry registry= Platform.getExtensionRegistry();
		ArrayList<Class<IBuildOptions>> list= new ArrayList<Class<IBuildOptions>>();

		IConfigurationElement[] elements= registry.getConfigurationElementsFor(PLUGIN_ID, EXTENSION_POINT);
		for (int i= 0; i < elements.length; i++) {
			try {
			    Collection<Class<IBuildOptions>> classes = parseElement(elements[i]);
			    for (Iterator<Class<IBuildOptions>> iter = classes.iterator(); iter.hasNext(); ) {
			    	Class<IBuildOptions> tmp = (Class<IBuildOptions>) iter.next();
			        if (!list.contains(tmp)) {
			            list.add(tmp);
			        }
			    }
			} catch (ClassCastException e) {
				
			}
		}
		
        // set factory list
        synchronized (mutex) {
    		OptionsManager.factories = Collections.unmodifiableList(list);
        }
	}

	@SuppressWarnings("unchecked")
	private static Collection<Class<IBuildOptions>> parseElement(IConfigurationElement element) {
	    Assert.isLegal(element != null);
	    
	    // UPDRTD Testare !!!!
	    
	    final String S_WRITER = "options";
	    final String S_WRITER_CLASS = "class";
	    
	    ArrayList<Class<IBuildOptions>> answer = new ArrayList<Class<IBuildOptions>>();
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
		            RtdruidLog.log(new RuntimeException("Not found the builder options extention class " + className, e));
		            continue; // next child
		        }
		        
		        // check if current tmpClass extend IAdapterFactoryLoader
		        if ( !((IBuildOptions.class).isAssignableFrom(tmpClass))) {
		        	RtdruidLog.log(new RuntimeException("The class " + className + " isn't an IBuildOptions"));
		            continue; // next child
		        }
		        
	            answer.add( (Class<IBuildOptions>) tmpClass);
		    }
		} while (false);
	    return answer;
	}
	
	
	// ------------------------
	
	public static HashMap<String, Object> getOptions() {
		HashMap<String, Object> answer = new HashMap<String, Object>();
		/*
	 	 * BuilderOptions Extentions
	 	 */
		IBuildOptions[] options = OptionsManager.getFactories();
		for (IBuildOptions opt : options) {
			try {
				answer.putAll(opt.getOptions());
			} catch (RuntimeException e) {
				RtdruidLog.log(e);
			}
		}
		return answer;
	}
}
