/*
 * Created on 15-mar-2004
 *
 * $Id: Search.java,v 1.8 2008/05/14 17:10:15 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.tools;

import java.util.ArrayList;
import java.util.LinkedList;

import org.eclipse.core.runtime.Assert;

import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IMultiValues;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

/**
 * @author Nicola Serreli
 */
public final class Search {

	/** A functional element (proc, var, subsystem, ...) */
	public static class FunctElement {
		final public String vtPath;
		final public String eviPath;

		public FunctElement(String vtPath, String eviPath) {
			this.vtPath = vtPath;
			this.eviPath = eviPath;
		}
		
		@Override
		public String toString() {
			return vtPath;
		}
	}

	public static class ArchElement {
		final public String vtPath;
		final public String name;

		public ArchElement(String vtPath, String name) {
			this.vtPath = vtPath;
			this.name = name;
		}
	}

	public static class TimeConstraintElement {
		final public String vtPath;
		final public String type;
		final public String value;
		final public String firstEvent;
		final public String secondEvent;

		public TimeConstraintElement(String vtPath, String type, String value, String firstEvent, String secondEvent) {
			this.vtPath = vtPath;
			this.type = type;
			this.value = value;
			this.firstEvent = firstEvent;
			this.secondEvent = secondEvent;
		}
	}

	public static class EventElement {
		final public String vtPath;
		final public String name;
		final public String type;
		final public String methodRef;

		public EventElement(String vtPath, String name, String type, String methodRef) {
			this.vtPath = vtPath;
			this.type = type;
			this.name = name;
			this.methodRef = methodRef;
		}
	}

	public static class MethodRefElement {
		final public String ownerVtPath;
		final public String ownerName;
		final public String name;
		final public String referedMethod;

		public MethodRefElement(String vtPath, String ownerName, String name, String referedMethod) {
			this.ownerVtPath = vtPath;
			this.ownerName = ownerName;
			this.name = name;
			this.referedMethod = referedMethod;
		}
	}

	public static final int SIGNAL_TYPE_EVENT = 1;
	public static final int SIGNAL_TYPE_COUNTER = 2;
	public static final int SIGNAL_TYPE_ALARM = 4;
//	public static final String SIGNAL_TYPE_EVENT = DPKG.getEvent().getName();

	

	/** Abbreviation for VarTree.SEPARATOR */
	private final static char S = IVarTree.SEPARATOR;

	private final static DataPackage DPKG = DataPackage.eINSTANCE;

	private static final String SYSTEM = DPKG.getSystem().getName();
	private static final String ANNOTATION = DPKG.getSystem_Annotation()
			.getName();

	private static final String ARCHITECTURAL = DPKG.getSystem_Architectural()
			.getName();

	private static final String CPU = DPKG.getCpu().getName();
	private static final String CPU_LIST = DPKG.getEcu_CpuList().getName();

	private static final String ECU = DPKG.getEcu().getName();
	private static final String ECU_LIST = DPKG.getArchitectural_EcuList()
			.getName();

	private static final String OS_APPLICATION = DPKG.getOsApplication().getName();
	private static final String OS_APPLICATION_LIST = DPKG.getCpu_OsApplication().getName();
	
	private static final String EVENT = DPKG.getEvent().getName();
	private static final String EVENT_TYPE = DPKG.getEvent_Type().getName();
	private static final String EVENT_METHODREF = DPKG.getEvent_MethodRefName().getName();
	private static final String EVENT_LIST = DPKG.getFunctional_EventList()
			.getName();

	private static final String EXEC_TIME = DPKG.getExecTime().getName();
	private static final String EXEC_TIME_ITEM_LIST = DPKG
			.getExecTimeList_ExecTimeItemsList().getName();
	// private static final String EXEC_TIME_LIST =
	// DPKG.getExecTimeList().getName();
	private static final String EXEC_TIME_LISTS = DPKG
			.getAnnotation_ExecTimeLists().getName();

	private static final String FUNCTIONAL = DPKG.getSystem_Functional()
			.getName();

	private static final String IMPLEMENTATION = DPKG
			.getFunctional_Implementation().getName();

	private static final String SUBSYSTEM = DPKG.getSubSystem().getName();
	private static final String SUB_SYS_IMPLEMENTATION = DPKG
			.getSubSystem_Implementation().getName();

	private static final String METHODS = DPKG.getProc_Methods().getName();
	// private static final String PROC_METHODS =
	// DPKG.getProc_Methods().getName();
	// private static final String VAR_METHODS =
	// DPKG.getVar_Methods().getName();

	private static final String METHOD_REF = DPKG.getMethodRef().getName();

	// PROC, TRIGGER, ....
	private static final String METHOD_REF_LIST = DPKG.getProc_MethodRefList()
			.getName();
	private static final String REFERED_METHOD = DPKG.getMethodRef_MethodName().getName();

	// SYSTEM, PROC, TRIGGER, RTOS, ....
	private static final String NAME = DPKG.getSystem_Name().getName();

	private static final String PROC = DPKG.getProc().getName();

	private static final String PROVIDED_INTERFACE = DPKG
			.getProvidedInterface().getName();
	private static final String PROVIDED_INTERFACE_LIST = DPKG
			.getSubSystem_ProvidedInterfaceList().getName();

	public static final String RUN = "run";
	public static final String READ = "read";
	public static final String WRITE = "write";

	public static final String OS_ACTIVATE_TASK = "activate_task";
	public static final String OS_TERMINATE_TASK = "terminate_task";
	public static final String OS_CONTEXT_SWITCH = "context_switch";
	public static final String OS_CONTEXT_SWITCH_cachePenalty = "context_switch_cachePenalty";

	
	private static final String RESOURCE = DPKG.getResource().getName();
	private static final String RESOURCE_LIST = DPKG
			.getArchitectural_ResourceList().getName();

	private static final String REQUIRED_INTERFACE = DPKG
			.getRequiredInterface().getName();
	private static final String REQUIRED_INTERFACE_LIST = DPKG
			.getSubSystem_RequiredInterfaceList().getName();

	private static final String RTOS = DPKG.getRtos().getName();

	private static final String TRIGGER = DPKG.getTrigger().getName();
	private static final String TRIGGER_METHOD_REFS = DPKG.getTrigger_MethodRefList().getName();
	
	private static final String TIME_FCONSTR = DPKG.getFunctional_TimeConstList().getName();
//	private static final String TIME_CONSTR = DPKG.getTimeConst().getName();
	private static final String TIME_CONSTR_LIST = DPKG.getTimeConst_TimeConstElementList().getName();
	private static final String TIME_CONSTR_ELEMENT = DPKG.getTimeConstElement().getName();
	private static final String TIME_CONSTR_BOUND = DPKG.getTimeConstElement_BoundType().getName();
	private static final String tIME_CONSTR_VALUE = DPKG.getTimeConstElement_BoundValue().getName();
	private static final String tIME_CONSTR_FIRST = DPKG.getTimeConstElement_FirstEvent().getName();
	private static final String tIME_CONSTR_SECOND = DPKG.getTimeConstElement_SecondEvent().getName();

	private static final String VAR = DPKG.getVar().getName();

	// ----------------------------- Trigger
	
	/**
	 * Search a trigger using its identificator a path ( [subsystem/]triggerName).
	 * Returns the path to trigger
	 * 
	 * @param ti
	 *            current data repository
	 * @param system
	 *            the system path (with protection)
	 * @param triggerId
	 *            the trigger identificator (writed using Evidence path rules)
	 * 
	 * @return the path of required trigger, null if not found
	 * 
	 * @throws NullPointerException
	 *             if system or triggerId is null
	 * */
	public static String aTrigger(ITreeInterface ti, String system, String triggerId) {
		if (system == null || triggerId == null) {
			throw new NullPointerException(
					"Required a not null system and trigger identificators");
		}
		String prefix = system + S + FUNCTIONAL + S + IMPLEMENTATION + S
					+ triggerId;
		if (!ti.exist(prefix, TRIGGER)) {
			return null; // not found !!
		}
		return prefix;
	}

	/**
	 * Search all triggers that have a reference to a specific method (
	 * [subsystem/]procName/methodName). Returns the path to trigger
	 * 
	 * @param ti
	 *            current data repository
	 * @param system
	 *            the system path (with protection)
	 * @param methodId
	 *            the method identificator (writed using Evidence path rules)
	 * 
	 * @return a vector with an element for each methodRef that points to
	 *         specified method, or an empty vector if there isn't any.
	 * 
	 * @throws NullPointerException
	 *             if system or triggerId is null
	 * */
	public static MethodRefElement[] allTriggesrForAMethod(ITreeInterface ti, String system, String methodId) {
		if (system == null || methodId == null) {
			throw new NullPointerException(
					"Required a not null system and method identificator");
		}
		String prefix = system + S + FUNCTIONAL + S + IMPLEMENTATION;
		String[] triggerNames = ti.getAllName(prefix, TRIGGER);
		
		ArrayList<MethodRefElement> answer = new ArrayList<MethodRefElement>();
		
		for (String triggerName : triggerNames) {
			
			// get all refered methods
			String triggerPath = prefix +S+ triggerName;
			ITreeInterface.TiInfo[] methodRefs = ti.getAll(
					triggerPath +S+ TRIGGER_METHOD_REFS 
					+S+ ITreeInterface.SPECIAL
					+S+ REFERED_METHOD, METHOD_REF);

			if (methodRefs == null) {
				continue;
			}
			
			for (ITreeInterface.TiInfo methodRef : methodRefs) {
				if (methodId.equals("" + methodRef.getVariable())) {
					answer.add(new MethodRefElement(triggerPath, triggerName, methodRef.getName(), methodId));
				}
			}
		}
		
		return answer.toArray( new MethodRefElement[answer.size()]);
	}
	
