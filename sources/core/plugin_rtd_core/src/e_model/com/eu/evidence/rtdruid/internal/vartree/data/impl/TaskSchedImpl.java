/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.TaskSched;

import com.eu.evidence.rtdruid.vartree.variables.BooleanVar;
import com.eu.evidence.rtdruid.vartree.variables.DoubleVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Sched</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskSchedImpl#getCDelta <em>CDelta</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskSchedImpl#getResponseTime <em>Response Time</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskSchedImpl#getSchedulable <em>Schedulable</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskSchedImpl#getTaskRef <em>Task Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskSchedImpl#getTDelta <em>TDelta</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskSchedImpl#getUtilization <em>Utilization</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskSchedImpl extends ObjectWithIDImpl implements TaskSched {
	/**
	 * The default value of the '{@link #getCDelta() <em>CDelta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCDelta()
	 * @generated
	 * @ordered
	 */
	protected static final DoubleVar CDELTA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCDelta() <em>CDelta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCDelta()
	 * @generated
	 * @ordered
	 */
	protected DoubleVar cDelta = CDELTA_EDEFAULT;

	/**
	 * The default value of the '{@link #getResponseTime() <em>Response Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponseTime()
	 * @generated
	 * @ordered
	 */
	protected static final TimeVar RESPONSE_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResponseTime() <em>Response Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponseTime()
	 * @generated
	 * @ordered
	 */
	protected TimeVar responseTime = RESPONSE_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchedulable() <em>Schedulable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulable()
	 * @generated
	 * @ordered
	 */
	protected static final BooleanVar SCHEDULABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSchedulable() <em>Schedulable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulable()
	 * @generated
	 * @ordered
	 */
	protected BooleanVar schedulable = SCHEDULABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTaskRef() <em>Task Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskRef()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar TASK_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTaskRef() <em>Task Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskRef()
	 * @generated
	 * @ordered
	 */
	protected StringVar taskRef = TASK_REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getTDelta() <em>TDelta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTDelta()
	 * @generated
	 * @ordered
	 */
	protected static final DoubleVar TDELTA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTDelta() <em>TDelta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTDelta()
	 * @generated
	 * @ordered
	 */
	protected DoubleVar tDelta = TDELTA_EDEFAULT;

	/**
	 * The default value of the '{@link #getUtilization() <em>Utilization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilization()
	 * @generated
	 * @ordered
	 */
	protected static final DoubleVar UTILIZATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUtilization() <em>Utilization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilization()
	 * @generated
	 * @ordered
	 */
	protected DoubleVar utilization = UTILIZATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskSchedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.TASK_SCHED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleVar getCDelta() {
		return cDelta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCDelta(DoubleVar newCDelta) {
		DoubleVar oldCDelta = cDelta;
		cDelta = newCDelta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TASK_SCHED__CDELTA, oldCDelta, cDelta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeVar getResponseTime() {
		return responseTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponseTime(TimeVar newResponseTime) {
		TimeVar oldResponseTime = responseTime;
		responseTime = newResponseTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TASK_SCHED__RESPONSE_TIME, oldResponseTime, responseTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanVar getSchedulable() {
		return schedulable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedulable(BooleanVar newSchedulable) {
		BooleanVar oldSchedulable = schedulable;
		schedulable = newSchedulable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TASK_SCHED__SCHEDULABLE, oldSchedulable, schedulable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getTaskRef() {
		return taskRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskRef(StringVar newTaskRef) {
		StringVar oldTaskRef = taskRef;
		taskRef = newTaskRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TASK_SCHED__TASK_REF, oldTaskRef, taskRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleVar getTDelta() {
		return tDelta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTDelta(DoubleVar newTDelta) {
		DoubleVar oldTDelta = tDelta;
		tDelta = newTDelta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TASK_SCHED__TDELTA, oldTDelta, tDelta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleVar getUtilization() {
		return utilization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtilization(DoubleVar newUtilization) {
		DoubleVar oldUtilization = utilization;
		utilization = newUtilization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TASK_SCHED__UTILIZATION, oldUtilization, utilization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.TASK_SCHED__CDELTA:
				return getCDelta();
			case DataPackage.TASK_SCHED__RESPONSE_TIME:
				return getResponseTime();
			case DataPackage.TASK_SCHED__SCHEDULABLE:
				return getSchedulable();
			case DataPackage.TASK_SCHED__TASK_REF:
				return getTaskRef();
			case DataPackage.TASK_SCHED__TDELTA:
				return getTDelta();
			case DataPackage.TASK_SCHED__UTILIZATION:
				return getUtilization();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DataPackage.TASK_SCHED__CDELTA:
				setCDelta((DoubleVar)newValue);
				return;
			case DataPackage.TASK_SCHED__RESPONSE_TIME:
				setResponseTime((TimeVar)newValue);
				return;
			case DataPackage.TASK_SCHED__SCHEDULABLE:
				setSchedulable((BooleanVar)newValue);
				return;
			case DataPackage.TASK_SCHED__TASK_REF:
				setTaskRef((StringVar)newValue);
				return;
			case DataPackage.TASK_SCHED__TDELTA:
				setTDelta((DoubleVar)newValue);
				return;
			case DataPackage.TASK_SCHED__UTILIZATION:
				setUtilization((DoubleVar)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DataPackage.TASK_SCHED__CDELTA:
				setCDelta(CDELTA_EDEFAULT);
				return;
			case DataPackage.TASK_SCHED__RESPONSE_TIME:
				setResponseTime(RESPONSE_TIME_EDEFAULT);
				return;
			case DataPackage.TASK_SCHED__SCHEDULABLE:
				setSchedulable(SCHEDULABLE_EDEFAULT);
				return;
			case DataPackage.TASK_SCHED__TASK_REF:
				setTaskRef(TASK_REF_EDEFAULT);
				return;
			case DataPackage.TASK_SCHED__TDELTA:
				setTDelta(TDELTA_EDEFAULT);
				return;
			case DataPackage.TASK_SCHED__UTILIZATION:
				setUtilization(UTILIZATION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DataPackage.TASK_SCHED__CDELTA:
				return CDELTA_EDEFAULT == null ? cDelta != null : !CDELTA_EDEFAULT.equals(cDelta);
			case DataPackage.TASK_SCHED__RESPONSE_TIME:
				return RESPONSE_TIME_EDEFAULT == null ? responseTime != null : !RESPONSE_TIME_EDEFAULT.equals(responseTime);
			case DataPackage.TASK_SCHED__SCHEDULABLE:
				return SCHEDULABLE_EDEFAULT == null ? schedulable != null : !SCHEDULABLE_EDEFAULT.equals(schedulable);
			case DataPackage.TASK_SCHED__TASK_REF:
				return TASK_REF_EDEFAULT == null ? taskRef != null : !TASK_REF_EDEFAULT.equals(taskRef);
			case DataPackage.TASK_SCHED__TDELTA:
				return TDELTA_EDEFAULT == null ? tDelta != null : !TDELTA_EDEFAULT.equals(tDelta);
			case DataPackage.TASK_SCHED__UTILIZATION:
				return UTILIZATION_EDEFAULT == null ? utilization != null : !UTILIZATION_EDEFAULT.equals(utilization);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (CDelta: ");
		result.append(cDelta);
		result.append(", ResponseTime: ");
		result.append(responseTime);
		result.append(", Schedulable: ");
		result.append(schedulable);
		result.append(", TaskRef: ");
		result.append(taskRef);
		result.append(", TDelta: ");
		result.append(tDelta);
		result.append(", Utilization: ");
		result.append(utilization);
		result.append(')');
		return result.toString();
	}

} //TaskSchedImpl
