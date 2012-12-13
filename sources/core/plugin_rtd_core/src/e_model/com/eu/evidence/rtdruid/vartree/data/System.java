/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.vartree.data;

import com.eu.evidence.rtdruid.vartree.variables.StringVar;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.System#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.System#getArchitectural <em>Architectural</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.System#getFunctional <em>Functional</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.System#getMapping <em>Mapping</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.System#getModes <em>Modes</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.System#getName <em>Name</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.System#getSchedulability <em>Schedulability</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.System#getXTC_Cookie <em>XTC Cookie</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends ObjectWithID {
	/**
	 * Returns the value of the '<em><b>Annotation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation</em>' containment reference.
	 * @see #setAnnotation(Annotation)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getSystem_Annotation()
	 * @model containment="true"
	 * @generated
	 */
	Annotation getAnnotation();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.System#getAnnotation <em>Annotation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotation</em>' containment reference.
	 * @see #getAnnotation()
	 * @generated
	 */
	void setAnnotation(Annotation value);

	/**
	 * Returns the value of the '<em><b>Architectural</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Architectural</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Architectural</em>' containment reference.
	 * @see #setArchitectural(Architectural)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getSystem_Architectural()
	 * @model containment="true"
	 * @generated
	 */
	Architectural getArchitectural();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.System#getArchitectural <em>Architectural</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Architectural</em>' containment reference.
	 * @see #getArchitectural()
	 * @generated
	 */
	void setArchitectural(Architectural value);

	/**
	 * Returns the value of the '<em><b>Functional</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Functional</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functional</em>' containment reference.
	 * @see #setFunctional(Functional)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getSystem_Functional()
	 * @model containment="true"
	 * @generated
	 */
	Functional getFunctional();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.System#getFunctional <em>Functional</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Functional</em>' containment reference.
	 * @see #getFunctional()
	 * @generated
	 */
	void setFunctional(Functional value);

	/**
	 * Returns the value of the '<em><b>Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping</em>' containment reference.
	 * @see #setMapping(Mapping)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getSystem_Mapping()
	 * @model containment="true"
	 * @generated
	 */
	Mapping getMapping();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.System#getMapping <em>Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping</em>' containment reference.
	 * @see #getMapping()
	 * @generated
	 */
	void setMapping(Mapping value);

	/**
	 * Returns the value of the '<em><b>Modes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modes</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modes</em>' containment reference.
	 * @see #setModes(Modes)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getSystem_Modes()
	 * @model containment="true"
	 * @generated
	 */
	Modes getModes();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.System#getModes <em>Modes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modes</em>' containment reference.
	 * @see #getModes()
	 * @generated
	 */
	void setModes(Modes value);

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
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getSystem_Name()
	 * @model id="true" dataType="com.eu.evidence.rtdruid.vartree.data.StringVar" required="true"
	 * @generated
	 */
	StringVar getName();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.System#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(StringVar value);

	/**
	 * Returns the value of the '<em><b>Schedulability</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedulability</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedulability</em>' containment reference.
	 * @see #setSchedulability(Schedulability)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getSystem_Schedulability()
	 * @model containment="true"
	 * @generated
	 */
	Schedulability getSchedulability();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.System#getSchedulability <em>Schedulability</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedulability</em>' containment reference.
	 * @see #getSchedulability()
	 * @generated
	 */
	void setSchedulability(Schedulability value);

	/**
	 * Returns the value of the '<em><b>XTC Cookie</b></em>' attribute list.
	 * The list contents are of type {@link com.eu.evidence.rtdruid.vartree.variables.StringVar}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XTC Cookie</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XTC Cookie</em>' attribute list.
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getSystem_XTC_Cookie()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.StringVar"
	 * @generated
	 */
	EList<StringVar> getXTC_Cookie();

} // System
