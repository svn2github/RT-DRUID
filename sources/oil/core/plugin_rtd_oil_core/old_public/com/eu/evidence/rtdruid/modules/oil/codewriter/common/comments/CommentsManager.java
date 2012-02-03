package com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments;

import java.util.ArrayList;
import java.util.HashMap;

public class CommentsManager {
	
	protected CommentWriterEmpty default_empty = new CommentWriterEmpty();
	protected HashMap<String, ICommentWriter> writers = new HashMap<String, ICommentWriter>();
	
	public void setWriter(String fileType, ICommentWriter writer) {
		if (writer == null) {
			writers.remove(fileType);
		} else {
			writers.put(fileType, writer);
		}
	}

	public String writeBanner(String fileType, String text) {
		return getCommentWriter(fileType).writerBanner(text);
	}

	public String writeComment(String fileType, String text) {
		return getCommentWriter(fileType).writerSingleLineComment(text);
	}
	
	public String writeMultiLinesComment(String fileType, String text) {
		return getCommentWriter(fileType).writerMultiLineComment(text);
	}

	public String writeMultiLinesComment(String fileType, String indent, String text) {
		return getCommentWriter(fileType).writerMultiLineComment(indent, text);
	}

	public ICommentWriter getCommentWriter(String fileType) {
		if (writers.containsKey(fileType)) {
			return writers.get(fileType);
		}
		return default_empty;
	}

	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	public static CommentsManager getDefaultsWriters() {
		CommentsManager answer = new CommentsManager();
		answer.setWriter(FileTypes.H, new CommentWriterH());
		answer.setWriter(FileTypes.C, new CommentWriterC());
		answer.setWriter(FileTypes.CPP, new CommentWriterCpp());
		answer.setWriter(FileTypes.ASM, new CommentWriterAsm());
		answer.setWriter(FileTypes.ORTI, new CommentWriterC());
		answer.setWriter(FileTypes.MAKEFILE, new CommentWriterMakefile());
		
		return answer;
	}
	
	

	/**
	 * Takes a String and split it in many rows. The length of each rows is the
	 * specified size (as max), and the point of split is the last withe space
	 * (before that size). If a row hasn't any white space, the row's length
	 * could be bigger than size.
	 * 
	 * @param txt
	 *            the text
	 * @param size
	 *            the max length of each row (must be bigger than zero)
	 * 
	 * @throws IllegalArgumentException
	 *             if size isn't bigger than zero
	 */
	public static String[] splitString(String txt, int size) {
		if (size <= 0) {
			throw new IllegalArgumentException(
					"Is required a size bigger than zero");
		}

		if (txt == null) {
			return new String[] {""};
		}

		ArrayList<String> answer = new ArrayList<String>();

		// first split with \n
		String[] tmpStrings = txt.split("\n");

		// then split each string at the last white space before the "size"
		// if there is no white space, search in "2*size", "3*size" ...
		for (int i = 0; i < tmpStrings.length; i++) {
			if (tmpStrings[i].length() > size) {
				int pos = size;
				String tmp = tmpStrings[i];
				while (pos < tmpStrings.length) {

					int p = tmp.lastIndexOf(" ", pos);
					if (p == -1) {
						// search in a bigger string
						pos += size;
					} else if (p == 0) {
						// don't store an empty string
						tmp = tmp.substring(1);
						pos = size;
					} else {
						// split and go on
						answer.add(tmp.substring(0, p));
						tmp = tmp.substring(p + 1);
						pos = size;
					}

				}
				// add the last row
				if (tmp.length() != 0) {
					answer.add(tmp);
				}
			} else {
				// directly add the row
				answer.add(tmpStrings[i]);
			}
		}

		return (String[]) answer.toArray(new String[answer.size()]);
	}

}
