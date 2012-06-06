package com.eu.evidence.rtdruid.internal.io;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import com.eu.evidence.rtdruid.Rtd_corePlugin;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.io.IRTDExporter;
import com.eu.evidence.rtdruid.io.IRTDImporter;
import com.eu.evidence.rtdruid.io.IRTDMultiFileImporter;

/**
 * This class is used to store every single file reader and writer, able to load 
 * data into the RT-Druid data structure and write files from a RT-Druid tree.
 * 
 *  It uses the two interfaces RTDImporter and RTDExporter.
 * 
 * @author Nicola Serreli
 */
public final class RTDResourceManagerFactory {
	
	/**
	 * This small class is used to store an Importer
	 * 
	 * @author Nicola Serreli
	 */
	public static class ResImporter {
		final String type;
		final Class<IRTDImporter> importer;
		final String description;
		final boolean caseSensitive;
		final String[] multiTypes;
		
		public ResImporter(String type, Class<IRTDImporter> importer, String descr, boolean caseSensitive) {
			this.type = type;
			this.importer = importer;
			this.description = descr;
			this.caseSensitive = caseSensitive;
			
			String[] tmp = null;
			try {
				IRTDImporter in = getAnInstance();
				if (in instanceof IRTDMultiFileImporter) {
					tmp = ((IRTDMultiFileImporter) in).validExtensions();
				}
			} catch (Exception e) {
				// ignore it
			}
			
			this.multiTypes = tmp;
		}
		@Override
		public String toString() {
			return "Import from " + type + "(case sensitive = " + caseSensitive + ") using " + importer.getName() + "\n" +
					"Descr = " + description;
		}
		
		/**
		 * This method tries to build a new instance of the RTDImporter stored here.
		 * 
		 * @return the new RTDImporter 
		 * @throws RuntimeException if there was any problem during the instantiation.
		 */
		public IRTDImporter getAnInstance() throws RuntimeException {
			IRTDImporter answer;
	        try {
	        	Constructor<IRTDImporter> construct = importer.getConstructor();
	        	if (construct != null) {
	        		answer = (IRTDImporter) construct.newInstance();
	        	} else {
	        		// this cannot append because the default constructor is used during
	        		// the extention point loading phase
	        		throw new RuntimeException("There isn't any default constructorfor " + importer.getName());
	        	}
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }

	        return answer;
		}
	}
	
	/**
	 * This small class is used to store an Exporter
	 * 
	 * @author Nicola Serreli
	 */
	public static class ResExporter {
		final String type;
		final Class<IRTDExporter> exporter;
		final String description;
		final boolean caseSensitive;
		
		public ResExporter(String type, Class<IRTDExporter> exporter, String descr, boolean caseSensitive) {
			this.type = type;
			this.exporter = exporter;
			this.description = descr;
			this.caseSensitive = caseSensitive;
		}
		
		@Override
		public String toString() {
			return "Export to " + type + "(case sensitive = " + caseSensitive + ") using " + exporter.getName() + "\n" +
					"Descr = " + description;
		}
		
		/**
		 * This method tries to build a new instance of the RTDExporter stored here.
		 * 
		 * @return the new RTDExporter 
		 * @throws RuntimeException if there was any problem during the instantiation.
		 */
		public IRTDExporter getAnInstance() throws RuntimeException {
			IRTDExporter answer;
	        try {
	        	Constructor<IRTDExporter> construct = exporter.getConstructor();
	        	if (construct != null) {
	        		answer = (IRTDExporter) construct.newInstance();
	        	} else {
	        		// this cannot append because the default constructor is used during
	        		// the extention point loading phase
	        		throw new RuntimeException("There isn't any default constructor for " + exporter.getName());
	        	}
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }

	        return answer;
		}
	}
	
	private static final String EXP_ID = Rtd_corePlugin.PLUGIN_ID+".data_tranformation";
    private static final String S_IMPORTER_ELEM = "importer";
    private static final String S_EXPORTER_ELEM = "exporter";
    
    private static final String S_ATTR_CASE = "case_sensitive";
    private static final String S_ATTR_DESCR = "description";
    private static final String S_ATTR_CLASS = "class";
    private static final String S_ATTR_TYPE = "type";
	
	private static RTDResourceManagerFactory instance = null;
	
	
    /** Contains the names of classes able to export data */
    private List<ResExporter> expFactories = null;
    /** Contains the names of classes able to import data */
    private List<ResImporter> impFactories = null;


	
	/**
	 * @return the current instance of this factory
	 */
	public static RTDResourceManagerFactory getInstance() {
		if (instance == null) {
			instance = new RTDResourceManagerFactory();
		}

		return instance;
	}

