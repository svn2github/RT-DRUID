/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.TaskMap;

import com.eu.evidence.rtdruid.vartree.variables.StringVar;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskMapImpl#getModeRef <em>Mode Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskMapImpl#getRtosRef <em>Rtos Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskMapImpl#getTaskRef <em>Task Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskMapImpl extends ObjectWithIDImpl implements TaskMap {
	/**
	 * The default value of the '{@link #getModeRef() <em>Mode Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModeRef()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar MODE_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModeRef() <em>Mode Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModeRef()
	 * @generated
	 * @ordered
	 */
	protected StringVar modeRef = MODE_REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getRtosRef() <em>Rtos Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRtosRef()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar RTOS_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRtosRef() <em>Rtos Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRtosRef()
	 * @generated
	 * @ordered
	 */
	protected StringVar rtosRef = RTOS_REF_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskMapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.TASK_MAP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getModeRef() {
		return modeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModeRef(StringVar newModeRef) {
		StringVar oldModeRef = modeRef;
		modeRef = newModeRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TASK_MAP__MODE_REF, oldModeRef, modeRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getRtosRef() {
		return rtosRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRtosRef(StringVar newRtosRef) {
		StringVar oldRtosRef = rtosRef;
		rtosRef = newRtosRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TASK_MAP__RTOS_REF, oldRtosRef, rtosRef));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TASK_MAP__TASK_REF, oldTaskRef, taskRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.TASK_MAP__MODE_REF:
				return getModeRef();
			case DataPackage.TASK_MAP__RTOS_REF:
				return getRtosRef();
			case DataPackage.TASK_MAP__TASK_REF:
				return getTaskRef();
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
			case DataPackage.TASK_MAP__MODE_REF:
				setModeRef((StringVar)newValue);
				return;
			case DataPackage.TASK_MAP__RTOS_REF:
				setRtosRef((StringVar)newValue);
				return;
			case DataPackage.TASK_MAP__TASK_REF:
				setTaskRef((StringVar)newValue);
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
			case DataPackage.TASK_MAP__MODE_REF:
				setModeRef(MODE_REF_EDEFAULT);
				return;
			case DataPackage.TASK_MAP__RTOS_REF:
				setRtosRef(RTOS_REF_EDEFAULT);
				return;
			case DataPackage.TASK_MAP__TASK_REF:
				setTaskRef(TASK_REF_EDEFAULT);
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
			case DataPackage.TASK_MAP__MODE_REF:
				return MODE_REF_EDEFAULT == null ? modeRef != null : !MODE_REF_EDEFAULT.equals(modeRef);
			case DataPackage.TASK_MAP__RTOS_REF:
				return RTOS_REF_EDEFAULT == null ? rtosRef != null : !RTOS_REF_EDEFAULT.equals(rtosRef);
			case DataPackage.TASK_MAP__TASK_REF:
				return TASK_REF_EDEFAULT == null ? taskRef != null : !TASK_REF_EDEFAULT.equals(taskRef);
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
		result.append(" (ModeRef: ");
		result.append(modeRef);
		result.append(", RtosRef: ");
		result.append(rtosRef);
		result.append(", TaskRef: ");
		result.append(taskRef);
		result.append(')');
		return result.toString();
	}

} //TaskMapImpl
