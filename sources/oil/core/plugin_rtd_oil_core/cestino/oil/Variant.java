/**
 * <copyright>
 * </copyright>
 *
 * $Id: Variant.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.data.oil;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.oil.Variant#getEnumeratorList <em>Enumerator List</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getVariant()
 * @model 
 * @generated
 */
public interface Variant extends Parameter {
	/**
	 * Returns the value of the '<em><b>Enumerator List</b></em>' reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.data.oil.Enumerator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumerator List</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumerator List</em>' reference list.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getVariant_EnumeratorList()
	 * @model type="rtdruid.vartree.data.oil.Enumerator"
	 * @generated
	 */
	EList getEnumeratorList();

} // Variant
