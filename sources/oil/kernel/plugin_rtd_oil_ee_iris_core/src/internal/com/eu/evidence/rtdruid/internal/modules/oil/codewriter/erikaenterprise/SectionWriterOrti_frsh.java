/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterOrti.java,v 1.2 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

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
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStackData;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * This writer build files for a FP Kernel
 * 
 * @author Nicola Serreli
 */
public class SectionWriterOrti_frsh extends SectionWriter implements
		IEEWriterKeywords, IExtractKeywordsExtentions, IExtractObjectsExtentions {
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;

	/** All data */
	protected final IVarTree vt;
	
	/** Current orti options (enabled by keyword ENABLE_ORTI) : a bits field 
	 *
	 * @deprecated attenzione: potrebbe venir persa tra una chiamata ed un'altra?
	 */
	protected int EE_ORTI_current = 0;

	public SectionWriterOrti_frsh() {
		this(null);
	}

	/**
	 * 
	 */
	public SectionWriterOrti_frsh(ErikaEnterpriseWriter parent) {
		super(IWritersKeywords.ENABLE_ORTI,
				new String[] {}, //
				new String[] {},
				SWCategoryManager.defaultInstance.newCategory(SWCategoryManager.TYPE_OTHERS));
		
		this.parent = parent;
		this.vt = parent != null ? parent.getVt() : null;
	}
	
	/**
	 * This method returns true if current instance of writer is enabled with
	 * specified keywords.
	 * 
	 * @return true if this writer is enabled
	 */
	protected boolean enabled() {

		return super.enabled() && (Collections.binarySearch(keywords, IWritersKeywords.FRSH) >= 0);
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
		
		return writeOrti();
	}

	
	/**
	 * Write Configuration's file for Orti
	 *
	 * @return buffers with configuration for Orti
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeOrti()
			throws OilCodeWriterException {


		final IOilObjectList[] oilObjects = parent.getOilObjects();
		IOilWriterBuffer[] answer = new IOilWriterBuffer[oilObjects.length];
		
		/* indentxxx contains some white spaces for indent the output */
		final String indent1 = IWritersKeywords.INDENT;
		final String indent2 = indent1 + IWritersKeywords.INDENT;
		//final String indent3 = indent2 + IWritersKeywords.INDENT;
		//final String indent4 = indent3 + WritersKeys.INDENT;
		
		// number of rtos
		final int rtosNumber = oilObjects.length;
		
		/***********************************************************************
		 * prepare and write buffers for All OS
		 **********************************************************************/
		for (int rtosId = 0; rtosId < rtosNumber; rtosId++) {

			// ------------------ common data ------------------

			// all objects for current os
			IOilObjectList ool = oilObjects[rtosId];
			List<String> requiredOilObjects = (List<String>) AbstractRtosWriter.getOsObject(ool, SGRK__FORCE_ARRAYS_LIST__);
			final ICommentWriter commentWriterOrti = getCommentWriter(ool, FileTypes.ORTI);

			if (answer[rtosId] == null) {
				answer[rtosId] = new OilWriterBuffer();
			}

			StringBuffer eeortiBuffer = answer[rtosId].get(FrshOrtiConstants.FILE_EE_ORTI);
			
//			StringBuffer eecfgBuffer = answer[rtosId].get(FILE_EE_CFG_C);
			
			/*******************************************************************
			 * 
			 * DECLARATION SECTION
			 *  
			 ******************************************************************/
			
//			eecfgBuffer.append(
//					CommonUtils.writerBannerC("ORTI") +
//					indent1 + "#include \"ee.h\"\n\n" +
//					indent1 + "#ifdef __OO_ORTI_LASTERROR__\n" +
//					indent2 + "StatusType EE_ORTI_lasterror = E_OK;\n" +
//					indent1 + "#endif\n\n" +
//					indent1 + "#ifdef __OO_ORTI_SERVICETRACE__\n" +
//					indent2 + "volatile EE_UINT8 EE_ORTI_servicetrace;\n" +
//					indent1 + "#endif\n\n"
//					#ifdef __OO_ORTI_RUNNINGISR2__
//					/* this variable stores 0 if no ISR is running, or the address of the ISR stub
//					   generated for the particular ISR handler */
//					EE_ADDR EE_ORTI_runningisr2 = (EE_ADDR)0;
//					#endif
//				);

			StringBuffer all_task_id = new StringBuffer("            \"NO_TASK\" = \"-1\"");
			StringBuffer all_priorities = new StringBuffer("            \"Not Running (0)\" = 0");
			StringBuffer all_appmodes_id = new StringBuffer();
			StringBuffer all_stack_id = new StringBuffer();
			
			{ // priorities and task ID
				BitSet priorities = new BitSet();
				/* TASK */
				for (Iterator iter = ool.getList(IOilObjectList.TASK).iterator(); iter.hasNext();) {
	
					ISimpleGenRes currTask = (ISimpleGenRes) iter.next();
	
					/* ID */
					String tname = currTask.getName();
					all_task_id.append(",\n            \"" +
							tname + "\" = " + 
							currTask.getString(ISimpleGenResKeywords.TASK_SYS_ID)); 
	
					/* READY_PRIORITY. */
					int id = currTask
							.getInt(ISimpleGenResKeywords.TASK_READY_PRIORITY);
					priorities.set(id);
	
				}
				all_task_id.append("\n");
	
				// fill priorities
				for (int i=priorities.nextSetBit(0); i>=0; i=priorities.nextSetBit(i+1)) {
					String prio = "0x"
						+ (Integer.toHexString(i)).toUpperCase();
	
					all_priorities.append(",\n"+
							"            \""+prio+"\" = "+prio); 
				}
				all_priorities.append("\n");
			}
			
			{
				
				List<ISimpleGenRes> appmodeList = ool.getList(IOilObjectList.APPMODE);
				int id = "true".equalsIgnoreCase(AbstractRtosWriter.getOsProperty(ool, ISimpleGenResKeywords.OSEK_AUTOSTART)) ? 1 : 0;

				if (id == 1) { // add default mode
					all_appmodes_id.append("            \"OSDEFAULTAPPMODE\" = 0");
				}
				
				final int appNumber = ool.getList(IOilObjectList.APPMODE).size() + id; 

				for (Iterator<ISimpleGenRes> iter = appmodeList.iterator(); iter.hasNext(); id++) {
					ISimpleGenRes curr = (ISimpleGenRes) iter.next();
					if (!IWritersKeywords.defaultAppMode.equals(curr.getName())) {
						all_appmodes_id.append(",\n" +
								"            \"" + curr.getName()+ "\" = "+ id);
					}
				}
				
				all_appmodes_id.append("\n");
			}
			
			{
				EEStackData[] stacks = ErikaEnterpriseWriter.checkOrDefault((EEStackData[]) AbstractRtosWriter.getOsObject(ool, SGRK_OS_STACK_LIST), new EEStackData[0]);
				if (stacks != null) {
					String pre = "";
					if (stacks != null) {
						for (int i=0; i<stacks.length; i++) {
							all_stack_id.append(pre + "            \"Stack"+i+"\" : Stack"+i+" = "+i);
							pre = ",\n";
						}
						if (all_stack_id.length()>0) all_stack_id.append("\n");
					}
				}
			}
			
			// all contracts
			StringBuffer all_contracts_id = new StringBuffer("            \"NO_VRES\" = \"-1\"");
			StringBuffer all_contracts_deff = new StringBuffer();
			{
				LinkedHashMap<String, SectionWriterKernelFRSH.Contract> cts = (LinkedHashMap<String, SectionWriterKernelFRSH.Contract>) AbstractRtosWriter.getOsObject(ool, SectionWriterKernelFRSH.FRSH_OS_CONTRACT_LIST);

				Collection<SectionWriterKernelFRSH.Contract> list = cts.values();
				int i=0;
				for (Iterator<SectionWriterKernelFRSH.Contract> iter = list.iterator(); iter.hasNext();) {

					SectionWriterKernelFRSH.Contract ct = (SectionWriterKernelFRSH.Contract) iter.next(); 
					all_contracts_id.append(",\n            \"" +
							ct.name + "\" = " + 
							i);
					i++;
				}
				all_contracts_deff.append(all_contracts_id + ",\n"
						+ "            \"UNBIND\" = 7\n");
				all_contracts_id.append("\n");
			}
			
			eeortiBuffer.append(
				commentWriterOrti.writerBanner("ORTI: Declaration Section ( CPU " + rtosId + " )")+
				"VERSION {\n" + 
				"    KOIL = \"2.1\";\n" + 
				"    OSSEMANTICS = \"ORTI\", \"2.1\";\n" + 
				"};\n" + 
				"\n" + 
				"IMPLEMENTATION EE_cpu_"+rtosId+" {\n" + 
				"    OS {\n" + 
				"\n" + 
				"    /* here for each task a small description and its index */\n" + 
				"        ENUM \"int\"[\n" +
				all_task_id + 
				"        ] RUNNINGTASK, \"EXEC\";\n" + 
				"\n" + 
				"        /* EE specific data structures */\n" + 
				"        CTYPE \"unsigned int\" EE_SYSCEILING, \"Sys Ceiling\";\n" + 
				"\n" + 
				"        ENUM \"int\"[\n" +
				all_task_id + 
				"        ] EE_RQFIRST, \"ReadyQ 1st\";\n" + 
				"\n" + 
				"        ENUM \"int\"[\n" +
				all_task_id + 
				"        ] EE_STKFIRST, \"StackedQ 1st\";\n" + 
				"\n" + 

				"        ENUM \"int\"[\n" +
				all_contracts_id + 
				"        ] EE_RCGFIRST, \"RechargingQ 1st\";\n" + 
//				"\n" + 
//				"        ENUM \"int\" [\n" +
//				all_priorities +
//				"        ] RUNNINGTASKPRIORITY, \"Priority of Running Task\";\n" + 
//				"\n" + 
//				"//PJ: al momento non supportato\n" + 
//				"//        ENUM \"unsigned char\" [\n" + 
//				"//            \"NO_ISR\"    = 0,\n" + 
//				"//            \"ISR_Button\" = ISR_Button,\n" + 
//				"//            \"ISR_Timer\"  = ISR_Timer,\n" + 
//				"//        ] RUNNINGISR2, \"Running ISR2\";\n" + 
//				"\n" + 
//				"        TOTRACE ENUM \"unsigned char\" [\n" + 
//				"            \"ActivateTask\" = 2,\n" + 
//				"            \"TerminateTask\" = 4,\n" + 
//				"            \"ChainTask\" = 6,\n" + 
//				"            \"Schedule\" = 8,\n" + 
//				"            \"GetTaskID\" = 10,\n" + 
//				"            \"GetTaskState\" = 12,\n" + 
//				"            \"DisableAllInterrupts\" = 14,\n" + 
//				"            \"EnableAllInterrupts\" = 16,\n" + 
//				"            \"SuspendAllInterrupts\" = 18,\n" + 
//				"            \"ResumeAllInterrupts\" = 20,\n" + 
//				"            \"SuspendOSInterrupts\" = 22,\n" + 
//				"            \"ResumeOSInterrupts\" = 24,\n" + 
//				"            \"GetResource\" = 26,\n" + 
//				"            \"ReleaseResource\" = 28,\n" + 
//				"            \"SetEvent\" = 30,\n" + 
//				"            \"ClearEvent\" = 32,\n" + 
//				"            \"GetEvent\" = 34,\n" + 
//				"            \"WaitEvent\" = 36,\n" + 
//				"            \"GetAlarmBase\" = 38,\n" + 
//				"            \"GetAlarm\" = 40,\n" + 
//				"            \"SetRelAlarm\" = 42,\n" + 
//				"            \"SetAbsAlarm\" = 44,\n" + 
//				"            \"CancelAlarm\" = 46,\n" + 
//				"            \"GetActiveApplicationMode\" = 48,\n" + 
//				"            \"StartOS\" = 50,\n" + 
//				"            \"ShutdownOS\" = 52,\n" + 
//				"            \"ForceSchedule\" = 54,\n" + 
//				"            \"CounterTick\" = 56\n" + 
//				"        ] SERVICETRACE, \"OS Services Watch\";\n" + 
//				"\n" + 
//				"    /* please note int and not unsigned char */\n" + 
//				"        ENUM \"int\" [\n" + 
//				"            \"E_OK\" = 0,\n" + 
//				"            \"E_OS_ACCESS\" = 1,\n" + 
//				"            \"E_OS_CALLEVEL\" = 2,\n" + 
//				"            \"E_OS_ID\" = 3,\n" + 
//				"            \"E_OS_LIMIT\" = 4,\n" + 
//				"            \"E_OS_NOFUNC\" = 5,\n" + 
//				"            \"E_OS_RESOURCE\" = 6,\n" + 
//				"            \"E_OS_STATE\" = 7,\n" + 
//				"            \"E_OS_VALUE\" = 8,\n" + 
//				"            \"E_OS_SYS_INIT\" = 9\n" + 
//				"        ] LASTERROR, \"Last error\";\n" + 
//				"\n" + 
//				"        ENUM \"unsigned char\" [\n" +
//				all_appmodes_id + 
//				"        ] CURRENTAPPMODE, \"Current application mode\";\n" + 
				"    }, \"OS\";\n\n" + 

				(	(EE_ORTI_current & FrshOrtiConstants.EE_ORTI_TASK) != 0 ?
					"    TASK {\n" + 
//					"        ENUM \"int\" [\n" +
//					all_priorities +
//					"        ] PRIORITY , \"Actual Prio\";\n" + 

					"        ENUM \"unsigned int\" [\n" + 
					"            \"SUSPENDED\"= 0,\n" + 
					"            \"READY\"    = 1,\n" + 
					"            \"STACKED\"  = 2,\n" + 
					"            \"BLOCKED\"  = 4,\n" + 
					"            \"EXEC\"     = 8\n" + 
					"        ] STATE, \"Task status\";\n\n" + 
					
					"        ENUM \"int\" [\n" + 
					"            \"No\"  = 0,\n" + 
					"            \"Yes\" = 1\n" + 
					"        ] WASSTACKED, \"WasStckd\";\n\n" + 
		
					"        ENUM \"int\"[\n" +
					all_contracts_id + 
					"        ] VRES, \"VRes\";\n\n" + 
					
					"        ENUM \"int\" [\n" + 
					"            \"not avail \" = \"-1\",\n" + 
					"            \"FREEZED   \" = 0,\n" + 
					"            \"INACTIVE  \" = 1,\n" + 
					"            \"ACTIVE    \" = 2,\n" + 
					"            \"RECHARGING\" = 4\n" + 
					"        ] VRESSTATE, \"VRES status\";\n\n" + 
					
					"        CTYPE \"int\" VRESDLINE, \"VRES Dline\";\n\n" + 

					"        ENUM \"int\"[\n" +
					all_contracts_deff + 
					"        ] DEFERREDVRES, \"VRES Deferrred\";\n\n" + 

					"        ENUM \"int\" [\n" + 
					"            \"No\"  = 0,\n" + 
					"            \"Yes\" = 1\n" + 
					"        ] RESLOCKED, \"ResLocked\";\n\n" + 

					"        ENUM \"int\"[\n" +
					all_task_id + 
					"        ] NEXT, \"Next\";\n\n" +
					
					"        CTYPE \"int\" PRLEVEL, \"Prmpt.Level\";\n\n" + 
					"        CTYPE \"int\" NACT,    \"NACT\";\n\n" + 
					

					(	(EE_ORTI_current & FrshOrtiConstants.EE_ORTI_STACK) != 0 && parent.checkKeyword(DEF__MULTI_STACK__)?
						"        ENUM \"unsigned int\" [\n" +
						all_stack_id + 
						"        ] STACK, \"Task Stack\";\n" : ""
					) + 

//					"        CTYPE \"int\" CURRENTACTIVATIONS, \"Current activations\";\n" + 
					"    }, \"Tasks\";\n\n" : ""
				) + 
				(	(EE_ORTI_current & FrshOrtiConstants.EE_ORTI_STACK) != 0 ?
					"    STACK {\n" + 
					"        CTYPE SIZE, \"Stack Size (Byte)\";\n" + 
					"        CTYPE \"unsigned int *\" BASEADDRESS, \"Base Address\";\n" + 
					"        STRING STACKDIRECTION, \"Stack Direction\";\n" + 
					"        CTYPE \"unsigned int\" FILLPATTERN, \"Stack Fill Pattern\";\n" + 
					"    }, \"Stacks\";\n\n" : ""
				) + 

				
				(
					"    VRES {\n" + 
					"        ENUM \"unsigned int\" [\n" + 
					"            \"FREEZED   \" = 0,\n" + 
					"            \"INACTIVE  \" = 1,\n" + 
					"            \"ACTIVE    \" = 2,\n" + 
					"            \"RECHARGING\" = 4\n" + 
					"        ] STATE, \"VRES status\";\n\n" +
					
	
					"        ENUM \"int\"[\n" +
					all_task_id + 
					"        ] TASK, \"Task\";\n\n" + 
	
					"        ENUM \"int\"[\n" +
					all_contracts_id + 
					"        ] NEXT, \"Next\";\n" + 
	
					"        CTYPE \"int\" BUDGETMAX, \"CT BudgetMax\";\n" + 
					"        CTYPE \"int\" PERIOD,    \"CT Period\";\n" + 
					"        CTYPE \"int\" BUDGET,    \"VRES Budget\";\n" + 
					"        CTYPE \"int\" ABSDLINE,  \"VRES AbsDline\";\n" + 
					"        CTYPE \"int\" DLINE,     \"VRES Current Dline\";\n" + 
	
					"    }, \"Contracts and Virtual Resources\";\n\n" 
				) +
				
				(	(EE_ORTI_current & FrshOrtiConstants.EE_ORTI_ALARM) != 0 ?
					"    ALARM {\n" + 
					"        CTYPE \"unsigned int\" ALARMTIME, \"Alarm Time\"; /* EE_TYPETICK */\n" + 
					"        CTYPE \"unsigned int\" CYCLETIME, \"Cycle Time\"; /* EE_TYPETICK */\n" + 
					"        ENUM [\n" + 
					"            \"STOPPED\" = 0,\n" + 
					"            \"RUNNING\" = 1\n" + 
					"        ] STATE, \"Alarm state\";\n" + 
					"        STRING ACTION, \"Action\";\n" + 
					"        STRING COUNTER, \"Counter\";\n" + 
					"        CTYPE \"unsigned int\" COUNTERVALUE, \"Counter Value\";\n" + 
					"    }, \"Alarms\";\n\n" : ""
				) +

				(	(EE_ORTI_current & FrshOrtiConstants.EE_ORTI_RESOURCE) != 0 ?
					"    RESOURCE {\n" + 
					"        ENUM \"unsigned char\" [\n" + 
					"            \"UNLOCKED\" = 0,\n" + 
					"            \"LOCKED\" = 1\n" + 
					"        ] STATE, \"Resource State\";\n" + 
					"        ENUM \"int\" [\n" +
					all_task_id + 
					"        ] LOCKER, \"Resource Locker\";\n" + 
					"        STRING PRIORITY, \"Ceiling priority\";\n" + 
					"    }, \"Resources\";\n\n" : ""
				) + 
				"}; /* END OF IMPLEMENTATION */\n"
			);

			
			/*******************************************************************
			 * 
			 * INFORMATION SECTION
			 *  
			 ******************************************************************/
			
			
			eeortiBuffer.append(
					commentWriterOrti.writerBanner("ORTI: Information Section ( CPU " + rtosId + " )")+
				
					"OS EE_arch {\n" +
					"    RUNNINGTASK   = \"EE_exec\";\n" + 
					"    EE_RQFIRST    = \"EE_rqfirst\";\n" + 
					"    EE_STKFIRST   = \"EE_stkfirst\";\n" + 
					"    EE_RCGFIRST   = \"EE_rcgfirst\";\n" + 
					"    EE_SYSCEILING = \"EE_sys_ceiling\";\n" + 
					"};\n\n");
			

			
			if ((EE_ORTI_current & FrshOrtiConstants.EE_ORTI_TASK) != 0 && ool.getList(IOilObjectList.TASK).size()>0) {
				/***************************************************************
				 * TASK
				 **************************************************************/
				String stack_vector_name = ErikaEnterpriseWriter.checkOrDefault(AbstractRtosWriter.getOsProperty(ool, SGRK_OS_STACK_VECTOR_NAME), "EE_hal_thread_tos");


				List<ISimpleGenRes> taskList = ool.getList(IOilObjectList.TASK);
				if (taskList.size() > 0) {
					eeortiBuffer.append("\n"+indent2+"/* Tasks */\n");

					for (Iterator<ISimpleGenRes> iter = taskList.iterator(); iter.hasNext(); ) {
						ISimpleGenRes curr = (ISimpleGenRes) iter.next();

						// task name
						final String name = curr.getName();
						// task id
						final String id = curr.getString(ISimpleGenResKeywords.TASK_SYS_ID);
						// number of activations
						final String act = curr.getString(ISimpleGenResKeywords.TASK_ACTIVATION);
						// stack id
						final String stackID;
						if (curr.containsProperty(SGRK_TASK_STACK)) {
							EEStackData stack = (EEStackData) curr.getObject(SGRK_TASK_STACK);
							stackID = "" + stack.stackID;
						} else {
							stackID = "0";
						}
						
						eeortiBuffer.append( 
								"TASK "+name+" {\n" + 

								indent1+"PRLEVEL      = \"EE_th["+id+"].prlevel\";\n" + 
								indent1+"STATE        = \"EE_th["+id+"].status & 0x7F\";\n" + 
								indent1+"WASSTACKED   = \"(EE_th["+id+"].status & 0x80) ? 1 : 0\";\n" +
								
								(
										(EE_ORTI_current & FrshOrtiConstants.EE_ORTI_STACK) != 0  && parent.checkKeyword(DEF__MULTI_STACK__) ? 
										indent1+"STACK        = \"("+stackID+")\";\n" : ""
//										indent1+"STACK        = \""+stack_vector_name+"["+stackID+"]\";\n" : ""
								) + 
								indent1+"NACT         = \"EE_th["+id+"].nact\";\n" + 
								indent1+"RESLOCKED    = \"(EE_th["+id+"].lockedcounter > 0) ? 1 : 0\";\n" + 

								indent1+"VRES         = \"EE_th["+id+"].vres\";\n" + 
								indent1+"DEFERREDVRES = \"EE_th["+id+"].vres_deferred\";\n" + 
								indent1+"NEXT         = \"EE_th["+id+"].next\";\n" + 
								indent1+"VRESSTATE    = \"(EE_th["+id+"].vres == -1) ? -1 : EE_vres[EE_th["+id+"].vres].status\";\n" + 
								indent1+"VRESDLINE    = \"(EE_th["+id+"].vres == -1) ? 0 : EE_vres[EE_th["+id+"].vres].absdline - EE_last_time\";\n" + 

								"};\n\n");		
					
					}			
					
					eeortiBuffer.append("\n");
				}

				
				// EE_CFG
//				List<ISimpleGenRes> resourceList = ool.getList(IOilObjectList.RESOURCE);
//				eecfgBuffer.append(
////				        indent1 + "#ifdef __OO_ORTI_PRIORITY__\n" +
//				        indent1 + "EE_TYPEPRIO EE_ORTI_th_priority["+taskList.size()+"]; /* MAX_TASK = "+taskList.size()+" */\n" +
//				        
//				        ((EE_ORTI_current & EE_ORTI_RESOURCE) != 0 ? "\n" +
//				                indent1 + "EE_TYPEPRIO EE_ORTI_resource_oldpriority["+resourceList.size()+"]; /* MAX_RESOURCE = "+resourceList.size()+" */\n"
//					        : "")+
////				        indent1 + "#endif\n" +
//				        		"\n"
//				);
			}

			
			{ // Contracts
				eeortiBuffer.append("\n"+indent2+"/* Contracts */\n");

				LinkedHashMap<String, SectionWriterKernelFRSH.Contract> cts = (LinkedHashMap<String, SectionWriterKernelFRSH.Contract>) AbstractRtosWriter.getOsObject(ool, SectionWriterKernelFRSH.FRSH_OS_CONTRACT_LIST);

				Collection<SectionWriterKernelFRSH.Contract> list = cts.values();
				int i=0;
				for (Iterator<SectionWriterKernelFRSH.Contract> iter = list.iterator(); iter.hasNext();) {

					SectionWriterKernelFRSH.Contract ct = (SectionWriterKernelFRSH.Contract) iter.next(); 

					eeortiBuffer.append( 
							"VRES "+ct.name+" {\n" + 

							indent1+"BUDGETMAX = \"EE_ct["+i+"].budget\";\n" + 
							indent1+"PERIOD    = \"EE_ct["+i+"].period\";\n" + 
							indent1+"BUDGET    = \"EE_vres["+i+"].budget_avail\";\n" +
							indent1+"ABSDLINE  = \"EE_vres["+i+"].absdline\";\n" +
							indent1+"DLINE     = \"EE_vres["+i+"].absdline - EE_last_time\";\n" + 

							indent1+"STATE     = \"EE_vres["+i+"].status\";\n" + 
							indent1+"TASK      = \"EE_vres["+i+"].task\";\n" + 
							indent1+"NEXT      = \"EE_vres["+i+"].next\";\n" + 

							"};\n\n");		
					i++;
				}
			}
			
			{
				EEStackData[] stacks = (EEStackData[]) AbstractRtosWriter.getOsObject(ool, SGRK_OS_STACK_LIST);
				if ((EE_ORTI_current & FrshOrtiConstants.EE_ORTI_STACK) != 0 && stacks != null) {
				/***************************************************************
				 * STACK
				 **************************************************************/
	
					if (stacks.length >0) {
						eeortiBuffer.append("\n"+indent2+"/* Stacks */\n");
						
						for (int i=0; i<stacks.length; i++) {
		
							EEStackData s = stacks[i];
							
							eeortiBuffer.append( 
									"STACK Stack"+s.stackID+" {\n" + 
									"    SIZE = \""+s.size[0]+"\";\n" + 
									"    STACKDIRECTION = \""+(s.directDown ? "DOWN" : "UP" )+"\";\n" + 
									"    BASEADDRESS = \"(unsigned int *)("+s.baseAddressTxt[0]+")\";\n" + 
									"    FILLPATTERN = \"0xA5A5A5A5\";\n" + 
									"};\n"); 
							
							//"(unsigned int *)((unsigned int*)((int)(&__alt_stack_pointer) - 4096))
						}
					}
				}
			}			
			
			if ((EE_ORTI_current & FrshOrtiConstants.EE_ORTI_ALARM) != 0) {
				/***************************************************************
				 * ALARMS
				 **************************************************************/
				List<ISimpleGenRes> alarmList = ool.getList(IOilObjectList.ALARM);
				if (alarmList.size() > 0) {
					eeortiBuffer.append("\n"+indent2+"/* Alarms */\n");

					int index = 0;
					for (Iterator<ISimpleGenRes> iter = alarmList.iterator(); iter.hasNext(); index++) {
						ISimpleGenRes curr = (ISimpleGenRes) iter.next();

						// alarm name
						final String name = curr.getName();
						// counter name
						final String counter = curr.getString(ISimpleGenResKeywords.ALARM_COUNTER);
						// alarm id
						final String id = "" + index;
						// action (a text description)
						final String actionDescr;
						
						{ // ----- set description -----
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
								String task_al_name = curr.getString(ISimpleGenResKeywords.ALARM_ACTIVATE_TASK);
								
								actionDescr = "activate task " + task_al_name;
								
							} else if (tipo.equals(ISimpleGenResKeywords.ALARM_SET_EVENT)) {
								String[] tmp = (String[]) curr.getObject(ISimpleGenResKeywords.ALARM_SET_EVENT);
								String task_al_name = tmp[0];
								String evento = tmp[1];

								actionDescr = "set " + evento + " on " + task_al_name;
								
							} else if (tipo.equals(ISimpleGenResKeywords.ALARM_CALL_BACK)) {
								String callBackName = curr.getString(ISimpleGenResKeywords.ALARM_CALL_BACK);
								
								actionDescr = "callback " + callBackName;
								
							} else {
								throw new Error("Unknow type");
							}
						}

						
						eeortiBuffer.append( 
								"ALARM "+name+" {\n" + 
								indent1+"ALARMTIME = \"EE_ORTI_alarmtime["+id+"]\";\n" + 
								indent1+"CYCLETIME = \"EE_alarm_RAM["+id+"].cycle\";\n" + 
								indent1+"STATE = \"(EE_alarm_RAM["+id+"].used == 0) ? 0 : 1\";\n" + 
								indent1+"ACTION = \""+actionDescr+"\";\n" + 
								indent1+"COUNTER = \""+counter+"\";\n" + 
								indent1+"COUNTERVALUE = \"EE_counter_RAM[EE_alarm_ROM["+id+"].c].value\";\n" + 
								"};\n");		
					
					}			
					
					eeortiBuffer.append("\n");
				}
				
				// EE_CFG
//				eecfgBuffer.append(
////				        indent1 + "#ifdef __OO_ORTI_ALARMTIME__\n" +
//				        indent1 + "/* this variable stores the time until an alarm expires; it is only\n" +
//				        indent1 + "   valid if an alarm is running.\n" +
//				        indent1 + "   Initvalue: all 0\n" +
//				        indent1 + "*/\n" +
//				        indent1 + "EE_TYPEPRIO EE_ORTI_alarmtime["+alarmList.size()+"]; /* MAX_ALARM = "+alarmList.size()+" */\n" +
////				        indent1 + "#endif\n" +
//				        		"\n");
			}

			if ((EE_ORTI_current & FrshOrtiConstants.EE_ORTI_RESOURCE) != 0) {
				/***************************************************************
				 * RESOURCES
				 **************************************************************/

				List<ISimpleGenRes> resourceList = ool.getList(IOilObjectList.RESOURCE);
				if (resourceList.size() > 0) {
					eeortiBuffer.append("\n"+indent2+"/* Resources */\n");

					for (Iterator<ISimpleGenRes> iter = resourceList.iterator(); iter.hasNext(); ) {
						ISimpleGenRes curr = (ISimpleGenRes) iter.next();

						// resource name
						final String name = curr.getName();
						// task id
						final String id = curr.getString(ISimpleGenResKeywords.RESOURCE_SYS_ID);
						// resource ceiling
						final String ceiling = curr.getString(ISimpleGenResKeywords.RESOURCE_CEILING);
						
						eeortiBuffer.append( 
								"RESOURCE "+name+" {\n" + 
								indent1+"STATE = \"(EE_resource_locked["+id+"])\";\n" +
								indent1+"LOCKER = \"(EE_resource_locked["+id+"] ? EE_ORTI_res_locker["+id+"] : -1)\";\n" +
								indent1+"PRIORITY = \""+ceiling+"\";\n" + 
								"};\n");		
					}			
					
					eeortiBuffer.append("\n");
				}
				
				// EE_CFG
//				eecfgBuffer.append(
////				        indent1 + "#ifdef __OO_ORTI_RES_LOCKER_TASK__" +
//				        indent1 + "EE_UREG EE_ORTI_res_locker["+resourceList.size()+"]; /* MAX_RESOURCE = "+resourceList.size()+" */\n" +
////				        indent1 + "#endif\n" +
//		        				"\n");
			}


			// add a new line
			eeortiBuffer.append("\n");

		}

		return answer;
	}

	
	
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix)
			throws OilCodeWriterException {

		for (int rtodId=0; rtodId<rtosPrefix.length; rtodId++) {

			final String currentRtosPrefix = parent.computeOilRtosPrefix(rtosPrefix[rtodId]);
	
			/***********************************************************************
		     * ORTI
		     **********************************************************************/
			{
				ArrayList<String> value = CommonUtils.getAllChildrenEnumType(vt,
						currentRtosPrefix + "ORTI_SECTIONS", null);
		
				if (value != null) {
					boolean none = false;
					for (int i=0; i<value.size(); i++) {
						if ("NONE".equals(value.get(i))) {
							none = true;
							break;
						} else if ("ALL".equals(value.get(i))) {
							EE_ORTI_current = FrshOrtiConstants.EE_ORTI_ALL;
							break;
						} else if ("OS_SECTION".equals(value.get(i))) {
							EE_ORTI_current |= FrshOrtiConstants.EE_ORTI_OS;
							
						} else if ("TASK_SECTION".equals(value.get(i))) {
							EE_ORTI_current |= FrshOrtiConstants.EE_ORTI_TASK;
							
						} else if ("RESOURCE_SECTION".equals(value.get(i))) {
							EE_ORTI_current |= FrshOrtiConstants.EE_ORTI_RESOURCE;
							
						} else if ("STACK_SECTION".equals(value.get(i))) {
							EE_ORTI_current |= FrshOrtiConstants.EE_ORTI_STACK;
							
						} else if ("ALARM_SECTION".equals(value.get(i))) {
							EE_ORTI_current |= FrshOrtiConstants.EE_ORTI_ALARM;
							
						} else {
							Messages.sendWarningNl("Unknow ORTI type : " + value.get(i), null, "qoiwueqwoiueqwe", null); 
						}
					}
					
					if (EE_ORTI_current != 0 && none) {
						throw new OilCodeWriterException("ORTI options contains NONE but, at the same time, it tries to enable some sections.");
					}
					if (EE_ORTI_current != 0 && !keywords.contains(IWritersKeywords.ENABLE_ORTI)) {
						keywords.add(IWritersKeywords.ENABLE_ORTI);
					}
				}
			}

		}		
	}	
	
	
	public void updateObjects() throws OilCodeWriterException {
		
		/* Do nothing, if ORTI is not enabled */
		if (!parent.checkKeyword(IWritersKeywords.ENABLE_ORTI)) 
			return;

		
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		
		for (int currentRtosId = 0; currentRtosId<oilObjects.length; currentRtosId++) { 
			final IOilObjectList ool = oilObjects[currentRtosId];
			
			/*
			 * Add sections  
			 */
			{
				final ISimpleGenRes sgrOs = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
				sgrOs.setObject(FrshOrtiConstants.OS_CPU_ORTI_ENABLED_SECTIONS, new Integer(EE_ORTI_current));
			}
		}
		
		
        
        //if (parent.checkKeyword(IWritersKeywords.ENABLE_ORTI)) 
        { 
        	final ISimpleGenRes sgrOs = oilObjects[RTOS_ID___COMMON_DATA].getList(IOilObjectList.OS).get(0);
        	final ICommentWriter commentWriterMf = getCommentWriter(oilObjects[RTOS_ID___COMMON_DATA], FileTypes.MAKEFILE);
        	
    		String value = commentWriterMf.writerBanner("Orti") + "export EE_ORTI_SUPPORT := 1\n";
			CommonUtils.updateSgrProperty(sgrOs, SGRK__MAKEFILE_MP_EXT_VARS__, value);
            
        }

	}
	
}

