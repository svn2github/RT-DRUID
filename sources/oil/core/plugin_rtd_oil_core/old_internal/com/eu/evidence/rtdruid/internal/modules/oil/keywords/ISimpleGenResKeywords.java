/*
 * Created on Dec 7, 2004
 *
 * $Id: ISimpleGenResKeywords.java,v 1.7 2008/05/14 17:15:53 durin Exp $
 */
package com.eu.evidence.rtdruid.internal.modules.oil.keywords;

/**
 * Contains a list of properties used for one or more Simple Gen Res Objects
 *
 * @author Nicola Serreli
 */
public interface ISimpleGenResKeywords {
	
	// UPDRTD rimuovere tutte le cose non generali
	
	
	/***************************************************************************
	 * GenRes
	 **************************************************************************/
	public final static String GEN_RES_NAME = "name";
	
	/***************************************************************************
	 * AppMode
	 **************************************************************************/
	public final static String APPMODES_TASK_LIST = "appmodes_task";
	public final static String APPMODES_ALARM_LIST = "appmodes_alarm";
	
	/***************************************************************************
	 * Task
	 **************************************************************************/
	public final static String TASK_SYS_ID = "task_id";
	public final static String TASK_READY_PRIORITY = "task_ready_priority";
	public final static String TASK_PRIORITY = "task_priority";
	public final static String TASK_DISPATCH_PRIORITY = "dispatch_priority";
	public final static String TASK_EXTENDED = "task_extended";
	public final static String TASK_AUTOSTART = "task_autostart";
	public final static String TASK_APPMODES_LIST = "task_appmodes";
	public final static String TASK_ACTIVATION = "task_activation";
	public final static String TASK_SCHEDULE = "schedule";
	public final static String TASK_RESOURCE_LIST = "resource_list";
	public final static String TASK_EVENT_LIST = "task_event_list";
	public final static String TASK_SRC_FILE_LIST = "task_src_file_list";
	public final static String TASK_STACK = "task_stack";
	public final static String TASK_STACK_SIZE = "task_stack_size";
	public final static String TASK_IRQ_SIZE = "task_irq_size";

	public final static String TASK_STACK_SHARED = "SHARED";
	public final static String TASK_STACK_PRIVATE = "PRIVATE";

	public final static String TASK_OS_APPLICATION_NAME = "task_mapped_to_an_os_application";


	/** This property say if at least one cpu sends a remote notification to a task */
	public final static String TASK_REMOTE = "remote";
	///** This property contains the list of cpu that send a remote notification to a task */
	//public final static String TASK_REMOTE_LIST = "task_remote_list";

	/***************************************************************************
	 * Isr
	 **************************************************************************/
	public final static String ISR_CATEGORY = "category";
	public final static String ISR_ENTRY = "entry";
	public final static String ISR_USER_PRIORITY = "isr_priority_defined_by_user";
	public final static String ISR_READY_PRIORITY = "isr_ready_priority";
	public final static String ISR_HANDLER = "handler";
	public final static String ISR_GENERATED_PRIORITY_VALUE  = "isr_priority_generated__integer";
	public final static String ISR_GENERATED_PRIORITY_STRING = "isr_priority_generated__string";
	public final static String ISR_GENERATED_HANDLER = "isr___generated_handler";
	public final static String ISR_GENERATED_ENTRY = "isr___generated_entry";
	public final static String ISR_GENERATED_PRIOID = "isr___generated_priority_id";
	public final static String ISR_ID = "isr_index";
	public final static String ISR_OS_APPLICATION_NAME = "isr_mapped_to_an_os_application";
	public final static String ISR_RESOURCE_LIST = TASK_RESOURCE_LIST;
	public final static String ISR_REQUIRES_RESOURCES = "isr_requires_resources";
	