	/**
	 * Search all triggers.
	 * For each trigger, returns the path and the name of the trigger.
	 * 
	 * @param ti
	 *            current data repository
	 * @param system
	 *            the system path (with protection)
	 * 
	 * @return path and name of all triggers
	 * 
	 * @throws NullPointerException
	 *             if system or triggerId is null
	 * */
	public static FunctElement[] allTrigger(ITreeInterface ti, String system) {
		if (system == null) {
			throw new NullPointerException(
					"Required a not null system identificators");
		}
		String prefix = system + S + FUNCTIONAL + S + IMPLEMENTATION;
		String[] paths = ti.getAllName(prefix, TRIGGER);
		
		FunctElement[] answer = new FunctElement[paths.length];
		for (int i=0; i< paths.length; i++) {
			answer[i] = new FunctElement(prefix + S + paths[i], paths[i]);
		}
		
		return answer;
	}

	// ----------------------------- Time Constraint
	
	/**
	 * Searchs all TimeConst stored inside the tree. If no system was found, returns
	 * null, otherwise returns an array with 0 or more String that contain paths
	 * of all found TimeConst.
	 * 
	 * @param ti
	 *            current data repository
	 *
	 * @return null if NO system is found. Otherwise returns a not null array
	 *         with 0 or more path, one for each found TimeConst
	 * 
	 * @throws NullPointerException
	 *             if it is null
	 * */
	public static String[] allTimeConstraints(ITreeInterface ti) {
		return allTimeConstraints(ti, DataPath.NULL_ID);
	}
	
	public static String[] allTimeConstraints(ITreeInterface ti, String modeRef) {
		Assert.isNotNull(ti, "expected a not null tree");
		
		if (modeRef == null) {
			modeRef = DataPath.NULL_ID;
		}
	
		String[] tmp = ti.getAllName(null, SYSTEM);
		if (tmp.length == 0) {
			// Messages.sendWarning("No System found", null, "", null);
			return null;
		}
		
		String prefix = tmp[0] + S + FUNCTIONAL + S + TIME_FCONSTR + S + modeRef + S + TIME_CONSTR_LIST;

		
		String[] paths = ti.getAllName(prefix, TIME_CONSTR_ELEMENT);
		for (int i=0; i< paths.length; i++) {
			paths[i] = prefix + S + paths[i];
		}

		return paths;
	}
	
	
	/**
	 * Searchs all data related to all TimeConst stored inside the tree. If no system was found, returns
	 * null, otherwise returns an array with 0 or more String that contain paths
	 * of all found TimeConst.
	 * Uses default mode.
	 * 
	 * @param ti
	 *            current data repository
	 *
	 * @return null if NO system is found. Otherwise returns a not null array
	 *         with 0 or more elements, one for each found TimeConst
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static TimeConstraintElement[] allTimeConstsData(ITreeInterface ti) {
		return allTimeConstsData(ti, null, null);
	}

	/**
	 * Searchs all data related to all TimeConst stored inside the tree. If no system was found, returns
	 * null, otherwise returns an array with 0 or more String that contain paths
	 * of all found TimeConst
	 * 
	 * @param ti
	 *            current data repository
	 * @param modeRef
	 *            the PartialOrder mode (Evidence reference)
	 * 
	 * @return null if NO system is found. Otherwise returns a not null array
	 *         with 0 or more element, one for each found TimeConst
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static TimeConstraintElement[] allTimeConstsData(ITreeInterface ti, String modeRef, String boundType) {
		String[] timesRoot = allTimeConstraints(ti, modeRef);

		ArrayList<TimeConstraintElement> elements = new ArrayList<TimeConstraintElement>();
		
		for (String root: timesRoot) {
			
			String bound = getString(ti, root + S + TIME_CONSTR_BOUND);
			
			if (boundType == null || boundType.equals(bound)) {
			
				String value = getString(ti, root + S + tIME_CONSTR_VALUE);
				String first = getString(ti, root + S + tIME_CONSTR_FIRST);
				String second = getString(ti, root + S + tIME_CONSTR_SECOND);
				
				elements.add(new TimeConstraintElement(root, bound, value, first, second));
			}
		}
		
		return elements.toArray(new TimeConstraintElement[elements.size()]);
	}
	
	/**
	 * Searchs all data related to all TimeConst related to a specific event. If no system was found, returns
	 * null, otherwise returns an array with 0 or more TimeConstraints
	 * 
	 * @param ti
	 *            current data repository
	 * @param modeRef
	 *            the mode
	 * @param eventName
	 *            the event name
	 * 
	 * @return null if NO system is found. Otherwise returns a not null array
	 *         with 0 or more element, one for each found TimeConst
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static TimeConstraintElement[] eventTimeConstsData(ITreeInterface ti, String modeRef, String eventName) {
		Assert.isNotNull(eventName, "expected a not null event name");
		String[] timesRoot = allTimeConstraints(ti, modeRef);

		ArrayList<TimeConstraintElement> elements = new ArrayList<TimeConstraintElement>();
		
		for (String root: timesRoot) {
			
			String bound = getString(ti, root + S + TIME_CONSTR_BOUND);
			
			String value = getString(ti, root + S + tIME_CONSTR_VALUE);
			String first = getString(ti, root + S + tIME_CONSTR_FIRST);
			String second = getString(ti, root + S + tIME_CONSTR_SECOND);

			if (eventName.equals(first) || eventName.equals(second)) {
				elements.add(new TimeConstraintElement(root, bound, value, first, second));
			}
		}
		
		return elements.toArray(new TimeConstraintElement[elements.size()]);
	}
	
	// ----------------------------- Var

	/**
	 * Search a var using its identificator a path ( [subsystem/]varName).
	 * Returns the path to var
	 * 
	 * @param ti
	 *            current data repository
	 * @param system
	 *            the system path (with protection)
	 * @param varId
	 *            the proc identificator (writed using Evidence path rules)
	 * 
	 * @return the path of required var, null if not found
	 * 
	 * @throws NullPointerException
	 *             if system or varId is null
	 * */
	public static String aVar(ITreeInterface ti, String system, String varId) {
		if (system == null || varId == null) {
			throw new NullPointerException(
					"Required a not null system and var identificators");
		}

		// search path to subsystem
		String prefix = varPrefix(ti, system, varId);
		varId = Utility.pathToVarTree(varId);

		// subsystem not found
		if (prefix == null) {
			return null;
		}
		String[] tmpPath = DataPath.splitPath(varId);
		prefix += S + IMPLEMENTATION + S
				+ DataPath.addSlash(tmpPath[tmpPath.length - 1]);
		if (!ti.exist(prefix, VAR)) {
			return null; // not found !!
		}
		return prefix;
	}

	/**
	 * Search a var using its identificator a path ( [subsystem/]varName). If
	 * given proc is a global proc, this method returns "systemName/Functional",
	 * else returns the path to subsystem.
	 * 
	 * @param ti
	 *            current data repository
	 * @param system
	 *            the system path (with protection)
	 * @param varId
	 *            the proc identificator (writed using Evidence path rules)
	 * 
	 * @return the path of owner system or subSystem, null if there isn't a var
	 *         with given identificator
	 * 
	 * @throws NullPointerException
	 *             if system or varId is null
	 * */
	public static String varPrefix(ITreeInterface ti, String system,
			String varId) {
		if (system == null || varId == null) {
			throw new NullPointerException(
					"Required a not null system and var identificators");
		}
		varId = Utility.pathToVarTree(varId);

		// split identificator
		String[] tmpPath = DataPath.splitPath(varId);

		String prefix = system + S + FUNCTIONAL;
		// search subsystem (nested)
		for (int i = 0; (i + 1) < tmpPath.length; i++) {
			prefix += S + IMPLEMENTATION + S + DataPath.addSlash(tmpPath[i]);
			// prefix += S + IMPLEMENTATION + S + tmpPath[i];
			if (!ti.exist(prefix, Utility.T_SUBSYSTEM)) {
				return null; // not found !!
			}
		}
		return prefix;
	}

	/**
	 * Search a var in local subsystem
	 * 
	 * @param ti
	 *            current data repository
	 * @param subSystem
	 *            the subSystem path (with protection)
	 * @param varName
	 *            the var name (without protection, see
	 *            {@link rtdruid.vartree.IVarTree#addSlash
	 *            rtdruid.vartree.VarTree.addSlash()})
	 * 
	 * @return the path of required var, null if not found
	 * 
	 * @throws NullPointerException
	 *             if subSystem or varName is null
	 * */
	public static String aLocalVar(ITreeInterface ti, String subSystem,
			String varName) {
		if (subSystem == null || varName == null) {
			throw new NullPointerException(
					"Required a not null subSystem and var names");
		}
		String path = subSystem + S + IMPLEMENTATION + S
				+ DataPath.addSlash(varName);
		return ti.exist(path, VAR) ? path : (String) null;
	}

