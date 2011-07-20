/*
 * Created on Nov 30, 2004
 *
 * $Id: OilCodeWriterException.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.exceptions;

/**
 * Is the main exception for all operations about
 * <code>write configuration files</code>
 * 
 * @author Nicola Serreli
 */
public class OilCodeWriterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8889723744630610375L;

	/** A constructor without parameter, useful only for subclasses. */
	protected OilCodeWriterException() {
	}

	/**
	 * The default contructor, with a message.
	 * 
	 * @param msg
	 *            the message that explains this exception
	 */
	public OilCodeWriterException(String msg) {
		super(msg);
	}
	

	/**
	 * The default contructor, with a message and a cause.
	 * 
	 * @param msg
	 *            the message that explains this exception
	 */
	public OilCodeWriterException(String msg, Throwable e) {
		super(msg, e);
	}
}
