/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import com.eu.evidence.rtdruid.vartree.data.Activation;
import com.eu.evidence.rtdruid.vartree.data.Annotation;
import com.eu.evidence.rtdruid.vartree.data.Architectural;
import com.eu.evidence.rtdruid.vartree.data.Bus;
import com.eu.evidence.rtdruid.vartree.data.CacheMissCost;
import com.eu.evidence.rtdruid.vartree.data.CacheMissCostList;
import com.eu.evidence.rtdruid.vartree.data.Com;
import com.eu.evidence.rtdruid.vartree.data.Cpu;
import com.eu.evidence.rtdruid.vartree.data.CpuSched;
import com.eu.evidence.rtdruid.vartree.data.DataFactory;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.Distribution;
import com.eu.evidence.rtdruid.vartree.data.Ecu;
import com.eu.evidence.rtdruid.vartree.data.Event;
import com.eu.evidence.rtdruid.vartree.data.ExecTime;
import com.eu.evidence.rtdruid.vartree.data.ExecTimeList;
import com.eu.evidence.rtdruid.vartree.data.Field;
import com.eu.evidence.rtdruid.vartree.data.Frame;
import com.eu.evidence.rtdruid.vartree.data.Functional;
import com.eu.evidence.rtdruid.vartree.data.Implementation;
import com.eu.evidence.rtdruid.vartree.data.Mapping;
import com.eu.evidence.rtdruid.vartree.data.MethodRef;
import com.eu.evidence.rtdruid.vartree.data.Mode;
import com.eu.evidence.rtdruid.vartree.data.Modes;
import com.eu.evidence.rtdruid.vartree.data.Mutex;
import com.eu.evidence.rtdruid.vartree.data.MutexRef;
import com.eu.evidence.rtdruid.vartree.data.ObjectWithID;
import com.eu.evidence.rtdruid.vartree.data.Order;
import com.eu.evidence.rtdruid.vartree.data.OsApplication;
import com.eu.evidence.rtdruid.vartree.data.PartialOrder;
import com.eu.evidence.rtdruid.vartree.data.Proc;
import com.eu.evidence.rtdruid.vartree.data.ProcMap;
import com.eu.evidence.rtdruid.vartree.data.ProvidedInterface;
import com.eu.evidence.rtdruid.vartree.data.RequiredInterface;
import com.eu.evidence.rtdruid.vartree.data.Resource;
import com.eu.evidence.rtdruid.vartree.data.ResourceRef;
import com.eu.evidence.rtdruid.vartree.data.Rtos;
import com.eu.evidence.rtdruid.vartree.data.Sample;
import com.eu.evidence.rtdruid.vartree.data.Schedulability;
import com.eu.evidence.rtdruid.vartree.data.Scheduling;
import com.eu.evidence.rtdruid.vartree.data.SchedulingScenario;
import com.eu.evidence.rtdruid.vartree.data.ScheduleTable;
import com.eu.evidence.rtdruid.vartree.data.Signal;
import com.eu.evidence.rtdruid.vartree.data.SpinLock;
import com.eu.evidence.rtdruid.vartree.data.SubSystem;
import com.eu.evidence.rtdruid.vartree.data.SystemImplementation;
import com.eu.evidence.rtdruid.vartree.data.Task;
import com.eu.evidence.rtdruid.vartree.data.TaskMap;
import com.eu.evidence.rtdruid.vartree.data.TaskSched;
import com.eu.evidence.rtdruid.vartree.data.TimeConst;
import com.eu.evidence.rtdruid.vartree.data.TimeConstElement;
import com.eu.evidence.rtdruid.vartree.data.Trigger;
import com.eu.evidence.rtdruid.vartree.data.Type;
import com.eu.evidence.rtdruid.vartree.data.Var;
import com.eu.evidence.rtdruid.vartree.data.VarMap;

