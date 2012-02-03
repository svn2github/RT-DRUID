/**
 * <copyright>
 * </copyright>
 *
 * $Id: Value.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.data.oil;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.oil.Value#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getValue()
 * @model 
 * @generated
 */
public interface Value extends Parameter {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.variables.StringDescrVar}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage#getValue_Values()
	 * @model type="rtdruid.vartree.variables.StringDescrVar" dataType="rtdruid.vartree.data.oil.VarWithDescrVar"
	 * @generated
	 */
	EList getValues();

} // Value
