/*
 * Created on 30-mar-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.eu.evidence.rtdruid.vartree.tools;

// projects package

import java.util.Properties;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVariable;

// standard java package

// exceptions

/** Checks if some type of references are corrected 
 * 
 * @author Nicola Serreli
 */
public class CheckReferences {
	/** Abbreviation for VarTree.SEPARATOR */
	protected final static String S = "" + IVarTree.SEPARATOR;
	
	/** ID for mode's type  */
	public final static String MODE_ID = "Mode";

	/** Current system */
	private String sysName;
	private String sysPath;
	private IVarTree vt;
	// TODO: aumentare i controlli per la consistenza dei dati (riferimenti e simini) 


	/**	Make a new 'checkReference' for given system
	 * 
	*	@param vt current data repository
	 *  @param system the system path (with protection)
	 * 
	 *   @throws NullPointerException if system is null
	 * */
	public CheckReferences(IVarTree vt, String system) {
        if (vt == null) {
			throw new NullPointerException(
					"Required a not null data repository");
		}
		if (system == null) {
//			throw new NullPointerException("Required a not null System name");
		}
		
		this.vt = vt;
		this.sysName = DataPath.removeSlash(DataPath.removeSlash(system));
		this.sysPath = system.startsWith("" + DataPath.SEPARATOR) ?
					system : "" + DataPath.SEPARATOR + system;
		
	}
	
	/**	Return the name of current system (without protection, see {@link rtdruid.vartree.IVarTree#addSlash rtdruid.vartree.VarTree.addSlash()})
	 */
	public String getSystemName() {
		return sysName;
	}


	public boolean checkAll() {
		boolean risp = true;
		boolean tmp;
		try {
		
			tmp = checkModes(); risp &= tmp;
			tmp = checkMethods(); risp &= tmp;
			tmp = checkMethodRefNames(); risp &= tmp;
			tmp = checkEventRef(); risp &= tmp;
			tmp = checkRtosRef(); risp &= tmp;
			
			tmp = checkVarMap(); risp &= tmp;
			//tmp = checkProcMap(); risp &= tmp;
			
		} catch (Exception e) {
		    risp = false;
			Messages.sendErrorNl(e.getMessage(), null, "891624quwlgr", new Properties());
			e.printStackTrace();	
		}
		return risp;
	}

	//------------------------------ MODE
	
	/** Checks if a mode exist in current system
	 * 
	 * @param modeName identifies the mode to search (without protection, see {@link rtdruid.vartree.IVarTree#addSlash rtdruid.vartree.VarTree.addSlash()})
	 * 
	 * @return true if modeName is null or if it exists, false otherwise.
	 * */
	public boolean existMode(String modeName) {
		if (modeName == null) {
			return true;
		}
		return (vt.newTreeInterface()).exist(S + sysPath + S + "Modes" + S + "ModeList"
		        + S + DataPath.makeSlashedId(modeName), MODE_ID);
	}
	
	/** Looks for all modeRef and checks them
	 * 
	 */
	public boolean checkModes() {
		IVarTreePointer vtp = vt.newVarTreePointer();
		if (vtp.goAbsolute( sysPath )) {
			return checkModes( vtp );
		}
		return true;
	}
	
