/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterMakefile.java,v 1.5 2008/01/09 17:43:32 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.sectionwriter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.HostOsUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OsType;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.RtdruidConfiguratorNumber;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEoptConstant;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * This writer builds makefile for erika, using source distributions.
 * 
 * Contains a standard makefile for SingleProcessor system  
 * 
 * @author Nicola Serreli
 */
public class SectionWriterMakefile_SP extends SectionWriter implements IEEWriterKeywords, IEEoptConstant {
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;

	/** All data */
	protected final IVarTree vt;

	/**
	 * 
	 */
	public SectionWriterMakefile_SP() {
		this(null);
	}
	/**
	 * 
	 */
	public SectionWriterMakefile_SP(ErikaEnterpriseWriter parent) {
		super("MAKEFILE_SP", new String[] {}, //
				new String[] {},
				SWCategoryManager.defaultInstance.newCategory(SWCategoryManager.TYPE_MAKEFILE, SWCategoryManager.defaultPriority));
		
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
		return parent.getRtosSize() == 1 && Collections.binarySearch(keywords, IWritersKeywords.CPU_NIOSII) <0;
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

		return writeMakefile();
	}
	
	/**
	 *  This method prepares data for <b>makefile </b>
	 * 
	 * @return buffers about Source and Binary Distribution
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeMakefile() throws OilCodeWriterException {

		
		// check if is needed a binary distribution
		final boolean useBinaryDistr = parent.checkKeyword(IEEWriterKeywords.DEF__EE_USE_BINARY_DISTRIBUTION__);
		
		final boolean enableRules = !(parent.getOptions().containsKey(IWritersKeywords.WRITER_DISABLE_EE_RULES) 
				&& "true".equalsIgnoreCase("" +parent.getOptions().get(IWritersKeywords.WRITER_DISABLE_EE_RULES)));


		final IOilObjectList[] oilObjects = parent.getOilObjects();		

		final int rtosNumber = oilObjects.length;
		IOilWriterBuffer[] answer = new IOilWriterBuffer[oilObjects.length];

		// for each rt-os, prepare a distrinct file
		for (int rtosId = 0; rtosId < rtosNumber; rtosId++) {

			answer[rtosId] = new OilWriterBuffer();
			// ---------------- required ----------------

			IOilObjectList ool = oilObjects[rtosId];
			StringBuffer sbMakefile = answer[rtosId].get(FILE_MAKEFILE);
			final ICommentWriter commentWriterMf = getCommentWriter(ool, FileTypes.MAKEFILE);

			// ------------------------------------------

//			String projectName = ErikaEnterpriseWriter.getOSName((ISimpleGenRes) ool.getList(IOilObjectList.OS)
//					.get(0));

			/*******************************************************************
			 * HEADER
			 ******************************************************************/
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(System.currentTimeMillis());
			String date = (c.get(Calendar.MONTH)+1) +"/"+c.get(Calendar.DAY_OF_MONTH)+"/"+c.get(Calendar.YEAR);
			sbMakefile
					.append(
							//"# "
//							//+ projectName
//							+ "# Date             : "+date+"\n"
//							+ "# RT-Druid version : "+ReadVersion.getRTDruidVersion()+"\n"
//							//+ "# OIL File         : \n"
//							//+ "# Architecture     : \n"
//							+ "#\n\n" +
//
							"### Setting Erika's variables:\n"
							+ "# ERIKA_FILES= ../../..\n"
							+ "# APPBASE = .\n"
							+ "# \n"
							+ "# EEOPT =\n\n");

			
			{
				String confNumber = RtdruidConfiguratorNumber.getRTDruidConfiguratorNumber();
				if (confNumber != null && confNumber.length()>0) {
					sbMakefile.append("\nRTDRUID_CONFIGURATOR_NUMBER:="+confNumber+"\n\n");
				}
			}
			
			if (useBinaryDistr) {
				// UPDRTD eliminare o spostare
				
//				final String distrVarName = parent.getDistributionLibraryName(sgrCpu, rtosId);
//
//				sbMakefile.append(CommonUtils
//						.writerBannerMakeFile("Binary Distribution")+
//						"EELIB = "+distrVarName+"\n" );
			}
			/*******************************************************************
			 * USER OPTIONS
			 ******************************************************************/
			{
				sbMakefile.append(commentWriterMf
						.writerBanner("User options"));
				String[] options = parent.extractEE_Opts(IGetEEOPTExtentions.EE_OPT_USER_ONLY, rtosId);
				for (int i=0; i<options.length; i++) {
				    sbMakefile.append("EEOPT += " + options[i] + "\n");
				}
			}

