/*
 * Created on Dec 2, 2004
 *
 * $Id: ErikaEnterpriseWriter.java,v 1.30 2008/05/14 17:13:52 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;


import static com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords.S;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.DefaultRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.HostOsUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OsType;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.ResourceList;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription.IRequiresUpdates;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EECpuDescriptionManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription.IRequiresUpdates;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IDistributionConstant;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.location.EEPaths;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilObjectType;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilPath;
import com.eu.evidence.rtdruid.modules.oil.interfaces.ISectionWriter;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVarTreePointer;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

/**
 * This class prepares all Configuration Files for Erika Enterprise RT-OS.
 * 
 * @author Nicola Serreli
 */
public class ErikaEnterpriseWriter extends DefaultRtosWriter implements IEEWriterKeywords {

	public static 
	/**
	 * Use a specific Properties that check if the new value is already
	 * setted and they are the same.
	 */
	class EEProperties extends Properties {
		/**	 */
		private static final long serialVersionUID = -752544725338646244L;
		/**
		 * Before set a property, check if the property already exist and if
		 * the new value and the old one are the same.
		 * 
		 * @param key
		 *            identifies the property
		 * @param value
		 *            the property value
		 * 
		 * @throws OilCodeWriterException
		 *             if the property was setted with a different value.
		 */
		public synchronized Object setOilProperty(String key, String value)
				throws OilCodeWriterException {

			// Don't do anything if value is null
			if (value == null) {
				return super.getProperty(key);
			}
			
			// Check if the property already exist
			if (super.containsKey(key)) {
				String oldValue = super.getProperty(key);

				// check if the new value is valid
				if (!value.equalsIgnoreCase(oldValue)) {
					throw new OilCodeWriterException(
							"Found more than one setting for " + key
									+ " : " + oldValue + " and " + value);
				}

				return oldValue;

			} else {
				// Set the property for the first time
				return super.setProperty(key, value);
			}
		}
		/**
		 * Disabled : use setOilProperty(String key, String value)
		 * 
		 * @throws UnsupportedOperationException
		 * 
		 * @deprecated use setOilProperty(String key, String value)
		 */
		public synchronized Object setProperty(String key, String value) {
			throw new UnsupportedOperationException(
					"Use setOilProperty(String key, String value)");
		}
	};
	
	private final static boolean useMultiplePriorities = false;
	
	/**
	 * UPDRTD rendere legata al plugin
	 * */
	protected final String[] kernel_types = new String[] { IWritersKeywords.OSEK_BCC1,
			IWritersKeywords.OSEK_BCC2, IWritersKeywords.OSEK_ECC1,
			IWritersKeywords.OSEK_ECC2, IWritersKeywords.EDF, IWritersKeywords.FP, IWritersKeywords.SRPT };

	/** The identifier of this writer */
	public final static String ID = "EE";
	
	/**
	 * Contains the current instance of this class and it's used by section
	 * writers
	 */
	protected ErikaEnterpriseWriter parent;

	

	/***************************************************************************
	 * 
	 * Variables
	 *  
	 **************************************************************************/

	/** Identifies current Eclipse project or output prefix */
	public String default_output_prefix = "";
	
	protected ISectionWriter[] writersList = null;

	
	/***************************************************************************
	 * 
	 * Constructor && init methods
	 *  
	 **************************************************************************/

	/** The default constructor */
	public ErikaEnterpriseWriter() {
		parent = this;
	}

	/**
	 * This method returns all {@link SectionWriter SectionWriter } availables
	 * with this RT-OS Writer.
	 */
	protected ISectionWriter[] getWriters() {
		
		if (writersList == null) {
// UPDRTD dividere i writers x gruppi !!! (e mantenere l'ordine qui indicato)
		
			ArrayList<ISectionWriter> answer = new ArrayList<ISectionWriter> (Arrays.asList(EESectionWritersFactory.getFactories(this)));
			/***********************************************************************
			 * FIRST Kernel writers
			 **********************************************************************/
//			{ // Common parts
//				answer.add(0, new SectionWriterCommonKernelDefs(this));
//				// remote notifications
//				answer.add(1, new SectionWriterRemoteNotification(this));
//			}
	
			/***********************************************************************
			 * THEN all HW Writers
			 **********************************************************************/
	
			/***********************************************************************
			 * and as the last : make file writer and distribution writer
			 **********************************************************************/
	
//			{ // MAKEFILE
//				answer.add(new SectionWriterMakefile_SP(this));
//				answer.add(new SectionWriterMakefile_MP(this));
//			}
			
			
			writersList = (ISectionWriter[]) answer
					.toArray(new ISectionWriter[answer.size()]);
		}
		
		return writersList;
	}

	/**
	 * Returns the identifier of current rtos inside the Oil Implementation
	 * Factory.
	 * 
	 * @return the identifier of current rtos
	 */
	protected String getRtosOilId() {
		return ID;
	}

	/**
	 * Returns the identifier of current HW inside the Oil Implementation
	 * Factory.
	 * 
	 * @return the identifier of current rtos
	 */
	protected String getHwOilId() {
		return null;
	}
	
