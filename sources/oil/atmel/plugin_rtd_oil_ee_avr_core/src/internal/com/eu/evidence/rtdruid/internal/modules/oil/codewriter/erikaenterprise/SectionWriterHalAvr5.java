/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterHalAvr5.java,v 1.15 2008/01/24 15:50:57 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.eu.evidence.modules.oil.avr.constants.AvrConstants;
import com.eu.evidence.rtdruid.desk.Messages;
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
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStackData;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStacks;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.modules.oil.keywords.IOilXMLLabels;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;

/**
 * This writer build files for a FP Kernel
 * 
 * @author Nicola Serreli
 */
public class SectionWriterHalAvr5 extends SectionWriter implements IEEWriterKeywords, IExtractObjectsExtentions  {
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;

	public final static String FILE_EE_HANDLER_INSTALL_S = "handler_install.S";
	
	/** All data */
	protected final IVarTree vt;

	/**
	 * 
	 */
	public SectionWriterHalAvr5() {
		this(null);
	}
	/**
	 * 
	 */
	public SectionWriterHalAvr5(ErikaEnterpriseWriter parent) {
		super(IWritersKeywords.CPU_AVR5, new String[] {}, //
				new String[] { //
				IWritersKeywords.CPU_NIOSII,//
				IWritersKeywords.CPU_JANUS,//
				IWritersKeywords.CPU_MPC5xx,//
				IWritersKeywords.CPU_NIOSII, //
				IWritersKeywords.CPU_PIC_30 },
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

		return writeEE_AVR5();
	}


	/**
	 * Write configuration's files for AVR 5
	 * 
	 * @return buffers with configuration for AVR 5 
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeEE_AVR5()
			throws OilCodeWriterException {

		final String ERR_CPU_TYPE = "AVR 5";
		final String STACK_BASE = "__SYS_STACK_ADDRESS";
		final IOilObjectList[] oilObjects = parent.getOilObjects();		

		IOilWriterBuffer answer = new OilWriterBuffer();
		final int currentRtosId = 0;

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
		IOilObjectList ool = oilObjects[currentRtosId];
		List<ISimpleGenRes> taskNames = ool.getList(IOilObjectList.TASK);
		String stackType = parent.getStackType(); // MULTI or MONO
//		final ISimpleGenRes sgrCpu = (ISimpleGenRes) oilObjects[currentRtosId].getList(IOilObjectList.OS____CHECK_REQUIRED).get(0);
		final List<String> currentCpuPrefixes = AbstractRtosWriter.getOsProperties(ool, SGRK_OS_CPU_DATA_PREFIX);
		//boolean irq_stack_need = checkKeyword(WritersKeys.IRQ_STACK_NEEDED);
		
		final ICommentWriter commentWriterC = getCommentWriter(ool, FileTypes.C);
		final ICommentWriter commentWriterMf = getCommentWriter(ool, FileTypes.MAKEFILE);

		// ------------- Buffers --------------------
		/* A buffer about stack  */
		StringBuffer sbStack = new StringBuffer();

		// ------------- Compute --------------------

		sbInithal_c.append("#include \"ee.h\"\n\n");

		/***********************************************************************
		 * STACK BASE POINTERS
		 **********************************************************************/
		long stackPointer;
		long stackEnd;
		{
			String[] tmp = parent.getCpuDataValue(ool, "STACK_BOTTOM");
			if (tmp != null && tmp.length == 0)
				throw new OilCodeWriterException(ERR_CPU_TYPE + " : Expected " + "STACK_BOTTOM");

			// check that values is a (Long) number
			try {
				stackPointer = (Long.decode(tmp[0])).longValue();
			} catch (Exception e) {
				throw new OilCodeWriterException(ERR_CPU_TYPE + " : Wrong int"
						+ "STACK_BOTTOM"
						+ ", value = " + tmp[0] + ")");
			}

		}
		stackEnd = stackPointer;

		/***********************************************************************
		 * MULTI STACK
		 **********************************************************************/
		if (DEF__MULTI_STACK__.equals(stackType)) {
			sbStack.append(commentWriterC
					.writerBanner("Stack definition for AVR 5") +
					indent + "#define " + STACK_BASE + " 0x"+ (Long.toHexString(stackPointer)).toUpperCase() + "\n\n");

			ITreeInterface ti = vt.newTreeInterface();


			
			int[] irqSize = null;
			if (parent.checkKeyword(DEF__IRQ_STACK_NEEDED__)) {
				/***************************************************************
				 * IRQ_STACK
				 **************************************************************/
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
										stackEnd -= irqSize[0];
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
			EEStacks elStack = new EEStacks(parent, oilObjects[currentRtosId], irqSize);
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

					ISimpleGenRes sgr = iter.next();
					tList.add(sgr.getName());
					tListN.add(sgr.getString(ISimpleGenResKeywords.TASK_SYS_ID));
				}

				// compute total stack size and add it to memory requirement
				int offset[][] = elStack.taskOffsets(tList
						.toArray(new String[0]));
				stackEnd -= offset[offset.length - 1][0]; // tot sys
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
				/* get offset of each stack. */
				int offset[][] =elStack.taskOffsets(tList
						.toArray(new String[1]));
				/* get the size of each stack. */
				int size[][] = elStack.stackSize(tList
						.toArray(new String[1]));
				/* descrStack contains a description for each stack. */ 
				String[] descrStack = new String[offset.length - 1];
				ArrayList<EEStackData> stackTmp = new ArrayList<EEStackData>();
				sbStack.append(indent
						+ "EE_UREG EE_avr5_thread_tos["+MAX_TASK+"+1] = {\n");

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
						+ "struct EE_TOS EE_avr5_system_tos["
						+ ErikaEnterpriseWriter.addVectorSizeDefine(ool, "EE_avr5_system_tos", offset.length - 1)
						+ "] = {\n");

				pre = "";
				post = "";
				// buffer for "stack use" description (SYS & IRQ)
				StringBuffer descrTotStack = new StringBuffer();

				/*
				 * For each stack prepare the configuration's vectors and
				 * descriptions
				 */
				for (int j = 0; j < offset.length - 1; j++) {
					StringBuffer spazi = new StringBuffer(offset[j][0] + "     ");
					sbStack.append(pre
							+ post
							+ indent
							+ indent
							+ "{(EE_ADDR)(" + STACK_BASE + " "
							+ (offset[j][0] > 0 ? "- "
									+ spazi.substring(0,
											(spazi.length() > 10 ? spazi
													.length() - 5 : 5)) + "-8"
									: "          ") + " )}");

					// set new values for size
					pre = ",";
					post = "\n";

					// prepare the complete description for all stack use
					descrTotStack.append(indent + " 0x"
							+ (Long.toHexString(stackPointer - offset[j][0]
									)).toUpperCase() + "   System stack: "
							+ descrStack[j] + ", Size = " + size[j][0] + "\n");
					
					// USED BY ORTI (NEVER CHECKED)
					stackTmp.add(new EEStackData(j, new long[] {size[j][0]}, new long[] {size[j][0]},
							new String[] {"(unsigned int *)(" + stackPointer + " - 0x" +
									Integer.toHexString(offset[j][0]+size[j][0]).toUpperCase()+ /*DELTA +"*/ " )"}, true));

				}

				// complete the stack's buffer
				sbStack.append(" " + post + indent + "};\n\n" + indent
						+ "EE_UREG EE_avr5_active_tos = 0U; /* dummy */\n\n");

				{ // if required, init also the irq stack
					if (irqSize != null) {
						sbStack
								.append(indent+"/* stack used only by IRQ handlers */\n"
										+ indent+"struct EE_TOS EE_avr5_IRQ_tos = {\n"
										+ indent+indent+"(EE_ADDR)(" + STACK_BASE + " - "
										+ offset[offset.length - 1][0]
										+ " -8 )\n"
										+ indent+"};\n\n");

						// prepare the complete description for all stack use
						descrTotStack.append(indent+" 0x"
								+ (Long.toHexString(stackPointer
										- offset[offset.length - 1][0]))
										.toUpperCase()
								+ "   System stack: IRQ handler, Size = "
								+ irqSize[0] + "\n");

						// REQUIRED By ORTI's STACK
						int eesdID = stackTmp.size();
						stackTmp.add(new EEStackData(eesdID, new long[] {irqSize[0]}, new long[] {irqSize[0]},
								new String[] {"(unsigned int *)(" + stackPointer + " - 0x" +
										Integer.toHexString(offset[offset.length - 1][0]+irqSize[0]).toUpperCase() + /*DELTA+*/" )"}, true));
					}
				}

				// add the description of memory allocation (stack and other objects)
				sbStack.append(indent + "/*\n" + indent
						+ " Stack Address      Symbol/Note\n"
						+ indent + " 0x"+ (Long.toHexString(stackPointer)).toUpperCase()+ "     __SP_INIT\n"
						+ indent + " 0x"+ (Long.toHexString(stackPointer)).toUpperCase()+ "     " + STACK_BASE + "\n"
						+ descrTotStack 
						+ indent + " 0x"+ (Long.toHexString(stackEnd)).toUpperCase()+ "     __SP_END\n"
						+ indent + " */\n");
				
				
				{// ORTI : Store link between task and stack
					int j = 1;
					for (Iterator<ISimpleGenRes> iter = taskNames.iterator(); iter.hasNext(); j++) {
						ISimpleGenRes sgr = iter.next();
						sgr.setObject(SGRK_TASK_STACK, stackTmp.get(pos[j]));
					}
					ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
					sgrCpu.setObject(SGRK_OS_STACK_LIST, stackTmp.toArray(new EEStackData[0]));
				}

			}
		}

		// ------------- Write --------------------
		//  add stack buffers
		sbInithal_c.append(sbStack);

		
		
