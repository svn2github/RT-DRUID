package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;


import java.util.ArrayList;
import java.util.List;

import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.SectionWriterHalTricore.TcModels;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription.IRequiresUpdates;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IMacrosForSharedData;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * The description of a Pic30
 * 
 * @author Nicola Serreli
 */
public class CpuDescrTricore extends CpuHwDescription implements IRequiresUpdates {

	protected TricoreAbstractModel model;
	/**
	 * 
	 */
	public CpuDescrTricore() {
		super(IWritersKeywords.CPU_TRICORE, "PRIVATE",
				new String[] { "SYS_SIZE" }, new String[] {}, 32, 2, 4, 32);
	}
	
	/**
	 * @param model the model to set
	 */
	public void setModel(TricoreAbstractModel model) {
		this.model = model;
		if (model != null) {
			packIsrPriorities = model.isPackIsrPriorities();
			supportOrtiISR2 = true;
			maxNestedInts = 255;
			IMacrosForSharedData tmp = model.getMacros();
			if (tmp != null) {
				macros = tmp;
			}
			if (model.osApplicationAreas() != null) {
				osApplicationNames = model.osApplicationAreas();
			}
		}
	}
	
	/**
	 * @return the model
	 */
	public TricoreAbstractModel getModel() {
		return model;
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription.IRequiresUpdates#update(com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes)
	 */
	@Override
	public void update(ErikaEnterpriseWriter parent, IVarTree vt, IOilObjectList[] oilObjects, int currentCpuId) {
		
        String model = null;
		for (IOilObjectList ool : oilObjects) {

			/***********************************************************************
			 * get values
			 **********************************************************************/
			ArrayList<String> childPaths = new ArrayList<String>();
			List<String> childFound = ErikaEnterpriseWriter.getRtosCommonChildType(vt, ool, "MCU_DATA", childPaths);

			for (int index = 0; index<childFound.size(); index++) {
				
				String mcu_type = childFound.get(index);
				
				if (SectionWriterHalTricore.TRICORE_MCU.equals(mcu_type)) {
					if (model == null) {
						// ... and compete it 
						String currentMcuPrefix = childPaths.get(index) + IEEWriterKeywords.PARAMETER_LIST + "MODEL";
						model = CommonUtils.getFirstChildEnumType(vt, currentMcuPrefix, null);
					}
				}
			}
		}
        TcModels tcModel = TcModels.get(model);
		if (tcModel != null) {
			setModel( tcModel.provider.newTricoreModel());
		}
		
	}
}