	/** Recursively looks for all modeRef and checks them
	 * 
	 * @param vtp the current node
	 * */
	private boolean checkModes(IVarTreePointer vtp) {
		boolean risp = true;
		
		{ // check current node 
			String type = vtp.getType();
			
			
			String[][] okType = {
				// { "NodeType"
				{ "PartialOrder",  "0" },
				{ "TimeConst", "0" },
				{ "Scheduling", "0" },
				{ "Activation", "0" },
				{ "ResourceRef", "0" },
				{ "MutexRef", "0" },
				{ "SchedulingScenario", "0" },
				{ "ProcMap", "0" },
				{ "TaskMap", "0" },
				{ "VarMap", "0" },
				{ "ExecTimeList", "0" }
			};
			
			for (int i=0; i<okType.length; i++) {
				if (okType[i][0].equals(type)) {
					int pos = Integer.parseInt(okType[i][1]);
					String modeName =  DataPath.resolveId(DataPath.removeSlash(vtp.getName()))[pos];
					
					if (!existMode(modeName)) {
//						sendWarning("A "+ vtp.getType() +"("+vtp.getName()+") Requires a nonexistent mode : " + modeName);
						sendWarning("Required a nonexistent mode : " + modeName);
						risp = false;
					}
					
					return risp;
				}
			}
			
			if ("ModeRef".equals(vtp.getName())) {
			    IVariable var = vtp.getVar();
				String modeName = var == null ? null : (String) var.get();
				
				if (!existMode(modeName)) {
					sendWarning("Required a nonexistent mode : " + modeName);
					risp = false;
				}
			}
		}
		
		{ // check for children
			if (vtp.getChildrenNumber() >0) {
				IVarTreePointer child = (IVarTreePointer) vtp.clone();
				child.goFirstChild();
				do {
					// if use
					//             risp &= checkModes(child)
					// when risp == false
					// it's possible that the program doesn't computate checkModes(Child) 
					boolean tmpRisp = checkModes(child);
					risp &= tmpRisp;
				} while (child.goNextSibling()); 
			}
		}
		
		return risp;
	}
	
	//	-------------------------------- METHODS
	/** Checks all method ref in current system
	 */
	public boolean checkMethods() {
		IVarTreePointer vtp = vt.newVarTreePointer();
		if (vtp.goAbsolute( sysPath )) {
			return checkMethods("", vtp );
		}
		return true;
	}
	
	/**
	 * */
	private boolean checkMethods(String path, IVarTreePointer vtp) {
		boolean risp = true;
//Messages.sendDebug("check Method " + path);		
		{ // check current node 
			String type = vtp.getType();
			IVarTreePointer child = (IVarTreePointer) vtp.clone();
			
			/*
			 * PROC 
			 */
			if ("Proc".equals(type)) {
				// remove "Implementation" from path
				final String DROP =  "" + S + "Implementation";
				String prefix = path.endsWith(DROP) ? path.substring(0, path.length() - DROP.length()) : path;
				
				boolean tmp = child.go("MethodRefList");
				tmp &= child.goFirstChild();
				if (tmp ){
					do {
						boolean tmpRisp = checkMethodRef(prefix, child, true);
						risp &= tmpRisp;
						
					} while (child.goNextSibling());
				}
				
				return risp;
				
			} else 
			/*
			 * REQUIRED INTERFACE 
			 */
			if ("RequiredInterface".equals(type)) {
				// try to get method name
				if (!child.go("ExternalMethodRef")) return risp;
				
				IVariable var = child.getVar();
				String methodName = var == null ? null : (String) var.get();
				if (methodName != null) {
					// correct path and make a new loop
					String prefix = Mapping.parentSubSystemPath(vt, path);
					
					if (Search.aLocalMethod(vt.newTreeInterface(), prefix, methodName) == null) {
						sendWarning("Reference to a not valid method : " + methodName);
						risp = false;
					}

				}
				
				return risp;
				
			} else 
			/*
			 * PROVIDED INTERFACE
			 */
			if ("ProvidedInterface".equals(type)) {
				if (!child.go("LocalObjectRef")) return risp;	// nothing to do (Not mapped??)
				IVariable var = child.getVar();
				String objName    =  var == null ? null : (String) var.get();
				
				child =  (IVarTreePointer) vtp.clone();
				if (!child.go("LocalMethodRef")) return risp;	// nothing to do (Not mapped??)
				var = child.getVar();
				String methodName    =  var == null ? null : (String) var.get();

				if (objName == null || methodName == null) {
					// nothing to do (Not mapped??)
					return risp;
				}
							
				// compose a method identificator and make a new loop
				String methId = objName + S + methodName; 
							
				// remove "Implementation" from path
				final String DROP =  "" + S + "ProvidedInterfaceList";
				String prefix = path.endsWith(DROP) ? path.substring(0, path.length() - DROP.length()) : path;

				if (Search.aLocalMethod(vt.newTreeInterface(), prefix, methId) == null) {
					sendWarning("Reference to a not valid method : " + methodName);
					risp = false;
				}
				
				return risp;
			} else 
			/*
			 * TRIGGER
			 */
			if ("Trigger".equals(type)) {
				
				// remove "Implementation" from path
				final String DROP =  "" + S + "TriggerList";
				String prefix = path.endsWith(DROP) ? path.substring(0, path.length() - DROP.length()) : path;
				
				boolean tmp = child.go("MethodRefList");
				tmp &= child.goFirstChild();
				if (tmp ){
					do {
						boolean tmpRisp = checkMethodRef(prefix, child, false);
						risp &= tmpRisp;
						
					} while (child.goNextSibling());
				}
				
				return risp;
			} else 
			/*
			 * RESOURCE REF
			 */
			if ("ResourceRef".equals(type)) {
				if (!child.go("MethodName")) return risp;	// nothing to do (Not mapped??)
				IVariable var = child.getVar();
				String methName    =  var == null ? null : (String) var.get();
					
				if (methName != null) {
					if (Search.aResourceMethod(vt.newTreeInterface(), sysPath, methName) == null) {
						sendWarning("Reference to a not valid Resource method : " + methName);
						risp = false;
					}
				}
				
				return risp;
			} 
			
		}
		
		{ // check for children
			if (vtp.getChildrenNumber() >0) {
				String newPath = path + S + vtp.getName();
				IVarTreePointer child = (IVarTreePointer) vtp.clone();
				child.goFirstChild();
				do {
					if (child.getChildrenNumber() == 0) {
						continue;
					}
					// if use
					//             risp &= checkModes(child)
					// when risp == false
					// it's possible that the program doesn't computate checkModes(Child) 
					boolean tmpRisp = checkMethods(newPath, child);
					risp &= tmpRisp;
				} while (child.goNextSibling()); 
			}
		}
		
		return risp;
	}
	
	
	/** Checks for a local method using link stored in a methodRef
	 * 
	 * @param path identifies the system (functional) or subSystem node
	 * @param vtp contains the current node (a methodRef)
	 * 
	 * @return true if no MethodName is defined, or if it's defined and existent, false otherwise 
	 * */
	private boolean checkMethodRef(String path, IVarTreePointer vtp, boolean isLocal) {
		
		IVarTreePointer child = (IVarTreePointer) vtp.clone();

		// looks for Method name
		if (!child.go("MethodName")) return true; // not found or not valid !!
		
		IVariable var = child.getVar();
		String method = var == null ? null : (String) var.get();
		
		if (method != null) {
			if (isLocal ?
				Search.aLocalMethod(vt.newTreeInterface(), path, method) == null :
				Search.aMethod(vt.newTreeInterface(), sysPath, method) == null
			) {
				sendWarning("Reference to a non valid method : " + method);
				return false;
			}
		}
		return true;
	}
	