	/**
	 * This method searchs all KEYWORDS defined inside the VarTree for current
	 * list of specific rtos. (HW type is a first one)<br>
	 * <br>
	 * Extract also MULTI_STACK, MONO_STACK, IRQ_STACK_NEEDED, OSEK_EXTENDED,
	 * .... <br><br>
	 * (See also {@link IWritersKeywords WritersKeys})
	 * 
	 * @return an array of String that contains all Keywords defined in all rtos
	 * 
	 * @throws OilCodeWriterException if the same KEYWORD is setted with differents
	 */
	protected String[] extractKeys() throws OilCodeWriterException {
		ArrayList<String> answer = new ArrayList<String>();
		answer.addAll(Arrays.asList(super.extractKeys()));
		
		{ // HOST OS
			OsType wrapper = HostOsUtils.common.getTarget();
			if (wrapper == OsType.Cygwin) {
				if (!answer.contains(IEEWriterKeywords.DEF_HOST_OS_CYGWIN)) {
					answer.add(IEEWriterKeywords.DEF_HOST_OS_CYGWIN);
				}
			} else if (wrapper == OsType.Linux) {
				if (!answer.contains(IEEWriterKeywords.DEF_HOST_OS_LINUX)) {
					answer.add(IEEWriterKeywords.DEF_HOST_OS_LINUX);
				}
			}
			
		}
		
		EEProperties checkKeys = new EEProperties();

		Boolean enable_multiStack = null;

		for (int rtodId=0; rtodId<rtosPrefix.length; rtodId++) {
			
			final String currentRtosPrefix = computeOilRtosPrefix(rtosPrefix[rtodId]);
			{
				/*******************************************************************
				 * CPU TYPE
				 ******************************************************************/
				
				ArrayList<String> cpu_paths = new ArrayList<String>();
				ArrayList<String> hw_types = new ArrayList<String>();
				getOsCpuData(currentRtosPrefix, hw_types, cpu_paths);
				
				for (int child_id = 0; child_id < cpu_paths.size(); child_id++ ) { 
					String hw_type = hw_types.get(child_id);
					String currentCpuDataPrefix = cpu_paths.get(child_id);
					
				if (hw_type != null) {
					
					// check if the value is valid
					checkKeys.setOilProperty("CPU_DATA", hw_type);

					if (!answer.contains(hw_type)) {
						answer.add(hw_type);
					}
			}
			
			
			if (currentCpuDataPrefix != null) {
				/*******************************************************************
				 * CPU PARAMETER (MULTI STACK)
				 ******************************************************************/
				String[] child = new String[1];
				String tmp = CommonUtils
						.getFirstChildEnumType(vt, currentCpuDataPrefix
								+ "MULTI_STACK", child);
	
				// TODO DEFAULT
						if (tmp != null) {

							// check if the value is valid
							checkKeys.setOilProperty("MULTI_STACK", tmp);
			
							if ("TRUE".equalsIgnoreCase(tmp) && !answer.contains(DEF__MULTI_STACK__)) {
											enable_multiStack = Boolean.TRUE;
								String tmpPath = currentCpuDataPrefix
									+ "MULTI_STACK" + VARIANT_ELIST+child[0] + PARAMETER_LIST
									+ "IRQ_STACK";
								
								String tmp2 = CommonUtils.getFirstChildEnumType(vt, tmpPath, child);
								boolean ok = "TRUE".equalsIgnoreCase(tmp2);
							
								// check if the value is valid
								checkKeys.setOilProperty("IRQ_STACK", tmp2);
								
								if (ok && !answer.contains(DEF__IRQ_STACK_NEEDED__)) {
									answer.add(DEF__IRQ_STACK_NEEDED__);
								}
										} else {
											enable_multiStack = Boolean.FALSE;
							}
						}
					}
				}
			}

			{
				/*******************************************************************
				 * MCU TYPE
				 ******************************************************************/
				// check only the first RTOS !!! (as rtos of CPU0)
				String[] child = new String[1];
				String mcu_type = CommonUtils.getFirstChildEnumType(vt,
						currentRtosPrefix + "MCU_DATA", child);
				if (mcu_type != null) {

					// check if the value is valid
					checkKeys.setOilProperty("MCU_DATA", mcu_type);

					if (!answer.contains(mcu_type)) {
						answer.add(mcu_type);
					}
					
				}
			}
			{
				/*******************************************************************
				 * KERNEL TYPE
				 ******************************************************************/
				// check only the first RTOS !!! (as rtos of CPU0)
				String[] child = new String[1];
				String kernel_type = CommonUtils.getFirstChildEnumType(vt,
						currentRtosPrefix + "KERNEL_TYPE", child);
				
				if (kernel_type != null) {
					// check if the value is valid
					checkKeys.setOilProperty("KERNEL_TYPE", kernel_type);

					if (!answer.contains(kernel_type)) {
						answer.add(kernel_type);
					}
				}
			}
			{
				/*******************************************************************
				 * STARTUP CODE
				 ******************************************************************/
				// check only the first RTOS !!! (as rtos of CPU0)
				String mcu_type = CommonUtils.getFirstChildEnumType(vt,
						currentRtosPrefix + "CUSTOM_STARTUP_CODE", null);
				if (mcu_type != null) {
	
					// check if the value is valid
					checkKeys.setOilProperty("CUSTOM_STARTUP_CODE", mcu_type);

					if ("true".equalsIgnoreCase(mcu_type) && !answer.contains(DEF__CUSTOM_STARTUP_CODE__)) {
						answer.add(DEF__CUSTOM_STARTUP_CODE__);
					}
					
				}
			}
		} // end for
		
		
		if (enable_multiStack == Boolean.TRUE && !answer.contains(DEF__MULTI_STACK__)) {
			answer.add(DEF__MULTI_STACK__);
		} else if (!answer.contains(DEF__MONO_STACK__)){
			answer.add(DEF__MONO_STACK__);
		}
		
//		// DEFAULT KERNEL
		if (false) {
			boolean found = false;
			for (int i = 0; i < kernel_types.length; i++) {
				if (!answer.contains(kernel_types[i])) {
					found = true;
					break;
				}
			}
			
			if (!found) {
				answer.add(IWritersKeywords.FP);
			}
		} 
		

		/***********************************************************************
		 *  Check basic conflicts between keywords
		 **********************************************************************/
		if (answer.contains(DEF__MONO_STACK__) && answer.contains(DEF__MULTI_STACK__)) {
			throw new OilCodeWriterException("Some cpu use MONO stack and some other use MULTI Stack: it's not valid.");
		}

		/***********************************************************************
         * MULTI_CPU
         **********************************************************************/
		if (getRtosSize() > 1) {
		    answer.add(DEF__MSRP__);
		    
		    // check spinlocks
		    if (existObject(IOilObjectList.SPINLOCK)) {
			    answer.add(DEF__USER_SPINLOCKS__);
		    }
		}
		
		/***********************************************************************
		 *
		 * Ask if some "writer" have new keywords to add
		 *  
		 **********************************************************************/
		{
			ISectionWriter[] writers = getWriters();

			// search keys
			for (int i = 0; i < writers.length; i++) {
				if (writers[i] instanceof IExtractKeywordsExtentions) {
					((IExtractKeywordsExtentions) writers[i]).updateKeywords(answer, rtosPrefix);
				}
			}
		}

		
		
		return (String[]) answer.toArray(new String[0]);
	}
	
	
	/**
	 * This method searchs all Oil Objects of a specific category for a specific
	 * rtos. All valid categories are listed in
	 * {@link IOilObjectList IOilObjectList}.
	 * 
	 * @param type
	 *            identifies the type of Object
	 * @param prefix
	 *            identifies the rtos
	 * 
	 * @return all Oil Objects (of given type) for the specific rtos
	 * 
	 * @throws OilCodeWriterException
	 *             throw this exception if there are some problems
	 */
	protected ISimpleGenRes[] extractObject(int type, String prefix)
			throws OilCodeWriterException {
		
		// a shortcut
		final DataPackage DPKG = DataPackage.eINSTANCE;

		// First asks super class to extract all objects ...
		ISimpleGenRes[] answer = super.extractObject(type, prefix);
		
		// ... then add some properties to OS object
		switch (type) {
			/* OS */
			case IOilObjectList.OS:
			for (int i=0; i<answer.length; i++) {
				/*******************************************************************
				 * CPU TYPE
				 ******************************************************************/
				String currentRtosPrefix = answer[i].getPath() + S
						+ (new OilPath(OilObjectType.OS, null)).getPath();
				ArrayList<String> cpu_paths = new ArrayList<String>();
				ArrayList<String> hw_types = new ArrayList<String>();
				getOsCpuData(currentRtosPrefix, hw_types, cpu_paths);
				ISimpleGenRes current = answer[i]; 
				String hw_type = null;
				for (int child_id = 0; hw_type == null && child_id < cpu_paths.size(); child_id++ ) { 
					hw_type = hw_types.get(child_id);
					
					if (hw_type != null) {
						current.setProperty(ISimpleGenResKeywords.OS_CPU_TYPE, hw_type);
					
					CpuHwDescription cpuDescr = EECpuDescriptionManager.getHWDescription(hw_type);
					if (cpuDescr != null) {
							current.setObject(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR, cpuDescr);
							current.setObject(ISimpleGenResKeywords.OS_CPU_COMMENT_MANAGER, cpuDescr.commentManager);
					} else {
							current.removeAProperty(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR);
							hw_type = null;
						}
					}
				}
				current.setProperty(ISimpleGenResKeywords.OS_CPU_NAME,
						getOSName(current));
				
				{
				    current.setObject(SGRK_OS_CPU_DATA_PREFIX, cpu_paths);
					}
				
				{
					// cpu speed
					IVarTreePointer vtp = vt.newVarTreePointer();
					boolean ok = vtp.goAbsolute(current.getPath());
					ok &= vtp.goParent();
					ok &= vtp.go(DPKG.getCpu_Speed().getName());
					if (ok) {
						IVariable v = vtp.getVar();
						if (v != null && v.get() != null) {
							String speedt = v.toString();
							if (!speedt.isEmpty() && !(""+null).equals(speedt)) {
								double factor = 1000000;
								if (speedt.toLowerCase().contains("ghz")) {
									factor = 1000000000;
									speedt = speedt.toLowerCase().replace("ghz", "").trim();
								} else if (speedt.toLowerCase().contains("mhz")) {
									speedt = speedt.toLowerCase().replace("mhz", "").trim();
								} else if (speedt.toLowerCase().contains("khz")) {
									factor = 1000;
									speedt = speedt.toLowerCase().replace("khz", "").trim();
								} else if (speedt.toLowerCase().contains("hz")) {
									factor = 1;
									speedt = speedt.toLowerCase().replace("hz", "").trim();
								}
								double speed = 0;
								try {
									speed = Double.parseDouble(speedt);
								} catch (NumberFormatException e) {
									throw new OilCodeWriterException("Expected a real number as cpu speed", e);
								}
					
								current.setProperty(SGRK_OS_CPU_SPEED_HZ, "" + Math.round(speed*factor));
							}
						}
					}
				}
			}

			break;
			case IOilObjectList.TASK:
				/**
				 * Set, for each task an id that is stored as a property: TASK_SYS_ID.
				 * 
				 * also, remember all source files required by a task (if specified)
				 */
			{
				for (int i=0; i<answer.length; i++) {
					
					final String path = answer[i].getPath()
							+S+ (new OilPath(OilObjectType.TASK, null)).getPath();
					
					answer[i].setProperty(ISimpleGenResKeywords.TASK_SYS_ID, "" + i);
					
					{
						String[] src_files = CommonUtils.getValue(vt, path+"APP_SRC");
						if (src_files!= null && src_files.length > 0) {
							answer[i].setObject(ISimpleGenResKeywords.TASK_SRC_FILE_LIST, Arrays.asList(src_files));
						}

					}
				}
			}
	
			break;
			case IOilObjectList.COUNTER:
				/**
				 * Set, for each counter an id that is stored as a property : COUNTER_SYS_ID.
				 */
			{
				// reorder: first HW counters
				ArrayList<ISimpleGenRes> hw = new ArrayList<ISimpleGenRes>();
				ArrayList<ISimpleGenRes> sw = new ArrayList<ISimpleGenRes>();
				for (ISimpleGenRes sgr : answer) {
					final String path = sgr.getPath()
							+S+ (new OilPath(OilObjectType.COUNTER, null)).getPath();

					{ // get mapping between counter and CPU
						String[] child = new String[1];
						String counter_type = CommonUtils.getFirstChildEnumType(vt, path+"TYPE", child);
						
						if (ISimpleGenResKeywords.COUNTER_TYPE_HW.equals(counter_type)) {
							sgr.setObject(ISimpleGenResKeywords.COUNTER_TYPE, ISimpleGenResKeywords.COUNTER_TYPE_HW);

							final String hw_path = path+"TYPE"+VARIANT_ELIST+child[0] + PARAMETER_LIST;
							String[] device = CommonUtils.getValue(vt, hw_path + "DEVICE");
							
							if (device!= null && device.length > 0) {
								sgr.setObject(ISimpleGenResKeywords.COUNTER_DEVICE, device[0]);
							}
							
							String[] handler = CommonUtils.getValue(vt, hw_path + "HANDLER");
							
							if (handler!= null && handler.length > 0) {
								sgr.setObject(ISimpleGenResKeywords.COUNTER_USER_HANDLER, handler[0]);
							}
							
							{	// ----------- PRIORITY ------------
								String[] values = CommonUtils.getValue(vt, hw_path+"PRIORITY");
								if (values!= null && values.length >0) {
									sgr.setProperty(ISimpleGenResKeywords.COUNTER_ISR_PRIORITY, values[0]);
								}
							}
							
							
							String systimer = CommonUtils.getFirstChildEnumType(vt, hw_path + "SYSTEM_TIMER");
							
							boolean first = false;
							if (systimer!= null && "true".equalsIgnoreCase(systimer)) {
								sgr.setObject(ISimpleGenResKeywords.COUNTER_SYSTIMER, Boolean.TRUE);
								first = true;
							}

							if (first) {
								hw.add(0, sgr);
							} else {
								hw.add(sgr);
							}
						} else {
							sgr.setObject(ISimpleGenResKeywords.COUNTER_TYPE, ISimpleGenResKeywords.COUNTER_TYPE_SW);
							sw.add(sgr);
						}
					}
				}
				
				if (hw.size()>0) {
					hw.addAll(sw);
					answer = (ISimpleGenRes[]) hw.toArray(new ISimpleGenRes[hw.size()]);
				}
				
				
				for (int i=0; i<answer.length; i++) {
					final String path = answer[i].getPath()
							+S+ (new OilPath(OilObjectType.COUNTER, null)).getPath();

					answer[i].setProperty(ISimpleGenResKeywords.COUNTER_SYS_ID, "" + i);

					{ // get mapping between counter and CPU
						String[] cpu_Id = CommonUtils.getValue(vt, path+"CPU_ID");
						
						if (cpu_Id!= null && cpu_Id.length > 0) {
							answer[i].setObject(ISimpleGenResKeywords.COUNTER_CPU_MAPPED_ID, cpu_Id[0]);
						} else {
							answer[i].setObject(ISimpleGenResKeywords.COUNTER_CPU_MAPPED_ID, DEFAULT_CPU_NAME);
						}
					}
					{ // get mapping between counter and CPU
						String[] spt = CommonUtils.getValue(vt, path+"SECONDSPERTICK");
						
						if (spt!= null && spt.length > 0) {

							double speed = 0;
							try {
								speed = Double.parseDouble(spt[0]);
							} catch (NumberFormatException e) {
								throw new OilCodeWriterException("Expected a real number as second per tick of counter "+answer[i].getName(), e);
							}
							answer[i].setObject(ISimpleGenResKeywords.COUNTER_SECONDPERTICK, Math.round(speed*1000000));
							answer[i].setObject(ISimpleGenResKeywords.COUNTER_NANOSECONDPERTICK, Math.round(speed*1000000000));
						}
					}
				}
			}
	
			break;
			case IOilObjectList.OSAPPLICATION:
			{
				for (int i=0; i<answer.length; i++) {
					final String path = answer[i].getPath()
							+S+ (new OilPath(OilObjectType.OSAPPLICATION, null)).getPath();
	
					{ // get mapping between counter and CPU
						String[] cpu_Id = CommonUtils.getValue(vt, path+"CPU_ID");
						
						if (cpu_Id!= null && cpu_Id.length > 0) {
							answer[i].setObject(ISimpleGenResKeywords.OS_APPL_CPU_MAPPED_ID, cpu_Id[0]);
						} else {
							answer[i].setObject(ISimpleGenResKeywords.OS_APPL_CPU_MAPPED_ID, DEFAULT_CPU_NAME);
						}
					}
				}
				
			}
			break;
			case IOilObjectList.SCHEDULE_TABLE:
			{
				for (int i=0; i<answer.length; i++) {
					final String path = answer[i].getPath()
							+S+ (new OilPath(OilObjectType.SCHEDULETABLE, null)).getPath();
	
					{ // get mapping between counter and CPU
						String[] cpu_Id = CommonUtils.getValue(vt, path+"CPU_ID");
						
						if (cpu_Id!= null && cpu_Id.length > 0) {
							answer[i].setObject(ISimpleGenResKeywords.SCHEDTABLE_CPU_MAPPED_ID, cpu_Id[0]);
						} else {
							answer[i].setObject(ISimpleGenResKeywords.SCHEDTABLE_CPU_MAPPED_ID, DEFAULT_CPU_NAME);
						}
					}
				}
				
			}
			break;
			case IOilObjectList.ALARM:
				/**
				 * Set, for each alarm an id that is stored as a property : ALARM_SYS_ID.
				 */
			{
				for (int i=0; i<answer.length; i++) {
					answer[i].setProperty(ISimpleGenResKeywords.ALARM_SYS_ID, "" + i);
				}
			}
	
			break;
		}
		return answer; 
	}
	
