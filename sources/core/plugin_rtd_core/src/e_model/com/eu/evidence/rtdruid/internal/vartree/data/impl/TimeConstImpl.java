/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.TimeConst;
import com.eu.evidence.rtdruid.vartree.data.TimeConstElement;

import com.eu.evidence.rtdruid.vartree.variables.StringVar;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Const</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TimeConstImpl#getModeRef <em>Mode Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TimeConstImpl#getTimeConstElementList <em>Time Const Element List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimeConstImpl extends ObjectWithIDImpl implements TimeConst {
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
	 * The cached value of the '{@link #getTimeConstElementList() <em>Time Const Element List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeConstElementList()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeConstElement> timeConstElementList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeConstImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.TIME_CONST;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TIME_CONST__MODE_REF, oldModeRef, modeRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TimeConstElement> getTimeConstElementList() {
		if (timeConstElementList == null) {
			timeConstElementList = new EObjectContainmentEList<TimeConstElement>(TimeConstElement.class, this, DataPackage.TIME_CONST__TIME_CONST_ELEMENT_LIST);
		}
		return timeConstElementList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataPackage.TIME_CONST__TIME_CONST_ELEMENT_LIST:
				return ((InternalEList<?>)getTimeConstElementList()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.TIME_CONST__MODE_REF:
				return getModeRef();
			case DataPackage.TIME_CONST__TIME_CONST_ELEMENT_LIST:
				return getTimeConstElementList();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DataPackage.TIME_CONST__MODE_REF:
				setModeRef((StringVar)newValue);
				return;
			case DataPackage.TIME_CONST__TIME_CONST_ELEMENT_LIST:
				getTimeConstElementList().clear();
				getTimeConstElementList().addAll((Collection<? extends TimeConstElement>)newValue);
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
			case DataPackage.TIME_CONST__MODE_REF:
				setModeRef(MODE_REF_EDEFAULT);
				return;
			case DataPackage.TIME_CONST__TIME_CONST_ELEMENT_LIST:
				getTimeConstElementList().clear();
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
			case DataPackage.TIME_CONST__MODE_REF:
				return MODE_REF_EDEFAULT == null ? modeRef != null : !MODE_REF_EDEFAULT.equals(modeRef);
			case DataPackage.TIME_CONST__TIME_CONST_ELEMENT_LIST:
				return timeConstElementList != null && !timeConstElementList.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //TimeConstImpl