	// ----------------------------- Proc

	/**
	 * Search a proc using its identificator a path ( [subsystem/]procName).
	 * Returns the path to proc
	 * 
	 * @param ti
	 *            current data repository
	 * @param system
	 *            the system path (with protection)
	 * @param procId
	 *            the proc identificator (writed using Evidence path rules)
	 * 
	 * @return the path of required proc, null if not found
	 * 
	 * @throws NullPointerException
	 *             if system or procId is null
	 * */
	public static String aProc(ITreeInterface ti, String system, String procId) {
		if (system == null || procId == null) {
			throw new NullPointerException(
					"Required a not null system and proc identificators");
		}
		// search path to subsystem
		String prefix = procPrefix(ti, system, procId);
		procId = Utility.pathToVarTree(procId);

		// subsystem not found
		if (prefix == null) {
			return null;
		}
		String[] tmpPath = DataPath.splitPath(procId);
		prefix += S + IMPLEMENTATION + S
				+ DataPath.addSlash(tmpPath[tmpPath.length - 1]);
		if (!ti.exist(prefix, PROC)) {
			return null; // not found !!
		}
		return prefix;
	}

	/**
	 * Search a proc using its identificator a path ( [subsystem/]procName). If
	 * given proc is a global proc, this method returns "systemName/Functional",
	 * else returns the path to subsystem.
	 * 
	 * @param ti
	 *            current data repository
	 * @param system
	 *            the system path (with protection)
	 * @param procId
	 *            the proc identificator (writed using Evidence path rules)
	 * 
	 * @return the path of owner system or subSystem, null if there isn't a proc
	 *         with given identificator
	 * 
	 * @throws NullPointerException
	 *             if system or procId is null
	 */
	public static String procPrefix(ITreeInterface ti, String system,
			String procId) {
		if (system == null || procId == null) {
			throw new NullPointerException(
					"Required a not null system and proc identificators");
		}
		procId = Utility.pathToVarTree(procId);

		// split identificator
		String[] tmpPath = DataPath.splitPath(procId);

		String prefix = system + S + FUNCTIONAL;
		// search subsystem (nested)
		for (int i = 0; (i + 1) < tmpPath.length; i++) {
			prefix += S + IMPLEMENTATION + S + DataPath.addSlash(tmpPath[i]);
			// prefix += S + IMPLEMENTATION + S + tmpPath[i];
			if (!ti.exist(prefix, Utility.T_SUBSYSTEM)) {
				return null; // not found !!
			}
		}
		if (!ti.exist(prefix + S + IMPLEMENTATION + S
				+ DataPath.addSlash(tmpPath[tmpPath.length - 1]), PROC)) {
			return null;
		}
		return prefix;
	}

	/**
	 * @param ti
	 *            current data repository
	 * @param subSystem
	 *            the subSystem path (with protection)
	 * @param procName
	 *            the proc name (writed using Evidence path rules)
	 * 
	 * @return the path of required proc, null if not found
	 * 
	 * @throws NullPointerException
	 *             if subSystem or procName is null
	 * */
	public static String aLocalProc(ITreeInterface ti, String subSystem,
			String procName) {
		if (subSystem == null || procName == null) {
			throw new NullPointerException(
					"Required a not null subSystem and proc names");
		}
		String path = subSystem + S + IMPLEMENTATION + S
				+ DataPath.addSlash(procName);
		return ti.exist(path, PROC) ? path : (String) null;
	}

	// ----------------------------- Method

	/**
	 * Search a Method using its identificator as path (
	 * [subsystem/]objName/methodName). ObjName is a subSystem or a Proc or a
	 * Var Returns the path to method owner.
	 * 
	 * @param ti
	 *            current data repository
	 * @param system
	 *            the system path (with protection)
	 * @param methodName
	 *            the method identificator (writed using Evidence path rules)
	 * 
	 * @return the path of method owner, null if not found
	 * 
	 * @throws NullPointerException
	 *             if system or methodName is null
	 */
	public static String aMethod(ITreeInterface ti, String system,
			String methodName) {
		if (system == null || methodName == null) {
			throw new NullPointerException(
					"Required a not null subSystem and proc names");
		}
		// search path to subsystem
		String prefix = methodPrefix(ti, system, methodName);
		methodName = Utility.pathToVarTree(methodName);

		// subsystem not found
		if (prefix == null) {
			return null;
		}

		// split identificator
		String[] tmpPath = DataPath.splitPath(methodName);
		if (tmpPath.length == 1) { // nothing to do !!!
			throw new IllegalArgumentException(
					"Required an method identificator with at least an objName and method name ("
							+ methodName + ")");
		}

		String risp = prefix + S + IMPLEMENTATION + S
				+ DataPath.addSlash(tmpPath[tmpPath.length - 2]);
		String tmpMethod = DataPath.removeSlash(tmpPath[tmpPath.length - 1]);

		// owner is a var ...
		if (ti.exist(risp, VAR)) {
			if (READ.equalsIgnoreCase(tmpMethod)
					|| WRITE.equalsIgnoreCase(tmpMethod))
				return risp;

			String[] methods = ((IMultiValues) ti.getValue(risp + S + METHODS))
					.getValues();

			for (int jj = 0; jj < methods.length; jj++) {
				if (tmpMethod.equals(methods[jj])) {
					return risp;
				}
			}
		}

		// ... or a proc?
		if (ti.exist(risp, PROC)) {
			// if ("run".equalsIgnoreCase(tmpPath[1])) return risp;
			if (RUN.equalsIgnoreCase(tmpMethod))
				return risp;

			String[] methods = ((IMultiValues) ti.getValue(risp + S + METHODS))
					.getValues();

			for (int jj = 0; jj < methods.length; jj++) {
				if (tmpMethod.equals(methods[jj])) {
					return risp;
				}
			}
		}

		// owner is a subSystem?
		// risp = subSystem + S + IMPLEMENTATION + S +
		// VarTree.addSlash(tmpPath[0]);
		if (ti.exist(risp, Utility.T_SUBSYSTEM)) {
			// search a provided interface
			String risp2 = risp + S + PROVIDED_INTERFACE_LIST + S
					+ tmpPath[tmpPath.length - 1];
			if (ti.exist(risp2, PROVIDED_INTERFACE)) {
				return risp;
			}

			// search a required interface
			risp2 = risp + S + REQUIRED_INTERFACE_LIST + S
					+ tmpPath[tmpPath.length - 1];
			if (ti.exist(risp2, REQUIRED_INTERFACE)) {
				return risp;
			}

		}

		// not found
		return null;
	}

	/**
	 * Search a Method in given subSystem, using its identificator as path (
	 * objName/methodName). ObjName is a subSystem or a Proc or a Var Returns
	 * the path to method owner.
	 * 
	 * @param ti
	 *            current data repository
	 * @param subSystem
	 *            the system path (with protection)
	 * @param methodName
	 *            a methodIdentificator (writed using Evidence path rules)
	 * 
	 * @return the path of method owner, null if not found
	 * 
	 * @throws NullPointerException
	 *             if subSystem or methodName is null
	 */
	public static String aLocalMethod(ITreeInterface ti, String subSystem,
			String methodName) {
		if (subSystem == null || methodName == null) {
			throw new NullPointerException(
					"Required a not null subSystem and method identificators");
		}
		
		String prefix_tmp = methodPrefix(ti, Search.systemName(ti), methodName);

		
		methodName = Utility.pathToVarTree(methodName);

		// split identificator
		String[] tmpPath = DataPath.splitPath(methodName);
		if (tmpPath.length != 2 || tmpPath[0] == null || tmpPath[1] == null) { // nothing
																				// to
																				// do
																				// !!!
			
			if (DataPath.makePath(DataPath.splitPath(subSystem)).equals(prefix_tmp)) {
				tmpPath = new String[] {tmpPath[tmpPath.length -2], tmpPath[tmpPath.length -1]};
			} else {
				
				throw new IllegalArgumentException(
						"Required an method identificator with a objName and method name ("
								+ methodName + ")");
			}
		}

		boolean localName = false;
		boolean sysImpl = false;
		{ // check for illegal names
			String[] subPath = DataPath.splitPath(subSystem);
			localName = !sysImpl
					&& tmpPath[0].equals(subPath[subPath.length - 1]);
		}

		String risp = subSystem + S + IMPLEMENTATION + S
				+ DataPath.addSlash(tmpPath[0]);
		String tmpMethod = DataPath.removeSlash(tmpPath[1]);

		// owner is a var ...
		if (ti.exist(risp, VAR)) {
			if (localName) { // the same name for a var and for local subSystem
				throw new IllegalStateException(
						"The same name is used for a var and for its parent subSystem ("
								+ methodName + ")");
			}
			if (READ.equalsIgnoreCase(tmpMethod)
					|| WRITE.equalsIgnoreCase(tmpMethod))
				return risp;

			String[] methods = ((IMultiValues) ti.getValue(risp + S + METHODS))
					.getValues();

			for (int jj = 0; jj < methods.length; jj++) {
				if (tmpMethod.equals(methods[jj])) {
					return risp;
				}
			}
		}

		// ... or a proc?
		if (ti.exist(risp, PROC)) {
			if (localName) { // the same name for a proc and for local subSystem
				throw new IllegalStateException(
						"The same name is used for a proc and for its parent subSystem ("
								+ methodName + ")");
			}
			// if ("run".equalsIgnoreCase(tmpPath[1])) return risp;

			String[] methods = ((IMultiValues) ti.getValue(risp + S + METHODS))
					.getValues();

			for (int jj = 0; jj < methods.length; jj++) {
				if (tmpMethod.equals(methods[jj])) {
					return risp;
				}
			}
		}

		// owner is a subSystem?
		// risp = subSystem + S + IMPLEMENTATION + S + tmpPath[0];
		if (ti.exist(risp, Utility.T_SUBSYSTEM)) {
			if (localName) { // the same name for a subSystem and for local
								// subSystem
				throw new IllegalStateException(
						"The same name is used for a subSystem and for its parent subSystem ("
								+ methodName + ")");
			}
			// search a provided interface
			String risp2 = risp + S + PROVIDED_INTERFACE_LIST + S
					+ DataPath.addSlash(tmpPath[1]);
			if (ti.exist(risp2, PROVIDED_INTERFACE)) {
				return risp;
			}
			// not found
			return null;
		}

		// Is current prefix a subSystem?
		if (!ti.exist(subSystem, Utility.T_SUBSYSTEM))
			return null;

		// ... and is it the method owner?
		String[] prefixPath = DataPath.splitPath(subSystem);
		if (!tmpPath[0].equals(prefixPath[prefixPath.length - 1]))
			return null;

		// ... search in requiredInterface
		risp = subSystem + S + REQUIRED_INTERFACE_LIST + S
				+ DataPath.addSlash(tmpPath[1]);
		if (ti.exist(risp, REQUIRED_INTERFACE)) {
			return subSystem;
		}
		return null;
	}

