/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterKernelFP.java,v 1.8 2008/05/14 17:14:03 durin Exp $
 */
package com.eu.evidence.rtdruid.hidden.modules.oil.codewriter.erikaenterprise;

import static com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter.getOsProperty;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.AutoOptions;
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
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * This writer build files for a FP Kernel
 * 
 * @author Nicola Serreli
 */
public class SectionWriterKernelFP extends SectionWriter implements
		IEEWriterKeywords, IExtractKeywordsExtentions, IGetEEOPTExtentions {
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;

	/**
	 * 
	 */
	public SectionWriterKernelFP() {
		this(null);
	}
	/**
	 * 
	 */
	public SectionWriterKernelFP(ErikaEnterpriseWriter parent) {
		super(IWritersKeywords.FP,
				new String[] {}, //
				new String[] { //
					IWritersKeywords.OSEK_BCC1, //
					IWritersKeywords.OSEK_BCC2, //
					IWritersKeywords.OSEK_ECC1, //
					IWritersKeywords.OSEK_ECC2, //
					IWritersKeywords.SRPT, //
					IWritersKeywords.CBS, //
					IWritersKeywords.IRIS, //
					IWritersKeywords.EDF //
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
					indent1 + commentWriterC.writerSingleLineComment("dispatch priority") + //\n" +
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
					 * --------------- WRITE VALUES ---------------
					 * 
					 * Append the correct value to all buffers
					 */
					EE_th_ready_prioBuffer.append(pre + post + indent2 + prio + "U");
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
//				+ indent1 + commentWriterC.writerSingleLineComment("ip of each thread body (ROM)") //\n"
//				+ indent1 + "const EE_FADDR EE_terminate_real_th_body["+MAX_TASK+"] = {\n"
//				+ sbThread.toString() + "\n"
//				+ indent1 + "};\n");
		
			buffer.append(EE_th_ready_prioBuffer);
			buffer.append(EE_th_dispatch_prioBuffer);
		
			/*
			 * EE_th_status
			 */
			buffer.append(indent1 + commentWriterC.writerSingleLineComment("thread status")); //\n");
		
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
					 * Call back functions
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

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.IExtractKeywordsExtentions#updateKeywords(java.util.ArrayList, java.lang.String[])
	 */
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix)
			throws OilCodeWriterException {

		final IVarTree vt = parent.getVt();

		for (int rtodId=0; rtodId<rtosPrefix.length; rtodId++) {

			final String currentRtosPrefix = parent.computeOilRtosPrefix(rtosPrefix[rtodId]);
		
			/*******************************************************************
			 * KERNEL TYPE
			 ******************************************************************/
			// check only the first RTOS !!! (as rtos of CPU0)
			String[] child = new String[1];
			String kernel_type = CommonUtils.getFirstChildEnumType(vt,
					currentRtosPrefix + "KERNEL_TYPE", child);

			List<AutoOptions> options = new ArrayList<AutoOptions>();
			
			// add DEF__ALLOW_NESTED_IRQ__ for FP or SRPT
			if ("FP".equals(kernel_type) || "SRPT".equals(kernel_type)) {
				String path = currentRtosPrefix + "KERNEL_TYPE" + VARIANT_ELIST
						+ child[0] + PARAMETER_LIST;

				options.add(new AutoOptions(
						path, // base path
						 "NESTED_IRQ", // oil word
						 "TRUE",	// value
						 DEF__ALLOW_NESTED_IRQ__, // key
						false // default key
						));
			}
			
			if ("FP".equals(kernel_type)) {
				/*******************************************************************
				 * OS FP PARAMETER
				 ******************************************************************/
				
				options.add(new AutoOptions(
							currentRtosPrefix, // base path
							 "USERESSCHEDULER", // oil word
							 "TRUE",	// value
							DEF__OS_HAS_USERESSCHEDULER__, // key
							true // default key
							));
			}
			
			AutoOptions.updateKeywords(options, keywords, vt);

		}

	}

	
	/* (non-Javadoc)
	 * @see com.eu.evidence.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions#getEEOpt(int)
	 */
	public List<String> getEEOpt(int type, int rtosId) {
		List<String> answer = new ArrayList<String>();
	    IOilObjectList ool = rtosId >= 0 ? parent.getOilObjects()[rtosId] : null;
		
		if (!(parent.checkKeyword(IWritersKeywords.FP))) {
			return answer;
		}
		
		
		if ((type & EE_OPT_COMMON_AUTO_ONLY) != 0) {
			/*******************************************************************
			 * AUTOMATIC OPTIONS (not CPU DEPENDENT)
			 ******************************************************************/

			{ // Extract options from current keywords
				String[][] fromKeywords = new String[][] {
						// -------- KERNEL -------------
						{ IWritersKeywords.FP, "__FP__" },
								
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
				
			}
			
		}


		if (ool != null && (type & EE_OPT_CPU_ONLY) != 0) {
			/*******************************************************************
			 * AUTOMATIC OPTIONS (not CPU DEPENDENT)
			 ******************************************************************/
			List<Integer> requiredOilObjects = (List<Integer>) AbstractRtosWriter.getOsObject(ool, SGRK__FORCE_ARRAYS_LIST__);

			// from Oil Object List
			// ... alarm
			if (ool.getList(IOilObjectList.ALARM).size() > 0 
					|| requiredOilObjects.contains(new Integer(IOilObjectList.ALARM))) {
				answer.add("__ALARMS__");
			}

			// ... resource
			if (ool.getList(IOilObjectList.RESOURCE).size() == 0
					&& !requiredOilObjects.contains(new Integer(IOilObjectList.RESOURCE))) {
				answer.add("__FP_NO_RESOURCE__");
			}

			{ // ... autostart
				if ("true".equalsIgnoreCase(getOsProperty(ool, ISimpleGenResKeywords.OSEK_TASK_AUTOSTART))) {
					
					answer.add("__OO_AUTOSTART_TASK__");
				}

				if ("true".equalsIgnoreCase(getOsProperty(ool, ISimpleGenResKeywords.OSEK_ALARM_AUTOSTART))) {
					
					answer.add("__OO_AUTOSTART_ALARM__");
				}

			}
			
			// ... nested IRQ
			if (CpuUtility.getSupportForNestedIRQ(ool) 
					&& parent.checkKeyword(DEF__ALLOW_NESTED_IRQ__)) {
				answer.add("__ALLOW_NESTED_IRQ__");
			}
			
		}

		return answer;
	}


}
