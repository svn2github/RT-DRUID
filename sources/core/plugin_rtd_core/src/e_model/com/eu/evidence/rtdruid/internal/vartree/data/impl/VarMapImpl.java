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
import com.eu.evidence.rtdruid.vartree.data.VarMap;
import com.eu.evidence.rtdruid.vartree.data.init.ObjectWithIDImpl;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Var Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.VarMapImpl#getBusRef <em>Bus Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.VarMapImpl#getFrameRef <em>Frame Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.VarMapImpl#getModeRef <em>Mode Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.VarMapImpl#getMutexRef <em>Mutex Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.VarMapImpl#getVarRef <em>Var Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VarMapImpl extends ObjectWithIDImpl implements VarMap
{
	/**
	 * The default value of the '{@link #getBusRef() <em>Bus Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getBusRef()
	 * @generated
	 * @ordered
	 */
  protected static final StringVar BUS_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBusRef() <em>Bus Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getBusRef()
	 * @generated
	 * @ordered
	 */
  protected StringVar busRef = BUS_REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getFrameRef() <em>Frame Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFrameRef()
	 * @generated
	 * @ordered
	 */
  protected static final StringVar FRAME_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFrameRef() <em>Frame Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFrameRef()
	 * @generated
	 * @ordered
	 */
  protected StringVar frameRef = FRAME_REF_EDEFAULT;

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
	 * The default value of the '{@link #getMutexRef() <em>Mutex Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMutexRef()
	 * @generated
	 * @ordered
	 */
  protected static final StringVar MUTEX_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMutexRef() <em>Mutex Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMutexRef()
	 * @generated
	 * @ordered
	 */
  protected StringVar mutexRef = MUTEX_REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getVarRef() <em>Var Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getVarRef()
	 * @generated
	 * @ordered
	 */
  protected static final StringVar VAR_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVarRef() <em>Var Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getVarRef()
	 * @generated
	 * @ordered
	 */
  protected StringVar varRef = VAR_REF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected VarMapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EClass eStaticClass() {
		return DataPackage.eINSTANCE.getVarMap();
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StringVar getVarRef() {
		return varRef;
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setVarRef(StringVar newVarRef)
  {
	{
		if ( !checkNewID(makeSlahedID(new IVariable[] {modeRef, newVarRef})) ) return;
	}

  	// Store old ID
  	String old_ID = getObjectID();
  	
	setVarRefGen(newVarRef);
	
	// ASk to update ID
  	didSetObjectID(old_ID);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private void setVarRefGen(StringVar newVarRef) {
    StringVar oldVarRef = varRef;
    varRef = newVarRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.VAR_MAP__VAR_REF, oldVarRef, varRef));
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
		if ( !checkNewID(makeSlahedID(new IVariable[] {newModeRef, varRef})) ) return;
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
      eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.VAR_MAP__MODE_REF, oldModeRef, modeRef));
  }

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StringVar getFrameRef() {
		return frameRef;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setFrameRef(StringVar newFrameRef) {
		StringVar oldFrameRef = frameRef;
		frameRef = newFrameRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.VAR_MAP__FRAME_REF, oldFrameRef, frameRef));
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StringVar getBusRef() {
		return busRef;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setBusRef(StringVar newBusRef) {
		StringVar oldBusRef = busRef;
		busRef = newBusRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.VAR_MAP__BUS_REF, oldBusRef, busRef));
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StringVar getMutexRef() {
		return mutexRef;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMutexRef(StringVar newMutexRef) {
		StringVar oldMutexRef = mutexRef;
		mutexRef = newMutexRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.VAR_MAP__MUTEX_REF, oldMutexRef, mutexRef));
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case DataPackage.VAR_MAP__BUS_REF:
				return getBusRef();
			case DataPackage.VAR_MAP__FRAME_REF:
				return getFrameRef();
			case DataPackage.VAR_MAP__MODE_REF:
				return getModeRef();
			case DataPackage.VAR_MAP__MUTEX_REF:
				return getMutexRef();
			case DataPackage.VAR_MAP__VAR_REF:
				return getVarRef();
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
			case DataPackage.VAR_MAP__BUS_REF:
				setBusRef((StringVar)newValue);
				return;
			case DataPackage.VAR_MAP__FRAME_REF:
				setFrameRef((StringVar)newValue);
				return;
			case DataPackage.VAR_MAP__MODE_REF:
				setModeRef((StringVar)newValue);
				return;
			case DataPackage.VAR_MAP__MUTEX_REF:
				setMutexRef((StringVar)newValue);
				return;
			case DataPackage.VAR_MAP__VAR_REF:
				setVarRef((StringVar)newValue);
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
			case DataPackage.VAR_MAP__BUS_REF:
				setBusRef(BUS_REF_EDEFAULT);
				return;
			case DataPackage.VAR_MAP__FRAME_REF:
				setFrameRef(FRAME_REF_EDEFAULT);
				return;
			case DataPackage.VAR_MAP__MODE_REF:
				setModeRef(MODE_REF_EDEFAULT);
				return;
			case DataPackage.VAR_MAP__MUTEX_REF:
				setMutexRef(MUTEX_REF_EDEFAULT);
				return;
			case DataPackage.VAR_MAP__VAR_REF:
				setVarRef(VAR_REF_EDEFAULT);
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
			case DataPackage.VAR_MAP__BUS_REF:
				return BUS_REF_EDEFAULT == null ? busRef != null : !BUS_REF_EDEFAULT.equals(busRef);
			case DataPackage.VAR_MAP__FRAME_REF:
				return FRAME_REF_EDEFAULT == null ? frameRef != null : !FRAME_REF_EDEFAULT.equals(frameRef);
			case DataPackage.VAR_MAP__MODE_REF:
				return MODE_REF_EDEFAULT == null ? modeRef != null : !MODE_REF_EDEFAULT.equals(modeRef);
			case DataPackage.VAR_MAP__MUTEX_REF:
				return MUTEX_REF_EDEFAULT == null ? mutexRef != null : !MUTEX_REF_EDEFAULT.equals(mutexRef);
			case DataPackage.VAR_MAP__VAR_REF:
				return VAR_REF_EDEFAULT == null ? varRef != null : !VAR_REF_EDEFAULT.equals(varRef);
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
		result.append(" (BusRef: ");
		result.append(busRef);
		result.append(", FrameRef: ");
		result.append(frameRef);
		result.append(", ModeRef: ");
		result.append(modeRef);
		result.append(", MutexRef: ");
		result.append(mutexRef);
		result.append(", VarRef: ");
		result.append(varRef);
		result.append(')');
		return result.toString();
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#getObjectID()
	 */
	public String getObjectID() {
		return makeSlahedID(new IVariable[] {modeRef, varRef});
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
		setVarRefGen (tmp[1] == null ? (StringVar) null : new StringVar(tmp[1]));

		// ASk to update ID
	  	didSetObjectID(old_ID);
		return true;
	}
} //VarMapImpl
