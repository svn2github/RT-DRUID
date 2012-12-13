/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.Event;
import com.eu.evidence.rtdruid.vartree.data.Functional;
import com.eu.evidence.rtdruid.vartree.data.PartialOrder;
import com.eu.evidence.rtdruid.vartree.data.SystemImplementation;
import com.eu.evidence.rtdruid.vartree.data.TimeConst;
import com.eu.evidence.rtdruid.vartree.data.Type;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

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
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.FunctionalImpl#getTypeList <em>Type List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionalImpl extends ObjectWithIDImpl implements Functional {
	/**
	 * The cached value of the '{@link #getEventList() <em>Event List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventList()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> eventList;

	/**
	 * The cached value of the '{@link #getPartialOrderList() <em>Partial Order List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartialOrderList()
	 * @generated
	 * @ordered
	 */
	protected EList<PartialOrder> partialOrderList;

	/**
	 * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemImplementation> implementation;

	/**
	 * The cached value of the '{@link #getTimeConstList() <em>Time Const List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeConstList()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeConst> timeConstList;

	/**
	 * The cached value of the '{@link #getTypeList() <em>Type List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeList()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> typeList;

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
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.FUNCTIONAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getEventList() {
		if (eventList == null) {
			eventList = new EObjectContainmentEList<Event>(Event.class, this, DataPackage.FUNCTIONAL__EVENT_LIST);
		}
		return eventList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PartialOrder> getPartialOrderList() {
		if (partialOrderList == null) {
			partialOrderList = new EObjectContainmentEList<PartialOrder>(PartialOrder.class, this, DataPackage.FUNCTIONAL__PARTIAL_ORDER_LIST);
		}
		return partialOrderList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemImplementation> getImplementation() {
		if (implementation == null) {
			implementation = new EObjectContainmentEList<SystemImplementation>(SystemImplementation.class, this, DataPackage.FUNCTIONAL__IMPLEMENTATION);
		}
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TimeConst> getTimeConstList() {
		if (timeConstList == null) {
			timeConstList = new EObjectContainmentEList<TimeConst>(TimeConst.class, this, DataPackage.FUNCTIONAL__TIME_CONST_LIST);
		}
		return timeConstList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getTypeList() {
		if (typeList == null) {
			typeList = new EObjectContainmentEList<Type>(Type.class, this, DataPackage.FUNCTIONAL__TYPE_LIST);
		}
		return typeList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataPackage.FUNCTIONAL__EVENT_LIST:
				return ((InternalEList<?>)getEventList()).basicRemove(otherEnd, msgs);
			case DataPackage.FUNCTIONAL__PARTIAL_ORDER_LIST:
				return ((InternalEList<?>)getPartialOrderList()).basicRemove(otherEnd, msgs);
			case DataPackage.FUNCTIONAL__IMPLEMENTATION:
				return ((InternalEList<?>)getImplementation()).basicRemove(otherEnd, msgs);
			case DataPackage.FUNCTIONAL__TIME_CONST_LIST:
				return ((InternalEList<?>)getTimeConstList()).basicRemove(otherEnd, msgs);
			case DataPackage.FUNCTIONAL__TYPE_LIST:
				return ((InternalEList<?>)getTypeList()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
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
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DataPackage.FUNCTIONAL__EVENT_LIST:
				getEventList().clear();
				getEventList().addAll((Collection<? extends Event>)newValue);
				return;
			case DataPackage.FUNCTIONAL__PARTIAL_ORDER_LIST:
				getPartialOrderList().clear();
				getPartialOrderList().addAll((Collection<? extends PartialOrder>)newValue);
				return;
			case DataPackage.FUNCTIONAL__IMPLEMENTATION:
				getImplementation().clear();
				getImplementation().addAll((Collection<? extends SystemImplementation>)newValue);
				return;
			case DataPackage.FUNCTIONAL__TIME_CONST_LIST:
				getTimeConstList().clear();
				getTimeConstList().addAll((Collection<? extends TimeConst>)newValue);
				return;
			case DataPackage.FUNCTIONAL__TYPE_LIST:
				getTypeList().clear();
				getTypeList().addAll((Collection<? extends Type>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
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
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
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
		return super.eIsSet(featureID);
	}

} //FunctionalImpl
