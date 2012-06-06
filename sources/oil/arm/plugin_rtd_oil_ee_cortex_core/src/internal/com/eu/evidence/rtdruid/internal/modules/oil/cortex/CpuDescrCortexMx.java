package com.eu.evidence.rtdruid.internal.modules.oil.cortex;
/**
 * Created on 21/09/2011
 *
 * $Id$
 */


import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;

/**
 * The description of a generic Cortex Mx
 * 
 * @author Nicola Serreli
 */
public class CpuDescrCortexMx extends CpuHwDescription {

	/**
	 * 
	 */
	public CpuDescrCortexMx() {
		super(IWritersKeywords.CPU_CORTEX_MX, "PRIVATE",
				new String[] { "SYS_SIZE" }, new String[] {}, 32, 4, 4, 32);
	}
}
