/*
 * Created on 11-nov-2004
 *
 * $Id: SimpleTransform.java,v 1.7 2008/03/26 18:23:51 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.transform;



import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Stack;

import org.eclipse.core.runtime.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.common.OilObjectList;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilTransformException;
import com.eu.evidence.rtdruid.internal.modules.oil.implementation.OilImplFactory_Impl;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IOilXMLLabels;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.abstractions.SimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplFactory;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplID;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IOilImplElementDescr;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IOilImplPointer;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IOilImplementation;
import com.eu.evidence.rtdruid.vartree.IMultiValues;
import com.eu.evidence.rtdruid.vartree.ISubVarTreePointer;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenRes;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Task;
import com.eu.evidence.rtdruid.vartree.abstractions.old.TaskSet;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.init.DataPath;
import com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage;
import com.eu.evidence.rtdruid.vartree.tools.Search;
import com.eu.evidence.rtdruid.vartree.tools.Utility;
import com.eu.evidence.rtdruid.vartree.variables.OilVarMP;
import com.eu.evidence.rtdruid.vartree.variables.StringVar;

/**
 * This class just store all data inside the OilVar of each FirstLevelObject
 * (OS, TASK, ...)
 * 
 * @author Nicola Serreli
 */
public class SimpleTransform implements IOilTransform {

	protected final static int SYSTEM_NUMBER = 1;

	protected final static OilApplPackage OAPKG = OilApplPackage.eINSTANCE;

	protected final static DataPackage DPKG = DataPackage.eINSTANCE;

	protected final static String INDENT = "    ";

	protected static final String TASK_MAPPING = "sgrk_task_mapping";
	protected static final String TASK_FORCE_MAPPING = "sgrk_task_add_mapping";

	protected IVarTree vt;

	/** If true, is required to write the implementation section */
	protected boolean writeImplementation = false;

	// -------------------------------
	protected String[] rtosNamePath;

	protected String[] rtosTypePath = {
			DPKG.getSystem_Architectural().getName(),
			DPKG.getArchitectural_EcuList().getName(), DPKG.getEcu().getName(),
			DPKG.getEcu_CpuList().getName(), DPKG.getCpu().getName(),
			DPKG.getCpu_Rtos().getName(), DPKG.getRtos_OilVar().getName() };

	/** All types of Oil Object that are stored inside the OS's OilVar * */
	protected String[] otherObjectsTypes = { IOilXMLLabels.OBJ_APPMODE,
			IOilXMLLabels.OBJ_COM, IOilXMLLabels.OBJ_IPDU,
			IOilXMLLabels.OBJ_MESSAGE, //IOilXMLLabels.OBJ_NETWORKMESSAGE,
			IOilXMLLabels.OBJ_NM };

	// -------------------------------
	protected IOilImplementation oilImpl;

	// -------------------------------

	/**
	 * Prepare the prefix for all data that will be stored inside the OilVar.
	 * 
	 * 
	 */
	public static String[] makeOilVarPrefix(boolean addName, String name,
			String objType, OilImplID id) {
		String objId = (addName ? DataPath.makeSlashedId(new String[] {
				objType, name }) : objType);

		return new String[] { objId, OAPKG.getRoot_HwList().getName(),
				DataPath.makeId(id.getHW()), OAPKG.getHW_RtosList().getName(),
				DataPath.makeId(id.getRtos()) };
	}

	// -------------------------------

	/**
	 * Store all given data inside the given VarTree. It requires also the id
	 * of HW and RT-OS. Doesn't check or use Transaction or roll-back. Uses
	 * VarTree interface. <br>
	 * <br>
	 * Before store anythings merge all
	 * 
	 * @param vt
	 *            where store all data
	 * @param appl
	 *            the data
	 * @param id
	 *            HW and RT-OS ids for data
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	public void load(IVarTree lvt, Document appl, OilImplID id)
			throws OilTransformException {
		Assert.isLegal(lvt != null, "Expected a not null VarTree");
		Assert.isLegal(appl != null, "Expected a not null Document");
		Assert.isLegal(id != null, "Expected a not null OilImplID");

		vt = lvt;
		oilImpl = OilImplFactory.getAnInstance(vt).getImpl(id);

		Element application = appl.getDocumentElement();
		checkTrue("application".equalsIgnoreCase(application.getNodeName()),
				"Expected an application node");
		
		if (!application.hasAttribute("Name")) {
			// empty ?
			
			checkTrue(!application.hasChildNodes(),
					"ask to create an unamed system with some children");
			
			// nothing to do
			return;
		}
		
		String sysName = application.getAttribute("Name");
		IVarTreePointer systemVtp = checkSystemName(vt, sysName);

		// check and store all objects
		/* RT-OS */
		String rtosName = storeOS(systemVtp, application, sysName, id);
		/* TASK */
		storeTasks(systemVtp, application, id, rtosName);
		/* ISR */
		storeIsr(systemVtp, application, id, rtosName);
		/* RESOURCE */
		storeMutex(systemVtp, application, id);
		/* ALARM, COUNTER and EVENT */
		storeSignals(systemVtp, application, id);
		/* APPMODE */
		storeAppmode(systemVtp, application, id);
		/* OS Application */
		storeOsApplication(systemVtp, application, sysName, id);
		/* Network messages */
		storeNetworkMessages(systemVtp, application, id);

