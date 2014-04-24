package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.eu.evidence.rtdruid.desk.Messages;
import com.eu.evidence.rtdruid.modules.oil.abstractions.IOilObjectList;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.vartree.IVarTree;

public class SectionWriterHalPicBoards implements IEEWriterKeywords {
	
	final protected static String PIC_30 = SectionWriterHalPic30.PIC_MCU;
	final protected static String PIC_32 = SectionWriterHalPic32.PIC_MCU;
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;
	/** All data */
	protected final IVarTree vt;
	/** Cpu type */
	protected final String cpu_type;
	
	

	public static class EE_FLEX_BOARD_MODEL {
		public final String name;
		public final String def;
		public final List<String> properties;
		public final String[] defines;
		EE_FLEX_BOARD_MODEL(String name, String def, String[] properties, String[] defines) {
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
	};
	
	
	public SectionWriterHalPicBoards(ErikaEnterpriseWriter parent, String cpu_type) {
		this.parent = parent;
		this.vt = parent == null ? null : parent.getVt();
		this.cpu_type = cpu_type;
	}
	
	
	/*
	 * Parse and write the BOARD Section
	 */
	public void checkBoard(ArrayList<String> ee_opts) {
		class BOARD_MODEL {
			public final String name;
			public final String def;
			public final String[] properties;
			public final String[] defines;
			public final HashMap<String, EE_FLEX_BOARD_MODEL> board_subtype;
			BOARD_MODEL(String name, String def, String[] properties, String[] defines) {
				this.name = name;
				this.def  = def;
				this.properties = properties;
				this.defines = defines;
				this.board_subtype = null;
			};
			BOARD_MODEL(String name, String def, String[] properties, String[] defines, HashMap<String, EE_FLEX_BOARD_MODEL> board_subtype) {
				this.name = name;
				this.def  = def;
				this.properties = properties;
				this.defines = defines;
				this.board_subtype = board_subtype;
			};
		}
		final HashMap<String, BOARD_MODEL> STANDARD_BOARD_PROPERTIES = new HashMap<String, BOARD_MODEL>();
		/* Add standard MCU and theris properties */ 
		STANDARD_BOARD_PROPERTIES.put("NO_BOARD", new BOARD_MODEL(
				"NO_BOARD", // name
				null,
				new String[0],
				new String[0]));

		
		if (PIC_30.equals(cpu_type)) {
			final HashMap<String, EE_FLEX_BOARD_MODEL> flex_subtype = new HashMap<String, EE_FLEX_BOARD_MODEL>();
			/* Add standard MCU and theris properties */ 
			flex_subtype.put("STANDARD", new EE_FLEX_BOARD_MODEL(
					"", // name
					null,
					new String[] {"LEDS", "LCD" /*, ALL */ },
					new String[] {"__USE_LEDS__", "__USE_LCD__"}));

			flex_subtype.put("DEMO", new EE_FLEX_BOARD_MODEL(
					"DEMO", // name
					"__USE_DEMOBOARD__",
					new String[] {
							"ACCELEROMETER",
							"ADC_IN",
							"BUTTONS",
							"BUZZER",
							"DAC",
							"ENCODER",
							"IR",
							"LCD",
							"LEDS",
							"PWM_OUT",
							"PWM_MOTOR",
							"SENSORS",
							"TRIMMER",
							"USB",
							"ZIGBEE",
							//"ALL"
							},
					new String[] {"__USE_ACCELEROMETER__",
							"__USE_ADC__",
							"__USE_BUTTONS__",
							"__USE_BUZZER__",
							"__USE_DAC__",
							"__USE_ENCODER__",
							"__USE_IR__",
							"__USE_LCD__",
							"__USE_LEDS__",
							"__USE_PWM__",
							"__USE_PWM_MOTOR__",
							"__USE_ANALOG_SENSORS__",
							"__USE_TRIMMER__",
							"__USE_USB__",
							"__USE_ZIGBEE__"}));
			
			flex_subtype.put("MULTI", new EE_FLEX_BOARD_MODEL(
					"MULTI", // name
					"__USE_MULTIBOARD__",
					new String[] {
							"ETHERNET",
							"EIB"
							//"ALL"
							},
					new String[] {
							"__USE_ETHERNET__",
							"__USE_EIB__"
					}));
			
			final String FLEX_NAME = "EE_FLEX";
			STANDARD_BOARD_PROPERTIES.put(FLEX_NAME, new BOARD_MODEL(
					FLEX_NAME, // name
					"__EE_FLEX__",
					new String[] {"USELEDS", "USELCD"},
					new String[] {"__USE_LEDS__", "__USE_LCD__"},
					flex_subtype
			));
		}
		
		if (PIC_30.equals(cpu_type)) {
			final HashMap<String, EE_FLEX_BOARD_MODEL> mini_flex_subtype = new HashMap<String, EE_FLEX_BOARD_MODEL>();
			/* Add standard MCU and theris properties */ 
			mini_flex_subtype.put("DEMO", new EE_FLEX_BOARD_MODEL(
					"DEMO", // name
					"__USE_DEMOBOARD__",
					new String[] {
							"BUZZER",
							"ACCELEROMETER",
							"LIGHT",
							"RTC"
							},
					new String[] {"__USE_BUZZER__",
							"__USE_ANALOG_IN__ __USE_ACCELEROMETER__",
							"__USE_ANALOG_IN__ __USE_LIGHT__",
							"__USE_RTC__"}));
			

			STANDARD_BOARD_PROPERTIES.put("EE_MINIFLEX", new BOARD_MODEL(
					"EE_MINIFLEX", // name
					"__EE_MINIFLEX__",
					new String[] {"USELEDS", "USEE2PROM", "USEBATTERYMONITOR", "USETEMPERATURE", "USEALL"},
					new String[] {
							"__USE_LEDS__",
							"__USE_E2PROM__",
							"__USE_ANALOG_IN__ __USE_BATTERY_MONITOR__",
							"__USE_ANALOG_IN__ __USE_TEMPERATURE__",
							"__USE_LEDS__ __USE_E2PROM__ __USE_ANALOG_IN__ __USE_BATTERY_MONITOR__ __USE_TEMPERATURE__"},
					mini_flex_subtype
			));
		}
		
		
		STANDARD_BOARD_PROPERTIES.put("MICROCHIP_EXPLORER16", new BOARD_MODEL(
				"MICROCHIP_EXPLORER16", // name
				"__MICROCHIP_EXPLORER16__",
				new String[] {"USELEDS", "USEBUTTONS", "USELCD", "USELEDD10", "USEANALOG"},
				new String[] {"__USE_LEDS__", "__USE_BUTTONS__", "__USE_LCD__", "__USE_LED_D10__", "__USE_ANALOG__"}));
		
		if (PIC_30.equals(cpu_type)) {
			STANDARD_BOARD_PROPERTIES.put("MICROCHIP_DSPICDEM11PLUS", new BOARD_MODEL(
					"MICROCHIP_DSPICDEM11PLUS", // name
					"__MICROCHIP_DSPICDEM11PLUS__",
					new String[] {"USELEDS", "USEBUTTONS", "USELCD", "USEANALOG", "USEAUDIO"},
					new String[] {"__USE_LEDS__", "__USE_BUTTONS__", "__USE_LCD__", "__USE_ANALOG__", "__USE_AUDIO__"}));
			

			STANDARD_BOARD_PROPERTIES.put("EE_EASYLAB", new BOARD_MODEL(
					"EE_EASYLAB", // name
					"EE_EASYLAB",
					new String[] {"USETIMER", "USEUART", "USELEDS", "USEDIO", "USEBUZZER", "USEADC", "USEPWM"},
					new String[] {"USE_TIMER", "USE_UART", "USE_LEDS", "USE_DIO", "USE_TIMER USE_BUZZER", "USE_ADC", "USE_PWM"}));
		}
		
		if (PIC_32.equals(cpu_type)) {
			STANDARD_BOARD_PROPERTIES.put("MICROCHIP_ESK", new BOARD_MODEL(
					"MICROCHIP_ESK", // name
					"__MICROCHIP_ESK__",
					new String[] {"USELEDS", "USEBUTTONS"},
					new String[] {"__USE_LEDS__", "__USE_BUTTONS__"}));
		}
		
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		
		for (int currentRtosId = 0; currentRtosId < oilObjects.length; currentRtosId ++) { 
			
			/***********************************************************************
			 * get values and store as EE_OPT
			 **********************************************************************/

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
				BOARD_MODEL board_properties = STANDARD_BOARD_PROPERTIES.get(board_type);
				if (board_properties != null) {
					if (board_properties.def!= null && !ee_opts.contains(board_properties.def)) {
						ee_opts.add(board_properties.def);
					}
					String currentMcuPrefix = childPaths.get(index) + PARAMETER_LIST;
	
					if (board_properties.board_subtype != null) {
						checkEE_FlexBoard(ee_opts, currentMcuPrefix, board_properties.board_subtype);
						
					}
					for (int i=0; i<board_properties.properties.length; i++) {
						String tmp = board_properties.properties[i];
						
						String value_type = CommonUtils.getFirstChildEnumType(vt, currentMcuPrefix+tmp, null);
						if ("TRUE".equals(value_type)) {
							for (String s: board_properties.defines[i].split(" ")) {
								 if (!ee_opts.contains(s)) {
									ee_opts.add(s);
								}
							}
						}
					}
					
					break;
				}
			}
		}
	}

