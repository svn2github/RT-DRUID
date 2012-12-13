/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.Distribution;
import com.eu.evidence.rtdruid.vartree.data.Sample;

import com.eu.evidence.rtdruid.vartree.variables.DoubleVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Distribution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.DistributionImpl#getAvg <em>Avg</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.DistributionImpl#getSampleList <em>Sample List</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.DistributionImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.DistributionImpl#getVariance <em>Variance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DistributionImpl extends ObjectWithIDImpl implements Distribution {
	/**
	 * The default value of the '{@link #getAvg() <em>Avg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvg()
	 * @generated
	 * @ordered
	 */
	protected static final TimeVar AVG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAvg() <em>Avg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvg()
	 * @generated
	 * @ordered
	 */
	protected TimeVar avg = AVG_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSampleList() <em>Sample List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampleList()
	 * @generated
	 * @ordered
	 */
	protected EList<Sample> sampleList;

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
	 * The default value of the '{@link #getVariance() <em>Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariance()
	 * @generated
	 * @ordered
	 */
	protected static final DoubleVar VARIANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVariance() <em>Variance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariance()
	 * @generated
	 * @ordered
	 */
	protected DoubleVar variance = VARIANCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DistributionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.DISTRIBUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeVar getAvg() {
		return avg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAvg(TimeVar newAvg) {
		TimeVar oldAvg = avg;
		avg = newAvg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DISTRIBUTION__AVG, oldAvg, avg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Sample> getSampleList() {
		if (sampleList == null) {
			sampleList = new EObjectContainmentEList<Sample>(Sample.class, this, DataPackage.DISTRIBUTION__SAMPLE_LIST);
		}
		return sampleList;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DISTRIBUTION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleVar getVariance() {
		return variance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariance(DoubleVar newVariance) {
		DoubleVar oldVariance = variance;
		variance = newVariance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.DISTRIBUTION__VARIANCE, oldVariance, variance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataPackage.DISTRIBUTION__SAMPLE_LIST:
				return ((InternalEList<?>)getSampleList()).basicRemove(otherEnd, msgs);
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
			case DataPackage.DISTRIBUTION__AVG:
				return getAvg();
			case DataPackage.DISTRIBUTION__SAMPLE_LIST:
				return getSampleList();
			case DataPackage.DISTRIBUTION__TYPE:
				return getType();
			case DataPackage.DISTRIBUTION__VARIANCE:
				return getVariance();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DataPackage.DISTRIBUTION__AVG:
				setAvg((TimeVar)newValue);
				return;
			case DataPackage.DISTRIBUTION__SAMPLE_LIST:
				getSampleList().clear();
				getSampleList().addAll((Collection<? extends Sample>)newValue);
				return;
			case DataPackage.DISTRIBUTION__TYPE:
				setType((StringVar)newValue);
				return;
			case DataPackage.DISTRIBUTION__VARIANCE:
				setVariance((DoubleVar)newValue);
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
			case DataPackage.DISTRIBUTION__AVG:
				setAvg(AVG_EDEFAULT);
				return;
			case DataPackage.DISTRIBUTION__SAMPLE_LIST:
				getSampleList().clear();
				return;
			case DataPackage.DISTRIBUTION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case DataPackage.DISTRIBUTION__VARIANCE:
				setVariance(VARIANCE_EDEFAULT);
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
			case DataPackage.DISTRIBUTION__AVG:
				return AVG_EDEFAULT == null ? avg != null : !AVG_EDEFAULT.equals(avg);
			case DataPackage.DISTRIBUTION__SAMPLE_LIST:
				return sampleList != null && !sampleList.isEmpty();
			case DataPackage.DISTRIBUTION__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case DataPackage.DISTRIBUTION__VARIANCE:
				return VARIANCE_EDEFAULT == null ? variance != null : !VARIANCE_EDEFAULT.equals(variance);
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
		result.append(" (Avg: ");
		result.append(avg);
		result.append(", Type: ");
		result.append(type);
		result.append(", Variance: ");
		result.append(variance);
		result.append(')');
		return result.toString();
	}

} //DistributionImpl
