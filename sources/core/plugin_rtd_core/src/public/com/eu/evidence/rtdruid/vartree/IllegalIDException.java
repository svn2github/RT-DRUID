package com.eu.evidence.rtdruid.vartree;

/** This exception is throwed if someone try to set an already used id */
 public class IllegalIDException extends RuntimeException {
 	
 	/**
	 * 
	 */
	private static final long serialVersionUID = -7398854963194066874L;
	
	public IllegalIDException() {}
 	public IllegalIDException(String message) { super(message); }
 }