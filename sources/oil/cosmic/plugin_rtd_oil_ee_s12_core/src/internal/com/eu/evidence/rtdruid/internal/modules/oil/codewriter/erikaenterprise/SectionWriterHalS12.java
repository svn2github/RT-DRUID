package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;
/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterHalPic30.java,v 1.17 2008/02/05 10:15:18 durin Exp $
 */


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.desk.RtdruidLog;
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
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuUtility;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStacks;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.modules.oil.s12.Activator;
import com.eu.evidence.rtdruid.modules.oil.s12.constants.S12Constants;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;

/**
 * This writer build files for a Freescale S12 CPU - Board
 * 
 * @author Nicola Serreli
 */
public class SectionWriterHalS12 extends SectionWriter 
	implements IEEWriterKeywords,
			IExtractObjectsExtentions,
			IExtractKeywordsExtentions {

	final public String KEY_HAL_FREESCALE_S12 = "__HCS12XS__";
	final public String _EE_OPT_HAL_S12 = "__MC9S12__";
	final public String _EE_OPT_COSMIC_COMPILER = "__COSMIC__";
	final public String _EE_OPT_CODEWARRIOR_COMPILER = "__CODEWARRIOR__";
	
	
	static class MCU_MODEL {
		public final String name;
		public final String model;
		public final String ee_opt;
		public final String linkerScript;
		public final String include_h;
		public final String include_c;
		public final String include_s;
		MCU_MODEL(String name, String model, String ee_opt, String linker, String inc_h, String inc_c, String inc_s) {
			this.name = name;
			this.model = model;
			this.ee_opt = ee_opt;
			this.linkerScript = linker;
			this.include_h = inc_h;
			this.include_c = inc_c;
			this.include_s = inc_s;
		}
	}
	final protected String S12_MCU = "MC9S12";
	final protected String S12_MCU_OLD_NAME = "S12XS";
	final protected String CUSTOM_MCU = "CUSTOM";
	final protected static HashMap<String, MCU_MODEL> STANDARD_MCU_PROPERTIES_COSMIC = new HashMap<String, MCU_MODEL>();
	final protected static HashMap<String, MCU_MODEL> STANDARD_MCU_PROPERTIES_CODEWARRIOR = new HashMap<String, MCU_MODEL>();

	class EE_S12_BOARD_MODEL {
		public final String name;
		public final String def;
		public final List<String> properties;
		public final String[] defines;
		EE_S12_BOARD_MODEL(String name, String def, String[] properties, String[] defines) {
			this.name = name;
			this.def  = def;
			List<String> tmp = Arrays.asList(properties);
			Collections.sort(tmp);
			this.properties = Collections.unmodifiableList( tmp );
			this.defines = defines;
		}
		public int searchProp(String property) {
			return Collections.binarySearch(properties, property);
		}
	}
	
	static {
		loadMCU_properties();
	}
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;
	
	/** All data */
	protected final IVarTree vt;
	
	
	/**
	 * 
	 */
	public SectionWriterHalS12() {
		this(null);
	}
	
	/**
	 * 
	 */
	public SectionWriterHalS12(ErikaEnterpriseWriter parent) {
		super(IWritersKeywords.CPU_S12,
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

	protected boolean enabled() {

		return Collections.binarySearch(keywords, IWritersKeywords.CPU_S12) >= 0 ||  Collections.binarySearch(keywords, IWritersKeywords.CPU_S12_OLD_NAME) >= 0;
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

		return writeEE_S12_CPU();
	}
	
	/**
	 * This method add new keywords enabled by this writer.
	 */
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix) {
		
		// UPDRTD controllare !!
		if (!keywords.contains(KEY_HAL_FREESCALE_S12)) {
			keywords.add(KEY_HAL_FREESCALE_S12);
		}
		
	}

	/**
	 * This method makes some changes to computed Oil Object
	 */
	public void updateObjects() throws OilCodeWriterException {

		final IOilObjectList[] oilObjects = parent.getOilObjects();		
		
		final int currentRtosId = 0;
		final IOilObjectList ool = oilObjects[currentRtosId];

		/***********************************************************************
		 * 
		 * EE OPTS
		 *  
		 **********************************************************************/
		{
			//List requiredOilObjects = (List) sgrCpu.getObject(SGRK__FORCE_ARRAYS_LIST__);
			boolean found_codewarrior = false; 
			{
				String[] existing = parent.extractUserOptions(currentRtosId);
				
				for (String s: existing) {
					if (_EE_OPT_CODEWARRIOR_COMPILER.equals(s)) {
						found_codewarrior = true;
						break;
					}
				}
			}

	        ArrayList<String> tmp = new ArrayList<String>();
	        
	        // store all older values (if there are)
	        for (Object all : AbstractRtosWriter.getOsObjects(ool, ISimpleGenResKeywords.OS_CPU_EE_OPTS)) {
	        	String[] old = (String[]) all;
	        	tmp.addAll(Arrays.asList(old));
	        }
	
	        if (found_codewarrior) {
	        	tmp.add(_EE_OPT_CODEWARRIOR_COMPILER);
	        } else {
	        	tmp.add(_EE_OPT_COSMIC_COMPILER);
	        }
	        tmp.add(_EE_OPT_HAL_S12);

			// mcu
			checkMcu(tmp);
			// Board
			checkBoard(tmp);
			
			ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
			sgrCpu.setObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS, tmp.toArray(new String[tmp.size()]));
		}

	}
	
	/**
	 * Write configuration's files for Freescale S12
	 * 
	 * @return buffers with configuration for Freescale S12
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeEE_S12_CPU()
			throws OilCodeWriterException {

		final String ERR_CPU_TYPE = "Freescale S12";
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
		final ICommentWriter commentWriterC = getCommentWriter(ool, FileTypes.C);
		final ICommentWriter commentWriterH = getCommentWriter(ool, FileTypes.H);
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

		sbInithal_c.append("\n#include \"ee.h\"\n");

		final int STACK_UNIT = ErikaEnterpriseWriter.getStackUnit(ool);

		/***********************************************************************
		 * MULTI STACK
		 **********************************************************************/
		if (DEF__MULTI_STACK__.equals(stackType)) {
			sbInithal_c.append(commentWriterC
					.writerBanner("Stack definition for Freescale S12"));
			
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
						+ "EE_UREG EE_s12_thread_tos["+MAX_TASK+"+1] = {\n");

				
				
					
				// DESCRIPTIONS
				for (int j = 0; j < pos.length; j++) {
					sbStack.append(pre + post + indent + indent + +pos[j]+"U");
					// set new values for "post" and "pre"
					post = commentWriterH.writerSingleLineComment(tList.get(j)); // + "*/\n";
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
						+ "struct EE_TOS EE_s12_system_tos["+ErikaEnterpriseWriter.addVectorSizeDefine(ool, "EE_s12_system_tos", size.length)
						+ "] = {\n");

				pre = "";
				post = "";
				
//				 DECLARE STACK SIZE && STACK (ARRAY)
				for (int j = 1; j < size.length; j++) {
				    long value = size[j][0];
				    value  = (value + (value%STACK_UNIT)) / STACK_UNIT; // arrottondo a 2
					sbStackDecl.append(indent1 + "int EE_s12_stack_"+j+"[STACK_"+j+"_SIZE];\t" + commentWriterH.writerSingleLineComment(descrStack[j])); //+" */\n");
					sbStackDeclSize.append(indent1 + "#define STACK_"+j+"_SIZE "+value+" // size = "+size[j][0]+" bytes \n");
				}
				
				/*
				 * For each stack prepare the configuration's vectors and
				 * descriptions
				 */
				for (int j = 0; j < size.length; j++) {
				    
			        String value = j == 0 ? "{0}" : "{(EE_ADDR)(&EE_s12_stack_"+j+"[STACK_"+j+"_SIZE -3])}";

					sbStack.append(pre
							+ post
							+ indent
							+ indent
							+ value);

					// set new values for size
					pre = ",";
					post = "\t"+ commentWriterH.writerSingleLineComment(descrStack[j]); //+" */\n";
				}

				// complete the stack's buffer
				sbStack.append(" " + post + indent + "};\n\n" + indent
						+ "EE_UREG EE_s12_active_tos = 0U; " + commentWriterH.writerSingleLineComment("dummy") +"\n");

				{ // if required, init also the irq stack
					if (irqSize != null) {
					    int j = size.length;
					    long value = irqSize[0];
					    value  = (value + (value%STACK_UNIT)) / STACK_UNIT; // arrottondo a 2
						sbStackDecl.append(indent1 + "int EE_s12_stack_"+j+"[STACK_"+j+"_SIZE];\t" + commentWriterH.writerSingleLineComment("irq stack")); // */\n");
						sbStackDeclSize.append(indent1 + "#define STACK_"+j+"_SIZE "+value+" // size = "+irqSize[0]+" bytes \n");

						sbStack
								.append(indent+commentWriterH.writerSingleLineComment("stack used only by IRQ handlers") //\n"
										+ indent+"struct EE_TOS EE_s12_IRQ_tos = {\n"
										+ indent+indent+"(EE_ADDR)(&EE_s12_stack_"+j+"[STACK_"+j+"_SIZE -3])\n"
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
			
			
			boolean found_codewarrior = usingCodewarriorCompiler(ool);
			

		    StringBuffer sbMakefile = new StringBuffer(commentWriterMf.writerBanner("Freescale S12"));
		    
		    {	// PATHs
	        	HashMap<String, ?> options = parent.getOptions();

		        String outputDir = "Debug";
		        String appBase = "..";
		        String gcc = found_codewarrior ? S12Constants.DEFAULT_S12_CODEWARRIOR_CONF_GCC : S12Constants.DEFAULT_S12_COSMIC_CONF_GCC;
//		        String asm = wrapper.wrapPath(found_codewarrior ? S12Constants.DEFAULT_S12_CODEWARRIOR_CONF_GCC : S12Constants.DEFAULT_S12_COSMIC_CONF_GCC);
		        
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
		        		CommonUtils.addMakefileDefinesInclude() +
		                "APPBASE := " + appBase + "\n" +
		                "OUTBASE := " + outputDir + "\n\n"); 

		    	if (found_codewarrior) {
			    	if (options.containsKey(S12Constants.PREF_S12_CODEWARRIOR_PATH) ) {
						String tmp = (String) options.get(S12Constants.PREF_S12_CODEWARRIOR_PATH);
						if (tmp.length()>0) gcc = tmp;
					}
		    	} else {
			    	if (options.containsKey(S12Constants.PREF_S12_COSMIC_PATH) ) {
						String tmp = (String) options.get(S12Constants.PREF_S12_COSMIC_PATH);
						if (tmp.length()>0) gcc = wrapper.wrapPath(tmp);
					}
		    	}
	    		sbMakefile.append( 
	    				CommonUtils.compilerMakefileDefines(gcc, "S12_ASMDIR", wrapper) +
	    				CommonUtils.compilerMakefileDefines(gcc, "S12_CCDIR", wrapper) );

		    }

		    ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
			CpuUtility.addSources(sgrCpu, new String[] {"$(S12_INCLUDE_C)", "$(S12_INCLUDE_S)"});
            sgrCpu.setProperty(SGRK__MAKEFILE_EXTENTIONS__, sbMakefile.toString());

		}
		
		// MCU
		mcuWrite(answer);

		return new IOilWriterBuffer[] { answer };
	}

	private boolean usingCodewarriorCompiler(final IOilObjectList ool) {
		boolean found_codewarrior = false;
		for (Object all : AbstractRtosWriter.getOsObjects(ool, ISimpleGenResKeywords.OS_CPU_EE_OPTS)) {
			if (!found_codewarrior) {
				for (String s : (String[]) all) {
					if (_EE_OPT_CODEWARRIOR_COMPILER.equals(s)) {
						found_codewarrior = true;
						break;
					}
				}
			}
		}

		return found_codewarrior;
	}

	
	/*
	 * Parse and write the MCU Section
	 */
	private void mcuWrite(IOilWriterBuffer buffers) {

//		final String S12_MCU = "COSMIC_S12XS";
//		final String CUSTOM_MCU = "CUSTOM";

		final IOilObjectList[] oilObjects = parent.getOilObjects();
		final int currentRtosId = 0;
		final IOilObjectList ool = oilObjects[currentRtosId];
		
		/* COMMON VARIABLES */
		String mcu_model = null;	// != null only if found a valid mcu
		MCU_MODEL mcu_properties = null;
		final HashMap<String, MCU_MODEL> STANDARD_MCU_PROPERTIES = usingCodewarriorCompiler(ool) ?
				STANDARD_MCU_PROPERTIES_CODEWARRIOR : STANDARD_MCU_PROPERTIES_COSMIC;

		
		{
			/***********************************************************************
			 * get values
			 **********************************************************************/
			ArrayList<String> childPaths = new ArrayList<String>();
			List<String> childFound = parent.getRtosCommonChildType(oilObjects[currentRtosId], "MCU_DATA", childPaths);

			for (int index = 0; index<childFound.size(); index++) {
				String mcu_type = childFound.get(index);
				if (mcu_model != null) {
					break;
				}
				
				String currentMcuPrefix = childPaths.get(index) + PARAMETER_LIST + "MODEL";
				
				if ((S12_MCU.equals(mcu_type) || S12_MCU_OLD_NAME.equals(mcu_type))) {
	
	
					String[] child = new String[1];
					String model_type = CommonUtils.getFirstChildEnumType(vt, currentMcuPrefix, child);
					
					/* CUSTOM */
					if (CUSTOM_MCU.equals(model_type)) {
						// read also LINKERSCRIPT, DEV_LIB, INCLUDE_C, INCLUDE_S
						currentMcuPrefix += VARIANT_ELIST + child[0] + PARAMETER_LIST;
						String[] model = CommonUtils.getValue(vt, currentMcuPrefix+"MODEL");
						String[] linker = CommonUtils.getValue(vt, currentMcuPrefix+"LINKERSCRIPT");
						String[] inc_h  = CommonUtils.getValue(vt, currentMcuPrefix+"INCLUDE_H");
						String[] inc_c  = CommonUtils.getValue(vt, currentMcuPrefix+"INCLUDE_C");
						String[] inc_s  = CommonUtils.getValue(vt, currentMcuPrefix+"INCLUDE_S");
						
						mcu_properties = new MCU_MODEL(
								CUSTOM_MCU,
								clean(model),
								"__"+clean(model)+"__",
								clean(linker),
								clean(inc_h),
								clean(inc_c),
								clean(inc_s)
						);
						mcu_model = CUSTOM_MCU;
					} else {
							/* STANDARD MCU */
						mcu_properties = STANDARD_MCU_PROPERTIES.get(model_type);
						if (mcu_properties != null) {
							mcu_model = model_type;
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
			ISimpleGenRes os = ool.getList(IOilObjectList.OS).get(0);
			String temp = os.getString(SGRK__MAKEFILE_EXTENTIONS__);
			StringBuffer answerBuffer = new StringBuffer();
			if (temp != null) {
				answerBuffer.append(temp);
			}
			final ICommentWriter commentWriterMf = getCommentWriter(ool, FileTypes.MAKEFILE);

			answerBuffer.append(commentWriterMf.writerBanner("Init MCU for S12 ("+mcu_model+")"));
	
			// complete the table
				answerBuffer.append("S12_MODEL           := " +mcu_properties.model + "\n"); 
			if (mcu_properties.linkerScript != null)
				answerBuffer.append("S12_LINKERSCRIPT    := " +mcu_properties.linkerScript + "\n"); 
			if (mcu_properties.include_h != null)
				answerBuffer.append("S12_INCLUDE_H       := " +mcu_properties.include_h + "\n");
			if (mcu_properties.include_c != null)
				answerBuffer.append("S12_INCLUDE_C       := " +mcu_properties.include_c + "\n");
			if (mcu_properties.include_s != null)
				answerBuffer.append("S12_INCLUDE_S       := " +mcu_properties.include_s + "\n");

            os.setProperty(SGRK__MAKEFILE_EXTENTIONS__, answerBuffer.toString());

		}
	}

	/*
	 * Parse and write the BOARD Section
	 */
	private void checkBoard(ArrayList<String> ee_opts) throws OilCodeWriterException {
		class BOARD_MODEL {
			public final String name;
			public final String def;
			public final String[] properties;
			public final String[] defines;
			BOARD_MODEL(String name, String def, String[] properties, String[] defines) {
				this.name = name;
				this.def  = def;
				this.properties = properties;
				this.defines = defines;
			}
		}
		final HashMap<String, BOARD_MODEL> STANDARD_BOARD_PROPERTIES = new HashMap<String, BOARD_MODEL>();
		/* Add standard MCU and theris properties */ 
		STANDARD_BOARD_PROPERTIES.put("NO_BOARD", new BOARD_MODEL(
				"NO_BOARD", // name
				null,
				new String[0],
				new String[0]));

		final String S12_NAME = "DEMO9S12XSFAME";
		STANDARD_BOARD_PROPERTIES.put(S12_NAME, new BOARD_MODEL(
				S12_NAME, // name
				"__DEMO9S12XSFAME__",
				new String[] {},
				new String[] {}));
		
		final String S12_TOWER_NAME = "TWRS12G128";
		STANDARD_BOARD_PROPERTIES.put(S12_TOWER_NAME, new BOARD_MODEL(
				S12_TOWER_NAME, // name
				"__TWRS12G128__",
				new String[] {},
				new String[] {}));

		final IOilObjectList[] oilObjects = parent.getOilObjects();
		final int currentRtosId = 0;
		
		{
			/***********************************************************************
			 * get values and store as EE_OPT
			 **********************************************************************/
			ArrayList<String> childPaths = new ArrayList<String>();
			List<String> childFound = parent.getRtosCommonChildType(oilObjects[currentRtosId], "BOARD_DATA", childPaths);

			for (int index = 0; index<childFound.size(); index++) {
				String board_type = childFound.get(index);
				
				/* STANDARD BOARD */
				BOARD_MODEL board_properties = STANDARD_BOARD_PROPERTIES.get(board_type);
				if (board_properties != null) {
					String currentBoardPrefix = childPaths.get(index) + PARAMETER_LIST;
					
					if (board_properties.def!= null && !ee_opts.contains(board_properties.def)) {
						ee_opts.add(board_properties.def);
					}
	
					if (S12_NAME.equals(board_properties.name)) {
						String s12xs_mcu = "MC9S12XS128";
						if (!ee_opts.contains("__"+s12xs_mcu+"__")) { // requires s12xs cpu
							throw new OilCodeWriterException(S12_NAME + " board requires the " +s12xs_mcu+ " mcu");
						}
						
						EE_S12_BOARD_MODEL board_options =	new EE_S12_BOARD_MODEL(
								null, //"DEMO", // name
								null, //"__USE_DEMOBOARD__",
								new String[] {
										"POTENTIOMETEER",
										"ADC",
										"BUTTONS",
										"LEDS",
										"LIGHT_SENSOR",
										},
								new String[] {
										"__USE_POTENTIOMETER__",
										"__USE_ADC__",
										"__USE_BUTTONS__",
										"__USE_LEDS__",
										"__USE_LIGHT_SENSOR__",
										});
						
						check_S12Board(ee_opts, currentBoardPrefix, board_options);
						
					} else if (S12_TOWER_NAME.equals(board_properties.name)) {
						String s12g_mcu = "MC9S12G128";
						if (!ee_opts.contains("__"+s12g_mcu+"__")) { // requires s12g cpu
							throw new OilCodeWriterException(S12_TOWER_NAME + " board requires the " +s12g_mcu+ " mcu");
						}
						EE_S12_BOARD_MODEL board_options =	new EE_S12_BOARD_MODEL(
								null, //"DEMO", // name
								null, //"__USE_DEMOBOARD__",
								new String[] {
										// ALL present by default
										"SCI",
										"BUTTONS",
										"LEDS"
										},
								new String[] {
										"__USE_SCI__",
										"__USE_BUTTONS__",
										"__USE_LEDS__"
										});
						
						check_S12Board(ee_opts, currentBoardPrefix, board_options);					
					}
					
					for (int i=0; i<board_properties.properties.length; i++) {
						String tmp = board_properties.properties[i];
						
						String value_type = CommonUtils.getFirstChildEnumType(vt, currentBoardPrefix+tmp, null);
						
						if ("TRUE".equals(value_type) && !ee_opts.contains(board_properties.defines[i])) {
							ee_opts.add(board_properties.defines[i]);
						}
					}
				}
			}

		}
	}

	/*
	 * Parse and write the BOARD Section
	 */
	private void check_S12Board(ArrayList<String> ee_opts, String currentMcuPrefix, EE_S12_BOARD_MODEL board_properties) {
		/***********************************************************************
		 * get values and store as EE_OPT
		 **********************************************************************/

		currentMcuPrefix += "OPTIONS";

		if (board_properties.def != null
				&& !ee_opts.contains(board_properties.def)) {
			ee_opts.add(board_properties.def);
		}

		ArrayList<String> board_options = CommonUtils.getAllChildrenEnumType(
				vt, currentMcuPrefix, null);

		if (board_options != null) {
			for (int i = 0; i < board_options.size(); i++) {
				String opt = (String) board_options.get(i);

				int index = board_properties.searchProp(opt);
				if ("ALL".equals(opt)) {

					for (int j = 0; j < board_properties.defines.length; j++) {
						if (!ee_opts.contains(board_properties.defines[j])) {
							ee_opts.add(board_properties.defines[j]);
						}
					}
					break; // already added every options

				} else if (index == -1) {
					Messages.sendError(
							"Option not valid for selected flex board : " + opt,
							null, "board_option_1", null);
					continue;
				} else {

					if (!ee_opts.contains(board_properties.defines[index])) {
						ee_opts.add(board_properties.defines[index]);
					}
				}
			}
		}

	}

	
	/*
	 * Parse and write the MCU Section
	 */
	private void checkMcu(ArrayList<String> ee_opts) throws OilCodeWriterException {

		final IOilObjectList[] oilObjects = parent.getOilObjects();
		final int currentRtosId = 0;
		
		/* COMMON VARIABLES */
		//String mcu_model = null;	// != null only if found a valid mcu
		MCU_MODEL mcu_properties = null;
		final HashMap<String, MCU_MODEL> STANDARD_MCU_PROPERTIES = ee_opts.contains(_EE_OPT_CODEWARRIOR_COMPILER) ?
				STANDARD_MCU_PROPERTIES_CODEWARRIOR : STANDARD_MCU_PROPERTIES_COSMIC;

		{
			/***********************************************************************
			 * get values
			 **********************************************************************/
			ArrayList<String> childPaths = new ArrayList<String>();
			List<String> childFound = parent.getRtosCommonChildType(oilObjects[currentRtosId], "MCU_DATA", childPaths);

			for (int index = 0; index<childFound.size(); index++) {
				String mcu_type = childFound.get(index);
				if (mcu_properties == null) {
	
					if ((S12_MCU.equals(mcu_type) || S12_MCU_OLD_NAME.equals(mcu_type))) {
						String mcu_model = null;
						// .. get Model
						{
							// ... and compete it 
							String modelPath = childPaths.get(index) + PARAMETER_LIST + "MODEL";
		
							String[] child = new String[1];
							String model_type = CommonUtils.getFirstChildEnumType(vt, modelPath, child);
							
							/* CUSTOM */
							if (CUSTOM_MCU.equals(model_type)) {
								// read also LINKERSCRIPT, DEV_LIB, INCLUDE_C, INCLUDE_S
								modelPath += VARIANT_ELIST + child[0] + PARAMETER_LIST;
								String[] model = CommonUtils.getValue(vt, modelPath+"MODEL");
								String[] linker = CommonUtils.getValue(vt, modelPath+"LINKERSCRIPT");
								String[] inc_h  = CommonUtils.getValue(vt, modelPath+"INCLUDE_H");
								String[] inc_c  = CommonUtils.getValue(vt, modelPath+"INCLUDE_C");
								String[] inc_s  = CommonUtils.getValue(vt, modelPath+"INCLUDE_S");
								
								mcu_properties = new MCU_MODEL(
										CUSTOM_MCU,
										clean(model),
										"__"+clean(model)+"__",
										clean(linker),
										clean(inc_h),
										clean(inc_c),
										clean(inc_s)
								);
								mcu_model = CUSTOM_MCU;
							} else {
									/* STANDARD MCU */
								mcu_properties = STANDARD_MCU_PROPERTIES.get(model_type);
								if (mcu_properties != null) {
									mcu_model = model_type;
								} else {
									throw new OilCodeWriterException("Unsupported mcu (" + model_type+")");
								}
							}
						}
						
						
						
						// .. get options
						{
							String optPath = childPaths.get(index) + PARAMETER_LIST;
							String[] names = new String[] {"SERIAL", "TIMER"};
							String[] eeopt;
							if ("MC9S12G128".equals(mcu_model)) {
								eeopt = new String[] {"__USE_SCI__", "__USE_TIMER__"};
							} else if ("MC9S12XS128".equals(mcu_model)) {
								eeopt = new String[] {"__USE_SCI__", "__USE_TIMER__ __USE_PIT__"};
							} else {
								eeopt = new String[] {"__USE_SCI__", "__USE_TIMER__ __USE_PIT__"};
							}
							
							for (int i=0; i<names.length; i++) {
								String tmp = names[i];
								
								String value_type = CommonUtils.getFirstChildEnumType(vt, optPath+tmp, null);
								
								if ("TRUE".equals(value_type)) {
									for (String s: eeopt[i].split(" ")) {
										if (!ee_opts.contains(s)) {
											ee_opts.add(s);
										}
									}
								}
							}
		
						}
						
						//
							{
							String modelPath = childPaths.get(index) + PARAMETER_LIST + "MODEL";
							String[] child = new String[1];
							String model_type = CommonUtils.getFirstChildEnumType(vt, modelPath, child);
							
							/* CUSTOM */
							if (CUSTOM_MCU.equals(model_type)) {
								
								// read only MODEL
								modelPath += VARIANT_ELIST + child[0] + PARAMETER_LIST;
								String model = clean(CommonUtils.getValue(vt, modelPath+"MODEL"));
								if (model != null && !ee_opts.contains("__"+model+"__")) {
									ee_opts.add("__"+model+"__");
								}
			
							} else {
									/* STANDARD MCU */
								mcu_properties = STANDARD_MCU_PROPERTIES.get(model_type);
								if (mcu_properties != null) {
									if (!ee_opts.contains(mcu_properties.ee_opt)) {
										ee_opts.add(mcu_properties.ee_opt);
									}
								}
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
			}
		}
		return answer;
	}
	
	/**
	 * Loads every know mcu
	 */
	protected static void loadMCU_properties() {
		final String MCU_filename__codewarrior = Activator.TEMPLATES_PATH + "s12_id__codewarrior.csv";
		final String MCU_filename__cosmic = Activator.TEMPLATES_PATH + "s12_id__cosmic.csv";
		
		class PropertyMaker {
			final char COMMENT = '#';
			final char SEPARATOR_CHAR = '\t';
			final String SEPARATOR = "[\t ]";
			final HashMap<String, MCU_MODEL> mcuProperties;
			final String fileName;
			boolean load = false;
			
			public PropertyMaker(HashMap<String, MCU_MODEL> map, String name) {
				mcuProperties = map;
				fileName = name;
				
				load();
			}
			
			@SuppressWarnings("unused")
			public void addARow(byte[] row, int start, int end) {
				
				// add a NOT EMPTY row
				if (row.length==0 || row[0]==COMMENT) return; 

				ArrayList<String> values = new ArrayList<String>();
						
// Header of the pic_id file			
//OIL/MOEL		File H		File INC	File GLD(linker)	File LIB(dev)	
				
				int prev=start;
				for (int i=prev; i<end; i++) {
					
					if (row[i]==SEPARATOR_CHAR) {
						// next word
						
						if (i!=prev) {
							String txt = new String(row, prev, i-prev);
							values.add(txt);
						}
						prev = i+1; // the next word starts from i+1
					}
				}
				// the last word
				if (prev!=row.length-1) {
					String txt = new String(row, prev, row.length - prev -1);
					values.add(txt);
				}
				
				// not valid !!!
				if (values.size()!=5) {
					RtdruidLog.showDebug(new RuntimeException("Illegal row inside s12_id\n" + (new String(row))));
					return;
				}
				
				String name   = values.get(0);
				String model  = name.startsWith("S12") ?	name.substring(3) : name;
				String ee_opt = "__" + model + "__";
				String inc_h  = values.get(1);
				String inc_c  = values.get(2);
				String inc_s  = values.get(3);
				String linker = values.get(4);
				
				MCU_MODEL mcu = new MCU_MODEL(
						name, // name
						model, // model
						ee_opt, // ee_opt
						linker, // linker
						inc_h, // dev
						inc_c, // include_c
						inc_s // include_s
				);
				
				mcuProperties.put(name, mcu);
			}
			public void addARow(String row) {
				
				// add a NOT EMPTY row
				if (row.length()==0 || row.charAt(0)==COMMENT) return; 

				String[] values = row.split(SEPARATOR); 
				
				// not valid !!!
				if (values.length!=5) {
					RtdruidLog.showDebug(new RuntimeException("Illegal row inside s12_id\n" + (new String(row))));
					return;
				}
				
				String name   = (String) values[0];
				String model  = name.startsWith("S12") ?	name.substring(3) : name;
				String ee_opt = "__" + model + "__";
				String inc_h  = ".".equals(values[1]) ? "" : (String) values[1];
				String inc_c  = ".".equals(values[2]) ? "" : (String) values[2];
				String inc_s  = ".".equals(values[3]) ? "" : (String) values[3];
				String linker = ".".equals(values[4]) ? "" : (String) values[4];
				
				MCU_MODEL mcu = new MCU_MODEL(
						name, // name
						model, // model
						ee_opt, // ee_opt
						linker, // linker
						inc_h, // include_h
						inc_c, // include_c
						inc_s // include_s
				);
				
				mcuProperties.put(name, mcu);
			}
			
			public void load() {
				if (load) {
					// already loaded
					return;
				}
				load = true;
				
				String tmp="";		
				try {
					InputStream input = SectionWriterHalS12.class.getResourceAsStream(fileName);
					
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
		};
		
		new PropertyMaker(STANDARD_MCU_PROPERTIES_COSMIC, MCU_filename__cosmic).load();
		new PropertyMaker(STANDARD_MCU_PROPERTIES_CODEWARRIOR, MCU_filename__codewarrior).load();
	}
}
