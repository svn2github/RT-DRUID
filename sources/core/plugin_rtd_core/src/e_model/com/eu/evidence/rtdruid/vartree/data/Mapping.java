/**
 * <copyright>
 * </copyright>
 *
 * %W%
 * @version %I% %H%
 */
package com.eu.evidence.rtdruid.vartree.data;

import org.eclipse.emf.common.util.EList;

import com.eu.evidence.rtdruid.vartree.variables.FastTaskToProcVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

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
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Mapping#getInverseTaskToProc <em>Inverse Task To Proc</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getMapping()
 * @model 
 * @generated
 */
public interface Mapping extends ObjectWithID{
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
	 * @model type="rtdruid.vartree.data.ProcMap" containment="true"
	 * @generated
	 */
	EList getProcMapList();

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
	 * @model type="rtdruid.vartree.data.TaskMap" containment="true"
	 * @generated
	 */
	EList getTaskMapList();

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
	 * @model type="rtdruid.vartree.data.VarMap" containment="true"
	 * @generated
	 */
	EList getVarMapList();

	/**
	 * Returns the value of the '<em><b>Inverse Task To Proc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inverse Task To Proc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inverse Task To Proc</em>' attribute.
	 * @see #isSetInverseTaskToProc()
	 * @see #unsetInverseTaskToProc()
	 * @see #setInverseTaskToProc(StringVar)
	 * @see rtdruid.vartree.data.DataPackage#getMapping_InverseTaskToProc()
	 * @model unsettable="true" dataType="rtdruid.vartree.data.StringVar" transient="true" volatile="true" ordered="false"
	 * @generated
	 */
	FastTaskToProcVar getInverseTaskToProc();

	/**
	 * Sets the value of the '{@link rtdruid.vartree.data.Mapping#getInverseTaskToProc <em>Inverse Task To Proc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inverse Task To Proc</em>' attribute.
	 * @see #isSetInverseTaskToProc()
	 * @see #unsetInverseTaskToProc()
	 * @see #getInverseTaskToProc()
	 * @generated
	 */
	void setInverseTaskToProc(FastTaskToProcVar value);

	/**
	 * Unsets the value of the '{@link rtdruid.vartree.data.Mapping#getInverseTaskToProc <em>Inverse Task To Proc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInverseTaskToProc()
	 * @see #getInverseTaskToProc()
	 * @see #setInverseTaskToProc(StringVar)
	 * @generated
	 */
	void unsetInverseTaskToProc();

	/**
	 * Returns whether the value of the '{@link rtdruid.vartree.data.Mapping#getInverseTaskToProc <em>Inverse Task To Proc</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Inverse Task To Proc</em>' attribute is set.
	 * @see #unsetInverseTaskToProc()
	 * @see #getInverseTaskToProc()
	 * @see #setInverseTaskToProc(StringVar)
	 * @generated
	 */
	boolean isSetInverseTaskToProc();

} // Mapping
