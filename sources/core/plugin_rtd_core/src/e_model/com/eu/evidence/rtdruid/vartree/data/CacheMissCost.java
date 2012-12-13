/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.vartree.data;

import com.eu.evidence.rtdruid.vartree.variables.StringVar;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cache Miss Cost</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCost#getBest <em>Best</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCost#getDistribution <em>Distribution</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCost#getRef <em>Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCost#getType <em>Type</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCost#getWorst <em>Worst</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCacheMissCost()
 * @model
 * @generated
 */
public interface CacheMissCost extends ObjectWithID {
	/**
	 * Returns the value of the '<em><b>Best</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Best</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Best</em>' attribute.
	 * @see #setBest(TimeVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCacheMissCost_Best()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.TimeVar"
	 * @generated
	 */
	TimeVar getBest();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCost#getBest <em>Best</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Best</em>' attribute.
	 * @see #getBest()
	 * @generated
	 */
	void setBest(TimeVar value);

	/**
	 * Returns the value of the '<em><b>Distribution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distribution</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distribution</em>' containment reference.
	 * @see #setDistribution(Distribution)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCacheMissCost_Distribution()
	 * @model containment="true"
	 * @generated
	 */
	Distribution getDistribution();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCost#getDistribution <em>Distribution</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distribution</em>' containment reference.
	 * @see #getDistribution()
	 * @generated
	 */
	void setDistribution(Distribution value);

	/**
	 * Returns the value of the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' attribute.
	 * @see #setRef(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCacheMissCost_Ref()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getRef();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCost#getRef <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' attribute.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(StringVar value);

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
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCacheMissCost_Type()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getType();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCost#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(StringVar value);

	/**
	 * Returns the value of the '<em><b>Worst</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Worst</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Worst</em>' attribute.
	 * @see #setWorst(TimeVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCacheMissCost_Worst()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.TimeVar"
	 * @generated
	 */
	TimeVar getWorst();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCost#getWorst <em>Worst</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Worst</em>' attribute.
	 * @see #getWorst()
	 * @generated
	 */
	void setWorst(TimeVar value);

} // CacheMissCost
