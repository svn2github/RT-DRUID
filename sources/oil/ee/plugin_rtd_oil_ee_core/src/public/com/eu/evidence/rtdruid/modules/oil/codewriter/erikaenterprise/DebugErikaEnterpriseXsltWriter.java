package com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise;

import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseXsltWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.HistoryXsltDebugger;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.IXsltDebugger;
import com.eu.evidence.rtdruid.modules.oil.codewriter.options.OptionsManager;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.tools.Search;

public class DebugErikaEnterpriseXsltWriter extends ErikaEnterpriseXsltWriter {
	
	

	public DebugErikaEnterpriseXsltWriter(String id, IVarTree vt) throws OilCodeWriterException {
		super(id, new ErikaEnterpriseWriter(), SWCategoryManager.EMPTY_CATEGORY);
		parent.init(vt, Search.allRtos(vt.newTreeInterface()), OptionsManager.getOptions());
		setOilId("ee");
		
		super.setDebugger(new HistoryXsltDebugger());
	}
	
	public void setDebugger(IXsltDebugger debugger) {
		throw new UnsupportedOperationException();
	}
	
	public IOilWriterBuffer[] write(IVarTree vt) throws OilCodeWriterException {
		((HistoryXsltDebugger)debugger).setVarTree(vt);
		
		IOilWriterBuffer[] answer = super.write(vt);
		
		((HistoryXsltDebugger)debugger).setOutputs(answer);
		return answer;
	}
}
