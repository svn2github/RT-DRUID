/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.ProvidedInterface;

import com.eu.evidence.rtdruid.vartree.variables.StringVar;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Provided Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ProvidedInterfaceImpl#getLocalMethodRef <em>Local Method Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ProvidedInterfaceImpl#getLocalObjectRef <em>Local Object Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ProvidedInterfaceImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProvidedInterfaceImpl extends ObjectWithIDImpl implements ProvidedInterface {
	/**
	 * The default value of the '{@link #getLocalMethodRef() <em>Local Method Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalMethodRef()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar LOCAL_METHOD_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocalMethodRef() <em>Local Method Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalMethodRef()
	 * @generated
	 * @ordered
	 */
	protected StringVar localMethodRef = LOCAL_METHOD_REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocalObjectRef() <em>Local Object Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalObjectRef()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar LOCAL_OBJECT_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocalObjectRef() <em>Local Object Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalObjectRef()
	 * @generated
	 * @ordered
	 */
	protected StringVar localObjectRef = LOCAL_OBJECT_REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected StringVar name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProvidedInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.PROVIDED_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getLocalMethodRef() {
		return localMethodRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalMethodRef(StringVar newLocalMethodRef) {
		StringVar oldLocalMethodRef = localMethodRef;
		localMethodRef = newLocalMethodRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.PROVIDED_INTERFACE__LOCAL_METHOD_REF, oldLocalMethodRef, localMethodRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getLocalObjectRef() {
		return localObjectRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalObjectRef(StringVar newLocalObjectRef) {
		StringVar oldLocalObjectRef = localObjectRef;
		localObjectRef = newLocalObjectRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.PROVIDED_INTERFACE__LOCAL_OBJECT_REF, oldLocalObjectRef, localObjectRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(StringVar newName) {
		StringVar oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.PROVIDED_INTERFACE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.PROVIDED_INTERFACE__LOCAL_METHOD_REF:
				return getLocalMethodRef();
			case DataPackage.PROVIDED_INTERFACE__LOCAL_OBJECT_REF:
				return getLocalObjectRef();
			case DataPackage.PROVIDED_INTERFACE__NAME:
				return getName();
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
			case DataPackage.PROVIDED_INTERFACE__LOCAL_METHOD_REF:
				setLocalMethodRef((StringVar)newValue);
				return;
			case DataPackage.PROVIDED_INTERFACE__LOCAL_OBJECT_REF:
				setLocalObjectRef((StringVar)newValue);
				return;
			case DataPackage.PROVIDED_INTERFACE__NAME:
				setName((StringVar)newValue);
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
			case DataPackage.PROVIDED_INTERFACE__LOCAL_METHOD_REF:
				setLocalMethodRef(LOCAL_METHOD_REF_EDEFAULT);
				return;
			case DataPackage.PROVIDED_INTERFACE__LOCAL_OBJECT_REF:
				setLocalObjectRef(LOCAL_OBJECT_REF_EDEFAULT);
				return;
			case DataPackage.PROVIDED_INTERFACE__NAME:
				setName(NAME_EDEFAULT);
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
			case DataPackage.PROVIDED_INTERFACE__LOCAL_METHOD_REF:
				return LOCAL_METHOD_REF_EDEFAULT == null ? localMethodRef != null : !LOCAL_METHOD_REF_EDEFAULT.equals(localMethodRef);
			case DataPackage.PROVIDED_INTERFACE__LOCAL_OBJECT_REF:
				return LOCAL_OBJECT_REF_EDEFAULT == null ? localObjectRef != null : !LOCAL_OBJECT_REF_EDEFAULT.equals(localObjectRef);
			case DataPackage.PROVIDED_INTERFACE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (LocalMethodRef: ");
		result.append(localMethodRef);
		result.append(", LocalObjectRef: ");
		result.append(localObjectRef);
		result.append(", Name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ProvidedInterfaceImpl
