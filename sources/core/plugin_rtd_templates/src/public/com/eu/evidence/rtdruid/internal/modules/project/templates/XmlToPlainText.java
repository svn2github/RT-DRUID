package com.eu.evidence.rtdruid.internal.modules.project.templates;

import java.util.ArrayList;

/**
 * This class can be used to convert a xml-like text into an equivalent plain text 
 * 
 */
public class XmlToPlainText {
	
	/** If true, the converter will try to collapse all white spaces. It also removes
	 * new lines if the following character is not a full stop.*/
	private boolean collapseWhiteSpaces = true;
	
	/**
	 * This function tries to convert an xml-like text to plane text, removing a lot of
	 * not-usable things 
	 * 
	 * @param input
	 * @return
	 */
	public String convert(String input) {
		StringBuffer answer = new StringBuffer();
		
		input = links(input);
		input = elementBR(input);
		input = elementP(input);

		input = collapseSpaces(input);
		
		input = elementli(input);

		
		//input = collapseSpaces(input);
		{
			String[] tmp = splitString(input, 70);
			
			for (String str : tmp) {
				if (str.length()>0)
					answer.append(str + "\n");
			}
		}
		
		
		return answer.toString();
	}
	
	
	/**
	 * This function tries to collapse all not useful whitespace in one. Moreover,
	 * it replaces new lines a spaces if there isn't any full (.) stop or colon (:) 
	 * before the new line.
	 */
	private String collapseSpaces(String input) {
		if (!collapseWhiteSpaces) {
			return input;
		}
		
		
		StringBuffer answer = new StringBuffer();
		
		// this var is used to say if is necessary or not to store the next white space
		boolean store = false;
		char lc = '\n'; // last char
		for (int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			
			// ignore this char
			if (c == '\r') {
				continue;
			}
			
			
			// check \n
			if (c == '\n') {
				if (lc != '.' && lc != ':') {
					c = ' ';// consider this new line as a simple white space
				} else {
					store = true; // force to store this char 
					lc = c; // but only once 
				}
			}
			
			
			
			// check general white spaces
			if (Character.isWhitespace(c)) {
				if (store) {
					answer.append(c);
					store = false;
				}
			} else {
				// store all not spaces
				answer.append(c);
				lc = c;
				store = true;
			}
			
		}
		
		
		return answer.toString();
	}

	
	
	
	/**
	 * This function converts hyperlinks in plain text, as 
	 * 
	 * "... description ... (http://link)"
	 */
	private String links(String input) {
		StringBuffer answer = new StringBuffer();
		
		// Example of link: 
		// <a href="http://....">text</a>
		
		
		for (int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			
			// ignore this char
			if (c == '<') {
				StringBuffer buff = new StringBuffer();
				buff.append(c);

				// look for "a"
				boolean found = false;
				for (i++; i<input.length() && !found; i++) {
					c = input.charAt(i);
					buff.append(c);
					
					if (Character.isWhitespace(c)) {
						continue; // next char
					} else if (c == 'a' || c == 'A'){
						found = true;
					} else {
						break; // wrong char
					}
				}
				
				if (found == false) {
					// nothing to do with this block
					answer.append(buff);
					continue; // next char
				}
				
				// get href
				int href_index = (input.toLowerCase()).indexOf("href", i);
				int close_index = input.indexOf(">", i);

				if (href_index > close_index || href_index < 0 || close_index < 0) {
					// nothing to do with this block
					answer.append(buff);
					continue; // next char
				}
				
				

				int ref_start_index = input.indexOf("\"", href_index);
				int ref_stop_index = ref_start_index <0 ? -1 : input.indexOf("\"", ref_start_index+1);

				if (ref_stop_index > close_index || ref_start_index < 0 || ref_stop_index < 0) {
					// nothing to do with this block
					answer.append(buff);
					continue; // next char
				} 
					
				
				// loock for conclusion
				int href_end = (input.toLowerCase()).indexOf("</a", close_index);
				int href_stop = href_end <0 ? -1 : input.indexOf(">", href_end);

				
				if (href_end < 0 || href_stop < 0) {
					// nothing to do with this block
					answer.append(buff);
					continue; // next char
				} 
				
				
				String ref= input.substring(ref_start_index+1, ref_stop_index);
				String descr= input.substring(close_index+1, href_end);
				
				
				
				// append the link and update the index
				answer.append(" " + descr + " (" + ref + ")");
				i = href_stop +1;
				
				
			} else {
				// add this char
				answer.append(c);
			}
			
		}
		
		
		return answer.toString();
	}

	
	
	
	/**
	 * This function converts br elements in new lines
	 */
	private String elementBR(String input) {
		StringBuffer answer = new StringBuffer();
		
		// Example of link: 
		// <a href="http://....">text</a>
		
		
		for (int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			
			// ignore this char
			if (c == '<') {
				StringBuffer buff = new StringBuffer();
				buff.append(c);

				// look for "br"
				final int END = -100;
				final int ERR = -1;
				int phase = 1; 
				for (i++; i<input.length(); i++) {
					c = input.charAt(i);
					buff.append(c);
					
					
					switch (phase) {
					
					// Phase 1 : looking for B, ignoring / and white space
						case 1:
							if (Character.isWhitespace(c)) {
								// continue; // next char
							} else if (c=='/') {
								phase = 2; // don't accept more /
							} else if (c == 'b' || c == 'B'){
								phase = 3; 
							} else {
								phase = ERR;
							}
							
							break;

					// Phase 2 : looking for B, ignoring white space
						case 2:
							if (Character.isWhitespace(c)) {
								// continue; // next char
							} else if (c == 'b' || c == 'B'){
								phase = 3; 
							} else {
								phase = ERR;
							}
							break;

					// Phase 3 : looking for R
						case 3:
							if (c == 'r' || c == 'R'){
								phase = 4; 
							} else {
								phase = ERR;
							}
							break;


					// Phase 4 : looking for >  ignoring / and white space
						case 4:
							if (Character.isWhitespace(c)) {
								// continue; // next char
							} else if (c=='/') {
								phase = 5; // don't accept more /
							} else if (c == '>'){
								phase = END; 
							} else {
								phase = ERR;
							}
							break;

					// Phase 5 : looking for >  ignoring / and white space
						case 5:
							if (Character.isWhitespace(c)) {
								// continue; // next char
							} else if (c == '>'){
								phase = END; 
							} else {
								phase = ERR;
							}
							break;

					}
					
					
					if (phase <0) {
						break; // exit from this loop
					}
				}
				
				// else phase == END
				if (phase == END) {
					answer.append("\n");

				} else  { //if (phase == ERR)
					
					// nothing to do with this block
					answer.append(buff);
				}
				
			} else {
				// add this char
				answer.append(c);
			}
			
		}
		
		
		return answer.toString();
	}

