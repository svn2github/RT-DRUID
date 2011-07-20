/**
 * Created on 31/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;

/**
 * The description of a Pic30
 * 
 * @author Nicola Serreli
 */
public class CpuDescrMico32 extends CpuHwDescription {

	/**
	 * 
	 */
	public CpuDescrMico32() {
		super(IWritersKeywords.CPU_MICO_32, "PRIVATE",
				new String[] { "SYS_SIZE" }, new String[] {}, 16, 4, 4, 32, false);
	}
}
