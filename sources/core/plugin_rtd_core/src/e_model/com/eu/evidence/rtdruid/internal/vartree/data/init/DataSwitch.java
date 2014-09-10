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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.eu.evidence.rtdruid.vartree.data.DataPackage
 * @generated
 */
public class DataSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DataPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSwitch() {
		if (modelPackage == null) {
			modelPackage = DataPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DataPackage.SYSTEM: {
				com.eu.evidence.rtdruid.vartree.data.System system = (com.eu.evidence.rtdruid.vartree.data.System)theEObject;
				T result = caseSystem(system);
				if (result == null) result = caseObjectWithID(system);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.OBJECT_WITH_ID: {
				ObjectWithID objectWithID = (ObjectWithID)theEObject;
				T result = caseObjectWithID(objectWithID);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.MODES: {
				Modes modes = (Modes)theEObject;
				T result = caseModes(modes);
				if (result == null) result = caseObjectWithID(modes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.MODE: {
				Mode mode = (Mode)theEObject;
				T result = caseMode(mode);
				if (result == null) result = caseObjectWithID(mode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.FUNCTIONAL: {
				Functional functional = (Functional)theEObject;
				T result = caseFunctional(functional);
				if (result == null) result = caseObjectWithID(functional);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.IMPLEMENTATION: {
				Implementation implementation = (Implementation)theEObject;
				T result = caseImplementation(implementation);
				if (result == null) result = caseSystemImplementation(implementation);
				if (result == null) result = caseObjectWithID(implementation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.PROC: {
				Proc proc = (Proc)theEObject;
				T result = caseProc(proc);
				if (result == null) result = caseImplementation(proc);
				if (result == null) result = caseSystemImplementation(proc);
				if (result == null) result = caseObjectWithID(proc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.ARCHITECTURAL: {
				Architectural architectural = (Architectural)theEObject;
				T result = caseArchitectural(architectural);
				if (result == null) result = caseObjectWithID(architectural);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.MAPPING: {
				Mapping mapping = (Mapping)theEObject;
				T result = caseMapping(mapping);
				if (result == null) result = caseObjectWithID(mapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.ANNOTATION: {
				Annotation annotation = (Annotation)theEObject;
				T result = caseAnnotation(annotation);
				if (result == null) result = caseObjectWithID(annotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.SCHEDULABILITY: {
				Schedulability schedulability = (Schedulability)theEObject;
				T result = caseSchedulability(schedulability);
				if (result == null) result = caseObjectWithID(schedulability);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.VAR: {
				Var var = (Var)theEObject;
				T result = caseVar(var);
				if (result == null) result = caseImplementation(var);
				if (result == null) result = caseSystemImplementation(var);
				if (result == null) result = caseObjectWithID(var);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.TRIGGER: {
				Trigger trigger = (Trigger)theEObject;
				T result = caseTrigger(trigger);
				if (result == null) result = caseSystemImplementation(trigger);
				if (result == null) result = caseObjectWithID(trigger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.EVENT: {
				Event event = (Event)theEObject;
				T result = caseEvent(event);
				if (result == null) result = caseObjectWithID(event);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.PARTIAL_ORDER: {
				PartialOrder partialOrder = (PartialOrder)theEObject;
				T result = casePartialOrder(partialOrder);
				if (result == null) result = caseObjectWithID(partialOrder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.SYSTEM_IMPLEMENTATION: {
				SystemImplementation systemImplementation = (SystemImplementation)theEObject;
				T result = caseSystemImplementation(systemImplementation);
				if (result == null) result = caseObjectWithID(systemImplementation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.SUB_SYSTEM: {
				SubSystem subSystem = (SubSystem)theEObject;
				T result = caseSubSystem(subSystem);
				if (result == null) result = caseImplementation(subSystem);
				if (result == null) result = caseSystemImplementation(subSystem);
				if (result == null) result = caseObjectWithID(subSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.TIME_CONST: {
				TimeConst timeConst = (TimeConst)theEObject;
				T result = caseTimeConst(timeConst);
				if (result == null) result = caseObjectWithID(timeConst);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.METHOD_REF: {
				MethodRef methodRef = (MethodRef)theEObject;
				T result = caseMethodRef(methodRef);
				if (result == null) result = caseObjectWithID(methodRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.PROVIDED_INTERFACE: {
				ProvidedInterface providedInterface = (ProvidedInterface)theEObject;
				T result = caseProvidedInterface(providedInterface);
				if (result == null) result = caseObjectWithID(providedInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.REQUIRED_INTERFACE: {
				RequiredInterface requiredInterface = (RequiredInterface)theEObject;
				T result = caseRequiredInterface(requiredInterface);
				if (result == null) result = caseObjectWithID(requiredInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.ORDER: {
				Order order = (Order)theEObject;
				T result = caseOrder(order);
				if (result == null) result = caseObjectWithID(order);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.TIME_CONST_ELEMENT: {
				TimeConstElement timeConstElement = (TimeConstElement)theEObject;
				T result = caseTimeConstElement(timeConstElement);
				if (result == null) result = caseObjectWithID(timeConstElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.ECU: {
				Ecu ecu = (Ecu)theEObject;
				T result = caseEcu(ecu);
				if (result == null) result = caseObjectWithID(ecu);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.TASK: {
				Task task = (Task)theEObject;
				T result = caseTask(task);
				if (result == null) result = caseObjectWithID(task);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.RESOURCE: {
				Resource resource = (Resource)theEObject;
				T result = caseResource(resource);
				if (result == null) result = caseObjectWithID(resource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.BUS: {
				Bus bus = (Bus)theEObject;
				T result = caseBus(bus);
				if (result == null) result = caseObjectWithID(bus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.FRAME: {
				Frame frame = (Frame)theEObject;
				T result = caseFrame(frame);
				if (result == null) result = caseObjectWithID(frame);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.SIGNAL: {
				Signal signal = (Signal)theEObject;
				T result = caseSignal(signal);
				if (result == null) result = caseObjectWithID(signal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.MUTEX: {
				Mutex mutex = (Mutex)theEObject;
				T result = caseMutex(mutex);
				if (result == null) result = caseObjectWithID(mutex);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.CPU: {
				Cpu cpu = (Cpu)theEObject;
				T result = caseCpu(cpu);
				if (result == null) result = caseObjectWithID(cpu);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.RTOS: {
				Rtos rtos = (Rtos)theEObject;
				T result = caseRtos(rtos);
				if (result == null) result = caseObjectWithID(rtos);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.SCHEDULING: {
				Scheduling scheduling = (Scheduling)theEObject;
				T result = caseScheduling(scheduling);
				if (result == null) result = caseObjectWithID(scheduling);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.ACTIVATION: {
				Activation activation = (Activation)theEObject;
				T result = caseActivation(activation);
				if (result == null) result = caseObjectWithID(activation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.RESOURCE_REF: {
				ResourceRef resourceRef = (ResourceRef)theEObject;
				T result = caseResourceRef(resourceRef);
				if (result == null) result = caseObjectWithID(resourceRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.MUTEX_REF: {
				MutexRef mutexRef = (MutexRef)theEObject;
				T result = caseMutexRef(mutexRef);
				if (result == null) result = caseObjectWithID(mutexRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.EXEC_TIME: {
				ExecTime execTime = (ExecTime)theEObject;
				T result = caseExecTime(execTime);
				if (result == null) result = caseObjectWithID(execTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.EXEC_TIME_LIST: {
				ExecTimeList execTimeList = (ExecTimeList)theEObject;
				T result = caseExecTimeList(execTimeList);
				if (result == null) result = caseObjectWithID(execTimeList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.DISTRIBUTION: {
				Distribution distribution = (Distribution)theEObject;
				T result = caseDistribution(distribution);
				if (result == null) result = caseObjectWithID(distribution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.SAMPLE: {
				Sample sample = (Sample)theEObject;
				T result = caseSample(sample);
				if (result == null) result = caseObjectWithID(sample);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.PROC_MAP: {
				ProcMap procMap = (ProcMap)theEObject;
				T result = caseProcMap(procMap);
				if (result == null) result = caseObjectWithID(procMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.TASK_MAP: {
				TaskMap taskMap = (TaskMap)theEObject;
				T result = caseTaskMap(taskMap);
				if (result == null) result = caseObjectWithID(taskMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.VAR_MAP: {
				VarMap varMap = (VarMap)theEObject;
				T result = caseVarMap(varMap);
				if (result == null) result = caseObjectWithID(varMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.SCHEDULING_SCENARIO: {
				SchedulingScenario schedulingScenario = (SchedulingScenario)theEObject;
				T result = caseSchedulingScenario(schedulingScenario);
				if (result == null) result = caseObjectWithID(schedulingScenario);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.CPU_SCHED: {
				CpuSched cpuSched = (CpuSched)theEObject;
				T result = caseCpuSched(cpuSched);
				if (result == null) result = caseObjectWithID(cpuSched);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.TASK_SCHED: {
				TaskSched taskSched = (TaskSched)theEObject;
				T result = caseTaskSched(taskSched);
				if (result == null) result = caseObjectWithID(taskSched);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.CACHE_MISS_COST_LIST: {
				CacheMissCostList cacheMissCostList = (CacheMissCostList)theEObject;
				T result = caseCacheMissCostList(cacheMissCostList);
				if (result == null) result = caseObjectWithID(cacheMissCostList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.CACHE_MISS_COST: {
				CacheMissCost cacheMissCost = (CacheMissCost)theEObject;
				T result = caseCacheMissCost(cacheMissCost);
				if (result == null) result = caseObjectWithID(cacheMissCost);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.FIELD: {
				Field field = (Field)theEObject;
				T result = caseField(field);
				if (result == null) result = caseObjectWithID(field);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.TYPE: {
				Type type = (Type)theEObject;
				T result = caseType(type);
				if (result == null) result = caseObjectWithID(type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.OS_APPLICATION: {
				OsApplication osApplication = (OsApplication)theEObject;
				T result = caseOsApplication(osApplication);
				if (result == null) result = caseObjectWithID(osApplication);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.COM: {
				Com com = (Com)theEObject;
				T result = caseCom(com);
				if (result == null) result = caseObjectWithID(com);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.SPIN_LOCK: {
				SpinLock spinLock = (SpinLock)theEObject;
				T result = caseSpinLock(spinLock);
				if (result == null) result = caseObjectWithID(spinLock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataPackage.SCHEDULE_TABLE: {
				ScheduleTable schedulingTable = (ScheduleTable)theEObject;
				T result = caseScheduleTable(schedulingTable);
				if (result == null) result = caseObjectWithID(schedulingTable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystem(com.eu.evidence.rtdruid.vartree.data.System object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object With ID</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object With ID</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectWithID(ObjectWithID object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modes</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modes</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModes(Modes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mode</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMode(Mode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Functional</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Functional</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctional(Functional object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImplementation(Implementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Proc</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proc</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProc(Proc object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Architectural</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Architectural</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArchitectural(Architectural object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapping(Mapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotation(Annotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Schedulability</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Schedulability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedulability(Schedulability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVar(Var object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trigger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrigger(Trigger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvent(Event object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Partial Order</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partial Order</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartialOrder(PartialOrder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Implementation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemImplementation(SystemImplementation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubSystem(SubSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Const</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Const</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeConst(TimeConst object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodRef(MethodRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Provided Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Provided Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProvidedInterface(ProvidedInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Required Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Required Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequiredInterface(RequiredInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Order</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Order</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrder(Order object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Const Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Const Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeConstElement(TimeConstElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecu</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecu</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEcu(Ecu object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTask(Task object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResource(Resource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bus</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBus(Bus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Frame</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Frame</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFrame(Frame object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Signal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Signal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSignal(Signal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mutex</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mutex</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMutex(Mutex object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cpu</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cpu</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCpu(Cpu object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rtos</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rtos</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRtos(Rtos object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduling</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduling</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScheduling(Scheduling object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivation(Activation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceRef(ResourceRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mutex Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mutex Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMutexRef(MutexRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exec Time</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exec Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecTime(ExecTime object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exec Time List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exec Time List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecTimeList(ExecTimeList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Distribution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Distribution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDistribution(Distribution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sample</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sample</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSample(Sample object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Proc Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proc Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcMap(ProcMap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskMap(TaskMap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVarMap(VarMap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduling Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduling Scenario</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedulingScenario(SchedulingScenario object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cpu Sched</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cpu Sched</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCpuSched(CpuSched object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Sched</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Sched</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskSched(TaskSched object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cache Miss Cost List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cache Miss Cost List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCacheMissCostList(CacheMissCostList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cache Miss Cost</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cache Miss Cost</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCacheMissCost(CacheMissCost object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseField(Field object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Os Application</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Os Application</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOsApplication(OsApplication object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Com</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Com</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCom(Com object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Spin Lock</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Spin Lock</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpinLock(SpinLock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduling Table</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduling Table</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScheduleTable(ScheduleTable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DataSwitch
