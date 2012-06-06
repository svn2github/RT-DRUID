package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.util.HashMap;

import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.IncompatibleWriterKeywordsException;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.RequiredWriterKeywordsException;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.XsltWriter;
import com.eu.evidence.rtdruid.modules.oil.interfaces.ISWCategory;

public class ErikaEnterpriseXsltWriter extends XsltWriter {

	protected ErikaEnterpriseWriter parent;
	
	public ErikaEnterpriseXsltWriter() {
		this("ee", null, null);
	}

	public ErikaEnterpriseXsltWriter(ErikaEnterpriseWriter parent) {
		this("ee", parent, null);
	}

	public ErikaEnterpriseXsltWriter(String id, ErikaEnterpriseWriter parent, ISWCategory category) {
		super(id, category);
		this.parent = parent;
		setOilId("ee");
	}
	
	public void setCategory(ISWCategory category) {
		this.category = category;
	}
	
	public void checkKeys(String[] keys)
			throws IncompatibleWriterKeywordsException,
			RequiredWriterKeywordsException {
		// always good
	}
	public boolean enabled(String[] keys) {
		// return always true
		return true;
	}
	
	protected HashMap<String, IOilWriterBuffer> getMap(
			IOilWriterBuffer[] buffers) {
		
		HashMap<String, IOilWriterBuffer> map = super.getMap(buffers);
		
		IOilObjectList[] oils = parent.getOilObjects();
		for (int i=0; i<oils.length; i++) {
			// OS[0] is enough
			ISimpleGenRes sgr = oils[i].getList(IOilObjectList.OS).get(0);
			map.put(sgr.getName(), buffers[i]);
		}
		
		return map;
	}
	
	protected void computeRtos() {
		if (parent == null) {
			super.computeRtos();
		} else {
			rtosPrefix = parent.extractDistinctOs();
		}
	}
}
