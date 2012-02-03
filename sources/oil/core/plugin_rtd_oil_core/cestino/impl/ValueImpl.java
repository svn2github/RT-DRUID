/**
 * <copyright>
 * </copyright>
 *
 * $Id: ValueImpl.java,v 1.2 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.vartree.data.oil.impl;




import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.eu.evidence.rtdruid.modules.oil.keywords.IOilXMLLabels;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage;
import com.eu.evidence.rtdruid.vartree.data.oil.Value;
import com.eu.evidence.rtdruid.vartree.variables.BooleanVar;
import com.eu.evidence.rtdruid.vartree.variables.StringDescrVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.ValueImpl#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueImpl extends ParameterImpl implements Value {
	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList values = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OilApplPackage.eINSTANCE.getValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getValues() {
		if (values == null) {
			values = new EDataTypeUniqueEList(StringDescrVar.class, this, OilApplPackage.VALUE__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case OilApplPackage.VALUE__NAME:
				return getName();
			case OilApplPackage.VALUE__TYPE:
				return getType();
			case OilApplPackage.VALUE__MULTI_VALUES:
				return getMultiValues();
			case OilApplPackage.VALUE__VALUES:
				return getValues();
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
			case OilApplPackage.VALUE__NAME:
				setName((StringVar)newValue);
				return;
			case OilApplPackage.VALUE__TYPE:
				setType((StringVar)newValue);
				return;
			case OilApplPackage.VALUE__MULTI_VALUES:
				setMultiValues((BooleanVar)newValue);
				return;
			case OilApplPackage.VALUE__VALUES:
				getValues().clear();
				getValues().addAll((Collection)newValue);
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
			case OilApplPackage.VALUE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OilApplPackage.VALUE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case OilApplPackage.VALUE__MULTI_VALUES:
				setMultiValues(MULTI_VALUES_EDEFAULT);
				return;
			case OilApplPackage.VALUE__VALUES:
				getValues().clear();
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
			case OilApplPackage.VALUE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OilApplPackage.VALUE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case OilApplPackage.VALUE__MULTI_VALUES:
				return multiValues != null;
			case OilApplPackage.VALUE__VALUES:
				return values != null && !values.isEmpty();
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
		result.append(" (Values: ");
		result.append(values);
		result.append(')');
		return result.toString();
	}

	/** Returns the xml rapresentation of current object and its descendants */
	public Element getXmlRapresentation(Document doc) {
		if (doc == null) {
			throw new NullPointerException("required a not null document");
		}
		
		Element current = doc.createElement(IOilXMLLabels.ELEM_ATTRIBUTE);
		if (name != null && name.get()!= null) {
			current.setAttribute(IOilXMLLabels.ATTR_NAME, (String) name.get());
		}

		EList children = getValues();
		for (Iterator iter = children.iterator(); iter.hasNext(); ) {
			IVariable child = (IVariable) iter.next();
			
			if (child.get() != null) {
				Element value = doc.createElement(IOilXMLLabels.ELEM_VALUE);
				value.setAttribute(IOilXMLLabels.ATTR_CURR_VALUE, child.toString());
				current.appendChild(value);
			}
		}
		
		return current;
	}

} //ValueImpl
