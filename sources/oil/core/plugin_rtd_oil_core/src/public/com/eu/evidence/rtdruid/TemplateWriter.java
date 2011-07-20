package com.eu.evidence.rtdruid;

import java.io.File;


import com.eu.evidence.rtdruid.desk.CommonPaths;
import com.eu.evidence.rtdruid.desk.ReadVersion;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.Logger;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.OilWorkerException;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.WorkerExampleWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.workers.WorkerOilConfWriter;
import com.eu.evidence.rtdruid.internal.modules.project.templates.ExampleTemplate;
import com.eu.evidence.rtdruid.internal.modules.project.templates.SearchTemplates;

public class TemplateWriter extends AbstractOilStandalone {

	protected final static String Help; 
	
	protected final static String EVI_BASE_KEY = "EVIDENCEBASE";

	protected final static String LIST_KEY = "--list";
	protected final static String CONF_ALL_KEY = "--conf_all";

	protected final static String TEMPLATE_KEY = "--template";
	protected final static String OPT_KEY = "--opt";
	protected final static String OUTPUT_KEY = "--output";
	protected final static String DEFAULT_OUTPUT = "template";

	static {
		
		String EEBASE = CommonPaths.getEVIDENCE_BASE();
		
		// init Help
		Help = "Help\n" +
		"RT-Druid "+ ReadVersion.getRTDruidVersion() +"\n\n" +
		"Valid parameters are:\n" +
		"  "+LIST_KEY+"                 list available templates\n" +
		"  "+CONF_ALL_KEY+"                 generate all templates\n" +
//		"  "+OPT_KEY+" param=value      specifies a parameter and its value\n" +
		"  "+TEMPLATE_KEY+" file_name      specifies the template ID\n" +
		"  "+OUTPUT_KEY+" directory   specifies the directory where store every file (Default value is '"+DEFAULT_OUTPUT+"')\n\n" +
		"Remember to set the enviroment variable EVIDENCEBASE to the root directory of Evidence programs\n" +
		"(Currently " + EVI_BASE_KEY +" = " + EEBASE + ")\n";

	}
	
	protected static Logger logger = new Logger() {
		public void log(String arg0) {
			System.out.println(arg0);
		}
	};

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			end(Help, -1);
		}
		
		String template_id = null;
		String output_dir = null;
		
		boolean list = false;
		boolean confall = false;

		for (int i=0; i<args.length; i++) {
			if (TEMPLATE_KEY.equals(args[i])) {
				// get the next element
				i++;
				if (i<args.length) {
					template_id = args[i];
				} else {
					// abort -----------------
					end(TEMPLATE_KEY + " parameter required a value", -2);
				}
			} else if (OUTPUT_KEY.equals(args[i])) {
				// get the next element
				i++;
				if (i < args.length) {
					output_dir = args[i];
				} else {
					// abort -----------------
					end(OUTPUT_KEY + " parameter required a value", -3);
				}
			} else if (LIST_KEY.equals(args[i])) {
				list = true;

			} else if (CONF_ALL_KEY.equals(args[i])) {
				confall = true;

			} else {
				// abort -----------------
				end(args[i] + " parameter is not valid\n\n" + Help, -4);
			}
		}
		// end parse args


		if (list) {
			ExampleTemplate[] templates = SearchTemplates.getConfigTemplates();

			// search all templates
			final String wsp = "    ";
			for (int i=0; i<templates.length; i++) {
				ExampleTemplate ex = templates[i];
				
				String buff = ""+i+") "
						+       "Title = " + ex.getTitle()+"\n"
						+ wsp + "Cat.  = " + ex.getCategory() + "\n"
						+ wsp + "ID    = " + ex.getExampleID() + "\n"
						+ wsp + "Descr.= " + ex.getShortDescr();
				printOut(buff);
			}
			
		} else if (confall) {
			
			TemplateWriter twriter = new TemplateWriter();
			twriter.outputDirectory = output_dir;
			twriter.execute();
			
		} else {
			// search the template and copy it

			if (template_id == null) {
				// abort -----------------
				end("Required " + TEMPLATE_KEY + " or " + LIST_KEY + "\n\n"+Help,-5);
			}
			if (output_dir == null) {
				output_dir = DEFAULT_OUTPUT;
			}
			
			WorkerExampleWriter writer = new WorkerExampleWriter(logger);
			writer.setExampleID(template_id);
			writer.setOutputDirectory(output_dir);
			try {
				writer.execute();
			} catch (OilWorkerException e) {
				logger.log(e.getMessage());
			}
		}
		
	}




	protected WorkerExampleWriter wWriter = new WorkerExampleWriter(logger);

	protected WorkerOilConfWriter wOilConf = new WorkerOilConfWriter(logger);
	protected boolean runConf = false;
	protected String  outputDirectory = "";
	

	/**
	 * Stores all buffers inside the specified directory.
	 * 
	 * @throws BuildException
	 *             if there is one or more errors during store operation
	 *  
	 */
	protected void save(ExampleTemplate template) {

		logger.log("\n\nExample ID = " + template.getExampleID()); // empty line
//			log("\nExample ID = " + template.toString()); // empty line

		try {
			wWriter.setExampleTemplate(template);
			wWriter.setOutputDirectory(outputDirectory + template.getExampleID()+File.separatorChar );
			wWriter.execute();
			
			if (runConf) {
				wOilConf.setOutputdir(outputDirectory + template.getExampleID()+File.separatorChar+"Debug"+File.separatorChar);
				wOilConf.setInputfile(outputDirectory + template.getExampleID()+File.separatorChar+"conf.oil");
				wOilConf.execute();
			}
		} catch (OilWorkerException e) {
			RtdruidLog.showDebug(e);
			throw new RuntimeException(e.getMessage());
		}
		
	}

	/**
	 * Start works. Check specified parameters, load file, compute buffers and
	 * write all outputs
	 * 
	 * @throws BuildException
	 *             if there is an error.
	 */
	public void execute()  {
		// ------------- make all checks ----------------
		if (outputDirectory == null) {
			throw new RuntimeException("Required an output directory");
		}

		logger.log(""); // empty line
		

		// --------------- Load example ------------------
		ExampleTemplate[] templates = SearchTemplates.getConfigTemplates();;

		// --------------- Store files -------------------
		for (int i=0; i<templates.length; i++)
			save(templates[i]);
	}

}
