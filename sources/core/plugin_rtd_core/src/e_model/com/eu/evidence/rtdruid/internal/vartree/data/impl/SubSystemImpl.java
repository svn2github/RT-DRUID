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
import com.eu.evidence.rtdruid.vartree.data.Implementation;
import com.eu.evidence.rtdruid.vartree.data.ProvidedInterface;
import com.eu.evidence.rtdruid.vartree.data.RequiredInterface;
import com.eu.evidence.rtdruid.vartree.data.SubSystem;
import com.eu.evidence.rtdruid.vartree.data.init.EObjectContainmentUniqueEList;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SubSystemImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SubSystemImpl#getProvidedInterfaceList <em>Provided Interface List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SubSystemImpl#getRequiredInterfaceList <em>Required Interface List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubSystemImpl extends ImplementationImpl implements SubSystem
{
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
	 * The cached value of the '{@link #getProvidedInterfaceList() <em>Provided Interface List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedInterfaceList()
	 * @generated
	 * @ordered
	 */
	protected EList providedInterfaceList = null;

	/**
	 * The cached value of the '{@link #getRequiredInterfaceList() <em>Required Interface List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredInterfaceList()
	 * @generated
	 * @ordered
	 */
	protected EList requiredInterfaceList = null;

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected SubSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EClass eStaticClass() {
		return DataPackage.eINSTANCE.getSubSystem();
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public EList getImplementation()
  {
    if (implementation == null)
    {
      implementation = new EObjectContainmentUniqueEList(Implementation.class, this, DataPackage.SUB_SYSTEM__IMPLEMENTATION);
    }
    return implementation;
  }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getProvidedInterfaceList() {
		if (providedInterfaceList == null) {
			providedInterfaceList = new EObjectContainmentUniqueEList(ProvidedInterface.class, this, DataPackage.SUB_SYSTEM__PROVIDED_INTERFACE_LIST);
		}
		return providedInterfaceList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getRequiredInterfaceList() {
		if (requiredInterfaceList == null) {
			requiredInterfaceList = new EObjectContainmentUniqueEList(RequiredInterface.class, this, DataPackage.SUB_SYSTEM__REQUIRED_INTERFACE_LIST);
		}
		return requiredInterfaceList;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case DataPackage.SUB_SYSTEM__IMPLEMENTATION:
					return ((InternalEList)getImplementation()).basicRemove(otherEnd, msgs);
				case DataPackage.SUB_SYSTEM__PROVIDED_INTERFACE_LIST:
					return ((InternalEList)getProvidedInterfaceList()).basicRemove(otherEnd, msgs);
				case DataPackage.SUB_SYSTEM__REQUIRED_INTERFACE_LIST:
					return ((InternalEList)getRequiredInterfaceList()).basicRemove(otherEnd, msgs);
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
			case DataPackage.SUB_SYSTEM__NAME:
				return getName();
			case DataPackage.SUB_SYSTEM__IMPLEMENTATION:
				return getImplementation();
			case DataPackage.SUB_SYSTEM__PROVIDED_INTERFACE_LIST:
				return getProvidedInterfaceList();
			case DataPackage.SUB_SYSTEM__REQUIRED_INTERFACE_LIST:
				return getRequiredInterfaceList();
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
			case DataPackage.SUB_SYSTEM__NAME:
				setName((StringVar)newValue);
				return;
			case DataPackage.SUB_SYSTEM__IMPLEMENTATION:
				getImplementation().clear();
				getImplementation().addAll((Collection)newValue);
				return;
			case DataPackage.SUB_SYSTEM__PROVIDED_INTERFACE_LIST:
				getProvidedInterfaceList().clear();
				getProvidedInterfaceList().addAll((Collection)newValue);
				return;
			case DataPackage.SUB_SYSTEM__REQUIRED_INTERFACE_LIST:
				getRequiredInterfaceList().clear();
				getRequiredInterfaceList().addAll((Collection)newValue);
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
			case DataPackage.SUB_SYSTEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DataPackage.SUB_SYSTEM__IMPLEMENTATION:
				getImplementation().clear();
				return;
			case DataPackage.SUB_SYSTEM__PROVIDED_INTERFACE_LIST:
				getProvidedInterfaceList().clear();
				return;
			case DataPackage.SUB_SYSTEM__REQUIRED_INTERFACE_LIST:
				getRequiredInterfaceList().clear();
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
			case DataPackage.SUB_SYSTEM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DataPackage.SUB_SYSTEM__IMPLEMENTATION:
				return implementation != null && !implementation.isEmpty();
			case DataPackage.SUB_SYSTEM__PROVIDED_INTERFACE_LIST:
				return providedInterfaceList != null && !providedInterfaceList.isEmpty();
			case DataPackage.SUB_SYSTEM__REQUIRED_INTERFACE_LIST:
				return requiredInterfaceList != null && !requiredInterfaceList.isEmpty();
		}
		return super.eIsSet(eFeature);
//		return eDynamicIsSet(eFeature);
	}
  
  /* *
   * check also the name of parent node
   */
 /* public void setName(StringVar newName)
  {
  	String tmpId = makeID(newName);
  	SubSystem padre = (SubSystem) eContainer();
	if ( !checkNewID(tmpId) 
			&& (padre != null ? padre.getObjectID().equals(tmpId): true)
			&& !getImplementation().contains(tmpId)) {
		return;
	}
  	
    StringVar oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.SYSTEM_IMPLEMENTATION__NAME, oldName, name));
  }*/

} //SubSystemImpl
