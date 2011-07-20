package com.eu.evidence.rtdruid.modules.jscan.ui.rtd_jscan_ui;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.eu.evidence.rtdruid.desk.RtdruidLog;

/**
 * The main plugin class to be used in the desktop.
 */
public class Rtd_jscan_uiPlugin extends AbstractUIPlugin {
	//The shared instance.
	private static Rtd_jscan_uiPlugin plugin;
	//Resource bundle.
	private ResourceBundle resourceBundle;
	
	/**
	 * The constructor.
	 */
	public Rtd_jscan_uiPlugin() {
		super();
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle("com.eu.evidence.rtdruid.modules.jscan.ui.rtd_jscan_ui.Rtd_jscan_uiPluginResources");
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
	}

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 */
	public static Rtd_jscan_uiPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getResourceString(String key) {
		Rtd_jscan_uiPlugin current = Rtd_jscan_uiPlugin.getDefault();
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