			// ???????????????????
			if (!useBinaryDistr) {
				/*******************************************************************
				 * AUTOMATIC OPTIONS
				 ******************************************************************/
				sbMakefile.append(commentWriterMf
						.writerBanner("Automatic options"));

				String[] options = parent.extractEE_Opts(EE_OPT_COMMON_AUTO_ONLY | EE_OPT_CPU_ONLY | EE_OPT_ENABLE_DISTR, rtosId);
				for (int i=0; i<options.length; i++) {
				    sbMakefile.append("EEOPT += " + options[i] + "\n");
				}
				if (SectionWriterCommonKernelDefs.includeEE_opt_application) {
					sbMakefile.append("EEOPT += " + FILE_EE_CFG_H_SECTION_EEOPT_DEFINES + "\n");
				}
			}
			
			
			/*******************************************************************
			 * EEBASE
			 ******************************************************************/
			{
				final String eeBasePath = parent.getEE_location();
				OsType wrapper = HostOsUtils.common.getTarget();
				sbMakefile.append(
						commentWriterMf.writerBanner("Erika base directory") +
						"ifdef ERIKA_FILES\n"+
						"ifdef EEBASE\n"+
						IWritersKeywords.INDENT + "$(warning EEBASE is set, but it has been overridden by ERIKA_FILES)\n"+
						"endif\n"+
						"EEBASE := "+wrapper.wrapPath("${ERIKA_FILES}")+"\n"+
						"\n"+
						"else # ERIKA_FILES\n"+
						"\n"+
						"ifndef EEBASE\n"+
						(eeBasePath == null? 
								  "        ${error RT-Druid was not able to find a default value for erika file. Please set ERIKA_FILES before run the makefile}"
								: "        EEBASE := "+wrapper.wrapPath(eeBasePath)
						) +"\n"+
						"else\n"+
						"        $(warning The usage of EEBASE is deprecated. Please use ERIKA_FILES)\n"+
						"endif\n"+
						"endif # ERIKA_FILES\n"+
						"# ERIKA_FILES has fulfilled its role. Make sure it's not used inside Erika makefiles\n"+ 
						"ERIKA_FILES :=\n"+
						( enableRules ? "$(info Using erika files in $(EEBASE))\n" : "")
		        );
			}
			
			
			
			/*******************************************************************
			 * EXTENTIONS
			 ******************************************************************/
			for (String value : AbstractRtosWriter.getOsProperties(ool,SGRK__MAKEFILE_EXTENTIONS__)) {
				sbMakefile.append(value);
			}

			{
				/***********************************************************************
				 * CONTRIBUTION to variables
				 ***********************************************************************/
				for (String value : AbstractRtosWriter.getOsProperties(ool, SGRK__MAKEFILE_CPU_EXT_VARS__)) {
					if (value != null)
						sbMakefile.append(value);
				}
			}

			{
				/***************************************************************
				 * FLAGS
				 **************************************************************/
				final String CFLAGS = "CFLAGS";
				final String ASFLAGS = "ASFLAGS";
				final String LDFLAGS = "LDFLAGS";
				final String LDDEPS = "LDDEPS";
				final String LIBS = "LIBS";

				HashMap<String, ArrayList<String>> commonParameters = parent
						.getRtosCommonAttributes(new String[] { CFLAGS,
								ASFLAGS, LDFLAGS, LDDEPS, LIBS});

				// FLAGS & VARIABLES
				sbMakefile.append(commentWriterMf.writerBanner("Flags")
					+ "CFLAGS  += " + ErikaEnterpriseWriter.arraysToString( (ArrayList<String>) commonParameters.get(CFLAGS), " ")+ "\n"
					+ "ASFLAGS += "	+ ErikaEnterpriseWriter.arraysToString(	(ArrayList<String>) commonParameters.get(ASFLAGS), " ")	+ "\n"
					+ "LDFLAGS += "	+ ErikaEnterpriseWriter.arraysToString(	(ArrayList<String>) commonParameters.get(LDFLAGS), " ")	+ "\n"
					+ "LDDEPS  += "	+ ErikaEnterpriseWriter.arraysToString(	(ArrayList<String>) commonParameters.get(LDDEPS), " ")	+ "\n"
	        		+ "LIBS    += " + ErikaEnterpriseWriter.arraysToString( (ArrayList<String>) commonParameters.get(LIBS), " ")+"\n");
			}

