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

	final static public int UNKNOWN = 0;

	final static public int CYGWIN = 1;
	final static public int LINUX = 2;

	final protected int currentSystem;

	public HostOsUtils() {
		if (Platform.getOS().equals(Platform.OS_WIN32) || 
				Platform.getOS().equals("win64")) {
			currentSystem = CYGWIN;
		} else if (Platform.getOS().equals(Platform.OS_LINUX)) {
			currentSystem = LINUX;
			
		} else {
			currentSystem = UNKNOWN;
		}
	}

	public int getCurrentSystem() {
		return currentSystem;
	}

	/**
	 * This function wraps paths, if needed
	 * 
	 * @param path
	 *            path in the file system
	 *            
	 * @return the same path, but protected if needed
	 */
	public String wrapPath(String path) {
		String answer = path;

		switch (currentSystem) {
		case CYGWIN:

			// protect '\' chars ?

			answer = "$(shell cygpath `cygpath -ms '" + path + "'`)";
			break;

		case LINUX:
			answer = path;
			break;

		case UNKNOWN:
		default:
			answer = path;
		}
		return answer;
	}
}
