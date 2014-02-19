/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterHalArm7.java,v 1.8 2008/01/24 15:50:57 durin Exp $
 */
package com.eu.evidence.rtdruid.hidden.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.eu.evidence.modules.oil.arm7.constants.Arm7Constants;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.HostOsUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OsType;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStackData;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStacks;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;

/**
 * This writer build files for configure the Hal of an Arm7
 * 
 * @author Nicola Serreli
 */
public class SectionWriterHalArm7 extends SectionWriter implements IEEWriterKeywords, 
	IExtractKeywordsExtentions, IGetEEOPTExtentions {
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;

	/** All data */
	protected final IVarTree vt;
	
	/**
	 * 
	 */
	public SectionWriterHalArm7() {
		this(null);
	}
	
	/**
	 * 
	 */
	public SectionWriterHalArm7(ErikaEnterpriseWriter parent) {
		super(IWritersKeywords.CPU_ARM7, new String[] {}, //
				new String[] { //
						IWritersKeywords.CPU_JANUS,//
						IWritersKeywords.CPU_MPC5xx,//
						IWritersKeywords.CPU_NIOSII, //
						IWritersKeywords.CPU_PIC_30, //
						IWritersKeywords.CPU_AVR5  },
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
		
		return writeEE_ARM7_CPU();
	}


	/**
	 * Write configuration's files for ARM7
	 * 
	 * @return buffers with configuration for ARM7
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeEE_ARM7_CPU()
			throws OilCodeWriterException {
		
		IOilObjectList[] oilObjects = parent.getOilObjects();
		
		IOilWriterBuffer answer = new OilWriterBuffer();
		final int currentRtosId = 0;
		//final String currentRtos = rtosPrefix[currentRtosId];
		/* see currentCpuDataPrefix
		 * final String currentRtosComplete = currentRtos + S
				+ DataPackage.eINSTANCE.getRtos_OilVar().getName() + S
				+ OilXMLLabels.OBJ_OS + oilHwRtosPrefix;*/

		// ------------- Common string --------------------
		
		boolean binaryDistr = parent.checkKeyword(DEF__EE_USE_BINARY_DISTRIBUTION__);

		/*
		 * Define a string for each MAX_OBJECT_NUMBER (OBJECT=task, RESOURCE, ...).
		 * Binary distribution uses the suffix RTD_. 
		 */
		final String MAX_TASK = (binaryDistr ? "RTD_" : "EE_") + "MAX_TASK";

		String pre = "";
		String post = "";
		final String indent = IWritersKeywords.INDENT;

		// ------------- Requirement --------------------
		StringBuffer sbInithal_c = answer.get(FILE_EE_CFG_C);
		IOilObjectList ool = oilObjects[currentRtosId];
		List<ISimpleGenRes> taskNames = ool.getList(IOilObjectList.TASK);
		final String cpuName = ErikaEnterpriseWriter.getOSName(ool);
		final ICommentWriter commentWriterC = getCommentWriter(ool, FileTypes.C);
		final ICommentWriter commentWriterMf = getCommentWriter(ool, FileTypes.MAKEFILE);
		
		String stackType = parent.getStackType(); // MULTI or MONO
		//boolean irq_stack_need = checkKeyword(WritersKeys.IRQ_STACK_NEEDED);

		// ------------- Buffers --------------------
		/* A buffer about stack  */
		StringBuffer sbStack = new StringBuffer();

		// ------------- Compute --------------------

		//String ee_cfg_h_file_name = answer.getFileName(FILE_EE_CFG_H);
		String ee_e7t_h_file_name = answer.getFileName(Arm7Constants.FILE_EE_E7T_H);

		sbInithal_c.append("#include \"ee.h\"\n"
				//+ "#include \"" + ee_cfg_h_file_name + "\"\n"
				+"#include \"" + ee_e7t_h_file_name	+ "\"");

		/***********************************************************************
		 * STACK BASE POINTERS
		 **********************************************************************/
		// get all values
		//   END,SP,UND,ABT,FIQ,SVC,SYS,IRQ
		long stackPointerValues[] = new long[8];
		long[] stackAddress = new long[8]; // resutls
		{
			
			String path[] = { "STACK_TOP", "STACK_BOTTOM", "UND_SIZE",
					"ABT_SIZE", "FIQ_SIZE", "SVC_SIZE", "SYS_SIZE" /*, "IRQ_SIZE"*/ };

			for (int i = 0; i < path.length; i++) {
				String[] tmp = parent.getCpuDataValue(ool, path[i]);
				if (tmp == null || tmp.length == 0)
					throw new RuntimeException("cfg_ARM7 : Expected " + path[i]);

				// check that values are (Long) numbers
				try {
					stackPointerValues[i] = (Long.decode(tmp[0])).longValue();
				} catch (Exception e) {
					throw new RuntimeException("cfg_ARM7 : Wrong int"
							+ path[i]
							+ ", value = "+ tmp[0] + ")");
				}
			}

			stackPointerValues[7] = 16; // IRQ_SIZE

		}
		{
			/*******************************************************************
			 * CHECK STACK SIZE
			 ******************************************************************/
			//   END,SP,UND,ABT,FIQ,SVC,SYS,IRQ
			int stackTot = 0;
			for (int j = 1; j < 8; j++) {
				stackTot += stackPointerValues[j];
			}

			if (stackPointerValues[0] < stackTot) {
				throw new RuntimeException(
						"writeInithal_c : this ARM7 requires more stack : \n\t"
								+ "Given = "
								+ (stackPointerValues[0] - stackPointerValues[1])
								+ "\n\tRequired = "
								+ (stackTot - stackPointerValues[1]));
			}

			// prepare all values (as required inside the Configuration File) from top
			stackAddress[6] = stackPointerValues[0];
			for (int i = 5; i >=0 ; i--) {
				stackAddress[i] = stackAddress[i + 1] - stackPointerValues[i + 2];
			}
			
			if (false) {
				stackAddress[0] = stackPointerValues[1]; // sp
				for (int i = 1; i < 7; i++) {
					stackAddress[i] = stackPointerValues[i + 1]
							+ stackAddress[i - 1];
				}
			}
		}

		/***********************************************************************
		 * MULTI STACK
		 **********************************************************************/
		if (DEF__MULTI_STACK__.equals(stackType)) {
			ArrayList<EEStackData> stackTmp = new ArrayList<EEStackData>();
			sbStack.append(commentWriterC
					.writerBanner("Stack definition for ARM 7"));

			ITreeInterface ti = vt.newTreeInterface();
			//long[] stackRequired = new long[2];

			int[] irqSize = null;
			if (parent.checkKeyword(DEF__IRQ_STACK_NEEDED__)) {
				/***************************************************************
				 * IRQ_STACK
				 **************************************************************/

				final List<String> currentCpuPrefixes = AbstractRtosWriter.getOsProperties(ool, SGRK_OS_CPU_DATA_PREFIX);
				for (String currentCpuPrefix: currentCpuPrefixes) {
					if (irqSize != null) {
						break;
					}
					
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
							irqSize = new int[2];
							{ // get data for IRQ STACK ...  
								String path[] = { "SYS_SIZE"/*, "IRQ_SIZE" */};
	
								for (int i = 0; i < path.length; i++) {
									String tmp = null;
									IVariable var = ti.getValue(prefixIRQ + path[i]
											+ VALUE_VALUE);
									if (var != null && var.get() != null) {
										tmp = var.toString();
									}
									if (tmp == null)
										throw new RuntimeException(
												"cfg_janus : Expected " + path[i]);
	
									// check for value
									try {
										// ... store them inside the irqSize vector
										irqSize[i] = (Integer.decode("" + tmp))
												.intValue();
										// ... and increase the memory requirement
										//stackRequired[i] += irqSize[i];
									} catch (Exception e) {
										throw new RuntimeException(
												"cfg_janus : Wrong int" + path[i]
														+ ", value = " + tmp + ")");
									}
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
			EEStacks elStack = new EEStacks(parent, parent.getOilObjects()[currentRtosId], irqSize);
			ArrayList<String> tList = new ArrayList<String>();  // Task Name
			ArrayList<String> tListN = new ArrayList<String>(); // Task Number (System id)

			{
				/***************************************************************
				 * STACK FOR EACH TASK
				 **************************************************************/
				// add the dummy task
				tListN.add(" ");
				tList.add(IWritersKeywords.dummyName);
				
				// fill data for each task
				for (Iterator<ISimpleGenRes> iter = taskNames.iterator(); iter.hasNext();) {

					ISimpleGenRes sgr = iter.next();
					tList.add(sgr.getName());
					tListN.add(sgr.getString(ISimpleGenResKeywords.TASK_SYS_ID));
				}
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
				/* get offset of each stack. */
				int offset[][] = elStack.taskOffsets(tList
						.toArray(new String[1]));
				/* get the size of each stack. */
				int size[][] = elStack.stackSize(tList
						.toArray(new String[1]));
				/* descrStack contains a description for each stack. */ 
				String[] descrStack = new String[offset.length - 1];
				sbStack.append(indent
						+ "EE_UREG EE_arm7_thread_tos["+MAX_TASK+"+1] = {\n");

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
									+ tListN.get(j) + " (" + tList.get(j) + ")");

				}

				// close sbStack
				sbStack.append(" \t" + post + indent + "};\n\n" + indent
						+ "struct EE_TOS EE_arm7_system_tos["+ErikaEnterpriseWriter.addVectorSizeDefine(ool, "EE_arm7_system_tos", (offset.length - 1))
						+ "] = {\n");

				pre = "";
				post = "";
				// buffer for "stack use" description (SYS & IRQ)
				StringBuffer descrTotStack[] = new StringBuffer[2];
				descrTotStack[0] = new StringBuffer();
				descrTotStack[1] = new StringBuffer();

				/*
				 * For each stack prepare the configuration's vectors and
				 * descriptions
				 */
				for (int j = 0; j < offset.length - 1; j++) {
					// user
					StringBuffer spazi = new StringBuffer(offset[j][0] + "     ");
					sbStack.append(pre
							+ post
							+ indent
							+ indent
							+ "{(EE_ADDR)(__SYS_STACK_ADDRESS "
							+ (offset[j][0] > 0 ? "- "
									+ spazi.substring(0,
											(spazi.length() > 10 ? spazi
													.length() - 5 : 5)) + "-32"
									: "          ") + /*"),");

					// system
					spazi = new StringBuffer(offset[j][1] + "     ");
					sbStack.append(" (EE_ADDR)(__IRQ_STACK_ADDRESS "
							+ (offset[j][1] > 0 ? "- "
									+ spazi.substring(0,
											(spazi.length() > 10 ? spazi
													.length() - 5 : 5)) + "-32"
									: "          ") + */")}");

					// set new values for size
					pre = ",";
					post = "\n";

					// prepare the complete description for all stack use
					descrTotStack[0].append(indent + " 0x"
							+ (Long.toHexString(stackAddress[5] - offset[j][0]
									)).toUpperCase() + "   System stack: "
							+ descrStack[j] + ", Size = " + size[j][0] + "\n");
//					descrTotStack[1].append(indent + " 0x"
//							+ (Long.toHexString(stackAddress[6] - offset[j][1]
//									)).toUpperCase() + "   IRQ stack   : "
//							+ descrStack[j] + ", Size = " + size[j][1] + "\n");
					
					// USED BY ORTI
					stackTmp.add(new EEStackData(j, new long[] {size[j][0]}, new long[] {size[j][0]},
							new String[] {"(unsigned int *)(" + stackAddress[5] + " - 0x" +
									Integer.toHexString(offset[j][0]+size[j][0]).toUpperCase()+ /*DELTA +"*/ " )"}, true));
					
				}

				{// ORTI : Store link between task and stack
					int j = 1;
					for (Iterator<ISimpleGenRes> iter = taskNames.iterator(); iter.hasNext(); j++) {
						ISimpleGenRes sgr = iter.next();
						sgr.setObject(SGRK_TASK_STACK, stackTmp.get(pos[j]));
					}
				}
				
				// complete the stack's buffer
				sbStack.append(" " + post + indent + "};\n\n" + indent
						+ "EE_UREG EE_arm7_active_tos = 0U; /* dummy */\n\n");

				{	// if required, init also the irq stack
					if (irqSize != null) {
						sbStack
								.append(indent+"/* stack used only by IRQ handlers */\n"
										+indent+ "struct EE_TOS EE_arm7_IRQ_tos = {\n"
										+indent+indent+ "(EE_ADDR)(__SYS_STACK_ADDRESS - "
										+ offset[offset.length - 1][0]
//										+ " -32),"
//										+ " (EE_ADDR)(__IRQ_STACK_ADDRESS - "
//										+ offset[offset.length - 1][1]
										+ " -32)\n"
										+indent+ "};\n\n");

						// prepare the complete description for all stack use
						descrTotStack[0].append(indent+" 0x"
								+ (Long.toHexString(stackAddress[5]
										- offset[offset.length - 1][0]))
										.toUpperCase()
								+ "   System stack: IRQ handler, Size = "
								+ irqSize[0] + "\n");
//						descrTotStack[1].append(indent+" 0x"
//								+ (Long.toHexString(stackAddress[6]
//										- offset[offset.length - 1][1]))
//										.toUpperCase()
//								+ "   IRQ stack: IRQ handler, Size = "
//								+ irqSize[1] + "\n");

						// REQUIRED By ORTI's STACK
						int eesdID = stackTmp.size();
						stackTmp.add(new EEStackData(eesdID, new long[] {irqSize[0]}, new long[] {irqSize[0]},
								new String[] {"(unsigned int *)(" + stackAddress[5] + " - 0x" +
										Integer.toHexString(offset[offset.length - 1][0]+irqSize[0]).toUpperCase() + /*DELTA+*/" )"}, true));
					}
				}

				// add the description of memory allocation (stack and other objects)
				sbStack.append(indent + "/*\n" + indent
						+ " Stack Address      Symbol/Note\n" + indent + " 0x"
						+ (Long.toHexString(stackAddress[6])).toUpperCase()
						+ "     __SP_END\n" + indent + " 0x"
						+ (Long.toHexString(stackAddress[6])).toUpperCase()
						+ "     __IRQ_STACK_ADDRESS\n"
						/*+ descrTotStack[1]*/ + indent + " 0x"
						+ (Long.toHexString(stackAddress[5])).toUpperCase()
						+ "     __SYS_STACK_ADDRESS\n"
						+ descrTotStack[0] + indent + " 0x"
						+ (Long.toHexString(stackAddress[4])).toUpperCase()
						+ "     __SVC_STACK_ADDRESS\n" + indent + " 0x"
						+ (Long.toHexString(stackAddress[3])).toUpperCase()
						+ "     __FIQ_STACK_ADDRESS\n" + indent + " 0x"
						+ (Long.toHexString(stackAddress[2])).toUpperCase()
						+ "     __ABT_STACK_ADDRESS\n" + indent + " 0x"
						+ (Long.toHexString(stackAddress[1])).toUpperCase()
						+ "     __UND_STACK_ADDRESS\n" + indent + " 0x"
						+ (Long.toHexString(stackAddress[0])).toUpperCase()
						+ "     __SP_INIT\n" + indent + indent
						+ " ... unused space ... Size = " + (stackAddress[0] - stackPointerValues[1])
						
						+"\n"+ indent + " 0x"
						+ (Long.toHexString(stackPointerValues[1])).toUpperCase()
						+ "     __SP_BOTTOM\n" + indent + " */\n");
			}

		
			// required by ORTI
			ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
			sgrCpu.setObject(SGRK_OS_STACK_LIST, stackTmp.toArray(new EEStackData[0]));
			sgrCpu.setObject(SGRK_OS_STACK_VECTOR_NAME, "EE_hal_thread_tos");

		} else {
			// REQUIRED BY ORTI (STACK Section)
			

		    /***********************************************************************
			 * STACK BASE POINTERS
			 * 
			 * If it's a number, stackPointer is set as a Long;
			 * If it's a string (as alt_data_end), stackPointer is set as a String.
			 *  
			 **********************************************************************/
			final Object stackPointer;
			{
				String key = "STACK_TOP";
				List<String> tmp = parent.getRtosCommonAttributes(ool, key);
				if (tmp.size() == 0)
					throw new RuntimeException("Expected " + key +" for cpu " + cpuName );

				// check that values is a (Long) number
				Object stmp = null;
				try {
					stmp = Long.decode(tmp.get(0));
				} catch (Exception e) {
					stmp = tmp.get(0);
				}
				stackPointer = stmp;

			}

			// ** Required for StackData ** 
			final String stackBaseDescr = stackPointer instanceof Long ?
					"0x"+ Long.toHexString(((Long) stackPointer).longValue())
					:
					"(int)(&"+stackPointer+")";
					
		    /***********************************************************************
			 * STACK SIZE
			 **********************************************************************/
			final long stackSize;
			{
				String key = "SYS_SIZE";
				List<String> tmp = parent.getRtosCommonAttributes(ool, key);
				if (tmp.size() == 0)
					throw new RuntimeException("Expected " + key +" for cpu " + cpuName );

				// check that values is a (Long) number
				Long stmp = null;
				try {
					stmp = Long.decode(tmp.get(0));
				} catch (Exception e) {
					throw new RuntimeException(
							"Expected an integer for SYS_SIZE ("+ tmp.get(0) + ")");
				}
				stackSize = stmp.longValue();
			}

			EEStackData[] stackD = new EEStackData[1];
			
			// prepare the complete description for all stack use
			stackD[0] = new EEStackData(0, new long[] {stackSize}, new long[] {stackSize},
					new String[] {"(unsigned int *)(" + stackBaseDescr + " - 0x" +
							Long.toHexString(stackSize).toUpperCase()+ /*DELTA +*/ " )"}, true);
			
			ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
			sgrCpu.setObject(SGRK_OS_STACK_LIST, stackD);
		}

		// ------------- Write --------------------
		sbInithal_c.append(commentWriterC
				.writerBanner("Initialization of HAL Variables for ARM 7")
				// add stack buffers
				+ sbStack);
		
		
		// write the memory configuration file for ARM7
		answer.append(Arm7Constants.FILE_EE_E7T_H, "#define __SP_END            0x"
				+ (Long.toHexString(stackAddress[6])).toUpperCase() + "\n"
				+ "#define __IRQ_STACK_ADDRESS 0x"
				+ (Long.toHexString(stackAddress[6])).toUpperCase() + "\n"
				+ "#define __SYS_STACK_ADDRESS 0x"
				+ (Long.toHexString(stackAddress[5])).toUpperCase() + "\n"
				+ "#define __SVC_STACK_ADDRESS 0x"
				+ (Long.toHexString(stackAddress[4])).toUpperCase() + "\n"
				+ "#define __FIQ_STACK_ADDRESS 0x"
				+ (Long.toHexString(stackAddress[3])).toUpperCase() + "\n"
				+ "#define __ABT_STACK_ADDRESS 0x"
				+ (Long.toHexString(stackAddress[2])).toUpperCase() + "\n"
				+ "#define __UND_STACK_ADDRESS 0x"
				+ (Long.toHexString(stackAddress[1])).toUpperCase() + "\n"
				+ "#define __SP_INIT           0x"
				+ (Long.toHexString(stackAddress[0])).toUpperCase() + "\n");

		
		
		{
			/***********************************************************************
	         * 
	         * MAKE FILE
	         *  
	         **********************************************************************/
			OsType wrapper = HostOsUtils.common.getTarget();

			    StringBuffer sbMakefile = new StringBuffer(commentWriterMf.writerBanner("ARM 7"));
			    
			    {	// PATHs
		        	HashMap<String, ?> options = parent.getOptions();

		        	String cleanPath = "c:/set/arm7/gcc/path";

			        String outputDir = "Debug";
			        String appBase = "";
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

			    	if (options.containsKey(Arm7Constants.PREF_ARM7_GCC_PATH)) {
						String tmp = (String) options.get(Arm7Constants.PREF_ARM7_GCC_PATH);
						if (tmp.length()>0) cleanPath = tmp;
					}
			        sbMakefile.append(
			        		CommonUtils.addMakefileDefinesInclude() +
			                "APPBASE := " + appBase + "\n" +
			                "OUTBASE := " + outputDir + "\n" +
							"\n" +			                	
			                CommonUtils.compilerMakefileDefines(cleanPath, "ARM7_GCCDIR", wrapper) + 
			                "ARM7_GCCPREFIX := arm-elf\n\n"
			                
			        );
			    }

			    
			    // linker script
				String[] tmp = parent.getCpuDataValue(ool, "LINKER_SCRIPT");
				if (tmp != null && tmp.length != 0 && tmp[0] != null){
		            String linkerScript = tmp[0];
		            
		            sbMakefile.append("ARM7_LINKERSCRIPT := " + linkerScript+"\n\n");
		        }
		        
				ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
	            sgrCpu.setProperty(SGRK__MAKEFILE_EXTENTIONS__, sbMakefile.toString());

			}

		
		return new IOilWriterBuffer[] { answer };
	}


	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.IExtractKeywordsExtentions#updateKeywords(java.util.ArrayList, java.lang.String[])
	 */
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix)
			throws OilCodeWriterException {

		if (!keywords.contains(IWritersKeywords.CPU_ARM7)) {
			return;
		}

		final IVarTree vt = parent.getVt();

		//final ArrayList ee_opts = new ArrayList();
		for (int i=0; i<rtosPrefix.length; i++) {
			
			/*******************************************************************
			 * BOARD TYPE
			 ******************************************************************/
			String path = parent.computeOilRtosPrefix(rtosPrefix[i]) + "BOARD_DATA";

			String[] child = new String[1];
			String board_type = CommonUtils.getFirstChildEnumType(vt,
					path , child);
			if (board_type != null) {

				// check if the value is valid
				if ("EVALUATOR7T".equals(board_type)
						&& !keywords.contains(Arm7Constants.DEF__EVALUATOR7T__)) {
					keywords.add(Arm7Constants.DEF__EVALUATOR7T__);
				}
				
			}
		}

	}	

	
	/* (non-Javadoc)
	 * @see com.eu.evidence.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions#getEEOpt(int)
	 */
	public List<String> getEEOpt(int type, int rtosId) {
		List<String> answer = new ArrayList<String>();
		
		
		if ((type & EE_OPT_COMMON_AUTO_ONLY) != 0) {
			/*******************************************************************
			 * AUTOMATIC OPTIONS (not CPU DEPENDENT)
			 ******************************************************************/

			{ // Extract options from current keywords
				String[][] fromKeywords = new String[][] {

					// -------- CPU -------------
					{ IWritersKeywords.CPU_ARM7,
							"__ARM7GNU__" },
					// -------- BOARD -------------
					{ Arm7Constants.DEF__EVALUATOR7T__,
							"__EVALUATOR7T__"}
				};

				for (int i = 0; i < fromKeywords.length; i++) {
					if (parent.checkKeyword(fromKeywords[i][0])) {
					    String[] splitted = fromKeywords[i][1].split(" ");
					    for (int l=0; l<splitted.length; l++) {
					        answer.add(splitted[l]);
					    }
					}
				}


			}
			
		}

		return answer;
	}

}
