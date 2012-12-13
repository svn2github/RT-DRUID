/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.Activation;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

import com.eu.evidence.rtdruid.vartree.variables.IntegerVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ActivationImpl#getActNumber <em>Act Number</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ActivationImpl#getActivationClass <em>Activation Class</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ActivationImpl#getDeadline <em>Deadline</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ActivationImpl#getModeRef <em>Mode Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ActivationImpl#getOffset <em>Offset</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ActivationImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ActivationImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActivationImpl extends ObjectWithIDImpl implements Activation {
	/**
	 * The default value of the '{@link #getActNumber() <em>Act Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActNumber()
	 * @generated
	 * @ordered
	 */
	protected static final IntegerVar ACT_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActNumber() <em>Act Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActNumber()
	 * @generated
	 * @ordered
	 */
	protected IntegerVar actNumber = ACT_NUMBER_EDEFAULT;

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
	 * The default value of the '{@link #getDeadline() <em>Deadline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeadline()
	 * @generated
	 * @ordered
	 */
	protected static final TimeVar DEADLINE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDeadline() <em>Deadline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeadline()
	 * @generated
	 * @ordered
	 */
	protected TimeVar deadline = DEADLINE_EDEFAULT;

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
	 * The default value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected static final TimeVar OFFSET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected TimeVar offset = OFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getPeriod() <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriod()
	 * @generated
	 * @ordered
	 */
	protected static final TimeVar PERIOD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPeriod() <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriod()
	 * @generated
	 * @ordered
	 */
	protected TimeVar period = PERIOD_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.ACTIVATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerVar getActNumber() {
		return actNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActNumber(IntegerVar newActNumber) {
		IntegerVar oldActNumber = actNumber;
		actNumber = newActNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ACTIVATION__ACT_NUMBER, oldActNumber, actNumber));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ACTIVATION__ACTIVATION_CLASS, oldActivationClass, activationClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeVar getDeadline() {
		return deadline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeadline(TimeVar newDeadline) {
		TimeVar oldDeadline = deadline;
		deadline = newDeadline;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ACTIVATION__DEADLINE, oldDeadline, deadline));
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
	 * @generated
	 */
	public void setModeRef(StringVar newModeRef) {
		StringVar oldModeRef = modeRef;
		modeRef = newModeRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ACTIVATION__MODE_REF, oldModeRef, modeRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeVar getOffset() {
		return offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOffset(TimeVar newOffset) {
		TimeVar oldOffset = offset;
		offset = newOffset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ACTIVATION__OFFSET, oldOffset, offset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeVar getPeriod() {
		return period;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriod(TimeVar newPeriod) {
		TimeVar oldPeriod = period;
		period = newPeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ACTIVATION__PERIOD, oldPeriod, period));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ACTIVATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.ACTIVATION__ACT_NUMBER:
				return getActNumber();
			case DataPackage.ACTIVATION__ACTIVATION_CLASS:
				return getActivationClass();
			case DataPackage.ACTIVATION__DEADLINE:
				return getDeadline();
			case DataPackage.ACTIVATION__MODE_REF:
				return getModeRef();
			case DataPackage.ACTIVATION__OFFSET:
				return getOffset();
			case DataPackage.ACTIVATION__PERIOD:
				return getPeriod();
			case DataPackage.ACTIVATION__TYPE:
				return getType();
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
			case DataPackage.ACTIVATION__ACT_NUMBER:
				setActNumber((IntegerVar)newValue);
				return;
			case DataPackage.ACTIVATION__ACTIVATION_CLASS:
				setActivationClass((StringVar)newValue);
				return;
			case DataPackage.ACTIVATION__DEADLINE:
				setDeadline((TimeVar)newValue);
				return;
			case DataPackage.ACTIVATION__MODE_REF:
				setModeRef((StringVar)newValue);
				return;
			case DataPackage.ACTIVATION__OFFSET:
				setOffset((TimeVar)newValue);
				return;
			case DataPackage.ACTIVATION__PERIOD:
				setPeriod((TimeVar)newValue);
				return;
			case DataPackage.ACTIVATION__TYPE:
				setType((StringVar)newValue);
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
			case DataPackage.ACTIVATION__ACT_NUMBER:
				setActNumber(ACT_NUMBER_EDEFAULT);
				return;
			case DataPackage.ACTIVATION__ACTIVATION_CLASS:
				setActivationClass(ACTIVATION_CLASS_EDEFAULT);
				return;
			case DataPackage.ACTIVATION__DEADLINE:
				setDeadline(DEADLINE_EDEFAULT);
				return;
			case DataPackage.ACTIVATION__MODE_REF:
				setModeRef(MODE_REF_EDEFAULT);
				return;
			case DataPackage.ACTIVATION__OFFSET:
				setOffset(OFFSET_EDEFAULT);
				return;
			case DataPackage.ACTIVATION__PERIOD:
				setPeriod(PERIOD_EDEFAULT);
				return;
			case DataPackage.ACTIVATION__TYPE:
				setType(TYPE_EDEFAULT);
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
			case DataPackage.ACTIVATION__ACT_NUMBER:
				return ACT_NUMBER_EDEFAULT == null ? actNumber != null : !ACT_NUMBER_EDEFAULT.equals(actNumber);
			case DataPackage.ACTIVATION__ACTIVATION_CLASS:
				return ACTIVATION_CLASS_EDEFAULT == null ? activationClass != null : !ACTIVATION_CLASS_EDEFAULT.equals(activationClass);
			case DataPackage.ACTIVATION__DEADLINE:
				return DEADLINE_EDEFAULT == null ? deadline != null : !DEADLINE_EDEFAULT.equals(deadline);
			case DataPackage.ACTIVATION__MODE_REF:
				return MODE_REF_EDEFAULT == null ? modeRef != null : !MODE_REF_EDEFAULT.equals(modeRef);
			case DataPackage.ACTIVATION__OFFSET:
				return OFFSET_EDEFAULT == null ? offset != null : !OFFSET_EDEFAULT.equals(offset);
			case DataPackage.ACTIVATION__PERIOD:
				return PERIOD_EDEFAULT == null ? period != null : !PERIOD_EDEFAULT.equals(period);
			case DataPackage.ACTIVATION__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
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
		result.append(" (ActNumber: ");
		result.append(actNumber);
		result.append(", ActivationClass: ");
		result.append(activationClass);
		result.append(", Deadline: ");
		result.append(deadline);
		result.append(", ModeRef: ");
		result.append(modeRef);
		result.append(", Offset: ");
		result.append(offset);
		result.append(", Period: ");
		result.append(period);
		result.append(", Type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //ActivationImpl
