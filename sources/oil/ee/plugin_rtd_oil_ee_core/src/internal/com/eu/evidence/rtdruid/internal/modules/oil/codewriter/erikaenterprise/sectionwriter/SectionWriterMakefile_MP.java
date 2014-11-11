/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterMakefile.java,v 1.5 2008/01/09 17:43:32 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.sectionwriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
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
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * This writer builds makefile for erika, using source or binary distributions.
 * 
 * Contains a standard makefile and some specific makefiles.
 * <br>
 * It's possible to contribute using specific keywords. See each method for more details.
 * 
 * @author Nicola Serreli
 */
public class SectionWriterMakefile_MP extends SectionWriter implements IEEWriterKeywords, IEEoptConstant {
	
	protected final static String ERIKA_INNER_MAKEFILE_DEFINE = "__ERIKA_INNER_MAKEFILE_CALL__";
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;

	/** All data */
	protected final IVarTree vt;
	
	/**
	 * 
	 */
	public SectionWriterMakefile_MP() {
		this(null);
	}
	
	/**
	 * 
	 */
	public SectionWriterMakefile_MP(ErikaEnterpriseWriter parent) {
		super("MAKEFILE", new String[] {}, //
				new String[] {},
				SWCategoryManager.defaultInstance.newCategory(SWCategoryManager.TYPE_MAKEFILE, SWCategoryManager.defaultPriority));
		
		this.parent = parent;
		this.vt = parent == null ? null : parent.getVt();
	}

	/**
	 * This method returns true if current instance of writer is enabled with
	 * specified keywords.
	 * 
	 * @return true if this writer is enabled
	 */
	protected boolean enabled() {
		return parent.getRtosSize() > 1 && Collections.binarySearch(keywords, IWritersKeywords.CPU_NIOSII) <0;

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

		return writeMakefile_MP();
	}
	
	/**
	 *  This method prepares data for <b>Nios2 makefiles</b>
	 * 
	 * @return buffers about Source and Binary Distribution
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeMakefile_MP() throws OilCodeWriterException {

		final IOilObjectList[] oilObjects = parent.getOilObjects();		

		IOilWriterBuffer[] answer = new IOilWriterBuffer[oilObjects.length];
	    for (int rtosId=0; rtosId<oilObjects.length; rtosId++) {	        
    		//  init variables
	        answer[rtosId] = new OilWriterBuffer();
	    }


        /*
         * makefile
         */
        writeMakefile(answer);
        
        /*
         * Common.mk
         */
        writeCommonMK(answer);
        
