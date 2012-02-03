/*
 * Created on 8-nov-2004
 *
 * $Id: VarTreeRequiredFactories.java,v 1.5 2008/03/26 18:23:51 durin Exp $
 */
package old.com.eu.evidence.rtdruid.internal.vartree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.AdapterFactory;

import com.eu.evidence.rtdruid.desk.IVarTreeRequiredFactories;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.vartree.AdapterFactoryLoader;



/**
 * Contains the names of all required adapter factories, that will be loaded
 * (using the method class.forName) each time that is called the method
 * getFactoies
 * 
 * @author Nicola Serreli
 * 
 * @deprecated
 */
// final public
class VarTreeRequiredFactories implements IVarTreeRequiredFactories {
    
    public static final String PLUGIN_ID = "com.eu.evidence.rtdruid.core";//"rtdruid.com.eu.evidence.rtdruid";
    public static final String EXTENSION_POINT = "requiredAdapterFactoriesID";
    public static final Boolean mutex = new Boolean(true);

    /** Contains the names of all required adapter factories*/
    private static List<Class<AdapterFactory>> factories = null;

    
    /*
     * public interface
     */
    /* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.hidden.vartree.IVarTreeRequiredFactories#pAddFactory(com.eu.evidence.rtdruid.vartree.AdapterFactoryLoader)
	 */
    public void pAddFactory(AdapterFactoryLoader factories) {
    	VarTreeRequiredFactories.addFactory(factories);
    }
    /* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.hidden.vartree.IVarTreeRequiredFactories#pAddFactory(org.eclipse.emf.common.notify.AdapterFactory)
	 */
    public void pAddFactory(AdapterFactory factories) {
    	VarTreeRequiredFactories.addFactory(factories);
    }
    /* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.hidden.vartree.IVarTreeRequiredFactories#pReload()
	 */
    public void pReload() {
    	VarTreeRequiredFactories.reloadExtensions();
    }
    
    
    /* **************************
     * 
     * GET FACTORIES
     *
     * **************************/

    /** Creates a new instances each required factory */
    static public synchronized AdapterFactory[] getFactories() {
        @SuppressWarnings("unused")
		final int factories = 1; // disable global factories inside this method !!
        List<Class<AdapterFactory>> localFactories;
        
        // get factory list
        synchronized (mutex) {
            localFactories = VarTreeRequiredFactories.factories;
            if (localFactories == null) {
                reloadExtensions();
                localFactories = VarTreeRequiredFactories.factories;
            }
        }
        
        ArrayList<AdapterFactory> answer = new ArrayList<AdapterFactory>();
	    for (Iterator<Class<AdapterFactory>> iter = localFactories.iterator(); iter.hasNext(); ) {
	        Class<AdapterFactory> tmpClass = (Class<AdapterFactory>) iter.next();
	        AdapterFactory af = null;
	        try {
	        	//af = (AdapterFactory) (tmpClass.getConstructor((Class<?>) null)).newInstance((Object) null);
	            af = (AdapterFactory) (tmpClass.getConstructor()).newInstance();
	        } catch (Exception e) {
	            RtdruidLog.log(e);
	            continue; // next child
	        }
	        answer.add(af);
	    }
    	
        return (AdapterFactory[]) answer.toArray(new AdapterFactory[answer.size()]);
    }

