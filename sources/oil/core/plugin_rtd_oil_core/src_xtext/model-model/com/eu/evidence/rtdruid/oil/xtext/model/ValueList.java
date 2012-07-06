/**
 */
package com.eu.evidence.rtdruid.oil.xtext.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.oil.xtext.model.ValueList#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getValueList()
 * @model
 * @generated
 */
public interface ValueList extends ValidValues {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getValueList_Values()
	 * @model
	 * @generated
	 */
	EList<String> getValues();

} // ValueList
