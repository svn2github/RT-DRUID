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

import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.Frame;
import com.eu.evidence.rtdruid.vartree.data.init.ObjectWithIDImpl;
import com.eu.evidence.rtdruid.vartree.variables.LongVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Frame</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.FrameImpl#getActivationClass <em>Activation Class</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.FrameImpl#getActivationRate <em>Activation Rate</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.FrameImpl#getActivationType <em>Activation Type</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.FrameImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.FrameImpl#getLength <em>Length</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.FrameImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FrameImpl extends ObjectWithIDImpl implements Frame
{
	/**
	 * The default value of the '{@link #getActivationClass() <em>Activation Class</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getActivationClass()
	 * @generated
	 * @ordered
	 */
  protected static final StringVar ACTIVATION_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActivationClass() <em>Activation Class</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getActivationClass()
	 * @generated
	 * @ordered
	 */
  protected StringVar activationClass = ACTIVATION_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getActivationRate() <em>Activation Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getActivationRate()
	 * @generated
	 * @ordered
	 */
  protected static final StringVar ACTIVATION_RATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActivationRate() <em>Activation Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getActivationRate()
	 * @generated
	 * @ordered
	 */
  protected StringVar activationRate = ACTIVATION_RATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getActivationType() <em>Activation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getActivationType()
	 * @generated
	 * @ordered
	 */
  protected static final StringVar ACTIVATION_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActivationType() <em>Activation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getActivationType()
	 * @generated
	 * @ordered
	 */
  protected StringVar activationType = ACTIVATION_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
  protected static final StringVar ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
  protected StringVar id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
  protected static final LongVar LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
  protected LongVar length = LENGTH_EDEFAULT;

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
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected FrameImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EClass eStaticClass() {
		return DataPackage.eINSTANCE.getFrame();
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
  public void setName(StringVar newName)
  {
	if ( !checkNewID(makeID(newName)) ) return;
  	
  	// Store old ID
  	String old_ID = getObjectID();

	setNameGen(newName);
	
	// ASk to update ID
  	didSetObjectID(old_ID);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private void setNameGen(StringVar newName) {
    StringVar oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.FRAME__NAME, oldName, name));
  }

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StringVar getActivationType() {
		return activationType;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setActivationType(StringVar newActivationType) {
		StringVar oldActivationType = activationType;
		activationType = newActivationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.FRAME__ACTIVATION_TYPE, oldActivationType, activationType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(StringVar newId) {
		StringVar oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.FRAME__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StringVar getActivationClass() {
		return activationClass;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setActivationClass(StringVar newActivationClass) {
		StringVar oldActivationClass = activationClass;
		activationClass = newActivationClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.FRAME__ACTIVATION_CLASS, oldActivationClass, activationClass));
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StringVar getActivationRate() {
		return activationRate;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setActivationRate(StringVar newActivationRate) {
		StringVar oldActivationRate = activationRate;
		activationRate = newActivationRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.FRAME__ACTIVATION_RATE, oldActivationRate, activationRate));
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LongVar getLength() {
		return length;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLength(LongVar newLength) {
		LongVar oldLength = length;
		length = newLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.FRAME__LENGTH, oldLength, length));
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case DataPackage.FRAME__ACTIVATION_CLASS:
				return getActivationClass();
			case DataPackage.FRAME__ACTIVATION_RATE:
				return getActivationRate();
			case DataPackage.FRAME__ACTIVATION_TYPE:
				return getActivationType();
			case DataPackage.FRAME__ID:
				return getId();
			case DataPackage.FRAME__LENGTH:
				return getLength();
			case DataPackage.FRAME__NAME:
				return getName();
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
			case DataPackage.FRAME__ACTIVATION_CLASS:
				setActivationClass((StringVar)newValue);
				return;
			case DataPackage.FRAME__ACTIVATION_RATE:
				setActivationRate((StringVar)newValue);
				return;
			case DataPackage.FRAME__ACTIVATION_TYPE:
				setActivationType((StringVar)newValue);
				return;
			case DataPackage.FRAME__ID:
				setId((StringVar)newValue);
				return;
			case DataPackage.FRAME__LENGTH:
				setLength((LongVar)newValue);
				return;
			case DataPackage.FRAME__NAME:
				setName((StringVar)newValue);
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
			case DataPackage.FRAME__ACTIVATION_CLASS:
				setActivationClass(ACTIVATION_CLASS_EDEFAULT);
				return;
			case DataPackage.FRAME__ACTIVATION_RATE:
				setActivationRate(ACTIVATION_RATE_EDEFAULT);
				return;
			case DataPackage.FRAME__ACTIVATION_TYPE:
				setActivationType(ACTIVATION_TYPE_EDEFAULT);
				return;
			case DataPackage.FRAME__ID:
				setId(ID_EDEFAULT);
				return;
			case DataPackage.FRAME__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case DataPackage.FRAME__NAME:
				setName(NAME_EDEFAULT);
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
			case DataPackage.FRAME__ACTIVATION_CLASS:
				return ACTIVATION_CLASS_EDEFAULT == null ? activationClass != null : !ACTIVATION_CLASS_EDEFAULT.equals(activationClass);
			case DataPackage.FRAME__ACTIVATION_RATE:
				return ACTIVATION_RATE_EDEFAULT == null ? activationRate != null : !ACTIVATION_RATE_EDEFAULT.equals(activationRate);
			case DataPackage.FRAME__ACTIVATION_TYPE:
				return ACTIVATION_TYPE_EDEFAULT == null ? activationType != null : !ACTIVATION_TYPE_EDEFAULT.equals(activationType);
			case DataPackage.FRAME__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case DataPackage.FRAME__LENGTH:
				return LENGTH_EDEFAULT == null ? length != null : !LENGTH_EDEFAULT.equals(length);
			case DataPackage.FRAME__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (ActivationClass: ");
		result.append(activationClass);
		result.append(", ActivationRate: ");
		result.append(activationRate);
		result.append(", ActivationType: ");
		result.append(activationType);
		result.append(", Id: ");
		result.append(id);
		result.append(", Length: ");
		result.append(length);
		result.append(", Name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#getObjectID()
	 */
	public String getObjectID() {
		return makeID(name);
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#setObjectID(java.lang.String)
	 */
	public boolean setObjectID(String newID) {
	  	if ( !checkNewID(newID) ) return false;

	  	// Store old ID
	  	String old_ID = getObjectID();
	  	
		String[] tmp = resolveID(newID);
		setNameGen(tmp[0] == null ? (StringVar) null : new StringVar(tmp[0]));
		
		// ASk to update ID
	  	didSetObjectID(old_ID);
		return true;
	}
} //FrameImpl
