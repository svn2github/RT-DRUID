/*
 * Created on 5-apr-2006
 *
 * $Id: ErikaEnterpriseWriterKeywords.java,v 1.3 2007/03/09 09:12:41 durin Exp $
 */
package com.eu.evidence.rtdruid.modules.oil.erikaenterprise.constants;

import com.eu.evidence.rtdruid.internal.modules.oil.keywords.IWritersKeywords;
import com.eu.evidence.rtdruid.modules.oil.codewriter.common.CommonUtils;
import com.eu.evidence.rtdruid.vartree.DataPath;

/**
 * Some keywords and constants used by Erika Enterprise writer
 * 
 * @author Nicola Serreli
 */
public interface IEEWriterKeywords extends IDistributionConstant, IEEoptConstant {

	
	/** Identifies a shared stack */
	public final static String SHARED_STACK = "shared_stack"; 

	public final static String DEFAULT_CPU_NAME = IWritersKeywords.DEFAULT_CPU_NAME;


	/** A shortcut to {@link DataPath#SEPARATOR DataPath.SEPARATOR} */
	public final static String S = "" + DataPath.SEPARATOR;


	/***************************************************************************
	 * 
	 * DEFAULT FILE's NAMES
	 *  
	 **************************************************************************/

	/** Identifies the common EE cfg file (.c) */
	public final static String FILE_EE_CFG_C = "eecfg.c";

	/** Identifies the common EE cfg file (.h) */
	public final static String FILE_EE_CFG_H = "eecfg.h";

	/** Identifies the application EE opt section */
	public final static String FILE_EE_CFG_H_SECTION_EEOPT_DEFINES = "__DISABLE_EEOPT_DEFINES__";

	// ------------------ Make files --------------------------
	
	/** Identifies the makefile */
	public final static String FILE_MAKEFILE = IWritersKeywords.FILE_MAKEFILE;

	// ------------------ MultiProcessor files --------------------------

	/** Identifies the MultiProcessor common file (for shared data) */
	public final static String FILE_EE_COMMON_C = "common.c";

	/** Identifies the MultiProcessor common makefile, used by all cpu */
	public final static String FILE_EE_COMMON_MK = "common.mk";
	
	/** Identifies MultiProcessor cpu.mk file (cpu specific makefile) */
	public final static String FILE_EE_CPU_MK = "cpu.mk";
	
	/** Identifies subdir.mk files (directory specific makefile) */
	public final static String FILE_EE_SUBDIR_MK = "subdir.mk";
	
	
	/***************************************************************************
	 * 
	 * OILVAR SUFFIX
	 *  
	 **************************************************************************/

	/** a suffix used to take the value list from a Value node inside a OilVar */
	public final static String VALUE_VALUE = CommonUtils.VALUE_VALUE;

	/**
	 * a suffix used to take the Enumerator list from a Variant node inside a
	 * OilVar
	 */
	public final static String VARIANT_ELIST = CommonUtils.VARIANT_ELIST;

	/**
	 * a suffix used to take the Parameter list from an Enumerator node inside a
	 * OilVar
	 */
	public final static String PARAMETER_LIST = CommonUtils.PARAMETER_LIST;

	/** a suffix used to take the type of an Enumerator node inside a OilVar */
	public final static String ENUM_TYPE = CommonUtils.ENUM_TYPE;

	/***************************************************************************
	 * 
	 * ERIKA ENTERPRISE OPTIONS and KEYWORDS
	 *  
	 **************************************************************************/

	/** A Keyword enabled if the current host os is win+cygwin */
	public final static String DEF_HOST_OS_CYGWIN = "curr_host_os__cygwin";

	/** A Keyword enabled if the current host os is linux */
	public final static String DEF_HOST_OS_LINUX = "curr_host_os__linux";
	
	
	/** A SimpleGenResKeyword for cpu related vector defines */
	public final static String SGRK_OS_CPU_VECTOR_SIZE_DEFINES = "os_cpu_vector_size_define_list";
	
	
	/** A SimpleGenResKeyword for cpu data inside an OS */
	public final static String SGRK_OS_CPU_DATA_PREFIX = "os_cpu_data_prefix";
	public final static String SGRK_OS_CPU_SPEED_HZ = "os_cpu_speed__hertz";

	/** A SimpleGenResKeyword that identifies a list of stack for a OS (an EEStackData[]) */
	public final static String SGRK_OS_STACK_LIST = "os_stack_list";
	