	/**
	 * This function converts br elements in new lines
	 */
	private String elementP(String input) {
		StringBuffer answer = new StringBuffer();
		
		// Example of link: 
		// <a href="http://....">text</a>
		
		
		for (int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			
			// ignore this char
			if (c == '<') {
				StringBuffer buff = new StringBuffer();
				buff.append(c);

				// look for "br"
				final int END = -100;
				final int ERR = -1;
				int phase = 1; 
				for (i++; i<input.length(); i++) {
					c = input.charAt(i);
					buff.append(c);
					
					
					switch (phase) {
					
					// Phase 1 : looking for B, ignoring / and white space
						case 1:
							if (Character.isWhitespace(c)) {
								// continue; // next char
							} else if (c=='/') {
								phase = 2; // don't accept more /
							} else if (c == 'p' || c == 'P'){
								phase = 3; 
							} else {
								phase = ERR;
							}
							
							break;

					// Phase 2 : looking for B, ignoring white space
						case 2:
							if (Character.isWhitespace(c)) {
								// continue; // next char
							} else if (c == 'p' || c == 'P'){
								phase = 3; 
							} else {
								phase = ERR;
							}
							break;

					// Phase 3 : looking for >  ignoring / and white space
						case 3:
							if (Character.isWhitespace(c)) {
								// continue; // next char
							} else if (c=='/') {
								phase = 4; // don't accept more /
							} else if (c == '>'){
								phase = END; 
							} else {
								phase = ERR;
							}
							break;

					// Phase 4 : looking for >  ignoring / and white space
						case 4:
							if (Character.isWhitespace(c)) {
								// continue; // next char
							} else if (c == '>'){
								phase = END; 
							} else {
								phase = ERR;
							}
							break;

					}
					
					
					if (phase <0) {
						break; // exit from this loop
					}
				}
				
				// else phase == END
				if (phase == END) {
					answer.append("\n");

				} else  { //if (phase == ERR)
					
					// nothing to do with this block
					answer.append(buff);
				}
				
			} else {
				// add this char
				answer.append(c);
			}
			
		}
		
		
		return answer.toString();
	}

	

	/**
	 * This function converts br elements in new lines
	 */
	private String elementli(String input) {
		
		String answer = input.replaceAll("<li>", "\n* ");
		answer = answer.replaceAll("<ul>", "");
		answer = answer.replaceAll("</ul>", "");
		answer = answer.replaceAll("</li>", "\n");
				
		return answer;
	}
	
	
	/**
	 * Takes a String and split it in many rows. The length of each rows is the
	 * specified size (as max), and the point of split is the last white space
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
			return new String[0];
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
				while (pos < tmp.length()) {

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
