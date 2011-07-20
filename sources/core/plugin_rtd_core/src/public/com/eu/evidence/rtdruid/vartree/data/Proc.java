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
 * A representation of the model object '<em><b>Proc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Proc#getMethodRefList <em>Method Ref List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Proc#getMethods <em>Methods</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getProc()
 * @model 
 * @generated
 */
public interface Proc extends Implementation{
	/**
	 * Returns the value of the '<em><b>Methods</b></em>' attribute list.
	 * The list contents are of type {@link rtdruid.vartree.variables.StringVar}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Methods</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' attribute list.
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getProc_Methods()
	 * @model type="rtdruid.vartree.variables.StringVar" dataType="rtdruid.vartree.data.StringVar"
	 * @generated
	 */
  EList getMethods();

	/**
	 * Returns the value of the '<em><b>Method Ref List</b></em>' containment reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.data.MethodRef}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Method Ref List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Method Ref List</em>' containment reference list.
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getProc_MethodRefList()
	 * @model type="rtdruid.vartree.data.MethodRef" containment="true"
	 * @generated
	 */
  EList getMethodRefList();

} // Proc
