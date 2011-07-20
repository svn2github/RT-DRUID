/*
 * Created on 21-giu-2005
 *
 * $Id: Rtd_oil_niossupportPlugin.java,v 1.4 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.cdt.ui;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.ui.common.ShowLogo;

/**
 * The main plugin class to be used in the desktop.
 * 
 * TODO : Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public class Rtd_oil_cdt_Plugin extends AbstractUIPlugin {
	
	final public static String PLUGIN_ID = "com.eu.evidence.rtdruid.oil.cdt.ui";
	//The shared instance.
	private static Rtd_oil_cdt_Plugin plugin;
	//Resource bundle.
	//private ResourceBundle publicBundle;
	private ResourceBundle resourceBundle;

    final public int PLUGIN_SN = 30001;
    final public String PLUGIN_VERS = "1.2.0";
	
	/**
	 * The constructor.
	 */
	public Rtd_oil_cdt_Plugin() {
		super();
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle("com.eu.evidence.rtdruid.modules.oil.cdt.ui.cdtsupport");
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
//		try {
//			publicBundle = ResourceBundle.getBundle("plugin");
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
	public static Rtd_oil_cdt_Plugin getDefault() {
		return plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle,
	 * or 'key' if not found.
	 */
	public static String getString(String key) {
		String answer = key;
		ResourceBundle bundle = Rtd_oil_cdt_Plugin.getDefault().resourceBundle;
		try {
			if (bundle != null) {
				return bundle.getString(key);
			}
		} catch (MissingResourceException e) {
		}
		
//		bundle = Rtdruid_module_oil_niosPlugin.getDefault().publicBundle;
//		try {
//			if (bundle != null) {
//				return bundle.getString(key);
//			}
//		} catch (MissingResourceException e) {
//		}
//		
		return answer;
	}

	public static String getFormattedString(String key, String arg) {
		return MessageFormat.format(getString(key), new Object[]{arg});
	}

	public static String getFormattedString(String key, Object[] args) {
		return MessageFormat.format(getString(key), args);
	}

	/**
	 * Returns the plugin's resource bundle,
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
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
