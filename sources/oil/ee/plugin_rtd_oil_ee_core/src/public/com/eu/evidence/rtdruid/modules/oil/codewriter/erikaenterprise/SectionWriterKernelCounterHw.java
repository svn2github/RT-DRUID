package com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.SectionWriterIsr.IsrInfo;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;

public class SectionWriterKernelCounterHw implements IEEWriterKeywords, IExtractObjectsExtentions {

	final String indent1 = IWritersKeywords.INDENT;
	final String indent2 = indent1 + IWritersKeywords.INDENT;
	final String indent3 = indent2 + IWritersKeywords.INDENT;

	protected final String hw_id;
	protected final String systimer_handler;
	
	protected Boolean checked;
	protected boolean allowSystemTimerPriority = false;
	protected SectionWriterIsr generateIsr2Defines = null;
	protected boolean computeIsrEntryFromPriority = false;
	protected boolean computeIsrIDFromPriority = false;
	
	protected final ErikaEnterpriseWriter parent;

	
	public SectionWriterKernelCounterHw(ErikaEnterpriseWriter parent, String hw_id, String systimer_handler) {
		this.parent = parent;
		this.hw_id = hw_id;
		this.systimer_handler = systimer_handler;
		checked = null;
	}
	
	/**
	 * @param allowSystemTimerPriority the allowSystemTimerPriority to set
	 */
	public void setAllowSystemTimerPriority(boolean allowSystemTimerPriority) {
		this.allowSystemTimerPriority = allowSystemTimerPriority;
	}
	
	/**
	 * @param generateIsr2Defines the generateIsr2Defines to set
	 */
	public void setGenerateIsr2Defines(SectionWriterIsr generateIsr2Defines) {
		this.generateIsr2Defines = generateIsr2Defines;
	}
	
	/**
	 * @param computeIsrEntryFromPriority the computeIsrEntryFromPriority to set
	 */
	public void setComputeIsrEntryFromPriority(boolean computeIsrEntryFromPriority) {
		this.computeIsrEntryFromPriority = computeIsrEntryFromPriority;
	}
	
	/**
	 * @param computeIsrIDFromPriority the computeIsrIDFromPriority to set
	 */
	public void setComputeIsrIDFromPriority(boolean computeIsrIDFromPriority) {
		this.computeIsrIDFromPriority = computeIsrIDFromPriority;
	}
	