	// - -- - - - - - -

	/**
	 * Searchs the implementation section that contains a method (or methodRef)
	 * using its identificator ( [subsystem/]objName/methodName) or (
	 * [subsystem/]objName/methodRefName).
	 * 
	 * @param ti
	 *            current data repository
	 * @param system
	 *            the system path (with protection)
	 * @param methodName
	 *            the method identificator (without protection, see
	 *            {@link rtdruid.vartree.IVarTree#addSlash
	 *            rtdruid.vartree.VarTree.addSlash()})
	 * 
	 * @return the path of implementation section that contains owner object,
	 *         null if there isn't an element of with given identificator (path)
	 * 
	 * @throws NullPointerException
	 *             if system or identificator is null
	 */
	public static String methodPrefix(ITreeInterface ti, String system,
			String identificator) {
		if (system == null || identificator == null) {
			throw new NullPointerException(
					"Required a not null system and method identificators");
		}
		identificator = Utility.pathToVarTree(identificator);

		// split identificator
		String[] tmpPath = DataPath.splitPath(identificator);
		if (tmpPath.length < 2) { // nothing to do !!!
			throw new IllegalArgumentException(
					"Required an method identificator with at least objName and method name  ("
							+ identificator + ")");
		}

		String prefix = system + S + FUNCTIONAL;
		// search subsystem (nested)
		for (int i = 0; (i + 2) < tmpPath.length; i++) {
			prefix += S + IMPLEMENTATION + S + DataPath.addSlash(tmpPath[i]);
			if (!ti.exist(prefix, Utility.T_SUBSYSTEM)) {
				return null; // not found !!
			}
		}
		return prefix;
	}

	// ----------------------------- Method

	/**
	 * Searchs the Architectural resource that contains a method, using its
	 * identificator ( resourceName/methodName).
	 * 
	 * @param ti
	 *            current data repository
	 * @param system
	 *            the system path (with protection)
	 * @param method
	 *            the method identificator ( resourceName/methodName)
	 * 
	 * @return the path of Architectural resource, null if there isn't any
	 *         resource with given id and method
	 * 
	 * @throws NullPointerException
	 *             if system or identificator is null
	 */
	public static String aResourceMethod(ITreeInterface ti, String system,
			String method) {
		if (system == null || method == null) {
			throw new NullPointerException(
					"Required a not null system and method's name");
		}
		method = Utility.pathToVarTree(method);

		String[] tmpPath = DataPath.splitPath(method);
		if (tmpPath.length != 2) {
			String temp[] = new String[2];
			temp[0] = tmpPath[0];
			temp[1] = "DefaultMethod";
			tmpPath = temp;
			// throw new
			// IllegalArgumentException("Required an method identificator with objName and method name  ("
			// + method + ")");
		}
		String prefix = system + S + ARCHITECTURAL + S + RESOURCE_LIST + S
				+ DataPath.addSlash(tmpPath[0]);

		// there isn't resources with this name
		if (!ti.exist(prefix, RESOURCE)) {
			return null;
		}

		String[] methods = ((IMultiValues) ti.getValue(prefix + S + METHODS))
				.getValues();
		String tmpMethod = DataPath.removeSlash(tmpPath[1]);

		if (READ.equalsIgnoreCase(tmpMethod)
				|| WRITE.equalsIgnoreCase(tmpMethod))
			return prefix;

		for (int jj = 0; jj < methods.length; jj++) {
			if (tmpMethod.equals(methods[jj])) {
				return prefix;
			}
		}

		// not found
		return null;
	}

	// ----------------------------- Method ref

	/**
	 * Search a MethodRef using its identificator as path (
	 * [subsystem/]objName/methodRefName). ObjName is a subSystem or a Proc or a
	 * Trigger Returns the path to method owner.
	 * 
	 * @param ti
	 *            current data repository
	 * @param system
	 *            the system path (with protection)
	 * @param methodRefName
	 *            the method identificator (writed using Evidence path rules)
	 * 
	 * @return the path of method owner, null if not found
	 * 
	 * @throws NullPointerException
	 *             if system or methodRefName is null
	 */
	public static String aMethodRef(ITreeInterface ti, String system,
			String methodRefName) {
		if (system == null || methodRefName == null) {
			throw new NullPointerException(
					"Required a not null system and method's name");
		}

		// search path to subsystem
		String prefix = methodPrefix(ti, system, methodRefName);
		methodRefName = Utility.pathToVarTree(methodRefName);

		// subsystem not found
		if (prefix == null) {
			return null;
		}

		// split identificator
		String[] tmpPath = DataPath.splitPath(methodRefName);
		if (tmpPath.length == 1) { // nothing to do !!!
			throw new IllegalArgumentException(
					"Required an method identificator with at least an objName and methodRef name ("
							+ methodRefName + ")");
		}

		String risp = prefix + S + IMPLEMENTATION + S
				+ tmpPath[tmpPath.length - 2];

		String tmpMethod = DataPath.addSlash(tmpPath[tmpPath.length - 1]);//DataPath.removeSlash(tmpPath[tmpPath.length - 1]);

		// owner is a trigger ...
		// if (ti.exist(risp, TRIGGER) ) {
		if (ti.exist(system + S + FUNCTIONAL + S + IMPLEMENTATION + S
				+ tmpPath[tmpPath.length - 2], TRIGGER)) {
			String risp2 = system + S + FUNCTIONAL + S + IMPLEMENTATION + S
					+ tmpPath[tmpPath.length - 2];

			if (ti.exist(risp2 + S + METHOD_REF_LIST + S + tmpMethod,
					METHOD_REF)) {
				return risp2;
			}
		}

		// ... or a proc?
		if (ti.exist(risp, PROC)) {

			if (ti
					.exist(risp + S + METHOD_REF_LIST + S + tmpMethod,
							METHOD_REF)) {
				return risp;
			}
		}

		// owner is a subSystem?
		// risp = subSystem + S + IMPLEMENTATION + S +
		// VarTree.addSlash(tmpPath[0]);
		if (ti.exist(risp, Utility.T_SUBSYSTEM)) {
			// search a provided interface -> ???

			// search a required interface
			String[] requNames = ti.getAllName(risp + S
					+ REQUIRED_INTERFACE_LIST, REQUIRED_INTERFACE);
			for (int i = 0; i < requNames.length; i++) {
				if (ti.exist(risp + S + REQUIRED_INTERFACE_LIST + S
						+ requNames[i] + S + tmpMethod, METHOD_REF)) {
					return risp;
				}
			}

		}

		// not found
		return null;
	}

	/**
	 * Search a MethodRef using its identificator as path (
	 * [subsystem/]objName/methodRefName). ObjName is a subSystem or a Proc or a
	 * Trigger.
	 * Returns the method pointed by this methodref.
	 * 
	 * @param ti
	 *            current data repository
	 * @param system
	 *            the system path (with protection)
	 * @param methodRefName
	 *            the method identificator (writed using Evidence path rules)
	 * 
	 * @return the method pointed by this methodref, null if not found
	 * 
	 * @throws NullPointerException
	 *             if system or methodRefName is null
	 */
	public static String aMethodRefMethod(ITreeInterface ti, String system,
			String methodRefName) {
		
		String prefix = aMethodRef(ti, system, methodRefName);

		String answer = null;

		if (prefix != null) { 

			String[] tmpPath = DataPath.splitPath(methodRefName);
			String tmpMethod = DataPath.removeSlash(tmpPath[tmpPath.length - 1]);
			String valuePath = prefix + S + METHOD_REF_LIST + S + tmpMethod +S + REFERED_METHOD;
			
			IVariable value = ti.getValue(valuePath);
	
			if (value != null) {
				answer = value.toString();
			}
		}

		return answer;
	}
	// ----------------------------- Event ref

