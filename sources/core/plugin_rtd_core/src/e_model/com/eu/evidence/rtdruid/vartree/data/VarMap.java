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
 * A representation of the model object '<em><b>Var Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.VarMap#getBusRef <em>Bus Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.VarMap#getFrameRef <em>Frame Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.VarMap#getModeRef <em>Mode Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.VarMap#getMutexRef <em>Mutex Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.VarMap#getVarRef <em>Var Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getVarMap()
 * @model
 * @generated
 */
public interface VarMap extends ObjectWithID {
	/**
	 * Returns the value of the '<em><b>Bus Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bus Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bus Ref</em>' attribute.
	 * @see #setBusRef(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getVarMap_BusRef()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getBusRef();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.VarMap#getBusRef <em>Bus Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bus Ref</em>' attribute.
	 * @see #getBusRef()
	 * @generated
	 */
	void setBusRef(StringVar value);

	/**
	 * Returns the value of the '<em><b>Frame Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frame Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frame Ref</em>' attribute.
	 * @see #setFrameRef(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getVarMap_FrameRef()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getFrameRef();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.VarMap#getFrameRef <em>Frame Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frame Ref</em>' attribute.
	 * @see #getFrameRef()
	 * @generated
	 */
	void setFrameRef(StringVar value);

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
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getVarMap_ModeRef()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getModeRef();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.VarMap#getModeRef <em>Mode Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode Ref</em>' attribute.
	 * @see #getModeRef()
	 * @generated
	 */
	void setModeRef(StringVar value);

	/**
	 * Returns the value of the '<em><b>Mutex Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mutex Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mutex Ref</em>' attribute.
	 * @see #setMutexRef(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getVarMap_MutexRef()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getMutexRef();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.VarMap#getMutexRef <em>Mutex Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mutex Ref</em>' attribute.
	 * @see #getMutexRef()
	 * @generated
	 */
	void setMutexRef(StringVar value);

	/**
	 * Returns the value of the '<em><b>Var Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Ref</em>' attribute.
	 * @see #setVarRef(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getVarMap_VarRef()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getVarRef();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.VarMap#getVarRef <em>Var Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Ref</em>' attribute.
	 * @see #getVarRef()
	 * @generated
	 */
	void setVarRef(StringVar value);

} // VarMap
