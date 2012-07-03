/**
 */
package com.eu.evidence.rtdruid.oil.xtext.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Impl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.oil.xtext.model.OilObjectImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.xtext.model.OilObjectImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.xtext.model.OilObjectImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getOilObjectImpl()
 * @model
 * @generated
 */
public interface OilObjectImpl extends EObject {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getOilObjectImpl_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterType> getParameters();

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
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getOilObjectImpl_Type()
	 * @model
	 * @generated
	 */
	ObjectType getType();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilObjectImpl#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ObjectType
	 * @see #getType()
	 * @generated
	 */
	void setType(ObjectType value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getOilObjectImpl_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilObjectImpl#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // OilObjectImpl