//		if (false) { // old
//			/*******************************************************************
//			 * 
//			 * Interrupt TABLE
//			 * 
//			 ******************************************************************/
//			StringBuffer sbHandler = answer.get(FILE_EE_HANDLER_INSTALL_S);
//			
//			sbHandler.append(CommonUtils.writerBannerC("Init IRQ Handler Table")
//					+ "#include \"mcu/atmel_atmega128/src/ee_irqstub.S\"\n");
//
//			/* all handler order by priority (start from 1 !!)*/
//			String[][] hndl_values = new String[][] {
///* 1*/	                { "HANDLER_IRQ0",	"external interrupt request 0"},
///* 2*/	                { "HANDLER_IRQ1",	"external interrupt request 1"},
///* 3*/	                { "HANDLER_IRQ2",	"external interrupt request 2"},
///* 4*/	                {"HANDLER_IRQ3",	"external interrupt request 3"},
///* 5*/	                {"HANDLER_IRQ4",	"external interrupt request 4"},
///* 6*/	                {"HANDLER_IRQ5",	"external interrupt request 5"},
///* 7*/	                {"HANDLER_IRQ6",	"external interrupt request 6"},
///* 8*/	                {"HANDLER_IRQ7",	"external interrupt request 7"},
//
///* 9*/	                {"HANDLER_T2_MATCH",	"Timer/Counter 2 Compare Match"},
///*10*/	                {"HANDLER_T2_OVERFLW",	"Timer/Counter 2 Overflow"},
//
///*11*/					{"HANDLER_T1_EVENT",	"Timer/Counter 1 Capture Event"},
///*12*/	                {"HANDLER_T1_MATCH_A",	"Timer/Counter 1 Compare Match A"},
///*13*/	        	    {"HANDLER_T1_MATCH_B",	"Timer/Counter 1 Compare Match B"},
///*14*/  	            {"HANDLER_T1_OVERFLW",	"Timer/Counter 1 Overflow"},
//
///*15*/	                {"HANDLER_T0_MATCH",	"Timer/Counter 0 Compare Match"},
///*16*/      	        {"HANDLER_T0_OVERFLW",	"Timer/Counter 0 Overflow"},
//
///*17*/	                {"HANDLER_SPI", 		"SPI Serial Transfer Complete"},
//
///*18*/	                {"HANDLER_US0_RX",  	"USART0 Rx complete"},
///*19*/	                {"HANDLER_US0_EMPTY",	"USART0 Data Register Empty"},
///*20*/	                {"HANDLER_US0_TX",  	"Usart0 Tx complete"},
//
///*21*/	                {"HANDLER_ADC", 		"ADC Conversion Complete"},
///*22*/	                {"HANDLER_EEPROM",		"EEPROM Ready"},
///*23*/	                {"HANDLER_ANALOG_COMP",	"Analog Comparator"},
//
///*24*/					{"HANDLER_T1_MATCH_C",	"Timer/Counter 1 Compare Match C"},
///*25*/	                {"HANDLER_T3_EVENT",	"Timer/Counter 3 Capture Event"},
///*26*/	                {"HANDLER_T3_MATCH_A",	"Timer/Counter 3 Compare Match A"},
///*27*/	                {"HANDLER_T3_MATCH_B",	"Timer/Counter 3 Compare Match B"},
///*28*/	                {"HANDLER_T3_MATCH_C",	"Timer/Counter 3 Compare Match C"},
///*29*/	                {"HANDLER_T3_OVERFLW",	"Timer/Counter 3 Overflow"},
//
///*30*/	                {"HANDLER_US1_RX",  	"USART1 Rx complete"},
///*31*/	                {"HANDLER_US1_EMPTY",	"USART1 Data Register Empty"},
///*32*/	                {"HANDLER_US1_TX",  	"Usart1 Tx complete"},
//
///*33*/	                {"HANDLER_2WSI",		"Two-wire serial Interface"},
///*34*/	                {"HANDLER_SPM_READY",	"Store program Memory Ready"},
//			};
//
//			/*******************************************************************
//			 * get values
//			 ******************************************************************/
//
//			Properties irq = new Properties();
//			
//			// get all defined handler
//			for (int i=0; i<=hndl_values.length; i++) {
//				String tmpVal[] = CommonUtils.getValue(vt, currentCpuPrefix
//					+ S + hndl_values[i][0]);
//			
//				if (tmpVal != null && tmpVal.length >0) {
//					
//					String nome_1 = tmpVal[0];
//					String nome_2 = "_v"+i+"_" + tmpVal[0];
//					
//					sbHandler.append("//" + hndl_values[i][1] + "\n" +
//							".global __vector_"+i+"\n" +
//							"__vector_"+i+" :\n" +
//							"\t\tEE_ISR2_HANDLER_STUB "+ nome_1 + ", " + nome_2 +"\n" +
//							"reti\n\n");
//				}
//				
//			}
//		} // fine OLD
		
		
		{
			/*******************************************************************
			 * 
			 * Interrupt TABLE
			 * 
			 ******************************************************************/
			StringBuffer sbHandler = answer.get(FILE_EE_HANDLER_INSTALL_S);
			
			sbHandler.append(commentWriterC.writerBanner("Init IRQ Handler Table")
					+ "#include \"mcu/atmel_atmega128/inc/ee_irqstub.S\"\n\n\n");

			/* all handler order by priority (start from 1 !!)*/
			String[][] hndl_values = new String[][] {
/* 1*/	                { "HANDLER_IRQ0",	"external interrupt request 0"},
/* 2*/	                { "HANDLER_IRQ1",	"external interrupt request 1"},
/* 3*/	                { "HANDLER_IRQ2",	"external interrupt request 2"},
/* 4*/	                {"HANDLER_IRQ3",	"external interrupt request 3"},
/* 5*/	                {"HANDLER_IRQ4",	"external interrupt request 4"},
/* 6*/	                {"HANDLER_IRQ5",	"external interrupt request 5"},
/* 7*/	                {"HANDLER_IRQ6",	"external interrupt request 6"},
/* 8*/	                {"HANDLER_IRQ7",	"external interrupt request 7"},

/* 9*/	                {"HANDLER_T2_MATCH",	"Timer/Counter 2 Compare Match"},
/*10*/	                {"HANDLER_T2_OVERFLW",	"Timer/Counter 2 Overflow"},

/*11*/					{"HANDLER_T1_EVENT",	"Timer/Counter 1 Capture Event"},
/*12*/	                {"HANDLER_T1_MATCH_A",	"Timer/Counter 1 Compare Match A"},
/*13*/	        	    {"HANDLER_T1_MATCH_B",	"Timer/Counter 1 Compare Match B"},
/*14*/  	            {"HANDLER_T1_OVERFLW",	"Timer/Counter 1 Overflow"},

/*15*/	                {"HANDLER_T0_MATCH",	"Timer/Counter 0 Compare Match"},
/*16*/      	        {"HANDLER_T0_OVERFLW",	"Timer/Counter 0 Overflow"},

/*17*/	                {"HANDLER_SPI", 		"SPI Serial Transfer Complete"},

/*18*/	                {"HANDLER_US0_RX",  	"USART0 Rx complete"},
/*19*/	                {"HANDLER_US0_EMPTY",	"USART0 Data Register Empty"},
/*20*/	                {"HANDLER_US0_TX",  	"Usart0 Tx complete"},

/*21*/	                {"HANDLER_ADC", 		"ADC Conversion Complete"},
/*22*/	                {"HANDLER_EEPROM",		"EEPROM Ready"},
/*23*/	                {"HANDLER_ANALOG_COMP",	"Analog Comparator"},

/*24*/					{"HANDLER_T1_MATCH_C",	"Timer/Counter 1 Compare Match C"},
/*25*/	                {"HANDLER_T3_EVENT",	"Timer/Counter 3 Capture Event"},
/*26*/	                {"HANDLER_T3_MATCH_A",	"Timer/Counter 3 Compare Match A"},
/*27*/	                {"HANDLER_T3_MATCH_B",	"Timer/Counter 3 Compare Match B"},
/*28*/	                {"HANDLER_T3_MATCH_C",	"Timer/Counter 3 Compare Match C"},
/*29*/	                {"HANDLER_T3_OVERFLW",	"Timer/Counter 3 Overflow"},

/*30*/	                {"HANDLER_US1_RX",  	"USART1 Rx complete"},
/*31*/	                {"HANDLER_US1_EMPTY",	"USART1 Data Register Empty"},
/*32*/	                {"HANDLER_US1_TX",  	"Usart1 Tx complete"},

/*33*/	                {"HANDLER_2WSI",		"Two-wire serial Interface"},
/*34*/	                {"HANDLER_SPM_READY",	"Store program Memory Ready"},
			};

			/*******************************************************************
			 * get values
			 ******************************************************************/

//			Properties irq = new Properties();
			
			ArrayList<String> handlersPaths = new ArrayList<String>();
			List<String> handlersFound =parent.getRtosCommonChildType(ool, "HANDLER", handlersPaths);
			
			// this map is useful to group all functions (KEY = "type_function")
			class HandlerInfo implements Comparable<Object> {
				final String function;
				final int type;
				ArrayList<Integer> entries = new ArrayList<Integer>(); // a list of Integer
				HandlerInfo(String function, int type) {
					this.function = function;
					this.type = type;
				}
				
				/* (non-Javadoc)
				 * @see java.lang.Comparable#compareTo(java.lang.Object)
				 */
				public int compareTo(Object arg0) {
					String oKey = "" + arg0;
					String tKey = toString();

					return tKey.compareTo(oKey);
				}
				
				/* (non-Javadoc)
				 * @see java.lang.Object#equals(java.lang.Object)
				 */
				public boolean equals(Object arg0) {
					return compareTo(arg0) == 0;
				}
				
				/* (non-Javadoc)
				 * @see java.lang.Object#toString()
				 */
				public String toString() {
					// TODO Auto-generated method stub
					return "" + type + "_" + function;
				}
			}
			TreeMap<String, HandlerInfo> handlers = new TreeMap<String, HandlerInfo>();
			
			// get all defined handler
			for (int i=0; i<hndl_values.length; i++) {
				
				int index = handlersFound == null ? -1 : handlersFound.indexOf(hndl_values[i][0]);
				if (index>=0) {

					// get the name of the function and the isr type
					String tp = handlersPaths.get(index) + CommonUtils.PARAMETER_LIST;
					String tmpVal[] = CommonUtils.getValue(vt, tp + "FUNCTION");
					String tmpTyp[] = CommonUtils.getValue(vt, tp + "TYPE");
					
					int hType = 1;
					if (tmpTyp != null && tmpTyp.length >0) {
						try {
							hType = (Integer.decode(tmpTyp[0])).intValue();
						} catch (Exception e) {
							throw new RuntimeException("AVR_5 : Wrong handler type for "+hndl_values[i][0]+" ("
									+ hndl_values[i][1] + "): only 1 and 2 are valid values.");
						}
						if (hType != 1 && hType != 2) {
							throw new RuntimeException("AVR_5 : Wrong handler type for "+hndl_values[i][0]+" ("
									+ hndl_values[i][1] + "): only 1 and 2 are valid values.");
						}
					}
					
					
					if (tmpVal != null && tmpVal.length >0) {
						
						String nome_funct = tmpVal[0];
						
						// search the function
						final String key = ""+hType+"_"+nome_funct;
						HandlerInfo info = handlers.get(key);
						if (info == null) {
							info = new HandlerInfo(nome_funct, hType);
							//info.entries.add(new Integer(index)); see later
							handlers.put(key, info);
						}
						info.entries.add(new Integer(i));
						
						
					} else {
						throw new RuntimeException("AVR_5 : It's required an handler for "+hndl_values[i][0]+" ("
								+ hndl_values[i][1] + ").");
					}

				}
				
				
			}
			
			// write all
			if (handlers.keySet().size() == 0) {
				sbHandler.append(indent+"// No IRQ Handler defined\n\n");
			}
			for (Iterator<String> iter = handlers.keySet().iterator(); iter.hasNext(); ) {
				
				HandlerInfo info = handlers.get(iter.next());

				
				// write all labels
				for (int i=0; i<info.entries.size(); i++) {
					int id = ((Integer) info.entries.get(i)).intValue();
					
					sbHandler.append("//\t\t" + hndl_values[id][1] + "\n" +
							".global __vector_"+(id+1)+"\n" +
							"__vector_"+(id+1)+" :\n");
				}

				// write the macro
				String nome_2 = "__isr"+info.type+"_" + info.function;
				sbHandler.append("\t\tEE_ISR"+info.type+"_HANDLER_STUB "+ info.function+ ", " + nome_2 +"\n" +
						"\t\treti\n\n\n");

			}

		}

		
		{
			/***********************************************************************
	         * 
	         * MAKE FILE
	         *  
	         **********************************************************************/

			    StringBuffer sbMakefile = new StringBuffer(commentWriterMf.writerBanner("AVR 5")
			    		+ "APP_SRCS += " 
						+ answer.getFileName(FILE_EE_HANDLER_INSTALL_S) + " \n\n");
			    

			    
			    {	// PATHs
		        	HashMap<String, ?> options = parent.getOptions();

			    	String avr5_gcc_Path = "C:\\programmi\\AVRGCC\\avrgcc";
		        	if (options.containsKey(AvrConstants.PREF_AVR5_GCC_PATH)) {
						String tmp = (String) options.get(AvrConstants.PREF_AVR5_GCC_PATH);
						if (tmp.length()>0) avr5_gcc_Path = tmp;
					}

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
			    	OsType wrapper = HostOsUtils.common.getTarget();
			    	IPath p = new Path(outputDir);
			    	if (p.isAbsolute()) {
			    		outputDir = wrapper.wrapPath(outputDir);
			    	}

			        sbMakefile.append(
			        		CommonUtils.addMakefileDefinesInclude() +
			                "APPBASE := " + appBase + "\n" +
			                "OUTBASE := " + outputDir + "\n" +
			                		
							"\n" +			                		
			                CommonUtils.compilerMakefileDefines(avr5_gcc_Path, "AVR5_DIR", wrapper) + 
			                "AVR5_MODEL := atmega128\n\n"
			        );
			    }
		        
			    // save in the first OS
			    final ISimpleGenRes sgrCpu = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
	            sgrCpu.setProperty(SGRK__MAKEFILE_EXTENTIONS__, sbMakefile.toString());

		}

		return new IOilWriterBuffer[] { answer };
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

	        // TIMERs
	        ArrayList<String> tmp = new ArrayList<String>();
	        
	        // store all older values (if there are) in the first cpu
	        final ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
	        if (sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_EE_OPTS)) {
	        	String[] old = (String[]) sgrCpu.getObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS);
	        	tmp.addAll(Arrays.asList(old));
	        }
	        
        	final String TIMER_STOP = "STOP"; 
	        String[] timers = new String[] {"TIMER0", "TIMER1", "TIMER2", "TIMER3"};
	        
	        boolean enable_some_timers = false; 
	        final List<String> currentCpuPrefixes = AbstractRtosWriter.getOsProperties(ool, SGRK_OS_CPU_DATA_PREFIX);
	        for (String currentCpuPrefix: currentCpuPrefixes) {
		        for (int i=0; i<timers.length; i++) {
					String tmp1 = CommonUtils
							.getFirstChildEnumType(vt, currentCpuPrefix
									+ timers[i], null);
					if (tmp1 == null) {
						tmp1 = TIMER_STOP;
					}
					
					// enable a timer only if is not stop
					if (!TIMER_STOP.equals(tmp1)) {
						String ee_opt = "__TIMER" + i + "_CLK_"+tmp1+"__";
						tmp.add(ee_opt);
						
						String ee_opt2 = "__TIMER_" + i + "_USED__";
						tmp.add(ee_opt2);
						
						enable_some_timers = true;
					}
				}
	        }

			// enable a timers only if at least one timer is not stop
	        if (enable_some_timers) {
				String ee_opt3 = "__TIMER_USED__";
				tmp.add(ee_opt3);
	        }
	        
	        
			// Board
			checkBoard(tmp);

			sgrCpu.setObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS, tmp.toArray(new String[tmp.size()]));
		}

	}

	
	/*
	 * Parse and write the BOARD Section
	 */
	private void checkBoard(ArrayList<String> ee_opts) {
		class AVR_BOARD_MODEL {
//			public final String name;
			public final String def;
			AVR_BOARD_MODEL(String name, String ee_opt) {
//				this.name = name;
				this.def = ee_opt;
			}
		}
		final HashMap<String, AVR_BOARD_MODEL> STANDARD_MCU_PROPERTIES = new HashMap<String, AVR_BOARD_MODEL>();
		/* Add standard MCU and theris properties */ 
		STANDARD_MCU_PROPERTIES.put("NO_BOARD", new AVR_BOARD_MODEL(
				"NO_BOARD", // name
				null
		));

		STANDARD_MCU_PROPERTIES.put("ATMEGA_STK500", new AVR_BOARD_MODEL(
				"ATMEGA128_STK50X", // name
				"__ATMEGA_STK50X__ "
		));
		STANDARD_MCU_PROPERTIES.put("XBOW_MIB5X0", new AVR_BOARD_MODEL(
				"CROSSBOW_MIB5X0", // name
				"__XBOW_MIB5X0__ "
		));
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		final int currentRtosId = 0;
		
		/* COMMON VARIABLES */
		{
			/***********************************************************************
			 * get values and store as EE_OPT
			 **********************************************************************/

			// prepare the path :
			// ... the prefix ...
			ArrayList<String> childPaths = new ArrayList<String>();
			List<String> childFound = parent.getRtosCommonChildType(oilObjects[currentRtosId], "BOARD_DATA", childPaths);

			String board_type = null;
			for (int index = 0; index<childFound.size(); index++) {
				String type_found = childFound.get(index); 
				if (board_type == null) {
					board_type = type_found;
				} else {
					if (!(board_type.equalsIgnoreCase(type_found))) {
						Messages.sendWarningNl("Found more than one Board section for the same cpu. (" + board_type + " and " + type_found + ")",
								null, "ajidasoidjasdiojasdi", null);
					}
				}
				
				
				
				/* STANDARD MCU */
				AVR_BOARD_MODEL board_properties = STANDARD_MCU_PROPERTIES.get(board_type);
				if (board_properties != null) {
	
					if (board_properties.def!= null && !ee_opts.contains(board_properties.def)) {
						ee_opts.add(board_properties.def);
					}
	
//					String currentMcuPrefix = childPaths.get(index) + PARAMETER_LIST;
//					for (int i=0; i<board_properties.properties.length; i++) {
//						String tmp = board_properties.properties[i];
//						
//						String value_type = CommonUtils.getFirstChildEnumType(vt, currentMcuPrefix+tmp, null);
//						
//						if ("TRUE".equals(value_type) && !ee_opts.contains(board_properties.defines[i])) {
//							ee_opts.add(board_properties.defines[i]);
//						}
//					}
				} else {
					String tmp = "";
				
					for (Iterator<String> keys = STANDARD_MCU_PROPERTIES.keySet().iterator(); keys.hasNext(); ) {
						tmp += keys.next() + (keys.hasNext() ? ", " : "");
					}
					
					Messages.sendWarningNl("No board is specified in BOARD_DATA section. Valid values are " +tmp + ".",
							null, "ajidasoidjasdiojasdi", null);
				}
				
				
			}
			

		}
	}

}
