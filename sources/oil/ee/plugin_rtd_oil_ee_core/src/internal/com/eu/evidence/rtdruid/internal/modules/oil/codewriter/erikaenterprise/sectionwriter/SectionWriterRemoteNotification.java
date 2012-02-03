/*
 * Created on 1-oct-2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.sectionwriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import com.eu.evidence.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.modules.oil.erikaenterprise.constants.IRemoteNotificationsConstants;
import com.eu.evidence.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions;
import com.eu.evidence.modules.oil.erikaenterprise.interfaces.IMacrosForSharedData;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuUtility;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EmptyMacrosForSharedData;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * This writer manages Remote Notifications
 * 
 * @author Nicola Serreli
 */
public class SectionWriterRemoteNotification extends SectionWriter implements
		IEEWriterKeywords, IRemoteNotificationsConstants,
		IExtractObjectsExtentions, IGetEEOPTExtentions {
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;

	/** All data */
	protected final IVarTree vt;
	
	/**
	 * 
	 */
	public SectionWriterRemoteNotification() {
		this(null);
	}
	
	/**
	 * 
	 */
	public SectionWriterRemoteNotification(ErikaEnterpriseWriter parent) {
		super("REMOTE_NOTIFICATION", new String[] {}, //
				new String[] {},
				SWCategoryManager.defaultInstance.newCategory(SWCategoryManager.TYPE_INIT, 6));
		
		this.parent = parent;
		this.vt = parent == null ? null : parent.getVt();
	}

	/**
	 * This method returns true if current instance of writer is enabled with
	 * specified keywords.
	 * 
	 * This writer is enabled if there is only one cpu
	 * 
	 * @return true if this writer is enabled
	 */
	protected boolean enabled() {
		return parent.getRtosSize() > 1 || Collections.binarySearch(keywords, IWritersKeywords.CPU_NIOSII) >=0;
	}

	/**
	 * This method parse the data, prepares all buffers for
	 * <code>.c/.h/.s/.asm</code> files and store them inside a
	 * {@link OilWriterBuffer OilWriterBuffer}. If there are more than one cpu,
	 * uses one {@link OilWriterBuffer OilWriterBuffer}for each cpu.
	 * 
	 * @param vt
	 *            all data (cannot be null)
	 * 
	 * @return one {@link OilWriterBuffer OilWriterBuffer}for each cpu.
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some errors
	 */
	public IOilWriterBuffer[] internalWrite(IVarTree vt)
			throws OilCodeWriterException {
		parent.check(vt);

		return writeRemoteNotification();
	}
	
	/**
	 *  This method prepares data for <b>remote Notification </b>
	 * 
	 * @return buffers 
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeRemoteNotification() {

		
		final String indent1 = IWritersKeywords.INDENT;
		final String indent2 = indent1 + IWritersKeywords.INDENT;
		final String indent3 = indent2 + IWritersKeywords.INDENT;

		final int rtosNumber = parent.getRtosSize();
		IOilObjectList[] oilObjects = parent.getOilObjects();
		IOilWriterBuffer[] answer = new IOilWriterBuffer[rtosNumber];
	
		boolean binaryDistr = parent.checkKeyword(IEEWriterKeywords.DEF__EE_USE_BINARY_DISTRIBUTION__);
		final String MAX_CPU = (binaryDistr ? "RTD_" : "EE_") + "MAX_CPU";
		final String MAX_RN = (binaryDistr ? "RTD_" : "EE_") + "MAX_RN";

		
		
		
		IMacrosForSharedData macros = new EmptyMacrosForSharedData();
		if (rtosNumber>0) {
			List<ISimpleGenRes> oslist = oilObjects[0].getList(IOilObjectList.OS);
			if (oslist.size()>0 && oslist.get(0).containsProperty(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR)) {
				macros = ((CpuHwDescription) oslist.get(0).getObject(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR)).getShareDataMacros();
			}
		}

		
		/***********************************************************************
		 * 
		 * prepare buffers for All OS :
		 * 
		 * #DEFINE xxx
		 * Arrays
		 * other data
		 * 
		 **********************************************************************/
		
		StringBuffer sbRnThread[] = new StringBuffer[rtosNumber];	// store data about pids of remote threads
		StringBuffer sbRnDeclaration = new StringBuffer();

		
		final StringBuffer EE_rn_cpuBuffer = new StringBuffer(indent1 
				+ "const EE_UINT8 " +
				macros.constVectorRom("EE_rn_cpu","["+MAX_RN+"]") +" =\n"+indent2+"{");
		final StringBuffer EE_rn_taskBuffer = new StringBuffer(indent1
				+ "#if defined( __RN_EVENT__ ) || defined( __RN_TASK__ )\n"
				+ indent2 + "const EE_TID " +
				macros.constVectorRom("EE_rn_task","["+MAX_RN+"]") +" = {\n");

		// number of remote notifications
		int rnNumber = 0;
		// All global resources (add each resource only one time !)
		HashMap<String, String> globRes = new HashMap<String, String>();
		final int nGlobRes;

		String rn_pre = "";
		String rn_post = "";

		// init buffers before start computation
		for (int rtosId = 0; rtosId < rtosNumber; rtosId++) {
			sbRnThread[rtosId] = new StringBuffer();
			answer[rtosId] = new OilWriterBuffer();
		}
		
		// a short description of RN
		ArrayList<String> rnDescr = new ArrayList<String>();
		
		for (int rtosId = 0; rtosId < rtosNumber; rtosId++) {
			
			// ------------------ common data ------------------

			// all objects for current os
			IOilObjectList ool = oilObjects[rtosId];

			String cpuId = "" + rtosId;
			

			for (Iterator<ISimpleGenRes> iter = ool.getList(IOilObjectList.TASK).iterator(); iter.hasNext(); ) {
				ISimpleGenRes task = (ISimpleGenRes) iter.next();
				
				String taskId = task.getString(ISimpleGenResKeywords.TASK_SYS_ID);
				
				final boolean remote = task.containsProperty(ISimpleGenResKeywords.TASK_REMOTE);
				if (remote) {
					EE_rn_cpuBuffer.append(rn_pre + " " + cpuId+"U");
					EE_rn_taskBuffer.append(rn_pre + rn_post + indent3 + taskId);
					
					
					// definition of remote notification
					sbRnDeclaration.append(indent1+"#define rn_" + task.getName() + " " + rnNumber + "\n");
					// definition of remote task inside the description of others cpu
					for (int rnOS =0; rnOS<rtosNumber; rnOS++) {
						if (rnOS != rtosId) {
							sbRnThread[rnOS].append(indent1
									+ "#define " + task.getName() + " (rn_" + task.getName() + "|EE_REMOTE_TID)\n");
						}
					}
					
					// update temp values
					rn_pre = ",";
					rn_post ="\t\t /* cpu_" + cpuId + " - thread " + task.getName() + " */\n";
					rnDescr.add(rn_post);
					rnNumber++;
				}
			}

			for (Iterator<ISimpleGenRes> iter = ool.getList(IOilObjectList.RESOURCE).iterator(); iter.hasNext(); ) {
				ISimpleGenRes res = (ISimpleGenRes) iter.next();
				
				if (res.containsProperty(ISimpleGenResKeywords.RESOURCE_GLOBAL) && 
						"true".equalsIgnoreCase(res.getString(ISimpleGenResKeywords.RESOURCE_GLOBAL))) {
					globRes.put(res.getName(),res.getName());
				}
			}

			
		}
		nGlobRes = globRes.size();
		
		EE_rn_cpuBuffer.append("};\n\n");
		EE_rn_taskBuffer.append(rn_post + indent2 + "};\n"+indent1+"#endif\n\n");
		
		
		/***********************************************************************
		 * If there aren't remote notifications, break
		 **********************************************************************/
		if (rnNumber == 0) {
			return new IOilWriterBuffer[0];
		}
		
		
		
		/***********************************************************************
		 * 
		 * add #DEFINE to all eecfg.h
		 *  
		 **********************************************************************/
		for (int rtosId = 0; rtosId < rtosNumber; rtosId++) {
			StringBuffer sbCfg_h = answer[rtosId].get(FILE_EE_CFG_H);
			
        	final ISimpleGenRes sgrOs = oilObjects[rtosId].getList(IOilObjectList.OS).get(0);
        	final ICommentWriter commentWriter = getCommentWriter(sgrOs, FileTypes.C);
			
			sbCfg_h.append(commentWriter.writerBanner("Remote Notification")
					+ indent1 + "#define "+MAX_RN+" "+rnNumber+"\n"
					+ ( binaryDistr ? "#ifndef EE_MAX_RN\n"
							  + indent1 + "extern const unsigned int EE_MAX_RN;\n"
							  + "#endif\n" 
					: "" )
					+ sbRnDeclaration.toString() + "\n"
					+ indent1 +"/* remote threads */\n"+
					sbRnThread[rtosId].toString()+"\n");

			if (binaryDistr) {
				StringBuffer sbCfg_c = answer[rtosId].get(FILE_EE_CFG_C);
				
				sbCfg_c.append(
						  "#ifndef EE_MAX_RN\n"
						+indent1+"const unsigned int EE_MAX_RN = " + rnNumber + ";\n"
						+ "#endif\n");
			}

		}
		
		{
			/***********************************************************************
			 * 
			 * write data on common.c of cpu0 (as shared)
			 * 
			 **********************************************************************/
	
	    	final ISimpleGenRes sgrOs = oilObjects[0].getList(IOilObjectList.OS).get(0);
			ICommentWriter commentWriter = getCommentWriter(sgrOs, FileTypes.C);

			{
				CpuUtility.addSources(sgrOs, answer[0].getFileName(FILE_EE_COMMON_C));
			}
			
			
			StringBuffer sbCommon_c = answer[0].get(FILE_EE_COMMON_C);
			
			sbCommon_c.append(commentWriter.writerBanner("Remote Notification")
					+ "#include \"ee.h\"\n"
					+ parent.addCommonDataMacro(FILE_EE_COMMON_C));
			
			if (binaryDistr) {
				sbCommon_c.append("#ifndef " + MAX_CPU + "\n"
						+ "#define " + MAX_CPU + " "+ oilObjects.length +"\n"
						+ "#endif\n\n");
			}
	
			sbCommon_c.append(EE_rn_cpuBuffer.toString()
					+ EE_rn_taskBuffer.toString() );
			
	
			sbCommon_c.append(
					indent1 + "/* For each RN: The type of notification that must be used\n" +
					indent1 + " * EE_RN_COUNTER, EE_RN_EVENT, EE_RN_TASK,\n" +
					indent1 + " * EE_RN_FUNC, EE_RN_SEM\n" +
					indent1 + " */\n" +
					indent1 + "EE_TYPERN_NOTIFY " +
					macros.vectorRam("EE_rn_type","["+MAX_RN+"][2]") +" = {\n");
			
			StringBuffer sb_rn_counter = new StringBuffer(
					indent1 + "/* For each RN: The counter number if EE_RN_COUNTER, or -1 */\n"
					+ indent1 + "#ifdef __RN_COUNTER__\n"
					+ indent2 + "const EE_TYPECOUNTER "
					+ macros.constVectorRom("EE_rn_counter","["+MAX_RN+"]") +" =\n"
					+ indent3 + "{");
	
			
			StringBuffer sb_rn_event = new StringBuffer(
			        indent1 + "#ifdef __RN_EVENT__ \n"
					+ indent2 + "EE_TYPEEVENTMASK "
					+ macros.vectorRam("EE_rn_event","["+MAX_RN+"][2]") +" = {\n");
	
			
			StringBuffer sb_rn_next = new StringBuffer(
					indent1 + "EE_TYPERN " +
					macros.vectorRam("EE_rn_next","["+MAX_RN+"][2]") +" = {\n");
	
			StringBuffer sb_rn_pending = new StringBuffer(
			        indent1 + "EE_UREG " +
			        macros.vectorRam("EE_rn_pending","["+MAX_RN+"][2]") +" = {\n");
	
			{
				String pre = "";
				String post = "";
				String tp = "";
				String tp2 = "";
				for (int i=0; i< rnNumber; i++) {
					sbCommon_c.append(pre +post+ indent2+ "{0U, 0U}");
					sb_rn_counter.append(tp + "-1");
					sb_rn_event.append(tp2 +indent3+ "{0U, 0U}");
					sb_rn_next.append(tp2 +indent3+ "{-1, -1}");
					sb_rn_pending.append(tp2 +indent2+ "{0U, 0U}");
		
					tp = ", ";
					tp2 = ",\n";
					pre = ",";
					post = (String) rnDescr.get(i);
				}
				sbCommon_c.append(post+indent1+"};\n\n");
			}
	
			sb_rn_counter.append("};\n"+ indent1 + "#endif\n\n");
			sb_rn_event.append("\n" + indent2 +"};\n" + indent1 + "#endif\n\n");
			sb_rn_next.append("\n" + indent1 + "};\n\n");
			sb_rn_pending.append("\n" + indent1 + "};\n\n");
	
			
			sbCommon_c.append( 
			        sb_rn_counter.toString() + 
			        sb_rn_event.toString() + 
			        sb_rn_next.toString() + 
			        sb_rn_pending.toString() +
			        
					indent1 + "#ifdef __RN_FUNC__\n" +
					indent2 + "/* const EE_ADDR "
					+ macros.constVectorRom("EE_rn_func","["+MAX_RN+"]") +" = {(EE_ADDR)f,...};*/\n" +
					indent1 + "#endif\n\n" +
					indent1 + "#ifdef __RN_SEM__\n" +
					indent2 + "/*EE_SEM * const " +
					macros.constVectorRom("EE_rn_sem","["+MAX_RN+"]") +";*/\n" +
					indent1 + "#endif\n\n");
	
			/*
			 * Arrays About CPU
			 * 
			 * EE_rn_first
			 * EE_rn_spin
			 * EE_rn_switch
			 * 
			 */
			
			StringBuffer sbRnFirst = new StringBuffer(indent1 + "EE_TYPERN " +
					macros.vectorRam("EE_rn_first","["+MAX_CPU+"][2]") +" = {\n"+indent2);
			StringBuffer sbRnSpin = new StringBuffer(indent1 + "const EE_TYPESPIN " +
					macros.constVectorRom("EE_rn_spin","["+MAX_CPU+"]") +" = { ");
			StringBuffer sbRnSwitch = new StringBuffer(indent1 + "EE_TYPERN_SWITCH " +
					macros.vectorRam("EE_rn_switch","["+MAX_CPU+"]") +" = { ");
			
			// prepare strings
			String pre2="";
			for (int i=0; i<rtosNumber; i++) {
				sbRnFirst.append(pre2+"{ -1, -1}");
				sbRnSpin.append(pre2+(nGlobRes+i)+"U");
				sbRnSwitch.append(pre2+"0U");
				
				pre2 =", ";
			}
			sbRnFirst.append("\n"+indent1 + "};\n\n");
			sbRnSpin.append("};\n\n");
			sbRnSwitch.append("};\n\n");
	
			sbCommon_c.append(
					sbRnFirst.toString() +
					sbRnSpin.toString() +
					sbRnSwitch.toString()
					//+"#endif /* __RN__ */"
			);
			
		}
		return answer;
	}
	

	/* (non-Javadoc)
	 * @see com.eu.evidence.modules.oil.erikaenterprise.subwriters.IExtractObjectsExtentions#updateObjects()
	 */
	public void updateObjects() throws OilCodeWriterException {
		IOilObjectList[] oilObjects = parent.getOilObjects();
		
		boolean rn_counter = false;
		boolean rn_event = parent.checkKeyword(IEEWriterKeywords.DEF__EE_USE_BINARY_DISTRIBUTION__)
						&& (oilObjects.length>1)
						&& (parent.checkKeyword(IWritersKeywords.OSEK_ECC1) 
								|| parent.checkKeyword(IWritersKeywords.OSEK_ECC2)
								|| parent.checkKeyword(IWritersKeywords.FRSH));
		boolean rn_task = false;
		boolean rn_func = false;
		boolean rn_sem = false;
		
		BitSet rn_set = new BitSet(5);

		
		setEventMask(oilObjects);
		
		for (int rtosId = 0; rtosId < oilObjects.length; rtosId++) {

			// all objects for current os
			IOilObjectList ool = oilObjects[rtosId];
			ISimpleGenRes os = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
			
			os.setObject(DEF__RN_BITS__, rn_set);
			
			// ------------------ RN COUNTER ------------------
			int rn_counter_number = 0;
			
			os.setObject(DEF__RN_COUNTER__, new Integer(rn_counter_number));

			// ------------------ RN EVENT ------------------
			int rn_event_number = 0;
			{
				List<ISimpleGenRes> eventList = ool.getList(IOilObjectList.EVENT);
				for (Iterator<ISimpleGenRes> iter = eventList.iterator(); iter.hasNext();) {
					ISimpleGenRes curr = (ISimpleGenRes) iter.next();
					
					if (curr.containsProperty(ISimpleGenResKeywords.EVENT_CPU_BITSET)) {
						if (((BitSet) curr.getObject(ISimpleGenResKeywords.EVENT_CPU_BITSET)).cardinality() > 1) {
							rn_event_number ++;
						}
					}
				}
	
				os.setObject(DEF__RN_EVENT__, new Integer(rn_event_number));
				if (rn_event_number>0) {
					rn_event = true;
				}
			}

			// ------------------ RN TASK ------------------
			int rn_task_number = 0;
			for (Iterator<ISimpleGenRes> iter = ool.getList(IOilObjectList.TASK).iterator(); iter.hasNext(); ) {
				ISimpleGenRes task = (ISimpleGenRes) iter.next();

				if (task.containsProperty(ISimpleGenResKeywords.TASK_REMOTE) 
						&& (""+true).equals(task.getString(ISimpleGenResKeywords.TASK_REMOTE))) {
					rn_task = true ;
					rn_task_number ++;
				}
			}
			os.setObject(DEF__RN_TASK__, new Integer(rn_task_number));

			// ------------------ RN FUNC ------------------
			int rn_func_number = 0;
			os.setObject(DEF__RN_FUNC__, new Integer(rn_func_number));

			// ------------------ RN SEM ------------------
			int rn_sem_number = 0;
			os.setObject(DEF__RN_SEM__, new Integer(rn_sem_number));

			// ------------------ store RN ------------------
			int rn_number = rn_counter_number + rn_event_number + rn_task_number
					+ rn_func_number + rn_sem_number;
			os.setObject(DEF__RN__, new Integer(rn_number));
			
		}
		
		// set each bit
		if (rn_counter) { rn_set.set(DEF__RN_COUNTER_BIT__); }
		if (rn_event)   { rn_set.set(DEF__RN_EVENT_BIT__); }
		if (rn_task)    { rn_set.set(DEF__RN_TASK_BIT__); }
		if (rn_func)    { rn_set.set(DEF__RN_FUNC_BIT__); }
		if (rn_sem)     { rn_set.set(DEF__RN_SEM_BIT__); }
	}

	
	/* (non-Javadoc)
	 * @see com.eu.evidence.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions#getEEOpt(int)
	 */
	public List<String> getEEOpt(int type, int rtosId) {
		List<String> answer = new ArrayList<String>();
		
	    IOilObjectList ool = rtosId >= 0 ? parent.getOilObjects()[rtosId] : null;
		
		if ((type & EE_OPT_CPU_ONLY) != 0) {
			/*******************************************************************
			 * AUTOMATIC OPTIONS (CPU DEPENDENT)
			 ******************************************************************/
			
			if (ool != null) {
			    ISimpleGenRes sgrCpu = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
			    BitSet rn_set = (BitSet) sgrCpu.getObject(DEF__RN_BITS__);
	
				// set each bit
			    if (rn_set.cardinality()>0)            { answer.add("__RN__"); }
				if (rn_set.get(DEF__RN_COUNTER_BIT__)) { answer.add("__RN_COUNTER__"); }
				if (rn_set.get(DEF__RN_EVENT_BIT__))   { answer.add("__RN_EVENT__"); }
				if (rn_set.get(DEF__RN_TASK_BIT__))    { answer.add("__RN_TASK__"); }
				if (rn_set.get(DEF__RN_FUNC_BIT__))    { answer.add("__RN_FUNC__"); }
				if (rn_set.get(DEF__RN_SEM_BIT__))     { answer.add("__RN_SEM__"); }
			}			
		}

		return answer;
	}

	
	/**
	 * Sets a valid mask for each event.
	 * 
	 * NOTE: this method is enabled does not take care of remote events. 
	 *       Moreover, this method set masks only for those events that does not have it. 
	 * 
	 * @throws OilCodeWriterException
	 *             if there're too many events
	 */
	protected void setEventMask(IOilObjectList[] oilObjects) throws OilCodeWriterException {
		
		/*
		 * Get OS/HAS_REMOTE_NOTIFICATION 
		 */
		final boolean useAlwaysRemoteEvent;
		{
			final String str_ALWAYS = "ALWAYS";
			final String str_IFREQUIRED = "IFREQUIRED";
			
			
			String[] values = parent.getRtosCommonChildType("USEREMOTEEVENT");
			if (values.length == 0 ) {
				useAlwaysRemoteEvent = false; // TODO: default value
				
			} else if (values.length >1) {
				throw new OilCodeWriterException("OS/USEREMOTEEVENT is setted with different values");
				
			} else if (str_ALWAYS.equals(values[0])) {
				useAlwaysRemoteEvent = true;
				
			} else if (str_IFREQUIRED.equals(values[0])) {
				useAlwaysRemoteEvent = false;
				
			} else {

					throw new OilCodeWriterException("Only " + str_ALWAYS + " and " 
							+ str_IFREQUIRED + " are valid values for OS/USEREMOTEEVENT.\n"
							+"\tFound "+values[0]);
			}
		}

		
		
		/*
		 * For each event, check where they are required
		 */
		HashMap<String, BitSet> event_to_cpu_map = new HashMap<String, BitSet>();
		if (!useAlwaysRemoteEvent) {
			for (int rtosId = 0; rtosId < oilObjects.length; rtosId++) {
				
				List<ISimpleGenRes> taskList = oilObjects[rtosId].getList(IOilObjectList.TASK);
				for (ISimpleGenRes task: taskList) {
					if (task.containsProperty(ISimpleGenResKeywords.TASK_EVENT_LIST)) {
						List<String> events = (List<String>) task.getObject(ISimpleGenResKeywords.TASK_EVENT_LIST);
						
						for (String event: events){
							BitSet bs;
							if (event_to_cpu_map.containsKey(event)) {
								bs = event_to_cpu_map.get(event);
							} else {
								bs = new BitSet();
								event_to_cpu_map.put(event, bs);
							}
							bs.set(rtosId);
						}
					}
				}
			
				List<ISimpleGenRes> alarmList = oilObjects[rtosId].getList(IOilObjectList.ALARM);
				for (ISimpleGenRes alarm: alarmList) {
					if (alarm.containsProperty(ISimpleGenResKeywords.ALARM_SET_EVENT)) {
						// {taskName, eventName}
						String[] task_event = (String[]) alarm.getObject(ISimpleGenResKeywords.ALARM_SET_EVENT);
						{
							String event = task_event[1];
							BitSet bs;
							if (event_to_cpu_map.containsKey(event)) {
								bs = event_to_cpu_map.get(event);
							} else {
								bs = new BitSet();
								event_to_cpu_map.put(event, bs);
							}
							bs.set(rtosId);
						}
					}
				}
				
			}
		}
		
		
		/*
		 * For each cpu, store all used mask
		 */
		BitSet[] bits = new BitSet[oilObjects.length];
		for (int i=0; i<bits.length; i++) {
			bits[i] = new BitSet();
		}
		/*
		 * And for each event, store the used mask
		 */
		HashMap<String, BitSet> event_mask_map = new HashMap<String, BitSet>();
		for (int rtosId = 0; rtosId < oilObjects.length; rtosId++) {
			List<ISimpleGenRes> eventList = oilObjects[rtosId].getList(IOilObjectList.EVENT);
			for (Iterator<ISimpleGenRes> iter = eventList.iterator(); iter.hasNext();) {

				ISimpleGenRes curr = (ISimpleGenRes) iter.next();
				if (curr.containsProperty(ISimpleGenResKeywords.EVENT_MASK)) {
					final String ev_name = curr.getName();
					long value = curr.getLong(ISimpleGenResKeywords.EVENT_MASK);
					
					long tmp = 1;
					int tti=0;
					for (; tti<65; tti++) {
						if (tmp == value) {
							break;
						}
						tmp = tmp << 1;
					}
					if (tmp != value) {
						throw new OilCodeWriterException("Not Valid mask for " + ev_name);
					}
					
					
					if (event_mask_map.containsKey(ev_name)) {
						if (!event_mask_map.get(ev_name).get(tti)) {
							throw new OilCodeWriterException("Found two different masks for the same event " + curr.getName());
						}
					} else {
						BitSet bs = new BitSet();
						bs.set(tti);
						event_mask_map.put(ev_name, bs);
					}
					
					if (useAlwaysRemoteEvent) {
						for (int i=0; i<oilObjects.length; i++) {
							bits[i].set(tti);
						}
					} else {
						if (event_to_cpu_map.containsKey(ev_name)) {
							BitSet cpuIds = event_to_cpu_map.get(ev_name);
							for (int i=0; i<oilObjects.length; i++) {
								if (cpuIds.get(i)) {
									bits[i].set(tti);
								}
							}
						}
					}
				}
			}
		}
		

		BitSet all_true = new BitSet();
		all_true.set(0, oilObjects.length, true);
		
		/*
		 * Set mask
		 */
		for (int rtosId = 0; rtosId < oilObjects.length; rtosId++) {
			List<ISimpleGenRes> eventList = oilObjects[rtosId].getList(IOilObjectList.EVENT);
			for (Iterator<ISimpleGenRes> iter = eventList.iterator(); iter.hasNext();) {

				ISimpleGenRes curr = (ISimpleGenRes) iter.next();
				final String ev_name = curr.getName();
				
				if (useAlwaysRemoteEvent || event_to_cpu_map.containsKey(ev_name)) {
					BitSet cpuIds = useAlwaysRemoteEvent ? all_true : event_to_cpu_map.get(ev_name);
					
					int mask;
					if (event_mask_map.containsKey(ev_name)) {
						mask = event_mask_map.get(ev_name).nextSetBit(0);
					} else {
						mask = getValidMask(cpuIds, bits);
						{
							BitSet bs = new BitSet();
							bs.set(mask);
							event_mask_map.put(ev_name, bs);
						}
					}
					
					curr.setProperty(ISimpleGenResKeywords.EVENT_MASK, "" + (1<<mask));
					curr.setObject(ISimpleGenResKeywords.EVENT_CPU_BITSET, cpuIds);
				} else {
					curr.setProperty(ISimpleGenResKeywords.EVENT_MASK, "" + (0));
					curr.setObject(ISimpleGenResKeywords.EVENT_CPU_BITSET, new BitSet());
				}
				
			}

		}

	}
	
	
	protected int getValidMask(BitSet cpuIds, BitSet[] usedMasks) throws OilCodeWriterException {
		int answer = 0;
		boolean searching = true;
		
		for (; searching && answer <65; ) {
			
			boolean valid_mask = true;
			
			for (int i=0; i<usedMasks.length && valid_mask; i++) {
				if (cpuIds.get(i) && usedMasks[i].get(answer)) {
					valid_mask = false;
				}
			}
			searching = !valid_mask;
			if (searching) {
				answer++;
			}
		}
		
		if (answer == 65) {
			throw new OilCodeWriterException("Not able to automatically set the mask to all events!!");
		}
		
		for (int i=0; i<usedMasks.length; i++) {
			if (cpuIds.get(i)) {
				usedMasks[i].set(answer);
			}
		}

		
		return answer;
	}
}
