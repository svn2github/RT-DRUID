/**
 * <copyright>
 * </copyright>
 *
 * %W%
 * @version %I% %H%
 */
package com.eu.evidence.rtdruid.vartree.data;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Architectural</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Architectural#getBusList <em>Bus List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Architectural#getEcuList <em>Ecu List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Architectural#getFrameList <em>Frame List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Architectural#getMutexList <em>Mutex List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Architectural#getResourceList <em>Resource List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Architectural#getSignalList <em>Signal List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Architectural#getTaskList <em>Task List</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getArchitectural()
 * @model 
 * @generated
 */
public interface Architectural extends ObjectWithID{
	/**
	 * Returns the value of the '<em><b>Bus List</b></em>' containment reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.data.Bus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bus List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bus List</em>' containment reference list.
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getArchitectural_BusList()
	 * @model type="rtdruid.vartree.data.Bus" containment="true"
	 * @generated
	 */
	EList getBusList();

	/**
	 * Returns the value of the '<em><b>Ecu List</b></em>' containment reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.data.Ecu}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecu List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecu List</em>' containment reference list.
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getArchitectural_EcuList()
	 * @model type="rtdruid.vartree.data.Ecu" containment="true" required="true"
	 * @generated
	 */
	EList getEcuList();

	/**
	 * Returns the value of the '<em><b>Frame List</b></em>' containment reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.data.Frame}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frame List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frame List</em>' containment reference list.
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getArchitectural_FrameList()
	 * @model type="rtdruid.vartree.data.Frame" containment="true"
	 * @generated
	 */
	EList getFrameList();

	/**
	 * Returns the value of the '<em><b>Mutex List</b></em>' containment reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.data.Mutex}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mutex List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mutex List</em>' containment reference list.
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getArchitectural_MutexList()
	 * @model type="rtdruid.vartree.data.Mutex" containment="true"
	 * @generated
	 */
	EList getMutexList();

	/**
	 * Returns the value of the '<em><b>Resource List</b></em>' containment reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.data.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource List</em>' containment reference list.
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getArchitectural_ResourceList()
	 * @model type="rtdruid.vartree.data.Resource" containment="true"
	 * @generated
	 */
	EList getResourceList();

	/**
	 * Returns the value of the '<em><b>Signal List</b></em>' containment reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.data.Signal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signal List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signal List</em>' containment reference list.
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getArchitectural_SignalList()
	 * @model type="rtdruid.vartree.data.Signal" containment="true"
	 * @generated
	 */
	EList getSignalList();

	/**
	 * Returns the value of the '<em><b>Task List</b></em>' containment reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.data.Task}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task List</em>' containment reference list.
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getArchitectural_TaskList()
	 * @model type="rtdruid.vartree.data.Task" containment="true" required="true"
	 * @generated
	 */
	EList getTaskList();

} // Architectural
