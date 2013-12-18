/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterHalMico32.java,v 1.17 2008/02/05 10:15:18 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.eu.evidence.rtdruid.desk.RtdruidLog;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.mico32.constants.Mico32Constants;
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
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStacks;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;

/**
 * This writer build files for a DS PIC CPU - Board
 * 
 * @author Nicola Serreli
 */
public class SectionWriterHalMico32 extends SectionWriter 
	implements IEEWriterKeywords,
			IExtractObjectsExtentions,
			IExtractKeywordsExtentions {

	
	final public String _EE_OPT_HAL_LATTICE_MICO32 = "__LM32__";
	final public String _EE_OPT_STATIC_ISR = "__STATIC_ISR_TABLE__";

	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;
	
	/** All data */
	protected final IVarTree vt;

	
	
	/**
	 * 
	 */
	public SectionWriterHalMico32() {
		this(null);
	}
	
	/**
	 * 
	 */
	public SectionWriterHalMico32(ErikaEnterpriseWriter parent) {
		super(IWritersKeywords.CPU_MICO_32,
				new String[] {}, //
				new String[] { //
					IWritersKeywords.CPU_NIOSII,//
					IWritersKeywords.CPU_JANUS,//
					IWritersKeywords.CPU_MPC5xx,//
					IWritersKeywords.CPU_NIOSII, //
					IWritersKeywords.CPU_AVR5,
					IWritersKeywords.CPU_PIC_30
					},
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

		return writeEE_MICO32_CPU();
	}
	
	/**
	 * This method add new keywords enabled by this writer.
	 */
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix) {
		
	}

	/**
	 * This method makes some changes to computed Oil Object
	 * @throws OilCodeWriterException if some ISR's attribute is missing 
	 */
	public void updateObjects() throws OilCodeWriterException {

		final IOilObjectList[] oilObjects = parent.getOilObjects();		
		
		final int currentRtosId = 0;
		final IOilObjectList ool = oilObjects[currentRtosId];

		/***********************************************************************
		 * 
		 * OS Properties
		 *  
		 **********************************************************************/
		{
	        for (ISimpleGenRes os : ool.getList(IOilObjectList.OS)) {
				for (final String currentCpuPrefix : (List<String>) os.getObject(SGRK_OS_CPU_DATA_PREFIX)) {
		        {
					String tmp1 = CommonUtils
							.getFirstChildEnumType(vt, currentCpuPrefix
									+ "USESTANDALONEPRINTF", null);
					if ("TRUE".equalsIgnoreCase(tmp1)) {
						os.setProperty(Mico32Constants.SGRK__MICO32_STANDALONE_PRINTF__, "true");
			        }
				}

				{
					String tmp1 = CommonUtils
						.getFirstChildEnumType(vt, currentCpuPrefix
									+ "USESMALLC", null);
					if ("TRUE".equalsIgnoreCase(tmp1)) {
						os.setProperty(Mico32Constants.SGRK__MICO32_SMALLC__, "true");
				    }
				}
				}
	        	
	        }

		}
		
		/***********************************************************************
		 * 
		 * EE OPTS
		 *  
		 **********************************************************************/
		{
			// here is enough to save everything in the first OS element
			final ISimpleGenRes sgrCpu = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
			//List requiredOilObjects = (List) sgrCpu.getObject(SGRK__FORCE_ARRAYS_LIST__);

	        ArrayList<String> tmp = new ArrayList<String>();
	        
	        // store all older values (if there are)
	        if (sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_EE_OPTS)) {
	        	String[] old = (String[]) sgrCpu.getObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS);
	        	tmp.addAll(Arrays.asList(old));
	        }
	
	        tmp.add(_EE_OPT_HAL_LATTICE_MICO32);

			if 	(ool.getList(IOilObjectList.ISR).size() > 0) {
				tmp.add(_EE_OPT_STATIC_ISR);
			}

			
			//  --------- board & mcu
			checkBoard(tmp);
			checkMcu(tmp); // note that mcu must done after board 
			
			
//			// ---------- Add crt0ram.S to sources
//			{	
//				List<String> src_files = new ArrayList<String>();
//				if (sgrCpu.containsProperty(ISimpleGenResKeywords.CPU_APP_SRC)) {
//					String[] files = (String[]) sgrCpu.getObject(ISimpleGenResKeywords.CPU_APP_SRC);
//					src_files.addAll(Arrays.asList(files));
//				}
//				if (!src_files.contains("$(OUTPUT_DIR)/crt0ram.S")) {
//					src_files.add("$(OUTPUT_DIR)/crt0ram.S");
//				}
//				sgrCpu.setObject(ISimpleGenResKeywords.CPU_APP_SRC, src_files.toArray(new String[src_files.size()]));
//			}

			// store ee_opts
			sgrCpu.setObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS, tmp.toArray(new String[tmp.size()]));
		}
		
		/***********************************************************************
		 * 
		 * Get ISR LEVEL and HANDLER
		 *  
		 **********************************************************************/
		{
			List<ISimpleGenRes> tasks = ool.getList(IOilObjectList.ISR);
			for (Iterator<ISimpleGenRes> iter = tasks.iterator(); iter.hasNext();) {

				ISimpleGenRes currIsr = (ISimpleGenRes) iter.next();
				
				{ // Check category
					String category = currIsr.containsProperty(ISimpleGenResKeywords.ISR_CATEGORY) ?
							currIsr.getString(ISimpleGenResKeywords.ISR_CATEGORY) : "";
					if (!"2".equals(category)) {
						throw new OilCodeWriterException("Mico32 supports only category 2 ISR (check "+currIsr.getName()+")." );
					}
					
					
				}
				
				if (!currIsr.containsProperty(Mico32Constants.SGRK__ISR_LEVEL__)) {
					throw new OilCodeWriterException("Required a LEVEL for the isr "+currIsr.getName()+".");
				}
				if (!currIsr.containsProperty(Mico32Constants.SGRK__ISR_HANDLER__)) {
					throw new OilCodeWriterException("The HANDLER for the isr "+currIsr.getName()+" is missing or incorrect.");
				}
			}

		}		


	}
	
	/**
	 * Write configuration's files for Lattice mico 32
	 * 
	 * @return buffers with configuration for Lattice mico 32
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeEE_MICO32_CPU()
			throws OilCodeWriterException {

		final String ERR_CPU_TYPE = "Lattice mico 32";
		final IOilObjectList[] oilObjects = parent.getOilObjects();		
		
		IOilWriterBuffer answer = new OilWriterBuffer();
		final int currentRtosId = 0;
		final String indent1 = IWritersKeywords.INDENT;
		final String indent2 = indent1 + IWritersKeywords.INDENT;
		final String indent3 = indent2 + IWritersKeywords.INDENT;

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
		final ICommentWriter commentWriterC = getCommentWriter(ool, FileTypes.C);

		List<ISimpleGenRes> taskNames = ool.getList(IOilObjectList.TASK);
		String stackType = parent.getStackType(); // MULTI or MONO


		// ------------- Compute --------------------

		sbInithal_c.append("\n#include \"ee.h\"\n");

		/***********************************************************************
		 * MULTI STACK
		 **********************************************************************/
		if (DEF__MULTI_STACK__.equals(stackType)) {

			// ------------- Buffers --------------------
			/* A buffer about stack  */
			StringBuffer sbStack = new StringBuffer();

			/* A buffer about declarations of stacks  */
			StringBuffer sbStackDecl = new StringBuffer();
			StringBuffer sbStackDecl_debug = new StringBuffer();
			StringBuffer sbStackDeclSize = new StringBuffer();

			
			sbInithal_c.append(commentWriterC
					.writerBanner("Stack definition for Lattice mico 32"));
			
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
					String type = CommonUtils.getFirstChildEnumType(
							vt, currentCpuPrefix
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
			//EEStacks elStack = new EEStacks(parent, ool, irqSize);
			EEStacks elStack = new EEStacks(parent, ool, null);
			elStack.setDummyStackPolicy(elStack.FORCE_ALWAYS | elStack.FORCE_FIRST);
			ArrayList<String> tList = new ArrayList<String>();
			ArrayList<String> tListN = new ArrayList<String>();

			final int STACK_UNIT = ErikaEnterpriseWriter.getStackUnit(ool);
			
			 
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
						+ "struct EE_TOS EE_mico32_system_tos["+ErikaEnterpriseWriter.addVectorSizeDefine(ool, "EE_mico32_system_tos", size.length)
						+ "] = {\n");

				pre = "";
				post = "";
				
//				 DECLARE STACK SIZE && STACK (ARRAY)
				for (int j = 1; j < size.length; j++) {
				    long value = size[j][0];
				    value  = (value + (value%STACK_UNIT)) / STACK_UNIT; // arrottondo a 2
					sbStackDecl.append(indent1 + "int EE_mico32_stack_"+j+"[STACK_"+j+"_SIZE];\t/* "+descrStack[j]+" */\n");
					sbStackDecl_debug.append(indent1 + "int EE_mico32_stack_"+j+"[STACK_"+j+"_SIZE + MICO32_STACK_DEBUG_LEN] = \n"+
								indent3 + "MICO32_STACK_INIT(STACK_"+j+"_SIZE);\t/* "+descrStack[j]+" */\n");
					sbStackDeclSize.append(indent1 + "#define STACK_"+j+"_SIZE "+value+" // size = "+size[j][0]+" bytes \n");
				}
				
				/*
				 * For each stack prepare the configuration's vectors and
				 * descriptions
				 */
				for (int j = 0; j < size.length; j++) {
				    
			        String value = j == 0 ? "{0}" : "{(EE_ADDR)(&EE_mico32_stack_"+j+"[STACK_"+j+"_SIZE - MICO32_INIT_TOS_OFFSET])}";

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
						+ "EE_UREG EE_mico32_active_tos = 0U; /* dummy */\n\n");

				{ // if required, init also the irq stack
					if (irqSize != null) {
					    int j = size.length;
					    long value = irqSize[0];
					    value  = (value + (value%STACK_UNIT)) / STACK_UNIT; // arrottondo a 2
						sbStackDecl.append(indent1 + "int EE_mico32_stack_"+j+"[STACK_"+j+"_SIZE];\t/* irq stack */\n");
						sbStackDecl_debug.append(indent1 + "int EE_mico32_stack_"+j+"[STACK_"+j+"_SIZE + MICO32_STACK_DEBUG_LEN] = \n"+
									indent3 + "MICO32_STACK_INIT(STACK_"+j+"_SIZE);\t/* irq stack */\n");
						sbStackDeclSize.append(indent1 + "#define STACK_"+j+"_SIZE "+value+" // size = "+irqSize[0]+" bytes \n");

						sbStack
								.append(indent+"/* stack used only by IRQ handlers */\n"
										+ indent+"struct EE_TOS EE_mico32_IRQ_tos = {\n"
										+ indent+indent+"(EE_ADDR)(&EE_mico32_stack_"+j+"[STACK_"+j+"_SIZE - MICO32_INIT_TOS_OFFSET])\n"
										+ indent+"};\n\n");
					}
				}
			
			}		

			//  add stack buffers
			sbInithal_c.append(sbStackDeclSize+"\n"+
					"#ifndef DEBUG_STACK\n" +
			        sbStackDecl +
			        "#else\n" +
			        sbStackDecl_debug+
			        "#endif\n\n" +
			        sbStack);
		}

		

		if 	(ool.getList(IOilObjectList.ISR).size() > 0) {
			/***************************************************************
			 * ISR table
			 **************************************************************/
			
			sbInithal_c.append(commentWriterC.writerBanner("Static ISR table") +
					indent1 + "#include <system_conf.h>\n" + 
					indent1 + "#include <cpu/mico32/inc/ee_irq_types.h>\n\n");
			
			StringBuffer isrDeclarations = new StringBuffer();
			StringBuffer isrTable = new StringBuffer(
					indent1 + "EE_mico32_ISR_handler MICO32_ISR_TABLE_QUALIFIER\n" +
					indent3 + "EE_mico32_ISR_table[MICO32_ISR_TABLE_LEN] = {\n");
			
			// fill data for each task
			pre = "";
			for (Iterator<ISimpleGenRes> iter = ool.getList(IOilObjectList.ISR).iterator(); iter.hasNext();) {

				ISimpleGenRes sgr = (ISimpleGenRes) iter.next();
				
				isrDeclarations.append(indent1 + "DECLARE_MICO32_ISR_HANDLER(" 
						+ sgr.getString(Mico32Constants.SGRK__ISR_HANDLER__)+ ");\n");
				
				isrTable.append(pre + indent2 
						+ "[" + sgr.getString(Mico32Constants.SGRK__ISR_LEVEL__)+ "] = " 
						+ sgr.getString(Mico32Constants.SGRK__ISR_HANDLER__));
				
				pre = ",\n";
			}
			isrTable.append("\n"+indent1 + "};\n" );

			sbInithal_c.append(isrDeclarations + "\n"
					+ isrTable);
		}

		
		// ------------- JTAG --------------------
		
		
