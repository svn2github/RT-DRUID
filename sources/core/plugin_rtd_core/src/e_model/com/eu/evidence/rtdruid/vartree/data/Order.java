/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.vartree.data;

import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Order</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Order#getFirstEvent <em>First Event</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Order#getSecondEvent <em>Second Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getOrder()
 * @model
 * @generated
 */
public interface Order extends ObjectWithID {
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
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getOrder_FirstEvent()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getFirstEvent();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Order#getFirstEvent <em>First Event</em>}' attribute.
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
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getOrder_SecondEvent()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getSecondEvent();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Order#getSecondEvent <em>Second Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Event</em>' attribute.
	 * @see #getSecondEvent()
	 * @generated
	 */
	void setSecondEvent(StringVar value);

} // Order
