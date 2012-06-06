/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterHalMico32.java,v 1.17 2008/02/05 10:15:18 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.vartree.IVarTree;

/**
 * This writer build files for a DS PIC CPU - Board
 * 
 * @author Nicola Serreli
 */
public class Mico32BoardLatticeXP2EvaluationBoard extends AMico32Board {

	protected static List<BoardOption> availableOptions = null;
	
	static {
		availableOptions = loadOptions();
	}


	private static ArrayList<BoardOption> loadOptions() {
		ArrayList<BoardOption> answer = new ArrayList<BoardOption>();

		addOptions(answer, "LEDS",
				new String[]{},
				new IndexedOption[]{
					new IndexedOption ( 
						new String[] {
								"EE_GPIO"+INDEX_PLACER+"_NAME_LC led", "EE_GPIO"+INDEX_PLACER+"_NAME_UC LED"}, // define
						IrqType.gpio),
					new IndexedOption ( 
						new String[] {
								"EE_GPIO"+INDEX_PLACER+"_NAME_LC num_led", "EE_GPIO"+INDEX_PLACER+"_NAME_UC NUM_LED"}, // define
						IrqType.gpio)}, 
				new String[] {"__USE_LEDS__", "__USE_GPIO__"},  //eeopt;
				GROUP_ZIGBEE); 

		addOptions(answer, "RS232",
				new IndexedOption[]{ new IndexedOption( 
						new String[] {"EE_UART"+INDEX_PLACER+"_NAME_LC uart", "EE_UART"+INDEX_PLACER+"_NAME_UC UART"}, // define
						IrqType.uart)}, 
				new String[]{"__USE_UART__"}); //eeopt;
		
		addOptions(answer, "RS232_IRQ_SUPPORT",
				new String[]{}, // define
				new String[] {"__USE_UART_IRQ__", "__USE_BUFFER__"}); //eeopt;
		
		addOptions(answer, "CAMERA",
				new String[]{},
				new IndexedOption[]{
					new IndexedOption(
						new String[] {
							"EE_I2C"+INDEX_PLACER+"_NAME_LC camera_i2c", "EE_I2C"+INDEX_PLACER+"_NAME_UC CAMERA_I2C"},
//						new String[] { "__EE_CAMERA_USE_I2C" +INDEX_PLACER+ "__"},
						IrqType.i2c)}, 
				new String[] {"__USE_CAMERA_HV7131GP__", "__USE_HV7131GP__", "__USE_I2C__"}); //eeopt;
		
		addOptions(answer, "CAMERA_IRQ_SUPPORT",
				new String[]{}, // define
				new String[] {"__USE_CAMERA_IRQ__"}); //eeopt;

		return answer;
	}
	
	
	
	/** All data */
	protected final IVarTree vt;

	/** Enabled options **/
	protected HashSet<String> foundOptions = new HashSet<String>();
	
	public Mico32BoardLatticeXP2EvaluationBoard(IVarTree vt) {
		this.vt = vt;
	}
	
	/*
	 * Parse and write the BOARD Section
	 */
	public void check(String path) {
		
		{
			/***********************************************************************
			 * get all options
			 **********************************************************************/

			// prepare the path :
			// ... the prefix ...
			String optionPath = path + "OPTIONS";
			ArrayList<String> board_options = CommonUtils.getAllChildrenEnumType(vt, optionPath, null);
			if (board_options != null)
				foundOptions.addAll(board_options);
		}
	}

	@Override
	protected String getBoardName() {
		return "Mico32 XP2 camera board";
	}
	
	/*
	 * Parse and write the BOARD Section
	 */
	public void updateObjects(final IOilObjectList[] oilObjects, ArrayList<String> eeoptions) throws OilCodeWriterException {

		eeoptions.add("__LATTICE_XP2_EV_BOARD__");
		int all = 0;
		
		CpuDescrMico32 cpu = new CpuDescrMico32();
		
		Indexes indexes = new Indexes();
		StringBuffer definitions = new StringBuffer();
		parseOptions(all, indexes, definitions, availableOptions,
				foundOptions, eeoptions, cpu.commentManager);
	

		for (IOilObjectList ool: oilObjects) {
			for (ISimpleGenRes os : ool.getList(IOilObjectList.OS)) {
				updateOs(os, definitions, indexes);
			}
		}

	}
}
