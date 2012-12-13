/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.vartree.data;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Annotation#getExecTimeLists <em>Exec Time Lists</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Annotation#getCacheMissCostLists <em>Cache Miss Cost Lists</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getAnnotation()
 * @model
 * @generated
 */
public interface Annotation extends ObjectWithID {
	/**
	 * Returns the value of the '<em><b>Exec Time Lists</b></em>' containment reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.data.ExecTimeList}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exec Time Lists</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exec Time Lists</em>' containment reference list.
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getAnnotation_ExecTimeLists()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExecTimeList> getExecTimeLists();

	/**
	 * Returns the value of the '<em><b>Cache Miss Cost Lists</b></em>' containment reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.data.CacheMissCostList}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cache Miss Cost Lists</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cache Miss Cost Lists</em>' containment reference list.
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getAnnotation_CacheMissCostLists()
	 * @model containment="true"
	 * @generated
	 */
	EList<CacheMissCostList> getCacheMissCostLists();

} // Annotation
