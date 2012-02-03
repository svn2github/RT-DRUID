/**
 * 
 */
package com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces;

import java.util.List;

import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEoptConstant;
import com.eu.evidence.rtdruid.modules.oil.interfaces.ISectionWriter;

/**
 * This interface is used to improve the generation of EE_OPT
 * */
public interface IGetEEOPTExtentions extends ISectionWriter, IEEoptConstant {
	
	/***************************************************************************
	 * Methods
	 **************************************************************************/

	/**
	 * Returns a list of EE_OPT of the specified type.
	 */
	List<String> getEEOpt(int type, int rtosId);
}