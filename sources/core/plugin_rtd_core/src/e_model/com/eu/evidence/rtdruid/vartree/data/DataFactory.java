/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.vartree.data;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage
 * @generated
 */
public interface DataFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataFactory eINSTANCE = com.eu.evidence.rtdruid.internal.vartree.data.impl.DataFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System</em>'.
	 * @generated
	 */
	System createSystem();

	/**
	 * Returns a new object of class '<em>Modes</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Modes</em>'.
	 * @generated
	 */
	Modes createModes();

	/**
	 * Returns a new object of class '<em>Mode</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mode</em>'.
	 * @generated
	 */
	Mode createMode();

	/**
	 * Returns a new object of class '<em>Functional</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Functional</em>'.
	 * @generated
	 */
	Functional createFunctional();

	/**
	 * Returns a new object of class '<em>Proc</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Proc</em>'.
	 * @generated
	 */
	Proc createProc();

	/**
	 * Returns a new object of class '<em>Architectural</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Architectural</em>'.
	 * @generated
	 */
	Architectural createArchitectural();

	/**
	 * Returns a new object of class '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping</em>'.
	 * @generated
	 */
	Mapping createMapping();

	/**
	 * Returns a new object of class '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation</em>'.
	 * @generated
	 */
	Annotation createAnnotation();

	/**
	 * Returns a new object of class '<em>Schedulability</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Schedulability</em>'.
	 * @generated
	 */
	Schedulability createSchedulability();

	/**
	 * Returns a new object of class '<em>Var</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Var</em>'.
	 * @generated
	 */
	Var createVar();

	/**
	 * Returns a new object of class '<em>Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trigger</em>'.
	 * @generated
	 */
	Trigger createTrigger();

	/**
	 * Returns a new object of class '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event</em>'.
	 * @generated
	 */
	Event createEvent();

	/**
	 * Returns a new object of class '<em>Partial Order</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Partial Order</em>'.
	 * @generated
	 */
	PartialOrder createPartialOrder();

	/**
	 * Returns a new object of class '<em>Sub System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub System</em>'.
	 * @generated
	 */
	SubSystem createSubSystem();

	/**
	 * Returns a new object of class '<em>Time Const</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Time Const</em>'.
	 * @generated
	 */
	TimeConst createTimeConst();

	/**
	 * Returns a new object of class '<em>Method Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method Ref</em>'.
	 * @generated
	 */
	MethodRef createMethodRef();

	/**
	 * Returns a new object of class '<em>Provided Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Provided Interface</em>'.
	 * @generated
	 */
	ProvidedInterface createProvidedInterface();

	/**
	 * Returns a new object of class '<em>Required Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Required Interface</em>'.
	 * @generated
	 */
	RequiredInterface createRequiredInterface();

	/**
	 * Returns a new object of class '<em>Order</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Order</em>'.
	 * @generated
	 */
	Order createOrder();

	/**
	 * Returns a new object of class '<em>Time Const Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Time Const Element</em>'.
	 * @generated
	 */
	TimeConstElement createTimeConstElement();

	/**
	 * Returns a new object of class '<em>Ecu</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecu</em>'.
	 * @generated
	 */
	Ecu createEcu();

	/**
	 * Returns a new object of class '<em>Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task</em>'.
	 * @generated
	 */
	Task createTask();

	/**
	 * Returns a new object of class '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource</em>'.
	 * @generated
	 */
	Resource createResource();

	/**
	 * Returns a new object of class '<em>Bus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bus</em>'.
	 * @generated
	 */
	Bus createBus();

	/**
	 * Returns a new object of class '<em>Frame</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Frame</em>'.
	 * @generated
	 */
	Frame createFrame();

	/**
	 * Returns a new object of class '<em>Signal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Signal</em>'.
	 * @generated
	 */
	Signal createSignal();

	/**
	 * Returns a new object of class '<em>Mutex</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mutex</em>'.
	 * @generated
	 */
	Mutex createMutex();

	/**
	 * Returns a new object of class '<em>Cpu</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cpu</em>'.
	 * @generated
	 */
	Cpu createCpu();

	/**
	 * Returns a new object of class '<em>Rtos</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rtos</em>'.
	 * @generated
	 */
	Rtos createRtos();

	/**
	 * Returns a new object of class '<em>Scheduling</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduling</em>'.
	 * @generated
	 */
	Scheduling createScheduling();

	/**
	 * Returns a new object of class '<em>Activation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activation</em>'.
	 * @generated
	 */
	Activation createActivation();

	/**
	 * Returns a new object of class '<em>Resource Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Ref</em>'.
	 * @generated
	 */
	ResourceRef createResourceRef();

	/**
	 * Returns a new object of class '<em>Mutex Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mutex Ref</em>'.
	 * @generated
	 */
	MutexRef createMutexRef();

	/**
	 * Returns a new object of class '<em>Exec Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exec Time</em>'.
	 * @generated
	 */
	ExecTime createExecTime();

	/**
	 * Returns a new object of class '<em>Exec Time List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exec Time List</em>'.
	 * @generated
	 */
	ExecTimeList createExecTimeList();

	/**
	 * Returns a new object of class '<em>Distribution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Distribution</em>'.
	 * @generated
	 */
	Distribution createDistribution();

	/**
	 * Returns a new object of class '<em>Sample</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sample</em>'.
	 * @generated
	 */
	Sample createSample();

	/**
	 * Returns a new object of class '<em>Proc Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Proc Map</em>'.
	 * @generated
	 */
	ProcMap createProcMap();

	/**
	 * Returns a new object of class '<em>Task Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task Map</em>'.
	 * @generated
	 */
	TaskMap createTaskMap();

	/**
	 * Returns a new object of class '<em>Var Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Var Map</em>'.
	 * @generated
	 */
	VarMap createVarMap();

	/**
	 * Returns a new object of class '<em>Scheduling Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduling Scenario</em>'.
	 * @generated
	 */
	SchedulingScenario createSchedulingScenario();

	/**
	 * Returns a new object of class '<em>Cpu Sched</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cpu Sched</em>'.
	 * @generated
	 */
	CpuSched createCpuSched();

	/**
	 * Returns a new object of class '<em>Task Sched</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task Sched</em>'.
	 * @generated
	 */
	TaskSched createTaskSched();

	/**
	 * Returns a new object of class '<em>Cache Miss Cost List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cache Miss Cost List</em>'.
	 * @generated
	 */
	CacheMissCostList createCacheMissCostList();

	/**
	 * Returns a new object of class '<em>Cache Miss Cost</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cache Miss Cost</em>'.
	 * @generated
	 */
	CacheMissCost createCacheMissCost();

	/**
	 * Returns a new object of class '<em>Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Field</em>'.
	 * @generated
	 */
	Field createField();

	/**
	 * Returns a new object of class '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type</em>'.
	 * @generated
	 */
	Type createType();

	/**
	 * Returns a new object of class '<em>Os Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Os Application</em>'.
	 * @generated
	 */
	OsApplication createOsApplication();

	/**
	 * Returns a new object of class '<em>Com</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Com</em>'.
	 * @generated
	 */
	Com createCom();

	/**
	 * Returns a new object of class '<em>Spin Lock</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Spin Lock</em>'.
	 * @generated
	 */
	SpinLock createSpinLock();

	/**
	 * Returns a new object of class '<em>Scheduling Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduling Table</em>'.
	 * @generated
	 */
	ScheduleTable createScheduleTable();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DataPackage getDataPackage();

} //DataFactory
