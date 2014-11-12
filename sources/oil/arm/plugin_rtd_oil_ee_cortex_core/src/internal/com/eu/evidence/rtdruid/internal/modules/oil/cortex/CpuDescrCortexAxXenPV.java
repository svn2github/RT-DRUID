package com.eu.evidence.rtdruid.internal.modules.oil.cortex;
/**
 * Created on 21/09/2011
 *
 * $Id$
 */


import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * The description of a generic Cortex Mx
 *
 * @author Nicola Serreli
 */
public class CpuDescrCortexAxXenPV extends CpuHwDescription implements CpuHwDescription.IRequiresUpdates {

	/**
	 *
	 */
	public CpuDescrCortexAxXenPV() {
		super(IWritersKeywords.CPU_CORTEX_AX_XENPV, "PRIVATE",
				new String[] { "SYS_SIZE" }, new String[] {}, 32, 4, 4, 32);

		macros = new MacrosForSharedData();
		packIsrPriorities = true;


	}

	public void update(ErikaEnterpriseWriter parent, IVarTree vt, IOilObjectList[] objects, int currentCpuId) {
		if (parent.checkKeyword(IEEWriterKeywords.DEF__USE_RPC__)) {
			startingIsrPriority = 1;
		}
	}
}
