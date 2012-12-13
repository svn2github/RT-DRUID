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
 * A representation of the model object '<em><b>Resource Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.ResourceRef#getModeRef <em>Mode Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.ResourceRef#getResourceMethodRef <em>Resource Method Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getResourceRef()
 * @model
 * @generated
 */
public interface ResourceRef extends ObjectWithID {
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
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getResourceRef_ModeRef()
	 * @model id="true" dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getModeRef();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.ResourceRef#getModeRef <em>Mode Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode Ref</em>' attribute.
	 * @see #getModeRef()
	 * @generated
	 */
	void setModeRef(StringVar value);

	/**
	 * Returns the value of the '<em><b>Resource Method Ref</b></em>' attribute list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.variables.StringVar}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Method Ref</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Method Ref</em>' attribute list.
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getResourceRef_ResourceMethodRef()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	EList<StringVar> getResourceMethodRef();

} // ResourceRef