	/***************************************************************************
	 * Autostart
	 **************************************************************************/
	/** Identifies the autostart property in an OSEK kernel */
	public final static String OSEK_AUTOSTART = "OSEK_autostart";
	public final static String OSEK_TASK_AUTOSTART = "OSEK_task_autostart";
	public final static String OSEK_ALARM_AUTOSTART = "OSEK_alarm_autostart";
	
	/***************************************************************************
	 * Counter
	 **************************************************************************/
	public final static String COUNTER_SYS_ID = "counter_id";
	public final static String COUNTER_CPU_MAPPED_ID = "counter_cpu_mapped_id";
	public final static String COUNTER_MAX_ALLOWED = "counter_maxAllowed";
	public final static String COUNTER_TICKS = "counter_ticks";
	public final static String COUNTER_MIN_CYCLE = "counter_minCycle";
	public final static String COUNTER_SECONDPERTICK = "counter_second_per_ticks";
	public final static String COUNTER_NANOSECONDPERTICK = "counter_nanosecond_per_ticks";
	
	public final static String COUNTER_TYPE = "counter_type";
	public final static String COUNTER_TYPE_HW = "HARDWARE";
	public final static String COUNTER_DEVICE = "counter__hw_device";
	/** Handler defined by the user (if one)*/
	public final static String COUNTER_USER_HANDLER = "counter__hw_user_handler";
	public final static String COUNTER_ISR_PRIORITY = "counter__hw_isr_priority";
	/** Handler used by the code (it may be the one proposed by the user or one computed by the code generator */
	public final static String COUNTER_GENERATED_HANDLER = "counter__hw_generated_handler";
	public final static String COUNTER_GENERATED_PRIORITY_VALUE = "counter__hw_generated_priority_value";
	public final static String COUNTER_GENERATED_PRIORITY_STRING = "counter__hw_generated_priority_string";
	public final static String COUNTER_SYSTIMER = "counter__hw_system_timer";
	public final static String COUNTER_TYPE_SW = "SOFTWARE";
	
	public final static String COUNTER_OS_APPLICATION_NAME = "counter_mapped_to_an_os_application";

	/***************************************************************************
	 * Alarm
	 **************************************************************************/
	public final static String ALARM_COUNTER = "alarm_counter";
	public final static String ALARM_AUTOSTART = "alarm_autostart_data";
	public final static String ALARM_INIT = "alarm_init_data";
//	public final static String ALARM_AUTOSTART_ALARMTIME = "alarm_autostart_ALARMTIME";
//	public final static String ALARM_AUTOSTART_CYCLETIME = "alarm_autostart_CYCLETIME";
	public final static String ALARM_AUTOSTART_MODES = "alarm_autostart_MODES";
	public final static String ALARM_SYS_ID = "alarm_id";

	/** contains the current alarm action (one of ALARM_ACTIVATE_TASK, ALARM_SET_EVENT and ALARM_CALL_BACK) */
	public final static String ALARM_ACTION_TYPE= "alarm_action_type";
	/** contains the task name */
	public final static String ALARM_ACTIVATE_TASK = "alarm_activate_task_name";
	/** contains the a Strin[2] with TaskName(0) and EventName(1) */
	public final static String ALARM_SET_EVENT = "alarm_set_event";
	/** contains the callBack name */
	public final static String ALARM_CALL_BACK = "alarm_call_back";
	/** contains the counter name */
	public final static String ALARM_INCR_COUNTER = "alarm_increment_counter";
	/** contains true if the task name is remote */
	public final static String ALARM_TASK_IS_REMOTE = "alarm_task_is_remote";

	public final static String ALARM_OS_APPLICATION_NAME = "alarm_mapped_to_an_os_application";


	/***************************************************************************
	 * Resources
	 **************************************************************************/
	public final static String RESOURCE_GLOBAL = "resource_global";
	public final static String RESOURCE_CEILING = "resource_ceiling";
	public final static String RESOURCE_ISR_CEILING = "resource_isr_ceiling";
	public final static String RESOURCE_USER_ISR_CEILING = "resource_isr_ceiling__user_value";
	public final static String RESOURCE_SYS_ID = "resource_id";
	public final static String RESOURCE_PROPERTY = "RESOURCEPROPERTY";
	/** All Src files required by a resource (String[]) */
	public final static String RESOURCE_SRC = "resource_src";
	
