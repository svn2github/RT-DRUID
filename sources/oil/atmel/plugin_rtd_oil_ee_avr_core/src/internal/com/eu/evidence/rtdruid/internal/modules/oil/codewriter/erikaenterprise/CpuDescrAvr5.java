/**
 * Created on 31/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;

/**
 * The description of an Avr5
 * 
 * @author Nicola Serreli
 */
public class CpuDescrAvr5 extends CpuHwDescription {

	/**
	 * 
	 */
	public CpuDescrAvr5() {
		super(IWritersKeywords.CPU_AVR5, "PRIVATE",
				new String[] { "SYS_SIZE" },
				new String[] { "SHARED_MIN_SYS_SIZE" }, 16, 2, 2, 16);
	}
}