	/**
	 * After extract all OilObjects, filter Counters and Alarms 
	 */
	protected IOilObjectList[] extractObjects() throws OilCodeWriterException {
		
		// if (rtosPrefix.length > 1 ){
		{
			/*******************************************************************
			 * Search the cpu master
			 * 
			 * check always that exists and contains a valid value
			 ******************************************************************/
			final String key = "MASTER_CPU";
			String value = null;
			
			final String commonPrefix = S
					+ (new OilPath(OilObjectType.OS, null)).getPath();
		    for (int ri=0; ri<rtosPrefix.length; ri++) {
				String currentRtosPrefix = rtosPrefix[ri] +commonPrefix;
				
				// search all attribute inside current rtos
		        String[] tmp = CommonUtils.getValue(vt, currentRtosPrefix
						                              						+ S + key);
		        if (tmp != null) {
		        	if (tmp.length>1) {
		        		throw new OilCodeWriterException("Found more than one value for OS/"+key);
		        	}
		        	
		            // check if there is another value
		            if (value != null && !value.equals(tmp[0])) {
		            	throw new OilCodeWriterException("Found more than one value for OS/"+key);
		            }
		            
	                value = tmp[0];
		        }
		    }

		    // check if is required the default value
			if (value == null && getRtosSize() >1) {
					Messages.sendWarningNl("Not found any value for MASTER_CPU. Using default value.", null, "al;uyshdga;iosdu", null);
				value = IWritersKeywords.DEFAULT_CPU_NAME;
			} // else, if we have exactly one cpu, we set the master cpu to this cpu (in the next loop)
			
			// check if the specified cpu exist
			int index = -1;
			String prefix_key = null;
//			final String dpkgRtosName = S+ DataPackage.eINSTANCE.getRtos_Name().getName();
		    for (int ri=0; ri<rtosPrefix.length && index==-1 ; ri++) {
		    	String name = null;

				ISimpleGenRes[] osList = super.extractObject(IOilObjectList.OS, rtosPrefix[ri]);
		    	
		    	if (osList != null && osList.length>0 && getOSName(osList[0])!= null) {
		    		name = getOSName(osList[0]);
		    	}
		    	
		    	if (value == null) {
		    		// set master cpu as the first one (and it should be also the only one)
		    		value = name; // note: name cannot be null !!		    		
		    	}
		    	
		    	if (value != null && value.equals(name)) {
		    		index = ri;
		    		prefix_key = rtosPrefix[ri];
		    	}
		    }		    		

		    if (value == null)  {
		    	// not found -> set index to 0
		    	index = 0;
		    	value = IWritersKeywords.DEFAULT_CPU_NAME;
		    }

		    // set current rtos as first
		    if (index == 0) {
		    	// do nothing
		    	
		    } else if (index!=-1) {
		    	// change the order of prefixs

	    		ArrayList<String> newRtosPrefix = new ArrayList<String>();
	    		newRtosPrefix.add(prefix_key);
	    		for (int i=0; i<rtosPrefix.length; i++) {
	    			if (index != i) {
			    		newRtosPrefix.add(rtosPrefix[i]);
	    			}
	    		}
	    		rtosPrefix = (String[]) newRtosPrefix.toArray(new String[newRtosPrefix.size()]);
	    		
		    } else {
		    	throw new OilCodeWriterException("Not found master cpu : " + value);
		    }
		}
		
		
		/***********************************************************************
		 * Call parent's method extractObjects()
		 **********************************************************************/
		

		IOilObjectList[] answer = super.extractObjects();

		/***********************************************************************
		 * Check and/or update CPU Descriptions
		 **********************************************************************/
		for (int i=0; i<answer.length; i++) {
			final IOilObjectList ool = answer[i];
			for (ISimpleGenRes sgrOs : ool.getList(IOilObjectList.OS)) {
				if (sgrOs.containsProperty(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR)) {
					CpuHwDescription descr = (CpuHwDescription) sgrOs
							.getObject(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR);
					if (descr != null && descr instanceof IRequiresUpdates) {
						((IRequiresUpdates) descr).update(this, vt, answer, i);
					}
				}
			}
		}
		
		/***********************************************************************
		 * 
		 * GetAll OsApplication.
		 * 
		 * Mapping between Cpu and Counter.
		 * 
		 * Mapping between Cpu and Alarm (using alarm's counter's map).
		 *  
		 **********************************************************************/
		Map<String, List<ISimpleGenRes>> osApplMap = new HashMap<String, List<ISimpleGenRes>>();
		for (IOilObjectList ool: answer) {
			for (ISimpleGenRes curr : ool.getList(IOilObjectList.OSAPPLICATION)) {
				
				String cpuId = curr.getString(ISimpleGenResKeywords.OS_APPL_CPU_MAPPED_ID);
				List<ISimpleGenRes> newList;
				if (osApplMap.containsKey(cpuId)) {
					newList = osApplMap.get(cpuId);
				} else {
					newList = new ArrayList<ISimpleGenRes>();
					osApplMap.put(cpuId, newList);
				}
				newList.add(curr);
			}
		}
		
		for (IOilObjectList ool: answer) {
			
			String cpuName = getOSName(ool);
			if (cpuName == null) {
				cpuName = DEFAULT_CPU_NAME;
			}
			
			/*
			 * Set OsApplications for current cpu  
			 */
			List<ISimpleGenRes> osApplications;
			if (osApplMap.containsKey(cpuName)) {
				osApplications = osApplMap.get(cpuName);
			} else {
				osApplications = new ArrayList<ISimpleGenRes>();
			}
			ool.setList(IOilObjectList.OSAPPLICATION,
					(ISimpleGenRes[]) osApplications.toArray(new ISimpleGenRes[osApplications
							.size()]));
			
			for (ISimpleGenRes curr : ool.getList(IOilObjectList.OSAPPLICATION)) {
				
				String cpuId = curr.getString(ISimpleGenResKeywords.OS_APPL_CPU_MAPPED_ID);
				List<ISimpleGenRes> newList;
				if (osApplMap.containsKey(cpuId)) {
					newList = osApplMap.get(cpuId);
				} else {
					newList = new ArrayList<ISimpleGenRes>();
					osApplMap.put(cpuId, newList);
				}
				newList.add(curr);
			}
			
			/*
			 * Remove counters not mapped to current cpu 
			 */
			List<ISimpleGenRes> counters = new ArrayList<ISimpleGenRes>(ool.getList(IOilObjectList.COUNTER));
			
			for (Iterator<ISimpleGenRes> iter = counters.iterator(); iter.hasNext(); ) {
				ISimpleGenRes curr = (ISimpleGenRes) iter.next();
				
				if (!cpuName.equals(curr.getString(ISimpleGenResKeywords.COUNTER_CPU_MAPPED_ID))) {
					iter.remove();
				}
			}
			
			// update ISimpleGenResKeywords.COUNTER_SYS_ID
			{ int id = 0;
				for (Iterator<ISimpleGenRes> iter = counters.iterator(); iter.hasNext(); ) {
					ISimpleGenRes curr = (ISimpleGenRes) iter.next();
					curr.setProperty(ISimpleGenResKeywords.COUNTER_SYS_ID, "" + id);
					id++;
				}
			}
			
			ool.setList(IOilObjectList.COUNTER,
					(ISimpleGenRes[]) counters.toArray(new ISimpleGenRes[counters
							.size()]));
			
			/*
			 * Remove alarms that uses counters not mapped to current cpu 
			 */
			List<ISimpleGenRes> alarms = new ArrayList<ISimpleGenRes>(ool.getList(IOilObjectList.ALARM));
			
			for (Iterator<ISimpleGenRes> iter = alarms.iterator(); iter.hasNext(); ) {
				ISimpleGenRes curr = (ISimpleGenRes) iter.next();
				
				String counterName = curr.getString(ISimpleGenResKeywords.ALARM_COUNTER);
				
				// search counter
				boolean search = true;
				for (int i=0; i<counters.size() && search; i++) {
					ISimpleGenRes counter = (ISimpleGenRes) counters.get(i);
					search = !counterName.equals(counter.getName());
				}
				
				if (search) {
					iter.remove();
				}
				
			}
			
			ool.setList(IOilObjectList.ALARM,
					(ISimpleGenRes[]) alarms.toArray(new ISimpleGenRes[alarms
							.size()]));
			

			/*
			 * Remove schedule tables not mapped to current cpu 
			 */
			List<ISimpleGenRes> schedTabl = new ArrayList<ISimpleGenRes>(ool.getList(IOilObjectList.SCHEDULE_TABLE));
			
			for (Iterator<ISimpleGenRes> iter = schedTabl.iterator(); iter.hasNext(); ) {
				ISimpleGenRes curr = (ISimpleGenRes) iter.next();
				
				if (!cpuName.equals(curr.getString(ISimpleGenResKeywords.SCHEDTABLE_CPU_MAPPED_ID))) {
					iter.remove();
				}
			}
			ool.setList(IOilObjectList.SCHEDULE_TABLE,
					(ISimpleGenRes[]) schedTabl.toArray(new ISimpleGenRes[schedTabl
							.size()]));
		}
		
		/***********************************************************************
		 * 
		 * Force Array generation (Alarm, Counters ...)
		 *  
		 **********************************************************************/
		 { 
			 for (IOilObjectList ool: answer) {
				 for (ISimpleGenRes rtos:ool.getList(IOilObjectList.OS)) {
	
				List<Integer> arrays;
				// NOTE : All cpus should work as this one
				if (false && // disabled  
						!checkKeyword(IWritersKeywords.CPU_S12)) { 
					arrays = Collections.unmodifiableList(
						Arrays.asList(new Integer[] {
								new Integer(IOilObjectList.ALARM),
								new Integer(IOilObjectList.APPMODE),
								new Integer(IOilObjectList.COUNTER),
								new Integer(IOilObjectList.RESOURCE),
								new Integer(IOilObjectList.TASK)
								})
						);
				
				} else {
					arrays = Collections.unmodifiableList(
							Arrays.asList(new Integer[0])
							);
					}
				
				rtos.setObject(SGRK__FORCE_ARRAYS_LIST__, arrays);
			}
		}
		}
	
		/***********************************************************************
		 * 
		 * Check and order Spin-locks
		 *  
		 **********************************************************************/
		 {
			 boolean enableNestedSpinlocks = false;
			 for (IOilObjectList ool: answer) {
				 boolean hasNext = false;
				 class SpinList {
					ISimpleGenRes spin;
					boolean hasPrev;
					SpinList next;
					/**
					 * 
					 */
					public SpinList(ISimpleGenRes o) {
						spin = o;
						next = null;
						hasPrev = false;
					}
				 };
				 
				 LinkedHashMap<String, SpinList> allSpins = new LinkedHashMap<String, SpinList>();
				 for (ISimpleGenRes spin : ool.getList(IOilObjectList.SPINLOCK)) {
					 allSpins.put(spin.getName(), new SpinList(spin));
					 if (spin.containsProperty(ISimpleGenResKeywords.SPINLOCK_NEXT)) {
						 hasNext = true;
					 }
				 }
				 if (hasNext) {
					 LinkedList<ISimpleGenRes> result = new LinkedList<ISimpleGenRes>();
					 enableNestedSpinlocks = true;
					 for (SpinList curr : allSpins.values()) {
						 int index = -1;
						 
						 if (curr.spin.containsProperty(ISimpleGenResKeywords.SPINLOCK_NEXT)) {
							 String next = curr.spin.getString(ISimpleGenResKeywords.SPINLOCK_NEXT);
							 if (!(allSpins.containsKey(next))) {
								 throw new OilCodeWriterException("The spinlock " + curr.spin.getName() + " points to a missing spinlock " + next);
							 }
							 if (next.equals(curr.spin.getName())) {
								 throw new OilCodeWriterException("The spinlock " + curr.spin.getName() + " points to a it self");
							 }
							 
							 SpinList nextElem = allSpins.get(next);
							 curr.next = nextElem;
							 nextElem.hasPrev = true;
							 // check cicles
							 for (SpinList iter = curr.next; iter != null; iter = iter.next) {
								 if (iter == curr) {
									 throw new OilCodeWriterException("Found a cicle on Spinlock Chain");
								 }
							 }
							 index = result.indexOf(nextElem.spin);
						 }
						 
						 if (index == -1) {
							 // addlast
							 result.addLast(curr.spin);
						 } else {
							 result.add(index, curr.spin);
						 }
					 }
					 ool.setList(IOilObjectList.SPINLOCK, result.toArray(new ISimpleGenRes[result.size()]));
				 }

			 }

			 if (enableNestedSpinlocks) {
				 for (IOilObjectList ool: answer) {
					 ool.getList(IOilObjectList.OS).get(0).setProperty(ISimpleGenResKeywords.OS_SPINLOCK_NESTED, "true");
				 }
			 }
		 }


		return answer;
	}
	
