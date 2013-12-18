/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterMakefile.java,v 1.5 2008/01/09 17:43:32 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.sectionwriter;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.RtdruidConfiguratorNumber;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IDistributionConstant;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEoptConstant;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * This writer builds ee.h, and adds basic informations like number of tasks and
 * their name. Those informations are common for all Erika Kernels
 * 
 * @author Nicola Serreli
 */
public class SectionWriterCommonKernelVectorSizeDefs extends SectionWriter 
		implements IEEWriterKeywords, IEEoptConstant {
	
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;
	
	/**
	 * 
	 */
	public SectionWriterCommonKernelVectorSizeDefs() {
		this(null);
	}
	/**
	 * 
	 */
	public SectionWriterCommonKernelVectorSizeDefs(ErikaEnterpriseWriter parent) {
		super("COMMON_KERNEL_DEFINITIONS", new String[] {}, //
				new String[] {},
				SWCategoryManager.defaultInstance.newCategory(SWCategoryManager.TYPE_END, 1000));
		
		this.parent = parent;
	}

	/**
	 * This method returns true if current instance of writer is enabled with
	 * specified keywords.
	 * 
	 * @return true if this writer is enabled
	 */
	protected boolean enabled() {
		return true;
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
	public IOilWriterBuffer[] internalWrite(IVarTree vt)
			throws OilCodeWriterException {
		parent.check(vt);

		return writeCommonDefinition();
	}
	
	/**
	 *  This method prepares base definition for Erika Kernels
	 * 
	 * @return buffers with kernel base definitions
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeCommonDefinition() throws OilCodeWriterException {
		
		IOilObjectList[] oilObjects = parent.getOilObjects();

		final int rtosNumber = oilObjects.length;
		IOilWriterBuffer[] answer = new IOilWriterBuffer[oilObjects.length];
		
		for (int rtosId = 0; rtosId < rtosNumber; rtosId++) {

			// ---------------- required ----------------
			IOilObjectList ool = oilObjects[rtosId];
			final ICommentWriter commentWriterH = getCommentWriter(ool, FileTypes.H);
			final String indent = IWritersKeywords.INDENT;

			// ---------------- prepare buffer ----------------
			answer[rtosId] = new OilWriterBuffer();
			final StringBuffer buffer = answer[rtosId].get(FILE_EE_CFG_H);

			Map<String, Integer> list = (Map<String, Integer>) ErikaEnterpriseWriter.getOsObject(ool, SGRK_OS_CPU_VECTOR_SIZE_DEFINES);
			if (list != null) {
				buffer.append(commentWriterH.writerBanner("Vector size defines"));
				
				ArrayList<String> keyes = new ArrayList<String>(list.keySet());
				Collections.sort(keyes);
				
				for (String key : keyes) {
					buffer.append(indent + "#define " +key + " " + list.get(key)+ "\n");
				}
			}

		}
		
		return answer;
	}

}
