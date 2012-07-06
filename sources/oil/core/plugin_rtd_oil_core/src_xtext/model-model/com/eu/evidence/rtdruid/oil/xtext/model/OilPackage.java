/**
 */
package com.eu.evidence.rtdruid.oil.xtext.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilFactory
 * @model kind="package"
 * @generated
 */
public interface OilPackage extends EPackage {
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
	String eNS_URI = "http://com.eu.evidence.rtdruid.oil.xtext.model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.eu.evidence.rtdruid.oil.xtext";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OilPackage eINSTANCE = com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterRef <em>Parameter Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ParameterRef
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getParameterRef()
	 * @generated
	 */
	int PARAMETER_REF = 11;

	/**
	 * The number of structural features of the '<em>Parameter Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_REF_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilObjectImpl <em>Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilObjectImpl
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getOilObject()
	 * @generated
	 */
	int OIL_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OIL_OBJECT__PARAMETERS = PARAMETER_REF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OIL_OBJECT__NAME = PARAMETER_REF_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OIL_OBJECT__TYPE = PARAMETER_REF_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OIL_OBJECT__DESCRIPTION = PARAMETER_REF_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OIL_OBJECT_FEATURE_COUNT = PARAMETER_REF_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ParameterImpl
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Auto</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__AUTO = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VALUE = 3;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__PARAMETERS = 4;

	/**
	 * The feature id for the '<em><b>Value Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VALUE_REF = 5;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilApplicationImpl <em>Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilApplicationImpl
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getOilApplication()
	 * @generated
	 */
	int OIL_APPLICATION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OIL_APPLICATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Oil Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OIL_APPLICATION__OIL_OBJECTS = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OIL_APPLICATION__DESCRIPTION = 2;

	/**
	 * The number of structural features of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OIL_APPLICATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilImplementationImpl <em>Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilImplementationImpl
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getOilImplementation()
	 * @generated
	 */
	int OIL_IMPLEMENTATION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OIL_IMPLEMENTATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Oil Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OIL_IMPLEMENTATION__OIL_OBJECTS = 1;

	/**
	 * The number of structural features of the '<em>Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OIL_IMPLEMENTATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilObjectImplImpl <em>Object Impl</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilObjectImplImpl
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getOilObjectImpl()
	 * @generated
	 */
	int OIL_OBJECT_IMPL = 4;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OIL_OBJECT_IMPL__PARAMETERS = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OIL_OBJECT_IMPL__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OIL_OBJECT_IMPL__DESCRIPTION = 2;

	/**
	 * The number of structural features of the '<em>Object Impl</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OIL_OBJECT_IMPL_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ParameterTypeImpl <em>Parameter Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ParameterTypeImpl
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getParameterType()
	 * @generated
	 */
	int PARAMETER_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TYPE__DEFAULT_VALUE = 1;

	/**
	 * The feature id for the '<em><b>Multi Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TYPE__MULTI_VALUE = 2;

	/**
	 * The feature id for the '<em><b>With Auto</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TYPE__WITH_AUTO = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TYPE__DESCRIPTION = 4;

	/**
	 * The feature id for the '<em><b>Default Auto</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TYPE__DEFAULT_AUTO = 5;

	/**
	 * The number of structural features of the '<em>Parameter Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TYPE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ValueTypeImpl <em>Value Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ValueTypeImpl
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getValueType()
	 * @generated
	 */
	int VALUE_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__NAME = PARAMETER_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__DEFAULT_VALUE = PARAMETER_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Multi Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__MULTI_VALUE = PARAMETER_TYPE__MULTI_VALUE;

