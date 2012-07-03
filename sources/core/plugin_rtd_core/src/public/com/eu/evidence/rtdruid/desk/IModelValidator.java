/**
 * 28/giu/2012
 */
package com.eu.evidence.rtdruid.desk;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public interface IModelValidator {

	boolean validate(InputStream input) throws IOException;

	/**
	 * @throws IOException 
	 * 
	 */
	boolean validate(String input) throws IOException;

	boolean containsErrors();

	boolean containsWarnings();

	String getReport();

}