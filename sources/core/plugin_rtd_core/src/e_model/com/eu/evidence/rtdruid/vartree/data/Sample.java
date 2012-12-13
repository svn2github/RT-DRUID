/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.vartree.data;

import com.eu.evidence.rtdruid.vartree.variables.DoubleVar;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sample</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Sample#getProbability <em>Probability</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Sample#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getSample()
 * @model
 * @generated
 */
public interface Sample extends ObjectWithID {
	/**
	 * Returns the value of the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probability</em>' attribute.
	 * @see #setProbability(DoubleVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getSample_Probability()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.DoubleVar"
	 * @generated
	 */
	DoubleVar getProbability();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Sample#getProbability <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probability</em>' attribute.
	 * @see #getProbability()
	 * @generated
	 */
	void setProbability(DoubleVar value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(TimeVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getSample_Value()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.TimeVar" required="true"
	 * @generated
	 */
	TimeVar getValue();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Sample#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(TimeVar value);

} // Sample
