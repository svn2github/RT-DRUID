package com.eu.evidence.rtdruid;

import java.io.File;


import com.eu.evidence.rtdruid.desk.ReadVersion;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.Logger;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.OilWorkerException;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.WorkerOilConfWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.options.PreferenceStorage;

public class OilConfigWriter extends AbstractOilStandalone {

	protected String Help; 

	protected final static String ANT_KEY = "--ant";
	protected final static String OIL_KEY = "--oil";
	protected final static String OUTPUT_KEY = "--output";
	protected final static String CONF_FILE_KEY = "--output";

	private String getHelp() {
		
		if (Help == null) {
			
			// init Help
			Help = "Help\n" +
			"RT-Druid "+ ReadVersion.getRTDruidVersion() +"\n\n" +
			"Valid parameters are:\n" +
	//		"  "+ANT_KEY+" file_name      specifies the ant file to use\n" +
			"  "+OIL_KEY+" file_name      specifies directly the oil file\n" +
			"  "+OUTPUT_KEY+" directory   specifies the directory where store every file (Default value is 'Debug')\n" +
			"                       (Note : application directory is the parent of the specified output)\n\n";
			
		}
		
		return Help;
	}

	protected static void loadProperties(String fileName, WorkerOilConfWriter writer) {
		PreferenceStorage prefs = PreferenceStorage.getCommonIstance();
		if (fileName != null) {
			File f = new File(fileName);
			if (!(f.exists() && f.isFile() && f.canRead())) {
				throw new RuntimeException("Cannot find or read " + fileName);
			}
			
			prefs.setCurrentFile(f);
		}
		if (prefs.getCurrentFile() != null)
			prefs.load();
		writer.addOptions(prefs.getAllValue());
	}
	
	/**
	 * @param args
	 */
	public void main(String[] args) {
		if (args.length == 0) {
			end(getHelp(), -1);
		}
		
		String oil_file = null;
		String output_dir = null;

		for (int i=0; i<args.length; i++) {
			if (OIL_KEY.equals(args[i])) {
				// get the next element
				i++;
				if (i<args.length) {
					oil_file = args[i];
				} else {
					end(OIL_KEY + " parameter required a value", -2);
				}
			} else if (OUTPUT_KEY.equals(args[i])) {
				// get the next element
				i++;
				if (i < args.length) {
					output_dir = args[i];
				} else {
					end(OUTPUT_KEY + " parameter required a value", -3);
				}
			} else {
				end(args[i] + " parameter is not valid\n\n" + Help, -4);
			}
		}
		// end parse args
		
		if (oil_file == null) {
			end(Help, -1);
		}
		
		if (output_dir == null) {
			output_dir = "Debug";
		}
		
		
		Logger logger = new Logger() {
			public void log(String arg0) {
				System.out.println(arg0);
			}
		};
		WorkerOilConfWriter writer = new WorkerOilConfWriter(logger);
		writer.setInputfile(oil_file);
		writer.setOutputdir(output_dir);
		loadProperties(null, writer);
		try {
			writer.execute();
		} catch (OilWorkerException e) {
			logger.log(e.getMessage());
		}
	}

	
}
