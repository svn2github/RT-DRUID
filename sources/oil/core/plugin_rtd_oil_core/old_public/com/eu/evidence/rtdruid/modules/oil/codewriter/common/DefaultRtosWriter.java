/*
 * Created on Nov 29, 2004
 *
 * $Id: DefaultRtosWriter.java,v 1.3 2008/05/14 17:13:23 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.codewriter.common;



import java.util.ArrayList;
import java.util.Map;

import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.interfaces.ISectionWriter;
import com.eu.evidence.rtdruid.modules.oil.interfaces.ISectionWriterWithOptions;



/**
 * This abstract RT-OS Writer split output code in many sections, and for each
 * section use a distinct {@link SectionWriter SectionWriter}. Each writer is
 * identifies by a keyword and it's used only if that keyword is stored inside
 * the data tree. In this way the writer tries to understand which data are
 * stored inside the tree and tries use the right
 * {@link SectionWriter SectionWriter}.
 * 
 * @author Nicola Serreli
 */
public abstract class DefaultRtosWriter extends AbstractRtosWriter {

	/**
	 * The main method. <br>
	 * This method parse the data, prepares all buffers for
	 * <code>.c/.h/.s/.asm</code> files and store them inside a
	 * {@link OilWriterBuffer OilWriterBuffer}. If there are more than one cpu,
	 * uses one {@link OilWriterBuffer OilWriterBuffer}for each cpu.
	 * 
	 * @return one {@link OilWriterBuffer OilWriterBuffer}for each cpu.
	 * 
	 * @throws OilCodeWriterException
	 *             throw this exception if there are some problems
	 */
	@SuppressWarnings("unchecked")
	public final IOilWriterBuffer[] write() throws OilCodeWriterException {
		ArrayList<IOilWriterBuffer> answer = new ArrayList<IOilWriterBuffer>();

		ISectionWriter[] writers = getWriters();

		// set options
		for (int i = 0; i < writers.length; i++) {
			if (writers[i] instanceof ISectionWriterWithOptions) {
				((ISectionWriterWithOptions) writers[i]).initOptions((Map<String, Object>) options);
			}
		}
		
		// search keys
		for (int i = 0; i < writers.length; i++) {
			writers[i].checkKeys(keys);
		}

		// write
		for (int i = 0; i < writers.length; i++) {
			appendBuffers(answer, writers[i].write(vt));
		}

		IOilWriterBuffer[] tmp = (IOilWriterBuffer[]) answer
				.toArray(new OilWriterBuffer[answer.size()]);
		
		updateDirectories(tmp);
		
		writeBanners(tmp);
		return tmp;
	}

	/**
	 * Appends the given array of OilWriterBuffer to the correspondent
	 * OilWriterBuffer stored inside the given ArrayList. If the array list has
	 * less elements, its size will be incresed.
	 * 
	 * @param currentBuffers
	 *            the previous list of buffers (can be empty but not null)
	 * @param newBuffers
	 *            all new buffers (can be null or empty)
	 * 
	 * @throws NullPointerException
	 *             if currentBuffers is null
	 */
	public static void appendBuffers(ArrayList<IOilWriterBuffer> currentBuffers,
			IOilWriterBuffer[] newBuffers) {
		if (newBuffers == null) {
			return;
		}
		for (int i = 0; i < newBuffers.length; i++) {
			if (i == currentBuffers.size()) {
				currentBuffers.add(newBuffers[i]);
			} else {
				((IOilWriterBuffer) currentBuffers.get(i)).append(newBuffers[i]);
			}
		}
	}

	

	/**
	 * Adds a path to each buffer if there is more than one cpu. Default type is "cpu#"
	 * 
	 * @param buffers
	 *            all buffers
	 */
	protected void updateDirectories(IOilWriterBuffer[] buffers) {
		if (buffers.length >1) {
			for (int i = 0; i<buffers.length; i++) {
				
				String path = "cpu" + i;
				
				IOilWriterBuffer buf = buffers[i];
				String[] buffIds = buf.getKeys();
				for (String buffId : buffIds) {
					buf.setFilePath(buffId, path);
				}
			}
		}
	}
	
	/**
	 * Adds a banner/header to each buffer
	 * 
	 * @param buffers
	 *            all buffers
	 */
	protected void writeBanners(IOilWriterBuffer[] buffers) {
		// as default : do nothing
	}

	/***************************************************************************
	 * 
	 * ABSTRACT METHOD
	 *  
	 **************************************************************************/

	/**
	 * This method returns all {@link SectionWriter SectionWriter}availables
	 * with this RT-OS Writer
	 */
	protected abstract ISectionWriter[] getWriters();

}
