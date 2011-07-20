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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import com.eu.evidence.rtdruid.vartree.data.Annotation;
import com.eu.evidence.rtdruid.vartree.data.Architectural;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.Functional;
import com.eu.evidence.rtdruid.vartree.data.Mapping;
import com.eu.evidence.rtdruid.vartree.data.Modes;
import com.eu.evidence.rtdruid.vartree.data.Schedulability;
import com.eu.evidence.rtdruid.vartree.data.init.ObjectWithIDImpl;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SystemImpl#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SystemImpl#getArchitectural <em>Architectural</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SystemImpl#getFunctional <em>Functional</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SystemImpl#getMapping <em>Mapping</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SystemImpl#getModes <em>Modes</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SystemImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SystemImpl#getSchedulability <em>Schedulability</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SystemImpl#getXTC_Cookie <em>XTC Cookie</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemImpl extends ObjectWithIDImpl implements com.eu.evidence.rtdruid.vartree.data.System
{
	/**
	 * The cached value of the '{@link #getAnnotation() <em>Annotation</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAnnotation()
	 * @generated
	 * @ordered
	 */
  protected Annotation annotation = null;

	/**
	 * The cached value of the '{@link #getArchitectural() <em>Architectural</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getArchitectural()
	 * @generated
	 * @ordered
	 */
  protected Architectural architectural = null;

	/**
	 * The cached value of the '{@link #getFunctional() <em>Functional</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFunctional()
	 * @generated
	 * @ordered
	 */
  protected Functional functional = null;

	/**
	 * The cached value of the '{@link #getMapping() <em>Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMapping()
	 * @generated
	 * @ordered
	 */
  protected Mapping mapping = null;

	/**
	 * The cached value of the '{@link #getModes() <em>Modes</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getModes()
	 * @generated
	 * @ordered
	 */
  protected Modes modes = null;

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
	 * The cached value of the '{@link #getSchedulability() <em>Schedulability</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSchedulability()
	 * @generated
	 * @ordered
	 */
  protected Schedulability schedulability = null;

	/**
	 * The cached value of the '{@link #getXTC_Cookie() <em>XTC Cookie</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXTC_Cookie()
	 * @generated
	 * @ordered
	 */
	protected EList xtC_Cookie = null;

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected SystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EClass eStaticClass() {
		return DataPackage.eINSTANCE.getSystem();
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
      eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.SYSTEM__NAME, oldName, name));
  }

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Modes getModes() {
		return modes;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getXTC_Cookie() {
		if (xtC_Cookie == null) {
			xtC_Cookie = new EDataTypeUniqueEList(StringVar.class, this, DataPackage.SYSTEM__XTC_COOKIE);
		}
 		return xtC_Cookie;
 	}
 
 	/**
 	 * <!-- begin-user-doc -->
 	 * <!-- end-user-doc -->
 	 * @generated
 	 */
  public NotificationChain basicSetModes(Modes newModes, NotificationChain msgs) {
		Modes oldModes = modes;
		modes = newModes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataPackage.SYSTEM__MODES, oldModes, newModes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setModes(Modes newModes) {
		if (newModes != modes) {
			NotificationChain msgs = null;
			if (modes != null)
				msgs = ((InternalEObject)modes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataPackage.SYSTEM__MODES, null, msgs);
			if (newModes != null)
				msgs = ((InternalEObject)newModes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataPackage.SYSTEM__MODES, null, msgs);
			msgs = basicSetModes(newModes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.SYSTEM__MODES, newModes, newModes));
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Functional getFunctional() {
		return functional;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetFunctional(Functional newFunctional, NotificationChain msgs) {
		Functional oldFunctional = functional;
		functional = newFunctional;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataPackage.SYSTEM__FUNCTIONAL, oldFunctional, newFunctional);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setFunctional(Functional newFunctional) {
		if (newFunctional != functional) {
			NotificationChain msgs = null;
			if (functional != null)
				msgs = ((InternalEObject)functional).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataPackage.SYSTEM__FUNCTIONAL, null, msgs);
			if (newFunctional != null)
				msgs = ((InternalEObject)newFunctional).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataPackage.SYSTEM__FUNCTIONAL, null, msgs);
			msgs = basicSetFunctional(newFunctional, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.SYSTEM__FUNCTIONAL, newFunctional, newFunctional));
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Architectural getArchitectural() {
		return architectural;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetArchitectural(Architectural newArchitectural, NotificationChain msgs) {
		Architectural oldArchitectural = architectural;
		architectural = newArchitectural;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataPackage.SYSTEM__ARCHITECTURAL, oldArchitectural, newArchitectural);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setArchitectural(Architectural newArchitectural) {
		if (newArchitectural != architectural) {
			NotificationChain msgs = null;
			if (architectural != null)
				msgs = ((InternalEObject)architectural).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataPackage.SYSTEM__ARCHITECTURAL, null, msgs);
			if (newArchitectural != null)
				msgs = ((InternalEObject)newArchitectural).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataPackage.SYSTEM__ARCHITECTURAL, null, msgs);
			msgs = basicSetArchitectural(newArchitectural, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.SYSTEM__ARCHITECTURAL, newArchitectural, newArchitectural));
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Mapping getMapping() {
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetMapping(Mapping newMapping, NotificationChain msgs) {
		Mapping oldMapping = mapping;
		mapping = newMapping;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataPackage.SYSTEM__MAPPING, oldMapping, newMapping);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMapping(Mapping newMapping) {
		if (newMapping != mapping) {
			NotificationChain msgs = null;
			if (mapping != null)
				msgs = ((InternalEObject)mapping).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataPackage.SYSTEM__MAPPING, null, msgs);
			if (newMapping != null)
				msgs = ((InternalEObject)newMapping).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataPackage.SYSTEM__MAPPING, null, msgs);
			msgs = basicSetMapping(newMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.SYSTEM__MAPPING, newMapping, newMapping));
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Annotation getAnnotation() {
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetAnnotation(Annotation newAnnotation, NotificationChain msgs) {
		Annotation oldAnnotation = annotation;
		annotation = newAnnotation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataPackage.SYSTEM__ANNOTATION, oldAnnotation, newAnnotation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAnnotation(Annotation newAnnotation) {
		if (newAnnotation != annotation) {
			NotificationChain msgs = null;
			if (annotation != null)
				msgs = ((InternalEObject)annotation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataPackage.SYSTEM__ANNOTATION, null, msgs);
			if (newAnnotation != null)
				msgs = ((InternalEObject)newAnnotation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataPackage.SYSTEM__ANNOTATION, null, msgs);
			msgs = basicSetAnnotation(newAnnotation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.SYSTEM__ANNOTATION, newAnnotation, newAnnotation));
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Schedulability getSchedulability() {
		return schedulability;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetSchedulability(Schedulability newSchedulability, NotificationChain msgs) {
		Schedulability oldSchedulability = schedulability;
		schedulability = newSchedulability;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataPackage.SYSTEM__SCHEDULABILITY, oldSchedulability, newSchedulability);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSchedulability(Schedulability newSchedulability) {
		if (newSchedulability != schedulability) {
			NotificationChain msgs = null;
			if (schedulability != null)
				msgs = ((InternalEObject)schedulability).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataPackage.SYSTEM__SCHEDULABILITY, null, msgs);
			if (newSchedulability != null)
				msgs = ((InternalEObject)newSchedulability).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataPackage.SYSTEM__SCHEDULABILITY, null, msgs);
			msgs = basicSetSchedulability(newSchedulability, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.SYSTEM__SCHEDULABILITY, newSchedulability, newSchedulability));
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case DataPackage.SYSTEM__ANNOTATION:
					return basicSetAnnotation(null, msgs);
				case DataPackage.SYSTEM__ARCHITECTURAL:
					return basicSetArchitectural(null, msgs);
				case DataPackage.SYSTEM__FUNCTIONAL:
					return basicSetFunctional(null, msgs);
				case DataPackage.SYSTEM__MAPPING:
					return basicSetMapping(null, msgs);
				case DataPackage.SYSTEM__MODES:
					return basicSetModes(null, msgs);
				case DataPackage.SYSTEM__SCHEDULABILITY:
					return basicSetSchedulability(null, msgs);
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
			case DataPackage.SYSTEM__ANNOTATION:
				return getAnnotation();
			case DataPackage.SYSTEM__ARCHITECTURAL:
				return getArchitectural();
			case DataPackage.SYSTEM__FUNCTIONAL:
				return getFunctional();
			case DataPackage.SYSTEM__MAPPING:
				return getMapping();
			case DataPackage.SYSTEM__MODES:
				return getModes();
			case DataPackage.SYSTEM__NAME:
				return getName();
			case DataPackage.SYSTEM__SCHEDULABILITY:
				return getSchedulability();
			case DataPackage.SYSTEM__XTC_COOKIE:
				return getXTC_Cookie();
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
			case DataPackage.SYSTEM__ANNOTATION:
				setAnnotation((Annotation)newValue);
				return;
			case DataPackage.SYSTEM__ARCHITECTURAL:
				setArchitectural((Architectural)newValue);
				return;
			case DataPackage.SYSTEM__FUNCTIONAL:
				setFunctional((Functional)newValue);
				return;
			case DataPackage.SYSTEM__MAPPING:
				setMapping((Mapping)newValue);
				return;
			case DataPackage.SYSTEM__MODES:
				setModes((Modes)newValue);
				return;
			case DataPackage.SYSTEM__NAME:
				setName((StringVar)newValue);
				return;
			case DataPackage.SYSTEM__SCHEDULABILITY:
				setSchedulability((Schedulability)newValue);
				return;
			case DataPackage.SYSTEM__XTC_COOKIE:
				getXTC_Cookie().clear();
				getXTC_Cookie().addAll((Collection)newValue);
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
			case DataPackage.SYSTEM__ANNOTATION:
				setAnnotation((Annotation)null);
				return;
			case DataPackage.SYSTEM__ARCHITECTURAL:
				setArchitectural((Architectural)null);
				return;
			case DataPackage.SYSTEM__FUNCTIONAL:
				setFunctional((Functional)null);
				return;
			case DataPackage.SYSTEM__MAPPING:
				setMapping((Mapping)null);
				return;
			case DataPackage.SYSTEM__MODES:
				setModes((Modes)null);
				return;
			case DataPackage.SYSTEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DataPackage.SYSTEM__SCHEDULABILITY:
				setSchedulability((Schedulability)null);
				return;
			case DataPackage.SYSTEM__XTC_COOKIE:
				getXTC_Cookie().clear();
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
			case DataPackage.SYSTEM__ANNOTATION:
				return annotation != null;
			case DataPackage.SYSTEM__ARCHITECTURAL:
				return architectural != null;
			case DataPackage.SYSTEM__FUNCTIONAL:
				return functional != null;
			case DataPackage.SYSTEM__MAPPING:
				return mapping != null;
			case DataPackage.SYSTEM__MODES:
				return modes != null;
			case DataPackage.SYSTEM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DataPackage.SYSTEM__SCHEDULABILITY:
				return schedulability != null;
			case DataPackage.SYSTEM__XTC_COOKIE:
				return xtC_Cookie != null && !xtC_Cookie.isEmpty();
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
		result.append(", XTC_Cookie: ");
		result.append(xtC_Cookie);
		result.append(')');
		return result.toString();
	}

	/* (non-Javadoc)
	 * @see rtdruid.vartree.data.ObjectWithID#getID()
	 */
	public String getID() {
		return (name == null ? null : (String) name.get());
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
} //SystemImpl