	/* (non-Javadoc)
	 * @see rtdruid.modules.oil.codewriter.crypted.AbstractRtosWriter#init(rtdruid.vartree.VarTree, java.lang.String[], java.util.HashMap)
	 */
	@SuppressWarnings("unchecked")
	public void init(IVarTree vt, String[] rtosPrefix, HashMap<String, ?> opt)
			throws OilCodeWriterException {
		super.init(vt, rtosPrefix, opt);

		
		/***********************************************************************
		 *
		 * Set Task's Priority and Remote attribute.
		 *  
		 **********************************************************************/
		if(!checkKeyword(IWritersKeywords.HR)) { 
			setIsrPriorities();
			setTaskPriorityAndRemote();
		}
		checkTimingProtection();
		
		/***********************************************************************
		 *
		 * Search other changes to Extracted Objects
		 *  
		 **********************************************************************/
		{
			ISectionWriter[] writers = getWriters();

			// search keys
			for (int i = 0; i < writers.length; i++) {
				if (writers[i] instanceof IExtractObjectsExtentions && writers[i].enabled(keys)) {
					((IExtractObjectsExtentions) writers[i]).updateObjects();
				}
			}
		}

		
		/***********************************************************************
		 *
		 * Compute Resources and dispatch priorities of tasks
		 *  
		 **********************************************************************/
		{
			new ResourceList(vt, architecturalPrefix,
					oilHwRtosPrefix, oilObjects,
					checkKeyword(DEF__OS_HAS_USERESSCHEDULER__), !checkKeyword(QUEUED_SPINLOCK));
		}

		
		/***********************************************************************
		 *
		 * Set Task's Dispatch Priority, and then "drop" internal resources
		 *  
		 **********************************************************************/
		if(!checkKeyword(IWritersKeywords.HR)) {
			setTaskDispatchPriority();
			final int R_ID = IOilObjectList.RESOURCE;
			for (int i=0; i<oilObjects.length; i++) {
				
				oilObjects[i].setList(R_ID,
						filterResourceTypes(oilObjects[i].getList(R_ID)));
			}
			
			ResourceList.setResourceId(oilObjects);
		}
		
		
		/***********************************************************************
		 *
		 * Check if there are some remote notifications, and update keywords 
		 * (REQUIRES/CHECK Kernel's Keywords and USE_BINARY/SOURCE keywords)
		 *  
		 **********************************************************************/
		// lookForRemoteNotification(); Remote notification is a writer
		
		
		/***********************************************************************
		 * 
		 * Compute autostart (required by extract_EE_OPTIONS and by many
		 * writers)
		 *  
		 **********************************************************************/
		computeAutoStart();
		
	}
	
	
	/***************************************************************************
	 * Writers
	 **************************************************************************/
	
	

	/**
	 * This method write all ee_opt as define 
	 */
	public IOilWriterBuffer[] writeEEOptAsDefine() {
	    
	    final boolean buildDistr = checkKeyword(DEF__EE_BUILD_DISTRIBUTION__);
	    final String base = IWritersKeywords.INDENT + "#define ";
	    
		final int rtosNumber = oilObjects.length;
		IOilWriterBuffer[] answer = new IOilWriterBuffer[oilObjects.length];

		// for each rt-os, prepare a distrinct file
		for (int rtosId = 0; rtosId < rtosNumber; rtosId++) {

			answer[rtosId] = new OilWriterBuffer();
			final StringBuffer buffer = answer[rtosId].get(FILE_EE_CFG_H);

        	final ICommentWriter commentWriter = SectionWriter.getCommentWriter(oilObjects[rtosId], FileTypes.C);

			/*******************************************************************
			 * USER OPTIONS
			 ******************************************************************/
			{
			    buffer.append(commentWriter
						.writerBanner("User options"));
			    
				String[] options = extractEE_Opts(IGetEEOPTExtentions.EE_OPT_USER_ONLY, rtosId);
				for (int i=0; i<options.length; i++) {
				    buffer.append(base + options[i] + "\n");
				}
			}

			if (!buildDistr) {
				/*******************************************************************
				 * AUTOMATIC OPTIONS
				 ******************************************************************/
			    buffer.append(commentWriter
						.writerBanner("Automatic options"));
	
				String[] options = extractEE_Opts(EE_OPT_COMMON_AUTO_ONLY | EE_OPT_CPU_ONLY , rtosId);
				for (int i=0; i<options.length; i++) {
					if ("__NIOS2__".equals(options[i])) {
						buffer.append( IWritersKeywords.INDENT + "#ifndef " + options[i] + "\n" +
								base + options[i] + "\n" +
								IWritersKeywords.INDENT + "#endif\n\n");
					} else {
						buffer.append(base + options[i] + "\n\n");
					}
				}
			}
		}	    
	    
	    return answer;
	}

	
	/**
	 * This method extract all EE_options from the current tree.
	 * 
	 * @param type
	 *            is a bits field, used to enable only some kind of options (see
	 *            EE_OPT_xxxx)
	 * @param rtos
	 *            if >= 0, is used to specify that options are computed for that
	 *            rtos
	 * 
	 * @return all found options 
	 */
	public String[] extractEE_Opts(int type, int rtosId) {
		final boolean useBinaryDistr = checkKeyword(DEF__EE_USE_BINARY_DISTRIBUTION__);//(type & EE_OPT_USE_BINARY_DISTR) != 0;
		final boolean genBinaryDistr = checkKeyword(DEF__EE_BUILD_DISTRIBUTION__);
		final boolean forEESignature = false; //(type & EE_OPT_FOR_SIGNATURE) != 0;

		if (useBinaryDistr && genBinaryDistr) {
			throw new RuntimeException("Cannot exctract options for 'use' binary distribution" +
					" and 'generate' binary distristribution at the same time.");
		}
	    LinkedList<String> answer = new LinkedList<String>();
	    IOilObjectList ool = rtosId >= 0 ? oilObjects[rtosId] : null;
	    
		/*******************************************************************
		 * USER OPTIONS
		 ******************************************************************/
		if ((type & IGetEEOPTExtentions.EE_OPT_USER_ONLY) != 0) {
			
			HashMap<String, ArrayList<String>> map = getRtosCommonAttributes(new String[] {"EE_OPT"});
			ArrayList<String> values = (ArrayList<String>) map.get("EE_OPT");
			if (values != null) {
				for (int i = 0; i < values.size(); i++) {
					String tmp = (String) values.get(i);
					boolean write = true;
					if (forEESignature || genBinaryDistr) {
						// check if it's a valid option
						for (int oo =0; write && oo<INVALID_SIGNATURE_OPTIONS.length; oo++) {
							write = !(INVALID_SIGNATURE_OPTIONS[oo].equals(tmp));
						}
					}
					
					check_valid_eeopt(tmp);
					
					if (write) {
						answer.add(tmp);
					}
				}

				
			}
		}

//		if (!genBinaryDistr && (type & EE_OPT_COMMON_AUTO_ONLY) != 0) {
		if ((type & EE_OPT_COMMON_AUTO_ONLY) != 0) {
			/*******************************************************************
			 * AUTOMATIC OPTIONS (not CPU DEPENDENT)
			 ******************************************************************/

			{ // Extract options from current keywords
				String[][] fromKeywords = new String[][] {
						// -------- HOST OS --------
						{ IEEWriterKeywords.DEF_HOST_OS_CYGWIN, "__RTD_CYGWIN__" },
						{ IEEWriterKeywords.DEF_HOST_OS_LINUX, "__RTD_LINUX__" },
						
						// -------- HW -------------
						{ IWritersKeywords.CPU_JANUS, "__JANUS__" },
						{ IWritersKeywords.CPU_PIC_30, "__PIC30__" },
						{ IWritersKeywords.CPU_MPC5xx, "__MPC5XX__ __MPC566EVB__" },
						{ IWritersKeywords.CPU_AVR5, "__AVR5__ __ATMEGA128__" },

						// -------- MULTI CPU -------------
						{ DEF__MSRP__, "__MSRP__" },

						// -------- STARTUP -------------
						{ DEF__CUSTOM_STARTUP_CODE__, DEF__CUSTOM_STARTUP_CODE__ },

				};

				for (int i = 0; i < fromKeywords.length; i++) {
					if (checkKeyword(fromKeywords[i][0])) {
					    String[] splitted = fromKeywords[i][1].split(" ");
					    for (int l=0; l<splitted.length; l++) {
					        answer.add(splitted[l]);
					    }
					}
				}
				
				if ("true".equals(getOsProperty(oilObjects[0], ISimpleGenResKeywords.OS_SPINLOCK_NESTED))) {
					answer.add("EE_SPINLOCK_ORDERED");
				}
			}

			/*******************************************************************
			 * AUTOMATIC OPTIONS (not CPU DEPENDENT)
			 ******************************************************************/
			if (ool != null) {
				List<Object> all = getOsObjects(ool, ISimpleGenResKeywords.OS_CPU_COMMON_EE_OPTS);
				for (Object o : all) {
				    String[] splitted = (String[]) o;
				    for (int l=0; l<splitted.length; l++) {
				        if (!answer.contains(splitted[l])) {
				            answer.add(splitted[l]);
				        }
				    }
				}
			} else {
				for (int i=0; i<oilObjects.length; i++) {
					List<Object> all = getOsObjects(oilObjects[i], ISimpleGenResKeywords.OS_CPU_COMMON_EE_OPTS);
					for (Object o : all) {
					    String[] splitted = (String[]) o;
					    for (int l=0; l<splitted.length; l++) {
					        if (!answer.contains(splitted[l])) {
					            answer.add(splitted[l]);
					        }
					    }
					}
				}
			}
		}


		if (ool != null && (type & EE_OPT_CPU_ONLY) != 0) {
			/*******************************************************************
			 * AUTOMATIC OPTIONS (not CPU DEPENDENT)
			 ******************************************************************/
			List<Object> all = getOsObjects(ool, ISimpleGenResKeywords.OS_CPU_EE_OPTS);
			for (Object o : all) {
				String[] splitted = (String[]) o;
				    for (int l=0; l<splitted.length; l++) {
				        if (!answer.contains(splitted[l])) {
				            answer.add(splitted[l]);
				        }
				    }
				}
		}
		
		{
			/*
			 * Writer options
			 */
			ISectionWriter[] writers = getWriters();
			for (int i = 0; i < writers.length; i++) {
				if (writers[i] instanceof IGetEEOPTExtentions && writers[i].enabled(keys)) {
					List<String> opts = ((IGetEEOPTExtentions) writers[i]).getEEOpt(type, rtosId);
					for (String s : opts) {
				        if (!answer.contains(s)) {
				            answer.add(s);
				        }
				    }
				}
			}
		}
		
		
	    return (String[]) answer.toArray(new String[answer.size()]);
	}

	public String[] extractUserOptions(int currentRtosId) {
		return extractEE_Opts(EE_OPT_USER_ONLY, currentRtosId);
	}

	
	private void check_valid_eeopt(String tmp) {
		boolean valid = tmp != null && tmp.length()>0 && tmp.length()<63;
		
		if (valid) {
			
			valid &= Character.isLetter(tmp.charAt(0)) || tmp.charAt(0) == '_';
			
			for (int i=1; i<tmp.length() && valid; i++) {
				valid &= Character.isLetterOrDigit(tmp.charAt(i)) || tmp.charAt(i) == '_';
			}
		}
		
		if (!valid) {
			Messages.sendWarningNl("The ee_opt " + tmp + " contains not valid characters. It should be a symbol.", null, "eeopt", null);
		}
	}

