/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.Order;

import com.eu.evidence.rtdruid.vartree.variables.StringVar;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Order</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.OrderImpl#getFirstEvent <em>First Event</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.OrderImpl#getSecondEvent <em>Second Event</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrderImpl extends ObjectWithIDImpl implements Order {
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
	protected OrderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.ORDER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ORDER__FIRST_EVENT, oldFirstEvent, firstEvent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ORDER__SECOND_EVENT, oldSecondEvent, secondEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.ORDER__FIRST_EVENT:
				return getFirstEvent();
			case DataPackage.ORDER__SECOND_EVENT:
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
			case DataPackage.ORDER__FIRST_EVENT:
				setFirstEvent((StringVar)newValue);
				return;
			case DataPackage.ORDER__SECOND_EVENT:
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
			case DataPackage.ORDER__FIRST_EVENT:
				setFirstEvent(FIRST_EVENT_EDEFAULT);
				return;
			case DataPackage.ORDER__SECOND_EVENT:
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
			case DataPackage.ORDER__FIRST_EVENT:
				return FIRST_EVENT_EDEFAULT == null ? firstEvent != null : !FIRST_EVENT_EDEFAULT.equals(firstEvent);
			case DataPackage.ORDER__SECOND_EVENT:
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
		result.append(" (FirstEvent: ");
		result.append(firstEvent);
		result.append(", SecondEvent: ");
		result.append(secondEvent);
		result.append(')');
		return result.toString();
	}

} //OrderImpl
