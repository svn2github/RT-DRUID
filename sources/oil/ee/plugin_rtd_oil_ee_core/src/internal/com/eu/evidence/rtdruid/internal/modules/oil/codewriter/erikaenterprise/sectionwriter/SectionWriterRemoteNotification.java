/*
 * Created on 1-oct-2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.sectionwriter;

import static com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.sectionwriter.SectionWriterQueuedSpinlock.getSpinCoreId;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuUtility;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EmptyMacrosForSharedData;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IRemoteNotificationsConstants;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IMacrosForSharedData;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * This writer manages Remote Notifications
 * 
 * @author Nicola Serreli
 */
public class SectionWriterRemoteNotification extends SectionWriter implements
		IEEWriterKeywords, IRemoteNotificationsConstants,
		IExtractObjectsExtentions, IExtractKeywordsExtentions, IGetEEOPTExtentions {
	
	public final static String DEF__USE_RN__ = "use old rn feature";
	
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
		return Collections.binarySearch(keywords, DEF__USE_RN__) >=0;
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
			CpuHwDescription currentStackDescription = ErikaEnterpriseWriter.getCpuHwDescription(oilObjects[0]);
			if (currentStackDescription != null) {
				macros =currentStackDescription.getShareDataMacros();
			}
		}
		if (parent.checkPragma(0)) {
			macros = macros.getPragma();
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

		
		final StringBuffer EE_rn_cpuBuffer_body = new StringBuffer(" =\n"+indent2+"{");
		final StringBuffer EE_rn_taskBuffer_body = new StringBuffer(" = {\n");

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
					EE_rn_cpuBuffer_body.append(rn_pre + " " + cpuId+"U");
					EE_rn_taskBuffer_body.append(rn_pre + rn_post + indent3 + taskId);
					
					
					// definition of remote notification
					sbRnDeclaration.append(indent1+"#define rn_" + task.getName() + " " + rnNumber + "\n");
					// definition of remote task inside the description of others cpu
					for (int rnOS =0; rnOS<rtosNumber; rnOS++) {
						if (rnOS != rtosId) {
							sbRnThread[rnOS].append(indent1
									+ "#define " + task.getName() + " ((EE_TID)rn_" + task.getName() + "+(EE_TID)EE_REMOTE_TID)\n");
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
		
		EE_rn_cpuBuffer_body.append("};\n");
		EE_rn_taskBuffer_body.append(rn_post + indent2 + "};\n");
		
		
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
			IOilObjectList ool = oilObjects[rtosId];
			
        	final ICommentWriter commentWriter = getCommentWriter(ool, FileTypes.C);
			
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
	
			ICommentWriter commentWriter = getCommentWriter(oilObjects[0], FileTypes.C);

			{
		    	final ISimpleGenRes sgrOs = oilObjects[0].getList(IOilObjectList.OS).get(0);
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
	
			StringBuffer tmpCommon_c = new StringBuffer();
			tmpCommon_c.append(
					macros.constVectorRom(indent1+ "const EE_UINT8 ", "EE_rn_cpu","["+MAX_RN+"]", EE_rn_cpuBuffer_body.toString() ) + "\n"
					+ indent1 + "#if defined( __RN_EVENT__ ) || defined( __RN_TASK__ )\n"
					+ macros.constVectorRom(indent2 + "const EE_TID ", "EE_rn_task","["+MAX_RN+"]", EE_rn_taskBuffer_body.toString()) 
					+indent1+"#endif\n\n");
			
	
			tmpCommon_c.append(
					indent1 + "/* For each RN: The type of notification that must be used\n" +
					indent1 + " * EE_RN_COUNTER, EE_RN_EVENT, EE_RN_TASK,\n" +
					indent1 + " * EE_RN_FUNC, EE_RN_SEM\n" +
					indent1 + " */\n");
			
			StringBuffer sb_rn_type_body = new StringBuffer(" = {\n");
			StringBuffer sb_rn_counter_body = new StringBuffer(" =\n"
					+ indent3 + "{");
			StringBuffer sb_rn_event_body = new StringBuffer(" = {\n");
			StringBuffer sb_rn_next_body = new StringBuffer(" = {\n");
			StringBuffer sb_rn_pending_body = new StringBuffer(" = {\n");
	
			{
				String pre = "";
				String post = "";
				String tp = "";
				String tp2 = "";
				for (int i=0; i< rnNumber; i++) {
					sb_rn_type_body.append(pre +post+ indent2+ "{0U, 0U}");
					sb_rn_counter_body.append(tp + "-1");
					sb_rn_event_body.append(tp2 +indent3+ "{0U, 0U}");
					sb_rn_next_body.append(tp2 +indent3+ "{-1, -1}");
					sb_rn_pending_body.append(tp2 +indent2+ "{0U, 0U}");
		
					tp = ", ";
					tp2 = ",\n";
					pre = ",";
					post = (String) rnDescr.get(i);
				}
				sb_rn_type_body.append(post+indent1+"};\n");
			}
	
			sb_rn_counter_body.append("};\n");
			sb_rn_event_body.append("\n" + indent2 +"};\n");
			sb_rn_next_body.append("\n" + indent1 + "};\n");
			sb_rn_pending_body.append("\n" + indent1 + "};\n");
	
			
			tmpCommon_c.append(
					macros.vectorRam(indent1 + "EE_TYPERN_NOTIFY ", "EE_rn_type","["+MAX_RN+"][2]", sb_rn_type_body.toString()) +"\n"
					
					+ indent1 + "/* For each RN: The counter number if EE_RN_COUNTER, or -1 */\n"
					+ indent1 + "#ifdef __RN_COUNTER__\n"
					+ macros.constVectorRom(indent2 + "const EE_TYPECOUNTER ", "EE_rn_counter","["+MAX_RN+"]", sb_rn_counter_body.toString())
			        + indent1 + "#endif\n\n"
			        
			        + indent1 + "#ifdef __RN_EVENT__ \n"
					+ macros.vectorRam(indent2 + "EE_TYPEEVENTMASK ", "EE_rn_event","["+MAX_RN+"][2]", sb_rn_event_body.toString())
			        + indent1 + "#endif\n\n"
			        
					+ macros.vectorRam(indent1 + "EE_TYPERN ", "EE_rn_next","["+MAX_RN+"][2]", sb_rn_next_body.toString()) + "\n"
					
			        + macros.vectorRam(indent1 + "EE_UREG ", "EE_rn_pending","["+MAX_RN+"][2]", sb_rn_pending_body.toString()) + "\n" +
			        
					indent1 + "#ifdef __RN_FUNC__\n"
					+ macros.constVectorRom(indent2 + "/* const EE_ADDR ", "EE_rn_func","["+MAX_RN+"]"," = {(EE_ADDR)f,...};*/\n") +
					indent1 + "#endif\n\n" +
					indent1 + "#ifdef __RN_SEM__\n" +
					macros.constVectorRom(indent2 + "/*EE_SEM * const ", "EE_rn_sem","["+MAX_RN+"]",";*/\n") +
					indent1 + "#endif\n\n");
	
			/*
			 * Arrays About CPU
			 * 
			 * EE_rn_first
			 * EE_rn_spin
			 * EE_rn_switch
			 * 
			 */
			
			StringBuffer sbRnFirst_body = new StringBuffer(" = {\n"+indent2);
			StringBuffer sbRnSpin_body = new StringBuffer(" = { ");
			StringBuffer sbRnSwitch_body = new StringBuffer(" = { ");
			
			// prepare strings
			String pre2="";
			for (int i=0; i<rtosNumber; i++) {
				sbRnFirst_body.append(pre2+"{ -1, -1}");
				sbRnSpin_body.append(pre2+getSpinCoreId(i));
				sbRnSwitch_body.append(pre2+"0U");
				
				pre2 =", ";
			}
			sbRnFirst_body.append("\n"+indent1 + "};\n");
			sbRnSpin_body.append("};\n");
			sbRnSwitch_body.append("};\n");
	
			tmpCommon_c.append(
					
					macros.vectorRam(indent1 + "EE_TYPERN ", "EE_rn_first","["+MAX_CPU+"][2]", sbRnFirst_body.toString()) + "\n" +
					macros.constVectorRom(indent1 + "const EE_TYPESPIN ", "EE_rn_spin","["+MAX_CPU+"]", sbRnSpin_body.toString()) + "\n" +
					macros.vectorRam(indent1 + "EE_TYPERN_SWITCH ", "EE_rn_switch","["+MAX_CPU+"]", sbRnSwitch_body.toString()) + "\n"
					//+"#endif /* __RN__ */"
			);
			
			if (macros instanceof IMacrosForSharedData.IPragma) {
				sbCommon_c.append(((IMacrosForSharedData.IPragma) macros).getPragmaSections());
			}
			sbCommon_c.append(tmpCommon_c);
			
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
			// set values into the first cpu
			final ISimpleGenRes os = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
			
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
		
		
		// Add an ISR2
		for (IOilObjectList ool : oilObjects) {
			
			Object o = AbstractRtosWriter.getOsObject(ool, ISimpleGenResKeywords.OS_CPU__ISR2_ADDITIONAL_NUMBER);
			Object t = AbstractRtosWriter.getOsObject(ool, ISimpleGenResKeywords.OS_CPU__ISR2_ADDITIONAL_TXT_LIST);
			int isr2Number = 1 + (o == null ? 0 : ((Integer) o).intValue()) ;
			@SuppressWarnings("unchecked")
			List<String> lt = t == null ? new ArrayList<String>() : (List<String>) t;
			lt.add("Remote notification requires an additional ISR2");
			for (ISimpleGenRes os : ool.getList(IOilObjectList.OS)) {
				os.setObject( ISimpleGenResKeywords.OS_CPU__ISR2_ADDITIONAL_NUMBER, new Integer(isr2Number));
				os.setObject( ISimpleGenResKeywords.OS_CPU__ISR2_ADDITIONAL_TXT_LIST, lt);
			}
			
		}
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
			    BitSet rn_set = (BitSet) AbstractRtosWriter.getOsObject(ool, DEF__RN_BITS__);
	
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
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions#updateKeywords(java.util.ArrayList, java.lang.String[])
	 */
	@Override
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix) throws OilCodeWriterException {
		
		if (parent.getRtosSize() > 1 || Collections.binarySearch(keywords, IWritersKeywords.CPU_NIOSII) >=0) {
	
			final IVarTree vt = parent.getVt();
			// by default, use this RemoteNotification handling
			boolean useRN = true;
	
			//final ArrayList ee_opts = new ArrayList();
			for (int i=0; i<rtosPrefix.length; i++) {
				
				/*******************************************************************
				 * BOARD TYPE
				 ******************************************************************/
				String path = parent.computeOilRtosPrefix(rtosPrefix[i]) + "REMOTENOTIFICATION";
	
				String[] child = new String[1];
				String board_type = CommonUtils.getFirstChildEnumType(vt,
						path , child);
				if (board_type != null) {
	
					// if the notification type is not rn, disable this writer
					if (!"USE_RN".equals(board_type)) {
						useRN = false;
					}
				}
			}
	
			if (useRN && !keywords.contains("USE_RN")) {
				keywords.add(DEF__USE_RN__);
			}
		}
	}
	
}
