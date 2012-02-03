/*
 * Created on Nov 29, 2004
 *
 * $Id: RtosFactoryImpl.java,v 1.4 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.common;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.modules.oil.Rtd_oil_corePlugin;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.RtosFactory;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IRtosWriter;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

/**
 * This factory contains all Configuration file writer for all RT-OS. To write
 * configuration files, use the
 * {@link #write(VarTree, String[]) write(VarTree, String[])}method
 * 
 * @see com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer
 * @see com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords
 * 
 * @author Nicola Serreli
 */
public final class RtosFactoryImpl extends RtosFactory {

	/**
	 * This little class contains a RT-OS writer with its identifer.
	 */
	protected static class RtosFactoryItem implements Comparable<Object> {

		/** The identifier */
		protected String id;

		/** The RT-OS writer (an {@link AbstractRtosWriter AbstractRtosWriter}) */
		protected Class<IRtosWriter> writer;

		/**
		 * Makes a new item with given id and writer.
		 * 
		 * @param id
		 *            the identifier for this rtos writer
		 * @param writer
		 *            the writer for a specied rtos
		 */
		@SuppressWarnings("unchecked")
		public RtosFactoryItem(String id, IRtosWriter writer) {
			this.id = id;
			this.writer = (Class<IRtosWriter>) writer.getClass();
			// check constructor
			boolean ok = false;
			try {
				ok = this.writer.getConstructor() != null;
			} catch (NoSuchMethodException e) {
				ok = false;
			}

			if (!ok) {
				throw new IllegalArgumentException("The given writer ("
						+ this.writer.getName()
						+ ") hasn't the default constructor.");
			}

		}

		/**
		 * Makes a new item with given id and writer.
		 * 
		 * @param id
		 *            the identifier for this rtos writer
		 * @param writer
		 *            the writer for a specied rtos
		 */
		public RtosFactoryItem(String id, Class<IRtosWriter> writer) {
			this.id = id;
			this.writer = writer;
			// check constructor
			boolean ok = false;
			try {
				ok = this.writer.getConstructor() != null;
			} catch (NoSuchMethodException e) {
				ok = false;
			}

			if (!ok) {
				throw new IllegalArgumentException("The given writer ("
						+ this.writer.getName()
						+ ") hasn't the default constructor.");
			}

		}

		/**
		 * Compare the id of this object to the id of another RtosFactoryItem or
		 * to a string. See also Comparable interface and String.compareTo(...).
		 */
		public int compareTo(Object o) {
			if (o instanceof RtosFactoryItem) {
				return id.compareTo(((RtosFactoryItem) o).id);
			}
			return id.compareTo(""+o);
		}

		/**
		 * Return id as String rapresentation of this object
		 * 
		 * @return the id
		 */
		public String toString() {
			return id;
		}

		/**
		 * Returns a new Instance of this Writer
		 * 
		 * @return a new Instance
		 */
		public AbstractRtosWriter getWriter() {
			AbstractRtosWriter answer = null;

			try {
				answer = (AbstractRtosWriter) (writer.getConstructor())
						.newInstance();
			} catch (Exception e) {
				RtdruidLog.log(e);
			}

			return answer;
		}
	}

	private static final String EXTENSION_POINT =
		"RtosWriter";
	   //com.eu.evidence.modules.oil.RtosWriter

	/** The unique instance of this Factory */
	public static RtosFactoryImpl INSTANCE = new RtosFactoryImpl();

	/** All available RT-OS writers (see {@link RtosFactoryItem RtosFactoryItem}) */
	protected ArrayList<RtosFactoryItem> rtosList;

	// --------------------------------------

	/** Store all availabe writers inside the internal list */
	public RtosFactoryImpl() {

		rtosList = new ArrayList<RtosFactoryItem>();

		init();
	}

    /* **************************
     * 
     * LOAD EXTENTIONS
     *
     * **************************/

