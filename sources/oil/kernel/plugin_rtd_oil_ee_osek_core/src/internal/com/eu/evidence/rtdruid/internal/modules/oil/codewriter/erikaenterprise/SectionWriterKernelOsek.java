/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterKernelOsek.java,v 1.6 2008/04/18 15:26:29 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.IncompatibleWriterKeywordsException;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.RequiredWriterKeywordsException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AlarmAutoStartDescr;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuUtility;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EECpuDescriptionManager;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * This writer build files for an Osek Kernel
 * 
 * @author Nicola Serreli
 */
public class SectionWriterKernelOsek extends SectionWriter implements
		IEEWriterKeywords, IExtractKeywordsExtentions, IGetEEOPTExtentions {
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;

	public SectionWriterKernelOsek() {
		this(null);
	}

	/**
	 * 
	 */
	public SectionWriterKernelOsek(ErikaEnterpriseWriter parent) {
		super(IWritersKeywords.OSEK_KERNEL,
				new String[] {}, //
				new String[] { //
					IWritersKeywords.EDF, //
					IWritersKeywords.FP, //
					IWritersKeywords.CBS, //
					IWritersKeywords.IRIS, //
					IWritersKeywords.SRPT //
				},
				SWCategoryManager.defaultInstance.newCategory(SWCategoryManager.TYPE_KERNEL));
		
		this.parent = parent;
	}

	protected String[] valid = new String[] {
			IWritersKeywords.OSEK_BCC1, //
			IWritersKeywords.OSEK_BCC2, //
			IWritersKeywords.OSEK_ECC1, //
			IWritersKeywords.OSEK_ECC2, //
			IWritersKeywords.OSEK_SC1, //
			IWritersKeywords.OSEK_SC2, //
			IWritersKeywords.OSEK_SC3, //
			IWritersKeywords.OSEK_SC4 //
	};

	/**
	 * This method check that the given keys list contains all required keys and
	 * none of wrongful keys.
	 * 
	 * @throws IncompatibleWriterKeywordsException
	 *             if there is one or more keywords incompatible with this
	 *             writer
	 */
	public void internalCheckKeys(String[] keys)
			throws IncompatibleWriterKeywordsException,
			RequiredWriterKeywordsException {
		super.checkKeys(keys);

		int pos = -1;

		for (int i = 0; i < valid.length; i++) {
			if (parent.checkKeyword(valid[i])) {
				if (pos != -1) {
					throw new IncompatibleWriterKeywordsException(
							id, valid[pos] + " - " + valid[i]);
				}
				pos = i;
			}
		}
		
		// set ECC1 and ECC2 incompatible with MONO_STACK
		if ((parent.checkKeyword(IWritersKeywords.OSEK_ECC1) || parent.checkKeyword(IWritersKeywords.OSEK_ECC2))
			&& 	parent.checkKeyword(DEF__MONO_STACK__)) {
			throw new IncompatibleWriterKeywordsException(
					"ECC1 and ECC2 kernels work only with multi stack.",
					id, DEF__MONO_STACK__);
		}
	}

	/**
	 * This method returns true if current instance of writer is enabled with
	 * specified keywords.
	 * 
	 * @return true if this writer is enabled
	 */
	protected boolean enabled() {
		for (int i = 0; i < valid.length; i++) {
			if (parent.checkKeyword(valid[i])) {
				return true;
			}
		}
		return false;
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
		ErikaEnterpriseWriter.appendBuffers(tmp, writeOSEK_Kernel());

		return tmp.toArray(new OilWriterBuffer[tmp.size()]);
	}

	
	/**
	 * Write Configuration's file for an OSEK Kernel
	 *
	 * @return buffers with configuration for an OSEK Kernel
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeOSEK_Kernel() throws OilCodeWriterException {

		IOilObjectList[] oilObjects = parent.getOilObjects();
		
		IOilWriterBuffer[] answer = new IOilWriterBuffer[oilObjects.length];
		
		// check if this a binary distribution
		boolean binaryDistr = parent.checkKeyword(IEEWriterKeywords.DEF__EE_USE_BINARY_DISTRIBUTION__);
		/*
		 * Define a string for each MAX_OBJECT_NUMBER (OBJECT=task, RESOURCE, ...).
		 * Binary distribution uses the suffix RTD_. 
		 */
		final String MAX_ALARM = (binaryDistr ? "RTD_" : "EE_") + "MAX_ALARM";
		final String MAX_APPMODE = (binaryDistr ? "RTD_" : "EE_") + "MAX_APPMODE";
		final String MAX_COUNTER = (binaryDistr ? "RTD_" : "EE_") + "MAX_COUNTER";
		final String MAX_TASK = (binaryDistr ? "RTD_" : "EE_") + "MAX_TASK";
		final String MAX_RESOURCE = (binaryDistr ? "RTD_" : "EE_") + "MAX_RESOURCE";
		
		
		/* indentxxx contains some white spaces for indent the output */
		final String indent1 = IWritersKeywords.INDENT;
		final String indent2 = indent1 + IWritersKeywords.INDENT;
		final String indent3 = indent2 + IWritersKeywords.INDENT;
		//final String indent4 = indent3 + WritersKeys.INDENT;
		
		// the current kernel identifier (BCC1, BCC2, ECC1, ECC2)
		final String kernelType = parent.getKernelType();
		// number of rtos
		final int rtosNumber = oilObjects.length;


		/***********************************************************************
		 * prepare and write buffers for All OS
		 **********************************************************************/
		for (int rtosId = 0; rtosId < rtosNumber; rtosId++) {
		
			// ------------------ common data ------------------
		
			// all objects for current os
			IOilObjectList ool = oilObjects[rtosId];
			// appModes contains the list of available modes
			ArrayList<String> appModes = null;
			// current os
			ISimpleGenRes os = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(
					0);
			List<Integer> requiredOilObjects = (List<Integer>) os.getObject(SGRK__FORCE_ARRAYS_LIST__);
			final ICommentWriter commentWriterC = getCommentWriter(os, FileTypes.C);

			
			/*
			 * Extract the max number of distrinct Priorities for current Kernel and HW.
			 * 
			 * The default value is 8 priorities.
			 * 
			 * BCC2 uses 8 priorities and ECC2 uses 16 priorities.
			 * The number of priorities for BCC1 and ECC1 depends onf HW type. 
			 */
			final int MaxPriorityLevels;
			{ 
				// Default value
				final int DefaultMaxPrioties = 8;
				
				if (IWritersKeywords.OSEK_BCC2.equals(kernelType)) {
					MaxPriorityLevels = 8;
					
				} else if (IWritersKeywords.OSEK_ECC2.equals(kernelType)) {
					MaxPriorityLevels = 16;
					
				} else if (IWritersKeywords.OSEK_BCC1.equals(kernelType) || IWritersKeywords.OSEK_ECC1.equals(kernelType)) {
		
					// search the current HW and then the correct number of Priorities
					String cpuType = os.getString(ISimpleGenResKeywords.OS_CPU_TYPE);
					int curr = DefaultMaxPrioties;
					if (EECpuDescriptionManager.containsHWDescription(cpuType)) {
						curr = EECpuDescriptionManager.getHWDescription(cpuType).prioSize;
					}
		
					MaxPriorityLevels = curr;
				} else {
					MaxPriorityLevels = DefaultMaxPrioties;
				}
			}
			
			// ------------------ prepare Application Modes ------------------
		
			{
				// Get all names of Application Modes (sorted)
				appModes = new ArrayList<String>();
				for (Iterator<ISimpleGenRes> iter = ool.getList(IOilObjectList.APPMODE)
						.iterator(); iter.hasNext();) {
					String name = iter.next().getName();
					if (!IWritersKeywords.defaultAppMode.equals(name)) {
						appModes.add(name);
					}
				}
				Collections.sort(appModes);
			}
		
			// autostart data
			LinkedList<String> autostartList[] = new LinkedList[appModes.size() + 1];
			for (int i = 0; i < autostartList.length; i++) {
				autostartList[i] = new LinkedList<String>();
			}
		
			// ---------------- prepare buffer ----------------
		
			if (answer[rtosId] == null) {
				answer[rtosId] = new OilWriterBuffer();
			}
		
			StringBuffer buffer = answer[rtosId].get(FILE_EE_CFG_C);
			//String ee_cfg_h_file_name = answer[rtosId].getFileName(FILE_EE_CFG_H);
		
			buffer.append(
					"#include \"ee.h\"\n"
					//+ "#include \""	+ ee_cfg_h_file_name + "\""
					+ commentWriterC.writerBanner("Kernel ( CPU " + rtosId
							+ " )"));
		
		
			// ready priority of each task (one row for each task)
			StringBuffer EE_th_ready_prioBuffer = new StringBuffer(indent1
					+ commentWriterC.writerSingleLineComment("ready priority") + indent1
					+ "const EE_TYPEPRIO EE_th_ready_prio["+MAX_TASK+"] = {\n");
			// buffer for rq Link (one row for each task)
			StringBuffer EE_rq_linkBuffer = new StringBuffer(indent1
					+ "EE_TYPEPRIO EE_rq_link["+MAX_TASK+"] =\n" + indent2 + "{");
			// dispatch priority of each task (one row for each task)
			StringBuffer EE_th_dispatch_prioBuffer = new StringBuffer(
					indent1
							+ "const EE_TYPEPRIO EE_th_dispatch_prio["+MAX_TASK+"] = {\n");
			// buffer for th_rnact (one row for each task)
			StringBuffer EE_th_rnactBuffer = new StringBuffer(indent1
					+ "EE_TYPEPRIO EE_th_rnact["+MAX_TASK+"] = {\n");
			// for each task, contains if it's extended or not
			StringBuffer EE_th_is_extendedBuffer = new StringBuffer(indent1
					+ "EE_TYPEPRIO EE_th_is_extended["+MAX_TASK+"] =\n"
					+ indent2 + "{");
		
		
			/* Contains task's address */
			StringBuffer sbThread = new StringBuffer();
			/* Contains task's declarations */
			StringBuffer sbDecThread = new StringBuffer();
			/* Contains task's stubs */
			StringBuffer sbStub = new StringBuffer();
		
			// ------------------ fill buffers ------------------
		
			int activaction_TOT = 0;
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
		
					ISimpleGenRes currTask = iter.next();
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
					id = currTask
							.getInt(ISimpleGenResKeywords.TASK_DISPATCH_PRIORITY);
					String dspPrio = "0x"
							+ (Integer.toHexString(id)).toUpperCase();
		
					/*
					 * ACTIVATION
					 * 
					 * act contains the max number of pending activations for current task
					 */
					int act = currTask
							.getInt(ISimpleGenResKeywords.TASK_ACTIVATION);
		
					/*
					 * EXTENDED
					 * 
					 * sched is true if the task is extended (has one or more events)
					 */
					int sched = ("true".equalsIgnoreCase(currTask
							.getString(ISimpleGenResKeywords.TASK_EXTENDED)) ? 1
							: 0);
		
					/*
					 * AUTOSTART
					 * 
					 * If a task has one or more autostart (for one or more
					 * differents application modes), add that task to
					 * autostart's list of specified Application Modes.
					 * 
					 * AutoStart is enabled if currentTask contains the property TASK_APPMODES_LIST.
					 * If that property is an empty List, it means that autostart is enabled for all
					 * application modes
					 */
					if (currTask
							.containsProperty(ISimpleGenResKeywords.TASK_APPMODES_LIST)) {
						List elenco = (List) currTask
								.getObject(ISimpleGenResKeywords.TASK_APPMODES_LIST);
		
						if (elenco.size() == 0) {
							// no value set means that
							// auto start is set to all application modes
							for (int i = 0; i < autostartList.length; i++) {
								autostartList[i].add(currTask.getName());
							}
						} else {
		
							/* search all valid Application modes.
							 * 
							 * "enable" contains one bit for all application mode:
							 * if that bit is set, the task has autostart for the corresponding
							 * application Mode.
							 * 
							 * Ecah application mode could be set only one time. 
							 */
							BitSet enabled = new BitSet(autostartList.length);
		
							for (Iterator appIter = elenco.iterator(); appIter
									.hasNext();) {
		
								String currAppMode = (String) appIter.next();
								if (IWritersKeywords.defaultAppMode
										.equals(currAppMode)) {
									// default application mode
									if (enabled.get(0)) {
										Messages.sendWarningNl(
												"Autostart set with the same APPMODE more times ."
														+ " (task = "
														+ currTask.getName()
														+ ", appMode = "
														+ currAppMode + ")",
												null, "sdfsdf;asdj", null);
										continue;
									}
									enabled.set(0);
		
									autostartList[0].add(currTask.getName());
								} else {
									// search APP MODE in "appModes" list
									int pos = Collections.binarySearch(
											appModes, currAppMode);
		
									if (pos < 0) { // not found
										throw new RuntimeException(
												"Autostart set with a not defined APPMODE ."
														+ " (task = "
														+ currTask.getName()
														+ ", appMode = "
														+ currAppMode + ")");
									}
		
									if (enabled.get(pos + 1)) {
										Messages.sendWarningNl(
												"Autostart set with the same APPMODE more times ."
														+ " (task = "
														+ currTask.getName()
														+ ", appMode = "
														+ currAppMode + ")",
												null, "kjasdh;asdj", null);
										continue;
									}
									enabled.set(pos + 1);
		
									autostartList[pos + 1].add(currTask
											.getName());
								}
							}
						}
					}
		
					/*
					 * --------------- WRITE VALUES ---------------
					 * 
					 * Append the correct value to all buffers
					 */
					EE_th_ready_prioBuffer.append(pre + post + indent2 + prio + "U");
					EE_th_dispatch_prioBuffer.append(pre + post + indent2
							+ dspPrio + "U");
					EE_rq_linkBuffer.append(pre + " " + priorityLevel + "U");
					EE_th_rnactBuffer.append(pre + post + indent2 + act + "U");
					EE_th_is_extendedBuffer.append(pre + " " + sched + "U");
		
					sbDecThread.append(pre2 + indent1 + "DeclareTask(" + tname + ");");
					sbThread.append(pre + pre2 + indent2 + "(EE_FADDR)Func"
							+ tname);
					sbStub.append(pre + post + indent2
							+ "(EE_FADDR)EE_oo_thread_stub");
					pre2 = "\n";
		
					pre = ",";
					post = "\t\t " + commentWriterC.writerSingleLineComment("thread " + tname); // ends with"\n";
		
					numTask++;
					activaction_TOT += act;
				}
			}
		
			/* Complete all buffers */
			EE_th_ready_prioBuffer.append(" " + post + indent1 + "};\n\n");
			EE_th_dispatch_prioBuffer.append(" " + post + indent1 + "};\n\n");
			EE_rq_linkBuffer.append("};\n\n");
			EE_th_rnactBuffer.append(post + indent1 + "};\n\n");
			EE_th_is_extendedBuffer.append("};\n\n");
			sbStub.append(" " + post);
		
			/*******************************************************************
			 * WRITE BUFFERS
			 ******************************************************************/
		
			// declare task and theirs address
			String mem_size = "EE_UINT32"; // 4 byte, default
			if (os.containsProperty(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR)) {
				int stack_size = ((CpuHwDescription) os.getObject(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR)).stackAddress;
				if (stack_size == 2) { // 2 byte
					mem_size = "EE_UINT16";
				} else if (stack_size == 1) { // 1 byte
					mem_size = "EE_UINT8";
				}  
			}

			buffer.append(indent1 + commentWriterC.writerSingleLineComment("Definition of task's body")
				+ sbDecThread + "\n\n"
				+ indent1 + "const EE_FADDR EE_hal_thread_body["+MAX_TASK+"] = {\n"
				+ sbStub + "\n"
				+ indent1 + "};\n\n"
				+ indent1 + mem_size + " EE_terminate_data["+MAX_TASK+"];\n\n"
				+ indent1 + commentWriterC.writerSingleLineComment("ip of each thread body (ROM)")
				+ indent1 + "const EE_FADDR EE_terminate_real_th_body["+MAX_TASK+"] = {\n"
				+ sbThread.toString() + "\n"
				+ indent1 + "};\n");
		
			buffer.append(EE_th_ready_prioBuffer);
			buffer.append(EE_th_dispatch_prioBuffer);
		
			/*
			 * EE_th_status
			 */
			buffer.append(indent1 + commentWriterC.writerSingleLineComment("thread status"));
		
			buffer.append(indent1
					+ "EE_TYPESTATUS EE_th_status["+MAX_TASK+"] = {\n");
			pre2 = "";
			for (int i = 0; i < numTask; i++) {
				buffer.append(pre2 + indent2 + "SUSPENDED");
				pre2 = ",\n";
			}
			buffer.append("\n" + indent1 + "};\n\n");
		
			/*
			 * EE_th_next
			 */
			buffer.append(indent1 + commentWriterC.writerSingleLineComment("next thread") + indent1
					+ "EE_TID EE_th_next["+MAX_TASK+"] = {\n");
			pre2 = "";
			for (int i = 0; i < numTask; i++) {
				buffer.append(pre2 + indent2 + "EE_NIL");
				pre2 = ",\n";
			}
			buffer.append("\n" + indent1 + "};\n\n");
		
			/*
			 * EE_stkfirst
			 */
			buffer.append(indent1 + commentWriterC.writerSingleLineComment("The first stacked task") + indent1
					+ "EE_TID EE_stkfirst = EE_NIL;\n\n");
			/*
			 * EE_sys_ceiling
			 */
			buffer.append(indent1 + commentWriterC.writerSingleLineComment("system ceiling") + indent1
					+ "EE_TYPEPRIO EE_sys_ceiling= 0x0000U;\n\n");
			/*
			 * ?CC1
			 * 
			 * EE_th_rnac EE_rq_first
			 */
			if (IWritersKeywords.OSEK_BCC1.equals(kernelType)
					|| IWritersKeywords.OSEK_ECC1.equals(kernelType)) {
				// EE_th_rnac
				buffer
						.append(indent1
								+ commentWriterC.writerSingleLineComment("remaining nact: init= maximum pending activations of a Task")
								+ indent1
								+ commentWriterC.writerSingleLineComment("MUST BE 1 for BCC1 and ECC1")
								+ indent1
								+ "EE_TYPENACT   EE_th_rnact["+MAX_TASK+"] =\n"
								+ indent2 + "{ ");
				pre2 = "";
				for (int i = 0; i < numTask; i++) {
					buffer.append(pre2 + "1U");
					pre2 = ", ";
				}
				buffer.append("};\n\n");
		
				// EE_rq_first
				buffer
						.append(indent1
								+ commentWriterC.writerSingleLineComment("First task in the ready queue (initvalue = EE_NIL)")
								+ indent1 + "EE_TID EE_rq_first  = EE_NIL;\n\n");
			}
		
			/*
			 * ?CC2
			 * 
			 * EE_th_rnact EE_rq_queues_head EE_rq_queues_tail EE_rq_bitmask
			 * EE_rq_link EE_rq_pairs_next EE_rq_pairs_tid EE_rq_free
			 *  
			 */
			if (IWritersKeywords.OSEK_BCC2.equals(kernelType)
					|| IWritersKeywords.OSEK_ECC2.equals(kernelType)) {
				if (IWritersKeywords.OSEK_BCC2.equals(kernelType)) {
					buffer
							.append(indent1
									+ commentWriterC.writerSingleLineComment("The priority queues: (8 priorities maximum!)")
									+ indent1
									+ "EE_TYPEPAIR EE_rq_queues_head[8] =\n"
									+ indent2
									+ "{ -1, -1, -1, -1, -1, -1, -1, -1};\n"
									+ indent1
									+ "EE_TYPEPAIR EE_rq_queues_tail[8] =\n"
									+ indent2
									+ "{ -1, -1, -1, -1, -1, -1, -1, -1};\n\n"
									+ indent1
									+ "EE_TYPE_RQ_MASK  EE_rq_bitmask = 0U;\n\n");
				} else {
					buffer
							.append(indent1
									+ commentWriterC.writerSingleLineComment("The priority queues: (16 priorities maximum!)")
		
									+ indent1
									+ "EE_TYPEPAIR EE_rq_queues_head[16] =\n"
									+ indent2
									+ "{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};\n"
									+ indent1
									+ "EE_TYPEPAIR EE_rq_queues_tail[16] =\n"
									+ indent2
									+ "{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};\n\n"
									+ indent1
									+ "EE_TYPE_RQ_MASK EE_rq_bitmask = 0U;\n\n");
				}
		
				// EE_th_rnact EE_rq_link
				buffer
						.append(indent1
								+ commentWriterC.writerSingleLineComment("remaining nact: init= maximum pending activations of a Task")
								+ EE_th_rnactBuffer + EE_rq_linkBuffer);
		
				// EE_rq_pairs_next
				buffer
						.append(indent1
								+ commentWriterC.writerSingleLineComment("The pairs that are enqueued into the priority queues ("
								+ activaction_TOT + " is the total number of task activations)")
								+ indent1
								+ "EE_TYPEPAIR EE_rq_pairs_next[] =\n"
								+ indent2 + "{ ");
				pre2 = "";
				for (int i = 1; i < activaction_TOT; i++) {
					buffer.append(pre2 + i);
					pre2 = ", ";
				}
				buffer.append(pre2 + "-1};\n\n");
		
				// EE_rq_pairs_tid EE_rq_free
				buffer
						.append(indent1
								+ commentWriterC.writerSingleLineComment("no need to be initialized")
								+ indent1
								+ "EE_TID EE_rq_pairs_tid["
								+ activaction_TOT
								+ "];\n\n"
								+ indent1
								+ commentWriterC.writerSingleLineComment("a list of unused pairs")
								+ indent1
								+ "EE_TYPEPAIR EE_rq_free = 0; " + commentWriterC.writerSingleLineComment("pointer to a free pair") +"\n");
			}
		
			/*
			 * EE_th_terminate_nextask
			 */
			buffer
					.append(indent1
							+ "#ifndef __OO_NO_CHAINTASK__\n"
							+ indent2
							+ commentWriterC.writerSingleLineComment("The next task to be activated after a ChainTask. initvalue=all EE_NIL")
							+ indent2
							+ "EE_TID EE_th_terminate_nextask["+MAX_TASK+"] = {\n");
			pre2 = "";
			for (int i = 0; i < numTask; i++) {
				buffer.append(pre2 + indent3 + "EE_NIL");
				pre2 = ",\n";
			}
			buffer.append("\n" + indent2 + "};\n" + indent1 + "#endif\n\n");
			
			/*******************************************************************
			 * EVENT HANDLING
			 ******************************************************************/
			if (IWritersKeywords.OSEK_ECC1.equals(kernelType)
					|| IWritersKeywords.OSEK_ECC2.equals(kernelType)) {
		
				buffer.append(commentWriterC.writerBanner("Event handling"));
		
				/*
				 * EE_th_event_active
				 */
				buffer
						.append(indent1
								+ "EE_TYPEEVENTMASK EE_th_event_active["+MAX_TASK+"] =\n"
								+ indent2 + "{ ");
				pre2 = "";
				for (int i = 0; i < numTask; i++) {
					buffer.append(pre2 + "0U");
					pre2 = ", ";
				}
				buffer.append("};" + indent1
						+ commentWriterC.writerSingleLineComment("thread event already active") +"\n");
		
				/*
				 * EE_th_event_waitmask
				 */
				buffer
						.append(indent1
								+ "EE_TYPEEVENTMASK EE_th_event_waitmask["+MAX_TASK+"] =\n"
								+ indent2 + "{ ");
				pre2 = "";
				for (int i = 0; i < numTask; i++) {
					buffer.append(pre2 + "0U");
					pre2 = ", ";
				}
				buffer.append("};" + indent1 + commentWriterC.writerSingleLineComment("thread wait mask") + "\n");
		
				/*
				 * EE_th_waswaiting
				 */
				buffer.append(indent1
						+ "EE_TYPEBOOL EE_th_waswaiting["+MAX_TASK+"] =\n"
						+ indent2 + "{ ");
				pre2 = "";
				for (int i = 0; i < numTask; i++) {
					buffer.append(pre2 + "0U");
					pre2 = ", ";
				}
				buffer.append("};\n\n");
		
				/*
				 * EE_th_is_extendedBuffer
				 */
				buffer.append(EE_th_is_extendedBuffer);
			}
		
			{
				/***************************************************************
				 * MUTEX
				 **************************************************************/
				List<ISimpleGenRes> mutexList = ool.getList(IOilObjectList.RESOURCE);
				if (mutexList.size() > 0 || requiredOilObjects.contains(new Integer(IOilObjectList.RESOURCE))) {
					
					final int maxMutex = parent.computeMaxResource(mutexList);
		
					buffer.append(commentWriterC.writerBanner("Mutex"));
		
					/*
					 * OSEK_EXTENDED
					 */
					if (parent.checkKeyword(OsekConstants.DEF__OSEKOS_EXTENDED_STATUS__)) {
						/*
						 * EE_th_resource_last
						 */
						buffer
								.append(commentWriterC.writerMultiLineComment(indent1,
											"This is the last mutex that the task has locked. This array\n" 
										+"   contains one entry for each task. Initvalue= all -1. at runtime,\n"
										+"   it points to the first item in the EE_resource_stack data structure.")
										+ indent1
										+ "EE_UREG EE_th_resource_last["+MAX_TASK+"] =\n"
										+ indent2 + "{ ");
						pre2 = "";
						for (int i = 0; i < numTask; i++) {
							buffer.append(pre2 + "(EE_UREG) -1");
							pre2 = ", ";
						}
						buffer.append("};\n\n");
		
						/*
						 * EE_th_resource_last
						 */
						buffer
								.append(commentWriterC.writerMultiLineComment(indent1,
										"This array is used to store a list of resources locked by a\n"
										+ "   task. there is one entry for each resource, initvalue = -1. the\n"
										+ "   list of resources locked by a task is ended by -1.")
										+ indent1
										+ "EE_UREG EE_resource_stack["+MAX_RESOURCE+"] =\n"
										+ indent2 + "{ ");
		
						pre2 = "";
						for (int i = 0; i < mutexList.size(); i++) {
							buffer.append(pre2 + "(EE_UREG) -1");
							pre2 = ", ";
						}
						buffer.append("};\n\n");
					}
		
					/*
					 * OSEK_EXTENDED || OSEK_ORTI_RESLOCKED
					 */
					{
						int current_orti = 0;
					
						if (parent.checkKeyword(IWritersKeywords.ENABLE_ORTI) &&
								os.containsProperty(OsekOrtiConstants.OS_CPU_ORTI_ENABLED_SECTIONS)) 
							current_orti = ((Integer) os.getObject(OsekOrtiConstants.OS_CPU_ORTI_ENABLED_SECTIONS));
					
						if (parent.checkKeyword(OsekConstants.DEF__OSEKOS_EXTENDED_STATUS__)
								|| (current_orti & OsekOrtiConstants.EE_ORTI_RESOURCE) != 0) {
			
							buffer
									.append(commentWriterC.writerMultiLineComment(indent1,
											"Only in extended status or when using ORTI with resources; for\n"
											+ "   each resource, a flag is allocated to see if the resource is locked or\n"
											+ "   not.  Note that this information cannot be easily knew from the previous\n"
											+ "   two data structures. initvalue=0")
											+ indent1
											+ "EE_TYPEBOOL EE_resource_locked["+MAX_RESOURCE+"] =\n"
											+ indent2 + "{ ");
							pre2 = "";
							for (int i = 0; i < maxMutex; i++) {
								buffer.append(pre2 + "0U");
								pre2 = ", ";
							}
							buffer.append("};\n\n");
						}
						
					}
			
					/*
					 * EE_resource_ceiling
					 */
					buffer
							.append(indent1
									+ "const EE_TYPEPRIO EE_resource_ceiling["+MAX_RESOURCE+"]= {\n");
					
		
					// search all ceilings and order them
					String[] names = new String[maxMutex];
					String[] ceilings = new String[maxMutex];
					for (Iterator<ISimpleGenRes> iter = mutexList.iterator(); iter
							.hasNext();) {
		
						ISimpleGenRes curr = iter.next();
		
						int id = curr.getInt(ISimpleGenResKeywords.RESOURCE_SYS_ID);
						
						ceilings[id] = "0x"
								+ (Integer
										.toHexString(curr
												.getInt(ISimpleGenResKeywords.RESOURCE_CEILING)))
										.toUpperCase()+"U";
						names[id]  = curr.getName();
					}
					
					
					
					
					/*
					 * RES_SCHEDULER
					 */
					// buffer.append(indent2 + res_sched_prio +"\t\t" + 
					// commentWriterC.writerSingleLineComment("RES_SCHEDULER"));
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
						post = "\t\t" + commentWriterC.writerSingleLineComment("resource " + name); // Ends with  " \n";
						pre2 = ",";
					}
					buffer.append(" " + post + indent1 + "};\n\n");
		
					buffer
							.append(indent1
									+ "EE_TYPEPRIO EE_resource_oldceiling["+MAX_RESOURCE+"];\n\n");
		
				} // end "if (mutexList.size()>0)"
			}
		
			{
				/***************************************************************
				 * COUNTERS
				 **************************************************************/
		
				List<ISimpleGenRes> counterList = ool.getList(IOilObjectList.COUNTER);
		
				if (counterList.size() > 0 || requiredOilObjects.contains(new Integer(IOilObjectList.COUNTER))) {
					buffer.append(commentWriterC.writerBanner("Counters"));
		
					/*
					 * EE_counter_ROM
					 */
					buffer
							.append(indent1+"const EE_oo_counter_ROM_type EE_counter_ROM[] = {\n");
					pre2 = "";
					post = "";
		
					for (Iterator<ISimpleGenRes> iter = counterList.iterator(); iter.hasNext();) {
		
						// ------ GET VALUES -----
						ISimpleGenRes curr = iter.next();
		
						String maxAllowed = curr.getString(ISimpleGenResKeywords.COUNTER_MAX_ALLOWED)+"U";
						String ticks = curr.getString(ISimpleGenResKeywords.COUNTER_TICKS)+"U";
						String minCycle = curr.getString(ISimpleGenResKeywords.COUNTER_MIN_CYCLE)+"U";
		
						// ------ WRITE BUFFER -----
		
						buffer.append(pre2 + post + indent2+"{" + maxAllowed + ", "
								+ ticks + ", " + minCycle + "}");
						pre2 = ",";
						post = indent2 + commentWriterC.writerSingleLineComment(curr.getName()); // end with \n;
					}
					buffer.append(" " + post +indent1+ "};\n\n");
		
					/*
					 * EE_counter_RAM
					 */
					buffer
							.append(indent1+"EE_oo_counter_RAM_type       EE_counter_RAM["+MAX_COUNTER+"] = {");
					pre2 = "\n";
					for (int i = 0; i < counterList.size(); i++) {
						buffer.append(pre2 + indent2+"{0U, -1}");
						pre2 = ",\n";
					}
					buffer.append("\n"+indent1+"};\n");
				}
			}
			{
				/***************************************************************
				 * ALARMS
				 **************************************************************/
		
				List<ISimpleGenRes> alarmList = ool.getList(IOilObjectList.ALARM);
		
				if (alarmList.size() > 0 || requiredOilObjects.contains(new Integer(IOilObjectList.ALARM))) {
					final String NULL_NAME = "NULL";
					buffer.append(commentWriterC.writerBanner("Alarms"));
					
					LinkedList<String> callback_functions = new LinkedList<String>();
		
					/*
					 * EE_alarm_ROM
					 */
					StringBuffer romBuffer = new StringBuffer(indent1
									+ "const EE_oo_alarm_ROM_type   EE_alarm_ROM[] = {\n");
		
					boolean withEvents = IWritersKeywords.OSEK_ECC1
							.equals(kernelType)
							|| IWritersKeywords.OSEK_ECC2.equals(kernelType);
		
					pre2 = "";
					for (Iterator<ISimpleGenRes> iter = alarmList.iterator(); iter.hasNext();) {
		
						ISimpleGenRes curr = iter.next();
		
						// set all values for each alarm
						int counter_id = -1;
						String callBackName = NULL_NAME;
						//int task_id = 0;
						String task_al_name = "0"; // default value
						String evento = "0U";
						String notif_type = "";
		
						// prepare all data
		
						{ // ----- GET VALUES -----
							String coun_Al_Name = curr.getString(ISimpleGenResKeywords.ALARM_COUNTER); 
		
							//search counter
							List<ISimpleGenRes> counterList = ool
									.getList(IOilObjectList.COUNTER);
							for (Iterator<ISimpleGenRes> countIter = counterList.iterator(); countIter
									.hasNext();) {
								ISimpleGenRes counter = countIter
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
										ISimpleGenRes sgr = ii
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
									ISimpleGenRes sgr = ii.next();
		
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
								+ (NULL_NAME.equals(callBackName) ? "(EE_VOID_CALLBACK)" : "") + callBackName + "}");
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
							+ "EE_oo_alarm_RAM_type         EE_alarm_RAM["
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
		
		
			/*******************************************************************
			 * APPMODE
			 ******************************************************************/ 
			buffer.append(commentWriterC.writerBanner("AppMode")
					+indent1+"EE_TYPEAPPMODE EE_ApplicationMode;\n");
			
			/*******************************************************************
			 * AUTOSTART
			 ******************************************************************/
			if ("true".equalsIgnoreCase(os
					.getString(ISimpleGenResKeywords.OSEK_AUTOSTART))) {
				
				
				// -------- TASK --------
				if ("true".equalsIgnoreCase(os
						.getString(ISimpleGenResKeywords.OSEK_TASK_AUTOSTART))) {
		
					buffer.append(commentWriterC.writerBanner("Auto Start (TASK)"));
					
					appModes.add(0, IWritersKeywords.defaultAppMode);
					
					Collection<String>[] allArrays = new Collection[appModes.size()];
		
					for (int appN = 0; appN < appModes.size(); appN++) {
						
						// search if the same array already exist
						final int arrayId = CommonUtils.searchArray(allArrays,
								(String[]) autostartList[appN].toArray(new String[autostartList[appN].size()] ) ); 

						final boolean disable_define  = autostartList[appN].size() == 0;
						StringBuffer tmp_buffer = new StringBuffer();

						if (arrayId == -1) {
							// store this new array ..
							allArrays[appN] = autostartList[appN];
							
						
							// .. and define it in the code
							tmp_buffer.append(indent1+"static const EE_TID EE_oo_autostart_task_mode_"
									+ appModes.get(appN) + "["
									+ autostartList[appN].size() + "] = \n"+ indent2+"{ ");
							pre2 = "";
							for (int i = 0; i < autostartList[appN].size(); i++) {
								tmp_buffer.append(pre2 + autostartList[appN].get(i));
								pre2 = ", ";
							}
							tmp_buffer.append(" };\n");
						
							
							
							
						}  else {
							// link to a previous defined array
							
							tmp_buffer.append("#define EE_oo_autostart_task_mode_"
									+ appModes.get(appN)+" EE_oo_autostart_task_mode_"+appModes.get(arrayId)+"\n");
						}
						
						
						buffer.append(disable_define ? 
									  commentWriterC.writerMultiLineComment(indent1, tmp_buffer.toString())
									: tmp_buffer.toString());
					}
		
					pre2 = "";
					buffer
							.append("\n"+indent1+"const struct EE_oo_autostart_task_type EE_oo_autostart_task_data["+MAX_APPMODE+"] = {\n");
					for (int appN = 0; appN < appModes.size(); appN++) {
						final boolean disable_define  = autostartList[appN].size() == 0; // ? ", 0}, //" : ""; 
						buffer
								.append(pre2 + indent2+"{ "
										+ autostartList[appN].size() + "U"
//										+ disable_define
										+ ", " + (disable_define ? "0U" 
												: "EE_oo_autostart_task_mode_" + appModes.get(appN))
										+ "}");
						pre2 = ",\n";
					}
					buffer.append("\n"+indent1+"};\n");
					appModes.remove(0);
				}
				
				// -------- ALARM --------
				if ("true".equalsIgnoreCase(os
						.getString(ISimpleGenResKeywords.OSEK_ALARM_AUTOSTART))) {
					
					buffer.append(commentWriterC.writerBanner("Auto Start (ALARM)"));
					
					appModes.add(0, IWritersKeywords.defaultAppMode);
					Collection<String>[] allArrays = new Collection[appModes.size()];
					int[] arraySize = new int[appModes.size()];
		
					// for each mode, prepare an array "EE_autostart_alarm_mode_XXX"
					for (int appN = 0; appN < appModes.size(); appN++) {
						String appModeName = appModes.get(appN);
		
						ArrayList<String> tmpArray = new ArrayList<String>();
		
						// check all alarms and prepare the list of Autostarted Alarms
						List<ISimpleGenRes> alarmList = ool.getList(IOilObjectList.ALARM);
						for (Iterator<ISimpleGenRes> iter = alarmList.iterator(); iter.hasNext();) {
							ISimpleGenRes alarm = iter.next();
							
							if (alarm.containsProperty(ISimpleGenResKeywords.ALARM_AUTOSTART)) {
								AlarmAutoStartDescr aasd = (AlarmAutoStartDescr) alarm.getObject(ISimpleGenResKeywords.ALARM_AUTOSTART);
								
								if (aasd.containsMode(appModeName)) {
									
									tmpArray.add(alarm.getName());
								}
							}
							
						}
						arraySize[appN] =  tmpArray.size();
						
						// search if the same array already exist
						final int arrayId = CommonUtils.searchArray(allArrays,
								tmpArray.toArray(new String[tmpArray.size()] ) ); 
		
						
						if (arrayId == -1) {
							// store this new array ..
							allArrays[appN] = tmpArray;
		
							// .. and define it in the code
							buffer.append(indent1+"static const EE_TYPEALARM EE_oo_autostart_alarm_mode_"
									+ appModeName+ "["+tmpArray.size()+"] =\n"+indent2+"{ ");
							pre2 = "";
							for (int i = 0; i < tmpArray.size(); i++) {
								String id = tmpArray.get(i);
								try {
									Integer.parseInt(id);
									// if arrived here, id is a number -> then add U
									id +="U";
								} catch (Exception e) {
									// id is not a number. ok... do nothing
								}
								buffer.append(pre2 + id);
								pre2 = ", ";
							}
							buffer.append(" };\n");
						}  else {
							// link to a previous defined array
							
							buffer.append(indent1+"#define EE_oo_autostart_alarm_mode_"
									+ appModeName+ " EE_oo_autostart_alarm_mode_"+appModes.get(arrayId)+"\n");
						}
		
					}
		
					// EE_autostart_data
					pre2 = "";
					buffer
							.append("\n"+ indent1+"const struct EE_oo_autostart_alarm_type EE_oo_autostart_alarm_data["+MAX_APPMODE+"] = {\n");
					for (int appN = 0; appN < appModes.size(); appN++) {
						buffer
								.append(pre2 + indent2+"{ "
										+ arraySize[appN]+"U"
										+ ", EE_oo_autostart_alarm_mode_"
										+ appModes.get(appN) + "}");
						pre2 = ",\n";
					}
					buffer.append("\n"+ indent1+"};\n");
					appModes.remove(0);
				}
				if (ool.getList(IOilObjectList.ALARM).size() > 0 && 
						("true".equalsIgnoreCase(os
								.getString(ISimpleGenResKeywords.OSEK_ALARM_AUTOSTART)))) {

					buffer.append(commentWriterC.writerBanner("Init alarms parameters (ALARM)"));

					
					// EE_oo_autostart_alarm_increment && EE_oo_autostart_alarm_cycle
					List<ISimpleGenRes> alarmList = ool.getList(IOilObjectList.ALARM);
					
					StringBuffer sbAlarmTime = new StringBuffer("\n"+ indent1+"const EE_TYPETICK EE_oo_autostart_alarm_increment["+MAX_ALARM+"] =\n"+indent2+"{");
					StringBuffer sbCycleTime = new StringBuffer("\n"+ indent1+"const EE_TYPETICK EE_oo_autostart_alarm_cycle["+MAX_ALARM+"] =\n"+indent2+"{");
					pre2 = "";
					
					// check all alarms
					for (Iterator<ISimpleGenRes> iter = alarmList.iterator(); iter.hasNext();) {
						ISimpleGenRes alarm = iter.next();
						
						long alarmTime = 0;
						long cycleTime = 0;
						
						if (alarm.containsProperty(ISimpleGenResKeywords.ALARM_AUTOSTART)) {
							AlarmAutoStartDescr aasd = (AlarmAutoStartDescr) alarm.getObject(ISimpleGenResKeywords.ALARM_AUTOSTART);
							
							alarmTime = aasd.getAlarmTime();
							cycleTime = aasd.getCycleTime();
							
						} else	if (alarm.containsProperty(ISimpleGenResKeywords.ALARM_INIT)) {
							AlarmAutoStartDescr aasd = (AlarmAutoStartDescr) alarm.getObject(ISimpleGenResKeywords.ALARM_INIT);
							
							alarmTime = aasd.getAlarmTime();
							cycleTime = aasd.getCycleTime();
						}

		
						sbAlarmTime.append(pre2 + alarmTime +"U");
						sbCycleTime.append(pre2 + cycleTime +"U");
						pre2 = ", ";
		
					}
					sbAlarmTime.append(" };\n");
					sbCycleTime.append(" };\n");
		
					buffer.append(sbAlarmTime.toString() + sbCycleTime.toString());
				}
		
			}
		
			// add a new line
			buffer.append("\n");
		}
		
		return answer;
	}
	
	
	
	

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.IExtractKeywordsExtentions#updateKeywords(java.util.ArrayList, java.lang.String[])
	 */
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix)
			throws OilCodeWriterException {

		if (!(keywords.contains(IWritersKeywords.OSEK_BCC1) ||
				keywords.contains(IWritersKeywords.OSEK_BCC2) ||
				keywords.contains(IWritersKeywords.OSEK_ECC1) ||
				keywords.contains(IWritersKeywords.OSEK_ECC2) ||
				keywords.contains(IWritersKeywords.OSEK_SC1) ||
				keywords.contains(IWritersKeywords.OSEK_SC2) ||
				keywords.contains(IWritersKeywords.OSEK_SC3) ||
				keywords.contains(IWritersKeywords.OSEK_SC4))) {
			return;
		}

		if (!keywords.contains(IWritersKeywords.OSEK_KERNEL)) {
			keywords.add(IWritersKeywords.OSEK_KERNEL);
		}
		if (keywords.contains(IWritersKeywords.OSEK_SC4)) {
			if (!keywords.contains(IWritersKeywords.KERNEL_MEMORY_PROTECTION)) {
				keywords.add(IWritersKeywords.KERNEL_MEMORY_PROTECTION);
			}
			if (!keywords.contains(IWritersKeywords.OSEK_ECC2)) {
				keywords.add(IWritersKeywords.OSEK_ECC2);
			}
		}

		
		final IVarTree vt = parent.getVt();

		for (int rtodId=0; rtodId<rtosPrefix.length; rtodId++) {

			final String currentRtosPrefix = parent.computeOilRtosPrefix(rtosPrefix[rtodId]);
	
			List<AutoOptions> options = new ArrayList<AutoOptions>();

			
			options.add(new AutoOptions(currentRtosPrefix, "STATUS", "EXTENDED", OsekConstants.DEF__OSEKOS_EXTENDED_STATUS__, false));
			options.add(new AutoOptions(currentRtosPrefix, "STARTUPHOOK", "TRUE", OsekConstants.DEF__OSEKOS_HAS_STARTUPHOOK__, false));
			options.add(new AutoOptions(currentRtosPrefix, "ERRORHOOK", "TRUE", OsekConstants.DEF__OSEKOS_HAS_ERRORHOOK__, false));
			options.add(new AutoOptions(currentRtosPrefix, "SHUTDOWNHOOK", "TRUE", OsekConstants.DEF__OSEKOS_HAS_SHUTDOWNHOOK__, false));
			options.add(new AutoOptions(currentRtosPrefix, "PRETASKHOOK", "TRUE", OsekConstants.DEF__OSEKOS_HAS_PRETASKHOOK__, false));
			options.add(new AutoOptions(currentRtosPrefix, "POSTTASKHOOK", "TRUE", OsekConstants.DEF__OSEKOS_HAS_POSTTASKHOOK__, false));
			options.add(new AutoOptions(currentRtosPrefix, "USEGETSERVICEID", "TRUE", OsekConstants.DEF__OSEKOS_HAS_USEGETSERVICEID__, false));
			options.add(new AutoOptions(currentRtosPrefix, "USEPARAMETERACCESS", "TRUE", OsekConstants.DEF__OSEKOS_HAS_USEPARAMETERACCESS__, false));
			options.add(new AutoOptions(currentRtosPrefix, "USERESSCHEDULER", "TRUE", OsekConstants.DEF__OSEKOS_HAS_USERESSCHEDULER__, true));
			options.add(new AutoOptions(currentRtosPrefix, "STARTUPSYNC", "TRUE", OsekConstants.DEF__OSEKOS_HAS_STARTUPSYNC__, true));

			AutoOptions.updateKeywords(options, keywords, vt);

		}
		
	}
	
	
	
	


	
	/* (non-Javadoc)
	 * @see com.eu.evidence.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions#getEEOpt(int)
	 */
	public List<String> getEEOpt(int type, int rtosId) {
		List<String> answer = new ArrayList<String>();
	    IOilObjectList ool = rtosId >= 0 ? parent.getOilObjects()[rtosId] : null;
		
		if (!(parent.checkKeyword(IWritersKeywords.OSEK_BCC1) ||
				parent.checkKeyword(IWritersKeywords.OSEK_BCC2) ||
				parent.checkKeyword(IWritersKeywords.OSEK_ECC1) ||
				keywords.contains(IWritersKeywords.OSEK_ECC2) ||
				keywords.contains(IWritersKeywords.OSEK_SC1) ||
				keywords.contains(IWritersKeywords.OSEK_SC2) ||
				keywords.contains(IWritersKeywords.OSEK_SC3) ||
				keywords.contains(IWritersKeywords.OSEK_SC4))) {
		}
		
		
		if ((type & EE_OPT_COMMON_AUTO_ONLY) != 0) {
			/*******************************************************************
			 * AUTOMATIC OPTIONS (not CPU DEPENDENT)
			 ******************************************************************/
			{ // Extract options from current keywords
				String[][] fromKeywords = new String[][] {
						{ IWritersKeywords.OSEK_BCC1,
								"__OO_BCC1__" },
						{ IWritersKeywords.OSEK_BCC2,
								"__OO_BCC2__" },
						{ IWritersKeywords.OSEK_ECC1,
								"__OO_ECC1__" },
						{ IWritersKeywords.OSEK_ECC2,
								"__OO_ECC2__" },
						{ IWritersKeywords.OSEK_SC1,
								"__OO_SC1__" },
						{ IWritersKeywords.OSEK_SC2,
								"__OO_SC2__" },
						{ IWritersKeywords.OSEK_SC3,
								"__AS_SC3__" },
						{ IWritersKeywords.OSEK_SC4,
								"__OO_ECC2__ __AS_SC4__" },

						// -------- OSEK -------------
						{ OsekConstants.DEF__OSEKOS_EXTENDED_STATUS__,
								"__OO_EXTENDED_STATUS__" },
						{ OsekConstants.DEF__OSEKOS_HAS_STARTUPHOOK__,
								"__OO_HAS_STARTUPHOOK__" },
						{ OsekConstants.DEF__OSEKOS_HAS_ERRORHOOK__,
								"__OO_HAS_ERRORHOOK__" },
						{ OsekConstants.DEF__OSEKOS_HAS_SHUTDOWNHOOK__,
								"__OO_HAS_SHUTDOWNHOOK__" },
						{ OsekConstants.DEF__OSEKOS_HAS_PRETASKHOOK__,
								"__OO_HAS_PRETASKHOOK__" },
						{ OsekConstants.DEF__OSEKOS_HAS_POSTTASKHOOK__,
								"__OO_HAS_POSTTASKHOOK__" },
						{ OsekConstants.DEF__OSEKOS_HAS_USEGETSERVICEID__,
								"__OO_HAS_USEGETSERVICEID__" },
						{ OsekConstants.DEF__OSEKOS_HAS_USEPARAMETERACCESS__,
								"__OO_HAS_USEPARAMETERACCESS__" },
//						{ DEF__OSEKOS_HAS_USERESSCHEDULER__,
//								"__OO_HAS_USERESSCHEDULER__" },
								
								
						{ DEF__IRQ_STACK_NEEDED__, "__IRQ_STACK_NEEDED__" },

						{ DEF__MONO_STACK__, "__MONO__" },
						{ DEF__MULTI_STACK__, "__MULTI__" },

				};

				for (int i = 0; i < fromKeywords.length; i++) {
					if (parent.checkKeyword(fromKeywords[i][0])) {
					    String[] splitted = fromKeywords[i][1].split(" ");
					    for (int l=0; l<splitted.length; l++) {
					        answer.add(splitted[l]);
					    }
					}
				}

				// USE RES SCHEDULER
				if (parent.checkKeyword(DEF__OS_HAS_USERESSCHEDULER__)) {
				    answer.add("__OO_HAS_USERESSCHEDULER__");
			    }


			}
			
		}


		if (ool != null && (type & EE_OPT_CPU_ONLY) != 0) {
			/*******************************************************************
			 * AUTOMATIC OPTIONS (not CPU DEPENDENT)
			 ******************************************************************/
		    ISimpleGenRes sgrCpu = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
			List<Integer> requiredOilObjects = (List<Integer>) sgrCpu.getObject(SGRK__FORCE_ARRAYS_LIST__);

//			boolean supportNestedIRQ = CpuUtility.getSupportForNestedIRQ(sgrCpu);

			
			// from Oil Object List
			// ... alarm
			if (ool.getList(IOilObjectList.ALARM).size() == 0 
					&& !requiredOilObjects.contains(new Integer(IOilObjectList.ALARM))) {
				answer.add("__OO_NO_ALARMS__");
			}

			// ... resource
			if (ool.getList(IOilObjectList.RESOURCE).size() == 0
					&& !requiredOilObjects.contains(new Integer(IOilObjectList.RESOURCE))) {
				answer.add("__OO_NO_RESOURCES__");
			}
			
			if (parent.checkKeyword(IWritersKeywords.OSEK_ECC1) 
				|| parent.checkKeyword(IWritersKeywords.OSEK_ECC2)) {
				if (ool.getList(IOilObjectList.EVENT).size() == 0
						&& !requiredOilObjects.contains(new Integer(IOilObjectList.EVENT))) {
					answer.add("__OO_NO_EVENTS__");
				}
			}
			

			{ // ... autostart
				ISimpleGenRes os = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);

				if (os.containsProperty(ISimpleGenResKeywords.OSEK_TASK_AUTOSTART) && "true".equalsIgnoreCase(os
						.getString(ISimpleGenResKeywords.OSEK_TASK_AUTOSTART))) {
					
					answer.add("__OO_AUTOSTART_TASK__");
				}

				if (os.containsProperty(ISimpleGenResKeywords.OSEK_ALARM_AUTOSTART) && "true".equalsIgnoreCase(os
						.getString(ISimpleGenResKeywords.OSEK_ALARM_AUTOSTART))) {
					
					answer.add("__OO_AUTOSTART_ALARM__");
				}

			}
			
			// USE RES SCHEDULER
			if (CpuUtility.getSupportForNestedIRQ(sgrCpu)
					// always enabled for an osek system (if supported by HW)
					// && parent.checkKeyword(DEF__ALLOW_NESTED_IRQ__)
					) {
			    answer.add( "__ALLOW_NESTED_IRQ__" );
		    }
		}


		return answer;
	}
}
