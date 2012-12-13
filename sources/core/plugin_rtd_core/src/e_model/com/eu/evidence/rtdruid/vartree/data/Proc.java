/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.vartree.data;

import com.eu.evidence.rtdruid.vartree.variables.StringVar;

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
public interface Proc extends Implementation {
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
	 * @model containment="true"
	 * @generated
	 */
	EList<MethodRef> getMethodRefList();

	/**
	 * Returns the value of the '<em><b>Methods</b></em>' attribute list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.variables.StringVar}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' attribute list.
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getProc_Methods()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	EList<StringVar> getMethods();

} // Proc
