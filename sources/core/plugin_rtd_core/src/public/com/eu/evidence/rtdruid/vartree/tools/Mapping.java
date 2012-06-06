/*
 * Created on 10-mar-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.eu.evidence.rtdruid.vartree.tools;


import java.util.Iterator;
import java.util.LinkedList;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

/** This class contains many functions that look for a mapping between two compatible objects
 * 
 * @author  Nicola Serreli
 */
public class Mapping {
	/** Abbreviation for VarTree.SEPARATOR */
	protected final static char S = IVarTree.SEPARATOR;
	
	
	private final static String PROC_TASK_MAPPING_TASKREF =
		DataPackage.eINSTANCE.getProcMap_TaskRef().getName();
	
	private final static String PROC_TASK_MAPPING_ORDER =
		DataPackage.eINSTANCE.getProcMap_Order().getName();

	private final static String PROC_TASK_MAPPING_ONCE_EVERY_K =
		DataPackage.eINSTANCE.getProcMap_OnceEveryK().getName();
	
	protected final static String[] PROC_TASK_MAPPING_TYPES = {
		DataPackage.eINSTANCE.getSystem().getName(),
		DataPackage.eINSTANCE.getSystem_Mapping().getName(),
		DataPackage.eINSTANCE.getMapping_ProcMapList().getName(),
		DataPackage.eINSTANCE.getProcMap().getName()};

	protected final static String[] TASK_RTOS_MAPPING_TYPES = {
		DataPackage.eINSTANCE.getSystem().getName(),
		DataPackage.eINSTANCE.getSystem_Mapping().getName(),
		DataPackage.eINSTANCE.getMapping_TaskMapList().getName(),
		DataPackage.eINSTANCE.getTaskMap().getName()};
	
	
	private String sysName;
	private String sysPath;
	private String modeRef;
	private IVarTree vt;
	
	/**	Make a new Mapping on given system, using the default mode
	 * 
	 *	@param vt current data repository
	 * 
	 *   @throws NullPointerException if system is null
	 * */
	public Mapping(IVarTree vt) {
		this(vt, Search.systemName(vt), Utility.DEFAULT_MODE);
	}
	
	/**	Make a new Mapping on given system, using the default mode
	 * 
	 *	@param vt current data repository
	 *  @param system the system path (with protection)
	 * 
	 *   @throws NullPointerException if system is null
	 * */
	public Mapping(IVarTree vt, String system) {
		this(vt, system, Utility.DEFAULT_MODE);
	}
	
	/**	Make a new Mapping on given system, using the given mode
	 * 
	 *	@param vt current data repository
	 *  @param system the system path (with protection)
	 *  @param moderef the new mode
	 * 
	 *   @throws NullPointerException if system
	 * */
	public Mapping(IVarTree vt, String system, String moderef) {
        if (vt == null) {
			throw new NullPointerException(
					"Required a not null data repository");
		}
		if (system == null) {
			throw new NullPointerException("Required a not null System path");
		}
		this.vt = vt;
		sysName = DataPath.removeSlash(DataPath.removeSlash(system));
		sysPath = system.startsWith("" + DataPath.SEPARATOR) ?
					system : "" + DataPath.SEPARATOR + system;
		modeRef = moderef;
	}
	
	// ----------------------------------

	/**
	 *  Sets the mode used in the mapping.
	 * 
	 *  @param moderef the new mode
	 * 
	 *  @return the old mode name
	 * */
	public String setMode(String moderef) {
		String tmp = modeRef;
		modeRef = moderef;
		return tmp; 
	}

	/**
	 *  Gets the mode used in the mapping.
	 * 
	 *  @return the name of current mode
	 * */
	public String getMode() {
		return modeRef; 
	}

	/**
	 *  Gets the system used in the mapping.
	 * 
	 *  @return the name of system
	 * */
	public String getSystem() {
		return sysName; 
	}

	// ---------------------------------- PROC - TASK

	/**
	 * Returns the task that will contain given proc, in current system and mode (or default mode)
	 * 
	 * @param procName the name of a proc (a eviPath without protection, see {@link rtdruid.vartree.IVarTree#addSlash rtdruid.vartree.VarTree.addSlash()})
	 * 
	 * @return the name of task or null if there isn't a mapping between given proc and a task, in current (or default) mode
	 * (without protection)
	 * 
	 * @throws NullPointerException if procName is null
	 * */ 
	public String procToTask(String procName) throws IncompleteMappingException {
		if (procName == null) {
			throw new NullPointerException ("Required a Not Null proc Name");
		}
		ITreeInterface ti = vt.newTreeInterface();
		String[] idList = { modeRef, procName };
		String path = Utility.chooseModeRef(ti, sysPath + S + "Mapping" + S + "ProcMapList" + S, idList, 0, modeRef);
		
		// no data about "proc to task" mapping
		if (path == null || !ti.exist(path + S + PROC_TASK_MAPPING_TASKREF, DataPath.STRING_TYPE )) {
			return null;
		}
		
		return (String) ti.getValue(path + S + "TaskRef").get();
	}