        /*
         * each cpu.mk && subdir.mk
         */
        writeCpuMKs(answer);
        	    
	    
	    return answer;
	}

	/**
	 * This method prepares the common.mk file. A file that contains every
	 * makefile parameter used during the compilation of each cpu's binary.
	 * 
	 * Another sectionWriter can contribute to this file using those extentions:
	 * {@link IEEWriterKeywords#SGRK__COMMON_MAKEFILE_MP_EXT_A_SUBD_INCLUDES__}, 
	 * {@link IEEWriterKeywords#SGRK__COMMON_MAKEFILE_MP_EXT_B_SUBD_INCLUDES__}, 
	 * {@link IEEWriterKeywords#SGRK__COMMON_MAKEFILE_MP_EXT_EOF__} and 
	 * {@link IEEWriterKeywords#SGRK__COMMON_MAKEFILE_MP_EXT_VARS__}
	 */
	protected void writeCommonMK(IOilWriterBuffer[] buffers) {
	    /*******************************************************************
	     * COMMON.MK
	     ******************************************************************/
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		IOilObjectList ool = oilObjects[RTOS_ID___COMMON_DATA];
		final ICommentWriter commentWriterMf = getCommentWriter(ool, FileTypes.MAKEFILE);
		
		final boolean enableRules = !(parent.getOptions().containsKey(IWritersKeywords.WRITER_DISABLE_EE_RULES) 
				&& "true".equalsIgnoreCase("" +parent.getOptions().get(IWritersKeywords.WRITER_DISABLE_EE_RULES)));

		StringBuffer sbCommon_mk = buffers[0].get(FILE_EE_COMMON_MK);

		{
			/***********************************************************************
			 * Common EE_BASE
			 **********************************************************************/
		
			final String eeBasePath = parent.getEE_location();
			OsType wrapper = HostOsUtils.common.getTarget();
			sbCommon_mk.append(
					commentWriterMf.writerBanner("Makefile created by RT-Druid\n\nCommon file") +"\n"+
					commentWriterMf.writerSingleLineComment("Erika base directory") +
					"ifneq ($("+ERIKA_INNER_MAKEFILE_DEFINE+"), yes)\n" +
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
					"ERIKA_FILES :=\n\n"+
					(enableRules ? "$(info Using erika files in $(EEBASE))\n" : "")+
					"endif " +commentWriterMf.writerSingleLineComment(ERIKA_INNER_MAKEFILE_DEFINE)+"\n"
	        );
			
			// ---------------- Configurator Number ----------------
			
			{
				String confNumber = RtdruidConfiguratorNumber.getRTDruidConfiguratorNumber();
				if (confNumber != null && confNumber.length()>0) {
					sbCommon_mk.append("\nRTDRUID_CONFIGURATOR_NUMBER:="+confNumber+"\n\n");
				}
			}

		}		
		
		
		{
			/***********************************************************************
			 * Common EE_OPT
			 **********************************************************************/
			sbCommon_mk.append(commentWriterMf
					.writerBanner("Common EE options") + "EEOPT += \n");
			String[] eeOpts = parent.extractEE_Opts(EE_OPT_ALL, -1);
			
			for (int eeId = 0; eeId < eeOpts.length; eeId++) {
				sbCommon_mk.append("EEOPT += " + eeOpts[eeId] + "\n");
			}
			if (SectionWriterCommonKernelDefs.includeEE_opt_application) {
				sbCommon_mk.append("EEOPT += " + FILE_EE_CFG_H_SECTION_EEOPT_DEFINES + "\n");
			}
			sbCommon_mk.append("\n");
		}

		{

			/***********************************************************************
			 * Get all Compiler Flags : CFLAGS ASFLAGS LDFLAGS LDDEPS LIBS
			 **********************************************************************/
			final String CFLAGS = "CFLAGS";
			final String ASFLAGS = "ASFLAGS";
			final String LDFLAGS = "LDFLAGS";
			final String LDDEPS = "LDDEPS";
			final String LIBS = "LIBS";

			HashMap<String, ArrayList<String>> commonParameters = parent
					.getRtosCommonAttributes(new String[] { CFLAGS, ASFLAGS,
							LDFLAGS, LDDEPS, LIBS, /* SYS_CONFIG, APP_CONFIG */
					});

			// FLAGS & VARIABLES
			sbCommon_mk.append(commentWriterMf.writerBanner("Flags")
					+ "CFLAGS   = " + ErikaEnterpriseWriter.arraysToString(commonParameters.get(CFLAGS), " ") + "\n\n"
					+ "ASFLAGS  = "	+ ErikaEnterpriseWriter.arraysToString(commonParameters.get(ASFLAGS)," ") + "\n\n"
					+ "LDFLAGS := " + ErikaEnterpriseWriter.arraysToString(commonParameters.get(LDFLAGS)," ") + "\n\n"
					+ "LDDEPS  += " + ErikaEnterpriseWriter.arraysToString(commonParameters.get(LDDEPS), " ") + "\n\n"
					+ "LIBS    := " + ErikaEnterpriseWriter.arraysToString(commonParameters.get(LIBS), " ") + "\n\n");
		}

		{
			/***********************************************************************
			 * CONTRIBUTION  to VARIABLES
			 ***********************************************************************/
			for (String value : AbstractRtosWriter.getOsProperties(ool,SGRK__COMMON_MAKEFILE_MP_EXT_VARS__)) {
			    if (value != null) 
			    	sbCommon_mk.append(value);
			}

		}

		{
			/***********************************************************************
			 * CONTRIBUTION  before SUBDIR include
			 ***********************************************************************/
			for (String value : AbstractRtosWriter.getOsProperties(ool,SGRK__COMMON_MAKEFILE_MP_EXT_B_SUBD_INCLUDES__)) {
			    if (value != null) 
			    	sbCommon_mk.append(value);
			}
		}

		{
			/***********************************************************************
			 * CONTRIBUTION  after SUBDIR include
			 ***********************************************************************/
			for (String value : AbstractRtosWriter.getOsProperties(ool,SGRK__COMMON_MAKEFILE_MP_EXT_A_SUBD_INCLUDES__)) {
			    if (value != null) 
			    	sbCommon_mk.append(value);
			}
		}

		{
			/***********************************************************************
			 * CONTRIBUTION  to the end of common.mk
			 ***********************************************************************/
			for (String value : AbstractRtosWriter.getOsProperties(ool,SGRK__COMMON_MAKEFILE_MP_EXT_EOF__)) {
			    if (value != null) 
			    	sbCommon_mk.append(value);
			}
		}
	        

	}
	
	
	/**
	 * This method prepares one cpu.mk and one subdir.mk file for each cput.
	 * 
	 * Another sectionWriter can contribute to this file using those extentions:
	 * {@link IEEWriterKeywords#SGRK__MAKEFILE_MP_CPU_EXT_VARS__} and 
	 * {@link IEEWriterKeywords#SGRK__MAKEFILE_MP_CPU_EOF__}
	 */
	protected void writeCpuMKs(IOilWriterBuffer[] buffers) {
		
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		
		/***********************************************************************
         * Compute files for all RT OS
         **********************************************************************/
	    for (int rtosId=0; rtosId<oilObjects.length; rtosId++) {
	        final IOilObjectList ool = oilObjects[rtosId];

            final String cpuName = ErikaEnterpriseWriter.getOSName(ool);
			final ICommentWriter commentWriterMf = getCommentWriter(ool, FileTypes.MAKEFILE);

	        
	        {
	            /***************************************************************
                 * CPU.MK
                 **************************************************************/
	            StringBuffer sbCpu_mk = buffers[rtosId].get(FILE_EE_CPU_MK);
	            buffers[rtosId].setFileName(FILE_EE_CPU_MK, "makefile");
	            
	            sbCpu_mk.append(commentWriterMf.writerBanner("Makefile created by RT-Druid\n\nCpu " + rtosId + "(" + cpuName + ")")+"\n");
	            
	            
	            {
	    			/***********************************************************************
	    			 * CONTRIBUTION  before COMMON.MK include
	    			 ***********************************************************************/
	            	for (String value : AbstractRtosWriter.getOsProperties(ool,SGRK__MAKEFILE_MP_CPU_EXT_B_COMMON_INCLUDE__)) {
	    			    if (value != null) 
	    			    	sbCpu_mk.append(value);
	    			}
	    		}

	            // COMMON MAKEFILE
   	            sbCpu_mk.append(commentWriterMf.writerSingleLineComment("Include common informations")
   	                    + "include ../" + buffers[rtosId].getFileName(FILE_EE_COMMON_MK) + "\n\n");
   	           
	            
	            // BASE dir
	            sbCpu_mk.append(commentWriterMf.writerSingleLineComment("Base dir") +
	            		"APPBASE ?= ../..\n");

	            { // ------------- write cpu sources -------------
		            sbCpu_mk.append(commentWriterMf.writerBanner("EE options")+
		            		"EEOPT += \n");
			        String[] eeOpts = parent.extractEE_Opts(EE_OPT_CPU_ONLY, rtosId);
			        for (int eeId =0; eeId<eeOpts.length; eeId++) {
			            sbCpu_mk.append("EEOPT += "+eeOpts[eeId]+"\n");
			        }
	            }

	            
	            { // ------------- write cpu sources -------------
		            sbCpu_mk.append(commentWriterMf.writerBanner("Sources"));
	
					LinkedHashSet<String> src_files = MakefileUtils.getSources(ool, vt);
					src_files.add(buffers[rtosId].getFileName(FILE_EE_CFG_C));
				
					sbCpu_mk.append("APP_SRCS += ");
		
					for (Iterator<String> iter = src_files.iterator(); iter.hasNext(); ) {
						sbCpu_mk.append(" " + iter.next());
					}
						
					sbCpu_mk.append("\n");
				}
				
				
	    		{
	    			/***********************************************************************
	    			 * CONTRIBUTION  to variables
	    			 ***********************************************************************/
	    			for (String value : AbstractRtosWriter.getOsProperties(ool, SGRK__MAKEFILE_CPU_EXT_VARS__)) {
	    			    if (value != null) 
	    			    	sbCpu_mk.append(value);
	    			}
	    		}
	            
	    		
	    		// COMMON MAKEFILE
				if (!(parent.getOptions().containsKey(IWritersKeywords.WRITER_DISABLE_EE_RULES) 
						&& "true".equalsIgnoreCase("" +parent.getOptions().get(IWritersKeywords.WRITER_DISABLE_EE_RULES)))) {
					
					sbCpu_mk.append(commentWriterMf.writerBanner("Default rules")
   	                    + "include $(EEBASE)/pkg/cfg/rules.mk\n\n");
				}
	    		 	                    
	    		{
					/***********************************************************************
					 * CONTRIBUTION to end of file
					 ***********************************************************************/
	    			for (String value : AbstractRtosWriter.getOsProperties(ool, SGRK__MAKEFILE_MP_CPU_EOF__)) {
						if (value != null)
							sbCpu_mk.append(value);
					}
				}
	        }
	        
	    }

	}
	
	
	/**
	 * This method prepares one cpu.mk and one subdir.mk file for each cput.
	 * 
	 * Another sectionWriter can contribute to this file using those extentions:
	 * {@link IEEWriterKeywords#SGRK__MAKEFILE_MP_EXT_VARS__} and 
	 * {@link IEEWriterKeywords#SGRK__MAKEFILE_MP_EXT_EOF__}
	 */
	protected void writeMakefile(IOilWriterBuffer[] buffers) {
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		final ICommentWriter commentWriter = getCommentWriter(oilObjects[RTOS_ID___COMMON_DATA], FileTypes.MAKEFILE);
		
        /*******************************************************************
         * MAKEFILE
         ******************************************************************/
        StringBuffer sbMakefile = buffers[0].get(FILE_MAKEFILE);

        sbMakefile.append(commentWriter.writerBanner("Makefile created by RT-Druid"));
        
        HashMap<String, Object> vtProperties = vt.getProperties();
        final String projectName = vtProperties.containsKey(IWritersKeywords.VTProperty_OilProjectName) ?
        		(String) vtProperties.get(IWritersKeywords.VTProperty_OilProjectName) : "myProject";
        		
        /*
         * Variables
         */
        		
        sbMakefile.append(commentWriter.writerSingleLineComment("Current Project")
                + "export PROJECT := " + projectName + "\n\n");

        /*
         * VARIABLES for Each CPU
         */

        StringBuffer sbSlavesList = new StringBuffer(commentWriter.writerBanner("Slave CPUs"));
    	        
        StringBuffer sbSlavesDirs = new StringBuffer(commentWriter.writerSingleLineComment("List of all the slave CPU dirs") +
        		"export CPU_DIRS := ");

        StringBuffer sbCpuList = new StringBuffer(commentWriter.writerSingleLineComment("List of all CPU") +
				"export CPU_LIST := CPU_MASTER ");
        
        // CPUs Directories
        int portNumber = 10000;
        for (int i=0; i<oilObjects.length; i++) {
	        final IOilObjectList ool = oilObjects[i];

            final String cpuName = ErikaEnterpriseWriter.getOSName(ool);
            
            if (i==0) {
            	sbMakefile.append(commentWriter.writerBanner("Master CPU") +
						"export CPU_MASTER_NAME := "+cpuName+"\n" +
						"export CPU_MASTER_PORT := "+portNumber+"\n" +
						"export CPU_MASTER_ID   := "+i+"\n" +
						"export CPU_MASTER_ELF  := $(PROJECT)_"+cpuName+".elf\n" +
						"export CPU_MASTER_DIR  := "+cpuName+"\n\n");
            } else {
                sbSlavesList.append(commentWriter.writerSingleLineComment("Slave cpu " + cpuName) +
						"export CPU"+i+"_NAME := "+cpuName+"\n" +
						"export CPU"+i+"_PORT := "+portNumber+"\n" +
						"export CPU"+i+"_ID   := "+i+"\n" +
						"export CPU"+i+"_ELF  := $(PROJECT)_"+cpuName+".elf\n" +
						"export CPU"+i+"_DIR  := "+cpuName+"\n\n");
            	sbSlavesDirs.append(" $(CPU"+i+"_DIR)");
	            sbCpuList.append(" CPU"+i);
            }
            
            
            portNumber ++;
        }
        
        if (oilObjects.length>1) {
	        sbMakefile.append(
	        		sbSlavesList.toString() + "\n" +
					sbSlavesDirs.toString() + "\n");
        }
        
        sbMakefile.append(
        		sbCpuList.toString() + "\n\n");

        {
			/***********************************************************************
			 * CONTRIBUTION  to variables
			 ***********************************************************************/
        	
        	for (String value : AbstractRtosWriter.getOsProperties(oilObjects[RTOS_ID___COMMON_DATA], SGRK__MAKEFILE_MP_EXT_VARS__)) {
			    if (value != null) 
			    	sbMakefile.append(value);
			}
		}        

        sbMakefile.append(
        		commentWriter.writerBanner("Include common and standard makefiles ...") +
        			"include common.mk\n\n"+
        			"export EEBASE\n" +
        			ERIKA_INNER_MAKEFILE_DEFINE+":=yes\n"+
        			"export " + ERIKA_INNER_MAKEFILE_DEFINE +"\n" +
        			"__BASE_MAKEFILE__ = yes\n" + 
        			"include $(EEBASE)/pkg/cfg/rules.mk\n\n");

        {
			/***********************************************************************
			 * CONTRIBUTION to end of file
			 ***********************************************************************/
        	for (String value : AbstractRtosWriter.getOsProperties(oilObjects[RTOS_ID___COMMON_DATA], SGRK__MAKEFILE_MP_EXT_EOF__)) {
				if (value != null)
					sbMakefile.append(value);
			}
		}
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
