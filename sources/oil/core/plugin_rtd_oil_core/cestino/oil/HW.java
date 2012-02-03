/**
 * <copyright>
 * </copyright>
 *
 * $Id: HW.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.data.oil;


import org.eclipse.emf.common.util.EList;

import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HW</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.oil.HW#getRtosList <em>Rtos List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.oil.HW#getName <em>Name</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.oil.HW#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getHW()
 * @model 
 * @generated
 */
public interface HW extends OilObjectWithID {
	/**
	 * Returns the value of the '<em><b>Rtos List</b></em>' reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.data.oil.RTOS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rtos List</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rtos List</em>' reference list.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getHW_RtosList()
	 * @model type="rtdruid.vartree.data.oil.RTOS"
	 * @generated
	 */
	EList<RTOS> getRtosList();

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
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getHW_Name()
	 * @model dataType="rtdruid.vartree.data.oil.StringVar"
	 * @generated
	 */
	StringVar getName();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.oil.HW#getName <em>Name</em>}' attribute.
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
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getHW_Description()
	 * @model dataType="rtdruid.vartree.data.oil.StringVar"
	 * @generated
	 */
	StringVar getDescription();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.oil.HW#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(StringVar value);

} // HW