	//	-------------------------------- METHODREF NAMES


	/** Looks for all event checks theirs MethodRefName
	 * 
	 */
	public boolean checkMethodRefNames() {
		ITreeInterface ti = vt.newTreeInterface();
		ITreeInterface.TiInfo[] events = ti.getAll(sysPath + S + "Functional" + S + "EventList" + S + ITreeInterface.SPECIAL + S + "MethodRefName", "Event");
		
		boolean risp = true;
		for (int i=0; i< events.length; i++) {
			IVariable var = events[i].getVariable();
			String methodRefName  = var == null ? null : (String) var.get();
			if (methodRefName == null) {
				continue;
			}
			
			if (Search.aMethodRef(vt.newTreeInterface(), sysPath, methodRefName) == null) {
				sendWarning("Reference to a non valid methodRef : " + methodRefName);
				risp =  false;
			}
		}

		return risp;
	}
	
	//	-------------------------------- EVENTREF
	
	/** Looks for all TimeConst and PartialOrder, and checks theirs EventRef
	 * 
	 */
	public boolean checkEventRef() {
		boolean risp = true;

		ITreeInterface ti = vt.newTreeInterface();
		{	// timeConst
			ITreeInterface.TiInfo[] timeConstFirst = ti.getAll(
					sysPath + S + "Functional" + S + "TimeConstList" + S + ITreeInterface.SPECIAL + S + "First"
					, "Event");
			ITreeInterface.TiInfo[] timeConstSecond = ti.getAll(
					sysPath + S + "Functional" + S + "TimeConstList" + S + ITreeInterface.SPECIAL + S + "First"
					, "Event");
			
			boolean tmp = checkEventRef(timeConstFirst); risp &= tmp;
			tmp = checkEventRef(timeConstSecond);  risp &= tmp;
		}
		
		

		{ // PartialOrder
			String path = sysPath + S + "Functional" + S + "PartialOrderList";
			String[] names = ti.getAllName(path, "PartialOrder");
			
			for (int i=0; i<names.length; i++) {

				ITreeInterface.TiInfo[] partialOrderFirst = ti.getAll(
						sysPath + S + "Functional" + S + "TimeConstList" + S + names[i] + S + "First" + S + "First"
						, "Order");
				ITreeInterface.TiInfo[] partialOrderSecond = ti.getAll(
						sysPath + S + "Functional" + S + "TimeConstList" + S + names[i] + S + "First" + S + "Second"
						, "Order");
			
				boolean tmp = checkEventRef(partialOrderFirst); risp &= tmp;
				tmp = checkEventRef(partialOrderSecond); risp &= tmp;
			}
					
		}
		return risp;
	}
	