//		sbInithal_c.append(
//				commentWriterC.writerBanner("If necessary, init JTag\nThen invoke application") +
//				indent1 + "#include \"DDStructs.h\"\n\n"+
//				indent1 + "void LatticeDDInit(void)\n" +
//				indent1 + "{\n" +
//				"#if 0\n" +
//				indent2 + commentWriterC.writerSingleLineComment("Initialize LM32 instance of lm32_top") +
//				indent2 +"LatticeMico32Init(&lm32_top_LM32);\n" +
//				indent2 + commentWriterC.writerSingleLineComment("Needed only to use the Jtag interface for I/O") +
//				"#endif\n\n" +
//				indent2 + commentWriterC.writerSingleLineComment("Invoke application's main routine") +
//				indent2 + "main();\n" +
//				indent1 + "}\n\n");
		

		//  ------------- BOARD DEFINITIONS ---------------

		StringBuffer eecfg_h = answer.get(FILE_EE_CFG_H);

		eecfg_h.append(commentWriterC.writerBanner("Mico 32 platform") +
				"#include <system_conf.h>\n\n");

		{
			String txt = AbstractRtosWriter.getOsProperty(ool, Mico32Constants.SGRK__MICO32_BOARD_EEC_DEFINES__);

			if (txt != null) {
				eecfg_h.append(commentWriterC.writerBanner("Mico 32 Board defines") +
						txt);
			}
		}
		
		//  ------------- MORE FILES ---------------
		
		
		// makefile
		prepareMakeFile(ool);

		// Add crt0ram.s file
		//addCrt0ramFile(answer);

		// .mk files
		Mico32McuLattice.addPlatformFile(ool, answer);
		addLatticeFile(ool, answer);
		
		return new IOilWriterBuffer[] { answer };
	}

	
	
	/*
	 * Parse and write the MCU Section
	 */
	private void checkMcu(ArrayList<String> ee_opts) throws OilCodeWriterException {
		(new Mico32McuLattice(parent)).checkMcu(ee_opts);
	}
	
	
