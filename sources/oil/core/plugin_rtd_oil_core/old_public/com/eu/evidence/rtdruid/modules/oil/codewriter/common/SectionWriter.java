/*
 * Created on Nov 29, 2004
 *
 * $Id: SectionWriter.java,v 1.3 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.codewriter.common;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.Assert;

import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.IncompatibleWriterKeywordsException;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.RequiredWriterKeywordsException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.CommentWriterEmpty;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.CommentsManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.interfaces.ISWCategory;
import com.eu.evidence.rtdruid.modules.oil.interfaces.ISectionWriter;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * Contains a writer for a section. <br>
 * This writer is identifies by an {@link #id id}and contains some relations
 * with other writers, identifies by theirs id. For that
 * {@link #requiredKeys requiredKey}contains all required writers and
 * {@link #wrongfulKeys wrongfulKeys}contains all incompatible writers.
 * 
 * @author Nicola Serreli
 */

public abstract class SectionWriter implements ISectionWriter {

	/** Identifies this writer */
	protected String id;
	
	/** The category of this writer */
	protected ISWCategory category;


	/** If true, this writer is enabled to work */
	private boolean enabled = false;

	/** This writer requires also this keys */
	protected String[] requiredKeys = new String[0];

	/** This writer cannot be used with this keys */
	protected String[] wrongfulKeys = new String[0];

	/** Current keywords (sorted) */
	protected List<String> keywords = new ArrayList<String>();

	//----------------- CONSTRUCTORS ----------------------

	/**
	 * Init internal structure. Required and wrongful keys are setted to empty
	 * arrays (not null)
	 * 
	 * @param id
	 *            identifies this writer
	 */
	protected SectionWriter(String wId, ISWCategory category) {
		Assert.isNotNull(wId);
		this.id = wId;
		this.category = category == null ? SWCategoryManager.EMPTY_CATEGORY : category;
	}

	/**
	 * Init internal structure.
	 * 
	 * @param wId
	 *            identifies this writer
	 * @param rKeys
	 *            contains all ids of required writers
	 * @param wKeys
	 *            contains all ids of incompatibles writers
	 */
	protected SectionWriter(String wId, String[] rKeys, String[] wKeys, ISWCategory category) {
		Assert.isNotNull(wId);
		id = wId;
		if (rKeys != null) {
			requiredKeys = rKeys;
		}
		if (wKeys != null) {
			wrongfulKeys = wKeys;
		}
		this.category = category == null ? SWCategoryManager.EMPTY_CATEGORY : category;
	}

	public String getId() {
		return id;
	}
	
	public ISWCategory getCategory() {
		return category;
	}
	
	protected void setCategory(ISWCategory category) {
		this.category = category;
	}
	
	//----------------- INIT METHODS ----------------------

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.hidden.modules.oil.codewriter.common.ISectionWriter#checkKeys(java.lang.String[])
	 */
	final public void checkKeys(String[] keys)
			throws IncompatibleWriterKeywordsException,
			RequiredWriterKeywordsException {

		if (enabled(keys)) {
			internalCheckKeys();
		}
	}

	/**
	 * This method check that the given keys list contains all required keys and
	 * none of wrongful keys.
	 * 
	 * @throws IncompatibleWriterKeywordsException
	 *             if there is one or more keywords incompatible with this
	 *             writer
	 * @throws RequiredWriterKeywordsException
	 *             if this writer requires one or more keywords
	 */
	protected void internalCheckKeys()
			throws IncompatibleWriterKeywordsException,
			RequiredWriterKeywordsException {

		// required keys
		for (int i = 0; i < requiredKeys.length; i++) {
			if (Collections.binarySearch(keywords, requiredKeys[i]) < 0) {
				throw new RequiredWriterKeywordsException(id, requiredKeys[i]);
			}
		}

		// incompatible keys
		for (int i = 0; i < wrongfulKeys.length; i++) {
			if (Collections.binarySearch(keywords, wrongfulKeys[i]) >= 0) {
				throw new IncompatibleWriterKeywordsException(id,
						wrongfulKeys[i]);
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.hidden.modules.oil.codewriter.common.ISectionWriter#enabled(java.lang.String[])
	 */
	final public boolean enabled(String[] keys) {

		// make a copy and sort it
		keywords = Arrays.asList(keys);
		Collections.sort(keywords);

		enabled = enabled();
		return enabled;
	}

	/**
	 * This method returns true if current instance of writer is enabled with
	 * specified keywords.
	 * 
	 * @return true if this writer is enabled
	 */
	protected boolean enabled() {

		return Collections.binarySearch(keywords, id) >= 0;
	}

	//-------------------- WRITE METHODS -------------------

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.hidden.modules.oil.codewriter.common.ISectionWriter#write(com.eu.evidence.rtdruid.vartree.IVarTree)
	 */
	final public IOilWriterBuffer[] write(IVarTree vt)
			throws OilCodeWriterException {

		if (!enabled) {
			return new IOilWriterBuffer[0];
		}

		return internalWrite(vt);
	}

	/**
	 * This method parse the data, prepares all buffers for
	 * <code>.c/.h/.s/.asm</code> files and store them inside a
	 * {@link OilWriterBuffer OilWriterBuffer}. If there are more than one cpu,
	 * uses one {@link OilWriterBuffer OilWriterBuffer}for each cpu.
	 * 
	 * @param vt
	 *            all data (cannot be null)
	 * 
	 * @return one {@link OilWriterBuffer OilWriterBuffer}for each cpu.
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some errors
	 */
	protected abstract IOilWriterBuffer[] internalWrite(IVarTree vt)
			throws OilCodeWriterException;

	
	public static ICommentWriter getCommentWriter(IOilObjectList ool, String fileType) {
		ICommentWriter commentWriter;
		CommentsManager cManager = (CommentsManager) AbstractRtosWriter.getOsObject(ool, ISimpleGenResKeywords.OS_CPU_COMMENT_MANAGER);
			if (cManager != null) {
				commentWriter = cManager.getCommentWriter(fileType);
			} else {
				commentWriter = new CommentWriterEmpty();
			}
		return commentWriter;
	}
}