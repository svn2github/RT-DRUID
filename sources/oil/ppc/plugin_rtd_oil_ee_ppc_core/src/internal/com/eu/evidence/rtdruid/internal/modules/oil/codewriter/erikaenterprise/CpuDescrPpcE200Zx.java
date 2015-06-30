/**
 * Created on 31/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.util.Arrays;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EECpuDescriptionManager;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * The description of a Powepc e200zx
 * 
 * @author Nicola Serreli
 */
public class CpuDescrPpcE200Zx extends CpuHwDescription implements CpuHwDescription.IRequiresUpdates {

	/**
	 * 
	 */
	public CpuDescrPpcE200Zx() {
		super(IWritersKeywords.CPU_PPCE200ZX, "PRIVATE",
				new String[] { "SYS_SIZE" }, new String[] {}, 32, 4, 4, 32, true);
		handlesEmpyVector = false;
		supportOrtiISR2 = true;
		
		macros = new MacrosForSharedData();
		mmuAvailable = true;
		

		/*
		 * (16 interrupts priorities and 3 timers)
		 */
		maxNestedInts = 19;
	}
	
	@Override
	public String initEmptyVector() {
		return "{0U}";
	}
	
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription.IRequiresUpdates#update(com.eu.evidence.rtdruid.vartree.IVarTree, com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList[])
	 */
	@Override
	public void update(ErikaEnterpriseWriter parent, IVarTree vt, IOilObjectList[] objects, final int currentCpuId) {
		
		{
		/***********************************************************************
		 * 
		 * Get CPU model
		 *  
		 **********************************************************************/
			IOilObjectList ool = objects[currentCpuId];
			String hw_type = null;
	//		Utility.explodeOilVar(Utility.varTreeToStringErtd(vt))
			for (String currentCpuPrefix: AbstractRtosWriter.getOsProperties(ool, IEEWriterKeywords.SGRK_OS_CPU_DATA_PREFIX)) {
				String cpu_model = CommonUtils.getFirstChildEnumType(vt, currentCpuPrefix+"MODEL", null);
				if ("E200Z0".equals(cpu_model)) {
					hw_type = IWritersKeywords.CPU_PPCE200Z0;
					
				} else if ("E200Z4".equals(cpu_model)) {
					hw_type = IWritersKeywords.CPU_PPCE200Z4;
					
				} else if ("E200Z6".equals(cpu_model)) {
					hw_type = IWritersKeywords.CPU_PPCE200Z6;
					
				} else if ("E200Z7".equals(cpu_model)) {
					hw_type = IWritersKeywords.CPU_PPCE200Z7;
					
				} else {
					Messages.sendError((cpu_model != null ? "Wrong" : "Missing") +
							" cpu model for PPC E200Zx family." +
							(cpu_model != null ? " Found " + cpu_model : ""), null, "", null);
				}
			}
			if (hw_type != null) {
				ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
				sgrCpu.setProperty(ISimpleGenResKeywords.OS_CPU_TYPE, hw_type);
			}
		}
		
		String mcuModel = null;
		for (IOilObjectList ool : objects) {
			if (mcuModel == null) {
				mcuModel = SectionWriterHalMpc567.getMcuType(vt, ool);
			}
		}

		if (SectionWriterHalMpc567.MCU_MPC5643L.equals(mcuModel)) {
			addMcuDevices(Arrays.asList(new McuCounterDevice[] {
					new McuCounterDevice("STM", "MPC5643L", 0, "30", "EE_mpc5643l_system_timer_handler")
			}));
		}

	}
}
