package com.eu.evidence.rtdruid.modules.oil.codewriter.common;

import org.eclipse.core.runtime.Platform;

/**
 * Collection of functions to handle the change of the host OS.
 * 
 * 
 * @author Nicola Serreli
 * 
 */
public class HostOsUtils {

	final static public HostOsUtils common = new HostOsUtils();
	
	protected OsType target;

	final protected OsType currentSystem;

	protected HostOsUtils() {
		if (Platform.getOS().equals(Platform.OS_WIN32) || 
				Platform.getOS().equals("win64")) {
			currentSystem = OsType.Cygwin;
		} else if (Platform.getOS().equals(Platform.OS_LINUX)) {
			currentSystem = OsType.Linux;
			
		} else {
			currentSystem = OsType.Unknown;
		}
		
		target = currentSystem;
	}

	public OsType getCurrentSystem() {
		return currentSystem;
	}
	
	/**
	 * @return the target
	 */
	public OsType getTarget() {
		return target;
	}
	
	/**
	 * @param target the target to set
	 */
	public void setTarget(OsType target) {
		if (target == null) {
			this.target = currentSystem;
		} else {
			this.target = target;
		}
	}
}
