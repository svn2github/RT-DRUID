/**
 * Created on 01/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces;


/**
 * This interface is used to add the banner to a specific type of files
 * 
 * @author Nicola Serreli
 *
 * @deprecated non completata
 * 
 */
public interface IFileBanner {

	/**
	 * This method returns the list of supported file extentions (e.g.: .c .cpp
	 * .h ), or null if it can potentially manage every type of file. In that
	 * case, use {@link isSupported} method.<br>
	 * <b>Important</b>: a null array has a different meaning form "empty array" means that no file is supported, while a
	 * null array means that 
	 * 
	 * 
	 * @return every supported file extentions. Null means "use
	 *         {@link isSupported}" method.
	 */
	String[] getSupportedExtentions();
	
	
	/**
	 * This method returns 
	 * */
	boolean isSupported(String fileName, String relativePath);
	
	/**
	 * This method is called to add a banner to a single buffer
	 * */
	void addBanner(StringBuffer buffer);
}
