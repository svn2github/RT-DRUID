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

import com.eu.evidence.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.modules.oil.erikaenterprise.constants.IEEoptConstant;
import com.eu.evidence.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions;
import com.eu.evidence.rtdruid.desk.ReadVersion;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.RtdruidConfiguratorNumber;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
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
				SWCategoryManager.defaultInstance.newCategory(SWCategoryManager.TYPE_MAKEFILE, Integer.MAX_VALUE));
		
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

		final IOilObjectList[] oilObjects = parent.getOilObjects();		

		final int rtosNumber = oilObjects.length;
		IOilWriterBuffer[] answer = new IOilWriterBuffer[oilObjects.length];

		// for each rt-os, prepare a distrinct file
		for (int rtosId = 0; rtosId < rtosNumber; rtosId++) {

			answer[rtosId] = new OilWriterBuffer();
			// ---------------- required ----------------

			IOilObjectList ool = oilObjects[rtosId];
			final ISimpleGenRes sgrCpu = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
			StringBuffer sbMakefile = answer[rtosId].get(FILE_MAKEFILE);
			final ICommentWriter commentWriterMf = getCommentWriter(sgrCpu, FileTypes.MAKEFILE);

			final String currentCpuPrefix = sgrCpu.getString(SGRK_OS_CPU_DATA_PREFIX);

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
							+ "# EEBASE = ../../..\n"
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
			}
			
			
			/*******************************************************************
			 * EXTENTIONS
			 ******************************************************************/
			if (sgrCpu.containsProperty(SGRK__MAKEFILE_EXTENTIONS__)) {
			    String value = sgrCpu.getString(SGRK__MAKEFILE_EXTENTIONS__);
				sbMakefile.append(value);
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
						|| parent.checkKeyword(IWritersKeywords.CPU_MICO_32)
						//|| parent.checkKeyword(IWritersKeywords.CPU_S12)
						) {
				    cfgPath = "$(OUTBASE)/";
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

				// THUMB SRC
				String[] tmp = CommonUtils.getValue(vt, currentCpuPrefix + S
						+ "THUMB_SRC");
				if (tmp != null) {
					sbMakefile.append("THUMB_SRCS =");
					for (int i = 0; i < tmp.length; i++) {
						sbMakefile.append(" " + tmp[i]);
					}
					sbMakefile.append("\n");
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
				if (sgrCpu.containsProperty(SGRK__MAKEFILE_AFTER_FILES__)) {
				    String value = sgrCpu.getString(SGRK__MAKEFILE_AFTER_FILES__);
				    if (value != null) 
				    	sbMakefile.append(value);
				}
			}
			
			/*******************************************************************
			 * END
			 ******************************************************************/
			
			// last line
			sbMakefile.append(commentWriterMf.writerBanner("end") +
			        "include $(EEBASE)/pkg/cfg/rules.mk\n");
			
			{
				/***********************************************************************
				 * CONTRIBUTION  to the end of makefile
				 ***********************************************************************/
				if (sgrCpu.containsProperty(SGRK__MAKEFILE_EXT_EOF__)) {
				    String value = sgrCpu.getString(SGRK__MAKEFILE_EXT_EOF__);
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
	    for (int rtosId=0; rtosId<oilObjects.length; rtosId++) {

    		IOilObjectList ool = oilObjects[rtosId];
	    	final ISimpleGenRes sgrCpu = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);

	    	String currentRtosPrefix = parent.computeOilRtosPrefix(sgrCpu.getPath()); 


	    	ArrayList<String> child = new ArrayList<String>();
	        ArrayList<String> tmp = CommonUtils.getAllChildrenEnumType(vt, currentRtosPrefix + S + "LIB", child);
	        if (tmp != null) {
	        	for (int i=0; i<tmp.size(); i++) {
	        		if ("ENABLE".equals(tmp.get(i))) {
			        				        	
			        	// NAME
			        	String[] names = CommonUtils.getValue(vt, currentRtosPrefix + S + "LIB" + S + CommonUtils.VARIANT_ELIST 
			        			+ child.get(i) + PARAMETER_LIST+ "NAME");
			        	
			        	if (names!= null) {
			        		for (int j=0; j<names.length; j++)
			        			if (!answer.contains(names[j]))
			        				answer.add(names[j]);
			        	}
	        		}
	        	}
	        }
			
	    }
	    
	    return (String[]) answer.toArray(new String[answer.size()]);

	}
}
