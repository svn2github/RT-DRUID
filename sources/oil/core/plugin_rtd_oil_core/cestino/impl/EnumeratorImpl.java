/**
 * <copyright>
 * </copyright>
 *
 * $Id: EnumeratorImpl.java,v 1.2 2008/05/14 17:15:33 durin Exp $
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
import com.eu.evidence.rtdruid.vartree.data.oil.Enumerator;
import com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage;
import com.eu.evidence.rtdruid.vartree.data.oil.OilObjectWithID;
import com.eu.evidence.rtdruid.vartree.data.oil.Parameter;
import com.eu.evidence.rtdruid.vartree.variables.IntegerVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumerator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.EnumeratorImpl#getParameterList <em>Parameter List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.EnumeratorImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.EnumeratorImpl#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumeratorImpl extends OilObjectWithIDImpl implements Enumerator {
	/**
	 * The cached value of the '{@link #getParameterList() <em>Parameter List</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterList()
	 * @generated
	 * @ordered
	 */
	protected EList parameterList = null;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected StringVar value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final IntegerVar INDEX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected IntegerVar index = INDEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumeratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OilApplPackage.eINSTANCE.getEnumerator();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getParameterList() {
		if (parameterList == null) {
			parameterList = new EObjectContainmentEList(Parameter.class, this, OilApplPackage.ENUMERATOR__PARAMETER_LIST);
		}
		return parameterList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(StringVar newValue) {
		StringVar oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilApplPackage.ENUMERATOR__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerVar getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setIndex(IntegerVar newIndex) {
		
//		if ( !checkNewID(makeID(newIndex)) ) return;
//
//	  	// Store old ID
//	  	String old_ID = getObjectID();
//	  			
		setIndexGen(newIndex);

//		// ASk to update ID
//	  	didSetObjectID(old_ID);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndexGen(IntegerVar newIndex) {
		IntegerVar oldIndex = index;
		index = newIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilApplPackage.ENUMERATOR__INDEX, oldIndex, index));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case OilApplPackage.ENUMERATOR__PARAMETER_LIST:
				return getParameterList();
			case OilApplPackage.ENUMERATOR__VALUE:
				return getValue();
			case OilApplPackage.ENUMERATOR__INDEX:
				return getIndex();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case OilApplPackage.ENUMERATOR__PARAMETER_LIST:
				getParameterList().clear();
				getParameterList().addAll((Collection)newValue);
				return;
			case OilApplPackage.ENUMERATOR__VALUE:
				setValue((StringVar)newValue);
				return;
			case OilApplPackage.ENUMERATOR__INDEX:
				setIndex((IntegerVar)newValue);
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
			case OilApplPackage.ENUMERATOR__PARAMETER_LIST:
				getParameterList().clear();
				return;
			case OilApplPackage.ENUMERATOR__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case OilApplPackage.ENUMERATOR__INDEX:
				setIndex(INDEX_EDEFAULT);
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
			case OilApplPackage.ENUMERATOR__PARAMETER_LIST:
				return parameterList != null && !parameterList.isEmpty();
			case OilApplPackage.ENUMERATOR__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case OilApplPackage.ENUMERATOR__INDEX:
				return INDEX_EDEFAULT == null ? index != null : !INDEX_EDEFAULT.equals(index);
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
		result.append(" (Value: ");
		result.append(value);
		result.append(", Index: ");
		result.append(index);
		result.append(')');
		return result.toString();
	}

//	/* (non-Javadoc)
//	 * @see rtdruid.vartree.data.ObjectWithID#getObjectID()
//	 */
//	public String getObjectID() {
//		return makeID(index);
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
		setIndexGen(tmp[0] == null ? (IntegerVar) null : new IntegerVar(tmp[0]));
		// ASk to update ID
//	  	didSetObjectID(old_ID);
		return true;
	}
	
	/** Returns the type of current object, using the oil syntax */
	public String getOilType() {
		return "" + value; 
	}
	
	
	/** Returns the xml rapresentation of current object and its descendants */
	public Element getXmlRapresentation(Document doc) {
		if (doc == null) {
			throw new NullPointerException("required a not null document");
		}
		
		Element current = doc.createElement(IOilXMLLabels.ELEM_ENUMERATOR);
		if (value != null && value.get()!= null) {
			current.setAttribute(IOilXMLLabels.ATTR_VALUE, (String) value.get());
		}
		EList children = getParameterList();
		for (Iterator iter = children.iterator(); iter.hasNext(); ) {
			OilObjectWithID child = (OilObjectWithID) iter.next();
			
			current.appendChild(child.getXmlRapresentation(doc));
		}
		
		return current;
	}
} //EnumeratorImpl
