/**
 * Created on 31/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;

/**
 * The description of a Mpc5xx
 * 
 * @author Nicola Serreli
 */
public class CpuDescrRx200 extends CpuHwDescription {

	/**
	 * 
	 */
	public CpuDescrRx200() {
		super(IWritersKeywords.CPU_RX200, "PRIVATE",
				new String[] { "SYS_SIZE" },
				new String[] {  }, 32, 4, 4, 32);
		handlesEmpyVector = false;
		supportOrtiISR2 = true;
	}
}
