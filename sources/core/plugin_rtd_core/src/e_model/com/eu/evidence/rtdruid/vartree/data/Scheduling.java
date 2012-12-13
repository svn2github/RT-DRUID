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
 * A representation of the model object '<em><b>Scheduling</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Scheduling#getModeRef <em>Mode Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Scheduling#getPreemptionGroupName <em>Preemption Group Name</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Scheduling#getPriority <em>Priority</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Scheduling#getThreshold <em>Threshold</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Scheduling#getStack <em>Stack</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getScheduling()
 * @model
 * @generated
 */
public interface Scheduling extends ObjectWithID {
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
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getScheduling_ModeRef()
	 * @model id="true" dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getModeRef();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Scheduling#getModeRef <em>Mode Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode Ref</em>' attribute.
	 * @see #getModeRef()
	 * @generated
	 */
	void setModeRef(StringVar value);

	/**
	 * Returns the value of the '<em><b>Preemption Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preemption Group Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preemption Group Name</em>' attribute.
	 * @see #setPreemptionGroupName(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getScheduling_PreemptionGroupName()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getPreemptionGroupName();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Scheduling#getPreemptionGroupName <em>Preemption Group Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preemption Group Name</em>' attribute.
	 * @see #getPreemptionGroupName()
	 * @generated
	 */
	void setPreemptionGroupName(StringVar value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(IntegerVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getScheduling_Priority()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.IntegerVar"
	 * @generated
	 */
	IntegerVar getPriority();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Scheduling#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(IntegerVar value);

	/**
	 * Returns the value of the '<em><b>Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threshold</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threshold</em>' attribute.
	 * @see #setThreshold(IntegerVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getScheduling_Threshold()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.IntegerVar"
	 * @generated
	 */
	IntegerVar getThreshold();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Scheduling#getThreshold <em>Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Threshold</em>' attribute.
	 * @see #getThreshold()
	 * @generated
	 */
	void setThreshold(IntegerVar value);

	/**
	 * Returns the value of the '<em><b>Stack</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stack</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stack</em>' attribute.
	 * @see #setStack(IntegerVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getScheduling_Stack()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.IntegerVar"
	 * @generated
	 */
	IntegerVar getStack();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Scheduling#getStack <em>Stack</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stack</em>' attribute.
	 * @see #getStack()
	 * @generated
	 */
	void setStack(IntegerVar value);

} // Scheduling
