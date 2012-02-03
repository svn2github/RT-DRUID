/**
 * <copyright>
 * </copyright>
 *
 * $Id: HWImpl.java,v 1.2 2008/05/14 17:15:33 durin Exp $
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
import com.eu.evidence.rtdruid.vartree.data.oil.RTOS;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>HW</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.HWImpl#getRtosList <em>Rtos List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.HWImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.HWImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HWImpl extends OilObjectWithIDImpl implements HW {
	/**
	 * The cached value of the '{@link #getRtosList() <em>Rtos List</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRtosList()
	 * @generated
	 * @ordered
	 */
	protected EList<RTOS> rtosList = null;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected StringVar name = NAME_EDEFAULT;

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
	protected HWImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OilApplPackage.eINSTANCE.getHW();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<RTOS> getRtosList() {
		if (rtosList == null) {
			rtosList = new EObjectContainmentEList<RTOS>(RTOS.class, this, OilApplPackage.HW__RTOS_LIST);
		}
		return rtosList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setName(StringVar newName) {
		  
//		if ( !checkNewID(makeID(newName)) ) return;
//
//	  	// Store old ID
//	  	String old_ID = getObjectID();
	  			
		setNameGen(newName);
	  			
//		// ASk to update ID
//	  	didSetObjectID(old_ID);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNameGen(StringVar newName) {
		StringVar oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilApplPackage.HW__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OilApplPackage.HW__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case OilApplPackage.HW__RTOS_LIST:
				return getRtosList();
			case OilApplPackage.HW__NAME:
				return getName();
			case OilApplPackage.HW__DESCRIPTION:
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
			case OilApplPackage.HW__RTOS_LIST:
				getRtosList().clear();
				getRtosList().addAll((Collection<RTOS>)newValue);
				return;
			case OilApplPackage.HW__NAME:
				setName((StringVar)newValue);
				return;
			case OilApplPackage.HW__DESCRIPTION:
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
			case OilApplPackage.HW__RTOS_LIST:
				getRtosList().clear();
				return;
			case OilApplPackage.HW__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OilApplPackage.HW__DESCRIPTION:
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
			case OilApplPackage.HW__RTOS_LIST:
				return rtosList != null && !rtosList.isEmpty();
			case OilApplPackage.HW__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OilApplPackage.HW__DESCRIPTION:
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
		result.append(" (Name: ");
		result.append(name);
		result.append(", Description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

//	/* (non-Javadoc)
//	 * @see rtdruid.vartree.data.ObjectWithID#getObjectID()
//	 */
//	public String getObjectID() {
//		return makeID(name);
//	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#setObjectID(java.lang.String)
	 */
	public boolean setObjectID(String newID) {
	  	if ( !checkNewID(newID) ) return false;
//
//	  	// Store old ID
//	  	String old_ID = getObjectID();

		String[] tmp = resolveID(newID);
		setNameGen(tmp[0] == null ? (StringVar) null : new StringVar(tmp[0]));

//		// ASk to update ID
//	  	didSetObjectID(old_ID);
		return true;
	}
	
	/** Returns the type of current object, using the oil syntax */
	public String getOilType() {
		return "HW"; 
	}

	/** Returns the xml rapresentation of current object and its descendants */
	public Element getXmlRapresentation(Document doc) {
		if (doc == null) {
			throw new NullPointerException("required a not null document");
		}
		
		Element current = doc.createElement(IOilXMLLabels.ELEM_OILVAR_HW);
		if (name != null && name.get()!= null) {
			current.setAttribute(IOilXMLLabels.ATTR_NAME, (String) name.get());
		}
		if (description != null && description.get()!= null) {
			Element descr = doc.createElement(IOilXMLLabels.ELEM_DESCRIPTION);
			current.appendChild(descr);
			
			descr.appendChild(doc.createTextNode((String) description.get()));
		}

		EList<RTOS> children = getRtosList();
		for (Iterator<RTOS> iter = children.iterator(); iter.hasNext(); ) {
			OilObjectWithID child = (OilObjectWithID) iter.next();
			
			current.appendChild(child.getXmlRapresentation(doc));
		}
		
		return current;
	}

} //HWImpl