	/**
	 * Returns the task that will contain given proc, in current system and mode (or default mode)
	 * 
	 * @param procName the name of a proc (a eviPath without protection, see {@link rtdruid.vartree.IVarTree#addSlash rtdruid.vartree.VarTree.addSlash()})
	 * 
	 * @return the order inside a task or null if there isn't a mapping between given proc and a task or if there is no order, in current (or default) mode
	 * 
	 * 
	 * @throws NullPointerException if procName is null
	 * */
	public Integer procToTaskOrder(String procName) {
		if (procName == null) {
			throw new NullPointerException ("Required a Not Null proc Name");
		}
		ITreeInterface ti = vt.newTreeInterface();
		String[] idList = { modeRef, procName };
		String path = Utility.chooseModeRef(ti, sysPath + S + "Mapping" + S + "ProcMapList" + S, idList, 0, modeRef);
		
		// no data about "proc to task" mapping
		if (path == null || !ti.exist(path + S + PROC_TASK_MAPPING_ORDER, DataPath.INTEGER_TYPE )) {
			return null;
		}
		
		Object o = ti.getValue(path + S + PROC_TASK_MAPPING_ORDER).get();
		if (o == null) {
			return null;
		}
		if (o instanceof Integer) {
			return (Integer) o;
		}
		
		try {
			return new Integer("" + o);
		} catch (Exception e) {
			RtdruidLog.showDebug(e);
		}
		return null;
	}
	
	/**
	 * Returns once every k map parameter for the specified proc, in current system and mode (or default mode)
	 * 
	 * @param procName the name of a proc (a eviPath without protection, see {@link rtdruid.vartree.IVarTree#addSlash rtdruid.vartree.VarTree.addSlash()})
	 * 
	 * @return the once every k instance of task parameter, or null if there isn't a mapping between given proc and a task or if there is no such value, in current (or default) mode
	 * 
	 * 
	 * @throws NullPointerException if procName is null
	 * */
	public Integer procToTaskFrequency(String procName) {
		if (procName == null) {
			throw new NullPointerException ("Required a Not Null proc Name");
		}
		ITreeInterface ti = vt.newTreeInterface();
		String[] idList = { modeRef, procName };
		String path = Utility.chooseModeRef(ti, sysPath + S + "Mapping" + S + "ProcMapList" + S, idList, 0, modeRef);
		
		// no data about "proc to task" mapping
		if (path == null || !ti.exist(path + S + PROC_TASK_MAPPING_ONCE_EVERY_K, DataPath.INTEGER_TYPE )) {
			return null;
		}
		
		Object o = ti.getValue(path + S + PROC_TASK_MAPPING_ONCE_EVERY_K).get();
		if (o == null) {
			return null;
		}
		if (o instanceof Integer) {
			return (Integer) o;
		}
		
		try {
			return new Integer("" + o);
		} catch (Exception e) {
			RtdruidLog.showDebug(e);
		}
		return null;
	}

	/**
	 * Set the task that will contain given proc, in current system and mode (or default mode)
	 * 
	 * @param procName the name of a proc (without protection, see {@link rtdruid.vartree.IVarTree#addSlash rtdruid.vartree.VarTree.addSlash()})
	 * 
	 * @param taskName the name of task or null if there isn't a mapping between given proc and a task, in current (or default) mode
	 * (without protection)
	 * 
	 * @throws NullPointerException if procName is null
	 * */
	public void setProcToTask(String procName, String taskName) {
		if (procName == null) {
			throw new NullPointerException ("Required a Not Null proc Name");
		}
		ITreeInterface ti = vt.newTreeInterface();
		String[] idList = { modeRef, procName };
		int modeIndex = 0;
		String path = Utility.chooseModeRef(ti, sysPath + S + "Mapping" + S + "ProcMapList" + S, idList, modeIndex, modeRef);
		
		if (path == null) {
			idList[modeIndex] = Utility.pathToEvidence(modeRef);
			path = sysPath + S + "Mapping" + S + "ProcMapList" + S + DataPath.makeSlashedId(idList);
		}
		
		if (taskName == null) {
			// remove old mapping
	    	IVarTreePointer vtp = vt.newVarTreePointer();
			if (vtp.go(path)) {
				vtp.destroy();
			}
			
			// END
			return;
		} 
		
		// no data about "proc to task" mapping
		if (!ti.exist(path + S + "TaskRef", DataPath.STRING_TYPE )) {
			
	    	IVarTreePointer vtp = vt.newVarTreePointer();
	    	String[] names = DataPath.splitPath(path);
	    	String[] types = PROC_TASK_MAPPING_TYPES;
	    	vt.newTreeInterface().makePath(vtp, names, types);
		}
		
		ti.setValue(path + S + "TaskRef", taskName);
	}