	/** A SimpleGenResKeyword that identifies the name of the stack vector (a String) */
	public final static String SGRK_OS_STACK_VECTOR_NAME = "os_stack_vector_name";
	public final static String SGRK_OS_STACK_VECTOR_FIELD = "os_stack_vector_field";
	
	/** A SimpleGenResKeyword that identifies the stack of a TASK (an EEStackData) */
	public final static String SGRK_TASK_STACK = "task_stack_data_description";
	
//	
//	/** A SimpleGenResKeyword that identifies the irq stack of a OS application (an EEStackData) */
//	public final static String OS_APPLICATION_IRQ_STACK = "sgr_os_application_irq_stack";
//
//	/** A SimpleGenResKeyword that identifies the irq stack of a OS application (an string) */
//	public final static String OS_APPLICATION_IRQ_STACK_ID = "sgr_os_application_irq_stack_id";
	
	/**
	 * Contains a list of Integer that identifies Oil Objects, using
	 * OilObjectList constants. If an object type is in this list, is required
	 * to initialize it's data structure, even if they are empty.
	 */
	public final static String SGRK__FORCE_ARRAYS_LIST__ = "__LIST_OF_REQUIRED_OBJECT_TYPES__";


	/** Identifies the multi stack option */
	public final static String DEF__MULTI_STACK__ = "__MULTI__";

	/** Identifies the mono stack option */
	public final static String DEF__MONO_STACK__ = "__MONO__";
	
	/** Enable Erika "use res scheduler" option 
	 * UPDRTD Warning check if this key is used only by OSEK 
	 */
	public final static String DEF__OS_HAS_USERESSCHEDULER__ = "__OO_HAS_USERESSCHEDULER__";


	/** Enable multiprocesor */
	public final static String DEF__MSRP__ = "__MSRP__";
	
	/** Enable user spinlock handling */
	public final static String DEF__USER_SPINLOCKS__ = "__USER_SPINLOCKS__";
	
	/** A 'general' way to define syncronous startup of a MultiProcessor System.
	 *  
	 *  This keyword isn't an EE_OPT and isn't directly used by Erika Enterprise 
	 */
	public final static String DEF__EE_HAS_STARTUPSYNC__ = "__EE_MP_HAS_STARTUPSYNC__";

	/***/
	public final static String DEF__EE_HAS_STARTUPBARRIER__ = "__EE_HAS_STARTUP_BARRIER__";

	
	
	/** Identifies that the irq stack is needed */
	public final static String DEF__IRQ_STACK_NEEDED__ = "__IRQ_STACK_NEEDED__";

	/** Identifies that is allowed the irq nesting */
	public final static String DEF__ALLOW_NESTED_IRQ__ = "__ALLOW_NESTED_IRQ__";

	
	/** Identifies that it is no required time frames reclamation */
	public final static String DEF__NO_TIME_FRAME_RECLAMATION__ = "EE_NO_RECLAMATION_TIME_FRAMES";

	/**
	 * Identifies a string added inside the makefile, before include "rules.mk"
	 */
	public final static String SGRK__MAKEFILE_EXTENTIONS__ = "__MAKEFILE_EXTENTIONS__";
	/**
	 * Identifies a string added inside the makefile file (used to compile a
	 * single-processor system), just after the inclusion of source files
	 */
	public final static String SGRK__MAKEFILE_AFTER_FILES__= "__MAKEFILE_EXTENTIONS__AFTER_SOURCES_INCLUDES__";
	/**
	 * Identifies a string added inside the makefile file (used to compile a
	 * single-processor system), at the end of the file
	 */
	public final static String SGRK__MAKEFILE_EXT_EOF__ = "__MAKEFILE_EXTENTIONS__END_OF_FILE__";

	
	/** Enables the usage of custom startup code */
	public final static String DEF__CUSTOM_STARTUP_CODE__ = "EE_USE_CUSTOM_STARTUP_CODE";


