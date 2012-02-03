/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.CacheMissCost;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.Distribution;
import com.eu.evidence.rtdruid.vartree.data.init.DataPath;
import com.eu.evidence.rtdruid.vartree.data.init.ObjectWithIDImpl;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cache Miss Cost</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.impl.CacheMissCostImpl#getBest <em>Best</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.impl.CacheMissCostImpl#getDistribution <em>Distribution</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.impl.CacheMissCostImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.impl.CacheMissCostImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.vartree.data.impl.CacheMissCostImpl#getWorst <em>Worst</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CacheMissCostImpl extends ObjectWithIDImpl implements CacheMissCost {
	
	
	/**
	 * The default value of the '{@link #getBest() <em>Best</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBest()
	 * @generated
	 * @ordered
	 */
	protected static final TimeVar BEST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBest() <em>Best</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBest()
	 * @generated
	 * @ordered
	 */
	protected TimeVar best = BEST_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDistribution() <em>Distribution</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistribution()
	 * @generated
	 * @ordered
	 */
	 protected Distribution distribution = null;

	/**
	 * The default value of the '{@link #getRef() <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected StringVar ref = REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected StringVar type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWorst() <em>Worst</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorst()
	 * @generated
	 * @ordered
	 */
	protected static final TimeVar WORST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWorst() <em>Worst</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorst()
	 * @generated
	 * @ordered
	 */
	protected TimeVar worst = WORST_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CacheMissCostImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return DataPackage.eINSTANCE.getCacheMissCost();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
  public void setType(StringVar newType) {
  	{
  		newType = varToUpperCase(newType);
		if ( !checkNewID(makeSlahedID(new IVariable[] { ref, newType })) ) return;
  	}

  	// Store old ID
  	String old_ID = getObjectID();
  	
  	setTypeGen(newType);
	
	// ASk to update ID
  	didSetObjectID(old_ID);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private void setTypeGen(StringVar newType) {
		StringVar oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CACHE_MISS_COST__REF, oldType, type));
	}

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	   * @generated NOT
	   */
	  public void setRef(StringVar newRef)
	  {
		{
			if ( !checkNewID(makeSlahedID(new IVariable[] { newRef, type })) ) return;
		}
	
		// Store old ID
		String old_ID = getObjectID();
		
		setRefGen(newRef);
		
		// ASk to update ID
		didSetObjectID(old_ID);
	  }
	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  private void setRefGen(StringVar newRef) {
	    StringVar oldRef = ref;
	    ref = newRef;
	    if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CACHE_MISS_COST__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeVar getWorst() {
		return worst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorst(TimeVar newWorst) {
		TimeVar oldWorst = worst;
		worst = newWorst;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CACHE_MISS_COST__WORST, oldWorst, worst));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeVar getBest() {
		return best;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBest(TimeVar newBest) {
		TimeVar oldBest = best;
		best = newBest;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CACHE_MISS_COST__BEST, oldBest, best));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Distribution getDistribution() {
		return distribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDistribution(Distribution newDistribution, NotificationChain msgs) {
		Distribution oldDistribution = distribution;
		distribution = newDistribution;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataPackage.CACHE_MISS_COST__DISTRIBUTION, oldDistribution, newDistribution);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistribution(Distribution newDistribution) {
		if (newDistribution != distribution) {
			NotificationChain msgs = null;
			if (distribution != null)
				msgs = ((InternalEObject)distribution).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataPackage.CACHE_MISS_COST__DISTRIBUTION, null, msgs);
			if (newDistribution != null)
				msgs = ((InternalEObject)newDistribution).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataPackage.CACHE_MISS_COST__DISTRIBUTION, null, msgs);
			msgs = basicSetDistribution(newDistribution, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.CACHE_MISS_COST__DISTRIBUTION, newDistribution, newDistribution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case DataPackage.CACHE_MISS_COST__DISTRIBUTION:
					return basicSetDistribution(null, msgs);
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
			case DataPackage.CACHE_MISS_COST__BEST:
				return getBest();
			case DataPackage.CACHE_MISS_COST__DISTRIBUTION:
				return getDistribution();
			case DataPackage.CACHE_MISS_COST__REF:
				return getRef();
			case DataPackage.CACHE_MISS_COST__TYPE:
				return getType();
			case DataPackage.CACHE_MISS_COST__WORST:
				return getWorst();
		}
		return super.eGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
  public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case DataPackage.CACHE_MISS_COST__BEST:
				setBest((TimeVar)newValue);
				return;
			case DataPackage.CACHE_MISS_COST__DISTRIBUTION:
				setDistribution((Distribution)newValue);
				return;
			case DataPackage.CACHE_MISS_COST__REF:
				setRef((StringVar)newValue);
				return;
			case DataPackage.CACHE_MISS_COST__TYPE:
				setType((StringVar)newValue);
				return;
			case DataPackage.CACHE_MISS_COST__WORST:
				setWorst((TimeVar)newValue);
				return;
		}
		super.eSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
  public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case DataPackage.CACHE_MISS_COST__BEST:
				setBest(BEST_EDEFAULT);
				return;
			case DataPackage.CACHE_MISS_COST__DISTRIBUTION:
				setDistribution((Distribution)null);
				return;
			case DataPackage.CACHE_MISS_COST__REF:
				setRef(REF_EDEFAULT);
				return;
			case DataPackage.CACHE_MISS_COST__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case DataPackage.CACHE_MISS_COST__WORST:
				setWorst(WORST_EDEFAULT);
				return;
		}
		super.eUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case DataPackage.CACHE_MISS_COST__BEST:
				return BEST_EDEFAULT == null ? best != null : !BEST_EDEFAULT.equals(best);
			case DataPackage.CACHE_MISS_COST__DISTRIBUTION:
				return distribution != null;
			case DataPackage.CACHE_MISS_COST__REF:
				return REF_EDEFAULT == null ? ref != null : !REF_EDEFAULT.equals(ref);
			case DataPackage.CACHE_MISS_COST__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case DataPackage.CACHE_MISS_COST__WORST:
				return WORST_EDEFAULT == null ? worst != null : !WORST_EDEFAULT.equals(worst);
		}
		return super.eIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (Best: ");
		result.append(best);
		result.append(", Ref: ");
		result.append(ref);
		result.append(", Type: ");
		result.append(type);
		result.append(", Worst: ");
		result.append(worst);
		result.append(')');
		return result.toString();
	}

		/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#getObjectID()
	 */
	public String getObjectID() {
		return makeSlahedID(new IVariable[] { ref, type});
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#setObjectID(java.lang.String)
	 */
	public boolean setObjectID(String newID) {
	  	if ( !checkNewID(newID) ) return false;
		
	  	// Store old ID
	  	String old_ID = getObjectID();
	  	
		String[] tmp = resolveID(newID);
		setRefGen (tmp[0] == null ? (StringVar) null : new StringVar(tmp[0]));
		setTypeGen(tmp[1] == null ? (StringVar) null : new StringVar(tmp[1]));
		
		// ASk to update ID
	  	didSetObjectID(old_ID);
		return true;
	}
	
  public boolean checkNewID(String newID) {
	String[] tmp = resolveID(newID);
	tmp[1] = tmp[1] == null ? null : tmp[1].toUpperCase();

	return super.checkNewID(DataPath.makeId(new String[] { tmp[0], tmp[1]}));
  }


} //CacheMissCostImpl
