/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.vartree.data;

import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.TaskMap#getModeRef <em>Mode Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.TaskMap#getRtosRef <em>Rtos Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.TaskMap#getTaskRef <em>Task Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getTaskMap()
 * @model
 * @generated
 */
public interface TaskMap extends ObjectWithID {
	/**
	 * Returns the value of the '<em><b>Mode Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode Ref</em>' attribute.
	 * @see #setModeRef(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getTaskMap_ModeRef()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getModeRef();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.TaskMap#getModeRef <em>Mode Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode Ref</em>' attribute.
	 * @see #getModeRef()
	 * @generated
	 */
	void setModeRef(StringVar value);

	/**
	 * Returns the value of the '<em><b>Rtos Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rtos Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rtos Ref</em>' attribute.
	 * @see #setRtosRef(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getTaskMap_RtosRef()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getRtosRef();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.TaskMap#getRtosRef <em>Rtos Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rtos Ref</em>' attribute.
	 * @see #getRtosRef()
	 * @generated
	 */
	void setRtosRef(StringVar value);

	/**
	 * Returns the value of the '<em><b>Task Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Ref</em>' attribute.
	 * @see #setTaskRef(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getTaskMap_TaskRef()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getTaskRef();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.TaskMap#getTaskRef <em>Task Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Ref</em>' attribute.
	 * @see #getTaskRef()
	 * @generated
	 */
	void setTaskRef(StringVar value);

} // TaskMap
