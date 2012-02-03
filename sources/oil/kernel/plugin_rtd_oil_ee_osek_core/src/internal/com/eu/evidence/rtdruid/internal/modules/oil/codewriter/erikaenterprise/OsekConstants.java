/**
 * Created on 30/set/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;

/**
 * @author Nicola Serreli
 *
 */
class OsekConstants {

	

	/** Enable osek extended status */
	public final static String DEF__OSEKOS_EXTENDED_STATUS__ = "__OO_EXTENDED_STATUS__";

	/** Enable osek start-up hook */
	public final static String DEF__OSEKOS_HAS_STARTUPHOOK__ = "__OO_HAS_STARTUPHOOK__";

	/** A 'general' way to define syncronous startup of a MultiProcessor System.
	 *  
	 *  This keyword isn't an EE_OPT and isn't directly used by Erika Enterprise 
	 */
	public final static String DEF__OSEKOS_HAS_STARTUPSYNC__ = IEEWriterKeywords.DEF__EE_HAS_STARTUPSYNC__;

	/***/
	public final static String DEF__OSEKOS_HAS_STARTUPBARRIER__ = IEEWriterKeywords.DEF__EE_HAS_STARTUPBARRIER__;
	
	/** Enable osek error hook */
	public final static String DEF__OSEKOS_HAS_ERRORHOOK__ = "__OO_HAS_ERRORHOOK__";

	/** Enable osek shutdown hook */
	public final static String DEF__OSEKOS_HAS_SHUTDOWNHOOK__ = "__OO_HAS_SHUTDOWNHOOK__";

	/** Enable osek pre-task hook */
	public final static String DEF__OSEKOS_HAS_PRETASKHOOK__ = "__OO_HAS_PRETASKHOOK__";

	/** Enable osek post-task hook */
	public final static String DEF__OSEKOS_HAS_POSTTASKHOOK__ = "__OO_HAS_POSTTASKHOOK__";

	/** Enable osek "use get service id" option */
	public final static String DEF__OSEKOS_HAS_USEGETSERVICEID__ = "__OO_HAS_USEGETSERVICEID__";

	/** Enable osek "use parameter access" option */
	public final static String DEF__OSEKOS_HAS_USEPARAMETERACCESS__ = "__OO_HAS_USEPARAMETERACCESS__";

	/** Enable osek "use res scheduler" option */
	public final static String DEF__OSEKOS_HAS_USERESSCHEDULER__ = IEEWriterKeywords.DEF__OS_HAS_USERESSCHEDULER__;

	/** Enable orti's res-locked option */
	//public final static String DEF__OSEK_ORTI_RESLOCKED__ = "__OO_ORTI_RESLOCKED__";
	
}
