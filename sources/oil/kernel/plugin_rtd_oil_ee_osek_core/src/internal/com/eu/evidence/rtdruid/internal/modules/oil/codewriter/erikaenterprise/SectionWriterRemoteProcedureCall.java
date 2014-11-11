/*
 * Created on 1-oct-2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.abstractions.SimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuUtility;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EmptyMacrosForSharedData;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IRemoteNotificationsConstants;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IMacrosForSharedData;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * This writer manages Remote Notifications
 * 
 * @author Nicola Serreli
 */
public class SectionWriterRemoteProcedureCall extends SectionWriter implements
		IEEWriterKeywords, IRemoteNotificationsConstants,
		IExtractObjectsExtentions, IExtractKeywordsExtentions, IGetEEOPTExtentions {
	
	public final static String DEF__USE_RPC__ = IEEWriterKeywords.DEF__USE_RPC__;
	private final String indent1 = IWritersKeywords.INDENT;
	private final String indent2 = indent1 + IWritersKeywords.INDENT;
	private final String indent3 = indent2 + IWritersKeywords.INDENT;

	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;

	/** All data */
	protected final IVarTree vt;
	
	/**
	 * 
	 */
	public SectionWriterRemoteProcedureCall() {
		this(null);
	}
	
	/**
	 * 
	 */
	public SectionWriterRemoteProcedureCall(ErikaEnterpriseWriter parent) {
		super("REMOTE_PROCEDURE_CALL", new String[] {}, //
				new String[] {},
				SWCategoryManager.defaultInstance.newCategory(SWCategoryManager.TYPE_INIT, 6));
		
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
		return Collections.binarySearch(keywords, DEF__USE_RPC__) >=0;
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

		return writeRemoteProcedureCall();
	}
	
	/**
	 *  This method prepares data for <b>remote Notification </b>
	 * 
	 * @return buffers 
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	private IOilWriterBuffer[] writeRemoteProcedureCall() {

		final int rtosNumber = parent.getRtosSize();
		IOilObjectList[] oilObjects = parent.getOilObjects();
		IOilWriterBuffer[] answer = new IOilWriterBuffer[rtosNumber];
	
		boolean binaryDistr = parent.checkKeyword(IEEWriterKeywords.DEF__EE_USE_BINARY_DISTRIBUTION__);
		final String MAX_CPU = (binaryDistr ? "RTD_" : "EE_") + "MAX_CPU";
		final boolean hasAccessProtection = parent.checkKeyword(IWritersKeywords.KERNEL_SERVICE_PROTECTION);

		
		
		IMacrosForSharedData macros = new EmptyMacrosForSharedData();
		if (rtosNumber>0) {
			CpuHwDescription currentStackDescription = ErikaEnterpriseWriter.getCpuHwDescription(oilObjects[0]);
			if (currentStackDescription != null) {
				macros =currentStackDescription.getShareDataMacros();
			}
		}
		if (parent.checkPragma(0)) {
			macros = macros.getPragma();
		}

		
		/***********************************************************************
		 * 
		 * prepare buffers for All OS :
		 * 
		 * #DEFINE xxx
		 * Arrays
		 * other data
		 * 
		 **********************************************************************/
		
		/** A buffer for Remote Task Definition (one for each cpu) */
		final StringBuilder[] sbRemoteTasksDefines = new StringBuilder[oilObjects.length];
		final StringBuilder[] sbRemoteAlarmsDefines = new StringBuilder[oilObjects.length];
		final StringBuilder[] sbRemoteCountersDefines = new StringBuilder[oilObjects.length];
		final StringBuilder[] sbRemoteOsApplsDefines = new StringBuilder[oilObjects.length];
		final StringBuilder[] sbRemoteSchedTabsDefines = new StringBuilder[oilObjects.length];

		final StringBuilder sbCommonRpc_access_mask = new StringBuilder();
		int access_index[] = {0};
		String access_descr = "";

		final StringBuilder sbCommonRpc_spins = new StringBuilder();
		final StringBuilder sbCommonRpc_ram = new StringBuilder();
		final StringBuilder sbCommonRpc_tasks = new StringBuilder();
		final StringBuilder sbCommonRpc_alarms = new StringBuilder();
		final StringBuilder sbCommonRpc_counters = new StringBuilder();
		final StringBuilder sbCommonRpc_OsAppls = new StringBuilder();
		final StringBuilder sbCommonRpc_SchedTabs = new StringBuilder();
		
		
		// init vectors
		for (int rtosId=0; rtosId<oilObjects.length; rtosId++) {
			answer[rtosId] = new OilWriterBuffer();
			sbRemoteTasksDefines[rtosId] = new StringBuilder();
			sbRemoteAlarmsDefines[rtosId] = new StringBuilder();
			sbRemoteCountersDefines[rtosId] = new StringBuilder();
			sbRemoteOsApplsDefines[rtosId] = new StringBuilder();
			sbRemoteSchedTabsDefines[rtosId] = new StringBuilder();
		}
		
		
		int globalTaskIndex = 0;
		int globalAlarmIndex = 0;
		int globalCounterIndex = 0;
		int globalOsApplIndex = 0;
		int globalSchedTablIndex = 0;
		for (int rtosId = 0; rtosId < rtosNumber; rtosId++) {
		
			// ------------------ common data ------------------

			// all objects for current os
			IOilObjectList ool = oilObjects[rtosId];
			final ICommentWriter commentWriterC = getCommentWriter(ool, FileTypes.C);

			String cpuId = "OS_CORE_ID_" + rtosId;

			sbCommonRpc_spins.append(( sbCommonRpc_spins.length() == 0 ? "" : ",\n"+indent2) +  "EE_SPINLOCK_CORE" + rtosId
					//+ (hasAccessProtection ? addAccessMask(null, oilObjects, sbCommonRpc_access_mask, access_index) : "")
					);
			sbCommonRpc_ram.append((   sbCommonRpc_ram.length()   == 0 ? "" : ",\n"+indent2) +  "{ INVALID_CORE_ID, 0U, {0U}, {0U}, {0U}, E_OK}");

			for (ISimpleGenRes task : ool.getList(IOilObjectList.TASK)) {
				final String name = task.getName();
				final String taskId = task.getString(ISimpleGenResKeywords.TASK_SYS_ID);

				for (int i=0; i< rtosNumber; i++) {
					if (i != rtosId) {
						sbRemoteTasksDefines[i].append(IWritersKeywords.INDENT + "#define " + name + " ((EE_TID)" + globalTaskIndex + "U + (EE_TID)EE_REMOTE_TID)\n");
					}
				}

				sbCommonRpc_tasks.append(
						( sbCommonRpc_tasks.length() == 0 ? "" : ",\n") 
						+ indent2 + "{ "+cpuId+", " + taskId + "U"
						+ (hasAccessProtection ? addAccessMask(task, oilObjects, sbCommonRpc_access_mask, access_index, access_descr) : "")
						+ "}");
				access_descr = commentWriterC.writerSingleLineComment(cpuId + " - " + name);

				// increase the task index number
				globalTaskIndex++;
			}
			for (ISimpleGenRes alarm : ool.getList(IOilObjectList.ALARM)) {
				final String name = alarm.getName();
				final String alarmId = alarm.getString(ISimpleGenResKeywords.ALARM_SYS_ID);

				for (int i=0; i< rtosNumber; i++) {
					if (i != rtosId) {
						sbRemoteAlarmsDefines[i].append(IWritersKeywords.INDENT + "#define " + name + " ((EE_TID)" + globalAlarmIndex + "U + (EE_TID)EE_REMOTE_TID)\n");
					}
				}
				
				sbCommonRpc_alarms.append(
						( sbCommonRpc_alarms.length() == 0 ? "" : ",\n") 
						+ indent2 + "{ "+cpuId+", " + alarmId + "U"
						+ (hasAccessProtection ? addAccessMask(alarm, oilObjects, sbCommonRpc_access_mask, access_index, access_descr) : "")
						+ "}");
				access_descr = commentWriterC.writerSingleLineComment(cpuId + " - " + name);
				
				// increase the task index number
				globalAlarmIndex++;
			}
			for (ISimpleGenRes counter : ool.getList(IOilObjectList.COUNTER)) {
				final String name = counter.getName();
				final String counterId = counter.getString(ISimpleGenResKeywords.COUNTER_SYS_ID);

				for (int i=0; i< rtosNumber; i++) {
					if (i != rtosId) {
						sbRemoteCountersDefines[i].append(IWritersKeywords.INDENT + "#define " + name + " ((EE_TID)" + globalCounterIndex + "U + (EE_TID)EE_REMOTE_TID)\n");
					}
				}
				
				sbCommonRpc_counters.append(
						( sbCommonRpc_counters.length() == 0 ? "" : ",\n") 
						+ indent2 + "{ "+cpuId+", " + counterId + "U"
						+ (hasAccessProtection ? addAccessMask(counter, oilObjects, sbCommonRpc_access_mask, access_index, access_descr) : "")
						+ "}");
				access_descr = commentWriterC.writerSingleLineComment(cpuId + " - " + name);
				
				// increase the task index number
				globalCounterIndex++;
			}
			for (ISimpleGenRes osAppl : ool.getList(IOilObjectList.OSAPPLICATION)) {
				final String name = osAppl.getName();
				final String osApplId = "" +(osAppl.getInt(ISimpleGenResKeywords.OS_APPL_ID));

				for (int i=0; i< rtosNumber; i++) {
					if (i != rtosId) {
						sbRemoteOsApplsDefines[i].append(IWritersKeywords.INDENT + "#define " + name + " ((EE_TID)" + globalOsApplIndex + "U + (EE_TID)EE_REMOTE_TID)\n");
					}
				}
				
				sbCommonRpc_OsAppls.append(
						( sbCommonRpc_OsAppls.length() == 0 ? "" : ",\n") 
						+ indent2 + "{ "+cpuId+", " + osApplId + "U"
						+ (hasAccessProtection ? ", EE_UREG_MINUS1" : "")
						+ "}");

				// increase the task index number
				globalOsApplIndex++;
			}
			for (ISimpleGenRes schedTab : ool.getList(IOilObjectList.SCHEDULE_TABLE)) {
				final String name = schedTab.getName();
				final String schedTabId = schedTab.getString(ISimpleGenResKeywords.SCHEDTABLE_SYS_ID);

				for (int i=0; i< rtosNumber; i++) {
					if (i != rtosId) {
						sbRemoteSchedTabsDefines[i].append(IWritersKeywords.INDENT + "#define " + name + " ((EE_TID)" + globalSchedTablIndex + "U + (EE_TID)EE_REMOTE_TID)\n");
					}
				}
				
				sbCommonRpc_SchedTabs.append(
						( sbCommonRpc_SchedTabs.length() == 0 ? "" : ",\n") 
						+ indent2 + "{ "+cpuId+", " + schedTabId + "U"
						+ (hasAccessProtection ? addAccessMask(schedTab, oilObjects, sbCommonRpc_access_mask, access_index, access_descr) : "")
						+ "}");
				access_descr = commentWriterC.writerSingleLineComment(cpuId + " - " + name);

				// increase the task index number
				globalSchedTablIndex++;
			}
		}
		if (access_index[0]>0) {
			sbCommonRpc_access_mask.append("  " + access_descr);
		}
		
	
	
		// ee_cfg.h
		for (int rtosId = 0; rtosId < rtosNumber; rtosId++) {
			IOilObjectList ool = oilObjects[rtosId];
			final ICommentWriter commentWriter = getCommentWriter(ool, FileTypes.H);
			
			StringBuffer sbCfg_h = answer[rtosId].get(FILE_EE_CFG_H);

			sbCfg_h.append(commentWriter.writerBanner("Remote tasks"));
			sbCfg_h.append(sbRemoteTasksDefines[rtosId].toString());
			
			sbCfg_h.append(commentWriter.writerBanner("Remote alarms"));
			sbCfg_h.append(sbRemoteAlarmsDefines[rtosId].toString());
			
			sbCfg_h.append(commentWriter.writerBanner("Remote counters"));
			sbCfg_h.append(sbRemoteCountersDefines[rtosId].toString());
			
			sbCfg_h.append(commentWriter.writerBanner("Remote OsApplication"));
			sbCfg_h.append(sbRemoteOsApplsDefines[rtosId].toString());
			
			sbCfg_h.append(commentWriter.writerBanner("Remote Schedule Tables"));
			sbCfg_h.append(sbRemoteSchedTabsDefines[rtosId].toString());
		}
		
		// common
		{
			IOilObjectList ool = oilObjects[0];
			final ICommentWriter commentWriter = getCommentWriter(ool, FileTypes.H);
			StringBuffer sbCommon_c = answer[0].get(FILE_EE_COMMON_C);

			sbCommon_c.append(commentWriter.writerBanner("Remote Procedure Call")
					+ "#include \"ee.h\"\n"
					+ parent.addCommonDataMacro(FILE_EE_COMMON_C));
			
			if (binaryDistr) {
				sbCommon_c.append("#ifndef " + MAX_CPU + "\n"
						+ "#define " + MAX_CPU + " "+ oilObjects.length +"\n"
						+ "#endif\n\n");
			}
			
			StringBuilder sbTable = new StringBuilder();
			sbCommon_c.append(
					macros.constVectorRom(
							indent1 + "EE_TYPESPIN const ", "EE_as_core_spinlocks","["+MAX_CPU+"]", " = {\n" + indent2 +
							sbCommonRpc_spins.toString() + "\n"+indent1+ "};\n") + "\n");
			
			if (hasAccessProtection && access_index[0]>0) {
				sbCommon_c.append(
						macros.constVectorRom(
								indent1 + "EE_TYPEACCESSMASK const ", "EE_as_rpc_remote_access_rules","["+ErikaEnterpriseWriter.addVectorSizeDefine(oilObjects, "EE_as_rpc_remote_access_rules", access_index[0])+"]", " = {\n" +
								sbCommonRpc_access_mask.toString() + indent1 + "};\n") + "\n");
			}
			
			if (sbCommonRpc_tasks.length()>0) {
				sbTable.append("&EE_as_rpc_tasks[0], ");
				
				sbCommon_c.append(
						macros.constVectorRom(
								indent1 + "EE_TYPEASREMOTEID const ", "EE_as_rpc_tasks","["+ErikaEnterpriseWriter.addVectorSizeDefine(oilObjects, "EE_as_rpc_tasks", globalTaskIndex)+"]", " = {\n" +
								sbCommonRpc_tasks.toString() + "\n" + indent1 + "};\n") + "\n");
			} else {
				sbTable.append("0U, ");
			}
			
			if (sbCommonRpc_alarms.length()>0) {
				sbTable.append("&EE_as_rpc_alarms[0], ");
				
				sbCommon_c.append(
						macros.constVectorRom(
								indent1 + "EE_TYPEASREMOTEID const ", "EE_as_rpc_alarms","["+ErikaEnterpriseWriter.addVectorSizeDefine(oilObjects, "EE_as_rpc_alarms", globalAlarmIndex)+"]", " = {\n" +
								sbCommonRpc_alarms.toString() + "\n" + indent1 + "};\n") + "\n");
			} else {
				sbTable.append("0U, ");
			}
			
			if (sbCommonRpc_counters.length()>0) {
				sbTable.append("&EE_as_rpc_counters[0], ");
				
				sbCommon_c.append(
						macros.constVectorRom(
								indent1 + "EE_TYPEASREMOTEID const ", "EE_as_rpc_counters","["+ErikaEnterpriseWriter.addVectorSizeDefine(oilObjects, "EE_as_rpc_counters", globalCounterIndex)+"]", " = {\n" +
								sbCommonRpc_counters.toString() + "\n" + indent1 + "};\n") + "\n");
			} else {
				sbTable.append("0U, ");
			}

			if (sbCommonRpc_SchedTabs.length()>0) {
				sbTable.append("&EE_as_rpc_schedTabs[0], ");
				
				sbCommon_c.append(
						macros.constVectorRom(
								indent1 + "EE_TYPEASREMOTEID const ", "EE_as_rpc_schedTabs","["+ErikaEnterpriseWriter.addVectorSizeDefine(oilObjects, "EE_as_rpc_schedTabs", globalSchedTablIndex)+"]", " = {\n" +
										sbCommonRpc_SchedTabs.toString() + "\n" + indent1 + "};\n") + "\n");
			} else {
				sbTable.append("0U, ");
			}
			
			if (sbCommonRpc_OsAppls.length()>0) {
				sbTable.append("&EE_as_rpc_osAppls[0]");
				
				sbCommon_c.append(
						macros.constVectorRom(
								indent1 + "EE_TYPEASREMOTEID const ", "EE_as_rpc_osAppls","["+ErikaEnterpriseWriter.addVectorSizeDefine(oilObjects, "EE_as_rpc_osAppls", globalOsApplIndex)+"]", " = {\n" +
										sbCommonRpc_OsAppls.toString() + "\n" + indent1 + "};\n") + "\n");
			} else {
				sbTable.append("0U");
			}
			

			
			sbCommon_c.append(
					macros.constVectorRom(indent1 + "EE_TYPEASREMOTEIDCONSTREF const ", "EE_as_rpc_services_table","["+ErikaEnterpriseWriter.addVectorSizeDefine(oilObjects, "EE_as_rpc_services_table", 5)+"]", " = {\n"
							+indent2 +  sbTable.toString() + "\n"+indent1+ "};\n\n") + 
					macros.vectorRam(indent1 + "EE_TYPEASRPC volatile ", "EE_as_rpc_RAM","["+MAX_CPU+"]", " = {\n" + indent2+sbCommonRpc_ram + "\n"+indent1 +"};\n") + "\n"
			);
		}
		
		

		return answer;
	}
	
	protected String addAccessMask(ISimpleGenRes sgr, IOilObjectList[] oilObjects, StringBuilder accessBuffer, int[] index, String access_descr) {
		if (sgr == null) sgr = new SimpleGenRes("", "");
		
		if (accessBuffer.length()>0) accessBuffer.append(", " + access_descr);
		accessBuffer.append(indent2);
		for (int i=0; i<oilObjects.length; i++) {
			if (i>0) accessBuffer.append(", ");
			accessBuffer.append(CpuUtility.getOsAccessBitMask(sgr, oilObjects[i], null));
		}
		String answer = ", " + index[0]+"U"; //+", " + (index[0]+oilObjects.length-1);
		index[0]+=oilObjects.length;
		return answer;
	}
	

	/* (non-Javadoc)
	 * @see com.eu.evidence.modules.oil.erikaenterprise.subwriters.IExtractObjectsExtentions#updateObjects()
	 */
	public void updateObjects() throws OilCodeWriterException {
		IOilObjectList[] oilObjects = parent.getOilObjects();
		
		setEventMask(oilObjects);
		String text = "Remote procedure call requires an additional ISR2";
		for (IOilObjectList ool : oilObjects) {
			
			Object o = AbstractRtosWriter.getOsObject(ool, ISimpleGenResKeywords.OS_CPU__ISR2_ADDITIONAL_NUMBER);
			Object t = AbstractRtosWriter.getOsObject(ool, ISimpleGenResKeywords.OS_CPU__ISR2_ADDITIONAL_TXT_LIST);
			int isr2Number = 1 + (o == null ? 0 : ((Integer) o).intValue()) ;
			@SuppressWarnings("unchecked")
			List<String> lt = t == null ? new ArrayList<String>() : (List<String>) t;
			lt.add(text);
			for (ISimpleGenRes os : ool.getList(IOilObjectList.OS)) {
				os.setObject( ISimpleGenResKeywords.OS_CPU__ISR2_ADDITIONAL_NUMBER, new Integer(isr2Number));
				os.setObject( ISimpleGenResKeywords.OS_CPU__ISR2_ADDITIONAL_TXT_LIST, lt);
			}
			
		}

	}

	
	/* (non-Javadoc)
	 * @see com.eu.evidence.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions#getEEOpt(int)
	 */
	public List<String> getEEOpt(int type, int rtosId) {
		List<String> answer = new ArrayList<String>();
		
		if ((type & EE_OPT_COMMON_AUTO_ONLY) != 0) {
			/*******************************************************************
			 * AUTOMATIC OPTIONS (CPU DEPENDENT)
			 ******************************************************************/
			
			answer.add("EE_AS_RPC__");
		}

		return answer;
	}

	
	/**
	 * Sets a valid mask for each event.
	 * 
	 * NOTE: this method is enabled does not take care of remote events. 
	 *       Moreover, this method set masks only for those events that does not have it. 
	 * 
	 * @throws OilCodeWriterException
	 *             if there're too many events
	 */
	private void setEventMask(IOilObjectList[] oilObjects) throws OilCodeWriterException {
		
		/* By default all tasks are remote */
		final boolean useAlwaysRemoteEvent = true;
		
		/*
		 * For each event, check where they are required
		 */
		HashMap<String, BitSet> event_to_cpu_map = new HashMap<String, BitSet>();
		if (!useAlwaysRemoteEvent) {
			for (int rtosId = 0; rtosId < oilObjects.length; rtosId++) {
				
				List<ISimpleGenRes> taskList = oilObjects[rtosId].getList(IOilObjectList.TASK);
				for (ISimpleGenRes task: taskList) {
					if (task.containsProperty(ISimpleGenResKeywords.TASK_EVENT_LIST)) {
						List<String> events = (List<String>) task.getObject(ISimpleGenResKeywords.TASK_EVENT_LIST);
						
						for (String event: events){
							BitSet bs;
							if (event_to_cpu_map.containsKey(event)) {
								bs = event_to_cpu_map.get(event);
							} else {
								bs = new BitSet();
								event_to_cpu_map.put(event, bs);
							}
							bs.set(rtosId);
						}
					}
				}
			
				List<ISimpleGenRes> alarmList = oilObjects[rtosId].getList(IOilObjectList.ALARM);
				for (ISimpleGenRes alarm: alarmList) {
					if (alarm.containsProperty(ISimpleGenResKeywords.ALARM_SET_EVENT)) {
						// {taskName, eventName}
						String[] task_event = (String[]) alarm.getObject(ISimpleGenResKeywords.ALARM_SET_EVENT);
						{
							String event = task_event[1];
							BitSet bs;
							if (event_to_cpu_map.containsKey(event)) {
								bs = event_to_cpu_map.get(event);
							} else {
								bs = new BitSet();
								event_to_cpu_map.put(event, bs);
							}
							bs.set(rtosId);
						}
					}
				}
				
			}
		}
		
		
		/*
		 * For each cpu, store all used mask
		 */
		BitSet[] bits = new BitSet[oilObjects.length];
		for (int i=0; i<bits.length; i++) {
			bits[i] = new BitSet();
		}
		/*
		 * And for each event, store the used mask
		 */
		HashMap<String, BitSet> event_mask_map = new HashMap<String, BitSet>();
		for (int rtosId = 0; rtosId < oilObjects.length; rtosId++) {
			List<ISimpleGenRes> eventList = oilObjects[rtosId].getList(IOilObjectList.EVENT);
			for (Iterator<ISimpleGenRes> iter = eventList.iterator(); iter.hasNext();) {

				ISimpleGenRes curr = (ISimpleGenRes) iter.next();
				if (curr.containsProperty(ISimpleGenResKeywords.EVENT_MASK)) {
					final String ev_name = curr.getName();
					long value = curr.getLong(ISimpleGenResKeywords.EVENT_MASK);
					
					long tmp = 1;
					int tti=0;
					for (; tti<65; tti++) {
						if (tmp == value) {
							break;
						}
						tmp = tmp << 1;
					}
					if (tmp != value) {
						throw new OilCodeWriterException("Not Valid mask for " + ev_name);
					}
					
					
					if (event_mask_map.containsKey(ev_name)) {
						if (!event_mask_map.get(ev_name).get(tti)) {
							throw new OilCodeWriterException("Found two different masks for the same event " + curr.getName());
						}
					} else {
						BitSet bs = new BitSet();
						bs.set(tti);
						event_mask_map.put(ev_name, bs);
					}
					
					if (useAlwaysRemoteEvent) {
						for (int i=0; i<oilObjects.length; i++) {
							bits[i].set(tti);
						}
					} else {
						if (event_to_cpu_map.containsKey(ev_name)) {
							BitSet cpuIds = event_to_cpu_map.get(ev_name);
							for (int i=0; i<oilObjects.length; i++) {
								if (cpuIds.get(i)) {
									bits[i].set(tti);
								}
							}
						}
					}
				}
			}
		}
		

		BitSet all_true = new BitSet();
		all_true.set(0, oilObjects.length, true);
		
		/*
		 * Set mask
		 */
		for (int rtosId = 0; rtosId < oilObjects.length; rtosId++) {
			List<ISimpleGenRes> eventList = oilObjects[rtosId].getList(IOilObjectList.EVENT);
			for (Iterator<ISimpleGenRes> iter = eventList.iterator(); iter.hasNext();) {

				ISimpleGenRes curr = (ISimpleGenRes) iter.next();
				final String ev_name = curr.getName();
				
				if (useAlwaysRemoteEvent || event_to_cpu_map.containsKey(ev_name)) {
					BitSet cpuIds = useAlwaysRemoteEvent ? all_true : event_to_cpu_map.get(ev_name);
					
					int mask;
					if (event_mask_map.containsKey(ev_name)) {
						mask = event_mask_map.get(ev_name).nextSetBit(0);
					} else {
						mask = getValidMask(cpuIds, bits);
						{
							BitSet bs = new BitSet();
							bs.set(mask);
							event_mask_map.put(ev_name, bs);
						}
					}
					
					curr.setProperty(ISimpleGenResKeywords.EVENT_MASK, "" + (1<<mask));
					curr.setObject(ISimpleGenResKeywords.EVENT_CPU_BITSET, cpuIds);
				} else {
					curr.setProperty(ISimpleGenResKeywords.EVENT_MASK, "" + (0));
					curr.setObject(ISimpleGenResKeywords.EVENT_CPU_BITSET, new BitSet());
				}
				
			}

		}

	}
	
	
	private int getValidMask(BitSet cpuIds, BitSet[] usedMasks) throws OilCodeWriterException {
		int answer = 0;
		boolean searching = true;
		
		for (; searching && answer <65; ) {
			
			boolean valid_mask = true;
			
			for (int i=0; i<usedMasks.length && valid_mask; i++) {
				if (cpuIds.get(i) && usedMasks[i].get(answer)) {
					valid_mask = false;
				}
			}
			searching = !valid_mask;
			if (searching) {
				answer++;
			}
		}
		
		if (answer == 65) {
			throw new OilCodeWriterException("Not able to automatically set the mask to all events!!");
		}
		
		for (int i=0; i<usedMasks.length; i++) {
			if (cpuIds.get(i)) {
				usedMasks[i].set(answer);
			}
		}

		
		return answer;
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions#updateKeywords(java.util.ArrayList, java.lang.String[])
	 */
	@Override
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix) throws OilCodeWriterException {
		
		if (parent.getRtosSize() > 1) {
	
			final IVarTree vt = parent.getVt();
			boolean useRpc = false;
	
			//final ArrayList ee_opts = new ArrayList();
			for (int i=0; i<rtosPrefix.length; i++) {
				
				/*******************************************************************
				 * BOARD TYPE
				 ******************************************************************/
				String path = parent.computeOilRtosPrefix(rtosPrefix[i]) + "REMOTENOTIFICATION";
	
				String[] child = new String[1];
				String board_type = CommonUtils.getFirstChildEnumType(vt,
						path , child);
				if (board_type != null) {
	
					// check if the value is valid
					if ("USE_RPC".equals(board_type)) {
						useRpc = true;
					}
				}
			}
	
			if (useRpc && !keywords.contains("USE_RN")) {
				keywords.add(DEF__USE_RPC__);
			}
		}
	}
	
}
