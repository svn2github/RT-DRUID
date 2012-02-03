/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.Architectural;
import com.eu.evidence.rtdruid.vartree.data.Bus;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.Ecu;
import com.eu.evidence.rtdruid.vartree.data.Frame;
import com.eu.evidence.rtdruid.vartree.data.Mutex;
import com.eu.evidence.rtdruid.vartree.data.Resource;
import com.eu.evidence.rtdruid.vartree.data.Signal;
import com.eu.evidence.rtdruid.vartree.data.Task;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Architectural</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ArchitecturalImpl#getBusList <em>Bus List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ArchitecturalImpl#getEcuList <em>Ecu List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ArchitecturalImpl#getFrameList <em>Frame List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ArchitecturalImpl#getMutexList <em>Mutex List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ArchitecturalImpl#getResourceList <em>Resource List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ArchitecturalImpl#getSignalList <em>Signal List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ArchitecturalImpl#getTaskList <em>Task List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArchitecturalImpl extends ObjectWithIDImpl implements Architectural {
	/**
	 * The cached value of the '{@link #getBusList() <em>Bus List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusList()
	 * @generated
	 * @ordered
	 */
	protected EList<Bus> busList;

	/**
	 * The cached value of the '{@link #getEcuList() <em>Ecu List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcuList()
	 * @generated
	 * @ordered
	 */
	protected EList<Ecu> ecuList;

	/**
	 * The cached value of the '{@link #getFrameList() <em>Frame List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameList()
	 * @generated
	 * @ordered
	 */
	protected EList<Frame> frameList;

	/**
	 * The cached value of the '{@link #getMutexList() <em>Mutex List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMutexList()
	 * @generated
	 * @ordered
	 */
	protected EList<Mutex> mutexList;

	/**
	 * The cached value of the '{@link #getResourceList() <em>Resource List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceList()
	 * @generated
	 * @ordered
	 */
	protected EList<Resource> resourceList;

	/**
	 * The cached value of the '{@link #getSignalList() <em>Signal List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignalList()
	 * @generated
	 * @ordered
	 */
	protected EList<Signal> signalList;

	/**
	 * The cached value of the '{@link #getTaskList() <em>Task List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskList()
	 * @generated
	 * @ordered
	 */
	protected EList<Task> taskList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchitecturalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.ARCHITECTURAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Bus> getBusList() {
		if (busList == null) {
			busList = new EObjectContainmentEList<Bus>(Bus.class, this, DataPackage.ARCHITECTURAL__BUS_LIST);
		}
		return busList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Ecu> getEcuList() {
		if (ecuList == null) {
			ecuList = new EObjectContainmentEList<Ecu>(Ecu.class, this, DataPackage.ARCHITECTURAL__ECU_LIST);
		}
		return ecuList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Frame> getFrameList() {
		if (frameList == null) {
			frameList = new EObjectContainmentEList<Frame>(Frame.class, this, DataPackage.ARCHITECTURAL__FRAME_LIST);
		}
		return frameList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mutex> getMutexList() {
		if (mutexList == null) {
			mutexList = new EObjectContainmentEList<Mutex>(Mutex.class, this, DataPackage.ARCHITECTURAL__MUTEX_LIST);
		}
		return mutexList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Resource> getResourceList() {
		if (resourceList == null) {
			resourceList = new EObjectContainmentEList<Resource>(Resource.class, this, DataPackage.ARCHITECTURAL__RESOURCE_LIST);
		}
		return resourceList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Signal> getSignalList() {
		if (signalList == null) {
			signalList = new EObjectContainmentEList<Signal>(Signal.class, this, DataPackage.ARCHITECTURAL__SIGNAL_LIST);
		}
		return signalList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Task> getTaskList() {
		if (taskList == null) {
			taskList = new EObjectContainmentEList<Task>(Task.class, this, DataPackage.ARCHITECTURAL__TASK_LIST);
		}
		return taskList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataPackage.ARCHITECTURAL__BUS_LIST:
				return ((InternalEList<?>)getBusList()).basicRemove(otherEnd, msgs);
			case DataPackage.ARCHITECTURAL__ECU_LIST:
				return ((InternalEList<?>)getEcuList()).basicRemove(otherEnd, msgs);
			case DataPackage.ARCHITECTURAL__FRAME_LIST:
				return ((InternalEList<?>)getFrameList()).basicRemove(otherEnd, msgs);
			case DataPackage.ARCHITECTURAL__MUTEX_LIST:
				return ((InternalEList<?>)getMutexList()).basicRemove(otherEnd, msgs);
			case DataPackage.ARCHITECTURAL__RESOURCE_LIST:
				return ((InternalEList<?>)getResourceList()).basicRemove(otherEnd, msgs);
			case DataPackage.ARCHITECTURAL__SIGNAL_LIST:
				return ((InternalEList<?>)getSignalList()).basicRemove(otherEnd, msgs);
			case DataPackage.ARCHITECTURAL__TASK_LIST:
				return ((InternalEList<?>)getTaskList()).basicRemove(otherEnd, msgs);
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
			case DataPackage.ARCHITECTURAL__BUS_LIST:
				return getBusList();
			case DataPackage.ARCHITECTURAL__ECU_LIST:
				return getEcuList();
			case DataPackage.ARCHITECTURAL__FRAME_LIST:
				return getFrameList();
			case DataPackage.ARCHITECTURAL__MUTEX_LIST:
				return getMutexList();
			case DataPackage.ARCHITECTURAL__RESOURCE_LIST:
				return getResourceList();
			case DataPackage.ARCHITECTURAL__SIGNAL_LIST:
				return getSignalList();
			case DataPackage.ARCHITECTURAL__TASK_LIST:
				return getTaskList();
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
			case DataPackage.ARCHITECTURAL__BUS_LIST:
				getBusList().clear();
				getBusList().addAll((Collection<? extends Bus>)newValue);
				return;
			case DataPackage.ARCHITECTURAL__ECU_LIST:
				getEcuList().clear();
				getEcuList().addAll((Collection<? extends Ecu>)newValue);
				return;
			case DataPackage.ARCHITECTURAL__FRAME_LIST:
				getFrameList().clear();
				getFrameList().addAll((Collection<? extends Frame>)newValue);
				return;
			case DataPackage.ARCHITECTURAL__MUTEX_LIST:
				getMutexList().clear();
				getMutexList().addAll((Collection<? extends Mutex>)newValue);
				return;
			case DataPackage.ARCHITECTURAL__RESOURCE_LIST:
				getResourceList().clear();
				getResourceList().addAll((Collection<? extends Resource>)newValue);
				return;
			case DataPackage.ARCHITECTURAL__SIGNAL_LIST:
				getSignalList().clear();
				getSignalList().addAll((Collection<? extends Signal>)newValue);
				return;
			case DataPackage.ARCHITECTURAL__TASK_LIST:
				getTaskList().clear();
				getTaskList().addAll((Collection<? extends Task>)newValue);
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
			case DataPackage.ARCHITECTURAL__BUS_LIST:
				getBusList().clear();
				return;
			case DataPackage.ARCHITECTURAL__ECU_LIST:
				getEcuList().clear();
				return;
			case DataPackage.ARCHITECTURAL__FRAME_LIST:
				getFrameList().clear();
				return;
			case DataPackage.ARCHITECTURAL__MUTEX_LIST:
				getMutexList().clear();
				return;
			case DataPackage.ARCHITECTURAL__RESOURCE_LIST:
				getResourceList().clear();
				return;
			case DataPackage.ARCHITECTURAL__SIGNAL_LIST:
				getSignalList().clear();
				return;
			case DataPackage.ARCHITECTURAL__TASK_LIST:
				getTaskList().clear();
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
			case DataPackage.ARCHITECTURAL__BUS_LIST:
				return busList != null && !busList.isEmpty();
			case DataPackage.ARCHITECTURAL__ECU_LIST:
				return ecuList != null && !ecuList.isEmpty();
			case DataPackage.ARCHITECTURAL__FRAME_LIST:
				return frameList != null && !frameList.isEmpty();
			case DataPackage.ARCHITECTURAL__MUTEX_LIST:
				return mutexList != null && !mutexList.isEmpty();
			case DataPackage.ARCHITECTURAL__RESOURCE_LIST:
				return resourceList != null && !resourceList.isEmpty();
			case DataPackage.ARCHITECTURAL__SIGNAL_LIST:
				return signalList != null && !signalList.isEmpty();
			case DataPackage.ARCHITECTURAL__TASK_LIST:
				return taskList != null && !taskList.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ArchitecturalImpl
