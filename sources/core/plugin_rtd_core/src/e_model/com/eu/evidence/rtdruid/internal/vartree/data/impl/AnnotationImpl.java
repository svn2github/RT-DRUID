/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.Annotation;
import com.eu.evidence.rtdruid.vartree.data.CacheMissCostList;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.ExecTimeList;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.AnnotationImpl#getExecTimeLists <em>Exec Time Lists</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.AnnotationImpl#getCacheMissCostLists <em>Cache Miss Cost Lists</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnnotationImpl extends ObjectWithIDImpl implements Annotation {
	/**
	 * The cached value of the '{@link #getExecTimeLists() <em>Exec Time Lists</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecTimeLists()
	 * @generated
	 * @ordered
	 */
	protected EList<ExecTimeList> execTimeLists;

	/**
	 * The cached value of the '{@link #getCacheMissCostLists() <em>Cache Miss Cost Lists</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCacheMissCostLists()
	 * @generated
	 * @ordered
	 */
	protected EList<CacheMissCostList> cacheMissCostLists;

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
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecTimeList> getExecTimeLists() {
		if (execTimeLists == null) {
			execTimeLists = new EObjectContainmentEList<ExecTimeList>(ExecTimeList.class, this, DataPackage.ANNOTATION__EXEC_TIME_LISTS);
		}
		return execTimeLists;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CacheMissCostList> getCacheMissCostLists() {
		if (cacheMissCostLists == null) {
			cacheMissCostLists = new EObjectContainmentEList<CacheMissCostList>(CacheMissCostList.class, this, DataPackage.ANNOTATION__CACHE_MISS_COST_LISTS);
		}
		return cacheMissCostLists;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataPackage.ANNOTATION__EXEC_TIME_LISTS:
				return ((InternalEList<?>)getExecTimeLists()).basicRemove(otherEnd, msgs);
			case DataPackage.ANNOTATION__CACHE_MISS_COST_LISTS:
				return ((InternalEList<?>)getCacheMissCostLists()).basicRemove(otherEnd, msgs);
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
			case DataPackage.ANNOTATION__EXEC_TIME_LISTS:
				return getExecTimeLists();
			case DataPackage.ANNOTATION__CACHE_MISS_COST_LISTS:
				return getCacheMissCostLists();
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
			case DataPackage.ANNOTATION__EXEC_TIME_LISTS:
				getExecTimeLists().clear();
				getExecTimeLists().addAll((Collection<? extends ExecTimeList>)newValue);
				return;
			case DataPackage.ANNOTATION__CACHE_MISS_COST_LISTS:
				getCacheMissCostLists().clear();
				getCacheMissCostLists().addAll((Collection<? extends CacheMissCostList>)newValue);
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
			case DataPackage.ANNOTATION__EXEC_TIME_LISTS:
				getExecTimeLists().clear();
				return;
			case DataPackage.ANNOTATION__CACHE_MISS_COST_LISTS:
				getCacheMissCostLists().clear();
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
			case DataPackage.ANNOTATION__EXEC_TIME_LISTS:
				return execTimeLists != null && !execTimeLists.isEmpty();
			case DataPackage.ANNOTATION__CACHE_MISS_COST_LISTS:
				return cacheMissCostLists != null && !cacheMissCostLists.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AnnotationImpl
