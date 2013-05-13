/**
 * 26/set/2012
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * 
 * @author Nicola Serreli
 * @since 2.0
 * 
 */
public abstract class TricoreAbstractModel {
	
	public interface ITricoreModelProvider {
		TricoreAbstractModel newTricoreModel();
	}
	

	protected IVarTree vt;
	protected ErikaEnterpriseWriter parent;

	/**
	 * @param vt
	 * @param parent
	 * @param currentRtosId
	 * @throws OilCodeWriterException
	 */
	public void updateObjects(ErikaEnterpriseWriter parent, int currentRtosId) throws OilCodeWriterException {
		this.parent = parent;
		this.vt = parent == null ? null : parent.getVt();
	}

	public void write(final int currentRtosId, IOilObjectList ool, IOilWriterBuffer buffers)
			throws OilCodeWriterException {
	};

	public String[] getEEopts(final int currentRtosId, IOilObjectList ool) {
		return new String[0];
	}

	/**
	 * @return
	 */
	public boolean isPackIsrPriorities() {
		return true;
	}
}
