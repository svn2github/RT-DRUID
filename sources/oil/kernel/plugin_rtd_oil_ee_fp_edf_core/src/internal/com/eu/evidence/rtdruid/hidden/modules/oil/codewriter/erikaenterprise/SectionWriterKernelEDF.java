/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterKernelEDF.java,v 1.6 2008/06/09 10:29:32 durin Exp $
 */
package com.eu.evidence.rtdruid.hidden.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuUtility;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EECpuDescriptionManager;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilObjectType;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

/**
 * This writer build files for a EDF Kernel
 * 
 * @author Nicola Serreli
 */
public class SectionWriterKernelEDF extends SectionWriter
		implements IEEWriterKeywords,
					IExtractObjectsExtentions,
					IExtractKeywordsExtentions {
	
	/**
	 * The deadline length writed inside the oil file (note : the value is a
	 * TimeVar if it was a time, otherwise is an Integer that contains directly
	 * the number of tick)
	 */
	final static String EDF_TASK_OIL_VALUE = "Kernel_EDF_keywords__task_deadline__by_user";
	
	/**
	 * The deadline length computed as a number of ticks
	 */
	final static String EDF_TASK_COMPUTED_DEADLINE = "Kernel_EDF_keywords__task_computed_deadline";
	
	/**
	 * The tick length writed inside the oil file (note : the value is a
	 * TimeVar)
	 */
	final static String EDF_RTOS_TICK_LENGTH = "Kernel_EDF_keywords__os_tick_length";
	
	/**
	 * Identifies the option related the place where store relative deadlines
	 * inside ram or rom (inside OS objects).
	 * 
	 */
	final static String EDF_OS_REL_DEADLINES_IN_RAM = "iris_os_relative_deadlines_stored_in_ram";
	
	/**
	 * Means "store store relative deadlines inside ram".
	 * 
	 * see EDF_OS_REL_DEADLINES_IN_RAM.
	 * 
	 */
	final static String EDF_OS_REL_DEADLINES_IN_RAM_value_ram = "ram";
	
	/**
	 * Means "store store relative deadlines inside rom".
	 * 
	 * see EDF_OS_REL_DEADLINES_IN_RAM.
	 * 
	 */
	final static String EDF_OS_REL_DEADLINES_IN_RAM_value_rom = "rom";
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;
	
	/**
	 * 
	 */
	public SectionWriterKernelEDF() {
		this(null);
	}
	/**
	 * 
	 */
	public SectionWriterKernelEDF(ErikaEnterpriseWriter parent) {
		super(IWritersKeywords.EDF,
				new String[] {}, //
				new String[] { //
					IWritersKeywords.OSEK_BCC1, //
					IWritersKeywords.OSEK_BCC2, //
					IWritersKeywords.OSEK_ECC1, //
					IWritersKeywords.OSEK_ECC2, //
					IWritersKeywords.CBS, //
					IWritersKeywords.IRIS, //
					IWritersKeywords.FP, //
					IWritersKeywords.SRPT //
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
		ErikaEnterpriseWriter.appendBuffers(tmp, writeFP_Kernel());

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
	protected IOilWriterBuffer[] writeFP_Kernel()
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
		final String MAX_APPMODE = (binaryDistr ? "RTD_" : "EE_") + "MAX_APPMODE";
		final String MAX_COUNTER = (binaryDistr ? "RTD_" : "EE_") + "MAX_COUNTER";
		final String MAX_TASK = (binaryDistr ? "RTD_" : "EE_") + "MAX_TASK";
		final String MAX_RESOURCE = (binaryDistr ? "RTD_" : "EE_") + "MAX_RESOURCE";
		
		
		/* indentxxx contains some white spaces for indent the output */
		final String indent1 = IWritersKeywords.INDENT;
		final String indent2 = indent1 + IWritersKeywords.INDENT;
		final String indent3 = indent2 + IWritersKeywords.INDENT;
		//final String indent4 = indent3 + WritersKeys.INDENT;
		
		
		// number of rtos
		final int rtosNumber = oilObjects.length;

		CpuHwDescription currentStackDescription = null;
		{
			// usw thw cpu type of first cpu (all cpus have the same type) 
			String cpuType = AbstractRtosWriter.getOsProperty(oilObjects[0], ISimpleGenResKeywords.OS_CPU_TYPE);
			currentStackDescription = EECpuDescriptionManager.getHWDescription(cpuType); 
		}

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
			List<Integer> requiredOilObjects = (List<Integer>) AbstractRtosWriter.getOsObject(ool, SGRK__FORCE_ARRAYS_LIST__);
			final ICommentWriter commentWriterC = getCommentWriter(ool, FileTypes.C);

			StringBuffer buffer = answer[rtosId].get(FILE_EE_CFG_C);

			
			// ---------------------------------------------------
			
			buffer.append(
					"#include \"ee.h\"\n"
					+ commentWriterC.writerBanner("Kernel ( CPU " + rtosId
							+ " )"));
		
		
			// ready priority of each task (one row for each task)
			StringBuffer EE_th_ready_prioBuffer = new StringBuffer(
					indent1 + commentWriterC.writerSingleLineComment("ready priority") + //\n" +
					indent1 + "const EE_TYPEPRIO EE_th_ready_prio["+MAX_TASK+"] = {\n");
			
			StringBuffer EE_th_dispatch_prioBuffer = new StringBuffer(
					indent1 + commentWriterC.writerSingleLineComment("dispatch priority") + // */\n" +
					indent1 + "const EE_TYPEPRIO EE_th_dispatch_prio["+MAX_TASK+"] = {\n");

//			// buffer for th_status
//			StringBuffer EE_th_statusBuffer = new StringBuffer(indent1
//					+ "EE_TYPEPRIO EE_th_status["+MAX_TASK+"] = {\n");

			// buffer for th_rnact (one row for each task)
			StringBuffer EE_th_nactBuffer = new StringBuffer(indent1
//					+ "EE_TYPEPRIO EE_th_nact["+MAX_TASK+"] = {\n");
					+ "EE_TYPEPRIO EE_th_nact["+MAX_TASK+"];\n");
			
//			// buffer for th_rnact (one row for each task)
//			StringBuffer EE_th_nextBuffer = new StringBuffer(indent1
//					+ "EE_TYPEPRIO EE_th_next["+MAX_TASK+"] = {\n");

		
			/* Contains task's address */
//			StringBuffer sbThread = new StringBuffer();
			/* Contains task's declarations */
			StringBuffer sbDecThread = new StringBuffer();
			/* Contains task's stubs */
			StringBuffer sbStub = new StringBuffer();

			/* Contains Task's Deadlines */
			StringBuffer sbDLThread = new StringBuffer();

			// ------------------ fill buffers ------------------
		
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
					id = currTask
							.getInt(ISimpleGenResKeywords.TASK_DISPATCH_PRIORITY);
					String dspPrio = "0x"
							+ (Integer.toHexString(id)).toUpperCase();

					/*
					 * DEADLINE.
					 * 
					 * dl contains the deadline, computed in "tick" as a String (0x....)
					 */
					String dl = currTask
							.getString(EDF_TASK_COMPUTED_DEADLINE);
		
					/*
					 * --------------- WRITE VALUES ---------------
					 * 
					 * Append the correct value to all buffers
					 */
					EE_th_ready_prioBuffer.append(pre + post + indent2 + prio + "U");
					sbDLThread.append(pre + post + indent2 + dl);
					EE_th_dispatch_prioBuffer.append(pre + post + indent2
							+ dspPrio + "U");
					//EE_th_nactBuffer.append(pre + post + indent2 + "0");
		
					sbDecThread.append(pre2 + indent1 + "DeclareTask(" + tname + ");");
//					sbThread.append(pre + pre2 + indent2 + "(EE_ADDR)Func"
//							+ tname);
					sbStub.append(pre + post + indent2
							+ "&Func" + tname);
					pre2 = "\n";
		
					pre = ",";
					post = "\t\t" + commentWriterC.writerSingleLineComment("thread " + tname); // + " */\n";
		
					numTask++;
				}
			}
		
			/* Complete all buffers */
			sbDLThread.append(" " + post);
			EE_th_ready_prioBuffer.append(" " + post + indent1 + "};\n\n");
			EE_th_dispatch_prioBuffer.append(" " + post + indent1 + "};\n\n");
			//EE_th_nactBuffer.append(post + indent1 + "};\n\n");
			sbStub.append(" " + post);
		
			/*******************************************************************
			 * WRITE BUFFERS
			 ******************************************************************/
		
			// declare task and theirs address
			buffer.append(indent1 + commentWriterC.writerSingleLineComment("Definition of task's body") //\n"
				+ sbDecThread + "\n\n"
				+ indent1 + "const EE_THREAD_PTR EE_hal_thread_body["+MAX_TASK+"] = {\n"
				+ sbStub + "\n"
				+ indent1 + "};\n\n");
//				+ indent1 + "EE_UINT32 EE_terminate_data["+MAX_TASK+"];\n\n"
//				+ indent1 + commentWriterC.writerSingleLineComment("p of each thread body (ROM)") //\n"
//				+ indent1 + "const EE_FADDR EE_terminate_real_th_body["+MAX_TASK+"] = {\n"
//				+ sbThread.toString() + "\n"
//				+ indent1 + "};\n");
		
			buffer.append(EE_th_ready_prioBuffer);
			buffer.append(EE_th_dispatch_prioBuffer);
		
			/*
			 * EE_th_status
			 */
			buffer.append(indent1 + commentWriterC.writerSingleLineComment("thread status")); // \n");
		
			buffer.append(indent1 + "#if defined(__MULTI__) || defined(__WITH_STATUS__)\n" +
					indent2 + "EE_TYPESTATUS EE_th_status["+MAX_TASK+"] = {\n");
			pre2 = "";
			for (int i = 0; i < numTask; i++) {
				buffer.append(pre2 + indent3 + "EE_READY");
				pre2 = ",\n";
			}
			buffer.append("\n" + indent2 + "};\n" +
					indent1 + "#endif\n\n");
		
			/*
			 * EE_th_next
			 */
			buffer.append(indent1 + commentWriterC.writerSingleLineComment("next thread") //\n" 
					+ indent1 + "EE_TID EE_th_next["+MAX_TASK+"] = {\n");
			pre2 = "";
			for (int i = 0; i < numTask; i++) {
				buffer.append(pre2 + indent2 + "EE_NIL");
				pre2 = ",\n";
			}
			buffer.append("\n" + indent1 + "};\n\n");
		
			buffer.append(EE_th_nactBuffer);
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
			buffer.append(indent1 + commentWriterC.writerSingleLineComment("system ceiling") // */\n"
					+ indent1 + "EE_TYPEPRIO EE_sys_ceiling= 0x0000U;\n\n");
		

			/*
			 * DeadLines
			 */
			String enable_dline_const = 
						EDF_OS_REL_DEADLINES_IN_RAM_value_ram.equals(AbstractRtosWriter.getOsProperty(ool, EDF_OS_REL_DEADLINES_IN_RAM)) ?
								"" : "const ";

			buffer.append(indent1 + commentWriterC.writerSingleLineComment("deadlines") //\n"
					+ indent1 + enable_dline_const + "EE_TYPERELDLINE EE_th_reldline["+MAX_TASK+"] = {\n"
					+ sbDLThread
					+ indent1 + "};\n"
					+ indent1 + "EE_TYPEABSDLINE EE_th_absdline["+MAX_TASK+"];\n\n");
			
			
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
						post = "\t\t"+commentWriterC.writerSingleLineComment("resource " + name); //+ " */\n";
						pre2 = ",";
					}
					buffer.append(" " + post + indent1 + "};\n\n");

					
					// OLD ceiling
					buffer.append(indent1
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
					 * Function CallBack
					 */
					LinkedList<String> callback_functions = new LinkedList<String>();

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
		
		}
		

		return answer;
	}

	public void updateObjects() throws OilCodeWriterException{
		if (!parent.checkKeyword(IWritersKeywords.EDF)) {
			return;
		}
		
		// NOTE : EDF works only on a single processor system
		final int currentRtosId = 0;

		TimeVar ticsLength = null;
		
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		final IVarTree vt = parent.getVt();
		final IOilObjectList ool = oilObjects[currentRtosId];
		
		final long timerSize_bits;
		{
			CpuHwDescription currentStackDescription = ErikaEnterpriseWriter.getCpuHwDescription(ool);
			if (currentStackDescription != null) {
				timerSize_bits = currentStackDescription.timerSize; 
			} else {
				timerSize_bits = 32;
			}
		}
		final long timerSize = 1l<<timerSize_bits; 
		
		boolean store_dl_in_ram = false;


		for (ISimpleGenRes sgrOs: ool.getList(IOilObjectList.OS)){// search the RTOS 
	
			final String currentRtosPrefix = sgrOs.getPath();
	
			// check only the first RTOS !!! (as rtos of CPU0)
			String[] child = new String[1];
			String oilVarPrefix = currentRtosPrefix + S 
					+ (new OilPath(OilObjectType.OS, null)).getPath();
		
			String kernel_type = CommonUtils.getFirstChildEnumType(vt,
					 oilVarPrefix + "KERNEL_TYPE", child);
			
			if (kernel_type != null && "EDF".equals(kernel_type)) {

				{ // TICK LENGTH
					
					String[] val = CommonUtils
							.getValue(vt, oilVarPrefix +S
									+ "KERNEL_TYPE" + VARIANT_ELIST + child[0]
									+ PARAMETER_LIST + "TICK_TIME");
	
					TimeVar var;
					if (val != null && val.length >0) {
						try {
							var = new TimeVar(val[0]);
						} catch (RuntimeException e) {
							throw new OilCodeWriterException("The TICK_TIME value inside the EDF section is not a valid 'time value'.");
						}
					} else {
						throw new OilCodeWriterException("Required a TICK_TIME.");
					}
					
					sgrOs.setObject(EDF_RTOS_TICK_LENGTH, var);
					ticsLength = var;
				}	
				
				{	// DEADLINES
					
					final String param = "REL_DEADLINES_IN_RAM";
					
					String dl_option_prefix = oilVarPrefix +S
							+ "KERNEL_TYPE" + VARIANT_ELIST + child[0]
					    	+ PARAMETER_LIST + param;
					
					ArrayList<String> tmpType = CommonUtils.getAllChildrenEnumType(vt, dl_option_prefix, null);
					
					store_dl_in_ram = false; // default value
					if (tmpType != null) {
						if (tmpType.size()==1) {
							if ("true".equalsIgnoreCase(tmpType.get(0))) {
								store_dl_in_ram = true;
							}
						} else if (tmpType.size()>1) {
							Messages.sendWarning("Found more than one value for " + param, null, null, null);
						}
					}
					
					sgrOs.setProperty(
									EDF_OS_REL_DEADLINES_IN_RAM,
									store_dl_in_ram ? EDF_OS_REL_DEADLINES_IN_RAM_value_ram
											: EDF_OS_REL_DEADLINES_IN_RAM_value_rom);
				}

			} else {
				throw new Error("Required EDF");
			}
		}

		/***********************************************************************
		 * 
		 * Get task Deadlines && compute theirs DeadLines (in ticks)
		 *  
		 **********************************************************************/
		{
			final double tics = ticsLength == null ? -1 : ((Double) ticsLength.get()).doubleValue();
			final int timeType = ticsLength.getType();

			
			List<ISimpleGenRes> tasks = ool.getList(IOilObjectList.TASK);
			for (Iterator<ISimpleGenRes> iter = tasks.iterator(); iter.hasNext();) {

				ISimpleGenRes currTask = (ISimpleGenRes) iter.next();

				String oilVarPrefix = (new OilPath(OilObjectType.TASK, null)).getPath();

				String deadLinePath = currTask.getPath() + S + oilVarPrefix + S
						+ "REL_DEADLINE" ;

				String[] values = CommonUtils.getValue(vt, deadLinePath);

				Object var = null;
				if (values != null && values.length >0) {
					try {
						var = new Long(values[0]);
					} catch (RuntimeException e) {
						// ignore the error
					}
					
					if (var == null) {
						try {
							var = new TimeVar(values[0]);
						} catch (RuntimeException e) {
							throw new OilCodeWriterException("The REL_DEADLINE value inside the task "
									+currTask.getName()+" is not neither a valid 'time value' or a valid 'integer'.");
						}
					}
				} else {
					throw new OilCodeWriterException("Required a REL_DEADLINE for the task "+currTask.getName()+".");
				}
				
				currTask.setObject(EDF_TASK_OIL_VALUE, var);
				
				if (var instanceof Long) {
					
					long tick_dl = ((Long) var).longValue();
					if (tick_dl >= timerSize) {
						throw new OilCodeWriterException("The REL_DEADLINE for the task "+currTask.getName()+" is too big: given value is "+
								tick_dl+" (doesn't fit in "+timerSize_bits+" bits).");
					}
					currTask.setProperty(EDF_TASK_COMPUTED_DEADLINE, var.toString());
				} else {
					
					
					TimeVar t_var = (TimeVar) ((TimeVar) var).clone(); // modify a different one
					t_var.setType(timeType);
					double val = ((Double) t_var.get()).doubleValue();
					
					long tick_dl = (long) Math.floor(val/tics);
					if (tick_dl >= timerSize) {
						throw new OilCodeWriterException("The REL_DEADLINE for the task "+currTask.getName()+" is too big: computed value is "+
								tick_dl+" (doesn't fit in "+timerSize_bits+" bits).");
					}
					currTask.setProperty(EDF_TASK_COMPUTED_DEADLINE, ""+tick_dl);
					
				}
				
			}

		}		
			


		{ // EE_OPT
			ISimpleGenRes sgrOs = ool.getList(IOilObjectList.OS).get(0);
			String[] lista = sgrOs.containsProperty(ISimpleGenResKeywords.OS_CPU_EE_OPTS) ?
					(String[]) sgrOs.getObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS) :
						new String[0];
			ArrayList<String> array = new ArrayList<String>(Arrays.asList(lista));
			array.add("__EDF__");
			array.add("__ALARMS__");

			if (store_dl_in_ram) {
				array.add("__REL_DEADLINES_IN_RAM__");
			}
			

			{ // Extract options from current keywords
				String[][] fromKeywords = new String[][] {
						// -------- KERNEL -------------
						{ DEF__IRQ_STACK_NEEDED__, "__IRQ_STACK_NEEDED__" },
						
						{ DEF__MONO_STACK__, "__MONO__" },
						{ DEF__MULTI_STACK__, "__MULTI__" },
				};

				for (int i = 0; i < fromKeywords.length; i++) {
					if (parent.checkKeyword(fromKeywords[i][0])) {
					    String[] splitted = fromKeywords[i][1].split(" ");
					    for (int l=0; l<splitted.length; l++) {
					    	array.add(splitted[l]);
					    }
					}
				}
				
				if (CpuUtility.getSupportForNestedIRQ(ool) 
						&& parent.checkKeyword(DEF__ALLOW_NESTED_IRQ__)) {
					array.add("__ALLOW_NESTED_IRQ__");
				}
			}

			sgrOs.setObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS, array.toArray(new String[array.size()]));
		}
		
		

		{// force alarms
			List<Integer> array = null;
			for (ISimpleGenRes sgrOs : ool.getList(IOilObjectList.OS)) {
				if (array == null) {
					if (sgrOs.containsProperty(ErikaEnterpriseWriter.SGRK__FORCE_ARRAYS_LIST__)) {
						array = (List<Integer>) sgrOs.getObject(ErikaEnterpriseWriter.SGRK__FORCE_ARRAYS_LIST__);

						if (array != null && !array.contains(new Integer(IOilObjectList.ALARM))) { 
							array = new ArrayList<Integer>(array);
							array.add(new Integer(IOilObjectList.ALARM));
							sgrOs.setObject(ErikaEnterpriseWriter.SGRK__FORCE_ARRAYS_LIST__, array);
						}
					}
				}
			}
			if (array == null) {
				array = new ArrayList<Integer>();
				ool.getList(IOilObjectList.OS).get(0).setObject(ErikaEnterpriseWriter.SGRK__FORCE_ARRAYS_LIST__, array);
			}
			
		}

	}


		
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.hidden.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter.IExtractKeywordsExtentions#updateKeywords(java.util.ArrayList)
	 */
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix) throws OilCodeWriterException {

		if (!keywords.contains(IWritersKeywords.EDF)) {
			return;
		}

		final IVarTree vt = parent.getVt();

		//final ArrayList ee_opts = new ArrayList();
		for (int i=0; i<rtosPrefix.length; i++) {
			// check only the first RTOS !!! (as rtos of CPU0)
			String[] child = new String[1];
			
			String path = parent.computeOilRtosPrefix(rtosPrefix[i]) + "KERNEL_TYPE";;

			String kernel_type = CommonUtils.getFirstChildEnumType(vt, path
					 , child);

			if (kernel_type != null && "EDF".equals(kernel_type)) {

				boolean ok = "TRUE".equalsIgnoreCase(CommonUtils
						.getFirstChildEnumType(vt, path+ VARIANT_ELIST + child[0]
								+ PARAMETER_LIST + "NESTED_IRQ"));

				if (ok && !keywords.contains(DEF__ALLOW_NESTED_IRQ__)) {
					keywords.add(DEF__ALLOW_NESTED_IRQ__);
				}

			}
			
		}
	}


}
