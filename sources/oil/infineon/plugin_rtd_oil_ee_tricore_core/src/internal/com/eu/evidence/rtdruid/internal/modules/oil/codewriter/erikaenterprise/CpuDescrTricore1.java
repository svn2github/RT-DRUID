package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;


import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;

/**
 * The description of a Pic30
 * 
 * @author Nicola Serreli
 */
public class CpuDescrTricore1 extends CpuHwDescription {

	/**
	 * 
	 */
	public CpuDescrTricore1() {
		super(IWritersKeywords.CPU_TRICORE1, "PRIVATE",
				new String[] { "SYS_SIZE" }, new String[] {}, 32, 2, 4, 32);
	}
}
