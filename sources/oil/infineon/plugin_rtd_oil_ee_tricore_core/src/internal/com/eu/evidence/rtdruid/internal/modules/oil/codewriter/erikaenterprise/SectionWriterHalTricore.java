package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.eu.evidence.modules.oil.tricore.constants.TricoreConstants;
import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.HostOsUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuHwDescription;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuUtility;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStacks;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.modules.oil.keywords.IOilXMLLabels;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

/**
 * This writer build files for a Tricore CPU - Board
 * 
 * @author Nicola Serreli
 */
public class SectionWriterHalTricore extends SectionWriter 
	implements IEEWriterKeywords,
			IExtractObjectsExtentions,
			IExtractKeywordsExtentions {

	final public String KEY_HAL_TRICORE = "__TRICORE1__";
	final public String _EE_OPT_HAL_TRICORE = "__TRICORE1__";
	
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;
	
	/** All data */
	protected final IVarTree vt;

	/**
	 * 
	 */
	public SectionWriterHalTricore() {
		this(null);
	}
	
	/**
	 * 
	 */
	public SectionWriterHalTricore(ErikaEnterpriseWriter parent) {
		super(IWritersKeywords.CPU_TRICORE1,
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

		return writeEE_Tricore1_CPU();
	}
	
	/**
	 * This method add new keywords enabled by this writer.
	 */
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix) {
		
		if (!keywords.contains(KEY_HAL_TRICORE)) {
			keywords.add(KEY_HAL_TRICORE);
		}
		
	}

	/**
	 * This method makes some changes to computed Oil Object
	 * @throws OilCodeWriterException 
	 */
	public void updateObjects() throws OilCodeWriterException {
		final IOilObjectList[] oilObjects = parent.getOilObjects();		
		
		final int currentRtosId = 0;
		final IOilObjectList ool = oilObjects[currentRtosId];
		final ISimpleGenRes sgrCpu = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
		final String currentCpuPrefix = sgrCpu.getString(SGRK_OS_CPU_DATA_PREFIX);

		/***********************************************************************
		 * 
		 * EE OPTS
		 *  
		 **********************************************************************/
		{
			//List requiredOilObjects = (List) sgrCpu.getObject(SGRK__FORCE_ARRAYS_LIST__);

	        ArrayList<String> tmp = new ArrayList<String>();
	        
	        // store all older values (if there are)
	        if (sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_EE_OPTS)) {
	        	String[] old = (String[]) sgrCpu.getObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS);
	        	tmp.addAll(Arrays.asList(old));
	        }
	
	        tmp.add(_EE_OPT_HAL_TRICORE);
	        tmp.add("__TRICORE_GNU__");
	        
	        
	        {
				String[] tmp1 = CommonUtils
						.getValue(vt, currentCpuPrefix + "MODEL");
				if (tmp1 != null && tmp1.length >0 && tmp1[0] != null) {
					String model = tmp1[0];
				
					if ("tc1796".equals(model)) {
				        tmp.add("__TC1796__");
				        tmp.add("__TC13__");
					} else {
						Messages.sendWarning("Unknown tricore cpu model " + model, null, "tricore_writer_model", null);
					}
					
					
		            sgrCpu.setProperty(TricoreConstants.SGRK__TRICORE_MODEL__, model);
		        }
			}

			{
				// ---------- Add crt0ram.S to sources
				if 	(ool.getList(IOilObjectList.ISR).size() > 0) {
					
					boolean enable_int = false;
					boolean enable_trap = false;

					List<ISimpleGenRes> tasks = ool.getList(IOilObjectList.ISR);
					for (Iterator<ISimpleGenRes> iter = tasks.iterator(); iter.hasNext();) {

						ISimpleGenRes currIsr = (ISimpleGenRes) iter.next();
						
						int category = currIsr.getInt(ISimpleGenResKeywords.ISR_CATEGORY); 
						
						switch (category) {
						case 1:
						case 2:
							enable_int = true;
							break;
						case 3:
							enable_trap = true;
							break;
						default:
							throw new OilCodeWriterException("Unsupported isr category (" + category + ") for isr " + currIsr.getName());
						}
					}
					
					
					if (enable_int)
						tmp.add("__INT__");
					if (enable_trap)
						tmp.add("__TRAP__");

					CpuUtility.addSources(sgrCpu, "$(OUTPUT_DIR)/" + TricoreConstants.ISR_HANDLER_FILE);

				}

			}

			// store ee_opts
			sgrCpu.setObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS, tmp.toArray(new String[tmp.size()]));
		}
		
		
		
		
		/***********************************************************************
		 * 
		 * Get ISR LEVEL and HANDLER
		 *  
		 **********************************************************************/
		{
			final String oilHwRtosPrefix = parent.getOilHwRtosPrefix();
			List<ISimpleGenRes> tasks = ool.getList(IOilObjectList.ISR);
			for (Iterator<ISimpleGenRes> iter = tasks.iterator(); iter.hasNext();) {

				ISimpleGenRes currIsr = (ISimpleGenRes) iter.next();
				
				String oilVarPrefix = DataPackage.eINSTANCE.getRtos_OilVar()
						.getName()
						+ S + IOilXMLLabels.OBJ_ISR + oilHwRtosPrefix;

	
				{ // LEVEL
					String deadLinePath = currIsr.getPath() + S + oilVarPrefix + S
							+ "LEVEL" ;
	
					String[] values = CommonUtils.getValue(vt, deadLinePath);
	
					String var = null;
					if (values != null && values.length >0) {
						var = values[0];
					} else {
						throw new OilCodeWriterException("Required a LEVEL for the isr "+currIsr.getName()+".");
					}
					
					currIsr.setObject(TricoreConstants.SGRK__ISR_LEVEL__, var);
				}
				
				{ // HANDLER
					String deadLinePath = currIsr.getPath() + S + oilVarPrefix + S
							+ "HANDLER" ;
	
					String[] values = CommonUtils.getValue(vt, deadLinePath);
	
					String var = null;
					if (values != null && values.length >0) {
						var = values[0];
					} else {
						throw new OilCodeWriterException("The HANDLER for the isr "+currIsr.getName()+" is missing or incorrect.");
					}
					
					currIsr.setObject(TricoreConstants.SGRK__ISR_HANDLER__, var);
				}
			}

		}		

	}
	
	/**
	 * Write configuration's files for TriCore1
	 * 
	 * @return buffers with configuration for TriCore1
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeEE_Tricore1_CPU()
			throws OilCodeWriterException {

		final String ERR_CPU_TYPE = "TriCore1";
		final IOilObjectList[] oilObjects = parent.getOilObjects();		
		
		IOilWriterBuffer answer = new OilWriterBuffer();
		final int currentRtosId = 0;
		final String indent1 = IWritersKeywords.INDENT;

		// ------------- Common string --------------------
		boolean binaryDistr = parent.checkKeyword(IEEWriterKeywords.DEF__EE_USE_BINARY_DISTRIBUTION__);

		/*
		 * Define a string for each MAX_OBJECT_NUMBER (OBJECT=task, RESOURCE, ...).
		 * Binary distribution uses the suffix RTD_. 
		 */
		final String MAX_TASK = (binaryDistr ? "RTD_" : "EE_") + "MAX_TASK";

		String pre = "";
		String post = "";
		final String indent = IWritersKeywords.INDENT;

		// ------------- Requirement --------------------
		StringBuffer sbInithal_c = answer.get(FILE_EE_CFG_C);
		
		final IOilObjectList ool = oilObjects[currentRtosId];
		final ISimpleGenRes sgrCpu = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
		final ICommentWriter commentWriterC = getCommentWriter(sgrCpu, FileTypes.C);
		final String currentCpuPrefix = sgrCpu.getString(SGRK_OS_CPU_DATA_PREFIX);
		
		List<ISimpleGenRes> taskNames = ool.getList(IOilObjectList.TASK);
		String stackType = parent.getStackType(); // MULTI or MONO

		// ------------- Buffers --------------------
		/* A buffer about stack  */
		StringBuffer sbStack = new StringBuffer();

		/* A buffer about declarations of stacks  */
		StringBuffer sbStackDecl = new StringBuffer();
		StringBuffer sbStackDeclSize = new StringBuffer();

		// ------------- Compute --------------------

		final int STACK_UNIT;
		if (sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR)) {
			CpuHwDescription currentStackDescription = (CpuHwDescription) sgrCpu.getObject(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR);
			STACK_UNIT = currentStackDescription.stackSize;
		} else {
			STACK_UNIT = 4;
		}
		
		sbInithal_c.append("\n#include \"ee.h\"\n");
		/***********************************************************************
		 * MULTI STACK
		 **********************************************************************/
		if (DEF__MULTI_STACK__.equals(stackType)) {
			sbInithal_c.append(commentWriterC
					.writerBanner("Stack definition for Tricore1"));
			
			ITreeInterface ti = vt.newTreeInterface();


			
			int[] irqSize = null;
			if (parent.checkKeyword(DEF__IRQ_STACK_NEEDED__)) {
				/***************************************************************
				 * IRQ_STACK
				 **************************************************************/
				
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
						+ "struct EE_CTX EE_tc1_system_ctx["+MAX_TASK+"+1] = {\n");

				
				
					
				// DESCRIPTIONS
				for (int j = 0; j < pos.length; j++) {
					sbStack.append(pre + post + indent + indent + "{ 0, NULL, " + +pos[j] + "}");
					// set new values for "post" and "pre"
					post = " /* " + tList.get(j) + " */\n";
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
						+ "struct EE_TOS EE_tcl_system_tos["
						+ (size.length) + "] = {\n");

				pre = "";
				post = "";
				
//				 DECLARE STACK SIZE && STACK (ARRAY)
				for (int j = 1; j < size.length; j++) {
				    long value = size[j][0];
				    value  = (value + (value%STACK_UNIT)) / STACK_UNIT; // arrottondo a 2
					sbStackDecl.append(indent1 + "EE_STACK EE_tcl_stack_"+j+"[STACK_"+j+"_SIZE];\t/* "+descrStack[j]+" */\n");
					sbStackDeclSize.append(indent1 + "#define STACK_"+j+"_SIZE "+value+" // size = "+size[j][0]+" bytes \n");
				}
				
				/*
				 * For each stack prepare the configuration's vectors and
				 * descriptions
				 */
				for (int j = 0; j < size.length; j++) {
				    
			        String value = j == 0 ? "{0}" : "{(EE_ADDR)(&EE_tcl_stack_"+j+"[STACK_" + j + "_SIZE - 3])}";

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
						+ "EE_UREG EE_tc1_active_tos = 0; /* dummy */\n\n");

				{ // if required, init also the irq stack
					if (irqSize != null) {
					    int j = size.length;
					    long value = irqSize[0];
					    value  = (value + (value%STACK_UNIT)) / STACK_UNIT; // arrottondo a 2
						sbStackDecl.append(indent1 + "EE_STACK EE_tcl_stack_"+j+"[STACK_"+j+"_SIZE];\t/* irq stack */\n");
						sbStackDeclSize.append(indent1 + "#define STACK_"+j+"_SIZE "+value+" // size = "+irqSize[0]+" bytes \n");

						sbStack
								.append(indent+"/* stack used only by IRQ handlers */\n"
										+ indent+"struct EE_TOS EE_tcl_IRQ_tos = {\n"
										+ indent+indent+"(EE_ADDR)(&EE_tcl_stack_"+j+"[STACK_" + j + "_SIZE - 3])\n"
										+ indent+"};\n\n");
					}
				}
				
			}
			

		}
		

		if 	(ool.getList(IOilObjectList.ISR).size() > 0) { // eecfg.h
			StringBuffer eecfg_h = answer.get(FILE_EE_CFG_H);
			eecfg_h.append(indent1 + "#define EE_MAX_ISR 32");
		}
		
		
		// MakeFile
		writeMakeFile(ool);
		writeIsrFile(ool, answer);

		// ------------- Write --------------------
		//  add stack buffers
		sbInithal_c.append(sbStackDeclSize+"\n"+
		        sbStackDecl + "\n" +
		        sbStack);

		
		
		return new IOilWriterBuffer[] { answer };
	}


	/**
	 * MakeFile
	 */
	private void writeMakeFile(final IOilObjectList ool) {
		final ISimpleGenRes sgrCpu = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
		final ICommentWriter commentWriterMf = getCommentWriter(sgrCpu, FileTypes.MAKEFILE);
		HostOsUtils wrapper = HostOsUtils.common;

		StringBuffer sbMakefile = new StringBuffer(commentWriterMf
				.writerBanner("Tricore"));

		{ // PATHs
			HashMap<String, ?> options = parent.getOptions();

			String outputDir = "Debug";
			String appBase = "..";
			// Get Default values

			if (options.containsKey(IWritersKeywords.WRITER_OUTPUT_DIR_SET)) {
				outputDir = (String) options
						.get(IWritersKeywords.WRITER_LAST_OUTPUT_DIR);
				outputDir = (String) options
						.get(IWritersKeywords.WRITER_FS_PATH_OUTPUT_DIR);

				appBase = (String) options
						.get(IWritersKeywords.WRITER_WS_OUTPUT_projectbase_DIR);// "..";
				if (options
						.containsKey(IWritersKeywords.WRITER_WS_PATH_OUTPUT_DIR)) {
					outputDir = (String) options
							.get(IWritersKeywords.WRITER_WS_PATH_OUTPUT_DIR);
				}
			}
			IPath p = new Path(outputDir);
			if (p.isAbsolute()) {
				outputDir = wrapper.wrapPath(outputDir);
			}
			
			String platformStr = "";
			if (HostOsUtils.common.getCurrentSystem() == HostOsUtils.LINUX) {
				platformStr = "export PLATFORM := LINUX\n\n";
			} else {
				platformStr = "export PLATFORM := CYGWIN\n\n";
			}
			
			String model = sgrCpu.containsProperty(TricoreConstants.SGRK__TRICORE_MODEL__) ?
					sgrCpu.getString(TricoreConstants.SGRK__TRICORE_MODEL__) : "";
			
			sbMakefile
					.append(platformStr
							+ "APPBASE := " + appBase + "\n"
							+ "OUTBASE := " + outputDir + "\n\n"
							+ "TRICORE1_MODEL  := " + model + "\n"
							+ "TRICORE1_GCCDIR := $(realpath $(shell dirname $(shell which tricore-gcc))/../)");
		}

		sgrCpu.setProperty(SGRK__MAKEFILE_EXTENTIONS__, sbMakefile.toString());

	}
	
	
	private void writeIsrFile(final IOilObjectList ool, IOilWriterBuffer buffers) throws OilCodeWriterException {
		final String indent1 = IWritersKeywords.INDENT;

		if 	(ool.getList(IOilObjectList.ISR).size() > 0) {
			StringBuffer isrFile_s = buffers.get(TricoreConstants.ISR_HANDLER_FILE);
			boolean enable_int = false;
			boolean enable_trap = false;
			
			/***************************************************************
			 * ISR table
			 **************************************************************/
			
			
			StringBuffer isrTable = new StringBuffer(
					"BEGIN_VECTOR_TABLE\n");

			StringBuffer trapTable = new StringBuffer(
					"BEGIN_TRAP_TABLE\n");
			
			// fill data for each task
			String pre = "";
			for (Iterator<ISimpleGenRes> iter = ool.getList(IOilObjectList.ISR).iterator(); iter.hasNext();) {

				ISimpleGenRes sgr = (ISimpleGenRes) iter.next();
				
				int category = sgr.getInt(ISimpleGenResKeywords.ISR_CATEGORY); 
				String level   = sgr.getString(TricoreConstants.SGRK__ISR_LEVEL__);
				String handler = sgr.getString(TricoreConstants.SGRK__ISR_HANDLER__);
				
				switch (category) {
				case 1:
					enable_int = true;
					isrTable.append(indent1 + "EE_ISR1_STUB " + level + " " + handler +"\n");
					break;
				case 2:
					enable_int = true;
					isrTable.append(indent1 + "EE_ISR2_STUB " + level + " " + handler +"\n");
					break;
				case 3:
					enable_trap = true;
					trapTable.append(indent1 + "EE_TRAP_STUB " + level + " " + handler +"\n");
					break;
				default:
					throw new OilCodeWriterException("Unsupported isr category (" + category + ") for isr " + sgr.getName());
				}
			}
			isrTable.append("END_VECTOR_TABLE\n" );
			trapTable.append("END_TRAP_TABLE\n" );
			
			isrFile_s.append(
					(enable_int ? "#include <cpu/tricore1/inc/ee_intstub.S>\n" : "") +
					(enable_trap ? "#include <cpu/tricore1/inc/ee_trapstub.S>\n" : "") +
					"\n" +
					(enable_int ? isrTable + "\n" : "") +
					(enable_trap ? trapTable : "") + "\n");
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
			}
		}
		return answer;
	}
}
