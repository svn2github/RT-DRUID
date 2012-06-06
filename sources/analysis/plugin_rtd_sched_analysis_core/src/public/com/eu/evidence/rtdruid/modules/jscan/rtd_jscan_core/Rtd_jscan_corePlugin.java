package com.eu.evidence.rtdruid.modules.jscan.rtd_jscan_core;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class Rtd_jscan_corePlugin extends Plugin {
	//The shared instance.
	private static Rtd_jscan_corePlugin plugin;
	//Resource bundle.
//	private ResourceBundle resourceBundle;
	
	public boolean disable = false;
	/**
	 * The constructor.
	 */
	public Rtd_jscan_corePlugin() {
		super();
		plugin = this;
//		try {
//			resourceBundle = ResourceBundle.getBundle("com.eu.evidence.rtdruid.modules.jscan.rtd_jscan_core.Rtd_jscan_corePluginResources");
//		} catch (MissingResourceException x) {
//			resourceBundle = null;
//		}
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
//	public static Rtd_jscan_corePlugin getDefault() {
//		return plugin;
//	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
//	public static String getResourceString(String key) {
//		ResourceBundle bundle = Rtd_jscan_corePlugin.getDefault().getResourceBundle();
//		try {
//			return (bundle != null) ? bundle.getString(key) : key;
//		} catch (MissingResourceException e) {
//			return key;
//		}
//	}

	/**
	 * Returns the plugin's resource bundle,
	 */
//	public ResourceBundle getResourceBundle() {
//		return resourceBundle;
//	}
}