	/**
	 * Builds an new Factory and load every extention. 
	 */
	private RTDResourceManagerFactory() {
		reload();
	}
	
	
    /**
     * Reload all extentions
	 */
    public void reload() {
		IExtensionRegistry registry= Platform.getExtensionRegistry();
		ArrayList<ResImporter> ilist= new ArrayList<ResImporter>();
		ArrayList<ResExporter> olist= new ArrayList<ResExporter>();

		IConfigurationElement[] elements= registry.getConfigurationElementsFor(EXP_ID);
		for (IConfigurationElement element : elements) {
			try {
				
		    	String chName = element.getName();
			    if (S_IMPORTER_ELEM.equalsIgnoreCase(chName)) {
			    	ResImporter res = parseImport(element);
			    	if (res != null) {
			    		ilist.add(res);
//			    		IRTDImporter importer = res.getAnInstance();
//			    		if (importer instanceof IRTDMultiFileImporter) {
//			    			
//			    		}
			    	}
			    } else if (S_EXPORTER_ELEM.equalsIgnoreCase(chName)) {
			    	ResExporter res = parseExport(element);
			    	if (res != null)
			    		olist.add(res);
			    } 
			} catch (ClassCastException e) {
				
			}
		}
		
    	impFactories = Collections.unmodifiableList(ilist);
    	expFactories = Collections.unmodifiableList(olist);
    }
	
    
    
    
    /**
	 * Parse an element as Import Element.
	 * 
	 * @param element
	 *            the Import element
	 * @return return a new ResImporter object or null if there was some
	 *         problems
	 */
	@SuppressWarnings("unchecked")
	private static ResImporter parseImport(IConfigurationElement element) {
	    Assert.isNotNull(element);

	    ResImporter answer = null;

    	String chName = element.getName();
	    /*
	     * Parse an Loader element
	     */
	    if (S_IMPORTER_ELEM.equalsIgnoreCase(chName)) {
	        String type = element.getAttribute(S_ATTR_TYPE);
	        String className = element.getAttribute(S_ATTR_CLASS);
	        boolean caseSensitive = "true".equalsIgnoreCase(element.getAttribute(S_ATTR_CASE)); // ? true : false;
	        String description = element.getAttribute(S_ATTR_DESCR);

	        // load directly the factory's class doen't wark always then
            // ask to eclipse framework to load the required class, and
            // store only the "Class" object
	        Class<?> tmpClass = null;
	        try {
	            Object o = element.createExecutableExtension(S_ATTR_CLASS);
	            tmpClass = o.getClass();
	        } catch (Exception e) {
	            RtdruidLog.log(new RuntimeException("Not found the importer class " + className, e));
	        }
	        
	        // check if current tmpClass extend IAdapterFactoryLoader
	        if ( tmpClass != null) {
	        	if ((IRTDImporter.class).isAssignableFrom(tmpClass)) {
	        		
	                answer = new ResImporter(type, (Class<IRTDImporter>) tmpClass, description, caseSensitive);
	        	} else {
	        		
		        	RtdruidLog.log(new RuntimeException("The class " + className + " isn't an IRTDImporter"));
	        	}
	        }
	        
	    }
	    return answer;
	}

    /**
	 * Parse an element as Export Element.
	 * 
	 * @param element
	 *            the Export element
	 * @return return a new ResExporter object or null if there was some
	 *         problems
	 */
	@SuppressWarnings("unchecked")
	private static ResExporter parseExport(IConfigurationElement element) {
	    Assert.isNotNull(element);

	    ResExporter answer = null;

    	String chName = element.getName();
	    /*
	     * Parse an Loader element
	     */
	    if (S_EXPORTER_ELEM.equalsIgnoreCase(chName)) {
	        String type = element.getAttribute(S_ATTR_TYPE);
	        String className = element.getAttribute(S_ATTR_CLASS);
	        boolean caseSensitive = "true".equalsIgnoreCase(element.getAttribute(S_ATTR_CASE)); // ? true : false;
	        String description = element.getAttribute(S_ATTR_DESCR);

	        // load directly the factory's class doen't wark always then
            // ask to eclipse framework to load the required class, and
            // store only the "Class" object
	        Class<?> tmpClass = null;
	        try {
	            Object o = element.createExecutableExtension(S_ATTR_CLASS);
	            tmpClass = o.getClass();
	        } catch (Exception e) {
	            RtdruidLog.log(new RuntimeException("Not found the importer class " + className, e));
	        }
	        
	        // check if current tmpClass extend RTDImporter
	        if ( tmpClass != null) {
	        	if ((IRTDImporter.class).isAssignableFrom(tmpClass)) {
	        		
	                answer = new ResExporter(type, (Class<IRTDExporter>) tmpClass, description, caseSensitive);
	        	} else {
	        		
		        	RtdruidLog.log(new RuntimeException("The class " + className + " isn't an IRTDExporter"));
	        	}
	        }
	        
	    }
	    return answer;
	}

