/**
 */
package com.eu.evidence.rtdruid.oil.xtext.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#getName <em>Name</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#isMultiValue <em>Multi Value</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#isWithAuto <em>With Auto</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#getDescription <em>Description</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#isDefaultAuto <em>Default Auto</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getParameterType()
 * @model abstract="true"
 * @generated
 */
public interface ParameterType extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getParameterType_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see #setDefaultValue(String)
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getParameterType_DefaultValue()
	 * @model
	 * @generated
	 */
	String getDefaultValue();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#getDefaultValue <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' attribute.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(String value);

	/**
	 * Returns the value of the '<em><b>Multi Value</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multi Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multi Value</em>' attribute.
	 * @see #setMultiValue(boolean)
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getParameterType_MultiValue()
	 * @model default="false"
	 * @generated
	 */
	boolean isMultiValue();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#isMultiValue <em>Multi Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multi Value</em>' attribute.
	 * @see #isMultiValue()
	 * @generated
	 */
	void setMultiValue(boolean value);

	/**
	 * Returns the value of the '<em><b>With Auto</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>With Auto</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>With Auto</em>' attribute.
	 * @see #setWithAuto(boolean)
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getParameterType_WithAuto()
	 * @model
	 * @generated
	 */
	boolean isWithAuto();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#isWithAuto <em>With Auto</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>With Auto</em>' attribute.
	 * @see #isWithAuto()
	 * @generated
	 */
	void setWithAuto(boolean value);

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
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getParameterType_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Default Auto</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Auto</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Auto</em>' attribute.
	 * @see #setDefaultAuto(boolean)
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getParameterType_DefaultAuto()
	 * @model default="false"
	 * @generated
	 */
	boolean isDefaultAuto();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#isDefaultAuto <em>Default Auto</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Auto</em>' attribute.
	 * @see #isDefaultAuto()
	 * @generated
	 */
	void setDefaultAuto(boolean value);

} // ParameterType
