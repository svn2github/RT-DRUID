package com.eu.evidence.rtdruid.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import com.eu.evidence.rtdruid.internal.io.RTDResourceManagerFactory;

public final class MultiSourceImporterFactory {

	/**
	 * This class helps to incrementally search the MultiSource importer. Note
	 * that the result can be related to the order of adding new files
	 * 
	 * @author Nicola Serreli
	 * 
	 */
	public static class LoadHelper {

		protected final ArrayList<String> fileName;
		protected final ArrayList<String> fileTypes;
		protected final ArrayList<InputStream> inputs;
		protected final Set<String> types;

		protected IRTDMultiFileImporter importer;

		public LoadHelper() {
			fileName = new ArrayList<String>();
			fileTypes = new ArrayList<String>();
			inputs = new ArrayList<InputStream>();
			types = new LinkedHashSet<String>();
			importer = null;
		}

		public boolean add(String name, InputStream input) {
			boolean answer = false;
			String type = null;
			{
				int pos = name.lastIndexOf(".");
				if (pos >0) {
					type = name.substring(pos+1);
				}
			}
			
			if (type != null) {
				
				if (types.contains(type)) {
					answer = true;
				} else {
					// build a new array with one free space, where put the new type
					String[] t = types.toArray(new String[types.size() +1]);
					t[t.length-1] = type; // set the value AFTER .toArray function
					
					IRTDMultiFileImporter im = MultiSourceImporterFactory.getFactory().getImporterFor(t);
					if (im != null) {
						answer = true;
						importer = im;
						types.add(type);
					}
				}
				
				
			}
			if (answer) {
				fileName.add(name);
				fileTypes.add(type);
				inputs.add(input);
			}
			
			return answer;
		}
		
		public List<String> getNames() {
			return Collections.unmodifiableList(fileName);
		}
		
		public EObject load() throws IOException {
			return load(null);
		}

		public EObject load(Map<?, ?> options) throws IOException {
			return importer.load(inputs.toArray(new InputStream[inputs.size()]), fileName.toArray(new String[fileName.size()]), options);
		}

	}

	/**
	 * The unique instance
	 */
	private static final MultiSourceImporterFactory factory = new MultiSourceImporterFactory();

	/**
	 * Private constructor
	 */
	private MultiSourceImporterFactory() {
	}

	/**
	 * @return the factory
	 */
	public static MultiSourceImporterFactory getFactory() {
		return factory;
	}

	/**
	 * @return all multi-file importers
	 */
	public List<IRTDMultiFileImporter> getElements() {
		return RTDResourceManagerFactory.getInstance().getElements();
	}

	/**
	 * Searches the most indicated importer for specified set of types
	 * 
	 * @param types
	 *            the set of types that should be supported by the importer
	 *            (case insensitive)
	 * @return the Importer
	 */
	public IRTDMultiFileImporter getImporterFor(String[] types) {
		return RTDResourceManagerFactory.getInstance().getImporterFor(types);
	}
}
