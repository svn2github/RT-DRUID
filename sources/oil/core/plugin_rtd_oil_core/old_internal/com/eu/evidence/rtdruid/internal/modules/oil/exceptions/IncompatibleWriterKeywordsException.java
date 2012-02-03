/*
 * Created on Nov 30, 2004
 *
 * $Id: IncompatibleWriterKeywordsException.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.exceptions;

/**
 * This exception is throw if a Writer is used with one or more incompatibles
 * Keywords
 * 
 * @author Nicola Serreli
 */
public class IncompatibleWriterKeywordsException extends OilCodeWriterException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 781938210934680804L;

	/** The identifier of writer */
	protected String writerId;

	/** The incompatible keyword */
	protected String incompatibleKeyword;

	// --------------------------------------------------------------------

	/** A constructor without parameter, useful only for subclasses. */
	protected IncompatibleWriterKeywordsException() {
	}
	
	/**
	 * The default contructor, with a message.
	 * 
	 * @param txt identifies the writer
	 * @param writerId identifies the writer
	 * @param incompatibleKeyword the incompatible keyword
	 */
	public IncompatibleWriterKeywordsException(String txt,
			String writerId,
			String incompatibleKeyword) {
		super(txt);

		this.incompatibleKeyword = incompatibleKeyword;
		this.writerId = writerId;
	}

	/**
	 * The default contructor, with a message.
	 * 
	 * @param writerId identifies the writer
	 * @param incompatibleKeyword the incompatible keyword
	 */
	public IncompatibleWriterKeywordsException(String writerId,
			String incompatibleKeyword) {
		super("The keyword " + incompatibleKeyword
				+ "is incompatible with this Writer (" + writerId + ")");

		this.incompatibleKeyword = incompatibleKeyword;
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
	 * Returns the incompatible keyword
	 * 
	 * @return the incompatible keyword
	 */
	public String getIncompatibleKeyword() {
		return incompatibleKeyword;
	}
}

