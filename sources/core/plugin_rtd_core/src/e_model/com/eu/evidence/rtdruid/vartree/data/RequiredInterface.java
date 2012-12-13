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
 * A representation of the model object '<em><b>Required Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.RequiredInterface#getExternalMethodRef <em>External Method Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.RequiredInterface#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getRequiredInterface()
 * @model
 * @generated
 */
public interface RequiredInterface extends ObjectWithID {
	/**
	 * Returns the value of the '<em><b>External Method Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Method Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Method Ref</em>' attribute.
	 * @see #setExternalMethodRef(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getRequiredInterface_ExternalMethodRef()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getExternalMethodRef();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.RequiredInterface#getExternalMethodRef <em>External Method Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External Method Ref</em>' attribute.
	 * @see #getExternalMethodRef()
	 * @generated
	 */
	void setExternalMethodRef(StringVar value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getRequiredInterface_Name()
	 * @model id="true" dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getName();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.RequiredInterface#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(StringVar value);

} // RequiredInterface
