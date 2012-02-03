/**
 * <copyright>
 * </copyright>
 *
 * $Id: OilApplPackage.java,v 1.1 2005/09/28 15:22:30 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.data.oil;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.eu.evidence.rtdruid.vartree.data.DataPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilApplFactory
 * @generated
 */
public interface OilApplPackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "oil";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://rtdruid.vartree.data.oil";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "rtdruid.vartree.data.oil";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OilApplPackage eINSTANCE = com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.OilApplPackageImpl.init();

	/**
	 * The base value for all meta object id
	 */
	int OIL_BASE_ID = 1000;
	
	/**
	 * The meta object id for the '{@link rtdruid.vartree.data.oil.impl.OilObjectWithIDImpl <em>Oil Object With ID</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.OilObjectWithIDImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.OilApplPackageImpl#getOilObjectWithID()
	 * @generated NOT
	 */
	int OIL_OBJECT_WITH_ID = OIL_BASE_ID + 4;

	/**
	 * The number of structural features of the the '<em>Oil Object With ID</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OIL_OBJECT_WITH_ID_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link rtdruid.vartree.data.oil.impl.RootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.RootImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.OilApplPackageImpl#getRoot()
	 * @generated NOT
	 */
	int ROOT = OIL_BASE_ID + 0;

	/**
	 * The feature id for the '<em><b>Hw List</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__HW_LIST = OIL_OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Object Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__OBJECT_TYPE = OIL_OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__DESCRIPTION = OIL_OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_FEATURE_COUNT = OIL_OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link rtdruid.vartree.data.oil.impl.HWImpl <em>HW</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.HWImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.OilApplPackageImpl#getHW()
	 * @generated NOT
	 */
	int HW = OIL_BASE_ID + 1;

	/**
	 * The feature id for the '<em><b>Rtos List</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW__RTOS_LIST = OIL_OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW__NAME = OIL_OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW__DESCRIPTION = OIL_OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the the '<em>HW</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_FEATURE_COUNT = OIL_OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link rtdruid.vartree.data.oil.impl.RTOSImpl <em>RTOS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.RTOSImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.OilApplPackageImpl#getRTOS()
	 * @generated NOT
	 */
	int RTOS = OIL_BASE_ID + 2;

	/**
	 * The feature id for the '<em><b>Parameter List</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RTOS__PARAMETER_LIST = OIL_OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RTOS__NAME = OIL_OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RTOS__DESCRIPTION = OIL_OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the the '<em>RTOS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RTOS_FEATURE_COUNT = OIL_OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link rtdruid.vartree.data.oil.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.ParameterImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.OilApplPackageImpl#getParameter()
	 * @generated NOT
	 */
	int PARAMETER = OIL_BASE_ID + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = OIL_OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = OIL_OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Multi Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__MULTI_VALUES = OIL_OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = OIL_OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link rtdruid.vartree.data.oil.impl.VariantImpl <em>Variant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.VariantImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.OilApplPackageImpl#getVariant()
	 * @generated NOT
	 */
	int VARIANT = OIL_BASE_ID + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT__NAME = PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT__TYPE = PARAMETER__TYPE;

	/**
	 * The feature id for the '<em><b>Multi Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT__MULTI_VALUES = PARAMETER__MULTI_VALUES;

	/**
	 * The feature id for the '<em><b>Enumerator List</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT__ENUMERATOR_LIST = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Variant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link rtdruid.vartree.data.oil.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.ValueImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.OilApplPackageImpl#getValue()
	 * @generated NOT
	 */
	int VALUE = OIL_BASE_ID + 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__NAME = PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__TYPE = PARAMETER__TYPE;

	/**
	 * The feature id for the '<em><b>Multi Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__MULTI_VALUES = PARAMETER__MULTI_VALUES;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__VALUES = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link rtdruid.vartree.data.oil.impl.EnumeratorImpl <em>Enumerator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.EnumeratorImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.OilApplPackageImpl#getEnumerator()
	 * @generated NOT
	 */
	int ENUMERATOR = OIL_BASE_ID + 7;

	/**
	 * The feature id for the '<em><b>Parameter List</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR__PARAMETER_LIST = OIL_OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR__VALUE = OIL_OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR__INDEX = OIL_OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the the '<em>Enumerator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR_FEATURE_COUNT = OIL_OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '<em>String Var</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.variables.StringVar
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.OilApplPackageImpl#getStringVar()
	 * @generated NOT
	 */
	int STRING_VAR = DataPackage.STRING_VAR;//8;

	/**
	 * The meta object id for the '<em>Var With Descr Var</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.vartree.variables.StringDescrVar
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.OilApplPackageImpl#getVarWithDescrVar()
	 * @generated
	 */
	int VAR_WITH_DESCR_VAR = 9;


	/**
	 * The meta object id for the '<em>Integer Var</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.variables.IntegerVar
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.OilApplPackageImpl#getIntegerVar()
	 * @generated NOT
	 */
	int INTEGER_VAR = DataPackage.INTEGER_VAR;


	/**
	 * The meta object id for the '<em>Boolean Var</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.variables.BooleanVar
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.oil.impl.OilApplPackageImpl#getBooleanVar()
	 * @generated NOT
	 */
	int BOOLEAN_VAR = DataPackage.BOOLEAN_VAR;


	/**
	 * Returns the meta object for class '{@link rtdruid.vartree.data.oil.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.Root
	 * @generated
	 */
	EClass getRoot();

	/**
	 * Returns the meta object for the reference list '{@link com.eu.evidence.rtdruid.vartree.data.oil.Root#getHwList <em>Hw List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Hw List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.Root#getHwList()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_HwList();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.oil.Root#getObjectType <em>Object Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object Type</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.Root#getObjectType()
	 * @see #getRoot()
	 * @generated
	 */
	EAttribute getRoot_ObjectType();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.oil.Root#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.Root#getDescription()
	 * @see #getRoot()
	 * @generated
	 */
	EAttribute getRoot_Description();

	/**
	 * Returns the meta object for class '{@link rtdruid.vartree.data.oil.HW <em>HW</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HW</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.HW
	 * @generated
	 */
	EClass getHW();

	/**
	 * Returns the meta object for the reference list '{@link com.eu.evidence.rtdruid.vartree.data.oil.HW#getRtosList <em>Rtos List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Rtos List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.HW#getRtosList()
	 * @see #getHW()
	 * @generated
	 */
	EReference getHW_RtosList();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.oil.HW#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.HW#getName()
	 * @see #getHW()
	 * @generated
	 */
	EAttribute getHW_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.oil.HW#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.HW#getDescription()
	 * @see #getHW()
	 * @generated
	 */
	EAttribute getHW_Description();

	/**
	 * Returns the meta object for class '{@link rtdruid.vartree.data.oil.RTOS <em>RTOS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>RTOS</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.RTOS
	 * @generated
	 */
	EClass getRTOS();

	/**
	 * Returns the meta object for the reference list '{@link com.eu.evidence.rtdruid.vartree.data.oil.RTOS#getParameterList <em>Parameter List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameter List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.RTOS#getParameterList()
	 * @see #getRTOS()
	 * @generated
	 */
	EReference getRTOS_ParameterList();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.oil.RTOS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.RTOS#getName()
	 * @see #getRTOS()
	 * @generated
	 */
	EAttribute getRTOS_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.oil.RTOS#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.RTOS#getDescription()
	 * @see #getRTOS()
	 * @generated
	 */
	EAttribute getRTOS_Description();

	/**
	 * Returns the meta object for class '{@link rtdruid.vartree.data.oil.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.oil.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.oil.Parameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.Parameter#getType()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.oil.Parameter#getMultiValues <em>Multi Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multi Values</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.Parameter#getMultiValues()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_MultiValues();

	/**
	 * Returns the meta object for class '{@link rtdruid.vartree.data.oil.OilObjectWithID <em>Oil Object With ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Oil Object With ID</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.OilObjectWithID
	 * @generated
	 */
	EClass getOilObjectWithID();

	/**
	 * Returns the meta object for class '{@link rtdruid.vartree.data.oil.Variant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variant</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.Variant
	 * @generated
	 */
	EClass getVariant();

	/**
	 * Returns the meta object for the reference list '{@link com.eu.evidence.rtdruid.vartree.data.oil.Variant#getEnumeratorList <em>Enumerator List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Enumerator List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.Variant#getEnumeratorList()
	 * @see #getVariant()
	 * @generated
	 */
	EReference getVariant_EnumeratorList();

	/**
	 * Returns the meta object for class '{@link rtdruid.vartree.data.oil.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for the attribute list '{@link com.eu.evidence.rtdruid.vartree.data.oil.Value#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.Value#getValues()
	 * @see #getValue()
	 * @generated
	 */
	EAttribute getValue_Values();

	/**
	 * Returns the meta object for class '{@link rtdruid.vartree.data.oil.Enumerator <em>Enumerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumerator</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.Enumerator
	 * @generated
	 */
	EClass getEnumerator();

	/**
	 * Returns the meta object for the reference list '{@link com.eu.evidence.rtdruid.vartree.data.oil.Enumerator#getParameterList <em>Parameter List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameter List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.Enumerator#getParameterList()
	 * @see #getEnumerator()
	 * @generated
	 */
	EReference getEnumerator_ParameterList();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.oil.Enumerator#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.Enumerator#getValue()
	 * @see #getEnumerator()
	 * @generated
	 */
	EAttribute getEnumerator_Value();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.oil.Enumerator#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.oil.Enumerator#getIndex()
	 * @see #getEnumerator()
	 * @generated
	 */
	EAttribute getEnumerator_Index();

	/**
	 * Returns the meta object for data type '{@link rtdruid.vartree.variables.StringVar <em>String Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String Var</em>'.
	 * @see com.eu.evidence.rtdruid.internal.vartree.variables.StringVar
	 * @model instanceClass="rtdruid.vartree.variables.StringVar"
	 * @generated
	 */
	EDataType getStringVar();

	/**
	 * Returns the meta object for data type '{@link rtdruid.vartree.variables.StringDescrVar <em>Var With Descr Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Var With Descr Var</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.variables.StringDescrVar
	 * @model instanceClass="rtdruid.vartree.variables.StringDescrVar"
	 * @generated
	 */
	EDataType getVarWithDescrVar();

	/**
	 * Returns the meta object for data type '{@link rtdruid.vartree.variables.IntegerVar <em>Integer Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Integer Var</em>'.
	 * @see com.eu.evidence.rtdruid.internal.vartree.variables.IntegerVar
	 * @model instanceClass="rtdruid.vartree.variables.IntegerVar"
	 * @generated
	 */
	EDataType getIntegerVar();

	/**
	 * Returns the meta object for data type '{@link rtdruid.vartree.variables.BooleanVar <em>Boolean Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Boolean Var</em>'.
	 * @see com.eu.evidence.rtdruid.internal.vartree.variables.BooleanVar
	 * @model instanceClass="rtdruid.vartree.variables.BooleanVar"
	 * @generated
	 */
	EDataType getBooleanVar();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OilApplFactory getOilApplFactory();

} //OilApplPackage
