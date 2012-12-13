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
 * A representation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Trigger#getMethodRefList <em>Method Ref List</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getTrigger()
 * @model
 * @generated
 */
public interface Trigger extends SystemImplementation {
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
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getTrigger_MethodRefList()
	 * @model containment="true"
	 * @generated
	 */
	EList<MethodRef> getMethodRefList();

} // Trigger
