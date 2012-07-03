/**
 */
package com.eu.evidence.rtdruid.oil.xtext.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.oil.xtext.model.ReferenceType#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getReferenceType()
 * @model
 * @generated
 */
public interface ReferenceType extends ParameterType {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.eu.evidence.rtdruid.oil.xtext.model.ObjectType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ObjectType
	 * @see #setType(ObjectType)
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getReferenceType_Type()
	 * @model
	 * @generated
	 */
	ObjectType getType();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.oil.xtext.model.ReferenceType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ObjectType
	 * @see #getType()
	 * @generated
	 */
	void setType(ObjectType value);

} // ReferenceType
