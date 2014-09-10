/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.vartree.data;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see com.eu.evidence.rtdruid.vartree.data.DataFactory
 * @model kind="package"
 * @generated
 */
public interface DataPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "rtdruid";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.evidence.eu.com/rtdruid/data";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.eu.evidence.rtdruid.data";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataPackage eINSTANCE = com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ObjectWithIDImpl <em>Object With ID</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ObjectWithIDImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getObjectWithID()
	 * @generated
	 */
	int OBJECT_WITH_ID = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_WITH_ID__PROPERTIES = 0;

	/**
	 * The number of structural features of the '<em>Object With ID</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_WITH_ID_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.SystemImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__ANNOTATION = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Architectural</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__ARCHITECTURAL = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Functional</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__FUNCTIONAL = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__MAPPING = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Modes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__MODES = OBJECT_WITH_ID_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Schedulability</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__SCHEDULABILITY = OBJECT_WITH_ID_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>XTC Cookie</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__XTC_COOKIE = OBJECT_WITH_ID_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ModesImpl <em>Modes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ModesImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getModes()
	 * @generated
	 */
	int MODES = 2;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODES__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Mode List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODES__MODE_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Modes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODES_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ModeImpl <em>Mode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ModeImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getMode()
	 * @generated
	 */
	int MODE = 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODE_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.FunctionalImpl <em>Functional</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.FunctionalImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getFunctional()
	 * @generated
	 */
	int FUNCTIONAL = 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Event List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL__EVENT_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Partial Order List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL__PARTIAL_ORDER_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL__IMPLEMENTATION = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Time Const List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL__TIME_CONST_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL__TYPE_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Functional</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SystemImplementationImpl <em>System Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.SystemImplementationImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getSystemImplementation()
	 * @generated
	 */
	int SYSTEM_IMPLEMENTATION = 15;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_IMPLEMENTATION__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_IMPLEMENTATION__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>System Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_IMPLEMENTATION_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ImplementationImpl <em>Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ImplementationImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getImplementation()
	 * @generated
	 */
	int IMPLEMENTATION = 5;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION__PROPERTIES = SYSTEM_IMPLEMENTATION__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION__NAME = SYSTEM_IMPLEMENTATION__NAME;

	/**
	 * The number of structural features of the '<em>Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_FEATURE_COUNT = SYSTEM_IMPLEMENTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ProcImpl <em>Proc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ProcImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getProc()
	 * @generated
	 */
	int PROC = 6;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC__PROPERTIES = IMPLEMENTATION__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC__NAME = IMPLEMENTATION__NAME;

	/**
	 * The feature id for the '<em><b>Method Ref List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC__METHOD_REF_LIST = IMPLEMENTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC__METHODS = IMPLEMENTATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Proc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC_FEATURE_COUNT = IMPLEMENTATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ArchitecturalImpl <em>Architectural</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ArchitecturalImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getArchitectural()
	 * @generated
	 */
	int ARCHITECTURAL = 7;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Bus List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL__BUS_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ecu List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL__ECU_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Frame List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL__FRAME_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mutex List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL__MUTEX_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Resource List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL__RESOURCE_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Signal List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL__SIGNAL_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Task List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL__TASK_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Com List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL__COM_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Spin Lock List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL__SPIN_LOCK_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Scheduling Table List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL__SCHEDULE_TABLE_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Architectural</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.MappingImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 8;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Proc Map List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__PROC_MAP_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Task Map List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__TASK_MAP_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Var Map List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__VAR_MAP_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.AnnotationImpl <em>Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.AnnotationImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 9;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Exec Time Lists</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__EXEC_TIME_LISTS = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cache Miss Cost Lists</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__CACHE_MISS_COST_LISTS = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SchedulabilityImpl <em>Schedulability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.SchedulabilityImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getSchedulability()
	 * @generated
	 */
	int SCHEDULABILITY = 10;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULABILITY__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Scheduling Scenario List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULABILITY__SCHEDULING_SCENARIO_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Schedulability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULABILITY_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.VarImpl <em>Var</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.VarImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getVar()
	 * @generated
	 */
	int VAR = 11;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__PROPERTIES = IMPLEMENTATION__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__NAME = IMPLEMENTATION__NAME;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__METHODS = IMPLEMENTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__TYPE = IMPLEMENTATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Var</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_FEATURE_COUNT = IMPLEMENTATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TriggerImpl <em>Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.TriggerImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getTrigger()
	 * @generated
	 */
	int TRIGGER = 12;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__PROPERTIES = SYSTEM_IMPLEMENTATION__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__NAME = SYSTEM_IMPLEMENTATION__NAME;

	/**
	 * The feature id for the '<em><b>Method Ref List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__METHOD_REF_LIST = SYSTEM_IMPLEMENTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_FEATURE_COUNT = SYSTEM_IMPLEMENTATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.EventImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 13;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Method Ref Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__METHOD_REF_NAME = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TYPE = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.PartialOrderImpl <em>Partial Order</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.PartialOrderImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getPartialOrder()
	 * @generated
	 */
	int PARTIAL_ORDER = 14;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_ORDER__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Mode Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_ORDER__MODE_REF = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Order List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_ORDER__ORDER_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Partial Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_ORDER_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SubSystemImpl <em>Sub System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.SubSystemImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getSubSystem()
	 * @generated
	 */
	int SUB_SYSTEM = 16;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__PROPERTIES = IMPLEMENTATION__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__NAME = IMPLEMENTATION__NAME;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__IMPLEMENTATION = IMPLEMENTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Provided Interface List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__PROVIDED_INTERFACE_LIST = IMPLEMENTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Required Interface List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM__REQUIRED_INTERFACE_LIST = IMPLEMENTATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Sub System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_SYSTEM_FEATURE_COUNT = IMPLEMENTATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TimeConstImpl <em>Time Const</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.TimeConstImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getTimeConst()
	 * @generated
	 */
	int TIME_CONST = 17;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONST__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Mode Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONST__MODE_REF = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Time Const Element List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONST__TIME_CONST_ELEMENT_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Time Const</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONST_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.MethodRefImpl <em>Method Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.MethodRefImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getMethodRef()
	 * @generated
	 */
	int METHOD_REF = 18;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_REF__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_REF__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_REF__METHOD_NAME = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Method Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_REF_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ProvidedInterfaceImpl <em>Provided Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ProvidedInterfaceImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getProvidedInterface()
	 * @generated
	 */
	int PROVIDED_INTERFACE = 19;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_INTERFACE__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Local Method Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_INTERFACE__LOCAL_METHOD_REF = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Local Object Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_INTERFACE__LOCAL_OBJECT_REF = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_INTERFACE__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Provided Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDED_INTERFACE_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.RequiredInterfaceImpl <em>Required Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.RequiredInterfaceImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getRequiredInterface()
	 * @generated
	 */
	int REQUIRED_INTERFACE = 20;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_INTERFACE__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>External Method Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_INTERFACE__EXTERNAL_METHOD_REF = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_INTERFACE__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Required Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_INTERFACE_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.OrderImpl <em>Order</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.OrderImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getOrder()
	 * @generated
	 */
	int ORDER = 21;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>First Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__FIRST_EVENT = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Second Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__SECOND_EVENT = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TimeConstElementImpl <em>Time Const Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.TimeConstElementImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getTimeConstElement()
	 * @generated
	 */
	int TIME_CONST_ELEMENT = 22;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONST_ELEMENT__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Bound Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONST_ELEMENT__BOUND_TYPE = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bound Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONST_ELEMENT__BOUND_VALUE = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>First Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONST_ELEMENT__FIRST_EVENT = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Second Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONST_ELEMENT__SECOND_EVENT = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Time Const Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONST_ELEMENT_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.EcuImpl <em>Ecu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.EcuImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getEcu()
	 * @generated
	 */
	int ECU = 23;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECU__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Cpu List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECU__CPU_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECU__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ecu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECU_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskImpl <em>Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getTask()
	 * @generated
	 */
	int TASK = 24;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Activation List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__ACTIVATION_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Oil Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__OIL_VAR = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resource Ref List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__RESOURCE_REF_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Scheduling List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__SCHEDULING_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK__TYPE = OBJECT_WITH_ID_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ResourceImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 25;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__METHODS = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mutex Ref List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__MUTEX_REF_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.BusImpl <em>Bus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.BusImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getBus()
	 * @generated
	 */
	int BUS = 26;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS__SPEED = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS__TYPE = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Bus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.FrameImpl <em>Frame</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.FrameImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getFrame()
	 * @generated
	 */
	int FRAME = 27;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAME__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Activation Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAME__ACTIVATION_CLASS = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Activation Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAME__ACTIVATION_RATE = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Activation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAME__ACTIVATION_TYPE = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAME__ID = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAME__LENGTH = OBJECT_WITH_ID_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAME__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Message Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAME__MESSAGE_TYPE = OBJECT_WITH_ID_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Frame</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAME_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SignalImpl <em>Signal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.SignalImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getSignal()
	 * @generated
	 */
	int SIGNAL = 28;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Oil Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__OIL_VAR = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL__TYPE = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.MutexImpl <em>Mutex</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.MutexImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getMutex()
	 * @generated
	 */
	int MUTEX = 29;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Oil Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX__OIL_VAR = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX__POLICY = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Mutex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CpuImpl <em>Cpu</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.CpuImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getCpu()
	 * @generated
	 */
	int CPU = 30;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU__MODEL = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rtos</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU__RTOS = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Os Application</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU__OS_APPLICATION = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU__SPEED = OBJECT_WITH_ID_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Speed Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU__SPEED_UNIT = OBJECT_WITH_ID_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Binary Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU__BINARY_IMAGE = OBJECT_WITH_ID_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Cpu</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.RtosImpl <em>Rtos</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.RtosImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getRtos()
	 * @generated
	 */
	int RTOS = 31;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RTOS__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RTOS__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Oil Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RTOS__OIL_VAR = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RTOS__TYPE = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RTOS__METHODS = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Rtos</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RTOS_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SchedulingImpl <em>Scheduling</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.SchedulingImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getScheduling()
	 * @generated
	 */
	int SCHEDULING = 32;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Mode Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING__MODE_REF = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Preemption Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING__PREEMPTION_GROUP_NAME = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING__PRIORITY = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING__THRESHOLD = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Stack</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING__STACK = OBJECT_WITH_ID_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Scheduling</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ActivationImpl <em>Activation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ActivationImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getActivation()
	 * @generated
	 */
	int ACTIVATION = 33;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATION__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Act Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATION__ACT_NUMBER = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Activation Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATION__ACTIVATION_CLASS = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Deadline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATION__DEADLINE = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mode Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATION__MODE_REF = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATION__OFFSET = OBJECT_WITH_ID_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATION__PERIOD = OBJECT_WITH_ID_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATION__TYPE = OBJECT_WITH_ID_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Activation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATION_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ResourceRefImpl <em>Resource Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ResourceRefImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getResourceRef()
	 * @generated
	 */
	int RESOURCE_REF = 34;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REF__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Mode Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REF__MODE_REF = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Method Ref</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REF__RESOURCE_METHOD_REF = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resource Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REF_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.MutexRefImpl <em>Mutex Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.MutexRefImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getMutexRef()
	 * @generated
	 */
	int MUTEX_REF = 35;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_REF__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Mode Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_REF__MODE_REF = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mutex Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_REF__MUTEX_NAME = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mutex Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTEX_REF_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ExecTimeImpl <em>Exec Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ExecTimeImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getExecTime()
	 * @generated
	 */
	int EXEC_TIME = 36;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_TIME__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Best</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_TIME__BEST = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Distribution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_TIME__DISTRIBUTION = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_TIME__REF = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_TIME__TYPE = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Worst</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_TIME__WORST = OBJECT_WITH_ID_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Exec Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_TIME_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ExecTimeListImpl <em>Exec Time List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ExecTimeListImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getExecTimeList()
	 * @generated
	 */
	int EXEC_TIME_LIST = 37;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_TIME_LIST__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Exec Time Items List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_TIME_LIST__EXEC_TIME_ITEMS_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mode Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_TIME_LIST__MODE_REF = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Exec Time List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_TIME_LIST_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.DistributionImpl <em>Distribution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DistributionImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getDistribution()
	 * @generated
	 */
	int DISTRIBUTION = 38;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Avg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION__AVG = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sample List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION__SAMPLE_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION__TYPE = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Variance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION__VARIANCE = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Distribution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTION_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SampleImpl <em>Sample</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.SampleImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getSample()
	 * @generated
	 */
	int SAMPLE = 39;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE__PROBABILITY = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE__VALUE = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sample</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAMPLE_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ProcMapImpl <em>Proc Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ProcMapImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getProcMap()
	 * @generated
	 */
	int PROC_MAP = 40;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC_MAP__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Mode Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC_MAP__MODE_REF = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC_MAP__ORDER = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Proc Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC_MAP__PROC_REF = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Task Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC_MAP__TASK_REF = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Once Every K</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC_MAP__ONCE_EVERY_K = OBJECT_WITH_ID_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Method Ref Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC_MAP__METHOD_REF_NAME = OBJECT_WITH_ID_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Proc Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC_MAP_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskMapImpl <em>Task Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskMapImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getTaskMap()
	 * @generated
	 */
	int TASK_MAP = 41;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_MAP__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Mode Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_MAP__MODE_REF = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rtos Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_MAP__RTOS_REF = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Task Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_MAP__TASK_REF = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Task Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_MAP_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.VarMapImpl <em>Var Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.VarMapImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getVarMap()
	 * @generated
	 */
	int VAR_MAP = 42;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_MAP__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Bus Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_MAP__BUS_REF = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Frame Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_MAP__FRAME_REF = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mode Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_MAP__MODE_REF = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mutex Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_MAP__MUTEX_REF = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Var Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_MAP__VAR_REF = OBJECT_WITH_ID_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Var Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_MAP_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SchedulingScenarioImpl <em>Scheduling Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.SchedulingScenarioImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getSchedulingScenario()
	 * @generated
	 */
	int SCHEDULING_SCENARIO = 43;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_SCENARIO__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Cpu Sched List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_SCENARIO__CPU_SCHED_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mode Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_SCENARIO__MODE_REF = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reports</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_SCENARIO__REPORTS = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Task Sched List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_SCENARIO__TASK_SCHED_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Scheduling Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_SCENARIO_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CpuSchedImpl <em>Cpu Sched</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.CpuSchedImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getCpuSched()
	 * @generated
	 */
	int CPU_SCHED = 44;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU_SCHED__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Boundary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU_SCHED__BOUNDARY = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cpu Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU_SCHED__CPU_REF = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Schedulable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU_SCHED__SCHEDULABLE = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Speed Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU_SCHED__SPEED_FACTOR = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Utilization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU_SCHED__UTILIZATION = OBJECT_WITH_ID_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Max Stack Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU_SCHED__MAX_STACK_SIZE = OBJECT_WITH_ID_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Cpu Sched</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPU_SCHED_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskSchedImpl <em>Task Sched</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskSchedImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getTaskSched()
	 * @generated
	 */
	int TASK_SCHED = 45;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SCHED__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>CDelta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SCHED__CDELTA = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Response Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SCHED__RESPONSE_TIME = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Schedulable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SCHED__SCHEDULABLE = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Task Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SCHED__TASK_REF = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>TDelta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SCHED__TDELTA = OBJECT_WITH_ID_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Utilization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SCHED__UTILIZATION = OBJECT_WITH_ID_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Task Sched</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_SCHED_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CacheMissCostListImpl <em>Cache Miss Cost List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.CacheMissCostListImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getCacheMissCostList()
	 * @generated
	 */
	int CACHE_MISS_COST_LIST = 46;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MISS_COST_LIST__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Cache Miss Cost Items List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MISS_COST_LIST__CACHE_MISS_COST_ITEMS_LIST = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mode Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MISS_COST_LIST__MODE_REF = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cache Miss Cost List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MISS_COST_LIST_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CacheMissCostImpl <em>Cache Miss Cost</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.CacheMissCostImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getCacheMissCost()
	 * @generated
	 */
	int CACHE_MISS_COST = 47;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MISS_COST__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Best</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MISS_COST__BEST = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Distribution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MISS_COST__DISTRIBUTION = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MISS_COST__REF = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MISS_COST__TYPE = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Worst</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MISS_COST__WORST = OBJECT_WITH_ID_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Cache Miss Cost</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MISS_COST_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.FieldImpl <em>Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.FieldImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getField()
	 * @generated
	 */
	int FIELD = 48;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__TYPE = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__SIZE = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.TypeImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 49;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Field</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__FIELD = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__DIM = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.OsApplicationImpl <em>Os Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.OsApplicationImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getOsApplication()
	 * @generated
	 */
	int OS_APPLICATION = 50;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_APPLICATION__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_APPLICATION__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Oil Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_APPLICATION__OIL_VAR = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Os Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_APPLICATION_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ComImpl <em>Com</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ComImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getCom()
	 * @generated
	 */
	int COM = 51;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Com</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COM_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SpinLockImpl <em>Spin Lock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.SpinLockImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getSpinLock()
	 * @generated
	 */
	int SPIN_LOCK = 52;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPIN_LOCK__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPIN_LOCK__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Spin Lock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPIN_LOCK_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ScheduleTableImpl <em>Scheduling Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ScheduleTableImpl
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getScheduleTable()
	 * @generated
	 */
	int SCHEDULE_TABLE = 53;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_TABLE__PROPERTIES = OBJECT_WITH_ID__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_TABLE__NAME = OBJECT_WITH_ID_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Scheduling Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_TABLE_FEATURE_COUNT = OBJECT_WITH_ID_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '<em>Boolean Var</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.vartree.variables.BooleanVar
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getBooleanVar()
	 * @generated
	 */
	int BOOLEAN_VAR = 54;

	/**
	 * The meta object id for the '<em>Double Var</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.vartree.variables.DoubleVar
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getDoubleVar()
	 * @generated
	 */
	int DOUBLE_VAR = 55;

	/**
	 * The meta object id for the '<em>Float Var</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.vartree.variables.FloatVar
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getFloatVar()
	 * @generated
	 */
	int FLOAT_VAR = 56;

	/**
	 * The meta object id for the '<em>Integer Var</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.vartree.variables.IntegerVar
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getIntegerVar()
	 * @generated
	 */
	int INTEGER_VAR = 57;

	/**
	 * The meta object id for the '<em>Long Var</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.vartree.variables.LongVar
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getLongVar()
	 * @generated
	 */
	int LONG_VAR = 58;

	/**
	 * The meta object id for the '<em>Oil Var</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.vartree.variables.OilVar
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getOilVar()
	 * @generated
	 */
	int OIL_VAR = 59;

	/**
	 * The meta object id for the '<em>String Var</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.vartree.variables.StringVar
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getStringVar()
	 * @generated
	 */
	int STRING_VAR = 60;

	/**
	 * The meta object id for the '<em>Time Var</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.vartree.variables.TimeVar
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getTimeVar()
	 * @generated
	 */
	int TIME_VAR = 61;

	/**
	 * The meta object id for the '<em>Property Var</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.eu.evidence.rtdruid.vartree.variables.PropertyVar
	 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getPropertyVar()
	 * @generated
	 */
	int PROPERTY_VAR = 62;


	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the containment reference '{@link com.eu.evidence.rtdruid.vartree.data.System#getAnnotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Annotation</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.System#getAnnotation()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Annotation();

	/**
	 * Returns the meta object for the containment reference '{@link com.eu.evidence.rtdruid.vartree.data.System#getArchitectural <em>Architectural</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Architectural</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.System#getArchitectural()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Architectural();

	/**
	 * Returns the meta object for the containment reference '{@link com.eu.evidence.rtdruid.vartree.data.System#getFunctional <em>Functional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Functional</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.System#getFunctional()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Functional();

	/**
	 * Returns the meta object for the containment reference '{@link com.eu.evidence.rtdruid.vartree.data.System#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.System#getMapping()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Mapping();

	/**
	 * Returns the meta object for the containment reference '{@link com.eu.evidence.rtdruid.vartree.data.System#getModes <em>Modes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Modes</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.System#getModes()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Modes();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.System#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.System#getName()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_Name();

	/**
	 * Returns the meta object for the containment reference '{@link com.eu.evidence.rtdruid.vartree.data.System#getSchedulability <em>Schedulability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Schedulability</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.System#getSchedulability()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Schedulability();

	/**
	 * Returns the meta object for the attribute list '{@link com.eu.evidence.rtdruid.vartree.data.System#getXTC_Cookie <em>XTC Cookie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>XTC Cookie</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.System#getXTC_Cookie()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_XTC_Cookie();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.ObjectWithID <em>Object With ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object With ID</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ObjectWithID
	 * @generated
	 */
	EClass getObjectWithID();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.ObjectWithID#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Properties</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ObjectWithID#getProperties()
	 * @see #getObjectWithID()
	 * @generated
	 */
	EAttribute getObjectWithID_Properties();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Modes <em>Modes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modes</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Modes
	 * @generated
	 */
	EClass getModes();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Modes#getModeList <em>Mode List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mode List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Modes#getModeList()
	 * @see #getModes()
	 * @generated
	 */
	EReference getModes_ModeList();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Mode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mode</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Mode
	 * @generated
	 */
	EClass getMode();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Mode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Mode#getName()
	 * @see #getMode()
	 * @generated
	 */
	EAttribute getMode_Name();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Functional <em>Functional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Functional</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Functional
	 * @generated
	 */
	EClass getFunctional();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Functional#getEventList <em>Event List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Event List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Functional#getEventList()
	 * @see #getFunctional()
	 * @generated
	 */
	EReference getFunctional_EventList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Functional#getPartialOrderList <em>Partial Order List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Partial Order List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Functional#getPartialOrderList()
	 * @see #getFunctional()
	 * @generated
	 */
	EReference getFunctional_PartialOrderList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Functional#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Implementation</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Functional#getImplementation()
	 * @see #getFunctional()
	 * @generated
	 */
	EReference getFunctional_Implementation();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Functional#getTimeConstList <em>Time Const List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Time Const List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Functional#getTimeConstList()
	 * @see #getFunctional()
	 * @generated
	 */
	EReference getFunctional_TimeConstList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Functional#getTypeList <em>Type List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Functional#getTypeList()
	 * @see #getFunctional()
	 * @generated
	 */
	EReference getFunctional_TypeList();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Implementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implementation</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Implementation
	 * @generated
	 */
	EClass getImplementation();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Proc <em>Proc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Proc</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Proc
	 * @generated
	 */
	EClass getProc();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Proc#getMethodRefList <em>Method Ref List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Method Ref List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Proc#getMethodRefList()
	 * @see #getProc()
	 * @generated
	 */
	EReference getProc_MethodRefList();

	/**
	 * Returns the meta object for the attribute list '{@link com.eu.evidence.rtdruid.vartree.data.Proc#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Methods</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Proc#getMethods()
	 * @see #getProc()
	 * @generated
	 */
	EAttribute getProc_Methods();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Architectural <em>Architectural</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architectural</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Architectural
	 * @generated
	 */
	EClass getArchitectural();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Architectural#getBusList <em>Bus List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bus List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Architectural#getBusList()
	 * @see #getArchitectural()
	 * @generated
	 */
	EReference getArchitectural_BusList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Architectural#getEcuList <em>Ecu List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ecu List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Architectural#getEcuList()
	 * @see #getArchitectural()
	 * @generated
	 */
	EReference getArchitectural_EcuList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Architectural#getFrameList <em>Frame List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Frame List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Architectural#getFrameList()
	 * @see #getArchitectural()
	 * @generated
	 */
	EReference getArchitectural_FrameList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Architectural#getMutexList <em>Mutex List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mutex List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Architectural#getMutexList()
	 * @see #getArchitectural()
	 * @generated
	 */
	EReference getArchitectural_MutexList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Architectural#getResourceList <em>Resource List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Architectural#getResourceList()
	 * @see #getArchitectural()
	 * @generated
	 */
	EReference getArchitectural_ResourceList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Architectural#getSignalList <em>Signal List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Signal List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Architectural#getSignalList()
	 * @see #getArchitectural()
	 * @generated
	 */
	EReference getArchitectural_SignalList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Architectural#getTaskList <em>Task List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Task List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Architectural#getTaskList()
	 * @see #getArchitectural()
	 * @generated
	 */
	EReference getArchitectural_TaskList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Architectural#getComList <em>Com List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Com List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Architectural#getComList()
	 * @see #getArchitectural()
	 * @generated
	 */
	EReference getArchitectural_ComList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Architectural#getSpinLockList <em>Spin Lock List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Spin Lock List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Architectural#getSpinLockList()
	 * @see #getArchitectural()
	 * @generated
	 */
	EReference getArchitectural_SpinLockList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Architectural#getScheduleTableList <em>Scheduling Table List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scheduling Table List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Architectural#getScheduleTableList()
	 * @see #getArchitectural()
	 * @generated
	 */
	EReference getArchitectural_ScheduleTableList();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Mapping#getProcMapList <em>Proc Map List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Proc Map List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Mapping#getProcMapList()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_ProcMapList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Mapping#getTaskMapList <em>Task Map List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Task Map List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Mapping#getTaskMapList()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_TaskMapList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Mapping#getVarMapList <em>Var Map List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Var Map List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Mapping#getVarMapList()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_VarMapList();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Annotation#getExecTimeLists <em>Exec Time Lists</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exec Time Lists</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Annotation#getExecTimeLists()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_ExecTimeLists();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Annotation#getCacheMissCostLists <em>Cache Miss Cost Lists</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cache Miss Cost Lists</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Annotation#getCacheMissCostLists()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_CacheMissCostLists();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Schedulability <em>Schedulability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schedulability</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Schedulability
	 * @generated
	 */
	EClass getSchedulability();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Schedulability#getSchedulingScenarioList <em>Scheduling Scenario List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scheduling Scenario List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Schedulability#getSchedulingScenarioList()
	 * @see #getSchedulability()
	 * @generated
	 */
	EReference getSchedulability_SchedulingScenarioList();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Var <em>Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Var
	 * @generated
	 */
	EClass getVar();

	/**
	 * Returns the meta object for the attribute list '{@link com.eu.evidence.rtdruid.vartree.data.Var#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Methods</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Var#getMethods()
	 * @see #getVar()
	 * @generated
	 */
	EAttribute getVar_Methods();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Var#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Var#getType()
	 * @see #getVar()
	 * @generated
	 */
	EAttribute getVar_Type();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Trigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trigger</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Trigger
	 * @generated
	 */
	EClass getTrigger();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Trigger#getMethodRefList <em>Method Ref List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Method Ref List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Trigger#getMethodRefList()
	 * @see #getTrigger()
	 * @generated
	 */
	EReference getTrigger_MethodRefList();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Event#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Event#getName()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Event#getMethodRefName <em>Method Ref Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Ref Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Event#getMethodRefName()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_MethodRefName();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Event#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Event#getType()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Type();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.PartialOrder <em>Partial Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partial Order</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.PartialOrder
	 * @generated
	 */
	EClass getPartialOrder();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.PartialOrder#getModeRef <em>Mode Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.PartialOrder#getModeRef()
	 * @see #getPartialOrder()
	 * @generated
	 */
	EAttribute getPartialOrder_ModeRef();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.PartialOrder#getOrderList <em>Order List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Order List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.PartialOrder#getOrderList()
	 * @see #getPartialOrder()
	 * @generated
	 */
	EReference getPartialOrder_OrderList();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.SystemImplementation <em>System Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Implementation</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.SystemImplementation
	 * @generated
	 */
	EClass getSystemImplementation();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.SystemImplementation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.SystemImplementation#getName()
	 * @see #getSystemImplementation()
	 * @generated
	 */
	EAttribute getSystemImplementation_Name();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.SubSystem <em>Sub System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub System</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.SubSystem
	 * @generated
	 */
	EClass getSubSystem();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.SubSystem#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Implementation</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.SubSystem#getImplementation()
	 * @see #getSubSystem()
	 * @generated
	 */
	EReference getSubSystem_Implementation();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.SubSystem#getProvidedInterfaceList <em>Provided Interface List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Provided Interface List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.SubSystem#getProvidedInterfaceList()
	 * @see #getSubSystem()
	 * @generated
	 */
	EReference getSubSystem_ProvidedInterfaceList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.SubSystem#getRequiredInterfaceList <em>Required Interface List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Required Interface List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.SubSystem#getRequiredInterfaceList()
	 * @see #getSubSystem()
	 * @generated
	 */
	EReference getSubSystem_RequiredInterfaceList();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.TimeConst <em>Time Const</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Const</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.TimeConst
	 * @generated
	 */
	EClass getTimeConst();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.TimeConst#getModeRef <em>Mode Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.TimeConst#getModeRef()
	 * @see #getTimeConst()
	 * @generated
	 */
	EAttribute getTimeConst_ModeRef();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.TimeConst#getTimeConstElementList <em>Time Const Element List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Time Const Element List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.TimeConst#getTimeConstElementList()
	 * @see #getTimeConst()
	 * @generated
	 */
	EReference getTimeConst_TimeConstElementList();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.MethodRef <em>Method Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.MethodRef
	 * @generated
	 */
	EClass getMethodRef();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.MethodRef#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.MethodRef#getName()
	 * @see #getMethodRef()
	 * @generated
	 */
	EAttribute getMethodRef_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.MethodRef#getMethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.MethodRef#getMethodName()
	 * @see #getMethodRef()
	 * @generated
	 */
	EAttribute getMethodRef_MethodName();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.ProvidedInterface <em>Provided Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Provided Interface</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ProvidedInterface
	 * @generated
	 */
	EClass getProvidedInterface();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.ProvidedInterface#getLocalMethodRef <em>Local Method Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local Method Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ProvidedInterface#getLocalMethodRef()
	 * @see #getProvidedInterface()
	 * @generated
	 */
	EAttribute getProvidedInterface_LocalMethodRef();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.ProvidedInterface#getLocalObjectRef <em>Local Object Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local Object Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ProvidedInterface#getLocalObjectRef()
	 * @see #getProvidedInterface()
	 * @generated
	 */
	EAttribute getProvidedInterface_LocalObjectRef();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.ProvidedInterface#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ProvidedInterface#getName()
	 * @see #getProvidedInterface()
	 * @generated
	 */
	EAttribute getProvidedInterface_Name();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.RequiredInterface <em>Required Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Required Interface</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.RequiredInterface
	 * @generated
	 */
	EClass getRequiredInterface();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.RequiredInterface#getExternalMethodRef <em>External Method Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External Method Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.RequiredInterface#getExternalMethodRef()
	 * @see #getRequiredInterface()
	 * @generated
	 */
	EAttribute getRequiredInterface_ExternalMethodRef();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.RequiredInterface#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.RequiredInterface#getName()
	 * @see #getRequiredInterface()
	 * @generated
	 */
	EAttribute getRequiredInterface_Name();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Order <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Order</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Order
	 * @generated
	 */
	EClass getOrder();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Order#getFirstEvent <em>First Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Event</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Order#getFirstEvent()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_FirstEvent();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Order#getSecondEvent <em>Second Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Second Event</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Order#getSecondEvent()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_SecondEvent();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.TimeConstElement <em>Time Const Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Const Element</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.TimeConstElement
	 * @generated
	 */
	EClass getTimeConstElement();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.TimeConstElement#getBoundType <em>Bound Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bound Type</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.TimeConstElement#getBoundType()
	 * @see #getTimeConstElement()
	 * @generated
	 */
	EAttribute getTimeConstElement_BoundType();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.TimeConstElement#getBoundValue <em>Bound Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bound Value</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.TimeConstElement#getBoundValue()
	 * @see #getTimeConstElement()
	 * @generated
	 */
	EAttribute getTimeConstElement_BoundValue();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.TimeConstElement#getFirstEvent <em>First Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Event</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.TimeConstElement#getFirstEvent()
	 * @see #getTimeConstElement()
	 * @generated
	 */
	EAttribute getTimeConstElement_FirstEvent();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.TimeConstElement#getSecondEvent <em>Second Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Second Event</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.TimeConstElement#getSecondEvent()
	 * @see #getTimeConstElement()
	 * @generated
	 */
	EAttribute getTimeConstElement_SecondEvent();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Ecu <em>Ecu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecu</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Ecu
	 * @generated
	 */
	EClass getEcu();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Ecu#getCpuList <em>Cpu List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cpu List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Ecu#getCpuList()
	 * @see #getEcu()
	 * @generated
	 */
	EReference getEcu_CpuList();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Ecu#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Ecu#getName()
	 * @see #getEcu()
	 * @generated
	 */
	EAttribute getEcu_Name();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Task
	 * @generated
	 */
	EClass getTask();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Task#getActivationList <em>Activation List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Activation List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Task#getActivationList()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_ActivationList();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Task#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Task#getName()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Task#getOilVar <em>Oil Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Oil Var</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Task#getOilVar()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_OilVar();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Task#getResourceRefList <em>Resource Ref List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Ref List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Task#getResourceRefList()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_ResourceRefList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Task#getSchedulingList <em>Scheduling List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scheduling List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Task#getSchedulingList()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_SchedulingList();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Task#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Task#getType()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_Type();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the attribute list '{@link com.eu.evidence.rtdruid.vartree.data.Resource#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Methods</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Resource#getMethods()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Methods();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Resource#getMutexRefList <em>Mutex Ref List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mutex Ref List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Resource#getMutexRefList()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_MutexRefList();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Resource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Resource#getName()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Name();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Bus <em>Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bus</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Bus
	 * @generated
	 */
	EClass getBus();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Bus#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Bus#getName()
	 * @see #getBus()
	 * @generated
	 */
	EAttribute getBus_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Bus#getSpeed <em>Speed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speed</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Bus#getSpeed()
	 * @see #getBus()
	 * @generated
	 */
	EAttribute getBus_Speed();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Bus#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Bus#getType()
	 * @see #getBus()
	 * @generated
	 */
	EAttribute getBus_Type();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Frame <em>Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Frame</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Frame
	 * @generated
	 */
	EClass getFrame();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Frame#getActivationClass <em>Activation Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Activation Class</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Frame#getActivationClass()
	 * @see #getFrame()
	 * @generated
	 */
	EAttribute getFrame_ActivationClass();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Frame#getActivationRate <em>Activation Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Activation Rate</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Frame#getActivationRate()
	 * @see #getFrame()
	 * @generated
	 */
	EAttribute getFrame_ActivationRate();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Frame#getActivationType <em>Activation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Activation Type</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Frame#getActivationType()
	 * @see #getFrame()
	 * @generated
	 */
	EAttribute getFrame_ActivationType();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Frame#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Frame#getId()
	 * @see #getFrame()
	 * @generated
	 */
	EAttribute getFrame_Id();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Frame#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Frame#getLength()
	 * @see #getFrame()
	 * @generated
	 */
	EAttribute getFrame_Length();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Frame#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Frame#getName()
	 * @see #getFrame()
	 * @generated
	 */
	EAttribute getFrame_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Frame#getMessageType <em>Message Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message Type</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Frame#getMessageType()
	 * @see #getFrame()
	 * @generated
	 */
	EAttribute getFrame_MessageType();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Signal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Signal</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Signal
	 * @generated
	 */
	EClass getSignal();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Signal#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Signal#getName()
	 * @see #getSignal()
	 * @generated
	 */
	EAttribute getSignal_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Signal#getOilVar <em>Oil Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Oil Var</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Signal#getOilVar()
	 * @see #getSignal()
	 * @generated
	 */
	EAttribute getSignal_OilVar();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Signal#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Signal#getType()
	 * @see #getSignal()
	 * @generated
	 */
	EAttribute getSignal_Type();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Mutex <em>Mutex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mutex</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Mutex
	 * @generated
	 */
	EClass getMutex();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Mutex#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Mutex#getName()
	 * @see #getMutex()
	 * @generated
	 */
	EAttribute getMutex_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Mutex#getOilVar <em>Oil Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Oil Var</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Mutex#getOilVar()
	 * @see #getMutex()
	 * @generated
	 */
	EAttribute getMutex_OilVar();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Mutex#getPolicy <em>Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Policy</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Mutex#getPolicy()
	 * @see #getMutex()
	 * @generated
	 */
	EAttribute getMutex_Policy();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Cpu <em>Cpu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cpu</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Cpu
	 * @generated
	 */
	EClass getCpu();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Cpu#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Cpu#getName()
	 * @see #getCpu()
	 * @generated
	 */
	EAttribute getCpu_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Cpu#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Cpu#getModel()
	 * @see #getCpu()
	 * @generated
	 */
	EAttribute getCpu_Model();

	/**
	 * Returns the meta object for the containment reference '{@link com.eu.evidence.rtdruid.vartree.data.Cpu#getRtos <em>Rtos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rtos</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Cpu#getRtos()
	 * @see #getCpu()
	 * @generated
	 */
	EReference getCpu_Rtos();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Cpu#getOsApplication <em>Os Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Os Application</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Cpu#getOsApplication()
	 * @see #getCpu()
	 * @generated
	 */
	EReference getCpu_OsApplication();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Cpu#getSpeed <em>Speed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speed</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Cpu#getSpeed()
	 * @see #getCpu()
	 * @generated
	 */
	EAttribute getCpu_Speed();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Cpu#getSpeed_Unit <em>Speed Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speed Unit</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Cpu#getSpeed_Unit()
	 * @see #getCpu()
	 * @generated
	 */
	EAttribute getCpu_Speed_Unit();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Cpu#getBinaryImage <em>Binary Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Binary Image</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Cpu#getBinaryImage()
	 * @see #getCpu()
	 * @generated
	 */
	EAttribute getCpu_BinaryImage();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Rtos <em>Rtos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rtos</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Rtos
	 * @generated
	 */
	EClass getRtos();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Rtos#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Rtos#getName()
	 * @see #getRtos()
	 * @generated
	 */
	EAttribute getRtos_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Rtos#getOilVar <em>Oil Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Oil Var</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Rtos#getOilVar()
	 * @see #getRtos()
	 * @generated
	 */
	EAttribute getRtos_OilVar();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Rtos#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Rtos#getType()
	 * @see #getRtos()
	 * @generated
	 */
	EAttribute getRtos_Type();

	/**
	 * Returns the meta object for the attribute list '{@link com.eu.evidence.rtdruid.vartree.data.Rtos#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Methods</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Rtos#getMethods()
	 * @see #getRtos()
	 * @generated
	 */
	EAttribute getRtos_Methods();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Scheduling <em>Scheduling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduling</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Scheduling
	 * @generated
	 */
	EClass getScheduling();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Scheduling#getModeRef <em>Mode Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Scheduling#getModeRef()
	 * @see #getScheduling()
	 * @generated
	 */
	EAttribute getScheduling_ModeRef();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Scheduling#getPreemptionGroupName <em>Preemption Group Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Preemption Group Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Scheduling#getPreemptionGroupName()
	 * @see #getScheduling()
	 * @generated
	 */
	EAttribute getScheduling_PreemptionGroupName();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Scheduling#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Scheduling#getPriority()
	 * @see #getScheduling()
	 * @generated
	 */
	EAttribute getScheduling_Priority();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Scheduling#getThreshold <em>Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Threshold</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Scheduling#getThreshold()
	 * @see #getScheduling()
	 * @generated
	 */
	EAttribute getScheduling_Threshold();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Scheduling#getStack <em>Stack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stack</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Scheduling#getStack()
	 * @see #getScheduling()
	 * @generated
	 */
	EAttribute getScheduling_Stack();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Activation <em>Activation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activation</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Activation
	 * @generated
	 */
	EClass getActivation();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Activation#getActNumber <em>Act Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Act Number</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Activation#getActNumber()
	 * @see #getActivation()
	 * @generated
	 */
	EAttribute getActivation_ActNumber();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Activation#getActivationClass <em>Activation Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Activation Class</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Activation#getActivationClass()
	 * @see #getActivation()
	 * @generated
	 */
	EAttribute getActivation_ActivationClass();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Activation#getDeadline <em>Deadline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deadline</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Activation#getDeadline()
	 * @see #getActivation()
	 * @generated
	 */
	EAttribute getActivation_Deadline();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Activation#getModeRef <em>Mode Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Activation#getModeRef()
	 * @see #getActivation()
	 * @generated
	 */
	EAttribute getActivation_ModeRef();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Activation#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Activation#getOffset()
	 * @see #getActivation()
	 * @generated
	 */
	EAttribute getActivation_Offset();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Activation#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Period</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Activation#getPeriod()
	 * @see #getActivation()
	 * @generated
	 */
	EAttribute getActivation_Period();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Activation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Activation#getType()
	 * @see #getActivation()
	 * @generated
	 */
	EAttribute getActivation_Type();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.ResourceRef <em>Resource Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ResourceRef
	 * @generated
	 */
	EClass getResourceRef();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.ResourceRef#getModeRef <em>Mode Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ResourceRef#getModeRef()
	 * @see #getResourceRef()
	 * @generated
	 */
	EAttribute getResourceRef_ModeRef();

	/**
	 * Returns the meta object for the attribute list '{@link com.eu.evidence.rtdruid.vartree.data.ResourceRef#getResourceMethodRef <em>Resource Method Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Resource Method Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ResourceRef#getResourceMethodRef()
	 * @see #getResourceRef()
	 * @generated
	 */
	EAttribute getResourceRef_ResourceMethodRef();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.MutexRef <em>Mutex Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mutex Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.MutexRef
	 * @generated
	 */
	EClass getMutexRef();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.MutexRef#getModeRef <em>Mode Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.MutexRef#getModeRef()
	 * @see #getMutexRef()
	 * @generated
	 */
	EAttribute getMutexRef_ModeRef();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.MutexRef#getMutexName <em>Mutex Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mutex Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.MutexRef#getMutexName()
	 * @see #getMutexRef()
	 * @generated
	 */
	EAttribute getMutexRef_MutexName();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.ExecTime <em>Exec Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exec Time</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ExecTime
	 * @generated
	 */
	EClass getExecTime();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.ExecTime#getBest <em>Best</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Best</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ExecTime#getBest()
	 * @see #getExecTime()
	 * @generated
	 */
	EAttribute getExecTime_Best();

	/**
	 * Returns the meta object for the containment reference '{@link com.eu.evidence.rtdruid.vartree.data.ExecTime#getDistribution <em>Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Distribution</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ExecTime#getDistribution()
	 * @see #getExecTime()
	 * @generated
	 */
	EReference getExecTime_Distribution();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.ExecTime#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ExecTime#getRef()
	 * @see #getExecTime()
	 * @generated
	 */
	EAttribute getExecTime_Ref();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.ExecTime#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ExecTime#getType()
	 * @see #getExecTime()
	 * @generated
	 */
	EAttribute getExecTime_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.ExecTime#getWorst <em>Worst</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Worst</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ExecTime#getWorst()
	 * @see #getExecTime()
	 * @generated
	 */
	EAttribute getExecTime_Worst();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.ExecTimeList <em>Exec Time List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exec Time List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ExecTimeList
	 * @generated
	 */
	EClass getExecTimeList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.ExecTimeList#getExecTimeItemsList <em>Exec Time Items List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exec Time Items List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ExecTimeList#getExecTimeItemsList()
	 * @see #getExecTimeList()
	 * @generated
	 */
	EReference getExecTimeList_ExecTimeItemsList();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.ExecTimeList#getModeRef <em>Mode Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ExecTimeList#getModeRef()
	 * @see #getExecTimeList()
	 * @generated
	 */
	EAttribute getExecTimeList_ModeRef();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Distribution <em>Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Distribution</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Distribution
	 * @generated
	 */
	EClass getDistribution();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Distribution#getAvg <em>Avg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Avg</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Distribution#getAvg()
	 * @see #getDistribution()
	 * @generated
	 */
	EAttribute getDistribution_Avg();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Distribution#getSampleList <em>Sample List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sample List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Distribution#getSampleList()
	 * @see #getDistribution()
	 * @generated
	 */
	EReference getDistribution_SampleList();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Distribution#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Distribution#getType()
	 * @see #getDistribution()
	 * @generated
	 */
	EAttribute getDistribution_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Distribution#getVariance <em>Variance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variance</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Distribution#getVariance()
	 * @see #getDistribution()
	 * @generated
	 */
	EAttribute getDistribution_Variance();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Sample <em>Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sample</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Sample
	 * @generated
	 */
	EClass getSample();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Sample#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Sample#getProbability()
	 * @see #getSample()
	 * @generated
	 */
	EAttribute getSample_Probability();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Sample#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Sample#getValue()
	 * @see #getSample()
	 * @generated
	 */
	EAttribute getSample_Value();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.ProcMap <em>Proc Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Proc Map</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ProcMap
	 * @generated
	 */
	EClass getProcMap();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.ProcMap#getModeRef <em>Mode Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ProcMap#getModeRef()
	 * @see #getProcMap()
	 * @generated
	 */
	EAttribute getProcMap_ModeRef();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.ProcMap#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ProcMap#getOrder()
	 * @see #getProcMap()
	 * @generated
	 */
	EAttribute getProcMap_Order();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.ProcMap#getProcRef <em>Proc Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Proc Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ProcMap#getProcRef()
	 * @see #getProcMap()
	 * @generated
	 */
	EAttribute getProcMap_ProcRef();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.ProcMap#getTaskRef <em>Task Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Task Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ProcMap#getTaskRef()
	 * @see #getProcMap()
	 * @generated
	 */
	EAttribute getProcMap_TaskRef();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.ProcMap#getOnceEveryK <em>Once Every K</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Once Every K</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ProcMap#getOnceEveryK()
	 * @see #getProcMap()
	 * @generated
	 */
	EAttribute getProcMap_OnceEveryK();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.ProcMap#getMethodRefName <em>Method Ref Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Ref Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ProcMap#getMethodRefName()
	 * @see #getProcMap()
	 * @generated
	 */
	EAttribute getProcMap_MethodRefName();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.TaskMap <em>Task Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Map</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.TaskMap
	 * @generated
	 */
	EClass getTaskMap();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.TaskMap#getModeRef <em>Mode Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.TaskMap#getModeRef()
	 * @see #getTaskMap()
	 * @generated
	 */
	EAttribute getTaskMap_ModeRef();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.TaskMap#getRtosRef <em>Rtos Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rtos Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.TaskMap#getRtosRef()
	 * @see #getTaskMap()
	 * @generated
	 */
	EAttribute getTaskMap_RtosRef();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.TaskMap#getTaskRef <em>Task Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Task Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.TaskMap#getTaskRef()
	 * @see #getTaskMap()
	 * @generated
	 */
	EAttribute getTaskMap_TaskRef();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.VarMap <em>Var Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var Map</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.VarMap
	 * @generated
	 */
	EClass getVarMap();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.VarMap#getBusRef <em>Bus Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bus Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.VarMap#getBusRef()
	 * @see #getVarMap()
	 * @generated
	 */
	EAttribute getVarMap_BusRef();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.VarMap#getFrameRef <em>Frame Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frame Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.VarMap#getFrameRef()
	 * @see #getVarMap()
	 * @generated
	 */
	EAttribute getVarMap_FrameRef();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.VarMap#getModeRef <em>Mode Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.VarMap#getModeRef()
	 * @see #getVarMap()
	 * @generated
	 */
	EAttribute getVarMap_ModeRef();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.VarMap#getMutexRef <em>Mutex Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mutex Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.VarMap#getMutexRef()
	 * @see #getVarMap()
	 * @generated
	 */
	EAttribute getVarMap_MutexRef();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.VarMap#getVarRef <em>Var Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.VarMap#getVarRef()
	 * @see #getVarMap()
	 * @generated
	 */
	EAttribute getVarMap_VarRef();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.SchedulingScenario <em>Scheduling Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduling Scenario</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.SchedulingScenario
	 * @generated
	 */
	EClass getSchedulingScenario();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.SchedulingScenario#getCpuSchedList <em>Cpu Sched List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cpu Sched List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.SchedulingScenario#getCpuSchedList()
	 * @see #getSchedulingScenario()
	 * @generated
	 */
	EReference getSchedulingScenario_CpuSchedList();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.SchedulingScenario#getModeRef <em>Mode Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.SchedulingScenario#getModeRef()
	 * @see #getSchedulingScenario()
	 * @generated
	 */
	EAttribute getSchedulingScenario_ModeRef();

	/**
	 * Returns the meta object for the attribute list '{@link com.eu.evidence.rtdruid.vartree.data.SchedulingScenario#getReports <em>Reports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Reports</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.SchedulingScenario#getReports()
	 * @see #getSchedulingScenario()
	 * @generated
	 */
	EAttribute getSchedulingScenario_Reports();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.SchedulingScenario#getTaskSchedList <em>Task Sched List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Task Sched List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.SchedulingScenario#getTaskSchedList()
	 * @see #getSchedulingScenario()
	 * @generated
	 */
	EReference getSchedulingScenario_TaskSchedList();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.CpuSched <em>Cpu Sched</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cpu Sched</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.CpuSched
	 * @generated
	 */
	EClass getCpuSched();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.CpuSched#getBoundary <em>Boundary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boundary</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.CpuSched#getBoundary()
	 * @see #getCpuSched()
	 * @generated
	 */
	EAttribute getCpuSched_Boundary();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.CpuSched#getCpuRef <em>Cpu Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cpu Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.CpuSched#getCpuRef()
	 * @see #getCpuSched()
	 * @generated
	 */
	EAttribute getCpuSched_CpuRef();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.CpuSched#getSchedulable <em>Schedulable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Schedulable</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.CpuSched#getSchedulable()
	 * @see #getCpuSched()
	 * @generated
	 */
	EAttribute getCpuSched_Schedulable();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.CpuSched#getSpeedFactor <em>Speed Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speed Factor</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.CpuSched#getSpeedFactor()
	 * @see #getCpuSched()
	 * @generated
	 */
	EAttribute getCpuSched_SpeedFactor();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.CpuSched#getUtilization <em>Utilization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Utilization</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.CpuSched#getUtilization()
	 * @see #getCpuSched()
	 * @generated
	 */
	EAttribute getCpuSched_Utilization();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.CpuSched#getMaxStackSize <em>Max Stack Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Stack Size</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.CpuSched#getMaxStackSize()
	 * @see #getCpuSched()
	 * @generated
	 */
	EAttribute getCpuSched_MaxStackSize();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.TaskSched <em>Task Sched</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Sched</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.TaskSched
	 * @generated
	 */
	EClass getTaskSched();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.TaskSched#getCDelta <em>CDelta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CDelta</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.TaskSched#getCDelta()
	 * @see #getTaskSched()
	 * @generated
	 */
	EAttribute getTaskSched_CDelta();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.TaskSched#getResponseTime <em>Response Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Response Time</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.TaskSched#getResponseTime()
	 * @see #getTaskSched()
	 * @generated
	 */
	EAttribute getTaskSched_ResponseTime();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.TaskSched#getSchedulable <em>Schedulable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Schedulable</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.TaskSched#getSchedulable()
	 * @see #getTaskSched()
	 * @generated
	 */
	EAttribute getTaskSched_Schedulable();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.TaskSched#getTaskRef <em>Task Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Task Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.TaskSched#getTaskRef()
	 * @see #getTaskSched()
	 * @generated
	 */
	EAttribute getTaskSched_TaskRef();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.TaskSched#getTDelta <em>TDelta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>TDelta</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.TaskSched#getTDelta()
	 * @see #getTaskSched()
	 * @generated
	 */
	EAttribute getTaskSched_TDelta();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.TaskSched#getUtilization <em>Utilization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Utilization</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.TaskSched#getUtilization()
	 * @see #getTaskSched()
	 * @generated
	 */
	EAttribute getTaskSched_Utilization();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCostList <em>Cache Miss Cost List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cache Miss Cost List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.CacheMissCostList
	 * @generated
	 */
	EClass getCacheMissCostList();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCostList#getCacheMissCostItemsList <em>Cache Miss Cost Items List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cache Miss Cost Items List</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.CacheMissCostList#getCacheMissCostItemsList()
	 * @see #getCacheMissCostList()
	 * @generated
	 */
	EReference getCacheMissCostList_CacheMissCostItemsList();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCostList#getModeRef <em>Mode Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.CacheMissCostList#getModeRef()
	 * @see #getCacheMissCostList()
	 * @generated
	 */
	EAttribute getCacheMissCostList_ModeRef();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCost <em>Cache Miss Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cache Miss Cost</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.CacheMissCost
	 * @generated
	 */
	EClass getCacheMissCost();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCost#getBest <em>Best</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Best</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.CacheMissCost#getBest()
	 * @see #getCacheMissCost()
	 * @generated
	 */
	EAttribute getCacheMissCost_Best();

	/**
	 * Returns the meta object for the containment reference '{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCost#getDistribution <em>Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Distribution</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.CacheMissCost#getDistribution()
	 * @see #getCacheMissCost()
	 * @generated
	 */
	EReference getCacheMissCost_Distribution();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCost#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.CacheMissCost#getRef()
	 * @see #getCacheMissCost()
	 * @generated
	 */
	EAttribute getCacheMissCost_Ref();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCost#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.CacheMissCost#getType()
	 * @see #getCacheMissCost()
	 * @generated
	 */
	EAttribute getCacheMissCost_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCost#getWorst <em>Worst</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Worst</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.CacheMissCost#getWorst()
	 * @see #getCacheMissCost()
	 * @generated
	 */
	EAttribute getCacheMissCost_Worst();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Field
	 * @generated
	 */
	EClass getField();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Field#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Field#getName()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Field#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Field#getType()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Field#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Field#getSize()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_Size();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Type#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Type#getName()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.eu.evidence.rtdruid.vartree.data.Type#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Field</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Type#getField()
	 * @see #getType()
	 * @generated
	 */
	EReference getType_Field();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Type#getDim <em>Dim</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dim</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Type#getDim()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_Dim();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.OsApplication <em>Os Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Os Application</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.OsApplication
	 * @generated
	 */
	EClass getOsApplication();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.OsApplication#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.OsApplication#getName()
	 * @see #getOsApplication()
	 * @generated
	 */
	EAttribute getOsApplication_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.OsApplication#getOilVar <em>Oil Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Oil Var</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.OsApplication#getOilVar()
	 * @see #getOsApplication()
	 * @generated
	 */
	EAttribute getOsApplication_OilVar();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.Com <em>Com</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Com</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Com
	 * @generated
	 */
	EClass getCom();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.Com#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.Com#getName()
	 * @see #getCom()
	 * @generated
	 */
	EAttribute getCom_Name();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.SpinLock <em>Spin Lock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Spin Lock</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.SpinLock
	 * @generated
	 */
	EClass getSpinLock();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.SpinLock#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.SpinLock#getName()
	 * @see #getSpinLock()
	 * @generated
	 */
	EAttribute getSpinLock_Name();

	/**
	 * Returns the meta object for class '{@link com.eu.evidence.rtdruid.vartree.data.ScheduleTable <em>Scheduling Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduling Table</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ScheduleTable
	 * @generated
	 */
	EClass getScheduleTable();

	/**
	 * Returns the meta object for the attribute '{@link com.eu.evidence.rtdruid.vartree.data.ScheduleTable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.data.ScheduleTable#getName()
	 * @see #getScheduleTable()
	 * @generated
	 */
	EAttribute getScheduleTable_Name();

	/**
	 * Returns the meta object for data type '{@link com.eu.evidence.rtdruid.vartree.variables.BooleanVar <em>Boolean Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Boolean Var</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.variables.BooleanVar
	 * @model instanceClass="com.eu.evidence.rtdruid.vartree.variables.BooleanVar"
	 * @generated
	 */
	EDataType getBooleanVar();

	/**
	 * Returns the meta object for data type '{@link com.eu.evidence.rtdruid.vartree.variables.DoubleVar <em>Double Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Double Var</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.variables.DoubleVar
	 * @model instanceClass="com.eu.evidence.rtdruid.vartree.variables.DoubleVar"
	 * @generated
	 */
	EDataType getDoubleVar();

	/**
	 * Returns the meta object for data type '{@link com.eu.evidence.rtdruid.vartree.variables.FloatVar <em>Float Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Float Var</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.variables.FloatVar
	 * @model instanceClass="com.eu.evidence.rtdruid.vartree.variables.FloatVar"
	 * @generated
	 */
	EDataType getFloatVar();

	/**
	 * Returns the meta object for data type '{@link com.eu.evidence.rtdruid.vartree.variables.IntegerVar <em>Integer Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Integer Var</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.variables.IntegerVar
	 * @model instanceClass="com.eu.evidence.rtdruid.vartree.variables.IntegerVar"
	 * @generated
	 */
	EDataType getIntegerVar();

	/**
	 * Returns the meta object for data type '{@link com.eu.evidence.rtdruid.vartree.variables.LongVar <em>Long Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Long Var</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.variables.LongVar
	 * @model instanceClass="com.eu.evidence.rtdruid.vartree.variables.LongVar"
	 * @generated
	 */
	EDataType getLongVar();

	/**
	 * Returns the meta object for data type '{@link com.eu.evidence.rtdruid.vartree.variables.OilVar <em>Oil Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Oil Var</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.variables.OilVar
	 * @model instanceClass="com.eu.evidence.rtdruid.vartree.variables.OilVar"
	 * @generated
	 */
	EDataType getOilVar();

	/**
	 * Returns the meta object for data type '{@link com.eu.evidence.rtdruid.vartree.variables.StringVar <em>String Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>String Var</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.variables.StringVar
	 * @model instanceClass="com.eu.evidence.rtdruid.vartree.variables.StringVar"
	 * @generated
	 */
	EDataType getStringVar();

	/**
	 * Returns the meta object for data type '{@link com.eu.evidence.rtdruid.vartree.variables.TimeVar <em>Time Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Time Var</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.variables.TimeVar
	 * @model instanceClass="com.eu.evidence.rtdruid.vartree.variables.TimeVar"
	 * @generated
	 */
	EDataType getTimeVar();

	/**
	 * Returns the meta object for data type '{@link com.eu.evidence.rtdruid.vartree.variables.PropertyVar <em>Property Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Property Var</em>'.
	 * @see com.eu.evidence.rtdruid.vartree.variables.PropertyVar
	 * @model instanceClass="com.eu.evidence.rtdruid.vartree.variables.PropertyVar"
	 * @generated
	 */
	EDataType getPropertyVar();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DataFactory getDataFactory();

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
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.SystemImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '<em><b>Annotation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__ANNOTATION = eINSTANCE.getSystem_Annotation();

		/**
		 * The meta object literal for the '<em><b>Architectural</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__ARCHITECTURAL = eINSTANCE.getSystem_Architectural();

		/**
		 * The meta object literal for the '<em><b>Functional</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__FUNCTIONAL = eINSTANCE.getSystem_Functional();

		/**
		 * The meta object literal for the '<em><b>Mapping</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__MAPPING = eINSTANCE.getSystem_Mapping();

		/**
		 * The meta object literal for the '<em><b>Modes</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__MODES = eINSTANCE.getSystem_Modes();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM__NAME = eINSTANCE.getSystem_Name();

		/**
		 * The meta object literal for the '<em><b>Schedulability</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__SCHEDULABILITY = eINSTANCE.getSystem_Schedulability();

		/**
		 * The meta object literal for the '<em><b>XTC Cookie</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM__XTC_COOKIE = eINSTANCE.getSystem_XTC_Cookie();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ObjectWithIDImpl <em>Object With ID</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ObjectWithIDImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getObjectWithID()
		 * @generated
		 */
		EClass OBJECT_WITH_ID = eINSTANCE.getObjectWithID();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_WITH_ID__PROPERTIES = eINSTANCE.getObjectWithID_Properties();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ModesImpl <em>Modes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ModesImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getModes()
		 * @generated
		 */
		EClass MODES = eINSTANCE.getModes();

		/**
		 * The meta object literal for the '<em><b>Mode List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODES__MODE_LIST = eINSTANCE.getModes_ModeList();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ModeImpl <em>Mode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ModeImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getMode()
		 * @generated
		 */
		EClass MODE = eINSTANCE.getMode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODE__NAME = eINSTANCE.getMode_Name();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.FunctionalImpl <em>Functional</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.FunctionalImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getFunctional()
		 * @generated
		 */
		EClass FUNCTIONAL = eINSTANCE.getFunctional();

		/**
		 * The meta object literal for the '<em><b>Event List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONAL__EVENT_LIST = eINSTANCE.getFunctional_EventList();

		/**
		 * The meta object literal for the '<em><b>Partial Order List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONAL__PARTIAL_ORDER_LIST = eINSTANCE.getFunctional_PartialOrderList();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONAL__IMPLEMENTATION = eINSTANCE.getFunctional_Implementation();

		/**
		 * The meta object literal for the '<em><b>Time Const List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONAL__TIME_CONST_LIST = eINSTANCE.getFunctional_TimeConstList();

		/**
		 * The meta object literal for the '<em><b>Type List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONAL__TYPE_LIST = eINSTANCE.getFunctional_TypeList();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ImplementationImpl <em>Implementation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ImplementationImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getImplementation()
		 * @generated
		 */
		EClass IMPLEMENTATION = eINSTANCE.getImplementation();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ProcImpl <em>Proc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ProcImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getProc()
		 * @generated
		 */
		EClass PROC = eINSTANCE.getProc();

		/**
		 * The meta object literal for the '<em><b>Method Ref List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROC__METHOD_REF_LIST = eINSTANCE.getProc_MethodRefList();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROC__METHODS = eINSTANCE.getProc_Methods();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ArchitecturalImpl <em>Architectural</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ArchitecturalImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getArchitectural()
		 * @generated
		 */
		EClass ARCHITECTURAL = eINSTANCE.getArchitectural();

		/**
		 * The meta object literal for the '<em><b>Bus List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURAL__BUS_LIST = eINSTANCE.getArchitectural_BusList();

		/**
		 * The meta object literal for the '<em><b>Ecu List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURAL__ECU_LIST = eINSTANCE.getArchitectural_EcuList();

		/**
		 * The meta object literal for the '<em><b>Frame List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURAL__FRAME_LIST = eINSTANCE.getArchitectural_FrameList();

		/**
		 * The meta object literal for the '<em><b>Mutex List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURAL__MUTEX_LIST = eINSTANCE.getArchitectural_MutexList();

		/**
		 * The meta object literal for the '<em><b>Resource List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURAL__RESOURCE_LIST = eINSTANCE.getArchitectural_ResourceList();

		/**
		 * The meta object literal for the '<em><b>Signal List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURAL__SIGNAL_LIST = eINSTANCE.getArchitectural_SignalList();

		/**
		 * The meta object literal for the '<em><b>Task List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURAL__TASK_LIST = eINSTANCE.getArchitectural_TaskList();

		/**
		 * The meta object literal for the '<em><b>Com List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURAL__COM_LIST = eINSTANCE.getArchitectural_ComList();

		/**
		 * The meta object literal for the '<em><b>Spin Lock List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURAL__SPIN_LOCK_LIST = eINSTANCE.getArchitectural_SpinLockList();

		/**
		 * The meta object literal for the '<em><b>Scheduling Table List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURAL__SCHEDULE_TABLE_LIST = eINSTANCE.getArchitectural_ScheduleTableList();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.MappingImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>Proc Map List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__PROC_MAP_LIST = eINSTANCE.getMapping_ProcMapList();

		/**
		 * The meta object literal for the '<em><b>Task Map List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__TASK_MAP_LIST = eINSTANCE.getMapping_TaskMapList();

		/**
		 * The meta object literal for the '<em><b>Var Map List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__VAR_MAP_LIST = eINSTANCE.getMapping_VarMapList();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.AnnotationImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Exec Time Lists</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__EXEC_TIME_LISTS = eINSTANCE.getAnnotation_ExecTimeLists();

		/**
		 * The meta object literal for the '<em><b>Cache Miss Cost Lists</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__CACHE_MISS_COST_LISTS = eINSTANCE.getAnnotation_CacheMissCostLists();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SchedulabilityImpl <em>Schedulability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.SchedulabilityImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getSchedulability()
		 * @generated
		 */
		EClass SCHEDULABILITY = eINSTANCE.getSchedulability();

		/**
		 * The meta object literal for the '<em><b>Scheduling Scenario List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULABILITY__SCHEDULING_SCENARIO_LIST = eINSTANCE.getSchedulability_SchedulingScenarioList();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.VarImpl <em>Var</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.VarImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getVar()
		 * @generated
		 */
		EClass VAR = eINSTANCE.getVar();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR__METHODS = eINSTANCE.getVar_Methods();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR__TYPE = eINSTANCE.getVar_Type();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TriggerImpl <em>Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.TriggerImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getTrigger()
		 * @generated
		 */
		EClass TRIGGER = eINSTANCE.getTrigger();

		/**
		 * The meta object literal for the '<em><b>Method Ref List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIGGER__METHOD_REF_LIST = eINSTANCE.getTrigger_MethodRefList();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.EventImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__NAME = eINSTANCE.getEvent_Name();

		/**
		 * The meta object literal for the '<em><b>Method Ref Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__METHOD_REF_NAME = eINSTANCE.getEvent_MethodRefName();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__TYPE = eINSTANCE.getEvent_Type();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.PartialOrderImpl <em>Partial Order</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.PartialOrderImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getPartialOrder()
		 * @generated
		 */
		EClass PARTIAL_ORDER = eINSTANCE.getPartialOrder();

		/**
		 * The meta object literal for the '<em><b>Mode Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTIAL_ORDER__MODE_REF = eINSTANCE.getPartialOrder_ModeRef();

		/**
		 * The meta object literal for the '<em><b>Order List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTIAL_ORDER__ORDER_LIST = eINSTANCE.getPartialOrder_OrderList();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SystemImplementationImpl <em>System Implementation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.SystemImplementationImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getSystemImplementation()
		 * @generated
		 */
		EClass SYSTEM_IMPLEMENTATION = eINSTANCE.getSystemImplementation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_IMPLEMENTATION__NAME = eINSTANCE.getSystemImplementation_Name();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SubSystemImpl <em>Sub System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.SubSystemImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getSubSystem()
		 * @generated
		 */
		EClass SUB_SYSTEM = eINSTANCE.getSubSystem();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_SYSTEM__IMPLEMENTATION = eINSTANCE.getSubSystem_Implementation();

		/**
		 * The meta object literal for the '<em><b>Provided Interface List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_SYSTEM__PROVIDED_INTERFACE_LIST = eINSTANCE.getSubSystem_ProvidedInterfaceList();

		/**
		 * The meta object literal for the '<em><b>Required Interface List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_SYSTEM__REQUIRED_INTERFACE_LIST = eINSTANCE.getSubSystem_RequiredInterfaceList();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TimeConstImpl <em>Time Const</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.TimeConstImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getTimeConst()
		 * @generated
		 */
		EClass TIME_CONST = eINSTANCE.getTimeConst();

		/**
		 * The meta object literal for the '<em><b>Mode Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_CONST__MODE_REF = eINSTANCE.getTimeConst_ModeRef();

		/**
		 * The meta object literal for the '<em><b>Time Const Element List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIME_CONST__TIME_CONST_ELEMENT_LIST = eINSTANCE.getTimeConst_TimeConstElementList();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.MethodRefImpl <em>Method Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.MethodRefImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getMethodRef()
		 * @generated
		 */
		EClass METHOD_REF = eINSTANCE.getMethodRef();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_REF__NAME = eINSTANCE.getMethodRef_Name();

		/**
		 * The meta object literal for the '<em><b>Method Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_REF__METHOD_NAME = eINSTANCE.getMethodRef_MethodName();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ProvidedInterfaceImpl <em>Provided Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ProvidedInterfaceImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getProvidedInterface()
		 * @generated
		 */
		EClass PROVIDED_INTERFACE = eINSTANCE.getProvidedInterface();

		/**
		 * The meta object literal for the '<em><b>Local Method Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROVIDED_INTERFACE__LOCAL_METHOD_REF = eINSTANCE.getProvidedInterface_LocalMethodRef();

		/**
		 * The meta object literal for the '<em><b>Local Object Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROVIDED_INTERFACE__LOCAL_OBJECT_REF = eINSTANCE.getProvidedInterface_LocalObjectRef();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROVIDED_INTERFACE__NAME = eINSTANCE.getProvidedInterface_Name();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.RequiredInterfaceImpl <em>Required Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.RequiredInterfaceImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getRequiredInterface()
		 * @generated
		 */
		EClass REQUIRED_INTERFACE = eINSTANCE.getRequiredInterface();

		/**
		 * The meta object literal for the '<em><b>External Method Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRED_INTERFACE__EXTERNAL_METHOD_REF = eINSTANCE.getRequiredInterface_ExternalMethodRef();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRED_INTERFACE__NAME = eINSTANCE.getRequiredInterface_Name();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.OrderImpl <em>Order</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.OrderImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getOrder()
		 * @generated
		 */
		EClass ORDER = eINSTANCE.getOrder();

		/**
		 * The meta object literal for the '<em><b>First Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__FIRST_EVENT = eINSTANCE.getOrder_FirstEvent();

		/**
		 * The meta object literal for the '<em><b>Second Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__SECOND_EVENT = eINSTANCE.getOrder_SecondEvent();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TimeConstElementImpl <em>Time Const Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.TimeConstElementImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getTimeConstElement()
		 * @generated
		 */
		EClass TIME_CONST_ELEMENT = eINSTANCE.getTimeConstElement();

		/**
		 * The meta object literal for the '<em><b>Bound Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_CONST_ELEMENT__BOUND_TYPE = eINSTANCE.getTimeConstElement_BoundType();

		/**
		 * The meta object literal for the '<em><b>Bound Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_CONST_ELEMENT__BOUND_VALUE = eINSTANCE.getTimeConstElement_BoundValue();

		/**
		 * The meta object literal for the '<em><b>First Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_CONST_ELEMENT__FIRST_EVENT = eINSTANCE.getTimeConstElement_FirstEvent();

		/**
		 * The meta object literal for the '<em><b>Second Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_CONST_ELEMENT__SECOND_EVENT = eINSTANCE.getTimeConstElement_SecondEvent();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.EcuImpl <em>Ecu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.EcuImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getEcu()
		 * @generated
		 */
		EClass ECU = eINSTANCE.getEcu();

		/**
		 * The meta object literal for the '<em><b>Cpu List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECU__CPU_LIST = eINSTANCE.getEcu_CpuList();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECU__NAME = eINSTANCE.getEcu_Name();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskImpl <em>Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getTask()
		 * @generated
		 */
		EClass TASK = eINSTANCE.getTask();

		/**
		 * The meta object literal for the '<em><b>Activation List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__ACTIVATION_LIST = eINSTANCE.getTask_ActivationList();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__NAME = eINSTANCE.getTask_Name();

		/**
		 * The meta object literal for the '<em><b>Oil Var</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__OIL_VAR = eINSTANCE.getTask_OilVar();

		/**
		 * The meta object literal for the '<em><b>Resource Ref List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__RESOURCE_REF_LIST = eINSTANCE.getTask_ResourceRefList();

		/**
		 * The meta object literal for the '<em><b>Scheduling List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK__SCHEDULING_LIST = eINSTANCE.getTask_SchedulingList();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK__TYPE = eINSTANCE.getTask_Type();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ResourceImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__METHODS = eINSTANCE.getResource_Methods();

		/**
		 * The meta object literal for the '<em><b>Mutex Ref List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__MUTEX_REF_LIST = eINSTANCE.getResource_MutexRefList();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__NAME = eINSTANCE.getResource_Name();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.BusImpl <em>Bus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.BusImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getBus()
		 * @generated
		 */
		EClass BUS = eINSTANCE.getBus();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUS__NAME = eINSTANCE.getBus_Name();

		/**
		 * The meta object literal for the '<em><b>Speed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUS__SPEED = eINSTANCE.getBus_Speed();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUS__TYPE = eINSTANCE.getBus_Type();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.FrameImpl <em>Frame</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.FrameImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getFrame()
		 * @generated
		 */
		EClass FRAME = eINSTANCE.getFrame();

		/**
		 * The meta object literal for the '<em><b>Activation Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FRAME__ACTIVATION_CLASS = eINSTANCE.getFrame_ActivationClass();

		/**
		 * The meta object literal for the '<em><b>Activation Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FRAME__ACTIVATION_RATE = eINSTANCE.getFrame_ActivationRate();

		/**
		 * The meta object literal for the '<em><b>Activation Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FRAME__ACTIVATION_TYPE = eINSTANCE.getFrame_ActivationType();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FRAME__ID = eINSTANCE.getFrame_Id();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FRAME__LENGTH = eINSTANCE.getFrame_Length();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FRAME__NAME = eINSTANCE.getFrame_Name();

		/**
		 * The meta object literal for the '<em><b>Message Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FRAME__MESSAGE_TYPE = eINSTANCE.getFrame_MessageType();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SignalImpl <em>Signal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.SignalImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getSignal()
		 * @generated
		 */
		EClass SIGNAL = eINSTANCE.getSignal();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGNAL__NAME = eINSTANCE.getSignal_Name();

		/**
		 * The meta object literal for the '<em><b>Oil Var</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGNAL__OIL_VAR = eINSTANCE.getSignal_OilVar();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGNAL__TYPE = eINSTANCE.getSignal_Type();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.MutexImpl <em>Mutex</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.MutexImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getMutex()
		 * @generated
		 */
		EClass MUTEX = eINSTANCE.getMutex();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MUTEX__NAME = eINSTANCE.getMutex_Name();

		/**
		 * The meta object literal for the '<em><b>Oil Var</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MUTEX__OIL_VAR = eINSTANCE.getMutex_OilVar();

		/**
		 * The meta object literal for the '<em><b>Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MUTEX__POLICY = eINSTANCE.getMutex_Policy();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CpuImpl <em>Cpu</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.CpuImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getCpu()
		 * @generated
		 */
		EClass CPU = eINSTANCE.getCpu();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPU__NAME = eINSTANCE.getCpu_Name();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPU__MODEL = eINSTANCE.getCpu_Model();

		/**
		 * The meta object literal for the '<em><b>Rtos</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPU__RTOS = eINSTANCE.getCpu_Rtos();

		/**
		 * The meta object literal for the '<em><b>Os Application</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPU__OS_APPLICATION = eINSTANCE.getCpu_OsApplication();

		/**
		 * The meta object literal for the '<em><b>Speed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPU__SPEED = eINSTANCE.getCpu_Speed();

		/**
		 * The meta object literal for the '<em><b>Speed Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPU__SPEED_UNIT = eINSTANCE.getCpu_Speed_Unit();

		/**
		 * The meta object literal for the '<em><b>Binary Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPU__BINARY_IMAGE = eINSTANCE.getCpu_BinaryImage();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.RtosImpl <em>Rtos</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.RtosImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getRtos()
		 * @generated
		 */
		EClass RTOS = eINSTANCE.getRtos();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RTOS__NAME = eINSTANCE.getRtos_Name();

		/**
		 * The meta object literal for the '<em><b>Oil Var</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RTOS__OIL_VAR = eINSTANCE.getRtos_OilVar();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RTOS__TYPE = eINSTANCE.getRtos_Type();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RTOS__METHODS = eINSTANCE.getRtos_Methods();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SchedulingImpl <em>Scheduling</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.SchedulingImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getScheduling()
		 * @generated
		 */
		EClass SCHEDULING = eINSTANCE.getScheduling();

		/**
		 * The meta object literal for the '<em><b>Mode Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULING__MODE_REF = eINSTANCE.getScheduling_ModeRef();

		/**
		 * The meta object literal for the '<em><b>Preemption Group Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULING__PREEMPTION_GROUP_NAME = eINSTANCE.getScheduling_PreemptionGroupName();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULING__PRIORITY = eINSTANCE.getScheduling_Priority();

		/**
		 * The meta object literal for the '<em><b>Threshold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULING__THRESHOLD = eINSTANCE.getScheduling_Threshold();

		/**
		 * The meta object literal for the '<em><b>Stack</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULING__STACK = eINSTANCE.getScheduling_Stack();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ActivationImpl <em>Activation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ActivationImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getActivation()
		 * @generated
		 */
		EClass ACTIVATION = eINSTANCE.getActivation();

		/**
		 * The meta object literal for the '<em><b>Act Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVATION__ACT_NUMBER = eINSTANCE.getActivation_ActNumber();

		/**
		 * The meta object literal for the '<em><b>Activation Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVATION__ACTIVATION_CLASS = eINSTANCE.getActivation_ActivationClass();

		/**
		 * The meta object literal for the '<em><b>Deadline</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVATION__DEADLINE = eINSTANCE.getActivation_Deadline();

		/**
		 * The meta object literal for the '<em><b>Mode Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVATION__MODE_REF = eINSTANCE.getActivation_ModeRef();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVATION__OFFSET = eINSTANCE.getActivation_Offset();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVATION__PERIOD = eINSTANCE.getActivation_Period();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVATION__TYPE = eINSTANCE.getActivation_Type();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ResourceRefImpl <em>Resource Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ResourceRefImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getResourceRef()
		 * @generated
		 */
		EClass RESOURCE_REF = eINSTANCE.getResourceRef();

		/**
		 * The meta object literal for the '<em><b>Mode Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_REF__MODE_REF = eINSTANCE.getResourceRef_ModeRef();

		/**
		 * The meta object literal for the '<em><b>Resource Method Ref</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_REF__RESOURCE_METHOD_REF = eINSTANCE.getResourceRef_ResourceMethodRef();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.MutexRefImpl <em>Mutex Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.MutexRefImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getMutexRef()
		 * @generated
		 */
		EClass MUTEX_REF = eINSTANCE.getMutexRef();

		/**
		 * The meta object literal for the '<em><b>Mode Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MUTEX_REF__MODE_REF = eINSTANCE.getMutexRef_ModeRef();

		/**
		 * The meta object literal for the '<em><b>Mutex Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MUTEX_REF__MUTEX_NAME = eINSTANCE.getMutexRef_MutexName();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ExecTimeImpl <em>Exec Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ExecTimeImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getExecTime()
		 * @generated
		 */
		EClass EXEC_TIME = eINSTANCE.getExecTime();

		/**
		 * The meta object literal for the '<em><b>Best</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_TIME__BEST = eINSTANCE.getExecTime_Best();

		/**
		 * The meta object literal for the '<em><b>Distribution</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXEC_TIME__DISTRIBUTION = eINSTANCE.getExecTime_Distribution();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_TIME__REF = eINSTANCE.getExecTime_Ref();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_TIME__TYPE = eINSTANCE.getExecTime_Type();

		/**
		 * The meta object literal for the '<em><b>Worst</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_TIME__WORST = eINSTANCE.getExecTime_Worst();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ExecTimeListImpl <em>Exec Time List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ExecTimeListImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getExecTimeList()
		 * @generated
		 */
		EClass EXEC_TIME_LIST = eINSTANCE.getExecTimeList();

		/**
		 * The meta object literal for the '<em><b>Exec Time Items List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXEC_TIME_LIST__EXEC_TIME_ITEMS_LIST = eINSTANCE.getExecTimeList_ExecTimeItemsList();

		/**
		 * The meta object literal for the '<em><b>Mode Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC_TIME_LIST__MODE_REF = eINSTANCE.getExecTimeList_ModeRef();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.DistributionImpl <em>Distribution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DistributionImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getDistribution()
		 * @generated
		 */
		EClass DISTRIBUTION = eINSTANCE.getDistribution();

		/**
		 * The meta object literal for the '<em><b>Avg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISTRIBUTION__AVG = eINSTANCE.getDistribution_Avg();

		/**
		 * The meta object literal for the '<em><b>Sample List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISTRIBUTION__SAMPLE_LIST = eINSTANCE.getDistribution_SampleList();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISTRIBUTION__TYPE = eINSTANCE.getDistribution_Type();

		/**
		 * The meta object literal for the '<em><b>Variance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISTRIBUTION__VARIANCE = eINSTANCE.getDistribution_Variance();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SampleImpl <em>Sample</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.SampleImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getSample()
		 * @generated
		 */
		EClass SAMPLE = eINSTANCE.getSample();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLE__PROBABILITY = eINSTANCE.getSample_Probability();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAMPLE__VALUE = eINSTANCE.getSample_Value();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ProcMapImpl <em>Proc Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ProcMapImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getProcMap()
		 * @generated
		 */
		EClass PROC_MAP = eINSTANCE.getProcMap();

		/**
		 * The meta object literal for the '<em><b>Mode Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROC_MAP__MODE_REF = eINSTANCE.getProcMap_ModeRef();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROC_MAP__ORDER = eINSTANCE.getProcMap_Order();

		/**
		 * The meta object literal for the '<em><b>Proc Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROC_MAP__PROC_REF = eINSTANCE.getProcMap_ProcRef();

		/**
		 * The meta object literal for the '<em><b>Task Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROC_MAP__TASK_REF = eINSTANCE.getProcMap_TaskRef();

		/**
		 * The meta object literal for the '<em><b>Once Every K</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROC_MAP__ONCE_EVERY_K = eINSTANCE.getProcMap_OnceEveryK();

		/**
		 * The meta object literal for the '<em><b>Method Ref Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROC_MAP__METHOD_REF_NAME = eINSTANCE.getProcMap_MethodRefName();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskMapImpl <em>Task Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskMapImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getTaskMap()
		 * @generated
		 */
		EClass TASK_MAP = eINSTANCE.getTaskMap();

		/**
		 * The meta object literal for the '<em><b>Mode Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_MAP__MODE_REF = eINSTANCE.getTaskMap_ModeRef();

		/**
		 * The meta object literal for the '<em><b>Rtos Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_MAP__RTOS_REF = eINSTANCE.getTaskMap_RtosRef();

		/**
		 * The meta object literal for the '<em><b>Task Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_MAP__TASK_REF = eINSTANCE.getTaskMap_TaskRef();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.VarMapImpl <em>Var Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.VarMapImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getVarMap()
		 * @generated
		 */
		EClass VAR_MAP = eINSTANCE.getVarMap();

		/**
		 * The meta object literal for the '<em><b>Bus Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR_MAP__BUS_REF = eINSTANCE.getVarMap_BusRef();

		/**
		 * The meta object literal for the '<em><b>Frame Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR_MAP__FRAME_REF = eINSTANCE.getVarMap_FrameRef();

		/**
		 * The meta object literal for the '<em><b>Mode Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR_MAP__MODE_REF = eINSTANCE.getVarMap_ModeRef();

		/**
		 * The meta object literal for the '<em><b>Mutex Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR_MAP__MUTEX_REF = eINSTANCE.getVarMap_MutexRef();

		/**
		 * The meta object literal for the '<em><b>Var Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR_MAP__VAR_REF = eINSTANCE.getVarMap_VarRef();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SchedulingScenarioImpl <em>Scheduling Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.SchedulingScenarioImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getSchedulingScenario()
		 * @generated
		 */
		EClass SCHEDULING_SCENARIO = eINSTANCE.getSchedulingScenario();

		/**
		 * The meta object literal for the '<em><b>Cpu Sched List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULING_SCENARIO__CPU_SCHED_LIST = eINSTANCE.getSchedulingScenario_CpuSchedList();

		/**
		 * The meta object literal for the '<em><b>Mode Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULING_SCENARIO__MODE_REF = eINSTANCE.getSchedulingScenario_ModeRef();

		/**
		 * The meta object literal for the '<em><b>Reports</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULING_SCENARIO__REPORTS = eINSTANCE.getSchedulingScenario_Reports();

		/**
		 * The meta object literal for the '<em><b>Task Sched List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULING_SCENARIO__TASK_SCHED_LIST = eINSTANCE.getSchedulingScenario_TaskSchedList();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CpuSchedImpl <em>Cpu Sched</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.CpuSchedImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getCpuSched()
		 * @generated
		 */
		EClass CPU_SCHED = eINSTANCE.getCpuSched();

		/**
		 * The meta object literal for the '<em><b>Boundary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPU_SCHED__BOUNDARY = eINSTANCE.getCpuSched_Boundary();

		/**
		 * The meta object literal for the '<em><b>Cpu Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPU_SCHED__CPU_REF = eINSTANCE.getCpuSched_CpuRef();

		/**
		 * The meta object literal for the '<em><b>Schedulable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPU_SCHED__SCHEDULABLE = eINSTANCE.getCpuSched_Schedulable();

		/**
		 * The meta object literal for the '<em><b>Speed Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPU_SCHED__SPEED_FACTOR = eINSTANCE.getCpuSched_SpeedFactor();

		/**
		 * The meta object literal for the '<em><b>Utilization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPU_SCHED__UTILIZATION = eINSTANCE.getCpuSched_Utilization();

		/**
		 * The meta object literal for the '<em><b>Max Stack Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPU_SCHED__MAX_STACK_SIZE = eINSTANCE.getCpuSched_MaxStackSize();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskSchedImpl <em>Task Sched</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.TaskSchedImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getTaskSched()
		 * @generated
		 */
		EClass TASK_SCHED = eINSTANCE.getTaskSched();

		/**
		 * The meta object literal for the '<em><b>CDelta</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_SCHED__CDELTA = eINSTANCE.getTaskSched_CDelta();

		/**
		 * The meta object literal for the '<em><b>Response Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_SCHED__RESPONSE_TIME = eINSTANCE.getTaskSched_ResponseTime();

		/**
		 * The meta object literal for the '<em><b>Schedulable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_SCHED__SCHEDULABLE = eINSTANCE.getTaskSched_Schedulable();

		/**
		 * The meta object literal for the '<em><b>Task Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_SCHED__TASK_REF = eINSTANCE.getTaskSched_TaskRef();

		/**
		 * The meta object literal for the '<em><b>TDelta</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_SCHED__TDELTA = eINSTANCE.getTaskSched_TDelta();

		/**
		 * The meta object literal for the '<em><b>Utilization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_SCHED__UTILIZATION = eINSTANCE.getTaskSched_Utilization();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CacheMissCostListImpl <em>Cache Miss Cost List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.CacheMissCostListImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getCacheMissCostList()
		 * @generated
		 */
		EClass CACHE_MISS_COST_LIST = eINSTANCE.getCacheMissCostList();

		/**
		 * The meta object literal for the '<em><b>Cache Miss Cost Items List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CACHE_MISS_COST_LIST__CACHE_MISS_COST_ITEMS_LIST = eINSTANCE.getCacheMissCostList_CacheMissCostItemsList();

		/**
		 * The meta object literal for the '<em><b>Mode Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CACHE_MISS_COST_LIST__MODE_REF = eINSTANCE.getCacheMissCostList_ModeRef();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.CacheMissCostImpl <em>Cache Miss Cost</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.CacheMissCostImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getCacheMissCost()
		 * @generated
		 */
		EClass CACHE_MISS_COST = eINSTANCE.getCacheMissCost();

		/**
		 * The meta object literal for the '<em><b>Best</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CACHE_MISS_COST__BEST = eINSTANCE.getCacheMissCost_Best();

		/**
		 * The meta object literal for the '<em><b>Distribution</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CACHE_MISS_COST__DISTRIBUTION = eINSTANCE.getCacheMissCost_Distribution();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CACHE_MISS_COST__REF = eINSTANCE.getCacheMissCost_Ref();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CACHE_MISS_COST__TYPE = eINSTANCE.getCacheMissCost_Type();

		/**
		 * The meta object literal for the '<em><b>Worst</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CACHE_MISS_COST__WORST = eINSTANCE.getCacheMissCost_Worst();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.FieldImpl <em>Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.FieldImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getField()
		 * @generated
		 */
		EClass FIELD = eINSTANCE.getField();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD__NAME = eINSTANCE.getField_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD__TYPE = eINSTANCE.getField_Type();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD__SIZE = eINSTANCE.getField_Size();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.TypeImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__NAME = eINSTANCE.getType_Name();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE__FIELD = eINSTANCE.getType_Field();

		/**
		 * The meta object literal for the '<em><b>Dim</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__DIM = eINSTANCE.getType_Dim();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.OsApplicationImpl <em>Os Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.OsApplicationImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getOsApplication()
		 * @generated
		 */
		EClass OS_APPLICATION = eINSTANCE.getOsApplication();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OS_APPLICATION__NAME = eINSTANCE.getOsApplication_Name();

		/**
		 * The meta object literal for the '<em><b>Oil Var</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OS_APPLICATION__OIL_VAR = eINSTANCE.getOsApplication_OilVar();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ComImpl <em>Com</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ComImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getCom()
		 * @generated
		 */
		EClass COM = eINSTANCE.getCom();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COM__NAME = eINSTANCE.getCom_Name();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.SpinLockImpl <em>Spin Lock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.SpinLockImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getSpinLock()
		 * @generated
		 */
		EClass SPIN_LOCK = eINSTANCE.getSpinLock();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPIN_LOCK__NAME = eINSTANCE.getSpinLock_Name();

		/**
		 * The meta object literal for the '{@link com.eu.evidence.rtdruid.internal.vartree.data.impl.ScheduleTableImpl <em>Scheduling Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.ScheduleTableImpl
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getScheduleTable()
		 * @generated
		 */
		EClass SCHEDULE_TABLE = eINSTANCE.getScheduleTable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULE_TABLE__NAME = eINSTANCE.getScheduleTable_Name();

		/**
		 * The meta object literal for the '<em>Boolean Var</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.vartree.variables.BooleanVar
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getBooleanVar()
		 * @generated
		 */
		EDataType BOOLEAN_VAR = eINSTANCE.getBooleanVar();

		/**
		 * The meta object literal for the '<em>Double Var</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.vartree.variables.DoubleVar
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getDoubleVar()
		 * @generated
		 */
		EDataType DOUBLE_VAR = eINSTANCE.getDoubleVar();

		/**
		 * The meta object literal for the '<em>Float Var</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.vartree.variables.FloatVar
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getFloatVar()
		 * @generated
		 */
		EDataType FLOAT_VAR = eINSTANCE.getFloatVar();

		/**
		 * The meta object literal for the '<em>Integer Var</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.vartree.variables.IntegerVar
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getIntegerVar()
		 * @generated
		 */
		EDataType INTEGER_VAR = eINSTANCE.getIntegerVar();

		/**
		 * The meta object literal for the '<em>Long Var</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.vartree.variables.LongVar
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getLongVar()
		 * @generated
		 */
		EDataType LONG_VAR = eINSTANCE.getLongVar();

		/**
		 * The meta object literal for the '<em>Oil Var</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.vartree.variables.OilVar
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getOilVar()
		 * @generated
		 */
		EDataType OIL_VAR = eINSTANCE.getOilVar();

		/**
		 * The meta object literal for the '<em>String Var</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.vartree.variables.StringVar
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getStringVar()
		 * @generated
		 */
		EDataType STRING_VAR = eINSTANCE.getStringVar();

		/**
		 * The meta object literal for the '<em>Time Var</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.vartree.variables.TimeVar
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getTimeVar()
		 * @generated
		 */
		EDataType TIME_VAR = eINSTANCE.getTimeVar();

		/**
		 * The meta object literal for the '<em>Property Var</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.eu.evidence.rtdruid.vartree.variables.PropertyVar
		 * @see com.eu.evidence.rtdruid.internal.vartree.data.impl.DataPackageImpl#getPropertyVar()
		 * @generated
		 */
		EDataType PROPERTY_VAR = eINSTANCE.getPropertyVar();

	}

} //DataPackage
