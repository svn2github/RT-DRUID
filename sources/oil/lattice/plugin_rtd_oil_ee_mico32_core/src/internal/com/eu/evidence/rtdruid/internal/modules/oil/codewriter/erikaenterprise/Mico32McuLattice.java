/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterHalMico32.java,v 1.17 2008/02/05 10:15:18 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.mico32.constants.Mico32Constants;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.keywords.IOilXMLLabels;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.data.DataPackage;

/**
 * This writer build files for a DS PIC CPU - Board
 * 
 * @author Nicola Serreli
 */
public class Mico32McuLattice implements IEEWriterKeywords {
	protected static final String indent1 = IWritersKeywords.INDENT;
	protected static final String indent2 = IWritersKeywords.INDENT + IWritersKeywords.INDENT;

	private static class Device {
		final String name;
		LinkedHashSet<String> enabledOptions;
		
		public Device(String name) {
			this.name = name;
			this.enabledOptions = new LinkedHashSet<String>();
		}
		
		static public Device loadDevice(IVarTree vt, String devicePath) throws OilCodeWriterException {

			// read Platform name 
			String name = SectionWriterHalMico32.clean(CommonUtils.getValue(vt, devicePath+"NAME"));
			if (name == null) {
				throw new OilCodeWriterException("Mico 32, mcu: found a device with an empty name");
			}
			
			Device answer = new Device(name);
			
			ArrayList<String> options = CommonUtils.getAllChildrenEnumType(vt, devicePath+"OPTIONS", null);
			if (options != null)
				answer.enabledOptions.addAll(options); 
					
			return answer;
		}
	}
	
	private static class Devices {
		ArrayList<Device> uarts = new ArrayList<Device>();
		ArrayList<Device> spi = new ArrayList<Device>();
		ArrayList<Device> timer = new ArrayList<Device>();
		ArrayList<Device> i2c = new ArrayList<Device>();
		ArrayList<Device> gpio = new ArrayList<Device>();
	}
	
	
	final private String MICO32_MCU = "LATTICE_PLATFORM";

	
	/** All data */
	protected final IVarTree vt;

	protected final ErikaEnterpriseWriter parent;
	
	private Devices foundDevices = new Devices();
	