	/**
     * This method searchs all specified attributes inside (direct) children of all oil OS objects.
     * 
     * @param keys
     *            a list that contains all names of all attributes
     * 
     * @return an HashMap with all found properties, stored as
     *         ArrayList(Strings)
     *  
     */
	public HashMap<String, ArrayList<String>> getRtosCommonAttributes(String[] keys) {
	    HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
	    
	    // check all availables rtos
	    for (int ri=0; ri<rtosPrefix.length; ri++) {
			String currentRtosPrefix = rtosPrefix[ri] + S
					+ (new OilPath(OilObjectType.OS, null)).getPath();
			
			// search all attribute inside current rtos
			for (int i=0; i<keys.length; i++) { 
				
		        String[] tmp = CommonUtils.getValue(vt, currentRtosPrefix
					                              						+ S + keys[i]);
		        if (tmp != null && tmp.length>0) {
		            // get the rigth array
		            ArrayList<String> values = (ArrayList<String>) answer.get(keys[i]);
		            if (values == null) {
		                values = new ArrayList<String>();
		                answer.put(keys[i], values);
		            }
		            // add only new values
		            for (int j=0; j<tmp.length; j++) {
			            if (!values.contains(tmp[j])) {
			                values.add( tmp[j] );
			            }
			        }
		        }
			}
	    }
	    
	    return answer;

	}
	
	/**
	 * This method searchs specified attribute inside (direct) children of all
	 * oil OS objects; the attribute must be an ENUM or a BOOLEAN.
	 * 
	 * @param key
	 *            identifies the attribute
	 * 
	 * @return an String[] with all (distinct) values or an empty array if the attribute was not found (or doesn't have values)  
	 *  
	 */
	public String[] getRtosCommonChildType(String key) {
	    ArrayList<String> answer = new ArrayList<String>();
	    
	    // check all availables rtos
	    for (int ri=0; ri<rtosPrefix.length; ri++) {
			String currentRtosPrefix = rtosPrefix[ri] + S
					+ (new OilPath(OilObjectType.OS, null)).getPath();
			
			// search attribute inside current rtos
			
	        ArrayList<String> tmp = CommonUtils.getAllChildrenEnumType(vt, currentRtosPrefix
				                              						+ S + key, null);
	        if (tmp != null) {
	            // add only new values
	            for (int j=0; j<tmp.size(); j++) {
		            if (!answer.contains(tmp.get(j))) {
		            	answer.add( tmp.get(j) );
		            }
		        }
	        }
			
	    }
	    
	    return (String[]) answer.toArray(new String[answer.size()]);

	}
	
	/**
	 * This method searchs specified attribute inside (direct) children of all
	 * oil OS objects; the attribute must be an ENUM or a BOOLEAN.
	 * 
	 * @param key
	 *            identifies the attribute
	 * 
	 * @return an String[] with all (distinct) values or an empty array if the attribute was not found (or doesn't have values)  
	 *  
	 */
	public List<String> getRtosCommonChildType(IOilObjectList ool, String key) {
		return getRtosCommonChildType(ool, key, null);
	}

	/**
	 * 
	 * @param ool
	 * @param key
	 * @param child if not null, it will contain the full path of each child
	 * @return
	 */
	public List<String> getRtosCommonChildType(IOilObjectList ool, String key, List<String> child) {
		return getRtosCommonChildType(vt, ool, key, child);
	}
	public static List<String> getRtosCommonChildType(IVarTree vt, IOilObjectList ool, String key, List<String> child) {
	    ArrayList<String> answer = new ArrayList<String>();
	    if (child != null) {
	    	child.clear();
		}
	    
	    // check all availables rtos
	    for (ISimpleGenRes os: ool.getList(IOilObjectList.OS)) {
			String currentRtosPrefix = os.getPath() + S
					+ (new OilPath(OilObjectType.OS, null)).getPath();
			
			// search attribute inside current rtos
			String basePath = currentRtosPrefix + S + key;
			ArrayList<String> tmpC = new ArrayList<String>();
	        ArrayList<String> tmp = CommonUtils.getAllChildrenEnumType(vt, basePath, tmpC);
	        if (tmp != null) {
	            // add only new values
	            for (int j=0; j<tmp.size(); j++) {
	            	final String nValue = tmp.get(j);
	            	if (child != null) {
		            	final String cpath = basePath + VARIANT_ELIST+tmpC.get(j);
	            		if (!child.contains(cpath)) {
	            			answer.add( nValue );
		            		child.add(cpath);
		            	}
		            } else {
		            	if (!answer.contains(nValue)) {
	            			answer.add( nValue );
		            	}
		            }
		        }
	        }
			
	    }
	    
	    return answer;

	}
	/**
     * This method searchs all specified attributes inside (direct) children of all oil OS objects.
     * 
     * @param keys
     *            a list that contains all names of all attributes
     * 
     * @return an HashMap with all found properties, stored as
     *         ArrayList(Strings)
     *  
     */
	public ArrayList<String> getRtosCommonAttributes(IOilObjectList ool, String keys) {
		ArrayList<String> values = new ArrayList<String>();
	    
	    // check all availables rtos
	    for (ISimpleGenRes os: ool.getList(IOilObjectList.OS)) {
			String currentRtosPrefix = os.getPath() + S
					+ (new OilPath(OilObjectType.OS, null)).getPath();
				
	        String[] tmp = CommonUtils.getValue(vt, currentRtosPrefix
				                              						+ S + keys);
	        if (tmp != null && tmp.length>0) {
	            // add only new values
	            for (int j=0; j<tmp.length; j++) {
		            if (!values.contains(tmp[j]) && tmp[j] != null) {
		                values.add( tmp[j] );
		            }
		        }
	        }
	    }
	    return values;
	}

	/***************************************************************************
	 * Utilities
	 **************************************************************************/

	/**
	 * This method tries to set the current VarTree. If one was already set,
	 * just check that they are the same
	 * 
	 * @param vartree
	 *            the new VarTree
	 * 
	 * @throws IllegalArgumentException
	 *             if the specified VarTree is null or is different from the one
	 *             already stored (no problem if it wasn't set)
	 */
	public void check(IVarTree vartree) {
		if (vartree == null) {
			throw new IllegalArgumentException("Require a not null vartree");
		}
		if (vt == null) {
			vt = vartree;
		} else {
			if (vt != vartree) {
				throw new IllegalArgumentException("Work on differents Data");
			}
		}
	}

	/**
	 * Search inside the keywords, the kernel type
	 * 
	 * @return the kernel type
	 * 
	 * @throws OilCodeWriterException
	 *             if the keywordlist contains more than one Kernel Type
	 *             
	 * @deprecated da sistemare
	 */
	public String getKernelType() throws OilCodeWriterException {

		int typeIndex = -1;
		for (int i = 0; i < kernel_types.length; i++) {
			if (checkKeyword(kernel_types[i])) {
				if (typeIndex < 0) {
					typeIndex = i;
				} else {
					throw new OilCodeWriterException(
							"Specified more than one value for Kernel Type");
				}
			}
		}
		
		if (typeIndex < 0) {
			return null;
//			throw new OilCodeWriterException("No kernel type found");
		}

		return kernel_types[typeIndex];
	}

	/**
	 * This method searchs inside all Keywords for the current Stack Type. It
	 * can be MULTI Stack and MONO Stack.
	 * 
	 * @return MULTI, MONO or null if there isn't Stack Type
	 * 
	 * @throws OilCodeWriterException
	 *             if at the same time are set Mono and Multi Stack
	 */
	public String getStackType() throws OilCodeWriterException {

		String[] types = new String[] { DEF__MONO_STACK__, DEF__MULTI_STACK__ };

		int typeIndex = -1;
		for (int i = 0; i < types.length; i++) {
			if (checkKeyword(types[i])) {
				if (typeIndex < 0) {
					typeIndex = i;
				} else {
					throw new OilCodeWriterException(
							"The keyword list contains two distinct Stack Types");
				}

			}
		}

		return typeIndex < 0 ? null : types[typeIndex];
	}


	/**
	 * This methods check if at least one Task requires the autoStart.
	 * For each OS, it stores the answer as a Property of OS.  
	 */
	protected void computeAutoStart() {
		
		// DEFAULT VALUE
		final boolean force_alarm_autostart = options != null && 
			options.containsKey(IDistributionConstant.DEF__BINARY_DISTRIBUTION_FORCE_ALARM_AUTOSTART__);
		final boolean force_task_autostart = options != null &&
			options.containsKey(IDistributionConstant.DEF__BINARY_DISTRIBUTION_FORCE_TASK_AUTOSTART__);
		final boolean force_schedTab_autostart = options != null &&
				options.containsKey(IDistributionConstant.DEF__BINARY_DISTRIBUTION_FORCE_SCHED_TAB_AUTOSTART__);

		// check all rtos
		for (int cpuId = 0; cpuId < oilObjects.length; cpuId++) {

			// work on every os
			for (ISimpleGenRes os : oilObjects[cpuId].getList(
					IOilObjectList.OS)) {

			if (os.containsProperty(ISimpleGenResKeywords.OSEK_AUTOSTART)) {
				continue;
			}
			
			boolean autostart = false;
			if (!os.containsProperty(ISimpleGenResKeywords.OSEK_TASK_AUTOSTART)) {

				// --------- TASK -----------
				boolean taskAutostart = force_task_autostart;
				for (Iterator iter = oilObjects[cpuId].getList(
						IOilObjectList.TASK).iterator(); iter.hasNext()
						&& !taskAutostart;) {

					if (((ISimpleGenRes) iter.next())
							.containsProperty(ISimpleGenResKeywords.TASK_APPMODES_LIST)) {
						taskAutostart = true;
					}
				}
				autostart |= taskAutostart;

				os.setProperty(ISimpleGenResKeywords.OSEK_TASK_AUTOSTART, ""
						+ taskAutostart);
				
				// --------- SCHEDULE TABLE -----------
				boolean schedTabAutostart = force_schedTab_autostart;
				for (Iterator iter = oilObjects[cpuId].getList(
						IOilObjectList.SCHEDULE_TABLE).iterator(); iter.hasNext()
						&& !schedTabAutostart;) {

					if (((ISimpleGenRes) iter.next())
							.containsProperty(ISimpleGenResKeywords.SCHEDTABLE_AUTOSTART_APPMODES_LIST)) {
						schedTabAutostart = true;
					}
				}
				autostart |= schedTabAutostart;

				os.setProperty(ISimpleGenResKeywords.OSEK_SCHEDULE_TABLE_AUTOSTART, ""
						+ schedTabAutostart);
				
				// --------- ALARM -----------
				boolean forceAlarm = os.containsProperty(SGRK__FORCE_ARRAYS_LIST__) 
						&& ((List<Integer>) os.getObject(SGRK__FORCE_ARRAYS_LIST__)).contains(new Integer(IOilObjectList.ALARM));
					
				boolean alarmAutostart = force_alarm_autostart && (
						oilObjects[cpuId].getList(IOilObjectList.ALARM).size()>0
						|| forceAlarm
					);
				for (Iterator iter = oilObjects[cpuId].getList(
						IOilObjectList.ALARM).iterator(); iter.hasNext()
						&& !alarmAutostart;) {

					if (((ISimpleGenRes) iter.next())
							.containsProperty(ISimpleGenResKeywords.ALARM_AUTOSTART)) {
						alarmAutostart = true;
					}
				}
				autostart |= alarmAutostart;

				os.setProperty(ISimpleGenResKeywords.OSEK_ALARM_AUTOSTART, ""
						+ alarmAutostart);
			}
			
			os.setProperty(ISimpleGenResKeywords.OSEK_AUTOSTART, ""
					+ autostart);
			}
		}
	}

