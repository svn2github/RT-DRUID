/*
 * Created on 10-dic-2006
 *
 * $Id: SearchTemplates.java,v 1.3 2007/03/12 13:40:55 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.project.templates;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.eu.evidence.templates.Activator;

/**
 * This class searchs and loads all "Evidence Template configuration file"s.
 * Those files are stored inside subdirectories of a specified path:
 * 
 * <b>template_root/ </b> is the specified path, that contains :<br>
 * <b>sub_dir_1/configFile.xml </b> <br>
 * <b>sub_dir_2/configFile.xml </b> <br>
 * <b>sub_dir_3/configFile.xml </b> <br>
 * 
 * The default name of configFile is stored inside
 * {@link DEFAULT_CONFIG_NAME DEFAULT_CONFIG_NAME }attribute.
 * 
 * @author Nicola Serreli
 */
public class SearchTemplates {

	/** The default name of a "Evidence Template configuration file" */
	public final static String DEFAULT_CONFIG_NAME = "template.xml";

	/**
	 * This metod searches and parses all configFiles inside every subdirectory
	 * of specified root directory. The name of configuration files is the one
	 * specified by configName parameter.
	 * 
	 * @param template_root
	 *            identifies a path inside the filesystem where look for config
	 *            files.
	 * @param configName
	 *            the name of configuration files
	 * 
	 * @return a no-null array of found and valid templates
	 */
	public static ExampleTemplate[] getConfigTemplates() {
		
		ITemplatesFolder[] exp_paths = ExpTemplateCollector.getTemplates();
		String[] paths = new String[exp_paths.length];
		for (int i = 0; i<exp_paths.length; i++) {
			paths[i] = exp_paths[i].getPath(); 
		}
		return getConfigTemplates(paths, DEFAULT_CONFIG_NAME);
	}

	/**
	 * This metod searches and parses all configFiles inside every subdirectory
	 * of specified root directory. The name of configuration files is the one
	 * specified by configName parameter.
	 * 
	 * @param template_root
	 *            identifies a path inside the filesystem where look for config
	 *            files.
	 * @param configName
	 *            the name of configuration files
	 * 
	 * @return a no-null array of found and valid templates
	 */
	public static ExampleTemplate[] getConfigTemplates(String[] template_roots,
			String configName) {
		
		ArrayList<ExampleTemplate> answer = new ArrayList<ExampleTemplate>();
		
		
		for (String template_root: template_roots) {
			/* 1) Search all files inside the specified root. */
			String[] files = getConfigFiles(template_root, configName);
			for (int i = 0; i < files.length; i++) {
	
				/* 2) Parse every found file and store it if there is no error. */
				ExampleTemplate ext = loadTemplate(files[i]);
				if (ext != null) {
					answer.add(ext);
				}
			}
		}

		/* 3) Return all valid templates. */
		return (ExampleTemplate[]) (answer.toArray(new ExampleTemplate[answer
				.size()]));
	}
	
	/**
	 * This metod searches and parses all configFiles inside every subdirectory
	 * of specified root directory. The name of configuration files is the one
	 * specified by configName parameter.
	 * 
	 * @param template_root
	 *            identifies a path inside the filesystem where look for config
	 *            files.
	 * @param configName
	 *            the name of configuration files
	 * 
	 * @return a no-null array of found and valid templates
	 */
	public static ExampleTemplate[] getConfigTemplates(String template_root,
			String configName) {
		ArrayList<ExampleTemplate> answer = new ArrayList<ExampleTemplate>();
		/* 1) Search all files inside the specified root. */
		String[] files = getConfigFiles(template_root, configName);
		for (int i = 0; i < files.length; i++) {

			/* 2) Parse every found file and store it if there is no error. */
			ExampleTemplate ext = loadTemplate(files[i]);
			if (ext != null) {
				answer.add(ext);
			}
		}

		/* 3) Return all valid templates. */
		return (ExampleTemplate[]) (answer.toArray(new ExampleTemplate[answer
				.size()]));
	}

	/**
	 * This metod search all configFiles inside every subdirectory of specified
	 * root directory. The name of configuration files is the one specified by
	 * configName parameter.
	 * 
	 * @param template_root
	 *            identifies a path inside the filesystem where look for config
	 *            files.
	 * @param configName
	 *            the name of configuration files
	 * 
	 * @return a no-null array of strings that contains the list of found files,
	 *         a relative path, like "sub_dir_1/configName"
	 */
	static String[] getConfigFiles(String template_root, String configName) {

		ArrayList<String> answer = new ArrayList<String>();
		
		getConfigFiles(template_root, configName, answer);
		
		return (String[]) answer.toArray(new String[answer.size()]);
	}

