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
import com.eu.evidence.rtdruid.vartree.data.Order;
import com.eu.evidence.rtdruid.vartree.data.init.ObjectWithIDImpl;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Order</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.OrderImpl#getFirstEvent <em>First Event</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.OrderImpl#getSecondEvent <em>Second Event</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrderImpl extends ObjectWithIDImpl implements Order
{
	/**
	 * The default value of the '{@link #getFirstEvent() <em>First Event</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFirstEvent()
	 * @generated
	 * @ordered
	 */
  protected static final StringVar FIRST_EVENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFirstEvent() <em>First Event</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFirstEvent()
	 * @generated
	 * @ordered
	 */
  protected StringVar firstEvent = FIRST_EVENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecondEvent() <em>Second Event</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSecondEvent()
	 * @generated
	 * @ordered
	 */
  protected static final StringVar SECOND_EVENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSecondEvent() <em>Second Event</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSecondEvent()
	 * @generated
	 * @ordered
	 */
  protected StringVar secondEvent = SECOND_EVENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected OrderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EClass eStaticClass() {
		return DataPackage.eINSTANCE.getOrder();
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StringVar getFirstEvent() {
		return firstEvent;
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setFirstEvent(StringVar newFirstEvent)
  {
	{
		if ( !checkNewID(makeSlahedID(new IVariable[] {newFirstEvent, secondEvent})) ) return;
	}

  	// Store old ID
  	String old_ID = getObjectID();
  	
	setFirstEventGen(newFirstEvent);

	// ASk to update ID
  	didSetObjectID(old_ID);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private void setFirstEventGen(StringVar newFirstEvent) {
    StringVar oldFirstEvent = firstEvent;
    firstEvent = newFirstEvent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ORDER__FIRST_EVENT, oldFirstEvent, firstEvent));
  }

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StringVar getSecondEvent() {
		return secondEvent;
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setSecondEvent(StringVar newSecondEvent)
  {
	{
		if ( !checkNewID(makeSlahedID(new IVariable[] {firstEvent, newSecondEvent})) ) return;
	}

  	// Store old ID
  	String old_ID = getObjectID();
  	
	setSecondEventGen(newSecondEvent);
	
	// ASk to update ID
  	didSetObjectID(old_ID);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private void setSecondEventGen(StringVar newSecondEvent) {
    StringVar oldSecondEvent = secondEvent;
    secondEvent = newSecondEvent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ORDER__SECOND_EVENT, oldSecondEvent, secondEvent));
  }

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case DataPackage.ORDER__FIRST_EVENT:
				return getFirstEvent();
			case DataPackage.ORDER__SECOND_EVENT:
				return getSecondEvent();
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
			case DataPackage.ORDER__FIRST_EVENT:
				setFirstEvent((StringVar)newValue);
				return;
			case DataPackage.ORDER__SECOND_EVENT:
				setSecondEvent((StringVar)newValue);
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
			case DataPackage.ORDER__FIRST_EVENT:
				setFirstEvent(FIRST_EVENT_EDEFAULT);
				return;
			case DataPackage.ORDER__SECOND_EVENT:
				setSecondEvent(SECOND_EVENT_EDEFAULT);
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
			case DataPackage.ORDER__FIRST_EVENT:
				return FIRST_EVENT_EDEFAULT == null ? firstEvent != null : !FIRST_EVENT_EDEFAULT.equals(firstEvent);
			case DataPackage.ORDER__SECOND_EVENT:
				return SECOND_EVENT_EDEFAULT == null ? secondEvent != null : !SECOND_EVENT_EDEFAULT.equals(secondEvent);
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
		result.append(" (FirstEvent: ");
		result.append(firstEvent);
		result.append(", SecondEvent: ");
		result.append(secondEvent);
		result.append(')');
		return result.toString();
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#getObjectID()
	 */
	public String getObjectID() {
		return makeSlahedID(new IVariable[] {firstEvent, secondEvent});
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#setObjectID(java.lang.String)
	 */
	public boolean setObjectID(String newID) {
	  	if ( !checkNewID(newID) ) return false;
		
	  	// Store old ID
	  	String old_ID = getObjectID();
	  	
		String[] tmp = resolveID(newID);
		setFirstEventGen (tmp[0] == null ? (StringVar) null : new StringVar(tmp[0]));
		setSecondEventGen(tmp[1] == null ? (StringVar) null : new StringVar(tmp[1]));

		// ASk to update ID
	  	didSetObjectID(old_ID);
		return true;
	}
} //OrderImpl