	/**
	 * This method set some properties of a Task: priorities and remote.
	 * 
	 * This method get the priority specified by user and tries to set a new
	 * priority (TASK_READY_PRIORITY), as Bit Field (as specified by Erika
	 * Enterpries). Bit 0 is the lower priority.
	 * 
	 */
	protected void setTaskPriorityAndRemote() throws OilCodeWriterException {

		/*
		 * Get OS/HAS_REMOTE_NOTIFICATION 
		 */
		final boolean useAlwaysRemoteTask;
		{
			final String str_ALWAYS = "ALWAYS";
			final String str_IFREQUIRED = "IFREQUIRED";
			
			
			String[] values = getRtosCommonChildType("USEREMOTETASK");
			if (values.length == 0 ) {
				useAlwaysRemoteTask = false; // TODO: default value
				
			} else if (values.length >1) {
				throw new OilCodeWriterException("OS/USEREMOTETASK is setted with different values");
				
			} else if (str_ALWAYS.equals(values[0])) {
				useAlwaysRemoteTask = true;
				
			} else if (str_IFREQUIRED.equals(values[0])) {
				useAlwaysRemoteTask = false;
				
			} else {

					throw new OilCodeWriterException("Only " + str_ALWAYS + " and " 
							+ str_IFREQUIRED + " are valid values for OS/USEREMOTETASK.\n"
							+"\tFound "+values[0]);
			}
		}
			
		/***********************************************************************
		 * Compute values
		 **********************************************************************/
		/*
		 * look on each task and set
		 * TASK_READY_PRIORITY and TASK_REMOTE
		 */
		for (int i = 0; i < oilObjects.length; i++) {
			

		/* 
		 * Search all defined priorities on each CPU (sorted)
		 */
			ArrayList<Integer> prioPres = new ArrayList<Integer>();
			for (Iterator<ISimpleGenRes> iter = oilObjects[i].getList(IOilObjectList.TASK)
					.iterator(); iter.hasNext();) {
				ISimpleGenRes curr = (ISimpleGenRes) iter.next();

				// search max ready priority
				int tmp_priority = curr
						.getInt(ISimpleGenResKeywords.TASK_PRIORITY);
				{// store the priority (if not already stored)
					int pos = Collections.binarySearch(prioPres,
							new Integer(tmp_priority));
					if (pos < 0) { // not found
						prioPres.add(-pos - 1, new Integer(tmp_priority));
				}
			}
		}


			int max_ready_priority = 0;

			for (Iterator<ISimpleGenRes> iter = oilObjects[i].getList(IOilObjectList.TASK)
					.iterator(); iter.hasNext();) {
				ISimpleGenRes curr = (ISimpleGenRes) iter.next();

				int tmp_priority;
				{// set the right bit as priority of this task
					Integer integer_priority = new Integer(curr
							.getInt(ISimpleGenResKeywords.TASK_PRIORITY));
					int prioVal = Collections.binarySearch(prioPres,
							integer_priority);
					if (prioVal < 0) { // not found
						throw new Error("Why ???");
					}
					tmp_priority = 1 << prioVal;
					curr.setProperty(ISimpleGenResKeywords.TASK_READY_PRIORITY,
							"" + tmp_priority);
				}

				// search max ready priority
				max_ready_priority = tmp_priority > max_ready_priority ? tmp_priority
						: max_ready_priority;

				/*
				 * TASK REMOTE 
				 * 
				 * (only if there are more than one cpu)
				 */
				if (oilObjects.length>1) {
					if (useAlwaysRemoteTask) {
						
						// enable Remote Notification without checks
						curr.setProperty(
								ISimpleGenResKeywords.TASK_REMOTE,
								"" + true);
						
					} else {
						
						// ----------- TASK's LINKED parameter ------------
						// search if current task is linked to another one, and, if
						// that task is on another cpu, set it as remote 
						String path = curr.getPath() + S
								+ (new OilPath(OilObjectType.TASK, null)).getPath();
						String[] values = CommonUtils.getValue(vt, path + "LINKED");
						if (values != null && values.length > 0) {
	
							// search for all linked tasks
							for (int linkNum = 0; linkNum < values.length; linkNum++) {
								if (values[linkNum].equals(curr.getName())) {
									throw new RuntimeException(
											"A task is linked to itself\n\tTask ="
													+ curr.getName());
								}
	
								boolean trovato = false;
								// search on all tasks (check if exist and set
								// "remote")
								for (int h = 0; h < oilObjects.length; h++) {
	
									for (Iterator<ISimpleGenRes> iter2 = oilObjects[h].getList(
											IOilObjectList.TASK).iterator(); iter
											.hasNext();) {
										ISimpleGenRes currLink = (ISimpleGenRes) iter2
												.next();
										if (values[linkNum].equals(currLink
												.getName())) {
											trovato = true;
											if (h == i) {
												currLink
														.setProperty(
																ISimpleGenResKeywords.TASK_REMOTE,
																"" + true);
											}
										}
									}
								}
	
								// Not foud
								if (!trovato) {
									throw new RuntimeException(
											"Tried to link a task ("
													+ curr.getName()
													+ ") to a non-existent task ("
													+ values[linkNum] + ")");
								}
							}
						}
					} // end LINKED
	
				}
			}

			// ISR
			{
				if (useMultiplePriorities) {
					/* 
					 * Search all defined priorities on each CPU (sorted)
					 */
					ArrayList<Integer> isrPrioPres = new ArrayList<Integer>();
					for (ISimpleGenRes curr : oilObjects[i].getList(IOilObjectList.ISR)) {
	
						if (curr.containsProperty(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_VALUE)) {
							
							// check priority only for those isr that have resources
							String[] tRes;
							if (curr.containsProperty(ISimpleGenResKeywords.ISR_RESOURCE_LIST)) {
								tRes = (String[]) ((List) curr.getObject(ISimpleGenResKeywords.ISR_RESOURCE_LIST)).toArray(new String[0]);
							} else {
								tRes = new String[0];
							}
							if (tRes.length != 0) {
							
							
								// search max ready priority
								int tmp_priority = curr
										.getInt(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_VALUE);
								{// store the priority (if not already stored)
									int pos = Collections.binarySearch(isrPrioPres,
											new Integer(tmp_priority));
									if (pos < 0) { // not found
										isrPrioPres.add(-pos - 1, new Integer(tmp_priority));
									}
								}
							}
						}
					}
	
		
					for (ISimpleGenRes curr : oilObjects[i].getList(IOilObjectList.ISR)) {
		
						if (curr.containsProperty(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_VALUE)) {
							
							int tmp_priority;
							{// set the right bit as priority of this task
								Integer integer_priority = new Integer(curr
										.getInt(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_VALUE));
								int prioVal = Collections.binarySearch(isrPrioPres,
										integer_priority);
								if (prioVal >= 0) {
									tmp_priority = 1 << (prioPres.size() + prioVal);
									curr.setProperty(ISimpleGenResKeywords.ISR_READY_PRIORITY,
											"" + tmp_priority);
								}
							}
	
						}
					}
				} else {
					// set all ready priority to 2^(max_priority + 1)
					for (ISimpleGenRes curr : oilObjects[i].getList(IOilObjectList.ISR)) {
						
						if (curr.containsProperty(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_VALUE)) {
							
							int tmp_priority = 1 << (prioPres.size());
							curr.setProperty(ISimpleGenResKeywords.ISR_READY_PRIORITY,
									"" + tmp_priority);
	
						}
					}
				}
			}

		}
		
		/*
		 * Check if there is some alarm that send a remote notification to a task
		 */
		if (!useAlwaysRemoteTask && oilObjects.length>1) {
		
			for (int rtosId = 0; rtosId < oilObjects.length; rtosId++) {

				for (Iterator<ISimpleGenRes> iter = oilObjects[rtosId].getList(IOilObjectList.ALARM)
						.iterator(); iter.hasNext();) {
					ISimpleGenRes curr = (ISimpleGenRes) iter.next();
					
					String type = curr.getString(ISimpleGenResKeywords.ALARM_ACTION_TYPE);
					final String taskName;
					
					if (ISimpleGenResKeywords.ALARM_ACTIVATE_TASK.equals(type)) {
						taskName = curr.getString(ISimpleGenResKeywords.ALARM_ACTIVATE_TASK);
					} else if (ISimpleGenResKeywords.ALARM_SET_EVENT.equals(type)) {
						taskName = ((String[]) curr.getObject(ISimpleGenResKeywords.ALARM_SET_EVENT))[0];
					} else {
						taskName = null;
					}
					
					if (taskName != null) {
						// search the task
						boolean search = true;
						
						for (int i = 0; i < oilObjects.length && search; i++) {

							for (Iterator<ISimpleGenRes> iter2 = oilObjects[i].getList(IOilObjectList.TASK)
									.iterator(); iter2.hasNext() && search;) {
								ISimpleGenRes task = (ISimpleGenRes) iter2.next();
								if (taskName.equals(task.getName())) {
									search = false;
									if (rtosId != i) {
										task.setProperty(ISimpleGenResKeywords.TASK_REMOTE, ""+true);
									}
								}
							}
						}
						
						if (search) {
							throw new OilCodeWriterException("Wrong task name for this Alarm."
									+ " (Alarm = "
									+ curr.getName()
									+ ", task name = "
									+ taskName + ")");
						}
					}
					
				}
				
			}

		}

	}
	
