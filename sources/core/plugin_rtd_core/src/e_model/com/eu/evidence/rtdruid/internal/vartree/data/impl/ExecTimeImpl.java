/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.Distribution;
import com.eu.evidence.rtdruid.vartree.data.ExecTime;

import com.eu.evidence.rtdruid.vartree.variables.StringVar;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exec Time</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ExecTimeImpl#getBest <em>Best</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ExecTimeImpl#getDistribution <em>Distribution</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ExecTimeImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ExecTimeImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ExecTimeImpl#getWorst <em>Worst</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecTimeImpl extends ObjectWithIDImpl implements ExecTime {
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
	protected Distribution distribution;

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
	protected ExecTimeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.EXEC_TIME;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.EXEC_TIME__BEST, oldBest, best));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataPackage.EXEC_TIME__DISTRIBUTION, oldDistribution, newDistribution);
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
				msgs = ((InternalEObject)distribution).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataPackage.EXEC_TIME__DISTRIBUTION, null, msgs);
			if (newDistribution != null)
				msgs = ((InternalEObject)newDistribution).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataPackage.EXEC_TIME__DISTRIBUTION, null, msgs);
			msgs = basicSetDistribution(newDistribution, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.EXEC_TIME__DISTRIBUTION, newDistribution, newDistribution));
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
	 * @generated
	 */
	public void setRef(StringVar newRef) {
		StringVar oldRef = ref;
		ref = newRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.EXEC_TIME__REF, oldRef, ref));
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
	 * @generated
	 */
	public void setType(StringVar newType) {
		StringVar oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.EXEC_TIME__TYPE, oldType, type));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.EXEC_TIME__WORST, oldWorst, worst));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataPackage.EXEC_TIME__DISTRIBUTION:
				return basicSetDistribution(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.EXEC_TIME__BEST:
				return getBest();
			case DataPackage.EXEC_TIME__DISTRIBUTION:
				return getDistribution();
			case DataPackage.EXEC_TIME__REF:
				return getRef();
			case DataPackage.EXEC_TIME__TYPE:
				return getType();
			case DataPackage.EXEC_TIME__WORST:
				return getWorst();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DataPackage.EXEC_TIME__BEST:
				setBest((TimeVar)newValue);
				return;
			case DataPackage.EXEC_TIME__DISTRIBUTION:
				setDistribution((Distribution)newValue);
				return;
			case DataPackage.EXEC_TIME__REF:
				setRef((StringVar)newValue);
				return;
			case DataPackage.EXEC_TIME__TYPE:
				setType((StringVar)newValue);
				return;
			case DataPackage.EXEC_TIME__WORST:
				setWorst((TimeVar)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DataPackage.EXEC_TIME__BEST:
				setBest(BEST_EDEFAULT);
				return;
			case DataPackage.EXEC_TIME__DISTRIBUTION:
				setDistribution((Distribution)null);
				return;
			case DataPackage.EXEC_TIME__REF:
				setRef(REF_EDEFAULT);
				return;
			case DataPackage.EXEC_TIME__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case DataPackage.EXEC_TIME__WORST:
				setWorst(WORST_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DataPackage.EXEC_TIME__BEST:
				return BEST_EDEFAULT == null ? best != null : !BEST_EDEFAULT.equals(best);
			case DataPackage.EXEC_TIME__DISTRIBUTION:
				return distribution != null;
			case DataPackage.EXEC_TIME__REF:
				return REF_EDEFAULT == null ? ref != null : !REF_EDEFAULT.equals(ref);
			case DataPackage.EXEC_TIME__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case DataPackage.EXEC_TIME__WORST:
				return WORST_EDEFAULT == null ? worst != null : !WORST_EDEFAULT.equals(worst);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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

} //ExecTimeImpl
