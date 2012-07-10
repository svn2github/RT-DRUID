/**
 */
package com.eu.evidence.rtdruid.oil.internal.xtext.model.impl;

import com.eu.evidence.rtdruid.oil.xtext.model.OilPackage;
import com.eu.evidence.rtdruid.oil.xtext.model.VType;
import com.eu.evidence.rtdruid.oil.xtext.model.ValidValues;
import com.eu.evidence.rtdruid.oil.xtext.model.ValueType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ValueTypeImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ValueTypeImpl#getValidValues <em>Valid Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueTypeImpl extends ParameterTypeImpl implements ValueType {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final VType TYPE_EDEFAULT = VType.STRING;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected VType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValidValues() <em>Valid Values</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidValues()
	 * @generated
	 * @ordered
	 */
	protected ValidValues validValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OilPackage.Literals.VALUE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(VType newType) {
		VType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilPackage.VALUE_TYPE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidValues getValidValues() {
		return validValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValidValues(ValidValues newValidValues, NotificationChain msgs) {
		ValidValues oldValidValues = validValues;
		validValues = newValidValues;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OilPackage.VALUE_TYPE__VALID_VALUES, oldValidValues, newValidValues);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidValues(ValidValues newValidValues) {
		if (newValidValues != validValues) {
			NotificationChain msgs = null;
			if (validValues != null)
				msgs = ((InternalEObject)validValues).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OilPackage.VALUE_TYPE__VALID_VALUES, null, msgs);
			if (newValidValues != null)
				msgs = ((InternalEObject)newValidValues).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OilPackage.VALUE_TYPE__VALID_VALUES, null, msgs);
			msgs = basicSetValidValues(newValidValues, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilPackage.VALUE_TYPE__VALID_VALUES, newValidValues, newValidValues));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OilPackage.VALUE_TYPE__VALID_VALUES:
				return basicSetValidValues(null, msgs);
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
			case OilPackage.VALUE_TYPE__TYPE:
				return getType();
			case OilPackage.VALUE_TYPE__VALID_VALUES:
				return getValidValues();
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
			case OilPackage.VALUE_TYPE__TYPE:
				setType((VType)newValue);
				return;
			case OilPackage.VALUE_TYPE__VALID_VALUES:
				setValidValues((ValidValues)newValue);
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
			case OilPackage.VALUE_TYPE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case OilPackage.VALUE_TYPE__VALID_VALUES:
				setValidValues((ValidValues)null);
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
			case OilPackage.VALUE_TYPE__TYPE:
				return type != TYPE_EDEFAULT;
			case OilPackage.VALUE_TYPE__VALID_VALUES:
				return validValues != null;
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
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //ValueTypeImpl
