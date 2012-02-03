/*
 * Created on Nov 29, 2004
 *
 * $Id: RtosFactory.java,v 1.2 2007/03/12 13:40:55 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.codewriter.common;



import java.util.HashMap;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.common.RtosFactoryImpl;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IRtosWriter;
import com.eu.evidence.rtdruid.vartree.IVarTree;


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
public abstract class RtosFactory {

	/**
	 * This little class contains a RT-OS writer with its identifer.
	 */
	protected static class RtosFactoryItem implements Comparable<Object> {

		/** The identifier */
		protected String id;

		/** The RT-OS writer (an {@link AbstractRtosWriter AbstractRtosWriter}) */
		protected Class<? extends IRtosWriter> writer;

		/**
		 * Makes a new item with given id and writer.
		 * 
		 * @param id
		 *            the identifier for this rtos writer
		 * @param writer
		 *            the writer for a specied rtos
		 */
		public RtosFactoryItem(String id, IRtosWriter writer) {
			this.id = id;
			this.writer = writer.getClass();
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
		public IRtosWriter getWriter() {
			IRtosWriter answer = null;

			try {
				answer = (writer.getConstructor())
						.newInstance();
			} catch (Exception e) {
				RtdruidLog.log(e);
			}

			return answer;
		}
	}

	/** The unique instance of this Factory */
	//public final static RtosFactory INSTANCE = new RtosFactory();
	
	//protected final Object impl;
	
	public final static RtosFactory INSTANCE; // = new RtosFactoryImpl();

	/** All available RT-OS writers (see {@link RtosFactoryItem RtosFactoryItem}) */
	//protected ArrayList rtosList;

	// --------------------------------------

	/** Store all availabe writers inside the internal list */
	static {
		
		INSTANCE = new RtosFactoryImpl();
	}

	/**
	 * Clears the current writer's list and initializes again the factory with
	 * default Writers
	 */
	public abstract void init();
	
	// ---------------------------------

	/**
	 * This method searchs the configuration writer for the given rtos, and asks
	 * it to prepare all buffers
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
	public IOilWriterBuffer[] write(IVarTree vt, String[] rtosPrefix)
			throws OilCodeWriterException {
		
		return write(vt, rtosPrefix, null);
	}
	
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
	public abstract IOilWriterBuffer[] write(IVarTree vt, String[] rtosPrefix, HashMap<String, Object> options)
			throws OilCodeWriterException;
	
	// ---------------------------------

	/**
	 * This method searchs the configuration writer for the given rtos, and asks
	 * it to prepare all Oil Object List
	 * 
	 * @param vt
	 *            all data
	 * @param rtosPrefix
	 *            all rtos (their path inside the VarTree)
	 * 
	 * @throws OilCodeWriterException
	 *             throw this exception if there are some problems
	 */
	public IOilObjectList[] extractObjects(IVarTree vt, String[] rtosPrefix)
			throws OilCodeWriterException {
		
		return extractObjects(vt, rtosPrefix, null);
	}
	
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
	public abstract IOilObjectList[] extractObjects(IVarTree vt, String[] rtosPrefix, HashMap<String, Object> options)
			throws OilCodeWriterException;

}