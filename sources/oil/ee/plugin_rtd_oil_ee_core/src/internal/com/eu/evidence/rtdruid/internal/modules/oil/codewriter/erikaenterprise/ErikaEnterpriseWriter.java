/*
 * Created on Dec 2, 2004
 *
 * $Id: ErikaEnterpriseWriter.java,v 1.30 2008/05/14 17:13:52 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import com.eu.evidence.modules.oil.erikaenterprise.constants.IDistributionConstant;
import com.eu.evidence.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions;
import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IOilXMLLabels;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.DefaultRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.HostOsUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.ResourceList;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EECpuDescriptionManager;
import com.eu.evidence.rtdruid.modules.oil.interfaces.ISectionWriter;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.data.init.DataPath;

/**
 * This class prepares all Configuration Files for Erika Enterprise RT-OS.
 * 
 * @author Nicola Serreli
 */
public class ErikaEnterpriseWriter extends DefaultRtosWriter implements IEEWriterKeywords {

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

	/** Prefix of cpu's data stored in each RT_OS */
	protected String[] cpuDataPrefix;

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
			HostOsUtils hostOs = HostOsUtils.common;
			if (hostOs.getCurrentSystem() == HostOsUtils.CYGWIN) {
				if (!answer.contains(IEEWriterKeywords.DEF_HOST_OS_CYGWIN)) {
					answer.add(IEEWriterKeywords.DEF_HOST_OS_CYGWIN);
				}
			} else if (hostOs.getCurrentSystem() == HostOsUtils.LINUX) {
				if (!answer.contains(IEEWriterKeywords.DEF_HOST_OS_LINUX)) {
					answer.add(IEEWriterKeywords.DEF_HOST_OS_LINUX);
				}
			}
			
		}

		cpuDataPrefix = new String[rtosPrefix.length];
		
		/**
		 * Use a specific Properties that check if the new value is already
		 * setted and they are the same.
		 */
		class MyProperties extends Properties {
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
		
		MyProperties checkKeys = new MyProperties();

		for (int rtodId=0; rtodId<rtosPrefix.length; rtodId++) {
			
			/** The prefix of all data about current cpu */
			String currentCpuDataPrefix = null;

			
			final String currentRtosPrefix = computeOilRtosPrefix(rtosPrefix[rtodId]);
			{
				/*******************************************************************
				 * CPU TYPE
				 ******************************************************************/
				// check only the first RTOS !!! (as rtos of CPU0)
				String[] child = new String[1];
				String hw_type = CommonUtils.getFirstChildEnumType(vt,
						currentRtosPrefix + "CPU_DATA", child);
				if (hw_type != null) {
					
					// check if the value is valid
					checkKeys.setOilProperty("CPU_DATA", hw_type);

					if (!answer.contains(hw_type)) {
						answer.add(hw_type);
					}
					currentCpuDataPrefix = currentRtosPrefix + "CPU_DATA"
							+ VARIANT_ELIST + child[0] + PARAMETER_LIST;
				}
			}
			cpuDataPrefix[rtodId] = currentCpuDataPrefix;
			
			
			if (currentCpuDataPrefix != null) {
				/*******************************************************************
				 * CPU PARAMETER (MULTI STACK)
				 ******************************************************************/
				String[] child = new String[1];
				String tmp = CommonUtils
						.getFirstChildEnumType(vt, currentCpuDataPrefix
								+ "MULTI_STACK", child);
	
				// TODO DEFAULT
				if (tmp == null) {
					tmp = "FALSE";
				}

				// check if the value is valid
				checkKeys.setOilProperty("MULTI_STACK", tmp);

				if ("TRUE".equalsIgnoreCase(tmp) && !answer.contains(DEF__MULTI_STACK__)) {
					answer.add(DEF__MULTI_STACK__);
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
					
				} else if ("FALSE".equalsIgnoreCase(tmp) && !answer.contains(DEF__MONO_STACK__)) {
					answer.add(DEF__MONO_STACK__); 
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
		} // end for
		
		
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
		if (rtosPrefix.length > 1) {
		    answer.add(DEF__MSRP__);
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
					+ DataPackage.eINSTANCE.getRtos_OilVar().getName() + S
					+ IOilXMLLabels.OBJ_OS + oilHwRtosPrefix;
				String[] child = new String[1];
				String hw_type = CommonUtils.getFirstChildEnumType(vt,
						currentRtosPrefix + "CPU_DATA", child);
				if (hw_type != null) {
					answer[i].setProperty(ISimpleGenResKeywords.OS_CPU_TYPE, hw_type);
					
					
					CpuHwDescription cpuDescr = EECpuDescriptionManager.getHWDescription(hw_type);
					if (cpuDescr != null) {
						answer[i].setObject(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR, cpuDescr);
						answer[i].setObject(ISimpleGenResKeywords.OS_CPU_COMMENT_MANAGER, cpuDescr.commentManager);
					} else {
						answer[i].removeAProperty(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR);
					}
				}
				answer[i].setProperty(ISimpleGenResKeywords.OS_CPU_NAME,
						getOSName(answer[i]));
				
				{
					String cpuPrefix = null;
					
					// search the rtosId
					for (int rtosId =0; rtosId<rtosPrefix.length && cpuPrefix == null; rtosId++) {
						if (prefix.equals(rtosPrefix[rtosId])) {
							cpuPrefix = cpuDataPrefix[rtosId];
						}
					}
					
					if (cpuPrefix != null) {
					    answer[i].setProperty(SGRK_OS_CPU_DATA_PREFIX, cpuPrefix);
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
							+S+ DPKG.getTask_OilVar().getName()
							+S+IOilXMLLabels.OBJ_TASK+oilHwRtosPrefix;
					
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
				for (int i=0; i<answer.length; i++) {
					final String path = answer[i].getPath()
							+S+ DPKG.getTask_OilVar().getName()
							+S+IOilXMLLabels.OBJ_COUNTER+oilHwRtosPrefix;

					
					answer[i].setProperty(ISimpleGenResKeywords.COUNTER_SYS_ID, "" + i);

					{ // get mapping between counter and CPU
						String[] cpu_Id = CommonUtils.getValue(vt, path+"CPU_ID");
						
						if (cpu_Id!= null && cpu_Id.length > 0) {
							answer[i].setObject(ISimpleGenResKeywords.COUNTER_CPU_MAPPED_ID, cpu_Id[0]);
						} else {
							answer[i].setObject(ISimpleGenResKeywords.COUNTER_CPU_MAPPED_ID, DEFAULT_CPU_NAME);
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
				+ DataPackage.eINSTANCE.getRtos_OilVar().getName() + S
				+ IOilXMLLabels.OBJ_OS + oilHwRtosPrefix;
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
			if (value == null) {
            	Messages.sendWarningNl("Not found any value for MASTER_CPU. Using default value.", null, "al;uyshdga;iosdu", null);
    		    // TODO : default value
				value = IWritersKeywords.DEFAULT_CPU_NAME;
			}
			
			
			// check if the specified cpu exist
			int index = -1;
//			final String dpkgRtosName = S+ DataPackage.eINSTANCE.getRtos_Name().getName();
		    for (int ri=0; ri<rtosPrefix.length && index==-1 ; ri++) {
		    	String name = IWritersKeywords.DEFAULT_CPU_NAME;

				ISimpleGenRes[] osList = super.extractObject(IOilObjectList.OS, rtosPrefix[ri]);
		    	
		    	if (osList != null && osList.length>0 && osList[0].getName()!= null) {
		    		name = getOSName(osList[0]);
		    	}
		    	
		    	if (value.equals(name)) {
		    		index = ri;
		    	}
		    }		    		

		    // set current rtos as first
		    if (index == 0) {
		    	// do nothing
		    	
		    } else if (index!=-1) {
		    	// move prefixs
	    		ArrayList<String> newCpuDataPrefix = new ArrayList<String>();
	    		newCpuDataPrefix.add(cpuDataPrefix[index]);

	    		ArrayList<String> newRtosPrefix = new ArrayList<String>();
	    		newRtosPrefix.add(rtosPrefix[index]);
	    		for (int i=0; i<rtosPrefix.length; i++) {
	    			if (index != i) {
			    		newRtosPrefix.add(rtosPrefix[i]);
			    		newCpuDataPrefix.add(cpuDataPrefix[i]);
	    			}
	    		}
	    		rtosPrefix = (String[]) newRtosPrefix.toArray(new String[newRtosPrefix.size()]);
	    		cpuDataPrefix = (String[]) newCpuDataPrefix.toArray(new String[newCpuDataPrefix.size()]);
	    		
		    } else {
		    	throw new OilCodeWriterException("Not found master cpu : " + value);
		    }
		}
		
		
		/***********************************************************************
		 * Call parent's method extractObjects()
		 **********************************************************************/
		

		IOilObjectList[] answer = super.extractObjects(); 
		
		/***********************************************************************
		 * 
		 * Mapping between Cpu and Counter.
		 * 
		 * Mapping between Cpu and Alarm (using alarm's counter's map).
		 *  
		 **********************************************************************/
		for (int rtosId =0; rtosId<answer.length; rtosId++) {
			
			ISimpleGenRes rtos = (ISimpleGenRes) answer[rtosId].getList(IOilObjectList.OS).get(0);
			String cpuName = getOSName(rtos);
			if (cpuName == null) {
				cpuName = DEFAULT_CPU_NAME;
			}
			
			/*
			 * Remove counters not mapped to current cpu 
			 */
			List<ISimpleGenRes> counters = new ArrayList<ISimpleGenRes>(answer[rtosId].getList(IOilObjectList.COUNTER));
			
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
			
			answer[rtosId].setList(IOilObjectList.COUNTER,
					(ISimpleGenRes[]) counters.toArray(new ISimpleGenRes[counters
							.size()]));
			
			/*
			 * Remove alarms that uses counters not mapped to current cpu 
			 */
			List<ISimpleGenRes> alarms = new ArrayList<ISimpleGenRes>(answer[rtosId].getList(IOilObjectList.ALARM));
			
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
			
			answer[rtosId].setList(IOilObjectList.ALARM,
					(ISimpleGenRes[]) alarms.toArray(new ISimpleGenRes[alarms
							.size()]));
			
		}
		
		/***********************************************************************
		 * 
		 * Force Array generation (Alarm, Counters ...)
		 *  
		 **********************************************************************/
		 { 
			for (int rtosId =0; rtosId<answer.length; rtosId++) {
				ISimpleGenRes rtos = (ISimpleGenRes) answer[rtosId].getList(IOilObjectList.OS).get(0);
	
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
		setTaskPriorityAndRemote();

		
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
					checkKeyword(DEF__OS_HAS_USERESSCHEDULER__));
		}

		
		/***********************************************************************
		 *
		 * Set Task's Dispatch Priority, and then "drop" internal resources
		 *  
		 **********************************************************************/
		{
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

        	final ISimpleGenRes sgrOs = oilObjects[rtosId].getList(IOilObjectList.OS).get(0);
        	final ICommentWriter commentWriter = SectionWriter.getCommentWriter(sgrOs, FileTypes.C);

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

				};

				for (int i = 0; i < fromKeywords.length; i++) {
					if (checkKeyword(fromKeywords[i][0])) {
					    String[] splitted = fromKeywords[i][1].split(" ");
					    for (int l=0; l<splitted.length; l++) {
					        answer.add(splitted[l]);
					    }
					}
				}
			}

			/*******************************************************************
			 * AUTOMATIC OPTIONS (not CPU DEPENDENT)
			 ******************************************************************/
			if (ool != null) {
			    ISimpleGenRes sgrCpu = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
				if (sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_COMMON_EE_OPTS)) {
				    String[] splitted = (String[]) sgrCpu.getObject(ISimpleGenResKeywords.OS_CPU_COMMON_EE_OPTS);
				    for (int l=0; l<splitted.length; l++) {
				        if (!answer.contains(splitted[l])) {
				            answer.add(splitted[l]);
				        }
				    }
				}
			} else {
				for (int i=0; i<oilObjects.length; i++) {
				    ISimpleGenRes sgrCpu = (ISimpleGenRes) oilObjects[i].getList(IOilObjectList.OS).get(0);
					if (sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_COMMON_EE_OPTS)) {
					    String[] splitted = (String[]) sgrCpu.getObject(ISimpleGenResKeywords.OS_CPU_COMMON_EE_OPTS);
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
		    ISimpleGenRes sgrCpu = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
			{ // CPU
				if (sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_EE_OPTS)) {
				    String[] splitted = (String[]) sgrCpu.getObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS);
				    for (int l=0; l<splitted.length; l++) {
				        if (!answer.contains(splitted[l])) {
				            answer.add(splitted[l]);
				        }
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
					+ DataPackage.eINSTANCE.getRtos_OilVar().getName() + S
					+ IOilXMLLabels.OBJ_OS + oilHwRtosPrefix;
			
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
					+ DataPackage.eINSTANCE.getRtos_OilVar().getName() + S
					+ IOilXMLLabels.OBJ_OS + oilHwRtosPrefix;
			
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

		// check all rtos
		for (int cpuId = 0; cpuId < oilObjects.length; cpuId++) {

			ISimpleGenRes os = (ISimpleGenRes) oilObjects[cpuId].getList(
					IOilObjectList.OS).get(0);

			if (os.containsProperty(ISimpleGenResKeywords.OSEK_AUTOSTART)) {
				continue;
			}
			
			boolean autostart = false;
			if (!os.containsProperty(ISimpleGenResKeywords.OSEK_TASK_AUTOSTART)) {

				// --------- TASK -----------
				boolean taskAutostart = force_alarm_autostart;
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
		 * Search all defined priorities on each CPU (sorted)
		 */
		ArrayList<Integer>[] prioPres = new ArrayList[oilObjects.length];
		for (int i = 0; i < oilObjects.length; i++) {
			prioPres[i] = new ArrayList<Integer>();
			for (Iterator<ISimpleGenRes> iter = oilObjects[i].getList(IOilObjectList.TASK)
					.iterator(); iter.hasNext();) {
				ISimpleGenRes curr = (ISimpleGenRes) iter.next();

				// search max ready priority
				int tmp_priority = curr
						.getInt(ISimpleGenResKeywords.TASK_PRIORITY);
				{// store the priority (if not already stored)
					int pos = Collections.binarySearch(prioPres[i],
							new Integer(tmp_priority));
					if (pos < 0) { // not found
						prioPres[i].add(-pos - 1, new Integer(tmp_priority));
					}
				}
			}
		}

		/*
		 * look on each task and set
		 * TASK_READY_PRIORITY and TASK_REMOTE
		 */
		for (int i = 0; i < oilObjects.length; i++) {

			int max_ready_priority = 0;

			for (Iterator<ISimpleGenRes> iter = oilObjects[i].getList(IOilObjectList.TASK)
					.iterator(); iter.hasNext();) {
				ISimpleGenRes curr = (ISimpleGenRes) iter.next();

				int tmp_priority;
				{// set the right bit as priority of this task
					Integer integer_priority = new Integer(curr
							.getInt(ISimpleGenResKeywords.TASK_PRIORITY));
					int prioVal = Collections.binarySearch(prioPres[i],
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
								+ DataPackage.eINSTANCE.getTask_OilVar() + S
								+ IOilXMLLabels.OBJ_TASK + oilHwRtosPrefix;
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
							if (ISimpleGenResKeywords.RESOURCE_INTERNAL == curr.getInt(ISimpleGenResKeywords.RESOURCE_TYPE)
									&& Collections.binarySearch(tRes, curr.getName()) >= 0) {
								
								// get task priority
								int tmp_priority = curr.getInt(ISimpleGenResKeywords.TASK_READY_PRIORITY);
								
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
			if ((type & ISimpleGenResKeywords.RESOURCE_CHAIN_ROOT) != 0
					& !((type & ISimpleGenResKeywords.RESOURCE_INTERNAL) != 0)) {
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
		
		Properties defined = null;
		ISimpleGenRes sgr = ((ISimpleGenRes) oilObjects[0].getList(IOilObjectList.OS).get(0));
		if (sgr.containsProperty(COMMON_MACRO_DEFINED_LIST)) {
			defined = (Properties) sgr.getObject(COMMON_MACRO_DEFINED_LIST);
			if (defined.containsKey(fileID)) {
				return "";
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
			defined = new Properties();
			defined.setProperty(fileID, answer);
			sgr.setObject(COMMON_MACRO_DEFINED_LIST, defined);
		}
		

		return answer;
	}

	/**
	 * Builds a new path composed by
	 * <code>rtosPrefix/OilVar/OS/OilHwPrefix</code>
	 */
	public String computeOilRtosPrefix(String rtosPrefix) {
		
		return rtosPrefix + S
				+ DataPackage.eINSTANCE.getRtos_OilVar().getName() + S
				+ IOilXMLLabels.OBJ_OS + oilHwRtosPrefix;

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
		
		for (Iterator<ISimpleGenRes> iter = resourceList.iterator(); iter.hasNext(); ) {
			ISimpleGenRes res = (ISimpleGenRes) iter.next();

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

	            ISimpleGenRes sgrCpu = (ISimpleGenRes) oilObjects[i].getList(IOilObjectList.OS).get(0);
	            String cpuName = ErikaEnterpriseWriter.getOSName(sgrCpu);
				
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
						String def_id = "__" + id.replace('.', '_').replace(' ', '_').toUpperCase() + "__";
						sb.insert(0,"#ifndef " +def_id +"\n" +
								"#define " +def_id +"\n\n");
						sb.append("#endif\n\n");
					}
				}
			}
			
		}
	}

}

