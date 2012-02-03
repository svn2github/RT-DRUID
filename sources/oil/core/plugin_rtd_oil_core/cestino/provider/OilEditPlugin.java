/**
 * <copyright>
 * </copyright>
 *
 * $Id: OilEditPlugin.java,v 1.2 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.vartree.data.oil.provider;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.ResourceLocator;

import com.eu.evidence.rtdruid.modules.oil.Rtd_oil_corePlugin;

/**
 * This is the central singleton for the oil edit plugin. <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * 
 * @generated NOT
 */
public final class OilEditPlugin implements ResourceLocator /* extends EMFPlugin */{


    /**
     * Keep track of the singleton. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    public static final OilEditPlugin INSTANCE = new OilEditPlugin();
    
    /**
     * Create the instance.
     */
    public OilEditPlugin() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.emf.common.util.ResourceLocator#getImage(java.lang.String)
     */
    public Object getImage(String key) {
        try {
            return Rtd_oil_corePlugin.getDefault().getImage(key);
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
        return Rtd_oil_corePlugin.getDefault().getBaseURL();
    }
    
    /*
     * Javadoc copied from interface.
     */
    public String getString(String key)
    {
      return Platform.getResourceBundle(Rtd_oil_corePlugin.getDefault().getBundle()).getString(key);
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