package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.eu.evidence.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IOilXMLLabels;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

public class SectionWriterKernelSystemCalls extends SectionWriter
	implements IEEWriterKeywords, IExtractObjectsExtentions,
	IExtractKeywordsExtentions, IGetEEOPTExtentions {

	protected final static String EE_ASM_FILE_H = "ee_asm.h";
	protected final static String EE_LINKER_FILE = "loc_diab.dld";

	public final static String OS_APPLICATION_TRUESTED = "sgr_os_application_trusted";
	public final static String OS_MAX_NESTING_LEVEL = "sgr_os_max_nesting_level";
	
	public final static String EE_OPT_MEMORY_PROTECTION = "__EE_MEMORY_PROTECTION__";
	public final static String EE_OPT_SC4 = "__AS_SC4__";
	
	protected final static String[] EE_OS_SERVICES_IDs = {
		"EE_ID_ActivateTask              ",
		"EE_ID_TerminateTask             ",
		"EE_ID_ChainTask                 ",
		"EE_ID_Schedule                  ",
		"EE_ID_ForceSchedule             ",
		"EE_ID_GetTaskID                 ",
		"EE_ID_GetTaskState              ",
		"EE_ID_EnableAllInterrupts       ",
		"EE_ID_DisableAllInterrupts      ",
		"EE_ID_ResumeAllInterrupts       ",
		"EE_ID_SuspendAllInterrupts      ",
		"EE_ID_ResumeOSInterrupts        ",
		"EE_ID_SuspendOSInterrupts       ",
		
		"EE_ID_GetActiveApplicationMode  ",
		"EE_ID_StartOS                   ",
		"EE_ID_ShutdownOS                "
	};
	
	protected final static String[] EE_RESOURCES_IDs = {
		"EE_ID_GetResource               ",
		"EE_ID_ReleaseResource           ",
	};
	
	protected final static String[] EE_ECC1_2_IDs = {
		"EE_ID_SetEvent                  ",
		"EE_ID_ClearEvent                ",
		"EE_ID_GetEvent                  ",
		"EE_ID_WaitEvent                 "
	};
	
	
	protected final static String[] EE_ALARMS_IDs = {
		"EE_ID_GetAlarmBase              ",
		"EE_ID_GetAlarm                  ",
		"EE_ID_SetRelAlarm               ",
		"EE_ID_SetAbsAlarm               ",
		"EE_ID_CancelAlarm               "
	};
	
	protected final static String[] EE_SEM_IDs = {
		"EE_ID_InitSem                   ",
		"EE_ID_WaitSem                   ",
		"EE_ID_TryWaitSem                ",
		"EE_ID_PostSem                   ",
		"EE_ID_GetValueSem               "
	};
	
	
	protected final static String EE_OS_SERVICES_DEF = 
	"#define ActivateTask(TaskID)   EE_SysCall1(EE_ID_ActivateTask, TaskID)\n" +
	"#define TerminateTask()        EE_SysCall0(EE_ID_TerminateTask)\n" +
	"#define ChainTask(TaskID)      EE_SysCall1(EE_ID_ChainTask, TaskID)\n" +
	"#define Schedule()             EE_SysCall0(EE_ID_Schedule)\n" +
	"#define ForceSchedule()        EE_SysCall0(EE_ID_ForceSchedule)\n" +
	"#define GetTaskID(TaskID)      EE_SysCall1(EE_ID_GetTaskID, TaskID)\n" +
	"#define GetTaskState(TaskID, State)                                    \\\n" +
	"                               EE_SysCall2(EE_ID_GetTaskState, TaskID, State)\n" +
	"#define EnableAllInterrupts()  EE_SysCall0(EE_ID_EnableAllInterrupts)\n" +
	"#define DisableAllInterrupts() EE_SysCall0(EE_ID_DisableAllInterrupts)\n" +
	"#define ResumeAllInterrupts()  EE_SysCall0(EE_ID_ResumeAllInterrupts)\n" +
	"#define SuspendAllInterrupts() EE_SysCall0(EE_ID_SuspendAllInterrupts)\n" +
	"#define ResumeOSInterrupts()   EE_SysCall0(EE_ID_ResumeOSInterrupts)\n" +
	"#define SuspendOSInterrupts()  EE_SysCall0(EE_ID_SuspendOSInterrupts)\n" +
	"                               EE_SysCall0(EE_ID_GetActiveApplicationMode)\n" +
	"#define StartOS(Mode)          EE_SysCall1(EE_ID_StartOS, Mode)\n" +
	"#define ShutdownOS(Error)      EE_SysCall0(EE_ID_ShutdownOS(Error)\n\n";
	
	protected final static String EE_RESOURCES_DEF = 
	"#define GetResource(ResID)     EE_SysCall1(EE_ID_GetResource, ResID)\n" +
	"#define ReleaseResource(ResID) EE_SysCall1(EE_ID_ReleaseResource, ResID)\n";
	
	protected final static String EE_ECC1_2_DEF = 
	"#define SetEvent(TaskID, Mask) EE_SysCall2(EE_ID_SetEvent, TaskID, Mask)\n" +
	"#define ClearEvent(Mask)       EE_SysCall1(EE_ID_ClearEvent, Mask)\n" +
	"#define GetEvent(TaskID, Event) EE_SysCall2(EE_ID_GetEvent, TaskID, Event)\n" +
	"#define WaitEvent(Mask)        EE_SysCall1(EE_ID_WaitEvent, Mask)\n\n";
	
	protected final static String EE_ALARMS_DEF = 
	"#define GetAlarmBase(AlarmID, info)                                    \\\n" +
	"                               EE_SysCall2(EE_ID_GetAlarmBase, AlarmID, info)\n" +
	"#define GetAlarm(AlarmID, Tick) EE_SysCall2(EE_ID_GetAlarm, AlarmID, Tick)\n" +
	"#define SetRelAlarm(AlarmID, incr, cycle)                              \\\n" +
	"                               EE_SysCall3(EE_ID_SetRelAlarm, AlarmID, incr, cycle)\n" +
	"#define SetAbsAlarm(AlarmID, sta, cycle)                               \\\n" +
	"                               EE_SysCall3(EE_ID_SetAbsAlarm, AlarmID, sta, cycle)\n" +
	"#define CancelAlarm(AlarmID)   EE_SysCall1(EE_ID_CancelAlarm, AlarmID)\n" +
	"#define GetActiveApplicationMode)                                      \\\n\n";
			
	protected final static String EE_SEM_DEF = 
	"#ifdef __OO_SEM__\n" +
	"#define InitSem(sem, value)    EE_SysCall2(EE_ID_InitSem, sem, value)\n" +
	"#define WaitSem(sem)           EE_SysCall1(EE_ID_WaitSem, sem)\n" +
	"#define TryWaitSem(sem)        EE_SysCall1(EE_ID_TryWaitSem, sem)\n" +
	"#define PostSem(sem)           EE_SysCall1(EE_ID_PostSem, sem)\n" +
	"#define GetValueSem(sem)       EE_SysCall1(EE_ID_GetValueSem, sem)\n" +
	"#endif // __OO_SEM__\n\n";
	
	
	
	protected final static String indent1 = IWritersKeywords.INDENT;
	protected final static String indent2 = IWritersKeywords.INDENT + IWritersKeywords.INDENT;
	
	
	protected final static String EE_OS_SERVICES_ADDRS = 
		indent1+"(EE_ADDR)EE_oo_ActivateTask,\n" +
		indent1+"(EE_ADDR)EE_oo_TerminateTask,\n" +
		indent1+"(EE_ADDR)EE_oo_ChainTask,\n" +
		indent1+"(EE_ADDR)EE_oo_Schedule,\n" +
		indent1+"(EE_ADDR)EE_oo_ForceSchedule,\n" +
		indent1+"(EE_ADDR)EE_oo_GetTaskID,\n" +
		indent1+"(EE_ADDR)EE_oo_GetTaskState,\n" +
		indent1+"(EE_ADDR)EE_oo_EnableAllInterrupts,\n" +
		indent1+"(EE_ADDR)EE_oo_DisableAllInterrupts,\n" +
		indent1+"(EE_ADDR)EE_oo_ResumeAllInterrupts,\n" +
		indent1+"(EE_ADDR)EE_oo_SuspendAllInterrupts,\n" +
		indent1+"(EE_ADDR)EE_oo_ResumeOSInterrupts,\n" +
		indent1+"(EE_ADDR)EE_oo_SuspendOSInterrupts,\n" +
		indent1+"(EE_ADDR)EE_oo_GetActiveApplicationMode,\n" +
		indent1+"(EE_ADDR)EE_oo_StartOS,\n" +
		indent1+"(EE_ADDR)EE_oo_ShutdownOS";
		
		protected final static String EE_RESOURCES_ADDRS = 
			indent1+"(EE_ADDR)EE_oo_GetResource,\n" +
			indent1+"(EE_ADDR)EE_oo_ReleaseResource";
		
		protected final static String EE_ECC1_2_ADDRS = 
			indent1+"(EE_ADDR)EE_oo_SetEvent,\n" +
			indent1+"(EE_ADDR)EE_oo_ClearEvent,\n" +
			indent1+"(EE_ADDR)EE_oo_GetEvent,\n" +
			indent1+"(EE_ADDR)EE_oo_WaitEvent";
		
		protected final static String EE_ALARMS_ADDRS = 
			indent1+"(EE_ADDR)EE_oo_GetAlarmBase,\n" +
			indent1+"(EE_ADDR)EE_oo_GetAlarm,\n" +
			indent1+"(EE_ADDR)EE_oo_SetRelAlarm,\n" +
			indent1+"(EE_ADDR)EE_oo_SetAbsAlarm,\n" +
			indent1+"(EE_ADDR)EE_oo_CancelAlarm";
				
		protected final static String EE_SEM_ADDRS = 
			"#ifdef __OO_SEM__\n" +
			indent1+"(EE_ADDR)EE_oo_InitSem,\n" +
			indent1+"(EE_ADDR)EE_oo_WaitSem,\n" +
			indent1+"(EE_ADDR)EE_oo_TryWaitSem,\n" +
			indent1+"(EE_ADDR)EE_oo_PostSem,\n" +
			indent1+"(EE_ADDR)EE_oo_GetValueSem\n" +
			"#endif // __OO_SEM__";
	
	
		protected final static String LINKER_HEADER = 
			"/* Temporary linker script with 2 OsApps. */\n" +
			"MEMORY\n" +
			"{\n" +
			"	boot:	org = 0x00000000, len = 0x00020000\n" +
			"	iflash:	org = 0x00020000, len = 0x001c0000\n" +
			"	isram:	org = 0x40000000, len = 0x00040000\n" +
			"}\n" +
			"\n" +
			"SECTIONS\n" +
			"{\n" +
			"	GROUP : {\n" +
			"		.boot : { }\n" +
			"	} > boot\n" +
			"\n" +
			"	GROUP : {\n" +
			"		.text : {\n" +
			"			*(.text)\n" +
			"			*(.init)\n" +
			"			*(.fini)\n" +
			"			*(.rdata)\n" +
			"			*(.rodata)\n" +
			"		}\n" +
			"\n" +
			"		_SDA2_BASE_ = . ;\n" +
			"		.sdata2 : { }\n" +
			"		_load_ram = . ;\n" +
			"	} > iflash\n" +
			"\n" +
			"	GROUP : {\n" +
			"		_sdata = . ;\n" +
			"		app0_start = . ;\n" +
			"		.data LOAD(_load_ram): { }\n" +
			"\n" +
			"		_SDA_BASE_ = . ;\n" +
			"		.sdata LOAD(_load_ram + ADDR(.sdata) - ADDR(.data)): { }\n" +
			"\n" +
			"		_sbss = . ;\n" +
			"		.sbss : { }\n" +
			"		.bss : { }\n" +
			"		_ebss = . ;\n" +
			"\n" +
			"		_sstack = . ;\n" +
			"		app0_sstart = . ;\n" +
			"		.stack (BSS) : { *(.stack) }\n" +
			"		_estack = . ;\n" +
			"		app0_end = . ;\n\n";
		
		protected final static String LINKER_END =
			"	} > isram\n" +
			"}\n";
		
		
		
		
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;
	
	/**
	 * 
	 */
	public SectionWriterKernelSystemCalls() {
		this(null);
	}
	
	/**
	 * 
	 */
	public SectionWriterKernelSystemCalls(ErikaEnterpriseWriter parent) {
		super("SYS_CALLS",
				new String[] {}, //
				new String[] {},
					SWCategoryManager.defaultInstance.newCategory(SWCategoryManager.TYPE_KERNEL));
		
		this.parent = parent;
	}
	
	@Override
	protected boolean enabled() {
		return checkMemoryProtection() && (Collections.binarySearch(keywords, IWritersKeywords.CPU_PPCE200ZX) > 0);
//		return (
//				(Collections.binarySearch(keywords, IWritersKeywords.OSEK_ECC1) > 0) 
//				|| (Collections.binarySearch(keywords, IWritersKeywords.OSEK_ECC2) > 0)
//			) && (Collections.binarySearch(keywords, IWritersKeywords.CPU_MPC5674F) > 0);
	}
	
	@Override
	protected IOilWriterBuffer[] internalWrite(IVarTree vt)
			throws OilCodeWriterException {
		
		IOilWriterBuffer answer = new OilWriterBuffer();
		final int currentRtosId = 0;
		final IOilObjectList ool = parent.getOilObjects()[currentRtosId];
		
		addSysCalls(ool, answer);
		addOsApplications(ool, answer);
		writeIsr(ool, answer);
		
		return new IOilWriterBuffer[] {answer};
	}
	
	
	protected void addSysCalls(IOilObjectList ool, IOilWriterBuffer answer) {
		ISimpleGenRes os = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
		List<Integer> requiredOilObjects = (List<Integer>) os.getObject(SGRK__FORCE_ARRAYS_LIST__);

		final ICommentWriter commentWriterH = getCommentWriter(os, FileTypes.H);
		final ICommentWriter commentWriterC = getCommentWriter(os, FileTypes.C);

		StringBuffer ee_asm_buffer = answer.get(EE_ASM_FILE_H);

		StringBuffer ee_c_buffer = answer.get(FILE_EE_CFG_C);
		ee_c_buffer.append(commentWriterC.writerBanner("System Calls") + 
				"const EE_ADDR EE_e200z7_syscall_table[] = {\n");
				
		StringBuffer ids = new StringBuffer();
		StringBuffer shortNames = new StringBuffer();
//		ee_asm_buffer.append("#ifndef __EE_ASM_H__\n" +
//				"#define __EE_ASM_H__\n\n");
		
		
		// this counter is the ID of the next sys call
		int counter = 0;
		final String end = ",\n\n";
		
		// OS Services
		for (String s: EE_OS_SERVICES_IDs) {
			ids.append("#define "+s+ (counter <10 ? " " : "") + counter +"\n");
			counter ++;
		}
		shortNames.append(EE_OS_SERVICES_DEF);
		ee_asm_buffer.append(
				"#define EE_OS_SERVICEID        32\n" +
				"#define EE_GENERAL_IDS         "+EE_OS_SERVICES_IDs.length+"\n\n");
		ee_c_buffer.append(EE_OS_SERVICES_ADDRS);
		
		// Resources
		if (ool.getList(IOilObjectList.RESOURCE).size() == 0
				&& !requiredOilObjects.contains(new Integer(IOilObjectList.RESOURCE)))  {

			for (String s: EE_RESOURCES_IDs) {
				ids.append("#define "+s+ (counter <10 ? " " : "") + counter +"\n");
				counter ++;
			}
			shortNames.append(EE_RESOURCES_DEF);
			
			ee_asm_buffer.append("#define EE_RESOURCES_IDS        "+EE_RESOURCES_IDs.length+"\n\n");
			ee_c_buffer.append(end + EE_RESOURCES_ADDRS);
		} else {
			ee_asm_buffer.append("#define EE_RESOURCES_IDS        0\n\n");
		}
		
		// Alarm
		if ( ool.getList(IOilObjectList.ALARM).size() > 0 
				|| requiredOilObjects.contains(new Integer(IOilObjectList.ALARM)))  {

			for (String s: EE_ALARMS_IDs) {
				ids.append("#define "+s+ (counter <10 ? " " : "") + counter +"\n");
				counter ++;
			}
			shortNames.append(EE_ALARMS_DEF);
			
			ee_asm_buffer.append("#define EE_ALARMS_IDS           "+EE_ALARMS_IDs.length+"\n\n");
			ee_c_buffer.append(end + EE_ALARMS_ADDRS);
		} else {
			ee_asm_buffer.append("#define EE_ALARMS_IDS           0\n\n");
		}
		
		// Events
		if (parent.checkKeyword(IWritersKeywords.OSEK_ECC1) 
				|| parent.checkKeyword(IWritersKeywords.OSEK_ECC2))  {

			for (String s: EE_ECC1_2_IDs) {
				ids.append("#define "+s+ (counter <10 ? " " : "") + counter +"\n");
				counter ++;
			}
			shortNames.append(EE_ECC1_2_DEF);
			
			ee_asm_buffer.append("#define EE_EVENTS_IDS           "+EE_ECC1_2_IDs.length+"\n\n");
			ee_c_buffer.append(end + EE_ECC1_2_ADDRS);
		} else {
			ee_asm_buffer.append("#define EE_EVENTS_IDS           0\n\n");
		}

		
		// Semaphores
		if ( true )  {

			ids.append("#ifdef __OO_SEM__\n"); // !!
			for (String s: EE_SEM_IDs) {
				ids.append("#define "+s+ (counter <10 ? " " : "") + counter +"\n");
				counter ++;
			}
			ids.append("#endif\n\n");  //!!
			shortNames.append(EE_SEM_DEF);
			ee_c_buffer.append(end + EE_SEM_ADDRS);
	
			
			ee_asm_buffer.append(
					"#ifdef __OO_SEM__\n" +
					"#define EE_SEM_IDS              "+EE_SEM_IDs.length+"\n" +
					"#else\n" +
					"#define EE_SEM_IDS              0\n" +
					"#endif\n\n");
//			ee_asm_buffer.append("#define EE_SEM_IDS              "+EE_SEM_IDs.length+"\n\n");
//		} else {
//			ee_asm_buffer.append("#define EE_SEM_IDS              0\n\n");
		}
		
		
		
		ee_asm_buffer.append("#define EE_SYSCALL_NR		(EE_GENERAL_IDS + EE_RESOURCES_IDS +	\\\n" +
				"				 EE_ALARMS_IDS + EE_SEM_IDS + EE_EVENTS_IDS)\n\n");
		
		final StringBuffer ee_buffer = answer.get(FILE_EE_CFG_H);
		ee_buffer.append(commentWriterH.writerBanner("System Calls")
				+ ids.toString() + "\n"
				+ shortNames.toString() + "\n");

		ee_c_buffer.append("\n};");
	}
	

	protected void addOsApplications(IOilObjectList ool, IOilWriterBuffer answer) throws OilCodeWriterException {
		List<ISimpleGenRes> applications = ool.getList(IOilObjectList.OSAPPLICATION);
		ISimpleGenRes os = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);

		StringBuffer ee_h_buffer = answer.get(FILE_EE_CFG_H);
		final ICommentWriter commentWriterH = getCommentWriter(os, FileTypes.H);

		StringBuffer ee_c_buffer = answer.get(FILE_EE_CFG_C);
		final ICommentWriter commentWriterC = getCommentWriter(os, FileTypes.C);
		
		StringBuffer linker_buffer = answer.get(EE_LINKER_FILE);

		// ee_cfg.h
		ee_h_buffer.append(
				commentWriterH.writerBanner("OS APPLICATIONS definition") +
				indent1 + "#define EE_MAX_APP " + (applications.size() +1) +"\n\n"); 				

		// ee_cfg.c
		ee_c_buffer.append(
				commentWriterC.writerBanner("OS APPLICATIONS definition") +
				"extern int sdata, ebss;\n");
				
		StringBuffer application_rom = new StringBuffer(
				indent1 + "const EE_as_Application_ROM_type EE_as_Application_ROM[EE_MAX_APP] = {\n");
		
		StringBuffer application_ram = new StringBuffer(
				indent1 + "EE_as_Application_RAM_type EE_as_Application_RAM[EE_MAX_APP] = {\n");
		
		// linker
		linker_buffer.append(LINKER_HEADER);
				
		{ // DEFAULT APPLICATION
			if (!os.containsProperty(ISimpleGenResKeywords.OS_IRQ_STACK_ID)) {
				throw new OilCodeWriterException("Required irq stack for default application");
			}
			String stack_id = os.getString(ISimpleGenResKeywords.OS_IRQ_STACK_ID);
			
			final String name = "app0";
			ee_h_buffer.append(indent1 + "#define EE_e200z7_"+name+"_mode    0x8000\n");
			ee_c_buffer.append("extern const int "+name+"_start, "+name+"_sstart, "+name+"_end;\n");
			application_rom.append(indent2 + "{(EE_ADDR)"+name+"_start, (EE_ADDR)"+name+"_sstart, (EE_ADDR)"+name+"_sstart, (EE_ADDR)"+name+"_end }");
			
			application_ram.append(indent2 + "{(EE_ADDR)&EE_e200z7_stack_"+stack_id+"[STACK_"+stack_id+"_SIZE - 2], EE_e200z7_"+name+"_mode, 0, 0 }");
		}
		
		for (ISimpleGenRes application : applications) {
			boolean trusted = application.containsProperty(OS_APPLICATION_TRUESTED) 
						&& "true".equalsIgnoreCase(application.getString(OS_APPLICATION_TRUESTED));
			final String name = application.getName();
			String stack_id = application.getString(OS_APPLICATION_IRQ_STACK_ID);

			// ee_cfg.h
//			#define EE_e200z7_app0_mode     0x8000
//			#define EE_e200z7_app1_mode     0xc000
//			#define EE_e200z7_app2_mode     0xc000
			ee_h_buffer.append(indent1 +"#define EE_e200z7_"+name+"_mode    " 
								+ (trusted ? "0x8000" : "0xc000" ) + "\n");


			// ee_cfg.c
//			extern const int app0_start, app0_sstart, app0_end;
			ee_c_buffer.append("extern const int "+name+"_start,"+name+"_sstart, "+name+"_end;\n");
			
//			
			application_rom.append(",\n" + 
					indent2 + "{(EE_ADDR)"+name+"_start, (EE_ADDR)"+name+"_sstart, (EE_ADDR)"+name+"_sstart, (EE_ADDR)"+name+"_end }");

			application_ram.append(",\n" + 
					indent2 + "{(EE_ADDR)&EE_e200z7_stack_"+stack_id+"[STACK_"+stack_id+"_SIZE - 2], EE_e200z7_"+name+"_mode, 0, 0 }");

			
			linker_buffer.append(
					"		. = ALIGN(32);\n" +
					"		"+name+"_start = . ;\n" +
					"		"+name+" : {\n" +
					"			"+name+".o(.data)\n" +
					"			"+name+".o(.bss)\n" +
					"			"+name+"_sstart = . ;\n" +
					"			*(."+name+"_stack)\n" +
					"		}\n" +
					"		"+name+"_end = . ;);\n\n");
		}
		
		
		application_rom.append("\n" + indent1 +"};\n\n");
		application_ram.append("\n" + indent1 +"};\n\n");

		ee_c_buffer.append("\n" +
				application_rom + "\n" +
				application_ram);

		linker_buffer.append(LINKER_END);
	}


	
	protected void writeIsr(IOilObjectList ool, IOilWriterBuffer answer) {

		List<ISimpleGenRes> isrList = ool.getList(IOilObjectList.ISR);
		List<ISimpleGenRes> osApplications = ool.getList(IOilObjectList.OSAPPLICATION);
		ISimpleGenRes os = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);

		StringBuffer ee_h_buffer = answer.get(FILE_EE_CFG_H);
		final ICommentWriter commentWriterH = getCommentWriter(os, FileTypes.H);

		StringBuffer ee_c_buffer = answer.get(FILE_EE_CFG_C);
		final ICommentWriter commentWriterC = getCommentWriter(os, FileTypes.C);
		

		int max_level = 16;
		if (os.containsProperty(OS_MAX_NESTING_LEVEL)) {
			max_level = os.getInt(OS_MAX_NESTING_LEVEL);
		}

		// ee_cfg.h
		ee_h_buffer.append(
				commentWriterH.writerBanner("ISR definition") +
				indent1 + "#define EE_MAX_NESTING_LEVEL     "+max_level+"\n" +
				indent1 + "#define EE_MAX_ISR               " + (isrList.size()) +"\n\n"); 				

		// ee_cfg.c
		ee_c_buffer.append(
				commentWriterC.writerBanner("ISR definition") +
				indent1 + "EE_as_ISR_RAM_type EE_as_ISR_stack[EE_MAX_NESTING_LEVEL];\n\n" +
				indent1 + "const EE_as_ISR_ROM_type EE_as_ISR_ROM[EE_MAX_ISR] = {\n");
				
		StringBuffer appl_id = new StringBuffer(commentWriterC.writerSingleLineComment("ISR to Application mapping"));
		StringBuffer isr_id = new StringBuffer(commentWriterC.writerSingleLineComment("ISR id"));

		String pre = "";
		for (ISimpleGenRes isr : isrList) {
			String name = isr.getName();
			
			int aid = isr.containsProperty(ISimpleGenResKeywords.ISR_OS_APPLICATION_NAME) ? 
					1+ getOsApplicationIndex(isr.getString(ISimpleGenResKeywords.ISR_OS_APPLICATION_NAME), osApplications)
					: 0;
			int iid = isr.getInt(ISimpleGenResKeywords.ISR_ID);
			appl_id.append(indent1 + "#define ISR2_APP_"+name+"\t" + aid + "\n");
			isr_id.append(indent1 + "#define ISR2_ID_"+name+"\t" + iid + "\n");
			
			ee_c_buffer.append(pre + indent2 + "{ ISR2_APP_"+name+" }");
			pre = ",\n";
		}

		ee_h_buffer.append(appl_id + "\n" + isr_id + "\n");
		
		ee_c_buffer.append("\n"+indent1+"};\n\n");

	}
	
	
	@Override
	public void updateObjects() throws OilCodeWriterException {
		final IVarTree vt = parent.getVt();
		final String trustedPath = S
					+ DataPackage.eINSTANCE.getOsApplication_OilVar().getName() + S
					+ IOilXMLLabels.OBJ_OS + parent.getOilHwRtosPrefix() + "TRUSTED";
		
		final String taskOsApplRefPath = S
					+ DataPackage.eINSTANCE.getOsApplication_OilVar().getName() + S
					+ IOilXMLLabels.OBJ_TASK + parent.getOilHwRtosPrefix() + "APPLICATION"; 

		
		final String isrOsApplRefPath = S
					+ DataPackage.eINSTANCE.getOsApplication_OilVar().getName() + S
					+ IOilXMLLabels.OBJ_ISR + parent.getOilHwRtosPrefix() + "APPLICATION";
		
		final String osNestingLevelPath = S
					+ DataPackage.eINSTANCE.getOsApplication_OilVar().getName() + S
					+ IOilXMLLabels.OBJ_OS + parent.getOilHwRtosPrefix() + "MAX_NESTING_LEVEL";

		final IOilObjectList[] oilObjects = parent.getOilObjects();	
		for (IOilObjectList ool : oilObjects) {

			
			{ // nesting level
				ISimpleGenRes os = ool.getList(IOilObjectList.OS).get(0);
				String[] value = CommonUtils.getValue(vt, os.getPath() + osNestingLevelPath);
				if (value != null && value.length>0 && value[0] != null && value[0].length()>0) {
					os.setProperty(OS_MAX_NESTING_LEVEL, value[0]);
				}
			}
			
			
			
			// OS applications
			List<ISimpleGenRes> applications = ool.getList(IOilObjectList.OSAPPLICATION);
			for (ISimpleGenRes appl : applications) {
			
				String type = CommonUtils.getFirstChildEnumType(vt, appl.getPath() + trustedPath, null);
				if ("true".equalsIgnoreCase(type)) {
					appl.setProperty(OS_APPLICATION_TRUESTED, "true");
				}
				
			}
			
			// tasks
			List<ISimpleGenRes> tasks = ool.getList(IOilObjectList.TASK);
			for (ISimpleGenRes task : tasks) {
			
				String[] os_appl_ref = CommonUtils.getValue(vt, task.getPath() + taskOsApplRefPath);
				if (os_appl_ref != null && os_appl_ref.length>0 && os_appl_ref[0] != null && os_appl_ref[0].length()>0) {
					task.setProperty(ISimpleGenResKeywords.TASK_OS_APPLICATION_NAME, os_appl_ref[0]);
				}
				
			}

			// isr
			List<ISimpleGenRes> isrs = ool.getList(IOilObjectList.ISR);
			int isr_id = 0;
			for (ISimpleGenRes isr : isrs) {
			
				String[] os_appl_ref = CommonUtils.getValue(vt, isr.getPath() + isrOsApplRefPath);
				if (os_appl_ref != null && os_appl_ref.length>0 && os_appl_ref[0] != null && os_appl_ref[0].length()>0) {
					isr.setProperty(ISimpleGenResKeywords.ISR_OS_APPLICATION_NAME, os_appl_ref[0]);
				}

				isr.setProperty(ISimpleGenResKeywords.ISR_ID, ""+isr_id);
				isr_id ++;

			}

		}
	}

	@Override
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix)
			throws OilCodeWriterException {
		
		final IVarTree vt = parent.getVt();
		final String osMemProtectionPath = S
				+ DataPackage.eINSTANCE.getOsApplication_OilVar().getName() + S
				+ IOilXMLLabels.OBJ_OS + parent.getOilHwRtosPrefix() + "MEMORY_PROTECTION";

		for (String s : rtosPrefix) {
			String os_appl_ref = CommonUtils.getFirstChildEnumType(vt, s+osMemProtectionPath, null);
			if ("true".equalsIgnoreCase(os_appl_ref)) {
				if (!keywords.contains(EE_OPT_MEMORY_PROTECTION)) {
					keywords.add(EE_OPT_MEMORY_PROTECTION);
				}
				break;
			}
		}
	}	
	
	
	@Override
	public List<String> getEEOpt(int type, int rtosId) {
		List<String> answer = new ArrayList<String>();
		if ((type & EE_OPT_COMMON_AUTO_ONLY)!= 0 && checkMemoryProtection()) {
			answer.add(EE_OPT_MEMORY_PROTECTION);
			answer.add(EE_OPT_SC4);
		}
		return answer;
	}
	/**
	 * 
	 * @param osAppl
	 *            os application name
	 * @param osApplicationList
	 *            all os applications
	 * @return the position in the array of specified os application
	 */
	protected int getOsApplicationIndex(String osAppl, List<ISimpleGenRes> osApplicationList) {
		if (osAppl != null) {
			for (int i=0; i<osApplicationList.size(); i++) {
				if (osAppl.equals(osApplicationList.get(i).getName())) {
					return i;
				}
			}
		}
		return -1;
	}

	protected boolean checkMemoryProtection() {
		return parent.checkKeyword(EE_OPT_MEMORY_PROTECTION);
	}
}
