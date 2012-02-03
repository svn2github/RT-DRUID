/*
 * Created on Sep 7, 2005
 *
 * $Id: IOilWriterBuffer.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.abstractions;


/**
 * TODO Commentare && Tradurre
 * 
 * @author Nicola Serreli
 */
public interface IOilWriterBuffer {
	// ---------------------------------------------------------------------
	int getBufferNumber();

	/**
	 * Returns the (String) id of one of the String buffers. <br>
	 * 
	 * @param buffId
	 *            identifies the required buffer
	 * 
	 * @return the asked Buffer
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if buffId isn't lower than zero or greater than bufferSize
	 *             minus one
	 */
	String[] getKeys();

	/**
	 * Returns one of the String buffers. <br>
	 * 
	 * @param buffId
	 *            identifies the required buffer
	 * 
	 * @return the asked Buffer
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if buffId isn't lower than zero or greater than bufferSize
	 *             minus one
	 */
	StringBuffer get(int buffId);

	/**
	 * Returns one of the String buffers. <br>
	 * If the buffer doens't exist, returns a new buffer.
	 * 
	 * @param buffId
	 *            identifies the required buffer
	 * 
	 * @return the asked Buffer
	 * 
	 * @throws NullPointerException
	 *             if buffId is null
	 */
	StringBuffer get(String buffId);

	// ---------------------------------------------------------------------
	void append(String buffId, String buffer);

	/**
	 * Appends buffers of given OilWriterBuffer to all correspondent buffers of
	 * this object
	 * 
	 * @param buffer
	 *            the source
	 */
	void append(IOilWriterBuffer buffer);

	/**
	 * 
	 * @return the file's name of buffer specified by given id, or null if there
	 *         isn't any buffer with that id
	 */
	String getFileName(String buffId);

	/**
	 * Set the file's path of buffer specified by given id, or null to unset it (and use the default value)
	 */
	void setFileName(String buffId, String name);

	/**
	 * 
	 * @return the file's path of buffer specified by given id, or null if there
	 *         isn't any buffer with that id
	 */
	String getFilePath(String buffId);

	/**
	 * Set the file's path of buffer specified by given id, or null to unset it (and use the default value)
	 */
	void setFilePath(String buffId, String name);
}