	/**
	 * Set the task that will contain given proc, in current system and mode (or default mode)
	 * 
	 * @param procName the name of a proc (without protection, see {@link rtdruid.vartree.IVarTree#addSlash rtdruid.vartree.VarTree.addSlash()})
	 * 
	 * @param taskName the name of task or null if there isn't a mapping between given proc and a task, in current (or default) mode
	 * (without protection)
	 * 
	 * @param order the order inside the task
	 * 
	 * @throws NullPointerException if procName is null
	 * */
	public IVarTreePointer setProcToTask(String procName, String taskName, Integer order) {
		if (procName == null) {
			throw new NullPointerException ("Required a Not Null proc Name");
		}
		ITreeInterface ti = vt.newTreeInterface();
		String[] idList = { modeRef, procName };
		int modeIndex = 0;
		String path = Utility.chooseModeRef(ti, sysPath + S + "Mapping" + S + "ProcMapList" + S, idList, modeIndex, modeRef);
		
		if (path == null) {
			idList[modeIndex] = Utility.pathToEvidence(modeRef);
			path = sysPath + S + "Mapping" + S + "ProcMapList" + S + DataPath.makeSlashedId(idList);
		}
		
		if (taskName == null) {
			// remove old mapping
	    	IVarTreePointer vtp = vt.newVarTreePointer();
			if (vtp.go(path)) {
				vtp.destroy();
			}
			
			// END
			return null;
		} 
		
		// no data about "proc to task" mapping
		if (!ti.exist(path + S + "TaskRef", DataPath.STRING_TYPE )) {
			
	    	IVarTreePointer vtp = vt.newVarTreePointer();
	    	String[] names = DataPath.splitPath(path);
	    	String[] types = PROC_TASK_MAPPING_TYPES;
	    	vt.newTreeInterface().makePath(vtp, names, types);
		}
		
		ti.setValue(path + S + PROC_TASK_MAPPING_TASKREF, taskName);
		ti.setValue(path + S + PROC_TASK_MAPPING_ORDER, order != null ? ""+order : null);
		
		IVarTreePointer vtp = vt.newVarTreePointer();
		if (vtp.go(path)) {
			return vtp;
		}
		return null;
	}

	/**
	 * Set the task that will contain given proc, in current system and mode (or default mode)
	 * 
	 * @param procName the name of a proc (without protection, see {@link rtdruid.vartree.IVarTree#addSlash rtdruid.vartree.VarTree.addSlash()})
	 * 
	 * @param taskName the name of task or null if there isn't a mapping between given proc and a task, in current (or default) mode
	 * (without protection)
	 * 
	 * @param order the order inside the task
	 * 
	 * @throws NullPointerException if procName is null
	 * */
	public IVarTreePointer getPointerProcToTask(String procName) {
		if (procName == null) {
			throw new NullPointerException ("Required a Not Null proc Name");
		}
		ITreeInterface ti = vt.newTreeInterface();
		String[] idList = { modeRef, procName };
		int modeIndex = 0;
		String path = Utility.chooseModeRef(ti, sysPath + S + "Mapping" + S + "ProcMapList" + S, idList, modeIndex, modeRef);
		
		if (path == null) {
			idList[modeIndex] = Utility.pathToEvidence(modeRef);
			path = sysPath + S + "Mapping" + S + "ProcMapList" + S + DataPath.makeSlashedId(idList);
		}
		
		IVarTreePointer vtp = vt.newVarTreePointer();
		if (vtp.go(path)) {
			return vtp;
		}
		return null;
	}


	/**
	 * Set the task that will contain given proc, in current system and mode (or default mode)
	 * 
	 * @param procName the name of a proc (without protection, see {@link rtdruid.vartree.IVarTree#addSlash rtdruid.vartree.VarTree.addSlash()})
	 * 
	 * @param taskName the name of task or null if there isn't a mapping between given proc and a task, in current (or default) mode
	 * (without protection)
	 * 
	 * @param onceEveryK indicates that this proc is activated once every k instances of the mapped task
	 * 
	 * @throws NullPointerException if procName is null
	 * */
	public IVarTreePointer setProcToTaskFreq(String procName, String taskName, Integer onceEveryK) {
		if (procName == null) {
			throw new NullPointerException ("Required a Not Null proc Name");
		}
		ITreeInterface ti = vt.newTreeInterface();
		String[] idList = { modeRef, procName };
		int modeIndex = 0;
		String path = Utility.chooseModeRef(ti, sysPath + S + "Mapping" + S + "ProcMapList" + S, idList, modeIndex, modeRef);
		
		if (path == null) {
			idList[modeIndex] = Utility.pathToEvidence(modeRef);
			path = sysPath + S + "Mapping" + S + "ProcMapList" + S + DataPath.makeSlashedId(idList);
		}
		
		if (taskName == null) {
			// remove old mapping
	    	IVarTreePointer vtp = vt.newVarTreePointer();
			if (vtp.go(path)) {
				vtp.destroy();
			}
			
			// END
			return null;
		} 
		
		// no data about "proc to task" mapping
		if (!ti.exist(path + S + "TaskRef", DataPath.STRING_TYPE )) {
			
	    	IVarTreePointer vtp = vt.newVarTreePointer();
	    	String[] names = DataPath.splitPath(path);
	    	String[] types = PROC_TASK_MAPPING_TYPES;
	    	vt.newTreeInterface().makePath(vtp, names, types);
		}
		
		ti.setValue(path + S + PROC_TASK_MAPPING_TASKREF, taskName);
		ti.setValue(path + S + PROC_TASK_MAPPING_ONCE_EVERY_K, onceEveryK != null ? ""+onceEveryK : null);
		
		IVarTreePointer vtp = vt.newVarTreePointer();
		if (vtp.go(path)) {
			return vtp;
		}
		return null;
	}

