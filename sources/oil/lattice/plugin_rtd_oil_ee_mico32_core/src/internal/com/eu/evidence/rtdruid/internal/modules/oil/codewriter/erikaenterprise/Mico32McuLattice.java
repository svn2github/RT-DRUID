/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterHalMico32.java,v 1.17 2008/02/05 10:15:18 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import static com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter.checkOrDefault;
import static com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter.getOsProperty;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import com.eu.evidence.rtdruid.internal.modules.oil.exceptions.OilCodeWriterException;
import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.internal.modules.oil.mico32.constants.Mico32Constants;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilWriterBuffer;
import com.eu.evidence.rtdruid.modules.oil.abstractions.ISimpleGenRes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SectionWriter;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.FileTypes;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.ICommentWriter;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilObjectType;
import com.eu.evidence.rtdruid.modules.oil.implementation.OilPath;
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
		for (IOilObjectList ool: oilObjects) {
			for (ISimpleGenRes os : ool.getList(IOilObjectList.OS)) {
	
				// prepare the path :
				// ... the prefix ...
				final String currentMcuPrefix = os.getPath() + S
						+ (new OilPath(OilObjectType.OS, null)).getPath() + "MCU_DATA";
				
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
		
		
		int last_uart  = getValue(oilObjects[0], Mico32Constants.SGRK__MICO32_LAST_USED_UART__Integer, 0);
		int last_spi   = getValue(oilObjects[0], Mico32Constants.SGRK__MICO32_LAST_USED_SPI__Integer, 0);
		int last_timer = getValue(oilObjects[0], Mico32Constants.SGRK__MICO32_LAST_USED_TIMER__Integer, 0);
		int last_i2c   = getValue(oilObjects[0], Mico32Constants.SGRK__MICO32_LAST_USED_I2C__Integer, 0);
		int last_gpio  = getValue(oilObjects[0], Mico32Constants.SGRK__MICO32_LAST_USED_GPIO__Integer, 0);
		
		final ICommentWriter commentWriter = SectionWriter.getCommentWriter(oilObjects[0], FileTypes.H);

		
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
		for (IOilObjectList ool: oilObjects) {

			/* COMMON VARIABLES */
			ISimpleGenRes os = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);

			String base = AbstractRtosWriter.getOsProperty(ool, Mico32Constants.SGRK__MICO32_BOARD_EEC_DEFINES__);

			if (base == null) {
				base = "";
			} else {
				base += "\n";
			}
			os.setProperty(Mico32Constants.SGRK__MICO32_BOARD_EEC_DEFINES__,
					base + definitions.toString());

			

			os.setProperty(Mico32Constants.SGRK__OS_PLATFORM_CFG__, platform_cfg);
			os.setProperty(Mico32Constants.SGRK__OS_PLATFORM_NAME__, platform_name);
			os.setProperty(Mico32Constants.SGRK__OS_PLATFORM_LIB_PATH_, platform_path);
		}
	}
	
	private int getValue(IOilObjectList ool, String key, int defaultValue) {
		Object o = AbstractRtosWriter.getOsObject(ool, key);
		if (o == null) {
			return defaultValue;
		}
		return ((Integer) o).intValue();
	}
	
	
	
	
	
	public static void addPlatformFile(IOilObjectList ool, IOilWriterBuffer answer) {
		StringBuffer buffer = answer.get("platform.mk");
		
		final String platform_name = checkOrDefault(getOsProperty(ool, Mico32Constants.SGRK__OS_PLATFORM_NAME__), "");
		final String platform_lib_path = checkOrDefault(getOsProperty(ool, Mico32Constants.SGRK__OS_PLATFORM_LIB_PATH_), "");
		final String platform_cfg = checkOrDefault(getOsProperty(ool, Mico32Constants.SGRK__OS_PLATFORM_CFG__), "");
		
		final ICommentWriter commentWriter = SectionWriter.getCommentWriter(ool, FileTypes.MAKEFILE);
		// Dynamic part
		buffer.append("# Platform-specific settings\n"+
				"#\n"+
				"\n"+
				CommonUtils.addMakefileDefinesInclude() +
				commentWriter.writerBanner("Variable part, automatically generated from 'conf.oil'")+
				"PLATFORM_NAME=" + platform_name + "\n"+
				"$(eval $(call check_and_set_mico32_platform_path,PLATFORM_LIB_PATH," + platform_lib_path + "))\n" +
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
