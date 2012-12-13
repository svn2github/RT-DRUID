/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.vartree.data;

import com.eu.evidence.rtdruid.vartree.variables.LongVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Frame</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Frame#getActivationClass <em>Activation Class</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Frame#getActivationRate <em>Activation Rate</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Frame#getActivationType <em>Activation Type</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Frame#getId <em>Id</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Frame#getLength <em>Length</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Frame#getName <em>Name</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Frame#getMessageType <em>Message Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getFrame()
 * @model
 * @generated
 */
public interface Frame extends ObjectWithID {
	/**
	 * Returns the value of the '<em><b>Activation Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activation Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activation Class</em>' attribute.
	 * @see #setActivationClass(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getFrame_ActivationClass()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getActivationClass();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Frame#getActivationClass <em>Activation Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activation Class</em>' attribute.
	 * @see #getActivationClass()
	 * @generated
	 */
	void setActivationClass(StringVar value);

	/**
	 * Returns the value of the '<em><b>Activation Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activation Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activation Rate</em>' attribute.
	 * @see #setActivationRate(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getFrame_ActivationRate()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getActivationRate();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Frame#getActivationRate <em>Activation Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activation Rate</em>' attribute.
	 * @see #getActivationRate()
	 * @generated
	 */
	void setActivationRate(StringVar value);

	/**
	 * Returns the value of the '<em><b>Activation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activation Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activation Type</em>' attribute.
	 * @see #setActivationType(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getFrame_ActivationType()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getActivationType();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Frame#getActivationType <em>Activation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activation Type</em>' attribute.
	 * @see #getActivationType()
	 * @generated
	 */
	void setActivationType(StringVar value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getFrame_Id()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getId();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Frame#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(StringVar value);

	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(LongVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getFrame_Length()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.LongVar"
	 * @generated
	 */
	LongVar getLength();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Frame#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(LongVar value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getFrame_Name()
	 * @model id="true" dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getName();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Frame#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(StringVar value);

	/**
	 * Returns the value of the '<em><b>Message Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Type</em>' attribute.
	 * @see #setMessageType(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getFrame_MessageType()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getMessageType();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Frame#getMessageType <em>Message Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Type</em>' attribute.
	 * @see #getMessageType()
	 * @generated
	 */
	void setMessageType(StringVar value);

} // Frame