		/* OTHER OBJECTS */
		storeOthers(systemVtp, application, rtosName, id);

	}

	/**
	 * Checks if exist the system used in the Oil data. If the VarTree contains
	 * the given System, this method just exits, else it tries to add a new
	 * System, but if VarTree already contains the max number of System, it
	 * throw a OilParserException.
	 * 
	 * @param vt
	 *            where store the system
	 * @param name
	 *            the system name
	 * 
	 * @return an IVarTreePointer to
	 * 
	 * @throws OilTransformException
	 *             if the system doesn't already exist and this method cannot
	 *             add a new System
	 */
	protected IVarTreePointer checkSystemName(IVarTree vt, String name)
			throws OilTransformException {
		ITreeInterface ti = vt.newTreeInterface();
		String systemType = DPKG.getSystem().getName();

		/* Check if already exist a system */
		int currSysNumber = ti.getAllName(null, systemType).length;

		IVarTreePointer vtp = vt.newVarTreePointer();

		/* use an already stored */
		if (vtp.go(S + DataPath.makeSlashedId(name))) {
			checkTrue(systemType.equals(vtp.getType()),
					"The required System already exist, but with a different type.");
			return vtp;
		}

		/*checkTrue(
				currSysNumber < SYSTEM_NUMBER,
				"VarTree already contains the max number of System, and cannot add the new given system :"
						+ name);*/

		try {
			if(currSysNumber < SYSTEM_NUMBER){
				ti.addElement(name, systemType, null);
			}
		} catch (ITreeInterface.AddElementException e) {
			throw new OilTransformException(
					"Cannot make a new system with given name :" + name);
		}
		checkTrue(vtp.go(S + DataPath.makeSlashedId(name)),
				"Error when try to add the new System");

		return vtp;

	}

	/**
	 * Store all data of an rtos inside the OilVar of element
	 * "/SystemName/Architecture/EcuList/OilEcu/CpuList/rtosName/Rtos", where
	 * the <b>SystemName </b> and <b>rtosName </b> are the values stored inside
	 * the <b>Application Name </b> and <b>OS Name </b>. Returns the name of
	 * RT-OS.
	 * 
	 * @param vtp
	 *            point to the system
	 * @param parent
	 *            the parent node
	 * @param id
	 *            contains the hw and rtos id of this data
	 * 
	 * @return the name of RT-OS
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	protected String storeOS(IVarTreePointer vtp, Element parent,
			String sysName, OilImplID id) throws OilTransformException {
		String rtosName = null;
		rtosNamePath = new String[] { DPKG.getSystem_Architectural().getName(),
				DPKG.getArchitectural_EcuList().getName(), sysName, // ecu name
																	// ... from
																	// oil
				DPKG.getEcu_CpuList().getName(), //
				sysName, // cpu name ... from oil
				DPKG.getCpu_Rtos().getName(), DPKG.getRtos_OilVar().getName() };

		// prepare where store all data
		Element[] osList = getAllSameElements(parent, "Object",
				new String[] { "type" }, new String[] { IOilXMLLabels.OBJ_OS });
		if (osList.length > 0) {
			rtosName = getAttribute(osList[0], "Name");
			// update the rtosNamePath
			//rtosNamePath[5] = rtosName;

			// set the HW model
			IVarTreePointer curr = makePath(vtp, new String[] { rtosNamePath[0],
					rtosNamePath[1], rtosNamePath[2], rtosNamePath[3],
					rtosNamePath[4] }, new String[] { rtosTypePath[0],
					rtosTypePath[1], rtosTypePath[2], rtosTypePath[3],
					rtosTypePath[4] });
			storeAVar(curr, DPKG.getCpu_Model().getName(), id.getHW());

			curr = makePath(curr, new String[] { rtosNamePath[5] },
					new String[] { rtosTypePath[5] });
			storeAVar(curr, DPKG.getRtos_Name().getName(), rtosName);
			storeAVar(curr, DPKG.getRtos_Type().getName(), id.getRtos());

			curr = makePath(curr, new String[] { rtosNamePath[6] },
					new String[] { rtosTypePath[6] });

			// store all instance of OS object from Oil tree
			for (int i = 0; i < osList.length; i++) {

				// check the rtosName
				checkTrue(checkStrings(rtosName,
						getAttribute(osList[i], "Name")),
						"The oil tree contains more than one "
								+ IOilXMLLabels.OBJ_OS);

				storeInsideAOilVar(curr, osList[i], id);

			} // end for(osList[0] ... osList[n])
		}

		return rtosName;
	}

	/**
	 * Store all data of an Os Application inside the OilVar of element
	 * "/SystemName/Architecture/EcuList/OilEcu/CpuList/OsApplicationsList/OsApplication", where
	 * the <b>SystemName </b> are the values stored inside
	 * the <b>Application Name </b>.
	 * 
	 * @param vtp
	 *            point to the system
	 * @param parent
	 *            the parent node
	 * @param id
	 *            contains the hw and rtos id of this data
	 * 
	 * @return the name of RT-OS
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	protected void storeOsApplication(IVarTreePointer vtp, Element parent,
			String sysName, OilImplID id) throws OilTransformException {
		String[] basePath = new String[] {
				DPKG.getSystem_Architectural().getName(), // 0 
				DPKG.getArchitectural_EcuList().getName(), // 1
				sysName, // ecu name ... from oil 2
				DPKG.getEcu_CpuList().getName(), // 3
				IWritersKeywords.DEFAULT_CPU_NAME, // cpu name ... from oil 4
				DPKG.getCpu_OsApplication().getName(), // 5
				null, // Os Application name 6
				DPKG.getOsApplication_OilVar().getName() }; // 6

		String[] baseType = new String[] { DPKG.getSystem_Architectural().getName(),
				DPKG.getArchitectural_EcuList().getName(), sysName, // ecu name
																	// ... from
																	// oil
				DPKG.getEcu_CpuList().getName(), //
				DPKG.getCpu().getName(), // cpu name ... from oil
				DPKG.getCpu_OsApplication().getName(),
				DPKG.getOsApplication().getName(), // Os Application name
				DPKG.getOsApplication_OilVar().getName() };
		
		
		
		{
			ITreeInterface ti = vt.newTreeInterface();
			String[] cpuNames = ti.getAllName(Search.systemName(vt) +S+ basePath[0] +S+ basePath[1] +S+ basePath[2] +S+ basePath[3], baseType[4]);
			if (cpuNames != null && cpuNames.length>0) {
				boolean default_is_valid = false;
				for (String cpuName: cpuNames) {
					if (basePath[4].equals(cpuName)) {
						default_is_valid = true;
						break;
					}
				}
				if (!default_is_valid) {
					basePath[4] = cpuNames[0];
				}
			}
		}
		
		
		// prepare where store all data
		Element[] osApList = getAllSameElements(parent,
				IOilXMLLabels.ELEM_OBJECT,
				new String[] { IOilXMLLabels.ATTR_TYPE },
				new String[] { IOilXMLLabels.OBJ_OSAPPLICATION });

		// aggregate instances of the same task
//		ArrayList<Element> unamedOsAppl = new ArrayList<Element>();
		ArrayList<ArrayList<Element>> namedOsAppl = new ArrayList<ArrayList<Element>>();
		{
			// namedTasksKeys is used to group together all objects with the
			// same name
			LinkedHashMap<String, ArrayList<Element>> namedOsApplKeys = new LinkedHashMap<String, ArrayList<Element>>();
			for (int i = 0; i < osApList.length; i++) {
				String tmp = getAttribute(osApList[i], IOilXMLLabels.ATTR_NAME);

//				if (tmp == null) {
//					unamedOsAppl.add(osApList[i]);
//				} else {
					if (namedOsApplKeys.containsKey(tmp)) {
						namedOsApplKeys.get(tmp).add(osApList[i]);
					} else {
						ArrayList<Element> ar = new ArrayList<Element>();
						ar.add(osApList[i]);
						namedOsApplKeys.put(tmp, ar);
						namedOsAppl.add(ar);
					}
//				}
			}
		}
		
		
		// parse all tasks. If there're more than one instance for the same
		// task, that task is parsed more than one time
		for (Iterator<ArrayList<Element>> iter = namedOsAppl.iterator(); iter.hasNext();) {
			ArrayList<Element> ar = iter.next();
		
			// the name of a task (also a null value is valid)
			final String osAppName = getAttribute(ar.get(0), "Name");

			basePath[6] = osAppName;
			IVarTreePointer curr = makePath(vtp, basePath, baseType);

			// store all instance of this TASK object inside the VarTree
			for (int i = 0; i < ar.size(); i++) {

				storeInsideAOilVar(curr, ar.get(i), id);
			}
		}
		
	}
	
	/**
	 * This method stores all tasks inside the given IVarTreePointer
	 * 
	 * @param vtp
	 *            point to the system
	 * @param parent
	 *            the parent node
	 * @param id
	 *            contains the hw and rtos id of this data
	 * @param rtos
	 *            the name of RT-OS. Required for the mapping between Tasks and
	 *            RT-OS.
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	protected void storeTasks(IVarTreePointer vtp, Element parent, OilImplID id,
			String rtos) throws OilTransformException {

		// prepare where store all data
		Element[] taskList = getAllSameElements(parent,
				IOilXMLLabels.ELEM_OBJECT,
				new String[] { IOilXMLLabels.ATTR_TYPE },
				new String[] { IOilXMLLabels.OBJ_TASK });

		// aggregate instances of the same task
		ArrayList<Element> unamedTasks = new ArrayList<Element>();
		ArrayList<ArrayList<Element>> namedTasks = new ArrayList<ArrayList<Element>>();
		{
			// namedTasksKeys is used to group together all objects with the
			// same name
			HashMap<String, ArrayList<Element>> namedTasksKeys = new HashMap<String, ArrayList<Element>>();
			for (int i = 0; i < taskList.length; i++) {
				String tmp = getAttribute(taskList[i], IOilXMLLabels.ATTR_NAME);

				if (tmp == null) {
					unamedTasks.add(taskList[i]);
				} else {
					if (namedTasksKeys.containsKey(tmp)) {
						namedTasksKeys.get(tmp).add(taskList[i]);
					} else {
						ArrayList<Element> ar = new ArrayList<Element>();
						ar.add(taskList[i]);
						namedTasksKeys.put(tmp, ar);
						namedTasks.add(ar);
					}
				}
			}
		}

		// first the task without a name (set id to null)
		// it isn't possible in a oil file !!
		if (unamedTasks.size() > 0) {

			storeATask((IVarTreePointer) vtp.clone(), unamedTasks, id);

			// also store mapping
			storeTaskMap((IVarTreePointer) vtp.clone(), null, rtos);
		}

		// parse all tasks. If there're more than one instance for the same
		// task, that task is parsed more than one time
		for (Iterator<ArrayList<Element>> iter = namedTasks.iterator(); iter.hasNext();) {
			ArrayList<Element> ar = iter.next();
			
			storeATask((IVarTreePointer) vtp.clone(), ar, id);

			// also store mapping
			storeTaskMap((IVarTreePointer) vtp.clone(), getAttribute(ar.get(0), "Name"), rtos);

		}

	}

	

	/**
	 * This method stores all isr inside the given IVarTreePointer
	 * 
	 * @param vtp
	 *            point to the system
	 * @param parent
	 *            the parent node
	 * @param id
	 *            contains the hw and rtos id of this data
	 * @param rtos
	 *            the name of RT-OS. Required for the mapping between Isr and
	 *            RT-OS.
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	protected void storeIsr(IVarTreePointer vtp, Element parent, OilImplID id,
			String rtos) throws OilTransformException {

		// prepare where store all data
		Element[] isrList = getAllSameElements(parent,
				IOilXMLLabels.ELEM_OBJECT,
				new String[] { IOilXMLLabels.ATTR_TYPE },
				new String[] { IOilXMLLabels.OBJ_ISR });

		// aggregate instances of the same task
		ArrayList<Element> unamedIsr = new ArrayList<Element>();
		ArrayList<ArrayList<Element>> namedIsr = new ArrayList<ArrayList<Element>>();
		{
			// namedTasksKeys is used to group together all objects with the
			// same name
			LinkedHashMap<String, ArrayList<Element>> namedIsrKeys = new LinkedHashMap<String, ArrayList<Element>>();
			for (int i = 0; i < isrList.length; i++) {
				String tmp = getAttribute(isrList[i], IOilXMLLabels.ATTR_NAME);

				if (tmp == null) {
					unamedIsr.add(isrList[i]);
				} else {
					if (namedIsrKeys.containsKey(tmp)) {
						namedIsrKeys.get(tmp).add(isrList[i]);
					} else {
						ArrayList<Element> ar = new ArrayList<Element>();
						ar.add(isrList[i]);
						namedIsrKeys.put(tmp, ar);
						namedIsr.add(ar);
					}
				}
			}
		}

		// first the task without a name (set id to null)
		// it isn't possible in a oil file !!
		if (unamedIsr.size() > 0) {

			storeAnIsr((IVarTreePointer) vtp.clone(), unamedIsr, id);

			// also store mapping
			storeIsrMap((IVarTreePointer) vtp.clone(), null, rtos);
		}

		// parse all tasks. If there're more than one instance for the same
		// task, that task is parsed more than one time
		for (Iterator<ArrayList<Element>> iter = namedIsr.iterator(); iter.hasNext();) {
			ArrayList<Element> ar = iter.next();
			
			storeAnIsr((IVarTreePointer) vtp.clone(), ar, id);

			// also store mapping
			storeIsrMap((IVarTreePointer) vtp.clone(), getAttribute(ar.get(0), "Name"), rtos);

		}

	}

	
	/**
	 * This method stores a task inside the given IVarTreePointer
	 * 
	 * @param vtp
	 *            point to the system
	 * @param id
	 *            contains the hw and rtos id of this data
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	protected void storeATask(IVarTreePointer vtp, ArrayList<Element> ar, OilImplID id) {
		final String[] taskNamePath = { DPKG.getSystem_Architectural().getName(),
				DPKG.getArchitectural_TaskList().getName(), //
				null, // task name ... from oil
				DPKG.getTask_OilVar().getName() };
		final String[] taskTypePath = { DPKG.getSystem_Architectural().getName(),
				DPKG.getArchitectural_TaskList().getName(),
				DPKG.getTask().getName(), DPKG.getTask_OilVar().getName() };

		// the name of a task (also a null value is valid)
		final String taskName = getAttribute(ar.get(0), "Name");

		taskNamePath[2] = taskName;
		IVarTreePointer curr = makePath(vtp, taskNamePath, taskTypePath);

		curr.goParent();
		storeAVar(curr, DPKG.getTask_Type().getName(), "task");
		curr.go(DPKG.getTask_OilVar().getName());

		// store all instance of this TASK object inside the VarTree
		for (int i = 0; i < ar.size(); i++) {

			storeInsideAOilVar(curr, ar.get(i), id);
		}
		
		{ // move vars outside OilVar
			IVarTreePointer oilVtp =  (IVarTreePointer) curr.clone();
			IVarTreePointer taskVtp = (IVarTreePointer) curr.clone();
			taskVtp.goParent();
			
			final String path;
			{	// prepare path
				StringBuffer tmpPath = new StringBuffer();
				String[] el = makeOilVarPrefix(false, null, IOilXMLLabels.OBJ_TASK, id);
				
				
				for (int i=0; i<el.length; i++) {
					tmpPath.append(el[i]+S);
				}
				
				path = tmpPath.toString()+S+OilApplPackage.eINSTANCE.getRTOS_ParameterList().getName()+S;
			}
			
			
			{ // ----------- TYPE = task ------------
				String[] pNames = {
						DPKG.getTask_ActivationList().getName(), 
						null,
						DPKG.getActivation_Type().getName()
				};
				String[] pTypes = {
						DPKG.getTask_ActivationList().getName(), 
						DPKG.getActivation().getName(),
						DPKG.getActivation_Type().getName()
				};
				
				IVariable var = new StringVar("periodic");
				
				IVarTreePointer lvtp = makePath(taskVtp, pNames, pTypes);
				lvtp.setVar(var);
			}
			
			{ // ----------- PRIORITY ------------
				IVarTreePointer lvtp = extract(oilVtp, path +"PRIORITY"+S+OilApplPackage.eINSTANCE.getValue_Values().getName());
				if (lvtp!= null) {
					String[] pNames = {
							DPKG.getTask_SchedulingList().getName(), 
							null,
							DPKG.getScheduling_Priority().getName()
					};
					String[] pTypes = {
							DPKG.getTask_SchedulingList().getName(), 
							DPKG.getScheduling().getName(),
							DPKG.getScheduling_Priority().getName()
					};
					
					IVariable var = lvtp.getVar();
					// remove data
					lvtp.goParent();
					lvtp.destroy();
					
					lvtp = makePath(taskVtp, pNames, pTypes);
					lvtp.setVar(var);
				}
			}
			
			{ // ----------- ACTIVATION ------------
				IVarTreePointer lvtp = extract(oilVtp, path +"ACTIVATION"+S+OilApplPackage.eINSTANCE.getValue_Values().getName());
				if (lvtp!= null) {
					String[] pNames = {
							DPKG.getTask_ActivationList().getName(), 
							null,
							DPKG.getActivation_ActNumber().getName()
					};
					String[] pTypes = {
							DPKG.getTask_ActivationList().getName(), 
							DPKG.getActivation().getName(),
							DPKG.getActivation_ActNumber().getName()
					};
					
					IVariable var = lvtp.getVar();
					// remove data
					lvtp.goParent();
					lvtp.destroy();
					
					lvtp = makePath(taskVtp, pNames, pTypes);
					lvtp.setVar(var);
				}
			}
			
			{ // ----------- RESOURCES ------------
				IVarTreePointer lvtp = extract(oilVtp, path +"RESOURCE"+S+OilApplPackage.eINSTANCE.getValue_Values().getName());
				if (lvtp!= null) {

					IVariable var = lvtp.getVar();
					// remove data
					lvtp.goParent();
					lvtp.destroy();
					
					if (var != null) {
						
						// search all Reource's Names
						String[] values = null;
						
						if (var instanceof IMultiValues) {
							values = ((IMultiValues) var).getValues();
						} else if (var.get() != null){
							values = new String[] { var.toString() };
						}
						
						if (values != null && values.length != 0) {
							
							// path to Task's ReourcesRef
							String[][] taskResRef = {
									{ // Names
										DPKG.getTask_ResourceRefList().getName(),
										null, // mode
										DPKG.getResourceRef_ResourceMethodRef().getName()
									},
									{  // Types
										DPKG.getTask_ResourceRefList().getName(),
										DPKG.getResourceRef().getName(),
										DPKG.getResourceRef_ResourceMethodRef().getName()
									}
							};
							
							// path to Resource's Method
							String[][] resources = {
									{
										DPKG.getArchitectural_ResourceList().getName(), 
										null, // resource Name
										DPKG.getResource_Methods().getName()
									},
									{
										DPKG.getArchitectural_ResourceList().getName(), 
										DPKG.getResource().getName(),
										DPKG.getResource_Methods().getName()
									}
							};
							
							// path to Resource's MutexRef
							String[][] resMutexRef = {
									{
										DPKG.getResource_MutexRefList().getName(),
										null, // mode
										DPKG.getMutexRef_MutexName().getName()
									},
									{
										DPKG.getResource_MutexRefList().getName(),
										DPKG.getMutexRef().getName(),
										DPKG.getMutexRef_MutexName().getName()
									}
							};

							
							IVarTreePointer archVtp = (IVarTreePointer) taskVtp.clone();
							
							archVtp.goParent(); // -> taskList
							archVtp.goParent(); // -> architectural
							
							
							for (int i=0; i<values.length; i++) {
								// prepare names
								final String mutexName = values[i];
								final String resName = "res_"+mutexName;
								final String methodName = "DefaultMethod";
								
								final String resMethodName = Utility.pathToEvidence(DataPath.makeId(resName)) +
									S + methodName;
								
								// complete Resource's paths
								resources[0][1] = resName;
								
								{ // add a reference to the Resource inside the task
									lvtp = makePath(taskVtp, taskResRef[0], taskResRef[1]);
									updateVar(lvtp, resMethodName);
								}
									
								{ // make the resource
									lvtp = makePath(archVtp, resources[0], resources[1]);
									updateVar(lvtp, methodName);
								}
								
								{ // make the resource's Mutex Ref
									lvtp.goParent();
									lvtp = makePath(lvtp, resMutexRef[0], resMutexRef[1]);
									updateVar(lvtp, mutexName);
								}
								
								
								
								
								
							}
						}
					}
					
//					lvtp = makePath(taskVtp, pNames, pTypes);
//					lvtp.setVar(var);
				}
			}
		}

	}

	private void updateVar(IVarTreePointer lvtp, final String value) {
		IVariable lvar = lvtp.getVar();
		if (lvar == null) {
			lvar = lvtp.getNewVar(value);
		} else {
			if (lvar instanceof IMultiValues) {
				((IMultiValues) lvar).appendValue(value);
			} else {
				lvar.set(value);
			}
		}
		lvtp.setVar(lvar);
	}


	/**
	 * This method stores a isr inside the given IVarTreePointer
	 * 
	 * @param vtp
	 *            point to the system
	 * @param id
	 *            contains the hw and rtos id of this data
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	protected void storeAnIsr(IVarTreePointer vtp, ArrayList<Element> ar, OilImplID id) {
		final String[] isrNamePath = { DPKG.getSystem_Architectural().getName(),
				DPKG.getArchitectural_TaskList().getName(), //
				null, // task name ... from oil
				DPKG.getTask_OilVar().getName() };
		final String[] isrTypePath = { DPKG.getSystem_Architectural().getName(),
				DPKG.getArchitectural_TaskList().getName(),
				DPKG.getTask().getName(), DPKG.getTask_OilVar().getName() };

		// the name of a task (also a null value is valid)
		final String isrName = getAttribute(ar.get(0), "Name");

		isrNamePath[2] = isrName;
		IVarTreePointer curr = makePath(vtp, isrNamePath, isrTypePath);

		curr.goParent();
		storeAVar(curr, DPKG.getTask_Type().getName(), "isr");
		curr.go(DPKG.getTask_OilVar().getName());

		// store all instance of this ISR object inside the VarTree
		for (int i = 0; i < ar.size(); i++) {

			storeInsideAOilVar(curr, ar.get(i), id);
		}
		
		{ // move vars outside OilVar
			IVarTreePointer oilVtp =  (IVarTreePointer) curr.clone();
			IVarTreePointer isrVtp = (IVarTreePointer) curr.clone();
			isrVtp.goParent();
			
			final String path;
			{	// prepare path
				StringBuffer tmpPath = new StringBuffer();
				String[] el = makeOilVarPrefix(false, null, IOilXMLLabels.OBJ_ISR, id);
				
				
				for (int i=0; i<el.length; i++) {
					tmpPath.append(el[i]+S);
				}
				
				path = tmpPath.toString()+S+OilApplPackage.eINSTANCE.getRTOS_ParameterList().getName()+S;
			}

			{ // ----------- TYPE = isr ------------
				String[] pNames = {
						DPKG.getTask_ActivationList().getName(), 
						null,
						DPKG.getActivation_Type().getName()
				};
				String[] pTypes = {
						DPKG.getTask_ActivationList().getName(), 
						DPKG.getActivation().getName(),
						DPKG.getActivation_Type().getName()
				};
				
				IVariable var = new StringVar("sporadic");
				
				IVarTreePointer lvtp = makePath(isrVtp, pNames, pTypes);
				lvtp.setVar(var);
			}

			
//			{ // ----------- PRIORITY ------------
//				IVarTreePointer lvtp = extract(oilVtp, path +"PRIORITY"+S+OilApplPackage.eINSTANCE.getValue_Values().getName());
//				if (lvtp!= null) {
//					String[] pNames = {
//							DPKG.getTask_SchedulingList().getName(), 
//							null,
//							DPKG.getScheduling_Priority().getName()
//					};
//					String[] pTypes = {
//							DPKG.getTask_SchedulingList().getName(), 
//							DPKG.getScheduling().getName(),
//							DPKG.getScheduling_Priority().getName()
//					};
//					
//					IVariable var = lvtp.getVar();
//					// remove data
//					lvtp.goParent();
//					lvtp.destroy();
//					
//					lvtp = makePath(taskVtp, pNames, pTypes);
//					lvtp.setVar(var);
//				}
//			}
			
//			{ // ----------- ACTIVATION ------------
//				IVarTreePointer lvtp = extract(oilVtp, path +"ACTIVATION"+S+OilApplPackage.eINSTANCE.getValue_Values().getName());
//				if (lvtp!= null) {
//					String[] pNames = {
//							DPKG.getTask_ActivationList().getName(), 
//							null,
//							DPKG.getActivation_ActNumber().getName()
//					};
//					String[] pTypes = {
//							DPKG.getTask_ActivationList().getName(), 
//							DPKG.getActivation().getName(),
//							DPKG.getActivation_ActNumber().getName()
//					};
//					
//					IVariable var = lvtp.getVar();
//					// remove data
//					lvtp.goParent();
//					lvtp.destroy();
//					
//					lvtp = makePath(taskVtp, pNames, pTypes);
//					lvtp.setVar(var);
//				}
//			}
			
			{ // ----------- RESOURCES ------------
				IVarTreePointer lvtp = extract(oilVtp, path +"RESOURCE"+S+OilApplPackage.eINSTANCE.getValue_Values().getName());
				if (lvtp!= null) {

					IVariable var = lvtp.getVar();
					// remove data
					lvtp.goParent();
					lvtp.destroy();
					
					if (var != null) {
						
						// search all Reource's Names
						String[] values = null;
						
						if (var instanceof IMultiValues) {
							values = ((IMultiValues) var).getValues();
						} else if (var.get() != null){
							values = new String[] { var.toString() };
						}
						
						if (values != null && values.length != 0) {
							
							// path to Isr's ReourcesRef
							String[][] isrResRef = {
									{ // Names
										DPKG.getTask_ResourceRefList().getName(),
										null, // mode
										DPKG.getResourceRef_ResourceMethodRef().getName()
									},
									{  // Types
										DPKG.getTask_ResourceRefList().getName(),
										DPKG.getResourceRef().getName(),
										DPKG.getResourceRef_ResourceMethodRef().getName()
									}
							};
							
							// path to Resource's Method
							String[][] resources = {
									{
										DPKG.getArchitectural_ResourceList().getName(), 
										null, // resource Name
										DPKG.getResource_Methods().getName()
									},
									{
										DPKG.getArchitectural_ResourceList().getName(), 
										DPKG.getResource().getName(),
										DPKG.getResource_Methods().getName()
									}
							};
							
							// path to Resource's MutexRef
							String[][] resMutexRef = {
									{
										DPKG.getResource_MutexRefList().getName(),
										null, // mode
										DPKG.getMutexRef_MutexName().getName()
									},
									{
										DPKG.getResource_MutexRefList().getName(),
										DPKG.getMutexRef().getName(),
										DPKG.getMutexRef_MutexName().getName()
									}
							};

							
							IVarTreePointer archVtp = (IVarTreePointer) isrVtp.clone();
							
							archVtp.goParent(); // -> taskList
							archVtp.goParent(); // -> architectural
							
							
							for (int i=0; i<values.length; i++) {
								// prepare names
								final String mutexName = values[i];
								final String resName = "res_"+mutexName;
								final String methodName = "DefaultMethod";
								
								final String resMethodName = Utility.pathToEvidence(DataPath.makeId(resName)) +
									S + methodName;
								
								// complete Resource's paths
								resources[0][1] = resName;
								
								{ // add a reference to the Resource inside the task
									lvtp = makePath(isrVtp, isrResRef[0], isrResRef[1]);
									updateVar(lvtp, resMethodName);
								}
									
								{ // make the resource
									lvtp = makePath(archVtp, resources[0], resources[1]);
									updateVar(lvtp, methodName);
								}
								
								{ // make the resource's Mutex Ref
									lvtp.goParent();
									lvtp = makePath(lvtp, resMutexRef[0], resMutexRef[1]);
									updateVar(lvtp, mutexName);
								}
								
								
								
								
								
							}
						}
					}
					
//					lvtp = makePath(taskVtp, pNames, pTypes);
//					lvtp.setVar(var);
				}
			}
		}

	}

	
	
	/**
	 * This method stores all task maps inside the given IVarTreePointer
	 * 
	 * @param vtp
	 *            point to the system
	 * @param taskName
	 *            the name of new task
	 * @param rtosName
	 *            the name of RT-OS.
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	protected void storeTaskMap(IVarTreePointer vtp, String taskName, String rtosName) {
		String[] mapNamePath = {
				DPKG.getSystem_Mapping().getName(),
				DPKG.getMapping_TaskMapList().getName(),
				DataPath.makeId(new String[] { null, taskName }), // 
				DPKG.getTaskMap_RtosRef().getName() };
		String[] mapTypePath = { DPKG.getSystem_Mapping().getName(),
				DPKG.getMapping_TaskMapList().getName(),
				DPKG.getTaskMap().getName(),
				DPKG.getTaskMap_RtosRef().getName() };

		IVarTreePointer curr = makePath(vtp, mapNamePath, mapTypePath);
		if (curr.getVar() != null && curr.getVar().get() != null) {
			checkTrue(checkStrings(curr.getVar().toString(), rtosName),
					"Try to Map an already mapped task to a different rtos");
		} else {
			IVariable v = curr.getNewVar(rtosName);
			curr.setVar(v);
		}

	}

	/**
	 * This method stores all isr maps inside the given IVarTreePointer
	 * 
	 * @param vtp
	 *            point to the system
	 * @param taskName
	 *            the name of new task
	 * @param rtosName
	 *            the name of RT-OS.
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	protected void storeIsrMap(IVarTreePointer vtp, String taskName, String rtosName) {
		String[] mapNamePath = {
				DPKG.getSystem_Mapping().getName(),
				DPKG.getMapping_TaskMapList().getName(),
				DataPath.makeId(new String[] { null, taskName }), // 
				DPKG.getTaskMap_RtosRef().getName() };
		String[] mapTypePath = { DPKG.getSystem_Mapping().getName(),
				DPKG.getMapping_TaskMapList().getName(),
				DPKG.getTaskMap().getName(),
				DPKG.getTaskMap_RtosRef().getName() };

		IVarTreePointer curr = makePath(vtp, mapNamePath, mapTypePath);
		if (curr.getVar() != null && curr.getVar().get() != null) {
			checkTrue(checkStrings(curr.getVar().toString(), rtosName),
					"Try to Map an already mapped isr to a different rtos");
		} else {
			IVariable v = curr.getNewVar(rtosName);
			curr.setVar(v);
		}

	}

	/**
	 * This method stores all Resources inside the given IVarTreePointer, as
	 * architectural Mutex
	 * 
	 * @param vtp
	 *            point to the system
	 * @param parent
	 *            the parent node (Oil Application Node)
	 * @param id
	 *            contains the hw and rtos id of this data
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	protected void storeMutex(IVarTreePointer vtp, Element parent, OilImplID id)
			throws OilTransformException {

		String[] mutexNamePath = { DPKG.getSystem_Architectural().getName(),
				DPKG.getArchitectural_MutexList().getName(), null, // mutex name
																   // ... from
																   // oil
				DPKG.getMutex_OilVar().getName() };
		String[] mutexTypePath = { DPKG.getSystem_Architectural().getName(),
				DPKG.getArchitectural_MutexList().getName(),
				DPKG.getMutex().getName(), DPKG.getMutex_OilVar().getName() };

		// prepare where store all data
		Element[] mutexList = getAllSameElements(parent, "Object",
				new String[] { "type" },
				new String[] { IOilXMLLabels.OBJ_RESOURCE });

		// aggregate instances of the same mutex
		ArrayList<Element> unamedMutex = new ArrayList<Element>();
		ArrayList<ArrayList<Element>> namedMutex = new ArrayList<ArrayList<Element>>();
		{
			// namedTasksKeys is used to group together all objects with the
			// same name
			HashMap<String, ArrayList<Element>> namedMutexKeys = new HashMap<String, ArrayList<Element>>();
			for (int i = 0; i < mutexList.length; i++) {
				String tmp = getAttribute(mutexList[i], "Name");

				if (tmp == null) {
					unamedMutex.add(mutexList[i]);
				} else {
					if (namedMutexKeys.containsKey(tmp)) {
						namedMutexKeys.get(tmp).add(mutexList[i]);
					} else {
						ArrayList<Element> ar = new ArrayList<Element>();
						ar.add(mutexList[i]);
						namedMutexKeys.put(tmp, ar);
						namedMutex.add(ar);
					}
				}
			}
		}

		// first the mutex without a name (set id to null)
		// it isn't possible in a oil file !!
		if (unamedMutex.size() > 0) {
			mutexNamePath[2] = null;
			IVarTreePointer curr = makePath(vtp, mutexNamePath, mutexTypePath);

			for (int ut = 0; ut < unamedMutex.size(); ut++) {

				storeInsideAOilVar(curr, unamedMutex.get(ut), id);
			}
		}

		// parse all mutexs. If there're more than one instance for the same
		// mutex, that mutex is parsed more than one time
		for (Iterator<ArrayList<Element>> iter = namedMutex.iterator(); iter.hasNext();) {
			ArrayList<Element> ar = iter.next();

			mutexNamePath[2] = getAttribute(ar.get(0), "Name");
			IVarTreePointer curr = makePath(vtp, mutexNamePath, mutexTypePath);

			// store all instance of this MUTEX object inside the VarTree
			for (int i = 0; i < ar.size(); i++) {

				storeInsideAOilVar(curr, ar.get(i), id);
			}
		}
	}

	/**
	 * This method stores all Events, Alarms and Counters inside the given
	 * IVarTreePointer, as architectural Signals
	 * 
	 * @param vtp
	 *            point to the system
	 * @param parent
	 *            the parent node (Oil Application Node)
	 * @param id
	 *            contains the hw and rtos id of this data
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	protected void storeSignals(IVarTreePointer vtp, Element parent, OilImplID id)
			throws OilTransformException {

		String[] signalNamePath = { DPKG.getSystem_Architectural().getName(),
				DPKG.getArchitectural_SignalList().getName(), null // element
																   // name ...
																   // from oil
		};
		String[] signalTypePath = { DPKG.getSystem_Architectural().getName(),
				DPKG.getArchitectural_SignalList().getName(),
				DPKG.getSignal().getName() };

		String[] types = { IOilXMLLabels.OBJ_ALARM, IOilXMLLabels.OBJ_COUNTER,
				IOilXMLLabels.OBJ_EVENT };

		for (int typeId = 0; typeId < types.length; typeId++) {
			// prepare where store all data
			Element[] elemList = getAllSameElements(parent, "Object",
					new String[] { "type" }, new String[] { types[typeId] });

			// aggregate instances of the same mutex
			ArrayList<Element> unamedElement = new ArrayList<Element>();
			ArrayList<ArrayList<Element>> namedElement = new ArrayList<ArrayList<Element>>();
			{
				// namedElementKeys is used to group together all objects with
				// the same name
				HashMap<String, ArrayList<Element>> namedElementKeys = new HashMap<String, ArrayList<Element>>();
				for (int i = 0; i < elemList.length; i++) {
					String tmp = getAttribute(elemList[i], "Name");

					if (tmp == null) {
						unamedElement.add(elemList[i]);
					} else {
						if (namedElementKeys.containsKey(tmp)) {
							namedElementKeys.get(tmp)
									.add(elemList[i]);
						} else {
							ArrayList<Element> ar = new ArrayList<Element>();
							ar.add(elemList[i]);
							namedElementKeys.put(tmp, ar);
							namedElement.add(ar);
						}
					}
				}
			}

			// first the mutex without a name (set id to null)
			// it isn't possible in a oil file !!
			if (unamedElement.size() > 0) {
				signalNamePath[2] = null;
				IVarTreePointer curr = makePath(vtp, signalNamePath,
						signalTypePath);

				// try to set the type of this element
				storeAVar(curr, DPKG.getSignal_Type().getName(), types[typeId]);

				// add oil data
				curr.go(DPKG.getSignal_OilVar().getName());
				for (int ut = 0; ut < unamedElement.size(); ut++) {

					storeInsideAOilVar(curr, unamedElement.get(ut),
							id);
				}
			}

			// parse all mutexs. If there're more than one instance for the same
			// mutex, that mutex is parsed more than one time
			for (Iterator<ArrayList<Element>> iter = namedElement.iterator(); iter.hasNext();) {
				ArrayList<Element> ar = iter.next();

				signalNamePath[2] = getAttribute(ar.get(0), "Name");
				IVarTreePointer curr = makePath(vtp, signalNamePath,
						signalTypePath);

				// try to set the type of this element
				storeAVar(curr, DPKG.getSignal_Type().getName(), types[typeId]);

				// store all instance of this TASK object inside the VarTree
				curr.go(DPKG.getSignal_OilVar().getName());
				for (int i = 0; i < ar.size(); i++) {

					storeInsideAOilVar(curr, ar.get(i), id);
				}
			}
		}
	}

	/**
	 * This method stores all Appmode inside the given IVarTreePointer, as mode
	 * (not inside an OilVar)
	 * 
	 * @param vtp
	 *            point to the system
	 * @param parent
	 *            the parent node (Oil Application Node)
	 * @param id
	 *            contains the hw and rtos id of this data
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	protected void storeAppmode(IVarTreePointer vtp, Element parent, OilImplID id)
			throws OilTransformException {

		String[] modeNamePath = { DPKG.getSystem_Modes().getName(),
				DPKG.getModes_ModeList().getName(), null, // mode name ... from
														  // oil
		/* DPKG.getMode_OilVar().getName() */};
		String[] modeTypePath = { DPKG.getSystem_Modes().getName(),
				DPKG.getModes_ModeList().getName(), DPKG.getMode().getName(),
		/* DPKG.getMode_OilVar().getName() */};

		// prepare where store all data
		Element[] appmodeList = getAllSameElements(parent, "Object",
				new String[] { "type" },
				new String[] { IOilXMLLabels.OBJ_APPMODE });

		// aggregate instances of the same mutex
		ArrayList<Element> unamedAppmode = new ArrayList<Element>();
		ArrayList<ArrayList<Element>> namedAppmode = new ArrayList<ArrayList<Element>>();
		{
			// namedAppmodeKeys is used to group together all objects with the
			// same name
			HashMap<String, ArrayList<Element>> namedAppmodeKeys = new HashMap<String, ArrayList<Element>>();
			for (int i = 0; i < appmodeList.length; i++) {
				String tmp = getAttribute(appmodeList[i], "Name");

				if (tmp == null) {
					unamedAppmode.add(appmodeList[i]);
				} else {
					if (namedAppmodeKeys.containsKey(tmp)) {
						namedAppmodeKeys.get(tmp)
								.add(appmodeList[i]);
					} else {
						ArrayList<Element> ar = new ArrayList<Element>();
						ar.add(appmodeList[i]);
						namedAppmodeKeys.put(tmp, ar);
						namedAppmode.add(ar);
					}
				}
			}
		}

		// first the mutex without a name (set id to null)
		// it isn't possible in a oil file !!
		if (unamedAppmode.size() > 0) {
			modeNamePath[2] = null;
			/* IVarTreePointer curr = */makePath(vtp, modeNamePath, modeTypePath);
			/*
			 * for (int ut=0; ut <unamedAppmode.size(); ut++) {
			 * 
			 * storeInsideAOilVar(curr, (Element) unamedAppmode.get(ut), id); }
			 */
		}

		// parse all mutexs. If there're more than one instance for the same
		// mutex, that mutex is parsed more than one time
		for (Iterator<ArrayList<Element>> iter = namedAppmode.iterator(); iter.hasNext();) {
			ArrayList<Element> ar = iter.next();

			modeNamePath[2] = getAttribute(ar.get(0), "Name");
			/* IVarTreePointer curr = */makePath(vtp, modeNamePath, modeTypePath);

			/*
			 * // store all instance of this APPMODE object inside the VarTree
			 * for (int i=0; i <ar.size(); i++) {
			 * 
			 * storeInsideAOilVar(curr, (Element) ar.get(i), id); }
			 */
		}
	}


	/**
	 * This method stores all Appmode inside the given IVarTreePointer, as mode
	 * (not inside an OilVar)
	 * 
	 * @param vtp
	 *            point to the system
	 * @param parent
	 *            the parent node (Oil Application Node)
	 * @param id
	 *            contains the hw and rtos id of this data
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	protected void storeNetworkMessages(IVarTreePointer vtp, Element parent, OilImplID id)
			throws OilTransformException {

		String[] frameNamePath = { DPKG.getSystem_Architectural().getName(),
				DPKG.getArchitectural_FrameList().getName(), null, // mode name ... from
														  // oil
		/* DPKG.getMode_OilVar().getName() */};
		String[] frameTypePath = { DPKG.getSystem_Architectural().getName(),
				DPKG.getArchitectural_FrameList().getName(), DPKG.getFrame().getName(),
		/* DPKG.getMode_OilVar().getName() */};

		// prepare where store all data
		Element[] appmodeList = getAllSameElements(parent, "Object",
				new String[] { "type" },
				new String[] { IOilXMLLabels.OBJ_NETWORKMESSAGE });

		// aggregate instances of the same mutex
		ArrayList<Element> unamedAppmode = new ArrayList<Element>();
		ArrayList<ArrayList<Element>> namedAppmode = new ArrayList<ArrayList<Element>>();
		{
			// namedAppmodeKeys is used to group together all objects with the
			// same name
			HashMap<String, ArrayList<Element>> namedAppmodeKeys = new HashMap<String, ArrayList<Element>>();
			for (int i = 0; i < appmodeList.length; i++) {
				String tmp = getAttribute(appmodeList[i], "Name");

				if (tmp == null) {
					unamedAppmode.add(appmodeList[i]);
				} else {
					if (namedAppmodeKeys.containsKey(tmp)) {
						namedAppmodeKeys.get(tmp)
								.add(appmodeList[i]);
					} else {
						ArrayList<Element> ar = new ArrayList<Element>();
						ar.add(appmodeList[i]);
						namedAppmodeKeys.put(tmp, ar);
						namedAppmode.add(ar);
					}
				}
			}
		}

		// first the mutex without a name (set id to null)
		// it isn't possible in a oil file !!
