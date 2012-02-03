/**
 * <copyright>
 * </copyright>
 *
 * $Id: RTOS.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.data.oil;


import org.eclipse.emf.common.util.EList;

import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>RTOS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.oil.RTOS#getParameterList <em>Parameter List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.oil.RTOS#getName <em>Name</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.oil.RTOS#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getRTOS()
 * @model 
 * @generated
 */
public interface RTOS extends OilObjectWithID {
	/**
	 * Returns the value of the '<em><b>Parameter List</b></em>' reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.data.oil.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter List</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter List</em>' reference list.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getRTOS_ParameterList()
	 * @model type="rtdruid.vartree.data.oil.Parameter"
	 * @generated
	 */
	EList getParameterList();

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
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getRTOS_Name()
	 * @model dataType="rtdruid.vartree.data.oil.StringVar"
	 * @generated
	 */
	StringVar getName();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.oil.RTOS#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(StringVar value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getRTOS_Description()
	 * @model dataType="rtdruid.vartree.data.oil.StringVar"
	 * @generated
	 */
	StringVar getDescription();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.oil.RTOS#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(StringVar value);

} // RTOS
