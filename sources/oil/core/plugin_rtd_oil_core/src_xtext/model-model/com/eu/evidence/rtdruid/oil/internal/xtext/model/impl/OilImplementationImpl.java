/**
 */
package com.eu.evidence.rtdruid.oil.internal.xtext.model.impl;

import com.eu.evidence.rtdruid.oil.xtext.model.OilImplementation;
import com.eu.evidence.rtdruid.oil.xtext.model.OilObjectImpl;
import com.eu.evidence.rtdruid.oil.xtext.model.OilPackage;

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
 * An implementation of the model object '<em><b>Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilImplementationImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilImplementationImpl#getOilObjects <em>Oil Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OilImplementationImpl extends EObjectImpl implements OilImplementation {
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
	 * The cached value of the '{@link #getOilObjects() <em>Oil Objects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOilObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<OilObjectImpl> oilObjects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OilImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OilPackage.Literals.OIL_IMPLEMENTATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, OilPackage.OIL_IMPLEMENTATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OilObjectImpl> getOilObjects() {
		if (oilObjects == null) {
			oilObjects = new EObjectContainmentEList<OilObjectImpl>(OilObjectImpl.class, this, OilPackage.OIL_IMPLEMENTATION__OIL_OBJECTS);
		}
		return oilObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OilPackage.OIL_IMPLEMENTATION__OIL_OBJECTS:
				return ((InternalEList<?>)getOilObjects()).basicRemove(otherEnd, msgs);
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
			case OilPackage.OIL_IMPLEMENTATION__NAME:
				return getName();
			case OilPackage.OIL_IMPLEMENTATION__OIL_OBJECTS:
				return getOilObjects();
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
			case OilPackage.OIL_IMPLEMENTATION__NAME:
				setName((String)newValue);
				return;
			case OilPackage.OIL_IMPLEMENTATION__OIL_OBJECTS:
				getOilObjects().clear();
				getOilObjects().addAll((Collection<? extends OilObjectImpl>)newValue);
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
			case OilPackage.OIL_IMPLEMENTATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OilPackage.OIL_IMPLEMENTATION__OIL_OBJECTS:
				getOilObjects().clear();
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
			case OilPackage.OIL_IMPLEMENTATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OilPackage.OIL_IMPLEMENTATION__OIL_OBJECTS:
				return oilObjects != null && !oilObjects.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //OilImplementationImpl
