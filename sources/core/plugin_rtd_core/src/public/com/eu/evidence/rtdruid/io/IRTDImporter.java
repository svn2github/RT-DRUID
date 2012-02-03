package com.eu.evidence.rtdruid.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * This interface is used to import data into the internal data structure from
 * another kind of formalism.
 * 
 * @author Nicola Serreli
 */
public interface IRTDImporter {

	/**
	 * Identifies the parent RT-Druid Importer inside the options. The type of
	 * the object is {@link IRTDImporter}.
	 */
	String OPT_PARENT_IMPORTER = "option___parent_rtd_importer";

	/**
	 * Specifies a particular importer that should be used to load a specific file.
	 * Has to be a String
	 */
	String OPT_USE_IMPORTER_TYPE = "option___use_rtd_importer_type";

	/**
	 * Specifies the full name of the source file (if any)
	 * Has to be a String
	 */
	String OPT_FILE_FULLNAME = "option___file__full_name";
	
	/**
	 * Loads the input stream and converts it into a RT-Druid tree.
	 * 
	 * @param input
	 *            the input stream that contains the data that have to be loaded
	 * 
	 * @param options
	 *            some options. It contains also the parent importer. Useful to
	 *            do transformations.
	 * 
	 * @return the root of the RT-Druid tree
	 * 
	 * @throws IOException
	 *             if there is any problem while reading the input stream.
	 */
	EObject load(InputStream input, Map<?, ?> options) throws IOException;

}