	/**
	 * Returns the list of proc contained in given task, in current system and mode (or default mode)
	 *
	 *  @param taskName the name of a task (without protection, see {@link rtdruid.vartree.IVarTree#addSlash rtdruid.vartree.VarTree.addSlash()})
	 * 
	 * @return all proc names or a void list if there isn't a mapping between given task and a proc, in current (or default) mode  (without protection)
	 * 
	 * @throws NullPointerException if taskName is null
	 * */
	public String[] taskToProc(String taskName) {
		if (taskName == null) {
			throw new NullPointerException ("Required a Not Null task Name");
		}

		final boolean use_fast_code = false;
		
		if (use_fast_code) {
//			ITreeInterface ti = vt.newTreeInterface();
//			
//			// check all ProcMap
//			String path = sysPath + S + DataPackage.eINSTANCE.getMapping().getName()
//					+ S + DataPackage.eINSTANCE.getMapping_InverseTaskToProc().getName();
//			
//			if (!ti.exist(path, null)) {
//				return new String[0];
//			}
//
//			FastTaskToProcVar v = (FastTaskToProcVar) ti.getValue(path);
//			
//			// Get default mapping
//			LinkedHashSet<String> procsDefaultMode = v.getProcs(null, taskName);
//			
//			if (modeRef != null) {
//				LinkedHashSet<String> procsCurrentMode = new LinkedHashSet<String> (v.getProcs(modeRef, taskName));
//				
//				// construct a copy and remove procs that are already inside procsCurrentMode
//				procsDefaultMode = new LinkedHashSet<String> (procsDefaultMode);
//				procsDefaultMode.removeAll(procsCurrentMode);
//				
//				IVarTreePointer vtp = vt.newVarTreePointer();
//				vtp.go(sysPath + S + DataPackage.eINSTANCE.getMapping().getName()
//						+ S + DataPackage.eINSTANCE.getMapping_ProcMapList().getName());
//				for (Iterator<String> iter = procsDefaultMode.iterator(); iter.hasNext(); ) {
//					String proc = iter.next();
//					
//					// check if current proc is mapped to "something" in this
//					// mode, is not mapped to current task,
//					// otherwise it should be stored inside procsCurrentMode
//					String[] idList = { modeRef, proc };
//
//					String procPath =/* sysPath + S + DataPackage.eINSTANCE.getMapping().getName()
//							+ S + DataPackage.eINSTANCE.getMapping_ProcMapList().getName() 
//							+ S +*/ DataPath.makeSlashedId(idList);
//					
//					if (vtp.exist(procPath)) {
//						iter.remove();
//					}
//				}
//				
//				procsCurrentMode.addAll(procsDefaultMode);
//				procsDefaultMode = procsCurrentMode; 
//			}
//
			return null; //(String[]) procsDefaultMode.toArray(new String[procsDefaultMode.size()]);
		
		} else { // old Code (slow)
				
			
			String taskName2 = DataPath.removeSlash(taskName);
			
			LinkedList<String> reqMode = new LinkedList<String>();	// required mode
			LinkedList<String> defMode = new LinkedList<String>();    // default mode
			LinkedList<String> scarti = new LinkedList<String>(); // all proc not mapped to given task in current mode
			 
			ITreeInterface ti = vt.newTreeInterface();
			
			// check all ProcMap
			String prefix = sysPath + S + "Mapping" + S + "ProcMapList";
			String[] names = ti.getAllName(prefix, "ProcMap"); 
			
			for (int i=0; i<names.length; i++) {
				String path = prefix + S + names[i];
				
				String tmpProc = (String) ti.getValue(path + S + "ProcRef").get(); // proc Name
				String tmpMode = (String) ti.getValue(path + S + "ModeRef").get(); // mode
				
				// drop not valid values
				if (tmpProc == null)  continue;
	
				// check if mode of current element is the current mode
				boolean currMode = tmpMode == null ? modeRef == null : tmpMode.equals(modeRef);
				
				// check if current element is a map to given Task
				String foundTaskName = null;
				{
					IVariable var = ti.getValue(path + S + "TaskRef");
					if (var != null) {
						foundTaskName = var.toString();
					}
				}
				if (! ( taskName.equals( foundTaskName ) || taskName2.equals( foundTaskName ))) {
					if (currMode) {
						// store a proc not mapped to given task in current mode
						scarti.add(tmpProc);
					}
					continue; // next element
				}
				
				// store the reference
				if (currMode) {
					reqMode.add(tmpProc);
					
				} else if (tmpMode == null) { // default mode
					defMode.add(tmpProc);
				}
			}
			
			// check all references stored as default mode if they are mapped to another task in current mode
			Iterator<String> it = defMode.iterator();
			while (it.hasNext()) {
				String tmpProc = (String) it.next();
				
				boolean ok = true;
				Iterator<String> itSc = scarti.iterator();
				while (itSc.hasNext() && ok) {
					if (tmpProc.equals( itSc.next())) {
						// mapped to another task
						ok = false;
					}
				}
				
				if (ok) {
					// not mapped to another task : store in the other list
					reqMode.add(tmpProc);
				}
			}
			
			return (String[]) reqMode.toArray( new String[0]);
		
		}
	}
	