import com.eu.evidence.rtdruid.vartree.variables.BooleanVar;
import com.eu.evidence.rtdruid.vartree.variables.DoubleVar;
import com.eu.evidence.rtdruid.vartree.variables.FloatVar;
import com.eu.evidence.rtdruid.vartree.variables.IntegerVar;
import com.eu.evidence.rtdruid.vartree.variables.LongVar;
import com.eu.evidence.rtdruid.vartree.variables.OilVar;
import com.eu.evidence.rtdruid.vartree.variables.PropertyVar;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;
import com.eu.evidence.rtdruid.vartree.variables.TimeVar;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataPackageImpl extends EPackageImpl implements DataPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectWithIDEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass procEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architecturalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulabilityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass varEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass triggerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partialOrderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeConstEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass providedInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requiredInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeConstElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ecuEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass busEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass frameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass signalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mutexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpuEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rtosEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mutexRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass execTimeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass execTimeListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass distributionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sampleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass procMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass varMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulingScenarioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpuSchedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskSchedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cacheMissCostListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cacheMissCostEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass osApplicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass comEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spinLockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulingTableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType booleanVarEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType doubleVarEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType floatVarEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType integerVarEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType longVarEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType oilVarEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stringVarEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType timeVarEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType propertyVarEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DataPackageImpl() {
		super(eNS_URI, DataFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link DataPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DataPackage init() {
		if (isInited) return (DataPackage)EPackage.Registry.INSTANCE.getEPackage(DataPackage.eNS_URI);

		// Obtain or create and register package
		DataPackageImpl theDataPackage = (DataPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DataPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DataPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theDataPackage.createPackageContents();

		// Initialize created meta-data
		theDataPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDataPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DataPackage.eNS_URI, theDataPackage);
		return theDataPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystem() {
		return systemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Annotation() {
		return (EReference)systemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Architectural() {
		return (EReference)systemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Functional() {
		return (EReference)systemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Mapping() {
		return (EReference)systemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Modes() {
		return (EReference)systemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystem_Name() {
		return (EAttribute)systemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Schedulability() {
		return (EReference)systemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystem_XTC_Cookie() {
		return (EAttribute)systemEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectWithID() {
		return objectWithIDEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectWithID_Properties() {
		return (EAttribute)objectWithIDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModes() {
		return modesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModes_ModeList() {
		return (EReference)modesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMode() {
		return modeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMode_Name() {
		return (EAttribute)modeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctional() {
		return functionalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctional_EventList() {
		return (EReference)functionalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctional_PartialOrderList() {
		return (EReference)functionalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctional_Implementation() {
		return (EReference)functionalEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctional_TimeConstList() {
		return (EReference)functionalEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctional_TypeList() {
		return (EReference)functionalEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplementation() {
		return implementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProc() {
		return procEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProc_MethodRefList() {
		return (EReference)procEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProc_Methods() {
		return (EAttribute)procEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitectural() {
		return architecturalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectural_BusList() {
		return (EReference)architecturalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectural_EcuList() {
		return (EReference)architecturalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectural_FrameList() {
		return (EReference)architecturalEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectural_MutexList() {
		return (EReference)architecturalEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectural_ResourceList() {
		return (EReference)architecturalEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectural_SignalList() {
		return (EReference)architecturalEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectural_TaskList() {
		return (EReference)architecturalEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectural_ComList() {
		return (EReference)architecturalEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectural_SpinLockList() {
		return (EReference)architecturalEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitectural_ScheduleTableList() {
		return (EReference)architecturalEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapping() {
		return mappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_ProcMapList() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_TaskMapList() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_VarMapList() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotation() {
		return annotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotation_ExecTimeLists() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotation_CacheMissCostLists() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulability() {
		return schedulabilityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulability_SchedulingScenarioList() {
		return (EReference)schedulabilityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVar() {
		return varEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVar_Methods() {
		return (EAttribute)varEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVar_Type() {
		return (EAttribute)varEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrigger() {
		return triggerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrigger_MethodRefList() {
		return (EReference)triggerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvent() {
		return eventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_Name() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_MethodRefName() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_Type() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartialOrder() {
		return partialOrderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPartialOrder_ModeRef() {
		return (EAttribute)partialOrderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartialOrder_OrderList() {
		return (EReference)partialOrderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemImplementation() {
		return systemImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemImplementation_Name() {
		return (EAttribute)systemImplementationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubSystem() {
		return subSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubSystem_Implementation() {
		return (EReference)subSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubSystem_ProvidedInterfaceList() {
		return (EReference)subSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubSystem_RequiredInterfaceList() {
		return (EReference)subSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeConst() {
		return timeConstEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeConst_ModeRef() {
		return (EAttribute)timeConstEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimeConst_TimeConstElementList() {
		return (EReference)timeConstEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethodRef() {
		return methodRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethodRef_Name() {
		return (EAttribute)methodRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethodRef_MethodName() {
		return (EAttribute)methodRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProvidedInterface() {
		return providedInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProvidedInterface_LocalMethodRef() {
		return (EAttribute)providedInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProvidedInterface_LocalObjectRef() {
		return (EAttribute)providedInterfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProvidedInterface_Name() {
		return (EAttribute)providedInterfaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequiredInterface() {
		return requiredInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequiredInterface_ExternalMethodRef() {
		return (EAttribute)requiredInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequiredInterface_Name() {
		return (EAttribute)requiredInterfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrder() {
		return orderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrder_FirstEvent() {
		return (EAttribute)orderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrder_SecondEvent() {
		return (EAttribute)orderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeConstElement() {
		return timeConstElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeConstElement_BoundType() {
		return (EAttribute)timeConstElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeConstElement_BoundValue() {
		return (EAttribute)timeConstElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeConstElement_FirstEvent() {
		return (EAttribute)timeConstElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeConstElement_SecondEvent() {
		return (EAttribute)timeConstElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEcu() {
		return ecuEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEcu_CpuList() {
		return (EReference)ecuEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEcu_Name() {
		return (EAttribute)ecuEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTask() {
		return taskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTask_ActivationList() {
		return (EReference)taskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_Name() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_OilVar() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTask_ResourceRefList() {
		return (EReference)taskEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTask_SchedulingList() {
		return (EReference)taskEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTask_Type() {
		return (EAttribute)taskEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResource() {
		return resourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResource_Methods() {
		return (EAttribute)resourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResource_MutexRefList() {
		return (EReference)resourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResource_Name() {
		return (EAttribute)resourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBus() {
		return busEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBus_Name() {
		return (EAttribute)busEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBus_Speed() {
		return (EAttribute)busEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBus_Type() {
		return (EAttribute)busEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFrame() {
		return frameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFrame_ActivationClass() {
		return (EAttribute)frameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFrame_ActivationRate() {
		return (EAttribute)frameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFrame_ActivationType() {
		return (EAttribute)frameEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFrame_Id() {
		return (EAttribute)frameEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFrame_Length() {
		return (EAttribute)frameEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFrame_Name() {
		return (EAttribute)frameEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFrame_MessageType() {
		return (EAttribute)frameEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSignal() {
		return signalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSignal_Name() {
		return (EAttribute)signalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSignal_OilVar() {
		return (EAttribute)signalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSignal_Type() {
		return (EAttribute)signalEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMutex() {
		return mutexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMutex_Name() {
		return (EAttribute)mutexEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMutex_OilVar() {
		return (EAttribute)mutexEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMutex_Policy() {
		return (EAttribute)mutexEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCpu() {
		return cpuEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCpu_Name() {
		return (EAttribute)cpuEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCpu_Model() {
		return (EAttribute)cpuEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCpu_Rtos() {
		return (EReference)cpuEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCpu_OsApplication() {
		return (EReference)cpuEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCpu_Speed() {
		return (EAttribute)cpuEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCpu_Speed_Unit() {
		return (EAttribute)cpuEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCpu_BinaryImage() {
		return (EAttribute)cpuEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRtos() {
		return rtosEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRtos_Name() {
		return (EAttribute)rtosEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRtos_OilVar() {
		return (EAttribute)rtosEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRtos_Type() {
		return (EAttribute)rtosEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRtos_Methods() {
		return (EAttribute)rtosEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScheduling() {
		return schedulingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScheduling_ModeRef() {
		return (EAttribute)schedulingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScheduling_PreemptionGroupName() {
		return (EAttribute)schedulingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScheduling_Priority() {
		return (EAttribute)schedulingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScheduling_Threshold() {
		return (EAttribute)schedulingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScheduling_Stack() {
		return (EAttribute)schedulingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivation() {
		return activationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivation_ActNumber() {
		return (EAttribute)activationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivation_ActivationClass() {
		return (EAttribute)activationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivation_Deadline() {
		return (EAttribute)activationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivation_ModeRef() {
		return (EAttribute)activationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivation_Offset() {
		return (EAttribute)activationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivation_Period() {
		return (EAttribute)activationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivation_Type() {
		return (EAttribute)activationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceRef() {
		return resourceRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceRef_ModeRef() {
		return (EAttribute)resourceRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceRef_ResourceMethodRef() {
		return (EAttribute)resourceRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMutexRef() {
		return mutexRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMutexRef_ModeRef() {
		return (EAttribute)mutexRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMutexRef_MutexName() {
		return (EAttribute)mutexRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecTime() {
		return execTimeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecTime_Best() {
		return (EAttribute)execTimeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecTime_Distribution() {
		return (EReference)execTimeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecTime_Ref() {
		return (EAttribute)execTimeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecTime_Type() {
		return (EAttribute)execTimeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecTime_Worst() {
		return (EAttribute)execTimeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecTimeList() {
		return execTimeListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecTimeList_ExecTimeItemsList() {
		return (EReference)execTimeListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecTimeList_ModeRef() {
		return (EAttribute)execTimeListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDistribution() {
		return distributionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDistribution_Avg() {
		return (EAttribute)distributionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDistribution_SampleList() {
		return (EReference)distributionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDistribution_Type() {
		return (EAttribute)distributionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDistribution_Variance() {
		return (EAttribute)distributionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSample() {
		return sampleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSample_Probability() {
		return (EAttribute)sampleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSample_Value() {
		return (EAttribute)sampleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcMap() {
		return procMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcMap_ModeRef() {
		return (EAttribute)procMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcMap_Order() {
		return (EAttribute)procMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcMap_ProcRef() {
		return (EAttribute)procMapEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcMap_TaskRef() {
		return (EAttribute)procMapEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcMap_OnceEveryK() {
		return (EAttribute)procMapEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcMap_MethodRefName() {
		return (EAttribute)procMapEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskMap() {
		return taskMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskMap_ModeRef() {
		return (EAttribute)taskMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskMap_RtosRef() {
		return (EAttribute)taskMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskMap_TaskRef() {
		return (EAttribute)taskMapEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVarMap() {
		return varMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVarMap_BusRef() {
		return (EAttribute)varMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVarMap_FrameRef() {
		return (EAttribute)varMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVarMap_ModeRef() {
		return (EAttribute)varMapEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVarMap_MutexRef() {
		return (EAttribute)varMapEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVarMap_VarRef() {
		return (EAttribute)varMapEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulingScenario() {
		return schedulingScenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulingScenario_CpuSchedList() {
		return (EReference)schedulingScenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchedulingScenario_ModeRef() {
		return (EAttribute)schedulingScenarioEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchedulingScenario_Reports() {
		return (EAttribute)schedulingScenarioEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulingScenario_TaskSchedList() {
		return (EReference)schedulingScenarioEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCpuSched() {
		return cpuSchedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCpuSched_Boundary() {
		return (EAttribute)cpuSchedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCpuSched_CpuRef() {
		return (EAttribute)cpuSchedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCpuSched_Schedulable() {
		return (EAttribute)cpuSchedEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCpuSched_SpeedFactor() {
		return (EAttribute)cpuSchedEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCpuSched_Utilization() {
		return (EAttribute)cpuSchedEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCpuSched_MaxStackSize() {
		return (EAttribute)cpuSchedEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskSched() {
		return taskSchedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskSched_CDelta() {
		return (EAttribute)taskSchedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskSched_ResponseTime() {
		return (EAttribute)taskSchedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskSched_Schedulable() {
		return (EAttribute)taskSchedEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskSched_TaskRef() {
		return (EAttribute)taskSchedEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskSched_TDelta() {
		return (EAttribute)taskSchedEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaskSched_Utilization() {
		return (EAttribute)taskSchedEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCacheMissCostList() {
		return cacheMissCostListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCacheMissCostList_CacheMissCostItemsList() {
		return (EReference)cacheMissCostListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMissCostList_ModeRef() {
		return (EAttribute)cacheMissCostListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCacheMissCost() {
		return cacheMissCostEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMissCost_Best() {
		return (EAttribute)cacheMissCostEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCacheMissCost_Distribution() {
		return (EReference)cacheMissCostEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMissCost_Ref() {
		return (EAttribute)cacheMissCostEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMissCost_Type() {
		return (EAttribute)cacheMissCostEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheMissCost_Worst() {
		return (EAttribute)cacheMissCostEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getField() {
		return fieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getField_Name() {
		return (EAttribute)fieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getField_Type() {
		return (EAttribute)fieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getField_Size() {
		return (EAttribute)fieldEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_Name() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getType_Field() {
		return (EReference)typeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_Dim() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOsApplication() {
		return osApplicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOsApplication_Name() {
		return (EAttribute)osApplicationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOsApplication_OilVar() {
		return (EAttribute)osApplicationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCom() {
		return comEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCom_Name() {
		return (EAttribute)comEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpinLock() {
		return spinLockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpinLock_Name() {
		return (EAttribute)spinLockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScheduleTable() {
		return schedulingTableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScheduleTable_Name() {
		return (EAttribute)schedulingTableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getBooleanVar() {
		return booleanVarEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDoubleVar() {
		return doubleVarEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFloatVar() {
		return floatVarEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIntegerVar() {
		return integerVarEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLongVar() {
		return longVarEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getOilVar() {
		return oilVarEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getStringVar() {
		return stringVarEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTimeVar() {
		return timeVarEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPropertyVar() {
		return propertyVarEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFactory getDataFactory() {
		return (DataFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		systemEClass = createEClass(SYSTEM);
		createEReference(systemEClass, SYSTEM__ANNOTATION);
		createEReference(systemEClass, SYSTEM__ARCHITECTURAL);
		createEReference(systemEClass, SYSTEM__FUNCTIONAL);
		createEReference(systemEClass, SYSTEM__MAPPING);
		createEReference(systemEClass, SYSTEM__MODES);
		createEAttribute(systemEClass, SYSTEM__NAME);
		createEReference(systemEClass, SYSTEM__SCHEDULABILITY);
		createEAttribute(systemEClass, SYSTEM__XTC_COOKIE);

		objectWithIDEClass = createEClass(OBJECT_WITH_ID);
		createEAttribute(objectWithIDEClass, OBJECT_WITH_ID__PROPERTIES);

		modesEClass = createEClass(MODES);
		createEReference(modesEClass, MODES__MODE_LIST);

		modeEClass = createEClass(MODE);
		createEAttribute(modeEClass, MODE__NAME);

		functionalEClass = createEClass(FUNCTIONAL);
		createEReference(functionalEClass, FUNCTIONAL__EVENT_LIST);
		createEReference(functionalEClass, FUNCTIONAL__PARTIAL_ORDER_LIST);
		createEReference(functionalEClass, FUNCTIONAL__IMPLEMENTATION);
		createEReference(functionalEClass, FUNCTIONAL__TIME_CONST_LIST);
		createEReference(functionalEClass, FUNCTIONAL__TYPE_LIST);

		implementationEClass = createEClass(IMPLEMENTATION);

		procEClass = createEClass(PROC);
		createEReference(procEClass, PROC__METHOD_REF_LIST);
		createEAttribute(procEClass, PROC__METHODS);

		architecturalEClass = createEClass(ARCHITECTURAL);
		createEReference(architecturalEClass, ARCHITECTURAL__BUS_LIST);
		createEReference(architecturalEClass, ARCHITECTURAL__ECU_LIST);
		createEReference(architecturalEClass, ARCHITECTURAL__FRAME_LIST);
		createEReference(architecturalEClass, ARCHITECTURAL__MUTEX_LIST);
		createEReference(architecturalEClass, ARCHITECTURAL__RESOURCE_LIST);
		createEReference(architecturalEClass, ARCHITECTURAL__SIGNAL_LIST);
		createEReference(architecturalEClass, ARCHITECTURAL__TASK_LIST);
		createEReference(architecturalEClass, ARCHITECTURAL__COM_LIST);
		createEReference(architecturalEClass, ARCHITECTURAL__SPIN_LOCK_LIST);
		createEReference(architecturalEClass, ARCHITECTURAL__SCHEDULE_TABLE_LIST);

		mappingEClass = createEClass(MAPPING);
		createEReference(mappingEClass, MAPPING__PROC_MAP_LIST);
		createEReference(mappingEClass, MAPPING__TASK_MAP_LIST);
		createEReference(mappingEClass, MAPPING__VAR_MAP_LIST);

		annotationEClass = createEClass(ANNOTATION);
		createEReference(annotationEClass, ANNOTATION__EXEC_TIME_LISTS);
		createEReference(annotationEClass, ANNOTATION__CACHE_MISS_COST_LISTS);

		schedulabilityEClass = createEClass(SCHEDULABILITY);
		createEReference(schedulabilityEClass, SCHEDULABILITY__SCHEDULING_SCENARIO_LIST);

		varEClass = createEClass(VAR);
		createEAttribute(varEClass, VAR__METHODS);
		createEAttribute(varEClass, VAR__TYPE);

		triggerEClass = createEClass(TRIGGER);
		createEReference(triggerEClass, TRIGGER__METHOD_REF_LIST);

		eventEClass = createEClass(EVENT);
		createEAttribute(eventEClass, EVENT__NAME);
		createEAttribute(eventEClass, EVENT__METHOD_REF_NAME);
		createEAttribute(eventEClass, EVENT__TYPE);

		partialOrderEClass = createEClass(PARTIAL_ORDER);
		createEAttribute(partialOrderEClass, PARTIAL_ORDER__MODE_REF);
		createEReference(partialOrderEClass, PARTIAL_ORDER__ORDER_LIST);

		systemImplementationEClass = createEClass(SYSTEM_IMPLEMENTATION);
		createEAttribute(systemImplementationEClass, SYSTEM_IMPLEMENTATION__NAME);

		subSystemEClass = createEClass(SUB_SYSTEM);
		createEReference(subSystemEClass, SUB_SYSTEM__IMPLEMENTATION);
		createEReference(subSystemEClass, SUB_SYSTEM__PROVIDED_INTERFACE_LIST);
		createEReference(subSystemEClass, SUB_SYSTEM__REQUIRED_INTERFACE_LIST);

		timeConstEClass = createEClass(TIME_CONST);
		createEAttribute(timeConstEClass, TIME_CONST__MODE_REF);
		createEReference(timeConstEClass, TIME_CONST__TIME_CONST_ELEMENT_LIST);

		methodRefEClass = createEClass(METHOD_REF);
		createEAttribute(methodRefEClass, METHOD_REF__NAME);
		createEAttribute(methodRefEClass, METHOD_REF__METHOD_NAME);

		providedInterfaceEClass = createEClass(PROVIDED_INTERFACE);
		createEAttribute(providedInterfaceEClass, PROVIDED_INTERFACE__LOCAL_METHOD_REF);
		createEAttribute(providedInterfaceEClass, PROVIDED_INTERFACE__LOCAL_OBJECT_REF);
		createEAttribute(providedInterfaceEClass, PROVIDED_INTERFACE__NAME);

		requiredInterfaceEClass = createEClass(REQUIRED_INTERFACE);
		createEAttribute(requiredInterfaceEClass, REQUIRED_INTERFACE__EXTERNAL_METHOD_REF);
		createEAttribute(requiredInterfaceEClass, REQUIRED_INTERFACE__NAME);

		orderEClass = createEClass(ORDER);
		createEAttribute(orderEClass, ORDER__FIRST_EVENT);
		createEAttribute(orderEClass, ORDER__SECOND_EVENT);

		timeConstElementEClass = createEClass(TIME_CONST_ELEMENT);
		createEAttribute(timeConstElementEClass, TIME_CONST_ELEMENT__BOUND_TYPE);
		createEAttribute(timeConstElementEClass, TIME_CONST_ELEMENT__BOUND_VALUE);
		createEAttribute(timeConstElementEClass, TIME_CONST_ELEMENT__FIRST_EVENT);
		createEAttribute(timeConstElementEClass, TIME_CONST_ELEMENT__SECOND_EVENT);

		ecuEClass = createEClass(ECU);
		createEReference(ecuEClass, ECU__CPU_LIST);
		createEAttribute(ecuEClass, ECU__NAME);

		taskEClass = createEClass(TASK);
		createEReference(taskEClass, TASK__ACTIVATION_LIST);
		createEAttribute(taskEClass, TASK__NAME);
		createEAttribute(taskEClass, TASK__OIL_VAR);
		createEReference(taskEClass, TASK__RESOURCE_REF_LIST);
		createEReference(taskEClass, TASK__SCHEDULING_LIST);
		createEAttribute(taskEClass, TASK__TYPE);

		resourceEClass = createEClass(RESOURCE);
		createEAttribute(resourceEClass, RESOURCE__METHODS);
		createEReference(resourceEClass, RESOURCE__MUTEX_REF_LIST);
		createEAttribute(resourceEClass, RESOURCE__NAME);

		busEClass = createEClass(BUS);
		createEAttribute(busEClass, BUS__NAME);
		createEAttribute(busEClass, BUS__SPEED);
		createEAttribute(busEClass, BUS__TYPE);

		frameEClass = createEClass(FRAME);
		createEAttribute(frameEClass, FRAME__ACTIVATION_CLASS);
		createEAttribute(frameEClass, FRAME__ACTIVATION_RATE);
		createEAttribute(frameEClass, FRAME__ACTIVATION_TYPE);
		createEAttribute(frameEClass, FRAME__ID);
		createEAttribute(frameEClass, FRAME__LENGTH);
		createEAttribute(frameEClass, FRAME__NAME);
		createEAttribute(frameEClass, FRAME__MESSAGE_TYPE);

		signalEClass = createEClass(SIGNAL);
		createEAttribute(signalEClass, SIGNAL__NAME);
		createEAttribute(signalEClass, SIGNAL__OIL_VAR);
		createEAttribute(signalEClass, SIGNAL__TYPE);

		mutexEClass = createEClass(MUTEX);
		createEAttribute(mutexEClass, MUTEX__NAME);
		createEAttribute(mutexEClass, MUTEX__OIL_VAR);
		createEAttribute(mutexEClass, MUTEX__POLICY);

		cpuEClass = createEClass(CPU);
		createEAttribute(cpuEClass, CPU__NAME);
		createEAttribute(cpuEClass, CPU__MODEL);
		createEReference(cpuEClass, CPU__RTOS);
		createEReference(cpuEClass, CPU__OS_APPLICATION);
		createEAttribute(cpuEClass, CPU__SPEED);
		createEAttribute(cpuEClass, CPU__SPEED_UNIT);
		createEAttribute(cpuEClass, CPU__BINARY_IMAGE);

		rtosEClass = createEClass(RTOS);
		createEAttribute(rtosEClass, RTOS__NAME);
		createEAttribute(rtosEClass, RTOS__OIL_VAR);
		createEAttribute(rtosEClass, RTOS__TYPE);
		createEAttribute(rtosEClass, RTOS__METHODS);

		schedulingEClass = createEClass(SCHEDULING);
		createEAttribute(schedulingEClass, SCHEDULING__MODE_REF);
		createEAttribute(schedulingEClass, SCHEDULING__PREEMPTION_GROUP_NAME);
		createEAttribute(schedulingEClass, SCHEDULING__PRIORITY);
		createEAttribute(schedulingEClass, SCHEDULING__THRESHOLD);
		createEAttribute(schedulingEClass, SCHEDULING__STACK);

		activationEClass = createEClass(ACTIVATION);
		createEAttribute(activationEClass, ACTIVATION__ACT_NUMBER);
		createEAttribute(activationEClass, ACTIVATION__ACTIVATION_CLASS);
		createEAttribute(activationEClass, ACTIVATION__DEADLINE);
		createEAttribute(activationEClass, ACTIVATION__MODE_REF);
		createEAttribute(activationEClass, ACTIVATION__OFFSET);
		createEAttribute(activationEClass, ACTIVATION__PERIOD);
		createEAttribute(activationEClass, ACTIVATION__TYPE);

		resourceRefEClass = createEClass(RESOURCE_REF);
		createEAttribute(resourceRefEClass, RESOURCE_REF__MODE_REF);
		createEAttribute(resourceRefEClass, RESOURCE_REF__RESOURCE_METHOD_REF);

		mutexRefEClass = createEClass(MUTEX_REF);
		createEAttribute(mutexRefEClass, MUTEX_REF__MODE_REF);
		createEAttribute(mutexRefEClass, MUTEX_REF__MUTEX_NAME);

		execTimeEClass = createEClass(EXEC_TIME);
		createEAttribute(execTimeEClass, EXEC_TIME__BEST);
		createEReference(execTimeEClass, EXEC_TIME__DISTRIBUTION);
		createEAttribute(execTimeEClass, EXEC_TIME__REF);
		createEAttribute(execTimeEClass, EXEC_TIME__TYPE);
		createEAttribute(execTimeEClass, EXEC_TIME__WORST);

		execTimeListEClass = createEClass(EXEC_TIME_LIST);
		createEReference(execTimeListEClass, EXEC_TIME_LIST__EXEC_TIME_ITEMS_LIST);
		createEAttribute(execTimeListEClass, EXEC_TIME_LIST__MODE_REF);

		distributionEClass = createEClass(DISTRIBUTION);
		createEAttribute(distributionEClass, DISTRIBUTION__AVG);
		createEReference(distributionEClass, DISTRIBUTION__SAMPLE_LIST);
		createEAttribute(distributionEClass, DISTRIBUTION__TYPE);
		createEAttribute(distributionEClass, DISTRIBUTION__VARIANCE);

		sampleEClass = createEClass(SAMPLE);
		createEAttribute(sampleEClass, SAMPLE__PROBABILITY);
		createEAttribute(sampleEClass, SAMPLE__VALUE);

		procMapEClass = createEClass(PROC_MAP);
		createEAttribute(procMapEClass, PROC_MAP__MODE_REF);
		createEAttribute(procMapEClass, PROC_MAP__ORDER);
		createEAttribute(procMapEClass, PROC_MAP__PROC_REF);
		createEAttribute(procMapEClass, PROC_MAP__TASK_REF);
		createEAttribute(procMapEClass, PROC_MAP__ONCE_EVERY_K);
		createEAttribute(procMapEClass, PROC_MAP__METHOD_REF_NAME);

		taskMapEClass = createEClass(TASK_MAP);
		createEAttribute(taskMapEClass, TASK_MAP__MODE_REF);
		createEAttribute(taskMapEClass, TASK_MAP__RTOS_REF);
		createEAttribute(taskMapEClass, TASK_MAP__TASK_REF);

		varMapEClass = createEClass(VAR_MAP);
		createEAttribute(varMapEClass, VAR_MAP__BUS_REF);
		createEAttribute(varMapEClass, VAR_MAP__FRAME_REF);
		createEAttribute(varMapEClass, VAR_MAP__MODE_REF);
		createEAttribute(varMapEClass, VAR_MAP__MUTEX_REF);
		createEAttribute(varMapEClass, VAR_MAP__VAR_REF);

		schedulingScenarioEClass = createEClass(SCHEDULING_SCENARIO);
		createEReference(schedulingScenarioEClass, SCHEDULING_SCENARIO__CPU_SCHED_LIST);
		createEAttribute(schedulingScenarioEClass, SCHEDULING_SCENARIO__MODE_REF);
		createEAttribute(schedulingScenarioEClass, SCHEDULING_SCENARIO__REPORTS);
		createEReference(schedulingScenarioEClass, SCHEDULING_SCENARIO__TASK_SCHED_LIST);

		cpuSchedEClass = createEClass(CPU_SCHED);
		createEAttribute(cpuSchedEClass, CPU_SCHED__BOUNDARY);
		createEAttribute(cpuSchedEClass, CPU_SCHED__CPU_REF);
		createEAttribute(cpuSchedEClass, CPU_SCHED__SCHEDULABLE);
		createEAttribute(cpuSchedEClass, CPU_SCHED__SPEED_FACTOR);
		createEAttribute(cpuSchedEClass, CPU_SCHED__UTILIZATION);
		createEAttribute(cpuSchedEClass, CPU_SCHED__MAX_STACK_SIZE);

		taskSchedEClass = createEClass(TASK_SCHED);
		createEAttribute(taskSchedEClass, TASK_SCHED__CDELTA);
		createEAttribute(taskSchedEClass, TASK_SCHED__RESPONSE_TIME);
		createEAttribute(taskSchedEClass, TASK_SCHED__SCHEDULABLE);
		createEAttribute(taskSchedEClass, TASK_SCHED__TASK_REF);
		createEAttribute(taskSchedEClass, TASK_SCHED__TDELTA);
		createEAttribute(taskSchedEClass, TASK_SCHED__UTILIZATION);

		cacheMissCostListEClass = createEClass(CACHE_MISS_COST_LIST);
		createEReference(cacheMissCostListEClass, CACHE_MISS_COST_LIST__CACHE_MISS_COST_ITEMS_LIST);
		createEAttribute(cacheMissCostListEClass, CACHE_MISS_COST_LIST__MODE_REF);

		cacheMissCostEClass = createEClass(CACHE_MISS_COST);
		createEAttribute(cacheMissCostEClass, CACHE_MISS_COST__BEST);
		createEReference(cacheMissCostEClass, CACHE_MISS_COST__DISTRIBUTION);
		createEAttribute(cacheMissCostEClass, CACHE_MISS_COST__REF);
		createEAttribute(cacheMissCostEClass, CACHE_MISS_COST__TYPE);
		createEAttribute(cacheMissCostEClass, CACHE_MISS_COST__WORST);

		fieldEClass = createEClass(FIELD);
		createEAttribute(fieldEClass, FIELD__NAME);
		createEAttribute(fieldEClass, FIELD__TYPE);
		createEAttribute(fieldEClass, FIELD__SIZE);

		typeEClass = createEClass(TYPE);
		createEAttribute(typeEClass, TYPE__NAME);
		createEReference(typeEClass, TYPE__FIELD);
		createEAttribute(typeEClass, TYPE__DIM);

		osApplicationEClass = createEClass(OS_APPLICATION);
		createEAttribute(osApplicationEClass, OS_APPLICATION__NAME);
		createEAttribute(osApplicationEClass, OS_APPLICATION__OIL_VAR);

		comEClass = createEClass(COM);
		createEAttribute(comEClass, COM__NAME);

		spinLockEClass = createEClass(SPIN_LOCK);
		createEAttribute(spinLockEClass, SPIN_LOCK__NAME);

		schedulingTableEClass = createEClass(SCHEDULE_TABLE);
		createEAttribute(schedulingTableEClass, SCHEDULE_TABLE__NAME);

		// Create data types
		booleanVarEDataType = createEDataType(BOOLEAN_VAR);
		doubleVarEDataType = createEDataType(DOUBLE_VAR);
		floatVarEDataType = createEDataType(FLOAT_VAR);
		integerVarEDataType = createEDataType(INTEGER_VAR);
		longVarEDataType = createEDataType(LONG_VAR);
		oilVarEDataType = createEDataType(OIL_VAR);
		stringVarEDataType = createEDataType(STRING_VAR);
		timeVarEDataType = createEDataType(TIME_VAR);
		propertyVarEDataType = createEDataType(PROPERTY_VAR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		systemEClass.getESuperTypes().add(this.getObjectWithID());
		modesEClass.getESuperTypes().add(this.getObjectWithID());
		modeEClass.getESuperTypes().add(this.getObjectWithID());
		functionalEClass.getESuperTypes().add(this.getObjectWithID());
		implementationEClass.getESuperTypes().add(this.getSystemImplementation());
		procEClass.getESuperTypes().add(this.getImplementation());
		architecturalEClass.getESuperTypes().add(this.getObjectWithID());
		mappingEClass.getESuperTypes().add(this.getObjectWithID());
		annotationEClass.getESuperTypes().add(this.getObjectWithID());
		schedulabilityEClass.getESuperTypes().add(this.getObjectWithID());
		varEClass.getESuperTypes().add(this.getImplementation());
		triggerEClass.getESuperTypes().add(this.getSystemImplementation());
		eventEClass.getESuperTypes().add(this.getObjectWithID());
		partialOrderEClass.getESuperTypes().add(this.getObjectWithID());
		systemImplementationEClass.getESuperTypes().add(this.getObjectWithID());
		subSystemEClass.getESuperTypes().add(this.getImplementation());
		timeConstEClass.getESuperTypes().add(this.getObjectWithID());
		methodRefEClass.getESuperTypes().add(this.getObjectWithID());
		providedInterfaceEClass.getESuperTypes().add(this.getObjectWithID());
		requiredInterfaceEClass.getESuperTypes().add(this.getObjectWithID());
		orderEClass.getESuperTypes().add(this.getObjectWithID());
		timeConstElementEClass.getESuperTypes().add(this.getObjectWithID());
		ecuEClass.getESuperTypes().add(this.getObjectWithID());
		taskEClass.getESuperTypes().add(this.getObjectWithID());
		resourceEClass.getESuperTypes().add(this.getObjectWithID());
		busEClass.getESuperTypes().add(this.getObjectWithID());
		frameEClass.getESuperTypes().add(this.getObjectWithID());
		signalEClass.getESuperTypes().add(this.getObjectWithID());
		mutexEClass.getESuperTypes().add(this.getObjectWithID());
		cpuEClass.getESuperTypes().add(this.getObjectWithID());
		rtosEClass.getESuperTypes().add(this.getObjectWithID());
		schedulingEClass.getESuperTypes().add(this.getObjectWithID());
		activationEClass.getESuperTypes().add(this.getObjectWithID());
		resourceRefEClass.getESuperTypes().add(this.getObjectWithID());
		mutexRefEClass.getESuperTypes().add(this.getObjectWithID());
		execTimeEClass.getESuperTypes().add(this.getObjectWithID());
		execTimeListEClass.getESuperTypes().add(this.getObjectWithID());
		distributionEClass.getESuperTypes().add(this.getObjectWithID());
		sampleEClass.getESuperTypes().add(this.getObjectWithID());
		procMapEClass.getESuperTypes().add(this.getObjectWithID());
		taskMapEClass.getESuperTypes().add(this.getObjectWithID());
		varMapEClass.getESuperTypes().add(this.getObjectWithID());
		schedulingScenarioEClass.getESuperTypes().add(this.getObjectWithID());
		cpuSchedEClass.getESuperTypes().add(this.getObjectWithID());
		taskSchedEClass.getESuperTypes().add(this.getObjectWithID());
		cacheMissCostListEClass.getESuperTypes().add(this.getObjectWithID());
		cacheMissCostEClass.getESuperTypes().add(this.getObjectWithID());
		fieldEClass.getESuperTypes().add(this.getObjectWithID());
		typeEClass.getESuperTypes().add(this.getObjectWithID());
		osApplicationEClass.getESuperTypes().add(this.getObjectWithID());
		comEClass.getESuperTypes().add(this.getObjectWithID());
		spinLockEClass.getESuperTypes().add(this.getObjectWithID());
		schedulingTableEClass.getESuperTypes().add(this.getObjectWithID());

		// Initialize classes and features; add operations and parameters
		initEClass(systemEClass, com.eu.evidence.rtdruid.vartree.data.System.class, "System", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystem_Annotation(), this.getAnnotation(), null, "Annotation", null, 0, 1, com.eu.evidence.rtdruid.vartree.data.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Architectural(), this.getArchitectural(), null, "Architectural", null, 0, 1, com.eu.evidence.rtdruid.vartree.data.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Functional(), this.getFunctional(), null, "Functional", null, 0, 1, com.eu.evidence.rtdruid.vartree.data.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Mapping(), this.getMapping(), null, "Mapping", null, 0, 1, com.eu.evidence.rtdruid.vartree.data.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Modes(), this.getModes(), null, "Modes", null, 0, 1, com.eu.evidence.rtdruid.vartree.data.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSystem_Name(), this.getStringVar(), "Name", null, 1, 1, com.eu.evidence.rtdruid.vartree.data.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Schedulability(), this.getSchedulability(), null, "Schedulability", null, 0, 1, com.eu.evidence.rtdruid.vartree.data.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSystem_XTC_Cookie(), this.getStringVar(), "XTC_Cookie", null, 0, -1, com.eu.evidence.rtdruid.vartree.data.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectWithIDEClass, ObjectWithID.class, "ObjectWithID", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getObjectWithID_Properties(), this.getPropertyVar(), "properties", null, 0, 1, ObjectWithID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(objectWithIDEClass, ecorePackage.getEBoolean(), "checkNewID", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newID", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(objectWithIDEClass, ecorePackage.getEString(), "getObjectID", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(objectWithIDEClass, ecorePackage.getEBoolean(), "setObjectID", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newID", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(modesEClass, Modes.class, "Modes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModes_ModeList(), this.getMode(), null, "ModeList", null, 0, -1, Modes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modeEClass, Mode.class, "Mode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMode_Name(), this.getStringVar(), "Name", null, 1, 1, Mode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionalEClass, Functional.class, "Functional", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctional_EventList(), this.getEvent(), null, "EventList", null, 0, -1, Functional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctional_PartialOrderList(), this.getPartialOrder(), null, "PartialOrderList", null, 0, -1, Functional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctional_Implementation(), this.getSystemImplementation(), null, "Implementation", null, 0, -1, Functional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctional_TimeConstList(), this.getTimeConst(), null, "TimeConstList", null, 0, -1, Functional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctional_TypeList(), this.getType(), null, "TypeList", null, 0, -1, Functional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(implementationEClass, Implementation.class, "Implementation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(procEClass, Proc.class, "Proc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProc_MethodRefList(), this.getMethodRef(), null, "MethodRefList", null, 0, -1, Proc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProc_Methods(), this.getStringVar(), "Methods", null, 0, -1, Proc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(architecturalEClass, Architectural.class, "Architectural", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArchitectural_BusList(), this.getBus(), null, "BusList", null, 0, -1, Architectural.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectural_EcuList(), this.getEcu(), null, "EcuList", null, 1, -1, Architectural.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectural_FrameList(), this.getFrame(), null, "FrameList", null, 0, -1, Architectural.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectural_MutexList(), this.getMutex(), null, "MutexList", null, 0, -1, Architectural.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectural_ResourceList(), this.getResource(), null, "ResourceList", null, 0, -1, Architectural.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectural_SignalList(), this.getSignal(), null, "SignalList", null, 0, -1, Architectural.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectural_TaskList(), this.getTask(), null, "TaskList", null, 1, -1, Architectural.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectural_ComList(), this.getCom(), null, "ComList", null, 0, -1, Architectural.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectural_SpinLockList(), this.getSpinLock(), null, "SpinLockList", null, 0, -1, Architectural.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitectural_ScheduleTableList(), this.getScheduleTable(), null, "ScheduleTableList", null, 0, -1, Architectural.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapping_ProcMapList(), this.getProcMap(), null, "ProcMapList", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapping_TaskMapList(), this.getTaskMap(), null, "TaskMapList", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapping_VarMapList(), this.getVarMap(), null, "VarMapList", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationEClass, Annotation.class, "Annotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotation_ExecTimeLists(), this.getExecTimeList(), null, "ExecTimeLists", null, 0, -1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotation_CacheMissCostLists(), this.getCacheMissCostList(), null, "CacheMissCostLists", null, 0, -1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schedulabilityEClass, Schedulability.class, "Schedulability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchedulability_SchedulingScenarioList(), this.getSchedulingScenario(), null, "SchedulingScenarioList", null, 0, -1, Schedulability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(varEClass, Var.class, "Var", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVar_Methods(), this.getStringVar(), "Methods", null, 0, -1, Var.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVar_Type(), this.getStringVar(), "Type", null, 0, 1, Var.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(triggerEClass, Trigger.class, "Trigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTrigger_MethodRefList(), this.getMethodRef(), null, "MethodRefList", null, 0, -1, Trigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventEClass, Event.class, "Event", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEvent_Name(), this.getStringVar(), "Name", null, 1, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_MethodRefName(), this.getStringVar(), "MethodRefName", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Type(), this.getStringVar(), "Type", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(partialOrderEClass, PartialOrder.class, "PartialOrder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPartialOrder_ModeRef(), this.getStringVar(), "ModeRef", null, 1, 1, PartialOrder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartialOrder_OrderList(), this.getOrder(), null, "OrderList", null, 0, -1, PartialOrder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(systemImplementationEClass, SystemImplementation.class, "SystemImplementation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSystemImplementation_Name(), this.getStringVar(), "Name", null, 1, 1, SystemImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subSystemEClass, SubSystem.class, "SubSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubSystem_Implementation(), this.getImplementation(), null, "Implementation", null, 0, -1, SubSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubSystem_ProvidedInterfaceList(), this.getProvidedInterface(), null, "ProvidedInterfaceList", null, 0, -1, SubSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubSystem_RequiredInterfaceList(), this.getRequiredInterface(), null, "RequiredInterfaceList", null, 0, -1, SubSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timeConstEClass, TimeConst.class, "TimeConst", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimeConst_ModeRef(), this.getStringVar(), "ModeRef", null, 1, 1, TimeConst.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTimeConst_TimeConstElementList(), this.getTimeConstElement(), null, "TimeConstElementList", null, 0, -1, TimeConst.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(methodRefEClass, MethodRef.class, "MethodRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMethodRef_Name(), this.getStringVar(), "Name", null, 1, 1, MethodRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethodRef_MethodName(), this.getStringVar(), "MethodName", null, 0, 1, MethodRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(providedInterfaceEClass, ProvidedInterface.class, "ProvidedInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProvidedInterface_LocalMethodRef(), this.getStringVar(), "LocalMethodRef", null, 0, 1, ProvidedInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProvidedInterface_LocalObjectRef(), this.getStringVar(), "LocalObjectRef", null, 0, 1, ProvidedInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProvidedInterface_Name(), this.getStringVar(), "Name", null, 1, 1, ProvidedInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requiredInterfaceEClass, RequiredInterface.class, "RequiredInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRequiredInterface_ExternalMethodRef(), this.getStringVar(), "ExternalMethodRef", null, 0, 1, RequiredInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequiredInterface_Name(), this.getStringVar(), "Name", null, 1, 1, RequiredInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(orderEClass, Order.class, "Order", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOrder_FirstEvent(), this.getStringVar(), "FirstEvent", null, 1, 1, Order.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOrder_SecondEvent(), this.getStringVar(), "SecondEvent", null, 1, 1, Order.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timeConstElementEClass, TimeConstElement.class, "TimeConstElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimeConstElement_BoundType(), this.getStringVar(), "BoundType", null, 0, 1, TimeConstElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeConstElement_BoundValue(), this.getTimeVar(), "BoundValue", null, 0, 1, TimeConstElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeConstElement_FirstEvent(), this.getStringVar(), "FirstEvent", null, 1, 1, TimeConstElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeConstElement_SecondEvent(), this.getStringVar(), "SecondEvent", null, 0, 1, TimeConstElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ecuEClass, Ecu.class, "Ecu", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEcu_CpuList(), this.getCpu(), null, "CpuList", null, 0, -1, Ecu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEcu_Name(), this.getStringVar(), "Name", null, 1, 1, Ecu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTask_ActivationList(), this.getActivation(), null, "ActivationList", null, 0, -1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTask_Name(), this.getStringVar(), "Name", null, 1, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTask_OilVar(), this.getOilVar(), "OilVar", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTask_ResourceRefList(), this.getResourceRef(), null, "ResourceRefList", null, 0, -1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTask_SchedulingList(), this.getScheduling(), null, "SchedulingList", null, 0, -1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTask_Type(), this.getStringVar(), "Type", null, 0, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceEClass, Resource.class, "Resource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResource_Methods(), this.getStringVar(), "Methods", null, 0, -1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResource_MutexRefList(), this.getMutexRef(), null, "MutexRefList", null, 0, -1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResource_Name(), this.getStringVar(), "Name", null, 1, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(busEClass, Bus.class, "Bus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBus_Name(), this.getStringVar(), "Name", null, 1, 1, Bus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBus_Speed(), this.getLongVar(), "Speed", null, 0, 1, Bus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBus_Type(), this.getStringVar(), "Type", null, 0, 1, Bus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(frameEClass, Frame.class, "Frame", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFrame_ActivationClass(), this.getStringVar(), "ActivationClass", null, 0, 1, Frame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFrame_ActivationRate(), this.getStringVar(), "ActivationRate", null, 0, 1, Frame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFrame_ActivationType(), this.getStringVar(), "ActivationType", null, 0, 1, Frame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFrame_Id(), this.getStringVar(), "Id", null, 0, 1, Frame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFrame_Length(), this.getLongVar(), "Length", null, 0, 1, Frame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFrame_Name(), this.getStringVar(), "Name", null, 1, 1, Frame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFrame_MessageType(), this.getStringVar(), "MessageType", null, 0, 1, Frame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(signalEClass, Signal.class, "Signal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSignal_Name(), this.getStringVar(), "Name", null, 1, 1, Signal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSignal_OilVar(), this.getOilVar(), "OilVar", null, 0, 1, Signal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSignal_Type(), this.getStringVar(), "Type", null, 0, 1, Signal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mutexEClass, Mutex.class, "Mutex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMutex_Name(), this.getStringVar(), "Name", null, 1, 1, Mutex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMutex_OilVar(), this.getOilVar(), "OilVar", null, 0, 1, Mutex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMutex_Policy(), this.getStringVar(), "Policy", null, 0, 1, Mutex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cpuEClass, Cpu.class, "Cpu", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCpu_Name(), this.getStringVar(), "Name", null, 1, 1, Cpu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCpu_Model(), this.getStringVar(), "Model", null, 0, 1, Cpu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCpu_Rtos(), this.getRtos(), null, "Rtos", null, 0, 1, Cpu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCpu_OsApplication(), this.getOsApplication(), null, "OsApplication", null, 0, -1, Cpu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCpu_Speed(), this.getDoubleVar(), "Speed", null, 0, 1, Cpu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCpu_Speed_Unit(), this.getStringVar(), "Speed_Unit", null, 0, 1, Cpu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCpu_BinaryImage(), this.getStringVar(), "BinaryImage", null, 0, 1, Cpu.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rtosEClass, Rtos.class, "Rtos", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRtos_Name(), this.getStringVar(), "Name", null, 1, 1, Rtos.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRtos_OilVar(), this.getOilVar(), "OilVar", null, 0, 1, Rtos.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRtos_Type(), this.getStringVar(), "Type", null, 0, 1, Rtos.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRtos_Methods(), this.getStringVar(), "Methods", null, 0, -1, Rtos.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schedulingEClass, Scheduling.class, "Scheduling", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScheduling_ModeRef(), this.getStringVar(), "ModeRef", null, 1, 1, Scheduling.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScheduling_PreemptionGroupName(), this.getStringVar(), "PreemptionGroupName", null, 0, 1, Scheduling.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScheduling_Priority(), this.getIntegerVar(), "Priority", null, 0, 1, Scheduling.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScheduling_Threshold(), this.getIntegerVar(), "Threshold", null, 0, 1, Scheduling.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScheduling_Stack(), this.getIntegerVar(), "Stack", null, 0, 1, Scheduling.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(activationEClass, Activation.class, "Activation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActivation_ActNumber(), this.getIntegerVar(), "ActNumber", null, 0, 1, Activation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivation_ActivationClass(), this.getStringVar(), "ActivationClass", null, 0, 1, Activation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivation_Deadline(), this.getTimeVar(), "Deadline", null, 0, 1, Activation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivation_ModeRef(), this.getStringVar(), "ModeRef", null, 1, 1, Activation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivation_Offset(), this.getTimeVar(), "Offset", null, 0, 1, Activation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivation_Period(), this.getTimeVar(), "Period", null, 0, 1, Activation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivation_Type(), this.getStringVar(), "Type", null, 0, 1, Activation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceRefEClass, ResourceRef.class, "ResourceRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceRef_ModeRef(), this.getStringVar(), "ModeRef", null, 1, 1, ResourceRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceRef_ResourceMethodRef(), this.getStringVar(), "ResourceMethodRef", null, 0, -1, ResourceRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mutexRefEClass, MutexRef.class, "MutexRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMutexRef_ModeRef(), this.getStringVar(), "ModeRef", null, 1, 1, MutexRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMutexRef_MutexName(), this.getStringVar(), "MutexName", null, 0, 1, MutexRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(execTimeEClass, ExecTime.class, "ExecTime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExecTime_Best(), this.getTimeVar(), "Best", null, 0, 1, ExecTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecTime_Distribution(), this.getDistribution(), null, "Distribution", null, 0, 1, ExecTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecTime_Ref(), this.getStringVar(), "Ref", null, 1, 1, ExecTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecTime_Type(), this.getStringVar(), "Type", null, 1, 1, ExecTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecTime_Worst(), this.getTimeVar(), "Worst", null, 0, 1, ExecTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(execTimeListEClass, ExecTimeList.class, "ExecTimeList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecTimeList_ExecTimeItemsList(), this.getExecTime(), null, "ExecTimeItemsList", null, 0, -1, ExecTimeList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecTimeList_ModeRef(), this.getStringVar(), "ModeRef", null, 1, 1, ExecTimeList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(distributionEClass, Distribution.class, "Distribution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDistribution_Avg(), this.getTimeVar(), "Avg", null, 0, 1, Distribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDistribution_SampleList(), this.getSample(), null, "SampleList", null, 0, -1, Distribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDistribution_Type(), this.getStringVar(), "Type", null, 0, 1, Distribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDistribution_Variance(), this.getDoubleVar(), "Variance", null, 0, 1, Distribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sampleEClass, Sample.class, "Sample", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSample_Probability(), this.getDoubleVar(), "Probability", null, 0, 1, Sample.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSample_Value(), this.getTimeVar(), "Value", null, 1, 1, Sample.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(procMapEClass, ProcMap.class, "ProcMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProcMap_ModeRef(), this.getStringVar(), "ModeRef", null, 1, 1, ProcMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcMap_Order(), this.getIntegerVar(), "Order", null, 0, 1, ProcMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcMap_ProcRef(), this.getStringVar(), "ProcRef", null, 1, 1, ProcMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcMap_TaskRef(), this.getStringVar(), "TaskRef", null, 0, 1, ProcMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcMap_OnceEveryK(), this.getIntegerVar(), "OnceEveryK", "1", 0, 1, ProcMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcMap_MethodRefName(), this.getStringVar(), "MethodRefName", null, 0, 1, ProcMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskMapEClass, TaskMap.class, "TaskMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTaskMap_ModeRef(), this.getStringVar(), "ModeRef", null, 1, 1, TaskMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTaskMap_RtosRef(), this.getStringVar(), "RtosRef", null, 0, 1, TaskMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTaskMap_TaskRef(), this.getStringVar(), "TaskRef", null, 1, 1, TaskMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(varMapEClass, VarMap.class, "VarMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVarMap_BusRef(), this.getStringVar(), "BusRef", null, 0, 1, VarMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVarMap_FrameRef(), this.getStringVar(), "FrameRef", null, 0, 1, VarMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVarMap_ModeRef(), this.getStringVar(), "ModeRef", null, 1, 1, VarMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVarMap_MutexRef(), this.getStringVar(), "MutexRef", null, 0, 1, VarMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVarMap_VarRef(), this.getStringVar(), "VarRef", null, 1, 1, VarMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schedulingScenarioEClass, SchedulingScenario.class, "SchedulingScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchedulingScenario_CpuSchedList(), this.getCpuSched(), null, "CpuSchedList", null, 0, -1, SchedulingScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSchedulingScenario_ModeRef(), this.getStringVar(), "ModeRef", null, 1, 1, SchedulingScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSchedulingScenario_Reports(), this.getStringVar(), "Reports", null, 0, -1, SchedulingScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSchedulingScenario_TaskSchedList(), this.getTaskSched(), null, "TaskSchedList", null, 0, -1, SchedulingScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cpuSchedEClass, CpuSched.class, "CpuSched", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCpuSched_Boundary(), this.getDoubleVar(), "Boundary", null, 0, 1, CpuSched.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCpuSched_CpuRef(), this.getStringVar(), "CpuRef", null, 1, 1, CpuSched.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCpuSched_Schedulable(), this.getBooleanVar(), "Schedulable", null, 0, 1, CpuSched.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCpuSched_SpeedFactor(), this.getDoubleVar(), "SpeedFactor", null, 0, 1, CpuSched.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCpuSched_Utilization(), this.getDoubleVar(), "Utilization", null, 0, 1, CpuSched.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCpuSched_MaxStackSize(), this.getIntegerVar(), "MaxStackSize", null, 0, 1, CpuSched.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskSchedEClass, TaskSched.class, "TaskSched", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTaskSched_CDelta(), this.getDoubleVar(), "CDelta", null, 0, 1, TaskSched.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTaskSched_ResponseTime(), this.getTimeVar(), "ResponseTime", null, 0, 1, TaskSched.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTaskSched_Schedulable(), this.getBooleanVar(), "Schedulable", null, 0, 1, TaskSched.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTaskSched_TaskRef(), this.getStringVar(), "TaskRef", null, 1, 1, TaskSched.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTaskSched_TDelta(), this.getDoubleVar(), "TDelta", null, 0, 1, TaskSched.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTaskSched_Utilization(), this.getDoubleVar(), "Utilization", null, 0, 1, TaskSched.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cacheMissCostListEClass, CacheMissCostList.class, "CacheMissCostList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCacheMissCostList_CacheMissCostItemsList(), this.getCacheMissCost(), null, "CacheMissCostItemsList", null, 0, -1, CacheMissCostList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCacheMissCostList_ModeRef(), this.getStringVar(), "ModeRef", null, 1, 1, CacheMissCostList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cacheMissCostEClass, CacheMissCost.class, "CacheMissCost", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCacheMissCost_Best(), this.getTimeVar(), "Best", null, 0, 1, CacheMissCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCacheMissCost_Distribution(), this.getDistribution(), null, "Distribution", null, 0, 1, CacheMissCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCacheMissCost_Ref(), this.getStringVar(), "Ref", null, 1, 1, CacheMissCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCacheMissCost_Type(), this.getStringVar(), "Type", null, 1, 1, CacheMissCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCacheMissCost_Worst(), this.getTimeVar(), "Worst", null, 0, 1, CacheMissCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fieldEClass, Field.class, "Field", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getField_Name(), this.getStringVar(), "Name", null, 0, 1, Field.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getField_Type(), this.getStringVar(), "Type", null, 0, 1, Field.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getField_Size(), this.getIntegerVar(), "Size", null, 0, 1, Field.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getType_Name(), this.getStringVar(), "Name", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getType_Field(), this.getField(), null, "Field", null, 0, -1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getType_Dim(), this.getIntegerVar(), "Dim", "1", 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(osApplicationEClass, OsApplication.class, "OsApplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOsApplication_Name(), this.getStringVar(), "Name", null, 0, 1, OsApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOsApplication_OilVar(), this.getOilVar(), "OilVar", null, 0, 1, OsApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(comEClass, Com.class, "Com", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCom_Name(), this.getStringVar(), "Name", null, 0, 1, Com.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(spinLockEClass, SpinLock.class, "SpinLock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSpinLock_Name(), this.getStringVar(), "Name", null, 0, 1, SpinLock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schedulingTableEClass, ScheduleTable.class, "ScheduleTable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScheduleTable_Name(), this.getStringVar(), "Name", null, 0, 1, ScheduleTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(booleanVarEDataType, BooleanVar.class, "BooleanVar", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(doubleVarEDataType, DoubleVar.class, "DoubleVar", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(floatVarEDataType, FloatVar.class, "FloatVar", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(integerVarEDataType, IntegerVar.class, "IntegerVar", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(longVarEDataType, LongVar.class, "LongVar", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(oilVarEDataType, OilVar.class, "OilVar", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(stringVarEDataType, StringVar.class, "StringVar", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(timeVarEDataType, TimeVar.class, "TimeVar", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(propertyVarEDataType, PropertyVar.class, "PropertyVar", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //DataPackageImpl
