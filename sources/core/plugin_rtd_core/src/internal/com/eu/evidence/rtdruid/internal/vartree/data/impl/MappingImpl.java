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
import com.eu.evidence.rtdruid.vartree.data.Mapping;
import com.eu.evidence.rtdruid.vartree.data.ProcMap;
import com.eu.evidence.rtdruid.vartree.data.TaskMap;
import com.eu.evidence.rtdruid.vartree.data.VarMap;
import com.eu.evidence.rtdruid.vartree.data.init.EObjectContainmentUniqueEList;
import com.eu.evidence.rtdruid.vartree.data.init.ObjectWithIDImpl;
import com.eu.evidence.rtdruid.vartree.variables.FastTaskToProcVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.MappingImpl#getProcMapList <em>Proc Map List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.MappingImpl#getTaskMapList <em>Task Map List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.MappingImpl#getVarMapList <em>Var Map List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.MappingImpl#getInverseTaskToProc <em>Inverse Task To Proc</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingImpl extends ObjectWithIDImpl implements Mapping
{
	/**
	 * The cached value of the '{@link #getProcMapList() <em>Proc Map List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcMapList()
	 * @generated
	 * @ordered
	 */
	protected EList procMapList = null;

	/**
	 * The cached value of the '{@link #getTaskMapList() <em>Task Map List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskMapList()
	 * @generated
	 * @ordered
	 */
	protected EList taskMapList = null;

	/**
	 * The cached value of the '{@link #getVarMapList() <em>Var Map List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarMapList()
	 * @generated
	 * @ordered
	 */
	protected EList varMapList = null;

	/**
	 * The value of the '{@link #getInverseTaskToProc() <em>Inverse Task To Proc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInverseTaskToProc()
	 * @generated
	 * @ordered
	 */
	protected FastTaskToProcVar inverse_task_to_proc_mapping = new FastTaskToProcVar();

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected MappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EClass eStaticClass() {
		return DataPackage.eINSTANCE.getMapping();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings({ "serial", "unchecked" })
	public EList getProcMapList() {
		if (procMapList == null) {
			procMapList = new EObjectContainmentUniqueEList(ProcMap.class, this, DataPackage.MAPPING__PROC_MAP_LIST) {
				@Override
				protected void didAdd(int index, Object newObject) {
					super.didAdd(index, newObject);
					
					if (newObject instanceof ProcMap) {
						ProcMap pMap = (ProcMap) newObject;
						StringVar mode = pMap.getModeRef();
						StringVar proc = pMap.getProcRef();
						StringVar task = pMap.getTaskRef();
						
						
						inverse_task_to_proc_mapping.createMap(mode == null ? null : (String) mode.get())
							.addProc(
									task == null ? null : (String) task.get(),
									proc == null ? null : (String) proc.get());
						
					}
				}
				@Override
				protected void didRemove(int index, Object oldObject) {
					super.didRemove(index, oldObject);
					
					if (oldObject instanceof ProcMap) {
						ProcMap pMap = (ProcMap) oldObject;
						StringVar mode = pMap.getModeRef();
						StringVar proc = pMap.getProcRef();
						StringVar task = pMap.getTaskRef();
						
						String modetxt = mode == null ? null : (String) mode.get();
						if (inverse_task_to_proc_mapping.containsMap(modetxt)) {
							inverse_task_to_proc_mapping.getMap(modetxt).removeProc(
									task == null ? null : (String) task.get(),
									proc == null ? null : (String) proc.get());
						}
					}
				}
				@Override
				protected void didSet(int index, Object newObject,
						Object oldObject) {
					super.didSet(index, newObject, oldObject);
					
					didRemove(index, oldObject);
					didAdd(index, newObject);
				}
			};
		}
		return procMapList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getTaskMapList() {
		if (taskMapList == null) {
			taskMapList = new EObjectContainmentUniqueEList(TaskMap.class, this, DataPackage.MAPPING__TASK_MAP_LIST);
		}
		return taskMapList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getVarMapList() {
		if (varMapList == null) {
			varMapList = new EObjectContainmentUniqueEList(VarMap.class, this, DataPackage.MAPPING__VAR_MAP_LIST);
		}
		return varMapList;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FastTaskToProcVar getInverseTaskToProc() {
		return inverse_task_to_proc_mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setInverseTaskToProc(FastTaskToProcVar newInverseTaskToProc) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void unsetInverseTaskToProc() {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSetInverseTaskToProc() {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case DataPackage.MAPPING__PROC_MAP_LIST:
					return ((InternalEList)getProcMapList()).basicRemove(otherEnd, msgs);
				case DataPackage.MAPPING__TASK_MAP_LIST:
					return ((InternalEList)getTaskMapList()).basicRemove(otherEnd, msgs);
				case DataPackage.MAPPING__VAR_MAP_LIST:
					return ((InternalEList)getVarMapList()).basicRemove(otherEnd, msgs);
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
			case DataPackage.MAPPING__PROC_MAP_LIST:
				return getProcMapList();
			case DataPackage.MAPPING__TASK_MAP_LIST:
				return getTaskMapList();
			case DataPackage.MAPPING__VAR_MAP_LIST:
				return getVarMapList();
			case DataPackage.MAPPING__INVERSE_TASK_TO_PROC:
				return getInverseTaskToProc();
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
			case DataPackage.MAPPING__PROC_MAP_LIST:
				getProcMapList().clear();
				getProcMapList().addAll((Collection)newValue);
				return;
			case DataPackage.MAPPING__TASK_MAP_LIST:
				getTaskMapList().clear();
				getTaskMapList().addAll((Collection)newValue);
				return;
			case DataPackage.MAPPING__VAR_MAP_LIST:
				getVarMapList().clear();
				getVarMapList().addAll((Collection)newValue);
				return;
			case DataPackage.MAPPING__INVERSE_TASK_TO_PROC:
				setInverseTaskToProc((FastTaskToProcVar)newValue);
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
			case DataPackage.MAPPING__PROC_MAP_LIST:
				getProcMapList().clear();
				return;
			case DataPackage.MAPPING__TASK_MAP_LIST:
				getTaskMapList().clear();
				return;
			case DataPackage.MAPPING__VAR_MAP_LIST:
				getVarMapList().clear();
				return;
			case DataPackage.MAPPING__INVERSE_TASK_TO_PROC:
				unsetInverseTaskToProc();
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
			case DataPackage.MAPPING__PROC_MAP_LIST:
				return procMapList != null && !procMapList.isEmpty();
			case DataPackage.MAPPING__TASK_MAP_LIST:
				return taskMapList != null && !taskMapList.isEmpty();
			case DataPackage.MAPPING__VAR_MAP_LIST:
				return varMapList != null && !varMapList.isEmpty();
			case DataPackage.MAPPING__INVERSE_TASK_TO_PROC:
				return isSetInverseTaskToProc();
		}
		return super.eIsSet(eFeature);
//		return eDynamicIsSet(eFeature);
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#getObjectID()
	 */
	public String getObjectID() {
		return "Mapping";
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#setObjectID(java.lang.String)
	 */
	public boolean setObjectID(String newID) {
		return getObjectID().equals(newID);
	}
} //MappingImpl