	/** Identifies the list of cpu that uses this resources (BitSet)*/
	public final static String RESOURCE_ALLOCATION = "resource_allocation";

	
	public final static String RESOURCE_TYPE = "resource_type";
	/** Identifies an INTERNAL reource */
	public static final int RESOURCE_INTERNAL = 1<<0;
	/** Identifies a LINKED reource */
	public static final int RESOURCE_LINKED = 1<<1;
	/** Identifies a STANDARD reource */
	public static final int RESOURCE_STANDARD = 1<<2;
	/** Identifies the ROOT reource of a chain*/
	public static final int RESOURCE_CHAIN_ROOT = 1<<3;
	
	/** Contains all names of resources linked to a root resource (ArrayList) */
	public static final String RESOURCE_CHAIN_LIST = "resource_chain_list";

	public final static String RESOURCE_OS_APPLICATION_NAME = "resource_mapped_to_an_os_application";

	/***************************************************************************
	 * Event
	 **************************************************************************/
	public final static String EVENT_MASK = "event_mask";
	public final static String EVENT_CPU_BITSET = "event_cpu_id_bitset";
	
	
	/***************************************************************************
	 * Network message
	 **************************************************************************/
	public final static String N_MESSAGE_LENGHT = "network_message_lenght";
	
	
	/***************************************************************************
	 * OS
	 **************************************************************************/
	public final static String OS_CPU_TYPE = "cpu_type";
	public final static String OS_CPU_NAME = "cpu_name";
	public final static String OS_CPU_DESCRIPTOR = "cpu_descriptor";
	public final static String OS_CPU_COMMENT_MANAGER = "comment_manager";
	public final static String OS_ADD_IRQH = "add_irq.h_include";
	
	public final static String OS_IRQ_STACK_ID = "id_for_default_irq_stack";

	public final static String SOURCES_LIST = "sources_list";
	public final static String THUMB_SOURCES_LIST = "thumb_sources_list";

	public final static String RTOS_PATH = "rtos_path";
	
	public final static String OS_SIGNATURE_DISTR_FULL_ = "_OS_SIGNATURE_DISTR_FULL_";
	public final static String OS_SIGNATURE_DISTR_LIMITED_ = "_OS_SIGNATURE_DISTR_LIMITED_";

	public final static String OS_CPU_EE_OPTS = "_cpu_type_specifics_ee_options_";
	public final static String OS_CPU_COMMON_EE_OPTS = "_cpu_type_common_ee_options_";
	public final static String OS_CPU_C_FLAGS = "_cpu_type_specifics_c_flags_";
	public final static String OS_CPU_AS_FLAGS = "_cpu_type_specifics_as_flags_";
	public final static String OS_CPU_LD_FLAGS = "_cpu_type_specifics_ld_flags_";
	public final static String OS_CPU_LD_DEPS = "_cpu_type_specifics_ld_deps_";
	public final static String OS_CPU_LIBS = "_cpu_type_specifics_libs_";
	public final static String OS_CPU_NIOS_JAM_FILE = "_cpu_type_specifics_nios_jam_file_";
	public final static String OS_CPU_MASTER_CPU = "_cpu_type_specifics_master_cpu_";
	public final static String OS_CPU_MP_SHARED_RAM= "_cpu_type_specifics_mp_shared_ram_";
	public final static String OS_CPU_MP_SHARED_ROM = "_cpu_type_specifics_mp_shared_rom_";
	public final static String OS_CPU_NIOS2_MUTEX_BASE = "_cpu_type_specifics_nios2_mutex_base_";
	public final static String OS_CPU_IPIC_GLOBAL_NAME = "_cpu_type_specifics_ipic_global_name_";
	public final static String OS_CPU_NIOS2_SYS_CONFIG = "_cpu_type_specifics_nios2_sys_config_";
	public final static String OS_CPU_NIOS2_APP_CONFIG = "_cpu_type_specifics_nios2_app_config_";
//	public final static String OS_CPU_ORTI_SECTIONS = "_cpu_type_specifics_orti_sections_";
//	
	
