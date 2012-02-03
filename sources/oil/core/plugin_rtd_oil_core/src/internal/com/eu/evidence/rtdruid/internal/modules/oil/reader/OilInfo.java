/*
 * Created on 10-nov-2004
 *
 * $Id: OilInfo.java,v 1.2 2008/01/09 17:44:03 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.reader;

import org.w3c.dom.Document;

/**
 * @author Nicola Serreli
 */
public class OilInfo {
	protected String name;
	protected Document impl;
	protected Document appl;
	
	public OilInfo(String name, Document impl, Document appl) {
		this.impl = impl;
		this.appl = appl;
		this.name = name;
	}

	public Document getAppl() { return appl; }
	public Document getImpl() { return impl; }
	public String getName() { return name; }
}
