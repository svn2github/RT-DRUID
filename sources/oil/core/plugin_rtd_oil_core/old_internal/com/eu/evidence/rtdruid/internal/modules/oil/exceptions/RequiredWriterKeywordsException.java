/*
 * Created on Nov 30, 2004
 *
 * $Id: RequiredWriterKeywordsException.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.exceptions;

/**
 * This exception is throw if a Writer is used without one or more required
 * Keywords
 * 
 * @author Nicola Serreli
 */
public class RequiredWriterKeywordsException extends OilCodeWriterException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8667342169314215596L;

	/** The identifier of writer */
	protected String writerId;

	/** The required keyword */
	protected String requiredKeyword;

	// --------------------------------------------------------------------

	/** A constructor without parameter, useful only for subclasses. */
	protected RequiredWriterKeywordsException() {
	}

	/**
	 * The default contructor, with a message.
	 * 
	 * @param writerId identifies the writer
	 * @param requiredKeyword the required keyword
	 */
	public RequiredWriterKeywordsException(String writerId,
			String requiredKeyword) {
		super("The keyword " + requiredKeyword
				+ "is required by this Writer (" + writerId + ")");

		this.requiredKeyword = requiredKeyword;
		this.writerId = writerId;
	}

	// --------------------------------------------------------------------

	/**
	 * Returns the id of writer
	 * 
	 * @return the id of writer
	 */
	public String getWriterId() {
		return writerId;
	}

	/**
	 * Returns the required keyword
	 * 
	 * @return the required keyword
	 */
	public String getRequiredKeyword() {
		return requiredKeyword;
	}
}