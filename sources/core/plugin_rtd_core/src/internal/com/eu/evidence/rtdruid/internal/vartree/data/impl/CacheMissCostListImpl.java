/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;

import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.CacheMissCost;
import com.eu.evidence.rtdruid.vartree.data.CacheMissCostList;
import com.eu.evidence.rtdruid.vartree.data.init.EObjectContainmentUniqueEList;
import com.eu.evidence.rtdruid.vartree.data.init.ObjectWithIDImpl;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Cache Miss Cost List</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link com.eu.evidence.rtdruid.rtdruid.vartree.data.impl.CacheMissCostListImpl#getCacheMissCostItemsList
 * <em>Cache Miss Cost Items List</em>}</li>
 * <li>{@link com.eu.evidence.rtdruid.rtdruid.vartree.data.impl.CacheMissCostListImpl#getModeRef <em>
 * Mode Ref</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CacheMissCostListImpl extends ObjectWithIDImpl implements
		CacheMissCostList {
	/**
	 * The cached value of the '{@link #getCacheMissCostItemsList()
	 * <em>Cache Miss Cost Items List</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCacheMissCostItemsList()
	 * @generated
	 * @ordered
	 */
	protected EList cacheMissCostItemsList = null;

	/**
	 * The default value of the '{@link #getModeRef() <em>Mode Ref</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModeRef()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar MODE_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModeRef() <em>Mode Ref</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModeRef()
	 * @generated
	 * @ordered
	 */
	protected StringVar modeRef = MODE_REF_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CacheMissCostListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return DataPackage.eINSTANCE.getCacheMissCostList();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList getCacheMissCostItemsList() {
		if (cacheMissCostItemsList == null) {
			cacheMissCostItemsList = new EObjectContainmentUniqueEList(
					CacheMissCost.class,
					this,
					DataPackage.CACHE_MISS_COST_LIST__CACHE_MISS_COST_ITEMS_LIST);
		}
		return cacheMissCostItemsList;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StringVar getModeRef() {
		return modeRef;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setModeRef(StringVar newModeRef) {
		if ( !checkNewID(makeID(newModeRef)) ) return;

		// Store old ID
		String old_ID = getObjectID();
		
		setModeRefGen(newModeRef);
	
		// ASk to update ID
		didSetObjectID(old_ID);
	  }
	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  private void setModeRefGen(StringVar newModeRef) {
		StringVar oldModeRef = modeRef;
		modeRef = newModeRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataPackage.CACHE_MISS_COST_LIST__MODE_REF, oldModeRef,
					modeRef));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
		case DataPackage.CACHE_MISS_COST_LIST__CACHE_MISS_COST_ITEMS_LIST:
			return ((InternalEList) getCacheMissCostItemsList()).basicRemove(
					otherEnd, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
  public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
		case DataPackage.CACHE_MISS_COST_LIST__CACHE_MISS_COST_ITEMS_LIST:
			return getCacheMissCostItemsList();
		case DataPackage.CACHE_MISS_COST_LIST__MODE_REF:
			return getModeRef();
		}
		return super.eGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
  public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
		case DataPackage.CACHE_MISS_COST_LIST__CACHE_MISS_COST_ITEMS_LIST:
			getCacheMissCostItemsList().clear();
			getCacheMissCostItemsList().addAll((Collection) newValue);
			return;
		case DataPackage.CACHE_MISS_COST_LIST__MODE_REF:
			setModeRef((StringVar) newValue);
			return;
		}
		super.eSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
  public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
		case DataPackage.CACHE_MISS_COST_LIST__CACHE_MISS_COST_ITEMS_LIST:
			getCacheMissCostItemsList().clear();
			return;
		case DataPackage.CACHE_MISS_COST_LIST__MODE_REF:
			setModeRef(MODE_REF_EDEFAULT);
			return;
		}
		super.eUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
  public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
		case DataPackage.CACHE_MISS_COST_LIST__CACHE_MISS_COST_ITEMS_LIST:
			return cacheMissCostItemsList != null
					&& !cacheMissCostItemsList.isEmpty();
		case DataPackage.CACHE_MISS_COST_LIST__MODE_REF:
			return MODE_REF_EDEFAULT == null ? modeRef != null
					: !MODE_REF_EDEFAULT.equals(modeRef);
		}
		return super.eIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (ModeRef: ");
		result.append(modeRef);
		result.append(')');
		return result.toString();
	}

		/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#getObjectID()
	 */
	public String getObjectID() {
		return makeID(modeRef);
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#setObjectID(java.lang.String)
	 */
	public boolean setObjectID(String newID) {
	  	if ( !checkNewID(newID) ) return false;

	  	// Store old ID
	  	String old_ID = getObjectID();
	  	
		String[] tmp = resolveID(newID);
		setModeRefGen(tmp[0] == null ? (StringVar) null : new StringVar(tmp[0]));
		
		// ASk to update ID
	  	didSetObjectID(old_ID);
		return true;
	}
} // CacheMissCostListImpl
