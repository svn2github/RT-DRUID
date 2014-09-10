/*
 * Created on Nov 29, 2004
 *
 * $Id: AbstractRtosWriter.java,v 1.8 2008/05/14 17:13:15 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.codewriter.common;

import static com.eu.evidence.rtdruid.modules.oil.transform.SimpleTransform.COM_LIST;
import static com.eu.evidence.rtdruid.modules.oil.transform.SimpleTransform.COM_TYPE;
import static com.eu.evidence.rtdruid.modules.oil.transform.SimpleTransform.MESSAGE_TYPE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.common.OilObjectList;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.abstractions.SimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilEcoreCreator;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilObjectType;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilPath;
import com.eu.evidence.rtdruid.modules.oil.interfaces.IRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.keywords.IOilXMLLabels;
import com.eu.evidence.rtdruid.modules.oil.transform.SimpleTransform;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.abstractions.old.GenRes;
import com.eu.evidence.rtdruid.vartree.abstractions.old.Task;
import com.eu.evidence.rtdruid.vartree.abstractions.old.TaskSet;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

/**
 * This class is an abstract writer for a specific RT-OS.
 * 
 * @author Nicola Serreli
 */
public abstract class AbstractRtosWriter implements IRtosWriter {

	/** Contains all data */
	protected IVarTree vt;

	/** Contains zero or more options */
	protected HashMap<String, ?> options;

	/** All keys, extracted from data (never null) */
	protected String[] keys;

	/** Contains all OSEK Object in */
	protected IOilObjectList[] oilObjects;

	/** A shortcut to {@link DataPath#SEPARATOR DataPath.SEPARATOR} */
	private final static String S = "" + DataPath.SEPARATOR;

	/**
	 * Contains all path that identifies inside the VarTree all rtos
	 */
	protected String[] rtosPrefix;

	/** Architectural prefix */
	protected String architecturalPrefix;
	
	/**
	 * Contains the prefix inside the OilVar (one for all rtos)
	 */
	protected String oilHwRtosPrefix;

	private Integer rtosSize;

	/***************************************************************************
	 * 
	 * INITIALIZATION
	 *  
	 **************************************************************************/

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.internal.modules.oil.codewriter.common.IRtosWriter#init(com.eu.evidence.rtdruid.vartree.IVarTree, java.lang.String[], java.util.HashMap)
	 */
	public void init(IVarTree vt, String[] rtosPrefix, HashMap<String, ?> opt) 
			throws OilCodeWriterException {
		Assert.isNotNull(vt);
		Assert.isNotNull(rtosPrefix);
		this.vt = vt;
		this.rtosPrefix = rtosPrefix;
		this.options = opt == null ? new HashMap<String, Object>() : opt;
		
		//oilVarPrefix = "";
		oilHwRtosPrefix = "";
		
		{ // search the architectural prefix
			
			if (rtosPrefix.length>0) {
				String[] tmp = DataPath.splitPath(rtosPrefix[0]);
				
				if (tmp.length>2) {
					architecturalPrefix = DataPath.makeSlashedId(tmp[0]) + S + DataPath.makeSlashedId(tmp[1]); 
				}
				
				oilHwRtosPrefix = S;
//						+ OilApplPackage.eINSTANCE.getRoot_HwList().getName()
//						+ S
//						+ DataPath.makeSlashedId(getHwOilId())
//						+ S
//						+ OilApplPackage.eINSTANCE.getHW_RtosList().getName()
//						+ S
//						+ DataPath.makeSlashedId(getRtosOilId())
//						+ S
//						+ OilApplPackage.eINSTANCE.getRTOS_ParameterList()
//								.getName()+S;

			}
			
		}

		{ // extract keys
			this.keys = extractKeys();
			//System.err.println("" + Arrays.asList(this.keys));
			Assert.isNotNull(this.keys);
		}

		{ // extract all Oil Object Lists
			this.oilObjects = extractObjects();
			Assert.isNotNull(this.oilObjects);
		}
	}

	/**
	 * This method searchs all KEYWORDS defined inside the VarTree for current
	 * list of specific rtos. (HW type is a first one)<br>
	 *
	 * (See also {@link IWritersKeywords WritersKeys})
	 * 
	 * @return an array of String that contains all Keywords defined in the first rtos
	 * 
	 * @throws OilCodeWriterException if there are some problems
	 */
	protected String[] extractKeys() throws OilCodeWriterException  {

		String[] answer = new String[0];

		if (rtosPrefix.length > 0) {

			// check only the first RTOS !!! (as rtos of CPU0)
			IVarTreePointer vtp = vt.newVarTreePointer();

			// check for rtos
			if (!vtp.go(rtosPrefix[0])) {
				return answer;
			}

			// get HW type
			String hw_type = getHwOilId();
			
			// if hw_type is set, add it to keywords
			if (hw_type != null) {
				String[] tmp = new String[answer.length + 1];
				System.arraycopy(answer, 0, tmp, 0, answer.length);
				tmp[answer.length] = hw_type;
				answer = tmp;
			}
		}
		return answer;
	}

	/**
	 * This method searchs all Oil objects defined inside the VarTree for
	 * current list of specific rtos.
	 * 
	 * @return an array of OilObjectList that contains all object defined. An
	 *         OilObjectList for each CPU. (Never returns null)
	 * 
	 * @throws OilCodeWriterException
	 *             throw this exception if there are some problems
	 */
	protected IOilObjectList[] extractObjects()
			throws OilCodeWriterException {
		
		Map<String, IOilObjectList> answer = extractDistinctOs();
		
		boolean extractSpinlocks = true;
		for (IOilObjectList ool: answer.values()) {

			for (ISimpleGenRes sgros: ool.getList(IOilObjectList.OS)) {
				String prefix = sgros.getPath();
				
				// search all objects
				for (int id = 0; id < IOilObjectList.OBJECT_NUMBER; id++) {
					List<ISimpleGenRes> list = ool.getList(id);
					ISimpleGenRes[] extracted;
					if (id == IOilObjectList.SPINLOCK && !extractSpinlocks) {
						// add spinlocks only to mastercpu
						extracted = new ISimpleGenRes[0];
					} else {
						extracted = extractObject(id, prefix);
					}
					ool.setList(id, merge(id, list, extracted));
				}
			}
			extractSpinlocks = false;
		}
		
		// check if at least one object has an OsApplication access rule
		if (!checkKeyword(IWritersKeywords.KERNEL_SERVICE_PROTECTION)) {
			
			boolean found = false;
			stop_searching:
			for (IOilObjectList ool: answer.values()) {

				for (ISimpleGenRes sgros: ool.getList(IOilObjectList.TASK)) {
					if (sgros.containsProperty(ISimpleGenResKeywords.TASK_ACCESSING_OS_APPL_LIST) &&
							!((List) sgros.getObject(ISimpleGenResKeywords.TASK_ACCESSING_OS_APPL_LIST)).isEmpty()) {
						found = true;
						break stop_searching;
					}
				}
			
				for (ISimpleGenRes sgros: ool.getList(IOilObjectList.RESOURCE)) {
					if (sgros.containsProperty(ISimpleGenResKeywords.RESOURCE_ACCESSING_OS_APPL_LIST) &&
							!((List) sgros.getObject(ISimpleGenResKeywords.RESOURCE_ACCESSING_OS_APPL_LIST)).isEmpty()) {
						found = true;
						break stop_searching;
					}
				}
			
				for (ISimpleGenRes sgros: ool.getList(IOilObjectList.ISR)) {
					if (sgros.containsProperty(ISimpleGenResKeywords.ISR_ACCESSING_OS_APPL_LIST) &&
							!((List) sgros.getObject(ISimpleGenResKeywords.ISR_ACCESSING_OS_APPL_LIST)).isEmpty()) {
						found = true;
						break stop_searching;
					}
				}
			
				for (ISimpleGenRes sgros: ool.getList(IOilObjectList.COUNTER)) {
					if (sgros.containsProperty(ISimpleGenResKeywords.COUNTER_ACCESSING_OS_APPL_LIST) &&
							!((List) sgros.getObject(ISimpleGenResKeywords.COUNTER_ACCESSING_OS_APPL_LIST)).isEmpty()) {
						found = true;
						break stop_searching;
					}
				}
			
				for (ISimpleGenRes sgros: ool.getList(IOilObjectList.ALARM)) {
					if (sgros.containsProperty(ISimpleGenResKeywords.ALARM_ACCESSING_OS_APPL_LIST) &&
							!((List) sgros.getObject(ISimpleGenResKeywords.ALARM_ACCESSING_OS_APPL_LIST)).isEmpty()) {
						found = true;
						break stop_searching;
					}
				}
			
				for (ISimpleGenRes sgros: ool.getList(IOilObjectList.SPINLOCK)) {
					if (sgros.containsProperty(ISimpleGenResKeywords.SPINLOCK_ACCESSING_OS_APPL_LIST) &&
							!((List) sgros.getObject(ISimpleGenResKeywords.SPINLOCK_ACCESSING_OS_APPL_LIST)).isEmpty()) {
						found = true;
						break stop_searching;
					}
				}
				
				for (ISimpleGenRes sgros: ool.getList(IOilObjectList.SCHEDULE_TABLE)) {
					if (sgros.containsProperty(ISimpleGenResKeywords.SCHEDTABLE_ACCESSING_OS_APPL_LIST) &&
							!((List) sgros.getObject(ISimpleGenResKeywords.SCHEDTABLE_ACCESSING_OS_APPL_LIST)).isEmpty()) {
						found = true;
						break stop_searching;
					}
				}
			}
			
			if (found) {
				// update the keywords
				String[] tmp = new String[keys.length +1];
				System.arraycopy(keys, 0, tmp, 0, keys.length);
				tmp[keys.length] = IWritersKeywords.KERNEL_SERVICE_PROTECTION;
				keys = tmp;
			}
		}
		
		return answer.values().toArray(new IOilObjectList[answer.size()]);
	}