	/**
	 * Search a event using its identificator. Returns the path of this event.
	 * 
	 * @param ti
	 *            current data repository
	 * @param system
	 *            the system path (with protection)
	 * @param eventName
	 *            the event identificator (writed using Evidence path rules)
	 * 
	 * @return the path of required event, null if not found
	 * 
	 * @throws NullPointerException
	 *             if system or eventName is null
	 */
	public static EventElement[] anEventsForAMethod(ITreeInterface ti, String system,
			String methodRef) {
		if (ti == null || system == null || methodRef == null) {
			throw new NullPointerException(
					"Required a not null treeinterface, system and method ref");
		}
		
		ArrayList<EventElement> answer = new ArrayList<Search.EventElement>();

		final String basePath = system + S + FUNCTIONAL + S + EVENT_LIST;
		String[] eventNames = ti.getAllName(basePath, EVENT);
		for (String eventName : eventNames) {
			
			IVariable var = ti.getValue(basePath +S+ eventName +S+ EVENT_METHODREF);
			if (var != null && methodRef.equalsIgnoreCase(var.toString())) {
				String type = "" + ti.getValue(basePath +S+ eventName +S+ EVENT_TYPE);
				answer.add(new EventElement(basePath +S+ eventName, eventName, type, methodRef));
			}
		}

		return answer.toArray(new EventElement[answer.size()]);
	}

	/**
	 * Search all events related to a method ref.
	 * 
	 * @param ti
	 *            current data repository
	 * @param system
	 *            the system path (with protection)
	 * @param methodRef
	 *            the event identificator (writed using Evidence path rules)
	 * 
	 * @return the path of required event, null if not found
	 * 
	 * @throws NullPointerException
	 *             if system or eventName is null
	 */
	public static String anEvent(ITreeInterface ti, String system,
			String eventName) {
		if (ti == null || system == null || eventName == null) {
			throw new NullPointerException(
					"Required a not null treeinterface, system and rtos' name");
		}
		eventName = DataPath.addSlash(Utility.pathToVarTree(eventName));

		String risp = system + S + FUNCTIONAL + S + EVENT_LIST + S + eventName;

		return ti.exist(risp, EVENT) ? risp : null;
	}
	

	
	// ----------------------------- RTOS REF

	/**
	 * Search a rtos using its identificator. Returns the path of all cpu that
	 * contains given rtos
	 * 
	 * @param ti
	 *            current data repository
	 * @param system
	 *            the system path (with protection)
	 * @param rtosName
	 *            the event identificator (the name and not Evidence reference)
	 * 
	 * @return all path of cpus that contain given rtos, or a zero length array
	 *         if no cpus are found
	 * 
	 * @throws NullPointerException
	 *             if system or rtosName is null
	 */
	public static String[] aRtos(ITreeInterface ti, String system,
			String rtosName) {
		if (ti == null || system == null || rtosName == null) {
			throw new NullPointerException(
					"Required a not null treeinterface, system and rtos' name");
		}
		// rtosName = Utility.pathToVarTree(rtosName);

		ArrayList<String> risp = new ArrayList<String>();

		String prefix = system + S + ARCHITECTURAL + S + ECU_LIST;

		String[] ecuNames = ti.getAllName(prefix, ECU);

		for (int i = 0; i < ecuNames.length; i++) {
			String cpuPrefix = prefix + S + ecuNames[i] + S + CPU_LIST;

			String[] cpuNames = ti.getAllName(cpuPrefix, CPU);

			for (int j = 0; j < cpuNames.length; j++) {
				String rtosPrefix = cpuPrefix + S + cpuNames[j];

				ITreeInterface.TiInfo[] rtosNames = ti.getAll(rtosPrefix + S
						+ ITreeInterface.SPECIAL + S + NAME, RTOS);

				for (int h = 0; h < rtosNames.length; h++) {

					// String ok = rtosPrefix + S + rtosNames[h];
					if (rtosName.equals(rtosNames[h].getVariable().get())) { // equals
																				// accept
																				// null
																				// values

						risp.add(rtosPrefix);
						break; // next cpu
					}
				}

				// next cpu
			}

			// next ecu
		}

		return (String[]) risp.toArray(new String[0]);
	}

	/**
	 * Searchs all Procs stored inside the tree. If no system was found, returns
	 * null, otherwise returns an array with 0 or more String that contain paths
	 * of all found Procs
	 * 
	 * @param vt
	 *            current data repository
	 * 
	 * @return null if NO system or ecu is found. Otherwise returns a not null
	 *         array with 0 or more path, one for each found RT-OS
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static String systemName(IVarTree vt) {
		if (vt == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}
		return systemName(vt.newTreeInterface());
	}
	public static String systemName(ITreeInterface ti) {
		if (ti == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}

		DataPackage dpkg = DataPackage.eINSTANCE;

		String prefix = null;
		String[] tmp = ti.getAllName(prefix, dpkg.getSystem().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No System found", null, "", null);
			return null;
		}
		return tmp[0];
	}

	
	/**
	 * Searchs all Ecus stored inside the tree. If no system or ecu was found,
	 * returns null, otherwise returns an array with 0 or more String that
	 * contain paths of all found Ecus
	 * 
	 * @param ti
	 *            current data repository
	 * 
	 * @return null if NO system is found. Otherwise returns a not null
	 *         array with 0 or more path, one for each found RT-OS
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static String[] allEcus(ITreeInterface ti) {
		if (ti == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}

		DataPackage dpkg = DataPackage.eINSTANCE;
		String S = "" + DataPath.SEPARATOR;

		String prefix = null;
		String[] tmp = ti.getAllName(prefix, dpkg.getSystem().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No System found", null, "", null);
			return null;
		}

		prefix = tmp[0] + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_EcuList().getName();

		return ti.getAllName(prefix, dpkg.getEcu().getName());
	}

	
	/**
	 * Searchs all RT-OS stored inside the tree. If no system or ecu was found,
	 * returns null, otherwise returns an array with 0 or more String that
	 * contain paths of all found RT-OS
	 * 
	 * @param ti
	 *            current data repository
	 * 
	 * @return null if NO system or ecu is found. Otherwise returns a not null
	 *         array with 0 or more path, one for each found RT-OS
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static String[] allRtos(ITreeInterface ti) {
		if (ti == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}

		DataPackage dpkg = DataPackage.eINSTANCE;
		String S = "" + DataPath.SEPARATOR;

		String prefix = null;
		String[] tmp = ti.getAllName(prefix, dpkg.getSystem().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No System found", null, "", null);
			return null;
		}

		prefix = tmp[0] + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_EcuList().getName();

		tmp = ti.getAllName(prefix, dpkg.getEcu().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No ECU found", null, "", null);
			return null;
		}

		// store all rtos
		ArrayList<String> rtosPath = new ArrayList<String>();

		// search cpu inside each ecu
		for (int i = 0; i < tmp.length; i++) {

			String currPrefix = prefix + S + tmp[i] + S
					+ dpkg.getEcu_CpuList().getName();

			String[] tmp2 = ti.getAllName(currPrefix, dpkg.getCpu().getName());
			if (tmp2.length == 0) {
				continue;
			}

			// search rtos inside each cpu
			for (int l = 0; l < tmp2.length; l++) {

				String currRtosPrefix = currPrefix + S + tmp2[l] + S
						+ dpkg.getCpu_Rtos().getName();
				if (ti.exist(currRtosPrefix, null)) {
					rtosPath.add(currRtosPrefix);
				}
			}
		}

		return (String[]) rtosPath.toArray(new String[rtosPath.size()]);
	}

	
	/**
	 * Searchs all RT-OS related to a specific ecu. If no system or ecu was
	 * found, returns null, otherwise returns an array with 0 or more String
	 * that contain paths of all found RT-OS
	 * 
	 * @param ti
	 *            current data repository
	 * @param ecu_name
	 *            the name of the ecu where look for rt-os
	 * 
	 * @return null if NO system or ecu is found. Otherwise returns a not null
	 *         array with 0 or more path, one for each found RT-OS
	 * 
	 * @throws NullPointerException
	 *             if ti or ecu is null
	 */
	public static String[] allRtos(ITreeInterface ti, String ecu_name) {
		if (ti == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}

		if (ecu_name == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}

		DataPackage dpkg = DataPackage.eINSTANCE;
		String S = "" + DataPath.SEPARATOR;

		String prefix = null;
		String[] tmp = ti.getAllName(prefix, dpkg.getSystem().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No System found", null, "", null);
			return null;
		}

		prefix = tmp[0] + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_EcuList().getName() + S+ ecu_name + S
					+ dpkg.getEcu_CpuList().getName();

		ArrayList<String> rtosPath = new ArrayList<String>();
		// search rtos inside each cpu
		String[] tmp2 = ti.getAllName(prefix, dpkg.getCpu().getName());
		for (int l = 0; l < tmp2.length; l++) {

			String currRtosPrefix = prefix + S + tmp2[l] + S
					+ dpkg.getCpu_Rtos().getName();
			if (ti.exist(currRtosPrefix, null)) {
				rtosPath.add(currRtosPrefix);
			}
		}
	

		return (String[]) rtosPath.toArray(new String[rtosPath.size()]);
	}
	
