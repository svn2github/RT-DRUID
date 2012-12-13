/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.Implementation;
import com.eu.evidence.rtdruid.vartree.data.ProvidedInterface;
import com.eu.evidence.rtdruid.vartree.data.RequiredInterface;
import com.eu.evidence.rtdruid.vartree.data.SubSystem;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SubSystemImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SubSystemImpl#getProvidedInterfaceList <em>Provided Interface List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SubSystemImpl#getRequiredInterfaceList <em>Required Interface List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubSystemImpl extends ImplementationImpl implements SubSystem {
	/**
	 * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected EList<Implementation> implementation;

	/**
	 * The cached value of the '{@link #getProvidedInterfaceList() <em>Provided Interface List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedInterfaceList()
	 * @generated
	 * @ordered
	 */
	protected EList<ProvidedInterface> providedInterfaceList;

	/**
	 * The cached value of the '{@link #getRequiredInterfaceList() <em>Required Interface List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredInterfaceList()
	 * @generated
	 * @ordered
	 */
	protected EList<RequiredInterface> requiredInterfaceList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.SUB_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Implementation> getImplementation() {
		if (implementation == null) {
			implementation = new EObjectContainmentEList<Implementation>(Implementation.class, this, DataPackage.SUB_SYSTEM__IMPLEMENTATION);
		}
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProvidedInterface> getProvidedInterfaceList() {
		if (providedInterfaceList == null) {
			providedInterfaceList = new EObjectContainmentEList<ProvidedInterface>(ProvidedInterface.class, this, DataPackage.SUB_SYSTEM__PROVIDED_INTERFACE_LIST);
		}
		return providedInterfaceList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RequiredInterface> getRequiredInterfaceList() {
		if (requiredInterfaceList == null) {
			requiredInterfaceList = new EObjectContainmentEList<RequiredInterface>(RequiredInterface.class, this, DataPackage.SUB_SYSTEM__REQUIRED_INTERFACE_LIST);
		}
		return requiredInterfaceList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataPackage.SUB_SYSTEM__IMPLEMENTATION:
				return ((InternalEList<?>)getImplementation()).basicRemove(otherEnd, msgs);
			case DataPackage.SUB_SYSTEM__PROVIDED_INTERFACE_LIST:
				return ((InternalEList<?>)getProvidedInterfaceList()).basicRemove(otherEnd, msgs);
			case DataPackage.SUB_SYSTEM__REQUIRED_INTERFACE_LIST:
				return ((InternalEList<?>)getRequiredInterfaceList()).basicRemove(otherEnd, msgs);
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
			case DataPackage.SUB_SYSTEM__IMPLEMENTATION:
				return getImplementation();
			case DataPackage.SUB_SYSTEM__PROVIDED_INTERFACE_LIST:
				return getProvidedInterfaceList();
			case DataPackage.SUB_SYSTEM__REQUIRED_INTERFACE_LIST:
				return getRequiredInterfaceList();
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
			case DataPackage.SUB_SYSTEM__IMPLEMENTATION:
				getImplementation().clear();
				getImplementation().addAll((Collection<? extends Implementation>)newValue);
				return;
			case DataPackage.SUB_SYSTEM__PROVIDED_INTERFACE_LIST:
				getProvidedInterfaceList().clear();
				getProvidedInterfaceList().addAll((Collection<? extends ProvidedInterface>)newValue);
				return;
			case DataPackage.SUB_SYSTEM__REQUIRED_INTERFACE_LIST:
				getRequiredInterfaceList().clear();
				getRequiredInterfaceList().addAll((Collection<? extends RequiredInterface>)newValue);
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
			case DataPackage.SUB_SYSTEM__IMPLEMENTATION:
				getImplementation().clear();
				return;
			case DataPackage.SUB_SYSTEM__PROVIDED_INTERFACE_LIST:
				getProvidedInterfaceList().clear();
				return;
			case DataPackage.SUB_SYSTEM__REQUIRED_INTERFACE_LIST:
				getRequiredInterfaceList().clear();
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
			case DataPackage.SUB_SYSTEM__IMPLEMENTATION:
				return implementation != null && !implementation.isEmpty();
			case DataPackage.SUB_SYSTEM__PROVIDED_INTERFACE_LIST:
				return providedInterfaceList != null && !providedInterfaceList.isEmpty();
			case DataPackage.SUB_SYSTEM__REQUIRED_INTERFACE_LIST:
				return requiredInterfaceList != null && !requiredInterfaceList.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SubSystemImpl