	/**
	 * The feature id for the '<em><b>With Auto</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__WITH_AUTO = PARAMETER_TYPE__WITH_AUTO;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__DESCRIPTION = PARAMETER_TYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Default Auto</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__DEFAULT_AUTO = PARAMETER_TYPE__DEFAULT_AUTO;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__TYPE = PARAMETER_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Valid Values</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__VALID_VALUES = PARAMETER_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Value Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE_FEATURE_COUNT = PARAMETER_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.EnumeratorTypeImpl <em>Enumerator Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.EnumeratorTypeImpl
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getEnumeratorType()
	 * @generated
	 */
	int ENUMERATOR_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR_TYPE__NAME = PARAMETER_REF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR_TYPE__PARAMETERS = PARAMETER_REF_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR_TYPE__DESCRIPTION = PARAMETER_REF_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Enumerator Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR_TYPE_FEATURE_COUNT = PARAMETER_REF_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.VariantTypeImpl <em>Variant Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.VariantTypeImpl
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getVariantType()
	 * @generated
	 */
	int VARIANT_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TYPE__NAME = PARAMETER_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TYPE__DEFAULT_VALUE = PARAMETER_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Multi Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TYPE__MULTI_VALUE = PARAMETER_TYPE__MULTI_VALUE;

	/**
	 * The feature id for the '<em><b>With Auto</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TYPE__WITH_AUTO = PARAMETER_TYPE__WITH_AUTO;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TYPE__DESCRIPTION = PARAMETER_TYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Default Auto</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TYPE__DEFAULT_AUTO = PARAMETER_TYPE__DEFAULT_AUTO;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TYPE__TYPE = PARAMETER_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TYPE__VALUES = PARAMETER_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variant Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_TYPE_FEATURE_COUNT = PARAMETER_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilFileImpl <em>File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilFileImpl
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getOilFile()
	 * @generated
	 */
	int OIL_FILE = 9;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OIL_FILE__IMPLEMENTATION = 0;

	/**
	 * The feature id for the '<em><b>Application</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OIL_FILE__APPLICATION = 1;

	/**
	 * The feature id for the '<em><b>Oil Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OIL_FILE__OIL_VERSION = 2;

	/**
	 * The number of structural features of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OIL_FILE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ReferenceTypeImpl <em>Reference Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ReferenceTypeImpl
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getReferenceType()
	 * @generated
	 */
	int REFERENCE_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__NAME = PARAMETER_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__DEFAULT_VALUE = PARAMETER_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Multi Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__MULTI_VALUE = PARAMETER_TYPE__MULTI_VALUE;

	/**
	 * The feature id for the '<em><b>With Auto</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__WITH_AUTO = PARAMETER_TYPE__WITH_AUTO;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__DESCRIPTION = PARAMETER_TYPE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Default Auto</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__DEFAULT_AUTO = PARAMETER_TYPE__DEFAULT_AUTO;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE__TYPE = PARAMETER_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_TYPE_FEATURE_COUNT = PARAMETER_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.oil.xtext.model.ValidValues <em>Valid Values</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ValidValues
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getValidValues()
	 * @generated
	 */
	int VALID_VALUES = 12;

	/**
	 * The number of structural features of the '<em>Valid Values</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_VALUES_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.RangeImpl <em>Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.RangeImpl
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getRange()
	 * @generated
	 */
	int RANGE = 13;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE__MIN = VALID_VALUES_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE__MAX = VALID_VALUES_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_FEATURE_COUNT = VALID_VALUES_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ValueListImpl <em>Value List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ValueListImpl
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getValueList()
	 * @generated
	 */
	int VALUE_LIST = 14;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_LIST__VALUES = VALID_VALUES_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Value List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_LIST_FEATURE_COUNT = VALID_VALUES_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.oil.xtext.model.ObjectType <em>Object Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ObjectType
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getObjectType()
	 * @generated
	 */
	int OBJECT_TYPE = 15;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.oil.xtext.model.VType <em>VType</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.VType
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getVType()
	 * @generated
	 */
	int VTYPE = 16;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.oil.xtext.model.EType <em>EType</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.EType
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getEType()
	 * @generated
	 */
	int ETYPE = 17;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.oil.xtext.model.PType <em>PType</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.PType
	 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getPType()
	 * @generated
	 */
	int PTYPE = 18;


	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilObject
	 * @generated
	 */
	EClass getOilObject();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilObject#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilObject#getParameters()
	 * @see #getOilObject()
	 * @generated
	 */
	EReference getOilObject_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilObject#getName()
	 * @see #getOilObject()
	 * @generated
	 */
	EAttribute getOilObject_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilObject#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilObject#getType()
	 * @see #getOilObject()
	 * @generated
	 */
	EAttribute getOilObject_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilObject#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilObject#getDescription()
	 * @see #getOilObject()
	 * @generated
	 */
	EAttribute getOilObject_Description();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.oil.xtext.model.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.Parameter#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.Parameter#getDescription()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Description();

