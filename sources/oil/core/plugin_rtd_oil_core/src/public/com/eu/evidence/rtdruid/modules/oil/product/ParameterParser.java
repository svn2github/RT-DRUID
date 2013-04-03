package com.eu.evidence.rtdruid.modules.oil.product;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.eu.evidence.rtdruid.desk.Logger;
import com.eu.evidence.rtdruid.desk.ReadVersion;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.IWorkerExampleWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.StdOutLogger;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.WorkerAllExampleWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.WorkerExampleList;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.WorkerExampleWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.WorkerOilConfWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.RtdruidConfiguratorNumber;
import com.eu.evidence.rtdruid.modules.oil.codewriter.options.PreferenceStorage;

public class ParameterParser {

	// help
	protected final static String HELP_KEY = "--help";
	protected final static String VERSION_KEY = "--version";

	
	// Build
	protected final static String INPUT_KEY = "--inputFile";
	protected final static String OUTPUT_KEY = "--outputDir";
	protected final static String CONF_FILE_KEY = "--preferenceFile";

	// Template List
	protected final static String LIST_KEY = "--listTemplates";
	protected final static String CONF_ALL_KEY = "--configureAllTemplates";

	// single template generation
	protected final static String TEMPLATE_KEY = "--templateId";
	
	
	public final static String DEFAULT_CONF_OUTPUT = "Debug";
	public final static String DEFAULT_TEMPLATE_OUTPUT = "template";

	// -------------
	
	protected String Help; 
	protected String TemplateHelp;
	protected String VersionHelp;
	protected Logger logger = new StdOutLogger();
	
	
	public String getWriterHelp() {
		
		if (Help == null) {
			
			// init Help
			Help = "Help\n" +
			"RT-Druid version "+ ReadVersion.getRTDruidVersion() +"\n\n" +
			"RT-Druid build   "+ RtdruidConfiguratorNumber.getRTDruidBuildNumber() +"\n\n" +
			"Valid parameters are:\n" +
	//		"  "+ANT_KEY+" file_name      specifies the ant file to use\n" +
			"  "+VERSION_KEY+"       shows the version number and exit.\n" +
			"  "+INPUT_KEY+" file_name [file_name .. file_name]      specifies directly one or more input files.\n" +
			"  "+CONF_FILE_KEY+" file_name      specifies the system configuration file\n" +
			"  "+OUTPUT_KEY+" directory   specifies the directory where store every file (Default value is '"+DEFAULT_CONF_OUTPUT+"')\n" +
			"                       (Note : application directory is the parent of the specified output)\n\n";
			
		}
		
		return Help;
	}

	public String getTemplateHelp() {
		if(TemplateHelp == null) {
			// init Help
			TemplateHelp = "Help\n" +
			"RT-Druid version "+ ReadVersion.getRTDruidVersion() +"\n\n" +
			"RT-Druid build   "+ RtdruidConfiguratorNumber.getRTDruidBuildNumber() +"\n\n" +
			"Valid parameters are:\n" +
			"  "+VERSION_KEY+"       shows the version number and exit.\n" +
			"  "+LIST_KEY+"                 list available templates\n" +
			"  "+CONF_ALL_KEY+"                 generate all templates\n" +
	//		"  "+OPT_KEY+" param=value      specifies a parameter and its value\n" +
			"  "+TEMPLATE_KEY+" file_name      specifies the template ID\n" +
			"  "+OUTPUT_KEY+" directory   specifies the directory where store every file (Default value is '"+DEFAULT_TEMPLATE_OUTPUT+"')\n\n";
		}
		
		return TemplateHelp;
	}


