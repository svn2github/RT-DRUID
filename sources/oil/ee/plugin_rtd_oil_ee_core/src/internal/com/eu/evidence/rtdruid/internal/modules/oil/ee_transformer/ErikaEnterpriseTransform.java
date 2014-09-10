/*
 * Created on 11-nov-2004
 *
 * $Id: ErikaEnterpriseTransform.java,v 1.3 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.ee_transformer;


import static com.eu.evidence.rtdruid.vartree.VarTreeUtil.storeAVar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilImplID;
import com.eu.evidence.rtdruid.modules.oil.implementation.IOilImplID;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilObjectType;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilPath;
import com.eu.evidence.rtdruid.modules.oil.keywords.IOilXMLLabels;
import com.eu.evidence.rtdruid.modules.oil.transform.SimpleTransform;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

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
	@Override
	protected String storeOS(IVarTreePointer vtp, Element parent,
			String sysName, IOilImplID id) throws OilTransformException {
		String rtosName = null;
		rtosNamePath = new String[] {//
				DPKG.getSystem_Architectural().getName(),//
				DPKG.getArchitectural_EcuList().getName(), //
				sysName, // ecu name ... from oil
				DPKG.getEcu_CpuList().getName(), //
				null, // cpu name ... from oil
				DPKG.getCpu_Rtos().getName()//
				};

		
		class OScpuName {
			public final Element os;
			public final String cpuName;
			
			public OScpuName(Element os, String cpuName) {
				this.os = os;
				this.cpuName = cpuName;
			}
			
			public boolean sameCpuName(String cpuName) {
				return this.cpuName == null ? cpuName == null : this.cpuName.equals(cpuName);
			}
		}
		LinkedList<OScpuName> finalOsList = new LinkedList<OScpuName>();
		
		
		
		// prepare where store all data
		Element[] osList = getAllSameElements(parent, IOilXMLLabels.ELEM_OBJECT,
				new String[] { IOilXMLLabels.ATTR_TYPE }, new String[] { IOilXMLLabels.OBJ_OS });

		/*
		 * Check that each OS object contains the description of one (or zero) cpu.
		 * If an OS contains more cpu, create new OS objects and move sencond, 
		 * third, ... cpu to this new objects.
		 * 
		 * It's valid that distinct OS contain data of the same cpu.
		 */
		boolean default_cpu_found = false;
		String cpuName = null;
		for (int i = 0; i < osList.length; i++) {
			
			/*
			 * Parse an OS object
			 */
			
			// children contains the list of all CPU_DATA stored inside current OS Object
			Element[] children = getAllSameElements( //
					osList[i], //
					null, //
					new String[] { IOilXMLLabels.ATTR_NAME }, // 
					new String[] { CPU_DATA_NAME });

			// firstCpuName_os is the first cpuName found inside current OS object
			OScpuName firstCpuName_os = null;

			
			
			
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
									IOilXMLLabels.ELEM_PARAMETER, //
									new String[] { IOilXMLLabels.ATTR_NAME }, // 
									new String[] { "ID" });
							if (tmp != null && tmp.length>0) {
								tmpCpuName = getAttribute(tmp[0], IOilXMLLabels.ATTR_CURR_VALUE);
							}
						}
						if (DEFAULT_CPU_NAME.equals(tmpCpuName)) {
							default_cpu_found = true;
						}
						if (tmpCpuName == null) {
							tmpCpuName = DEFAULT_CPU_NAME;
						}
						
						if (firstCpuName_os == null){
							
							firstCpuName_os = new OScpuName(osList[i], tmpCpuName);
							
							// save current os inside the os-cpuName list
							finalOsList.add(firstCpuName_os);
						} else if  (!firstCpuName_os.sameCpuName(tmpCpuName)) {
							
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
						}

					}
				}
				
				// if this CPU_DATA is empty, remove it from OS
				if (children[ci].getChildNodes().getLength() == 0) {
					children[ci].getParentNode().removeChild(children[ci]);
					
				}
			}

			if (firstCpuName_os == null) { // NO CPU_DATA
//				firstCpuName_os = DEFAULT_CPU_NAME;

				// save current os inside the os-cpuName list
				finalOsList.add(new OScpuName(osList[i], null)); //firstCpuName_os));
			}

			
			if (cpuName == null) {
				cpuName = firstCpuName_os == null ? null : firstCpuName_os.cpuName;
			}
		}
		if (cpuName == null) {
			cpuName = DEFAULT_CPU_NAME;
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
			
			final String currCpuName;
			if (current.cpuName == null) {
				if (default_cpu_found) {
					currCpuName = DEFAULT_CPU_NAME;
				} else {
					currCpuName = cpuName;
				}
			} else {
				currCpuName = current.cpuName;
			}
			
			// update the rtosNamePath
			//rtosNamePath[5] = rtosName;

			// set the HW model
			IVarTreePointer curr = vtp.clone().makePath(new String[] { rtosNamePath[0],
					rtosNamePath[1], rtosNamePath[2], rtosNamePath[3],
					currCpuName }, new String[] { rtosTypePath[0],
					rtosTypePath[1], rtosTypePath[2], rtosTypePath[3],
					rtosTypePath[4] });
			storeAVar(curr, DPKG.getCpu_Model().getName(), ((OilImplID)id).getHW());

			curr.makePath(new String[] { rtosNamePath[5] },
					new String[] { rtosTypePath[5] });
			storeAVar(curr, DPKG.getRtos_Name().getName(), makeRtosId(currCpuName, rtosName));
			storeAVar(curr, DPKG.getRtos_Type().getName(), ((OilImplID)id).getRtos());


			storeInsideAOilVar(curr, current.os, id);
			
			{ // move vars outside OilVar
				IVarTreePointer oilVtp = (IVarTreePointer) curr.clone();
				IVarTreePointer osVtp = (IVarTreePointer) curr.clone();
				osVtp.goParent();

				final String path = (new OilPath(OilObjectType.OS, null)).getPath();
				
				{ // ----------- CPU_CLOCK ------------
					
					for (String s: getEnums(oilVtp, path+"CPU_DATA")) {
					
						IVarTreePointer lvtp = extract(oilVtp, path +"CPU_DATA"+S+s+S+"CPU_CLOCK");
						if (lvtp!= null) {
							String[] pNames = {
									DPKG.getCpu_Speed().getName()
							};
							String[] pTypes = {
									DPKG.getCpu_Speed().getName()
							};
							
							
							IVariable var = lvtp.getVar();
							if (var != null && var.get() != null) {
								lvtp.setVar(null);
								// remove data
	//							lvtp.goParent();
	//							lvtp.destroy();
	
								lvtp = osVtp.clone().makePath(pNames, pTypes);
								lvtp.setVar(var);
							}
						}
							
					}
				}
			}

		}

		return makeRtosId(cpuName, rtosName);
	}

	private List<String> getEnums(IVarTreePointer vtp, String path) {
		
		vtp = vtp.clone();
		boolean ok = vtp.go(path); //+ VARIANT_ELIST);
		ArrayList<String> answer = new ArrayList<String>();
		for (ok &= vtp.goFirstChild(); ok; ok&=vtp.goNextSibling()) {
			answer.add(vtp.getName());
		}
		return answer;
	}

	
	/* (non-Javadoc)
	 * @see rtdruid.modules.oil.transform.SimpleTransform#storeTasks(rtdruid.vartree.IVarTreePointer, org.w3c.dom.Element, rtdruid.modules.oil.vtextensions.OilImplID, java.lang.String)
	 */
	@Override
	protected void storeTasks(IVarTreePointer vtp, Element parent, IOilImplID id,
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
	protected void storeIsr(IVarTreePointer vtp, Element parent, IOilImplID id, String rtos)
			throws OilTransformException {
		// get only the name of rtos without cpu
		rtos = extractRtosName(rtos);

		// prepare where store all data
		Element[] isrList = getAllSameElements(parent, IOilXMLLabels.ELEM_OBJECT,
				new String[] { IOilXMLLabels.ATTR_TYPE }, new String[] { IOilXMLLabels.OBJ_ISR });

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
			String cpu = getTaskCpuMap(unamedIsr);
			if (cpu == null) {
				cpu = DEFAULT_CPU_NAME;
			}

			storeAnIsr((IVarTreePointer) vtp.clone(), unamedIsr, id);

			// also store mapping
			storeIsrMap((IVarTreePointer) vtp.clone(), null, makeRtosId(cpu, rtos));
		}

		// parse all tasks. If there're more than one instance for the same
		// task, that task is parsed more than one time
		for (Iterator<ArrayList<Element>> iter = namedIsr.iterator(); iter.hasNext();) {
			ArrayList<Element> ar = iter.next();
			String cpu = getTaskCpuMap(ar);
			if (cpu == null) {
				cpu = DEFAULT_CPU_NAME;
			}

			storeAnIsr((IVarTreePointer) vtp.clone(), ar, id);

			// also store mapping
			storeIsrMap((IVarTreePointer) vtp.clone(), getAttribute(ar.get(0), "Name"), DataPath.makeSlashedId(new String[] {cpu, rtos}));

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
					IOilXMLLabels.ELEM_PARAMETER, //
					new String[] { IOilXMLLabels.ATTR_NAME }, // 
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
	@Override
	protected void writeApplication(StringBuffer buffer, IOilImplID id,
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
	protected void writeApplication(StringBuffer buffer, IOilImplID id,
			String[] rtosPath) {

		String sysName = DataPath.splitPath(rtosPath[0])[0];

		//String cpuName = splittedPath[0];
		String oilVarPrefix = S;
//				+ OilApplPackage.eINSTANCE.getRoot_HwList().getName() + S
//				+ DataPath.makeSlashedId(id.getHW()) + S
//				+ OilApplPackage.eINSTANCE.getHW_RtosList().getName() + S
//				+ DataPath.makeSlashedId(id.getRtos()) + S
//				+ OilApplPackage.eINSTANCE.getRTOS_ParameterList().getName()
//				+ S;

		//header
		buffer.append("CPU " + sysName + " {\n");

		IOilObjectList ool = extractApplicationObjects(rtosPath);

		int order[] = { IOilObjectList.OS, IOilObjectList.OSAPPLICATION, IOilObjectList.TASK,
				IOilObjectList.COUNTER, IOilObjectList.ALARM,
				IOilObjectList.RESOURCE, IOilObjectList.EVENT, IOilObjectList.ISR,
				IOilObjectList.MESSAGE, IOilObjectList.NETWORKMESSAGE,
				IOilObjectList.COM, IOilObjectList.NM, IOilObjectList.APPMODE,
				IOilObjectList.IPDU, IOilObjectList.SPINLOCK, IOilObjectList.SCHEDULE_TABLE };

		for (int oolId = 0; oolId < order.length; oolId++) {

			List<ISimpleGenRes> olist = ool.getList(order[oolId]);
			for (Iterator<ISimpleGenRes> iter = olist.iterator(); iter.hasNext();) {
				ISimpleGenRes curr = iter.next(); 
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
	@Override
	public String write(IVarTree vt, IOilImplID id, String[] rtosPaths)
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
	@Override
	protected void writeApplicationObject(StringBuffer buffer,
			String oilVarPrefix, ISimpleGenRes object, int objType, String rtosPath) {
		
		switch (objType) {
		case IOilObjectList.OS: {
			HashMap<String, String> add = new HashMap<String, String>(); 

			ISimpleGenRes tmp = new SimpleGenRes(object.getName().contains("" + DataPath.SEPARATOR) ? extractRtosName(object.getName()) : "EE",
						object.getPath());
			
			// fare la copia dell'oggetto !!!
			HashMap<String, ? extends Object> properties = object.getAllProperties();
			for (Iterator<String> iter = properties.keySet().iterator(); iter.hasNext(); ) {
				String key = (String) iter.next();
				tmp.setObject(key, properties.get(key));
			}
			
			object = tmp;
			{ // add CPU_SPEED
				IVarTreePointer vtp = vt.newVarTreePointer();
				boolean ok = vtp.goAbsolute(object.getPath());
				ok &= vtp.goParent();
				ok &= vtp.go(DPKG.getCpu_Speed().getName());
				if (ok) {
					IVariable v = vtp.getVar();
					if (v != null && v.get() != null) {
						String speedt = v.toString();
						if (!speedt.isEmpty() && !(""+null).equals(speedt)) {
							double factor = 1;
							if (speedt.toLowerCase().contains("ghz")) {
								factor = 1000;
								speedt = speedt.toLowerCase().replace("ghz", "").trim();
							} else if (speedt.toLowerCase().contains("mhz")) {
								speedt = speedt.toLowerCase().replace("mhz", "").trim();
							} else if (speedt.toLowerCase().contains("khz")) {
								factor = 0.001;
								speedt = speedt.toLowerCase().replace("khz", "").trim();
							} else if (speedt.toLowerCase().contains("hz")) {
								factor = 0.000001;
								speedt = speedt.toLowerCase().replace("hz", "").trim();
							}
							double speed = 0;
							try {
								speed = Double.parseDouble(speedt);
							} catch (NumberFormatException e) {
								speed = 0;
							}
							
							if (speed != 0) {
								String oilPath = object.getPath() +S+ (new OilPath(OilObjectType.OS, null)).getPath()+ S + "CPU_DATA";

								for (String s: CommonUtils.getAllChildrenEnumType(vt, oilPath, null)) {
									add.put("/CPU_DATA/"+s, INDENT+INDENT+INDENT+"CPU_CLOCK = " + (speed*factor) + ";\n");
								}
							}
						}
					}
				}
			}
			object.setObject(SGR_ADDITIONAL, add);
			
		}
			break;		
			
		case IOilObjectList.TASK: {
			
			// CPU_ID
						String path = (new OilPath(OilObjectType.TASK, null)).getPath() + "CPU_ID";
						IVarTreePointer vtp = vt.newVarTreePointer();
						vtp.goAbsolute(object.getPath());
						if (vtp.go(path)) {
							// System.out.println("TROVATO CPU_ID");
							
						} else {
							object.setProperty(TASK_FORCE_MAPPING, Boolean.TRUE.toString());
						}
			
		}
		break;		
			
		case IOilObjectList.ISR: {
			
			// CPU_ID
						String path = (new OilPath(OilObjectType.ISR, null)).getPath() + "CPU_ID";
						IVarTreePointer vtp = vt.newVarTreePointer();
						vtp.goAbsolute(object.getPath());
						if (vtp.go(path)) {
							// System.out.println("TROVATO CPU_ID");
							
						} else {
							object.setProperty(ISR_FORCE_MAPPING, Boolean.TRUE.toString());
						}
			
		}
		}
		super.writeApplicationObject(buffer, oilVarPrefix, object, objType, rtosPath);
	}

	/*
	 * (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.transform.SimpleTransform#writeApplicationObjectProperties(java.lang.StringBuffer, java.lang.String, com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes, int, java.lang.String)
	 */
	@Override
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
				String cpu_name = extractCpuName(object.getString(TASK_MAPPING));
				
				buffer.append(indent + "CPU_ID = \"" + cpu_name + "\"; // auto value\n");
			}
			
		}
		case IOilObjectList.ISR: {
			
			// CPU_ID
			if (object.containsProperty(ISR_FORCE_MAPPING) 
					&& "TRUE".equalsIgnoreCase(object.getString(ISR_FORCE_MAPPING))
					&& object.containsProperty(ISR_MAPPING)) {
				String cpu_name = extractCpuName(object.getString(ISR_MAPPING));
				
				buffer.append(indent + "CPU_ID = \"" + cpu_name + "\"; // auto value\n");
			}
			
		}
		};
		
		
	}
		
	private String makeRtosId(String cpu, String rtos) {
		return DataPath.makeSlashedId(new String[] {cpu, rtos});
	}
	private String extractCpuName(String rtosAndCpu) {
		if (rtosAndCpu == null) return null;

		String answer = rtosAndCpu;
		String[] tmp = DataPath.resolveId(DataPath.removeSlash(rtosAndCpu));
		if (tmp.length == 2) {
			answer = tmp[0];
		}
		return answer;
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
