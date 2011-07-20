package com.eu.evidence.rtdruid.internal.modules.jscan.partialorder;

/**
 * 
 * This Exception is thrown if a proc is not found, for example in the mapped
 * list of a task.
 * 
 */
public class ProcNotFoundException extends WrongMappingException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2884064838167485235L;

	public ProcNotFoundException() {
		super();
	}

	public ProcNotFoundException(String msg) {
		super(msg);
	}

	public ProcNotFoundException(String msg, Throwable e) {
		super(msg, e);
	}
}
