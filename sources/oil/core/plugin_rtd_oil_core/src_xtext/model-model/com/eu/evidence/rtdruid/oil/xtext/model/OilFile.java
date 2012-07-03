/**
 */
package com.eu.evidence.rtdruid.oil.xtext.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.oil.xtext.model.OilFile#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.xtext.model.OilFile#getApplication <em>Application</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.xtext.model.OilFile#getOilVersion <em>Oil Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getOilFile()
 * @model
 * @generated
 */
public interface OilFile extends EObject {
	/**
	 * Returns the value of the '<em><b>Implementation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation</em>' containment reference.
	 * @see #setImplementation(OilImplementation)
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getOilFile_Implementation()
	 * @model containment="true"
	 * @generated
	 */
	OilImplementation getImplementation();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilFile#getImplementation <em>Implementation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation</em>' containment reference.
	 * @see #getImplementation()
	 * @generated
	 */
	void setImplementation(OilImplementation value);

	/**
	 * Returns the value of the '<em><b>Application</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application</em>' containment reference.
	 * @see #setApplication(OilApplication)
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getOilFile_Application()
	 * @model containment="true"
	 * @generated
	 */
	OilApplication getApplication();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilFile#getApplication <em>Application</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application</em>' containment reference.
	 * @see #getApplication()
	 * @generated
	 */
	void setApplication(OilApplication value);

	/**
	 * Returns the value of the '<em><b>Oil Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Oil Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Oil Version</em>' attribute.
	 * @see #setOilVersion(String)
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilPackage#getOilFile_OilVersion()
	 * @model
	 * @generated
	 */
	String getOilVersion();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilFile#getOilVersion <em>Oil Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Oil Version</em>' attribute.
	 * @see #getOilVersion()
	 * @generated
	 */
	void setOilVersion(String value);

} // OilFile
