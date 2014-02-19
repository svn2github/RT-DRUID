/*
 * Created on 1-oct-2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.sectionwriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
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
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EmptyMacrosForSharedData;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IMacrosForSharedData;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * This writer manages Remote Notifications
 * 
 * @author Nicola Serreli
 */
public class SectionWriterQueuedSpinlock extends SectionWriter implements
		IEEWriterKeywords, IExtractKeywordsExtentions,
		IExtractObjectsExtentions, IGetEEOPTExtentions {
	
	/**
	 * 
	 */
	private static final String SPINLOCK_STATUS_ARRAY = "EE_hal_spinlock_status";

	/**
	 * 
	 */
	private static final String SPINLOCK_BASE_NAME = "EE_hal_spinlock_value_";

	/**
	 * 
	 */
	private static final String SPINLOCK_VALUE_ARRAY = "EE_hal_spinlock_value";

	protected final boolean enableRemoteResources = false;
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;

	/** All data */
	protected final IVarTree vt;
	
	/**
	 * 
	 */
	public SectionWriterQueuedSpinlock() {
		this(null);
	}
	
	/**
	 * 
	 */
	public SectionWriterQueuedSpinlock(ErikaEnterpriseWriter parent) {
		super("Queued Spinlock", new String[] {}, //
				new String[] {},
				SWCategoryManager.defaultInstance.newCategory(SWCategoryManager.TYPE_INIT, 10));
		
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
		return parent.getRtosSize() > 1 
				&& Collections.binarySearch(keywords, IWritersKeywords.CPU_NIOSII) <0 
				&& Collections.binarySearch(keywords, QUEUED_SPINLOCK) >=0;
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

		return writeQueuedSpinlocks();
	}
	
	/**
	 *  This method prepares data for <b>remote Notification </b>
	 * 
	 * @return buffers 
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeQueuedSpinlocks() {

		
		final String indent1 = IWritersKeywords.INDENT;
		final String indent2 = indent1 + IWritersKeywords.INDENT;
		final String indent3 = indent2 + IWritersKeywords.INDENT;

		final int rtosNumber = parent.getRtosSize();
		IOilObjectList[] oilObjects = parent.getOilObjects();
		IOilWriterBuffer[] answer = new IOilWriterBuffer[rtosNumber];
		for (int i=0; i<answer.length; i++) {
			answer [i] =  new OilWriterBuffer();
		}
	
		boolean binaryDistr = parent.checkKeyword(IEEWriterKeywords.DEF__EE_USE_BINARY_DISTRIBUTION__);
		final String MAX_CPU = (binaryDistr ? "RTD_" : "EE_") + "MAX_CPU";
		final String MAX_RN = (binaryDistr ? "RTD_" : "EE_") + "MAX_RN";

		IMacrosForSharedData macros = new EmptyMacrosForSharedData();
		if (rtosNumber>0) {
			CpuHwDescription currentStackDescription = ErikaEnterpriseWriter.getCpuHwDescription(oilObjects[0]);
			if (currentStackDescription != null) {
				macros =currentStackDescription.getShareDataMacros();
			}
		}
		if (parent.checkPragma(0)) {
			macros = macros.getPragma();
		}

		
		/***********************************************************************
		 * 
		 * prepare the buffers for Common.c :
		 * 
		 * #DEFINE xxx
		 * Arrays
		 * other data
		 * 
		 **********************************************************************/
		
		
		
		
		if (rtosNumber >0 && parent.checkKeyword(DEF__MSRP__)) {
			/*******************************************************************
			 * 
			 * SPIN LOCK
			 *  
			 ******************************************************************/
			ICommentWriter commentWriterC_common = getCommentWriter(oilObjects[0], FileTypes.C);
			StringBuffer sbCommon_c = answer[0].get(FILE_EE_COMMON_C);

			StringBuilder sbCfg_h = new StringBuilder(commentWriterC_common.writerBanner("Spin lock IDs"));
			
			sbCommon_c.append(commentWriterC_common.writerBanner("Spin locks") 
					+ "#include \"ee.h\"\n"
					+ parent.addCommonDataMacro(FILE_EE_COMMON_C));
			
			if (binaryDistr) {
				sbCommon_c.append("#ifndef " + MAX_CPU + "\n"
						+ "#define " + MAX_CPU + " "+ rtosNumber +"\n"
						+ "#endif\n\n");
			}

			// add a spin lock for each global resources
			String pre ="";
			String pre2 ="";
			String post="";
//			StringBuffer sbSpinArrays = new StringBuffer();
			StringBuffer sbSpinStatusArray = new StringBuffer();
			StringBuffer sbSpinValuesArray = new StringBuffer();
			StringBuffer sbSpinShare = new StringBuffer();
//			int spinNumber = 0;
			int spinlockIndex = 0;


			if (enableRemoteResources) {
				// search all globalResources
				Properties globalResources = new Properties();
				for (int rtosId = 0; rtosId < rtosNumber; rtosId++) {
					// all objects for current os
					IOilObjectList ool = oilObjects[rtosId];
	
					for (Iterator<ISimpleGenRes> iter = ool.getList(IOilObjectList.RESOURCE).iterator(); iter.hasNext(); ) {
						ISimpleGenRes res = (ISimpleGenRes) iter.next();
						
						if (res.containsProperty(ISimpleGenResKeywords.RESOURCE_GLOBAL) && 
								"true".equalsIgnoreCase(res.getString(ISimpleGenResKeywords.RESOURCE_GLOBAL))) {
	
							globalResources.setProperty(res.getString(ISimpleGenResKeywords.RESOURCE_SYS_ID), res.getName());
						}
					}

				}

				// number of spinlock
				final int count = globalResources.size();
//				spinNumber += count;
				
				for (int i = 0; i<count; i++) {
				    String name = globalResources.getProperty("" + i);
				    sbSpinStatusArray.append(pre + post + indent2+"((EE_UINT32)&"+SPINLOCK_BASE_NAME+name+"[0]) + 1U");
				    sbSpinValuesArray.append(pre2 + indent2+"&"+SPINLOCK_BASE_NAME+name+"[0]");
	//			    sbSpinArrays.append(indent1+"extern EE_UINT32 EE_hal_spin_value_"+name+"["+MAX_CPU+"];\n");
				    sbSpinShare.append(
				    		macros.vectorRamUnitialized(
				    				indent1+"EE_UINT16 ",
				    				SPINLOCK_BASE_NAME+name,
				    				"["+MAX_CPU+"]",
				    				";\n"));
	
					pre = ",";
					pre2 = ",\n";
					post = "\t /* " + name + " */\n";
					spinlockIndex++;
				}
			}

			 sbCfg_h.append("#define EE_MAX_SPINLOCK_USER " + spinlockIndex + "\n\n");
			 final int sbCfg_h_size = sbCfg_h.length();

			// add a spin lock for each cpu
//			spinNumber += rtosNumber;
			for (int rtosId=rtosNumber-1; rtosId>=0; rtosId--) {
				// all objects for current os
				IOilObjectList ool = oilObjects[rtosId];
				String name = ErikaEnterpriseWriter.getOSName(ool);

			    sbSpinStatusArray.append(pre + post + indent2+"((EE_UINT32)&"+SPINLOCK_BASE_NAME+name+"[0]) + 1U");
			    sbSpinValuesArray.append(pre2 + indent2+"&"+SPINLOCK_BASE_NAME+name+"[0]");
//			    sbSpinArrays.append(indent1+"extern EE_UINT32 EE_hal_spin_value_"+name+"["+MAX_CPU+"];\n");
			    sbSpinShare.append(
			    		macros.vectorRamUnitialized(
			    				indent1+"EE_UINT16 ",
			    				SPINLOCK_BASE_NAME+name,
			    				"["+MAX_CPU+"]",
			    				";\n"));
			    

				pre = ",";
				pre2 = ",\n";
				post = "\t /* " + name + " */\n";

			    sbCfg_h.insert(sbCfg_h_size, "#define EE_SPINLOCK_CORE" + rtosId + " " + spinlockIndex + post );
			    spinlockIndex++;
			}

			sbCommon_c.append(
					sbSpinShare.toString() + "\n" +
//					indent1 + "#define RTD_MAX_SPIN_LOCK "+(spinNumber)+"\n\n" +
//					sbSpinArrays.toString() + "\n\n" +
					macros.vectorRam(
						indent1 + "EE_UINT32 ",
						SPINLOCK_STATUS_ARRAY, "[EE_MAX_SPINLOCK_OS]",
						" = {\n" +
						sbSpinStatusArray.toString() + " " + post +
						indent1 + "};"
						)+ "\n\n" +
					macros.constVectorRom(
						indent1 + "EE_UINT16 * const ",
						SPINLOCK_VALUE_ARRAY,"[EE_MAX_SPINLOCK_OS]",
						" = {\n" +
						sbSpinValuesArray.toString() + "\n" +
						indent1 + "};") +
					"\n\n");
			
			sbCfg_h.append("#define EE_MAX_SPINLOCK_OS " + spinlockIndex + "\n\n");
			
			for (int rtosId = 0; rtosId < rtosNumber; rtosId++) {
				StringBuffer sbCommon_h = answer[rtosId].get(FILE_EE_CFG_H);
				sbCommon_h.append(sbCfg_h.toString()+ "\n");
			}

		}
		
		
		
		
		
		
		
//					macros.vectorRam(indent1 + "EE_TYPERN_NOTIFY ", "EE_rn_type","["+MAX_RN+"][2]", sb_rn_type_body.toString()) +"\n"
//					
//					+ indent1 + "/* For each RN: The counter number if EE_RN_COUNTER, or -1 */\n"
//					+ indent1 + "#ifdef __RN_COUNTER__\n"
//					+ macros.constVectorRom(indent2 + "const EE_TYPECOUNTER ", "EE_rn_counter","["+MAX_RN+"]", sb_rn_counter_body.toString())
//			        + indent1 + "#endif\n\n"
//			        
//			        + indent1 + "#ifdef __RN_EVENT__ \n"
//					+ macros.vectorRam(indent2 + "EE_TYPEEVENTMASK ", "EE_rn_event","["+MAX_RN+"][2]", sb_rn_event_body.toString())
//			        + indent1 + "#endif\n\n"
//			        
//					+ macros.vectorRam(indent1 + "EE_TYPERN ", "EE_rn_next","["+MAX_RN+"][2]", sb_rn_next_body.toString()) + "\n"
//					
//			        + macros.vectorRam(indent1 + "EE_UREG ", "EE_rn_pending","["+MAX_RN+"][2]", sb_rn_pending_body.toString()) + "\n" +
//			        
//					indent1 + "#ifdef __RN_FUNC__\n"
//					+ macros.constVectorRom(indent2 + "/* const EE_ADDR ", "EE_rn_func","["+MAX_RN+"]"," = {(EE_ADDR)f,...};*/\n") +
//					indent1 + "#endif\n\n" +
//					indent1 + "#ifdef __RN_SEM__\n" +
//					macros.constVectorRom(indent2 + "/*EE_SEM * const ", "EE_rn_sem","["+MAX_RN+"]",";*/\n") +
//					indent1 + "#endif\n\n");
	
			
		
		return answer;
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions#updateKeywords(java.util.ArrayList, java.lang.String[])
	 */
	@Override
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix) throws OilCodeWriterException {
		if (parent.getRtosSize() > 1) {
	
			final IVarTree vt = parent.getVt();
	
			//final ArrayList ee_opts = new ArrayList();
			for (int i=0; i<rtosPrefix.length; i++) {
				
				/*******************************************************************
				 * SPINLOCKS TYPE
				 ******************************************************************/
				String path = parent.computeOilRtosPrefix(rtosPrefix[i]) + "SPINLOCKS";
	
				String[] child = new String[1];
				String board_type = CommonUtils.getFirstChildEnumType(vt,
						path , child);
				if ("QUEUED".equals(board_type)
							&& !keywords.contains(QUEUED_SPINLOCK)) {
						keywords.add(QUEUED_SPINLOCK);
				}
			}
		}
	}
	

	/* (non-Javadoc)
	 * @see com.eu.evidence.modules.oil.erikaenterprise.subwriters.IExtractObjectsExtentions#updateObjects()
	 */
	public void updateObjects() throws OilCodeWriterException {
		// do nothing
	}

	
	/* (non-Javadoc)
	 * @see com.eu.evidence.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions#getEEOpt(int)
	 */
	public List<String> getEEOpt(int type, int rtosId) {
		List<String> answer = new ArrayList<String>();
		
		if ((type & EE_OPT_COMMON_AUTO_ONLY) != 0) {
			/*******************************************************************
			 * AUTOMATIC OPTIONS
			 ******************************************************************/
			if (parent.checkKeyword(QUEUED_SPINLOCK)) {
				answer.add("EE_QUEUEING_SPINLOCKS");
			}
		}

		return answer;
	}
}
