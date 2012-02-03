package com.eu.evidence.rtdruid.internal.modules.oil.cortex;
/*
 * Created on 21/09/2011
 *
 * $Id$
 */


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IOilXMLLabels;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.HostOsUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStacks;
import com.eu.evidence.rtdruid.modules.oil.cortex.constants.CortexConstants;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.location.EEPaths;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

/**
 * This writer build files for a CORTEX M0 CPU - Board
 * 
 * @author Nicola Serreli
 */
public class SectionWriterHalCortexM0 extends SectionWriter 
	implements IEEWriterKeywords,
			IExtractObjectsExtentions,
			IExtractKeywordsExtentions {

	/** Cortex M0 ee_opts */
	public final static String EEOPT__CORTEX_M0__ = "__CORTEX_M0__";
	public final static String EEOPT__IAR_COMPILER__ = "__IAR__";
	public final static String EEOPT__CORTEX_M0_JLINK__ = "__C_M0_IAR_J_LINK__";
	

	final protected String CUSTOM_MCU = "CUSTOM";
	final protected static HashMap<String, Mcu_Model> STANDARD_MCU_PROPERTIES = new HashMap<String, Mcu_Model>();
	private static final String CORTEX_MCU = "CORTEX_M0";
	
	static {
		loadMCU_properties();
	}
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;
	
	/** All data */
	protected final IVarTree vt;
	
	/**
	 * 
	 */
	public SectionWriterHalCortexM0() {
		this(null);
	}
	
	/**
	 * 
	 */
	public SectionWriterHalCortexM0(ErikaEnterpriseWriter parent) {
		super(IWritersKeywords.CPU_CORTEX_M0,
				new String[] {}, //
				new String[] { //
					IWritersKeywords.CPU_NIOSII,//
					IWritersKeywords.CPU_JANUS,//
					IWritersKeywords.CPU_MPC5xx,//
					IWritersKeywords.CPU_NIOSII, //
					IWritersKeywords.CPU_AVR5 },
					SWCategoryManager.defaultInstance.newCategory(SWCategoryManager.TYPE_CPU));
		
		this.parent = parent;
		this.vt = parent == null ? null : parent.getVt();
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

		return writeEE_CORTEX_M0_CPU();
	}
	
	/**
	 * This method add new keywords enabled by this writer.
	 */
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix) {
	}

	/**
	 * This method makes some changes to computed Oil Object
	 */
	public void updateObjects() {

		final IOilObjectList[] oilObjects = parent.getOilObjects();		

        ArrayList<String> commonEEopt = new ArrayList<String>();
		
		// mcu
		checkMcu(commonEEopt);
		
		for ( int currentRtosId = 0; currentRtosId <oilObjects.length; currentRtosId ++) {
			final IOilObjectList ool = oilObjects[currentRtosId];
			final ISimpleGenRes sgrCpu = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
			final String currentCpuPrefix = sgrCpu.getString(SGRK_OS_CPU_DATA_PREFIX);
	
			/***********************************************************************
			 * 
			 * EE OPTS
			 *  
			 **********************************************************************/
			{
				//List requiredOilObjects = (List) sgrCpu.getObject(SGRK__FORCE_ARRAYS_LIST__);
	
		        // ICD 2
		        ArrayList<String> tmp = new ArrayList<String>(commonEEopt);
		        
		        // store all older values (if there are)
		        if (sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_EE_OPTS)) {
		        	String[] old = (String[]) sgrCpu.getObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS);
		        	tmp.addAll(Arrays.asList(old));
		        }
		
		        tmp.add(EEOPT__CORTEX_M0__);
		        
		        {
					String tmp1 = CommonUtils
							.getFirstChildEnumType(vt, currentCpuPrefix
									+ "JLINK", null);
					if ("TRUE".equalsIgnoreCase(tmp1)) {
			            sgrCpu.setProperty(CortexConstants.SGRK__CORTEX_JLINK__, "true");
			            tmp.add(EEOPT__CORTEX_M0_JLINK__);
			        }
				}
	
				{
					String tmp1 = CommonUtils
						.getFirstChildEnumType(vt, currentCpuPrefix
									+ "COMPILER_TYPE", null);
					if (tmp1 == null) {
						tmp1 = CortexConstants.SGRK__IAR_COMPILER__;
					}
						
					sgrCpu.setProperty(CortexConstants.SGRK__CORTEX_COMPILER_TYPE__, tmp1);
					if (CortexConstants.SGRK__IAR_COMPILER__.equalsIgnoreCase(tmp1)) {
			            tmp.add(EEOPT__IAR_COMPILER__);
				    }
				}
	
				sgrCpu.setObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS, tmp.toArray(new String[tmp.size()]));
			}
			
		}

	}
	
	/**
	 * Write configuration's files for CORTEX M0
	 * 
	 * @return buffers with configuration for CORTEX M0
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeEE_CORTEX_M0_CPU()
			throws OilCodeWriterException {

		final String ERR_CPU_TYPE = "CORTEX M0";
		final IOilObjectList[] oilObjects = parent.getOilObjects();		
		
		IOilWriterBuffer[] allBuffers = new IOilWriterBuffer[oilObjects.length];
		final String indent = IWritersKeywords.INDENT;

		// ------------- Common string --------------------
		final boolean binaryDistr = parent.checkKeyword(IEEWriterKeywords.DEF__EE_USE_BINARY_DISTRIBUTION__);

		/*
		 * Define a string for each MAX_OBJECT_NUMBER (OBJECT=task, RESOURCE, ...).
		 * Binary distribution uses the suffix RTD_. 
		 */
		final String MAX_TASK = (binaryDistr ? "RTD_" : "EE_") + "MAX_TASK";

		for ( int currentRtosId = 0; currentRtosId <oilObjects.length; currentRtosId ++) {
			IOilWriterBuffer answer = new OilWriterBuffer();
			allBuffers[currentRtosId] = answer;
	
			String pre = "";
			String post = "";
	
			
			// ------------- Requirement --------------------
			StringBuffer sbInithal_c = answer.get(FILE_EE_CFG_C);
			
			final IOilObjectList ool = oilObjects[currentRtosId];
			final ISimpleGenRes sgrCpu = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
			final String currentCpuPrefix = sgrCpu.getString(SGRK_OS_CPU_DATA_PREFIX);
			final ICommentWriter commentWriterC = getCommentWriter(sgrCpu, FileTypes.C);
			final ICommentWriter commentWriterMf = getCommentWriter(sgrCpu, FileTypes.MAKEFILE);

			List<ISimpleGenRes> taskNames = ool.getList(IOilObjectList.TASK);
			String stackType = parent.getStackType(); // MULTI or MONO
	
			// ------------- Buffers --------------------
			/* A buffer about stack  */
			StringBuffer sbStack = new StringBuffer();
	
			/* A buffer about declarations of stacks  */
			StringBuffer sbStackDecl = new StringBuffer();
			StringBuffer sbStackDeclSize = new StringBuffer();
	
			// ------------- Compute --------------------
	
			sbInithal_c.append("\n#include \"ee.h\"\n");
	
	//		/***********************************************************************
	//         * 
	//         * EE OPTS
	//         *  
	//         **********************************************************************/
	
		    final int STACK_UNIT;
			if (sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR)) {
				CpuHwDescription currentStackDescription = (CpuHwDescription) sgrCpu.getObject(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR);
				STACK_UNIT = currentStackDescription.stackSize;
			} else {
				STACK_UNIT = 4;
			}
			
			/***********************************************************************
			 * MULTI STACK
			 **********************************************************************/
			if (DEF__MULTI_STACK__.equals(stackType)) {
				sbInithal_c.append(commentWriterC
						.writerBanner("Stack definition for CORTEX M0"));
				
				ITreeInterface ti = vt.newTreeInterface();
	
	
				
				int[] irqSize = null;
				if (parent.checkKeyword(DEF__IRQ_STACK_NEEDED__)) {
					/***************************************************************
					 * IRQ_STACK
					 **************************************************************/
					
					String[] child = new String[1];
					String type = CommonUtils
							.getFirstChildEnumType(vt, currentCpuPrefix
									+ "MULTI_STACK", child);
	
					if ("TRUE".equalsIgnoreCase(type)) {
						String prefixIRQ = currentCpuPrefix
							+ "MULTI_STACK" + VARIANT_ELIST+child[0] + PARAMETER_LIST
							+ "IRQ_STACK";
						boolean ok = "TRUE".equalsIgnoreCase(CommonUtils
						.getFirstChildEnumType(vt, prefixIRQ, child));
						
						if (ok) {
							
							prefixIRQ += VARIANT_ELIST + child[0] +PARAMETER_LIST;
							irqSize = new int[1];
							{ // get data for IRQ STACK ...
								String path[] = { "SYS_SIZE" };
	
								for (int i = 0; i < path.length; i++) {
									String tmp = null;
									IVariable var = ti.getValue(prefixIRQ + path[i]
											+ VALUE_VALUE);
									if (var != null && var.get() != null) {
										tmp = var.toString();
									}
									if (tmp == null)
										throw new RuntimeException(
												ERR_CPU_TYPE + " : Expected " + path[i]);
	
									// check for value
									try {
										// ... store them inside the irqSize vector
										irqSize[0] = (Integer.decode("" + tmp))
												.intValue();
										// ... and increase the memory requirement
	//									stackEnd += irqSize[0];
									} catch (Exception e) {
										throw new RuntimeException(
												ERR_CPU_TYPE + " : Wrong int" + path[i]
														+ ", value = " + tmp + ")");
									}
								}
							}
						}
					}
	
				}
	
				/*
				 * elStack contains all data about stack, for current rtos and its
				 * tasks.
				 * 
				 * tList and tListN are used to identify all tasks (theirs name and
				 * system id).
				 * 
				 * elStack accepts the list of task's names (tList) to compute all
				 * required stack and theirs size/position
				 */
				EEStacks elStack = new EEStacks(parent, ool, irqSize);
				elStack.setDummyStackPolicy(elStack.FORCE_ALWAYS | elStack.FORCE_FIRST);
				ArrayList<String> tList = new ArrayList<String>();
				ArrayList<String> tListN = new ArrayList<String>();
	
				{
					/***************************************************************
					 * STACK FOR EACH TASK
					 **************************************************************/
					
					// add the dummy task
					tListN.add(" ");
					tList.add(IWritersKeywords.dummyName);
					
					// fill data for each task
					for (Iterator<ISimpleGenRes> iter = taskNames.iterator(); iter.hasNext();) {
	
						ISimpleGenRes sgr = (ISimpleGenRes) iter.next();
						tList.add(sgr.getName());
						tListN.add(sgr.getString(ISimpleGenResKeywords.TASK_SYS_ID));
					}
	
					// compute total stack size and add it to memory requirement
	//				int offset[][] = elStack.taskOffsets((String[]) tList
	//						.toArray(new String[0]));
	//				stackEnd += offset[offset.length - 1][0]; // tot sys
				}
	
				
				{
					/***************************************************************
					 * PREPARE BUFFERS
					 **************************************************************/
	
					pre = "";
					post = "";
	
					/* get the link between a task and its stack. */
					int pos[] = elStack.taskStackLink(tList
							.toArray(new String[1]));
					/* get the size of each stack. */
					int size[][] = elStack.stackSize(tList
							.toArray(new String[1]));
					/* descrStack contains a description for each stack. */ 
					String[] descrStack = new String[size.length];
					sbStack.append(indent
							+ "const EE_UREG EE_std_thread_tos["+MAX_TASK+"+1] = {\n");
	
					
					
						
					// DESCRIPTIONS
					for (int j = 0; j < pos.length; j++) {
						sbStack.append(pre + post + indent + indent + +pos[j]+"U");
						// set new values for "post" and "pre"
						post = " /* " + tList.get(j) + "*/\n";
						pre = ",\t";
	
						/*
						 * add the name of current task to the description of the /
						 * right stack. Check also if there is already something or
						 * not, infact in the second case append the new description
						 * to the old one
						 */ 
						descrStack[pos[j]] = (descrStack[pos[j]] == null) ?
								// The first description
								("Task " + tListN.get(j) + " (" + tList.get(j) + ")")
								:
								// other descriptions
								(descrStack[pos[j]] + ", " + "Task "
										+ tListN.get(j) + " (" + tList.get(j) + ")"); // others
					}
	
					// close sbStack
					sbStack.append(" \t" + post + indent + "};\n\n" + indent
							+ "struct EE_TOS EE_cortex_m0_system_tos["
							+ (size.length) + "] = {\n");
	
					pre = "";
					post = "";
					
	//				 DECLARE STACK SIZE && STACK (ARRAY)
					for (int j = 1; j < size.length; j++) {
					    long value = size[j][0];
					    value  = (value + (value%STACK_UNIT)) / STACK_UNIT; // arrottondo a 2
						sbStackDecl.append(indent + "int EE_cortex_m0_stack_"+j+"[STACK_"+j+"_SIZE];\t/* "+descrStack[j]+" */\n");
						sbStackDeclSize.append(indent + "#define STACK_"+j+"_SIZE "+value+" // size = "+size[j][0]+" bytes \n");
					}
					
					/*
					 * For each stack prepare the configuration's vectors and
					 * descriptions
					 */
					for (int j = 0; j < size.length; j++) {
					    
				        String value = j == 0 ? "{0}" : "{(EE_ADDR)(&EE_cortex_m0_stack_"+j+"[STACK_"+j+"_SIZE - CORTEX_M0_INIT_TOS_OFFSET])}";
	
						sbStack.append(pre
								+ post
								+ indent
								+ indent
								+ value);
	
						// set new values for size
						pre = ",";
						post = "\t/* "+descrStack[j]+" */\n";
					}
	
					// complete the stack's buffer
					sbStack.append(" " + post + indent + "};\n\n" + indent
							+ "EE_UREG EE_cortex_m0_active_tos = 0U; /* dummy */\n\n");
	
					{ // if required, init also the irq stack
						if (irqSize != null) {
						    int j = size.length;
						    long value = irqSize[0];
						    value  = (value + (value%STACK_UNIT)) / STACK_UNIT; // arrottondo a 2
							sbStackDecl.append(indent + "int EE_cortex_m0_stack_"+j+"[STACK_"+j+"_SIZE];\t/* irq stack */\n");
							sbStackDeclSize.append(indent + "#define STACK_"+j+"_SIZE "+value+" // size = "+irqSize[0]+" bytes \n");
	
							sbStack
									.append(indent+"/* stack used only by IRQ handlers */\n"
											+ indent+"struct EE_TOS EE_cortex_m0_IRQ_tos = {\n"
											+ indent+indent+"(EE_ADDR)(&EE_cortex_m0_stack_"+j+"[STACK_"+j+"_SIZE])\n"
											+ indent+"};\n\n");
						}
					}
				}
				
	
			}
	
			// ------------- Write --------------------
			//  add stack buffers
			sbInithal_c.append(sbStackDeclSize+"\n"+
			        sbStackDecl + "\n" +
			        sbStack);
	
			
			{
			/***********************************************************************
	         * 
	         * MAKE FILE
	         *  
	         **********************************************************************/
				HostOsUtils wrapper = HostOsUtils.common;
	
			    StringBuffer sbMakefile = new StringBuffer(commentWriterMf.writerBanner("CORTEX M0"));
			    
			    {	// PATHs
					final String eeBasePath = EEPaths.getEe_base();
					final boolean cygwin = HostOsUtils.common.getCurrentSystem() == HostOsUtils.CYGWIN;
			    	
		        	HashMap<String, ?> options = parent.getOptions();
	
			        String outputDir = "Debug";
			        String appBase = "..";
			        // Get Default values 
			        String gcc = CortexConstants.DEFAULT_CORTEXM0_CONF_CC;
			        
			    	if (options.containsKey(IWritersKeywords.WRITER_OUTPUT_DIR_SET)) {
						outputDir = (String) options.get(IWritersKeywords.WRITER_LAST_OUTPUT_DIR);
						outputDir = (String) options.get(IWritersKeywords.WRITER_FS_PATH_OUTPUT_DIR);
						
						appBase = (String) options.get(IWritersKeywords.WRITER_WS_OUTPUT_projectbase_DIR);//"..";
						if (options.containsKey(IWritersKeywords.WRITER_WS_PATH_OUTPUT_DIR)) {
							outputDir = (String) options.get(IWritersKeywords.WRITER_WS_PATH_OUTPUT_DIR);
						}
					}
			    	IPath p = new Path(outputDir);
			    	if (p.isAbsolute()) {
			    		outputDir = wrapper.wrapPath(outputDir);
			    	}
			    	
			    	
			    	if (options.containsKey(CortexConstants.PREF_CORTEXM0_CC_PATH)) {
						String tmp = (String) options.get(CortexConstants.PREF_CORTEXM0_CC_PATH);
						if (tmp.length()>0) gcc = tmp;
					}
			    	
			        sbMakefile.append(
			        		"ifndef EEBASE\n" +
			        		IWritersKeywords.INDENT + "EEBASE  := "+wrapper.wrapPath(eeBasePath)+"\n" +
			                "endif\n" +
			                "APPBASE := " + appBase + "\n" +
			                "OUTBASE := " + outputDir + "\n\n");
			        
			        String compiler_type = sgrCpu.containsProperty(CortexConstants.SGRK__CORTEX_COMPILER_TYPE__) ?
			        		sgrCpu.getString(CortexConstants.SGRK__CORTEX_COMPILER_TYPE__) : null;
			        if (CortexConstants.SGRK__IAR_COMPILER__.equalsIgnoreCase(compiler_type)) {
				        sbMakefile.append(
				        	"ifndef IAR_CCDIR\n" +
				        	IWritersKeywords.INDENT + "IAR_CCDIR := " + wrapper.wrapPath(gcc) + "\n" +
			                "endif\n\n");
			        }
			    }
	
	            sgrCpu.setProperty(SGRK__MAKEFILE_EXTENTIONS__, sbMakefile.toString());
	
			}
		
		}

		// MCU
		mcuWrite(allBuffers);

		return allBuffers;
	}

	
	/*
	 * Parse and write the MCU Section
	 */
	private void mcuWrite(IOilWriterBuffer[] buffers) {
		final String CUSTOM_MCU = "CUSTOM";

		final IOilObjectList[] oilObjects = parent.getOilObjects();
		String mcu_model = null;	// != null only if found a valid mcu
		Mcu_Model mcu_properties = null;
		for (int currentRtosId = 0; mcu_model == null && currentRtosId < oilObjects.length; currentRtosId ++) { 
			
			/* COMMON VARIABLES */
			ISimpleGenRes os = (ISimpleGenRes) oilObjects[currentRtosId].getList(IOilObjectList.OS).get(0);

			{
				/***********************************************************************
				 * get values
				 **********************************************************************/
	
				// prepare the path :
				// ... the prefix ...
				String currentMcuPrefix = os.getPath() + S
						+ DataPackage.eINSTANCE.getRtos_OilVar().getName() + S
						+ IOilXMLLabels.OBJ_OS + parent.getOilHwRtosPrefix() + "MCU_DATA";
				
				// ... get the node identifier
				String[] child = new String[1];
				String mcu_type = CommonUtils.getFirstChildEnumType(vt, currentMcuPrefix, child);
				
				if (child.length >0 && CORTEX_MCU.equals(mcu_type)) {
					// ... and compete it 
					currentMcuPrefix += VARIANT_ELIST + child[0] + PARAMETER_LIST + "MODEL";
	
					String model_type = CommonUtils.getFirstChildEnumType(vt, currentMcuPrefix, child);
					
					/* CUSTOM */
					if (CUSTOM_MCU.equals(model_type)) {
						// read also LINKERSCRIPT, DEV_LIB, INCLUDE_C, INCLUDE_S
						currentMcuPrefix += VARIANT_ELIST + child[0] + PARAMETER_LIST;
						String[] model = CommonUtils.getValue(vt, currentMcuPrefix+"MODEL");
						String[] linker = CommonUtils.getValue(vt, currentMcuPrefix+"LINKERSCRIPT");
						String[] inc_h  = CommonUtils.getValue(vt, currentMcuPrefix+"INCLUDE_H");
						
						mcu_properties = new Mcu_Model(
								CUSTOM_MCU,
								clean(model),
								"__"+clean(model)+"__",
								clean(linker),
								clean(inc_h)
						);
						mcu_model = CUSTOM_MCU;
					} else {
							/* STANDARD MCU */
						mcu_properties = STANDARD_MCU_PROPERTIES.get(model_type);
						if (mcu_properties != null) {
							mcu_model = model_type;
						}
					}
				}
			}
		}

		if (mcu_model != null) {
			/***********************************************************************
			 * prepare buffers
			 **********************************************************************/
			
			// The answer (StringBuffer)
			StringBuffer answerBuffer = new StringBuffer();
	
			// complete the table
				answerBuffer.append("CORTEX_M0_MODEL           := " +mcu_properties.model + "\n"); 
			if (mcu_properties.linkerScript != null)
				answerBuffer.append("CORTEX_M0_LINKERSCRIPT    := " +mcu_properties.linkerScript + "\n"); 
			if (mcu_properties.include_h != null)
				answerBuffer.append("CORTEX_M0_INCLUDE_H       := " +mcu_properties.include_h + "\n");

			for (int currentRtosId = 0; currentRtosId < oilObjects.length; currentRtosId ++) { 
				ISimpleGenRes os = (ISimpleGenRes) oilObjects[currentRtosId].getList(IOilObjectList.OS).get(0);
				final ICommentWriter commentWriterMf = getCommentWriter(os, FileTypes.MAKEFILE);

				
				String temp = os.getString(SGRK__MAKEFILE_EXTENTIONS__);
	            os.setProperty(SGRK__MAKEFILE_EXTENTIONS__, temp +
	            		commentWriterMf.writerBanner("Init MCU for CORTEX M0 ("+mcu_model+")") +
	            		answerBuffer.toString());
			}

		}
	}
	

	/*
	 * Parse and write the MCU Section
	 */
	private void checkMcu(ArrayList<String> ee_opts) {

		final IOilObjectList[] oilObjects = parent.getOilObjects();
		Mcu_Model mcu_properties = null;
		for (int currentRtosId = 0; mcu_properties == null && currentRtosId < oilObjects.length; currentRtosId ++) { 
			
			/* COMMON VARIABLES */
			ISimpleGenRes os = (ISimpleGenRes) oilObjects[currentRtosId].getList(IOilObjectList.OS).get(0);
			//String mcu_model = null;	// != null only if found a valid mcu
	
			{
				/***********************************************************************
				 * get values
				 **********************************************************************/
	
				// prepare the path :
				// ... the prefix ...
				String currentMcuPrefix = os.getPath() + S
						+ DataPackage.eINSTANCE.getRtos_OilVar().getName() + S
						+ IOilXMLLabels.OBJ_OS + parent.getOilHwRtosPrefix() + "MCU_DATA";
				
				// ... get the node identifier
				String[] child = new String[1];
				String mcu_type = CommonUtils.getFirstChildEnumType(vt, currentMcuPrefix, child);
				
				if (child.length >0 && CORTEX_MCU.equals(mcu_type)) {
					// ... and compete it 
					currentMcuPrefix += VARIANT_ELIST + child[0] + PARAMETER_LIST + "MODEL";
	
					String model_type = CommonUtils.getFirstChildEnumType(vt, currentMcuPrefix, child);
					
					/* CUSTOM */
					if (CUSTOM_MCU.equals(model_type)) {
						
						// read only MODEL
						currentMcuPrefix += VARIANT_ELIST + child[0] + PARAMETER_LIST;
						String model = clean(CommonUtils.getValue(vt, currentMcuPrefix+"MODEL"));
						if (model != null) {
							if (!ee_opts.contains("__"+model+"__")) {
								ee_opts.add("__"+model+"__");
							}
							
							String linkscript = clean(CommonUtils.getValue(vt, currentMcuPrefix+"LINKERSCRIPT"));
							if (linkscript != null && !ee_opts.contains("__USE_CUSTOM_LINKER_SCRIPT__")) {
								ee_opts.add("__USE_CUSTOM_LINKER_SCRIPT__");
							}
						}
	
					} else {
							/* STANDARD MCU */
						mcu_properties = STANDARD_MCU_PROPERTIES.get(model_type);
						if (mcu_properties != null) {
							
							String[] splitted = mcu_properties.ee_opt == null ? new String[0] : mcu_properties.ee_opt.split(" ");
							for (String t : splitted) {
								if (!ee_opts.contains(t)) {
									ee_opts.add(t);
								}
							}
						}
					}
				}
				
				
			}
		}
	}
	/**
	 * This metod takes an array and returns the first element, or null if the
	 * array is a zero-length array or if the first element is empty ("" or
	 * null)
	 */
	protected String clean(String[] arr) {
		String answer = null;
		if (arr != null && arr.length>0) {
			if (arr[0].trim().length()>0) {
				answer= arr[0].trim();
			}
		}
		return answer;
	}

	
	/**
	 * Loads every know mcu
	 */
	protected static void loadMCU_properties() {
		final String MCU_filename = com.eu.evidence.rtdruid.modules.oil.cortex.Activator.TEMPLATES_PATH + "/cortex_m0_id.csv";
		
		class PropertyMaker {
			final char COMMENT = '#';
			final char SEPARATOR_CHAR = '\t';
			final String SEPARATOR = "[\t ]";
			
			@SuppressWarnings("unused")
			public void addARow(byte[] row, int start, int end) {
				
				// add a NOT EMPTY row
				if (row.length==0 || row[0]==COMMENT) return; 

				ArrayList<String> values = new ArrayList<String>();
						
// Header of the cortex_m0_id file			
//OIL/MOEL		File H		File GLD(linker)
				
				int prev=start;
				for (int i=prev; i<end; i++) {
					
					if (row[i]==SEPARATOR_CHAR) {
						// next word
						
						if (i!=prev) {
							String txt = new String(row, prev, i-prev);
							values.add(txt);
						}
						prev = i+1; // the next word starts from i+1
					}
				}
				// the last word
				if (prev!=row.length-1) {
					String txt = new String(row, prev, row.length - prev -1);
					values.add(txt);
				}
				
				// not valid !!!
				if (values.size()!=5) {
					RtdruidLog.showDebug(new RuntimeException("Illegal row inside cortex_m0_id\n" + (new String(row))));
					return;
				}
				
				String name   = values.get(0);
				String model  = name.startsWith("CORTEX") ?	name.substring(5) : name;
				String ee_opt = "__" + model + "__ __"+ name +"__";
				String inc_h  = values.get(1);
				String linker = values.get(2);
				
				Mcu_Model mcu = new Mcu_Model(
						name, // name
						model, // model
						ee_opt, // ee_opt
						linker, // linker
						inc_h // include_s
				);
				
				STANDARD_MCU_PROPERTIES.put(name, mcu);
			}
			public void addARow(String row) {
				
				// add a NOT EMPTY row
				if (row.length()==0 || row.charAt(0)==COMMENT) return; 

				String[] values = row.split(SEPARATOR); 
				
				// not valid !!!
				if (values.length!=5) {
					RtdruidLog.showDebug(new RuntimeException("Illegal row inside cortex_m0_id\n" + (new String(row))));
					return;
				}
				
				String name   = (String) values[0];
				String model  = name.startsWith("CORTEX") ?	name.substring(5) : name;
				String ee_opt = "__" + model + "__ __"+ name +"__";
				String inc_h  = (String) values[1];
				String linker = (String) values[2];
				
				Mcu_Model mcu = new Mcu_Model(
						name, // name
						model, // model
						ee_opt, // ee_opt
						linker, // linker
						inc_h // include_h
				);
				
				STANDARD_MCU_PROPERTIES.put(name, mcu);
			}
		};
		
		PropertyMaker pmaker = new PropertyMaker();
		String tmp="";		
		try {
			InputStream input = SectionWriterHalCortexM0.class.getResourceAsStream(MCU_filename);
			if (input != null) {
				
				ByteArrayOutputStream output = new ByteArrayOutputStream();
				
				byte[] data = new byte[1024];
				try {
					for (int length = input.read(data); length != -1; length = input.read(data)) {
						output.write(data, 0, length);
					}
				} catch (IOException e) {
					// ???
					e.printStackTrace();
				}
				tmp = output.toString();
			}
		} catch (Exception e) {
			RtdruidLog.log(e);
		} catch (Error e) {
			RtdruidLog.log(e);
		}

		String[] rows = tmp.split("\n");

		for (int i=0; i<rows.length; i++) {
			String t = rows[i]; 
			if (t.endsWith("\r")) {
				t = t.substring(0, t.length()-1);
			}
			pmaker.addARow(t);
		}
	}
}
