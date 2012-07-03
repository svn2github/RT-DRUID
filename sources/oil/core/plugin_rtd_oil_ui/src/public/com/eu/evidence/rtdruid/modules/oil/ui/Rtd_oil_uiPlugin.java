package com.eu.evidence.rtdruid.modules.oil.ui;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.oil.xtext.ui.internal.OilActivator;
import com.eu.evidence.rtdruid.ui.common.ShowLogo;

/**
 * The main plugin class to be used in the desktop.
 */
public class Rtd_oil_uiPlugin extends OilActivator {//AbstractUIPlugin {

	final public static String PLUGIN_ID = "com.eu.evidence.rtdruid.oil.ui";
	
	//The shared instance.
	private static Rtd_oil_uiPlugin plugin;
	//Resource bundle.
	private ResourceBundle resourceBundle;
	
	/**
	 * The constructor.
	 */
	public Rtd_oil_uiPlugin() {
		super();
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle("com.eu.evidence.rtdruid.modules.oil.ui.Rtd_oil_uiPluginResources");
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
	public static Rtd_oil_uiPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = Rtd_oil_uiPlugin.getDefault().getResourceBundle();
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
    
    /** Show logo */
	static {
		try {
			new ShowLogo();
		} catch (Throwable e) {
			RtdruidLog.log(e);
		}
	}
}
