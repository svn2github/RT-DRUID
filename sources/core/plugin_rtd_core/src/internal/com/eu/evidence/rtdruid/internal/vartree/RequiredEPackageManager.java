/*
 * Created on 8-nov-2004
 *
 * $Id: VarTreeRequiredFactories.java,v 1.5 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.vartree;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.vartree.IEPackageProvider;



/**
 * Contains the names of all required adapter factories, that will be loaded
 * (using the method class.forName) each time that is called the method
 * getFactoies
 * 
 * @author Nicola Serreli
 */
final public class RequiredEPackageManager {
    
    public static final String PLUGIN_ID = "com.eu.evidence.rtdruid.core";//"rtdruid.com.eu.evidence.rtdruid";
    public static final String EXTENSION_POINT = "requiredEPackageID";
    public static final Boolean mutex = new Boolean(true);

    /** Contains the names of all required adapter factories*/
    private static List<Class<IEPackageProvider>> factories = null;

    
    /* **************************
     * 
     * GET FACTORIES
     *
     * **************************/

    /** Creates a new instances each required factory */
    static public synchronized IEPackageProvider[] getEPackages() {
        final int factories = 1; // disable global factories inside this method !!
        List<Class<IEPackageProvider>> localFactories;
        
        // get factory list
        synchronized (mutex) {
            localFactories = RequiredEPackageManager.factories;
            if (localFactories == null) {
                reloadExtensions();
                localFactories = RequiredEPackageManager.factories;
            }
        }
        
        ArrayList<IEPackageProvider> answer = new ArrayList<IEPackageProvider>();
	    for (Iterator<Class<IEPackageProvider>> iter = localFactories.iterator(); iter.hasNext(); ) {
	        Class<IEPackageProvider> tmpClass = (Class<IEPackageProvider>) iter.next();
	        IEPackageProvider af = null;
	        try {
	        	//af = (IEPackageProvider) (tmpClass.getConstructor((Class<?>) null)).newInstance((Object) null);
	            af = (IEPackageProvider) (tmpClass.getConstructor()).newInstance();
	        } catch (Exception e) {
	            RtdruidLog.log(e);
	            continue; // next child
	        }
	        answer.add(af);
	    }
    	
        return (IEPackageProvider[]) answer.toArray(new IEPackageProvider[answer.size()]);
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
	    final int factories = 1; // disable global factories inside this method !!

		IExtensionRegistry registry= Platform.getExtensionRegistry();
		ArrayList<Class<IEPackageProvider>> list= new ArrayList<Class<IEPackageProvider>>();

		IConfigurationElement[] elements= registry.getConfigurationElementsFor(PLUGIN_ID, EXTENSION_POINT);
		for (int i= 0; i < elements.length; i++) {
			try {
			    Collection<Class<IEPackageProvider>> classes = parseElement(elements[i]);
			    for (Iterator<Class<IEPackageProvider>> iter = classes.iterator(); iter.hasNext(); ) {
			    	Class<IEPackageProvider> tmp = (Class<IEPackageProvider>) iter.next();
			        if (!list.contains(tmp)) {
			            list.add(tmp);
			        }
			    }
			} catch (ClassCastException e) {
				
			}
		}
		
        // set factory list
        synchronized (mutex) {
    		RequiredEPackageManager.factories = Collections.unmodifiableList(list);
        }
	}

	private static Collection<Class<IEPackageProvider>> parseElement(IConfigurationElement element) {
	    Assert.isLegal(element != null);
	    
	    final String LOADER = "loader";
	    final String LOADER_CLASS = "class";
	    
    	String chName = element.getName();
        ArrayList<Class<IEPackageProvider>> answer = new ArrayList<Class<IEPackageProvider>>();
	    /*
	     * Parse an Loader element
	     */
	    if (LOADER.equalsIgnoreCase(chName)) {
	        String className = element.getAttribute(LOADER_CLASS);

	        // load directly the factory's class doen't wark always then
            // ask to eclipse framework to load the required class, and
            // store only the "Class" object
	        try {
	            Object o = element.createExecutableExtension(LOADER_CLASS);
	            if ( !((IEPackageProvider.class).isAssignableFrom(o.getClass()))) {
		        	RtdruidLog.log(new RuntimeException("The class " + className + " isn't an IEPackageProvider"));
		        } else {
		        	answer.add((Class<IEPackageProvider>) o.getClass());
		        }
	        } catch (Exception e) {
	            RtdruidLog.log(new RuntimeException("Not found the adapter factory loader " + className, e));
	        }
	    }
	    
	    return answer;
	}
}
