/*
 * Created on 10-dic-2006
 *
 * $Id: ExampleTemplate.java,v 1.3 2007/05/11 16:08:39 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.project.templates;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import com.eu.evidence.templates.Activator;

/**
 * This class contains all information about an Oil Example Template
 * 
 * @author Nicola Serreli
 */
public class ExampleTemplate {

	/** One single file : the full name (path + name) and the content */
	public static class ExampleFile {
		protected String name;
		protected String fs_path;
		protected InputStream content;
		
		/**
		 * Build a new example File
		 */
		public ExampleFile(String name, String fs_path) {
			this.name = name;
			this.fs_path = fs_path;
			this.content = null;
		}
		/**
		 * Build a new example File
		 */
		public ExampleFile(String name, String fs_path, InputStream content) {
			this.name = name;
			this.fs_path = fs_path;
			this.content = content;
		}
		/**
		 * @return Returns the content.
		 */
		public InputStream getContent() {
			if (content == null) {
				try {
					content = new FileInputStream(computeFsPath(fs_path, name));
				} catch (IOException e) {
					Activator.log(e);
				}
			}
			return content;
		}
		
		/**
		 * @return Returns the name.
		 */
		public String getName() {
			return name;
		}
		
		public String toString() {
			return "Name = "+name+ " -- fs = " + fs_path; 
		}
	}
	
	public class ExampleDirectory {
		// da finire
	}
	
	public class ExampleFileList {
		// da finire
	}
	
	/**
	 * An unique ID
	 */
	protected final String exampleID;
	
	/**
	 * The category of this example. Structured as a path, with element
	 * separated by / 
	 * It's used to show the example inside a tree
	 */
	protected final String category;

	/** The name of this Template (Showed to the user) */
	protected final String title;

	/** The short descritpion of this Template (Showed to the user) (can be null) */
	protected final String shortDescr;

	/**
	 * The long descritpion of this Template (Showed to the user) (cannnot be
	 * null)
	 */
	protected final String longDescr;

	/** The fileSystem path of this Template (cannot be null) */
	protected final String fs_path;

	/** The parser of template configuration file for this ExampleTemplate */
	protected final TemplateParser parser;

	
	
	/** The list of files the file_name and the ExampleFile object*/
	protected final HashMap<String, ExampleFile> files = new HashMap<String, ExampleFile>();
	
	// ----------------------------------------------------
	
	/**
	 * Creates a new template with specified values
	 * 
	 * @param category
	 *            identifies the category of this template
	 * @param title
	 *            the name of this Template (Showed to the user)
	 * @param shortDecr
	 *            The short descritpion of this Template (Showed to the user)
	 *            (can be null)
	 * @param longDecr
	 *            The long descritpion of this Template (Showed to the user)
	 *            (cannnot be null)
	 * @param fs_path
	 *            The fileSystem path of this Template (cannot be null)
	 * 
	 * @throws NullPointerException
	 *             if one of title, longDescr and fs_path is null.
	 */
	public ExampleTemplate(String category, String exampleID, String title, String shortDecr, String longDecr,
			String fs_path, TemplateParser parser) {
		if (title == null || longDecr == null || fs_path == null) {
			throw new NullPointerException();
		}
		this.exampleID = exampleID;
		this.category = category;
		this.title = title;
		this.shortDescr = shortDecr;
		this.longDescr = longDecr;
		this.fs_path = fs_path;
		this.parser = parser;
	}
	
	/**
	 * @return Returns the exampleID.
	 */
	public String getExampleID() {
		return exampleID;
	}
	
	/**
	 * @return Returns the category.
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * @return Returns the fs_path.
	 */
	public String getFs_path() {
		return fs_path;
	}
	
	/**
	 * @return Returns the longDescr.
	 */
	public String getLongDescr() {
		return longDescr;
	}
	
	/**
	 * @return Returns the shortDescr.
	 */
	public String getShortDescr() {
		return shortDescr;
	}
	
	/**
	 * @return Returns the title.
	 */
	public String getTitle() {
		return title;
	}
	
	// --------------------------------------------------------
	
