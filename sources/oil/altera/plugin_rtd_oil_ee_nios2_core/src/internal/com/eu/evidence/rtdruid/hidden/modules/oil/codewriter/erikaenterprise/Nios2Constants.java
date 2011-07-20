/**
 * Created on 30/set/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.hidden.modules.oil.codewriter.erikaenterprise;

/**
 * @author Nicola Serreli
 *
 */
class Nios2Constants {

	/** Enable Nios MultiProcessor */
	public final static String DEF__NIOS2_MULTICPU__ = "__NIOS2_MULTICPU__";
	/** Enable spin lock using custom instruction */
	public final static String DEF__NIOS2_SPIN_CUSTOM_INSTRUCTION__ = "__NIOS2_SPIN_CUSTOM_INSTRUCTION__";
	/** Enable spin lock using altera's mutex */
//	public final static String DEF__NIOS2_SPIN_AVALON_MUTEX__ = "__NIOS2_SPIN_AVALON_MUTEX__";
	/** Enable Syncronization after mutex initialization */
	public final static String DEF__NIOS2_SYNC_INIT_MUTEX__ = "__NIOS2_SYNC_INIT_MUTEX__";
	/** Use altera's ipic for nios2 */
	public final static String DEF__NIOS2_IPIC_PIO__ = "__NIOS2_IPIC_PIO__";
	
	/** Identifies Nios2 System library */
	public final static String SGRK__NIOS2_SYSTEM_LIBRARY__ = "__NIOS2_SYSTEM_LIBRARY__";
	
	/** Identifies the path of Nios2 System library */
	public final static String SGRK__NIOS2_SYSTEM_LIBRARY_PATH__ = "__NIOS2_SYSTEM_LIBRARY_PATH__";

}
