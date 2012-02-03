/*
 * Created on 11-nov-2004
 *
 * $Id: ErikaEnterpriseTransform.java,v 1.3 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.ee_transformer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilTransformException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.abstractions.SimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplID;
import com.eu.evidence.rtdruid.modules.oil.keywords.IOilXMLLabels;
import com.eu.evidence.rtdruid.modules.oil.transform.SimpleTransform;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.init.DataPath;
import com.eu.evidence.rtdruid.vartree.data.oil.OilApplPackage;

/**
 * This class just store all data inside the OilVar of each FirstLevelObject
 * (OS, TASK, ...)
 * 
 * @author Nicola Serreli
 */
public class ErikaEnterpriseTransform extends SimpleTransform {

	final static String DEFAULT_CPU_NAME = IWritersKeywords.DEFAULT_CPU_NAME;
	
	final static String CPU_DATA_NAME = "CPU_DATA";
	
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
		rtosNamePath = new String[] {//
				DPKG.getSystem_Architectural().getName(),//
				DPKG.getArchitectural_EcuList().getName(), //
				sysName, // ecu name ... from oil
				DPKG.getEcu_CpuList().getName(), //
				null, // cpu name ... from oil
				DPKG.getCpu_Rtos().getName(),//
				DPKG.getRtos_OilVar().getName() };

		
		class OScpuName {
			public final Element os;
			public final String cpuName;
			
			public OScpuName(Element os, String cpuName) {
				this.os = os;
				this.cpuName = cpuName;
			}
		}
		LinkedList<OScpuName> finalOsList = new LinkedList<OScpuName>();
		
		
		
		// prepare where store all data
		Element[] osList = getAllSameElements(parent, "Object",
				new String[] { "type" }, new String[] { IOilXMLLabels.OBJ_OS });

