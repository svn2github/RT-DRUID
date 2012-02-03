/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.vartree.data;

import com.eu.evidence.rtdruid.vartree.variables.DoubleVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cpu</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Cpu#getName <em>Name</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Cpu#getModel <em>Model</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Cpu#getRtos <em>Rtos</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Cpu#getOsApplication <em>Os Application</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Cpu#getSpeed <em>Speed</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Cpu#getSpeed_Unit <em>Speed Unit</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.Cpu#getBinaryImage <em>Binary Image</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCpu()
 * @model
 * @generated
 */
public interface Cpu extends ObjectWithID {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCpu_Name()
	 * @model id="true" dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getName();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Cpu#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(StringVar value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' attribute.
	 * @see #setModel(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCpu_Model()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getModel();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Cpu#getModel <em>Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' attribute.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(StringVar value);

	/**
	 * Returns the value of the '<em><b>Rtos</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rtos</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rtos</em>' containment reference.
	 * @see #setRtos(Rtos)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCpu_Rtos()
	 * @model containment="true"
	 * @generated
	 */
	Rtos getRtos();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Cpu#getRtos <em>Rtos</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rtos</em>' containment reference.
	 * @see #getRtos()
	 * @generated
	 */
	void setRtos(Rtos value);

	/**
	 * Returns the value of the '<em><b>Os Application</b></em>' containment reference list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.data.OsApplication}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Os Application</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Os Application</em>' containment reference list.
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCpu_OsApplication()
	 * @model containment="true"
	 * @generated
	 */
	EList<OsApplication> getOsApplication();

	/**
	 * Returns the value of the '<em><b>Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Speed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Speed</em>' attribute.
	 * @see #setSpeed(DoubleVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCpu_Speed()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.DoubleVar"
	 * @generated
	 */
	DoubleVar getSpeed();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Cpu#getSpeed <em>Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Speed</em>' attribute.
	 * @see #getSpeed()
	 * @generated
	 */
	void setSpeed(DoubleVar value);

	/**
	 * Returns the value of the '<em><b>Speed Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Speed Unit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Speed Unit</em>' attribute.
	 * @see #setSpeed_Unit(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCpu_Speed_Unit()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getSpeed_Unit();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Cpu#getSpeed_Unit <em>Speed Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Speed Unit</em>' attribute.
	 * @see #getSpeed_Unit()
	 * @generated
	 */
	void setSpeed_Unit(StringVar value);

	/**
	 * Returns the value of the '<em><b>Binary Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binary Image</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binary Image</em>' attribute.
	 * @see #setBinaryImage(StringVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getCpu_BinaryImage()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	StringVar getBinaryImage();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.Cpu#getBinaryImage <em>Binary Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binary Image</em>' attribute.
	 * @see #getBinaryImage()
	 * @generated
	 */
	void setBinaryImage(StringVar value);

} // Cpu
