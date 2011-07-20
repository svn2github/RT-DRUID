/*
 * Created on Sep 7, 2004
 *
 * $Id: ValueNotFoundException.java,v 1.1 2005/09/28 15:22:29 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.jscan;

/**
 * @author Nicola Serreli
 */
public class ValueNotFoundException extends RuntimeException {
	public ValueNotFoundException(String msg) {
		super(msg);
	}
}
