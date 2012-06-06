/*
 * Created on 11/dic/07
 *
 * $Id: TaskUtility.java,v 1.1 2008/01/09 17:53:03 durin Exp $
 */
package com.eu.evidence.rtdruid.vartree.tools;

import java.util.ArrayList;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

public class TaskUtility implements ITaskUtility {
	
	protected final static String ARC = DataPackage.eINSTANCE.getArchitectural().getName();
	protected final static String TASK_LIST = DataPackage.eINSTANCE.getArchitectural_TaskList().getName();
	
	protected final static String MAPPING = DataPackage.eINSTANCE.getMapping().getName();
	protected final static String TASK_MAP_LIST = DataPackage.eINSTANCE.getMapping_TaskMapList().getName();
	protected final static String TASK_MAP_REF = DataPackage.eINSTANCE.getTaskMap_TaskRef().getName();

	protected final static String PROC_MAP_LIST = DataPackage.eINSTANCE.getMapping_ProcMapList().getName();
	protected final static String PROC_MAP_TREF = DataPackage.eINSTANCE.getProcMap_TaskRef().getName();

	protected final static String TASK_T = DataPackage.eINSTANCE.getTask_Type().getName();
	protected final static String TASK_ACT =  DataPackage.eINSTANCE.getTask_ActivationList().getName();
	protected final static String ACTIVATION =  DataPackage.eINSTANCE.getActivation().getName();
	protected final static String ACTIVATION_T =  DataPackage.eINSTANCE.getActivation_Type().getName();

	protected final static String[] TASK_TYPES = {
		DataPackage.eINSTANCE.getSystem().getName(), // 0
		DataPackage.eINSTANCE.getSystem_Architectural().getName(), // 1
		DataPackage.eINSTANCE.getArchitectural_TaskList().getName(), // 2
		DataPackage.eINSTANCE.getTask().getName()}; //3
		
	protected IVarTree vt;
	
