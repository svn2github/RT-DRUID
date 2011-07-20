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

import com.eu.evidence.rtdruid.vartree.data.Architectural;
import com.eu.evidence.rtdruid.vartree.data.Bus;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.Ecu;
import com.eu.evidence.rtdruid.vartree.data.Frame;
import com.eu.evidence.rtdruid.vartree.data.Mutex;
import com.eu.evidence.rtdruid.vartree.data.Resource;
import com.eu.evidence.rtdruid.vartree.data.Signal;
import com.eu.evidence.rtdruid.vartree.data.Task;
import com.eu.evidence.rtdruid.vartree.data.init.EObjectContainmentUniqueEList;
import com.eu.evidence.rtdruid.vartree.data.init.ObjectWithIDImpl;


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
public class ArchitecturalImpl extends ObjectWithIDImpl implements Architectural
{
	/**
	 * The cached value of the '{@link #getBusList() <em>Bus List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusList()
	 * @generated
	 * @ordered
	 */
	protected EList busList = null;

	/**
	 * The cached value of the '{@link #getEcuList() <em>Ecu List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcuList()
	 * @generated
	 * @ordered
	 */
	protected EList ecuList = null;

	/**
	 * The cached value of the '{@link #getFrameList() <em>Frame List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameList()
	 * @generated
	 * @ordered
	 */
	protected EList frameList = null;

	/**
	 * The cached value of the '{@link #getMutexList() <em>Mutex List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMutexList()
	 * @generated
	 * @ordered
	 */
	protected EList mutexList = null;

	/**
	 * The cached value of the '{@link #getResourceList() <em>Resource List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceList()
	 * @generated
	 * @ordered
	 */
	protected EList resourceList = null;

	/**
	 * The cached value of the '{@link #getSignalList() <em>Signal List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignalList()
	 * @generated
	 * @ordered
	 */
	protected EList signalList = null;

	/**
	 * The cached value of the '{@link #getTaskList() <em>Task List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskList()
	 * @generated
	 * @ordered
	 */
	protected EList taskList = null;

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
  protected EClass eStaticClass() {
		return DataPackage.eINSTANCE.getArchitectural();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getBusList() {
		if (busList == null) {
			busList = new EObjectContainmentUniqueEList(Bus.class, this, DataPackage.ARCHITECTURAL__BUS_LIST);
		}
		return busList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getEcuList() {
		if (ecuList == null) {
			ecuList = new EObjectContainmentUniqueEList(Ecu.class, this, DataPackage.ARCHITECTURAL__ECU_LIST);
		}
		return ecuList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getFrameList() {
		if (frameList == null) {
			frameList = new EObjectContainmentUniqueEList(Frame.class, this, DataPackage.ARCHITECTURAL__FRAME_LIST);
		}
		return frameList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getMutexList() {
		if (mutexList == null) {
			mutexList = new EObjectContainmentUniqueEList(Mutex.class, this, DataPackage.ARCHITECTURAL__MUTEX_LIST);
		}
		return mutexList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getResourceList() {
		if (resourceList == null) {
			resourceList = new EObjectContainmentUniqueEList(Resource.class, this, DataPackage.ARCHITECTURAL__RESOURCE_LIST);
		}
		return resourceList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getSignalList() {
		if (signalList == null) {
			signalList = new EObjectContainmentUniqueEList(Signal.class, this, DataPackage.ARCHITECTURAL__SIGNAL_LIST);
		}
		return signalList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getTaskList() {
		if (taskList == null) {
			taskList = new EObjectContainmentUniqueEList(Task.class, this, DataPackage.ARCHITECTURAL__TASK_LIST);
		}
		return taskList;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case DataPackage.ARCHITECTURAL__BUS_LIST:
					return ((InternalEList)getBusList()).basicRemove(otherEnd, msgs);
				case DataPackage.ARCHITECTURAL__ECU_LIST:
					return ((InternalEList)getEcuList()).basicRemove(otherEnd, msgs);
				case DataPackage.ARCHITECTURAL__FRAME_LIST:
					return ((InternalEList)getFrameList()).basicRemove(otherEnd, msgs);
				case DataPackage.ARCHITECTURAL__MUTEX_LIST:
					return ((InternalEList)getMutexList()).basicRemove(otherEnd, msgs);
				case DataPackage.ARCHITECTURAL__RESOURCE_LIST:
					return ((InternalEList)getResourceList()).basicRemove(otherEnd, msgs);
				case DataPackage.ARCHITECTURAL__SIGNAL_LIST:
					return ((InternalEList)getSignalList()).basicRemove(otherEnd, msgs);
				case DataPackage.ARCHITECTURAL__TASK_LIST:
					return ((InternalEList)getTaskList()).basicRemove(otherEnd, msgs);
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
			case DataPackage.ARCHITECTURAL__BUS_LIST:
				getBusList().clear();
				getBusList().addAll((Collection)newValue);
				return;
			case DataPackage.ARCHITECTURAL__ECU_LIST:
				getEcuList().clear();
				getEcuList().addAll((Collection)newValue);
				return;
			case DataPackage.ARCHITECTURAL__FRAME_LIST:
				getFrameList().clear();
				getFrameList().addAll((Collection)newValue);
				return;
			case DataPackage.ARCHITECTURAL__MUTEX_LIST:
				getMutexList().clear();
				getMutexList().addAll((Collection)newValue);
				return;
			case DataPackage.ARCHITECTURAL__RESOURCE_LIST:
				getResourceList().clear();
				getResourceList().addAll((Collection)newValue);
				return;
			case DataPackage.ARCHITECTURAL__SIGNAL_LIST:
				getSignalList().clear();
				getSignalList().addAll((Collection)newValue);
				return;
			case DataPackage.ARCHITECTURAL__TASK_LIST:
				getTaskList().clear();
				getTaskList().addAll((Collection)newValue);
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
		return super.eIsSet(eFeature);
//		return eDynamicIsSet(eFeature);
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#getObjectID()
	 */
	public String getObjectID() {
		return "Architectural";
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#setObjectID(java.lang.String)
	 */
	public boolean setObjectID(String newID) {
		return getObjectID().equals(newID);
	}
} //ArchitecturalImpl
