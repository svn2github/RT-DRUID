/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.vartree.data;

import com.eu.evidence.rtdruid.vartree.variables.DoubleVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Distribution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Distribution#getAvg <em>Avg</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Distribution#getSampleList <em>Sample List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Distribution#getType <em>Type</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Distribution#getVariance <em>Variance</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getDistribution()
 * @model
 * @generated
 */
public interface Distribution extends ObjectWithID {
	/**
	 * Returns the value of the '<em><b>Avg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Avg</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Avg</em>' attribute.
	 * @see #setAvg(TimeVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getDistribution_Avg()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.TimeVar"
	 * @generated
	 */
	TimeVar getAvg();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Distribution#getAvg <em>Avg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Avg</em>' attribute.
	 * @see #getAvg()
	 * @generated
	 */
	void setAvg(TimeVar value);

	/**
	 * Returns the value of the '<em><b>Sample List</b></em>' containment reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.data.Sample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sample List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sample List</em>' containment reference list.
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getDistribution_SampleList()
	 * @model containment="true"
	 * @generated
	 */
	EList<Sample> getSampleList();

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
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getDistribution_Type()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getType();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Distribution#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(StringVar value);

	/**
	 * Returns the value of the '<em><b>Variance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variance</em>' attribute.
	 * @see #setVariance(DoubleVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getDistribution_Variance()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.DoubleVar"
	 * @generated
	 */
	DoubleVar getVariance();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Distribution#getVariance <em>Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variance</em>' attribute.
	 * @see #getVariance()
	 * @generated
	 */
	void setVariance(DoubleVar value);

} // Distribution
