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
public class Mico32BoardEYE extends AMico32Board {

	
	private final static String  ALL_ZIGBEE = "ALL_ZIGBEE";
	private final static String  ALL_ETHERNET = "ALL_ETHERNET";
	
	protected static List<BoardOption> availableOptions = null;
		
	
	static {
		availableOptions = loadOptions();
	}


	private static ArrayList<BoardOption> loadOptions() {
		ArrayList<BoardOption> answer = new ArrayList<BoardOption>();

		UniqueIndexedOption misc_gpio = new UniqueIndexedOption ( 
				new String[] {
						"EE_GPIO"+INDEX_PLACER+"_NAME_LC misc_gpio", "EE_GPIO"+INDEX_PLACER+"_NAME_UC MISC_GPIO"}, // define
				IrqType.gpio); 

		UniqueIndexedOption camera_lsensor_i2c = new UniqueIndexedOption ( 
				new String[] {
					"EE_I2C"+INDEX_PLACER+"_NAME_LC camera_i2c", "EE_I2C"+INDEX_PLACER+"_NAME_UC CAMERA_I2C"},
				IrqType.i2c); 

//		addOptions(answer, "LCD",
//				new IndexedOption[]{ new IndexedOption( 
//						new String[] {"EE_GPIO"+INDEX_PLACER+"_NAME_LC lcd_gpio", "EE_GPIO"+INDEX_PLACER+"_NAME_UC LCD_GPIO"}, // define
//						IrqType.gpio)}, 
//				new String[] {"__USE_GPIO__"}); //eeopt;

		
		addOptions(answer, "LIGHTSENSOR",
				new String[]{}, // define
				new IndexedOption[]{ 
					camera_lsensor_i2c},
				new String[] {"__USE_LIGHTSENSOR_TSL2561T__", "__USE_I2C__"}); //eeopt;
		
		addOptions(answer, "LEDS",
				new String[]{},
				new IndexedOption[]{ 
					misc_gpio}, 
				new String[] {"__USE_LEDS__", "__USE_GPIO__"}  //eeopt;
				); 
		
		addOptions(answer, "TRANSISTORS",
				new String[]{}, // define
				new String[] {"__USE_TRANSISTORS__"}); //eeopt;

		addOptions(answer, "SWITCHES",
				new String[]{}, // define
				new String[] {"__USE_SWITCHES__"}); //eeopt;

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
					camera_lsensor_i2c},
				new String[] {"__USE_CAMERA_HV7131GP__", "__USE_HV7131GP__", "__USE_I2C__"}); //eeopt;
		
		addOptions(answer, "CAMERA_IRQ_SUPPORT",
				new String[]{}, // define
				new String[] {"__USE_CAMERA_IRQ__"}); //eeopt;
		
		addOptions(answer, "RTCLOCK",
				new String[]{"EE_RTC_NAME_LC rtc", "EE_RTC_NAME_UC RTC"},
				new IndexedOption[]{ new IndexedOption( 
						new String[] { "EE_I2C"+INDEX_PLACER+"_NAME_LC rtc_i2c", "EE_I2C"+INDEX_PLACER+"_NAME_UC RTC_I2C"}, // define
						IrqType.i2c)}, 
				new String[] {"__USE_RTC_PCF8583__", "__USE_I2C__"}); //eeopt;

		
		addOptions(answer, "RTCLOCK_IRQ_SUPPORT",
				new String[]{}, // define
				new String[] {}, //eeopt;
				"RTC IRQ for alarm detection not supported");
		
		addOptions(answer, "EXTSPI",
				new IndexedOption[]{ new IndexedOption( 
						new String[]{"EE_SPI"+INDEX_PLACER+"_NAME_LC ext_spi", "EE_SPI"+INDEX_PLACER+"_NAME_UC EXT_SPI"}, // define
						IrqType.spi)}, 
				new String[] {"__USE_SPI__"}); //eeopt;
		
		addOptions(answer, "EXTSPI_IRQ_SUPPORT",
				new String[]{}, // define
				new String[] {"__USE_SPI_IRQ__"}); //eeopt;
		
		addOptions(answer, "ZIGBEE",
				new String[]{"EE_ZIGBEE_NAME_LC zigbee", "EE_ZIGBEE_NAME_UC ZIGBEE"},
				new IndexedOption[]{ 
					new IndexedOption( 
						new String[] {"EE_SPI"+INDEX_PLACER+"_NAME_LC net_spi", "EE_SPI"+INDEX_PLACER+"_NAME_UC NET_SPI"},
						IrqType.spi), 
					misc_gpio}, 
				new String[] {"__USE_ZIGBEE_MRF24J40__", "__USE_SPI__", "__USE_GPIO__"},  //eeopt;
				GROUP_ZIGBEE); 
		
		addOptions(answer, "ZIGBEE_IRQ_SUPPORT",
				new String[]{}, // define
				new IndexedOption[]{},
				new String[] {"__USE_ZIGBEE_IRQ__"},  //eeopt;
				GROUP_ZIGBEE);

		addOptions(answer, "ETHERNET",
				new String[]{"EE_ETHERNET_NAME_LC ethernet", "EE_ETHERNET_NAME_UC ETHERNET"},
				new IndexedOption[]{ 
					new IndexedOption( 
						new String[] { "EE_SPI"+INDEX_PLACER+"_NAME_LC net_spi", "EE_SPI"+INDEX_PLACER+"_NAME_UC NET_SPI"},
						IrqType.spi), 
					misc_gpio}, 
				new String[] {"__USE_ETHERNET_ENC28J60__", "__USE_SPI__", "__USE_GPIO__"},  //eeopt;
				GROUP_ETHERNET); 

		addOptions(answer, "ETHERNET_IRQ_SUPPORT",
				new String[]{}, // define
				new IndexedOption[]{},
				new String[] {"__USE_ETHERNET_IRQ__"},  //eeopt;
				GROUP_ETHERNET);

//		addOptions(answer, ALL_ZIGBEE,
//				new String[]{}, // define
//				new String[] {},  //eeopt;
//				GROUP_ZIGBEE);
//
//		addOptions(answer, ALL_ETHERNET,
//				new String[]{}, // define
//				new String[] {},  //eeopt;
//				GROUP_ETHERNET);

		return answer;
	}
	
	
	
	/** All data */
	protected final IVarTree vt;

	/** Enabled options **/
	protected HashSet<String> foundOptions = new HashSet<String>();
	
	public Mico32BoardEYE(IVarTree vt) {
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
		return "Mico32 fpg-eye board";
	}
	
	/*
	 * Parse and write the BOARD Section
	 */
	public void updateObjects(final IOilObjectList[] oilObjects, ArrayList<String> eeoptions) throws OilCodeWriterException {

		eeoptions.add("__FPG_EYE__");
		
		int all = 0;
		
		if (foundOptions.contains(ALL_ETHERNET)) {
			all = GROUP_ETHERNET;
		} 
		if (foundOptions.contains(ALL_ZIGBEE)) {
			if (all != 0) {
				throw new OilCodeWriterException ("Mico32, fpg-eye board: it is illegal to require both ETHERNET and ZIGBEE options");
			}
			all = GROUP_ZIGBEE;
		}
		
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
