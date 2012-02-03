/**
 * <copyright>
 * </copyright>
 *
 * %W%
 * @version %I% %H%
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;




import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.eu.evidence.rtdruid.vartree.data.CpuSched;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.SchedulingScenario;
import com.eu.evidence.rtdruid.vartree.data.TaskSched;
import com.eu.evidence.rtdruid.vartree.data.init.EObjectContainmentUniqueEList;
import com.eu.evidence.rtdruid.vartree.data.init.ObjectWithIDImpl;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduling Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SchedulingScenarioImpl#getCpuSchedList <em>Cpu Sched List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SchedulingScenarioImpl#getModeRef <em>Mode Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SchedulingScenarioImpl#getReports <em>Reports</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SchedulingScenarioImpl#getTaskSchedList <em>Task Sched List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SchedulingScenarioImpl extends ObjectWithIDImpl implements SchedulingScenario
{
	/**
	 * The cached value of the '{@link #getCpuSchedList() <em>Cpu Sched List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuSchedList()
	 * @generated
	 * @ordered
	 */
	protected EList cpuSchedList = null;

	/**
	 * The default value of the '{@link #getModeRef() <em>Mode Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getModeRef()
	 * @generated
	 * @ordered
	 */
  protected static final StringVar MODE_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModeRef() <em>Mode Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getModeRef()
	 * @generated
	 * @ordered
	 */
  protected StringVar modeRef = MODE_REF_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReports() <em>Reports</em>}' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getReports()
	 * @generated
	 * @ordered
	 */
  protected EList reports = null;

	/**
	 * The cached value of the '{@link #getTaskSchedList() <em>Task Sched List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskSchedList()
	 * @generated
	 * @ordered
	 */
	protected EList taskSchedList = null;

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected SchedulingScenarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EClass eStaticClass() {
		return DataPackage.eINSTANCE.getSchedulingScenario();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getCpuSchedList() {
		if (cpuSchedList == null) {
			cpuSchedList = new EObjectContainmentUniqueEList(CpuSched.class, this, DataPackage.SCHEDULING_SCENARIO__CPU_SCHED_LIST);
		}
		return cpuSchedList;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StringVar getModeRef() {
		return modeRef;
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setModeRef(StringVar newModeRef)
  {
	if ( !checkNewID(makeID(newModeRef)) ) return;
  	
  	// Store old ID
  	String old_ID = getObjectID();
  	
	setModeRefGen(newModeRef);
	
	// ASk to update ID
  	didSetObjectID(old_ID);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private void setModeRefGen(StringVar newModeRef) {
    StringVar oldModeRef = modeRef;
    modeRef = newModeRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.SCHEDULING_SCENARIO__MODE_REF, oldModeRef, modeRef));
  }

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList getReports() {
		if (reports == null) {
			reports = new EDataTypeUniqueEList(StringVar.class, this, DataPackage.SCHEDULING_SCENARIO__REPORTS);
		}
		return reports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getTaskSchedList() {
		if (taskSchedList == null) {
			taskSchedList = new EObjectContainmentUniqueEList(TaskSched.class, this, DataPackage.SCHEDULING_SCENARIO__TASK_SCHED_LIST);
		}
		return taskSchedList;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case DataPackage.SCHEDULING_SCENARIO__CPU_SCHED_LIST:
					return ((InternalEList)getCpuSchedList()).basicRemove(otherEnd, msgs);
				case DataPackage.SCHEDULING_SCENARIO__TASK_SCHED_LIST:
					return ((InternalEList)getTaskSchedList()).basicRemove(otherEnd, msgs);
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
			case DataPackage.SCHEDULING_SCENARIO__CPU_SCHED_LIST:
				return getCpuSchedList();
			case DataPackage.SCHEDULING_SCENARIO__MODE_REF:
				return getModeRef();
			case DataPackage.SCHEDULING_SCENARIO__REPORTS:
				return getReports();
			case DataPackage.SCHEDULING_SCENARIO__TASK_SCHED_LIST:
				return getTaskSchedList();
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
			case DataPackage.SCHEDULING_SCENARIO__CPU_SCHED_LIST:
				getCpuSchedList().clear();
				getCpuSchedList().addAll((Collection)newValue);
				return;
			case DataPackage.SCHEDULING_SCENARIO__MODE_REF:
				setModeRef((StringVar)newValue);
				return;
			case DataPackage.SCHEDULING_SCENARIO__REPORTS:
				getReports().clear();
				getReports().addAll((Collection)newValue);
				return;
			case DataPackage.SCHEDULING_SCENARIO__TASK_SCHED_LIST:
				getTaskSchedList().clear();
				getTaskSchedList().addAll((Collection)newValue);
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
			case DataPackage.SCHEDULING_SCENARIO__CPU_SCHED_LIST:
				getCpuSchedList().clear();
				return;
			case DataPackage.SCHEDULING_SCENARIO__MODE_REF:
				setModeRef(MODE_REF_EDEFAULT);
				return;
			case DataPackage.SCHEDULING_SCENARIO__REPORTS:
				getReports().clear();
				return;
			case DataPackage.SCHEDULING_SCENARIO__TASK_SCHED_LIST:
				getTaskSchedList().clear();
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
			case DataPackage.SCHEDULING_SCENARIO__CPU_SCHED_LIST:
				return cpuSchedList != null && !cpuSchedList.isEmpty();
			case DataPackage.SCHEDULING_SCENARIO__MODE_REF:
				return MODE_REF_EDEFAULT == null ? modeRef != null : !MODE_REF_EDEFAULT.equals(modeRef);
			case DataPackage.SCHEDULING_SCENARIO__REPORTS:
				return reports != null && !reports.isEmpty();
			case DataPackage.SCHEDULING_SCENARIO__TASK_SCHED_LIST:
				return taskSchedList != null && !taskSchedList.isEmpty();
		}
		return super.eIsSet(eFeature);
//		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (ModeRef: ");
		result.append(modeRef);
		result.append(", Reports: ");
		result.append(reports);
		result.append(')');
		return result.toString();
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#getObjectID()
	 */
	public String getObjectID() {
		return makeID(modeRef);
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#setObjectID(java.lang.String)
	 */
	public boolean setObjectID(String newID) {
	  	if ( !checkNewID(newID) ) return false;

	  	// Store old ID
	  	String old_ID = getObjectID();
	  	
		String[] tmp = resolveID(newID);
		setModeRefGen(tmp[0] == null ? (StringVar) null : new StringVar(tmp[0]));
		
		// ASk to update ID
	  	didSetObjectID(old_ID);
		return true;
	}
} //SchedulingScenarioImpl
