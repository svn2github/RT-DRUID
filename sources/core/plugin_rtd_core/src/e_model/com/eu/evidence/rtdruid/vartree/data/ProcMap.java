/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.vartree.data;

import com.eu.evidence.rtdruid.vartree.variables.IntegerVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Proc Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.ProcMap#getModeRef <em>Mode Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.ProcMap#getOrder <em>Order</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.ProcMap#getProcRef <em>Proc Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.ProcMap#getTaskRef <em>Task Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.ProcMap#getOnceEveryK <em>Once Every K</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.ProcMap#getMethodRefName <em>Method Ref Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getProcMap()
 * @model
 * @generated
 */
public interface ProcMap extends ObjectWithID {
	/**
	 * Returns the value of the '<em><b>Mode Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode Ref</em>' attribute.
	 * @see #setModeRef(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getProcMap_ModeRef()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getModeRef();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.ProcMap#getModeRef <em>Mode Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode Ref</em>' attribute.
	 * @see #getModeRef()
	 * @generated
	 */
	void setModeRef(StringVar value);

	/**
	 * Returns the value of the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order</em>' attribute.
	 * @see #setOrder(IntegerVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getProcMap_Order()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.IntegerVar"
	 * @generated
	 */
	IntegerVar getOrder();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.ProcMap#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order</em>' attribute.
	 * @see #getOrder()
	 * @generated
	 */
	void setOrder(IntegerVar value);

	/**
	 * Returns the value of the '<em><b>Proc Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proc Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proc Ref</em>' attribute.
	 * @see #setProcRef(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getProcMap_ProcRef()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getProcRef();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.ProcMap#getProcRef <em>Proc Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proc Ref</em>' attribute.
	 * @see #getProcRef()
	 * @generated
	 */
	void setProcRef(StringVar value);

	/**
	 * Returns the value of the '<em><b>Task Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Ref</em>' attribute.
	 * @see #setTaskRef(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getProcMap_TaskRef()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getTaskRef();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.ProcMap#getTaskRef <em>Task Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Ref</em>' attribute.
	 * @see #getTaskRef()
	 * @generated
	 */
	void setTaskRef(StringVar value);

	/**
	 * Returns the value of the '<em><b>Once Every K</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Once Every K</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Once Every K</em>' attribute.
	 * @see #setOnceEveryK(IntegerVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getProcMap_OnceEveryK()
	 * @model default="1" dataType="com.eu.evidence.rtdruid.vartree.data.IntegerVar"
	 * @generated
	 */
	IntegerVar getOnceEveryK();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.ProcMap#getOnceEveryK <em>Once Every K</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Once Every K</em>' attribute.
	 * @see #getOnceEveryK()
	 * @generated
	 */
	void setOnceEveryK(IntegerVar value);

	/**
	 * Returns the value of the '<em><b>Method Ref Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Ref Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method Ref Name</em>' attribute.
	 * @see #setMethodRefName(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getProcMap_MethodRefName()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getMethodRefName();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.ProcMap#getMethodRefName <em>Method Ref Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method Ref Name</em>' attribute.
	 * @see #getMethodRefName()
	 * @generated
	 */
	void setMethodRefName(StringVar value);

} // ProcMap