	public Map<String, IOilObjectList> extractDistinctOs() {
		return extractDistinctOs(vt, rtosPrefix);
	}
	public static Map<String, IOilObjectList> extractDistinctOs(IVarTree vt, String[] rtosPrefix) {
		final DataPackage DPKG = DataPackage.eINSTANCE;
		Map<String, IOilObjectList> answer = new LinkedHashMap<String, IOilObjectList>();

		// cicle all rtos
		for (int rtosId = 0; rtosId < rtosPrefix.length; rtosId++) {
			ISimpleGenRes oss = new SimpleGenRes(
					getVarAsString(vt, rtosPrefix[rtosId] + S
							+ DPKG.getRtos_Name().getName()), rtosPrefix[rtosId]);
			final String osName = oss.getName();
			if (answer.containsKey(osName)) {
				IOilObjectList old_ool = answer.get(osName);  
				ArrayList<ISimpleGenRes> newList = new ArrayList<ISimpleGenRes>(old_ool.getList(IOilObjectList.OS));
				
				newList.add(oss);
				old_ool.setList(IOilObjectList.OS, newList);
			} else {
			IOilObjectList ool = new OilObjectList();
				ool.setList(IOilObjectList.OS, new ISimpleGenRes[] {oss});
				answer.put(osName, ool);
			}
			
		}
		return answer;
	}
	
	

	protected List<? extends ISimpleGenRes> merge(int objType, List<ISimpleGenRes> list,
			ISimpleGenRes[] extractObject) {
		if (list == null) {
			list = new ArrayList<ISimpleGenRes>();
		}
		if (extractObject == null) {
			return list;
		}
		
		Map<String, ISimpleGenRes> answer = new LinkedHashMap<String, ISimpleGenRes>();
		
		// first add all list elements
		for (ISimpleGenRes sgr: list) {
			String id = getId(objType, sgr);
			if (answer.containsKey(id)) {
				answer.get(id).merge(sgr);
			} else {
				answer.put(id, sgr);
			}
		}
		// then add all vector elments
		for (ISimpleGenRes sgr: extractObject) {
			String id = getId(objType, sgr);
			if (answer.containsKey(id)) {
				answer.get(id).merge(sgr);
			} else {
				answer.put(id, sgr);
			}
			}
		return new ArrayList<ISimpleGenRes>(answer.values());
		}

	protected String getId(int objType, ISimpleGenRes sgr) {
		String answer;
		switch (objType) {
		case IOilObjectList.OSAPPLICATION:
//		case IOilObjectList.MESSAGE:
//		case IOilObjectList.COM:
//		case IOilObjectList.NM:
//		case IOilObjectList.IPDU:
			answer = sgr.getName();
			break;
		default:
			answer = sgr.getPath();
		};
		
		return answer;
	}

	