	/**
	 * Searchs all RT-OS stored inside the tree. If no system or ecu was found,
	 * returns null, otherwise returns an array with 0 or more String that
	 * contain paths of all found RT-OS
	 * 
	 * @param ti
	 *            current data repository
	 * 
	 * @return an empty array if NO system or ecu is found. Otherwise returns a
	 *         not null array with 0 or more path, one for each found RT-OS
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static ArchElement[] allRtosNames(ITreeInterface ti) {
		if (ti == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}

		DataPackage dpkg = DataPackage.eINSTANCE;
		String S = "" + DataPath.SEPARATOR;

		String prefix = null;
		String[] tmp = ti.getAllName(prefix, dpkg.getSystem().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No System found", null, "", null);
			return new ArchElement[0];
		}

		prefix = tmp[0] + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_EcuList().getName();

		tmp = ti.getAllName(prefix, dpkg.getEcu().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No ECU found", null, "", null);
			return new ArchElement[0];
		}

		// store all rtos
		ArrayList<ArchElement> rtosPath = new ArrayList<ArchElement>();

		// search cpu inside each ecu
		for (int i = 0; i < tmp.length; i++) {

			String currPrefix = prefix + S + tmp[i] + S + CPU_LIST;

			String[] tmp2 = ti.getAllName(currPrefix, CPU);
			if (tmp2.length == 0) {
				continue;
			}

			// search rtos inside each cpu
			for (int l = 0; l < tmp2.length; l++) {

				String currRtosPrefix = currPrefix + S + tmp2[l] + S
						+ dpkg.getCpu_Rtos().getName();
				if (ti.exist(currRtosPrefix, null)) {

					String name = ""
							+ ti.getValue(currRtosPrefix + S
									+ dpkg.getRtos_Name().getName());

					rtosPath.add(new ArchElement(currRtosPrefix, name));
				}
			}
		}

		return (ArchElement[]) rtosPath
				.toArray(new ArchElement[rtosPath.size()]);
	}

	/**
	 * Searchs all RT-OS related to a specific ecu. If no system or ecu was
	 * found, returns null, otherwise returns an array with 0 or more String
	 * that contain paths of all found RT-OS
	 * 
	 * @param ti
	 *            current data repository
	 * @param ecu_name
	 *            the name of the ecu where look for rt-os
	 * 
	 * @return null if NO system or ecu is found. Otherwise returns a not null
	 *         array with 0 or more path, one for each found RT-OS
	 * 
	 * @throws NullPointerException
	 *             if ti or ecu is null
	 */
	public static ArchElement[] allRtosNames(ITreeInterface ti, String ecu_name) {
		if (ti == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}

		if (ecu_name == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}

		DataPackage dpkg = DataPackage.eINSTANCE;
		String S = "" + DataPath.SEPARATOR;

		String prefix = null;
		String[] tmp = ti.getAllName(prefix, dpkg.getSystem().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No System found", null, "", null);
			return null;
		}

		prefix = tmp[0] + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_EcuList().getName() + S+ ecu_name + S
					+ dpkg.getEcu_CpuList().getName();

		ArrayList<ArchElement> rtosPath = new ArrayList<ArchElement>();
		// search rtos inside each cpu
		String[] tmp2 = ti.getAllName(prefix, dpkg.getCpu().getName());
		for (int l = 0; l < tmp2.length; l++) {

			String currRtosPrefix = prefix + S + tmp2[l] + S
					+ dpkg.getCpu_Rtos().getName();
			if (ti.exist(currRtosPrefix, null)) {
				
				String name = ""
						+ ti.getValue(currRtosPrefix + S
								+ dpkg.getRtos_Name().getName());

				rtosPath.add(new ArchElement(currRtosPrefix, name));
			}
		}
	

		return (ArchElement[]) rtosPath.toArray(new ArchElement[rtosPath.size()]);
	}
	

	/**
	 * Searchs all OS Application stored inside the tree. If no system or ecu was found,
	 * returns null, otherwise returns an array with 0 or more String that
	 * contain paths of all found OS Application
	 * 
	 * @param ti
	 *            current data repository
	 * 
	 * @return null if NO system or ecu is found. Otherwise returns a not null
	 *         array with 0 or more path, one for each found OS Application
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static String[] allOsApplication(ITreeInterface ti) {
		if (ti == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}

		DataPackage dpkg = DataPackage.eINSTANCE;
		String S = "" + DataPath.SEPARATOR;

		String prefix = null;
		String[] tmp = ti.getAllName(prefix, dpkg.getSystem().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No System found", null, "", null);
			return null;
		}

		prefix = tmp[0] + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_EcuList().getName();

		tmp = ti.getAllName(prefix, dpkg.getEcu().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No ECU found", null, "", null);
			return null;
		}

		
		// store all Os Applications
		ArrayList<String> osApplPath = new ArrayList<String>();

		// search cpu inside each ecu
		for (int i = 0; i < tmp.length; i++) {

			String currPrefix = prefix + S + tmp[i] + S + CPU_LIST;

			String[] tmp2 = ti.getAllName(currPrefix, CPU);
			if (tmp2.length == 0) {
				continue;
			}

			// search os application inside each cpu
			for (int l = 0; l < tmp2.length; l++) {
				String currCpuPrefix = currPrefix + S + tmp2[l] + S
					+ OS_APPLICATION_LIST;

				String[] osAppl_names = ti.getAllName(currCpuPrefix, OS_APPLICATION);
				for (String osApp_name : osAppl_names) {

					osApplPath.add(currCpuPrefix+S+osApp_name);
				}
			}
		}
		
		return (String[]) osApplPath.toArray(new String[osApplPath.size()]);
	}

	/**
	 * Searchs all OS Applications stored inside the tree. If no system or ecu was found,
	 * returns null, otherwise returns an array with 0 or more String that
	 * contain paths of all found OS Applications
	 * 
	 * @param ti
	 *            current data repository
	 * 
	 * @return an empty array if NO system or ecu is found. Otherwise returns a
	 *         not null array with 0 or more path, one for each found RT-OS
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static ArchElement[] allOsApplNames(ITreeInterface ti) {
		if (ti == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}

		DataPackage dpkg = DataPackage.eINSTANCE;
		String S = "" + DataPath.SEPARATOR;

		String prefix = null;
		String[] tmp = ti.getAllName(prefix, dpkg.getSystem().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No System found", null, "", null);
			return new ArchElement[0];
		}

		prefix = tmp[0] + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_EcuList().getName();

		tmp = ti.getAllName(prefix, dpkg.getEcu().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No ECU found", null, "", null);
			return new ArchElement[0];
		}

		// store all Os Applications
		ArrayList<ArchElement> osApplPath = new ArrayList<ArchElement>();

		// search cpu inside each ecu
		for (int i = 0; i < tmp.length; i++) {

			String currPrefix = prefix + S + tmp[i] + S + CPU_LIST;

			String[] tmp2 = ti.getAllName(currPrefix, CPU);
			if (tmp2.length == 0) {
				continue;
			}

			// search os application inside each cpu
			for (int l = 0; l < tmp2.length; l++) {
				String currCpuPrefix = currPrefix + S + tmp2[l] + S
					+ OS_APPLICATION_LIST;

				String[] osAppl_names = ti.getAllName(currCpuPrefix, OS_APPLICATION);
				for (String osApp_name : osAppl_names) {

					osApplPath.add(new ArchElement(currCpuPrefix+S+osApp_name, osApp_name));
				}
			}
		}

		return (ArchElement[]) osApplPath
				.toArray(new ArchElement[osApplPath.size()]);
	}

	
	/**
	 * Searchs all OS Applications related to a specific cpu. If no system or ecu was found,
	 * returns null, otherwise returns an array with 0 or more String that
	 * contain paths of all found OS Applications
	 * 
	 * @param ti
	 *            current data repository
	 * @param cpu_path
	 *            the path to the cpu where look for osApplications
	 *             
	 * @return an empty array if NO system or ecu is found. Otherwise returns a
	 *         not null array with 0 or more path, one for each found osApplication
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static ArchElement[] allOsApplNames(ITreeInterface ti, String cpu_path) {
		if (ti == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}

		String S = "" + DataPath.SEPARATOR;

		// store all Os Applications
		ArrayList<ArchElement> osApplPath = new ArrayList<ArchElement>();

		String currCpuPrefix = cpu_path + S
			+ OS_APPLICATION_LIST;

		String[] osAppl_names = ti.getAllName(currCpuPrefix, OS_APPLICATION);
			for (String osApp_name : osAppl_names) {

			osApplPath.add(new ArchElement(currCpuPrefix+S+osApp_name, osApp_name));
		}

		return (ArchElement[]) osApplPath
				.toArray(new ArchElement[osApplPath.size()]);
	}
	
	/**
	 * Searchs all Procs stored inside the tree. If no system was found, returns
	 * null, otherwise returns an array with 0 or more String that contain paths
	 * of all found Procs
	 * 
	 * @param vt
	 *            current data repository
	 * 
	 * @return null if NO system or ecu is found. Otherwise returns a not null
	 *         array with 0 or more path, one for each found RT-OS
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static String[] allProcs(IVarTree vt) {
		if (vt == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}

		DataPackage dpkg = DataPackage.eINSTANCE;
		String S = "" + DataPath.SEPARATOR;

		String prefix = null;
		String[] tmp = vt.newTreeInterface().getAllName(prefix,
				dpkg.getSystem().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No System found", null, "", null);
			return null;
		}

		ArrayList<String> paths = new ArrayList<String>();

		prefix = tmp[0] + S + FUNCTIONAL + S + IMPLEMENTATION + S;

		IVarTreePointer vtp = vt.newVarTreePointer();

		// go to the first child of Functional_implementation node, and search
		// every proc in the main level and inside any subsystem
		boolean ok = vtp.go(prefix);
		for (ok &= vtp.goFirstChild(); ok; ok = vtp.goNextSibling()) {

			if (PROC.equals(vtp.getType())) {
				paths.add(prefix + vtp.getName());
			} else if (SUBSYSTEM.equals(vtp.getType())) {
				allProcs((IVarTreePointer) vtp.clone(), paths, prefix);
			}
		}

		return (String[]) paths.toArray(new String[paths.size()]);

	}

	/** Iterative search (internal use) */
	protected static void allProcs(IVarTreePointer vtp,
			ArrayList<String> paths, String prefix) {

		prefix = prefix + vtp.getName() + S + SUB_SYS_IMPLEMENTATION + S;

		boolean ok = vtp.go(SUB_SYS_IMPLEMENTATION);
		for (ok &= vtp.goFirstChild(); ok; ok = vtp.goNextSibling()) {

			if (PROC.equals(vtp.getType())) {
				paths.add(prefix + vtp.getName());
			} else if (SUBSYSTEM.equals(vtp.getType())) {
				allProcs((IVarTreePointer) vtp.clone(), paths, prefix);
			}
		}
	}