	public final static String OS_CPU__ISR_REQUIRES_RESOURCES = "an_isr_requires_resources";
	public final static String OS_CPU__ISR_REQUIRES_RESOURCES_MAX_PRIO = "an_isr_requires_resources_max_priority";
	public final static String OS_CPU__ISR_REQUIRES_RESOURCES_SIZE = "an_isr_requires_resources_size";

	
	public final static String OS_CPU_STATUS = "_cpu_type_specifics_status_";
	public final static String OS_CPU_STARTUPHOOK = "_cpu_type_specifics_startuphook_";
	public final static String OS_CPU_ERRORHOOK = "_cpu_type_specifics_errorhook_";
	public final static String OS_CPU_SHUTDOWNHOOK = "_cpu_type_specifics_shutdownhook_";
	public final static String OS_CPU_PRETASKHOOK = "_cpu_type_specifics_pretaskhook_";
	public final static String OS_CPU_POSTTASKHOOK = "_cpu_type_specifics_posttaskhook_";
	public final static String OS_CPU_USEGETSERVICEID = "_cpu_type_specifics_usegetserviceid_";
	public final static String OS_CPU_USEPARAMETERACCESS = "_cpu_type_specifics_useparameteraccess_";
	public final static String OS_CPU_USERESSCHEDULER = "_cpu_type_specifics_userscheduler_";
	public final static String OS_CPU_STARTUPSYNC = "_cpu_type_specifics_startupsync_";
	public final static String OS_CPU_USEREMOTETASK = "_cpu_type_specifics_usermotetask_";
	public final static String OS_CPU_NIOS2_DO_MAKE_OBJDUMP = "_cpu_type_specifics_nios2_obj_dump_";
	public final static String OS_CPU_KERNEL_TYPE = "_cpu_type_specifics_kernel_type_";
	public final static String OS_CPU_KERNEL_TYPE_NESTED_IRQ = "_cpu_type_specifics_kernel_type_nested_irq_";
	public final static String OS_MCU_DATA = "_cpu_type_specifics_mcu_data_";
	public final static String OS_MCU_DATA_MODEL = "_cpu_type_specifics_mcu_data_model_";
	public final static String OS_MCU_DATA_MODEL_CUSTOM_MODEL = "_cpu_type_specifics_mcu_data_model_custom_model_";
	public final static String OS_MCU_DATA_MODEL_CUSTOM_LINKERSCRIPT = "_cpu_type_specifics_mcu_data_model_custom_linkerscript_";
	public final static String OS_MCU_DATA_MODEL_CUSTOM_DEV_LIB = "_cpu_type_specifics_mcu_data_model_custom_dev_lib_";
	public final static String OS_MCU_DATA_MODEL_CUSTOM_INCLUDE_C = "_cpu_type_specifics_mcu_data_model_custom_include_c_";
	public final static String OS_MCU_DATA_MODEL_CUSTOM_INCLUDE_S = "_cpu_type_specifics_mcu_data_model_custom_include_s_";
	public final static String OS_BOARD_DATA = "_cpu_type_specifics_board_data_";
	public final static String OS_BOARD_DATA_USELEDS = "_cpu_type_specifics_board_data_useleds_";
	public final static String OS_BOARD_DATA_EXP16_USEBUTTONS = "_cpu_type_specifics_board_data_exp16_usebuttons_";
	public final static String OS_BOARD_DATA_EXP16_USELCD = "_cpu_type_specifics_board_data_exp16_uselcd_";
	public final static String OS_BOARD_DATA_EXP16_USEANALOG = "_cpu_type_specifics_board_data_exp16_useanalog_";
	
