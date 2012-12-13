/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.CpuSched;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.SchedulingScenario;
import com.eu.evidence.rtdruid.vartree.data.TaskSched;

import com.eu.evidence.rtdruid.vartree.variables.StringVar;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduling Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SchedulingScenarioImpl#getCpuSchedList <em>Cpu Sched List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SchedulingScenarioImpl#getModeRef <em>Mode Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SchedulingScenarioImpl#getReports <em>Reports</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SchedulingScenarioImpl#getTaskSchedList <em>Task Sched List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SchedulingScenarioImpl extends ObjectWithIDImpl implements SchedulingScenario {
	/**
	 * The cached value of the '{@link #getCpuSchedList() <em>Cpu Sched List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuSchedList()
	 * @generated
	 * @ordered
	 */
	protected EList<CpuSched> cpuSchedList;

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
	 * The cached value of the '{@link #getReports() <em>Reports</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReports()
	 * @generated
	 * @ordered
	 */
	protected EList<StringVar> reports;

	/**
	 * The cached value of the '{@link #getTaskSchedList() <em>Task Sched List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskSchedList()
	 * @generated
	 * @ordered
	 */
	protected EList<TaskSched> taskSchedList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulingScenarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.SCHEDULING_SCENARIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CpuSched> getCpuSchedList() {
		if (cpuSchedList == null) {
			cpuSchedList = new EObjectContainmentEList<CpuSched>(CpuSched.class, this, DataPackage.SCHEDULING_SCENARIO__CPU_SCHED_LIST);
		}
		return cpuSchedList;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.SCHEDULING_SCENARIO__MODE_REF, oldModeRef, modeRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StringVar> getReports() {
		if (reports == null) {
			reports = new EDataTypeUniqueEList<StringVar>(StringVar.class, this, DataPackage.SCHEDULING_SCENARIO__REPORTS);
		}
		return reports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TaskSched> getTaskSchedList() {
		if (taskSchedList == null) {
			taskSchedList = new EObjectContainmentEList<TaskSched>(TaskSched.class, this, DataPackage.SCHEDULING_SCENARIO__TASK_SCHED_LIST);
		}
		return taskSchedList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataPackage.SCHEDULING_SCENARIO__CPU_SCHED_LIST:
				return ((InternalEList<?>)getCpuSchedList()).basicRemove(otherEnd, msgs);
			case DataPackage.SCHEDULING_SCENARIO__TASK_SCHED_LIST:
				return ((InternalEList<?>)getTaskSchedList()).basicRemove(otherEnd, msgs);
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
			case DataPackage.SCHEDULING_SCENARIO__CPU_SCHED_LIST:
				return getCpuSchedList();
			case DataPackage.SCHEDULING_SCENARIO__MODE_REF:
				return getModeRef();
			case DataPackage.SCHEDULING_SCENARIO__REPORTS:
				return getReports();
			case DataPackage.SCHEDULING_SCENARIO__TASK_SCHED_LIST:
				return getTaskSchedList();
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
			case DataPackage.SCHEDULING_SCENARIO__CPU_SCHED_LIST:
				getCpuSchedList().clear();
				getCpuSchedList().addAll((Collection<? extends CpuSched>)newValue);
				return;
			case DataPackage.SCHEDULING_SCENARIO__MODE_REF:
				setModeRef((StringVar)newValue);
				return;
			case DataPackage.SCHEDULING_SCENARIO__REPORTS:
				getReports().clear();
				getReports().addAll((Collection<? extends StringVar>)newValue);
				return;
			case DataPackage.SCHEDULING_SCENARIO__TASK_SCHED_LIST:
				getTaskSchedList().clear();
				getTaskSchedList().addAll((Collection<? extends TaskSched>)newValue);
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
			case DataPackage.SCHEDULING_SCENARIO__CPU_SCHED_LIST:
				getCpuSchedList().clear();
				return;
			case DataPackage.SCHEDULING_SCENARIO__MODE_REF:
				setModeRef(MODE_REF_EDEFAULT);
				return;
			case DataPackage.SCHEDULING_SCENARIO__REPORTS:
				getReports().clear();
				return;
			case DataPackage.SCHEDULING_SCENARIO__TASK_SCHED_LIST:
				getTaskSchedList().clear();
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
			case DataPackage.SCHEDULING_SCENARIO__CPU_SCHED_LIST:
				return cpuSchedList != null && !cpuSchedList.isEmpty();
			case DataPackage.SCHEDULING_SCENARIO__MODE_REF:
				return MODE_REF_EDEFAULT == null ? modeRef != null : !MODE_REF_EDEFAULT.equals(modeRef);
			case DataPackage.SCHEDULING_SCENARIO__REPORTS:
				return reports != null && !reports.isEmpty();
			case DataPackage.SCHEDULING_SCENARIO__TASK_SCHED_LIST:
				return taskSchedList != null && !taskSchedList.isEmpty();
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
		result.append(", Reports: ");
		result.append(reports);
		result.append(')');
		return result.toString();
	}

} //SchedulingScenarioImpl