	/**
	 * 
	 */
	public Mico32McuLattice(ErikaEnterpriseWriter parent) {
		this.parent = parent;
		this.vt = parent.getVt();
	}
	
	
	/*
	 * Parse and write the MCU Section
	 */
	public void checkMcu(ArrayList<String> ee_opts) throws OilCodeWriterException {

		final IOilObjectList[] oilObjects = parent.getOilObjects();
		
		String platform_name = "";
		String platform_path = "";
		String platform_cfg = "";
		
		/* COMMON VARIABLES */
		for (int currentRtosId = 0; currentRtosId < oilObjects.length; currentRtosId++) {
		
			ISimpleGenRes os = (ISimpleGenRes) oilObjects[currentRtosId].getList(IOilObjectList.OS).get(currentRtosId);

			// prepare the path :
			// ... the prefix ...
			final String currentMcuPrefix = os.getPath() + S
					+ DataPackage.eINSTANCE.getRtos_OilVar().getName() + S
					+ IOilXMLLabels.OBJ_OS + parent.getOilHwRtosPrefix() + "MCU_DATA";
			
			// ... get the node identifier
			String[] child = new String[1];
			String mcu_type = CommonUtils.getFirstChildEnumType(vt, currentMcuPrefix, child);
			
			if (child.length >0 && MICO32_MCU.equals(mcu_type)) {
				
				{ // LIBRARY
					// ... and compete it 
					String libraryPath = currentMcuPrefix + VARIANT_ELIST + child[0] + PARAMETER_LIST + "MODEL";
	
					String model_type = CommonUtils.getFirstChildEnumType(vt, libraryPath, child);
					
					/* CUSTOM */
					if ("LIBRARY".equals(model_type)) {
						libraryPath += VARIANT_ELIST + child[0] + PARAMETER_LIST;
						
						// read Platform name 
						String name = SectionWriterHalMico32.clean(CommonUtils.getValue(vt, libraryPath+"PLATFORM_NAME"));
						if (name != null) {
							platform_name = name;
						}
						
						// read Platform path 
						String path = SectionWriterHalMico32.clean(CommonUtils.getValue(vt, libraryPath+"PLATFORM_LIB_PATH"));
						if (path != null) {
							platform_path = path;
						}
						
						// read Platform name 
						String cfg = SectionWriterHalMico32.clean(CommonUtils.getValue(vt, libraryPath+"PLATFORM_BLD_CFG"));
						if (cfg != null) {
							platform_cfg = cfg;
						}
					}
					
				}
				
				{ // ------  Devices  ------

					// ... and compete it 
					String devicesPath = currentMcuPrefix + VARIANT_ELIST + child[0] + PARAMETER_LIST + "DEVICE";
	
					ArrayList<String> children = new ArrayList<String>();
					ArrayList<String> device_types = CommonUtils.getAllChildrenEnumType(vt, devicesPath, children);
					
					if (device_types != null)
					for (int i=0; i<device_types.size(); i++) {
						String type = device_types.get(i);
						String path = devicesPath + VARIANT_ELIST + children.get(i) + PARAMETER_LIST;
						if ("UART".equals(type)) { // UART max 2
							foundDevices.uarts.add(Device.loadDevice(vt, path));
						} else if ("SPI".equals(type)) { // SPI max 2
							foundDevices.spi.add(Device.loadDevice(vt, path));
						} else if ("TIMER".equals(type)) { // TIMER max 4								
							foundDevices.timer.add(Device.loadDevice(vt, path));
						} else if ("I2C".equals(type)) { // I2C max 2
							foundDevices.i2c.add(Device.loadDevice(vt, path));
						} else if ("GPIO".equals(type)) { // GPIO max ??
							foundDevices.gpio.add(Device.loadDevice(vt, path));
						}

					}
					
				}
				
			}
		}
		
		if (foundDevices.uarts.size() > 2) {
			throw new OilCodeWriterException("Mico 32, mcu: supported max 2 UART");
		}
		if (foundDevices.spi.size() > 2) {
			throw new OilCodeWriterException("Mico 32, mcu: supported max 2 SPI");
		}
		if (foundDevices.timer.size() > 4) {
			throw new OilCodeWriterException("Mico 32, mcu: supported max 4 TIMER");
		}
		if (foundDevices.i2c.size() > 2) {
			throw new OilCodeWriterException("Mico 32, mcu: supported max 2 I2C");
		}
		
		
		int last_uart  = 0;
		int last_spi   = 0;
		int last_timer = 0;
		int last_i2c   = 0;
		int last_gpio   = 0;
		
		final ICommentWriter commentWriter;
		{
			ISimpleGenRes os = (ISimpleGenRes) oilObjects[0].getList(IOilObjectList.OS).get(0);

			if (os.containsProperty(Mico32Constants.SGRK__MICO32_LAST_USED_UART__Integer)) {
				last_uart = ((Integer) os.getObject(Mico32Constants.SGRK__MICO32_LAST_USED_UART__Integer)).intValue();
			}
			if (os.containsProperty(Mico32Constants.SGRK__MICO32_LAST_USED_SPI__Integer)) {
				last_spi = ((Integer) os.getObject(Mico32Constants.SGRK__MICO32_LAST_USED_SPI__Integer)).intValue();
			}
			if (os.containsProperty(Mico32Constants.SGRK__MICO32_LAST_USED_TIMER__Integer)) {
				last_timer = ((Integer) os.getObject(Mico32Constants.SGRK__MICO32_LAST_USED_TIMER__Integer)).intValue();
			}
			if (os.containsProperty(Mico32Constants.SGRK__MICO32_LAST_USED_I2C__Integer)) {
				last_i2c = ((Integer) os.getObject(Mico32Constants.SGRK__MICO32_LAST_USED_I2C__Integer)).intValue();
			}
			if (os.containsProperty(Mico32Constants.SGRK__MICO32_LAST_USED_GPIO__Integer)) {
				last_gpio = ((Integer) os.getObject(Mico32Constants.SGRK__MICO32_LAST_USED_GPIO__Integer)).intValue();
			}
			
			commentWriter = SectionWriter.getCommentWriter(os, FileTypes.H);
		}

		
		StringBuffer definitions = new StringBuffer();
		String space = "";
		for (Device dev : foundDevices.uarts){
			last_uart +=1;
			
			add(ee_opts, "__USE_UART__");
			
			definitions.append(space +
					indent1 + commentWriter.writerSingleLineComment("Mico32 mcu device: uart " + dev.name) +
					indent1 + "#define EE_UART" + last_uart +"_NAME_LC "+ dev.name + "\n" +
					indent1 + "#define EE_UART" + last_uart +"_NAME_UC "+ dev.name.toUpperCase() + "\n"
					);
			addIfDefIrq(dev.name, definitions);

			if (dev.enabledOptions.contains("ALL") || dev.enabledOptions.contains("UART_IRQ_SUPPORT")) {
				add(ee_opts, "__USE_UART_IRQ__");
				add(ee_opts, "__USE_BUFFER__");
			}	
			space = "\n";
		}
		for (Device dev : foundDevices.spi){
			last_spi +=1;

			add(ee_opts, "__USE_SPI__");

			definitions.append(space +
					indent1 + commentWriter.writerSingleLineComment("Mico32 mcu device: spi " + dev.name) +
					indent1 + "#define EE_SPI" + last_spi +"_NAME_LC "+ dev.name + "\n" +
					indent1 + "#define EE_SPI" + last_spi +"_NAME_UC "+ dev.name.toUpperCase() + "\n"
					);
			addIfDefIrq(dev.name, definitions);

			if (dev.enabledOptions.contains("ALL") || dev.enabledOptions.contains("SPI_IRQ_SUPPORT")) {
				add(ee_opts, "__USE_SPI_IRQ__");
				add(ee_opts, "__USE_BUFFER__");
			}	
			space = "\n";
		}
		for (Device dev : foundDevices.timer){
			last_timer +=1;

			add(ee_opts, "__USE_TIMER__");

			definitions.append(space +
					indent1 + commentWriter.writerSingleLineComment("Mico32 mcu device: timer " + dev.name) +
					indent1 + "#define EE_TIMER" + last_timer +"_NAME_LC "+ dev.name + "\n" +
					indent1 + "#define EE_TIMER" + last_timer +"_NAME_UC "+ dev.name.toUpperCase() + "\n"
					);
			addIfDefIrq(dev.name, definitions);

			if (dev.enabledOptions.contains("ALL") || dev.enabledOptions.contains("TIMER_IRQ_SUPPORT")) {
				add(ee_opts, "__USE_TIMER_IRQ__");
			}	
			space = "\n";
		}
		for (Device dev : foundDevices.i2c){
			last_i2c +=1;

			add(ee_opts, "__USE_I2C__");

			definitions.append(space +
					indent1 + commentWriter.writerSingleLineComment("Mico32 mcu device: i2c " + dev.name) +
					indent1 + "#define EE_I2C" + last_i2c +"_NAME_LC "+ dev.name + "\n" +
					indent1 + "#define EE_I2C" + last_i2c +"_NAME_UC "+ dev.name.toUpperCase() + "\n"
					);
			addIfDefIrq(dev.name, definitions);

			if (dev.enabledOptions.contains("ALL") || dev.enabledOptions.contains("I2C_IRQ_SUPPORT")) {
				add(ee_opts, "__USE_I2C_IRQ__");
				add(ee_opts, "__USE_BUFFER__");
			}
			space = "\n";
		}
		for (Device dev : foundDevices.gpio){
			last_gpio +=1;

			add(ee_opts, "__USE_GPIO__");

			definitions.append(space +
					indent1 + commentWriter.writerSingleLineComment("Mico32 mcu device: gpio " + dev.name) +
					indent1 + "#define EE_GPIO" + last_gpio +"_NAME_LC "+ dev.name + "\n" +
					indent1 + "#define EE_GPIO" + last_gpio +"_NAME_UC "+ dev.name.toUpperCase() + "\n"
					);
			addIfDefIrq(dev.name, definitions);

			if (dev.enabledOptions.contains("ALL") || dev.enabledOptions.contains("GPIO_IRQ_SUPPORT")) {
				add(ee_opts, "__USE_GPIO_IRQ__");
			}
			space = "\n";
		}
		
		
		
		
		// -- Store everything
		for (int currentRtosId = 0; currentRtosId  < oilObjects.length; currentRtosId++) {  
		
			/* COMMON VARIABLES */
			ISimpleGenRes os = (ISimpleGenRes) oilObjects[currentRtosId].getList(IOilObjectList.OS).get(0);

			String base = "";

			if (os.containsProperty(Mico32Constants.SGRK__MICO32_BOARD_EEC_DEFINES__)) {
				base = os.getString(Mico32Constants.SGRK__MICO32_BOARD_EEC_DEFINES__) + "\n";
			}
			os.setProperty(Mico32Constants.SGRK__MICO32_BOARD_EEC_DEFINES__,
					base + definitions.toString());

			

			os.setProperty(Mico32Constants.SGRK__OS_PLATFORM_CFG__, platform_cfg);
			os.setProperty(Mico32Constants.SGRK__OS_PLATFORM_NAME__, platform_name);
			os.setProperty(Mico32Constants.SGRK__OS_PLATFORM_LIB_PATH_, platform_path);
		}
	}
	
	
	
	
	
