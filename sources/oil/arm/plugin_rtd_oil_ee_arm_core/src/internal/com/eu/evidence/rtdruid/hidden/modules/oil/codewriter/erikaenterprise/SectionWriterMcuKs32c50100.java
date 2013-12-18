/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterMcuKs32c50100.java,v 1.2 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.hidden.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.eu.evidence.modules.oil.arm7.constants.Arm7Constants;
import com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter;
import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
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
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilObjectType;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilPath;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * This writer build files for a FP Kernel
 * 
 * @author Nicola Serreli
 */
public class SectionWriterMcuKs32c50100 extends SectionWriter implements IEEWriterKeywords,
	IExtractKeywordsExtentions, IGetEEOPTExtentions {

	/** Contains all properties of a Samsung KS32C50100 (as stored inside the oil) */
	private final static String[][] SAMSUNG_KS32C501_IRQ_KEYS = {
	//
			{"IRQ_EXT0", "/* Ext 0 */ "},
			{"IRQ_EXT1", "/* Ext 1 */"},
			{"IRQ_EXT2", "/* Ext 2 */"},
			{"IRQ_EXT3", "/* Ext 3 */"},
			{"IRQ_UART0TX", "/* UART0 Tx */"},
			{"IRQ_UART0RX", "/* UART0 Rx & error */"},
			{"IRQ_UART1TX", "/* UART1 Tx */"},
			{"IRQ_UART1RX", "/* UART1 Rx & error */"},
			{"IRQ_GDMA0", "/* GDMA ch. 0 */"},
			{"IRQ_GDMA1", "/* GDMA ch. 1 */"},
			{"IRQ_TIMER0", "/* Timer 0 */"},
			{"IRQ_TIMER1", "/* Timer 1 */"},
			{"IRQ_HDLCATX", "/* HDLC A Tx */"},
			{"IRQ_HDLCARX", "/* HDLC A Rx */"},
			{"IRQ_HDLCBTX", "/* HDLC B Tx */"},
			{"IRQ_HDLCBRX", "/* HDLC B Rx */"},
			{"IRQ_ETHBDMATX", "/* Ethernet BDMA Tx */"},
			{"IRQ_ETHBDMARX", "/* Ethernet BDMA Rx */"},
			{"IRQ_ETHMACTX", "/* Ethernet MAC Tx */"},
			{"IRQ_ETHMACRX", "/* Ethernet MAC Rx */"},
			{"IRQ_I2C", "/* I2C-bus */"},
			{"IRQ_NO_PENDING", "/* No Pending Interrupt */"},
	};

	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;
	
	/** All data */
	protected final IVarTree vt;
	
	
	/**
	 * 
	 */
	public SectionWriterMcuKs32c50100() {
		this(null);
	}
	/**
	 * 
	 */
	public SectionWriterMcuKs32c50100(ErikaEnterpriseWriter parent) {
		super(Arm7Constants.DEF__SAMSUNG_KS32C50100__,
				new String[] {
						IWritersKeywords.CPU_ARM7
				}, //
				new String[] {},
				SWCategoryManager.defaultInstance.newCategory(SWCategoryManager.TYPE_BOARD));
		
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

		return writeSAMSUNG_KS32C501_MCU();
	}

	/**
	 * Write data for MCU SAMSUNG_KS32C501 (only inside the first Oil Writer
	 * Buffer)
	 * 
	 * @return buffers with configuration for MPC5xx without memory protection
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeSAMSUNG_KS32C501_MCU()
			throws OilCodeWriterException {

		
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		final int currentRtosId = 0;
		final IOilObjectList ool = oilObjects[currentRtosId]; 
		
		/* COMMON VARIABLES */
		final ICommentWriter commentWriterC = getCommentWriter(ool, FileTypes.C);
		Properties irq = new Properties();

		for (ISimpleGenRes os: ool.getList(IOilObjectList.OS)) {
			/***********************************************************************
			 * get values
			 **********************************************************************/

			// check if there is something inside the Tree about this MCU
			if (!os.containsProperty(Arm7Constants.DEF__SAMSUNG_KS32C50100__)) {
	
				// prepare the path :
				// ... the prefix ...
				String currentMcuPrefix = os.getPath() + S 
						+ (new OilPath(OilObjectType.OS, null)).getPath()
						+ "MCU_DATA";
				
				// ... get the node identifier
				String[] child = new String[1];
				//String mcu_type = 
				CommonUtils.getFirstChildEnumType(vt, currentMcuPrefix, child);
				// assert("SAMSUNG_KS32C50100".equals(mcu_type))

				// ... and compete it 
				currentMcuPrefix += VARIANT_ELIST + child[0] + PARAMETER_LIST;

				// look for all properties
				for (int i = 0; i < SAMSUNG_KS32C501_IRQ_KEYS.length; i++) {
					String[] tmp = CommonUtils.getValue(vt, currentMcuPrefix
							+ SAMSUNG_KS32C501_IRQ_KEYS[i][0]);
					if (tmp != null && tmp.length != 0) {
						irq
								.setProperty(SAMSUNG_KS32C501_IRQ_KEYS[i][0],
										tmp[0]);
					}
				}

				// store the property inside the OS object
				os.setObject(Arm7Constants.DEF__SAMSUNG_KS32C50100__, irq);
			}

		}
		
		
		/***********************************************************************
		 * prepare buffers
		 **********************************************************************/
		
		final String indent1 = IWritersKeywords.INDENT;
		final String indent2 = indent1 + indent1;
		final String FOR_EVER_LOOP_FUNCTION_NAME = "EE_RTDruid_forever_loop";

		IOilWriterBuffer answer = new OilWriterBuffer();

		// The answer (StringBuffer)
		StringBuffer answerBuffer = answer.get(FILE_EE_CFG_C);
		answerBuffer.append(commentWriterC.writerBanner("Init Samsung KS32C501 (MCU)"));

		// A buffer for functions (handler)
		StringBuffer functionBuffer = new StringBuffer();
		
		// A buffer for the vector
		StringBuffer buffer = new StringBuffer();
		buffer.append(indent1 + "const EE_ADDR EE_IC_EXTIRQ_vector["+ErikaEnterpriseWriter.addVectorSizeDefine(ool, "EE_IC_EXTIRQ_vector", 22)+"] = {\n");
		
		/*
		 * requireForEverLoop checks if all handler are defined by user.
		 * If not, means that the forEverLoop is required and then it's added
		 */
		boolean requireForEverLoop = false;

		// prepare the functionBuffer and vectorBuffer
		String descr = "";
		for (int i = 0; i < SAMSUNG_KS32C501_IRQ_KEYS.length; i++) {
			// tmp contains the function's name (the current handler of
			// current interrupt)
			String tmp;
			if (irq.containsKey(SAMSUNG_KS32C501_IRQ_KEYS[i][0])) {
				tmp = irq.getProperty(SAMSUNG_KS32C501_IRQ_KEYS[i][0]);
				// add the declared handler to declaration's buffer
				functionBuffer.append(indent1+"void "+tmp+"(void);\n");
			} else {
				tmp = FOR_EVER_LOOP_FUNCTION_NAME;
				// for ever loop is required
				requireForEverLoop = true;
			}

			// update irq table
			buffer.append(descr + indent2 + "(EE_ADDR)" + tmp);
			descr = ",\t" + SAMSUNG_KS32C501_IRQ_KEYS[i][1] + "\n";
		}

		// complete the irq table
		buffer
				.append("\t"
						+ SAMSUNG_KS32C501_IRQ_KEYS[SAMSUNG_KS32C501_IRQ_KEYS.length-1][1]
						+ "\n" + indent1 + "};\n");

		/***********************************************************************
		 * write buffers
		 **********************************************************************/
		// write all function
		if (requireForEverLoop) {
			answerBuffer.append(indent1 + "void "+FOR_EVER_LOOP_FUNCTION_NAME+"(void)\n" + indent1 + "{\n"
				+ indent2 + "  for (;;);\n" + indent1 + "}\n\n");
		}
		if (functionBuffer.length() != 0) {
			answerBuffer.append(functionBuffer+"\n");
		}
		// write the irq table
		answerBuffer.append(buffer);

		/***********************************************************************
		 *  IRQ Mask
		 **********************************************************************/
		// write all irq mask (always the same, at this moment)
		answerBuffer.append(indent1+"#if defined(__IRQ_PRIORITY_MASKS__) && defined(__ALLOW_NESTED_IRQ__)\n\n" +
				indent1+"#ifdef __IRQ_PRIORITY_MASKS_NOCONST__\n" +
				indent1+"EE_TYPEIRQMASK EE_IC_EXTIRQ_masks["+ErikaEnterpriseWriter.addVectorSizeDefine(ool, "EE_IC_EXTIRQ_masks", 21)+"];\n" +
				indent1+"#else\n" +
				indent1+"/* the appropriate values have to be specified here!!!\n" + 
				indent1+"   0x001FFFFF is a safe value that blocks everything\n" +
				indent1+"*/\n" +
				indent1+"const EE_TYPEIRQMASK EE_IC_EXTIRQ_masks["+ErikaEnterpriseWriter.addVectorSizeDefine(ool, "EE_IC_EXTIRQ_masks", 21)+"] = {\n" +
				indent2+"0x001FFFFF, /* Ext 0 */\n" +
				indent2+"0x001FFFFF, /* Ext 1 */\n" +
				indent2+"0x001FFFFF, /* Ext 2 */\n" +
				indent2+"0x001FFFFF, /* Ext 3 */\n" +
				indent2+"0x001FFFFF, /* UART0 Tx */\n" +
				indent2+"0x001FFFFF, /* UART0 Rx & error*/\n" +
				indent2+"0x001FFFFF, /* UART1 Tx */\n" +
				indent2+"0x001FFFFF, /* UART1 Rx & error*/\n" +
				indent2+"0x001FFFFF, /* GDMA ch. 0 */\n" +
				indent2+"0x001FFFFF, /* GDMA ch. 1 */\n" +
				indent2+"0x001FFFFF, /* Timer 0 */\n" +
				indent2+"0x001FFFFF, /* Timer 1 */\n" +
				indent2+"0x001FFFFF, /* HDLC A Tx */\n" +
				indent2+"0x001FFFFF, /* HDLC A Rx */\n" +
				indent2+"0x001FFFFF, /* HDLC B Tx */\n" +
				indent2+"0x001FFFFF, /* HDLC B Rx */\n" +
				indent2+"0x001FFFFF, /* Ethernet BDMA Tx */\n" +
				indent2+"0x001FFFFF, /* Ethernet BDMA Rx */\n" +
				indent2+"0x001FFFFF, /* Ethernet MAC Tx */\n" +
				indent2+"0x001FFFFF, /* Ethernet MAC Rx */\n" +
				indent2+"0x001FFFFF, /* I2C-bus */\n" +
				indent1+"};\n" +
				indent1+"#endif\n\n" +
				indent1+"#endif\n");


		return new IOilWriterBuffer[] { answer };
	}

	
