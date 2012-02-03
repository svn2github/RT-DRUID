/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterHalMico32.java,v 1.17 2008/02/05 10:15:18 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.eu.evidence.rtdruid.desk.Messages;
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
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EECpuDescriptionManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStackData;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStacks;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

/**
 * This writer build files for a DS PIC CPU - Board
 * 
 * @author Nicola Serreli
 */
public class SectionWriterHalMpc567 extends SectionWriter 
	implements IEEWriterKeywords,
			IExtractObjectsExtentions,
			IExtractKeywordsExtentions {

	final String indent1 = IWritersKeywords.INDENT;
	final String indent2 = indent1 + IWritersKeywords.INDENT;

	
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;
	
	/** All data */
	protected final IVarTree vt;

	static final String PPC_MCU = "PPCE200ZX";
	static final String ERR_CPU_TYPE = "Freescale PPC E200Zx";
	static final String SGR_OS_APPL_SHARED_STACK_ID = "sgr__os_application__shared_stack_id__integer";
	static final String SGR_OS_CPU_SYS_STACK_SIZE = "sgr__os_cpu_system_stack_size";
	
	static final String SGR_OS_MCU_MODEL = "sgr__os_cpu__mcu_model";

	static final String STACK_BASE_NAME = "EE_stack_";
	private static final long DEFAULT_SYS_STACK_SIZE = 4096;
	/**
	 * 
	 */
	public SectionWriterHalMpc567() {
		this(null);
	}
	
	/**
	 * 
	 */
	public SectionWriterHalMpc567(ErikaEnterpriseWriter parent) {
		super(IWritersKeywords.CPU_PPCE200ZX,
				new String[] {}, //
				new String[] { //
					IWritersKeywords.CPU_NIOSII,//
					IWritersKeywords.CPU_JANUS,//
					IWritersKeywords.CPU_MPC5xx,//
					IWritersKeywords.CPU_NIOSII, //
					IWritersKeywords.CPU_AVR5,
					IWritersKeywords.CPU_PIC_30
					},
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

		return writeEE_e200z7_CPU();
	}
	
	/**
	 * This method add new keywords enabled by this writer.
	 */
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix) {
		
	}

	/**
	 * This method makes some changes to computed Oil Object
	 * @throws OilCodeWriterException if some ISR's attribute is missing 
	 */
	public void updateObjects() throws OilCodeWriterException {

		final IOilObjectList[] oilObjects = parent.getOilObjects();
		
        LinkedHashSet<String> tmp_common_eeopts = new LinkedHashSet<String>();

		
		for (int currentRtosId = 0; currentRtosId < oilObjects.length; currentRtosId++) {
			final IOilObjectList ool = oilObjects[currentRtosId];
			final ISimpleGenRes sgrCpu = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
			
			if (sgrCpu.containsProperty(SGRK_OS_CPU_DATA_PREFIX)) {
				final String currentCpuPrefix = sgrCpu.getString(SGRK_OS_CPU_DATA_PREFIX);
	
		        ArrayList<String> tmp_eeopts = new ArrayList<String>();
				
				/***********************************************************************
				 * 
				 * Get CPU model
				 *  
				 **********************************************************************/
				String hw_type = null;
//				Utility.explodeOilVar(Utility.varTreeToStringErtd(vt))
				{
					String cpu_model = CommonUtils.getFirstChildEnumType(vt, currentCpuPrefix+"MODEL", null);
					if ("E200Z0".equals(cpu_model)) {
						tmp_eeopts.add("__PPCE200Z0__");
						hw_type = IWritersKeywords.CPU_PPCE200Z0;
						
					} else if ("E200Z6".equals(cpu_model)) {
						tmp_eeopts.add("__PPCE200Z6__");
						hw_type = IWritersKeywords.CPU_PPCE200Z6;
						
					} else if ("E200Z7".equals(cpu_model)) {
						tmp_eeopts.add("__PPCE200Z7__");
						hw_type = IWritersKeywords.CPU_PPCE200Z7;
						
					} else {
						Messages.sendError((cpu_model != null ? "Wrong" : "Missing") +
								" cpu model for PPC E200Zx family." +
								(cpu_model != null ? " Found " + cpu_model : ""), null, "", null);
					}
					
					if (hw_type != null) {
						sgrCpu.setProperty(ISimpleGenResKeywords.OS_CPU_TYPE, hw_type);
						
						CpuHwDescription cpuDescr = EECpuDescriptionManager.getHWDescription(hw_type);
						if (cpuDescr != null) {
							sgrCpu.setObject(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR, cpuDescr);
							sgrCpu.setObject(ISimpleGenResKeywords.OS_CPU_COMMENT_MANAGER, cpuDescr.commentManager);
						} else {
							sgrCpu.removeAProperty(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR);
						}
						
						tmp_common_eeopts.add("__PPCE200ZX__");
					}
				}
	
				/***********************************************************************
				 * 
				 * EE OPTS
				 *  
				 **********************************************************************/
				{
					//List requiredOilObjects = (List) sgrCpu.getObject(SGRK__FORCE_ARRAYS_LIST__);
		
			        
			        // store all older values (if there are)
			        if (sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_EE_OPTS)) {
			        	String[] old = (String[]) sgrCpu.getObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS);
			        	tmp_eeopts.addAll(Arrays.asList(old));
			        }
			        
					String vle = CommonUtils.getFirstChildEnumType(vt, currentCpuPrefix+"VLE");
					if ("TRUE".equals(vle)
							|| (vle == null && hw_type == IWritersKeywords.CPU_PPCE200Z0)) {
						tmp_eeopts.add("__VLE__");
					} else if ("FALSE".equals(vle) && hw_type == IWritersKeywords.CPU_PPCE200Z0)  {
						throw new OilCodeWriterException("VLE should be enabled for ppc E200Z0.");
					}
	
			
		//	        tmp.add("__MPC5674F__");
		//	        tmp.add("__PPCE200Z7__");
			        tmp_eeopts.add("__DIAB__");
			        
					
		//			{ STILL NOT IMPLEMENTED IN EE 
		//				if 	(ool.getList(IOilObjectList.ISR).size() > 0) {
		//					tmp.add(_EE_OPT_STATIC_ISR);
		//				}
		//
		//			}
		
					
					//  --------- board & mcu
		//			checkBoard(tmp);
		
					// store ee_opts
					sgrCpu.setObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS, tmp_eeopts.toArray(new String[tmp_eeopts.size()]));
				}
						
				/***********************************************************************
				 * 
				 * System stack size
				 *  
				 **********************************************************************/
				{
					String[] stack_size = CommonUtils.getValue(vt, currentCpuPrefix+"SYS_STACK_SIZE");
					if (stack_size != null && stack_size.length>0 && stack_size[0] != null) {
						
						boolean valid = false;
						int value = -1;
						try {
							value = Integer.decode(stack_size[0]);
							valid = true;
						} catch (NumberFormatException e) {
							Messages.sendWarningNl("Invalid value for System stack size : " + stack_size[0]);
						}
						
						if (valid && value <0) {
							Messages.sendWarningNl("System stack size cannot be negative (" + value + ")");
						} else {
							
							sgrCpu.setProperty(SGR_OS_CPU_SYS_STACK_SIZE, ""+value);
						}
						
					}

				}
			}
			
		}
		
		checkMcu(tmp_common_eeopts); // note that mcu must done after board 
	
		for (int currentRtosId = 0; currentRtosId < oilObjects.length; currentRtosId ++) { 
			IOilObjectList ool = oilObjects[currentRtosId];
			
			/* COMMON VARIABLES */
			ISimpleGenRes sgrCpu = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
			sgrCpu.setObject(ISimpleGenResKeywords.OS_CPU_COMMON_EE_OPTS, tmp_common_eeopts.toArray(new String[tmp_common_eeopts.size()]));			
			
			// updateStacks (needed by orti)... not the best solution....
			handleStacks(ool);
		}

	
	}
	
	/**
	 * Write configuration's files for Freescale MPC5674F, PPC E200Z7
	 * 
	 * @return buffers with configuration for Freescale MPC5674F, PPC E200Z7
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeEE_e200z7_CPU()
			throws OilCodeWriterException {

		final IOilObjectList[] oilObjects = parent.getOilObjects();		
		IOilWriterBuffer[] answer = new IOilWriterBuffer[oilObjects.length];

		final int rtosNumber = oilObjects.length;


		/***********************************************************************
		 * prepare and write buffers for All OS
		 **********************************************************************/
		for (int currentRtosId = 0; currentRtosId < rtosNumber; currentRtosId++) {
		
			IOilWriterBuffer cpuBuffs = new OilWriterBuffer();
			answer[currentRtosId] = cpuBuffs;
	
	
			// ------------- Requirement --------------------
			StringBuffer sbInithal_c = cpuBuffs.get(FILE_EE_CFG_C);
			StringBuffer sbInithal_h = cpuBuffs.get(FILE_EE_CFG_H);
			
			final IOilObjectList ool = oilObjects[currentRtosId];
			final ISimpleGenRes sgrCpu = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
	
	
			// ------------- Compute --------------------
	
			sbInithal_c.append("\n#include \"ee.h\"\n");
	
			/***********************************************************************
			 * SYSTEM STACK SIZE
			 **********************************************************************/
			sbInithal_h.append(indent1 + getCommentWriter(sgrCpu, FileTypes.H).writerSingleLineComment("System stack size") + 
						indent1 + "#define EE_SYS_STACK_SIZE     " + 
							( sgrCpu.containsProperty(SGR_OS_CPU_SYS_STACK_SIZE) ? 
									sgrCpu.getString(SGR_OS_CPU_SYS_STACK_SIZE) :
									DEFAULT_SYS_STACK_SIZE)
						+ "\n\n");
			
			
			/***********************************************************************
			 * OTHER STACKs
			 **********************************************************************/
			sbInithal_c.append(handleStacks(ool));
			
	
			
			//  ------------- MORE FILES ---------------
			
			
			// makefile
			prepareMakeFile(sgrCpu);
		
		}
		
		return answer;
	}


	protected StringBuffer handleStacks(final IOilObjectList ool) throws OilCodeWriterException  {
		String stackType = parent.getStackType(); // MULTI or MONO
		StringBuffer sbInithal_c = new StringBuffer();

		final ISimpleGenRes sgrCpu = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
		if (!sgrCpu.containsProperty(SGRK_OS_CPU_DATA_PREFIX)) {
			return sbInithal_c;
		}
		final String currentCpuPrefix = sgrCpu.getString(SGRK_OS_CPU_DATA_PREFIX);
		final ICommentWriter commentWriterC = getCommentWriter(sgrCpu, FileTypes.C);
		
		List<ISimpleGenRes> taskNames = ool.getList(IOilObjectList.TASK);
		List<ISimpleGenRes> osApplications = ool.getList(IOilObjectList.OSAPPLICATION);
		boolean binaryDistr = parent.checkKeyword(IEEWriterKeywords.DEF__EE_USE_BINARY_DISTRIBUTION__);
		
		final String cpu_type = sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_TYPE) ? sgrCpu.getString(ISimpleGenResKeywords.OS_CPU_TYPE) : PPC_MCU;
		final String mcu_type = sgrCpu.containsProperty(SGR_OS_MCU_MODEL) ? " " + sgrCpu.getString(SGR_OS_MCU_MODEL) : "";

		/*
		 * Define a string for each MAX_OBJECT_NUMBER (OBJECT=task, RESOURCE, ...).
		 * Binary distribution uses the suffix RTD_. 
		 */
		final String MAX_TASK = (binaryDistr ? "RTD_" : "EE_") + "MAX_TASK";

		String pre = "";
		String post = "";
		final String indent = IWritersKeywords.INDENT;
		
		EEStackData sys_stack = new EEStackData(0,
				new long[] { sgrCpu.containsProperty(SGR_OS_CPU_SYS_STACK_SIZE) ? 
						sgrCpu.getLong(SGR_OS_CPU_SYS_STACK_SIZE) : DEFAULT_SYS_STACK_SIZE},
				new long[] {0},
				new String[] {" (int)&EE_e200zx_sys_stack "}, true);

		
		/***********************************************************************
		 * MULTI STACK
		 **********************************************************************/
		if (DEF__MULTI_STACK__.equals(stackType)) {
			ArrayList<EEStackData> stackTmp = new ArrayList<EEStackData>();
//			final String DELTA = "-2";

			// ------------- Buffers --------------------
			/* A buffer about stack  */
			StringBuffer sbStack = new StringBuffer();

			/* A buffer about declarations of stacks  */
			StringBuffer sbStackDecl = new StringBuffer();
			StringBuffer sbStackDeclSize = new StringBuffer();
//			StringBuffer stackPatternFill = new StringBuffer();
			
			sbInithal_c.append(commentWriterC
					.writerBanner("Stack definition for Freescale"+mcu_type+", PPC "+cpu_type.toLowerCase()));
			
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
			//EEStacks elStack = new EEStacks(parent, ool, irqSize);
			EEStacks elStack = new EEStacks(parent, ool, null);
			elStack.setDummyStackPolicy(elStack.FORCE_ALWAYS | elStack.FORCE_FIRST);
			ArrayList<String> tList = new ArrayList<String>();
			ArrayList<String> tListN = new ArrayList<String>();

			// use a macro to ensure alignment
//			final int STACK_UNIT;
//			if (sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR)) {
//				CpuHwDescription currentStackDescription = (CpuHwDescription) sgrCpu.getObject(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR);
//				STACK_UNIT = currentStackDescription.stackSize;
//			} else {
//				STACK_UNIT = 4;
//			}
			
			 
			{
				/***************************************************************
				 * STACK FOR EACH TASK
				 **************************************************************/
				
				// add the dummy task
				tListN.add("");
				tList.add(IWritersKeywords.dummyName);
				
				// fill data for each task
				for (Iterator<ISimpleGenRes> iter = taskNames.iterator(); iter.hasNext();) {

					ISimpleGenRes sgr = (ISimpleGenRes) iter.next();
					tList.add(sgr.getName());
					tListN.add(sgr.getString(ISimpleGenResKeywords.TASK_SYS_ID));
				}

				// fill data for each shared stack, related to OS applications
				for (Iterator<ISimpleGenRes> iter = osApplications.iterator(); iter.hasNext();) {

					ISimpleGenRes sgr = (ISimpleGenRes) iter.next();
					tList.add(EEStacks.APPLICATION_SHARED_PREFIX+ sgr.getName());
					tListN.add(" ");

					tList.add(EEStacks.APPLICATION_IRQ_PREFIX+ sgr.getName());
					tListN.add("");
					
					sgr.setObject(SGR_OS_APPL_SHARED_STACK_ID, new Integer((tList.size()-1)));
					sgr.setObject(EEStacks.STACK_BASE_NAME_PREFIX, STACK_BASE_NAME);
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
				/* get the memory section id of each stack. */
				String memoryId[] = elStack.stackMemoryId(tList
						.toArray(new String[1]));
				
				/* descrStack contains a description for each stack. */ 
				String[] descrStack = new String[size.length];
				sbStack.append(indent
						+ "const EE_UREG EE_std_thread_tos["+MAX_TASK+"+1] = {\n");
				
			 // fill data for each shared stack, related to OS applications
				for (Iterator<ISimpleGenRes> iter = osApplications.iterator(); iter.hasNext();) {

					ISimpleGenRes sgr = (ISimpleGenRes) iter.next();
					Integer index = (Integer) sgr.getObject(SGR_OS_APPL_SHARED_STACK_ID);

					sgr.setProperty(ISimpleGenResKeywords.OS_APPL_SHARED_STACK_ID,"" + pos[index.intValue()]);
					
				}
					
				// DESCRIPTIONS
				
				for (int j = 0; j < pos.length; j++) {
					String stack_name = tList.get(j);
					if (!stack_name.startsWith(EEStacks.APPLICATION_SHARED_PREFIX) 
							&& !stack_name.startsWith(EEStacks.APPLICATION_IRQ_PREFIX)) {
						
						sbStack.append(pre + post + indent + indent + +pos[j]+"U");
						// set new values for "post" and "pre"
						post = " /* " + stack_name + "*/\n";
						pre = ",\t";
					}

					/*
					 * add the name of current task to the description of the /
					 * right stack. Check also if there is already something or
					 * not, infact in the second case append the new description
					 * to the old one
					 */ 
					final String tid;
					if (stack_name.startsWith(EEStacks.APPLICATION_SHARED_PREFIX)) {
						tid = "shared stack " +stack_name.substring(EEStacks.APPLICATION_SHARED_PREFIX.length()); 
					} else if (stack_name.startsWith(EEStacks.APPLICATION_IRQ_PREFIX)) {
						tid = "ISR stack for " +stack_name.substring(EEStacks.APPLICATION_IRQ_PREFIX.length()); 
					} else {
						tid = "Task " +tListN.get(j)+ " (" + stack_name + ")";
					}
					descrStack[pos[j]] = (descrStack[pos[j]] == null) ?
							// The first description
							(tid)
							:
							// other descriptions
							(descrStack[pos[j]] + ", " + tid); // others
				}

				// close sbStack
				sbStack.append(" \t" + post + indent + "};\n\n");

				pre = "";
				post = "";

				
				// USED BY ORTI
				stackTmp.add(sys_stack);
				

//				 DECLARE STACK SIZE && STACK (ARRAY)
				for (int j = 1; j < size.length; j++) {
				    long value = size[j][0];
//				    value  = (value + (value%STACK_UNIT)) / STACK_UNIT; // arrottondo a 2
					sbStackDecl.append(indent1 + "static EE_STACK_T " +
								(memoryId[j] == null ? "EE_STACK_ATTRIB" : "EE_STACK_ATTRIB_NAME("+memoryId[j]+")") +
								" "+STACK_BASE_NAME+j+"[EE_STACK_WLEN(STACK_"+j+"_SIZE)];\t/* "+descrStack[j]+" */\n");
					sbStackDeclSize.append(indent1 + "#define STACK_"+j+"_SIZE "+value+" " + commentWriterC.writerSingleLineComment("size = "+size[j][0]+" bytes"));
					
					// USED BY ORTI
					stackTmp.add(new EEStackData(j, new long[] {size[j][0]}, new long[] {size[j][0]},
							new String[] {" (int)(&"+STACK_BASE_NAME+j+")"}, true)); // DELTA
				}

				
				int tos_size = size.length - osApplications.size();
				
				// open system tos
				sbStack.append(indent
						+ "struct EE_TOS EE_e200z7_system_tos["
						+ (tos_size) + "] = {\n");

				/*
				 * For each stack prepare the configuration's vectors and
				 * descriptions
				 */
				for (int j = 0; j < tos_size; j++) {
				    
			        String value = j == 0 ? "{0}" : "{(EE_ADDR)(&"+STACK_BASE_NAME+j+"[EE_STACK_INITP(STACK_"+j+"_SIZE)])}"; // DELTA

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
						+ "EE_UREG EE_e200z7_active_tos = 0U; /* dummy */\n\n");

				{ // if required, init also the irq stack
					if (irqSize != null) {
					    int j = size.length;
					    long value = irqSize[0];
//					    value  = (value + (value%STACK_UNIT)) / STACK_UNIT; // arrottondo a 2
						sbStackDecl.append(indent1 + "static EE_STACK_T EE_STACK_ATTRIB "+STACK_BASE_NAME+j+"[EE_STACK_WLEN(STACK_"+j+"_SIZE)];\t/* irq stack */\n");
						sbStackDeclSize.append(indent1 + "#define STACK_"+j+"_SIZE "+value+ " " + commentWriterC.writerSingleLineComment("size = "+irqSize[0]+" bytes"));

						sbStack
								.append(indent+"/* stack used only by IRQ handlers */\n"
										+ indent+"struct EE_TOS EE_e200z7_IRQ_tos = {\n"
										+ indent+indent+"(EE_ADDR)(&"+STACK_BASE_NAME+j+"[EE_STACK_INITP(STACK_"+j+"_SIZE)])\n" // DELTA
										+ indent+"};\n\n");
						
						// REQUIRED By ORTI's STACK
						int eesdID = stackTmp.size();
						stackTmp.add(new EEStackData(eesdID, new long[] {irqSize[0]}, new long[] {irqSize[0]},
								new String[] {" (int)(&"+STACK_BASE_NAME+j+")"}, true)); // DELTA

						sgrCpu.setProperty(ISimpleGenResKeywords.OS_IRQ_STACK_ID, ""+eesdID);
					}
				}

				
//			    stackPatternFill.append("#endif\n");
				{// ORTI : Store link between task and stack
					int j = 1;
					for (Iterator<ISimpleGenRes> iter = taskNames.iterator(); iter.hasNext(); j++) {
						ISimpleGenRes sgr = iter.next();
						sgr.setObject(SGRK_TASK_STACK, stackTmp.get(pos[j]));
					}
					sgrCpu.setObject(SGRK_OS_STACK_LIST, stackTmp.toArray(new EEStackData[0]));
					sgrCpu.setObject(SGRK_OS_STACK_VECTOR_NAME, "EE_e200z7_system_tos");
				}

			}		

			//  add stack buffers
			sbInithal_c.append(sbStackDeclSize+"\n"+
			        sbStackDecl + "\n" +
			        sbStack
//			        +stackPatternFill
			        );
		} else {
			sgrCpu.setObject(SGRK_OS_STACK_LIST, new EEStackData[] {sys_stack});
		}

		return sbInithal_c;
	}
	
	/*
	 * Parse and write the MCU Section
	 */
	private void checkMcu(LinkedHashSet<String> tmp_common_eeopts) throws OilCodeWriterException {
		
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		int z0 = 0;
		int z6 = 0;
		int z7 = 0;
		
		String mcu_model = null;
		
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
				
				if (child.length >0 && PPC_MCU.equals(mcu_type)) {
					// ... and compete it 
					currentMcuPrefix += VARIANT_ELIST + child[0] + PARAMETER_LIST + "MODEL";
	
					mcu_model = CommonUtils.getFirstChildEnumType(vt, currentMcuPrefix, child);
				}
			}
			
			
			
			if (os.containsProperty(ISimpleGenResKeywords.OS_CPU_TYPE)) {
				String hw_type = os.getString(ISimpleGenResKeywords.OS_CPU_TYPE);

				if (IWritersKeywords.CPU_PPCE200Z0.equals(hw_type)) {
					z0++;
				} else if (IWritersKeywords.CPU_PPCE200Z6.equals(hw_type)) {
					z6++;
				} else if (IWritersKeywords.CPU_PPCE200Z7.equals(hw_type)) {
					z7++;
				} 

			}
		}
		
		String mcu_ee_opt = null;
		if ("MPC5668G".equals(mcu_model)) {
			
			if (z0>1 || z6>1 || z7 >0) {
				Messages.sendWarningNl("MPC5668G mcu supports not more than one z0 and not more than one z6");
			}
			mcu_ee_opt = "__MPC5668G__";
		} else if ("MPC5674F".equals(mcu_model)) {
			
			if (z0>0 || z6>0 || z7 !=1) {
				Messages.sendWarningNl("MPC5674F mcu supports only a single Z7 cpu");
			}
			mcu_ee_opt = "__MPC5674F__";
			
		} else {
			Messages.sendWarningNl("Unsupported MCU");
		}

			
		for (int currentRtosId = 0; currentRtosId < oilObjects.length; currentRtosId ++) { 
			
			/* COMMON VARIABLES */
			ISimpleGenRes sgrCpu = (ISimpleGenRes) oilObjects[currentRtosId].getList(IOilObjectList.OS).get(0);

			if (mcu_ee_opt != null) {
				tmp_common_eeopts.add(mcu_ee_opt);				
			}
			
			if (mcu_model != null)
				sgrCpu.setProperty(SGR_OS_MCU_MODEL, mcu_model);
		}
	}
	
	void prepareMakeFile(ISimpleGenRes sgrCpu) {
		final ICommentWriter commentWriterMf = getCommentWriter(sgrCpu, FileTypes.MAKEFILE);
		
		
		final String cpu_type = sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_TYPE) ? sgrCpu.getString(ISimpleGenResKeywords.OS_CPU_TYPE) : PPC_MCU;
		final String mcu_type = sgrCpu.containsProperty(SGR_OS_MCU_MODEL) ? " " + sgrCpu.getString(SGR_OS_MCU_MODEL) : "";
		
		/***********************************************************************
         * 
         * MAKE FILE
         *  
         **********************************************************************/
			HostOsUtils wrapper = HostOsUtils.common;

		    StringBuffer sbMakefile_variables = new StringBuffer(commentWriterMf.writerBanner("Freescale"+mcu_type+", PPC "+cpu_type));
		    
		    {	// PATHs
	        	HashMap<String, ?> options = parent.getOptions();

		        String outputDir = "Debug";
		        String appBase = "..";
		        
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
		    	
		    	
		        sbMakefile_variables.append(
		                "APPBASE := " + appBase + "\n" +
		                "OUTBASE := " + outputDir + "\n\n"
		                
		        );
		    }

            sgrCpu.setProperty(SGRK__MAKEFILE_EXTENTIONS__, sbMakefile_variables.toString());

	}

	
	/**
	 * This metod takes an array and returns the first element, or null if the
	 * array is a zero-length array or if the first element is empty ("" or
	 * null)
	 */
	static String clean(String[] arr) {
		String answer = null;
		if (arr != null && arr.length>0) {
			if (arr[0].trim().length()>0) {
				answer= arr[0].trim();
			}
		}
		return answer;
	}

}
