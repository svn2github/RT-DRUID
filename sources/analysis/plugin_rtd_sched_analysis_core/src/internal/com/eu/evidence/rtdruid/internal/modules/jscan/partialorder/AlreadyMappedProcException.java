package com.eu.evidence.rtdruid.internal.modules.jscan.partialorder;

/**
 * This exception is thrown when a proc is mapped more than one time
 * to a single task.  
 */
public class AlreadyMappedProcException extends WrongMappingException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8284432151657238192L;

	public AlreadyMappedProcException() {
	}

	public AlreadyMappedProcException(String msg) {
		super(msg);
	}

	public AlreadyMappedProcException(String msg, Throwable e) {
		super(msg, e);
	}

}
