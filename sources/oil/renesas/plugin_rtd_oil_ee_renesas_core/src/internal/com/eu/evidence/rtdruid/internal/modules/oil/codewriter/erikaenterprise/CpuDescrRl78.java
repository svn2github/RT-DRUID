/**
 * Created on 1/feb/2017
 *
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;

/**
 * The description of a Rx510
 * 
 * @author Nicola Serreli
 */
public class CpuDescrRl78 extends CpuHwDescription {

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
}
