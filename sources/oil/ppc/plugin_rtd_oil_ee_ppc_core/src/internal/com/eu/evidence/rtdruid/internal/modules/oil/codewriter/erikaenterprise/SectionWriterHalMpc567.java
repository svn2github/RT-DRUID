/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterHalMico32.java,v 1.17 2008/02/05 10:15:18 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import static com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter.checkOrDefault;
import static com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter.getOsProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.eu.evidence.modules.oil.ppc.constants.PpcConstants;
import com.eu.evidence.rtdruid.desk.Messages;
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
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.SectionWriterIsr;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.SectionWriterIsr.ShareType;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.SectionWriterKernelCounterHw;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStackData;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStacks;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;

/**
 * This writer build files for a DS PIC CPU - Board
 * 
 * @author Nicola Serreli
 */
public class SectionWriterHalMpc567 extends SectionWriter 
	implements IEEWriterKeywords,
			IExtractObjectsExtentions,
			IExtractKeywordsExtentions {

	/**
	 * 
	 */
	public static final String MCU_MPC5668G = "MPC5668G";
	/**
	 * 
	 */
	public static final String MCU_MPC5674F = "MPC5674F";
	/**
	 * 
	 */
	public static final String MCU_MPC5643L = "MPC5643L";
	
	private static final String EE_E200ZX_SYSTEM_TIMER_HANDLER = "EE_e200zx_system_timer_handler";
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
	public static final String SGR_OS_CPU_LINKERSCRIPT = "sgr__os_cpu_linker_script";
	public static final String SGR_OS_MCU_LINKERSCRIPT = "sgr__os_mcu_linker_script";
	
	static final String SGR_OS_MCU_MODEL = "sgr__os_cpu__mcu_model";

	static final String STACK_BASE_NAME = "EE_stack_";
	private static final long DEFAULT_SYS_STACK_SIZE = 4096;

	public static final String SGR_OS_CPU_USER_COMPILER = "sgr__os_cpu_user_compiler";
	public static final String EEOPT_CODEWARRIOR = "__CODEWARRIOR__";
	public static final String EEOPT_DIAB = "__DIAB__";
	public static final String EEOPT_GNU = "EE_GNU__";
	
	enum CompilerType {
		diab, gnu, codewarrior
	};
	
	
	private final SectionWriterIsr isrWriter;
	private final SectionWriterKernelCounterHw counterHwWriter;
	
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
		
		isrWriter = new SectionWriterIsr(parent, IWritersKeywords.CPU_PPCE200ZX);
		counterHwWriter = new SectionWriterKernelCounterHw(parent, IWritersKeywords.CPU_PPCE200ZX, EE_E200ZX_SYSTEM_TIMER_HANDLER);
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
		
		{
			isrWriter.updateObjects();
			counterHwWriter.updateObjects();
		}

		final IOilObjectList[] oilObjects = parent.getOilObjects();
		
        LinkedHashSet<String> tmp_common_eeopts = new LinkedHashSet<String>();

        String mcu_linker_script = null;
        {
    		for (IOilObjectList ool : oilObjects) {

				/***********************************************************************
				 * get values
				 **********************************************************************/
				ArrayList<String> childPaths = new ArrayList<String>();
				List<String> childFound = parent.getRtosCommonChildType(ool, "MCU_DATA", childPaths);

				for (int index = 0; index<childFound.size(); index++) {
					String mcu_type = childFound.get(index);
					if (PPC_MCU.equals(mcu_type)) {
						String currentMcuPrefix = childPaths.get(index) + PARAMETER_LIST + "LINKERSCRIPT";
						String[] tmp1 = CommonUtils.getValue(vt, currentMcuPrefix);
						if (tmp1 != null && tmp1.length >0 && tmp1[0] != null) {
							mcu_linker_script = tmp1[0];
						}
					}
				}
    		}
        }
		
		for (int currentRtosId = 0; currentRtosId < oilObjects.length; currentRtosId++) {
			final IOilObjectList ool = oilObjects[currentRtosId];
			
			{
		        ArrayList<String> tmp_eeopts = new ArrayList<String>();
				
				/***********************************************************************
				 * 
				 * Get CPU model
				 *  
				 **********************************************************************/
				String hw_type = ErikaEnterpriseWriter.getOsProperty(ool, ISimpleGenResKeywords.OS_CPU_TYPE);
				if (hw_type != null) {
					if (IWritersKeywords.CPU_PPCE200Z0.equals(hw_type)) {
						tmp_eeopts.add("__PPCE200Z0__");
						
					} else if (IWritersKeywords.CPU_PPCE200Z4.equals(hw_type)) {
						tmp_eeopts.add("EE_PPCE200Z4");
						
					} else if (IWritersKeywords.CPU_PPCE200Z6.equals(hw_type)) {
						tmp_eeopts.add("__PPCE200Z6__");
						
					} else if (IWritersKeywords.CPU_PPCE200Z7.equals(hw_type)) {
						tmp_eeopts.add("__PPCE200Z7__");
					}
					
					tmp_common_eeopts.add("__PPCE200ZX__");
				}
			
				/***********************************************************************
				 * 
				 * EE OPTS
				 *  
				 **********************************************************************/
				{
					//List requiredOilObjects = (List) sgrCpu.getObject(SGRK__FORCE_ARRAYS_LIST__);
		
			        
			        // store all older values (if there are)
					ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
			        if (sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_EE_OPTS)) {
			        	String[] old = (String[]) sgrCpu.getObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS);
			        	tmp_eeopts.addAll(Arrays.asList(old));
			        }
			        

			        String vle = null;
					for (String currentCpuPrefix: AbstractRtosWriter.getOsProperties(ool, SGRK_OS_CPU_DATA_PREFIX)) {
						if (vle == null) {
							vle = CommonUtils.getFirstChildEnumType(vt, currentCpuPrefix+"VLE");
						}
					}

					if ("TRUE".equals(vle)
							|| (vle == null && hw_type == IWritersKeywords.CPU_PPCE200Z0)) {
						tmp_eeopts.add("__VLE__");
					} else if ("FALSE".equals(vle) && hw_type == IWritersKeywords.CPU_PPCE200Z0)  {
						throw new OilCodeWriterException("VLE should be enabled for ppc E200Z0.");
					}
	
		//	        tmp.add("__MPC5674F__");
		//	        tmp.add("__PPCE200Z7__");
//			        tmp_eeopts.add(EEOPT_DIAB);
					
					/***********************************************************************
					 * 
					 * Compiler
					 *  
					 **********************************************************************/
			        {
			        	
			        	String tmpCompiler = null;
			        	String tmp1 = null;
			        	String gnuExpFile = null;
			        	String[] childName = new String[1];
			    		for (String currentCpuPrefix: AbstractRtosWriter.getOsProperties(ool, SGRK_OS_CPU_DATA_PREFIX)) {
			    			String lPath = currentCpuPrefix + S + "COMPILER_TYPE";
			    			tmp1 = CommonUtils.getFirstChildEnumType(vt, lPath, childName);
			    			if (tmp1 != null &&
			    					("DIAB".equals(tmp1) || "GNU".equals(tmp1) || "CODEWARRIOR".equals(tmp1))
			    			) {
			    					if (tmpCompiler == null) {
					    				tmpCompiler = tmp1;
			    					} else {
			    						if (!tmpCompiler.equals(tmp1))
				    						Messages.sendErrorNl("Only one CompilerType is allowed. Found: " + tmpCompiler + " and " + tmp1 , null, "mpc_writer_model", null);
			    					}
			    			}
			    		}
			        	
						if (tmpCompiler == null) {
							tmp_eeopts.add(EEOPT_DIAB);
						} else if ("DIAB".equals(tmpCompiler)) {
							tmp_eeopts.add(EEOPT_DIAB);
						} else if ("GNU".equals(tmpCompiler)) {
							tmp_eeopts.add(EEOPT_GNU);
						} else if ("CODEWARRIOR".equals(tmpCompiler)) {
							tmp_eeopts.add(EEOPT_DIAB);
							tmp_eeopts.add(EEOPT_CODEWARRIOR);
						}

						sgrCpu.setObject(SGR_OS_CPU_USER_COMPILER, tmpCompiler);
			        }
					
			        
					
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
					String[] stack_size = parent.getCpuDataValue(ool, "SYS_STACK_SIZE");
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
							
							ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
							sgrCpu.setProperty(SGR_OS_CPU_SYS_STACK_SIZE, ""+value);
						}
						
					}

				}
				
				/***********************************************************************
				 * 
				 * CPU linker script
				 *  
				 **********************************************************************/
				{
					ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
					String[] cpu_linkerscript = parent.getCpuDataValue(ool, "LINKERSCRIPT");
					boolean linker = false;
					if (cpu_linkerscript != null && cpu_linkerscript.length>0 && cpu_linkerscript[0] != null) {
						sgrCpu.setProperty(SGR_OS_CPU_LINKERSCRIPT, ""+cpu_linkerscript[0]);
						linker = true;
					}
					if (mcu_linker_script != null) {
						sgrCpu.setProperty(SGR_OS_MCU_LINKERSCRIPT, ""+mcu_linker_script);
						linker = true;
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
			handleStacks(currentRtosId, ool);
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
	
	
			// ------------- Compute --------------------
	
			sbInithal_c.append("\n#include \"ee.h\"\n");
	
			/***********************************************************************
			 * SYSTEM STACK SIZE
			 **********************************************************************/
			sbInithal_h.append(indent1 + getCommentWriter(ool, FileTypes.H).writerSingleLineComment("System stack size") + 
						indent1 + "#define EE_SYS_STACK_SIZE     " + 
							( ErikaEnterpriseWriter.checkOrDefault(AbstractRtosWriter.getOsProperty(ool, SGR_OS_CPU_SYS_STACK_SIZE),
									DEFAULT_SYS_STACK_SIZE))
						+ "\n\n");
			
			
			/***********************************************************************
			 * OTHER STACKs
			 **********************************************************************/
			sbInithal_c.append(handleStacks(currentRtosId, ool));
			
	
			
			//  ------------- MORE FILES ---------------
			
			
			// isr
			isrWriter.writeIsr(oilObjects, currentRtosId, ool, cpuBuffs);
			counterHwWriter.writeCounterHw(currentRtosId, ool, cpuBuffs);
			
			// makefile
			prepareMakeFile(currentRtosId, ool);
		
		}
		
		return answer;
	}


	protected StringBuffer handleStacks(int currentRtosId, final IOilObjectList ool) throws OilCodeWriterException  {
		String stackType = parent.getStackType(); // MULTI or MONO
		StringBuffer sbInithal_c = new StringBuffer();

		if (getOsProperty(ool, SGRK_OS_CPU_DATA_PREFIX) == null) {
			return sbInithal_c;
		}
		final ICommentWriter commentWriterC = getCommentWriter(ool, FileTypes.C);
		
		List<ISimpleGenRes> taskNames = ool.getList(IOilObjectList.TASK);
		List<ISimpleGenRes> osApplications = ool.getList(IOilObjectList.OSAPPLICATION);
		boolean binaryDistr = parent.checkKeyword(IEEWriterKeywords.DEF__EE_USE_BINARY_DISTRIBUTION__);
		
		final String cpu_type = checkOrDefault(getOsProperty(ool, ISimpleGenResKeywords.OS_CPU_TYPE), PPC_MCU);
		final String mcu_type;
		{
			String tmp = getOsProperty(ool, SGR_OS_MCU_MODEL);
			mcu_type = tmp == null ? "" : " " + tmp;
		}

		/*
		 * Define a string for each MAX_OBJECT_NUMBER (OBJECT=task, RESOURCE, ...).
		 * Binary distribution uses the suffix RTD_. 
		 */
		final String MAX_TASK = (binaryDistr ? "RTD_" : "EE_") + "MAX_TASK";

		String pre = "";
		String post = "";
		final String indent = IWritersKeywords.INDENT;
		
		EEStackData sys_stack = new EEStackData(0,
				new long[] { Long.decode(checkOrDefault(getOsProperty(ool, SGR_OS_CPU_SYS_STACK_SIZE), "" + DEFAULT_SYS_STACK_SIZE))},
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
			final boolean usePragma = parent.checkPragma(currentRtosId);
			LinkedHashMap<String, StringBuffer> sbStackPragma = new LinkedHashMap<String, StringBuffer>();
//			StringBuffer stackPatternFill = new StringBuffer();
			
			sbInithal_c.append(commentWriterC
					.writerBanner("Stack definition for Freescale"+mcu_type+", PPC "+cpu_type.toLowerCase()));
			
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
			    	final String memId = memoryId[j];
//				    value  = (value + (value%STACK_UNIT)) / STACK_UNIT; // arrottondo a 2
					sbStackDeclSize.append(indent1 + "#define STACK_"+j+"_SIZE "+value+" " + commentWriterC.writerSingleLineComment("size = "+size[j][0]+" bytes"));
			    	
			    	final String decl = "static EE_STACK_T " +
							( usePragma ? "" :
								(memId == null ? "EE_STACK_ATTRIB " : "EE_STACK_ATTRIB_NAME("+memId+") ")
							) +
								STACK_BASE_NAME+j+"[EE_STACK_WLEN(STACK_"+j+"_SIZE)];\t/* "+descrStack[j]+" */";
			    	
				    if (usePragma) {
				    	addPragmaSections(sbStackPragma, decl, memId);
				    } else {
				    	sbStackDecl.append(indent1 + decl + "\n");
				    }
					
					// USED BY ORTI
					stackTmp.add(new EEStackData(j, new long[] {size[j][0]}, new long[] {size[j][0]},
							new String[] {" (int)(&"+STACK_BASE_NAME+j+")"}, true)); // DELTA
				}

				
				int tos_size = size.length - osApplications.size();
				
				// open system tos
				sbStack.append(indent
						+ "struct EE_TOS EE_e200z7_system_tos["+ErikaEnterpriseWriter.addVectorSizeDefine(ool, "EE_e200z7_system_tos", tos_size)
						+ "] = {\n");

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
						sbStackDeclSize.append(indent1 + "#define STACK_"+j+"_SIZE "+value+ " " + commentWriterC.writerSingleLineComment("size = "+irqSize[0]+" bytes"));
						
						final String decl = "static EE_STACK_T "+( usePragma ? "" : "EE_STACK_ATTRIB ")+STACK_BASE_NAME+j+"[EE_STACK_WLEN(STACK_"+j+"_SIZE)];\t/* irq stack */";
					    if (usePragma) {
					    	addPragmaSections(sbStackPragma, decl, null);
					    } else {
					    	sbStackDecl.append(indent1 + decl + "\n");
					    }

						sbStack
								.append(indent+"/* stack used only by IRQ handlers */\n"
										+ indent+"struct EE_TOS EE_e200z7_IRQ_tos = {\n"
										+ indent+indent+"(EE_ADDR)(&"+STACK_BASE_NAME+j+"[EE_STACK_INITP(STACK_"+j+"_SIZE)])\n" // DELTA
										+ indent+"};\n\n");
						
						// REQUIRED By ORTI's STACK
						int eesdID = stackTmp.size();
						stackTmp.add(new EEStackData(eesdID, new long[] {irqSize[0]}, new long[] {irqSize[0]},
								new String[] {" (int)(&"+STACK_BASE_NAME+j+")"}, true)); // DELTA

						ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
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
					ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
					sgrCpu.setObject(SGRK_OS_STACK_LIST, stackTmp.toArray(new EEStackData[0]));
					sgrCpu.setObject(SGRK_OS_STACK_VECTOR_NAME, "EE_e200z7_system_tos");
				}

			}		

			// add stack sizes
			sbInithal_c.append(sbStackDeclSize+"\n");

			//  add pragma sections
			closePragmaSections(sbStackPragma);
			for (StringBuffer buff: sbStackPragma.values()) {
				sbInithal_c.append(buff+"\n\n");
			}

			// add other stack declarations
			sbInithal_c.append(sbStackDecl + "\n" +
			        sbStack
//			        +stackPatternFill
			        );

		} else {
			
			ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
			sgrCpu.setObject(SGRK_OS_STACK_LIST, new EEStackData[] {sys_stack});
		}

		return sbInithal_c;
	}

	private void addPragmaSections(
			LinkedHashMap<String, StringBuffer> sbStackPragma, String stack_def,
			final String memId) {
		StringBuffer buff;
		if (sbStackPragma.containsKey(memId)) {
			buff = sbStackPragma.get(memId);
		} else {
			buff = new StringBuffer();
			sbStackPragma.put(memId, buff);
			if (memId == null) {
				buff.append("#pragma section PRAGMA_SECTION_BEGIN_SYS_STACK\n");
			} else {
				buff.append("#pragma section DATA \"ee_stack_"+memId+"\" \"ee_stack_"+memId+"\"\n");
			}
		}
		
		buff.append(indent1 + stack_def + "\n");
	}
	
	private void closePragmaSections(LinkedHashMap<String, StringBuffer> sbStackPragma){
		for (Entry<String, StringBuffer> entry : sbStackPragma.entrySet()) {
			String key = entry.getKey();
			if (key == null) {
				entry.getValue().append("#pragma section PRAGMA_SECTION_END_SYS_STACK\n");
			} else {
				entry.getValue().append("#pragma section DATA\n");
			}
		}
	}

	/*
	 * Parse and write the MCU Section
	 */
	private void checkMcu(LinkedHashSet<String> tmp_common_eeopts) throws OilCodeWriterException {
		
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		int z0 = 0;
		int z4 = 0;
		int z6 = 0;
		int z7 = 0;
		
		String mcu_model = null;
		
		for (IOilObjectList ool : oilObjects) {

			if (mcu_model == null) {
				mcu_model = getMcuType(parent.getVt(), ool);
			}
			
			{
				String hw_type = getOsProperty(ool, ISimpleGenResKeywords.OS_CPU_TYPE);

				if (IWritersKeywords.CPU_PPCE200Z0.equals(hw_type)) {
					z0++;
				} else if (IWritersKeywords.CPU_PPCE200Z4.equals(hw_type)) {
					z4++;
				} else if (IWritersKeywords.CPU_PPCE200Z6.equals(hw_type)) {
					z6++;
				} else if (IWritersKeywords.CPU_PPCE200Z7.equals(hw_type)) {
					z7++;
				} 

			}
		}
		
		String mcu_ee_opt = null;
		if (MCU_MPC5668G.equals(mcu_model)) {
			
			if (z0>1 || z6>1 || z4 >0 || z7 >0) {
				Messages.sendWarningNl("MPC5668G mcu supports not more than one z0 and not more than one z6");
			}
			mcu_ee_opt = "__MPC5668G__";
			
			updateSharedIntControllerPrio();
		} else if (MCU_MPC5674F.equals(mcu_model)) {
			
			if (z0>0 || z6>0 || z4 >0 || z7 !=1) {
				Messages.sendWarningNl("MPC5674F mcu supports only a single Z7 cpu");
			}
			mcu_ee_opt = "__MPC5674F__";
		} else if (MCU_MPC5643L.equals(mcu_model)) {
			
			if (z0>0 || z6>0 || z7 >0 || z4 > 2) {
				Messages.sendWarningNl("MPC5643L mcu supports one or two Z4 cpu");
			}
			mcu_ee_opt = "EE_MPC5643L";
			
		} else {
			Messages.sendWarningNl("Unsupported MCU");
		}
		
		if (mcu_ee_opt != null) {
			tmp_common_eeopts.add(mcu_ee_opt);				
		}

			
		if (mcu_model != null) {
			for (IOilObjectList ool: oilObjects) { 
				ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
				sgrCpu.setProperty(SGR_OS_MCU_MODEL, mcu_model);
			}
		}
	}

	/**
	 * @param mcu_model
	 * @param ool
	 * @return
	 */
	public static String getMcuType(IVarTree vt, IOilObjectList ool) {
		/***********************************************************************
		 * get values
		 **********************************************************************/
		String mcu_model = null;
		ArrayList<String> childPaths = new ArrayList<String>();
		List<String> childFound = ErikaEnterpriseWriter.getRtosCommonChildType(vt, ool, "MCU_DATA", childPaths);

		for (int index = 0; index<childFound.size(); index++) {
			if (mcu_model == null) {
				String mcu_type = childFound.get(index);
				
				if (PPC_MCU.equals(mcu_type)) {
					// ... and compete it 
					String currentMcuPrefix = childPaths.get(index) + PARAMETER_LIST + "MODEL";

					mcu_model = CommonUtils.getFirstChildEnumType(vt, currentMcuPrefix, null);
				}
				
			}
		}
		return mcu_model;
	}
	
	/**
	 * 
	 */
	private void updateSharedIntControllerPrio() {
		IOilObjectList[] oilObjects = parent.getOilObjects();
		if (oilObjects.length>1) {
			// NOTE: this code works with 2 cpu (z0 and z6)
			
			isrWriter.setSharedInterruptController(ShareType.CommonOnly);
			
			HashMap<String , BitSet> isrEntryLocation = new HashMap<String, BitSet>();
			HashMap<String , String> isrEntryPrio = new HashMap<String, String>();
			
			
			// get the location for all isr entries
			for (int index=0; index <oilObjects.length; index++) {
				for (ISimpleGenRes isr : oilObjects[index].getList(IOilObjectList.ISR)) {
					
					String id = isr.getString(ISimpleGenResKeywords.ISR_GENERATED_ENTRY);
					String prio = isr.getString(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_STRING);
					BitSet set;
					if (isrEntryLocation.containsKey(id)) {
						set = isrEntryLocation.get(id);
						
						String oldPrio = isrEntryPrio.get(id);
						if (oldPrio != null && oldPrio.equals(prio)==false) {
							 Messages.sendWarningNl("Isr " + id + " is shared but has different priorities. Use the master's one (" + oldPrio +")");
							 isr.setProperty(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_STRING, oldPrio);
						}
						
					} else {
						set = new BitSet();
						isrEntryLocation.put(id, set);
						isrEntryPrio.put(id, prio);
					}
					set.set(index);
				}
			}
			
			// get the mapping z0->indez, z6->index
			for (int index=0; index <oilObjects.length; index++) {
				for (ISimpleGenRes isr : oilObjects[index].getList(IOilObjectList.ISR)) {
					
					String id = isr.getString(ISimpleGenResKeywords.ISR_GENERATED_ENTRY);
					BitSet set = isrEntryLocation.get(id);
					String mask = null;
					if (set.get(0) && set.get(1)) {
						// both
						mask = "EE_RTDRUID_ISR_BOTH";
					} else if (set.get(0)) {
						// master
						mask = "EE_RTDRUID_ISR_MASTER";
					} else {
						// slave
						mask = "EE_RTDRUID_ISR_SLAVE";
					}
					
					if (mask!=null) {
						String prio = isr.getString(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_STRING);
						isr.setProperty(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_STRING, "("+prio+" | " + mask + ")");
					}
				}
			}
						
			
		}
	}

	/**
	 * MakeFile
	 */
	private void prepareMakeFile(final int currentRtosId, final IOilObjectList ool) {
		final ICommentWriter commentWriterMf = getCommentWriter(ool, FileTypes.MAKEFILE);
		final boolean multicore = parent.getOilObjects().length>1;
		
		final String cpu_type = checkOrDefault(getOsProperty(ool, ISimpleGenResKeywords.OS_CPU_TYPE), PPC_MCU);
		final String mcu_type;
		{
			String tmp = getOsProperty(ool, SGR_OS_MCU_MODEL);
			mcu_type = tmp == null ? "" : " " + tmp;
		}
		
		/***********************************************************************
         * 
         * MAKE FILE
         *  
         **********************************************************************/
		OsType wrapper = HostOsUtils.common.getTarget();

	    StringBuilder sbMakefile = new StringBuilder(commentWriterMf.writerBanner("Freescale"+mcu_type+", PPC "+cpu_type));
	    StringBuilder sbVariables = new StringBuilder();
//			StringBuilder sbCommon = new StringBuilder();
		    
		    {	// PATHs
	        	HashMap<String, ?> options = parent.getOptions();

	        	sbMakefile.append(CommonUtils.addMakefileDefinesInclude());
	        	if (!multicore) { 
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
			    	
			    	
			        sbMakefile.append(
			                "APPBASE := " + appBase + "\n" +
			                "OUTBASE := " + outputDir + "\n\n"
			        );
			    }
	        	{
	        		CompilerType type = CompilerType.diab;
	        		String userComp = getOsProperty(ool, SGR_OS_CPU_USER_COMPILER);
	        		
	        		if (userComp == null) {
	        			if (usingCodewarriorCompiler(currentRtosId))
	        				type = CompilerType.codewarrior;
	        		} else if ("CODEWARRIOR".equals(userComp)) {
	        			type = CompilerType.codewarrior;
	        		} else if ("GNU".equals(userComp)) {
	        			type = CompilerType.gnu;
	        		}
			        
					String compiler_define = "";
			        
			        String gcc = "";
	
			        switch (type) {
			        case codewarrior:
					        {
					    		gcc = PpcConstants.DEFAULT_PPC_CODEWARRIOR_CONF_CC;
						    	if (options.containsKey(PpcConstants.PREF_PPC_CODEWARRIOR_PATH) ) {
									String tmp = (String) options.get(PpcConstants.PREF_PPC_CODEWARRIOR_PATH);
									if (tmp.length()>0) gcc = tmp;
								}
					    		compiler_define = CommonUtils.compilerMakefileDefines(gcc, "PPC_CW_BASEDIR", wrapper);
					    	}
					        break;
					        
				    case gnu:
					        {
					    		gcc = PpcConstants.DEFAULT_PPC_GNU_CONF_GCC;
						    	if (options.containsKey(PpcConstants.PREF_PPC_GNU_PATH) ) {
									String tmp = (String) options.get(PpcConstants.PREF_PPC_GNU_PATH);
									if (tmp.length()>0) gcc = tmp;
								}
					    		compiler_define = CommonUtils.compilerMakefileDefines(gcc, "PPC_GNU_BASEDIR", wrapper);
					    	}
					        break;
			        
			        default:
			        case diab:
					        {
					        	if (options.containsKey(PpcConstants.PREF_PPC_DIAB_PATH) ) {
									gcc = (String) options.get(PpcConstants.PREF_PPC_DIAB_PATH);
								}
						    	compiler_define = CommonUtils.compilerMakefileDefines(gcc, "PPC_DIAB_BASEDIR", wrapper);
					    	}
					        break;
			        }
			        
			    	sbMakefile.append(compiler_define);
	        	}		        
		        
		        
		    }

			ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
	
			{ // linker script
				String link = null;
				if (sgrCpu.containsProperty(SGR_OS_CPU_LINKERSCRIPT)) {
					link = sgrCpu.getString(SGR_OS_CPU_LINKERSCRIPT);
				}
				if (link == null && sgrCpu.containsProperty(SGR_OS_MCU_LINKERSCRIPT)) {
					link = sgrCpu.getString(SGR_OS_MCU_LINKERSCRIPT);
				}
				
				if (link != null) {
					sbVariables.append("EE_LINKERSCRIPT := " + link+ "\n");
				}
				
			}

			if (multicore) {
				if (sgrCpu.containsProperty(SGRK__MAKEFILE_CPU_EXT_VARS__)) {
					sbMakefile.append(sgrCpu.getString(SGRK__MAKEFILE_CPU_EXT_VARS__));
				}
				sbMakefile.append("\n");
				sgrCpu.setProperty(SGRK__MAKEFILE_CPU_EXT_VARS__, sbMakefile.toString());
			} else {
				
				if (sgrCpu.containsProperty(SGRK__MAKEFILE_EXTENTIONS__)) {
					sbMakefile.append(sgrCpu.getString(SGRK__MAKEFILE_EXTENTIONS__));
				}
				sgrCpu.setProperty(SGRK__MAKEFILE_EXTENTIONS__, sbMakefile.toString());
			}

			if (sgrCpu.containsProperty(SGRK__MAKEFILE_CPU_EXT_VARS__)) {
				sbVariables.append(sgrCpu.getString(SGRK__MAKEFILE_CPU_EXT_VARS__));
			}
			sgrCpu.setProperty(SGRK__MAKEFILE_CPU_EXT_VARS__, sbVariables.toString());
	}
	

	private boolean usingCodewarriorCompiler(final int rtosId) {
		boolean found_codewarrior = false;
		for (String s : parent.extractEE_Opts(EE_OPT_USER_ONLY, rtosId)) {
			if (EEOPT_CODEWARRIOR.equals(s)) {
				found_codewarrior = true;
				break;
			}
		}

		return found_codewarrior;
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
