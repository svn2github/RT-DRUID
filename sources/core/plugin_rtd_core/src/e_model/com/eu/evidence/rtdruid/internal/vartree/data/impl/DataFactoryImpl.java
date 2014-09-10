/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
import com.eu.evidence.rtdruid.vartree.data.Mapping;
import com.eu.evidence.rtdruid.vartree.data.MethodRef;
import com.eu.evidence.rtdruid.vartree.data.Mode;
import com.eu.evidence.rtdruid.vartree.data.Modes;
import com.eu.evidence.rtdruid.vartree.data.Mutex;
import com.eu.evidence.rtdruid.vartree.data.MutexRef;
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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataFactoryImpl extends EFactoryImpl implements DataFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DataFactory init() {
		try {
			DataFactory theDataFactory = (DataFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.evidence.eu.com/rtdruid/data"); 
			if (theDataFactory != null) {
				return theDataFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DataFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DataPackage.SYSTEM: return createSystem();
			case DataPackage.MODES: return createModes();
			case DataPackage.MODE: return createMode();
			case DataPackage.FUNCTIONAL: return createFunctional();
			case DataPackage.PROC: return createProc();
			case DataPackage.ARCHITECTURAL: return createArchitectural();
			case DataPackage.MAPPING: return createMapping();
			case DataPackage.ANNOTATION: return createAnnotation();
			case DataPackage.SCHEDULABILITY: return createSchedulability();
			case DataPackage.VAR: return createVar();
			case DataPackage.TRIGGER: return createTrigger();
			case DataPackage.EVENT: return createEvent();
			case DataPackage.PARTIAL_ORDER: return createPartialOrder();
			case DataPackage.SUB_SYSTEM: return createSubSystem();
			case DataPackage.TIME_CONST: return createTimeConst();
			case DataPackage.METHOD_REF: return createMethodRef();
			case DataPackage.PROVIDED_INTERFACE: return createProvidedInterface();
			case DataPackage.REQUIRED_INTERFACE: return createRequiredInterface();
			case DataPackage.ORDER: return createOrder();
			case DataPackage.TIME_CONST_ELEMENT: return createTimeConstElement();
			case DataPackage.ECU: return createEcu();
			case DataPackage.TASK: return createTask();
			case DataPackage.RESOURCE: return createResource();
			case DataPackage.BUS: return createBus();
			case DataPackage.FRAME: return createFrame();
			case DataPackage.SIGNAL: return createSignal();
			case DataPackage.MUTEX: return createMutex();
			case DataPackage.CPU: return createCpu();
			case DataPackage.RTOS: return createRtos();
			case DataPackage.SCHEDULING: return createScheduling();
			case DataPackage.ACTIVATION: return createActivation();
			case DataPackage.RESOURCE_REF: return createResourceRef();
			case DataPackage.MUTEX_REF: return createMutexRef();
			case DataPackage.EXEC_TIME: return createExecTime();
			case DataPackage.EXEC_TIME_LIST: return createExecTimeList();
			case DataPackage.DISTRIBUTION: return createDistribution();
			case DataPackage.SAMPLE: return createSample();
			case DataPackage.PROC_MAP: return createProcMap();
			case DataPackage.TASK_MAP: return createTaskMap();
			case DataPackage.VAR_MAP: return createVarMap();
			case DataPackage.SCHEDULING_SCENARIO: return createSchedulingScenario();
			case DataPackage.CPU_SCHED: return createCpuSched();
			case DataPackage.TASK_SCHED: return createTaskSched();
			case DataPackage.CACHE_MISS_COST_LIST: return createCacheMissCostList();
			case DataPackage.CACHE_MISS_COST: return createCacheMissCost();
			case DataPackage.FIELD: return createField();
			case DataPackage.TYPE: return createType();
			case DataPackage.OS_APPLICATION: return createOsApplication();
			case DataPackage.COM: return createCom();
			case DataPackage.SPIN_LOCK: return createSpinLock();
			case DataPackage.SCHEDULE_TABLE: return createScheduleTable();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	
	public Object createFromString(EDataType eDataType, String initialValue) {
		return createFromStringGen(eDataType, initialValue);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromStringGen(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DataPackage.BOOLEAN_VAR:
				return createBooleanVarFromString(eDataType, initialValue);
			case DataPackage.DOUBLE_VAR:
				return createDoubleVarFromString(eDataType, initialValue);
			case DataPackage.FLOAT_VAR:
				return createFloatVarFromString(eDataType, initialValue);
			case DataPackage.INTEGER_VAR:
				return createIntegerVarFromString(eDataType, initialValue);
			case DataPackage.LONG_VAR:
				return createLongVarFromString(eDataType, initialValue);
			case DataPackage.OIL_VAR:
				return createOilVarFromString(eDataType, initialValue);
			case DataPackage.STRING_VAR:
				return createStringVarFromString(eDataType, initialValue);
			case DataPackage.TIME_VAR:
				return createTimeVarFromString(eDataType, initialValue);
			case DataPackage.PROPERTY_VAR:
				return createPropertyVarFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DataPackage.BOOLEAN_VAR:
				return convertBooleanVarToString(eDataType, instanceValue);
			case DataPackage.DOUBLE_VAR:
				return convertDoubleVarToString(eDataType, instanceValue);
			case DataPackage.FLOAT_VAR:
				return convertFloatVarToString(eDataType, instanceValue);
			case DataPackage.INTEGER_VAR:
				return convertIntegerVarToString(eDataType, instanceValue);
			case DataPackage.LONG_VAR:
				return convertLongVarToString(eDataType, instanceValue);
			case DataPackage.OIL_VAR:
				return convertOilVarToString(eDataType, instanceValue);
			case DataPackage.STRING_VAR:
				return convertStringVarToString(eDataType, instanceValue);
			case DataPackage.TIME_VAR:
				return convertTimeVarToString(eDataType, instanceValue);
			case DataPackage.PROPERTY_VAR:
				return convertPropertyVarToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public com.eu.evidence.rtdruid.vartree.data.System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Modes createModes() {
		ModesImpl modes = new ModesImpl();
		return modes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode createMode() {
		ModeImpl mode = new ModeImpl();
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Functional createFunctional() {
		FunctionalImpl functional = new FunctionalImpl();
		return functional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Proc createProc() {
		ProcImpl proc = new ProcImpl();
		return proc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Architectural createArchitectural() {
		ArchitecturalImpl architectural = new ArchitecturalImpl();
		return architectural;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping createMapping() {
		MappingImpl mapping = new MappingImpl();
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation createAnnotation() {
		AnnotationImpl annotation = new AnnotationImpl();
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Schedulability createSchedulability() {
		SchedulabilityImpl schedulability = new SchedulabilityImpl();
		return schedulability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Var createVar() {
		VarImpl var = new VarImpl();
		return var;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trigger createTrigger() {
		TriggerImpl trigger = new TriggerImpl();
		return trigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event createEvent() {
		EventImpl event = new EventImpl();
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartialOrder createPartialOrder() {
		PartialOrderImpl partialOrder = new PartialOrderImpl();
		return partialOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubSystem createSubSystem() {
		SubSystemImpl subSystem = new SubSystemImpl();
		return subSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeConst createTimeConst() {
		TimeConstImpl timeConst = new TimeConstImpl();
		return timeConst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodRef createMethodRef() {
		MethodRefImpl methodRef = new MethodRefImpl();
		return methodRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidedInterface createProvidedInterface() {
		ProvidedInterfaceImpl providedInterface = new ProvidedInterfaceImpl();
		return providedInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredInterface createRequiredInterface() {
		RequiredInterfaceImpl requiredInterface = new RequiredInterfaceImpl();
		return requiredInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Order createOrder() {
		OrderImpl order = new OrderImpl();
		return order;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeConstElement createTimeConstElement() {
		TimeConstElementImpl timeConstElement = new TimeConstElementImpl();
		return timeConstElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ecu createEcu() {
		EcuImpl ecu = new EcuImpl();
		return ecu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task createTask() {
		TaskImpl task = new TaskImpl();
		return task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource createResource() {
		ResourceImpl resource = new ResourceImpl();
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bus createBus() {
		BusImpl bus = new BusImpl();
		return bus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Frame createFrame() {
		FrameImpl frame = new FrameImpl();
		return frame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signal createSignal() {
		SignalImpl signal = new SignalImpl();
		return signal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mutex createMutex() {
		MutexImpl mutex = new MutexImpl();
		return mutex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Cpu createCpu() {
		CpuImpl cpu = new CpuImpl();
		return cpu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rtos createRtos() {
		RtosImpl rtos = new RtosImpl();
		return rtos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scheduling createScheduling() {
		SchedulingImpl scheduling = new SchedulingImpl();
		return scheduling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activation createActivation() {
		ActivationImpl activation = new ActivationImpl();
		return activation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRef createResourceRef() {
		ResourceRefImpl resourceRef = new ResourceRefImpl();
		return resourceRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutexRef createMutexRef() {
		MutexRefImpl mutexRef = new MutexRefImpl();
		return mutexRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecTime createExecTime() {
		ExecTimeImpl execTime = new ExecTimeImpl();
		return execTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecTimeList createExecTimeList() {
		ExecTimeListImpl execTimeList = new ExecTimeListImpl();
		return execTimeList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Distribution createDistribution() {
		DistributionImpl distribution = new DistributionImpl();
		return distribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sample createSample() {
		SampleImpl sample = new SampleImpl();
		return sample;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcMap createProcMap() {
		ProcMapImpl procMap = new ProcMapImpl();
		return procMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskMap createTaskMap() {
		TaskMapImpl taskMap = new TaskMapImpl();
		return taskMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VarMap createVarMap() {
		VarMapImpl varMap = new VarMapImpl();
		return varMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingScenario createSchedulingScenario() {
		SchedulingScenarioImpl schedulingScenario = new SchedulingScenarioImpl();
		return schedulingScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CpuSched createCpuSched() {
		CpuSchedImpl cpuSched = new CpuSchedImpl();
		return cpuSched;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskSched createTaskSched() {
		TaskSchedImpl taskSched = new TaskSchedImpl();
		return taskSched;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CacheMissCostList createCacheMissCostList() {
		CacheMissCostListImpl cacheMissCostList = new CacheMissCostListImpl();
		return cacheMissCostList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CacheMissCost createCacheMissCost() {
		CacheMissCostImpl cacheMissCost = new CacheMissCostImpl();
		return cacheMissCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Field createField() {
		FieldImpl field = new FieldImpl();
		return field;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type createType() {
		TypeImpl type = new TypeImpl();
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OsApplication createOsApplication() {
		OsApplicationImpl osApplication = new OsApplicationImpl();
		return osApplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Com createCom() {
		ComImpl com = new ComImpl();
		return com;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpinLock createSpinLock() {
		SpinLockImpl spinLock = new SpinLockImpl();
		return spinLock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScheduleTable createScheduleTable() {
		ScheduleTableImpl schedulingTable = new ScheduleTableImpl();
		return schedulingTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanVar createBooleanVarFromString(EDataType eDataType, String initialValue) {
		return (BooleanVar)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBooleanVarToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleVar createDoubleVarFromString(EDataType eDataType, String initialValue) {
		return (DoubleVar)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDoubleVarToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FloatVar createFloatVarFromString(EDataType eDataType, String initialValue) {
		return (FloatVar)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFloatVarToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerVar createIntegerVarFromString(EDataType eDataType, String initialValue) {
		return (IntegerVar)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIntegerVarToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongVar createLongVarFromString(EDataType eDataType, String initialValue) {
		return (LongVar)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLongVarToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OilVar createOilVarFromString(EDataType eDataType, String initialValue) {
		return (OilVar)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOilVarToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVar createStringVarFromString(EDataType eDataType, String initialValue) {
		return (StringVar)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStringVarToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeVar createTimeVarFromString(EDataType eDataType, String initialValue) {
		return (TimeVar)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTimeVarToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PropertyVar createPropertyVarFromString(EDataType eDataType, String initialValue) {
		return new PropertyVar(initialValue);//(PropertyVar)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPropertyVarToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataPackage getDataPackage() {
		return (DataPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DataPackage getPackage() {
		return DataPackage.eINSTANCE;
	}

} //DataFactoryImpl
