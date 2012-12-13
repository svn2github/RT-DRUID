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
 * A representation of the model object '<em><b>Provided Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.ProvidedInterface#getLocalMethodRef <em>Local Method Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.ProvidedInterface#getLocalObjectRef <em>Local Object Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.ProvidedInterface#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getProvidedInterface()
 * @model
 * @generated
 */
public interface ProvidedInterface extends ObjectWithID {
	/**
	 * Returns the value of the '<em><b>Local Method Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Method Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Method Ref</em>' attribute.
	 * @see #setLocalMethodRef(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getProvidedInterface_LocalMethodRef()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getLocalMethodRef();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.ProvidedInterface#getLocalMethodRef <em>Local Method Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Method Ref</em>' attribute.
	 * @see #getLocalMethodRef()
	 * @generated
	 */
	void setLocalMethodRef(StringVar value);

	/**
	 * Returns the value of the '<em><b>Local Object Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Object Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Object Ref</em>' attribute.
	 * @see #setLocalObjectRef(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getProvidedInterface_LocalObjectRef()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getLocalObjectRef();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.ProvidedInterface#getLocalObjectRef <em>Local Object Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Object Ref</em>' attribute.
	 * @see #getLocalObjectRef()
	 * @generated
	 */
	void setLocalObjectRef(StringVar value);

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
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getProvidedInterface_Name()
	 * @model id="true" dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getName();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.ProvidedInterface#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(StringVar value);

} // ProvidedInterface