	/*
	 * 
	 *  GET
	 * 
	 * 
	 */
	
	
	/**
	 * @return all supported import types (or an empty array if none)
	 */
	public String[] getAllImportTypes() {
		ArrayList<String> types = new ArrayList<String>();
		for (ResImporter res: impFactories) {
			types.add(res.type);
		}
		return types.toArray(new String[types.size()]);
	}
	
	/**
	 * Checks if the specified type is supported
	 * 
	 * @param type
	 *            the file type (like "xml" or "ertd")
	 *            
	 * @return true if there is an RTDImporter for that type of file
	 */
	public boolean supportImport(String type) {
		return getImportRes(type) != null;
	}

	/**
	 * Searches the RTDImporter that support the specified type
	 * 
	 * @param type
	 *            the file type (like "xml" or "ertd")
	 * 
	 * @return the RTDImporter entry or null if the specified file is not
	 *         supported by any importer
	 */
	public IRTDImporter getImport(String type) {
		ResImporter res = getImportRes(type);
		return res != null ? res.getAnInstance() : null;
	}
	/**
	 * Searches the RTDImporter that support the specified type
	 * 
	 * @param type
	 *            the file type (like "xml" or "ertd")
	 * 
	 * @return the RTDImporter entry or null if the specified file is not
	 *         supported by any importer
	 */
	public ResImporter getImportRes(String type) {
		for (ResImporter res: impFactories) {
			if (!res.caseSensitive) {
				if (res.type.equalsIgnoreCase(type)) {
					return res;
				}
			} else {
				if (res.type.equals(type)) {
					return res;
				}
			}
		}

		return null;
	}


	/**
	 * @return all supported export types (or an empty array if none)
	 */
	public String[] getAllExportTypes() {
		ArrayList<String> types = new ArrayList<String>();
		for (ResExporter res: expFactories) {
			types.add(res.type);
		}
		return types.toArray(new String[types.size()]);
	}
	
	/**
	 * Checks if the specified type is supported
	 * 
	 * @param type
	 *            the file type (like "xml" or "ertd")
	 *            
	 * @return true if there is an RTDImporter for that type of file
	 */
	public boolean supportExport(String type) {
		return getExportRes(type) != null;
	}

	/**
	 * Searches the RTDExporter that support the specified type
	 * 
	 * @param type
	 *            the file type (like "xml" or "ertd")
	 * 
	 * @return the RTDExporter entry or null if the specified file is not
	 *         supported by any exporter
	 */
	public IRTDExporter getExport(String type) {
		ResExporter res = getExportRes(type);
		return res != null ? res.getAnInstance() : null;
	}

	/**
	 * Searches the RTDExporter that support the specified type
	 * 
	 * @param type
	 *            the file type (like "xml" or "ertd")
	 * 
	 * @return the RTDExporter entry or null if the specified file is not
	 *         supported by any exporter
	 */
	public ResExporter getExportRes(String type) {
		for (ResExporter res: expFactories) {
			if (!res.caseSensitive) {
				if (res.type.equalsIgnoreCase(type)) {
					return res;
				}
			} else {
				if (res.type.equals(type)) {
					return res;
				}
			}
		}

		return null;
	}
	
	// MULTI IMPORT
	

	public List<IRTDMultiFileImporter> getElements() {
		ArrayList<IRTDMultiFileImporter> answer = new ArrayList<IRTDMultiFileImporter>();
		
		for (ResImporter res: impFactories) {
			if (res.multiTypes != null) {
				answer.add((IRTDMultiFileImporter) res.getAnInstance());
			}
		}
		return Collections.unmodifiableList(answer);
	}
	
	public IRTDMultiFileImporter getImporterFor(String[] types) {
		// try to remove double extensions
		Set<String> required = prepareSet(types);
		
		ResImporter answer = null;
		int extraTypes = Integer.MAX_VALUE;
		for (ResImporter res: impFactories) {
			if (res.multiTypes != null) {
			
				Set<String> s = prepareSet(res.multiTypes);
				if (s.size() >= required.size()) {
					int current_extra_values = s.size()-required.size();
					
					boolean valid = true;
					for (String t: required) {
						valid &= s.contains(t);
					}
					if (valid && (current_extra_values < extraTypes)) {
						answer = res;
						extraTypes = current_extra_values;
					}
				}
			}
			
		}
		
		return answer == null ? null : (IRTDMultiFileImporter) answer.getAnInstance();
	}
	
	protected Set<String> prepareSet(String[] values) {
		LinkedHashSet<String> answer = new LinkedHashSet<String>();
		for (String t: values) {
			t = t.toLowerCase();
			answer.add(t);
		}
		return answer;
	}
	
}
