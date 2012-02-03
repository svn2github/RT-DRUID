/**
 * 14/nov/2011
 */
package com.eu.evidence.rtdruid.epackage;

/**
 * This exception is thrown if there is a problem during the build of RT-Druid
 * Ecore Package
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public class RTDEPackageBuildException extends Exception {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = -2791416252601159159L;

	/**
	 * Default constructor
	 */
	public RTDEPackageBuildException() {
	}

	/**
	 * The constructor with an error message
	 * 
	 * @param msg
	 *            the error message
	 * 
	 */
	public RTDEPackageBuildException(String msg) {
		super(msg);
	}

	/**
	 * The constructor with an error message and a cause
	 * 
	 * @param msg
	 *            the error message
	 * @param t
	 *            the cause
	 * 
	 */
	public RTDEPackageBuildException(String msg, Throwable t) {
		super(msg, t);
	}

	/**
	 * The constructor with a cause.
	 * 
	 * @param t
	 *            the cause
	 * 
	 */
	public RTDEPackageBuildException(Throwable t) {
		super(t);
	}

}
