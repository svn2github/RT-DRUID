package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;

class HrOrtiConstants {

	
	/***************************************************************************
	 * ORTI options
	 **************************************************************************/
	
	public final static int EE_ORTI_OS = 1;
	public final static int EE_ORTI_TASK = 1<<2;
	public final static int EE_ORTI_RESOURCE = 1<<3;
	public final static int EE_ORTI_STACK = 1<<4;
	public final static int EE_ORTI_ALARM = 1<<5;
	public final static int EE_ORTI_ALL = 0xFF;

	
	/***************************************************************************
	 * ORTI KeyWord
	 **************************************************************************/
	
	/**
	 * This keyword is used to store required ORTI sections for a specific cpu.
	 * The value is an Integer that stores a bit mask.
	 */
	public final static String OS_CPU_ORTI_ENABLED_SECTIONS = "_cpu_type_specifics_enabled_orti_sections_";
	
	
	/***************************************************************************
	 * ORTI Files
	 **************************************************************************/
	
	/** Identifies system.orti files (one for each cpu) */
	public final static String FILE_EE_ORTI = "system.orti";

	
}