	public void writeCounterHw(int currentRtosId, IOilObjectList ool, IOilWriterBuffer oilWBuff) throws OilCodeWriterException {

		int max_counter_hw = 0;
		ISimpleGenRes sysTimer = null;
		Map<String, ISimpleGenRes> devices = new LinkedHashMap<String, ISimpleGenRes>();
		CpuHwDescription cpuDescr = ErikaEnterpriseWriter.getCpuHwDescription(ool);

		for (ISimpleGenRes sgr: ool.getList(IOilObjectList.COUNTER)) {
			if (sgr.containsProperty(ISimpleGenResKeywords.COUNTER_TYPE) && 
					ISimpleGenResKeywords.COUNTER_TYPE_HW.equalsIgnoreCase(sgr.getString(ISimpleGenResKeywords.COUNTER_TYPE))) {
				max_counter_hw ++;
					
				if (sgr.containsProperty(ISimpleGenResKeywords.COUNTER_DEVICE)) {
					String device = sgr.getString(ISimpleGenResKeywords.COUNTER_DEVICE);
					if (device != null) {
						if (devices.containsKey(device)) {
						Messages.sendWarningNl(
								"Two or more hw counter connected to the same device in the same cpu " +
								"(device = " + device
								+ ", counters = " + devices.get(device).getName() + " and " + sgr.getName() +")" );
						} else {
							devices.put(device, sgr);
						}
					}
				}
					
				if (sysTimer == null) {
					if (sgr.containsProperty(ISimpleGenResKeywords.COUNTER_SYSTIMER)
							&& Boolean.TRUE.equals(sgr.getObject(ISimpleGenResKeywords.COUNTER_SYSTIMER))) {
							sysTimer = sgr;
						}
				}

			} else {
				// we suppose that HW counters are the firsts in the list
				break;
			}
		}

		// check if there is at least one HW counter
		if (max_counter_hw == 0) {
			return;
		}
		
		
	
		if (SectionWriterIsr.checkStaticIsrTable(parent, currentRtosId)) {
			// check if there is an ISR with the same entry
			for (ISimpleGenRes  isr : ool.getList(IOilObjectList.ISR)) {
				String category = isr.containsProperty(ISimpleGenResKeywords.ISR_CATEGORY) ? isr.getString(ISimpleGenResKeywords.ISR_CATEGORY) : "";
				
				if ("2".equals(category)) {
					String entry = isr.containsProperty(ISimpleGenResKeywords.ISR_ENTRY) ? isr.getString(ISimpleGenResKeywords.ISR_ENTRY) : "";
					if (devices.containsKey(entry)) {
						Messages.sendWarningNl("The device " + entry + " is connected to both an HW counter ("+devices.get(entry)+") and to a isr ("+isr.getName()+").");
						devices.remove(entry);
					}
				}
			}
		}

		{
			// defines
			final StringBuffer buffer = oilWBuff.get(FILE_EE_CFG_H);
			final ICommentWriter commentWriterH = SectionWriter.getCommentWriter(ool, FileTypes.H);
			
			buffer.append(commentWriterH.writerBanner("HW counter definition"));
			String speed = AbstractRtosWriter.getOsProperty(ool, IEEWriterKeywords.SGRK_OS_CPU_SPEED_HZ);
			if (speed == null) {
				// check if the master cpu has a clock setting
				IOilObjectList masterOol = parent.getOilObjects()[0];
				speed = AbstractRtosWriter.getOsProperty(masterOol, IEEWriterKeywords.SGRK_OS_CPU_SPEED_HZ);
				if (speed == null) {
					throw new OilCodeWriterException("Expected a CLOCK for cpu " + ErikaEnterpriseWriter.getOSName(ool));
				}
			}
			buffer.append(    "#define EE_MAX_COUNTER_HW " + max_counter_hw+"\n");
			if (sysTimer != null) {
				buffer.append("#define EE_SYSTEM_TIMER   " + sysTimer.getName() +"\n");
				if (sysTimer.containsProperty(ISimpleGenResKeywords.COUNTER_DEVICE)) {
					String deviceId = sysTimer.getString(ISimpleGenResKeywords.COUNTER_DEVICE);
					CpuHwDescription.McuCounterDevice device = cpuDescr == null ? null : cpuDescr.getMcuDevice(deviceId);
					String value = "EE_" + 
							(device == null ? hw_id : device.getMcu_id()) // CPU - MCU id
							+ "_"+deviceId;
					buffer.append("#define EE_SYSTEM_TIMER_DEVICE   " + value +"\n");
				}
			}
			
			buffer.append("\n");
			
			if (generateIsr2Defines == null) {
				for (Entry<String, ISimpleGenRes> dev: devices.entrySet()) {
					String deviceId = dev.getKey();
					CpuHwDescription.McuCounterDevice device = cpuDescr == null ? null : cpuDescr.getMcuDevice(deviceId);

					String entry_id = "EE_" + 
							(device == null ? hw_id : device.getMcu_id()) // CPU - MCU id
							+ "_"+deviceId+"_ISR";

					ISimpleGenRes curr = dev.getValue();
					buffer.append("#define " + entry_id + " " + curr.getString(ISimpleGenResKeywords.COUNTER_GENERATED_HANDLER) +"\n");
					if (curr.containsProperty(ISimpleGenResKeywords.COUNTER_GENERATED_PRIORITY_STRING)) {
						String prio = curr.getString(ISimpleGenResKeywords.COUNTER_GENERATED_PRIORITY_STRING);
						final String prio_id = (device == null ?
								entry_id :
								"EE_" + hw_id +"_"+device.getEntry()
								)+"_PRI";
						buffer.append("#define " + prio_id + " " + prio+"\n");
					}
	
				}
			} else {
				
				for (ISimpleGenRes sgr: ool.getList(IOilObjectList.COUNTER)) {
					if (sgr.containsProperty(ISimpleGenResKeywords.COUNTER_TYPE) && 
							ISimpleGenResKeywords.COUNTER_TYPE_HW.equalsIgnoreCase(sgr.getString(ISimpleGenResKeywords.COUNTER_TYPE))) {

						String deviceId = sgr.containsProperty(ISimpleGenResKeywords.COUNTER_DEVICE) ? sgr.getString(ISimpleGenResKeywords.COUNTER_DEVICE) : null;
						CpuHwDescription.McuCounterDevice device = cpuDescr == null ? null : cpuDescr.getMcuDevice(deviceId);
						final String entry_id = "EE_" + 
								(device == null ? hw_id : device.getMcu_id()) // CPU - MCU id
								+ "_"+
								(computeIsrEntryFromPriority ? sgr.getString(ISimpleGenResKeywords.COUNTER_GENERATED_PRIORITY_VALUE) : deviceId)+"_ISR";
						final String prio_id = (device == null ?
								entry_id :
								"EE_" + hw_id +"_"+device.getEntry()
								)+"_PRI";

						IsrInfo info = new IsrInfo();
						
						info.name = sgr.getName();
						info.category = "2";
						info.handler = sgr.getString(ISimpleGenResKeywords.COUNTER_GENERATED_HANDLER);
						info.entry_id = entry_id;
						info.disable = false;
						info.generated_prioid = prio_id;
						info.generated_isrid = sgr.containsProperty(ISimpleGenResKeywords.COUNTER_ISR_ID_TXT) ? sgr.getString(ISimpleGenResKeywords.COUNTER_ISR_ID_TXT): null;
						info.generated_prio_string = sgr.containsProperty(ISimpleGenResKeywords.COUNTER_GENERATED_PRIORITY_STRING) ? sgr.getString(ISimpleGenResKeywords.COUNTER_GENERATED_PRIORITY_STRING): null;

						generateIsr2Defines.doWriteIsr12(buffer, commentWriterH, info);

					}
				}
			}

		}
		
		{
			// Second per ticks
			final StringBuffer buffer = oilWBuff.get(FILE_EE_CFG_C);
			final ICommentWriter commentWriterC = SectionWriter.getCommentWriter(ool, FileTypes.C);

			buffer.append(commentWriterC.writerBanner("HW counter definition"));
			buffer.append(indent1+"const EE_oo_counter_hw_ROM_type EE_counter_hw_ROM["+ErikaEnterpriseWriter.addVectorSizeDefine(ool, "EE_counter_hw_ROM", max_counter_hw)+"] = {\n");
			String pre2 = "";
			String post = "";
			List<ISimpleGenRes> counters = ool.getList(IOilObjectList.COUNTER);
			for (int i=0; i<max_counter_hw; i++) {
				ISimpleGenRes sgr = counters.get(i);

				String maxAllowed = sgr.getLong(ISimpleGenResKeywords.COUNTER_SECONDPERTICK)+"U";

				// ------ WRITE BUFFER -----
	
				buffer.append(pre2 + post + indent2+"{" + maxAllowed+ "}");
				pre2 = ",";
				post = indent2 + commentWriterC.writerSingleLineComment(sgr.getName()); // end with \n;
			}
			buffer.append(" " + post +indent1+ "};\n\n");
		}
	}

