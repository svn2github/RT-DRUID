package com.eu.evidence.rtdruid.test.modules.oil.xtext;

import java.net.URL;

public class PackageProvider {

	public static PackageProvider DEFAULT = new PackageProvider();
	

	/**
	 * This function return the bundle path of the specified class
	 * 
	 * @param c a class
	 * @return the bundle path where the specified class is located
	 */
	public String computeBundleClassPath(Class<?> c) {
		URL path = c.getClassLoader().getResource("/" + c.getPackage().getName().replaceAll("\\.", "/") + "/");
		return path.toString();
	}

	/**
	 * This function add "classpath://" to the specified class package.
	 * All "." are replaced with "/"
	 * 
	 * 
	 * @param c a class
	 * @return a string composed by "classpath://" and the package path 
	 */
//	public String computeClassPath(Class<?> c) {
//		return "classpath://" + c.getPackage().getName().replaceAll("\\.", "/") + "/";
//	}

	
}
