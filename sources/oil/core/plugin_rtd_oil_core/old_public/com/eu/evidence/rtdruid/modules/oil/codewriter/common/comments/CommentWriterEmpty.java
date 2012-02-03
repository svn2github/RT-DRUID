package com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments;

public class CommentWriterEmpty implements ICommentWriter {


	/**
	 * This method prepares a banner as a Comment in the Asm Style. Accepts null
	 * messages.
	 * 
	 * @param message
	 *            contains the message that will set inside the banner
	 * 
	 * @return a String that contains the banner
	 */
	public String writerBanner(String message) {
		return "\n";
	}

	/**
	 * This method prepares a Comment in the Asm Style. Accepts null
	 * messages. If there is a new line, this function uses the multiline version.
	 * 
	 * The result always ends with a new line.
	 * 
	 * @param message
	 *            contains the message that will set inside the comment
	 * 
	 * @return a String that contains the comment
	 */
	public String writerSingleLineComment(String message) {
		return "\n";
	}

	/**
	 * This method prepares a Multiline Comment in the Asm Style. Accepts null
	 * messages.
	 * 
	 * The result always ends with a new line.
	 * 
	 * @param message
	 *            contains the message that will set inside the comment
	 * 
	 * @return a String that contains the comment
	 */
	public String writerMultiLineComment(String message) {
		return "\n";
	}

	/**
	 * This method prepares a Multiline Comment in the Asm Style. Accepts null
	 * messages.
	 * 
	 * The result always ends with a new line.
	 * 
	 * @param indent
	 *            white spaces before the comment start, at each line
	 * 
	 * @param message
	 *            contains the message that will set inside the comment
	 * 
	 * @return a String that contains the comment
	 */
	public String writerMultiLineComment(String indent, String message) {
		return "\n";
	}


}




