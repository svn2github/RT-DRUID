/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.Activation;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.ResourceRef;
import com.eu.evidence.rtdruid.vartree.data.Scheduling;
import com.eu.evidence.rtdruid.vartree.data.Task;

import com.eu.evidence.rtdruid.vartree.variables.OilVar;
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
 * An implementation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskImpl#getActivationList <em>Activation List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskImpl#getOilVar <em>Oil Var</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskImpl#getResourceRefList <em>Resource Ref List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskImpl#getSchedulingList <em>Scheduling List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskImpl extends ObjectWithIDImpl implements Task {
	/**
	 * The cached value of the '{@link #getActivationList() <em>Activation List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivationList()
	 * @generated
	 * @ordered
	 */
	protected EList<Activation> activationList;

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
	 * The cached value of the '{@link #getResourceRefList() <em>Resource Ref List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceRefList()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceRef> resourceRefList;

	/**
	 * The cached value of the '{@link #getSchedulingList() <em>Scheduling List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulingList()
	 * @generated
	 * @ordered
	 */
	protected EList<Scheduling> schedulingList;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected StringVar type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Activation> getActivationList() {
		if (activationList == null) {
			activationList = new EObjectContainmentEList<Activation>(Activation.class, this, DataPackage.TASK__ACTIVATION_LIST);
		}
		return activationList;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TASK__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TASK__OIL_VAR, oldOilVar, oilVar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceRef> getResourceRefList() {
		if (resourceRefList == null) {
			resourceRefList = new EObjectContainmentEList<ResourceRef>(ResourceRef.class, this, DataPackage.TASK__RESOURCE_REF_LIST);
		}
		return resourceRefList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Scheduling> getSchedulingList() {
		if (schedulingList == null) {
			schedulingList = new EObjectContainmentEList<Scheduling>(Scheduling.class, this, DataPackage.TASK__SCHEDULING_LIST);
		}
		return schedulingList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(StringVar newType) {
		StringVar oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TASK__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataPackage.TASK__ACTIVATION_LIST:
				return ((InternalEList<?>)getActivationList()).basicRemove(otherEnd, msgs);
			case DataPackage.TASK__RESOURCE_REF_LIST:
				return ((InternalEList<?>)getResourceRefList()).basicRemove(otherEnd, msgs);
			case DataPackage.TASK__SCHEDULING_LIST:
				return ((InternalEList<?>)getSchedulingList()).basicRemove(otherEnd, msgs);
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
			case DataPackage.TASK__ACTIVATION_LIST:
				return getActivationList();
			case DataPackage.TASK__NAME:
				return getName();
			case DataPackage.TASK__OIL_VAR:
				return getOilVar();
			case DataPackage.TASK__RESOURCE_REF_LIST:
				return getResourceRefList();
			case DataPackage.TASK__SCHEDULING_LIST:
				return getSchedulingList();
			case DataPackage.TASK__TYPE:
				return getType();
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
			case DataPackage.TASK__ACTIVATION_LIST:
				getActivationList().clear();
				getActivationList().addAll((Collection<? extends Activation>)newValue);
				return;
			case DataPackage.TASK__NAME:
				setName((StringVar)newValue);
				return;
			case DataPackage.TASK__OIL_VAR:
				setOilVar((OilVar)newValue);
				return;
			case DataPackage.TASK__RESOURCE_REF_LIST:
				getResourceRefList().clear();
				getResourceRefList().addAll((Collection<? extends ResourceRef>)newValue);
				return;
			case DataPackage.TASK__SCHEDULING_LIST:
				getSchedulingList().clear();
				getSchedulingList().addAll((Collection<? extends Scheduling>)newValue);
				return;
			case DataPackage.TASK__TYPE:
				setType((StringVar)newValue);
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
			case DataPackage.TASK__ACTIVATION_LIST:
				getActivationList().clear();
				return;
			case DataPackage.TASK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DataPackage.TASK__OIL_VAR:
				setOilVar(OIL_VAR_EDEFAULT);
				return;
			case DataPackage.TASK__RESOURCE_REF_LIST:
				getResourceRefList().clear();
				return;
			case DataPackage.TASK__SCHEDULING_LIST:
				getSchedulingList().clear();
				return;
			case DataPackage.TASK__TYPE:
				setType(TYPE_EDEFAULT);
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
			case DataPackage.TASK__ACTIVATION_LIST:
				return activationList != null && !activationList.isEmpty();
			case DataPackage.TASK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DataPackage.TASK__OIL_VAR:
				return OIL_VAR_EDEFAULT == null ? oilVar != null : !OIL_VAR_EDEFAULT.equals(oilVar);
			case DataPackage.TASK__RESOURCE_REF_LIST:
				return resourceRefList != null && !resourceRefList.isEmpty();
			case DataPackage.TASK__SCHEDULING_LIST:
				return schedulingList != null && !schedulingList.isEmpty();
			case DataPackage.TASK__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
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
		result.append(", Type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //TaskImpl
