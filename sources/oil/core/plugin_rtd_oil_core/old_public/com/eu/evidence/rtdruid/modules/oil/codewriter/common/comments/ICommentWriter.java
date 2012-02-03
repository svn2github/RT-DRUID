package com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments;

public interface ICommentWriter {

	/**
	 * This method prepares a banner. Null messages are treated as empty
	 * messages. Usually a banner is a block of lines used only for the banner
	 * and it helps to easily identify a section in the generated code.
	 * 
	 * @param message
	 *            contains the message that will set inside the banner
	 * 
	 * @return a String that contains the banner
	 */
	public String writerBanner(String message);

	/**
	 * This method prepares a Comment that consume the current line. Null
	 * messages are treated as empty messages. If the message contains one
	 * or more new line characters, this function uses the multiline version.
	 * 
	 * The result always ends with a new line.
	 * 
	 * @param message
	 *            contains the message that will set inside the comment
	 * 
	 * @return a String that contains the comment
	 */
	public String writerSingleLineComment(String message);

	/**
	 * This method prepares a Multiline Comment, i.e. the message is formatted 
	 * in one or more rows depending on already present new line characters and
	 * row length, that usually has a maximum size.
	 * Null messages are treated as empty messages.
	 * 
	 * The result always ends with a new line.
	 * 
	 * @param message
	 *            contains the message that will set inside the comment
	 * 
	 * @return a String that contains the comment
	 */
	public String writerMultiLineComment(String message);

	/**
	 * This method prepares a Multiline Comment, i.e. the message is formatted 
	 * in one or more rows depending on already present new line characters and
	 * row length, that usually has a maximum size.
	 * This method accepts also a displacement that is put a the beginning of 
	 * each line.
	 * Null messages are treated as empty messages.
	 * 
	 * The result always ends with a new line.
	 * 
	 * Is not required that implementations checks that the indentation is
	 * composed by only white spaces.
	 * 
	 * @param indent
	 *            white spaces before the comment start, at each line. Cannot be null.
	 * 
	 * @param message
	 *            contains the message that will set inside the comment
	 * 
	 * @return a String that contains the comment
	 */
	public String writerMultiLineComment(String indent, String message);

}
