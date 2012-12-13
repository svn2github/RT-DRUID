/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.DataFactory;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.ProcMap;

import com.eu.evidence.rtdruid.vartree.variables.IntegerVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Proc Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ProcMapImpl#getModeRef <em>Mode Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ProcMapImpl#getOrder <em>Order</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ProcMapImpl#getProcRef <em>Proc Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ProcMapImpl#getTaskRef <em>Task Ref</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ProcMapImpl#getOnceEveryK <em>Once Every K</em>}</li>
 *   <li>{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ProcMapImpl#getMethodRefName <em>Method Ref Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcMapImpl extends ObjectWithIDImpl implements ProcMap {
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
	 * The default value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected static final IntegerVar ORDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected IntegerVar order = ORDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getProcRef() <em>Proc Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcRef()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar PROC_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProcRef() <em>Proc Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcRef()
	 * @generated
	 * @ordered
	 */
	protected StringVar procRef = PROC_REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getTaskRef() <em>Task Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskRef()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar TASK_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTaskRef() <em>Task Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskRef()
	 * @generated
	 * @ordered
	 */
	protected StringVar taskRef = TASK_REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getOnceEveryK() <em>Once Every K</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnceEveryK()
	 * @generated
	 * @ordered
	 */
	protected static final IntegerVar ONCE_EVERY_K_EDEFAULT = (IntegerVar)DataFactory.eINSTANCE.createFromString(DataPackage.eINSTANCE.getIntegerVar(), "1");

	/**
	 * The cached value of the '{@link #getOnceEveryK() <em>Once Every K</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnceEveryK()
	 * @generated
	 * @ordered
	 */
	protected IntegerVar onceEveryK = ONCE_EVERY_K_EDEFAULT;

	/**
	 * The default value of the '{@link #getMethodRefName() <em>Method Ref Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodRefName()
	 * @generated
	 * @ordered
	 */
	protected static final StringVar METHOD_REF_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMethodRefName() <em>Method Ref Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodRefName()
	 * @generated
	 * @ordered
	 */
	protected StringVar methodRefName = METHOD_REF_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcMapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataPackage.Literals.PROC_MAP;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.PROC_MAP__MODE_REF, oldModeRef, modeRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerVar getOrder() {
		return order;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrder(IntegerVar newOrder) {
		IntegerVar oldOrder = order;
		order = newOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.PROC_MAP__ORDER, oldOrder, order));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getProcRef() {
		return procRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcRef(StringVar newProcRef) {
		StringVar oldProcRef = procRef;
		procRef = newProcRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.PROC_MAP__PROC_REF, oldProcRef, procRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getTaskRef() {
		return taskRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaskRef(StringVar newTaskRef) {
		StringVar oldTaskRef = taskRef;
		taskRef = newTaskRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.PROC_MAP__TASK_REF, oldTaskRef, taskRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerVar getOnceEveryK() {
		return onceEveryK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnceEveryK(IntegerVar newOnceEveryK) {
		IntegerVar oldOnceEveryK = onceEveryK;
		onceEveryK = newOnceEveryK;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.PROC_MAP__ONCE_EVERY_K, oldOnceEveryK, onceEveryK));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar getMethodRefName() {
		return methodRefName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodRefName(StringVar newMethodRefName) {
		StringVar oldMethodRefName = methodRefName;
		methodRefName = newMethodRefName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.PROC_MAP__METHOD_REF_NAME, oldMethodRefName, methodRefName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataPackage.PROC_MAP__MODE_REF:
				return getModeRef();
			case DataPackage.PROC_MAP__ORDER:
				return getOrder();
			case DataPackage.PROC_MAP__PROC_REF:
				return getProcRef();
			case DataPackage.PROC_MAP__TASK_REF:
				return getTaskRef();
			case DataPackage.PROC_MAP__ONCE_EVERY_K:
				return getOnceEveryK();
			case DataPackage.PROC_MAP__METHOD_REF_NAME:
				return getMethodRefName();
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
			case DataPackage.PROC_MAP__MODE_REF:
				setModeRef((StringVar)newValue);
				return;
			case DataPackage.PROC_MAP__ORDER:
				setOrder((IntegerVar)newValue);
				return;
			case DataPackage.PROC_MAP__PROC_REF:
				setProcRef((StringVar)newValue);
				return;
			case DataPackage.PROC_MAP__TASK_REF:
				setTaskRef((StringVar)newValue);
				return;
			case DataPackage.PROC_MAP__ONCE_EVERY_K:
				setOnceEveryK((IntegerVar)newValue);
				return;
			case DataPackage.PROC_MAP__METHOD_REF_NAME:
				setMethodRefName((StringVar)newValue);
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
			case DataPackage.PROC_MAP__MODE_REF:
				setModeRef(MODE_REF_EDEFAULT);
				return;
			case DataPackage.PROC_MAP__ORDER:
				setOrder(ORDER_EDEFAULT);
				return;
			case DataPackage.PROC_MAP__PROC_REF:
				setProcRef(PROC_REF_EDEFAULT);
				return;
			case DataPackage.PROC_MAP__TASK_REF:
				setTaskRef(TASK_REF_EDEFAULT);
				return;
			case DataPackage.PROC_MAP__ONCE_EVERY_K:
				setOnceEveryK(ONCE_EVERY_K_EDEFAULT);
				return;
			case DataPackage.PROC_MAP__METHOD_REF_NAME:
				setMethodRefName(METHOD_REF_NAME_EDEFAULT);
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
			case DataPackage.PROC_MAP__MODE_REF:
				return MODE_REF_EDEFAULT == null ? modeRef != null : !MODE_REF_EDEFAULT.equals(modeRef);
			case DataPackage.PROC_MAP__ORDER:
				return ORDER_EDEFAULT == null ? order != null : !ORDER_EDEFAULT.equals(order);
			case DataPackage.PROC_MAP__PROC_REF:
				return PROC_REF_EDEFAULT == null ? procRef != null : !PROC_REF_EDEFAULT.equals(procRef);
			case DataPackage.PROC_MAP__TASK_REF:
				return TASK_REF_EDEFAULT == null ? taskRef != null : !TASK_REF_EDEFAULT.equals(taskRef);
			case DataPackage.PROC_MAP__ONCE_EVERY_K:
				return ONCE_EVERY_K_EDEFAULT == null ? onceEveryK != null : !ONCE_EVERY_K_EDEFAULT.equals(onceEveryK);
			case DataPackage.PROC_MAP__METHOD_REF_NAME:
				return METHOD_REF_NAME_EDEFAULT == null ? methodRefName != null : !METHOD_REF_NAME_EDEFAULT.equals(methodRefName);
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
		result.append(" (ModeRef: ");
		result.append(modeRef);
		result.append(", Order: ");
		result.append(order);
		result.append(", ProcRef: ");
		result.append(procRef);
		result.append(", TaskRef: ");
		result.append(taskRef);
		result.append(", OnceEveryK: ");
		result.append(onceEveryK);
		result.append(", MethodRefName: ");
		result.append(methodRefName);
		result.append(')');
		return result.toString();
	}

} //ProcMapImpl
