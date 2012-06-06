/**
 * 17/mag/2012
 */
package com.eu.evidence.rtdruid.modules.oil.codewriter.common;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public enum OsType {
	Linux("linux"), Win("win"), Cygwin("cygwin"), Unknown("unknown");
	
	protected final String text;
	
	/**
	 * 
	 */
	private OsType(String text) {
		this.text = text;
	}
	
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
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

		switch (this) {
		case Cygwin:
		case Win:

			// protect '\' chars ?

			answer = "$(shell cygpath `cygpath -ms '" + path + "'`)";
			break;

		case Linux:
			answer = path;
			break;

		case Unknown:
		default:
			answer = path;
		}
		return answer;
	}

}
