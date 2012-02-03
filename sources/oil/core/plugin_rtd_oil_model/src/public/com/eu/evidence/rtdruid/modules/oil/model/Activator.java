package com.eu.evidence.rtdruid.modules.oil.model;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {


	private static BundleContext context;
	public static String PLUGIN_ID = "com.eu.evidence.rtdruid.oil.model";

	static BundleContext getContext() {
		return context;
	}
	
	public static Bundle getBundle() {
		if (context != null) {
			return context.getBundle();
		}
		return null;
	}
	


	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}
	

}
