/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterMakefile.java,v 1.5 2008/01/09 17:43:32 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.sectionwriter;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.RtdruidConfiguratorNumber;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IDistributionConstant;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEoptConstant;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * This writer builds ee.h, and adds basic informations like number of tasks and
 * their name. Those informations are common for all Erika Kernels
 * 
 * @author Nicola Serreli
 */
public class SectionWriterCommonKernelDefs extends SectionWriter 
		implements IEEWriterKeywords, IEEoptConstant {
	
	private static final String EE_MAX_ISR2_WITH_RESOURCES = "EE_MAX_ISR2_WITH_RESOURCES";
	
	public final static boolean includeEE_opt_application = true;
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;

	/** All data */
	protected final IVarTree vt;
	
	/**
	 * 
	 */
	public SectionWriterCommonKernelDefs() {
		this(null);
	}
	/**
	 * 
	 */
	public SectionWriterCommonKernelDefs(ErikaEnterpriseWriter parent) {
		super("COMMON_KERNEL_DEFINITIONS", new String[] {}, //
				new String[] {},
				SWCategoryManager.defaultInstance.newCategory(SWCategoryManager.TYPE_INIT, 5));
		
		this.parent = parent;
		this.vt = parent == null ? null : parent.getVt();
	}

	/**
	 * This method returns true if current instance of writer is enabled with
	 * specified keywords.
	 * 
	 * @return true if this writer is enabled
	 */
	protected boolean enabled() {
		return true;
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

		return writeCommonDefinition();
	}
	
	/**
	 *  This method prepares base definition for Erika Kernels
	 * 
	 * @return buffers with kernel base definitions
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	@SuppressWarnings("unchecked")
	protected IOilWriterBuffer[] writeCommonDefinition() throws OilCodeWriterException {
		
		IOilObjectList[] oilObjects = parent.getOilObjects();

		final String indent = IWritersKeywords.INDENT;
		final int rtosNumber = oilObjects.length;
		IOilWriterBuffer[] answer = new IOilWriterBuffer[oilObjects.length];

		// set all "unset" masks
		setEventMask(oilObjects);	

		// check if this a binary distribution
		final boolean binaryDistr = parent.checkKeyword(IDistributionConstant.DEF__EE_USE_BINARY_DISTRIBUTION__);
		final boolean binaryDistrFull = binaryDistr && parent.checkKeyword(IDistributionConstant.DEF__EE_USE_BINARY_DISTRIBUTION_FULL__); 
		
		for (int rtosId = 0; rtosId < rtosNumber; rtosId++) {

			// ---------------- required ----------------

			IOilObjectList ool = oilObjects[rtosId];
			final ICommentWriter commentWriterC = getCommentWriter(ool, FileTypes.C);
			final ICommentWriter commentWriterH = getCommentWriter(ool, FileTypes.H);

			// ---------------- prepare buffer ----------------

			answer[rtosId] = new OilWriterBuffer();

			final StringBuffer buffer_c = answer[rtosId].get(FILE_EE_CFG_C);

			final StringBuffer buffer = answer[rtosId].get(FILE_EE_CFG_H);
			
			// ---------------- Configurator Number ----------------
			
			{
				String confNumber = RtdruidConfiguratorNumber.getRTDruidConfiguratorNumber();
				if (confNumber != null && confNumber.length()>0) {
					buffer.append("\n#define RTDRUID_CONFIGURATOR_NUMBER "+confNumber+"\n\n");
				}
			}
			
			buffer.append(commentWriterH.writerBanner("Common defines ( CPU "
					+ rtosId + " )"));


			// ---------------- fill buffer ----------------

			{
				/*
				 * ---------------- TASK ----------------
				 * 
				 * Define an Identifier for all Tasks.
				 * 
				 * Define MAX_TASK as number of Task
				 */
				List<ISimpleGenRes> taskList = ool.getList(IOilObjectList.TASK);

				buffer.append("\n" + indent + commentWriterH.writerSingleLineComment("TASK definition")); // \n");
				if (!binaryDistr) {
					buffer.append(indent + "#define EE_MAX_TASK " + taskList.size()
						+ "\n");
				} else if (binaryDistrFull) {
					buffer_c.append(indent + "const unsigned int EE_MAX_TASK = " + taskList.size()
							+ ";\n");
				}
				

				for (Iterator<ISimpleGenRes> iter = taskList.iterator(); iter.hasNext();) {
					ISimpleGenRes curr = (ISimpleGenRes) iter.next();
					buffer.append(indent + "#define " + curr.getName() + " "
							+ curr.getString(ISimpleGenResKeywords.TASK_SYS_ID)
							+ "\n");
				}
			}

			{
				/*
				 * ---------------- MUTEX ----------------
				 * 
				 * Define an Identifier for all Mutex.
				 * 
				 * Define MAX_RESOURCES as number of Mutex
				 */

				List<ISimpleGenRes> mutexList = ool.getList(IOilObjectList.RESOURCE);

				buffer.append("\n" + indent + commentWriterH.writerSingleLineComment("MUTEX definition")); // \n");
				if (!binaryDistr) {
					buffer.append(indent + "#define EE_MAX_RESOURCE "
						+ parent.computeMaxResource(mutexList) + "U\n");
				} else if (binaryDistrFull) {
					buffer_c.append(indent + "const unsigned int EE_MAX_RESOURCE = "
							+ parent.computeMaxResource(mutexList)
							+ "U;\n");
				}

				
				// first global resources then local resources
				boolean global = true;
				{
					for (int j=0; j<2; j++) {
						
						for (Iterator<ISimpleGenRes> iter = mutexList.iterator(); iter.hasNext();) {
							ISimpleGenRes curr = (ISimpleGenRes) iter.next();
							
							boolean currGlobal = curr.containsProperty(ISimpleGenResKeywords.RESOURCE_GLOBAL) && 
									"true".equalsIgnoreCase(curr.getString(ISimpleGenResKeywords.RESOURCE_GLOBAL));
								
							if (global == currGlobal) {
								String id = curr.getString(ISimpleGenResKeywords.RESOURCE_SYS_ID);
								String unsignedId = "U"; // if id is a number, add U
								try {
									Integer.parseInt(id);
								} catch (Exception e) {
									unsignedId = ""; // if id is not a number, don't add U
								}
								
								final ArrayList<String> names;
//								if (curr.containsProperty(ISimpleGenResKeywords.RESOURCE_CHAIN_LIST)) {
//									 names = (ArrayList<String>) curr.getObject(ISimpleGenResKeywords.RESOURCE_CHAIN_LIST);
//								} else {
									names = new ArrayList<String>();
									names.add(curr.getName());
//								}

								for (int aln=0; aln<names.size(); aln++) {
									buffer.append(indent + "#define " + names.get(aln) + " "
											+ (global ? "(" + id + unsignedId + "|EE_GLOBAL_MUTEX)" : ("" + id + unsignedId) )+ "\n");
								}
							}
						}
						
						global = false;
					}
				}

				
				if ("true".equalsIgnoreCase(AbstractRtosWriter.getOsProperty(ool, ISimpleGenResKeywords.OS_CPU__ISR_REQUIRES_RESOURCES))) {
					
					String max_level = AbstractRtosWriter.getOsProperty(ool, ISimpleGenResKeywords.OS_CPU__ISR_REQUIRES_RESOURCES_MAX_PRIO);
					String size = AbstractRtosWriter.getOsProperty(ool, ISimpleGenResKeywords.OS_CPU__ISR_REQUIRES_RESOURCES_SIZE);
					
					buffer.append("\n"+indent + "#define " +EE_MAX_ISR2_WITH_RESOURCES+" "
							+ size + "U\n");
					buffer.append(indent + "#define EE_ISR2_MAX_LEVEL          "
							+ max_level + "U\n");
					
				}
			}

			{
				/*
				 * ---------------- EVENT ----------------
				 * 
				 * Define the value of each EVENT
				 * (enable one bit for each event)
				 */

				List<ISimpleGenRes> eventList = ool.getList(IOilObjectList.EVENT);
				StringBuffer tmp_event = new StringBuffer();
				for (Iterator<ISimpleGenRes> iter = eventList.iterator(); iter.hasNext();) {
					ISimpleGenRes curr = (ISimpleGenRes) iter.next();
					
					boolean add = true;
					if (curr.containsProperty(ISimpleGenResKeywords.EVENT_CPU_BITSET)) {
						add = ((BitSet) curr.getObject(ISimpleGenResKeywords.EVENT_CPU_BITSET)).get(rtosId);
					}
					
					if (add) {
						String mask = (Long.toHexString(curr
								.getLong(ISimpleGenResKeywords.EVENT_MASK)));
						tmp_event.append(indent + "#define " + curr.getName()
								+ " 0x" + mask.toUpperCase() + "U\n");
					}
				}

				if (tmp_event.length() > 0) {
					buffer.append("\n"+ 
							indent + commentWriterH.writerSingleLineComment("EVENT definition") +
							tmp_event); // \n");
				}
			}

			{
				/*
				 * ---------------- ALARM ----------------
				 * 
				 * Define an Identifier for all Alarm.
				 * 
				 * Define MAX_ALARM as number of Alarm
				 */

				List<ISimpleGenRes> alarmList = ool.getList(IOilObjectList.ALARM);

				buffer.append("\n" + indent + commentWriterH.writerSingleLineComment("ALARM definition")); //\n");
				if (!binaryDistr) {
					buffer.append(indent + "#define EE_MAX_ALARM " + alarmList.size()
						+ "U\n");
				} else if (binaryDistrFull) {
					buffer_c.append(indent + "const unsigned int EE_MAX_ALARM = " + alarmList.size()
							+ "U;\n");
				}

				int id = 0;
				for (Iterator<ISimpleGenRes> iter = alarmList.iterator(); iter.hasNext(); id++) {
					ISimpleGenRes curr = (ISimpleGenRes) iter.next();
					buffer.append(indent + "#define " + curr.getName() + " "
							+ id + "U\n");
					curr.setProperty(ISimpleGenResKeywords.ALARM_SYS_ID, "" +id);
				}
				

				buffer.append("\n" + indent + commentWriterH.writerSingleLineComment("COUNTER OBJECTS definition")); //\n");
				if (!binaryDistr) {
					buffer.append(indent + "#define EE_MAX_COUNTER_OBJECTS EE_MAX_ALARM\n");
				} else if (binaryDistrFull) {
					buffer_c.append(indent + "const unsigned int EE_MAX_COUNTER_OBJECTS = " + alarmList.size()
							+ "U;\n");
				}
			}

 			{
				String speed = AbstractRtosWriter.getOsProperty(ool, IEEWriterKeywords.SGRK_OS_CPU_SPEED_HZ);
				if (speed == null) {
					// check if the master cpu has a clock setting
					IOilObjectList masterOol = parent.getOilObjects()[0];
					speed = AbstractRtosWriter.getOsProperty(masterOol, IEEWriterKeywords.SGRK_OS_CPU_SPEED_HZ);
				}
				if (speed != null) {
					buffer.append("\n" + indent + commentWriterH.writerSingleLineComment("CPU CLOCK definition")); //\n");
					buffer.append(indent +    "#define EE_CPU_CLOCK      " + speed+"U\n");
				}
			}
			
			{
				/*
				 * ---------------- COUNTER ----------------
				 * 
				 * Define an Identifier for all Counter.
				 * 
				 * Define MAX_COUNTER as number of Counter
				 */

				List<ISimpleGenRes> counterList = ool.getList(IOilObjectList.COUNTER);

				buffer.append("\n" + indent + commentWriterH.writerSingleLineComment("COUNTER definition")); //\n");
				if (!binaryDistr) {
					buffer.append(indent + "#define EE_MAX_COUNTER "
						+ counterList.size() + "U\n");
				} else if (binaryDistrFull) {
					buffer_c.append(indent + "const unsigned int EE_MAX_COUNTER = " + counterList.size()
							+ "U;\n");
				}

				int id = 0;
				for (Iterator<ISimpleGenRes> iter = counterList.iterator(); iter.hasNext(); id++) {
					ISimpleGenRes curr = (ISimpleGenRes) iter.next();
					buffer.append(indent + "#define " + curr.getName() + " "
							+ id + "U\n"); // should use ISimpleGenResKeywords.COUNTER_SYS_ID
				}
			}

			{
				/*
				 * ---------------- APPLICATION MODE ----------------
				 * 
				 * Define an Identifier for all Application Mode.
				 * 
				 * Define MAX_APPMODE as number of Application Mode
				 */

				List<ISimpleGenRes> appmodeList = ool.getList(IOilObjectList.APPMODE);

				int id = "true".equalsIgnoreCase(AbstractRtosWriter.getOsProperty(ool, ISimpleGenResKeywords.OSEK_AUTOSTART)) ? 1 : 0;
				ArrayList<String> appModes = new ArrayList<String>();
				for (Iterator<ISimpleGenRes> iter = ool.getList(IOilObjectList.APPMODE)
						.iterator(); iter.hasNext();) {
					String name = iter.next().getName();
					if (id==0 || !IWritersKeywords.defaultAppMode.equals(name) ) {
						appModes.add(name);
					}
				}
				Collections.sort(appModes);
				
				final int appNumber = appModes.size() + id; 

				buffer.append("\n" + indent + commentWriterH.writerSingleLineComment("APPMODE definition")); //\n");
				if (!binaryDistr) {
					buffer.append(indent + "#define EE_MAX_APPMODE " + appNumber + "U\n");
				} else if (binaryDistrFull) {
					buffer_c.append(indent + "const unsigned int EE_MAX_APPMODE = " + appNumber + ";\n");
				}

				for (int i=0; i<appModes.size(); i++) {
					buffer.append(indent + "#define " + appModes.get(i)+ " "+ (i+id)
							+ "\n");
				}
			}
			buffer.append("\n");
				
			{
				/*
				 * ---------------- CPU ----------------
				 * 
				 * Define MAX_CPU as number of cpu
				 * 
				 * Define CURRENT_CPU as id of current
				 */
				if (!binaryDistr) {
					buffer.append(indent + commentWriterH.writerSingleLineComment("CPUs") //\n"
							+ indent + "#define EE_MAX_CPU "+rtosNumber+"\n"
							+ indent + "#define EE_CURRENTCPU "+rtosId+"\n\n");
				} else if (binaryDistrFull) {
					buffer_c.append(
							indent + commentWriterH.writerSingleLineComment("CPUs") //\n"
							+ indent + "const unsigned int EE_MAX_CPU = "+rtosNumber+";\n"
							+ indent + "const unsigned int EE_CURRENTCPU = "+rtosId+";\n\n");
				}
			}
						
			{
				/*
				 * ---------------- ISR2 ----------------
				 * 
				 * Define MAX_ISR2 as number of isr2 for current cpu
				 */
				String number = AbstractRtosWriter.getOsProperty(ool, ISimpleGenResKeywords.OS_CPU__ISR2_NUMBER);
				buffer.append(IWritersKeywords.INDENT +commentWriterH.writerSingleLineComment("Number of isr 2"));
				Object text = AbstractRtosWriter.getOsObject(ool, ISimpleGenResKeywords.OS_CPU__ISR2_ADDITIONAL_TXT_LIST);
				if (text != null && text instanceof List) {
					for (Object s : (List<?>) text) {
						buffer.append(IWritersKeywords.INDENT +commentWriterH.writerSingleLineComment(""+s));
					}
				}
				buffer.append(IWritersKeywords.INDENT + "#define EE_MAX_ISR2 " + (number == null ? "0" : number ) + "\n\n");

			}
			
			/*
			 * 
			 *  EE_OPT inside an .h file
			 * 
			 * 
			 */
			if (includeEE_opt_application) {

				Set<String> not_valid_defines = new HashSet<String>();
				not_valid_defines.add("DEBUG");
				
				final StringBuffer buffer_ee_opt = buffer;
				buffer_ee_opt.append("#ifndef " + FILE_EE_CFG_H_SECTION_EEOPT_DEFINES + "\n");
				
				/*******************************************************************
				 * USER OPTIONS
				 ******************************************************************/
				{
					buffer_ee_opt.append(commentWriterH
							.writerBanner("User options"));
					String[] options = parent.extractEE_Opts(IGetEEOPTExtentions.EE_OPT_USER_ONLY, rtosId);
					for (int i=0; i<options.length; i++) {
						if (!not_valid_defines.contains(options[i])) {
							buffer_ee_opt.append("#define " + options[i] + "\n");
						}
					}
					
				}

				{
					/*******************************************************************
					 * AUTOMATIC OPTIONS
					 ******************************************************************/
					buffer_ee_opt.append(commentWriterH
							.writerBanner("Automatic options"));

					String[] options = parent.extractEE_Opts(EE_OPT_COMMON_AUTO_ONLY | EE_OPT_CPU_ONLY, rtosId);
					for (int i=0; i<options.length; i++) {
						if (!not_valid_defines.contains(options[i])) {
							buffer_ee_opt.append("#define " + options[i] + "\n");
						}
					}
				}
				
				buffer_ee_opt.append("\n#endif\n\n");
				
			}
			
			
			
			
			// define max number of objects for a binary distribution
			if (binaryDistr) {
				
				buffer_c.append(commentWriterC.writerBanner("Set values of local RTD_MAX_xxx"));

				/*
				 * Define a string for each MAX_OBJECT_NUMBER (OBJECT=task, RESOURCE, ...).
				 * Binary distribution uses the suffix RTD_. 
				 */
				final String MAX_ALARM = "RTD_MAX_ALARM";
				final String MAX_APPMODE = "RTD_MAX_APPMODE";
				final String MAX_COUNTER = "RTD_MAX_COUNTER";
				final String MAX_TASK = "RTD_MAX_TASK";
				final String MAX_RESOURCE = "RTD_MAX_RESOURCE";
				final String MAX_CPU = "RTD_MAX_CPU";
				final String CURRENT_CPU = "RTD_CURRENTCPU";

				// compute the number of APPMODES
				final int appNumber = ool.getList(IOilObjectList.APPMODE).size() + (
						"true".equalsIgnoreCase(AbstractRtosWriter.getOsProperty(ool, ISimpleGenResKeywords.OSEK_AUTOSTART)) ? 1 : 0); 
				
				// write all definitions
				buffer_c.append("#define " + MAX_ALARM +" "+ ool.getList(IOilObjectList.ALARM).size()+ "U\n"
				+ "#define " + MAX_APPMODE +" "+ appNumber + "U\n"
				+ "#define " + MAX_COUNTER +" "+ ool.getList(IOilObjectList.COUNTER).size()+ "U\n"
				+ "#define " + MAX_TASK +" "+ ool.getList(IOilObjectList.TASK).size()+ "U\n"
				+ "#define " + MAX_RESOURCE +" "+ ool.getList(IOilObjectList.RESOURCE).size()+ "U\n\n"
				+ "#define " + MAX_CPU +" "+ rtosNumber+ "U\n"
				+ "#define " + CURRENT_CPU +" "+ rtosId+ "U\n\n");
				
				// ----------------- NIOS_II ---------------
				
				
//				if (checkKeyword(WritersKeys.CPU_NIOSII)) {
				if (parent.checkKeyword(IDistributionConstant.DEF__EE_USE_BINARY_DISTRIBUTION__)) { 

					buffer_c.append(commentWriterC.writerBanner("Set values of global EE_MAX_xxx"));
					buffer.append(commentWriterC.writerBanner("Import extern values : EE_MAX_xxx"));

					String[][] id;
					{
						ArrayList<String[]> tmp = new ArrayList<String[]>();

						tmp.add(new String[] {"EE_MAX_ALARM", "" + ool.getList(IOilObjectList.ALARM).size()+"U"});
						tmp.add(new String[] {"EE_MAX_APPMODE",""+appNumber+"U"});
						tmp.add(new String[] {"EE_MAX_COUNTER",""+ool.getList(IOilObjectList.COUNTER).size()+"U"});
						tmp.add(new String[] {"EE_MAX_TASK",""+ool.getList(IOilObjectList.TASK).size()+"U"});
						tmp.add(new String[] {"EE_MAX_RESOURCE",""+ool.getList(IOilObjectList.RESOURCE).size()+"U"});

						if (rtosNumber>1) {
							tmp.add(new String[] {"EE_MAX_CPU",""+rtosNumber+"U"});
							tmp.add(new String[] {"EE_CURRENTCPU",""+rtosId+"U"});
						}
						
						id = (String[][]) tmp.toArray(new String[tmp.size()][]);
					}

					for (int i=0; i<id.length; i++) {
						buffer_c.append(
								  "#ifndef "+id[i][0]+"\n"
								+indent+"const unsigned int "+id[i][0]+" = "+id[i][1]+";\n"
								+ "#endif\n");
						
						buffer.append(
								  "#ifndef "+id[i][0]+"\n"
								  + indent + "extern const unsigned int "+id[i][0]+";\n"
								  + "#endif\n");

					}
				
				}
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
		
		// check used events
		for (int i = 0; i < oilObjects.length; i++) {
			boolean unsettedMask = false;
			BitSet usedMasks = new BitSet();
			
			List<ISimpleGenRes> eventList = oilObjects[i].getList(IOilObjectList.EVENT);
			for (Iterator<ISimpleGenRes> iter = eventList.iterator(); iter.hasNext();) {

				ISimpleGenRes curr = (ISimpleGenRes) iter.next();
				if (curr.containsProperty(ISimpleGenResKeywords.EVENT_MASK)) {
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
						throw new OilCodeWriterException("Not Valuid mask");
					}
					usedMasks.set(tti);

				} else {
					unsettedMask = true;
				}
			}
			
			if (!unsettedMask) { //all masks are setted
				return;
			}
			
			// set all mask = auto
			int maskPos = 0;
			for (Iterator<ISimpleGenRes> iter = eventList.iterator(); iter.hasNext();) {

				ISimpleGenRes curr = (ISimpleGenRes) iter.next();
				if (!curr.containsProperty(ISimpleGenResKeywords.EVENT_MASK)) {
					// search an unused mask
					while (usedMasks.get(maskPos) && maskPos<65) {
						maskPos++;
					}
					if (maskPos == 65) {
						throw new OilCodeWriterException("Too many events !!");
					}
					
					curr.setProperty(ISimpleGenResKeywords.EVENT_MASK, "" + (1<<maskPos));
					usedMasks.set(maskPos);
					maskPos++;
				}
			}
		}		
	}

}
