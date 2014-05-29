/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterMakefile.java,v 1.5 2008/01/09 17:43:32 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.sectionwriter;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuUtility;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEoptConstant;
import com.eu.evidence.rtdruid.modules.oil.keywords.IOilXMLLabels;
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
public class SectionWriterMakefile_nios extends SectionWriter implements IEEWriterKeywords, IEEoptConstant {
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;

	/** All data */
	protected final IVarTree vt;
	
	/**
	 * 
	 */
	public SectionWriterMakefile_nios() {
		this(null);
	}
	
	/**
	 * 
	 */
	public SectionWriterMakefile_nios(ErikaEnterpriseWriter parent) {
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
		return Collections.binarySearch(keywords, IWritersKeywords.CPU_NIOSII) >=0;

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

		StringBuffer sbCommon_mk = buffers[0].get(FILE_EE_COMMON_MK);

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
			 * INCLUDE each subdir.mk file  
			 ***********************************************************************/

			// include sub_makefiles
			sbCommon_mk.append(
					commentWriterMf.writerBanner("Include the makefiles for each source subdirectory")
					+ "-include ${patsubst %, %/subdir.mk, $(SUBDIRS)}\n"
					+ "MAKEFILE_LIST += $(patsubst %, %/subdir.mk, $(SUBDIRS))\n\n");

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
	@SuppressWarnings("unchecked")
	protected void writeCpuMKs(IOilWriterBuffer[] buffers) {
	    final String PATH_SEPARATOR = "/";
		
		
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
	            
	            // APP_CONFIG
	            sbCpu_mk.append("# RT_D: Configuration for application project.\n"
	                    + "APP_CONFIG  := " + parent.default_output_prefix + PATH_SEPARATOR + cpuName+"\n\n");
	            
	            
	            // SUBDIRS
	            sbCpu_mk.append("# Autogenerated list of subdirectories which contain source files.\n"
	                    + "SUBDIRS     := \\\n. \\\n\n\n");
	            
	            // C_SRCS
	            sbCpu_mk.append("# RT_D: added automatically generated files...\n"
	                    + "C_SRCS      += \\\n${addprefix $(APP_CONFIG)/, \\\n"+buffers[rtosId].getFileName(FILE_EE_CFG_C)+" \\\n");
	            if (rtosId == 0 && oilObjects.length>1) {
	                sbCpu_mk.append(buffers[rtosId].getFileName(FILE_EE_COMMON_C)+" \\\n");
	            }
	            sbCpu_mk.append("}\n\n");

		        // EE_OPT
	            sbCpu_mk.append("# RT_D: EE options specifics for cpu "+cpuName+"\n" +
	            		"EEOPT += \n");
		        String[] eeOpts = parent.extractEE_Opts(EE_OPT_CPU_ONLY, rtosId);
		        for (int eeId =0; eeId<eeOpts.length; eeId++) {
		            sbCpu_mk.append("EEOPT += "+eeOpts[eeId]+"\n");
		        }
		        sbCpu_mk.append("\n");

	            // ELF
	            sbCpu_mk.append("# RT_D: \n"
	                    + "ELF         := ${PROJECT}_" + cpuName + ".elf\n\n");

	            // LINKER (Definitions)
	            sbCpu_mk.append("# RT_D: attenction: what if the user specifies a custom linker script????\n"
	                    + "LINKER_SCRIPT           = generated_" + cpuName + ".x\n\n");

	    		{
	    			/***********************************************************************
	    			 * CONTRIBUTION  to variables
	    			 ***********************************************************************/
	    			for (String value : AbstractRtosWriter.getOsProperties(ool,SGRK__MAKEFILE_CPU_EXT_VARS__)) {
	    			    if (value != null) 
	    			    	sbCpu_mk.append(value);
	    			}
	    		}
	            
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
   	            sbCpu_mk.append("# RT_D: Include common informations between processors\n"
   	                    + "include ../" + buffers[rtosId].getFileName(FILE_EE_COMMON_MK) + "\n\n");
   	            	                    
	    		{
					/***********************************************************************
					 * CONTRIBUTION to end of file
					 ***********************************************************************/
	    			for (String value : AbstractRtosWriter.getOsProperties(ool,SGRK__MAKEFILE_MP_CPU_EOF__)) {
						if (value != null)
							sbCpu_mk.append(value);
					}
				}
	        }

	        /*
	         * ########################################################################
	         */
	        
	        {
	            /***************************************************************
                 * SUBDIR.MK
                 **************************************************************/
	            StringBuffer sbCpu_mk = buffers[rtosId].get(FILE_EE_SUBDIR_MK);
	            
	            sbCpu_mk.append(commentWriterMf.writerBanner("RT_D: Auto-generated lists of source files at this location"));
	            

				/* Use an HashMap to write all files only one time */
	            LinkedHashSet<String> src_files = new LinkedHashSet<String>();

				final List<String> currentCpuPrefixes = AbstractRtosWriter.getOsProperties(ool, SGRK_OS_CPU_DATA_PREFIX);
				for (String currentCpuPrefix: currentCpuPrefixes) {
		
						/* Get all source files for current cpu */ 
						String[] tmp = CommonUtils.getValue(vt, currentCpuPrefix
						                              						+ S + "APP_SRC");
						if (tmp != null) {
		
							for (int i = 0; i < tmp.length; i++) {
								src_files.add(tmp[i]);
							}
						}
		            }
				/* Get all source files of all tasks mapped to current cpu */ 
				for (Iterator<ISimpleGenRes> iter = ool.getList(IOilObjectList.TASK).iterator(); iter.hasNext(); ) {
					ISimpleGenRes task = (ISimpleGenRes) iter.next();
					
					if (task.containsProperty(ISimpleGenResKeywords.TASK_SRC_FILE_LIST)) {
						Object o = task.getObject(ISimpleGenResKeywords.TASK_SRC_FILE_LIST);
						if (o instanceof String[]) {
							String[] files = (String[]) o;
							for (String s : files) {
								src_files.add(s);
							}
						} else if (o instanceof List) {
							List<String> files = (List) o;
							for (String s : files) {
								src_files.add(s);
							}
						} else if (o instanceof String) {
							src_files.add((String) o);
						}
					}
				}
				// get Resource's files
				for (Iterator<ISimpleGenRes> iter = ool.getList(IOilObjectList.RESOURCE).iterator(); iter.hasNext(); ) {
					ISimpleGenRes resource = (ISimpleGenRes) iter.next();
					
					if (resource.containsProperty(ISimpleGenResKeywords.RESOURCE_SRC)) {
						Object o = resource.getObject(ISimpleGenResKeywords.RESOURCE_SRC);
						if (o instanceof String[]) {
							String[] files = (String[]) o;
							for (String s : files) {
								src_files.add(s);
							}
						} else if (o instanceof List) {
							List<String> files = (List) o;
							for (String s : files) {
								src_files.add(s);
							}
						} else if (o instanceof String) {
							src_files.add((String) o);
						}
					}
				}

				// CPU
				{
					src_files.addAll(Arrays.asList(CpuUtility.getSources(ool)));
				}
				
				String[] tmp = (String[]) src_files.toArray(new String[src_files.size()]);
				
	            // C files
	            sbCpu_mk.append("C_SRCS += \\\n"
	                    + "${addprefix , \\\n");
   				if (tmp != null) {
  					for (int i = 0; i < tmp.length; i++) {
  					    if (tmp[i].endsWith(".c") || tmp[i].endsWith(".C")) {
  					        sbCpu_mk.append(tmp[i] + " \\\n");
  					    }
  					}
  				}
                sbCpu_mk.append("}\n\n");

	            // CXX files
	            sbCpu_mk.append("CXX_SRCS += \\\n"
	                    + "${addprefix , \\\n");
   				if (tmp != null) {
  					for (int i = 0; i < tmp.length; i++) {
  					    
  					    if (".cpp".equalsIgnoreCase(tmp[i].substring(Math.max(tmp[i].length()-4, 0))) ||
  					          ".cxx".equalsIgnoreCase(tmp[i].substring(Math.max(tmp[i].length()-4, 0))) ||
  					          ".cc".equalsIgnoreCase(tmp[i].substring(Math.max(tmp[i].length()-3, 0))) ){
  					        sbCpu_mk.append(tmp[i] + " \\\n");
  					    }
  					}
  				}
                sbCpu_mk.append("}\n\n");

	            // CXX files
	            sbCpu_mk.append("ASM_SRCS += \\\n"
	                    + "${addprefix , \\\n");
   				if (tmp != null) {
  					for (int i = 0; i < tmp.length; i++) {
  					    if (".as".equalsIgnoreCase(tmp[i].substring(Math.max(tmp[i].length()-3, 0))) || 
  					          ".s".equalsIgnoreCase(tmp[i].substring(Math.max(tmp[i].length()-2, 0)))) {
  					        sbCpu_mk.append(tmp[i] + " \\\n");
  					    }
  					}
  				}
                sbCpu_mk.append("}\n\n");
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
        		(String) vtProperties.get(IWritersKeywords.VTProperty_OilProjectName) : "";
        final String projectPath = vtProperties.containsKey(IWritersKeywords.VTProperty_OilProjectPath) ?
        		(String) vt.getProperties().get(IWritersKeywords.VTProperty_OilProjectPath) : "";
        		
        /*
         * Variables
         */
        		
        sbMakefile.append("# Current Project\n"
                + "export PROJECT := " + projectName + "\n"
                + "export APP_DIR := " + projectPath + "\n\n");

        /*
         * VARIABLES for Each CPU
         */

        StringBuffer sbSlavesList = new StringBuffer("# Other CPUs\n");
    	        
        StringBuffer sbSlavesDirs = new StringBuffer("# List of all the slave CPU dirs\n" +
        		"CPU_DIRS := ");

        StringBuffer sbCpuList = new StringBuffer("# List of all CPU \n" +
				"CPU_LIST := CPU_MASTER ");
        
        // CPUs Directories
        int portNumber = 10000;
        for (int i=0; i<oilObjects.length; i++) {
	        final IOilObjectList ool = oilObjects[i];
            final String cpuName = ErikaEnterpriseWriter.getOSName(ool);
            
            if (i==0) {
            	sbMakefile.append("# Master CPU\n" +
            			"CPU_MASTER_NAME := "+cpuName+"\n" +
						"CPU_MASTER_PORT := "+portNumber+"\n" +
						"CPU_MASTER_ID   := "+(i+1)+"\n" +
						"CPU_MASTER_ELF  := "+cpuName+"/$(PROJECT)_"+cpuName+".elf\n" +
            			"CPU_MASTER_DIR  := $(APP_DIR)/"+parent.default_output_prefix+"/"+cpuName+"\n\n");
            } else {
                sbSlavesList.append(
                		"CPU"+i+"_NAME := "+cpuName+"\n" +
						"CPU"+i+"_PORT := "+portNumber+"\n" +
						"CPU"+i+"_ID   := "+(i+1)+"\n" +
            			"CPU"+i+"_ELF  := "+cpuName+"/$(PROJECT)_"+cpuName+".elf\n" +
                		"CPU"+i+"_DIR  := $(APP_DIR)/"+parent.default_output_prefix+"/"+cpuName+"\n\n");
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
		final String oilHwRtosPrefix = parent.getOilHwRtosPrefix(); 

		ArrayList<String> answer = new ArrayList<String>();
		
//		String found = null;
	    for (int rtosId=0; rtosId<oilObjects.length; rtosId++) {

    		IOilObjectList ool = oilObjects[rtosId];
    		
			ArrayList<String> childPaths = new ArrayList<String>();
			List<String> childFound = parent.getRtosCommonChildType(ool, "LIB", childPaths);

			for (int index = 0; index<childFound.size(); index++) {
	    	
        		if ("ENABLE".equals(childFound.get(index))) {

        			String[] names = CommonUtils.getValue(vt, childPaths + PARAMETER_LIST+ "NAME");
	        	
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