	/**
	 * Returns the meta object for the reference '{@link com.eu.evidence.rtdruid.oil.xtext.model.Parameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.Parameter#getType()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.Parameter#isAuto <em>Auto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auto</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.Parameter#isAuto()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Auto();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.Parameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.Parameter#getValue()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Value();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.oil.xtext.model.Parameter#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.Parameter#getParameters()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Parameters();

	/**
	 * Returns the meta object for the reference '{@link com.eu.evidence.rtdruid.oil.xtext.model.Parameter#getValueRef <em>Value Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value Ref</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.Parameter#getValueRef()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_ValueRef();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilApplication
	 * @generated
	 */
	EClass getOilApplication();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilApplication#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilApplication#getName()
	 * @see #getOilApplication()
	 * @generated
	 */
	EAttribute getOilApplication_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilApplication#getOilObjects <em>Oil Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Oil Objects</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilApplication#getOilObjects()
	 * @see #getOilApplication()
	 * @generated
	 */
	EReference getOilApplication_OilObjects();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilApplication#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilApplication#getDescription()
	 * @see #getOilApplication()
	 * @generated
	 */
	EAttribute getOilApplication_Description();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implementation</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilImplementation
	 * @generated
	 */
	EClass getOilImplementation();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilImplementation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilImplementation#getName()
	 * @see #getOilImplementation()
	 * @generated
	 */
	EAttribute getOilImplementation_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilImplementation#getOilObjects <em>Oil Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Oil Objects</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilImplementation#getOilObjects()
	 * @see #getOilImplementation()
	 * @generated
	 */
	EReference getOilImplementation_OilObjects();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilObjectImpl <em>Object Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Impl</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilObjectImpl
	 * @generated
	 */
	EClass getOilObjectImpl();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilObjectImpl#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilObjectImpl#getParameters()
	 * @see #getOilObjectImpl()
	 * @generated
	 */
	EReference getOilObjectImpl_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilObjectImpl#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilObjectImpl#getType()
	 * @see #getOilObjectImpl()
	 * @generated
	 */
	EAttribute getOilObjectImpl_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilObjectImpl#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilObjectImpl#getDescription()
	 * @see #getOilObjectImpl()
	 * @generated
	 */
	EAttribute getOilObjectImpl_Description();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterType <em>Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Type</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ParameterType
	 * @generated
	 */
	EClass getParameterType();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#getName()
	 * @see #getParameterType()
	 * @generated
	 */
	EAttribute getParameterType_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#getDefaultValue()
	 * @see #getParameterType()
	 * @generated
	 */
	EAttribute getParameterType_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#isMultiValue <em>Multi Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multi Value</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#isMultiValue()
	 * @see #getParameterType()
	 * @generated
	 */
	EAttribute getParameterType_MultiValue();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#isWithAuto <em>With Auto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>With Auto</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#isWithAuto()
	 * @see #getParameterType()
	 * @generated
	 */
	EAttribute getParameterType_WithAuto();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#getDescription()
	 * @see #getParameterType()
	 * @generated
	 */
	EAttribute getParameterType_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#isDefaultAuto <em>Default Auto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Auto</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ParameterType#isDefaultAuto()
	 * @see #getParameterType()
	 * @generated
	 */
	EAttribute getParameterType_DefaultAuto();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.oil.xtext.model.ValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Type</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ValueType
	 * @generated
	 */
	EClass getValueType();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.ValueType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ValueType#getType()
	 * @see #getValueType()
	 * @generated
	 */
	EAttribute getValueType_Type();

