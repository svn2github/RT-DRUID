/*
 * Created on Nov 30, 2004
 *
 * $Id: IWritersKeywords.java,v 1.14 2008/04/18 15:26:29 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.keywords;

import com.eu.evidence.rtdruid.modules.oil.codewriter.common.SWCategoryManager;

/**
 * This class contains all keys used by writers as identifiers for rtosWriter or
 * sections. Many of these keys are the keywords used inside an Oil File.
 * 
 * @author Nicola Serreli
 */
public interface IWritersKeywords {
	
	
	// UPDRTD rimuovere tutte le cose non generali
	
	final static String TXT = "abcdefgh12345678!@#$%^&*qwertyui";
	/** Identifies Erika Enterprise */
	public final static String RTOS_EE = "EE";

	/** Identifies Erika Enterprise Sources Location (host path) */
	public final static String ERIKA_ENTERPRISE_LOCATION = "Erika_Enterprise_Location";


	//  ------------------------ CPU ------------------------

	/** Identifies an unknow cpu */
	public final static String CPU_UNKNOW = "UNKNOW_HW";

	/** Identifies an ARM7 cpu */
	public final static String CPU_ARM7 = "ARM7";

	/** Identifies a JANUS architecture (two cpu) */
	public final static String CPU_JANUS = "JANUS";

	/** Identifies a Renesas RX200 architecture */
	public final static String CPU_RX200 = "RX200";
	
	/** Identifies a PPC architecture (without protection) */
	public final static String CPU_MPC5xx = "MPC5";

	/** Identifies a PPC architecture (E200Zx family) */
	public final static String CPU_PPCE200ZX = "PPCE200ZX";
	
	/** Identifies a PPC architecture (Z0) */
	public final static String CPU_PPCE200Z0 = "E200Z0";

	/** Identifies a PPC architecture (Z4) */
	public final static String CPU_PPCE200Z4 = "E200Z4";

	/** Identifies a PPC architecture (Z6) */
	public final static String CPU_PPCE200Z6 = "E200Z6";

	/** Identifies a PPC architecture (Z7) */
	public final static String CPU_PPCE200Z7 = "E200Z7";

	/** Identifies a PPC architecture (without protection) */
	public final static String MCU_MPC5674F = "MPC5674F";

	/** Identifies a NIOS architecture (one or more cpu) */
	public final static String CPU_NIOSII = "NIOSII";

	/** Identifies a TriCore architecture (one or more cpu?) */
	public final static String CPU_TRICORE = "TRICORE";
	/** Identifies a TriCore architecture (one or more cpu?) */
	public final static String CPU_TRICORE1 = "TRICORE1";

	/** Identifies a generic Cortex Mx architecture (one or more cpu?) */
	public final static String CPU_CORTEX_MX = "CORTEX_MX";

	/** Identifies a generic Cortex Ax (XEN) architecture (one or more cpu?) */
	public final static String CPU_CORTEX_AX_XENPV = "CORTEX_AX_XENPV";

	/** Identifies a PIC 30 architecture (one or more cpu?) */
	public final static String CPU_PIC_30 = "PIC30";

	/** Identifies a PIC 32 architecture (one or more cpu?) */
	public final static String CPU_PIC_32 = "PIC32";

	/** Identifies a Mico32 (latix?) architecture (one or more cpu?) */
	public final static String CPU_MICO_32 = "LM32";

	/** Identifies a S12 architecture (one or more cpu?) */
	public final static String CPU_S12 = "MC9S12";
	/** Identifies a S12 architecture (one or more cpu?) */
	public final static String CPU_S12_OLD_NAME = "MC9S12XS";

	/** Identifies an AVR 5 architecture (one cpu?) */
	public final static String CPU_AVR5 = "AVR_5";

	/** Identifies an AVR architecture (one cpu?) */
	public final static String CPU_AVR8 = "AVR8";

	/** Identifies an AVR architecture (one cpu?) */
	public final static String CPU_X86 = "X86";
	
	/** Identifies the number of cpu (one or more cpu) */
	public final static String CPU_NUMBER = "CPU_NUMBER";
	
	/** Identifies the default name for cpus */
	public final static String DEFAULT_CPU_NAME = "default_cpu";


	//  -------------------- KERNEL TYPE --------------------

	/** Identifies a generic OSEK kernel (BCC1, BCC2, ECC1, ECC2)*/
	public final static String OSEK_KERNEL = "BCC1_BCC2_ECC1_ECC2";

