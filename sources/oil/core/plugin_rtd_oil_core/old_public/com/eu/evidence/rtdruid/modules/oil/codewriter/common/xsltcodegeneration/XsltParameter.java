package com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration;

import org.eclipse.core.runtime.Assert;

/**
 * 
 * A really simple parameter
 * 
 * @author Nicola Serreli
 *
 */
public class XsltParameter implements IXsltParameter {
	
	/** The ID */	
	protected String ID;
	/** The Value */	
	protected String value;

	public XsltParameter(String ID, String value) {
		Assert.isNotNull(ID);
		this.ID = ID;
		this.value = value;
	}
	
	public XsltParameter(String ID) {
		this(ID, null);
	}
	
	@Override
	public String getID() {
		return ID;
	}

	@Override
	public String getValue() {
		return value;
	}

}
