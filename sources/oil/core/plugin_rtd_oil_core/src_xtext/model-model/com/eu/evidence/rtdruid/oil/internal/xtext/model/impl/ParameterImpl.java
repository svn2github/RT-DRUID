/**
 */
package com.eu.evidence.rtdruid.oil.internal.xtext.model.impl;

import com.eu.evidence.rtdruid.oil.xtext.model.OilPackage;
import com.eu.evidence.rtdruid.oil.xtext.model.Parameter;
import com.eu.evidence.rtdruid.oil.xtext.model.ParameterRef;
import com.eu.evidence.rtdruid.oil.xtext.model.ParameterType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ParameterImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ParameterImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ParameterImpl#isAuto <em>Auto</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ParameterImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ParameterImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ParameterImpl#getValueRef <em>Value Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterImpl extends EObjectImpl implements Parameter {
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ParameterType type;

	/**
	 * The default value of the '{@link #isAuto() <em>Auto</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAuto()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTO_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAuto() <em>Auto</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAuto()
	 * @generated
	 * @ordered
	 */
	protected boolean auto = AUTO_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * The cached value of the '{@link #getValueRef() <em>Value Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueRef()
	 * @generated
	 * @ordered
	 */
	protected ParameterRef valueRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OilPackage.Literals.PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilPackage.PARAMETER__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (ParameterType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OilPackage.PARAMETER__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ParameterType newType) {
		ParameterType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilPackage.PARAMETER__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAuto() {
		return auto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuto(boolean newAuto) {
		boolean oldAuto = auto;
		auto = newAuto;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilPackage.PARAMETER__AUTO, oldAuto, auto));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilPackage.PARAMETER__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, OilPackage.PARAMETER__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterRef getValueRef() {
		if (valueRef != null && valueRef.eIsProxy()) {
			InternalEObject oldValueRef = (InternalEObject)valueRef;
			valueRef = (ParameterRef)eResolveProxy(oldValueRef);
			if (valueRef != oldValueRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OilPackage.PARAMETER__VALUE_REF, oldValueRef, valueRef));
			}
		}
		return valueRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterRef basicGetValueRef() {
		return valueRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueRef(ParameterRef newValueRef) {
		ParameterRef oldValueRef = valueRef;
		valueRef = newValueRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilPackage.PARAMETER__VALUE_REF, oldValueRef, valueRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OilPackage.PARAMETER__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case OilPackage.PARAMETER__DESCRIPTION:
				return getDescription();
			case OilPackage.PARAMETER__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case OilPackage.PARAMETER__AUTO:
				return isAuto();
			case OilPackage.PARAMETER__VALUE:
				return getValue();
			case OilPackage.PARAMETER__PARAMETERS:
				return getParameters();
			case OilPackage.PARAMETER__VALUE_REF:
				if (resolve) return getValueRef();
				return basicGetValueRef();
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
			case OilPackage.PARAMETER__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case OilPackage.PARAMETER__TYPE:
				setType((ParameterType)newValue);
				return;
			case OilPackage.PARAMETER__AUTO:
				setAuto((Boolean)newValue);
				return;
			case OilPackage.PARAMETER__VALUE:
				setValue((String)newValue);
				return;
			case OilPackage.PARAMETER__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case OilPackage.PARAMETER__VALUE_REF:
				setValueRef((ParameterRef)newValue);
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
			case OilPackage.PARAMETER__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case OilPackage.PARAMETER__TYPE:
				setType((ParameterType)null);
				return;
			case OilPackage.PARAMETER__AUTO:
				setAuto(AUTO_EDEFAULT);
				return;
			case OilPackage.PARAMETER__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case OilPackage.PARAMETER__PARAMETERS:
				getParameters().clear();
				return;
			case OilPackage.PARAMETER__VALUE_REF:
				setValueRef((ParameterRef)null);
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
			case OilPackage.PARAMETER__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case OilPackage.PARAMETER__TYPE:
				return type != null;
			case OilPackage.PARAMETER__AUTO:
				return auto != AUTO_EDEFAULT;
			case OilPackage.PARAMETER__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case OilPackage.PARAMETER__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case OilPackage.PARAMETER__VALUE_REF:
				return valueRef != null;
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
		result.append(" (description: ");
		result.append(description);
		result.append(", auto: ");
		result.append(auto);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //ParameterImpl
