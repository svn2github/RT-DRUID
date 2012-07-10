/**
 */
package com.eu.evidence.rtdruid.oil.internal.xtext.model.impl;

import com.eu.evidence.rtdruid.oil.xtext.model.OilApplication;
import com.eu.evidence.rtdruid.oil.xtext.model.OilFile;
import com.eu.evidence.rtdruid.oil.xtext.model.OilImplementation;
import com.eu.evidence.rtdruid.oil.xtext.model.OilPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilFileImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilFileImpl#getApplication <em>Application</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilFileImpl#getOilVersion <em>Oil Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OilFileImpl extends EObjectImpl implements OilFile {
	/**
	 * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected OilImplementation implementation;

	/**
	 * The cached value of the '{@link #getApplication() <em>Application</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplication()
	 * @generated
	 * @ordered
	 */
	protected OilApplication application;

	/**
	 * The default value of the '{@link #getOilVersion() <em>Oil Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOilVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String OIL_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOilVersion() <em>Oil Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOilVersion()
	 * @generated
	 * @ordered
	 */
	protected String oilVersion = OIL_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OilFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OilPackage.Literals.OIL_FILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OilImplementation getImplementation() {
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImplementation(OilImplementation newImplementation, NotificationChain msgs) {
		OilImplementation oldImplementation = implementation;
		implementation = newImplementation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OilPackage.OIL_FILE__IMPLEMENTATION, oldImplementation, newImplementation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementation(OilImplementation newImplementation) {
		if (newImplementation != implementation) {
			NotificationChain msgs = null;
			if (implementation != null)
				msgs = ((InternalEObject)implementation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OilPackage.OIL_FILE__IMPLEMENTATION, null, msgs);
			if (newImplementation != null)
				msgs = ((InternalEObject)newImplementation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OilPackage.OIL_FILE__IMPLEMENTATION, null, msgs);
			msgs = basicSetImplementation(newImplementation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilPackage.OIL_FILE__IMPLEMENTATION, newImplementation, newImplementation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OilApplication getApplication() {
		return application;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetApplication(OilApplication newApplication, NotificationChain msgs) {
		OilApplication oldApplication = application;
		application = newApplication;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OilPackage.OIL_FILE__APPLICATION, oldApplication, newApplication);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplication(OilApplication newApplication) {
		if (newApplication != application) {
			NotificationChain msgs = null;
			if (application != null)
				msgs = ((InternalEObject)application).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OilPackage.OIL_FILE__APPLICATION, null, msgs);
			if (newApplication != null)
				msgs = ((InternalEObject)newApplication).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OilPackage.OIL_FILE__APPLICATION, null, msgs);
			msgs = basicSetApplication(newApplication, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilPackage.OIL_FILE__APPLICATION, newApplication, newApplication));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOilVersion() {
		return oilVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOilVersion(String newOilVersion) {
		String oldOilVersion = oilVersion;
		oilVersion = newOilVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OilPackage.OIL_FILE__OIL_VERSION, oldOilVersion, oilVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OilPackage.OIL_FILE__IMPLEMENTATION:
				return basicSetImplementation(null, msgs);
			case OilPackage.OIL_FILE__APPLICATION:
				return basicSetApplication(null, msgs);
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
			case OilPackage.OIL_FILE__IMPLEMENTATION:
				return getImplementation();
			case OilPackage.OIL_FILE__APPLICATION:
				return getApplication();
			case OilPackage.OIL_FILE__OIL_VERSION:
				return getOilVersion();
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
			case OilPackage.OIL_FILE__IMPLEMENTATION:
				setImplementation((OilImplementation)newValue);
				return;
			case OilPackage.OIL_FILE__APPLICATION:
				setApplication((OilApplication)newValue);
				return;
			case OilPackage.OIL_FILE__OIL_VERSION:
				setOilVersion((String)newValue);
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
			case OilPackage.OIL_FILE__IMPLEMENTATION:
				setImplementation((OilImplementation)null);
				return;
			case OilPackage.OIL_FILE__APPLICATION:
				setApplication((OilApplication)null);
				return;
			case OilPackage.OIL_FILE__OIL_VERSION:
				setOilVersion(OIL_VERSION_EDEFAULT);
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
			case OilPackage.OIL_FILE__IMPLEMENTATION:
				return implementation != null;
			case OilPackage.OIL_FILE__APPLICATION:
				return application != null;
			case OilPackage.OIL_FILE__OIL_VERSION:
				return OIL_VERSION_EDEFAULT == null ? oilVersion != null : !OIL_VERSION_EDEFAULT.equals(oilVersion);
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
		result.append(" (oilVersion: ");
		result.append(oilVersion);
		result.append(')');
		return result.toString();
	}

} //OilFileImpl