	/**
	 * Clears the current writer's list and initializes again the factory with
	 * default Writers
	 */
	public synchronized void init() {
		rtosList.clear();

		IExtensionRegistry registry= Platform.getExtensionRegistry();

		IConfigurationElement[] elements= registry.getConfigurationElementsFor(
				Rtd_oil_corePlugin.PLUGIN_ID,
				EXTENSION_POINT);
		for (int i= 0; i < elements.length; i++) {
			try {
			    Collection<RtosFactoryItem> classes = parseElement(elements[i]);
			    for (Iterator<RtosFactoryItem> iter = classes.iterator(); iter.hasNext(); ) {
			    	RtosFactoryItem tmp = (RtosFactoryItem) iter.next();
			    	// TODO: check if contains only memory address
			        if (!rtosList.contains(tmp)) {
			        	rtosList.add(tmp);
			        }
			    }
			} catch (Exception e) {
				RtdruidLog.log(e);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static Collection<RtosFactoryItem> parseElement(IConfigurationElement element) {
	    Assert.isNotNull(element != null);
	    
	    // UPDRTD Testare !!!!
	    
	    final String S_WRITER = "writer";
	    final String S_WRITER_CLASS = "class";
	    final String S_WRITER_ID = "rtos_id";
	    
	    ArrayList<RtosFactoryItem> answer = new ArrayList<RtosFactoryItem>();
/*	    IConfigurationElement children[] = element.getChildren();
	    
	    
		for (int i= 0; i < children.length; i++) {
		    String chName = children[i].getName();*/
	    do {
	    	String chName = element.getName();
		    /*
		     * Parse an Loader element
		     */
		    if (S_WRITER.equalsIgnoreCase(chName)) {
		        String writerId = element.getAttribute(S_WRITER_ID);
		        if ( writerId == null) {
		        	RtdruidLog.log(new NullPointerException("Required an ID"));
		            continue; // next child
		        }

		        
		        String className = element.getAttribute(S_WRITER_CLASS);
		        // load directly the factory's class doen't wark always then
                // ask to eclipse framework to load the required class, and
                // store only the "Class" object
		        Class<?> tmpClass = null;
		        try {
		            Object o = element.createExecutableExtension(S_WRITER_CLASS);
		            tmpClass = o.getClass();
		        } catch (Exception e) {
		            RtdruidLog.log(new RuntimeException("Not found the RT-OS writer class " + className, e));
		            continue; // next child
		        }
		        
		        // check if current tmpClass extend IAdapterFactoryLoader
		        if ( !((IRtosWriter.class).isAssignableFrom(tmpClass))) {
		        	RtdruidLog.log(new RuntimeException("The class " + className + " isn't an ISectionWriter"));
		            continue; // next child
		        }
		        
	            answer.add( new RtosFactoryItem(writerId,
	            		(Class<IRtosWriter>) tmpClass));
		    }
		} while (false);
	    return answer;
	}

	
    /* **************************
     * 
     * CALL Writers
     *
     * **************************/

	/**
	 * This method searchs the configuration writer for the given rtos, and asks
	 * it to prepare all buffers
	 * 
	 * @param vt
	 *            all data
	 * @param rtosPrefix
	 *            all rtos (their path inside the VarTree)
	 * 
	 * @throws OilCodeWriterException
	 *             throw this exception if there are some problems
	 */
/*	public OilWriterBuffer[] write(VarTree vt, String[] rtosPrefix)
			throws OilCodeWriterException {
		
		return write(vt, rtosPrefix, null);
	}*/
	
	/**
	 * This method searchs the configuration writer for the given rtos, and asks
	 * it to prepare all buffers
	 * 
	 * @param vt
	 *            all data
	 * @param rtosPrefix
	 *            all rtos (their path inside the VarTree)
	 * 
	 * @throws OilCodeWriterException
	 *             throw this exception if there are some problems
	 */
	public IOilWriterBuffer[] write(IVarTree vt, String[] rtosPrefix, HashMap<String, Object> options)
			throws OilCodeWriterException {

		// search the writer
		IRtosWriter writer = checkAndGetWriter(vt, rtosPrefix);
		if (writer == null) {
			return new IOilWriterBuffer[0];
		}

		// .. and start to "write"
		writer.init(vt, rtosPrefix, options);
		return writer.write();
	}

	/**
	 * Stores a new Rtos Writer. <br>
	 * Only the "class" is stored and than a new instance is maked for each time
	 * that this writer is required. See also
	 * {@link RtosFactoryItem RtosFactoryItem}
	 * 
	 * @param id
	 *            the identifier for the new Writer
	 * @param writer
	 *            an istance of the writer
	 *  
	 */
	protected void addWriter(String id, IRtosWriter writer) {
		if (id == null || writer == null) {
			throw new IllegalArgumentException(
					"Excepted not null id and writer\n\t" + "id = " + id
							+ "\n\twriter = " + writer);
		}

		int pos = Collections.binarySearch(rtosList, id);
		if (pos < 0) {
			rtosList.add(-pos - 1, new RtosFactoryItem(id, writer));

		} else {
			// check thet are the same or not
			if (((RtosFactoryItem) rtosList.get(pos)).getWriter().getClass() != writer
					.getClass()) {
				throw new IllegalArgumentException(
						"Already exist an writer with the given id but with a different AbstractRtosWriter\n\t"
								+ "id = " + id);
			}
		}
	}

	/**
	 * Checks that all rtosPrefix are valid and that all have the same RT-OS id.
	 * Returns the identifier of most correct RtosWriter
	 * 
	 * @param rtosPrefix
	 *            the list of rtos
	 * 
	 * @return the identifier of most correct RtosWriter
	 * 
	 * @throws OilCodeWriterException
	 *             if there is more than one type of RT-OS
	 */
	protected String checkRtosList(IVarTree vt, String[] rtosPrefix)
			throws OilCodeWriterException {
		
		final ITreeInterface ti = vt.newTreeInterface();
		final char S = DataPath.SEPARATOR;

		String answer = null;

		// search for each rtos its type and check that they are not null and
		// the same for all rtos
		for (int i = 0; i < rtosPrefix.length; i++) {
		
			String rtosNamePath = rtosPrefix[i]+S+DataPackage.eINSTANCE.getRtos_Type().getName(); 
			final boolean ok = ti.exist(rtosNamePath, null);
			
			IVariable var = ok ? ti.getValue(rtosNamePath) : null;
			
			final String type = var == null ? null : (var.get() == null ? null : var.toString());
			if (type == null) {
				throw new OilCodeWriterException("Not found a valid rtos name for " + rtosPrefix[i]);
			}
			
			if (answer == null) {
				answer = type;
			} else {
				if (!answer.equalsIgnoreCase(type)) {
					throw new OilCodeWriterException(
							"More than one rtos type (" + answer + " and "
									+ type + ")");
				}
			}
			
		}
		return answer;
	}
	
	// --------------------------------------------------
	
	/**
	 * This method searchs the configuration writer for the given rtos, and asks
	 * it to prepare all Oil Object List
	 * 
	 * @param vt
	 *            all data
	 * @param rtosPrefix
	 *            all rtos (their path inside the VarTree)
	 * @param options
	 *            some options (depends on writer). Unknow options are ignored
	 * 
	 * @throws OilCodeWriterException
	 *             throw this exception if there are some problems
	 */
	public IOilObjectList[] extractObjects(IVarTree vt, String[] rtosPrefix, HashMap<String, Object> options)
			throws OilCodeWriterException {
	
		// search the writer
		IRtosWriter writer = checkAndGetWriter(vt, rtosPrefix);
		if (writer == null) {
			return new IOilObjectList[0];
		}
		
		// .. init and return required objects
		writer.init(vt, rtosPrefix, options);
		return writer.getOilObjects();

	}
	
	/**
	 * This method check if vt is null or rtosPrefix is null, and search the
	 * correct writer.
	 * 
	 * @param vt
	 *            contains the current Tree
	 * @param rtosPrefix
	 *            all rtos (their path inside the VarTree)
	 * 
	 * @throws IllegalArgumentException
	 *             if vt or rtosPrefix is null
	 * @throws OilCodeWriterException
	 *             if the writer is not found
	 */
	protected IRtosWriter checkAndGetWriter(IVarTree vt, String[] rtosPrefix) 
			throws OilCodeWriterException {

		if (vt == null) {
			throw new IllegalArgumentException("Excepted not null vartree");
		}
		if (rtosPrefix == null) {
			throw new IllegalArgumentException("Excepted not null rtos prefix");
		}

		// there is at least one rtos ?
		if (rtosPrefix.length == 0) {
			return null;
		}

		// Check rtos prefix and extract the rtosId ...
		String rtosId = checkRtosList(vt, rtosPrefix);

		// ... search the writer ...
		int pos = Collections.binarySearch(rtosList, rtosId);
		if (pos < 0) {
			String id = "";
			for (int i=0; i<rtosList.size(); i++) {
				id += (i == 0 ? "" : ", ") + ((RtosFactoryItem) rtosList.get(i)).id;
			}
			throw new OilCodeWriterException(
					"Not found any RT OS Writer with given id : " + rtosId
					+ "\nValid ids are : " + id);
		}

		// ... load the correct rtos ...
		return ((RtosFactoryItem) rtosList.get(pos)).getWriter();
	}
}