package com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.eu.evidence.rtdruid.modules.oil.codewriter.common.comments.CommentsManager;
import com.eu.evidence.rtdruid.modules.oil.erikaenterprise.interfaces.IMacrosForSharedData;

/**
 * This class is used to store some attributes required by a lot of common
 * functions, like find stacks and compute maximum priority value.
 * 
 * @author Nicola Serreli
 */
public class CpuHwDescription {
	
	/**
	 * Number of bytes used to store the stack address.
	 */
	public final static boolean DEFAULT_supportForNestedIRQ = true;



	public static final int DEFAULT_MAX_NESTING_LEVEL = 16;
	
	

	/** A identifier for this cpu */
	public final String cpuType;
	/**
	 * Oil ID that identifies if is required a PRIVATE stack (opposite of
	 * "share" stack)
	 */
	public final String privateId;
	/** Oil identifiers for all stacks that are present in a "PRIVATE stack" */
	public final List<String> stackNames;
	/** Oil identifiers for all stacks that are present in a "SHARED stack" */
	public final List<String> sharedStackNames;
	/** Number of bits used to represent a priority */
	public final int prioSize;
	/**
	 * Number of bytes of each minimum stack unit. It means that the stack must
	 * be a multiple of this value.
	 */
	public final int stackSize;
	/**
	 * Number of bits used by the cpu timer.
	 */
	public final int timerSize;

	/**
	 * Number of bytes used to store the stack address.
	 */
	public final int stackAddress;

	/**
	 * Number of bytes used to store the stack address.
	 */
	public final boolean supportForNestedIRQ;

	/**
	 * The comment manager for this architecture.
	 */
	public final CommentsManager commentManager;

	
	/**
	 * Able to handle empty vectors
	 */
	protected boolean handlesEmpyVector = true;
	
	/**
	 * 
	 */
	protected IMacrosForSharedData macros = new EmptyMacrosForSharedData();
	
	/**
	 * The maximum number of nested interrupts 
	 */
	protected int maxNestedInts = DEFAULT_MAX_NESTING_LEVEL;
	
	/**
	 * Build a new Cpu HW Description
	 */
	public CpuHwDescription(String ct, String pi, String[] stkNames,
			String[] sharedStkNames, int prio, int stkSize, int stkAddr,
			int timer) {
		cpuType = ct;
		privateId = pi;
		stackNames = Collections.unmodifiableList(Arrays.asList(stkNames));
		sharedStackNames = Collections.unmodifiableList(Arrays
				.asList(sharedStkNames));
		prioSize = prio;
		stackSize = stkSize;
		stackAddress = stkAddr;
		timerSize = timer;
		supportForNestedIRQ = DEFAULT_supportForNestedIRQ;
		commentManager = CommentsManager.getDefaultsWriters();
	}

	/**
	 * Build a new Cpu HW Description
	 */
	public CpuHwDescription(String ct, String pi, String[] stkNames,
			String[] sharedStkNames, int prio, int stkSize, int stkAddr,
			int timer, boolean supportIRQ) {
		cpuType = ct;
		privateId = pi;
		stackNames = Collections.unmodifiableList(Arrays.asList(stkNames));
		sharedStackNames = Collections.unmodifiableList(Arrays
				.asList(sharedStkNames));
		prioSize = prio;
		stackSize = stkSize;
		stackAddress = stkAddr;
		timerSize = timer;
		supportForNestedIRQ = supportIRQ;
		commentManager = CommentsManager.getDefaultsWriters();
	}
	
	/**
	 * @return true if the default compiler for this processor is able to handle empty vectors 
	 */
	public boolean isAbleToHandleEmpyVector() {
		return handlesEmpyVector;
	}
	
	
	/**
	 * Returns the code used to init an empty vector, i.e. the code between '=' and ';'.
	 * Default value is '{}'.
	 * 
	 * @return the text used to init an empty vector, i.e. the code between '=' and ';' 
	 */
	public String initEmptyVector() {
		return  "{}";
	}
	
	/**
	 * 
	 */
	public IMacrosForSharedData getShareDataMacros() {
		return macros;
	}
	
	public int getMaxNestedInts() {
		return maxNestedInts;
	}
	
}