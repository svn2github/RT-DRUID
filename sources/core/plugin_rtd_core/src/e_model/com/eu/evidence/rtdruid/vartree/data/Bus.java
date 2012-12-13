/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.vartree.data;

import com.eu.evidence.rtdruid.vartree.variables.LongVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bus</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Bus#getName <em>Name</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Bus#getSpeed <em>Speed</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Bus#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getBus()
 * @model
 * @generated
 */
public interface Bus extends ObjectWithID {
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
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getBus_Name()
	 * @model id="true" dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getName();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Bus#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(StringVar value);

	/**
	 * Returns the value of the '<em><b>Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Speed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Speed</em>' attribute.
	 * @see #setSpeed(LongVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getBus_Speed()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.LongVar"
	 * @generated
	 */
	LongVar getSpeed();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Bus#getSpeed <em>Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Speed</em>' attribute.
	 * @see #getSpeed()
	 * @generated
	 */
	void setSpeed(LongVar value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getBus_Type()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getType();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Bus#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(StringVar value);

} // Bus
