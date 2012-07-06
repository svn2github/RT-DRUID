/**
 */
package com.eu.evidence.rtdruid.oil.xtext.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.oil.xtext.model.ValueType#getType <em>Type</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.xtext.model.ValueType#getValidValues <em>Valid Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getValueType()
 * @model
 * @generated
 */
public interface ValueType extends ParameterType {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.eu.evidence.rtdruid.oil.xtext.model.VType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.VType
	 * @see #setType(VType)
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getValueType_Type()
	 * @model
	 * @generated
	 */
	VType getType();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.oil.xtext.model.ValueType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.VType
	 * @see #getType()
	 * @generated
	 */
	void setType(VType value);

	/**
	 * Returns the value of the '<em><b>Valid Values</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valid Values</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valid Values</em>' containment reference.
	 * @see #setValidValues(ValidValues)
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getValueType_ValidValues()
	 * @model containment="true"
	 * @generated
	 */
	ValidValues getValidValues();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.oil.xtext.model.ValueType#getValidValues <em>Valid Values</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valid Values</em>' containment reference.
	 * @see #getValidValues()
	 * @generated
	 */
	void setValidValues(ValidValues value);

} // ValueType
