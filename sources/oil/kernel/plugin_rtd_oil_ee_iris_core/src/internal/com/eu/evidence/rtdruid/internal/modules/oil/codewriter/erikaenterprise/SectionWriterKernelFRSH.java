/*
 * Created on 26-jun-2008
 *
 * $Id: SectionWriterKernelFRSH.java,v 1.3 2008/09/15 14:07:12 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import static com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter.getOsObject;
import static com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter.getOsProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.eu.evidence.rtdruid.desk.Messages;
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
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuUtility;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStacks;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IRemoteNotificationsConstants;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilObjectType;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

/**
 * This writer build files for a Frescor Kernel
 * 
 * @author Nicola Serreli
 */
public class SectionWriterKernelFRSH extends SectionWriter implements
		IEEWriterKeywords, IExtractObjectsExtentions {
	
	/** Contains details of a contract */
	public static class Contract {
		final String name;
		final long budget;
		final long period;
		final String cpu_id;
		
		public Contract(String name, long budget, long period, String cpu_id) {
			this.name = name;
			this.budget = budget;
			this.period = period;
			this.cpu_id = cpu_id;
		}
	}

	/** Contains details of a contract */
	public static class FrshTimer {
		protected final boolean single;
		protected String t_irq;
		protected String t_irq_budget;
		protected String t_irq_recharge;
		protected String t_irq_dl_check;
		protected String t_irq_sem;

		public FrshTimer(String name) {
			this.single = true;
			this.t_irq = name;
		}
		
		public FrshTimer(String budget, String recharge, String dl_check, String sem) {
			this.single = false;
			this.t_irq_budget = budget;
			this.t_irq_recharge = recharge;
			this.t_irq_dl_check = dl_check;
			this.t_irq_sem = sem;
		}
		
		public boolean isSingle() {
			return single;
		}
		
		public String getT_irq() {
			return t_irq;
		}
		
		public String getT_irq_budget() {
			return t_irq_budget;
		}
		
		public String getT_irq_dl_check() {
			return t_irq_dl_check;
		}
		
		public String getT_irq_recharge() {
			return t_irq_recharge;
		}
		
		public String getT_irq_sem() {
			return t_irq_sem;
		}
	}
	
	/** Identifies the list of contracts for a frescor kernel (inside OS objects) */
	final static String FRSH_OS_CONTRACT_LIST = "frescor_os_contract_list";
	/** Identifies the type of IRQ (simple or multiple) with its parameters (type FrshTimer) */
	final static String FRSH_CPU_TIMER = "frescor_cpu_timer";
	/** Identifies the free running timer (type String) */
	final static String FRSH_CPU_FREE_TIMER = "frescor_cpu_free_timer";
	/**
	 * Identifies the reference to a contract for a task, scheduled with a frescor
	 * kernel (inside TASK objects)
	 */
	/** Map contract/task */
	final static String FRSH_TASK_CONTRACT_REF = "frescor_task_contract_ref";

	/** Identifies the list of contracts for a frescor kernel (inside OS objects) */
	final static String FRSH_OS_USE_SYNC_OBJ = "frescor_os_use_synch_objects";
	/** Interval between timer increment */
	final static String FRSH_OS_TICK_TIME = "frescor_os_tick_time";
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;
	
	public SectionWriterKernelFRSH() {
		this(null);
	}
	/**
	 * 
	 */
	public SectionWriterKernelFRSH(ErikaEnterpriseWriter parent) {
		super(IWritersKeywords.FRSH,
				new String[] {}, //
				new String[] { //
					IWritersKeywords.OSEK_BCC1, //
					IWritersKeywords.OSEK_BCC2, //
					IWritersKeywords.OSEK_ECC1, //
					IWritersKeywords.OSEK_ECC2, //
					IWritersKeywords.SRPT, //
					IWritersKeywords.FP, //
					IWritersKeywords.CBS, //
					IWritersKeywords.EDF, //
					IWritersKeywords.IRIS, //
				},
				SWCategoryManager.defaultInstance.newCategory(SWCategoryManager.TYPE_KERNEL));
		
		this.parent = parent;
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
		
		/*
		 * Call some function to prepare many structures
		 * Task properties, Counter properties, Resources ...
		 */
		// computeAutoStart(); called inside INIT()

		// prepare all files with common kernel definition like MAX_TASK,
		// MAX_RESOURCE, Alarm, Event ID, ...
		ArrayList<IOilWriterBuffer> tmp = new ArrayList<IOilWriterBuffer>();
//		ErikaEnterpriseWriter.appendBuffers(tmp, parent.writeCommonKernelDefines());
		ErikaEnterpriseWriter.appendBuffers(tmp, writeFRSH_Kernel());

		return (IOilWriterBuffer[]) tmp.toArray(new OilWriterBuffer[tmp.size()]);
	}


	/**
	 * Write Configuration's file for an FP Kernel
	 *
	 * @return buffers with configuration for an FP Kernel
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeFRSH_Kernel()
			throws OilCodeWriterException {
//return new OilWriterBuffer[0];
		
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		final IOilWriterBuffer[] answer = new IOilWriterBuffer[oilObjects.length];
		
		
		// check if this a binary distribution
		boolean binaryDistr = parent.checkKeyword(IEEWriterKeywords.DEF__EE_USE_BINARY_DISTRIBUTION__);
		/*
		 * Define a string for each MAX_OBJECT_NUMBER (OBJECT=task, RESOURCE, ...).
		 * Binary distribution uses the suffix RTD_. 
		 */
		final String MAX_ALARM = (binaryDistr ? "RTD_" : "EE_") + "MAX_ALARM";
		//final String MAX_APPMODE = (binaryDistr ? "RTD_" : "EE_") + "MAX_APPMODE";
		final String MAX_COUNTER = (binaryDistr ? "RTD_" : "EE_") + "MAX_COUNTER";
		final String MAX_TASK = (binaryDistr ? "RTD_" : "EE_") + "MAX_TASK";
		final String MAX_RESOURCE = (binaryDistr ? "RTD_" : "EE_") + "MAX_RESOURCE";
		final String MAX_CONTRACT = (binaryDistr ? "RTD_" : "EE_") + "MAX_CONTRACT";
		
		
		/* indentxxx contains some white spaces for indent the output */
		final String indent1 = IWritersKeywords.INDENT;
		final String indent2 = indent1 + IWritersKeywords.INDENT;
		//final String indent3 = indent2 + IWritersKeywords.INDENT;
		//final String indent4 = indent3 + WritersKeys.INDENT;
		
		
		// number of rtos
		final int rtosNumber = oilObjects.length;
	    boolean enable_rn = false; 

		// usw thw cpu type of first cpu (all cpus have the same type) 
		CpuHwDescription currentStackDescription = ErikaEnterpriseWriter.getCpuHwDescription(oilObjects[0]);

		/*
		 * Extract the max number of distrinct Priorities for current HW.
		 * 
		 * The default value is 32 priorities.
		 */
		final int MaxPriorityLevels;
		if (currentStackDescription != null) { 
			MaxPriorityLevels = currentStackDescription.prioSize;
		} else {
			MaxPriorityLevels = 32;
		}

		
		/***********************************************************************
		 * prepare and write buffers for All OS
		 **********************************************************************/
		for (int rtosId = 0; rtosId < rtosNumber; rtosId++) {
			answer[rtosId] = new OilWriterBuffer();
		
			// ------------------ common data ------------------
		
			// all objects for current os
			IOilObjectList ool = oilObjects[rtosId];
			// current os
			List requiredOilObjects = (List) getOsObject(ool, SGRK__FORCE_ARRAYS_LIST__);
			final ICommentWriter commentWriterC = getCommentWriter(ool, FileTypes.C);
			final ICommentWriter commentWriterH = getCommentWriter(ool, FileTypes.H);

			{
			    BitSet rn_set = (BitSet) getOsObject(ool, IRemoteNotificationsConstants.DEF__RN_BITS__);
			    enable_rn = rn_set == null ? false : rn_set.cardinality() > 0;
			}

		
			StringBuffer buffer = answer[rtosId].get(FILE_EE_CFG_C);
			StringBuffer buffer_ee_h = answer[rtosId].get(FILE_EE_CFG_H);

			Map<String,Contract> contracts = (Map<String,Contract>) getOsObject(ool, FRSH_OS_CONTRACT_LIST);
			// required for contracts taskname field
			Map<String, String> contract2task = new HashMap<String, String>();
			{
				List<ISimpleGenRes> tl = ool.getList(IOilObjectList.TASK);
				for (Iterator<ISimpleGenRes> iter = tl.iterator(); iter.hasNext();) {
					ISimpleGenRes currTask = (ISimpleGenRes)iter.next();
					contract2task.put((String)currTask.getString(FRSH_TASK_CONTRACT_REF), (String)currTask.getName());
				}
			}
			
			// ---------------------------------------------------
			
			buffer.append(
					"#include \"ee.h\"\n"
					+ commentWriterC.writerBanner("Kernel ( CPU " + rtosId
							+ " )"));
		
			StringBuffer contractsBuffer = new StringBuffer(
					commentWriterC.writerBanner("Contracts"));
			
			{// Contracts

				String pre = "";
				String post = "";
				//String pre2 = "";

				// 
				contractsBuffer.append("\n" + indent1 + commentWriterC.writerSingleLineComment("Contracts") // */\n" +
						+ indent1 + "const EE_TYPECONTRACTSTRUCT EE_ct["+MAX_CONTRACT+"] = {\n");

				final StringBuffer eecfgh_buffer = answer[rtosId].get(FILE_EE_CFG_H);
				eecfgh_buffer.append("\n" + indent1 + commentWriterH.writerSingleLineComment("Contracts") //\n" 
						+ indent1 + "#define " + MAX_CONTRACT + " "+ contracts.size() +"\n");

//				final StringBuffer EE_frsh_contract_label = new StringBuffer();
//				EE_frsh_contract_label.append(indent1 + 
//						"const char *EE_frsh_contract_label[" + MAX_CONTRACT + "] = {");

				final StringBuffer ee_vres = new StringBuffer(commentWriterC.writerBanner("VRes"));
				ee_vres.append("\n" + indent1 + "EE_TYPEVRESSTRUCT EE_vres[" + MAX_CONTRACT + "] = {\n");

//				final StringBuffer ee_th = new StringBuffer();
//				ee_th.append("EE_TYPETASKSTRUCT EE_th[EE_MAX_TASK] = {\n");

				int index = 0;
				for (Contract c : contracts.values()) {
					
					String budget = "0x" + Long.toHexString(c.budget);
					String period = "0x" + Long.toHexString(c.period);
					
					contractsBuffer.append(pre + post + indent2
							+ "{" + budget + ", " + period + ", " + period + "/" + budget +"}");
					
					eecfgh_buffer.append(indent1 + "#define " +c.name+ " " + index + "\n");
//					EE_frsh_contract_label.append(pre + "\n" + indent2 + "\"" + c.name+ "\"");
					{ //get mapped task to current contract
						String tname = (String)contract2task.get((String)c.name);
						if (tname == null || tname.length() == 0)
							tname = "EE_NIL";
						ee_vres.append(pre + post + indent2 + "{ 0, 0, 0, EE_VRES_FREEZED, " + tname + " }");
					}
					//pre2 = "\n";
					pre = ",";
					post = "\t\t" + commentWriterC.writerSingleLineComment("Contract " + c.name); // + " */\n";
					
					// update index
					index++;
				}
				
				contractsBuffer.append(" " + post + indent1 + "};\n\n");

//				EE_frsh_contract_label.append(" \n" + indent1 + "};\n\n");
			
				ee_vres.append(" " + post + indent1 + "};\n\n");
			
//				contractsBuffer.append(EE_frsh_contract_label);
				contractsBuffer.append(ee_vres);
			}
		
//			// Preemption level == ready priority of each task (one row for each task)
//			StringBuffer EE_th_prlevelBuffer = new StringBuffer(
//					indent1 + commentWriterC.writerSingleLineComment("Task Preempiton Levels") + //\n" +
//					indent1 + "const EE_TYPERELDLINE EE_th_prlevel["+MAX_TASK+"] = {\n");
//
//			// Budget of each task (one row for each task)
//			StringBuffer EE_th_budgetBuffer = new StringBuffer(
//					indent1 + commentWriterC.writerSingleLineComment("Mean Execution Time of each task") + //\n" +
//					indent1 + "EE_TYPECAPACITY EE_th_budget["+MAX_TASK+"] = {\n");
//
//			// Runtime available Budget of each task (one row for each task)
//			StringBuffer EE_th_runtimebudgetBuffer = new StringBuffer(
//					indent1 + commentWriterC.writerSingleLineComment("(Runtime) Available budget of each task") + //\n" +
//					indent1 + "EE_TYPECAPACITY EE_th_budget_avail["+MAX_TASK+"] = {\n");
//			
//			// Period of each task (one row for each task)
//			StringBuffer EE_th_periodBuffer = new StringBuffer(
//					indent1 + commentWriterC.writerSingleLineComment("Replenishment period of each task") + //\n" +
//					indent1 + "EE_TYPERELDLINE EE_th_period["+MAX_TASK+"] = {\n");
//
//			// Inv. of Utilization of each task (one row for each task)
//			StringBuffer EE_th_inv_proc_utilBuffer = new StringBuffer(
//					indent1 + commentWriterC.writerSingleLineComment("Inverse processor utilization of each task") + //\n" +
//					indent1 + "EE_TYPERELDLINE EE_inv_proc_util["+MAX_TASK+"] = {\n");

//			StringBuffer EE_th_dispatch_prioBuffer = new StringBuffer(
//					indent1 + commentWriterC.writerSingleLineComment("dispatch priority") + //\n" +
//					indent1 + "const EE_TYPEPRIO EE_th_dispatch_prio["+MAX_TASK+"] = {\n");

//			// buffer for th_status
//			StringBuffer EE_th_statusBuffer = new StringBuffer(indent1
//					+ "EE_TYPEPRIO EE_th_status["+MAX_TASK+"] = {\n");

//			// buffer for th_rnact (one row for each task)
//			StringBuffer EE_th_nactBuffer = new StringBuffer(indent1
////					+ "EE_TYPEPRIO EE_th_nact["+MAX_TASK+"] = {\n");
//					+ "EE_TYPEPRIO EE_th_nact["+MAX_TASK+"];\n");
			
//			// buffer for th_rnact (one row for each task)
//			StringBuffer EE_th_nextBuffer = new StringBuffer(indent1
//					+ "EE_TYPEPRIO EE_th_next["+MAX_TASK+"] = {\n");

		
			/* Contains task's address */
//			StringBuffer sbThread = new StringBuffer();
			/* Contains task's declarations */
			StringBuffer sbDecThread = new StringBuffer();
			/* Contains task's stubs */
			StringBuffer sbStub = new StringBuffer();
		
			final StringBuffer ee_th = new StringBuffer();
			ee_th.append("\n" + indent1 + "EE_TYPETASKSTRUCT EE_th[" + MAX_TASK + "] = {\n");

			// ------------------ fill buffers ------------------
		
			//int activaction_TOT = 0;
			int numTask = 0;
		
			String pre = "";
			String post = "";
			String pre2 = "";
		
			{
		
				// for each task, prepare some buffer with its declaration and address
				List<ISimpleGenRes> taskList = ool.getList(IOilObjectList.TASK);
		
				/***************************************************************
				 * DECLARE TASKs AND GET THEIR DATA
				 **************************************************************/
				for (Iterator<ISimpleGenRes> iter = taskList.iterator(); iter.hasNext();) {
		
					ISimpleGenRes currTask = (ISimpleGenRes) iter.next();
					String tname = currTask.getName();
		
					/*
					 * READY_PRIORITY.
					 * 
					 * prio contains the priority of current task (as a String).
					 * 
					 * priorityLevel identifies the priority level (each
					 * priority is a distinct bit)
					 */
					int id = currTask
							.getInt(ISimpleGenResKeywords.TASK_READY_PRIORITY);
					String prio = "0x"
							+ (Integer.toHexString(id)).toUpperCase();
					int priorityLevel = -1;
					for (int k = 0; k < MaxPriorityLevels; k++) {
						if (id == 1 << k) {
							priorityLevel = k;
							break;
						}
					}
		
					// ususaly only if there're more than "MaxPriorityLevels" differents priority levels
					if (priorityLevel == -1) {
						throw new OilCodeWriterException("Not valid priority (Max "+MaxPriorityLevels+" distinct priorities)"
								+ "\n\tPriority : " + prio 
								+ "\n\tTask     : " + currTask.getName());
					}
		
					/*
					 * DISPATCH_PRIORITY.
					 * 
					 * dspPrio contains the dispatch Priority as a String
					 */
//					id = currTask
//							.getInt(ISimpleGenResKeywords.TASK_DISPATCH_PRIORITY);
//					String dspPrio = "0x"
//							+ (Integer.toHexString(id)).toUpperCase();
		

					/*
					 * Contract.
					 * 
					 * contract contains the contract related to current task.
					 * The check of existence of related contract is done inside updateObject function
					 */
					Contract c = contracts.get(currTask.getString(FRSH_TASK_CONTRACT_REF));
					

					/*
					 * --------------- WRITE VALUES ---------------
					 * 
					 * Append the correct value to all buffers
					 */
//					EE_th_prlevelBuffer.append(pre + post + indent2 + prio);
//					EE_th_dispatch_prioBuffer.append(pre + post + indent2
//							+ dspPrio);
					//EE_th_nactBuffer.append(pre + post + indent2 + "0");
		
					sbDecThread.append(pre2 + indent1 + "DeclareTask(" + tname + ");");
					
//					EE_th_budgetBuffer.append(pre + post + indent2 + "0x" + Long.toHexString(c.budget));
//					EE_th_runtimebudgetBuffer.append(pre + post + indent2 + "0");
//					EE_th_periodBuffer.append(pre + post + indent2 + "0x" + Long.toHexString(c.period));
//					EE_th_inv_proc_utilBuffer.append(pre + post + indent2+ "0x" + Long.toHexString(c.period) + "/" + "0x" + Long.toHexString(c.budget));
//					sbThread.append(pre + pre2 + indent2 + "(EE_ADDR)Func"
//							+ tname);
					sbStub.append(pre + post + indent2
							+ "Func" + tname);
					pre2 = "\n";
		
					ee_th.append(indent2 + "{ " + prio + ", EE_TASK_SUSPENDED, EE_NIL, 0, 0, ");
					ee_th.append(c.name + ", EE_VRES_NIL },\n");

					pre = ",";
					post = "\t\t" + commentWriterC.writerSingleLineComment("thread " + tname); // + " */\n";
		
					numTask++;
				}
			}
		
			/* Complete all buffers */
//			EE_th_prlevelBuffer.append(" " + post + indent1 + "};\n\n");
//			EE_th_dispatch_prioBuffer.append(" " + post + indent1 + "};\n\n");
			//EE_th_nactBuffer.append(post + indent1 + "};\n\n");
//			EE_th_budgetBuffer.append(" " + post + indent1 + "};\n\n");
//			EE_th_runtimebudgetBuffer.append(" " + post + indent1 + "};\n\n");
//			EE_th_periodBuffer.append(" " + post + indent1 + "};\n\n");
//			EE_th_inv_proc_utilBuffer.append(" " + post + indent1 + "};\n\n");
			sbStub.append(" " + post);
		
			ee_th.append(indent1 + "};\n\n");
			
			/*******************************************************************
			 * WRITE BUFFERS
			 ******************************************************************/
		
			// declare task and theirs address
			buffer.append(indent1 + commentWriterC.writerSingleLineComment("Definition of task's body") //\n"
				+ sbDecThread + "\n\n"
				+ contractsBuffer // Contracts
				+ commentWriterC.writerBanner("Tasks")
				+ ee_th
				+ indent1 + "const EE_THREAD_PTR EE_hal_thread_body["+MAX_TASK+"] = {\n"
				+ sbStub
				+ indent1 + "};\n\n");
//				+ indent1 + "EE_UINT32 EE_terminate_data["+MAX_TASK+"];\n\n"
//				+ indent1 + commentWriterC.writerSingleLineComment("ip of each thread body (ROM)) // */\n"
//				+ indent1 + "const EE_FADDR EE_terminate_real_th_body["+MAX_TASK+"] = {\n"
//				+ sbThread.toString() + "\n"
//				+ indent1 + "};\n");
		

//			buffer.append(contractsBuffer); // ADD Contracts
//			buffer.append(EE_th_prlevelBuffer);
//
//			buffer.append(EE_th_budgetBuffer);
//			buffer.append(EE_th_runtimebudgetBuffer);
//			buffer.append(EE_th_periodBuffer);
//			buffer.append(EE_th_inv_proc_utilBuffer);
//			buffer.append(EE_th_dispatch_prioBuffer);
			
			buffer.append(
//					indent1 + commentWriterC.writerSingleLineComment("Stores if a task is waiting on a mutex") //\n"
//					+ indent1 +"EE_UREG EE_th_lockedcounter["+MAX_TASK+"];\n\n"
//					
//					+ indent1 + commentWriterC.writerSingleLineComment("Stores if a task is active or not") //\n"
//					+ indent1 +"EE_UREG EE_th_active["+MAX_TASK+"];\n\n"
//					
//					+ indent1 + commentWriterC.writerSingleLineComment("Task absolute deadline") //\n"
//					+ indent1 +"EE_TYPEABSDLINE EE_th_absdline["+MAX_TASK+"];\n\n"
					
					//+
					indent1 +commentWriterC.writerSingleLineComment("The first recharging task") //\n"
					+ indent1 +"EE_TYPECONTRACT EE_rcgfirst = EE_VRES_NIL;\n\n"

					+ indent1 +commentWriterC.writerSingleLineComment("The running task") //\n"
					+ indent1 +"EE_TID EE_exec = EE_NIL;\n\n"
					
					+ indent1 +commentWriterC.writerSingleLineComment("Required for capacity accounting") //\n"
					+ indent1 +"EE_TIME EE_last_time;\n\n");
			
			/*
			 * EE_th_status
			 */
//			buffer.append(indent1 + commentWriterC.writerSingleLineComment("thread status")); //\n");
//		
//			buffer.append(indent1 + "#if defined(__MULTI__) || defined(__WITH_STATUS__)\n" +
//					indent2 + "EE_TYPESTATUS EE_th_status["+MAX_TASK+"] = {\n");
//			pre2 = "";
//			for (int i = 0; i < numTask; i++) {
//				buffer.append(pre2 + indent3 + "EE_READY");
//				pre2 = ",\n";
//			}
//			buffer.append("\n" + indent2 + "};\n" +
//					indent1 + "#endif\n\n");
//		
//			/*
//			 * EE_th_next
//			 */
//			buffer.append(indent1 + commentWriterC.writerSingleLineComment("next thread") //\n"
//					+ indent1 + "EE_TID EE_th_next["+MAX_TASK+"] = {\n");
//			pre2 = "";
//			for (int i = 0; i < numTask; i++) {
//				buffer.append(pre2 + indent2 + "EE_NIL");
//				pre2 = ",\n";
//			}
//			buffer.append("\n" + indent1 + "};\n\n");
		
//			buffer.append(EE_th_nactBuffer);
			/*
			 * EE_stkfirst && EE_rqfirst
			 */
			buffer.append(indent1 + commentWriterC.writerSingleLineComment("The first stacked task") + //\n" +
					indent1 + "EE_TID EE_stkfirst = EE_NIL;\n\n" +
					indent1 + commentWriterC.writerSingleLineComment("The first task into the ready queue") + //\n" +
					indent1 + "EE_TID EE_rqfirst  = EE_NIL;\n\n");
			/*
			 * EE_sys_ceiling
			 */
			buffer.append(indent1 + commentWriterC.writerSingleLineComment("system ceiling") //\n"
					+ indent1 + "EE_TYPEPRIO EE_sys_ceiling= 0x0000U;\n\n");
			

			{
				/***************************************************************
				 * MUTEX
				 **************************************************************/
				List<ISimpleGenRes> mutexList = ool.getList(IOilObjectList.RESOURCE);
				if (mutexList.size() > 0 || requiredOilObjects.contains(new Integer(IOilObjectList.RESOURCE))) {
					
					final int maxMutex = parent.computeMaxResource(mutexList);
		
					buffer.append(commentWriterC.writerBanner("Mutex"));
		
					/*
					 * EE_resource_ceiling
					 */
					buffer.append(
							indent1 + "const EE_TYPEPRIO EE_resource_ceiling["+MAX_RESOURCE+"]= {\n");
		
					// search all ceilings and order them
					String[] names = new String[maxMutex];
					String[] ceilings = new String[maxMutex];
					for (Iterator<ISimpleGenRes> iter = mutexList.iterator(); iter
							.hasNext();) {
		
						ISimpleGenRes curr = (ISimpleGenRes) iter.next();
		
						int id = curr.getInt(ISimpleGenResKeywords.RESOURCE_SYS_ID);
						
						ceilings[id] = "0x"
								+ (Integer.toHexString(
										curr.getInt(ISimpleGenResKeywords.RESOURCE_CEILING)))
										.toUpperCase()+"U";
						names[id]  = curr.getName();
					}
					
					
					
					
					/*
					 * RES_SCHEDULER
					 */
					pre2 = "";
					post = "";
					for (int j = 0; j < maxMutex; j++) {
		
						final String name;
						final String ceiling;
						if (ceilings[j] != null) {
							name = names[j];
							ceiling = ceilings[j];
						} else {
							name = "UNUSED";
							ceiling = "0U";
						}
						
						buffer.append(pre2 + post + indent2 + ceiling);
						post = "\t\t" + commentWriterC.writerSingleLineComment("resource " + name); // + " */\n";
						pre2 = ",";
					}
					buffer.append(" " + post + indent1 + "};\n\n");

					
					// OLD ceiling
					buffer.append(indent1 + commentWriterC.writerSingleLineComment("old mutex ceiling") //\n"
							+ indent1 + "EE_TYPEPRIO EE_resource_oldceiling["+MAX_RESOURCE+"];\n\n");
		
				} // end "if (mutexList.size()>0)"
			}
			
			{
				/***************************************************************
				 * FRESCOR SEMAPHORES 
				 **************************************************************/
				
				if (Boolean.TRUE.equals(getOsObject(ool, FRSH_OS_USE_SYNC_OBJ)) ) {
					
					buffer.append(commentWriterC.writerBanner("FRESCOR SYNCHRONIZATION OBJECTS") + 
							indent1 + "EE_TYPETIMEOUTSTRUCT EE_frsh_timeout["+MAX_TASK+"];\n\n"+
							indent1 + "EE_TID EE_frsh_timeout_first = EE_NIL;\n\n");		
					
				}
			}
			{
				/***************************************************************
				 * COUNTERS
				 **************************************************************/
		
				List<ISimpleGenRes> counterList = ool.getList(IOilObjectList.COUNTER);
		
				if (counterList.size() > 0 || requiredOilObjects.contains(new Integer(IOilObjectList.COUNTER))) {
					buffer.append(commentWriterC.writerBanner("Counters"));
		
					/*
					 * EE_counter_RAM
					 */
					buffer
							.append(indent1+"EE_counter_RAM_type       EE_counter_RAM["+MAX_COUNTER+"] = {");
					pre2 = "\n";
					post = "";
		
					for (Iterator<ISimpleGenRes> iter = counterList.iterator(); iter.hasNext();) {
		
						// ------ GET VALUES -----
						ISimpleGenRes curr = (ISimpleGenRes) iter.next();
		
//						String maxAllowed = curr.getString(ISimpleGenResKeywords.COUNTER_MAX_ALLOWED);
//						String ticks = curr.getString(ISimpleGenResKeywords.COUNTER_TICKS);
//						String minCycle = curr.getString(ISimpleGenResKeywords.COUNTER_MIN_CYCLE);
		
						// ------ WRITE BUFFER -----
		
						buffer.append(pre2 + post + indent2+"{0, -1}");
						pre2 = ",";
						post = indent2 + commentWriterC.writerSingleLineComment(curr.getName()); // + "*/\n";
					}
					buffer.append(" " + post +indent1+ "};\n\n");
		
				}
			}
			{
				/***************************************************************
				 * ALARMS
				 **************************************************************/
		
				List<ISimpleGenRes> alarmList = ool.getList(IOilObjectList.ALARM);
		
				if (alarmList.size() > 0 || requiredOilObjects.contains(new Integer(IOilObjectList.ALARM))) {
					buffer.append(commentWriterC.writerBanner("Alarms"));
		
					/*
					 * Call back functions
					 */
					List<String> callback_functions = new LinkedList<String>();
					/*
					 * EE_alarm_ROM
					 */
					StringBuffer romBuffer = new StringBuffer(indent1
									+ "const EE_alarm_ROM_type   EE_alarm_ROM["+ErikaEnterpriseWriter.addVectorSizeDefine(ool, "EE_alarm_ROM", alarmList.size())+"] = {\n");
		
					boolean withEvents = false; // default for FP
		
					pre2 = "";
					for (Iterator<ISimpleGenRes> iter = alarmList.iterator(); iter.hasNext();) {
		
						ISimpleGenRes curr = (ISimpleGenRes) iter.next();
		
						// set all values for each alarm
						int counter_id = -1;
						String callBackName = "NULL";
						//int task_id = 0;
						String task_al_name = "0"; // default value
						String evento = "0";
						String notif_type = "";
		
						// prepare all data
		
						{ // ----- GET VALUES -----
							String coun_Al_Name = curr.getString(ISimpleGenResKeywords.ALARM_COUNTER); 
		
							//search counter
							List<ISimpleGenRes> counterList = ool
									.getList(IOilObjectList.COUNTER);
							for (Iterator<ISimpleGenRes> countIter = counterList.iterator(); countIter
									.hasNext();) {
								ISimpleGenRes counter = (ISimpleGenRes) countIter
										.next();
		
								if (coun_Al_Name.equals(counter.getName())) {
									counter_id = counter
											.getInt(ISimpleGenResKeywords.COUNTER_SYS_ID);
									break;
								}
							}
							if (counter_id == -1) {
								throw new RuntimeException(
										"Alarm : Wrong counter name for this Alarm."
												+ " (Alarm = " + curr.getName()
												+ ", counter = " + coun_Al_Name
												+ ")");
							}
		
							final String tipo = curr.getString(ISimpleGenResKeywords.ALARM_ACTION_TYPE);
		
							/*
							 * these are the different types of alarm
							 * notifications...
							 * 
							 * #define EE_ALARM_ACTION_TASK 0
							 * #define EE_ALARM_ACTION_CALLBACK 1
							 * #define EE_ALARM_ACTION_EVENT 2
							 */
							if (tipo.equals(ISimpleGenResKeywords.ALARM_ACTIVATE_TASK)) {
								task_al_name = curr.getString(ISimpleGenResKeywords.ALARM_ACTIVATE_TASK);
								
								/* Check the task name */
								boolean notFound = true; 
								//search task id
								for (int cpuId = 0; cpuId < oilObjects.length
										&& notFound; cpuId++) {
		
									List<ISimpleGenRes> list = oilObjects[cpuId].getList(IOilObjectList.TASK);
									for (Iterator<ISimpleGenRes> ii = list.iterator(); ii
											.hasNext()
											&& notFound;) {
										ISimpleGenRes sgr = (ISimpleGenRes) ii
												.next();
		
										notFound = !task_al_name.equals(sgr.getName());
									}
								}
								if (notFound) {
									throw new RuntimeException(
											"Alarm : Wrong task name for Alarm "
													+ curr.getName()
													+ " ( task name = "
													+ task_al_name + ")");
								}
		
								
								/*
								 * some row later, if the associated task is
								 * EXTENDED, the notify_type is set as event
								 * instead task.
								 */
								notif_type = "EE_ALARM_ACTION_TASK    ";
								
							} else if (tipo.equals(ISimpleGenResKeywords.ALARM_SET_EVENT)) {
								String[] tmp = (String[]) curr.getObject(ISimpleGenResKeywords.ALARM_SET_EVENT);
								task_al_name = tmp[0];
								evento = tmp[1];
		
								// check for event name
								boolean found = false;
								List<ISimpleGenRes> list = ool.getList(IOilObjectList.EVENT);
								for (Iterator<ISimpleGenRes> ii = list.iterator(); ii
										.hasNext()
										&& !found;) {
									ISimpleGenRes sgr = (ISimpleGenRes) ii.next();
		
									found = evento.equals(sgr.getName());
								}
		
								if (!found)
									throw new RuntimeException(
											"Alarm : Not found given event for this alarm"
													+ " (Alarm = "
													+ curr.getName()
													+ ", event = " + evento
													+ ")");
		
								notif_type = "EE_ALARM_ACTION_EVENT   ";
								
							} else if (tipo.equals(ISimpleGenResKeywords.ALARM_CALL_BACK)) {
								callBackName = curr.getString(ISimpleGenResKeywords.ALARM_CALL_BACK);
								
								if (!callback_functions.contains(callBackName)) {
									callback_functions.add(callBackName);
								}
								
								notif_type = "EE_ALARM_ACTION_CALLBACK";
								
							} else {
								throw new Error("Unknow type");
							}
						}
		
						// write
						romBuffer.append(pre2 + indent2 + "{" + counter_id + ", "
								+ notif_type + ", " + task_al_name
								+ (withEvents ? ", " + evento : "") + ", "
								+ callBackName + "}");
						pre2 = ",\n";
					}
					romBuffer.append("\n"+indent1 + "};\n\n");
		
					// add functions
					if (callback_functions.size()>0) {
						buffer.append(indent1 + "// Functions\n");
						for (Iterator<String> iter = callback_functions.iterator(); iter.hasNext(); ) {
							buffer.append(indent1 + "void " + iter.next()+ "(void);\n");
						}
						buffer.append("\n");
					}
					// add ROM
					buffer.append(romBuffer.toString());
					/*
					 * EE_alarm_RAM
					 */
					buffer.append(indent1
							+ "EE_alarm_RAM_type         EE_alarm_RAM["
							+ MAX_ALARM + "];");/* = {");
					pre = "\n";
					for (int i = 0; i < alarmList.size() - 1; i++) {
						buffer.append(pre+indent2+"{0,0,0,-1}");
						pre = ",\n";
					}
					buffer.append("\n"+indent1+"};\n\n");
					*/
					buffer.append("\n\n");
				}
			}
		
		
			{ // TIMERS
				final boolean cpu_timers = getOsObject(ool, FRSH_CPU_TIMER) != null;
				final boolean free_run   = getOsObject(ool, FRSH_CPU_FREE_TIMER) != null;

				if (cpu_timers || free_run ) {
					buffer_ee_h.append(commentWriterC.writerBanner("FRSH Timers"));
				}
				if (free_run) { // TIMERS
					String free = getOsProperty(ool, FRSH_CPU_FREE_TIMER);
					buffer_ee_h.append(
							indent1 + "#define TIMER_SYSTEM_BASE "  + free + "_BASE\n\n"); 
				}
				if (cpu_timers) { // TIMERS
					FrshTimer timer = (FrshTimer) getOsObject(ool, FRSH_CPU_TIMER);
					Boolean useSem = (Boolean) getOsObject(ool, FRSH_OS_USE_SYNC_OBJ);
					
					if (timer.isSingle()) {
						buffer_ee_h.append(
								indent1 + "#define TIMER_COMMON_BASE "  + timer.getT_irq() + "_BASE\n" + 
								indent1 + "#define TIMER_COMMON_IRQ  "  + timer.getT_irq() + "_IRQ\n"
						);

					} else {
						
						buffer_ee_h.append(
								indent1 + "#define TIMER_CAPACITY_BASE "  + timer.getT_irq_budget() + "_BASE\n" + 
								indent1 + "#define TIMER_CAPACITY_IRQ  "  + timer.getT_irq_budget() + "_IRQ\n\n" +
								
								indent1 + "#define TIMER_RECHARGING_BASE "  + timer.getT_irq_recharge() + "_BASE\n" + 
								indent1 + "#define TIMER_RECHARGING_IRQ  "  + timer.getT_irq_recharge() + "_IRQ\n\n" +
								
								indent1 + "#define TIMER_DLCHECK_BASE "  + timer.getT_irq_dl_check() + "_BASE\n" + 
								indent1 + "#define TIMER_DLCHECK_IRQ  "  + timer.getT_irq_dl_check() + "_IRQ\n\n" + 
								
								(useSem != null && useSem.booleanValue() ? 
									indent1 + "#define TIMER_SYNCHOBJ_BASE "  + timer.getT_irq_sem() + "_BASE\n" + 
									indent1 + "#define TIMER_SYNCHOBJ_IRQ  "  + timer.getT_irq_sem() + "_IRQ\n\n"
									: ""
								)
						);
					}
				}
	}
		}

	
		if (enable_rn) {
			
        	final ICommentWriter commentWriterC = getCommentWriter(oilObjects[0], FileTypes.C);

			
			final String MAX_RN = (binaryDistr ? "RTD_" : "EE_") + "MAX_RN";
			
			StringBuffer sbCommon_c = answer[0].get(FILE_EE_COMMON_C);
			sbCommon_c.append(commentWriterC.writerBanner("FRSH Remote Notification")
					+ indent1 + "EE_TYPECONTRACT "+
					parent.sharedData("EE_rn_vres","["+MAX_RN+"][2]", Boolean.FALSE) + ";\n\n"
				);	
		}
		
	
		return answer;
	}
	
	public void updateObjects() throws OilCodeWriterException{
		if (!parent.checkKeyword(IWritersKeywords.FRSH)) {
			return;
		}
		
//		//final TimeVar ticsLength; 
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		final IVarTree vt = parent.getVt();
//		final int currentRtosId = 0;
//		final IOilObjectList ool = oilObjects[currentRtosId];
//		final ISimpleGenRes sgrOs = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
		Boolean use_sync_objs = null;

		//LinkedHashMap<String, Contract> contracts = new LinkedHashMap<String, Contract>();
		Map<String, Contract> contracts = new LinkedHashMap<String, Contract>();

		boolean found_kernel = false;
		TimeVar tv_tick_time = null;


		// Prepare an HashMap for each cpu
		HashMap<String, Map<String,Contract>> cpuContracts = new HashMap<String, Map<String,Contract>>();
		for (int currentRtosId=0; currentRtosId<oilObjects.length; currentRtosId++) {// search the RTOS 
			final IOilObjectList ool = oilObjects[currentRtosId];
			final String t_cpuid = ErikaEnterpriseWriter.getOSName(ool);
			LinkedHashMap<String,Contract> map = new LinkedHashMap<String,Contract>();
			cpuContracts.put(t_cpuid, map);
			// store the map as a property of the OS
			{
				ISimpleGenRes sgrOs = ool.getList(IOilObjectList.OS).get(0);
				sgrOs.setObject(FRSH_OS_CONTRACT_LIST, map);
			}

		
			// SEARCH Tick Time
		
			// check only the first RTOS !!! (as rtos of CPU0)
			ArrayList<String> childPaths = new ArrayList<String>();
			List<String> childFound = parent.getRtosCommonChildType(ool, "KERNEL_TYPE", childPaths);
			String kernel_type = childFound.isEmpty() ? null : childFound.get(0);

			if (kernel_type != null && "FRSH".equals(kernel_type)) {
				
				found_kernel = true;
				TimeVar tmp_tick_time = null;
				
				{//read TICK_TIME
					final String param = "TICK_TIME";
					String dl_option_prefix = childPaths.get(0) + PARAMETER_LIST + param;
					String[] tmpType = CommonUtils.getValue(vt, dl_option_prefix);
					if (tmpType != null) {
						if (tmpType.length == 1) {
							final String str_val = tmpType[0];
							if (str_val != null) {
								try {
									tmp_tick_time = new TimeVar(str_val);
								} catch(Exception e) {}
							}
						}
					}
					if (tmp_tick_time != null) {
						
						if (tv_tick_time != null) {
							throw new OilCodeWriterException("Found two times TICK_TIME.");
						}
						
						double t = ((Double)tmp_tick_time.get()).doubleValue();
						if (t <= 0) {
							throw new OilCodeWriterException("TICK_TIME invalid in kernel FRSH: must be positive.");
						}
					}
				}
			
			}
		}

		for (int currentRtosId=0; currentRtosId<oilObjects.length; currentRtosId++) {// search the RTOS 
			/***********************************************************************
			 * 
			 * CONTRACTS
			 *  
			 **********************************************************************/
	
			final IOilObjectList ool = oilObjects[currentRtosId];
			
			
			double tick_time = -1; 			
			if (tv_tick_time != null) {
				final ISimpleGenRes sgrOs = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
				sgrOs.setObject(FRSH_OS_TICK_TIME, (TimeVar)tv_tick_time);
				tick_time = ((Double)tv_tick_time.get()).doubleValue();
			}

			
			ArrayList<String> childPaths = new ArrayList<String>();
			List<String> childFound = parent.getRtosCommonChildType(ool, "KERNEL_TYPE", childPaths);
			String kernel_type = childFound.isEmpty() ? null : childFound.get(0);
			
			if (kernel_type != null && "FRSH".equals(kernel_type)) {
	
				found_kernel = true;

				{	// DEADLINES
					
					final String param = "USE_SYNC_OBJ";
					
					String dl_option_prefix = childPaths.get(0) + PARAMETER_LIST + param;
					
					ArrayList<String> tmpType = CommonUtils.getAllChildrenEnumType(vt, dl_option_prefix, null);
					
					//use_semaphores = false; // default value
					if (tmpType != null) {
						if (tmpType.size()==1) {
							if (use_sync_objs != null) {
								if ( !(""+use_sync_objs).equalsIgnoreCase((String)(tmpType.get(0)))) {
									Messages.sendWarning("Found more than one value for " + param, null, null, null);
								}
							} else {
								if ("true".equalsIgnoreCase((String)(tmpType.get(0)))) {
									use_sync_objs = Boolean.TRUE;
								} else {
									use_sync_objs = Boolean.FALSE;
								}
							}
						} else if (tmpType.size()>1) {
							Messages.sendWarning("Found more than one value for " + param, null, null, null);
						}
					}
					
//					sgrOs.setObject(FRSH_OS_USE_SEM,
//									use_semaphores ? Boolean.TRUE : Boolean.FALSE);
				}
				{ // CONTRACTs
				
					String contract_prefix = childPaths.get(0) + PARAMETER_LIST + "CONTRACTS";
//					String[] val = CommonUtils
//							.getValue(vt, contract_prefix);
					
					ArrayList<String> childName = new ArrayList<String>();
					CommonUtils.getAllChildrenEnumType(vt, contract_prefix, childName);
					
					if (childName == null || childName.size() == 0) {
//						Messages.sendWarning("No contracts found", null, null, null);
						// do nothing
					} else {
						
						
						for (String contr_id : childName) {
							
							String tpath = contract_prefix + VARIANT_ELIST + contr_id + PARAMETER_LIST;
	
							String[] name   = CommonUtils.getValue(vt, tpath+ "NAME");
							String[] budget = CommonUtils.getValue(vt, tpath+ "BUDGET");
							String[] period = CommonUtils.getValue(vt, tpath+ "PERIOD");
							String[] cpu_id = CommonUtils.getValue(vt, tpath + "CPU_ID");
							
							if (name == null || name.length == 0) {
								throw new OilCodeWriterException("Found a contract without a name.");
							}
							else { // avoid duplicates contracts names
								if (contracts.containsKey((String)name[0])) {
									throw new OilCodeWriterException("Duplicate contract name: " + name[0]);
								}
							}

							// handle budget/period
							if ( (budget == null) || (budget.length == 0) || (budget[0] == null) ||  (budget[0].length() == 0) ) {
								throw new OilCodeWriterException("Missing or invalid budget for contract: " + name[0]);
							}
							if ( (period == null) || (period.length == 0) || (period[0] == null) || (period[0].length() == 0) ) {
								throw new OilCodeWriterException("Missing or invalid period for contract: " + name[0]);
							}

							// b, p can be time, and if so must be converted in cycles							
							long budget_i = -1;
							long period_i = -1;
							{
								boolean valid = true;
								{ // budget
									valid = true;
									try { // initially try as ticks (long)
										budget_i = Long.decode(budget[0]).longValue();
									}
									catch(Exception e) {
										valid = false;
									}
									if (!valid) { // then try as string (timevar)
										double l_b = 0;
										TimeVar tv;
								try {
											tv = new TimeVar(budget[0]);
											tv.setType(tv_tick_time.getType());
											l_b = ((Double)tv_tick_time.get()).doubleValue();
								}
										catch(Exception e) {
											throw new OilCodeWriterException("Missing or invalid budget for contract: " + name[0]);
								}
										if (tv_tick_time == null) {
											throw new OilCodeWriterException("Missing TICK_TIME for the FRESCOR Kernel");
							}
										budget_i = (long)(l_b / tick_time);
									}
								}
								{ // period
									valid = true;
									try { // initially try as ticks (long)
										period_i = Long.decode(period[0]).longValue();
									}
									catch(Exception e) {
										valid = false;
									}
									if (!valid) { // then try as string (timevar)
										double l_p = 0;
										TimeVar tv;
								try {
											tv = new TimeVar(period[0]);
											tv.setType(tv_tick_time.getType());
											l_p = ((Double)tv_tick_time.get()).doubleValue();
										}
										catch(Exception e) {
											throw new OilCodeWriterException("Missing or invalid period for contract: " + name[0]);
										}
										if (tv_tick_time == null) {
											throw new OilCodeWriterException("Missing TICK_TIME for the FRESCOR Kernel");
										}
										period_i = (long)(l_p / tick_time);
									}
								}
							}
							if (budget_i < 0) {
								throw new OilCodeWriterException("Invalid budget for contract: " +
										name[0] + ". Must be non-negative.");
							}
							if (budget_i > period_i) {
								throw new OilCodeWriterException("Budget cannot be greater" +
										"than period in contract: " + name[0]);
								}
								if (period_i <=0) {
								throw new OilCodeWriterException("Invalid period for contract: " +
										name[0] + ". Must be positive.");
							}
							if (cpu_id == null || cpu_id.length == 0) {
								cpu_id = new String[] { IWritersKeywords.DEFAULT_CPU_NAME };
								}
							
							Contract c = new Contract(name[0], budget_i, period_i, cpu_id[0]);
							// add to the cpu
							if (cpuContracts.containsKey(cpu_id[0])) {
								((Map)cpuContracts.get(cpu_id[0])).put(name[0], c);
							} else {
								Messages.sendWarning("The contract " + name[0] + " is mapped to an unknow cpu (" + cpu_id[0] + ")", 
										null, "swfrsh_load_contract_", null);
							}
							
							// build a complete list of all Contracts
							contracts.put(name[0], c);
						}
						}
					}
//			} else {
//				throw new Error("Required FRESCOR");
				}
					
			//sgrOs.setObject(FRSH_OS_CONTRACT_LIST, contracts);

			}
			
		// Set Default Vaule
		if (use_sync_objs == null) {
			use_sync_objs = Boolean.FALSE;
		}

		if (!found_kernel) {
			throw new Error("Required FRESCOR");
		}

		if (parent.checkKeyword(IWritersKeywords.CPU_NIOSII)) { // TIMERS
			for (int currentRtosId=0; currentRtosId<oilObjects.length; currentRtosId++) {// search the RTOS 
				final IOilObjectList ool = oilObjects[currentRtosId];
				final String cpuName = ErikaEnterpriseWriter.getOSName(ool);


				/*
				 * Frsh TImer
				 */

				FrshTimer timer = null;
				String freeRunning = null;
				
				final List<String> currentCpuPrefixes = AbstractRtosWriter.getOsProperties(ool, SGRK_OS_CPU_DATA_PREFIX);
				for (String currentCpuPrefix: currentCpuPrefixes) {
					if (timer == null) {
		
						String[] child = new String[1];
						String type = CommonUtils
								.getFirstChildEnumType(vt, currentCpuPrefix
										+ "FRSH_TIMERS", child);
		
						if ("SINGLE".equalsIgnoreCase(type)) {
							String prefixIRQ = currentCpuPrefix
								+ "FRSH_TIMERS" + VARIANT_ELIST+child[0] + PARAMETER_LIST
								+ "TIMER_IRQ";
		
							String[] tmp = CommonUtils.getValue(vt, prefixIRQ);
							if (tmp == null || tmp.length == 0 || tmp[0] == null)
								throw new RuntimeException("Expected " + "TIMER_IRQ" +" for cpu " + cpuName );
		
							timer = new FrshTimer(tmp[0]);
						
						} else if ("MULTIPLE".equalsIgnoreCase(type)) {
										
							String prefixIRQ = currentCpuPrefix
								+ "FRSH_TIMERS" + VARIANT_ELIST+child[0] + PARAMETER_LIST;
		
							String[] tmp_budg = CommonUtils.getValue(vt, prefixIRQ + "TIMER_IRQ_BUDGET");
							if (tmp_budg == null || tmp_budg.length == 0 || tmp_budg[0] == null)
								throw new RuntimeException("Expected " + "TIMER_IRQ_BUDGET" +" for cpu " + cpuName );
							
							String[] tmp_rec = CommonUtils.getValue(vt, prefixIRQ + "TIMER_IRQ_RECHARGE");
							if (tmp_rec == null || tmp_rec.length == 0 || tmp_rec[0] == null)
								throw new RuntimeException("Expected " + "TIMER_IRQ_RECHARGE" +" for cpu " + cpuName );
							
							String[] tmp_dl = CommonUtils.getValue(vt, prefixIRQ + "TIMER_IRQ_DLCHECK");
							if (tmp_dl == null || tmp_dl.length == 0 || tmp_dl[0] == null)
								throw new RuntimeException("Expected " + "TIMER_IRQ_DLCHECK" +" for cpu " + cpuName );
							
							String[] tmp_sem; 
							tmp_sem = CommonUtils.getValue(vt, prefixIRQ + "TIMER_IRQ_SEM");
							
							if (tmp_sem == null || tmp_sem.length == 0 || tmp_sem[0] == null) {
								if (use_sync_objs.booleanValue()){
									throw new RuntimeException("Expected " + "TIMER_IRQ_SEM" +" for cpu " + cpuName );
								} else {
									tmp_sem = new String[] {null};
								}
							}		
					
							timer = new FrshTimer(tmp_budg[0], tmp_rec[0], tmp_dl[0], tmp_sem[0]);
						}
					}
				

					/*
					 * TIMER_FREERUNNING
					 */
					
					if (freeRunning == null) {
						String[] tmp = CommonUtils.getValue(vt, currentCpuPrefix
								+ "TIMER_FREERUNNING");
				
						if (tmp != null && tmp.length >0) 
							freeRunning = tmp[0];
					}
				}
				
				if (timer == null)
					throw new RuntimeException("Expected " + "FRSH_TIMERS" +" for cpu " + cpuName 
							+ "( Valid values are : SINGLE and MULTIPLE. )" );

				
				if (freeRunning == null)
					throw new RuntimeException("Expected " + "TIMER_FREERUNNING" +" for cpu " + cpuName );

				
				ISimpleGenRes sgrOs = ool.getList(IOilObjectList.OS).get(0);
				sgrOs.setObject(FRSH_CPU_TIMER, timer);
				sgrOs.setObject(FRSH_CPU_FREE_TIMER, freeRunning);
			} // End For each Cpu
			
		}

			

		/***********************************************************************
		 * 
		 * Set task and Cpu properties (Contract Ref, Contract List e USE_SYNC_OBJ)
		 *  
		 **********************************************************************/
		{
			
			// Check the Stack Type
			String stackType = parent.getStackType(); // MULTI or MONO
			if (!DEF__MULTI_STACK__.equals(stackType)) {
				throw new OilCodeWriterException("Frescor kernel requires MULTI_STACK");
			}
			// irq stack
			if (!parent.checkKeyword(DEF__IRQ_STACK_NEEDED__)) {
				throw new OilCodeWriterException("This kernel requires a private STACK for IRQs.");
			}
			
			final IOilObjectList[] _oilObjects = parent.getOilObjects();
			HashSet<String> hs = new HashSet<String>();
			for (int i = 0; i < _oilObjects.length; i++) { //foreach cpu

				double total_task_utilization = 0;
				final IOilObjectList ool = _oilObjects[i];
				final List<ISimpleGenRes> tasks = ool.getList(IOilObjectList.TASK);
				final String t_cpuid = ErikaEnterpriseWriter.getOSName(ool);

			// update stack properties of each task
			new EEStacks(parent, ool, null);

				for (Iterator<ISimpleGenRes> iter = tasks.iterator(); iter.hasNext();) { //foreach task
					final ISimpleGenRes currTask = (ISimpleGenRes)iter.next();
					final String oilVarPrefix = (new OilPath(OilObjectType.TASK, null)).getPath();
					final String contractPath = currTask.getPath() + S + oilVarPrefix + S
							+ "CONTRACT";
					final String[] _contracts = CommonUtils.getValue(vt, contractPath);
					if (_contracts == null || _contracts.length == 0 || _contracts[0].length() == 0 ) {
						throw new OilCodeWriterException("Required a CONTRACT reference for the task "+currTask.getName()+".");
					}
					if (!contracts.containsKey(_contracts[0])) {
						throw new OilCodeWriterException("Task " + currTask.getName() + " references to a non existing CONTRACT (" + _contracts[0] + ").");
					}
					if (!hs.add((String)_contracts[0])) {
						throw new OilCodeWriterException("Task " + currTask.getName() +
								" tries to get already bound contract " + _contracts[0]);
					}
					final Contract c = (Contract)contracts.get(_contracts[0]);
					final String c_cpuid = c.cpu_id;

					long budget = c.budget; // handle budget/period
					long period = c.period;
					if (budget == 0)
						Messages.sendWarning("Budget is 0!, task " + currTask.getName() +
								"will never be executed.", null, "BUDGETISZERO", null);
					total_task_utilization += ((double)budget) / period;
					if (!c_cpuid.equalsIgnoreCase(t_cpuid)) {
						throw new OilCodeWriterException("Task " + currTask.getName() + " and contract " + c.name + " have different CPU.");
					}

					{ // checks if this task has its own stack
				boolean ok = false;
				if (currTask.containsProperty(ISimpleGenResKeywords.TASK_STACK)) {
					ok = ISimpleGenResKeywords.TASK_STACK_PRIVATE.equalsIgnoreCase(currTask.getString(ISimpleGenResKeywords.TASK_STACK));
				}
				
				if (!ok) {
					throw new OilCodeWriterException("Frescor kernel requires a private STACK for each task. Task " + currTask.getName() + " doesn't have a private stack.");
				}
			}
					currTask.setObject(FRSH_TASK_CONTRACT_REF, _contracts[0]);
			
			}

				if (total_task_utilization >1) {
					throw new OilCodeWriterException("Current totat utilization of cpu " + t_cpuid + " is higher than one : "+ total_task_utilization);
				}
				{ // set values
					ool.getList(IOilObjectList.OS).get(0).setObject(FRSH_OS_USE_SYNC_OBJ, use_sync_objs.booleanValue() ? Boolean.TRUE : Boolean.FALSE);
				}


				{ // EE_OPT
					ISimpleGenRes sgrOs = ool.getList(IOilObjectList.OS).get(0);
					String[] lista = sgrOs.containsProperty(ISimpleGenResKeywords.OS_CPU_EE_OPTS) ?
							(String[]) sgrOs.getObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS) :
								new String[0];
					List requiredOilObjects = ErikaEnterpriseWriter.checkOrDefault((List) getOsObject(ool, SGRK__FORCE_ARRAYS_LIST__), new ArrayList());
					//ArrayList<String> array = new ArrayList<String>(Arrays.asList(lista));
					ArrayList<String> array = new ArrayList<String>(Arrays.asList(lista));
					
					array.add("__FRSH__");
					array.add("__TIME_SUPPORT__");
					
					// needed by FRSH ... but should be generated?
					array.add("__MULTI__");
					array.add("__IRQ_STACK_NEEDED__");
					
					if (use_sync_objs.booleanValue()) {
						array.add("__FRSH_SYNCHOBJ__");
					}
					
					{
					    BitSet rn_set = (BitSet) getOsObject(ool, IRemoteNotificationsConstants.DEF__RN_BITS__);
						if (rn_set != null && rn_set.cardinality()>0) {
							array.add("__RN_BIND__");
							array.add("__RN_UNBIND__");
					    }
					}
					
					if (CpuUtility.getSupportForNestedIRQ(ool) 
							&& parent.checkKeyword(DEF__ALLOW_NESTED_IRQ__)) {
						array.add("__ALLOW_NESTED_IRQ__");
					}
					
					if (ool.getList(IOilObjectList.ALARM).size() > 0 
							|| requiredOilObjects.contains(new Integer(IOilObjectList.ALARM))) {
						array.add("__ALARMS__");
					}
					
					if (sgrOs.containsProperty(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR)) {
						String single_irq_opt = "__FRSH_SINGLEIRQ__";
						
						CpuHwDescription currentStackDescription = ErikaEnterpriseWriter.getCpuHwDescription(ool); 

						if (IWritersKeywords.CPU_NIOSII.equals(currentStackDescription.cpuType)) {
							FrshTimer timer = (FrshTimer) getOsObject(ool, FRSH_CPU_TIMER);
							if (timer != null && timer.isSingle()) {
								array.add(single_irq_opt);
							}
							
						} else if (IWritersKeywords.CPU_PIC_30.equals(currentStackDescription.cpuType)) {
							array.add(single_irq_opt);
						}
		
					}
					sgrOs.setObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS, array.toArray(new String[array.size()]));
				}

			}
		}
		
	}

}

