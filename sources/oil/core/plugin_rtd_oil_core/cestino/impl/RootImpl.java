/**
 * <copyright>
 * </copyright>
 *
 * $Id: RootImpl.java,v 1.2 2008/05/14 17:15:33 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.vartree.data.oil.impl;



import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.eu.evidence.rtdruid.modules.oil.keywords.IOilXMLLabels;
import com.eu.evidence.rtdruid.vartree.data.oil.HW;
import com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage;
import com.eu.evidence.rtdruid.vartree.data.oil.OilObjectWithID;
import com.eu.evidence.rtdruid.vartree.data.oil.Root;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.RootImpl#getHwList <em>Hw List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.RootImpl#getObjectType <em>Object Type</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.RootImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RootImpl extends OilObjectWithIDImpl implements Root {
	/**
	 * The cached value of the '{@link #getHwList() <em>Hw List</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHwList()
	 * @generated
	 * @ordered
	 */
	protected EList<HW> hwList = null;

	/**
	 * The default value of the '{@link #getObjectType() <em>Object Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectType()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar OBJECT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObjectType() <em>Object Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectType()
	 * @generated
	 * @ordered
	 */
	protected StringVar objectType = OBJECT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected StringVar description = DESCRIPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OilApplPackage.eINSTANCE.getRoot();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<HW> getHwList() {
		if (hwList == null) {
			hwList = new EObjectContainmentEList<HW>(HW.class, this, OilApplPackage.ROOT__HW_LIST);
		}
		return hwList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getObjectType() {
		return objectType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setObjectType(StringVar newObjectType) {
		  
//		if ( !checkNewID(makeID(newObjectType)) ) return;
//
//	  	// Store old ID
//	  	String old_ID = getObjectID();
	  			
		setObjectTypeGen(newObjectType);
	  			
//		// ASk to update ID
//	  	didSetObjectID(old_ID);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectTypeGen(StringVar newObjectType) {
		StringVar oldObjectType = objectType;
		objectType = newObjectType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilApplPackage.ROOT__OBJECT_TYPE, oldObjectType, objectType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(StringVar newDescription) {
		StringVar oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilApplPackage.ROOT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case OilApplPackage.ROOT__HW_LIST:
				return getHwList();
			case OilApplPackage.ROOT__OBJECT_TYPE:
				return getObjectType();
			case OilApplPackage.ROOT__DESCRIPTION:
				return getDescription();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case OilApplPackage.ROOT__HW_LIST:
				getHwList().clear();
				getHwList().addAll((Collection)newValue);
				return;
			case OilApplPackage.ROOT__OBJECT_TYPE:
				setObjectType((StringVar)newValue);
				return;
			case OilApplPackage.ROOT__DESCRIPTION:
				setDescription((StringVar)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case OilApplPackage.ROOT__HW_LIST:
				getHwList().clear();
				return;
			case OilApplPackage.ROOT__OBJECT_TYPE:
				setObjectType(OBJECT_TYPE_EDEFAULT);
				return;
			case OilApplPackage.ROOT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case OilApplPackage.ROOT__HW_LIST:
				return hwList != null && !hwList.isEmpty();
			case OilApplPackage.ROOT__OBJECT_TYPE:
				return OBJECT_TYPE_EDEFAULT == null ? objectType != null : !OBJECT_TYPE_EDEFAULT.equals(objectType);
			case OilApplPackage.ROOT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (ObjectType: ");
		result.append(objectType);
		result.append(", Description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

//	/* (non-Javadoc)
//	 * @see rtdruid.vartree.data.ObjectWithID#getObjectID()
//	 */
//	public String getObjectID() {
//		return makeID(objectType);
//	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#setObjectID(java.lang.String)
	 */
	public boolean setObjectID(String newID) {
	  	if ( !checkNewID(newID) ) return false;

	  	// Store old ID
	  	String old_ID = getObjectID();
	  			
		String[] tmp = resolveID(newID);
		setObjectTypeGen(tmp[0] == null ? (StringVar) null : new StringVar(tmp[0]));
	  			
		// ASk to update ID
//	  	didSetObjectID(old_ID);
		return true;
	}
	
	/** Returns the type of current object, using the oil syntax */
	public String getOilType() {
		return "Root"; 
	}

	/** Returns the xml rapresentation of current object and its descendants */
	public Element getXmlRapresentation(Document doc) {
		if (doc == null) {
			throw new NullPointerException("required a not null document");
		}
		
		Element current = doc.createElement(IOilXMLLabels.ELEM_OILVAR_ROOT);
		if (objectType != null && objectType.get()!= null) {
			current.setAttribute(IOilXMLLabels.ATTR_OBJ_TYPE, (String) objectType.get());
		}
		if (description != null && description.get()!= null) {
			Element descr = doc.createElement(IOilXMLLabels.ELEM_DESCRIPTION);
			current.appendChild(descr);
			
			descr.appendChild(doc.createTextNode((String) description.get()));
		}

		EList<HW> children = getHwList();
		for (Iterator<HW> iter = children.iterator(); iter.hasNext(); ) {
			OilObjectWithID child = (OilObjectWithID) iter.next();
			
			current.appendChild(child.getXmlRapresentation(doc));
		}
		
		return current;
	}


} //RootImpl