/* (non-Javadoc)
	 * @see com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.IExtractKeywordsExtentions#updateKeywords(java.util.ArrayList, java.lang.String[])
	 */
	public void updateKeywords(ArrayList<String> keywords, String[] rtosPrefix)
			throws OilCodeWriterException {

		if (!keywords.contains(IWritersKeywords.CPU_ARM7)) {
			return;
		}

		final IVarTree vt = parent.getVt();

		//final ArrayList ee_opts = new ArrayList();
		for (int i=0; i<rtosPrefix.length; i++) {
			
			/*******************************************************************
			 * MCU TYPE
			 ******************************************************************/
			String path = parent.computeOilRtosPrefix(rtosPrefix[i]) + "MCU_DATA";

			String[] child = new String[1];
			String mcu_type = CommonUtils.getFirstChildEnumType(vt,
					path , child);
			if (mcu_type != null) {

				// check if the value is valid
				if ("SAMSUNG_KS32C50100".equals(mcu_type)
						&& !keywords.contains(Arm7Constants.DEF__SAMSUNG_KS32C50100__)) {
					keywords.add(Arm7Constants.DEF__SAMSUNG_KS32C50100__);
				}
				
			}
		}

	}	


	/* (non-Javadoc)
	 * @see com.eu.evidence.modules.oil.erikaenterprise.interfaces.IGetEEOPTExtentions#getEEOpt(int)
	 */
	public List<String> getEEOpt(int type, int rtosId) {
		List<String> answer = new ArrayList<String>();
		
		
		if ((type & EE_OPT_COMMON_AUTO_ONLY) != 0) {
			/*******************************************************************
			 * AUTOMATIC OPTIONS (not CPU DEPENDENT)
			 ******************************************************************/

			{ // Extract options from current keywords
				if (parent.checkKeyword(Arm7Constants.DEF__SAMSUNG_KS32C50100__)) {
					
					answer.add("__SAMSUNG_KS32C50100__");
				}

			}
			
		}

		return answer;
	}

}
