/**
 * <copyright>
 * </copyright>
 *
 * %W%
 * @version %I% %H%
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;




import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import com.eu.evidence.rtdruid.vartree.data.Annotation;
import com.eu.evidence.rtdruid.vartree.data.CacheMissCostList;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.ExecTimeList;
import com.eu.evidence.rtdruid.vartree.data.init.EObjectContainmentUniqueEList;
import com.eu.evidence.rtdruid.vartree.data.init.ObjectWithIDImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.AnnotationImpl#getExecTimeLists <em>Exec Time Lists</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnnotationImpl extends ObjectWithIDImpl implements Annotation
{
	/**
	 * The cached value of the '{@link #getExecTimeLists() <em>Exec Time Lists</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecTimeLists()
	 * @generated
	 * @ordered
	 */
	protected EList execTimeLists = null;

 	/**
	 * The cached value of the '{@link #getCacheMissCostLists() <em>Cache Miss Cost Lists</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCacheMissCostLists()
	 * @generated
	 * @ordered
	 */
	protected EList cacheMissCostLists;

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected AnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EClass eStaticClass() {
		return DataPackage.eINSTANCE.getAnnotation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getExecTimeLists() {
		if (execTimeLists == null) {
			execTimeLists = new EObjectContainmentUniqueEList(ExecTimeList.class, this, DataPackage.ANNOTATION__EXEC_TIME_LISTS);
		}
		return execTimeLists;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getCacheMissCostLists() {
		if (cacheMissCostLists == null) {
			cacheMissCostLists = new EObjectContainmentUniqueEList(CacheMissCostList.class, this, DataPackage.ANNOTATION__CACHE_MISS_COST_LISTS);
		}
		return cacheMissCostLists;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case DataPackage.ANNOTATION__EXEC_TIME_LISTS:
					return ((InternalEList)getExecTimeLists()).basicRemove(otherEnd, msgs);
				case DataPackage.ANNOTATION__CACHE_MISS_COST_LISTS:
						return ((InternalEList)getCacheMissCostLists()).basicRemove(otherEnd, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case DataPackage.ANNOTATION__EXEC_TIME_LISTS:
				return getExecTimeLists();
			case DataPackage.ANNOTATION__CACHE_MISS_COST_LISTS:
				return getCacheMissCostLists();
		}
		return super.eGet(eFeature, resolve);
//		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case DataPackage.ANNOTATION__EXEC_TIME_LISTS:
				getExecTimeLists().clear();
				getExecTimeLists().addAll((Collection)newValue);
				return;
			case DataPackage.ANNOTATION__CACHE_MISS_COST_LISTS:
				getCacheMissCostLists().clear();
				getCacheMissCostLists().addAll((Collection)newValue);
				return;
		}
		super.eSet(eFeature, newValue);
//		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case DataPackage.ANNOTATION__EXEC_TIME_LISTS:
				getExecTimeLists().clear();
				return;
			case DataPackage.ANNOTATION__CACHE_MISS_COST_LISTS:
				getCacheMissCostLists().clear();
				return;
		}
		super.eUnset(eFeature);
//		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case DataPackage.ANNOTATION__EXEC_TIME_LISTS:
				return execTimeLists != null && !execTimeLists.isEmpty();
			case DataPackage.ANNOTATION__CACHE_MISS_COST_LISTS:
				return cacheMissCostLists != null && !cacheMissCostLists.isEmpty();
		}
		return super.eIsSet(eFeature);
//		return eDynamicIsSet(eFeature);
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#getObjectID()
	 */
	public String getObjectID() {
		return "Annotation";
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#setObjectID(java.lang.String)
	 */
	public boolean setObjectID(String newID) {
		return getObjectID().equals(newID);
	}
} //AnnotationImpl