	/**
	 * Returns the meta object for the containment reference '{@link com.eu.evidence.rtdruid.oil.xtext.model.ValueType#getValidValues <em>Valid Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Valid Values</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ValueType#getValidValues()
	 * @see #getValueType()
	 * @generated
	 */
	EReference getValueType_ValidValues();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType <em>Enumerator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumerator Type</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType
	 * @generated
	 */
	EClass getEnumeratorType();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType#getName()
	 * @see #getEnumeratorType()
	 * @generated
	 */
	EAttribute getEnumeratorType_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType#getParameters()
	 * @see #getEnumeratorType()
	 * @generated
	 */
	EReference getEnumeratorType_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.EnumeratorType#getDescription()
	 * @see #getEnumeratorType()
	 * @generated
	 */
	EAttribute getEnumeratorType_Description();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.oil.xtext.model.VariantType <em>Variant Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variant Type</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.VariantType
	 * @generated
	 */
	EClass getVariantType();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.VariantType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.VariantType#getType()
	 * @see #getVariantType()
	 * @generated
	 */
	EAttribute getVariantType_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.oil.xtext.model.VariantType#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.VariantType#getValues()
	 * @see #getVariantType()
	 * @generated
	 */
	EReference getVariantType_Values();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilFile
	 * @generated
	 */
	EClass getOilFile();

	/**
	 * Returns the meta object for the containment reference '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilFile#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Implementation</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilFile#getImplementation()
	 * @see #getOilFile()
	 * @generated
	 */
	EReference getOilFile_Implementation();

	/**
	 * Returns the meta object for the containment reference '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilFile#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Application</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilFile#getApplication()
	 * @see #getOilFile()
	 * @generated
	 */
	EReference getOilFile_Application();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.OilFile#getOilVersion <em>Oil Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Oil Version</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.OilFile#getOilVersion()
	 * @see #getOilFile()
	 * @generated
	 */
	EAttribute getOilFile_OilVersion();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.oil.xtext.model.ReferenceType <em>Reference Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Type</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ReferenceType
	 * @generated
	 */
	EClass getReferenceType();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.ReferenceType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ReferenceType#getType()
	 * @see #getReferenceType()
	 * @generated
	 */
	EAttribute getReferenceType_Type();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterRef <em>Parameter Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Ref</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ParameterRef
	 * @generated
	 */
	EClass getParameterRef();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.oil.xtext.model.ValidValues <em>Valid Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Valid Values</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ValidValues
	 * @generated
	 */
	EClass getValidValues();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.oil.xtext.model.Range <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Range</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.Range
	 * @generated
	 */
	EClass getRange();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.Range#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.Range#getMin()
	 * @see #getRange()
	 * @generated
	 */
	EAttribute getRange_Min();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.oil.xtext.model.Range#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.Range#getMax()
	 * @see #getRange()
	 * @generated
	 */
	EAttribute getRange_Max();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.oil.xtext.model.ValueList <em>Value List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value List</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ValueList
	 * @generated
	 */
	EClass getValueList();

	/**
	 * Returns the meta object for the attribute list '{@link com.eu.evidence.rtdruid.oil.xtext.model.ValueList#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ValueList#getValues()
	 * @see #getValueList()
	 * @generated
	 */
	EAttribute getValueList_Values();

	/**
	 * Returns the meta object for enum '{@link com.eu.evidence.rtdruid.oil.xtext.model.ObjectType <em>Object Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Object Type</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.ObjectType
	 * @generated
	 */
	EEnum getObjectType();

	/**
	 * Returns the meta object for enum '{@link com.eu.evidence.rtdruid.oil.xtext.model.VType <em>VType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>VType</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.VType
	 * @generated
	 */
	EEnum getVType();

