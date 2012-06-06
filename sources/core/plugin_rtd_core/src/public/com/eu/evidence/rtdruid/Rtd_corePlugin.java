package com.eu.evidence.rtdruid;

import java.io.InputStream;
import java.net.URL;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.ResourceLocator;
import org.osgi.framework.Bundle;

import com.eu.evidence.rtdruid.desk.RtdruidLog;


/**
 * The main plugin class to be used in the desktop.
 */
public class Rtd_corePlugin extends Plugin implements ResourceLocator {
    public final static String PLUGIN_ID = "com.eu.evidence.rtdruid.core";
    public final static String TEMPLATES_PATH = "/com/eu/evidence/rtdruid/templates";

    public final static String EPACKAGE_BASE_ID = "RT-Druid Core - Base contribution";

    
    
	public static final boolean IS_RESOURCES_BUNDLE_ACTIVE;
	static {
		boolean result = false;
		try {
			Bundle resourcesBundle = Platform.getBundle("org.eclipse.core.resources");
			result = resourcesBundle != null
					&& (resourcesBundle.getState() & (Bundle.ACTIVE | Bundle.STARTING )) != 0;
		} catch (Throwable exception) {
			// Assume that it's not available.
		}
		IS_RESOURCES_BUNDLE_ACTIVE = result;
	}    
    
    //The shared instance.
	private static Rtd_corePlugin plugin;
	//Resource bundle.
	private ResourceBundle resourceBundle;
	
	/**
	 * The constructor.
	 */
	public Rtd_corePlugin() {
		super();
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle("com.eu.evidence.rtdruid.Rtd_corePluginResources");
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
	}

	/**
	 * Returns the shared instance.
	 */
	public static Rtd_corePlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getResourceString(String key) {
		Rtd_corePlugin current = Rtd_corePlugin.getDefault();
		ResourceBundle bundle = current.getResourceBundle();
		if (bundle == null) {
			try {
				bundle = new PropertyResourceBundle(FileLocator.openStream(current.getBundle(), new Path("plugin.properties"), false));
				current.resourceBundle = bundle;
			} catch (Throwable e) {
				RtdruidLog.log(e);
			}
		}
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return key;
		}
	}

	/**
	 * Returns the plugin's resource bundle,
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	

	/**
	 */
	public Object getImage(String key) {
		try {
			URL url = new URL(getBaseURL() + "icons/" + key + ".gif");
			InputStream inputStream = url.openStream();
			inputStream.close();
			return url;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
    
    /*
     * Javadoc copied from interface.
     */
    public URL getBaseURL()
    {
      return getBundle().getEntry("/");
    }
    
    
    ////////////////////////////// LOG ////////////////////////////// 

	public static void log(IStatus status) {
        if (getDefault() != null) {
        	((Plugin) getDefault()).getLog().log(status);
        } else {
        	status.getException().printStackTrace();
        }
	}
	
	public static void log(Throwable e) {
        if ( e instanceof CoreException ) {
                log(((CoreException)e).getStatus());
        } else {
                log(new Status(IStatus.ERROR, PLUGIN_ID, IStatus.ERROR, e.getMessage() == null ? "" : e.getMessage(), e));
        }
	}

    ////////////////////////////// RESOURCE LOCATOR ////////////////////////////// 

	
	@Override
	public String getString(String key) {
		return getResourceString(key);
	}

	@Override
	public String getString(String key, boolean translate) {
		return getResourceString(key);
	}

	@Override
	public String getString(String key, Object[] substitutions) {
		return MessageFormat.format(getString(key), substitutions);
	}

	@Override
	public String getString(String key, Object[] substitutions,
			boolean translate) {
		return MessageFormat.format(getString(key, translate), substitutions);
	}
	
}