	/**
	 * ALARM INCREMENT COUNTER CHECK
	 */
	public void checkAlarmIncrementCountCycles(IOilObjectList[] objects) {
        LinkedHashMap<String, ISimpleGenRes> counters = new LinkedHashMap<String, ISimpleGenRes>();
        @SuppressWarnings("unchecked") HashSet<String>[] counters_ool = new HashSet[objects.length];
        for (int i=0; i<counters_ool.length; i++) {
        	counters_ool[i] = new HashSet<String>();
        }

        int i=0;
		for (IOilObjectList ool :  objects) {
			for (ISimpleGenRes curr :  ool.getList(IOilObjectList.COUNTER)) {
				counters.put(curr.getName(), curr);
				counters_ool[i].add(curr.getName());
			}
			i++;
		}
        
        LinkedHashMap<String, ISimpleGenRes> counter_to_alarm = new LinkedHashMap<String, ISimpleGenRes>();
		
        LinkedHashMap<String, ISimpleGenRes> alarm_incr_counter = new LinkedHashMap<String, ISimpleGenRes>();
        i=0;
		for (IOilObjectList ool :  objects) {
			for (ISimpleGenRes curr :  ool.getList(IOilObjectList.ALARM)) {
				final String tipo = curr.getString(ISimpleGenResKeywords.ALARM_ACTION_TYPE);
				if (tipo.equals(ISimpleGenResKeywords.ALARM_INCR_COUNTER)) {
					String coun_Al_Name = curr.getString(ISimpleGenResKeywords.ALARM_COUNTER);
					String counter_al_name = curr.getString(ISimpleGenResKeywords.ALARM_INCR_COUNTER);
					
					if (!counters.containsKey(coun_Al_Name)) {
						throw new RuntimeException(
								"Alarm : Wrong counter name for this Alarm."
										+ " (Alarm = " + curr.getName()
										+ ", counter = " + coun_Al_Name
										+ ")");
					}
					if (!counters_ool[i].contains(coun_Al_Name)) {
						throw new RuntimeException(
								"Alarm : Alarm " + curr.getName()
										+ " requires a remote counter = " + coun_Al_Name
										+ ", but is not supported.");
					}
					if (!counters.containsKey(counter_al_name)) {
						throw new RuntimeException(
								"Alarm : Wrong counter name for this Alarm."
										+ " (Alarm = " + curr.getName()
										+ ", counter = " + counter_al_name
										+ ")");
					}
					
					if (!counters_ool[i].contains(counter_al_name)) {
						throw new RuntimeException(
								"Alarm : Alarm " + curr.getName()
								+ " requires a remote counter = " + coun_Al_Name
								+ ", but this feature is not supported.");
					}
						
					
					counter_to_alarm.put(coun_Al_Name, curr);
					alarm_incr_counter.put(curr.getName(), curr);
				}
			}
			i++;
		}
			
		for (ISimpleGenRes starting_alarm :  alarm_incr_counter.values()) {
			
			String counter = starting_alarm.getString(ISimpleGenResKeywords.ALARM_INCR_COUNTER);
			while (counter_to_alarm.containsKey(counter)) {
				
				ISimpleGenRes alarm = counter_to_alarm.get(counter);
				if (alarm == starting_alarm) {
					throw new RuntimeException(
							"Alarm : Found an increment counter cycle starting from " + starting_alarm.getName());
				}
				
				counter = alarm.getString(ISimpleGenResKeywords.ALARM_INCR_COUNTER);
			}
			
		}
	}
	
	
	/**
	 * This method searchs all Oil Objects of a specific category for a specific
	 * rtos. All valid categories are listed in
	 * {@link OilObjectList OilObjectList}.
	 * 
	 * @param type
	 *            identifies the type of Object
	 * @param rtosPrefix
	 *            identifies the rtos
	 * 
	 * @return all Oil Objects (of given type) for the specific rtos
	 * 
	 * @throws OilCodeWriterException
	 *             throw this exception if there are some problems
	 */
	protected ISimpleGenRes[] extractObject(int type, String rtosPrefix) 
			throws OilCodeWriterException {
		ISimpleGenRes[] answer = new ISimpleGenRes[0];
		String sysName = DataPath.splitPath(rtosPrefix)[0];
		final DataPackage DPKG = DataPackage.eINSTANCE;

		switch (type) {
		/* ----------------------  OS  ---------------------- */
		case IOilObjectList.OS: {
			answer = new SimpleGenRes[] { new SimpleGenRes(
					getVarAsString(rtosPrefix + S
							+ DPKG.getRtos_Name().getName()), rtosPrefix) };
			
			{ // ----------------- CPU type-----------------
				String[] tp = DataPath.splitPath(rtosPrefix);
				String cpuTypePath = tp[0] // System
							+S+ tp[1]		// Architectural
							+S+ tp[2]		// EcuList
							+S+ tp[3]		// Ecu
							+S+ tp[4]		// CpuList
							+S+ tp[5]		// Cpu
							+S+ DPKG.getCpu_Model().getName()		// Cpu_Type
						   ;
				String[] cpuType = CommonUtils.getValue(vt, cpuTypePath);
				if (cpuType!= null && cpuType.length!=0) {
					answer[0].setProperty(ISimpleGenResKeywords.OS_CPU_TYPE, cpuType[0]);
				} else {
					answer[0].setProperty(ISimpleGenResKeywords.OS_CPU_TYPE, "UNKNOW_CPU");
				}
				answer[0].setProperty(ISimpleGenResKeywords.OS_CPU_NAME, tp[5]);
			}
		}
			break;

		/* ----------------------  OS APPLICATION  ---------------------- */
		case IOilObjectList.OSAPPLICATION: {

			ArrayList<SimpleGenRes> tempList = new ArrayList<SimpleGenRes>();
			
			
			String[] split = DataPath.splitPath(rtosPrefix);
			if (!(split == null || split.length <7)) {
				
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
					
					s.setObject(ISimpleGenResKeywords.RTOS_PATH,
							new String[] {rtosPrefix});
					s.setObject(ISimpleGenResKeywords.OS_APPL_PATH,
							new String[] { s.getPath()});
					tempList.add(s);
				}
			}
			answer = tempList.toArray( new SimpleGenRes[tempList.size()] );
		}
			break;

		/* ----------------------  TASK  ---------------------- */
		case IOilObjectList.TASK: {
			String rtosName = getVarAsString(rtosPrefix + S
					+ DataPackage.eINSTANCE.getRtos_Name().getName());
			if (rtosName == null) {
				break;
			}

			/*******************************************************************
			 * Search tasks
			 ******************************************************************/
			// use class TaskSet to search all tasks mapped to current rtos
			TaskSet ts = new TaskSet(vt, sysName);
			ts.setProperty(Task.STR_TASK_TYPE, "", false);
			ts.setProperty(Task.STR_PRIORITY, "", false);
			ts.setProperty(Task.STR_ACT_NUMBER, "", false);
			ts.setProperty(Task.STR_RESOURCE_LIST, "", false);
			
			for (int i = 0; i < ts.getPrefixNumber(); i++) {
				if (rtosName.equals(ts.getPrefix(i))) {

					//answer = new SimpleGenRes[ts.getSize(i)];
					ArrayList<SimpleGenRes> tmpAnswer = new ArrayList<SimpleGenRes>();
					for (int h = 0; h < ts.getSize(i); h++) {
						GenRes current = ts.getItem(i, h);
						
						if (!"task".equalsIgnoreCase(current.getString(Task.STR_TASK_TYPE))) {
							continue; // this element is not a task
						}
						
						SimpleGenRes currentAnswer = new SimpleGenRes(
								current.getName(), current
										.getPath());
						tmpAnswer.add(currentAnswer);
						
						// take also ....
						
						// ----------- PRIORITY ------------
						if (current.existProperty("priority")) {
							Object ttt = current.getProperty("priority");

							if (isAValidInteger(ttt)) {
								currentAnswer.setProperty(ISimpleGenResKeywords.TASK_PRIORITY, "" + ttt);
							} else {
								if(! checkKeyword(IWritersKeywords.HR))
								throw new OilCodeWriterException("Not found or not valid value for task "+ current.getName() + "'s priority");
							}
						}
						// ----------- ACTIVATION ------------
						if (current.existProperty("ActNumber")) {
							Object ttt = current.getProperty("ActNumber");

							if (ttt == null || (""+ttt).length() == 0) {
								// TODO: USE DEFAULT VALUE !!!!!!!!!
								currentAnswer.setProperty(ISimpleGenResKeywords.TASK_ACTIVATION, "" + 1);
							} else if (isAValidInteger(ttt)) {
								currentAnswer.setProperty(ISimpleGenResKeywords.TASK_ACTIVATION, "" + ttt);
							} else {
								throw new OilCodeWriterException("Not found or not valid value for task "+ current.getName() + "'s priority's property");
							}
						}
						// ----------- RESOURCE ------------
						if (current.existProperty("Resource")) {
							Object ttt = current.getCollection("Resource");
							if (ttt!=null) {
								currentAnswer.setObject(ISimpleGenResKeywords.TASK_RESOURCE_LIST, ttt);
							}
						}
					}
					
					answer = tmpAnswer.toArray( new SimpleGenRes[tmpAnswer.size()] );
					break;
				}
			}
			
			/*******************************************************************
			 * Take values from varTree (inside the oilVar)
			 ******************************************************************/
			
			// 1) Search inside the OilVar:
			//    Priority, Activation, Schedule, Event, Autostart, Resource
			// 2) if found, store them inside the rigth SimpleGenRes
			for (int i=0; i< answer.length; i++) {
				// common data
				final String path = answer[i].getPath() +S+ (new OilPath(OilObjectType.TASK, null)).getPath();
				String[] values;
				String chType;
				/*
				{ // ----------- PRIORITY ------------
					values = CommonUtils.getValue(vt, path +"PRIORITY");
					if (values!= null && values.length == 1) {
						//answer[i].setProperty(SimpleGenResKeywords.TASK_PRIORITY, values[0]);
					} else {
						throw new OilCodeWriterException("Required the priority of task " + answer[i].getName());
					}
				}
				
				{ // ----------- ACTIVATION ------------
					values = CommonUtils.getValue(vt, path+"ACTIVATION");
					if (values!= null && values.length == 1) {
						answer[i].setProperty(SimpleGenResKeywords.TASK_ACTIVATION, values[0]);
					}
				}*/
				
				{	// ----------- SCHEDULE ------------
					chType = CommonUtils.getFirstChildEnumType(vt, path+"SCHEDULE");
					if (chType!= null) {
						answer[i].setProperty(ISimpleGenResKeywords.TASK_SCHEDULE, chType);
					} else {
						answer[i].setProperty(ISimpleGenResKeywords.TASK_SCHEDULE, "");
					}
				}
				
				{	// ----------- EVENT & TASK_EXTENDED ------------
					boolean extended = false;
					values = CommonUtils.getValue(vt, path+"EVENT");
					if (values!= null && values.length > 0) {
						answer[i].setObject(ISimpleGenResKeywords.TASK_EVENT_LIST, Arrays.asList(values));
						extended = true;
					}
					answer[i].setProperty(ISimpleGenResKeywords.TASK_EXTENDED, ""+extended);
				}
				
				{	// ----------- AUTOSTART ------------
					String[] chName = new String[1]; 
					chType = CommonUtils.getFirstChildEnumType(vt, path+"AUTOSTART", chName);
					if ("true".equalsIgnoreCase(chType)) {
						
						values = CommonUtils.getValue(vt, path+"AUTOSTART"+CommonUtils.VARIANT_ELIST+chName[0]+CommonUtils.PARAMETER_LIST+"APPMODE");
						
						if (values!= null && values.length > 0) {
							answer[i].setObject(ISimpleGenResKeywords.TASK_APPMODES_LIST, Arrays.asList(values));
						} else {
							// store an empty list 
							answer[i].setObject(ISimpleGenResKeywords.TASK_APPMODES_LIST, new ArrayList<String>());
						}
					} else {
						// don't store anything
					}
				}
				
				/*{ // ----------- RESOURCES ------------
					values = CommonUtils.getValue(vt, path+"RESOURCE");
					if (values!= null && values.length > 0) {
						answer[i].setObject(SimpleGenResKeywords.TASK_RESOURCE_LIST, Arrays.asList(values));
					}
				}*/
				{ // ----------- Accessing OS Applications ------------
					values = CommonUtils.getValue(vt, path+"ACCESSING_APPLICATION");
					if (values!= null && values.length > 0) {
						answer[i].setObject(ISimpleGenResKeywords.TASK_ACCESSING_OS_APPL_LIST, Arrays.asList(values));
					}
				}
				
				{ // ----------- timing protection ------------
					String[] chName = new String[1]; 
					chType = CommonUtils.getFirstChildEnumType(vt, path+"TIMING_PROTECTION", chName);
					if ("true".equalsIgnoreCase(chType)) {
						String tp_path = path+"TIMING_PROTECTION"+CommonUtils.VARIANT_ELIST+chName[0]+CommonUtils.PARAMETER_LIST;
						answer[i].setObject(ISimpleGenResKeywords.TASK_TIMING_PROTECTION, "true");
						
						values = CommonUtils.getValue(vt, tp_path+"MAXALLINTERRUPTLOCKTIME");
						if (values!= null && values.length > 0) {
							answer[i].setObject(ISimpleGenResKeywords.TASK_TIMING_PROTECTION_MAX_INT, values[0]);
						}
						
						values = CommonUtils.getValue(vt, tp_path+"EXECUTIONBUDGET");
						if (values!= null && values.length > 0) {
							answer[i].setObject(ISimpleGenResKeywords.TASK_TIMING_PROTECTION_BUDGET, values[0]);
						}
						
						values = CommonUtils.getValue(vt, tp_path+"MAXOSINTERRUPTLOCKTIME");
						if (values!= null && values.length > 0) {
							answer[i].setObject(ISimpleGenResKeywords.TASK_TIMING_PROTECTION_MAX_OS, values[0]);
						}
						
						values = CommonUtils.getValue(vt, tp_path+"TIMEFRAME");
						if (values!= null && values.length > 0) {
							answer[i].setObject(ISimpleGenResKeywords.TASK_TIMING_PROTECTION_FRAME, values[0]);
						}
						
						ArrayList<String> resEnums = new ArrayList<String>(); 
						ArrayList<String> resTypes = CommonUtils.getAllChildrenEnumType(vt, tp_path+"RESOURCE", resEnums);
						ArrayList<String[]> resourceLocks = new ArrayList<String[]>();
						for (int ri=0; ri<resTypes.size(); ri++) {
							if ("RESOURCELOCK".equalsIgnoreCase(resTypes.get(ri))) {
								String[] resourceLock = new String[2];
								values = CommonUtils.getValue(vt, tp_path+S+"RESOURCE"+S+resEnums.get(ri)+S+"RESOURCELOCKTIME");
								if (values!= null && values.length > 0) {
									resourceLock[1] = values[0];
								}
								
								values = CommonUtils.getValue(vt, tp_path+S+"RESOURCE"+S+resEnums.get(ri)+S+"RESOURCE");
								if (values!= null && values.length > 0) {
									resourceLock[0] = values[0];
								}
								
								if (resourceLock[0] != null && resourceLock[0] != "" && resourceLock[1] != null && resourceLock[1] != "") {
									resourceLocks.add(resourceLock);
								}
							}
						}
						answer[i].setObject(ISimpleGenResKeywords.TASK_TIMING_PROTECTION_RESLOCK, resourceLocks);
					}
				}
				
			}
		}
			break;
			/* ----------------------  ISR   ---------------------- */
		case IOilObjectList.ISR: {
			String rtosName = getVarAsString(rtosPrefix + S
					+ DataPackage.eINSTANCE.getRtos_Name().getName());
			if (rtosName == null) {
				break;
			}

			/*******************************************************************
			 * Search tasks
			 ******************************************************************/
			
			// use class TaskSet to search all tasks mapped to current rtos
			TaskSet ts = new TaskSet(vt, sysName);
			ts.setProperty(Task.STR_TASK_TYPE, "", false);
			ts.setProperty(Task.STR_RESOURCE_LIST, "", false);
			
			for (int i = 0; i < ts.getPrefixNumber(); i++) {
				if (rtosName.equals(ts.getPrefix(i))) {

					//answer = new SimpleGenRes[ts.getSize(i)];
					ArrayList<SimpleGenRes> tmpAnswer = new ArrayList<SimpleGenRes>();
					for (int h = 0; h < ts.getSize(i); h++) {
						GenRes current = ts.getItem(i, h);
						
						if (!"isr".equalsIgnoreCase(current.getString(Task.STR_TASK_TYPE))) {
							continue; // this element is not an isr
						}
						
						SimpleGenRes currentAnswer = new SimpleGenRes(
								current.getName(), current
										.getPath());
						tmpAnswer.add(currentAnswer);
						
						// take also ....

						// ----------- RESOURCE ------------
						if (current.existProperty("Resource")) {
							Object ttt = current.getCollection("Resource");
							if (ttt!=null) {
								currentAnswer.setObject(ISimpleGenResKeywords.TASK_RESOURCE_LIST, ttt);
							}
						}
						
					}
					
					answer = tmpAnswer.toArray( new SimpleGenRes[tmpAnswer.size()] );
					break;
				}
			}
			
			/*******************************************************************
			 * Take values from varTree (inside the oilVar)
			 ******************************************************************/
			
			// 1) Search inside the OilVar:
			//    Priority, Activation, Schedule, Event, Autostart, Resource
			// 2) if found, store them inside the rigth SimpleGenRes
			for (int i=0; i< answer.length; i++) {
				// common data
				String path = answer[i].getPath() +S+ (new OilPath(OilObjectType.ISR, null)).getPath();
				String[] values;

				{	// ----------- TRAP ------------
					String value = CommonUtils.getFirstChildEnumType(vt, path+"TRAP");
					if ("TRUE".equalsIgnoreCase(value)) {
						answer[i].setObject(ISimpleGenResKeywords.ISR_TRAP, Boolean.TRUE);
//					} else {
//						answer[i].setProperty(ISimpleGenResKeywords.ISR_ENTRY, "");
					}
				}

				{	// ----------- CATEGORY ------------
					values = CommonUtils.getValue(vt, path+"CATEGORY");
					if (values!= null && values.length >0) {
						answer[i].setProperty(ISimpleGenResKeywords.ISR_CATEGORY, values[0]);
//					} else {
//						answer[i].setProperty(ISimpleGenResKeywords.ISR_CATEGORY, "");
					}
				}
				{	// ----------- PRIORITY ------------
					values = CommonUtils.getValue(vt, path+"PRIORITY");
					if (values!= null && values.length >0) {
						answer[i].setProperty(ISimpleGenResKeywords.ISR_USER_PRIORITY, values[0]);
//					} else {
//						answer[i].setProperty(ISimpleGenResKeywords.ISR_PRIORITY, "");
					}
				}
				{	// ----------- ENTRY ------------
					values = CommonUtils.getValue(vt, path+"ENTRY");
					if (values!= null && values.length >0) {
						answer[i].setProperty(ISimpleGenResKeywords.ISR_ENTRY, values[0]);
//					} else {
//						answer[i].setProperty(ISimpleGenResKeywords.ISR_ENTRY, "");
					}
				}
				{	// ----------- LEVEL ------------
					values = CommonUtils.getValue(vt, path+"LEVEL");
					if (values!= null && values.length >0) {
						answer[i].setProperty(ISimpleGenResKeywords.ISR_LEVEL, values[0]);
//					} else {
//						answer[i].setProperty(ISimpleGenResKeywords.ISR_ENTRY, "");
					}
				}
				{	// ----------- HANDLER ------------
					values = CommonUtils.getValue(vt, path+"HANDLER");
					if (values!= null && values.length >0) {
						answer[i].setProperty(ISimpleGenResKeywords.ISR_HANDLER, values[0]);
					} else {
						answer[i].setProperty(ISimpleGenResKeywords.ISR_HANDLER, answer[i].getName());
					}
				}
				if (answer[i].containsProperty(ISimpleGenResKeywords.ISR_ENTRY) && answer[i].containsProperty(ISimpleGenResKeywords.ISR_LEVEL)) {
					Messages.sendWarningNl("ISR " + answer[i].getName() + " contains both ENTRY and LEVEL attributes.");
				}
				
				{ // ----------- Accessing OS Applications ------------
					values = CommonUtils.getValue(vt, path+"ACCESSING_APPLICATION");
					if (values!= null && values.length > 0) {
						answer[i].setObject(ISimpleGenResKeywords.ISR_ACCESSING_OS_APPL_LIST, Arrays.asList(values));
					}
				}
				
				{ // ----------- timing protection ------------
					String[] chName = new String[1]; 
					String chType = CommonUtils.getFirstChildEnumType(vt, path+"TIMING_PROTECTION", chName);
					if ("true".equalsIgnoreCase(chType)) {
						String tp_path = path+"TIMING_PROTECTION"+CommonUtils.VARIANT_ELIST+chName[0]+CommonUtils.PARAMETER_LIST;
						answer[i].setObject(ISimpleGenResKeywords.ISR_TIMING_PROTECTION, "true");
						
						values = CommonUtils.getValue(vt, tp_path+"MAXALLINTERRUPTLOCKTIME");
						if (values!= null && values.length > 0) {
							answer[i].setObject(ISimpleGenResKeywords.ISR_TIMING_PROTECTION_MAX_INT, values[0]);
						}
						
						values = CommonUtils.getValue(vt, tp_path+"EXECUTIONTIME");
						if (values!= null && values.length > 0) {
							answer[i].setObject(ISimpleGenResKeywords.ISR_TIMING_PROTECTION_BUDGET, values[0]);
						}
						
						values = CommonUtils.getValue(vt, tp_path+"MAXOSINTERRUPTLOCKTIME");
						if (values!= null && values.length > 0) {
							answer[i].setObject(ISimpleGenResKeywords.ISR_TIMING_PROTECTION_MAX_OS, values[0]);
						}
						
						values = CommonUtils.getValue(vt, tp_path+"TIMEFRAME");
						if (values!= null && values.length > 0) {
							answer[i].setObject(ISimpleGenResKeywords.ISR_TIMING_PROTECTION_FRAME, values[0]);
						}
						
						ArrayList<String> resEnums = new ArrayList<String>(); 
						ArrayList<String> resTypes = CommonUtils.getAllChildrenEnumType(vt, tp_path+"RESOURCE", resEnums);
						ArrayList<String[]> resourceLocks = new ArrayList<String[]>();
						for (int ri=0; ri<resTypes.size(); ri++) {
							if ("LOCKINGTIME".equalsIgnoreCase(resTypes.get(ri))) {
								String[] resourceLock = new String[2];
								values = CommonUtils.getValue(vt, tp_path+S+"RESOURCE"+S+resEnums.get(ri)+S+"MAXRESOURCELOCKTIME");
								if (values!= null && values.length > 0) {
									resourceLock[1] = values[0];
								}
								
								values = CommonUtils.getValue(vt, tp_path+S+"RESOURCE"+S+resEnums.get(ri)+S+"RESOURCE");
								if (values!= null && values.length > 0) {
									resourceLock[0] = values[0];
								}
								
								if (resourceLock[0] != null && resourceLock[0] != "" && resourceLock[1] != null && resourceLock[1] != "") {
									resourceLocks.add(resourceLock);
								}
							}
						}
						answer[i].setObject(ISimpleGenResKeywords.ISR_TIMING_PROTECTION_RESLOCK, resourceLocks);
					}
				}
			}
		}
			break;
		/* ----------------------  ALARM - COUNTER - EVENT  ---------------------- */
		case IOilObjectList.COUNTER:
		case IOilObjectList.ALARM:
		case IOilObjectList.EVENT:
		{
			String signalPath = sysName+S+DPKG.getSystem_Architectural().getName()+S
    			+DPKG.getArchitectural_SignalList().getName();
			ITreeInterface ti = vt.newTreeInterface();
	        String[] signalNames = ti.getAllName(signalPath,DPKG.getSignal().getName());
	        ArrayList<ISimpleGenRes> tmpAnswer = new ArrayList<ISimpleGenRes>(); // use a dynamic list to store all object
	        
	        // choose the type (as String) of current OilObjectList
	        String requiredType = null;
	        switch (type) {
				case IOilObjectList.COUNTER: requiredType = IOilXMLLabels.OBJ_COUNTER; break;
				case IOilObjectList.ALARM:   requiredType = IOilXMLLabels.OBJ_ALARM; break;
				case IOilObjectList.EVENT:   requiredType = IOilXMLLabels.OBJ_EVENT; break;
	        }
	        
	        // Look at all objects and extract only objects with the rigth type
	        // For selected objects, search and store theirs properties
	        for (int i=0; i<signalNames.length; i++) {
	        	String tmpPath = signalPath +S+signalNames[i]+S;
	        	
	        	// .. check object type ..
	        	IVariable var = ti.getValue(tmpPath+DPKG.getSignal_Type().getName());
	        	if (var != null && requiredType.equals(var.toString())) {
	        	
	        		ISimpleGenRes sgr = new SimpleGenRes(
							signalNames[i], tmpPath); 
					tmpAnswer.add(sgr);

					// each object type has differents properties. Select the correct group
					String[][] requiredValues = new String[0][0];
					if (type == IOilObjectList.COUNTER) {
						/////////////          COUNTER          /////////////
						
						requiredValues = new String[][] {
								{ "MAXALLOWEDVALUE", ISimpleGenResKeywords.COUNTER_MAX_ALLOWED},
								{ "MINCYCLE", ISimpleGenResKeywords.COUNTER_MIN_CYCLE},
								{ "TICKSPERBASE", ISimpleGenResKeywords.COUNTER_TICKS}
						};
						
					} else if (type == IOilObjectList.EVENT) {
						/////////////          EVENT          /////////////
						
						requiredValues = new String[][] {
								{ "MASK", ISimpleGenResKeywords.EVENT_MASK}
						};

					} else if (type == IOilObjectList.ALARM) {
						/////////////          ALARM          /////////////

						requiredValues = new String[][] {
								{ "COUNTER", ISimpleGenResKeywords.ALARM_COUNTER}
						};
						
						{ // take ALARM ACTION
							final String basePath = tmpPath
									+ (new OilPath(OilObjectType.get(requiredType), signalNames[i])).getPath()
									+"ACTION";
							
							final String str_ACTION_ACTIVATE_TASK = "ACTIVATETASK";
							final String str_ACTION_SET_EVENT = "SETEVENT";
							final String str_ACTION_ALARM_CALL_BACK = "ALARMCALLBACK";
							final String str_ACTION_ALARM_INCR_COUNTER = "INCREMENTCOUNTER";
							
							final String str_ACTIVATE_TASK_TASK = "TASK";
							
							final String str_SET_EVENT_TASK = "TASK";
							final String str_SET_EVENT_EVENT = "EVENT";
							
							final String str_ALARM_CALL_BACK_NAME = "ALARMCALLBACKNAME";
							
							final String str_ALARM_COUNTER_NAME = "COUNTER";

							String[] childName = new String[1];
							String tmpType = CommonUtils.getFirstChildEnumType(vt, basePath, childName);
							
							if (str_ACTION_ACTIVATE_TASK.equalsIgnoreCase(tmpType)) { // ACTIVATE TASK
								final String taskName;
								String path = basePath + CommonUtils.VARIANT_ELIST+childName[0]+CommonUtils.PARAMETER_LIST;
								
								// TASK
								String[] val = CommonUtils.getValue(vt, path+str_ACTIVATE_TASK_TASK);
								if (val != null && val.length>0 && val[0] != null) {
									taskName = val[0];
								} else {
									throw new OilCodeWriterException("Required " + 
											str_ACTION_ACTIVATE_TASK + "/"+str_ACTIVATE_TASK_TASK 
											+ " for alarm " + sgr.getName());
								}
	
								sgr.setObject(ISimpleGenResKeywords.ALARM_ACTIVATE_TASK, taskName);
								sgr.setProperty(ISimpleGenResKeywords.ALARM_ACTION_TYPE,
										ISimpleGenResKeywords.ALARM_ACTIVATE_TASK);

							} else if (str_ACTION_SET_EVENT.equalsIgnoreCase(tmpType)) { // SET EVENT
								final String taskName;
								final String eventName;
								
								String path = basePath + CommonUtils.VARIANT_ELIST+childName[0]+CommonUtils.PARAMETER_LIST;
								
								// TASK
								String[] val = CommonUtils.getValue(vt, path+str_SET_EVENT_TASK);
								if (val != null && val.length>0 && val[0] != null) {
									taskName = val[0];
								} else {
									throw new OilCodeWriterException("Required " + 
											str_ACTION_SET_EVENT + "/"+str_SET_EVENT_TASK 
											+ " for alarm " + sgr.getName());
								}
								
								// EVENT
								val = CommonUtils.getValue(vt, path+str_SET_EVENT_EVENT);
								if (val != null && val.length>0 && val[0] != null) {
									eventName = val[0];
								} else {
									throw new OilCodeWriterException("Required " + 
											str_ACTION_SET_EVENT + "/"+str_SET_EVENT_EVENT 
											+ " for alarm " + sgr.getName());
								}
	
								sgr.setObject(ISimpleGenResKeywords.ALARM_SET_EVENT, new String[] {taskName, eventName});
								sgr.setProperty(ISimpleGenResKeywords.ALARM_ACTION_TYPE,
										ISimpleGenResKeywords.ALARM_SET_EVENT);

							} else if (str_ACTION_ALARM_CALL_BACK.equalsIgnoreCase(tmpType)) { // ALARM CALL BACK
								final String callBackName;
								
								String path = basePath + CommonUtils.VARIANT_ELIST+childName[0]+CommonUtils.PARAMETER_LIST;
								
								// TASK
								String[] val = CommonUtils.getValue(vt, path+str_ALARM_CALL_BACK_NAME);
								if (val != null && val.length>0 && val[0] != null) {
									callBackName = val[0];
								} else {
									throw new OilCodeWriterException("Required " + 
											str_ACTION_ALARM_CALL_BACK + "/"+str_ALARM_CALL_BACK_NAME 
											+ " for alarm " + sgr.getName());
								}
	
								sgr.setObject(ISimpleGenResKeywords.ALARM_CALL_BACK, callBackName);
								sgr.setProperty(ISimpleGenResKeywords.ALARM_ACTION_TYPE,
										ISimpleGenResKeywords.ALARM_CALL_BACK);

							} else if (str_ACTION_ALARM_INCR_COUNTER.equalsIgnoreCase(tmpType)) { // INCREMENT COUNTER
								final String counterName;
								
								String path = basePath + CommonUtils.VARIANT_ELIST+childName[0]+CommonUtils.PARAMETER_LIST;
								
								// Counter
								String[] val = CommonUtils.getValue(vt, path+str_ALARM_COUNTER_NAME);
								if (val != null && val.length>0 && val[0] != null) {
									counterName = val[0];
								} else {
									throw new OilCodeWriterException("Required " + 
											str_ACTION_ALARM_INCR_COUNTER + "/"+str_ALARM_COUNTER_NAME 
											+ " for alarm " + sgr.getName());
								}
	
								sgr.setObject(ISimpleGenResKeywords.ALARM_INCR_COUNTER, counterName);
								sgr.setProperty(ISimpleGenResKeywords.ALARM_ACTION_TYPE,
										ISimpleGenResKeywords.ALARM_INCR_COUNTER);

							} else {

								throw new OilCodeWriterException("Expected one of "
										+ str_ACTION_ACTIVATE_TASK +", "
										+ str_ACTION_SET_EVENT + " and "
										+ str_ACTION_ALARM_CALL_BACK
										+ " as action of alarm " + sgr.getName());
							}
							

						}

						
						{ // take ALARM AUTOSTART
							String path = tmpPath
									+ (new OilPath(OilObjectType.get(requiredType), signalNames[i])).getPath()
									+"AUTOSTART";
							String[] childName = new String[1];
							String tmpType = CommonUtils.getFirstChildEnumType(vt, path, childName);
							if ("true".equalsIgnoreCase(tmpType)) {
								String[] modes = null;
								long alarmTime =0;
								long cycleTime =0;
								
								path +=CommonUtils.VARIANT_ELIST+childName[0]+CommonUtils.PARAMETER_LIST;
								
								// APPMODE
								String[] val = CommonUtils.getValue(vt, path+"APPMODE");
								if (val != null) {
									modes = val;
								}
								
								// ALARMTIME
								val = CommonUtils.getValue(vt, path+"ALARMTIME");
								if (val != null) {
									try {
										alarmTime = Long.decode(val[0]).longValue();
									} catch (NumberFormatException e) {
										throw new OilCodeWriterException("The ALARMTIME parameter of ALARM "
												+ sgr.getName()+" contains a not valid number : "+val[0]);
									}
								}
	
								// CYCLETIME
								val = CommonUtils.getValue(vt, path+"CYCLETIME");
								if (val != null) {
									try {
										cycleTime = Long.decode(val[0]).longValue();
									} catch (NumberFormatException e) {
										throw new OilCodeWriterException("The CYCLETIME parameter of ALARM "
												+ sgr.getName()+" contains a not valid number : "+val[0]);
									}
								}
	
								AlarmAutoStartDescr aasd = new AlarmAutoStartDescr(modes, alarmTime, cycleTime);
								sgr.setObject(ISimpleGenResKeywords.ALARM_AUTOSTART, aasd);
								
								
							} else if ("false".equalsIgnoreCase(tmpType)) {
								String[] modes = null;
								long alarmTime =0;
								long cycleTime =0;
								
								path +=CommonUtils.VARIANT_ELIST+childName[0]+CommonUtils.PARAMETER_LIST;
																
								// ALARMTIME
								String[] val = val = CommonUtils.getValue(vt, path+"ALARMTIME");
								if (val != null) {
									try {
										alarmTime = Long.decode(val[0]).longValue();
									} catch (NumberFormatException e) {
										throw new OilCodeWriterException("The ALARMTIME parameter of ALARM "
												+ sgr.getName()+" contains a not valid number : "+val[0]);
									}
								}
	
								// CYCLETIME
								val = CommonUtils.getValue(vt, path+"CYCLETIME");
								if (val != null) {
									try {
										cycleTime = Long.decode(val[0]).longValue();
									} catch (NumberFormatException e) {
										throw new OilCodeWriterException("The CYCLETIME parameter of ALARM "
												+ sgr.getName()+" contains a not valid number : "+val[0]);
									}
								}
	
								AlarmAutoStartDescr aasd = new AlarmAutoStartDescr(modes, alarmTime, cycleTime);
								sgr.setObject(ISimpleGenResKeywords.ALARM_INIT, aasd);
							}
						} 
					}
					
					// ... search proprerties inside the OilVar and store them as properties (if found) ...
					for (int vi=0; vi<requiredValues.length; vi++) {
						String tt = tmpPath
								+ (new OilPath(OilObjectType.get(requiredType), signalNames[i])).getPath()
								+requiredValues[vi][0];
						String[] value = CommonUtils.getValue(vt, tt);
						if (value!=null && value.length>0) {
							sgr.setProperty(requiredValues[vi][1], value[0]);
						}

					}
					
					if (type == IOilObjectList.ALARM || type == IOilObjectList.COUNTER) { // ----------- Accessing OS Applications ------------
						String path = tmpPath
								+ (new OilPath(OilObjectType.get(requiredType), signalNames[i])).getPath();
						String[] values = CommonUtils.getValue(vt, path+"ACCESSING_APPLICATION");
						if (values!= null && values.length > 0) {
							sgr.setObject(
									(type == IOilObjectList.ALARM ? ISimpleGenResKeywords.ALARM_ACCESSING_OS_APPL_LIST : ISimpleGenResKeywords.COUNTER_ACCESSING_OS_APPL_LIST )
									, Arrays.asList(values));
						}
					}
	        	}
	        }
	        
	        if (type == IOilObjectList.EVENT) {
	        	Collections.sort(tmpAnswer, new Comparator<ISimpleGenRes>() {
	        		/* (non-Javadoc)
	        		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	        		 */
	        		@Override
	        		public int compare(ISimpleGenRes o1, ISimpleGenRes o2) {
	        			final int answer;
	        			if (o1 == null || o1.getName() == null) {
	        				if (o2 == null || o2.getName() == null) {
	        					answer = 0;
	        				} else {
	        					answer = Integer.MIN_VALUE; 
	        				}
	        			} else {
	        				if (o2 == null || o2.getName() == null) {
	        					answer = Integer.MIN_VALUE; 
	        				} else {
	        					answer = o1.getName().compareTo(o2.getName()); 
	        				}
	        			}
	        			return answer;
	        		}
				});
	        }
	        
	        // convert the answer 
	        if (tmpAnswer.size()>0) {
	        	answer = tmpAnswer.toArray(new SimpleGenRes[tmpAnswer.size()]);
	        }
	        
	        
		}
			break;
		
		/* ----------------------  SPINLOCK  ---------------------- */
		case IOilObjectList.SPINLOCK:
		{
			String resPath = sysName+S+DPKG.getSystem_Architectural().getName()+S
    			+SimpleTransform.SPIN_LOCK_LIST;
			
			// search all Architectural SpinLocks ...
	        String[] resNames = vt.newTreeInterface().getAllName(resPath,SimpleTransform.SPIN_LOCK);
	        if (resNames.length>0) {
				answer = new SimpleGenRes[resNames.length];

				// ... and store as SimpleGenRes 
		        for (int i=0; i<resNames.length; i++) {
					answer[i] = new SimpleGenRes(
							resNames[i], resPath+S+resNames[i]+S);
					
					String path = answer[i].getPath() +S+ (new OilPath(OilObjectType.SPINLOCK, null)).getPath();
					String[] values;

					{	// ----------- NEXT_SPINLOCK ------------
						values = CommonUtils.getValue(vt, path+"NEXT_SPINLOCK");
						if (values != null && values.length>0 && values[0] != null) {
							answer[i].setObject(ISimpleGenResKeywords.SPINLOCK_NEXT, values[0]);
						}
					}
					{	// ----------- ACCESSING_APPLICATION ------------
						values = CommonUtils.getValue(vt, path+"ACCESSING_APPLICATION");
						if (values != null) {
							answer[i].setObject(ISimpleGenResKeywords.SPINLOCK_ACCESSING_OS_APPL_LIST, Arrays.asList(values));
						}
					}

		        }
	        }
	        
	        
		}
			break;
			/* ----------------------  SCHEDULE TABLE  ---------------------- */
		case IOilObjectList.SCHEDULE_TABLE:
		{
			String rtosName = getVarAsString(rtosPrefix + S
					+ DataPackage.eINSTANCE.getRtos_Name().getName());
			if (rtosName == null) {
				break;
			}
			
			String resPath = sysName+S+DPKG.getSystem_Architectural().getName()+S
    			+SimpleTransform.SCHED_TABLE_LIST;
			
			// search all Architectural Schedule table ...
	        String[] resNames = vt.newTreeInterface().getAllName(resPath,SimpleTransform.SCHED_TABLE);
	        if (resNames.length>0) {
	        	
				answer = new SimpleGenRes[resNames.length];

				// ... and store as SimpleGenRes 
		        for (int i=0; i<resNames.length; i++) {
					answer[i] = new SimpleGenRes(
							resNames[i], resPath+S+resNames[i]+S);
					
					String path = answer[i].getPath() +S+ (new OilPath(OilObjectType.SCHEDULETABLE, null)).getPath();
					String[] values;

					{	// ----------- CPU_ID ------------
						values = CommonUtils.getValue(vt, path+"CPU_ID");
						if (values != null && values.length>0 && values[0] != null) {
							
							answer[i].setObject(ISimpleGenResKeywords.SCHEDTABLE_DURATION, values[0]);
						}
					}

					{	// ----------- DURATION ------------
						values = CommonUtils.getValue(vt, path+"DURATION");
						if (values != null && values.length>0 && values[0] != null) {
							answer[i].setObject(ISimpleGenResKeywords.SCHEDTABLE_DURATION, values[0]);
						}
					}
					{	// ----------- REPEATING ------------
						String enumType = CommonUtils.getFirstChildEnumType(vt, path+"REPEATING");
						answer[i].setObject(ISimpleGenResKeywords.SCHEDTABLE_REPEATING, "TRUE".equalsIgnoreCase(enumType) ? "TRUE" : "FALSE");
					}
					{	// ----------- COUNTER ------------
						values = CommonUtils.getValue(vt, path+"COUNTER");
						if (values != null) {
							answer[i].setObject(ISimpleGenResKeywords.SCHEDULING_COUNTER, values[0]);
						}
					}
					{	// ----------- ACCESSING_APPLICATION ------------
						values = CommonUtils.getValue(vt, path+"ACCESSING_APPLICATION");
						if (values != null) {
							answer[i].setObject(ISimpleGenResKeywords.SCHEDTABLE_ACCESSING_OS_APPL_LIST, Arrays.asList(values));
						}
					}
					
					{	// ----------- AUTOSTART ------------
						String[] chName = new String[1];
						String localPath = path+"AUTOSTART";
						String chType = CommonUtils.getFirstChildEnumType(vt, localPath, chName);
						if ("true".equalsIgnoreCase(chType)) {
							localPath += CommonUtils.VARIANT_ELIST+chName[0]+CommonUtils.PARAMETER_LIST;
							
							values = CommonUtils.getValue(vt, localPath+"APPMODE");
							
							if (values!= null && values.length > 0) {
								answer[i].setObject(ISimpleGenResKeywords.SCHEDTABLE_AUTOSTART_APPMODES_LIST, Arrays.asList(values));
							} else {
								// store an empty list 
								answer[i].setObject(ISimpleGenResKeywords.SCHEDTABLE_AUTOSTART_APPMODES_LIST, new ArrayList<String>());
							}
							
							values = CommonUtils.getValue(vt, localPath+"START_VALUE");
							if (values != null && values.length>0 && values[0] != null) {
								answer[i].setObject(ISimpleGenResKeywords.SCHEDTABLE_AUTOSTART_START_VALUE, values[0]);
							}
							
							String enumType = CommonUtils.getFirstChildEnumType(vt, localPath+"TYPE");
							String tmp = ISimpleGenResKeywords.SCHEDTABLE_AUTOSTART_TYPE_ABSOLUTE;
							if (ISimpleGenResKeywords.SCHEDTABLE_AUTOSTART_TYPE_RELATIVE.equalsIgnoreCase(enumType)) tmp = ISimpleGenResKeywords.SCHEDTABLE_AUTOSTART_TYPE_RELATIVE;
							else if (ISimpleGenResKeywords.SCHEDTABLE_AUTOSTART_TYPE_SYNCHRON.equalsIgnoreCase(enumType)) tmp = ISimpleGenResKeywords.SCHEDTABLE_AUTOSTART_TYPE_SYNCHRON;
							answer[i].setObject(ISimpleGenResKeywords.SCHEDTABLE_AUTOSTART_TYPE, tmp);

						} else {
							// don't store anything
						}
					}

		        }
	        }
	        
	        
		}
			break;
		/* ----------------------  RESOURCE  ---------------------- */
		case IOilObjectList.RESOURCE:
		if (false) {
			String resPath = sysName+S+DPKG.getSystem_Architectural().getName()+S
    			+DPKG.getArchitectural_MutexList().getName();
			
			// search all Architectural Mutex ...
	        String[] resNames = vt.newTreeInterface().getAllName(resPath,DPKG.getMutex().getName());
	        if (resNames.length>0) {
				answer = new SimpleGenRes[resNames.length];

				// ... and store as SimpleGenRes 
		        for (int i=0; i<resNames.length; i++) {
					answer[i] = new SimpleGenRes(
							resNames[i], resPath+S+resNames[i]+S);
		        }
	        }
		}
			break;

		/* ----------------------  APPMODE  ---------------------- */
		case IOilObjectList.APPMODE:
		{
			String modesPath = sysName+S+DPKG.getSystem_Modes().getName()+S+DPKG.getModes_ModeList().getName();

			// search all Modes ...
	        String[] modesNames = vt.newTreeInterface().getAllName(modesPath,DPKG.getMode().getName());
	        if (modesNames.length>0) {
				answer = new SimpleGenRes[modesNames.length];

				// ... and store as SimpleGenRes 
		        for (int i=0; i<modesNames.length; i++) {
					answer[i] = new SimpleGenRes(
							modesNames[i], modesPath+S+modesNames[i]+S);
		        }
	        }
		}
			break;
		/* ----------------------  MESSAGES  ---------------------- */
		case IOilObjectList.MESSAGE:
		case IOilObjectList.NETWORKMESSAGE:
		{
			final String sizeType = S + DPKG.getFrame_Length().getName();
			final String prefix = sysName + S + DPKG.getArchitectural().getName() + S
					+ DPKG.getArchitectural_FrameList().getName() + S;
			ITreeInterface ti = vt.newTreeInterface();
			final String[] names = ti.getAllName(prefix, DPKG.getFrame().getName());

			ArrayList<ISimpleGenRes> temp = new ArrayList<ISimpleGenRes>();
			for (int i = 0; i < names.length; i++) {
				String curr_type;
				{
					// default type = message.
					IVariable msgtype = ti.getValue(prefix + names[i] +S+ MESSAGE_TYPE);
					if (type == IOilObjectList.NETWORKMESSAGE) {
						
						if (!(IOilXMLLabels.OBJ_NETWORKMESSAGE.equalsIgnoreCase("" + msgtype))) {
							continue;
						}
						curr_type = IOilXMLLabels.OBJ_NETWORKMESSAGE;
					} else {
						curr_type = IOilXMLLabels.OBJ_MESSAGE;
					}
				}
				
				ISimpleGenRes curr = new SimpleGenRes(names[i], prefix + names[i]);
				curr.setProperty(IOilXMLLabels.ATTR_TYPE, curr_type);

				try {
					IVariable size = ti.getValue(prefix + names[i] + sizeType);
					if (size != null && size.toString() != null) {
						curr.setProperty(ISimpleGenResKeywords.N_MESSAGE_LENGHT, size.toString());
					}
				} catch (Exception e) {
					// nothing
				}

				temp.add(curr);
			}
			answer = (ISimpleGenRes[]) temp.toArray(new ISimpleGenRes[temp.size()]);

		}
			break;
		/* ----------------------  COM  ---------------------- */
		case IOilObjectList.COM: {
			String prefix = sysName + S + DPKG.getSystem_Architectural().getName() + S + COM_LIST + S;
			String[] names = vt.newTreeInterface().getAllName(prefix, COM_TYPE);

			answer = new SimpleGenRes[names.length];
			for (int i = 0; i < names.length; i++) {
				answer[i] = new SimpleGenRes(names[i], prefix + names[i]);
				answer[i].setProperty(IOilXMLLabels.ATTR_TYPE, IOilXMLLabels.OBJ_COM);
			}
		}
			break;

		/* ----------------------  OTHERS  ---------------------- */
		case IOilObjectList.IPDU:
		case IOilObjectList.NM:
		{
			OilObjectType oType = OilObjectType.get(type);
			String rtdtype = OilEcoreCreator.getRtdEClassExtPoint(oType.getText());
			ArrayList<ISimpleGenRes> tempList = new ArrayList<ISimpleGenRes>();
			{
				String base = rtosPrefix+S+ rtdtype + S;
				String[] childNames = vt.newTreeInterface().getAllName(base, null);
				for (String name: childNames) {
					String[] split = DataPath.resolveId(DataPath.removeSlash(DataPath.removeSlash(name)));
					ISimpleGenRes current = new SimpleGenRes(split[1], base + name);
//					current.setProperty(IOilXMLLabels.ATTR_TYPE, oType.getText());
//					current.setProperty(ISimpleGenResKeywords.RTOS_PATH, rtosPath);
					tempList.add(current);
				}
			}
			answer = (ISimpleGenRes[]) tempList.toArray(new ISimpleGenRes[tempList.size()]);
		}
			break;

		/* ----------------------  CPU  ---------------------- */
		case IOilObjectList.CPU: // nothing
			break;
		default:
			throw new IllegalArgumentException(
					"Specified Oil Object Type is not valid : " + type);
		}