	public static void addPlatformFile(ISimpleGenRes os, IOilWriterBuffer answer) {
		StringBuffer buffer = answer.get("platform.mk");
		
		final String platform_name = os.containsProperty(Mico32Constants.SGRK__OS_PLATFORM_NAME__) ?
				os.getString(Mico32Constants.SGRK__OS_PLATFORM_NAME__) : "";
		final String platform_lib_path = os.containsProperty(Mico32Constants.SGRK__OS_PLATFORM_LIB_PATH_) ?
				os.getString(Mico32Constants.SGRK__OS_PLATFORM_LIB_PATH_) : "";
		final String platform_cfg = os.containsProperty(Mico32Constants.SGRK__OS_PLATFORM_CFG__) ?
				os.getString(Mico32Constants.SGRK__OS_PLATFORM_CFG__) : "";
		
		final ICommentWriter commentWriter = SectionWriter.getCommentWriter(os, FileTypes.MAKEFILE);
		// Dynamic part
		buffer.append("# Platform-specific settings\n"+
				"#\n"+
				"\n"+
				commentWriter.writerBanner("Variable part, automatically generated from 'conf.oil'")+
				"PLATFORM_NAME=" + platform_name + "\n"+
				"PLATFORM_LIB_PATH=" + platform_lib_path + "\n"+
				"PLATFORM_BLD_CFG=" + platform_cfg + "\n"+
				"\n\n");
		
		// Fixed Part
//		buffer.append(commentWriter.writerBanner("Fixed part")+
//			"ifndef PLATFORM_BLD_CFG\n"+
//			"ifeq ($(findstring DEBUG,$(EEOPT)) , DEBUG)\n"+
//			"PLATFORM_BLD_CFG=Debug\n"+
//			"else\n"+
//			"PLATFORM_BLD_CFG=Release\n"+
//			"endif\n"+
//			"endif\n"+
//			"\n"+
//			"# Where these platform-dependent makefiles are located.\n"+
//			"PLATFORM_MAKEFILES_DIR = $(addprefix $(PLATFORM_LIB_PATH),\\\n"+
//			IWritersKeywords.INDENT + "$(addprefix /$(PLATFORM_NAME), /$(PLATFORM_BLD_CFG)))\n"+
//			"\n"+
//			"# Platform library (relative path and name)\n"+
//			"PLATFORM_LIBRARY=$(addprefix $(PLATFORM_LIB_PATH)/,\\\n"+
//			IWritersKeywords.INDENT + "$(addprefix $(PLATFORM_BLD_CFG)/,\\\n"+
//			IWritersKeywords.INDENT + "$(addprefix $(PLATFORM_BLD_CFG)/, lib$(PLATFORM_NAME).a)))\n"+
//			"\n"+
//			"\n"+
//			"# Linker file\n"+
//			"PLATFORM_LD_FILE=$(PLATFORM_MAKEFILES_DIR)/linker.ld\n"+
//			"\n"+
//			"# Platform_rules.mk contains CPU configuration.\n"+
//			"include $(PLATFORM_MAKEFILES_DIR)/platform_rules.mk");
	}

	


	private void add(ArrayList<String> ee_opts, String eeopt) {
		if (!ee_opts.contains(eeopt)) {
			ee_opts.add(eeopt);
		}
	}


	public final static void addIfDefIrqWithCheck(String define, StringBuffer definitions) {
		if (define.startsWith("EE_") && define.contains("_NAME_UC ")) {
			addIfDefIrq(define.substring(define.indexOf("_NAME_UC ") + "_NAME_UC ".length()), definitions);
		}
	}
	public final static void addIfDefIrq(String name, StringBuffer definitions) {
		definitions.append(indent1 + "#ifndef "+ name.toUpperCase() + "_IRQ \n" +
				indent2 + "#define "+ name.toUpperCase() + "_IRQ -1\n" +
				indent1 + "#endif\n");
	}

}
