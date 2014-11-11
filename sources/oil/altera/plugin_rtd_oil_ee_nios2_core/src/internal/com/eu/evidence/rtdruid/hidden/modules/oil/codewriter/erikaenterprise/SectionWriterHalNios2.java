/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterHalNios2.java,v 1.8 2007/07/18 07:12:34 durin Exp $
 */
package com.eu.evidence.rtdruid.hidden.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.eu.evidence.rtdruid.desk.Messages;
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
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStackData;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStacks;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;

/**
 * This writer build files for configure the Hal of an Arm7
 * 
 * @author Nicola Serreli
 */
public class SectionWriterHalNios2 extends SectionWriter 
		implements IEEWriterKeywords,
				IExtractObjectsExtentions,
				IExtractKeywordsExtentions,
				IGetEEOPTExtentions {
		
	public final static String DEF___NIOS2_SPIN_AVALON_MUTEX_DIRECT__ = "__NIOS2_SPIN_AVALON_MUTEX_DIRECT__";
	
	/* Identifies a the bitwise mask used to identify system resources in the HR kernel*/
	public final static String HR_SYSTEM_RESOURCES_MASK__ = "__HR_SYSTEM_RESOURCES_MASK___";
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;

	/** All data */
	protected final IVarTree vt;

	/** The default delta at the begin of each stack */
    final String DELTA = " -36";

    /**
	 * 
	 */
	public SectionWriterHalNios2() {
		this(null);
	}
    
	/**
	 * 
	 */
	public SectionWriterHalNios2(ErikaEnterpriseWriter parent) {
		super(IWritersKeywords.CPU_NIOSII,
				new String[] {}, //
				new String[] { //
						IWritersKeywords.CPU_JANUS,//
						IWritersKeywords.CPU_MPC5xx,//
						IWritersKeywords.CPU_ARM7, //
						IWritersKeywords.CPU_PIC_30, //
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
		
		
		ArrayList<IOilWriterBuffer> answer = new ArrayList<IOilWriterBuffer>();
		ErikaEnterpriseWriter.appendBuffers(answer, writeEE_NIOSII_CPU());
//		ErikaEnterpriseWriter.appendBuffers(answer, parent.writeEEOptAsDefine());

		// prepare the answer
		return (IOilWriterBuffer[]) answer.toArray(new OilWriterBuffer[answer.size()]);
	}


	/**
	 * Write configuration's files for NIOSII
	 * 
	 * @return buffers with configuration for NIOSII
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeEE_NIOSII_CPU()
			throws OilCodeWriterException {
		

		final IOilObjectList[] oilObjects = parent.getOilObjects();


		final int rtosNumber = oilObjects.length;

		final String indent1 = IWritersKeywords.INDENT;
		final String indent2 = indent1 + IWritersKeywords.INDENT;
		IOilWriterBuffer[] answer = new IOilWriterBuffer[oilObjects.length];
		
		final boolean binaryDistr = parent.checkKeyword(IEEWriterKeywords.DEF__EE_USE_BINARY_DISTRIBUTION__);
		final String MAX_CPU = (binaryDistr ? "RTD_" : "EE_") + "MAX_CPU";
		final String MAX_TASK = (binaryDistr ? "RTD_" : "EE_") + "MAX_TASK";

				
		// IPIC
		String globalIpcName = "";
		if (rtosNumber>1) {
			String key = "IPIC_GLOBAL_NAME";
			HashMap<String, ArrayList<String>> values = parent.getRtosCommonAttributes(new String[] {key});
			if (!values.containsKey(key)) {
				throw new OilCodeWriterException("Expected a value for " + key );
			}
			globalIpcName = (String) ((ArrayList<String>) values.get(key)).get(0);
		}
		
		for (int rtosId=0; rtosId<rtosNumber; rtosId++) {
			answer[rtosId] = new OilWriterBuffer();
			IOilObjectList ool = oilObjects[rtosId];

			// ------------- Common string --------------------
			
			/*
			 * Define a string for each MAX_OBJECT_NUMBER (OBJECT=task, RESOURCE, ...).
			 * Binary distribution uses the suffix RTD_. 
			 */
	
			String pre = "";
			String post = "";

			// ------------- Requirement --------------------
			StringBuffer sbInithal_c = answer[rtosId].get(FILE_EE_CFG_C);
			List<ISimpleGenRes> taskNames = ool.getList(IOilObjectList.TASK);
			String stackType = parent.getStackType(); // MULTI or MONO
			final String cpuName = ErikaEnterpriseWriter.getOSName(ool);

			final ICommentWriter commentWriterC = getCommentWriter(ool, FileTypes.C);
			final ICommentWriter commentWriterH = getCommentWriter(ool, FileTypes.H);

			// ------------- Compute --------------------
			
			sbInithal_c.append("#include \"ee.h\"\n");

			/***********************************************************************
			 * MULTI STACK
			 **********************************************************************/
			if (DEF__MULTI_STACK__.equals(stackType)) {
				// ------------- Buffers --------------------
				/* A buffer about stack  */
				StringBuffer sbStack = new StringBuffer();
				ArrayList<EEStackData> stackTmp = new ArrayList<EEStackData>();
				
				/***********************************************************************
				 * STACK BASE POINTERS
				 * 
				 * If it's a number, stackPointer is set as a Long;
				 * If it's a string (as alt_data_end), stackPointer is set as a String. 
				 **********************************************************************/
				final String STR_STACK_ADDRESS = "__RTD_SYS_STACK_ADDRESS";
				final Object stackPointer;

//				final long maxStackEnd;
				long stackSize = 0;
				{
					String key = "STACK_TOP";
					String[] tmp = getStackSize(ool, cpuName, key);

					// check that values is a (Long) number
					Object stmp = null;
					try {
						stmp = Long.decode(tmp[0]);
					} catch (Exception e) {
						/*throw new RuntimeException("cfg_nios2 : Wrong int"
								+ "STACK_TOP"
								+ ", value = " + tmp[0] + ")");*/
						
						stmp = tmp[0];
					}
					stackPointer = stmp;

				}

				// ** Required for StackData ** 
				final String stackBaseDescr;
				
				sbStack.append(commentWriterC
						.writerBanner("Stack definition for NIOS II"));
				if (stackPointer instanceof String) {
					sbStack.append(indent1+ "extern int " +stackPointer +";\n");
				}
				stackBaseDescr = stackPointer instanceof Long ?
						"0x"+ Long.toHexString(((Long) stackPointer).longValue())
						:
						"(int)(&"+stackPointer+")";
				sbStack.append(indent1+ "#define " +STR_STACK_ADDRESS +" " + 
						stackBaseDescr + "\n\n");
				
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
													"cfg_nios2 : Expected " + path[i]);
	
										// check for value
										try {
											// ... store them inside the irqSize vector
											irqSize[0] = (Integer.decode("" + tmp))
													.intValue();
											// ... and increase the memory requirement
											stackSize += irqSize[0];
										} catch (Exception e) {
											throw new RuntimeException(
													"cfg_nios2 : Wrong int" + path[i]
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
				EEStacks elStack = new EEStacks(parent, oilObjects[rtosId], irqSize);
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
					int offset[][] = elStack.taskOffsets((String[]) tList
							.toArray(new String[0]));
					stackSize += offset[offset.length - 1][0]; // tot sys
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
					sbStack.append(indent1
							+ "EE_UREG EE_hal_thread_tos["+MAX_TASK+"+1] = {\n");

					for (int j = 0; j < pos.length; j++) {
						sbStack.append(pre + post + indent1 + indent1 + +pos[j]+"U");
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
					sbStack.append(" \t" + post + indent1 + "};\n\n" + indent1
							+ "struct EE_TOS EE_nios2_system_tos["+ErikaEnterpriseWriter.addVectorSizeDefine(ool, "EE_nios2_system_tos", offset.length - 1)
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
								+ indent1
								+ indent1
								+ "{(EE_ADDR)(" +STR_STACK_ADDRESS
								+ (offset[j][0] > 0 ? "- "
										+ spazi.substring(0,
												(spazi.length() > 10 ? spazi
														.length() - 5 : 5)) + DELTA
										: "          ") + " )}");
						// set new values for size
						pre = ",";
						post = "\n";

						// prepare the complete description for all stack use
						descrTotStack.append(indent1 + " "+ STR_STACK_ADDRESS+" - 0x"
								+ Integer.toHexString(offset[j][0]).toUpperCase() 
								+ "   System stack: "
								+ descrStack[j] + ", Size = " + size[j][0] + "\n");

						// USED BY ORTI
						stackTmp.add(new EEStackData(j, new long[] {size[j][0]}, new long[] {size[j][0]},
								new String[] {"(unsigned int *)(" + stackBaseDescr + " - 0x" +
										Integer.toHexString(offset[j][0]+size[j][0]).toUpperCase()+ /*DELTA +"*/ " )"}, true));
					}

					{// ORTI : Store link between task and stack
						int j = 1;
						for (Iterator<ISimpleGenRes> iter = taskNames.iterator(); iter.hasNext(); j++) {
							ISimpleGenRes sgr = (ISimpleGenRes) iter.next();
							sgr.setObject(SGRK_TASK_STACK, stackTmp.get(pos[j]));
						}
					}
					
					// complete the stack's buffer
					sbStack.append(" " + post + indent1 + "};\n\n" + indent1
							+ "EE_UREG EE_hal_active_tos = 0U; /* dummy */\n\n");

					{ // if required, init also the irq stack
						if (irqSize != null) {

							sbStack
									.append(indent1+"/* stack used only by IRQ handlers */\n"
											+ indent1+"struct EE_TOS EE_nios2_IRQ_tos = {\n"
											+ indent1+indent1+ "(EE_ADDR)(" +STR_STACK_ADDRESS+"- 0x" +
											Integer.toHexString(offset[offset.length - 1][0]).toUpperCase()+ " )\n"
											+ indent1+"};\n\n");

							// prepare the complete description for all stack use
							descrTotStack.append(indent1+ " " +STR_STACK_ADDRESS+" - " +
									Integer.toHexString(offset[offset.length - 1][0]).toUpperCase()
									+ "   System stack: IRQ handler, Size = "
									+ irqSize[0] + "\n");
							
							// REQUIRED By ORTI's STACK
							int eesdID = stackTmp.size();
							stackTmp.add(new EEStackData(eesdID, new long[] {irqSize[0]}, new long[] {irqSize[0]},
									new String[] {"(unsigned int *)(" + stackBaseDescr + " - 0x" +
											Integer.toHexString(offset[offset.length - 1][0]+irqSize[0]).toUpperCase() + /*DELTA+*/" )"}, true));
						}
					}

					// add the description of memory allocation (stack and other objects)
					sbStack.append(indent1 + "/*\n" + indent1
							+ " Stack Address      Symbol/Note\n"
							+ indent1 + " "+ STR_STACK_ADDRESS+ "     Higher stack address\n"
							+ descrTotStack 
							+ indent1 + " "+ STR_STACK_ADDRESS +" - 0x" + (Long.toHexString(stackSize)).toUpperCase()+ "     Lower stack address\n"
							+ indent1 + " */\n");
				}

				// ------------- Write --------------------
				sbInithal_c.append(sbStack);
				
				// required by ORTI
				ISimpleGenRes os = ool.getList(IOilObjectList.OS).get(0);
				os.setObject(SGRK_OS_STACK_LIST, (EEStackData[]) stackTmp.toArray(new EEStackData[0]));
				os.setObject(SGRK_OS_STACK_VECTOR_NAME, "EE_hal_thread_tos");
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
					
					String[] tmp = getStackSize(ool, cpuName, key);

					// check that values is a (Long) number
					Object stmp = null;
					try {
						stmp = Long.decode(tmp[0]);
					} catch (Exception e) {
						stmp = tmp[0];
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
					String[] tmp = getStackSize(ool, cpuName, key);
					// check that values is a (Long) number
					Long stmp = null;
					try {
						stmp = Long.decode(tmp[0]);
					} catch (Exception e) {
						throw new RuntimeException(
								"cfg_nios2 : Wrong int "+ key
										+ ", value = " + tmp[0] + ")");
					}
					stackSize = stmp.longValue();
				}

				EEStackData[] stackD = new EEStackData[1];
				
				// prepare the complete description for all stack use
				stackD[0] = new EEStackData(0, new long[] {stackSize}, new long[] {stackSize},
						new String[] {"(unsigned int *)(" + stackBaseDescr + " - 0x" +
								Long.toHexString(stackSize).toUpperCase()+ /*DELTA +*/ " )"}, true);
					
				ISimpleGenRes os = ool.getList(IOilObjectList.OS).get(0);
				os.setObject(SGRK_OS_STACK_LIST, stackD);

			}

			
			{
				/*******************************************************************
				 * 
				 * SHARED RESOURCES (macros)
				 * IPIC
				 *  
				 ******************************************************************/

				// OLD IPIC
//	            // IPIC
//				String[] ipic = CommonUtils
//					.getValue(vt, currentCpuPrefix + "IPIC_NAME");
//				if (ipic != null && ipic.length >0 && ipic[0]!=null) {
//
//				    sbInithal_c.append(CommonUtils.writerBannerC("IPIC")
//				            + "#include <system.h>\n"
//				            + indent1 + "alt_u32 * const EE_IPIC_BASE = (alt_u32 *)"+ ipic[0] + "_BASE;\n"
//				            + indent1 + "alt_u32 const EE_IPIC_IRQ = "+ ipic[0] + "_IRQ;\n\n");
//				}

				if (rtosNumber>1) {
		            // IPIC
					String ipicKey = "IPIC_LOCAL_NAME";
					String[] ipic = parent.getCpuDataValue(ool, ipicKey);
					if (ipic != null && ipic.length >0 && ipic[0]!=null) {
	
					    sbInithal_c.append(commentWriterC.writerBanner("IPIC")
					            + "#include <system.h>\n"
					            + indent1 + "alt_u32 * const EE_IPIC_OUTPUT_BASE = (alt_u32 *)"+ globalIpcName + "_BASE;\n"
					            + indent1 + "alt_u32 * const EE_IPIC_INPUT_BASE  = (alt_u32 *)"+ ipic[0] + "_BASE;\n"
					            + indent1 + "alt_u32 const EE_IPIC_IRQ = "+ ipic[0] + "_IRQ;\n\n");
					} else {
						throw new RuntimeException("Expected " + ipicKey +" for cpu " + cpuName );
					}
				}
				
				
				// MUTEX
	            StringBuffer sbeecfg_h = answer[rtosId].get(FILE_EE_CFG_H);
				List<ISimpleGenRes> mutexList = oilObjects[rtosId].getList(IOilObjectList.RESOURCE);

				if (mutexList.size()>0) {
					sbeecfg_h.append(
							commentWriterH.writerBanner("MACROs for MUTEX definition"));
						
					for (Iterator<ISimpleGenRes> iter = mutexList.iterator(); iter.hasNext();) {
						ISimpleGenRes curr = (ISimpleGenRes) iter.next();
						
						boolean currGlobal = curr.containsProperty(ISimpleGenResKeywords.RESOURCE_GLOBAL) && 
								"true".equalsIgnoreCase(curr.getString(ISimpleGenResKeywords.RESOURCE_GLOBAL));
								
						sbeecfg_h.append(indent1 + "#define EE_SHARED_RES_" + curr.getName() + "(var) "
									+ (currGlobal ? parent.sharedData("var","",null) : "var") + "\n");
					}
				}
	            
			}
			if(parent.checkKeyword(IWritersKeywords.HR)) {
				/* Setting the bitwise mask used to identify system resources in the HR kernel */
				ISimpleGenRes res = ool.getList(IOilObjectList.RESOURCE).get(0);
				res.setObject(HR_SYSTEM_RESOURCES_MASK__, 0x40000000);
			}
		} // end for (int rtosId ... rtosPrefix..)
		
		if (rtosNumber>1) {
			/*******************************************************************
			 * 
			 * MUTEX device
			 *  
			 ******************************************************************/
			// search the MUTEX_DEVICE definition
			String mutexDevice = null;
			final String key = "NIOS2_MUTEX_BASE";
			
			HashMap<String, ArrayList<String>> map = parent.getRtosCommonAttributes(new String[] {key});
			ArrayList<String> values = (ArrayList<String>) map.get(key);
			if (values != null) {

				if (values.size() == 1 ) {
					mutexDevice = (String) values.get(0);
					
				} else if (values.size() >1) {
					throw new OilCodeWriterException("OS/"+key+" is setted with different values");
				}
			}

			if (mutexDevice != null) {
				// append mutex Device to all eecfg.h
				for (int rtosId = 0; rtosId < rtosNumber; rtosId++) {
					
		        	final ICommentWriter commentWriterC = getCommentWriter(oilObjects[rtosId], FileTypes.C);

					
		            if (binaryDistr) {
			            StringBuffer sbeecfg_c = answer[rtosId].get(FILE_EE_CFG_C);
			            sbeecfg_c.append(commentWriterC.writerBanner("MutexDevice") 
			            		+ indent1+ "const unsigned int EE_ALTERA_MUTEX_BASE = " + mutexDevice+";\n\n");

		            } else {
			            StringBuffer sbeecfg_h = answer[rtosId].get(FILE_EE_CFG_H);
			            
			            sbeecfg_h.append(commentWriterC.writerBanner("MutexDevice") 
								+indent1+ "#include \"system.h\"\n");
		            	sbeecfg_h.append(indent1+ "#define EE_ALTERA_MUTEX_BASE " + mutexDevice+"\n\n");
		            }

				}
				
			} else {
				Messages.sendWarningNl("Not found any "+key+"", null, "asdaksjdh", null);
			}
		}

		/** Common part (stored inside common.c of cpu0) */
		final StringBuffer sbCommon_c = answer[RTOS_ID___COMMON_DATA].get(FILE_EE_COMMON_C);
    	final ICommentWriter commentWriterC_common = getCommentWriter(oilObjects[RTOS_ID___COMMON_DATA], FileTypes.C);

		if (rtosNumber >0 && parent.checkKeyword(DEF__MSRP__)) {
			/*******************************************************************
			 * 
			 * SPIN LOCK
			 *  
			 ******************************************************************/

			sbCommon_c.append(commentWriterC_common.writerBanner("Spin locks") 
					+ "#include \"ee.h\"\n"
					+ parent.addCommonDataMacro(FILE_EE_COMMON_C));
			
			if (binaryDistr) {
				sbCommon_c.append("#ifndef " + MAX_CPU + "\n"
						+ "#define " + MAX_CPU + " "+ rtosNumber +"\n"
						+ "#endif\n\n");
			}
			
			sbCommon_c.append(indent1 + "/* There MUST be at least 1 spin for each mutex,\n"
					+ indent1 + " * +1 for each CPU if the notification mechanism is used. */\n");
	
			// search all globalResources
			Properties globalResources = new Properties();
			for (int rtosId = 0; rtosId < rtosNumber; rtosId++) {
				// all objects for current os
				IOilObjectList ool = oilObjects[rtosId];

				for (Iterator<ISimpleGenRes> iter = ool.getList(IOilObjectList.RESOURCE).iterator(); iter.hasNext(); ) {
					ISimpleGenRes res = (ISimpleGenRes) iter.next();
					
					if (res.containsProperty(ISimpleGenResKeywords.RESOURCE_GLOBAL) && 
							"true".equalsIgnoreCase(res.getString(ISimpleGenResKeywords.RESOURCE_GLOBAL))) {

						// NB : 
						//if (globalResources.containsKey(res.getString(SimpleGenResKeywords.RESOURCE_SYS_ID)) && 
						//		! res.getName().equals(globalResources.get(res.getString(SimpleGenResKeywords.RESOURCE_SYS_ID))) {
						//	throw new Error("!!!");
						//}
						
						globalResources.setProperty(res.getString(ISimpleGenResKeywords.RESOURCE_SYS_ID), res.getName());
					}
				}

				
			}

			// number of spinlock
			final int count = globalResources.size();
			
			// add a spin lock for each global resources
			String pre ="";
			String pre2 ="";
			String post="";
			StringBuffer sbSpinArrays = new StringBuffer();
			StringBuffer sbSpinStatusArray = new StringBuffer();
			StringBuffer sbSpinValuesArray = new StringBuffer();
			StringBuffer sbSpinShare = new StringBuffer();
			for (int i = 0; i<count; i++) {
			    String name = globalResources.getProperty("" + i);
			    sbSpinStatusArray.append(pre + post + indent2+"(EE_UINT32)(EE_hal_spin_value_"+name+")+1");
			    sbSpinValuesArray.append(pre2 + indent2+"EE_hal_spin_value_"+name);
			    sbSpinArrays.append(indent1+"extern EE_UINT32 EE_hal_spin_value_"+name+"["+MAX_CPU+"];\n");
			    sbSpinShare.append(indent1+"EE_UINT32 "+parent.sharedData("EE_hal_spin_value_"+name,"["+MAX_CPU+"]", Boolean.FALSE) + ";\n");

				pre = ",";
				pre2 = ",\n";
				post = "\t /* " + name + " */\n";
			}


			// add a spin lock for each cpu
			for (int rtosId=0; rtosId<rtosNumber; rtosId++) {
				// all objects for current os
				IOilObjectList ool = oilObjects[rtosId];
				String name = ErikaEnterpriseWriter.getOSName(ool);

			    sbSpinStatusArray.append(pre + post + indent2+"(EE_UINT32)(EE_hal_spin_value_"+name+")+1");
			    sbSpinValuesArray.append(pre2 + indent2+"EE_hal_spin_value_"+name);
			    sbSpinArrays.append(indent1+"extern EE_UINT32 EE_hal_spin_value_"+name+"["+MAX_CPU+"];\n");
			    sbSpinShare.append(indent1+"EE_UINT32 "+parent.sharedData("EE_hal_spin_value_"+name,"["+MAX_CPU+"]", Boolean.FALSE) + ";\n");

				pre = ",";
				pre2 = ",\n";
				post = "\t /* " + name + " */\n";
			}

			//if (parent.checkKeyword(DEF__NIOS2_SPIN_AVALON_MUTEX__)) {
			if (parent.checkKeyword(DEF___NIOS2_SPIN_AVALON_MUTEX_DIRECT__)) {
				sbCommon_c.append(indent2 + "// Mutex initialization, only in the case of avalon mutexes...\n" +
						indent1 + "#define RTD_MAX_SPIN_LOCK "+(count+rtosNumber)+"\n\n" +
						sbSpinArrays.toString() + "\n\n" +
						indent1 + "EE_UINT32 " +
						parent.sharedData("EE_hal_spin_status", "[RTD_MAX_SPIN_LOCK]", Boolean.FALSE) + " = {\n" +
						sbSpinStatusArray.toString() + " " + post +
						indent1 + "};\n\n" +
						sbSpinShare.toString() + "\n\n" +
						indent1 + "EE_UINT32 * const " +
						parent.sharedData("EE_hal_spin_value","[RTD_MAX_SPIN_LOCK]", Boolean.TRUE) + " = {\n" +
						sbSpinValuesArray.toString() + "\n" +
						indent1 + "};\n\n");
			}

		}
		

		{
			/*******************************************************************
			 * 
			 * Synchronization at startup
			 *  
			 ******************************************************************/
		    String value = parent.checkKeyword(Nios2Constants.DEF__NIOS2_SYNC_INIT_MUTEX__) ? "1" : "0"; 
		    
			sbCommon_c.append(commentWriterC_common.writerBanner("Synchronization at startup") +
					indent1 + "#if defined(__NIOS2_SPIN_AVALON_MUTEX_DIRECT__) && !defined(__NIOS2_NO_STARTUP_BARRIER__)\n" +
					indent2 + "volatile EE_UREG " + parent.sharedData("EE_startsynclocation", "", Boolean.FALSE)+";\n" +
					indent2 + "const EE_UREG " + parent.sharedData("EE_has_startup_barrier", "", Boolean.TRUE)+" = "+ value +";\n" +
					indent1 + "#endif\n\n");
			
		}
		return answer;
	}

	private String[] getStackSize(IOilObjectList ool, final String cpuName,
			String key) {
		String[] tmp = parent.getCpuDataValue(ool, key);
		if (tmp == null || tmp.length == 0 || tmp[0] == null)
			throw new RuntimeException("Expected " + key +" for cpu " + cpuName );
		return tmp;
	}

	/**
	 * This method makes some changes to computed Oil Object
	 */
	public void updateObjects() throws OilCodeWriterException {

		final IOilObjectList[] oilObjects = parent.getOilObjects();
		final int rtosNumber = oilObjects.length;

		for (int rtosId = 0; rtosId < rtosNumber; rtosId++) {
			

	        final IOilObjectList ool = oilObjects[rtosId];

			{
				/***********************************************************************
				 * 
				 * EE OPTS
				 * 
				 **********************************************************************/
				ArrayList<String> tmp = new ArrayList<String>();
				// store all older values (if there are)
				ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
				if (sgrCpu
						.containsProperty(ISimpleGenResKeywords.OS_CPU_EE_OPTS)) {
					String[] old = (String[]) sgrCpu
							.getObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS);
					tmp.addAll(Arrays.asList(old));
				}

				if (parent.checkKeyword(DEF___NIOS2_SPIN_AVALON_MUTEX_DIRECT__)) {
					tmp.add(DEF___NIOS2_SPIN_AVALON_MUTEX_DIRECT__);
				}
				sgrCpu.setObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS,
						(String[]) tmp.toArray(new String[tmp.size()]));

			}

			{
		        /*******************************************************************
	             * Search Nios Project Properties
	             ******************************************************************/
				ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
		        
		        String[] tmp = parent.getCpuDataValue(ool, "SYSTEM_LIBRARY_NAME");
		        if (tmp != null && tmp.length>0) {
		            sgrCpu.setProperty(Nios2Constants.SGRK__NIOS2_SYSTEM_LIBRARY__, tmp[0]);
		        }
	
		        tmp = parent.getCpuDataValue(ool, "SYSTEM_LIBRARY_PATH");
		        if (tmp != null && tmp.length>0) {
		            sgrCpu.setProperty(Nios2Constants.SGRK__NIOS2_SYSTEM_LIBRARY_PATH__, tmp[0]);
		        }
	        }
	        
		}
		
		
		{
			makefileContributions();
		}

	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.hidden.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter.IExtractKeywordsExtentions#updateKeywords(java.util.ArrayList)
	 */
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix) {
		
		if (!keywords.contains(IWritersKeywords.CPU_NIOSII)) {
			return;
		}

		/***********************************************************************
		 * 
		 * EE OPTS
		 *  
		 **********************************************************************/
		if (parent.getRtosSize() > 1) {

			// ---------- NIOS2_MUTEX_BASE ------------
			final String key = "NIOS2_MUTEX_BASE";
			
			HashMap<String, ArrayList<String>> map = parent.getRtosCommonAttributes(new String[] {key});
			ArrayList<String> values = (ArrayList<String>) map.get(key);
			if (values != null && values.size() == 1 && !keywords.contains(DEF___NIOS2_SPIN_AVALON_MUTEX_DIRECT__)) {
				keywords.add(DEF___NIOS2_SPIN_AVALON_MUTEX_DIRECT__);
			}
			

		    /*******************************************************************
             * NIOS MULTI CPU
             ******************************************************************/
			if (!keywords.contains(Nios2Constants.DEF__NIOS2_MULTICPU__)) {
				keywords.add(Nios2Constants.DEF__NIOS2_MULTICPU__);
//		        keywords.add(DEF__NIOS2_SPIN_AVALON_MUTEX__);
				keywords.add(Nios2Constants.DEF__NIOS2_IPIC_PIO__);
		        if (keywords.contains(DEF__EE_HAS_STARTUPSYNC__)) {
		        	keywords.add(Nios2Constants.DEF__NIOS2_SYNC_INIT_MUTEX__);
//		        	keywords.remove(DEF__OSEKOS_HAS_STARTUPSYNC__);
		        }
			}
		}

		
	}

	
	protected void makefileContributions() throws OilCodeWriterException {
		final IOilObjectList[] oilObjects = parent.getOilObjects();

		
        /*################################################################
         * COMMON MK 
         *###############################################################*/
		ISimpleGenRes masterSgrCpu = oilObjects[RTOS_ID___COMMON_DATA].getList(IOilObjectList.OS).get(0);
		final ICommentWriter commentWriterMf = getCommentWriter(oilObjects[RTOS_ID___COMMON_DATA], FileTypes.MAKEFILE);
		
		{
			/***********************************************************************
			 * CONTRIBUTION to VARIABLES in common.mk
			 ***********************************************************************/
			final String SYS_CONFIG = "NIOS2_SYS_CONFIG";
			final String APP_CONFIG = "NIOS2_APP_CONFIG";

			HashMap<String, ArrayList<String>> commonParameters = parent
					.getRtosCommonAttributes(new String[] { SYS_CONFIG,
							APP_CONFIG });

			if (!commonParameters.containsKey(APP_CONFIG)
					|| ((String) ((ArrayList<String>) commonParameters
							.get(APP_CONFIG)).get(0)).length() == 0) {
				throw new RuntimeException("Required a not empty " + APP_CONFIG);

			}

			if (!commonParameters.containsKey(SYS_CONFIG)
					|| ((String) ((ArrayList<String>) commonParameters
							.get(APP_CONFIG)).get(0)).length() == 0) {
				throw new RuntimeException("Required a not empty " + SYS_CONFIG);

			}

			final String PTF_PATH = "NIOS2_PTF_FILE";
			{
				String value = null;

	        	ArrayList<String> values = (ArrayList<String>) parent.getRtosCommonAttributes(new String[] {PTF_PATH}).get(PTF_PATH);

				if (values == null || values.size() == 0 ) {
					throw new OilCodeWriterException("OS/"+PTF_PATH+" is required");
					
				} else if (values.size() >1) {
					throw new OilCodeWriterException("OS/"+PTF_PATH+" is setted with different values");
					
				} else {
					value = (String) values.get(0);
					
					if (value.length() == 0) {
						throw new OilCodeWriterException("OS/"+PTF_PATH+" is empty");
					}
				}

			    commonParameters.put(PTF_PATH, values);
			}


			final String do_make_objdump_value;
			{
				final String DO_MAKE_OBJDUMP = "NIOS2_DO_MAKE_OBJDUMP";
				final String str_TRUE = "TRUE";
				final String str_FALSE = "FALSE";

				String[] values = parent
						.getRtosCommonChildType(DO_MAKE_OBJDUMP);
				if (values.length == 0) {
					do_make_objdump_value = "0"; // TODO: default value

				} else if (values.length > 1) {
					throw new OilCodeWriterException("OS/" + DO_MAKE_OBJDUMP
							+ " is setted with different values");

				} else if (str_TRUE.equals(values[0])) {
					do_make_objdump_value = "1";

				} else if (str_FALSE.equals(values[0])) {
					do_make_objdump_value = "0";

				} else {

					throw new OilCodeWriterException("Only " + str_TRUE
							+ " and " + str_FALSE + " are valid values for OS/"
							+ DO_MAKE_OBJDUMP + ".\n" + "\tFound " + values[0]);
				}
			}

			String value = "# Configuration for system library project\n"
					+ "SYS_CONFIG := "
					+ (String) ((ArrayList<String>) commonParameters
							.get(SYS_CONFIG)).get(0) + "\n"
					+ "DO_MAKE_OBJDUMP := " + do_make_objdump_value + "\n\n";

			value += "# Nios2 System Library: PTF file\n"
	                + "PTF := " + (String) ((ArrayList<String>) commonParameters
							.get(PTF_PATH)).get(0) + "\n\n";

			
			parent.default_output_prefix = (String) ((ArrayList<String>) commonParameters
					.get(APP_CONFIG)).get(0);

			CommonUtils.updateSgrProperty(masterSgrCpu,
					SGRK__COMMON_MAKEFILE_MP_EXT_VARS__, value);
		}

		{
			/***********************************************************************
			 * CONTRIBUTION  to the end of common.mk
			 ***********************************************************************/

			String value = commentWriterMf.writerBanner("Common mk file")+
				"include $(SOPC_KIT_NIOS2)/components/evidence_ee/build/ee_common.mk\n\n";
			CommonUtils.updateSgrProperty(masterSgrCpu, SGRK__COMMON_MAKEFILE_MP_EXT_EOF__, value);
		}
		

        /*################################################################
         * MAKEFILE 
         *###############################################################*/
		
        {
        	String ID = "NIOS2_JAM_FILE";
        	ArrayList<String> tmp = (ArrayList<String>) parent.getRtosCommonAttributes(new String[] {ID}).get(ID);
        	String niosJamFile = null;
        	if (tmp != null && tmp.size() >0) {
        		niosJamFile = (String) tmp.get(0);
        	}
        	if (niosJamFile != null) {
        		String value = "export EE_NIOS2_JAM_FILE := " + niosJamFile + "\n\n";
    			CommonUtils.updateSgrProperty(masterSgrCpu, SGRK__MAKEFILE_MP_EXT_VARS__, value);
        	}
        	
        	
        	CommonUtils.updateSgrProperty(masterSgrCpu, SGRK__MAKEFILE_MP_EXT_EOF__, 
        			commentWriterMf.writerBanner("Default mk file") +
    				"include $(SOPC_KIT_NIOS2)/components/evidence_ee/build/ee_global.mk\n\n");
        }


        /*################################################################
         * CPU.mk
         *###############################################################*/
		
		
		/***********************************************************************
         * Contribution for each Cpu
         **********************************************************************/
	    for (int rtosId=0; rtosId<oilObjects.length; rtosId++) {
	        final IOilObjectList ool = oilObjects[rtosId];
            final ISimpleGenRes sgrCpu = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);

		
		
	        // Variables
	        String value = "# RT_D: Referenced system library & location.\n"
	                + "SYSTEM_NAME := " + sgrCpu.getString(Nios2Constants.SGRK__NIOS2_SYSTEM_LIBRARY__) + "\n"
	                + "SYSTEM_DIR  := " + sgrCpu.getString(Nios2Constants.SGRK__NIOS2_SYSTEM_LIBRARY_PATH__) + "\n\n";
	        CommonUtils.updateSgrProperty(sgrCpu, SGRK__MAKEFILE_CPU_EXT_VARS__, value);
	        
	        
	        

	        {    // End of File
	        	StringBuffer tmp = new StringBuffer();
	            tmp.append("# Include makefile for the OS we are building on as specified in system library project\n"
		                    + "APP_MAKEFILE := $(SOPC_KIT_NIOS2)/components/evidence_ee/build/app.mk\n"
		                    + "include $(APP_MAKEFILE)\n\n");
	
	            // LINKER (Roules)
	            if (rtosId == 0) {
	            	tmp.append("# Include additional rules for the FIRST CPU\n" +
		                    "FIRSTCPU_MAKEFILE := $(SOPC_KIT_NIOS2)/components/evidence_ee/build/ee_firstcpu.mk\n" +
		                    "include $(FIRSTCPU_MAKEFILE)\n\n");
	            } else {
	            	tmp.append("# Include additional rules for CPUs != first CPU\n" +
		                    "OTHERCPU_MAKEFILE := $(SOPC_KIT_NIOS2)/components/evidence_ee/build/ee_othercpu.mk\n" +
	                    	"include $(OTHERCPU_MAKEFILE)\n\n");
	            }
	            
	            CommonUtils.updateSgrProperty(sgrCpu, SGRK__MAKEFILE_MP_CPU_EOF__, tmp.toString());
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
					{ IWritersKeywords.CPU_NIOSII, "__NIOS2__" },

					{ Nios2Constants.DEF__NIOS2_MULTICPU__, "__NIOS2_MULTICPU__" },
					{ Nios2Constants.DEF__NIOS2_IPIC_PIO__, "__NIOS2_IPIC_PIO__" },
//					{ DEF__NIOS2_SPIN_AVALON_MUTEX__, "__NIOS2_SPIN_AVALON_MUTEX__" },
//					{ DEF__NIOS2_SYNC_INIT_MUTEX__, "__NIOS2_SYNC_INIT_MUTEX__" },
				
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
