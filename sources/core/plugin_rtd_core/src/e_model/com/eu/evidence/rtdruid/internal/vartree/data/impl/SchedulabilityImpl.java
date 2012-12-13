/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.Schedulability;
import com.eu.evidence.rtdruid.vartree.data.SchedulingScenario;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Schedulability</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SchedulabilityImpl#getSchedulingScenarioList <em>Scheduling Scenario List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SchedulabilityImpl extends ObjectWithIDImpl implements Schedulability {
	/**
	 * The cached value of the '{@link #getSchedulingScenarioList() <em>Scheduling Scenario List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulingScenarioList()
	 * @generated
	 * @ordered
	 */
	protected EList<SchedulingScenario> schedulingScenarioList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulabilityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.SCHEDULABILITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SchedulingScenario> getSchedulingScenarioList() {
		if (schedulingScenarioList == null) {
			schedulingScenarioList = new EObjectContainmentEList<SchedulingScenario>(SchedulingScenario.class, this, DataPackage.SCHEDULABILITY__SCHEDULING_SCENARIO_LIST);
		}
		return schedulingScenarioList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataPackage.SCHEDULABILITY__SCHEDULING_SCENARIO_LIST:
				return ((InternalEList<?>)getSchedulingScenarioList()).basicRemove(otherEnd, msgs);
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
			case DataPackage.SCHEDULABILITY__SCHEDULING_SCENARIO_LIST:
				return getSchedulingScenarioList();
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
			case DataPackage.SCHEDULABILITY__SCHEDULING_SCENARIO_LIST:
				getSchedulingScenarioList().clear();
				getSchedulingScenarioList().addAll((Collection<? extends SchedulingScenario>)newValue);
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
			case DataPackage.SCHEDULABILITY__SCHEDULING_SCENARIO_LIST:
				getSchedulingScenarioList().clear();
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
			case DataPackage.SCHEDULABILITY__SCHEDULING_SCENARIO_LIST:
				return schedulingScenarioList != null && !schedulingScenarioList.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SchedulabilityImpl
