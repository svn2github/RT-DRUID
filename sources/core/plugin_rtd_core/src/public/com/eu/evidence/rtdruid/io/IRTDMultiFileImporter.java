package com.eu.evidence.rtdruid.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * This interface is used to import data into the internal data structure from
 * another kind of formalism, collecting multiple sources at once.
 * 
 * @author Nicola Serreli
 */
public interface IRTDMultiFileImporter {

	/**
	 * Returns the list of file extension supported by this Importer. The result
	 * cannot be null and should contain at least one element.
	 * 
	 * @return the list of file extension supported by this Importer
	 */
	String[] validExtensions();

	/**
	 * Loads the input stream and converts it into a RT-Druid tree.
	 * 
	 * @param input
	 *            the input stream that contains the data that have to be loaded
	 * 
	 * @param input_name
	 *            the input full path. It may be used by inclusion functions.
	 *            The name type can be used to select how read the corresponding
	 *            input.
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
	EObject load(InputStream[] input,
			String[] input_name, Map<?, ?> options) throws IOException;

}