			{
				/*******************************************************************
				 * LIBS
				 ******************************************************************/
				String[] libs = getLibs();
				if (libs != null) {
					for (int i=0; i<libs.length; i++) {
						sbMakefile.append("\nLIB_OPT  += __LIB_" + libs[i].toUpperCase()+ "__");
					}
					sbMakefile.append("\n");
				}
			}
			
			
			/*******************************************************************
			 * SOURCES
			 ******************************************************************/
			sbMakefile.append(commentWriterMf.writerBanner("Sources"));

			LinkedHashSet<String> src_files = MakefileUtils.getSources(ool, vt);
			
			{ // ------------- write common sources -------------
			    
			    String cfgPath = "";
				if (parent.checkKeyword(IWritersKeywords.CPU_PIC_30)
						//|| parent.checkKeyword(IWritersKeywords.CPU_S12)
						) {
				    cfgPath = "$(OUTBASE)/";
				} else if (parent.checkKeyword(IWritersKeywords.CPU_MICO_32)
						//|| parent.checkKeyword(IWritersKeywords.CPU_S12)
						) {
				    cfgPath = "$(OUTPUT_DIR)/";
				}

			    
				sbMakefile.append("APP_SRCS += " + cfgPath
						+ answer[0].getFileName(FILE_EE_CFG_C));
	
				
				for (Iterator<String> iter = src_files.iterator(); iter.hasNext(); ) {
					sbMakefile.append(" " + iter.next());
				}
				sbMakefile.append("\n");
			}
			
			
			// cpu's sources (SPECIAL)
			if (parent.checkKeyword(IWritersKeywords.CPU_ARM7)) {
				
				StringBuffer tmpBuff = new StringBuffer();

				final List<String> currentCpuPrefixes = AbstractRtosWriter.getOsProperties(ool, SGRK_OS_CPU_DATA_PREFIX);
				for (String currentCpuPrefix: currentCpuPrefixes) {
					// THUMB SRC
					String[] tmp = CommonUtils.getValue(vt, currentCpuPrefix + S
							+ "THUMB_SRC");
					if (tmp != null) {
						for (int i = 0; i < tmp.length; i++) {
							tmpBuff.append(" " + tmp[i]);
						}
					}
				}
				if (tmpBuff.length() > 0) {
					sbMakefile.append("THUMB_SRCS =" + tmpBuff + "\n");
				}

			} else if (parent.checkKeyword(IWritersKeywords.CPU_JANUS)) {
				throw new UnsupportedOperationException("Write Make file unsupported for JANUS");
			} else if (parent.checkKeyword(IWritersKeywords.CPU_NIOSII)) {
				throw new UnsupportedOperationException("NIOS 2 don't use this make file");
			}

			{
				/***********************************************************************
				 * CONTRIBUTION  to makefile after file listing
				 ***********************************************************************/
				for (String value : AbstractRtosWriter.getOsProperties(ool,SGRK__MAKEFILE_AFTER_FILES__)) {
				    if (value != null) 
				    	sbMakefile.append(value);
				}
			}
			
			/*******************************************************************
			 * END
			 ******************************************************************/
			
			// last line
			if (enableRules) {				
				sbMakefile.append(commentWriterMf.writerBanner("end") +
				        "include $(EEBASE)/pkg/cfg/rules.mk\n");
			}
			
			{
				/***********************************************************************
				 * CONTRIBUTION  to the end of makefile
				 ***********************************************************************/
				for (String value : AbstractRtosWriter.getOsProperties(ool,SGRK__MAKEFILE_EXT_EOF__)) {
				    if (value != null) 
				    	sbMakefile.append(value);
				}
			}
			
		}

		return answer;
	}
	
	protected String[] getLibs() {

		final IOilObjectList[] oilObjects = parent.getOilObjects();

		ArrayList<String> answer = new ArrayList<String>();
		
//		String found = null;
	    for (IOilObjectList ool : oilObjects) {
			ArrayList<String> childPaths = new ArrayList<String>();
			List<String> childFound = parent.getRtosCommonChildType(ool, "LIB", childPaths);

			for (int index = 0; index<childFound.size(); index++) {
	    	
        		if ("ENABLE".equals(childFound.get(index))) {

    		        	// NAME
        			String[] names = CommonUtils.getValue(vt, childPaths.get(index) + PARAMETER_LIST+ "NAME");
		        	
		        	if (names!= null) {
		        		for (int j=0; j<names.length; j++)
		        			if (!answer.contains(names[j]))
		        				answer.add(names[j]);
		        	}
	        	}
	        }
			
	    }
	    
	    return (String[]) answer.toArray(new String[answer.size()]);

	}
}
