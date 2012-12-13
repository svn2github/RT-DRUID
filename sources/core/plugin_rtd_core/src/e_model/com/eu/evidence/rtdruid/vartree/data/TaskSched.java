/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.vartree.data;

import com.eu.evidence.rtdruid.vartree.variables.BooleanVar;
import com.eu.evidence.rtdruid.vartree.variables.DoubleVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Sched</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.TaskSched#getCDelta <em>CDelta</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.TaskSched#getResponseTime <em>Response Time</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.TaskSched#getSchedulable <em>Schedulable</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.TaskSched#getTaskRef <em>Task Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.TaskSched#getTDelta <em>TDelta</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.TaskSched#getUtilization <em>Utilization</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getTaskSched()
 * @model
 * @generated
 */
public interface TaskSched extends ObjectWithID {
	/**
	 * Returns the value of the '<em><b>CDelta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CDelta</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>CDelta</em>' attribute.
	 * @see #setCDelta(DoubleVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getTaskSched_CDelta()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.DoubleVar"
	 * @generated
	 */
	DoubleVar getCDelta();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.TaskSched#getCDelta <em>CDelta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>CDelta</em>' attribute.
	 * @see #getCDelta()
	 * @generated
	 */
	void setCDelta(DoubleVar value);

	/**
	 * Returns the value of the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Response Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response Time</em>' attribute.
	 * @see #setResponseTime(TimeVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getTaskSched_ResponseTime()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.TimeVar"
	 * @generated
	 */
	TimeVar getResponseTime();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.TaskSched#getResponseTime <em>Response Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Response Time</em>' attribute.
	 * @see #getResponseTime()
	 * @generated
	 */
	void setResponseTime(TimeVar value);

	/**
	 * Returns the value of the '<em><b>Schedulable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedulable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedulable</em>' attribute.
	 * @see #setSchedulable(BooleanVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getTaskSched_Schedulable()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.BooleanVar"
	 * @generated
	 */
	BooleanVar getSchedulable();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.TaskSched#getSchedulable <em>Schedulable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedulable</em>' attribute.
	 * @see #getSchedulable()
	 * @generated
	 */
	void setSchedulable(BooleanVar value);

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
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getTaskSched_TaskRef()
	 * @model id="true" dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getTaskRef();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.TaskSched#getTaskRef <em>Task Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Ref</em>' attribute.
	 * @see #getTaskRef()
	 * @generated
	 */
	void setTaskRef(StringVar value);

	/**
	 * Returns the value of the '<em><b>TDelta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TDelta</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TDelta</em>' attribute.
	 * @see #setTDelta(DoubleVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getTaskSched_TDelta()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.DoubleVar"
	 * @generated
	 */
	DoubleVar getTDelta();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.TaskSched#getTDelta <em>TDelta</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>TDelta</em>' attribute.
	 * @see #getTDelta()
	 * @generated
	 */
	void setTDelta(DoubleVar value);

	/**
	 * Returns the value of the '<em><b>Utilization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utilization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utilization</em>' attribute.
	 * @see #setUtilization(DoubleVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getTaskSched_Utilization()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.DoubleVar"
	 * @generated
	 */
	DoubleVar getUtilization();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.TaskSched#getUtilization <em>Utilization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Utilization</em>' attribute.
	 * @see #getUtilization()
	 * @generated
	 */
	void setUtilization(DoubleVar value);

} // TaskSched
