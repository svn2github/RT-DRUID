/*
 * Created on 1-oct-2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.sectionwriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.AutoOptions;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IOilXMLLabels;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
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
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

/**
 * This writer manages Remote Notifications
 * 
 * @author Nicola Serreli
 */
public class SectionWriterMemoryProtection extends SectionWriter implements
		IEEWriterKeywords, IRemoteNotificationsConstants,
		IGetEEOPTExtentions, IExtractObjectsExtentions,
		IExtractKeywordsExtentions {

	public final static String SGR_OS_MAX_NESTING_LEVEL = "sgr_os_max_nesting_level";


	
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
			List<ISimpleGenRes> applications = ool.getList(IOilObjectList.OSAPPLICATION);
			ISimpleGenRes os = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);

			
			StringBuffer ee_c_buffer = answer[currentRtosId].get(FILE_EE_CFG_C);
			final ICommentWriter commentWriterC = getCommentWriter(os, FileTypes.C);

			
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
						(appl.getInt(ISimpleGenResKeywords.OS_APPL_ID)+1) + "U, " +
						"0x" + Long.toHexString(appl.getLong(SectionWriterOsApplication.OS_APPLICATION_MEM_BASE)) + "U, " +
						"0x" + Long.toHexString(size) + "U, " +
						log_size + "U, " + 
						(trusted ? "EE_MEMPROT_TRUST_DATA" : "EE_MEMPROT_USR_DATA") + ")"
						);
				
				end = " " +commentWriterC.writerSingleLineComment(appl.getName());
						
			}
			
			ee_c_buffer.append(end + indent1 + "};\n\n");
			
			
			writeIsr(ool, answer[currentRtosId]);

		}
		return answer;
	}
	
	
	protected void writeIsr(IOilObjectList ool, IOilWriterBuffer answer) {
		List<ISimpleGenRes> isrList = ool.getList(IOilObjectList.ISR);
		
		if (isrList.size() == 0) {
			return;
		}
		
		final String indent1 = IWritersKeywords.INDENT;
		final String indent2 = indent1 + IWritersKeywords.INDENT;

		List<ISimpleGenRes> osApplications = ool.getList(IOilObjectList.OSAPPLICATION);
		ISimpleGenRes os = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);

		StringBuffer ee_h_buffer = answer.get(FILE_EE_CFG_H);
		final ICommentWriter commentWriterH = getCommentWriter(os, FileTypes.H);

		StringBuffer ee_c_buffer = answer.get(FILE_EE_CFG_C);
		final ICommentWriter commentWriterC = getCommentWriter(os, FileTypes.C);
		

		int max_level = CpuHwDescription.DEFAULT_MAX_NESTING_LEVEL;
		
		if (os.containsProperty(SGR_OS_MAX_NESTING_LEVEL)) {
			max_level = os.getInt(SGR_OS_MAX_NESTING_LEVEL);
		} else if (os.containsProperty(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR)) {
			max_level = ((CpuHwDescription) os.getObject(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR)).getMaxNestedInts();
		}

		// ee_cfg.h
		ee_h_buffer.append(
				commentWriterH.writerBanner("ISR definition") +
				indent1 + "#define EE_MAX_NESTING_LEVEL     "+max_level+"\n" +
				indent1 + "#define EE_MAX_ISR               " + (isrList.size()) +"\n\n"); 				

		// ee_cfg.c
		ee_c_buffer.append(
				commentWriterC.writerBanner("ISR definition") +
				indent1 + "EE_as_ISR_RAM_type EE_as_ISR_stack[EE_MAX_NESTING_LEVEL];\n\n" +
				indent1 + "const EE_as_ISR_ROM_type EE_as_ISR_ROM[EE_MAX_ISR] = {\n");
				
		StringBuffer appl_id = new StringBuffer(commentWriterC.writerSingleLineComment("ISR to Application mapping"));
		StringBuffer isr_id = new StringBuffer(commentWriterC.writerSingleLineComment("ISR id"));

		String pre = "";
		String post = "";
		for (ISimpleGenRes isr : isrList) {
			String name = isr.getName();
			
			int aid = isr.containsProperty(ISimpleGenResKeywords.ISR_OS_APPLICATION_NAME) ? 
					1+ getOsApplicationIndex(isr.getString(ISimpleGenResKeywords.ISR_OS_APPLICATION_NAME), osApplications)
					: 0;
			int iid = isr.getInt(ISimpleGenResKeywords.ISR_ID);
			appl_id.append(indent1 + "#define ISR2_APP_"+name+"\t" + aid + "\n");
			isr_id.append(indent1 + "#define ISR2_ID_"+name+"\t" + iid + "\n");
			
			ee_c_buffer.append(pre + post + indent2 + "{ "+aid+" }");
			pre = ",";
			post = commentWriterC.writerSingleLineComment(name);
		}

		ee_h_buffer.append(appl_id + "\n" + isr_id + "\n");
		
		ee_c_buffer.append(" " + post+indent1+"};\n\n");

	}


	/**
	 * 
	 * @param osAppl
	 *            os application name
	 * @param osApplicationList
	 *            all os applications
	 * @return the position in the array of specified os application
	 */
	private int getOsApplicationIndex(String osAppl, List<ISimpleGenRes> osApplicationList) {
		if (osAppl != null) {
			for (int i=0; i<osApplicationList.size(); i++) {
				if (osAppl.equals(osApplicationList.get(i).getName())) {
					return i;
				}
			}
		}
		return -1;
	}
		
	/* (non-Javadoc)
	 * @see com.eu.evidence.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions#getEEOpt(int)
	 */
	public List<String> getEEOpt(int type, int rtosId) {
		List<String> answer = new ArrayList<String>();
		
		if ((type & EE_OPT_CPU_ONLY) != 0) {
			/*******************************************************************
			 * AUTOMATIC OPTIONS (CPU DEPENDENT)
			 ******************************************************************/
			answer.add(EE_OPT_MEMORY_PROTECTION);
			answer.add("__EE_USE_MMU__");
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
		final IVarTree vt = parent.getVt();

		final String osNestingLevelPath = S
					+ DataPackage.eINSTANCE.getOsApplication_OilVar().getName() + S
					+ IOilXMLLabels.OBJ_OS + parent.getOilHwRtosPrefix() + "MAX_NESTING_LEVEL";

		final IOilObjectList[] oilObjects = parent.getOilObjects();	
		for (IOilObjectList ool : oilObjects) {

			
			{ // nesting level
				ISimpleGenRes os = ool.getList(IOilObjectList.OS).get(0);
				String[] value = CommonUtils.getValue(vt, os.getPath() + osNestingLevelPath);
				if (value != null && value.length>0 && value[0] != null && value[0].length()>0) {
					os.setProperty(SGR_OS_MAX_NESTING_LEVEL, value[0]);
				}
			}

			
			// isr
			List<ISimpleGenRes> isrs = ool.getList(IOilObjectList.ISR);
			int isr_id = 0;
			for (ISimpleGenRes isr : isrs) {
				if (!isr.containsProperty(ISimpleGenResKeywords.ISR_ID)) {
					isr.setProperty(ISimpleGenResKeywords.ISR_ID, ""+isr_id);
					isr_id ++;
				}

			}

		}
	}

}
