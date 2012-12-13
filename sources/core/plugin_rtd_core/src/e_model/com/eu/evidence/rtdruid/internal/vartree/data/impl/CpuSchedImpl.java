/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.CpuSched;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

import com.eu.evidence.rtdruid.vartree.variables.BooleanVar;
import com.eu.evidence.rtdruid.vartree.variables.DoubleVar;
import com.eu.evidence.rtdruid.vartree.variables.IntegerVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cpu Sched</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CpuSchedImpl#getBoundary <em>Boundary</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CpuSchedImpl#getCpuRef <em>Cpu Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CpuSchedImpl#getSchedulable <em>Schedulable</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CpuSchedImpl#getSpeedFactor <em>Speed Factor</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CpuSchedImpl#getUtilization <em>Utilization</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CpuSchedImpl#getMaxStackSize <em>Max Stack Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CpuSchedImpl extends ObjectWithIDImpl implements CpuSched {
	/**
	 * The default value of the '{@link #getBoundary() <em>Boundary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundary()
	 * @generated
	 * @ordered
	 */
	protected static final DoubleVar BOUNDARY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBoundary() <em>Boundary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundary()
	 * @generated
	 * @ordered
	 */
	protected DoubleVar boundary = BOUNDARY_EDEFAULT;

	/**
	 * The default value of the '{@link #getCpuRef() <em>Cpu Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuRef()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar CPU_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCpuRef() <em>Cpu Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuRef()
	 * @generated
	 * @ordered
	 */
	protected StringVar cpuRef = CPU_REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchedulable() <em>Schedulable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulable()
	 * @generated
	 * @ordered
	 */
	protected static final BooleanVar SCHEDULABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSchedulable() <em>Schedulable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulable()
	 * @generated
	 * @ordered
	 */
	protected BooleanVar schedulable = SCHEDULABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpeedFactor() <em>Speed Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeedFactor()
	 * @generated
	 * @ordered
	 */
	protected static final DoubleVar SPEED_FACTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpeedFactor() <em>Speed Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeedFactor()
	 * @generated
	 * @ordered
	 */
	protected DoubleVar speedFactor = SPEED_FACTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getUtilization() <em>Utilization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilization()
	 * @generated
	 * @ordered
	 */
	protected static final DoubleVar UTILIZATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUtilization() <em>Utilization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilization()
	 * @generated
	 * @ordered
	 */
	protected DoubleVar utilization = UTILIZATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxStackSize() <em>Max Stack Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxStackSize()
	 * @generated
	 * @ordered
	 */
	protected static final IntegerVar MAX_STACK_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxStackSize() <em>Max Stack Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxStackSize()
	 * @generated
	 * @ordered
	 */
	protected IntegerVar maxStackSize = MAX_STACK_SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CpuSchedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.CPU_SCHED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleVar getBoundary() {
		return boundary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundary(DoubleVar newBoundary) {
		DoubleVar oldBoundary = boundary;
		boundary = newBoundary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CPU_SCHED__BOUNDARY, oldBoundary, boundary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getCpuRef() {
		return cpuRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpuRef(StringVar newCpuRef) {
		StringVar oldCpuRef = cpuRef;
		cpuRef = newCpuRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CPU_SCHED__CPU_REF, oldCpuRef, cpuRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanVar getSchedulable() {
		return schedulable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedulable(BooleanVar newSchedulable) {
		BooleanVar oldSchedulable = schedulable;
		schedulable = newSchedulable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CPU_SCHED__SCHEDULABLE, oldSchedulable, schedulable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleVar getSpeedFactor() {
		return speedFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpeedFactor(DoubleVar newSpeedFactor) {
		DoubleVar oldSpeedFactor = speedFactor;
		speedFactor = newSpeedFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CPU_SCHED__SPEED_FACTOR, oldSpeedFactor, speedFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleVar getUtilization() {
		return utilization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtilization(DoubleVar newUtilization) {
		DoubleVar oldUtilization = utilization;
		utilization = newUtilization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CPU_SCHED__UTILIZATION, oldUtilization, utilization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerVar getMaxStackSize() {
		return maxStackSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxStackSize(IntegerVar newMaxStackSize) {
		IntegerVar oldMaxStackSize = maxStackSize;
		maxStackSize = newMaxStackSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CPU_SCHED__MAX_STACK_SIZE, oldMaxStackSize, maxStackSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.CPU_SCHED__BOUNDARY:
				return getBoundary();
			case DataPackage.CPU_SCHED__CPU_REF:
				return getCpuRef();
			case DataPackage.CPU_SCHED__SCHEDULABLE:
				return getSchedulable();
			case DataPackage.CPU_SCHED__SPEED_FACTOR:
				return getSpeedFactor();
			case DataPackage.CPU_SCHED__UTILIZATION:
				return getUtilization();
			case DataPackage.CPU_SCHED__MAX_STACK_SIZE:
				return getMaxStackSize();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DataPackage.CPU_SCHED__BOUNDARY:
				setBoundary((DoubleVar)newValue);
				return;
			case DataPackage.CPU_SCHED__CPU_REF:
				setCpuRef((StringVar)newValue);
				return;
			case DataPackage.CPU_SCHED__SCHEDULABLE:
				setSchedulable((BooleanVar)newValue);
				return;
			case DataPackage.CPU_SCHED__SPEED_FACTOR:
				setSpeedFactor((DoubleVar)newValue);
				return;
			case DataPackage.CPU_SCHED__UTILIZATION:
				setUtilization((DoubleVar)newValue);
				return;
			case DataPackage.CPU_SCHED__MAX_STACK_SIZE:
				setMaxStackSize((IntegerVar)newValue);
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
			case DataPackage.CPU_SCHED__BOUNDARY:
				setBoundary(BOUNDARY_EDEFAULT);
				return;
			case DataPackage.CPU_SCHED__CPU_REF:
				setCpuRef(CPU_REF_EDEFAULT);
				return;
			case DataPackage.CPU_SCHED__SCHEDULABLE:
				setSchedulable(SCHEDULABLE_EDEFAULT);
				return;
			case DataPackage.CPU_SCHED__SPEED_FACTOR:
				setSpeedFactor(SPEED_FACTOR_EDEFAULT);
				return;
			case DataPackage.CPU_SCHED__UTILIZATION:
				setUtilization(UTILIZATION_EDEFAULT);
				return;
			case DataPackage.CPU_SCHED__MAX_STACK_SIZE:
				setMaxStackSize(MAX_STACK_SIZE_EDEFAULT);
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
			case DataPackage.CPU_SCHED__BOUNDARY:
				return BOUNDARY_EDEFAULT == null ? boundary != null : !BOUNDARY_EDEFAULT.equals(boundary);
			case DataPackage.CPU_SCHED__CPU_REF:
				return CPU_REF_EDEFAULT == null ? cpuRef != null : !CPU_REF_EDEFAULT.equals(cpuRef);
			case DataPackage.CPU_SCHED__SCHEDULABLE:
				return SCHEDULABLE_EDEFAULT == null ? schedulable != null : !SCHEDULABLE_EDEFAULT.equals(schedulable);
			case DataPackage.CPU_SCHED__SPEED_FACTOR:
				return SPEED_FACTOR_EDEFAULT == null ? speedFactor != null : !SPEED_FACTOR_EDEFAULT.equals(speedFactor);
			case DataPackage.CPU_SCHED__UTILIZATION:
				return UTILIZATION_EDEFAULT == null ? utilization != null : !UTILIZATION_EDEFAULT.equals(utilization);
			case DataPackage.CPU_SCHED__MAX_STACK_SIZE:
				return MAX_STACK_SIZE_EDEFAULT == null ? maxStackSize != null : !MAX_STACK_SIZE_EDEFAULT.equals(maxStackSize);
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
		result.append(" (Boundary: ");
		result.append(boundary);
		result.append(", CpuRef: ");
		result.append(cpuRef);
		result.append(", Schedulable: ");
		result.append(schedulable);
		result.append(", SpeedFactor: ");
		result.append(speedFactor);
		result.append(", Utilization: ");
		result.append(utilization);
		result.append(", MaxStackSize: ");
		result.append(maxStackSize);
		result.append(')');
		return result.toString();
	}

} //CpuSchedImpl
