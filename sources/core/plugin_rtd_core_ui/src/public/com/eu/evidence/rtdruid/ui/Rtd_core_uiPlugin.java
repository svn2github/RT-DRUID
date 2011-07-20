package com.eu.evidence.rtdruid.ui;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.ui.common.ShowLogo;

/**
 * The main plugin class to be used in the desktop.
 */
public class Rtd_core_uiPlugin extends AbstractUIPlugin {

	final public static String PLUGIN_ID = "com.eu.evidence.rtdruid.core.ui";

	//The shared instance.
	private static Rtd_core_uiPlugin plugin;
	//Resource bundle.
	private ResourceBundle resourceBundle;
	/**
	 * The constructor.
	 */
	public Rtd_core_uiPlugin() {
		super();
		
		if (plugin == null) {
			plugin = this;
			try {
				resourceBundle = ResourceBundle.getBundle("com.eu.evidence.rtdruid.ui.coreui");
			} catch (MissingResourceException x) {
				resourceBundle = null;
			}
			
		} else {
			this.resourceBundle = plugin.resourceBundle;
			//RtdruidLog.showDebug(new RuntimeException("RTD Core UI instanced more than one time"));
		}
	}

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		if (plugin != this) {
			throw new RuntimeException("Illegal Rtd_core_uiPlugin");
		}
		
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		if (plugin != this) {
			throw new RuntimeException("Illegal Rtd_core_uiPlugin");
		}
		
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 */
	public static Rtd_core_uiPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = Rtd_core_uiPlugin.getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return key;
		}
	}

	
	/*
     * Javadoc copied from interface.
     */
    public String getString(String key, Object [] substitutions)
    {
      return MessageFormat.format(getResourceString(key), substitutions);
    }
    
    public String getString(String key, boolean translate) {
    	return getResourceString(key);
    }
    /*
     * Javadoc copied from interface.
     */
    public String getString(String key, Object [] substitutions, boolean translate)
    {
      return MessageFormat.format(getString(key, translate), substitutions);
    }

    
	/**
	 * Returns the plugin's resource bundle,
	 */
	public ResourceBundle getResourceBundle() {
		return plugin.resourceBundle;
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
