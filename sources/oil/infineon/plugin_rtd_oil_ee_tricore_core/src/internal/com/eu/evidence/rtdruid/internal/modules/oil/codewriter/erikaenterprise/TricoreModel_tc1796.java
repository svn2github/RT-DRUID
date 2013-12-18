/**
 * 26/set/2012
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.eu.evidence.modules.oil.tricore.constants.TricoreConstants;
import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.ISimpleGenResKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuUtility;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStacks;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVariable;

/**
 *
 * @author Nicola Serreli
 * @since 2.0
 *
 */
public class TricoreModel_tc1796 extends TricoreAbstractModel implements IEEWriterKeywords {
	
public static class TricoreModelProvider_tc1796 implements ITricoreModelProvider {
		/* (non-Javadoc)
		 * @see com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.TricoreAbstractModel.ITricoreModelProvider#newTricoreModel()
		 */
		@Override
		public TricoreAbstractModel newTricoreModel() {
			return new TricoreModel_tc1796();
		}
	}
	
	protected final String ERR_CPU_TYPE = "TriCore1";

	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.TricoreAbstractModel#getEEopts()
	 */
	@Override
	public String[] getEEopts(int currentRtosId, IOilObjectList ool) {
		ArrayList<String> tmp = new ArrayList<String>();
		
		if (currentRtosId == -1) {
			tmp.add(SectionWriterHalTricore.EEOPT_HAL_TRICORE__OLD);
			tmp.add("__TC1796__");
			tmp.add("__TC13__");
		} else {
			{ // compiler
				switch (currentCompiler) {
					case DEFAULT:
					case GNU:
						tmp.add(SectionWriterHalTricore.EEOPT_TRICORE_GNU);
						break;
					default:
						Messages.sendWarningNl("Unsupported compiler");
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
	//						throw new OilCodeWriterException("Unsupported isr category (" + category + ") for isr " + currIsr.getName());
						}
					}
					
					
					if (enable_int)
						tmp.add("__INT__");
					if (enable_trap)
						tmp.add("__TRAP__");
				}
			}
		}
		return (String[]) tmp.toArray(new String[tmp.size()]);
    }
	
	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.TricoreAbstractModel#updateObjects(com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter, int)
	 */
	@Override
	public void updateObjects(ErikaEnterpriseWriter parent, int currentRtosId) throws OilCodeWriterException {
		super.updateObjects(parent, currentRtosId);
		final IOilObjectList ool = parent.getOilObjects()[currentRtosId];

		
		/***********************************************************************
		 * 
		 * Get ISR LEVEL and HANDLER
		 *  
		 **********************************************************************/
		{
			List<ISimpleGenRes> isrList = ool.getList(IOilObjectList.ISR);
			for (Iterator<ISimpleGenRes> iter = isrList.iterator(); iter.hasNext();) {

				ISimpleGenRes currIsr = (ISimpleGenRes) iter.next();
				if (!currIsr.containsProperty(TricoreConstants.SGRK__ISR_LEVEL__)) {
					throw new OilCodeWriterException("Required a LEVEL for the isr "+currIsr.getName()+".");
				}
				if (!currIsr.containsProperty(TricoreConstants.SGRK__ISR_HANDLER__)) {
					throw new OilCodeWriterException("The HANDLER for the isr "+currIsr.getName()+" is missing or incorrect.");
				}
			}
			if (!isrList.isEmpty()) {
				ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
				CpuUtility.addSources(sgrCpu, TricoreConstants.ISR_HANDLER_FILE);
			}

		}
	}
	
	@Override
	public void write(final int currentRtosId, final IOilObjectList ool, final IOilWriterBuffer buffers) throws OilCodeWriterException {
		if (DEF__MULTI_STACK__.equals(parent.getStackType())) {
			writeMultistack(ool, buffers);
		}
		writeIsrFile(ool, buffers);
	}

	/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ITricoreModel#writeMultistack()
	 */
	protected void writeMultistack(final IOilObjectList ool, final IOilWriterBuffer answer) {
		// ------------- Buffers --------------------
		StringBuffer sbInithal_c = answer.get(FILE_EE_CFG_C);
		
		/* A buffer about stack  */
		final StringBuffer sbStack = new StringBuffer();

		/* A buffer about declarations of stacks  */
		final StringBuffer sbStackDecl = new StringBuffer();
		final StringBuffer sbStackDeclSize = new StringBuffer();

		// ------------- Buffers --------------------
		
		final String indent = IWritersKeywords.INDENT;
		final int STACK_UNIT = ErikaEnterpriseWriter.getStackUnit(ool);
		final ICommentWriter commentWriterC = SectionWriter.getCommentWriter(ool, FileTypes.C);
		List<ISimpleGenRes> taskNames = ool.getList(IOilObjectList.TASK);


		boolean binaryDistr = parent.checkKeyword(IEEWriterKeywords.DEF__EE_USE_BINARY_DISTRIBUTION__);

		/*
		 * Define a string for each MAX_OBJECT_NUMBER (OBJECT=task, RESOURCE, ...).
		 * Binary distribution uses the suffix RTD_. 
		 */
		final String MAX_TASK = (binaryDistr ? "RTD_" : "EE_") + "MAX_TASK";

		String pre = "";
		String post = "";


		sbInithal_c.append("\n#include \"ee.h\"\n");
		sbInithal_c.append(commentWriterC
				.writerBanner("Stack definition for Tricore1"));
		
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
//			int offset[][] = elStack.taskOffsets((String[]) tList
//					.toArray(new String[0]));
//			stackEnd += offset[offset.length - 1][0]; // tot sys
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
					+ "struct EE_TOS EE_tcl_system_tos["+ErikaEnterpriseWriter.addVectorSizeDefine(ool, "EE_tcl_system_tos", size.length)
					 + "] = {\n");

			pre = "";
			post = "";
			
