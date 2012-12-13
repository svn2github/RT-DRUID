/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.vartree.data;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Mapping#getProcMapList <em>Proc Map List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Mapping#getTaskMapList <em>Task Map List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Mapping#getVarMapList <em>Var Map List</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getMapping()
 * @model
 * @generated
 */
public interface Mapping extends ObjectWithID {
	/**
	 * Returns the value of the '<em><b>Proc Map List</b></em>' containment reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.data.ProcMap}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proc Map List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proc Map List</em>' containment reference list.
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getMapping_ProcMapList()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProcMap> getProcMapList();

	/**
	 * Returns the value of the '<em><b>Task Map List</b></em>' containment reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.data.TaskMap}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Map List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Map List</em>' containment reference list.
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getMapping_TaskMapList()
	 * @model containment="true"
	 * @generated
	 */
	EList<TaskMap> getTaskMapList();

	/**
	 * Returns the value of the '<em><b>Var Map List</b></em>' containment reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.data.VarMap}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Map List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Map List</em>' containment reference list.
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getMapping_VarMapList()
	 * @model containment="true"
	 * @generated
	 */
	EList<VarMap> getVarMapList();

} // Mapping
