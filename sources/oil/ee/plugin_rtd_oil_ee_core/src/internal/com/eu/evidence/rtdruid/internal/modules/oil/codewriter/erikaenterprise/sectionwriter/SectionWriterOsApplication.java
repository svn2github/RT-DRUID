/*
 * Created on 1-oct-2008
 *
 * $Id$
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.sectionwriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IOilXMLLabels;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStacks;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IRemoteNotificationsConstants;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.tools.Search;

/**
 * This writer manages OS Application
 * 
 * @author Nicola Serreli
 */
public class SectionWriterOsApplication extends SectionWriter implements
		IEEWriterKeywords, IRemoteNotificationsConstants,
		IExtractObjectsExtentions, IGetEEOPTExtentions,
		IExtractKeywordsExtentions {

	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;

	/** All data */
	protected final IVarTree vt;
	
	public final static String OS_APPLICATION_MEM_BASE = "SGR_os_application_mem_base";
	public final static String OS_APPLICATION_MEM_SIZE = "SGR_os_application_mem_size";
	public final static String OS_APPLICATION_SHARED_SIZE = "SGR_os_application_shared_size";
	public final static String OS_APPLICATION_IRQ_SIZE = "SGR_os_application_irq_size";
	
	public final static String EE_APPS_CONF = "apps.conf";
	
	
	protected final static String indent1 = IWritersKeywords.INDENT;
	protected final static String indent2 = IWritersKeywords.INDENT + IWritersKeywords.INDENT;
	protected final static String white = "                                        ";

	/**
	 * 
	 */
	public SectionWriterOsApplication() {
		this(null);
	}
	
	/**
	 * 
	 */
	public SectionWriterOsApplication(ErikaEnterpriseWriter parent) {
		super("OS_APPLICATION", new String[] {}, //
				new String[] {},
				SWCategoryManager.defaultInstance.newCategory(
						SWCategoryManager.TYPE_KERNEL,
						IWritersKeywords.KERNEL_MEMORY_PROTECTION_PRIORITY-1));
		
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
		return Collections.binarySearch(keywords, IWritersKeywords.KERNEL_OS_APPLICATION) >=0 ;
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
		
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		IOilWriterBuffer[] answer = new IOilWriterBuffer[oilObjects.length];
		for (int currentRtosId = 0; currentRtosId <oilObjects.length; currentRtosId++) {
			IOilWriterBuffer buff = new OilWriterBuffer();
			answer[currentRtosId] = buff;
			
			final IOilObjectList ool = oilObjects[currentRtosId];
			
			addOsApplications(ool, buff);
		}
		

		return answer;
	}

	protected void addOsApplications(IOilObjectList ool, IOilWriterBuffer answer) throws OilCodeWriterException {
		List<ISimpleGenRes> applications = ool.getList(IOilObjectList.OSAPPLICATION);
		ISimpleGenRes os = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);

		StringBuffer ee_h_buffer = answer.get(FILE_EE_CFG_H);
		final ICommentWriter commentWriterH = getCommentWriter(os, FileTypes.H);

		StringBuffer ee_c_buffer = answer.get(FILE_EE_CFG_C);
		final ICommentWriter commentWriterC = getCommentWriter(os, FileTypes.C);
		
		StringBuffer linker_buffer = answer.get(EE_APPS_CONF);

		// ee_cfg.h
		ee_h_buffer.append(
				commentWriterH.writerBanner("OS APPLICATIONS definition") +
				indent1 + "#define EE_MAX_APP " + applications.size() +"U\n\n"); 				

		// ee_cfg.c
		ee_c_buffer.append(
				commentWriterC.writerBanner("OS APPLICATIONS definition"));
		
		
				
		StringBuffer application_rom = new StringBuffer(
				indent1 + "const EE_as_Application_ROM_type EE_as_Application_ROM[EE_MAX_APP] = {\n");
		
		StringBuffer application_ram = new StringBuffer(
				indent1 + "EE_as_Application_RAM_type EE_as_Application_RAM[EE_MAX_APP+1U] = {\n" +
				indent2 + "EE_APP_RAM_INIT(0,0U),\n");
		
				
		String end = "";
		for (ISimpleGenRes application : applications) {
			boolean trusted = application.containsProperty(IEEWriterKeywords.OS_APPLICATION_TRUSTED) 
						&& "true".equalsIgnoreCase(application.getString(IEEWriterKeywords.OS_APPLICATION_TRUSTED));
			final String name = application.getName();
			String stack_id = application.getString(ISimpleGenResKeywords.OS_APPL_SHARED_STACK_ID);
			String stack_base_name = application.getString(EEStacks.STACK_BASE_NAME_PREFIX);
			
			String mem_base = application.getString(OS_APPLICATION_MEM_BASE);
			String mem_size = application.getString(OS_APPLICATION_MEM_SIZE);


			// ee_cfg.c
//			extern const int app0_start, app0_sstart, app0_end;
			
			ee_c_buffer.append(indent1 + "extern const int _load_data_"+name+";\n" +
					indent1 + "extern int _sdata_"+name+";\n" +
					indent1 + "extern int _sbss_"+name+";\n" +
					indent1 + "extern int _ebss_"+name+";\n");

			application_rom.append(end +
					indent2 + "{{ &_load_data_"+name+", &_sdata_"+name+", &_sbss_"+name+", &_ebss_"+name+" }}");

			application_ram.append(end +
					indent2 + "EE_APP_RAM_INIT(&"+stack_base_name+stack_id+"[EE_STACK_INITP(STACK_"+stack_id+"_SIZE)], "+
						(trusted ? "EE_MEMPROT_TRUST_MODE" : "EE_MEMPROT_USR_MODE") + ")");

			
			linker_buffer.append(
					name + 
					(name.length() < 30 ? white.substring(0, 30-name.length()) : "" ) + " " + 
					mem_base + " " +
					mem_size + " " +
					(trusted ? "1" : "0")+
					"\n");
			
			end = ",\n";
		}
		
		
		application_rom.append("\n" + indent1 +"};\n\n");
		application_ram.append("\n" + indent1 +"};\n\n");

		ee_c_buffer.append("\n" +
				application_rom + "\n" +
				application_ram);
		
		linker_buffer.append("\n");
		
		
		
		// Task to application link
		
		ee_c_buffer.append(indent1 + "const ApplicationType EE_th_app[EE_MAX_TASK+1] = {\n" +
				indent2 + "0");
		end = "\t"+commentWriterC.writerSingleLineComment("dummy");
		for (ISimpleGenRes task: ool.getList(IOilObjectList.TASK) ) {
			ee_c_buffer.append("," + end +
					indent2 + (task.getInt(ISimpleGenResKeywords.OS_APPL_ID) +1) );
			end = "\t"+commentWriterC.writerSingleLineComment(task.getName());
		}
		
		ee_c_buffer.append(" " + end + indent1 + "};\n\n");
		
	}

	
	@Override
	public void updateObjects() throws OilCodeWriterException {
		final IVarTree vt = parent.getVt();
		
		final String osApplBasePath = S
				+ DataPackage.eINSTANCE.getOsApplication_OilVar().getName() + S
				+ IOilXMLLabels.OBJ_OSAPPLICATION + parent.getOilHwRtosPrefix();

		final String path_trusted = osApplBasePath+ "TRUSTED";
		final String path_mem_base = osApplBasePath+ "MEMORY_BASE";
		final String path_mem_size = osApplBasePath+ "MEMORY_SIZE";
		final String path_mem_shared = osApplBasePath+ "SHARED_STACK_SIZE";
		final String path_mem_irq = osApplBasePath+ "IRQ_STACK_SIZE";
		
		final String path_alarm    = osApplBasePath+ "ALARM";
		final String path_counter  = osApplBasePath+ "COUNTER";
		final String path_isr      = osApplBasePath+ "ISR";
		final String path_resource = osApplBasePath+ "RESOURCE";
		final String path_task     = osApplBasePath+ "TASK";

		final String path_trusted_function = PARAMETER_LIST+ "TRUSTED_FUNCTION";


//		final String taskOsApplRefPath = S
//				+ DataPackage.eINSTANCE.getOsApplication_OilVar().getName() + S
//				+ IOilXMLLabels.OBJ_TASK + parent.getOilHwRtosPrefix() + "APPLICATION"; 
//
//	
//	final String isrOsApplRefPath = S
//				+ DataPackage.eINSTANCE.getOsApplication_OilVar().getName() + S
//				+ IOilXMLLabels.OBJ_ISR + parent.getOilHwRtosPrefix() + "APPLICATION";
	
		
		final IOilObjectList[] oilObjects = parent.getOilObjects();	
		for (IOilObjectList ool : oilObjects) {
			
			Map<String, ISimpleGenRes> map_alarm = getMap(ool.getList(IOilObjectList.ALARM));
			Map<String, ISimpleGenRes> map_counter = getMap(ool.getList(IOilObjectList.COUNTER));
			Map<String, ISimpleGenRes> map_isr = getMap(ool.getList(IOilObjectList.ISR));
			Map<String, ISimpleGenRes> map_resource = getMap(ool.getList(IOilObjectList.RESOURCE));
			Map<String, ISimpleGenRes> map_task = getMap(ool.getList(IOilObjectList.TASK));
			

			
			// OS applications
			int id = 0;
			List<ISimpleGenRes> applications = ool.getList(IOilObjectList.OSAPPLICATION);
			for (ISimpleGenRes appl : applications) {
				String appl_path = appl.getPath();
				String appl_name = appl.getName();
				
				
				appl.setProperty(ISimpleGenResKeywords.OS_APPL_ID, "" +id);
				
				String[] trusted_child = new String[1];
				String type = CommonUtils.getFirstChildEnumType(vt, appl_path + path_trusted, trusted_child);
				if ("true".equalsIgnoreCase(type)) {
					appl.setProperty(IEEWriterKeywords.OS_APPLICATION_TRUSTED, "true");
					ArrayList<String> childName = new ArrayList<String>();
					String trusted_func_path = appl_path + path_trusted + VARIANT_ELIST +  trusted_child[0] + path_trusted_function;
					
					ArrayList<String> trustedFunctionNames = new ArrayList<String>();
					
					ArrayList<String> childTypes = CommonUtils.getAllChildrenEnumType(vt, trusted_func_path, childName);
					if (childTypes != null) {
						for (int i=0; i<childTypes.size(); i++) {
							String ct = childTypes.get(i);
							if ("TRUE".equalsIgnoreCase(ct)) {
								String[] name = CommonUtils.getValue(vt, trusted_func_path + VARIANT_ELIST +  childName.get(i) + PARAMETER_LIST + "NAME");
								if (name != null && name.length>0) {
									for (String n: name) {
										trustedFunctionNames.add(n);
									}
								}
							}
						}
					}
					
					
					appl.setObject(IEEWriterKeywords.OS_APPLICATION_TRUSTED_FUNCTIONS, trustedFunctionNames);
					
				}
			
				{
					String[] val = CommonUtils.getValue(vt, appl_path + path_mem_base);
					if (val != null && val.length>0 && val[0] != null && val[0].length()>0) {
						
						try {
							Long.decode(val[0]);
						} catch (NumberFormatException e) {
							throw new OilCodeWriterException("OsApplication " + appl_name + " MEM_BASE is not a valid number");
						}
						
						appl.setProperty(OS_APPLICATION_MEM_BASE, val[0]);
					} else {
						throw new OilCodeWriterException("Required a mem base for OsApplication " + appl_name);
					}
				}
				{
					String[] val = CommonUtils.getValue(vt, appl_path + path_mem_size);
					if (val != null && val.length>0 && val[0] != null && val[0].length()>0) {
						
						try {
							Long.decode(val[0]);
						} catch (NumberFormatException e) {
							throw new OilCodeWriterException("OsApplication " + appl_name + " MEM_SIZE is not a valid number");
						}
						
						appl.setProperty(OS_APPLICATION_MEM_SIZE, val[0]);
					} else {
						throw new OilCodeWriterException("Required a mem size for OsApplication " + appl_name);
					}
				}
				{
					String[] val = CommonUtils.getValue(vt, appl_path + path_mem_shared);
					if (val != null && val.length>0 && val[0] != null && val[0].length()>0) {
						appl.setProperty(OS_APPLICATION_SHARED_SIZE, val[0]);
					}
				}
				{
					String[] val = CommonUtils.getValue(vt, appl_path + path_mem_irq);
					if (val != null && val.length>0 && val[0] != null && val[0].length()>0) {
						appl.setProperty(OS_APPLICATION_IRQ_SIZE, val[0]);
					}
				}
				
				{
					ArrayList<String> alarms = new ArrayList<String>();
					String[] values = CommonUtils.getValue(vt, appl_path + path_alarm);
					if (values != null) for (String val: values) {
						if (!map_alarm.containsKey(val)) {
							throw new OilCodeWriterException("Cannot resolve a reference from OsApplication " + appl_name + " to the alarm " + val);
						}
						if (add_appl_ref(map_alarm.get(val), ISimpleGenResKeywords.ALARM_OS_APPLICATION_NAME, appl_name, id)) {
							alarms.add(val);
						}
					}
					appl.setObject(ISimpleGenResKeywords.OS_APPL_LIST_REF_ALARM, alarms);
				}
				{
					ArrayList<String> counter = new ArrayList<String>();
					String[] values = CommonUtils.getValue(vt, appl_path + path_counter);
					if (values != null) for (String val: values) {
						if (!map_counter.containsKey(val)) {
							throw new OilCodeWriterException("Cannot resolve a reference from OsApplication " + appl_name + " to the counter " + val);
						}
						if (add_appl_ref(map_counter.get(val), ISimpleGenResKeywords.COUNTER_OS_APPLICATION_NAME, appl_name, id)) {
							counter.add(val);
						}
					}
					appl.setObject(ISimpleGenResKeywords.OS_APPL_LIST_REF_COUNTER, counter);
				}
				{
					ArrayList<String> isr = new ArrayList<String>();
					String[] values = CommonUtils.getValue(vt, appl_path + path_isr);
					if (values != null) for (String val: values) {
						if (!map_isr.containsKey(val)) {
							throw new OilCodeWriterException("Cannot resolve a reference from OsApplication " + appl_name + " to the isr " + val);
						}
						if (add_appl_ref(map_isr.get(val), ISimpleGenResKeywords.ISR_OS_APPLICATION_NAME, appl_name, id)) {
							isr.add(val);
						}
					}
					appl.setObject(ISimpleGenResKeywords.OS_APPL_LIST_REF_ISR, isr);
				}
				{
					ArrayList<String> resource = new ArrayList<String>();
					String[] values = CommonUtils.getValue(vt, appl_path + path_resource);
					if (values != null) for (String val: values) {
						if (!map_resource.containsKey(val)) {
							throw new OilCodeWriterException("Cannot resolve a reference from OsApplication " + appl_name + " to the resource " + val);
						}
						if (add_appl_ref(map_resource.get(val), ISimpleGenResKeywords.RESOURCE_OS_APPLICATION_NAME, appl_name, id)) {
							resource.add(val);
						}
					}
					appl.setObject(ISimpleGenResKeywords.OS_APPL_LIST_REF_RESOURCE, resource);
				}
				{
					ArrayList<String> task = new ArrayList<String>();
					String[] values = CommonUtils.getValue(vt, appl_path + path_task);
					if (values != null) for (String val: values) {
						if (!map_task.containsKey(val)) {
							throw new OilCodeWriterException("Cannot resolve a reference from OsApplication " + appl_name + " to the task " + val);
						}
						ISimpleGenRes sgr_task = map_task.get(val);
						if (add_appl_ref(sgr_task, ISimpleGenResKeywords.TASK_OS_APPLICATION_NAME, appl_name, id)) {
							task.add(val);
						}
					}
					appl.setObject(ISimpleGenResKeywords.OS_APPL_LIST_REF_TASK, task);
				}
				
				id++;
			}
			
			
			
			
//			/**** OLD CODE ***/
//			
//			// tasks
//			List<ISimpleGenRes> tasks = ool.getList(IOilObjectList.TASK);
//			for (ISimpleGenRes task : tasks) {
//			
//				String[] os_appl_ref = CommonUtils.getValue(vt, task.getPath() + taskOsApplRefPath);
//				if (os_appl_ref != null && os_appl_ref.length>0 && os_appl_ref[0] != null && os_appl_ref[0].length()>0) {
//					add_appl_ref(task, ISimpleGenResKeywords.TASK_OS_APPLICATION_NAME, os_appl_ref[0]);
//				}
//				
//			}
//
//			// isr
//			List<ISimpleGenRes> isrs = ool.getList(IOilObjectList.ISR);
//			int isr_id = 0;
//			for (ISimpleGenRes isr : isrs) {
//			
//				String[] os_appl_ref = CommonUtils.getValue(vt, isr.getPath() + isrOsApplRefPath);
//				if (os_appl_ref != null && os_appl_ref.length>0 && os_appl_ref[0] != null && os_appl_ref[0].length()>0) {
//					add_appl_ref(isr, ISimpleGenResKeywords.ISR_OS_APPLICATION_NAME, os_appl_ref[0]);
//				}
//
//				if (!isr.containsProperty(ISimpleGenResKeywords.ISR_ID)) {
//					isr.setProperty(ISimpleGenResKeywords.ISR_ID, ""+isr_id);
//					isr_id ++;
//				}
//
//			}
//
			
			if (applications.size() >0) {
				
				// check 
				List<String> not_map_alarm = new LinkedList<String>();
				List<String> not_map_counter = new LinkedList<String>();
				List<String> not_map_isr = new LinkedList<String>();
				List<String> not_map_resource = new LinkedList<String>();
				List<String> not_map_task = new LinkedList<String>();

				List<ISimpleGenRes> alarms = ool.getList(IOilObjectList.ALARM);
				for (ISimpleGenRes alarm : alarms) {
					if (!alarm.containsProperty(ISimpleGenResKeywords.OS_APPL_ID)) {
						not_map_alarm.add(alarm.getName());
					}
				}
				List<ISimpleGenRes> counters = ool.getList(IOilObjectList.COUNTER);
				for (ISimpleGenRes counter : counters) {
					if (!counter.containsProperty(ISimpleGenResKeywords.OS_APPL_ID)) {
						not_map_counter.add(counter.getName());
					}
				}
				List<ISimpleGenRes> isrs = ool.getList(IOilObjectList.ISR);
				for (ISimpleGenRes isr : isrs) {
					if (!isr.containsProperty(ISimpleGenResKeywords.OS_APPL_ID)) {
						not_map_isr.add(isr.getName());
					}
				}
				List<ISimpleGenRes> resources = ool.getList(IOilObjectList.RESOURCE);
				for (ISimpleGenRes resource : resources) {
					if (!resource.containsProperty(ISimpleGenResKeywords.OS_APPL_ID)) {
						not_map_resource.add(resource.getName());
					}
				}

				List<ISimpleGenRes> tasks = ool.getList(IOilObjectList.TASK);
				for (ISimpleGenRes task : tasks) {
					if (!task.containsProperty(ISimpleGenResKeywords.OS_APPL_ID)) {
						not_map_task.add(task.getName());
					}
				}
				
				StringBuffer buff = new StringBuffer();
				if (not_map_alarm.size()>0) {
					buff.append("Alarm not assigned to any OsApplication:");
					for (String s: not_map_alarm) {
						buff.append(" " + s );
					}
					buff.append("\n");
				}
				if (not_map_counter.size()>0) {
					buff.append("Counter not assigned to any OsApplication:");
					for (String s: not_map_counter) {
						buff.append(" " + s );
					}
					buff.append("\n");
				}
				if (not_map_isr.size()>0) {
					buff.append("Isr not assigned to any OsApplication:");
					for (String s: not_map_isr) {
						buff.append(" " + s );
					}
					buff.append("\n");
				}
				if (not_map_resource.size()>0) {
					buff.append("Resource not assigned to any OsApplication:");
					for (String s: not_map_resource) {
						buff.append(" " + s );
					}
					buff.append("\n");
				}
				if (not_map_task.size()>0) {
					buff.append("Task not assigned to any OsApplication:");
					for (String s: not_map_task) {
						buff.append(" " + s );
					}
					buff.append("\n");
				}
				
				if (buff.length()>0) {
					throw new OilCodeWriterException(buff.toString());					
				}
					
			}

			
		}
	}

	
	protected boolean add_appl_ref(ISimpleGenRes sgr, String pName, String os_appl_name, int id) throws OilCodeWriterException {
		if (sgr == null) {
			return false;
		}
		if (sgr.containsProperty(pName)) {
			if (!os_appl_name.equals(sgr.getObject(pName))) {
				throw new OilCodeWriterException(sgr.getName() + " is assigned to two distinct os applications ("
							+ os_appl_name + " and " + sgr.getObject(pName) +")");
			}
			return false;
		}
		sgr.setProperty(pName, os_appl_name);
		sgr.setProperty(ISimpleGenResKeywords.OS_APPL_ID, "" +id);

		return true;
	}
	
	protected Map<String, ISimpleGenRes> getMap(List<ISimpleGenRes> list) {
		Map<String, ISimpleGenRes> map = new HashMap<String, ISimpleGenRes>();
		for (ISimpleGenRes sgr: list) {
			map.put(sgr.getName(), sgr);
		}
		return map;
	}
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions#getEEOpt(int)
	 */
	public List<String> getEEOpt(int type, int rtosId) {
		List<String> answer = new ArrayList<String>();
		// nothing
		return answer;
	}

	@Override
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix)
			throws OilCodeWriterException {
		
		String[] osAppls = Search.allOsApplication(vt.newTreeInterface());
		if (osAppls != null && osAppls.length>0) {
			if (!keywords.contains(IWritersKeywords.KERNEL_OS_APPLICATION)) {
				keywords.add(IWritersKeywords.KERNEL_OS_APPLICATION);
			}
		}
	}	
	
	
}
