/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterOrti.java,v 1.2 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
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
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;
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
public class SectionWriterOrti_osek extends SectionWriter implements
		IEEWriterKeywords, IExtractKeywordsExtentions, IExtractObjectsExtentions {
	
	private enum SectionTypes {
		NONE("NONE", 0), 
		ALL("ALL", OsekOrtiConstants.EE_ORTI_ALL),
		OS("OS_SECTION", OsekOrtiConstants.EE_ORTI_OS),
		TASK("TASK_SECTION", OsekOrtiConstants.EE_ORTI_TASK),
		ISR2("ISR2_SECTION", OsekOrtiConstants.EE_ORTI_ISR2),
		RESOURCE("RESOURCE_SECTION", OsekOrtiConstants.EE_ORTI_RESOURCE),
		STACK("STACK_SECTION", OsekOrtiConstants.EE_ORTI_STACK),
		ALARM("ALARM_SECTION", OsekOrtiConstants.EE_ORTI_ALARM);
		
		private final String text;
		private final int mask;
		
		private SectionTypes(String text, int mask) {
			this.text = text;
			this.mask = mask;
		}

		public static SectionTypes getType(String s) {
			for (SectionTypes t: values()) {
				if (t.getText().equals(s)) {
					return t;
				}	
			}
			return null;
		}
		
		public String getText() {
			return text;
		}
		public int getMask() {
			return mask;
		}
	};
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;

	/** All data */
	protected final IVarTree vt;

	public SectionWriterOrti_osek() {
		this(null);
	}

	/**
	 * 
	 */
	public SectionWriterOrti_osek(ErikaEnterpriseWriter parent) {
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

		return super.enabled() && (Collections.binarySearch(keywords, IWritersKeywords.OSEK_KERNEL) >= 0);
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
		
		//final int EE_ORTI_current = parent.getORTI_current();

		/***********************************************************************
		 * prepare and write buffers for All OS
		 **********************************************************************/
		for (int rtosId = 0; rtosId < rtosNumber; rtosId++) {

			
			// ------------------ common data ------------------

			// all objects for current os
			IOilObjectList ool = oilObjects[rtosId];
			// current os

			final int EE_ORTI_current = ErikaEnterpriseWriter.checkOrDefault((Integer)AbstractRtosWriter.getOsObject(ool, OsekOrtiConstants.OS_CPU_ORTI_ENABLED_SECTIONS),
					new Integer(0));


			ICommentWriter commentWriter = getCommentWriter(ool, FileTypes.ORTI);

			
			if (answer[rtosId] == null) {
				answer[rtosId] = new OilWriterBuffer();
			}

			StringBuffer eeortiBuffer = answer[rtosId].get(OsekOrtiConstants.FILE_EE_ORTI);
			
//			StringBuffer eecfgBuffer = answer[rtosId].get(FILE_EE_CFG_C);
			
			/*******************************************************************
			 * 
			 * DECLARATION SECTION
			 *  
			 ******************************************************************/
			
			StringBuffer all_task_id = new StringBuffer("            \"NO_TASK\" = \"-1\"");
			StringBuffer all_priorities = new StringBuffer("            \"Not Running (0)\" = 0");
			StringBuffer all_appmodes_id = new StringBuffer();
			StringBuffer all_stack_id = new StringBuffer();
			StringBuffer all_isr2 = new StringBuffer();
			StringBuffer all_memoryProtection = new StringBuffer();
			
			{ // priorities and task ID
				BitSet priorities = new BitSet();
				/* TASK */
				for (Iterator<ISimpleGenRes> iter = ool.getList(IOilObjectList.TASK).iterator(); iter.hasNext();) {
	
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
				
//				final int appNumber = ool.getList(IOilObjectList.APPMODE).size() + id; 

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
				EEStackData[] stacks = (EEStackData[]) AbstractRtosWriter.getOsObject(ool, SGRK_OS_STACK_LIST);
				String pre = "";
				if (stacks != null) {
					for (int i=0; i<stacks.length; i++) {
						all_stack_id.append(pre + "            \"Stack"+i+"\" : Stack"+i+" = "+i);
						pre = ",\n";
					}
					if (all_stack_id.length()>0) all_stack_id.append("\n");
				}
			}
			
			if ((EE_ORTI_current & OsekOrtiConstants.EE_ORTI_ISR2) != 0) {
				all_isr2.append("        ENUM \"void *\" [\n" +
						"            \"NO_ISR2\" = 0");
				
				for (ISimpleGenRes isr: ool.getList(IOilObjectList.ISR)) {
					if (isr.containsProperty(ISimpleGenResKeywords.ISR_CATEGORY) && "2".equals(isr.getString(ISimpleGenResKeywords.ISR_CATEGORY))) {
						String handler = isr.getString(ISimpleGenResKeywords.ISR_GENERATED_HANDLER);
						if (handler != null) {
							all_isr2.append(",\n            \""+isr.getName()+"\" = \""+handler+"\"");
						}
					}
				}
				for (ISimpleGenRes counter: ool.getList(IOilObjectList.COUNTER)) {
					if (counter.containsProperty(ISimpleGenResKeywords.COUNTER_GENERATED_HANDLER)) {
						String handler = counter.getString(ISimpleGenResKeywords.COUNTER_GENERATED_HANDLER);
						if (handler != null) {
							all_isr2.append(",\n            \""+counter.getName()+"\" = \""+handler+"\"");
						}
					}
				}

				all_isr2.append("\n        ] RUNNINGISR2, \"Running ISR2\";\n\n");
			}
			
			if (parent.checkKeyword(IWritersKeywords.KERNEL_OS_APPLICATION)) {
				all_memoryProtection.append(",\n" +
						"            \"GetNumberOfActivatedCores\" = 72,\n" +
						"            \"GetCoreID\" = 74,\n" +
						"            \"StartCore\" = 76,\n" +
						"            \"StartNonAutosarCore\" = 78,\n" +
						"            \"GetSpinlock\" = 80,\n" +
						"            \"ReleaseSpinlock\" = 82,\n" +
						"            \"TryToGetSpinlock\" = 84,\n" +
						"            \"ShutdownAllCores\" = 86,\n" +
						"            \"CheckTaskMemoryAccess\" = 88,\n" +
						"            \"CheckIsrMemoryAccess\" = 90,\n" +
						"            \"GetApplicationID\" = 92,\n" +
						"            \"GetISRID\" = 94,\n" +
						"            \"GetApplicationState\" = 96,\n" +
						"            \"TerminateApplication\" = 98,\n" +
						"            \"AllowAccess\" = 100,\n" +
						"            \"CheckObjectAccess\" = 102,\n" +
						"            \"CheckObjectOwnership\" = 104,\n" +
						"            \"CallTrustedFunction\" = 106,\n" +
						"            \"StartScheduleTableRel\" = 108,\n" +
						"            \"StartScheduleTableAbs\" = 110,\n" +
						"            \"StopScheduleTable\" = 112,\n" +
						"            \"NextScheduleTable\" = 114,\n" +
						"            \"GetScheduleTableStatus\" = 116,\n" +
						"            \"SyncScheduleTable\" = 118"
						);
			}
			

			
			eeortiBuffer.append(
					commentWriter.writerBanner("ORTI: Declaration Section ( CPU " + rtosId + " )")+
				"VERSION {\n" + 
				"    KOIL = \"2.1\";\n" + 
				"    OSSEMANTICS = \"ORTI\", \"2.1\";\n" + 
				"};\n" + 
				"\n" + 
				"IMPLEMENTATION EE_cpu_"+rtosId+" {\n" + 
				"    OS {\n" + 
				"\n" + 
				"    /* here for each task a small description and its index */\n" + 
				"        TOTRACE ENUM [\n" +
				all_task_id + 
				"        ] RUNNINGTASK, \"Running Task Id\";\n" + 
				"\n" + 
				"        ENUM \"int\" [\n" +
				all_priorities +
				"        ] RUNNINGTASKPRIORITY, \"Priority of Running Task\";\n" + 
				"\n" + 
//				"//PJ: al momento non supportato\n" + 
//				"//        ENUM \"unsigned char\" [\n" + 
//				"//            \"NO_ISR\"    = 0,\n" + 
//				"//            \"ISR_Button\" = ISR_Button,\n" + 
//				"//            \"ISR_Timer\"  = ISR_Timer,\n" + 
//				"//        ] RUNNINGISR2, \"Running ISR2\";\n" + 
//				"\n" + 
				"        TOTRACE ENUM \"unsigned char\" [\n" + 
				"            \"ActivateTask\" = 2,\n" + 
				"            \"TerminateTask\" = 4,\n" + 
				"            \"ChainTask\" = 6,\n" + 
				"            \"Schedule\" = 8,\n" + 
				"            \"GetTaskID\" = 10,\n" + 
				"            \"GetTaskState\" = 12,\n" + 
				"            \"DisableAllInterrupts\" = 14,\n" + 
				"            \"EnableAllInterrupts\" = 16,\n" + 
				"            \"SuspendAllInterrupts\" = 18,\n" + 
				"            \"ResumeAllInterrupts\" = 20,\n" + 
				"            \"SuspendOSInterrupts\" = 22,\n" + 
				"            \"ResumeOSInterrupts\" = 24,\n" + 
				"            \"GetResource\" = 26,\n" + 
				"            \"ReleaseResource\" = 28,\n" + 
				"            \"SetEvent\" = 30,\n" + 
				"            \"ClearEvent\" = 32,\n" + 
				"            \"GetEvent\" = 34,\n" + 
				"            \"WaitEvent\" = 36,\n" + 
				"            \"GetAlarmBase\" = 38,\n" + 
				"            \"GetAlarm\" = 40,\n" + 
				"            \"SetRelAlarm\" = 42,\n" + 
				"            \"SetAbsAlarm\" = 44,\n" + 
				"            \"CancelAlarm\" = 46,\n" + 
				"            \"GetActiveApplicationMode\" = 48,\n" + 
				"            \"StartOS\" = 50,\n" + 
				"            \"ShutdownOS\" = 52,\n" + 
				"            \"ForceSchedule\" = 54,\n" + 
				"            \"IncrementCounter\" = 56,\n"+
				"            \"GetCounterValue\" = 58,\n"+
				"            \"GetElapsedValue\" = 60,\n"+

				"            \"InitSem\" = 62,\n" + 
				"            \"WaitSem\" = 64,\n" + 
				"            \"TryWaitSem\" = 66,\n"+
				"            \"PostSem\" = 68,\n"+
				"            \"GetValueSem\" = 70"+

				all_memoryProtection +"\n" + 
				"        ] SERVICETRACE, \"OS Services Watch\";\n" + 
				"\n" + 
				"    /* please note int and not unsigned char */\n" + 
				"        ENUM \"int\" [\n" + 
				"            \"E_OK\" = 0,\n" + 
				"            \"E_OS_ACCESS\" = 1,\n" + 
				"            \"E_OS_CALLEVEL\" = 2,\n" + 
				"            \"E_OS_ID\" = 3,\n" + 
				"            \"E_OS_LIMIT\" = 4,\n" + 
				"            \"E_OS_NOFUNC\" = 5,\n" + 
				"            \"E_OS_RESOURCE\" = 6,\n" + 
				"            \"E_OS_STATE\" = 7,\n" + 
				"            \"E_OS_VALUE\" = 8,\n" + 
				"            \"E_OS_SYS_INIT\" = 9\n" + 
				"        ] LASTERROR, \"Last error\";\n" + 
				"\n" + 
				"        ENUM \"unsigned char\" [\n" +
				all_appmodes_id + 
				"        ] CURRENTAPPMODE, \"Current application mode\";\n" + 
				"\n" + 
				all_isr2 +
				"        /* EE specific data structures */\n" + 
				"        CTYPE \"unsigned int\" vs_EE_SYSCEILING, \"EE system ceiling\";\n" + 
				"    }, \"OS\";\n\n" + 

				(	(EE_ORTI_current & OsekOrtiConstants.EE_ORTI_TASK) != 0 ?
					"    TASK {\n" + 
					"        ENUM \"int\" [\n" +
					all_priorities +
					"        ] PRIORITY , \"Actual Prio\";\n" + 

					"        ENUM \"unsigned char\" [\n" + 
					"            \"RUNNING\"=0,\n" + 
					"            \"WAITING\"=1,\n" + 
					"            \"READY\"=2,\n" + 
					"            \"SUSPENDED\"=3\n" + 
					"        ] STATE, \"Task State\";\n" + 

					(	(EE_ORTI_current & OsekOrtiConstants.EE_ORTI_STACK) != 0 && all_stack_id.length()>0 ? //parent.checkKeyword(DEF__MULTI_STACK__)?
						"        ENUM \"unsigned int\" [\n" +
						all_stack_id + 
						"        ] STACK, \"Task Stack\";\n" : ""
					) + 

					"        CTYPE \"int\" CURRENTACTIVATIONS, \"Current activations\";\n" + 
					"    }, \"Tasks\";\n\n" : ""
				) + 
				(	(EE_ORTI_current & OsekOrtiConstants.EE_ORTI_STACK) != 0 ?
					"    STACK {\n" + 
					"        CTYPE SIZE, \"Stack Size (Byte)\";\n" + 
					"        CTYPE \"unsigned int *\" BASEADDRESS, \"Base Address\";\n" + 
					"        STRING STACKDIRECTION, \"Stack Direction\";\n" + 
					"        CTYPE \"unsigned int\" FILLPATTERN, \"Stack Fill Pattern\";\n" + 
					"    }, \"Stacks\";\n\n" : ""
				) + 
				(	(EE_ORTI_current & OsekOrtiConstants.EE_ORTI_ALARM) != 0 ?
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

				(	(EE_ORTI_current & OsekOrtiConstants.EE_ORTI_RESOURCE) != 0 ?
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
					commentWriter.writerBanner("ORTI: Information Section ( CPU " + rtosId + " )")+
				
					"OS EE_arch {\n" + 
					"    RUNNINGTASK = \"EE_stkfirst\";\n" + 
					"    RUNNINGTASKPRIORITY = \"(EE_stkfirst == -1) ? 0 : " +
						((EE_ORTI_current & OsekOrtiConstants.EE_ORTI_TASK) != 0 && ool.getList(IOilObjectList.TASK).size()>0 ?
								"EE_ORTI_th_priority[EE_stkfirst]" : "0") + "\";\n" + 

					((EE_ORTI_current & OsekOrtiConstants.EE_ORTI_ISR2) != 0 ?
								"    RUNNINGISR2 = \"EE_ORTI_runningisr2\";\n" : "") +

					"    SERVICETRACE = \"EE_ORTI_servicetrace\";\n" + 
					"    LASTERROR = \"EE_ORTI_lasterror\";\n" + 
					"    CURRENTAPPMODE = \"EE_ApplicationMode\";\n" + 
					"    vs_EE_SYSCEILING = \"EE_sys_ceiling\";\n" + 
					"};\n\n");
			

			
			if ((EE_ORTI_current & OsekOrtiConstants.EE_ORTI_TASK) != 0 && ool.getList(IOilObjectList.TASK).size()>0) {
				/***************************************************************
				 * TASK
				 **************************************************************/

				String stack_vector_name = ErikaEnterpriseWriter.checkOrDefault(AbstractRtosWriter.getOsProperty(ool, SGRK_OS_STACK_VECTOR_NAME), "EE_hal_thread_tos");
				String stack_vector_field = ErikaEnterpriseWriter.checkOrDefault(AbstractRtosWriter.getOsProperty(ool, SGRK_OS_STACK_VECTOR_FIELD), "");

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
								indent1+"PRIORITY = \"(EE_ORTI_th_priority["+id+"])\";\n" + 
								indent1+"STATE = \"(EE_th_status["+id+"])\";\n" + 
								indent1+"CURRENTACTIVATIONS = \"("+act+" - EE_th_rnact["+id+"])\";  /* "+act+" = max activations */\n" + 
								(
										(EE_ORTI_current & OsekOrtiConstants.EE_ORTI_STACK) != 0  && all_stack_id.length()>0 ? 
												(parent.checkKeyword(DEF__MULTI_STACK__) ? 
														indent1+"STACK = \"("+stackID+")\";\n" :
														indent1+"STACK = \"(0)\";\n"  
//														indent1+"STACK = \"("+stack_vector_name+"["+stackID+"]"+stack_vector_field+")\";\n" :
//														indent1+"STACK = Stack0;\n"  
												): "") + 
								"};\n");		
					
					}			
					
					eeortiBuffer.append("\n");
				}
			}

			{
				EEStackData[] stacks = (EEStackData[]) AbstractRtosWriter.getOsObject(ool, SGRK_OS_STACK_LIST);
				if ((EE_ORTI_current & OsekOrtiConstants.EE_ORTI_STACK) != 0 && stacks != null) {
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
			
			if ((EE_ORTI_current & OsekOrtiConstants.EE_ORTI_ALARM) != 0 && ool.getList(IOilObjectList.ALARM).size() >0) {
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

							} else if (tipo.equals(ISimpleGenResKeywords.ALARM_INCR_COUNTER)) {
								String counterName = curr.getString(ISimpleGenResKeywords.ALARM_INCR_COUNTER);
								
								actionDescr = "incr counter " + counterName;

							} else {
								throw new Error("Unknow type");
							}
						}

						
						eeortiBuffer.append( 
								"ALARM "+name+" {\n" + 
								indent1+"ALARMTIME = \"EE_ORTI_alarmtime["+id+"]\";\n" + 
								indent1+"CYCLETIME = \"EE_oo_counter_object_RAM["+id+"].cycle\";\n" + 
								indent1+"STATE = \"(EE_oo_counter_object_RAM["+id+"].used == 0) ? 0 : 1\";\n" + 
								indent1+"ACTION = \""+actionDescr+"\";\n" + 
								indent1+"COUNTER = \""+counter+"\";\n" + 
								indent1+"COUNTERVALUE = \"EE_counter_RAM[EE_oo_counter_object_ROM["+id+"].c].value\";\n" + 
								"};\n");		
					
					}			
					
					eeortiBuffer.append("\n");
				}
			}

			if ((EE_ORTI_current & OsekOrtiConstants.EE_ORTI_RESOURCE) != 0 && ool.getList(IOilObjectList.RESOURCE).size() >0) {
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
			}


			// add a new line
			eeortiBuffer.append("\n");

		}

		return answer;
	}

	
	
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix)
			throws OilCodeWriterException {
		int EE_ORTI_current = 0;
		boolean none = false;
		for (int rtodId=0; rtodId<rtosPrefix.length; rtodId++) {

			final String currentRtosPrefix = parent.computeOilRtosPrefix(rtosPrefix[rtodId]);
	
			/***********************************************************************
		     * ORTI
		     **********************************************************************/
			ArrayList<String> value = CommonUtils.getAllChildrenEnumType(vt,
					currentRtosPrefix + "ORTI_SECTIONS", null);
	
			if (value != null) {
				for (int i=0; i<value.size(); i++) {
					SectionTypes t = SectionTypes.getType(value.get(i));
					if (t != null) {
						if (t == SectionTypes.NONE) {
							none = true;
						} else {
							EE_ORTI_current |= t.getMask();
						}
					} else {
						Messages.sendWarningNl("Unknow ORTI type : " + value.get(i), null, "qoiwueqwoiueqwe", null); 
					}
				}
			}	
		}
		if (EE_ORTI_current != 0 && none) {
			throw new OilCodeWriterException("ORTI options contains NONE but, at the same time, it tries to enable some sections.");
		}
		if (EE_ORTI_current != 0 && !keywords.contains(IWritersKeywords.ENABLE_ORTI)) {
			keywords.add(IWritersKeywords.ENABLE_ORTI);
		}
		if ( (EE_ORTI_current & OsekOrtiConstants.EE_ORTI_ISR2) != 0 && !keywords.contains(IWritersKeywords.ENABLE_ORTI_ISR2)) {
			keywords.add(IWritersKeywords.ENABLE_ORTI_ISR2);
		}
	}	

	public void updateObjects() throws OilCodeWriterException {
		
		/* Do nothing, if ORTI is not enabled */
		if (!parent.checkKeyword(IWritersKeywords.ENABLE_ORTI)) 
			return;

		int EE_ORTI_current = 0;
		
		final IOilObjectList[] oilObjects = parent.getOilObjects();

		boolean supportISR2 = false;
		boolean requiredISR2 = false;
		for (int currentRtosId = 0; currentRtosId<oilObjects.length; currentRtosId++) { 
			final IOilObjectList ool = oilObjects[currentRtosId];

			List<String> value = parent.getRtosCommonChildType(ool, "ORTI_SECTIONS");
	
			if (value != null) {
				for (int i=0; i<value.size(); i++) {
					SectionTypes t = SectionTypes.getType(value.get(i));
					if (t != null) {
						EE_ORTI_current |= t.getMask();
						if (t == SectionTypes.ISR2) {
							requiredISR2 = true;
						}
					}
				}
			}
			
			
			{
				CpuHwDescription currentStackDescription = ErikaEnterpriseWriter.getCpuHwDescription(ool);
				if (currentStackDescription != null) {
				supportISR2 |= currentStackDescription.isSupportOrtiISR2();
			}
		}
		}
		if (requiredISR2 && !supportISR2) {
			throw new OilCodeWriterException("This architecture does not support ORTI ISR2 section");
		}
		
		if (!supportISR2) {
			EE_ORTI_current = EE_ORTI_current & (~OsekOrtiConstants.EE_ORTI_ISR2);
		}

		
		
		for (int currentRtosId = 0; currentRtosId<oilObjects.length; currentRtosId++) { 
			final IOilObjectList ool = oilObjects[currentRtosId];
			
			/*
			 * Update EE_OPT for ORTI
			 */
			
			{ 
				ISimpleGenRes sgrOs = ool.getList(IOilObjectList.OS).get(0);
				String[] lista = sgrOs.containsProperty(ISimpleGenResKeywords.OS_CPU_EE_OPTS) ?
						(String[]) sgrOs.getObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS) :
							new String[0];
				ArrayList<String> array = new ArrayList<String>(Arrays.asList(lista));
				

				if ((EE_ORTI_current & OsekOrtiConstants.EE_ORTI_OS) != 0) {
					array.add("__OO_ORTI_LASTERROR__");
					array.add("__OO_ORTI_SERVICETRACE__");
				}
				if ((EE_ORTI_current & OsekOrtiConstants.EE_ORTI_TASK) != 0) {
					array.add("__OO_ORTI_PRIORITY__");
				    
				    // the resource functions keep
		            // trace of the locker task.
					array.add("__OO_ORTI_RES_LOCKER_TASK__");
				}
				if ((EE_ORTI_current & OsekOrtiConstants.EE_ORTI_RESOURCE) != 0) {
				    // the resource functions keep trace
		            // of the fact that a resource is locked or not
					array.add("__OO_ORTI_RES_ISLOCKED__");
				}
				if ((EE_ORTI_current & OsekOrtiConstants.EE_ORTI_STACK) != 0) {
					array.add("__OO_ORTI_STACK__");
				}
				if ((EE_ORTI_current & OsekOrtiConstants.EE_ORTI_ALARM) != 0) {
					array.add("__OO_ORTI_ALARMTIME__");
				}
				if ((EE_ORTI_current & OsekOrtiConstants.EE_ORTI_ISR2) != 0) {
					array.add("__OO_ORTI_RUNNINGISR2__");
				}

				
				sgrOs.setObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS, array.toArray(new String[array.size()]));
			}
			
			/*
			 * Add  
			 */
			{
				ISimpleGenRes sgrOs = ool.getList(IOilObjectList.OS).get(0);
				sgrOs.setObject(OsekOrtiConstants.OS_CPU_ORTI_ENABLED_SECTIONS, new Integer(EE_ORTI_current));
			}
		}
		
		
        
//        if (parent.checkKeyword(IWritersKeywords.ENABLE_ORTI)) 
		{ 
        	final ISimpleGenRes sgrOs = oilObjects[RTOS_ID___COMMON_DATA].getList(IOilObjectList.OS).get(0);
        	
        	ICommentWriter commentWriter = getCommentWriter(oilObjects[RTOS_ID___COMMON_DATA], FileTypes.MAKEFILE);
        	
    		String value = commentWriter.writerBanner("Orti") + "export EE_ORTI_SUPPORT := 1\n";
			CommonUtils.updateSgrProperty(sgrOs, SGRK__MAKEFILE_MP_EXT_VARS__, value);
            
        }

	}
	
}

