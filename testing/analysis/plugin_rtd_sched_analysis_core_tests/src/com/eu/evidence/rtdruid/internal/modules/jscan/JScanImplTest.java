package com.eu.evidence.rtdruid.internal.modules.jscan;

import java.util.Properties;

import com.eu.evidence.rtdruid.internal.modules.jscan.cachecost.CacheCostSchedulability;
import com.eu.evidence.rtdruid.internal.modules.jscan.common.HyperplanesAnalysis;
import com.eu.evidence.rtdruid.internal.modules.jscan.common.JScanImpl;
import com.eu.evidence.rtdruid.internal.modules.jscan.common.RMSchedulability;
import com.eu.evidence.rtdruid.internal.modules.jscan.common.RTASchedulability;
import com.eu.evidence.rtdruid.internal.modules.jscan.multiframe.MultiFrameTaskSchedulability;
import com.eu.evidence.rtdruid.internal.modules.jscan.offset.OffSetSchedulability;
import com.eu.evidence.rtdruid.internal.modules.jscan.offset.OffSetSchedulabilityAssignment;
import com.eu.evidence.rtdruid.internal.modules.jscan.offset.OffsetDMSchedulabilityComplete;
import com.eu.evidence.rtdruid.internal.modules.jscan.offset.OffsetEDFSchedulabilityComplete;
import com.eu.evidence.rtdruid.vartree.IVarTree;

public class JScanImplTest extends JScanImpl {

	/* WITHOUT OFFSET */
	/***/
	public RMSchedulability prepareRMTest(IVarTree vt, String prefix, String mode) {
		return prepareRM(vt, prefix, mode, null);
	}
	/***/
	public RTASchedulability prepareRTATest(IVarTree vt, String prefix, String mode) {
		return prepareRTA(vt, prefix, mode, null);
	}
	/***/
	public HyperplanesAnalysis prepareHPATest(IVarTree vt, String prefix, String mode) {
		return prepareHPA(vt, prefix, mode, null);
	}
	/***/
	public MultiFrameTaskSchedulability prepareMultiFrameTest(IVarTree vt, String prefix, String mode) {
		return prepareMultiFrame(vt, prefix, mode, null);
	}
	/***/
	public CacheCostSchedulability prepareCacheMissCostTest(IVarTree vt, String prefix, String mode) {
		return prepareCacheMissCost(vt, prefix, mode, null);
	}

	/* WITH OFFSET */
	/***/
	public OffSetSchedulability prepareOSEDFTest(IVarTree vt, String prefix, String mode) {
		return prepareOSEDF(vt, prefix, mode, null);
	}


	public OffSetSchedulability prepareOSRTTest(IVarTree vt, String prefix, String mode) {
		return prepareOSRT(vt, prefix, mode, null);
	}
	public OffSetSchedulability prepareOSHPTest(IVarTree vt, String prefix, String mode) {
		return prepareOSHP(vt, prefix, mode, null);
	}
	public OffSetSchedulabilityAssignment prepareOSATest(IVarTree vt, String prefix, String mode) {
		return prepareOSA(vt, prefix, mode, null);
	}
	public OffsetDMSchedulabilityComplete prepareOSDMTest(IVarTree vt, String prefix, String mode) {
		return prepareOSDM(vt, prefix, mode, null);
	}
	
	public OffsetEDFSchedulabilityComplete prepareOSEDFCTest(IVarTree vt, String prefix, String mode) {
		return prepareOSEDFC(vt, prefix, mode, null);
	}

	
	
	
	
	
	
	
	/* WITHOUT OFFSET */
	/***/
	public RMSchedulability prepareRMTest(IVarTree vt, String prefix, String mode, Properties option) {
		return prepareRM(vt, prefix, mode, option);
	}
	/***/
	public RTASchedulability prepareRTATest(IVarTree vt, String prefix, String mode, Properties option) {
		return prepareRTA(vt, prefix, mode, option);
	}
	/***/
	public HyperplanesAnalysis prepareHPATest(IVarTree vt, String prefix, String mode, Properties option) {
		return prepareHPA(vt, prefix, mode, option);
	}
	/***/
	public MultiFrameTaskSchedulability prepareMultiFrameTest(IVarTree vt, String prefix, String mode, Properties option) {
		return prepareMultiFrame(vt, prefix, mode, option);
	}
	/***/
	public CacheCostSchedulability prepareCacheMissCostTest(IVarTree vt, String prefix, String mode, Properties option) {
		return prepareCacheMissCost(vt, prefix, mode, option);
	}

	/* WITH OFFSET */
	/***/
	public OffSetSchedulability prepareOSEDFTest(IVarTree vt, String prefix, String mode, Properties option) {
		return prepareOSEDF(vt, prefix, mode, option);
	}


	public OffSetSchedulability prepareOSRTTest(IVarTree vt, String prefix, String mode, Properties option) {
		return prepareOSRT(vt, prefix, mode, option);
	}
	public OffSetSchedulability prepareOSHPTest(IVarTree vt, String prefix, String mode, Properties option) {
		return prepareOSHP(vt, prefix, mode, option);
	}
	public OffSetSchedulabilityAssignment prepareOSATest(IVarTree vt, String prefix, String mode, Properties option) {
		return prepareOSA(vt, prefix, mode, option);
	}
	public OffsetDMSchedulabilityComplete prepareOSDMTest(IVarTree vt, String prefix, String mode, Properties option) {
		return prepareOSDM(vt, prefix, mode, option);
	}
	
	public OffsetEDFSchedulabilityComplete prepareOSEDFCTest(IVarTree vt, String prefix, String mode, Properties option) {
		return prepareOSEDFC(vt, prefix, mode, option);
	}

	
}
