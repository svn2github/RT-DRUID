/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.CacheMissCost;
import com.eu.evidence.rtdruid.vartree.data.CacheMissCostList;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

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
 * An implementation of the model object '<em><b>Cache Miss Cost List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CacheMissCostListImpl#getCacheMissCostItemsList <em>Cache Miss Cost Items List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CacheMissCostListImpl#getModeRef <em>Mode Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CacheMissCostListImpl extends ObjectWithIDImpl implements CacheMissCostList {
	/**
	 * The cached value of the '{@link #getCacheMissCostItemsList() <em>Cache Miss Cost Items List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCacheMissCostItemsList()
	 * @generated
	 * @ordered
	 */
	protected EList<CacheMissCost> cacheMissCostItemsList;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CacheMissCostListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.CACHE_MISS_COST_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CacheMissCost> getCacheMissCostItemsList() {
		if (cacheMissCostItemsList == null) {
			cacheMissCostItemsList = new EObjectContainmentEList<CacheMissCost>(CacheMissCost.class, this, DataPackage.CACHE_MISS_COST_LIST__CACHE_MISS_COST_ITEMS_LIST);
		}
		return cacheMissCostItemsList;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CACHE_MISS_COST_LIST__MODE_REF, oldModeRef, modeRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataPackage.CACHE_MISS_COST_LIST__CACHE_MISS_COST_ITEMS_LIST:
				return ((InternalEList<?>)getCacheMissCostItemsList()).basicRemove(otherEnd, msgs);
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
			case DataPackage.CACHE_MISS_COST_LIST__CACHE_MISS_COST_ITEMS_LIST:
				return getCacheMissCostItemsList();
			case DataPackage.CACHE_MISS_COST_LIST__MODE_REF:
				return getModeRef();
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
			case DataPackage.CACHE_MISS_COST_LIST__CACHE_MISS_COST_ITEMS_LIST:
				getCacheMissCostItemsList().clear();
				getCacheMissCostItemsList().addAll((Collection<? extends CacheMissCost>)newValue);
				return;
			case DataPackage.CACHE_MISS_COST_LIST__MODE_REF:
				setModeRef((StringVar)newValue);
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
			case DataPackage.CACHE_MISS_COST_LIST__CACHE_MISS_COST_ITEMS_LIST:
				getCacheMissCostItemsList().clear();
				return;
			case DataPackage.CACHE_MISS_COST_LIST__MODE_REF:
				setModeRef(MODE_REF_EDEFAULT);
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
			case DataPackage.CACHE_MISS_COST_LIST__CACHE_MISS_COST_ITEMS_LIST:
				return cacheMissCostItemsList != null && !cacheMissCostItemsList.isEmpty();
			case DataPackage.CACHE_MISS_COST_LIST__MODE_REF:
				return MODE_REF_EDEFAULT == null ? modeRef != null : !MODE_REF_EDEFAULT.equals(modeRef);
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

} //CacheMissCostListImpl
