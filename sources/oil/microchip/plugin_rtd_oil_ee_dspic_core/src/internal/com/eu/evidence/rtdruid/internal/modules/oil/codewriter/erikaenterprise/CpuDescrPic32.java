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
public class CpuDescrPic32 extends CpuHwDescription {

	/**
	 * 
	 */
	public CpuDescrPic32() {
		super(IWritersKeywords.CPU_PIC_32, "PRIVATE",
				new String[] { "SYS_SIZE" }, new String[] {}, 16, 2, 4, 32);
	}
}