	/** Identifies an OSEK BCC1 kernel */
	public final static String OSEK_BCC1 = "BCC1";

	/** Identifies an OSEK BCC2 kernel */
	public final static String OSEK_BCC2 = "BCC2";

	/** Identifies an OSEK ECC1 kernel */
	public final static String OSEK_ECC1 = "ECC1";

	/** Identifies an OSEK ECC2 kernel */
	public final static String OSEK_ECC2 = "ECC2";

	/** Identifies an OSEK BCC1 kernel */
	public final static String OSEK_SC1 = "SC1";

	/** Identifies an OSEK BCC2 kernel */
	public final static String OSEK_SC2 = "SC2";

	/** Identifies an OSEK ECC1 kernel */
	public final static String OSEK_SC3 = "SC3";

	/** Identifies an OSEK ECC2 kernel */
	public final static String OSEK_SC4 = "SC4";

	
	/** Identifies an FP kernel */
	public final static String FP = "FP";

	/** Identifies an EDF kernel */
	public final static String EDF = "EDF";

	/** Identifies an SRPT kernel */
	public final static String SRPT = "SRPT";

	/** Identifies an IRIS kernel */
	public final static String IRIS = "IRIS";

	/** Identifies a FRESCOR kernel */
	public final static String FRSH = "FRSH";

	/** Identifies an HR kernel */
	public final static String HR = "HR";

	/** Identifies an CBS kernel */
	public final static String CBS = "CBS";

	/** Enables the support for sys calls (if available) */
	public final static String KERNEL_SYS_CALL = "OS_SYS_CALL";

	/** Enables the os applications for the current kernel (if available) */
	public final static String KERNEL_OS_APPLICATION = "OS_APPLICATION";

	/** Enables the service protection for the current kernel (if available) */
	public final static String KERNEL_SERVICE_PROTECTION = "SERVICE_PROTECTION";
	
	/** Enables the memory protection for the current kernel (if available) */
	public final static String KERNEL_MEMORY_PROTECTION = "MEMORY_PROTECTION";
	
	/** Enables the usage of kernel private stacks for the current architecture (if available) */
	public final static String KERNEL_KERNEL_STACKS = "KERNEL_STACKS";

	/** Common memory protection writer: writer type */
	public final static String KERNEL_MEMORY_PROTECTION_TYPE = SWCategoryManager.TYPE_KERNEL;
	/** Common memory protection writer: priority inside writer type */
	public final static int KERNEL_MEMORY_PROTECTION_PRIORITY = 6;
	
	// ---------------------- Var Tree -----------------------
	
	/** Contains the path of Project that contains the OilFile */
	public final static String VTProperty_OilProjectPath = "VTProperty_Oil_Project_Path";

	/** Contains the name of Project that contains the OilFile */
	public final static String VTProperty_OilProjectName = "VTProperty_Oil_Project_Name";

	//  -------------------- OTHER --------------------

	/** Identifies the os's property that contains all keywords */
	public final static String CONTAINER_OS_KEYWORDS = "KEYWORDS";
	
	/** Contains the wait spaces used to indent files */
	public final static String INDENT = "    ";

	/** Contains the name of Dummy Thread */
	public final static String dummyName = "dummy";
	
	/** Contains the name of default app mode */
	public final static String defaultAppMode = "OSDEFAULTAPPMODE";

	public final static String RES_SCHEDULER = "RES_SCHEDULER";

	public final static String FILE_MAKEFILE = "makefile";

	/** Identifies the option that contains the common path of output directories */
	public final static String WRITER_OUTPUT_DIR_SET = "writer_output_prefix_GROUP";
	public final static String WRITER_LAST_OUTPUT_DIR = "writer_last_output_prefix";
	// this keyword is used to go from output dir to app_base
	public final static String WRITER_FS_PATH_OUTPUT_DIR = "writer_fs_full_path_output_dir";
	public final static String WRITER_WS_OUTPUT_projectbase_DIR = "writer_base_output_prefix_inside_project";
	public final static String WRITER_WS_PATH_OUTPUT_DIR = "writer_ws_project_relative_path_output_dir";
	
	public static final String WRITER_DISABLE_EE_RULES = "disable_generation_of_ee_rules_call_inside_makefiles";

	
	// ----------------------- ORTI -------------------------------
	/** This keyword is used to enable the generation of orti files */
	public final static String ENABLE_ORTI = "enable_orti_output";
	public final static String ENABLE_ORTI_ISR2 = "enable_orti_isr2_output";
	

}
