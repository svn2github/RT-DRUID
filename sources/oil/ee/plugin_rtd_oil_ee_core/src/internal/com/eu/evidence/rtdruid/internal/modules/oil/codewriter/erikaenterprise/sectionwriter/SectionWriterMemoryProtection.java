/*
 * Created on 1-oct-2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.sectionwriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.AutoOptions;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IRemoteNotificationsConstants;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * This writer manages Remote Notifications
 * 
 * @author Nicola Serreli
 */
public class SectionWriterMemoryProtection extends SectionWriter implements
		IEEWriterKeywords, IRemoteNotificationsConstants,
		IGetEEOPTExtentions, IExtractObjectsExtentions,
		IExtractKeywordsExtentions {
	        
	public final static String EE_OPT_MEMORY_PROTECTION = "__EE_MEMORY_PROTECTION__";
	protected final static String indent1 = IWritersKeywords.INDENT;
	protected final static String indent2 = IWritersKeywords.INDENT + IWritersKeywords.INDENT;

	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;

	/** All data */
	protected final IVarTree vt;
	
	/**
	 * 
	 */
	public SectionWriterMemoryProtection() {
		this(null);
	}
	
	/**
	 * 
	 */
	public SectionWriterMemoryProtection(ErikaEnterpriseWriter parent) {
		super("MEMORY_PROTECTION", new String[] {}, //
				new String[] {},
				SWCategoryManager.defaultInstance.newCategory(
						IWritersKeywords.KERNEL_MEMORY_PROTECTION_TYPE,
						IWritersKeywords.KERNEL_MEMORY_PROTECTION_PRIORITY));
		
		this.parent = parent;
		this.vt = parent == null ? null : parent.getVt();
	}

	/**
	 * This method returns true if current instance of writer is enabled with
	 * specified keywords.
	 * 
	 * This writer is enabled if there is only one cpu
	 * 
	 * @return true if this writer is enabled
	 */
	protected boolean enabled() {
		return Collections.binarySearch(keywords, IWritersKeywords.OSEK_SC4) >=0 || 
				Collections.binarySearch(keywords, IWritersKeywords.KERNEL_MEMORY_PROTECTION) >=0 ;
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
		
		if (!parent.checkKeyword(IEEWriterKeywords.DEF__MULTI_STACK__) 
				&& parent.checkKeyword(IWritersKeywords.KERNEL_MEMORY_PROTECTION)) {
			throw new OilCodeWriterException("Memory protection requires multi stack enabled.");
		}
		


		return writeMemoryProtection();
	}
	
	/**
	 *  This method prepares data for <b>remote Notification </b>
	 * 
	 * @return buffers 
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeMemoryProtection() {
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		IOilWriterBuffer[] answer = new IOilWriterBuffer[oilObjects.length];
		for (int currentRtosId = 0; currentRtosId <oilObjects.length; currentRtosId++) {
			answer[currentRtosId] = new OilWriterBuffer();;
			
			final IOilObjectList ool = oilObjects[currentRtosId];
			CpuHwDescription descr = ErikaEnterpriseWriter.getCpuHwDescription(ool);
			if (descr != null && descr.hasMMU()) {
				
				List<ISimpleGenRes> applications = ool.getList(IOilObjectList.OSAPPLICATION);
				
				StringBuffer ee_c_buffer = answer[currentRtosId].get(FILE_EE_CFG_C);
				final ICommentWriter commentWriterC = getCommentWriter(ool, FileTypes.C);
	
				
				ee_c_buffer.append(
						commentWriterC.writerBanner("Memory Partitions") +
						indent1+ "const EE_MEMPROT_ENTRY_T EE_hal_memprot_entries[EE_HAL_MEMPROT_ENTRIES(EE_MAX_APP)] = {\n"+
						indent2+ "EE_MEMPROT_SYSTEM_ENTRY"
						);
	
				String end = "\n";
				
				for (ISimpleGenRes appl: applications) {
					
					long size = appl.getLong(SectionWriterOsApplication.OS_APPLICATION_MEM_SIZE);
					int log_size = (int) Math.ceil(Math.log(size) / Math.log(2));
					
					boolean trusted = appl.containsProperty(IEEWriterKeywords.OS_APPLICATION_TRUSTED) 
							&& "true".equalsIgnoreCase(appl.getString(IEEWriterKeywords.OS_APPLICATION_TRUSTED));
	
					ee_c_buffer.append("," + end +
							indent2 + "EE_MEMPROT_USER_ENTRY("+
							(appl.getInt(ISimpleGenResKeywords.OS_APPL_ID)) + "U, " +
							"0x" + Long.toHexString(appl.getLong(SectionWriterOsApplication.OS_APPLICATION_MEM_BASE)) + "U, " +
							"0x" + Long.toHexString(size) + "U, " +
							log_size + "U, " + 
							(trusted ? "EE_MEMPROT_TRUST_DATA" : "EE_MEMPROT_USR_DATA") + ")"
							);
					
					end = " " +commentWriterC.writerSingleLineComment(appl.getName());
							
				}
				
				ee_c_buffer.append(end + indent1 + "};\n\n");
			}
		}
		return answer;
	}
		
	/* (non-Javadoc)
	 * @see com.eu.evidence.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions#getEEOpt(int)
	 */
	public List<String> getEEOpt(int type, int rtosId) {
		List<String> answer = new ArrayList<String>();
		
		if ((type & EE_OPT_CPU_ONLY) != 0 && rtosId>=0) {
			/*******************************************************************
			 * AUTOMATIC OPTIONS (CPU DEPENDENT)
			 ******************************************************************/
			answer.add(EE_OPT_MEMORY_PROTECTION);
			
			CpuHwDescription descr = ErikaEnterpriseWriter.getCpuHwDescription(parent.getOilObjects()[rtosId]);
			if (descr != null && descr.hasMMU()) {
				answer.add("__EE_USE_MMU__");
			}
		}

		return answer;
	}

	@Override
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix)
			throws OilCodeWriterException {
		
		if (keywords.contains(IWritersKeywords.OSEK_SC4)) {
			keywords.add(IWritersKeywords.KERNEL_MEMORY_PROTECTION);
		}
		
		List<AutoOptions> options = new ArrayList<AutoOptions>();
		for (int rtodId=0; rtodId<rtosPrefix.length; rtodId++) {

			final String currentRtosPrefix = parent.computeOilRtosPrefix(rtosPrefix[rtodId]);
			options.add(new AutoOptions(currentRtosPrefix, "MEMORY_PROTECTION", "TRUE", IWritersKeywords.KERNEL_MEMORY_PROTECTION, false));
			options.add(new AutoOptions(currentRtosPrefix, "KERNEL_STACKS", "TRUE", IWritersKeywords.KERNEL_KERNEL_STACKS, false));

		}
		AutoOptions.updateKeywords(options, keywords, vt);
		if (keywords.contains(IWritersKeywords.KERNEL_MEMORY_PROTECTION)) {
			if (!keywords.contains(IWritersKeywords.KERNEL_SYS_CALL)) {
				keywords.add(IWritersKeywords.KERNEL_SYS_CALL);
			}
			if (!keywords.contains(IWritersKeywords.KERNEL_OS_APPLICATION)) {
				keywords.add(IWritersKeywords.KERNEL_OS_APPLICATION);
			}
		}
	}
	
	@Override
	public void updateObjects() throws OilCodeWriterException {
		// do nothing
	}

}
