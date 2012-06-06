/**
 * Created on 12/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants;

import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions;

/**
 * @author Nicola Serreli
 *
 */
public interface IEEoptConstant {

	/***************************************************************************
	 * EE_OPT types
	 **************************************************************************/

	/** Identifies only automatic options */
	int EE_OPT_COMMON_AUTO_ONLY = 1 << 2;

	/** Identifies only automatic options about's cpu */
	int EE_OPT_CPU_ONLY = 1 << 3;

	/** Enables only options that can be setted with binary distributions */
	// int EE_OPT_USE_BINARY_DISTR = 1<<4;
	/** Enables only options that are used to generate a binary distributions */
	// int EE_OPT_GENERATE_BINARY_DISTR = 1<<5;
	/**
	 * Enable options that are used to identify distributions
	 * 
	 * @deprecated old
	 */
	int EE_OPT_ENABLE_DISTR = 1 << 6;

	/**
	 * Disable all options not valid inside a signature
	 * 
	 * @deprecated old
	 */
	int EE_OPT_FOR_SIGNATURE = 1 << 7;

	/** Identifies only user options */
	int EE_OPT_USER_ONLY = 1;

	/**
	 * Identifies all options (without USE/GENERATE binary distribution and
	 * "for a signature")
	 */
	int EE_OPT_ALL = EE_OPT_USER_ONLY
			| EE_OPT_COMMON_AUTO_ONLY | EE_OPT_CPU_ONLY | EE_OPT_ENABLE_DISTR;


}
