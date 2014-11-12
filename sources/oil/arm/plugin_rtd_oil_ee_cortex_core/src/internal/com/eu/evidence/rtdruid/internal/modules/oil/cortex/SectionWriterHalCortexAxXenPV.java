package com.eu.evidence.rtdruid.internal.modules.oil.cortex;
/*
 * Created on 21/09/2011
 *
 * $Id$
 */


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.HostOsUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OsType;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.SectionWriterIsr;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.SectionWriterKernelCounterHw;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStacks;
import com.eu.evidence.rtdruid.modules.oil.cortex.constants.CortexConstants;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;

/**
 * This writer build files for a CORTEX Ax CPU - Board (as Xen PV guest)
 *
 * @author Nicola Serreli
 */
public class SectionWriterHalCortexAxXenPV extends SectionWriter
	implements IEEWriterKeywords,
			IExtractObjectsExtentions,
			IExtractKeywordsExtentions {



	/** Cortex M0 ee_opts */
	public final static String EEOPT__CORTEX_AX_XENPV__ = "EE_CORTEX_AX_XENPV__";
	public final static String EEOPT__GNU_COMPILER__ = "EE_GNU__";

//	public final static String EEOPT__CORTEX_MODEL_A9__ = "__CORTEX_A9__";

	private static final String EE_CORTEX_SYSTEM_TIMER_HANDLER = "EE_cortex_system_timer_handler";

	static final String SGR_OS_CPU_SYS_STACK_SIZE = "sgr__os_cpu_system_stack_size";

	final protected String CUSTOM_MCU = "CUSTOM";
	final protected static HashMap<String, Mcu_Model> ALLWINNER_MCU_PROPERTIES = new HashMap<String, Mcu_Model>();
	private static final String ALLWINNER_MCU = "ALLWINNER";

	private static final String CUBIEBOARD2 = "CUBIEBOARD2";

	static {
		loadMCU_properties();
	}

	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;

	/** All data */
	protected final IVarTree vt;

	private final SectionWriterIsr isrWriter;
	private final SectionWriterKernelCounterHw counterHwWriter;

	/**
	 *
	 */
	public SectionWriterHalCortexAxXenPV() {
		this(null);

	}

	/**
	 *
	 */
	public SectionWriterHalCortexAxXenPV(ErikaEnterpriseWriter parent) {
		super(IWritersKeywords.CPU_CORTEX_AX_XENPV,
				new String[] {}, //
				new String[] { //
					IWritersKeywords.CPU_NIOSII,//
					IWritersKeywords.CPU_JANUS,//
					IWritersKeywords.CPU_MPC5xx,//
					IWritersKeywords.CPU_NIOSII, //
					IWritersKeywords.CPU_AVR5 },
					SWCategoryManager.defaultInstance.newCategory(SWCategoryManager.TYPE_CPU));

		this.parent = parent;
		this.vt = parent == null ? null : parent.getVt();

		isrWriter = new SectionWriterIsr(parent, "CAX");
		isrWriter.setGenerateDefineCategory(true);
		counterHwWriter = new SectionWriterKernelCounterHw(parent, "CAX", EE_CORTEX_SYSTEM_TIMER_HANDLER);
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

		return writeEE_CORTEX_Ax_CPU();
	}

	/**
	 * This method add new keywords enabled by this writer.
	 */
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix) {
	}

	/**
	 * This method makes some changes to computed Oil Object
	 */
	public void updateObjects() throws OilCodeWriterException {

		final IOilObjectList[] oilObjects = parent.getOilObjects();

        ArrayList<String> cpuEEopt = new ArrayList<String>();

        {
		 // mcu
			checkMcu(cpuEEopt);

			 // board
			checkBoard(cpuEEopt);

			// isr
			isrWriter.updateObjects();

			// counter
			counterHwWriter.updateObjects();
        }

		for ( int currentRtosId = 0; currentRtosId <oilObjects.length; currentRtosId ++) {
			final IOilObjectList ool = oilObjects[currentRtosId];

			/***********************************************************************
			 *
			 * EE OPTS
			 *
			 **********************************************************************/
			{
				//List requiredOilObjects = (List) sgrCpu.getObject(SGRK__FORCE_ARRAYS_LIST__);

		        ArrayList<String> tmp_cpu = new ArrayList<String>(cpuEEopt);
		        ArrayList<String> tmp_common = new ArrayList<String>();

		        // store all older values (if there are)
		        ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
		        if (sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_EE_OPTS)) {
				String[] old = (String[]) sgrCpu.getObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS);
				tmp_cpu.addAll(Arrays.asList(old));
		        }
		        if (sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_COMMON_EE_OPTS)) {
				String[] old = (String[]) sgrCpu.getObject(ISimpleGenResKeywords.OS_CPU_COMMON_EE_OPTS);
				tmp_common.addAll(Arrays.asList(old));
		        }

		        tmp_common.add(EEOPT__CORTEX_AX_XENPV__);
		        String cpu_model;
		        {
				List<String> all = parent.getCpuDataEnum(ool, "MODEL");
					cpu_model = all.size() == 0? null : all.get(0);
					if (CortexConstants.SGRK__CORTEX_A9__.equalsIgnoreCase(cpu_model)) {
			            sgrCpu.setProperty(CortexConstants.SGRK__CORTEX_CPU_MODEL__, CortexConstants.SGRK__CORTEX_A9__);
//			            tmp.add(EEOPT__CORTEX_MODEL_A9__);
			        } else {
					Messages.sendWarningNl("No cortex cpu model set.");
			        }
				}

				{
				List<String> all = parent.getCpuDataEnum(ool, "COMPILER_TYPE");
					String tmp1 = all.size() == 0? null : all.get(0);
					if (tmp1 == null) {
						if (CortexConstants.SGRK__CORTEX_A9__.equalsIgnoreCase(cpu_model)) {
							tmp1 = CortexConstants.SGRK__GNU_COMPILER__;
				        }
					}

					sgrCpu.setProperty(CortexConstants.SGRK__CORTEX_COMPILER_TYPE__, tmp1);
					if (CortexConstants.SGRK__GNU_COMPILER__.equalsIgnoreCase(tmp1)) {
						tmp_common.add(EEOPT__GNU_COMPILER__);
				    }

				}

				sgrCpu.setObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS, tmp_cpu.toArray(new String[tmp_cpu.size()]));
				sgrCpu.setObject(ISimpleGenResKeywords.OS_CPU_COMMON_EE_OPTS, tmp_common.toArray(new String[tmp_common.size()]));

				/***********************************************************************
				 *
				 * System stack size
				 *
				 **********************************************************************/
				{
					String[] stack_size = parent.getCpuDataValue(ool, "SYS_STACK_SIZE");
					if (stack_size != null && stack_size.length>0 && stack_size[0] != null) {

						boolean valid = false;
						int value = -1;
						try {
							value = Integer.decode(stack_size[0]);
							valid = true;
						} catch (NumberFormatException e) {
							Messages.sendWarningNl("Invalid value for System stack size : " + stack_size[0]);
						}

						if (valid && value <0) {
							Messages.sendWarningNl("System stack size cannot be negative (" + value + ")");
						} else {

							sgrCpu.setProperty(SGR_OS_CPU_SYS_STACK_SIZE, ""+value);
						}

					}

				}
			}

		}

	}

	/**
	 * Write configuration's files for CORTEX M0
	 *
	 * @return buffers with configuration for CORTEX M0
	 *
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeEE_CORTEX_Ax_CPU()
			throws OilCodeWriterException {

		final String ERR_CPU_TYPE = "CORTEX AX";
		final IOilObjectList[] oilObjects = parent.getOilObjects();

		IOilWriterBuffer[] allBuffers = new IOilWriterBuffer[oilObjects.length];
		final String indent = IWritersKeywords.INDENT;

		// ------------- Common string --------------------
		final boolean binaryDistr = parent.checkKeyword(IEEWriterKeywords.DEF__EE_USE_BINARY_DISTRIBUTION__);
		final boolean multicore = parent.getOilObjects().length>1;

		/*
		 * Define a string for each MAX_OBJECT_NUMBER (OBJECT=task, RESOURCE, ...).
		 * Binary distribution uses the suffix RTD_.
		 */
		final String MAX_TASK = (binaryDistr ? "RTD_" : "EE_") + "MAX_TASK";

		for ( int currentRtosId = 0; currentRtosId <oilObjects.length; currentRtosId ++) {
			IOilWriterBuffer answer = new OilWriterBuffer();
			allBuffers[currentRtosId] = answer;

			String pre = "";
			String post = "";


			// ------------- Requirement --------------------
			StringBuffer sbInithal_c = answer.get(FILE_EE_CFG_C);
			StringBuffer sbInithal_h = answer.get(FILE_EE_CFG_H);

			final IOilObjectList ool = oilObjects[currentRtosId];
			final ICommentWriter commentWriterH = getCommentWriter(ool, FileTypes.H);
			final ICommentWriter commentWriterC = getCommentWriter(ool, FileTypes.C);
			final ICommentWriter commentWriterMf = getCommentWriter(ool, FileTypes.MAKEFILE);

			List<ISimpleGenRes> taskNames = ool.getList(IOilObjectList.TASK);
			String stackType = parent.getStackType(); // MULTI or MONO

			// ------------- Buffers --------------------
			/* A buffer about stack  */
			StringBuffer sbStack = new StringBuffer();

			/* A buffer about declarations of stacks  */
			StringBuffer sbStackDecl = new StringBuffer();
			StringBuffer sbStackDeclSize = new StringBuffer();

			// ------------- Compute --------------------

			isrWriter.writeIsr(currentRtosId, ool, answer);
			counterHwWriter.writeCounterHw(currentRtosId, ool, answer);

			sbInithal_c.append("\n#include \"ee.h\"\n");


			/***********************************************************************
			 * SYSTEM STACK SIZE
			 **********************************************************************/
			{
				String s = AbstractRtosWriter.getOsProperty(ool, SGR_OS_CPU_SYS_STACK_SIZE);
				if (s != null) {
					sbInithal_h.append(getCommentWriter(ool, FileTypes.H).writerBanner("System stack size") +
								"#define EE_SYS_STACK_SIZE     " + s + "\n\n");
				}
			}

	//		/***********************************************************************
	//         *
	//         * EE OPTS
	//         *
	//         **********************************************************************/

		    final int STACK_UNIT = ErikaEnterpriseWriter.getStackUnit(ool);

			/***********************************************************************
			 * MULTI STACK
			 **********************************************************************/
			if (DEF__MULTI_STACK__.equals(stackType)) {
				sbInithal_c.append(commentWriterC
						.writerBanner("Stack definition for CORTEX A9"));

				ITreeInterface ti = vt.newTreeInterface();



				int[] irqSize = null;
				if (parent.checkKeyword(DEF__IRQ_STACK_NEEDED__)) {
					/***************************************************************
					 * IRQ_STACK
					 **************************************************************/
					final List<String> currentCpuPrefixes = AbstractRtosWriter.getOsProperties(ool, SGRK_OS_CPU_DATA_PREFIX);
					for (String currentCpuPrefix: currentCpuPrefixes) {
					if (irqSize != null) {
						break;
					}

						String[] child = new String[1];
						String type = CommonUtils
								.getFirstChildEnumType(vt, currentCpuPrefix
										+ "MULTI_STACK", child);

						if ("TRUE".equalsIgnoreCase(type)) {
							String prefixIRQ = currentCpuPrefix
								+ "MULTI_STACK" + VARIANT_ELIST+child[0] + PARAMETER_LIST
								+ "IRQ_STACK";
							boolean ok = "TRUE".equalsIgnoreCase(CommonUtils
							.getFirstChildEnumType(vt, prefixIRQ, child));

							if (ok) {

								prefixIRQ += VARIANT_ELIST + child[0] +PARAMETER_LIST;
								irqSize = new int[1];
								{ // get data for IRQ STACK ...
									String path[] = { "SYS_SIZE" };

									for (int i = 0; i < path.length; i++) {
										String tmp = null;
										IVariable var = ti.getValue(prefixIRQ + path[i]
												+ VALUE_VALUE);
										if (var != null && var.get() != null) {
											tmp = var.toString();
										}
										if (tmp == null)
											throw new RuntimeException(
													ERR_CPU_TYPE + " : Expected " + path[i]);

										// check for value
										try {
											// ... store them inside the irqSize vector
											irqSize[0] = (Integer.decode("" + tmp))
													.intValue();
											// ... and increase the memory requirement
		//									stackEnd += irqSize[0];
										} catch (Exception e) {
											throw new RuntimeException(
													ERR_CPU_TYPE + " : Wrong int" + path[i]
															+ ", value = " + tmp + ")");
										}
									}
								}
							}
						}
					}

				}

				/*
				 * elStack contains all data about stack, for current rtos and its
				 * tasks.
				 *
				 * tList and tListN are used to identify all tasks (theirs name and
				 * system id).
				 *
				 * elStack accepts the list of task's names (tList) to compute all
				 * required stack and theirs size/position
				 */
				EEStacks elStack = new EEStacks(parent, ool, irqSize);
				elStack.setDummyStackPolicy(elStack.FORCE_ALWAYS | elStack.FORCE_FIRST);
				ArrayList<String> tList = new ArrayList<String>();
				ArrayList<String> tListN = new ArrayList<String>();

				{
					/***************************************************************
					 * STACK FOR EACH TASK
					 **************************************************************/

					// add the dummy task
					tListN.add(" ");
					tList.add(IWritersKeywords.dummyName);

					// fill data for each task
					for (Iterator<ISimpleGenRes> iter = taskNames.iterator(); iter.hasNext();) {

						ISimpleGenRes sgr = (ISimpleGenRes) iter.next();
						tList.add(sgr.getName());
						tListN.add(sgr.getString(ISimpleGenResKeywords.TASK_SYS_ID));
					}

					// compute total stack size and add it to memory requirement
	//				int offset[][] = elStack.taskOffsets((String[]) tList
	//						.toArray(new String[0]));
	//				stackEnd += offset[offset.length - 1][0]; // tot sys
				}


				{
					/***************************************************************
					 * PREPARE BUFFERS
					 **************************************************************/

					pre = "";
					post = "";

					/* get the link between a task and its stack. */
					int pos[] = elStack.taskStackLink(tList
							.toArray(new String[1]));
					/* get the size of each stack. */
					int size[][] = elStack.stackSize(tList
							.toArray(new String[1]));
					/* descrStack contains a description for each stack. */
					String[] descrStack = new String[size.length];
					sbStack.append(indent
							+ "const EE_UREG EE_std_thread_tos["+MAX_TASK+"+1] = {\n");




					// DESCRIPTIONS
					for (int j = 0; j < pos.length; j++) {
						sbStack.append(pre + post + indent + indent + +pos[j]+"U");
						// set new values for "post" and "pre"
						post = " /* " + tList.get(j) + "*/\n";
						pre = ",\t";

						/*
						 * add the name of current task to the description of the /
						 * right stack. Check also if there is already something or
						 * not, infact in the second case append the new description
						 * to the old one
						 */
						descrStack[pos[j]] = (descrStack[pos[j]] == null) ?
								// The first description
								("Task " + tListN.get(j) + " (" + tList.get(j) + ")")
								:
								// other descriptions
								(descrStack[pos[j]] + ", " + "Task "
										+ tListN.get(j) + " (" + tList.get(j) + ")"); // others
					}

					// close sbStack
					sbStack.append(" \t" + post + indent + "};\n\n" + indent
							+ "struct EE_TOS EE_cortex_ax_xenpv_system_tos["
							+ (size.length) + "] = {\n");

					pre = "";
					post = "";

	//				 DECLARE STACK SIZE && STACK (ARRAY)
					for (int j = 1; j < size.length; j++) {
					    long value = size[j][0];
					    value  = (value + (value%STACK_UNIT)) / STACK_UNIT; // arrottondo a 2
						sbStackDecl.append(indent + "int EE_cortex_ax_xenpv_stack_"+j+"[STACK_"+j+"_SIZE];\t/* "+descrStack[j]+" */\n");
						sbStackDeclSize.append(indent + "#define STACK_"+j+"_SIZE "+value+" // size = "+size[j][0]+" bytes \n");
					}

					/*
					 * For each stack prepare the configuration's vectors and
					 * descriptions
					 */
					for (int j = 0; j < size.length; j++) {

				        String value = j == 0 ? "{0}" : "{(EE_ADDR)(&EE_cortex_ax_xenpv_stack_"+j+"[STACK_"+j+"_SIZE - CORTEX_AX_XENPV_INIT_TOS_OFFSET])}";

						sbStack.append(pre
								+ post
								+ indent
								+ indent
								+ value);

						// set new values for size
						pre = ",";
						post = "\t/* "+descrStack[j]+" */\n";
					}

					// complete the stack's buffer
					sbStack.append(" " + post + indent + "};\n\n" + indent
							+ "EE_UREG EE_cortex_ax_xenpv_active_tos = 0U; /* dummy */\n\n");

					{ // if required, init also the irq stack
						if (irqSize != null) {
						    int j = size.length;
						    long value = irqSize[0];
						    value  = (value + (value%STACK_UNIT)) / STACK_UNIT; // arrottondo a 2
							sbStackDecl.append(indent + "int EE_cortex_ax_xenpv_stack_"+j+"[STACK_"+j+"_SIZE];\t/* irq stack */\n");
							sbStackDeclSize.append(indent + "#define STACK_"+j+"_SIZE "+value+" // size = "+irqSize[0]+" bytes \n");

							sbStack
									.append(indent+"/* stack used only by IRQ handlers */\n"
											+ indent+"struct EE_TOS EE_cortex_ax_xenpv_IRQ_tos = {\n"
											+ indent+indent+"(EE_ADDR)(&EE_cortex_ax_xenpv_stack_"+j+"[STACK_"+j+"_SIZE])\n"
											+ indent+"};\n\n");
						}
					}
				}


			}

			// ------------- Write --------------------
			//  add stack buffers
			sbInithal_c.append(sbStackDeclSize+"\n"+
			        sbStackDecl + "\n" +
			        sbStack);


			{
			/***********************************************************************
	         *
	         * MAKE FILE
	         *
	         **********************************************************************/
				OsType wrapper = HostOsUtils.common.getTarget();

			    StringBuffer sbMakefile = new StringBuffer(commentWriterMf.writerBanner("CORTEX A9"));
				StringBuilder sbVariables = new StringBuilder();
				StringBuilder sbCommon = new StringBuilder();

			    {	// PATHs
				HashMap<String, ?> options = parent.getOptions();

			        String outputDir = "Debug";
			        String appBase = "..";
			        // Get Default values

				if (options.containsKey(IWritersKeywords.WRITER_OUTPUT_DIR_SET)) {
						outputDir = (String) options.get(IWritersKeywords.WRITER_LAST_OUTPUT_DIR);
						outputDir = (String) options.get(IWritersKeywords.WRITER_FS_PATH_OUTPUT_DIR);

						appBase = (String) options.get(IWritersKeywords.WRITER_WS_OUTPUT_projectbase_DIR);//"..";
						if (options.containsKey(IWritersKeywords.WRITER_WS_PATH_OUTPUT_DIR)) {
							outputDir = (String) options.get(IWritersKeywords.WRITER_WS_PATH_OUTPUT_DIR);
						}
					}
				IPath p = new Path(outputDir);
				if (p.isAbsolute()) {
					outputDir = wrapper.wrapPath(outputDir);
				}


			        sbMakefile.append(
			                "APPBASE ?= " + appBase + "\n" +
			                "OUTBASE := " + outputDir + "\n\n");
			        sbCommon.append("GNUC_CORTEX_AX_XENPV_MODEL := cortex-a7\n");

			        String compiler_type = AbstractRtosWriter.getOsProperty(ool,CortexConstants.SGRK__CORTEX_COMPILER_TYPE__);
			        if (CortexConstants.SGRK__GNU_COMPILER__.equalsIgnoreCase(compiler_type)) {
				        String gcc = CortexConstants.DEFAULT_CORTEXAx_CONF_GNU_CC;
					if (options.containsKey(CortexConstants.PREF_CORTEXAx_GNU_CC_PATH)) {
							String tmp = (String) options.get(CortexConstants.PREF_CORTEXAx_GNU_CC_PATH);
							if (tmp.length()>0) gcc = tmp;
						}

				        String compiler_define = CommonUtils.compilerMakefileDefines(gcc, "CORTEX_AX_XENPV_GCCDIR", wrapper);
					if (multicore) {
							sbCommon.append("\n"+
									CommonUtils.addMakefileDefinesInclude()
									+ compiler_define);
						} else {
							sbVariables.append("\n"+
									CommonUtils.addMakefileDefinesInclude()
									+ compiler_define);
						}
			        }
			    }

			    ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);

	            if (multicore) {
				if (sgrCpu.containsProperty(SGRK__COMMON_MAKEFILE_MP_EXT_VARS__)) {
					sbMakefile.append(sgrCpu.getString(SGRK__COMMON_MAKEFILE_MP_EXT_VARS__));
				}
				sgrCpu.setProperty(SGRK__COMMON_MAKEFILE_MP_EXT_VARS__, sbCommon.toString());
			} else {
				sbVariables.append(sbCommon.toString());
			}

			if (sgrCpu.containsProperty(SGRK__MAKEFILE_EXTENTIONS__)) {
				sbMakefile.append(sgrCpu.getString(SGRK__MAKEFILE_EXTENTIONS__));
			}
			sgrCpu.setProperty(SGRK__MAKEFILE_EXTENTIONS__, sbMakefile.toString());

			if (sgrCpu.containsProperty(SGRK__MAKEFILE_CPU_EXT_VARS__)) {
				sbVariables.append(sgrCpu.getString(SGRK__MAKEFILE_CPU_EXT_VARS__));
			}
			sgrCpu.setProperty(SGRK__MAKEFILE_CPU_EXT_VARS__, sbVariables.toString());
			}


			{ // max isr level
				int max_level = -1;
				List<ISimpleGenRes> isrList = ool.getList(IOilObjectList.ISR);
				for (ISimpleGenRes curr : isrList) {
					int entry = -1;
					int level = -1;
					try {
						if (curr.containsProperty(ISimpleGenResKeywords.ISR_ENTRY)) {
							entry = curr.getInt(ISimpleGenResKeywords.ISR_ENTRY);
						}
					} catch (Exception e) {
						Messages.sendWarningNl("The entry of isr " + curr.getName() + " is not a number and cannot be used to compute EE_CAX_MAX_ISR_ID");
					}
					try {
						if (curr.containsProperty(ISimpleGenResKeywords.ISR_LEVEL)) {
							level = curr.getInt(ISimpleGenResKeywords.ISR_LEVEL);
						}
					} catch (Exception e) {
						Messages.sendWarningNl("The level of isr " + curr.getName() + " is not a number and cannot be used to compute EE_CAX_MAX_ISR_ID");
					}
					if (entry >-1 && entry > max_level) { max_level = entry; }
					if (level >-1 && level > max_level) { max_level = level; }
				}

				sbInithal_h.append(commentWriterH.writerBanner("Set the max ISR level"));
				sbInithal_h.append("#define EE_CAX_MAX_ISR_ID     "+ (max_level)+"\n\n");
			}
		}

		// MCU
		mcuWrite(allBuffers);

		return allBuffers;
	}

	/*
	 * Parse and write the MCU Section
	 */
	private void mcuWrite(IOilWriterBuffer[] buffers) {
		final String CUSTOM_MCU = "CUSTOM";

		final IOilObjectList[] oilObjects = parent.getOilObjects();
		String mcu_model = null;	// != null only if found a valid mcu
		Mcu_Model mcu_properties = null;
		String mcu_type = null;
		String prefix = "";
		for (int currentRtosId = 0; mcu_model == null && currentRtosId < oilObjects.length; currentRtosId ++) {

			ArrayList<String> childPaths = new ArrayList<String>();
			List<String> childFound = parent.getRtosCommonChildType(oilObjects[currentRtosId], "MCU_DATA", childPaths);

			for (int index = 0; index<childFound.size(); index++) {
				mcu_type = childFound.get(index);
				if (mcu_model == null) {
				/***********************************************************************
				 * get values
				 **********************************************************************/
					String currentMcuPrefix = childPaths.get(index) + PARAMETER_LIST + "MODEL";

					if (ALLWINNER_MCU.equals(mcu_type)) {
						prefix = "CORTEX_AX_";
						// ... and compete it

						String[] child = new String[1];
						String model_type = CommonUtils.getFirstChildEnumType(vt, currentMcuPrefix, child);

						/* CUSTOM */
						if (CUSTOM_MCU.equals(model_type)) {
							// read also LINKERSCRIPT, DEV_LIB, INCLUDE_C, INCLUDE_S
							currentMcuPrefix += VARIANT_ELIST + child[0] + PARAMETER_LIST;
							String[] model = CommonUtils.getValue(vt, currentMcuPrefix+"MODEL");
							String[] linker = CommonUtils.getValue(vt, currentMcuPrefix+"LINKERSCRIPT");
							String[] inc_c  = CommonUtils.getValue(vt, currentMcuPrefix+"INCLUDE_C");
							String[] inc_s  = CommonUtils.getValue(vt, currentMcuPrefix+"INCLUDE_S");
							String[] startup  = CommonUtils.getValue(vt, currentMcuPrefix+"STARTUP");

							mcu_properties = new Mcu_Model(
									CUSTOM_MCU,
									clean(model),
									"__"+clean(model)+"__",
									clean(linker),
									clean(inc_c),
									clean(inc_s),
									clean(startup)
							);
							mcu_model = CUSTOM_MCU;
						} else {
								/* STANDARD MCU */
							mcu_properties = ALLWINNER_MCU_PROPERTIES.get(model_type);
							if (mcu_properties != null) {
								mcu_model = model_type;
							}
						}
					}
				}
			}
		}

		if (mcu_model != null) {
			/***********************************************************************
			 * prepare buffers
			 **********************************************************************/

			// The answer (StringBuffer)
			StringBuffer answerBuffer = new StringBuffer();



			// complete the table
				answerBuffer.append(prefix + "MODEL           := " +mcu_properties.model + "\n");
			if (mcu_properties.linkerScript != null)
				answerBuffer.append(prefix + "LINKERSCRIPT    := " +mcu_properties.linkerScript + "\n");
			if (mcu_properties.include_c != null)
				answerBuffer.append(prefix + "INCLUDE_C       := " +mcu_properties.include_c + "\n");
			if (mcu_properties.include_s != null)
				answerBuffer.append(prefix + "INCLUDE_S       := " +mcu_properties.include_s + "\n");
			if (mcu_properties.startup != null)
				answerBuffer.append(prefix + "STARTUP         := " +mcu_properties.startup + "\n");

			for (int currentRtosId = 0; currentRtosId < oilObjects.length; currentRtosId ++) {
				final ICommentWriter commentWriterMf = getCommentWriter(oilObjects[currentRtosId], FileTypes.MAKEFILE);


				ISimpleGenRes os = (ISimpleGenRes) oilObjects[currentRtosId].getList(IOilObjectList.OS).get(0);
				String temp = os.getString(SGRK__MAKEFILE_CPU_EXT_VARS__);
	            os.setProperty(SGRK__MAKEFILE_CPU_EXT_VARS__, temp +
				commentWriterMf.writerBanner("Init MCU for CORTEX Ax ("+mcu_model+")") +
				answerBuffer.toString());
			}

		}
	}


	/*
	 * Parse and write the MCU Section
	 */
	private void checkMcu(ArrayList<String> ee_opts) {
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		Mcu_Model mcu_properties = null;
		for (int currentRtosId = 0; mcu_properties == null && currentRtosId < oilObjects.length; currentRtosId ++) {

			ArrayList<String> childPaths = new ArrayList<String>();
			List<String> childFound = parent.getRtosCommonChildType(oilObjects[currentRtosId], "MCU_DATA", childPaths);

			for (int index = 0; index<childFound.size(); index++) {
				String mcu_type = childFound.get(index);
				if (mcu_properties == null) {

					/***********************************************************************
					 * get values
					 **********************************************************************/
					String currentMcuPrefix = childPaths.get(index) + PARAMETER_LIST + "MODEL";

					if (ALLWINNER_MCU.equals(mcu_type)) {
//						{
//							String t = "EE__ALLWINNER__";
//							if (!ee_opts.contains(t)) {
//								ee_opts.add(t);
//							}
//						}

						String[] child = new String[1];
						String model_type = CommonUtils.getFirstChildEnumType(vt, currentMcuPrefix, child);

						/* CUSTOM */
						if (CUSTOM_MCU.equals(model_type)) {

							// read only MODEL
							currentMcuPrefix += VARIANT_ELIST + child[0] + PARAMETER_LIST;
							String model = clean(CommonUtils.getValue(vt, currentMcuPrefix+"MODEL"));
							if (model != null) {
								if (!ee_opts.contains("EE_"+model+"__")) {
									ee_opts.add("EE_"+model+"__");
								}

								String linkscript = clean(CommonUtils.getValue(vt, currentMcuPrefix+"LINKERSCRIPT"));
								if (linkscript != null && !ee_opts.contains("__USE_CUSTOM_LINKER_SCRIPT__")) {
									ee_opts.add("__USE_CUSTOM_LINKER_SCRIPT__");
								}
							}

						} else {
								/* STANDARD MCU */
							mcu_properties = ALLWINNER_MCU_PROPERTIES.get(model_type);
							if (mcu_properties != null) {

								String[] splitted = mcu_properties.ee_opt == null ? new String[0] : mcu_properties.ee_opt.split(" ");
								for (String t : splitted) {
									if (!ee_opts.contains(t)) {
										ee_opts.add(t);
									}
								}
							}
						}
					}
				}
			}
		}
	}


	/*
	 * Parse and write the BOARD Section
	 */
	private void checkBoard(ArrayList<String> ee_opts) {
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		Mcu_Model mcu_properties = null;
		for (int currentRtosId = 0; mcu_properties == null && currentRtosId < oilObjects.length; currentRtosId ++) {

			ArrayList<String> childPaths = new ArrayList<String>();
			List<String> childFound = parent.getRtosCommonChildType(oilObjects[currentRtosId], "BOARD_DATA", childPaths);

			for (int index = 0; index<childFound.size(); index++) {
				String mcu_type = childFound.get(index);
				if (mcu_properties == null) {

					/***********************************************************************
					 * get values
					 **********************************************************************/

					if (CUBIEBOARD2.equals(mcu_type)) {
						{
							String t = "EE_CUBIEBOARD2__";
							if (!ee_opts.contains(t)) {
								ee_opts.add(t);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * This metod takes an array and returns the first element, or null if the
	 * array is a zero-length array or if the first element is empty ("" or
	 * null)
	 */
	protected String clean(String[] arr) {
		String answer = null;
		if (arr != null && arr.length>0) {
			if (arr[0].trim().length()>0) {
				answer= arr[0].trim();
				if ("?".equals(answer)) {
					answer = null;
				}
			}
		}
		return answer;
	}


	/**
	 * Loads every known mcu
	 */
	protected static void loadMCU_properties() {
		final String ALLWINNER_MCU_filename = com.eu.evidence.rtdruid.modules.oil.cortex.Activator.TEMPLATES_PATH + "/cortex_allwinner_id.csv";

		class PropertyMaker {
			final char COMMENT = '#';

			final protected HashMap<String, Mcu_Model> prop;

			public PropertyMaker(HashMap<String, Mcu_Model> prop) {
				this.prop = prop;
			}


			public void loadFile(String MCU_filename) {
				String tmp="";
				try {
					InputStream input = SectionWriterHalCortexAxXenPV.class.getResourceAsStream(MCU_filename);
					if (input != null) {

						ByteArrayOutputStream output = new ByteArrayOutputStream();

						byte[] data = new byte[1024];
						try {
							for (int length = input.read(data); length != -1; length = input.read(data)) {
								output.write(data, 0, length);
							}
						} catch (IOException e) {
							// ???
							e.printStackTrace();
						}
						tmp = output.toString();
					}
				} catch (Exception e) {
					RtdruidLog.log(e);
				} catch (Error e) {
					RtdruidLog.log(e);
				}

				String[] rows = tmp.split("\n");

				for (int i=0; i<rows.length; i++) {
					String t = rows[i];
					if (t.endsWith("\r")) {
						t = t.substring(0, t.length()-1);
					}
					addARow(t);
				}
			}


			public void addARow(String row) {

				// add a NOT EMPTY row
				if (row.length()==0 || row.charAt(0)==COMMENT) return;

				Mcu_Model mcu = new Mcu_Model(row, "EE_");

				prop.put(mcu.name, mcu);
			}
		};

		(new PropertyMaker(ALLWINNER_MCU_PROPERTIES)).loadFile(ALLWINNER_MCU_filename);
	}
}