    /**
     * Add a specific Factory
     */
    static public synchronized void addFactory(AdapterFactoryLoader factories) {
        List<Class<AdapterFactory>> localFactories;
    	
        synchronized (mutex) {
            localFactories = VarTreeRequiredFactories.factories;
            if (localFactories == null) {
                localFactories = new ArrayList<Class<AdapterFactory>>(Arrays.asList(factories.getFactoryies()));
            } else {
            	localFactories = new ArrayList<Class<AdapterFactory>>(localFactories);
            	localFactories.addAll(Arrays.asList(factories.getFactoryies()));
            }
            VarTreeRequiredFactories.factories = Collections.unmodifiableList(localFactories);
        }
    }
    /**
     * Add a specific Factory
     */
    @SuppressWarnings("unchecked")
	static public synchronized void addFactory(AdapterFactory factories) {
        List<Class<AdapterFactory>> localFactories;
    	
        synchronized (mutex) {
            localFactories = VarTreeRequiredFactories.factories;
            if (localFactories == null) {
                localFactories = new ArrayList<Class<AdapterFactory>>();
            } else {
            	localFactories = new ArrayList<Class<AdapterFactory>>(localFactories);
            }
        	localFactories.add((Class<AdapterFactory>) factories.getClass());

        	VarTreeRequiredFactories.factories = Collections.unmodifiableList(localFactories);
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
		ArrayList<Class<AdapterFactory>> list= new ArrayList<Class<AdapterFactory>>();

		IConfigurationElement[] elements= registry.getConfigurationElementsFor(PLUGIN_ID, EXTENSION_POINT);
		for (int i= 0; i < elements.length; i++) {
			try {
			    Collection<Class<AdapterFactory>> classes = parseElement(elements[i]);
			    for (Iterator<Class<AdapterFactory>> iter = classes.iterator(); iter.hasNext(); ) {
			    	Class<AdapterFactory> tmp = (Class<AdapterFactory>) iter.next();
			        if (!list.contains(tmp)) {
			            list.add(tmp);
			        }
			    }
			} catch (ClassCastException e) {
				
			}
		}
		
        // set factory list
        synchronized (mutex) {
    		VarTreeRequiredFactories.factories = Collections.unmodifiableList(list);
        }
	}

	@SuppressWarnings("unchecked")
	private static Collection<Class<AdapterFactory>> parseElement(IConfigurationElement element) {
	    Assert.isLegal(element != null);
	    
	    final String ADP_FACTORY = "adapterFactory";
	    final String ADP_FACTORY_CLASS = "class";
	    final String LOADER = "loader";
	    final String LOADER_CLASS = "class";
	    
	    ArrayList<Class<AdapterFactory>> answer = new ArrayList<Class<AdapterFactory>>();
/*	    IConfigurationElement children[] = element.getChildren();
	    
	    
		for (int i= 0; i < children.length; i++) {
		    String chName = children[i].getName();*/
	    do {
	    	String chName = element.getName();
		    /*
		     * Parse an Loader element
		     */
		    if (LOADER.equalsIgnoreCase(chName)) {
		        String className = element.getAttribute(LOADER_CLASS);
		        // load directly the factory's class doen't wark always then
                // ask to eclipse framework to load the required class, and
                // store only the "Class" object
		        Class<?> tmpClass = null;
		        try {
		            Object o = element.createExecutableExtension(LOADER_CLASS);
		            tmpClass = o.getClass();
		        } catch (Exception e) {
		            RtdruidLog.log(new RuntimeException("Not found the adapter factory loader " + className, e));
		            continue; // next child
		        }
		        
		        // check if current tmpClass extend IAdapterFactoryLoader
		        if ( !((AdapterFactoryLoader.class).isAssignableFrom(tmpClass))) {
		        	RtdruidLog.log(new RuntimeException("The class " + className + " isn't an IAdapterFactoryLoader"));
		            continue; // next child
		        }
		        
		        AdapterFactoryLoader afl = null;
		        try {
		            //afl = (AdapterFactoryLoader) (tmpClass.getConstructor((Class<?>) null)).newInstance((Object) null);
		        	afl = (AdapterFactoryLoader) (tmpClass.getConstructor()).newInstance();
		        } catch (Exception e) {
		        	RtdruidLog.log(e);
		            continue; // next child
		        }
		        Class<AdapterFactory>[] classes = afl.getFactoryies();
		        for (int h=0; h<classes.length; h++) {
			        // check if current tmpClass extend IAdapterFactoryLoader
			        if ( !((AdapterFactory.class).isAssignableFrom(classes[h]))) {
			        	RtdruidLog.log(new RuntimeException("The class " + className + " isn't an Adapter Factory"));
			            continue; // next adapter factory
			        }
			        
		            answer.add(classes[h]);
		        }
		        
		        
		    } /*
		       * Parse an Adapter Factory element
		       */ 
		    else if (ADP_FACTORY.equalsIgnoreCase(chName)) {
		        String className = element.getAttribute(ADP_FACTORY_CLASS);
		        
		        Class<?> tmpClass = null;
		        // load directly the factory's class doen't wark always then
                // ask to eclipse framework to load the required class, and
                // store only the "Class" object
		        try {
		            Object o = element.createExecutableExtension(ADP_FACTORY_CLASS);
		            tmpClass = o.getClass();
		        } catch (Exception e) {
		            RtdruidLog.log(new RuntimeException("Not found the adapter factory loader " + className, e));
		            continue; // next child
		        }
		        
		        
		        // check if current tmpClass extend IAdapterFactoryLoader
		        if ( !((AdapterFactory.class).isAssignableFrom(tmpClass))) {
		        	RtdruidLog.log(new RuntimeException("The class " + className + " isn't an IAdapterFactoryLoader"));
		            continue; // next child
		        }

	            answer.add( (Class<AdapterFactory>) tmpClass);
		    }
		} while (false);
	    return answer;
	}
}
