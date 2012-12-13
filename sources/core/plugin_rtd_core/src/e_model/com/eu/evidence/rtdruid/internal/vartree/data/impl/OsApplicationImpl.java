/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.OsApplication;

import com.eu.evidence.rtdruid.vartree.variables.OilVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Os Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.OsApplicationImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.OsApplicationImpl#getOilVar <em>Oil Var</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OsApplicationImpl extends ObjectWithIDImpl implements OsApplication {
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
	 * The default value of the '{@link #getOilVar() <em>Oil Var</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOilVar()
	 * @generated
	 * @ordered
	 */
	protected static final OilVar OIL_VAR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOilVar() <em>Oil Var</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOilVar()
	 * @generated
	 * @ordered
	 */
	protected OilVar oilVar = OIL_VAR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OsApplicationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.OS_APPLICATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.OS_APPLICATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OilVar getOilVar() {
		return oilVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOilVar(OilVar newOilVar) {
		OilVar oldOilVar = oilVar;
		oilVar = newOilVar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.OS_APPLICATION__OIL_VAR, oldOilVar, oilVar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.OS_APPLICATION__NAME:
				return getName();
			case DataPackage.OS_APPLICATION__OIL_VAR:
				return getOilVar();
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
			case DataPackage.OS_APPLICATION__NAME:
				setName((StringVar)newValue);
				return;
			case DataPackage.OS_APPLICATION__OIL_VAR:
				setOilVar((OilVar)newValue);
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
			case DataPackage.OS_APPLICATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DataPackage.OS_APPLICATION__OIL_VAR:
				setOilVar(OIL_VAR_EDEFAULT);
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
			case DataPackage.OS_APPLICATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DataPackage.OS_APPLICATION__OIL_VAR:
				return OIL_VAR_EDEFAULT == null ? oilVar != null : !OIL_VAR_EDEFAULT.equals(oilVar);
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
		result.append(" (Name: ");
		result.append(name);
		result.append(", OilVar: ");
		result.append(oilVar);
		result.append(')');
		return result.toString();
	}

} //OsApplicationImpl
