/**
 */
package com.eu.evidence.rtdruid.oil.internal.xtext.model.impl;

import com.eu.evidence.rtdruid.oil.xtext.model.OilPackage;
import com.eu.evidence.rtdruid.oil.xtext.model.ParameterType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ParameterTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ParameterTypeImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ParameterTypeImpl#isMultiValue <em>Multi Value</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ParameterTypeImpl#isWithAuto <em>With Auto</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ParameterTypeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ParameterTypeImpl#isDefaultAuto <em>Default Auto</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ParameterTypeImpl extends EObjectImpl implements ParameterType {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected String defaultValue = DEFAULT_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #isMultiValue() <em>Multi Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiValue()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MULTI_VALUE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMultiValue() <em>Multi Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiValue()
	 * @generated
	 * @ordered
	 */
	protected boolean multiValue = MULTI_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #isWithAuto() <em>With Auto</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWithAuto()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WITH_AUTO_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isWithAuto() <em>With Auto</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWithAuto()
	 * @generated
	 * @ordered
	 */
	protected boolean withAuto = WITH_AUTO_EDEFAULT;

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
	 * The default value of the '{@link #isDefaultAuto() <em>Default Auto</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefaultAuto()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEFAULT_AUTO_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDefaultAuto() <em>Default Auto</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefaultAuto()
	 * @generated
	 * @ordered
	 */
	protected boolean defaultAuto = DEFAULT_AUTO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OilPackage.Literals.PARAMETER_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilPackage.PARAMETER_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultValue(String newDefaultValue) {
		String oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilPackage.PARAMETER_TYPE__DEFAULT_VALUE, oldDefaultValue, defaultValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMultiValue() {
		return multiValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiValue(boolean newMultiValue) {
		boolean oldMultiValue = multiValue;
		multiValue = newMultiValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilPackage.PARAMETER_TYPE__MULTI_VALUE, oldMultiValue, multiValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isWithAuto() {
		return withAuto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWithAuto(boolean newWithAuto) {
		boolean oldWithAuto = withAuto;
		withAuto = newWithAuto;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilPackage.PARAMETER_TYPE__WITH_AUTO, oldWithAuto, withAuto));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OilPackage.PARAMETER_TYPE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDefaultAuto() {
		return defaultAuto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultAuto(boolean newDefaultAuto) {
		boolean oldDefaultAuto = defaultAuto;
		defaultAuto = newDefaultAuto;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilPackage.PARAMETER_TYPE__DEFAULT_AUTO, oldDefaultAuto, defaultAuto));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OilPackage.PARAMETER_TYPE__NAME:
				return getName();
			case OilPackage.PARAMETER_TYPE__DEFAULT_VALUE:
				return getDefaultValue();
			case OilPackage.PARAMETER_TYPE__MULTI_VALUE:
				return isMultiValue();
			case OilPackage.PARAMETER_TYPE__WITH_AUTO:
				return isWithAuto();
			case OilPackage.PARAMETER_TYPE__DESCRIPTION:
				return getDescription();
			case OilPackage.PARAMETER_TYPE__DEFAULT_AUTO:
				return isDefaultAuto();
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
			case OilPackage.PARAMETER_TYPE__NAME:
				setName((String)newValue);
				return;
			case OilPackage.PARAMETER_TYPE__DEFAULT_VALUE:
				setDefaultValue((String)newValue);
				return;
			case OilPackage.PARAMETER_TYPE__MULTI_VALUE:
				setMultiValue((Boolean)newValue);
				return;
			case OilPackage.PARAMETER_TYPE__WITH_AUTO:
				setWithAuto((Boolean)newValue);
				return;
			case OilPackage.PARAMETER_TYPE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case OilPackage.PARAMETER_TYPE__DEFAULT_AUTO:
				setDefaultAuto((Boolean)newValue);
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
			case OilPackage.PARAMETER_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OilPackage.PARAMETER_TYPE__DEFAULT_VALUE:
				setDefaultValue(DEFAULT_VALUE_EDEFAULT);
				return;
			case OilPackage.PARAMETER_TYPE__MULTI_VALUE:
				setMultiValue(MULTI_VALUE_EDEFAULT);
				return;
			case OilPackage.PARAMETER_TYPE__WITH_AUTO:
				setWithAuto(WITH_AUTO_EDEFAULT);
				return;
			case OilPackage.PARAMETER_TYPE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case OilPackage.PARAMETER_TYPE__DEFAULT_AUTO:
				setDefaultAuto(DEFAULT_AUTO_EDEFAULT);
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
			case OilPackage.PARAMETER_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OilPackage.PARAMETER_TYPE__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? defaultValue != null : !DEFAULT_VALUE_EDEFAULT.equals(defaultValue);
			case OilPackage.PARAMETER_TYPE__MULTI_VALUE:
				return multiValue != MULTI_VALUE_EDEFAULT;
			case OilPackage.PARAMETER_TYPE__WITH_AUTO:
				return withAuto != WITH_AUTO_EDEFAULT;
			case OilPackage.PARAMETER_TYPE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case OilPackage.PARAMETER_TYPE__DEFAULT_AUTO:
				return defaultAuto != DEFAULT_AUTO_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", defaultValue: ");
		result.append(defaultValue);
		result.append(", multiValue: ");
		result.append(multiValue);
		result.append(", withAuto: ");
		result.append(withAuto);
		result.append(", description: ");
		result.append(description);
		result.append(", defaultAuto: ");
		result.append(defaultAuto);
		result.append(')');
		return result.toString();
	}

} //ParameterTypeImpl
