/**
 * <copyright>
 * </copyright>
 *
 * $Id: DataEditPlugin.java,v 1.2 2007/03/09 09:12:40 durin Exp $
 */
package com.eu.evidence.rtdruid;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.ResourceLocator;
import org.osgi.framework.Bundle;

import com.eu.evidence.rtdruid.Rtd_corePlugin;
import com.eu.evidence.rtdruid.desk.RtdruidLog;

/**
 * This is the central singleton for the Data edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated NOT
 * 
 */
public final class DataEditPlugin implements ResourceLocator /* extends EMFPlugin */{

    //public final static String PLUGIN_ID = "com.eu.evidence.rtdruid.module.oil";

    /**
     * Keep track of the singleton. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    public static final DataEditPlugin INSTANCE = new DataEditPlugin();
    
    /**
     * Create the instance.
     */
    public DataEditPlugin() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.emf.common.util.ResourceLocator#getImage(java.lang.String)
     */
    public Object getImage(String key) {
        try {
            return Rtd_corePlugin.getDefault().getImage(key);
        } catch (IOException e) {
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.emf.common.util.ResourceLocator#getBaseURL()
     */
    public URL getBaseURL() {
        return Rtd_corePlugin.getDefault().getBaseURL();
    }
    
    /*
     * Javadoc copied from interface.
     */
    public String getString(String key)
    {
		//return Platform.getResourceBundle(Rtd_corePlugin.getDefault().getBundle()).getString(key);
    	String answer = null;
    	try {
    		Bundle bundle=Rtd_corePlugin.getDefault().getBundle();
	    	answer = bundle == null? null:getBundleString(Platform.getResourceBundle(bundle), key);
	    	
	    	if (answer == null) {
		    	answer = getBundleString(ResourceBundle.getBundle("plugin", Locale.getDefault(), Rtd_corePlugin.class.getClassLoader()), key);
	    	}
	    	
	    	if (answer == null) {
	    		answer = key;
	    	}
	    	
	    	/*
	    	 * else
        {
          String resourceName = getBaseURL().toString() + "plugin.properties";
          try
          {
            InputStream inputStream =  new URL(resourceName).openStream();
            bundle = untranslatedResourceBundle = new PropertyResourceBundle(inputStream);
            inputStream.close();
          }
          catch (IOException ioException)
          {
            throw new MissingResourceException("Missing properties: " + resourceName, getClass().getName(), "plugin.properties");
          }
        }
	    	 */
	    	
    	} catch (Exception e) {
    		RtdruidLog.showDebug("getString ERRORR -> " +key);
    		RtdruidLog.showDebug(e);
    		
	    	answer = key;
    	}

    	//System.out.println("getString " + key + " = " + answer );
    	
    	return answer;
    }
    
    /** This method is a work-around for an Eclipse 3.3 Bug (Sometimes, getKey() return null).
     * 
     *  If this method find the required string, it return the string, otherwise returns null
     */
    private String getBundleString(ResourceBundle b, String key) {
    	String answer = null;
    	
    	if (b != null) {
			if (b.getKeys() == null) {
//				try {
					answer = b.getString(key);
					
//				} catch (Exception e) {
//					//e.printStackTrace();
//				}
			} else if (b.containsKey(key)) {
				answer = b.getString(key);
			}
    	}
    	
    	
    	return answer;
    }
    
    /*
     * Javadoc copied from interface.
     */
    public String getString(String key, Object [] substitutions)
    {
      return MessageFormat.format(getString(key), substitutions);
    }
    /*
     * Javadoc copied from interface.
     */
    public String getString(String key, boolean translate) {
    	return getString(key);
    }
    /*
     * Javadoc copied from interface.
     */
    public String getString(String key, Object [] substitutions, boolean translate)
    {
      return MessageFormat.format(getString(key, translate), substitutions);
    }

}
