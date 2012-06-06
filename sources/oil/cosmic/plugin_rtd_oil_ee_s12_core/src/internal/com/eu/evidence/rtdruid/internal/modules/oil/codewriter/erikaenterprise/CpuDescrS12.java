package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;
/**
 * Created on 31/ott/2008
 *
 * $Id$
 */


import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;

/**
 * The description of a S12
 * 
 * @author Nicola Serreli
 */
public class CpuDescrS12 extends CpuHwDescription {

	/**
	 * 
	 */
	public CpuDescrS12() {
		this(IWritersKeywords.CPU_S12);
	}
	
	/**
	 * 
	 */
	CpuDescrS12(String ID) {
		super(ID, "PRIVATE",
				new String[] { "SYS_SIZE" }, new String[] {}, 16, 2, 2, 16);
		
		commentManager.setWriter(FileTypes.H, new CommentWriterS12H());
	}
}