	/*
	 * Parse and write the BOARD Section
	 */
	private void checkEE_FlexBoard(ArrayList<String> ee_opts, String currentMcuPrefix, HashMap<String, EE_FLEX_BOARD_MODEL> board_subtype) {
		{
			/***********************************************************************
			 * get values and store as EE_OPT
			 **********************************************************************/

			// prepare the path :
			// ... the prefix ...
			currentMcuPrefix = currentMcuPrefix + "TYPE";
			
			// ... get the node identifier
			String[] boardtype_path = new String[1];
			String boardtype_type = CommonUtils.getFirstChildEnumType(vt, currentMcuPrefix, boardtype_path);
			
				/* STANDARD MCU */
			EE_FLEX_BOARD_MODEL board_properties = board_subtype.get(boardtype_type);
			if (board_properties != null) {
				currentMcuPrefix += VARIANT_ELIST + boardtype_path[0] + PARAMETER_LIST+ "OPTIONS";

				if (board_properties.def!= null && !ee_opts.contains(board_properties.def)) {
					ee_opts.add(board_properties.def);
				}

				ArrayList<String> board_options = CommonUtils.getAllChildrenEnumType(vt, currentMcuPrefix, null);

				for (int i=0; i<board_options.size(); i++) {
					String opt = (String) board_options.get(i);
					
					int index = board_properties.searchProp(opt);
					if ("ALL".equals(opt)) {

						for (int j=0; j<board_properties.defines.length; j++) {
							String[] splitted = board_properties.defines[j].split(" ");
							for (String t : splitted) {
								if (!ee_opts.contains(t)) {
									ee_opts.add(t);
								}
							}
						}
						break; // already added every options

					} else if (index == -1) {
						Messages.sendError("Option not valid for selected flex board : " + opt, null, "board_option_1", null);
						continue;
					} else {
						
						String[] splitted = board_properties.defines[index].split(" ");
						for (String t : splitted) {
							if (!ee_opts.contains(t)) {
								ee_opts.add(t);
							}
						}
						
					}
				}
			} else {
				Messages.sendWarning("Board not found: " + boardtype_type, null, "pqoiwenaklsndf", null);
			}

		}
	}

	
}