	protected void setIsrPriorities() {
		
		for (IOilObjectList ool : parent.getOilObjects()) {
			
			CpuHwDescription cpuDescr = ErikaEnterpriseWriter.getCpuHwDescription(ool);
			final boolean packPriorities = cpuDescr == null ? true : cpuDescr.isPackIsrPriorities();
			final int startingPriority   = cpuDescr == null ? 0 : cpuDescr.getStartingIsrPriorities();
			
			ArrayList<Integer> isr1PrioPres = new ArrayList<Integer>();
			ArrayList<Integer> isr2PrioPres = new ArrayList<Integer>();

			for (ISimpleGenRes sgr: ool.getList(IOilObjectList.ISR)) {
				boolean trap = sgr.containsProperty(ISimpleGenResKeywords.ISR_TRAP) ? ((Boolean) sgr.getObject(ISimpleGenResKeywords.ISR_TRAP)).booleanValue() : false;
				if (!trap) {
					String category = sgr.containsProperty(ISimpleGenResKeywords.ISR_CATEGORY) ? sgr.getString(ISimpleGenResKeywords.ISR_CATEGORY) : "";
					
					ArrayList<Integer> priorities = null;
					final boolean oneOrTwo;
					if ("1".equals(category)) {
						priorities = isr1PrioPres;
						oneOrTwo = true;
					} else if ("2".equals(category)) {
						priorities = isr2PrioPres;
						oneOrTwo = true;
					} else {
						oneOrTwo = false;
					}
					
					if (oneOrTwo) {
						// priority
						if (sgr.containsProperty(ISimpleGenResKeywords.ISR_USER_PRIORITY)) {
							// search max ready priority
							int tmp_priority = sgr.getInt(ISimpleGenResKeywords.ISR_USER_PRIORITY);
							{// store the priority (if not already stored)
								int pos = Collections.binarySearch(priorities,
										new Integer(tmp_priority));
								if (pos < 0) { // not found
									priorities.add(-pos - 1, new Integer(tmp_priority));
								}
							}
						}
					}
				}
			
			}
			
			for (ISimpleGenRes sgr: ool.getList(IOilObjectList.COUNTER)) {
				if (sgr.containsProperty(ISimpleGenResKeywords.COUNTER_TYPE) && 
						ISimpleGenResKeywords.COUNTER_TYPE_HW.equalsIgnoreCase(sgr.getString(ISimpleGenResKeywords.COUNTER_TYPE))) {
					
					Integer tmp_priority = getCounterPrio(sgr, cpuDescr);
					if (tmp_priority != null ){// store the priority (if not already stored)
						int pos = Collections.binarySearch(isr2PrioPres,
								tmp_priority);
						if (pos < 0) { // not found
							isr2PrioPres.add(-pos - 1, tmp_priority);
						}
					}
				}
			}
			
			
			if (isr1PrioPres.size()>0 && isr2PrioPres.size() >0){
				int min_isr1_prio = isr1PrioPres.get(0);
				int max_isr2_prio = isr2PrioPres.get(isr2PrioPres.size()-1);
				
				if (min_isr1_prio<=max_isr2_prio) {
					Messages.sendWarningNl("All isr1 priorities should be bigger than isr2 priorities.");
				}
			}
			
			
			final int isr1Base = isr2PrioPres.size()+1;
			
			for (ISimpleGenRes sgr: ool.getList(IOilObjectList.ISR)) {
				boolean trap = sgr.containsProperty(ISimpleGenResKeywords.ISR_TRAP) ? ((Boolean) sgr.getObject(ISimpleGenResKeywords.ISR_TRAP)).booleanValue() : false;
				if (!trap) {
	
					String category = sgr.containsProperty(ISimpleGenResKeywords.ISR_CATEGORY) ? sgr.getString(ISimpleGenResKeywords.ISR_CATEGORY) : "";
					
					int base = 1;
					ArrayList<Integer> priorities = null;
					if ("1".equals(category)) {
						priorities = isr1PrioPres;
						base = packPriorities ? isr1Base : 0;
					} else if ("2".equals(category)) {
						priorities = isr2PrioPres;
						base = packPriorities ? 1 : 0;
					}
					
					if (priorities != null && sgr.containsProperty(ISimpleGenResKeywords.ISR_USER_PRIORITY)) {
								
						Integer integer_priority = new Integer(sgr.getInt(ISimpleGenResKeywords.ISR_USER_PRIORITY));
						int prioVal = packPriorities ? Collections.binarySearch(priorities, integer_priority) : integer_priority.intValue();
						if (prioVal >= 0) {
							prioVal+= base+startingPriority; // values starting from 1 (not 0)
							sgr.setProperty(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_VALUE, "" + prioVal);
							sgr.setProperty(ISimpleGenResKeywords.ISR_GENERATED_PRIORITY_STRING, "EE_ISR_PRI_" + prioVal);
						}
					}
				}
			}
			
			for (ISimpleGenRes sgr: ool.getList(IOilObjectList.COUNTER)) {
				if (sgr.containsProperty(ISimpleGenResKeywords.COUNTER_TYPE) && 
						ISimpleGenResKeywords.COUNTER_TYPE_HW.equalsIgnoreCase(sgr.getString(ISimpleGenResKeywords.COUNTER_TYPE))) {
					Integer integer_priority = getCounterPrio(sgr, cpuDescr);

					if (integer_priority != null) {
						int prioVal = packPriorities ? Collections.binarySearch(isr2PrioPres, integer_priority) : integer_priority.intValue();
						if (prioVal >= 0) {
							prioVal+=packPriorities ? 1 : 0;; // values starting from 1 (not 0)
							sgr.setProperty(ISimpleGenResKeywords.COUNTER_GENERATED_PRIORITY_VALUE, "" + prioVal);
							sgr.setProperty(ISimpleGenResKeywords.COUNTER_GENERATED_PRIORITY_STRING, "EE_ISR_PRI_" + prioVal);
						}
					}
				}
			}
			
			if (isr2PrioPres.size()>0) {
				ool.getList(IOilObjectList.OS).get(0).setProperty(ISimpleGenResKeywords.OS_ADD_IRQH, "true");
			}
		}
	}

	
	protected void checkTimingProtection() {
		
		for (IOilObjectList ool : parent.getOilObjects()) {

			boolean hasTimingProtection = false;
			for (ISimpleGenRes sgr: ool.getList(IOilObjectList.TASK)) {
				if (sgr.containsProperty(ISimpleGenResKeywords.TASK_TIMING_PROTECTION) && "true".equalsIgnoreCase(sgr.getString(ISimpleGenResKeywords.TASK_TIMING_PROTECTION))) {
					hasTimingProtection = true;
					break;
				}
			}

			if (!hasTimingProtection) {
				for (ISimpleGenRes sgr: ool.getList(IOilObjectList.ISR)) {
					if (sgr.containsProperty(ISimpleGenResKeywords.ISR_TIMING_PROTECTION) && "true".equalsIgnoreCase(sgr.getString(ISimpleGenResKeywords.ISR_TIMING_PROTECTION))) {
						hasTimingProtection = true;
						break;
					}
				}	
			}
			
			for (ISimpleGenRes os : ool.getList(
					IOilObjectList.OS)) {
				
				os.setProperty(ISimpleGenResKeywords.OS_HAS_TIMING_PPROTECTION, ""
						+ hasTimingProtection);
			}
		}
	}

	
	/**
	 * @param sgr
	 * @param cpuDescr
	 * @return
	 */
	private Integer getCounterPrio(ISimpleGenRes sgr, CpuHwDescription cpuDescr) {
		String deviceId = sgr.containsProperty(ISimpleGenResKeywords.COUNTER_DEVICE) ? sgr.getString(ISimpleGenResKeywords.COUNTER_DEVICE) : null;
		CpuHwDescription.McuCounterDevice device = cpuDescr == null ? null : cpuDescr.getMcuDevice(deviceId);
		// priority
		Integer integer_priority = device == null ? null : device.getPrio();
		if (sgr.containsProperty(ISimpleGenResKeywords.COUNTER_ISR_PRIORITY)) {
			// search max ready priority
			integer_priority = sgr.getInt(ISimpleGenResKeywords.COUNTER_ISR_PRIORITY);
		}
		return integer_priority;
	}
	
	
	/**
	 * Set the Dispatch priority (TASK_DISPATCH_PRIORITY) of each task.
	 * <br>
	 * For a <b>non preemtable task</b>, the dispatch priority is the greatest priority for its cpu.
	 * <br>
	 * For a <b>preemtable task with internal resources</b>, the dispatch priority is the greatest
	 * priority of its internal resources.
	 * <br>
	 * For a <b>preemtable task without internal resources</b>, the dispatch priority is equalt to
	 * its priority.
	 */
	protected void setTaskDispatchPriority() {

		for (int cpuId = 0; cpuId < oilObjects.length; cpuId++) {

			List<ISimpleGenRes> taskList = oilObjects[cpuId].getList(IOilObjectList.TASK);
			List<ISimpleGenRes> resList  = oilObjects[cpuId].getList(IOilObjectList.RESOURCE);
			
			/*******************************************************************
			 * compute max priority
			 ******************************************************************/
			int max_ready_priority = 0;
			for (Iterator<ISimpleGenRes> iter = taskList.iterator(); iter.hasNext();) {
				ISimpleGenRes curr = (ISimpleGenRes) iter.next();
				
				// get task priority
				int tmp_priority = curr.getInt(ISimpleGenResKeywords.TASK_READY_PRIORITY);
				
				// search max ready priority
				max_ready_priority = tmp_priority > max_ready_priority ? tmp_priority
						: max_ready_priority;
			}
			

			/*******************************************************************
			 * Set dispatch Priority
			 ******************************************************************/
			for (Iterator<ISimpleGenRes> iter = taskList.iterator(); iter.hasNext(); ) {

				ISimpleGenRes currTask = (ISimpleGenRes) iter.next();
				
				// Is this task preemptable?
				final boolean preemptable = "FULL".equals(currTask.getString(ISimpleGenResKeywords.TASK_SCHEDULE));

				if (preemptable) {  // PREEMPTABLE !!
					/*
					 * If this task has resources, compute the max ceiling.
					 * 
					 * Doesn't check that a non preemptable task doesn't require
					 * an Internal Resource (checked when resources are
					 * computed)
					 */
					int max_ceiling = currTask.getInt(ISimpleGenResKeywords.TASK_READY_PRIORITY);
					if (currTask.containsProperty(ISimpleGenResKeywords.TASK_RESOURCE_LIST)) {
				
						ArrayList tRes = new ArrayList((List) currTask.getObject(ISimpleGenResKeywords.TASK_RESOURCE_LIST));
	
						Collections.sort(tRes);
						
	
						// check all resources
						for (Iterator<ISimpleGenRes> iterRes = resList.iterator(); tRes.size()!=0 && iterRes.hasNext(); ) {
							ISimpleGenRes curr = (ISimpleGenRes) iterRes.next();
							
							// use only Internal Resources required by this task
							if ((ISimpleGenResKeywords.RESOURCE_INTERNAL & curr.getInt(ISimpleGenResKeywords.RESOURCE_TYPE)) != 0
									&& Collections.binarySearch(tRes, curr.getName()) >= 0) {
								
								// get task priority
								int tmp_priority = curr.getInt(ISimpleGenResKeywords.RESOURCE_CEILING);
								
								// search max ready priority
								max_ceiling = tmp_priority > max_ceiling ? tmp_priority : max_ceiling;
							}
							
						}
					}
					
					currTask.setProperty(ISimpleGenResKeywords.TASK_DISPATCH_PRIORITY,
							"" + max_ceiling);


				} else { // NON PREEMPTABLE !!
					currTask.setProperty(ISimpleGenResKeywords.TASK_DISPATCH_PRIORITY,
							"" + max_ready_priority);
					
				}

			}
		}
		
	}

	//-----------------------------------------------------------------------

	
	
	/** This method get an Array of Strings and convert it into a String with all element separated by a specified separator */
	public static String arraysToString(ArrayList<String> input, String separator) {
	    if (input == null || input.size() == 0) {
	        return "";
	    }
	    StringBuffer answer = new StringBuffer(""+ input.get(0));
	    
	    for (int i=1; i<input.size(); i++) {
	        answer.append( separator + input.get(i));
	    }
	    return answer.toString();
	}
	
	/***/
	public static String getOSName(ISimpleGenRes cpu) {
		return cpu.containsProperty(ISimpleGenResKeywords.OS_CPU_NAME) ?
				cpu.getString(ISimpleGenResKeywords.OS_CPU_NAME)
				: DataPath.resolveId(DataPath.removeSlash(cpu.getName()))[0];
	}
	public static String getOSName(IOilObjectList cpus) {
		return getOSName(cpus.getList(IOilObjectList.OS).get(0));
	}

	
	/**
	 * Extract from list of resources, only STANDARD and LINKED RESOURCES that
	 * are root of theirs groups/chains.
	 * 
	 * NB: SimpleGenRes aren't cloned.
	 * 
	 * @param resList
	 *            a list of SimpleGenRes that contains all resources (this
	 *            method doesnt change it)
	 */
	protected ArrayList filterResourceTypes(final List resList) {
		ArrayList answer = new ArrayList();
		
		for (Iterator iter = resList.iterator(); iter.hasNext();) {
			ISimpleGenRes curr = (ISimpleGenRes) iter.next();

			int type = curr.getInt(ISimpleGenResKeywords.RESOURCE_TYPE);
			if ((type & ISimpleGenResKeywords.RESOURCE_INTERNAL) == 0) {
//			if ((type & ISimpleGenResKeywords.RESOURCE_CHAIN_ROOT) != 0
//					& !((type & ISimpleGenResKeywords.RESOURCE_INTERNAL) != 0)) {
				answer.add(curr);
			}
		}
		
		return answer;
	}
	
	
	

	
	/**
	 * This method corrects definitions of shared structures
	 * 
	 * UPDRTD DA SPOSTRE
	 * @deprecated DA SPOSTARE
	 */
	public String sharedData(String dataName, String array, Boolean rom) {
		if (array == null) {
			array = "";
		}
		
		if (checkKeyword(IWritersKeywords.CPU_NIOSII)) {
			return "EE_SHARED_DATA("+dataName+")"+array+ 
				(rom != null ? (rom.booleanValue() ? " EE_ONCHIPROM" : " EE_ONCHIPRAM") : "");
		}
		
		// default
		return dataName+array;
	}
	/**
	 * This method returns a string that define macro used to share data among
	 * cpus. It also sets a property inside the OS of OilObjectList[0] that
	 * remember that the macro was already defined inside a file.
	 * 
	 * @param fileID identifies a common file
	 * 
	 * @return a string that contains macros, or empty if macros were already defined
	 * 
	 * UPDRTD DA SPOSTRE
	 * @deprecated DA SPOSTARE
	 */
	public String addCommonDataMacro(String fileID) {
		/** A property */
		final String COMMON_MACRO_DEFINED_LIST = "common_macro_defined_file_list";
		
		final Properties defined;
		
		{
			List<Object> all = getOsObjects(oilObjects[0], COMMON_MACRO_DEFINED_LIST);
			if (all.size()>0) {
				for (Object o: all) {
					if (((Properties) o).containsKey(fileID)) {
				return "";
			}
					
				}
				defined = (Properties) all.get(0);
			} else {
				defined = null;
			}
		}
		// else
		
		String sharedROM = ""; //__attribute__ ((section (\".onchip_rom_common\")))\n"
		String sharedRAM = ""; //__attribute__ ((section (\".onchip_ram_common\")))\n"

		{ // read values from VarTree
			final String ROM = "MP_SHARED_ROM";
			final String RAM = "MP_SHARED_RAM";
			
			HashMap<String, ArrayList<String>> tmp = getRtosCommonAttributes(new String[] {ROM, RAM});
			
			if (tmp.containsKey(ROM)) {
				sharedROM = (String) ((ArrayList<String>) tmp.get(ROM)).get(0);
			}
			if (tmp.containsKey(RAM)) {
				sharedRAM = (String) ((ArrayList<String>) tmp.get(RAM)).get(0);
			}
		}

		
		String answer = "";
		// search macros for current cpu type
		if (checkKeyword(IWritersKeywords.CPU_NIOSII)) {
			answer = "#ifndef EE_ONCHIPROM\n"
				+ "#define EE_ONCHIPROM "+sharedROM+"\n" 
				+ "#endif\n"
				+ "#ifndef EE_ONCHIPRAM\n"
				+ "#define EE_ONCHIPRAM "+sharedRAM+"\n"
				+ "#endif\n";
		}
		
		// remember that the macros are added
		if (defined != null) {
			defined.setProperty(fileID, answer);
		} else {
			Properties newDefined = new Properties();
			newDefined.setProperty(fileID, answer);
			oilObjects[0].getList(IOilObjectList.OS).get(0).setObject(COMMON_MACRO_DEFINED_LIST, newDefined);
		}
		

		return answer;
	}