		/*
		 * Check that each OS object contains the description of one (or zero) cpu.
		 * If an OS contains more cpu, create new OS objects and move sencond, 
		 * third, ... cpu to this new objects.
		 * 
		 * It's valid that distinct OS contain data of the same cpu.
		 */
		String cpuName = null;
		for (int i = 0; i < osList.length; i++) {
			
			/*
			 * Parse an OS object
			 */
			
			// children contains the list of all CPU_DATA stored inside current OS Object
			Element[] children = getAllSameElements( //
					osList[i], //
					null, //
					new String[] { OAPKG.getParameter_Name().getName() }, // 
					new String[] { CPU_DATA_NAME });

			// firstCpuName_os is the first cpuName found inside current OS object
			String firstCpuName_os = null;

			// check all cpu_data
			for (int ci =0; ci<children.length; ci++) {
				/*
				 * Parse an CPU_DATA parameter.
				 * 
				 * a cpu_data contains one or more enumerator
				 */
				
				
				NodeList cpuDataList = children[ci].getChildNodes(); 
				for (int ni =0; ni<cpuDataList.getLength(); ni++) {
					Node cpuData = cpuDataList.item(ni);

					/*
					 * Parse an enumerator inside the cpu_data
					 */

					// if is an enumerator, check for cpuName (ID). If it's a different ID, than move it out, to a new OS object
					if (cpuData instanceof Element && IOilXMLLabels.ELEM_ENUM_VALUE.equalsIgnoreCase(cpuData.getNodeName())) {
						
						String tmpCpuName = null;
						{
							Element[] tmp = getAllSameElements( //
									(Element) cpuData, //
									OAPKG.getParameter().getName(), //
									new String[] { OAPKG.getParameter_Name().getName() }, // 
									new String[] { "ID" });
							if (tmp != null && tmp.length>0) {
								tmpCpuName = getAttribute(tmp[0], IOilXMLLabels.ATTR_CURR_VALUE);
							}
						}
						if (tmpCpuName == null) {
							tmpCpuName = DEFAULT_CPU_NAME;
						}
						
						if (firstCpuName_os != null && !firstCpuName_os.equalsIgnoreCase(tmpCpuName)) {
							
							/*
							 * Create a new OS object and move current cpu inside it 
							 */
							Document doc = parent.getOwnerDocument();
							
							// new OS
							Element newOS = doc.createElement(IOilXMLLabels.ELEM_OBJECT);
							newOS.setAttribute(IOilXMLLabels.ATTR_TYPE,  IOilXMLLabels.OBJ_OS);
							if (parent.hasAttribute(IOilXMLLabels.ATTR_NAME)) {
								newOS.setAttribute(IOilXMLLabels.ATTR_NAME, osList[i].getAttribute(IOilXMLLabels.ATTR_NAME) );
							}
							parent.appendChild(newOS);
							
							// new CPU_DATA
							Element newCpuData = doc.createElement(IOilXMLLabels.ELEM_PARAMETER);
							newCpuData.setAttribute(IOilXMLLabels.ATTR_NAME, CPU_DATA_NAME );
							newOS.appendChild(newCpuData);
							
							// move cpuData enumerator
							cpuData.getParentNode().removeChild(cpuData);
							newCpuData.appendChild(cpuData);

							// save the new os inside the os-cpuName list
							finalOsList.add(new OScpuName(newOS, tmpCpuName));
							
						} else {
							firstCpuName_os = tmpCpuName;
							
							// save current os inside the os-cpuName list
							finalOsList.add(new OScpuName(osList[i], firstCpuName_os));
						}

					}
				}
				
				// if this CPU_DATA is empty, remove it from OS
				if (children[ci].getChildNodes().getLength() == 0) {
					children[ci].getParentNode().removeChild(children[ci]);
					
				}
			}

			if (firstCpuName_os == null) {
				firstCpuName_os = DEFAULT_CPU_NAME;

				// save current os inside the os-cpuName list
				finalOsList.add(new OScpuName(osList[i], firstCpuName_os));
			}

			
			if (cpuName == null) {
				cpuName = firstCpuName_os;
			}
		}
		rtosNamePath[4] = cpuName;

		
		// store all instance of OS object from Oil tree
		for (Iterator<OScpuName> iter = finalOsList.iterator(); iter.hasNext(); ) {
			OScpuName current = iter.next();
			
			if (rtosName == null) {
				rtosName = getAttribute(current.os, "Name");
			} else {
				// check the rtosName
				checkTrue(checkStrings(rtosName,
						getAttribute(current.os, "Name")),
						"The oil tree contains more than one "
								+ IOilXMLLabels.OBJ_OS);
			}
			
			
			// update the rtosNamePath
			//rtosNamePath[5] = rtosName;

			// set the HW model
			IVarTreePointer curr = makePath(vtp, new String[] { rtosNamePath[0],
					rtosNamePath[1], rtosNamePath[2], rtosNamePath[3],
					current.cpuName }, new String[] { rtosTypePath[0],
					rtosTypePath[1], rtosTypePath[2], rtosTypePath[3],
					rtosTypePath[4] });
			storeAVar(curr, DPKG.getCpu_Model().getName(), id.getHW());

			curr = makePath(curr, new String[] { rtosNamePath[5] },
					new String[] { rtosTypePath[5] });
			storeAVar(curr, DPKG.getRtos_Name().getName(), makeRtosId(current.cpuName, rtosName));
			storeAVar(curr, DPKG.getRtos_Type().getName(), id.getRtos());

			curr = makePath(curr, new String[] { rtosNamePath[6] },
					new String[] { rtosTypePath[6] });


			storeInsideAOilVar(curr, current.os, id);
		}

