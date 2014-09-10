/*
 * Created on 1-oct-2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.sectionwriter;

import static com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils.addToAllStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.SectionWriterIsr;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription.OsApplicationAreas;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuUtility;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStacks;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IRemoteNotificationsConstants;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilObjectType;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.tools.Search;

/**
 * This writer manages OS Application
 * 
 * @author Nicola Serreli
 */
public class SectionWriterOsApplication extends SectionWriter implements
		IEEWriterKeywords, IRemoteNotificationsConstants,
		IExtractObjectsExtentions, IGetEEOPTExtentions,
		IExtractKeywordsExtentions {
	
	/**
	 * 
	 */
	private static final String NO_HOOK = "0U";
	
	public final static String SGR_OS_MAX_NESTING_LEVEL = "sgr_os_max_nesting_level";
	

	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;

	/** All data */
	protected final IVarTree vt;
	
	public final static String OS_APPLICATION_MEM_BASE = "SGR_os_application_mem_base";
	public final static String OS_APPLICATION_MEM_SIZE = "SGR_os_application_mem_size";
	public final static String OS_APPLICATION_SHARED_SIZE = "SGR_os_application_shared_size";
	public final static String OS_APPLICATION_IRQ_SIZE = "SGR_os_application_irq_size";
	public final static String OS_APPLICATION_RESTART_TASK = "SGR_os_application_restart_task";
	
	
	public final static String EE_APPS_CONF = "apps.conf";
	
	
	protected final static String indent1 = IWritersKeywords.INDENT;
	protected final static String indent2 = IWritersKeywords.INDENT + IWritersKeywords.INDENT;
	protected final static String white = "                                        ";

	/**
	 * 
	 */
	public SectionWriterOsApplication() {
		this(null);
	}
	
	/**
	 * 
	 */
	public SectionWriterOsApplication(ErikaEnterpriseWriter parent) {
		super("OS_APPLICATION", new String[] {}, //
				new String[] {},
				SWCategoryManager.defaultInstance.newCategory(
						SWCategoryManager.TYPE_KERNEL,
						IWritersKeywords.KERNEL_MEMORY_PROTECTION_PRIORITY-1));
		
		this.parent = parent;
		this.vt = parent == null ? null : parent.getVt();
	}

	/**
	 * This method returns true if current instance of writer is enabled with
	 * specified keywords.
	 * 
	 * This writer is enabled if there is only one cpu
	 * 
	 * @return true if this writer is enabled
	 */
	protected boolean enabled() {
		return Collections.binarySearch(keywords, IWritersKeywords.KERNEL_OS_APPLICATION) >=0 ;
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
		
		if (!parent.checkKeyword(IEEWriterKeywords.DEF__MULTI_STACK__) 
				&& parent.checkKeyword(IWritersKeywords.KERNEL_OS_APPLICATION)) {
			Messages.sendWarningNl("OsApplication should be used with multi stack enabled.");
		}
		
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		IOilWriterBuffer[] answer = new IOilWriterBuffer[oilObjects.length];
		for (int currentRtosId = 0; currentRtosId <oilObjects.length; currentRtosId++) {
			IOilWriterBuffer buff = new OilWriterBuffer();
			answer[currentRtosId] = buff;
			
			final IOilObjectList ool = oilObjects[currentRtosId];
			
			addOsApplications(ool, buff);
			
			writeIsr(ool, buff);
		}
		

		return answer;
	}

	protected void addOsApplications(IOilObjectList ool, IOilWriterBuffer answer) throws OilCodeWriterException {
		final boolean needStackMonitoring = true; //force parent.checkKeyword(ISimpleGenResKeywords.OS_STACK_MONITORING);
		CpuHwDescription cpuDescr = ErikaEnterpriseWriter.getCpuHwDescription(ool);
		OsApplicationAreas areaNames = cpuDescr == null ? null : cpuDescr.getOsApplicationNames();
		
		List<ISimpleGenRes> applications = ool.getList(IOilObjectList.OSAPPLICATION);
		
		StringBuffer ee_h_buffer = answer.get(FILE_EE_CFG_H);
		final ICommentWriter commentWriterH = getCommentWriter(ool, FileTypes.H);

		StringBuffer ee_c_buffer = answer.get(FILE_EE_CFG_C);
		final ICommentWriter commentWriterC = getCommentWriter(ool, FileTypes.C);
		
		// ee_cfg.h
		ee_h_buffer.append(
				commentWriterH.writerBanner("OS APPLICATIONS definition") +
				indent1 + "#define EE_MAX_APP " + (applications.size() +1)+"U\n"); 	
		for (ISimpleGenRes application : applications) {
			ee_h_buffer.append(indent1+ "#define " + application.getName() 
					+ " "+ application.getInt(ISimpleGenResKeywords.OS_APPL_ID)+"U\n" );
		
		}
		ee_h_buffer.append("\n");

		// ee_cfg.c
		ee_c_buffer.append(
				commentWriterC.writerBanner("OS APPLICATIONS definition"));
		
		
				
		StringBuffer application_rom = new StringBuffer(
				indent1 + "const EE_as_Application_ROM_type EE_as_Application_ROM[EE_MAX_APP] = {\n" +
				indent2 + "{{ ");
		if (areaNames != null) {
			if (areaNames.getConstKAreas().isEmpty() && areaNames.getKAreas().isEmpty()) {

				String sep = "";
				final int size = areaNames.getConstAreas().size() + areaNames.getAreas().size();
				for (int i=0; i<size; i++) {
					application_rom.append(sep + "0U");
					sep = ", ";
				}

			} else {
				
				for (String areaName : areaNames.getConstKAreas()) {
					ee_c_buffer.append(indent1 + "extern const int " + areaName+";\n");
				}
				for (String areaName : areaNames.getKAreas()) {
					ee_c_buffer.append(indent1 + "extern int " + areaName+";\n");
				}
				ee_c_buffer.append("\n");
				
				String sep = "";
				for (String areaName : areaNames.getConstKAreas()) {
					application_rom.append(sep + "&" + areaName);
					sep = ", ";
				}
				for (String areaName : areaNames.getKAreas()) {
					application_rom.append(sep + "&" + areaName);
					sep = ", ";
				}
				
			}
		}
		application_rom.append(" }, EE_MEMPROT_TRUST_MODE" +
				(needStackMonitoring ? ", 0U": "") +
				", EE_NIL}");
		
		StringBuffer application_ram = new StringBuffer(
				indent1 + "EE_as_Application_RAM_type EE_as_Application_RAM[EE_MAX_APP];\n");
				//= {\n" +				indent2 + "EE_APP_RAM_INIT(0U)");
		
				
		StringBuilder startUp_buffer  = new StringBuilder(indent1 +"const EE_HOOKTYPE EE_as_Application_startuphook[EE_MAX_APP] = {\n" +
				indent2 + NO_HOOK);
		StringBuilder shutdown_buffer = new StringBuilder(indent1 +"const EE_STATUSHOOKTYPE EE_as_Application_shutdownhook[EE_MAX_APP] = {\n" +
				indent2 + NO_HOOK);
		StringBuilder error_buffer    = new StringBuilder(indent1 +"const EE_STATUSHOOKTYPE EE_as_Application_errorhook[EE_MAX_APP] = {\n" +
				indent2 + NO_HOOK);

		StringBuilder startUp_decl_buffer  = new StringBuilder(indent1 + commentWriterC.writerSingleLineComment("Os Application Startup Hooks"));
		StringBuilder shutdown_decl_buffer = new StringBuilder(indent1 + commentWriterC.writerSingleLineComment("Os Application Shutdown Hooks"));
		StringBuilder error_decl_buffer    = new StringBuilder(indent1 + commentWriterC.writerSingleLineComment("Os Application Errork Hooks"));

		final boolean enableMemoryProtection = parent.checkKeyword(IWritersKeywords.KERNEL_MEMORY_PROTECTION);
		StringBuffer linker_buffer = new StringBuffer();
		String end = ",\n";
		for (ISimpleGenRes application : applications) {
			// if memory protection is disabled, everything is handled as trusted
			final boolean trusted;
			if (enableMemoryProtection)  {
				trusted = application.containsProperty(IEEWriterKeywords.OS_APPLICATION_TRUSTED) 
								&& "true".equalsIgnoreCase(application.getString(IEEWriterKeywords.OS_APPLICATION_TRUSTED));
			} else {
				if (application.containsProperty(IEEWriterKeywords.OS_APPLICATION_TRUSTED) 
						&& !("true".equalsIgnoreCase(application.getString(IEEWriterKeywords.OS_APPLICATION_TRUSTED)))) {
					Messages.sendWarningNl("The osApplication " +application.getName() + " is defined as NOT TRUSTED, but without memory protection it is handled as trusted.");
				}
				
				trusted = true;
			}
			final String name = application.getName();
			String stack_id = application.getString(ISimpleGenResKeywords.OS_APPL_SHARED_STACK_ID);
			String stack_base_name = application.getString(EEStacks.STACK_BASE_NAME_PREFIX);
			
			

			String hError = application.containsProperty(IEEWriterKeywords.OS_APPLICATION_HOOK_ERROR) 
					&& "true".equalsIgnoreCase(application.getString(IEEWriterKeywords.OS_APPLICATION_HOOK_ERROR))?
							"ErrorHook_" + application.getName() : NO_HOOK;
			String hStartup = application.containsProperty(IEEWriterKeywords.OS_APPLICATION_HOOK_STARTUP) 
					&& "true".equalsIgnoreCase(application.getString(IEEWriterKeywords.OS_APPLICATION_HOOK_STARTUP))?
							"StartupHook_" + application.getName() : NO_HOOK;
			String hShutdown = application.containsProperty(IEEWriterKeywords.OS_APPLICATION_HOOK_SHUTDOWN) 
					&& "true".equalsIgnoreCase(application.getString(IEEWriterKeywords.OS_APPLICATION_HOOK_SHUTDOWN))?
							"ShutdownHook_" + application.getName() : NO_HOOK;


			// ee_cfg.c
//			extern const int app0_start, app0_sstart, app0_end;

			//if (enableMemoryProtection) 
			{
				String mem_base = application.containsProperty(OS_APPLICATION_MEM_BASE) ? application.getString(OS_APPLICATION_MEM_BASE) : "0";
				String mem_size = application.containsProperty(OS_APPLICATION_MEM_SIZE) ? application.getString(OS_APPLICATION_MEM_SIZE) : "0";
				String restartTask = application.getString(OS_APPLICATION_RESTART_TASK);
				
				linker_buffer.append(
						name + 
						(name.length() < 30 ? white.substring(0, 30-name.length()) : "" ) + " " + 
						mem_base + " " +
						mem_size + " " +
						(trusted ? "1" : "0")+
						"\n");
				for (String areaName : areaNames.getConstAreas()) {
					ee_c_buffer.append(indent1 + "extern const int " + areaName+"_"+name+";\n");
				}
				for (String areaName : areaNames.getAreas()) {
					ee_c_buffer.append(indent1 + "extern int " + areaName+"_"+name+";\n");
				}
				ee_c_buffer.append("\n");
	
				application_rom.append(end +
						indent2 + "{{ ");
				
				if (areaNames != null) {
					String sep = "";
					for (String areaName : areaNames.getConstAreas()) {
						application_rom.append(sep + "&" + areaName+"_"+name);
						sep = ", ";
					}
					for (String areaName : areaNames.getAreas()) {
						application_rom.append(sep + "&" + areaName+"_"+name);
						sep = ", ";
					}
				}
				
				application_rom.append(" }, "+
							(trusted ? "EE_MEMPROT_TRUST_MODE" : "EE_MEMPROT_USR_MODE") +
							(needStackMonitoring ? ", "+(stack_id.length() == 0 || "-1".equals(stack_id)? "((EE_UREG)-1)": stack_id+"U"): "") +
							", "+restartTask+"}");
			}

//			if (parent.checkKeyword(IWritersKeywords.CPU_PPCE200ZX)) {
//				application_ram.append(end +
//						indent2 + "EE_APP_RAM_INIT(&"+stack_base_name+stack_id+"[EE_STACK_INITP(STACK_"+stack_id+"_SIZE)])");
//			} else {
//				application_ram.append(end +
//						indent2 + "EE_APP_RAM_INIT(EE_STACK_INITP("+stack_base_name+stack_id+"))");
//			}
			
			startUp_buffer.append(end +indent2 + hStartup);
			shutdown_buffer.append(end +indent2 + hShutdown);
			error_buffer.append(end +indent2 + hError);
			
			if (hStartup  != NO_HOOK) { startUp_decl_buffer.append( indent1 + "extern void "+hStartup +" ( void );\n"); };
			if (hShutdown != NO_HOOK) { shutdown_decl_buffer.append(indent1 + "extern void "+hShutdown+" ( StatusType );\n"); };
			if (hError    != NO_HOOK) { error_decl_buffer.append(   indent1 + "extern void "+hError+   " ( StatusType );\n"); };


			
			end = ",\n";
		}

		answer.get(EE_APPS_CONF).append(linker_buffer + "\n");
		
		application_rom.append("\n" + indent1 +"};\n\n");
		//application_ram.append("\n" + indent1 +"};\n\n");
		startUp_buffer.append("\n" + indent1 +"};\n\n");
		shutdown_buffer.append("\n" + indent1 +"};\n\n");
		error_buffer.append("\n" + indent1 +"};\n\n");

		ee_c_buffer.append("\n" +
				application_rom + "\n" + application_ram + "\n" +  
				startUp_decl_buffer +
				startUp_buffer +
				shutdown_decl_buffer +
				shutdown_buffer +
				error_decl_buffer  +
				error_buffer);
		
		
		
		// Task to application link
		
		ee_c_buffer.append(indent1 + "const ApplicationType EE_th_app[EE_MAX_TASK+1] = {\n" +
				indent2 + "0");
		end = "\t"+commentWriterC.writerSingleLineComment("dummy");
		for (ISimpleGenRes task: ool.getList(IOilObjectList.TASK) ) {
			if (!task.containsProperty(ISimpleGenResKeywords.OS_APPL_ID)) {
				throw new OilCodeWriterException("The task " + task.getName() + " is not related to any OsApplication.");
			}
			ee_c_buffer.append("," + end +
					indent2 + task.getInt(ISimpleGenResKeywords.OS_APPL_ID) );
			end = "\t"+commentWriterC.writerSingleLineComment(task.getName());
		}
		
		ee_c_buffer.append(" " + end + indent1 + "};\n\n");
		
		
		if (parent.checkKeyword(IWritersKeywords.KERNEL_SERVICE_PROTECTION)) {
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
			final String MAX_SCHED_TAB = (binaryDistr ? "RTD_" : "EE_") + "MAX_SCHEDULETABLE";
			final String MAX_SPINLOCK = (binaryDistr ? "RTD_" : "EE_") + "MAX_SPINLOCK";
			String pre = "";
			
			ee_c_buffer.append(
					commentWriterC.writerBanner("OS APPLICATIONS ACCESS"));
			
			if (!ool.getList(IOilObjectList.TASK).isEmpty()) {
				ee_c_buffer.append(indent1 + "EE_TYPEACCESSMASK const EE_as_task_access_rules["+MAX_TASK+"] =\n"+indent1+"{\n");
				for (ISimpleGenRes task : ool.getList(IOilObjectList.TASK)) {
					ee_c_buffer.append(pre + indent2 + CpuUtility.getOsAccessBitMask(task, ool, null));
					pre = ",\n";
				}
				ee_c_buffer.append(pre + indent1 + "};\n\n");
			}
			
			if (ErikaEnterpriseWriter.getIsr2Number(ool) >0) {
				pre = "";
				ee_c_buffer.append(indent1 + "EE_TYPEACCESSMASK const EE_as_isr_access_rules[EE_MAX_ISR_ID] =\n"+indent1+"{\n");
				for (ISimpleGenRes isr : SectionWriterIsr.getIsrByID(ool)) {
					ee_c_buffer.append(pre + indent2 + CpuUtility.getOsAccessBitMask(isr, ool, null));
					pre = ",\n";
				}
				ee_c_buffer.append(pre + indent1 + "};\n\n");
			}

			if (!ool.getList(IOilObjectList.RESOURCE).isEmpty()) {
				pre = "";
				ee_c_buffer.append(indent1 + "EE_TYPEACCESSMASK const EE_as_resource_access_rules["+MAX_RESOURCE+"] =\n"+indent1+"{\n");
				for (ISimpleGenRes resource : ool.getList(IOilObjectList.RESOURCE)) {
					ee_c_buffer.append(pre + indent2 + CpuUtility.getOsAccessBitMask(resource, ool, null));
					pre = ",\n";
				}
				ee_c_buffer.append(pre + indent1 + "};\n\n");
			}

			if (!ool.getList(IOilObjectList.ALARM).isEmpty()) {
				pre = "";
				ee_c_buffer.append(indent1 + "EE_TYPEACCESSMASK const EE_as_alarm_access_rules["+MAX_ALARM+"] =\n"+indent1+"{\n");
				for (ISimpleGenRes alarm : ool.getList(IOilObjectList.ALARM)) {
					ee_c_buffer.append(pre + indent2 + CpuUtility.getOsAccessBitMask(alarm, ool, null));
					pre = ",\n";
				}
				ee_c_buffer.append(pre + indent1 + "};\n\n");
			}

			if (!ool.getList(IOilObjectList.COUNTER).isEmpty()) {
				pre = "";
				ee_c_buffer.append(indent1 + "EE_TYPEACCESSMASK const EE_as_counter_access_rules["+MAX_COUNTER+"] =\n"+indent1+"{\n");
				for (ISimpleGenRes counter : ool.getList(IOilObjectList.COUNTER)) {
					ee_c_buffer.append(pre + indent2 + CpuUtility.getOsAccessBitMask(counter, ool, null));
					pre = ",\n";
				}
				ee_c_buffer.append(pre + indent1 + "};\n\n");
			}

			if (!ool.getList(IOilObjectList.SCHEDULE_TABLE).isEmpty()) {
				pre = "";
				ee_c_buffer.append(indent1 + "EE_TYPEACCESSMASK const EE_as_scheduletable_access_rules["+MAX_SCHED_TAB+"] =\n"+indent1+"{\n");
				for (ISimpleGenRes schedTab : ool.getList(IOilObjectList.SCHEDULE_TABLE)) {
					ee_c_buffer.append(pre + indent2 + CpuUtility.getOsAccessBitMask(schedTab, ool, null));
					pre = ",\n";
				}
				ee_c_buffer.append(pre + indent1 + "};\n\n");
			}

			// search SPINLOCK on all cores
			for (IOilObjectList sool : parent.getOilObjects()) { 
				if (!sool.getList(IOilObjectList.SPINLOCK).isEmpty()) {
					pre = "";
					ee_c_buffer.append(indent1 + "EE_TYPEACCESSMASK const EE_as_spinlock_access_rules["+MAX_SPINLOCK+"] =\n"+indent1+"{\n");
					for (ISimpleGenRes spinlock : sool.getList(IOilObjectList.SPINLOCK)) {
						ee_c_buffer.append(pre + indent2 + CpuUtility.getOsAccessBitMask(spinlock, /* object list of this core */ ool, null));
						pre = ",\n";
					}
					ee_c_buffer.append(pre + indent1 + "};\n\n");
					
					// spin-locks found. Do not search for more
					break;
				}
			}
		}
		
	}
	

	protected void writeIsr(IOilObjectList ool, IOilWriterBuffer answer) {
		List<ISimpleGenRes> orderedIsr = SectionWriterIsr.getIsrByID(ool);
		
		if (orderedIsr.size() == 0) {
			return;
		}
		
		final String indent1 = IWritersKeywords.INDENT;
		final String indent2 = indent1 + IWritersKeywords.INDENT;

		List<ISimpleGenRes> osApplications = ool.getList(IOilObjectList.OSAPPLICATION);

		StringBuffer ee_h_buffer = answer.get(FILE_EE_CFG_H);
		final ICommentWriter commentWriterH = getCommentWriter(ool, FileTypes.H);

		StringBuffer ee_c_buffer = answer.get(FILE_EE_CFG_C);
		final ICommentWriter commentWriterC = getCommentWriter(ool, FileTypes.C);
		

		int max_level = CpuHwDescription.DEFAULT_MAX_NESTING_LEVEL;
		int isr2_number = ErikaEnterpriseWriter.getIsr2Number(ool);
		{
			String svalue = AbstractRtosWriter.getOsProperty(ool, SGR_OS_MAX_NESTING_LEVEL);
			if (svalue != null) {
				max_level =  Integer.decode(svalue).intValue();
			} else {
				CpuHwDescription currentStackDescription = ErikaEnterpriseWriter.getCpuHwDescription(ool);
				if (currentStackDescription != null) {
					max_level = currentStackDescription.getMaxNestedInts();
				}
			}
		}

		
		// ee_cfg.h
		ee_h_buffer.append(
				commentWriterH.writerBanner("ISR definition") +
				indent1 + "#define EE_MAX_NESTING_LEVEL   "+(isr2_number<max_level?isr2_number : max_level)+"\n\n"); 				

		// ee_cfg.c
		ee_c_buffer.append(commentWriterC.writerBanner("ISR definition"));
		HashSet<String> def = new HashSet<String>();
		for (ISimpleGenRes isr : orderedIsr) {
			if (isr != null) {
				String name = "";
				if (isr.containsProperty(ISimpleGenResKeywords.ISR_GENERATED_HANDLER)) {
					name = isr.getString(ISimpleGenResKeywords.ISR_GENERATED_HANDLER);
				} else if (isr.containsProperty(ISimpleGenResKeywords.COUNTER_GENERATED_HANDLER)) {
					name = isr.getString(ISimpleGenResKeywords.COUNTER_GENERATED_HANDLER);
				}
				if (name.length()>0) {
					if (!def.contains(name)) {
						def.add(name);
						ee_c_buffer.append("extern void "+name+"( void ); /* "+isr.getName()+" */\n");
					} else {
						ee_c_buffer.append(commentWriterC.writerSingleLineComment("extern void "+name+"( void ); /* "+isr.getName()+" */"));
					}
				}
			}		
		}
		ee_c_buffer.append("\n" +
				indent1 + "EE_as_ISR_RAM_type EE_as_ISR_stack[EE_MAX_NESTING_LEVEL];\n\n" +
				indent1 + "const EE_as_ISR_ROM_type EE_as_ISR_ROM[EE_MAX_ISR_ID] = {\n");
				
		StringBuffer appl_id = new StringBuffer(commentWriterC.writerSingleLineComment("ISR to Application mapping"));

		String pre = "";
		String post = "";
		final boolean needOrtiHandler = parent.checkKeyword(IWritersKeywords.ENABLE_ORTI_ISR2);
		for (ISimpleGenRes isr : orderedIsr) {
			if (isr != null) {
				String name = isr.getName();
				String orti_handler = needOrtiHandler ? ", " + isr.getString(ISimpleGenResKeywords.ISR_GENERATED_HANDLER) : "";
				
				int aid = 0;
				if (isr.containsProperty(ISimpleGenResKeywords.ISR_OS_APPLICATION_NAME)) {
					aid = 1+ getOsApplicationIndex(isr.getString(ISimpleGenResKeywords.ISR_OS_APPLICATION_NAME), osApplications);
				//  --> at this moment all ISR related to HW Counters are executed by Kernel OsApplication, then aid = 0
//				} else if (isr.containsProperty(ISimpleGenResKeywords.COUNTER_OS_APPLICATION_NAME)) { 
//					aid = 1+ getOsApplicationIndex(isr.getString(ISimpleGenResKeywords.COUNTER_OS_APPLICATION_NAME), osApplications); 
				}
				appl_id.append(indent1 + "#define ISR2_APP_"+name+"\t" + aid + "\n");
				
				ee_c_buffer.append(pre + post + indent2 + "{ "+aid + orti_handler+" }");
				pre = ",";
				post = commentWriterC.writerSingleLineComment(name);
			} else {
				String orti_handler = needOrtiHandler ? ", 0" : "";
				ee_c_buffer.append(pre + post + indent2 + "{ ((ApplicationType)-1)"+orti_handler+" }");
				pre = ",";
				post = commentWriterC.writerSingleLineComment("not used");
			}
		}

		ee_h_buffer.append(appl_id + "\n");
		
		ee_c_buffer.append(" " + post+indent1+"};\n\n");

	}

	
	/**
	 * 
	 * @param osAppl
	 *            os application name
	 * @param osApplicationList
	 *            all os applications
	 * @return the position in the array of specified os application
	 */
	private int getOsApplicationIndex(String osAppl, List<ISimpleGenRes> osApplicationList) {
		if (osAppl != null) {
			for (int i=0; i<osApplicationList.size(); i++) {
				if (osAppl.equals(osApplicationList.get(i).getName())) {
					return i;
				}
			}
		}
		return -1;
	}
	
	@Override
	public void updateObjects() throws OilCodeWriterException {
		final IVarTree vt = parent.getVt();
		
		final String osApplBasePath = S
				+ (new OilPath(OilObjectType.OSAPPLICATION, null)).getPath();

		final String path_trusted = osApplBasePath+ "TRUSTED";
		final String path_mem_base = osApplBasePath+ "MEMORY_BASE";
		final String path_mem_size = osApplBasePath+ "MEMORY_SIZE";
		final String path_mem_shared = osApplBasePath+ "SHARED_STACK_SIZE";
		final String path_mem_irq = osApplBasePath+ "IRQ_STACK_SIZE";
		
		final String path_alarm      = osApplBasePath+ "ALARM";
		final String path_counter    = osApplBasePath+ "COUNTER";
		final String path_isr        = osApplBasePath+ "ISR";
		final String path_resource   = osApplBasePath+ "RESOURCE";
		final String path_task       = osApplBasePath+ "TASK";
		final String path_schedTable = osApplBasePath+ "SCHEDULETABLE";

		final String path_restarttask     = osApplBasePath+ "RESTARTTASK";

		final String path_startUpH  =  osApplBasePath+ "STARTUPHOOK";
		final String path_errorH    =  osApplBasePath+ "ERRORHOOK";
		final String path_shutdownH =  osApplBasePath+ "SHUTDOWNHOOK";
		

		final String osNestingLevelPath = S
				+ (new OilPath(OilObjectType.OS, null)).getPath()
				+ "MAX_NESTING_LEVEL";

		
		final String path_trusted_function = PARAMETER_LIST+ "TRUSTED_FUNCTION";
		
		final boolean enableMemoryProtection = parent.checkKeyword(IWritersKeywords.KERNEL_MEMORY_PROTECTION);

		final IOilObjectList[] oilObjects = parent.getOilObjects();	
		boolean useOsApplications = false;
		for (IOilObjectList ool : oilObjects) {
			if (ool.getList(IOilObjectList.OSAPPLICATION).size()>0) {
				useOsApplications = true;
			}
		}
		
		for (IOilObjectList ool : oilObjects) {
			
			Map<String, ISimpleGenRes> map_alarm = getMap(ool.getList(IOilObjectList.ALARM));
			Map<String, ISimpleGenRes> map_counter = getMap(ool.getList(IOilObjectList.COUNTER));
			Map<String, ISimpleGenRes> map_isr = getMap(ool.getList(IOilObjectList.ISR));
			Map<String, ISimpleGenRes> map_resource = getMap(ool.getList(IOilObjectList.RESOURCE));
			Map<String, ISimpleGenRes> map_task = getMap(ool.getList(IOilObjectList.TASK));
			Map<String, ISimpleGenRes> map_schedTable = getMap(ool.getList(IOilObjectList.SCHEDULE_TABLE));
			

			for (ISimpleGenRes os: ool.getList(IOilObjectList.OS)){ // nesting level
				String[] value = CommonUtils.getValue(vt, os.getPath() + osNestingLevelPath);
				if (value != null && value.length>0 && value[0] != null && value[0].length()>0) {
					os.setProperty(SGR_OS_MAX_NESTING_LEVEL, value[0]);
				}
			}
			

			for (ISimpleGenRes sgr: ool.getList(IOilObjectList.SPINLOCK)){
				sgr.setObject(ISimpleGenResKeywords.OS_APPL_NAME, ISimpleGenResKeywords.OS_APPL_KERNEL_NAME);
				sgr.setObject(ISimpleGenResKeywords.OS_APPL_ID, new Integer(0));
			}
			
			// OS applications
			int id = 1;
			List<ISimpleGenRes> applications = ool.getList(IOilObjectList.OSAPPLICATION);
			for (ISimpleGenRes appl : applications) {
				
				//String appl_path = appl.getPath();
				String[] appl_paths = (String[]) appl.getObject(ISimpleGenResKeywords.OS_APPL_PATH);
				String appl_name = appl.getName();
				
				
				appl.setProperty(ISimpleGenResKeywords.OS_APPL_ID, "" +id);
				appl.setObject(ISimpleGenResKeywords.OS_APPL_NAME, appl_name);
				
				String[] trusted_child = new String[1];
				String type = CommonUtils.getFirstChildEnumType(vt, addToAllStrings(appl_paths, path_trusted), trusted_child);
				if ("true".equalsIgnoreCase(type)) {
					appl.setProperty(IEEWriterKeywords.OS_APPLICATION_TRUSTED, "true");
					ArrayList<String> childName = new ArrayList<String>();
					String trusted_func_path = trusted_child[0] + path_trusted_function;
					
					ArrayList<String> trustedFunctionNames = new ArrayList<String>();
					
					ArrayList<String> childTypes = CommonUtils.getAllChildrenEnumType(vt, trusted_func_path, childName);
					if (childTypes != null) {
						for (int i=0; i<childTypes.size(); i++) {
							String ct = childTypes.get(i);
							if ("TRUE".equalsIgnoreCase(ct)) {
								String[] name = CommonUtils.getValue(vt, trusted_func_path + VARIANT_ELIST +  childName.get(i) + PARAMETER_LIST + "NAME");
								if (name != null && name.length>0) {
									for (String n: name) {
										trustedFunctionNames.add(n);
									}
								}
							}
						}
					}
					
					
					appl.setObject(IEEWriterKeywords.OS_APPLICATION_TRUSTED_FUNCTIONS, trustedFunctionNames);
					
				}
				{
					String val = CommonUtils.getFirstChildEnumType(vt, addToAllStrings(appl_paths, path_startUpH), null);
					if (val != null) {
						appl.setProperty(OS_APPLICATION_HOOK_STARTUP, "" + "true".equalsIgnoreCase(val));
					}
					val = CommonUtils.getFirstChildEnumType(vt, addToAllStrings(appl_paths, path_shutdownH), null);
					if (val != null) {
						appl.setProperty(OS_APPLICATION_HOOK_SHUTDOWN, "" + "true".equalsIgnoreCase(val));
					}
					val = CommonUtils.getFirstChildEnumType(vt, addToAllStrings(appl_paths, path_errorH), null);
					if (val != null) {
						appl.setProperty(OS_APPLICATION_HOOK_ERROR, "" + "true".equalsIgnoreCase(val));
					}
				}

			
				{
					String[] val = CommonUtils.getValues(vt, addToAllStrings(appl_paths, path_mem_base));
					if (val != null && val.length>0 && val[0] != null && val[0].length()>0) {
						
//						try {
//							Long.decode(val[0]);
//						} catch (NumberFormatException e) {
//							throw new OilCodeWriterException("OsApplication " + appl_name + " MEM_BASE is not a valid number");
//						}
						
						appl.setProperty(OS_APPLICATION_MEM_BASE, val[0]);
					} else {
						appl.setProperty(OS_APPLICATION_MEM_BASE, "0");
//						throw new OilCodeWriterException("Required a mem base for OsApplication " + appl_name);
					}
				}
				{
					String[] val = CommonUtils.getValues(vt, addToAllStrings(appl_paths, path_mem_size));
					if (val != null && val.length>0 && val[0] != null && val[0].length()>0) {
						
						try {
							Long.decode(val[0]);
						} catch (NumberFormatException e) {
							throw new OilCodeWriterException("OsApplication " + appl_name + " MEM_SIZE is not a valid number");
						}
						
						appl.setProperty(OS_APPLICATION_MEM_SIZE, val[0]);
					} else if (enableMemoryProtection) {
						appl.setProperty(OS_APPLICATION_MEM_SIZE, "0");
						//throw new OilCodeWriterException("Required a mem size for OsApplication " + appl_name);
					}
				}
				{
					String[] val = CommonUtils.getValues(vt, addToAllStrings(appl_paths, path_mem_shared));
					if (val != null && val.length>0 && val[0] != null && val[0].length()>0) {
						appl.setProperty(OS_APPLICATION_SHARED_SIZE, val[0]);
					}
				}
				{
					String[] val = CommonUtils.getValues(vt, addToAllStrings(appl_paths, path_mem_irq));
					if (val != null && val.length>0 && val[0] != null && val[0].length()>0) {
						appl.setProperty(OS_APPLICATION_IRQ_SIZE, val[0]);
					}
				}
				
				{
					ArrayList<String> alarms = new ArrayList<String>();
					String[] values = CommonUtils.getValues(vt, addToAllStrings(appl_paths, path_alarm));
					if (values != null) for (String val: values) {
						if (!map_alarm.containsKey(val)) {
							throw new OilCodeWriterException("Cannot resolve a reference from OsApplication " + appl_name + " to the alarm " + val);
						}
						if (add_appl_ref(map_alarm.get(val), ISimpleGenResKeywords.ALARM_OS_APPLICATION_NAME, appl_name, id)) {
							alarms.add(val);
						}
					}
					appl.setObject(ISimpleGenResKeywords.OS_APPL_LIST_REF_ALARM, alarms);
				}
				{
					ArrayList<String> counter = new ArrayList<String>();
					String[] values = CommonUtils.getValues(vt, addToAllStrings(appl_paths, path_counter));
					if (values != null) for (String val: values) {
						if (!map_counter.containsKey(val)) {
							throw new OilCodeWriterException("Cannot resolve a reference from OsApplication " + appl_name + " to the counter " + val);
						}
						if (add_appl_ref(map_counter.get(val), ISimpleGenResKeywords.COUNTER_OS_APPLICATION_NAME, appl_name, id)) {
							counter.add(val);
						}
					}
					appl.setObject(ISimpleGenResKeywords.OS_APPL_LIST_REF_COUNTER, counter);
				}
				{
					ArrayList<String> isr = new ArrayList<String>();
					String[] values = CommonUtils.getValues(vt, addToAllStrings(appl_paths, path_isr));
					if (values != null) for (String val: values) {
						if (!map_isr.containsKey(val)) {
							throw new OilCodeWriterException("Cannot resolve a reference from OsApplication " + appl_name + " to the isr " + val);
						}
						if (add_appl_ref(map_isr.get(val), ISimpleGenResKeywords.ISR_OS_APPLICATION_NAME, appl_name, id)) {
							isr.add(val);
						}
					}
					appl.setObject(ISimpleGenResKeywords.OS_APPL_LIST_REF_ISR, isr);
				}
				{
					ArrayList<String> resource = new ArrayList<String>();
					String[] values = CommonUtils.getValues(vt, addToAllStrings(appl_paths, path_resource));
					if (values != null) for (String val: values) {
						if (!map_resource.containsKey(val)) {
							throw new OilCodeWriterException("Cannot resolve a reference from OsApplication " + appl_name + " to the resource " + val);
						}
						if (add_appl_ref(map_resource.get(val), ISimpleGenResKeywords.RESOURCE_OS_APPLICATION_NAME, appl_name, id)) {
							resource.add(val);
						}
					}
					appl.setObject(ISimpleGenResKeywords.OS_APPL_LIST_REF_RESOURCE, resource);
				}
				{
					ArrayList<String> task = new ArrayList<String>();
					String[] values = CommonUtils.getValues(vt, addToAllStrings(appl_paths, path_task));
					if (values != null) for (String val: values) {
						if (!map_task.containsKey(val)) {
							throw new OilCodeWriterException("Cannot resolve a reference from OsApplication " + appl_name + " to the task " + val);
						}
						ISimpleGenRes sgr_task = map_task.get(val);
						if (add_appl_ref(sgr_task, ISimpleGenResKeywords.TASK_OS_APPLICATION_NAME, appl_name, id)) {
							task.add(val);
						}
					}
					appl.setObject(ISimpleGenResKeywords.OS_APPL_LIST_REF_TASK, task);
					
					{
						String[] val = CommonUtils.getValues(vt, addToAllStrings(appl_paths, path_restarttask));
						String resttask = "EE_NIL";
						if (val != null && val.length>0 && val[0] != null && val[0].length()>0) {
							
							// check if the value is a valid task name
							if (task.contains(val[0])) {
								resttask = val[0];
							} else {
								throw new OilCodeWriterException("The restartTask " +val[0]+ " is not one of tasks related to the OsApplication " + appl_name);
							}
							
							appl.setProperty(OS_APPLICATION_RESTART_TASK, val[0]);
						}
							
						appl.setProperty(OS_APPLICATION_RESTART_TASK, resttask);
						
					}
				}
				{
					ArrayList<String> schedTable = new ArrayList<String>();
					String[] values = CommonUtils.getValues(vt, addToAllStrings(appl_paths, path_schedTable));
					if (values != null) for (String val: values) {
						if (!map_schedTable.containsKey(val)) {
							throw new OilCodeWriterException("Cannot resolve a reference from OsApplication " + appl_name + " to the scheduling table " + val);
						}
						ISimpleGenRes sgr_scTab = map_schedTable.get(val);
						if (add_appl_ref(sgr_scTab, ISimpleGenResKeywords.SCHEDTABLE_OS_APPLICATION_NAME, appl_name, id)) {
							schedTable.add(val);
						}
					}
					appl.setObject(ISimpleGenResKeywords.OS_APPL_LIST_REF_SCHEDTABLE, schedTable);
				}
				
				id++;
			}
			
			
			if (useOsApplications) {//applications.size() >0) {
				
				// check 
				List<String> not_map_alarm = new LinkedList<String>();
				List<String> not_map_counter = new LinkedList<String>();
				List<String> not_map_isr = new LinkedList<String>();
				List<String> not_map_resource = new LinkedList<String>();
				List<String> not_map_task = new LinkedList<String>();
				List<String> not_map_schedTable = new LinkedList<String>();

				List<ISimpleGenRes> alarms = ool.getList(IOilObjectList.ALARM);
				for (ISimpleGenRes alarm : alarms) {
					if (!alarm.containsProperty(ISimpleGenResKeywords.OS_APPL_ID)) {
						not_map_alarm.add(alarm.getName());
					}
				}
				List<ISimpleGenRes> counters = ool.getList(IOilObjectList.COUNTER);
				for (ISimpleGenRes counter : counters) {
					if (!counter.containsProperty(ISimpleGenResKeywords.OS_APPL_ID)) {
						not_map_counter.add(counter.getName());
					}
				}
				List<ISimpleGenRes> isrs = ool.getList(IOilObjectList.ISR);
				for (ISimpleGenRes isr : isrs) {
					if (!isr.containsProperty(ISimpleGenResKeywords.OS_APPL_ID)) {
						not_map_isr.add(isr.getName());
					}
				}
				List<ISimpleGenRes> resources = ool.getList(IOilObjectList.RESOURCE);
				for (ISimpleGenRes resource : resources) {
					if (!resource.containsProperty(ISimpleGenResKeywords.OS_APPL_ID)) {
						not_map_resource.add(resource.getName());
					}
				}

				List<ISimpleGenRes> tasks = ool.getList(IOilObjectList.TASK);
				for (ISimpleGenRes task : tasks) {
					if (!task.containsProperty(ISimpleGenResKeywords.OS_APPL_ID)) {
						not_map_task.add(task.getName());
					}
				}
				
				List<ISimpleGenRes> scheduleTables = ool.getList(IOilObjectList.SCHEDULE_TABLE);
				for (ISimpleGenRes schedTab : scheduleTables) {
					if (!schedTab.containsProperty(ISimpleGenResKeywords.OS_APPL_ID)) {
						not_map_schedTable.add(schedTab.getName());
					}
				}
				
				StringBuffer buff = new StringBuffer();
				if (not_map_alarm.size()>0) {
					buff.append("Alarm not assigned to any OsApplication:");
					for (String s: not_map_alarm) {
						buff.append(" " + s );
					}
					buff.append("\n");
				}
				if (not_map_counter.size()>0) {
					buff.append("Counter not assigned to any OsApplication:");
					for (String s: not_map_counter) {
						buff.append(" " + s );
					}
					buff.append("\n");
				}
				if (not_map_isr.size()>0) {
					buff.append("Isr not assigned to any OsApplication:");
					for (String s: not_map_isr) {
						buff.append(" " + s );
					}
					buff.append("\n");
				}
				if (not_map_resource.size()>0) {
					buff.append("Resource not assigned to any OsApplication:");
					for (String s: not_map_resource) {
						buff.append(" " + s );
					}
					buff.append("\n");
				}
				if (not_map_task.size()>0) {
					buff.append("Task not assigned to any OsApplication:");
					for (String s: not_map_task) {
						buff.append(" " + s );
					}
					buff.append("\n");
				}
				if (not_map_schedTable.size()>0) {
					buff.append("Schedule Table not assigned to any OsApplication:");
					for (String s: not_map_schedTable) {
						buff.append(" " + s );
					}
					buff.append("\n");
				}
				
				if (buff.length()>0) {
					throw new OilCodeWriterException(buff.toString());					
				}
					
			}

			
		}
	}

	
	protected boolean add_appl_ref(ISimpleGenRes sgr, String pName, String os_appl_name, int id) throws OilCodeWriterException {
		if (sgr == null) {
			return false;
		}
		if (sgr.containsProperty(pName)) {
			// ignore if an object is already set as kernel object (like system timer)
			if (ISimpleGenResKeywords.OS_APPL_KERNEL_NAME.equalsIgnoreCase(sgr.getString(pName))) {
				return true;
			}
			
			if (!os_appl_name.equals(sgr.getObject(pName))) {
				throw new OilCodeWriterException(sgr.getName() + " is assigned to two distinct os applications ("
							+ os_appl_name + " and " + sgr.getObject(pName) +")");
			}
			return false;
		}
		
		sgr.setProperty(pName, os_appl_name);
		sgr.setProperty(ISimpleGenResKeywords.OS_APPL_ID, "" +id);

		return true;
	}
	
	protected Map<String, ISimpleGenRes> getMap(List<ISimpleGenRes> list) {
		Map<String, ISimpleGenRes> map = new HashMap<String, ISimpleGenRes>();
		for (ISimpleGenRes sgr: list) {
			map.put(sgr.getName(), sgr);
		}
		return map;
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
	
			// Enable OsApplications
			if (parent.checkKeyword(IWritersKeywords.KERNEL_OS_APPLICATION)) {
			    answer.add("EE_AS_OSAPPLICATIONS__");
		    }
		}

		return answer;
	}

	@Override
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix)
			throws OilCodeWriterException {
		
		String[] osAppls = Search.allOsApplication(vt.newTreeInterface());
		if (osAppls != null && osAppls.length>0) {
			if (!keywords.contains(IWritersKeywords.KERNEL_OS_APPLICATION)) {
				keywords.add(IWritersKeywords.KERNEL_OS_APPLICATION);
			}
		}
	}
	
}
