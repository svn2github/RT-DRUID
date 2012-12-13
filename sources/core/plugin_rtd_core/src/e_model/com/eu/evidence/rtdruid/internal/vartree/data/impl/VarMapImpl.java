/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.VarMap;

import com.eu.evidence.rtdruid.vartree.variables.StringVar;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Var Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.VarMapImpl#getBusRef <em>Bus Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.VarMapImpl#getFrameRef <em>Frame Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.VarMapImpl#getModeRef <em>Mode Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.VarMapImpl#getMutexRef <em>Mutex Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.VarMapImpl#getVarRef <em>Var Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VarMapImpl extends ObjectWithIDImpl implements VarMap {
	/**
	 * The default value of the '{@link #getBusRef() <em>Bus Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusRef()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar BUS_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBusRef() <em>Bus Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusRef()
	 * @generated
	 * @ordered
	 */
	protected StringVar busRef = BUS_REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getFrameRef() <em>Frame Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameRef()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar FRAME_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFrameRef() <em>Frame Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameRef()
	 * @generated
	 * @ordered
	 */
	protected StringVar frameRef = FRAME_REF_EDEFAULT;

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
	 * The default value of the '{@link #getMutexRef() <em>Mutex Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMutexRef()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar MUTEX_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMutexRef() <em>Mutex Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMutexRef()
	 * @generated
	 * @ordered
	 */
	protected StringVar mutexRef = MUTEX_REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getVarRef() <em>Var Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarRef()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar VAR_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVarRef() <em>Var Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarRef()
	 * @generated
	 * @ordered
	 */
	protected StringVar varRef = VAR_REF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VarMapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.VAR_MAP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getBusRef() {
		return busRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBusRef(StringVar newBusRef) {
		StringVar oldBusRef = busRef;
		busRef = newBusRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.VAR_MAP__BUS_REF, oldBusRef, busRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getFrameRef() {
		return frameRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrameRef(StringVar newFrameRef) {
		StringVar oldFrameRef = frameRef;
		frameRef = newFrameRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.VAR_MAP__FRAME_REF, oldFrameRef, frameRef));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.VAR_MAP__MODE_REF, oldModeRef, modeRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getMutexRef() {
		return mutexRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMutexRef(StringVar newMutexRef) {
		StringVar oldMutexRef = mutexRef;
		mutexRef = newMutexRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.VAR_MAP__MUTEX_REF, oldMutexRef, mutexRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getVarRef() {
		return varRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarRef(StringVar newVarRef) {
		StringVar oldVarRef = varRef;
		varRef = newVarRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.VAR_MAP__VAR_REF, oldVarRef, varRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.VAR_MAP__BUS_REF:
				return getBusRef();
			case DataPackage.VAR_MAP__FRAME_REF:
				return getFrameRef();
			case DataPackage.VAR_MAP__MODE_REF:
				return getModeRef();
			case DataPackage.VAR_MAP__MUTEX_REF:
				return getMutexRef();
			case DataPackage.VAR_MAP__VAR_REF:
				return getVarRef();
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
			case DataPackage.VAR_MAP__BUS_REF:
				setBusRef((StringVar)newValue);
				return;
			case DataPackage.VAR_MAP__FRAME_REF:
				setFrameRef((StringVar)newValue);
				return;
			case DataPackage.VAR_MAP__MODE_REF:
				setModeRef((StringVar)newValue);
				return;
			case DataPackage.VAR_MAP__MUTEX_REF:
				setMutexRef((StringVar)newValue);
				return;
			case DataPackage.VAR_MAP__VAR_REF:
				setVarRef((StringVar)newValue);
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
			case DataPackage.VAR_MAP__BUS_REF:
				setBusRef(BUS_REF_EDEFAULT);
				return;
			case DataPackage.VAR_MAP__FRAME_REF:
				setFrameRef(FRAME_REF_EDEFAULT);
				return;
			case DataPackage.VAR_MAP__MODE_REF:
				setModeRef(MODE_REF_EDEFAULT);
				return;
			case DataPackage.VAR_MAP__MUTEX_REF:
				setMutexRef(MUTEX_REF_EDEFAULT);
				return;
			case DataPackage.VAR_MAP__VAR_REF:
				setVarRef(VAR_REF_EDEFAULT);
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
			case DataPackage.VAR_MAP__BUS_REF:
				return BUS_REF_EDEFAULT == null ? busRef != null : !BUS_REF_EDEFAULT.equals(busRef);
			case DataPackage.VAR_MAP__FRAME_REF:
				return FRAME_REF_EDEFAULT == null ? frameRef != null : !FRAME_REF_EDEFAULT.equals(frameRef);
			case DataPackage.VAR_MAP__MODE_REF:
				return MODE_REF_EDEFAULT == null ? modeRef != null : !MODE_REF_EDEFAULT.equals(modeRef);
			case DataPackage.VAR_MAP__MUTEX_REF:
				return MUTEX_REF_EDEFAULT == null ? mutexRef != null : !MUTEX_REF_EDEFAULT.equals(mutexRef);
			case DataPackage.VAR_MAP__VAR_REF:
				return VAR_REF_EDEFAULT == null ? varRef != null : !VAR_REF_EDEFAULT.equals(varRef);
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
		result.append(" (BusRef: ");
		result.append(busRef);
		result.append(", FrameRef: ");
		result.append(frameRef);
		result.append(", ModeRef: ");
		result.append(modeRef);
		result.append(", MutexRef: ");
		result.append(mutexRef);
		result.append(", VarRef: ");
		result.append(varRef);
		result.append(')');
		return result.toString();
	}

} //VarMapImpl