	/**
	 */
	private boolean checkEventRef(ITreeInterface.TiInfo[] data) {
		boolean risp = true;
		for (int i=0; i< data.length; i++) {
			String eventRef  =(String) data[i].getVariable().get();
			if (eventRef == null) {
				continue;
			}
			
			if (Search.anEvent(vt.newTreeInterface(), sysPath, eventRef) == null) {
				sendWarning("Reference to a not valid event: " + eventRef);
				risp =  false;
			}
		}
		
		return risp;
	}
	
	//	-------------------------------- RTOS REF
	
	/** Looks for all TaskMap element, and checks theirs rtosRef
	 * 
	 */
	public boolean checkRtosRef() {
		boolean risp = true;

		ITreeInterface ti = vt.newTreeInterface();
		// timeConst
		ITreeInterface.TiInfo[] data = ti.getAll(
				sysPath + S + "Mapping" + S + "TaskMapList" + S + ITreeInterface.SPECIAL + S + "RtosRef"
				, "TaskMap");
		
		for (int i=0; i< data.length; i++) {
			String rtosRef  =(String) data[i].getVariable().get();
			
			if (Search.aRtos(vt.newTreeInterface(), sysPath, rtosRef).length == 0) {
				sendWarning("Reference to a not valid rtos: " + rtosRef);
				risp =  false;
			}
		}

		return risp;
	}

	// -------------------------------- VAR MAP
	
	/** Looks for all VarMap element, and checks theirs rtosRef
	 * 
	 */
	public boolean checkVarMap() {
		boolean risp = true;

		ITreeInterface ti = vt.newTreeInterface();
		
		String[] varMapNames = ti.getAllName(sysPath + S + "Mapping" + S + "VarMapList", "VarMap");
		
		
		for (int i=0; i< varMapNames.length; i++) {
			String prefix = sysPath+S+"Mapping"+S+"VarMapList"+S+varMapNames[i];
			
			{ // check mutex
				IVariable var = ti.getValue(prefix+S+"MutexRef");
				String mutexName = null;
				if (var != null) {
					mutexName = (String) var.get();
				}
				if (!ti.exist(sysPath+S+"Architectural"+S+"MutexList"+S+DataPath.makeSlashedId(mutexName), "Mutex")) {
					sendWarning("Reference to a not valid mutex: " + mutexName);
					risp =  false;
				}
			}
			
			{ // check var
				IVariable var = ti.getValue(prefix+S+"VarRef");
				String varName = null;
				if (var != null) {
					varName = (String) var.get();
				}
				if (Search.aVar(ti, sysPath, varName) == null) {
					sendWarning("Reference to a not valid var: " + varName);
					risp =  false;
				}
			}
		}

		return risp;
	}
	
	
	// -------------------------------- PROC MAP

	// -------------------------------- OUTPUT
	
	private void sendError(String txt){
		Messages.sendErrorNl(txt, txt, "CheckReferences", null);
	}

	private void sendWarning(String txt){
		Messages.sendWarningNl(txt, txt, "CheckReferences", null);
	}
}
