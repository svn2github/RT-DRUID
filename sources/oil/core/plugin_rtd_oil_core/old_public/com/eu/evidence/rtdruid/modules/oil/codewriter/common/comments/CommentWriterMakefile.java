package com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments;

public class CommentWriterMakefile implements ICommentWriter {

	/**
	 * Should be used to identify files managed by this writer
	 */
	public static final String WRITER_ID = FileTypes.MAKEFILE;
	
	/**
	 * This method prepares a banner as a Comment in the MakeFile Style. Accepts
	 * null messages.
	 * 
	 * @param message
	 *            contains the message that will set inside the banner
	 * 
	 * @return a String that contains the banner
	 */
	public String writerBanner(String message) {
		// split the message in one or more rows
		String[] txt = CommentsManager.splitString(message, 75);
		StringBuffer answer = new StringBuffer(
				"\n\n"
						+ "############################################################################\n"
						+ "#\n");

		// write all rows
		for (int i = 0; i < txt.length; i++) {
			answer.append("# " + txt[i] + "\n");
		}
		answer
				.append("#\n"
						+ "############################################################################\n");
		return answer.toString();
	}

	
	/**
	 * This method prepares a Comment in the Cpp Style. Accepts null
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
		if (message == null) {
			message = "";
		} else if (message.indexOf('\n')>0) {
			return writerMultiLineComment(message);
		}

		return "# " + message + "\n";
	}

	/**
	 * This method prepares a Multiline Comment in the Cpp Style. Accepts null
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
		// split the message in one or more rows
		String[] txt = CommentsManager.splitString(message, 75);
		StringBuffer answer = new StringBuffer();

		// write all rows
		for (int i = 0; i < txt.length; i++) {
			answer.append(" # " + txt[i] + "\n");
		}
		
		return answer.toString();
	}

	/**
	 * This method prepares a Multiline Comment in the Cpp Style. Accepts null
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
		// split the message in one or more rows
		int row_size = 75 - indent.length();
		if (row_size < 30)
			row_size = 30;
		String[] txt = CommentsManager.splitString(message, row_size);
		StringBuffer answer = new StringBuffer();

		// write all rows
		for (int i = 0; i < txt.length; i++) {
			answer.append(indent + "# " + txt[i] + "\n");
		}
		
		return answer.toString();
	}

}