	public TaskUtility(IVarTree vt) {
		this.vt = vt;
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.vartree.tools.ITaskUtility#removeTasks(java.util.ArrayList)
	 */
	public void removeTasks(ArrayList<String> names) {
		
		boolean transaction = vt.getCurrentTransaction() == null;
		if (transaction) {
			vt.beginTransaction();
		}
		try {
			
			IVarTreePointer vtp_arch = vt.newVarTreePointer();
			boolean ok = vtp_arch.goFirstChild();
			ok &= vtp_arch.go(ARC);
			ok &= vtp_arch.go(TASK_LIST);
			
			IVarTreePointer vtp_map = vt.newVarTreePointer();
			ok &= vtp_map.goFirstChild();
			ok &= vtp_map.go(MAPPING);

			if (ok) {
				for (int i=0; i<names.size(); i++) {
					String curr = (String) names.get(i);
					if (vtp_arch.go(curr)) {
						vtp_arch.destroy();
						
						removeTaskRtosMapping((IVarTreePointer) vtp_map.clone(), curr);
						removeProcTaskMapping((IVarTreePointer) vtp_map.clone(), curr);
					}
				}
			}
			
			
		} catch (Throwable e) {
			RtdruidLog.log(e);
			if (transaction) {
				vt.rollbackTransaction();
			}
		} finally {
			if (transaction) {
				vt.commitTransaction();
			}
		}
		
	}
	
	protected void removeTaskRtosMapping(IVarTreePointer vtp, String task) {
		
		// search inside every taskMap element the specified task
		for (boolean go = vtp.go(TASK_MAP_LIST) && vtp.goFirstChild(); go; ) {
			
			boolean found = false;
			// check the taskRef
			if (vtp.go(TASK_MAP_REF)) {
				IVariable v = vtp.getVar();
				found = task.equals(v != null ? v.get() : null);
				vtp.goParent();
			}
			if (found) {
				// remove current node
				IVarTreePointer tmp = (IVarTreePointer) vtp.clone();
				
				go = vtp.goNextSibling();
				tmp.destroy();
				
			} else {
				// go to the next
				go = vtp.goNextSibling();
				
			}
		}
	}

	protected void removeProcTaskMapping(IVarTreePointer vtp, String task) {
		
		// search inside every taskMap element the specified task
		for (boolean go = vtp.go(PROC_MAP_LIST) && vtp.goFirstChild(); go; ) {
			
			boolean found = false;
			// check the taskRef
			if (vtp.go(PROC_MAP_TREF)) {
				IVariable v = vtp.getVar();
				found = task.equals(v != null ? v.get() : null);
				vtp.goParent();
			}
			if (found) {
				// remove current node
				IVarTreePointer tmp = (IVarTreePointer) vtp.clone();
				
				go = vtp.goNextSibling();
				tmp.destroy();
				
			} else {
				// go to the next
				go = vtp.goNextSibling();
				
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.vartree.tools.ITaskUtility#createTasks(java.util.ArrayList)
	 */
	public void createTasks(ArrayList<String> names) {

		boolean transaction = vt.getCurrentTransaction() == null;
		if (transaction) {
			vt.beginTransaction();
		}
		try {
			
			IVarTreePointer vtp = vt.newVarTreePointer();
			if (!vtp.goFirstChild()) {
				vtp.add("default", TASK_TYPES[0]);
				vtp.goFirstChild();
			}
			if (!vtp.go(ARC)) {
				vtp.add(ARC, TASK_TYPES[1]);
				vtp.go(ARC);
			}
			if (!vtp.go(TASK_LIST)) {
				vtp.add(TASK_LIST, TASK_TYPES[2]);
				vtp.go(TASK_LIST);
			}
			
			for (int i=0; i<names.size(); i++) {
				String curr = (String) names.get(i);
				if (!vtp.go(DataPath.addSlash(curr))) {
					vtp.add(TASK_LIST, TASK_TYPES[3]);
					vtp.goParent();
				}
			}
			
		} catch (Throwable e) {
			RtdruidLog.log(e);
			if (transaction) {
				vt.rollbackTransaction();
			}
		} finally {
			if (transaction) {
				vt.commitTransaction();
			}
		}

	}


	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.vartree.tools.ITaskUtility#createTask(java.lang.String)
	 */
	public void createTask(String name) {

		boolean transaction = vt.getCurrentTransaction() == null;
		if (transaction) {
			vt.beginTransaction();
		}
		try {
			
			IVarTreePointer vtp = vt.newVarTreePointer();
			if (!vtp.goFirstChild()) {
				vtp.add("default", TASK_TYPES[0]);
				vtp.goFirstChild();
			}
			if (!vtp.go(ARC)) {
				vtp.add(ARC, TASK_TYPES[1]);
				vtp.go(ARC);
			}
			if (!vtp.go(TASK_LIST)) {
				vtp.add(TASK_LIST, TASK_TYPES[2]);
				vtp.go(TASK_LIST);
			}
			
			if (!vtp.go(DataPath.makeSlashedId(name))) {
				vtp.add(DataPath.addSlash(name), TASK_TYPES[3]);
				
				IVarTreePointer tmp = (IVarTreePointer) vtp.clone();
				tmp.go(DataPath.makeSlashedId(name));
				fillTask(tmp);
				vtp.goParent();
			}
			
		} catch (Throwable e) {
			RtdruidLog.log(e);
			if (transaction) {
				vt.rollbackTransaction();
			}
		} finally {
			if (transaction) {
				vt.commitTransaction();
			}
		}

	}

	protected void fillTask(IVarTreePointer vtp) {
		
		// set the type
		if (vtp.go(TASK_T)) {
			IVariable v = vtp.getNewVar("task");
			vtp.setVar(v);
			vtp.goParent();
		}
		
		// set periodic
		{
			if (!vtp.go(TASK_ACT)) {
				vtp.add(TASK_ACT, TASK_ACT);
				vtp.go(TASK_ACT);
			}
			if (!vtp.go(ACTIVATION)) {
				vtp.add(null, ACTIVATION);
				vtp.go(DataPath.makeSlashedId((String)null));
			}
			if (!vtp.go(ACTIVATION_T)) {
				vtp.add(ACTIVATION_T, ACTIVATION_T);
				vtp.go(ACTIVATION_T);
			}
			IVariable v = vtp.getNewVar("periodic");
			vtp.setVar(v);
			
			vtp.goParent(); // activation
			vtp.goParent(); // activation_list = task_act
			vtp.goParent(); // task
		}

	}
	

}
