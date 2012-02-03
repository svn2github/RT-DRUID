package com.eu.evidence.rtdruid.io;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * This interface is used to export data from internal data structure to another
 * kind of formalism.
 * 
 * @author Nicola Serreli
 */
public interface IRTDExporter {

	/**
	 * Identifies the parent RT-Druid Exporter inside the options. The type of
	 * the object is {@link IRTDExporter}.
	 */
	String OPT_PARENT_EXPORTER = "option___parent_rtd_exporter";

	/**
	 * Specifies a particular importer that should be used to load a specific file.
	 * Has to be a String
	 */
	String OPT_USE_EXPORTER_TYPE = "option___use_rtd_exporter_type";
	
	/**
	 * Saves the RT-Druid tree in the specified output stream.
	 * 
	 * @param output
	 *            where save data
	 * 
	 * @param data
	 *            the data that have to be saved
	 * 
	 * @param options
	 *            some options. It contains also the parent exporter. Useful to
	 *            do transformations.
	 * 
	 * @return return the root of the tree.
	 * 
	 * @throws IOException
	 *             if there is any problem while reading the input stream.
	 */
	void export(OutputStream output,
			EObject data, Map<?, ?> options)
			throws IOException;

}
