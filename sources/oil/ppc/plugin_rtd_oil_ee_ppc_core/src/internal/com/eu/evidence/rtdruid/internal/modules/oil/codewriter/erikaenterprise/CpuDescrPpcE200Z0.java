/**
 * Created on 31/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;

/**
 * The description of a MPC5674F
 * 
 * @author Nicola Serreli
 */
public class CpuDescrPpcE200Z0 extends CpuHwDescription {

	/**
	 * 
	 */
	public CpuDescrPpcE200Z0() {
		super(IWritersKeywords.CPU_PPCE200Z0, "PRIVATE",
				new String[] { "SYS_SIZE" }, new String[] {}, 16, 4, 4, 32, false);
		handlesEmpyVector = false;
		
		macros = new MacrosForSharedData();
	}
	
	@Override
	public String initEmptyVector() {
		return "{0U}";
	}
}
