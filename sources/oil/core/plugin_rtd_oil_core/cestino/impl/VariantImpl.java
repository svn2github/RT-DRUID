/**
 * <copyright>
 * </copyright>
 *
 * $Id: VariantImpl.java,v 1.2 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.vartree.data.oil.impl;



import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.eu.evidence.rtdruid.modules.oil.keywords.IOilXMLLabels;
import com.eu.evidence.rtdruid.vartree.data.oil.Enumerator;
import com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage;
import com.eu.evidence.rtdruid.vartree.data.oil.OilObjectWithID;
import com.eu.evidence.rtdruid.vartree.data.oil.Variant;
import com.eu.evidence.rtdruid.vartree.variables.BooleanVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.VariantImpl#getEnumeratorList <em>Enumerator List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariantImpl extends ParameterImpl implements Variant {
	/**
	 * The cached value of the '{@link #getEnumeratorList() <em>Enumerator List</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumeratorList()
	 * @generated
	 * @ordered
	 */
	protected EList enumeratorList = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OilApplPackage.eINSTANCE.getVariant();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getEnumeratorList() {
		if (enumeratorList == null) {
			enumeratorList = new EObjectContainmentEList(Enumerator.class, this, OilApplPackage.VARIANT__ENUMERATOR_LIST);
		}
		return enumeratorList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case OilApplPackage.VARIANT__NAME:
				return getName();
			case OilApplPackage.VARIANT__TYPE:
				return getType();
			case OilApplPackage.VARIANT__MULTI_VALUES:
				return getMultiValues();
			case OilApplPackage.VARIANT__ENUMERATOR_LIST:
				return getEnumeratorList();
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
			case OilApplPackage.VARIANT__NAME:
				setName((StringVar)newValue);
				return;
			case OilApplPackage.VARIANT__TYPE:
				setType((StringVar)newValue);
				return;
			case OilApplPackage.VARIANT__MULTI_VALUES:
				setMultiValues((BooleanVar)newValue);
				return;
			case OilApplPackage.VARIANT__ENUMERATOR_LIST:
				getEnumeratorList().clear();
				getEnumeratorList().addAll((Collection)newValue);
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
			case OilApplPackage.VARIANT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OilApplPackage.VARIANT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case OilApplPackage.VARIANT__MULTI_VALUES:
				setMultiValues(MULTI_VALUES_EDEFAULT);
				return;
			case OilApplPackage.VARIANT__ENUMERATOR_LIST:
				getEnumeratorList().clear();
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case OilApplPackage.VARIANT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OilApplPackage.VARIANT__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case OilApplPackage.VARIANT__MULTI_VALUES:
				return multiValues != null;
			case OilApplPackage.VARIANT__ENUMERATOR_LIST:
				return enumeratorList != null && !enumeratorList.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

	/** Returns the xml rapresentation of current object and its descendants */
	public Element getXmlRapresentation(Document doc) {
		if (doc == null) {
			throw new NullPointerException("required a not null document");
		}
		
		Element current = doc.createElement(IOilXMLLabels.ELEM_VARIANT);
		if (name != null && name.get()!= null) {
			current.setAttribute(IOilXMLLabels.ATTR_NAME, (String) name.get());
		}

		EList children = getEnumeratorList();
		for (Iterator iter = children.iterator(); iter.hasNext(); ) {
			OilObjectWithID child = (OilObjectWithID) iter.next();
			
			current.appendChild(child.getXmlRapresentation(doc));
		}
		
		return current;
	}

} //VariantImpl
