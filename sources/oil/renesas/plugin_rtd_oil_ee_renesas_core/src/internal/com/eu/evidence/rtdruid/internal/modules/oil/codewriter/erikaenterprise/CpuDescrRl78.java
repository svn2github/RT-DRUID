/**
 * Created on 1/feb/2017
 *
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.util.Arrays;

import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * The description of a Rx510
 * 
 * @author Nicola Serreli
 */
public class CpuDescrRl78 extends CpuHwDescription implements CpuHwDescription.IRequiresUpdates {

	/**
	 * 
	 */
	public CpuDescrRl78() {
		super(IWritersKeywords.CPU_RL78, "PRIVATE",
				new String[] { "SYS_SIZE" },
				new String[] {  }, 32, 2, 4, 32);
		handlesEmpyVector = false;
		supportOrtiISR2 = true;
		maxIsrPriority = 4;
	}
	
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription.IRequiresUpdates#update(com.eu.evidence.rtdruid.vartree.IVarTree, com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList[])
	 */
	@Override
	public void update(ErikaEnterpriseWriter parent, IVarTree vt, IOilObjectList[] objects, final int currentCpuId) {

		addMcuDevices(Arrays.asList(new McuCounterDevice[] {
				new McuCounterDevice("TRJMR0_FCK",  "R5F10XXX", 0, "INTTRJ0", "EE_rl78_system_timer_handler", "EE_RL78_INTTRJ0_ISR"),
				new McuCounterDevice("TRJMR0_FCK8", "R5F10XXX", 0, "INTTRJ0", "EE_rl78_system_timer_handler", "EE_RL78_INTTRJ0_ISR"),
				new McuCounterDevice("TRJMR0_FCK2", "R5F10XXX", 0, "INTTRJ0", "EE_rl78_system_timer_handler", "EE_RL78_INTTRJ0_ISR"),
				new McuCounterDevice("TRJMR0_FIL",  "R5F10XXX", 0, "INTTRJ0", "EE_rl78_system_timer_handler", "EE_RL78_INTTRJ0_ISR"),
				new McuCounterDevice("TRJMR0_FSUB", "R5F10XXX", 0, "INTTRJ0", "EE_rl78_system_timer_handler", "EE_RL78_INTTRJ0_ISR"),
				new McuCounterDevice("TRJMR0_FSL",  "R5F10XXX", 0, "INTTRJ0", "EE_rl78_system_timer_handler", "EE_RL78_INTTRJ0_ISR")
		}));

	}
}