	public String getVersion() {
		if(VersionHelp == null) {
			VersionHelp = "RT-Druid version "+ ReadVersion.getRTDruidVersion() +"\n\n" +
			"RT-Druid build   "+ RtdruidConfiguratorNumber.getRTDruidBuildNumber() +"\n\n";
		}
		
		return VersionHelp;
	}
	
	
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	protected static void loadProperties(String fileName, WorkerOilConfWriter writer)  throws IOException {
		writer.addOptions(loadProperties(fileName));
		
	}
	protected static HashMap<String, String> loadProperties(String fileName)  throws IOException {
		
			
		PreferenceStorage prefs = PreferenceStorage.getCommonIstance();
		if (fileName != null) {
			File f = new File(fileName);
			if (!(f.exists() && f.isFile() && f.canRead())) {
				throw new IOException("Cannot find or read " + fileName);
			}
			
			prefs.setCurrentFile(f);
		}
		if (prefs.getCurrentFile() != null)
			prefs.load();
		return prefs.getAllValue();
	}
	
	
	// ----------------------------------------
	//
	//      WRITER
	//
	// ----------------------------------------
	
	
	/**
	 * @param args
	 */
	public WorkerOilConfWriter parseWriter(String[] args) throws IllegalArgumentException, IOException {
		if (args.length == 0) {
			throw new IllegalArgumentException(getWriterHelp());
		}
		
		ArrayList<String> oil_file = new ArrayList<String>();
		String pref_file = null;
		String output_dir = null;

		boolean inputKeyFound = false;
		for (int i=0; i<args.length; i++) {
			if (VERSION_KEY.equals(args[i])) {
				throw new RuntimeException(getVersion());
				
			} else if (HELP_KEY.equals(args[i])) {
				throw new RuntimeException(getWriterHelp());
				
			} else if (INPUT_KEY.equals(args[i])) {
				// get the next element
				i++;
				inputKeyFound = true;
				if (i<args.length) {
					oil_file.add(args[i]);
				} else {
					throw new IllegalArgumentException(INPUT_KEY + " parameter required a value");
				}
			} else if (OUTPUT_KEY.equals(args[i])) {
				// get the next element
				i++;
				if (i < args.length) {
					output_dir = args[i];
				} else {
					throw new IllegalArgumentException(OUTPUT_KEY + " parameter required a value");
				}
			} else if (CONF_FILE_KEY.equals(args[i])) {
				// get the next element
				i++;
				if (i < args.length) {
					pref_file = args[i];
				} else {
					throw new IllegalArgumentException(CONF_FILE_KEY + " parameter required a value");
				}
			} else if (inputKeyFound) {
				oil_file.add(args[i]); // one more input file
			} else {
				
				throw new IllegalArgumentException(args[i] + " parameter is not valid\n\n" + getWriterHelp());
			}
		}
		// end parse args
		
		if (oil_file.size() == 0) {
			throw new IllegalArgumentException(getWriterHelp());
		}
		
		if (output_dir == null) {
			output_dir = "Debug";
		}
		
		WorkerOilConfWriter writer = new WorkerOilConfWriter(logger);
		for (String s: oil_file) {
			writer.addInputfile(s);
		}
		writer.setOutputdir(output_dir);
		loadProperties(pref_file, writer);

		return writer;
	}

	
	
	// ----------------------------------------
	//
	//      TEMPLATE
	//
	// ----------------------------------------

	
	/**
	 * @param args
	 */
	public IWorkerExampleWriter parseTemplates(String[] args)  throws IllegalArgumentException, IOException {
		if (args.length == 0) {
			throw new IllegalArgumentException(getTemplateHelp());
		}
		
		IWorkerExampleWriter answer = null;
		String template_id = null;
		String output_dir = null;
		String pref_file = null;
		
		boolean list = false;
		boolean confall = false;

		for (int i=0; i<args.length; i++) {
			if (VERSION_KEY.equals(args[i])) {
				throw new RuntimeException(getVersion());
				
			} else if (HELP_KEY.equals(args[i])) {
				throw new IllegalArgumentException(getTemplateHelp());
			} else if (TEMPLATE_KEY.equals(args[i])) {
				// get the next element
				i++;
				if (i<args.length) {
					template_id = args[i];
				} else {
					// abort -----------------
					throw new IllegalArgumentException(TEMPLATE_KEY + " parameter required a value");
				}
			} else if (OUTPUT_KEY.equals(args[i])) {
				// get the next element
				i++;
				if (i < args.length) {
					output_dir = args[i];
				} else {
					// abort -----------------
					throw new IllegalArgumentException(OUTPUT_KEY + " parameter required a value");
				}
			} else if (LIST_KEY.equals(args[i])) {
				list = true;

			} else if (CONF_ALL_KEY.equals(args[i])) {
				confall = true;

			} else {
				// abort -----------------
				throw new IllegalArgumentException(args[i] + " parameter is not valid\n\n" + Help);
			}
		}
		// end parse args

		if (output_dir == null) {
			output_dir = DEFAULT_TEMPLATE_OUTPUT;
		}

		if (list) {
			
			answer = new WorkerExampleList(logger);
			
		} else if (confall) {
			
			answer = new WorkerAllExampleWriter(logger);
			
		} else {
			// search the template and copy it

			if (template_id == null) {
				// abort -----------------
				throw new IllegalArgumentException("Required " + TEMPLATE_KEY + " or " + LIST_KEY + "\n\n"+Help);
			}
			
			
			WorkerExampleWriter writer = new WorkerExampleWriter(logger);
			writer.setExampleID(template_id);
			
			answer = writer;
		}
		
		answer.setOutputDirectory(output_dir);
		answer.setOptions(loadProperties(pref_file));
		return answer;
	}
	
	
}