	/**
	 * Builds a new path composed by
	 * <code>rtosPrefix/OilVar/OS/OilHwPrefix</code>
	 */
	public String computeOilRtosPrefix(String rtosPrefix) {
		
		return rtosPrefix + S
				+ (new OilPath(OilObjectType.OS, null)).getPath();

	}


	/**
	 * This little method searchs the max id (+1) inside a list of Resources (SimpleGenRes)
	 * 
	 * @param resourceList a list of SimpleGenRes that contains some Resources
	 * 
	 * @return 0 if the list was empty, or 1+ the maximum id of all given resources 
	 * */
	public int computeMaxResource(List<ISimpleGenRes> resourceList) {
		int answer = -1;
		
		for (ISimpleGenRes res : resourceList) {

			int currentId = res.getInt(ISimpleGenResKeywords.RESOURCE_SYS_ID);
			
			answer = Math.max(answer, currentId);
		}
		
		return answer+1;
	}

	/**
	 * Returns the Distribution name of specified cpu
	 * 
	 *  @deprecated controllare ...
	 * */
	public String getDistributionName(ISimpleGenRes cpu, int rtosId) {
		final String distrVarName;
//		if (cpu.containsProperty(SGRK__EE_SIGNATURE__)) {
//			distrVarName = ((IEESignature) cpu.getObject(SGRK__EE_SIGNATURE__)).getName();
//    		
//    	} else 
    	if (options.containsKey(IDistributionConstant.DEF__EE_USE_BINARY_DISTRIBUTION__)) {
    		distrVarName = "" + options.get(IDistributionConstant.DEF__EE_USE_BINARY_DISTRIBUTION__);
    	} else {
		
			distrVarName = options.containsKey(IDistributionConstant.DEF__EE_DISTRIBUTION_NAME__) ?
					(String) options.get(IDistributionConstant.DEF__EE_DISTRIBUTION_NAME__) :  "RTDRUID_DIST"+rtosId;
    	}
		
		return distrVarName;
	}

	/**
	 * Adds a path to each buffer if there is more than one cpu. Default type is "cpu#"
	 * 
	 * @param buffers
	 *            all buffers
	 */
	protected void updateDirectories(IOilWriterBuffer[] buffers) {
		
		ArrayList<String> baseFiles = new ArrayList<String>();
		baseFiles.add("common.mk");
//		baseFiles.add("common.c");
//		baseFiles.add("common.h");
		baseFiles.add("makefile");
		
		
		if (buffers.length >1) {
			for (int i = 0; i<buffers.length; i++) {

	            String cpuName = ErikaEnterpriseWriter.getOSName(oilObjects[i]);
				
				IOilWriterBuffer buf = buffers[i];
				String[] buffIds = buf.getKeys();
				for (String buffId : buffIds) {
					if (!baseFiles.contains(buffId)) {
						buf.setFilePath(buffId, cpuName);
					}
				}
			}
		}
	}
	

	/**
	 * Adds a banner/header to each buffer
	 * 
	 * @param buffers
	 *            all buffers
	 */
	protected void writeBanners(IOilWriterBuffer[] buffers) {
		// as default : do nothing
		for (IOilWriterBuffer buffer: buffers) {
			
			for (String id : buffer.getKeys()) {
				if (id.endsWith(".h") || id.endsWith(".hpp")) {
					
					// ignore this file -> note: this should be done in a more clean way
					if ("cfg_e7t.h".equals(id)) {
						continue;
					}
					
					StringBuffer sb = buffer.get(id);
					if (sb.length()>0) {
						String def_id = getIncludeDefine(id);
						sb.insert(0,"#ifndef " +def_id +"\n" +
								"#define " +def_id +"\n\n");
						sb.append("\n\n#endif\n\n");
					}
				}
			}
			
		}
	}
	
	/**
	 * This method computes the symbol for a generic .h/.hpp file.
	 * The returned string is used to protect the file with ifndef ... define ... statements
	 *   
	 * @param id
	 * @return
	 */
	public static String getIncludeDefine(String id) {
		return id.replace('.', '_').replace(' ', '_').toUpperCase();
	}

	public String getEE_location() {
		return options.containsKey(IWritersKeywords.ERIKA_ENTERPRISE_LOCATION) ?
				(String) options.get(IWritersKeywords.ERIKA_ENTERPRISE_LOCATION) : EEPaths.getEe_base();
	}

	public boolean checkPragma(int currentRtosId) {
		String[] existing = parent.extractUserOptions(currentRtosId);
		
		for (String s: existing) {
			if ("USE_PRAGMAS".equals(s)) {
				return true;
			}
		}

		return false;
	}

	public boolean existObject(int objId) {
		IOilObjectList[] oList = getOilObjects();
		if (oList != null) {
			for (IOilObjectList list : oList) {
				if (list.getList(objId).size()>0) {
					return true;
				}
			}
		}
		
		// check directly in the tree
		for (String prefix : rtosPrefix) {
			try {
				if (extractObject(objId, prefix).length >0) {
					return true;
				}
			} catch (OilCodeWriterException e) {
				// do nothing
			}
		}
		
		
		return false;
	}

	
	public static CpuHwDescription getCpuHwDescription(IOilObjectList ool) {
		CpuHwDescription currentStackDescription = (CpuHwDescription) getOsObject(ool, ISimpleGenResKeywords.OS_CPU_DESCRIPTOR);
		if (currentStackDescription == null) {
			String cpuType = AbstractRtosWriter.getOsProperty(ool, ISimpleGenResKeywords.OS_CPU_TYPE);
			currentStackDescription = EECpuDescriptionManager.getHWDescription(cpuType); 
		}
		return currentStackDescription;
	}
	public static int getStackUnit(IOilObjectList ool) {
		CpuHwDescription currentStackDescription = getCpuHwDescription(ool);
		
		if (currentStackDescription != null) {
			return currentStackDescription.stackSize;
		} else {
			return 4;
		}
	}
	
	public static <T> T checkOrDefault(T value, T defaultValue) {
		return value == null ? defaultValue : value;
	}
	
	public static <T> T first(List<T> value) {
		return value == null  || value.isEmpty()? null: value.get(0);
}

	public String[] getCpuDataValue(IOilObjectList ool, String key) {
		String[] tmp = null;
		for (String currentCpuPrefix: AbstractRtosWriter.getOsProperties(ool, SGRK_OS_CPU_DATA_PREFIX)) {
			if (tmp != null) {
				break;
			}
			tmp = CommonUtils.getValue(vt, currentCpuPrefix + S + key);
			if (tmp != null && (tmp.length == 0 || tmp[0] == null)) {
				tmp = null;
			}
		}
		return tmp;
	}
	
	public List<String> getCpuDataEnum(IOilObjectList ool, String key) {
		ArrayList<String> answer = new ArrayList<String>();
		for (String currentCpuPrefix: AbstractRtosWriter.getOsProperties(ool, SGRK_OS_CPU_DATA_PREFIX)) {
			String tmp = CommonUtils.getFirstChildEnumType(vt, currentCpuPrefix + S + key);
			if (tmp != null) {
				answer.add(tmp);
			}
		}
		return answer;
	}
	
	
	private void getOsCpuData(String currentRtosPrefix, ArrayList<String> hw_types, ArrayList<String> paths) {
		hw_types.clear();
		paths.clear();
	
		ArrayList<String> child = new ArrayList<String>();
		ArrayList<String> tmp_types = CommonUtils.getAllChildrenEnumType(vt, currentRtosPrefix + "CPU_DATA", child);
		for (int child_id = 0; child_id < child.size(); child_id++ ) { 
			String hw_type = tmp_types.get(child_id);
			
			if (hw_type != null) {
				
				hw_types.add(hw_type);
				paths.add(currentRtosPrefix + "CPU_DATA" + VARIANT_ELIST + child.get(child_id) + PARAMETER_LIST);
			}
		}
	}
	
	public static String addVectorSizeDefine(IOilObjectList ool, String vectorName, int size) {
		String defineName = vectorName.toUpperCase() + "_SIZE";
		Map<String, Integer> list = (Map<String, Integer>) getOsObject(ool, SGRK_OS_CPU_VECTOR_SIZE_DEFINES);
		if (list == null) {
			list = new HashMap<String, Integer>();
			ool.getList(IOilObjectList.OS).get(0).setObject(SGRK_OS_CPU_VECTOR_SIZE_DEFINES, list);
		}
		if (!list.containsKey(defineName)) {
			list.put(defineName, new Integer(size));
		}
		
		return defineName;
	}

	/**
	 * @param ool
	 * @return
	 */
	public static int getIsr2Number(IOilObjectList ool) {
		String number1 = AbstractRtosWriter.getOsProperty(ool, ISimpleGenResKeywords.OS_CPU__ISR2_NUMBER);
		String number2 = AbstractRtosWriter.getOsProperty(ool, ISimpleGenResKeywords.OS_CPU__ISR2_ADDITIONAL_NUMBER);
		int number = 0;
		if (number1 != null) {
			try {
				number += Integer.parseInt(number1);
			} catch (NumberFormatException e) {}
		}
		if (number2 != null) {
			try {
				number += Integer.parseInt(number2);
			} catch (NumberFormatException e) {}
		}
		return number;
	}
	
	public static String addVectorSizeDefine(IOilObjectList[] ools, String vectorName, int size) {
		String defineName = vectorName.toUpperCase() + "_SIZE";
		for (IOilObjectList ool : ools) {
			Map<String, Integer> list = (Map<String, Integer>) getOsObject(ool, SGRK_OS_CPU_VECTOR_SIZE_DEFINES);
			if (list == null) {
				list = new HashMap<String, Integer>();
				ool.getList(IOilObjectList.OS).get(0).setObject(SGRK_OS_CPU_VECTOR_SIZE_DEFINES, list);
			}
			if (!list.containsKey(defineName)) {
				list.put(defineName, new Integer(size));
			}
		}
		return defineName;
	}
}
