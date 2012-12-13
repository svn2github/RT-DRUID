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
 * A representation of the model object '<em><b>Time Const Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.TimeConstElement#getBoundType <em>Bound Type</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.TimeConstElement#getBoundValue <em>Bound Value</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.TimeConstElement#getFirstEvent <em>First Event</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.TimeConstElement#getSecondEvent <em>Second Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getTimeConstElement()
 * @model
 * @generated
 */
public interface TimeConstElement extends ObjectWithID {
	/**
	 * Returns the value of the '<em><b>Bound Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Type</em>' attribute.
	 * @see #setBoundType(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getTimeConstElement_BoundType()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getBoundType();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.TimeConstElement#getBoundType <em>Bound Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound Type</em>' attribute.
	 * @see #getBoundType()
	 * @generated
	 */
	void setBoundType(StringVar value);

	/**
	 * Returns the value of the '<em><b>Bound Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Value</em>' attribute.
	 * @see #setBoundValue(TimeVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getTimeConstElement_BoundValue()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.TimeVar"
	 * @generated
	 */
	TimeVar getBoundValue();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.TimeConstElement#getBoundValue <em>Bound Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound Value</em>' attribute.
	 * @see #getBoundValue()
	 * @generated
	 */
	void setBoundValue(TimeVar value);

	/**
	 * Returns the value of the '<em><b>First Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Event</em>' attribute.
	 * @see #setFirstEvent(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getTimeConstElement_FirstEvent()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getFirstEvent();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.TimeConstElement#getFirstEvent <em>First Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Event</em>' attribute.
	 * @see #getFirstEvent()
	 * @generated
	 */
	void setFirstEvent(StringVar value);

	/**
	 * Returns the value of the '<em><b>Second Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Event</em>' attribute.
	 * @see #setSecondEvent(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getTimeConstElement_SecondEvent()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getSecondEvent();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.TimeConstElement#getSecondEvent <em>Second Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Event</em>' attribute.
	 * @see #getSecondEvent()
	 * @generated
	 */
	void setSecondEvent(StringVar value);

} // TimeConstElement