//			 DECLARE STACK SIZE && STACK (ARRAY)
			for (int j = 1; j < size.length; j++) {
			    long value = size[j][0];
			    value  = (value + (value%STACK_UNIT)) / STACK_UNIT; // arrotondo a 2
				sbStackDecl.append(indent + "EE_STACK EE_tcl_stack_"+j+"[STACK_"+j+"_SIZE];\t/* "+descrStack[j]+" */\n");
				sbStackDeclSize.append(indent + "#define STACK_"+j+"_SIZE "+value+" // size = "+size[j][0]+" bytes \n");
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
				    value  = (value + (value%STACK_UNIT)) / STACK_UNIT; // arrotondo a 2
					sbStackDecl.append(indent + "EE_STACK EE_tcl_stack_"+j+"[STACK_"+j+"_SIZE];\t/* irq stack */\n");
					sbStackDeclSize.append(indent + "#define STACK_"+j+"_SIZE "+value+" // size = "+irqSize[0]+" bytes \n");

					sbStack
							.append(indent+"/* stack used only by IRQ handlers */\n"
									+ indent+"struct EE_TOS EE_tcl_IRQ_tos = {\n"
									+ indent+indent+"(EE_ADDR)(&EE_tcl_stack_"+j+"[STACK_" + j + "_SIZE - 3])\n"
									+ indent+"};\n\n");
				}
			}
			
		}

		// ------------- Write --------------------
		//  add stack buffers
		sbInithal_c.append(sbStackDeclSize+"\n"+
		        sbStackDecl + "\n" +
		        sbStack);

	}
	
	
	
	protected void writeIsrFile(final IOilObjectList ool, IOilWriterBuffer buffers) throws OilCodeWriterException {
		final String indent1 = IWritersKeywords.INDENT;

		if 	(ool.getList(IOilObjectList.ISR).size() > 0) {
			StringBuffer isrFile_s = buffers.get(TricoreConstants.ISR_HANDLER_FILE);
			boolean enable_int = false;
			boolean enable_trap = false;
			
			/***************************************************************
			 * ISR defines
			 **************************************************************/
			StringBuffer eecfg_h = buffers.get(FILE_EE_CFG_H);
			eecfg_h.append(indent1 + "#define EE_MAX_ISR 32");

			/***************************************************************
			 * ISR table
			 **************************************************************/
			
			
			StringBuffer isrTable = new StringBuffer(
					"BEGIN_VECTOR_TABLE\n");

			StringBuffer trapTable = new StringBuffer(
					"BEGIN_TRAP_TABLE\n");
			
			// fill data for each task
//			String pre = "";
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


}