	/**
	 * Searchs all Procs stored inside the tree. If no system was found, returns
	 * null, otherwise returns an array with 0 or more String that contain paths
	 * of all found Procs
	 * 
	 * @param vt
	 *            current data repository
	 * 
	 * @return null if NO system or ecu is found. Otherwise returns a not null
	 *         array with 0 or more path, one for each found RT-OS
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static FunctElement[] allProcsName(IVarTree vt) {
		if (vt == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}

		DataPackage dpkg = DataPackage.eINSTANCE;
		String S = "" + DataPath.SEPARATOR;

		String prefix = null;
		String[] tmp = vt.newTreeInterface().getAllName(prefix,
				dpkg.getSystem().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No System found", null, "", null);
			return null;
		}

		ArrayList<FunctElement> elements = new ArrayList<FunctElement>();

		prefix = tmp[0] + S + FUNCTIONAL + S + IMPLEMENTATION + S;

		IVarTreePointer vtp = vt.newVarTreePointer();

		// go to the first child of Functional_implementation node, and search
		// every proc in the main level and inside any subsystem
		boolean ok = vtp.go(prefix);
		for (ok &= vtp.goFirstChild(); ok; ok = vtp.goNextSibling()) {

			if (PROC.equals(vtp.getType())) {
				elements.add(new FunctElement(prefix + vtp.getName(), DataPath
						.removeSlash(vtp.getName())));
			} else if (SUBSYSTEM.equals(vtp.getType())) {
				allProcsName((IVarTreePointer) vtp.clone(), elements, prefix,
						"");
			}
		}

		return (FunctElement[]) elements.toArray(new FunctElement[elements
				.size()]);

	}

	/** Iterative search (internal use) */
	protected static void allProcsName(IVarTreePointer vtp,
			ArrayList<FunctElement> elements, String vtPrefix, String eviPrefix) {

		vtPrefix = vtPrefix + vtp.getName() + S + SUB_SYS_IMPLEMENTATION + S;
		eviPrefix = eviPrefix + DataPath.removeSlash(vtp.getName()) + S;

		boolean ok = vtp.go(SUB_SYS_IMPLEMENTATION);
		for (ok &= vtp.goFirstChild(); ok; ok = vtp.goNextSibling()) {

			if (PROC.equals(vtp.getType())) {
				elements.add(new FunctElement(vtPrefix + vtp.getName(),
						eviPrefix + DataPath.removeSlash(vtp.getName())));
			} else if (SUBSYSTEM.equals(vtp.getType())) {
				allProcsName((IVarTreePointer) vtp.clone(), elements, vtPrefix,
						eviPrefix);
			}
		}
	}

