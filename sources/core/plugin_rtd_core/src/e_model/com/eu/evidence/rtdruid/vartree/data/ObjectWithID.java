/**
 * <copyright>
 * </copyright>
 *
 * %W%
 * @version %I% %H%
 */
package com.eu.evidence.rtdruid.vartree.data;

import org.eclipse.emf.ecore.EObject;

import com.eu.evidence.rtdruid.vartree.variables.PropertyVar;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object With ID</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.ObjectWithID#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getObjectWithID()
 * @model abstract="true"
 * @generated
 */
public interface ObjectWithID extends EObject{
	
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' attribute.
	 * @see #setProperties(PropertyVar)
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#getObjectWithID_Properties()
	 * @model dataType="com.eu.evidence.rtdruid.vartree.data.PropertyVar"
	 * @generated
	 */
	PropertyVar getProperties();

	/**
	 * Sets the value of the '{@link com.eu.evidence.rtdruid.vartree.data.ObjectWithID#getProperties <em>Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties</em>' attribute.
	 * @see #getProperties()
	 * @generated
	 */
	void setProperties(PropertyVar value);
	
	/**
	 * This flag is used to identify if this object is unused and has no ID. 
	 * 
	 * Is used to solve a bug with EMF copy, that tries to insert many new_&&_empty
	 * objects before fill them with theirs ID.
	 */
	boolean isNew_object();
	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model parameters=""
	 * @generated
	 */
  String getObjectID();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model 
	 * @generated
	 */
	boolean setObjectID(String newID);

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model 
	 * @generated
	 */
  boolean checkNewID(String newID);
  
  /** Make a distinct copy of current node and all its attributes and references
   * */
  public ObjectWithID clone();
  
  /**
   * Try to merge current node with another Object of the same type (and all its
   * attributes and references). The result is stored in current node.
   * 
   * @param source
   *            the other object
   * @param path
   *            identifies the location of current nodes inside the tree (the
   *            path is the same for both object)
   * @param overwrite
   *            if true, attributes of the parameter <b>source </b> overwrite
   *            attributes of <b>this </b>. Otherwise, throws an Exception if
   *            two node contains different values for the same attribute
   * 
   * @throws IllegalArgumentException
   *             if two object are not compatible (or one of theirs descendants)
   */
  public void merge(ObjectWithID source, String path, boolean overwrite);

} // ObjectWithID