	/***************************************************************************
	 * CPU_DATA
	 **************************************************************************/
	public final static String CPU_DATA = "cpu_data";
	public final static String CPU_TYPE = "cpu_type";
	public final static String CPU_ID = "cpu_id";
	public final static String CPU_THUMB_SRC = "cpu_data_thumb_src";
//	public final static String CPU_LINKER_SCRIPT = "cpu_data_linker_script";
//	public final static String CPU_ICD2 = "cpu_data_icd2";
//	public final static String CPU_ENABLE_SPLIM = "cpu_enable_splim";
	public final static String CPU_MULTI_STACK = "cpu_multi_stack"; // true - false
	public final static String CPU_MULTI_STACK_SYS_SIZE = "cpu_multi_stack_sys_size";
	
	//ARM7 Properties
//	public final static String CPU_DATA_STACK_BOTTOM = "cpu_data_stack_bottom";
//	public final static String CPU_DATA_IRQ_SIZE = "cpu_data_irq_size";
//	public final static String CPU_DATA_SVC_SIZE = "cpu_data_svc_size";
//	public final static String CPU_DATA_FIQ_SIZE = "cpu_data_fiq_size";
//	public final static String CPU_DATA_ABT_SIZE = "cpu_data_abt_size";
//	public final static String CPU_DATA_UND_SIZE = "cpu_data_und_size";
//	public final static String CPU_DATA_MKP_SIZE = "cpu_data_mkp_size";
//	public final static String CPU_DATA_SHARED_MIN_IRQ_SIZE = "cpu_data_shared_irq_size";
	
	//NIOS Properties
	public final static String CPU_DATA_STACK_TOP = "cpu_data_stack_top";
	public final static String CPU_DATA_SYS_SIZE = "cpu_data_sys_size";
	public final static String CPU_DATA_SHARED_MIN_SYS_SIZE = "cpu_data_shared_min_size";
	public final static String CPU_DATA_SYSTEM_LIBRARY_NAME = "cpu_data_system_library_name";
	public final static String CPU_DATA_SYSTEM_LIBRARY_PATH = "cpu_data_system_library_path";
	public final static String CPU_DATA_IPIC_LOCAL_NAME = "cpu_data_ipic_local_name";
	public final static String CPU_DATA_MULTI_STACK = "cpu_data_multi_stack";
	public final static String CPU_DATA_MULTI_STACK_IRQ_STACK = "cpu_data_multi_stack_irq_stack";
	public final static String CPU_DATA_MULTI_STACK_IRQ_STACK_SYS_SIZE = "cpu_data_multi_stack_irq_stack_sys_size";
	public final static String CPU_DATA_MULTI_STACK_DUMMY_STACK = "cpu_data_multi_stack_dummy_stack";
	public final static String CPU_DATA_MULTI_STACK_DUMMY_STACK_SYS_SIZE = "cpu_data_multi_stack_dummy_stack_sys_size";
	
	

	/***************************************************************************
	 * OS Application
	 **************************************************************************/
	public final static String OS_APPL_ID = "os_application_id";
	public final static String OS_APPL_PATH = "os_application_paths";
	public final static String OS_APPL_STACK = "os_application_stack";

	public final static String OS_APPL_LIST_REF_ALARM = "os_application_list_ref_alarm";
	public final static String OS_APPL_LIST_REF_COUNTER = "os_application_list_ref_counter";
	public final static String OS_APPL_LIST_REF_ISR = "os_application_list_ref_isr";
	public final static String OS_APPL_LIST_REF_RESOURCE = "os_application_list_ref_resource";
	public final static String OS_APPL_LIST_REF_TASK = "os_application_list_ref_task";
	
	public final static String OS_APPL_SHARED_STACK_ID = "os_application_shared_stack_id";
	
}

