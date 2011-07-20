package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import com.eu.evidence.modules.oil.erikaenterprise.constants.EEPaths;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.HostOsUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.IXsltParameter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.xsltcodegeneration.XsltParameterProvider;

public class EEParameterProvider extends XsltParameterProvider {
	public final static String EE_BASE_PARAMETER_ID = "eebase";
	
	protected class EEBaseParameter implements IXsltParameter {
		@Override
		public String getID() {
			return EE_BASE_PARAMETER_ID;
		}
		
		
		@Override
		public String getValue() {
			HostOsUtils wrapper = HostOsUtils.common;
			final String eeBasePath = EEPaths.getEe_base();
			return eeBasePath != null && wrapper != null ? wrapper.wrapPath(eeBasePath) : "";
		}
	}

	public EEParameterProvider() {
		set(new EEBaseParameter());
	}

}
