package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.HostOsUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OsType;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.IXsltParameter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.XsltParameterProvider;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.location.EEPaths;

public class EEParameterProvider extends XsltParameterProvider {
	public final static String EE_BASE_PARAMETER_ID = "eebase";
	
	protected class EEBaseParameter implements IXsltParameter {
		@Override
		public String getID() {
			return EE_BASE_PARAMETER_ID;
		}
		
		
		@Override
		public String getValue() {
			OsType wrapper = HostOsUtils.common.getTarget();
			final String eeBasePath = options.containsKey(IWritersKeywords.ERIKA_ENTERPRISE_LOCATION) ?
					(String) options.get(IWritersKeywords.ERIKA_ENTERPRISE_LOCATION) : EEPaths.getEe_base();
			return eeBasePath != null ? wrapper.wrapPath(eeBasePath) : "";
		}
	}

	public EEParameterProvider() {
		set(new EEBaseParameter());
	}

}
