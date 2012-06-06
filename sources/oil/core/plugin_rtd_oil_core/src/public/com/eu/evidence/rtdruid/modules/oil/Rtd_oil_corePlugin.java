package com.eu.evidence.rtdruid.modules.oil;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilEPackageProvider;

/**
 * The main plugin class to be used in the desktop.
 */
public class Rtd_oil_corePlugin extends Plugin {
    public final static String PLUGIN_ID = 
    	"com.eu.evidence.rtdruid.oil.core";
       //com.eu.evidence.rtdruid.oil.core
    public final static String TEMPLATES_PATH = "/com/eu/evidence/rtdruid/modules/oil/templates/";
    
    public final static String EPACKAGE_OIL_CONTRIBUTIONS_ID = OilEPackageProvider.ID;

	//The shared instance.
	private static Rtd_oil_corePlugin plugin;
	//Resource bundle.
	private ResourceBundle resourceBundle;
	
    final public int PLUGIN_SN = 20001;
    final public String PLUGIN_VERS = "1.2.0";

	/**
	 * The constructor.
	 */
	public Rtd_oil_corePlugin() {
		super();
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle("com.eu.evidence.rtd_oil_core.Rtd_oil_corePluginResources");
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
	public static Rtd_oil_corePlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getResourceString(String key) {
		Rtd_oil_corePlugin current = Rtd_oil_corePlugin.getDefault();
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