	//	---------------------------------- TASK - RTOS

	/**
	 * Returns the rtos that will contain given task, in current system and mode (or default mode)
	 * 
	 *  @param taskName the name of a task (without protection, see {@link rtdruid.vartree.IVarTree#addSlash rtdruid.vartree.VarTree.addSlash()})
	 * 
	 *  @return the name of rtos or null if there isn't a mapping between given task and a rtos, in current (or default) mode   (without protection)
	 * 
	 * @throws NullPointerException if taskName is null
	 * */
	public String taskToRTOS(String taskName) {
		if (taskName == null) {
			throw new NullPointerException ("Required a Not Null task Name");
		}
		ITreeInterface ti = vt.newTreeInterface();
		String[] idList = { modeRef, Utility.pathToEvidence(taskName) };
		String path = Utility.chooseModeRef(ti, sysPath + S + "Mapping" + S + "TaskMapList" + S, idList, 0, modeRef);
		
		// no data about "proc to task" mapping
		if (path == null) {
			idList = new String[] { modeRef, Utility.pathToEvidence(DataPath.addSlash(taskName)) };
			path = Utility.chooseModeRef(ti, sysPath + S + "Mapping" + S + "TaskMapList" + S, idList, 0, modeRef);
			
			// no data about "proc to task" mapping
			if (path == null || !ti.exist(path + S + "RtosRef", DataPath.STRING_TYPE )) {
				return null;
			}
		} else if (!ti.exist(path + S + "RtosRef", DataPath.STRING_TYPE )) {
			return null;
		}
		
		return (String) ti.getValue(path + S + "RtosRef").get();
	}

	/**
	 * Sets the rtos that will contain given task, in current system and mode (or default mode)
	 * 
	 *  @param taskName the name of a task (without protection, see {@link rtdruid.vartree.IVarTree#addSlash rtdruid.vartree.VarTree.addSlash()})
	 * 
	 *  @param rtosName the name of rtos or null if there isn't a mapping between given task and a rtos, in current (or default) mode   (without protection)
	 * 
	 * @throws NullPointerException if taskName is null
	 * */
	public void setTaskToRTOS(String taskName, String rtosName) {
		if (taskName == null) {
			throw new NullPointerException ("Required a Not Null task Name");
		}
		ITreeInterface ti = vt.newTreeInterface();
		String[] idList = { modeRef, Utility.pathToEvidence(taskName) };
		int modeIndex = 0;
		String path = Utility.chooseModeRef(ti, sysPath + S + "Mapping" + S + "TaskMapList" + S, idList, modeIndex, modeRef);
		
		if (path == null) {
			idList[modeIndex] = Utility.pathToEvidence(modeRef);
			path = sysPath + S + "Mapping" + S + "TaskMapList" + S + DataPath.makeSlashedId(idList);
		}
		
		if (rtosName == null) {
			// remove old mapping
	    	IVarTreePointer vtp = vt.newVarTreePointer();
			if (vtp.go(path)) {
				vtp.destroy();
			}
			
			// END
			return;
		} 
		
		// no data about "proc to task" mapping
		if (!ti.exist(path + S + "RtosRef", DataPath.STRING_TYPE )) {
			
	    	IVarTreePointer vtp = vt.newVarTreePointer();
	    	String[] names = DataPath.splitPath(path);
	    	String[] types = TASK_RTOS_MAPPING_TYPES;
	    	vt.newTreeInterface().makePath(vtp, names, types);
		}
		
		ti.setValue(path + S + "RtosRef", rtosName);
	}
	/**
	 * Returns all tasks allocated to given rtos, in current system and mode (or default mode)
	 * 
	 *  @param rtosName the name of a rtos (without protection, see {@link rtdruid.vartree.IVarTree#addSlash rtdruid.vartree.VarTree.addSlash()})
	 * 
	 * @return all tasks or an empty list if there isn't a mapping between given rtos and a task, in current mode or default (without protection)
	 * 
	 * @throws NullPointerException if rtosName is null
	 * */
	public String[] rtosToTask(String rtosName) {
		if (rtosName == null) {
			throw new NullPointerException ("Required a Not Null rtos Name");
		}
		LinkedList<String> reqMode = new LinkedList<String>();	// required mode
		LinkedList<String> defMode = new LinkedList<String>();    // default mode
		LinkedList<String> scarti = new LinkedList<String>(); // all task not mapped to given cpu in current mode
		 
		ITreeInterface ti = vt.newTreeInterface();
		
		// check all ProcMap
		String prefix = sysPath + S + "Mapping" + S + "TaskMapList";
		String[] names = ti.getAllName(prefix, "TaskMap"); 
		
		for (int i=0; i<names.length; i++) {
			String path = prefix + S + names[i];
			
			String tmpTask = (String) ti.getValue(path + S + "TaskRef").get(); // task Name
			String tmpMode = (String) ti.getValue(path + S + "ModeRef").get(); // mode
			
			// drop not valid values
			if (tmpTask == null)  continue;
			
			// check if mode of current element is the current mode
			boolean currMode = tmpMode == null ? modeRef == null : tmpMode.equals(modeRef);
			
			// check if current element is a map to given Task
			if (! rtosName.equals( ti.getValue(path + S + "RtosRef").get() )) {
				if (currMode) {
					// store a proc not mapped to given task in current mode
					scarti.add(tmpTask);
				}
				continue; // next element
			}
			
			// store the reference
			if (currMode) {
				if (!reqMode.contains(tmpTask)) {
					reqMode.add(tmpTask);
				}
				
			} else if (tmpMode == null) { // default mode
				defMode.add(tmpTask);
			}
		}
		
		// check all references stored as default mode if they are mapped to another cpu in current mode
		Iterator<String> it = defMode.iterator();
		while (it.hasNext()) {
			String tmpTask = (String) it.next();
			
			boolean ok = true;
			Iterator<String> itSc = scarti.iterator();
			while (itSc.hasNext() && ok) {
				if (tmpTask.equals( itSc.next() )) {
					// mapped to another cpu
					ok = false;
				}
			}
			
			if (ok) {
				// not mapped to another cpu : store in the other list
				if (!reqMode.contains(tmpTask)) {
					reqMode.add(tmpTask);
				}
			}
		}
		
		return (String[]) reqMode.toArray( new String[0]);
	}

