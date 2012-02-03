package com.eu.evidence.modules.oil.erikaenterprise.constants;

public class EE_src_distr {

	public final String version;
	public final String srcPath;
	public final String contribPath;
	
	public EE_src_distr(String version, String src, String contrib) {
		this.version = version;
		this.contribPath = contrib;
		this.srcPath = src;
	}
	
	@Override
	public String toString() {
		return "Ver. (" + version + "); src ("+srcPath+"); contrib ("+contribPath+")";
	}
}