		return makeRtosId(cpuName, rtosName);
	}
	
	/* (non-Javadoc)
	 * @see rtdruid.modules.oil.transform.SimpleTransform#storeTasks(rtdruid.vartree.IVarTreePointer, org.w3c.dom.Element, rtdruid.modules.oil.vtextensions.OilImplID, java.lang.String)
	 */
	protected void storeTasks(IVarTreePointer vtp, Element parent, OilImplID id,
			String rtos) throws OilTransformException {

		// get only the name of rtos without cpu
		rtos = extractRtosName(rtos);
		
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
			
			String cpu = getTaskCpuMap(unamedTasks);
			if (cpu == null) {
				cpu = DEFAULT_CPU_NAME;
			}

			storeATask((IVarTreePointer) vtp.clone(), unamedTasks, id);

			// also store mapping
			storeTaskMap((IVarTreePointer) vtp.clone(), null, makeRtosId(cpu, rtos));
		}

		// parse all tasks. If there're more than one instance for the same
		// task, that task is parsed more than one time
		for (Iterator<ArrayList<Element>> iter = namedTasks.iterator(); iter.hasNext();) {
			ArrayList<Element> ar = iter.next();
			
			String cpu = getTaskCpuMap(ar);
			if (cpu == null) {
				cpu = DEFAULT_CPU_NAME;
			}

			storeATask((IVarTreePointer) vtp.clone(), ar, id);

			// also store mapping
			storeTaskMap((IVarTreePointer) vtp.clone(), getAttribute(ar.get(0), "Name"), DataPath.makeSlashedId(new String[] {cpu, rtos}));

		}
	}
	
	/**
	 * Searchs inside one or more XML elements that describes a task some info
	 * about the mapping between task and a cpu.
	 * 
	 * @return the cpu name or null if not found
	 */
	protected String getTaskCpuMap(ArrayList<Element> task) {
		String answer = null;

		for (int i=0; i<task.size(); i++) {

			Element[] tmp = getAllSameElements( //
					task.get(i), //
					OAPKG.getParameter().getName(), //
					new String[] { OAPKG.getParameter_Name().getName() }, // 
					new String[] { "CPU_ID" });
			if (tmp != null) {
				for (int ti=0; ti<tmp.length; ti++) {
					
					String value = getAttribute(tmp[ti], IOilXMLLabels.ATTR_CURR_VALUE); 
					if (answer == null) {
						answer = value;
					} else {
						checkTrue(checkStrings(answer, value), "The same task is mapped to more than one cpu:\n"
								+ "\t Task = " +  getAttribute(task.get(i), IOilXMLLabels.ATTR_NAME)
								+ "\n\t cpu1 = " + answer
								+ "\n\t cpu2 = " + value);
					}
				}
			}
		}
		return answer;
	}
	
	// ****************************************************
	
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
		
		writeApplication(buffer, id, new String[] { rtosPath} );
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
			String[] rtosPath) {

		String sysName = DataPath.splitPath(rtosPath[0])[0];

		//String cpuName = splittedPath[0];
		String oilVarPrefix = S
				+ OilApplPackage.eINSTANCE.getRoot_HwList().getName() + S
				+ DataPath.makeSlashedId(id.getHW()) + S
				+ OilApplPackage.eINSTANCE.getHW_RtosList().getName() + S
				+ DataPath.makeSlashedId(id.getRtos()) + S
				+ OilApplPackage.eINSTANCE.getRTOS_ParameterList().getName()
				+ S;

		//header
		buffer.append("CPU " + sysName + " {\n");

		IOilObjectList ool = extractApplicationObjects(rtosPath);

		int order[] = { IOilObjectList.OS, IOilObjectList.OSAPPLICATION, IOilObjectList.TASK,
				IOilObjectList.COUNTER, IOilObjectList.ALARM,
				IOilObjectList.RESOURCE, IOilObjectList.EVENT, IOilObjectList.ISR,
				IOilObjectList.MESSAGE, IOilObjectList.NETWORKMESSAGE,
				IOilObjectList.COM, IOilObjectList.NM, IOilObjectList.APPMODE,
				IOilObjectList.IPDU };

		for (int oolId = 0; oolId < order.length; oolId++) {

			List<ISimpleGenRes> olist = ool.getList(order[oolId]);
			for (Iterator<ISimpleGenRes> iter = olist.iterator(); iter.hasNext();) {
				ISimpleGenRes curr = (ISimpleGenRes) iter.next(); 
				writeApplicationObject(buffer, oilVarPrefix,
						curr, order[oolId], curr.getString(ISimpleGenResKeywords.RTOS_PATH));
			}

		}

		//end
		buffer.append("};\n\n");

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
		
		// init
		this.vt = vt;

		if (rtosPaths == null || rtosPaths.length == 0) {
			throw new NullPointerException("required a not null path");
		}
		for (int i=0; i<rtosPaths.length; i++) {
			if (!vt.newTreeInterface().exist(rtosPaths[i],
					DataPackage.eINSTANCE.getRtos().getName())) {
				throw new IllegalArgumentException(
						"The specified rtos path isn't valid.\n\t" + "path = "
								+ rtosPaths[i]);
			}
		}

		StringBuffer buffer = new StringBuffer();
		if (writeImplementation) {
			buffer.append("OIL_VERSION = \"2.4\";\n\n");
	
			// write
			writeImplementation(buffer, id);
		}

		writeApplication(buffer, id, rtosPaths);
		return buffer.toString();
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
	@SuppressWarnings("unchecked")
	protected void writeApplicationObject(StringBuffer buffer,
			String oilVarPrefix, ISimpleGenRes object, int objType, String rtosPath) {
		
		switch (objType) {
		case IOilObjectList.OS: {

			ISimpleGenRes tmp = new SimpleGenRes(object.getName().contains("" + DataPath.SEPARATOR) ? extractRtosName(object.getName()) : "EE",
						object.getPath());
			
			// fare la copia dell'oggetto !!!
			HashMap properties = object.getAllProperties();
			for (Iterator iter = properties.keySet().iterator(); iter.hasNext(); ) {
				String key = (String) iter.next();
				tmp.setObject(key, properties.get(key));
			}
			
			object = tmp;
		}
			break;		
			
		case IOilObjectList.TASK: {
			
			// CPU_ID
						String path = DPKG.getTask_OilVar().getName() + S
								+ object.getString(IOilXMLLabels.ATTR_TYPE) + S
								+ oilVarPrefix + "CPU_ID";
						IVarTreePointer vtp = vt.newVarTreePointer();
						vtp.goAbsolute(object.getPath());
						if (vtp.go(path)) {
							// System.out.println("TROVATO CPU_ID");
							
						} else {
							object.setProperty(TASK_FORCE_MAPPING, Boolean.TRUE.toString());
						}
			
		}
		}
		super.writeApplicationObject(buffer, oilVarPrefix, object, objType, rtosPath);
	}

	protected void writeApplicationObjectProperties(StringBuffer buffer, String indent,
			ISimpleGenRes object, int objType, String rtosPath) {
		super.writeApplicationObjectProperties(buffer, indent,
				object, objType, rtosPath);
		
		switch (objType) {
		case IOilObjectList.TASK: {
			
			// CPU_ID
			if (object.containsProperty(TASK_FORCE_MAPPING) 
					&& "TRUE".equalsIgnoreCase(object.getString(TASK_FORCE_MAPPING))
					&& object.containsProperty(TASK_MAPPING)) {
				String rtos_name = extractRtosName(object.getString(TASK_MAPPING));
				
				buffer.append(indent + "CPU_ID = \"" + rtos_name + "\"; // auto value\n");
			}
			
		}
		};
		
		
	}
		
	private String makeRtosId(String cpu, String rtos) {
		return DataPath.makeSlashedId(new String[] {cpu, rtos});
	}
	private String extractRtosName(String rtosAndCpu) {
		if (rtosAndCpu == null) return null;

		String answer = rtosAndCpu;
		String[] tmp = DataPath.resolveId(DataPath.removeSlash(rtosAndCpu));
		if (tmp.length == 2) {
			answer = tmp[1];
		}
		return answer;
	}
}