package com.eu.evidence.rtdruid.modules.oil.erikaenterprise.location;

public class EE_src_distr {
	public static enum Reporter {
		/**
		 * RT-Druid Configuration file
		 */
		RTD_CONFIGURATION,
		/**
		 * Extension point to sources located inside an eclipse plugin 
		 */
		EXTPOINT_PLUGIN_SOURCES,
		/**
		 * Extension point to sources located somewhere in the filesystem
		 */
		EXTPOINT_FILESYSTEM_SOURCES;
	};
	
	
	public final Reporter reported_by;

	public final String version;
	public final String erikaFilesLocation;
	public final String contribPath;
	
	public EE_src_distr(String version, String eeLocation, String contrib, Reporter reportedBy) {
		
		this.version = version;
		this.contribPath = contrib;
		this.erikaFilesLocation = eeLocation;
		this.reported_by = reportedBy;
	}
	
	@Override
	public String toString() {
		return "Ver. (" + version + "); ee location ("+erikaFilesLocation+"); contrib ("+contribPath+")";
	}
}