	/**
	 * Returns a map ("String nameFile" - "ExampleFile object") that contains
	 * all files of this example
	 */
	public ExampleFile[] getExampleFiles() {
		
		
		// GET FILES from FILE_ELEMENTs
		try	{
			ArrayList<ExampleFile> arr = parser.parseFilesSection();
			for (int i=0; i<arr.size(); i++) {
				ExampleFile o = arr.get(i);
				String key = o.getName();
				if (!files.containsKey(key)) {
					files.put(key, o);
				}
			}
		} catch (TemplateParserException e) {
			Activator.log(e);
		}
		
		
		// GET FILES from DIRECTORY_ELEMENTs
//		try	{
//			ArrayList arr = parser.parseFilesSection();
//			for (int i=0; i<arr.size(); i++) {
//				Object o = arr.get(i);
//				Object key = (o instanceof ExampleFile) ? ((ExampleFile) o).getName() : o;
//				if (!files.containsKey(key)) {
//					files.put(key, o);
//				}
//			}
//		} catch (TemplateParserException e) {
//			Rtd_corePlugin.log(e);
//		}

		// GET FILES from FILES_ELEMENTs
//		try	{
//			ArrayList arr = parser.parseFilesSection();
//			for (int i=0; i<arr.size(); i++) {
//				Object o = arr.get(i);
//				Object key = (o instanceof ExampleFile) ? ((ExampleFile) o).getName() : o;
//				if (!files.containsKey(key)) {
//					files.put(key, o);
//				}
//			}
//		} catch (TemplateParserException e) {
//			Rtd_corePlugin.log(e);
//		}
		
		ArrayList<ExampleFile> answer = new ArrayList<ExampleFile>(files.values());
		Collections.sort(answer, new Comparator<ExampleFile>() {
			public boolean equals(Object obj) {
				// TODO Auto-generated method stub
				return false;
			}

			public int compare(ExampleFile o1, ExampleFile o2) {
				final String s1;
				if (o1 instanceof ExampleFile) {
					s1 = ((ExampleFile) o1).getName();
				} else {
					s1 = "" +o1;
				}
				final String s2;
				if (o2 instanceof ExampleFile) {
					s2 = ((ExampleFile) o2).getName();
				} else {
					s2 = "" +o2;
				}
				return s1.compareTo(s2);
			}
		});
		
		return (ExampleFile[]) answer.toArray(new ExampleFile[answer.size()]);
	}
	// --------------------------------------------------------
	
	public String toString() {
		StringBuffer tmp = new StringBuffer( 
			  "{ID  ="+exampleID + "\n"
			+ " Cat ="+category + "\n"
			+ " Tit =__"+title + "__\n"
			+ " sDes=__"+shortDescr + "__\n"
			+ " lDes=__"+longDescr + "__\n"
			+ " fils=__\n");
		ExampleFile[] vFiles = getExampleFiles();
		for (int i=0; i<vFiles.length; i++) {
			tmp.append("\t "+vFiles[i]+"\n");
		}
		tmp.append("      __\n}");
		return tmp.toString();
	}
	
	/**
	 * This method split a path in elements
	 * */
	public static final String[] splitPath(String path) {
		if (path != null) {
			return path.split("/");
		}
		return null;
	}
	
	/**
	 * This method returns the last element of a path
	 * 
	 * @return the last element of the path (can be the given path) or null, if
	 *         the path is null
	 *  
	 */
	public static final String lastElement(String path) {
		if (path != null) {
			int index = path.lastIndexOf("/");
			if (index>=0) {
				return path.substring(index+1);
			} 
			// else
			return path;
		}
		return null;
	}
	
	/**
	 * This method removes the last element of a path
	 * 
	 * @return the path without the last element or null, if there is only one
	 *         element (or if the path is null)
	 */
	public static final String removeLastElement(String path) {
		if (path != null) {
			int index = path.lastIndexOf("/");
			if (index>=0) {
				return path.substring(0,index);
			} 
			// else
			return null;
		}
		return null;
	}
	
	
	/**
	 * This method split a path in elements
	 * */
	public static final File computeFsPath(String basePath, String fileName) {
		return new File(basePath +File.separatorChar+fileName);
//		IPath pt = //new Path(basePath).append(fileName);
//		return pt.toFile();
	}

}

//---------------- PARSER -----------------------

/**
 * This class parse the template configuration file, structured as a XML
 * Document
 * 
 * @author Nicola Serreli
 */
class TemplateParser {

	final static String ELEM_ROOT = "evidence_example";
	final static String ELEM_CATEGORY = "category";
	final static String ELEM_TITLE = "title";
	final static String ELEM_SMALL_DESCR = "small_descr";
	final static String ELEM_LONG_DESCR = "long_descr";
	final static String ELEM_FILE_SECTION = "file_section";
	final static String ELEM_FILE = "file";
	final static String ELEM_DIRECTORY = "directory";
	final static String ELEM_FILE_LIST = "files";
	final static String ELEM_VAR_ID = "var_id";
	final static String ELEM_VARIABLE_SECTION = "variables";
	final static String ELEM_USER_VARIABLE = "user_var";
	final static String ELEM_GUI_NAME = "gui_name";
	final static String ELEM_DEFAULT_VALUE = "default";

