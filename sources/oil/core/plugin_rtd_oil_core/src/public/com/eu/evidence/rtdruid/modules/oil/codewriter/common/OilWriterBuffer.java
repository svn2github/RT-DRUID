/*
 * Created on Nov 29, 2004
 *
 * $Id: OilWriterBuffer.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.codewriter.common;


import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;


/**
 * This little class buffers for one cpu. <br>
 * One buffer for <code>.c</code> file, one for <code>.h</code> file and one
 * for <code>.s/.asm</code> file.
 * 
 * @author Nicola Serreli
 */
public class OilWriterBuffer implements IOilWriterBuffer {

	/** Contains all buffers */
	protected LinkedHashMap<String, StringBuffer> buffers = new LinkedHashMap<String, StringBuffer>();

	// ---------------------------------------------------------------------

	/**
	 * Returns the number of available buffers
	 * 
	 * @return the number of available buffers
	 */
	public int getBufferNumber() {
		return buffers.size();
	}

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
	public String[] getKeys() {
		String[] answer = new String[buffers.size()];
		int i=0;
		for (Iterator<String> iter = buffers.keySet().iterator(); iter.hasNext(); i++) {
			answer[i] = (String) iter.next();
		}
		return answer;
	}

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
	public StringBuffer get(int buffId) {
		if (buffId < 0 || buffId > buffers.size()) {
			throw new IndexOutOfBoundsException(
					"The given buffId isn't a valid id." + "BuffId = " + buffId
							+ "; buffer.size() = " + buffers.size());
		}
		Iterator<Entry<String, StringBuffer>> iter = buffers.entrySet().iterator();
		StringBuffer answer = null;
		for (int i = 0; i < buffId; i++) {
			answer = (StringBuffer) iter.next().getValue();
		}
		return answer;
	}

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
	public StringBuffer get(String buffId) {
		StringBuffer answer = null;

		if (!buffers.containsKey(buffId)) {
			answer = new StringBuffer();
			buffers.put(buffId, answer);

		} else {
			answer = (StringBuffer) buffers.get(buffId);
		}

		return answer;
	}

	// ---------------------------------------------------------------------

	/**
	 * Appends the buffer to the specified internal buffer. If it doesn't exist,
	 * make a new one.
	 * 
	 * @param buffer
	 *            the source
	 */
	public void append(String buffId, String buffer) {

		get(buffId).append(buffer);
	}

	/**
	 * Appends buffers of given OilWriterBuffer to all correspondent buffers of
	 * this object
	 * 
	 * @param buffer
	 *            the source
	 */
	public void append(IOilWriterBuffer ibuffer) {
		
		if (ibuffer instanceof OilWriterBuffer) {
			OilWriterBuffer buffer = (OilWriterBuffer) ibuffer; 
	
			Set<String> keys = buffer.buffers.keySet();
			for (Iterator<String> iter = keys.iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				// use this.get(String) to get the rigth StringBuffer (and create a
				// new one if needed)
				get(key).append((StringBuffer) buffer.buffers.get(key));
			}
			
			
			for (Entry<Object, Object> val : buffer.fileName.entrySet()) {
				if (!fileName.containsKey(val.getKey())) {
					fileName.put(val.getKey(), val.getValue());
				}
			}
			
			for (Entry<Object, Object> val : buffer.filePath.entrySet()) {
				if (!filePath.containsKey(val.getKey())) {
					filePath.put(val.getKey(), val.getValue());
				}
			}
			
		} else {
			// TODO: add support for a generic IOilWriterBuffer  
			throw new UnsupportedOperationException();
		}
	}

	// ----------------------

	/**
	 * Returns a string Rapresentation of this Oil Writer Buffer
	 * 
	 * @return a string Rapresentation of this Oil Writer Buffer
	 */
	public String toString() {

		StringBuffer answer = new StringBuffer();

		for (Entry<String, StringBuffer> entry : buffers.entrySet()) {
			String key = entry.getKey();
			StringBuffer buff = entry.getValue();

			answer.append("------------------- BUFFER ("+key+")" + getFilePath(key) + " / " + getFileName(key)
					+ " ------------------- \n");
			answer.append(buff);
		}
		
		return answer.toString();
	}
	
	// -------------------------
	
	private Properties filePath = new Properties();
	private Properties fileName = new Properties();



	/**
	 * 
	 * @return the file's name of buffer specified by given id, or null if there
	 *         isn't any buffer with that id
	 */
	public String getFileName(String buffId) {
		return fileName.getProperty(buffId, buffId);
	}
	
	/**
	 * 
	 * @return the file's name of buffer specified by given id, or null if there
	 *         isn't any buffer with that id
	 */
	public void setFileName(String buffId, String name) {
		if (name == null) {
			fileName.remove(buffId);
		} else {
			fileName.setProperty(buffId, name);
		}
	}

	
	/**
	 * 
	 * @return the file's name of buffer specified by given id, or null if there
	 *         isn't any buffer with that id
	 */
	public String getFilePath(String buffId) {
		return filePath.getProperty(buffId, "");
	}

	/**
	 * 
	 * @return the file's name of buffer specified by given id, or null if there
	 *         isn't any buffer with that id
	 */
	public void setFilePath(String buffId, String path) {
		if (path == null) {
			filePath.remove(buffId);
		} else {
			filePath.setProperty(buffId, path);
		}
	}

}