	/**
	 * Returns the meta object for enum '{@link com.eu.evidence.rtdruid.oil.xtext.model.EType <em>EType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>EType</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.EType
	 * @generated
	 */
	EEnum getEType();

	/**
	 * Returns the meta object for enum '{@link com.eu.evidence.rtdruid.oil.xtext.model.PType <em>PType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>PType</em>'.
	 * @see com.eu.evidence.rtdruid.oil.xtext.model.PType
	 * @generated
	 */
	EEnum getPType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OilFactory getOilFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilObjectImpl <em>Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilObjectImpl
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getOilObject()
		 * @generated
		 */
		EClass OIL_OBJECT = eINSTANCE.getOilObject();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OIL_OBJECT__PARAMETERS = eINSTANCE.getOilObject_Parameters();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OIL_OBJECT__NAME = eINSTANCE.getOilObject_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OIL_OBJECT__TYPE = eINSTANCE.getOilObject_Type();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OIL_OBJECT__DESCRIPTION = eINSTANCE.getOilObject_Description();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ParameterImpl
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__DESCRIPTION = eINSTANCE.getParameter_Description();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__TYPE = eINSTANCE.getParameter_Type();

		/**
		 * The meta object literal for the '<em><b>Auto</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__AUTO = eINSTANCE.getParameter_Auto();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__VALUE = eINSTANCE.getParameter_Value();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__PARAMETERS = eINSTANCE.getParameter_Parameters();

		/**
		 * The meta object literal for the '<em><b>Value Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__VALUE_REF = eINSTANCE.getParameter_ValueRef();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilApplicationImpl <em>Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilApplicationImpl
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getOilApplication()
		 * @generated
		 */
		EClass OIL_APPLICATION = eINSTANCE.getOilApplication();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OIL_APPLICATION__NAME = eINSTANCE.getOilApplication_Name();

		/**
		 * The meta object literal for the '<em><b>Oil Objects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OIL_APPLICATION__OIL_OBJECTS = eINSTANCE.getOilApplication_OilObjects();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OIL_APPLICATION__DESCRIPTION = eINSTANCE.getOilApplication_Description();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilImplementationImpl <em>Implementation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilImplementationImpl
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getOilImplementation()
		 * @generated
		 */
		EClass OIL_IMPLEMENTATION = eINSTANCE.getOilImplementation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OIL_IMPLEMENTATION__NAME = eINSTANCE.getOilImplementation_Name();

		/**
		 * The meta object literal for the '<em><b>Oil Objects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OIL_IMPLEMENTATION__OIL_OBJECTS = eINSTANCE.getOilImplementation_OilObjects();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilObjectImplImpl <em>Object Impl</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilObjectImplImpl
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getOilObjectImpl()
		 * @generated
		 */
		EClass OIL_OBJECT_IMPL = eINSTANCE.getOilObjectImpl();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OIL_OBJECT_IMPL__PARAMETERS = eINSTANCE.getOilObjectImpl_Parameters();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OIL_OBJECT_IMPL__TYPE = eINSTANCE.getOilObjectImpl_Type();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OIL_OBJECT_IMPL__DESCRIPTION = eINSTANCE.getOilObjectImpl_Description();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ParameterTypeImpl <em>Parameter Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ParameterTypeImpl
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getParameterType()
		 * @generated
		 */
		EClass PARAMETER_TYPE = eINSTANCE.getParameterType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_TYPE__NAME = eINSTANCE.getParameterType_Name();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_TYPE__DEFAULT_VALUE = eINSTANCE.getParameterType_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Multi Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_TYPE__MULTI_VALUE = eINSTANCE.getParameterType_MultiValue();

		/**
		 * The meta object literal for the '<em><b>With Auto</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_TYPE__WITH_AUTO = eINSTANCE.getParameterType_WithAuto();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_TYPE__DESCRIPTION = eINSTANCE.getParameterType_Description();

		/**
		 * The meta object literal for the '<em><b>Default Auto</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_TYPE__DEFAULT_AUTO = eINSTANCE.getParameterType_DefaultAuto();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ValueTypeImpl <em>Value Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ValueTypeImpl
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getValueType()
		 * @generated
		 */
		EClass VALUE_TYPE = eINSTANCE.getValueType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_TYPE__TYPE = eINSTANCE.getValueType_Type();

