package com.eu.evidence.rtdruid.modules.oil.cdt.ui.cygwin;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.eu.evidence.rtdruid.desk.RtdruidLog;

/**
 * This class uses the Windows (MS) command "reg" to access to the windows
 * register and get the CygWin installation path.
 * 
 * @author Nicola Serreli
 */
class AutoCygwindSearch {

	private static final List<String[]> reg_paths;
	
	static {
		ArrayList<String[]> tmp = new ArrayList<String[]>();
		
		// Cygwin <1.7 
		
		// path in the section "current user" 
		tmp.add(new String[] { "reg", "query",
			"\"HKCU\\SOFTWARE\\Cygnus Solutions\\Cygwin\\mounts v2\\/\"", "/v",
			"native" });

		// path in the section "local machine" 
		tmp.add(new String[] { "reg",
			"query",
			"\"HKLM\\SOFTWARE\\Cygnus Solutions\\Cygwin\\mounts v2\\/\"", "/v",
			"native" });

		// Cygwin =1.7 Su win 7 
		
		// path in the section "local machine" 
		tmp.add(new String[] { "reg",
			"query",
			"\"HKEY_LOCAL_MACHINE\\SOFTWARE\\Wow6432Node\\Cygwin\\setup\"", "/v",
			"rootdir" });

		// path in the section "local machine" 
		tmp.add(new String[] { "reg",
			"query",
			"\"HKEY_CURRENT_USER\\SOFTWARE\\Wow6432Node\\Cygwin\\setup\"", "/v",
			"rootdir" });

		
		reg_paths = Collections.unmodifiableList(tmp);
	}
	
	/**
	 * This method tries to get the CygWin installation path. Like
	 * <code>C:\cygwin</code>
	 * 
	 * @return the path found inside the windows register or null if not found
	 */
	static public String search() {
		String answer = null;
		for (int i=0; answer == null && i<reg_paths.size(); i++) {
			answer = search(reg_paths.get(i));
		}

		return answer;
	}

	/**
	 * Tries to run the specified command and then search for a valid string in
	 * the output of specified program.
	 * 
	 * @param prg
	 *            the command and its parameters
	 * 
	 * @return the path found inside the windows register or null if not found
	 */
	static protected String search(String[] prg) {
		StringBuffer buff = new StringBuffer();
		try {
			Process p = Runtime.getRuntime().exec(prg);
			InputStream in = p.getInputStream();
			if (in != null) {
				in = new BufferedInputStream(in);

				for (int v; (v = in.read()) != -1;) {
					buff.append((char) v);
				}
			}
		} catch (IOException e) {
			// do nothing
			//RtdruidLog.showDebug(e);
		}

		// to be sure that there is at least one new line at the end
		buff.append("\n");
		return parseBuffer(buff.toString(), prg[prg.length-1]);
	}

	/**
	 * Tries to parse the specified text, looking for the installation path.
	 * 
	 * @param buffer
	 *            the output of the reg command. Cannot be null.
	 * 
	 * @return the path found inside the specified string or null if not found
	 */
	protected static String parseBuffer(String buffer, final String prop_key) {
		final String reg_type = "REG_SZ";

		// the text is supposed to be in the form:
		// .... some text ... \n native REG_SZ __path__ \n ...

		String answer = null;
		int index = buffer.indexOf(prop_key);
		if (index != -1) {
			int end = buffer.indexOf('\n', index);
			String sub = buffer.substring(index + prop_key.length(), end - 1);

			index = sub.indexOf(reg_type);
			if (index != -1) {
				answer = sub.substring(index + reg_type.length());
				answer = answer.trim();
				if (answer.length() == 0) {
					answer = null;
				}
			}

		}

		return answer;
	}
}
