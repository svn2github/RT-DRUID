/**
 * <copyright>
 * </copyright>
 *
 * %W%
 * @version %I% %H%
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;




import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.TaskMap;
import com.eu.evidence.rtdruid.vartree.data.init.ObjectWithIDImpl;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskMapImpl#getModeRef <em>Mode Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskMapImpl#getRtosRef <em>Rtos Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskMapImpl#getTaskRef <em>Task Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskMapImpl extends ObjectWithIDImpl implements TaskMap
{
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
	 * The default value of the '{@link #getRtosRef() <em>Rtos Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getRtosRef()
	 * @generated
	 * @ordered
	 */
  protected static final StringVar RTOS_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRtosRef() <em>Rtos Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getRtosRef()
	 * @generated
	 * @ordered
	 */
  protected StringVar rtosRef = RTOS_REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getTaskRef() <em>Task Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTaskRef()
	 * @generated
	 * @ordered
	 */
  protected static final StringVar TASK_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTaskRef() <em>Task Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTaskRef()
	 * @generated
	 * @ordered
	 */
  protected StringVar taskRef = TASK_REF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected TaskMapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EClass eStaticClass() {
		return DataPackage.eINSTANCE.getTaskMap();
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StringVar getTaskRef() {
		return taskRef;
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setTaskRef(StringVar newTaskRef)
  {
	{
		if ( !checkNewID(makeSlahedID(new IVariable[] {modeRef, newTaskRef})) ) return;
	}

  	// Store old ID
  	String old_ID = getObjectID();
  	
	setTaskRefGen(newTaskRef);
	
	// ASk to update ID
  	didSetObjectID(old_ID);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private void setTaskRefGen(StringVar newTaskRef) {
    StringVar oldTaskRef = taskRef;
    taskRef = newTaskRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TASK_MAP__TASK_REF, oldTaskRef, taskRef));
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
	{
		if ( !checkNewID(makeSlahedID(new IVariable[] {newModeRef, taskRef})) ) return;
	}

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
      eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TASK_MAP__MODE_REF, oldModeRef, modeRef));
  }

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StringVar getRtosRef() {
		return rtosRef;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setRtosRef(StringVar newRtosRef) {
		StringVar oldRtosRef = rtosRef;
		rtosRef = newRtosRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.TASK_MAP__RTOS_REF, oldRtosRef, rtosRef));
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case DataPackage.TASK_MAP__MODE_REF:
				return getModeRef();
			case DataPackage.TASK_MAP__RTOS_REF:
				return getRtosRef();
			case DataPackage.TASK_MAP__TASK_REF:
				return getTaskRef();
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
			case DataPackage.TASK_MAP__MODE_REF:
				setModeRef((StringVar)newValue);
				return;
			case DataPackage.TASK_MAP__RTOS_REF:
				setRtosRef((StringVar)newValue);
				return;
			case DataPackage.TASK_MAP__TASK_REF:
				setTaskRef((StringVar)newValue);
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
			case DataPackage.TASK_MAP__MODE_REF:
				setModeRef(MODE_REF_EDEFAULT);
				return;
			case DataPackage.TASK_MAP__RTOS_REF:
				setRtosRef(RTOS_REF_EDEFAULT);
				return;
			case DataPackage.TASK_MAP__TASK_REF:
				setTaskRef(TASK_REF_EDEFAULT);
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
			case DataPackage.TASK_MAP__MODE_REF:
				return MODE_REF_EDEFAULT == null ? modeRef != null : !MODE_REF_EDEFAULT.equals(modeRef);
			case DataPackage.TASK_MAP__RTOS_REF:
				return RTOS_REF_EDEFAULT == null ? rtosRef != null : !RTOS_REF_EDEFAULT.equals(rtosRef);
			case DataPackage.TASK_MAP__TASK_REF:
				return TASK_REF_EDEFAULT == null ? taskRef != null : !TASK_REF_EDEFAULT.equals(taskRef);
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
		result.append(", RtosRef: ");
		result.append(rtosRef);
		result.append(", TaskRef: ");
		result.append(taskRef);
		result.append(')');
		return result.toString();
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#getObjectID()
	 */
	public String getObjectID() {
		return makeSlahedID(new IVariable[] {modeRef, taskRef});
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
		setTaskRefGen(tmp[1] == null ? (StringVar) null : new StringVar(tmp[1]));

		// ASk to update ID
	  	didSetObjectID(old_ID);
		return true;
	}
} //TaskMapImpl