		/**
		 * The meta object literal for the '<em><b>Valid Values</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_TYPE__VALID_VALUES = eINSTANCE.getValueType_ValidValues();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.EnumeratorTypeImpl <em>Enumerator Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.EnumeratorTypeImpl
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getEnumeratorType()
		 * @generated
		 */
		EClass ENUMERATOR_TYPE = eINSTANCE.getEnumeratorType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATOR_TYPE__NAME = eINSTANCE.getEnumeratorType_Name();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATOR_TYPE__PARAMETERS = eINSTANCE.getEnumeratorType_Parameters();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATOR_TYPE__DESCRIPTION = eINSTANCE.getEnumeratorType_Description();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.VariantTypeImpl <em>Variant Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.VariantTypeImpl
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getVariantType()
		 * @generated
		 */
		EClass VARIANT_TYPE = eINSTANCE.getVariantType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIANT_TYPE__TYPE = eINSTANCE.getVariantType_Type();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIANT_TYPE__VALUES = eINSTANCE.getVariantType_Values();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilFileImpl <em>File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilFileImpl
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getOilFile()
		 * @generated
		 */
		EClass OIL_FILE = eINSTANCE.getOilFile();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OIL_FILE__IMPLEMENTATION = eINSTANCE.getOilFile_Implementation();

		/**
		 * The meta object literal for the '<em><b>Application</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OIL_FILE__APPLICATION = eINSTANCE.getOilFile_Application();

		/**
		 * The meta object literal for the '<em><b>Oil Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OIL_FILE__OIL_VERSION = eINSTANCE.getOilFile_OilVersion();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ReferenceTypeImpl <em>Reference Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ReferenceTypeImpl
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getReferenceType()
		 * @generated
		 */
		EClass REFERENCE_TYPE = eINSTANCE.getReferenceType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_TYPE__TYPE = eINSTANCE.getReferenceType_Type();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.oil.xtext.model.ParameterRef <em>Parameter Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.oil.xtext.model.ParameterRef
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getParameterRef()
		 * @generated
		 */
		EClass PARAMETER_REF = eINSTANCE.getParameterRef();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.oil.xtext.model.ValidValues <em>Valid Values</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.oil.xtext.model.ValidValues
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getValidValues()
		 * @generated
		 */
		EClass VALID_VALUES = eINSTANCE.getValidValues();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.RangeImpl <em>Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.RangeImpl
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getRange()
		 * @generated
		 */
		EClass RANGE = eINSTANCE.getRange();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANGE__MIN = eINSTANCE.getRange_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANGE__MAX = eINSTANCE.getRange_Max();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ValueListImpl <em>Value List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.ValueListImpl
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getValueList()
		 * @generated
		 */
		EClass VALUE_LIST = eINSTANCE.getValueList();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_LIST__VALUES = eINSTANCE.getValueList_Values();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.oil.xtext.model.ObjectType <em>Object Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.oil.xtext.model.ObjectType
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getObjectType()
		 * @generated
		 */
		EEnum OBJECT_TYPE = eINSTANCE.getObjectType();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.oil.xtext.model.VType <em>VType</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.oil.xtext.model.VType
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getVType()
		 * @generated
		 */
		EEnum VTYPE = eINSTANCE.getVType();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.oil.xtext.model.EType <em>EType</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.oil.xtext.model.EType
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getEType()
		 * @generated
		 */
		EEnum ETYPE = eINSTANCE.getEType();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.oil.xtext.model.PType <em>PType</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.oil.xtext.model.PType
		 * @see com.eu.evidence.rtdruid.oil.internal.xtext.model.impl.OilPackageImpl#getPType()
		 * @generated
		 */
		EEnum PTYPE = eINSTANCE.getPType();

	}

} //OilPackage
