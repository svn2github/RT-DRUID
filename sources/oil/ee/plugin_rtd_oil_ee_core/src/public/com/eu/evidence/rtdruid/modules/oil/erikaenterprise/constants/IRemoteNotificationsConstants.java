/**
 * Created on 12/ott/2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants;

/**
 * @author Nicola Serreli
 *
 */
public interface IRemoteNotificationsConstants {

	// - RN
	/** Enable remote notifications (only general methods) */
	public final static String DEF__RN__ = "__RN__";
	/** Enable TASK remote notifications  */
	public final static String DEF__RN_TASK__ = "__RN_TASK__";
	/** Enable EVENT remote notifications  */
	public final static String DEF__RN_EVENT__ = "__RN_EVENT__";
	/** Enable COUNTER remote notifications  */
	public final static String DEF__RN_COUNTER__ = "__RN_COUNTER__";
	/** Enable FUNC remote notifications  */
	public final static String DEF__RN_FUNC__ = "__RN_FUNC__";
	/** Enable SEM remote notifications  */
	public final static String DEF__RN_SEM__ = "__RN_SEM__";

	// - ENABLED or NOT
	
	/** Enable remote notifications (only general methods) (bit set)*/
	public final static String DEF__RN_BITS__ = "__RN_BIT_SET_";
	/** Enable TASK remote notifications  (bit)*/
	public final static int DEF__RN_TASK_BIT__ = 0;
	/** Enable EVENT remote notifications  (bit)*/
	public final static int DEF__RN_EVENT_BIT__ = 1;
	/** Enable COUNTER remote notifications  (bit)*/
	public final static int DEF__RN_COUNTER_BIT__ = 2;
	/** Enable FUNC remote notifications  (bit)*/
	public final static int DEF__RN_FUNC_BIT__ = 3;
	/** Enable SEM remote notifications  (bit)*/
	public final static int DEF__RN_SEM_BIT__ = 4;
	
	
	
	/** The name of spin-lock status array */
	public final static String SPINLOCK_STATUS_ARRAY = "EE_hal_spinlock_status";
	/** The base name of spin-lock value arrays (one for each core) */
	public final static String SPINLOCK_BASE_NAME = "EE_hal_spinlock_value_";
	/** The name of spin-lock value array (The collector one) */
	public final static String SPINLOCK_VALUE_ARRAY = "EE_hal_spinlock_value";

}
