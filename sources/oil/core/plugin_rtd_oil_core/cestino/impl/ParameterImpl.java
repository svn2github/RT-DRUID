/**
 * <copyright>
 * </copyright>
 *
 * $Id: ParameterImpl.java,v 1.2 2008/05/14 17:15:33 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.vartree.data.oil.impl;



import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage;
import com.eu.evidence.rtdruid.vartree.data.oil.Parameter;
import com.eu.evidence.rtdruid.vartree.variables.BooleanVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.ParameterImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.ParameterImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.ParameterImpl#getMultiValues <em>Multi Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ParameterImpl extends OilObjectWithIDImpl implements Parameter {
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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected StringVar type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMultiValues() <em>Multi Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiValues()
	 * @generated
	 * @ordered
	 */
	protected static final BooleanVar MULTI_VALUES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMultiValues() <em>Multi Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiValues()
	 * @generated
	 * @ordered
	 */
	protected BooleanVar multiValues = MULTI_VALUES_EDEFAULT;// MULTI_VALUES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OilApplPackage.eINSTANCE.getParameter();
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
		  
//		if ( name!=null || !checkNewID(makeID(newName)) ) return;
//
//	  	// Store old ID
//	  	String old_ID = getObjectID();
//	  			
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
			eNotify(new ENotificationImpl(this, Notification.SET, OilApplPackage.PARAMETER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setType(StringVar newType) {
		if (type != null) return;
		setTypeGen(newType);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeGen(StringVar newType) {
		StringVar oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilApplPackage.PARAMETER__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanVar getMultiValues() {
		return multiValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiValues(BooleanVar newMultiValues) {
		BooleanVar oldMultiValues = multiValues;
		multiValues = newMultiValues;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilApplPackage.PARAMETER__MULTI_VALUES, oldMultiValues, multiValues));
	}

	/**
	 * <!-- begin-user-doc --> 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case OilApplPackage.PARAMETER__NAME:
				return getName();
			case OilApplPackage.PARAMETER__TYPE:
				return getType();
			case OilApplPackage.PARAMETER__MULTI_VALUES:
				return getMultiValues();
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
			case OilApplPackage.PARAMETER__NAME:
				setName((StringVar)newValue);
				return;
			case OilApplPackage.PARAMETER__TYPE:
				setType((StringVar)newValue);
				return;
			case OilApplPackage.PARAMETER__MULTI_VALUES:
				setMultiValues((BooleanVar)newValue);
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
			case OilApplPackage.PARAMETER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OilApplPackage.PARAMETER__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case OilApplPackage.PARAMETER__MULTI_VALUES:
				setMultiValues(MULTI_VALUES_EDEFAULT);
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
			case OilApplPackage.PARAMETER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OilApplPackage.PARAMETER__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case OilApplPackage.PARAMETER__MULTI_VALUES:
				return multiValues != null;
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
		result.append(", Type: ");
		result.append(type);
		result.append(", MultiValues: ");
		result.append(multiValues);
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
	  	if (name!=null || !checkNewID(newID) ) return false;

	  	// Store old ID
	  	String old_ID = getObjectID();
		String[] tmp = resolveID(newID);
		setNameGen(tmp[0] == null ? (StringVar) null : new StringVar(tmp[0]));
	  			
		// ASk to update ID
//	  	didSetObjectID(old_ID);
		return true;
	}
	
	/** Returns the type of current object, using the oil syntax */
	public String getOilType() {
		return "" + type; 
	}
} //ParameterImpl
