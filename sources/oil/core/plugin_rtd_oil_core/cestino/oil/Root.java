/**
 * <copyright>
 * </copyright>
 *
 * $Id: Root.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.data.oil;


import org.eclipse.emf.common.util.EList;

import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.oil.Root#getHwList <em>Hw List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.oil.Root#getObjectType <em>Object Type</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.oil.Root#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getRoot()
 * @model 
 * @generated
 */
public interface Root extends OilObjectWithID {
	/**
	 * Returns the value of the '<em><b>Hw List</b></em>' reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.data.oil.HW}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hw List</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hw List</em>' reference list.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getRoot_HwList()
	 * @model type="rtdruid.vartree.data.oil.HW"
	 * @generated
	 */
	EList<HW> getHwList();

	/**
	 * Returns the value of the '<em><b>Object Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Type</em>' attribute.
	 * @see #setObjectType(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getRoot_ObjectType()
	 * @model dataType="rtdruid.vartree.data.oil.StringVar"
	 * @generated
	 */
	StringVar getObjectType();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.oil.Root#getObjectType <em>Object Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Type</em>' attribute.
	 * @see #getObjectType()
	 * @generated
	 */
	void setObjectType(StringVar value);

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
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getRoot_Description()
	 * @model dataType="rtdruid.vartree.data.oil.StringVar"
	 * @generated
	 */
	StringVar getDescription();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.oil.Root#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(StringVar value);

} // Root
