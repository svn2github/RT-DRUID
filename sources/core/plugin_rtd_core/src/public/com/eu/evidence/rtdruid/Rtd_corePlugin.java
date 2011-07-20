package com.eu.evidence.rtdruid;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;

import com.eu.evidence.rtdruid.desk.RtdruidLog;


/**
 * The main plugin class to be used in the desktop.
 */
public class Rtd_corePlugin extends Plugin {
    final static String PLUGIN_ID = "com.eu.evidence.rtdruid";
    public final static String TEMPLATES_PATH = "/com/eu/evidence/rtdruid/templates";
    
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
	

	/**
	 */
    public Object getImage(String key) throws IOException
    {
      URL url = new URL(getBaseURL() + "icons/" + key + ".gif");
      InputStream inputStream = url.openStream(); 
      inputStream.close();
      return url;
    }
    
    /*
     * Javadoc copied from interface.
     */
    public URL getBaseURL()
    {
      return getBundle().getEntry("/");
    }
}