	final static String ATTR_VERSION = "version";
	final static String ATTR_ID = "ID";
	final static String ATTR_NAME = "name";
	final static String ATTR_ALL_VARS = "vars";
	final static String ATTR_FILES_GROUP = "group";
	final static String ATTR_RECURSIVE = "recursive";
	final static String ATTR_VAR_TYPE = "type";
	final static String ATTR_VAR_REQUIRED = "required";


	protected final Document doc;
	/** The directory that contains the template configuration file */
	protected final String fs_basePath; 

	/**
	 * Creates a new Parser for the speified XML document
	 * 
	 * @param doc
	 *            the XML to parse
	 * @param fs_basePath
	 *            is the directory that contains the template configuration file (can be null)
	 */
	public TemplateParser(Document doc, String fs_basePath) {
		this.doc = doc;
		this.fs_basePath = fs_basePath == null ? "" : fs_basePath;
	}
	
	/**
	 * Ask to parse the document.
	 */
	protected ExampleTemplate parse() throws TemplateParserException {

		Element root = doc.getDocumentElement();
		String exampleID = root.getAttribute(ATTR_ID);
		String category = getChildText(root, ELEM_CATEGORY);
		String title = getChildText(root, ELEM_TITLE);
		String short_descr = getChildText(root, ELEM_SMALL_DESCR);
		String long_descr =  getChildText(root, ELEM_LONG_DESCR);
		
		ExampleTemplate answer = new ExampleTemplate(category, exampleID, title, short_descr, long_descr, fs_basePath, this); 
		
//		
//		// Variables
//		parseVars(root);
//		
		return answer;
	}
	
	
	/** Searchs every FILE Section */
	public ArrayList<ExampleTemplate.ExampleFile> parseFilesSection() throws TemplateParserException {

		ArrayList<ExampleTemplate.ExampleFile> answer = new ArrayList<ExampleTemplate.ExampleFile>();
		Element root = doc.getDocumentElement();

		// Store File Section
		NodeList nl = root.getElementsByTagName(ELEM_FILE_SECTION);
		for (int i=0; i<nl.getLength(); i++) {
			
			parseFileElement((Element) nl.item(i), answer);
		}
		
		return answer;
	}

	/** Searchs every file element */
	protected void parseFileElement(Element root, ArrayList<ExampleTemplate.ExampleFile> answer) throws TemplateParserException {

		// Files
		NodeList nl = root.getElementsByTagName(ELEM_FILE);
		for (int i=0; i<nl.getLength(); i++) {
			Element child = (Element) nl.item(i);
			String name = child.getAttribute(ATTR_NAME);
			if (name != null && name.length()>0) {
				// add a new file element
				answer.add(new ExampleTemplate.ExampleFile(name, fs_basePath));
			}
		}
	}
	
	/**
	 * 
	 * @param root
	 * @throws TemplateParserException
	 * 
	 * @deprecated Must be implementated
	 */
	protected void parseVars(Element root) throws TemplateParserException {

		// Files
		//NodeList nl = root.getElementsByTagName(ELEM_VARIABLE_SECTION);
	}

	
	/**
	 * This method searches a child of "parent" node with "childName" name.
	 * If there is atleast one, returns the text containes it the first, if
	 * it is a text node. If there is any problem, returns null.
	 * 
	 * @param parent
	 *            the parent node
	 * @param childName
	 *            the name of required child node (a text node)
	 * 
	 * @return the text contained in the child node or null if the child
	 *         node doesn't exist or isn't a text node
	 */
	protected String getChildText(Element parent, String childName) {
		NodeList nl = parent.getElementsByTagName(childName);
		if (nl.getLength()==0) 
			return null;
		
		Node child = nl.item(0).getFirstChild();
		
		if (child instanceof Text) {
			return ((Text) child).getData();
		}
		return null;
	}
	
}

/**
 * An exception during the parse of the configuration file.
 * */
class TemplateParserException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1736169449337106848L;
	public TemplateParserException() {
		super();
	}
	public TemplateParserException(String txt) {
		super(txt);
	}
	public TemplateParserException(String txt, Throwable cause) {
		super(txt, cause);
	}

}
