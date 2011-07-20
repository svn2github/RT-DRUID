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
public class CpuDescrMpc5 extends CpuHwDescription {

	/**
	 * 
	 */
	public CpuDescrMpc5() {
		super(IWritersKeywords.CPU_MPC5xx, "PRIVATE",
				new String[] { "SYS_SIZE" },
				new String[] { "SHARED_MIN_SYS_SIZE" }, 32, 4, 4, 32);
	}
}
