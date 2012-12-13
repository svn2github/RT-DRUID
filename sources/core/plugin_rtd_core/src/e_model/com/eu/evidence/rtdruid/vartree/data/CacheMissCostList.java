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
 * A representation of the model object '<em><b>Cache Miss Cost List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCostList#getCacheMissCostItemsList <em>Cache Miss Cost Items List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCostList#getModeRef <em>Mode Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCacheMissCostList()
 * @model
 * @generated
 */
public interface CacheMissCostList extends ObjectWithID {
	/**
	 * Returns the value of the '<em><b>Cache Miss Cost Items List</b></em>' containment reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.data.CacheMissCost}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cache Miss Cost Items List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cache Miss Cost Items List</em>' containment reference list.
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCacheMissCostList_CacheMissCostItemsList()
	 * @model containment="true"
	 * @generated
	 */
	EList<CacheMissCost> getCacheMissCostItemsList();

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
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCacheMissCostList_ModeRef()
	 * @model id="true" dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getModeRef();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCostList#getModeRef <em>Mode Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode Ref</em>' attribute.
	 * @see #getModeRef()
	 * @generated
	 */
	void setModeRef(StringVar value);

} // CacheMissCostList