	/*
	 * 
	 * Extentions to common.mk file 
	 * 
	 */
	/** This id is used to remember that every common extention is stored inside the first RT-OS object */
	public final static int RTOS_ID___COMMON_DATA = 0;
	/**
	 * Identifies a string added inside the common.mk file (used to compile
	 * multiprocessor systems), inside the section VARIABLES
	 */
	public final static String SGRK__COMMON_MAKEFILE_MP_EXT_VARS__ = "__COMMON.MK_EXTENTIONS__VARIABLES__";
	/**
	 * Identifies a string added inside the common.mk file (used to compile a
	 * multiprocessor system), just before the inclusion of subdirs
	 */
	public final static String SGRK__COMMON_MAKEFILE_MP_EXT_B_SUBD_INCLUDES__ = "__COMMON.MK_EXTENTIONS__BEFORE_SUBDIR_INCLUDES__";
	/**
	 * Identifies a string added inside the common.mk file (used to compile a
	 * multiprocessor system), just after the inclusion of subfirs
	 */
	public final static String SGRK__COMMON_MAKEFILE_MP_EXT_A_SUBD_INCLUDES__ = "__COMMON.MK_EXTENTIONS__AFTER_SUBDIR_INCLUDES__";
	/**
	 * Identifies a string added inside the common.mk file (used to compile a
	 * multiprocessor system), at the end of the file
	 */
	public final static String SGRK__COMMON_MAKEFILE_MP_EXT_EOF__ = "__COMMON.MK_EXTENTIONS__END_OF_FILE__";

	/*
	 * 
	 * Extentions to cpu.mk file 
	 * 
	 */
	
	/**
	 * Identifies a string added inside the cpu's makefile file inside the
	 * section VARIABLES. This is used to both single-core and multi-core.
	 */
	public final static String SGRK__MAKEFILE_CPU_EXT_VARS__ = "__CPU.MK_EXTENTIONS__VARIABLES__";
	/**
	 * Identifies a string added inside the cpu.mk file (used to compile a
	 * multiprocessor system), just before the inclusion of common.mk
	 */
	public final static String SGRK__MAKEFILE_MP_CPU_EXT_B_COMMON_INCLUDE__ = "__CPU.MK_EXTENTIONS__BEFORE_COMMON.mk_INCLUDE__";
	/**
	 * Identifies a string added inside the cpu.mk file (used to compile
	 * multiprocessor systems), at the end of the file
	 */
	public final static String SGRK__MAKEFILE_MP_CPU_EOF__ = "__CPU.MK_EXTENTIONS__END_OF_FILE__";
	
	/*
	 * 
	 * Extentions to makefile (Multi Processor)
	 * 
	 */
	/**
	 * Identifies a string added inside the makefile file (used to compile
	 * multiprocessor systems), inside the section VARIABLES
	 */
	public final static String SGRK__MAKEFILE_MP_EXT_VARS__ = "__MAKEFILE.MP_EXTENTIONS__VARIABLES__";
	/**
	 * Identifies a string added inside the makefile file (used to compile a
	 * multiprocessor system), at the end of the file
	 */
	public final static String SGRK__MAKEFILE_MP_EXT_EOF__ = "__MAKEFILE.MP_EXTENTIONS__END_OF_FILE__";

	
	/** Enable Sources Distribution 
	@deprecated old
	 */
	
	// Ni 5.gen.2006
//	public final static String DEF__EE_SOURCE_DISTRIBUTION__ = IWritersKeywords.DEF__EE_SOURCE_DISTRIBUTION__;
//	public final static String DEF__EE_BINARY_DISTRIBUTION_FULL__ = IWritersKeywords.DEF__EE_BINARY_DISTRIBUTION_FULL__;
//	public final static String DEF__EE_BINARY_DISTRIBUTION_LIMITED__ = IWritersKeywords.DEF__EE_BINARY_DISTRIBUTION_LIMITED__;
	//public final static String DEF__EE_DISTRIBUTION_NAME__ = IWritersKeywords.DEF__EE_DISTRIBUTION_NAME__;
	public final static String DEF__EE_BUILD_DISTRIBUTION__ = "build a distribution";
	
	/**
	 * Options that cannot be used to compile distributions. 
	@deprecated old
	 */
	public final static String[] INVALID_SIGNATURE_OPTIONS = {
			"DEBUG"
	};

	public final static String OS_APPLICATION_TRUSTED = "SGR_os_application_trusted";

	public final static String OS_APPLICATION_TRUSTED_FUNCTIONS = "SGR_os_application_trusted_functions__String_list";
	public final static String OS_APPLICATION_HOOK_STARTUP  = "SGR_os_application_enable_startup_hook__";
	public final static String OS_APPLICATION_HOOK_SHUTDOWN = "SGR_os_application_enable_shutdown_hook__";
	public final static String OS_APPLICATION_HOOK_ERROR    = "SGR_os_application_enable_error_hook__";
		

	public final static String SIMPLE_SPINLOCK = "enable simple spinlock handling";
	public final static String QUEUED_SPINLOCK = "enable queued spinlock handling";

	public static final String DEF__USE_RPC__ = "use new Remote Procedure Call feature";

}
