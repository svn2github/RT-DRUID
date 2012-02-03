/**
 * Created on 12/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.interfaces;

import java.util.HashMap;

import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * @author Nicola Serreli
 *
 */
public interface IRtosWriter {

	/**
	 * Inits the writer
	 * 
	 * @param vt
	 *            contains all data
	 * 
	 * @param rtosPrefix
	 *            identifies the rtos that contains all Oil Objects.
	 * 
	 * @throws NullPointerException
	 *             if vt is null
	 * @throws OilCodeWriterException
	 *             throw this exception if there are some problems
	 */
	public void init(IVarTree vt, String[] rtosPrefix,
			HashMap<String, ?> opt) throws OilCodeWriterException;

	/**
	 * Returns all oil objects
	 * */
	public IOilObjectList[] getOilObjects();

	/**
	 * The main method. <br>
	 * This method parse the data, prepares all buffers for
	 * <code>.c/.h/.s/.asm</code> files and store them inside a
	 * {@link OilWriterBuffer OilWriterBuffer}. If there are more than one cpu,
	 * uses one {@link OilWriterBuffer OilWriterBuffer}for each cpu. (See also
	 * {@link #init(VarTree, String[]) init method})
	 * 
	 * @return one {@link OilWriterBuffer OilWriterBuffer}for each cpu.
	 * 
	 * @throws OilCodeWriterException
	 *             throw this exception if there are some problems
	 */
	public IOilWriterBuffer[] write() throws OilCodeWriterException;

}