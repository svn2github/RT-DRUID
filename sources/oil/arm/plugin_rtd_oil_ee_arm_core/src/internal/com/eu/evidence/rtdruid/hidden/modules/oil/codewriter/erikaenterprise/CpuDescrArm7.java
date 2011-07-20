/**
 * Created on 31/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.hidden.modules.oil.codewriter.erikaenterprise;

import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;

/**
 * The description of an Arm7
 * 
 * @author Nicola Serreli
 */
public class CpuDescrArm7 extends CpuHwDescription {

	/**
	 * 
	 */
	public CpuDescrArm7() {
		super(
				IWritersKeywords.CPU_ARM7,
				"PRIVATE",
				new String[] { "SYS_SIZE"/* , "IRQ_SIZE" */},
				new String[] { "SHARED_MIN_SYS_SIZE"/* , "SHARED_MIN_IRQ_SIZE" */},
				32, 4, 4, 32);
	}
}
