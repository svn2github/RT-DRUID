/*
 * Created on 11-nov-2004
 *
 * $Id: OilTransformException.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.exceptions;

/**
 * TODO add comments
 *
 * @author Nicola Serreli
 */
public class OilTransformException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5997875805874103321L;
	public OilTransformException() {};
    public OilTransformException(String msg) { super(msg); };
    public OilTransformException(String msg, Throwable e) { super(msg, e); };
}
