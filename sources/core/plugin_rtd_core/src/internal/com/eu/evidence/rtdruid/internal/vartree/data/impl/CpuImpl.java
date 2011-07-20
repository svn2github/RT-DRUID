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
import org.eclipse.emf.ecore.util.InternalEList;

import com.eu.evidence.rtdruid.vartree.data.Cpu;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.OsApplication;
import com.eu.evidence.rtdruid.vartree.data.Rtos;
import com.eu.evidence.rtdruid.vartree.data.init.EObjectContainmentUniqueEList;
import com.eu.evidence.rtdruid.vartree.data.init.ObjectWithIDImpl;
import com.eu.evidence.rtdruid.vartree.variables.DoubleVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cpu</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CpuImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CpuImpl#getModel <em>Model</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CpuImpl#getRtos <em>Rtos</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CpuImpl#getOsApplication <em>Os Application</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CpuImpl#getSpeed <em>Speed</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CpuImpl#getSpeed_Unit <em>Speed Unit</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CpuImpl#getBinaryImage <em>Binary Image</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CpuImpl extends ObjectWithIDImpl implements Cpu
{
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
	 * The default value of the '{@link #getModel() <em>Model</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
  protected static final StringVar MODEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
  protected StringVar model = MODEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRtos() <em>Rtos</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getRtos()
	 * @generated
	 * @ordered
	 */
  protected Rtos rtos = null;

  /**
  	 * The cached value of the '{@link #getOsApplication() <em>Os Application</em>}' containment reference list.
  	 * <!-- begin-user-doc -->
  	 * <!-- end-user-doc -->
  	 * @see #getOsApplication()
  	 * @generated
  	 * @ordered
  	 */
  	protected EList osApplication;
  
	/**
	 * The default value of the '{@link #getSpeed() <em>Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeed()
	 * @generated
	 * @ordered
	 */
	protected static final DoubleVar SPEED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpeed() <em>Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeed()
	 * @generated
	 * @ordered
	 */
	protected DoubleVar speed = SPEED_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpeed_Unit() <em>Speed Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeed_Unit()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar SPEED_UNIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpeed_Unit() <em>Speed Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeed_Unit()
	 * @generated
	 * @ordered
	 */
	protected StringVar speed_Unit = SPEED_UNIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getBinaryImage() <em>Binary Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinaryImage()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar BINARY_IMAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBinaryImage() <em>Binary Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinaryImage()
	 * @generated
	 * @ordered
	 */
	protected StringVar binaryImage = BINARY_IMAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected CpuImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EClass eStaticClass() {
		return DataPackage.eINSTANCE.getCpu();
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
      eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CPU__NAME, oldName, name));
  }

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StringVar getModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setModel(StringVar newModel) {
		StringVar oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CPU__MODEL, oldModel, model));
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Rtos getRtos() {
		return rtos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
  public EList getOsApplication() {
  		if (osApplication == null) {
  			osApplication = new EObjectContainmentUniqueEList(OsApplication.class, this, DataPackage.CPU__OS_APPLICATION);
  		}
  		return osApplication;
  	}
  
	  
	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetRtos(Rtos newRtos, NotificationChain msgs) {
		Rtos oldRtos = rtos;
		rtos = newRtos;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataPackage.CPU__RTOS, oldRtos, newRtos);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setRtos(Rtos newRtos) {
		if (newRtos != rtos) {
			NotificationChain msgs = null;
			if (rtos != null)
				msgs = ((InternalEObject)rtos).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataPackage.CPU__RTOS, null, msgs);
			if (newRtos != null)
				msgs = ((InternalEObject)newRtos).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataPackage.CPU__RTOS, null, msgs);
			msgs = basicSetRtos(newRtos, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CPU__RTOS, newRtos, newRtos));
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
   	public DoubleVar getSpeed() {
 		return speed;
 	}
 
 	/**
 	 * <!-- begin-user-doc -->
 	 * <!-- end-user-doc -->
 	 * @generated
 	 */
 	public void setSpeed(DoubleVar newSpeed) {
 		DoubleVar oldSpeed = speed;
 		speed = newSpeed;
 		if (eNotificationRequired())
 			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CPU__SPEED, oldSpeed, speed));
 	}
 
 	/**
 	 * <!-- begin-user-doc -->
 	 * <!-- end-user-doc -->
 	 * @generated
 	 */
 	public StringVar getSpeed_Unit() {
 		return speed_Unit;
 	}
 
 	/**
 	 * <!-- begin-user-doc -->
 	 * <!-- end-user-doc -->
 	 * @generated
 	 */
 	public void setSpeed_Unit(StringVar newSpeed_Unit) {
 		StringVar oldSpeed_Unit = speed_Unit;
 		speed_Unit = newSpeed_Unit;
 		if (eNotificationRequired())
 			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CPU__SPEED_UNIT, oldSpeed_Unit, speed_Unit));
 	}
 
 	/**
 	 * <!-- begin-user-doc -->
 	 * <!-- end-user-doc -->
 	 * @generated
 	 */
 	public StringVar getBinaryImage() {
 		return binaryImage;
 	}
 
 	/**
 	 * <!-- begin-user-doc -->
 	 * <!-- end-user-doc -->
 	 * @generated
 	 */
 	public void setBinaryImage(StringVar newBinaryImage) {
 		StringVar oldBinaryImage = binaryImage;
 		binaryImage = newBinaryImage;
 		if (eNotificationRequired())
 			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CPU__BINARY_IMAGE, oldBinaryImage, binaryImage));
 	}
 
 	/**
 	 * <!-- begin-user-doc -->
 	 * <!-- end-user-doc -->
 	 * @generated
 	 */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case DataPackage.CPU__RTOS:
					return basicSetRtos(null, msgs);
				case DataPackage.CPU__OS_APPLICATION:
					return ((InternalEList)getOsApplication()).basicRemove(otherEnd, msgs);
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
			case DataPackage.CPU__NAME:
				return getName();
			case DataPackage.CPU__MODEL:
				return getModel();
			case DataPackage.CPU__RTOS:
				return getRtos();
			case DataPackage.CPU__OS_APPLICATION:
				return getOsApplication();
			case DataPackage.CPU__SPEED:
				return getSpeed();
			case DataPackage.CPU__SPEED_UNIT:
				return getSpeed_Unit();
			case DataPackage.CPU__BINARY_IMAGE:
				return getBinaryImage();
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
			case DataPackage.CPU__NAME:
				setName((StringVar)newValue);
				return;
			case DataPackage.CPU__MODEL:
				setModel((StringVar)newValue);
				return;
			case DataPackage.CPU__RTOS:
				setRtos((Rtos)newValue);
				return;
			case DataPackage.CPU__OS_APPLICATION:
				getOsApplication().clear();
				getOsApplication().addAll((Collection)newValue);
				return;
			case DataPackage.CPU__SPEED:
				setSpeed((DoubleVar)newValue);
				return;
			case DataPackage.CPU__SPEED_UNIT:
				setSpeed_Unit((StringVar)newValue);
				return;
			case DataPackage.CPU__BINARY_IMAGE:
				setBinaryImage((StringVar)newValue);
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
			case DataPackage.CPU__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DataPackage.CPU__MODEL:
				setModel(MODEL_EDEFAULT);
				return;
			case DataPackage.CPU__RTOS:
				setRtos((Rtos)null);
				return;
			case DataPackage.CPU__OS_APPLICATION:
				getOsApplication().clear();
				return;
			case DataPackage.CPU__SPEED:
				setSpeed(SPEED_EDEFAULT);
				return;
			case DataPackage.CPU__SPEED_UNIT:
				setSpeed_Unit(SPEED_UNIT_EDEFAULT);
				return;
			case DataPackage.CPU__BINARY_IMAGE:
				setBinaryImage(BINARY_IMAGE_EDEFAULT);
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
			case DataPackage.CPU__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DataPackage.CPU__MODEL:
				return MODEL_EDEFAULT == null ? model != null : !MODEL_EDEFAULT.equals(model);
			case DataPackage.CPU__RTOS:
				return rtos != null;
			case DataPackage.CPU__OS_APPLICATION:
				return osApplication != null && !osApplication.isEmpty();
			case DataPackage.CPU__SPEED:
				return SPEED_EDEFAULT == null ? speed != null : !SPEED_EDEFAULT.equals(speed);
			case DataPackage.CPU__SPEED_UNIT:
				return SPEED_UNIT_EDEFAULT == null ? speed_Unit != null : !SPEED_UNIT_EDEFAULT.equals(speed_Unit);
			case DataPackage.CPU__BINARY_IMAGE:
				return BINARY_IMAGE_EDEFAULT == null ? binaryImage != null : !BINARY_IMAGE_EDEFAULT.equals(binaryImage);
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
		result.append(" (Name: ");
		result.append(name);
		result.append(", Model: ");
		result.append(model);
		result.append(", Speed: ");
		result.append(speed);
		result.append(", Speed_Unit: ");
		result.append(speed_Unit);
		result.append(", BinaryImage: ");
		result.append(binaryImage);
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
} //CpuImpl
