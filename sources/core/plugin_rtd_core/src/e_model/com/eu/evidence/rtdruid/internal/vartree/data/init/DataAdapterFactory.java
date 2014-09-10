/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.vartree.data.init;

import com.eu.evidence.rtdruid.vartree.data.Activation;
import com.eu.evidence.rtdruid.vartree.data.Annotation;
import com.eu.evidence.rtdruid.vartree.data.Architectural;
import com.eu.evidence.rtdruid.vartree.data.Bus;
import com.eu.evidence.rtdruid.vartree.data.CacheMissCost;
import com.eu.evidence.rtdruid.vartree.data.CacheMissCostList;
import com.eu.evidence.rtdruid.vartree.data.Com;
import com.eu.evidence.rtdruid.vartree.data.Cpu;
import com.eu.evidence.rtdruid.vartree.data.CpuSched;
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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage
 * @generated
 */
public class DataAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DataPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DataPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataSwitch<Adapter> modelSwitch =
		new DataSwitch<Adapter>() {
			@Override
			public Adapter caseSystem(com.eu.evidence.rtdruid.vartree.data.System object) {
				return createSystemAdapter();
			}
			@Override
			public Adapter caseObjectWithID(ObjectWithID object) {
				return createObjectWithIDAdapter();
			}
			@Override
			public Adapter caseModes(Modes object) {
				return createModesAdapter();
			}
			@Override
			public Adapter caseMode(Mode object) {
				return createModeAdapter();
			}
			@Override
			public Adapter caseFunctional(Functional object) {
				return createFunctionalAdapter();
			}
			@Override
			public Adapter caseImplementation(Implementation object) {
				return createImplementationAdapter();
			}
			@Override
			public Adapter caseProc(Proc object) {
				return createProcAdapter();
			}
			@Override
			public Adapter caseArchitectural(Architectural object) {
				return createArchitecturalAdapter();
			}
			@Override
			public Adapter caseMapping(Mapping object) {
				return createMappingAdapter();
			}
			@Override
			public Adapter caseAnnotation(Annotation object) {
				return createAnnotationAdapter();
			}
			@Override
			public Adapter caseSchedulability(Schedulability object) {
				return createSchedulabilityAdapter();
			}
			@Override
			public Adapter caseVar(Var object) {
				return createVarAdapter();
			}
			@Override
			public Adapter caseTrigger(Trigger object) {
				return createTriggerAdapter();
			}
			@Override
			public Adapter caseEvent(Event object) {
				return createEventAdapter();
			}
			@Override
			public Adapter casePartialOrder(PartialOrder object) {
				return createPartialOrderAdapter();
			}
			@Override
			public Adapter caseSystemImplementation(SystemImplementation object) {
				return createSystemImplementationAdapter();
			}
			@Override
			public Adapter caseSubSystem(SubSystem object) {
				return createSubSystemAdapter();
			}
			@Override
			public Adapter caseTimeConst(TimeConst object) {
				return createTimeConstAdapter();
			}
			@Override
			public Adapter caseMethodRef(MethodRef object) {
				return createMethodRefAdapter();
			}
			@Override
			public Adapter caseProvidedInterface(ProvidedInterface object) {
				return createProvidedInterfaceAdapter();
			}
			@Override
			public Adapter caseRequiredInterface(RequiredInterface object) {
				return createRequiredInterfaceAdapter();
			}
			@Override
			public Adapter caseOrder(Order object) {
				return createOrderAdapter();
			}
			@Override
			public Adapter caseTimeConstElement(TimeConstElement object) {
				return createTimeConstElementAdapter();
			}
			@Override
			public Adapter caseEcu(Ecu object) {
				return createEcuAdapter();
			}
			@Override
			public Adapter caseTask(Task object) {
				return createTaskAdapter();
			}
			@Override
			public Adapter caseResource(Resource object) {
				return createResourceAdapter();
			}
			@Override
			public Adapter caseBus(Bus object) {
				return createBusAdapter();
			}
			@Override
			public Adapter caseFrame(Frame object) {
				return createFrameAdapter();
			}
			@Override
			public Adapter caseSignal(Signal object) {
				return createSignalAdapter();
			}
			@Override
			public Adapter caseMutex(Mutex object) {
				return createMutexAdapter();
			}
			@Override
			public Adapter caseCpu(Cpu object) {
				return createCpuAdapter();
			}
			@Override
			public Adapter caseRtos(Rtos object) {
				return createRtosAdapter();
			}
			@Override
			public Adapter caseScheduling(Scheduling object) {
				return createSchedulingAdapter();
			}
			@Override
			public Adapter caseActivation(Activation object) {
				return createActivationAdapter();
			}
			@Override
			public Adapter caseResourceRef(ResourceRef object) {
				return createResourceRefAdapter();
			}
			@Override
			public Adapter caseMutexRef(MutexRef object) {
				return createMutexRefAdapter();
			}
			@Override
			public Adapter caseExecTime(ExecTime object) {
				return createExecTimeAdapter();
			}
			@Override
			public Adapter caseExecTimeList(ExecTimeList object) {
				return createExecTimeListAdapter();
			}
			@Override
			public Adapter caseDistribution(Distribution object) {
				return createDistributionAdapter();
			}
			@Override
			public Adapter caseSample(Sample object) {
				return createSampleAdapter();
			}
			@Override
			public Adapter caseProcMap(ProcMap object) {
				return createProcMapAdapter();
			}
			@Override
			public Adapter caseTaskMap(TaskMap object) {
				return createTaskMapAdapter();
			}
			@Override
			public Adapter caseVarMap(VarMap object) {
				return createVarMapAdapter();
			}
			@Override
			public Adapter caseSchedulingScenario(SchedulingScenario object) {
				return createSchedulingScenarioAdapter();
			}
			@Override
			public Adapter caseCpuSched(CpuSched object) {
				return createCpuSchedAdapter();
			}
			@Override
			public Adapter caseTaskSched(TaskSched object) {
				return createTaskSchedAdapter();
			}
			@Override
			public Adapter caseCacheMissCostList(CacheMissCostList object) {
				return createCacheMissCostListAdapter();
			}
			@Override
			public Adapter caseCacheMissCost(CacheMissCost object) {
				return createCacheMissCostAdapter();
			}
			@Override
			public Adapter caseField(Field object) {
				return createFieldAdapter();
			}
			@Override
			public Adapter caseType(Type object) {
				return createTypeAdapter();
			}
			@Override
			public Adapter caseOsApplication(OsApplication object) {
				return createOsApplicationAdapter();
			}
			@Override
			public Adapter caseCom(Com object) {
				return createComAdapter();
			}
			@Override
			public Adapter caseSpinLock(SpinLock object) {
				return createSpinLockAdapter();
			}
			@Override
			public Adapter caseScheduleTable(ScheduleTable object) {
				return createScheduleTableAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.System
	 * @generated
	 */
	public Adapter createSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.ObjectWithID <em>Object With ID</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.ObjectWithID
	 * @generated
	 */
	public Adapter createObjectWithIDAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Modes <em>Modes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Modes
	 * @generated
	 */
	public Adapter createModesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Mode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Mode
	 * @generated
	 */
	public Adapter createModeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Functional <em>Functional</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Functional
	 * @generated
	 */
	public Adapter createFunctionalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Implementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Implementation
	 * @generated
	 */
	public Adapter createImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Proc <em>Proc</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Proc
	 * @generated
	 */
	public Adapter createProcAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Architectural <em>Architectural</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Architectural
	 * @generated
	 */
	public Adapter createArchitecturalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Mapping
	 * @generated
	 */
	public Adapter createMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Annotation
	 * @generated
	 */
	public Adapter createAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Schedulability <em>Schedulability</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Schedulability
	 * @generated
	 */
	public Adapter createSchedulabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Var <em>Var</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Var
	 * @generated
	 */
	public Adapter createVarAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Trigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Trigger
	 * @generated
	 */
	public Adapter createTriggerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Event
	 * @generated
	 */
	public Adapter createEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.PartialOrder <em>Partial Order</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.PartialOrder
	 * @generated
	 */
	public Adapter createPartialOrderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.SystemImplementation <em>System Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.SystemImplementation
	 * @generated
	 */
	public Adapter createSystemImplementationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.SubSystem <em>Sub System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.SubSystem
	 * @generated
	 */
	public Adapter createSubSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.TimeConst <em>Time Const</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.TimeConst
	 * @generated
	 */
	public Adapter createTimeConstAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.MethodRef <em>Method Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.MethodRef
	 * @generated
	 */
	public Adapter createMethodRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.ProvidedInterface <em>Provided Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.ProvidedInterface
	 * @generated
	 */
	public Adapter createProvidedInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.RequiredInterface <em>Required Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.RequiredInterface
	 * @generated
	 */
	public Adapter createRequiredInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Order <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Order
	 * @generated
	 */
	public Adapter createOrderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.TimeConstElement <em>Time Const Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.TimeConstElement
	 * @generated
	 */
	public Adapter createTimeConstElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Ecu <em>Ecu</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Ecu
	 * @generated
	 */
	public Adapter createEcuAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Task
	 * @generated
	 */
	public Adapter createTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Bus <em>Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Bus
	 * @generated
	 */
	public Adapter createBusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Frame <em>Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Frame
	 * @generated
	 */
	public Adapter createFrameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Signal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Signal
	 * @generated
	 */
	public Adapter createSignalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Mutex <em>Mutex</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Mutex
	 * @generated
	 */
	public Adapter createMutexAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Cpu <em>Cpu</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Cpu
	 * @generated
	 */
	public Adapter createCpuAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Rtos <em>Rtos</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Rtos
	 * @generated
	 */
	public Adapter createRtosAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Scheduling <em>Scheduling</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Scheduling
	 * @generated
	 */
	public Adapter createSchedulingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Activation <em>Activation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Activation
	 * @generated
	 */
	public Adapter createActivationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.ResourceRef <em>Resource Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.ResourceRef
	 * @generated
	 */
	public Adapter createResourceRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.MutexRef <em>Mutex Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.MutexRef
	 * @generated
	 */
	public Adapter createMutexRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.ExecTime <em>Exec Time</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.ExecTime
	 * @generated
	 */
	public Adapter createExecTimeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.ExecTimeList <em>Exec Time List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.ExecTimeList
	 * @generated
	 */
	public Adapter createExecTimeListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Distribution <em>Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Distribution
	 * @generated
	 */
	public Adapter createDistributionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Sample <em>Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Sample
	 * @generated
	 */
	public Adapter createSampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.ProcMap <em>Proc Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.ProcMap
	 * @generated
	 */
	public Adapter createProcMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.TaskMap <em>Task Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.TaskMap
	 * @generated
	 */
	public Adapter createTaskMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.VarMap <em>Var Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.VarMap
	 * @generated
	 */
	public Adapter createVarMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.SchedulingScenario <em>Scheduling Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.SchedulingScenario
	 * @generated
	 */
	public Adapter createSchedulingScenarioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.CpuSched <em>Cpu Sched</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.CpuSched
	 * @generated
	 */
	public Adapter createCpuSchedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.TaskSched <em>Task Sched</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.TaskSched
	 * @generated
	 */
	public Adapter createTaskSchedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCostList <em>Cache Miss Cost List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.CacheMissCostList
	 * @generated
	 */
	public Adapter createCacheMissCostListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.CacheMissCost <em>Cache Miss Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.CacheMissCost
	 * @generated
	 */
	public Adapter createCacheMissCostAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Field
	 * @generated
	 */
	public Adapter createFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.OsApplication <em>Os Application</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.OsApplication
	 * @generated
	 */
	public Adapter createOsApplicationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.Com <em>Com</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.Com
	 * @generated
	 */
	public Adapter createComAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.SpinLock <em>Spin Lock</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.SpinLock
	 * @generated
	 */
	public Adapter createSpinLockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.eu.evidence.rtdruid.vartree.data.ScheduleTable <em>Scheduling Table</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.eu.evidence.rtdruid.vartree.data.ScheduleTable
	 * @generated
	 */
	public Adapter createScheduleTableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DataAdapterFactory
