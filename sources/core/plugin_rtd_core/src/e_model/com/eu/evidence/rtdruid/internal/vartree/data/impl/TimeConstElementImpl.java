/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.TimeConstElement;

import com.eu.evidence.rtdruid.vartree.variables.StringVar;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Const Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TimeConstElementImpl#getBoundType <em>Bound Type</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TimeConstElementImpl#getBoundValue <em>Bound Value</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TimeConstElementImpl#getFirstEvent <em>First Event</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TimeConstElementImpl#getSecondEvent <em>Second Event</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimeConstElementImpl extends ObjectWithIDImpl implements TimeConstElement {
	/**
	 * The default value of the '{@link #getBoundType() <em>Bound Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundType()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar BOUND_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBoundType() <em>Bound Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundType()
	 * @generated
	 * @ordered
	 */
	protected StringVar boundType = BOUND_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBoundValue() <em>Bound Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundValue()
	 * @generated
	 * @ordered
	 */
	protected static final TimeVar BOUND_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBoundValue() <em>Bound Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundValue()
	 * @generated
	 * @ordered
	 */
	protected TimeVar boundValue = BOUND_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFirstEvent() <em>First Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstEvent()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar FIRST_EVENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFirstEvent() <em>First Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstEvent()
	 * @generated
	 * @ordered
	 */
	protected StringVar firstEvent = FIRST_EVENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecondEvent() <em>Second Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondEvent()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar SECOND_EVENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSecondEvent() <em>Second Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondEvent()
	 * @generated
	 * @ordered
	 */
	protected StringVar secondEvent = SECOND_EVENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeConstElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.TIME_CONST_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getBoundType() {
		return boundType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundType(StringVar newBoundType) {
		StringVar oldBoundType = boundType;
		boundType = newBoundType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TIME_CONST_ELEMENT__BOUND_TYPE, oldBoundType, boundType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeVar getBoundValue() {
		return boundValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundValue(TimeVar newBoundValue) {
		TimeVar oldBoundValue = boundValue;
		boundValue = newBoundValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TIME_CONST_ELEMENT__BOUND_VALUE, oldBoundValue, boundValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getFirstEvent() {
		return firstEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstEvent(StringVar newFirstEvent) {
		StringVar oldFirstEvent = firstEvent;
		firstEvent = newFirstEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TIME_CONST_ELEMENT__FIRST_EVENT, oldFirstEvent, firstEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getSecondEvent() {
		return secondEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondEvent(StringVar newSecondEvent) {
		StringVar oldSecondEvent = secondEvent;
		secondEvent = newSecondEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TIME_CONST_ELEMENT__SECOND_EVENT, oldSecondEvent, secondEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.TIME_CONST_ELEMENT__BOUND_TYPE:
				return getBoundType();
			case DataPackage.TIME_CONST_ELEMENT__BOUND_VALUE:
				return getBoundValue();
			case DataPackage.TIME_CONST_ELEMENT__FIRST_EVENT:
				return getFirstEvent();
			case DataPackage.TIME_CONST_ELEMENT__SECOND_EVENT:
				return getSecondEvent();
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
			case DataPackage.TIME_CONST_ELEMENT__BOUND_TYPE:
				setBoundType((StringVar)newValue);
				return;
			case DataPackage.TIME_CONST_ELEMENT__BOUND_VALUE:
				setBoundValue((TimeVar)newValue);
				return;
			case DataPackage.TIME_CONST_ELEMENT__FIRST_EVENT:
				setFirstEvent((StringVar)newValue);
				return;
			case DataPackage.TIME_CONST_ELEMENT__SECOND_EVENT:
				setSecondEvent((StringVar)newValue);
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
			case DataPackage.TIME_CONST_ELEMENT__BOUND_TYPE:
				setBoundType(BOUND_TYPE_EDEFAULT);
				return;
			case DataPackage.TIME_CONST_ELEMENT__BOUND_VALUE:
				setBoundValue(BOUND_VALUE_EDEFAULT);
				return;
			case DataPackage.TIME_CONST_ELEMENT__FIRST_EVENT:
				setFirstEvent(FIRST_EVENT_EDEFAULT);
				return;
			case DataPackage.TIME_CONST_ELEMENT__SECOND_EVENT:
				setSecondEvent(SECOND_EVENT_EDEFAULT);
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
			case DataPackage.TIME_CONST_ELEMENT__BOUND_TYPE:
				return BOUND_TYPE_EDEFAULT == null ? boundType != null : !BOUND_TYPE_EDEFAULT.equals(boundType);
			case DataPackage.TIME_CONST_ELEMENT__BOUND_VALUE:
				return BOUND_VALUE_EDEFAULT == null ? boundValue != null : !BOUND_VALUE_EDEFAULT.equals(boundValue);
			case DataPackage.TIME_CONST_ELEMENT__FIRST_EVENT:
				return FIRST_EVENT_EDEFAULT == null ? firstEvent != null : !FIRST_EVENT_EDEFAULT.equals(firstEvent);
			case DataPackage.TIME_CONST_ELEMENT__SECOND_EVENT:
				return SECOND_EVENT_EDEFAULT == null ? secondEvent != null : !SECOND_EVENT_EDEFAULT.equals(secondEvent);
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
		result.append(" (BoundType: ");
		result.append(boundType);
		result.append(", BoundValue: ");
		result.append(boundValue);
		result.append(", FirstEvent: ");
		result.append(firstEvent);
		result.append(", SecondEvent: ");
		result.append(secondEvent);
		result.append(')');
		return result.toString();
	}

} //TimeConstElementImpl