//	void addCrt0ramFile(IOilWriterBuffer answer) {
//		StringBuffer buffer = answer.get("crt0ram.S");
//		try {
//			InputStream input = getClass().getClassLoader().getResourceAsStream("/com/eu/evidence/modules/oil/mico32/templates/crt0ram.S");
//			if (input != null) {
//				input = new BufferedInputStream(input);
//			} else {
//				RtdruidLog.showDebug("Cannot open crt0Ram.S file");
//			}
//			for (int a=-1; (a=input.read()) >=0; ) {
//				buffer.append((char)a);
//			}
//		} catch (IOException e) {
//			RtdruidLog.showDebug("Cannot read crt0Ram.S file");
//			RtdruidLog.showDebug(e);
//		}
//		
//	}
	
	
	void addLatticeFile(IOilObjectList ool, IOilWriterBuffer answer) {
		final ICommentWriter commentWriterMf = getCommentWriter(ool, FileTypes.MAKEFILE);
		StringBuffer buffer = answer.get("lattice.mk");
		
		final String cflags = "true".equalsIgnoreCase(AbstractRtosWriter.getOsProperty(ool, Mico32Constants.SGRK__MICO32_STANDALONE_PRINTF__)) ?
				"-D_USE_LSCC_PRINTF_" : "";
		final String clib = "true".equalsIgnoreCase(AbstractRtosWriter.getOsProperty(ool, Mico32Constants.SGRK__MICO32_SMALLC__)) ?
				"-lsmallc" : "-lc";
		
		// Dynamic part
		buffer.append(
				commentWriterMf.writerBanner("Settings for the Lattice building environment\n\n"+
						"Automatically generated from 'conf.oil'") +

				"# Use standalone printf implementation: -D_USE_LSCC_PRINTF_\n"+
				"CFLAGS += " + cflags + "\n\n" +
				"# C library to use.\n" +
				"C_LIB := " + clib + "\n\n");
				
	}

	void prepareMakeFile(IOilObjectList ool) {
		final ICommentWriter commentWriterMf = getCommentWriter(ool, FileTypes.MAKEFILE);
		/***********************************************************************
         * 
         * MAKE FILE
         *  
         **********************************************************************/
		OsType wrapper = HostOsUtils.common.getTarget();

		    StringBuffer sbMakefile_variables = new StringBuffer(commentWriterMf.writerBanner("Lattice mico 32"));
		    
		    {	// PATHs
	        	HashMap<String, ?> options = parent.getOptions();

		        String outputDir = "Debug";
		        String appBase = "..";
		        
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
		    	
		    	
		        sbMakefile_variables.append(
		                "APPBASE := " + appBase + "\n" +
		                "OUTBASE := " + outputDir + "\n\n" +
		                "ifndef OUTPUT_DIR\n" +
		                "OUTPUT_DIR := .\n" +
		                "else\n" +
		                "APPBASE := .\n" +
		                "endif\n\n"
		                
//		                "LD_FILE = $(OUTPUT_DIR)/linker.ld\n\n"
		        );
		    }

		    ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
            sgrCpu.setProperty(SGRK__MAKEFILE_EXTENTIONS__, sbMakefile_variables.toString());

            
            sgrCpu.setProperty(SGRK__MAKEFILE_AFTER_FILES__,
            		commentWriterMf.writerBanner("More rules for Lattice mico 32") +
            		"include $(OUTPUT_DIR)/platform.mk\n" +
	                "include $(OUTPUT_DIR)/lattice.mk\n\n" +
//	                include $(EEBASE)/pkg/cfg/rules.mk

	                "# Remove the crt*.o files from the building process\n" +
	                "$(LD_FILE): $(PLATFORM_LD_FILE)\n" +
	                "	@echo \"Patching linker script\"\n" +
	                "	$(QUIET) grep -v -E '^INPUT\\(' $< > $@\n\n"
            );

	}
	

	
	
	/*
	 * Parse and write the BOARD Section
	 */
	private void checkBoard(ArrayList<String> ee_opts) throws OilCodeWriterException {
		final String fpg_eye = "FPG_EYE";
		final String xp2_camera = "XP2_CAMERA_BOARD";
		final String xp2_evaluation_board = "LATTICE_XP2_EV_BOARD";
		
		String currentBoard = null;
		AMico32Board cameraBoard = null;
		
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		for (int currentRtosId = 0; currentRtosId  < oilObjects.length; currentRtosId++) {  
			
			ArrayList<String> childPaths = new ArrayList<String>();
			List<String> childFound = parent.getRtosCommonChildType(oilObjects[currentRtosId], "BOARD_DATA", childPaths);

			for (int index = 0; index<childFound.size(); index++) {
				String board_type = childFound.get(index); 
			
				/***********************************************************************
				 * get values and store as EE_OPT
				 **********************************************************************/

				if (currentBoard == null) {
					currentBoard = board_type;
	
					String currentMcuPrefix = childPaths.get(index) + PARAMETER_LIST;
	
					if (xp2_camera.equals(board_type)) {
						cameraBoard = new Mico32BoardXP2Camera(vt);
						cameraBoard.check(currentMcuPrefix);
	
					} else if (fpg_eye.equals(board_type)) {
						cameraBoard = new Mico32BoardEYE(vt);
						cameraBoard.check(currentMcuPrefix);
	
					} else if (xp2_evaluation_board.equals(board_type)) {
						cameraBoard = new Mico32BoardLatticeXP2EvaluationBoard(vt);
						cameraBoard.check(currentMcuPrefix);
	
					} else if (board_type != null){
						// note that if the execution is here, it means that the oil
						// accept this board
						RtdruidLog.showDebug("Unknonw mico32 board " + board_type);
					}
					
				} else if (!currentBoard.equals(board_type)) {
					throw new OilCodeWriterException("Mico32: found more than one type of board. "+currentBoard+" and " + board_type );					
				}

			}

		}
		
		if (cameraBoard != null) { 
			cameraBoard.updateObjects(oilObjects, ee_opts);
		}
	}

	
	
	
	
	/**
	 * This metod takes an array and returns the first element, or null if the
	 * array is a zero-length array or if the first element is empty ("" or
	 * null)
	 */
	static String clean(String[] arr) {
		String answer = null;
		if (arr != null && arr.length>0) {
			if (arr[0].trim().length()>0) {
				answer= arr[0].trim();
			}
		}
		return answer;
	}
	

}
