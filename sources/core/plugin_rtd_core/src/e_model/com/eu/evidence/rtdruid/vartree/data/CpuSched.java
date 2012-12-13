/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.vartree.data;

import com.eu.evidence.rtdruid.vartree.variables.BooleanVar;
import com.eu.evidence.rtdruid.vartree.variables.DoubleVar;
import com.eu.evidence.rtdruid.vartree.variables.IntegerVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cpu Sched</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.CpuSched#getBoundary <em>Boundary</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.CpuSched#getCpuRef <em>Cpu Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.CpuSched#getSchedulable <em>Schedulable</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.CpuSched#getSpeedFactor <em>Speed Factor</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.CpuSched#getUtilization <em>Utilization</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.CpuSched#getMaxStackSize <em>Max Stack Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCpuSched()
 * @model
 * @generated
 */
public interface CpuSched extends ObjectWithID {
	/**
	 * Returns the value of the '<em><b>Boundary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boundary</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boundary</em>' attribute.
	 * @see #setBoundary(DoubleVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCpuSched_Boundary()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.DoubleVar"
	 * @generated
	 */
	DoubleVar getBoundary();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.CpuSched#getBoundary <em>Boundary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boundary</em>' attribute.
	 * @see #getBoundary()
	 * @generated
	 */
	void setBoundary(DoubleVar value);

	/**
	 * Returns the value of the '<em><b>Cpu Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cpu Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cpu Ref</em>' attribute.
	 * @see #setCpuRef(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCpuSched_CpuRef()
	 * @model id="true" dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getCpuRef();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.CpuSched#getCpuRef <em>Cpu Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cpu Ref</em>' attribute.
	 * @see #getCpuRef()
	 * @generated
	 */
	void setCpuRef(StringVar value);

	/**
	 * Returns the value of the '<em><b>Schedulable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedulable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedulable</em>' attribute.
	 * @see #setSchedulable(BooleanVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCpuSched_Schedulable()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.BooleanVar"
	 * @generated
	 */
	BooleanVar getSchedulable();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.CpuSched#getSchedulable <em>Schedulable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedulable</em>' attribute.
	 * @see #getSchedulable()
	 * @generated
	 */
	void setSchedulable(BooleanVar value);

	/**
	 * Returns the value of the '<em><b>Speed Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Speed Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Speed Factor</em>' attribute.
	 * @see #setSpeedFactor(DoubleVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCpuSched_SpeedFactor()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.DoubleVar"
	 * @generated
	 */
	DoubleVar getSpeedFactor();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.CpuSched#getSpeedFactor <em>Speed Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Speed Factor</em>' attribute.
	 * @see #getSpeedFactor()
	 * @generated
	 */
	void setSpeedFactor(DoubleVar value);

	/**
	 * Returns the value of the '<em><b>Utilization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utilization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utilization</em>' attribute.
	 * @see #setUtilization(DoubleVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCpuSched_Utilization()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.DoubleVar"
	 * @generated
	 */
	DoubleVar getUtilization();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.CpuSched#getUtilization <em>Utilization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Utilization</em>' attribute.
	 * @see #getUtilization()
	 * @generated
	 */
	void setUtilization(DoubleVar value);

	/**
	 * Returns the value of the '<em><b>Max Stack Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Stack Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Stack Size</em>' attribute.
	 * @see #setMaxStackSize(IntegerVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCpuSched_MaxStackSize()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.IntegerVar"
	 * @generated
	 */
	IntegerVar getMaxStackSize();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.CpuSched#getMaxStackSize <em>Max Stack Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Stack Size</em>' attribute.
	 * @see #getMaxStackSize()
	 * @generated
	 */
	void setMaxStackSize(IntegerVar value);

} // CpuSched
