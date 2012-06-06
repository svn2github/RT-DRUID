/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterHalMico32.java,v 1.17 2008/02/05 10:15:18 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;

import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.OilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.CpuUtility;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.vartree.DataPath;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;
import com.eu.evidence.rtdruid.vartree.tools.Search;

/**
 * This writer build files for the intercommunication among two cores using a "fake" autosar com
 * 
 * @author Nicola Serreli
 */
public class SectionWriterComMpc567 extends SectionWriter 
	implements IEEWriterKeywords,
			IExtractObjectsExtentions,
			IExtractKeywordsExtentions {

	final String indent1 = IWritersKeywords.INDENT;
	final String indent2 = indent1 + IWritersKeywords.INDENT;

	protected static final DataPackage DPKG = DataPackage.eINSTANCE;
	protected static final char S = DataPath.SEPARATOR;
	
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;
	
	/** All data */
	protected final IVarTree vt;

	static final String PPC_MCU = "PPCE200ZX";
	
	/**
	 * 
	 */
	public SectionWriterComMpc567() {
		this(null);
	}
	
	/**
	 * 
	 */
	public SectionWriterComMpc567(ErikaEnterpriseWriter parent) {
		super(IWritersKeywords.CPU_PPCE200ZX,
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

	@Override
	protected boolean enabled() {
		return super.enabled() && parent.getRtosSize()>1;
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

		return writeCom();
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
	
	}
	
	/**
	 * Write configuration's files for Com initialization
	 * 
	 * @return buffers with configuration for the Com initialization
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeCom()
			throws OilCodeWriterException {
		
		final String frame_list_path = Search.systemName(vt) +S+ DPKG.getSystem_Architectural().getName() + S +
				DPKG.getArchitectural_FrameList().getName() ;
		
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		IOilWriterBuffer[] answer = new IOilWriterBuffer[oilObjects.length];
		ICommentWriter commentWriter;
		{
			commentWriter = getCommentWriter(oilObjects[0], FileTypes.C);
		}
		
		StringBuffer com_h = new StringBuffer();
		StringBuffer com_c = new StringBuffer();
		
		// get all Frames
		String[] frame_names = vt.newTreeInterface().getAllName(frame_list_path, DPKG.getFrame().getName()); 
		if (frame_names.length>0) {
			prepareComFiles(frame_names, com_h, com_c, commentWriter);
		}

		
		for (int rtosId = 0; rtosId < oilObjects.length; rtosId++) {
			
			IOilObjectList ool = oilObjects[rtosId];
			answer[rtosId] = new OilWriterBuffer();
			
			if (frame_names.length>0) {
				if (rtosId == 0) {
					// master
					answer[rtosId].get("Com.c").append(com_c);
					CpuUtility.addSources(ool, new String[] {answer[rtosId].getFileName("Com.c")});
				}
				answer[rtosId].get("Com.h").append(com_h);
			}
			
		}
		
		
		return answer;
	}


	protected void prepareComFiles(String[] frame_names, StringBuffer com_h,
			StringBuffer com_c, ICommentWriter cComment) throws OilCodeWriterException {

		
		com_h.append("#include <ee.h>\n"+
				"#include \"com_core.h\"\n\n" +
				"#define SignalIdMax " + (frame_names.length -1) + "U\n" +
				"extern const struct ee_com_signal_def EE_SHARED_CDATA ee_com_sig_defs[SignalIdMax + 1U];\n\n");

		
		com_c.append("#include \"Com.h\"\n"+
					"#include \"ee.h\"\n\n");
		
		
		
		ITreeInterface ti = vt.newTreeInterface();
		final String basePath = Search.systemName(vt) +S+ DPKG.getSystem_Architectural().getName() + S +
				DPKG.getArchitectural_FrameList().getName()+S;
		final String sizeType = DPKG.getFrame_Length().getName();
		
		StringBuffer sizes = new StringBuffer();
		StringBuffer buffers = new StringBuffer();
		StringBuffer collector = new StringBuffer("const struct ee_com_signal_def EE_SHARED_CDATA ee_com_sig_defs[SignalIdMax + 1U] = {\n");
		
		int id =0;
		for (String name : frame_names) {
			
			int char_size = -1;
			{
				IVariable size =  ti.getValue(basePath+name+S+sizeType);
				if (size != null && size.get() != null) {
					
					try {
						char_size = Integer.parseInt( "" + size.get() );
						
					} catch (NumberFormatException e) {
						// nothing
						char_size = -1;
					}
				}
				
			
				if (char_size == -1) {
					throw new OilCodeWriterException("Frame " + name + " has a not valid length");
				}
				
				char_size = (int) Math.ceil(char_size/8.0);
			}
			
			
			// com.h
			com_h.append("#define " + name + " " +id+"U\n");
			
			
			// com.c
			sizes.append(cComment.writerSingleLineComment(name) +
					"#define EE_COM_SIG"+id+"_LEN " + char_size + "U\n");
			
			buffers.append("static unsigned char EE_SHARED_UDATA ee_com_sig_"+id+"_buf[EE_COM_SIG"+id+"_LEN];\n");
			collector.append(indent1+"{ ee_com_sig_"+id+"_buf, EE_COM_SIG"+id+"_LEN },\t" + cComment.writerSingleLineComment(name));
			
			
			// next id
			id++;
		}
		collector.append("};\n");
		
		
		com_h.append("\n");
		
		com_c.append(sizes + "\n" +
				buffers + "\n" +
				collector + "\n");
		
	}
}
