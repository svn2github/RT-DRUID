/**
 * <copyright>
 * </copyright>
 *
 * %W%
 * @version %I% %H%
 */
package com.eu.evidence.rtdruid.vartree.data;


import org.eclipse.emf.common.util.EList;

import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exec Time List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.ExecTimeList#getExecTimeItemsList <em>Exec Time Items List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.ExecTimeList#getModeRef <em>Mode Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getExecTimeList()
 * @model 
 * @generated
 */
public interface ExecTimeList extends ObjectWithID{
	/**
	 * Returns the value of the '<em><b>Exec Time Items List</b></em>' containment reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.data.ExecTime}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exec Time Items List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exec Time Items List</em>' containment reference list.
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getExecTimeList_ExecTimeItemsList()
	 * @model type="rtdruid.vartree.data.ExecTime" containment="true"
	 * @generated
	 */
	EList getExecTimeItemsList();

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
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getExecTimeList_ModeRef()
	 * @model dataType="rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
  StringVar getModeRef();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.ExecTimeList#getModeRef <em>Mode Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode Ref</em>' attribute.
	 * @see #getModeRef()
	 * @generated
	 */
  void setModeRef(StringVar value);

} // ExecTimeList
