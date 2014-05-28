/*
 * Created on 5-apr-2006
 *
 * $Id: SectionWriterHalMico32.java,v 1.17 2008/02/05 10:15:18 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

import static com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise.ErikaEnterpriseWriter.checkOrDefault;
import static com.eu.evidence.rtdruid.modules.oil.codewriter.common.AbstractRtosWriter.getOsProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

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
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.SectionWriterIsr;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStackData;
import com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw.EEStacks;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants.IEEWriterKeywords;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractKeywordsExtentions;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IExtractObjectsExtentions;
import com.eu.evidence.rtdruid.vartree.ITreeInterface;
import com.eu.evidence.rtdruid.vartree.IVarTree;
import com.eu.evidence.rtdruid.vartree.IVariable;

/**
 * This writer build files for a DS PIC CPU - Board
 * 
 * @author Nicola Serreli
 */
public class SectionWriterHalAvr8 extends SectionWriter 
	implements IEEWriterKeywords,
			IExtractObjectsExtentions,
			IExtractKeywordsExtentions {
	
	final String indent1 = IWritersKeywords.INDENT;
	final String indent2 = indent1 + IWritersKeywords.INDENT;

	
	static class EEEntry {
		final String path;
		final String defaultValue;
		List<String> eeopt = new ArrayList<String>();
		
		String requiredEEopt = null;
		String requiredEEoptMsg = null;
		
		protected Map<String, String> values = new HashMap<String, String>(); // key -> eeopt
		public EEEntry(String path, String defaultValue) {
			this.path = path;
			this.defaultValue = defaultValue;
		}
		EEEntry add(String key, String eeopt) {
			this.values.put(key, eeopt);
			return this;
		}
		EEEntry addEnabled(String eeopt) {
			this.eeopt.add(eeopt);
			return this;
		}
		EEEntry addRequired(String eeopt, String msg) {
			this.requiredEEopt = eeopt;
			this.requiredEEoptMsg = msg;
			return this;
		}
		
		void check(IVarTree vt, String basePath, ErikaEnterpriseWriter.EEProperties checkProps, LinkedHashSet<String> tmp_common_eeopts) throws OilCodeWriterException {
			
			String prefix = basePath + PARAMETER_LIST + this.path;
			
			String type = CommonUtils.getFirstChildEnumType(vt, prefix, null);
			if (type == null) type = this.defaultValue;
			
			if (this.values.containsKey(type)) {
				
				String val = this.values.get(type);
				if (val != null) {
					checkProps.setOilProperty(this.path, type);

					if (this.requiredEEopt != null && !tmp_common_eeopts.contains(this.requiredEEopt)) {
						Messages.sendWarningNl(this.requiredEEoptMsg);
					} else {
						String[] val_splitted = val.split(" ");
						for (String s : val_splitted) {
							if (!s.trim().isEmpty()) {
								tmp_common_eeopts.add(s);
							}
						}
						
						for (String s : this.eeopt) {
							tmp_common_eeopts.add(s);
						}

					}
				}
			}
		}
	}
	
	static class EEEnum {
		final String eeopt;
		List<EEEntry> entries = new ArrayList<EEEntry>();
		EEEnum (String eeopt) {
			this.eeopt = eeopt;
		}
	}
	
	static class EEEnumGroup {
		final String path;
		Map<String, EEEnum> groups = new HashMap<String, EEEnum>();		
		public EEEnumGroup(String path) {
			this.path = path;
		}
	}
	
	static class EEBoard {
		String eeopt;
		List<EEEntry> model = new ArrayList<EEEntry>();
		List<EEEntry> entries = new ArrayList<EEEntry>();
		List<EEEnumGroup> drivers = new ArrayList<EEEnumGroup>();
	}
	
	static Map<String, EEBoard> boards;
	static Map<String, EEBoard> mcus;
	
	static {
		mcus = new HashMap<String, EEBoard>();
		boards = new HashMap<String, EEBoard>();
		
		{
			EEBoard xmega = new EEBoard();
			mcus.put("XMEGA", xmega);

			xmega.eeopt = "__ATXMEGA__";
			xmega.model.add( new EEEntry("MODEL", "XMEGA_16d4")
								.add("XMEGA_14d4",   "atxmega14d4")
								.add("XMEGA_pardon", "atxmegapardon")
								.add("XMEGA_16d4",   "atxmega16d4")
								.add("XMEGA_32d4",   "atxmega32d4")
								.add("CUSTOM",  ""));
			xmega.entries.add( new EEEntry("AVR_PGMSPACE", null).add("TRUE", "__AVR_PGMSPACE__") );
			xmega.entries.add( new EEEntry("USE_TC_HW",    null).add("TRUE", "__USE_TC_HW__") );

			{ // MCU
				EEEnumGroup mcu = new EEEnumGroup("ENABLE_MCU_DRIVER");
				xmega.drivers.add(mcu);
				
				EEEnum trueEnum = new EEEnum(null);
				mcu.groups.put("TRUE", trueEnum);
				
				trueEnum.entries.add( new EEEntry("MCU_STATUS",              null).add("EXTENDED", "__MCU_EXTENDED_STATUS__") );
				trueEnum.entries.add( new EEEntry("MCU_DEINIT_API",          null).add("TRUE", "__MCU_DEINIT_API__") );
				trueEnum.entries.add( new EEEntry("MCU_INITCLOCK_API",       null).add("TRUE", "__MCU_INITCLOCK_API__") );
				trueEnum.entries.add( new EEEntry("MCU_DEINITCLOCK_API",     null).add("TRUE", "__MCU_DEINITCLOCK_API__") );
				trueEnum.entries.add( new EEEntry("MCU_GETCLOCKSTATUS_API",  null).add("TRUE", "__MCU_GETCLOCKSTATUS_API__") );
				trueEnum.entries.add( new EEEntry("MCU_DISTRIBUTECLOCK_API", null).add("TRUE", "__MCU_DISTRIBUTECLOCK_API__") );
				trueEnum.entries.add( new EEEntry("MCU_SETMODE_API",         null).add("TRUE", "__MCU_SETMODE_API__") );
				trueEnum.entries.add( new EEEntry("MCU_GETRESETREASON_API",  null).add("TRUE", "__MCU_GETRESETREASON_API__") );
				trueEnum.entries.add( new EEEntry("MCU_PERFORMRESET_API",    null).add("TRUE", "__MCU_PERFORMRESET_API__") );
			}
			
			{ // MCU POWER REDUCTION
				EEEnumGroup mcu = new EEEnumGroup("ENABLE_MCU_POWER_REDUCTION");
				xmega.drivers.add(mcu);
				
				EEEnum trueEnum = new EEEnum("__MCU_POWER_REDUCTION__");
				mcu.groups.put("TRUE", trueEnum);
				
				trueEnum.entries.add( new EEEntry("PULL_UP",  null).add("TRUE", "__MCU_PR_PULL_UP__") );
				trueEnum.entries.add( new EEEntry("PORT_OUT", null).add("TRUE", "__MCU_PR_PORT_OUT__") );
				trueEnum.entries.add( new EEEntry("JTAG",     null).add("TRUE", "__MCU_PR_JTAG__") );
			}
			
			{ // E2P
				EEEnumGroup e2p = new EEEnumGroup("ENABLE_E2P_DRIVER");
				xmega.drivers.add(e2p);
				
				EEEnum trueEnum = new EEEnum("__E2P_DRIVER__");
				e2p.groups.put("TRUE", trueEnum);
				
				trueEnum.entries.add( new EEEntry("E2P_STATUS",        null).add("EXTENDED", "__E2P_EXTENDED_STATUS__") );
				trueEnum.entries.add( new EEEntry("E2P_INTERRUPT",     null).add("TRUE", "__E2P_INTERRUPT__") );
				trueEnum.entries.add( new EEEntry("E2P_SYNCHRONOUS",   null).add("TRUE", "__E2P_SYNCHRONOUS__") );
				trueEnum.entries.add( new EEEntry("E2P_GETSTATUS_API", null).add("TRUE", "__E2P_GETSTATUS_API__") );
				trueEnum.entries.add( new EEEntry("E2P_DEINIT_API",    null).add("TRUE", "__E2P_DEINIT_API__") );
				trueEnum.entries.add( new EEEntry("E2P_READ_API",      null).add("TRUE", "__E2P_READ_API__") );
				trueEnum.entries.add( new EEEntry("E2P_WRITE_API",     null).add("TRUE", "__E2P_WRITE_API__") );
				trueEnum.entries.add( new EEEntry("E2P_ERASE_API",     null).add("TRUE", "__E2P_ERASE_API__") );
				trueEnum.entries.add( new EEEntry("E2P_COMPARE_API",   null).add("TRUE", "__E2P_COMPARE_API__") );
				trueEnum.entries.add( new EEEntry("E2P_CANCEL_API",    null).add("TRUE", "__E2P_CANCEL_API__") );
			}

			{ // GPIO
				EEEnumGroup gpio = new EEEnumGroup("ENABLE_GPIO_DRIVER");
				xmega.drivers.add(gpio);
				
				EEEnum trueEnum = new EEEnum("__GPIO_DRIVER__");
				gpio.groups.put("TRUE", trueEnum);
				
				trueEnum.entries.add( new EEEntry("GPIO_STATUS",           null).add("EXTENDED", "__GPIO_EXTENDED_STATUS__") );
				trueEnum.entries.add( new EEEntry("GPIO_DEINIT_API",       null).add("TRUE", "__GPIO_DEINIT_API__") );
				trueEnum.entries.add( new EEEntry("GPIO_READCHANNEL_API",  null).add("TRUE", "__GPIO_READCHANNEL_API__") );
				trueEnum.entries.add( new EEEntry("GPIO_READCHANNEL_NTS",  null).add("TRUE", "__GPIO_READCHANNEL_NTS__") );
				trueEnum.entries.add( new EEEntry("GPIO_WRITECHANNEL_API", null).add("TRUE", "__GPIO_WRITECHANNEL_API__") );
				trueEnum.entries.add( new EEEntry("GPIO_WRITECHANNEL_NTS", null).add("TRUE", "__GPIO_WRITECHANNEL_NTS__") );
				trueEnum.entries.add( new EEEntry("GPIO_FLIPCHANNEL_API",  null).add("TRUE", "__GPIO_FLIPCHANNEL_API__") );
				trueEnum.entries.add( new EEEntry("GPIO_FLIPCHANNEL_NTS",  null).add("TRUE", "__GPIO_FLIPCHANNEL_NTS__") );
				trueEnum.entries.add( new EEEntry("GPIO_ENABLENOTIF_API",  null).add("TRUE", "__GPIO_ENABLENOTIF_API__") );
				trueEnum.entries.add( new EEEntry("GPIO_DISABLENOTIF_API", null).add("TRUE", "__GPIO_DISABLENOTIF_API__") );
			}

			{ // GPT
				EEEnumGroup gpt = new EEEnumGroup("ENABLE_GPT_DRIVER");
				xmega.drivers.add(gpt);
				
				EEEnum trueEnum = new EEEnum("__GPT_DRIVER__");
				gpt.groups.put("TRUE", trueEnum);
				
				trueEnum.entries.add( new EEEntry("GPT_STATUS",               null).add("EXTENDED", "__GPT_EXTENDED_STATUS__") );
				trueEnum.entries.add( new EEEntry("GPT_ONESHOT",              null).add("TRUE", "__GPT_ONESHOT__") );
				trueEnum.entries.add( new EEEntry("GPT_GETSTATUS_API",        null).add("TRUE", "__GPT_GETSTATUS_API__") );
				trueEnum.entries.add( new EEEntry("GPT_DEINIT_API",           null).add("TRUE", "__GPT_DEINIT_API__") );
				trueEnum.entries.add( new EEEntry("GPT_ENABLENOTIF_API",      null).add("TRUE", "__GPT_ENABLENOTIF_API__") );
				trueEnum.entries.add( new EEEntry("GPT_DISABLENOTIF_API",     null).add("TRUE", "__GPT_DISABLENOTIF_API__") );
				trueEnum.entries.add( new EEEntry("GPT_STOPTIMER_API",        null).add("TRUE", "__GPT_STOPTIMER_API__") );
				trueEnum.entries.add( new EEEntry("GPT_GETTIMEELAPSED_API",   null).add("TRUE", "__GPT_GETTIMEELAPSED_API__") );
				trueEnum.entries.add( new EEEntry("GPT_GETTIMEREMAINING_API", null).add("TRUE", "__GPT_GETTIMEREMAINING_API__") );


				trueEnum.entries.add( new EEEntry("GPT_CHANNEL_C_0", null)
								.add("DIV1",    "__GPT_CHANNEL_C_0_DIV_1__")
								.add("DIV2",    "__GPT_CHANNEL_C_0_DIV_2__")
								.add("DIV4",    "__GPT_CHANNEL_C_0_DIV_4__")
								.add("DIV8",    "__GPT_CHANNEL_C_0_DIV_8__")
								.add("DIV64",   "__GPT_CHANNEL_C_0_DIV_64__")
								.add("DIV256",  "__GPT_CHANNEL_C_0_DIV_256__")
								.add("DIV1024", "__GPT_CHANNEL_C_0_DIV_1024__")
								.addEnabled("__GPT_CHANNEL_C_0__")
				);
				trueEnum.entries.add( new EEEntry("GPT_CHANNEL_D_0", null)
								.add("DIV1",    "__GPT_CHANNEL_D_0_DIV_1__")
								.add("DIV2",    "__GPT_CHANNEL_D_0_DIV_2__")
								.add("DIV4",    "__GPT_CHANNEL_D_0_DIV_4__")
								.add("DIV8",    "__GPT_CHANNEL_D_0_DIV_8__")
								.add("DIV64",   "__GPT_CHANNEL_D_0_DIV_64__")
								.add("DIV256",  "__GPT_CHANNEL_D_0_DIV_256__")
								.add("DIV1024", "__GPT_CHANNEL_D_0_DIV_1024__")
								.addEnabled("__GPT_CHANNEL_D_0__")
				);
				trueEnum.entries.add( new EEEntry("GPT_CHANNEL_E_0", null)
								.add("DIV1",    "__GPT_CHANNEL_E_0_DIV_1__")
								.add("DIV2",    "__GPT_CHANNEL_E_0_DIV_2__")
								.add("DIV4",    "__GPT_CHANNEL_E_0_DIV_4__")
								.add("DIV8",    "__GPT_CHANNEL_E_0_DIV_8__")
								.add("DIV64",   "__GPT_CHANNEL_E_0_DIV_64__")
								.add("DIV256",  "__GPT_CHANNEL_E_0_DIV_256__")
								.add("DIV1024", "__GPT_CHANNEL_E_0_DIV_1024__")
								.addEnabled("__GPT_CHANNEL_E_0__")
				);
				trueEnum.entries.add( new EEEntry("GPT_CHANNEL_F_0", null)
								.add("DIV1",    "__GPT_CHANNEL_F_0_DIV_1__")
								.add("DIV2",    "__GPT_CHANNEL_F_0_DIV_2__")
								.add("DIV4",    "__GPT_CHANNEL_F_0_DIV_4__")
								.add("DIV8",    "__GPT_CHANNEL_F_0_DIV_8__")
								.add("DIV64",   "__GPT_CHANNEL_F_0_DIV_64__")
								.add("DIV256",  "__GPT_CHANNEL_F_0_DIV_256__")
								.add("DIV1024", "__GPT_CHANNEL_F_0_DIV_1024__")
								.addEnabled("__GPT_CHANNEL_F_0__")
				);

				trueEnum.entries.add( new EEEntry("GPT_CHANNEL_C_1", null)
								.add("DIV1",    "__GPT_CHANNEL_C_1_DIV_1__")
								.add("DIV2",    "__GPT_CHANNEL_C_1_DIV_2__")
								.add("DIV4",    "__GPT_CHANNEL_C_1_DIV_4__")
								.add("DIV8",    "__GPT_CHANNEL_C_1_DIV_8__")
								.add("DIV64",   "__GPT_CHANNEL_C_1_DIV_64__")
								.add("DIV256",  "__GPT_CHANNEL_C_1_DIV_256__")
								.add("DIV1024", "__GPT_CHANNEL_C_1_DIV_1024__")
								.addEnabled("__GPT_CHANNEL_C_1__")
								.addRequired("__USE_TC_HW__", "Requires USE_TC_HW = TRUE.")
				);
				trueEnum.entries.add( new EEEntry("GPT_CHANNEL_D_1", null)
								.add("DIV1",    "__GPT_CHANNEL_D_1_DIV_1__")
								.add("DIV2",    "__GPT_CHANNEL_D_1_DIV_2__")
								.add("DIV4",    "__GPT_CHANNEL_D_1_DIV_4__")
								.add("DIV8",    "__GPT_CHANNEL_D_1_DIV_8__")
								.add("DIV64",   "__GPT_CHANNEL_D_1_DIV_64__")
								.add("DIV256",  "__GPT_CHANNEL_D_1_DIV_256__")
								.add("DIV1024", "__GPT_CHANNEL_D_1_DIV_1024__")
								.addEnabled("__GPT_CHANNEL_D_1__")
								.addRequired("__USE_TC_HW__", "Requires USE_TC_HW = TRUE.")
				);
				trueEnum.entries.add( new EEEntry("GPT_CHANNEL_E_1", null)
								.add("DIV1",    "__GPT_CHANNEL_E_1_DIV_1__")
								.add("DIV2",    "__GPT_CHANNEL_E_1_DIV_2__")
								.add("DIV4",    "__GPT_CHANNEL_E_1_DIV_4__")
								.add("DIV8",    "__GPT_CHANNEL_E_1_DIV_8__")
								.add("DIV64",   "__GPT_CHANNEL_E_1_DIV_64__")
								.add("DIV256",  "__GPT_CHANNEL_E_1_DIV_256__")
								.add("DIV1024", "__GPT_CHANNEL_E_1_DIV_1024__")
								.addEnabled("__GPT_CHANNEL_E_1__")
								.addRequired("__USE_TC_HW__", "Requires USE_TC_HW = TRUE.")
				);
				trueEnum.entries.add( new EEEntry("GPT_CHANNEL_F_1", null)
								.add("DIV1",    "__GPT_CHANNEL_F_1_DIV_1__")
								.add("DIV2",    "__GPT_CHANNEL_F_1_DIV_2__")
								.add("DIV4",    "__GPT_CHANNEL_F_1_DIV_4__")
								.add("DIV8",    "__GPT_CHANNEL_F_1_DIV_8__")
								.add("DIV64",   "__GPT_CHANNEL_F_1_DIV_64__")
								.add("DIV256",  "__GPT_CHANNEL_F_1_DIV_256__")
								.add("DIV1024", "__GPT_CHANNEL_F_1_DIV_1024__")
								.addEnabled("__GPT_CHANNEL_F_1__")
								.addRequired("__USE_TC_HW__", "Requires USE_TC_HW = TRUE.")
				);
			}

			{ // PWM
				EEEnumGroup pwm = new EEEnumGroup("ENABLE_PWM_DRIVER");
				xmega.drivers.add(pwm);
				
				EEEnum trueEnum = new EEEnum("__PWM_DRIVER__");
				pwm.groups.put("TRUE", trueEnum);
				
				trueEnum.entries.add( new EEEntry("PWM_STATUS",              null).add("EXTENDED", "__PWM_EXTENDED_STATUS__") );
				trueEnum.entries.add( new EEEntry("PWM_GETSTATUS_API",       null).add("TRUE", "__PWM_GETSTATUS_API__") );
				trueEnum.entries.add( new EEEntry("PWM_DEINIT_API",          null).add("TRUE", "__PWM_DEINIT_API__") );
				trueEnum.entries.add( new EEEntry("PWM_ENABLENOTIF_API",     null).add("TRUE", "__PWM_ENABLENOTIF_API__") );
				trueEnum.entries.add( new EEEntry("PWM_DISABLENOTIF_API",    null).add("TRUE", "__PWM_DISABLENOTIF_API__") );
				trueEnum.entries.add( new EEEntry("PWM_SETDUTYCYCLE_API",    null).add("TRUE", "__PWM_SETDUTYCYCLE_API__") );
				trueEnum.entries.add( new EEEntry("PWM_GETOUTPUTSTATE_API",  null).add("TRUE", "__PWM_GETOUTPUTSTATE_API__") );
				trueEnum.entries.add( new EEEntry("PWM_SETOUTPUTTOIDLE_API", null).add("TRUE", "__PWM_SETOUTPUTTOIDLE_API__") );

				//  ----- 0 --------
				trueEnum.entries.add( new EEEntry("PWM_CHANNEL_C_0", null)
								.add("DIV1",    "__PWM_CHANNEL_C_0_DIV_1__")
								.add("DIV2",    "__PWM_CHANNEL_C_0_DIV_2__")
								.add("DIV4",    "__PWM_CHANNEL_C_0_DIV_4__")
								.add("DIV8",    "__PWM_CHANNEL_C_0_DIV_8__")
								.add("DIV64",   "__PWM_CHANNEL_C_0_DIV_64__")
								.add("DIV256",  "__PWM_CHANNEL_C_0_DIV_256__")
								.add("DIV1024", "__PWM_CHANNEL_C_0_DIV_1024__")
								.addEnabled("__PWM_CHANNEL_C_0__")
				);
				trueEnum.entries.add( new EEEntry("PWM_CHANNEL_D_0", null)
								.add("DIV1",    "__PWM_CHANNEL_D_0_DIV_1__")
								.add("DIV2",    "__PWM_CHANNEL_D_0_DIV_2__")
								.add("DIV4",    "__PWM_CHANNEL_D_0_DIV_4__")
								.add("DIV8",    "__PWM_CHANNEL_D_0_DIV_8__")
								.add("DIV64",   "__PWM_CHANNEL_D_0_DIV_64__")
								.add("DIV256",  "__PWM_CHANNEL_D_0_DIV_256__")
								.add("DIV1024", "__PWM_CHANNEL_D_0_DIV_1024__")
								.addEnabled("__PWM_CHANNEL_D_0__")
				);
				trueEnum.entries.add( new EEEntry("PWM_CHANNEL_E_0", null)
								.add("DIV1",    "__PWM_CHANNEL_E_0_DIV_1__")
								.add("DIV2",    "__PWM_CHANNEL_E_0_DIV_2__")
								.add("DIV4",    "__PWM_CHANNEL_E_0_DIV_4__")
								.add("DIV8",    "__PWM_CHANNEL_E_0_DIV_8__")
								.add("DIV64",   "__PWM_CHANNEL_E_0_DIV_64__")
								.add("DIV256",  "__PWM_CHANNEL_E_0_DIV_256__")
								.add("DIV1024", "__PWM_CHANNEL_E_0_DIV_1024__")
								.addEnabled("__PWM_CHANNEL_E_0__")
				);
				trueEnum.entries.add( new EEEntry("PWM_CHANNEL_F_0", null)
								.add("DIV1",    "__PWM_CHANNEL_F_0_DIV_1__")
								.add("DIV2",    "__PWM_CHANNEL_F_0_DIV_2__")
								.add("DIV4",    "__PWM_CHANNEL_F_0_DIV_4__")
								.add("DIV8",    "__PWM_CHANNEL_F_0_DIV_8__")
								.add("DIV64",   "__PWM_CHANNEL_F_0_DIV_64__")
								.add("DIV256",  "__PWM_CHANNEL_F_0_DIV_256__")
								.add("DIV1024", "__PWM_CHANNEL_F_0_DIV_1024__")
								.addEnabled("__PWM_CHANNEL_F_0__")
				);

				//  ----- 1 --------
				trueEnum.entries.add( new EEEntry("PWM_CHANNEL_C_1", null)
								.add("DIV1",    "__PWM_CHANNEL_C_1_DIV_1__")
								.add("DIV2",    "__PWM_CHANNEL_C_1_DIV_2__")
								.add("DIV4",    "__PWM_CHANNEL_C_1_DIV_4__")
								.add("DIV8",    "__PWM_CHANNEL_C_1_DIV_8__")
								.add("DIV64",   "__PWM_CHANNEL_C_1_DIV_64__")
								.add("DIV256",  "__PWM_CHANNEL_C_1_DIV_256__")
								.add("DIV1024", "__PWM_CHANNEL_C_1_DIV_1024__")
								.addEnabled("__PWM_CHANNEL_C_1__")
								.addRequired("__USE_TC_HW__", "Requires USE_TC_HW = TRUE.")
				);
				trueEnum.entries.add( new EEEntry("PWM_CHANNEL_D_1", null)
								.add("DIV1",    "__PWM_CHANNEL_D_1_DIV_1__")
								.add("DIV2",    "__PWM_CHANNEL_D_1_DIV_2__")
								.add("DIV4",    "__PWM_CHANNEL_D_1_DIV_4__")
								.add("DIV8",    "__PWM_CHANNEL_D_1_DIV_8__")
								.add("DIV64",   "__PWM_CHANNEL_D_1_DIV_64__")
								.add("DIV256",  "__PWM_CHANNEL_D_1_DIV_256__")
								.add("DIV1024", "__PWM_CHANNEL_D_1_DIV_1024__")
								.addEnabled("__PWM_CHANNEL_D_1__")
								.addRequired("__USE_TC_HW__", "Requires USE_TC_HW = TRUE.")
				);
				trueEnum.entries.add( new EEEntry("PWM_CHANNEL_E_1", null)
								.add("DIV1",    "__PWM_CHANNEL_E_1_DIV_1__")
								.add("DIV2",    "__PWM_CHANNEL_E_1_DIV_2__")
								.add("DIV4",    "__PWM_CHANNEL_E_1_DIV_4__")
								.add("DIV8",    "__PWM_CHANNEL_E_1_DIV_8__")
								.add("DIV64",   "__PWM_CHANNEL_E_1_DIV_64__")
								.add("DIV256",  "__PWM_CHANNEL_E_1_DIV_256__")
								.add("DIV1024", "__PWM_CHANNEL_E_1_DIV_1024__")
								.addEnabled("__PWM_CHANNEL_E_1__")
								.addRequired("__USE_TC_HW__", "Requires USE_TC_HW = TRUE.")
				);
				trueEnum.entries.add( new EEEntry("PWM_CHANNEL_F_1", null)
								.add("DIV1",    "__PWM_CHANNEL_F_1_DIV_1__")
								.add("DIV2",    "__PWM_CHANNEL_F_1_DIV_2__")
								.add("DIV4",    "__PWM_CHANNEL_F_1_DIV_4__")
								.add("DIV8",    "__PWM_CHANNEL_F_1_DIV_8__")
								.add("DIV64",   "__PWM_CHANNEL_F_1_DIV_64__")
								.add("DIV256",  "__PWM_CHANNEL_F_1_DIV_256__")
								.add("DIV1024", "__PWM_CHANNEL_F_1_DIV_1024__")
								.addEnabled("__PWM_CHANNEL_F_1__")
								.addRequired("__USE_TC_HW__", "Requires USE_TC_HW = TRUE.")
				);

				//  ----- 0 --------			
				trueEnum.entries.add( new EEEntry("PWM_C_0_CC", null)
								.add("A",    "__PWM_C_0_CCA__")
								.add("B",    "__PWM_C_0_CCB__")
								.add("C",    "__PWM_C_0_CCC__")
								.add("D",    "__PWM_C_0_CCD__")
				);
				trueEnum.entries.add( new EEEntry("PWM_D_0_CC", null)
								.add("A",    "__PWM_D_0_CCA__")
								.add("B",    "__PWM_D_0_CCB__")
								.add("C",    "__PWM_D_0_CCC__")
								.add("D",    "__PWM_D_0_CCD__")
				);
				trueEnum.entries.add( new EEEntry("PWM_E_0_CC", null)
								.add("A",    "__PWM_E_0_CCA__")
								.add("B",    "__PWM_E_0_CCB__")
								.add("C",    "__PWM_E_0_CCC__")
								.add("D",    "__PWM_E_0_CCD__")
				);
				trueEnum.entries.add( new EEEntry("PWM_F_0_CC", null)
								.add("A",    "__PWM_F_0_CCA__")
								.add("B",    "__PWM_F_0_CCB__")
								.add("C",    "__PWM_F_0_CCC__")
								.add("D",    "__PWM_F_0_CCD__")
				);
				
				//  ----- 1 --------			
				trueEnum.entries.add( new EEEntry("PWM_C_1_CC", null)
								.add("A",    "__PWM_C_1_CCA__")
								.add("B",    "__PWM_C_1_CCB__")
								.addRequired("__USE_TC_HW__", "Requires USE_TC_HW = TRUE.")
				);
				trueEnum.entries.add( new EEEntry("PWM_D_1_CC", null)
								.add("A",    "__PWM_D_1_CCA__")
								.add("B",    "__PWM_D_1_CCB__")
								.addRequired("__USE_TC_HW__", "Requires USE_TC_HW = TRUE.")
				);
				trueEnum.entries.add( new EEEntry("PWM_E_1_CC", null)
								.add("A",    "__PWM_E_1_CCA__")
								.add("B",    "__PWM_E_1_CCB__")
								.addRequired("__USE_TC_HW__", "Requires USE_TC_HW = TRUE.")
				);
				trueEnum.entries.add( new EEEntry("PWM_F_1_CC", null)
								.add("A",    "__PWM_F_1_CCA__")
								.add("B",    "__PWM_F_1_CCB__")
								.addRequired("__USE_TC_HW__", "Requires USE_TC_HW = TRUE.")
				);

			}
			
			{ // RTC
				EEEnumGroup rtc = new EEEnumGroup("ENABLE_RTC_DRIVER");
				xmega.drivers.add(rtc);
				
				EEEnum trueEnum = new EEEnum("__RTC_DRIVER__");
				rtc.groups.put("TRUE", trueEnum);
				
				trueEnum.entries.add( new EEEntry("RTC_STATUS",           null).add("EXTENDED", "__RTC_EXTENDED_STATUS__") );
				trueEnum.entries.add( new EEEntry("RTC_GETSTATUS_API",    null).add("TRUE", "__RTC_GETSTATUS_API__") );
				trueEnum.entries.add( new EEEntry("RTC_DEINIT_API",       null).add("TRUE", "__RTC_DEINIT_API__") );
				trueEnum.entries.add( new EEEntry("RTC_ENABLENOTIF_API",  null).add("TRUE", "__RTC_ENABLENOTIF_API__") );
				trueEnum.entries.add( new EEEntry("RTC_DISABLENOTIF_API", null).add("TRUE", "__RTC_DISABLENOTIF_API__") );
				trueEnum.entries.add( new EEEntry("RTC_STOP_API",         null).add("TRUE", "__RTC_STOP_API__") );
				trueEnum.entries.add( new EEEntry("RTC_GETCOUNTER_API",   null).add("TRUE", "__RTC_GETCOUNTER_API__") );
				trueEnum.entries.add( new EEEntry("RTC_SETCOUNTER_API",   null).add("TRUE", "__RTC_SETCOUNTER_API__") );

				//  ----- 0 --------
				trueEnum.entries.add( new EEEntry("RTC_CHANNEL_0", null)
								.add("DIV1",    "__RTC_CHANNEL_0_DIV_1__")
								.add("DIV2",    "__RTC_CHANNEL_0_DIV_2__")
								.add("DIV4",    "__RTC_CHANNEL_0_DIV_4__")
								.add("DIV8",    "__RTC_CHANNEL_0_DIV_8__")
								.add("DIV64",   "__RTC_CHANNEL_0_DIV_64__")
								.add("DIV256",  "__RTC_CHANNEL_0_DIV_256__")
								.add("DIV1024", "__RTC_CHANNEL_0_DIV_1024__")
								.addEnabled("__RTC_CHANNEL_0__")
				);
			}
			
			{ // SCI
				EEEnumGroup sci = new EEEnumGroup("ENABLE_SCI_DRIVER");
				xmega.drivers.add(sci);
				
				EEEnum trueEnum = new EEEnum("__SCI_DRIVER__");
				sci.groups.put("TRUE", trueEnum);
				
				trueEnum.entries.add( new EEEntry("SCI_STATUS",           null).add("EXTENDED", "__SCI_EXTENDED_STATUS__") );
				trueEnum.entries.add( new EEEntry("SCI_BAUDRATE_TABLE",   null).add("TRUE", "__SCI_BAUDRATE_TABLE__") );
				trueEnum.entries.add( new EEEntry("SCI_GETSTATUS_API",    null).add("TRUE", "__SCI_GETSTATUS_API__") );
				trueEnum.entries.add( new EEEntry("SCI_DEINIT_API",       null).add("TRUE", "__SCI_DEINIT_API__") );
				trueEnum.entries.add( new EEEntry("SCI_WRITETXDATA_API",  null).add("TRUE", "__SCI_WRITETXDATA_API__") );
				trueEnum.entries.add( new EEEntry("SCI_WRITETXDATA__NTS", null).add("TRUE", "__SCI_WRITETXDATA__NTS__") );
				trueEnum.entries.add( new EEEntry("SCI_DISABLETX_API",    null).add("TRUE", "__SCI_DISABLETX_API__") );
				trueEnum.entries.add( new EEEntry("SCI_ENABLETX_API",     null).add("TRUE", "__SCI_ENABLETX_API__") );
				trueEnum.entries.add( new EEEntry("SCI_READRXDATA_API",   null).add("TRUE", "__SCI_READRXDATA_API__") );
				trueEnum.entries.add( new EEEntry("SCI_READRXDATA_NTS",   null).add("TRUE", "__SCI_READRXDATA_NTS__") );
				trueEnum.entries.add( new EEEntry("SCI_DISABLERX_API",    null).add("TRUE", "__SCI_DISABLERX_API__") );
				trueEnum.entries.add( new EEEntry("SCI_ENABLERX_API",     null).add("TRUE", "__SCI_ENABLERX_API__") );
				trueEnum.entries.add( new EEEntry("SCI_ENABLENOTIF_API",  null).add("TRUE", "__SCI_ENABLENOTIF_API__") );
				trueEnum.entries.add( new EEEntry("SCI_DISABLENOTIF_API", null).add("TRUE", "__SCI_DISABLENOTIF_API__") );
			}
		}
		
		{
			EEBoard mega = new EEBoard();
			mcus.put("MEGA", mega);

			mega.eeopt = "__ATMEGA__";
			mega.model.add( new EEEntry("MODEL", "MEGA_328p")
						.add("MEGA_128",   "atmega128")
						.add("MEGA_1281", "atmega1281")
						.add("MEGA_328",   "atmega328")
						.add("MEGA_328p",  "atmega328p")
						.add("CUSTOM",  ""));
			mega.entries.add( new EEEntry("USEIC",   null).add("TRUE", "__IC_USED__") );
			mega.entries.add( new EEEntry("USEUART", null).add("TRUE", "__USE_UART__") );
			mega.entries.add( new EEEntry("USESPI",  null).add("TRUE", "__USE_SPI__") );

			mega.entries.add( new EEEntry("TIMER0", null)
						.add("DIV1",    "__TIMER0_CLK_DIV1__")
						.add("DIV8",    "__TIMER0_CLK_DIV8__")
						.add("DIV32",   "__TIMER0_CLK_DIV32__")
						.add("DIV64",   "__TIMER0_CLK_DIV64__")
						.add("DIV256",  "__TIMER0_CLK_DIV256__")
						.add("DIV1024", "__TIMER0_CLK_DIV1024__")
						.addEnabled("__TIMER_USED__")
						.addEnabled("__TIMER_0_USED__")
			);
			mega.entries.add( new EEEntry("TIMER1", null)
						.add("DIV1",    "__TIMER1_CLK_DIV1__")
						.add("DIV8",    "__TIMER1_CLK_DIV8__")
						.add("DIV64",   "__TIMER1_CLK_DIV64__")
						.add("DIV256",  "__TIMER1_CLK_DIV256__")
						.add("DIV1024", "__TIMER1_CLK_DIV1024__")
						.addEnabled("__TIMER_USED__")
						.addEnabled("__TIMER_1_USED__")
			);
			mega.entries.add( new EEEntry("TIMER2", null)
						.add("DIV1",    "__TIMER2_CLK_DIV1__")
						.add("DIV8",    "__TIMER2_CLK_DIV8__")
						.add("DIV64",   "__TIMER2_CLK_DIV64__")
						.add("DIV256",  "__TIMER2_CLK_DIV256__")
						.add("DIV1024", "__TIMER2_CLK_DIV1024__")
						.addEnabled("__TIMER_USED__")
						.addEnabled("__TIMER_2_USED__")
			);
			mega.entries.add( new EEEntry("TIMER3", null)
						.add("DIV1",    "__TIMER3_CLK_DIV1__")
						.add("DIV8",    "__TIMER3_CLK_DIV8__")
						.add("DIV64",   "__TIMER3_CLK_DIV64__")
						.add("DIV256",  "__TIMER3_CLK_DIV256__")
						.add("DIV1024", "__TIMER3_CLK_DIV1024__")
						.addEnabled("__TIMER_USED__")
						.addEnabled("__TIMER_3_USED__")
			);

		}
		
		
		// ------------------
		
		{
			EEBoard board = new EEBoard();
			boards.put("XBOW_MIB5X0", board);

			board.eeopt = "__XBOW_MIB5X0__";
			board.entries.add( new EEEntry("USELEDS",   null).add("TRUE", "__LEDS_USED__") );
		}
		{
			EEBoard board = new EEBoard();
			boards.put("ATMEL_STK50X", board);

			board.eeopt = "__ATMEL_STK50X__";
			board.entries.add( new EEEntry("USELEDS",   null).add("TRUE", "__LEDS_USED__") );
			board.entries.add( new EEEntry("USEBUTTON", null).add("TRUE", "__BUTTON_USED__") );
		}		
		{
			EEBoard mega = new EEBoard();
			boards.put("ATMEL_STK600", mega);

			mega.eeopt = "__ATMEL_STK600__";
			mega.entries.add( new EEEntry("USELEDS",   null).add("TRUE", "__LED_DRIVER__") );

			mega.entries.add( new EEEntry("LEDPORT", null)
						.add("A",    "__LED_PORT_A__")
						.add("B",    "__LED_PORT_B__")
						.add("C",    "__LED_PORT_C__")
						.add("D",    "__LED_PORT_D__")
						.add("E",    "__LED_PORT_E__")
						.add("F",    "__LED_PORT_F__")
						.add("G",    "__LED_PORT_G__")
						.add("H",    "__LED_PORT_H__")
						.add("J",    "__LED_PORT_J__")
						.add("K",    "__LED_PORT_K__")
						.add("L",    "__LED_PORT_L__")
						.add("M",    "__LED_PORT_M__")
						.add("N",    "__LED_PORT_N__")
						.add("P",    "__LED_PORT_P__")
						.add("Q",    "__LED_PORT_Q__")
			);
		}
		{
			EEBoard board = new EEBoard();
			boards.put("ARDUINO_UNO", board);

			board.eeopt = "__ARDUINO_UNO__";
			board.entries.add( new EEEntry("USELEDS",   null).add("TRUE", "__LED_USED__") );
		}
	}
	
	
	/** The Erika Enterprise Writer that call this section writer */
	protected final ErikaEnterpriseWriter parent;
	
	/** All data */
	protected final IVarTree vt;

	static final String ERR_CPU_TYPE = "Avr 8";
	static final String SGR_OS_APPL_SHARED_STACK_ID = "sgr__os_application__shared_stack_id__integer";
	static final String SGR_OS_CPU_SYS_STACK_SIZE = "sgr__os_cpu_system_stack_size";
	
	static final String SGR_OS_MCU_MODEL = "sgr__os_cpu__mcu_model";

	static final String STACK_BASE_NAME = "EE_avr8_stack_";
	private static final long DEFAULT_SYS_STACK_SIZE = 4096;
	
	private final SectionWriterIsr isrWriter;
	
	/**
	 * 
	 */
	public SectionWriterHalAvr8() {
		this(null);
	}
	
	/**
	 * 
	 */
	public SectionWriterHalAvr8(ErikaEnterpriseWriter parent) {
		super(IWritersKeywords.CPU_AVR8,
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
		
		isrWriter = new SectionWriterIsr(parent, IWritersKeywords.CPU_AVR8);
		isrWriter.setGenerateDefineCategory(true);
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

		return writeEE_avr_CPU();
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
		
		{
			isrWriter.updateObjects();
		}

		final IOilObjectList[] oilObjects = parent.getOilObjects();
		
        LinkedHashSet<String> tmp_common_eeopts = new LinkedHashSet<String>();

		for (int currentRtosId = 0; currentRtosId < oilObjects.length; currentRtosId++) {
			final IOilObjectList ool = oilObjects[currentRtosId];
			
			{
		        ArrayList<String> tmp_eeopts = new ArrayList<String>();
				/***********************************************************************
				 * 
				 * EE OPTS
				 *  
				 **********************************************************************/
				{
			        // store all older values (if there are)
					ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
			        if (sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_EE_OPTS)) {
			        	String[] old = (String[]) sgrCpu.getObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS);
			        	tmp_eeopts.addAll(Arrays.asList(old));
			        }
			        
			        tmp_eeopts.add("__AVR8__");
		
					// store ee_opts
					sgrCpu.setObject(ISimpleGenResKeywords.OS_CPU_EE_OPTS, tmp_eeopts.toArray(new String[tmp_eeopts.size()]));
				}
						
				/***********************************************************************
				 * 
				 * System stack size
				 *  
				 **********************************************************************/
				{
					String[] stack_size = parent.getCpuDataValue(ool, "SYS_STACK_SIZE");
					if (stack_size != null && stack_size.length>0 && stack_size[0] != null) {
						
						boolean valid = false;
						int value = -1;
						try {
							value = Integer.decode(stack_size[0]);
							valid = true;
						} catch (NumberFormatException e) {
							Messages.sendWarningNl("Invalid value for System stack size : " + stack_size[0]);
						}
						
						if (valid && value <0) {
							Messages.sendWarningNl("System stack size cannot be negative (" + value + ")");
						} else {
							
							ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
							sgrCpu.setProperty(SGR_OS_CPU_SYS_STACK_SIZE, ""+value);
						}
						
					}

				}
			}
			
		}
		
		checkMcu(tmp_common_eeopts);   // note that mcu   must done after board 
		checkBoard(tmp_common_eeopts); // note that board must done after board 
	
		for (int currentRtosId = 0; currentRtosId < oilObjects.length; currentRtosId ++) { 
			IOilObjectList ool = oilObjects[currentRtosId];
			
			/* COMMON VARIABLES */
			ISimpleGenRes sgrCpu = (ISimpleGenRes) ool.getList(IOilObjectList.OS).get(0);
			sgrCpu.setObject(ISimpleGenResKeywords.OS_CPU_COMMON_EE_OPTS, tmp_common_eeopts.toArray(new String[tmp_common_eeopts.size()]));			
			
			// updateStacks (needed by orti)... not the best solution....
			handleStacks(currentRtosId, ool);
		}
	}
	
	/**
	 * Write configuration's files for Freescale MPC5674F, PPC E200Z7
	 * 
	 * @return buffers with configuration for Freescale MPC5674F, PPC E200Z7
	 * 
	 * @throws OilCodeWriterException
	 *             if there are some problems
	 */
	protected IOilWriterBuffer[] writeEE_avr_CPU()
			throws OilCodeWriterException {

		final IOilObjectList[] oilObjects = parent.getOilObjects();		
		IOilWriterBuffer[] answer = new IOilWriterBuffer[oilObjects.length];

		final int rtosNumber = oilObjects.length;


		/***********************************************************************
		 * prepare and write buffers for All OS
		 **********************************************************************/
		for (int currentRtosId = 0; currentRtosId < rtosNumber; currentRtosId++) {
		
			IOilWriterBuffer cpuBuffs = new OilWriterBuffer();
			answer[currentRtosId] = cpuBuffs;
	
	
			// ------------- Requirement --------------------
			StringBuffer sbInithal_c = cpuBuffs.get(FILE_EE_CFG_C);
//			StringBuffer sbInithal_h = cpuBuffs.get(FILE_EE_CFG_H);
			
			final IOilObjectList ool = oilObjects[currentRtosId];
	
	
			// ------------- Compute --------------------
	
			sbInithal_c.append("\n#include \"ee.h\"\n");
	
//			/***********************************************************************
//			 * SYSTEM STACK SIZE
//			 **********************************************************************/
//			sbInithal_h.append(indent1 + getCommentWriter(ool, FileTypes.H).writerSingleLineComment("System stack size") + 
//						indent1 + "#define EE_SYS_STACK_SIZE     " + 
//							( ErikaEnterpriseWriter.checkOrDefault(AbstractRtosWriter.getOsProperty(ool, SGR_OS_CPU_SYS_STACK_SIZE),
//									DEFAULT_SYS_STACK_SIZE))
//						+ "\n\n");
			
			
			/***********************************************************************
			 * OTHER STACKs
			 **********************************************************************/
			sbInithal_c.append(handleStacks(currentRtosId, ool));
			
	
			
			//  ------------- MORE FILES ---------------
			
			
			// isr
			isrWriter.writeIsr(oilObjects, currentRtosId, ool, cpuBuffs);
			
			// makefile
			prepareMakeFile(currentRtosId, ool);
		
		}
		
		return answer;
	}


	protected StringBuffer handleStacks(int currentRtosId, final IOilObjectList ool) throws OilCodeWriterException  {
		String stackType = parent.getStackType(); // MULTI or MONO
		StringBuffer sbInithal_c = new StringBuffer();

		if (getOsProperty(ool, SGRK_OS_CPU_DATA_PREFIX) == null) {
			return sbInithal_c;
		}
		final ICommentWriter commentWriterC = getCommentWriter(ool, FileTypes.C);
		
		List<ISimpleGenRes> taskNames = ool.getList(IOilObjectList.TASK);
		List<ISimpleGenRes> osApplications = ool.getList(IOilObjectList.OSAPPLICATION);
		boolean binaryDistr = parent.checkKeyword(IEEWriterKeywords.DEF__EE_USE_BINARY_DISTRIBUTION__);
		
		final String mcu_type;
		{
			String tmp = getOsProperty(ool, SGR_OS_MCU_MODEL);
			mcu_type = tmp == null ? "" : " (" + tmp + ")";
		}

		/*
		 * Define a string for each MAX_OBJECT_NUMBER (OBJECT=task, RESOURCE, ...).
		 * Binary distribution uses the suffix RTD_. 
		 */
		final String MAX_TASK = (binaryDistr ? "RTD_" : "EE_") + "MAX_TASK";

		String pre = "";
		String post = "";
		final String indent = IWritersKeywords.INDENT;
		
		EEStackData sys_stack = new EEStackData(0,
				new long[] { Long.decode(checkOrDefault(getOsProperty(ool, SGR_OS_CPU_SYS_STACK_SIZE), "" + DEFAULT_SYS_STACK_SIZE))},
				new long[] {0},
				new String[] {" (int)&EE_avr8_sys_stack "}, true);

		
		/***********************************************************************
		 * MULTI STACK
		 **********************************************************************/
		if (DEF__MULTI_STACK__.equals(stackType)) {
			ArrayList<EEStackData> stackTmp = new ArrayList<EEStackData>();
//			final String DELTA = "-2";

			// ------------- Buffers --------------------
			/* A buffer about stack  */
			StringBuffer sbStack = new StringBuffer();

			/* A buffer about declarations of stacks  */
			StringBuffer sbStackDecl = new StringBuffer();
			StringBuffer sbStackDeclSize = new StringBuffer();
//			StringBuffer stackPatternFill = new StringBuffer();
			
			sbInithal_c.append(commentWriterC
					.writerBanner("Stack definition for AVR8"+mcu_type));
			
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
			//EEStacks elStack = new EEStacks(parent, ool, irqSize);
			EEStacks elStack = new EEStacks(parent, ool, null);
			elStack.setDummyStackPolicy(elStack.FORCE_ALWAYS | elStack.FORCE_FIRST);
			ArrayList<String> tList = new ArrayList<String>();
			ArrayList<String> tListN = new ArrayList<String>();

			// use a macro to ensure alignment
//			final int STACK_UNIT;
//			if (sgrCpu.containsProperty(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR)) {
//				CpuHwDescription currentStackDescription = (CpuHwDescription) sgrCpu.getObject(ISimpleGenResKeywords.OS_CPU_DESCRIPTOR);
//				STACK_UNIT = currentStackDescription.stackSize;
//			} else {
//				STACK_UNIT = 4;
//			}
			
			 
			{
				/***************************************************************
				 * STACK FOR EACH TASK
				 **************************************************************/
				
				// add the dummy task
				tListN.add("");
				tList.add(IWritersKeywords.dummyName);
				
				// fill data for each task
				for (Iterator<ISimpleGenRes> iter = taskNames.iterator(); iter.hasNext();) {

					ISimpleGenRes sgr = (ISimpleGenRes) iter.next();
					tList.add(sgr.getName());
					tListN.add(sgr.getString(ISimpleGenResKeywords.TASK_SYS_ID));
				}

				// fill data for each shared stack, related to OS applications
				for (Iterator<ISimpleGenRes> iter = osApplications.iterator(); iter.hasNext();) {

					ISimpleGenRes sgr = (ISimpleGenRes) iter.next();
					tList.add(EEStacks.APPLICATION_SHARED_PREFIX+ sgr.getName());
					tListN.add(" ");

					tList.add(EEStacks.APPLICATION_IRQ_PREFIX+ sgr.getName());
					tListN.add("");
					
					sgr.setObject(SGR_OS_APPL_SHARED_STACK_ID, new Integer((tList.size()-1)));
					sgr.setObject(EEStacks.STACK_BASE_NAME_PREFIX, STACK_BASE_NAME);
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
				/* get the memory section id of each stack. */
				String memoryId[] = elStack.stackMemoryId(tList
						.toArray(new String[1]));
				
				/* descrStack contains a description for each stack. */ 
				String[] descrStack = new String[size.length];
				sbStack.append(indent
						+ "const EE_UREG EE_std_thread_tos["+MAX_TASK+"+1] = {\n");
				
			 // fill data for each shared stack, related to OS applications
				for (Iterator<ISimpleGenRes> iter = osApplications.iterator(); iter.hasNext();) {

					ISimpleGenRes sgr = (ISimpleGenRes) iter.next();
					Integer index = (Integer) sgr.getObject(SGR_OS_APPL_SHARED_STACK_ID);

					sgr.setProperty(ISimpleGenResKeywords.OS_APPL_SHARED_STACK_ID,"" + pos[index.intValue()]);
					
				}
					
				// DESCRIPTIONS
				
				for (int j = 0; j < pos.length; j++) {
					String stack_name = tList.get(j);
					if (!stack_name.startsWith(EEStacks.APPLICATION_SHARED_PREFIX) 
							&& !stack_name.startsWith(EEStacks.APPLICATION_IRQ_PREFIX)) {
						
						sbStack.append(pre + post + indent + indent + +pos[j]+"U");
						// set new values for "post" and "pre"
						post = " /* " + stack_name + "*/\n";
						pre = ",\t";
					}

					/*
					 * add the name of current task to the description of the /
					 * right stack. Check also if there is already something or
					 * not, infact in the second case append the new description
					 * to the old one
					 */ 
					final String tid;
					if (stack_name.startsWith(EEStacks.APPLICATION_SHARED_PREFIX)) {
						tid = "shared stack " +stack_name.substring(EEStacks.APPLICATION_SHARED_PREFIX.length()); 
					} else if (stack_name.startsWith(EEStacks.APPLICATION_IRQ_PREFIX)) {
						tid = "ISR stack for " +stack_name.substring(EEStacks.APPLICATION_IRQ_PREFIX.length()); 
					} else {
						tid = "Task " +tListN.get(j)+ " (" + stack_name + ")";
					}
					descrStack[pos[j]] = (descrStack[pos[j]] == null) ?
							// The first description
							(tid)
							:
							// other descriptions
							(descrStack[pos[j]] + ", " + tid); // others
				}

				// close sbStack
				sbStack.append(" \t" + post + indent + "};\n\n");

				pre = "";
				post = "";

				
				// USED BY ORTI
				stackTmp.add(sys_stack);
				

//				 DECLARE STACK SIZE && STACK (ARRAY)
				for (int j = 1; j < size.length; j++) {
				    long value = size[j][0];
			    	final String memId = memoryId[j];
//				    value  = (value + (value%STACK_UNIT)) / STACK_UNIT; // arrottondo a 2
					sbStackDeclSize.append(indent1 + "#define STACK_"+j+"_SIZE "+value+" " + commentWriterC.writerSingleLineComment("size = "+size[j][0]+" bytes"));
			    	
			    	final String decl = "EE_UREG " +
								STACK_BASE_NAME+j+"[STACK_"+j+"_SIZE];\t/* "+descrStack[j]+" */";
			    	sbStackDecl.append(indent1 + decl + "\n");
					
					// USED BY ORTI
					stackTmp.add(new EEStackData(j, new long[] {size[j][0]}, new long[] {size[j][0]},
							new String[] {" (int)(&"+STACK_BASE_NAME+j+")"}, true)); // DELTA
				}

				
				int tos_size = size.length - osApplications.size();
				
				// open system tos
				sbStack.append(indent
						+ "struct EE_TOS EE_avr8_system_tos["+ErikaEnterpriseWriter.addVectorSizeDefine(ool, "EE_avr8_system_tos", tos_size)
						+ "] = {\n");

				/*
				 * For each stack prepare the configuration's vectors and
				 * descriptions
				 */
				for (int j = 0; j < tos_size; j++) {
				    
			        String value = j == 0 ? "{0}" : "{(EE_ADDR)(&"+STACK_BASE_NAME+j+"[STACK_"+j+"_SIZE - AVR8_INIT_TOS_OFFSET])}"; // DELTA

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
						+ "EE_UREG EE_avr8_active_tos = 0U; /* dummy */\n\n");

				{ // if required, init also the irq stack
					if (irqSize != null) {
						int j = size.length;
					    long value = irqSize[0];
					    
//					    value  = (value + (value%STACK_UNIT)) / STACK_UNIT; // arrottondo a 2
						sbStackDeclSize.append(indent1 + "#define STACK_"+j+"_SIZE "+value+ " " + commentWriterC.writerSingleLineComment("size = "+irqSize[0]+" bytes"));
						
						final String decl = "EE_UREG "+STACK_BASE_NAME+j+"[STACK_"+j+"_SIZE];\t/* irq stack */";
				    	sbStackDecl.append(indent1 + decl + "\n");

						sbStack
								.append(indent+"/* stack used only by IRQ handlers */\n"
										+ indent+"struct EE_TOS EE_avr8_IRQ_tos = {\n"
										+ indent+indent+"(EE_ADDR)(&"+STACK_BASE_NAME+j+"[STACK_"+j+"_SIZE - AVR8_INIT_TOS_OFFSET])\n" // DELTA
										+ indent+"};\n\n");
						
						// REQUIRED By ORTI's STACK
						int eesdID = stackTmp.size();
						stackTmp.add(new EEStackData(eesdID, new long[] {irqSize[0]}, new long[] {irqSize[0]},
								new String[] {" (int)(&"+STACK_BASE_NAME+j+")"}, true)); // DELTA

						ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
						sgrCpu.setProperty(ISimpleGenResKeywords.OS_IRQ_STACK_ID, ""+eesdID);
					}
				}

				
//			    stackPatternFill.append("#endif\n");
				{// ORTI : Store link between task and stack
					int j = 1;
					for (Iterator<ISimpleGenRes> iter = taskNames.iterator(); iter.hasNext(); j++) {
						ISimpleGenRes sgr = iter.next();
						sgr.setObject(SGRK_TASK_STACK, stackTmp.get(pos[j]));
					}
					ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
					sgrCpu.setObject(SGRK_OS_STACK_LIST, stackTmp.toArray(new EEStackData[0]));
					sgrCpu.setObject(SGRK_OS_STACK_VECTOR_NAME, "EE_avr8_system_tos");
				}

			}		

			// add stack sizes
			sbInithal_c.append(sbStackDeclSize+"\n");

			// add other stack declarations
			sbInithal_c.append(sbStackDecl + "\n" +
			        sbStack
//			        +stackPatternFill
			        );

		} else {
			
			ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
			sgrCpu.setObject(SGRK_OS_STACK_LIST, new EEStackData[] {sys_stack});
		}

		return sbInithal_c;
	}

	/*
	 * Parse and write the MCU Section
	 */
	private void checkMcu(LinkedHashSet<String> tmp_common_eeopts) throws OilCodeWriterException {
		
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		String mcu_model = null;
		
		ErikaEnterpriseWriter.EEProperties checkProps = new ErikaEnterpriseWriter.EEProperties();
		
		for (IOilObjectList ool : oilObjects) {

			/***********************************************************************
			 * get values
			 **********************************************************************/
			ArrayList<String> childPaths = new ArrayList<String>();
			List<String> childFound = ErikaEnterpriseWriter.getRtosCommonChildType(vt, ool, "MCU_DATA", childPaths);

			for (int index = 0; index<childFound.size(); index++) {
				if (mcu_model == null) {
					String mcu_type = childFound.get(index);
					
					EEBoard mcu = mcus.get(mcu_type);
					if (mcu != null) {
						final String mcuBasePath = childPaths.get(index);
						
						if (mcu.eeopt != null)
							tmp_common_eeopts.add(mcu.eeopt);

						for (EEEntry modelGp : mcu.model) {
							String prefix = mcuBasePath + PARAMETER_LIST + modelGp.path;

							String[] enumName = new String[1];
							String type = CommonUtils.getFirstChildEnumType(vt, prefix, enumName);
							if (type == null) type = modelGp.defaultValue;
							
							if ("CUSTOM".equals(type)) {
								String[] values = CommonUtils.getValue(vt, 
										prefix + S + enumName[0] + S +"MODEL");
								if (values != null && values.length>0) {
									mcu_model = values[0];
								}
								
							} else if (modelGp.values.containsKey(type)) {
								mcu_model = modelGp.values.get(type);
							}
						}
						
						for (EEEntry entry : mcu.entries) {
							entry.check(vt, mcuBasePath, checkProps, tmp_common_eeopts);
						}

						for (EEEnumGroup group : mcu.drivers) {

							String groupPrefix = mcuBasePath + PARAMETER_LIST + group.path;
							
							String[] groupPathStr = new String[1];
							String groupTypeStr = CommonUtils.getFirstChildEnumType(vt, groupPrefix, groupPathStr);
							if (groupTypeStr != null && group.groups.containsKey(groupTypeStr)) {
								EEEnum driver = group.groups.get(groupTypeStr);
								groupPrefix += VARIANT_ELIST+groupPathStr[0];
								
								if (driver.eeopt != null) {
									tmp_common_eeopts.add(driver.eeopt);
								}
								
								for (EEEntry entry : driver.entries) {
									entry.check(vt, groupPrefix, checkProps, tmp_common_eeopts);
								}									
							}
						}
					}
					
				}
			}
			
		}
		
		if (mcu_model != null) {
			for (IOilObjectList ool: oilObjects) { 
				ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
				sgrCpu.setProperty(SGR_OS_MCU_MODEL, mcu_model);
			}
		}
	}


	/*
	 * Parse and write the MCU Section
	 */
	private void checkBoard(LinkedHashSet<String> tmp_common_eeopts) throws OilCodeWriterException {
		
		final IOilObjectList[] oilObjects = parent.getOilObjects();
		String mcu_type = null;
		
		ErikaEnterpriseWriter.EEProperties checkProps = new ErikaEnterpriseWriter.EEProperties();
		
		for (IOilObjectList ool : oilObjects) {

			/***********************************************************************
			 * get values
			 **********************************************************************/
			ArrayList<String> childPaths = new ArrayList<String>();
			List<String> childFound = ErikaEnterpriseWriter.getRtosCommonChildType(vt, ool, "BOARD_DATA", childPaths);

			for (int index = 0; index<childFound.size(); index++) {
				if (mcu_type == null) {
					mcu_type = childFound.get(index);
					
					EEBoard board = boards.get(mcu_type);
					if (board != null) {
						final String mcuBasePath = childPaths.get(index);
						
						if (board.eeopt != null)
							tmp_common_eeopts.add(board.eeopt);
						
						for (EEEntry entry : board.entries) {
							entry.check(vt, mcuBasePath, checkProps, tmp_common_eeopts);
						}

						for (EEEnumGroup group : board.drivers) {

							String groupPrefix = mcuBasePath + PARAMETER_LIST + group.path;
							
							String[] groupPathStr = new String[1];
							String groupTypeStr = CommonUtils.getFirstChildEnumType(vt, groupPrefix, groupPathStr);
							if (groupTypeStr != null && group.groups.containsKey(groupTypeStr)) {
								EEEnum driver = group.groups.get(groupTypeStr);
								groupPrefix += VARIANT_ELIST+groupPathStr[0];
								
								if (driver.eeopt != null) {
									tmp_common_eeopts.add(driver.eeopt);
								}
								
								for (EEEntry entry : board.entries) {
									entry.check(vt, mcuBasePath, checkProps, tmp_common_eeopts);
								}									
							}
						}
					}
					
				}
			}
			
		}
	}
	
	/**
	 * MakeFile
	 */
	private void prepareMakeFile(final int currentRtosId, final IOilObjectList ool) {
		final ICommentWriter commentWriterMf = getCommentWriter(ool, FileTypes.MAKEFILE);
		final boolean multicore = parent.getOilObjects().length>1;
		
		final String mcu_type;
		{
			String tmp = getOsProperty(ool, SGR_OS_MCU_MODEL);
			mcu_type = tmp == null ? "" : " (" + tmp + ")";
		}
		
		/***********************************************************************
         * 
         * MAKE FILE
         *  
         **********************************************************************/
		OsType wrapper = HostOsUtils.common.getTarget();

	    StringBuilder sbMakefile = new StringBuilder(commentWriterMf.writerBanner("AVR8"+mcu_type));
	    StringBuilder sbVariables = new StringBuilder();
//			StringBuilder sbCommon = new StringBuilder();
		    
		    {	// PATHs
	        	HashMap<String, ?> options = parent.getOptions();

	        	{ 
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
			    	IPath p = new Path(outputDir);
			    	if (p.isAbsolute()) {
			    		outputDir = wrapper.wrapPath(outputDir);
			    	}
			    	
			    	
			        sbMakefile.append(
			        		CommonUtils.addMakefileDefinesInclude() +
			                "APPBASE := " + appBase + "\n" +
			                "OUTBASE := " + outputDir + "\n\n"
			        );
			    }
	        	{
	        		String tmp = getOsProperty(ool, SGR_OS_MCU_MODEL);
	        		if (tmp != null) {
	        			sbMakefile.append( "AVR8_MCU := " + tmp + "\n\n" );
			        }
	        	}
	        	{
					String compiler_define = "";			        
			        String gcc = "";
			        
			    	if (options.containsKey(AvrConstants.PREF_AVR8_GCC_PATH) ) {
						String tmp = (String) options.get(AvrConstants.PREF_AVR8_GCC_PATH);
						if (tmp.length()>0) gcc = tmp;
					}
		    		compiler_define = CommonUtils.compilerMakefileDefines(gcc, "AVR_TOOLS", wrapper);
			        
			    	sbMakefile.append(compiler_define);
	        	}
	        	{
			    	if (options.containsKey(AvrConstants.PREF_AVR8_ARDUINO_PATH) ) {
						String gcc = (String) options.get(AvrConstants.PREF_AVR8_ARDUINO_PATH);
						if (gcc.length()>0) {
				    		String compiler_define = CommonUtils.compilerMakefileDefines(gcc, "ARDUINO_SDK_FILES", wrapper);
					        
					    	sbMakefile.append(compiler_define);
						}
					}
	        	}
		    }

			ISimpleGenRes sgrCpu = ool.getList(IOilObjectList.OS).get(0);
			
			if (sgrCpu.containsProperty(SGRK__MAKEFILE_EXTENTIONS__)) {
				sbMakefile.append(sgrCpu.getString(SGRK__MAKEFILE_EXTENTIONS__));
			}
			sgrCpu.setProperty(SGRK__MAKEFILE_EXTENTIONS__, sbMakefile.toString());

			if (sgrCpu.containsProperty(SGRK__MAKEFILE_CPU_EXT_VARS__)) {
				sbVariables.append(sgrCpu.getString(SGRK__MAKEFILE_CPU_EXT_VARS__));
			}
			sgrCpu.setProperty(SGRK__MAKEFILE_CPU_EXT_VARS__, sbVariables.toString());
	}
	
	/**
	 * This metod takes an array and returns the first element, or null if the
	 * array is a zero-length array or if the first element is empty ("" or
	 * null)
	 */
	static String clean(String[] arr) {
		String answer = null;
		if (arr != null && arr.length>0) {
			if (arr[0].trim().length()>0) {
				answer= arr[0].trim();
			}
		}
		return answer;
	}

}