//		if (unamedAppmode.size() > 0) {
//			frameNamePath[2] = null;
//			IVarTreePointer curr = makePath(vtp, frameNamePath, frameTypePath);
//			/*
//			 * for (int ut=0; ut <unamedAppmode.size(); ut++) {
//			 * 
//			 * storeInsideAOilVar(curr, (Element) unamedAppmode.get(ut), id); }
//			 */
//		}

		// parse all mutexs. If there're more than one instance for the same
		// mutex, that mutex is parsed more than one time
		for (Iterator<ArrayList<Element>> iter = namedAppmode.iterator(); iter.hasNext();) {
			ArrayList<Element> ar = iter.next();

			frameNamePath[2] = getAttribute(ar.get(0), "Name");
			IVarTreePointer curr = makePath(vtp, frameNamePath, frameTypePath);
			String s = null;
			size_search: 
			for (int i=0; i <ar.size(); i++) {
				for (Element msg_prop : getAllSameElements(ar.get(i), "parameter",
						new String[] { "Name" },
						new String[] { "MESSAGEPROPERTY" })) {
					
					for (Element msg_prop_static : getAllSameElements(msg_prop, "enumerator",
							new String[] { "Name" },
							new String[] { "STATIC" })) {
						
						for (Element msg_prop_static_size : getAllSameElements(msg_prop_static, "parameter",
								new String[] { "Name" },
								new String[] { "SIZEINBITS" })) {
							
							s = getAttribute(msg_prop_static_size, "CurrValue");
							if (s != null) {
								break size_search;
							}
						}

					}
					
				}
			}
			if (s != null) {
				storeAVar(curr, DPKG.getFrame_Length().getName(), s);
			}
			
			
//			for (int i=0; i <ar.size(); i++) {
//				storeInsideAOilVar(curr, (Element) ar.get(i), id);
//			}
			
		}
	}

	/**
	 * Store all data of an rtos inside the OilVar of element
	 * "/SystemName/Architecture/EcuList/OilEcu/CpuList/rtosName/Rtos", where
	 * the <b>SystemName </b> and <b>rtosName </b> are the values stored inside
	 * the <b>Application Name </b> and <b>OS Name </b>. Returns the name of
	 * RT-OS.
	 * 
	 * @param vtp
	 *            point to the system
	 * @param parent
	 *            the parent node
	 * @param rtosName
	 *            the name of RT-OS
	 * 
	 * @param id
	 *            contains the hw and rtos id of this data
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	protected void storeOthers(IVarTreePointer vtp, Element parent,
			String rtosName, OilImplID id) throws OilTransformException {
		if (rtosNamePath == null) {
			throw new Error("First call storeOs than storeOthers");
		}

		for (int typeId = 0; typeId < otherObjectsTypes.length; typeId++) {
			// prepare where store all data
			Element[] objList = getAllSameElements(parent, "Object",
					new String[] { "type" },
					new String[] { otherObjectsTypes[typeId] });
			if (objList.length > 0) {

				// set the HW model
				IVarTreePointer curr = makePath(vtp, new String[] {
						rtosNamePath[0], rtosNamePath[1], rtosNamePath[2],
						rtosNamePath[3], rtosNamePath[4] }, new String[] {
						rtosTypePath[0], rtosTypePath[1], rtosTypePath[2],
						rtosTypePath[3], rtosTypePath[4] });
				storeAVar(curr, DPKG.getCpu_Model().getName(), id.getHW());

				curr = makePath(curr, new String[] { rtosNamePath[5] },
						new String[] { rtosTypePath[5] });
				storeAVar(curr, DPKG.getRtos_Name().getName(), rtosName);

				curr = makePath(curr, new String[] { rtosNamePath[6] },
						new String[] { rtosTypePath[6] });

				// store all instance of OS object from Oil tree
				for (int i = 0; i < objList.length; i++) {

					String name = getAttribute(objList[i], "Name");

					IVariable var = curr.getVar();
					if (var == null) {
						var = curr.getNewVar(null);
						if (var == null) { /*DEBUG*/			throw new Error("Try to get a not null var");		}
					}
					//checkTrue(var instanceof OilVar, "Required an OilVar");

					curr.setVar(storeInsideAOilVar(/*(OilVar)*/ var, parent, id,
							name, true));

				} // end for(osList[0] ... osList[n])
			}
		}
	}

	/*
	 * 
	 * UTILITIES
	 *  
	 */

	/**
	 * Stores an Oil tree (XML) inside an OilVar; If the given OilVar contains
	 * an old tree, merge the new tree and the old one.
	 * 
	 * @param old
	 *            the old Oil Tree
	 * @param parent
	 *            the new Oil Tree
	 * @param id
	 *            identifies the Oil Implementation
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	protected void storeInsideAOilVar(IVarTreePointer vtp, Element parent,
			OilImplID id) throws OilTransformException {
		IVariable var = vtp.getVar();
		if (var == null) {
			var = vtp.getNewVar(null);
			if (var == null) { /*DEBUG*/			throw new Error("Try to get a not null var");		}
		}
		//checkTrue(var instanceof OilVar, "Required an OilVar");

		vtp.setVar(storeInsideAOilVar(/*(OilVar)*/ var, parent, id, null, false));

	}

	/**
	 * Stores an Oil tree (XML) inside an OilVar; If the given OilVar contains
	 * an old tree, merge the new tree and the old one.
	 * 
	 * @param old
	 *            the old Oil Tree
	 * @param parent
	 *            the new Oil Tree
	 * @param id
	 *            identifies the Oil Implementation
	 * 
	 * @return a new Oil Var that contains all oil data.
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	protected IVariable storeInsideAOilVar(IVariable old, Element parent,
			OilImplID id, String name, boolean addName)
			throws OilTransformException {
		IVariable answer = (IVariable) old.clone();

		if (answer instanceof OilVarMP) {
			ISubVarTreePointer svtp = ((OilVarMP) answer).getPointer(vt);

			String objType = getAttribute(parent, IOilXMLLabels.ATTR_TYPE);

			svtp = makePath(svtp, makeOilVarPrefix(addName, name, objType, id),
					new String[] { OAPKG.getRoot().getName(),
							OAPKG.getRoot_HwList().getName(),
							OAPKG.getHW().getName(),
							OAPKG.getHW_RtosList().getName(),
							OAPKG.getRTOS().getName() });

			ArrayList<String> typePath = new ArrayList<String>();

			typePath.add(objType);
			NodeList children = parent.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				Node node = children.item(i);
				if (node instanceof Element) {
					storeInsideAOilVar(svtp, (Element) node, typePath);
				}
			}
		} else {
			String text = "";
			if (old.get() != null) {
				text += old;
			}
			text += parent;
			answer.set(text);
		}
		return answer;
	}

	/**
	 * Recursively stores an sub Oil tree (XML) inside the current
	 * subVarTreePointer.
	 * 
	 * @param svtp
	 *            where add the new data
	 * @param current
	 *            the new data
	 * @param typePath
	 *            identifies the type of parent node, inside the Oil
	 *            Implementation tree. typePath[0] is the FIRST_LEVEL_OBJECT
	 *            tpye and typePath[size-1] is the type of parent node.
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	protected void storeInsideAOilVar(ISubVarTreePointer svtp, Element current,
			ArrayList<String> typePath) throws OilTransformException {
		svtp = (ISubVarTreePointer) svtp.clone();

		//        System.out.println(current);
		String elemType = current.getNodeName();
		typePath.add(0, getAttribute(current, IOilXMLLabels.ATTR_NAME));

		/***********************************************************************
		 * Store a parameter
		 **********************************************************************/
		if (IOilXMLLabels.ELEM_PARAMETER.equals(elemType)) {
			{
				Stack<String> st = new Stack<String>();
				String svtpType = svtp.getType();
				if (OAPKG.getRTOS().getName().equals(svtpType)) {
					st.push(OAPKG.getRTOS_ParameterList().getName());
				} else { // default
					//if (OAPKG.getEnumerator().getName().equals(svtpType)) {
					st.push(OAPKG.getEnumerator_ParameterList().getName());
					//} else {
					//    checkTrue(false, "Unexpected node type: " + svtpType);
				}
				svtp.makeSteps(st);
			}

			IOilImplPointer oip = oilImpl.getPointer();
			boolean ok = true;
			for (int i = typePath.size() - 1; ok && i >= 0; i--) {
				ok = oip.goChild(typePath.get(i));
			}
			checkTrue(ok, "A not defined element " + typePathToString(typePath));

			IOilImplElementDescr curr = oip.getCurrentDescr();
			switch (curr.getType()) {
			case IOilImplPointer.REFERENCE:
			// the same of ATTRIBUTE
			// break;
			case IOilImplPointer.ATTRIBUTE: {
				String value = null;
				String type;
				if (curr.getType() == IOilImplPointer.ATTRIBUTE) {
					value = getAttribute(current, IOilXMLLabels.ATTR_CURR_VALUE);
					type = curr.getAttributes().getProperty(IOilXMLLabels.ATTR_TYPE);
				} else {
					value = getAttribute(current, IOilXMLLabels.ATTR_CURR_VALUE);
					if (value == null) {
						NodeList children = current.getChildNodes();
						for (int i = 0; i < children.getLength(); i++) {
							Node node = children.item(i);
							if (node instanceof Element
									&& IOilXMLLabels.ELEM_ENUM_VALUE.equals(node
											.getNodeName())) {
								value = getAttribute((Element) node,
										IOilXMLLabels.ATTR_NAME);
								break;
							}
						}
					}

					type = curr.getAttributes()
							.getProperty(IOilXMLLabels.ATTR_OBJ_REF_TYPE);
				}
				//boolean auto = "true".equalsIgnoreCase(getAttribute(current,
				// OilXMLLabels.ATTR_AUTO));
				boolean defaultValuesUsed = false;
				{
					Stack<String> stackPath = new Stack<String>();
					stackPath.push(OAPKG.getValue_Values().getName());
					stackPath
							.push(getAttribute(current, IOilXMLLabels.ATTR_NAME));

					defaultValuesUsed = ((ISubVarTreePointer) svtp.clone())
							.makeSteps(stackPath) == ISubVarTreePointer.ERROR;
				}
				svtp = makePath(svtp, new String[] {
						getAttribute(current, IOilXMLLabels.ATTR_NAME),
						OAPKG.getValue_Values().getName() }, new String[] {
						type, OAPKG.getValue_Values().getName() });

				IVariable var = svtp.getVar();
				if (!defaultValuesUsed && var != null && var.get() != null) {
					if (var instanceof IMultiValues) {
						if (value != null) {
							((IMultiValues) var).appendValue(value);
							svtp.setVar(var);
						}
					} else {
						checkTrue(checkStrings(var.toString(), value),
								"Try to overwrite an already existent variable with a different value."
								+"\n\tElement   = "+ getAttribute(current, IOilXMLLabels.ATTR_NAME)
								+"\n\tOld value = "+var.toString() 
								+"\n\tNew value = "+value);

					}
				} else {
					var = svtp.getNewVar(value);
					svtp.setVar(var);
				}
			}
				break;
			case IOilImplPointer.VARIANT: {
				String name = getAttribute(current,IOilXMLLabels.ATTR_NAME);
				svtp = makePath(svtp, new String[] { name }, new String[] { name });

				final boolean multiValues = "true".equalsIgnoreCase(curr.getAttributes().getProperty(IOilXMLLabels.ATTR_MULTIPLE_VALUES, "false"));
				
				{ // Multi Values
					ISubVarTreePointer tsvtp = (ISubVarTreePointer) svtp.clone();
					Stack<String> st = new Stack<String>();
					st.push(OAPKG.getParameter_MultiValues().getName());
					if (tsvtp.makeSteps(st) != ISubVarTreePointer.OK) {
						throw new RuntimeException("Unnaspected error");
					}
					
					IVariable var = tsvtp.getVar();
					//if (true || var == null) {
						// always set the value
						var = tsvtp.getNewVar("" + multiValues);
						tsvtp.setVar(var);
					//} else { }
				}

								
				IOilImplElementDescr[] currChildren = oip.getChildrenDescr();
				String validValues = currChildren.length >1 ? "one of ": "";
				for (int cc=0; cc<currChildren.length; cc++) {
					validValues += (cc>0 ? ", " : "") + currChildren[cc].getName();
				}
				
				// cicle all children
				NodeList children = current.getChildNodes();
				for (int i = 0; i < children.getLength(); i++) {
					Node node = children.item(i);
					if (node instanceof Element) {
						String childName = getAttribute((Element) node,IOilXMLLabels.ATTR_NAME);
						
						// check if is a valid children
						boolean found = false; 
						for (int cc=0; cc<currChildren.length && !found; cc++) {
							found = currChildren[cc].getName().equals( childName );
						}
						
						checkTrue(found, childName + " is an illegal value for " + name + "."
								+ " Expected "+ validValues + ".");
						
						storeInsideAOilVar(svtp, (Element) node, typePath);
					}
				}
				
				if (!multiValues) {
					
					ISubVarTreePointer tsvtp = (ISubVarTreePointer) svtp.clone();
					Stack<String> st = new Stack<String>();
					st.push(OAPKG.getVariant_EnumeratorList().getName());
					if (tsvtp.makeSteps(st) != ISubVarTreePointer.OK) {
						throw new RuntimeException("Unnaspected error");
					}
					if (tsvtp.getChildrenNumber() >1) {
						throw new RuntimeException(svtp.getName() 
								+ " contains more than one value (expected only " + validValues + ")");
					}
				}

				if (children.getLength() == 0) {
					String value = getAttribute(current, IOilXMLLabels.ATTR_CURR_VALUE);
					
					checkTrue(value!=null, value + " is an illegal value for " + name + "."
							+ " Expected "+ validValues + ", not strings or numbers.");
					// else
					checkTrue(value==null, "Illegal value for " + name + "."
							+ " Expected "+ validValues + ".");
				}

				

			}
				break;
			default:
				// throw an exception
				checkTrue(false, "Illegal Implementation Type: " + curr.getType());
				break;
			}

		}
		/***********************************************************************
		 * Store an Enumerator
		 **********************************************************************/
		else if (IOilXMLLabels.ELEM_ENUM_VALUE.equals(elemType)) {
			svtp = makePath(svtp, new String[] {
					OAPKG.getVariant_EnumeratorList().getName(),
					getAttribute(current, IOilXMLLabels.ATTR_NAME) },
					new String[] { OAPKG.getVariant_EnumeratorList().getName(),
							OAPKG.getEnumerator().getName() });

			// cicle all children
			NodeList children = current.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				Node node = children.item(i);
				if (node instanceof Element) {
					storeInsideAOilVar(svtp, (Element) node, typePath);
				}
			}
		}
		/***********************************************************************
		 * Store a Description
		 **********************************************************************/
		else if (IOilXMLLabels.ELEM_DESCRIPTION.equals(elemType)) {
			// TODO : finire
//			checkTrue(false, "Finire la gestione delle descrizioni");

		}
		typePath.remove(0);
	}

	/**
	 * Checks if given node contains the var <code>varName</code> and, if
	 * true, checks if the var's value is the given one. If the node doesn't
	 * contains the var or if the value is null, this method creates a new var
	 * with the given value and adds it to <code>parent</code> node.
	 * 
	 * @param parent
	 *            the node that contains the node with the required var
	 * @param varName
	 *            identifies the variable
	 * @param value
	 *            the required value
	 * 
	 * @throws OilTransformException
	 *             if the <code>parent</code> node already contains the
	 *             variable but with another not null value.
	 */
	protected void storeAVar(IVarTreePointer parent, String varName, String value)
			throws OilTransformException {

		IVarTreePointer curr = (IVarTreePointer) parent.clone();
		if (!curr.go(varName)) {
			curr.add(varName, new StringVar(value));
		} else {
			IVariable var = curr.getVar();
			if (var != null && var.get() != null) {
				if (var instanceof IMultiValues) {
					if (value != null) {
						((IMultiValues) var).appendValue(value);
					}
				} else {
					checkTrue(checkStrings(var.toString(), value),
							"Try to overwrite an already existent variable with a different value.");
				}
			} else {
				IVariable tmpVar = curr.getNewVar(value);
				curr.setVar(tmpVar);
			}
		}
	}

	/**
	 * Search all siblings with the same id: Element.Name and a list of
	 * (attribute name, attribute value).
	 * If type is null, it checks all elements.
	 * 
	 * @param parent
	 *            the parent node
	 * @param type
	 *            the element name. If null, means all elements.
	 * @param attrType
	 *            all attribute to check. Cannot be null.
	 * @param attrValue
	 *            the value of each attribute. Cannot be null.
	 */
	protected Element[] getAllSameElements(Element parent, String type,
			String[] attrType, String[] attrValue) {
		// if parent, attrType or attrValue is null it will throw an
		// NullPointerException; If the code is correct, it will never throw
		// that exception.
		// Otherwise I need to add a check for array's lengths
		Assert.isLegal(attrType.length == attrValue.length);

		ArrayList<Node> answer = new ArrayList<Node>();
		NodeList allChildren = parent.getChildNodes();
		for (int i = 0; i < allChildren.getLength(); i++) {

			// is an Element of the right type
			Node ch = allChildren.item(i);
			if (ch instanceof Element
					&& (type == null ? true : type.equalsIgnoreCase(ch.getNodeName()))) {

				NamedNodeMap attrs = ch.getAttributes();
				boolean ok = true;
				// check all attributes
				for (int a = 0; ok && a < attrType.length; a++) {

					boolean search = true;
					// search
					for (int a2 = 0; search && a2 < attrs.getLength(); a2++) {
						if (attrType[a].equalsIgnoreCase(attrs.item(a2)
								.getNodeName())) {
							ok = attrValue[a].equals(attrs.item(a2)
									.getNodeValue());
							search = false;
						}
					}

					// ok is true if
					// 1. search == false : the attribute was found
					// and
					// 2. ok == true : the attribute has the rigth value
					ok &= !search;

				}

				// store this element (one time)
				if (ok) {
					if (!answer.contains(ch)) {
						answer.add(ch);
					}
				}
			}
		}

		// return the answer
		return answer.toArray(new Element[0]);
	}

	/**
	 * This method ensure that a path exist; infact if one or more elements
	 * doesn't exist, it creates them; Throws an OilTransformException if there
	 * are some problems. <br>
	 * Returns a different IVarTreePointer that points to the new node, at the
	 * end of given path.
	 * 
	 * @param vtp
	 *            where store the path
	 * @param names
	 *            names of each step (without slashes)
	 * @param types
	 *            the type of each step
	 * 
	 * @throws OilTransformException
	 *             if the system doesn't already exist and this method cannot
	 *             add a new System
	 */
	protected IVarTreePointer makePath(IVarTreePointer vtp, String[] names,
			String[] types) throws OilTransformException {
		// if vtp, names or types is null it will throw an NullPointerException;
		// If the code is correct, it will never throw that exception.
		// Otherwise I need to add a check for array's lengths
		Assert.isLegal(names.length == types.length);

		//System.out.println("Path");
		//for (int i=0; i< names.length; i++) {
		//	System.out.println("\t" +names[i] + "-" + types[i]);
		//}
		// use a copy !
		vtp = (IVarTreePointer) vtp.clone();

		for (int i = 0; i < names.length; i++) {
			// try to go into the required node
			if (!vtp.go(DataPath.addSlash(names[i]))) {

				// try to add it
				try {
					vtp.add(names[i], types[i]);
				} catch (RuntimeException e) {
					throw new OilTransformException("(" + vtp.getName() + " - "
							+ vtp.getType() + ") " + e.getMessage(), e);
				}
				// try again to go in the new node
				checkTrue(vtp.go(DataPath.addSlash(names[i])),
						"Error when try to add a node :\n\t" + "name = "
								+ names[i] + " ,type = " + types[i]);
			}
		}
		return vtp;
	}

	/**
	 * This method ensure that a path exist; infact if one or more elements
	 * doesn't exist, it creates them; Throws an OilTransformException if there
	 * are some problems. <br>
	 * Returns a different ISubVarTreePointer that points to the new node, at the
	 * end of given path.
	 * 
	 * @param vtp
	 *            where store the path
	 * @param names
	 *            names of each step (without slashes)
	 * @param types
	 *            the type of each step
	 * 
	 * @throws OilTransformException
	 *             if the system doesn't already exist and this method cannot
	 *             add a new System
	 */
	protected ISubVarTreePointer makePath(ISubVarTreePointer svtp,
			String[] names, String[] types) throws OilTransformException {
		// if svtp, names or types is null it will throw an
		// NullPointerException;
		// If the code is correct, it will never throw that exception.
		// Otherwise I need to add a check for array's lengths
		Assert.isLegal(names.length == types.length);

		/*
		 * System.err.println("Nomi = "); for (int i=0; i <names.length; i++)
		 * System.err.println("\t"+ names[i]); System.err.println("Tipi = ");
		 * for (int i=0; i <types.length; i++) System.err.println("\t = " +
		 * types[i]);
		 */
		// use a copy !
		svtp = (ISubVarTreePointer) svtp.clone();
		Stack<String> path = new Stack<String>();

		for (int i = 0; i < names.length; i++) {
			// try to go into the required node
			path.push(DataPath.addSlash(names[i]));
			switch (svtp.makeSteps(path)) {

			case ISubVarTreePointer.OK:
				// next step
				break;
			case ISubVarTreePointer.ERROR:
			// try to add a new child
			{
				String newName;
				try {
					newName = svtp.add(names[i], types[i]);
				} catch (RuntimeException e) {
					throw new OilTransformException(e.getMessage(), e);
				}

				// TODO: controllare se necessita di protezioni aggiuntive
				path.push(newName);

				checkTrue(svtp.makeSteps(path) == ISubVarTreePointer.OK,
						"Error when try to add a node :\n\t" + "name = "
								+ names[i] + "\n\ttype = " + types[i]);
				break;
			}
			case ISubVarTreePointer.BACK_TO_PARENT: { // not valid value !!!
				checkTrue(false, "Not valid child name:\n\t" + "name = "
						+ names[i] + " ,type = " + types[i]);
				break;
			}
			}
		}
		return svtp;
	}

	/**
	 * Searchs an attribute, ingoring case
	 */
	protected String getAttribute(Element elem, String attrName) {

		NamedNodeMap attrs = elem.getAttributes();

		// search
		for (int i = 0; i < attrs.getLength(); i++) {
			if (attrName.equalsIgnoreCase(attrs.item(i).getNodeName())) {
				return attrs.item(i).getNodeValue();
			}
		}
		return null;
	}

	/**
	 * Check if two strings are equals (or also if they are togheter null).
	 * 
	 * @param a
	 *            the first string
	 * @param b
	 *            the second string
	 * 
	 * @return true if <code>a == null and b == null</code> or if
	 *         <code>a != null and a.equals(b)</code>
	 */
	protected boolean checkStrings(String a, String b) {
		return a == null ? b == null : a.equals(b);
	}

	/**
	 * If the condition is false, throws a new OilTransform exception
	 * 
	 * @param value
	 *            the condition
	 * @param msg
	 *            the message for the OilTransformException
	 * @throws OilTransformException
	 *             if value is false
	 */
	protected void checkTrue(boolean value, String msg)
			throws OilTransformException {
		if (!value) {
			throw new OilTransformException(msg);
		}
	}

	/**
	 * This method searchs a specific element inside a tree.
	 * 
	 * @param vtp
	 *            the root of sub-tree
	 * @param path
	 *            identifies a node inside the tree
	 * 
	 * @return the element or null if it wasn't found
	 */
	protected IVarTreePointer extract(IVarTreePointer vtp, String path) {
		vtp = (IVarTreePointer) vtp.clone();
		if (vtp.go(path)) {
			return vtp;
		}
		return null;
	}

	/***************************************************************************
	 * 
	 * OIL WRITER
	 *  
	 **************************************************************************/

	/**
	 * Take all data from the given VarTree and write the rigth Oil File. It
	 * requireds also the id of HW and RT-OS.
	 * 
	 * @param vt
	 *            where store all data
	 * @param id
	 *            HW and RT-OS ids for data
	 * @param rtosPath
	 *            identifies the rtos needed to write the oil file
	 * 
	 * @return a string with Oil syntax
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	public String write(IVarTree vt, OilImplID id, String rtosPath)
			throws OilTransformException {

		// init
		this.vt = vt;

		if (rtosPath == null) {
			throw new NullPointerException("required a not null path");
		}
		if (!vt.newTreeInterface().exist(rtosPath,
				DataPackage.eINSTANCE.getRtos().getName())) {
			throw new IllegalArgumentException(
					"The specified rtos path isn't valid.\n\t" + "path = "
							+ rtosPath);
		}

		StringBuffer buffer = new StringBuffer();
		if (writeImplementation) {
			buffer.append("OIL_VERSION = \"2.4\";\n\n");
	
			// write
			writeImplementation(buffer, id);
		}

		writeApplication(buffer, id, rtosPath);
		return buffer.toString();
	}
	
	/**
	 * Take all data from the given VarTree and write the rigth Oil File. It
	 * requireds also the id of HW and RT-OS.
	 * 
	 * @param vt
	 *            where store all data
	 * @param id
	 *            HW and RT-OS ids for data
	 * @param rtosPaths
	 *            identifies all rtos needed to write the oil file
	 * 
	 * @return a string with Oil syntax
	 * 
	 * @throws OilTransformException
	 *             if there are some problems
	 */
	public String write(IVarTree vt, OilImplID id, String[] rtosPaths)
			throws OilTransformException {
		throw new UnsupportedOperationException(
				"Default Oil Transformer doesn't support export from more than one rtos");
	}

	/**
	 * Returns true if is required to write the implementation section in the
	 * output Oil File
	 * 
	 * @return Returns the writeImplementation.
	 */
	public boolean isWriteImplementation() {
		return writeImplementation;
	}
	
	/**
	 * Set if is required to write the implementation section in the output Oil
	 * File
	 * 
	 * @param writeImplementation
	 *            The writeImplementation to set.
	 */
	public void setWriteImplementation(boolean writeImplementation) {
		this.writeImplementation = writeImplementation;
	}
	

	/**
	 * Write the implementation section
	 * 
	 * @param buffer
	 *            the output (Oil)
	 * 
	 * @param id
	 *            identifies the Implementation
	 */
	protected void writeImplementation(StringBuffer buffer, OilImplID id) {
		IOilImplementation impl = OilImplFactory_Impl.getAnInstance(vt).getImpl(id);

		buffer.append(impl.toOil());
	}

	/**
	 * Write the application section
	 * 
	 * @param buffer
	 *            the output (Oil)
	 * @param id
	 *            identifies the Application
	 * @param rtosPath
	 *            identifies the current rtos
	 */
	protected void writeApplication(StringBuffer buffer, OilImplID id,
			String rtosPath) {

		String[] splittedPath = DataPath.splitPath(rtosPath);

		String cpuName = splittedPath[5];
		String oilVarPrefix = S
				+ OilApplPackage.eINSTANCE.getRoot_HwList().getName() + S
				+ DataPath.makeSlashedId(id.getHW()) + S
				+ OilApplPackage.eINSTANCE.getHW_RtosList().getName() + S
				+ DataPath.makeSlashedId(id.getRtos()) + S
				+ OilApplPackage.eINSTANCE.getRTOS_ParameterList().getName()
				+ S;

		//header
		buffer.append("CPU " + cpuName + " {\n");

		IOilObjectList ool = extractApplicationObjects(new String[] {rtosPath});

		int order[] = { IOilObjectList.OS, IOilObjectList.OSAPPLICATION, IOilObjectList.TASK,
				IOilObjectList.COUNTER, IOilObjectList.ALARM,
				IOilObjectList.RESOURCE, IOilObjectList.EVENT, IOilObjectList.ISR,
				IOilObjectList.MESSAGE, IOilObjectList.NETWORKMESSAGE,
				IOilObjectList.COM, IOilObjectList.NM, IOilObjectList.APPMODE,
				IOilObjectList.IPDU };

		for (int oolId = 0; oolId < order.length; oolId++) {

			List olist = ool.getList(order[oolId]);
			for (Iterator iter = olist.iterator(); iter.hasNext();) {
				writeApplicationObject(buffer, oilVarPrefix,
						(ISimpleGenRes) iter.next(), order[oolId], rtosPath);
			}

		}

		//end
		buffer.append("};\n\n");

	}

	/**
	 * Extract from current VarTree all Application Objects (OS, TASKS,
	 * RESOURCES, ...)
	 */
	protected IOilObjectList extractApplicationObjects(String[] rtos) {

		IOilObjectList answer = new OilObjectList();

		String sysName = DataPath.splitPath(rtos[0])[0];

		for (int objID = 0; objID < IOilObjectList.OBJECT_NUMBER; objID++) {

			SimpleGenRes[] objects = new SimpleGenRes[0];
			switch (objID) {
			case IOilObjectList.OS: {

				objects = new SimpleGenRes[rtos.length];
				for (int i=0; i<rtos.length; i++) {
					String name = ""
							+ vt.newTreeInterface().getValue(
									rtos[i] + S + DPKG.getRtos_Name().getName());
					objects[i] = new SimpleGenRes(name, rtos[i]);
					objects[i].setProperty(IOilXMLLabels.ATTR_TYPE,
							IOilXMLLabels.OBJ_OS);
					
					objects[i].setProperty(ISimpleGenResKeywords.RTOS_PATH,
							rtos[i]);
				}
			}
				break;
			case IOilObjectList.OSAPPLICATION: {

				ArrayList<SimpleGenRes> tempList = new ArrayList<SimpleGenRes>();
				
				
				for (String rtosPath : rtos) {
					
					String[] split = DataPath.splitPath(rtosPath);
					if (split == null || split.length <7) {
						continue;
					}
					
					String path = DataPath.makePath(new String[] {
							split[0], // sys 
							split[1], // arch
							split[2], // arch_eculist
							split[3], // ecu
							split[4], // cpu_list
							split[5], // cpu
							DPKG.getCpu_OsApplication().getName()
					});
					
					String[] applNames = vt.newTreeInterface().getAllName(path, DPKG.getOsApplication().getName());
					
					for (String name: applNames) {
						SimpleGenRes s = new SimpleGenRes(name, path+S+ name);
						s.setProperty(IOilXMLLabels.ATTR_TYPE,
								IOilXMLLabels.OBJ_OSAPPLICATION);
						s.setProperty(ISimpleGenResKeywords.RTOS_PATH,
								rtosPath);
						tempList.add(s);
					}
				}
					
				objects = tempList.toArray(new SimpleGenRes[tempList.size()]);
			}
				break;
			case IOilObjectList.TASK: {
				

				/*******************************************************************
				 * Search tasks
				 ******************************************************************/
				
				// use class TaskSet to search all tasks mapped to current rtos
				TaskSet ts = new TaskSet(vt, sysName);
				ts.setProperty(Task.STR_TASK_TYPE, "", false);
				ts.setProperty(Task.STR_PRIORITY, "", false);
				ts.setProperty(Task.STR_ACT_NUMBER, "", false);
				ts.setProperty(Task.STR_RESOURCE_LIST, "", false);

				ArrayList<ISimpleGenRes> objList = new ArrayList<ISimpleGenRes>();
	
				for (int i = 0; i < ts.getPrefixNumber(); i++) {
					for (int ri=0; ri<rtos.length; ri++) {
						String rtosName = ""
							+ vt.newTreeInterface().getValue(
									rtos[ri] + S + DPKG.getRtos_Name().getName());
						
						if (rtosName != null && rtosName.equals(ts.getPrefix(i))) {
	
//							objects = new SimpleGenRes[ts.getSize(i)];
							for (int h = 0; h < ts.getSize(i); h++) {
								GenRes current = ts.getItem(i, h);
								if (!"task".equalsIgnoreCase(current.getString(Task.STR_TASK_TYPE))) {
									continue; // this element is not a task
								}

								ISimpleGenRes object = new SimpleGenRes(
										current.getName(), current.getPath());
								objList.add(object);
								
								object.setProperty(IOilXMLLabels.ATTR_TYPE,
										IOilXMLLabels.OBJ_TASK);
	
								// take also ....
								
								// ----------- PRIORITY ------------
								if (current.existProperty(Task.STR_PRIORITY)) {
									Object ttt = current.getProperty(Task.STR_PRIORITY);
									if (ttt!=null && (ttt.toString()).length()>0) {
										object.setProperty(ISimpleGenResKeywords.TASK_PRIORITY, "" + ttt);
									}
								}
								// ----------- ACTIVATION ------------
								if (current.existProperty(Task.STR_ACT_NUMBER)) {
									Object ttt = current.getProperty(Task.STR_ACT_NUMBER);
									if (ttt!=null && (ttt.toString()).length()>0) {
										object.setProperty(ISimpleGenResKeywords.TASK_ACTIVATION, "" + ttt);
									}
								}
								// ----------- RESOURCE ------------
								if (current.existProperty(Task.STR_RESOURCE_LIST)) {
									Object ttt = current.getCollection(Task.STR_RESOURCE_LIST);
									if (ttt!=null && (ttt.toString()).length()>0) {
										object.setObject(ISimpleGenResKeywords.TASK_RESOURCE_LIST, ttt);
									}
								}
								// ----------- MAPPING ------------
								{
									String rtos_name = ts.getCpuItem(i) != null ?  ts.getCpuItem(i).getName() : null;
									if (rtos_name!=null && rtos_name.length()>0) {
										object.setProperty(TASK_MAPPING, "" + rtos_name);
									}
								}
								
								object.setProperty(ISimpleGenResKeywords.RTOS_PATH,
										rtos[ri]);
							}
							break;
						}
						
					} // end "for (int ri=0; ri<rtos.length; ri++)"
				} // end "for (int i = 0; i < ts.getPrefixNumber(); i++)"

				objects = objList.toArray((new SimpleGenRes[objList.size()]));
				
				/*
				
				String prefix = path[0] + S + path[1] + S
						+ DPKG.getArchitectural_TaskList().getName() + S;
				String[] names = vt.newTreeInterface().getAllName(prefix,
						DPKG.getTask().getName());

				objects = new SimpleGenRes[names.length];
				for (int i = 0; i < names.length; i++) {
					objects[i] = new SimpleGenRes(names[i], prefix + names[i]);
					objects[i].setProperty(OilXMLLabels.ATTR_TYPE,
							OilXMLLabels.OBJ_TASK);
					
					
				}
				*/
			}
				break;
			case IOilObjectList.ISR: {
				

				/*******************************************************************
				 * Search isr
				 ******************************************************************/
				
				// use class TaskSet to search all tasks mapped to current rtos
				TaskSet ts = new TaskSet(vt, sysName);
				ts.setProperty(Task.STR_TASK_TYPE, "", false);
				ts.setProperty(Task.STR_RESOURCE_LIST, "", false);

				ArrayList<ISimpleGenRes> objList = new ArrayList<ISimpleGenRes>();
	
				for (int i = 0; i < ts.getPrefixNumber(); i++) {
					for (int ri=0; ri<rtos.length; ri++) {
						String rtosName = ""
							+ vt.newTreeInterface().getValue(
									rtos[ri] + S + DPKG.getRtos_Name().getName());
						
						if (rtosName != null && rtosName.equals(ts.getPrefix(i))) {
	
//							objects = new SimpleGenRes[ts.getSize(i)];
							for (int h = 0; h < ts.getSize(i); h++) {
								GenRes current = ts.getItem(i, h);
								if (!"isr".equalsIgnoreCase(current.getString(Task.STR_TASK_TYPE))) {
									continue; // this element is not a task
								}

								ISimpleGenRes object = new SimpleGenRes(
										current.getName(), current.getPath());
								objList.add(object);
								
								object.setProperty(IOilXMLLabels.ATTR_TYPE,
										IOilXMLLabels.OBJ_ISR);
	
								// take also ....

								// ----------- RESOURCE ------------
								if (current.existProperty(Task.STR_RESOURCE_LIST)) {
									Object ttt = current.getCollection(Task.STR_RESOURCE_LIST);
									if (ttt!=null && (ttt.toString()).length()>0) {
										object.setObject(ISimpleGenResKeywords.TASK_RESOURCE_LIST, ttt);
									}
								}
								
								object.setProperty(ISimpleGenResKeywords.RTOS_PATH,
										rtos[ri]);
							}
							break;
						}
						
					} // end "for (int ri=0; ri<rtos.length; ri++)"
				} // end "for (int i = 0; i < ts.getPrefixNumber(); i++)"

				objects = objList.toArray((new SimpleGenRes[objList.size()]));
				
				/*
				
				String prefix = path[0] + S + path[1] + S
						+ DPKG.getArchitectural_TaskList().getName() + S;
				String[] names = vt.newTreeInterface().getAllName(prefix,
						DPKG.getTask().getName());

				objects = new SimpleGenRes[names.length];
				for (int i = 0; i < names.length; i++) {
					objects[i] = new SimpleGenRes(names[i], prefix + names[i]);
					objects[i].setProperty(OilXMLLabels.ATTR_TYPE,
							OilXMLLabels.OBJ_TASK);
					
					
				}
				*/
			}
				break;
			case IOilObjectList.EVENT:
			case IOilObjectList.ALARM:
			case IOilObjectList.COUNTER: {

				String type = null;
				if (objID == IOilObjectList.EVENT) {
					type = IOilXMLLabels.OBJ_EVENT;
				} else if (objID == IOilObjectList.ALARM) {
					type = IOilXMLLabels.OBJ_ALARM;
				} else if (objID == IOilObjectList.COUNTER) {
					type = IOilXMLLabels.OBJ_COUNTER;
				} else { // ??????????????????
					break;
				}

				ITreeInterface ti = vt.newTreeInterface();
				String prefix = sysName + S + DPKG.getArchitectural().getName() + S
						+ DPKG.getArchitectural_SignalList().getName() + S;
				String[] names = ti.getAllName(prefix, DPKG.getSignal()
						.getName());

				ArrayList<ISimpleGenRes> objList = new ArrayList<ISimpleGenRes>();
				for (int i = 0; i < names.length; i++) {

					IVariable var = ti.getValue(prefix + S + names[i] + S
							+ DPKG.getSignal_Type().getName());
					if (var != null && type.equals(var.toString())) {

						ISimpleGenRes tmp = new SimpleGenRes(names[i], prefix
								+ names[i]);
						tmp.setProperty(IOilXMLLabels.ATTR_TYPE, type);
						tmp.setProperty(ISimpleGenResKeywords.RTOS_PATH,
								rtos[0]);
						objList.add(tmp);
					}

				}
				objects = objList
						.toArray(new SimpleGenRes[objList.size()]);
			}
				break;
			case IOilObjectList.RESOURCE: {
				String prefix = sysName + S + DPKG.getArchitectural().getName() + S
						+ DPKG.getArchitectural_MutexList().getName() + S;
				String[] names = vt.newTreeInterface().getAllName(prefix,
						DPKG.getMutex().getName());

				objects = new SimpleGenRes[names.length];
				for (int i = 0; i < names.length; i++) {
					objects[i] = new SimpleGenRes(names[i], prefix + names[i]);
					objects[i].setProperty(IOilXMLLabels.ATTR_TYPE,
							IOilXMLLabels.OBJ_RESOURCE);
					objects[i].setProperty(ISimpleGenResKeywords.RTOS_PATH,
							rtos[0]);
				}
			}
				break;
			case IOilObjectList.APPMODE: {
				String prefix = sysName + S + DPKG.getModes().getName() + S
						+ DPKG.getModes_ModeList().getName() + S;
				String[] names = vt.newTreeInterface().getAllName(prefix,
						DPKG.getMode().getName());

				objects = new SimpleGenRes[names.length];
				for (int i = 0; i < names.length; i++) {
					objects[i] = new SimpleGenRes(names[i], prefix + names[i]);
					objects[i].setProperty(IOilXMLLabels.ATTR_TYPE,
							IOilXMLLabels.OBJ_APPMODE);
					objects[i].setProperty(ISimpleGenResKeywords.RTOS_PATH,
							rtos[0]);
				}
			}
				break;
			case IOilObjectList.NETWORKMESSAGE: {
				final String sizeType = S+ DPKG.getFrame_Length().getName();
				final String prefix = sysName + S + DPKG.getArchitectural().getName() + S
						+ DPKG.getArchitectural_FrameList().getName() + S;
				ITreeInterface ti = vt.newTreeInterface();
				final String[] names = ti.getAllName(prefix,
						DPKG.getFrame().getName());
				

				objects = new SimpleGenRes[names.length];
				for (int i = 0; i < names.length; i++) {
					objects[i] = new SimpleGenRes(names[i], prefix + names[i]);
					objects[i].setProperty(IOilXMLLabels.ATTR_TYPE,
							IOilXMLLabels.OBJ_NETWORKMESSAGE);
					objects[i].setProperty(ISimpleGenResKeywords.RTOS_PATH,
							rtos[0]);
					
					
					try {
							IVariable size =  ti.getValue(prefix+ names[i]+sizeType);
							if (size != null && size.toString() != null) {
								objects[i].setProperty(ISimpleGenResKeywords.N_MESSAGE_LENGHT,
										size.toString());
							}
					} catch (Exception e) {
						// nothing
					}
					
					
					
				}
			}
				break;
			case IOilObjectList.MESSAGE:
			case IOilObjectList.COM:
			case IOilObjectList.NM:
			case IOilObjectList.IPDU:
				break;
			}

			answer.setList(objID, objects);
		}

		return answer;
	}

	/**
	 * Write the application section
	 * 
	 * @param buffer
	 *            the output (Oil)
	 * 
	 * @param id
	 *            identifies the Application
	 */
	protected void writeApplicationObject(StringBuffer buffer,
			String oilVarPrefix, ISimpleGenRes object, int objType, String rtosPath) {

		// header
		buffer.append(INDENT + object.getString(IOilXMLLabels.ATTR_TYPE) + " "
				+ object.getName() + " {\n");

		IVarTreePointer vtp = vt.newVarTreePointer();
		vtp.goAbsolute(object.getPath());
		String path = null;

		// choose path
		switch (objType) {
		case IOilObjectList.OS: {

			path = DPKG.getRtos_OilVar().getName() + S
					+ object.getString(IOilXMLLabels.ATTR_TYPE) + S
					+ oilVarPrefix;
		}
			break;
		case IOilObjectList.OSAPPLICATION: {
			path = DPKG.getOsApplication_OilVar().getName() + S
					+ object.getString(IOilXMLLabels.ATTR_TYPE) + S
					+ oilVarPrefix;
		}
		case IOilObjectList.ISR:
		case IOilObjectList.TASK: {
			path = DPKG.getTask_OilVar().getName() + S
					+ object.getString(IOilXMLLabels.ATTR_TYPE) + S
					+ oilVarPrefix;
		}
			break;
		case IOilObjectList.ALARM:
		case IOilObjectList.COUNTER:
		case IOilObjectList.EVENT: {
			path = DPKG.getRtos_OilVar().getName() + S
				+ object.getString(IOilXMLLabels.ATTR_TYPE) + S
				+ oilVarPrefix;
		}
			break;
		case IOilObjectList.RESOURCE: {
			path = DPKG.getMutex_OilVar().getName() + S
				+ IOilXMLLabels.OBJ_RESOURCE+ S
				+ oilVarPrefix;
		}
			break;
		case IOilObjectList.APPMODE: {
			path = DPKG.getRtos_OilVar().getName() + S
				+ IOilXMLLabels.OBJ_APPMODE + S
				+ oilVarPrefix;
		}
			break;
		case IOilObjectList.NETWORKMESSAGE: {
			
			// NOTE: This path doesn't exist
			path = DPKG.getMutex_OilVar().getName() + S
				+ IOilXMLLabels.OBJ_RESOURCE+ S
				+ oilVarPrefix;
		}
			break;
		case IOilObjectList.MESSAGE:
		case IOilObjectList.COM:
		case IOilObjectList.NM:
		case IOilObjectList.IPDU:
		default:
			vtp.goAbsolute(rtosPath);
			path = DPKG.getRtos_OilVar().getName() + S
				+ object.getString(IOilXMLLabels.ATTR_TYPE) + S
				+ oilVarPrefix;
			break;
		}

		// add properties
		writeApplicationObjectProperties(buffer, INDENT + INDENT,
				object, objType, rtosPath);
		
		// children
		if (vtp.go(path)) {
			for (boolean ok = vtp.goFirstChild(); ok; ok = vtp.goNextSibling()) {
				writeApplicationObject(buffer, INDENT + INDENT,
						(IVarTreePointer) vtp.clone());
			}
		}

		// end
		buffer.append(INDENT + "};\n");
	}
	
	protected void writeApplicationObjectProperties(StringBuffer buffer, String indent,
			ISimpleGenRes object, int objType, String rtosPath) {
		
		switch (objType) {
			case IOilObjectList.TASK: {
				// add PRIORITY
				if (object.containsProperty(ISimpleGenResKeywords.TASK_PRIORITY)) {
					buffer.append(indent + "PRIORITY = "
							+ object.getObject(ISimpleGenResKeywords.TASK_PRIORITY) + ";\n");
					
				}
				
				// add RESOURCES
				if (object.containsProperty(ISimpleGenResKeywords.TASK_RESOURCE_LIST)) {
					Collection  res = (Collection) object.getObject(ISimpleGenResKeywords.TASK_RESOURCE_LIST);
					
					for (Iterator iter = res.iterator(); iter.hasNext(); ) {
						
						buffer.append(indent + "RESOURCE = " + iter.next() + ";\n");
					}
				}
				
				// add APPNUMBER
				if (object.containsProperty(ISimpleGenResKeywords.TASK_ACTIVATION)) {
					buffer.append(indent + "ACTIVATION = "
							+ object.getObject(ISimpleGenResKeywords.TASK_ACTIVATION) + ";\n");
					
				}
			}
			break;
			
			case IOilObjectList.ISR: {
				
				// add RESOURCES
				if (object.containsProperty(ISimpleGenResKeywords.TASK_RESOURCE_LIST)) {
					Collection  res = (Collection) object.getObject(ISimpleGenResKeywords.TASK_RESOURCE_LIST);
					
					for (Iterator iter = res.iterator(); iter.hasNext(); ) {
						
						buffer.append(indent + "RESOURCE = " + iter.next() + ";\n");
					}
				}
			}
				break;
			case IOilObjectList.NETWORKMESSAGE: {
				// add RESOURCES
				if (object.containsProperty(ISimpleGenResKeywords.N_MESSAGE_LENGHT)) {
					String  res = object.getString(ISimpleGenResKeywords.N_MESSAGE_LENGHT);
					
					buffer.append(indent + "MESSAGEPROPERTY = STATIC {\n" +
							indent+indent+"SIZEINBITS = " + res + ";\n" +
							indent+"};\n");
					
				}
			}
				break;
		}

	}

	/**
	 * Write the application section
	 * 
	 * @param buffer
	 *            the output (Oil)
	 * 
	 * @param id
	 *            identifies the Application
	 */
	protected void writeApplicationObject(StringBuffer buffer, String indent,
			IVarTreePointer vtp) {

		String name = vtp.getName();

		if (vtp.exist(OAPKG.getValue_Values().getName())) {
			// ------------- A VARIABLE -----------------
			String type = null;
			{
				IVarTreePointer tvtp = (IVarTreePointer) vtp.clone();
				tvtp.go(OAPKG.getParameter_Type().getName());
				IVariable var = tvtp.getVar();

				type = "" + var;
			}

			String quote = "STRING".equalsIgnoreCase(type) ? "\"" : "";
			vtp.go(OAPKG.getValue_Values().getName());

			IVariable var = vtp.getVar();
			if (var instanceof IMultiValues) {
				String values[] = ((IMultiValues) var).getValues();
				if (values == null) {
					return;
				}

				for (int i = 0; i < values.length; i++) {
					buffer.append(indent + name + " = " + quote + values[i]
							+ quote + ";\n");
				}
			} else {
				if (!"null".equals("" + vtp.getVar())){
					buffer.append(indent + name + " = " + quote + vtp.getVar()
							+ quote + ";\n");
				}
			}

			return;

		} else if (vtp.go((OAPKG.getVariant_EnumeratorList().getName()))) {
			// ------------- A VARIANT -----------------

			for (boolean ok = vtp.goFirstChild(); ok; ok = vtp.goNextSibling()) {
				buffer.append(indent + name + " = ");
				writeApplicationObject(buffer, indent, (IVarTreePointer) vtp
						.clone());
				buffer.append(";\n");
			}

			return;

		}
		if (vtp.exist((OAPKG.getEnumerator_Value().getName()))) {
			// ------------- A SINGLE ENUM -----------------

			{
				IVarTreePointer tvtp = (IVarTreePointer) vtp.clone();
				tvtp.go(OAPKG.getEnumerator_Value().getName());
				IVariable var = tvtp.getVar();

				buffer.append("" + var);
			}

			boolean ok = vtp.go(OAPKG.getEnumerator_ParameterList().getName());
			ok &= vtp.goFirstChild();
			if (ok) {
				buffer.append(" {\n");

				for (; ok; ok = vtp.goNextSibling()) {
					writeApplicationObject(buffer, indent + INDENT,
							(IVarTreePointer) vtp.clone());
				}
				buffer.append(indent + "}");
			} else {
				//buffer.append(";\n");
			}

			return;
		}

		return;
	}

	
	// ------------------------------
	
	protected String typePathToString(ArrayList<String> typePath) {
		StringBuffer tmp = new StringBuffer();

		for (int i=typePath.size()-1; i>-1; i--) {
			tmp.append(
					typePath.get(i).toString()
					+ (i!=0 ? "/" : "")
			);
		}
		
		return tmp.toString();
		
	}
}