/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterHalMpc5.java,v 1.4 2007/09/12 16:01:50 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.eu.evidence.modules.oil.ppc.constants.PpcConstants;
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
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStacks;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;

/**
 * This writer build files for configure the Hal of an Arm7
 * 
 * @author Nicola Serreli
 */
public class SectionWriterHalMpc5 extends SectionWriter implements IEEWriterKeywords {
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;

	/** All data */
	protected final IVarTree vt;

	/**
	 * 
	 */
	public SectionWriterHalMpc5() {
		this(null);
	}
	/**
	 * 
	 */
	public SectionWriterHalMpc5(ErikaEnterpriseWriter parent) {
		super(IWritersKeywords.CPU_MPC5xx,
				new String[] {}, //
				new String[] { //
						IWritersKeywords.CPU_ARM7,//
						IWritersKeywords.CPU_JANUS,//
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
		
		return writeEE_MPC5_WITHOUTPROTECTION_CPU();
	}

	/**
	 * Write configuration's files for MPC5xx without memory protection
	 * 
	 * @return buffers with configuration for MPC5xx without memory protection
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeEE_MPC5_WITHOUTPROTECTION_CPU()
			throws OilCodeWriterException {

		IOilWriterBuffer answer = new OilWriterBuffer();
		final int currentRtosId = 0;
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		final IOilObjectList ool = oilObjects[currentRtosId];
		
		final ICommentWriter commentWriterC = getCommentWriter(ool, FileTypes.C);

		// ------------- Common string --------------------
		boolean binaryDistr = parent.checkKeyword(IEEWriterKeywords.DEF__EE_USE_BINARY_DISTRIBUTION__);

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
		List<ISimpleGenRes> taskNames = oilObjects[currentRtosId].getList(IOilObjectList.TASK);
		String stackType = parent.getStackType(); // MULTI or MONO
		//boolean irq_stack_need = checkKeyword(WritersKeys.IRQ_STACK_NEEDED);

		// ------------- Compute --------------------

		//String ee_cfg_h_file_name = answer.getFileName(FILE_EE_CFG_H);
		String ee_evb_h_file_name = answer.getFileName(PpcConstants.FILE_EE_EVB_H);

		sbInithal_c.append("#include \"ee.h\"\n" 
				//+ "#include \"" + ee_cfg_h_file_name + "\"\n"
				+"#include \"" + ee_evb_h_file_name
				+ "\"");

		/***********************************************************************
		 * STACK BASE POINTERS
		 **********************************************************************/
		long stackPointer;
		long stackEnd;
		{
			String[] tmp = parent.getCpuDataValue(ool, "STACK_BOTTOM");
			if (tmp == null || tmp.length == 0 || tmp[0] == null)
				throw new RuntimeException("cfg_mpc5 : Expected " + "STACK_BOTTOM");

			// check that values is a (Long) number
			try {
				stackPointer = (Long.decode(tmp[0])).longValue();
			} catch (Exception e) {
				throw new RuntimeException("cfg_mpc5 : Wrong int"
						+ "STACK_BOTTOM"
						+ ", value = " + tmp[0] + ")");
			}

		}
		stackEnd = stackPointer;

		/***********************************************************************
		 * MULTI STACK
		 **********************************************************************/
		if (DEF__MULTI_STACK__.equals(stackType)) {
			// ------------- Buffers --------------------
			/* A buffer about stack  */
			StringBuffer sbStack = new StringBuffer();

			sbStack.append(commentWriterC
					.writerBanner("Stack definition for MPC5xx without protection"));

			ITreeInterface ti = vt.newTreeInterface();


			
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
												"cfg_mpc5 : Expected " + path[i]);
	
									// check for value
									try {
										// ... store them inside the irqSize vector
										irqSize[0] = (Integer.decode("" + tmp))
												.intValue();
										// ... and increase the memory requirement
										stackEnd -= irqSize[0];
									} catch (Exception e) {
										throw new RuntimeException(
												"cfg_mpc5 : Wrong int" + path[i]
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
			EEStacks elStack = new EEStacks(parent, oilObjects[currentRtosId], irqSize);
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
				int offset[][] = elStack.taskOffsets((String[]) tList
						.toArray(new String[0]));
				stackEnd -= offset[offset.length - 1][0]; // tot sys
			}

			
			{
				/***************************************************************
				 * PREPARE BUFFERS
				 **************************************************************/

				pre = "";
				post = "";

				/* get the link between a task and its stack. */
				int pos[] = elStack.taskStackLink((String[]) tList
						.toArray(new String[1]));
				/* get offset of each stack. */
				int offset[][] =elStack.taskOffsets((String[]) tList
						.toArray(new String[1]));
				/* get the size of each stack. */
				int size[][] = elStack.stackSize((String[]) tList
						.toArray(new String[1]));
				/* descrStack contains a description for each stack. */ 
				String[] descrStack = new String[offset.length - 1];
				sbStack.append(indent
						+ "EE_UREG EE_mpc5_thread_tos["+MAX_TASK+"+1] = {\n");

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
						+ "struct EE_TOS EE_mpc5_system_tos["+ErikaEnterpriseWriter.addVectorSizeDefine(ool, "EE_mpc5_system_tos", offset.length - 1)
						+ "] = {\n");

				pre = "";
				post = "";
				// buffer for "stack use" description (SYS & IRQ)
				StringBuffer descrTotStack = new StringBuffer();

				/*
				 * For each stack prepare the configuration's vectors and
				 * descriptions
				 */
				for (int j = 0; j < offset.length - 1; j++) {
					StringBuffer spazi = new StringBuffer(offset[j][0] + "     ");
					sbStack.append(pre
							+ post
							+ indent
							+ indent
							+ "{(EE_ADDR)(__SYS_STACK_ADDRESS "
							+ (offset[j][0] > 0 ? "- "
									+ spazi.substring(0,
											(spazi.length() > 10 ? spazi
													.length() - 5 : 5)) + "-8"
									: "          ") + " )}");

					// set new values for size
					pre = ",";
					post = "\n";

					// prepare the complete description for all stack use
					descrTotStack.append(indent + " 0x"
							+ (Long.toHexString(stackPointer - offset[j][0]
									)).toUpperCase() + "   System stack: "
							+ descrStack[j] + ", Size = " + size[j][0] + "\n");
				}

				// complete the stack's buffer
				sbStack.append(" " + post + indent + "};\n\n" + indent
						+ "EE_UREG EE_mpc5_active_tos = 0U; /* dummy */\n\n");

				{ // if required, init also the irq stack
					if (irqSize != null) {
						sbStack
								.append(indent+"/* stack used only by IRQ handlers */\n"
										+ indent+"struct EE_TOS EE_pmc5_IRQ_tos = {\n"
										+ indent+indent+"(EE_ADDR)(__SYS_STACK_ADDRESS - "
										+ offset[offset.length - 1][0]
										+ " -8 )\n"
										+ indent+"};\n\n");

						// prepare the complete description for all stack use
						descrTotStack.append(indent+" 0x"
								+ (Long.toHexString(stackPointer
										- offset[offset.length - 1][0]))
										.toUpperCase()
								+ "   System stack: IRQ handler, Size = "
								+ irqSize[0] + "\n");
					}
				}

				// add the description of memory allocation (stack and other objects)
				sbStack.append(indent + "/*\n" + indent
						+ " Stack Address      Symbol/Note\n"
						+ indent + " 0x"+ (Long.toHexString(stackPointer)).toUpperCase()+ "     __SP_INIT\n"
						+ indent + " 0x"+ (Long.toHexString(stackPointer)).toUpperCase()+ "     __SYS_STACK_ADDRESS\n"
						+ descrTotStack 
						+ indent + " 0x"+ (Long.toHexString(stackEnd)).toUpperCase()+ "     __SP_END\n"
						+ indent + " */\n");
			}

			// ------------- Write --------------------
			sbInithal_c.append(sbStack);
		}


		{
			/*******************************************************************
			 * IRQ TABLE
			 ******************************************************************/
			sbInithal_c.append(commentWriterC.writerBanner("Init IRQ Handler Table"));

			/*******************************************************************
			 * get values
			 ******************************************************************/

			String[] irq_labels = {
					"HANDLER_IRQ", "HANDLER_LVL"
			};

			Properties irq = new Properties();
			
			// get all defined handler
			for (int i=0; i<=7; i++) {
				for (int il=0; il<2; il++) {
					String[] tmpVal = parent.getCpuDataValue(ool, irq_labels[il]+i);
				
					if (tmpVal != null && tmpVal.length >0) {
						irq.setProperty(irq_labels[il]+i,
								tmpVal[0]);
					}

				}
			}
			
			
			/***********************************************************************
			 * prepare buffers
			 **********************************************************************/
			
			final String indent1 = IWritersKeywords.INDENT;
			final String indent2 = indent1 + indent1;
			final String FOR_EVER_LOOP_FUNCTION_NAME = "EE_RTDruid_forever_loop";

			/* functionBuffer contains all function's declaration */
			StringBuffer functionBuffer = new StringBuffer();
			
			/* buffer contains the irq table with all handler's address */
			StringBuffer buffer = new StringBuffer();
			buffer.append(indent1 + "const EE_ADDR EE_mpc5_irq_table["+ErikaEnterpriseWriter.addVectorSizeDefine(ool, "EE_mpc5_irq_table", 16)+"] = {\n");
			
			/*
			 * requireForEverLoop checks if all handler are defined by user.
			 * If not, means that the forEverLoop is required and then it's added
			 */
			boolean requireForEverLoop = false;
			String[] irq_descr = {
					"IRQ", "LVL"
			};

			String descr = "";
			for (int i=0; i<=7; i++) {
				for (int il=0; il<2; il++) {
					// tmp contains the function's name (the current handler of
					// current interrupt)
					String tmp;
					if (irq.containsKey(irq_labels[il]+i)) {
						tmp = irq.getProperty(irq_labels[il]+i);
						// add the declared handler to declaration's buffer
						functionBuffer.append(indent1+"void "+tmp+"(void);\n");
					} else {
						tmp = FOR_EVER_LOOP_FUNCTION_NAME;
						// for ever loop is required
						requireForEverLoop = true;
					}

					// update irq table
					buffer.append(descr + indent2 + "(EE_ADDR)" + tmp);
					descr = ",\t/* " +irq_descr[il]+i + " handler */\n";
				}
			}

			// complete the irq table
			buffer
					.append("\t/* " +irq_descr[1]+7 + " handler */\n" + indent1 + "};\n\n");

			/***********************************************************************
			 * write buffers
			 **********************************************************************/
			// write all function
			if (requireForEverLoop) {
				sbInithal_c.append(indent1 + "void "+FOR_EVER_LOOP_FUNCTION_NAME+"(void)\n" + indent1 + "{\n"
					+ indent2 + "  for (;;);\n" + indent1 + "}\n\n");
			}
			if (functionBuffer.length() != 0) {
				sbInithal_c.append(functionBuffer+"\n");
			}
			// write the irq table
			sbInithal_c.append(buffer);

			/***********************************************************************
			 *  IRQ Mask
			 **********************************************************************/
			// write all irq mask (always the same, at this moment)
			sbInithal_c.append(indent1+"#ifdef __ALLOW_NESTED_IRQ__\n"+
					indent1+"#ifndef __ENHANCED_IRQ__\n"+
					indent1+"const EE_UINT32 EE_mpc5_irq_mask["+ErikaEnterpriseWriter.addVectorSizeDefine(ool, "EE_mpc5_irq_mask", 16)+"] = {\n"+
					indent2+"0x00000000,\n"+
					indent2+"0x80000000,\n"+
					indent2+"0xC0000000,\n"+
					indent2+"0xE0000000,\n"+
					indent2+"0xF0000000,\n"+
					indent2+"0xF8000000,\n"+
					indent2+"0xFC000000,\n"+
					indent2+"0xFE000000,\n"+
					indent2+"0xFF000000,\n"+
					indent2+"0xFF800000,\n"+
					indent2+"0xFFC00000,\n"+
					indent2+"0xFFE00000,\n"+
					indent2+"0xFFF00000,\n"+
					indent2+"0xFFF80000,\n"+
					indent2+"0xFFFC0000,\n"+
					indent2+"0xFFFE0000\n"+
					indent1+"};\n"+
					indent1+"#endif\n"+
					indent1+"#endif\n");
		}
		
		
		/***********************************************************************
		 *  memory configuration file for MPC5xx without Memory protection
		 **********************************************************************/
		answer.append(PpcConstants.FILE_EE_EVB_H,
				"extern EE_ADDR __HEAP_END;\n\n"
				+ "#define __SP_INIT           0x"+ (Long.toHexString(stackPointer)).toUpperCase() + "\n"
				+ "#define __SYS_STACK_ADDRESS 0x"+ (Long.toHexString(stackPointer)).toUpperCase() + "\n"
				+ "#define __SP_END            __HEAP_END\n\n");

		return new IOilWriterBuffer[] { answer };
	}

}
