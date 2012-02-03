/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.Mapping;
import com.eu.evidence.rtdruid.vartree.data.ProcMap;
import com.eu.evidence.rtdruid.vartree.data.TaskMap;
import com.eu.evidence.rtdruid.vartree.data.VarMap;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.MappingImpl#getProcMapList <em>Proc Map List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.MappingImpl#getTaskMapList <em>Task Map List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.MappingImpl#getVarMapList <em>Var Map List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingImpl extends ObjectWithIDImpl implements Mapping {
	/**
	 * The cached value of the '{@link #getProcMapList() <em>Proc Map List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcMapList()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcMap> procMapList;

	/**
	 * The cached value of the '{@link #getTaskMapList() <em>Task Map List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskMapList()
	 * @generated
	 * @ordered
	 */
	protected EList<TaskMap> taskMapList;

	/**
	 * The cached value of the '{@link #getVarMapList() <em>Var Map List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarMapList()
	 * @generated
	 * @ordered
	 */
	protected EList<VarMap> varMapList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcMap> getProcMapList() {
		if (procMapList == null) {
			procMapList = new EObjectContainmentEList<ProcMap>(ProcMap.class, this, DataPackage.MAPPING__PROC_MAP_LIST);
		}
		return procMapList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TaskMap> getTaskMapList() {
		if (taskMapList == null) {
			taskMapList = new EObjectContainmentEList<TaskMap>(TaskMap.class, this, DataPackage.MAPPING__TASK_MAP_LIST);
		}
		return taskMapList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VarMap> getVarMapList() {
		if (varMapList == null) {
			varMapList = new EObjectContainmentEList<VarMap>(VarMap.class, this, DataPackage.MAPPING__VAR_MAP_LIST);
		}
		return varMapList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataPackage.MAPPING__PROC_MAP_LIST:
				return ((InternalEList<?>)getProcMapList()).basicRemove(otherEnd, msgs);
			case DataPackage.MAPPING__TASK_MAP_LIST:
				return ((InternalEList<?>)getTaskMapList()).basicRemove(otherEnd, msgs);
			case DataPackage.MAPPING__VAR_MAP_LIST:
				return ((InternalEList<?>)getVarMapList()).basicRemove(otherEnd, msgs);
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
			case DataPackage.MAPPING__PROC_MAP_LIST:
				return getProcMapList();
			case DataPackage.MAPPING__TASK_MAP_LIST:
				return getTaskMapList();
			case DataPackage.MAPPING__VAR_MAP_LIST:
				return getVarMapList();
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
			case DataPackage.MAPPING__PROC_MAP_LIST:
				getProcMapList().clear();
				getProcMapList().addAll((Collection<? extends ProcMap>)newValue);
				return;
			case DataPackage.MAPPING__TASK_MAP_LIST:
				getTaskMapList().clear();
				getTaskMapList().addAll((Collection<? extends TaskMap>)newValue);
				return;
			case DataPackage.MAPPING__VAR_MAP_LIST:
				getVarMapList().clear();
				getVarMapList().addAll((Collection<? extends VarMap>)newValue);
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
			case DataPackage.MAPPING__PROC_MAP_LIST:
				getProcMapList().clear();
				return;
			case DataPackage.MAPPING__TASK_MAP_LIST:
				getTaskMapList().clear();
				return;
			case DataPackage.MAPPING__VAR_MAP_LIST:
				getVarMapList().clear();
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
			case DataPackage.MAPPING__PROC_MAP_LIST:
				return procMapList != null && !procMapList.isEmpty();
			case DataPackage.MAPPING__TASK_MAP_LIST:
				return taskMapList != null && !taskMapList.isEmpty();
			case DataPackage.MAPPING__VAR_MAP_LIST:
				return varMapList != null && !varMapList.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MappingImpl