	/**
	 * This metod, recursively, searches all configFiles inside every
	 * subdirectory of specified root directory. The name of configuration files
	 * is the one specified by configName parameter.
	 * 
	 * @param template_root
	 *            identifies a path inside the filesystem where look for config
	 *            files.
	 * @param configName
	 *            the name of configuration files
	 * @param found
	 *            contains the list of found values
	 */
	protected static void getConfigFiles(String template_root, String configName, ArrayList<String> found) {

		// check if given path is a directory
		File rootDir = new File(template_root);
		if (!(rootDir.isDirectory() && rootDir.canRead() && rootDir.exists())) {
			return;
		}
		
		// try to get the list of files and directories in this directory 
		String[] children = rootDir.list();
		
		if (children == null) 
			return; // nothing to do
		
		// check every child
		for (int i=0; i<children.length; i++) {
			File child = new File(template_root, children[i]);

			if ( child.isDirectory() && child.canRead() && child.exists() ) {
				// check if this sub-directory contains the configFile
				
				File confFile = new File(template_root+File.separatorChar+children[i], configName);
				if ( confFile.isFile() && confFile.canRead() && confFile.exists() ) {
					found.add(template_root+File.separatorChar+children[i] +File.separatorChar+configName);
				} else {
					getConfigFiles(template_root+File.separatorChar+children[i], configName, found);
				}
			}
		}
	}

	/**
	 * This method loads and parses the specified template file from fileSystem.
	 * 
	 * @param fs_path
	 *            identifies the file inside the file System
	 * 
	 * @return the loaded template or null if there was some error.
	 */
	static ExampleTemplate loadTemplate(String fs_path) {

		ExampleTemplate answer = null;
		try {
			File f = new File(fs_path);			
			FileInputStream fis = new FileInputStream(f);
			answer = loadTemplate(fis, f.getParent(), f.getName());
		} catch (FileNotFoundException e) {
			Activator.log(e);
		}

		return answer;
	}

	/**
	 * This method loads and parses the specified template file from an
	 * InputStream.
	 * 
	 * @param configFile
	 *            a stream to load the config file
	 * @param fs_basePath
	 *            is the directory that contains the template configuration file
	 * @param fs_tempateName
	 *            is the name of template configuration file
	 */
	static ExampleTemplate loadTemplate(InputStream configFile, final String fs_basePath, final String fs_templateName) {

		// parse the file and store it as an XML document
		Document doc = null;
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringElementContentWhitespace(true);
			factory.setIgnoringComments(true);
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			doc = builder.parse(configFile);
						
		}catch(IOException e){
			Activator.log(e);
//			throw new TemplateParserException("Cannot open the config file", e);
		}catch(ParserConfigurationException e){
			Activator.log(e);
//			throw new TemplateParserException("Cannot open the config file", e);
		}catch(SAXException e){
			Activator.log(e);
//			throw new TemplateParserException("Cannot parse the config file", e);
		}

		// convert the XML Document into a list of ExampleTemplate 
		ExampleTemplate answer = null;
		if (doc != null) {
			TemplateParser tp = new TemplateParser(doc, fs_basePath);
			try {
				answer = tp.parse();
			} catch (TemplateParserException e) {
				Activator.log(e);
			}
		}
		
		return answer;
	}


	// ---------------- COPY FILES ----------------------
	
	/**
	 * This class copies example files specified inside a template configuration
	 * file, into a specified project or fileSystem directory.
	 * 
	 */
	public static class CopyExampleFiles {


		protected final ExampleTemplate template;

		/**
		 * Creates a new Parser for the speified XML document
		 * 
		 * @param doc
		 *            the XML to parse
		 */
		public CopyExampleFiles(ExampleTemplate template) {
			this.template = template;
		}
		
		/**
		 */
		public void copyIntoAProject(IProject project, IProgressMonitor monitor) throws CoreException, IOException {
			ExampleTemplate.ExampleFile[] files = template.getExampleFiles();
			
			for (int i=0; i<files.length; i++) {
				ExampleTemplate.ExampleFile f = files[i];
				InputStream is = f.getContent();
				if (is!= null) {
					IFile res = project.getFile(f.getName());
					if (res.exists())
						res.setContents(is, true, false, monitor);
					else
						res.create(is, true, monitor);
					is.close();
				}
			}
		}

		/**
		 */
		public void copyIntoAFSDirectory() {
			throw new UnsupportedOperationException("Da finire");
		}
		
	}
	
}