	/**
	 * Searchs all Tasks stored inside the tree. If no system was found, returns
	 * null, otherwise returns an array with 0 or more String that contain paths
	 * of all found Tasks
	 * 
	 * @param ti
	 *            current data repository
	 * 
	 * @return null if NO system is found. Otherwise returns a not null array
	 *         with 0 or more path, one for each found RT-OS
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static String[] allTasks(ITreeInterface ti) {
		if (ti == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}

		DataPackage dpkg = DataPackage.eINSTANCE;
		String S = "" + DataPath.SEPARATOR;

		String prefix = null;
		String[] tmp = ti.getAllName(prefix, dpkg.getSystem().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No System found", null, "", null);
			return null;
		}

		prefix = tmp[0] + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_TaskList().getName();

		String[] answer = ti.getAllName(prefix, dpkg.getTask().getName());

		for (int i = 0; i < answer.length; i++) {
			answer[i] = prefix + S + answer[i];
		}

		return answer;
	}

	/**
	 * Searchs a Tasks stored inside the tree. If no system was found or the
	 * task doesn't exist, returns null, otherwise returns the path of the found
	 * Task
	 * 
	 * @param ti
	 *            current data repository
	 * 
	 * @param taskName
	 *            the task name
	 * 
	 * @return null if the task is not found
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static String aTasks(IVarTree vt, String taskName) {
		if (vt == null) {
			throw new NullPointerException("Required a not null tree");
		}

		StringBuffer answer = new StringBuffer();
		DataPackage dpkg = DataPackage.eINSTANCE;
		String S = "" + DataPath.SEPARATOR;
		IVarTreePointer vtp = vt.newVarTreePointer();
		
		boolean ok = vtp.goFirstChild();
		answer.append(
				vtp.getName()+ S + 
				dpkg.getSystem_Architectural().getName() + S +
				dpkg.getArchitectural_TaskList().getName() + S);
		

		ok &= vtp.go(dpkg.getSystem_Architectural().getName());
		ok &= vtp.go(dpkg.getArchitectural_TaskList().getName());
		
		if (ok) {
			if (vtp.exist(DataPath.makeSlashedId(taskName))) {
				answer.append(DataPath.makeSlashedId(taskName));
				return answer.toString();
			}
		}

		return null;
	}

	/**
	 * Searchs all Application Modes stored inside the tree. If no system was found, returns
	 * null, otherwise returns an array with 0 or more String that contain paths
	 * of all found Application Modes
	 * 
	 * @param ti
	 *            current data repository
	 * 
	 * @return null if NO system is found. Otherwise returns a not null array
	 *         with 0 or more path, one for each found Application Mode
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static ArchElement[] allApplModesNames(ITreeInterface ti) {
		if (ti == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}

		DataPackage dpkg = DataPackage.eINSTANCE;
		String S = "" + DataPath.SEPARATOR;

		String prefix = null;
		String[] tmp = ti.getAllName(prefix, dpkg.getSystem().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No System found", null, "", null);
			return null;
		}

		prefix = tmp[0] +S+DPKG.getSystem_Modes().getName()+S+DPKG.getModes_ModeList().getName();

		String[] ttmp = ti.getAllName(prefix, dpkg.getMode().getName());
		ArchElement[] answer = new ArchElement[ttmp.length];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = new ArchElement(prefix + S + ttmp[i], DataPath
					.removeSlash(DataPath.removeSlash(ttmp[i])));
		}

		return answer;
	}

	/**
	 * Searchs all Resources stored inside the tree. If no system was found, returns
	 * null, otherwise returns an array with 0 or more String that contain paths
	 * of all found Resources
	 * 
	 * @param ti
	 *            current data repository
	 * 
	 * @return null if NO system is found. Otherwise returns a not null array
	 *         with 0 or more path, one for each found RT-OS
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static ArchElement[] allResourcesNames(ITreeInterface ti) {
		if (ti == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}

		DataPackage dpkg = DataPackage.eINSTANCE;
		String S = "" + DataPath.SEPARATOR;

		String prefix = null;
		String[] tmp = ti.getAllName(prefix, dpkg.getSystem().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No System found", null, "", null);
			return null;
		}

		prefix = tmp[0] + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_MutexList().getName();

		String[] ttmp = ti.getAllName(prefix, dpkg.getMutex().getName());
		ArchElement[] answer = new ArchElement[ttmp.length];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = new ArchElement(prefix + S + ttmp[i], DataPath
					.removeSlash(DataPath.removeSlash(ttmp[i])));
		}

		return answer;
	}

	/**
	 * Searchs all Tasks stored inside the tree. If no system was found, returns
	 * null, otherwise returns an array with 0 or more String that contain paths
	 * of all found Tasks
	 * 
	 * @param ti
	 *            current data repository
	 * 
	 * @return null if NO system is found. Otherwise returns a not null array
	 *         with 0 or more path, one for each found RT-OS
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static ArchElement[] allTasksNames(ITreeInterface ti) {
		if (ti == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}

		DataPackage dpkg = DataPackage.eINSTANCE;
		String S = "" + DataPath.SEPARATOR;

		String prefix = null;
		String[] tmp = ti.getAllName(prefix, dpkg.getSystem().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No System found", null, "", null);
			return null;
		}

		prefix = tmp[0] + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_TaskList().getName();

		String[] ttmp = ti.getAllName(prefix, dpkg.getTask().getName());
		ArchElement[] answer = new ArchElement[ttmp.length];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = new ArchElement(prefix + S + ttmp[i], DataPath
					.removeSlash(DataPath.removeSlash(ttmp[i])));
		}

		return answer;
	}
	
	/**
	 * Searchs all Schedule table stored inside the tree. If no system was found, returns
	 * null, otherwise returns an array with 0 or more String that contain paths
	 * of all found Tasks
	 * 
	 * @param ti
	 *            current data repository
	 * 
	 * @return null if NO system is found. Otherwise returns a not null array
	 *         with 0 or more path, one for each found RT-OS
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static ArchElement[] allScheduleTableNames(ITreeInterface ti) {
		if (ti == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}

		DataPackage dpkg = DataPackage.eINSTANCE;
		String S = "" + DataPath.SEPARATOR;

		String prefix = null;
		String[] tmp = ti.getAllName(prefix, dpkg.getSystem().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No System found", null, "", null);
			return null;
		}

		prefix = tmp[0] + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_TaskList().getName();

		String[] ttmp = ti.getAllName(prefix, dpkg.getScheduleTable().getName());
		ArchElement[] answer = new ArchElement[ttmp.length];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = new ArchElement(prefix + S + ttmp[i], DataPath
					.removeSlash(DataPath.removeSlash(ttmp[i])));
		}

		return answer;
	}
	
	/**
	 * Searchs all Spinlocks stored inside the tree. If no system was found, returns
	 * null, otherwise returns an array with 0 or more String that contain paths
	 * of all found Spinlocks
	 * 
	 * @param ti
	 *            current data repository
	 * 
	 * @return null if NO system is found. Otherwise returns a not null array
	 *         with 0 or more path, one for each found RT-OS
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static ArchElement[] allSpinlockNames(ITreeInterface ti) {
		if (ti == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}

		DataPackage dpkg = DataPackage.eINSTANCE;
		String S = "" + DataPath.SEPARATOR;

		String prefix = null;
		String[] tmp = ti.getAllName(prefix, dpkg.getSystem().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No System found", null, "", null);
			return null;
		}

		prefix = tmp[0] + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_SpinLockList().getName();

		String[] ttmp = ti.getAllName(prefix, dpkg.getSpinLock().getName());
		ArchElement[] answer = new ArchElement[ttmp.length];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = new ArchElement(prefix + S + ttmp[i], DataPath
					.removeSlash(DataPath.removeSlash(ttmp[i])));
		}

		return answer;
	}


	/**
	 * Searchs all Signals stored inside the tree (EVENT, COUNTER, ). If no system was found, returns
	 * null, otherwise returns an array with 0 or more String that contain paths
	 * of all found Tasks
	 * 
	 * @param ti
	 *            current data repository
	 * 
	 * @return null if NO system is found. Otherwise returns a not null array
	 *         with 0 or more path, one for each found RT-OS
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static ArchElement[] allSignalsNames(ITreeInterface ti, int type) {
		if (ti == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}

		DataPackage dpkg = DataPackage.eINSTANCE;
		String S = "" + DataPath.SEPARATOR;

		String prefix = null;
		String[] tmp = ti.getAllName(prefix, dpkg.getSystem().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No System found", null, "", null);
			return null;
		}

		prefix = tmp[0] + S + dpkg.getSystem_Architectural().getName() + S
				+ dpkg.getArchitectural_SignalList().getName();

		String[] ttmp = ti.getAllName(prefix, dpkg.getSignal().getName());
		LinkedList<ArchElement> answer = new LinkedList<ArchElement>();

		for (int i = 0; i < ttmp.length; i++) {
			IVariable var = ti.getValue(prefix + S + ttmp[i] + S + dpkg.getSignal_Type().getName());
			boolean ok = false;
			if (var != null) {
				String vt_type = var.toString();
				ok |= (type & SIGNAL_TYPE_EVENT) != 0 && "EVENT".equals(vt_type);
				ok |= (type & SIGNAL_TYPE_COUNTER) != 0 && "COUNTER".equals(vt_type);
				ok |= (type & SIGNAL_TYPE_ALARM) != 0 && "ALARM".equals(vt_type);
			}
			if (ok) {
				answer.add( new ArchElement(prefix + S + ttmp[i], DataPath
						.removeSlash(DataPath.removeSlash(ttmp[i]))));
			}
		}

		return answer.toArray(new ArchElement[answer.size()]);
	}
	// -------------------------------- ExecTime

	/**
	 * Search the exectime
	 * 
	 * @param ti
	 *            current data repository
	 * @param system
	 *            the system path (with protection)
	 * @param ref
	 *            the ExecTime reference (Evidence reference)
	 * @param type
	 *            the ExecTime reference type
	 * @param modeRef
	 *            the ExecTime mode (Evidence reference)
	 * 
	 * @return the path to correct ExecTime element or null if not found
	 */
	public static String anExecTime(ITreeInterface ti, String system,
			String ref, String type, String modeRef) {
		// search annotation
		String slashedID = DataPath.makeSlashedId(new String[] { ref,
				type.toUpperCase() });
		system = system == null ? DataPath.NULL_ID : system;

		String tmpPath = null;
		if (modeRef != null) {
			String firstPrefix = system + S + ANNOTATION + S + EXEC_TIME_LISTS
					+ S + DataPath.makeSlashedId(modeRef) + S
					+ EXEC_TIME_ITEM_LIST + S + slashedID;

			if (ti.exist(firstPrefix, EXEC_TIME)) {
				tmpPath = firstPrefix;
			}
		}

		if (tmpPath == null) {

			String secondPrefix = system + S + ANNOTATION + S + EXEC_TIME_LISTS
					+ S + DataPath.NULL_ID + S + EXEC_TIME_ITEM_LIST + S
					+ slashedID;

			if (ti.exist(secondPrefix, EXEC_TIME)) {
				tmpPath = secondPrefix;
			}
		}
		return tmpPath;
	}

	
	// -------------------------------- PartialOrder

	/**
	 * Searchs all Partial Orders stored inside the tree. If no system was found, returns
	 * null, otherwise returns an array with 0 or more String that contain paths
	 * of all found Partial Order.
	 * Uses default mode.
	 * 
	 * @param ti
	 *            current data repository
	 *
	 * @return null if NO system is found. Otherwise returns a not null array
	 *         with 0 or more path, one for each found Partial Order
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static String[] allPartialOrders(ITreeInterface ti) {
		return allPartialOrders(ti, null);
	}
	
	/**
	 * Searchs all Partial Orders stored inside the tree. If no system was found, returns
	 * null, otherwise returns an array with 0 or more String that contain paths
	 * of all found Partial Order
	 * 
	 * @param ti
	 *            current data repository
	 * @param modeRef
	 *            the PartialOrder mode (Evidence reference)
	 * 
	 * @return null if NO system is found. Otherwise returns a not null array
	 *         with 0 or more path, one for each found Partial Order
	 * 
	 * @throws NullPointerException
	 *             if ti is null
	 */
	public static String[] allPartialOrders(ITreeInterface ti, String modeRef) {
		if (ti == null) {
			throw new NullPointerException("Required a not null treeinterface");
		}
		
		if (modeRef == null) {
			modeRef = DataPath.NULL_ID;
		}

		DataPackage dpkg = DataPackage.eINSTANCE;
		String S = "" + DataPath.SEPARATOR;

		String prefix = null;
		String[] tmp = ti.getAllName(prefix, dpkg.getSystem().getName());
		if (tmp.length == 0) {
			// Messages.sendWarning("No System found", null, "", null);
			return null;
		}

		prefix = tmp[0] + S + dpkg.getSystem_Functional().getName() + S
				+ dpkg.getFunctional_PartialOrderList().getName() 
				+ S+ modeRef + S + dpkg.getPartialOrder_OrderList().getName();

		String[] answer = ti.getAllName(prefix, dpkg.getOrder().getName());

		for (int i = 0; i < answer.length; i++) {
			answer[i] = prefix + S + answer[i];
		}

		return answer;
	}

	
	public static String getString(ITreeInterface ti, String path) {
		String answer = null;
		{
			IVariable o = ti.getValue(path);
			if (o != null && o.get() != null) {
				answer = o.toString();
			}
		}
		return answer;
	}

	public static String[] getVString(ITreeInterface ti, String path) {
		String answer[] = null;
		{
			IVariable o = ti.getValue(path);
			if (o != null) {
				if (o instanceof IMultiValues) {
					answer = ((IMultiValues) o).getValues().clone();
				} else {
					answer = new String[] {o.toString()};
				}
			}
		}
		return answer;
	}

}
