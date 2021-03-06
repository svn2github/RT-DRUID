/**
 * Created on 31/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.hidden.modules.oil.codewriter.erikaenterprise;

import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;

/**
 * The description of a Nios2
 * 
 * @author Nicola Serreli
 */
public class CpuDescrNios2 extends CpuHwDescription {

	/**
	 * 
	 */
	public CpuDescrNios2() {
		super(IWritersKeywords.CPU_NIOSII, "PRIVATE",
				new String[] { "SYS_SIZE" },
				new String[] { "SHARED_MIN_SYS_SIZE" }, 32, 4, 4, 32);
	}
}
