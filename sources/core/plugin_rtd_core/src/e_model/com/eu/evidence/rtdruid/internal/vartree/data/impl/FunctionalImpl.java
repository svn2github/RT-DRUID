/**
 * <copyright>
 * </copyright>
 *
 * %W%
 * @version %I% %H%
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;




import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.Event;
import com.eu.evidence.rtdruid.vartree.data.Functional;
import com.eu.evidence.rtdruid.vartree.data.PartialOrder;
import com.eu.evidence.rtdruid.vartree.data.SystemImplementation;
import com.eu.evidence.rtdruid.vartree.data.TimeConst;
import com.eu.evidence.rtdruid.vartree.data.Type;
import com.eu.evidence.rtdruid.vartree.data.init.EObjectContainmentUniqueEList;
import com.eu.evidence.rtdruid.vartree.data.init.ObjectWithIDImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Functional</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.FunctionalImpl#getEventList <em>Event List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.FunctionalImpl#getPartialOrderList <em>Partial Order List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.FunctionalImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.FunctionalImpl#getTimeConstList <em>Time Const List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.impl.FunctionalImpl#getTypeList <em>Type List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionalImpl extends ObjectWithIDImpl implements Functional
{
	/**
	 * The cached value of the '{@link #getEventList() <em>Event List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getEventList()
	 * @generated
	 * @ordered
	 */
  protected EList eventList = null;

	/**
	 * The cached value of the '{@link #getPartialOrderList() <em>Partial Order List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getPartialOrderList()
	 * @generated
	 * @ordered
	 */
  protected EList partialOrderList = null;

	/**
	 * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected EList implementation = null;

	/**
	 * The cached value of the '{@link #getTimeConstList() <em>Time Const List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTimeConstList()
	 * @generated
	 * @ordered
	 */
  protected EList timeConstList = null;

  /**
  	 * The cached value of the '{@link #getTypeList() <em>Type List</em>}' containment reference list.
  	 * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
  	 * @see #getTypeList()
  	 * @generated
  	 * @ordered
  	 */
  protected EList typeList;
  
	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected FunctionalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EClass eStaticClass() {
		return DataPackage.eINSTANCE.getFunctional();
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public EList getEventList()
  {
    if (eventList == null)
    {
      eventList = new EObjectContainmentUniqueEList(Event.class, this, DataPackage.FUNCTIONAL__EVENT_LIST);
    }
    return eventList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT 
   */
  public EList getPartialOrderList()
  {
    if (partialOrderList == null)
    {
      partialOrderList = new EObjectContainmentUniqueEList(PartialOrder.class, this, DataPackage.FUNCTIONAL__PARTIAL_ORDER_LIST);
    }
    return partialOrderList;
  }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getImplementation() {
		if (implementation == null) {
			implementation = new EObjectContainmentUniqueEList(SystemImplementation.class, this, DataPackage.FUNCTIONAL__IMPLEMENTATION);
		}
		return implementation;
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT 
   */
  public EList getTimeConstList()
  {
    if (timeConstList == null)
    {
      timeConstList = new EObjectContainmentUniqueEList(TimeConst.class, this, DataPackage.FUNCTIONAL__TIME_CONST_LIST);
    }
    return timeConstList;
  }

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  	public EList getTypeList() {
  		if (typeList == null) {
  			typeList = new EObjectContainmentUniqueEList(Type.class, this, DataPackage.FUNCTIONAL__TYPE_LIST);
  		}
  		return typeList;
  	}
  
  	/**
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case DataPackage.FUNCTIONAL__EVENT_LIST:
					return ((InternalEList)getEventList()).basicRemove(otherEnd, msgs);
				case DataPackage.FUNCTIONAL__PARTIAL_ORDER_LIST:
					return ((InternalEList)getPartialOrderList()).basicRemove(otherEnd, msgs);
				case DataPackage.FUNCTIONAL__IMPLEMENTATION:
					return ((InternalEList)getImplementation()).basicRemove(otherEnd, msgs);
				case DataPackage.FUNCTIONAL__TIME_CONST_LIST:
					return ((InternalEList)getTimeConstList()).basicRemove(otherEnd, msgs);
				case DataPackage.FUNCTIONAL__TYPE_LIST:
					return ((InternalEList)getTypeList()).basicRemove(otherEnd, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case DataPackage.FUNCTIONAL__EVENT_LIST:
				return getEventList();
			case DataPackage.FUNCTIONAL__PARTIAL_ORDER_LIST:
				return getPartialOrderList();
			case DataPackage.FUNCTIONAL__IMPLEMENTATION:
				return getImplementation();
			case DataPackage.FUNCTIONAL__TIME_CONST_LIST:
				return getTimeConstList();
			case DataPackage.FUNCTIONAL__TYPE_LIST:
				return getTypeList();
		}
		return super.eGet(eFeature, resolve);
//		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case DataPackage.FUNCTIONAL__EVENT_LIST:
				getEventList().clear();
				getEventList().addAll((Collection)newValue);
				return;
			case DataPackage.FUNCTIONAL__PARTIAL_ORDER_LIST:
				getPartialOrderList().clear();
				getPartialOrderList().addAll((Collection)newValue);
				return;
			case DataPackage.FUNCTIONAL__IMPLEMENTATION:
				getImplementation().clear();
				getImplementation().addAll((Collection)newValue);
				return;
			case DataPackage.FUNCTIONAL__TIME_CONST_LIST:
				getTimeConstList().clear();
				getTimeConstList().addAll((Collection)newValue);
				return;
			case DataPackage.FUNCTIONAL__TYPE_LIST:
				getTypeList().clear();
				getTypeList().addAll((Collection)newValue);
				return;
		}
		super.eSet(eFeature, newValue);
//		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case DataPackage.FUNCTIONAL__EVENT_LIST:
				getEventList().clear();
				return;
			case DataPackage.FUNCTIONAL__PARTIAL_ORDER_LIST:
				getPartialOrderList().clear();
				return;
			case DataPackage.FUNCTIONAL__IMPLEMENTATION:
				getImplementation().clear();
				return;
			case DataPackage.FUNCTIONAL__TIME_CONST_LIST:
				getTimeConstList().clear();
				return;
			case DataPackage.FUNCTIONAL__TYPE_LIST:
				getTypeList().clear();
				return;
		}
		super.eUnset(eFeature);
//		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case DataPackage.FUNCTIONAL__EVENT_LIST:
				return eventList != null && !eventList.isEmpty();
			case DataPackage.FUNCTIONAL__PARTIAL_ORDER_LIST:
				return partialOrderList != null && !partialOrderList.isEmpty();
			case DataPackage.FUNCTIONAL__IMPLEMENTATION:
				return implementation != null && !implementation.isEmpty();
			case DataPackage.FUNCTIONAL__TIME_CONST_LIST:
				return timeConstList != null && !timeConstList.isEmpty();
			case DataPackage.FUNCTIONAL__TYPE_LIST:
				return typeList != null && !typeList.isEmpty();
		}
		return super.eIsSet(eFeature);
//		return eDynamicIsSet(eFeature);
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#getObjectID()
	 */
	public String getObjectID() {
		return "Functional";
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#setObjectID(java.lang.String)
	 */
	public boolean setObjectID(String newID) {
		return getObjectID().equals(newID);
	}
} //FunctionalImpl
