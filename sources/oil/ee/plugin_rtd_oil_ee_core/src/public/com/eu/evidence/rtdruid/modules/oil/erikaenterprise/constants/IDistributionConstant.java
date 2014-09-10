/**
 * Created on 01/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants;

/**
 * @author Nicola Serreli
 *
 */
public interface IDistributionConstant {

	//  -------------------- Distributions --------------------

	/** Distribution name. Used during build of ".mk" and during build of configurations files */
	public final static String DEF__EE_DISTRIBUTION_NAME__ = "set_ee_distribution_name";
	
	/***************************************************************************
	 * 
	 * Build ".mk" file required to build EE Distribution (Libraries)
	 *  
	 **************************************************************************/

	/** Build a ".mk" for EE Source Distribution */
	public final static String DEF__EE_BUILD_SOURCE_DISTRIBUTION__         = "build_ee_source_distribution";
	/** Build a ".mk" for EE Binary Distribution FULL */
	public final static String DEF__EE_BUILD_BINARY_DISTRIBUTION_FULL__    = "build_ee_binary_distribution_full";
	/** Build a ".mk" for EE Binary Distribution LIMITED */
	public final static String DEF__EE_BUILD_BINARY_DISTRIBUTION_LIMITED__ = "build_ee_binary_distribution_limited";
	/** Identifies the ".mk" file to build */
	public final static String DEF__EE_BUILD_DISTRIBUTION_FILENAME__       = "contains the path and name of .mk file";
	/***************************************************************************
	 * 
	 * USE Sources Distribution -> Makefile uses directly EE sources and
	 * RT-Druid doesn't search/check any signature of EE Library
	 *  
	 **************************************************************************/
 	public final static String DEF__EE_USE_SOURCE_DISTRIBUTION__         = "use_ee_source_distribution";
	
	/***************************************************************************
	 * 
	 * USE Binary Distribution
	 *  
	 **************************************************************************/
 	/**
	  * Exist if is used a binary distribution of Erika E., and is used to
	  * identify the name of "used library" (only if that library is the same
	  * for the whole system)
	  */
	public final static String DEF__EE_USE_BINARY_DISTRIBUTION__         = "use_ee_binary_distribution";
	public final static String DEF__EE_USE_BINARY_DISTRIBUTION_FULL__    = "use_ee_binary_distribution_full";
	public final static String DEF__EE_USE_BINARY_DISTRIBUTION_LIMITED__ = "use_ee_binary_distribution_limited";

	public final static String DEF__BINARY_DISTRIBUTION_FORCE_ALARM_AUTOSTART__ = "bin_distr__force_alarm_autostart";
	public final static String DEF__BINARY_DISTRIBUTION_FORCE_TASK_AUTOSTART__ = "bin_distr__force_task_autostart";
	public final static String DEF__BINARY_DISTRIBUTION_FORCE_SCHED_TAB_AUTOSTART__ = "bin_distr__force_sched_tab_autostart";

	/***/
	public final static String DEF__EE_SIGNATURE_DOCUMENT_ISTREAM__ = "use_this_signature's_document_(inputStream)";

}
