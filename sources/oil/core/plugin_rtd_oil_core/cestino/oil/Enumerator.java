/**
 * <copyright>
 * </copyright>
 *
 * $Id: Enumerator.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.data.oil;


import org.eclipse.emf.common.util.EList;

import com.eu.evidence.rtdruid.vartree.variables.IntegerVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumerator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.oil.Enumerator#getParameterList <em>Parameter List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.oil.Enumerator#getValue <em>Value</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.oil.Enumerator#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getEnumerator()
 * @model 
 * @generated
 */
public interface Enumerator extends OilObjectWithID{
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
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getEnumerator_ParameterList()
	 * @model type="rtdruid.vartree.data.oil.Parameter"
	 * @generated
	 */
	EList getParameterList();

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getEnumerator_Value()
	 * @model dataType="rtdruid.vartree.data.oil.StringVar"
	 * @generated
	 */
	StringVar getValue();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.oil.Enumerator#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(StringVar value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(IntegerVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getEnumerator_Index()
	 * @model dataType="rtdruid.vartree.data.oil.IntegerVar"
	 * @generated
	 */
	IntegerVar getIndex();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.oil.Enumerator#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(IntegerVar value);

} // Enumerator