	//	---------------------------------- CPU - RTOS

	/**
	 * Returns the rtos that will controll given cpu, in current system
	 * 
	 *  @param cpuName the name of a cpu (without protection, see {@link rtdruid.vartree.IVarTree#addSlash rtdruid.vartree.VarTree.addSlash()})
	 * 
	 *  @return the name of all rtos or null if there isn't a mapping between given cpu and a rtos (without protection)
	 * 
	 * @throws NullPointerException if cpuName is null
	 * */
	public String[] cpuToRTOS(String cpuName) {
		if (cpuName == null) {
			throw new NullPointerException ("Required a Not Null cpu Name");
		}

		String prefix = sysPath + S + "Architectural" + S + "EcuList";
		ITreeInterface ti = vt.newTreeInterface();
		if (!ti.exist(prefix, "EcuList" )) {	// no ecu
			return new String[0];
		}
		
		String slashedName = DataPath.addSlash(cpuName);
		
		//search cpu
		String path = null;
		String[] names = ti.getAllName(prefix, "Ecu");
		for (int i=0; i<names.length && path == null; i++) {
			if (ti.exist(prefix + S + names[i] + S + slashedName, "Cpu" )) {
				path = prefix + S + names[i] + S + slashedName;
			}
		}
		if (path == null) {
			return new String[0];
		}
		
		names = ti.getAllName(path, "RTOS");
		String[] risp = new String[names.length];
		// remove protections
		for (int i=0; i<names.length && path == null; i++) {
			risp[i] = DataPath.removeSlash(names[i]);
		}

		return risp;
	}

