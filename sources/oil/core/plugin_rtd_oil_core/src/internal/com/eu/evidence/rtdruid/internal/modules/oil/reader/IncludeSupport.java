package com.eu.evidence.rtdruid.internal.modules.oil.reader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.eu.evidence.rtdruid.desk.RtdruidLog;

/**
 * This class tries to solve {@link #INCLUDE_KW include} requests, using
 * relative files, absolute and libraries.
 * 
 * 
 * @author Nicola Serreli
 * 
 */
public class IncludeSupport {

	protected String basePath;
	protected List<String> libPaths = new ArrayList<String>();

	public final static String INCLUDE_KW = "#INCLUDE";
	protected final static String INCLUDE_KW_lower = INCLUDE_KW.toLowerCase();

	/**
	 * Builds a new instance. The base path is used especially for the first
	 * file.
	 * 
	 * @param basePath
	 *            the base directory
	 */
	public IncludeSupport(String basePath) {
		if (basePath == null)
			throw new NullPointerException();
		this.basePath = basePath;
	}

	/**
	 * Adds a new LibPath. Should use absolute paths here, becuse they are not
	 * converted to absolute and used as they are.
	 * 
	 * @param libPath
	 *            a new path
	 */
	public void addLibPath(String libPath) {

		if (libPath != null && !libPaths.contains(libPath)) {
			libPaths.add(libPath);
		}

	}

	/**
	 * Adds some new LibPath. Should use absolute paths here, becuse they are
	 * not converted to absolute and used as they are.
	 * 
	 * @param libPath
	 *            a list of new path (not null)
	 */
	public void addLibPath(List<String> libs) {
		for (String path : libs) {
			addLibPath(path);
		}
	}

	/**
	 * Tries to solve inclusions. If the given path is absolute, the file is
	 * searched directly. Otherwise is checked the option useLibPath: if false,
	 * the file is searched inside the basePath; if true the file is searched
	 * inside a library directory.
	 * 
	 * @param fileName
	 *            the file that should be parsed. Can be an absolute path, or a
	 *            path relative to the base directory or a path relative to a
	 *            library directory.
	 * @param useLibPath
	 *            the file is a library file (useful only with relative paths)
	 * 
	 * @return the result of the recursive inclusion of all files.
	 * 
	 * @throws IOException
	 *             if there is any problem reading files
	 */
	public String compose(String fileName, boolean useLibPath)
			throws IOException {
		return compose(new Stack<String>(), basePath, fileName, useLibPath)
				.toString();
	}

	/**
	 * Tries to solve inclusions. If the file path is not specified, this stream
	 * can include only absolute paths and libraries.
	 * 
	 * @param input
	 *            the stream that should be parsed.
	 * @param fileName
	 *            the name of the file (used only in error messages)
	 * @param filePath
	 *            used to include relative paths
	 *            
	 * @return the result of the inclusion.
	 * 
	 * @throws IOException if there is any problem reading files
	 */
	public String compose(InputStream input, String fileName, String filePath)
			throws IOException {
		Stack<String> st = new Stack<String>();
		st.push(filePath+File.separatorChar+fileName);
		return parse(st, input, fileName, filePath).toString();
	}

	/**
	 * Tries to solve inclusions. If the given path is absolute, the file is
	 * searched directly. Otherwise is checked the option useLibPath: if false,
	 * the file is searched inside the basePath; if true the file is searched
	 * inside a library directory. Uses { @link parse} method.
	 * 
	 * @param parsedFiles
	 *            already visited files. (to prevent cycles)
	 * @param parentPath
	 *            path of the file that asked to include this one. Used to solve
	 *            "relative" paths
	 * @param fileName
	 *            the file that should be parsed. Can be an absolute path, or a
	 *            path relative to the base directory or a path relative to a
	 *            library directory.
	 * @param useLibPath
	 *            the file is a library file (useful only with relative paths)
	 * 
	 * @return the result of the recursive inclusion of all files.
	 * 
	 * @throws IOException
	 *             if there is any problem reading files
	 * 
	 */
	protected StringBuffer compose(Stack<String> parsedFiles,
			String parentPath, String fileName, boolean useLibPath)
			throws IOException {
		IPath p;
		if (useLibPath) {
			p = searchLib(fileName);

			if (p == null) {
				throw new IOException("Cannot read the lib file " + fileName);
			}

		} else {
			// convert the file name in a File (and then in the absolute path)
			p = new Path(fileName);
			if (!p.isAbsolute()) {
				if (parentPath == null) {
					throw new IOException("Cannot find the file " + fileName);
				}
				p = new Path(parentPath);
				p = p.append(fileName);
			}
		}

		File f = p.toFile();
		if (!f.exists() || !f.canRead() || !f.isFile()) {
			// Messages.sendWarning("The file " + , detailedText, errorCode,
			// otherInfo)

			throw new IOException("Cannot read the file " + f.getAbsolutePath());
			// return result;
		}
		String absPath = f.getAbsolutePath();

		if (parsedFiles.contains(absPath)) {
			throw new IOException("Found a cyclic " + absPath);
		}

		parsedFiles.push(absPath);
		final String localPath;
		{
			File tmp = f.getParentFile();
			
			if (tmp == null && absPath != null){
				File absFile = new File(absPath);
				tmp = absFile.getParentFile();
			}
			
			if (tmp != null) {
				localPath = tmp.getAbsolutePath();
			} else {
				// ???? a file has always a parent !!!
				localPath = parentPath;
			}
		}

		// parse current file
		InputStream input = new BufferedInputStream(new FileInputStream(f));
		StringBuffer result = parse(parsedFiles, input, absPath, localPath);

		// end parse
		parsedFiles.pop();
		return result;
	}

