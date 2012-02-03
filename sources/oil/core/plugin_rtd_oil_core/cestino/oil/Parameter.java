/**
 * <copyright>
 * </copyright>
 *
 * $Id: Parameter.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.data.oil;

import com.eu.evidence.rtdruid.vartree.variables.BooleanVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.oil.Parameter#getName <em>Name</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.oil.Parameter#getType <em>Type</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.oil.Parameter#getMultiValues <em>Multi Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getParameter()
 * @model abstract="true"
 * @generated
 */
public interface Parameter extends OilObjectWithID{
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
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getParameter_Name()
	 * @model dataType="rtdruid.vartree.data.oil.StringVar"
	 * @generated
	 */
	StringVar getName();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.oil.Parameter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(StringVar value);

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
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getParameter_Type()
	 * @model dataType="rtdruid.vartree.data.oil.StringVar"
	 * @generated
	 */
	StringVar getType();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.oil.Parameter#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(StringVar value);

	/**
	 * Returns the value of the '<em><b>Multi Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multi Values</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multi Values</em>' attribute.
	 * @see #setMultiValues(BooleanVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getParameter_MultiValues()
	 * @model dataType="rtdruid.vartree.data.oil.BooleanVar"
	 * @generated
	 */
	BooleanVar getMultiValues();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.oil.Parameter#getMultiValues <em>Multi Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multi Values</em>' attribute.
	 * @see #getMultiValues()
	 * @generated
	 */
	void setMultiValues(BooleanVar value);

} // Parameter