	/**
	 * Returns all cpus controlled by given rtos, in current system
	 * 
	 *  @param rtosName the name of a rtos (without protection, see {@link rtdruid.vartree.IVarTree#addSlash rtdruid.vartree.VarTree.addSlash()})
	 * 
	 * @return all cpus or an empty list if there isn't a mapping between given rtos and a cpu (without protection)
	 * 
	 * @throws NullPointerException if rtosName is null
	 * */
	public String[] rtosToCpu(String rtosName) {
		if (rtosName == null) {
			throw new NullPointerException ("Required a Not Null rtos Name");
		}
		
		LinkedList<String> risp = new LinkedList<String>();
		
		String prefix = sysPath + S + "Architectural" + S + "EcuList";
		ITreeInterface ti = vt.newTreeInterface();
		if (!ti.exist(prefix, "EcuList" )) {	// no ecu
			return new String[0];
		}

		String rtosPName = DataPath.addSlash(rtosName);
		
		//search cpu
		String[] ecuNames = ti.getAllName(prefix, "Ecu");
		for (int i=0; i<ecuNames.length; i++) {

			String[] cpuNames = ti.getAllName(prefix, "Cpu");
			for (int j=0; j<cpuNames.length; j++) {
				
				if (ti.exist(prefix + S + ecuNames[i] + S + cpuNames[j] + S + rtosPName, "RTOS" )) {
					risp.add( DataPath.removeSlash(cpuNames[j]));
				}
				
			}
		}

		return (String[]) risp.toArray(new String[0]);
	}

/*	// ---------------------------------- TASK - CPU
 // TEST: Aggiustare TaskToCpu e CpuToTask. NOTA: potrebbe non essere un legame univoco, in quanto rtos-cpu non puo' non essere univoco
	/**
	 * Returns the cpu that will contain given task, in current system and mode (or default mode)
	 * 
	 *  @param taskName the name of a task (without protection, see {@link rtdruid.vartree.VarTree#addSlash rtdruid.vartree.VarTree.addSlash()})
	 * 
	 *  @return the name of cpu or null if there isn't a mapping between given task and a cpu, in current (or default) mode   (without protection)
	 * 
	 * @throws NullPointerException if taskName is null
	 * */
/*	public String taskToCpu(String taskName) {
		if (taskName == null) {
			throw new NullPointerException ("Required a Not Null task Name");
		}
		String[] idList = { taskName, modeRef };
		String path = Utility.chooseModeRef(sys + S + "Mapping" + S + "TaskMapList" + S, idList, 1, modeRef);
		
		// no data about "proc to task" mapping
		TreeInterface ti = new TreeInterface();
		if (path == null || !ti.exist(path + S + "cpuRef", DataPath.STRING_TYPE )) {
			return null;
		}
		
		return (String) ti.getValue(path + S + "cpuRef").get();
	}

	/**
	 * Returns all tasks allocated to given cpu, in current system and mode (or default mode)
	 * 
	 *  @param cpuName the name of a cpu (without protection, see {@link rtdruid.vartree.VarTree#addSlash rtdruid.vartree.VarTree.addSlash()})
	 * 
	 * @return all tasks or an empty list if there isn't a mapping between given cpu and a task, in current mode or default (without protection)
	 * 
	 * @throws NullPointerException if cpuName is null
	 * */
/*	public String[] cpuToTask(String cpuName) {
		if (cpuName == null) {
			throw new NullPointerException ("Required a Not Null cpu Name");
		}
		LinkedList reqMode = new LinkedList();	// required mode
		LinkedList defMode = new LinkedList();    // default mode
		LinkedList scarti = new LinkedList(); // all task not mapped to given cpu in current mode
		 
		TreeInterface ti = new TreeInterface();
		
		// check all ProcMap
		String prefix = sys + S + "Mapping" + S + "TaskMapList";
		String[] names = ti.getAllName(prefix, "TaskMap"); 
		
		for (int i=0; i<names.length; i++) {
			String path = prefix + S + names[i];
			
			String tmpTask = (String) ti.getValue(path + S + "TaskRef").get(); // task Name
			String tmpMode = (String) ti.getValue(path + S + "ModeRef").get(); // mode
			
			// drop not valid values
			if (tmpTask == null)  continue;
			
			// check if mode of current element is the current mode
			boolean currMode = tmpMode == null ? modeRef == null : tmpMode.equals(modeRef);
			
			// check if current element is a map to given Task
			if (! cpuName.equals( ti.getValue(path + S + "cpuRef").get() )) {
				if (currMode) {
					// store a proc not mapped to given task in current mode
					scarti.add(tmpTask);
				}
				continue; // next element
			}
			
			// store the reference
			if (currMode) {
				reqMode.add(tmpTask);
				
			} else if (tmpMode == null) { // default mode
				defMode.add(tmpTask);
			}
		}
		
		// check all references stored as default mode if they are mapped to another cpu in current mode
		Iterator it = defMode.iterator();
		while (it.hasNext()) {
			String tmpTask = (String) it.next();
			
			boolean ok = true;
			Iterator itSc = scarti.iterator();
			while (itSc.hasNext() && ok) {
				if (tmpTask.equals( itSc.next() )) {
					// mapped to another cpu
					ok = false;
				}
			}
			
			if (ok) {
				// not mapped to another cpu : store in the other list
				reqMode.add(tmpTask);
			}
		}
		
		return (String[]) reqMode.toArray( new String[0]);
	}
*/
	// ---------------------------------- VAR - MUTEX

	/**
	 * Returns the mutex that will protect given var, in current system and mode (or default mode)
	 * 
	 *  @param varName the name of a var (without protection, see {@link rtdruid.vartree.IVarTree#addSlash rtdruid.vartree.VarTree.addSlash()})
	 * 
	 *  @return the name of mutex or null if there isn't a mapping between given var and a mutex, in current (or default) mode   (without protection)
	 * 
	 * @throws NullPointerException if varName is null
	 * */
	public String varToMutex(String varName) {
		if (varName == null) {
			throw new NullPointerException ("Required a Not Null var Name");
		}
		ITreeInterface ti = vt.newTreeInterface();
		String[] idList = { modeRef, varName };
		String path = Utility.chooseModeRef(ti, sysPath + S + "Mapping" + S + "VarMapList" + S, idList, 0, modeRef);
		
		// no data about "proc to task" mapping
		if (path == null || !ti.exist(path + S + "MutexRef", DataPath.STRING_TYPE )) {
			return null;
		}
		
		return (String) ti.getValue(path + S + "MutexRef").get();
	}