	/**
	 * Tries to solve inclusions. If the file path is not specified, this stream
	 * can include only absolute paths and libraries.
	 * 
	 * @param parsedFiles
	 *            already visited files. (to prevent cycles)
	 * @param input
	 *            the stream that should be parsed.
	 * @param fileName
	 *            the name of the file (used only in error messages)
	 * @param filePath
	 *            used to include relative paths
	 *            
	 * @return the result of the inclusion.
	 * 
	 * @throws IOException if there is any problem reading files
	 */
	protected StringBuffer parse(Stack<String> parsedFiles, InputStream input,
			String fileName, String filePath) throws IOException {
		StringBuffer result = new StringBuffer();

		try {
			int a;
			int index = 0;
			while ((a = input.read()) != -1) {

				if (index < INCLUDE_KW.length()) {
					if (a == INCLUDE_KW.charAt(index)
							|| a == INCLUDE_KW_lower.charAt(index)) {
						index++;
					} else {
						index = 0;
					}

					// add the char
					result.append((char) a);

				} else {
					index = 0;

					// FOUND INCLUDE_KW
					result.setLength(result.length() - INCLUDE_KW.length());

					// try to get the file name

					while (true) {
						if (a == -1) {
							throw new IOException("Premature end of file "
									+ fileName);
						}
						if (!(Character.isWhitespace((char) a)))
							break;
						a = input.read();
					}

					final boolean defLib;
					final char end;

					if (((char) a) == '"') {
						defLib = false;
						end = '"';
					} else if (((char) a) == '<') {
						defLib = true;
						end = '>';
					} else {
						throw new IOException(
								"Found an invalid Premature end of file "
										+ fileName);
					}

					StringBuffer child = new StringBuffer();
					while (true) {
						a = input.read();
						if (a == -1) {
							throw new IOException("Premature end of file "
									+ fileName);
						} else if (((char) a) == end) {
							break;
						}

						child.append((char) a);
					}

					result.append(compose(parsedFiles, filePath, child
							.toString(), defLib));

				}

			}
		} catch (FileNotFoundException e) {
			// not possible (the file is checked before the open operation)
			RtdruidLog.log(e);
		}

		// end parse
		return result;
	}

	/**
	 * Searches the library file identified by the given file name. If there is
	 * more than one file with the same name in different paths, returns the
	 * first one and log the error Otherwise, if there is no match, returns
	 * null.
	 * 
	 * @param fileName
	 *            a string that identifies the file inside a library directory
	 * 
	 * @return the first file that match with the given name or null if none is
	 *         found.
	 */
	protected IPath searchLib(String fileName) {
		IPath answer = null;

		// if the path is absolute, is not a real "library path"
		IPath tmp = new Path(fileName);
		if (tmp.isAbsolute()) {
			answer = tmp;
		} else {

			// search in any library path
			// if found, continue to search to check for not-unique file names
			for (String libBase : libPaths) {

				tmp = new Path(libBase);
				tmp = tmp.append(fileName);

				File f = tmp.toFile();
				if (f.exists() && f.canRead() && f.isFile()) {

					if (answer != null) {
						RtdruidLog.log("Warning found multiple match for the oil library "
										+ fileName);
					} else {
						answer = tmp;
					}
					// don't break but continue to check any libPath
				}
			}
		}

		return answer;
	}

}