	@Override
	public void updateObjects() throws OilCodeWriterException {
		for (IOilObjectList ool : parent.getOilObjects()) {
			
			final int isrNumber = ool.getList(IOilObjectList.ISR).size();
			int counterIsrNumber = 0;
			
			// check sysTimer
			ISimpleGenRes sysTimer = null;
			for (ISimpleGenRes sgr: ool.getList(IOilObjectList.COUNTER)) {
				CpuHwDescription cpuDescr = ErikaEnterpriseWriter.getCpuHwDescription(ool);
				
				if (sgr.containsProperty(ISimpleGenResKeywords.COUNTER_TYPE) && 
						ISimpleGenResKeywords.COUNTER_TYPE_HW.equals(sgr.getObject(ISimpleGenResKeywords.COUNTER_TYPE))) {

					CpuHwDescription.McuCounterDevice device;
					{
						String deviceId = sgr.containsProperty(ISimpleGenResKeywords.COUNTER_DEVICE) ? sgr.getString(ISimpleGenResKeywords.COUNTER_DEVICE) : null;
						device = cpuDescr == null ? null : cpuDescr.getMcuDevice(deviceId);
					}
						
					if (sgr.containsProperty(ISimpleGenResKeywords.COUNTER_SYSTIMER)
							&& Boolean.TRUE.equals(sgr.getObject(ISimpleGenResKeywords.COUNTER_SYSTIMER))) {
						if (sysTimer != null) {
							throw new OilCodeWriterException("Each core can have at most a single system timers found " +sysTimer.getName()+" and " +  sgr.getName());
						}
						sysTimer = sgr;
					
						if (sgr.containsProperty(ISimpleGenResKeywords.COUNTER_USER_HANDLER)) {
							throw new OilCodeWriterException("System timer does not support handler redefinition");
						}
						
						if (!allowSystemTimerPriority && sgr.containsProperty(ISimpleGenResKeywords.COUNTER_ISR_PRIORITY)) {
							throw new OilCodeWriterException("System timer does not support priority redefinition");
						}
						
						if (device == null) {
							sgr.setProperty(ISimpleGenResKeywords.COUNTER_GENERATED_HANDLER, systimer_handler);
						} else {
							sgr.setProperty(ISimpleGenResKeywords.COUNTER_GENERATED_HANDLER, device.getHandler());							
						}
						
						sysTimer.setProperty(ISimpleGenResKeywords.GENERIC_ACCESSING_ALLOW_ALL, Boolean.TRUE.toString());
						sysTimer.setObject(ISimpleGenResKeywords.OS_APPL_NAME, ISimpleGenResKeywords.OS_APPL_KERNEL_NAME);
						sysTimer.setObject(ISimpleGenResKeywords.OS_APPL_ID, new Integer(0));
						
					} else  { // handler
						String handler = "EE_" + sgr.getName() + "_handler";
						if (sgr.containsProperty(ISimpleGenResKeywords.COUNTER_USER_HANDLER)) {
							handler = sgr.getString(ISimpleGenResKeywords.COUNTER_USER_HANDLER);
						} else if (device != null){
							handler = device.getHandler();
						}
						
						sgr.setProperty(ISimpleGenResKeywords.COUNTER_GENERATED_HANDLER, handler);
					}
					
					if (computeIsrIDFromPriority) { // ID from priority
						Integer prioVal = null;
						if (device != null) {
							prioVal = new Integer(device.getPrio());
						} else if (sgr.containsProperty(ISimpleGenResKeywords.COUNTER_ISR_PRIORITY)) {
							prioVal = new Integer(sgr.getInt(ISimpleGenResKeywords.COUNTER_ISR_PRIORITY));
						}
						
						if (prioVal != null) {
							sgr.setObject(ISimpleGenResKeywords.COUNTER_ISR_ID, new Integer(prioVal));
							sgr.setObject(ISimpleGenResKeywords.COUNTER_ISR_ID_TXT, "" + prioVal);
						}
					} else {
						
						sgr.setObject(ISimpleGenResKeywords.COUNTER_ISR_ID, new Integer(isrNumber+counterIsrNumber));
						sgr.setObject(ISimpleGenResKeywords.COUNTER_ISR_ID_TXT, "" + (isrNumber+counterIsrNumber));
					}
					
					// increased as last thing
					counterIsrNumber++;
				} // end Counter HW if
			}

			if (sysTimer != null) {

				ArrayList<String> tmp_eeopts = new ArrayList<String>();
				ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
		        if (sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_EE_OPTS)) {
		        	String[] old = (String[]) sgrCpu.getObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS);
		        	tmp_eeopts.addAll(Arrays.asList(old));
		        }
		        		
		        tmp_eeopts.add("ENABLE_SYSTEM_TIMER");
				// store ee_opts
				sgrCpu.setObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS, tmp_eeopts.toArray(new String[tmp_eeopts.size()]));
			}
		
			{ // increase the isr size
				Object o = AbstractRtosWriter.getOsObject(ool, ISimpleGenResKeywords.OS_CPU__ISR2_ADDITIONAL_NUMBER);
				int addIsrNumber = counterIsrNumber + (o == null ? 0 : ((Integer) o).intValue()) ;
				for (ISimpleGenRes os : ool.getList(IOilObjectList.OS)) {
					os.setObject( ISimpleGenResKeywords.OS_CPU__ISR2_ADDITIONAL_NUMBER, new Integer(addIsrNumber));
				}
			}
		}
	}
}
