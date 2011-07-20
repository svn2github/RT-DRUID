package com.eu.evidence.rtdruid.internal.modules.jscan.partialorder;

/**
 * This exception is throwed if there is an error during 
 * the building of mapping structure.
 */
public class WrongMappingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2887101185628254926L;

	public WrongMappingException() {
		super();
	}

	public WrongMappingException(String msg) {
		super(msg);
	}
	
	public WrongMappingException(String msg, Throwable e) {
		super(msg, e);
	}
}