		return answer;
	}

	/**
	 * Searchs a var inside the tree e return it's string value. If it doesn't
	 * find the var or its value is null, returns null.
	 * 
	 * @param path
	 *            idenfies the variable
	 * 
	 * @return the String rapresentation of the specified var or null if the var
	 *         was empty or not found
	 */
	protected String getVarAsString(String path) {
		return getVarAsString(vt, path);
	}
	protected static String getVarAsString(IVarTree vt, String path) {
		IVarTreePointer vtp = vt.newVarTreePointer();

		// search ...
		if (vtp.go(path)) {
			// ... check if is a container
			if (vtp.isContainer()) {
				return null;
			}
			// ... then get the var ...
			IVariable var = vtp.getVar();
			if (var != null && var.get() != null) {
				// ... and return the value
				return var.toString();
			}
		}

		return null;
	}
	
	
	
	/**
	 * Returns the size of Rtos List 
	 */
	public int getRtosSize() {
		
		if (rtosSize == null) {
			
			if (oilObjects != null) {
				rtosSize = oilObjects.length;
			} else {
				rtosSize = extractDistinctOs().size();
			}
		}
		
		return rtosSize;
	}
	

	/**
	 * Check if specified object contains a valid integer rapresentation (using toString)
	 */
	protected boolean isAValidInteger(Object txt) {
		if (txt == null) {
			return false;
		}
		
		if (txt instanceof Integer) {
			return true;
		}
		
		String toString = txt.toString();
		
		try {
			Integer.decode(toString);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * Searchs the given Key inside the current keyword's list.
	 * 
	 * @param key
	 *            specified the string to search
	 * 
	 * @return true if the specified string is one of current keywords
	 */
	public boolean checkKeyword(String key) {
		Assert.isNotNull(key);
		for (int i = 0; i < keys.length; i++) {
			if (key.equals(keys[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return Returns the oilHwRtosPrefix.
	 */
	public String getOilHwRtosPrefix() {
		return oilHwRtosPrefix;
	}
	
	/**
	 * @return Returns the options.
	 */
	public HashMap<String, ?> getOptions() {
		return options;
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.internal.modules.oil.codewriter.common.IRtosWriter#getOilObjects()
	 */
	public IOilObjectList[] getOilObjects() {
		return oilObjects;
	}
	
	/**
	 * Returns current IVarTree
	 * */
	public IVarTree getVt() {
		return vt;
	}
	
	/***************************************************************************
	 * 
	 * ABSTRACT METHOD
	 *  
	 **************************************************************************/

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.internal.modules.oil.codewriter.common.IRtosWriter#write()
	 */
	public abstract IOilWriterBuffer[] write() throws OilCodeWriterException;

	/**
	 * Returns the identifier of current rtos inside the Oil Implementation
	 * Factory.
	 * 
	 * @return the identifier of current rtos
	 */
	protected abstract String getRtosOilId();

	/**
	 * Returns the identifier of current HW inside the Oil Implementation
	 * Factory.
	 * 
	 * @return the identifier of current rtos
	 */
	protected abstract String getHwOilId();
	
	public static List<String> getOsProperties(IOilObjectList ool, String key) {
		ArrayList<String> l = new ArrayList<String>();
		if (ool != null) {
			for (ISimpleGenRes sgrOs : ool.getList(IOilObjectList.OS)) {
				if (sgrOs.containsProperty(key)) {
					Object o = sgrOs.getObject(key);
					if (o != null) {
						if (o instanceof String) {
							l.add((String) o);
						} else if (o instanceof String[]) {
							l.addAll(Arrays.asList((String[]) o ));
						} else if (o instanceof Collection) {
							for (Object obj : (Collection<?>)o) {
								if (obj != null) {
									l.add(obj.toString());
								}
							}
						}
					}
				}
			}
		}
		return l;
	}
	
	public static String getOsProperty(IOilObjectList ool, String key) {
		if (ool == null) {
			return null;
		}
		for (ISimpleGenRes sgrOs : ool.getList(IOilObjectList.OS)) {
			if (sgrOs.containsProperty(key)) {
				String t = sgrOs.getString(key);
				if (t != null) {
					return t;
				}
			}
		}
		return null;
	}
	
	public static List<Object> getOsObjects(IOilObjectList ool, String key) {
		ArrayList<Object> l = new ArrayList<Object>();
		if (ool != null) {
			for (ISimpleGenRes sgrOs : ool.getList(IOilObjectList.OS)) {
				if (sgrOs.containsProperty(key)) {
					Object t = sgrOs.getObject(key);
					if (t != null) {
						l.add(t);
					}
				}
			}

		}
		return l;
	}
	
	public static Object getOsObject(IOilObjectList ool, String key) {
		if (ool == null) {
			return null;
		}
		for (ISimpleGenRes sgrOs : ool.getList(IOilObjectList.OS)) {
			if (sgrOs.containsProperty(key)) {
				Object t = sgrOs.getObject(key);
				if (t != null) {
					return t;
				}
			}
		}
		return null;
	}

}

