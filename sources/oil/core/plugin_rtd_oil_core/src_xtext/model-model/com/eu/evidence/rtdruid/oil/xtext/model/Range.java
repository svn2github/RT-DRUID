/**
 */
package com.eu.evidence.rtdruid.oil.xtext.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.oil.xtext.model.Range#getMin <em>Min</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.xtext.model.Range#getMax <em>Max</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getRange()
 * @model
 * @generated
 */
public interface Range extends ValidValues {
	/**
	 * Returns the value of the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min</em>' attribute.
	 * @see #setMin(String)
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getRange_Min()
	 * @model
	 * @generated
	 */
	String getMin();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.oil.xtext.model.Range#getMin <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min</em>' attribute.
	 * @see #getMin()
	 * @generated
	 */
	void setMin(String value);

	/**
	 * Returns the value of the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max</em>' attribute.
	 * @see #setMax(String)
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getRange_Max()
	 * @model
	 * @generated
	 */
	String getMax();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.oil.xtext.model.Range#getMax <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max</em>' attribute.
	 * @see #getMax()
	 * @generated
	 */
	void setMax(String value);

} // Range
