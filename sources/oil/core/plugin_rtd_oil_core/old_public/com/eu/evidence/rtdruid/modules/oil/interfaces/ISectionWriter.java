package com.eu.evidence.rtdruid.modules.oil.interfaces;

import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.IncompatibleWriterKeywordsException;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.RequiredWriterKeywordsException;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.vartree.IVarTree;

public interface ISectionWriter {
	

	/**
	 * @return the category covered by this section writer
	 */
	public ISWCategory getCategory();
	

	/**
	 * @return the id of this section writer
	 */
	public String getId();
	
	
	/**
	 * This method check that the given keys list contains all required keys and
	 * none of wrongful keys. Than store current keywords. If specified keywords
	 * don't enable this write, this method does nothing, otherwise calls
	 * {@link #internalCheckKeys() internalCheckKeys}.
	 * 
	 * @param keys
	 *            all currently setted keys
	 * 
	 * @return true if given keys list contains all required keys and none of
	 *         wrongful keys. False otherwise.
	 * 
	 * @throws IncompatibleWriterKeywordsException
	 *             if there is one or more keywords incompatible with this
	 *             writer
	 * @throws RequiredWriterKeywordsException
	 *             if this writer requires one or more keywords
	 */
	public void checkKeys(String[] keys)
			throws IncompatibleWriterKeywordsException,
			RequiredWriterKeywordsException;

	/**
	 * This method returns true if current instance of writer is enabled with
	 * specified keywords.
	 * 
	 * @param keys
	 *            all currently setted keys
	 * 
	 * @return true if this writer is enabled
	 */
	public boolean enabled(String[] keys);

	/**
	 * The main method. <br>
	 * This method parse the data, prepares all buffers for
	 * <code>.c/.h/.s/.asm</code> files and store them inside a
	 * {@link OilWriterBuffer OilWriterBuffer}. If there are more than one cpu,
	 * uses one {@link OilWriterBuffer OilWriterBuffer }for each cpu.
	 * 
	 * @param vt
	 *            all data (cannot be null)
	 * 
	 * @return one {@link OilWriterBuffer OilWriterBuffer }for each cpu.
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some errors
	 */
	public IOilWriterBuffer[] write(IVarTree vt) throws OilCodeWriterException;

}