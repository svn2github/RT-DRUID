/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterHalPic32.java,v 1.17 2008/02/05 10:15:18 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.eu.evidence.modules.oil.dspic.Activator;
import com.eu.evidence.modules.oil.dspic.constants.PicConstants;
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
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStacks;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilObjectType;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;

/**
 * This writer build files for a DS PIC CPU - Board
 * 
 * @author Nicola Serreli
 */
public class SectionWriterHalPic32 extends SectionWriter 
	implements IEEWriterKeywords,
			IExtractObjectsExtentions,
			IExtractKeywordsExtentions {

	final public String KEY_HAL_MICROCHIP_PIC32 = "__MICROCHIP_PIC32__";
	final public String _EE_OPT_HAL_MICROCHIP_PIC32 = "__MICROCHIP_PIC32__";
	
	
	final public static String PIC_MCU = "PIC32";
	final protected String CUSTOM_MCU = "CUSTOM";
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;
	
	/** All data */
	protected final IVarTree vt;

	final protected static HashMap<String, Mcu_Model> STANDARD_MCU_PROPERTIES = new HashMap<String, Mcu_Model>();

	static {
		loadMCU_properties();
	}

	
	/**
	 * 
	 */
	public SectionWriterHalPic32() {
		this(null);
	}
	
	/**
	 * 
	 */
	public SectionWriterHalPic32(ErikaEnterpriseWriter parent) {
		super(IWritersKeywords.CPU_PIC_32,
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

		return writeEE_PIC32_CPU();
	}
	
	/**
	 * This method add new keywords enabled by this writer.
	 */
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix) {
		
		// UPDRTD controllare !!
		if (!keywords.contains(KEY_HAL_MICROCHIP_PIC32)) {
			keywords.add(KEY_HAL_MICROCHIP_PIC32);
		}
		
	}

	/**
	 * This method makes some changes to computed Oil Object
	 */
	public void updateObjects() {

		final IOilObjectList[] oilObjects = parent.getOilObjects();		
		
		final int currentRtosId = 0;
		final IOilObjectList ool = oilObjects[currentRtosId];
		/***********************************************************************
		 * 
		 * EE OPTS
		 *  
		 **********************************************************************/
		{
	        ArrayList<String> tmp = new ArrayList<String>();
	        
	        // store all older values in the first cpu (if there are)
	        ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
	        if (sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_EE_OPTS)) {
	        	String[] old = (String[]) sgrCpu.getObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS);
	        	tmp.addAll(Arrays.asList(old));
	        }
	
	        tmp.add("__PIC32__");
	        tmp.add(_EE_OPT_HAL_MICROCHIP_PIC32);
	        
	        {
	        	boolean found = false;
	        	for (String s: parent.getCpuDataEnum(ool, "ICD2")) {
	        		found |= "TRUE".equalsIgnoreCase(s);
	        	}
	        	
	        	if (found) {
	        		sgrCpu.setProperty(PicConstants.SGRK__PIC32_ICD2__, "true");
	        		tmp.add("__PIC32_ICD2__");
	        	}
	        }

			// mcu
			checkMcu(tmp);
			// Board
			(new SectionWriterHalPicBoards(parent, PIC_MCU)).checkBoard(tmp);
			
			sgrCpu.setObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS, tmp.toArray(new String[tmp.size()]));
		}

	}
	
	/**
	 * Write configuration's files for PIC 32
	 * 
	 * @return buffers with configuration for PIC 32
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeEE_PIC32_CPU()
			throws OilCodeWriterException {

		final String ERR_CPU_TYPE = "pic 32";
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
					.writerBanner("Stack definition for PIC 32"));
			
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
						+ "EE_UREG EE_pic32_thread_tos["+MAX_TASK+"+1] = {\n");

				
				
					
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
						+ "struct EE_TOS EE_pic32_system_tos["+ErikaEnterpriseWriter.addVectorSizeDefine(ool, "EE_pic32_system_tos", size.length)
						+ "] = {\n");

				pre = "";
				post = "";
				
//				 DECLARE STACK SIZE && STACK (ARRAY)
				for (int j = 1; j < size.length; j++) {
				    long value = size[j][0];
				    value  = (value + (value%STACK_UNIT)) / STACK_UNIT; // arrottondo a 2
					sbStackDecl.append(indent1 + "int EE_pic32_stack_"+j+"[STACK_"+j+"_SIZE];\t/* "+descrStack[j]+" */\n");
					sbStackDeclSize.append(indent1 + "#define STACK_"+j+"_SIZE "+value+" // size = "+size[j][0]+" bytes \n");
				}
				
				/*
				 * For each stack prepare the configuration's vectors and
				 * descriptions
				 */
				for (int j = 0; j < size.length; j++) {
				    
			        String value = j == 0 ? "{0}" : "{(EE_ADDR)(&EE_pic32_stack_"+j+"[7])}";

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
						+ "EE_UREG EE_pic32_active_tos = 0U; /* dummy */\n\n");

				{ // if required, init also the irq stack
					if (irqSize != null) {
					    int j = size.length;
					    long value = irqSize[0];
					    value  = (value + (value%STACK_UNIT)) / STACK_UNIT; // arrottondo a 2
						sbStackDecl.append(indent1 + "int EE_pic32_stack_"+j+"[STACK_"+j+"_SIZE];\t/* irq stack */\n");
						sbStackDeclSize.append(indent1 + "#define STACK_"+j+"_SIZE "+value+" // size = "+irqSize[0]+" bytes \n");

						sbStack
								.append(indent+"/* stack used only by IRQ handlers */\n"
										+ indent+"struct EE_TOS EE_pic32_IRQ_tos = {\n"
										+ indent+indent+"(EE_ADDR)(&EE_pic32_stack_"+j+"[7])\n"
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

		    StringBuffer sbMakefile = new StringBuffer(commentWriterMf.writerBanner("PIC 32"));
		    
		    {	// PATHs
	        	HashMap<String, ?> options = parent.getOptions();

		        String outputDir = "Debug";
		        String appBase = "..";
		        // Get Default values 
		        String gcc = PicConstants.DEFAULT_PIC32_CONF_GCC;
		        String asm = null; //wrapper.wrapPath(PicConstants.DEFAULT_PIC32_CONF_ASM);
		        
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
		    	
		    	
		    	if (options.containsKey(PicConstants.PREF_PIC32_GCC_PATH)) {
					String tmp = (String) options.get(PicConstants.PREF_PIC32_GCC_PATH);
					if (tmp.length()>0) gcc = tmp;
				}
		    	if (options.containsKey(PicConstants.PREF_PIC32_ASM_PATH)) {
					String tmp = (String) options.get(PicConstants.PREF_PIC32_ASM_PATH);
					if (tmp.length()>0) asm = tmp;
				}
		    	if (asm == null) {
		    		asm = gcc;
		    	}
		    	
		        sbMakefile.append(
		        		CommonUtils.addMakefileDefinesInclude() +
		                "APPBASE := " + appBase + "\n" +
		                "OUTBASE := " + outputDir + "\n\n" + 
				        CommonUtils.compilerMakefileDefines(asm, "PIC32_ASMDIR", wrapper) +
				        CommonUtils.compilerMakefileDefines(gcc, "PIC32_GCCDIR", wrapper) 
		        );
		    }

		    ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
            sgrCpu.setProperty(SGRK__MAKEFILE_EXTENTIONS__, sbMakefile.toString());

		}
		
		// MCU
		mcuWrite(answer);

		return new IOilWriterBuffer[] { answer };
	}

	
	/*
	 * Parse and write the MCU Section
	 */
	private void mcuWrite(IOilWriterBuffer buffers) {
		final String PIC_MCU = "PIC32";
		final String CUSTOM_MCU = "CUSTOM";

		final IOilObjectList[] oilObjects = parent.getOilObjects();
		final int currentRtosId = 0;
		final IOilObjectList ool = oilObjects[currentRtosId];
		
		/* COMMON VARIABLES */
		final ICommentWriter commentWriterMf = getCommentWriter(ool, FileTypes.MAKEFILE);
		String mcu_model = null;	// != null only if found a valid mcu

		Mcu_Model mcu_properties = null;
		for (ISimpleGenRes os: ool.getList(IOilObjectList.OS)){
				if (mcu_model == null) {
				/***********************************************************************
				 * get values
				 **********************************************************************/
	
				// prepare the path :
				// ... the prefix ...
				String currentMcuPrefix = os.getPath() + S
						+ (new OilPath(OilObjectType.OS, null)).getPath()
						+ "MCU_DATA";
				
				// ... get the node identifier
				String[] child = new String[1];
				String mcu_type = CommonUtils.getFirstChildEnumType(vt, currentMcuPrefix, child);
				
				if (child.length >0 && PIC_MCU.equals(mcu_type)) {
					// ... and compete it 
					currentMcuPrefix += VARIANT_ELIST + child[0] + PARAMETER_LIST + "MODEL";
	
					String model_type = CommonUtils.getFirstChildEnumType(vt, currentMcuPrefix, child);
					
					/* CUSTOM */
					if (CUSTOM_MCU.equals(model_type)) {
	//					 read also LINKERSCRIPT, DEV_LIB, INCLUDE_C, INCLUDE_S
						currentMcuPrefix += VARIANT_ELIST + child[0] + PARAMETER_LIST;
						String[] model = CommonUtils.getValue(vt, currentMcuPrefix+"MODEL");
						String[] linker = CommonUtils.getValue(vt, currentMcuPrefix+"LINKERSCRIPT");
						String[] dev    = CommonUtils.getValue(vt, currentMcuPrefix+"DEV_LIB");
						String[] inc_c  = CommonUtils.getValue(vt, currentMcuPrefix+"INCLUDE_C");
						String[] inc_s  = CommonUtils.getValue(vt, currentMcuPrefix+"INCLUDE_S");
						
						mcu_properties = new Mcu_Model(
								CUSTOM_MCU,
								clean(model),
								"__"+clean(model)+"__",
								clean(linker),
								clean(dev),
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
			answerBuffer.append(commentWriterMf.writerBanner("Init MCU for PIC32 ("+mcu_model+")"));
	
	
			// complete the table
				answerBuffer.append("PIC32_MODEL           := " +mcu_properties.model + "\n"); 
//			if (mcu_properties.linkerScript != null)
//				answerBuffer.append("PIC32_LINKERSCRIPT    := " +mcu_properties.linkerScript + "\n"); 
			if (mcu_properties.dev_lib != null)
				answerBuffer.append("PIC32_DEV_LIB         := " +mcu_properties.dev_lib + "\n");
			if (mcu_properties.include_c != null)
				answerBuffer.append("PIC32_INCLUDE_C       := " +mcu_properties.include_c + "\n");
			if (mcu_properties.include_s != null && !"_".equals(mcu_properties.include_s))
				answerBuffer.append("PIC32_INCLUDE_S       := " +mcu_properties.include_s + "\n");
	
	        os.setProperty(SGRK__MAKEFILE_EXTENTIONS__, answerBuffer.toString());
		}
	}

	
	/*
	 * Parse and write the MCU Section
	 */
	private void checkMcu(ArrayList<String> ee_opts) {

		final IOilObjectList[] oilObjects = parent.getOilObjects();
		final int currentRtosId = 0;
		
		/* COMMON VARIABLES */
		//String mcu_model = null;	// != null only if found a valid mcu
		Mcu_Model mcu_properties = null;

		for (ISimpleGenRes os: oilObjects[currentRtosId].getList(IOilObjectList.OS)){
			if (mcu_properties == null) {
				/***********************************************************************
				 * get values
				 **********************************************************************/
	
				// prepare the path :
				// ... the prefix ...
				String currentMcuPrefix = os.getPath() + S
						+ (new OilPath(OilObjectType.OS, null)).getPath()
						+ "MCU_DATA";
				
				// ... get the node identifier
				String[] child = new String[1];
				String mcu_type = CommonUtils.getFirstChildEnumType(vt, currentMcuPrefix, child);
				
				if (child.length >0 && PIC_MCU.equals(mcu_type)) {
					// ... and compete it 
					currentMcuPrefix += VARIANT_ELIST + child[0] + PARAMETER_LIST + "MODEL";
	
					String model_type = CommonUtils.getFirstChildEnumType(vt, currentMcuPrefix, child);
					
					/* CUSTOM */
					if (CUSTOM_MCU.equals(model_type)) {
						
						// read only MODEL
						currentMcuPrefix += VARIANT_ELIST + child[0] + PARAMETER_LIST;
						String model = clean(CommonUtils.getValue(vt, currentMcuPrefix+"MODEL"));
						if (model != null && !ee_opts.contains("__"+model+"__")) {
							ee_opts.add("__"+model+"__");
						}
	
					} else {
							/* STANDARD MCU */
						/* STANDARD MCU */
						mcu_properties = STANDARD_MCU_PROPERTIES.get(model_type);
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
		final String MCU_filename = Activator.TEMPLATES_PATH + "pic32_id.csv";
		
		class PropertyMaker {
			final char COMMENT = '#';
			final char SEPARATOR_CHAR = '\t';
			final String SEPARATOR = "[\t ]";
			
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
					RtdruidLog.showDebug(new RuntimeException("Illegal row inside pic_id\n" + (new String(row))));
					return;
				}
				
				String name   = values.get(0);
				String model  = name.startsWith("PIC") ?	name.substring(3) : name;
				String ee_opt = "__" + model + "__";
				String linker = values.get(3);
				String dev    = values.get(4);
				String inc_c  = values.get(1);
				String inc_s  = values.get(2);
				
				Mcu_Model mcu = new Mcu_Model(
						name, // name
						model, // model
						ee_opt, // ee_opt
						linker, // linker
						dev, // dev
						inc_c, // include_c
						inc_s // include_s
				);
				
				STANDARD_MCU_PROPERTIES.put(name, mcu);
			}
			public void addARow(String row) {
				
				// add a NOT EMPTY row
				if (row.length()==0 || row.charAt(0)==COMMENT) return; 

				String[] values = row.split(SEPARATOR); 
				
				// not valid !!!
				if (values.length!=5) {
					RtdruidLog.showDebug(new RuntimeException("Illegal row inside pic_id\n" + (new String(row))));
					return;
				}
				
				String name   = (String) values[0];
				String model  = name.startsWith("PIC") ?	name.substring(3) : name;
				String ee_opt = "__" + model + "__";
				String linker = (String) values[3];
				String dev    = (String) values[4];
				String inc_c  = (String) values[1];
				String inc_s  = (String) values[2];
				
				Mcu_Model mcu = new Mcu_Model(
						name, // name
						model, // model
						ee_opt, // ee_opt
						linker, // linker
						dev, // dev
						inc_c, // include_c
						inc_s // include_s
				);
				
				STANDARD_MCU_PROPERTIES.put(name, mcu);
			}
		};
		
		PropertyMaker pmaker = new PropertyMaker();
		String tmp="";		
		try {
			InputStream input = SectionWriterHalPic32.class.getResourceAsStream(MCU_filename);
			
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
			pmaker.addARow(t);
		}
	}

}