	/**
	 * Returns all vars protected by given mutex, in current system and mode (or default mode)
	 * 
	 *  @param mutexName the name of a mutex (without protection, see {@link rtdruid.vartree.IVarTree#addSlash rtdruid.vartree.VarTree.addSlash()})
	 * 
	 * @return all vars or an empty list if there isn't a mapping between given mutex and a var, in current mode or default (without protection)
	 * 
	 * @throws NullPointerException if mutexName is null
	 * */
	public String[] mutexToVar(String mutexName) {
		if (mutexName == null) {
			throw new NullPointerException ("Required a Not Null mutex Name");
		}
		LinkedList<String> reqMode = new LinkedList<String>();	// required mode
		LinkedList<String> defMode = new LinkedList<String>();    // default mode
		LinkedList<String> scarti = new LinkedList<String>(); // all var not mapped to given mutex in current mode
		 
		ITreeInterface ti = vt.newTreeInterface();
		
		// check all ProcMap
		String prefix = sysPath + S + "Mapping" + S + "VarMapList";
		String[] names = ti.getAllName(prefix, "VarMap"); 
		
		for (int i=0; i<names.length; i++) {
			String path = prefix + S + names[i];
			
			String tmpVar = (String) ti.getValue(path + S + "VarRef").get(); // task Name
			String tmpMode = (String) ti.getValue(path + S + "ModeRef").get(); // mode
			
			// drop not valid values
			if (tmpVar == null)  continue;
			
			// check if mode of current element is the current mode
			boolean currMode = tmpMode == null ? modeRef == null : tmpMode.equals(modeRef);
			
			// check if current element is a map to given Task
			if (! mutexName.equals( ti.getValue(path + S + "MutexRef").get() )) {
				if (currMode) {
					// store a proc not mapped to given task in current mode
					scarti.add(tmpVar);
				}
				continue; // next element
			}
			
			// store the reference
			if (currMode) {
				reqMode.add(tmpVar);
				
			} else if (tmpMode == null) { // default mode
				defMode.add(tmpVar);
			}
		}
		
		// check all references stored as default mode if they are mapped to another mutex in current mode
		Iterator<String> it = defMode.iterator();
		while (it.hasNext()) {
			String tmpMutex = (String) it.next();
			
			boolean ok = true;
			Iterator<String> itSc = scarti.iterator();
			while (itSc.hasNext() && ok) {
				if (tmpMutex.equals( itSc.next() )) {
					// mapped to another mutex
					ok = false;
				}
			}
			
			if (ok) {
				// not mapped to another mutex : store in the other list
				reqMode.add(tmpMutex);
			}
		}
		
		return (String[]) reqMode.toArray( new String[0]);
	}
	
	
	// Utility
	
	/** Makes a var name: SubSystem/SubSystem/.../SubSystem/varName.
	 * 
	 * Looks each path's elements and store only subsystem elements.
	 * This method searchs the var into <b>subSystemPath/Implementation/ AddSlash(varName)</b>
	 *  and  returns null if it doesn't find this var. 
	 * 
	*	@param lvt current data repository
	 * @param subSystemPath the path to subSystem
	 * @param varName the name of a var (without protection!!!)
	 * 
	 * @return the global identificator of a var, or null if given path (+ VarName) doesn't exist  
	 * */
	public static String makeVarName(IVarTree lvt, String subSystemPath, String varName) {
		String risp = "";
		
		String[] path = DataPath.splitPath(subSystemPath);
		IVarTreePointer vtp = lvt.newVarTreePointer();
		
		for (int i=0; i< path.length; i++) {
			// exist given element?
			if ( !vtp.go(path[i]) ) return null;
			// is it a subsystem?
			if (Utility.T_SUBSYSTEM.equals(vtp.getType())) {
				risp += path[i] + S; 
			}
		}
		
		// exist var ?
		String newName = DataPath.addSlash(varName);
		if ( !vtp.go("Implementation" + S + newName) ) return null;

		risp += newName;
		risp = Utility.pathToEvidence(risp); // convert to "evidence path"
		
		return risp;
	}
	
	/** Searchs the path of parent subSystem, or to System if there isn't any parent subSystem.
	 *  Returns null if given path is a System path or if given path identifies a non-existent node.
	 * 
	*	@param lvt current data repository
	 * @param subSystemPath the path to subSystem
	 * 
	 * @return the path of parent subSystem, or to System, or null if element identifes by given path is a System.
	 * Also returns null if given path identifies a non-existent node.   
	 * */
	public static String parentSubSystemPath(IVarTree lvt, String subSystemPath) {
		String risp = "" + S;   boolean rispSys = false;
		String tmp1 = ""; boolean sys1 = false;
		String tmp2 = "";
			
		String[] path = DataPath.splitPath(subSystemPath);
		IVarTreePointer vtp = lvt.newVarTreePointer();
			
		for (int i=0; i< path.length; i++) {
			// exist given element?
			if ( !vtp.go(path[i]) ) return null;

			tmp2+= path[i] +S;

			// is it a subsystem or a System
			if (Utility.T_SUBSYSTEM.equals(vtp.getType()) || "System".equals(vtp.getType()) ) {
				// shift :  "" > tmp2 > tmp1 >> risp
				risp += tmp1;
				tmp1 = tmp2;
				tmp2 = "";
				// set sys
				rispSys = sys1;
				sys1 = "System".equals(vtp.getType());
			}
		}
		
		// try to return a system path?
		if (rispSys) {
			risp += "Functional" + S;
			if ((lvt.newTreeInterface()).exist(risp, "Functional")) {
				return risp; 
			} else {
				// Why ??
				// given path is correct but there isn't any functional node!!
				return null; 
			}
		}
		
		// no risp.
		if ("".equals(risp)) return null;
				
		return risp;
	}

	
}
